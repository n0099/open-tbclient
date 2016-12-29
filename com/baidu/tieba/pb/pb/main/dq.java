package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dq extends cs<com.baidu.tieba.tbadkCore.data.q, dw> implements View.OnClickListener {
    private TbRichTextView.e aJq;
    private boolean adS;
    private View.OnLongClickListener aou;
    private ArrayList<IconData> cNP;
    private View.OnClickListener cjr;
    protected boolean ctc;
    protected int dXB;
    private boolean dXC;
    private String dXD;
    private com.baidu.tieba.pb.pb.sub.ba dXE;
    private ArrayList<IconData> dXF;
    private View.OnClickListener dXG;
    private boolean dXH;
    private final boolean dXI;
    private int dXJ;
    private int dXK;
    protected com.baidu.tieba.pb.data.f dXl;
    private com.baidu.tieba.pb.a.d dXp;
    private boolean dZc;
    private boolean eaN;
    private TbRichTextView.b ede;
    private boolean edf;

    private void init() {
        this.dXJ = getDimensionPixelSize(r.e.ds30);
        this.dXK = com.baidu.adp.lib.util.k.I(this.mContext) - getDimensionPixelSize(r.e.ds60);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dXB = 0;
        this.ctc = true;
        this.dXC = true;
        this.dXl = null;
        this.dXD = null;
        this.dXE = null;
        this.dXF = null;
        this.cNP = null;
        this.dXG = null;
        this.cjr = null;
        this.aJq = null;
        this.dXp = null;
        this.aou = null;
        this.ede = null;
        this.dXH = false;
        this.dXI = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eaN = false;
        this.edf = false;
        this.dZc = false;
        this.adS = false;
        init();
    }

    private void a(dw dwVar) {
        if (dwVar != null) {
            if (dwVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ar.l(dwVar.dXQ, r.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.ar.l(dwVar.dYi, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.c(dwVar.bbH, r.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ar.c((View) dwVar.dXV, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ar.c((View) dwVar.dXW, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ar.c(dwVar.dXX, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ar.c(dwVar.dXY, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ar.k(dwVar.edt, r.f.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.ar.c(dwVar.edt, r.f.icon_pb_more_n);
                com.baidu.tbadk.core.util.ar.l(dwVar.dYb, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ar.l(dwVar.dYc, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ar.c(dwVar.dYc, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.k(dwVar.edw, r.f.btn_appdownload);
                com.baidu.tbadk.core.util.ar.c(dwVar.edw, r.d.cp_cont_i, 1);
                dwVar.dYa.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10039));
                com.baidu.tbadk.core.util.ar.c(dwVar.dYv, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ar.c(dwVar.dYu, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ar.c(dwVar.dYt, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ar.c(dwVar.dYs, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ar.k(dwVar.dXS, r.f.bg_floor_new_middle);
                com.baidu.tbadk.core.util.ar.l(dwVar.dYf, r.d.cp_bg_line_e);
                c(dwVar);
            }
            dwVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public dw a(ViewGroup viewGroup) {
        dw dwVar = new dw(this.dYB.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, viewGroup, false), this.ctc, this.dXB);
        a(dwVar);
        return dwVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, dw dwVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) dwVar);
        a(dwVar);
        e(dwVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aK(i);
        if (qVar2 != null) {
            qVar2.sB();
            a(dwVar, qVar2, view, i);
        }
        if (!this.dXH && this.dXI && dwVar != null && dwVar.dYa.Il() && (listView = ((PbActivity) this.dYB.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dXH = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private boolean nL(int i) {
        if (aK(0) instanceof com.baidu.tieba.tbadkCore.data.q) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) aK(0);
            if (qVar.bga() == 1 && i == 1) {
                return true;
            }
            return qVar.bga() != 1 && i == 0;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v59, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:226:0x07e2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0df7  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0e03  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0e0f  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0e53  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(dw dwVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, int i) {
        SparseArray sparseArray;
        UserTbVipInfoData userTbVipInfoData;
        com.baidu.tbadk.widget.richText.a avP;
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<com.baidu.tbadk.data.b> bgj;
        int i2;
        if (dwVar != null && qVar != null) {
            dwVar.dYg.setVisibility(0);
            dwVar.dXU.setTag(null);
            dwVar.dXU.setUserId(null);
            dwVar.bbH.setText((CharSequence) null);
            dwVar.dXW.setVisibility(8);
            dwVar.dYf.setVisibility(0);
            dwVar.dXZ.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) dwVar.dYe.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                dwVar.dYe.setTag(sparseArray3);
                dwVar.dYa.setTag(sparseArray3);
                dwVar.dXQ.setTag(r.g.tag_from, sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_is_subpb, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dwVar.dYa.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            dwVar.dYa.setPadding(0, 0, 0, 0);
            if (!this.ctc) {
                if (qVar.bga() == 1) {
                    dwVar.dYa.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
                    dwVar.dYa.setIsSupportVitality(false);
                }
            } else if (TextUtils.isEmpty(qVar.getBimg_url())) {
                this.edf = false;
                sparseArray.put(r.g.tag_richtext_bg, null);
                dwVar.dYa.gD(null);
                dwVar.dYa.setBackgroundDrawable(null);
                if (qVar.bga() == 1) {
                    dwVar.dYa.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
                    dwVar.dYa.setIsSupportVitality(false);
                }
            } else {
                this.edf = true;
                dwVar.dYa.setIsSupportVitality(false);
                if (qVar.bga() == 1) {
                    layoutParams.leftMargin = getDimensionPixelSize(r.e.ds30);
                } else {
                    layoutParams.leftMargin = 0;
                }
                layoutParams.rightMargin = getDimensionPixelSize(r.e.ds30);
                if (qVar.aNF() == null) {
                    layoutParams.bottomMargin = getDimensionPixelSize(r.e.ds24);
                } else {
                    layoutParams.bottomMargin = getDimensionPixelSize(r.e.ds32);
                }
                layoutParams.topMargin = getDimensionPixelSize(r.e.ds24);
                sparseArray.put(r.g.tag_richtext_bg, qVar.getBimg_url());
                dwVar.dYa.gD(qVar.getBimg_url());
            }
            dwVar.dYa.setLayoutParams(layoutParams);
            if (qVar.bga() != 1) {
                if (TextUtils.isEmpty(qVar.getBimg_url())) {
                    dwVar.dYa.setOnClickListener(this.cjr);
                    dwVar.dYa.setTextViewOnClickListener(this.cjr);
                } else {
                    dwVar.dYa.setOnClickListener(null);
                    dwVar.dYa.setTextViewOnClickListener(null);
                }
                dwVar.dXQ.setOnClickListener(this.cjr);
                dwVar.dYe.setOnClickListener(this.cjr);
            } else {
                dwVar.dXQ.setOnClickListener(null);
                dwVar.dYe.setOnClickListener(null);
            }
            dwVar.dXY.setText(qVar.bgc());
            if (qVar.bga() == 1) {
                a(dwVar.dYa, view, true, this.edf);
                dwVar.dYi.setVisibility(8);
                dwVar.dXR.setVisibility(8);
                dwVar.dYg.setVisibility(8);
                dwVar.dYe.setVisibility(8);
                dwVar.dXY.setVisibility(8);
                dwVar.dYh.setVisibility(8);
                dwVar.dYx.setVisibility(8);
                dwVar.dYd.setVisibility(0);
                String str = null;
                long j = 0;
                if (qVar.getAuthor() != null) {
                    j = qVar.getAuthor().getUserIdLong();
                    str = qVar.getAuthor().getUserName();
                }
                if (this.dXl != null && this.dXl.aIl() != null) {
                    dwVar.dYd.a(qVar.bgh(), str, j, com.baidu.adp.lib.h.b.c(this.dXl.aIl().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                }
                dwVar.dYd.tm();
                if (this.dXC) {
                    PraiseData praiseData = null;
                    if (this.dXl != null && this.dXl.aIl() != null) {
                        this.dXl.aIl().rv();
                    }
                    if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                        dwVar.dYb.setVisibility(0);
                        dwVar.dYc.setVisibility(0);
                        dwVar.dYb.setIsFromPb(true);
                        dwVar.dYb.a(null, this.dXl.aIl().getId(), praiseData.getPostId(), true);
                        dwVar.dYb.m24do(this.mSkinType);
                    } else {
                        dwVar.dYb.setVisibility(8);
                        dwVar.dYc.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.d.ak(dwVar.dYb);
                    com.baidu.tieba.graffiti.d.ak(dwVar.dYc);
                    dwVar.dYr.setVisibility(0);
                    dwVar.dYt.setText(qVar.bgc());
                    com.baidu.tbadk.data.g bgd = qVar.bgd();
                    dwVar.dYv.setVisibility(8);
                    if (bgd != null && !TextUtils.isEmpty(bgd.getName()) && !TextUtils.isEmpty(bgd.getName().trim())) {
                        String name = bgd.getName();
                        String lat = bgd.getLat();
                        String lng = bgd.getLng();
                        dwVar.dYu.setVisibility(0);
                        com.baidu.adp.lib.util.k.a(this.mContext, dwVar.dYu, 0, 10, 0, 10);
                        dwVar.dYu.setText(bgd.getName());
                        dwVar.dYu.setOnClickListener(new dr(this, lat, lng, name));
                    } else {
                        dwVar.dYu.setVisibility(8);
                    }
                    if (this.dXl.aIA() != null && !StringUtils.isNull(this.dXl.aIA().pS(), true)) {
                        b(dwVar);
                    }
                } else {
                    dwVar.dYb.setVisibility(8);
                    dwVar.dYc.setVisibility(8);
                    if (qVar.getAuthor() != null && qVar.getAuthor().getGodInfo() != null) {
                        dwVar.dYd.iW(false);
                    } else {
                        dwVar.dYb.setVisibility(8);
                        dwVar.dYc.setVisibility(8);
                        dwVar.dYu.setVisibility(8);
                        dwVar.dYv.setVisibility(8);
                    }
                    if (this.dXl.aIA() != null && !StringUtils.isNull(this.dXl.aIA().pS(), true) && dwVar.edl != null) {
                        dwVar.edl.setVisibility(8);
                        dwVar.edq.DU();
                    }
                }
                if (this.dYB.aJb().aMt()) {
                    dwVar.dYa.setVisibility(8);
                }
                if (this.dXl.aIl() != null && this.dXl.aIl().rR() != null) {
                    com.baidu.tbadk.core.data.bp rR = this.dXl.aIl().rR();
                    String activityUrl = rR.getActivityUrl();
                    String sV = rR.sV();
                    String sW = rR.sW();
                    if (!StringUtils.isNull(sW)) {
                        dwVar.edw.setVisibility(0);
                        dwVar.edw.setText(sW);
                        dwVar.edw.setOnClickListener(new ds(this, activityUrl));
                        dwVar.edx.setOnClickListener(new dt(this, activityUrl));
                        if (!StringUtils.isNull(sV)) {
                            dwVar.bAR.setVisibility(0);
                            dwVar.bAR.c(sV, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    dwVar.edw.setVisibility(8);
                    dwVar.bAR.setVisibility(8);
                }
                if (dwVar.edB != null) {
                    dwVar.edB.setVisibility(8);
                }
                if (this.dXl != null && this.dXl.aIl() != null && this.dXl.aIl().sq()) {
                    dwVar.edE.bKs.setVisibility(0);
                    dwVar.edE.b(this.dXl);
                    dwVar.edE.onChangeSkinType(this.mSkinType);
                    dwVar.edE.d(qVar.HH());
                } else {
                    dwVar.edE.bKs.setVisibility(8);
                }
            } else {
                if (this.dXl.aIA() != null && !StringUtils.isNull(this.dXl.aIA().pS(), true) && dwVar.edl != null) {
                    dwVar.edl.setVisibility(8);
                }
                dwVar.dYa.setVisibility(0);
                a(dwVar.dYa, view, false, this.edf);
                dwVar.dXR.setVisibility(0);
                dwVar.dYh.setVisibility(0);
                dwVar.bAR.setVisibility(8);
                dwVar.edw.setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = dwVar.dYi.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) dwVar.dYg.getLayoutParams();
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) dwVar.dYe.getLayoutParams();
                if (nL(i)) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds20);
                    layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                    layoutParams4.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds6);
                } else {
                    layoutParams4.topMargin = 0;
                    layoutParams3.topMargin = 0;
                    layoutParams2.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds1);
                }
                dwVar.dYg.setLayoutParams(layoutParams3);
                dwVar.dYe.setLayoutParams(layoutParams4);
                dwVar.dYi.setLayoutParams(layoutParams2);
                dwVar.dYi.setVisibility(0);
                dwVar.dYd.setVisibility(8);
                dwVar.dYb.setVisibility(8);
                dwVar.dYc.setVisibility(8);
                dwVar.dYe.setVisibility(0);
                dwVar.dYg.setVisibility(0);
                dwVar.dXY.setVisibility(0);
                com.baidu.tbadk.data.g bgd2 = qVar.bgd();
                dwVar.dYr.setVisibility(8);
                if (bgd2 != null && !TextUtils.isEmpty(bgd2.getName()) && !TextUtils.isEmpty(bgd2.getName().trim())) {
                    String name2 = bgd2.getName();
                    String lat2 = bgd2.getLat();
                    String lng2 = bgd2.getLng();
                    dwVar.dYv.setVisibility(0);
                    dwVar.dYv.setText(bgd2.getName());
                    dwVar.dYv.setOnClickListener(new du(this, lat2, lng2, name2));
                } else {
                    dwVar.dYv.setVisibility(8);
                }
                String format = String.format(this.mContext.getString(r.j.is_floor), Integer.valueOf(qVar.bga()));
                dwVar.dXX.setVisibility(0);
                dwVar.dXX.setText(format);
                if (dwVar.edB != null) {
                    if (qVar.rZ() != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) dwVar.dYg.getLayoutParams();
                        marginLayoutParams.topMargin = (int) this.dYB.getResources().getDimension(r.e.ds16);
                        dwVar.dYg.setLayoutParams(marginLayoutParams);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) dwVar.edC.getLayoutParams();
                        marginLayoutParams2.topMargin = (int) this.dYB.getResources().getDimension(r.e.ds10);
                        dwVar.edC.setLayoutParams(marginLayoutParams2);
                        dwVar.edB.a(this.dYB.getPageContext(), qVar.rZ(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", this.dXl.aIk().getId(), this.dXl.aIk().getName(), this.dXl.aIl().getId(), null));
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) dwVar.edD.getLayoutParams();
                        marginLayoutParams3.leftMargin = (int) this.dYB.getResources().getDimension(r.e.ds30);
                        marginLayoutParams3.rightMargin = (int) this.dYB.getResources().getDimension(r.e.ds30);
                        dwVar.edD.setLayoutParams(marginLayoutParams3);
                    } else {
                        dwVar.edB.a(null, null, null);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) dwVar.edD.getLayoutParams();
                        marginLayoutParams4.leftMargin = 0;
                        marginLayoutParams4.rightMargin = 0;
                        dwVar.edD.setLayoutParams(marginLayoutParams4);
                    }
                }
            }
            if (this.dXD != null && !this.dXD.equals("0") && this.dXD.equals(qVar.getAuthor().getUserId())) {
                dwVar.dXZ.setVisibility(0);
                com.baidu.tbadk.core.util.ar.j((View) dwVar.dXZ, r.d.cp_link_tip_a);
            } else {
                dwVar.dXZ.setVisibility(8);
            }
            dwVar.dYa.setVideoImageId(r.f.pic_video);
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(r.g.tag_clip_board, qVar);
            sparseArray4.put(r.g.tag_load_sub_data, qVar);
            sparseArray4.put(r.g.tag_load_sub_view, view);
            sparseArray4.put(r.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray4.put(r.g.tag_pb_floor_number, Integer.valueOf(qVar.bga()));
            dwVar.edt.setTag(sparseArray4);
            dwVar.edu.setTag(sparseArray4);
            if (qVar.bge() > 0 && qVar.bfX() != null && qVar.bfX().size() > 0) {
                if (this.dXE == null) {
                    this.dXE = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.dXE.setIsFromCDN(this.mIsFromCDN);
                    this.dXE.G(this.dXG);
                    boolean z4 = false;
                    String userId = this.dXl.aIl().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z4 = true;
                    }
                    this.dXE.B(this.dXl.aIu(), z4);
                    this.dXE.h(this.dXl.aIl());
                }
                this.dXE.on(qVar.getId());
                dwVar.dYf.setVisibility(0);
                dwVar.dYf.a(qVar, view);
                dwVar.dYf.setChildOnClickListener(this.cjr);
                dwVar.dYf.setChildOnLongClickListener(this.aou);
                dwVar.dYf.setChildOnTouchListener(this.dXp);
                dwVar.dYf.setSubPbAdapter(this.dXE);
                dwVar.dYf.setVisibility(0);
                dwVar.dYx.setVisibility(0);
                dwVar.dYx.invalidate();
                dwVar.dYh.setPadding(0, 0, 0, 0);
            } else {
                dwVar.dYh.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds26));
                dwVar.dYf.setVisibility(8);
                dwVar.dYx.setVisibility(8);
            }
            String portrait = qVar.getAuthor().getPortrait();
            if (qVar.getAuthor() != null) {
                String name_show = qVar.getAuthor().getName_show();
                int gy = com.baidu.tbadk.util.u.gy(name_show);
                if (!StringUtils.isNull(qVar.getAuthor().getSealPrefix())) {
                    if (gy > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 12)) + "...";
                    }
                } else if (gy > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (!StringUtils.isNull(qVar.getAuthor().getSealPrefix())) {
                    dwVar.bbH.setText(ag(qVar.getAuthor().getSealPrefix(), name_show));
                } else {
                    dwVar.bbH.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.ar.c(dwVar.bbH, r.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ar.c(dwVar.bbH, r.d.cp_cont_f, 1);
                }
                int level_id = qVar.getAuthor().getLevel_id();
                int is_bawu = qVar.getAuthor().getIs_bawu();
                String bawu_type = qVar.getAuthor().getBawu_type();
                if (level_id != 0) {
                    dwVar.dXV.setVisibility(0);
                    com.baidu.tbadk.core.util.ar.c(dwVar.dXV, BitmapHelper.getGradeResourceIdNew(level_id));
                    String bgl = qVar.bgl();
                    if (StringUtils.isNull(bgl)) {
                        bgl = String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id));
                    }
                    dwVar.dXV.setContentDescription(bgl);
                    dwVar.dXV.setOnClickListener(null);
                } else {
                    dwVar.dXV.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ar.c(dwVar.dXW, r.f.pb_manager);
                        dwVar.dXV.setVisibility(8);
                        dwVar.dXW.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ar.c(dwVar.dXW, r.f.pb_assist);
                        dwVar.dXV.setVisibility(8);
                        dwVar.dXW.setVisibility(0);
                    }
                    if (dwVar.dXW.getVisibility() == 0) {
                        dwVar.dXW.setAlpha(179);
                    }
                }
                if (dwVar.dXV.getVisibility() == 0) {
                    dwVar.dXV.setAlpha(179);
                }
                int gy2 = com.baidu.tbadk.util.u.gy(qVar.getAuthor().getName_show());
                if (gy2 < 14 || dwVar.dXV.getVisibility() != 0 || dwVar.dXZ.getVisibility() != 0) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                int i3 = (StringUtils.isNull(qVar.getAuthor().getSealPrefix()) || gy2 < 12 || dwVar.dXV.getVisibility() != 0 || dwVar.dXZ.getVisibility() != 0) ? i2 : i2 - 1;
                this.dXF = qVar.getAuthor().getIconInfo();
                this.cNP = qVar.getAuthor().getTShowInfoNew();
                if (dwVar.bQG != null) {
                    if (com.baidu.tbadk.core.util.x.t(this.dXF)) {
                        dwVar.bQG.setVisibility(8);
                    } else {
                        dwVar.bQG.setVisibility(0);
                    }
                    dwVar.bQG.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                    dwVar.bQG.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.bJq);
                    dwVar.bQG.wD();
                    dwVar.bQG.a(this.dXF, i3, getDimensionPixelSize(r.e.ds24), getDimensionPixelSize(r.e.ds24), getDimensionPixelSize(r.e.ds10));
                }
                if (dwVar.ahx != null) {
                    dwVar.ahx.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehq);
                    if (this.cNP != null && this.cNP.size() > 0 && this.cNP.get(0) != null) {
                        dwVar.ahx.setTag(this.cNP.get(0).getUrl());
                    }
                    dwVar.ahx.a(this.cNP, 3, getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds8), true);
                }
            }
            if (qVar.getAuthor() == null || qVar.getAuthor().getUserTbVipInfoData() == null) {
                userTbVipInfoData = null;
            } else {
                userTbVipInfoData = qVar.getAuthor().getUserTbVipInfoData();
            }
            if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().pS())) {
                dwVar.dXU.setVisibility(4);
                dwVar.edv.setVisibility(8);
                dwVar.dXT.setVisibility(0);
                dwVar.edv.setVisibility(8);
                dwVar.dXT.getHeadView().setUserId(qVar.getAuthor().getUserId());
                dwVar.dXT.getHeadView().ae(qVar.getAuthor().getUserName(), qVar.bgk());
                dwVar.dXT.getHeadView().setImageDrawable(null);
                dwVar.dXT.getHeadView().c(portrait, 28, false);
                dwVar.dXT.dW(qVar.getAuthor().getPendantData().pS());
                dwVar.dXT.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                dwVar.dXT.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                if (dwVar.baW != null) {
                    if (dwVar.baX == null) {
                        dwVar.baW.inflate();
                        dwVar.baX = (TbImageView) dwVar.getView().findViewById(r.g.user_head_mask);
                    }
                    if (dwVar.baX != null) {
                        dwVar.baX.c(userTbVipInfoData.getvipV_url(), 10, false);
                    }
                    dwVar.edv.setIsBigV(true);
                }
                dwVar.dXU.setVisibility(4);
                dwVar.edv.setVisibility(0);
                dwVar.dXT.setVisibility(8);
                dwVar.edv.setData(qVar.getAuthor());
                dwVar.edv.setUserId(qVar.getAuthor().getUserId());
                dwVar.edv.ae(qVar.getAuthor().getUserName(), qVar.bgk());
            } else {
                dwVar.dXT.setVisibility(8);
                if (g(qVar)) {
                    dwVar.dXU.setVisibility(4);
                    dwVar.edv.setVisibility(0);
                    dwVar.edv.c(portrait, 28, false);
                    dwVar.edv.setUserId(qVar.getAuthor().getUserId());
                    dwVar.edv.ae(qVar.getAuthor().getUserName(), qVar.bgk());
                    dwVar.edv.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehp);
                } else {
                    dwVar.dXU.setVisibility(0);
                    dwVar.edv.setVisibility(8);
                    dwVar.dXU.setUserId(qVar.getAuthor().getUserId());
                    dwVar.dXU.ae(qVar.getAuthor().getUserName(), qVar.bgk());
                    dwVar.dXU.setImageDrawable(null);
                    dwVar.dXU.c(portrait, 28, false);
                }
            }
            dwVar.bbH.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
            dwVar.bbH.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            dwVar.dYa.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_c));
            if (this.ctc) {
                dwVar.dYa.setDefaultImageId(r.f.transparent_bg);
            } else {
                dwVar.dYa.setDefaultImageId(r.f.icon_click);
            }
            dwVar.dYa.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                avP = null;
            } else {
                avP = qVar.avP();
            }
            if (this.dXH || !this.dXI) {
                dwVar.dYa.a(avP, false, this.ede);
            } else {
                dwVar.dYa.a(avP, true, this.ede);
            }
            boolean z5 = false;
            boolean z6 = false;
            if (this.dXl != null && this.dXl.aIu() != 0) {
                z5 = true;
                z6 = true;
                if (qVar != null && qVar.getAuthor() != null) {
                    String userId2 = qVar.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z5 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z5 = false;
                    }
                }
            }
            if (this.dXl != null && this.dXl.aIl() != null && this.dXl.aIl().getAuthor() != null && qVar.getAuthor() != null) {
                String userId3 = this.dXl.aIl().getAuthor().getUserId();
                String userId4 = qVar.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId3)) {
                    if (!UtilHelper.isCurrentAccount(userId4)) {
                        z = true;
                        z3 = false;
                        z2 = true;
                    } else {
                        z3 = true;
                        z = false;
                        z2 = true;
                    }
                    if (qVar != null && qVar.getAuthor() != null && UtilHelper.isCurrentAccount(qVar.getAuthor().getUserId())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i4 = 1;
                    if (qVar.bga() == 1) {
                        i4 = 0;
                    }
                    sparseArray4.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z5) {
                        sparseArray4.put(r.g.tag_should_manage_visible, true);
                        sparseArray4.put(r.g.tag_manage_user_identity, Integer.valueOf(this.dXl.aIu()));
                        sparseArray4.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray4.put(r.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray4.put(r.g.tag_user_mute_visible, true);
                        sparseArray4.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray4.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray4.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.dXl.aIl() != null) {
                            sparseArray4.put(r.g.tag_user_mute_thread_id, this.dXl.aIl().getId());
                        }
                        sparseArray4.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray4.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z2) {
                        sparseArray4.put(r.g.tag_should_delete_visible, true);
                        sparseArray4.put(r.g.tag_manage_user_identity, Integer.valueOf(this.dXl.aIu()));
                        sparseArray4.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray4.put(r.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray4.put(r.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray4.put(r.g.tag_should_delete_visible, false);
                    }
                    bgj = qVar.bgj();
                    if (bgj.size() > 0 || (qVar.bga() == 1 && this.dYB.aJb().aMt())) {
                        dwVar.edy.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar = bgj.get(0);
                        if (!StringUtils.isNull(bVar.getIconUrl())) {
                            a(dwVar, bVar.getIconUrl());
                            if (!StringUtils.isNull(bVar.BM())) {
                                dwVar.edy.setTag(r.g.tag_pb_lottery_tail_link, bVar.BM());
                            }
                        } else {
                            dwVar.edy.setVisibility(8);
                        }
                    }
                    a(dwVar, qVar, qVar.bga() != 1, avP);
                    d(dwVar);
                }
            }
            z = false;
            z2 = z6;
            z3 = false;
            if (qVar != null) {
                z2 = true;
                z3 = true;
            }
            int i42 = 1;
            if (qVar.bga() == 1) {
            }
            sparseArray4.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z5) {
            }
            if (!z) {
            }
            if (!z2) {
            }
            bgj = qVar.bgj();
            if (bgj.size() > 0) {
            }
            dwVar.edy.setVisibility(8);
            a(dwVar, qVar, qVar.bga() != 1, avP);
            d(dwVar);
        }
    }

    private void b(dw dwVar) {
        if (dwVar != null && this.dXl != null && this.dXl.aIA() != null) {
            dwVar.aLk();
            dwVar.edl.setOnClickListener(this.cjr);
            com.baidu.tieba.pb.data.h aIA = this.dXl.aIA();
            dwVar.edq.setSupportNoImage(true);
            dwVar.edq.setInterceptOnClick(true);
            if (this.ctc) {
                dwVar.edq.setDefaultResource(r.f.transparent_bg);
                dwVar.edq.c(aIA.pS(), 17, false);
            } else {
                dwVar.edq.setDefaultResource(r.f.icon_click);
            }
            dwVar.edq.setOnClickListener(this.cjr);
            dwVar.edp.setOnClickListener(this.cjr);
            int aIC = aIA.aIC();
            String aID = StringUtils.isNull(aIA.aID(), true) ? "" : aIA.aID();
            String string = this.mContext.getString(r.j.yule_head_img);
            if (aIC <= 0) {
                dwVar.edo.setVisibility(8);
                dwVar.edp.setVisibility(8);
            } else {
                dwVar.edo.setVisibility(0);
                dwVar.edp.setVisibility(0);
                if (aIC > 20) {
                    string = String.format(this.mContext.getString(r.j.yule_head_img_rank), "20+");
                } else {
                    string = String.format(this.mContext.getString(r.j.yule_head_img_rank), new StringBuilder(String.valueOf(aIC)).toString());
                }
                dwVar.edo.setText(" " + aID);
            }
            dwVar.edn.setText(string);
            if (aIA.pP()) {
                dwVar.edr.setVisibility(8);
            } else {
                dwVar.edr.setVisibility(0);
                dwVar.edr.setText(String.format(this.mContext.getString(r.j.yule_head_img_pic_author), aIA.pR()));
            }
            if (StringUtils.isNull(this.dXl.aIl().getAuthor().getName_show(), true)) {
                dwVar.eds.setVisibility(8);
            } else {
                dwVar.eds.setVisibility(0);
                dwVar.eds.setText(String.format(this.mContext.getString(r.j.yule_head_img_post_author), this.dXl.aIl().getAuthor().getName_show()));
            }
            if (dwVar.dYr.getVisibility() == 0) {
                View findViewById = dwVar.dXQ.findViewById(r.g.yule_head_img_blank);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) dwVar.dYr.getLayoutParams();
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams != null && marginLayoutParams != null && layoutParams.height == getDimensionPixelSize(r.e.ds72)) {
                    layoutParams.height -= marginLayoutParams.topMargin;
                }
            }
            c(dwVar);
        }
    }

    private void c(dw dwVar) {
        if (dwVar.edl != null) {
            com.baidu.tbadk.core.util.ar.l(dwVar.edm, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) dwVar.edn, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.j((View) dwVar.edo, r.d.cp_cont_e);
            com.baidu.tbadk.core.util.ar.j((View) dwVar.edp, r.d.cp_link_tip_a);
            com.baidu.tbadk.core.util.ar.j((View) dwVar.edr, r.d.cp_cont_i);
            com.baidu.tbadk.core.util.ar.j((View) dwVar.eds, r.d.cp_cont_i);
        }
    }

    private void a(dw dwVar, String str) {
        dwVar.edy.setVisibility(0);
        com.baidu.adp.lib.g.c.eA().a(str, 17, new dv(this, dwVar, str), this.dYB.getUniqueId());
    }

    private void d(dw dwVar) {
        dwVar.dYa.setTextViewOnTouchListener(this.dXp);
        dwVar.dYa.setTextViewCheckSelection(false);
    }

    private void a(dw dwVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aNF() == null) {
            dwVar.dYw.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(qVar.aNF(), dwVar.dYw, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1110=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int I = (((com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i = 0;
        if (!z) {
            i = getDimensionPixelSize(r.e.ds132);
        } else if (z2) {
            i = getDimensionPixelSize(r.e.ds64);
        }
        int min = Math.min(I - i, this.dXB);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private boolean g(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (qVar == null || qVar.getAuthor() == null || qVar.getAuthor().getGodUserData() == null || qVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void e(dw dwVar) {
        dwVar.dXQ.setOnTouchListener(this.dXp);
        dwVar.dXQ.setOnLongClickListener(this.aou);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl;
        dwVar.bbH.setOnClickListener(aVar.ehp);
        dwVar.dXU.setOnClickListener(aVar.ehp);
        dwVar.dXT.setOnClickListener(aVar.ehp);
        dwVar.dYe.setOnLongClickListener(this.aou);
        dwVar.dYa.setOnLongClickListener(this.aou);
        dwVar.dYe.setOnTouchListener(this.dXp);
        dwVar.dYa.setOnTouchListener(this.dXp);
        dwVar.dYa.setCommonTextViewOnClickListener(this.cjr);
        dwVar.dYa.setOnImageClickListener(this.aJq);
        dwVar.dYa.setOnEmotionClickListener(aVar.ehr);
        dwVar.bQG.setOnClickListener(aVar.bJq);
        dwVar.ahx.setOnClickListener(aVar.ehq);
        dwVar.dYw.setOnClickListener(this.cjr);
        dwVar.edy.setOnClickListener(this.cjr);
        dwVar.edt.setOnClickListener(this.cjr);
        dwVar.edu.setOnClickListener(this.cjr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.dXl = fVar;
    }

    public void nw(int i) {
        this.dXB = i;
    }

    public void hX(boolean z) {
        this.ctc = z;
    }

    public void hY(boolean z) {
        this.dXC = z;
    }

    public void hZ(boolean z) {
        this.eaN = z;
    }

    public void nN(String str) {
        this.dXD = str;
    }

    public void F(View.OnClickListener onClickListener) {
        this.dXG = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cjr = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJq = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dXp = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aou = onLongClickListener;
    }

    public void ib(boolean z) {
        this.dZc = z;
    }

    public void a(TbRichTextView.b bVar) {
        this.ede = bVar;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str, r.f.pic_smalldot_title));
            return com.baidu.tieba.card.ap.a((Context) this.dYB.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
