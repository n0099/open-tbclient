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
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.view.PbReplyEcommCard;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dt extends cr<com.baidu.tieba.tbadkCore.data.s, eb> implements View.OnClickListener {
    private TbRichTextView.d aFF;
    private View.OnClickListener aZG;
    private View.OnLongClickListener aku;
    private ArrayList<IconData> bBy;
    protected boolean ctv;
    protected com.baidu.tieba.pb.data.h dMC;
    private com.baidu.tieba.pb.a.d dME;
    protected int dNb;
    protected boolean dNc;
    private boolean dNd;
    private String dNe;
    private com.baidu.tieba.pb.pb.sub.au dNf;
    private ArrayList<IconData> dNg;
    private View.OnClickListener dNh;
    private boolean dNi;
    private final boolean dNj;
    private int dNk;
    private int dNl;
    private boolean dOH;
    private boolean dQk;
    private boolean dSg;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dNb = 0;
        this.ctv = true;
        this.dNc = true;
        this.dNd = true;
        this.dMC = null;
        this.dNe = null;
        this.dNf = null;
        this.dNg = null;
        this.bBy = null;
        this.dNh = null;
        this.aZG = null;
        this.aFF = null;
        this.dME = null;
        this.aku = null;
        this.dNi = false;
        this.dNj = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.dQk = false;
        this.dSg = false;
        this.dOH = false;
        init();
    }

    private void init() {
        this.dNk = getDimensionPixelSize(u.e.ds30);
        this.dNl = com.baidu.adp.lib.util.k.A(this.mContext) - getDimensionPixelSize(u.e.ds60);
    }

    private void a(eb ebVar) {
        if (ebVar != null) {
            if (ebVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.av.l(ebVar.dNq, u.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.av.l(ebVar.dNr, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ebVar.dNs, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(ebVar.dSm, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ebVar.dNP, u.d.common_color_10005, 1);
                com.baidu.tbadk.core.util.av.c(ebVar.dNR, u.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.av.c(ebVar.aOX, u.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.av.c(ebVar.dNw, u.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c(ebVar.dNx, u.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c(ebVar.dNz, u.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ebVar.dNA, u.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(ebVar.dNC, u.f.btn_pb_more_btn_selector);
                com.baidu.tbadk.core.util.av.c(ebVar.dSo, u.f.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.av.l(ebVar.dNE, u.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.l(ebVar.dNF, u.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.c(ebVar.dNF, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ebVar.dNJ, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ebVar.dSq, u.f.btn_appdownload);
                com.baidu.tbadk.core.util.av.c(ebVar.dSq, u.d.cp_cont_i, 1);
                ebVar.dND.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10039));
            }
            ebVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public eb a(ViewGroup viewGroup) {
        eb ebVar = new eb(LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, viewGroup, false), this.dNc, this.ctv, this.dNb, false);
        a(ebVar);
        return ebVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cr, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, eb ebVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) ebVar);
        a(ebVar);
        c(ebVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) at(i);
        if (sVar2 != null) {
            a(ebVar, sVar2, view, false, i);
        }
        if (!this.dNi && this.dNj && ebVar != null && ebVar.dND.Hq() && (listView = ((PbActivity) this.dOg.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dNi = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v303, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:228:0x08b7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x08d9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x08e1  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0915  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x096e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x09a4  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0a23  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0e6f  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0e9f  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0eab  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0eb7  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0efb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(eb ebVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.a auL;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bcx;
        SparseArray sparseArray2;
        if (ebVar != null && sVar != null) {
            if (!z) {
                ebVar.dNM.setVisibility(0);
                ebVar.dNv.setTag(null);
                ebVar.dNv.setUserId(null);
                ebVar.aOX.setText((CharSequence) null);
                ebVar.dNx.setVisibility(8);
                ebVar.dNK.setVisibility(0);
                ebVar.dNC.setVisibility(0);
                ebVar.dNB.setVisibility(8);
                if (sVar.bco() == null) {
                    ebVar.dNL.setVisibility(8);
                } else if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && sVar.bco().AA() == 1) {
                    ebVar.dNL.changeSkinType(this.mSkinType);
                    ebVar.dNL.setVisibility(0);
                    ebVar.dNL.setData(sVar.bco());
                } else {
                    ebVar.dNL.setVisibility(8);
                }
                SparseArray sparseArray3 = (SparseArray) ebVar.dNH.getTag();
                if (sparseArray3 == null) {
                    SparseArray sparseArray4 = new SparseArray();
                    ebVar.dNH.setTag(sparseArray4);
                    ebVar.dND.setTag(sparseArray4);
                    ebVar.dNq.setTag(u.g.tag_from, sparseArray4);
                    sparseArray2 = sparseArray4;
                } else {
                    sparseArray2 = sparseArray3;
                }
                sparseArray2.put(u.g.tag_clip_board, sVar);
                sparseArray2.put(u.g.tag_is_subpb, false);
                ebVar.dND.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ebVar.dND.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                layoutParams.topMargin = getDimensionPixelSize(u.e.ds20);
                layoutParams.bottomMargin = getDimensionPixelSize(u.e.ds20);
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                if (!this.ctv) {
                    layoutParams.leftMargin = 0;
                    layoutParams.topMargin = 0;
                    ebVar.dND.setIsSupportVitality(true);
                } else if (TextUtils.isEmpty(sVar.getBimg_url())) {
                    this.dSg = false;
                    sparseArray2.put(u.g.tag_richtext_bg, null);
                    ebVar.dND.gC(null);
                    ebVar.dND.setBackgroundDrawable(null);
                    if (sVar.bcm() == 1) {
                        ebVar.dND.setIsSupportVitality(true);
                    } else {
                        ebVar.dND.setIsSupportVitality(false);
                    }
                } else {
                    this.dSg = true;
                    ebVar.dND.setIsSupportVitality(false);
                    if (sVar.bcm() == 1) {
                        layoutParams.leftMargin = getDimensionPixelSize(u.e.ds30);
                    } else {
                        layoutParams.leftMargin = 0;
                    }
                    layoutParams.rightMargin = getDimensionPixelSize(u.e.ds30);
                    sparseArray2.put(u.g.tag_richtext_bg, sVar.getBimg_url());
                    ebVar.dND.gC(sVar.getBimg_url());
                }
                ebVar.dND.setLayoutParams(layoutParams);
                if (sVar.bcm() != 1) {
                    if (TextUtils.isEmpty(sVar.getBimg_url())) {
                        ebVar.dND.setOnClickListener(this.aZG);
                        ebVar.dND.setTextViewOnClickListener(this.aZG);
                    } else {
                        ebVar.dND.setOnClickListener(null);
                        ebVar.dND.setTextViewOnClickListener(null);
                    }
                    ebVar.dNq.setOnClickListener(this.aZG);
                    ebVar.dNH.setOnClickListener(this.aZG);
                } else {
                    ebVar.dNq.setOnClickListener(null);
                    ebVar.dNH.setOnClickListener(null);
                }
                ebVar.dNA.setText(sVar.bcn());
                if (sVar.bcm() == 1) {
                    ebVar.dNq.setPadding(0, 0, 0, 0);
                    a(ebVar.dND, view, true, this.dSg);
                    ebVar.dNr.setVisibility(8);
                    ebVar.dNs.setVisibility(8);
                    ebVar.dNt.setVisibility(8);
                    ebVar.dNM.setVisibility(8);
                    ebVar.dNH.setVisibility(8);
                    ebVar.dNA.setVisibility(8);
                    ebVar.dNN.setVisibility(8);
                    ebVar.dNG.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    if (this.dMC != null && this.dMC.aDO() != null) {
                        ebVar.dNG.a(sVar.bcv(), str, j, com.baidu.adp.lib.h.b.c(this.dMC.aDO().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    }
                    ebVar.dNG.se();
                    if (this.dNd) {
                        PraiseData praiseData = null;
                        if (this.dMC != null && this.dMC.aDO() != null) {
                            this.dMC.aDO().getPraise();
                        }
                        if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                            ebVar.dNE.setVisibility(0);
                            ebVar.dNF.setVisibility(0);
                            ebVar.dNE.setIsFromPb(true);
                            ebVar.dNE.a(null, this.dMC.aDO().getId(), praiseData.getPostId(), true);
                            ebVar.dNE.cX(this.mSkinType);
                        } else {
                            ebVar.dNE.setVisibility(8);
                            ebVar.dNF.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.an(ebVar.dNE);
                        com.baidu.tieba.graffiti.d.an(ebVar.dNF);
                        com.baidu.tbadk.data.g bcp = sVar.bcp();
                        ebVar.dNZ.setVisibility(8);
                        if (bcp != null && !TextUtils.isEmpty(bcp.getName()) && !TextUtils.isEmpty(bcp.getName().trim())) {
                            String name = bcp.getName();
                            String lat = bcp.getLat();
                            String lng = bcp.getLng();
                            ebVar.dNW.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, ebVar.dNW, 0, 10, 0, 10);
                            ebVar.dNY.setText(bcp.getName());
                            com.baidu.tbadk.core.util.av.c(ebVar.dNY, u.d.cp_link_tip_c, 1);
                            com.baidu.tbadk.core.util.av.c(ebVar.dNX, u.f.icon_pb_pin);
                            ebVar.dNW.setOnClickListener(new du(this, lat, lng, name));
                        } else {
                            ebVar.dNX.setVisibility(8);
                            ebVar.dNY.setVisibility(8);
                        }
                        if (sVar.getAuthor() != null && sVar.getAuthor().getGodInfo() != null) {
                            ebVar.dNG.ib(false);
                            ViewGroup.LayoutParams layoutParams2 = ebVar.dNW.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.width = -2;
                                ebVar.dNW.setLayoutParams(layoutParams2);
                            }
                            ebVar.dNW.setVisibility(0);
                            View findViewWithTag = ebVar.dNW.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(u.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(u.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(u.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                ebVar.dNW.addView(textView, 0);
                            }
                            View findViewWithTag2 = ebVar.dNW.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(u.e.fontsize24));
                                com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_d, 1);
                                textView2.setText(sVar.bcn());
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(u.e.ds20), 0);
                                ebVar.dNW.addView(textView2, 1);
                            }
                            if (ebVar.dSn == null) {
                                ebVar.dNX.setVisibility(8);
                                ebVar.dNW.removeView(ebVar.dNY);
                                ebVar.dSn = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams3.addRule(11);
                                layoutParams3.addRule(15);
                                ebVar.dNY.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.icon_pb_pin), (Drawable) null, (Drawable) null, (Drawable) null);
                                ebVar.dSn.addView(ebVar.dNY, layoutParams3);
                                ebVar.dNW.addView(ebVar.dSn, new LinearLayout.LayoutParams(-1, -2));
                                if (bcp != null && !TextUtils.isEmpty(bcp.getName()) && !TextUtils.isEmpty(bcp.getName().trim())) {
                                    ebVar.dNY.setOnClickListener(new dv(this, bcp.getLat(), bcp.getLng(), bcp.getName()));
                                }
                            }
                            ebVar.dNW.setOnClickListener(null);
                        }
                    } else {
                        ebVar.dNE.setVisibility(8);
                        ebVar.dNF.setVisibility(8);
                        ebVar.dNW.setVisibility(8);
                        ebVar.dNZ.setVisibility(8);
                    }
                    if (this.dOg.aED().aHV()) {
                        ebVar.dND.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) ebVar.dNL.getLayoutParams()).leftMargin = getDimensionPixelSize(u.e.ds30);
                    if (this.dMC.aDO() != null && this.dMC.aDO().qR() != null) {
                        com.baidu.tbadk.core.data.bh qR = this.dMC.aDO().qR();
                        String activityUrl = qR.getActivityUrl();
                        String rN = qR.rN();
                        String rO = qR.rO();
                        if (!StringUtils.isNull(rO)) {
                            ebVar.dSq.setVisibility(0);
                            ebVar.dSq.setText(rO);
                            ebVar.dSq.setOnClickListener(new dw(this, activityUrl));
                            ebVar.dSr.setOnClickListener(new dx(this, activityUrl));
                            if (!StringUtils.isNull(rN)) {
                                ebVar.bFY.setVisibility(0);
                                ebVar.bFY.c(rN, 10, true);
                            }
                        } else {
                            return;
                        }
                    } else {
                        ebVar.dSq.setVisibility(8);
                        ebVar.bFY.setVisibility(8);
                    }
                    if (ebVar.dSv != null) {
                        ebVar.dSv.setVisibility(8);
                    }
                } else {
                    ebVar.dND.setVisibility(0);
                    a(ebVar.dND, view, false, this.dSg);
                    ebVar.dNt.setVisibility(0);
                    ebVar.dNN.setVisibility(0);
                    ebVar.dNq.setPadding(getDimensionPixelSize(u.e.ds30), 0, getDimensionPixelSize(u.e.ds30), 0);
                    ebVar.bFY.setVisibility(8);
                    ebVar.dSq.setVisibility(8);
                    if (this.dQk && i == 0) {
                        ebVar.dNr.setVisibility(8);
                        ebVar.dNs.setVisibility(8);
                    } else if (i == 1) {
                        if (!this.dOH && (sVar.getPraise() == null || !sVar.getPraise().isPriaseDataValid())) {
                            ebVar.dNr.setVisibility(0);
                        } else if (this.dQk || this.dNd) {
                            ebVar.dNr.setVisibility(0);
                        } else {
                            ebVar.dNr.setVisibility(8);
                        }
                        ebVar.dNs.setVisibility(8);
                    } else {
                        ebVar.dNr.setVisibility(0);
                        ebVar.dNs.setVisibility(8);
                        if (i == 2 && this.dOH) {
                            ebVar.dNr.setVisibility(8);
                        }
                    }
                    com.baidu.tbadk.data.g bcp2 = sVar.bcp();
                    ebVar.dNW.setVisibility(8);
                    if (bcp2 != null && !TextUtils.isEmpty(bcp2.getName()) && !TextUtils.isEmpty(bcp2.getName().trim())) {
                        String name2 = bcp2.getName();
                        String lat2 = bcp2.getLat();
                        String lng2 = bcp2.getLng();
                        ebVar.dNZ.setVisibility(0);
                        ebVar.dOb.setText(bcp2.getName());
                        com.baidu.tbadk.core.util.av.c(ebVar.dOb, u.d.cp_link_tip_c, 1);
                        com.baidu.tbadk.core.util.av.c(ebVar.dOa, u.f.icon_pb_pin);
                        ebVar.dNZ.setOnClickListener(new dy(this, lat2, lng2, name2));
                    } else {
                        ebVar.dNZ.setVisibility(8);
                    }
                    ebVar.dNG.setVisibility(8);
                    ((LinearLayout.LayoutParams) ebVar.dNL.getLayoutParams()).leftMargin = 0;
                    ebVar.dNE.setVisibility(8);
                    ebVar.dNF.setVisibility(8);
                    ebVar.dNH.setVisibility(0);
                    ebVar.dNM.setVisibility(0);
                    ebVar.dNA.setVisibility(0);
                    String format = String.format(this.mContext.getString(u.j.is_floor), Integer.valueOf(sVar.bcm()));
                    ebVar.dNz.setVisibility(0);
                    ebVar.dNz.setText(format);
                    if (ebVar.dSv != null) {
                        if (sVar.qZ() != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ebVar.dNM.getLayoutParams();
                            marginLayoutParams.topMargin = (int) this.dOg.getResources().getDimension(u.e.ds16);
                            ebVar.dNM.setLayoutParams(marginLayoutParams);
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ebVar.dSw.getLayoutParams();
                            marginLayoutParams2.topMargin = (int) this.dOg.getResources().getDimension(u.e.ds10);
                            ebVar.dSw.setLayoutParams(marginLayoutParams2);
                            ebVar.dNC.setPadding(ebVar.dNC.getPaddingLeft(), (int) this.dOg.getResources().getDimension(u.e.ds14), ebVar.dNC.getPaddingRight(), ebVar.dNC.getPaddingBottom());
                            ebVar.dNr.setVisibility(8);
                            ebVar.dNs.setVisibility(8);
                            ebVar.dSv.a(this.dOg.getPageContext(), sVar.qZ(), com.baidu.tieba.tbadkCore.d.a.a("PB", "c0132", this.dMC.aDN().getId(), this.dMC.aDN().getName(), this.dMC.aDO().getId(), null));
                            ebVar.dNq.setPadding(0, 0, 0, 0);
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) ebVar.dSz.getLayoutParams();
                            marginLayoutParams3.leftMargin = (int) this.dOg.getResources().getDimension(u.e.ds30);
                            marginLayoutParams3.rightMargin = (int) this.dOg.getResources().getDimension(u.e.ds30);
                            ebVar.dSz.setLayoutParams(marginLayoutParams3);
                        } else {
                            ebVar.dSv.a(null, null, null);
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) ebVar.dSz.getLayoutParams();
                            marginLayoutParams4.leftMargin = 0;
                            marginLayoutParams4.rightMargin = 0;
                            ebVar.dSz.setLayoutParams(marginLayoutParams4);
                        }
                    }
                }
                if (this.dNe != null && !this.dNe.equals("0") && this.dNe.equals(sVar.getAuthor().getUserId())) {
                    ebVar.dNB.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(ebVar.dNB, u.f.icon_floorhost);
                    ebVar.dNB.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                }
            } else {
                ebVar.dNM.setVisibility(8);
            }
            com.baidu.tbadk.core.util.av.k(ebVar.dNu, u.f.bg_floor_new_middle);
            ebVar.dND.setVideoImageId(u.f.pic_video);
            com.baidu.tbadk.core.util.av.c(ebVar.dNC, u.f.btn_pb_more_btn_selector);
            SparseArray sparseArray5 = (SparseArray) ebVar.dNC.getTag();
            if (sparseArray5 == null) {
                SparseArray sparseArray6 = new SparseArray();
                ebVar.dNC.setTag(sparseArray6);
                sparseArray = sparseArray6;
            } else {
                sparseArray = sparseArray5;
            }
            sparseArray.put(u.g.tag_clip_board, sVar);
            sparseArray.put(u.g.tag_load_sub_data, sVar);
            sparseArray.put(u.g.tag_load_sub_view, view);
            sparseArray.put(u.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(u.g.tag_pb_floor_number, Integer.valueOf(sVar.bcm()));
            SparseArray sparseArray7 = (SparseArray) ebVar.dSo.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                ebVar.dSo.setTag(sparseArray7);
            }
            sparseArray7.put(u.g.tag_clip_board, sVar);
            sparseArray7.put(u.g.tag_load_sub_data, sVar);
            sparseArray7.put(u.g.tag_load_sub_view, view);
            if (sVar.bcq() > 0) {
                if (this.dNf == null) {
                    this.dNf = new com.baidu.tieba.pb.pb.sub.au(this.mContext);
                    this.dNf.setIsFromCDN(this.mIsFromCDN);
                    this.dNf.J(this.dNh);
                    boolean z7 = false;
                    String userId2 = this.dMC.aDO().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.dNf.J(this.dMC.aDU(), z7);
                    this.dNf.p(this.dMC.aDO());
                    this.dNf.hh(this.dNc);
                }
                ebVar.dNK.setVisibility(0);
                ebVar.dNJ.setVisibility(0);
                ebVar.dNI.setVisibility(0);
                ebVar.dNK.a(sVar, view);
                ebVar.dNK.setChildOnClickListener(this.aZG);
                ebVar.dNK.setChildOnLongClickListener(this.aku);
                ebVar.dNK.setChildOnTouchListener(this.dME);
                ebVar.dNK.setSubPbAdapter(this.dNf);
                ebVar.dNK.setVisibility(0);
            } else {
                ebVar.dNK.setVisibility(8);
                ebVar.dNJ.setVisibility(8);
                ebVar.dNI.setVisibility(8);
            }
            a(ebVar, sVar, this.dMC.aDX(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.u.gx(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                    }
                    ebVar.aOX.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(ebVar.aOX, u.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(ebVar.aOX, u.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        ebVar.dNw.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(ebVar.dNw, BitmapHelper.getGradeResourceIdNew(level_id));
                        String bcz = sVar.bcz();
                        if (StringUtils.isNull(bcz)) {
                            bcz = String.format(TbadkCoreApplication.m9getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id));
                        }
                        ebVar.dNw.setContentDescription(bcz);
                        ebVar.dNw.setOnClickListener(null);
                    } else {
                        ebVar.dNw.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(ebVar.dNx, u.f.pb_manager);
                            ebVar.dNw.setVisibility(8);
                            ebVar.dNx.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(ebVar.dNx, u.f.pb_assist);
                            ebVar.dNw.setVisibility(8);
                            ebVar.dNx.setVisibility(0);
                        }
                        if (ebVar.dNx.getVisibility() == 0) {
                            ebVar.dNx.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        }
                    }
                    if (ebVar.dNw.getVisibility() == 0) {
                        ebVar.dNw.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(ebVar.dNy, u.f.icon_pb_pop_girl);
                        ebVar.dNy.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(ebVar.dNy, u.f.icon_pb_pop_boy);
                        ebVar.dNy.setVisibility(0);
                    } else {
                        ebVar.dNy.setVisibility(8);
                    }
                    if (ebVar.dNy.getVisibility() == 0) {
                        ebVar.dNy.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (com.baidu.tbadk.util.u.gx(sVar.getAuthor().getName_show()) >= 14 && ebVar.dNw.getVisibility() == 0 && ebVar.dNB.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.dNg = sVar.getAuthor().getIconInfo();
                    this.bBy = sVar.getAuthor().getTShowInfoNew();
                    if (ebVar.bTj != null) {
                        ebVar.bTj.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                        ebVar.bTj.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.bHY);
                        ebVar.bTj.vy();
                        ebVar.bTj.a(this.dNg, i2, getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds10));
                    }
                    if (ebVar.aef != null) {
                        ebVar.aef.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.dWh);
                        if (this.bBy != null && this.bBy.size() > 0 && this.bBy.get(0) != null) {
                            ebVar.aef.setTag(this.bBy.get(0).getUrl());
                        }
                        ebVar.aef.a(this.bBy, 3, getDimensionPixelSize(u.e.ds36), getDimensionPixelSize(u.e.ds36), getDimensionPixelSize(u.e.ds8), true);
                    }
                }
                if (e(sVar)) {
                    if (this.dNc) {
                        ebVar.dNv.setVisibility(4);
                        ebVar.dSp.setVisibility(0);
                    }
                    ebVar.dSp.c(portrait, 28, false);
                    ebVar.dSp.setUserId(sVar.getAuthor().getUserId());
                    ebVar.dSp.ae(sVar.getAuthor().getUserName(), sVar.bcy());
                    ebVar.dSp.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.dWg);
                } else {
                    if (this.dNc) {
                        ebVar.dNv.setVisibility(0);
                    }
                    ebVar.dSp.setVisibility(8);
                    ebVar.dNv.setUserId(sVar.getAuthor().getUserId());
                    ebVar.dNv.ae(sVar.getAuthor().getUserName(), sVar.bcy());
                    ebVar.dNv.setImageDrawable(null);
                    ebVar.dNv.c(portrait, 28, false);
                }
                ebVar.aOX.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                ebVar.aOX.setTag(u.g.tag_user_name, sVar.getAuthor().getUserName());
            }
            ebVar.dND.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_c));
            if (this.ctv) {
                ebVar.dND.setDefaultImageId(u.f.transparent_bg);
            } else {
                ebVar.dND.setDefaultImageId(u.f.icon_click);
            }
            ebVar.dND.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                auL = null;
            } else {
                auL = sVar.auL();
            }
            if (this.dNi || !this.dNj) {
                ebVar.dND.a(auL, false);
            } else {
                ebVar.dND.a(auL, true);
            }
            ebVar.dND.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10039));
            boolean z8 = false;
            boolean z9 = false;
            if (this.dMC.aDU() != 0) {
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
            if (this.dMC != null && this.dMC.aDO() != null && this.dMC.aDO().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.dMC.aDO().getAuthor().getUserId();
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
                        if (ebVar.dNR != null) {
                            ebVar.dNR.setVisibility(0);
                            ebVar.dNR.setText(u.j.manage);
                            ebVar.dNR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (ebVar.dNR != null) {
                            ebVar.dNR.setVisibility(0);
                            ebVar.dNR.setText(u.j.delete);
                            ebVar.dNR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (ebVar.dNR != null) {
                        ebVar.dNR.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.bcm() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(u.g.tag_should_manage_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dMC.aDU()));
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
                        if (this.dMC.aDO() != null) {
                            sparseArray.put(u.g.tag_user_mute_thread_id, this.dMC.aDO().getId());
                        }
                        sparseArray.put(u.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(u.g.tag_should_delete_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dMC.aDU()));
                        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(u.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        ebVar.dNC.setVisibility(8);
                        com.baidu.tbadk.core.util.av.c(ebVar.dNP, u.d.common_color_10005, 1);
                        ebVar.dNP.setText(String.format(this.mContext.getResources().getString(u.j.write_addition_update), sVar.bcn()));
                        if (ebVar.dNR.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.av.c(ebVar.dNR, u.d.cp_link_tip_c, 3);
                            sparseArray.put(u.g.tag_user_mute_visible, false);
                            ebVar.dNR.setTag(sparseArray);
                            ebVar.dNR.setOnClickListener(this.dNh);
                        }
                    }
                    bcx = sVar.bcx();
                    if (bcx.size() > 0 || (sVar.bcm() == 1 && this.dOg.aED().aHV())) {
                        ebVar.dSs.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar = bcx.get(0);
                        if (!StringUtils.isNull(bVar.getIconUrl())) {
                            a(ebVar, bVar.getIconUrl());
                            if (!StringUtils.isNull(bVar.Az())) {
                                ebVar.dSs.setTag(u.g.tag_pb_lottery_tail_link, bVar.Az());
                            }
                        } else {
                            ebVar.dSs.setVisibility(8);
                        }
                    }
                    a(ebVar, sVar, sVar.bcm() != 1, auL);
                    b(ebVar);
                    a(z, sVar, ebVar);
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
            if (sVar.bcm() == 1) {
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
            bcx = sVar.bcx();
            if (bcx.size() > 0) {
            }
            ebVar.dSs.setVisibility(8);
            a(ebVar, sVar, sVar.bcm() != 1, auL);
            b(ebVar);
            a(z, sVar, ebVar);
        }
    }

    private void a(boolean z, com.baidu.tieba.tbadkCore.data.s sVar, eb ebVar) {
        if (sVar.bcm() == 1 && this.dNd) {
            if (ebVar.dSy != null) {
                ebVar.dSy.setVisibility(8);
            }
        } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class) && EcommSwitchStatic.Fq()) {
            if (!z) {
                DealInfoData dealInfoData = sVar.dealInfoData;
                if (dealInfoData != null) {
                    PbReplyEcommCard aGC = ebVar.aGC();
                    aGC.setData(dealInfoData);
                    aGC.setVisibility(0);
                    aGC.aJi();
                } else if (ebVar.dSy != null) {
                    ebVar.dSy.setVisibility(8);
                }
            } else if (ebVar.dSy != null) {
                ebVar.dSy.setVisibility(8);
            }
        }
    }

    private void a(eb ebVar, String str) {
        ebVar.dSs.setVisibility(0);
        com.baidu.adp.lib.g.c.dG().a(str, 17, new dz(this, ebVar, str), this.dOg.getUniqueId());
    }

    private void b(eb ebVar) {
        ebVar.dND.setTextViewOnTouchListener(this.dME);
        ebVar.dND.setTextViewCheckSelection(true);
    }

    private void a(eb ebVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aIV() == null) {
            ebVar.dOc.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(sVar.aIV(), ebVar.dOc, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1180=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int A = (((com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int dimensionPixelSize = getDimensionPixelSize(u.e.ds60);
        if (!z) {
            dimensionPixelSize = getDimensionPixelSize(u.e.ds98);
        } else if (z2) {
            dimensionPixelSize = 0;
        }
        int min = Math.min(A - dimensionPixelSize, this.dNb);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void a(eb ebVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.bcr() > 0 && sVar.bcl() != null) {
            ebVar.dNO.setVisibility(0);
            ebVar.dNO.removeViews(0, ebVar.dNO.getChildCount() - 1);
            int size = sVar.bcl().size();
            int bcs = sVar.bcs();
            for (int i2 = 0; i2 < bcs; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.bcl().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, (ViewGroup) ebVar.dNO, false);
                eb ebVar2 = new eb(inflate, this.dNc, this.ctv, this.dNb, true);
                c(ebVar2);
                a(ebVar2, sVar2, (View) ebVar.dNO, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(u.g.tag_clip_board, sVar2);
                sparseArray.put(u.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.ctv) {
                    sparseArray.put(u.g.tag_richtext_bg, null);
                    ebVar2.dND.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ebVar2.dND.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    ebVar2.dND.setLayoutParams(layoutParams);
                    ebVar2.dND.setPadding(0, 0, 0, 0);
                    ebVar.dND.gC(null);
                } else {
                    ebVar.dND.gC(sVar.getBimg_url());
                    ebVar2.dND.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ebVar2.dND.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(u.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(u.e.ds36);
                    ebVar2.dND.setLayoutParams(layoutParams2);
                }
                ebVar.dNO.addView(inflate, ebVar.dNO.getChildCount() - 1);
            }
            if (bcs < size) {
                ebVar.dNS.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(ebVar.dNU, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(ebVar.dNV, u.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(ebVar.dNT, u.d.cp_cont_f, 1);
                ebVar.dNS.setOnClickListener(new ea(this, bcs, size, sVar));
                return;
            }
            ebVar.dNS.setVisibility(8);
            return;
        }
        ebVar.dNO.setVisibility(8);
    }

    private boolean e(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (sVar == null || sVar.getAuthor() == null || sVar.getAuthor().getGodUserData() == null || sVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void c(eb ebVar) {
        ebVar.dNq.setOnTouchListener(this.dME);
        ebVar.dNq.setOnLongClickListener(this.aku);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP;
        ebVar.aOX.setOnClickListener(aVar.dWg);
        ebVar.dNC.setOnClickListener(this.aZG);
        ebVar.dNv.setOnClickListener(aVar.dWg);
        ebVar.dNH.setOnLongClickListener(this.aku);
        ebVar.dND.setOnLongClickListener(this.aku);
        ebVar.dNH.setOnTouchListener(this.dME);
        ebVar.dND.setOnTouchListener(this.dME);
        ebVar.dND.setOnImageClickListener(this.aFF);
        ebVar.dND.setOnEmotionClickListener(aVar.dWi);
        ebVar.bTj.setOnClickListener(aVar.bHY);
        ebVar.aef.setOnClickListener(aVar.dWh);
        ebVar.dOc.setOnClickListener(this.aZG);
        ebVar.dSs.setOnClickListener(this.aZG);
        ebVar.dSo.setOnClickListener(this.aZG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.dMC = hVar;
    }

    public void nf(int i) {
        this.dNb = i;
    }

    public void hg(boolean z) {
        this.ctv = z;
    }

    public void hh(boolean z) {
        this.dNc = z;
    }

    public void hi(boolean z) {
        this.dNd = z;
    }

    public void hj(boolean z) {
        this.dQk = z;
    }

    public void nq(String str) {
        this.dNe = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dNh = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZG = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFF = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dME = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aku = onLongClickListener;
    }

    public void hl(boolean z) {
        this.dOH = z;
    }
}
