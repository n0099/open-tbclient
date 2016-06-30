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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cr;
import com.baidu.tieba.pb.pb.sub.au;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends cr<com.baidu.tieba.tbadkCore.data.s, ad> implements View.OnClickListener {
    private TbRichTextView.d aFF;
    private View.OnClickListener aZG;
    private View.OnLongClickListener aku;
    private ArrayList<IconData> bBy;
    private boolean ctv;
    private com.baidu.tieba.pb.data.h dMC;
    private com.baidu.tieba.pb.a.d dME;
    private int dNb;
    private boolean dNc;
    private boolean dNd;
    private String dNe;
    private au dNf;
    private ArrayList<IconData> dNg;
    private View.OnClickListener dNh;
    private boolean dNi;
    private final boolean dNj;
    private int dNk;
    private int dNl;
    private com.baidu.tieba.vote.b dNm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dNb = 0;
        this.ctv = true;
        this.dNc = true;
        this.dNd = true;
        this.dMC = null;
        this.dNe = null;
        this.dNf = null;
        this.dNg = null;
        this.bBy = null;
        this.dNh = null;
        this.aZG = null;
        this.aFF = null;
        this.dME = null;
        this.aku = null;
        this.dNi = false;
        this.dNj = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(ad adVar) {
        if (adVar != null) {
            if (adVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                av.l(adVar.dNr, u.d.cp_bg_line_b);
                av.l(adVar.dNs, u.d.cp_bg_line_b);
                av.c(adVar.dNP, u.d.common_color_10005, 1);
                av.c(adVar.dNR, u.d.cp_link_tip_c, 3);
                av.c(adVar.aOX, u.d.cp_cont_f, 1);
                av.c(adVar.dNw, u.d.cp_cont_i, 1);
                av.c(adVar.dNx, u.d.cp_cont_i, 1);
                av.c(adVar.dNz, u.d.cp_cont_d, 1);
                av.c(adVar.dNA, u.d.cp_cont_d, 1);
                av.c(adVar.dNC, u.f.btn_pb_reply_selector);
                av.l(adVar.dNE, u.d.cp_bg_line_e);
                av.l(adVar.dNF, u.d.cp_bg_line_e);
                av.c(adVar.dNF, u.d.cp_bg_line_b);
                av.c(adVar.dNJ, u.d.cp_bg_line_b);
            }
            adVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.dNk = getDimensionPixelSize(u.e.ds30);
        this.dNl = com.baidu.adp.lib.util.k.A(this.mContext) - getDimensionPixelSize(u.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public ad a(ViewGroup viewGroup) {
        ad adVar = new ad(LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, viewGroup, false), this.dNc, this.ctv, this.dNb, false);
        a(adVar);
        return adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cr, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, ad adVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) adVar);
        a(adVar);
        c(adVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) at(i);
        if (sVar2 != null) {
            a(adVar, sVar2, view, false, i);
        }
        if (!this.dNi && this.dNj && adVar != null && adVar.dND.Hq() && (listView = ((PbActivity) this.dOg.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dNi = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a35  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a65  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0a71  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0a7d  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0a89  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (adVar != null && sVar != null) {
            if (!z) {
                adVar.dNv.setTag(null);
                adVar.dNv.setUserId(null);
                adVar.aOX.setText((CharSequence) null);
                adVar.dNx.setVisibility(8);
                adVar.dNK.setVisibility(0);
                adVar.dNC.setVisibility(0);
                adVar.dNB.setVisibility(8);
                if (sVar.bco() == null || b(sVar)) {
                    adVar.dNL.setVisibility(8);
                } else if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && sVar.bco().AA() == 1) {
                    adVar.dNL.changeSkinType(this.mSkinType);
                    adVar.dNL.setVisibility(0);
                    adVar.dNL.setData(sVar.bco());
                } else {
                    adVar.dNL.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) adVar.dNH.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    adVar.dNH.setTag(sparseArray2);
                    adVar.dND.setTag(sparseArray2);
                }
                sparseArray2.put(u.g.tag_clip_board, sVar);
                sparseArray2.put(u.g.tag_is_subpb, false);
                a(adVar.dND, getDimensionPixelSize(u.e.ds30));
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ctv || b(sVar)) {
                    sparseArray2.put(u.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adVar.dND.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    adVar.dND.setLayoutParams(layoutParams);
                    adVar.dND.setPadding(0, 0, 0, 0);
                    adVar.dND.gC(null);
                } else {
                    sparseArray2.put(u.g.tag_richtext_bg, sVar.getBimg_url());
                    adVar.dND.gC(sVar.getBimg_url());
                    if (sVar.bcm() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) adVar.dND.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(u.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(u.e.ds40);
                        adVar.dND.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) adVar.dND.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(u.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(u.e.ds20);
                        adVar.dND.setLayoutParams(layoutParams3);
                    }
                }
                adVar.dNA.setText(ba.y(sVar.getTime()));
                adVar.dNG.setVisibility(8);
                if (sVar.bcm() == 1) {
                    av.l(adVar.dNq, u.d.cp_bg_line_d);
                    adVar.dNr.setVisibility(8);
                    adVar.dNs.setVisibility(8);
                    adVar.dNt.setVisibility(8);
                    adVar.dNH.setVisibility(8);
                    adVar.dNA.setVisibility(8);
                    adVar.dNG.setVisibility(0);
                    adVar.dNM.setVisibility(8);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    adVar.dNG.a(sVar.bcv(), str, j, com.baidu.adp.lib.h.b.c(this.dMC.aDO().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    adVar.dNG.se();
                    if (this.dNd) {
                        PraiseData praise = this.dMC.aDO().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            adVar.dNE.setVisibility(0);
                            adVar.dNF.setVisibility(0);
                            adVar.dNE.setIsFromPb(true);
                            adVar.dNE.a(praise, this.dMC.aDO().getId(), praise.getPostId(), true);
                            adVar.dNE.cX(this.mSkinType);
                        } else {
                            adVar.dNE.setVisibility(8);
                            adVar.dNF.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.an(adVar.dNE);
                        com.baidu.tieba.graffiti.d.an(adVar.dNF);
                        com.baidu.tbadk.data.g bcp = sVar.bcp();
                        adVar.dNZ.setVisibility(8);
                        if (bcp != null && !TextUtils.isEmpty(bcp.getName()) && !TextUtils.isEmpty(bcp.getName().trim())) {
                            String name = bcp.getName();
                            String lat = bcp.getLat();
                            String lng = bcp.getLng();
                            adVar.dNW.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, adVar.dNW, 0, 10, 0, 10);
                            adVar.dNY.setText(bcp.getName());
                            av.c(adVar.dNY, u.d.cp_link_tip_c, 1);
                            av.c(adVar.dNX, u.f.icon_pb_pin);
                            adVar.dNW.setOnClickListener(new aa(this, lat, lng, name));
                        } else {
                            adVar.dNW.setVisibility(8);
                        }
                    } else {
                        adVar.dNE.setVisibility(8);
                        adVar.dNF.setVisibility(8);
                        adVar.dNW.setVisibility(8);
                        adVar.dNZ.setVisibility(8);
                    }
                    a(adVar.dND, getDimensionPixelSize(u.e.ds30));
                    ((LinearLayout.LayoutParams) adVar.dNL.getLayoutParams()).leftMargin = getDimensionPixelSize(u.e.ds30);
                } else {
                    av.l(adVar.dNq, u.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.dNd) {
                            adVar.dNr.setVisibility(8);
                            adVar.dNs.setVisibility(8);
                            PraiseData praise2 = this.dMC.aDO().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                adVar.dNs.setVisibility(8);
                                adVar.dNr.setVisibility(0);
                            } else {
                                adVar.dNs.setVisibility(0);
                                adVar.dNr.setVisibility(8);
                            }
                        } else {
                            adVar.dNr.setVisibility(0);
                            adVar.dNs.setVisibility(8);
                        }
                    } else {
                        adVar.dNr.setVisibility(0);
                        adVar.dNs.setVisibility(8);
                    }
                    adVar.dNt.setVisibility(0);
                    com.baidu.tbadk.data.g bcp2 = sVar.bcp();
                    adVar.dNW.setVisibility(8);
                    if (bcp2 != null && !TextUtils.isEmpty(bcp2.getName()) && !TextUtils.isEmpty(bcp2.getName().trim())) {
                        String name2 = bcp2.getName();
                        String lat2 = bcp2.getLat();
                        String lng2 = bcp2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) adVar.dNZ.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.dNc) {
                                layoutParams4.leftMargin = getDimensionPixelSize(u.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(u.e.ds104);
                            }
                            adVar.dNZ.setLayoutParams(layoutParams4);
                        }
                        adVar.dNZ.setVisibility(0);
                        adVar.dOb.setText(bcp2.getName());
                        av.c(adVar.dOb, u.d.cp_link_tip_c, 1);
                        av.c(adVar.dOa, u.f.icon_pb_pin);
                        adVar.dNZ.setOnClickListener(new ab(this, lat2, lng2, name2));
                    } else {
                        adVar.dNZ.setVisibility(8);
                    }
                    adVar.dNE.setVisibility(8);
                    adVar.dNF.setVisibility(8);
                    adVar.dNH.setVisibility(0);
                    adVar.dNA.setVisibility(0);
                    String format = String.format(this.mContext.getString(u.j.is_floor), Integer.valueOf(sVar.bcm()));
                    adVar.dNz.setVisibility(0);
                    adVar.dNz.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) adVar.dNL.getLayoutParams();
                    if (!this.dNc) {
                        a(adVar.dND, getDimensionPixelSize(u.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(u.e.ds74);
                    } else {
                        a(adVar.dND, getDimensionPixelSize(u.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(u.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) adVar.dNI.getLayoutParams();
                    if (!this.dNc) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(u.e.ds30);
                    }
                }
                if (this.dNe != null && !this.dNe.equals("0") && this.dNe.equals(sVar.getAuthor().getUserId())) {
                    adVar.dNB.setVisibility(0);
                    av.c(adVar.dNB, u.f.icon_floorhost);
                }
            }
            av.k(adVar.dNu, u.f.bg_floor_new_middle);
            adVar.dND.setVideoImageId(u.f.pic_video);
            adVar.dND.setTextColor(av.getColor(u.d.common_color_10039));
            av.c(adVar.dNC, u.f.btn_pb_reply_selector);
            adVar.dND.setLinkTextColor(av.getColor(u.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) adVar.dNC.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                adVar.dNC.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(u.g.tag_clip_board, sVar);
            sparseArray.put(u.g.tag_load_sub_data, sVar);
            sparseArray.put(u.g.tag_load_sub_view, view);
            sparseArray.put(u.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(u.g.tag_pb_floor_number, Integer.valueOf(sVar.bcm()));
            if (sVar.bcq() > 0) {
                if (this.dNf == null) {
                    this.dNf = new au(this.mContext);
                    this.dNf.setIsFromCDN(this.mIsFromCDN);
                    this.dNf.J(this.dNh);
                    boolean z7 = false;
                    String userId2 = this.dMC.aDO().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.dNf.J(this.dMC.aDU(), z7);
                    this.dNf.p(this.dMC.aDO());
                    this.dNf.hh(this.dNc);
                }
                adVar.dNK.setVisibility(0);
                adVar.dNJ.setVisibility(0);
                adVar.dNI.setVisibility(0);
                adVar.dNK.a(sVar, view);
                adVar.dNK.setChildOnClickListener(this.aZG);
                adVar.dNK.setChildOnLongClickListener(this.aku);
                adVar.dNK.setChildOnTouchListener(this.dME);
                adVar.dNK.setSubPbAdapter(this.dNf);
                adVar.dNK.setVisibility(0);
            } else {
                adVar.dNK.setVisibility(8);
                adVar.dNJ.setVisibility(8);
                adVar.dNI.setVisibility(8);
            }
            a(adVar, sVar, this.dMC.aDX(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.u.gx(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                    }
                    adVar.aOX.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        av.c(adVar.aOX, u.d.cp_cont_h, 1);
                    } else {
                        av.c(adVar.aOX, u.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        adVar.dNw.setVisibility(0);
                        av.c(adVar.dNw, BitmapHelper.getGradeResourceIdNew(level_id));
                        adVar.dNw.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                        adVar.dNw.setOnClickListener(null);
                    } else {
                        adVar.dNw.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            av.c(adVar.dNx, u.f.pb_manager);
                            adVar.dNw.setVisibility(8);
                            adVar.dNx.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            av.c(adVar.dNx, u.f.pb_assist);
                            adVar.dNw.setVisibility(8);
                            adVar.dNx.setVisibility(0);
                        }
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        av.c(adVar.dNy, u.f.icon_pb_pop_girl);
                        adVar.dNy.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        av.c(adVar.dNy, u.f.icon_pb_pop_boy);
                        adVar.dNy.setVisibility(0);
                    } else {
                        adVar.dNy.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.u.gx(sVar.getAuthor().getName_show()) >= 14 && adVar.dNw.getVisibility() == 0 && adVar.dNB.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.dNg = sVar.getAuthor().getIconInfo();
                    this.bBy = sVar.getAuthor().getTShowInfoNew();
                    if (adVar.bTj != null) {
                        adVar.bTj.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                        adVar.bTj.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.bHY);
                        adVar.bTj.a(this.dNg, i2, getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds10));
                    }
                    if (adVar.aef != null) {
                        adVar.aef.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.dWh);
                        adVar.aef.a(this.bBy, 3, getDimensionPixelSize(u.e.ds36), getDimensionPixelSize(u.e.ds32), getDimensionPixelSize(u.e.ds8), true);
                    }
                }
                adVar.dNv.setUserId(sVar.getAuthor().getUserId());
                adVar.dNv.setUserName(sVar.getAuthor().getUserName());
                adVar.dNv.setImageDrawable(null);
                adVar.aOX.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                adVar.aOX.setTag(u.g.tag_user_name, sVar.getAuthor().getUserName());
                adVar.dNv.c(portrait, 28, false);
            }
            adVar.dND.setLinkTextColor(av.getColor(u.d.cp_link_tip_c));
            if (this.ctv) {
                adVar.dND.setDefaultImageId(u.f.transparent_bg);
            } else {
                adVar.dND.setDefaultImageId(u.f.icon_click);
            }
            adVar.dND.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.auL();
            }
            if (this.dNi || !this.dNj) {
                adVar.dND.a(aVar, false);
            } else {
                adVar.dND.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.dMC.aDU() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = sVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.dMC != null && this.dMC.aDO() != null && this.dMC.aDO().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.dMC.aDO().getAuthor().getUserId();
                String userId5 = sVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = sVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (adVar.dNR != null) {
                            adVar.dNR.setVisibility(0);
                            adVar.dNR.setText(u.j.manage);
                            adVar.dNR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (adVar.dNR != null) {
                            adVar.dNR.setVisibility(0);
                            adVar.dNR.setText(u.j.delete);
                            adVar.dNR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (adVar.dNR != null) {
                        adVar.dNR.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.bcm() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(u.g.tag_should_manage_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dMC.aDU()));
                        sparseArray.put(u.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(u.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(u.g.tag_user_mute_visible, true);
                        sparseArray.put(u.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sVar.getAuthor() != null) {
                            sparseArray.put(u.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                            sparseArray.put(u.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                        }
                        if (this.dMC.aDO() != null) {
                            sparseArray.put(u.g.tag_user_mute_thread_id, this.dMC.aDO().getId());
                        }
                        sparseArray.put(u.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(u.g.tag_should_delete_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dMC.aDU()));
                        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(u.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        adVar.dNC.setVisibility(8);
                        av.c(adVar.dNP, u.d.common_color_10005, 1);
                        adVar.dNP.setText(String.format(this.mContext.getResources().getString(u.j.write_addition_update), ba.y(sVar.getTime())));
                        if (adVar.dNR.getVisibility() == 0) {
                            av.c(adVar.dNR, u.d.cp_link_tip_c, 3);
                            sparseArray.put(u.g.tag_user_mute_visible, false);
                            adVar.dNR.setTag(sparseArray);
                            adVar.dNR.setOnClickListener(this.dNh);
                        }
                    }
                    a(adVar, sVar, sVar.bcm() != 1, aVar);
                    b(adVar);
                    if (z) {
                        a(view, sVar);
                        if (this.dNm != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.dNm.bjp();
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
            userId = sVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (sVar.bcm() == 1) {
            }
            sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(adVar, sVar, sVar.bcm() != 1, aVar);
            b(adVar);
            if (z) {
            }
        }
    }

    private void b(ad adVar) {
        adVar.dND.setTextViewOnTouchListener(this.dME);
        adVar.dND.setTextViewCheckSelection(false);
    }

    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aIV() == null || b(sVar)) {
            adVar.dOc.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(sVar.aIV(), adVar.dOc, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dNl - (i - this.dNk));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.bcr() > 0 && sVar.bcl() != null) {
            adVar.dNO.setVisibility(0);
            adVar.dNO.removeViews(0, adVar.dNO.getChildCount() - 1);
            int size = sVar.bcl().size();
            int bcs = sVar.bcs();
            for (int i2 = 0; i2 < bcs; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.bcl().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, (ViewGroup) adVar.dNO, false);
                ad adVar2 = new ad(inflate, this.dNc, this.ctv, this.dNb, true);
                c(adVar2);
                a(adVar2, sVar2, (View) adVar.dNO, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(u.g.tag_clip_board, sVar2);
                sparseArray.put(u.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.ctv) {
                    sparseArray.put(u.g.tag_richtext_bg, null);
                    adVar2.dND.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adVar2.dND.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    adVar2.dND.setLayoutParams(layoutParams);
                    adVar2.dND.setPadding(0, 0, 0, 0);
                    adVar.dND.gC(null);
                } else {
                    adVar.dND.gC(sVar.getBimg_url());
                    adVar2.dND.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) adVar2.dND.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(u.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(u.e.ds36);
                    adVar2.dND.setLayoutParams(layoutParams2);
                }
                adVar.dNO.addView(inflate, adVar.dNO.getChildCount() - 1);
            }
            if (bcs < size) {
                adVar.dNS.setVisibility(0);
                av.k(adVar.dNU, u.d.cp_bg_line_b);
                av.k(adVar.dNV, u.d.cp_bg_line_b);
                av.c(adVar.dNT, u.d.cp_cont_f, 1);
                adVar.dNS.setOnClickListener(new ac(this, bcs, size, sVar));
                return;
            }
            adVar.dNS.setVisibility(8);
            return;
        }
        adVar.dNO.setVisibility(8);
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (this.dMC == null || this.dMC.aDO() == null || !this.dMC.aDO().ri() || this.dMC.aDO().qF() == null || sVar.bcm() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (b(sVar) && view != null && this.dOg != null) {
            if (this.dNm == null) {
                this.dNm = new com.baidu.tieba.vote.b(this.dOg);
            }
            this.dNm.a(view, this.dMC);
        } else if (this.dNm != null) {
            this.dNm.setVisibility(8);
        }
    }

    private void c(ad adVar) {
        adVar.aOX.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.dWg);
        adVar.dNC.setOnClickListener(this.aZG);
        adVar.dNv.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.dWg);
        adVar.dNH.setOnLongClickListener(this.aku);
        adVar.dND.setOnLongClickListener(this.aku);
        adVar.dNH.setOnTouchListener(this.dME);
        adVar.dND.setOnTouchListener(this.dME);
        adVar.dND.setOnImageClickListener(this.aFF);
        adVar.dND.setOnEmotionClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.dWi);
        adVar.bTj.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.bHY);
        adVar.aef.setOnClickListener(((PbActivity) this.dOg.getPageContext().getOrignalPage()).dOP.dWh);
        adVar.dOc.setOnClickListener(this.aZG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.dMC = hVar;
    }

    public void nf(int i) {
        this.dNb = i;
    }

    public void hg(boolean z) {
        this.ctv = z;
    }

    public void hh(boolean z) {
        this.dNc = z;
    }

    public void hi(boolean z) {
        this.dNd = z;
    }

    public void nq(String str) {
        this.dNe = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dNh = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZG = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFF = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dME = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aku = onLongClickListener;
    }
}
