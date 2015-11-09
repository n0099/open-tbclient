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
public class ch extends bz<com.baidu.tieba.tbadkCore.data.o, cl> implements View.OnClickListener {
    private TbRichTextView.d aBf;
    private ArrayList<IconData> aSY;
    private View.OnClickListener aZI;
    private View.OnLongClickListener ajZ;
    private boolean chO;
    private com.baidu.tieba.pb.a.c chP;
    private String chV;
    private com.baidu.tieba.pb.pb.sub.ak chW;
    private ArrayList<IconData> chX;
    private View.OnClickListener chY;
    private int cho;
    private boolean chp;
    private boolean chq;
    private com.baidu.tieba.pb.b.c chs;
    private boolean chu;
    private final boolean chv;
    private int chw;
    private int chx;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
    /* renamed from: M */
    public cl a(ViewGroup viewGroup) {
        return new cl(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, viewGroup, false), this.chO, this.chp, this.cho, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bz, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, cl clVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) clVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(clVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aA(i);
        com.baidu.tbadk.core.util.an.j(clVar.cii, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.j(clVar.cij, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.b(clVar.ciz, i.c.subpb_listitem_time, 1);
        com.baidu.tbadk.core.util.an.b(clVar.ciB, i.c.cp_link_tip_c, 3);
        com.baidu.tbadk.core.util.an.b(clVar.aGS, i.c.cp_cont_f, 1);
        com.baidu.tbadk.core.util.an.b((View) clVar.cin, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.an.b((View) clVar.cio, i.c.cp_cont_i, 1);
        com.baidu.tbadk.core.util.an.b(clVar.ciq, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.an.b(clVar.bqp, i.c.cp_cont_d, 1);
        com.baidu.tbadk.core.util.an.c(clVar.cis, i.e.btn_pb_reply_selector);
        com.baidu.tbadk.core.util.an.j(clVar.chD, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.j(clVar.chE, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.an.j(clVar.chF, i.c.cp_bg_line_e);
        com.baidu.tbadk.core.util.an.c(clVar.chF, i.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.an.c(clVar.civ, i.c.cp_bg_line_b);
        if (oVar2 != null) {
            a(clVar, oVar2, view, false, i);
        }
        if (!this.chu && this.chv && clVar != null && clVar.chB.Fi() && (listView = ((PbActivity) this.cjZ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.chu = true;
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
    private void a(cl clVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (clVar != null && oVar != null) {
            if (!z) {
                clVar.cim.setTag(null);
                clVar.cim.setUserId(null);
                clVar.aGS.setText((CharSequence) null);
                clVar.cio.setVisibility(8);
                clVar.ciw.setVisibility(0);
                clVar.cis.setVisibility(0);
                clVar.cir.setVisibility(8);
                if (oVar.axv() == null) {
                    clVar.cix.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && oVar.axv().zV() == 1) {
                    clVar.cix.changeSkinType(this.mSkinType);
                    clVar.cix.setVisibility(0);
                    clVar.cix.setData(oVar.axv());
                } else {
                    clVar.cix.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) clVar.cit.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    clVar.cit.setTag(sparseArray2);
                    clVar.chB.setTag(sparseArray2);
                }
                sparseArray2.put(i.f.tag_clip_board, oVar);
                sparseArray2.put(i.f.tag_is_subpb, false);
                a(clVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
                if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.chp) {
                    sparseArray2.put(i.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) clVar.chB.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    clVar.chB.setLayoutParams(layoutParams);
                    clVar.chB.setPadding(0, 0, 0, 0);
                    clVar.chB.fU(null);
                } else {
                    sparseArray2.put(i.f.tag_richtext_bg, oVar.getBimg_url());
                    clVar.chB.fU(oVar.getBimg_url());
                    if (oVar.axt() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) clVar.chB.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds40);
                        clVar.chB.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) clVar.chB.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds20);
                        clVar.chB.setLayoutParams(layoutParams3);
                    }
                }
                clVar.bqp.setText(com.baidu.tbadk.core.util.as.m(oVar.getTime()));
                if (oVar.axt() == 1) {
                    com.baidu.tbadk.core.util.an.j(clVar.cih, i.c.cp_bg_line_d);
                    clVar.cii.setVisibility(8);
                    clVar.cij.setVisibility(8);
                    clVar.cik.setVisibility(8);
                    clVar.cit.setVisibility(8);
                    clVar.bqp.setVisibility(8);
                    if (this.chq) {
                        PraiseData praise = this.chP.afh().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            clVar.chE.setVisibility(0);
                            clVar.chD.setVisibility(0);
                            clVar.chF.setVisibility(0);
                            clVar.chE.setIsFromPb(true);
                            clVar.chE.a(praise, this.chP.afh().getId(), praise.getPostId(), true);
                            clVar.chE.cP(this.mSkinType);
                        } else {
                            clVar.chE.setVisibility(8);
                            clVar.chD.setVisibility(8);
                            clVar.chF.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d axw = oVar.axw();
                        clVar.ciJ.setVisibility(8);
                        if (axw != null && !TextUtils.isEmpty(axw.getName()) && !TextUtils.isEmpty(axw.getName().trim())) {
                            String name = axw.getName();
                            String lat = axw.getLat();
                            String lng = axw.getLng();
                            clVar.ciG.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, clVar.ciG, 0, 10, 0, 10);
                            clVar.ciI.setText(axw.getName());
                            com.baidu.tbadk.core.util.an.b(clVar.ciI, i.c.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.an.c(clVar.ciH, i.e.icon_frs_site);
                            clVar.ciG.setOnClickListener(new ci(this, lat, lng, name));
                        } else {
                            clVar.ciG.setVisibility(8);
                        }
                    } else {
                        clVar.chE.setVisibility(8);
                        clVar.chD.setVisibility(8);
                        clVar.chF.setVisibility(8);
                        clVar.ciG.setVisibility(8);
                        clVar.ciJ.setVisibility(8);
                    }
                    a(clVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
                    ((LinearLayout.LayoutParams) clVar.cix.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                } else {
                    com.baidu.tbadk.core.util.an.j(clVar.cih, i.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.chq) {
                            clVar.cii.setVisibility(8);
                            clVar.cij.setVisibility(8);
                            PraiseData praise2 = this.chP.afh().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                clVar.cij.setVisibility(8);
                                clVar.cii.setVisibility(0);
                            } else {
                                clVar.cij.setVisibility(0);
                                clVar.cii.setVisibility(8);
                            }
                        } else {
                            clVar.cii.setVisibility(0);
                            clVar.cij.setVisibility(8);
                        }
                    } else {
                        clVar.cii.setVisibility(0);
                        clVar.cij.setVisibility(8);
                    }
                    clVar.cik.setVisibility(0);
                    com.baidu.tbadk.data.d axw2 = oVar.axw();
                    clVar.ciG.setVisibility(8);
                    if (axw2 != null && !TextUtils.isEmpty(axw2.getName()) && !TextUtils.isEmpty(axw2.getName().trim())) {
                        String name2 = axw2.getName();
                        String lat2 = axw2.getLat();
                        String lng2 = axw2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) clVar.ciJ.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.chO) {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds74);
                            } else {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(i.d.ds104);
                            }
                            clVar.ciJ.setLayoutParams(layoutParams4);
                        }
                        clVar.ciJ.setVisibility(0);
                        clVar.ciL.setText(axw2.getName());
                        com.baidu.tbadk.core.util.an.b(clVar.ciL, i.c.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.an.c(clVar.ciK, i.e.icon_frs_site);
                        clVar.ciJ.setOnClickListener(new cj(this, lat2, lng2, name2));
                    } else {
                        clVar.ciJ.setVisibility(8);
                    }
                    clVar.chE.setVisibility(8);
                    clVar.chD.setVisibility(8);
                    clVar.chF.setVisibility(8);
                    clVar.cit.setVisibility(0);
                    clVar.bqp.setVisibility(0);
                    String format = String.format(this.mContext.getString(i.h.is_floor), Integer.valueOf(oVar.axt()));
                    clVar.ciq.setVisibility(0);
                    clVar.ciq.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) clVar.cix.getLayoutParams();
                    if (!this.chO) {
                        a(clVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds74));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds74);
                    } else {
                        a(clVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds104));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) clVar.ciu.getLayoutParams();
                    if (!this.chO) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(i.d.ds30);
                    }
                }
                if (this.chV != null && !this.chV.equals("0") && this.chV.equals(oVar.getAuthor().getUserId())) {
                    clVar.cir.setVisibility(0);
                    com.baidu.tbadk.core.util.an.c(clVar.cir, i.e.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.an.i(clVar.cil, i.e.bg_floor_new_middle);
            clVar.chB.setVideoImageId(i.e.pic_video);
            clVar.chB.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.pb_listitem_content));
            com.baidu.tbadk.core.util.an.c(clVar.cis, i.e.btn_pb_reply_selector);
            clVar.chB.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) clVar.cis.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                clVar.cis.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(i.f.tag_clip_board, oVar);
            sparseArray.put(i.f.tag_load_sub_data, oVar);
            sparseArray.put(i.f.tag_load_sub_view, view);
            if (oVar.axx() > 0) {
                if (this.chW == null) {
                    this.chW = new com.baidu.tieba.pb.pb.sub.ak(this.mContext);
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
                clVar.ciw.setVisibility(0);
                clVar.civ.setVisibility(0);
                clVar.ciu.setVisibility(0);
                clVar.ciw.a(oVar, view);
                clVar.ciw.setChildOnClickListener(this.aZI);
                clVar.ciw.setChildOnLongClickListener(this.ajZ);
                clVar.ciw.setChildOnTouchListener(this.chs);
                clVar.ciw.setSubPbAdapter(this.chW);
                clVar.ciw.setVisibility(0);
            } else {
                clVar.ciw.setVisibility(8);
                clVar.civ.setVisibility(8);
                clVar.ciu.setVisibility(8);
            }
            a(clVar, oVar, this.chP.afo(), i);
            if (!z) {
                String portrait = oVar.getAuthor().getPortrait();
                if (oVar.getAuthor() != null) {
                    String name_show = oVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.n.fQ(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                    }
                    clVar.aGS.setText(name_show);
                    ArrayList<IconData> tShowInfo = oVar.getAuthor().getTShowInfo();
                    if (tShowInfo != null && tShowInfo.size() > 0) {
                        com.baidu.tbadk.core.util.an.b(clVar.aGS, i.c.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.an.b(clVar.aGS, i.c.cp_cont_f, 1);
                    }
                    int level_id = oVar.getAuthor().getLevel_id();
                    int is_bawu = oVar.getAuthor().getIs_bawu();
                    String bawu_type = oVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        clVar.cin.setVisibility(0);
                        com.baidu.tbadk.core.util.an.c(clVar.cin, com.baidu.tbadk.core.util.c.ch(level_id));
                        clVar.cin.setOnClickListener(null);
                    } else {
                        clVar.cin.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.an.c(clVar.cio, i.e.pb_manager);
                            clVar.cin.setVisibility(8);
                            clVar.cio.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.an.c(clVar.cio, i.e.pb_assist);
                            clVar.cin.setVisibility(8);
                            clVar.cio.setVisibility(0);
                        }
                    }
                    if (oVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.an.c(clVar.cip, i.e.icon_pb_pop_girl);
                        clVar.cip.setVisibility(0);
                    } else if (oVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.an.c(clVar.cip, i.e.icon_pb_pop_boy);
                        clVar.cip.setVisibility(0);
                    } else {
                        clVar.cip.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.n.fQ(oVar.getAuthor().getName_show()) >= 14 && clVar.cin.getVisibility() == 0 && clVar.cir.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.chX = oVar.getAuthor().getIconInfo();
                    this.aSY = oVar.getAuthor().getTShowInfo();
                    if (clVar.bds != null) {
                        clVar.bds.setTag(i.f.tag_user_id, oVar.getAuthor().getUserId());
                        clVar.bds.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.aXx);
                        clVar.bds.a(this.chX, i2, this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                    }
                    if (clVar.aTq != null) {
                        clVar.aTq.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnd);
                        clVar.aTq.a(this.aSY, 3, this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                    }
                }
                clVar.cim.setUserId(oVar.getAuthor().getUserId());
                clVar.cim.setUserName(oVar.getAuthor().getUserName());
                clVar.cim.setImageDrawable(null);
                clVar.aGS.setTag(i.f.tag_user_id, oVar.getAuthor().getUserId());
                clVar.aGS.setTag(i.f.tag_user_name, oVar.getAuthor().getUserName());
                clVar.cim.d(portrait, 28, false);
            }
            clVar.chB.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_c));
            if (this.chp) {
                clVar.chB.setDefaultImageId(i.e.img_default_100);
            } else {
                clVar.chB.setDefaultImageId(i.e.icon_click);
            }
            clVar.chB.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = oVar.axu();
            }
            if (this.chu || !this.chv) {
                clVar.chB.a(aVar, false);
            } else {
                clVar.chB.a(aVar, true);
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
                        if (clVar.ciB != null) {
                            clVar.ciB.setVisibility(0);
                            clVar.ciB.setText(i.h.manage);
                            clVar.ciB.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (clVar.ciB != null) {
                            clVar.ciB.setVisibility(0);
                            clVar.ciB.setText(i.h.delete);
                            clVar.ciB.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (clVar.ciB != null) {
                        clVar.ciB.setVisibility(8);
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
                        clVar.cis.setVisibility(8);
                        com.baidu.tbadk.core.util.an.b(clVar.ciz, i.c.subpb_listitem_time, 1);
                        clVar.ciz.setText(String.format(this.mContext.getResources().getString(i.h.write_addition_update), com.baidu.tbadk.core.util.as.m(oVar.getTime())));
                        if (clVar.ciB.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.an.b(clVar.ciB, i.c.cp_link_tip_c, 3);
                            sparseArray.put(i.f.tag_display_reply_visible, false);
                            clVar.ciB.setTag(sparseArray);
                            clVar.ciB.setOnClickListener(this.chY);
                        }
                    }
                    a(clVar, oVar, oVar.axt() != 1, aVar);
                    a(clVar);
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
            a(clVar, oVar, oVar.axt() != 1, aVar);
            a(clVar);
        }
    }

    private void a(cl clVar) {
        clVar.chB.setTextViewOnTouchListener(this.chs);
        clVar.chB.setTextViewCheckSelection(false);
    }

    private void a(cl clVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (oVar == null || oVar.aiq() == null) {
            clVar.ciM.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(oVar.aiq(), clVar.ciM, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(oVar.getBimg_url()));
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

    private void a(cl clVar, com.baidu.tieba.tbadkCore.data.o oVar, AdditionData additionData, int i) {
        if (oVar.axy() > 0 && oVar.axs() != null) {
            clVar.ciy.setVisibility(0);
            clVar.ciy.removeViews(0, clVar.ciy.getChildCount() - 1);
            int size = oVar.axs().size();
            int axz = oVar.axz();
            for (int i2 = 0; i2 < axz; i2++) {
                com.baidu.tieba.tbadkCore.data.o oVar2 = oVar.axs().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item, (ViewGroup) clVar.ciy, false);
                cl clVar2 = new cl(inflate, this.chO, this.chp, this.cho, true);
                b(clVar2);
                a(clVar2, oVar2, (View) clVar.ciy, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(i.f.tag_clip_board, oVar2);
                sparseArray.put(i.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(oVar2.getBimg_url()) || !this.chp) {
                    sparseArray.put(i.f.tag_richtext_bg, null);
                    clVar2.chB.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) clVar2.chB.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    clVar2.chB.setLayoutParams(layoutParams);
                    clVar2.chB.setPadding(0, 0, 0, 0);
                    clVar.chB.fU(null);
                } else {
                    clVar.chB.fU(oVar.getBimg_url());
                    clVar2.chB.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) clVar2.chB.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(i.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(i.d.ds36);
                    clVar2.chB.setLayoutParams(layoutParams2);
                }
                clVar.ciy.addView(inflate, clVar.ciy.getChildCount() - 1);
            }
            if (axz < size) {
                clVar.ciC.setVisibility(0);
                com.baidu.tbadk.core.util.an.i(clVar.ciE, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.an.i(clVar.ciF, i.c.cp_bg_line_b);
                com.baidu.tbadk.core.util.an.b(clVar.ciD, i.c.cp_cont_f, 1);
                clVar.ciC.setOnClickListener(new ck(this, axz, size, oVar));
                return;
            }
            clVar.ciC.setVisibility(8);
            return;
        }
        clVar.ciy.setVisibility(8);
    }

    private void b(cl clVar) {
        clVar.aGS.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnc);
        clVar.cis.setOnClickListener(this.aZI);
        clVar.cim.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnc);
        clVar.cit.setOnLongClickListener(this.ajZ);
        clVar.chB.setOnLongClickListener(this.ajZ);
        clVar.cit.setOnTouchListener(this.chs);
        clVar.chB.setOnTouchListener(this.chs);
        clVar.chB.setOnImageClickListener(this.aBf);
        clVar.chB.setOnEmotionClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cne);
        clVar.bds.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.aXx);
        clVar.aTq.setOnClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cnd);
        clVar.ciM.setOnClickListener(this.aZI);
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
