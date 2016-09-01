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
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.view.PbReplyEcommCard;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class du extends cs<com.baidu.tieba.tbadkCore.data.q, ec> implements View.OnClickListener {
    private TbRichTextView.d aJI;
    private boolean adQ;
    private View.OnLongClickListener aoq;
    private View.OnClickListener bmb;
    protected boolean cHP;
    private ArrayList<IconData> dbL;
    protected com.baidu.tieba.pb.data.h ekQ;
    private com.baidu.tieba.pb.a.d ekU;
    private final boolean elA;
    private int elB;
    private int elC;
    protected int els;
    protected boolean elt;
    private boolean elu;
    private String elv;
    private com.baidu.tieba.pb.pb.sub.av elw;
    private ArrayList<IconData> elx;
    private View.OnClickListener ely;
    private boolean elz;
    private boolean emZ;
    private boolean eoE;
    private boolean eqC;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.els = 0;
        this.cHP = true;
        this.elt = true;
        this.elu = true;
        this.ekQ = null;
        this.elv = null;
        this.elw = null;
        this.elx = null;
        this.dbL = null;
        this.ely = null;
        this.bmb = null;
        this.aJI = null;
        this.ekU = null;
        this.aoq = null;
        this.elz = false;
        this.elA = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eoE = false;
        this.eqC = false;
        this.emZ = false;
        this.adQ = false;
        init();
    }

    private void init() {
        this.elB = getDimensionPixelSize(t.e.ds30);
        this.elC = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    private void a(ec ecVar) {
        if (ecVar != null) {
            if (ecVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.av.l(ecVar.elH, t.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.av.l(ecVar.elI, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ecVar.elJ, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ecVar.eqI, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.emh, t.d.common_color_10005, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.emj, t.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.av.c(ecVar.aVl, t.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.av.c((View) ecVar.elO, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c((View) ecVar.elP, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.elR, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.elS, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.elU, t.f.btn_pb_more_btn_selector);
                com.baidu.tbadk.core.util.av.c(ecVar.eqK, t.f.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.av.l(ecVar.elW, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.l(ecVar.elX, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.c(ecVar.elX, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.emb, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ecVar.eqM, t.f.btn_appdownload);
                com.baidu.tbadk.core.util.av.c(ecVar.eqM, t.d.cp_cont_i, 1);
                ecVar.elV.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10039));
                com.baidu.tbadk.core.util.av.c(ecVar.emt, t.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.ems, t.f.icon_pb_pin);
                com.baidu.tbadk.core.util.av.c(ecVar.emq, t.d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.emp, t.f.icon_pb_pin);
                com.baidu.tbadk.core.util.av.k(ecVar.elL, t.f.bg_floor_new_middle);
            }
            ecVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public ec a(ViewGroup viewGroup) {
        ec ecVar = new ec(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.elt, this.cHP, this.els, false);
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
        c(ecVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aJ(i);
        if (qVar2 != null) {
            a(ecVar, qVar2, view, false, i);
        }
        if (!this.elz && this.elA && ecVar != null && ecVar.elV.IN() && (listView = ((PbActivity) this.emy.getPageContext().getOrignalPage()).getListView()) != null) {
            this.elz = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v353, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0931  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x095b  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x098f  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x09e8  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0a1e  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0a9d  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0fca  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0ffa  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x1006  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x1012  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x1056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.a aAk;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bjn;
        UserTbVipInfoData userTbVipInfoData;
        SparseArray sparseArray2;
        if (ecVar != null && qVar != null) {
            if (!z) {
                ecVar.eme.setVisibility(0);
                ecVar.elN.setTag(null);
                ecVar.elN.setUserId(null);
                ecVar.aVl.setText((CharSequence) null);
                ecVar.elP.setVisibility(8);
                ecVar.emc.setVisibility(0);
                ecVar.elU.setVisibility(0);
                ecVar.elT.setVisibility(8);
                if (qVar.bje() == null) {
                    ecVar.emd.setVisibility(8);
                } else if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && qVar.bje().BP() == 1) {
                    ecVar.emd.changeSkinType(this.mSkinType);
                    ecVar.emd.setVisibility(0);
                    ecVar.emd.setData(qVar.bje());
                } else {
                    ecVar.emd.setVisibility(8);
                }
                SparseArray sparseArray3 = (SparseArray) ecVar.elZ.getTag();
                if (sparseArray3 == null) {
                    SparseArray sparseArray4 = new SparseArray();
                    ecVar.elZ.setTag(sparseArray4);
                    ecVar.elV.setTag(sparseArray4);
                    ecVar.elH.setTag(t.g.tag_from, sparseArray4);
                    sparseArray2 = sparseArray4;
                } else {
                    sparseArray2 = sparseArray3;
                }
                sparseArray2.put(t.g.tag_clip_board, qVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                ecVar.elV.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar.elV.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                layoutParams.topMargin = getDimensionPixelSize(t.e.ds20);
                layoutParams.bottomMargin = getDimensionPixelSize(t.e.ds20);
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                if (!this.cHP) {
                    layoutParams.leftMargin = 0;
                    layoutParams.topMargin = 0;
                    ecVar.elV.setIsSupportVitality(true);
                } else if (TextUtils.isEmpty(qVar.getBimg_url())) {
                    this.eqC = false;
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    ecVar.elV.gE(null);
                    ecVar.elV.setBackgroundDrawable(null);
                    if (qVar.bjc() == 1) {
                        ecVar.elV.setIsSupportVitality(true);
                    } else {
                        ecVar.elV.setIsSupportVitality(false);
                    }
                } else {
                    this.eqC = true;
                    ecVar.elV.setIsSupportVitality(false);
                    if (qVar.bjc() == 1) {
                        layoutParams.leftMargin = getDimensionPixelSize(t.e.ds30);
                    } else {
                        layoutParams.leftMargin = 0;
                    }
                    layoutParams.rightMargin = getDimensionPixelSize(t.e.ds30);
                    sparseArray2.put(t.g.tag_richtext_bg, qVar.getBimg_url());
                    ecVar.elV.gE(qVar.getBimg_url());
                }
                ecVar.elV.setLayoutParams(layoutParams);
                if (qVar.bjc() != 1) {
                    if (TextUtils.isEmpty(qVar.getBimg_url())) {
                        ecVar.elV.setOnClickListener(this.bmb);
                        ecVar.elV.setTextViewOnClickListener(this.bmb);
                    } else {
                        ecVar.elV.setOnClickListener(null);
                        ecVar.elV.setTextViewOnClickListener(null);
                    }
                    ecVar.elH.setOnClickListener(this.bmb);
                    ecVar.elZ.setOnClickListener(this.bmb);
                } else {
                    ecVar.elH.setOnClickListener(null);
                    ecVar.elZ.setOnClickListener(null);
                }
                ecVar.elS.setText(qVar.bjd());
                if (qVar.bjc() == 1) {
                    ecVar.elH.setPadding(0, 0, 0, 0);
                    a(ecVar.elV, view, true, this.eqC);
                    ecVar.elI.setVisibility(8);
                    ecVar.elJ.setVisibility(8);
                    ecVar.elK.setVisibility(8);
                    ecVar.eme.setVisibility(8);
                    ecVar.elZ.setVisibility(8);
                    ecVar.elS.setVisibility(8);
                    ecVar.emf.setVisibility(8);
                    ecVar.elY.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (qVar.getAuthor() != null) {
                        j = qVar.getAuthor().getUserIdLong();
                        str = qVar.getAuthor().getUserName();
                    }
                    if (this.ekQ != null && this.ekQ.aLQ() != null) {
                        ecVar.elY.a(qVar.bjl(), str, j, com.baidu.adp.lib.h.b.c(this.ekQ.aLQ().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                    }
                    ecVar.elY.ti();
                    if (this.elu) {
                        PraiseData praiseData = null;
                        if (this.ekQ != null && this.ekQ.aLQ() != null) {
                            this.ekQ.aLQ().rt();
                        }
                        if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                            ecVar.elW.setVisibility(0);
                            ecVar.elX.setVisibility(0);
                            ecVar.elW.setIsFromPb(true);
                            ecVar.elW.a(null, this.ekQ.aLQ().getId(), praiseData.getPostId(), true);
                            ecVar.elW.dl(this.mSkinType);
                        } else {
                            ecVar.elW.setVisibility(8);
                            ecVar.elX.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.al(ecVar.elW);
                        com.baidu.tieba.graffiti.d.al(ecVar.elX);
                        com.baidu.tbadk.data.g bjf = qVar.bjf();
                        ecVar.emr.setVisibility(8);
                        if (bjf != null && !TextUtils.isEmpty(bjf.getName()) && !TextUtils.isEmpty(bjf.getName().trim())) {
                            String name = bjf.getName();
                            String lat = bjf.getLat();
                            String lng = bjf.getLng();
                            ecVar.emo.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, ecVar.emo, 0, 10, 0, 10);
                            ecVar.emq.setText(bjf.getName());
                            ecVar.emo.setOnClickListener(new dv(this, lat, lng, name));
                        } else {
                            ecVar.emp.setVisibility(8);
                            ecVar.emq.setVisibility(8);
                        }
                        if (qVar.getAuthor() != null && qVar.getAuthor().getGodInfo() != null) {
                            ecVar.elY.iI(false);
                            ViewGroup.LayoutParams layoutParams2 = ecVar.emo.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.width = -2;
                                ecVar.emo.setLayoutParams(layoutParams2);
                            }
                            ecVar.emo.setVisibility(0);
                            View findViewWithTag = ecVar.emo.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(t.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(t.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                ecVar.emo.addView(textView, 0);
                            }
                            View findViewWithTag2 = ecVar.emo.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView2, t.d.cp_cont_d, 1);
                                textView2.setText(qVar.bjd());
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(t.e.ds20), 0);
                                ecVar.emo.addView(textView2, 1);
                            }
                            if (ecVar.eqJ == null) {
                                ecVar.emp.setVisibility(8);
                                ecVar.emo.removeView(ecVar.emq);
                                ecVar.eqJ = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams3.addRule(11);
                                layoutParams3.addRule(15);
                                ecVar.emq.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.icon_pb_pin), (Drawable) null, (Drawable) null, (Drawable) null);
                                ecVar.eqJ.addView(ecVar.emq, layoutParams3);
                                ecVar.emo.addView(ecVar.eqJ, new LinearLayout.LayoutParams(-1, -2));
                                if (bjf != null && !TextUtils.isEmpty(bjf.getName()) && !TextUtils.isEmpty(bjf.getName().trim())) {
                                    ecVar.emq.setOnClickListener(new dw(this, bjf.getLat(), bjf.getLng(), bjf.getName()));
                                }
                            }
                            ecVar.emo.setOnClickListener(null);
                        }
                    } else {
                        ecVar.elW.setVisibility(8);
                        ecVar.elX.setVisibility(8);
                        ecVar.emo.setVisibility(8);
                        ecVar.emr.setVisibility(8);
                    }
                    if (this.emy.aMF().aPW()) {
                        ecVar.elV.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) ecVar.emd.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                    if (this.ekQ.aLQ() != null && this.ekQ.aLQ().rM() != null) {
                        com.baidu.tbadk.core.data.bq rM = this.ekQ.aLQ().rM();
                        String activityUrl = rM.getActivityUrl();
                        String sR = rM.sR();
                        String sS = rM.sS();
                        if (!StringUtils.isNull(sS)) {
                            ecVar.eqM.setVisibility(0);
                            ecVar.eqM.setText(sS);
                            ecVar.eqM.setOnClickListener(new dx(this, activityUrl));
                            ecVar.eqN.setOnClickListener(new dy(this, activityUrl));
                            if (!StringUtils.isNull(sR)) {
                                ecVar.bSz.setVisibility(0);
                                ecVar.bSz.c(sR, 10, true);
                            }
                        } else {
                            return;
                        }
                    } else {
                        ecVar.eqM.setVisibility(8);
                        ecVar.bSz.setVisibility(8);
                    }
                    if (ecVar.eqR != null) {
                        ecVar.eqR.setVisibility(8);
                    }
                } else {
                    ecVar.elV.setVisibility(0);
                    a(ecVar.elV, view, false, this.eqC);
                    ecVar.elK.setVisibility(0);
                    ecVar.emf.setVisibility(0);
                    ecVar.elH.setPadding(getDimensionPixelSize(t.e.ds30), 0, getDimensionPixelSize(t.e.ds30), 0);
                    ecVar.bSz.setVisibility(8);
                    ecVar.eqM.setVisibility(8);
                    if (this.eoE && i == 0) {
                        ecVar.elI.setVisibility(8);
                        ecVar.elJ.setVisibility(8);
                    } else if (i == 1) {
                        if (!this.emZ && (qVar.rt() == null || !qVar.rt().isPriaseDataValid())) {
                            ecVar.elI.setVisibility(0);
                        } else if (this.eoE || this.elu) {
                            ecVar.elI.setVisibility(0);
                        } else {
                            ecVar.elI.setVisibility(8);
                        }
                        ecVar.elJ.setVisibility(8);
                    } else {
                        ecVar.elI.setVisibility(0);
                        ecVar.elJ.setVisibility(8);
                        if (i == 2 && this.emZ) {
                            ecVar.elI.setVisibility(8);
                        }
                    }
                    com.baidu.tbadk.data.g bjf2 = qVar.bjf();
                    ecVar.emo.setVisibility(8);
                    if (bjf2 != null && !TextUtils.isEmpty(bjf2.getName()) && !TextUtils.isEmpty(bjf2.getName().trim())) {
                        String name2 = bjf2.getName();
                        String lat2 = bjf2.getLat();
                        String lng2 = bjf2.getLng();
                        ecVar.emr.setVisibility(0);
                        ecVar.emt.setText(bjf2.getName());
                        ecVar.emr.setOnClickListener(new dz(this, lat2, lng2, name2));
                    } else {
                        ecVar.emr.setVisibility(8);
                    }
                    ecVar.elY.setVisibility(8);
                    ((LinearLayout.LayoutParams) ecVar.emd.getLayoutParams()).leftMargin = 0;
                    ecVar.elW.setVisibility(8);
                    ecVar.elX.setVisibility(8);
                    ecVar.elZ.setVisibility(0);
                    ecVar.eme.setVisibility(0);
                    ecVar.elS.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(qVar.bjc()));
                    ecVar.elR.setVisibility(0);
                    ecVar.elR.setText(format);
                    if (ecVar.eqR != null) {
                        if (qVar.rU() != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.eme.getLayoutParams();
                            marginLayoutParams.topMargin = (int) this.emy.getResources().getDimension(t.e.ds16);
                            ecVar.eme.setLayoutParams(marginLayoutParams);
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ecVar.eqS.getLayoutParams();
                            marginLayoutParams2.topMargin = (int) this.emy.getResources().getDimension(t.e.ds10);
                            ecVar.eqS.setLayoutParams(marginLayoutParams2);
                            ecVar.elU.setPadding(ecVar.elU.getPaddingLeft(), (int) this.emy.getResources().getDimension(t.e.ds14), ecVar.elU.getPaddingRight(), ecVar.elU.getPaddingBottom());
                            ecVar.elI.setVisibility(8);
                            ecVar.elJ.setVisibility(8);
                            ecVar.eqR.a(this.emy.getPageContext(), qVar.rU(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", this.ekQ.aLP().getId(), this.ekQ.aLP().getName(), this.ekQ.aLQ().getId(), null));
                            ecVar.elH.setPadding(0, 0, 0, 0);
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) ecVar.eqV.getLayoutParams();
                            marginLayoutParams3.leftMargin = (int) this.emy.getResources().getDimension(t.e.ds30);
                            marginLayoutParams3.rightMargin = (int) this.emy.getResources().getDimension(t.e.ds30);
                            ecVar.eqV.setLayoutParams(marginLayoutParams3);
                        } else {
                            ecVar.eqR.a(null, null, null);
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) ecVar.eqV.getLayoutParams();
                            marginLayoutParams4.leftMargin = 0;
                            marginLayoutParams4.rightMargin = 0;
                            ecVar.eqV.setLayoutParams(marginLayoutParams4);
                        }
                    }
                }
                if (this.elv != null && !this.elv.equals("0") && this.elv.equals(qVar.getAuthor().getUserId())) {
                    ecVar.elT.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(ecVar.elT, t.f.icon_floorhost);
                    ecVar.elT.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                }
            } else {
                ecVar.eme.setVisibility(8);
            }
            ecVar.elV.setVideoImageId(t.f.pic_video);
            SparseArray sparseArray5 = (SparseArray) ecVar.elU.getTag();
            if (sparseArray5 == null) {
                SparseArray sparseArray6 = new SparseArray();
                ecVar.elU.setTag(sparseArray6);
                sparseArray = sparseArray6;
            } else {
                sparseArray = sparseArray5;
            }
            sparseArray.put(t.g.tag_clip_board, qVar);
            sparseArray.put(t.g.tag_load_sub_data, qVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(t.g.tag_pb_floor_number, Integer.valueOf(qVar.bjc()));
            SparseArray sparseArray7 = (SparseArray) ecVar.eqK.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                ecVar.eqK.setTag(sparseArray7);
            }
            sparseArray7.put(t.g.tag_clip_board, qVar);
            sparseArray7.put(t.g.tag_load_sub_data, qVar);
            sparseArray7.put(t.g.tag_load_sub_view, view);
            if (qVar.bjg() > 0 && qVar.biY() != null && qVar.biY().size() > 0) {
                if (this.elw == null) {
                    this.elw = new com.baidu.tieba.pb.pb.sub.av(this.mContext);
                    this.elw.setIsFromCDN(this.mIsFromCDN);
                    this.elw.I(this.ely);
                    boolean z7 = false;
                    String userId2 = this.ekQ.aLQ().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.elw.N(this.ekQ.aLX(), z7);
                    this.elw.r(this.ekQ.aLQ());
                    this.elw.hO(this.elt);
                }
                this.elw.pj(qVar.getId());
                ecVar.emc.setVisibility(0);
                ecVar.emb.setVisibility(0);
                ecVar.ema.setVisibility(0);
                ecVar.emc.a(qVar, view);
                ecVar.emc.setChildOnClickListener(this.bmb);
                ecVar.emc.setChildOnLongClickListener(this.aoq);
                ecVar.emc.setChildOnTouchListener(this.ekU);
                ecVar.emc.setSubPbAdapter(this.elw);
                ecVar.emc.setVisibility(0);
            } else {
                ecVar.emc.setVisibility(8);
                ecVar.emb.setVisibility(8);
                ecVar.ema.setVisibility(8);
            }
            a(ecVar, qVar, this.ekQ.aMa(), i);
            if (!z) {
                String portrait = qVar.getAuthor().getPortrait();
                if (qVar.getAuthor() != null) {
                    String name_show = qVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.v.gz(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                    }
                    ecVar.aVl.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(ecVar.aVl, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(ecVar.aVl, t.d.cp_cont_f, 1);
                    }
                    int level_id = qVar.getAuthor().getLevel_id();
                    int is_bawu = qVar.getAuthor().getIs_bawu();
                    String bawu_type = qVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        ecVar.elO.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(ecVar.elO, BitmapHelper.getGradeResourceIdNew(level_id));
                        String bjp = qVar.bjp();
                        if (StringUtils.isNull(bjp)) {
                            bjp = String.format(TbadkCoreApplication.m9getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id));
                        }
                        ecVar.elO.setContentDescription(bjp);
                        ecVar.elO.setOnClickListener(null);
                    } else {
                        ecVar.elO.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(ecVar.elP, t.f.pb_manager);
                            ecVar.elO.setVisibility(8);
                            ecVar.elP.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(ecVar.elP, t.f.pb_assist);
                            ecVar.elO.setVisibility(8);
                            ecVar.elP.setVisibility(0);
                        }
                        if (ecVar.elP.getVisibility() == 0) {
                            ecVar.elP.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        }
                    }
                    if (ecVar.elO.getVisibility() == 0) {
                        ecVar.elO.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (qVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(ecVar.elQ, t.f.icon_pb_pop_girl);
                        ecVar.elQ.setVisibility(0);
                    } else if (qVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(ecVar.elQ, t.f.icon_pb_pop_boy);
                        ecVar.elQ.setVisibility(0);
                    } else {
                        ecVar.elQ.setVisibility(8);
                    }
                    if (ecVar.elQ.getVisibility() == 0) {
                        ecVar.elQ.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (com.baidu.tbadk.util.v.gz(qVar.getAuthor().getName_show()) >= 14 && ecVar.elO.getVisibility() == 0 && ecVar.elT.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.elx = qVar.getAuthor().getIconInfo();
                    this.dbL = qVar.getAuthor().getTShowInfoNew();
                    if (ecVar.cgs != null) {
                        ecVar.cgs.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                        ecVar.cgs.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.bUu);
                        ecVar.cgs.wC();
                        ecVar.cgs.a(this.elx, i2, getDimensionPixelSize(t.e.ds30), getDimensionPixelSize(t.e.ds30), getDimensionPixelSize(t.e.ds10));
                    }
                    if (ecVar.ahO != null) {
                        ecVar.ahO.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euR);
                        if (this.dbL != null && this.dbL.size() > 0 && this.dbL.get(0) != null) {
                            ecVar.ahO.setTag(this.dbL.get(0).getUrl());
                        }
                        ecVar.ahO.a(this.dbL, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.ds8), true);
                    }
                }
                if (qVar.getAuthor() == null || qVar.getAuthor().getUserTbVipInfoData() == null) {
                    userTbVipInfoData = null;
                } else {
                    userTbVipInfoData = qVar.getAuthor().getUserTbVipInfoData();
                }
                if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().rc())) {
                    if (this.elt) {
                        ecVar.elN.setVisibility(4);
                        ecVar.eqL.setVisibility(8);
                        ecVar.elM.setVisibility(0);
                    } else {
                        ecVar.elM.setVisibility(8);
                    }
                    ecVar.elH.setPadding(getDimensionPixelSize(t.e.ds4), 0, getDimensionPixelSize(t.e.ds30), 0);
                    ecVar.eqL.setVisibility(8);
                    ecVar.elM.getHeadView().setUserId(qVar.getAuthor().getUserId());
                    ecVar.elM.getHeadView().ae(qVar.getAuthor().getUserName(), qVar.bjo());
                    ecVar.elM.getHeadView().setImageDrawable(null);
                    ecVar.elM.getHeadView().c(portrait, 28, false);
                    ecVar.elM.dU(qVar.getAuthor().getPendantData().rc());
                    ecVar.elM.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                    ecVar.elM.setTag(t.g.tag_user_name, qVar.getAuthor().getUserName());
                } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                    if (this.elt) {
                        if (ecVar.aYe != null) {
                            if (ecVar.aYf == null) {
                                ecVar.aYe.inflate();
                                ecVar.aYf = (TbImageView) ecVar.getView().findViewById(t.g.user_head_mask);
                            }
                            ecVar.aYf.c(userTbVipInfoData.getvipV_url(), 10, false);
                            ecVar.eqL.setIsBigV(true);
                        }
                        ecVar.elN.setVisibility(4);
                        ecVar.eqL.setVisibility(0);
                    } else {
                        ecVar.elN.setVisibility(4);
                        ecVar.eqL.setVisibility(4);
                        ecVar.aYf.setVisibility(8);
                    }
                    ecVar.elM.setVisibility(8);
                    ecVar.eqL.setData(qVar.getAuthor());
                    ecVar.eqL.setUserId(qVar.getAuthor().getUserId());
                    ecVar.eqL.ae(qVar.getAuthor().getUserName(), qVar.bjo());
                } else {
                    ecVar.elM.setVisibility(8);
                    if (f(qVar)) {
                        if (this.elt) {
                            ecVar.elN.setVisibility(4);
                            ecVar.eqL.setVisibility(0);
                        }
                        ecVar.eqL.c(portrait, 28, false);
                        ecVar.eqL.setUserId(qVar.getAuthor().getUserId());
                        ecVar.eqL.ae(qVar.getAuthor().getUserName(), qVar.bjo());
                        ecVar.eqL.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euQ);
                    } else {
                        if (this.elt) {
                            ecVar.elN.setVisibility(0);
                        }
                        ecVar.eqL.setVisibility(8);
                        ecVar.elN.setUserId(qVar.getAuthor().getUserId());
                        ecVar.elN.ae(qVar.getAuthor().getUserName(), qVar.bjo());
                        ecVar.elN.setImageDrawable(null);
                        ecVar.elN.c(portrait, 28, false);
                    }
                }
                ecVar.aVl.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                ecVar.aVl.setTag(t.g.tag_user_name, qVar.getAuthor().getUserName());
            }
            ecVar.elV.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_link_tip_c));
            if (this.cHP) {
                ecVar.elV.setDefaultImageId(t.f.transparent_bg);
            } else {
                ecVar.elV.setDefaultImageId(t.f.icon_click);
            }
            ecVar.elV.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                aAk = null;
            } else {
                aAk = qVar.aAk();
            }
            if (this.elz || !this.elA) {
                ecVar.elV.a(aAk, false);
            } else {
                ecVar.elV.a(aAk, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.ekQ.aLX() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = qVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.ekQ != null && this.ekQ.aLQ() != null && this.ekQ.aLQ().getAuthor() != null && qVar.getAuthor() != null) {
                String userId4 = this.ekQ.aLQ().getAuthor().getUserId();
                String userId5 = qVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = qVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (ecVar.emj != null) {
                            ecVar.emj.setVisibility(0);
                            ecVar.emj.setText(t.j.manage);
                            ecVar.emj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (ecVar.emj != null) {
                            ecVar.emj.setVisibility(0);
                            ecVar.emj.setText(t.j.delete);
                            ecVar.emj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (ecVar.emj != null) {
                        ecVar.emj.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (qVar.bjc() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ekQ.aLX()));
                        sparseArray.put(t.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.ekQ.aLQ() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.ekQ.aLQ().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ekQ.aLX()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        ecVar.elU.setVisibility(8);
                        com.baidu.tbadk.core.util.av.c(ecVar.emh, t.d.common_color_10005, 1);
                        ecVar.emh.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), qVar.bjd()));
                        if (ecVar.emj.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.av.c(ecVar.emj, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            ecVar.emj.setTag(sparseArray);
                            ecVar.emj.setOnClickListener(this.ely);
                        }
                    }
                    bjn = qVar.bjn();
                    if (bjn.size() > 0 || (qVar.bjc() == 1 && this.emy.aMF().aPW())) {
                        ecVar.eqO.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar = bjn.get(0);
                        if (!StringUtils.isNull(bVar.getIconUrl())) {
                            a(ecVar, bVar.getIconUrl());
                            if (!StringUtils.isNull(bVar.BO())) {
                                ecVar.eqO.setTag(t.g.tag_pb_lottery_tail_link, bVar.BO());
                            }
                        } else {
                            ecVar.eqO.setVisibility(8);
                        }
                    }
                    a(ecVar, qVar, qVar.bjc() != 1, aAk);
                    b(ecVar);
                    a(z, qVar, ecVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = qVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (qVar.bjc() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, qVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            bjn = qVar.bjn();
            if (bjn.size() > 0) {
            }
            ecVar.eqO.setVisibility(8);
            a(ecVar, qVar, qVar.bjc() != 1, aAk);
            b(ecVar);
            a(z, qVar, ecVar);
        }
    }

    private void a(boolean z, com.baidu.tieba.tbadkCore.data.q qVar, ec ecVar) {
        if (qVar.bjc() == 1 && this.elu) {
            if (ecVar.eqU != null) {
                ecVar.eqU.setVisibility(8);
            }
        } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class) && EcommSwitchStatic.GL()) {
            if (!z) {
                DealInfoData dealInfoData = qVar.dealInfoData;
                if (dealInfoData != null) {
                    PbReplyEcommCard aOG = ecVar.aOG();
                    aOG.setData(dealInfoData);
                    aOG.setVisibility(0);
                    aOG.aRi();
                } else if (ecVar.eqU != null) {
                    ecVar.eqU.setVisibility(8);
                }
            } else if (ecVar.eqU != null) {
                ecVar.eqU.setVisibility(8);
            }
        }
    }

    private void a(ec ecVar, String str) {
        ecVar.eqO.setVisibility(0);
        com.baidu.adp.lib.g.c.eA().a(str, 17, new ea(this, ecVar, str), this.emy.getUniqueId());
    }

    private void b(ec ecVar) {
        ecVar.elV.setTextViewOnTouchListener(this.ekU);
        ecVar.elV.setTextViewCheckSelection(true);
    }

    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aQY() == null) {
            ecVar.emu.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(qVar.aQY(), ecVar.emu, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1232=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int K = (((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int dimensionPixelSize = getDimensionPixelSize(t.e.ds60);
        if (!z) {
            dimensionPixelSize = getDimensionPixelSize(t.e.ds98);
        } else if (z2) {
            dimensionPixelSize = 0;
        }
        int min = Math.min(K - dimensionPixelSize, this.els);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.q qVar, AdditionData additionData, int i) {
        if (qVar.bjh() > 0 && qVar.bjb() != null) {
            ecVar.emg.setVisibility(0);
            ecVar.emg.removeViews(0, ecVar.emg.getChildCount() - 1);
            int size = qVar.bjb().size();
            int bji = qVar.bji();
            for (int i2 = 0; i2 < bji; i2++) {
                com.baidu.tieba.tbadkCore.data.q qVar2 = qVar.bjb().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) ecVar.emg, false);
                ec ecVar2 = new ec(inflate, this.elt, this.cHP, this.els, true);
                c(ecVar2);
                a(ecVar2, qVar2, (View) ecVar.emg, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, qVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(qVar2.getBimg_url()) || !this.cHP) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    ecVar2.elV.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar2.elV.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    ecVar2.elV.setLayoutParams(layoutParams);
                    ecVar2.elV.setPadding(0, 0, 0, 0);
                    ecVar.elV.gE(null);
                } else {
                    ecVar.elV.gE(qVar.getBimg_url());
                    ecVar2.elV.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ecVar2.elV.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    ecVar2.elV.setLayoutParams(layoutParams2);
                }
                ecVar.emg.addView(inflate, ecVar.emg.getChildCount() - 1);
            }
            if (bji < size) {
                ecVar.emk.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(ecVar.emm, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ecVar.emn, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.eml, t.d.cp_cont_f, 1);
                ecVar.emk.setOnClickListener(new eb(this, bji, size, qVar));
                return;
            }
            ecVar.emk.setVisibility(8);
            return;
        }
        ecVar.emg.setVisibility(8);
    }

    private boolean f(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (qVar == null || qVar.getAuthor() == null || qVar.getAuthor().getGodUserData() == null || qVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void c(ec ecVar) {
        ecVar.elH.setOnTouchListener(this.ekU);
        ecVar.elH.setOnLongClickListener(this.aoq);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.emy.getPageContext().getOrignalPage()).eni;
        ecVar.aVl.setOnClickListener(aVar.euQ);
        ecVar.elU.setOnClickListener(this.bmb);
        ecVar.elN.setOnClickListener(aVar.euQ);
        ecVar.elM.setOnClickListener(aVar.euQ);
        ecVar.elZ.setOnLongClickListener(this.aoq);
        ecVar.elV.setOnLongClickListener(this.aoq);
        ecVar.elZ.setOnTouchListener(this.ekU);
        ecVar.elV.setOnTouchListener(this.ekU);
        ecVar.elV.setOnImageClickListener(this.aJI);
        ecVar.elV.setOnEmotionClickListener(aVar.euS);
        ecVar.cgs.setOnClickListener(aVar.bUu);
        ecVar.ahO.setOnClickListener(aVar.euR);
        ecVar.emu.setOnClickListener(this.bmb);
        ecVar.eqO.setOnClickListener(this.bmb);
        ecVar.eqK.setOnClickListener(this.bmb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.ekQ = hVar;
    }

    public void oa(int i) {
        this.els = i;
    }

    public void hN(boolean z) {
        this.cHP = z;
    }

    public void hO(boolean z) {
        this.elt = z;
    }

    public void hP(boolean z) {
        this.elu = z;
    }

    public void hQ(boolean z) {
        this.eoE = z;
    }

    public void oL(String str) {
        this.elv = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.ely = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmb = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJI = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ekU = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoq = onLongClickListener;
    }

    public void hS(boolean z) {
        this.emZ = z;
    }
}
