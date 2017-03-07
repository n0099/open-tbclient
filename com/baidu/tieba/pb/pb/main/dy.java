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
public class dy extends cz<PostData, ee> implements View.OnClickListener {
    private TbRichTextView.e aNu;
    private boolean ais;
    private View.OnLongClickListener asV;
    protected boolean cBC;
    private ArrayList<IconData> cXq;
    private View.OnClickListener crj;
    protected int eiZ;
    private boolean eja;
    protected com.baidu.tieba.pb.data.f ejb;
    private com.baidu.tieba.pb.pb.sub.ba ejc;
    private ArrayList<IconData> ejd;
    private View.OnClickListener eje;
    private com.baidu.tieba.pb.a.d ejf;
    private boolean ejg;
    private final boolean ejh;
    private int eji;
    private int ejj;
    private boolean ekC;
    private boolean emy;
    private TbRichTextView.b eoU;
    private boolean eoV;
    private String mHostId;

    private void init() {
        this.eji = getDimensionPixelSize(w.f.ds30);
        this.ejj = com.baidu.adp.lib.util.k.ag(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
        this.eoU = null;
        this.ejg = false;
        this.ejh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.emy = false;
        this.eoV = false;
        this.ekC = false;
        this.ais = false;
        init();
    }

    private void a(ee eeVar) {
        if (eeVar != null) {
            if (eeVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.k(eeVar.ejp, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(eeVar.ejH, w.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.aq.c(eeVar.bsn, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c((View) eeVar.eju, w.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.aq.c((View) eeVar.ejv, w.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.aq.c(eeVar.ejw, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(eeVar.ejx, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.j(eeVar.epk, w.g.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.aq.c(eeVar.epk, w.g.icon_pb_more_n);
                com.baidu.tbadk.core.util.aq.j(eeVar.epm, w.g.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.aq.c(eeVar.epm, w.g.icon_pb_more_n);
                eeVar.epo.tD();
                com.baidu.tbadk.core.util.aq.k(eeVar.ejA, w.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.aq.k(eeVar.ejB, w.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.aq.c(eeVar.ejB, w.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.aq.j(eeVar.epq, w.g.btn_appdownload);
                com.baidu.tbadk.core.util.aq.c(eeVar.epq, w.e.cp_cont_i, 1);
                eeVar.ejz.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10039));
                com.baidu.tbadk.core.util.aq.c(eeVar.ejU, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(eeVar.ejT, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(eeVar.ejS, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.c(eeVar.ejR, w.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.aq.j(eeVar.ejr, w.g.bg_floor_new_middle);
                com.baidu.tbadk.core.util.aq.k(eeVar.ejE, w.e.cp_bg_line_e);
                c(eeVar);
            }
            eeVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public ee onCreateViewHolder(ViewGroup viewGroup) {
        ee eeVar = new ee(this.eka.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.cBC, this.eiZ);
        a(eeVar);
        return eeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cz, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, ee eeVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, eeVar);
        a(eeVar);
        e(eeVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sO();
            a(eeVar, postData2, view, i);
        }
        if (!this.ejg && this.ejh && eeVar != null && eeVar.ejz.IC() && (listView = ((PbActivity) this.eka.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ejg = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private boolean oq(int i) {
        if (getItem(0) instanceof PostData) {
            PostData postData = (PostData) getItem(0);
            if (postData.bhD() == 1 && i == 1) {
                return true;
            }
            return postData.bhD() != 1 && i == 0;
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
    private void a(ee eeVar, PostData postData, View view, int i) {
        SparseArray sparseArray;
        UserTbVipInfoData userTbVipInfoData;
        TbRichText aws;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bhM;
        int i2;
        if (eeVar != null && postData != null) {
            eeVar.ejF.setVisibility(0);
            eeVar.ejt.setTag(null);
            eeVar.ejt.setUserId(null);
            eeVar.bsn.setText((CharSequence) null);
            eeVar.ejv.setVisibility(8);
            eeVar.ejE.setVisibility(0);
            eeVar.ejy.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) eeVar.ejD.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                eeVar.ejD.setTag(sparseArray3);
                eeVar.ejz.setTag(sparseArray3);
                eeVar.ejp.setTag(w.h.tag_from, sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eeVar.ejz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            eeVar.ejz.setPadding(0, 0, 0, 0);
            if (!this.cBC) {
                if (postData.bhD() == 1) {
                    eeVar.ejz.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                    eeVar.ejz.setIsSupportVitality(false);
                }
            } else if (TextUtils.isEmpty(postData.getBimg_url())) {
                this.eoV = false;
                sparseArray.put(w.h.tag_richtext_bg, null);
                eeVar.ejz.gp(null);
                eeVar.ejz.setBackgroundDrawable(null);
                if (postData.bhD() == 1) {
                    eeVar.ejz.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                    eeVar.ejz.setIsSupportVitality(false);
                }
            } else {
                this.eoV = true;
                eeVar.ejz.setIsSupportVitality(false);
                if (postData.bhD() == 1) {
                    layoutParams.leftMargin = getDimensionPixelSize(w.f.ds30);
                } else {
                    layoutParams.leftMargin = 0;
                }
                layoutParams.rightMargin = getDimensionPixelSize(w.f.ds30);
                if (postData.aOS() == null) {
                    layoutParams.bottomMargin = getDimensionPixelSize(w.f.ds24);
                } else {
                    layoutParams.bottomMargin = getDimensionPixelSize(w.f.ds32);
                }
                layoutParams.topMargin = getDimensionPixelSize(w.f.ds24);
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                eeVar.ejz.gp(postData.getBimg_url());
            }
            eeVar.ejz.setLayoutParams(layoutParams);
            if (postData.bhD() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    eeVar.ejz.setOnClickListener(this.crj);
                    eeVar.ejz.setTextViewOnClickListener(this.crj);
                } else {
                    eeVar.ejz.setOnClickListener(null);
                    eeVar.ejz.setTextViewOnClickListener(null);
                }
                eeVar.ejp.setOnClickListener(this.crj);
                eeVar.ejD.setOnClickListener(this.crj);
            } else {
                eeVar.ejp.setOnClickListener(null);
                eeVar.ejD.setOnClickListener(null);
            }
            eeVar.ejx.setText(postData.bhF());
            if (postData.bhD() == 1) {
                a(eeVar.ejz, view, true, this.eoV);
                eeVar.ejH.setVisibility(8);
                eeVar.ejq.setVisibility(8);
                eeVar.ejF.setVisibility(8);
                eeVar.ejD.setVisibility(8);
                eeVar.ejx.setVisibility(8);
                eeVar.ejG.setVisibility(8);
                eeVar.ejW.setVisibility(8);
                eeVar.ejC.setVisibility(0);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                if (this.ejb != null && this.ejb.aJq() != null) {
                    eeVar.ejC.a(postData.bhK(), str, j, com.baidu.adp.lib.g.b.c(this.ejb.aJq().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                eeVar.ejC.tD();
                if (this.eja) {
                    PraiseData praiseData = null;
                    if (this.ejb != null && this.ejb.aJq() != null) {
                        this.ejb.aJq().rG();
                    }
                    if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                        eeVar.ejA.setVisibility(0);
                        eeVar.ejB.setVisibility(0);
                        eeVar.ejA.setIsFromPb(true);
                        eeVar.ejA.a(null, this.ejb.aJq().getId(), praiseData.getPostId(), true);
                        eeVar.ejA.dl(this.mSkinType);
                    } else {
                        eeVar.ejA.setVisibility(8);
                        eeVar.ejB.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.an(eeVar.ejA);
                    com.baidu.tieba.graffiti.c.an(eeVar.ejB);
                    eeVar.ejQ.setVisibility(0);
                    eeVar.ejS.setText(postData.bhF());
                    com.baidu.tbadk.data.g bhG = postData.bhG();
                    eeVar.ejU.setVisibility(8);
                    if (bhG != null && !TextUtils.isEmpty(bhG.getName()) && !TextUtils.isEmpty(bhG.getName().trim())) {
                        String name = bhG.getName();
                        String lat = bhG.getLat();
                        String lng = bhG.getLng();
                        eeVar.ejT.setVisibility(0);
                        com.baidu.adp.lib.util.k.a(this.mContext, eeVar.ejT, 0, 10, 0, 10);
                        eeVar.ejT.setText(bhG.getName());
                        eeVar.ejT.setOnClickListener(new dz(this, lat, lng, name));
                    } else {
                        eeVar.ejT.setVisibility(8);
                    }
                    if (this.ejb.aJH() != null && !StringUtils.isNull(this.ejb.aJH().qd(), true)) {
                        b(eeVar);
                    }
                } else {
                    eeVar.ejA.setVisibility(8);
                    eeVar.ejB.setVisibility(8);
                    if (postData.getAuthor() != null && postData.getAuthor().getGodInfo() != null) {
                        eeVar.ejC.jf(false);
                    } else {
                        eeVar.ejA.setVisibility(8);
                        eeVar.ejB.setVisibility(8);
                        eeVar.ejT.setVisibility(8);
                        eeVar.ejU.setVisibility(8);
                    }
                    if (this.ejb.aJH() != null && !StringUtils.isNull(this.ejb.aJH().qd(), true) && eeVar.epc != null) {
                        eeVar.epc.setVisibility(8);
                        eeVar.eph.Ei();
                    }
                }
                if (this.eka.aKj().aND()) {
                    eeVar.ejz.setVisibility(8);
                }
                if (this.ejb.aJq() != null && this.ejb.aJq().sc() != null) {
                    com.baidu.tbadk.core.data.bt sc = this.ejb.aJq().sc();
                    String activityUrl = sc.getActivityUrl();
                    String tm = sc.tm();
                    String tn = sc.tn();
                    if (!StringUtils.isNull(tn)) {
                        eeVar.epq.setVisibility(0);
                        eeVar.epq.setText(tn);
                        eeVar.epq.setOnClickListener(new ea(this, activityUrl));
                        eeVar.epr.setOnClickListener(new eb(this, activityUrl));
                        if (!StringUtils.isNull(tm)) {
                            eeVar.bPv.setVisibility(0);
                            eeVar.bPv.c(tm, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    eeVar.epq.setVisibility(8);
                    eeVar.bPv.setVisibility(8);
                }
                if (eeVar.epv != null) {
                    eeVar.epv.setVisibility(8);
                }
                if (this.ejb != null && this.ejb.aJq() != null && this.ejb.aJq().sD()) {
                    eeVar.epy.d(postData.HZ());
                    eeVar.ejz.setVisibility(8);
                    eeVar.ejQ.setVisibility(8);
                    eeVar.epy.bXT.setVisibility(8);
                } else {
                    eeVar.epy.bXT.setVisibility(8);
                    eeVar.ejQ.setVisibility(0);
                }
            } else {
                if (this.ejb.aJH() != null && !StringUtils.isNull(this.ejb.aJH().qd(), true) && eeVar.epc != null) {
                    eeVar.epc.setVisibility(8);
                }
                eeVar.ejz.setVisibility(0);
                a(eeVar.ejz, view, false, this.eoV);
                eeVar.ejq.setVisibility(0);
                eeVar.ejG.setVisibility(0);
                eeVar.bPv.setVisibility(8);
                eeVar.epq.setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = eeVar.ejH.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) eeVar.ejF.getLayoutParams();
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) eeVar.ejD.getLayoutParams();
                if (oq(i)) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20);
                    layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                    layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds6);
                } else {
                    layoutParams4.topMargin = 0;
                    layoutParams3.topMargin = 0;
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1);
                }
                eeVar.ejF.setLayoutParams(layoutParams3);
                eeVar.ejD.setLayoutParams(layoutParams4);
                eeVar.ejH.setLayoutParams(layoutParams2);
                eeVar.ejH.setVisibility(0);
                eeVar.ejC.setVisibility(8);
                eeVar.ejA.setVisibility(8);
                eeVar.ejB.setVisibility(8);
                eeVar.ejD.setVisibility(0);
                eeVar.ejF.setVisibility(0);
                eeVar.ejx.setVisibility(0);
                com.baidu.tbadk.data.g bhG2 = postData.bhG();
                eeVar.ejQ.setVisibility(8);
                if (bhG2 != null && !TextUtils.isEmpty(bhG2.getName()) && !TextUtils.isEmpty(bhG2.getName().trim())) {
                    String name2 = bhG2.getName();
                    String lat2 = bhG2.getLat();
                    String lng2 = bhG2.getLng();
                    eeVar.ejU.setVisibility(0);
                    eeVar.ejU.setText(bhG2.getName());
                    eeVar.ejU.setOnClickListener(new ec(this, lat2, lng2, name2));
                } else {
                    eeVar.ejU.setVisibility(8);
                }
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bhD()));
                eeVar.ejw.setVisibility(0);
                eeVar.ejw.setText(format);
                if (eeVar.epv != null) {
                    if (postData.sl() != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eeVar.ejF.getLayoutParams();
                        marginLayoutParams.topMargin = (int) this.eka.getResources().getDimension(w.f.ds16);
                        eeVar.ejF.setLayoutParams(marginLayoutParams);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) eeVar.epw.getLayoutParams();
                        marginLayoutParams2.topMargin = (int) this.eka.getResources().getDimension(w.f.ds10);
                        eeVar.epw.setLayoutParams(marginLayoutParams2);
                        eeVar.epv.a(this.eka.getPageContext(), postData.sl(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", this.ejb.aJp().getId(), this.ejb.aJp().getName(), this.ejb.aJq().getId(), null));
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) eeVar.epx.getLayoutParams();
                        marginLayoutParams3.leftMargin = (int) this.eka.getResources().getDimension(w.f.ds30);
                        marginLayoutParams3.rightMargin = (int) this.eka.getResources().getDimension(w.f.ds30);
                        eeVar.epx.setLayoutParams(marginLayoutParams3);
                    } else {
                        eeVar.epv.a(null, null, null);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) eeVar.epx.getLayoutParams();
                        marginLayoutParams4.leftMargin = 0;
                        marginLayoutParams4.rightMargin = 0;
                        eeVar.epx.setLayoutParams(marginLayoutParams4);
                    }
                }
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                eeVar.ejy.setVisibility(0);
                com.baidu.tbadk.core.util.aq.i((View) eeVar.ejy, w.e.cp_link_tip_a);
            } else {
                eeVar.ejy.setVisibility(8);
            }
            eeVar.ejz.setVideoImageId(w.g.pic_video);
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(w.h.tag_clip_board, postData);
            sparseArray4.put(w.h.tag_load_sub_data, postData);
            sparseArray4.put(w.h.tag_load_sub_view, view);
            sparseArray4.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray4.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bhD()));
            if (postData.bhP()) {
                eeVar.epl.setVisibility(8);
                eeVar.epn.setVisibility(0);
                eeVar.epo.setVisibility(0);
                eeVar.epo.setTag(w.h.tag_clip_board, postData);
                eeVar.epm.setTag(sparseArray4);
                eeVar.epn.setTag(sparseArray4);
                eeVar.epo.a(postData.bhR(), postData.bhQ(), false);
            } else {
                eeVar.epl.setVisibility(0);
                eeVar.epk.setTag(sparseArray4);
                eeVar.epl.setTag(sparseArray4);
                eeVar.epn.setVisibility(8);
                eeVar.epo.setVisibility(8);
            }
            if (postData.bhH() > 0 && postData.bhA() != null && postData.bhA().size() > 0) {
                if (this.ejc == null) {
                    this.ejc = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.ejc.setIsFromCDN(this.mIsFromCDN);
                    this.ejc.H(this.eje);
                    boolean z7 = false;
                    String userId = this.ejb.aJq().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.ejc.B(this.ejb.aJA(), z7);
                    this.ejc.h(this.ejb.aJq());
                }
                this.ejc.nL(postData.getId());
                eeVar.ejE.setVisibility(0);
                eeVar.ejE.a(postData, view);
                eeVar.ejE.setChildOnClickListener(this.crj);
                eeVar.ejE.setChildOnLongClickListener(this.asV);
                eeVar.ejE.setChildOnTouchListener(this.ejf);
                eeVar.ejE.setSubPbAdapter(this.ejc);
                eeVar.ejE.setVisibility(0);
                eeVar.ejW.setVisibility(0);
                eeVar.ejW.invalidate();
                eeVar.ejG.setPadding(0, 0, 0, 0);
            } else {
                eeVar.ejG.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds26));
                eeVar.ejE.setVisibility(8);
                eeVar.ejW.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gk = com.baidu.tbadk.util.u.gk(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gk > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 12)) + "...";
                    }
                } else if (gk > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    eeVar.bsn.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    eeVar.bsn.setText(name_show);
                }
                if (eeVar.epb != null && postData.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = postData.getAuthor().getAlaUserData();
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        eeVar.epb.setVisibility(8);
                    } else {
                        eeVar.epb.setVisibility(0);
                        com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                        bVar.Qx = alaUserData;
                        bVar.type = 3;
                        eeVar.epb.setTag(bVar);
                    }
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.aq.c(eeVar.bsn, w.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aq.c(eeVar.bsn, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                if (level_id != 0) {
                    eeVar.eju.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.c(eeVar.eju, BitmapHelper.getGradeResourceIdNew(level_id));
                    String bhO = postData.bhO();
                    if (StringUtils.isNull(bhO)) {
                        bhO = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id));
                    }
                    eeVar.eju.setContentDescription(bhO);
                    eeVar.eju.setOnClickListener(null);
                } else {
                    eeVar.eju.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.aq.c(eeVar.ejv, w.g.pb_manager);
                        eeVar.eju.setVisibility(8);
                        eeVar.ejv.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.aq.c(eeVar.ejv, w.g.pb_assist);
                        eeVar.eju.setVisibility(8);
                        eeVar.ejv.setVisibility(0);
                    }
                    if (eeVar.ejv.getVisibility() == 0) {
                        eeVar.ejv.setAlpha(179);
                    }
                }
                if (eeVar.eju.getVisibility() == 0) {
                    eeVar.eju.setAlpha(179);
                }
                int gk2 = com.baidu.tbadk.util.u.gk(postData.getAuthor().getName_show());
                if (gk2 < 14 || eeVar.eju.getVisibility() != 0 || eeVar.ejy.getVisibility() != 0) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                int i3 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gk2 < 12 || eeVar.eju.getVisibility() != 0 || eeVar.ejy.getVisibility() != 0) ? i2 : i2 - 1;
                this.ejd = postData.getAuthor().getIconInfo();
                this.cXq = postData.getAuthor().getTShowInfoNew();
                if (eeVar.ceI != null) {
                    if (com.baidu.tbadk.core.util.x.q(this.ejd)) {
                        eeVar.ceI.setVisibility(8);
                    } else {
                        eeVar.ceI.setVisibility(0);
                    }
                    eeVar.ceI.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    eeVar.ceI.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.bWQ);
                    eeVar.ceI.wV();
                    eeVar.ceI.a(this.ejd, i3, getDimensionPixelSize(w.f.ds24), getDimensionPixelSize(w.f.ds24), getDimensionPixelSize(w.f.ds10));
                }
                if (eeVar.ame != null) {
                    eeVar.ame.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etG);
                    if (this.cXq != null && this.cXq.size() > 0 && this.cXq.get(0) != null) {
                        eeVar.ame.setTag(this.cXq.get(0).getUrl());
                    }
                    eeVar.ame.a(this.cXq, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData.getAuthor() == null || postData.getAuthor().getUserTbVipInfoData() == null) {
                userTbVipInfoData = null;
            } else {
                userTbVipInfoData = postData.getAuthor().getUserTbVipInfoData();
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().qd())) {
                eeVar.ejt.setVisibility(4);
                eeVar.epp.setVisibility(8);
                eeVar.ejs.setVisibility(0);
                eeVar.epp.setVisibility(8);
                eeVar.ejs.getHeadView().setUserId(postData.getAuthor().getUserId());
                eeVar.ejs.getHeadView().ac(postData.getAuthor().getUserName(), postData.bhN());
                eeVar.ejs.getHeadView().setImageDrawable(null);
                eeVar.ejs.getHeadView().c(portrait, 28, false);
                eeVar.ejs.dO(postData.getAuthor().getPendantData().qd());
                eeVar.ejs.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                eeVar.ejs.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
                eeVar.ejs.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
            } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                if (eeVar.bbh != null) {
                    if (eeVar.bbi == null) {
                        eeVar.bbh.inflate();
                        eeVar.bbi = (TbImageView) eeVar.getView().findViewById(w.h.user_head_mask);
                    }
                    if (eeVar.bbi != null) {
                        eeVar.bbi.c(userTbVipInfoData.getvipV_url(), 10, false);
                    }
                    eeVar.epp.setIsBigV(true);
                }
                eeVar.ejt.setVisibility(4);
                eeVar.epp.setVisibility(0);
                eeVar.ejs.setVisibility(8);
                eeVar.epp.setData(postData.getAuthor());
                eeVar.epp.setUserId(postData.getAuthor().getUserId());
                eeVar.epp.ac(postData.getAuthor().getUserName(), postData.bhN());
            } else {
                eeVar.ejs.setVisibility(8);
                if (f(postData)) {
                    eeVar.ejt.setVisibility(4);
                    eeVar.epp.setVisibility(0);
                    eeVar.epp.c(portrait, 28, false);
                    eeVar.epp.setUserId(postData.getAuthor().getUserId());
                    eeVar.epp.ac(postData.getAuthor().getUserName(), postData.bhN());
                    eeVar.epp.setOnClickListener(((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN.etF);
                } else {
                    eeVar.ejt.setVisibility(0);
                    eeVar.epp.setVisibility(8);
                    eeVar.ejt.setUserId(postData.getAuthor().getUserId());
                    eeVar.ejt.ac(postData.getAuthor().getUserName(), postData.bhN());
                    eeVar.ejt.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    eeVar.ejt.setImageDrawable(null);
                    eeVar.ejt.c(portrait, 28, false);
                }
            }
            eeVar.bsn.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            eeVar.bsn.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            eeVar.bsn.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
            eeVar.ejz.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            if (this.cBC) {
                eeVar.ejz.setDefaultImageId(w.g.transparent_bg);
            } else {
                eeVar.ejz.setDefaultImageId(w.g.icon_click);
            }
            eeVar.ejz.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                aws = null;
            } else {
                aws = postData.aws();
            }
            if (this.ejg || !this.ejh) {
                eeVar.ejz.a(aws, false, this.eoU);
            } else {
                eeVar.ejz.a(aws, true, this.eoU);
            }
            boolean z8 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (this.ejb != null && this.ejb.aJA() != 0) {
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
            if (this.ejb != null && this.ejb.aJq() != null && this.ejb.aJq().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.ejb.aJq().getAuthor().getUserId();
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
                    if (postData.bhD() == 1) {
                        i4 = 0;
                    }
                    sparseArray4.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray4.put(w.h.tag_should_manage_visible, true);
                        sparseArray4.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejb.aJA()));
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
                        if (this.ejb.aJq() != null) {
                            sparseArray4.put(w.h.tag_user_mute_thread_id, this.ejb.aJq().getId());
                        }
                        sparseArray4.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray4.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray4.put(w.h.tag_should_delete_visible, true);
                        sparseArray4.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ejb.aJA()));
                        sparseArray4.put(w.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray4.put(w.h.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray4.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray4.put(w.h.tag_should_delete_visible, false);
                    }
                    bhM = postData.bhM();
                    if (bhM.size() > 0 || (postData.bhD() == 1 && this.eka.aKj().aND())) {
                        eeVar.eps.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar2 = bhM.get(0);
                        if (!StringUtils.isNull(bVar2.getIconUrl())) {
                            a(eeVar, bVar2.getIconUrl());
                            if (!StringUtils.isNull(bVar2.Ca())) {
                                eeVar.eps.setTag(w.h.tag_pb_lottery_tail_link, bVar2.Ca());
                            }
                        } else {
                            eeVar.eps.setVisibility(8);
                        }
                    }
                    a(eeVar, postData, postData.bhD() != 1, aws);
                    d(eeVar);
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
            if (postData.bhD() == 1) {
            }
            sparseArray4.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z9) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            bhM = postData.bhM();
            if (bhM.size() > 0) {
            }
            eeVar.eps.setVisibility(8);
            a(eeVar, postData, postData.bhD() != 1, aws);
            d(eeVar);
        }
    }

    private void b(ee eeVar) {
        if (eeVar != null && this.ejb != null && this.ejb.aJH() != null) {
            eeVar.aMr();
            eeVar.epc.setOnClickListener(this.crj);
            com.baidu.tieba.pb.data.h aJH = this.ejb.aJH();
            eeVar.eph.setSupportNoImage(true);
            eeVar.eph.setInterceptOnClick(true);
            if (this.cBC) {
                eeVar.eph.setDefaultResource(w.g.transparent_bg);
                eeVar.eph.c(aJH.qd(), 17, false);
            } else {
                eeVar.eph.setDefaultResource(w.g.icon_click);
            }
            eeVar.eph.setOnClickListener(this.crj);
            eeVar.epg.setOnClickListener(this.crj);
            int aJL = aJH.aJL();
            String aJM = StringUtils.isNull(aJH.aJM(), true) ? "" : aJH.aJM();
            String string = this.mContext.getString(w.l.yule_head_img);
            if (aJL <= 0) {
                eeVar.epf.setVisibility(8);
                eeVar.epg.setVisibility(8);
            } else {
                eeVar.epf.setVisibility(0);
                eeVar.epg.setVisibility(0);
                if (aJL > 20) {
                    string = String.format(this.mContext.getString(w.l.yule_head_img_rank), "20+");
                } else {
                    string = String.format(this.mContext.getString(w.l.yule_head_img_rank), new StringBuilder(String.valueOf(aJL)).toString());
                }
                eeVar.epf.setText(" " + aJM);
            }
            eeVar.epe.setText(string);
            if (aJH.qa()) {
                eeVar.epi.setVisibility(8);
            } else {
                eeVar.epi.setVisibility(0);
                eeVar.epi.setText(String.format(this.mContext.getString(w.l.star_cover_pic_author), aJH.qc()));
            }
            if (StringUtils.isNull(this.ejb.aJq().getAuthor().getName_show(), true)) {
                eeVar.epj.setVisibility(8);
            } else {
                eeVar.epj.setVisibility(0);
                eeVar.epj.setText(String.format(this.mContext.getString(w.l.star_cover_post_author), this.ejb.aJq().getAuthor().getName_show()));
            }
            if (eeVar.ejQ.getVisibility() == 0) {
                View findViewById = eeVar.ejp.findViewById(w.h.yule_head_img_blank);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eeVar.ejQ.getLayoutParams();
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams != null && marginLayoutParams != null && layoutParams.height == getDimensionPixelSize(w.f.ds72)) {
                    layoutParams.height -= marginLayoutParams.topMargin;
                }
            }
            c(eeVar);
        }
    }

    private void c(ee eeVar) {
        if (eeVar.epc != null) {
            com.baidu.tbadk.core.util.aq.k(eeVar.epd, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i((View) eeVar.epe, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i((View) eeVar.epf, w.e.cp_cont_e);
            com.baidu.tbadk.core.util.aq.i((View) eeVar.epg, w.e.cp_link_tip_a);
            com.baidu.tbadk.core.util.aq.i((View) eeVar.epi, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i((View) eeVar.epj, w.e.cp_cont_i);
        }
    }

    private void a(ee eeVar, String str) {
        eeVar.eps.setVisibility(0);
        com.baidu.adp.lib.f.c.fG().a(str, 17, new ed(this, eeVar, str), this.eka.getUniqueId());
    }

    private void d(ee eeVar) {
        eeVar.ejz.setTextViewOnTouchListener(this.ejf);
        eeVar.ejz.setTextViewCheckSelection(false);
    }

    private void a(ee eeVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aOS() == null) {
            eeVar.ejV.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aOS(), eeVar.ejV, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1160=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int ag = (((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i = 0;
        if (!z) {
            i = getDimensionPixelSize(w.f.ds132);
        } else if (z2) {
            i = getDimensionPixelSize(w.f.ds64);
        }
        int min = Math.min(ag - i, this.eiZ);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private boolean f(PostData postData) {
        return (postData == null || postData.getAuthor() == null || postData.getAuthor().getGodUserData() == null || postData.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void e(ee eeVar) {
        eeVar.ejp.setOnTouchListener(this.ejf);
        eeVar.ejp.setOnLongClickListener(this.asV);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eka.getPageContext().getOrignalPage()).ekN;
        eeVar.bsn.setOnClickListener(aVar.etF);
        eeVar.ejt.setOnClickListener(aVar.etF);
        eeVar.ejs.setOnClickListener(aVar.etF);
        eeVar.ejD.setOnLongClickListener(this.asV);
        eeVar.ejz.setOnLongClickListener(this.asV);
        eeVar.ejD.setOnTouchListener(this.ejf);
        eeVar.ejz.setOnTouchListener(this.ejf);
        eeVar.ejz.setCommonTextViewOnClickListener(this.crj);
        eeVar.ejz.setOnImageClickListener(this.aNu);
        eeVar.ejz.setOnEmotionClickListener(aVar.etH);
        eeVar.ceI.setOnClickListener(aVar.bWQ);
        eeVar.ame.setOnClickListener(aVar.etG);
        eeVar.ejV.setOnClickListener(this.crj);
        eeVar.eps.setOnClickListener(this.crj);
        eeVar.epk.setOnClickListener(this.crj);
        eeVar.epl.setOnClickListener(this.crj);
        eeVar.epm.setOnClickListener(this.crj);
        eeVar.epn.setOnClickListener(this.crj);
        eeVar.epo.setOnClickListener(this.crj);
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

    public void id(boolean z) {
        this.emy = z;
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

    public void ih(boolean z) {
        this.ekC = z;
    }

    public void a(TbRichTextView.b bVar) {
        this.eoU = bVar;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.eka.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
