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
public class by extends bp<com.baidu.tieba.tbadkCore.c.j, cc> implements View.OnClickListener {
    private static HashMap<Point, Integer> bJI = new HashMap<>();
    private ArrayList<IconData> aHS;
    private View.OnClickListener aMP;
    private View.OnLongClickListener aeq;
    private com.baidu.tbadk.widget.richText.s asV;
    private com.baidu.tieba.pb.a.b bIK;
    private boolean bIM;
    private boolean bIN;
    private boolean bIO;
    private String bIP;
    private View.OnClickListener bIQ;
    private com.baidu.tieba.pb.pb.sub.a bIR;
    private com.baidu.tieba.pb.b.d bIf;
    private ArrayList<IconData> bJH;
    private boolean bJJ;
    private final boolean bJK;
    private int bJL;
    private int bJM;
    private int mImageMaxWidth;
    private int width;

    static {
        bJI.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.y.i_want_lottery));
        bJI.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.y.look_result));
        bJI.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.y.i_want_lottery));
        bJI.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.y.i_want_share_picture));
        bJI.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.y.look_result));
        bJI.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.y.i_want_share_picture));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.width = -1;
        this.mImageMaxWidth = 0;
        this.bIM = true;
        this.bIN = true;
        this.bIO = true;
        this.bIK = null;
        this.bIP = null;
        this.bIR = null;
        this.bJH = null;
        this.aHS = null;
        this.bIQ = null;
        this.aMP = null;
        this.asV = null;
        this.bIf = null;
        this.aeq = null;
        this.bJJ = false;
        this.bJK = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.bJL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
        this.bJM = com.baidu.adp.lib.util.n.M(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public cc a(ViewGroup viewGroup) {
        return new cc(com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.new_pb_list_item, viewGroup, false), this.bIN, this.bIM, this.mImageMaxWidth, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.c.j jVar, cc ccVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.tbadkCore.c.j) ccVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(ccVar);
        com.baidu.tieba.tbadkCore.c.j jVar2 = (com.baidu.tieba.tbadkCore.c.j) aA(i);
        com.baidu.tbadk.core.util.ba.j(ccVar.bJU, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.j(ccVar.bJV, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.b(ccVar.bKr, com.baidu.tieba.s.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.ba.b(ccVar.bKt, com.baidu.tieba.s.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.ba.b(ccVar.azt, com.baidu.tieba.s.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ba.b(ccVar.bJZ, com.baidu.tieba.s.cp_cont_i, 1);
        com.baidu.tbadk.core.util.ba.b(ccVar.bKb, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ba.b(ccVar.bKc, com.baidu.tieba.s.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ba.c(ccVar.bKe, com.baidu.tieba.u.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.ba.j(ccVar.bKi, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.j(ccVar.bKj, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.ba.j(ccVar.bKk, com.baidu.tieba.s.cp_bg_line_e);
        com.baidu.tbadk.core.util.ba.c(ccVar.bKk, com.baidu.tieba.s.cp_bg_line_b);
        com.baidu.tbadk.core.util.ba.c(ccVar.bKn, com.baidu.tieba.s.cp_bg_line_b);
        int qO = this.bIK.YP().qO();
        if (qO == 1 || qO == 4) {
            com.baidu.tbadk.core.util.ba.b(ccVar.bKg, com.baidu.tieba.s.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ba.i((View) ccVar.bKg, com.baidu.tieba.u.buy_yinji_btn_bg);
        } else if (qO == 2) {
            com.baidu.tbadk.core.util.ba.b(ccVar.bKg, com.baidu.tieba.s.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ba.i((View) ccVar.bKg, com.baidu.tieba.u.btn_pb_bottom_comment_selector);
        }
        if (jVar2 != null) {
            a(ccVar, jVar2, view, false, i);
        }
        if (!this.bJJ && this.bJK && ccVar != null && ccVar.bKf.DL() && (listView = ((PbActivity) this.bIF.getPageContext().getOrignalPage()).getListView()) != null) {
            this.bJJ = true;
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
    private void a(cc ccVar, com.baidu.tieba.tbadkCore.c.j jVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (ccVar != null && jVar != null) {
            if (!z) {
                ccVar.bJY.setTag(null);
                ccVar.bJY.setUserId(null);
                ccVar.azt.setText((CharSequence) null);
                ccVar.bKo.setVisibility(0);
                ccVar.bKe.setVisibility(0);
                ccVar.bKd.setVisibility(8);
                if (jVar.amC() == null) {
                    ccVar.bKp.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && jVar.amC().xN() == 1) {
                    ccVar.bKp.changeSkinType(this.mSkinType);
                    ccVar.bKp.setVisibility(0);
                    ccVar.bKp.setData(jVar.amC());
                } else {
                    ccVar.bKp.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) ccVar.bKl.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    ccVar.bKl.setTag(sparseArray2);
                    ccVar.bKf.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.v.tag_clip_board, jVar);
                sparseArray2.put(com.baidu.tieba.v.tag_is_subpb, false);
                a(ccVar.bKf, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30));
                if (TextUtils.isEmpty(jVar.getBimg_url()) || !this.bIM) {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ccVar.bKf.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    ccVar.bKf.setLayoutParams(layoutParams);
                    ccVar.bKf.setPadding(0, 0, 0, 0);
                    ccVar.bKf.eO(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.v.tag_richtext_bg, jVar.getBimg_url());
                    ccVar.bKf.eO(jVar.getBimg_url());
                    if (jVar.amA() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ccVar.bKf.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds40);
                        ccVar.bKf.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ccVar.bKf.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds20);
                        ccVar.bKf.setLayoutParams(layoutParams3);
                    }
                }
                ccVar.bKc.setText(com.baidu.tbadk.core.util.bd.n(jVar.getTime()));
                if (jVar.amA() == 1) {
                    com.baidu.tbadk.core.util.ba.j(ccVar.bJT, com.baidu.tieba.s.cp_bg_line_d);
                    ccVar.bJU.setVisibility(8);
                    ccVar.bJV.setVisibility(8);
                    ccVar.bJW.setVisibility(8);
                    ccVar.bKl.setVisibility(8);
                    ccVar.bKc.setVisibility(8);
                    if (this.bIO) {
                        PraiseData praise = this.bIK.YP().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            ccVar.bKj.setVisibility(0);
                            ccVar.bKi.setVisibility(0);
                            ccVar.bKk.setVisibility(0);
                            ccVar.bKj.setIsFromPb(true);
                            ccVar.bKj.a(praise, this.bIK.YP().getId(), praise.getPostId(), true);
                            ccVar.bKj.cu(this.mSkinType);
                        } else {
                            ccVar.bKj.setVisibility(8);
                            ccVar.bKi.setVisibility(8);
                            ccVar.bKk.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d amD = jVar.amD();
                        ccVar.bKB.setVisibility(8);
                        if (amD != null && !TextUtils.isEmpty(amD.getName()) && !TextUtils.isEmpty(amD.getName().trim())) {
                            String name = amD.getName();
                            String lat = amD.getLat();
                            String lng = amD.getLng();
                            ccVar.bKy.setVisibility(0);
                            com.baidu.adp.lib.util.n.a(this.mContext, ccVar.bKy, 0, 10, 0, 10);
                            ccVar.bKA.setText(amD.getName());
                            com.baidu.tbadk.core.util.ba.b(ccVar.bKA, com.baidu.tieba.s.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.ba.c(ccVar.bKz, com.baidu.tieba.u.icon_frs_site);
                            ccVar.bKy.setOnClickListener(new bz(this, lat, lng, name));
                        } else {
                            ccVar.bKy.setVisibility(8);
                        }
                    } else {
                        ccVar.bKj.setVisibility(8);
                        ccVar.bKi.setVisibility(8);
                        ccVar.bKk.setVisibility(8);
                        ccVar.bKy.setVisibility(8);
                        ccVar.bKB.setVisibility(8);
                    }
                    a(ccVar.bKf, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30));
                    ((LinearLayout.LayoutParams) ccVar.bKp.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
                } else {
                    com.baidu.tbadk.core.util.ba.j(ccVar.bJT, com.baidu.tieba.s.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bIO) {
                            ccVar.bJU.setVisibility(8);
                            ccVar.bJV.setVisibility(8);
                            PraiseData praise2 = this.bIK.YP().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                ccVar.bJV.setVisibility(8);
                                ccVar.bJU.setVisibility(0);
                            } else {
                                ccVar.bJV.setVisibility(0);
                                ccVar.bJU.setVisibility(8);
                            }
                        } else {
                            ccVar.bJU.setVisibility(0);
                            ccVar.bJV.setVisibility(8);
                        }
                    } else {
                        ccVar.bJU.setVisibility(0);
                        ccVar.bJV.setVisibility(8);
                    }
                    ccVar.bJW.setVisibility(0);
                    com.baidu.tbadk.data.d amD2 = jVar.amD();
                    ccVar.bKy.setVisibility(8);
                    if (amD2 != null && !TextUtils.isEmpty(amD2.getName()) && !TextUtils.isEmpty(amD2.getName().trim())) {
                        String name2 = amD2.getName();
                        String lat2 = amD2.getLat();
                        String lng2 = amD2.getLng();
                        ccVar.bKB.setVisibility(0);
                        ccVar.bKD.setText(amD2.getName());
                        com.baidu.tbadk.core.util.ba.b(ccVar.bKD, com.baidu.tieba.s.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.ba.c(ccVar.bKC, com.baidu.tieba.u.icon_frs_site);
                        ccVar.bKB.setOnClickListener(new ca(this, lat2, lng2, name2));
                    } else {
                        ccVar.bKB.setVisibility(8);
                    }
                    ccVar.bKj.setVisibility(8);
                    ccVar.bKi.setVisibility(8);
                    ccVar.bKk.setVisibility(8);
                    ccVar.bKl.setVisibility(0);
                    ccVar.bKc.setVisibility(0);
                    String format = String.format(this.mContext.getString(com.baidu.tieba.y.is_floor), Integer.valueOf(jVar.amA()));
                    ccVar.bKb.setVisibility(0);
                    ccVar.bKb.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) ccVar.bKp.getLayoutParams();
                    if (!this.bIN) {
                        a(ccVar.bKf, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds74);
                    } else {
                        a(ccVar.bKf, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) ccVar.bKm.getLayoutParams();
                    if (!this.bIN) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds30);
                    }
                }
                if (this.bIP != null && !this.bIP.equals(GameInfoData.NOT_FROM_DETAIL) && this.bIP.equals(jVar.getAuthor().getUserId())) {
                    ccVar.bKd.setVisibility(0);
                    com.baidu.tbadk.core.util.ba.c(ccVar.bKd, com.baidu.tieba.u.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.ba.i(ccVar.bJX, com.baidu.tieba.u.bg_floor_new_middle);
            ccVar.bKf.setVideoImageId(com.baidu.tieba.u.pic_video);
            ccVar.bKf.setTextColor(com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.pb_listitem_content));
            com.baidu.tbadk.core.util.ba.c(ccVar.bKe, com.baidu.tieba.u.btn_pb_reply_selector);
            ccVar.bKf.setLinkTextColor(com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) ccVar.bKe.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                ccVar.bKe.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_data, jVar);
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_view, view);
            if (jVar.amE() > 0) {
                if (this.bIR == null) {
                    this.bIR = new com.baidu.tieba.pb.pb.sub.a(this.mContext, ((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMv);
                    this.bIR.setIsFromCDN(this.mIsFromCDN);
                    this.bIR.w(this.bIQ);
                    boolean z7 = false;
                    String userId = this.bIK.YP().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bIR.q(this.bIK.YS(), z7);
                    this.bIR.dK(this.bIN);
                }
                ccVar.bKo.setVisibility(0);
                ccVar.bKn.setVisibility(0);
                ccVar.bKm.setVisibility(0);
                ccVar.bKo.a(jVar, view);
                ccVar.bKo.setLookMoreTag(i);
                ccVar.bKo.setChildOnClickListener(this.aMP);
                ccVar.bKo.setChildOnLongClickListener(this.aeq);
                ccVar.bKo.setChildOnTouchListener(this.bIf);
                ccVar.bKo.setSubPbAdapter(this.bIR);
                ccVar.bKo.setVisibility(0);
            } else {
                ccVar.bKo.setVisibility(8);
                ccVar.bKn.setVisibility(8);
                ccVar.bKm.setVisibility(8);
            }
            a(ccVar, jVar, this.bIK.YU(), i);
            if (!z) {
                String portrait = jVar.getAuthor().getPortrait();
                if (jVar.getAuthor() != null) {
                    ccVar.azt.setText(jVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.ba.b(ccVar.azt, com.baidu.tieba.s.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ba.b(ccVar.azt, com.baidu.tieba.s.cp_cont_f, 1);
                    }
                    int level_id = jVar.getAuthor().getLevel_id();
                    int is_bawu = jVar.getAuthor().getIs_bawu();
                    String bawu_type = jVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        ccVar.bJZ.setVisibility(0);
                        com.baidu.tbadk.core.util.ba.c(ccVar.bJZ, com.baidu.tbadk.core.util.c.bQ(level_id));
                        i2 = 2;
                        ccVar.bJZ.setOnClickListener(null);
                    } else {
                        ccVar.bJZ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ba.c(ccVar.bJZ, com.baidu.tieba.u.pb_manager);
                            ccVar.bJZ.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMw);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ba.c(ccVar.bJZ, com.baidu.tieba.u.pb_assist);
                            ccVar.bJZ.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMw);
                        }
                    }
                    if (jVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.ba.c(ccVar.bKa, com.baidu.tieba.u.icon_pop_girl_square);
                        ccVar.bKa.setVisibility(0);
                    } else {
                        ccVar.bKa.setVisibility(8);
                    }
                    this.bJH = jVar.getAuthor().getIconInfo();
                    this.aHS = jVar.getAuthor().getTShowInfo();
                    if (ccVar.aOi != null) {
                        ccVar.aOi.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMw);
                        ccVar.aOi.a(this.bJH, i2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                    }
                    if (ccVar.aIh != null) {
                        ccVar.aIh.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMx);
                        ccVar.aIh.a(this.aHS, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                    }
                }
                ccVar.bJY.setUserId(jVar.getAuthor().getUserId());
                ccVar.bJY.setUserName(jVar.getAuthor().getUserName());
                ccVar.bJY.setImageDrawable(null);
                ccVar.azt.setTag(com.baidu.tieba.v.tag_user_id, jVar.getAuthor().getUserId());
                ccVar.azt.setTag(com.baidu.tieba.v.tag_user_name, jVar.getAuthor().getUserName());
                ccVar.bJY.c(portrait, 28, false);
            }
            ccVar.bKf.setLinkTextColor(com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_link_tip_c));
            if (this.bIM) {
                ccVar.bKf.setDefaultImageId(com.baidu.tieba.u.img_default_100);
            } else {
                ccVar.bKf.setDefaultImageId(com.baidu.tieba.u.icon_click);
            }
            ccVar.bKf.setIsFromCDN(this.mIsFromCDN);
            if (this.bIM) {
                ccVar.bKh.setDefaultImageId(com.baidu.tieba.u.img_default_100);
            } else {
                ccVar.bKh.setDefaultImageId(com.baidu.tieba.u.icon_click);
            }
            ccVar.bKh.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (jVar.amA() == 1 && this.bIK.YP().qQ()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a amB = jVar.amB();
                if (amB != null && amB.Dv() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> Dv = amB.Dv();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= Dv.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = Dv.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.g DA = cVar.DA();
                            DA.setWidth(ccVar.bKh.getMaxImageWidth());
                            DA.setHeight(ccVar.bKh.getMaxImageHeight());
                            DA.bh(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                ccVar.bKg.setVisibility(8);
                ccVar.bKh.setVisibility(8);
                if (arrayList.size() >= 1) {
                    ccVar.bKh.setVisibility(0);
                }
                int qO = this.bIK.YP().qO();
                if (qO == 1 || qO == 2 || qO == 4) {
                    ccVar.bKg.setVisibility(0);
                    ccVar.bKg.setOnClickListener(this.aMP);
                    ccVar.bKg.setEnabled(true);
                }
                Integer num = bJI.get(new Point(this.bIK.YP().qP(), qO));
                if (num != null) {
                    ccVar.bKg.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                ccVar.bKg.setVisibility(8);
                ccVar.bKh.setVisibility(8);
            }
            if (aVar == null) {
                aVar = jVar.amB();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.bJJ || !this.bJK) {
                ccVar.bKf.a(aVar, false);
                ccVar.bKh.a(aVar3, false);
            } else {
                ccVar.bKf.a(aVar, true);
                ccVar.bKh.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bIK.YS() != 0) {
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
                        if (ccVar.bKt != null) {
                            ccVar.bKt.setVisibility(0);
                            ccVar.bKt.setText(com.baidu.tieba.y.manage);
                            ccVar.bKt.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                            if (ccVar.bKt != null) {
                                ccVar.bKt.setVisibility(0);
                                ccVar.bKt.setText(com.baidu.tieba.y.delete);
                                ccVar.bKt.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                            if (ccVar.bKt != null) {
                                ccVar.bKt.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (jVar.amA() == 1) {
                        i5 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.bIK.YS()));
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
                        ccVar.bKe.setVisibility(8);
                        com.baidu.tbadk.core.util.ba.b(ccVar.bKr, com.baidu.tieba.s.subpb_listitem_time, 1);
                        ccVar.bKr.setText(String.format(this.mContext.getResources().getString(com.baidu.tieba.y.write_addition_update), com.baidu.tbadk.core.util.bd.n(jVar.getTime())));
                        if (ccVar.bKt.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.ba.b(ccVar.bKt, com.baidu.tieba.s.cp_link_tip_c, 3);
                            ccVar.bKt.setTag(sparseArray);
                            ccVar.bKt.setOnClickListener(this.bIQ);
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
                if (jVar.amA() == 1) {
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
                String userId3 = this.bIK.YP().getAuthor().getUserId();
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
                if (jVar.amA() == 1) {
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
            tbRichTextView.setMaxImageWidth(this.bJM - (i - this.bJL));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(cc ccVar, com.baidu.tieba.tbadkCore.c.j jVar, AdditionData additionData, int i) {
        if (jVar.amF() > 0 && jVar.amz() != null) {
            ccVar.bKq.setVisibility(0);
            ccVar.bKq.removeViews(0, ccVar.bKq.getChildCount() - 1);
            int size = jVar.amz().size();
            int amG = jVar.amG();
            for (int i2 = 0; i2 < amG; i2++) {
                com.baidu.tieba.tbadkCore.c.j jVar2 = jVar.amz().get(i2);
                View a = com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.new_pb_list_item, ccVar.bKq, false);
                cc ccVar2 = new cc(a, this.bIN, this.bIM, this.mImageMaxWidth, true);
                a(ccVar2, jVar2, (View) ccVar.bKq, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, jVar2);
                sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
                if (TextUtils.isEmpty(jVar2.getBimg_url()) || !this.bIM) {
                    sparseArray.put(com.baidu.tieba.v.tag_richtext_bg, null);
                    ccVar2.bKf.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ccVar2.bKf.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    ccVar2.bKf.setLayoutParams(layoutParams);
                    ccVar2.bKf.setPadding(0, 0, 0, 0);
                    ccVar.bKf.eO(null);
                } else {
                    ccVar.bKf.eO(jVar.getBimg_url());
                    ccVar2.bKf.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ccVar2.bKf.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds36);
                    ccVar2.bKf.setLayoutParams(layoutParams2);
                }
                ccVar.bKq.addView(a, ccVar.bKq.getChildCount() - 1);
            }
            if (amG < size) {
                ccVar.bKu.setVisibility(0);
                com.baidu.tbadk.core.util.ba.i(ccVar.bKw, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.ba.i(ccVar.bKx, com.baidu.tieba.s.cp_bg_line_b);
                com.baidu.tbadk.core.util.ba.b(ccVar.bKv, com.baidu.tieba.s.cp_cont_f, 1);
                ccVar.bKu.setOnClickListener(new cb(this, amG, size, jVar));
                return;
            }
            ccVar.bKu.setVisibility(8);
            return;
        }
        ccVar.bKq.setVisibility(8);
    }

    private void a(cc ccVar) {
        ccVar.azt.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMv);
        ccVar.bKe.setOnClickListener(this.aMP);
        ccVar.bJY.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMv);
        ccVar.bKl.setOnLongClickListener(this.aeq);
        ccVar.bKf.setOnLongClickListener(this.aeq);
        ccVar.bKl.setOnTouchListener(this.bIf);
        ccVar.bKf.setOnTouchListener(this.bIf);
        ccVar.bKf.setOnImageClickListener(this.asV);
        ccVar.bKh.setOnImageClickListener(this.asV);
        ccVar.bKf.setOnEmotionClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMy);
        ccVar.aOi.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMw);
        ccVar.aIh.setOnClickListener(((PbActivity) this.bIF.getPageContext().getOrignalPage()).bHZ.bMx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        this.bIK = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.mImageMaxWidth = i;
    }

    public void dJ(boolean z) {
        this.bIM = z;
    }

    public void dK(boolean z) {
        this.bIN = z;
    }

    public void dL(boolean z) {
        this.bIO = z;
    }

    public void hJ(String str) {
        this.bIP = str;
    }

    public void t(View.OnClickListener onClickListener) {
        this.bIQ = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.aMP = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.asV = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bIf = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aeq = onLongClickListener;
    }
}
