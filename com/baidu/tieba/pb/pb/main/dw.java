package com.baidu.tieba.pb.pb.main;

import android.content.Context;
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
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dw extends cx<PostData, ec> implements View.OnClickListener {
    private TbRichTextView.e aNM;
    private boolean aiH;
    private View.OnLongClickListener atn;
    protected boolean cCs;
    private ArrayList<IconData> cYe;
    private View.OnClickListener csa;
    private View.OnClickListener ejA;
    private com.baidu.tieba.pb.a.d ejB;
    private boolean ejC;
    private final boolean ejD;
    private int ejE;
    private int ejF;
    protected int ejv;
    private boolean ejw;
    protected com.baidu.tieba.pb.data.f ejx;
    private com.baidu.tieba.pb.pb.sub.ba ejy;
    private ArrayList<IconData> ejz;
    private boolean ekX;
    private boolean emW;
    private TbRichTextView.b epu;
    private boolean epv;
    private String mHostId;

    private void init() {
        this.ejE = getDimensionPixelSize(w.f.ds30);
        this.ejF = com.baidu.adp.lib.util.k.af(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
        this.epu = null;
        this.ejC = false;
        this.ejD = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.emW = false;
        this.epv = false;
        this.ekX = false;
        this.aiH = false;
        init();
    }

    private void a(ec ecVar) {
        if (ecVar != null) {
            if (ecVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.k(ecVar.ejL, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(ecVar.ekd, w.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.aq.c(ecVar.bux, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c((View) ecVar.ejQ, w.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.aq.c((View) ecVar.ejR, w.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ejS, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ejT, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.j(ecVar.epK, w.g.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.aq.c(ecVar.epK, w.g.icon_pb_more_n);
                com.baidu.tbadk.core.util.aq.j(ecVar.epM, w.g.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.aq.c(ecVar.epM, w.g.icon_pb_more_n);
                ecVar.epO.onChangeSkinType();
                com.baidu.tbadk.core.util.aq.k(ecVar.ejW, w.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.aq.k(ecVar.ejX, w.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.aq.c(ecVar.ejX, w.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.aq.j(ecVar.epQ, w.g.btn_appdownload);
                com.baidu.tbadk.core.util.aq.c(ecVar.epQ, w.e.cp_cont_i, 1);
                ecVar.ejV.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039));
                com.baidu.tbadk.core.util.aq.c(ecVar.ekq, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ekp, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.eko, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(ecVar.ekn, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.j(ecVar.ejN, w.g.bg_floor_new_middle);
                com.baidu.tbadk.core.util.aq.k(ecVar.eka, w.e.cp_bg_line_e);
                c(ecVar);
            }
            ecVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public ec onCreateViewHolder(ViewGroup viewGroup) {
        ec ecVar = new ec(this.ekw.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.cCs, this.ejv);
        a(ecVar);
        return ecVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cx, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, ec ecVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, ecVar);
        a(ecVar);
        e(ecVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.tm();
            a(ecVar, postData2, view, i);
        }
        if (!this.ejC && this.ejD && ecVar != null && ecVar.ejV.Jb() && (listView = ((PbActivity) this.ekw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ejC = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private boolean ou(int i) {
        if (getItem(0) instanceof PostData) {
            PostData postData = (PostData) getItem(0);
            if (postData.bjp() == 1 && i == 1) {
                return true;
            }
            return postData.bjp() != 1 && i == 0;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v59, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0ed5  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0ee1  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0eed  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0f31  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0f34  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ec ecVar, PostData postData, View view, int i) {
        SparseArray sparseArray;
        UserTbVipInfoData userTbVipInfoData;
        TbRichText axm;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bjy;
        int i2;
        if (ecVar != null && postData != null) {
            ecVar.ekb.setVisibility(0);
            ecVar.ejP.setTag(null);
            ecVar.ejP.setUserId(null);
            ecVar.bux.setText((CharSequence) null);
            ecVar.ejR.setVisibility(8);
            ecVar.eka.setVisibility(0);
            ecVar.ejU.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) ecVar.ejZ.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                ecVar.ejZ.setTag(sparseArray3);
                ecVar.ejV.setTag(sparseArray3);
                ecVar.ejL.setTag(w.h.tag_from, sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar.ejV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            ecVar.ejV.setPadding(0, 0, 0, 0);
            if (!this.cCs) {
                if (postData.bjp() == 1) {
                    ecVar.ejV.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                    ecVar.ejV.setIsSupportVitality(false);
                }
            } else if (TextUtils.isEmpty(postData.getBimg_url())) {
                this.epv = false;
                sparseArray.put(w.h.tag_richtext_bg, null);
                ecVar.ejV.gv(null);
                ecVar.ejV.setBackgroundDrawable(null);
                if (postData.bjp() == 1) {
                    ecVar.ejV.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                    ecVar.ejV.setIsSupportVitality(false);
                }
            } else {
                this.epv = true;
                ecVar.ejV.setIsSupportVitality(false);
                if (postData.bjp() == 1) {
                    layoutParams.leftMargin = getDimensionPixelSize(w.f.ds30);
                } else {
                    layoutParams.leftMargin = 0;
                }
                layoutParams.rightMargin = getDimensionPixelSize(w.f.ds30);
                if (postData.aQc() == null) {
                    layoutParams.bottomMargin = getDimensionPixelSize(w.f.ds24);
                } else {
                    layoutParams.bottomMargin = getDimensionPixelSize(w.f.ds32);
                }
                layoutParams.topMargin = getDimensionPixelSize(w.f.ds24);
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                ecVar.ejV.gv(postData.getBimg_url());
            }
            ecVar.ejV.setLayoutParams(layoutParams);
            if (postData.bjp() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    ecVar.ejV.setOnClickListener(this.csa);
                    ecVar.ejV.setTextViewOnClickListener(this.csa);
                } else {
                    ecVar.ejV.setOnClickListener(null);
                    ecVar.ejV.setTextViewOnClickListener(null);
                }
                ecVar.ejL.setOnClickListener(this.csa);
                ecVar.ejZ.setOnClickListener(this.csa);
            } else {
                ecVar.ejL.setOnClickListener(null);
                ecVar.ejZ.setOnClickListener(null);
            }
            ecVar.ejT.setText(postData.bjr());
            if (postData.bjp() == 1) {
                a(ecVar.ejV, view, true, this.epv);
                ecVar.ekd.setVisibility(8);
                ecVar.ejM.setVisibility(8);
                ecVar.ekb.setVisibility(8);
                ecVar.ejZ.setVisibility(8);
                ecVar.ejT.setVisibility(8);
                ecVar.ekc.setVisibility(8);
                ecVar.eks.setVisibility(8);
                ecVar.ejY.setVisibility(0);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                if (this.ejx != null && this.ejx.aKy() != null) {
                    ecVar.ejY.a(postData.bjw(), str, j, com.baidu.adp.lib.g.b.c(this.ejx.aKy().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                ecVar.ejY.onChangeSkinType();
                if (this.ejw) {
                    PraiseData praiseData = null;
                    if (this.ejx != null && this.ejx.aKy() != null) {
                        this.ejx.aKy().se();
                    }
                    if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                        ecVar.ejW.setVisibility(0);
                        ecVar.ejX.setVisibility(0);
                        ecVar.ejW.setIsFromPb(true);
                        ecVar.ejW.a(null, this.ejx.aKy().getId(), praiseData.getPostId(), true);
                        ecVar.ejW.m24do(this.mSkinType);
                    } else {
                        ecVar.ejW.setVisibility(8);
                        ecVar.ejX.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.al(ecVar.ejW);
                    com.baidu.tieba.graffiti.c.al(ecVar.ejX);
                    ecVar.ekm.setVisibility(0);
                    ecVar.eko.setText(postData.bjr());
                    com.baidu.tbadk.data.g bjs = postData.bjs();
                    ecVar.ekq.setVisibility(8);
                    if (bjs != null && !TextUtils.isEmpty(bjs.getName()) && !TextUtils.isEmpty(bjs.getName().trim())) {
                        String name = bjs.getName();
                        String lat = bjs.getLat();
                        String lng = bjs.getLng();
                        ecVar.ekp.setVisibility(0);
                        com.baidu.adp.lib.util.k.a(this.mContext, ecVar.ekp, 0, 10, 0, 10);
                        ecVar.ekp.setText(bjs.getName());
                        ecVar.ekp.setOnClickListener(new dx(this, lat, lng, name));
                    } else {
                        ecVar.ekp.setVisibility(8);
                    }
                    if (this.ejx.aKP() != null && !StringUtils.isNull(this.ejx.aKP().qB(), true)) {
                        b(ecVar);
                    }
                } else {
                    ecVar.ejW.setVisibility(8);
                    ecVar.ejX.setVisibility(8);
                    if (postData.getAuthor() != null && postData.getAuthor().getGodInfo() != null) {
                        ecVar.ejY.jo(false);
                    } else {
                        ecVar.ejW.setVisibility(8);
                        ecVar.ejX.setVisibility(8);
                        ecVar.ekp.setVisibility(8);
                        ecVar.ekq.setVisibility(8);
                    }
                    if (this.ejx.aKP() != null && !StringUtils.isNull(this.ejx.aKP().qB(), true) && ecVar.epC != null) {
                        ecVar.epC.setVisibility(8);
                        ecVar.epH.EG();
                    }
                }
                if (this.ekw.aLr().aON()) {
                    ecVar.ejV.setVisibility(8);
                }
                if (this.ejx.aKy() != null && this.ejx.aKy().sA() != null) {
                    com.baidu.tbadk.core.data.bs sA = this.ejx.aKy().sA();
                    String activityUrl = sA.getActivityUrl();
                    String tK = sA.tK();
                    String tL = sA.tL();
                    if (!StringUtils.isNull(tL)) {
                        ecVar.epQ.setVisibility(0);
                        ecVar.epQ.setText(tL);
                        ecVar.epQ.setOnClickListener(new dy(this, activityUrl));
                        ecVar.epR.setOnClickListener(new dz(this, activityUrl));
                        if (!StringUtils.isNull(tK)) {
                            ecVar.bRB.setVisibility(0);
                            ecVar.bRB.c(tK, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    ecVar.epQ.setVisibility(8);
                    ecVar.bRB.setVisibility(8);
                }
                if (ecVar.epV != null) {
                    ecVar.epV.setVisibility(8);
                }
                if (this.ejx != null && this.ejx.aKy() != null && this.ejx.aKy().tb()) {
                    ecVar.epY.d(postData.Iy());
                    ecVar.ejV.setVisibility(8);
                    ecVar.ekm.setVisibility(8);
                    ecVar.epY.euH.setVisibility(8);
                } else {
                    ecVar.epY.euH.setVisibility(8);
                    ecVar.ekm.setVisibility(0);
                }
            } else {
                if (this.ejx.aKP() != null && !StringUtils.isNull(this.ejx.aKP().qB(), true) && ecVar.epC != null) {
                    ecVar.epC.setVisibility(8);
                }
                ecVar.ejV.setVisibility(0);
                a(ecVar.ejV, view, false, this.epv);
                ecVar.ejM.setVisibility(0);
                ecVar.ekc.setVisibility(0);
                ecVar.bRB.setVisibility(8);
                ecVar.epQ.setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = ecVar.ekd.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ecVar.ekb.getLayoutParams();
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) ecVar.ejZ.getLayoutParams();
                if (ou(i)) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20);
                    layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                    layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds6);
                } else {
                    layoutParams4.topMargin = 0;
                    layoutParams3.topMargin = 0;
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
                }
                ecVar.ekb.setLayoutParams(layoutParams3);
                ecVar.ejZ.setLayoutParams(layoutParams4);
                ecVar.ekd.setLayoutParams(layoutParams2);
                ecVar.ekd.setVisibility(0);
                ecVar.ejY.setVisibility(8);
                ecVar.ejW.setVisibility(8);
                ecVar.ejX.setVisibility(8);
                ecVar.ejZ.setVisibility(0);
                ecVar.ekb.setVisibility(0);
                ecVar.ejT.setVisibility(0);
                com.baidu.tbadk.data.g bjs2 = postData.bjs();
                ecVar.ekm.setVisibility(8);
                if (bjs2 != null && !TextUtils.isEmpty(bjs2.getName()) && !TextUtils.isEmpty(bjs2.getName().trim())) {
                    String name2 = bjs2.getName();
                    String lat2 = bjs2.getLat();
                    String lng2 = bjs2.getLng();
                    ecVar.ekq.setVisibility(0);
                    ecVar.ekq.setText(bjs2.getName());
                    ecVar.ekq.setOnClickListener(new ea(this, lat2, lng2, name2));
                } else {
                    ecVar.ekq.setVisibility(8);
                }
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bjp()));
                ecVar.ejS.setVisibility(0);
                ecVar.ejS.setText(format);
                if (ecVar.epV != null) {
                    if (postData.sJ() != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.ekb.getLayoutParams();
                        marginLayoutParams.topMargin = (int) this.ekw.getResources().getDimension(w.f.ds16);
                        ecVar.ekb.setLayoutParams(marginLayoutParams);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ecVar.epW.getLayoutParams();
                        marginLayoutParams2.topMargin = (int) this.ekw.getResources().getDimension(w.f.ds10);
                        ecVar.epW.setLayoutParams(marginLayoutParams2);
                        ecVar.epV.a(this.ekw.getPageContext(), postData.sJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", this.ejx.aKx().getId(), this.ejx.aKx().getName(), this.ejx.aKy().getId(), null));
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) ecVar.epX.getLayoutParams();
                        marginLayoutParams3.leftMargin = (int) this.ekw.getResources().getDimension(w.f.ds30);
                        marginLayoutParams3.rightMargin = (int) this.ekw.getResources().getDimension(w.f.ds30);
                        ecVar.epX.setLayoutParams(marginLayoutParams3);
                    } else {
                        ecVar.epV.a(null, null, null);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) ecVar.epX.getLayoutParams();
                        marginLayoutParams4.leftMargin = 0;
                        marginLayoutParams4.rightMargin = 0;
                        ecVar.epX.setLayoutParams(marginLayoutParams4);
                    }
                }
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                ecVar.ejU.setVisibility(0);
                com.baidu.tbadk.core.util.aq.i(ecVar.ejU, w.e.cp_link_tip_a);
            } else {
                ecVar.ejU.setVisibility(8);
            }
            ecVar.ejV.setVideoImageId(w.g.pic_video);
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(w.h.tag_clip_board, postData);
            sparseArray4.put(w.h.tag_load_sub_data, postData);
            sparseArray4.put(w.h.tag_load_sub_view, view);
            sparseArray4.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray4.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bjp()));
            if (postData.bjB()) {
                ecVar.epL.setVisibility(8);
                ecVar.epN.setVisibility(0);
                ecVar.epO.setVisibility(0);
                ecVar.epO.setTag(w.h.tag_clip_board, postData);
                ecVar.epM.setTag(sparseArray4);
                ecVar.epN.setTag(sparseArray4);
                ecVar.epO.a(postData.bjD(), postData.bjC(), false);
            } else {
                ecVar.epL.setVisibility(0);
                ecVar.epK.setTag(sparseArray4);
                ecVar.epL.setTag(sparseArray4);
                ecVar.epN.setVisibility(8);
                ecVar.epO.setVisibility(8);
            }
            if (postData.bjt() > 0 && postData.bjm() != null && postData.bjm().size() > 0) {
                if (this.ejy == null) {
                    this.ejy = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.ejy.setIsFromCDN(this.mIsFromCDN);
                    this.ejy.I(this.ejA);
                    boolean z7 = false;
                    String userId = this.ejx.aKy().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.ejy.B(this.ejx.aKI(), z7);
                    this.ejy.h(this.ejx.aKy());
                }
                this.ejy.nQ(postData.getId());
                ecVar.eka.setVisibility(0);
                ecVar.eka.a(postData, view);
                ecVar.eka.setChildOnClickListener(this.csa);
                ecVar.eka.setChildOnLongClickListener(this.atn);
                ecVar.eka.setChildOnTouchListener(this.ejB);
                ecVar.eka.setSubPbAdapter(this.ejy);
                ecVar.eka.setVisibility(0);
                ecVar.eks.setVisibility(0);
                ecVar.eks.invalidate();
                ecVar.ekc.setPadding(0, 0, 0, 0);
            } else {
                ecVar.ekc.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds26));
                ecVar.eka.setVisibility(8);
                ecVar.eks.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gq = com.baidu.tbadk.util.u.gq(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gq > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 12)) + "...";
                    }
                } else if (gq > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    ecVar.bux.setText(af(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    ecVar.bux.setText(name_show);
                }
                if (ecVar.epB != null && postData.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = postData.getAuthor().getAlaUserData();
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        ecVar.epB.setVisibility(8);
                    } else {
                        ecVar.epB.setVisibility(0);
                        com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                        bVar.QS = alaUserData;
                        bVar.type = 3;
                        ecVar.epB.setTag(bVar);
                    }
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.aq.c(ecVar.bux, w.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aq.c(ecVar.bux, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                if (level_id != 0) {
                    ecVar.ejQ.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.c(ecVar.ejQ, BitmapHelper.getGradeResourceIdNew(level_id));
                    String bjA = postData.bjA();
                    if (StringUtils.isNull(bjA)) {
                        bjA = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id));
                    }
                    ecVar.ejQ.setContentDescription(bjA);
                    ecVar.ejQ.setOnClickListener(null);
                } else {
                    ecVar.ejQ.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.aq.c(ecVar.ejR, w.g.pb_manager);
                        ecVar.ejQ.setVisibility(8);
                        ecVar.ejR.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.aq.c(ecVar.ejR, w.g.pb_assist);
                        ecVar.ejQ.setVisibility(8);
                        ecVar.ejR.setVisibility(0);
                    }
                    if (ecVar.ejR.getVisibility() == 0) {
                        ecVar.ejR.setAlpha(179);
                    }
                }
                if (ecVar.ejQ.getVisibility() == 0) {
                    ecVar.ejQ.setAlpha(179);
                }
                int gq2 = com.baidu.tbadk.util.u.gq(postData.getAuthor().getName_show());
                if (gq2 < 14 || ecVar.ejQ.getVisibility() != 0 || ecVar.ejU.getVisibility() != 0) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                int i3 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gq2 < 12 || ecVar.ejQ.getVisibility() != 0 || ecVar.ejU.getVisibility() != 0) ? i2 : i2 - 1;
                this.ejz = postData.getAuthor().getIconInfo();
                this.cYe = postData.getAuthor().getTShowInfoNew();
                if (ecVar.cfz != null) {
                    if (com.baidu.tbadk.core.util.x.q(this.ejz)) {
                        ecVar.cfz.setVisibility(8);
                    } else {
                        ecVar.cfz.setVisibility(0);
                    }
                    ecVar.cfz.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    ecVar.cfz.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.bYW);
                    ecVar.cfz.xr();
                    ecVar.cfz.a(this.ejz, i3, getDimensionPixelSize(w.f.ds24), getDimensionPixelSize(w.f.ds24), getDimensionPixelSize(w.f.ds10));
                }
                if (ecVar.ams != null) {
                    ecVar.ams.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.eub);
                    if (this.cYe != null && this.cYe.size() > 0 && this.cYe.get(0) != null) {
                        ecVar.ams.setTag(this.cYe.get(0).getUrl());
                    }
                    ecVar.ams.a(this.cYe, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData.getAuthor() == null || postData.getAuthor().getUserTbVipInfoData() == null) {
                userTbVipInfoData = null;
            } else {
                userTbVipInfoData = postData.getAuthor().getUserTbVipInfoData();
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().qB())) {
                ecVar.ejP.setVisibility(4);
                ecVar.epP.setVisibility(8);
                ecVar.ejO.setVisibility(0);
                ecVar.epP.setVisibility(8);
                ecVar.ejO.getHeadView().setUserId(postData.getAuthor().getUserId());
                ecVar.ejO.getHeadView().ad(postData.getAuthor().getUserName(), postData.bjz());
                ecVar.ejO.getHeadView().setImageDrawable(null);
                ecVar.ejO.getHeadView().c(portrait, 28, false);
                ecVar.ejO.dU(postData.getAuthor().getPendantData().qB());
                ecVar.ejO.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                ecVar.ejO.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
                ecVar.ejO.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
            } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                if (ecVar.bbW != null) {
                    if (ecVar.bbX == null) {
                        ecVar.bbW.inflate();
                        ecVar.bbX = (TbImageView) ecVar.getView().findViewById(w.h.user_head_mask);
                    }
                    if (ecVar.bbX != null) {
                        ecVar.bbX.c(userTbVipInfoData.getvipV_url(), 10, false);
                    }
                    ecVar.epP.setIsBigV(true);
                }
                ecVar.ejP.setVisibility(4);
                ecVar.epP.setVisibility(0);
                ecVar.ejO.setVisibility(8);
                ecVar.epP.setData(postData.getAuthor());
                ecVar.epP.setUserId(postData.getAuthor().getUserId());
                ecVar.epP.ad(postData.getAuthor().getUserName(), postData.bjz());
            } else {
                ecVar.ejO.setVisibility(8);
                if (f(postData)) {
                    ecVar.ejP.setVisibility(4);
                    ecVar.epP.setVisibility(0);
                    ecVar.epP.c(portrait, 28, false);
                    ecVar.epP.setUserId(postData.getAuthor().getUserId());
                    ecVar.epP.ad(postData.getAuthor().getUserName(), postData.bjz());
                    ecVar.epP.setOnClickListener(((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj.eua);
                } else {
                    ecVar.ejP.setVisibility(0);
                    ecVar.epP.setVisibility(8);
                    ecVar.ejP.setUserId(postData.getAuthor().getUserId());
                    ecVar.ejP.ad(postData.getAuthor().getUserName(), postData.bjz());
                    ecVar.ejP.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    ecVar.ejP.setImageDrawable(null);
                    ecVar.ejP.c(portrait, 28, false);
                }
            }
            ecVar.bux.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            ecVar.bux.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            ecVar.bux.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
            ecVar.ejV.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            if (this.cCs) {
                ecVar.ejV.setDefaultImageId(w.g.transparent_bg);
            } else {
                ecVar.ejV.setDefaultImageId(w.g.icon_click);
            }
            ecVar.ejV.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                axm = null;
            } else {
                axm = postData.axm();
            }
            if (this.ejC || !this.ejD) {
                ecVar.ejV.a(axm, false, this.epu);
            } else {
                ecVar.ejV.a(axm, true, this.epu);
            }
            boolean z8 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (this.ejx != null && this.ejx.aKI() != 0) {
                z9 = true;
                z10 = true;
                if (postData != null && postData.getAuthor() != null) {
                    String userId2 = postData.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.ejx != null && this.ejx.aKy() != null && this.ejx.aKy().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.ejx.aKy().getAuthor().getUserId();
                String userId4 = postData.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId4)) {
                        z2 = false;
                        z11 = true;
                    }
                    if (postData == null && postData.getAuthor() != null && UtilHelper.isCurrentAccount(postData.getAuthor().getUserId())) {
                        z3 = true;
                        z4 = true;
                    } else {
                        boolean z12 = z11;
                        z3 = z;
                        z4 = z12;
                    }
                    if (z8) {
                        z5 = z2;
                        z6 = z3;
                    } else {
                        z9 = false;
                        z6 = false;
                        z5 = false;
                    }
                    int i4 = 1;
                    if (postData.bjp() == 1) {
                        i4 = 0;
                    }
                    sparseArray4.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray4.put(w.h.tag_should_manage_visible, true);
                        sparseArray4.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejx.aKI()));
                        sparseArray4.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray4.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray4.put(w.h.tag_user_mute_visible, true);
                        sparseArray4.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray4.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray4.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.ejx.aKy() != null) {
                            sparseArray4.put(w.h.tag_user_mute_thread_id, this.ejx.aKy().getId());
                        }
                        sparseArray4.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray4.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray4.put(w.h.tag_should_delete_visible, true);
                        sparseArray4.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejx.aKI()));
                        sparseArray4.put(w.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray4.put(w.h.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray4.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray4.put(w.h.tag_should_delete_visible, false);
                    }
                    bjy = postData.bjy();
                    if (bjy.size() > 0 || (postData.bjp() == 1 && this.ekw.aLr().aON())) {
                        ecVar.epS.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar2 = bjy.get(0);
                        if (!StringUtils.isNull(bVar2.getIconUrl())) {
                            a(ecVar, bVar2.getIconUrl());
                            if (!StringUtils.isNull(bVar2.Cy())) {
                                ecVar.epS.setTag(w.h.tag_pb_lottery_tail_link, bVar2.Cy());
                            }
                        } else {
                            ecVar.epS.setVisibility(8);
                        }
                    }
                    a(ecVar, postData, postData.bjp() != 1, axm);
                    d(ecVar);
                }
            }
            z = z10;
            z2 = false;
            if (postData == null) {
            }
            boolean z122 = z11;
            z3 = z;
            z4 = z122;
            if (z8) {
            }
            int i42 = 1;
            if (postData.bjp() == 1) {
            }
            sparseArray4.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z9) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            bjy = postData.bjy();
            if (bjy.size() > 0) {
            }
            ecVar.epS.setVisibility(8);
            a(ecVar, postData, postData.bjp() != 1, axm);
            d(ecVar);
        }
    }

    private void b(ec ecVar) {
        if (ecVar != null && this.ejx != null && this.ejx.aKP() != null) {
            ecVar.aNB();
            ecVar.epC.setOnClickListener(this.csa);
            com.baidu.tieba.pb.data.h aKP = this.ejx.aKP();
            ecVar.epH.setSupportNoImage(true);
            ecVar.epH.setInterceptOnClick(true);
            if (this.cCs) {
                ecVar.epH.setDefaultResource(w.g.transparent_bg);
                ecVar.epH.c(aKP.qB(), 17, false);
            } else {
                ecVar.epH.setDefaultResource(w.g.icon_click);
            }
            ecVar.epH.setOnClickListener(this.csa);
            ecVar.epG.setOnClickListener(this.csa);
            int aKT = aKP.aKT();
            String aKU = StringUtils.isNull(aKP.aKU(), true) ? "" : aKP.aKU();
            String string = this.mContext.getString(w.l.yule_head_img);
            if (aKT <= 0) {
                ecVar.epF.setVisibility(8);
                ecVar.epG.setVisibility(8);
            } else {
                ecVar.epF.setVisibility(0);
                ecVar.epG.setVisibility(0);
                if (aKT > 20) {
                    string = String.format(this.mContext.getString(w.l.yule_head_img_rank), "20+");
                } else {
                    string = String.format(this.mContext.getString(w.l.yule_head_img_rank), new StringBuilder(String.valueOf(aKT)).toString());
                }
                ecVar.epF.setText(" " + aKU);
            }
            ecVar.epE.setText(string);
            if (aKP.qy()) {
                ecVar.epI.setVisibility(8);
            } else {
                ecVar.epI.setVisibility(0);
                ecVar.epI.setText(String.format(this.mContext.getString(w.l.star_cover_pic_author), aKP.qA()));
            }
            if (StringUtils.isNull(this.ejx.aKy().getAuthor().getName_show(), true)) {
                ecVar.epJ.setVisibility(8);
            } else {
                ecVar.epJ.setVisibility(0);
                ecVar.epJ.setText(String.format(this.mContext.getString(w.l.star_cover_post_author), this.ejx.aKy().getAuthor().getName_show()));
            }
            if (ecVar.ekm.getVisibility() == 0) {
                View findViewById = ecVar.ejL.findViewById(w.h.yule_head_img_blank);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ecVar.ekm.getLayoutParams();
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams != null && marginLayoutParams != null && layoutParams.height == getDimensionPixelSize(w.f.ds72)) {
                    layoutParams.height -= marginLayoutParams.topMargin;
                }
            }
            c(ecVar);
        }
    }

    private void c(ec ecVar) {
        if (ecVar.epC != null) {
            com.baidu.tbadk.core.util.aq.k(ecVar.epD, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(ecVar.epE, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(ecVar.epF, w.e.cp_cont_e);
            com.baidu.tbadk.core.util.aq.i(ecVar.epG, w.e.cp_link_tip_a);
            com.baidu.tbadk.core.util.aq.i(ecVar.epI, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(ecVar.epJ, w.e.cp_cont_i);
        }
    }

    private void a(ec ecVar, String str) {
        ecVar.epS.setVisibility(0);
        com.baidu.adp.lib.f.c.fM().a(str, 17, new eb(this, ecVar, str), this.ekw.getUniqueId());
    }

    private void d(ec ecVar) {
        ecVar.ejV.setTextViewOnTouchListener(this.ejB);
        ecVar.ejV.setTextViewCheckSelection(false);
    }

    private void a(ec ecVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aQc() == null) {
            ecVar.ekr.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aQc(), ecVar.ekr, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1160=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int af = (((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i = 0;
        if (!z) {
            i = getDimensionPixelSize(w.f.ds132);
        } else if (z2) {
            i = getDimensionPixelSize(w.f.ds64);
        }
        int min = Math.min(af - i, this.ejv);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private boolean f(PostData postData) {
        return (postData == null || postData.getAuthor() == null || postData.getAuthor().getGodUserData() == null || postData.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void e(ec ecVar) {
        ecVar.ejL.setOnTouchListener(this.ejB);
        ecVar.ejL.setOnLongClickListener(this.atn);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.ekw.getPageContext().getOrignalPage()).elj;
        ecVar.bux.setOnClickListener(aVar.eua);
        ecVar.ejP.setOnClickListener(aVar.eua);
        ecVar.ejO.setOnClickListener(aVar.eua);
        ecVar.ejZ.setOnLongClickListener(this.atn);
        ecVar.ejV.setOnLongClickListener(this.atn);
        ecVar.ejZ.setOnTouchListener(this.ejB);
        ecVar.ejV.setOnTouchListener(this.ejB);
        ecVar.ejV.setCommonTextViewOnClickListener(this.csa);
        ecVar.ejV.setOnImageClickListener(this.aNM);
        ecVar.ejV.setOnEmotionClickListener(aVar.euc);
        ecVar.cfz.setOnClickListener(aVar.bYW);
        ecVar.ams.setOnClickListener(aVar.eub);
        ecVar.ekr.setOnClickListener(this.csa);
        ecVar.epS.setOnClickListener(this.csa);
        ecVar.epK.setOnClickListener(this.csa);
        ecVar.epL.setOnClickListener(this.csa);
        ecVar.epM.setOnClickListener(this.csa);
        ecVar.epN.setOnClickListener(this.csa);
        ecVar.epO.setOnClickListener(this.csa);
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

    public void im(boolean z) {
        this.emW = z;
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

    public void iq(boolean z) {
        this.ekX = z;
    }

    public void a(TbRichTextView.b bVar) {
        this.epu = bVar;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.ekw.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
