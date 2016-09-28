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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.pb.pb.sub.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class w extends cs<com.baidu.tieba.tbadkCore.data.q, aa> implements View.OnClickListener {
    private TbRichTextView.e aJh;
    private View.OnLongClickListener anY;
    private View.OnClickListener bmo;
    private boolean cIH;
    private ArrayList<IconData> ddj;
    private com.baidu.tieba.pb.data.h emS;
    private com.baidu.tieba.pb.a.d emU;
    private com.baidu.tieba.vote.b enA;
    private int enp;
    private boolean enq;
    private boolean enr;
    private String ens;
    private av ent;
    private ArrayList<IconData> enu;
    private View.OnClickListener env;
    private boolean enw;
    private final boolean enx;
    private int eny;
    private int enz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.enp = 0;
        this.cIH = true;
        this.enq = true;
        this.enr = true;
        this.emS = null;
        this.ens = null;
        this.ent = null;
        this.enu = null;
        this.ddj = null;
        this.env = null;
        this.bmo = null;
        this.aJh = null;
        this.emU = null;
        this.anY = null;
        this.enw = false;
        this.enx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(aa aaVar) {
        if (aaVar != null) {
            if (aaVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.av.l(aaVar.enF, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.l(aaVar.enG, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(aaVar.eoe, r.d.common_color_10005, 1);
                com.baidu.tbadk.core.util.av.c(aaVar.eoh, r.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.av.c(aaVar.aVU, r.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.av.c((View) aaVar.enL, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c((View) aaVar.enM, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.av.c(aaVar.enO, r.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(aaVar.enP, r.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.av.c(aaVar.enR, r.f.btn_pb_reply_selector);
                com.baidu.tbadk.core.util.av.l(aaVar.enT, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.l(aaVar.enU, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.av.c(aaVar.enU, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(aaVar.enY, r.d.cp_bg_line_b);
            }
            aaVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.eny = getDimensionPixelSize(r.e.ds30);
        this.enz = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(r.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public aa a(ViewGroup viewGroup) {
        aa aaVar = new aa(LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, viewGroup, false), this.enq, this.cIH, this.enp, false);
        a(aaVar);
        return aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, aa aaVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) aaVar);
        a(aaVar);
        c(aaVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aJ(i);
        if (qVar2 != null) {
            qVar2.sL();
            a(aaVar, qVar2, view, false, i);
        }
        if (!this.enw && this.enx && aaVar != null && aaVar.enS.IN() && (listView = ((PbActivity) this.eow.getPageContext().getOrignalPage()).getListView()) != null) {
            this.enw = true;
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
    private void a(aa aaVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (aaVar != null && qVar != null) {
            if (!z) {
                aaVar.enK.setTag(null);
                aaVar.enK.setUserId(null);
                aaVar.aVU.setText((CharSequence) null);
                aaVar.enM.setVisibility(8);
                aaVar.enZ.setVisibility(0);
                aaVar.enR.setVisibility(0);
                aaVar.enQ.setVisibility(8);
                if (qVar.bjQ() == null || c(qVar)) {
                    aaVar.eoa.setVisibility(8);
                } else if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && qVar.bjQ().BT() == 1) {
                    aaVar.eoa.changeSkinType(this.mSkinType);
                    aaVar.eoa.setVisibility(0);
                    aaVar.eoa.setData(qVar.bjQ());
                } else {
                    aaVar.eoa.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) aaVar.enW.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    aaVar.enW.setTag(sparseArray2);
                    aaVar.enS.setTag(sparseArray2);
                }
                sparseArray2.put(r.g.tag_clip_board, qVar);
                sparseArray2.put(r.g.tag_is_subpb, false);
                a(aaVar.enS, getDimensionPixelSize(r.e.ds30));
                if (TextUtils.isEmpty(qVar.getBimg_url()) || !this.cIH || c(qVar)) {
                    sparseArray2.put(r.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aaVar.enS.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    aaVar.enS.setLayoutParams(layoutParams);
                    aaVar.enS.setPadding(0, 0, 0, 0);
                    aaVar.enS.gI(null);
                } else {
                    sparseArray2.put(r.g.tag_richtext_bg, qVar.getBimg_url());
                    aaVar.enS.gI(qVar.getBimg_url());
                    if (qVar.bjO() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aaVar.enS.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(r.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(r.e.ds40);
                        aaVar.enS.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) aaVar.enS.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(r.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(r.e.ds20);
                        aaVar.enS.setLayoutParams(layoutParams3);
                    }
                }
                aaVar.enP.setText(az.t(qVar.getTime()));
                aaVar.enV.setVisibility(8);
                if (qVar.bjO() == 1) {
                    com.baidu.tbadk.core.util.av.l(aaVar.enE, r.d.cp_bg_line_d);
                    aaVar.enF.setVisibility(8);
                    aaVar.enG.setVisibility(8);
                    aaVar.enH.setVisibility(8);
                    aaVar.enW.setVisibility(8);
                    aaVar.enP.setVisibility(8);
                    aaVar.enV.setVisibility(0);
                    aaVar.eob.setVisibility(8);
                    String str = null;
                    long j = 0;
                    if (qVar.getAuthor() != null) {
                        j = qVar.getAuthor().getUserIdLong();
                        str = qVar.getAuthor().getUserName();
                    }
                    aaVar.enV.a(qVar.bjX(), str, j, com.baidu.adp.lib.h.b.c(this.emS.aMs().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                    aaVar.enV.tx();
                    if (this.enr) {
                        PraiseData rF = this.emS.aMs().rF();
                        if (rF != null && rF.getUser() != null && rF.getUser().size() > 0) {
                            aaVar.enT.setVisibility(0);
                            aaVar.enU.setVisibility(0);
                            aaVar.enT.setIsFromPb(true);
                            aaVar.enT.a(rF, this.emS.aMs().getId(), rF.getPostId(), true);
                            aaVar.enT.dl(this.mSkinType);
                        } else {
                            aaVar.enT.setVisibility(8);
                            aaVar.enU.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.ak(aaVar.enT);
                        com.baidu.tieba.graffiti.d.ak(aaVar.enU);
                        com.baidu.tbadk.data.g bjR = qVar.bjR();
                        aaVar.eop.setVisibility(8);
                        if (bjR != null && !TextUtils.isEmpty(bjR.getName()) && !TextUtils.isEmpty(bjR.getName().trim())) {
                            String name = bjR.getName();
                            String lat = bjR.getLat();
                            String lng = bjR.getLng();
                            aaVar.eom.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, aaVar.eom, 0, 10, 0, 10);
                            aaVar.eoo.setText(bjR.getName());
                            com.baidu.tbadk.core.util.av.c(aaVar.eoo, r.d.cp_link_tip_c, 1);
                            com.baidu.tbadk.core.util.av.c(aaVar.eon, r.f.icon_pb_pin);
                            aaVar.eom.setOnClickListener(new x(this, lat, lng, name));
                        } else {
                            aaVar.eom.setVisibility(8);
                        }
                    } else {
                        aaVar.enT.setVisibility(8);
                        aaVar.enU.setVisibility(8);
                        aaVar.eom.setVisibility(8);
                        aaVar.eop.setVisibility(8);
                    }
                    a(aaVar.enS, getDimensionPixelSize(r.e.ds30));
                    ((LinearLayout.LayoutParams) aaVar.eoa.getLayoutParams()).leftMargin = getDimensionPixelSize(r.e.ds30);
                } else {
                    com.baidu.tbadk.core.util.av.l(aaVar.enE, r.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.enr) {
                            aaVar.enF.setVisibility(8);
                            aaVar.enG.setVisibility(8);
                            PraiseData rF2 = this.emS.aMs().rF();
                            if (rF2 != null && rF2.getUser() != null && rF2.getUser().size() > 0) {
                                aaVar.enG.setVisibility(8);
                                aaVar.enF.setVisibility(0);
                            } else {
                                aaVar.enG.setVisibility(0);
                                aaVar.enF.setVisibility(8);
                            }
                        } else {
                            aaVar.enF.setVisibility(0);
                            aaVar.enG.setVisibility(8);
                        }
                    } else {
                        aaVar.enF.setVisibility(0);
                        aaVar.enG.setVisibility(8);
                    }
                    aaVar.enH.setVisibility(0);
                    com.baidu.tbadk.data.g bjR2 = qVar.bjR();
                    aaVar.eom.setVisibility(8);
                    if (bjR2 != null && !TextUtils.isEmpty(bjR2.getName()) && !TextUtils.isEmpty(bjR2.getName().trim())) {
                        String name2 = bjR2.getName();
                        String lat2 = bjR2.getLat();
                        String lng2 = bjR2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) aaVar.eop.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.enq) {
                                layoutParams4.leftMargin = getDimensionPixelSize(r.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(r.e.ds104);
                            }
                            aaVar.eop.setLayoutParams(layoutParams4);
                        }
                        aaVar.eop.setVisibility(0);
                        aaVar.eor.setText(bjR2.getName());
                        com.baidu.tbadk.core.util.av.c(aaVar.eor, r.d.cp_link_tip_c, 1);
                        com.baidu.tbadk.core.util.av.c(aaVar.eoq, r.f.icon_pb_pin);
                        aaVar.eop.setOnClickListener(new y(this, lat2, lng2, name2));
                    } else {
                        aaVar.eop.setVisibility(8);
                    }
                    aaVar.enT.setVisibility(8);
                    aaVar.enU.setVisibility(8);
                    aaVar.enW.setVisibility(0);
                    aaVar.enP.setVisibility(0);
                    String format = String.format(this.mContext.getString(r.j.is_floor), Integer.valueOf(qVar.bjO()));
                    aaVar.enO.setVisibility(0);
                    aaVar.enO.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) aaVar.eoa.getLayoutParams();
                    if (!this.enq) {
                        a(aaVar.enS, getDimensionPixelSize(r.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(r.e.ds74);
                    } else {
                        a(aaVar.enS, getDimensionPixelSize(r.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(r.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) aaVar.enX.getLayoutParams();
                    if (!this.enq) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(r.e.ds30);
                    }
                }
                if (this.ens != null && !this.ens.equals("0") && this.ens.equals(qVar.getAuthor().getUserId())) {
                    aaVar.enQ.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(aaVar.enQ, r.f.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.av.k(aaVar.enI, r.f.bg_floor_new_middle);
            aaVar.enS.setVideoImageId(r.f.pic_video);
            aaVar.enS.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10039));
            com.baidu.tbadk.core.util.av.c(aaVar.enR, r.f.btn_pb_reply_selector);
            aaVar.enS.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) aaVar.enR.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                aaVar.enR.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_load_sub_data, qVar);
            sparseArray.put(r.g.tag_load_sub_view, view);
            sparseArray.put(r.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(r.g.tag_pb_floor_number, Integer.valueOf(qVar.bjO()));
            if (qVar.bjS() > 0) {
                if (this.ent == null) {
                    this.ent = new av(this.mContext);
                    this.ent.setIsFromCDN(this.mIsFromCDN);
                    this.ent.H(this.env);
                    boolean z7 = false;
                    String userId2 = this.emS.aMs().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.ent.N(this.emS.aMz(), z7);
                    this.ent.b(this.emS.aMs());
                    this.ent.hR(this.enq);
                }
                this.ent.pz(qVar.getId());
                aaVar.enZ.setVisibility(0);
                aaVar.enY.setVisibility(0);
                aaVar.enX.setVisibility(0);
                aaVar.enZ.a(qVar, view);
                aaVar.enZ.setChildOnClickListener(this.bmo);
                aaVar.enZ.setChildOnLongClickListener(this.anY);
                aaVar.enZ.setChildOnTouchListener(this.emU);
                aaVar.enZ.setSubPbAdapter(this.ent);
                aaVar.enZ.setVisibility(0);
            } else {
                aaVar.enZ.setVisibility(8);
                aaVar.enY.setVisibility(8);
                aaVar.enX.setVisibility(8);
            }
            a(aaVar, qVar, this.emS.aMC(), i);
            if (!z) {
                String portrait = qVar.getAuthor().getPortrait();
                if (qVar.getAuthor() != null) {
                    String name_show = qVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.v.gD(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                    }
                    aaVar.aVU.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(aaVar.aVU, r.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(aaVar.aVU, r.d.cp_cont_f, 1);
                    }
                    int level_id = qVar.getAuthor().getLevel_id();
                    int is_bawu = qVar.getAuthor().getIs_bawu();
                    String bawu_type = qVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        aaVar.enL.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(aaVar.enL, BitmapHelper.getGradeResourceIdNew(level_id));
                        aaVar.enL.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                        aaVar.enL.setOnClickListener(null);
                    } else {
                        aaVar.enL.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(aaVar.enM, r.f.pb_manager);
                            aaVar.enL.setVisibility(8);
                            aaVar.enM.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(aaVar.enM, r.f.pb_assist);
                            aaVar.enL.setVisibility(8);
                            aaVar.enM.setVisibility(0);
                        }
                    }
                    if (qVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(aaVar.enN, r.f.icon_pb_pop_girl);
                        aaVar.enN.setVisibility(0);
                    } else if (qVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(aaVar.enN, r.f.icon_pb_pop_boy);
                        aaVar.enN.setVisibility(0);
                    } else {
                        aaVar.enN.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.v.gD(qVar.getAuthor().getName_show()) >= 14 && aaVar.enL.getVisibility() == 0 && aaVar.enQ.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.enu = qVar.getAuthor().getIconInfo();
                    this.ddj = qVar.getAuthor().getTShowInfoNew();
                    if (aaVar.cgq != null) {
                        aaVar.cgq.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                        aaVar.cgq.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.bUn);
                        aaVar.cgq.a(this.enu, i2, getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds10));
                    }
                    if (aaVar.ahw != null) {
                        aaVar.ahw.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewX);
                        aaVar.ahw.a(this.ddj, 3, getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds32), getDimensionPixelSize(r.e.ds8), true);
                    }
                }
                if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().pO())) {
                    aaVar.enK.setVisibility(4);
                    aaVar.enJ.setVisibility(0);
                    aaVar.enJ.dX(qVar.getAuthor().getPendantData().pO());
                    aaVar.enJ.getHeadView().c(portrait, 28, false);
                    aaVar.enJ.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                    aaVar.enJ.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
                } else {
                    aaVar.enK.setVisibility(0);
                    aaVar.enJ.setVisibility(8);
                    aaVar.enK.setUserId(qVar.getAuthor().getUserId());
                    aaVar.enK.setUserName(qVar.getAuthor().getUserName());
                    aaVar.enK.setImageDrawable(null);
                    aaVar.enK.c(portrait, 28, false);
                }
                aaVar.aVU.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                aaVar.aVU.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            }
            aaVar.enS.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.cp_link_tip_c));
            if (this.cIH) {
                aaVar.enS.setDefaultImageId(r.f.transparent_bg);
            } else {
                aaVar.enS.setDefaultImageId(r.f.icon_click);
            }
            aaVar.enS.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = qVar.aAI();
            }
            if (this.enw || !this.enx) {
                aaVar.enS.a(aVar, false);
            } else {
                aaVar.enS.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.emS.aMz() != 0) {
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
            if (this.emS != null && this.emS.aMs() != null && this.emS.aMs().getAuthor() != null && qVar.getAuthor() != null) {
                String userId4 = this.emS.aMs().getAuthor().getUserId();
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
                        if (aaVar.eoh != null) {
                            aaVar.eoh.setVisibility(0);
                            aaVar.eoh.setText(r.j.manage);
                            aaVar.eoh.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (aaVar.eoh != null) {
                            aaVar.eoh.setVisibility(0);
                            aaVar.eoh.setText(r.j.delete);
                            aaVar.eoh.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (aaVar.eoh != null) {
                        aaVar.eoh.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (qVar.bjO() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z8) {
                        sparseArray.put(r.g.tag_should_manage_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(this.emS.aMz()));
                        sparseArray.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(r.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(r.g.tag_user_mute_visible, true);
                        sparseArray.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.emS.aMs() != null) {
                            sparseArray.put(r.g.tag_user_mute_thread_id, this.emS.aMs().getId());
                        }
                        sparseArray.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(r.g.tag_should_delete_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(this.emS.aMz()));
                        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(r.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray.put(r.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        aaVar.enR.setVisibility(8);
                        com.baidu.tbadk.core.util.av.c(aaVar.eoe, r.d.common_color_10005, 1);
                        aaVar.eoe.setText(String.format(this.mContext.getResources().getString(r.j.write_addition_update), az.t(qVar.getTime())));
                        if (aaVar.eoh.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.av.c(aaVar.eoh, r.d.cp_link_tip_c, 3);
                            sparseArray.put(r.g.tag_user_mute_visible, false);
                            aaVar.eoh.setTag(sparseArray);
                            aaVar.eoh.setOnClickListener(this.env);
                        }
                    }
                    a(aaVar, qVar, qVar.bjO() != 1, aVar);
                    b(aaVar);
                    if (z) {
                        a(view, qVar);
                        if (this.enA != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.enA.bqZ();
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
            if (qVar.bjO() == 1) {
            }
            sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(aaVar, qVar, qVar.bjO() != 1, aVar);
            b(aaVar);
            if (z) {
            }
        }
    }

    private void b(aa aaVar) {
        aaVar.enS.setTextViewOnTouchListener(this.emU);
        aaVar.enS.setTextViewCheckSelection(false);
    }

    private void a(aa aaVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aRG() == null || c(qVar)) {
            aaVar.eos.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.u.a(qVar.aRG(), aaVar.eos, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.enz - (i - this.eny));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(aa aaVar, com.baidu.tieba.tbadkCore.data.q qVar, AdditionData additionData, int i) {
        if (qVar.bjT() > 0 && qVar.bjN() != null) {
            aaVar.eod.setVisibility(0);
            aaVar.eod.removeViews(0, aaVar.eod.getChildCount() - 1);
            int size = qVar.bjN().size();
            int bjU = qVar.bjU();
            for (int i2 = 0; i2 < bjU; i2++) {
                com.baidu.tieba.tbadkCore.data.q qVar2 = qVar.bjN().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, (ViewGroup) aaVar.eod, false);
                aa aaVar2 = new aa(inflate, this.enq, this.cIH, this.enp, true);
                c(aaVar2);
                a(aaVar2, qVar2, (View) aaVar.eod, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(r.g.tag_clip_board, qVar2);
                sparseArray.put(r.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(qVar2.getBimg_url()) || !this.cIH) {
                    sparseArray.put(r.g.tag_richtext_bg, null);
                    aaVar2.enS.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aaVar2.enS.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    aaVar2.enS.setLayoutParams(layoutParams);
                    aaVar2.enS.setPadding(0, 0, 0, 0);
                    aaVar.enS.gI(null);
                } else {
                    aaVar.enS.gI(qVar.getBimg_url());
                    aaVar2.enS.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aaVar2.enS.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(r.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(r.e.ds36);
                    aaVar2.enS.setLayoutParams(layoutParams2);
                }
                aaVar.eod.addView(inflate, aaVar.eod.getChildCount() - 1);
            }
            if (bjU < size) {
                aaVar.eoi.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(aaVar.eok, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.k(aaVar.eol, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.av.c(aaVar.eoj, r.d.cp_cont_f, 1);
                aaVar.eoi.setOnClickListener(new z(this, bjU, size, qVar));
                return;
            }
            aaVar.eoi.setVisibility(8);
            return;
        }
        aaVar.eod.setVisibility(8);
    }

    private boolean c(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (this.emS == null || this.emS.aMs() == null || !this.emS.aMs().sy() || this.emS.aMs().rE() == null || qVar.bjO() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.q qVar) {
        if (c(qVar) && view != null && this.eow != null) {
            if (this.enA == null) {
                this.enA = new com.baidu.tieba.vote.b(this.eow);
            }
            this.enA.a(view, this.emS);
        } else if (this.enA != null) {
            this.enA.setVisibility(8);
        }
    }

    private void c(aa aaVar) {
        aaVar.aVU.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewW);
        aaVar.enR.setOnClickListener(this.bmo);
        aaVar.enK.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewW);
        aaVar.enJ.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewW);
        aaVar.enW.setOnLongClickListener(this.anY);
        aaVar.enS.setOnLongClickListener(this.anY);
        aaVar.enW.setOnTouchListener(this.emU);
        aaVar.enS.setOnTouchListener(this.emU);
        aaVar.enS.setOnImageClickListener(this.aJh);
        aaVar.enS.setOnEmotionClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewY);
        aaVar.cgq.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.bUn);
        aaVar.ahw.setOnClickListener(((PbActivity) this.eow.getPageContext().getOrignalPage()).epf.ewX);
        aaVar.eos.setOnClickListener(this.bmo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.emS = hVar;
    }

    public void ok(int i) {
        this.enp = i;
    }

    public void hQ(boolean z) {
        this.cIH = z;
    }

    public void hR(boolean z) {
        this.enq = z;
    }

    public void hS(boolean z) {
        this.enr = z;
    }

    public void oZ(String str) {
        this.ens = str;
    }

    public void F(View.OnClickListener onClickListener) {
        this.env = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmo = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJh = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.emU = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anY = onLongClickListener;
    }
}
