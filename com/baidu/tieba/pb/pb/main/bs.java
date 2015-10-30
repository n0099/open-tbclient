package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bs extends bk<com.baidu.tieba.tbadkCore.data.k, bw> implements View.OnClickListener {
    private TbRichTextView.c aCn;
    private ArrayList<IconData> aSQ;
    private View.OnClickListener aZw;
    private View.OnLongClickListener ajU;
    private int cgJ;
    private boolean cgK;
    private boolean cgL;
    private boolean cgM;
    private com.baidu.tieba.pb.a.b cgN;
    private String cgO;
    private com.baidu.tieba.pb.pb.sub.ai cgP;
    private ArrayList<IconData> cgQ;
    private View.OnClickListener cgR;
    private com.baidu.tieba.pb.b.c cgS;
    private boolean cgU;
    private final boolean cgV;
    private int cgW;
    private int cgX;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cgJ = 0;
        this.cgK = true;
        this.cgL = true;
        this.cgM = true;
        this.cgN = null;
        this.cgO = null;
        this.cgP = null;
        this.cgQ = null;
        this.aSQ = null;
        this.cgR = null;
        this.aZw = null;
        this.aCn = null;
        this.cgS = null;
        this.ajU = null;
        this.cgU = false;
        this.cgV = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cgW = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.cgX = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public bw a(ViewGroup viewGroup) {
        return new bw(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.cgL, this.cgK, this.cgJ, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bk, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.k kVar, bw bwVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) kVar, (com.baidu.tieba.tbadkCore.data.k) bwVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(bwVar);
        com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) aA(i);
        com.baidu.tbadk.core.util.an.j(bwVar.chf, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.j(bwVar.chg, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.b(bwVar.chB, i.c.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.an.b(bwVar.chD, i.c.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.an.b(bwVar.aHY, i.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.b((View) bwVar.chk, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.an.b((View) bwVar.chP, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.an.b(bwVar.chm, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.an.b(bwVar.bpL, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.an.c(bwVar.cho, i.e.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.an.j(bwVar.chs, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.j(bwVar.cht, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.an.j(bwVar.chu, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.an.c(bwVar.chu, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.c(bwVar.chx, i.c.cp_bg_line_b);
        if (kVar2 != null) {
            a(bwVar, kVar2, view, false, i);
        }
        if (!this.cgU && this.cgV && bwVar != null && bwVar.chp.Fl() && (listView = ((PbActivity) this.ciU.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cgU = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0a1a  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0a4a  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0a56  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0a62  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0a6e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bw bwVar, com.baidu.tieba.tbadkCore.data.k kVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (bwVar != null && kVar != null) {
            if (!z) {
                bwVar.chj.setTag(null);
                bwVar.chj.setUserId(null);
                bwVar.aHY.setText((CharSequence) null);
                bwVar.chP.setVisibility(8);
                bwVar.chy.setVisibility(0);
                bwVar.cho.setVisibility(0);
                bwVar.chn.setVisibility(8);
                if (kVar.awG() == null) {
                    bwVar.chz.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && kVar.awG().zQ() == 1) {
                    bwVar.chz.changeSkinType(this.mSkinType);
                    bwVar.chz.setVisibility(0);
                    bwVar.chz.setData(kVar.awG());
                } else {
                    bwVar.chz.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) bwVar.chv.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bwVar.chv.setTag(sparseArray2);
                    bwVar.chp.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, kVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(bwVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgK) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bwVar.chp.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bwVar.chp.setLayoutParams(layoutParams);
                    bwVar.chp.setPadding(0, 0, 0, 0);
                    bwVar.chp.fS(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, kVar.getBimg_url());
                    bwVar.chp.fS(kVar.getBimg_url());
                    if (kVar.awE() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bwVar.chp.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        bwVar.chp.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bwVar.chp.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        bwVar.chp.setLayoutParams(layoutParams3);
                    }
                }
                bwVar.bpL.setText(com.baidu.tbadk.core.util.as.m(kVar.getTime()));
                if (kVar.awE() == 1) {
                    com.baidu.tbadk.core.util.an.j(bwVar.che, i.c.cp_bg_line_d);
                    bwVar.chf.setVisibility(8);
                    bwVar.chg.setVisibility(8);
                    bwVar.chh.setVisibility(8);
                    bwVar.chv.setVisibility(8);
                    bwVar.bpL.setVisibility(8);
                    if (this.cgM) {
                        PraiseData praise = this.cgN.aeK().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            bwVar.cht.setVisibility(0);
                            bwVar.chs.setVisibility(0);
                            bwVar.chu.setVisibility(0);
                            bwVar.cht.setIsFromPb(true);
                            bwVar.cht.a(praise, this.cgN.aeK().getId(), praise.getPostId(), true);
                            bwVar.cht.cP(this.mSkinType);
                        } else {
                            bwVar.cht.setVisibility(8);
                            bwVar.chs.setVisibility(8);
                            bwVar.chu.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d awH = kVar.awH();
                        bwVar.chQ.setVisibility(8);
                        if (awH != null && !TextUtils.isEmpty(awH.getName()) && !TextUtils.isEmpty(awH.getName().trim())) {
                            String name = awH.getName();
                            String lat = awH.getLat();
                            String lng = awH.getLng();
                            bwVar.chI.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, bwVar.chI, 0, 10, 0, 10);
                            bwVar.chK.setText(awH.getName());
                            com.baidu.tbadk.core.util.an.b(bwVar.chK, i.c.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.an.c(bwVar.chJ, i.e.icon_frs_site);
                            bwVar.chI.setOnClickListener(new bt(this, lat, lng, name));
                        } else {
                            bwVar.chI.setVisibility(8);
                        }
                    } else {
                        bwVar.cht.setVisibility(8);
                        bwVar.chs.setVisibility(8);
                        bwVar.chu.setVisibility(8);
                        bwVar.chI.setVisibility(8);
                        bwVar.chQ.setVisibility(8);
                    }
                    a(bwVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) bwVar.chz.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    com.baidu.tbadk.core.util.an.j(bwVar.che, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cgM) {
                            bwVar.chf.setVisibility(8);
                            bwVar.chg.setVisibility(8);
                            PraiseData praise2 = this.cgN.aeK().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                bwVar.chg.setVisibility(8);
                                bwVar.chf.setVisibility(0);
                            } else {
                                bwVar.chg.setVisibility(0);
                                bwVar.chf.setVisibility(8);
                            }
                        } else {
                            bwVar.chf.setVisibility(0);
                            bwVar.chg.setVisibility(8);
                        }
                    } else {
                        bwVar.chf.setVisibility(0);
                        bwVar.chg.setVisibility(8);
                    }
                    bwVar.chh.setVisibility(0);
                    com.baidu.tbadk.data.d awH2 = kVar.awH();
                    bwVar.chI.setVisibility(8);
                    if (awH2 != null && !TextUtils.isEmpty(awH2.getName()) && !TextUtils.isEmpty(awH2.getName().trim())) {
                        String name2 = awH2.getName();
                        String lat2 = awH2.getLat();
                        String lng2 = awH2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) bwVar.chQ.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.cgL) {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds74);
                            } else {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds104);
                            }
                            bwVar.chQ.setLayoutParams(layoutParams4);
                        }
                        bwVar.chQ.setVisibility(0);
                        bwVar.chS.setText(awH2.getName());
                        com.baidu.tbadk.core.util.an.b(bwVar.chS, i.c.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.an.c(bwVar.chR, i.e.icon_frs_site);
                        bwVar.chQ.setOnClickListener(new bu(this, lat2, lng2, name2));
                    } else {
                        bwVar.chQ.setVisibility(8);
                    }
                    bwVar.cht.setVisibility(8);
                    bwVar.chs.setVisibility(8);
                    bwVar.chu.setVisibility(8);
                    bwVar.chv.setVisibility(0);
                    bwVar.bpL.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(kVar.awE()));
                    bwVar.chm.setVisibility(0);
                    bwVar.chm.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) bwVar.chz.getLayoutParams();
                    if (!this.cgL) {
                        a(bwVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(bwVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) bwVar.chw.getLayoutParams();
                    if (!this.cgL) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.cgO != null && !this.cgO.equals("0") && this.cgO.equals(kVar.getAuthor().getUserId())) {
                    bwVar.chn.setVisibility(0);
                    com.baidu.tbadk.core.util.an.c(bwVar.chn, i.e.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.an.i(bwVar.chi, i.e.bg_floor_new_middle);
            bwVar.chp.setVideoImageId(i.e.pic_video);
            bwVar.chp.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.pb_listitem_content));
            com.baidu.tbadk.core.util.an.c(bwVar.cho, i.e.btn_pb_reply_selector);
            bwVar.chp.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) bwVar.cho.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bwVar.cho.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_load_sub_data, kVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (kVar.awI() > 0) {
                if (this.cgP == null) {
                    this.cgP = new com.baidu.tieba.pb.pb.sub.ai(this.mContext);
                    this.cgP.setIsFromCDN(this.mIsFromCDN);
                    this.cgP.D(this.cgR);
                    boolean z7 = false;
                    String userId2 = this.cgN.aeK().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cgP.p(this.cgN.aeO(), z7);
                    this.cgP.e(this.cgN.aeK());
                    this.cgP.eq(this.cgL);
                }
                bwVar.chy.setVisibility(0);
                bwVar.chx.setVisibility(0);
                bwVar.chw.setVisibility(0);
                bwVar.chy.a(kVar, view);
                bwVar.chy.setChildOnClickListener(this.aZw);
                bwVar.chy.setChildOnLongClickListener(this.ajU);
                bwVar.chy.setChildOnTouchListener(this.cgS);
                bwVar.chy.setSubPbAdapter(this.cgP);
                bwVar.chy.setVisibility(0);
            } else {
                bwVar.chy.setVisibility(8);
                bwVar.chx.setVisibility(8);
                bwVar.chw.setVisibility(8);
            }
            a(bwVar, kVar, this.cgN.aeR(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    String name_show = kVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.n.fO(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                    }
                    bwVar.aHY.setText(name_show);
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.an.b(bwVar.aHY, i.c.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.an.b(bwVar.aHY, i.c.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        bwVar.chk.setVisibility(0);
                        com.baidu.tbadk.core.util.an.c(bwVar.chk, com.baidu.tbadk.core.util.c.ch(level_id));
                        bwVar.chk.setOnClickListener(null);
                    } else {
                        bwVar.chk.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.an.c(bwVar.chP, i.e.pb_manager);
                            bwVar.chk.setVisibility(8);
                            bwVar.chP.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.an.c(bwVar.chP, i.e.pb_assist);
                            bwVar.chk.setVisibility(8);
                            bwVar.chP.setVisibility(0);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.an.c(bwVar.chl, i.e.icon_pb_pop_girl);
                        bwVar.chl.setVisibility(0);
                    } else if (kVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.an.c(bwVar.chl, i.e.icon_pb_pop_boy);
                        bwVar.chl.setVisibility(0);
                    } else {
                        bwVar.chl.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.n.fO(kVar.getAuthor().getName_show()) >= 14 && bwVar.chk.getVisibility() == 0 && bwVar.chn.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cgQ = kVar.getAuthor().getIconInfo();
                    this.aSQ = kVar.getAuthor().getTShowInfo();
                    if (bwVar.bcN != null) {
                        bwVar.bcN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                        bwVar.bcN.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.aXo);
                        bwVar.bcN.a(this.cgQ, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (bwVar.aTi != null) {
                        bwVar.aTi.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clO);
                        bwVar.aTi.a(this.aSQ, 3, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                    }
                }
                bwVar.chj.setUserId(kVar.getAuthor().getUserId());
                bwVar.chj.setUserName(kVar.getAuthor().getUserName());
                bwVar.chj.setImageDrawable(null);
                bwVar.aHY.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                bwVar.aHY.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
                bwVar.chj.d(portrait, 28, false);
            }
            bwVar.chp.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_c));
            if (this.cgK) {
                bwVar.chp.setDefaultImageId(i.e.img_default_100);
            } else {
                bwVar.chp.setDefaultImageId(i.e.icon_click);
            }
            bwVar.chp.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = kVar.awF();
            }
            if (this.cgU || !this.cgV) {
                bwVar.chp.a(aVar, false);
            } else {
                bwVar.chp.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cgN.aeO() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = kVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.cgN != null && this.cgN.aeK() != null && this.cgN.aeK().getAuthor() != null && kVar.getAuthor() != null) {
                String userId4 = this.cgN.aeK().getAuthor().getUserId();
                String userId5 = kVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = kVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (bwVar.chD != null) {
                            bwVar.chD.setVisibility(0);
                            bwVar.chD.setText(i.h.manage);
                            bwVar.chD.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (bwVar.chD != null) {
                            bwVar.chD.setVisibility(0);
                            bwVar.chD.setText(i.h.delete);
                            bwVar.chD.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (bwVar.chD != null) {
                        bwVar.chD.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (kVar.awE() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                    if (!z8) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgN.aeO()));
                        sparseArray.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (kVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, kVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, kVar.getAuthor().getUserName());
                        }
                        if (this.cgN.aeK() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cgN.aeK().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgN.aeO()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        bwVar.cho.setVisibility(8);
                        com.baidu.tbadk.core.util.an.b(bwVar.chB, i.c.subpb_listitem_time, 1);
                        bwVar.chB.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), com.baidu.tbadk.core.util.as.m(kVar.getTime())));
                        if (bwVar.chD.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.an.b(bwVar.chD, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            bwVar.chD.setTag(sparseArray);
                            bwVar.chD.setOnClickListener(this.cgR);
                        }
                    }
                    a(bwVar, kVar, kVar.awE() != 1, aVar);
                    a(bwVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = kVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (kVar.awE() == 1) {
            }
            sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(bwVar, kVar, kVar.awE() != 1, aVar);
            a(bwVar);
        }
    }

    private void a(bw bwVar) {
        bwVar.chp.setTextViewOnTouchListener(this.cgS);
        bwVar.chp.setTextViewCheckSelection(false);
    }

    private void a(bw bwVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (kVar == null || kVar.ahK() == null) {
            bwVar.chL.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(kVar.ahK(), bwVar.chL, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(kVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cgX - (i - this.cgW));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(bw bwVar, com.baidu.tieba.tbadkCore.data.k kVar, AdditionData additionData, int i) {
        if (kVar.awJ() > 0 && kVar.awD() != null) {
            bwVar.chA.setVisibility(0);
            bwVar.chA.removeViews(0, bwVar.chA.getChildCount() - 1);
            int size = kVar.awD().size();
            int awK = kVar.awK();
            for (int i2 = 0; i2 < awK; i2++) {
                com.baidu.tieba.tbadkCore.data.k kVar2 = kVar.awD().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) bwVar.chA, false);
                bw bwVar2 = new bw(inflate, this.cgL, this.cgK, this.cgJ, true);
                b(bwVar2);
                a(bwVar2, kVar2, (View) bwVar.chA, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, kVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.cgK) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    bwVar2.chp.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bwVar2.chp.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bwVar2.chp.setLayoutParams(layoutParams);
                    bwVar2.chp.setPadding(0, 0, 0, 0);
                    bwVar.chp.fS(null);
                } else {
                    bwVar.chp.fS(kVar.getBimg_url());
                    bwVar2.chp.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bwVar2.chp.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    bwVar2.chp.setLayoutParams(layoutParams2);
                }
                bwVar.chA.addView(inflate, bwVar.chA.getChildCount() - 1);
            }
            if (awK < size) {
                bwVar.chE.setVisibility(0);
                com.baidu.tbadk.core.util.an.i(bwVar.chG, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.an.i(bwVar.chH, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.an.b(bwVar.chF, i.c.cp_cont_f, 1);
                bwVar.chE.setOnClickListener(new bv(this, awK, size, kVar));
                return;
            }
            bwVar.chE.setVisibility(8);
            return;
        }
        bwVar.chA.setVisibility(8);
    }

    private void b(bw bwVar) {
        bwVar.aHY.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clN);
        bwVar.cho.setOnClickListener(this.aZw);
        bwVar.chj.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clN);
        bwVar.chv.setOnLongClickListener(this.ajU);
        bwVar.chp.setOnLongClickListener(this.ajU);
        bwVar.chv.setOnTouchListener(this.cgS);
        bwVar.chp.setOnTouchListener(this.cgS);
        bwVar.chp.setOnImageClickListener(this.aCn);
        bwVar.chp.setOnEmotionClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clP);
        bwVar.bcN.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.aXo);
        bwVar.aTi.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clO);
        bwVar.chL.setOnClickListener(this.aZw);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.b bVar) {
        this.cgN = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.cgJ = i;
    }

    public void ep(boolean z) {
        this.cgK = z;
    }

    public void eq(boolean z) {
        this.cgL = z;
    }

    public void er(boolean z) {
        this.cgM = z;
    }

    public void jH(String str) {
        this.cgO = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cgR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCn = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajU = onLongClickListener;
    }
}
