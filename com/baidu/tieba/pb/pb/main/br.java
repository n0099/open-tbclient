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
    private static HashMap<Point, Integer> ccF = new HashMap<>();
    private TbRichTextView.c aBY;
    private ArrayList<IconData> aTv;
    private View.OnClickListener aZc;
    private View.OnLongClickListener akJ;
    private com.baidu.tieba.pb.a.b cbC;
    private boolean cbE;
    private boolean cbF;
    private boolean cbG;
    private int cbH;
    private String cbI;
    private View.OnClickListener cbJ;
    private com.baidu.tieba.pb.pb.sub.ai cbK;
    private com.baidu.tieba.pb.b.c cbb;
    private ArrayList<IconData> ccE;
    private boolean ccG;
    private final boolean ccH;
    private int ccI;
    private int ccJ;
    private int width;

    static {
        ccF.put(new Point(1, 1), Integer.valueOf(i.C0057i.i_want_lottery));
        ccF.put(new Point(1, 2), Integer.valueOf(i.C0057i.look_result));
        ccF.put(new Point(1, 4), Integer.valueOf(i.C0057i.i_want_lottery));
        ccF.put(new Point(2, 1), Integer.valueOf(i.C0057i.i_want_share_picture));
        ccF.put(new Point(2, 2), Integer.valueOf(i.C0057i.look_result));
        ccF.put(new Point(2, 4), Integer.valueOf(i.C0057i.i_want_share_picture));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.width = -1;
        this.cbH = 0;
        this.cbE = true;
        this.cbF = true;
        this.cbG = true;
        this.cbC = null;
        this.cbI = null;
        this.cbK = null;
        this.ccE = null;
        this.aTv = null;
        this.cbJ = null;
        this.aZc = null;
        this.aBY = null;
        this.cbb = null;
        this.akJ = null;
        this.ccG = false;
        this.ccH = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.ccI = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.ccJ = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public bv a(ViewGroup viewGroup) {
        return new bv(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.cbF, this.cbE, this.cbH, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.i iVar, bv bvVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.tbadkCore.data.i) bvVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(bvVar);
        com.baidu.tieba.tbadkCore.data.i iVar2 = (com.baidu.tieba.tbadkCore.data.i) aA(i);
        com.baidu.tbadk.core.util.al.j(bvVar.ccR, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.j(bvVar.ccS, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.b(bvVar.cdo, i.c.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.cdq, i.c.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.al.b(bvVar.aII, i.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.ccW, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.ccY, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.al.b(bvVar.ccZ, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.al.c(bvVar.cdb, i.e.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.al.j(bvVar.cdf, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.j(bvVar.cdg, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(bvVar.cdh, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.c(bvVar.cdh, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.al.c(bvVar.cdk, i.c.cp_bg_line_b);
        int sy = this.cbC.acH().sy();
        if (sy == 1 || sy == 4) {
            com.baidu.tbadk.core.util.al.b(bvVar.cdd, i.c.cp_cont_i, 1);
            com.baidu.tbadk.core.util.al.i((View) bvVar.cdd, i.e.buy_yinji_btn_bg);
        } else if (sy == 2) {
            com.baidu.tbadk.core.util.al.b(bvVar.cdd, i.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.i((View) bvVar.cdd, i.e.btn_pb_bottom_comment_selector);
        }
        if (iVar2 != null) {
            a(bvVar, iVar2, view, false, i);
        }
        if (!this.ccG && this.ccH && bvVar != null && bvVar.cdc.Fr() && (listView = ((PbActivity) this.cbx.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ccG = true;
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
                bvVar.ccV.setTag(null);
                bvVar.ccV.setUserId(null);
                bvVar.aII.setText((CharSequence) null);
                bvVar.cdl.setVisibility(0);
                bvVar.cdb.setVisibility(0);
                bvVar.cda.setVisibility(8);
                if (iVar.apX() == null) {
                    bvVar.cdm.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && iVar.apX().zR() == 1) {
                    bvVar.cdm.changeSkinType(this.mSkinType);
                    bvVar.cdm.setVisibility(0);
                    bvVar.cdm.setData(iVar.apX());
                } else {
                    bvVar.cdm.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) bvVar.cdi.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bvVar.cdi.setTag(sparseArray2);
                    bvVar.cdc.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, iVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(bvVar.cdc, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(iVar.getBimg_url()) || !this.cbE) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bvVar.cdc.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bvVar.cdc.setLayoutParams(layoutParams);
                    bvVar.cdc.setPadding(0, 0, 0, 0);
                    bvVar.cdc.fG(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, iVar.getBimg_url());
                    bvVar.cdc.fG(iVar.getBimg_url());
                    if (iVar.apV() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bvVar.cdc.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        bvVar.cdc.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bvVar.cdc.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        bvVar.cdc.setLayoutParams(layoutParams3);
                    }
                }
                bvVar.ccZ.setText(com.baidu.tbadk.core.util.aq.m(iVar.getTime()));
                if (iVar.apV() == 1) {
                    com.baidu.tbadk.core.util.al.j(bvVar.ccQ, i.c.cp_bg_line_d);
                    bvVar.ccR.setVisibility(8);
                    bvVar.ccS.setVisibility(8);
                    bvVar.ccT.setVisibility(8);
                    bvVar.cdi.setVisibility(8);
                    bvVar.ccZ.setVisibility(8);
                    if (this.cbG) {
                        PraiseData praise = this.cbC.acH().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            bvVar.cdg.setVisibility(0);
                            bvVar.cdf.setVisibility(0);
                            bvVar.cdh.setVisibility(0);
                            bvVar.cdg.setIsFromPb(true);
                            bvVar.cdg.a(praise, this.cbC.acH().getId(), praise.getPostId(), true);
                            bvVar.cdg.cI(this.mSkinType);
                        } else {
                            bvVar.cdg.setVisibility(8);
                            bvVar.cdf.setVisibility(8);
                            bvVar.cdh.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d apY = iVar.apY();
                        bvVar.cdy.setVisibility(8);
                        if (apY != null && !TextUtils.isEmpty(apY.getName()) && !TextUtils.isEmpty(apY.getName().trim())) {
                            String name = apY.getName();
                            String lat = apY.getLat();
                            String lng = apY.getLng();
                            bvVar.cdv.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, bvVar.cdv, 0, 10, 0, 10);
                            bvVar.cdx.setText(apY.getName());
                            com.baidu.tbadk.core.util.al.b(bvVar.cdx, i.c.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.al.c(bvVar.cdw, i.e.icon_frs_site);
                            bvVar.cdv.setOnClickListener(new bs(this, lat, lng, name));
                        } else {
                            bvVar.cdv.setVisibility(8);
                        }
                    } else {
                        bvVar.cdg.setVisibility(8);
                        bvVar.cdf.setVisibility(8);
                        bvVar.cdh.setVisibility(8);
                        bvVar.cdv.setVisibility(8);
                        bvVar.cdy.setVisibility(8);
                    }
                    a(bvVar.cdc, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) bvVar.cdm.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    com.baidu.tbadk.core.util.al.j(bvVar.ccQ, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cbG) {
                            bvVar.ccR.setVisibility(8);
                            bvVar.ccS.setVisibility(8);
                            PraiseData praise2 = this.cbC.acH().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                bvVar.ccS.setVisibility(8);
                                bvVar.ccR.setVisibility(0);
                            } else {
                                bvVar.ccS.setVisibility(0);
                                bvVar.ccR.setVisibility(8);
                            }
                        } else {
                            bvVar.ccR.setVisibility(0);
                            bvVar.ccS.setVisibility(8);
                        }
                    } else {
                        bvVar.ccR.setVisibility(0);
                        bvVar.ccS.setVisibility(8);
                    }
                    bvVar.ccT.setVisibility(0);
                    com.baidu.tbadk.data.d apY2 = iVar.apY();
                    bvVar.cdv.setVisibility(8);
                    if (apY2 != null && !TextUtils.isEmpty(apY2.getName()) && !TextUtils.isEmpty(apY2.getName().trim())) {
                        String name2 = apY2.getName();
                        String lat2 = apY2.getLat();
                        String lng2 = apY2.getLng();
                        bvVar.cdy.setVisibility(0);
                        bvVar.cdA.setText(apY2.getName());
                        com.baidu.tbadk.core.util.al.b(bvVar.cdA, i.c.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.al.c(bvVar.cdz, i.e.icon_frs_site);
                        bvVar.cdy.setOnClickListener(new bt(this, lat2, lng2, name2));
                    } else {
                        bvVar.cdy.setVisibility(8);
                    }
                    bvVar.cdg.setVisibility(8);
                    bvVar.cdf.setVisibility(8);
                    bvVar.cdh.setVisibility(8);
                    bvVar.cdi.setVisibility(0);
                    bvVar.ccZ.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.C0057i.is_floor), Integer.valueOf(iVar.apV()));
                    bvVar.ccY.setVisibility(0);
                    bvVar.ccY.setText(format);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) bvVar.cdm.getLayoutParams();
                    if (!this.cbF) {
                        a(bvVar.cdc, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(bvVar.cdc, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams4.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) bvVar.cdj.getLayoutParams();
                    if (!this.cbF) {
                        layoutParams5.leftMargin = 0;
                    } else {
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.cbI != null && !this.cbI.equals("0") && this.cbI.equals(iVar.getAuthor().getUserId())) {
                    bvVar.cda.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(bvVar.cda, i.e.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.al.i(bvVar.ccU, i.e.bg_floor_new_middle);
            bvVar.cdc.setVideoImageId(i.e.pic_video);
            bvVar.cdc.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.pb_listitem_content));
            com.baidu.tbadk.core.util.al.c(bvVar.cdb, i.e.btn_pb_reply_selector);
            bvVar.cdc.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) bvVar.cdb.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bvVar.cdb.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, iVar);
            sparseArray.put(i.f.tag_load_sub_data, iVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (iVar.apZ() > 0) {
                if (this.cbK == null) {
                    this.cbK = new com.baidu.tieba.pb.pb.sub.ai(this.mContext);
                    this.cbK.setIsFromCDN(this.mIsFromCDN);
                    this.cbK.D(this.cbJ);
                    boolean z7 = false;
                    String userId2 = this.cbC.acH().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cbK.n(this.cbC.acK(), z7);
                    this.cbK.d(this.cbC.acH());
                    this.cbK.ei(this.cbF);
                }
                bvVar.cdl.setVisibility(0);
                bvVar.cdk.setVisibility(0);
                bvVar.cdj.setVisibility(0);
                bvVar.cdl.a(iVar, view);
                bvVar.cdl.setChildOnClickListener(this.aZc);
                bvVar.cdl.setChildOnLongClickListener(this.akJ);
                bvVar.cdl.setChildOnTouchListener(this.cbb);
                bvVar.cdl.setSubPbAdapter(this.cbK);
                bvVar.cdl.setVisibility(0);
            } else {
                bvVar.cdl.setVisibility(8);
                bvVar.cdk.setVisibility(8);
                bvVar.cdj.setVisibility(8);
            }
            a(bvVar, iVar, this.cbC.acN(), i);
            if (!z) {
                String portrait = iVar.getAuthor().getPortrait();
                if (iVar.getAuthor() != null) {
                    bvVar.aII.setText(iVar.getAuthor().getName_show());
                    ArrayList<IconData> tShowInfo = iVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.al.b(bvVar.aII, i.c.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.al.b(bvVar.aII, i.c.cp_cont_f, 1);
                    }
                    int level_id = iVar.getAuthor().getLevel_id();
                    int is_bawu = iVar.getAuthor().getIs_bawu();
                    String bawu_type = iVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        bvVar.ccW.setVisibility(0);
                        com.baidu.tbadk.core.util.al.c(bvVar.ccW, com.baidu.tbadk.core.util.c.cb(level_id));
                        i2 = 2;
                        bvVar.ccW.setOnClickListener(null);
                    } else {
                        bvVar.ccW.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.al.c(bvVar.ccW, i.e.pb_manager);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.al.c(bvVar.ccW, i.e.pb_assist);
                        }
                    }
                    if (iVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.al.c(bvVar.ccX, i.e.icon_pop_girl_square);
                        bvVar.ccX.setVisibility(0);
                    } else {
                        bvVar.ccX.setVisibility(8);
                    }
                    this.ccE = iVar.getAuthor().getIconInfo();
                    this.aTv = iVar.getAuthor().getTShowInfo();
                    if (bvVar.bco != null) {
                        bvVar.bco.setTag(i.f.tag_user_id, iVar.getAuthor().getUserId());
                        bvVar.bco.setOnClickListener(((PbActivity) this.cbx.getPageContext().getOrignalPage()).caR.aXO);
                        bvVar.bco.a(this.ccE, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (bvVar.aTN != null) {
                        bvVar.aTN.setOnClickListener(((PbActivity) this.cbx.getPageContext().getOrignalPage()).caR.cfo);
                        bvVar.aTN.a(this.aTv, 3, this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                    }
                }
                bvVar.ccV.setUserId(iVar.getAuthor().getUserId());
                bvVar.ccV.setUserName(iVar.getAuthor().getUserName());
                bvVar.ccV.setImageDrawable(null);
                bvVar.aII.setTag(i.f.tag_user_id, iVar.getAuthor().getUserId());
                bvVar.aII.setTag(i.f.tag_user_name, iVar.getAuthor().getUserName());
                bvVar.ccV.d(portrait, 28, false);
            }
            bvVar.cdc.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_c));
            if (this.cbE) {
                bvVar.cdc.setDefaultImageId(i.e.img_default_100);
            } else {
                bvVar.cdc.setDefaultImageId(i.e.icon_click);
            }
            bvVar.cdc.setIsFromCDN(this.mIsFromCDN);
            if (this.cbE) {
                bvVar.cde.setDefaultImageId(i.e.img_default_100);
            } else {
                bvVar.cde.setDefaultImageId(i.e.icon_click);
            }
            bvVar.cde.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            ArrayList arrayList = new ArrayList();
            if (iVar.apV() == 1 && this.cbC.acH().sA()) {
                ArrayList arrayList2 = new ArrayList();
                com.baidu.tbadk.widget.richText.a apW = iVar.apW();
                if (apW != null && apW.EW() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> EW = apW.EW();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= EW.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = EW.get(i4);
                        int type = cVar.getType();
                        if (type == 1) {
                            arrayList2.add(cVar);
                        } else if (type == 8 && arrayList.size() <= 2) {
                            com.baidu.tbadk.widget.richText.f Fb = cVar.Fb();
                            Fb.setWidth(bvVar.cde.getMaxImageWidth());
                            Fb.setHeight(bvVar.cde.getMaxImageHeight());
                            Fb.bq(false);
                            arrayList.add(cVar);
                        }
                        i3 = i4 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList2);
                bvVar.cdd.setVisibility(8);
                bvVar.cde.setVisibility(8);
                if (arrayList.size() >= 1) {
                    bvVar.cde.setVisibility(0);
                }
                int sy = this.cbC.acH().sy();
                if (sy == 1 || sy == 2 || sy == 4) {
                    bvVar.cdd.setVisibility(0);
                    bvVar.cdd.setOnClickListener(this.aZc);
                    bvVar.cdd.setEnabled(true);
                }
                Integer num = ccF.get(new Point(this.cbC.acH().sz(), sy));
                if (num != null) {
                    bvVar.cdd.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                bvVar.cdd.setVisibility(8);
                bvVar.cde.setVisibility(8);
            }
            if (aVar == null) {
                aVar = iVar.apW();
            }
            com.baidu.tbadk.widget.richText.a aVar3 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
            if (this.ccG || !this.ccH) {
                bvVar.cdc.a(aVar, false);
                bvVar.cde.a(aVar3, false);
            } else {
                bvVar.cdc.a(aVar, true);
                bvVar.cde.a(aVar3, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cbC.acK() != 0) {
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
            if (this.cbC != null && this.cbC.acH() != null && this.cbC.acH().getAuthor() != null && iVar.getAuthor() != null) {
                String userId4 = this.cbC.acH().getAuthor().getUserId();
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
                        if (bvVar.cdq != null) {
                            bvVar.cdq.setVisibility(0);
                            bvVar.cdq.setText(i.C0057i.manage);
                            bvVar.cdq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (bvVar.cdq != null) {
                            bvVar.cdq.setVisibility(0);
                            bvVar.cdq.setText(i.C0057i.delete);
                            bvVar.cdq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (bvVar.cdq != null) {
                        bvVar.cdq.setVisibility(8);
                    }
                    int i5 = 1;
                    if (z) {
                        i5 = 2;
                    }
                    if (iVar.apV() == 1) {
                        i5 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
                    if (!z8) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cbC.acK()));
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
                        if (this.cbC.acH() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cbC.acH().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, iVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cbC.acK()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(i.f.tag_del_post_id, iVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        bvVar.cdb.setVisibility(8);
                        com.baidu.tbadk.core.util.al.b(bvVar.cdo, i.c.subpb_listitem_time, 1);
                        bvVar.cdo.setText(String.format(this.mContext.getResources().getString(i.C0057i.write_addition_update), com.baidu.tbadk.core.util.aq.m(iVar.getTime())));
                        if (bvVar.cdq.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.al.b(bvVar.cdq, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            bvVar.cdq.setTag(sparseArray);
                            bvVar.cdq.setOnClickListener(this.cbJ);
                        }
                    }
                    a(bvVar, iVar, iVar.apV() != 1, aVar);
                    a(bvVar, iVar);
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
            if (iVar.apV() == 1) {
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
            a(bvVar, iVar, iVar.apV() != 1, aVar);
            a(bvVar, iVar);
        }
    }

    private void a(bv bvVar, com.baidu.tieba.tbadkCore.data.i iVar) {
        bvVar.cdc.setTextViewOnTouchListener(this.cbb);
        bvVar.cdc.setTextViewCheckSelection(false);
    }

    private void a(bv bvVar, com.baidu.tieba.tbadkCore.data.i iVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (iVar == null || iVar.afz() == null) {
            bvVar.cdB.setVisibility(8);
        } else {
            new com.baidu.tieba.pb.view.d(bvVar.cdB, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(iVar.getBimg_url())).a(iVar.afz());
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ccJ - (i - this.ccI));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(bv bvVar, com.baidu.tieba.tbadkCore.data.i iVar, AdditionData additionData, int i) {
        if (iVar.aqa() > 0 && iVar.apU() != null) {
            bvVar.cdn.setVisibility(0);
            bvVar.cdn.removeViews(0, bvVar.cdn.getChildCount() - 1);
            int size = iVar.apU().size();
            int aqb = iVar.aqb();
            for (int i2 = 0; i2 < aqb; i2++) {
                com.baidu.tieba.tbadkCore.data.i iVar2 = iVar.apU().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) bvVar.cdn, false);
                bv bvVar2 = new bv(inflate, this.cbF, this.cbE, this.cbH, true);
                a(bvVar2);
                a(bvVar2, iVar2, (View) bvVar.cdn, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, iVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(iVar2.getBimg_url()) || !this.cbE) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    bvVar2.cdc.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bvVar2.cdc.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    bvVar2.cdc.setLayoutParams(layoutParams);
                    bvVar2.cdc.setPadding(0, 0, 0, 0);
                    bvVar.cdc.fG(null);
                } else {
                    bvVar.cdc.fG(iVar.getBimg_url());
                    bvVar2.cdc.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bvVar2.cdc.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    bvVar2.cdc.setLayoutParams(layoutParams2);
                }
                bvVar.cdn.addView(inflate, bvVar.cdn.getChildCount() - 1);
            }
            if (aqb < size) {
                bvVar.cdr.setVisibility(0);
                com.baidu.tbadk.core.util.al.i(bvVar.cdt, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.i(bvVar.cdu, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.b(bvVar.cds, i.c.cp_cont_f, 1);
                bvVar.cdr.setOnClickListener(new bu(this, aqb, size, iVar));
                return;
            }
            bvVar.cdr.setVisibility(8);
            return;
        }
        bvVar.cdn.setVisibility(8);
    }

    private void a(bv bvVar) {
        bvVar.aII.setOnClickListener(((PbActivity) this.cbx.getPageContext().getOrignalPage()).caR.cfn);
        bvVar.cdb.setOnClickListener(this.aZc);
        bvVar.ccV.setOnClickListener(((PbActivity) this.cbx.getPageContext().getOrignalPage()).caR.cfn);
        bvVar.cdi.setOnLongClickListener(this.akJ);
        bvVar.cdc.setOnLongClickListener(this.akJ);
        bvVar.cdi.setOnTouchListener(this.cbb);
        bvVar.cdc.setOnTouchListener(this.cbb);
        bvVar.cdc.setOnImageClickListener(this.aBY);
        bvVar.cde.setOnImageClickListener(this.aBY);
        bvVar.cdc.setOnEmotionClickListener(((PbActivity) this.cbx.getPageContext().getOrignalPage()).caR.cfp);
        bvVar.bco.setOnClickListener(((PbActivity) this.cbx.getPageContext().getOrignalPage()).caR.aXO);
        bvVar.aTN.setOnClickListener(((PbActivity) this.cbx.getPageContext().getOrignalPage()).caR.cfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        this.cbC = bVar;
    }

    public void setImageMaxWidth(int i) {
        this.cbH = i;
    }

    public void eh(boolean z) {
        this.cbE = z;
    }

    public void ei(boolean z) {
        this.cbF = z;
    }

    public void ej(boolean z) {
        this.cbG = z;
    }

    public void jm(String str) {
        this.cbI = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cbJ = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.aZc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aBY = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cbb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akJ = onLongClickListener;
    }
}
