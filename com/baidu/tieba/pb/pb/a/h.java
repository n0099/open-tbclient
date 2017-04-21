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
    private TbRichTextView.e aNM;
    private View.OnLongClickListener atn;
    private boolean cCs;
    private ArrayList<IconData> cYe;
    private View.OnClickListener csa;
    private View.OnClickListener ejA;
    private com.baidu.tieba.pb.a.d ejB;
    private boolean ejC;
    private final boolean ejD;
    private int ejE;
    private int ejF;
    private com.baidu.tieba.vote.a ejG;
    private int ejv;
    private boolean ejw;
    private com.baidu.tieba.pb.data.f ejx;
    private ba ejy;
    private ArrayList<IconData> ejz;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ejv = 0;
        this.cCs = true;
        this.ejw = true;
        this.ejx = null;
        this.mHostId = null;
        this.ejy = null;
        this.ejz = null;
        this.cYe = null;
        this.ejA = null;
        this.csa = null;
        this.aNM = null;
        this.ejB = null;
        this.atn = null;
        this.ejC = false;
        this.ejD = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                aq.c(jVar.ekf, w.e.common_color_10005, 1);
                aq.c(jVar.ekh, w.e.cp_link_tip_c, 3);
                aq.c(jVar.bux, w.e.cp_cont_f, 1);
                aq.c((View) jVar.ejQ, w.e.cp_cont_i, 1);
                aq.c((View) jVar.ejR, w.e.cp_cont_i, 1);
                aq.c(jVar.ejS, w.e.cp_cont_d, 1);
                aq.c(jVar.ejT, w.e.cp_cont_d, 1);
                aq.k(jVar.ejW, w.e.cp_bg_line_e);
                aq.k(jVar.ejX, w.e.cp_bg_line_e);
                aq.c(jVar.ejX, w.e.cp_bg_line_b);
                aq.k(jVar.eka, w.e.cp_bg_line_c);
            }
            jVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.ejE = getDimensionPixelSize(w.f.ds30);
        this.ejF = k.af(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.cCs, this.ejv, false);
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
        if (!this.ejC && this.ejD && jVar != null && jVar.ejV.Jb() && (listView = ((PbActivity) this.ekw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ejC = true;
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
            aq.k(jVar.ekd, w.e.cp_bg_line_b);
            jVar.ejP.setTag(null);
            jVar.ejP.setUserId(null);
            jVar.bux.setText((CharSequence) null);
            jVar.ejR.setVisibility(8);
            jVar.eka.setVisibility(0);
            jVar.ejU.setVisibility(8);
            SparseArray sparseArray = (SparseArray) jVar.ejZ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                jVar.ejZ.setTag(sparseArray);
                jVar.ejV.setTag(sparseArray);
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(jVar.ejV, getDimensionPixelSize(w.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.cCs || c(postData)) {
                sparseArray.put(w.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.ejV.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                jVar.ejV.setLayoutParams(layoutParams);
                jVar.ejV.setPadding(0, 0, 0, 0);
                jVar.ejV.gv(null);
            } else {
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                jVar.ejV.gv(postData.getBimg_url());
                if (postData.bjp() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.ejV.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds40);
                    jVar.ejV.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) jVar.ejV.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(w.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(w.f.ds20);
                    jVar.ejV.setLayoutParams(layoutParams3);
                }
            }
            jVar.ejT.setText(au.q(postData.getTime()));
            jVar.ejY.setVisibility(8);
            if (postData.bjp() == 1) {
                aq.k(jVar.ejL, w.e.cp_bg_line_d);
                jVar.ejM.setVisibility(8);
                jVar.ekd.setVisibility(8);
                jVar.ejZ.setVisibility(8);
                jVar.ejT.setVisibility(8);
                jVar.ejY.setVisibility(0);
                jVar.ekb.setVisibility(8);
                jVar.ekc.setVisibility(8);
                jVar.eks.setVisibility(8);
                jVar.ekm.setVisibility(8);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                jVar.ejY.a(postData.bjw(), str, j, com.baidu.adp.lib.g.b.c(this.ejx.aKy().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                jVar.ejY.onChangeSkinType();
                if (this.ejw) {
                    PraiseData se = this.ejx.aKy().se();
                    if (se != null && se.getUser() != null && se.getUser().size() > 0) {
                        jVar.ejW.setVisibility(0);
                        jVar.ejX.setVisibility(0);
                        jVar.ejW.setIsFromPb(true);
                        jVar.ejW.a(se, this.ejx.aKy().getId(), se.getPostId(), true);
                        jVar.ejW.m24do(this.mSkinType);
                    } else {
                        jVar.ejW.setVisibility(8);
                        jVar.ejX.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.al(jVar.ejW);
                    com.baidu.tieba.graffiti.c.al(jVar.ejX);
                } else {
                    jVar.ejW.setVisibility(8);
                    jVar.ejX.setVisibility(8);
                }
                a(jVar.ejV, getDimensionPixelSize(w.f.ds30));
            } else {
                jVar.ekd.setVisibility(0);
                aq.k(jVar.ejL, w.e.cp_bg_line_e);
                jVar.ejM.setVisibility(0);
                com.baidu.tbadk.data.g bjs = postData.bjs();
                jVar.ekm.setVisibility(8);
                if (bjs != null && !TextUtils.isEmpty(bjs.getName()) && !TextUtils.isEmpty(bjs.getName().trim())) {
                    String name = bjs.getName();
                    String lat = bjs.getLat();
                    String lng = bjs.getLng();
                    jVar.ekq.setText(bjs.getName());
                    aq.c(jVar.ekq, w.e.cp_cont_c, 1);
                    jVar.ekq.setOnClickListener(new i(this, lat, lng, name));
                } else {
                    jVar.ekq.setVisibility(8);
                }
                jVar.ejW.setVisibility(8);
                jVar.ejX.setVisibility(8);
                jVar.ejZ.setVisibility(0);
                jVar.ejT.setVisibility(0);
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bjp()));
                jVar.ejS.setVisibility(0);
                jVar.ejS.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                jVar.ejU.setVisibility(0);
                aq.i(jVar.ejU, w.e.cp_link_tip_a);
            } else {
                jVar.ejU.setVisibility(8);
            }
            aq.j(jVar.ejN, w.g.bg_floor_new_middle);
            jVar.ejV.setVideoImageId(w.g.pic_video);
            jVar.ejV.setTextColor(aq.getColor(w.e.common_color_10039));
            jVar.ejV.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bjp()));
            if (postData.bjt() > 0) {
                if (this.ejy == null) {
                    this.ejy = new ba(this.mContext);
                    this.ejy.setIsFromCDN(this.mIsFromCDN);
                    this.ejy.I(this.ejA);
                    boolean z6 = false;
                    String userId2 = this.ejx.aKy().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.ejy.B(this.ejx.aKI(), z6);
                    this.ejy.h(this.ejx.aKy());
                }
                this.ejy.nQ(postData.getId());
                jVar.eka.setVisibility(0);
                jVar.eka.a(postData, view);
                jVar.eka.setChildOnClickListener(this.csa);
                jVar.eka.setChildOnLongClickListener(this.atn);
                jVar.eka.setChildOnTouchListener(this.ejB);
                jVar.eka.setSubPbAdapter(this.ejy);
                jVar.eka.setVisibility(0);
                jVar.ekc.setPadding(0, 0, 0, k.g(this.mContext, w.f.ds24));
                jVar.eks.setVisibility(0);
            } else {
                jVar.ekc.setPadding(0, 0, 0, k.g(this.mContext, w.f.ds40));
                jVar.eka.setVisibility(8);
                jVar.eks.setVisibility(8);
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
                    jVar.bux.setText(af(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    jVar.bux.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aq.c(jVar.bux, w.e.cp_cont_h, 1);
                } else {
                    aq.c(jVar.bux, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    jVar.ejQ.setVisibility(0);
                    aq.c(jVar.ejQ, BitmapHelper.getGradeResourceIdNew(level_id));
                    jVar.ejQ.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id)));
                    jVar.ejQ.setOnClickListener(null);
                } else {
                    jVar.ejQ.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aq.c(jVar.ejR, w.g.pb_manager);
                        jVar.ejQ.setVisibility(8);
                        jVar.ejR.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aq.c(jVar.ejR, w.g.pb_assist);
                        jVar.ejQ.setVisibility(8);
                        jVar.ejR.setVisibility(0);
                    }
                }
                int gq2 = u.gq(postData.getAuthor().getName_show());
                if (gq2 >= 14 && jVar.ejQ.getVisibility() == 0 && jVar.ejU.getVisibility() == 0) {
                    i3 = 2;
                }
                int i4 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gq2 < 12 || jVar.ejQ.getVisibility() != 0 || jVar.ejU.getVisibility() != 0) ? i3 : i3 - 1;
                this.ejz = postData.getAuthor().getIconInfo();
                this.cYe = postData.getAuthor().getTShowInfoNew();
                if (jVar.cfz != null) {
                    jVar.cfz.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    jVar.cfz.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.bYW);
                    jVar.cfz.a(this.ejz, i4, getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds10));
                }
                if (jVar.ams != null) {
                    jVar.ams.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.eub);
                    jVar.ams.a(this.cYe, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds32), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().qB())) {
                jVar.ejP.setVisibility(4);
                jVar.ejO.setVisibility(0);
                jVar.ejO.dU(postData.getAuthor().getPendantData().qB());
                jVar.ejO.getHeadView().c(portrait, 28, false);
                jVar.ejO.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                jVar.ejO.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                jVar.ejP.setVisibility(0);
                jVar.ejO.setVisibility(8);
                jVar.ejP.setUserId(postData.getAuthor().getUserId());
                jVar.ejP.setUserName(postData.getAuthor().getUserName());
                jVar.ejP.setImageDrawable(null);
                jVar.ejP.c(portrait, 28, false);
            }
            jVar.bux.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            jVar.bux.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            jVar.ejV.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            if (this.cCs) {
                jVar.ejV.setDefaultImageId(w.g.transparent_bg);
            } else {
                jVar.ejV.setDefaultImageId(w.g.icon_click);
            }
            jVar.ejV.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.axm();
            }
            if (this.ejC || !this.ejD) {
                jVar.ejV.a(tbRichText, false);
            } else {
                jVar.ejV.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.ejx.aKI() != 0) {
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
            if (this.ejx != null && this.ejx.aKy() != null && this.ejx.aKy().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.ejx.aKy().getAuthor().getUserId();
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
                        if (jVar.ekh != null) {
                            jVar.ekh.setVisibility(0);
                            jVar.ekh.setText(w.l.manage);
                            jVar.ekh.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (jVar.ekh != null) {
                            jVar.ekh.setVisibility(0);
                            jVar.ekh.setText(w.l.delete);
                            jVar.ekh.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (jVar.ekh != null) {
                        jVar.ekh.setVisibility(8);
                    }
                    int i5 = 1;
                    if (postData.bjp() == 1) {
                        i5 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejx.aKI()));
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
                        if (this.ejx.aKy() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.ejx.aKy().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejx.aKI()));
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    a(jVar, postData, postData.bjp() != 1, tbRichText);
                    b(jVar);
                    a(view, postData);
                    if (this.ejG == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.ejG.bnu();
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
            if (postData.bjp() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(jVar, postData, postData.bjp() != 1, tbRichText);
            b(jVar);
            a(view, postData);
            if (this.ejG == null) {
            }
        }
    }

    private void b(j jVar) {
        jVar.ejV.setTextViewOnTouchListener(this.ejB);
        jVar.ejV.setTextViewCheckSelection(false);
    }

    private void a(j jVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aQc() == null || c(postData)) {
            jVar.ekr.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aQc(), jVar.ekr, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ejF - (i - this.ejE));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean c(PostData postData) {
        return (this.ejx == null || this.ejx.aKy() == null || !this.ejx.aKy().ta() || this.ejx.aKy().sd() == null || postData.bjp() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (c(postData) && view != null && this.ekw != null) {
            if (this.ejG == null) {
                this.ejG = new com.baidu.tieba.vote.a(this.ekw);
            }
            this.ejG.a(view, this.ejx);
        } else if (this.ejG != null) {
            this.ejG.setVisibility(8);
        }
    }

    private void c(j jVar) {
        jVar.bux.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.eua);
        jVar.ejP.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.eua);
        jVar.ejO.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.eua);
        jVar.ejZ.setOnLongClickListener(this.atn);
        jVar.ejV.setOnLongClickListener(this.atn);
        jVar.ejZ.setOnTouchListener(this.ejB);
        jVar.ejV.setOnTouchListener(this.ejB);
        jVar.ejV.setOnImageClickListener(this.aNM);
        jVar.ejV.setOnEmotionClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.euc);
        jVar.cfz.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.bYW);
        jVar.ams.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.eub);
        jVar.ekr.setOnClickListener(this.csa);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ejx = fVar;
    }

    public void og(int i) {
        this.ejv = i;
    }

    public void ik(boolean z) {
        this.cCs = z;
    }

    public void il(boolean z) {
        this.ejw = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ejA = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.csa = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNM = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ejB = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atn = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return at.a((Context) this.ekw.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
