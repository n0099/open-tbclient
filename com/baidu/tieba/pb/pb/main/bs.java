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
    private TbRichTextView.c aCc;
    private ArrayList<IconData> aSF;
    private View.OnClickListener aZl;
    private View.OnLongClickListener ajT;
    private boolean cgA;
    private boolean cgB;
    private com.baidu.tieba.pb.a.b cgC;
    private String cgD;
    private com.baidu.tieba.pb.pb.sub.ai cgE;
    private ArrayList<IconData> cgF;
    private View.OnClickListener cgG;
    private com.baidu.tieba.pb.b.c cgH;
    private boolean cgJ;
    private final boolean cgK;
    private int cgL;
    private int cgM;
    private int cgy;
    private boolean cgz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
    /* renamed from: L */
    public bw a(ViewGroup viewGroup) {
        return new bw(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.cgA, this.cgz, this.cgy, false);
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
        com.baidu.tbadk.core.util.am.j(bwVar.cgU, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.am.j(bwVar.cgV, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.am.b(bwVar.chq, i.c.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.am.b(bwVar.chs, i.c.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.am.b(bwVar.aHN, i.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.b((View) bwVar.cgZ, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.am.b((View) bwVar.chE, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.am.b(bwVar.chb, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.am.b(bwVar.bpA, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.am.c(bwVar.chd, i.e.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.am.j(bwVar.chh, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.am.j(bwVar.chi, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.j(bwVar.chj, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.c(bwVar.chj, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.am.c(bwVar.chm, i.c.cp_bg_line_b);
        if (kVar2 != null) {
            a(bwVar, kVar2, view, false, i);
        }
        if (!this.cgJ && this.cgK && bwVar != null && bwVar.che.Fp() && (listView = ((PbActivity) this.ciJ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cgJ = true;
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
                bwVar.cgY.setTag(null);
                bwVar.cgY.setUserId(null);
                bwVar.aHN.setText((CharSequence) null);
                bwVar.chE.setVisibility(8);
                bwVar.chn.setVisibility(0);
                bwVar.chd.setVisibility(0);
                bwVar.chc.setVisibility(8);
                if (kVar.awA() == null) {
                    bwVar.cho.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && kVar.awA().zT() == 1) {
                    bwVar.cho.changeSkinType(this.mSkinType);
                    bwVar.cho.setVisibility(0);
                    bwVar.cho.setData(kVar.awA());
                } else {
                    bwVar.cho.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) bwVar.chk.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bwVar.chk.setTag(sparseArray2);
                    bwVar.che.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, kVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(bwVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(kVar.getBimg_url()) || !this.cgz) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bwVar.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bwVar.che.setLayoutParams(layoutParams);
                    bwVar.che.setPadding(0, 0, 0, 0);
                    bwVar.che.fS(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, kVar.getBimg_url());
                    bwVar.che.fS(kVar.getBimg_url());
                    if (kVar.awy() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bwVar.che.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        bwVar.che.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bwVar.che.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        bwVar.che.setLayoutParams(layoutParams3);
                    }
                }
                bwVar.bpA.setText(com.baidu.tbadk.core.util.ar.o(kVar.getTime()));
                if (kVar.awy() == 1) {
                    com.baidu.tbadk.core.util.am.j(bwVar.cgT, i.c.cp_bg_line_d);
                    bwVar.cgU.setVisibility(8);
                    bwVar.cgV.setVisibility(8);
                    bwVar.cgW.setVisibility(8);
                    bwVar.chk.setVisibility(8);
                    bwVar.bpA.setVisibility(8);
                    if (this.cgB) {
                        PraiseData praise = this.cgC.aeO().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            bwVar.chi.setVisibility(0);
                            bwVar.chh.setVisibility(0);
                            bwVar.chj.setVisibility(0);
                            bwVar.chi.setIsFromPb(true);
                            bwVar.chi.a(praise, this.cgC.aeO().getId(), praise.getPostId(), true);
                            bwVar.chi.cP(this.mSkinType);
                        } else {
                            bwVar.chi.setVisibility(8);
                            bwVar.chh.setVisibility(8);
                            bwVar.chj.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d awB = kVar.awB();
                        bwVar.chF.setVisibility(8);
                        if (awB != null && !TextUtils.isEmpty(awB.getName()) && !TextUtils.isEmpty(awB.getName().trim())) {
                            String name = awB.getName();
                            String lat = awB.getLat();
                            String lng = awB.getLng();
                            bwVar.chx.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, bwVar.chx, 0, 10, 0, 10);
                            bwVar.chz.setText(awB.getName());
                            com.baidu.tbadk.core.util.am.b(bwVar.chz, i.c.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.am.c(bwVar.chy, i.e.icon_frs_site);
                            bwVar.chx.setOnClickListener(new bt(this, lat, lng, name));
                        } else {
                            bwVar.chx.setVisibility(8);
                        }
                    } else {
                        bwVar.chi.setVisibility(8);
                        bwVar.chh.setVisibility(8);
                        bwVar.chj.setVisibility(8);
                        bwVar.chx.setVisibility(8);
                        bwVar.chF.setVisibility(8);
                    }
                    a(bwVar.che, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) bwVar.cho.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    com.baidu.tbadk.core.util.am.j(bwVar.cgT, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cgB) {
                            bwVar.cgU.setVisibility(8);
                            bwVar.cgV.setVisibility(8);
                            PraiseData praise2 = this.cgC.aeO().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                bwVar.cgV.setVisibility(8);
                                bwVar.cgU.setVisibility(0);
                            } else {
                                bwVar.cgV.setVisibility(0);
                                bwVar.cgU.setVisibility(8);
                            }
                        } else {
                            bwVar.cgU.setVisibility(0);
                            bwVar.cgV.setVisibility(8);
                        }
                    } else {
                        bwVar.cgU.setVisibility(0);
                        bwVar.cgV.setVisibility(8);
                    }
                    bwVar.cgW.setVisibility(0);
                    com.baidu.tbadk.data.d awB2 = kVar.awB();
                    bwVar.chx.setVisibility(8);
                    if (awB2 != null && !TextUtils.isEmpty(awB2.getName()) && !TextUtils.isEmpty(awB2.getName().trim())) {
                        String name2 = awB2.getName();
                        String lat2 = awB2.getLat();
                        String lng2 = awB2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) bwVar.chF.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.cgA) {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds74);
                            } else {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds104);
                            }
                            bwVar.chF.setLayoutParams(layoutParams4);
                        }
                        bwVar.chF.setVisibility(0);
                        bwVar.chH.setText(awB2.getName());
                        com.baidu.tbadk.core.util.am.b(bwVar.chH, i.c.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.am.c(bwVar.chG, i.e.icon_frs_site);
                        bwVar.chF.setOnClickListener(new bu(this, lat2, lng2, name2));
                    } else {
                        bwVar.chF.setVisibility(8);
                    }
                    bwVar.chi.setVisibility(8);
                    bwVar.chh.setVisibility(8);
                    bwVar.chj.setVisibility(8);
                    bwVar.chk.setVisibility(0);
                    bwVar.bpA.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(kVar.awy()));
                    bwVar.chb.setVisibility(0);
                    bwVar.chb.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) bwVar.cho.getLayoutParams();
                    if (!this.cgA) {
                        a(bwVar.che, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(bwVar.che, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) bwVar.chl.getLayoutParams();
                    if (!this.cgA) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.cgD != null && !this.cgD.equals("0") && this.cgD.equals(kVar.getAuthor().getUserId())) {
                    bwVar.chc.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(bwVar.chc, i.e.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.am.i(bwVar.cgX, i.e.bg_floor_new_middle);
            bwVar.che.setVideoImageId(i.e.pic_video);
            bwVar.che.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.pb_listitem_content));
            com.baidu.tbadk.core.util.am.c(bwVar.chd, i.e.btn_pb_reply_selector);
            bwVar.che.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) bwVar.chd.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bwVar.chd.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_load_sub_data, kVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (kVar.awC() > 0) {
                if (this.cgE == null) {
                    this.cgE = new com.baidu.tieba.pb.pb.sub.ai(this.mContext);
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
                bwVar.chn.setVisibility(0);
                bwVar.chm.setVisibility(0);
                bwVar.chl.setVisibility(0);
                bwVar.chn.a(kVar, view);
                bwVar.chn.setChildOnClickListener(this.aZl);
                bwVar.chn.setChildOnLongClickListener(this.ajT);
                bwVar.chn.setChildOnTouchListener(this.cgH);
                bwVar.chn.setSubPbAdapter(this.cgE);
                bwVar.chn.setVisibility(0);
            } else {
                bwVar.chn.setVisibility(8);
                bwVar.chm.setVisibility(8);
                bwVar.chl.setVisibility(8);
            }
            a(bwVar, kVar, this.cgC.aeV(), i);
            if (!z) {
                String portrait = kVar.getAuthor().getPortrait();
                if (kVar.getAuthor() != null) {
                    String name_show = kVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.n.fO(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                    }
                    bwVar.aHN.setText(name_show);
                    ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.am.b(bwVar.aHN, i.c.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.am.b(bwVar.aHN, i.c.cp_cont_f, 1);
                    }
                    int level_id = kVar.getAuthor().getLevel_id();
                    int is_bawu = kVar.getAuthor().getIs_bawu();
                    String bawu_type = kVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        bwVar.cgZ.setVisibility(0);
                        com.baidu.tbadk.core.util.am.c(bwVar.cgZ, com.baidu.tbadk.core.util.c.ch(level_id));
                        bwVar.cgZ.setOnClickListener(null);
                    } else {
                        bwVar.cgZ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.am.c(bwVar.chE, i.e.pb_manager);
                            bwVar.cgZ.setVisibility(8);
                            bwVar.chE.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.am.c(bwVar.chE, i.e.pb_assist);
                            bwVar.cgZ.setVisibility(8);
                            bwVar.chE.setVisibility(0);
                        }
                    }
                    if (kVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.am.c(bwVar.cha, i.e.icon_pb_pop_girl);
                        bwVar.cha.setVisibility(0);
                    } else if (kVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.am.c(bwVar.cha, i.e.icon_pb_pop_boy);
                        bwVar.cha.setVisibility(0);
                    } else {
                        bwVar.cha.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.n.fO(kVar.getAuthor().getName_show()) >= 14 && bwVar.cgZ.getVisibility() == 0 && bwVar.chc.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cgF = kVar.getAuthor().getIconInfo();
                    this.aSF = kVar.getAuthor().getTShowInfo();
                    if (bwVar.bcC != null) {
                        bwVar.bcC.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                        bwVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
                        bwVar.bcC.a(this.cgF, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (bwVar.aSX != null) {
                        bwVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
                        bwVar.aSX.a(this.aSF, 3, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                    }
                }
                bwVar.cgY.setUserId(kVar.getAuthor().getUserId());
                bwVar.cgY.setUserName(kVar.getAuthor().getUserName());
                bwVar.cgY.setImageDrawable(null);
                bwVar.aHN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
                bwVar.aHN.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
                bwVar.cgY.d(portrait, 28, false);
            }
            bwVar.che.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_link_tip_c));
            if (this.cgz) {
                bwVar.che.setDefaultImageId(i.e.img_default_100);
            } else {
                bwVar.che.setDefaultImageId(i.e.icon_click);
            }
            bwVar.che.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = kVar.awz();
            }
            if (this.cgJ || !this.cgK) {
                bwVar.che.a(aVar, false);
            } else {
                bwVar.che.a(aVar, true);
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
                        if (bwVar.chs != null) {
                            bwVar.chs.setVisibility(0);
                            bwVar.chs.setText(i.h.manage);
                            bwVar.chs.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (bwVar.chs != null) {
                            bwVar.chs.setVisibility(0);
                            bwVar.chs.setText(i.h.delete);
                            bwVar.chs.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (bwVar.chs != null) {
                        bwVar.chs.setVisibility(8);
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
                        bwVar.chd.setVisibility(8);
                        com.baidu.tbadk.core.util.am.b(bwVar.chq, i.c.subpb_listitem_time, 1);
                        bwVar.chq.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), com.baidu.tbadk.core.util.ar.o(kVar.getTime())));
                        if (bwVar.chs.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.am.b(bwVar.chs, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            bwVar.chs.setTag(sparseArray);
                            bwVar.chs.setOnClickListener(this.cgG);
                        }
                    }
                    a(bwVar, kVar, kVar.awy() != 1, aVar);
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
            a(bwVar, kVar, kVar.awy() != 1, aVar);
            a(bwVar);
        }
    }

    private void a(bw bwVar) {
        bwVar.che.setTextViewOnTouchListener(this.cgH);
        bwVar.che.setTextViewCheckSelection(false);
    }

    private void a(bw bwVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (kVar == null || kVar.ahO() == null) {
            bwVar.chA.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(kVar.ahO(), bwVar.chA, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(kVar.getBimg_url()));
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

    private void a(bw bwVar, com.baidu.tieba.tbadkCore.data.k kVar, AdditionData additionData, int i) {
        if (kVar.awD() > 0 && kVar.awx() != null) {
            bwVar.chp.setVisibility(0);
            bwVar.chp.removeViews(0, bwVar.chp.getChildCount() - 1);
            int size = kVar.awx().size();
            int awE = kVar.awE();
            for (int i2 = 0; i2 < awE; i2++) {
                com.baidu.tieba.tbadkCore.data.k kVar2 = kVar.awx().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) bwVar.chp, false);
                bw bwVar2 = new bw(inflate, this.cgA, this.cgz, this.cgy, true);
                b(bwVar2);
                a(bwVar2, kVar2, (View) bwVar.chp, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, kVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(kVar2.getBimg_url()) || !this.cgz) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    bwVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bwVar2.che.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bwVar2.che.setLayoutParams(layoutParams);
                    bwVar2.che.setPadding(0, 0, 0, 0);
                    bwVar.che.fS(null);
                } else {
                    bwVar.che.fS(kVar.getBimg_url());
                    bwVar2.che.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bwVar2.che.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    bwVar2.che.setLayoutParams(layoutParams2);
                }
                bwVar.chp.addView(inflate, bwVar.chp.getChildCount() - 1);
            }
            if (awE < size) {
                bwVar.cht.setVisibility(0);
                com.baidu.tbadk.core.util.am.i(bwVar.chv, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.am.i(bwVar.chw, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.am.b(bwVar.chu, i.c.cp_cont_f, 1);
                bwVar.cht.setOnClickListener(new bv(this, awE, size, kVar));
                return;
            }
            bwVar.cht.setVisibility(8);
            return;
        }
        bwVar.chp.setVisibility(8);
    }

    private void b(bw bwVar) {
        bwVar.aHN.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        bwVar.chd.setOnClickListener(this.aZl);
        bwVar.cgY.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clC);
        bwVar.chk.setOnLongClickListener(this.ajT);
        bwVar.che.setOnLongClickListener(this.ajT);
        bwVar.chk.setOnTouchListener(this.cgH);
        bwVar.che.setOnTouchListener(this.cgH);
        bwVar.che.setOnImageClickListener(this.aCc);
        bwVar.che.setOnEmotionClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clE);
        bwVar.bcC.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.aXd);
        bwVar.aSX.setOnClickListener(((PbActivity) this.ciJ.getPageContext().getOrignalPage()).cib.clD);
        bwVar.chA.setOnClickListener(this.aZl);
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
