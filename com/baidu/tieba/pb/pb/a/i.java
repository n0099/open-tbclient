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
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dn;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.pb.view.aa;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends dn<PostData, l> implements View.OnClickListener {
    private TbRichTextView.e aOb;
    private com.baidu.tieba.pb.a.d aOc;
    private View.OnLongClickListener atb;
    private ArrayList<IconData> cXF;
    private View.OnClickListener cvw;
    private int ejZ;
    private boolean eka;
    private boolean ekb;
    private com.baidu.tieba.pb.data.f ekc;
    private ba ekd;
    private ArrayList<IconData> eke;
    private View.OnClickListener ekf;
    private boolean ekg;
    private final boolean ekh;
    private int eki;
    private int ekj;
    private com.baidu.tieba.vote.a ekk;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ejZ = 0;
        this.eka = true;
        this.ekb = true;
        this.ekc = null;
        this.mHostId = null;
        this.ekd = null;
        this.eke = null;
        this.cXF = null;
        this.ekf = null;
        this.cvw = null;
        this.aOb = null;
        this.aOc = null;
        this.atb = null;
        this.ekg = false;
        this.ekh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                aq.c(lVar.ekJ, w.e.common_color_10005, 1);
                aq.c(lVar.ekL, w.e.cp_link_tip_c, 3);
                aq.c(lVar.bAh, w.e.cp_cont_f, 1);
                aq.c((View) lVar.eku, w.e.cp_cont_i, 1);
                aq.c((View) lVar.ekv, w.e.cp_cont_i, 1);
                aq.c(lVar.ekw, w.e.cp_cont_d, 1);
                aq.c(lVar.ekx, w.e.cp_cont_d, 1);
                aq.k(lVar.ekA, w.e.cp_bg_line_e);
                aq.k(lVar.ekB, w.e.cp_bg_line_e);
                aq.c(lVar.ekB, w.e.cp_bg_line_b);
                aq.k(lVar.ekE, w.e.cp_bg_line_c);
            }
            lVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.eki = getDimensionPixelSize(w.f.ds30);
        this.ekj = com.baidu.adp.lib.util.k.af(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.eka, this.ejZ, false);
        a(lVar);
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, lVar);
        a(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.ss();
            a(lVar, postData2, view, i);
        }
        if (!this.ekg && this.ekh && lVar != null && lVar.ekz.Ik() && (listView = ((PbActivity) this.elf.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ekg = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x062c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0981  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x098d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(l lVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (lVar != null && postData != null) {
            aq.k(lVar.ekH, w.e.cp_bg_line_b);
            lVar.ekt.setTag(null);
            lVar.ekt.setUserId(null);
            lVar.bAh.setText((CharSequence) null);
            lVar.ekv.setVisibility(8);
            lVar.ekE.setVisibility(0);
            lVar.eky.setVisibility(8);
            SparseArray sparseArray = (SparseArray) lVar.ekD.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                lVar.ekD.setTag(sparseArray);
                lVar.ekz.setTag(sparseArray);
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(lVar.ekz, getDimensionPixelSize(w.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eka || f(postData)) {
                sparseArray.put(w.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.ekz.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                lVar.ekz.setLayoutParams(layoutParams);
                lVar.ekz.setPadding(0, 0, 0, 0);
                lVar.ekz.gs(null);
            } else {
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                lVar.ekz.gs(postData.getBimg_url());
                if (postData.big() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.ekz.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds40);
                    lVar.ekz.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) lVar.ekz.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(w.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(w.f.ds20);
                    lVar.ekz.setLayoutParams(layoutParams3);
                }
            }
            lVar.ekx.setText(au.q(postData.getTime()));
            lVar.ekC.setVisibility(8);
            if (postData.big() == 1) {
                aq.k(lVar.ekp, w.e.cp_bg_line_d);
                lVar.ekq.setVisibility(8);
                lVar.ekH.setVisibility(8);
                lVar.ekD.setVisibility(8);
                lVar.ekx.setVisibility(8);
                lVar.ekC.setVisibility(0);
                lVar.ekF.setVisibility(8);
                lVar.ekG.setVisibility(8);
                lVar.ekW.setVisibility(8);
                lVar.ekQ.setVisibility(8);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                lVar.ekC.a(postData.bin(), str, j, com.baidu.adp.lib.g.b.c(this.ekc.aIB().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                lVar.ekC.onChangeSkinType();
                if (this.ekb) {
                    PraiseData rk = this.ekc.aIB().rk();
                    if (rk != null && rk.getUser() != null && rk.getUser().size() > 0) {
                        lVar.ekA.setVisibility(0);
                        lVar.ekB.setVisibility(0);
                        lVar.ekA.setIsFromPb(true);
                        lVar.ekA.a(rk, this.ekc.aIB().getId(), rk.getPostId(), true);
                        lVar.ekA.dn(this.mSkinType);
                    } else {
                        lVar.ekA.setVisibility(8);
                        lVar.ekB.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.aj(lVar.ekA);
                    com.baidu.tieba.graffiti.c.aj(lVar.ekB);
                } else {
                    lVar.ekA.setVisibility(8);
                    lVar.ekB.setVisibility(8);
                }
                a(lVar.ekz, getDimensionPixelSize(w.f.ds30));
                if (!this.elf.aKl()) {
                    if (this.ekc.aIW() != null && this.ekc.aIW().size() <= 4) {
                        lVar.elb.setVisibility(0);
                        List<be> aIW = this.ekc.aIW();
                        for (int i2 = 0; i2 < aIW.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, lVar.ekX, aIW);
                            } else if (i2 == 1) {
                                a(i2, lVar.ekY, aIW);
                            } else if (i2 == 2) {
                                a(i2, lVar.ekZ, aIW);
                            } else if (i2 == 3) {
                                a(i2, lVar.ela, aIW);
                            }
                        }
                    }
                } else {
                    lVar.elb.setVisibility(8);
                }
            } else {
                lVar.elb.setVisibility(8);
                lVar.ekH.setVisibility(0);
                aq.k(lVar.ekp, w.e.cp_bg_line_e);
                lVar.ekq.setVisibility(0);
                com.baidu.tbadk.data.g bij = postData.bij();
                lVar.ekQ.setVisibility(8);
                if (bij != null && !TextUtils.isEmpty(bij.getName()) && !TextUtils.isEmpty(bij.getName().trim())) {
                    String name = bij.getName();
                    String lat = bij.getLat();
                    String lng = bij.getLng();
                    lVar.ekU.setText(bij.getName());
                    aq.c(lVar.ekU, w.e.cp_cont_c, 1);
                    lVar.ekU.setOnClickListener(new j(this, lat, lng, name));
                } else {
                    lVar.ekU.setVisibility(8);
                }
                lVar.ekA.setVisibility(8);
                lVar.ekB.setVisibility(8);
                lVar.ekD.setVisibility(0);
                lVar.ekx.setVisibility(0);
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.big()));
                lVar.ekw.setVisibility(0);
                lVar.ekw.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                lVar.eky.setVisibility(0);
                aq.i(lVar.eky, w.e.cp_link_tip_a);
            } else {
                lVar.eky.setVisibility(8);
            }
            aq.j(lVar.ekr, w.g.bg_floor_new_middle);
            lVar.ekz.setVideoImageId(w.g.pic_video);
            lVar.ekz.setTextColor(aq.getColor(w.e.common_color_10039));
            lVar.ekz.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.big()));
            if (postData.bik() > 0) {
                if (this.ekd == null) {
                    this.ekd = new ba(this.mContext);
                    this.ekd.setIsFromCDN(this.mIsFromCDN);
                    this.ekd.J(this.ekf);
                    boolean z6 = false;
                    String userId2 = this.ekc.aIB().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.ekd.A(this.ekc.aIM(), z6);
                    this.ekd.N(this.ekc.aIB());
                }
                this.ekd.ok(postData.getId());
                lVar.ekE.setVisibility(0);
                lVar.ekE.a(postData, view);
                lVar.ekE.setChildOnClickListener(this.cvw);
                lVar.ekE.setChildOnLongClickListener(this.atb);
                lVar.ekE.setChildOnTouchListener(this.aOc);
                lVar.ekE.setSubPbAdapter(this.ekd);
                lVar.ekE.setVisibility(0);
                lVar.ekG.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds24));
                lVar.ekW.setVisibility(0);
            } else {
                lVar.ekG.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
                lVar.ekE.setVisibility(8);
                lVar.ekW.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = x.gn(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gn = x.gn(name_show);
                if (i3 > 0) {
                    if (gn > 12) {
                        name_show = String.valueOf(x.d(name_show, 0, 14)) + "...";
                    }
                } else if (gn > 14) {
                    name_show = String.valueOf(x.d(name_show, 0, 14)) + "...";
                }
                if (i3 > 0) {
                    lVar.bAh.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    lVar.bAh.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aq.c(lVar.bAh, w.e.cp_cont_h, 1);
                } else {
                    aq.c(lVar.bAh, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    lVar.eku.setVisibility(0);
                    aq.c(lVar.eku, BitmapHelper.getGradeResourceIdNew(level_id));
                    lVar.eku.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id)));
                    lVar.eku.setOnClickListener(null);
                } else {
                    lVar.eku.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aq.c(lVar.ekv, w.g.pb_manager);
                        lVar.eku.setVisibility(8);
                        lVar.ekv.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aq.c(lVar.ekv, w.g.pb_assist);
                        lVar.eku.setVisibility(8);
                        lVar.ekv.setVisibility(0);
                    }
                }
                int gn2 = x.gn(postData.getAuthor().getName_show());
                if (gn2 >= 14 && lVar.eku.getVisibility() == 0 && lVar.eky.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gn2 < 12 || lVar.eku.getVisibility() != 0 || lVar.eky.getVisibility() != 0) ? i4 : i4 - 1;
                this.eke = postData.getAuthor().getIconInfo();
                this.cXF = postData.getAuthor().getTShowInfoNew();
                if (lVar.ciK != null) {
                    lVar.ciK.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    lVar.ciK.setOnClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ccV);
                    lVar.ciK.a(this.eke, i5, getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds10));
                }
                if (lVar.amk != null) {
                    lVar.amk.setOnClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ewB);
                    lVar.amk.a(this.cXF, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds32), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pL())) {
                lVar.ekt.setVisibility(4);
                lVar.eks.setVisibility(0);
                lVar.eks.dP(postData.getAuthor().getPendantData().pL());
                lVar.eks.getHeadView().c(portrait, 28, false);
                lVar.eks.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                lVar.eks.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                lVar.ekt.setVisibility(0);
                lVar.eks.setVisibility(8);
                lVar.ekt.setUserId(postData.getAuthor().getUserId());
                lVar.ekt.setUserName(postData.getAuthor().getUserName());
                lVar.ekt.setImageDrawable(null);
                lVar.ekt.c(portrait, 28, false);
            }
            lVar.bAh.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            lVar.bAh.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            lVar.ekz.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            if (this.eka) {
                lVar.ekz.setDefaultImageId(w.g.transparent_bg);
            } else {
                lVar.ekz.setDefaultImageId(w.g.icon_click);
            }
            lVar.ekz.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.avd();
            }
            if (this.ekg || !this.ekh) {
                lVar.ekz.a(tbRichText, false);
            } else {
                lVar.ekz.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.ekc.aIM() != 0) {
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
            if (this.ekc != null && this.ekc.aIB() != null && this.ekc.aIB().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.ekc.aIB().getAuthor().getUserId();
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
                        if (lVar.ekL != null) {
                            lVar.ekL.setVisibility(0);
                            lVar.ekL.setText(w.l.manage);
                            lVar.ekL.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (lVar.ekL != null) {
                            lVar.ekL.setVisibility(0);
                            lVar.ekL.setText(w.l.delete);
                            lVar.ekL.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (lVar.ekL != null) {
                        lVar.ekL.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.big() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ekc.aIM()));
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
                        if (this.ekc.aIB() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.ekc.aIB().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ekc.aIM()));
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    a(lVar, postData, postData.big() != 1, tbRichText);
                    b(lVar);
                    a(view, postData);
                    if (this.ekk == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.ekk.bmw();
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
            int i62 = 1;
            if (postData.big() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(lVar, postData, postData.big() != 1, tbRichText);
            b(lVar);
            a(view, postData);
            if (this.ekk == null) {
            }
        }
    }

    private void b(l lVar) {
        lVar.ekz.setTextViewOnTouchListener(this.aOc);
        lVar.ekz.setTextViewCheckSelection(false);
    }

    private void a(l lVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aOB() == null || f(postData)) {
            lVar.ekV.setVisibility(8);
        } else {
            aa.a(postData.aOB(), lVar.ekV, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ekj - (i - this.eki));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean f(PostData postData) {
        return (this.ekc == null || this.ekc.aIB() == null || !this.ekc.aIB().sg() || this.ekc.aIB().rj() == null || postData.big() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (f(postData) && view != null && this.elf != null) {
            if (this.ekk == null) {
                this.ekk = new com.baidu.tieba.vote.a(this.elf);
            }
            this.ekk.a(view, this.ekc);
        } else if (this.ekk != null) {
            this.ekk.setVisibility(8);
        }
    }

    private void c(l lVar) {
        lVar.bAh.setOnClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ewA);
        lVar.ekt.setOnClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ewA);
        lVar.eks.setOnClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ewA);
        lVar.ekD.setOnLongClickListener(this.atb);
        lVar.ekz.setOnLongClickListener(this.atb);
        lVar.ekD.setOnTouchListener(this.aOc);
        lVar.ekz.setOnTouchListener(this.aOc);
        lVar.ekz.setOnImageClickListener(this.aOb);
        lVar.ekz.setOnEmotionClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ewC);
        lVar.ciK.setOnClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ccV);
        lVar.amk.setOnClickListener(((PbActivity) this.elf.getPageContext().getOrignalPage()).elV.ewB);
        lVar.ekV.setOnClickListener(this.cvw);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ekc = fVar;
    }

    public void op(int i) {
        this.ejZ = i;
    }

    public void hZ(boolean z) {
        this.eka = z;
    }

    public void ia(boolean z) {
        this.ekb = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ekf = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cvw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOb = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atb = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return at.a((Context) this.elf.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<be> list) {
        if (textView != null) {
            be beVar = (be) com.baidu.tbadk.core.util.x.c(list, i);
            if (beVar == null) {
                textView.setVisibility(8);
                return;
            }
            String forumName = beVar.getForumName();
            String forumId = beVar.getForumId();
            textView.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new k(this, forumName, forumId));
        }
    }

    public void nM(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.elf.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
