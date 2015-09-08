package com.baidu.tieba.pb.pb.main;

import android.graphics.Point;
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
import java.util.HashMap;
/* loaded from: classes.dex */
public class br extends bj<com.baidu.tieba.tbadkCore.data.i, bv> implements View.OnClickListener {
    private static HashMap<Point, Integer> cdC = new HashMap<>();
    private TbRichTextView.c aDG;
    private ArrayList<IconData> aTJ;
    private View.OnClickListener aZv;
    private View.OnLongClickListener alb;
    private com.baidu.tieba.pb.b.c cbW;
    private boolean ccA;
    private boolean ccB;
    private int ccC;
    private String ccD;
    private View.OnClickListener ccE;
    private com.baidu.tieba.pb.pb.sub.ai ccF;
    private com.baidu.tieba.pb.a.b ccx;
    private boolean ccz;
    private ArrayList<IconData> cdB;
    private boolean cdD;
    private final boolean cdE;
    private int cdF;
    private int cdG;
    private int width;

    static {
        cdC.put(new Point(1, 1), Integer.valueOf(i.h.i_want_lottery));
        cdC.put(new Point(1, 2), Integer.valueOf(i.h.look_result));
        cdC.put(new Point(1, 4), Integer.valueOf(i.h.i_want_lottery));
        cdC.put(new Point(2, 1), Integer.valueOf(i.h.i_want_share_picture));
        cdC.put(new Point(2, 2), Integer.valueOf(i.h.look_result));
        cdC.put(new Point(2, 4), Integer.valueOf(i.h.i_want_share_picture));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.width = -1;
        this.ccC = 0;
        this.ccz = true;
        this.ccA = true;
        this.ccB = true;
        this.ccx = null;
        this.ccD = null;
        this.ccF = null;
        this.cdB = null;
        this.aTJ = null;
        this.ccE = null;
        this.aZv = null;
        this.aDG = null;
        this.cbW = null;
        this.alb = null;
        this.cdD = false;
        this.cdE = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cdF = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.cdG = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public bv a(ViewGroup viewGroup) {
        return new bv(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.ccA, this.ccz, this.ccC, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.i iVar, bv bvVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.tbadkCore.data.i) bvVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(bvVar);
        com.baidu.tieba.tbadkCore.data.i iVar2 = (com.baidu.tieba.tbadkCore.data.i) aA(i);
        com.baidu.tbadk.core.util.al.i(bvVar.cdO, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.i(bvVar.cdP, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.b(bvVar.cel, i.c.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.cen, i.c.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.al.b(bvVar.aIV, i.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.cdT, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.cdV, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.cdW, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.al.c(bvVar.cdY, i.e.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.al.i(bvVar.cec, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.i(bvVar.ced, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(bvVar.cee, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.c(bvVar.cee, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.c(bvVar.ceh, i.c.cp_bg_line_b);
        int sB = this.ccx.acQ().sB();
        if (sB == 1 || sB == 4) {
            com.baidu.tbadk.core.util.al.b(bvVar.cea, i.c.cp_cont_i, 1);
            com.baidu.tbadk.core.util.al.h((View) bvVar.cea, i.e.buy_yinji_btn_bg);
        } else if (sB == 2) {
            com.baidu.tbadk.core.util.al.b(bvVar.cea, i.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.h((View) bvVar.cea, i.e.btn_pb_bottom_comment_selector);
        }
        if (iVar2 != null) {
            a(bvVar, iVar2, view, false, i);
        }
        if (!this.cdD && this.cdE && bvVar != null && bvVar.cdZ.FB() && (listView = ((PbActivity) this.ccs.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cdD = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0a88  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0ab8  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0ac4  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0ad0  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0adc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(bv bvVar, com.baidu.tieba.tbadkCore.data.i iVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (bvVar != null && iVar != null) {
            if (!z) {
                bvVar.cdS.setTag(null);
                bvVar.cdS.setUserId(null);
                bvVar.aIV.setText((CharSequence) null);
                bvVar.cei.setVisibility(0);
                bvVar.cdY.setVisibility(0);
                bvVar.cdX.setVisibility(8);
                if (iVar.aul() == null) {
                    bvVar.cej.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && iVar.aul().Ae() == 1) {
                    bvVar.cej.changeSkinType(this.mSkinType);
                    bvVar.cej.setVisibility(0);
                    bvVar.cej.setData(iVar.aul());
                } else {
                    bvVar.cej.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) bvVar.cef.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bvVar.cef.setTag(sparseArray2);
                    bvVar.cdZ.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, iVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(bvVar.cdZ, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(iVar.getBimg_url()) || !this.ccz) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bvVar.cdZ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bvVar.cdZ.setLayoutParams(layoutParams);
                    bvVar.cdZ.setPadding(0, 0, 0, 0);
                    bvVar.cdZ.fO(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, iVar.getBimg_url());
                    bvVar.cdZ.fO(iVar.getBimg_url());
                    if (iVar.auj() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bvVar.cdZ.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        bvVar.cdZ.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bvVar.cdZ.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        bvVar.cdZ.setLayoutParams(layoutParams3);
                    }
                }
                bvVar.cdW.setText(com.baidu.tbadk.core.util.aq.m(iVar.getTime()));
                if (iVar.auj() == 1) {
                    com.baidu.tbadk.core.util.al.i(bvVar.cdN, i.c.cp_bg_line_d);
                    bvVar.cdO.setVisibility(8);
                    bvVar.cdP.setVisibility(8);
                    bvVar.cdQ.setVisibility(8);
                    bvVar.cef.setVisibility(8);
                    bvVar.cdW.setVisibility(8);
                    if (this.ccB) {
                        PraiseData praise = this.ccx.acQ().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            bvVar.ced.setVisibility(0);
                            bvVar.cec.setVisibility(0);
                            bvVar.cee.setVisibility(0);
                            bvVar.ced.setIsFromPb(true);
                            bvVar.ced.a(praise, this.ccx.acQ().getId(), praise.getPostId(), true);
                            bvVar.ced.cO(this.mSkinType);
                        } else {
                            bvVar.ced.setVisibility(8);
                            bvVar.cec.setVisibility(8);
                            bvVar.cee.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aum = iVar.aum();
                        bvVar.cev.setVisibility(8);
                        if (aum != null && !TextUtils.isEmpty(aum.getName()) && !TextUtils.isEmpty(aum.getName().trim())) {
                            String name = aum.getName();
                            String lat = aum.getLat();
                            String lng = aum.getLng();
                            bvVar.ces.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, bvVar.ces, 0, 10, 0, 10);
                            bvVar.ceu.setText(aum.getName());
                            com.baidu.tbadk.core.util.al.b(bvVar.ceu, i.c.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.al.c(bvVar.cet, i.e.icon_frs_site);
                            bvVar.ces.setOnClickListener(new bs(this, lat, lng, name));
                        } else {
                            bvVar.ces.setVisibility(8);
                        }
                    } else {
                        bvVar.ced.setVisibility(8);
                        bvVar.cec.setVisibility(8);
                        bvVar.cee.setVisibility(8);
                        bvVar.ces.setVisibility(8);
                        bvVar.cev.setVisibility(8);
                    }
                    a(bvVar.cdZ, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) bvVar.cej.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    com.baidu.tbadk.core.util.al.i(bvVar.cdN, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.ccB) {
                            bvVar.cdO.setVisibility(8);
                            bvVar.cdP.setVisibility(8);
                            PraiseData praise2 = this.ccx.acQ().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                bvVar.cdP.setVisibility(8);
                                bvVar.cdO.setVisibility(0);
                            } else {
                                bvVar.cdP.setVisibility(0);
                                bvVar.cdO.setVisibility(8);
                            }
                        } else {
                            bvVar.cdO.setVisibility(0);
                            bvVar.cdP.setVisibility(8);
                        }
                    } else {
                        bvVar.cdO.setVisibility(0);
                        bvVar.cdP.setVisibility(8);
                    }
                    bvVar.cdQ.setVisibility(0);
                    com.baidu.tbadk.data.d aum2 = iVar.aum();
                    bvVar.ces.setVisibility(8);
                    if (aum2 != null && !TextUtils.isEmpty(aum2.getName()) && !TextUtils.isEmpty(aum2.getName().trim())) {
                        String name2 = aum2.getName();
                        String lat2 = aum2.getLat();
                        String lng2 = aum2.getLng();
                        bvVar.cev.setVisibility(0);
                        bvVar.cex.setText(aum2.getName());
                        com.baidu.tbadk.core.util.al.b(bvVar.cex, i.c.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.al.c(bvVar.cew, i.e.icon_frs_site);
                        bvVar.cev.setOnClickListener(new bt(this, lat2, lng2, name2));
                    } else {
                        bvVar.cev.setVisibility(8);
                    }
                    bvVar.ced.setVisibility(8);
                    bvVar.cec.setVisibility(8);
                    bvVar.cee.setVisibility(8);
                    bvVar.cef.setVisibility(0);
                    bvVar.cdW.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(iVar.auj()));
                    bvVar.cdV.setVisibility(0);
                    bvVar.cdV.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) bvVar.cej.getLayoutParams();
                    if (!this.ccA) {
                        a(bvVar.cdZ, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(bvVar.cdZ, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) bvVar.ceg.getLayoutParams();
                    if (!this.ccA) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.ccD != null && !this.ccD.equals("0") && this.ccD.equals(iVar.getAuthor().getUserId())) {
                    bvVar.cdX.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(bvVar.cdX, i.e.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.al.h(bvVar.cdR, i.e.bg_floor_new_middle);
            bvVar.cdZ.setVideoImageId(i.e.pic_video);
            bvVar.cdZ.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.pb_listitem_content));
            com.baidu.tbadk.core.util.al.c(bvVar.cdY, i.e.btn_pb_reply_selector);
            bvVar.cdZ.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) bvVar.cdY.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bvVar.cdY.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, iVar);
            sparseArray.put(i.f.tag_load_sub_data, iVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (iVar.aun() > 0) {
                if (this.ccF == null) {
                    this.ccF = new com.baidu.tieba.pb.pb.sub.ai(this.mContext);
                    this.ccF.setIsFromCDN(this.mIsFromCDN);
                    this.ccF.C(this.ccE);
                    boolean z7 = false;
                    String userId2 = this.ccx.acQ().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.ccF.o(this.ccx.acU(), z7);
                    this.ccF.e(this.ccx.acQ());
                    this.ccF.ep(this.ccA);
                }
                bvVar.cei.setVisibility(0);
                bvVar.ceh.setVisibility(0);
                bvVar.ceg.setVisibility(0);
                bvVar.cei.a(iVar, view);
                bvVar.cei.setChildOnClickListener(this.aZv);
                bvVar.cei.setChildOnLongClickListener(this.alb);
                bvVar.cei.setChildOnTouchListener(this.cbW);
                bvVar.cei.setSubPbAdapter(this.ccF);
                bvVar.cei.setVisibility(0);
            } else {
                bvVar.cei.setVisibility(8);
                bvVar.ceh.setVisibility(8);
                bvVar.ceg.setVisibility(8);
            }
            a(bvVar, iVar, this.ccx.acX(), i);
            if (!z) {
                String portrait = iVar.getAuthor().getPortrait();
                if (iVar.getAuthor() != null) {
                    bvVar.aIV.setText(iVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = iVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.al.b(bvVar.aIV, i.c.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.al.b(bvVar.aIV, i.c.cp_cont_f, 1);
                    }
                    int level_id = iVar.getAuthor().getLevel_id();
                    int is_bawu = iVar.getAuthor().getIs_bawu();
                    String bawu_type = iVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        bvVar.cdT.setVisibility(0);
                        com.baidu.tbadk.core.util.al.c(bvVar.cdT, com.baidu.tbadk.core.util.c.cf(level_id));
                        i2 = 2;
                        bvVar.cdT.setOnClickListener(null);
                    } else {
                        bvVar.cdT.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.al.c(bvVar.cdT, i.e.pb_manager);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.al.c(bvVar.cdT, i.e.pb_assist);
                        }
                    }
                    if (iVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.al.c(bvVar.cdU, i.e.icon_pop_girl_square);
                        bvVar.cdU.setVisibility(0);
                    } else {
                        bvVar.cdU.setVisibility(8);
                    }
                    this.cdB = iVar.getAuthor().getIconInfo();
                    this.aTJ = iVar.getAuthor().getTShowInfo();
                    if (bvVar.bcI != null) {
                        bvVar.bcI.setTag(i.f.tag_user_id, iVar.getAuthor().getUserId());
                        bvVar.bcI.setOnClickListener(((PbActivity) this.ccs.getPageContext().getOrignalPage()).cbM.aXJ);
                        bvVar.bcI.a(this.cdB, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (bvVar.aUb != null) {
                        bvVar.aUb.setOnClickListener(((PbActivity) this.ccs.getPageContext().getOrignalPage()).cbM.cgl);
                        bvVar.aUb.a(this.aTJ, 3, this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                    }
                }
                bvVar.cdS.setUserId(iVar.getAuthor().getUserId());
                bvVar.cdS.setUserName(iVar.getAuthor().getUserName());
                bvVar.cdS.setImageDrawable(null);
                bvVar.aIV.setTag(i.f.tag_user_id, iVar.getAuthor().getUserId());
                bvVar.aIV.setTag(i.f.tag_user_name, iVar.getAuthor().getUserName());
                bvVar.cdS.d(portrait, 28, false);
            }
            bvVar.cdZ.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_c));
            if (this.ccz) {
                bvVar.cdZ.setDefaultImageId(i.e.img_default_100);
            } else {
                bvVar.cdZ.setDefaultImageId(i.e.icon_click);
            }
            bvVar.cdZ.setIsFromCDN(this.mIsFromCDN);
            if (this.ccz) {
                bvVar.ceb.setDefaultImageId(i.e.img_default_100);
            } else {
                bvVar.ceb.setDefaultImageId(i.e.icon_click);
            }
            bvVar.ceb.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (iVar.auj() == 1 && this.ccx.acQ().sD()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a auk = iVar.auk();
                if (auk != null && auk.Fg() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> Fg = auk.Fg();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= Fg.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = Fg.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.f Fl = cVar.Fl();
                            Fl.setWidth(bvVar.ceb.getMaxImageWidth());
                            Fl.setHeight(bvVar.ceb.getMaxImageHeight());
                            Fl.bx(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                bvVar.cea.setVisibility(8);
                bvVar.ceb.setVisibility(8);
                if (arrayList.size() >= 1) {
                    bvVar.ceb.setVisibility(0);
                }
                int sB = this.ccx.acQ().sB();
                if (sB == 1 || sB == 2 || sB == 4) {
                    bvVar.cea.setVisibility(0);
                    bvVar.cea.setOnClickListener(this.aZv);
                    bvVar.cea.setEnabled(true);
                }
                Integer num = cdC.get(new Point(this.ccx.acQ().sC(), sB));
                if (num != null) {
                    bvVar.cea.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                bvVar.cea.setVisibility(8);
                bvVar.ceb.setVisibility(8);
            }
            if (aVar == null) {
                aVar = iVar.auk();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.cdD || !this.cdE) {
                bvVar.cdZ.a(aVar, false);
                bvVar.ceb.a(aVar3, false);
            } else {
                bvVar.cdZ.a(aVar, true);
                bvVar.ceb.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.ccx.acU() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = iVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.ccx != null && this.ccx.acQ() != null && this.ccx.acQ().getAuthor() != null && iVar.getAuthor() != null) {
                String userId4 = this.ccx.acQ().getAuthor().getUserId();
                String userId5 = iVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = iVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (bvVar.cen != null) {
                            bvVar.cen.setVisibility(0);
                            bvVar.cen.setText(i.h.manage);
                            bvVar.cen.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (bvVar.cen != null) {
                            bvVar.cen.setVisibility(0);
                            bvVar.cen.setText(i.h.delete);
                            bvVar.cen.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (bvVar.cen != null) {
                        bvVar.cen.setVisibility(8);
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (iVar.auj() == 1) {
                        i5 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
                    if (!z8) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.ccx.acU()));
                        sparseArray.put(i.f.tag_forbid_user_name, iVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (iVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, iVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, iVar.getAuthor().getUserName());
                        }
                        if (this.ccx.acQ() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.ccx.acQ().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, iVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.ccx.acU()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(i.f.tag_del_post_id, iVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        bvVar.cdY.setVisibility(8);
                        com.baidu.tbadk.core.util.al.b(bvVar.cel, i.c.subpb_listitem_time, 1);
                        bvVar.cel.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), com.baidu.tbadk.core.util.aq.m(iVar.getTime())));
                        if (bvVar.cen.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.al.b(bvVar.cen, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            bvVar.cen.setTag(sparseArray);
                            bvVar.cen.setOnClickListener(this.ccE);
                        }
                    }
                    a(bvVar, iVar, iVar.auj() != 1, aVar);
                    a(bvVar);
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = iVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i52 = 1;
            if (z) {
            }
            if (iVar.auj() == 1) {
            }
            sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(bvVar, iVar, iVar.auj() != 1, aVar);
            a(bvVar);
        }
    }

    private void a(bv bvVar) {
        bvVar.cdZ.setTextViewOnTouchListener(this.cbW);
        bvVar.cdZ.setTextViewCheckSelection(false);
    }

    private void a(bv bvVar, com.baidu.tieba.tbadkCore.data.i iVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (iVar == null || iVar.afQ() == null) {
            bvVar.cey.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(iVar.afQ(), bvVar.cey, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(iVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cdG - (i - this.cdF));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(bv bvVar, com.baidu.tieba.tbadkCore.data.i iVar, AdditionData additionData, int i) {
        if (iVar.auo() > 0 && iVar.aui() != null) {
            bvVar.cek.setVisibility(0);
            bvVar.cek.removeViews(0, bvVar.cek.getChildCount() - 1);
            int size = iVar.aui().size();
            int aup = iVar.aup();
            for (int i2 = 0; i2 < aup; i2++) {
                com.baidu.tieba.tbadkCore.data.i iVar2 = iVar.aui().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) bvVar.cek, false);
                bv bvVar2 = new bv(inflate, this.ccA, this.ccz, this.ccC, true);
                b(bvVar2);
                a(bvVar2, iVar2, (View) bvVar.cek, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, iVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(iVar2.getBimg_url()) || !this.ccz) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    bvVar2.cdZ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bvVar2.cdZ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bvVar2.cdZ.setLayoutParams(layoutParams);
                    bvVar2.cdZ.setPadding(0, 0, 0, 0);
                    bvVar.cdZ.fO(null);
                } else {
                    bvVar.cdZ.fO(iVar.getBimg_url());
                    bvVar2.cdZ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bvVar2.cdZ.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    bvVar2.cdZ.setLayoutParams(layoutParams2);
                }
                bvVar.cek.addView(inflate, bvVar.cek.getChildCount() - 1);
            }
            if (aup < size) {
                bvVar.ceo.setVisibility(0);
                com.baidu.tbadk.core.util.al.h(bvVar.ceq, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.h(bvVar.cer, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.b(bvVar.cep, i.c.cp_cont_f, 1);
                bvVar.ceo.setOnClickListener(new bu(this, aup, size, iVar));
                return;
            }
            bvVar.ceo.setVisibility(8);
            return;
        }
        bvVar.cek.setVisibility(8);
    }

    private void b(bv bvVar) {
        bvVar.aIV.setOnClickListener(((PbActivity) this.ccs.getPageContext().getOrignalPage()).cbM.cgk);
        bvVar.cdY.setOnClickListener(this.aZv);
        bvVar.cdS.setOnClickListener(((PbActivity) this.ccs.getPageContext().getOrignalPage()).cbM.cgk);
        bvVar.cef.setOnLongClickListener(this.alb);
        bvVar.cdZ.setOnLongClickListener(this.alb);
        bvVar.cef.setOnTouchListener(this.cbW);
        bvVar.cdZ.setOnTouchListener(this.cbW);
        bvVar.cdZ.setOnImageClickListener(this.aDG);
        bvVar.ceb.setOnImageClickListener(this.aDG);
        bvVar.cdZ.setOnEmotionClickListener(((PbActivity) this.ccs.getPageContext().getOrignalPage()).cbM.cgm);
        bvVar.bcI.setOnClickListener(((PbActivity) this.ccs.getPageContext().getOrignalPage()).cbM.aXJ);
        bvVar.aUb.setOnClickListener(((PbActivity) this.ccs.getPageContext().getOrignalPage()).cbM.cgl);
        bvVar.cey.setOnClickListener(this.aZv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        this.ccx = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.ccC = i;
    }

    public void eo(boolean z) {
        this.ccz = z;
    }

    public void ep(boolean z) {
        this.ccA = z;
    }

    public void eq(boolean z) {
        this.ccB = z;
    }

    public void ju(String str) {
        this.ccD = str;
    }

    public void A(View.OnClickListener onClickListener) {
        this.ccE = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZv = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aDG = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cbW = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alb = onLongClickListener;
    }
}
