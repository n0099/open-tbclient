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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ct;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends ct<com.baidu.tieba.tbadkCore.data.q, w> implements View.OnClickListener {
    private TbRichTextView.e aJZ;
    private View.OnLongClickListener aoS;
    private View.OnClickListener bpk;
    private boolean cNW;
    private ArrayList<IconData> diU;
    private com.baidu.tieba.pb.data.h esP;
    private com.baidu.tieba.pb.a.d esT;
    private int etg;
    private boolean eth;
    private String eti;
    private ba etj;
    private ArrayList<IconData> etk;
    private View.OnClickListener etl;
    private boolean etm;
    private final boolean etn;
    private int eto;
    private int etp;
    private com.baidu.tieba.vote.b etq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.etg = 0;
        this.cNW = true;
        this.eth = true;
        this.esP = null;
        this.eti = null;
        this.etj = null;
        this.etk = null;
        this.diU = null;
        this.etl = null;
        this.bpk = null;
        this.aJZ = null;
        this.esT = null;
        this.aoS = null;
        this.etm = false;
        this.etn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(w wVar) {
        if (wVar != null) {
            if (wVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                at.c(wVar.etP, r.d.common_color_10005, 1);
                at.c(wVar.etR, r.d.cp_link_tip_c, 3);
                at.c(wVar.aYg, r.d.cp_cont_f, 1);
                at.c((View) wVar.etA, r.d.cp_cont_i, 1);
                at.c((View) wVar.etB, r.d.cp_cont_i, 1);
                at.c(wVar.etC, r.d.cp_cont_d, 1);
                at.c(wVar.etD, r.d.cp_cont_d, 1);
                at.l(wVar.etG, r.d.cp_bg_line_e);
                at.l(wVar.etH, r.d.cp_bg_line_e);
                at.c(wVar.etH, r.d.cp_bg_line_b);
                at.l(wVar.etK, r.d.cp_bg_line_c);
            }
            wVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.eto = getDimensionPixelSize(r.e.ds30);
        this.etp = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(r.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public w a(ViewGroup viewGroup) {
        w wVar = new w(LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, viewGroup, false), this.cNW, this.etg, false);
        a(wVar);
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ct, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, w wVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) wVar);
        a(wVar);
        c(wVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aJ(i);
        if (qVar2 != null) {
            qVar2.sN();
            a(wVar, qVar2, view, i);
        }
        if (!this.etm && this.etn && wVar != null && wVar.etF.IQ() && (listView = ((PbActivity) this.eug.getPageContext().getOrignalPage()).getListView()) != null) {
            this.etm = true;
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
    private void a(w wVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (wVar != null && qVar != null) {
            at.l(wVar.etN, r.d.cp_bg_line_b);
            wVar.etz.setTag(null);
            wVar.etz.setUserId(null);
            wVar.aYg.setText((CharSequence) null);
            wVar.etB.setVisibility(8);
            wVar.etK.setVisibility(0);
            wVar.etE.setVisibility(8);
            SparseArray sparseArray = (SparseArray) wVar.etJ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                wVar.etJ.setTag(sparseArray);
                wVar.etF.setTag(sparseArray);
            }
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_is_subpb, false);
            a(wVar.etF, getDimensionPixelSize(r.e.ds30));
            if (TextUtils.isEmpty(qVar.getBimg_url()) || !this.cNW || d(qVar)) {
                sparseArray.put(r.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) wVar.etF.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                wVar.etF.setLayoutParams(layoutParams);
                wVar.etF.setPadding(0, 0, 0, 0);
                wVar.etF.gI(null);
            } else {
                sparseArray.put(r.g.tag_richtext_bg, qVar.getBimg_url());
                wVar.etF.gI(qVar.getBimg_url());
                if (qVar.bml() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) wVar.etF.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(r.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(r.e.ds40);
                    wVar.etF.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) wVar.etF.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(r.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(r.e.ds20);
                    wVar.etF.setLayoutParams(layoutParams3);
                }
            }
            wVar.etD.setText(ax.s(qVar.getTime()));
            wVar.etI.setVisibility(8);
            if (qVar.bml() == 1) {
                at.l(wVar.etv, r.d.cp_bg_line_d);
                wVar.etw.setVisibility(8);
                wVar.etN.setVisibility(8);
                wVar.etJ.setVisibility(8);
                wVar.etD.setVisibility(8);
                wVar.etI.setVisibility(0);
                wVar.etL.setVisibility(8);
                wVar.etM.setVisibility(8);
                wVar.euc.setVisibility(8);
                wVar.etW.setVisibility(8);
                String str = null;
                long j = 0;
                if (qVar.getAuthor() != null) {
                    j = qVar.getAuthor().getUserIdLong();
                    str = qVar.getAuthor().getUserName();
                }
                wVar.etI.a(qVar.bms(), str, j, com.baidu.adp.lib.h.b.c(this.esP.aOl().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                wVar.etI.tB();
                if (this.eth) {
                    PraiseData rH = this.esP.aOl().rH();
                    if (rH != null && rH.getUser() != null && rH.getUser().size() > 0) {
                        wVar.etG.setVisibility(0);
                        wVar.etH.setVisibility(0);
                        wVar.etG.setIsFromPb(true);
                        wVar.etG.a(rH, this.esP.aOl().getId(), rH.getPostId(), true);
                        wVar.etG.dm(this.mSkinType);
                    } else {
                        wVar.etG.setVisibility(8);
                        wVar.etH.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.d.ak(wVar.etG);
                    com.baidu.tieba.graffiti.d.ak(wVar.etH);
                } else {
                    wVar.etG.setVisibility(8);
                    wVar.etH.setVisibility(8);
                }
                a(wVar.etF, getDimensionPixelSize(r.e.ds30));
            } else {
                wVar.etN.setVisibility(0);
                at.l(wVar.etv, r.d.cp_bg_line_e);
                wVar.etw.setVisibility(0);
                com.baidu.tbadk.data.g bmo = qVar.bmo();
                wVar.etW.setVisibility(8);
                if (bmo != null && !TextUtils.isEmpty(bmo.getName()) && !TextUtils.isEmpty(bmo.getName().trim())) {
                    String name = bmo.getName();
                    String lat = bmo.getLat();
                    String lng = bmo.getLng();
                    wVar.eua.setText(bmo.getName());
                    at.c(wVar.eua, r.d.cp_cont_c, 1);
                    wVar.eua.setOnClickListener(new v(this, lat, lng, name));
                } else {
                    wVar.eua.setVisibility(8);
                }
                wVar.etG.setVisibility(8);
                wVar.etH.setVisibility(8);
                wVar.etJ.setVisibility(0);
                wVar.etD.setVisibility(0);
                String format = String.format(this.mContext.getString(r.j.is_floor), Integer.valueOf(qVar.bml()));
                wVar.etC.setVisibility(0);
                wVar.etC.setText(format);
            }
            if (this.eti != null && !this.eti.equals("0") && this.eti.equals(qVar.getAuthor().getUserId())) {
                wVar.etE.setVisibility(0);
                at.j((View) wVar.etE, r.d.cp_link_tip_a);
            } else {
                wVar.etE.setVisibility(8);
            }
            at.k(wVar.etx, r.f.bg_floor_new_middle);
            wVar.etF.setVideoImageId(r.f.pic_video);
            wVar.etF.setTextColor(at.getColor(r.d.common_color_10039));
            wVar.etF.setLinkTextColor(at.getColor(r.d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(r.g.tag_clip_board, qVar);
            sparseArray2.put(r.g.tag_load_sub_data, qVar);
            sparseArray2.put(r.g.tag_load_sub_view, view);
            sparseArray2.put(r.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(r.g.tag_pb_floor_number, Integer.valueOf(qVar.bml()));
            if (qVar.bmp() > 0) {
                if (this.etj == null) {
                    this.etj = new ba(this.mContext);
                    this.etj.setIsFromCDN(this.mIsFromCDN);
                    this.etj.J(this.etl);
                    boolean z6 = false;
                    String userId2 = this.esP.aOl().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.etj.P(this.esP.aOt(), z6);
                    this.etj.c(this.esP.aOl());
                }
                this.etj.pM(qVar.getId());
                wVar.etK.setVisibility(0);
                wVar.etK.a(qVar, view);
                wVar.etK.setChildOnClickListener(this.bpk);
                wVar.etK.setChildOnLongClickListener(this.aoS);
                wVar.etK.setChildOnTouchListener(this.esT);
                wVar.etK.setSubPbAdapter(this.etj);
                wVar.etK.setVisibility(0);
                wVar.etM.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds24));
                wVar.euc.setVisibility(0);
            } else {
                wVar.etM.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds40));
                wVar.etK.setVisibility(8);
                wVar.euc.setVisibility(8);
            }
            String portrait = qVar.getAuthor().getPortrait();
            if (qVar.getAuthor() != null) {
                String name_show = qVar.getAuthor().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(qVar.getAuthor().getSealPrefix())) {
                    i2 = com.baidu.tbadk.util.u.gD(qVar.getAuthor().getSealPrefix()) + 2;
                }
                int gD = com.baidu.tbadk.util.u.gD(name_show);
                if (i2 > 0) {
                    if (gD > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                    }
                } else if (gD > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (i2 > 0) {
                    wVar.aYg.setText(ag(qVar.getAuthor().getSealPrefix(), name_show));
                } else {
                    wVar.aYg.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    at.c(wVar.aYg, r.d.cp_cont_h, 1);
                } else {
                    at.c(wVar.aYg, r.d.cp_cont_f, 1);
                }
                int level_id = qVar.getAuthor().getLevel_id();
                int is_bawu = qVar.getAuthor().getIs_bawu();
                String bawu_type = qVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    wVar.etA.setVisibility(0);
                    at.c(wVar.etA, BitmapHelper.getGradeResourceIdNew(level_id));
                    wVar.etA.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                    wVar.etA.setOnClickListener(null);
                } else {
                    wVar.etA.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        at.c(wVar.etB, r.f.pb_manager);
                        wVar.etA.setVisibility(8);
                        wVar.etB.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        at.c(wVar.etB, r.f.pb_assist);
                        wVar.etA.setVisibility(8);
                        wVar.etB.setVisibility(0);
                    }
                }
                int gD2 = com.baidu.tbadk.util.u.gD(qVar.getAuthor().getName_show());
                if (gD2 >= 14 && wVar.etA.getVisibility() == 0 && wVar.etE.getVisibility() == 0) {
                    i3 = 2;
                }
                int i4 = (StringUtils.isNull(qVar.getAuthor().getSealPrefix()) || gD2 < 12 || wVar.etA.getVisibility() != 0 || wVar.etE.getVisibility() != 0) ? i3 : i3 - 1;
                this.etk = qVar.getAuthor().getIconInfo();
                this.diU = qVar.getAuthor().getTShowInfoNew();
                if (wVar.clv != null) {
                    wVar.clv.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                    wVar.clv.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.bXu);
                    wVar.clv.a(this.etk, i4, getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds30), getDimensionPixelSize(r.e.ds10));
                }
                if (wVar.ahW != null) {
                    wVar.ahW.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDk);
                    wVar.ahW.a(this.diU, 3, getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds32), getDimensionPixelSize(r.e.ds8), true);
                }
            }
            if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().pR())) {
                wVar.etz.setVisibility(4);
                wVar.ety.setVisibility(0);
                wVar.ety.dZ(qVar.getAuthor().getPendantData().pR());
                wVar.ety.getHeadView().c(portrait, 28, false);
                wVar.ety.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                wVar.ety.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            } else {
                wVar.etz.setVisibility(0);
                wVar.ety.setVisibility(8);
                wVar.etz.setUserId(qVar.getAuthor().getUserId());
                wVar.etz.setUserName(qVar.getAuthor().getUserName());
                wVar.etz.setImageDrawable(null);
                wVar.etz.c(portrait, 28, false);
            }
            wVar.aYg.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
            wVar.aYg.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            wVar.etF.setLinkTextColor(at.getColor(r.d.cp_link_tip_c));
            if (this.cNW) {
                wVar.etF.setDefaultImageId(r.f.transparent_bg);
            } else {
                wVar.etF.setDefaultImageId(r.f.icon_click);
            }
            wVar.etF.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = qVar.aCE();
            }
            if (this.etm || !this.etn) {
                wVar.etF.a(aVar, false);
            } else {
                wVar.etF.a(aVar, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.esP.aOt() != 0) {
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
            if (this.esP != null && this.esP.aOl() != null && this.esP.aOl().getAuthor() != null && qVar.getAuthor() != null) {
                String userId4 = this.esP.aOl().getAuthor().getUserId();
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
                        if (wVar.etR != null) {
                            wVar.etR.setVisibility(0);
                            wVar.etR.setText(r.j.manage);
                            wVar.etR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (wVar.etR != null) {
                            wVar.etR.setVisibility(0);
                            wVar.etR.setText(r.j.delete);
                            wVar.etR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (wVar.etR != null) {
                        wVar.etR.setVisibility(8);
                    }
                    int i5 = 1;
                    if (qVar.bml() == 1) {
                        i5 = 0;
                    }
                    sparseArray2.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z7) {
                        sparseArray2.put(r.g.tag_should_manage_visible, true);
                        sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.esP.aOt()));
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
                        if (this.esP.aOl() != null) {
                            sparseArray2.put(r.g.tag_user_mute_thread_id, this.esP.aOl().getId());
                        }
                        sparseArray2.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray2.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(r.g.tag_should_delete_visible, true);
                        sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.esP.aOt()));
                        sparseArray2.put(r.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(r.g.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray2.put(r.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray2.put(r.g.tag_should_delete_visible, false);
                    }
                    a(wVar, qVar, qVar.bml() != 1, aVar);
                    b(wVar);
                    a(view, qVar);
                    if (this.etq == null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                        this.etq.bts();
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
            if (qVar.bml() == 1) {
            }
            sparseArray2.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(wVar, qVar, qVar.bml() != 1, aVar);
            b(wVar);
            a(view, qVar);
            if (this.etq == null) {
            }
        }
    }

    private void b(w wVar) {
        wVar.etF.setTextViewOnTouchListener(this.esT);
        wVar.etF.setTextViewCheckSelection(false);
    }

    private void a(w wVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aTO() == null || d(qVar)) {
            wVar.eub.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.s.a(qVar.aTO(), wVar.eub, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.etp - (i - this.eto));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean d(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (this.esP == null || this.esP.aOl() == null || !this.esP.aOl().sA() || this.esP.aOl().rG() == null || qVar.bml() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.q qVar) {
        if (d(qVar) && view != null && this.eug != null) {
            if (this.etq == null) {
                this.etq = new com.baidu.tieba.vote.b(this.eug);
            }
            this.etq.a(view, this.esP);
        } else if (this.etq != null) {
            this.etq.setVisibility(8);
        }
    }

    private void c(w wVar) {
        wVar.aYg.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDj);
        wVar.etz.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDj);
        wVar.ety.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDj);
        wVar.etJ.setOnLongClickListener(this.aoS);
        wVar.etF.setOnLongClickListener(this.aoS);
        wVar.etJ.setOnTouchListener(this.esT);
        wVar.etF.setOnTouchListener(this.esT);
        wVar.etF.setOnImageClickListener(this.aJZ);
        wVar.etF.setOnEmotionClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDl);
        wVar.clv.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.bXu);
        wVar.ahW.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDk);
        wVar.eub.setOnClickListener(this.bpk);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.esP = hVar;
    }

    public void ou(int i) {
        this.etg = i;
    }

    public void ij(boolean z) {
        this.cNW = z;
    }

    public void ik(boolean z) {
        this.eth = z;
    }

    public void pm(String str) {
        this.eti = str;
    }

    public void I(View.OnClickListener onClickListener) {
        this.etl = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bpk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJZ = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.esT = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoS = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new an.a(str));
            return an.a((Context) this.eug.getActivity(), str2, (ArrayList<an.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
