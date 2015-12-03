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
public class cn extends cb<com.baidu.tieba.tbadkCore.data.o, cs> implements View.OnClickListener {
    private TbRichTextView.d aDR;
    private ArrayList<IconData> aYm;
    private View.OnLongClickListener alK;
    private View.OnClickListener bfL;
    private boolean cAl;
    private com.baidu.tieba.pb.a.c cAm;
    private String cAs;
    private com.baidu.tieba.pb.pb.sub.al cAt;
    private ArrayList<IconData> cAu;
    private View.OnClickListener cAv;
    private int czL;
    private boolean czM;
    private boolean czN;
    private com.baidu.tieba.pb.b.c czP;
    private boolean czR;
    private final boolean czS;
    private int czT;
    private int czU;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.czL = 0;
        this.czM = true;
        this.cAl = true;
        this.czN = true;
        this.cAm = null;
        this.cAs = null;
        this.cAt = null;
        this.cAu = null;
        this.aYm = null;
        this.cAv = null;
        this.bfL = null;
        this.aDR = null;
        this.czP = null;
        this.alK = null;
        this.czR = false;
        this.czS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.czT = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds30);
        this.czU = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public cs a(ViewGroup viewGroup) {
        return new cs(LayoutInflater.from(this.mContext).inflate(n.g.new_pb_list_item, viewGroup, false), this.cAl, this.czM, this.czL, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cb, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, cs csVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) csVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(csVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aB(i);
        com.baidu.tbadk.core.util.as.j(csVar.cAE, n.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(csVar.cAF, n.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.b(csVar.cAV, n.c.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.as.b(csVar.cAX, n.c.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.as.b(csVar.aJR, n.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.as.b((View) csVar.cAJ, n.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.as.b((View) csVar.cAK, n.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.as.b(csVar.cAM, n.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.b(csVar.bEX, n.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.c(csVar.cAO, n.e.btn_pb_more_selector);
        com.baidu.tbadk.core.util.as.c(csVar.cCS, n.e.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.as.j(csVar.czZ, n.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(csVar.cAa, n.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.j(csVar.cAb, n.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.c(csVar.cAb, n.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.c(csVar.cAR, n.c.cp_bg_line_b);
        if (oVar2 != null) {
            a(csVar, oVar2, view, false, i);
        }
        if (!this.czR && this.czS && csVar != null && csVar.czX.Gn() && (listView = ((PbActivity) this.cCy.getPageContext().getOrignalPage()).getListView()) != null) {
            this.czR = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x07b8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07c0  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x07f4  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x08e2  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0c2d  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0c5d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0c69  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0c75  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0c81  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(cs csVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (csVar != null && oVar != null) {
            if (!z) {
                csVar.cAI.setTag(null);
                csVar.cAI.setUserId(null);
                csVar.aJR.setText((CharSequence) null);
                csVar.cAK.setVisibility(8);
                csVar.cAS.setVisibility(0);
                csVar.cAO.setVisibility(0);
                csVar.cAN.setVisibility(8);
                if (oVar.aDf() == null) {
                    csVar.cAT.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && oVar.aDf().AR() == 1) {
                    csVar.cAT.changeSkinType(this.mSkinType);
                    csVar.cAT.setVisibility(0);
                    csVar.cAT.setData(oVar.aDf());
                } else {
                    csVar.cAT.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) csVar.cAP.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    csVar.cAP.setTag(sparseArray2);
                    csVar.czX.setTag(sparseArray2);
                }
                sparseArray2.put(n.f.tag_clip_board, oVar);
                sparseArray2.put(n.f.tag_is_subpb, false);
                a(csVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
                if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.czM) {
                    sparseArray2.put(n.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) csVar.czX.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    csVar.czX.setLayoutParams(layoutParams);
                    csVar.czX.setPadding(0, 0, 0, 0);
                    csVar.czX.gh(null);
                    csVar.czX.setBackgroundDrawable(null);
                } else {
                    sparseArray2.put(n.f.tag_richtext_bg, oVar.getBimg_url());
                    csVar.czX.gh(oVar.getBimg_url());
                    if (oVar.aDd() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) csVar.czX.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(n.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(n.d.ds40);
                        csVar.czX.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) csVar.czX.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(n.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(n.d.ds20);
                        csVar.czX.setLayoutParams(layoutParams3);
                    }
                }
                csVar.bEX.setText(com.baidu.tbadk.core.util.ax.s(oVar.getTime()));
                if (oVar.aDd() == 1) {
                    com.baidu.tbadk.core.util.as.j(csVar.cAD, n.c.cp_bg_line_d);
                    csVar.cAE.setVisibility(8);
                    csVar.cAF.setVisibility(8);
                    csVar.cAG.setVisibility(8);
                    csVar.cAP.setVisibility(8);
                    csVar.bEX.setVisibility(8);
                    csVar.cAc.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (oVar.getAuthor() != null) {
                        j = oVar.getAuthor().getUserIdLong();
                        str = oVar.getAuthor().getUserName();
                    }
                    csVar.cAc.a(oVar.aDm(), str, j, com.baidu.adp.lib.h.b.c(this.cAm.ajz().getId(), 0L), com.baidu.adp.lib.h.b.c(oVar.getId(), 0L));
                    csVar.cAc.tH();
                    if (this.czN) {
                        PraiseData praise = this.cAm.ajz().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            csVar.cAa.setVisibility(0);
                            csVar.czZ.setVisibility(0);
                            csVar.cAb.setVisibility(0);
                            csVar.cAa.setIsFromPb(true);
                            csVar.cAa.a(praise, this.cAm.ajz().getId(), praise.getPostId(), true);
                            csVar.cAa.cX(this.mSkinType);
                        } else {
                            csVar.cAa.setVisibility(8);
                            csVar.czZ.setVisibility(8);
                            csVar.cAb.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aDg = oVar.aDg();
                        csVar.cBf.setVisibility(8);
                        if (aDg != null && !TextUtils.isEmpty(aDg.getName()) && !TextUtils.isEmpty(aDg.getName().trim())) {
                            String name = aDg.getName();
                            String lat = aDg.getLat();
                            String lng = aDg.getLng();
                            csVar.cBc.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, csVar.cBc, 0, 10, 0, 10);
                            csVar.cBe.setText(aDg.getName());
                            com.baidu.tbadk.core.util.as.b(csVar.cBe, n.c.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.as.c(csVar.cBd, n.e.icon_frs_site);
                            csVar.cBc.setOnClickListener(new co(this, lat, lng, name));
                        } else {
                            csVar.cBd.setVisibility(8);
                            csVar.cBe.setVisibility(8);
                        }
                        if (oVar.getAuthor() != null && oVar.getAuthor().getGodInfo() != null) {
                            csVar.cAc.fB(false);
                            ViewGroup.LayoutParams layoutParams4 = csVar.cBc.getLayoutParams();
                            if (layoutParams4 != null) {
                                layoutParams4.width = -2;
                                csVar.cBc.setLayoutParams(layoutParams4);
                            }
                            csVar.cBc.setVisibility(0);
                            View findViewWithTag = csVar.cBc.findViewWithTag("pb_item_god_floor_tag");
                            if (findViewWithTag == null || !(findViewWithTag instanceof TextView)) {
                                TextView textView = new TextView(this.mContext);
                                textView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(n.d.fontsize24));
                                com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_d, 1);
                                textView.setText(String.format(this.mContext.getString(n.i.is_floor), 1));
                                textView.setPadding(0, 0, this.mContext.getResources().getDimensionPixelSize(n.d.ds14), 0);
                                textView.setTag("pb_item_god_floor_tag");
                                csVar.cBc.addView(textView, 0);
                            }
                            View findViewWithTag2 = csVar.cBc.findViewWithTag("pb_item_god_time_tag");
                            if (findViewWithTag2 == null || !(findViewWithTag2 instanceof TextView)) {
                                TextView textView2 = new TextView(this.mContext);
                                textView2.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(n.d.fontsize24));
                                com.baidu.tbadk.core.util.as.b(textView2, n.c.cp_cont_d, 1);
                                textView2.setText(com.baidu.tbadk.core.util.ax.s(oVar.getTime()));
                                textView2.setTag("pb_item_god_time_tag");
                                textView2.setGravity(3);
                                textView2.setPadding(0, 0, this.mContext.getResources().getDimensionPixelSize(n.d.ds20), 0);
                                csVar.cBc.addView(textView2, 1);
                            }
                            if (csVar.cDZ == null) {
                                csVar.cBd.setVisibility(8);
                                csVar.cBc.removeView(csVar.cBe);
                                csVar.cDZ = new RelativeLayout(this.mContext);
                                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams5.addRule(11);
                                layoutParams5.addRule(15);
                                csVar.cBe.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_frs_site), (Drawable) null, (Drawable) null, (Drawable) null);
                                csVar.cDZ.addView(csVar.cBe, layoutParams5);
                                csVar.cBc.addView(csVar.cDZ, new LinearLayout.LayoutParams(-1, -2));
                                if (aDg != null && !TextUtils.isEmpty(aDg.getName()) && !TextUtils.isEmpty(aDg.getName().trim())) {
                                    csVar.cBe.setOnClickListener(new cp(this, aDg.getLat(), aDg.getLng(), aDg.getName()));
                                }
                            }
                            csVar.cBc.setOnClickListener(null);
                        }
                    } else {
                        csVar.cAa.setVisibility(8);
                        csVar.czZ.setVisibility(8);
                        csVar.cAb.setVisibility(8);
                        csVar.cBc.setVisibility(8);
                        csVar.cBf.setVisibility(8);
                    }
                    a(csVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
                    ((LinearLayout.LayoutParams) csVar.cAT.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds30);
                } else {
                    com.baidu.tbadk.core.util.as.j(csVar.cAD, n.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.czN) {
                            csVar.cAE.setVisibility(8);
                            csVar.cAF.setVisibility(8);
                            PraiseData praise2 = this.cAm.ajz().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                csVar.cAF.setVisibility(8);
                                csVar.cAE.setVisibility(0);
                            } else {
                                csVar.cAF.setVisibility(0);
                                csVar.cAE.setVisibility(8);
                            }
                        } else {
                            csVar.cAE.setVisibility(0);
                            csVar.cAF.setVisibility(8);
                        }
                    } else {
                        csVar.cAE.setVisibility(0);
                        csVar.cAF.setVisibility(8);
                    }
                    csVar.cAG.setVisibility(0);
                    com.baidu.tbadk.data.d aDg2 = oVar.aDg();
                    csVar.cBc.setVisibility(8);
                    if (aDg2 != null && !TextUtils.isEmpty(aDg2.getName()) && !TextUtils.isEmpty(aDg2.getName().trim())) {
                        String name2 = aDg2.getName();
                        String lat2 = aDg2.getLat();
                        String lng2 = aDg2.getLng();
                        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) csVar.cBf.getLayoutParams();
                        if (layoutParams6 != null) {
                            if (!this.cAl) {
                                layoutParams6.leftMargin = this.mContext.getResources().getDimensionPixelSize(n.d.ds74);
                            } else {
                                layoutParams6.leftMargin = this.mContext.getResources().getDimensionPixelSize(n.d.ds104);
                            }
                            csVar.cBf.setLayoutParams(layoutParams6);
                        }
                        csVar.cBf.setVisibility(0);
                        csVar.cBh.setText(aDg2.getName());
                        com.baidu.tbadk.core.util.as.b(csVar.cBh, n.c.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.as.c(csVar.cBg, n.e.icon_frs_site);
                        csVar.cBf.setOnClickListener(new cq(this, lat2, lng2, name2));
                    } else {
                        csVar.cBf.setVisibility(8);
                    }
                    csVar.cAc.setVisibility(8);
                    csVar.cAa.setVisibility(8);
                    csVar.czZ.setVisibility(8);
                    csVar.cAb.setVisibility(8);
                    csVar.cAP.setVisibility(0);
                    csVar.bEX.setVisibility(0);
                    String format = String.format(this.mContext.getString(n.i.is_floor), Integer.valueOf(oVar.aDd()));
                    csVar.cAM.setVisibility(0);
                    csVar.cAM.setText(format);
                    LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) csVar.cAT.getLayoutParams();
                    if (!this.cAl) {
                        a(csVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds74));
                        layoutParams7.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds74);
                    } else {
                        a(csVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds104));
                        layoutParams7.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) csVar.cAQ.getLayoutParams();
                    if (!this.cAl) {
                        layoutParams8.leftMargin = 0;
                    } else {
                        layoutParams8.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds30);
                    }
                }
                if (this.cAs != null && !this.cAs.equals("0") && this.cAs.equals(oVar.getAuthor().getUserId())) {
                    csVar.cAN.setVisibility(0);
                    com.baidu.tbadk.core.util.as.c(csVar.cAN, n.e.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.as.i(csVar.cAH, n.e.bg_floor_new_middle);
            csVar.czX.setVideoImageId(n.e.pic_video);
            csVar.czX.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.pb_listitem_content));
            com.baidu.tbadk.core.util.as.c(csVar.cAO, n.e.btn_pb_more_selector);
            csVar.czX.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) csVar.cAO.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                csVar.cAO.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(n.f.tag_clip_board, oVar);
            sparseArray.put(n.f.tag_load_sub_data, oVar);
            sparseArray.put(n.f.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) csVar.cCS.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                csVar.cCS.setTag(sparseArray5);
            }
            sparseArray5.put(n.f.tag_clip_board, oVar);
            sparseArray5.put(n.f.tag_load_sub_data, oVar);
            sparseArray5.put(n.f.tag_load_sub_view, view);
            if (oVar.aDh() > 0) {
                if (this.cAt == null) {
                    this.cAt = new com.baidu.tieba.pb.pb.sub.al(this.mContext);
                    this.cAt.setIsFromCDN(this.mIsFromCDN);
                    this.cAt.D(this.cAv);
                    boolean z7 = false;
                    String userId2 = this.cAm.ajz().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cAt.q(this.cAm.ajD(), z7);
                    this.cAt.e(this.cAm.ajz());
                    this.cAt.eV(this.cAl);
                }
                csVar.cAS.setVisibility(0);
                csVar.cAR.setVisibility(0);
                csVar.cAQ.setVisibility(0);
                csVar.cAS.a(oVar, view);
                csVar.cAS.setChildOnClickListener(this.bfL);
                csVar.cAS.setChildOnLongClickListener(this.alK);
                csVar.cAS.setChildOnTouchListener(this.czP);
                csVar.cAS.setSubPbAdapter(this.cAt);
                csVar.cAS.setVisibility(0);
            } else {
                csVar.cAS.setVisibility(8);
                csVar.cAR.setVisibility(8);
                csVar.cAQ.setVisibility(8);
            }
            a(csVar, oVar, this.cAm.ajG(), i);
            if (!z) {
                String portrait = oVar.getAuthor().getPortrait();
                if (oVar.getAuthor() != null) {
                    String name_show = oVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.o.ge(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.o.e(name_show, 0, 14)) + "...";
                    }
                    csVar.aJR.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = oVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.as.b(csVar.aJR, n.c.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.as.b(csVar.aJR, n.c.cp_cont_f, 1);
                    }
                    int level_id = oVar.getAuthor().getLevel_id();
                    int is_bawu = oVar.getAuthor().getIs_bawu();
                    String bawu_type = oVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        csVar.cAJ.setVisibility(0);
                        com.baidu.tbadk.core.util.as.c(csVar.cAJ, com.baidu.tbadk.core.util.c.cp(level_id));
                        csVar.cAJ.setOnClickListener(null);
                    } else {
                        csVar.cAJ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.as.c(csVar.cAK, n.e.pb_manager);
                            csVar.cAJ.setVisibility(8);
                            csVar.cAK.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.as.c(csVar.cAK, n.e.pb_assist);
                            csVar.cAJ.setVisibility(8);
                            csVar.cAK.setVisibility(0);
                        }
                    }
                    if (oVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.as.c(csVar.cAL, n.e.icon_pb_pop_girl);
                        csVar.cAL.setVisibility(0);
                    } else if (oVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.as.c(csVar.cAL, n.e.icon_pb_pop_boy);
                        csVar.cAL.setVisibility(0);
                    } else {
                        csVar.cAL.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.o.ge(oVar.getAuthor().getName_show()) >= 14 && csVar.cAJ.getVisibility() == 0 && csVar.cAN.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cAu = oVar.getAuthor().getIconInfo();
                    this.aYm = oVar.getAuthor().getTShowInfoNew();
                    if (csVar.bjY != null) {
                        csVar.bjY.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
                        csVar.bjY.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.bdv);
                        csVar.bjY.a(this.cAu, i2, this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_margin));
                    }
                    if (csVar.aYE != null) {
                        csVar.aYE.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGo);
                        if (this.aYm != null && this.aYm.size() > 0 && this.aYm.get(0) != null) {
                            csVar.aYE.setTag(this.aYm.get(0).getUrl());
                        }
                        csVar.aYE.a(this.aYm, 3, this.mContext.getResources().getDimensionPixelSize(n.d.ds36), this.mContext.getResources().getDimensionPixelSize(n.d.ds36), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
                    }
                }
                csVar.cAI.setUserId(oVar.getAuthor().getUserId());
                csVar.cAI.setUserName(oVar.getAuthor().getUserName());
                csVar.cAI.setImageDrawable(null);
                csVar.aJR.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
                csVar.aJR.setTag(n.f.tag_user_name, oVar.getAuthor().getUserName());
                csVar.cAI.d(portrait, 28, false);
            }
            csVar.czX.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_link_tip_c));
            if (this.czM) {
                csVar.czX.setDefaultImageId(n.e.img_default_100);
            } else {
                csVar.czX.setDefaultImageId(n.e.icon_click);
            }
            csVar.czX.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = oVar.aDe();
            }
            if (this.czR || !this.czS) {
                csVar.czX.a(aVar, false);
            } else {
                csVar.czX.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cAm.ajD() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = oVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.cAm != null && this.cAm.ajz() != null && this.cAm.ajz().getAuthor() != null && oVar.getAuthor() != null) {
                String userId4 = this.cAm.ajz().getAuthor().getUserId();
                String userId5 = oVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = oVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (csVar.cAX != null) {
                            csVar.cAX.setVisibility(0);
                            csVar.cAX.setText(n.i.manage);
                            csVar.cAX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (csVar.cAX != null) {
                            csVar.cAX.setVisibility(0);
                            csVar.cAX.setText(n.i.delete);
                            csVar.cAX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (csVar.cAX != null) {
                        csVar.cAX.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (oVar.aDd() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
                    if (!z8) {
                        sparseArray.put(n.f.tag_should_manage_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cAm.ajD()));
                        sparseArray.put(n.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(n.f.tag_user_mute_visible, true);
                        sparseArray.put(n.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (oVar.getAuthor() != null) {
                            sparseArray.put(n.f.tag_user_mute_mute_userid, oVar.getAuthor().getUserId());
                            sparseArray.put(n.f.tag_user_mute_mute_username, oVar.getAuthor().getUserName());
                        }
                        if (this.cAm.ajz() != null) {
                            sparseArray.put(n.f.tag_user_mute_thread_id, this.cAm.ajz().getId());
                        }
                        sparseArray.put(n.f.tag_user_mute_post_id, oVar.getId());
                    } else {
                        sparseArray.put(n.f.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(n.f.tag_should_delete_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cAm.ajD()));
                        sparseArray.put(n.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(n.f.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(n.f.tag_del_post_id, oVar.getId());
                    } else {
                        sparseArray.put(n.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        csVar.cAO.setVisibility(8);
                        com.baidu.tbadk.core.util.as.b(csVar.cAV, n.c.subpb_listitem_time, 1);
                        csVar.cAV.setText(String.format(this.mContext.getResources().getString(n.i.write_addition_update), com.baidu.tbadk.core.util.ax.s(oVar.getTime())));
                        if (csVar.cAX.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.as.b(csVar.cAX, n.c.cp_link_tip_c, 3);
                            sparseArray.put(n.f.tag_user_mute_visible, false);
                            csVar.cAX.setTag(sparseArray);
                            csVar.cAX.setOnClickListener(this.cAv);
                        }
                    }
                    a(csVar, oVar, oVar.aDd() != 1, aVar);
                    a(csVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = oVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (oVar.aDd() == 1) {
            }
            sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(csVar, oVar, oVar.aDd() != 1, aVar);
            a(csVar);
        }
    }

    private void a(cs csVar) {
        csVar.czX.setTextViewOnTouchListener(this.czP);
        csVar.czX.setTextViewCheckSelection(false);
    }

    private void a(cs csVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (oVar == null || oVar.amT() == null) {
            csVar.cBi.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.e.a(oVar.amT(), csVar.cBi, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(oVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.czU - (i - this.czT));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(cs csVar, com.baidu.tieba.tbadkCore.data.o oVar, AdditionData additionData, int i) {
        if (oVar.aDi() > 0 && oVar.aDc() != null) {
            csVar.cAU.setVisibility(0);
            csVar.cAU.removeViews(0, csVar.cAU.getChildCount() - 1);
            int size = oVar.aDc().size();
            int aDj = oVar.aDj();
            for (int i2 = 0; i2 < aDj; i2++) {
                com.baidu.tieba.tbadkCore.data.o oVar2 = oVar.aDc().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(n.g.new_pb_list_item, (ViewGroup) csVar.cAU, false);
                cs csVar2 = new cs(inflate, this.cAl, this.czM, this.czL, true);
                b(csVar2);
                a(csVar2, oVar2, (View) csVar.cAU, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(n.f.tag_clip_board, oVar2);
                sparseArray.put(n.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(oVar2.getBimg_url()) || !this.czM) {
                    sparseArray.put(n.f.tag_richtext_bg, null);
                    csVar2.czX.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) csVar2.czX.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    csVar2.czX.setLayoutParams(layoutParams);
                    csVar2.czX.setPadding(0, 0, 0, 0);
                    csVar.czX.gh(null);
                } else {
                    csVar.czX.gh(oVar.getBimg_url());
                    csVar2.czX.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) csVar2.czX.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(n.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(n.d.ds36);
                    csVar2.czX.setLayoutParams(layoutParams2);
                }
                csVar.cAU.addView(inflate, csVar.cAU.getChildCount() - 1);
            }
            if (aDj < size) {
                csVar.cAY.setVisibility(0);
                com.baidu.tbadk.core.util.as.i(csVar.cBa, n.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.i(csVar.cBb, n.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.as.b(csVar.cAZ, n.c.cp_cont_f, 1);
                csVar.cAY.setOnClickListener(new cr(this, aDj, size, oVar));
                return;
            }
            csVar.cAY.setVisibility(8);
            return;
        }
        csVar.cAU.setVisibility(8);
    }

    private void b(cs csVar) {
        csVar.aJR.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGn);
        csVar.cAO.setOnClickListener(this.bfL);
        csVar.cAI.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGn);
        csVar.cAP.setOnLongClickListener(this.alK);
        csVar.czX.setOnLongClickListener(this.alK);
        csVar.cAP.setOnTouchListener(this.czP);
        csVar.czX.setOnTouchListener(this.czP);
        csVar.czX.setOnImageClickListener(this.aDR);
        csVar.czX.setOnEmotionClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGp);
        csVar.bjY.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.bdv);
        csVar.aYE.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGo);
        csVar.cBi.setOnClickListener(this.bfL);
        csVar.cCS.setOnClickListener(this.bfL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cAm = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.czL = i;
    }

    public void eT(boolean z) {
        this.czM = z;
    }

    public void eV(boolean z) {
        this.cAl = z;
    }

    public void eU(boolean z) {
        this.czN = z;
    }

    public void ky(String str) {
        this.cAs = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cAv = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bfL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aDR = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.czP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alK = onLongClickListener;
    }
}
