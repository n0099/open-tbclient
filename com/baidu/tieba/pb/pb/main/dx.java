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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dx extends da<com.baidu.tieba.tbadkCore.data.p, ed> implements View.OnClickListener {
    private TbRichTextView.e aHX;
    private boolean adc;
    private View.OnLongClickListener anA;
    protected boolean cAg;
    private ArrayList<IconData> cUY;
    private View.OnClickListener cpK;
    protected int egh;
    private boolean egi;
    protected com.baidu.tieba.pb.data.f egj;
    private com.baidu.tieba.pb.pb.sub.ba egk;
    private ArrayList<IconData> egl;
    private View.OnClickListener egm;
    private com.baidu.tieba.pb.a.d egn;
    private boolean ego;
    private final boolean egp;
    private int egq;
    private int egr;
    private boolean ehK;
    private boolean ejF;
    private TbRichTextView.b elX;
    private boolean elY;
    private String mHostId;

    private void init() {
        this.egq = getDimensionPixelSize(r.f.ds30);
        this.egr = com.baidu.adp.lib.util.k.I(this.mContext) - getDimensionPixelSize(r.f.ds60);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dx(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
        this.elX = null;
        this.ego = false;
        this.egp = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.ejF = false;
        this.elY = false;
        this.ehK = false;
        this.adc = false;
        init();
    }

    private void a(ed edVar) {
        if (edVar != null) {
            if (edVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ap.k(edVar.egx, r.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ap.k(edVar.egP, r.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.ap.c(edVar.blu, r.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ap.c((View) edVar.egC, r.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ap.c((View) edVar.egD, r.e.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ap.c(edVar.egE, r.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ap.c(edVar.egF, r.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ap.j(edVar.emn, r.g.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.ap.c(edVar.emn, r.g.icon_pb_more_n);
                com.baidu.tbadk.core.util.ap.k(edVar.egI, r.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.k(edVar.egJ, r.e.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.c(edVar.egJ, r.e.cp_bg_line_b);
                com.baidu.tbadk.core.util.ap.j((View) edVar.emq, r.g.btn_appdownload);
                com.baidu.tbadk.core.util.ap.c(edVar.emq, r.e.cp_cont_i, 1);
                edVar.egH.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10039));
                com.baidu.tbadk.core.util.ap.c(edVar.ehc, r.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ap.c(edVar.ehb, r.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ap.c(edVar.eha, r.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ap.c(edVar.egZ, r.e.cp_cont_c, 1);
                com.baidu.tbadk.core.util.ap.j(edVar.egz, r.g.bg_floor_new_middle);
                com.baidu.tbadk.core.util.ap.k(edVar.egM, r.e.cp_bg_line_e);
                c(edVar);
            }
            edVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public ed onCreateViewHolder(ViewGroup viewGroup) {
        ed edVar = new ed(this.ehi.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.j.new_pb_list_item, viewGroup, false), this.cAg, this.egh);
        a(edVar);
        return edVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.da, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.p pVar, ed edVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, pVar, edVar);
        a(edVar);
        e(edVar);
        com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) getItem(i);
        if (pVar2 != null) {
            pVar2.st();
            a(edVar, pVar2, view, i);
        }
        if (!this.ego && this.egp && edVar != null && edVar.egH.Ic() && (listView = ((PbActivity) this.ehi.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ego = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private boolean oC(int i) {
        if (getItem(0) instanceof com.baidu.tieba.tbadkCore.data.p) {
            com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) getItem(0);
            if (pVar.bhQ() == 1 && i == 1) {
                return true;
            }
            return pVar.bhQ() != 1 && i == 0;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v59, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0838  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0843  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0e87  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0e93  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0e9f  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0ee3  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0ee6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ed edVar, com.baidu.tieba.tbadkCore.data.p pVar, View view, int i) {
        SparseArray sparseArray;
        UserTbVipInfoData userTbVipInfoData;
        TbRichText awW;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ArrayList<com.baidu.tbadk.data.b> bhZ;
        int i2;
        if (edVar != null && pVar != null) {
            edVar.egN.setVisibility(0);
            edVar.egB.setTag(null);
            edVar.egB.setUserId(null);
            edVar.blu.setText((CharSequence) null);
            edVar.egD.setVisibility(8);
            edVar.egM.setVisibility(0);
            edVar.egG.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) edVar.egL.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                edVar.egL.setTag(sparseArray3);
                edVar.egH.setTag(sparseArray3);
                edVar.egx.setTag(r.h.tag_from, sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            sparseArray.put(r.h.tag_clip_board, pVar);
            sparseArray.put(r.h.tag_is_subpb, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) edVar.egH.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            edVar.egH.setPadding(0, 0, 0, 0);
            if (!this.cAg) {
                if (pVar.bhQ() == 1) {
                    edVar.egH.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32);
                    edVar.egH.setIsSupportVitality(false);
                }
            } else if (TextUtils.isEmpty(pVar.getBimg_url())) {
                this.elY = false;
                sparseArray.put(r.h.tag_richtext_bg, null);
                edVar.egH.gA(null);
                edVar.egH.setBackgroundDrawable(null);
                if (pVar.bhQ() == 1) {
                    edVar.egH.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds32);
                    edVar.egH.setIsSupportVitality(false);
                }
            } else {
                this.elY = true;
                edVar.egH.setIsSupportVitality(false);
                if (pVar.bhQ() == 1) {
                    layoutParams.leftMargin = getDimensionPixelSize(r.f.ds30);
                } else {
                    layoutParams.leftMargin = 0;
                }
                layoutParams.rightMargin = getDimensionPixelSize(r.f.ds30);
                if (pVar.aPB() == null) {
                    layoutParams.bottomMargin = getDimensionPixelSize(r.f.ds24);
                } else {
                    layoutParams.bottomMargin = getDimensionPixelSize(r.f.ds32);
                }
                layoutParams.topMargin = getDimensionPixelSize(r.f.ds24);
                sparseArray.put(r.h.tag_richtext_bg, pVar.getBimg_url());
                edVar.egH.gA(pVar.getBimg_url());
            }
            edVar.egH.setLayoutParams(layoutParams);
            if (pVar.bhQ() != 1) {
                if (TextUtils.isEmpty(pVar.getBimg_url())) {
                    edVar.egH.setOnClickListener(this.cpK);
                    edVar.egH.setTextViewOnClickListener(this.cpK);
                } else {
                    edVar.egH.setOnClickListener(null);
                    edVar.egH.setTextViewOnClickListener(null);
                }
                edVar.egx.setOnClickListener(this.cpK);
                edVar.egL.setOnClickListener(this.cpK);
            } else {
                edVar.egx.setOnClickListener(null);
                edVar.egL.setOnClickListener(null);
            }
            edVar.egF.setText(pVar.bhS());
            if (pVar.bhQ() == 1) {
                a(edVar.egH, view, true, this.elY);
                edVar.egP.setVisibility(8);
                edVar.egy.setVisibility(8);
                edVar.egN.setVisibility(8);
                edVar.egL.setVisibility(8);
                edVar.egF.setVisibility(8);
                edVar.egO.setVisibility(8);
                edVar.ehe.setVisibility(8);
                edVar.egK.setVisibility(0);
                String str = null;
                long j = 0;
                if (pVar.getAuthor() != null) {
                    j = pVar.getAuthor().getUserIdLong();
                    str = pVar.getAuthor().getUserName();
                }
                if (this.egj != null && this.egj.aJZ() != null) {
                    edVar.egK.a(pVar.bhX(), str, j, com.baidu.adp.lib.g.b.c(this.egj.aJZ().getId(), 0L), com.baidu.adp.lib.g.b.c(pVar.getId(), 0L));
                }
                edVar.egK.tg();
                if (this.egi) {
                    PraiseData praiseData = null;
                    if (this.egj != null && this.egj.aJZ() != null) {
                        this.egj.aJZ().rn();
                    }
                    if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                        edVar.egI.setVisibility(0);
                        edVar.egJ.setVisibility(0);
                        edVar.egI.setIsFromPb(true);
                        edVar.egI.a(null, this.egj.aJZ().getId(), praiseData.getPostId(), true);
                        edVar.egI.dp(this.mSkinType);
                    } else {
                        edVar.egI.setVisibility(8);
                        edVar.egJ.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.ap(edVar.egI);
                    com.baidu.tieba.graffiti.c.ap(edVar.egJ);
                    edVar.egY.setVisibility(0);
                    edVar.eha.setText(pVar.bhS());
                    com.baidu.tbadk.data.g bhT = pVar.bhT();
                    edVar.ehc.setVisibility(8);
                    if (bhT != null && !TextUtils.isEmpty(bhT.getName()) && !TextUtils.isEmpty(bhT.getName().trim())) {
                        String name = bhT.getName();
                        String lat = bhT.getLat();
                        String lng = bhT.getLng();
                        edVar.ehb.setVisibility(0);
                        com.baidu.adp.lib.util.k.a(this.mContext, edVar.ehb, 0, 10, 0, 10);
                        edVar.ehb.setText(bhT.getName());
                        edVar.ehb.setOnClickListener(new dy(this, lat, lng, name));
                    } else {
                        edVar.ehb.setVisibility(8);
                    }
                    if (this.egj.aKq() != null && !StringUtils.isNull(this.egj.aKq().pL(), true)) {
                        b(edVar);
                    }
                } else {
                    edVar.egI.setVisibility(8);
                    edVar.egJ.setVisibility(8);
                    if (pVar.getAuthor() != null && pVar.getAuthor().getGodInfo() != null) {
                        edVar.egK.ji(false);
                    } else {
                        edVar.egI.setVisibility(8);
                        edVar.egJ.setVisibility(8);
                        edVar.ehb.setVisibility(8);
                        edVar.ehc.setVisibility(8);
                    }
                    if (this.egj.aKq() != null && !StringUtils.isNull(this.egj.aKq().pL(), true) && edVar.emf != null) {
                        edVar.emf.setVisibility(8);
                        edVar.emk.DP();
                    }
                }
                if (this.ehi.aKO().aOj()) {
                    edVar.egH.setVisibility(8);
                }
                if (this.egj.aJZ() != null && this.egj.aJZ().rI() != null) {
                    com.baidu.tbadk.core.data.br rI = this.egj.aJZ().rI();
                    String activityUrl = rI.getActivityUrl();
                    String sP = rI.sP();
                    String sQ = rI.sQ();
                    if (!StringUtils.isNull(sQ)) {
                        edVar.emq.setVisibility(0);
                        edVar.emq.setText(sQ);
                        edVar.emq.setOnClickListener(new dz(this, activityUrl));
                        edVar.emr.setOnClickListener(new ea(this, activityUrl));
                        if (!StringUtils.isNull(sP)) {
                            edVar.bIm.setVisibility(0);
                            edVar.bIm.c(sP, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    edVar.emq.setVisibility(8);
                    edVar.bIm.setVisibility(8);
                }
                if (edVar.emv != null) {
                    edVar.emv.setVisibility(8);
                }
                if (this.egj != null && this.egj.aJZ() != null && this.egj.aJZ().si()) {
                    edVar.emy.d(pVar.Hz());
                    edVar.egH.setVisibility(8);
                    edVar.egY.setVisibility(8);
                    edVar.emy.bQL.setVisibility(8);
                } else {
                    edVar.emy.bQL.setVisibility(8);
                    edVar.egY.setVisibility(0);
                }
            } else {
                if (this.egj.aKq() != null && !StringUtils.isNull(this.egj.aKq().pL(), true) && edVar.emf != null) {
                    edVar.emf.setVisibility(8);
                }
                edVar.egH.setVisibility(0);
                a(edVar.egH, view, false, this.elY);
                edVar.egy.setVisibility(0);
                edVar.egO.setVisibility(0);
                edVar.bIm.setVisibility(8);
                edVar.emq.setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = edVar.egP.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) edVar.egN.getLayoutParams();
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) edVar.egL.getLayoutParams();
                if (oC(i)) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds20);
                    layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds8);
                    layoutParams4.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds6);
                } else {
                    layoutParams4.topMargin = 0;
                    layoutParams3.topMargin = 0;
                    layoutParams2.height = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds1);
                }
                edVar.egN.setLayoutParams(layoutParams3);
                edVar.egL.setLayoutParams(layoutParams4);
                edVar.egP.setLayoutParams(layoutParams2);
                edVar.egP.setVisibility(0);
                edVar.egK.setVisibility(8);
                edVar.egI.setVisibility(8);
                edVar.egJ.setVisibility(8);
                edVar.egL.setVisibility(0);
                edVar.egN.setVisibility(0);
                edVar.egF.setVisibility(0);
                com.baidu.tbadk.data.g bhT2 = pVar.bhT();
                edVar.egY.setVisibility(8);
                if (bhT2 != null && !TextUtils.isEmpty(bhT2.getName()) && !TextUtils.isEmpty(bhT2.getName().trim())) {
                    String name2 = bhT2.getName();
                    String lat2 = bhT2.getLat();
                    String lng2 = bhT2.getLng();
                    edVar.ehc.setVisibility(0);
                    edVar.ehc.setText(bhT2.getName());
                    edVar.ehc.setOnClickListener(new eb(this, lat2, lng2, name2));
                } else {
                    edVar.ehc.setVisibility(8);
                }
                String format = String.format(this.mContext.getString(r.l.is_floor), Integer.valueOf(pVar.bhQ()));
                edVar.egE.setVisibility(0);
                edVar.egE.setText(format);
                if (edVar.emv != null) {
                    if (pVar.rR() != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) edVar.egN.getLayoutParams();
                        marginLayoutParams.topMargin = (int) this.ehi.getResources().getDimension(r.f.ds16);
                        edVar.egN.setLayoutParams(marginLayoutParams);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) edVar.emw.getLayoutParams();
                        marginLayoutParams2.topMargin = (int) this.ehi.getResources().getDimension(r.f.ds10);
                        edVar.emw.setLayoutParams(marginLayoutParams2);
                        edVar.emv.a(this.ehi.getPageContext(), pVar.rR(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", this.egj.aJY().getId(), this.egj.aJY().getName(), this.egj.aJZ().getId(), null));
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) edVar.emx.getLayoutParams();
                        marginLayoutParams3.leftMargin = (int) this.ehi.getResources().getDimension(r.f.ds30);
                        marginLayoutParams3.rightMargin = (int) this.ehi.getResources().getDimension(r.f.ds30);
                        edVar.emx.setLayoutParams(marginLayoutParams3);
                    } else {
                        edVar.emv.a(null, null, null);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) edVar.emx.getLayoutParams();
                        marginLayoutParams4.leftMargin = 0;
                        marginLayoutParams4.rightMargin = 0;
                        edVar.emx.setLayoutParams(marginLayoutParams4);
                    }
                }
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(pVar.getAuthor().getUserId())) {
                edVar.egG.setVisibility(0);
                com.baidu.tbadk.core.util.ap.i((View) edVar.egG, r.e.cp_link_tip_a);
            } else {
                edVar.egG.setVisibility(8);
            }
            edVar.egH.setVideoImageId(r.g.pic_video);
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(r.h.tag_clip_board, pVar);
            sparseArray4.put(r.h.tag_load_sub_data, pVar);
            sparseArray4.put(r.h.tag_load_sub_view, view);
            sparseArray4.put(r.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray4.put(r.h.tag_pb_floor_number, Integer.valueOf(pVar.bhQ()));
            edVar.emn.setTag(sparseArray4);
            edVar.emo.setTag(sparseArray4);
            if (pVar.bhU() > 0 && pVar.bhN() != null && pVar.bhN().size() > 0) {
                if (this.egk == null) {
                    this.egk = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.egk.setIsFromCDN(this.mIsFromCDN);
                    this.egk.J(this.egm);
                    boolean z7 = false;
                    String userId = this.egj.aJZ().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.egk.B(this.egj.aKj(), z7);
                    this.egk.h(this.egj.aJZ());
                }
                this.egk.oD(pVar.getId());
                edVar.egM.setVisibility(0);
                edVar.egM.a(pVar, view);
                edVar.egM.setChildOnClickListener(this.cpK);
                edVar.egM.setChildOnLongClickListener(this.anA);
                edVar.egM.setChildOnTouchListener(this.egn);
                edVar.egM.setSubPbAdapter(this.egk);
                edVar.egM.setVisibility(0);
                edVar.ehe.setVisibility(0);
                edVar.ehe.invalidate();
                edVar.egO.setPadding(0, 0, 0, 0);
            } else {
                edVar.egO.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds26));
                edVar.egM.setVisibility(8);
                edVar.ehe.setVisibility(8);
            }
            String portrait = pVar.getAuthor().getPortrait();
            if (pVar.getAuthor() != null) {
                String name_show = pVar.getAuthor().getName_show();
                int gv = com.baidu.tbadk.util.u.gv(name_show);
                if (!StringUtils.isNull(pVar.getAuthor().getSealPrefix())) {
                    if (gv > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 12)) + "...";
                    }
                } else if (gv > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (!StringUtils.isNull(pVar.getAuthor().getSealPrefix())) {
                    edVar.blu.setText(ag(pVar.getAuthor().getSealPrefix(), name_show));
                } else {
                    edVar.blu.setText(name_show);
                }
                if (edVar.eme != null && pVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = pVar.getAuthor().getAlaUserData();
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        edVar.eme.setVisibility(8);
                    } else {
                        edVar.eme.setVisibility(0);
                        com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                        bVar.Lv = alaUserData;
                        bVar.type = 3;
                        edVar.eme.setTag(bVar);
                    }
                }
                ArrayList<IconData> tShowInfoNew = pVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.ap.c(edVar.blu, r.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.c(edVar.blu, r.e.cp_cont_f, 1);
                }
                int level_id = pVar.getAuthor().getLevel_id();
                int is_bawu = pVar.getAuthor().getIs_bawu();
                String bawu_type = pVar.getAuthor().getBawu_type();
                if (level_id != 0) {
                    edVar.egC.setVisibility(0);
                    com.baidu.tbadk.core.util.ap.c(edVar.egC, BitmapHelper.getGradeResourceIdNew(level_id));
                    String bib = pVar.bib();
                    if (StringUtils.isNull(bib)) {
                        bib = String.format(TbadkCoreApplication.m9getInst().getString(r.l.degree_in_forum), Integer.valueOf(level_id));
                    }
                    edVar.egC.setContentDescription(bib);
                    edVar.egC.setOnClickListener(null);
                } else {
                    edVar.egC.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ap.c(edVar.egD, r.g.pb_manager);
                        edVar.egC.setVisibility(8);
                        edVar.egD.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ap.c(edVar.egD, r.g.pb_assist);
                        edVar.egC.setVisibility(8);
                        edVar.egD.setVisibility(0);
                    }
                    if (edVar.egD.getVisibility() == 0) {
                        edVar.egD.setAlpha(179);
                    }
                }
                if (edVar.egC.getVisibility() == 0) {
                    edVar.egC.setAlpha(179);
                }
                int gv2 = com.baidu.tbadk.util.u.gv(pVar.getAuthor().getName_show());
                if (gv2 < 14 || edVar.egC.getVisibility() != 0 || edVar.egG.getVisibility() != 0) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                int i3 = (StringUtils.isNull(pVar.getAuthor().getSealPrefix()) || gv2 < 12 || edVar.egC.getVisibility() != 0 || edVar.egG.getVisibility() != 0) ? i2 : i2 - 1;
                this.egl = pVar.getAuthor().getIconInfo();
                this.cUY = pVar.getAuthor().getTShowInfoNew();
                if (edVar.bXk != null) {
                    if (com.baidu.tbadk.core.util.w.s(this.egl)) {
                        edVar.bXk.setVisibility(8);
                    } else {
                        edVar.bXk.setVisibility(0);
                    }
                    edVar.bXk.setTag(r.h.tag_user_id, pVar.getAuthor().getUserId());
                    edVar.bXk.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.bPI);
                    edVar.bXk.wy();
                    edVar.bXk.a(this.egl, i3, getDimensionPixelSize(r.f.ds24), getDimensionPixelSize(r.f.ds24), getDimensionPixelSize(r.f.ds10));
                }
                if (edVar.agL != null) {
                    edVar.agL.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqz);
                    if (this.cUY != null && this.cUY.size() > 0 && this.cUY.get(0) != null) {
                        edVar.agL.setTag(this.cUY.get(0).getUrl());
                    }
                    edVar.agL.a(this.cUY, 3, getDimensionPixelSize(r.f.ds36), getDimensionPixelSize(r.f.ds36), getDimensionPixelSize(r.f.ds8), true);
                }
            }
            if (pVar.getAuthor() == null || pVar.getAuthor().getUserTbVipInfoData() == null) {
                userTbVipInfoData = null;
            } else {
                userTbVipInfoData = pVar.getAuthor().getUserTbVipInfoData();
            }
            if (pVar != null && pVar.getAuthor() != null && pVar.getAuthor().getPendantData() != null && !StringUtils.isNull(pVar.getAuthor().getPendantData().pL())) {
                edVar.egB.setVisibility(4);
                edVar.emp.setVisibility(8);
                edVar.egA.setVisibility(0);
                edVar.emp.setVisibility(8);
                edVar.egA.getHeadView().setUserId(pVar.getAuthor().getUserId());
                edVar.egA.getHeadView().ae(pVar.getAuthor().getUserName(), pVar.bia());
                edVar.egA.getHeadView().setImageDrawable(null);
                edVar.egA.getHeadView().c(portrait, 28, false);
                edVar.egA.dU(pVar.getAuthor().getPendantData().pL());
                edVar.egA.setTag(r.h.tag_user_id, pVar.getAuthor().getUserId());
                edVar.egA.setTag(r.h.tag_user_name, pVar.getAuthor().getUserName());
                edVar.egA.setTag(r.h.tag_virtual_user_url, pVar.getAuthor().getVirtualUserUrl());
            } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                if (edVar.aUU != null) {
                    if (edVar.aUV == null) {
                        edVar.aUU.inflate();
                        edVar.aUV = (TbImageView) edVar.getView().findViewById(r.h.user_head_mask);
                    }
                    if (edVar.aUV != null) {
                        edVar.aUV.c(userTbVipInfoData.getvipV_url(), 10, false);
                    }
                    edVar.emp.setIsBigV(true);
                }
                edVar.egB.setVisibility(4);
                edVar.emp.setVisibility(0);
                edVar.egA.setVisibility(8);
                edVar.emp.setData(pVar.getAuthor());
                edVar.emp.setUserId(pVar.getAuthor().getUserId());
                edVar.emp.ae(pVar.getAuthor().getUserName(), pVar.bia());
            } else {
                edVar.egA.setVisibility(8);
                if (f(pVar)) {
                    edVar.egB.setVisibility(4);
                    edVar.emp.setVisibility(0);
                    edVar.emp.c(portrait, 28, false);
                    edVar.emp.setUserId(pVar.getAuthor().getUserId());
                    edVar.emp.ae(pVar.getAuthor().getUserName(), pVar.bia());
                    edVar.emp.setOnClickListener(((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW.eqy);
                } else {
                    edVar.egB.setVisibility(0);
                    edVar.emp.setVisibility(8);
                    edVar.egB.setUserId(pVar.getAuthor().getUserId());
                    edVar.egB.ae(pVar.getAuthor().getUserName(), pVar.bia());
                    edVar.egB.setTag(r.h.tag_virtual_user_url, pVar.getAuthor().getVirtualUserUrl());
                    edVar.egB.setImageDrawable(null);
                    edVar.egB.c(portrait, 28, false);
                }
            }
            edVar.blu.setTag(r.h.tag_user_id, pVar.getAuthor().getUserId());
            edVar.blu.setTag(r.h.tag_user_name, pVar.getAuthor().getUserName());
            edVar.blu.setTag(r.h.tag_virtual_user_url, pVar.getAuthor().getVirtualUserUrl());
            edVar.egH.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_c));
            if (this.cAg) {
                edVar.egH.setDefaultImageId(r.g.transparent_bg);
            } else {
                edVar.egH.setDefaultImageId(r.g.icon_click);
            }
            edVar.egH.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                awW = null;
            } else {
                awW = pVar.awW();
            }
            if (this.ego || !this.egp) {
                edVar.egH.a(awW, false, this.elX);
            } else {
                edVar.egH.a(awW, true, this.elX);
            }
            boolean z8 = !StringUtils.isNull(pVar.getAuthor().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            if (this.egj != null && this.egj.aKj() != 0) {
                z9 = true;
                z10 = true;
                if (pVar != null && pVar.getAuthor() != null) {
                    String userId2 = pVar.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z9 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.egj != null && this.egj.aJZ() != null && this.egj.aJZ().getAuthor() != null && pVar.getAuthor() != null) {
                String userId3 = this.egj.aJZ().getAuthor().getUserId();
                String userId4 = pVar.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId4)) {
                        z2 = false;
                        z11 = true;
                    }
                    if (pVar == null && pVar.getAuthor() != null && UtilHelper.isCurrentAccount(pVar.getAuthor().getUserId())) {
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
                    if (pVar.bhQ() == 1) {
                        i4 = 0;
                    }
                    sparseArray4.put(r.h.tag_forbid_user_post_id, pVar.getId());
                    if (!z9) {
                        sparseArray4.put(r.h.tag_should_manage_visible, true);
                        sparseArray4.put(r.h.tag_manage_user_identity, Integer.valueOf(this.egj.aKj()));
                        sparseArray4.put(r.h.tag_forbid_user_name, pVar.getAuthor().getUserName());
                    } else {
                        sparseArray4.put(r.h.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray4.put(r.h.tag_user_mute_visible, true);
                        sparseArray4.put(r.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (pVar.getAuthor() != null) {
                            sparseArray4.put(r.h.tag_user_mute_mute_userid, pVar.getAuthor().getUserId());
                            sparseArray4.put(r.h.tag_user_mute_mute_username, pVar.getAuthor().getUserName());
                        }
                        if (this.egj.aJZ() != null) {
                            sparseArray4.put(r.h.tag_user_mute_thread_id, this.egj.aJZ().getId());
                        }
                        sparseArray4.put(r.h.tag_user_mute_post_id, pVar.getId());
                    } else {
                        sparseArray4.put(r.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray4.put(r.h.tag_should_delete_visible, true);
                        sparseArray4.put(r.h.tag_manage_user_identity, Integer.valueOf(this.egj.aKj()));
                        sparseArray4.put(r.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray4.put(r.h.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray4.put(r.h.tag_del_post_id, pVar.getId());
                    } else {
                        sparseArray4.put(r.h.tag_should_delete_visible, false);
                    }
                    bhZ = pVar.bhZ();
                    if (bhZ.size() > 0 || (pVar.bhQ() == 1 && this.ehi.aKO().aOj())) {
                        edVar.ems.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar2 = bhZ.get(0);
                        if (!StringUtils.isNull(bVar2.getIconUrl())) {
                            a(edVar, bVar2.getIconUrl());
                            if (!StringUtils.isNull(bVar2.BH())) {
                                edVar.ems.setTag(r.h.tag_pb_lottery_tail_link, bVar2.BH());
                            }
                        } else {
                            edVar.ems.setVisibility(8);
                        }
                    }
                    a(edVar, pVar, pVar.bhQ() != 1, awW);
                    d(edVar);
                }
            }
            z = z10;
            z2 = false;
            if (pVar == null) {
            }
            boolean z122 = z11;
            z3 = z;
            z4 = z122;
            if (z8) {
            }
            int i42 = 1;
            if (pVar.bhQ() == 1) {
            }
            sparseArray4.put(r.h.tag_forbid_user_post_id, pVar.getId());
            if (!z9) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            bhZ = pVar.bhZ();
            if (bhZ.size() > 0) {
            }
            edVar.ems.setVisibility(8);
            a(edVar, pVar, pVar.bhQ() != 1, awW);
            d(edVar);
        }
    }

    private void b(ed edVar) {
        if (edVar != null && this.egj != null && this.egj.aKq() != null) {
            edVar.aMY();
            edVar.emf.setOnClickListener(this.cpK);
            com.baidu.tieba.pb.data.h aKq = this.egj.aKq();
            edVar.emk.setSupportNoImage(true);
            edVar.emk.setInterceptOnClick(true);
            if (this.cAg) {
                edVar.emk.setDefaultResource(r.g.transparent_bg);
                edVar.emk.c(aKq.pL(), 17, false);
            } else {
                edVar.emk.setDefaultResource(r.g.icon_click);
            }
            edVar.emk.setOnClickListener(this.cpK);
            edVar.emj.setOnClickListener(this.cpK);
            int aKt = aKq.aKt();
            String aKu = StringUtils.isNull(aKq.aKu(), true) ? "" : aKq.aKu();
            String string = this.mContext.getString(r.l.yule_head_img);
            if (aKt <= 0) {
                edVar.emi.setVisibility(8);
                edVar.emj.setVisibility(8);
            } else {
                edVar.emi.setVisibility(0);
                edVar.emj.setVisibility(0);
                if (aKt > 20) {
                    string = String.format(this.mContext.getString(r.l.yule_head_img_rank), "20+");
                } else {
                    string = String.format(this.mContext.getString(r.l.yule_head_img_rank), new StringBuilder(String.valueOf(aKt)).toString());
                }
                edVar.emi.setText(" " + aKu);
            }
            edVar.emh.setText(string);
            if (aKq.pI()) {
                edVar.eml.setVisibility(8);
            } else {
                edVar.eml.setVisibility(0);
                edVar.eml.setText(String.format(this.mContext.getString(r.l.star_cover_pic_author), aKq.pK()));
            }
            if (StringUtils.isNull(this.egj.aJZ().getAuthor().getName_show(), true)) {
                edVar.emm.setVisibility(8);
            } else {
                edVar.emm.setVisibility(0);
                edVar.emm.setText(String.format(this.mContext.getString(r.l.star_cover_post_author), this.egj.aJZ().getAuthor().getName_show()));
            }
            if (edVar.egY.getVisibility() == 0) {
                View findViewById = edVar.egx.findViewById(r.h.yule_head_img_blank);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) edVar.egY.getLayoutParams();
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams != null && marginLayoutParams != null && layoutParams.height == getDimensionPixelSize(r.f.ds72)) {
                    layoutParams.height -= marginLayoutParams.topMargin;
                }
            }
            c(edVar);
        }
    }

    private void c(ed edVar) {
        if (edVar.emf != null) {
            com.baidu.tbadk.core.util.ap.k(edVar.emg, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.i((View) edVar.emh, r.e.cp_cont_d);
            com.baidu.tbadk.core.util.ap.i((View) edVar.emi, r.e.cp_cont_e);
            com.baidu.tbadk.core.util.ap.i((View) edVar.emj, r.e.cp_link_tip_a);
            com.baidu.tbadk.core.util.ap.i((View) edVar.eml, r.e.cp_cont_i);
            com.baidu.tbadk.core.util.ap.i((View) edVar.emm, r.e.cp_cont_i);
        }
    }

    private void a(ed edVar, String str) {
        edVar.ems.setVisibility(0);
        com.baidu.adp.lib.f.c.ey().a(str, 17, new ec(this, edVar, str), this.ehi.getUniqueId());
    }

    private void d(ed edVar) {
        edVar.egH.setTextViewOnTouchListener(this.egn);
        edVar.egH.setTextViewCheckSelection(false);
    }

    private void a(ed edVar, com.baidu.tieba.tbadkCore.data.p pVar, boolean z, TbRichText tbRichText) {
        if (pVar == null || pVar.aPB() == null) {
            edVar.ehd.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(pVar.aPB(), edVar.ehd, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(pVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1143=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        if (tbRichTextView == null) {
            return;
        }
        int I = (((com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i = 0;
        if (!z) {
            i = getDimensionPixelSize(r.f.ds132);
        } else if (z2) {
            i = getDimensionPixelSize(r.f.ds64);
        }
        int min = Math.min(I - i, this.egh);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private boolean f(com.baidu.tieba.tbadkCore.data.p pVar) {
        return (pVar == null || pVar.getAuthor() == null || pVar.getAuthor().getGodUserData() == null || pVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void e(ed edVar) {
        edVar.egx.setOnTouchListener(this.egn);
        edVar.egx.setOnLongClickListener(this.anA);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.ehi.getPageContext().getOrignalPage()).ehW;
        edVar.blu.setOnClickListener(aVar.eqy);
        edVar.egB.setOnClickListener(aVar.eqy);
        edVar.egA.setOnClickListener(aVar.eqy);
        edVar.egL.setOnLongClickListener(this.anA);
        edVar.egH.setOnLongClickListener(this.anA);
        edVar.egL.setOnTouchListener(this.egn);
        edVar.egH.setOnTouchListener(this.egn);
        edVar.egH.setCommonTextViewOnClickListener(this.cpK);
        edVar.egH.setOnImageClickListener(this.aHX);
        edVar.egH.setOnEmotionClickListener(aVar.eqA);
        edVar.bXk.setOnClickListener(aVar.bPI);
        edVar.agL.setOnClickListener(aVar.eqz);
        edVar.ehd.setOnClickListener(this.cpK);
        edVar.ems.setOnClickListener(this.cpK);
        edVar.emn.setOnClickListener(this.cpK);
        edVar.emo.setOnClickListener(this.cpK);
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

    public void ik(boolean z) {
        this.ejF = z;
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

    public void im(boolean z) {
        this.ehK = z;
    }

    public void a(TbRichTextView.b bVar) {
        this.elX = bVar;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, r.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.ehi.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
