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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cx;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends cx<PostData, j> implements View.OnClickListener {
    private TbRichTextView.e aNK;
    private View.OnLongClickListener atl;
    private boolean cAb;
    private ArrayList<IconData> cVN;
    private View.OnClickListener cpI;
    private int ehf;
    private boolean ehg;
    private com.baidu.tieba.pb.data.f ehh;
    private ba ehi;
    private ArrayList<IconData> ehj;
    private View.OnClickListener ehk;
    private com.baidu.tieba.pb.a.d ehl;
    private boolean ehm;
    private final boolean ehn;
    private int eho;
    private int ehp;
    private com.baidu.tieba.vote.a ehq;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ehf = 0;
        this.cAb = true;
        this.ehg = true;
        this.ehh = null;
        this.mHostId = null;
        this.ehi = null;
        this.ehj = null;
        this.cVN = null;
        this.ehk = null;
        this.cpI = null;
        this.aNK = null;
        this.ehl = null;
        this.atl = null;
        this.ehm = false;
        this.ehn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                aq.c(jVar.ehP, w.e.common_color_10005, 1);
                aq.c(jVar.ehR, w.e.cp_link_tip_c, 3);
                aq.c(jVar.bsf, w.e.cp_cont_f, 1);
                aq.c((View) jVar.ehA, w.e.cp_cont_i, 1);
                aq.c((View) jVar.ehB, w.e.cp_cont_i, 1);
                aq.c(jVar.ehC, w.e.cp_cont_d, 1);
                aq.c(jVar.ehD, w.e.cp_cont_d, 1);
                aq.k(jVar.ehG, w.e.cp_bg_line_e);
                aq.k(jVar.ehH, w.e.cp_bg_line_e);
                aq.c(jVar.ehH, w.e.cp_bg_line_b);
                aq.k(jVar.ehK, w.e.cp_bg_line_c);
            }
            jVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.eho = getDimensionPixelSize(w.f.ds30);
        this.ehp = k.af(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.cAb, this.ehf, false);
        a(jVar);
        return jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cx, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, j jVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, jVar);
        a(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.tm();
            a(jVar, postData2, view, i);
        }
        if (!this.ehm && this.ehn && jVar != null && jVar.ehF.Jb() && (listView = ((PbActivity) this.eig.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ehm = true;
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
    private void a(j jVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (jVar != null && postData != null) {
            aq.k(jVar.ehN, w.e.cp_bg_line_b);
            jVar.ehz.setTag(null);
            jVar.ehz.setUserId(null);
            jVar.bsf.setText((CharSequence) null);
            jVar.ehB.setVisibility(8);
            jVar.ehK.setVisibility(0);
            jVar.ehE.setVisibility(8);
            SparseArray sparseArray = (SparseArray) jVar.ehJ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                jVar.ehJ.setTag(sparseArray);
                jVar.ehF.setTag(sparseArray);
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(jVar.ehF, getDimensionPixelSize(w.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.cAb || c(postData)) {
                sparseArray.put(w.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.ehF.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                jVar.ehF.setLayoutParams(layoutParams);
                jVar.ehF.setPadding(0, 0, 0, 0);
                jVar.ehF.gv(null);
            } else {
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                jVar.ehF.gv(postData.getBimg_url());
                if (postData.bio() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.ehF.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds40);
                    jVar.ehF.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) jVar.ehF.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(w.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(w.f.ds20);
                    jVar.ehF.setLayoutParams(layoutParams3);
                }
            }
            jVar.ehD.setText(au.q(postData.getTime()));
            jVar.ehI.setVisibility(8);
            if (postData.bio() == 1) {
                aq.k(jVar.ehv, w.e.cp_bg_line_d);
                jVar.ehw.setVisibility(8);
                jVar.ehN.setVisibility(8);
                jVar.ehJ.setVisibility(8);
                jVar.ehD.setVisibility(8);
                jVar.ehI.setVisibility(0);
                jVar.ehL.setVisibility(8);
                jVar.ehM.setVisibility(8);
                jVar.eic.setVisibility(8);
                jVar.ehW.setVisibility(8);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                jVar.ehI.a(postData.biv(), str, j, com.baidu.adp.lib.g.b.c(this.ehh.aJx().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                jVar.ehI.onChangeSkinType();
                if (this.ehg) {
                    PraiseData se = this.ehh.aJx().se();
                    if (se != null && se.getUser() != null && se.getUser().size() > 0) {
                        jVar.ehG.setVisibility(0);
                        jVar.ehH.setVisibility(0);
                        jVar.ehG.setIsFromPb(true);
                        jVar.ehG.a(se, this.ehh.aJx().getId(), se.getPostId(), true);
                        jVar.ehG.m26do(this.mSkinType);
                    } else {
                        jVar.ehG.setVisibility(8);
                        jVar.ehH.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.al(jVar.ehG);
                    com.baidu.tieba.graffiti.c.al(jVar.ehH);
                } else {
                    jVar.ehG.setVisibility(8);
                    jVar.ehH.setVisibility(8);
                }
                a(jVar.ehF, getDimensionPixelSize(w.f.ds30));
            } else {
                jVar.ehN.setVisibility(0);
                aq.k(jVar.ehv, w.e.cp_bg_line_e);
                jVar.ehw.setVisibility(0);
                com.baidu.tbadk.data.g bir = postData.bir();
                jVar.ehW.setVisibility(8);
                if (bir != null && !TextUtils.isEmpty(bir.getName()) && !TextUtils.isEmpty(bir.getName().trim())) {
                    String name = bir.getName();
                    String lat = bir.getLat();
                    String lng = bir.getLng();
                    jVar.eia.setText(bir.getName());
                    aq.c(jVar.eia, w.e.cp_cont_c, 1);
                    jVar.eia.setOnClickListener(new i(this, lat, lng, name));
                } else {
                    jVar.eia.setVisibility(8);
                }
                jVar.ehG.setVisibility(8);
                jVar.ehH.setVisibility(8);
                jVar.ehJ.setVisibility(0);
                jVar.ehD.setVisibility(0);
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bio()));
                jVar.ehC.setVisibility(0);
                jVar.ehC.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                jVar.ehE.setVisibility(0);
                aq.i(jVar.ehE, w.e.cp_link_tip_a);
            } else {
                jVar.ehE.setVisibility(8);
            }
            aq.j(jVar.ehx, w.g.bg_floor_new_middle);
            jVar.ehF.setVideoImageId(w.g.pic_video);
            jVar.ehF.setTextColor(aq.getColor(w.e.common_color_10039));
            jVar.ehF.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bio()));
            if (postData.bis() > 0) {
                if (this.ehi == null) {
                    this.ehi = new ba(this.mContext);
                    this.ehi.setIsFromCDN(this.mIsFromCDN);
                    this.ehi.I(this.ehk);
                    boolean z6 = false;
                    String userId2 = this.ehh.aJx().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.ehi.B(this.ehh.aJH(), z6);
                    this.ehi.h(this.ehh.aJx());
                }
                this.ehi.nP(postData.getId());
                jVar.ehK.setVisibility(0);
                jVar.ehK.a(postData, view);
                jVar.ehK.setChildOnClickListener(this.cpI);
                jVar.ehK.setChildOnLongClickListener(this.atl);
                jVar.ehK.setChildOnTouchListener(this.ehl);
                jVar.ehK.setSubPbAdapter(this.ehi);
                jVar.ehK.setVisibility(0);
                jVar.ehM.setPadding(0, 0, 0, k.g(this.mContext, w.f.ds24));
                jVar.eic.setVisibility(0);
            } else {
                jVar.ehM.setPadding(0, 0, 0, k.g(this.mContext, w.f.ds40));
                jVar.ehK.setVisibility(8);
                jVar.eic.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i2 = u.gq(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gq = u.gq(name_show);
                if (i2 > 0) {
                    if (gq > 12) {
                        name_show = String.valueOf(u.d(name_show, 0, 14)) + "...";
                    }
                } else if (gq > 14) {
                    name_show = String.valueOf(u.d(name_show, 0, 14)) + "...";
                }
                if (i2 > 0) {
                    jVar.bsf.setText(af(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    jVar.bsf.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aq.c(jVar.bsf, w.e.cp_cont_h, 1);
                } else {
                    aq.c(jVar.bsf, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    jVar.ehA.setVisibility(0);
                    aq.c(jVar.ehA, BitmapHelper.getGradeResourceIdNew(level_id));
                    jVar.ehA.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id)));
                    jVar.ehA.setOnClickListener(null);
                } else {
                    jVar.ehA.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aq.c(jVar.ehB, w.g.pb_manager);
                        jVar.ehA.setVisibility(8);
                        jVar.ehB.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aq.c(jVar.ehB, w.g.pb_assist);
                        jVar.ehA.setVisibility(8);
                        jVar.ehB.setVisibility(0);
                    }
                }
                int gq2 = u.gq(postData.getAuthor().getName_show());
                if (gq2 >= 14 && jVar.ehA.getVisibility() == 0 && jVar.ehE.getVisibility() == 0) {
                    i3 = 2;
                }
                int i4 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gq2 < 12 || jVar.ehA.getVisibility() != 0 || jVar.ehE.getVisibility() != 0) ? i3 : i3 - 1;
                this.ehj = postData.getAuthor().getIconInfo();
                this.cVN = postData.getAuthor().getTShowInfoNew();
                if (jVar.cdi != null) {
                    jVar.cdi.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    jVar.cdi.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.bWF);
                    jVar.cdi.a(this.ehj, i4, getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds10));
                }
                if (jVar.ams != null) {
                    jVar.ams.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erJ);
                    jVar.ams.a(this.cVN, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds32), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().qB())) {
                jVar.ehz.setVisibility(4);
                jVar.ehy.setVisibility(0);
                jVar.ehy.dU(postData.getAuthor().getPendantData().qB());
                jVar.ehy.getHeadView().c(portrait, 28, false);
                jVar.ehy.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                jVar.ehy.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                jVar.ehz.setVisibility(0);
                jVar.ehy.setVisibility(8);
                jVar.ehz.setUserId(postData.getAuthor().getUserId());
                jVar.ehz.setUserName(postData.getAuthor().getUserName());
                jVar.ehz.setImageDrawable(null);
                jVar.ehz.c(portrait, 28, false);
            }
            jVar.bsf.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            jVar.bsf.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            jVar.ehF.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            if (this.cAb) {
                jVar.ehF.setDefaultImageId(w.g.transparent_bg);
            } else {
                jVar.ehF.setDefaultImageId(w.g.icon_click);
            }
            jVar.ehF.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.awl();
            }
            if (this.ehm || !this.ehn) {
                jVar.ehF.a(tbRichText, false);
            } else {
                jVar.ehF.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.ehh.aJH() != 0) {
                z7 = true;
                z8 = true;
                String userId3 = postData.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z7 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z7 = false;
                }
            }
            if (this.ehh != null && this.ehh.aJx() != null && this.ehh.aJx().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.ehh.aJx().getAuthor().getUserId();
                String userId5 = postData.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        z4 = z2;
                        z5 = z3;
                    }
                    if (!z7) {
                        if (jVar.ehR != null) {
                            jVar.ehR.setVisibility(0);
                            jVar.ehR.setText(w.l.manage);
                            jVar.ehR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (jVar.ehR != null) {
                            jVar.ehR.setVisibility(0);
                            jVar.ehR.setText(w.l.delete);
                            jVar.ehR.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (jVar.ehR != null) {
                        jVar.ehR.setVisibility(8);
                    }
                    int i5 = 1;
                    if (postData.bio() == 1) {
                        i5 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ehh.aJH()));
                        sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray2.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(w.h.tag_user_mute_visible, true);
                        sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.ehh.aJx() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.ehh.aJx().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ehh.aJH()));
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    a(jVar, postData, postData.bio() != 1, tbRichText);
                    b(jVar);
                    a(view, postData);
                    if (this.ehq == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.ehq.bmt();
                        return;
                    }
                    return;
                }
            }
            z = false;
            z2 = z8;
            z3 = false;
            userId = postData.getAuthor().getUserId();
            if (userId == null) {
            }
            z4 = z2;
            z5 = z3;
            if (!z7) {
            }
            int i52 = 1;
            if (postData.bio() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(jVar, postData, postData.bio() != 1, tbRichText);
            b(jVar);
            a(view, postData);
            if (this.ehq == null) {
            }
        }
    }

    private void b(j jVar) {
        jVar.ehF.setTextViewOnTouchListener(this.ehl);
        jVar.ehF.setTextViewCheckSelection(false);
    }

    private void a(j jVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aPb() == null || c(postData)) {
            jVar.eib.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aPb(), jVar.eib, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ehp - (i - this.eho));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean c(PostData postData) {
        return (this.ehh == null || this.ehh.aJx() == null || !this.ehh.aJx().ta() || this.ehh.aJx().sd() == null || postData.bio() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (c(postData) && view != null && this.eig != null) {
            if (this.ehq == null) {
                this.ehq = new com.baidu.tieba.vote.a(this.eig);
            }
            this.ehq.a(view, this.ehh);
        } else if (this.ehq != null) {
            this.ehq.setVisibility(8);
        }
    }

    private void c(j jVar) {
        jVar.bsf.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erI);
        jVar.ehz.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erI);
        jVar.ehy.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erI);
        jVar.ehJ.setOnLongClickListener(this.atl);
        jVar.ehF.setOnLongClickListener(this.atl);
        jVar.ehJ.setOnTouchListener(this.ehl);
        jVar.ehF.setOnTouchListener(this.ehl);
        jVar.ehF.setOnImageClickListener(this.aNK);
        jVar.ehF.setOnEmotionClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erK);
        jVar.cdi.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.bWF);
        jVar.ams.setOnClickListener(((PbActivity) this.eig.getPageContext().getOrignalPage()).eiT.erJ);
        jVar.eib.setOnClickListener(this.cpI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ehh = fVar;
    }

    public void oa(int i) {
        this.ehf = i;
    }

    public void ia(boolean z) {
        this.cAb = z;
    }

    public void ib(boolean z) {
        this.ehg = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ehk = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cpI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNK = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ehl = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atl = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return at.a((Context) this.eig.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
