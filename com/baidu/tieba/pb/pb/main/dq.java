package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dq extends cm<com.baidu.tieba.tbadkCore.data.s, dx> implements View.OnClickListener {
    private TbRichTextView.d aFe;
    private View.OnLongClickListener ajO;
    private ArrayList<IconData> bfm;
    private View.OnClickListener bnn;
    private int dfH;
    private boolean dfI;
    private boolean dfJ;
    private com.baidu.tieba.pb.data.e dfK;
    private boolean dfL;
    private com.baidu.tieba.pb.a.d dfM;
    private int dfN;
    private int dfO;
    private boolean dfP;
    private final boolean dfQ;
    private String dgZ;
    private com.baidu.tieba.pb.pb.sub.an dha;
    private ArrayList<IconData> dhb;
    private View.OnClickListener dhc;
    private boolean diI;
    private boolean dkm;
    private boolean dms;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dfH = 0;
        this.dfI = true;
        this.dfJ = true;
        this.dfL = true;
        this.dfK = null;
        this.dgZ = null;
        this.dha = null;
        this.dhb = null;
        this.bfm = null;
        this.dhc = null;
        this.bnn = null;
        this.aFe = null;
        this.dfM = null;
        this.ajO = null;
        this.dfP = false;
        this.dfQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.dkm = false;
        this.dms = false;
        this.diI = false;
        init();
    }

    private void init() {
        this.dfN = getDimensionPixelSize(t.e.ds30);
        this.dfO = com.baidu.adp.lib.util.k.B(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    private void a(dx dxVar) {
        if (dxVar != null) {
            if (dxVar.mSkinType != TbadkCoreApplication.m11getInst().getSkinType()) {
                com.baidu.tbadk.core.util.at.l(dxVar.dhh, t.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.at.l(dxVar.dhi, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.l(dxVar.dhj, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.l(dxVar.dmv, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.c(dxVar.dhC, t.d.subpb_listitem_time, 1);
                com.baidu.tbadk.core.util.at.c(dxVar.dhE, t.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.at.c(dxVar.aLz, t.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.at.c(dxVar.dhn, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.at.c(dxVar.dho, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.at.c(dxVar.dhq, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.at.c(dxVar.dhr, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.at.c(dxVar.dht, t.f.btn_pb_more_btn_selector);
                com.baidu.tbadk.core.util.at.c(dxVar.dkC, t.f.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.at.l(dxVar.dfW, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.at.l(dxVar.dfX, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.at.c(dxVar.dfX, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.c(dxVar.dhw, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.k(dxVar.dmy, t.f.btn_appdownload);
                com.baidu.tbadk.core.util.at.c(dxVar.dmy, t.d.cp_cont_i, 1);
                dxVar.dfT.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.pb_listitem_content));
            }
            dxVar.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public dx b(ViewGroup viewGroup) {
        dx dxVar = new dx(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.dfJ, this.dfI, this.dfH, false);
        a(dxVar);
        return dxVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, dx dxVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) dxVar);
        a(dxVar);
        c(dxVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) at(i);
        if (sVar2 != null) {
            a(dxVar, sVar2, view, false, i);
        }
        if (!this.dfP && this.dfQ && dxVar != null && dxVar.dfT.Hn() && (listView = ((PbActivity) this.dhY.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dfP = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:216:0x0889  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x08b3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0940  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0976  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x09f5  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0d41  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0d71  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0d7d  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0d89  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0dd6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(dx dxVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.a amw;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> aUd;
        SparseArray sparseArray2;
        if (dxVar != null && sVar != null) {
            if (!z) {
                dxVar.dhz.setVisibility(0);
                dxVar.dhm.setTag(null);
                dxVar.dhm.setUserId(null);
                dxVar.aLz.setText((CharSequence) null);
                dxVar.dho.setVisibility(8);
                dxVar.dhx.setVisibility(0);
                dxVar.dht.setVisibility(0);
                dxVar.dhs.setVisibility(8);
                if (sVar.aTU() == null) {
                    dxVar.dhy.setVisibility(8);
                } else if (TbadkCoreApplication.m11getInst().isBaobaoShouldOpen() && sVar.aTU().Au() == 1) {
                    dxVar.dhy.changeSkinType(this.mSkinType);
                    dxVar.dhy.setVisibility(0);
                    dxVar.dhy.setData(sVar.aTU());
                } else {
                    dxVar.dhy.setVisibility(8);
                }
                SparseArray sparseArray3 = (SparseArray) dxVar.dhu.getTag();
                if (sparseArray3 == null) {
                    SparseArray sparseArray4 = new SparseArray();
                    dxVar.dhu.setTag(sparseArray4);
                    dxVar.dfT.setTag(sparseArray4);
                    dxVar.dhh.setTag(t.g.tag_from, sparseArray4);
                    sparseArray2 = sparseArray4;
                } else {
                    sparseArray2 = sparseArray3;
                }
                sparseArray2.put(t.g.tag_clip_board, sVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                dxVar.dfT.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dxVar.dfT.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                layoutParams.topMargin = getDimensionPixelSize(t.e.ds20);
                layoutParams.bottomMargin = getDimensionPixelSize(t.e.ds20);
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                if (!this.dfI) {
                    layoutParams.leftMargin = 0;
                    layoutParams.topMargin = 0;
                    dxVar.dfT.setIsSupportVitality(true);
                } else if (TextUtils.isEmpty(sVar.getBimg_url())) {
                    this.dms = false;
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    dxVar.dfT.gv(null);
                    dxVar.dfT.setBackgroundDrawable(null);
                    if (sVar.aTS() == 1) {
                        dxVar.dfT.setIsSupportVitality(true);
                    } else {
                        dxVar.dfT.setIsSupportVitality(false);
                    }
                } else {
                    this.dms = true;
                    dxVar.dfT.setIsSupportVitality(false);
                    if (sVar.aTS() == 1) {
                        layoutParams.leftMargin = getDimensionPixelSize(t.e.ds30);
                    } else {
                        layoutParams.leftMargin = 0;
                    }
                    layoutParams.rightMargin = getDimensionPixelSize(t.e.ds30);
                    sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                    dxVar.dfT.gv(sVar.getBimg_url());
                }
                dxVar.dfT.setLayoutParams(layoutParams);
                if (sVar.aTS() != 1) {
                    if (TextUtils.isEmpty(sVar.getBimg_url())) {
                        dxVar.dfT.setOnClickListener(this.bnn);
                        dxVar.dfT.setTextViewOnClickListener(this.bnn);
                    } else {
                        dxVar.dfT.setOnClickListener(null);
                        dxVar.dfT.setTextViewOnClickListener(null);
                    }
                    dxVar.dhh.setOnClickListener(this.bnn);
                    dxVar.dhu.setOnClickListener(this.bnn);
                } else {
                    dxVar.dhh.setOnClickListener(null);
                    dxVar.dhu.setOnClickListener(null);
                }
                dxVar.dhr.setText(sVar.aTT());
                if (sVar.aTS() == 1) {
                    dxVar.dhh.setPadding(0, 0, 0, 0);
                    a(dxVar.dfT, view, true, this.dms);
                    dxVar.dhi.setVisibility(8);
                    dxVar.dhj.setVisibility(8);
                    dxVar.dhk.setVisibility(8);
                    dxVar.dhz.setVisibility(8);
                    dxVar.dhu.setVisibility(8);
                    dxVar.dhr.setVisibility(8);
                    dxVar.dhA.setVisibility(8);
                    dxVar.dfV.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    dxVar.dfV.a(sVar.aUb(), str, j, com.baidu.adp.lib.h.b.c(this.dfK.avB().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    dxVar.dfV.sf();
                    if (this.dfL) {
                        PraiseData praise = this.dfK.avB().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            dxVar.dfW.setVisibility(0);
                            dxVar.dfX.setVisibility(0);
                            dxVar.dfW.setIsFromPb(true);
                            dxVar.dfW.a(praise, this.dfK.avB().getId(), praise.getPostId(), true);
                            dxVar.dfW.cW(this.mSkinType);
                        } else {
                            dxVar.dfW.setVisibility(8);
                            dxVar.dfX.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.aj(dxVar.dfW);
                        com.baidu.tieba.graffiti.d.aj(dxVar.dfX);
                        com.baidu.tbadk.data.f aTV = sVar.aTV();
                        dxVar.dhM.setVisibility(8);
                        if (aTV != null && !TextUtils.isEmpty(aTV.getName()) && !TextUtils.isEmpty(aTV.getName().trim())) {
                            String name = aTV.getName();
                            String lat = aTV.getLat();
                            String lng = aTV.getLng();
                            dxVar.dhJ.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, dxVar.dhJ, 0, 10, 0, 10);
                            dxVar.dhL.setText(aTV.getName());
                            com.baidu.tbadk.core.util.at.c(dxVar.dhL, t.d.cp_link_tip_c, 1);
                            com.baidu.tbadk.core.util.at.c(dxVar.dhK, t.f.icon_pb_pin);
                            dxVar.dhJ.setOnClickListener(new dr(this, lat, lng, name));
                        } else {
                            dxVar.dhK.setVisibility(8);
                            dxVar.dhL.setVisibility(8);
                        }
                        if (sVar.getAuthor() != null && sVar.getAuthor().getGodInfo() != null) {
                            dxVar.dfV.hh(false);
                            ViewGroup.LayoutParams layoutParams2 = dxVar.dhJ.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.width = -2;
                                dxVar.dhJ.setLayoutParams(layoutParams2);
                            }
                            dxVar.dhJ.setVisibility(0);
                            View findViewWithTag = dxVar.dhJ.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(t.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(t.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                dxVar.dhJ.addView(textView, 0);
                            }
                            View findViewWithTag2 = dxVar.dhJ.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_cont_d, 1);
                                textView2.setText(sVar.aTT());
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(t.e.ds20), 0);
                                dxVar.dhJ.addView(textView2, 1);
                            }
                            if (dxVar.dmw == null) {
                                dxVar.dhK.setVisibility(8);
                                dxVar.dhJ.removeView(dxVar.dhL);
                                dxVar.dmw = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams3.addRule(11);
                                layoutParams3.addRule(15);
                                dxVar.dhL.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.icon_pb_pin), (Drawable) null, (Drawable) null, (Drawable) null);
                                dxVar.dmw.addView(dxVar.dhL, layoutParams3);
                                dxVar.dhJ.addView(dxVar.dmw, new LinearLayout.LayoutParams(-1, -2));
                                if (aTV != null && !TextUtils.isEmpty(aTV.getName()) && !TextUtils.isEmpty(aTV.getName().trim())) {
                                    dxVar.dhL.setOnClickListener(new ds(this, aTV.getLat(), aTV.getLng(), aTV.getName()));
                                }
                            }
                            dxVar.dhJ.setOnClickListener(null);
                        }
                    } else {
                        dxVar.dfW.setVisibility(8);
                        dxVar.dfX.setVisibility(8);
                        dxVar.dhJ.setVisibility(8);
                        dxVar.dhM.setVisibility(8);
                    }
                    if (this.dhY.awt().awi()) {
                        dxVar.dfT.setVisibility(8);
                    }
                    ((LinearLayout.LayoutParams) dxVar.dhy.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                    if (this.dfK.avB() != null && this.dfK.avB().qV() != null) {
                        com.baidu.tbadk.core.data.bf qV = this.dfK.avB().qV();
                        String activityUrl = qV.getActivityUrl();
                        String rP = qV.rP();
                        String rQ = qV.rQ();
                        if (!StringUtils.isNull(rQ)) {
                            dxVar.dmy.setVisibility(0);
                            dxVar.dmy.setText(rQ);
                            dxVar.dmy.setOnClickListener(new dt(this, activityUrl));
                            dxVar.dmz.setOnClickListener(new du(this, activityUrl));
                            if (!StringUtils.isNull(rP)) {
                                dxVar.bkY.setVisibility(0);
                                dxVar.bkY.c(rP, 10, true);
                            }
                        } else {
                            return;
                        }
                    } else {
                        dxVar.dmy.setVisibility(8);
                        dxVar.bkY.setVisibility(8);
                    }
                } else {
                    dxVar.dfT.setVisibility(0);
                    a(dxVar.dfT, view, false, this.dms);
                    dxVar.dhk.setVisibility(0);
                    dxVar.dhA.setVisibility(0);
                    dxVar.dhh.setPadding(getDimensionPixelSize(t.e.ds30), 0, getDimensionPixelSize(t.e.ds30), 0);
                    dxVar.bkY.setVisibility(8);
                    dxVar.dmy.setVisibility(8);
                    if (this.dkm && i == 0) {
                        dxVar.dhi.setVisibility(8);
                        dxVar.dhj.setVisibility(8);
                    } else if (i == 1) {
                        if (!this.diI && (sVar.getPraise() == null || !sVar.getPraise().isPriaseDataValid())) {
                            dxVar.dhi.setVisibility(0);
                        } else if (this.dkm || this.dfL) {
                            dxVar.dhi.setVisibility(0);
                        } else {
                            dxVar.dhi.setVisibility(8);
                        }
                        dxVar.dhj.setVisibility(8);
                    } else {
                        dxVar.dhi.setVisibility(0);
                        dxVar.dhj.setVisibility(8);
                        if (i == 2 && this.diI) {
                            dxVar.dhi.setVisibility(8);
                        }
                    }
                    com.baidu.tbadk.data.f aTV2 = sVar.aTV();
                    dxVar.dhJ.setVisibility(8);
                    if (aTV2 != null && !TextUtils.isEmpty(aTV2.getName()) && !TextUtils.isEmpty(aTV2.getName().trim())) {
                        String name2 = aTV2.getName();
                        String lat2 = aTV2.getLat();
                        String lng2 = aTV2.getLng();
                        dxVar.dhM.setVisibility(0);
                        dxVar.dhO.setText(aTV2.getName());
                        com.baidu.tbadk.core.util.at.c(dxVar.dhO, t.d.cp_link_tip_c, 1);
                        com.baidu.tbadk.core.util.at.c(dxVar.dhN, t.f.icon_pb_pin);
                        dxVar.dhM.setOnClickListener(new dv(this, lat2, lng2, name2));
                    } else {
                        dxVar.dhM.setVisibility(8);
                    }
                    dxVar.dfV.setVisibility(8);
                    ((LinearLayout.LayoutParams) dxVar.dhy.getLayoutParams()).leftMargin = 0;
                    dxVar.dfW.setVisibility(8);
                    dxVar.dfX.setVisibility(8);
                    dxVar.dhu.setVisibility(0);
                    dxVar.dhz.setVisibility(0);
                    dxVar.dhr.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTS()));
                    dxVar.dhq.setVisibility(0);
                    dxVar.dhq.setText(format);
                }
                if (this.dgZ != null && !this.dgZ.equals("0") && this.dgZ.equals(sVar.getAuthor().getUserId())) {
                    dxVar.dhs.setVisibility(0);
                    com.baidu.tbadk.core.util.at.c(dxVar.dhs, t.f.icon_floorhost);
                    dxVar.dhs.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                }
            } else {
                dxVar.dhz.setVisibility(8);
            }
            com.baidu.tbadk.core.util.at.k(dxVar.dhl, t.f.bg_floor_new_middle);
            dxVar.dfT.setVideoImageId(t.f.pic_video);
            com.baidu.tbadk.core.util.at.c(dxVar.dht, t.f.btn_pb_more_btn_selector);
            SparseArray sparseArray5 = (SparseArray) dxVar.dht.getTag();
            if (sparseArray5 == null) {
                SparseArray sparseArray6 = new SparseArray();
                dxVar.dht.setTag(sparseArray6);
                sparseArray = sparseArray6;
            } else {
                sparseArray = sparseArray5;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(t.g.tag_pb_floor_number, Integer.valueOf(sVar.aTS()));
            SparseArray sparseArray7 = (SparseArray) dxVar.dkC.getTag();
            if (sparseArray7 == null) {
                sparseArray7 = new SparseArray();
                dxVar.dkC.setTag(sparseArray7);
            }
            sparseArray7.put(t.g.tag_clip_board, sVar);
            sparseArray7.put(t.g.tag_load_sub_data, sVar);
            sparseArray7.put(t.g.tag_load_sub_view, view);
            if (sVar.aTW() > 0) {
                if (this.dha == null) {
                    this.dha = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.dha.setIsFromCDN(this.mIsFromCDN);
                    this.dha.J(this.dhc);
                    boolean z7 = false;
                    String userId2 = this.dfK.avB().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.dha.v(this.dfK.avH(), z7);
                    this.dha.l(this.dfK.avB());
                    this.dha.gr(this.dfJ);
                }
                dxVar.dhx.setVisibility(0);
                dxVar.dhw.setVisibility(0);
                dxVar.dhv.setVisibility(0);
                dxVar.dhx.a(sVar, view);
                dxVar.dhx.setChildOnClickListener(this.bnn);
                dxVar.dhx.setChildOnLongClickListener(this.ajO);
                dxVar.dhx.setChildOnTouchListener(this.dfM);
                dxVar.dhx.setSubPbAdapter(this.dha);
                dxVar.dhx.setVisibility(0);
            } else {
                dxVar.dhx.setVisibility(8);
                dxVar.dhw.setVisibility(8);
                dxVar.dhv.setVisibility(8);
            }
            a(dxVar, sVar, this.dfK.avK(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.u.gp(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                    }
                    dxVar.aLz.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.at.c(dxVar.aLz, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.at.c(dxVar.aLz, t.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        dxVar.dhn.setVisibility(0);
                        com.baidu.tbadk.core.util.at.c(dxVar.dhn, BitmapHelper.getGradeResourceIdNew(level_id));
                        String aUf = sVar.aUf();
                        if (StringUtils.isNull(aUf)) {
                            aUf = String.format(TbadkCoreApplication.m11getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id));
                        }
                        dxVar.dhn.setContentDescription(aUf);
                        dxVar.dhn.setOnClickListener(null);
                    } else {
                        dxVar.dhn.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.at.c(dxVar.dho, t.f.pb_manager);
                            dxVar.dhn.setVisibility(8);
                            dxVar.dho.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.at.c(dxVar.dho, t.f.pb_assist);
                            dxVar.dhn.setVisibility(8);
                            dxVar.dho.setVisibility(0);
                        }
                        if (dxVar.dho.getVisibility() == 0) {
                            dxVar.dho.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        }
                    }
                    if (dxVar.dhn.getVisibility() == 0) {
                        dxVar.dhn.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.at.c(dxVar.dhp, t.f.icon_pb_pop_girl);
                        dxVar.dhp.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.at.c(dxVar.dhp, t.f.icon_pb_pop_boy);
                        dxVar.dhp.setVisibility(0);
                    } else {
                        dxVar.dhp.setVisibility(8);
                    }
                    if (dxVar.dhp.getVisibility() == 0) {
                        dxVar.dhp.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    }
                    if (com.baidu.tbadk.util.u.gp(sVar.getAuthor().getName_show()) >= 14 && dxVar.dhn.getVisibility() == 0 && dxVar.dhs.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.dhb = sVar.getAuthor().getIconInfo();
                    this.bfm = sVar.getAuthor().getTShowInfoNew();
                    if (dxVar.bvy != null) {
                        dxVar.bvy.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                        dxVar.bvy.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.bkL);
                        dxVar.bvy.vv();
                        dxVar.bvy.a(this.dhb, i2, getDimensionPixelSize(t.e.pb_icon_width), getDimensionPixelSize(t.e.pb_icon_height), getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (dxVar.adH != null) {
                        dxVar.adH.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpK);
                        if (this.bfm != null && this.bfm.size() > 0 && this.bfm.get(0) != null) {
                            dxVar.adH.setTag(this.bfm.get(0).getUrl());
                        }
                        dxVar.adH.a(this.bfm, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.small_icon_margin), true);
                    }
                }
                if (f(sVar)) {
                    if (this.dfJ) {
                        dxVar.dhm.setVisibility(4);
                        dxVar.dmx.setVisibility(0);
                    }
                    dxVar.dmx.c(portrait, 28, false);
                    dxVar.dmx.setUserId(sVar.getAuthor().getUserId());
                    dxVar.dmx.af(sVar.getAuthor().getUserName(), sVar.aUe());
                    dxVar.dmx.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpJ);
                } else {
                    if (this.dfJ) {
                        dxVar.dhm.setVisibility(0);
                    }
                    dxVar.dmx.setVisibility(8);
                    dxVar.dhm.setUserId(sVar.getAuthor().getUserId());
                    dxVar.dhm.af(sVar.getAuthor().getUserName(), sVar.aUe());
                    dxVar.dhm.setImageDrawable(null);
                    dxVar.dhm.c(portrait, 28, false);
                }
                dxVar.aLz.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                dxVar.aLz.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            }
            dxVar.dfT.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            if (this.dfI) {
                dxVar.dfT.setDefaultImageId(t.f.transparent_bg);
            } else {
                dxVar.dfT.setDefaultImageId(t.f.icon_click);
            }
            dxVar.dfT.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                amw = null;
            } else {
                amw = sVar.amw();
            }
            if (this.dfP || !this.dfQ) {
                dxVar.dfT.a(amw, false);
            } else {
                dxVar.dfT.a(amw, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.dfK.avH() != 0) {
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
            if (this.dfK != null && this.dfK.avB() != null && this.dfK.avB().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.dfK.avB().getAuthor().getUserId();
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
                        if (dxVar.dhE != null) {
                            dxVar.dhE.setVisibility(0);
                            dxVar.dhE.setText(t.j.manage);
                            dxVar.dhE.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (dxVar.dhE != null) {
                            dxVar.dhE.setVisibility(0);
                            dxVar.dhE.setText(t.j.delete);
                            dxVar.dhE.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (dxVar.dhE != null) {
                        dxVar.dhE.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.aTS() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dfK.avH()));
                        sparseArray.put(t.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                        }
                        if (this.dfK.avB() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.dfK.avB().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dfK.avH()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        dxVar.dht.setVisibility(8);
                        com.baidu.tbadk.core.util.at.c(dxVar.dhC, t.d.subpb_listitem_time, 1);
                        dxVar.dhC.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), sVar.aTT()));
                        if (dxVar.dhE.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.at.c(dxVar.dhE, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            dxVar.dhE.setTag(sparseArray);
                            dxVar.dhE.setOnClickListener(this.dhc);
                        }
                    }
                    aUd = sVar.aUd();
                    if (aUd.size() > 0 || (sVar.aTS() == 1 && this.dhY.awt().awi())) {
                        dxVar.dmA.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar = aUd.get(0);
                        if (!StringUtils.isNull(bVar.getIconUrl())) {
                            dxVar.dmA.setScaleType(ImageView.ScaleType.FIT_XY);
                            dxVar.dmA.c(bVar.getIconUrl(), 10, true);
                            dxVar.dmA.setVisibility(0);
                            if (!StringUtils.isNull(bVar.At())) {
                                dxVar.dmA.setTag(t.g.tag_pb_lottery_tail_link, bVar.At());
                            }
                        }
                    }
                    a(dxVar, sVar, sVar.aTS() != 1, amw);
                    b(dxVar);
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
            if (sVar.aTS() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            aUd = sVar.aUd();
            if (aUd.size() > 0) {
            }
            dxVar.dmA.setVisibility(8);
            a(dxVar, sVar, sVar.aTS() != 1, amw);
            b(dxVar);
        }
    }

    private void b(dx dxVar) {
        dxVar.dfT.setTextViewOnTouchListener(this.dfM);
        dxVar.dfT.setTextViewCheckSelection(true);
    }

    private void a(dx dxVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAC() == null) {
            dxVar.dhP.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.n.a(sVar.aAC(), dxVar.dhP, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1061=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int B = (((com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int dimensionPixelSize = getDimensionPixelSize(t.e.ds60);
        if (!z) {
            dimensionPixelSize = getDimensionPixelSize(t.e.ds98);
        } else if (z2) {
            dimensionPixelSize = 0;
        }
        int min = Math.min(B - dimensionPixelSize, this.dfH);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void a(dx dxVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.aTX() > 0 && sVar.aTR() != null) {
            dxVar.dhB.setVisibility(0);
            dxVar.dhB.removeViews(0, dxVar.dhB.getChildCount() - 1);
            int size = sVar.aTR().size();
            int aTY = sVar.aTY();
            for (int i2 = 0; i2 < aTY; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.aTR().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) dxVar.dhB, false);
                dx dxVar2 = new dx(inflate, this.dfJ, this.dfI, this.dfH, true);
                c(dxVar2);
                a(dxVar2, sVar2, (View) dxVar.dhB, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, sVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.dfI) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    dxVar2.dfT.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dxVar2.dfT.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    dxVar2.dfT.setLayoutParams(layoutParams);
                    dxVar2.dfT.setPadding(0, 0, 0, 0);
                    dxVar.dfT.gv(null);
                } else {
                    dxVar.dfT.gv(sVar.getBimg_url());
                    dxVar2.dfT.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dxVar2.dfT.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    dxVar2.dfT.setLayoutParams(layoutParams2);
                }
                dxVar.dhB.addView(inflate, dxVar.dhB.getChildCount() - 1);
            }
            if (aTY < size) {
                dxVar.dhF.setVisibility(0);
                com.baidu.tbadk.core.util.at.k(dxVar.dhH, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.k(dxVar.dhI, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.c(dxVar.dhG, t.d.cp_cont_f, 1);
                dxVar.dhF.setOnClickListener(new dw(this, aTY, size, sVar));
                return;
            }
            dxVar.dhF.setVisibility(8);
            return;
        }
        dxVar.dhB.setVisibility(8);
    }

    private boolean f(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (sVar == null || sVar.getAuthor() == null || sVar.getAuthor().getGodUserData() == null || sVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void c(dx dxVar) {
        dxVar.dhh.setOnTouchListener(this.dfM);
        dxVar.dhh.setOnLongClickListener(this.ajO);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS;
        dxVar.aLz.setOnClickListener(aVar.dpJ);
        dxVar.dht.setOnClickListener(this.bnn);
        dxVar.dhm.setOnClickListener(aVar.dpJ);
        dxVar.dhu.setOnLongClickListener(this.ajO);
        dxVar.dfT.setOnLongClickListener(this.ajO);
        dxVar.dhu.setOnTouchListener(this.dfM);
        dxVar.dfT.setOnTouchListener(this.dfM);
        dxVar.dfT.setOnImageClickListener(this.aFe);
        dxVar.dfT.setOnEmotionClickListener(aVar.dpL);
        dxVar.bvy.setOnClickListener(aVar.bkL);
        dxVar.adH.setOnClickListener(aVar.dpK);
        dxVar.dhP.setOnClickListener(this.bnn);
        dxVar.dmA.setOnClickListener(this.bnn);
        dxVar.dkC.setOnClickListener(this.bnn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfK = eVar;
    }

    public void lE(int i) {
        this.dfH = i;
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void gr(boolean z) {
        this.dfJ = z;
    }

    public void gs(boolean z) {
        this.dfL = z;
    }

    public void gC(boolean z) {
        this.dkm = z;
    }

    public void lQ(String str) {
        this.dgZ = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dhc = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    public void gu(boolean z) {
        this.diI = z;
    }
}
