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
public class de extends cl<com.baidu.tieba.tbadkCore.data.r, dl> implements View.OnClickListener {
    private TbRichTextView.d aGi;
    private View.OnLongClickListener anJ;
    private ArrayList<IconData> beA;
    private View.OnClickListener bmy;
    private int cJW;
    private boolean cJX;
    private boolean cJY;
    private com.baidu.tieba.pb.a.c cJZ;
    private boolean cKa;
    private com.baidu.tieba.pb.b.c cKb;
    private int cKc;
    private int cKd;
    private boolean cKe;
    private final boolean cKf;
    private String cLq;
    private com.baidu.tieba.pb.pb.sub.am cLr;
    private ArrayList<IconData> cLs;
    private View.OnClickListener cLt;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cJW = 0;
        this.cJX = true;
        this.cJY = true;
        this.cKa = true;
        this.cJZ = null;
        this.cLq = null;
        this.cLr = null;
        this.cLs = null;
        this.beA = null;
        this.cLt = null;
        this.bmy = null;
        this.aGi = null;
        this.cKb = null;
        this.anJ = null;
        this.cKe = false;
        this.cKf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cKc = getDimensionPixelSize(t.e.ds30);
        this.cKd = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    private void a(dl dlVar) {
        if (dlVar != null) {
            if (dlVar.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ar.l(dlVar.cLz, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.l(dlVar.cLA, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.b(dlVar.cLR, t.d.subpb_listitem_time, 1);
                com.baidu.tbadk.core.util.ar.b(dlVar.cLT, t.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.ar.b(dlVar.aMu, t.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ar.b((View) dlVar.cLE, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ar.b((View) dlVar.cLF, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ar.b(dlVar.cLH, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ar.b(dlVar.cLI, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ar.c(dlVar.cLK, t.f.btn_pb_more_selector);
                com.baidu.tbadk.core.util.ar.c(dlVar.cOj, t.f.btn_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.ar.l(dlVar.cKj, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.l(dlVar.cKl, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ar.l(dlVar.cKm, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ar.c(dlVar.cKm, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.c(dlVar.cLN, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.k(dlVar.cPK, t.f.btn_appdownload);
                com.baidu.tbadk.core.util.ar.b(dlVar.cPK, t.d.cp_cont_i, 1);
            }
            dlVar.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public dl b(ViewGroup viewGroup) {
        dl dlVar = new dl(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.cJY, this.cJX, this.cJW, false);
        a(dlVar);
        return dlVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, dl dlVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) dlVar);
        a(dlVar);
        c(dlVar);
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) aG(i);
        if (rVar2 != null) {
            a(dlVar, rVar2, view, false, i);
        }
        if (!this.cKe && this.cKf && dlVar != null && dlVar.cKi.HB() && (listView = ((PbActivity) this.cNL.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cKe = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:193:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0804  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0810  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0838  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x08c7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0c8b  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0cbb  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0cc7  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0cd3  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0cdf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(dl dlVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (dlVar != null && rVar != null) {
            if (!z) {
                dlVar.cLD.setTag(null);
                dlVar.cLD.setUserId(null);
                dlVar.aMu.setText((CharSequence) null);
                dlVar.cLF.setVisibility(8);
                dlVar.cLO.setVisibility(0);
                dlVar.cLK.setVisibility(0);
                dlVar.cLJ.setVisibility(8);
                if (rVar.aMx() == null) {
                    dlVar.cLP.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && rVar.aMx().BX() == 1) {
                    dlVar.cLP.changeSkinType(this.mSkinType);
                    dlVar.cLP.setVisibility(0);
                    dlVar.cLP.setData(rVar.aMx());
                } else {
                    dlVar.cLP.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) dlVar.cLL.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    dlVar.cLL.setTag(sparseArray2);
                    dlVar.cKi.setTag(sparseArray2);
                }
                sparseArray2.put(t.g.tag_clip_board, rVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                a(dlVar.cKi, getDimensionPixelSize(t.e.ds30));
                if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cJX) {
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dlVar.cKi.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    dlVar.cKi.setLayoutParams(layoutParams);
                    dlVar.cKi.setPadding(0, 0, 0, 0);
                    dlVar.cKi.gi(null);
                    dlVar.cKi.setBackgroundDrawable(null);
                } else {
                    sparseArray2.put(t.g.tag_richtext_bg, rVar.getBimg_url());
                    dlVar.cKi.gi(rVar.getBimg_url());
                    if (rVar.aMw() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dlVar.cKi.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds40);
                        dlVar.cKi.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) dlVar.cKi.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(t.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(t.e.ds20);
                        dlVar.cKi.setLayoutParams(layoutParams3);
                    }
                }
                dlVar.cLI.setText(com.baidu.tbadk.core.util.aw.t(rVar.getTime()));
                if (rVar.aMw() == 1) {
                    com.baidu.tbadk.core.util.ar.l(dlVar.cLy, t.d.cp_bg_line_d);
                    dlVar.cLz.setVisibility(8);
                    dlVar.cLA.setVisibility(8);
                    dlVar.cLB.setVisibility(8);
                    dlVar.cLL.setVisibility(8);
                    dlVar.cLI.setVisibility(8);
                    dlVar.cKk.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (rVar.getAuthor() != null) {
                        j = rVar.getAuthor().getUserIdLong();
                        str = rVar.getAuthor().getUserName();
                    }
                    dlVar.cKk.a(rVar.aME(), str, j, com.baidu.adp.lib.h.b.c(this.cJZ.aoF().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                    dlVar.cKk.uv();
                    if (this.cKa) {
                        PraiseData praise = this.cJZ.aoF().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            dlVar.cKl.setVisibility(0);
                            dlVar.cKj.setVisibility(0);
                            dlVar.cKm.setVisibility(0);
                            dlVar.cKl.setIsFromPb(true);
                            dlVar.cKl.a(praise, this.cJZ.aoF().getId(), praise.getPostId(), true);
                            dlVar.cKl.dk(this.mSkinType);
                        } else {
                            dlVar.cKl.setVisibility(8);
                            dlVar.cKj.setVisibility(8);
                            dlVar.cKm.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aMy = rVar.aMy();
                        dlVar.cMb.setVisibility(8);
                        if (aMy != null && !TextUtils.isEmpty(aMy.getName()) && !TextUtils.isEmpty(aMy.getName().trim())) {
                            String name = aMy.getName();
                            String lat = aMy.getLat();
                            String lng = aMy.getLng();
                            dlVar.cLY.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, dlVar.cLY, 0, 10, 0, 10);
                            dlVar.cMa.setText(aMy.getName());
                            com.baidu.tbadk.core.util.ar.b(dlVar.cMa, t.d.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.ar.c(dlVar.cLZ, t.f.icon_frs_site);
                            dlVar.cLY.setOnClickListener(new df(this, lat, lng, name));
                        } else {
                            dlVar.cLZ.setVisibility(8);
                            dlVar.cMa.setVisibility(8);
                        }
                        if (rVar.getAuthor() != null && rVar.getAuthor().getGodInfo() != null) {
                            dlVar.cKk.fO(false);
                            ViewGroup.LayoutParams layoutParams4 = dlVar.cLY.getLayoutParams();
                            if (layoutParams4 != null) {
                                layoutParams4.width = -2;
                                dlVar.cLY.setLayoutParams(layoutParams4);
                            }
                            dlVar.cLY.setVisibility(0);
                            View findViewWithTag = dlVar.cLY.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(t.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(t.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                dlVar.cLY.addView(textView, 0);
                            }
                            View findViewWithTag2 = dlVar.cLY.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(t.e.fontsize24));
                                com.baidu.tbadk.core.util.ar.b(textView2, t.d.cp_cont_d, 1);
                                textView2.setText(com.baidu.tbadk.core.util.aw.t(rVar.getTime()));
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(t.e.ds20), 0);
                                dlVar.cLY.addView(textView2, 1);
                            }
                            if (dlVar.cPI == null) {
                                dlVar.cLZ.setVisibility(8);
                                dlVar.cLY.removeView(dlVar.cMa);
                                dlVar.cPI = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams5.addRule(11);
                                layoutParams5.addRule(15);
                                dlVar.cMa.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.icon_frs_site), (Drawable) null, (Drawable) null, (Drawable) null);
                                dlVar.cPI.addView(dlVar.cMa, layoutParams5);
                                dlVar.cLY.addView(dlVar.cPI, new LinearLayout.LayoutParams(-1, -2));
                                if (aMy != null && !TextUtils.isEmpty(aMy.getName()) && !TextUtils.isEmpty(aMy.getName().trim())) {
                                    dlVar.cMa.setOnClickListener(new dg(this, aMy.getLat(), aMy.getLng(), aMy.getName()));
                                }
                            }
                            dlVar.cLY.setOnClickListener(null);
                        }
                    } else {
                        dlVar.cKl.setVisibility(8);
                        dlVar.cKj.setVisibility(8);
                        dlVar.cKm.setVisibility(8);
                        dlVar.cLY.setVisibility(8);
                        dlVar.cMb.setVisibility(8);
                    }
                    a(dlVar.cKi, getDimensionPixelSize(t.e.ds30));
                    ((LinearLayout.LayoutParams) dlVar.cLP.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                    if (this.cJZ.aoF() != null && this.cJZ.aoF().tu() != null) {
                        com.baidu.tbadk.core.data.ao tu = this.cJZ.aoF().tu();
                        String activityUrl = tu.getActivityUrl();
                        String ue = tu.ue();
                        String uf = tu.uf();
                        if (!StringUtils.isNull(uf)) {
                            dlVar.cPK.setVisibility(0);
                            dlVar.cPK.setText(uf);
                            dlVar.cPK.setOnClickListener(new dh(this, activityUrl));
                            dlVar.cPL.setOnClickListener(new di(this, activityUrl));
                            if (!StringUtils.isNull(ue)) {
                                dlVar.bkt.setVisibility(0);
                                dlVar.bkt.d(ue, 10, true);
                            }
                        } else {
                            return;
                        }
                    } else {
                        dlVar.cPK.setVisibility(8);
                        dlVar.bkt.setVisibility(8);
                    }
                } else {
                    com.baidu.tbadk.core.util.ar.l(dlVar.cLy, t.d.cp_bg_line_e);
                    dlVar.bkt.setVisibility(8);
                    dlVar.cPK.setVisibility(8);
                    if (i == 1) {
                        if (this.cKa) {
                            dlVar.cLz.setVisibility(8);
                            dlVar.cLA.setVisibility(8);
                            PraiseData praise2 = this.cJZ.aoF().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0 && !this.cJZ.aoF().tJ()) {
                                dlVar.cLA.setVisibility(8);
                                dlVar.cLz.setVisibility(0);
                            } else {
                                dlVar.cLA.setVisibility(0);
                                dlVar.cLz.setVisibility(8);
                            }
                        } else {
                            dlVar.cLz.setVisibility(0);
                            dlVar.cLA.setVisibility(8);
                        }
                    } else {
                        dlVar.cLz.setVisibility(0);
                        dlVar.cLA.setVisibility(8);
                    }
                    dlVar.cLB.setVisibility(0);
                    com.baidu.tbadk.data.d aMy2 = rVar.aMy();
                    dlVar.cLY.setVisibility(8);
                    if (aMy2 != null && !TextUtils.isEmpty(aMy2.getName()) && !TextUtils.isEmpty(aMy2.getName().trim())) {
                        String name2 = aMy2.getName();
                        String lat2 = aMy2.getLat();
                        String lng2 = aMy2.getLng();
                        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) dlVar.cMb.getLayoutParams();
                        if (layoutParams6 != null) {
                            if (!this.cJY) {
                                layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds74);
                            } else {
                                layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds104);
                            }
                            dlVar.cMb.setLayoutParams(layoutParams6);
                        }
                        dlVar.cMb.setVisibility(0);
                        dlVar.cMd.setText(aMy2.getName());
                        com.baidu.tbadk.core.util.ar.b(dlVar.cMd, t.d.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.ar.c(dlVar.cMc, t.f.icon_frs_site);
                        dlVar.cMb.setOnClickListener(new dj(this, lat2, lng2, name2));
                    } else {
                        dlVar.cMb.setVisibility(8);
                    }
                    dlVar.cKk.setVisibility(8);
                    dlVar.cKl.setVisibility(8);
                    dlVar.cKj.setVisibility(8);
                    dlVar.cKm.setVisibility(8);
                    dlVar.cLL.setVisibility(0);
                    dlVar.cLI.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(rVar.aMw()));
                    dlVar.cLH.setVisibility(0);
                    dlVar.cLH.setText(format);
                    LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) dlVar.cLP.getLayoutParams();
                    if (!this.cJY) {
                        a(dlVar.cKi, getDimensionPixelSize(t.e.ds74));
                        layoutParams7.leftMargin = getDimensionPixelSize(t.e.ds74);
                    } else {
                        a(dlVar.cKi, getDimensionPixelSize(t.e.ds104));
                        layoutParams7.leftMargin = getDimensionPixelSize(t.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) dlVar.cLM.getLayoutParams();
                    if (!this.cJY) {
                        layoutParams8.leftMargin = 0;
                    } else {
                        layoutParams8.leftMargin = getDimensionPixelSize(t.e.ds30);
                    }
                }
                if (this.cLq != null && !this.cLq.equals("0") && this.cLq.equals(rVar.getAuthor().getUserId())) {
                    dlVar.cLJ.setVisibility(0);
                    com.baidu.tbadk.core.util.ar.c(dlVar.cLJ, t.f.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.ar.k(dlVar.cLC, t.f.bg_floor_new_middle);
            dlVar.cKi.setVideoImageId(t.f.pic_video);
            dlVar.cKi.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.ar.c(dlVar.cLK, t.f.btn_pb_more_selector);
            dlVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) dlVar.cLK.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                dlVar.cLK.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, rVar);
            sparseArray.put(t.g.tag_load_sub_data, rVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            SparseArray sparseArray5 = (SparseArray) dlVar.cOj.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                dlVar.cOj.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, rVar);
            sparseArray5.put(t.g.tag_load_sub_data, rVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            if (rVar.aMz() > 0) {
                if (this.cLr == null) {
                    this.cLr = new com.baidu.tieba.pb.pb.sub.am(this.mContext);
                    this.cLr.setIsFromCDN(this.mIsFromCDN);
                    this.cLr.J(this.cLt);
                    boolean z7 = false;
                    String userId2 = this.cJZ.aoF().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cLr.t(this.cJZ.aoJ(), z7);
                    this.cLr.h(this.cJZ.aoF());
                    this.cLr.fh(this.cJY);
                }
                dlVar.cLO.setVisibility(0);
                dlVar.cLN.setVisibility(0);
                dlVar.cLM.setVisibility(0);
                dlVar.cLO.a(rVar, view);
                dlVar.cLO.setChildOnClickListener(this.bmy);
                dlVar.cLO.setChildOnLongClickListener(this.anJ);
                dlVar.cLO.setChildOnTouchListener(this.cKb);
                dlVar.cLO.setSubPbAdapter(this.cLr);
                dlVar.cLO.setVisibility(0);
            } else {
                dlVar.cLO.setVisibility(8);
                dlVar.cLN.setVisibility(8);
                dlVar.cLM.setVisibility(8);
            }
            a(dlVar, rVar, this.cJZ.aoM(), i);
            if (!z) {
                String portrait = rVar.getAuthor().getPortrait();
                if (rVar.getAuthor() != null) {
                    String name_show = rVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.o.gf(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.o.d(name_show, 0, 14)) + "...";
                    }
                    dlVar.aMu.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.ar.b(dlVar.aMu, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ar.b(dlVar.aMu, t.d.cp_cont_f, 1);
                    }
                    int level_id = rVar.getAuthor().getLevel_id();
                    int is_bawu = rVar.getAuthor().getIs_bawu();
                    String bawu_type = rVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        dlVar.cLE.setVisibility(0);
                        com.baidu.tbadk.core.util.ar.c(dlVar.cLE, BitmapHelper.getGradeResourceIdNew(level_id));
                        dlVar.cLE.setOnClickListener(null);
                    } else {
                        dlVar.cLE.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ar.c(dlVar.cLF, t.f.pb_manager);
                            dlVar.cLE.setVisibility(8);
                            dlVar.cLF.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ar.c(dlVar.cLF, t.f.pb_assist);
                            dlVar.cLE.setVisibility(8);
                            dlVar.cLF.setVisibility(0);
                        }
                    }
                    if (rVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.ar.c(dlVar.cLG, t.f.icon_pb_pop_girl);
                        dlVar.cLG.setVisibility(0);
                    } else if (rVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.ar.c(dlVar.cLG, t.f.icon_pb_pop_boy);
                        dlVar.cLG.setVisibility(0);
                    } else {
                        dlVar.cLG.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.o.gf(rVar.getAuthor().getName_show()) >= 14 && dlVar.cLE.getVisibility() == 0 && dlVar.cLJ.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cLs = rVar.getAuthor().getIconInfo();
                    this.beA = rVar.getAuthor().getTShowInfoNew();
                    if (dlVar.bqH != null) {
                        dlVar.bqH.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                        dlVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
                        dlVar.bqH.a(this.cLs, i2, getDimensionPixelSize(t.e.pb_icon_width), getDimensionPixelSize(t.e.pb_icon_height), getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (dlVar.ahI != null) {
                        dlVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
                        if (this.beA != null && this.beA.size() > 0 && this.beA.get(0) != null) {
                            dlVar.ahI.setTag(this.beA.get(0).getUrl());
                        }
                        dlVar.ahI.a(this.beA, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.small_icon_margin), true);
                    }
                }
                if (f(rVar)) {
                    if (this.cJY) {
                        dlVar.cLD.setVisibility(4);
                        dlVar.cPJ.setVisibility(0);
                    }
                    dlVar.cPJ.d(portrait, 28, false);
                    dlVar.cPJ.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                    dlVar.cPJ.setTag(t.g.tag_user_name, rVar.getAuthor().getUserName());
                    dlVar.cPJ.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
                } else {
                    if (this.cJY) {
                        dlVar.cLD.setVisibility(0);
                    }
                    dlVar.cPJ.setVisibility(8);
                    dlVar.cLD.setUserId(rVar.getAuthor().getUserId());
                    dlVar.cLD.setUserName(rVar.getAuthor().getUserName());
                    dlVar.cLD.setImageDrawable(null);
                    dlVar.cLD.d(portrait, 28, false);
                }
                dlVar.aMu.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                dlVar.aMu.setTag(t.g.tag_user_name, rVar.getAuthor().getUserName());
            }
            dlVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            if (this.cJX) {
                dlVar.cKi.setDefaultImageId(t.f.img_default_100);
            } else {
                dlVar.cKi.setDefaultImageId(t.f.icon_click);
            }
            dlVar.cKi.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aiT();
            }
            if (this.cKe || !this.cKf) {
                dlVar.cKi.a(aVar, false);
            } else {
                dlVar.cKi.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cJZ.aoJ() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = rVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.cJZ != null && this.cJZ.aoF() != null && this.cJZ.aoF().getAuthor() != null && rVar.getAuthor() != null) {
                String userId4 = this.cJZ.aoF().getAuthor().getUserId();
                String userId5 = rVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = rVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (dlVar.cLT != null) {
                            dlVar.cLT.setVisibility(0);
                            dlVar.cLT.setText(t.j.manage);
                            dlVar.cLT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (dlVar.cLT != null) {
                            dlVar.cLT.setVisibility(0);
                            dlVar.cLT.setText(t.j.delete);
                            dlVar.cLT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (dlVar.cLT != null) {
                        dlVar.cLT.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (rVar.aMw() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cJZ.aoJ()));
                        sparseArray.put(t.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                        }
                        if (this.cJZ.aoF() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.cJZ.aoF().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, rVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cJZ.aoJ()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, rVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        dlVar.cLK.setVisibility(8);
                        com.baidu.tbadk.core.util.ar.b(dlVar.cLR, t.d.subpb_listitem_time, 1);
                        dlVar.cLR.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), com.baidu.tbadk.core.util.aw.t(rVar.getTime())));
                        if (dlVar.cLT.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.ar.b(dlVar.cLT, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            dlVar.cLT.setTag(sparseArray);
                            dlVar.cLT.setOnClickListener(this.cLt);
                        }
                    }
                    a(dlVar, rVar, rVar.aMw() != 1, aVar);
                    b(dlVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = rVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (rVar.aMw() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(dlVar, rVar, rVar.aMw() != 1, aVar);
            b(dlVar);
        }
    }

    private void b(dl dlVar) {
        dlVar.cKi.setTextViewOnTouchListener(this.cKb);
        dlVar.cKi.setTextViewCheckSelection(false);
    }

    private void a(dl dlVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar == null || rVar.asK() == null) {
            dlVar.cMe.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar.asK(), dlVar.cMe, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cKd - (i - this.cKc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(dl dlVar, com.baidu.tieba.tbadkCore.data.r rVar, AdditionData additionData, int i) {
        if (rVar.aMA() > 0 && rVar.aMv() != null) {
            dlVar.cLQ.setVisibility(0);
            dlVar.cLQ.removeViews(0, dlVar.cLQ.getChildCount() - 1);
            int size = rVar.aMv().size();
            int aMB = rVar.aMB();
            for (int i2 = 0; i2 < aMB; i2++) {
                com.baidu.tieba.tbadkCore.data.r rVar2 = rVar.aMv().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) dlVar.cLQ, false);
                dl dlVar2 = new dl(inflate, this.cJY, this.cJX, this.cJW, true);
                c(dlVar2);
                a(dlVar2, rVar2, (View) dlVar.cLQ, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, rVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(rVar2.getBimg_url()) || !this.cJX) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    dlVar2.cKi.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dlVar2.cKi.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    dlVar2.cKi.setLayoutParams(layoutParams);
                    dlVar2.cKi.setPadding(0, 0, 0, 0);
                    dlVar.cKi.gi(null);
                } else {
                    dlVar.cKi.gi(rVar.getBimg_url());
                    dlVar2.cKi.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dlVar2.cKi.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    dlVar2.cKi.setLayoutParams(layoutParams2);
                }
                dlVar.cLQ.addView(inflate, dlVar.cLQ.getChildCount() - 1);
            }
            if (aMB < size) {
                dlVar.cLU.setVisibility(0);
                com.baidu.tbadk.core.util.ar.k(dlVar.cLW, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.k(dlVar.cLX, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.b(dlVar.cLV, t.d.cp_cont_f, 1);
                dlVar.cLU.setOnClickListener(new dk(this, aMB, size, rVar));
                return;
            }
            dlVar.cLU.setVisibility(8);
            return;
        }
        dlVar.cLQ.setVisibility(8);
    }

    private boolean f(com.baidu.tieba.tbadkCore.data.r rVar) {
        return (rVar == null || rVar.getAuthor() == null || rVar.getAuthor().getGodUserData() == null || rVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void c(dl dlVar) {
        dlVar.aMu.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        dlVar.cLK.setOnClickListener(this.bmy);
        dlVar.cLD.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        dlVar.cLL.setOnLongClickListener(this.anJ);
        dlVar.cKi.setOnLongClickListener(this.anJ);
        dlVar.cLL.setOnTouchListener(this.cKb);
        dlVar.cKi.setOnTouchListener(this.cKb);
        dlVar.cKi.setOnImageClickListener(this.aGi);
        dlVar.cKi.setOnEmotionClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSG);
        dlVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
        dlVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
        dlVar.cMe.setOnClickListener(this.bmy);
        dlVar.cOj.setOnClickListener(this.bmy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cJZ = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cJW = i;
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void fh(boolean z) {
        this.cJY = z;
    }

    public void fi(boolean z) {
        this.cKa = z;
    }

    public void kz(String str) {
        this.cLq = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.cLt = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }
}
