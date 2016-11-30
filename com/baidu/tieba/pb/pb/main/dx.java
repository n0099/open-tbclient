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
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.view.PbReplyEcommCard;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class dx extends ct<com.baidu.tieba.tbadkCore.data.q, ed> implements View.OnClickListener {
    private TbRichTextView.e aJZ;
    private boolean aez;
    private View.OnLongClickListener aoS;
    private View.OnClickListener bpk;
    protected boolean cNW;
    private ArrayList<IconData> diU;
    protected com.baidu.tieba.pb.data.h esP;
    private com.baidu.tieba.pb.a.d esT;
    protected int etg;
    private boolean eth;
    private String eti;
    private com.baidu.tieba.pb.pb.sub.ba etj;
    private ArrayList<IconData> etk;
    private View.OnClickListener etl;
    private boolean etm;
    private final boolean etn;
    private int eto;
    private int etp;
    private boolean euH;
    private boolean ewr;
    private TbRichTextView.b eyS;
    private boolean eyT;
    private Set<String> eyU;

    private void init() {
        this.eto = getDimensionPixelSize(r.e.ds30);
        this.etp = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(r.e.ds60);
        this.eyU = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dx(PbActivity pbActivity, BdUniqueId bdUniqueId) {
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
        this.eyS = null;
        this.etm = false;
        this.etn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.ewr = false;
        this.eyT = false;
        this.euH = false;
        this.aez = false;
        init();
    }

    private void a(ed edVar) {
        if (edVar != null) {
            if (edVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.at.l(edVar.etv, r.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.at.l(edVar.etN, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.c(edVar.aYg, r.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.at.c((View) edVar.etA, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.at.c((View) edVar.etB, r.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.at.c(edVar.etC, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.at.c(edVar.etD, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.at.k(edVar.ezi, r.f.icon_pb_reply_btn_selector);
                com.baidu.tbadk.core.util.at.c(edVar.ezi, r.f.icon_pb_more_n);
                com.baidu.tbadk.core.util.at.l(edVar.etG, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.at.l(edVar.etH, r.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.at.c(edVar.etH, r.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.at.k(edVar.ezl, r.f.btn_appdownload);
                com.baidu.tbadk.core.util.at.c(edVar.ezl, r.d.cp_cont_i, 1);
                edVar.etF.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.common_color_10039));
                com.baidu.tbadk.core.util.at.c(edVar.eua, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.at.c(edVar.etZ, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.at.c(edVar.etY, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.at.c(edVar.etX, r.d.cp_cont_c, 1);
                com.baidu.tbadk.core.util.at.k(edVar.etx, r.f.bg_floor_new_middle);
                com.baidu.tbadk.core.util.at.l(edVar.etK, r.d.cp_bg_line_e);
                c(edVar);
            }
            edVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public ed a(ViewGroup viewGroup) {
        ed edVar = new ed(this.eug.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.h.new_pb_list_item, viewGroup, false), this.cNW, this.etg);
        a(edVar);
        return edVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ct, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.q qVar, ed edVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tieba.tbadkCore.data.q) edVar);
        a(edVar);
        e(edVar);
        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) aJ(i);
        if (qVar2 != null) {
            qVar2.sN();
            a(edVar, qVar2, view, i);
        }
        if (!this.etm && this.etn && edVar != null && edVar.etF.IQ() && (listView = ((PbActivity) this.eug.getPageContext().getOrignalPage()).getListView()) != null) {
            this.etm = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private boolean oJ(int i) {
        if (aJ(0) instanceof com.baidu.tieba.tbadkCore.data.q) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) aJ(0);
            if (qVar.bml() == 1 && i == 1) {
                return true;
            }
            return qVar.bml() != 1 && i == 0;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v59, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:226:0x07e2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0dfa  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0e06  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0e12  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0e56  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ed edVar, com.baidu.tieba.tbadkCore.data.q qVar, View view, int i) {
        SparseArray sparseArray;
        UserTbVipInfoData userTbVipInfoData;
        com.baidu.tbadk.widget.richText.a aCE;
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<com.baidu.tbadk.data.b> bmu;
        int i2;
        if (edVar != null && qVar != null) {
            edVar.etL.setVisibility(0);
            edVar.etz.setTag(null);
            edVar.etz.setUserId(null);
            edVar.aYg.setText((CharSequence) null);
            edVar.etB.setVisibility(8);
            edVar.etK.setVisibility(0);
            edVar.etE.setVisibility(8);
            SparseArray sparseArray2 = (SparseArray) edVar.etJ.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                edVar.etJ.setTag(sparseArray3);
                edVar.etF.setTag(sparseArray3);
                edVar.etv.setTag(r.g.tag_from, sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_is_subpb, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) edVar.etF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            edVar.etF.setPadding(0, 0, 0, 0);
            if (!this.cNW) {
                if (qVar.bml() == 1) {
                    edVar.etF.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
                    edVar.etF.setIsSupportVitality(false);
                }
            } else if (TextUtils.isEmpty(qVar.getBimg_url())) {
                this.eyT = false;
                sparseArray.put(r.g.tag_richtext_bg, null);
                edVar.etF.gI(null);
                edVar.etF.setBackgroundDrawable(null);
                if (qVar.bml() == 1) {
                    edVar.etF.setIsSupportVitality(true);
                } else {
                    layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds32);
                    edVar.etF.setIsSupportVitality(false);
                }
            } else {
                this.eyT = true;
                edVar.etF.setIsSupportVitality(false);
                if (qVar.bml() == 1) {
                    layoutParams.leftMargin = getDimensionPixelSize(r.e.ds30);
                } else {
                    layoutParams.leftMargin = 0;
                }
                layoutParams.rightMargin = getDimensionPixelSize(r.e.ds30);
                if (qVar.aTO() == null) {
                    layoutParams.bottomMargin = getDimensionPixelSize(r.e.ds24);
                } else {
                    layoutParams.bottomMargin = getDimensionPixelSize(r.e.ds32);
                }
                layoutParams.topMargin = getDimensionPixelSize(r.e.ds24);
                sparseArray.put(r.g.tag_richtext_bg, qVar.getBimg_url());
                edVar.etF.gI(qVar.getBimg_url());
            }
            edVar.etF.setLayoutParams(layoutParams);
            if (qVar.bml() != 1) {
                if (TextUtils.isEmpty(qVar.getBimg_url())) {
                    edVar.etF.setOnClickListener(this.bpk);
                    edVar.etF.setTextViewOnClickListener(this.bpk);
                } else {
                    edVar.etF.setOnClickListener(null);
                    edVar.etF.setTextViewOnClickListener(null);
                }
                edVar.etv.setOnClickListener(this.bpk);
                edVar.etJ.setOnClickListener(this.bpk);
            } else {
                edVar.etv.setOnClickListener(null);
                edVar.etJ.setOnClickListener(null);
            }
            edVar.etD.setText(qVar.bmn());
            if (qVar.bml() == 1) {
                a(edVar.etF, view, true, this.eyT);
                edVar.etN.setVisibility(8);
                edVar.etw.setVisibility(8);
                edVar.etL.setVisibility(8);
                edVar.etJ.setVisibility(8);
                edVar.etD.setVisibility(8);
                edVar.etM.setVisibility(8);
                edVar.euc.setVisibility(8);
                edVar.etI.setVisibility(0);
                String str = null;
                long j = 0;
                if (qVar.getAuthor() != null) {
                    j = qVar.getAuthor().getUserIdLong();
                    str = qVar.getAuthor().getUserName();
                }
                if (this.esP != null && this.esP.aOl() != null) {
                    edVar.etI.a(qVar.bms(), str, j, com.baidu.adp.lib.h.b.c(this.esP.aOl().getId(), 0L), com.baidu.adp.lib.h.b.c(qVar.getId(), 0L));
                }
                edVar.etI.tB();
                if (this.eth) {
                    PraiseData praiseData = null;
                    if (this.esP != null && this.esP.aOl() != null) {
                        this.esP.aOl().rH();
                    }
                    if (0 != 0 && praiseData.getUser() != null && praiseData.getUser().size() > 0) {
                        edVar.etG.setVisibility(0);
                        edVar.etH.setVisibility(0);
                        edVar.etG.setIsFromPb(true);
                        edVar.etG.a(null, this.esP.aOl().getId(), praiseData.getPostId(), true);
                        edVar.etG.dm(this.mSkinType);
                    } else {
                        edVar.etG.setVisibility(8);
                        edVar.etH.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.d.ak(edVar.etG);
                    com.baidu.tieba.graffiti.d.ak(edVar.etH);
                    edVar.etW.setVisibility(0);
                    edVar.etY.setText(qVar.bmn());
                    com.baidu.tbadk.data.g bmo = qVar.bmo();
                    edVar.eua.setVisibility(8);
                    if (bmo != null && !TextUtils.isEmpty(bmo.getName()) && !TextUtils.isEmpty(bmo.getName().trim())) {
                        String name = bmo.getName();
                        String lat = bmo.getLat();
                        String lng = bmo.getLng();
                        edVar.etZ.setVisibility(0);
                        com.baidu.adp.lib.util.k.a(this.mContext, edVar.etZ, 0, 10, 0, 10);
                        edVar.etZ.setText(bmo.getName());
                        edVar.etZ.setOnClickListener(new dy(this, lat, lng, name));
                    } else {
                        edVar.etZ.setVisibility(8);
                    }
                    if (this.esP.aOz() != null && !StringUtils.isNull(this.esP.aOz().pR(), true)) {
                        b(edVar);
                    }
                } else {
                    edVar.etG.setVisibility(8);
                    edVar.etH.setVisibility(8);
                    if (qVar.getAuthor() != null && qVar.getAuthor().getGodInfo() != null) {
                        edVar.etI.jl(false);
                    } else {
                        edVar.etG.setVisibility(8);
                        edVar.etH.setVisibility(8);
                        edVar.etZ.setVisibility(8);
                        edVar.eua.setVisibility(8);
                    }
                    if (this.esP.aOz() != null && !StringUtils.isNull(this.esP.aOz().pR(), true) && edVar.eza != null) {
                        edVar.eza.setVisibility(8);
                        edVar.ezf.Em();
                    }
                }
                if (this.eug.aPc().aSA()) {
                    edVar.etF.setVisibility(8);
                }
                if (this.esP.aOl() != null && this.esP.aOl().sa() != null) {
                    com.baidu.tbadk.core.data.bu sa = this.esP.aOl().sa();
                    String activityUrl = sa.getActivityUrl();
                    String tk = sa.tk();
                    String tl = sa.tl();
                    if (!StringUtils.isNull(tl)) {
                        edVar.ezl.setVisibility(0);
                        edVar.ezl.setText(tl);
                        edVar.ezl.setOnClickListener(new dz(this, activityUrl));
                        edVar.ezm.setOnClickListener(new ea(this, activityUrl));
                        if (!StringUtils.isNull(tk)) {
                            edVar.bUF.setVisibility(0);
                            edVar.bUF.c(tk, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    edVar.ezl.setVisibility(8);
                    edVar.bUF.setVisibility(8);
                }
                if (edVar.ezq != null) {
                    edVar.ezq.setVisibility(8);
                }
                if (this.esP != null && this.esP.aOl() != null && this.esP.aOl().sB()) {
                    edVar.ezv.ceJ.setVisibility(0);
                    edVar.ezv.b(this.esP);
                    edVar.ezv.onChangeSkinType(this.mSkinType);
                    edVar.ezv.d(qVar.Il());
                } else {
                    edVar.ezv.ceJ.setVisibility(8);
                }
            } else {
                if (this.esP.aOz() != null && !StringUtils.isNull(this.esP.aOz().pR(), true) && edVar.eza != null) {
                    edVar.eza.setVisibility(8);
                }
                edVar.etF.setVisibility(0);
                a(edVar.etF, view, false, this.eyT);
                edVar.etw.setVisibility(0);
                edVar.etM.setVisibility(0);
                edVar.bUF.setVisibility(8);
                edVar.ezl.setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = edVar.etN.getLayoutParams();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) edVar.etL.getLayoutParams();
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) edVar.etJ.getLayoutParams();
                if (oJ(i)) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds20);
                    layoutParams3.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
                    layoutParams4.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds6);
                } else {
                    layoutParams4.topMargin = 0;
                    layoutParams3.topMargin = 0;
                    layoutParams2.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds1);
                }
                edVar.etL.setLayoutParams(layoutParams3);
                edVar.etJ.setLayoutParams(layoutParams4);
                edVar.etN.setLayoutParams(layoutParams2);
                edVar.etN.setVisibility(0);
                edVar.etI.setVisibility(8);
                edVar.etG.setVisibility(8);
                edVar.etH.setVisibility(8);
                edVar.etJ.setVisibility(0);
                edVar.etL.setVisibility(0);
                edVar.etD.setVisibility(0);
                com.baidu.tbadk.data.g bmo2 = qVar.bmo();
                edVar.etW.setVisibility(8);
                if (bmo2 != null && !TextUtils.isEmpty(bmo2.getName()) && !TextUtils.isEmpty(bmo2.getName().trim())) {
                    String name2 = bmo2.getName();
                    String lat2 = bmo2.getLat();
                    String lng2 = bmo2.getLng();
                    edVar.eua.setVisibility(0);
                    edVar.eua.setText(bmo2.getName());
                    edVar.eua.setOnClickListener(new eb(this, lat2, lng2, name2));
                } else {
                    edVar.eua.setVisibility(8);
                }
                String format = String.format(this.mContext.getString(r.j.is_floor), Integer.valueOf(qVar.bml()));
                edVar.etC.setVisibility(0);
                edVar.etC.setText(format);
                if (edVar.ezq != null) {
                    if (qVar.si() != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) edVar.etL.getLayoutParams();
                        marginLayoutParams.topMargin = (int) this.eug.getResources().getDimension(r.e.ds16);
                        edVar.etL.setLayoutParams(marginLayoutParams);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) edVar.ezr.getLayoutParams();
                        marginLayoutParams2.topMargin = (int) this.eug.getResources().getDimension(r.e.ds10);
                        edVar.ezr.setLayoutParams(marginLayoutParams2);
                        edVar.ezq.a(this.eug.getPageContext(), qVar.si(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", this.esP.aOk().getId(), this.esP.aOk().getName(), this.esP.aOl().getId(), null));
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) edVar.ezu.getLayoutParams();
                        marginLayoutParams3.leftMargin = (int) this.eug.getResources().getDimension(r.e.ds30);
                        marginLayoutParams3.rightMargin = (int) this.eug.getResources().getDimension(r.e.ds30);
                        edVar.ezu.setLayoutParams(marginLayoutParams3);
                    } else {
                        edVar.ezq.a(null, null, null);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) edVar.ezu.getLayoutParams();
                        marginLayoutParams4.leftMargin = 0;
                        marginLayoutParams4.rightMargin = 0;
                        edVar.ezu.setLayoutParams(marginLayoutParams4);
                    }
                }
            }
            if (this.eti != null && !this.eti.equals("0") && this.eti.equals(qVar.getAuthor().getUserId())) {
                edVar.etE.setVisibility(0);
                com.baidu.tbadk.core.util.at.j((View) edVar.etE, r.d.cp_link_tip_a);
            } else {
                edVar.etE.setVisibility(8);
            }
            edVar.etF.setVideoImageId(r.f.pic_video);
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(r.g.tag_clip_board, qVar);
            sparseArray4.put(r.g.tag_load_sub_data, qVar);
            sparseArray4.put(r.g.tag_load_sub_view, view);
            sparseArray4.put(r.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray4.put(r.g.tag_pb_floor_number, Integer.valueOf(qVar.bml()));
            edVar.ezi.setTag(sparseArray4);
            edVar.ezj.setTag(sparseArray4);
            if (qVar.bmp() > 0 && qVar.bmi() != null && qVar.bmi().size() > 0) {
                if (this.etj == null) {
                    this.etj = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.etj.setIsFromCDN(this.mIsFromCDN);
                    this.etj.J(this.etl);
                    boolean z4 = false;
                    String userId = this.esP.aOl().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z4 = true;
                    }
                    this.etj.P(this.esP.aOt(), z4);
                    this.etj.c(this.esP.aOl());
                }
                this.etj.pM(qVar.getId());
                edVar.etK.setVisibility(0);
                edVar.etK.a(qVar, view);
                edVar.etK.setChildOnClickListener(this.bpk);
                edVar.etK.setChildOnLongClickListener(this.aoS);
                edVar.etK.setChildOnTouchListener(this.esT);
                edVar.etK.setSubPbAdapter(this.etj);
                edVar.etK.setVisibility(0);
                edVar.euc.setVisibility(0);
                edVar.euc.invalidate();
                edVar.etM.setPadding(0, 0, 0, 0);
            } else {
                edVar.etM.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds26));
                edVar.etK.setVisibility(8);
                edVar.euc.setVisibility(8);
            }
            String portrait = qVar.getAuthor().getPortrait();
            if (qVar.getAuthor() != null) {
                String name_show = qVar.getAuthor().getName_show();
                int gD = com.baidu.tbadk.util.u.gD(name_show);
                if (!StringUtils.isNull(qVar.getAuthor().getSealPrefix())) {
                    if (gD > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 12)) + "...";
                    }
                } else if (gD > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                if (!StringUtils.isNull(qVar.getAuthor().getSealPrefix())) {
                    edVar.aYg.setText(ag(qVar.getAuthor().getSealPrefix(), name_show));
                } else {
                    edVar.aYg.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.at.c(edVar.aYg, r.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.at.c(edVar.aYg, r.d.cp_cont_f, 1);
                }
                int level_id = qVar.getAuthor().getLevel_id();
                int is_bawu = qVar.getAuthor().getIs_bawu();
                String bawu_type = qVar.getAuthor().getBawu_type();
                if (level_id != 0) {
                    edVar.etA.setVisibility(0);
                    com.baidu.tbadk.core.util.at.c(edVar.etA, BitmapHelper.getGradeResourceIdNew(level_id));
                    String bmw = qVar.bmw();
                    if (StringUtils.isNull(bmw)) {
                        bmw = String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id));
                    }
                    edVar.etA.setContentDescription(bmw);
                    edVar.etA.setOnClickListener(null);
                } else {
                    edVar.etA.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.at.c(edVar.etB, r.f.pb_manager);
                        edVar.etA.setVisibility(8);
                        edVar.etB.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.at.c(edVar.etB, r.f.pb_assist);
                        edVar.etA.setVisibility(8);
                        edVar.etB.setVisibility(0);
                    }
                    if (edVar.etB.getVisibility() == 0) {
                        edVar.etB.setAlpha(179);
                    }
                }
                if (edVar.etA.getVisibility() == 0) {
                    edVar.etA.setAlpha(179);
                }
                int gD2 = com.baidu.tbadk.util.u.gD(qVar.getAuthor().getName_show());
                if (gD2 < 14 || edVar.etA.getVisibility() != 0 || edVar.etE.getVisibility() != 0) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                int i3 = (StringUtils.isNull(qVar.getAuthor().getSealPrefix()) || gD2 < 12 || edVar.etA.getVisibility() != 0 || edVar.etE.getVisibility() != 0) ? i2 : i2 - 1;
                this.etk = qVar.getAuthor().getIconInfo();
                this.diU = qVar.getAuthor().getTShowInfoNew();
                if (edVar.clv != null) {
                    if (com.baidu.tbadk.core.util.x.t(this.etk)) {
                        edVar.clv.setVisibility(8);
                    } else {
                        edVar.clv.setVisibility(0);
                    }
                    edVar.clv.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                    edVar.clv.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.bXu);
                    edVar.clv.wQ();
                    edVar.clv.a(this.etk, i3, getDimensionPixelSize(r.e.ds24), getDimensionPixelSize(r.e.ds24), getDimensionPixelSize(r.e.ds10));
                }
                if (edVar.ahW != null) {
                    edVar.ahW.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDk);
                    if (this.diU != null && this.diU.size() > 0 && this.diU.get(0) != null) {
                        edVar.ahW.setTag(this.diU.get(0).getUrl());
                    }
                    edVar.ahW.a(this.diU, 3, getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds36), getDimensionPixelSize(r.e.ds8), true);
                }
            }
            if (qVar.getAuthor() == null || qVar.getAuthor().getUserTbVipInfoData() == null) {
                userTbVipInfoData = null;
            } else {
                userTbVipInfoData = qVar.getAuthor().getUserTbVipInfoData();
            }
            if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getPendantData() != null && !StringUtils.isNull(qVar.getAuthor().getPendantData().pR())) {
                edVar.etz.setVisibility(4);
                edVar.ezk.setVisibility(8);
                edVar.ety.setVisibility(0);
                edVar.ezk.setVisibility(8);
                edVar.ety.getHeadView().setUserId(qVar.getAuthor().getUserId());
                edVar.ety.getHeadView().ae(qVar.getAuthor().getUserName(), qVar.bmv());
                edVar.ety.getHeadView().setImageDrawable(null);
                edVar.ety.getHeadView().c(portrait, 28, false);
                edVar.ety.dZ(qVar.getAuthor().getPendantData().pR());
                edVar.ety.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                edVar.ety.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            } else if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                if (edVar.bbQ != null) {
                    if (edVar.bbR == null) {
                        edVar.bbQ.inflate();
                        edVar.bbR = (TbImageView) edVar.getView().findViewById(r.g.user_head_mask);
                    }
                    if (edVar.bbR != null) {
                        edVar.bbR.c(userTbVipInfoData.getvipV_url(), 10, false);
                    }
                    edVar.ezk.setIsBigV(true);
                }
                edVar.etz.setVisibility(4);
                edVar.ezk.setVisibility(0);
                edVar.ety.setVisibility(8);
                edVar.ezk.setData(qVar.getAuthor());
                edVar.ezk.setUserId(qVar.getAuthor().getUserId());
                edVar.ezk.ae(qVar.getAuthor().getUserName(), qVar.bmv());
            } else {
                edVar.ety.setVisibility(8);
                if (g(qVar)) {
                    edVar.etz.setVisibility(4);
                    edVar.ezk.setVisibility(0);
                    edVar.ezk.c(portrait, 28, false);
                    edVar.ezk.setUserId(qVar.getAuthor().getUserId());
                    edVar.ezk.ae(qVar.getAuthor().getUserName(), qVar.bmv());
                    edVar.ezk.setOnClickListener(((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ.eDj);
                } else {
                    edVar.etz.setVisibility(0);
                    edVar.ezk.setVisibility(8);
                    edVar.etz.setUserId(qVar.getAuthor().getUserId());
                    edVar.etz.ae(qVar.getAuthor().getUserName(), qVar.bmv());
                    edVar.etz.setImageDrawable(null);
                    edVar.etz.c(portrait, 28, false);
                }
            }
            edVar.aYg.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
            edVar.aYg.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            edVar.etF.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_c));
            if (this.cNW) {
                edVar.etF.setDefaultImageId(r.f.transparent_bg);
            } else {
                edVar.etF.setDefaultImageId(r.f.icon_click);
            }
            edVar.etF.setIsFromCDN(this.mIsFromCDN);
            if (0 != 0) {
                aCE = null;
            } else {
                aCE = qVar.aCE();
            }
            if (this.etm || !this.etn) {
                edVar.etF.a(aCE, false, this.eyS);
            } else {
                edVar.etF.a(aCE, true, this.eyS);
            }
            boolean z5 = false;
            boolean z6 = false;
            if (this.esP != null && this.esP.aOt() != 0) {
                z5 = true;
                z6 = true;
                if (qVar != null && qVar.getAuthor() != null) {
                    String userId2 = qVar.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z5 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z5 = false;
                    }
                }
            }
            if (this.esP != null && this.esP.aOl() != null && this.esP.aOl().getAuthor() != null && qVar.getAuthor() != null) {
                String userId3 = this.esP.aOl().getAuthor().getUserId();
                String userId4 = qVar.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId3)) {
                    if (!UtilHelper.isCurrentAccount(userId4)) {
                        z = true;
                        z3 = false;
                        z2 = true;
                    } else {
                        z3 = true;
                        z = false;
                        z2 = true;
                    }
                    if (qVar != null && qVar.getAuthor() != null && UtilHelper.isCurrentAccount(qVar.getAuthor().getUserId())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i4 = 1;
                    if (qVar.bml() == 1) {
                        i4 = 0;
                    }
                    sparseArray4.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z5) {
                        sparseArray4.put(r.g.tag_should_manage_visible, true);
                        sparseArray4.put(r.g.tag_manage_user_identity, Integer.valueOf(this.esP.aOt()));
                        sparseArray4.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray4.put(r.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray4.put(r.g.tag_user_mute_visible, true);
                        sparseArray4.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray4.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray4.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.esP.aOl() != null) {
                            sparseArray4.put(r.g.tag_user_mute_thread_id, this.esP.aOl().getId());
                        }
                        sparseArray4.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray4.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z2) {
                        sparseArray4.put(r.g.tag_should_delete_visible, true);
                        sparseArray4.put(r.g.tag_manage_user_identity, Integer.valueOf(this.esP.aOt()));
                        sparseArray4.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray4.put(r.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray4.put(r.g.tag_del_post_id, qVar.getId());
                    } else {
                        sparseArray4.put(r.g.tag_should_delete_visible, false);
                    }
                    bmu = qVar.bmu();
                    if (bmu.size() > 0 || (qVar.bml() == 1 && this.eug.aPc().aSA())) {
                        edVar.ezn.setVisibility(8);
                    } else {
                        com.baidu.tbadk.data.b bVar = bmu.get(0);
                        if (!StringUtils.isNull(bVar.getIconUrl())) {
                            a(edVar, bVar.getIconUrl());
                            if (!StringUtils.isNull(bVar.BZ())) {
                                edVar.ezn.setTag(r.g.tag_pb_lottery_tail_link, bVar.BZ());
                            }
                        } else {
                            edVar.ezn.setVisibility(8);
                        }
                    }
                    a(edVar, qVar, qVar.bml() != 1, aCE);
                    d(edVar);
                    a(qVar, edVar);
                }
            }
            z = false;
            z2 = z6;
            z3 = false;
            if (qVar != null) {
                z2 = true;
                z3 = true;
            }
            int i42 = 1;
            if (qVar.bml() == 1) {
            }
            sparseArray4.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z5) {
            }
            if (!z) {
            }
            if (!z2) {
            }
            bmu = qVar.bmu();
            if (bmu.size() > 0) {
            }
            edVar.ezn.setVisibility(8);
            a(edVar, qVar, qVar.bml() != 1, aCE);
            d(edVar);
            a(qVar, edVar);
        }
    }

    private void b(ed edVar) {
        if (edVar != null && this.esP != null && this.esP.aOz() != null) {
            edVar.aRq();
            edVar.eza.setOnClickListener(this.bpk);
            com.baidu.tieba.pb.data.l aOz = this.esP.aOz();
            edVar.ezf.setSupportNoImage(true);
            edVar.ezf.setInterceptOnClick(true);
            if (this.cNW) {
                edVar.ezf.setDefaultResource(r.f.transparent_bg);
                edVar.ezf.c(aOz.pR(), 17, false);
            } else {
                edVar.ezf.setDefaultResource(r.f.icon_click);
            }
            edVar.ezf.setOnClickListener(this.bpk);
            edVar.eze.setOnClickListener(this.bpk);
            int aOD = aOz.aOD();
            String aOE = StringUtils.isNull(aOz.aOE(), true) ? "" : aOz.aOE();
            String string = this.mContext.getString(r.j.yule_head_img);
            if (aOD <= 0) {
                edVar.ezd.setVisibility(8);
                edVar.eze.setVisibility(8);
            } else {
                edVar.ezd.setVisibility(0);
                edVar.eze.setVisibility(0);
                if (aOD > 20) {
                    string = String.format(this.mContext.getString(r.j.yule_head_img_rank), "20+");
                } else {
                    string = String.format(this.mContext.getString(r.j.yule_head_img_rank), new StringBuilder(String.valueOf(aOD)).toString());
                }
                edVar.ezd.setText(" " + aOE);
            }
            edVar.ezc.setText(string);
            if (aOz.pO()) {
                edVar.ezg.setVisibility(8);
            } else {
                edVar.ezg.setVisibility(0);
                edVar.ezg.setText(String.format(this.mContext.getString(r.j.yule_head_img_pic_author), aOz.pQ()));
            }
            if (StringUtils.isNull(this.esP.aOl().getAuthor().getName_show(), true)) {
                edVar.ezh.setVisibility(8);
            } else {
                edVar.ezh.setVisibility(0);
                edVar.ezh.setText(String.format(this.mContext.getString(r.j.yule_head_img_post_author), this.esP.aOl().getAuthor().getName_show()));
            }
            if (edVar.etW.getVisibility() == 0) {
                View findViewById = edVar.etv.findViewById(r.g.yule_head_img_blank);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) edVar.etW.getLayoutParams();
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams != null && marginLayoutParams != null && layoutParams.height == getDimensionPixelSize(r.e.ds72)) {
                    layoutParams.height -= marginLayoutParams.topMargin;
                }
            }
            c(edVar);
        }
    }

    private void c(ed edVar) {
        if (edVar.eza != null) {
            com.baidu.tbadk.core.util.at.l(edVar.ezb, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) edVar.ezc, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) edVar.ezd, r.d.cp_cont_e);
            com.baidu.tbadk.core.util.at.j((View) edVar.eze, r.d.cp_link_tip_a);
            com.baidu.tbadk.core.util.at.j((View) edVar.ezg, r.d.cp_cont_i);
            com.baidu.tbadk.core.util.at.j((View) edVar.ezh, r.d.cp_cont_i);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, ed edVar) {
        if (qVar.bml() == 1 && this.eth) {
            if (edVar.ezt != null) {
                edVar.ezt.setVisibility(8);
            }
        } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class) && EcommSwitchStatic.GN()) {
            DealInfoData dealInfoData = qVar.dealInfoData;
            if (dealInfoData != null) {
                PbReplyEcommCard aRp = edVar.aRp();
                aRp.a(dealInfoData, qVar.getId());
                t(qVar.getId(), dealInfoData.productId);
                aRp.setVisibility(0);
                aRp.aTX();
            } else if (edVar.ezt != null) {
                edVar.ezt.setVisibility(8);
            }
        }
    }

    private void t(String str, long j) {
        if (!this.eyU.contains(str)) {
            this.eyU.add(str);
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11424").ab("tid", str).g("obj_id", j));
        }
    }

    private void a(ed edVar, String str) {
        edVar.ezn.setVisibility(0);
        com.baidu.adp.lib.g.c.eA().a(str, 17, new ec(this, edVar, str), this.eug.getUniqueId());
    }

    private void d(ed edVar) {
        edVar.etF.setTextViewOnTouchListener(this.esT);
        edVar.etF.setTextViewCheckSelection(false);
    }

    private void a(ed edVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (qVar == null || qVar.aTO() == null) {
            edVar.eub.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.s.a(qVar.aTO(), edVar.eub, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(qVar.getBimg_url()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1161=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z, boolean z2) {
        int i = 0;
        if (tbRichTextView == null) {
            return;
        }
        int K = (((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (!z) {
            i = getDimensionPixelSize(r.e.ds80);
        } else if (z2) {
        }
        int min = Math.min(K - i, this.etg);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private boolean g(com.baidu.tieba.tbadkCore.data.q qVar) {
        return (qVar == null || qVar.getAuthor() == null || qVar.getAuthor().getGodUserData() == null || qVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }

    private void e(ed edVar) {
        edVar.etv.setOnTouchListener(this.esT);
        edVar.etv.setOnLongClickListener(this.aoS);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eug.getPageContext().getOrignalPage()).euQ;
        edVar.aYg.setOnClickListener(aVar.eDj);
        edVar.etz.setOnClickListener(aVar.eDj);
        edVar.ety.setOnClickListener(aVar.eDj);
        edVar.etJ.setOnLongClickListener(this.aoS);
        edVar.etF.setOnLongClickListener(this.aoS);
        edVar.etJ.setOnTouchListener(this.esT);
        edVar.etF.setOnTouchListener(this.esT);
        edVar.etF.setCommonTextViewOnClickListener(this.bpk);
        edVar.etF.setOnImageClickListener(this.aJZ);
        edVar.etF.setOnEmotionClickListener(aVar.eDl);
        edVar.clv.setOnClickListener(aVar.bXu);
        edVar.ahW.setOnClickListener(aVar.eDk);
        edVar.eub.setOnClickListener(this.bpk);
        edVar.ezn.setOnClickListener(this.bpk);
        edVar.ezi.setOnClickListener(this.bpk);
        edVar.ezj.setOnClickListener(this.bpk);
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

    public void il(boolean z) {
        this.ewr = z;
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

    public void in(boolean z) {
        this.euH = z;
    }

    public void a(TbRichTextView.b bVar) {
        this.eyS = bVar;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new an.a(str, r.f.pic_smalldot_title));
            return com.baidu.tieba.card.an.a((Context) this.eug.getActivity(), str2, (ArrayList<an.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
