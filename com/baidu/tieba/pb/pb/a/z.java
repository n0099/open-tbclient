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
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.pb.pb.sub.au;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends cs<com.baidu.tieba.tbadkCore.data.s, ad> implements View.OnClickListener {
    private TbRichTextView.d aGw;
    private View.OnLongClickListener alj;
    private View.OnClickListener baF;
    private ArrayList<IconData> cQe;
    private boolean cwk;
    private com.baidu.tieba.pb.data.h dYM;
    private com.baidu.tieba.pb.a.d dYQ;
    private int dZo;
    private boolean dZp;
    private boolean dZq;
    private String dZr;
    private au dZs;
    private ArrayList<IconData> dZt;
    private View.OnClickListener dZu;
    private boolean dZv;
    private final boolean dZw;
    private int dZx;
    private int dZy;
    private com.baidu.tieba.vote.b dZz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dZo = 0;
        this.cwk = true;
        this.dZp = true;
        this.dZq = true;
        this.dYM = null;
        this.dZr = null;
        this.dZs = null;
        this.dZt = null;
        this.cQe = null;
        this.dZu = null;
        this.baF = null;
        this.aGw = null;
        this.dYQ = null;
        this.alj = null;
        this.dZv = false;
        this.dZw = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(ad adVar) {
        if (adVar != null) {
            if (adVar.mSkinType != TbadkCoreApplication.m10getInst().getSkinType()) {
                av.l(adVar.dZE, u.d.cp_bg_line_b);
                av.l(adVar.dZF, u.d.cp_bg_line_b);
                av.c(adVar.eac, u.d.common_color_10005, 1);
                av.c(adVar.eae, u.d.cp_link_tip_c, 3);
                av.c(adVar.aPR, u.d.cp_cont_f, 1);
                av.c((View) adVar.dZJ, u.d.cp_cont_i, 1);
                av.c((View) adVar.dZK, u.d.cp_cont_i, 1);
                av.c(adVar.dZM, u.d.cp_cont_d, 1);
                av.c(adVar.dZN, u.d.cp_cont_d, 1);
                av.c(adVar.dZP, u.f.btn_pb_reply_selector);
                av.l(adVar.dZR, u.d.cp_bg_line_e);
                av.l(adVar.dZS, u.d.cp_bg_line_e);
                av.c(adVar.dZS, u.d.cp_bg_line_b);
                av.c(adVar.dZW, u.d.cp_bg_line_b);
            }
            adVar.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        }
    }

    private void init() {
        this.dZx = getDimensionPixelSize(u.e.ds30);
        this.dZy = com.baidu.adp.lib.util.k.A(this.mContext) - getDimensionPixelSize(u.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public ad a(ViewGroup viewGroup) {
        ad adVar = new ad(LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, viewGroup, false), this.dZp, this.cwk, this.dZo, false);
        a(adVar);
        return adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, ad adVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) adVar);
        a(adVar);
        c(adVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) aw(i);
        if (sVar2 != null) {
            a(adVar, sVar2, view, false, i);
        }
        if (!this.dZv && this.dZw && adVar != null && adVar.dZQ.Ho() && (listView = ((PbActivity) this.eat.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dZv = true;
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
                adVar.dZI.setTag(null);
                adVar.dZI.setUserId(null);
                adVar.aPR.setText((CharSequence) null);
                adVar.dZK.setVisibility(8);
                adVar.dZX.setVisibility(0);
                adVar.dZP.setVisibility(0);
                adVar.dZO.setVisibility(8);
                if (sVar.bfD() == null || c(sVar)) {
                    adVar.dZY.setVisibility(8);
                } else if (TbadkCoreApplication.m10getInst().isBaobaoShouldOpen() && sVar.bfD().AA() == 1) {
                    adVar.dZY.changeSkinType(this.mSkinType);
                    adVar.dZY.setVisibility(0);
                    adVar.dZY.setData(sVar.bfD());
                } else {
                    adVar.dZY.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) adVar.dZU.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    adVar.dZU.setTag(sparseArray2);
                    adVar.dZQ.setTag(sparseArray2);
                }
                sparseArray2.put(u.g.tag_clip_board, sVar);
                sparseArray2.put(u.g.tag_is_subpb, false);
                a(adVar.dZQ, getDimensionPixelSize(u.e.ds30));
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.cwk || c(sVar)) {
                    sparseArray2.put(u.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adVar.dZQ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    adVar.dZQ.setLayoutParams(layoutParams);
                    adVar.dZQ.setPadding(0, 0, 0, 0);
                    adVar.dZQ.gB(null);
                } else {
                    sparseArray2.put(u.g.tag_richtext_bg, sVar.getBimg_url());
                    adVar.dZQ.gB(sVar.getBimg_url());
                    if (sVar.bfB() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) adVar.dZQ.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(u.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(u.e.ds40);
                        adVar.dZQ.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) adVar.dZQ.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(u.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(u.e.ds20);
                        adVar.dZQ.setLayoutParams(layoutParams3);
                    }
                }
                adVar.dZN.setText(ba.t(sVar.getTime()));
                adVar.dZT.setVisibility(8);
                if (sVar.bfB() == 1) {
                    av.l(adVar.dZD, u.d.cp_bg_line_d);
                    adVar.dZE.setVisibility(8);
                    adVar.dZF.setVisibility(8);
                    adVar.dZG.setVisibility(8);
                    adVar.dZU.setVisibility(8);
                    adVar.dZN.setVisibility(8);
                    adVar.dZT.setVisibility(0);
                    adVar.dZZ.setVisibility(8);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    adVar.dZT.a(sVar.bfK(), str, j, com.baidu.adp.lib.h.b.c(this.dYM.aGY().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    adVar.dZT.sd();
                    if (this.dZq) {
                        PraiseData qp = this.dYM.aGY().qp();
                        if (qp != null && qp.getUser() != null && qp.getUser().size() > 0) {
                            adVar.dZR.setVisibility(0);
                            adVar.dZS.setVisibility(0);
                            adVar.dZR.setIsFromPb(true);
                            adVar.dZR.a(qp, this.dYM.aGY().getId(), qp.getPostId(), true);
                            adVar.dZR.cX(this.mSkinType);
                        } else {
                            adVar.dZR.setVisibility(8);
                            adVar.dZS.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.al(adVar.dZR);
                        com.baidu.tieba.graffiti.d.al(adVar.dZS);
                        com.baidu.tbadk.data.g bfE = sVar.bfE();
                        adVar.eam.setVisibility(8);
                        if (bfE != null && !TextUtils.isEmpty(bfE.getName()) && !TextUtils.isEmpty(bfE.getName().trim())) {
                            String name = bfE.getName();
                            String lat = bfE.getLat();
                            String lng = bfE.getLng();
                            adVar.eaj.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, adVar.eaj, 0, 10, 0, 10);
                            adVar.eal.setText(bfE.getName());
                            av.c(adVar.eal, u.d.cp_link_tip_c, 1);
                            av.c(adVar.eak, u.f.icon_pb_pin);
                            adVar.eaj.setOnClickListener(new aa(this, lat, lng, name));
                        } else {
                            adVar.eaj.setVisibility(8);
                        }
                    } else {
                        adVar.dZR.setVisibility(8);
                        adVar.dZS.setVisibility(8);
                        adVar.eaj.setVisibility(8);
                        adVar.eam.setVisibility(8);
                    }
                    a(adVar.dZQ, getDimensionPixelSize(u.e.ds30));
                    ((LinearLayout.LayoutParams) adVar.dZY.getLayoutParams()).leftMargin = getDimensionPixelSize(u.e.ds30);
                } else {
                    av.l(adVar.dZD, u.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.dZq) {
                            adVar.dZE.setVisibility(8);
                            adVar.dZF.setVisibility(8);
                            PraiseData qp2 = this.dYM.aGY().qp();
                            if (qp2 != null && qp2.getUser() != null && qp2.getUser().size() > 0) {
                                adVar.dZF.setVisibility(8);
                                adVar.dZE.setVisibility(0);
                            } else {
                                adVar.dZF.setVisibility(0);
                                adVar.dZE.setVisibility(8);
                            }
                        } else {
                            adVar.dZE.setVisibility(0);
                            adVar.dZF.setVisibility(8);
                        }
                    } else {
                        adVar.dZE.setVisibility(0);
                        adVar.dZF.setVisibility(8);
                    }
                    adVar.dZG.setVisibility(0);
                    com.baidu.tbadk.data.g bfE2 = sVar.bfE();
                    adVar.eaj.setVisibility(8);
                    if (bfE2 != null && !TextUtils.isEmpty(bfE2.getName()) && !TextUtils.isEmpty(bfE2.getName().trim())) {
                        String name2 = bfE2.getName();
                        String lat2 = bfE2.getLat();
                        String lng2 = bfE2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) adVar.eam.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.dZp) {
                                layoutParams4.leftMargin = getDimensionPixelSize(u.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(u.e.ds104);
                            }
                            adVar.eam.setLayoutParams(layoutParams4);
                        }
                        adVar.eam.setVisibility(0);
                        adVar.eao.setText(bfE2.getName());
                        av.c(adVar.eao, u.d.cp_link_tip_c, 1);
                        av.c(adVar.ean, u.f.icon_pb_pin);
                        adVar.eam.setOnClickListener(new ab(this, lat2, lng2, name2));
                    } else {
                        adVar.eam.setVisibility(8);
                    }
                    adVar.dZR.setVisibility(8);
                    adVar.dZS.setVisibility(8);
                    adVar.dZU.setVisibility(0);
                    adVar.dZN.setVisibility(0);
                    String format = String.format(this.mContext.getString(u.j.is_floor), Integer.valueOf(sVar.bfB()));
                    adVar.dZM.setVisibility(0);
                    adVar.dZM.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) adVar.dZY.getLayoutParams();
                    if (!this.dZp) {
                        a(adVar.dZQ, getDimensionPixelSize(u.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(u.e.ds74);
                    } else {
                        a(adVar.dZQ, getDimensionPixelSize(u.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(u.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) adVar.dZV.getLayoutParams();
                    if (!this.dZp) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(u.e.ds30);
                    }
                }
                if (this.dZr != null && !this.dZr.equals("0") && this.dZr.equals(sVar.getAuthor().getUserId())) {
                    adVar.dZO.setVisibility(0);
                    av.c(adVar.dZO, u.f.icon_floorhost);
                }
            }
            av.k(adVar.dZH, u.f.bg_floor_new_middle);
            adVar.dZQ.setVideoImageId(u.f.pic_video);
            adVar.dZQ.setTextColor(av.getColor(u.d.common_color_10039));
            av.c(adVar.dZP, u.f.btn_pb_reply_selector);
            adVar.dZQ.setLinkTextColor(av.getColor(u.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) adVar.dZP.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                adVar.dZP.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(u.g.tag_clip_board, sVar);
            sparseArray.put(u.g.tag_load_sub_data, sVar);
            sparseArray.put(u.g.tag_load_sub_view, view);
            sparseArray.put(u.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(u.g.tag_pb_floor_number, Integer.valueOf(sVar.bfB()));
            if (sVar.bfF() > 0) {
                if (this.dZs == null) {
                    this.dZs = new au(this.mContext);
                    this.dZs.setIsFromCDN(this.mIsFromCDN);
                    this.dZs.K(this.dZu);
                    boolean z7 = false;
                    String userId2 = this.dYM.aGY().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.dZs.N(this.dYM.aHf(), z7);
                    this.dZs.r(this.dYM.aGY());
                    this.dZs.hs(this.dZp);
                }
                adVar.dZX.setVisibility(0);
                adVar.dZW.setVisibility(0);
                adVar.dZV.setVisibility(0);
                adVar.dZX.a(sVar, view);
                adVar.dZX.setChildOnClickListener(this.baF);
                adVar.dZX.setChildOnLongClickListener(this.alj);
                adVar.dZX.setChildOnTouchListener(this.dYQ);
                adVar.dZX.setSubPbAdapter(this.dZs);
                adVar.dZX.setVisibility(0);
            } else {
                adVar.dZX.setVisibility(8);
                adVar.dZW.setVisibility(8);
                adVar.dZV.setVisibility(8);
            }
            a(adVar, sVar, this.dYM.aHi(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.v.gw(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                    }
                    adVar.aPR.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        av.c(adVar.aPR, u.d.cp_cont_h, 1);
                    } else {
                        av.c(adVar.aPR, u.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        adVar.dZJ.setVisibility(0);
                        av.c(adVar.dZJ, BitmapHelper.getGradeResourceIdNew(level_id));
                        adVar.dZJ.setContentDescription(String.format(TbadkCoreApplication.m10getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                        adVar.dZJ.setOnClickListener(null);
                    } else {
                        adVar.dZJ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            av.c(adVar.dZK, u.f.pb_manager);
                            adVar.dZJ.setVisibility(8);
                            adVar.dZK.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            av.c(adVar.dZK, u.f.pb_assist);
                            adVar.dZJ.setVisibility(8);
                            adVar.dZK.setVisibility(0);
                        }
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        av.c(adVar.dZL, u.f.icon_pb_pop_girl);
                        adVar.dZL.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        av.c(adVar.dZL, u.f.icon_pb_pop_boy);
                        adVar.dZL.setVisibility(0);
                    } else {
                        adVar.dZL.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.v.gw(sVar.getAuthor().getName_show()) >= 14 && adVar.dZJ.getVisibility() == 0 && adVar.dZO.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.dZt = sVar.getAuthor().getIconInfo();
                    this.cQe = sVar.getAuthor().getTShowInfoNew();
                    if (adVar.bVj != null) {
                        adVar.bVj.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                        adVar.bVj.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.bJt);
                        adVar.bVj.a(this.dZt, i2, getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds30), getDimensionPixelSize(u.e.ds10));
                    }
                    if (adVar.aeT != null) {
                        adVar.aeT.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.eiK);
                        adVar.aeT.a(this.cQe, 3, getDimensionPixelSize(u.e.ds36), getDimensionPixelSize(u.e.ds32), getDimensionPixelSize(u.e.ds8), true);
                    }
                }
                adVar.dZI.setUserId(sVar.getAuthor().getUserId());
                adVar.dZI.setUserName(sVar.getAuthor().getUserName());
                adVar.dZI.setImageDrawable(null);
                adVar.aPR.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                adVar.aPR.setTag(u.g.tag_user_name, sVar.getAuthor().getUserName());
                adVar.dZI.c(portrait, 28, false);
            }
            adVar.dZQ.setLinkTextColor(av.getColor(u.d.cp_link_tip_c));
            if (this.cwk) {
                adVar.dZQ.setDefaultImageId(u.f.transparent_bg);
            } else {
                adVar.dZQ.setDefaultImageId(u.f.icon_click);
            }
            adVar.dZQ.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.avx();
            }
            if (this.dZv || !this.dZw) {
                adVar.dZQ.a(aVar, false);
            } else {
                adVar.dZQ.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.dYM.aHf() != 0) {
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
            if (this.dYM != null && this.dYM.aGY() != null && this.dYM.aGY().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.dYM.aGY().getAuthor().getUserId();
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
                        if (adVar.eae != null) {
                            adVar.eae.setVisibility(0);
                            adVar.eae.setText(u.j.manage);
                            adVar.eae.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (adVar.eae != null) {
                            adVar.eae.setVisibility(0);
                            adVar.eae.setText(u.j.delete);
                            adVar.eae.setCompoundDrawablesWithIntrinsicBounds(getDrawable(u.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (adVar.eae != null) {
                        adVar.eae.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.bfB() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(u.g.tag_should_manage_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dYM.aHf()));
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
                        if (this.dYM.aGY() != null) {
                            sparseArray.put(u.g.tag_user_mute_thread_id, this.dYM.aGY().getId());
                        }
                        sparseArray.put(u.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(u.g.tag_should_delete_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dYM.aHf()));
                        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(u.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        adVar.dZP.setVisibility(8);
                        av.c(adVar.eac, u.d.common_color_10005, 1);
                        adVar.eac.setText(String.format(this.mContext.getResources().getString(u.j.write_addition_update), ba.t(sVar.getTime())));
                        if (adVar.eae.getVisibility() == 0) {
                            av.c(adVar.eae, u.d.cp_link_tip_c, 3);
                            sparseArray.put(u.g.tag_user_mute_visible, false);
                            adVar.eae.setTag(sparseArray);
                            adVar.eae.setOnClickListener(this.dZu);
                        }
                    }
                    a(adVar, sVar, sVar.bfB() != 1, aVar);
                    b(adVar);
                    if (z) {
                        a(view, sVar);
                        if (this.dZz != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.dZz.bmE();
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
            if (sVar.bfB() == 1) {
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
            a(adVar, sVar, sVar.bfB() != 1, aVar);
            b(adVar);
            if (z) {
            }
        }
    }

    private void b(ad adVar) {
        adVar.dZQ.setTextViewOnTouchListener(this.dYQ);
        adVar.dZQ.setTextViewCheckSelection(false);
    }

    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aMg() == null || c(sVar)) {
            adVar.eap.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(sVar.aMg(), adVar.eap, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dZy - (i - this.dZx));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.bfG() > 0 && sVar.bfA() != null) {
            adVar.eab.setVisibility(0);
            adVar.eab.removeViews(0, adVar.eab.getChildCount() - 1);
            int size = sVar.bfA().size();
            int bfH = sVar.bfH();
            for (int i2 = 0; i2 < bfH; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.bfA().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(u.h.new_pb_list_item, (ViewGroup) adVar.eab, false);
                ad adVar2 = new ad(inflate, this.dZp, this.cwk, this.dZo, true);
                c(adVar2);
                a(adVar2, sVar2, (View) adVar.eab, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(u.g.tag_clip_board, sVar2);
                sparseArray.put(u.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.cwk) {
                    sparseArray.put(u.g.tag_richtext_bg, null);
                    adVar2.dZQ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adVar2.dZQ.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    adVar2.dZQ.setLayoutParams(layoutParams);
                    adVar2.dZQ.setPadding(0, 0, 0, 0);
                    adVar.dZQ.gB(null);
                } else {
                    adVar.dZQ.gB(sVar.getBimg_url());
                    adVar2.dZQ.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) adVar2.dZQ.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(u.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(u.e.ds36);
                    adVar2.dZQ.setLayoutParams(layoutParams2);
                }
                adVar.eab.addView(inflate, adVar.eab.getChildCount() - 1);
            }
            if (bfH < size) {
                adVar.eaf.setVisibility(0);
                av.k(adVar.eah, u.d.cp_bg_line_b);
                av.k(adVar.eai, u.d.cp_bg_line_b);
                av.c(adVar.eag, u.d.cp_cont_f, 1);
                adVar.eaf.setOnClickListener(new ac(this, bfH, size, sVar));
                return;
            }
            adVar.eaf.setVisibility(8);
            return;
        }
        adVar.eab.setVisibility(8);
    }

    private boolean c(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (this.dYM == null || this.dYM.aGY() == null || !this.dYM.aGY().rg() || this.dYM.aGY().qo() == null || sVar.bfB() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (c(sVar) && view != null && this.eat != null) {
            if (this.dZz == null) {
                this.dZz = new com.baidu.tieba.vote.b(this.eat);
            }
            this.dZz.a(view, this.dYM);
        } else if (this.dZz != null) {
            this.dZz.setVisibility(8);
        }
    }

    private void c(ad adVar) {
        adVar.aPR.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.eiJ);
        adVar.dZP.setOnClickListener(this.baF);
        adVar.dZI.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.eiJ);
        adVar.dZU.setOnLongClickListener(this.alj);
        adVar.dZQ.setOnLongClickListener(this.alj);
        adVar.dZU.setOnTouchListener(this.dYQ);
        adVar.dZQ.setOnTouchListener(this.dYQ);
        adVar.dZQ.setOnImageClickListener(this.aGw);
        adVar.dZQ.setOnEmotionClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.eiL);
        adVar.bVj.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.bJt);
        adVar.aeT.setOnClickListener(((PbActivity) this.eat.getPageContext().getOrignalPage()).ebc.eiK);
        adVar.eap.setOnClickListener(this.baF);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.dYM = hVar;
    }

    public void nx(int i) {
        this.dZo = i;
    }

    public void hr(boolean z) {
        this.cwk = z;
    }

    public void hs(boolean z) {
        this.dZp = z;
    }

    public void ht(boolean z) {
        this.dZq = z;
    }

    public void ob(String str) {
        this.dZr = str;
    }

    public void I(View.OnClickListener onClickListener) {
        this.dZu = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.baF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGw = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dYQ = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alj = onLongClickListener;
    }
}
