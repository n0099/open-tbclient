package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cs;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends cs<com.baidu.tieba.tbadkCore.data.q, v> implements View.OnClickListener {
    private TbRichTextView.e aJq;
    private View.OnLongClickListener aou;
    private ArrayList<IconData> cNP;
    private View.OnClickListener cjr;
    private boolean ctc;
    private int dXB;
    private boolean dXC;
    private String dXD;
    private ba dXE;
    private ArrayList<IconData> dXF;
    private View.OnClickListener dXG;
    private boolean dXH;
    private final boolean dXI;
    private int dXJ;
    private int dXK;
    private com.baidu.tieba.vote.b dXL;
    private com.baidu.tieba.pb.data.f dXl;
    private com.baidu.tieba.pb.a.d dXp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dXB = 0;
        this.ctc = true;
        this.dXC = true;
        this.dXl = null;
        this.dXD = null;
        this.dXE = null;
        this.dXF = null;
        this.cNP = null;
        this.dXG = null;
        this.cjr = null;
        this.aJq = null;
        this.dXp = null;
        this.aou = null;
        this.dXH = false;
        this.dXI = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(v vVar) {
        if (vVar != null) {
            if (vVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                ar.c(vVar.dYk, r.d.common_color_10005, 1);
                ar.c(vVar.dYm, r.d.cp_link_tip_c, 3);
                ar.c(vVar.bbH, r.d.cp_cont_f, 1);
                ar.c((View) vVar.dXV, r.d.cp_cont_i, 1);
                ar.c((View) vVar.dXW, r.d.cp_cont_i, 1);
                ar.c(vVar.dXX, r.d.cp_cont_d, 1);
                ar.c(vVar.dXY, r.d.cp_cont_d, 1);
                ar.l(vVar.dYb, r.d.cp_bg_line_e);
                ar.l(vVar.dYc, r.d.cp_bg_line_e);
                ar.c(vVar.dYc, r.d.cp_bg_line_b);
                ar.l(vVar.dYf, r.d.cp_bg_line_c);
            }
            vVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.dXJ = getDimensionPixelSize(r.e.ds30);
        this.dXK = com.baidu.adp.lib.util.k.I(this.mContext) - getDimensionPixelSize(r.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public v a(ViewGroup viewGroup) {
        v vVar = new v(LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, viewGroup, false), this.ctc, this.dXB, false);
        a(vVar);
        return vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cs, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, v vVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) vVar);
        a(vVar);
        c(vVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aK(i);
        if (qVar2 != null) {
            qVar2.sB();
            a(vVar, qVar2, view, i);
        }
        if (!this.dXH && this.dXI && vVar != null && vVar.dYa.Il() && (listView = ((PbActivity) this.dYB.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dXH = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x08d3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0927  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(v vVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (vVar != null && qVar != null) {
            ar.l(vVar.dYi, r.d.cp_bg_line_b);
            vVar.dXU.setTag(null);
            vVar.dXU.setUserId(null);
            vVar.bbH.setText((CharSequence) null);
            vVar.dXW.setVisibility(8);
            vVar.dYf.setVisibility(0);
            vVar.dXZ.setVisibility(8);
            SparseArray sparseArray = (SparseArray) vVar.dYe.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                vVar.dYe.setTag(sparseArray);
                vVar.dYa.setTag(sparseArray);
            }
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_is_subpb, false);
            a(vVar.dYa, getDimensionPixelSize(r.e.ds30));
            if (TextUtils.isEmpty(qVar.getBimg_url()) || !this.ctc || d(qVar)) {
                sparseArray.put(r.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) vVar.dYa.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                vVar.dYa.setLayoutParams(layoutParams);
                vVar.dYa.setPadding(0, 0, 0, 0);
                vVar.dYa.gD(null);
            } else {
                sparseArray.put(r.g.tag_richtext_bg, qVar.getBimg_url());
                vVar.dYa.gD(qVar.getBimg_url());
                if (qVar.bga() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) vVar.dYa.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(r.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(r.e.ds40);
                    vVar.dYa.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) vVar.dYa.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(r.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(r.e.ds20);
                    vVar.dYa.setLayoutParams(layoutParams3);
                }
            }
            vVar.dXY.setText(av.s(qVar.getTime()));
            vVar.dYd.setVisibility(8);
            if (qVar.bga() == 1) {
                ar.l(vVar.dXQ, r.d.cp_bg_line_d);
                vVar.dXR.setVisibility(8);
                vVar.dYi.setVisibility(8);
                vVar.dYe.setVisibility(8);
                vVar.dXY.setVisibility(8);
                vVar.dYd.setVisibility(0);
                vVar.dYg.setVisibility(8);
                vVar.dYh.setVisibility(8);
                vVar.dYx.setVisibility(8);
                vVar.dYr.setVisibility(8);
                String str = null;
                long j = 0;
                if (qVar.getAuthor() != null) {
                    j = qVar.getAuthor().getUserIdLong();
                    str = qVar.getAuthor().getUserName();
                }
                vVar.dYd.a(qVar.bgh(), str, j, com.baidu.adp.lib.h.b.c(this.dXl.aIl().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                vVar.dYd.tm();
                if (this.dXC) {
                    PraiseData rv = this.dXl.aIl().rv();
                    if (rv != null && rv.getUser() != null && rv.getUser().size() > 0) {
                        vVar.dYb.setVisibility(0);
                        vVar.dYc.setVisibility(0);
                        vVar.dYb.setIsFromPb(true);
                        vVar.dYb.a(rv, this.dXl.aIl().getId(), rv.getPostId(), true);
                        vVar.dYb.m24do(this.mSkinType);
                    } else {
                        vVar.dYb.setVisibility(8);
                        vVar.dYc.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.d.ak(vVar.dYb);
                    com.baidu.tieba.graffiti.d.ak(vVar.dYc);
                } else {
                    vVar.dYb.setVisibility(8);
                    vVar.dYc.setVisibility(8);
                }
                a(vVar.dYa, getDimensionPixelSize(r.e.ds30));
            } else {
                vVar.dYi.setVisibility(0);
                ar.l(vVar.dXQ, r.d.cp_bg_line_e);
                vVar.dXR.setVisibility(0);
                com.baidu.tbadk.data.g bgd = qVar.bgd();
                vVar.dYr.setVisibility(8);
                if (bgd != null && !TextUtils.isEmpty(bgd.getName()) && !TextUtils.isEmpty(bgd.getName().trim())) {
                    String name = bgd.getName();
                    String lat = bgd.getLat();
                    String lng = bgd.getLng();
                    vVar.dYv.setText(bgd.getName());
                    ar.c(vVar.dYv, r.d.cp_cont_c, 1);
                    vVar.dYv.setOnClickListener(new u(this, lat, lng, name));
                } else {
                    vVar.dYv.setVisibility(8);
                }
                vVar.dYb.setVisibility(8);
                vVar.dYc.setVisibility(8);
                vVar.dYe.setVisibility(0);
                vVar.dXY.setVisibility(0);
                String format = String.format(this.mContext.getString(r.j.is_floor), Integer.valueOf(qVar.bga()));
                vVar.dXX.setVisibility(0);
                vVar.dXX.setText(format);
            }
            if (this.dXD != null && !this.dXD.equals("0") && this.dXD.equals(qVar.getAuthor().getUserId())) {
                vVar.dXZ.setVisibility(0);
                ar.j((View) vVar.dXZ, r.d.cp_link_tip_a);
            } else {
                vVar.dXZ.setVisibility(8);
            }
            ar.k(vVar.dXS, r.f.bg_floor_new_middle);
            vVar.dYa.setVideoImageId(r.f.pic_video);
            vVar.dYa.setTextColor(ar.getColor(r.d.common_color_10039));
            vVar.dYa.setLinkTextColor(ar.getColor(r.d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(r.g.tag_clip_board, qVar);
            sparseArray2.put(r.g.tag_load_sub_data, qVar);
            sparseArray2.put(r.g.tag_load_sub_view, view);
            sparseArray2.put(r.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(r.g.tag_pb_floor_number, Integer.valueOf(qVar.bga()));
            if (qVar.bge() > 0) {
                if (this.dXE == null) {
                    this.dXE = new ba(this.mContext);
                    this.dXE.setIsFromCDN(this.mIsFromCDN);
                    this.dXE.G(this.dXG);
                    boolean z6 = false;
                    String userId2 = this.dXl.aIl().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.dXE.B(this.dXl.aIu(), z6);
                    this.dXE.h(this.dXl.aIl());
                }
                this.dXE.on(qVar.getId());
                vVar.dYf.setVisibility(0);
                vVar.dYf.a(qVar, view);
                vVar.dYf.setChildOnClickListener(this.cjr);
                vVar.dYf.setChildOnLongClickListener(this.aou);
                vVar.dYf.setChildOnTouchListener(this.dXp);
                vVar.dYf.setSubPbAdapter(this.dXE);
                vVar.dYf.setVisibility(0);
                vVar.dYh.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds24));
                vVar.dYx.setVisibility(0);
            } else {
                vVar.dYh.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40));
                vVar.dYf.setVisibility(8);
                vVar.dYx.setVisibility(8);
            }
            String portrait = qVar.getAuthor().getPortrait();
            if (qVar.getAuthor() != null) {
                String name_show = qVar.getAuthor().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(qVar.getAuthor().getSealPrefix())) {
                    i2 = com.baidu.tbadk.util.u.gy(qVar.getAuthor().getSealPrefix()) + 2;
                }
                int gy = com.baidu.tbadk.util.u.gy(name_show);
                if (i2 > 0) {
                    if (gy > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                    }
                } else if (gy > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (i2 > 0) {
                    vVar.bbH.setText(ag(qVar.getAuthor().getSealPrefix(), name_show));
                } else {
                    vVar.bbH.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    ar.c(vVar.bbH, r.d.cp_cont_h, 1);
                } else {
                    ar.c(vVar.bbH, r.d.cp_cont_f, 1);
                }
                int level_id = qVar.getAuthor().getLevel_id();
                int is_bawu = qVar.getAuthor().getIs_bawu();
                String bawu_type = qVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    vVar.dXV.setVisibility(0);
                    ar.c(vVar.dXV, BitmapHelper.getGradeResourceIdNew(level_id));
                    vVar.dXV.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                    vVar.dXV.setOnClickListener(null);
                } else {
                    vVar.dXV.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ar.c(vVar.dXW, r.f.pb_manager);
                        vVar.dXV.setVisibility(8);
                        vVar.dXW.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        ar.c(vVar.dXW, r.f.pb_assist);
                        vVar.dXV.setVisibility(8);
                        vVar.dXW.setVisibility(0);
                    }
                }
                int gy2 = com.baidu.tbadk.util.u.gy(qVar.getAuthor().getName_show());
                if (gy2 >= 14 && vVar.dXV.getVisibility() == 0 && vVar.dXZ.getVisibility() == 0) {
                    i3 = 2;
                }
                int i4 = (StringUtils.isNull(qVar.getAuthor().getSealPrefix()) || gy2 < 12 || vVar.dXV.getVisibility() != 0 || vVar.dXZ.getVisibility() != 0) ? i3 : i3 - 1;
                this.dXF = qVar.getAuthor().getIconInfo();
                this.cNP = qVar.getAuthor().getTShowInfoNew();
                if (vVar.bQG != null) {
                    vVar.bQG.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                    vVar.bQG.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.bJq);
                    vVar.bQG.a(this.dXF, i4, getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds10));
                }
                if (vVar.ahx != null) {
                    vVar.ahx.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehq);
                    vVar.ahx.a(this.cNP, 3, getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds32), getDimensionPixelSize(r.e.ds8), true);
                }
            }
            if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().pS())) {
                vVar.dXU.setVisibility(4);
                vVar.dXT.setVisibility(0);
                vVar.dXT.dW(qVar.getAuthor().getPendantData().pS());
                vVar.dXT.getHeadView().c(portrait, 28, false);
                vVar.dXT.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                vVar.dXT.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            } else {
                vVar.dXU.setVisibility(0);
                vVar.dXT.setVisibility(8);
                vVar.dXU.setUserId(qVar.getAuthor().getUserId());
                vVar.dXU.setUserName(qVar.getAuthor().getUserName());
                vVar.dXU.setImageDrawable(null);
                vVar.dXU.c(portrait, 28, false);
            }
            vVar.bbH.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
            vVar.bbH.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            vVar.dYa.setLinkTextColor(ar.getColor(r.d.cp_link_tip_c));
            if (this.ctc) {
                vVar.dYa.setDefaultImageId(r.f.transparent_bg);
            } else {
                vVar.dYa.setDefaultImageId(r.f.icon_click);
            }
            vVar.dYa.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = qVar.avP();
            }
            if (this.dXH || !this.dXI) {
                vVar.dYa.a(aVar, false);
            } else {
                vVar.dYa.a(aVar, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.dXl.aIu() != 0) {
                z7 = true;
                z8 = true;
                String userId3 = qVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z7 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z7 = false;
                }
            }
            if (this.dXl != null && this.dXl.aIl() != null && this.dXl.aIl().getAuthor() != null && qVar.getAuthor() != null) {
                String userId4 = this.dXl.aIl().getAuthor().getUserId();
                String userId5 = qVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = qVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        z4 = z2;
                        z5 = z3;
                    }
                    if (!z7) {
                        if (vVar.dYm != null) {
                            vVar.dYm.setVisibility(0);
                            vVar.dYm.setText(r.j.manage);
                            vVar.dYm.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (vVar.dYm != null) {
                            vVar.dYm.setVisibility(0);
                            vVar.dYm.setText(r.j.delete);
                            vVar.dYm.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (vVar.dYm != null) {
                        vVar.dYm.setVisibility(8);
                    }
                    int i5 = 1;
                    if (qVar.bga() == 1) {
                        i5 = 0;
                    }
                    sparseArray2.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z7) {
                        sparseArray2.put(r.g.tag_should_manage_visible, true);
                        sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.dXl.aIu()));
                        sparseArray2.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray2.put(r.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(r.g.tag_user_mute_visible, true);
                        sparseArray2.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray2.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray2.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.dXl.aIl() != null) {
                            sparseArray2.put(r.g.tag_user_mute_thread_id, this.dXl.aIl().getId());
                        }
                        sparseArray2.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray2.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(r.g.tag_should_delete_visible, true);
                        sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.dXl.aIu()));
                        sparseArray2.put(r.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(r.g.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray2.put(r.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray2.put(r.g.tag_should_delete_visible, false);
                    }
                    a(vVar, qVar, qVar.bga() != 1, aVar);
                    b(vVar);
                    a(view, qVar);
                    if (this.dXL == null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                        this.dXL.bks();
                        return;
                    }
                    return;
                }
            }
            z = false;
            z2 = z8;
            z3 = false;
            userId = qVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z4 = z2;
            z5 = z3;
            if (!z7) {
            }
            int i52 = 1;
            if (qVar.bga() == 1) {
            }
            sparseArray2.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(vVar, qVar, qVar.bga() != 1, aVar);
            b(vVar);
            a(view, qVar);
            if (this.dXL == null) {
            }
        }
    }

    private void b(v vVar) {
        vVar.dYa.setTextViewOnTouchListener(this.dXp);
        vVar.dYa.setTextViewCheckSelection(false);
    }

    private void a(v vVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aNF() == null || d(qVar)) {
            vVar.dYw.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(qVar.aNF(), vVar.dYw, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dXK - (i - this.dXJ));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean d(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (this.dXl == null || this.dXl.aIl() == null || !this.dXl.aIl().sp() || this.dXl.aIl().ru() == null || qVar.bga() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.q qVar) {
        if (d(qVar) && view != null && this.dYB != null) {
            if (this.dXL == null) {
                this.dXL = new com.baidu.tieba.vote.b(this.dYB);
            }
            this.dXL.a(view, this.dXl);
        } else if (this.dXL != null) {
            this.dXL.setVisibility(8);
        }
    }

    private void c(v vVar) {
        vVar.bbH.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehp);
        vVar.dXU.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehp);
        vVar.dXT.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehp);
        vVar.dYe.setOnLongClickListener(this.aou);
        vVar.dYa.setOnLongClickListener(this.aou);
        vVar.dYe.setOnTouchListener(this.dXp);
        vVar.dYa.setOnTouchListener(this.dXp);
        vVar.dYa.setOnImageClickListener(this.aJq);
        vVar.dYa.setOnEmotionClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehr);
        vVar.bQG.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.bJq);
        vVar.ahx.setOnClickListener(((PbActivity) this.dYB.getPageContext().getOrignalPage()).dZl.ehq);
        vVar.dYw.setOnClickListener(this.cjr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.dXl = fVar;
    }

    public void nw(int i) {
        this.dXB = i;
    }

    public void hX(boolean z) {
        this.ctc = z;
    }

    public void hY(boolean z) {
        this.dXC = z;
    }

    public void nN(String str) {
        this.dXD = str;
    }

    public void F(View.OnClickListener onClickListener) {
        this.dXG = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cjr = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJq = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dXp = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aou = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str));
            return ap.a((Context) this.dYB.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
