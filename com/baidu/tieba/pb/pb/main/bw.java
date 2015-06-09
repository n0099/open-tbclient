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
    private static HashMap<Point, Integer> bMe = new HashMap<>();
    private ArrayList<IconData> aKj;
    private View.OnClickListener aPn;
    private View.OnLongClickListener afC;
    private com.baidu.tbadk.widget.richText.s auJ;
    private com.baidu.tieba.pb.b.d bKH;
    private com.baidu.tieba.pb.a.b bLf;
    private boolean bLh;
    private boolean bLi;
    private boolean bLj;
    private String bLk;
    private View.OnClickListener bLl;
    private com.baidu.tieba.pb.pb.sub.ag bLm;
    private ArrayList<IconData> bMd;
    private boolean bMf;
    private final boolean bMg;
    private int bMh;
    private int bMi;
    private int mImageMaxWidth;
    private int width;

    static {
        bMe.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.t.i_want_lottery));
        bMe.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.t.look_result));
        bMe.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.t.i_want_lottery));
        bMe.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.t.i_want_share_picture));
        bMe.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.t.look_result));
        bMe.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.t.i_want_share_picture));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.width = -1;
        this.mImageMaxWidth = 0;
        this.bLh = true;
        this.bLi = true;
        this.bLj = true;
        this.bLf = null;
        this.bLk = null;
        this.bLm = null;
        this.bMd = null;
        this.aKj = null;
        this.bLl = null;
        this.aPn = null;
        this.auJ = null;
        this.bKH = null;
        this.afC = null;
        this.bMf = false;
        this.bMg = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.bMh = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30);
        this.bMi = com.baidu.adp.lib.util.n.M(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public ca a(ViewGroup viewGroup) {
        return new ca(com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.new_pb_list_item, viewGroup, false), this.bLi, this.bLh, this.mImageMaxWidth, false);
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
        com.baidu.tbadk.core.util.ay.j(caVar.bMq, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.j(caVar.bMr, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.b(caVar.bMN, com.baidu.tieba.n.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMP, com.baidu.tieba.n.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.ay.b(caVar.aBn, com.baidu.tieba.n.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMv, com.baidu.tieba.n.cp_cont_i, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMx, com.baidu.tieba.n.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ay.b(caVar.bMy, com.baidu.tieba.n.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ay.c(caVar.bMA, com.baidu.tieba.p.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.ay.j(caVar.bME, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.j(caVar.bMF, com.baidu.tieba.n.cp_bg_line_e);
        com.baidu.tbadk.core.util.ay.j(caVar.bMG, com.baidu.tieba.n.cp_bg_line_e);
        com.baidu.tbadk.core.util.ay.c(caVar.bMG, com.baidu.tieba.n.cp_bg_line_b);
        com.baidu.tbadk.core.util.ay.c(caVar.bMJ, com.baidu.tieba.n.cp_bg_line_b);
        int ru = this.bLf.aat().ru();
        if (ru == 1 || ru == 4) {
            com.baidu.tbadk.core.util.ay.b(caVar.bMC, com.baidu.tieba.n.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ay.i((View) caVar.bMC, com.baidu.tieba.p.buy_yinji_btn_bg);
        } else if (ru == 2) {
            com.baidu.tbadk.core.util.ay.b(caVar.bMC, com.baidu.tieba.n.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ay.i((View) caVar.bMC, com.baidu.tieba.p.btn_pb_bottom_comment_selector);
        }
        if (jVar2 != null) {
            a(caVar, jVar2, view, false, i);
        }
        if (!this.bMf && this.bMg && caVar != null && caVar.bMB.EC() && (listView = ((PbActivity) this.bLa.getPageContext().getOrignalPage()).getListView()) != null) {
            this.bMf = true;
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
                caVar.bMu.setTag(null);
                caVar.bMu.setUserId(null);
                caVar.aBn.setText((CharSequence) null);
                caVar.bMK.setVisibility(0);
                caVar.bMA.setVisibility(0);
                caVar.bMz.setVisibility(8);
                if (jVar.aoE() == null) {
                    caVar.bML.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && jVar.aoE().yH() == 1) {
                    caVar.bML.changeSkinType(this.mSkinType);
                    caVar.bML.setVisibility(0);
                    caVar.bML.setData(jVar.aoE());
                } else {
                    caVar.bML.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) caVar.bMH.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    caVar.bMH.setTag(sparseArray2);
                    caVar.bMB.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.q.tag_clip_board, jVar);
                sparseArray2.put(com.baidu.tieba.q.tag_is_subpb, false);
                a(caVar.bMB, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30));
                if (TextUtils.isEmpty(jVar.getBimg_url()) || !this.bLh) {
                    sparseArray2.put(com.baidu.tieba.q.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) caVar.bMB.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    caVar.bMB.setLayoutParams(layoutParams);
                    caVar.bMB.setPadding(0, 0, 0, 0);
                    caVar.bMB.fm(null);
                } else {
                    sparseArray2.put(com.baidu.tieba.q.tag_richtext_bg, jVar.getBimg_url());
                    caVar.bMB.fm(jVar.getBimg_url());
                    if (jVar.aoC() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) caVar.bMB.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds40);
                        caVar.bMB.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) caVar.bMB.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds20);
                        caVar.bMB.setLayoutParams(layoutParams3);
                    }
                }
                caVar.bMy.setText(com.baidu.tbadk.core.util.bb.o(jVar.getTime()));
                if (jVar.aoC() == 1) {
                    com.baidu.tbadk.core.util.ay.j(caVar.bMp, com.baidu.tieba.n.cp_bg_line_d);
                    caVar.bMq.setVisibility(8);
                    caVar.bMr.setVisibility(8);
                    caVar.bMs.setVisibility(8);
                    caVar.bMH.setVisibility(8);
                    caVar.bMy.setVisibility(8);
                    if (this.bLj) {
                        PraiseData praise = this.bLf.aat().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            caVar.bMF.setVisibility(0);
                            caVar.bME.setVisibility(0);
                            caVar.bMG.setVisibility(0);
                            caVar.bMF.setIsFromPb(true);
                            caVar.bMF.a(praise, this.bLf.aat().getId(), praise.getPostId(), true);
                            caVar.bMF.cz(this.mSkinType);
                        } else {
                            caVar.bMF.setVisibility(8);
                            caVar.bME.setVisibility(8);
                            caVar.bMG.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aoF = jVar.aoF();
                        caVar.bMX.setVisibility(8);
                        if (aoF != null && !TextUtils.isEmpty(aoF.getName()) && !TextUtils.isEmpty(aoF.getName().trim())) {
                            String name = aoF.getName();
                            String lat = aoF.getLat();
                            String lng = aoF.getLng();
                            caVar.bMU.setVisibility(0);
                            com.baidu.adp.lib.util.n.a(this.mContext, caVar.bMU, 0, 10, 0, 10);
                            caVar.bMW.setText(aoF.getName());
                            com.baidu.tbadk.core.util.ay.b(caVar.bMW, com.baidu.tieba.n.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.ay.c(caVar.bMV, com.baidu.tieba.p.icon_frs_site);
                            caVar.bMU.setOnClickListener(new bx(this, lat, lng, name));
                        } else {
                            caVar.bMU.setVisibility(8);
                        }
                    } else {
                        caVar.bMF.setVisibility(8);
                        caVar.bME.setVisibility(8);
                        caVar.bMG.setVisibility(8);
                        caVar.bMU.setVisibility(8);
                        caVar.bMX.setVisibility(8);
                    }
                    a(caVar.bMB, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30));
                    ((LinearLayout.LayoutParams) caVar.bML.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30);
                } else {
                    com.baidu.tbadk.core.util.ay.j(caVar.bMp, com.baidu.tieba.n.cp_bg_line_e);
                    if (i == 1) {
                        if (this.bLj) {
                            caVar.bMq.setVisibility(8);
                            caVar.bMr.setVisibility(8);
                            PraiseData praise2 = this.bLf.aat().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                caVar.bMr.setVisibility(8);
                                caVar.bMq.setVisibility(0);
                            } else {
                                caVar.bMr.setVisibility(0);
                                caVar.bMq.setVisibility(8);
                            }
                        } else {
                            caVar.bMq.setVisibility(0);
                            caVar.bMr.setVisibility(8);
                        }
                    } else {
                        caVar.bMq.setVisibility(0);
                        caVar.bMr.setVisibility(8);
                    }
                    caVar.bMs.setVisibility(0);
                    com.baidu.tbadk.data.d aoF2 = jVar.aoF();
                    caVar.bMU.setVisibility(8);
                    if (aoF2 != null && !TextUtils.isEmpty(aoF2.getName()) && !TextUtils.isEmpty(aoF2.getName().trim())) {
                        String name2 = aoF2.getName();
                        String lat2 = aoF2.getLat();
                        String lng2 = aoF2.getLng();
                        caVar.bMX.setVisibility(0);
                        caVar.bMZ.setText(aoF2.getName());
                        com.baidu.tbadk.core.util.ay.b(caVar.bMZ, com.baidu.tieba.n.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.ay.c(caVar.bMY, com.baidu.tieba.p.icon_frs_site);
                        caVar.bMX.setOnClickListener(new by(this, lat2, lng2, name2));
                    } else {
                        caVar.bMX.setVisibility(8);
                    }
                    caVar.bMF.setVisibility(8);
                    caVar.bME.setVisibility(8);
                    caVar.bMG.setVisibility(8);
                    caVar.bMH.setVisibility(0);
                    caVar.bMy.setVisibility(0);
                    String format = String.format(this.mContext.getString(com.baidu.tieba.t.is_floor), Integer.valueOf(jVar.aoC()));
                    caVar.bMx.setVisibility(0);
                    caVar.bMx.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) caVar.bML.getLayoutParams();
                    if (!this.bLi) {
                        a(caVar.bMB, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds74);
                    } else {
                        a(caVar.bMB, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) caVar.bMI.getLayoutParams();
                    if (!this.bLi) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds30);
                    }
                }
                if (this.bLk != null && !this.bLk.equals(GameInfoData.NOT_FROM_DETAIL) && this.bLk.equals(jVar.getAuthor().getUserId())) {
                    caVar.bMz.setVisibility(0);
                    com.baidu.tbadk.core.util.ay.c(caVar.bMz, com.baidu.tieba.p.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.ay.i(caVar.bMt, com.baidu.tieba.p.bg_floor_new_middle);
            caVar.bMB.setVideoImageId(com.baidu.tieba.p.pic_video);
            caVar.bMB.setTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.pb_listitem_content));
            com.baidu.tbadk.core.util.ay.c(caVar.bMA, com.baidu.tieba.p.btn_pb_reply_selector);
            caVar.bMB.setLinkTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) caVar.bMA.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                caVar.bMA.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.q.tag_load_sub_data, jVar);
            sparseArray.put(com.baidu.tieba.q.tag_load_sub_view, view);
            if (jVar.aoG() > 0) {
                if (this.bLm == null) {
                    this.bLm = new com.baidu.tieba.pb.pb.sub.ag(this.mContext);
                    this.bLm.setIsFromCDN(this.mIsFromCDN);
                    this.bLm.w(this.bLl);
                    boolean z7 = false;
                    String userId = this.bLf.aat().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.bLm.p(this.bLf.aaw(), z7);
                    this.bLm.dT(this.bLi);
                }
                caVar.bMK.setVisibility(0);
                caVar.bMJ.setVisibility(0);
                caVar.bMI.setVisibility(0);
                caVar.bMK.a(jVar, view);
                caVar.bMK.setChildOnClickListener(this.aPn);
                caVar.bMK.setChildOnLongClickListener(this.afC);
                caVar.bMK.setChildOnTouchListener(this.bKH);
                caVar.bMK.setSubPbAdapter(this.bLm);
                caVar.bMK.setVisibility(0);
            } else {
                caVar.bMK.setVisibility(8);
                caVar.bMJ.setVisibility(8);
                caVar.bMI.setVisibility(8);
            }
            a(caVar, jVar, this.bLf.aay(), i);
            if (!z) {
                String portrait = jVar.getAuthor().getPortrait();
                if (jVar.getAuthor() != null) {
                    caVar.aBn.setText(jVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.ay.b(caVar.aBn, com.baidu.tieba.n.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ay.b(caVar.aBn, com.baidu.tieba.n.cp_cont_f, 1);
                    }
                    int level_id = jVar.getAuthor().getLevel_id();
                    int is_bawu = jVar.getAuthor().getIs_bawu();
                    String bawu_type = jVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        caVar.bMv.setVisibility(0);
                        com.baidu.tbadk.core.util.ay.c(caVar.bMv, com.baidu.tbadk.core.util.c.bT(level_id));
                        i2 = 2;
                        caVar.bMv.setOnClickListener(null);
                    } else {
                        caVar.bMv.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ay.c(caVar.bMv, com.baidu.tieba.p.pb_manager);
                            caVar.bMv.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOL);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ay.c(caVar.bMv, com.baidu.tieba.p.pb_assist);
                            caVar.bMv.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOL);
                        }
                    }
                    if (jVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.ay.c(caVar.bMw, com.baidu.tieba.p.icon_pop_girl_square);
                        caVar.bMw.setVisibility(0);
                    } else {
                        caVar.bMw.setVisibility(8);
                    }
                    this.bMd = jVar.getAuthor().getIconInfo();
                    this.aKj = jVar.getAuthor().getTShowInfo();
                    if (caVar.aQL != null) {
                        caVar.aQL.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOL);
                        caVar.aQL.a(this.bMd, i2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_margin));
                    }
                    if (caVar.aKy != null) {
                        caVar.aKy.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOM);
                        caVar.aKy.a(this.aKj, 3, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_margin), true);
                    }
                }
                caVar.bMu.setUserId(jVar.getAuthor().getUserId());
                caVar.bMu.setUserName(jVar.getAuthor().getUserName());
                caVar.bMu.setImageDrawable(null);
                caVar.aBn.setTag(com.baidu.tieba.q.tag_user_id, jVar.getAuthor().getUserId());
                caVar.aBn.setTag(com.baidu.tieba.q.tag_user_name, jVar.getAuthor().getUserName());
                caVar.bMu.c(portrait, 28, false);
            }
            caVar.bMB.setLinkTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_link_tip_c));
            if (this.bLh) {
                caVar.bMB.setDefaultImageId(com.baidu.tieba.p.img_default_100);
            } else {
                caVar.bMB.setDefaultImageId(com.baidu.tieba.p.icon_click);
            }
            caVar.bMB.setIsFromCDN(this.mIsFromCDN);
            if (this.bLh) {
                caVar.bMD.setDefaultImageId(com.baidu.tieba.p.img_default_100);
            } else {
                caVar.bMD.setDefaultImageId(com.baidu.tieba.p.icon_click);
            }
            caVar.bMD.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (jVar.aoC() == 1 && this.bLf.aat().rw()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a aoD = jVar.aoD();
                if (aoD != null && aoD.Em() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> Em = aoD.Em();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= Em.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = Em.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.g Er = cVar.Er();
                            Er.setWidth(caVar.bMD.getMaxImageWidth());
                            Er.setHeight(caVar.bMD.getMaxImageHeight());
                            Er.bp(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                caVar.bMC.setVisibility(8);
                caVar.bMD.setVisibility(8);
                if (arrayList.size() >= 1) {
                    caVar.bMD.setVisibility(0);
                }
                int ru = this.bLf.aat().ru();
                if (ru == 1 || ru == 2 || ru == 4) {
                    caVar.bMC.setVisibility(0);
                    caVar.bMC.setOnClickListener(this.aPn);
                    caVar.bMC.setEnabled(true);
                }
                Integer num = bMe.get(new Point(this.bLf.aat().rv(), ru));
                if (num != null) {
                    caVar.bMC.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                caVar.bMC.setVisibility(8);
                caVar.bMD.setVisibility(8);
            }
            if (aVar == null) {
                aVar = jVar.aoD();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.bMf || !this.bMg) {
                caVar.bMB.a(aVar, false);
                caVar.bMD.a(aVar3, false);
            } else {
                caVar.bMB.a(aVar, true);
                caVar.bMD.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.bLf.aaw() != 0) {
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
                        if (caVar.bMP != null) {
                            caVar.bMP.setVisibility(0);
                            caVar.bMP.setText(com.baidu.tieba.t.manage);
                            caVar.bMP.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                            z6 = true;
                        }
                        z6 = z5;
                    } else {
                        if (z2) {
                            z5 = true;
                            sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, true);
                            if (caVar.bMP != null) {
                                caVar.bMP.setVisibility(0);
                                caVar.bMP.setText(com.baidu.tieba.t.delete);
                                caVar.bMP.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                z6 = true;
                            }
                        } else {
                            z5 = false;
                            sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, false);
                            if (caVar.bMP != null) {
                                caVar.bMP.setVisibility(8);
                            }
                        }
                        z6 = z5;
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (jVar.aoC() == 1) {
                        i5 = 0;
                    }
                    if (z6) {
                        sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(this.bLf.aaw()));
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
                        caVar.bMA.setVisibility(8);
                        com.baidu.tbadk.core.util.ay.b(caVar.bMN, com.baidu.tieba.n.subpb_listitem_time, 1);
                        caVar.bMN.setText(String.format(this.mContext.getResources().getString(com.baidu.tieba.t.write_addition_update), com.baidu.tbadk.core.util.bb.o(jVar.getTime())));
                        if (caVar.bMP.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.ay.b(caVar.bMP, com.baidu.tieba.n.cp_link_tip_c, 3);
                            caVar.bMP.setTag(sparseArray);
                            caVar.bMP.setOnClickListener(this.bLl);
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
                if (jVar.aoC() == 1) {
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
                String userId3 = this.bLf.aat().getAuthor().getUserId();
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
                if (jVar.aoC() == 1) {
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
            tbRichTextView.setMaxImageWidth(this.bMi - (i - this.bMh));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(ca caVar, com.baidu.tieba.tbadkCore.data.j jVar, AdditionData additionData, int i) {
        if (jVar.aoH() > 0 && jVar.aoB() != null) {
            caVar.bMM.setVisibility(0);
            caVar.bMM.removeViews(0, caVar.bMM.getChildCount() - 1);
            int size = jVar.aoB().size();
            int aoI = jVar.aoI();
            for (int i2 = 0; i2 < aoI; i2++) {
                com.baidu.tieba.tbadkCore.data.j jVar2 = jVar.aoB().get(i2);
                View a = com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.new_pb_list_item, caVar.bMM, false);
                ca caVar2 = new ca(a, this.bLi, this.bLh, this.mImageMaxWidth, true);
                a(caVar2);
                a(caVar2, jVar2, (View) caVar.bMM, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(com.baidu.tieba.q.tag_clip_board, jVar2);
                sparseArray.put(com.baidu.tieba.q.tag_is_subpb, true);
                if (TextUtils.isEmpty(jVar2.getBimg_url()) || !this.bLh) {
                    sparseArray.put(com.baidu.tieba.q.tag_richtext_bg, null);
                    caVar2.bMB.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) caVar2.bMB.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    caVar2.bMB.setLayoutParams(layoutParams);
                    caVar2.bMB.setPadding(0, 0, 0, 0);
                    caVar.bMB.fm(null);
                } else {
                    caVar.bMB.fm(jVar.getBimg_url());
                    caVar2.bMB.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) caVar2.bMB.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.ds36);
                    caVar2.bMB.setLayoutParams(layoutParams2);
                }
                caVar.bMM.addView(a, caVar.bMM.getChildCount() - 1);
            }
            if (aoI < size) {
                caVar.bMQ.setVisibility(0);
                com.baidu.tbadk.core.util.ay.i(caVar.bMS, com.baidu.tieba.n.cp_bg_line_b);
                com.baidu.tbadk.core.util.ay.i(caVar.bMT, com.baidu.tieba.n.cp_bg_line_b);
                com.baidu.tbadk.core.util.ay.b(caVar.bMR, com.baidu.tieba.n.cp_cont_f, 1);
                caVar.bMQ.setOnClickListener(new bz(this, aoI, size, jVar));
                return;
            }
            caVar.bMQ.setVisibility(8);
            return;
        }
        caVar.bMM.setVisibility(8);
    }

    private void a(ca caVar) {
        caVar.aBn.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOK);
        caVar.bMA.setOnClickListener(this.aPn);
        caVar.bMu.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOK);
        caVar.bMH.setOnLongClickListener(this.afC);
        caVar.bMB.setOnLongClickListener(this.afC);
        caVar.bMH.setOnTouchListener(this.bKH);
        caVar.bMB.setOnTouchListener(this.bKH);
        caVar.bMB.setOnImageClickListener(this.auJ);
        caVar.bMD.setOnImageClickListener(this.auJ);
        caVar.bMB.setOnEmotionClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bON);
        caVar.aQL.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOL);
        caVar.aKy.setOnClickListener(((PbActivity) this.bLa.getPageContext().getOrignalPage()).bKB.bOM);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        this.bLf = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.mImageMaxWidth = i;
    }

    public void setIsShowImage(boolean z) {
        this.bLh = z;
    }

    public void dT(boolean z) {
        this.bLi = z;
    }

    public void dU(boolean z) {
        this.bLj = z;
    }

    public void ir(String str) {
        this.bLk = str;
    }

    public void t(View.OnClickListener onClickListener) {
        this.bLl = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.aPn = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.auJ = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bKH = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afC = onLongClickListener;
    }
}
