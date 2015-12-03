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
import com.baidu.tieba.pb.pb.main.cb;
import com.baidu.tieba.pb.pb.sub.al;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends cb<com.baidu.tieba.tbadkCore.data.o, r> implements View.OnClickListener {
    private TbRichTextView.d aDR;
    private ArrayList<IconData> aYm;
    private View.OnLongClickListener alK;
    private View.OnClickListener bfL;
    private boolean cAl;
    private com.baidu.tieba.pb.a.c cAm;
    private String cAs;
    private al cAt;
    private ArrayList<IconData> cAu;
    private View.OnClickListener cAv;
    private com.baidu.tieba.vote.b cAw;
    private int czL;
    private boolean czM;
    private boolean czN;
    private com.baidu.tieba.pb.b.c czP;
    private boolean czR;
    private final boolean czS;
    private int czT;
    private int czU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.czL = 0;
        this.czM = true;
        this.cAl = true;
        this.czN = true;
        this.cAm = null;
        this.cAs = null;
        this.cAt = null;
        this.cAu = null;
        this.aYm = null;
        this.cAv = null;
        this.bfL = null;
        this.aDR = null;
        this.czP = null;
        this.alK = null;
        this.czR = false;
        this.czS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.czT = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds30);
        this.czU = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public r a(ViewGroup viewGroup) {
        return new r(LayoutInflater.from(this.mContext).inflate(n.g.new_pb_list_item, viewGroup, false), this.cAl, this.czM, this.czL, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cb, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, r rVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) rVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(rVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aB(i);
        as.j(rVar.cAE, n.c.cp_bg_line_b);
        as.j(rVar.cAF, n.c.cp_bg_line_b);
        as.b(rVar.cAV, n.c.subpb_listitem_time, 1);
        as.b(rVar.cAX, n.c.cp_link_tip_c, 3);
        as.b(rVar.aJR, n.c.cp_cont_f, 1);
        as.b((View) rVar.cAJ, n.c.cp_cont_i, 1);
        as.b((View) rVar.cAK, n.c.cp_cont_i, 1);
        as.b(rVar.cAM, n.c.cp_cont_d, 1);
        as.b(rVar.bEX, n.c.cp_cont_d, 1);
        as.c(rVar.cAO, n.e.btn_pb_reply_selector);
        as.j(rVar.czZ, n.c.cp_bg_line_b);
        as.j(rVar.cAa, n.c.cp_bg_line_e);
        as.j(rVar.cAb, n.c.cp_bg_line_e);
        as.c(rVar.cAb, n.c.cp_bg_line_b);
        as.c(rVar.cAR, n.c.cp_bg_line_b);
        if (oVar2 != null) {
            a(rVar, oVar2, view, false, i);
        }
        if (!this.czR && this.czS && rVar != null && rVar.czX.Gn() && (listView = ((PbActivity) this.cCy.getPageContext().getOrignalPage()).getListView()) != null) {
            this.czR = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a90  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0ac0  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0acc  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0ad8  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0ae4  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(r rVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (rVar != null && oVar != null) {
            if (!z) {
                rVar.cAI.setTag(null);
                rVar.cAI.setUserId(null);
                rVar.aJR.setText((CharSequence) null);
                rVar.cAK.setVisibility(8);
                rVar.cAS.setVisibility(0);
                rVar.cAO.setVisibility(0);
                rVar.cAN.setVisibility(8);
                if (oVar.aDf() == null || b(oVar)) {
                    rVar.cAT.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && oVar.aDf().AR() == 1) {
                    rVar.cAT.changeSkinType(this.mSkinType);
                    rVar.cAT.setVisibility(0);
                    rVar.cAT.setData(oVar.aDf());
                } else {
                    rVar.cAT.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) rVar.cAP.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    rVar.cAP.setTag(sparseArray2);
                    rVar.czX.setTag(sparseArray2);
                }
                sparseArray2.put(n.f.tag_clip_board, oVar);
                sparseArray2.put(n.f.tag_is_subpb, false);
                a(rVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
                if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.czM || b(oVar)) {
                    sparseArray2.put(n.f.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.czX.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    rVar.czX.setLayoutParams(layoutParams);
                    rVar.czX.setPadding(0, 0, 0, 0);
                    rVar.czX.gh(null);
                } else {
                    sparseArray2.put(n.f.tag_richtext_bg, oVar.getBimg_url());
                    rVar.czX.gh(oVar.getBimg_url());
                    if (oVar.aDd() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.czX.getLayoutParams();
                        layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(n.d.ds16);
                        layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(n.d.ds40);
                        rVar.czX.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.czX.getLayoutParams();
                        layoutParams3.topMargin = (int) this.mContext.getResources().getDimension(n.d.ds20);
                        layoutParams3.bottomMargin = (int) this.mContext.getResources().getDimension(n.d.ds20);
                        rVar.czX.setLayoutParams(layoutParams3);
                    }
                }
                rVar.bEX.setText(ax.s(oVar.getTime()));
                rVar.cAc.setVisibility(8);
                if (oVar.aDd() == 1) {
                    as.j(rVar.cAD, n.c.cp_bg_line_d);
                    rVar.cAE.setVisibility(8);
                    rVar.cAF.setVisibility(8);
                    rVar.cAG.setVisibility(8);
                    rVar.cAP.setVisibility(8);
                    rVar.bEX.setVisibility(8);
                    rVar.cAc.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (oVar.getAuthor() != null) {
                        j = oVar.getAuthor().getUserIdLong();
                        str = oVar.getAuthor().getUserName();
                    }
                    rVar.cAc.a(oVar.aDm(), str, j, com.baidu.adp.lib.h.b.c(this.cAm.ajz().getId(), 0L), com.baidu.adp.lib.h.b.c(oVar.getId(), 0L));
                    rVar.cAc.tH();
                    if (this.czN) {
                        PraiseData praise = this.cAm.ajz().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            rVar.cAa.setVisibility(0);
                            rVar.czZ.setVisibility(0);
                            rVar.cAb.setVisibility(0);
                            rVar.cAa.setIsFromPb(true);
                            rVar.cAa.a(praise, this.cAm.ajz().getId(), praise.getPostId(), true);
                            rVar.cAa.cX(this.mSkinType);
                        } else {
                            rVar.cAa.setVisibility(8);
                            rVar.czZ.setVisibility(8);
                            rVar.cAb.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aDg = oVar.aDg();
                        rVar.cBf.setVisibility(8);
                        if (aDg != null && !TextUtils.isEmpty(aDg.getName()) && !TextUtils.isEmpty(aDg.getName().trim())) {
                            String name = aDg.getName();
                            String lat = aDg.getLat();
                            String lng = aDg.getLng();
                            rVar.cBc.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, rVar.cBc, 0, 10, 0, 10);
                            rVar.cBe.setText(aDg.getName());
                            as.b(rVar.cBe, n.c.cp_cont_c, 1);
                            as.c(rVar.cBd, n.e.icon_frs_site);
                            rVar.cBc.setOnClickListener(new o(this, lat, lng, name));
                        } else {
                            rVar.cBc.setVisibility(8);
                        }
                    } else {
                        rVar.cAa.setVisibility(8);
                        rVar.czZ.setVisibility(8);
                        rVar.cAb.setVisibility(8);
                        rVar.cBc.setVisibility(8);
                        rVar.cBf.setVisibility(8);
                    }
                    a(rVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
                    ((LinearLayout.LayoutParams) rVar.cAT.getLayoutParams()).leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds30);
                } else {
                    as.j(rVar.cAD, n.c.cp_bg_line_e);
                    if (i == 1) {
                        if (this.czN) {
                            rVar.cAE.setVisibility(8);
                            rVar.cAF.setVisibility(8);
                            PraiseData praise2 = this.cAm.ajz().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                rVar.cAF.setVisibility(8);
                                rVar.cAE.setVisibility(0);
                            } else {
                                rVar.cAF.setVisibility(0);
                                rVar.cAE.setVisibility(8);
                            }
                        } else {
                            rVar.cAE.setVisibility(0);
                            rVar.cAF.setVisibility(8);
                        }
                    } else {
                        rVar.cAE.setVisibility(0);
                        rVar.cAF.setVisibility(8);
                    }
                    rVar.cAG.setVisibility(0);
                    com.baidu.tbadk.data.d aDg2 = oVar.aDg();
                    rVar.cBc.setVisibility(8);
                    if (aDg2 != null && !TextUtils.isEmpty(aDg2.getName()) && !TextUtils.isEmpty(aDg2.getName().trim())) {
                        String name2 = aDg2.getName();
                        String lat2 = aDg2.getLat();
                        String lng2 = aDg2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) rVar.cBf.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.cAl) {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(n.d.ds74);
                            } else {
                                layoutParams4.leftMargin = this.mContext.getResources().getDimensionPixelSize(n.d.ds104);
                            }
                            rVar.cBf.setLayoutParams(layoutParams4);
                        }
                        rVar.cBf.setVisibility(0);
                        rVar.cBh.setText(aDg2.getName());
                        as.b(rVar.cBh, n.c.cp_cont_c, 1);
                        as.c(rVar.cBg, n.e.icon_frs_site);
                        rVar.cBf.setOnClickListener(new p(this, lat2, lng2, name2));
                    } else {
                        rVar.cBf.setVisibility(8);
                    }
                    rVar.cAa.setVisibility(8);
                    rVar.czZ.setVisibility(8);
                    rVar.cAb.setVisibility(8);
                    rVar.cAP.setVisibility(0);
                    rVar.bEX.setVisibility(0);
                    String format = String.format(this.mContext.getString(n.i.is_floor), Integer.valueOf(oVar.aDd()));
                    rVar.cAM.setVisibility(0);
                    rVar.cAM.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) rVar.cAT.getLayoutParams();
                    if (!this.cAl) {
                        a(rVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds74));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds74);
                    } else {
                        a(rVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds104));
                        layoutParams5.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) rVar.cAQ.getLayoutParams();
                    if (!this.cAl) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = (int) this.mContext.getResources().getDimension(n.d.ds30);
                    }
                }
                if (this.cAs != null && !this.cAs.equals("0") && this.cAs.equals(oVar.getAuthor().getUserId())) {
                    rVar.cAN.setVisibility(0);
                    as.c(rVar.cAN, n.e.icon_floorhost);
                }
            }
            as.i(rVar.cAH, n.e.bg_floor_new_middle);
            rVar.czX.setVideoImageId(n.e.pic_video);
            rVar.czX.setTextColor(as.getColor(n.c.pb_listitem_content));
            as.c(rVar.cAO, n.e.btn_pb_reply_selector);
            rVar.czX.setLinkTextColor(as.getColor(n.c.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) rVar.cAO.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                rVar.cAO.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(n.f.tag_clip_board, oVar);
            sparseArray.put(n.f.tag_load_sub_data, oVar);
            sparseArray.put(n.f.tag_load_sub_view, view);
            if (oVar.aDh() > 0) {
                if (this.cAt == null) {
                    this.cAt = new al(this.mContext);
                    this.cAt.setIsFromCDN(this.mIsFromCDN);
                    this.cAt.D(this.cAv);
                    boolean z7 = false;
                    String userId2 = this.cAm.ajz().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cAt.q(this.cAm.ajD(), z7);
                    this.cAt.e(this.cAm.ajz());
                    this.cAt.eV(this.cAl);
                }
                rVar.cAS.setVisibility(0);
                rVar.cAR.setVisibility(0);
                rVar.cAQ.setVisibility(0);
                rVar.cAS.a(oVar, view);
                rVar.cAS.setChildOnClickListener(this.bfL);
                rVar.cAS.setChildOnLongClickListener(this.alK);
                rVar.cAS.setChildOnTouchListener(this.czP);
                rVar.cAS.setSubPbAdapter(this.cAt);
                rVar.cAS.setVisibility(0);
            } else {
                rVar.cAS.setVisibility(8);
                rVar.cAR.setVisibility(8);
                rVar.cAQ.setVisibility(8);
            }
            a(rVar, oVar, this.cAm.ajG(), i);
            if (!z) {
                String portrait = oVar.getAuthor().getPortrait();
                if (oVar.getAuthor() != null) {
                    String name_show = oVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.o.ge(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.o.e(name_show, 0, 14)) + "...";
                    }
                    rVar.aJR.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = oVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        as.b(rVar.aJR, n.c.cp_cont_h, 1);
                    } else {
                        as.b(rVar.aJR, n.c.cp_cont_f, 1);
                    }
                    int level_id = oVar.getAuthor().getLevel_id();
                    int is_bawu = oVar.getAuthor().getIs_bawu();
                    String bawu_type = oVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        rVar.cAJ.setVisibility(0);
                        as.c(rVar.cAJ, com.baidu.tbadk.core.util.c.cp(level_id));
                        rVar.cAJ.setOnClickListener(null);
                    } else {
                        rVar.cAJ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            as.c(rVar.cAK, n.e.pb_manager);
                            rVar.cAJ.setVisibility(8);
                            rVar.cAK.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            as.c(rVar.cAK, n.e.pb_assist);
                            rVar.cAJ.setVisibility(8);
                            rVar.cAK.setVisibility(0);
                        }
                    }
                    if (oVar.getAuthor().getGender() == 2) {
                        as.c(rVar.cAL, n.e.icon_pb_pop_girl);
                        rVar.cAL.setVisibility(0);
                    } else if (oVar.getAuthor().getGender() == 1) {
                        as.c(rVar.cAL, n.e.icon_pb_pop_boy);
                        rVar.cAL.setVisibility(0);
                    } else {
                        rVar.cAL.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.o.ge(oVar.getAuthor().getName_show()) >= 14 && rVar.cAJ.getVisibility() == 0 && rVar.cAN.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cAu = oVar.getAuthor().getIconInfo();
                    this.aYm = oVar.getAuthor().getTShowInfoNew();
                    if (rVar.bjY != null) {
                        rVar.bjY.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
                        rVar.bjY.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.bdv);
                        rVar.bjY.a(this.cAu, i2, this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.pb_icon_margin));
                    }
                    if (rVar.aYE != null) {
                        rVar.aYE.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGo);
                        rVar.aYE.a(this.aYm, 3, this.mContext.getResources().getDimensionPixelSize(n.d.ds36), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
                    }
                }
                rVar.cAI.setUserId(oVar.getAuthor().getUserId());
                rVar.cAI.setUserName(oVar.getAuthor().getUserName());
                rVar.cAI.setImageDrawable(null);
                rVar.aJR.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
                rVar.aJR.setTag(n.f.tag_user_name, oVar.getAuthor().getUserName());
                rVar.cAI.d(portrait, 28, false);
            }
            rVar.czX.setLinkTextColor(as.getColor(n.c.cp_link_tip_c));
            if (this.czM) {
                rVar.czX.setDefaultImageId(n.e.img_default_100);
            } else {
                rVar.czX.setDefaultImageId(n.e.icon_click);
            }
            rVar.czX.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = oVar.aDe();
            }
            if (this.czR || !this.czS) {
                rVar.czX.a(aVar, false);
            } else {
                rVar.czX.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cAm.ajD() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = oVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.cAm != null && this.cAm.ajz() != null && this.cAm.ajz().getAuthor() != null && oVar.getAuthor() != null) {
                String userId4 = this.cAm.ajz().getAuthor().getUserId();
                String userId5 = oVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = oVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (rVar.cAX != null) {
                            rVar.cAX.setVisibility(0);
                            rVar.cAX.setText(n.i.manage);
                            rVar.cAX.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (rVar.cAX != null) {
                            rVar.cAX.setVisibility(0);
                            rVar.cAX.setText(n.i.delete);
                            rVar.cAX.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (rVar.cAX != null) {
                        rVar.cAX.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (oVar.aDd() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
                    if (!z8) {
                        sparseArray.put(n.f.tag_should_manage_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cAm.ajD()));
                        sparseArray.put(n.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.f.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(n.f.tag_user_mute_visible, true);
                        sparseArray.put(n.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (oVar.getAuthor() != null) {
                            sparseArray.put(n.f.tag_user_mute_mute_userid, oVar.getAuthor().getUserId());
                            sparseArray.put(n.f.tag_user_mute_mute_username, oVar.getAuthor().getUserName());
                        }
                        if (this.cAm.ajz() != null) {
                            sparseArray.put(n.f.tag_user_mute_thread_id, this.cAm.ajz().getId());
                        }
                        sparseArray.put(n.f.tag_user_mute_post_id, oVar.getId());
                    } else {
                        sparseArray.put(n.f.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(n.f.tag_should_delete_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cAm.ajD()));
                        sparseArray.put(n.f.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(n.f.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(n.f.tag_del_post_id, oVar.getId());
                    } else {
                        sparseArray.put(n.f.tag_should_delete_visible, false);
                    }
                    if (z) {
                        rVar.cAO.setVisibility(8);
                        as.b(rVar.cAV, n.c.subpb_listitem_time, 1);
                        rVar.cAV.setText(String.format(this.mContext.getResources().getString(n.i.write_addition_update), ax.s(oVar.getTime())));
                        if (rVar.cAX.getVisibility() == 0) {
                            as.b(rVar.cAX, n.c.cp_link_tip_c, 3);
                            sparseArray.put(n.f.tag_user_mute_visible, false);
                            rVar.cAX.setTag(sparseArray);
                            rVar.cAX.setOnClickListener(this.cAv);
                        }
                    }
                    a(rVar, oVar, oVar.aDd() != 1, aVar);
                    a(rVar);
                    if (z) {
                        a(view, oVar);
                        if (this.cAw != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.cAw.aGS();
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
            userId = oVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (oVar.aDd() == 1) {
            }
            sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(rVar, oVar, oVar.aDd() != 1, aVar);
            a(rVar);
            if (z) {
            }
        }
    }

    private void a(r rVar) {
        rVar.czX.setTextViewOnTouchListener(this.czP);
        rVar.czX.setTextViewCheckSelection(false);
    }

    private void a(r rVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (oVar == null || oVar.amT() == null || b(oVar)) {
            rVar.cBi.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.e.a(oVar.amT(), rVar.cBi, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(oVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.czU - (i - this.czT));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(r rVar, com.baidu.tieba.tbadkCore.data.o oVar, AdditionData additionData, int i) {
        if (oVar.aDi() > 0 && oVar.aDc() != null) {
            rVar.cAU.setVisibility(0);
            rVar.cAU.removeViews(0, rVar.cAU.getChildCount() - 1);
            int size = oVar.aDc().size();
            int aDj = oVar.aDj();
            for (int i2 = 0; i2 < aDj; i2++) {
                com.baidu.tieba.tbadkCore.data.o oVar2 = oVar.aDc().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(n.g.new_pb_list_item, (ViewGroup) rVar.cAU, false);
                r rVar2 = new r(inflate, this.cAl, this.czM, this.czL, true);
                b(rVar2);
                a(rVar2, oVar2, (View) rVar.cAU, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(n.f.tag_clip_board, oVar2);
                sparseArray.put(n.f.tag_is_subpb, true);
                if (TextUtils.isEmpty(oVar2.getBimg_url()) || !this.czM) {
                    sparseArray.put(n.f.tag_richtext_bg, null);
                    rVar2.czX.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar2.czX.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    rVar2.czX.setLayoutParams(layoutParams);
                    rVar2.czX.setPadding(0, 0, 0, 0);
                    rVar.czX.gh(null);
                } else {
                    rVar.czX.gh(oVar.getBimg_url());
                    rVar2.czX.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar2.czX.getLayoutParams();
                    layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(n.d.ds16);
                    layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(n.d.ds36);
                    rVar2.czX.setLayoutParams(layoutParams2);
                }
                rVar.cAU.addView(inflate, rVar.cAU.getChildCount() - 1);
            }
            if (aDj < size) {
                rVar.cAY.setVisibility(0);
                as.i(rVar.cBa, n.c.cp_bg_line_b);
                as.i(rVar.cBb, n.c.cp_bg_line_b);
                as.b(rVar.cAZ, n.c.cp_cont_f, 1);
                rVar.cAY.setOnClickListener(new q(this, aDj, size, oVar));
                return;
            }
            rVar.cAY.setVisibility(8);
            return;
        }
        rVar.cAU.setVisibility(8);
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.o oVar) {
        return (this.cAm == null || this.cAm.ajz() == null || !this.cAm.ajz().tc() || this.cAm.ajz().sH() == null || oVar.aDd() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.o oVar) {
        if (b(oVar) && view != null && this.cCy != null) {
            if (this.cAw == null) {
                this.cAw = new com.baidu.tieba.vote.b(this.cCy);
            }
            this.cAw.a(view, this.cAm);
        } else if (this.cAw != null) {
            this.cAw.setVisibility(8);
        }
    }

    private void b(r rVar) {
        rVar.aJR.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGn);
        rVar.cAO.setOnClickListener(this.bfL);
        rVar.cAI.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGn);
        rVar.cAP.setOnLongClickListener(this.alK);
        rVar.czX.setOnLongClickListener(this.alK);
        rVar.cAP.setOnTouchListener(this.czP);
        rVar.czX.setOnTouchListener(this.czP);
        rVar.czX.setOnImageClickListener(this.aDR);
        rVar.czX.setOnEmotionClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGp);
        rVar.bjY.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.bdv);
        rVar.aYE.setOnClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGo);
        rVar.cBi.setOnClickListener(this.bfL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cAm = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.czL = i;
    }

    public void eT(boolean z) {
        this.czM = z;
    }

    public void eV(boolean z) {
        this.cAl = z;
    }

    public void eU(boolean z) {
        this.czN = z;
    }

    public void ky(String str) {
        this.cAs = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cAv = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bfL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aDR = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.czP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alK = onLongClickListener;
    }
}
