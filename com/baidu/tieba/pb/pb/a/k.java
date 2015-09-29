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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
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
    private TbRichTextView.c aCc;
    private ArrayList<IconData> aSF;
    private View.OnClickListener aZl;
    private View.OnLongClickListener ajT;
    private boolean cgA;
    private boolean cgB;
    private com.baidu.tieba.pb.a.b cgC;
    private String cgD;
    private ai cgE;
    private ArrayList<IconData> cgF;
    private View.OnClickListener cgG;
    private com.baidu.tieba.pb.b.c cgH;
    private boolean cgJ;
    private final boolean cgK;
    private int cgL;
    private int cgM;
    private int cgy;
    private boolean cgz;
    private com.baidu.tieba.vote.b chC;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cgy = 0;
        this.cgz = true;
        this.cgA = true;
        this.cgB = true;
        this.cgC = null;
        this.cgD = null;
        this.cgE = null;
        this.cgF = null;
        this.aSF = null;
        this.cgG = null;
        this.aZl = null;
        this.aCc = null;
        this.cgH = null;
        this.ajT = null;
        this.cgJ = false;
        this.cgK = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cgL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.cgM = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public o a(ViewGroup viewGroup) {
        return new o(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.cgA, this.cgz, this.cgy, false);
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
        am.j(oVar.cgU, i.c.cp_bg_line_b);
        am.j(oVar.cgV, i.c.cp_bg_line_b);
        am.b(oVar.chq, i.c.subpb_listitem_time, 1);
        am.b(oVar.chs, i.c.cp_link_tip_c, 3);
        am.b(oVar.aHN, i.c.cp_cont_f, 1);
        am.b((View) oVar.cgZ, i.c.cp_cont_i, 1);
        am.b((View) oVar.chE, i.c.cp_cont_i, 1);
        am.b(oVar.chb, i.c.cp_cont_d, 1);
        am.b(oVar.bpA, i.c.cp_cont_d, 1);
        am.c(oVar.chd, i.e.btn_pb_reply_selector);
        am.j(oVar.chh, i.c.cp_bg_line_b);
        am.j(oVar.chi, i.c.cp_bg_line_e);
        am.j(oVar.chj, i.c.cp_bg_line_e);
        am.c(oVar.chj, i.c.cp_bg_line_b);
        am.c(oVar.chm, i.c.cp_bg_line_b);
        if (kVar2 != null) {
            a(oVar, kVar2, view, false, i);
        }
        if (!this.cgJ && this.cgK && oVar != null && oVar.che.Fp() && (listView = ((PbActivity) this.ciJ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cgJ = true;
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
                oVar.cgY.setTag(null);
                oVar.cgY.setUserId(null);
                oVar.aHN.setText((CharSequence) null);
                oVar.chE.setVisibility(8);
                oVar.chn.setVisibility(0);
                oVar.chd.setVisibility(0);
                oVar.chc.setVisibility(8);
                if (kVar.awA() == null || b(kVar)) {
                    oVar.cho.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && kVar.awA().zT() == 1) {
                    oVar.cho.changeSkinType(this.mSkinType);
                    oVar.cho.setVisibility(0);
                    oVar.cho.setData(kVar.awA());
                } else {
                    oVar.cho.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) oVar.chk.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    oVar.chk.setTag(sparseArray2);
                    oVar.che.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, kVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(oVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgz || b(kVar)) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) oVar.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    oVar.che.setLayoutParams(layoutParams);
                    oVar.che.setPadding(0, 0, 0, 0);
                    oVar.che.fS(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, kVar.getBimg_url());
                    oVar.che.fS(kVar.getBimg_url());
                    if (kVar.awy() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) oVar.che.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        oVar.che.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) oVar.che.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        oVar.che.setLayoutParams(layoutParams3);
                    }
                }
                oVar.bpA.setText(ar.o(kVar.getTime()));
                if (kVar.awy() == 1) {
                    am.j(oVar.cgT, i.c.cp_bg_line_d);
                    oVar.cgU.setVisibility(8);
                    oVar.cgV.setVisibility(8);
                    oVar.cgW.setVisibility(8);
                    oVar.chk.setVisibility(8);
                    oVar.bpA.setVisibility(8);
                    if (this.cgB) {
                        PraiseData praise = this.cgC.aeO().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            oVar.chi.setVisibility(0);
                            oVar.chh.setVisibility(0);
                            oVar.chj.setVisibility(0);
                            oVar.chi.setIsFromPb(true);
                            oVar.chi.a(praise, this.cgC.aeO().getId(), praise.getPostId(), true);
                            oVar.chi.cP(this.mSkinType);
                        } else {
                            oVar.chi.setVisibility(8);
                            oVar.chh.setVisibility(8);
                            oVar.chj.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d awB = kVar.awB();
                        oVar.chF.setVisibility(8);
                        if (awB != null && !TextUtils.isEmpty(awB.getName()) && !TextUtils.isEmpty(awB.getName().trim())) {
                            String name = awB.getName();
                            String lat = awB.getLat();
                            String lng = awB.getLng();
                            oVar.chx.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, oVar.chx, 0, 10, 0, 10);
                            oVar.chz.setText(awB.getName());
                            am.b(oVar.chz, i.c.cp_cont_c, 1);
                            am.c(oVar.chy, i.e.icon_frs_site);
                            oVar.chx.setOnClickListener(new l(this, lat, lng, name));
                        } else {
                            oVar.chx.setVisibility(8);
                        }
                    } else {
                        oVar.chi.setVisibility(8);
                        oVar.chh.setVisibility(8);
                        oVar.chj.setVisibility(8);
                        oVar.chx.setVisibility(8);
                        oVar.chF.setVisibility(8);
                    }
                    a(oVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) oVar.cho.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    am.j(oVar.cgT, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cgB) {
                            oVar.cgU.setVisibility(8);
                            oVar.cgV.setVisibility(8);
                            PraiseData praise2 = this.cgC.aeO().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                oVar.cgV.setVisibility(8);
                                oVar.cgU.setVisibility(0);
                            } else {
                                oVar.cgV.setVisibility(0);
                                oVar.cgU.setVisibility(8);
                            }
                        } else {
                            oVar.cgU.setVisibility(0);
                            oVar.cgV.setVisibility(8);
                        }
                    } else {
                        oVar.cgU.setVisibility(0);
                        oVar.cgV.setVisibility(8);
                    }
                    oVar.cgW.setVisibility(0);
                    com.baidu.tbadk.data.d awB2 = kVar.awB();
                    oVar.chx.setVisibility(8);
                    if (awB2 != null && !TextUtils.isEmpty(awB2.getName()) && !TextUtils.isEmpty(awB2.getName().trim())) {
                        String name2 = awB2.getName();
                        String lat2 = awB2.getLat();
                        String lng2 = awB2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) oVar.chF.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.cgA) {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds74);
                            } else {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds104);
                            }
                            oVar.chF.setLayoutParams(layoutParams4);
                        }
                        oVar.chF.setVisibility(0);
                        oVar.chH.setText(awB2.getName());
                        am.b(oVar.chH, i.c.cp_cont_c, 1);
                        am.c(oVar.chG, i.e.icon_frs_site);
                        oVar.chF.setOnClickListener(new m(this, lat2, lng2, name2));
                    } else {
                        oVar.chF.setVisibility(8);
                    }
                    oVar.chi.setVisibility(8);
                    oVar.chh.setVisibility(8);
                    oVar.chj.setVisibility(8);
                    oVar.chk.setVisibility(0);
                    oVar.bpA.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(kVar.awy()));
                    oVar.chb.setVisibility(0);
                    oVar.chb.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) oVar.cho.getLayoutParams();
                    if (!this.cgA) {
                        a(oVar.che, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(oVar.che, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) oVar.chl.getLayoutParams();
                    if (!this.cgA) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.cgD != null && !this.cgD.equals("0") && this.cgD.equals(kVar.getAuthor().getUserId())) {
                    oVar.chc.setVisibility(0);
                    am.c(oVar.chc, i.e.icon_floorhost);
                }
            }
            am.i(oVar.cgX, i.e.bg_floor_new_middle);
            oVar.che.setVideoImageId(i.e.pic_video);
            oVar.che.setTextColor(am.getColor(i.c.pb_listitem_content));
            am.c(oVar.chd, i.e.btn_pb_reply_selector);
            oVar.che.setLinkTextColor(am.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) oVar.chd.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                oVar.chd.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_load_sub_data, kVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (kVar.awC() > 0) {
                if (this.cgE == null) {
                    this.cgE = new ai(this.mContext);
                    this.cgE.setIsFromCDN(this.mIsFromCDN);
                    this.cgE.D(this.cgG);
                    boolean z7 = false;
                    String userId2 = this.cgC.aeO().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cgE.p(this.cgC.aeS(), z7);
                    this.cgE.e(this.cgC.aeO());
                    this.cgE.eq(this.cgA);
                }
                oVar.chn.setVisibility(0);
                oVar.chm.setVisibility(0);
                oVar.chl.setVisibility(0);
                oVar.chn.a(kVar, view);
                oVar.chn.setChildOnClickListener(this.aZl);
                oVar.chn.setChildOnLongClickListener(this.ajT);
                oVar.chn.setChildOnTouchListener(this.cgH);
                oVar.chn.setSubPbAdapter(this.cgE);
                oVar.chn.setVisibility(0);
            } else {
                oVar.chn.setVisibility(8);
                oVar.chm.setVisibility(8);
                oVar.chl.setVisibility(8);
            }
            a(oVar, kVar, this.cgC.aeV(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    String name_show = kVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.n.fO(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                    }
                    oVar.aHN.setText(name_show);
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        am.b(oVar.aHN, i.c.cp_cont_h, 1);
                    } else {
                        am.b(oVar.aHN, i.c.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        oVar.cgZ.setVisibility(0);
                        am.c(oVar.cgZ, com.baidu.tbadk.core.util.c.ch(level_id));
                        oVar.cgZ.setOnClickListener(null);
                    } else {
                        oVar.cgZ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            am.c(oVar.chE, i.e.pb_manager);
                            oVar.cgZ.setVisibility(8);
                            oVar.chE.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            am.c(oVar.chE, i.e.pb_assist);
                            oVar.cgZ.setVisibility(8);
                            oVar.chE.setVisibility(0);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        am.c(oVar.cha, i.e.icon_pb_pop_girl);
                        oVar.cha.setVisibility(0);
                    } else if (kVar.getAuthor().getGender() == 1) {
                        am.c(oVar.cha, i.e.icon_pb_pop_boy);
                        oVar.cha.setVisibility(0);
                    } else {
                        oVar.cha.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.n.fO(kVar.getAuthor().getName_show()) >= 14 && oVar.cgZ.getVisibility() == 0 && oVar.chc.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cgF = kVar.getAuthor().getIconInfo();
                    this.aSF = kVar.getAuthor().getTShowInfo();
                    if (oVar.bcC != null) {
                        oVar.bcC.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                        oVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
                        oVar.bcC.a(this.cgF, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (oVar.aSX != null) {
                        oVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
                        oVar.aSX.a(this.aSF, 3, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                    }
                }
                oVar.cgY.setUserId(kVar.getAuthor().getUserId());
                oVar.cgY.setUserName(kVar.getAuthor().getUserName());
                oVar.cgY.setImageDrawable(null);
                oVar.aHN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                oVar.aHN.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
                oVar.cgY.d(portrait, 28, false);
            }
            oVar.che.setLinkTextColor(am.getColor(i.c.cp_link_tip_c));
            if (this.cgz) {
                oVar.che.setDefaultImageId(i.e.img_default_100);
            } else {
                oVar.che.setDefaultImageId(i.e.icon_click);
            }
            oVar.che.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = kVar.awz();
            }
            if (this.cgJ || !this.cgK) {
                oVar.che.a(aVar, false);
            } else {
                oVar.che.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cgC.aeS() != 0) {
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
            if (this.cgC != null && this.cgC.aeO() != null && this.cgC.aeO().getAuthor() != null && kVar.getAuthor() != null) {
                String userId4 = this.cgC.aeO().getAuthor().getUserId();
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
                        if (oVar.chs != null) {
                            oVar.chs.setVisibility(0);
                            oVar.chs.setText(i.h.manage);
                            oVar.chs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (oVar.chs != null) {
                            oVar.chs.setVisibility(0);
                            oVar.chs.setText(i.h.delete);
                            oVar.chs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (oVar.chs != null) {
                        oVar.chs.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (kVar.awy() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                    if (!z8) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgC.aeS()));
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
                        if (this.cgC.aeO() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cgC.aeO().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgC.aeS()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        oVar.chd.setVisibility(8);
                        am.b(oVar.chq, i.c.subpb_listitem_time, 1);
                        oVar.chq.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), ar.o(kVar.getTime())));
                        if (oVar.chs.getVisibility() == 0) {
                            am.b(oVar.chs, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            oVar.chs.setTag(sparseArray);
                            oVar.chs.setOnClickListener(this.cgG);
                        }
                    }
                    a(oVar, kVar, kVar.awy() != 1, aVar);
                    a(oVar);
                    if (z) {
                        a(view, kVar);
                        if (this.chC != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.chC.aAA();
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
            if (kVar.awy() == 1) {
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
            a(oVar, kVar, kVar.awy() != 1, aVar);
            a(oVar);
            if (z) {
            }
        }
    }

    private void a(o oVar) {
        oVar.che.setTextViewOnTouchListener(this.cgH);
        oVar.che.setTextViewCheckSelection(false);
    }

    private void a(o oVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (kVar == null || kVar.ahO() == null || b(kVar)) {
            oVar.chA.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(kVar.ahO(), oVar.chA, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(kVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cgM - (i - this.cgL));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(o oVar, com.baidu.tieba.tbadkCore.data.k kVar, AdditionData additionData, int i) {
        if (kVar.awD() > 0 && kVar.awx() != null) {
            oVar.chp.setVisibility(0);
            oVar.chp.removeViews(0, oVar.chp.getChildCount() - 1);
            int size = kVar.awx().size();
            int awE = kVar.awE();
            for (int i2 = 0; i2 < awE; i2++) {
                com.baidu.tieba.tbadkCore.data.k kVar2 = kVar.awx().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) oVar.chp, false);
                o oVar2 = new o(inflate, this.cgA, this.cgz, this.cgy, true);
                b(oVar2);
                a(oVar2, kVar2, (View) oVar.chp, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, kVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.cgz) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    oVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) oVar2.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    oVar2.che.setLayoutParams(layoutParams);
                    oVar2.che.setPadding(0, 0, 0, 0);
                    oVar.che.fS(null);
                } else {
                    oVar.che.fS(kVar.getBimg_url());
                    oVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) oVar2.che.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    oVar2.che.setLayoutParams(layoutParams2);
                }
                oVar.chp.addView(inflate, oVar.chp.getChildCount() - 1);
            }
            if (awE < size) {
                oVar.cht.setVisibility(0);
                am.i(oVar.chv, i.c.cp_bg_line_b);
                am.i(oVar.chw, i.c.cp_bg_line_b);
                am.b(oVar.chu, i.c.cp_cont_f, 1);
                oVar.cht.setOnClickListener(new n(this, awE, size, kVar));
                return;
            }
            oVar.cht.setVisibility(8);
            return;
        }
        oVar.chp.setVisibility(8);
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.k kVar) {
        return (this.cgC == null || this.cgC.aeO() == null || !this.cgC.aeO().sB() || this.cgC.aeO().sg() == null || kVar.awy() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.k kVar) {
        if (b(kVar) && view != null && this.ciJ != null) {
            if (this.chC == null) {
                this.chC = new com.baidu.tieba.vote.b(this.ciJ);
            }
            this.chC.a(view, this.cgC);
        } else if (this.chC != null) {
            this.chC.setVisibility(8);
        }
    }

    private void b(o oVar) {
        oVar.aHN.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        oVar.chd.setOnClickListener(this.aZl);
        oVar.cgY.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        oVar.chk.setOnLongClickListener(this.ajT);
        oVar.che.setOnLongClickListener(this.ajT);
        oVar.chk.setOnTouchListener(this.cgH);
        oVar.che.setOnTouchListener(this.cgH);
        oVar.che.setOnImageClickListener(this.aCc);
        oVar.che.setOnEmotionClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clE);
        oVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
        oVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
        oVar.chA.setOnClickListener(this.aZl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.b bVar) {
        this.cgC = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.cgy = i;
    }

    public void ep(boolean z) {
        this.cgz = z;
    }

    public void eq(boolean z) {
        this.cgA = z;
    }

    public void er(boolean z) {
        this.cgB = z;
    }

    public void jH(String str) {
        this.cgD = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cgG = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZl = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCc = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cgH = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajT = onLongClickListener;
    }
}
