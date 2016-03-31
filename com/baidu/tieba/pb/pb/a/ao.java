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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.db;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ao extends db<com.baidu.tieba.tbadkCore.data.s, as> implements View.OnClickListener {
    private TbRichTextView.d aJc;
    private View.OnLongClickListener aoa;
    private ArrayList<IconData> bjm;
    private View.OnClickListener brL;
    private int ddn;
    private boolean ddo;
    private boolean ddp;
    private com.baidu.tieba.pb.data.e ddq;
    private boolean ddr;
    private com.baidu.tieba.pb.a.c dds;
    private int ddt;
    private int ddv;
    private boolean ddw;
    private final boolean ddx;
    private String deG;
    private com.baidu.tieba.pb.pb.sub.an deH;
    private ArrayList<IconData> deI;
    private View.OnClickListener deJ;
    private com.baidu.tieba.vote.b deK;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ddn = 0;
        this.ddo = true;
        this.ddp = true;
        this.ddr = true;
        this.ddq = null;
        this.deG = null;
        this.deH = null;
        this.deI = null;
        this.bjm = null;
        this.deJ = null;
        this.brL = null;
        this.aJc = null;
        this.dds = null;
        this.aoa = null;
        this.ddw = false;
        this.ddx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(as asVar) {
        if (asVar != null) {
            if (asVar.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                at.l(asVar.deP, t.d.cp_bg_line_b);
                at.l(asVar.deQ, t.d.cp_bg_line_b);
                at.b(asVar.dfh, t.d.subpb_listitem_time, 1);
                at.b(asVar.dfj, t.d.cp_link_tip_c, 3);
                at.b(asVar.aPp, t.d.cp_cont_f, 1);
                at.b((View) asVar.deU, t.d.cp_cont_i, 1);
                at.b((View) asVar.deV, t.d.cp_cont_i, 1);
                at.b(asVar.deX, t.d.cp_cont_d, 1);
                at.b(asVar.deY, t.d.cp_cont_d, 1);
                at.c(asVar.dfa, t.f.btn_pb_reply_selector);
                at.l(asVar.ddB, t.d.cp_bg_line_b);
                at.l(asVar.ddD, t.d.cp_bg_line_e);
                at.l(asVar.ddE, t.d.cp_bg_line_e);
                at.c(asVar.ddE, t.d.cp_bg_line_b);
                at.c(asVar.dfd, t.d.cp_bg_line_b);
            }
            asVar.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    private void init() {
        this.ddt = getDimensionPixelSize(t.e.ds30);
        this.ddv = com.baidu.adp.lib.util.k.B(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public as b(ViewGroup viewGroup) {
        as asVar = new as(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.ddp, this.ddo, this.ddn, false);
        a(asVar);
        return asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, as asVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) asVar);
        a(asVar);
        c(asVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) aF(i);
        if (sVar2 != null) {
            a(asVar, sVar2, view, false, i);
        }
        if (!this.ddw && this.ddx && asVar != null && asVar.ddA.IX() && (listView = ((PbActivity) this.dfw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ddw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a41  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a71  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0a7d  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0a89  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0a95  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(as asVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (asVar != null && sVar != null) {
            if (!z) {
                asVar.deT.setTag(null);
                asVar.deT.setUserId(null);
                asVar.aPp.setText((CharSequence) null);
                asVar.deV.setVisibility(8);
                asVar.dfe.setVisibility(0);
                asVar.dfa.setVisibility(0);
                asVar.deZ.setVisibility(8);
                if (sVar.aTu() == null || c(sVar)) {
                    asVar.dff.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && sVar.aTu().CA() == 1) {
                    asVar.dff.changeSkinType(this.mSkinType);
                    asVar.dff.setVisibility(0);
                    asVar.dff.setData(sVar.aTu());
                } else {
                    asVar.dff.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) asVar.dfb.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    asVar.dfb.setTag(sparseArray2);
                    asVar.ddA.setTag(sparseArray2);
                }
                sparseArray2.put(t.g.tag_clip_board, sVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                a(asVar.ddA, getDimensionPixelSize(t.e.ds30));
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ddo || c(sVar)) {
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) asVar.ddA.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    asVar.ddA.setLayoutParams(layoutParams);
                    asVar.ddA.setPadding(0, 0, 0, 0);
                    asVar.ddA.gu(null);
                } else {
                    sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                    asVar.ddA.gu(sVar.getBimg_url());
                    if (sVar.aTs() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) asVar.ddA.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds40);
                        asVar.ddA.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) asVar.ddA.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(t.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(t.e.ds20);
                        asVar.ddA.setLayoutParams(layoutParams3);
                    }
                }
                asVar.deY.setText(ay.w(sVar.getTime()));
                asVar.ddC.setVisibility(8);
                if (sVar.aTs() == 1) {
                    at.l(asVar.deO, t.d.cp_bg_line_d);
                    asVar.deP.setVisibility(8);
                    asVar.deQ.setVisibility(8);
                    asVar.deR.setVisibility(8);
                    asVar.dfb.setVisibility(8);
                    asVar.deY.setVisibility(8);
                    asVar.ddC.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    asVar.ddC.a(sVar.aTB(), str, j, com.baidu.adp.lib.h.b.c(this.ddq.avv().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    asVar.ddC.uA();
                    if (this.ddr) {
                        PraiseData praise = this.ddq.avv().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            asVar.ddD.setVisibility(0);
                            asVar.ddB.setVisibility(0);
                            asVar.ddE.setVisibility(0);
                            asVar.ddD.setIsFromPb(true);
                            asVar.ddD.a(praise, this.ddq.avv().getId(), praise.getPostId(), true);
                            asVar.ddD.dn(this.mSkinType);
                        } else {
                            asVar.ddD.setVisibility(8);
                            asVar.ddB.setVisibility(8);
                            asVar.ddE.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.af(asVar.ddD);
                        com.baidu.tieba.graffiti.d.af(asVar.ddB);
                        com.baidu.tieba.graffiti.d.af(asVar.ddE);
                        com.baidu.tbadk.data.e aTv = sVar.aTv();
                        asVar.dfr.setVisibility(8);
                        if (aTv != null && !TextUtils.isEmpty(aTv.getName()) && !TextUtils.isEmpty(aTv.getName().trim())) {
                            String name = aTv.getName();
                            String lat = aTv.getLat();
                            String lng = aTv.getLng();
                            asVar.dfo.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, asVar.dfo, 0, 10, 0, 10);
                            asVar.dfq.setText(aTv.getName());
                            at.b(asVar.dfq, t.d.cp_cont_c, 1);
                            at.c(asVar.dfp, t.f.icon_frs_site);
                            asVar.dfo.setOnClickListener(new ap(this, lat, lng, name));
                        } else {
                            asVar.dfo.setVisibility(8);
                        }
                    } else {
                        asVar.ddD.setVisibility(8);
                        asVar.ddB.setVisibility(8);
                        asVar.ddE.setVisibility(8);
                        asVar.dfo.setVisibility(8);
                        asVar.dfr.setVisibility(8);
                    }
                    a(asVar.ddA, getDimensionPixelSize(t.e.ds30));
                    ((LinearLayout.LayoutParams) asVar.dff.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                } else {
                    at.l(asVar.deO, t.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.ddr) {
                            asVar.deP.setVisibility(8);
                            asVar.deQ.setVisibility(8);
                            PraiseData praise2 = this.ddq.avv().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                asVar.deQ.setVisibility(8);
                                asVar.deP.setVisibility(0);
                            } else {
                                asVar.deQ.setVisibility(0);
                                asVar.deP.setVisibility(8);
                            }
                        } else {
                            asVar.deP.setVisibility(0);
                            asVar.deQ.setVisibility(8);
                        }
                    } else {
                        asVar.deP.setVisibility(0);
                        asVar.deQ.setVisibility(8);
                    }
                    asVar.deR.setVisibility(0);
                    com.baidu.tbadk.data.e aTv2 = sVar.aTv();
                    asVar.dfo.setVisibility(8);
                    if (aTv2 != null && !TextUtils.isEmpty(aTv2.getName()) && !TextUtils.isEmpty(aTv2.getName().trim())) {
                        String name2 = aTv2.getName();
                        String lat2 = aTv2.getLat();
                        String lng2 = aTv2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) asVar.dfr.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.ddp) {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds104);
                            }
                            asVar.dfr.setLayoutParams(layoutParams4);
                        }
                        asVar.dfr.setVisibility(0);
                        asVar.dft.setText(aTv2.getName());
                        at.b(asVar.dft, t.d.cp_cont_c, 1);
                        at.c(asVar.dfs, t.f.icon_frs_site);
                        asVar.dfr.setOnClickListener(new aq(this, lat2, lng2, name2));
                    } else {
                        asVar.dfr.setVisibility(8);
                    }
                    asVar.ddD.setVisibility(8);
                    asVar.ddB.setVisibility(8);
                    asVar.ddE.setVisibility(8);
                    asVar.dfb.setVisibility(0);
                    asVar.deY.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTs()));
                    asVar.deX.setVisibility(0);
                    asVar.deX.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) asVar.dff.getLayoutParams();
                    if (!this.ddp) {
                        a(asVar.ddA, getDimensionPixelSize(t.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds74);
                    } else {
                        a(asVar.ddA, getDimensionPixelSize(t.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) asVar.dfc.getLayoutParams();
                    if (!this.ddp) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds30);
                    }
                }
                if (this.deG != null && !this.deG.equals("0") && this.deG.equals(sVar.getAuthor().getUserId())) {
                    asVar.deZ.setVisibility(0);
                    at.c(asVar.deZ, t.f.icon_floorhost);
                }
            }
            at.k(asVar.deS, t.f.bg_floor_new_middle);
            asVar.ddA.setVideoImageId(t.f.pic_video);
            asVar.ddA.setTextColor(at.getColor(t.d.pb_listitem_content));
            at.c(asVar.dfa, t.f.btn_pb_reply_selector);
            asVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) asVar.dfa.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                asVar.dfa.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            if (sVar.aTw() > 0) {
                if (this.deH == null) {
                    this.deH = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.deH.setIsFromCDN(this.mIsFromCDN);
                    this.deH.N(this.deJ);
                    boolean z7 = false;
                    String userId2 = this.ddq.avv().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.deH.t(this.ddq.avB(), z7);
                    this.deH.h(this.ddq.avv());
                    this.deH.fR(this.ddp);
                }
                asVar.dfe.setVisibility(0);
                asVar.dfd.setVisibility(0);
                asVar.dfc.setVisibility(0);
                asVar.dfe.a(sVar, view);
                asVar.dfe.setChildOnClickListener(this.brL);
                asVar.dfe.setChildOnLongClickListener(this.aoa);
                asVar.dfe.setChildOnTouchListener(this.dds);
                asVar.dfe.setSubPbAdapter(this.deH);
                asVar.dfe.setVisibility(0);
            } else {
                asVar.dfe.setVisibility(8);
                asVar.dfd.setVisibility(8);
                asVar.dfc.setVisibility(8);
            }
            a(asVar, sVar, this.ddq.avE(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.r.go(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.r.d(name_show, 0, 14)) + "...";
                    }
                    asVar.aPp.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        at.b(asVar.aPp, t.d.cp_cont_h, 1);
                    } else {
                        at.b(asVar.aPp, t.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        asVar.deU.setVisibility(0);
                        at.c(asVar.deU, BitmapHelper.getGradeResourceIdNew(level_id));
                        asVar.deU.setContentDescription(String.format(TbadkCoreApplication.m411getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                        asVar.deU.setOnClickListener(null);
                    } else {
                        asVar.deU.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            at.c(asVar.deV, t.f.pb_manager);
                            asVar.deU.setVisibility(8);
                            asVar.deV.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            at.c(asVar.deV, t.f.pb_assist);
                            asVar.deU.setVisibility(8);
                            asVar.deV.setVisibility(0);
                        }
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        at.c(asVar.deW, t.f.icon_pb_pop_girl);
                        asVar.deW.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        at.c(asVar.deW, t.f.icon_pb_pop_boy);
                        asVar.deW.setVisibility(0);
                    } else {
                        asVar.deW.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.r.go(sVar.getAuthor().getName_show()) >= 14 && asVar.deU.getVisibility() == 0 && asVar.deZ.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.deI = sVar.getAuthor().getIconInfo();
                    this.bjm = sVar.getAuthor().getTShowInfoNew();
                    if (asVar.bvK != null) {
                        asVar.bvK.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                        asVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
                        asVar.bvK.a(this.deI, i2, getDimensionPixelSize(t.e.pb_icon_width), getDimensionPixelSize(t.e.pb_icon_height), getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (asVar.ahN != null) {
                        asVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
                        asVar.ahN.a(this.bjm, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.small_icon_height), getDimensionPixelSize(t.e.small_icon_margin), true);
                    }
                }
                asVar.deT.setUserId(sVar.getAuthor().getUserId());
                asVar.deT.setUserName(sVar.getAuthor().getUserName());
                asVar.deT.setImageDrawable(null);
                asVar.aPp.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                asVar.aPp.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
                asVar.deT.c(portrait, 28, false);
            }
            asVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.ddo) {
                asVar.ddA.setDefaultImageId(t.f.transparent_bg);
            } else {
                asVar.ddA.setDefaultImageId(t.f.icon_click);
            }
            asVar.ddA.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amn();
            }
            if (this.ddw || !this.ddx) {
                asVar.ddA.a(aVar, false);
            } else {
                asVar.ddA.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.ddq.avB() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = sVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.ddq != null && this.ddq.avv() != null && this.ddq.avv().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.ddq.avv().getAuthor().getUserId();
                String userId5 = sVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = sVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (asVar.dfj != null) {
                            asVar.dfj.setVisibility(0);
                            asVar.dfj.setText(t.j.manage);
                            asVar.dfj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (asVar.dfj != null) {
                            asVar.dfj.setVisibility(0);
                            asVar.dfj.setText(t.j.delete);
                            asVar.dfj.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (asVar.dfj != null) {
                        asVar.dfj.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.aTs() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ddq.avB()));
                        sparseArray.put(t.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                        }
                        if (this.ddq.avv() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.ddq.avv().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ddq.avB()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        asVar.dfa.setVisibility(8);
                        at.b(asVar.dfh, t.d.subpb_listitem_time, 1);
                        asVar.dfh.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), ay.w(sVar.getTime())));
                        if (asVar.dfj.getVisibility() == 0) {
                            at.b(asVar.dfj, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            asVar.dfj.setTag(sparseArray);
                            asVar.dfj.setOnClickListener(this.deJ);
                        }
                    }
                    a(asVar, sVar, sVar.aTs() != 1, aVar);
                    b(asVar);
                    if (z) {
                        a(view, sVar);
                        if (this.deK != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.deK.aYE();
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
            userId = sVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (sVar.aTs() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(asVar, sVar, sVar.aTs() != 1, aVar);
            b(asVar);
            if (z) {
            }
        }
    }

    private void b(as asVar) {
        asVar.ddA.setTextViewOnTouchListener(this.dds);
        asVar.ddA.setTextViewCheckSelection(false);
    }

    private void a(as asVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAu() == null || c(sVar)) {
            asVar.dfu.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(sVar.aAu(), asVar.dfu, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ddv - (i - this.ddt));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(as asVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.aTx() > 0 && sVar.aTr() != null) {
            asVar.dfg.setVisibility(0);
            asVar.dfg.removeViews(0, asVar.dfg.getChildCount() - 1);
            int size = sVar.aTr().size();
            int aTy = sVar.aTy();
            for (int i2 = 0; i2 < aTy; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.aTr().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) asVar.dfg, false);
                as asVar2 = new as(inflate, this.ddp, this.ddo, this.ddn, true);
                c(asVar2);
                a(asVar2, sVar2, (View) asVar.dfg, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, sVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.ddo) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    asVar2.ddA.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) asVar2.ddA.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    asVar2.ddA.setLayoutParams(layoutParams);
                    asVar2.ddA.setPadding(0, 0, 0, 0);
                    asVar.ddA.gu(null);
                } else {
                    asVar.ddA.gu(sVar.getBimg_url());
                    asVar2.ddA.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) asVar2.ddA.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    asVar2.ddA.setLayoutParams(layoutParams2);
                }
                asVar.dfg.addView(inflate, asVar.dfg.getChildCount() - 1);
            }
            if (aTy < size) {
                asVar.dfk.setVisibility(0);
                at.k(asVar.dfm, t.d.cp_bg_line_b);
                at.k(asVar.dfn, t.d.cp_bg_line_b);
                at.b(asVar.dfl, t.d.cp_cont_f, 1);
                asVar.dfk.setOnClickListener(new ar(this, aTy, size, sVar));
                return;
            }
            asVar.dfk.setVisibility(8);
            return;
        }
        asVar.dfg.setVisibility(8);
    }

    private boolean c(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (this.ddq == null || this.ddq.avv() == null || !this.ddq.avv().tN() || this.ddq.avv().tm() == null || sVar.aTs() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (c(sVar) && view != null && this.dfw != null) {
            if (this.deK == null) {
                this.deK = new com.baidu.tieba.vote.b(this.dfw);
            }
            this.deK.a(view, this.ddq);
        } else if (this.deK != null) {
            this.deK.setVisibility(8);
        }
    }

    private void c(as asVar) {
        asVar.aPp.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        asVar.dfa.setOnClickListener(this.brL);
        asVar.deT.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        asVar.dfb.setOnLongClickListener(this.aoa);
        asVar.ddA.setOnLongClickListener(this.aoa);
        asVar.dfb.setOnTouchListener(this.dds);
        asVar.ddA.setOnTouchListener(this.dds);
        asVar.ddA.setOnImageClickListener(this.aJc);
        asVar.ddA.setOnEmotionClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dny);
        asVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
        asVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
        asVar.dfu.setOnClickListener(this.brL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.ddq = eVar;
    }

    public void lP(int i) {
        this.ddn = i;
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void fR(boolean z) {
        this.ddp = z;
    }

    public void fS(boolean z) {
        this.ddr = z;
    }

    public void lM(String str) {
        this.deG = str;
    }

    public void L(View.OnClickListener onClickListener) {
        this.deJ = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }
}
