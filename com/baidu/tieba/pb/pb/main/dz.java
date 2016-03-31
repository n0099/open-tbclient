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
public class dz extends db<com.baidu.tieba.tbadkCore.data.s, eg> implements View.OnClickListener {
    private TbRichTextView.d aJc;
    private View.OnLongClickListener aoa;
    private ArrayList<IconData> bjm;
    private View.OnClickListener brL;
    private int ddn;
    private boolean ddo;
    private boolean ddp;
    private com.baidu.tieba.pb.data.e ddq;
    private boolean ddr;
    private com.baidu.tieba.pb.a.c dds;
    private int ddt;
    private int ddv;
    private boolean ddw;
    private final boolean ddx;
    private String deG;
    private com.baidu.tieba.pb.pb.sub.an deH;
    private ArrayList<IconData> deI;
    private View.OnClickListener deJ;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ddn = 0;
        this.ddo = true;
        this.ddp = true;
        this.ddr = true;
        this.ddq = null;
        this.deG = null;
        this.deH = null;
        this.deI = null;
        this.bjm = null;
        this.deJ = null;
        this.brL = null;
        this.aJc = null;
        this.dds = null;
        this.aoa = null;
        this.ddw = false;
        this.ddx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.ddt = getDimensionPixelSize(t.e.ds30);
        this.ddv = com.baidu.adp.lib.util.k.B(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    private void a(eg egVar) {
        if (egVar != null) {
            if (egVar.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                com.baidu.tbadk.core.util.at.l(egVar.deP, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.l(egVar.deQ, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.b(egVar.dfh, t.d.subpb_listitem_time, 1);
                com.baidu.tbadk.core.util.at.b(egVar.dfj, t.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.at.b(egVar.aPp, t.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.at.b((View) egVar.deU, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.at.b((View) egVar.deV, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.at.b(egVar.deX, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.at.b(egVar.deY, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.at.c(egVar.dfa, t.f.btn_pb_more_selector);
                com.baidu.tbadk.core.util.at.c(egVar.diq, t.f.btn_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.at.l(egVar.ddB, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.l(egVar.ddD, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.at.l(egVar.ddE, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.at.c(egVar.ddE, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.c(egVar.dfd, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.k(egVar.dka, t.f.btn_appdownload);
                com.baidu.tbadk.core.util.at.b(egVar.dka, t.d.cp_cont_i, 1);
            }
            egVar.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public eg b(ViewGroup viewGroup) {
        eg egVar = new eg(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.ddp, this.ddo, this.ddn, false);
        a(egVar);
        return egVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, eg egVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) egVar);
        a(egVar);
        c(egVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) aF(i);
        if (sVar2 != null) {
            a(egVar, sVar2, view, false, i);
        }
        if (!this.ddw && this.ddx && egVar != null && egVar.ddA.IX() && (listView = ((PbActivity) this.dfw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ddw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0833  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x083b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0847  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x08c8  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0cf4  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0d24  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0d30  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0d3c  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0d89  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(eg egVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.a amn;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.a> aTD;
        if (egVar != null && sVar != null) {
            if (!z) {
                egVar.deT.setTag(null);
                egVar.deT.setUserId(null);
                egVar.aPp.setText((CharSequence) null);
                egVar.deV.setVisibility(8);
                egVar.dfe.setVisibility(0);
                egVar.dfa.setVisibility(0);
                egVar.deZ.setVisibility(8);
                if (sVar.aTu() == null) {
                    egVar.dff.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && sVar.aTu().CA() == 1) {
                    egVar.dff.changeSkinType(this.mSkinType);
                    egVar.dff.setVisibility(0);
                    egVar.dff.setData(sVar.aTu());
                } else {
                    egVar.dff.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) egVar.dfb.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    egVar.dfb.setTag(sparseArray2);
                    egVar.ddA.setTag(sparseArray2);
                }
                sparseArray2.put(t.g.tag_clip_board, sVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                a(egVar.ddA, getDimensionPixelSize(t.e.ds30));
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ddo) {
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) egVar.ddA.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    egVar.ddA.setLayoutParams(layoutParams);
                    egVar.ddA.setPadding(0, 0, 0, 0);
                    egVar.ddA.gu(null);
                    egVar.ddA.setBackgroundDrawable(null);
                } else {
                    sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                    egVar.ddA.gu(sVar.getBimg_url());
                    if (sVar.aTs() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) egVar.ddA.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds40);
                        egVar.ddA.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) egVar.ddA.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(t.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(t.e.ds20);
                        egVar.ddA.setLayoutParams(layoutParams3);
                    }
                }
                egVar.deY.setText(sVar.aTt());
                if (sVar.aTs() == 1) {
                    com.baidu.tbadk.core.util.at.l(egVar.deO, t.d.cp_bg_line_d);
                    egVar.deP.setVisibility(8);
                    egVar.deQ.setVisibility(8);
                    egVar.deR.setVisibility(8);
                    egVar.dfb.setVisibility(8);
                    egVar.deY.setVisibility(8);
                    egVar.ddC.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    egVar.ddC.a(sVar.aTB(), str, j, com.baidu.adp.lib.h.b.c(this.ddq.avv().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    egVar.ddC.uA();
                    if (this.ddr) {
                        PraiseData praise = this.ddq.avv().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            egVar.ddD.setVisibility(0);
                            egVar.ddB.setVisibility(0);
                            egVar.ddE.setVisibility(0);
                            egVar.ddD.setIsFromPb(true);
                            egVar.ddD.a(praise, this.ddq.avv().getId(), praise.getPostId(), true);
                            egVar.ddD.dn(this.mSkinType);
                        } else {
                            egVar.ddD.setVisibility(8);
                            egVar.ddB.setVisibility(8);
                            egVar.ddE.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.af(egVar.ddD);
                        com.baidu.tieba.graffiti.d.af(egVar.ddB);
                        com.baidu.tieba.graffiti.d.af(egVar.ddE);
                        com.baidu.tbadk.data.e aTv = sVar.aTv();
                        egVar.dfr.setVisibility(8);
                        if (aTv != null && !TextUtils.isEmpty(aTv.getName()) && !TextUtils.isEmpty(aTv.getName().trim())) {
                            String name = aTv.getName();
                            String lat = aTv.getLat();
                            String lng = aTv.getLng();
                            egVar.dfo.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, egVar.dfo, 0, 10, 0, 10);
                            egVar.dfq.setText(aTv.getName());
                            com.baidu.tbadk.core.util.at.b(egVar.dfq, t.d.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.at.c(egVar.dfp, t.f.icon_frs_site);
                            egVar.dfo.setOnClickListener(new ea(this, lat, lng, name));
                        } else {
                            egVar.dfp.setVisibility(8);
                            egVar.dfq.setVisibility(8);
                        }
                        if (sVar.getAuthor() != null && sVar.getAuthor().getGodInfo() != null) {
                            egVar.ddC.gC(false);
                            ViewGroup.LayoutParams layoutParams4 = egVar.dfo.getLayoutParams();
                            if (layoutParams4 != null) {
                                layoutParams4.width = -2;
                                egVar.dfo.setLayoutParams(layoutParams4);
                            }
                            egVar.dfo.setVisibility(0);
                            View findViewWithTag = egVar.dfo.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(t.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(t.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                egVar.dfo.addView(textView, 0);
                            }
                            View findViewWithTag2 = egVar.dfo.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.at.b(textView2, t.d.cp_cont_d, 1);
                                textView2.setText(sVar.aTt());
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(t.e.ds20), 0);
                                egVar.dfo.addView(textView2, 1);
                            }
                            if (egVar.djY == null) {
                                egVar.dfp.setVisibility(8);
                                egVar.dfo.removeView(egVar.dfq);
                                egVar.djY = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams5.addRule(11);
                                layoutParams5.addRule(15);
                                egVar.dfq.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.icon_frs_site), (Drawable) null, (Drawable) null, (Drawable) null);
                                egVar.djY.addView(egVar.dfq, layoutParams5);
                                egVar.dfo.addView(egVar.djY, new LinearLayout.LayoutParams(-1, -2));
                                if (aTv != null && !TextUtils.isEmpty(aTv.getName()) && !TextUtils.isEmpty(aTv.getName().trim())) {
                                    egVar.dfq.setOnClickListener(new eb(this, aTv.getLat(), aTv.getLng(), aTv.getName()));
                                }
                            }
                            egVar.dfo.setOnClickListener(null);
                        }
                    } else {
                        egVar.ddD.setVisibility(8);
                        egVar.ddB.setVisibility(8);
                        egVar.ddE.setVisibility(8);
                        egVar.dfo.setVisibility(8);
                        egVar.dfr.setVisibility(8);
                    }
                    if (this.dfw.awi().awe()) {
                        egVar.ddA.setVisibility(8);
                    } else {
                        a(egVar.ddA, getDimensionPixelSize(t.e.ds30));
                    }
                    ((LinearLayout.LayoutParams) egVar.dff.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                    if (this.ddq.avv() != null && this.ddq.avv().tx() != null) {
                        com.baidu.tbadk.core.data.az tx = this.ddq.avv().tx();
                        String activityUrl = tx.getActivityUrl();
                        String uk = tx.uk();
                        String ul = tx.ul();
                        if (!StringUtils.isNull(ul)) {
                            egVar.dka.setVisibility(0);
                            egVar.dka.setText(ul);
                            egVar.dka.setOnClickListener(new ec(this, activityUrl));
                            egVar.dkb.setOnClickListener(new ed(this, activityUrl));
                            if (!StringUtils.isNull(uk)) {
                                egVar.bpI.setVisibility(0);
                                egVar.bpI.c(uk, 10, true);
                            }
                        } else {
                            return;
                        }
                    } else {
                        egVar.dka.setVisibility(8);
                        egVar.bpI.setVisibility(8);
                    }
                } else {
                    com.baidu.tbadk.core.util.at.l(egVar.deO, t.d.cp_bg_line_e);
                    egVar.bpI.setVisibility(8);
                    egVar.dka.setVisibility(8);
                    if (i == 1) {
                        if (this.ddr) {
                            egVar.deP.setVisibility(8);
                            egVar.deQ.setVisibility(8);
                            PraiseData praise2 = this.ddq.avv().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0 && !this.ddq.avv().tO()) {
                                egVar.deQ.setVisibility(8);
                                egVar.deP.setVisibility(0);
                            } else {
                                egVar.deQ.setVisibility(0);
                                egVar.deP.setVisibility(8);
                            }
                        } else {
                            egVar.deP.setVisibility(0);
                            egVar.deQ.setVisibility(8);
                        }
                    } else {
                        egVar.deP.setVisibility(0);
                        egVar.deQ.setVisibility(8);
                    }
                    egVar.deR.setVisibility(0);
                    com.baidu.tbadk.data.e aTv2 = sVar.aTv();
                    egVar.dfo.setVisibility(8);
                    if (aTv2 != null && !TextUtils.isEmpty(aTv2.getName()) && !TextUtils.isEmpty(aTv2.getName().trim())) {
                        String name2 = aTv2.getName();
                        String lat2 = aTv2.getLat();
                        String lng2 = aTv2.getLng();
                        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) egVar.dfr.getLayoutParams();
                        if (layoutParams6 != null) {
                            if (!this.ddp) {
                                layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds74);
                            } else {
                                layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds104);
                            }
                            egVar.dfr.setLayoutParams(layoutParams6);
                        }
                        egVar.dfr.setVisibility(0);
                        egVar.dft.setText(aTv2.getName());
                        com.baidu.tbadk.core.util.at.b(egVar.dft, t.d.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.at.c(egVar.dfs, t.f.icon_frs_site);
                        egVar.dfr.setOnClickListener(new ee(this, lat2, lng2, name2));
                    } else {
                        egVar.dfr.setVisibility(8);
                    }
                    egVar.ddC.setVisibility(8);
                    egVar.ddD.setVisibility(8);
                    egVar.ddB.setVisibility(8);
                    egVar.ddE.setVisibility(8);
                    egVar.dfb.setVisibility(0);
                    egVar.deY.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTs()));
                    egVar.deX.setVisibility(0);
                    egVar.deX.setText(format);
                    LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) egVar.dff.getLayoutParams();
                    if (!this.ddp) {
                        a(egVar.ddA, getDimensionPixelSize(t.e.ds74));
                        layoutParams7.leftMargin = getDimensionPixelSize(t.e.ds74);
                    } else {
                        a(egVar.ddA, getDimensionPixelSize(t.e.ds104));
                        layoutParams7.leftMargin = getDimensionPixelSize(t.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) egVar.dfc.getLayoutParams();
                    if (!this.ddp) {
                        layoutParams8.leftMargin = 0;
                    } else {
                        layoutParams8.leftMargin = getDimensionPixelSize(t.e.ds30);
                    }
                }
                if (this.deG != null && !this.deG.equals("0") && this.deG.equals(sVar.getAuthor().getUserId())) {
                    egVar.deZ.setVisibility(0);
                    com.baidu.tbadk.core.util.at.c(egVar.deZ, t.f.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.at.k(egVar.deS, t.f.bg_floor_new_middle);
            egVar.ddA.setVideoImageId(t.f.pic_video);
            egVar.ddA.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.at.c(egVar.dfa, t.f.btn_pb_more_selector);
            egVar.ddA.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) egVar.dfa.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                egVar.dfa.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            SparseArray sparseArray5 = (SparseArray) egVar.diq.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                egVar.diq.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, sVar);
            sparseArray5.put(t.g.tag_load_sub_data, sVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            if (sVar.aTw() > 0) {
                if (this.deH == null) {
                    this.deH = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.deH.setIsFromCDN(this.mIsFromCDN);
                    this.deH.N(this.deJ);
                    boolean z7 = false;
                    String userId2 = this.ddq.avv().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.deH.t(this.ddq.avB(), z7);
                    this.deH.h(this.ddq.avv());
                    this.deH.fR(this.ddp);
                }
                egVar.dfe.setVisibility(0);
                egVar.dfd.setVisibility(0);
                egVar.dfc.setVisibility(0);
                egVar.dfe.a(sVar, view);
                egVar.dfe.setChildOnClickListener(this.brL);
                egVar.dfe.setChildOnLongClickListener(this.aoa);
                egVar.dfe.setChildOnTouchListener(this.dds);
                egVar.dfe.setSubPbAdapter(this.deH);
                egVar.dfe.setVisibility(0);
            } else {
                egVar.dfe.setVisibility(8);
                egVar.dfd.setVisibility(8);
                egVar.dfc.setVisibility(8);
            }
            a(egVar, sVar, this.ddq.avE(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.r.go(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.r.d(name_show, 0, 14)) + "...";
                    }
                    egVar.aPp.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.at.b(egVar.aPp, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.at.b(egVar.aPp, t.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        egVar.deU.setVisibility(0);
                        com.baidu.tbadk.core.util.at.c(egVar.deU, BitmapHelper.getGradeResourceIdNew(level_id));
                        String aTF = sVar.aTF();
                        if (StringUtils.isNull(aTF)) {
                            aTF = String.format(TbadkCoreApplication.m411getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id));
                        }
                        egVar.deU.setContentDescription(aTF);
                        egVar.deU.setOnClickListener(null);
                    } else {
                        egVar.deU.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.at.c(egVar.deV, t.f.pb_manager);
                            egVar.deU.setVisibility(8);
                            egVar.deV.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.at.c(egVar.deV, t.f.pb_assist);
                            egVar.deU.setVisibility(8);
                            egVar.deV.setVisibility(0);
                        }
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.at.c(egVar.deW, t.f.icon_pb_pop_girl);
                        egVar.deW.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.at.c(egVar.deW, t.f.icon_pb_pop_boy);
                        egVar.deW.setVisibility(0);
                    } else {
                        egVar.deW.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.r.go(sVar.getAuthor().getName_show()) >= 14 && egVar.deU.getVisibility() == 0 && egVar.deZ.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.deI = sVar.getAuthor().getIconInfo();
                    this.bjm = sVar.getAuthor().getTShowInfoNew();
                    if (egVar.bvK != null) {
                        egVar.bvK.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                        egVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
                        egVar.bvK.a(this.deI, i2, getDimensionPixelSize(t.e.pb_icon_width), getDimensionPixelSize(t.e.pb_icon_height), getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (egVar.ahN != null) {
                        egVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
                        if (this.bjm != null && this.bjm.size() > 0 && this.bjm.get(0) != null) {
                            egVar.ahN.setTag(this.bjm.get(0).getUrl());
                        }
                        egVar.ahN.a(this.bjm, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.small_icon_margin), true);
                    }
                }
                if (f(sVar)) {
                    if (this.ddp) {
                        egVar.deT.setVisibility(4);
                        egVar.djZ.setVisibility(0);
                    }
                    egVar.djZ.c(portrait, 28, false);
                    egVar.djZ.setUserId(sVar.getAuthor().getUserId());
                    egVar.djZ.af(sVar.getAuthor().getUserName(), sVar.aTE());
                    egVar.djZ.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
                } else {
                    if (this.ddp) {
                        egVar.deT.setVisibility(0);
                    }
                    egVar.djZ.setVisibility(8);
                    egVar.deT.setUserId(sVar.getAuthor().getUserId());
                    egVar.deT.af(sVar.getAuthor().getUserName(), sVar.aTE());
                    egVar.deT.setImageDrawable(null);
                    egVar.deT.c(portrait, 28, false);
                }
                egVar.aPp.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                egVar.aPp.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            }
            egVar.ddA.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            if (this.ddo) {
                egVar.ddA.setDefaultImageId(t.f.transparent_bg);
            } else {
                egVar.ddA.setDefaultImageId(t.f.icon_click);
            }
            egVar.ddA.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                amn = null;
            } else {
                amn = sVar.amn();
            }
            if (this.ddw || !this.ddx) {
                egVar.ddA.a(amn, false);
            } else {
                egVar.ddA.a(amn, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.ddq.avB() != 0) {
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
            if (this.ddq != null && this.ddq.avv() != null && this.ddq.avv().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.ddq.avv().getAuthor().getUserId();
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
                        if (egVar.dfj != null) {
                            egVar.dfj.setVisibility(0);
                            egVar.dfj.setText(t.j.manage);
                            egVar.dfj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (egVar.dfj != null) {
                            egVar.dfj.setVisibility(0);
                            egVar.dfj.setText(t.j.delete);
                            egVar.dfj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (egVar.dfj != null) {
                        egVar.dfj.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.aTs() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ddq.avB()));
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
                        if (this.ddq.avv() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.ddq.avv().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ddq.avB()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        egVar.dfa.setVisibility(8);
                        com.baidu.tbadk.core.util.at.b(egVar.dfh, t.d.subpb_listitem_time, 1);
                        egVar.dfh.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), sVar.aTt()));
                        if (egVar.dfj.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.at.b(egVar.dfj, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            egVar.dfj.setTag(sparseArray);
                            egVar.dfj.setOnClickListener(this.deJ);
                        }
                    }
                    aTD = sVar.aTD();
                    if (aTD.size() > 0 || (sVar.aTs() == 1 && this.dfw.awi().awe())) {
                        egVar.dkc.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.a aVar = aTD.get(0);
                        if (!StringUtils.isNull(aVar.getIconUrl())) {
                            egVar.dkc.setScaleType(ImageView.ScaleType.FIT_XY);
                            egVar.dkc.c(aVar.getIconUrl(), 10, true);
                            egVar.dkc.setVisibility(0);
                            if (!StringUtils.isNull(aVar.Cz())) {
                                egVar.dkc.setTag(t.g.tag_pb_lottery_tail_link, aVar.Cz());
                            }
                        }
                    }
                    a(egVar, sVar, sVar.aTs() != 1, amn);
                    b(egVar);
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
            if (sVar.aTs() == 1) {
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
            aTD = sVar.aTD();
            if (aTD.size() > 0) {
            }
            egVar.dkc.setVisibility(8);
            a(egVar, sVar, sVar.aTs() != 1, amn);
            b(egVar);
        }
    }

    private void b(eg egVar) {
        egVar.ddA.setTextViewOnTouchListener(this.dds);
        egVar.ddA.setTextViewCheckSelection(false);
    }

    private void a(eg egVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAu() == null) {
            egVar.dfu.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(sVar.aAu(), egVar.dfu, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ddv - (i - this.ddt));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(eg egVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.aTx() > 0 && sVar.aTr() != null) {
            egVar.dfg.setVisibility(0);
            egVar.dfg.removeViews(0, egVar.dfg.getChildCount() - 1);
            int size = sVar.aTr().size();
            int aTy = sVar.aTy();
            for (int i2 = 0; i2 < aTy; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.aTr().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) egVar.dfg, false);
                eg egVar2 = new eg(inflate, this.ddp, this.ddo, this.ddn, true);
                c(egVar2);
                a(egVar2, sVar2, (View) egVar.dfg, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, sVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.ddo) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    egVar2.ddA.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) egVar2.ddA.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    egVar2.ddA.setLayoutParams(layoutParams);
                    egVar2.ddA.setPadding(0, 0, 0, 0);
                    egVar.ddA.gu(null);
                } else {
                    egVar.ddA.gu(sVar.getBimg_url());
                    egVar2.ddA.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) egVar2.ddA.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    egVar2.ddA.setLayoutParams(layoutParams2);
                }
                egVar.dfg.addView(inflate, egVar.dfg.getChildCount() - 1);
            }
            if (aTy < size) {
                egVar.dfk.setVisibility(0);
                com.baidu.tbadk.core.util.at.k(egVar.dfm, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.k(egVar.dfn, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.b(egVar.dfl, t.d.cp_cont_f, 1);
                egVar.dfk.setOnClickListener(new ef(this, aTy, size, sVar));
                return;
            }
            egVar.dfk.setVisibility(8);
            return;
        }
        egVar.dfg.setVisibility(8);
    }

    private boolean f(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (sVar == null || sVar.getAuthor() == null || sVar.getAuthor().getGodUserData() == null || sVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void c(eg egVar) {
        egVar.aPp.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        egVar.dfa.setOnClickListener(this.brL);
        egVar.deT.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        egVar.dfb.setOnLongClickListener(this.aoa);
        egVar.ddA.setOnLongClickListener(this.aoa);
        egVar.dfb.setOnTouchListener(this.dds);
        egVar.ddA.setOnTouchListener(this.dds);
        egVar.ddA.setOnImageClickListener(this.aJc);
        egVar.ddA.setOnEmotionClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dny);
        egVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
        egVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
        egVar.dfu.setOnClickListener(this.brL);
        egVar.dkc.setOnClickListener(this.brL);
        egVar.diq.setOnClickListener(this.brL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.ddq = eVar;
    }

    public void lP(int i) {
        this.ddn = i;
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void fR(boolean z) {
        this.ddp = z;
    }

    public void fS(boolean z) {
        this.ddr = z;
    }

    public void lM(String str) {
        this.deG = str;
    }

    public void L(View.OnClickListener onClickListener) {
        this.deJ = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }
}
