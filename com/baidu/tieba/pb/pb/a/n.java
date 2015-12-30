package com.baidu.tieba.pb.pb.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ce;
import com.baidu.tieba.pb.pb.sub.am;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends ce<com.baidu.tieba.tbadkCore.data.r, r> implements View.OnClickListener {
    private TbRichTextView.d aFq;
    private View.OnLongClickListener amQ;
    private ArrayList<IconData> bcl;
    private View.OnClickListener bjD;
    private boolean cDQ;
    private com.baidu.tieba.pb.a.c cDR;
    private String cDX;
    private am cDY;
    private ArrayList<IconData> cDZ;
    private int cDq;
    private boolean cDr;
    private boolean cDs;
    private com.baidu.tieba.pb.b.c cDu;
    private boolean cDw;
    private final boolean cDx;
    private int cDy;
    private int cDz;
    private View.OnClickListener cEa;
    private com.baidu.tieba.vote.b cEb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cDq = 0;
        this.cDr = true;
        this.cDQ = true;
        this.cDs = true;
        this.cDR = null;
        this.cDX = null;
        this.cDY = null;
        this.cDZ = null;
        this.bcl = null;
        this.cEa = null;
        this.bjD = null;
        this.aFq = null;
        this.cDu = null;
        this.amQ = null;
        this.cDw = false;
        this.cDx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                as.j(rVar.cEj, n.d.cp_bg_line_b);
                as.j(rVar.cEk, n.d.cp_bg_line_b);
                as.b(rVar.cEA, n.d.subpb_listitem_time, 1);
                as.b(rVar.cEC, n.d.cp_link_tip_c, 3);
                as.b(rVar.aLp, n.d.cp_cont_f, 1);
                as.b((View) rVar.cEo, n.d.cp_cont_i, 1);
                as.b((View) rVar.cEp, n.d.cp_cont_i, 1);
                as.b(rVar.cEr, n.d.cp_cont_d, 1);
                as.b(rVar.bIB, n.d.cp_cont_d, 1);
                as.c(rVar.cEt, n.f.btn_pb_reply_selector);
                as.j(rVar.cDE, n.d.cp_bg_line_b);
                as.j(rVar.cDF, n.d.cp_bg_line_e);
                as.j(rVar.cDG, n.d.cp_bg_line_e);
                as.c(rVar.cDG, n.d.cp_bg_line_b);
                as.c(rVar.cEw, n.d.cp_bg_line_b);
            }
            rVar.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    private void init() {
        this.cDy = getDimensionPixelSize(n.e.ds30);
        this.cDz = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(n.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public r a(ViewGroup viewGroup) {
        r rVar = new r(LayoutInflater.from(this.mContext).inflate(n.h.new_pb_list_item, viewGroup, false), this.cDQ, this.cDr, this.cDq, false);
        a(rVar);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, r rVar2) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) rVar2);
        a(rVar2);
        c(rVar2);
        com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) au(i);
        if (rVar3 != null) {
            a(rVar2, rVar3, view, false, i);
        }
        if (!this.cDw && this.cDx && rVar2 != null && rVar2.cDC.Gc() && (listView = ((PbActivity) this.cGj.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cDw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a0c  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a3c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0a48  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0a54  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(r rVar, com.baidu.tieba.tbadkCore.data.r rVar2, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (rVar != null && rVar2 != null) {
            if (!z) {
                rVar.cEn.setTag(null);
                rVar.cEn.setUserId(null);
                rVar.aLp.setText((CharSequence) null);
                rVar.cEp.setVisibility(8);
                rVar.cEx.setVisibility(0);
                rVar.cEt.setVisibility(0);
                rVar.cEs.setVisibility(8);
                if (rVar2.aFs() == null || b(rVar2)) {
                    rVar.cEy.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && rVar2.aFs().AH() == 1) {
                    rVar.cEy.changeSkinType(this.mSkinType);
                    rVar.cEy.setVisibility(0);
                    rVar.cEy.setData(rVar2.aFs());
                } else {
                    rVar.cEy.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) rVar.cEu.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    rVar.cEu.setTag(sparseArray2);
                    rVar.cDC.setTag(sparseArray2);
                }
                sparseArray2.put(n.g.tag_clip_board, rVar2);
                sparseArray2.put(n.g.tag_is_subpb, false);
                a(rVar.cDC, getDimensionPixelSize(n.e.ds30));
                if (TextUtils.isEmpty(rVar2.getBimg_url()) || !this.cDr || b(rVar2)) {
                    sparseArray2.put(n.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.cDC.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    rVar.cDC.setLayoutParams(layoutParams);
                    rVar.cDC.setPadding(0, 0, 0, 0);
                    rVar.cDC.gl(null);
                } else {
                    sparseArray2.put(n.g.tag_richtext_bg, rVar2.getBimg_url());
                    rVar.cDC.gl(rVar2.getBimg_url());
                    if (rVar2.aFq() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.cDC.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(n.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(n.e.ds40);
                        rVar.cDC.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.cDC.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(n.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(n.e.ds20);
                        rVar.cDC.setLayoutParams(layoutParams3);
                    }
                }
                rVar.bIB.setText(ax.s(rVar2.getTime()));
                rVar.cDH.setVisibility(8);
                if (rVar2.aFq() == 1) {
                    as.j(rVar.cEi, n.d.cp_bg_line_d);
                    rVar.cEj.setVisibility(8);
                    rVar.cEk.setVisibility(8);
                    rVar.cEl.setVisibility(8);
                    rVar.cEu.setVisibility(8);
                    rVar.bIB.setVisibility(8);
                    rVar.cDH.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (rVar2.getAuthor() != null) {
                        j = rVar2.getAuthor().getUserIdLong();
                        str = rVar2.getAuthor().getUserName();
                    }
                    rVar.cDH.a(rVar2.aFz(), str, j, com.baidu.adp.lib.h.b.c(this.cDR.akH().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar2.getId(), 0L));
                    rVar.cDH.tr();
                    if (this.cDs) {
                        PraiseData praise = this.cDR.akH().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            rVar.cDF.setVisibility(0);
                            rVar.cDE.setVisibility(0);
                            rVar.cDG.setVisibility(0);
                            rVar.cDF.setIsFromPb(true);
                            rVar.cDF.a(praise, this.cDR.akH().getId(), praise.getPostId(), true);
                            rVar.cDF.cR(this.mSkinType);
                        } else {
                            rVar.cDF.setVisibility(8);
                            rVar.cDE.setVisibility(8);
                            rVar.cDG.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aFt = rVar2.aFt();
                        rVar.cEK.setVisibility(8);
                        if (aFt != null && !TextUtils.isEmpty(aFt.getName()) && !TextUtils.isEmpty(aFt.getName().trim())) {
                            String name = aFt.getName();
                            String lat = aFt.getLat();
                            String lng = aFt.getLng();
                            rVar.cEH.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, rVar.cEH, 0, 10, 0, 10);
                            rVar.cEJ.setText(aFt.getName());
                            as.b(rVar.cEJ, n.d.cp_cont_c, 1);
                            as.c(rVar.cEI, n.f.icon_frs_site);
                            rVar.cEH.setOnClickListener(new o(this, lat, lng, name));
                        } else {
                            rVar.cEH.setVisibility(8);
                        }
                    } else {
                        rVar.cDF.setVisibility(8);
                        rVar.cDE.setVisibility(8);
                        rVar.cDG.setVisibility(8);
                        rVar.cEH.setVisibility(8);
                        rVar.cEK.setVisibility(8);
                    }
                    a(rVar.cDC, getDimensionPixelSize(n.e.ds30));
                    ((LinearLayout.LayoutParams) rVar.cEy.getLayoutParams()).leftMargin = getDimensionPixelSize(n.e.ds30);
                } else {
                    as.j(rVar.cEi, n.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cDs) {
                            rVar.cEj.setVisibility(8);
                            rVar.cEk.setVisibility(8);
                            PraiseData praise2 = this.cDR.akH().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                rVar.cEk.setVisibility(8);
                                rVar.cEj.setVisibility(0);
                            } else {
                                rVar.cEk.setVisibility(0);
                                rVar.cEj.setVisibility(8);
                            }
                        } else {
                            rVar.cEj.setVisibility(0);
                            rVar.cEk.setVisibility(8);
                        }
                    } else {
                        rVar.cEj.setVisibility(0);
                        rVar.cEk.setVisibility(8);
                    }
                    rVar.cEl.setVisibility(0);
                    com.baidu.tbadk.data.d aFt2 = rVar2.aFt();
                    rVar.cEH.setVisibility(8);
                    if (aFt2 != null && !TextUtils.isEmpty(aFt2.getName()) && !TextUtils.isEmpty(aFt2.getName().trim())) {
                        String name2 = aFt2.getName();
                        String lat2 = aFt2.getLat();
                        String lng2 = aFt2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) rVar.cEK.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.cDQ) {
                                layoutParams4.leftMargin = getDimensionPixelSize(n.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(n.e.ds104);
                            }
                            rVar.cEK.setLayoutParams(layoutParams4);
                        }
                        rVar.cEK.setVisibility(0);
                        rVar.cEM.setText(aFt2.getName());
                        as.b(rVar.cEM, n.d.cp_cont_c, 1);
                        as.c(rVar.cEL, n.f.icon_frs_site);
                        rVar.cEK.setOnClickListener(new p(this, lat2, lng2, name2));
                    } else {
                        rVar.cEK.setVisibility(8);
                    }
                    rVar.cDF.setVisibility(8);
                    rVar.cDE.setVisibility(8);
                    rVar.cDG.setVisibility(8);
                    rVar.cEu.setVisibility(0);
                    rVar.bIB.setVisibility(0);
                    String format = String.format(this.mContext.getString(n.j.is_floor), Integer.valueOf(rVar2.aFq()));
                    rVar.cEr.setVisibility(0);
                    rVar.cEr.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) rVar.cEy.getLayoutParams();
                    if (!this.cDQ) {
                        a(rVar.cDC, getDimensionPixelSize(n.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(n.e.ds74);
                    } else {
                        a(rVar.cDC, getDimensionPixelSize(n.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(n.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) rVar.cEv.getLayoutParams();
                    if (!this.cDQ) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(n.e.ds30);
                    }
                }
                if (this.cDX != null && !this.cDX.equals("0") && this.cDX.equals(rVar2.getAuthor().getUserId())) {
                    rVar.cEs.setVisibility(0);
                    as.c(rVar.cEs, n.f.icon_floorhost);
                }
            }
            as.i(rVar.cEm, n.f.bg_floor_new_middle);
            rVar.cDC.setVideoImageId(n.f.pic_video);
            rVar.cDC.setTextColor(as.getColor(n.d.pb_listitem_content));
            as.c(rVar.cEt, n.f.btn_pb_reply_selector);
            rVar.cDC.setLinkTextColor(as.getColor(n.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) rVar.cEt.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                rVar.cEt.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(n.g.tag_clip_board, rVar2);
            sparseArray.put(n.g.tag_load_sub_data, rVar2);
            sparseArray.put(n.g.tag_load_sub_view, view);
            if (rVar2.aFu() > 0) {
                if (this.cDY == null) {
                    this.cDY = new am(this.mContext);
                    this.cDY.setIsFromCDN(this.mIsFromCDN);
                    this.cDY.D(this.cEa);
                    boolean z7 = false;
                    String userId2 = this.cDR.akH().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cDY.r(this.cDR.akL(), z7);
                    this.cDY.g(this.cDR.akH());
                    this.cDY.eU(this.cDQ);
                }
                rVar.cEx.setVisibility(0);
                rVar.cEw.setVisibility(0);
                rVar.cEv.setVisibility(0);
                rVar.cEx.a(rVar2, view);
                rVar.cEx.setChildOnClickListener(this.bjD);
                rVar.cEx.setChildOnLongClickListener(this.amQ);
                rVar.cEx.setChildOnTouchListener(this.cDu);
                rVar.cEx.setSubPbAdapter(this.cDY);
                rVar.cEx.setVisibility(0);
            } else {
                rVar.cEx.setVisibility(8);
                rVar.cEw.setVisibility(8);
                rVar.cEv.setVisibility(8);
            }
            a(rVar, rVar2, this.cDR.akO(), i);
            if (!z) {
                String portrait = rVar2.getAuthor().getPortrait();
                if (rVar2.getAuthor() != null) {
                    String name_show = rVar2.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.o.gi(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.o.e(name_show, 0, 14)) + "...";
                    }
                    rVar.aLp.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = rVar2.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        as.b(rVar.aLp, n.d.cp_cont_h, 1);
                    } else {
                        as.b(rVar.aLp, n.d.cp_cont_f, 1);
                    }
                    int level_id = rVar2.getAuthor().getLevel_id();
                    int is_bawu = rVar2.getAuthor().getIs_bawu();
                    String bawu_type = rVar2.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        rVar.cEo.setVisibility(0);
                        as.c(rVar.cEo, com.baidu.tbadk.core.util.c.ci(level_id));
                        rVar.cEo.setOnClickListener(null);
                    } else {
                        rVar.cEo.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            as.c(rVar.cEp, n.f.pb_manager);
                            rVar.cEo.setVisibility(8);
                            rVar.cEp.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            as.c(rVar.cEp, n.f.pb_assist);
                            rVar.cEo.setVisibility(8);
                            rVar.cEp.setVisibility(0);
                        }
                    }
                    if (rVar2.getAuthor().getGender() == 2) {
                        as.c(rVar.cEq, n.f.icon_pb_pop_girl);
                        rVar.cEq.setVisibility(0);
                    } else if (rVar2.getAuthor().getGender() == 1) {
                        as.c(rVar.cEq, n.f.icon_pb_pop_boy);
                        rVar.cEq.setVisibility(0);
                    } else {
                        rVar.cEq.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.o.gi(rVar2.getAuthor().getName_show()) >= 14 && rVar.cEo.getVisibility() == 0 && rVar.cEs.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cDZ = rVar2.getAuthor().getIconInfo();
                    this.bcl = rVar2.getAuthor().getTShowInfoNew();
                    if (rVar.bnP != null) {
                        rVar.bnP.setTag(n.g.tag_user_id, rVar2.getAuthor().getUserId());
                        rVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
                        rVar.bnP.a(this.cDZ, i2, getDimensionPixelSize(n.e.pb_icon_width), getDimensionPixelSize(n.e.pb_icon_height), getDimensionPixelSize(n.e.pb_icon_margin));
                    }
                    if (rVar.agT != null) {
                        rVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
                        rVar.agT.a(this.bcl, 3, getDimensionPixelSize(n.e.ds36), getDimensionPixelSize(n.e.small_icon_height), getDimensionPixelSize(n.e.small_icon_margin), true);
                    }
                }
                rVar.cEn.setUserId(rVar2.getAuthor().getUserId());
                rVar.cEn.setUserName(rVar2.getAuthor().getUserName());
                rVar.cEn.setImageDrawable(null);
                rVar.aLp.setTag(n.g.tag_user_id, rVar2.getAuthor().getUserId());
                rVar.aLp.setTag(n.g.tag_user_name, rVar2.getAuthor().getUserName());
                rVar.cEn.d(portrait, 28, false);
            }
            rVar.cDC.setLinkTextColor(as.getColor(n.d.cp_link_tip_c));
            if (this.cDr) {
                rVar.cDC.setDefaultImageId(n.f.img_default_100);
            } else {
                rVar.cDC.setDefaultImageId(n.f.icon_click);
            }
            rVar.cDC.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar2.aFr();
            }
            if (this.cDw || !this.cDx) {
                rVar.cDC.a(aVar, false);
            } else {
                rVar.cDC.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cDR.akL() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = rVar2.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.cDR != null && this.cDR.akH() != null && this.cDR.akH().getAuthor() != null && rVar2.getAuthor() != null) {
                String userId4 = this.cDR.akH().getAuthor().getUserId();
                String userId5 = rVar2.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = rVar2.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (rVar.cEC != null) {
                            rVar.cEC.setVisibility(0);
                            rVar.cEC.setText(n.j.manage);
                            rVar.cEC.setCompoundDrawablesWithIntrinsicBounds(getDrawable(n.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (rVar.cEC != null) {
                            rVar.cEC.setVisibility(0);
                            rVar.cEC.setText(n.j.delete);
                            rVar.cEC.setCompoundDrawablesWithIntrinsicBounds(getDrawable(n.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (rVar.cEC != null) {
                        rVar.cEC.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (rVar2.aFq() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(n.g.tag_forbid_user_post_id, rVar2.getId());
                    if (!z8) {
                        sparseArray.put(n.g.tag_should_manage_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cDR.akL()));
                        sparseArray.put(n.g.tag_forbid_user_name, rVar2.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(n.g.tag_user_mute_visible, true);
                        sparseArray.put(n.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar2.getAuthor() != null) {
                            sparseArray.put(n.g.tag_user_mute_mute_userid, rVar2.getAuthor().getUserId());
                            sparseArray.put(n.g.tag_user_mute_mute_username, rVar2.getAuthor().getUserName());
                        }
                        if (this.cDR.akH() != null) {
                            sparseArray.put(n.g.tag_user_mute_thread_id, this.cDR.akH().getId());
                        }
                        sparseArray.put(n.g.tag_user_mute_post_id, rVar2.getId());
                    } else {
                        sparseArray.put(n.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(n.g.tag_should_delete_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cDR.akL()));
                        sparseArray.put(n.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(n.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(n.g.tag_del_post_id, rVar2.getId());
                    } else {
                        sparseArray.put(n.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        rVar.cEt.setVisibility(8);
                        as.b(rVar.cEA, n.d.subpb_listitem_time, 1);
                        rVar.cEA.setText(String.format(this.mContext.getResources().getString(n.j.write_addition_update), ax.s(rVar2.getTime())));
                        if (rVar.cEC.getVisibility() == 0) {
                            as.b(rVar.cEC, n.d.cp_link_tip_c, 3);
                            sparseArray.put(n.g.tag_user_mute_visible, false);
                            rVar.cEC.setTag(sparseArray);
                            rVar.cEC.setOnClickListener(this.cEa);
                        }
                    }
                    a(rVar, rVar2, rVar2.aFq() != 1, aVar);
                    b(rVar);
                    if (z) {
                        a(view, rVar2);
                        if (this.cEb != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.cEb.aJm();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            z2 = false;
            z3 = z9;
            z4 = false;
            userId = rVar2.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (rVar2.aFq() == 1) {
            }
            sparseArray.put(n.g.tag_forbid_user_post_id, rVar2.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(rVar, rVar2, rVar2.aFq() != 1, aVar);
            b(rVar);
            if (z) {
            }
        }
    }

    private void b(r rVar) {
        rVar.cDC.setTextViewOnTouchListener(this.cDu);
        rVar.cDC.setTextViewCheckSelection(false);
    }

    private void a(r rVar, com.baidu.tieba.tbadkCore.data.r rVar2, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar2 == null || rVar2.aoe() == null || b(rVar2)) {
            rVar.cEN.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar2.aoe(), rVar.cEN, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar2.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cDz - (i - this.cDy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(r rVar, com.baidu.tieba.tbadkCore.data.r rVar2, AdditionData additionData, int i) {
        if (rVar2.aFv() > 0 && rVar2.aFp() != null) {
            rVar.cEz.setVisibility(0);
            rVar.cEz.removeViews(0, rVar.cEz.getChildCount() - 1);
            int size = rVar2.aFp().size();
            int aFw = rVar2.aFw();
            for (int i2 = 0; i2 < aFw; i2++) {
                com.baidu.tieba.tbadkCore.data.r rVar3 = rVar2.aFp().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(n.h.new_pb_list_item, (ViewGroup) rVar.cEz, false);
                r rVar4 = new r(inflate, this.cDQ, this.cDr, this.cDq, true);
                c(rVar4);
                a(rVar4, rVar3, (View) rVar.cEz, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(n.g.tag_clip_board, rVar3);
                sparseArray.put(n.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(rVar3.getBimg_url()) || !this.cDr) {
                    sparseArray.put(n.g.tag_richtext_bg, null);
                    rVar4.cDC.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar4.cDC.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    rVar4.cDC.setLayoutParams(layoutParams);
                    rVar4.cDC.setPadding(0, 0, 0, 0);
                    rVar.cDC.gl(null);
                } else {
                    rVar.cDC.gl(rVar2.getBimg_url());
                    rVar4.cDC.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar4.cDC.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(n.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(n.e.ds36);
                    rVar4.cDC.setLayoutParams(layoutParams2);
                }
                rVar.cEz.addView(inflate, rVar.cEz.getChildCount() - 1);
            }
            if (aFw < size) {
                rVar.cED.setVisibility(0);
                as.i(rVar.cEF, n.d.cp_bg_line_b);
                as.i(rVar.cEG, n.d.cp_bg_line_b);
                as.b(rVar.cEE, n.d.cp_cont_f, 1);
                rVar.cED.setOnClickListener(new q(this, aFw, size, rVar2));
                return;
            }
            rVar.cED.setVisibility(8);
            return;
        }
        rVar.cEz.setVisibility(8);
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.r rVar) {
        return (this.cDR == null || this.cDR.akH() == null || !this.cDR.akH().sM() || this.cDR.akH().sr() == null || rVar.aFq() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (b(rVar) && view != null && this.cGj != null) {
            if (this.cEb == null) {
                this.cEb = new com.baidu.tieba.vote.b(this.cGj);
            }
            this.cEb.a(view, this.cDR);
        } else if (this.cEb != null) {
            this.cEb.setVisibility(8);
        }
    }

    private void c(r rVar) {
        rVar.aLp.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        rVar.cEt.setOnClickListener(this.bjD);
        rVar.cEn.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        rVar.cEu.setOnLongClickListener(this.amQ);
        rVar.cDC.setOnLongClickListener(this.amQ);
        rVar.cEu.setOnTouchListener(this.cDu);
        rVar.cDC.setOnTouchListener(this.cDu);
        rVar.cDC.setOnImageClickListener(this.aFq);
        rVar.cDC.setOnEmotionClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKo);
        rVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
        rVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
        rVar.cEN.setOnClickListener(this.bjD);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cDR = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cDq = i;
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void eU(boolean z) {
        this.cDQ = z;
    }

    public void eT(boolean z) {
        this.cDs = z;
    }

    public void ku(String str) {
        this.cDX = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cEa = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bjD = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFq = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cDu = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }
}
