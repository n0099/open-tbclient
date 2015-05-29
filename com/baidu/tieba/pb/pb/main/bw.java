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
public class bw extends bn<com.baidu.tieba.tbadkCore.data.j, ca> implements View.OnClickListener {
    private static HashMap<Point, Integer> bMd = new HashMap<>();
    private ArrayList<IconData> aKi;
    private View.OnClickListener aPm;
    private View.OnLongClickListener afC;
    private com.baidu.tbadk.widget.richText.s auJ;
    private com.baidu.tieba.pb.b.d bKG;
    private com.baidu.tieba.pb.a.b bLe;
    private boolean bLg;
    private boolean bLh;
    private boolean bLi;
    private String bLj;
    private View.OnClickListener bLk;
    private com.baidu.tieba.pb.pb.sub.ag bLl;
    private ArrayList<IconData> bMc;
    private boolean bMe;
    private final boolean bMf;
    private int bMg;
    private int bMh;
    private int mImageMaxWidth;
    private int width;

    static {
        bMd.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.t.i_want_lottery));
        bMd.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.t.look_result));
        bMd.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.t.i_want_lottery));
        bMd.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.t.i_want_share_picture));
        bMd.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.t.look_result));
        bMd.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.t.i_want_share_picture));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.width = -1;
        this.mImageMaxWidth = 0;
        this.bLg = true;
        this.bLh = true;
        this.bLi = true;
        this.bLe = null;
        this.bLj = null;
        this.bLl = null;
        this.bMc = null;
        this.aKi = null;
        this.bLk = null;
        this.aPm = null;
        this.auJ = null;
        this.bKG = null;
        this.afC = null;
        this.bMe = false;
        this.bMf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.bMg = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30);
        this.bMh = com.baidu.adp.lib.util.n.M(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public ca a(ViewGroup viewGroup) {
        return new ca(com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.new_pb_list_item, viewGroup, false), this.bLh, this.bLg, this.mImageMaxWidth, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.j jVar, ca caVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.tbadkCore.data.j) caVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(caVar);
        com.baidu.tieba.tbadkCore.data.j jVar2 = (com.baidu.tieba.tbadkCore.data.j) ay(i);
        com.baidu.tbadk.core.util.ay.j(caVar.bMp, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.j(caVar.bMq, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.b(caVar.bMM, com.baidu.tieba.n.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMO, com.baidu.tieba.n.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.ay.b(caVar.aBm, com.baidu.tieba.n.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMu, com.baidu.tieba.n.cp_cont_i, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMw, com.baidu.tieba.n.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMx, com.baidu.tieba.n.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ay.c(caVar.bMz, com.baidu.tieba.p.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.ay.j(caVar.bMD, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.j(caVar.bME, com.baidu.tieba.n.cp_bg_line_e);
        com.baidu.tbadk.core.util.ay.j(caVar.bMF, com.baidu.tieba.n.cp_bg_line_e);
        com.baidu.tbadk.core.util.ay.c(caVar.bMF, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.c(caVar.bMI, com.baidu.tieba.n.cp_bg_line_b);
        int ru = this.bLe.aas().ru();
        if (ru == 1 || ru == 4) {
            com.baidu.tbadk.core.util.ay.b(caVar.bMB, com.baidu.tieba.n.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ay.i((View) caVar.bMB, com.baidu.tieba.p.buy_yinji_btn_bg);
        } else if (ru == 2) {
            com.baidu.tbadk.core.util.ay.b(caVar.bMB, com.baidu.tieba.n.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ay.i((View) caVar.bMB, com.baidu.tieba.p.btn_pb_bottom_comment_selector);
        }
        if (jVar2 != null) {
            a(caVar, jVar2, view, false, i);
        }
        if (!this.bMe && this.bMf && caVar != null && caVar.bMA.EB() && (listView = ((PbActivity) this.bKZ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.bMe = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0581 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x09db  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0a21  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0a3d  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ca caVar, com.baidu.tieba.tbadkCore.data.j jVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (caVar != null && jVar != null) {
            if (!z) {
                caVar.bMt.setTag(null);
                caVar.bMt.setUserId(null);
                caVar.aBm.setText((CharSequence) null);
                caVar.bMJ.setVisibility(0);
                caVar.bMz.setVisibility(0);
                caVar.bMy.setVisibility(8);
                if (jVar.aoD() == null) {
                    caVar.bMK.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && jVar.aoD().yG() == 1) {
                    caVar.bMK.changeSkinType(this.mSkinType);
                    caVar.bMK.setVisibility(0);
                    caVar.bMK.setData(jVar.aoD());
                } else {
                    caVar.bMK.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) caVar.bMG.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    caVar.bMG.setTag(sparseArray2);
                    caVar.bMA.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.q.tag_clip_board, jVar);
                sparseArray2.put(com.baidu.tieba.q.tag_is_subpb, false);
                a(caVar.bMA, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30));
                if (TextUtils.isEmpty(jVar.getBimg_url()) || !this.bLg) {
                    sparseArray2.put(com.baidu.tieba.q.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) caVar.bMA.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    caVar.bMA.setLayoutParams(layoutParams);
                    caVar.bMA.setPadding(0, 0, 0, 0);
                    caVar.bMA.fm(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.q.tag_richtext_bg, jVar.getBimg_url());
                    caVar.bMA.fm(jVar.getBimg_url());
                    if (jVar.aoB() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) caVar.bMA.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds40);
                        caVar.bMA.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) caVar.bMA.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds20);
                        caVar.bMA.setLayoutParams(layoutParams3);
                    }
                }
                caVar.bMx.setText(com.baidu.tbadk.core.util.bb.o(jVar.getTime()));
                if (jVar.aoB() == 1) {
                    com.baidu.tbadk.core.util.ay.j(caVar.bMo, com.baidu.tieba.n.cp_bg_line_d);
                    caVar.bMp.setVisibility(8);
                    caVar.bMq.setVisibility(8);
                    caVar.bMr.setVisibility(8);
                    caVar.bMG.setVisibility(8);
                    caVar.bMx.setVisibility(8);
                    if (this.bLi) {
                        PraiseData praise = this.bLe.aas().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            caVar.bME.setVisibility(0);
                            caVar.bMD.setVisibility(0);
                            caVar.bMF.setVisibility(0);
                            caVar.bME.setIsFromPb(true);
                            caVar.bME.a(praise, this.bLe.aas().getId(), praise.getPostId(), true);
                            caVar.bME.cz(this.mSkinType);
                        } else {
                            caVar.bME.setVisibility(8);
                            caVar.bMD.setVisibility(8);
                            caVar.bMF.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aoE = jVar.aoE();
                        caVar.bMW.setVisibility(8);
                        if (aoE != null && !TextUtils.isEmpty(aoE.getName()) && !TextUtils.isEmpty(aoE.getName().trim())) {
                            String name = aoE.getName();
                            String lat = aoE.getLat();
                            String lng = aoE.getLng();
                            caVar.bMT.setVisibility(0);
                            com.baidu.adp.lib.util.n.a(this.mContext, caVar.bMT, 0, 10, 0, 10);
                            caVar.bMV.setText(aoE.getName());
                            com.baidu.tbadk.core.util.ay.b(caVar.bMV, com.baidu.tieba.n.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.ay.c(caVar.bMU, com.baidu.tieba.p.icon_frs_site);
                            caVar.bMT.setOnClickListener(new bx(this, lat, lng, name));
                        } else {
                            caVar.bMT.setVisibility(8);
                        }
                    } else {
                        caVar.bME.setVisibility(8);
                        caVar.bMD.setVisibility(8);
                        caVar.bMF.setVisibility(8);
                        caVar.bMT.setVisibility(8);
                        caVar.bMW.setVisibility(8);
                    }
                    a(caVar.bMA, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30));
                    ((LinearLayout.LayoutParams) caVar.bMK.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30);
                } else {
                    com.baidu.tbadk.core.util.ay.j(caVar.bMo, com.baidu.tieba.n.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bLi) {
                            caVar.bMp.setVisibility(8);
                            caVar.bMq.setVisibility(8);
                            PraiseData praise2 = this.bLe.aas().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                caVar.bMq.setVisibility(8);
                                caVar.bMp.setVisibility(0);
                            } else {
                                caVar.bMq.setVisibility(0);
                                caVar.bMp.setVisibility(8);
                            }
                        } else {
                            caVar.bMp.setVisibility(0);
                            caVar.bMq.setVisibility(8);
                        }
                    } else {
                        caVar.bMp.setVisibility(0);
                        caVar.bMq.setVisibility(8);
                    }
                    caVar.bMr.setVisibility(0);
                    com.baidu.tbadk.data.d aoE2 = jVar.aoE();
                    caVar.bMT.setVisibility(8);
                    if (aoE2 != null && !TextUtils.isEmpty(aoE2.getName()) && !TextUtils.isEmpty(aoE2.getName().trim())) {
                        String name2 = aoE2.getName();
                        String lat2 = aoE2.getLat();
                        String lng2 = aoE2.getLng();
                        caVar.bMW.setVisibility(0);
                        caVar.bMY.setText(aoE2.getName());
                        com.baidu.tbadk.core.util.ay.b(caVar.bMY, com.baidu.tieba.n.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.ay.c(caVar.bMX, com.baidu.tieba.p.icon_frs_site);
                        caVar.bMW.setOnClickListener(new by(this, lat2, lng2, name2));
                    } else {
                        caVar.bMW.setVisibility(8);
                    }
                    caVar.bME.setVisibility(8);
                    caVar.bMD.setVisibility(8);
                    caVar.bMF.setVisibility(8);
                    caVar.bMG.setVisibility(0);
                    caVar.bMx.setVisibility(0);
                    String format = String.format(this.mContext.getString(com.baidu.tieba.t.is_floor), Integer.valueOf(jVar.aoB()));
                    caVar.bMw.setVisibility(0);
                    caVar.bMw.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) caVar.bMK.getLayoutParams();
                    if (!this.bLh) {
                        a(caVar.bMA, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds74);
                    } else {
                        a(caVar.bMA, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) caVar.bMH.getLayoutParams();
                    if (!this.bLh) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30);
                    }
                }
                if (this.bLj != null && !this.bLj.equals(GameInfoData.NOT_FROM_DETAIL) && this.bLj.equals(jVar.getAuthor().getUserId())) {
                    caVar.bMy.setVisibility(0);
                    com.baidu.tbadk.core.util.ay.c(caVar.bMy, com.baidu.tieba.p.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.ay.i(caVar.bMs, com.baidu.tieba.p.bg_floor_new_middle);
            caVar.bMA.setVideoImageId(com.baidu.tieba.p.pic_video);
            caVar.bMA.setTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.pb_listitem_content));
            com.baidu.tbadk.core.util.ay.c(caVar.bMz, com.baidu.tieba.p.btn_pb_reply_selector);
            caVar.bMA.setLinkTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) caVar.bMz.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                caVar.bMz.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.q.tag_load_sub_data, jVar);
            sparseArray.put(com.baidu.tieba.q.tag_load_sub_view, view);
            if (jVar.aoF() > 0) {
                if (this.bLl == null) {
                    this.bLl = new com.baidu.tieba.pb.pb.sub.ag(this.mContext);
                    this.bLl.setIsFromCDN(this.mIsFromCDN);
                    this.bLl.w(this.bLk);
                    boolean z7 = false;
                    String userId = this.bLe.aas().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bLl.p(this.bLe.aav(), z7);
                    this.bLl.dT(this.bLh);
                }
                caVar.bMJ.setVisibility(0);
                caVar.bMI.setVisibility(0);
                caVar.bMH.setVisibility(0);
                caVar.bMJ.a(jVar, view);
                caVar.bMJ.setChildOnClickListener(this.aPm);
                caVar.bMJ.setChildOnLongClickListener(this.afC);
                caVar.bMJ.setChildOnTouchListener(this.bKG);
                caVar.bMJ.setSubPbAdapter(this.bLl);
                caVar.bMJ.setVisibility(0);
            } else {
                caVar.bMJ.setVisibility(8);
                caVar.bMI.setVisibility(8);
                caVar.bMH.setVisibility(8);
            }
            a(caVar, jVar, this.bLe.aax(), i);
            if (!z) {
                String portrait = jVar.getAuthor().getPortrait();
                if (jVar.getAuthor() != null) {
                    caVar.aBm.setText(jVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.ay.b(caVar.aBm, com.baidu.tieba.n.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ay.b(caVar.aBm, com.baidu.tieba.n.cp_cont_f, 1);
                    }
                    int level_id = jVar.getAuthor().getLevel_id();
                    int is_bawu = jVar.getAuthor().getIs_bawu();
                    String bawu_type = jVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        caVar.bMu.setVisibility(0);
                        com.baidu.tbadk.core.util.ay.c(caVar.bMu, com.baidu.tbadk.core.util.c.bT(level_id));
                        i2 = 2;
                        caVar.bMu.setOnClickListener(null);
                    } else {
                        caVar.bMu.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ay.c(caVar.bMu, com.baidu.tieba.p.pb_manager);
                            caVar.bMu.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOK);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ay.c(caVar.bMu, com.baidu.tieba.p.pb_assist);
                            caVar.bMu.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOK);
                        }
                    }
                    if (jVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.ay.c(caVar.bMv, com.baidu.tieba.p.icon_pop_girl_square);
                        caVar.bMv.setVisibility(0);
                    } else {
                        caVar.bMv.setVisibility(8);
                    }
                    this.bMc = jVar.getAuthor().getIconInfo();
                    this.aKi = jVar.getAuthor().getTShowInfo();
                    if (caVar.aQK != null) {
                        caVar.aQK.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOK);
                        caVar.aQK.a(this.bMc, i2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_margin));
                    }
                    if (caVar.aKx != null) {
                        caVar.aKx.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOL);
                        caVar.aKx.a(this.aKi, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_margin), true);
                    }
                }
                caVar.bMt.setUserId(jVar.getAuthor().getUserId());
                caVar.bMt.setUserName(jVar.getAuthor().getUserName());
                caVar.bMt.setImageDrawable(null);
                caVar.aBm.setTag(com.baidu.tieba.q.tag_user_id, jVar.getAuthor().getUserId());
                caVar.aBm.setTag(com.baidu.tieba.q.tag_user_name, jVar.getAuthor().getUserName());
                caVar.bMt.c(portrait, 28, false);
            }
            caVar.bMA.setLinkTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_link_tip_c));
            if (this.bLg) {
                caVar.bMA.setDefaultImageId(com.baidu.tieba.p.img_default_100);
            } else {
                caVar.bMA.setDefaultImageId(com.baidu.tieba.p.icon_click);
            }
            caVar.bMA.setIsFromCDN(this.mIsFromCDN);
            if (this.bLg) {
                caVar.bMC.setDefaultImageId(com.baidu.tieba.p.img_default_100);
            } else {
                caVar.bMC.setDefaultImageId(com.baidu.tieba.p.icon_click);
            }
            caVar.bMC.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (jVar.aoB() == 1 && this.bLe.aas().rw()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a aoC = jVar.aoC();
                if (aoC != null && aoC.El() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> El = aoC.El();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= El.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = El.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.g Eq = cVar.Eq();
                            Eq.setWidth(caVar.bMC.getMaxImageWidth());
                            Eq.setHeight(caVar.bMC.getMaxImageHeight());
                            Eq.bp(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                caVar.bMB.setVisibility(8);
                caVar.bMC.setVisibility(8);
                if (arrayList.size() >= 1) {
                    caVar.bMC.setVisibility(0);
                }
                int ru = this.bLe.aas().ru();
                if (ru == 1 || ru == 2 || ru == 4) {
                    caVar.bMB.setVisibility(0);
                    caVar.bMB.setOnClickListener(this.aPm);
                    caVar.bMB.setEnabled(true);
                }
                Integer num = bMd.get(new Point(this.bLe.aas().rv(), ru));
                if (num != null) {
                    caVar.bMB.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                caVar.bMB.setVisibility(8);
                caVar.bMC.setVisibility(8);
            }
            if (aVar == null) {
                aVar = jVar.aoC();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.bMe || !this.bMf) {
                caVar.bMA.a(aVar, false);
                caVar.bMC.a(aVar3, false);
            } else {
                caVar.bMA.a(aVar, true);
                caVar.bMC.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bLe.aav() != 0) {
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
                        sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, true);
                        if (caVar.bMO != null) {
                            caVar.bMO.setVisibility(0);
                            caVar.bMO.setText(com.baidu.tieba.t.manage);
                            caVar.bMO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, true);
                            if (caVar.bMO != null) {
                                caVar.bMO.setVisibility(0);
                                caVar.bMO.setText(com.baidu.tieba.t.delete);
                                caVar.bMO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, false);
                            if (caVar.bMO != null) {
                                caVar.bMO.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (jVar.aoB() == 1) {
                        i5 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(this.bLe.aav()));
                    }
                    if (z2) {
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_id, jVar.getId());
                    } else {
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_id, "");
                    }
                    sparseArray.put(com.baidu.tieba.q.tag_forbid_user_post_id, jVar.getId());
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.q.tag_forbid_user_name, jVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(com.baidu.tieba.q.tag_forbid_user_name, "");
                    }
                    if (z) {
                        caVar.bMz.setVisibility(8);
                        com.baidu.tbadk.core.util.ay.b(caVar.bMM, com.baidu.tieba.n.subpb_listitem_time, 1);
                        caVar.bMM.setText(String.format(this.mContext.getResources().getString(com.baidu.tieba.t.write_addition_update), com.baidu.tbadk.core.util.bb.o(jVar.getTime())));
                        if (caVar.bMO.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.ay.b(caVar.bMO, com.baidu.tieba.n.cp_link_tip_c, 3);
                            caVar.bMO.setTag(sparseArray);
                            caVar.bMO.setOnClickListener(this.bLk);
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
                if (jVar.aoB() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                sparseArray.put(com.baidu.tieba.q.tag_forbid_user_post_id, jVar.getId());
                if (z3) {
                }
                if (z) {
                }
            } else {
                String userId3 = this.bLe.aas().getAuthor().getUserId();
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
                if (jVar.aoB() == 1) {
                }
                if (z6) {
                }
                if (z2) {
                }
                sparseArray.put(com.baidu.tieba.q.tag_forbid_user_post_id, jVar.getId());
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
            tbRichTextView.setMaxImageWidth(this.bMh - (i - this.bMg));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(ca caVar, com.baidu.tieba.tbadkCore.data.j jVar, AdditionData additionData, int i) {
        if (jVar.aoG() > 0 && jVar.aoA() != null) {
            caVar.bML.setVisibility(0);
            caVar.bML.removeViews(0, caVar.bML.getChildCount() - 1);
            int size = jVar.aoA().size();
            int aoH = jVar.aoH();
            for (int i2 = 0; i2 < aoH; i2++) {
                com.baidu.tieba.tbadkCore.data.j jVar2 = jVar.aoA().get(i2);
                View a = com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.new_pb_list_item, caVar.bML, false);
                ca caVar2 = new ca(a, this.bLh, this.bLg, this.mImageMaxWidth, true);
                a(caVar2);
                a(caVar2, jVar2, (View) caVar.bML, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.q.tag_clip_board, jVar2);
                sparseArray.put(com.baidu.tieba.q.tag_is_subpb, true);
                if (TextUtils.isEmpty(jVar2.getBimg_url()) || !this.bLg) {
                    sparseArray.put(com.baidu.tieba.q.tag_richtext_bg, null);
                    caVar2.bMA.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) caVar2.bMA.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    caVar2.bMA.setLayoutParams(layoutParams);
                    caVar2.bMA.setPadding(0, 0, 0, 0);
                    caVar.bMA.fm(null);
                } else {
                    caVar.bMA.fm(jVar.getBimg_url());
                    caVar2.bMA.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) caVar2.bMA.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds36);
                    caVar2.bMA.setLayoutParams(layoutParams2);
                }
                caVar.bML.addView(a, caVar.bML.getChildCount() - 1);
            }
            if (aoH < size) {
                caVar.bMP.setVisibility(0);
                com.baidu.tbadk.core.util.ay.i(caVar.bMR, com.baidu.tieba.n.cp_bg_line_b);
                com.baidu.tbadk.core.util.ay.i(caVar.bMS, com.baidu.tieba.n.cp_bg_line_b);
                com.baidu.tbadk.core.util.ay.b(caVar.bMQ, com.baidu.tieba.n.cp_cont_f, 1);
                caVar.bMP.setOnClickListener(new bz(this, aoH, size, jVar));
                return;
            }
            caVar.bMP.setVisibility(8);
            return;
        }
        caVar.bML.setVisibility(8);
    }

    private void a(ca caVar) {
        caVar.aBm.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOJ);
        caVar.bMz.setOnClickListener(this.aPm);
        caVar.bMt.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOJ);
        caVar.bMG.setOnLongClickListener(this.afC);
        caVar.bMA.setOnLongClickListener(this.afC);
        caVar.bMG.setOnTouchListener(this.bKG);
        caVar.bMA.setOnTouchListener(this.bKG);
        caVar.bMA.setOnImageClickListener(this.auJ);
        caVar.bMC.setOnImageClickListener(this.auJ);
        caVar.bMA.setOnEmotionClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOM);
        caVar.aQK.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOK);
        caVar.aKx.setOnClickListener(((PbActivity) this.bKZ.getPageContext().getOrignalPage()).bKA.bOL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        this.bLe = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.mImageMaxWidth = i;
    }

    public void setIsShowImage(boolean z) {
        this.bLg = z;
    }

    public void dT(boolean z) {
        this.bLh = z;
    }

    public void dU(boolean z) {
        this.bLi = z;
    }

    public void ir(String str) {
        this.bLj = str;
    }

    public void t(View.OnClickListener onClickListener) {
        this.bLk = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.aPm = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.auJ = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bKG = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afC = onLongClickListener;
    }
}
