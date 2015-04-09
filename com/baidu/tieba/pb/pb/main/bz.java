package com.baidu.tieba.pb.pb.main;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bz extends bq<com.baidu.tieba.tbadkCore.c.j, cd> implements View.OnClickListener {
    private static HashMap<Point, Integer> bJX = new HashMap<>();
    private ArrayList<IconData> aIa;
    private View.OnClickListener aNa;
    private View.OnLongClickListener aey;
    private com.baidu.tbadk.widget.richText.s atd;
    private com.baidu.tieba.pb.a.b bIY;
    private com.baidu.tieba.pb.b.d bIs;
    private ArrayList<IconData> bJW;
    private boolean bJY;
    private final boolean bJZ;
    private boolean bJa;
    private boolean bJb;
    private boolean bJc;
    private String bJd;
    private View.OnClickListener bJe;
    private com.baidu.tieba.pb.pb.sub.a bJf;
    private int bKa;
    private int bKb;
    private int mImageMaxWidth;
    private int width;

    static {
        bJX.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.y.i_want_lottery));
        bJX.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.y.look_result));
        bJX.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.y.i_want_lottery));
        bJX.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.y.i_want_share_picture));
        bJX.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.y.look_result));
        bJX.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.y.i_want_share_picture));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.width = -1;
        this.mImageMaxWidth = 0;
        this.bJa = true;
        this.bJb = true;
        this.bJc = true;
        this.bIY = null;
        this.bJd = null;
        this.bJf = null;
        this.bJW = null;
        this.aIa = null;
        this.bJe = null;
        this.aNa = null;
        this.atd = null;
        this.bIs = null;
        this.aey = null;
        this.bJY = false;
        this.bJZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.bKa = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
        this.bKb = com.baidu.adp.lib.util.n.M(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public cd a(ViewGroup viewGroup) {
        return new cd(com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.new_pb_list_item, viewGroup, false), this.bJb, this.bJa, this.mImageMaxWidth, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.c.j jVar, cd cdVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.tbadkCore.c.j) cdVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(cdVar);
        com.baidu.tieba.tbadkCore.c.j jVar2 = (com.baidu.tieba.tbadkCore.c.j) aA(i);
        com.baidu.tbadk.core.util.ba.j(cdVar.bKj, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.j(cdVar.bKk, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.b(cdVar.bKG, com.baidu.tieba.s.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.ba.b(cdVar.bKI, com.baidu.tieba.s.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.ba.b(cdVar.azB, com.baidu.tieba.s.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ba.b(cdVar.bKo, com.baidu.tieba.s.cp_cont_i, 1);
        com.baidu.tbadk.core.util.ba.b(cdVar.bKq, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ba.b(cdVar.bKr, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ba.c(cdVar.bKt, com.baidu.tieba.u.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.ba.j(cdVar.bKx, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.j(cdVar.bKy, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.ba.j(cdVar.bKz, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.ba.c(cdVar.bKz, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.c(cdVar.bKC, com.baidu.tieba.s.cp_bg_line_b);
        int qO = this.bIY.Zb().qO();
        if (qO == 1 || qO == 4) {
            com.baidu.tbadk.core.util.ba.b(cdVar.bKv, com.baidu.tieba.s.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ba.i((View) cdVar.bKv, com.baidu.tieba.u.buy_yinji_btn_bg);
        } else if (qO == 2) {
            com.baidu.tbadk.core.util.ba.b(cdVar.bKv, com.baidu.tieba.s.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ba.i((View) cdVar.bKv, com.baidu.tieba.u.btn_pb_bottom_comment_selector);
        }
        if (jVar2 != null) {
            a(cdVar, jVar2, view, false, i);
        }
        if (!this.bJY && this.bJZ && cdVar != null && cdVar.bKu.DR() && (listView = ((PbActivity) this.bIT.getPageContext().getOrignalPage()).getListView()) != null) {
            this.bJY = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0596 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x09f0  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0a1d  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0a36  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0a52  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(cd cdVar, com.baidu.tieba.tbadkCore.c.j jVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (cdVar != null && jVar != null) {
            if (!z) {
                cdVar.bKn.setTag(null);
                cdVar.bKn.setUserId(null);
                cdVar.azB.setText((CharSequence) null);
                cdVar.bKD.setVisibility(0);
                cdVar.bKt.setVisibility(0);
                cdVar.bKs.setVisibility(8);
                if (jVar.amR() == null) {
                    cdVar.bKE.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && jVar.amR().xT() == 1) {
                    cdVar.bKE.changeSkinType(this.mSkinType);
                    cdVar.bKE.setVisibility(0);
                    cdVar.bKE.setData(jVar.amR());
                } else {
                    cdVar.bKE.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) cdVar.bKA.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    cdVar.bKA.setTag(sparseArray2);
                    cdVar.bKu.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.v.tag_clip_board, jVar);
                sparseArray2.put(com.baidu.tieba.v.tag_is_subpb, false);
                a(cdVar.bKu, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30));
                if (TextUtils.isEmpty(jVar.getBimg_url()) || !this.bJa) {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cdVar.bKu.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    cdVar.bKu.setLayoutParams(layoutParams);
                    cdVar.bKu.setPadding(0, 0, 0, 0);
                    cdVar.bKu.eR(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, jVar.getBimg_url());
                    cdVar.bKu.eR(jVar.getBimg_url());
                    if (jVar.amP() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cdVar.bKu.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds40);
                        cdVar.bKu.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) cdVar.bKu.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds20);
                        cdVar.bKu.setLayoutParams(layoutParams3);
                    }
                }
                cdVar.bKr.setText(com.baidu.tbadk.core.util.bd.n(jVar.getTime()));
                if (jVar.amP() == 1) {
                    com.baidu.tbadk.core.util.ba.j(cdVar.bKi, com.baidu.tieba.s.cp_bg_line_d);
                    cdVar.bKj.setVisibility(8);
                    cdVar.bKk.setVisibility(8);
                    cdVar.bKl.setVisibility(8);
                    cdVar.bKA.setVisibility(8);
                    cdVar.bKr.setVisibility(8);
                    if (this.bJc) {
                        PraiseData praise = this.bIY.Zb().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            cdVar.bKy.setVisibility(0);
                            cdVar.bKx.setVisibility(0);
                            cdVar.bKz.setVisibility(0);
                            cdVar.bKy.setIsFromPb(true);
                            cdVar.bKy.a(praise, this.bIY.Zb().getId(), praise.getPostId(), true);
                            cdVar.bKy.cu(this.mSkinType);
                        } else {
                            cdVar.bKy.setVisibility(8);
                            cdVar.bKx.setVisibility(8);
                            cdVar.bKz.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d amS = jVar.amS();
                        cdVar.bKQ.setVisibility(8);
                        if (amS != null && !TextUtils.isEmpty(amS.getName()) && !TextUtils.isEmpty(amS.getName().trim())) {
                            String name = amS.getName();
                            String lat = amS.getLat();
                            String lng = amS.getLng();
                            cdVar.bKN.setVisibility(0);
                            com.baidu.adp.lib.util.n.a(this.mContext, cdVar.bKN, 0, 10, 0, 10);
                            cdVar.bKP.setText(amS.getName());
                            com.baidu.tbadk.core.util.ba.b(cdVar.bKP, com.baidu.tieba.s.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.ba.c(cdVar.bKO, com.baidu.tieba.u.icon_frs_site);
                            cdVar.bKN.setOnClickListener(new ca(this, lat, lng, name));
                        } else {
                            cdVar.bKN.setVisibility(8);
                        }
                    } else {
                        cdVar.bKy.setVisibility(8);
                        cdVar.bKx.setVisibility(8);
                        cdVar.bKz.setVisibility(8);
                        cdVar.bKN.setVisibility(8);
                        cdVar.bKQ.setVisibility(8);
                    }
                    a(cdVar.bKu, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30));
                    ((LinearLayout.LayoutParams) cdVar.bKE.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
                } else {
                    com.baidu.tbadk.core.util.ba.j(cdVar.bKi, com.baidu.tieba.s.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bJc) {
                            cdVar.bKj.setVisibility(8);
                            cdVar.bKk.setVisibility(8);
                            PraiseData praise2 = this.bIY.Zb().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                cdVar.bKk.setVisibility(8);
                                cdVar.bKj.setVisibility(0);
                            } else {
                                cdVar.bKk.setVisibility(0);
                                cdVar.bKj.setVisibility(8);
                            }
                        } else {
                            cdVar.bKj.setVisibility(0);
                            cdVar.bKk.setVisibility(8);
                        }
                    } else {
                        cdVar.bKj.setVisibility(0);
                        cdVar.bKk.setVisibility(8);
                    }
                    cdVar.bKl.setVisibility(0);
                    com.baidu.tbadk.data.d amS2 = jVar.amS();
                    cdVar.bKN.setVisibility(8);
                    if (amS2 != null && !TextUtils.isEmpty(amS2.getName()) && !TextUtils.isEmpty(amS2.getName().trim())) {
                        String name2 = amS2.getName();
                        String lat2 = amS2.getLat();
                        String lng2 = amS2.getLng();
                        cdVar.bKQ.setVisibility(0);
                        cdVar.bKS.setText(amS2.getName());
                        com.baidu.tbadk.core.util.ba.b(cdVar.bKS, com.baidu.tieba.s.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.ba.c(cdVar.bKR, com.baidu.tieba.u.icon_frs_site);
                        cdVar.bKQ.setOnClickListener(new cb(this, lat2, lng2, name2));
                    } else {
                        cdVar.bKQ.setVisibility(8);
                    }
                    cdVar.bKy.setVisibility(8);
                    cdVar.bKx.setVisibility(8);
                    cdVar.bKz.setVisibility(8);
                    cdVar.bKA.setVisibility(0);
                    cdVar.bKr.setVisibility(0);
                    String format = String.format(this.mContext.getString(com.baidu.tieba.y.is_floor), Integer.valueOf(jVar.amP()));
                    cdVar.bKq.setVisibility(0);
                    cdVar.bKq.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) cdVar.bKE.getLayoutParams();
                    if (!this.bJb) {
                        a(cdVar.bKu, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds74);
                    } else {
                        a(cdVar.bKu, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) cdVar.bKB.getLayoutParams();
                    if (!this.bJb) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
                    }
                }
                if (this.bJd != null && !this.bJd.equals(GameInfoData.NOT_FROM_DETAIL) && this.bJd.equals(jVar.getAuthor().getUserId())) {
                    cdVar.bKs.setVisibility(0);
                    com.baidu.tbadk.core.util.ba.c(cdVar.bKs, com.baidu.tieba.u.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.ba.i(cdVar.bKm, com.baidu.tieba.u.bg_floor_new_middle);
            cdVar.bKu.setVideoImageId(com.baidu.tieba.u.pic_video);
            cdVar.bKu.setTextColor(com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.pb_listitem_content));
            com.baidu.tbadk.core.util.ba.c(cdVar.bKt, com.baidu.tieba.u.btn_pb_reply_selector);
            cdVar.bKu.setLinkTextColor(com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) cdVar.bKt.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                cdVar.bKt.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_data, jVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_view, view);
            if (jVar.amT() > 0) {
                if (this.bJf == null) {
                    this.bJf = new com.baidu.tieba.pb.pb.sub.a(this.mContext, ((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bML);
                    this.bJf.setIsFromCDN(this.mIsFromCDN);
                    this.bJf.x(this.bJe);
                    boolean z7 = false;
                    String userId = this.bIY.Zb().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bJf.q(this.bIY.Ze(), z7);
                    this.bJf.dI(this.bJb);
                }
                cdVar.bKD.setVisibility(0);
                cdVar.bKC.setVisibility(0);
                cdVar.bKB.setVisibility(0);
                cdVar.bKD.a(jVar, view);
                cdVar.bKD.setLookMoreTag(i);
                cdVar.bKD.setChildOnClickListener(this.aNa);
                cdVar.bKD.setChildOnLongClickListener(this.aey);
                cdVar.bKD.setChildOnTouchListener(this.bIs);
                cdVar.bKD.setSubPbAdapter(this.bJf);
                cdVar.bKD.setVisibility(0);
            } else {
                cdVar.bKD.setVisibility(8);
                cdVar.bKC.setVisibility(8);
                cdVar.bKB.setVisibility(8);
            }
            a(cdVar, jVar, this.bIY.Zg(), i);
            if (!z) {
                String portrait = jVar.getAuthor().getPortrait();
                if (jVar.getAuthor() != null) {
                    cdVar.azB.setText(jVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.ba.b(cdVar.azB, com.baidu.tieba.s.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ba.b(cdVar.azB, com.baidu.tieba.s.cp_cont_f, 1);
                    }
                    int level_id = jVar.getAuthor().getLevel_id();
                    int is_bawu = jVar.getAuthor().getIs_bawu();
                    String bawu_type = jVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        cdVar.bKo.setVisibility(0);
                        com.baidu.tbadk.core.util.ba.c(cdVar.bKo, com.baidu.tbadk.core.util.c.bQ(level_id));
                        i2 = 2;
                        cdVar.bKo.setOnClickListener(null);
                    } else {
                        cdVar.bKo.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ba.c(cdVar.bKo, com.baidu.tieba.u.pb_manager);
                            cdVar.bKo.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bMM);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ba.c(cdVar.bKo, com.baidu.tieba.u.pb_assist);
                            cdVar.bKo.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bMM);
                        }
                    }
                    if (jVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.ba.c(cdVar.bKp, com.baidu.tieba.u.icon_pop_girl_square);
                        cdVar.bKp.setVisibility(0);
                    } else {
                        cdVar.bKp.setVisibility(8);
                    }
                    this.bJW = jVar.getAuthor().getIconInfo();
                    this.aIa = jVar.getAuthor().getTShowInfo();
                    if (cdVar.aOz != null) {
                        cdVar.aOz.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bMM);
                        cdVar.aOz.a(this.bJW, i2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                    }
                    if (cdVar.aIp != null) {
                        cdVar.aIp.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bMN);
                        cdVar.aIp.a(this.aIa, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                    }
                }
                cdVar.bKn.setUserId(jVar.getAuthor().getUserId());
                cdVar.bKn.setUserName(jVar.getAuthor().getUserName());
                cdVar.bKn.setImageDrawable(null);
                cdVar.azB.setTag(com.baidu.tieba.v.tag_user_id, jVar.getAuthor().getUserId());
                cdVar.azB.setTag(com.baidu.tieba.v.tag_user_name, jVar.getAuthor().getUserName());
                cdVar.bKn.c(portrait, 28, false);
            }
            cdVar.bKu.setLinkTextColor(com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_link_tip_c));
            if (this.bJa) {
                cdVar.bKu.setDefaultImageId(com.baidu.tieba.u.img_default_100);
            } else {
                cdVar.bKu.setDefaultImageId(com.baidu.tieba.u.icon_click);
            }
            cdVar.bKu.setIsFromCDN(this.mIsFromCDN);
            if (this.bJa) {
                cdVar.bKw.setDefaultImageId(com.baidu.tieba.u.img_default_100);
            } else {
                cdVar.bKw.setDefaultImageId(com.baidu.tieba.u.icon_click);
            }
            cdVar.bKw.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (jVar.amP() == 1 && this.bIY.Zb().qQ()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a amQ = jVar.amQ();
                if (amQ != null && amQ.DB() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> DB = amQ.DB();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= DB.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = DB.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.g DG = cVar.DG();
                            DG.setWidth(cdVar.bKw.getMaxImageWidth());
                            DG.setHeight(cdVar.bKw.getMaxImageHeight());
                            DG.bh(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                cdVar.bKv.setVisibility(8);
                cdVar.bKw.setVisibility(8);
                if (arrayList.size() >= 1) {
                    cdVar.bKw.setVisibility(0);
                }
                int qO = this.bIY.Zb().qO();
                if (qO == 1 || qO == 2 || qO == 4) {
                    cdVar.bKv.setVisibility(0);
                    cdVar.bKv.setOnClickListener(this.aNa);
                    cdVar.bKv.setEnabled(true);
                }
                Integer num = bJX.get(new Point(this.bIY.Zb().qP(), qO));
                if (num != null) {
                    cdVar.bKv.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                cdVar.bKv.setVisibility(8);
                cdVar.bKw.setVisibility(8);
            }
            if (aVar == null) {
                aVar = jVar.amQ();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.bJY || !this.bJZ) {
                cdVar.bKu.a(aVar, false);
                cdVar.bKw.a(aVar3, false);
            } else {
                cdVar.bKu.a(aVar, true);
                cdVar.bKw.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bIY.Ze() != 0) {
                z8 = true;
                z9 = true;
                String userId2 = jVar.getAuthor().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals(GameInfoData.NOT_FROM_DETAIL) || userId2.length() == 0) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                    if (!z2 && z3) {
                        z5 = true;
                        sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                        if (cdVar.bKI != null) {
                            cdVar.bKI.setVisibility(0);
                            cdVar.bKI.setText(com.baidu.tieba.y.manage);
                            cdVar.bKI.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                            if (cdVar.bKI != null) {
                                cdVar.bKI.setVisibility(0);
                                cdVar.bKI.setText(com.baidu.tieba.y.delete);
                                cdVar.bKI.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                            if (cdVar.bKI != null) {
                                cdVar.bKI.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (jVar.amP() == 1) {
                        i5 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.bIY.Ze()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, jVar.getId());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, "");
                    }
                    sparseArray.put(com.baidu.tieba.v.tag_forbid_user_post_id, jVar.getId());
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, jVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, "");
                    }
                    if (z) {
                        cdVar.bKt.setVisibility(8);
                        com.baidu.tbadk.core.util.ba.b(cdVar.bKG, com.baidu.tieba.s.subpb_listitem_time, 1);
                        cdVar.bKG.setText(String.format(this.mContext.getResources().getString(com.baidu.tieba.y.write_addition_update), com.baidu.tbadk.core.util.bd.n(jVar.getTime())));
                        if (cdVar.bKI.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.ba.b(cdVar.bKI, com.baidu.tieba.s.cp_link_tip_c, 3);
                            cdVar.bKI.setTag(sparseArray);
                            cdVar.bKI.setOnClickListener(this.bJe);
                            return;
                        }
                        return;
                    }
                    return;
                }
                z2 = z9;
                z3 = z8;
                z4 = false;
                if (!z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i52 = 1;
                if (z) {
                }
                if (jVar.amP() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                sparseArray.put(com.baidu.tieba.v.tag_forbid_user_post_id, jVar.getId());
                if (z3) {
                }
                if (z) {
                }
            } else {
                String userId3 = this.bIY.Zb().getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = false;
                } else {
                    String userId4 = jVar.getAuthor().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = false;
                        z4 = true;
                    }
                    z2 = z9;
                    z3 = z8;
                    z4 = false;
                }
                if (!z2) {
                }
                if (z2) {
                }
                z6 = z5;
                int i522 = 1;
                if (z) {
                }
                if (jVar.amP() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                sparseArray.put(com.baidu.tieba.v.tag_forbid_user_post_id, jVar.getId());
                if (z3) {
                }
                if (z) {
                }
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.bKb - (i - this.bKa));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(cd cdVar, com.baidu.tieba.tbadkCore.c.j jVar, AdditionData additionData, int i) {
        if (jVar.amU() > 0 && jVar.amO() != null) {
            cdVar.bKF.setVisibility(0);
            cdVar.bKF.removeViews(0, cdVar.bKF.getChildCount() - 1);
            int size = jVar.amO().size();
            int amV = jVar.amV();
            for (int i2 = 0; i2 < amV; i2++) {
                com.baidu.tieba.tbadkCore.c.j jVar2 = jVar.amO().get(i2);
                View a = com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.new_pb_list_item, cdVar.bKF, false);
                cd cdVar2 = new cd(a, this.bJb, this.bJa, this.mImageMaxWidth, true);
                a(cdVar2, jVar2, (View) cdVar.bKF, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, jVar2);
                sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
                if (TextUtils.isEmpty(jVar2.getBimg_url()) || !this.bJa) {
                    sparseArray.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    cdVar2.bKu.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cdVar2.bKu.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    cdVar2.bKu.setLayoutParams(layoutParams);
                    cdVar2.bKu.setPadding(0, 0, 0, 0);
                    cdVar.bKu.eR(null);
                } else {
                    cdVar.bKu.eR(jVar.getBimg_url());
                    cdVar2.bKu.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cdVar2.bKu.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds36);
                    cdVar2.bKu.setLayoutParams(layoutParams2);
                }
                cdVar.bKF.addView(a, cdVar.bKF.getChildCount() - 1);
            }
            if (amV < size) {
                cdVar.bKJ.setVisibility(0);
                com.baidu.tbadk.core.util.ba.i(cdVar.bKL, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.ba.i(cdVar.bKM, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.ba.b(cdVar.bKK, com.baidu.tieba.s.cp_cont_f, 1);
                cdVar.bKJ.setOnClickListener(new cc(this, amV, size, jVar));
                return;
            }
            cdVar.bKJ.setVisibility(8);
            return;
        }
        cdVar.bKF.setVisibility(8);
    }

    private void a(cd cdVar) {
        cdVar.azB.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bML);
        cdVar.bKt.setOnClickListener(this.aNa);
        cdVar.bKn.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bML);
        cdVar.bKA.setOnLongClickListener(this.aey);
        cdVar.bKu.setOnLongClickListener(this.aey);
        cdVar.bKA.setOnTouchListener(this.bIs);
        cdVar.bKu.setOnTouchListener(this.bIs);
        cdVar.bKu.setOnImageClickListener(this.atd);
        cdVar.bKw.setOnImageClickListener(this.atd);
        cdVar.bKu.setOnEmotionClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bMO);
        cdVar.aOz.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bMM);
        cdVar.aIp.setOnClickListener(((PbActivity) this.bIT.getPageContext().getOrignalPage()).bIm.bMN);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        this.bIY = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.mImageMaxWidth = i;
    }

    public void dH(boolean z) {
        this.bJa = z;
    }

    public void dI(boolean z) {
        this.bJb = z;
    }

    public void dJ(boolean z) {
        this.bJc = z;
    }

    public void hM(String str) {
        this.bJd = str;
    }

    public void u(View.OnClickListener onClickListener) {
        this.bJe = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.aNa = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.atd = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bIs = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aey = onLongClickListener;
    }
}
