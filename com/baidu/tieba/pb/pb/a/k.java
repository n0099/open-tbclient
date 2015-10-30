package com.baidu.tieba.pb.pb.a;

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.bk;
import com.baidu.tieba.pb.pb.sub.ai;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends bk<com.baidu.tieba.tbadkCore.data.k, o> implements View.OnClickListener {
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
    private ai cgP;
    private ArrayList<IconData> cgQ;
    private View.OnClickListener cgR;
    private com.baidu.tieba.pb.b.c cgS;
    private boolean cgU;
    private final boolean cgV;
    private int cgW;
    private int cgX;
    private com.baidu.tieba.vote.b chN;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
    /* renamed from: I */
    public o a(ViewGroup viewGroup) {
        return new o(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.cgL, this.cgK, this.cgJ, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bk, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.k kVar, o oVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) kVar, (com.baidu.tieba.tbadkCore.data.k) oVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(oVar);
        com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) aA(i);
        an.j(oVar.chf, i.c.cp_bg_line_b);
        an.j(oVar.chg, i.c.cp_bg_line_b);
        an.b(oVar.chB, i.c.subpb_listitem_time, 1);
        an.b(oVar.chD, i.c.cp_link_tip_c, 3);
        an.b(oVar.aHY, i.c.cp_cont_f, 1);
        an.b((View) oVar.chk, i.c.cp_cont_i, 1);
        an.b((View) oVar.chP, i.c.cp_cont_i, 1);
        an.b(oVar.chm, i.c.cp_cont_d, 1);
        an.b(oVar.bpL, i.c.cp_cont_d, 1);
        an.c(oVar.cho, i.e.btn_pb_reply_selector);
        an.j(oVar.chs, i.c.cp_bg_line_b);
        an.j(oVar.cht, i.c.cp_bg_line_e);
        an.j(oVar.chu, i.c.cp_bg_line_e);
        an.c(oVar.chu, i.c.cp_bg_line_b);
        an.c(oVar.chx, i.c.cp_bg_line_b);
        if (kVar2 != null) {
            a(oVar, kVar2, view, false, i);
        }
        if (!this.cgU && this.cgV && oVar != null && oVar.chp.Fl() && (listView = ((PbActivity) this.ciU.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cgU = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0a42  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0a72  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0a7e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a96  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(o oVar, com.baidu.tieba.tbadkCore.data.k kVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (oVar != null && kVar != null) {
            if (!z) {
                oVar.chj.setTag(null);
                oVar.chj.setUserId(null);
                oVar.aHY.setText((CharSequence) null);
                oVar.chP.setVisibility(8);
                oVar.chy.setVisibility(0);
                oVar.cho.setVisibility(0);
                oVar.chn.setVisibility(8);
                if (kVar.awG() == null || b(kVar)) {
                    oVar.chz.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && kVar.awG().zQ() == 1) {
                    oVar.chz.changeSkinType(this.mSkinType);
                    oVar.chz.setVisibility(0);
                    oVar.chz.setData(kVar.awG());
                } else {
                    oVar.chz.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) oVar.chv.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    oVar.chv.setTag(sparseArray2);
                    oVar.chp.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, kVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(oVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgK || b(kVar)) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) oVar.chp.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    oVar.chp.setLayoutParams(layoutParams);
                    oVar.chp.setPadding(0, 0, 0, 0);
                    oVar.chp.fS(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, kVar.getBimg_url());
                    oVar.chp.fS(kVar.getBimg_url());
                    if (kVar.awE() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) oVar.chp.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        oVar.chp.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) oVar.chp.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        oVar.chp.setLayoutParams(layoutParams3);
                    }
                }
                oVar.bpL.setText(as.m(kVar.getTime()));
                if (kVar.awE() == 1) {
                    an.j(oVar.che, i.c.cp_bg_line_d);
                    oVar.chf.setVisibility(8);
                    oVar.chg.setVisibility(8);
                    oVar.chh.setVisibility(8);
                    oVar.chv.setVisibility(8);
                    oVar.bpL.setVisibility(8);
                    if (this.cgM) {
                        PraiseData praise = this.cgN.aeK().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            oVar.cht.setVisibility(0);
                            oVar.chs.setVisibility(0);
                            oVar.chu.setVisibility(0);
                            oVar.cht.setIsFromPb(true);
                            oVar.cht.a(praise, this.cgN.aeK().getId(), praise.getPostId(), true);
                            oVar.cht.cP(this.mSkinType);
                        } else {
                            oVar.cht.setVisibility(8);
                            oVar.chs.setVisibility(8);
                            oVar.chu.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d awH = kVar.awH();
                        oVar.chQ.setVisibility(8);
                        if (awH != null && !TextUtils.isEmpty(awH.getName()) && !TextUtils.isEmpty(awH.getName().trim())) {
                            String name = awH.getName();
                            String lat = awH.getLat();
                            String lng = awH.getLng();
                            oVar.chI.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, oVar.chI, 0, 10, 0, 10);
                            oVar.chK.setText(awH.getName());
                            an.b(oVar.chK, i.c.cp_cont_c, 1);
                            an.c(oVar.chJ, i.e.icon_frs_site);
                            oVar.chI.setOnClickListener(new l(this, lat, lng, name));
                        } else {
                            oVar.chI.setVisibility(8);
                        }
                    } else {
                        oVar.cht.setVisibility(8);
                        oVar.chs.setVisibility(8);
                        oVar.chu.setVisibility(8);
                        oVar.chI.setVisibility(8);
                        oVar.chQ.setVisibility(8);
                    }
                    a(oVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) oVar.chz.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    an.j(oVar.che, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cgM) {
                            oVar.chf.setVisibility(8);
                            oVar.chg.setVisibility(8);
                            PraiseData praise2 = this.cgN.aeK().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                oVar.chg.setVisibility(8);
                                oVar.chf.setVisibility(0);
                            } else {
                                oVar.chg.setVisibility(0);
                                oVar.chf.setVisibility(8);
                            }
                        } else {
                            oVar.chf.setVisibility(0);
                            oVar.chg.setVisibility(8);
                        }
                    } else {
                        oVar.chf.setVisibility(0);
                        oVar.chg.setVisibility(8);
                    }
                    oVar.chh.setVisibility(0);
                    com.baidu.tbadk.data.d awH2 = kVar.awH();
                    oVar.chI.setVisibility(8);
                    if (awH2 != null && !TextUtils.isEmpty(awH2.getName()) && !TextUtils.isEmpty(awH2.getName().trim())) {
                        String name2 = awH2.getName();
                        String lat2 = awH2.getLat();
                        String lng2 = awH2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) oVar.chQ.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.cgL) {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds74);
                            } else {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds104);
                            }
                            oVar.chQ.setLayoutParams(layoutParams4);
                        }
                        oVar.chQ.setVisibility(0);
                        oVar.chS.setText(awH2.getName());
                        an.b(oVar.chS, i.c.cp_cont_c, 1);
                        an.c(oVar.chR, i.e.icon_frs_site);
                        oVar.chQ.setOnClickListener(new m(this, lat2, lng2, name2));
                    } else {
                        oVar.chQ.setVisibility(8);
                    }
                    oVar.cht.setVisibility(8);
                    oVar.chs.setVisibility(8);
                    oVar.chu.setVisibility(8);
                    oVar.chv.setVisibility(0);
                    oVar.bpL.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(kVar.awE()));
                    oVar.chm.setVisibility(0);
                    oVar.chm.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) oVar.chz.getLayoutParams();
                    if (!this.cgL) {
                        a(oVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(oVar.chp, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) oVar.chw.getLayoutParams();
                    if (!this.cgL) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.cgO != null && !this.cgO.equals("0") && this.cgO.equals(kVar.getAuthor().getUserId())) {
                    oVar.chn.setVisibility(0);
                    an.c(oVar.chn, i.e.icon_floorhost);
                }
            }
            an.i(oVar.chi, i.e.bg_floor_new_middle);
            oVar.chp.setVideoImageId(i.e.pic_video);
            oVar.chp.setTextColor(an.getColor(i.c.pb_listitem_content));
            an.c(oVar.cho, i.e.btn_pb_reply_selector);
            oVar.chp.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) oVar.cho.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                oVar.cho.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_load_sub_data, kVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (kVar.awI() > 0) {
                if (this.cgP == null) {
                    this.cgP = new ai(this.mContext);
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
                oVar.chy.setVisibility(0);
                oVar.chx.setVisibility(0);
                oVar.chw.setVisibility(0);
                oVar.chy.a(kVar, view);
                oVar.chy.setChildOnClickListener(this.aZw);
                oVar.chy.setChildOnLongClickListener(this.ajU);
                oVar.chy.setChildOnTouchListener(this.cgS);
                oVar.chy.setSubPbAdapter(this.cgP);
                oVar.chy.setVisibility(0);
            } else {
                oVar.chy.setVisibility(8);
                oVar.chx.setVisibility(8);
                oVar.chw.setVisibility(8);
            }
            a(oVar, kVar, this.cgN.aeR(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    String name_show = kVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.n.fO(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                    }
                    oVar.aHY.setText(name_show);
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        an.b(oVar.aHY, i.c.cp_cont_h, 1);
                    } else {
                        an.b(oVar.aHY, i.c.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        oVar.chk.setVisibility(0);
                        an.c(oVar.chk, com.baidu.tbadk.core.util.c.ch(level_id));
                        oVar.chk.setOnClickListener(null);
                    } else {
                        oVar.chk.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            an.c(oVar.chP, i.e.pb_manager);
                            oVar.chk.setVisibility(8);
                            oVar.chP.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            an.c(oVar.chP, i.e.pb_assist);
                            oVar.chk.setVisibility(8);
                            oVar.chP.setVisibility(0);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        an.c(oVar.chl, i.e.icon_pb_pop_girl);
                        oVar.chl.setVisibility(0);
                    } else if (kVar.getAuthor().getGender() == 1) {
                        an.c(oVar.chl, i.e.icon_pb_pop_boy);
                        oVar.chl.setVisibility(0);
                    } else {
                        oVar.chl.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.n.fO(kVar.getAuthor().getName_show()) >= 14 && oVar.chk.getVisibility() == 0 && oVar.chn.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cgQ = kVar.getAuthor().getIconInfo();
                    this.aSQ = kVar.getAuthor().getTShowInfo();
                    if (oVar.bcN != null) {
                        oVar.bcN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                        oVar.bcN.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.aXo);
                        oVar.bcN.a(this.cgQ, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (oVar.aTi != null) {
                        oVar.aTi.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clO);
                        oVar.aTi.a(this.aSQ, 3, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                    }
                }
                oVar.chj.setUserId(kVar.getAuthor().getUserId());
                oVar.chj.setUserName(kVar.getAuthor().getUserName());
                oVar.chj.setImageDrawable(null);
                oVar.aHY.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                oVar.aHY.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
                oVar.chj.d(portrait, 28, false);
            }
            oVar.chp.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            if (this.cgK) {
                oVar.chp.setDefaultImageId(i.e.img_default_100);
            } else {
                oVar.chp.setDefaultImageId(i.e.icon_click);
            }
            oVar.chp.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = kVar.awF();
            }
            if (this.cgU || !this.cgV) {
                oVar.chp.a(aVar, false);
            } else {
                oVar.chp.a(aVar, true);
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
                        if (oVar.chD != null) {
                            oVar.chD.setVisibility(0);
                            oVar.chD.setText(i.h.manage);
                            oVar.chD.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (oVar.chD != null) {
                            oVar.chD.setVisibility(0);
                            oVar.chD.setText(i.h.delete);
                            oVar.chD.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (oVar.chD != null) {
                        oVar.chD.setVisibility(8);
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
                        oVar.cho.setVisibility(8);
                        an.b(oVar.chB, i.c.subpb_listitem_time, 1);
                        oVar.chB.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), as.m(kVar.getTime())));
                        if (oVar.chD.getVisibility() == 0) {
                            an.b(oVar.chD, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            oVar.chD.setTag(sparseArray);
                            oVar.chD.setOnClickListener(this.cgR);
                        }
                    }
                    a(oVar, kVar, kVar.awE() != 1, aVar);
                    a(oVar);
                    if (z) {
                        a(view, kVar);
                        if (this.chN != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.chN.aAG();
                            return;
                        }
                        return;
                    }
                    return;
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
            a(oVar, kVar, kVar.awE() != 1, aVar);
            a(oVar);
            if (z) {
            }
        }
    }

    private void a(o oVar) {
        oVar.chp.setTextViewOnTouchListener(this.cgS);
        oVar.chp.setTextViewCheckSelection(false);
    }

    private void a(o oVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (kVar == null || kVar.ahK() == null || b(kVar)) {
            oVar.chL.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(kVar.ahK(), oVar.chL, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(kVar.getBimg_url()));
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

    private void a(o oVar, com.baidu.tieba.tbadkCore.data.k kVar, AdditionData additionData, int i) {
        if (kVar.awJ() > 0 && kVar.awD() != null) {
            oVar.chA.setVisibility(0);
            oVar.chA.removeViews(0, oVar.chA.getChildCount() - 1);
            int size = kVar.awD().size();
            int awK = kVar.awK();
            for (int i2 = 0; i2 < awK; i2++) {
                com.baidu.tieba.tbadkCore.data.k kVar2 = kVar.awD().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) oVar.chA, false);
                o oVar2 = new o(inflate, this.cgL, this.cgK, this.cgJ, true);
                b(oVar2);
                a(oVar2, kVar2, (View) oVar.chA, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, kVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.cgK) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    oVar2.chp.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) oVar2.chp.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    oVar2.chp.setLayoutParams(layoutParams);
                    oVar2.chp.setPadding(0, 0, 0, 0);
                    oVar.chp.fS(null);
                } else {
                    oVar.chp.fS(kVar.getBimg_url());
                    oVar2.chp.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) oVar2.chp.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    oVar2.chp.setLayoutParams(layoutParams2);
                }
                oVar.chA.addView(inflate, oVar.chA.getChildCount() - 1);
            }
            if (awK < size) {
                oVar.chE.setVisibility(0);
                an.i(oVar.chG, i.c.cp_bg_line_b);
                an.i(oVar.chH, i.c.cp_bg_line_b);
                an.b(oVar.chF, i.c.cp_cont_f, 1);
                oVar.chE.setOnClickListener(new n(this, awK, size, kVar));
                return;
            }
            oVar.chE.setVisibility(8);
            return;
        }
        oVar.chA.setVisibility(8);
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.k kVar) {
        return (this.cgN == null || this.cgN.aeK() == null || !this.cgN.aeK().sy() || this.cgN.aeK().sd() == null || kVar.awE() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.k kVar) {
        if (b(kVar) && view != null && this.ciU != null) {
            if (this.chN == null) {
                this.chN = new com.baidu.tieba.vote.b(this.ciU);
            }
            this.chN.a(view, this.cgN);
        } else if (this.chN != null) {
            this.chN.setVisibility(8);
        }
    }

    private void b(o oVar) {
        oVar.aHY.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clN);
        oVar.cho.setOnClickListener(this.aZw);
        oVar.chj.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clN);
        oVar.chv.setOnLongClickListener(this.ajU);
        oVar.chp.setOnLongClickListener(this.ajU);
        oVar.chv.setOnTouchListener(this.cgS);
        oVar.chp.setOnTouchListener(this.cgS);
        oVar.chp.setOnImageClickListener(this.aCn);
        oVar.chp.setOnEmotionClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clP);
        oVar.bcN.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.aXo);
        oVar.aTi.setOnClickListener(((PbActivity) this.ciU.getPageContext().getOrignalPage()).cin.clO);
        oVar.chL.setOnClickListener(this.aZw);
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
