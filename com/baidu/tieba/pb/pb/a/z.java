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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.pb.pb.sub.av;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends cs<com.baidu.tieba.tbadkCore.data.q, ad> implements View.OnClickListener {
    private TbRichTextView.d aJI;
    private View.OnLongClickListener aoq;
    private View.OnClickListener bmb;
    private boolean cHP;
    private ArrayList<IconData> dbL;
    private com.baidu.tieba.pb.data.h ekQ;
    private com.baidu.tieba.pb.a.d ekU;
    private final boolean elA;
    private int elB;
    private int elC;
    private com.baidu.tieba.vote.b elD;
    private int els;
    private boolean elt;
    private boolean elu;
    private String elv;
    private av elw;
    private ArrayList<IconData> elx;
    private View.OnClickListener ely;
    private boolean elz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.els = 0;
        this.cHP = true;
        this.elt = true;
        this.elu = true;
        this.ekQ = null;
        this.elv = null;
        this.elw = null;
        this.elx = null;
        this.dbL = null;
        this.ely = null;
        this.bmb = null;
        this.aJI = null;
        this.ekU = null;
        this.aoq = null;
        this.elz = false;
        this.elA = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(ad adVar) {
        if (adVar != null) {
            if (adVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.av.l(adVar.elI, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(adVar.elJ, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(adVar.emh, t.d.common_color_10005, 1);
                com.baidu.tbadk.core.util.av.c(adVar.emj, t.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.av.c(adVar.aVl, t.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.av.c((View) adVar.elO, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c((View) adVar.elP, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c(adVar.elR, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(adVar.elS, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(adVar.elU, t.f.btn_pb_reply_selector);
                com.baidu.tbadk.core.util.av.l(adVar.elW, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.l(adVar.elX, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.c(adVar.elX, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(adVar.emb, t.d.cp_bg_line_b);
            }
            adVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.elB = getDimensionPixelSize(t.e.ds30);
        this.elC = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public ad a(ViewGroup viewGroup) {
        ad adVar = new ad(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.elt, this.cHP, this.els, false);
        a(adVar);
        return adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, ad adVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) adVar);
        a(adVar);
        c(adVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aJ(i);
        if (qVar2 != null) {
            a(adVar, qVar2, view, false, i);
        }
        if (!this.elz && this.elA && adVar != null && adVar.elV.IN() && (listView = ((PbActivity) this.emy.getPageContext().getOrignalPage()).getListView()) != null) {
            this.elz = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0ab8  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0ae8  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0af4  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0b00  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0b0c  */
    /* JADX WARN: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (adVar != null && qVar != null) {
            if (!z) {
                adVar.elN.setTag(null);
                adVar.elN.setUserId(null);
                adVar.aVl.setText((CharSequence) null);
                adVar.elP.setVisibility(8);
                adVar.emc.setVisibility(0);
                adVar.elU.setVisibility(0);
                adVar.elT.setVisibility(8);
                if (qVar.bje() == null || c(qVar)) {
                    adVar.emd.setVisibility(8);
                } else if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && qVar.bje().BP() == 1) {
                    adVar.emd.changeSkinType(this.mSkinType);
                    adVar.emd.setVisibility(0);
                    adVar.emd.setData(qVar.bje());
                } else {
                    adVar.emd.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) adVar.elZ.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    adVar.elZ.setTag(sparseArray2);
                    adVar.elV.setTag(sparseArray2);
                }
                sparseArray2.put(t.g.tag_clip_board, qVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                a(adVar.elV, getDimensionPixelSize(t.e.ds30));
                if (TextUtils.isEmpty(qVar.getBimg_url()) || !this.cHP || c(qVar)) {
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adVar.elV.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    adVar.elV.setLayoutParams(layoutParams);
                    adVar.elV.setPadding(0, 0, 0, 0);
                    adVar.elV.gE(null);
                } else {
                    sparseArray2.put(t.g.tag_richtext_bg, qVar.getBimg_url());
                    adVar.elV.gE(qVar.getBimg_url());
                    if (qVar.bjc() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) adVar.elV.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds40);
                        adVar.elV.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) adVar.elV.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(t.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(t.e.ds20);
                        adVar.elV.setLayoutParams(layoutParams3);
                    }
                }
                adVar.elS.setText(ba.t(qVar.getTime()));
                adVar.elY.setVisibility(8);
                if (qVar.bjc() == 1) {
                    com.baidu.tbadk.core.util.av.l(adVar.elH, t.d.cp_bg_line_d);
                    adVar.elI.setVisibility(8);
                    adVar.elJ.setVisibility(8);
                    adVar.elK.setVisibility(8);
                    adVar.elZ.setVisibility(8);
                    adVar.elS.setVisibility(8);
                    adVar.elY.setVisibility(0);
                    adVar.eme.setVisibility(8);
                    String str = null;
                    long j = 0;
                    if (qVar.getAuthor() != null) {
                        j = qVar.getAuthor().getUserIdLong();
                        str = qVar.getAuthor().getUserName();
                    }
                    adVar.elY.a(qVar.bjl(), str, j, com.baidu.adp.lib.h.b.c(this.ekQ.aLQ().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                    adVar.elY.ti();
                    if (this.elu) {
                        PraiseData rt = this.ekQ.aLQ().rt();
                        if (rt != null && rt.getUser() != null && rt.getUser().size() > 0) {
                            adVar.elW.setVisibility(0);
                            adVar.elX.setVisibility(0);
                            adVar.elW.setIsFromPb(true);
                            adVar.elW.a(rt, this.ekQ.aLQ().getId(), rt.getPostId(), true);
                            adVar.elW.dl(this.mSkinType);
                        } else {
                            adVar.elW.setVisibility(8);
                            adVar.elX.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.al(adVar.elW);
                        com.baidu.tieba.graffiti.d.al(adVar.elX);
                        com.baidu.tbadk.data.g bjf = qVar.bjf();
                        adVar.emr.setVisibility(8);
                        if (bjf != null && !TextUtils.isEmpty(bjf.getName()) && !TextUtils.isEmpty(bjf.getName().trim())) {
                            String name = bjf.getName();
                            String lat = bjf.getLat();
                            String lng = bjf.getLng();
                            adVar.emo.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, adVar.emo, 0, 10, 0, 10);
                            adVar.emq.setText(bjf.getName());
                            com.baidu.tbadk.core.util.av.c(adVar.emq, t.d.cp_link_tip_c, 1);
                            com.baidu.tbadk.core.util.av.c(adVar.emp, t.f.icon_pb_pin);
                            adVar.emo.setOnClickListener(new aa(this, lat, lng, name));
                        } else {
                            adVar.emo.setVisibility(8);
                        }
                    } else {
                        adVar.elW.setVisibility(8);
                        adVar.elX.setVisibility(8);
                        adVar.emo.setVisibility(8);
                        adVar.emr.setVisibility(8);
                    }
                    a(adVar.elV, getDimensionPixelSize(t.e.ds30));
                    ((LinearLayout.LayoutParams) adVar.emd.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                } else {
                    com.baidu.tbadk.core.util.av.l(adVar.elH, t.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.elu) {
                            adVar.elI.setVisibility(8);
                            adVar.elJ.setVisibility(8);
                            PraiseData rt2 = this.ekQ.aLQ().rt();
                            if (rt2 != null && rt2.getUser() != null && rt2.getUser().size() > 0) {
                                adVar.elJ.setVisibility(8);
                                adVar.elI.setVisibility(0);
                            } else {
                                adVar.elJ.setVisibility(0);
                                adVar.elI.setVisibility(8);
                            }
                        } else {
                            adVar.elI.setVisibility(0);
                            adVar.elJ.setVisibility(8);
                        }
                    } else {
                        adVar.elI.setVisibility(0);
                        adVar.elJ.setVisibility(8);
                    }
                    adVar.elK.setVisibility(0);
                    com.baidu.tbadk.data.g bjf2 = qVar.bjf();
                    adVar.emo.setVisibility(8);
                    if (bjf2 != null && !TextUtils.isEmpty(bjf2.getName()) && !TextUtils.isEmpty(bjf2.getName().trim())) {
                        String name2 = bjf2.getName();
                        String lat2 = bjf2.getLat();
                        String lng2 = bjf2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) adVar.emr.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.elt) {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds104);
                            }
                            adVar.emr.setLayoutParams(layoutParams4);
                        }
                        adVar.emr.setVisibility(0);
                        adVar.emt.setText(bjf2.getName());
                        com.baidu.tbadk.core.util.av.c(adVar.emt, t.d.cp_link_tip_c, 1);
                        com.baidu.tbadk.core.util.av.c(adVar.ems, t.f.icon_pb_pin);
                        adVar.emr.setOnClickListener(new ab(this, lat2, lng2, name2));
                    } else {
                        adVar.emr.setVisibility(8);
                    }
                    adVar.elW.setVisibility(8);
                    adVar.elX.setVisibility(8);
                    adVar.elZ.setVisibility(0);
                    adVar.elS.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(qVar.bjc()));
                    adVar.elR.setVisibility(0);
                    adVar.elR.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) adVar.emd.getLayoutParams();
                    if (!this.elt) {
                        a(adVar.elV, getDimensionPixelSize(t.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds74);
                    } else {
                        a(adVar.elV, getDimensionPixelSize(t.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) adVar.ema.getLayoutParams();
                    if (!this.elt) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds30);
                    }
                }
                if (this.elv != null && !this.elv.equals("0") && this.elv.equals(qVar.getAuthor().getUserId())) {
                    adVar.elT.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(adVar.elT, t.f.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.av.k(adVar.elL, t.f.bg_floor_new_middle);
            adVar.elV.setVideoImageId(t.f.pic_video);
            adVar.elV.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10039));
            com.baidu.tbadk.core.util.av.c(adVar.elU, t.f.btn_pb_reply_selector);
            adVar.elV.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) adVar.elU.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                adVar.elU.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, qVar);
            sparseArray.put(t.g.tag_load_sub_data, qVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(t.g.tag_pb_floor_number, Integer.valueOf(qVar.bjc()));
            if (qVar.bjg() > 0) {
                if (this.elw == null) {
                    this.elw = new av(this.mContext);
                    this.elw.setIsFromCDN(this.mIsFromCDN);
                    this.elw.I(this.ely);
                    boolean z7 = false;
                    String userId2 = this.ekQ.aLQ().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.elw.N(this.ekQ.aLX(), z7);
                    this.elw.r(this.ekQ.aLQ());
                    this.elw.hO(this.elt);
                }
                this.elw.pj(qVar.getId());
                adVar.emc.setVisibility(0);
                adVar.emb.setVisibility(0);
                adVar.ema.setVisibility(0);
                adVar.emc.a(qVar, view);
                adVar.emc.setChildOnClickListener(this.bmb);
                adVar.emc.setChildOnLongClickListener(this.aoq);
                adVar.emc.setChildOnTouchListener(this.ekU);
                adVar.emc.setSubPbAdapter(this.elw);
                adVar.emc.setVisibility(0);
            } else {
                adVar.emc.setVisibility(8);
                adVar.emb.setVisibility(8);
                adVar.ema.setVisibility(8);
            }
            a(adVar, qVar, this.ekQ.aMa(), i);
            if (!z) {
                String portrait = qVar.getAuthor().getPortrait();
                if (qVar.getAuthor() != null) {
                    String name_show = qVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.v.gz(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                    }
                    adVar.aVl.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(adVar.aVl, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(adVar.aVl, t.d.cp_cont_f, 1);
                    }
                    int level_id = qVar.getAuthor().getLevel_id();
                    int is_bawu = qVar.getAuthor().getIs_bawu();
                    String bawu_type = qVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        adVar.elO.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(adVar.elO, BitmapHelper.getGradeResourceIdNew(level_id));
                        adVar.elO.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                        adVar.elO.setOnClickListener(null);
                    } else {
                        adVar.elO.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(adVar.elP, t.f.pb_manager);
                            adVar.elO.setVisibility(8);
                            adVar.elP.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(adVar.elP, t.f.pb_assist);
                            adVar.elO.setVisibility(8);
                            adVar.elP.setVisibility(0);
                        }
                    }
                    if (qVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(adVar.elQ, t.f.icon_pb_pop_girl);
                        adVar.elQ.setVisibility(0);
                    } else if (qVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(adVar.elQ, t.f.icon_pb_pop_boy);
                        adVar.elQ.setVisibility(0);
                    } else {
                        adVar.elQ.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.v.gz(qVar.getAuthor().getName_show()) >= 14 && adVar.elO.getVisibility() == 0 && adVar.elT.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.elx = qVar.getAuthor().getIconInfo();
                    this.dbL = qVar.getAuthor().getTShowInfoNew();
                    if (adVar.cgs != null) {
                        adVar.cgs.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                        adVar.cgs.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.bUu);
                        adVar.cgs.a(this.elx, i2, getDimensionPixelSize(t.e.ds30), getDimensionPixelSize(t.e.ds30), getDimensionPixelSize(t.e.ds10));
                    }
                    if (adVar.ahO != null) {
                        adVar.ahO.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euR);
                        adVar.ahO.a(this.dbL, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.ds32), getDimensionPixelSize(t.e.ds8), true);
                    }
                }
                if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().rc())) {
                    adVar.elN.setVisibility(4);
                    adVar.elM.setVisibility(0);
                    adVar.elM.dU(qVar.getAuthor().getPendantData().rc());
                    adVar.elM.getHeadView().c(portrait, 28, false);
                    adVar.elM.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                    adVar.elM.setTag(t.g.tag_user_name, qVar.getAuthor().getUserName());
                } else {
                    adVar.elN.setVisibility(0);
                    adVar.elM.setVisibility(8);
                    adVar.elN.setUserId(qVar.getAuthor().getUserId());
                    adVar.elN.setUserName(qVar.getAuthor().getUserName());
                    adVar.elN.setImageDrawable(null);
                    adVar.elN.c(portrait, 28, false);
                }
                adVar.aVl.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                adVar.aVl.setTag(t.g.tag_user_name, qVar.getAuthor().getUserName());
            }
            adVar.elV.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_link_tip_c));
            if (this.cHP) {
                adVar.elV.setDefaultImageId(t.f.transparent_bg);
            } else {
                adVar.elV.setDefaultImageId(t.f.icon_click);
            }
            adVar.elV.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = qVar.aAk();
            }
            if (this.elz || !this.elA) {
                adVar.elV.a(aVar, false);
            } else {
                adVar.elV.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.ekQ.aLX() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = qVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.ekQ != null && this.ekQ.aLQ() != null && this.ekQ.aLQ().getAuthor() != null && qVar.getAuthor() != null) {
                String userId4 = this.ekQ.aLQ().getAuthor().getUserId();
                String userId5 = qVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = qVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (adVar.emj != null) {
                            adVar.emj.setVisibility(0);
                            adVar.emj.setText(t.j.manage);
                            adVar.emj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (adVar.emj != null) {
                            adVar.emj.setVisibility(0);
                            adVar.emj.setText(t.j.delete);
                            adVar.emj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (adVar.emj != null) {
                        adVar.emj.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (qVar.bjc() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ekQ.aLX()));
                        sparseArray.put(t.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.ekQ.aLQ() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.ekQ.aLQ().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ekQ.aLX()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        adVar.elU.setVisibility(8);
                        com.baidu.tbadk.core.util.av.c(adVar.emh, t.d.common_color_10005, 1);
                        adVar.emh.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), ba.t(qVar.getTime())));
                        if (adVar.emj.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.av.c(adVar.emj, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            adVar.emj.setTag(sparseArray);
                            adVar.emj.setOnClickListener(this.ely);
                        }
                    }
                    a(adVar, qVar, qVar.bjc() != 1, aVar);
                    b(adVar);
                    if (z) {
                        a(view, qVar);
                        if (this.elD != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.elD.bqu();
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
            userId = qVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (qVar.bjc() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, qVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(adVar, qVar, qVar.bjc() != 1, aVar);
            b(adVar);
            if (z) {
            }
        }
    }

    private void b(ad adVar) {
        adVar.elV.setTextViewOnTouchListener(this.ekU);
        adVar.elV.setTextViewCheckSelection(false);
    }

    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aQY() == null || c(qVar)) {
            adVar.emu.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(qVar.aQY(), adVar.emu, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.elC - (i - this.elB));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(ad adVar, com.baidu.tieba.tbadkCore.data.q qVar, AdditionData additionData, int i) {
        if (qVar.bjh() > 0 && qVar.bjb() != null) {
            adVar.emg.setVisibility(0);
            adVar.emg.removeViews(0, adVar.emg.getChildCount() - 1);
            int size = qVar.bjb().size();
            int bji = qVar.bji();
            for (int i2 = 0; i2 < bji; i2++) {
                com.baidu.tieba.tbadkCore.data.q qVar2 = qVar.bjb().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) adVar.emg, false);
                ad adVar2 = new ad(inflate, this.elt, this.cHP, this.els, true);
                c(adVar2);
                a(adVar2, qVar2, (View) adVar.emg, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, qVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(qVar2.getBimg_url()) || !this.cHP) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    adVar2.elV.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) adVar2.elV.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    adVar2.elV.setLayoutParams(layoutParams);
                    adVar2.elV.setPadding(0, 0, 0, 0);
                    adVar.elV.gE(null);
                } else {
                    adVar.elV.gE(qVar.getBimg_url());
                    adVar2.elV.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) adVar2.elV.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    adVar2.elV.setLayoutParams(layoutParams2);
                }
                adVar.emg.addView(inflate, adVar.emg.getChildCount() - 1);
            }
            if (bji < size) {
                adVar.emk.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(adVar.emm, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(adVar.emn, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(adVar.eml, t.d.cp_cont_f, 1);
                adVar.emk.setOnClickListener(new ac(this, bji, size, qVar));
                return;
            }
            adVar.emk.setVisibility(8);
            return;
        }
        adVar.emg.setVisibility(8);
    }

    private boolean c(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (this.ekQ == null || this.ekQ.aLQ() == null || !this.ekQ.aLQ().sm() || this.ekQ.aLQ().rs() == null || qVar.bjc() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.q qVar) {
        if (c(qVar) && view != null && this.emy != null) {
            if (this.elD == null) {
                this.elD = new com.baidu.tieba.vote.b(this.emy);
            }
            this.elD.a(view, this.ekQ);
        } else if (this.elD != null) {
            this.elD.setVisibility(8);
        }
    }

    private void c(ad adVar) {
        adVar.aVl.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euQ);
        adVar.elU.setOnClickListener(this.bmb);
        adVar.elN.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euQ);
        adVar.elM.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euQ);
        adVar.elZ.setOnLongClickListener(this.aoq);
        adVar.elV.setOnLongClickListener(this.aoq);
        adVar.elZ.setOnTouchListener(this.ekU);
        adVar.elV.setOnTouchListener(this.ekU);
        adVar.elV.setOnImageClickListener(this.aJI);
        adVar.elV.setOnEmotionClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euS);
        adVar.cgs.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.bUu);
        adVar.ahO.setOnClickListener(((PbActivity) this.emy.getPageContext().getOrignalPage()).eni.euR);
        adVar.emu.setOnClickListener(this.bmb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.ekQ = hVar;
    }

    public void oa(int i) {
        this.els = i;
    }

    public void hN(boolean z) {
        this.cHP = z;
    }

    public void hO(boolean z) {
        this.elt = z;
    }

    public void hP(boolean z) {
        this.elu = z;
    }

    public void oL(String str) {
        this.elv = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.ely = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmb = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJI = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ekU = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoq = onLongClickListener;
    }
}
