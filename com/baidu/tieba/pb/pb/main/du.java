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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class du extends cs<com.baidu.tieba.tbadkCore.data.s, ec> implements View.OnClickListener {
    private TbRichTextView.d aGw;
    private boolean abg;
    private View.OnLongClickListener alj;
    private View.OnClickListener baF;
    private ArrayList<IconData> cQe;
    protected boolean cwk;
    protected com.baidu.tieba.pb.data.h dYM;
    private com.baidu.tieba.pb.a.d dYQ;
    protected int dZo;
    protected boolean dZp;
    private boolean dZq;
    private String dZr;
    private com.baidu.tieba.pb.pb.sub.au dZs;
    private ArrayList<IconData> dZt;
    private View.OnClickListener dZu;
    private boolean dZv;
    private final boolean dZw;
    private int dZx;
    private int dZy;
    private boolean eaU;
    private boolean ecz;
    private boolean eex;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dZo = 0;
        this.cwk = true;
        this.dZp = true;
        this.dZq = true;
        this.dYM = null;
        this.dZr = null;
        this.dZs = null;
        this.dZt = null;
        this.cQe = null;
        this.dZu = null;
        this.baF = null;
        this.aGw = null;
        this.dYQ = null;
        this.alj = null;
        this.dZv = false;
        this.dZw = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.ecz = false;
        this.eex = false;
        this.eaU = false;
        this.abg = false;
        init();
    }

    private void init() {
        this.dZx = getDimensionPixelSize(u.e.ds30);
        this.dZy = com.baidu.adp.lib.util.k.A(this.mContext) - getDimensionPixelSize(u.e.ds60);
    }

    private void a(ec ecVar) {
        if (ecVar != null) {
            if (ecVar.mSkinType != TbadkCoreApplication.m10getInst().getSkinType()) {
                com.baidu.tbadk.core.util.av.l(ecVar.dZD, u.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.av.l(ecVar.dZE, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ecVar.dZF, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ecVar.eeD, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.eac, u.d.common_color_10005, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.eae, u.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.av.c(ecVar.aPR, u.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.av.c((View) ecVar.dZJ, u.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c((View) ecVar.dZK, u.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.dZM, u.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.dZN, u.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ecVar.dZP, u.f.btn_pb_more_btn_selector);
                com.baidu.tbadk.core.util.av.c(ecVar.eeF, u.f.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.av.l(ecVar.dZR, u.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.l(ecVar.dZS, u.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.c(ecVar.dZS, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.dZW, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ecVar.eeH, u.f.btn_appdownload);
                com.baidu.tbadk.core.util.av.c(ecVar.eeH, u.d.cp_cont_i, 1);
                ecVar.dZQ.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10039));
            }
            ecVar.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public ec a(ViewGroup viewGroup) {
        ec ecVar = new ec(LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, viewGroup, false), this.dZp, this.cwk, this.dZo, false);
        a(ecVar);
        return ecVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, ec ecVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) ecVar);
        a(ecVar);
        c(ecVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) aw(i);
        if (sVar2 != null) {
            a(ecVar, sVar2, view, false, i);
        }
        if (!this.dZv && this.dZw && ecVar != null && ecVar.dZQ.Ho() && (listView = ((PbActivity) this.eat.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dZv = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v328, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0922  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0936  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x09b7  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x09ed  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0a6c  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0f20  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0f50  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0f5c  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0f68  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0fac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.a avx;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bfM;
        UserTbVipInfoData userTbVipInfoData;
        SparseArray sparseArray2;
        if (ecVar != null && sVar != null) {
            if (!z) {
                ecVar.dZZ.setVisibility(0);
                ecVar.dZI.setTag(null);
                ecVar.dZI.setUserId(null);
                ecVar.aPR.setText((CharSequence) null);
                ecVar.dZK.setVisibility(8);
                ecVar.dZX.setVisibility(0);
                ecVar.dZP.setVisibility(0);
                ecVar.dZO.setVisibility(8);
                if (sVar.bfD() == null) {
                    ecVar.dZY.setVisibility(8);
                } else if (TbadkCoreApplication.m10getInst().isBaobaoShouldOpen() && sVar.bfD().AA() == 1) {
                    ecVar.dZY.changeSkinType(this.mSkinType);
                    ecVar.dZY.setVisibility(0);
                    ecVar.dZY.setData(sVar.bfD());
                } else {
                    ecVar.dZY.setVisibility(8);
                }
                SparseArray sparseArray3 = (SparseArray) ecVar.dZU.getTag();
                if (sparseArray3 == null) {
                    SparseArray sparseArray4 = new SparseArray();
                    ecVar.dZU.setTag(sparseArray4);
                    ecVar.dZQ.setTag(sparseArray4);
                    ecVar.dZD.setTag(u.g.tag_from, sparseArray4);
                    sparseArray2 = sparseArray4;
                } else {
                    sparseArray2 = sparseArray3;
                }
                sparseArray2.put(u.g.tag_clip_board, sVar);
                sparseArray2.put(u.g.tag_is_subpb, false);
                ecVar.dZQ.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar.dZQ.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                layoutParams.topMargin = getDimensionPixelSize(u.e.ds20);
                layoutParams.bottomMargin = getDimensionPixelSize(u.e.ds20);
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                if (!this.cwk) {
                    layoutParams.leftMargin = 0;
                    layoutParams.topMargin = 0;
                    ecVar.dZQ.setIsSupportVitality(true);
                } else if (TextUtils.isEmpty(sVar.getBimg_url())) {
                    this.eex = false;
                    sparseArray2.put(u.g.tag_richtext_bg, null);
                    ecVar.dZQ.gB(null);
                    ecVar.dZQ.setBackgroundDrawable(null);
                    if (sVar.bfB() == 1) {
                        ecVar.dZQ.setIsSupportVitality(true);
                    } else {
                        ecVar.dZQ.setIsSupportVitality(false);
                    }
                } else {
                    this.eex = true;
                    ecVar.dZQ.setIsSupportVitality(false);
                    if (sVar.bfB() == 1) {
                        layoutParams.leftMargin = getDimensionPixelSize(u.e.ds30);
                    } else {
                        layoutParams.leftMargin = 0;
                    }
                    layoutParams.rightMargin = getDimensionPixelSize(u.e.ds30);
                    sparseArray2.put(u.g.tag_richtext_bg, sVar.getBimg_url());
                    ecVar.dZQ.gB(sVar.getBimg_url());
                }
                ecVar.dZQ.setLayoutParams(layoutParams);
                if (sVar.bfB() != 1) {
                    if (TextUtils.isEmpty(sVar.getBimg_url())) {
                        ecVar.dZQ.setOnClickListener(this.baF);
                        ecVar.dZQ.setTextViewOnClickListener(this.baF);
                    } else {
                        ecVar.dZQ.setOnClickListener(null);
                        ecVar.dZQ.setTextViewOnClickListener(null);
                    }
                    ecVar.dZD.setOnClickListener(this.baF);
                    ecVar.dZU.setOnClickListener(this.baF);
                } else {
                    ecVar.dZD.setOnClickListener(null);
                    ecVar.dZU.setOnClickListener(null);
                }
                ecVar.dZN.setText(sVar.bfC());
                if (sVar.bfB() == 1) {
                    ecVar.dZD.setPadding(0, 0, 0, 0);
                    a(ecVar.dZQ, view, true, this.eex);
                    ecVar.dZE.setVisibility(8);
                    ecVar.dZF.setVisibility(8);
                    ecVar.dZG.setVisibility(8);
                    ecVar.dZZ.setVisibility(8);
                    ecVar.dZU.setVisibility(8);
                    ecVar.dZN.setVisibility(8);
                    ecVar.eaa.setVisibility(8);
                    ecVar.dZT.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    if (this.dYM != null && this.dYM.aGY() != null) {
                        ecVar.dZT.a(sVar.bfK(), str, j, com.baidu.adp.lib.h.b.c(this.dYM.aGY().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    }
                    ecVar.dZT.sd();
                    if (this.dZq) {
                        PraiseData praiseData = null;
                        if (this.dYM != null && this.dYM.aGY() != null) {
                            this.dYM.aGY().qp();
                        }
                        if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                            ecVar.dZR.setVisibility(0);
                            ecVar.dZS.setVisibility(0);
                            ecVar.dZR.setIsFromPb(true);
                            ecVar.dZR.a(null, this.dYM.aGY().getId(), praiseData.getPostId(), true);
                            ecVar.dZR.cX(this.mSkinType);
                        } else {
                            ecVar.dZR.setVisibility(8);
                            ecVar.dZS.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.al(ecVar.dZR);
                        com.baidu.tieba.graffiti.d.al(ecVar.dZS);
                        com.baidu.tbadk.data.g bfE = sVar.bfE();
                        ecVar.eam.setVisibility(8);
                        if (bfE != null && !TextUtils.isEmpty(bfE.getName()) && !TextUtils.isEmpty(bfE.getName().trim())) {
                            String name = bfE.getName();
                            String lat = bfE.getLat();
                            String lng = bfE.getLng();
                            ecVar.eaj.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, ecVar.eaj, 0, 10, 0, 10);
                            ecVar.eal.setText(bfE.getName());
                            com.baidu.tbadk.core.util.av.c(ecVar.eal, u.d.cp_link_tip_c, 1);
                            com.baidu.tbadk.core.util.av.c(ecVar.eak, u.f.icon_pb_pin);
                            ecVar.eaj.setOnClickListener(new dv(this, lat, lng, name));
                        } else {
                            ecVar.eak.setVisibility(8);
                            ecVar.eal.setVisibility(8);
                        }
                        if (sVar.getAuthor() != null && sVar.getAuthor().getGodInfo() != null) {
                            ecVar.dZT.in(false);
                            ViewGroup.LayoutParams layoutParams2 = ecVar.eaj.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.width = -2;
                                ecVar.eaj.setLayoutParams(layoutParams2);
                            }
                            ecVar.eaj.setVisibility(0);
                            View findViewWithTag = ecVar.eaj.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(u.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(u.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(u.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                ecVar.eaj.addView(textView, 0);
                            }
                            View findViewWithTag2 = ecVar.eaj.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(u.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_d, 1);
                                textView2.setText(sVar.bfC());
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(u.e.ds20), 0);
                                ecVar.eaj.addView(textView2, 1);
                            }
                            if (ecVar.eeE == null) {
                                ecVar.eak.setVisibility(8);
                                ecVar.eaj.removeView(ecVar.eal);
                                ecVar.eeE = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams3.addRule(11);
                                layoutParams3.addRule(15);
                                ecVar.eal.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.icon_pb_pin), (Drawable) null, (Drawable) null, (Drawable) null);
                                ecVar.eeE.addView(ecVar.eal, layoutParams3);
                                ecVar.eaj.addView(ecVar.eeE, new LinearLayout.LayoutParams(-1, -2));
                                if (bfE != null && !TextUtils.isEmpty(bfE.getName()) && !TextUtils.isEmpty(bfE.getName().trim())) {
                                    ecVar.eal.setOnClickListener(new dw(this, bfE.getLat(), bfE.getLng(), bfE.getName()));
                                }
                            }
                            ecVar.eaj.setOnClickListener(null);
                        }
                    } else {
                        ecVar.dZR.setVisibility(8);
                        ecVar.dZS.setVisibility(8);
                        ecVar.eaj.setVisibility(8);
                        ecVar.eam.setVisibility(8);
                    }
                    if (this.eat.aHN().aLf()) {
                        ecVar.dZQ.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) ecVar.dZY.getLayoutParams()).leftMargin = getDimensionPixelSize(u.e.ds30);
                    if (this.dYM.aGY() != null && this.dYM.aGY().qH() != null) {
                        com.baidu.tbadk.core.data.bm qH = this.dYM.aGY().qH();
                        String activityUrl = qH.getActivityUrl();
                        String rM = qH.rM();
                        String rN = qH.rN();
                        if (!StringUtils.isNull(rN)) {
                            ecVar.eeH.setVisibility(0);
                            ecVar.eeH.setText(rN);
                            ecVar.eeH.setOnClickListener(new dx(this, activityUrl));
                            ecVar.eeI.setOnClickListener(new dy(this, activityUrl));
                            if (!StringUtils.isNull(rM)) {
                                ecVar.bHt.setVisibility(0);
                                ecVar.bHt.c(rM, 10, true);
                            }
                        } else {
                            return;
                        }
                    } else {
                        ecVar.eeH.setVisibility(8);
                        ecVar.bHt.setVisibility(8);
                    }
                    if (ecVar.eeM != null) {
                        ecVar.eeM.setVisibility(8);
                    }
                } else {
                    ecVar.dZQ.setVisibility(0);
                    a(ecVar.dZQ, view, false, this.eex);
                    ecVar.dZG.setVisibility(0);
                    ecVar.eaa.setVisibility(0);
                    ecVar.dZD.setPadding(getDimensionPixelSize(u.e.ds30), 0, getDimensionPixelSize(u.e.ds30), 0);
                    ecVar.bHt.setVisibility(8);
                    ecVar.eeH.setVisibility(8);
                    if (this.ecz && i == 0) {
                        ecVar.dZE.setVisibility(8);
                        ecVar.dZF.setVisibility(8);
                    } else if (i == 1) {
                        if (!this.eaU && (sVar.qp() == null || !sVar.qp().isPriaseDataValid())) {
                            ecVar.dZE.setVisibility(0);
                        } else if (this.ecz || this.dZq) {
                            ecVar.dZE.setVisibility(0);
                        } else {
                            ecVar.dZE.setVisibility(8);
                        }
                        ecVar.dZF.setVisibility(8);
                    } else {
                        ecVar.dZE.setVisibility(0);
                        ecVar.dZF.setVisibility(8);
                        if (i == 2 && this.eaU) {
                            ecVar.dZE.setVisibility(8);
                        }
                    }
                    com.baidu.tbadk.data.g bfE2 = sVar.bfE();
                    ecVar.eaj.setVisibility(8);
                    if (bfE2 != null && !TextUtils.isEmpty(bfE2.getName()) && !TextUtils.isEmpty(bfE2.getName().trim())) {
                        String name2 = bfE2.getName();
                        String lat2 = bfE2.getLat();
                        String lng2 = bfE2.getLng();
                        ecVar.eam.setVisibility(0);
                        ecVar.eao.setText(bfE2.getName());
                        com.baidu.tbadk.core.util.av.c(ecVar.eao, u.d.cp_link_tip_c, 1);
                        com.baidu.tbadk.core.util.av.c(ecVar.ean, u.f.icon_pb_pin);
                        ecVar.eam.setOnClickListener(new dz(this, lat2, lng2, name2));
                    } else {
                        ecVar.eam.setVisibility(8);
                    }
                    ecVar.dZT.setVisibility(8);
                    ((LinearLayout.LayoutParams) ecVar.dZY.getLayoutParams()).leftMargin = 0;
                    ecVar.dZR.setVisibility(8);
                    ecVar.dZS.setVisibility(8);
                    ecVar.dZU.setVisibility(0);
                    ecVar.dZZ.setVisibility(0);
                    ecVar.dZN.setVisibility(0);
                    String format = String.format(this.mContext.getString(u.j.is_floor), Integer.valueOf(sVar.bfB()));
                    ecVar.dZM.setVisibility(0);
                    ecVar.dZM.setText(format);
                    if (ecVar.eeM != null) {
                        if (sVar.qP() != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.dZZ.getLayoutParams();
                            marginLayoutParams.topMargin = (int) this.eat.getResources().getDimension(u.e.ds16);
                            ecVar.dZZ.setLayoutParams(marginLayoutParams);
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ecVar.eeN.getLayoutParams();
                            marginLayoutParams2.topMargin = (int) this.eat.getResources().getDimension(u.e.ds10);
                            ecVar.eeN.setLayoutParams(marginLayoutParams2);
                            ecVar.dZP.setPadding(ecVar.dZP.getPaddingLeft(), (int) this.eat.getResources().getDimension(u.e.ds14), ecVar.dZP.getPaddingRight(), ecVar.dZP.getPaddingBottom());
                            ecVar.dZE.setVisibility(8);
                            ecVar.dZF.setVisibility(8);
                            ecVar.eeM.a(this.eat.getPageContext(), sVar.qP(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", this.dYM.aGX().getId(), this.dYM.aGX().getName(), this.dYM.aGY().getId(), null));
                            ecVar.dZD.setPadding(0, 0, 0, 0);
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) ecVar.eeQ.getLayoutParams();
                            marginLayoutParams3.leftMargin = (int) this.eat.getResources().getDimension(u.e.ds30);
                            marginLayoutParams3.rightMargin = (int) this.eat.getResources().getDimension(u.e.ds30);
                            ecVar.eeQ.setLayoutParams(marginLayoutParams3);
                        } else {
                            ecVar.eeM.a(null, null, null);
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) ecVar.eeQ.getLayoutParams();
                            marginLayoutParams4.leftMargin = 0;
                            marginLayoutParams4.rightMargin = 0;
                            ecVar.eeQ.setLayoutParams(marginLayoutParams4);
                        }
                    }
                }
                if (this.dZr != null && !this.dZr.equals("0") && this.dZr.equals(sVar.getAuthor().getUserId())) {
                    ecVar.dZO.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(ecVar.dZO, u.f.icon_floorhost);
                    ecVar.dZO.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                }
            } else {
                ecVar.dZZ.setVisibility(8);
            }
            com.baidu.tbadk.core.util.av.k(ecVar.dZH, u.f.bg_floor_new_middle);
            ecVar.dZQ.setVideoImageId(u.f.pic_video);
            com.baidu.tbadk.core.util.av.c(ecVar.dZP, u.f.btn_pb_more_btn_selector);
            SparseArray sparseArray5 = (SparseArray) ecVar.dZP.getTag();
            if (sparseArray5 == null) {
                SparseArray sparseArray6 = new SparseArray();
                ecVar.dZP.setTag(sparseArray6);
                sparseArray = sparseArray6;
            } else {
                sparseArray = sparseArray5;
            }
            sparseArray.put(u.g.tag_clip_board, sVar);
            sparseArray.put(u.g.tag_load_sub_data, sVar);
            sparseArray.put(u.g.tag_load_sub_view, view);
            sparseArray.put(u.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(u.g.tag_pb_floor_number, Integer.valueOf(sVar.bfB()));
            SparseArray sparseArray7 = (SparseArray) ecVar.eeF.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                ecVar.eeF.setTag(sparseArray7);
            }
            sparseArray7.put(u.g.tag_clip_board, sVar);
            sparseArray7.put(u.g.tag_load_sub_data, sVar);
            sparseArray7.put(u.g.tag_load_sub_view, view);
            if (sVar.bfF() > 0 && sVar.bfx() != null && sVar.bfx().size() > 0) {
                if (this.dZs == null) {
                    this.dZs = new com.baidu.tieba.pb.pb.sub.au(this.mContext);
                    this.dZs.setIsFromCDN(this.mIsFromCDN);
                    this.dZs.K(this.dZu);
                    boolean z7 = false;
                    String userId2 = this.dYM.aGY().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.dZs.N(this.dYM.aHf(), z7);
                    this.dZs.r(this.dYM.aGY());
                    this.dZs.hs(this.dZp);
                }
                ecVar.dZX.setVisibility(0);
                ecVar.dZW.setVisibility(0);
                ecVar.dZV.setVisibility(0);
                ecVar.dZX.a(sVar, view);
                ecVar.dZX.setChildOnClickListener(this.baF);
                ecVar.dZX.setChildOnLongClickListener(this.alj);
                ecVar.dZX.setChildOnTouchListener(this.dYQ);
                ecVar.dZX.setSubPbAdapter(this.dZs);
                ecVar.dZX.setVisibility(0);
            } else {
                ecVar.dZX.setVisibility(8);
                ecVar.dZW.setVisibility(8);
                ecVar.dZV.setVisibility(8);
            }
            a(ecVar, sVar, this.dYM.aHi(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.v.gw(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                    }
                    ecVar.aPR.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(ecVar.aPR, u.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(ecVar.aPR, u.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        ecVar.dZJ.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(ecVar.dZJ, BitmapHelper.getGradeResourceIdNew(level_id));
                        String bfO = sVar.bfO();
                        if (StringUtils.isNull(bfO)) {
                            bfO = String.format(TbadkCoreApplication.m10getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id));
                        }
                        ecVar.dZJ.setContentDescription(bfO);
                        ecVar.dZJ.setOnClickListener(null);
                    } else {
                        ecVar.dZJ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(ecVar.dZK, u.f.pb_manager);
                            ecVar.dZJ.setVisibility(8);
                            ecVar.dZK.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(ecVar.dZK, u.f.pb_assist);
                            ecVar.dZJ.setVisibility(8);
                            ecVar.dZK.setVisibility(0);
                        }
                        if (ecVar.dZK.getVisibility() == 0) {
                            ecVar.dZK.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        }
                    }
                    if (ecVar.dZJ.getVisibility() == 0) {
                        ecVar.dZJ.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(ecVar.dZL, u.f.icon_pb_pop_girl);
                        ecVar.dZL.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(ecVar.dZL, u.f.icon_pb_pop_boy);
                        ecVar.dZL.setVisibility(0);
                    } else {
                        ecVar.dZL.setVisibility(8);
                    }
                    if (ecVar.dZL.getVisibility() == 0) {
                        ecVar.dZL.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (com.baidu.tbadk.util.v.gw(sVar.getAuthor().getName_show()) >= 14 && ecVar.dZJ.getVisibility() == 0 && ecVar.dZO.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.dZt = sVar.getAuthor().getIconInfo();
                    this.cQe = sVar.getAuthor().getTShowInfoNew();
                    if (ecVar.bVj != null) {
                        ecVar.bVj.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                        ecVar.bVj.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.bJt);
                        ecVar.bVj.vy();
                        ecVar.bVj.a(this.dZt, i2, getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds10));
                    }
                    if (ecVar.aeT != null) {
                        ecVar.aeT.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.eiK);
                        if (this.cQe != null && this.cQe.size() > 0 && this.cQe.get(0) != null) {
                            ecVar.aeT.setTag(this.cQe.get(0).getUrl());
                        }
                        ecVar.aeT.a(this.cQe, 3, getDimensionPixelSize(u.e.ds36), getDimensionPixelSize(u.e.ds36), getDimensionPixelSize(u.e.ds8), true);
                    }
                }
                if (sVar.getAuthor() == null || sVar.getAuthor().getUserTbVipInfoData() == null) {
                    userTbVipInfoData = null;
                } else {
                    userTbVipInfoData = sVar.getAuthor().getUserTbVipInfoData();
                }
                if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                    if (this.dZp) {
                        if (ecVar.aSW != null) {
                            if (ecVar.aSX == null) {
                                ecVar.aSW.inflate();
                                ecVar.aSX = (TbImageView) ecVar.getView().findViewById(u.g.user_head_mask);
                            }
                            ecVar.aSX.c(userTbVipInfoData.getvipV_url(), 10, false);
                            ecVar.eeG.setIsBigV(true);
                        }
                        ecVar.dZI.setVisibility(4);
                        ecVar.eeG.setVisibility(0);
                    } else {
                        ecVar.dZI.setVisibility(4);
                        ecVar.eeG.setVisibility(4);
                        ecVar.aSX.setVisibility(8);
                    }
                    ecVar.eeG.setData(sVar.getAuthor());
                    ecVar.eeG.setUserId(sVar.getAuthor().getUserId());
                    ecVar.eeG.ae(sVar.getAuthor().getUserName(), sVar.bfN());
                } else if (f(sVar)) {
                    if (this.dZp) {
                        ecVar.dZI.setVisibility(4);
                        ecVar.eeG.setVisibility(0);
                    }
                    ecVar.eeG.c(portrait, 28, false);
                    ecVar.eeG.setUserId(sVar.getAuthor().getUserId());
                    ecVar.eeG.ae(sVar.getAuthor().getUserName(), sVar.bfN());
                    ecVar.eeG.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.eiJ);
                } else {
                    if (this.dZp) {
                        ecVar.dZI.setVisibility(0);
                    }
                    ecVar.eeG.setVisibility(8);
                    ecVar.dZI.setUserId(sVar.getAuthor().getUserId());
                    ecVar.dZI.ae(sVar.getAuthor().getUserName(), sVar.bfN());
                    ecVar.dZI.setImageDrawable(null);
                    ecVar.dZI.c(portrait, 28, false);
                }
                ecVar.aPR.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                ecVar.aPR.setTag(u.g.tag_user_name, sVar.getAuthor().getUserName());
            }
            ecVar.dZQ.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_c));
            if (this.cwk) {
                ecVar.dZQ.setDefaultImageId(u.f.transparent_bg);
            } else {
                ecVar.dZQ.setDefaultImageId(u.f.icon_click);
            }
            ecVar.dZQ.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                avx = null;
            } else {
                avx = sVar.avx();
            }
            if (this.dZv || !this.dZw) {
                ecVar.dZQ.a(avx, false);
            } else {
                ecVar.dZQ.a(avx, true);
            }
            ecVar.dZQ.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10039));
            boolean z8 = false;
            boolean z9 = false;
            if (this.dYM.aHf() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = sVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.dYM != null && this.dYM.aGY() != null && this.dYM.aGY().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.dYM.aGY().getAuthor().getUserId();
                String userId5 = sVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = sVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (ecVar.eae != null) {
                            ecVar.eae.setVisibility(0);
                            ecVar.eae.setText(u.j.manage);
                            ecVar.eae.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (ecVar.eae != null) {
                            ecVar.eae.setVisibility(0);
                            ecVar.eae.setText(u.j.delete);
                            ecVar.eae.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (ecVar.eae != null) {
                        ecVar.eae.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.bfB() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(u.g.tag_should_manage_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dYM.aHf()));
                        sparseArray.put(u.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(u.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(u.g.tag_user_mute_visible, true);
                        sparseArray.put(u.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sVar.getAuthor() != null) {
                            sparseArray.put(u.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                            sparseArray.put(u.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                        }
                        if (this.dYM.aGY() != null) {
                            sparseArray.put(u.g.tag_user_mute_thread_id, this.dYM.aGY().getId());
                        }
                        sparseArray.put(u.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(u.g.tag_should_delete_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dYM.aHf()));
                        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(u.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        ecVar.dZP.setVisibility(8);
                        com.baidu.tbadk.core.util.av.c(ecVar.eac, u.d.common_color_10005, 1);
                        ecVar.eac.setText(String.format(this.mContext.getResources().getString(u.j.write_addition_update), sVar.bfC()));
                        if (ecVar.eae.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.av.c(ecVar.eae, u.d.cp_link_tip_c, 3);
                            sparseArray.put(u.g.tag_user_mute_visible, false);
                            ecVar.eae.setTag(sparseArray);
                            ecVar.eae.setOnClickListener(this.dZu);
                        }
                    }
                    bfM = sVar.bfM();
                    if (bfM.size() > 0 || (sVar.bfB() == 1 && this.eat.aHN().aLf())) {
                        ecVar.eeJ.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar = bfM.get(0);
                        if (!StringUtils.isNull(bVar.getIconUrl())) {
                            a(ecVar, bVar.getIconUrl());
                            if (!StringUtils.isNull(bVar.Az())) {
                                ecVar.eeJ.setTag(u.g.tag_pb_lottery_tail_link, bVar.Az());
                            }
                        } else {
                            ecVar.eeJ.setVisibility(8);
                        }
                    }
                    a(ecVar, sVar, sVar.bfB() != 1, avx);
                    b(ecVar);
                    a(z, sVar, ecVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = sVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (sVar.bfB() == 1) {
            }
            sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            bfM = sVar.bfM();
            if (bfM.size() > 0) {
            }
            ecVar.eeJ.setVisibility(8);
            a(ecVar, sVar, sVar.bfB() != 1, avx);
            b(ecVar);
            a(z, sVar, ecVar);
        }
    }

    private void a(boolean z, com.baidu.tieba.tbadkCore.data.s sVar, ec ecVar) {
        if (sVar.bfB() == 1 && this.dZq) {
            if (ecVar.eeP != null) {
                ecVar.eeP.setVisibility(8);
            }
        } else if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class) && EcommSwitchStatic.Fr()) {
            if (!z) {
                DealInfoData dealInfoData = sVar.dealInfoData;
                if (dealInfoData != null) {
                    PbReplyEcommCard aJP = ecVar.aJP();
                    aJP.setData(dealInfoData);
                    aJP.setVisibility(0);
                    aJP.aMt();
                } else if (ecVar.eeP != null) {
                    ecVar.eeP.setVisibility(8);
                }
            } else if (ecVar.eeP != null) {
                ecVar.eeP.setVisibility(8);
            }
        }
    }

    private void a(ec ecVar, String str) {
        ecVar.eeJ.setVisibility(0);
        com.baidu.adp.lib.g.c.dF().a(str, 17, new ea(this, ecVar, str), this.eat.getUniqueId());
    }

    private void b(ec ecVar) {
        ecVar.dZQ.setTextViewOnTouchListener(this.dYQ);
        ecVar.dZQ.setTextViewCheckSelection(true);
    }

    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aMg() == null) {
            ecVar.eap.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(sVar.aMg(), ecVar.eap, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1213=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int A = (((com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int dimensionPixelSize = getDimensionPixelSize(u.e.ds60);
        if (!z) {
            dimensionPixelSize = getDimensionPixelSize(u.e.ds98);
        } else if (z2) {
            dimensionPixelSize = 0;
        }
        int min = Math.min(A - dimensionPixelSize, this.dZo);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void a(ec ecVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.bfG() > 0 && sVar.bfA() != null) {
            ecVar.eab.setVisibility(0);
            ecVar.eab.removeViews(0, ecVar.eab.getChildCount() - 1);
            int size = sVar.bfA().size();
            int bfH = sVar.bfH();
            for (int i2 = 0; i2 < bfH; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.bfA().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, (ViewGroup) ecVar.eab, false);
                ec ecVar2 = new ec(inflate, this.dZp, this.cwk, this.dZo, true);
                c(ecVar2);
                a(ecVar2, sVar2, (View) ecVar.eab, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(u.g.tag_clip_board, sVar2);
                sparseArray.put(u.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.cwk) {
                    sparseArray.put(u.g.tag_richtext_bg, null);
                    ecVar2.dZQ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar2.dZQ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    ecVar2.dZQ.setLayoutParams(layoutParams);
                    ecVar2.dZQ.setPadding(0, 0, 0, 0);
                    ecVar.dZQ.gB(null);
                } else {
                    ecVar.dZQ.gB(sVar.getBimg_url());
                    ecVar2.dZQ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ecVar2.dZQ.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(u.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(u.e.ds36);
                    ecVar2.dZQ.setLayoutParams(layoutParams2);
                }
                ecVar.eab.addView(inflate, ecVar.eab.getChildCount() - 1);
            }
            if (bfH < size) {
                ecVar.eaf.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(ecVar.eah, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ecVar.eai, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ecVar.eag, u.d.cp_cont_f, 1);
                ecVar.eaf.setOnClickListener(new eb(this, bfH, size, sVar));
                return;
            }
            ecVar.eaf.setVisibility(8);
            return;
        }
        ecVar.eab.setVisibility(8);
    }

    private boolean f(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (sVar == null || sVar.getAuthor() == null || sVar.getAuthor().getGodUserData() == null || sVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void c(ec ecVar) {
        ecVar.dZD.setOnTouchListener(this.dYQ);
        ecVar.dZD.setOnLongClickListener(this.alj);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc;
        ecVar.aPR.setOnClickListener(aVar.eiJ);
        ecVar.dZP.setOnClickListener(this.baF);
        ecVar.dZI.setOnClickListener(aVar.eiJ);
        ecVar.dZU.setOnLongClickListener(this.alj);
        ecVar.dZQ.setOnLongClickListener(this.alj);
        ecVar.dZU.setOnTouchListener(this.dYQ);
        ecVar.dZQ.setOnTouchListener(this.dYQ);
        ecVar.dZQ.setOnImageClickListener(this.aGw);
        ecVar.dZQ.setOnEmotionClickListener(aVar.eiL);
        ecVar.bVj.setOnClickListener(aVar.bJt);
        ecVar.aeT.setOnClickListener(aVar.eiK);
        ecVar.eap.setOnClickListener(this.baF);
        ecVar.eeJ.setOnClickListener(this.baF);
        ecVar.eeF.setOnClickListener(this.baF);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.dYM = hVar;
    }

    public void nx(int i) {
        this.dZo = i;
    }

    public void hr(boolean z) {
        this.cwk = z;
    }

    public void hs(boolean z) {
        this.dZp = z;
    }

    public void ht(boolean z) {
        this.dZq = z;
    }

    public void hu(boolean z) {
        this.ecz = z;
    }

    public void ob(String str) {
        this.dZr = str;
    }

    public void I(View.OnClickListener onClickListener) {
        this.dZu = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.baF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGw = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dYQ = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alj = onLongClickListener;
    }

    public void hw(boolean z) {
        this.eaU = z;
    }
}
