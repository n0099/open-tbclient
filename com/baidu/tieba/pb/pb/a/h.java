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
import com.baidu.tieba.pb.pb.main.cz;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends cz<PostData, j> implements View.OnClickListener {
    private TbRichTextView.e aNu;
    private View.OnLongClickListener asV;
    private boolean cBC;
    private ArrayList<IconData> cXq;
    private View.OnClickListener crj;
    private int eiZ;
    private boolean eja;
    private com.baidu.tieba.pb.data.f ejb;
    private ba ejc;
    private ArrayList<IconData> ejd;
    private View.OnClickListener eje;
    private com.baidu.tieba.pb.a.d ejf;
    private boolean ejg;
    private final boolean ejh;
    private int eji;
    private int ejj;
    private com.baidu.tieba.vote.a ejk;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eiZ = 0;
        this.cBC = true;
        this.eja = true;
        this.ejb = null;
        this.mHostId = null;
        this.ejc = null;
        this.ejd = null;
        this.cXq = null;
        this.eje = null;
        this.crj = null;
        this.aNu = null;
        this.ejf = null;
        this.asV = null;
        this.ejg = false;
        this.ejh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                aq.c(jVar.ejJ, w.e.common_color_10005, 1);
                aq.c(jVar.ejL, w.e.cp_link_tip_c, 3);
                aq.c(jVar.bsn, w.e.cp_cont_f, 1);
                aq.c((View) jVar.eju, w.e.cp_cont_i, 1);
                aq.c((View) jVar.ejv, w.e.cp_cont_i, 1);
                aq.c(jVar.ejw, w.e.cp_cont_d, 1);
                aq.c(jVar.ejx, w.e.cp_cont_d, 1);
                aq.k(jVar.ejA, w.e.cp_bg_line_e);
                aq.k(jVar.ejB, w.e.cp_bg_line_e);
                aq.c(jVar.ejB, w.e.cp_bg_line_b);
                aq.k(jVar.ejE, w.e.cp_bg_line_c);
            }
            jVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.eji = getDimensionPixelSize(w.f.ds30);
        this.ejj = k.ag(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.cBC, this.eiZ, false);
        a(jVar);
        return jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cz, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, j jVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, jVar);
        a(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sO();
            a(jVar, postData2, view, i);
        }
        if (!this.ejg && this.ejh && jVar != null && jVar.ejz.IC() && (listView = ((PbActivity) this.eka.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ejg = true;
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
            aq.k(jVar.ejH, w.e.cp_bg_line_b);
            jVar.ejt.setTag(null);
            jVar.ejt.setUserId(null);
            jVar.bsn.setText((CharSequence) null);
            jVar.ejv.setVisibility(8);
            jVar.ejE.setVisibility(0);
            jVar.ejy.setVisibility(8);
            SparseArray sparseArray = (SparseArray) jVar.ejD.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                jVar.ejD.setTag(sparseArray);
                jVar.ejz.setTag(sparseArray);
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(jVar.ejz, getDimensionPixelSize(w.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.cBC || c(postData)) {
                sparseArray.put(w.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.ejz.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                jVar.ejz.setLayoutParams(layoutParams);
                jVar.ejz.setPadding(0, 0, 0, 0);
                jVar.ejz.gp(null);
            } else {
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                jVar.ejz.gp(postData.getBimg_url());
                if (postData.bhD() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.ejz.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds40);
                    jVar.ejz.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) jVar.ejz.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(w.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(w.f.ds20);
                    jVar.ejz.setLayoutParams(layoutParams3);
                }
            }
            jVar.ejx.setText(au.q(postData.getTime()));
            jVar.ejC.setVisibility(8);
            if (postData.bhD() == 1) {
                aq.k(jVar.ejp, w.e.cp_bg_line_d);
                jVar.ejq.setVisibility(8);
                jVar.ejH.setVisibility(8);
                jVar.ejD.setVisibility(8);
                jVar.ejx.setVisibility(8);
                jVar.ejC.setVisibility(0);
                jVar.ejF.setVisibility(8);
                jVar.ejG.setVisibility(8);
                jVar.ejW.setVisibility(8);
                jVar.ejQ.setVisibility(8);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                jVar.ejC.a(postData.bhK(), str, j, com.baidu.adp.lib.g.b.c(this.ejb.aJq().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                jVar.ejC.tD();
                if (this.eja) {
                    PraiseData rG = this.ejb.aJq().rG();
                    if (rG != null && rG.getUser() != null && rG.getUser().size() > 0) {
                        jVar.ejA.setVisibility(0);
                        jVar.ejB.setVisibility(0);
                        jVar.ejA.setIsFromPb(true);
                        jVar.ejA.a(rG, this.ejb.aJq().getId(), rG.getPostId(), true);
                        jVar.ejA.dl(this.mSkinType);
                    } else {
                        jVar.ejA.setVisibility(8);
                        jVar.ejB.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.an(jVar.ejA);
                    com.baidu.tieba.graffiti.c.an(jVar.ejB);
                } else {
                    jVar.ejA.setVisibility(8);
                    jVar.ejB.setVisibility(8);
                }
                a(jVar.ejz, getDimensionPixelSize(w.f.ds30));
            } else {
                jVar.ejH.setVisibility(0);
                aq.k(jVar.ejp, w.e.cp_bg_line_e);
                jVar.ejq.setVisibility(0);
                com.baidu.tbadk.data.g bhG = postData.bhG();
                jVar.ejQ.setVisibility(8);
                if (bhG != null && !TextUtils.isEmpty(bhG.getName()) && !TextUtils.isEmpty(bhG.getName().trim())) {
                    String name = bhG.getName();
                    String lat = bhG.getLat();
                    String lng = bhG.getLng();
                    jVar.ejU.setText(bhG.getName());
                    aq.c(jVar.ejU, w.e.cp_cont_c, 1);
                    jVar.ejU.setOnClickListener(new i(this, lat, lng, name));
                } else {
                    jVar.ejU.setVisibility(8);
                }
                jVar.ejA.setVisibility(8);
                jVar.ejB.setVisibility(8);
                jVar.ejD.setVisibility(0);
                jVar.ejx.setVisibility(0);
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bhD()));
                jVar.ejw.setVisibility(0);
                jVar.ejw.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                jVar.ejy.setVisibility(0);
                aq.i((View) jVar.ejy, w.e.cp_link_tip_a);
            } else {
                jVar.ejy.setVisibility(8);
            }
            aq.j(jVar.ejr, w.g.bg_floor_new_middle);
            jVar.ejz.setVideoImageId(w.g.pic_video);
            jVar.ejz.setTextColor(aq.getColor(w.e.common_color_10039));
            jVar.ejz.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bhD()));
            if (postData.bhH() > 0) {
                if (this.ejc == null) {
                    this.ejc = new ba(this.mContext);
                    this.ejc.setIsFromCDN(this.mIsFromCDN);
                    this.ejc.H(this.eje);
                    boolean z6 = false;
                    String userId2 = this.ejb.aJq().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.ejc.B(this.ejb.aJA(), z6);
                    this.ejc.h(this.ejb.aJq());
                }
                this.ejc.nL(postData.getId());
                jVar.ejE.setVisibility(0);
                jVar.ejE.a(postData, view);
                jVar.ejE.setChildOnClickListener(this.crj);
                jVar.ejE.setChildOnLongClickListener(this.asV);
                jVar.ejE.setChildOnTouchListener(this.ejf);
                jVar.ejE.setSubPbAdapter(this.ejc);
                jVar.ejE.setVisibility(0);
                jVar.ejG.setPadding(0, 0, 0, k.g(this.mContext, w.f.ds24));
                jVar.ejW.setVisibility(0);
            } else {
                jVar.ejG.setPadding(0, 0, 0, k.g(this.mContext, w.f.ds40));
                jVar.ejE.setVisibility(8);
                jVar.ejW.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i2 = u.gk(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gk = u.gk(name_show);
                if (i2 > 0) {
                    if (gk > 12) {
                        name_show = String.valueOf(u.d(name_show, 0, 14)) + "...";
                    }
                } else if (gk > 14) {
                    name_show = String.valueOf(u.d(name_show, 0, 14)) + "...";
                }
                if (i2 > 0) {
                    jVar.bsn.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    jVar.bsn.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aq.c(jVar.bsn, w.e.cp_cont_h, 1);
                } else {
                    aq.c(jVar.bsn, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    jVar.eju.setVisibility(0);
                    aq.c(jVar.eju, BitmapHelper.getGradeResourceIdNew(level_id));
                    jVar.eju.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id)));
                    jVar.eju.setOnClickListener(null);
                } else {
                    jVar.eju.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aq.c(jVar.ejv, w.g.pb_manager);
                        jVar.eju.setVisibility(8);
                        jVar.ejv.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aq.c(jVar.ejv, w.g.pb_assist);
                        jVar.eju.setVisibility(8);
                        jVar.ejv.setVisibility(0);
                    }
                }
                int gk2 = u.gk(postData.getAuthor().getName_show());
                if (gk2 >= 14 && jVar.eju.getVisibility() == 0 && jVar.ejy.getVisibility() == 0) {
                    i3 = 2;
                }
                int i4 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gk2 < 12 || jVar.eju.getVisibility() != 0 || jVar.ejy.getVisibility() != 0) ? i3 : i3 - 1;
                this.ejd = postData.getAuthor().getIconInfo();
                this.cXq = postData.getAuthor().getTShowInfoNew();
                if (jVar.ceI != null) {
                    jVar.ceI.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    jVar.ceI.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.bWQ);
                    jVar.ceI.a(this.ejd, i4, getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds10));
                }
                if (jVar.ame != null) {
                    jVar.ame.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etG);
                    jVar.ame.a(this.cXq, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds32), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().qd())) {
                jVar.ejt.setVisibility(4);
                jVar.ejs.setVisibility(0);
                jVar.ejs.dO(postData.getAuthor().getPendantData().qd());
                jVar.ejs.getHeadView().c(portrait, 28, false);
                jVar.ejs.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                jVar.ejs.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                jVar.ejt.setVisibility(0);
                jVar.ejs.setVisibility(8);
                jVar.ejt.setUserId(postData.getAuthor().getUserId());
                jVar.ejt.setUserName(postData.getAuthor().getUserName());
                jVar.ejt.setImageDrawable(null);
                jVar.ejt.c(portrait, 28, false);
            }
            jVar.bsn.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            jVar.bsn.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            jVar.ejz.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            if (this.cBC) {
                jVar.ejz.setDefaultImageId(w.g.transparent_bg);
            } else {
                jVar.ejz.setDefaultImageId(w.g.icon_click);
            }
            jVar.ejz.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aws();
            }
            if (this.ejg || !this.ejh) {
                jVar.ejz.a(tbRichText, false);
            } else {
                jVar.ejz.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.ejb.aJA() != 0) {
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
            if (this.ejb != null && this.ejb.aJq() != null && this.ejb.aJq().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.ejb.aJq().getAuthor().getUserId();
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
                        if (jVar.ejL != null) {
                            jVar.ejL.setVisibility(0);
                            jVar.ejL.setText(w.l.manage);
                            jVar.ejL.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (jVar.ejL != null) {
                            jVar.ejL.setVisibility(0);
                            jVar.ejL.setText(w.l.delete);
                            jVar.ejL.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (jVar.ejL != null) {
                        jVar.ejL.setVisibility(8);
                    }
                    int i5 = 1;
                    if (postData.bhD() == 1) {
                        i5 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejb.aJA()));
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
                        if (this.ejb.aJq() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.ejb.aJq().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejb.aJA()));
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    a(jVar, postData, postData.bhD() != 1, tbRichText);
                    b(jVar);
                    a(view, postData);
                    if (this.ejk == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.ejk.blJ();
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
            if (postData.bhD() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(jVar, postData, postData.bhD() != 1, tbRichText);
            b(jVar);
            a(view, postData);
            if (this.ejk == null) {
            }
        }
    }

    private void b(j jVar) {
        jVar.ejz.setTextViewOnTouchListener(this.ejf);
        jVar.ejz.setTextViewCheckSelection(false);
    }

    private void a(j jVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aOS() == null || c(postData)) {
            jVar.ejV.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aOS(), jVar.ejV, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ejj - (i - this.eji));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean c(PostData postData) {
        return (this.ejb == null || this.ejb.aJq() == null || !this.ejb.aJq().sC() || this.ejb.aJq().rF() == null || postData.bhD() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (c(postData) && view != null && this.eka != null) {
            if (this.ejk == null) {
                this.ejk = new com.baidu.tieba.vote.a(this.eka);
            }
            this.ejk.a(view, this.ejb);
        } else if (this.ejk != null) {
            this.ejk.setVisibility(8);
        }
    }

    private void c(j jVar) {
        jVar.bsn.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etF);
        jVar.ejt.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etF);
        jVar.ejs.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etF);
        jVar.ejD.setOnLongClickListener(this.asV);
        jVar.ejz.setOnLongClickListener(this.asV);
        jVar.ejD.setOnTouchListener(this.ejf);
        jVar.ejz.setOnTouchListener(this.ejf);
        jVar.ejz.setOnImageClickListener(this.aNu);
        jVar.ejz.setOnEmotionClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etH);
        jVar.ceI.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.bWQ);
        jVar.ame.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etG);
        jVar.ejV.setOnClickListener(this.crj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ejb = fVar;
    }

    public void oc(int i) {
        this.eiZ = i;
    }

    public void ib(boolean z) {
        this.cBC = z;
    }

    public void ic(boolean z) {
        this.eja = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eje = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.crj = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNu = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ejf = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.asV = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return at.a((Context) this.eka.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
