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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends da<p, f> implements View.OnClickListener {
    private TbRichTextView.e aHX;
    private View.OnLongClickListener anA;
    private boolean cAg;
    private ArrayList<IconData> cUY;
    private View.OnClickListener cpK;
    private int egh;
    private boolean egi;
    private com.baidu.tieba.pb.data.f egj;
    private ba egk;
    private ArrayList<IconData> egl;
    private View.OnClickListener egm;
    private com.baidu.tieba.pb.a.d egn;
    private boolean ego;
    private final boolean egp;
    private int egq;
    private int egr;
    private com.baidu.tieba.vote.a egs;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.egh = 0;
        this.cAg = true;
        this.egi = true;
        this.egj = null;
        this.mHostId = null;
        this.egk = null;
        this.egl = null;
        this.cUY = null;
        this.egm = null;
        this.cpK = null;
        this.aHX = null;
        this.egn = null;
        this.anA = null;
        this.ego = false;
        this.egp = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                ap.c(fVar.egR, r.e.common_color_10005, 1);
                ap.c(fVar.egT, r.e.cp_link_tip_c, 3);
                ap.c(fVar.blu, r.e.cp_cont_f, 1);
                ap.c((View) fVar.egC, r.e.cp_cont_i, 1);
                ap.c((View) fVar.egD, r.e.cp_cont_i, 1);
                ap.c(fVar.egE, r.e.cp_cont_d, 1);
                ap.c(fVar.egF, r.e.cp_cont_d, 1);
                ap.k(fVar.egI, r.e.cp_bg_line_e);
                ap.k(fVar.egJ, r.e.cp_bg_line_e);
                ap.c(fVar.egJ, r.e.cp_bg_line_b);
                ap.k(fVar.egM, r.e.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.egq = getDimensionPixelSize(r.f.ds30);
        this.egr = k.I(this.mContext) - getDimensionPixelSize(r.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(r.j.new_pb_list_item, viewGroup, false), this.cAg, this.egh, false);
        a(fVar);
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.da, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, p pVar, f fVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, pVar, fVar);
        a(fVar);
        c(fVar);
        p pVar2 = (p) getItem(i);
        if (pVar2 != null) {
            pVar2.st();
            a(fVar, pVar2, view, i);
        }
        if (!this.ego && this.egp && fVar != null && fVar.egH.Ic() && (listView = ((PbActivity) this.ehi.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ego = true;
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
    private void a(f fVar, p pVar, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (fVar != null && pVar != null) {
            ap.k(fVar.egP, r.e.cp_bg_line_b);
            fVar.egB.setTag(null);
            fVar.egB.setUserId(null);
            fVar.blu.setText((CharSequence) null);
            fVar.egD.setVisibility(8);
            fVar.egM.setVisibility(0);
            fVar.egG.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.egL.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.egL.setTag(sparseArray);
                fVar.egH.setTag(sparseArray);
            }
            sparseArray.put(r.h.tag_clip_board, pVar);
            sparseArray.put(r.h.tag_is_subpb, false);
            a(fVar.egH, getDimensionPixelSize(r.f.ds30));
            if (TextUtils.isEmpty(pVar.getBimg_url()) || !this.cAg || c(pVar)) {
                sparseArray.put(r.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.egH.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.egH.setLayoutParams(layoutParams);
                fVar.egH.setPadding(0, 0, 0, 0);
                fVar.egH.gA(null);
            } else {
                sparseArray.put(r.h.tag_richtext_bg, pVar.getBimg_url());
                fVar.egH.gA(pVar.getBimg_url());
                if (pVar.bhQ() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.egH.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(r.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(r.f.ds40);
                    fVar.egH.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.egH.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(r.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(r.f.ds20);
                    fVar.egH.setLayoutParams(layoutParams3);
                }
            }
            fVar.egF.setText(at.r(pVar.getTime()));
            fVar.egK.setVisibility(8);
            if (pVar.bhQ() == 1) {
                ap.k(fVar.egx, r.e.cp_bg_line_d);
                fVar.egy.setVisibility(8);
                fVar.egP.setVisibility(8);
                fVar.egL.setVisibility(8);
                fVar.egF.setVisibility(8);
                fVar.egK.setVisibility(0);
                fVar.egN.setVisibility(8);
                fVar.egO.setVisibility(8);
                fVar.ehe.setVisibility(8);
                fVar.egY.setVisibility(8);
                String str = null;
                long j = 0;
                if (pVar.getAuthor() != null) {
                    j = pVar.getAuthor().getUserIdLong();
                    str = pVar.getAuthor().getUserName();
                }
                fVar.egK.a(pVar.bhX(), str, j, com.baidu.adp.lib.g.b.c(this.egj.aJZ().getId(), 0L), com.baidu.adp.lib.g.b.c(pVar.getId(), 0L));
                fVar.egK.tg();
                if (this.egi) {
                    PraiseData rn = this.egj.aJZ().rn();
                    if (rn != null && rn.getUser() != null && rn.getUser().size() > 0) {
                        fVar.egI.setVisibility(0);
                        fVar.egJ.setVisibility(0);
                        fVar.egI.setIsFromPb(true);
                        fVar.egI.a(rn, this.egj.aJZ().getId(), rn.getPostId(), true);
                        fVar.egI.dp(this.mSkinType);
                    } else {
                        fVar.egI.setVisibility(8);
                        fVar.egJ.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.ap(fVar.egI);
                    com.baidu.tieba.graffiti.c.ap(fVar.egJ);
                } else {
                    fVar.egI.setVisibility(8);
                    fVar.egJ.setVisibility(8);
                }
                a(fVar.egH, getDimensionPixelSize(r.f.ds30));
            } else {
                fVar.egP.setVisibility(0);
                ap.k(fVar.egx, r.e.cp_bg_line_e);
                fVar.egy.setVisibility(0);
                g bhT = pVar.bhT();
                fVar.egY.setVisibility(8);
                if (bhT != null && !TextUtils.isEmpty(bhT.getName()) && !TextUtils.isEmpty(bhT.getName().trim())) {
                    String name = bhT.getName();
                    String lat = bhT.getLat();
                    String lng = bhT.getLng();
                    fVar.ehc.setText(bhT.getName());
                    ap.c(fVar.ehc, r.e.cp_cont_c, 1);
                    fVar.ehc.setOnClickListener(new e(this, lat, lng, name));
                } else {
                    fVar.ehc.setVisibility(8);
                }
                fVar.egI.setVisibility(8);
                fVar.egJ.setVisibility(8);
                fVar.egL.setVisibility(0);
                fVar.egF.setVisibility(0);
                String format = String.format(this.mContext.getString(r.l.is_floor), Integer.valueOf(pVar.bhQ()));
                fVar.egE.setVisibility(0);
                fVar.egE.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(pVar.getAuthor().getUserId())) {
                fVar.egG.setVisibility(0);
                ap.i((View) fVar.egG, r.e.cp_link_tip_a);
            } else {
                fVar.egG.setVisibility(8);
            }
            ap.j(fVar.egz, r.g.bg_floor_new_middle);
            fVar.egH.setVideoImageId(r.g.pic_video);
            fVar.egH.setTextColor(ap.getColor(r.e.common_color_10039));
            fVar.egH.setLinkTextColor(ap.getColor(r.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(r.h.tag_clip_board, pVar);
            sparseArray2.put(r.h.tag_load_sub_data, pVar);
            sparseArray2.put(r.h.tag_load_sub_view, view);
            sparseArray2.put(r.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(r.h.tag_pb_floor_number, Integer.valueOf(pVar.bhQ()));
            if (pVar.bhU() > 0) {
                if (this.egk == null) {
                    this.egk = new ba(this.mContext);
                    this.egk.setIsFromCDN(this.mIsFromCDN);
                    this.egk.J(this.egm);
                    boolean z6 = false;
                    String userId2 = this.egj.aJZ().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.egk.B(this.egj.aKj(), z6);
                    this.egk.h(this.egj.aJZ());
                }
                this.egk.oD(pVar.getId());
                fVar.egM.setVisibility(0);
                fVar.egM.a(pVar, view);
                fVar.egM.setChildOnClickListener(this.cpK);
                fVar.egM.setChildOnLongClickListener(this.anA);
                fVar.egM.setChildOnTouchListener(this.egn);
                fVar.egM.setSubPbAdapter(this.egk);
                fVar.egM.setVisibility(0);
                fVar.egO.setPadding(0, 0, 0, k.e(this.mContext, r.f.ds24));
                fVar.ehe.setVisibility(0);
            } else {
                fVar.egO.setPadding(0, 0, 0, k.e(this.mContext, r.f.ds40));
                fVar.egM.setVisibility(8);
                fVar.ehe.setVisibility(8);
            }
            String portrait = pVar.getAuthor().getPortrait();
            if (pVar.getAuthor() != null) {
                String name_show = pVar.getAuthor().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(pVar.getAuthor().getSealPrefix())) {
                    i2 = u.gv(pVar.getAuthor().getSealPrefix()) + 2;
                }
                int gv = u.gv(name_show);
                if (i2 > 0) {
                    if (gv > 12) {
                        name_show = String.valueOf(u.d(name_show, 0, 14)) + "...";
                    }
                } else if (gv > 14) {
                    name_show = String.valueOf(u.d(name_show, 0, 14)) + "...";
                }
                if (i2 > 0) {
                    fVar.blu.setText(ag(pVar.getAuthor().getSealPrefix(), name_show));
                } else {
                    fVar.blu.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = pVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    ap.c(fVar.blu, r.e.cp_cont_h, 1);
                } else {
                    ap.c(fVar.blu, r.e.cp_cont_f, 1);
                }
                int level_id = pVar.getAuthor().getLevel_id();
                int is_bawu = pVar.getAuthor().getIs_bawu();
                String bawu_type = pVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    fVar.egC.setVisibility(0);
                    ap.c(fVar.egC, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.egC.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.l.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.egC.setOnClickListener(null);
                } else {
                    fVar.egC.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ap.c(fVar.egD, r.g.pb_manager);
                        fVar.egC.setVisibility(8);
                        fVar.egD.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        ap.c(fVar.egD, r.g.pb_assist);
                        fVar.egC.setVisibility(8);
                        fVar.egD.setVisibility(0);
                    }
                }
                int gv2 = u.gv(pVar.getAuthor().getName_show());
                if (gv2 >= 14 && fVar.egC.getVisibility() == 0 && fVar.egG.getVisibility() == 0) {
                    i3 = 2;
                }
                int i4 = (StringUtils.isNull(pVar.getAuthor().getSealPrefix()) || gv2 < 12 || fVar.egC.getVisibility() != 0 || fVar.egG.getVisibility() != 0) ? i3 : i3 - 1;
                this.egl = pVar.getAuthor().getIconInfo();
                this.cUY = pVar.getAuthor().getTShowInfoNew();
                if (fVar.bXk != null) {
                    fVar.bXk.setTag(r.h.tag_user_id, pVar.getAuthor().getUserId());
                    fVar.bXk.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.bPI);
                    fVar.bXk.a(this.egl, i4, getDimensionPixelSize(r.f.ds30), getDimensionPixelSize(r.f.ds30), getDimensionPixelSize(r.f.ds10));
                }
                if (fVar.agL != null) {
                    fVar.agL.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqz);
                    fVar.agL.a(this.cUY, 3, getDimensionPixelSize(r.f.ds36), getDimensionPixelSize(r.f.ds32), getDimensionPixelSize(r.f.ds8), true);
                }
            }
            if (pVar != null && pVar.getAuthor() != null && pVar.getAuthor().getPendantData() != null && !StringUtils.isNull(pVar.getAuthor().getPendantData().pL())) {
                fVar.egB.setVisibility(4);
                fVar.egA.setVisibility(0);
                fVar.egA.dU(pVar.getAuthor().getPendantData().pL());
                fVar.egA.getHeadView().c(portrait, 28, false);
                fVar.egA.setTag(r.h.tag_user_id, pVar.getAuthor().getUserId());
                fVar.egA.setTag(r.h.tag_user_name, pVar.getAuthor().getUserName());
            } else {
                fVar.egB.setVisibility(0);
                fVar.egA.setVisibility(8);
                fVar.egB.setUserId(pVar.getAuthor().getUserId());
                fVar.egB.setUserName(pVar.getAuthor().getUserName());
                fVar.egB.setImageDrawable(null);
                fVar.egB.c(portrait, 28, false);
            }
            fVar.blu.setTag(r.h.tag_user_id, pVar.getAuthor().getUserId());
            fVar.blu.setTag(r.h.tag_user_name, pVar.getAuthor().getUserName());
            fVar.egH.setLinkTextColor(ap.getColor(r.e.cp_link_tip_c));
            if (this.cAg) {
                fVar.egH.setDefaultImageId(r.g.transparent_bg);
            } else {
                fVar.egH.setDefaultImageId(r.g.icon_click);
            }
            fVar.egH.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = pVar.awW();
            }
            if (this.ego || !this.egp) {
                fVar.egH.a(tbRichText, false);
            } else {
                fVar.egH.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.egj.aKj() != 0) {
                z7 = true;
                z8 = true;
                String userId3 = pVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z7 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z7 = false;
                }
            }
            if (this.egj != null && this.egj.aJZ() != null && this.egj.aJZ().getAuthor() != null && pVar.getAuthor() != null) {
                String userId4 = this.egj.aJZ().getAuthor().getUserId();
                String userId5 = pVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = pVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        z4 = z2;
                        z5 = z3;
                    }
                    if (!z7) {
                        if (fVar.egT != null) {
                            fVar.egT.setVisibility(0);
                            fVar.egT.setText(r.l.manage);
                            fVar.egT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (fVar.egT != null) {
                            fVar.egT.setVisibility(0);
                            fVar.egT.setText(r.l.delete);
                            fVar.egT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(r.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (fVar.egT != null) {
                        fVar.egT.setVisibility(8);
                    }
                    int i5 = 1;
                    if (pVar.bhQ() == 1) {
                        i5 = 0;
                    }
                    sparseArray2.put(r.h.tag_forbid_user_post_id, pVar.getId());
                    if (!z7) {
                        sparseArray2.put(r.h.tag_should_manage_visible, true);
                        sparseArray2.put(r.h.tag_manage_user_identity, Integer.valueOf(this.egj.aKj()));
                        sparseArray2.put(r.h.tag_forbid_user_name, pVar.getAuthor().getUserName());
                    } else {
                        sparseArray2.put(r.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(r.h.tag_user_mute_visible, true);
                        sparseArray2.put(r.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (pVar.getAuthor() != null) {
                            sparseArray2.put(r.h.tag_user_mute_mute_userid, pVar.getAuthor().getUserId());
                            sparseArray2.put(r.h.tag_user_mute_mute_username, pVar.getAuthor().getUserName());
                        }
                        if (this.egj.aJZ() != null) {
                            sparseArray2.put(r.h.tag_user_mute_thread_id, this.egj.aJZ().getId());
                        }
                        sparseArray2.put(r.h.tag_user_mute_post_id, pVar.getId());
                    } else {
                        sparseArray2.put(r.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(r.h.tag_should_delete_visible, true);
                        sparseArray2.put(r.h.tag_manage_user_identity, Integer.valueOf(this.egj.aKj()));
                        sparseArray2.put(r.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(r.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray2.put(r.h.tag_del_post_id, pVar.getId());
                    } else {
                        sparseArray2.put(r.h.tag_should_delete_visible, false);
                    }
                    a(fVar, pVar, pVar.bhQ() != 1, tbRichText);
                    b(fVar);
                    a(view, pVar);
                    if (this.egs == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.egs.blU();
                        return;
                    }
                    return;
                }
            }
            z = false;
            z2 = z8;
            z3 = false;
            userId = pVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z4 = z2;
            z5 = z3;
            if (!z7) {
            }
            int i52 = 1;
            if (pVar.bhQ() == 1) {
            }
            sparseArray2.put(r.h.tag_forbid_user_post_id, pVar.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(fVar, pVar, pVar.bhQ() != 1, tbRichText);
            b(fVar);
            a(view, pVar);
            if (this.egs == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.egH.setTextViewOnTouchListener(this.egn);
        fVar.egH.setTextViewCheckSelection(false);
    }

    private void a(f fVar, p pVar, boolean z, TbRichText tbRichText) {
        if (pVar == null || pVar.aPB() == null || c(pVar)) {
            fVar.ehd.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(pVar.aPB(), fVar.ehd, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(pVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.egr - (i - this.egq));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean c(p pVar) {
        return (this.egj == null || this.egj.aJZ() == null || !this.egj.aJZ().sh() || this.egj.aJZ().rm() == null || pVar.bhQ() != 1) ? false : true;
    }

    private void a(View view, p pVar) {
        if (c(pVar) && view != null && this.ehi != null) {
            if (this.egs == null) {
                this.egs = new com.baidu.tieba.vote.a(this.ehi);
            }
            this.egs.a(view, this.egj);
        } else if (this.egs != null) {
            this.egs.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.blu.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqy);
        fVar.egB.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqy);
        fVar.egA.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqy);
        fVar.egL.setOnLongClickListener(this.anA);
        fVar.egH.setOnLongClickListener(this.anA);
        fVar.egL.setOnTouchListener(this.egn);
        fVar.egH.setOnTouchListener(this.egn);
        fVar.egH.setOnImageClickListener(this.aHX);
        fVar.egH.setOnEmotionClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqA);
        fVar.bXk.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.bPI);
        fVar.agL.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqz);
        fVar.ehd.setOnClickListener(this.cpK);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.egj = fVar;
    }

    public void oo(int i) {
        this.egh = i;
    }

    public void ii(boolean z) {
        this.cAg = z;
    }

    public void ij(boolean z) {
        this.egi = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void I(View.OnClickListener onClickListener) {
        this.egm = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cpK = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aHX = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.egn = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anA = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a((Context) this.ehi.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
