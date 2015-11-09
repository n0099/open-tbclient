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
import com.baidu.tieba.pb.pb.main.bz;
import com.baidu.tieba.pb.pb.sub.ak;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends bz<com.baidu.tieba.tbadkCore.data.o, r> implements View.OnClickListener {
    private TbRichTextView.d aBf;
    private ArrayList<IconData> aSY;
    private View.OnClickListener aZI;
    private View.OnLongClickListener ajZ;
    private boolean chO;
    private com.baidu.tieba.pb.a.c chP;
    private String chV;
    private ak chW;
    private ArrayList<IconData> chX;
    private View.OnClickListener chY;
    private com.baidu.tieba.vote.b chZ;
    private int cho;
    private boolean chp;
    private boolean chq;
    private com.baidu.tieba.pb.b.c chs;
    private boolean chu;
    private final boolean chv;
    private int chw;
    private int chx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cho = 0;
        this.chp = true;
        this.chO = true;
        this.chq = true;
        this.chP = null;
        this.chV = null;
        this.chW = null;
        this.chX = null;
        this.aSY = null;
        this.chY = null;
        this.aZI = null;
        this.aBf = null;
        this.chs = null;
        this.ajZ = null;
        this.chu = false;
        this.chv = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.chw = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.chx = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public r a(ViewGroup viewGroup) {
        return new r(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.chO, this.chp, this.cho, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bz, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, r rVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) rVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(rVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aA(i);
        an.j(rVar.cii, i.c.cp_bg_line_b);
        an.j(rVar.cij, i.c.cp_bg_line_b);
        an.b(rVar.ciz, i.c.subpb_listitem_time, 1);
        an.b(rVar.ciB, i.c.cp_link_tip_c, 3);
        an.b(rVar.aGS, i.c.cp_cont_f, 1);
        an.b((View) rVar.cin, i.c.cp_cont_i, 1);
        an.b((View) rVar.cio, i.c.cp_cont_i, 1);
        an.b(rVar.ciq, i.c.cp_cont_d, 1);
        an.b(rVar.bqp, i.c.cp_cont_d, 1);
        an.c(rVar.cis, i.e.btn_pb_reply_selector);
        an.j(rVar.chD, i.c.cp_bg_line_b);
        an.j(rVar.chE, i.c.cp_bg_line_e);
        an.j(rVar.chF, i.c.cp_bg_line_e);
        an.c(rVar.chF, i.c.cp_bg_line_b);
        an.c(rVar.civ, i.c.cp_bg_line_b);
        if (oVar2 != null) {
            a(rVar, oVar2, view, false, i);
        }
        if (!this.chu && this.chv && rVar != null && rVar.chB.Fi() && (listView = ((PbActivity) this.cjZ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.chu = true;
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
    private void a(r rVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (rVar != null && oVar != null) {
            if (!z) {
                rVar.cim.setTag(null);
                rVar.cim.setUserId(null);
                rVar.aGS.setText((CharSequence) null);
                rVar.cio.setVisibility(8);
                rVar.ciw.setVisibility(0);
                rVar.cis.setVisibility(0);
                rVar.cir.setVisibility(8);
                if (oVar.axv() == null || b(oVar)) {
                    rVar.cix.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && oVar.axv().zV() == 1) {
                    rVar.cix.changeSkinType(this.mSkinType);
                    rVar.cix.setVisibility(0);
                    rVar.cix.setData(oVar.axv());
                } else {
                    rVar.cix.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) rVar.cit.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    rVar.cit.setTag(sparseArray2);
                    rVar.chB.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, oVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(rVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.chp || b(oVar)) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.chB.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    rVar.chB.setLayoutParams(layoutParams);
                    rVar.chB.setPadding(0, 0, 0, 0);
                    rVar.chB.fU(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, oVar.getBimg_url());
                    rVar.chB.fU(oVar.getBimg_url());
                    if (oVar.axt() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.chB.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        rVar.chB.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.chB.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        rVar.chB.setLayoutParams(layoutParams3);
                    }
                }
                rVar.bqp.setText(as.m(oVar.getTime()));
                if (oVar.axt() == 1) {
                    an.j(rVar.cih, i.c.cp_bg_line_d);
                    rVar.cii.setVisibility(8);
                    rVar.cij.setVisibility(8);
                    rVar.cik.setVisibility(8);
                    rVar.cit.setVisibility(8);
                    rVar.bqp.setVisibility(8);
                    if (this.chq) {
                        PraiseData praise = this.chP.afh().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            rVar.chE.setVisibility(0);
                            rVar.chD.setVisibility(0);
                            rVar.chF.setVisibility(0);
                            rVar.chE.setIsFromPb(true);
                            rVar.chE.a(praise, this.chP.afh().getId(), praise.getPostId(), true);
                            rVar.chE.cP(this.mSkinType);
                        } else {
                            rVar.chE.setVisibility(8);
                            rVar.chD.setVisibility(8);
                            rVar.chF.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d axw = oVar.axw();
                        rVar.ciJ.setVisibility(8);
                        if (axw != null && !TextUtils.isEmpty(axw.getName()) && !TextUtils.isEmpty(axw.getName().trim())) {
                            String name = axw.getName();
                            String lat = axw.getLat();
                            String lng = axw.getLng();
                            rVar.ciG.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, rVar.ciG, 0, 10, 0, 10);
                            rVar.ciI.setText(axw.getName());
                            an.b(rVar.ciI, i.c.cp_cont_c, 1);
                            an.c(rVar.ciH, i.e.icon_frs_site);
                            rVar.ciG.setOnClickListener(new o(this, lat, lng, name));
                        } else {
                            rVar.ciG.setVisibility(8);
                        }
                    } else {
                        rVar.chE.setVisibility(8);
                        rVar.chD.setVisibility(8);
                        rVar.chF.setVisibility(8);
                        rVar.ciG.setVisibility(8);
                        rVar.ciJ.setVisibility(8);
                    }
                    a(rVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) rVar.cix.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    an.j(rVar.cih, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.chq) {
                            rVar.cii.setVisibility(8);
                            rVar.cij.setVisibility(8);
                            PraiseData praise2 = this.chP.afh().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                rVar.cij.setVisibility(8);
                                rVar.cii.setVisibility(0);
                            } else {
                                rVar.cij.setVisibility(0);
                                rVar.cii.setVisibility(8);
                            }
                        } else {
                            rVar.cii.setVisibility(0);
                            rVar.cij.setVisibility(8);
                        }
                    } else {
                        rVar.cii.setVisibility(0);
                        rVar.cij.setVisibility(8);
                    }
                    rVar.cik.setVisibility(0);
                    com.baidu.tbadk.data.d axw2 = oVar.axw();
                    rVar.ciG.setVisibility(8);
                    if (axw2 != null && !TextUtils.isEmpty(axw2.getName()) && !TextUtils.isEmpty(axw2.getName().trim())) {
                        String name2 = axw2.getName();
                        String lat2 = axw2.getLat();
                        String lng2 = axw2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) rVar.ciJ.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.chO) {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds74);
                            } else {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds104);
                            }
                            rVar.ciJ.setLayoutParams(layoutParams4);
                        }
                        rVar.ciJ.setVisibility(0);
                        rVar.ciL.setText(axw2.getName());
                        an.b(rVar.ciL, i.c.cp_cont_c, 1);
                        an.c(rVar.ciK, i.e.icon_frs_site);
                        rVar.ciJ.setOnClickListener(new p(this, lat2, lng2, name2));
                    } else {
                        rVar.ciJ.setVisibility(8);
                    }
                    rVar.chE.setVisibility(8);
                    rVar.chD.setVisibility(8);
                    rVar.chF.setVisibility(8);
                    rVar.cit.setVisibility(0);
                    rVar.bqp.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(oVar.axt()));
                    rVar.ciq.setVisibility(0);
                    rVar.ciq.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) rVar.cix.getLayoutParams();
                    if (!this.chO) {
                        a(rVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(rVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) rVar.ciu.getLayoutParams();
                    if (!this.chO) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.chV != null && !this.chV.equals("0") && this.chV.equals(oVar.getAuthor().getUserId())) {
                    rVar.cir.setVisibility(0);
                    an.c(rVar.cir, i.e.icon_floorhost);
                }
            }
            an.i(rVar.cil, i.e.bg_floor_new_middle);
            rVar.chB.setVideoImageId(i.e.pic_video);
            rVar.chB.setTextColor(an.getColor(i.c.pb_listitem_content));
            an.c(rVar.cis, i.e.btn_pb_reply_selector);
            rVar.chB.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) rVar.cis.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                rVar.cis.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, oVar);
            sparseArray.put(i.f.tag_load_sub_data, oVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (oVar.axx() > 0) {
                if (this.chW == null) {
                    this.chW = new ak(this.mContext);
                    this.chW.setIsFromCDN(this.mIsFromCDN);
                    this.chW.D(this.chY);
                    boolean z7 = false;
                    String userId2 = this.chP.afh().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.chW.p(this.chP.afl(), z7);
                    this.chW.e(this.chP.afh());
                    this.chW.et(this.chO);
                }
                rVar.ciw.setVisibility(0);
                rVar.civ.setVisibility(0);
                rVar.ciu.setVisibility(0);
                rVar.ciw.a(oVar, view);
                rVar.ciw.setChildOnClickListener(this.aZI);
                rVar.ciw.setChildOnLongClickListener(this.ajZ);
                rVar.ciw.setChildOnTouchListener(this.chs);
                rVar.ciw.setSubPbAdapter(this.chW);
                rVar.ciw.setVisibility(0);
            } else {
                rVar.ciw.setVisibility(8);
                rVar.civ.setVisibility(8);
                rVar.ciu.setVisibility(8);
            }
            a(rVar, oVar, this.chP.afo(), i);
            if (!z) {
                String portrait = oVar.getAuthor().getPortrait();
                if (oVar.getAuthor() != null) {
                    String name_show = oVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.n.fQ(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                    }
                    rVar.aGS.setText(name_show);
                    ArrayList<IconData> tShowInfo = oVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        an.b(rVar.aGS, i.c.cp_cont_h, 1);
                    } else {
                        an.b(rVar.aGS, i.c.cp_cont_f, 1);
                    }
                    int level_id = oVar.getAuthor().getLevel_id();
                    int is_bawu = oVar.getAuthor().getIs_bawu();
                    String bawu_type = oVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        rVar.cin.setVisibility(0);
                        an.c(rVar.cin, com.baidu.tbadk.core.util.c.ch(level_id));
                        rVar.cin.setOnClickListener(null);
                    } else {
                        rVar.cin.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            an.c(rVar.cio, i.e.pb_manager);
                            rVar.cin.setVisibility(8);
                            rVar.cio.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            an.c(rVar.cio, i.e.pb_assist);
                            rVar.cin.setVisibility(8);
                            rVar.cio.setVisibility(0);
                        }
                    }
                    if (oVar.getAuthor().getGender() == 2) {
                        an.c(rVar.cip, i.e.icon_pb_pop_girl);
                        rVar.cip.setVisibility(0);
                    } else if (oVar.getAuthor().getGender() == 1) {
                        an.c(rVar.cip, i.e.icon_pb_pop_boy);
                        rVar.cip.setVisibility(0);
                    } else {
                        rVar.cip.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.n.fQ(oVar.getAuthor().getName_show()) >= 14 && rVar.cin.getVisibility() == 0 && rVar.cir.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.chX = oVar.getAuthor().getIconInfo();
                    this.aSY = oVar.getAuthor().getTShowInfo();
                    if (rVar.bds != null) {
                        rVar.bds.setTag(i.f.tag_user_id, oVar.getAuthor().getUserId());
                        rVar.bds.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.aXx);
                        rVar.bds.a(this.chX, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (rVar.aTq != null) {
                        rVar.aTq.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnd);
                        rVar.aTq.a(this.aSY, 3, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                    }
                }
                rVar.cim.setUserId(oVar.getAuthor().getUserId());
                rVar.cim.setUserName(oVar.getAuthor().getUserName());
                rVar.cim.setImageDrawable(null);
                rVar.aGS.setTag(i.f.tag_user_id, oVar.getAuthor().getUserId());
                rVar.aGS.setTag(i.f.tag_user_name, oVar.getAuthor().getUserName());
                rVar.cim.d(portrait, 28, false);
            }
            rVar.chB.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            if (this.chp) {
                rVar.chB.setDefaultImageId(i.e.img_default_100);
            } else {
                rVar.chB.setDefaultImageId(i.e.icon_click);
            }
            rVar.chB.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = oVar.axu();
            }
            if (this.chu || !this.chv) {
                rVar.chB.a(aVar, false);
            } else {
                rVar.chB.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.chP.afl() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = oVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.chP != null && this.chP.afh() != null && this.chP.afh().getAuthor() != null && oVar.getAuthor() != null) {
                String userId4 = this.chP.afh().getAuthor().getUserId();
                String userId5 = oVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = oVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (rVar.ciB != null) {
                            rVar.ciB.setVisibility(0);
                            rVar.ciB.setText(i.h.manage);
                            rVar.ciB.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (rVar.ciB != null) {
                            rVar.ciB.setVisibility(0);
                            rVar.ciB.setText(i.h.delete);
                            rVar.ciB.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (rVar.ciB != null) {
                        rVar.ciB.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (oVar.axt() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(i.f.tag_forbid_user_post_id, oVar.getId());
                    if (!z8) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.chP.afl()));
                        sparseArray.put(i.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (oVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, oVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, oVar.getAuthor().getUserName());
                        }
                        if (this.chP.afh() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.chP.afh().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, oVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(this.chP.afl()));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(i.f.tag_del_post_id, oVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        rVar.cis.setVisibility(8);
                        an.b(rVar.ciz, i.c.subpb_listitem_time, 1);
                        rVar.ciz.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), as.m(oVar.getTime())));
                        if (rVar.ciB.getVisibility() == 0) {
                            an.b(rVar.ciB, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            rVar.ciB.setTag(sparseArray);
                            rVar.ciB.setOnClickListener(this.chY);
                        }
                    }
                    a(rVar, oVar, oVar.axt() != 1, aVar);
                    a(rVar);
                    if (z) {
                        a(view, oVar);
                        if (this.chZ != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.chZ.aBw();
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
            userId = oVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (oVar.axt() == 1) {
            }
            sparseArray.put(i.f.tag_forbid_user_post_id, oVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(rVar, oVar, oVar.axt() != 1, aVar);
            a(rVar);
            if (z) {
            }
        }
    }

    private void a(r rVar) {
        rVar.chB.setTextViewOnTouchListener(this.chs);
        rVar.chB.setTextViewCheckSelection(false);
    }

    private void a(r rVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (oVar == null || oVar.aiq() == null || b(oVar)) {
            rVar.ciM.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(oVar.aiq(), rVar.ciM, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(oVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.chx - (i - this.chw));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(r rVar, com.baidu.tieba.tbadkCore.data.o oVar, AdditionData additionData, int i) {
        if (oVar.axy() > 0 && oVar.axs() != null) {
            rVar.ciy.setVisibility(0);
            rVar.ciy.removeViews(0, rVar.ciy.getChildCount() - 1);
            int size = oVar.axs().size();
            int axz = oVar.axz();
            for (int i2 = 0; i2 < axz; i2++) {
                com.baidu.tieba.tbadkCore.data.o oVar2 = oVar.axs().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) rVar.ciy, false);
                r rVar2 = new r(inflate, this.chO, this.chp, this.cho, true);
                b(rVar2);
                a(rVar2, oVar2, (View) rVar.ciy, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, oVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(oVar2.getBimg_url()) || !this.chp) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    rVar2.chB.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar2.chB.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    rVar2.chB.setLayoutParams(layoutParams);
                    rVar2.chB.setPadding(0, 0, 0, 0);
                    rVar.chB.fU(null);
                } else {
                    rVar.chB.fU(oVar.getBimg_url());
                    rVar2.chB.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar2.chB.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    rVar2.chB.setLayoutParams(layoutParams2);
                }
                rVar.ciy.addView(inflate, rVar.ciy.getChildCount() - 1);
            }
            if (axz < size) {
                rVar.ciC.setVisibility(0);
                an.i(rVar.ciE, i.c.cp_bg_line_b);
                an.i(rVar.ciF, i.c.cp_bg_line_b);
                an.b(rVar.ciD, i.c.cp_cont_f, 1);
                rVar.ciC.setOnClickListener(new q(this, axz, size, oVar));
                return;
            }
            rVar.ciC.setVisibility(8);
            return;
        }
        rVar.ciy.setVisibility(8);
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.o oVar) {
        return (this.chP == null || this.chP.afh() == null || !this.chP.afh().sB() || this.chP.afh().sg() == null || oVar.axt() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.o oVar) {
        if (b(oVar) && view != null && this.cjZ != null) {
            if (this.chZ == null) {
                this.chZ = new com.baidu.tieba.vote.b(this.cjZ);
            }
            this.chZ.a(view, this.chP);
        } else if (this.chZ != null) {
            this.chZ.setVisibility(8);
        }
    }

    private void b(r rVar) {
        rVar.aGS.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnc);
        rVar.cis.setOnClickListener(this.aZI);
        rVar.cim.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnc);
        rVar.cit.setOnLongClickListener(this.ajZ);
        rVar.chB.setOnLongClickListener(this.ajZ);
        rVar.cit.setOnTouchListener(this.chs);
        rVar.chB.setOnTouchListener(this.chs);
        rVar.chB.setOnImageClickListener(this.aBf);
        rVar.chB.setOnEmotionClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cne);
        rVar.bds.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.aXx);
        rVar.aTq.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnd);
        rVar.ciM.setOnClickListener(this.aZI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.chP = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cho = i;
    }

    public void er(boolean z) {
        this.chp = z;
    }

    public void et(boolean z) {
        this.chO = z;
    }

    public void es(boolean z) {
        this.chq = z;
    }

    public void jJ(String str) {
        this.chV = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.chY = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aBf = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.chs = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajZ = onLongClickListener;
    }
}
