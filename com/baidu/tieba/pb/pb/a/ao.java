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
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ao extends cm<com.baidu.tieba.tbadkCore.data.s, as> implements View.OnClickListener {
    private TbRichTextView.d aFe;
    private View.OnLongClickListener ajO;
    private ArrayList<IconData> bfm;
    private View.OnClickListener bnn;
    private int dfH;
    private boolean dfI;
    private boolean dfJ;
    private com.baidu.tieba.pb.data.e dfK;
    private boolean dfL;
    private com.baidu.tieba.pb.a.d dfM;
    private int dfN;
    private int dfO;
    private boolean dfP;
    private final boolean dfQ;
    private String dgZ;
    private com.baidu.tieba.pb.pb.sub.an dha;
    private ArrayList<IconData> dhb;
    private View.OnClickListener dhc;
    private com.baidu.tieba.vote.b dhd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dfH = 0;
        this.dfI = true;
        this.dfJ = true;
        this.dfL = true;
        this.dfK = null;
        this.dgZ = null;
        this.dha = null;
        this.dhb = null;
        this.bfm = null;
        this.dhc = null;
        this.bnn = null;
        this.aFe = null;
        this.dfM = null;
        this.ajO = null;
        this.dfP = false;
        this.dfQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(as asVar) {
        if (asVar != null) {
            if (asVar.mSkinType != TbadkCoreApplication.m11getInst().getSkinType()) {
                at.l(asVar.dhi, t.d.cp_bg_line_b);
                at.l(asVar.dhj, t.d.cp_bg_line_b);
                at.c(asVar.dhC, t.d.subpb_listitem_time, 1);
                at.c(asVar.dhE, t.d.cp_link_tip_c, 3);
                at.c(asVar.aLz, t.d.cp_cont_f, 1);
                at.c(asVar.dhn, t.d.cp_cont_i, 1);
                at.c(asVar.dho, t.d.cp_cont_i, 1);
                at.c(asVar.dhq, t.d.cp_cont_d, 1);
                at.c(asVar.dhr, t.d.cp_cont_d, 1);
                at.c(asVar.dht, t.f.btn_pb_reply_selector);
                at.l(asVar.dfW, t.d.cp_bg_line_e);
                at.l(asVar.dfX, t.d.cp_bg_line_e);
                at.c(asVar.dfX, t.d.cp_bg_line_b);
                at.c(asVar.dhw, t.d.cp_bg_line_b);
            }
            asVar.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        }
    }

    private void init() {
        this.dfN = getDimensionPixelSize(t.e.ds30);
        this.dfO = com.baidu.adp.lib.util.k.B(this.mContext) - getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public as b(ViewGroup viewGroup) {
        as asVar = new as(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, viewGroup, false), this.dfJ, this.dfI, this.dfH, false);
        a(asVar);
        return asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, as asVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) asVar);
        a(asVar);
        c(asVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) at(i);
        if (sVar2 != null) {
            a(asVar, sVar2, view, false, i);
        }
        if (!this.dfP && this.dfQ && asVar != null && asVar.dfT.Hn() && (listView = ((PbActivity) this.dhY.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dfP = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a35  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a65  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0a71  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0a7d  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0a89  */
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
                asVar.dhm.setTag(null);
                asVar.dhm.setUserId(null);
                asVar.aLz.setText((CharSequence) null);
                asVar.dho.setVisibility(8);
                asVar.dhx.setVisibility(0);
                asVar.dht.setVisibility(0);
                asVar.dhs.setVisibility(8);
                if (sVar.aTU() == null || c(sVar)) {
                    asVar.dhy.setVisibility(8);
                } else if (TbadkCoreApplication.m11getInst().isBaobaoShouldOpen() && sVar.aTU().Au() == 1) {
                    asVar.dhy.changeSkinType(this.mSkinType);
                    asVar.dhy.setVisibility(0);
                    asVar.dhy.setData(sVar.aTU());
                } else {
                    asVar.dhy.setVisibility(8);
                }
                SparseArray sparseArray2 = (SparseArray) asVar.dhu.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    asVar.dhu.setTag(sparseArray2);
                    asVar.dfT.setTag(sparseArray2);
                }
                sparseArray2.put(t.g.tag_clip_board, sVar);
                sparseArray2.put(t.g.tag_is_subpb, false);
                a(asVar.dfT, getDimensionPixelSize(t.e.ds30));
                if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.dfI || c(sVar)) {
                    sparseArray2.put(t.g.tag_richtext_bg, null);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) asVar.dfT.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    asVar.dfT.setLayoutParams(layoutParams);
                    asVar.dfT.setPadding(0, 0, 0, 0);
                    asVar.dfT.gv(null);
                } else {
                    sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                    asVar.dfT.gv(sVar.getBimg_url());
                    if (sVar.aTS() == 1) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) asVar.dfT.getLayoutParams();
                        layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                        layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds40);
                        asVar.dfT.setLayoutParams(layoutParams2);
                    } else {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) asVar.dfT.getLayoutParams();
                        layoutParams3.topMargin = getDimensionPixelSize(t.e.ds20);
                        layoutParams3.bottomMargin = getDimensionPixelSize(t.e.ds20);
                        asVar.dfT.setLayoutParams(layoutParams3);
                    }
                }
                asVar.dhr.setText(ay.x(sVar.getTime()));
                asVar.dfV.setVisibility(8);
                if (sVar.aTS() == 1) {
                    at.l(asVar.dhh, t.d.cp_bg_line_d);
                    asVar.dhi.setVisibility(8);
                    asVar.dhj.setVisibility(8);
                    asVar.dhk.setVisibility(8);
                    asVar.dhu.setVisibility(8);
                    asVar.dhr.setVisibility(8);
                    asVar.dfV.setVisibility(0);
                    asVar.dhz.setVisibility(8);
                    String str = null;
                    long j = 0;
                    if (sVar.getAuthor() != null) {
                        j = sVar.getAuthor().getUserIdLong();
                        str = sVar.getAuthor().getUserName();
                    }
                    asVar.dfV.a(sVar.aUb(), str, j, com.baidu.adp.lib.h.b.c(this.dfK.avB().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                    asVar.dfV.sf();
                    if (this.dfL) {
                        PraiseData praise = this.dfK.avB().getPraise();
                        if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                            asVar.dfW.setVisibility(0);
                            asVar.dfX.setVisibility(0);
                            asVar.dfW.setIsFromPb(true);
                            asVar.dfW.a(praise, this.dfK.avB().getId(), praise.getPostId(), true);
                            asVar.dfW.cW(this.mSkinType);
                        } else {
                            asVar.dfW.setVisibility(8);
                            asVar.dfX.setVisibility(8);
                        }
                        com.baidu.tieba.graffiti.d.aj(asVar.dfW);
                        com.baidu.tieba.graffiti.d.aj(asVar.dfX);
                        com.baidu.tbadk.data.f aTV = sVar.aTV();
                        asVar.dhM.setVisibility(8);
                        if (aTV != null && !TextUtils.isEmpty(aTV.getName()) && !TextUtils.isEmpty(aTV.getName().trim())) {
                            String name = aTV.getName();
                            String lat = aTV.getLat();
                            String lng = aTV.getLng();
                            asVar.dhJ.setVisibility(0);
                            com.baidu.adp.lib.util.k.a(this.mContext, asVar.dhJ, 0, 10, 0, 10);
                            asVar.dhL.setText(aTV.getName());
                            at.c(asVar.dhL, t.d.cp_link_tip_c, 1);
                            at.c(asVar.dhK, t.f.icon_pb_pin);
                            asVar.dhJ.setOnClickListener(new ap(this, lat, lng, name));
                        } else {
                            asVar.dhJ.setVisibility(8);
                        }
                    } else {
                        asVar.dfW.setVisibility(8);
                        asVar.dfX.setVisibility(8);
                        asVar.dhJ.setVisibility(8);
                        asVar.dhM.setVisibility(8);
                    }
                    a(asVar.dfT, getDimensionPixelSize(t.e.ds30));
                    ((LinearLayout.LayoutParams) asVar.dhy.getLayoutParams()).leftMargin = getDimensionPixelSize(t.e.ds30);
                } else {
                    at.l(asVar.dhh, t.d.cp_bg_line_e);
                    if (i == 1) {
                        if (this.dfL) {
                            asVar.dhi.setVisibility(8);
                            asVar.dhj.setVisibility(8);
                            PraiseData praise2 = this.dfK.avB().getPraise();
                            if (praise2 != null && praise2.getUser() != null && praise2.getUser().size() > 0) {
                                asVar.dhj.setVisibility(8);
                                asVar.dhi.setVisibility(0);
                            } else {
                                asVar.dhj.setVisibility(0);
                                asVar.dhi.setVisibility(8);
                            }
                        } else {
                            asVar.dhi.setVisibility(0);
                            asVar.dhj.setVisibility(8);
                        }
                    } else {
                        asVar.dhi.setVisibility(0);
                        asVar.dhj.setVisibility(8);
                    }
                    asVar.dhk.setVisibility(0);
                    com.baidu.tbadk.data.f aTV2 = sVar.aTV();
                    asVar.dhJ.setVisibility(8);
                    if (aTV2 != null && !TextUtils.isEmpty(aTV2.getName()) && !TextUtils.isEmpty(aTV2.getName().trim())) {
                        String name2 = aTV2.getName();
                        String lat2 = aTV2.getLat();
                        String lng2 = aTV2.getLng();
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) asVar.dhM.getLayoutParams();
                        if (layoutParams4 != null) {
                            if (!this.dfJ) {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds74);
                            } else {
                                layoutParams4.leftMargin = getDimensionPixelSize(t.e.ds104);
                            }
                            asVar.dhM.setLayoutParams(layoutParams4);
                        }
                        asVar.dhM.setVisibility(0);
                        asVar.dhO.setText(aTV2.getName());
                        at.c(asVar.dhO, t.d.cp_link_tip_c, 1);
                        at.c(asVar.dhN, t.f.icon_pb_pin);
                        asVar.dhM.setOnClickListener(new aq(this, lat2, lng2, name2));
                    } else {
                        asVar.dhM.setVisibility(8);
                    }
                    asVar.dfW.setVisibility(8);
                    asVar.dfX.setVisibility(8);
                    asVar.dhu.setVisibility(0);
                    asVar.dhr.setVisibility(0);
                    String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTS()));
                    asVar.dhq.setVisibility(0);
                    asVar.dhq.setText(format);
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) asVar.dhy.getLayoutParams();
                    if (!this.dfJ) {
                        a(asVar.dfT, getDimensionPixelSize(t.e.ds74));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds74);
                    } else {
                        a(asVar.dfT, getDimensionPixelSize(t.e.ds104));
                        layoutParams5.leftMargin = getDimensionPixelSize(t.e.ds104);
                    }
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) asVar.dhv.getLayoutParams();
                    if (!this.dfJ) {
                        layoutParams6.leftMargin = 0;
                    } else {
                        layoutParams6.leftMargin = getDimensionPixelSize(t.e.ds30);
                    }
                }
                if (this.dgZ != null && !this.dgZ.equals("0") && this.dgZ.equals(sVar.getAuthor().getUserId())) {
                    asVar.dhs.setVisibility(0);
                    at.c(asVar.dhs, t.f.icon_floorhost);
                }
            }
            at.k(asVar.dhl, t.f.bg_floor_new_middle);
            asVar.dfT.setVideoImageId(t.f.pic_video);
            asVar.dfT.setTextColor(at.getColor(t.d.pb_listitem_content));
            at.c(asVar.dht, t.f.btn_pb_reply_selector);
            asVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) asVar.dht.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                asVar.dht.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(t.g.tag_pb_floor_number, Integer.valueOf(sVar.aTS()));
            if (sVar.aTW() > 0) {
                if (this.dha == null) {
                    this.dha = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.dha.setIsFromCDN(this.mIsFromCDN);
                    this.dha.J(this.dhc);
                    boolean z7 = false;
                    String userId2 = this.dfK.avB().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                    }
                    this.dha.v(this.dfK.avH(), z7);
                    this.dha.l(this.dfK.avB());
                    this.dha.gr(this.dfJ);
                }
                asVar.dhx.setVisibility(0);
                asVar.dhw.setVisibility(0);
                asVar.dhv.setVisibility(0);
                asVar.dhx.a(sVar, view);
                asVar.dhx.setChildOnClickListener(this.bnn);
                asVar.dhx.setChildOnLongClickListener(this.ajO);
                asVar.dhx.setChildOnTouchListener(this.dfM);
                asVar.dhx.setSubPbAdapter(this.dha);
                asVar.dhx.setVisibility(0);
            } else {
                asVar.dhx.setVisibility(8);
                asVar.dhw.setVisibility(8);
                asVar.dhv.setVisibility(8);
            }
            a(asVar, sVar, this.dfK.avK(), i);
            if (!z) {
                String portrait = sVar.getAuthor().getPortrait();
                if (sVar.getAuthor() != null) {
                    String name_show = sVar.getAuthor().getName_show();
                    if (com.baidu.tbadk.util.u.gp(name_show) > 14) {
                        name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                    }
                    asVar.aLz.setText(name_show);
                    ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        at.c(asVar.aLz, t.d.cp_cont_h, 1);
                    } else {
                        at.c(asVar.aLz, t.d.cp_cont_f, 1);
                    }
                    int level_id = sVar.getAuthor().getLevel_id();
                    int is_bawu = sVar.getAuthor().getIs_bawu();
                    String bawu_type = sVar.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        asVar.dhn.setVisibility(0);
                        at.c(asVar.dhn, BitmapHelper.getGradeResourceIdNew(level_id));
                        asVar.dhn.setContentDescription(String.format(TbadkCoreApplication.m11getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                        asVar.dhn.setOnClickListener(null);
                    } else {
                        asVar.dhn.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            at.c(asVar.dho, t.f.pb_manager);
                            asVar.dhn.setVisibility(8);
                            asVar.dho.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            at.c(asVar.dho, t.f.pb_assist);
                            asVar.dhn.setVisibility(8);
                            asVar.dho.setVisibility(0);
                        }
                    }
                    if (sVar.getAuthor().getGender() == 2) {
                        at.c(asVar.dhp, t.f.icon_pb_pop_girl);
                        asVar.dhp.setVisibility(0);
                    } else if (sVar.getAuthor().getGender() == 1) {
                        at.c(asVar.dhp, t.f.icon_pb_pop_boy);
                        asVar.dhp.setVisibility(0);
                    } else {
                        asVar.dhp.setVisibility(8);
                    }
                    if (com.baidu.tbadk.util.u.gp(sVar.getAuthor().getName_show()) >= 14 && asVar.dhn.getVisibility() == 0 && asVar.dhs.getVisibility() == 0) {
                        i2 = 2;
                    }
                    this.dhb = sVar.getAuthor().getIconInfo();
                    this.bfm = sVar.getAuthor().getTShowInfoNew();
                    if (asVar.bvy != null) {
                        asVar.bvy.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                        asVar.bvy.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.bkL);
                        asVar.bvy.a(this.dhb, i2, getDimensionPixelSize(t.e.pb_icon_width), getDimensionPixelSize(t.e.pb_icon_height), getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (asVar.adH != null) {
                        asVar.adH.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpK);
                        asVar.adH.a(this.bfm, 3, getDimensionPixelSize(t.e.ds36), getDimensionPixelSize(t.e.small_icon_height), getDimensionPixelSize(t.e.small_icon_margin), true);
                    }
                }
                asVar.dhm.setUserId(sVar.getAuthor().getUserId());
                asVar.dhm.setUserName(sVar.getAuthor().getUserName());
                asVar.dhm.setImageDrawable(null);
                asVar.aLz.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                asVar.aLz.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
                asVar.dhm.c(portrait, 28, false);
            }
            asVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.dfI) {
                asVar.dfT.setDefaultImageId(t.f.transparent_bg);
            } else {
                asVar.dfT.setDefaultImageId(t.f.icon_click);
            }
            asVar.dfT.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amw();
            }
            if (this.dfP || !this.dfQ) {
                asVar.dfT.a(aVar, false);
            } else {
                asVar.dfT.a(aVar, true);
            }
            boolean z8 = false;
            boolean z9 = false;
            if (this.dfK.avH() != 0) {
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
            if (this.dfK != null && this.dfK.avB() != null && this.dfK.avB().getAuthor() != null && sVar.getAuthor() != null) {
                String userId4 = this.dfK.avB().getAuthor().getUserId();
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
                        if (asVar.dhE != null) {
                            asVar.dhE.setVisibility(0);
                            asVar.dhE.setText(t.j.manage);
                            asVar.dhE.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z5) {
                        if (asVar.dhE != null) {
                            asVar.dhE.setVisibility(0);
                            asVar.dhE.setText(t.j.delete);
                            asVar.dhE.setCompoundDrawablesWithIntrinsicBounds(getDrawable(t.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (asVar.dhE != null) {
                        asVar.dhE.setVisibility(8);
                    }
                    int i3 = 1;
                    if (z) {
                        i3 = 2;
                    }
                    if (sVar.aTS() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z8) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dfK.avH()));
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
                        if (this.dfK.avB() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.dfK.avB().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dfK.avH()));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_should_delete_visible, false);
                    }
                    if (z) {
                        asVar.dht.setVisibility(8);
                        at.c(asVar.dhC, t.d.subpb_listitem_time, 1);
                        asVar.dhC.setText(String.format(this.mContext.getResources().getString(t.j.write_addition_update), ay.x(sVar.getTime())));
                        if (asVar.dhE.getVisibility() == 0) {
                            at.c(asVar.dhE, t.d.cp_link_tip_c, 3);
                            sparseArray.put(t.g.tag_user_mute_visible, false);
                            asVar.dhE.setTag(sparseArray);
                            asVar.dhE.setOnClickListener(this.dhc);
                        }
                    }
                    a(asVar, sVar, sVar.aTS() != 1, aVar);
                    b(asVar);
                    if (z) {
                        a(view, sVar);
                        if (this.dhd != null && aVar != null && !TextUtils.isEmpty(aVar.toString())) {
                            this.dhd.baU();
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
            if (sVar.aTS() == 1) {
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
            a(asVar, sVar, sVar.aTS() != 1, aVar);
            b(asVar);
            if (z) {
            }
        }
    }

    private void b(as asVar) {
        asVar.dfT.setTextViewOnTouchListener(this.dfM);
        asVar.dfT.setTextViewCheckSelection(false);
    }

    private void a(as asVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAC() == null || c(sVar)) {
            asVar.dhP.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.n.a(sVar.aAC(), asVar.dhP, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dfO - (i - this.dfN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(as asVar, com.baidu.tieba.tbadkCore.data.s sVar, AdditionData additionData, int i) {
        if (sVar.aTX() > 0 && sVar.aTR() != null) {
            asVar.dhB.setVisibility(0);
            asVar.dhB.removeViews(0, asVar.dhB.getChildCount() - 1);
            int size = sVar.aTR().size();
            int aTY = sVar.aTY();
            for (int i2 = 0; i2 < aTY; i2++) {
                com.baidu.tieba.tbadkCore.data.s sVar2 = sVar.aTR().get(i2);
                View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item, (ViewGroup) asVar.dhB, false);
                as asVar2 = new as(inflate, this.dfJ, this.dfI, this.dfH, true);
                c(asVar2);
                a(asVar2, sVar2, (View) asVar.dhB, true, i);
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(t.g.tag_clip_board, sVar2);
                sparseArray.put(t.g.tag_is_subpb, true);
                if (TextUtils.isEmpty(sVar2.getBimg_url()) || !this.dfI) {
                    sparseArray.put(t.g.tag_richtext_bg, null);
                    asVar2.dfT.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) asVar2.dfT.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    asVar2.dfT.setLayoutParams(layoutParams);
                    asVar2.dfT.setPadding(0, 0, 0, 0);
                    asVar.dfT.gv(null);
                } else {
                    asVar.dfT.gv(sVar.getBimg_url());
                    asVar2.dfT.setTag(sparseArray);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) asVar2.dfT.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(t.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(t.e.ds36);
                    asVar2.dfT.setLayoutParams(layoutParams2);
                }
                asVar.dhB.addView(inflate, asVar.dhB.getChildCount() - 1);
            }
            if (aTY < size) {
                asVar.dhF.setVisibility(0);
                at.k(asVar.dhH, t.d.cp_bg_line_b);
                at.k(asVar.dhI, t.d.cp_bg_line_b);
                at.c(asVar.dhG, t.d.cp_cont_f, 1);
                asVar.dhF.setOnClickListener(new ar(this, aTY, size, sVar));
                return;
            }
            asVar.dhF.setVisibility(8);
            return;
        }
        asVar.dhB.setVisibility(8);
    }

    private boolean c(com.baidu.tieba.tbadkCore.data.s sVar) {
        return (this.dfK == null || this.dfK.avB() == null || !this.dfK.avB().rl() || this.dfK.avB().qL() == null || sVar.aTS() != 1) ? false : true;
    }

    private void a(View view, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (c(sVar) && view != null && this.dhY != null) {
            if (this.dhd == null) {
                this.dhd = new com.baidu.tieba.vote.b(this.dhY);
            }
            this.dhd.a(view, this.dfK);
        } else if (this.dhd != null) {
            this.dhd.setVisibility(8);
        }
    }

    private void c(as asVar) {
        asVar.aLz.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpJ);
        asVar.dht.setOnClickListener(this.bnn);
        asVar.dhm.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpJ);
        asVar.dhu.setOnLongClickListener(this.ajO);
        asVar.dfT.setOnLongClickListener(this.ajO);
        asVar.dhu.setOnTouchListener(this.dfM);
        asVar.dfT.setOnTouchListener(this.dfM);
        asVar.dfT.setOnImageClickListener(this.aFe);
        asVar.dfT.setOnEmotionClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpL);
        asVar.bvy.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.bkL);
        asVar.adH.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpK);
        asVar.dhP.setOnClickListener(this.bnn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfK = eVar;
    }

    public void lE(int i) {
        this.dfH = i;
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void gr(boolean z) {
        this.dfJ = z;
    }

    public void gs(boolean z) {
        this.dfL = z;
    }

    public void lQ(String str) {
        this.dgZ = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dhc = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }
}
