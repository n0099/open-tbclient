package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.view.PbReplyEcommCard;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class du extends cs<com.baidu.tieba.tbadkCore.data.q, ec> implements View.OnClickListener {
    private TbRichTextView.e aJh;
    private boolean aeb;
    private View.OnLongClickListener anY;
    private View.OnClickListener bmo;
    protected boolean cIH;
    private ArrayList<IconData> ddj;
    protected com.baidu.tieba.pb.data.h emS;
    private com.baidu.tieba.pb.a.d emU;
    protected int enp;
    protected boolean enq;
    private boolean enr;
    private String ens;
    private com.baidu.tieba.pb.pb.sub.av ent;
    private ArrayList<IconData> enu;
    private View.OnClickListener env;
    private boolean enw;
    private final boolean enx;
    private int eny;
    private int enz;
    private boolean eoX;
    private boolean eqC;
    private TbRichTextView.b esA;
    private boolean esB;
    private Set<String> esC;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.enp = 0;
        this.cIH = true;
        this.enq = true;
        this.enr = true;
        this.emS = null;
        this.ens = null;
        this.ent = null;
        this.enu = null;
        this.ddj = null;
        this.env = null;
        this.bmo = null;
        this.aJh = null;
        this.emU = null;
        this.anY = null;
        this.esA = null;
        this.enw = false;
        this.enx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eqC = false;
        this.esB = false;
        this.eoX = false;
        this.aeb = false;
        init();
    }

    private void init() {
        this.eny = getDimensionPixelSize(r.e.ds30);
        this.enz = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(r.e.ds60);
        this.esC = new HashSet();
    }

    private void a(ec ecVar) {
        if (ecVar != null) {
            if (ecVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.av.l(ecVar.enE, r.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.av.l(ecVar.enF, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ecVar.enG, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ecVar.esI, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.eoe, r.d.common_color_10005, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.eoh, r.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.av.c(ecVar.aVU, r.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.av.c((View) ecVar.enL, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c((View) ecVar.enM, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.enO, r.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.enP, r.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.enR, r.f.btn_pb_more_btn_selector);
                com.baidu.tbadk.core.util.av.c(ecVar.esS, r.f.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.av.l(ecVar.enT, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.l(ecVar.enU, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.c(ecVar.enU, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.enY, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ecVar.esU, r.f.btn_appdownload);
                com.baidu.tbadk.core.util.av.c(ecVar.esU, r.d.cp_cont_i, 1);
                ecVar.enS.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10039));
                com.baidu.tbadk.core.util.av.c(ecVar.eor, r.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.eoq, r.f.icon_pb_pin);
                com.baidu.tbadk.core.util.av.c(ecVar.eoo, r.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.eon, r.f.icon_pb_pin);
                com.baidu.tbadk.core.util.av.k(ecVar.enI, r.f.bg_floor_new_middle);
                c(ecVar);
            }
            ecVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public ec a(ViewGroup viewGroup) {
        ec ecVar = new ec(LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, viewGroup, false), this.enq, this.cIH, this.enp, false);
        a(ecVar);
        return ecVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, ec ecVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) ecVar);
        a(ecVar);
        e(ecVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aJ(i);
        if (qVar2 != null) {
            qVar2.sL();
            a(ecVar, qVar2, view, false, i);
        }
        if (!this.enw && this.enx && ecVar != null && ecVar.enS.IN() && (listView = ((PbActivity) this.eow.getPageContext().getOrignalPage()).getListView()) != null) {
            this.enw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v358, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:251:0x094c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x096e  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0976  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0982  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x09aa  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0a03  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0a39  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0ab8  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x103c  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x106c  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x1078  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x1084  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x10c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.a aAI;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bjZ;
        UserTbVipInfoData userTbVipInfoData;
        SparseArray sparseArray2;
        if (ecVar != null && qVar != null) {
            if (!z) {
                ecVar.eob.setVisibility(0);
                ecVar.enK.setTag(null);
                ecVar.enK.setUserId(null);
                ecVar.aVU.setText((CharSequence) null);
                ecVar.enM.setVisibility(8);
                ecVar.enZ.setVisibility(0);
                ecVar.enR.setVisibility(0);
                ecVar.enQ.setVisibility(8);
                if (qVar.bjQ() == null) {
                    ecVar.eoa.setVisibility(8);
                } else if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && qVar.bjQ().BT() == 1) {
                    ecVar.eoa.changeSkinType(this.mSkinType);
                    ecVar.eoa.setVisibility(0);
                    ecVar.eoa.setData(qVar.bjQ());
                } else {
                    ecVar.eoa.setVisibility(8);
                }
                SparseArray sparseArray3 = (SparseArray) ecVar.enW.getTag();
                if (sparseArray3 == null) {
                    SparseArray sparseArray4 = new SparseArray();
                    ecVar.enW.setTag(sparseArray4);
                    ecVar.enS.setTag(sparseArray4);
                    ecVar.enE.setTag(r.g.tag_from, sparseArray4);
                    sparseArray2 = sparseArray4;
                } else {
                    sparseArray2 = sparseArray3;
                }
                sparseArray2.put(r.g.tag_clip_board, qVar);
                sparseArray2.put(r.g.tag_is_subpb, false);
                ecVar.enS.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar.enS.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                layoutParams.topMargin = getDimensionPixelSize(r.e.ds20);
                layoutParams.bottomMargin = getDimensionPixelSize(r.e.ds20);
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                if (!this.cIH) {
                    layoutParams.leftMargin = 0;
                    layoutParams.topMargin = 0;
                    ecVar.enS.setIsSupportVitality(true);
                } else if (TextUtils.isEmpty(qVar.getBimg_url())) {
                    this.esB = false;
                    sparseArray2.put(r.g.tag_richtext_bg, null);
                    ecVar.enS.gI(null);
                    ecVar.enS.setBackgroundDrawable(null);
                    if (qVar.bjO() == 1) {
                        ecVar.enS.setIsSupportVitality(true);
                    } else {
                        ecVar.enS.setIsSupportVitality(false);
                    }
                } else {
                    this.esB = true;
                    ecVar.enS.setIsSupportVitality(false);
                    if (qVar.bjO() == 1) {
                        layoutParams.leftMargin = getDimensionPixelSize(r.e.ds30);
                    } else {
                        layoutParams.leftMargin = 0;
                    }
                    layoutParams.rightMargin = getDimensionPixelSize(r.e.ds30);
                    sparseArray2.put(r.g.tag_richtext_bg, qVar.getBimg_url());
                    ecVar.enS.gI(qVar.getBimg_url());
                }
                ecVar.enS.setLayoutParams(layoutParams);
                if (qVar.bjO() != 1) {
                    if (TextUtils.isEmpty(qVar.getBimg_url())) {
                        ecVar.enS.setOnClickListener(this.bmo);
                        ecVar.enS.setTextViewOnClickListener(this.bmo);
                    } else {
                        ecVar.enS.setOnClickListener(null);
                        ecVar.enS.setTextViewOnClickListener(null);
                    }
                    ecVar.enE.setOnClickListener(this.bmo);
                    ecVar.enW.setOnClickListener(this.bmo);
                } else {
                    ecVar.enE.setOnClickListener(null);
                    ecVar.enW.setOnClickListener(null);
                }
                ecVar.enP.setText(qVar.bjP());
                if (qVar.bjO() == 1) {
                    ecVar.enE.setPadding(0, 0, 0, 0);
                    a(ecVar.enS, view, true, this.esB);
                    ecVar.enF.setVisibility(8);
                    ecVar.enG.setVisibility(8);
                    ecVar.enH.setVisibility(8);
                    ecVar.eob.setVisibility(8);
                    ecVar.enW.setVisibility(8);
                    ecVar.enP.setVisibility(8);
                    ecVar.eoc.setVisibility(8);
                    ecVar.enV.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (qVar.getAuthor() != null) {
                        j = qVar.getAuthor().getUserIdLong();
                        str = qVar.getAuthor().getUserName();
                    }
                    if (this.emS != null && this.emS.aMs() != null) {
                        ecVar.enV.a(qVar.bjX(), str, j, com.baidu.adp.lib.h.b.c(this.emS.aMs().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                    }
                    ecVar.enV.tx();
                    if (this.enr) {
                        PraiseData praiseData = null;
                        if (this.emS != null && this.emS.aMs() != null) {
                            this.emS.aMs().rF();
                        }
                        if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                            ecVar.enT.setVisibility(0);
                            ecVar.enU.setVisibility(0);
                            ecVar.enT.setIsFromPb(true);
                            ecVar.enT.a(null, this.emS.aMs().getId(), praiseData.getPostId(), true);
                            ecVar.enT.dl(this.mSkinType);
                        } else {
                            ecVar.enT.setVisibility(8);
                            ecVar.enU.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.ak(ecVar.enT);
                        com.baidu.tieba.graffiti.d.ak(ecVar.enU);
                        com.baidu.tbadk.data.g bjR = qVar.bjR();
                        ecVar.eop.setVisibility(8);
                        if (bjR != null && !TextUtils.isEmpty(bjR.getName()) && !TextUtils.isEmpty(bjR.getName().trim())) {
                            String name = bjR.getName();
                            String lat = bjR.getLat();
                            String lng = bjR.getLng();
                            ecVar.eom.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, ecVar.eom, 0, 10, 0, 10);
                            ecVar.eoo.setText(bjR.getName());
                            ecVar.eom.setOnClickListener(new dv(this, lat, lng, name));
                        } else {
                            ecVar.eon.setVisibility(8);
                            ecVar.eoo.setVisibility(8);
                        }
                        if (qVar.getAuthor() != null && qVar.getAuthor().getGodInfo() != null) {
                            ecVar.enV.iL(false);
                            ViewGroup.LayoutParams layoutParams2 = ecVar.eom.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.width = -2;
                                ecVar.eom.setLayoutParams(layoutParams2);
                            }
                            ecVar.eom.setVisibility(0);
                            View findViewWithTag = ecVar.eom.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(r.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView, r.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(r.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(r.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                ecVar.eom.addView(textView, 0);
                            }
                            View findViewWithTag2 = ecVar.eom.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(r.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView2, r.d.cp_cont_d, 1);
                                textView2.setText(qVar.bjP());
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(r.e.ds20), 0);
                                ecVar.eom.addView(textView2, 1);
                            }
                            if (ecVar.esR == null) {
                                ecVar.eon.setVisibility(8);
                                ecVar.eom.removeView(ecVar.eoo);
                                ecVar.esR = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams3.addRule(11);
                                layoutParams3.addRule(15);
                                ecVar.eoo.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.icon_pb_pin), (Drawable) null, (Drawable) null, (Drawable) null);
                                ecVar.esR.addView(ecVar.eoo, layoutParams3);
                                ecVar.eom.addView(ecVar.esR, new LinearLayout.LayoutParams(-1, -2));
                                if (bjR != null && !TextUtils.isEmpty(bjR.getName()) && !TextUtils.isEmpty(bjR.getName().trim())) {
                                    ecVar.eoo.setOnClickListener(new dw(this, bjR.getLat(), bjR.getLng(), bjR.getName()));
                                }
                            }
                            ecVar.eom.setOnClickListener(null);
                        }
                        if (this.emS.aMG() != null && !StringUtils.isNull(this.emS.aMG().pO(), true)) {
                            b(ecVar);
                        }
                    } else {
                        ecVar.enT.setVisibility(8);
                        ecVar.enU.setVisibility(8);
                        ecVar.eom.setVisibility(8);
                        ecVar.eop.setVisibility(8);
                        if (this.emS.aMG() != null && !StringUtils.isNull(this.emS.aMG().pO(), true) && ecVar.esJ != null) {
                            ecVar.esJ.setVisibility(8);
                            ecVar.esO.Eh();
                        }
                    }
                    if (this.eow.aNk().aQF()) {
                        ecVar.enS.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) ecVar.eoa.getLayoutParams()).leftMargin = getDimensionPixelSize(r.e.ds30);
                    if (this.emS.aMs() != null && this.emS.aMs().rY() != null) {
                        com.baidu.tbadk.core.data.bs rY = this.emS.aMs().rY();
                        String activityUrl = rY.getActivityUrl();
                        String tg = rY.tg();
                        String th = rY.th();
                        if (!StringUtils.isNull(th)) {
                            ecVar.esU.setVisibility(0);
                            ecVar.esU.setText(th);
                            ecVar.esU.setOnClickListener(new dx(this, activityUrl));
                            ecVar.esV.setOnClickListener(new dy(this, activityUrl));
                            if (!StringUtils.isNull(tg)) {
                                ecVar.bSs.setVisibility(0);
                                ecVar.bSs.c(tg, 10, true);
                            }
                        } else {
                            return;
                        }
                    } else {
                        ecVar.esU.setVisibility(8);
                        ecVar.bSs.setVisibility(8);
                    }
                    if (ecVar.esZ != null) {
                        ecVar.esZ.setVisibility(8);
                    }
                } else {
                    if (this.emS.aMG() != null && !StringUtils.isNull(this.emS.aMG().pO(), true) && ecVar.esJ != null) {
                        ecVar.esJ.setVisibility(8);
                    }
                    ecVar.enS.setVisibility(0);
                    a(ecVar.enS, view, false, this.esB);
                    ecVar.enH.setVisibility(0);
                    ecVar.eoc.setVisibility(0);
                    ecVar.enE.setPadding(getDimensionPixelSize(r.e.ds30), 0, getDimensionPixelSize(r.e.ds30), 0);
                    ecVar.bSs.setVisibility(8);
                    ecVar.esU.setVisibility(8);
                    if (this.eqC && i == 0) {
                        ecVar.enF.setVisibility(8);
                        ecVar.enG.setVisibility(8);
                    } else if (i == 1) {
                        if (!this.eoX && (qVar.rF() == null || !qVar.rF().isPriaseDataValid())) {
                            ecVar.enF.setVisibility(0);
                        } else if (this.eqC || this.enr) {
                            ecVar.enF.setVisibility(0);
                        } else {
                            ecVar.enF.setVisibility(8);
                        }
                        ecVar.enG.setVisibility(8);
                    } else {
                        ecVar.enF.setVisibility(0);
                        ecVar.enG.setVisibility(8);
                        if (i == 2 && this.eoX) {
                            ecVar.enF.setVisibility(8);
                        }
                    }
                    com.baidu.tbadk.data.g bjR2 = qVar.bjR();
                    ecVar.eom.setVisibility(8);
                    if (bjR2 != null && !TextUtils.isEmpty(bjR2.getName()) && !TextUtils.isEmpty(bjR2.getName().trim())) {
                        String name2 = bjR2.getName();
                        String lat2 = bjR2.getLat();
                        String lng2 = bjR2.getLng();
                        ecVar.eop.setVisibility(0);
                        ecVar.eor.setText(bjR2.getName());
                        ecVar.eop.setOnClickListener(new dz(this, lat2, lng2, name2));
                    } else {
                        ecVar.eop.setVisibility(8);
                    }
                    ecVar.enV.setVisibility(8);
                    ((LinearLayout.LayoutParams) ecVar.eoa.getLayoutParams()).leftMargin = 0;
                    ecVar.enT.setVisibility(8);
                    ecVar.enU.setVisibility(8);
                    ecVar.enW.setVisibility(0);
                    ecVar.eob.setVisibility(0);
                    ecVar.enP.setVisibility(0);
                    String format = String.format(this.mContext.getString(r.j.is_floor), Integer.valueOf(qVar.bjO()));
                    ecVar.enO.setVisibility(0);
                    ecVar.enO.setText(format);
                    if (ecVar.esZ != null) {
                        if (qVar.sg() != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.eob.getLayoutParams();
                            marginLayoutParams.topMargin = (int) this.eow.getResources().getDimension(r.e.ds16);
                            ecVar.eob.setLayoutParams(marginLayoutParams);
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ecVar.eta.getLayoutParams();
                            marginLayoutParams2.topMargin = (int) this.eow.getResources().getDimension(r.e.ds10);
                            ecVar.eta.setLayoutParams(marginLayoutParams2);
                            ecVar.enR.setPadding(ecVar.enR.getPaddingLeft(), (int) this.eow.getResources().getDimension(r.e.ds14), ecVar.enR.getPaddingRight(), ecVar.enR.getPaddingBottom());
                            ecVar.enF.setVisibility(8);
                            ecVar.enG.setVisibility(8);
                            ecVar.esZ.a(this.eow.getPageContext(), qVar.sg(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", this.emS.aMr().getId(), this.emS.aMr().getName(), this.emS.aMs().getId(), null));
                            ecVar.enE.setPadding(0, 0, 0, 0);
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) ecVar.ete.getLayoutParams();
                            marginLayoutParams3.leftMargin = (int) this.eow.getResources().getDimension(r.e.ds30);
                            marginLayoutParams3.rightMargin = (int) this.eow.getResources().getDimension(r.e.ds30);
                            ecVar.ete.setLayoutParams(marginLayoutParams3);
                        } else {
                            ecVar.esZ.a(null, null, null);
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) ecVar.ete.getLayoutParams();
                            marginLayoutParams4.leftMargin = 0;
                            marginLayoutParams4.rightMargin = 0;
                            ecVar.ete.setLayoutParams(marginLayoutParams4);
                        }
                    }
                }
                if (this.ens != null && !this.ens.equals("0") && this.ens.equals(qVar.getAuthor().getUserId())) {
                    ecVar.enQ.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(ecVar.enQ, r.f.icon_floorhost);
                    ecVar.enQ.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                }
            } else {
                ecVar.eob.setVisibility(8);
            }
            ecVar.enS.setVideoImageId(r.f.pic_video);
            SparseArray sparseArray5 = (SparseArray) ecVar.enR.getTag();
            if (sparseArray5 == null) {
                SparseArray sparseArray6 = new SparseArray();
                ecVar.enR.setTag(sparseArray6);
                sparseArray = sparseArray6;
            } else {
                sparseArray = sparseArray5;
            }
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_load_sub_data, qVar);
            sparseArray.put(r.g.tag_load_sub_view, view);
            sparseArray.put(r.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(r.g.tag_pb_floor_number, Integer.valueOf(qVar.bjO()));
            SparseArray sparseArray7 = (SparseArray) ecVar.esS.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                ecVar.esS.setTag(sparseArray7);
            }
            sparseArray7.put(r.g.tag_clip_board, qVar);
            sparseArray7.put(r.g.tag_load_sub_data, qVar);
            sparseArray7.put(r.g.tag_load_sub_view, view);
            if (qVar.bjS() > 0 && qVar.bjK() != null && qVar.bjK().size() > 0) {
                if (this.ent == null) {
                    this.ent = new com.baidu.tieba.pb.pb.sub.av(this.mContext);
                    this.ent.setIsFromCDN(this.mIsFromCDN);
                    this.ent.H(this.env);
                    boolean z7 = false;
                    String userId = this.emS.aMs().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.ent.N(this.emS.aMz(), z7);
                    this.ent.b(this.emS.aMs());
                    this.ent.hR(this.enq);
                }
                this.ent.pz(qVar.getId());
                ecVar.enZ.setVisibility(0);
                ecVar.enY.setVisibility(0);
                ecVar.enX.setVisibility(0);
                ecVar.enZ.a(qVar, view);
                ecVar.enZ.setChildOnClickListener(this.bmo);
                ecVar.enZ.setChildOnLongClickListener(this.anY);
                ecVar.enZ.setChildOnTouchListener(this.emU);
                ecVar.enZ.setSubPbAdapter(this.ent);
                ecVar.enZ.setVisibility(0);
            } else {
                ecVar.enZ.setVisibility(8);
                ecVar.enY.setVisibility(8);
                ecVar.enX.setVisibility(8);
            }
            a(ecVar, qVar, this.emS.aMC(), i);
            if (!z) {
                String portrait = qVar.getAuthor().getPortrait();
                if (qVar.getAuthor() != null) {
                    String name_show = qVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.v.gD(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                    }
                    ecVar.aVU.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(ecVar.aVU, r.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(ecVar.aVU, r.d.cp_cont_f, 1);
                    }
                    int level_id = qVar.getAuthor().getLevel_id();
                    int is_bawu = qVar.getAuthor().getIs_bawu();
                    String bawu_type = qVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        ecVar.enL.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(ecVar.enL, BitmapHelper.getGradeResourceIdNew(level_id));
                        String bkb = qVar.bkb();
                        if (StringUtils.isNull(bkb)) {
                            bkb = String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id));
                        }
                        ecVar.enL.setContentDescription(bkb);
                        ecVar.enL.setOnClickListener(null);
                    } else {
                        ecVar.enL.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(ecVar.enM, r.f.pb_manager);
                            ecVar.enL.setVisibility(8);
                            ecVar.enM.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(ecVar.enM, r.f.pb_assist);
                            ecVar.enL.setVisibility(8);
                            ecVar.enM.setVisibility(0);
                        }
                        if (ecVar.enM.getVisibility() == 0) {
                            ecVar.enM.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        }
                    }
                    if (ecVar.enL.getVisibility() == 0) {
                        ecVar.enL.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (qVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(ecVar.enN, r.f.icon_pb_pop_girl);
                        ecVar.enN.setVisibility(0);
                    } else if (qVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(ecVar.enN, r.f.icon_pb_pop_boy);
                        ecVar.enN.setVisibility(0);
                    } else {
                        ecVar.enN.setVisibility(8);
                    }
                    if (ecVar.enN.getVisibility() == 0) {
                        ecVar.enN.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (com.baidu.tbadk.util.v.gD(qVar.getAuthor().getName_show()) >= 14 && ecVar.enL.getVisibility() == 0 && ecVar.enQ.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.enu = qVar.getAuthor().getIconInfo();
                    this.ddj = qVar.getAuthor().getTShowInfoNew();
                    if (ecVar.cgq != null) {
                        ecVar.cgq.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                        ecVar.cgq.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.bUn);
                        ecVar.cgq.wL();
                        ecVar.cgq.a(this.enu, i2, getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds10));
                    }
                    if (ecVar.ahw != null) {
                        ecVar.ahw.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewX);
                        if (this.ddj != null && this.ddj.size() > 0 && this.ddj.get(0) != null) {
                            ecVar.ahw.setTag(this.ddj.get(0).getUrl());
                        }
                        ecVar.ahw.a(this.ddj, 3, getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds8), true);
                    }
                }
                if (qVar.getAuthor() == null || qVar.getAuthor().getUserTbVipInfoData() == null) {
                    userTbVipInfoData = null;
                } else {
                    userTbVipInfoData = qVar.getAuthor().getUserTbVipInfoData();
                }
                if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().pO())) {
                    if (this.enq) {
                        ecVar.enK.setVisibility(4);
                        ecVar.esT.setVisibility(8);
                        ecVar.enJ.setVisibility(0);
                    } else {
                        ecVar.enJ.setVisibility(8);
                    }
                    if (qVar.bjO() != 1) {
                        ecVar.enE.setPadding(getDimensionPixelSize(r.e.ds4), 0, getDimensionPixelSize(r.e.ds30), 0);
                    }
                    ecVar.esT.setVisibility(8);
                    ecVar.enJ.getHeadView().setUserId(qVar.getAuthor().getUserId());
                    ecVar.enJ.getHeadView().ae(qVar.getAuthor().getUserName(), qVar.bka());
                    ecVar.enJ.getHeadView().setImageDrawable(null);
                    ecVar.enJ.getHeadView().c(portrait, 28, false);
                    ecVar.enJ.dX(qVar.getAuthor().getPendantData().pO());
                    ecVar.enJ.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                    ecVar.enJ.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
                } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                    if (this.enq) {
                        if (ecVar.aYH != null) {
                            if (ecVar.aYI == null) {
                                ecVar.aYH.inflate();
                                ecVar.aYI = (TbImageView) ecVar.getView().findViewById(r.g.user_head_mask);
                            }
                            if (ecVar.aYI != null) {
                                ecVar.aYI.c(userTbVipInfoData.getvipV_url(), 10, false);
                            }
                            ecVar.esT.setIsBigV(true);
                        }
                        ecVar.enK.setVisibility(4);
                        ecVar.esT.setVisibility(0);
                    } else {
                        ecVar.enK.setVisibility(4);
                        ecVar.esT.setVisibility(4);
                        if (ecVar.aYI != null) {
                            ecVar.aYI.setVisibility(8);
                        }
                    }
                    ecVar.enJ.setVisibility(8);
                    ecVar.esT.setData(qVar.getAuthor());
                    ecVar.esT.setUserId(qVar.getAuthor().getUserId());
                    ecVar.esT.ae(qVar.getAuthor().getUserName(), qVar.bka());
                } else {
                    ecVar.enJ.setVisibility(8);
                    if (f(qVar)) {
                        if (this.enq) {
                            ecVar.enK.setVisibility(4);
                            ecVar.esT.setVisibility(0);
                        }
                        ecVar.esT.c(portrait, 28, false);
                        ecVar.esT.setUserId(qVar.getAuthor().getUserId());
                        ecVar.esT.ae(qVar.getAuthor().getUserName(), qVar.bka());
                        ecVar.esT.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewW);
                    } else {
                        if (this.enq) {
                            ecVar.enK.setVisibility(0);
                        }
                        ecVar.esT.setVisibility(8);
                        ecVar.enK.setUserId(qVar.getAuthor().getUserId());
                        ecVar.enK.ae(qVar.getAuthor().getUserName(), qVar.bka());
                        ecVar.enK.setImageDrawable(null);
                        ecVar.enK.c(portrait, 28, false);
                    }
                }
                ecVar.aVU.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                ecVar.aVU.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            }
            ecVar.enS.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.cp_link_tip_c));
            if (this.cIH) {
                ecVar.enS.setDefaultImageId(r.f.transparent_bg);
            } else {
                ecVar.enS.setDefaultImageId(r.f.icon_click);
            }
            ecVar.enS.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                aAI = null;
            } else {
                aAI = qVar.aAI();
            }
            if (this.enw || !this.enx) {
                ecVar.enS.a(aAI, false, this.esA);
            } else {
                ecVar.enS.a(aAI, true, this.esA);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.emS != null && this.emS.aMz() != 0) {
                z8 = true;
                z9 = true;
                if (qVar != null && qVar.getAuthor() != null) {
                    String userId2 = qVar.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z8 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.emS != null && this.emS.aMs() != null && this.emS.aMs().getAuthor() != null && qVar.getAuthor() != null) {
                String userId3 = this.emS.aMs().getAuthor().getUserId();
                String userId4 = qVar.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId3)) {
                    if (!UtilHelper.isCurrentAccount(userId4)) {
                        z2 = true;
                        z4 = false;
                        z3 = true;
                    } else {
                        z4 = true;
                        z2 = false;
                        z3 = true;
                    }
                    if (qVar == null && qVar.getAuthor() != null && UtilHelper.isCurrentAccount(qVar.getAuthor().getUserId())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (ecVar.eoh != null) {
                            ecVar.eoh.setVisibility(0);
                            ecVar.eoh.setText(r.j.manage);
                            ecVar.eoh.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (ecVar.eoh != null) {
                            ecVar.eoh.setVisibility(0);
                            ecVar.eoh.setText(r.j.delete);
                            ecVar.eoh.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (ecVar.eoh != null) {
                        ecVar.eoh.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (qVar.bjO() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z8) {
                        sparseArray.put(r.g.tag_should_manage_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(this.emS.aMz()));
                        sparseArray.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(r.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(r.g.tag_user_mute_visible, true);
                        sparseArray.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.emS.aMs() != null) {
                            sparseArray.put(r.g.tag_user_mute_thread_id, this.emS.aMs().getId());
                        }
                        sparseArray.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(r.g.tag_should_delete_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(this.emS.aMz()));
                        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(r.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray.put(r.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        ecVar.enR.setVisibility(8);
                        com.baidu.tbadk.core.util.av.c(ecVar.eoe, r.d.common_color_10005, 1);
                        ecVar.eoe.setText(String.format(this.mContext.getResources().getString(r.j.write_addition_update), qVar.bjP()));
                        if (ecVar.eoh.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.av.c(ecVar.eoh, r.d.cp_link_tip_c, 3);
                            sparseArray.put(r.g.tag_user_mute_visible, false);
                            ecVar.eoh.setTag(sparseArray);
                            ecVar.eoh.setOnClickListener(this.env);
                        }
                    }
                    bjZ = qVar.bjZ();
                    if (bjZ.size() > 0 || (qVar.bjO() == 1 && this.eow.aNk().aQF())) {
                        ecVar.esW.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar = bjZ.get(0);
                        if (!StringUtils.isNull(bVar.getIconUrl())) {
                            a(ecVar, bVar.getIconUrl());
                            if (!StringUtils.isNull(bVar.BS())) {
                                ecVar.esW.setTag(r.g.tag_pb_lottery_tail_link, bVar.BS());
                            }
                        } else {
                            ecVar.esW.setVisibility(8);
                        }
                    }
                    a(ecVar, qVar, qVar.bjO() != 1, aAI);
                    d(ecVar);
                    a(z, qVar, ecVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            if (qVar == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (qVar.bjO() == 1) {
            }
            sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            bjZ = qVar.bjZ();
            if (bjZ.size() > 0) {
            }
            ecVar.esW.setVisibility(8);
            a(ecVar, qVar, qVar.bjO() != 1, aAI);
            d(ecVar);
            a(z, qVar, ecVar);
        }
    }

    private void b(ec ecVar) {
        if (ecVar != null && this.emS != null && this.emS.aMG() != null) {
            ecVar.aPp();
            ecVar.esJ.setOnClickListener(this.bmo);
            com.baidu.tieba.pb.data.l aMG = this.emS.aMG();
            ecVar.esO.setSupportNoImage(true);
            ecVar.esO.setInterceptOnClick(true);
            if (this.cIH) {
                ecVar.esO.setDefaultResource(r.f.transparent_bg);
                ecVar.esO.c(aMG.pO(), 17, false);
            } else {
                ecVar.esO.setDefaultResource(r.f.icon_click);
            }
            ecVar.esO.setOnClickListener(this.bmo);
            ecVar.esN.setOnClickListener(this.bmo);
            int aMK = aMG.aMK();
            String aML = StringUtils.isNull(aMG.aML(), true) ? "" : aMG.aML();
            String string = this.mContext.getString(r.j.yule_head_img);
            if (aMK <= 0) {
                ecVar.esM.setVisibility(8);
                ecVar.esN.setVisibility(8);
            } else {
                ecVar.esM.setVisibility(0);
                ecVar.esN.setVisibility(0);
                if (aMK > 20) {
                    string = String.format(this.mContext.getString(r.j.yule_head_img_rank), "20+");
                } else {
                    string = String.format(this.mContext.getString(r.j.yule_head_img_rank), new StringBuilder(String.valueOf(aMK)).toString());
                }
                ecVar.esM.setText(" " + aML);
            }
            ecVar.esL.setText(string);
            if (aMG.pL()) {
                ecVar.esP.setVisibility(8);
            } else {
                ecVar.esP.setVisibility(0);
                ecVar.esP.setText(String.format(this.mContext.getString(r.j.yule_head_img_pic_author), aMG.pN()));
            }
            if (StringUtils.isNull(this.emS.aMs().getAuthor().getName_show(), true)) {
                ecVar.esQ.setVisibility(8);
            } else {
                ecVar.esQ.setVisibility(0);
                ecVar.esQ.setText(String.format(this.mContext.getString(r.j.yule_head_img_post_author), this.emS.aMs().getAuthor().getName_show()));
            }
            if (ecVar.eom.getVisibility() == 0) {
                View findViewById = ecVar.enE.findViewById(r.g.yule_head_img_blank);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.eom.getLayoutParams();
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams != null && marginLayoutParams != null && layoutParams.height == getDimensionPixelSize(r.e.ds72)) {
                    layoutParams.height -= marginLayoutParams.topMargin;
                }
            }
            c(ecVar);
        }
    }

    private void c(ec ecVar) {
        if (ecVar.esJ != null) {
            com.baidu.tbadk.core.util.av.l(ecVar.esK, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) ecVar.esL, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) ecVar.esM, r.d.cp_cont_e);
            com.baidu.tbadk.core.util.av.j((View) ecVar.esN, r.d.cp_link_tip_a);
            com.baidu.tbadk.core.util.av.j((View) ecVar.esP, r.d.cp_cont_i);
            com.baidu.tbadk.core.util.av.j((View) ecVar.esQ, r.d.cp_cont_i);
        }
    }

    private void a(boolean z, com.baidu.tieba.tbadkCore.data.q qVar, ec ecVar) {
        if (qVar.bjO() == 1 && this.enr) {
            if (ecVar.etd != null) {
                ecVar.etd.setVisibility(8);
            }
        } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class) && EcommSwitchStatic.GK()) {
            if (!z) {
                DealInfoData dealInfoData = qVar.dealInfoData;
                if (dealInfoData != null) {
                    PbReplyEcommCard aPo = ecVar.aPo();
                    aPo.a(dealInfoData, qVar.getId());
                    s(qVar.getId(), dealInfoData.productId);
                    aPo.setVisibility(0);
                    aPo.aRQ();
                } else if (ecVar.etd != null) {
                    ecVar.etd.setVisibility(8);
                }
            } else if (ecVar.etd != null) {
                ecVar.etd.setVisibility(8);
            }
        }
    }

    private void s(String str, long j) {
        if (!this.esC.contains(str)) {
            this.esC.add(str);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11424").ab("tid", str).g("obj_id", j));
        }
    }

    private void a(ec ecVar, String str) {
        ecVar.esW.setVisibility(0);
        com.baidu.adp.lib.g.c.eA().a(str, 17, new ea(this, ecVar, str), this.eow.getUniqueId());
    }

    private void d(ec ecVar) {
        ecVar.enS.setTextViewOnTouchListener(this.emU);
        ecVar.enS.setTextViewCheckSelection(true);
    }

    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aRG() == null) {
            ecVar.eos.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(qVar.aRG(), ecVar.eos, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1367=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int K = (((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int dimensionPixelSize = getDimensionPixelSize(r.e.ds60);
        if (!z) {
            dimensionPixelSize = getDimensionPixelSize(r.e.ds98);
        } else if (z2) {
            dimensionPixelSize = 0;
        }
        int min = Math.min(K - dimensionPixelSize, this.enp);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.q qVar, AdditionData additionData, int i) {
        if (qVar.bjT() > 0 && qVar.bjN() != null) {
            ecVar.eod.setVisibility(0);
            ecVar.eod.removeViews(0, ecVar.eod.getChildCount() - 1);
            int size = qVar.bjN().size();
            int bjU = qVar.bjU();
            for (int i2 = 0; i2 < bjU; i2++) {
                com.baidu.tieba.tbadkCore.data.q qVar2 = qVar.bjN().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, (ViewGroup) ecVar.eod, false);
                ec ecVar2 = new ec(inflate, this.enq, this.cIH, this.enp, true);
                e(ecVar2);
                a(ecVar2, qVar2, (View) ecVar.eod, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(r.g.tag_clip_board, qVar2);
                sparseArray.put(r.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(qVar2.getBimg_url()) || !this.cIH) {
                    sparseArray.put(r.g.tag_richtext_bg, null);
                    ecVar2.enS.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar2.enS.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    ecVar2.enS.setLayoutParams(layoutParams);
                    ecVar2.enS.setPadding(0, 0, 0, 0);
                    ecVar.enS.gI(null);
                } else {
                    ecVar.enS.gI(qVar.getBimg_url());
                    ecVar2.enS.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ecVar2.enS.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(r.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(r.e.ds36);
                    ecVar2.enS.setLayoutParams(layoutParams2);
                }
                ecVar.eod.addView(inflate, ecVar.eod.getChildCount() - 1);
            }
            if (bjU < size) {
                ecVar.eoi.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(ecVar.eok, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ecVar.eol, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.eoj, r.d.cp_cont_f, 1);
                ecVar.eoi.setOnClickListener(new eb(this, bjU, size, qVar));
                return;
            }
            ecVar.eoi.setVisibility(8);
            return;
        }
        ecVar.eod.setVisibility(8);
    }

    private boolean f(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (qVar == null || qVar.getAuthor() == null || qVar.getAuthor().getGodUserData() == null || qVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void e(ec ecVar) {
        ecVar.enE.setOnTouchListener(this.emU);
        ecVar.enE.setOnLongClickListener(this.anY);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eow.getPageContext().getOrignalPage()).epf;
        ecVar.aVU.setOnClickListener(aVar.ewW);
        ecVar.enR.setOnClickListener(this.bmo);
        ecVar.enK.setOnClickListener(aVar.ewW);
        ecVar.enJ.setOnClickListener(aVar.ewW);
        ecVar.enW.setOnLongClickListener(this.anY);
        ecVar.enS.setOnLongClickListener(this.anY);
        ecVar.enW.setOnTouchListener(this.emU);
        ecVar.enS.setOnTouchListener(this.emU);
        ecVar.enS.setOnImageClickListener(this.aJh);
        ecVar.enS.setOnEmotionClickListener(aVar.ewY);
        ecVar.cgq.setOnClickListener(aVar.bUn);
        ecVar.ahw.setOnClickListener(aVar.ewX);
        ecVar.eos.setOnClickListener(this.bmo);
        ecVar.esW.setOnClickListener(this.bmo);
        ecVar.esS.setOnClickListener(this.bmo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.emS = hVar;
    }

    public void ok(int i) {
        this.enp = i;
    }

    public void hQ(boolean z) {
        this.cIH = z;
    }

    public void hR(boolean z) {
        this.enq = z;
    }

    public void hS(boolean z) {
        this.enr = z;
    }

    public void hT(boolean z) {
        this.eqC = z;
    }

    public void oZ(String str) {
        this.ens = str;
    }

    public void F(View.OnClickListener onClickListener) {
        this.env = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmo = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJh = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.emU = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anY = onLongClickListener;
    }

    public void hV(boolean z) {
        this.eoX = z;
    }

    public void a(TbRichTextView.b bVar) {
        this.esA = bVar;
    }
}
