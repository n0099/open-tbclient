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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cl;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class an extends cl<com.baidu.tieba.tbadkCore.data.r, ar> implements View.OnClickListener {
    private TbRichTextView.d aGi;
    private View.OnLongClickListener anJ;
    private ArrayList<IconData> beA;
    private View.OnClickListener bmy;
    private int cJW;
    private boolean cJX;
    private boolean cJY;
    private com.baidu.tieba.pb.a.c cJZ;
    private boolean cKa;
    private com.baidu.tieba.pb.b.c cKb;
    private int cKc;
    private int cKd;
    private boolean cKe;
    private final boolean cKf;
    private String cLq;
    private com.baidu.tieba.pb.pb.sub.am cLr;
    private ArrayList<IconData> cLs;
    private View.OnClickListener cLt;
    private com.baidu.tieba.vote.b cLu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cJW = 0;
        this.cJX = true;
        this.cJY = true;
        this.cKa = true;
        this.cJZ = null;
        this.cLq = null;
        this.cLr = null;
        this.cLs = null;
        this.beA = null;
        this.cLt = null;
        this.bmy = null;
        this.aGi = null;
        this.cKb = null;
        this.anJ = null;
        this.cKe = false;
        this.cKf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(ar arVar) {
        if (arVar != null) {
            if (arVar.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ar.l(arVar.cLz, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.l(arVar.cLA, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.b(arVar.cLR, t.d.subpb_listitem_time, 1);
                com.baidu.tbadk.core.util.ar.b(arVar.cLT, t.d.cp_link_tip_c, 3);
                com.baidu.tbadk.core.util.ar.b(arVar.aMu, t.d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ar.b((View) arVar.cLE, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ar.b((View) arVar.cLF, t.d.cp_cont_i, 1);
                com.baidu.tbadk.core.util.ar.b(arVar.cLH, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ar.b(arVar.cLI, t.d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ar.c(arVar.cLK, t.f.btn_pb_reply_selector);
                com.baidu.tbadk.core.util.ar.l(arVar.cKj, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.l(arVar.cKl, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ar.l(arVar.cKm, t.d.cp_bg_line_e);
                com.baidu.tbadk.core.util.ar.c(arVar.cKm, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.c(arVar.cLN, t.d.cp_bg_line_b);
            }
            arVar.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    private void init() {
        this.cKc = getDimensionPixelSize(t.e.ds30);
        this.cKd = com.baidu.adp.lib.util.k.K(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public ar b(ViewGroup viewGroup) {
        ar arVar = new ar(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.cJY, this.cJX, this.cJW, false);
        a(arVar);
        return arVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, ar arVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) arVar);
        a(arVar);
        c(arVar);
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) aG(i);
        if (rVar2 != null) {
            a(arVar, rVar2, view, false, i);
        }
        if (!this.cKe && this.cKf && arVar != null && arVar.cKi.HB() && (listView = ((PbActivity) this.cNL.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cKe = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a15  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a45  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0a51  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0a5d  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0a69  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(ar arVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        boolean z6;
        if (arVar != null && rVar != null) {
            if (!z) {
                arVar.cLD.setTag(null);
                arVar.cLD.setUserId(null);
                arVar.aMu.setText((CharSequence) null);
                arVar.cLF.setVisibility(8);
                arVar.cLO.setVisibility(0);
                arVar.cLK.setVisibility(0);
                arVar.cLJ.setVisibility(8);
                if (rVar.aMx() == null || c(rVar)) {
                    arVar.cLP.setVisibility(8);
                } else if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && rVar.aMx().BX() == 1) {
                    arVar.cLP.changeSkinType(this.mSkinType);
                    arVar.cLP.setVisibility(0);
                    arVar.cLP.setData(rVar.aMx());
                } else {
                    arVar.cLP.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) arVar.cLL.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    arVar.cLL.setTag(sparseArray2);
                    arVar.cKi.setTag(sparseArray2);
                }
                sparseArray2.put(t.g.tag_clip_board, rVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                a(arVar.cKi, getDimensionPixelSize(t.e.ds30));
                if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cJX || c(rVar)) {
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) arVar.cKi.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    arVar.cKi.setLayoutParams(layoutParams);
                    arVar.cKi.setPadding(0, 0, 0, 0);
                    arVar.cKi.gi(null);
                } else {
                    sparseArray2.put(t.g.tag_richtext_bg, rVar.getBimg_url());
                    arVar.cKi.gi(rVar.getBimg_url());
                    if (rVar.aMw() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) arVar.cKi.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds40);
                        arVar.cKi.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) arVar.cKi.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(t.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(t.e.ds20);
                        arVar.cKi.setLayoutParams(layoutParams3);
                    }
                }
                arVar.cLI.setText(aw.t(rVar.getTime()));
                arVar.cKk.setVisibility(8);
                if (rVar.aMw() == 1) {
                    com.baidu.tbadk.core.util.ar.l(arVar.cLy, t.d.cp_bg_line_d);
                    arVar.cLz.setVisibility(8);
                    arVar.cLA.setVisibility(8);
                    arVar.cLB.setVisibility(8);
                    arVar.cLL.setVisibility(8);
                    arVar.cLI.setVisibility(8);
                    arVar.cKk.setVisibility(0);
                    String str = null;
                    long j = 0;
                    if (rVar.getAuthor() != null) {
                        j = rVar.getAuthor().getUserIdLong();
                        str = rVar.getAuthor().getUserName();
                    }
                    arVar.cKk.a(rVar.aME(), str, j, com.baidu.adp.lib.h.b.c(this.cJZ.aoF().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                    arVar.cKk.uv();
                    if (this.cKa) {
                        PraiseData praise = this.cJZ.aoF().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            arVar.cKl.setVisibility(0);
                            arVar.cKj.setVisibility(0);
                            arVar.cKm.setVisibility(0);
                            arVar.cKl.setIsFromPb(true);
                            arVar.cKl.a(praise, this.cJZ.aoF().getId(), praise.getPostId(), true);
                            arVar.cKl.dk(this.mSkinType);
                        } else {
                            arVar.cKl.setVisibility(8);
                            arVar.cKj.setVisibility(8);
                            arVar.cKm.setVisibility(8);
                        }
                        com.baidu.tbadk.data.d aMy = rVar.aMy();
                        arVar.cMb.setVisibility(8);
                        if (aMy != null && !TextUtils.isEmpty(aMy.getName()) && !TextUtils.isEmpty(aMy.getName().trim())) {
                            String name = aMy.getName();
                            String lat = aMy.getLat();
                            String lng = aMy.getLng();
                            arVar.cLY.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, arVar.cLY, 0, 10, 0, 10);
                            arVar.cMa.setText(aMy.getName());
                            com.baidu.tbadk.core.util.ar.b(arVar.cMa, t.d.cp_cont_c, 1);
                            com.baidu.tbadk.core.util.ar.c(arVar.cLZ, t.f.icon_frs_site);
                            arVar.cLY.setOnClickListener(new ao(this, lat, lng, name));
                        } else {
                            arVar.cLY.setVisibility(8);
                        }
                    } else {
                        arVar.cKl.setVisibility(8);
                        arVar.cKj.setVisibility(8);
                        arVar.cKm.setVisibility(8);
                        arVar.cLY.setVisibility(8);
                        arVar.cMb.setVisibility(8);
                    }
                    a(arVar.cKi, getDimensionPixelSize(t.e.ds30));
                    ((LinearLayout.LayoutParams) arVar.cLP.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                } else {
                    com.baidu.tbadk.core.util.ar.l(arVar.cLy, t.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.cKa) {
                            arVar.cLz.setVisibility(8);
                            arVar.cLA.setVisibility(8);
                            PraiseData praise2 = this.cJZ.aoF().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                arVar.cLA.setVisibility(8);
                                arVar.cLz.setVisibility(0);
                            } else {
                                arVar.cLA.setVisibility(0);
                                arVar.cLz.setVisibility(8);
                            }
                        } else {
                            arVar.cLz.setVisibility(0);
                            arVar.cLA.setVisibility(8);
                        }
                    } else {
                        arVar.cLz.setVisibility(0);
                        arVar.cLA.setVisibility(8);
                    }
                    arVar.cLB.setVisibility(0);
                    com.baidu.tbadk.data.d aMy2 = rVar.aMy();
                    arVar.cLY.setVisibility(8);
                    if (aMy2 != null && !TextUtils.isEmpty(aMy2.getName()) && !TextUtils.isEmpty(aMy2.getName().trim())) {
                        String name2 = aMy2.getName();
                        String lat2 = aMy2.getLat();
                        String lng2 = aMy2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) arVar.cMb.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.cJY) {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds104);
                            }
                            arVar.cMb.setLayoutParams(layoutParams4);
                        }
                        arVar.cMb.setVisibility(0);
                        arVar.cMd.setText(aMy2.getName());
                        com.baidu.tbadk.core.util.ar.b(arVar.cMd, t.d.cp_cont_c, 1);
                        com.baidu.tbadk.core.util.ar.c(arVar.cMc, t.f.icon_frs_site);
                        arVar.cMb.setOnClickListener(new ap(this, lat2, lng2, name2));
                    } else {
                        arVar.cMb.setVisibility(8);
                    }
                    arVar.cKl.setVisibility(8);
                    arVar.cKj.setVisibility(8);
                    arVar.cKm.setVisibility(8);
                    arVar.cLL.setVisibility(0);
                    arVar.cLI.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(rVar.aMw()));
                    arVar.cLH.setVisibility(0);
                    arVar.cLH.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) arVar.cLP.getLayoutParams();
                    if (!this.cJY) {
                        a(arVar.cKi, getDimensionPixelSize(t.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds74);
                    } else {
                        a(arVar.cKi, getDimensionPixelSize(t.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) arVar.cLM.getLayoutParams();
                    if (!this.cJY) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds30);
                    }
                }
                if (this.cLq != null && !this.cLq.equals("0") && this.cLq.equals(rVar.getAuthor().getUserId())) {
                    arVar.cLJ.setVisibility(0);
                    com.baidu.tbadk.core.util.ar.c(arVar.cLJ, t.f.icon_floorhost);
                }
            }
            com.baidu.tbadk.core.util.ar.k(arVar.cLC, t.f.bg_floor_new_middle);
            arVar.cKi.setVideoImageId(t.f.pic_video);
            arVar.cKi.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.ar.c(arVar.cLK, t.f.btn_pb_reply_selector);
            arVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) arVar.cLK.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                arVar.cLK.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, rVar);
            sparseArray.put(t.g.tag_load_sub_data, rVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            if (rVar.aMz() > 0) {
                if (this.cLr == null) {
                    this.cLr = new com.baidu.tieba.pb.pb.sub.am(this.mContext);
                    this.cLr.setIsFromCDN(this.mIsFromCDN);
                    this.cLr.J(this.cLt);
                    boolean z7 = false;
                    String userId2 = this.cJZ.aoF().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.cLr.t(this.cJZ.aoJ(), z7);
                    this.cLr.h(this.cJZ.aoF());
                    this.cLr.fh(this.cJY);
                }
                arVar.cLO.setVisibility(0);
                arVar.cLN.setVisibility(0);
                arVar.cLM.setVisibility(0);
                arVar.cLO.a(rVar, view);
                arVar.cLO.setChildOnClickListener(this.bmy);
                arVar.cLO.setChildOnLongClickListener(this.anJ);
                arVar.cLO.setChildOnTouchListener(this.cKb);
                arVar.cLO.setSubPbAdapter(this.cLr);
                arVar.cLO.setVisibility(0);
            } else {
                arVar.cLO.setVisibility(8);
                arVar.cLN.setVisibility(8);
                arVar.cLM.setVisibility(8);
            }
            a(arVar, rVar, this.cJZ.aoM(), i);
            if (!z) {
                String portrait = rVar.getAuthor().getPortrait();
                if (rVar.getAuthor() != null) {
                    String name_show = rVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.o.gf(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.o.d(name_show, 0, 14)) + "...";
                    }
                    arVar.aMu.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.ar.b(arVar.aMu, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ar.b(arVar.aMu, t.d.cp_cont_f, 1);
                    }
                    int level_id = rVar.getAuthor().getLevel_id();
                    int is_bawu = rVar.getAuthor().getIs_bawu();
                    String bawu_type = rVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        arVar.cLE.setVisibility(0);
                        com.baidu.tbadk.core.util.ar.c(arVar.cLE, BitmapHelper.getGradeResourceIdNew(level_id));
                        arVar.cLE.setOnClickListener(null);
                    } else {
                        arVar.cLE.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ar.c(arVar.cLF, t.f.pb_manager);
                            arVar.cLE.setVisibility(8);
                            arVar.cLF.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ar.c(arVar.cLF, t.f.pb_assist);
                            arVar.cLE.setVisibility(8);
                            arVar.cLF.setVisibility(0);
                        }
                    }
                    if (rVar.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.ar.c(arVar.cLG, t.f.icon_pb_pop_girl);
                        arVar.cLG.setVisibility(0);
                    } else if (rVar.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.ar.c(arVar.cLG, t.f.icon_pb_pop_boy);
                        arVar.cLG.setVisibility(0);
                    } else {
                        arVar.cLG.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.o.gf(rVar.getAuthor().getName_show()) >= 14 && arVar.cLE.getVisibility() == 0 && arVar.cLJ.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.cLs = rVar.getAuthor().getIconInfo();
                    this.beA = rVar.getAuthor().getTShowInfoNew();
                    if (arVar.bqH != null) {
                        arVar.bqH.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                        arVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
                        arVar.bqH.a(this.cLs, i2, getDimensionPixelSize(t.e.pb_icon_width), getDimensionPixelSize(t.e.pb_icon_height), getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (arVar.ahI != null) {
                        arVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
                        arVar.ahI.a(this.beA, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.small_icon_height), getDimensionPixelSize(t.e.small_icon_margin), true);
                    }
                }
                arVar.cLD.setUserId(rVar.getAuthor().getUserId());
                arVar.cLD.setUserName(rVar.getAuthor().getUserName());
                arVar.cLD.setImageDrawable(null);
                arVar.aMu.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                arVar.aMu.setTag(t.g.tag_user_name, rVar.getAuthor().getUserName());
                arVar.cLD.d(portrait, 28, false);
            }
            arVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            if (this.cJX) {
                arVar.cKi.setDefaultImageId(t.f.img_default_100);
            } else {
                arVar.cKi.setDefaultImageId(t.f.icon_click);
            }
            arVar.cKi.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aiT();
            }
            if (this.cKe || !this.cKf) {
                arVar.cKi.a(aVar, false);
            } else {
                arVar.cKi.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.cJZ.aoJ() != 0) {
                z8 = true;
                z9 = true;
                String userId3 = rVar.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z8 = false;
                }
            }
            if (this.cJZ != null && this.cJZ.aoF() != null && this.cJZ.aoF().getAuthor() != null && rVar.getAuthor() != null) {
                String userId4 = this.cJZ.aoF().getAuthor().getUserId();
                String userId5 = rVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = false;
                    } else {
                        z2 = false;
                        z4 = true;
                    }
                    userId = rVar.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = z3;
                        z6 = z4;
                    }
                    if (!z8) {
                        if (arVar.cLT != null) {
                            arVar.cLT.setVisibility(0);
                            arVar.cLT.setText(t.j.manage);
                            arVar.cLT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (arVar.cLT != null) {
                            arVar.cLT.setVisibility(0);
                            arVar.cLT.setText(t.j.delete);
                            arVar.cLT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (arVar.cLT != null) {
                        arVar.cLT.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (rVar.aMw() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cJZ.aoJ()));
                        sparseArray.put(t.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                        }
                        if (this.cJZ.aoF() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.cJZ.aoF().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, rVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cJZ.aoJ()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, rVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        arVar.cLK.setVisibility(8);
                        com.baidu.tbadk.core.util.ar.b(arVar.cLR, t.d.subpb_listitem_time, 1);
                        arVar.cLR.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), aw.t(rVar.getTime())));
                        if (arVar.cLT.getVisibility() == 0) {
                            com.baidu.tbadk.core.util.ar.b(arVar.cLT, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            arVar.cLT.setTag(sparseArray);
                            arVar.cLT.setOnClickListener(this.cLt);
                        }
                    }
                    a(arVar, rVar, rVar.aMw() != 1, aVar);
                    b(arVar);
                    if (z) {
                        a(view, rVar);
                        if (this.cLu != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.cLu.aSc();
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
            userId = rVar.getAuthor().getUserId();
            if (userId == null) {
            }
            z5 = z3;
            z6 = z4;
            if (!z8) {
            }
            int i32 = 1;
            if (z) {
            }
            if (rVar.aMw() == 1) {
            }
            sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
            if (!z8) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (z) {
            }
            a(arVar, rVar, rVar.aMw() != 1, aVar);
            b(arVar);
            if (z) {
            }
        }
    }

    private void b(ar arVar) {
        arVar.cKi.setTextViewOnTouchListener(this.cKb);
        arVar.cKi.setTextViewCheckSelection(false);
    }

    private void a(ar arVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar == null || rVar.asK() == null || c(rVar)) {
            arVar.cMe.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar.asK(), arVar.cMe, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cKd - (i - this.cKc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(ar arVar, com.baidu.tieba.tbadkCore.data.r rVar, AdditionData additionData, int i) {
        if (rVar.aMA() > 0 && rVar.aMv() != null) {
            arVar.cLQ.setVisibility(0);
            arVar.cLQ.removeViews(0, arVar.cLQ.getChildCount() - 1);
            int size = rVar.aMv().size();
            int aMB = rVar.aMB();
            for (int i2 = 0; i2 < aMB; i2++) {
                com.baidu.tieba.tbadkCore.data.r rVar2 = rVar.aMv().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) arVar.cLQ, false);
                ar arVar2 = new ar(inflate, this.cJY, this.cJX, this.cJW, true);
                c(arVar2);
                a(arVar2, rVar2, (View) arVar.cLQ, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, rVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(rVar2.getBimg_url()) || !this.cJX) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    arVar2.cKi.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) arVar2.cKi.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    arVar2.cKi.setLayoutParams(layoutParams);
                    arVar2.cKi.setPadding(0, 0, 0, 0);
                    arVar.cKi.gi(null);
                } else {
                    arVar.cKi.gi(rVar.getBimg_url());
                    arVar2.cKi.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) arVar2.cKi.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    arVar2.cKi.setLayoutParams(layoutParams2);
                }
                arVar.cLQ.addView(inflate, arVar.cLQ.getChildCount() - 1);
            }
            if (aMB < size) {
                arVar.cLU.setVisibility(0);
                com.baidu.tbadk.core.util.ar.k(arVar.cLW, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.k(arVar.cLX, t.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.ar.b(arVar.cLV, t.d.cp_cont_f, 1);
                arVar.cLU.setOnClickListener(new aq(this, aMB, size, rVar));
                return;
            }
            arVar.cLU.setVisibility(8);
            return;
        }
        arVar.cLQ.setVisibility(8);
    }

    private boolean c(com.baidu.tieba.tbadkCore.data.r rVar) {
        return (this.cJZ == null || this.cJZ.aoF() == null || !this.cJZ.aoF().tI() || this.cJZ.aoF().tk() == null || rVar.aMw() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (c(rVar) && view != null && this.cNL != null) {
            if (this.cLu == null) {
                this.cLu = new com.baidu.tieba.vote.b(this.cNL);
            }
            this.cLu.a(view, this.cJZ);
        } else if (this.cLu != null) {
            this.cLu.setVisibility(8);
        }
    }

    private void c(ar arVar) {
        arVar.aMu.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        arVar.cLK.setOnClickListener(this.bmy);
        arVar.cLD.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        arVar.cLL.setOnLongClickListener(this.anJ);
        arVar.cKi.setOnLongClickListener(this.anJ);
        arVar.cLL.setOnTouchListener(this.cKb);
        arVar.cKi.setOnTouchListener(this.cKb);
        arVar.cKi.setOnImageClickListener(this.aGi);
        arVar.cKi.setOnEmotionClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSG);
        arVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
        arVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
        arVar.cMe.setOnClickListener(this.bmy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cJZ = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cJW = i;
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void fh(boolean z) {
        this.cJY = z;
    }

    public void fi(boolean z) {
        this.cKa = z;
    }

    public void kz(String str) {
        this.cLq = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.cLt = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }
}
