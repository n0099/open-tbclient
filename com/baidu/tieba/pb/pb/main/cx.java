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
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cx extends ce<com.baidu.tieba.tbadkCore.data.r, dc> implements View.OnClickListener {
    private TbRichTextView.d aFq;
    private View.OnLongClickListener amQ;
    private ArrayList<IconData> bcl;
    private View.OnClickListener bjD;
    private boolean cDQ;
    private com.baidu.tieba.pb.a.c cDR;
    private String cDX;
    private com.baidu.tieba.pb.pb.sub.am cDY;
    private ArrayList<IconData> cDZ;
    private int cDq;
    private boolean cDr;
    private boolean cDs;
    private com.baidu.tieba.pb.b.c cDu;
    private boolean cDw;
    private final boolean cDx;
    private int cDy;
    private int cDz;
    private View.OnClickListener cEa;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cDq = 0;
        this.cDr = true;
        this.cDQ = true;
        this.cDs = true;
        this.cDR = null;
        this.cDX = null;
        this.cDY = null;
        this.cDZ = null;
        this.bcl = null;
        this.cEa = null;
        this.bjD = null;
        this.aFq = null;
        this.cDu = null;
        this.amQ = null;
        this.cDw = false;
        this.cDx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cDy = getDimensionPixelSize(n.e.ds30);
        this.cDz = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(n.e.ds60);
    }

    private void a(dc dcVar) {
        if (dcVar != null) {
            if (dcVar.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                com.baidu.tbadk.core.util.as.j(dcVar.cEj, n.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.j(dcVar.cEk, n.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.b(dcVar.cEA, n.d.subpb_listitem_time, 1);
                com.baidu.tbadk.core.util.as.b(dcVar.cEC, n.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.as.b(dcVar.aLp, n.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.as.b((View) dcVar.cEo, n.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.as.b((View) dcVar.cEp, n.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.as.b(dcVar.cEr, n.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.as.b(dcVar.bIB, n.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.as.c(dcVar.cEt, n.f.btn_pb_more_selector);
                com.baidu.tbadk.core.util.as.c(dcVar.cGF, n.f.btn_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.as.j(dcVar.cDE, n.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.j(dcVar.cDF, n.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.as.j(dcVar.cDG, n.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.as.c(dcVar.cDG, n.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.c(dcVar.cEw, n.d.cp_bg_line_b);
            }
            dcVar.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public dc a(ViewGroup viewGroup) {
        dc dcVar = new dc(LayoutInflater.from(this.mContext).inflate(n.h.new_pb_list_item, viewGroup, false), this.cDQ, this.cDr, this.cDq, false);
        a(dcVar);
        return dcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, dc dcVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) dcVar);
        a(dcVar);
        c(dcVar);
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) au(i);
        if (rVar2 != null) {
            a(dcVar, rVar2, view, false, i);
        }
        if (!this.cDw && this.cDx && dcVar != null && dcVar.cDC.Gc() && (listView = ((PbActivity) this.cGj.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cDw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0832  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0b91  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0bc1  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0bcd  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0bd9  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0be5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(dc dcVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (dcVar != null && rVar != null) {
            if (!z) {
                dcVar.cEn.setTag(null);
                dcVar.cEn.setUserId(null);
                dcVar.aLp.setText((CharSequence) null);
                dcVar.cEp.setVisibility(8);
                dcVar.cEx.setVisibility(0);
                dcVar.cEt.setVisibility(0);
                dcVar.cEs.setVisibility(8);
                if (rVar.aFs() == null) {
                    dcVar.cEy.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && rVar.aFs().AH() == 1) {
                    dcVar.cEy.changeSkinType(this.mSkinType);
                    dcVar.cEy.setVisibility(0);
                    dcVar.cEy.setData(rVar.aFs());
                } else {
                    dcVar.cEy.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) dcVar.cEu.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    dcVar.cEu.setTag(sparseArray2);
                    dcVar.cDC.setTag(sparseArray2);
                }
                sparseArray2.put(n.g.tag_clip_board, rVar);
                sparseArray2.put(n.g.tag_is_subpb, false);
                a(dcVar.cDC, getDimensionPixelSize(n.e.ds30));
                if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cDr) {
                    sparseArray2.put(n.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dcVar.cDC.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    dcVar.cDC.setLayoutParams(layoutParams);
                    dcVar.cDC.setPadding(0, 0, 0, 0);
                    dcVar.cDC.gl(null);
                    dcVar.cDC.setBackgroundDrawable(null);
                } else {
                    sparseArray2.put(n.g.tag_richtext_bg, rVar.getBimg_url());
                    dcVar.cDC.gl(rVar.getBimg_url());
                    if (rVar.aFq() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dcVar.cDC.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(n.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(n.e.ds40);
                        dcVar.cDC.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) dcVar.cDC.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(n.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(n.e.ds20);
                        dcVar.cDC.setLayoutParams(layoutParams3);
                    }
                }
                dcVar.bIB.setText(com.baidu.tbadk.core.util.ax.s(rVar.getTime()));
                if (rVar.aFq() == 1) {
                    com.baidu.tbadk.core.util.as.j(dcVar.cEi, n.d.cp_bg_line_d);
                    dcVar.cEj.setVisibility(8);
                    dcVar.cEk.setVisibility(8);
                    dcVar.cEl.setVisibility(8);
                    dcVar.cEu.setVisibility(8);
                    dcVar.bIB.setVisibility(8);
                    dcVar.cDH.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (rVar.getAuthor() != null) {
                        j = rVar.getAuthor().getUserIdLong();
                        str = rVar.getAuthor().getUserName();
                    }
                    dcVar.cDH.a(rVar.aFz(), str, j, com.baidu.adp.lib.h.b.c(this.cDR.akH().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                    dcVar.cDH.tr();
                    if (this.cDs) {
                        PraiseData praise = this.cDR.akH().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            dcVar.cDF.setVisibility(0);
                            dcVar.cDE.setVisibility(0);
                            dcVar.cDG.setVisibility(0);
                            dcVar.cDF.setIsFromPb(true);
                            dcVar.cDF.a(praise, this.cDR.akH().getId(), praise.getPostId(), true);
                            dcVar.cDF.cR(this.mSkinType);
                        } else {
                            dcVar.cDF.setVisibility(8);
                            dcVar.cDE.setVisibility(8);
                            dcVar.cDG.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aFt = rVar.aFt();
                        dcVar.cEK.setVisibility(8);
                        if (aFt != null && !TextUtils.isEmpty(aFt.getName()) && !TextUtils.isEmpty(aFt.getName().trim())) {
                            String name = aFt.getName();
                            String lat = aFt.getLat();
                            String lng = aFt.getLng();
                            dcVar.cEH.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, dcVar.cEH, 0, 10, 0, 10);
                            dcVar.cEJ.setText(aFt.getName());
                            com.baidu.tbadk.core.util.as.b(dcVar.cEJ, n.d.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.as.c(dcVar.cEI, n.f.icon_frs_site);
                            dcVar.cEH.setOnClickListener(new cy(this, lat, lng, name));
                        } else {
                            dcVar.cEI.setVisibility(8);
                            dcVar.cEJ.setVisibility(8);
                        }
                        if (rVar.getAuthor() != null && rVar.getAuthor().getGodInfo() != null) {
                            dcVar.cDH.fA(false);
                            ViewGroup.LayoutParams layoutParams4 = dcVar.cEH.getLayoutParams();
                            if (layoutParams4 != null) {
                                layoutParams4.width = -2;
                                dcVar.cEH.setLayoutParams(layoutParams4);
                            }
                            dcVar.cEH.setVisibility(0);
                            View findViewWithTag = dcVar.cEH.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, getDimensionPixelSize(n.e.fontsize24));
                                com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(n.j.is_floor), 1));
                                textView.setPadding(0, 0, getDimensionPixelSize(n.e.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                dcVar.cEH.addView(textView, 0);
                            }
                            View findViewWithTag2 = dcVar.cEH.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, getDimensionPixelSize(n.e.fontsize24));
                                com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_cont_d, 1);
                                textView2.setText(com.baidu.tbadk.core.util.ax.s(rVar.getTime()));
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, getDimensionPixelSize(n.e.ds20), 0);
                                dcVar.cEH.addView(textView2, 1);
                            }
                            if (dcVar.cHY == null) {
                                dcVar.cEI.setVisibility(8);
                                dcVar.cEH.removeView(dcVar.cEJ);
                                dcVar.cHY = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams5.addRule(11);
                                layoutParams5.addRule(15);
                                dcVar.cEJ.setCompoundDrawablesWithIntrinsicBounds(getDrawable(n.f.icon_frs_site), (Drawable) null, (Drawable) null, (Drawable) null);
                                dcVar.cHY.addView(dcVar.cEJ, layoutParams5);
                                dcVar.cEH.addView(dcVar.cHY, new LinearLayout.LayoutParams(-1, -2));
                                if (aFt != null && !TextUtils.isEmpty(aFt.getName()) && !TextUtils.isEmpty(aFt.getName().trim())) {
                                    dcVar.cEJ.setOnClickListener(new cz(this, aFt.getLat(), aFt.getLng(), aFt.getName()));
                                }
                            }
                            dcVar.cEH.setOnClickListener(null);
                        }
                    } else {
                        dcVar.cDF.setVisibility(8);
                        dcVar.cDE.setVisibility(8);
                        dcVar.cDG.setVisibility(8);
                        dcVar.cEH.setVisibility(8);
                        dcVar.cEK.setVisibility(8);
                    }
                    a(dcVar.cDC, getDimensionPixelSize(n.e.ds30));
                    ((LinearLayout.LayoutParams) dcVar.cEy.getLayoutParams()).leftMargin = getDimensionPixelSize(n.e.ds30);
                } else {
                    com.baidu.tbadk.core.util.as.j(dcVar.cEi, n.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cDs) {
                            dcVar.cEj.setVisibility(8);
                            dcVar.cEk.setVisibility(8);
                            PraiseData praise2 = this.cDR.akH().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                dcVar.cEk.setVisibility(8);
                                dcVar.cEj.setVisibility(0);
                            } else {
                                dcVar.cEk.setVisibility(0);
                                dcVar.cEj.setVisibility(8);
                            }
                        } else {
                            dcVar.cEj.setVisibility(0);
                            dcVar.cEk.setVisibility(8);
                        }
                    } else {
                        dcVar.cEj.setVisibility(0);
                        dcVar.cEk.setVisibility(8);
                    }
                    dcVar.cEl.setVisibility(0);
                    com.baidu.tbadk.data.d aFt2 = rVar.aFt();
                    dcVar.cEH.setVisibility(8);
                    if (aFt2 != null && !TextUtils.isEmpty(aFt2.getName()) && !TextUtils.isEmpty(aFt2.getName().trim())) {
                        String name2 = aFt2.getName();
                        String lat2 = aFt2.getLat();
                        String lng2 = aFt2.getLng();
                        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) dcVar.cEK.getLayoutParams();
                        if (layoutParams6 != null) {
                            if (!this.cDQ) {
                                layoutParams6.leftMargin = getDimensionPixelSize(n.e.ds74);
                            } else {
                                layoutParams6.leftMargin = getDimensionPixelSize(n.e.ds104);
                            }
                            dcVar.cEK.setLayoutParams(layoutParams6);
                        }
                        dcVar.cEK.setVisibility(0);
                        dcVar.cEM.setText(aFt2.getName());
                        com.baidu.tbadk.core.util.as.b(dcVar.cEM, n.d.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.as.c(dcVar.cEL, n.f.icon_frs_site);
                        dcVar.cEK.setOnClickListener(new da(this, lat2, lng2, name2));
                    } else {
                        dcVar.cEK.setVisibility(8);
                    }
                    dcVar.cDH.setVisibility(8);
                    dcVar.cDF.setVisibility(8);
                    dcVar.cDE.setVisibility(8);
                    dcVar.cDG.setVisibility(8);
                    dcVar.cEu.setVisibility(0);
                    dcVar.bIB.setVisibility(0);
                    String format = String.format(this.mContext.getString(n.j.is_floor), Integer.valueOf(rVar.aFq()));
                    dcVar.cEr.setVisibility(0);
                    dcVar.cEr.setText(format);
                    LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) dcVar.cEy.getLayoutParams();
                    if (!this.cDQ) {
                        a(dcVar.cDC, getDimensionPixelSize(n.e.ds74));
                        layoutParams7.leftMargin = getDimensionPixelSize(n.e.ds74);
                    } else {
                        a(dcVar.cDC, getDimensionPixelSize(n.e.ds104));
                        layoutParams7.leftMargin = getDimensionPixelSize(n.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) dcVar.cEv.getLayoutParams();
                    if (!this.cDQ) {
                        layoutParams8.leftMargin = 0;
                    } else {
                        layoutParams8.leftMargin = getDimensionPixelSize(n.e.ds30);
                    }
                }
                if (this.cDX != null && !this.cDX.equals("0") && this.cDX.equals(rVar.getAuthor().getUserId())) {
                    dcVar.cEs.setVisibility(0);
                    com.baidu.tbadk.core.util.as.c(dcVar.cEs, n.f.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.as.i(dcVar.cEm, n.f.bg_floor_new_middle);
            dcVar.cDC.setVideoImageId(n.f.pic_video);
            dcVar.cDC.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.pb_listitem_content));
            com.baidu.tbadk.core.util.as.c(dcVar.cEt, n.f.btn_pb_more_selector);
            dcVar.cDC.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) dcVar.cEt.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                dcVar.cEt.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(n.g.tag_clip_board, rVar);
            sparseArray.put(n.g.tag_load_sub_data, rVar);
            sparseArray.put(n.g.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) dcVar.cGF.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                dcVar.cGF.setTag(sparseArray5);
            }
            sparseArray5.put(n.g.tag_clip_board, rVar);
            sparseArray5.put(n.g.tag_load_sub_data, rVar);
            sparseArray5.put(n.g.tag_load_sub_view, view);
            if (rVar.aFu() > 0) {
                if (this.cDY == null) {
                    this.cDY = new com.baidu.tieba.pb.pb.sub.am(this.mContext);
                    this.cDY.setIsFromCDN(this.mIsFromCDN);
                    this.cDY.D(this.cEa);
                    boolean z7 = false;
                    String userId2 = this.cDR.akH().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cDY.r(this.cDR.akL(), z7);
                    this.cDY.g(this.cDR.akH());
                    this.cDY.eU(this.cDQ);
                }
                dcVar.cEx.setVisibility(0);
                dcVar.cEw.setVisibility(0);
                dcVar.cEv.setVisibility(0);
                dcVar.cEx.a(rVar, view);
                dcVar.cEx.setChildOnClickListener(this.bjD);
                dcVar.cEx.setChildOnLongClickListener(this.amQ);
                dcVar.cEx.setChildOnTouchListener(this.cDu);
                dcVar.cEx.setSubPbAdapter(this.cDY);
                dcVar.cEx.setVisibility(0);
            } else {
                dcVar.cEx.setVisibility(8);
                dcVar.cEw.setVisibility(8);
                dcVar.cEv.setVisibility(8);
            }
            a(dcVar, rVar, this.cDR.akO(), i);
            if (!z) {
                String portrait = rVar.getAuthor().getPortrait();
                if (rVar.getAuthor() != null) {
                    String name_show = rVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.o.gi(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.o.e(name_show, 0, 14)) + "...";
                    }
                    dcVar.aLp.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.as.b(dcVar.aLp, n.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.as.b(dcVar.aLp, n.d.cp_cont_f, 1);
                    }
                    int level_id = rVar.getAuthor().getLevel_id();
                    int is_bawu = rVar.getAuthor().getIs_bawu();
                    String bawu_type = rVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        dcVar.cEo.setVisibility(0);
                        com.baidu.tbadk.core.util.as.c(dcVar.cEo, com.baidu.tbadk.core.util.c.ci(level_id));
                        dcVar.cEo.setOnClickListener(null);
                    } else {
                        dcVar.cEo.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.as.c(dcVar.cEp, n.f.pb_manager);
                            dcVar.cEo.setVisibility(8);
                            dcVar.cEp.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.as.c(dcVar.cEp, n.f.pb_assist);
                            dcVar.cEo.setVisibility(8);
                            dcVar.cEp.setVisibility(0);
                        }
                    }
                    if (rVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.as.c(dcVar.cEq, n.f.icon_pb_pop_girl);
                        dcVar.cEq.setVisibility(0);
                    } else if (rVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.as.c(dcVar.cEq, n.f.icon_pb_pop_boy);
                        dcVar.cEq.setVisibility(0);
                    } else {
                        dcVar.cEq.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.o.gi(rVar.getAuthor().getName_show()) >= 14 && dcVar.cEo.getVisibility() == 0 && dcVar.cEs.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cDZ = rVar.getAuthor().getIconInfo();
                    this.bcl = rVar.getAuthor().getTShowInfoNew();
                    if (dcVar.bnP != null) {
                        dcVar.bnP.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
                        dcVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
                        dcVar.bnP.a(this.cDZ, i2, getDimensionPixelSize(n.e.pb_icon_width), getDimensionPixelSize(n.e.pb_icon_height), getDimensionPixelSize(n.e.pb_icon_margin));
                    }
                    if (dcVar.agT != null) {
                        dcVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
                        if (this.bcl != null && this.bcl.size() > 0 && this.bcl.get(0) != null) {
                            dcVar.agT.setTag(this.bcl.get(0).getUrl());
                        }
                        dcVar.agT.a(this.bcl, 3, getDimensionPixelSize(n.e.ds36), getDimensionPixelSize(n.e.ds36), getDimensionPixelSize(n.e.small_icon_margin), true);
                    }
                }
                dcVar.cEn.setUserId(rVar.getAuthor().getUserId());
                dcVar.cEn.setUserName(rVar.getAuthor().getUserName());
                dcVar.cEn.setImageDrawable(null);
                dcVar.aLp.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
                dcVar.aLp.setTag(n.g.tag_user_name, rVar.getAuthor().getUserName());
                dcVar.cEn.d(portrait, 28, false);
            }
            dcVar.cDC.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_c));
            if (this.cDr) {
                dcVar.cDC.setDefaultImageId(n.f.img_default_100);
            } else {
                dcVar.cDC.setDefaultImageId(n.f.icon_click);
            }
            dcVar.cDC.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aFr();
            }
            if (this.cDw || !this.cDx) {
                dcVar.cDC.a(aVar, false);
            } else {
                dcVar.cDC.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cDR.akL() != 0) {
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
            if (this.cDR != null && this.cDR.akH() != null && this.cDR.akH().getAuthor() != null && rVar.getAuthor() != null) {
                String userId4 = this.cDR.akH().getAuthor().getUserId();
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
                        if (dcVar.cEC != null) {
                            dcVar.cEC.setVisibility(0);
                            dcVar.cEC.setText(n.j.manage);
                            dcVar.cEC.setCompoundDrawablesWithIntrinsicBounds(getDrawable(n.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (dcVar.cEC != null) {
                            dcVar.cEC.setVisibility(0);
                            dcVar.cEC.setText(n.j.delete);
                            dcVar.cEC.setCompoundDrawablesWithIntrinsicBounds(getDrawable(n.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (dcVar.cEC != null) {
                        dcVar.cEC.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (rVar.aFq() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(n.g.tag_forbid_user_post_id, rVar.getId());
                    if (!z8) {
                        sparseArray.put(n.g.tag_should_manage_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cDR.akL()));
                        sparseArray.put(n.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(n.g.tag_user_mute_visible, true);
                        sparseArray.put(n.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar.getAuthor() != null) {
                            sparseArray.put(n.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                            sparseArray.put(n.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                        }
                        if (this.cDR.akH() != null) {
                            sparseArray.put(n.g.tag_user_mute_thread_id, this.cDR.akH().getId());
                        }
                        sparseArray.put(n.g.tag_user_mute_post_id, rVar.getId());
                    } else {
                        sparseArray.put(n.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(n.g.tag_should_delete_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cDR.akL()));
                        sparseArray.put(n.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(n.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(n.g.tag_del_post_id, rVar.getId());
                    } else {
                        sparseArray.put(n.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        dcVar.cEt.setVisibility(8);
                        com.baidu.tbadk.core.util.as.b(dcVar.cEA, n.d.subpb_listitem_time, 1);
                        dcVar.cEA.setText(String.format(this.mContext.getResources().getString(n.j.write_addition_update), com.baidu.tbadk.core.util.ax.s(rVar.getTime())));
                        if (dcVar.cEC.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.as.b(dcVar.cEC, n.d.cp_link_tip_c, 3);
                            sparseArray.put(n.g.tag_user_mute_visible, false);
                            dcVar.cEC.setTag(sparseArray);
                            dcVar.cEC.setOnClickListener(this.cEa);
                        }
                    }
                    a(dcVar, rVar, rVar.aFq() != 1, aVar);
                    b(dcVar);
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
            if (rVar.aFq() == 1) {
            }
            sparseArray.put(n.g.tag_forbid_user_post_id, rVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(dcVar, rVar, rVar.aFq() != 1, aVar);
            b(dcVar);
        }
    }

    private void b(dc dcVar) {
        dcVar.cDC.setTextViewOnTouchListener(this.cDu);
        dcVar.cDC.setTextViewCheckSelection(false);
    }

    private void a(dc dcVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar == null || rVar.aoe() == null) {
            dcVar.cEN.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar.aoe(), dcVar.cEN, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cDz - (i - this.cDy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(dc dcVar, com.baidu.tieba.tbadkCore.data.r rVar, AdditionData additionData, int i) {
        if (rVar.aFv() > 0 && rVar.aFp() != null) {
            dcVar.cEz.setVisibility(0);
            dcVar.cEz.removeViews(0, dcVar.cEz.getChildCount() - 1);
            int size = rVar.aFp().size();
            int aFw = rVar.aFw();
            for (int i2 = 0; i2 < aFw; i2++) {
                com.baidu.tieba.tbadkCore.data.r rVar2 = rVar.aFp().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(n.h.new_pb_list_item, (ViewGroup) dcVar.cEz, false);
                dc dcVar2 = new dc(inflate, this.cDQ, this.cDr, this.cDq, true);
                c(dcVar2);
                a(dcVar2, rVar2, (View) dcVar.cEz, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(n.g.tag_clip_board, rVar2);
                sparseArray.put(n.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(rVar2.getBimg_url()) || !this.cDr) {
                    sparseArray.put(n.g.tag_richtext_bg, null);
                    dcVar2.cDC.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dcVar2.cDC.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    dcVar2.cDC.setLayoutParams(layoutParams);
                    dcVar2.cDC.setPadding(0, 0, 0, 0);
                    dcVar.cDC.gl(null);
                } else {
                    dcVar.cDC.gl(rVar.getBimg_url());
                    dcVar2.cDC.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dcVar2.cDC.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(n.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(n.e.ds36);
                    dcVar2.cDC.setLayoutParams(layoutParams2);
                }
                dcVar.cEz.addView(inflate, dcVar.cEz.getChildCount() - 1);
            }
            if (aFw < size) {
                dcVar.cED.setVisibility(0);
                com.baidu.tbadk.core.util.as.i(dcVar.cEF, n.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.i(dcVar.cEG, n.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.b(dcVar.cEE, n.d.cp_cont_f, 1);
                dcVar.cED.setOnClickListener(new db(this, aFw, size, rVar));
                return;
            }
            dcVar.cED.setVisibility(8);
            return;
        }
        dcVar.cEz.setVisibility(8);
    }

    private void c(dc dcVar) {
        dcVar.aLp.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        dcVar.cEt.setOnClickListener(this.bjD);
        dcVar.cEn.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        dcVar.cEu.setOnLongClickListener(this.amQ);
        dcVar.cDC.setOnLongClickListener(this.amQ);
        dcVar.cEu.setOnTouchListener(this.cDu);
        dcVar.cDC.setOnTouchListener(this.cDu);
        dcVar.cDC.setOnImageClickListener(this.aFq);
        dcVar.cDC.setOnEmotionClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKo);
        dcVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
        dcVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
        dcVar.cEN.setOnClickListener(this.bjD);
        dcVar.cGF.setOnClickListener(this.bjD);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cDR = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cDq = i;
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void eU(boolean z) {
        this.cDQ = z;
    }

    public void eT(boolean z) {
        this.cDs = z;
    }

    public void kv(String str) {
        this.cDX = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cEa = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bjD = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFq = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cDu = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }
}
