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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends l<PostData, g> implements View.OnClickListener {
    private TbRichTextView.e aRy;
    private com.baidu.tieba.pb.a.c aRz;
    private View.OnLongClickListener avB;
    private View.OnClickListener cUc;
    private ArrayList<IconData> dyb;
    private int eFI;
    private boolean eFJ;
    private boolean eFK;
    private com.baidu.tieba.pb.data.f eFL;
    private com.baidu.tieba.pb.pb.sub.d eFM;
    private ArrayList<IconData> eFN;
    private View.OnClickListener eFO;
    private boolean eFP;
    private final boolean eFQ;
    private int eFR;
    private int eFS;
    private com.baidu.tieba.vote.a eFT;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eFI = 0;
        this.eFJ = true;
        this.eFK = true;
        this.eFL = null;
        this.mHostId = null;
        this.eFM = null;
        this.eFN = null;
        this.dyb = null;
        this.eFO = null;
        this.cUc = null;
        this.aRy = null;
        this.aRz = null;
        this.avB = null;
        this.eFP = false;
        this.eFQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(g gVar) {
        if (gVar != null) {
            if (gVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(gVar.eGs, d.e.common_color_10005, 1);
                aj.c(gVar.eGu, d.e.cp_link_tip_c, 3);
                aj.c(gVar.bEL, d.e.cp_cont_f, 1);
                aj.c(gVar.eGd, d.e.cp_cont_i, 1);
                aj.c(gVar.eGe, d.e.cp_cont_i, 1);
                aj.c(gVar.eGf, d.e.cp_cont_d, 1);
                aj.c(gVar.eGg, d.e.cp_cont_d, 1);
                aj.k(gVar.eGj, d.e.cp_bg_line_e);
                aj.k(gVar.eGk, d.e.cp_bg_line_e);
                aj.c(gVar.eGk, d.e.cp_bg_line_b);
                aj.k(gVar.eGn, d.e.cp_bg_line_c);
            }
            gVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eFR = getDimensionPixelSize(d.f.ds30);
        this.eFS = k.ad(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public g onCreateViewHolder(ViewGroup viewGroup) {
        g gVar = new g(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.eFJ, this.eFI, false);
        a(gVar);
        return gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, g gVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, gVar);
        a(gVar);
        c(gVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sz();
            a(gVar, postData2, view, i);
        }
        if (!this.eFP && this.eFQ && gVar != null && gVar.eGi.Jj() && (listView = ((PbActivity) this.eGQ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eFP = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x084a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0a70  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0aad  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0ab9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0ac5  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0ad1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(g gVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (gVar != null && postData != null) {
            aj.k(gVar.eGq, d.e.cp_bg_line_b);
            gVar.eGc.setTag(null);
            gVar.eGc.setUserId(null);
            gVar.bEL.setText((CharSequence) null);
            gVar.eGe.setVisibility(8);
            gVar.eGn.setVisibility(0);
            gVar.eGh.setVisibility(8);
            SparseArray sparseArray = (SparseArray) gVar.eGm.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                gVar.eGm.setTag(sparseArray);
                gVar.eGi.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(gVar.eGi, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eFJ || g(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.eGi.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                gVar.eGi.setLayoutParams(layoutParams);
                gVar.eGi.setPadding(0, 0, 0, 0);
                gVar.eGi.gZ(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                gVar.eGi.gZ(postData.getBimg_url());
                if (postData.bso() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.eGi.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    gVar.eGi.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) gVar.eGi.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    gVar.eGi.setLayoutParams(layoutParams3);
                }
            }
            gVar.eGg.setText(am.r(postData.getTime()));
            gVar.eGl.setVisibility(8);
            if (postData.bso() == 1) {
                aj.k(gVar.eFY, d.e.cp_bg_line_d);
                gVar.eFZ.setVisibility(8);
                gVar.eGq.setVisibility(8);
                gVar.eGm.setVisibility(8);
                gVar.eGg.setVisibility(8);
                gVar.eGl.setVisibility(0);
                gVar.eGo.setVisibility(8);
                gVar.eGp.setVisibility(8);
                gVar.eGF.setVisibility(8);
                gVar.eGz.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                gVar.eGl.a(postData.bsv(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eFL.aOX().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                gVar.eGl.onChangeSkinType();
                if (this.eFK) {
                    PraiseData rr = this.eFL.aOX().rr();
                    if (rr != null && rr.getUser() != null && rr.getUser().size() > 0) {
                        gVar.eGj.setVisibility(0);
                        gVar.eGk.setVisibility(0);
                        gVar.eGj.setIsFromPb(true);
                        gVar.eGj.a(rr, this.eFL.aOX().getId(), rr.getPostId(), true);
                        gVar.eGj.du(this.mSkinType);
                    } else {
                        gVar.eGj.setVisibility(8);
                        gVar.eGk.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.b.az(gVar.eGj);
                    com.baidu.tieba.graffiti.b.az(gVar.eGk);
                } else {
                    gVar.eGj.setVisibility(8);
                    gVar.eGk.setVisibility(8);
                }
                a(gVar.eGi, getDimensionPixelSize(d.f.ds30));
                if (!this.eGQ.aQN()) {
                    if (this.eFL.aPr() != null && this.eFL.aPr().size() <= 4) {
                        gVar.eGK.setVisibility(0);
                        List<be> aPr = this.eFL.aPr();
                        for (int i2 = 0; i2 < aPr.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, gVar.eGG, aPr);
                            } else if (i2 == 1) {
                                a(i2, gVar.eGH, aPr);
                            } else if (i2 == 2) {
                                a(i2, gVar.eGI, aPr);
                            } else if (i2 == 3) {
                                a(i2, gVar.eGJ, aPr);
                            }
                        }
                    }
                } else {
                    gVar.eGK.setVisibility(8);
                }
            } else {
                gVar.eGK.setVisibility(8);
                gVar.eGq.setVisibility(0);
                aj.k(gVar.eFY, d.e.cp_bg_line_e);
                gVar.eFZ.setVisibility(0);
                h bsr = postData.bsr();
                gVar.eGz.setVisibility(8);
                if (bsr != null && !TextUtils.isEmpty(bsr.getName()) && !TextUtils.isEmpty(bsr.getName().trim())) {
                    final String name = bsr.getName();
                    final String lat = bsr.getLat();
                    final String lng = bsr.getLng();
                    gVar.eGD.setText(bsr.getName());
                    aj.c(gVar.eGD, d.e.cp_cont_c, 1);
                    gVar.eGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.f.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!i.hi()) {
                                    f.this.eGQ.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.T(f.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, f.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    gVar.eGD.setVisibility(8);
                }
                gVar.eGj.setVisibility(8);
                gVar.eGk.setVisibility(8);
                gVar.eGm.setVisibility(0);
                gVar.eGg.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bso()));
                gVar.eGf.setVisibility(0);
                gVar.eGf.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                gVar.eGh.setVisibility(0);
                aj.i(gVar.eGh, d.e.cp_link_tip_a);
            } else {
                gVar.eGh.setVisibility(8);
            }
            aj.j(gVar.eGa, d.g.bg_floor_new_middle);
            gVar.eGi.setVideoImageId(d.g.pic_video);
            gVar.eGi.setTextColor(aj.getColor(d.e.common_color_10039));
            gVar.eGi.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bso()));
            if (postData.bss() > 0) {
                if (this.eFM == null) {
                    this.eFM = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eFM.setIsFromCDN(this.mIsFromCDN);
                    this.eFM.C(this.eFO);
                    boolean z6 = false;
                    String userId2 = this.eFL.aOX().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.eFM.z(this.eFL.aPi(), z6);
                    this.eFM.Z(this.eFL.aOX());
                }
                this.eFM.pB(postData.getId());
                gVar.eGn.setVisibility(0);
                gVar.eGn.a(postData, view);
                gVar.eGn.setChildOnClickListener(this.cUc);
                gVar.eGn.setChildOnLongClickListener(this.avB);
                gVar.eGn.setChildOnTouchListener(this.aRz);
                gVar.eGn.setSubPbAdapter(this.eFM);
                gVar.eGn.setVisibility(0);
                gVar.eGp.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds24));
                gVar.eGF.setVisibility(0);
            } else {
                gVar.eGp.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds40));
                gVar.eGn.setVisibility(8);
                gVar.eGF.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = v.gS(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gS = v.gS(name_show);
                if (i3 > 0) {
                    if (gS > 12) {
                        name_show = v.e(name_show, 0, 14) + "...";
                    }
                } else if (gS > 14) {
                    name_show = v.e(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    gVar.bEL.setText(ah(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    gVar.bEL.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(gVar.bEL, d.e.cp_cont_h, 1);
                } else {
                    aj.c(gVar.bEL, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    gVar.eGd.setVisibility(0);
                    aj.c(gVar.eGd, BitmapHelper.getGradeResourceIdNew(level_id));
                    gVar.eGd.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    gVar.eGd.setOnClickListener(null);
                } else {
                    gVar.eGd.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(gVar.eGe, d.g.pb_manager);
                        gVar.eGd.setVisibility(8);
                        gVar.eGe.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(gVar.eGe, d.g.pb_assist);
                        gVar.eGd.setVisibility(8);
                        gVar.eGe.setVisibility(0);
                    }
                }
                int gS2 = v.gS(postData.getAuthor().getName_show());
                if (gS2 >= 14 && gVar.eGd.getVisibility() == 0 && gVar.eGh.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gS2 < 12 || gVar.eGd.getVisibility() != 0 || gVar.eGh.getVisibility() != 0) ? i4 : i4 - 1;
                this.eFN = postData.getAuthor().getIconInfo();
                this.dyb = postData.getAuthor().getTShowInfoNew();
                if (gVar.cHC != null) {
                    gVar.cHC.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    gVar.cHC.setOnClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.czD);
                    gVar.cHC.a(this.eFN, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (gVar.aoS != null) {
                    gVar.aoS.setOnClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.eUi);
                    gVar.aoS.a(this.dyb, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pR())) {
                gVar.eGc.setVisibility(4);
                gVar.eGb.setVisibility(0);
                gVar.eGb.eq(postData.getAuthor().getPendantData().pR());
                gVar.eGb.getHeadView().c(portrait, 28, false);
                gVar.eGb.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                gVar.eGb.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                gVar.eGc.setVisibility(0);
                gVar.eGb.setVisibility(8);
                gVar.eGc.setUserId(postData.getAuthor().getUserId());
                gVar.eGc.setUserName(postData.getAuthor().getUserName());
                gVar.eGc.setImageDrawable(null);
                gVar.eGc.c(portrait, 28, false);
            }
            gVar.bEL.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            gVar.bEL.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            gVar.eGi.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            if (this.eFJ) {
                gVar.eGi.setDefaultImageId(d.g.transparent_bg);
            } else {
                gVar.eGi.setDefaultImageId(d.g.icon_click);
            }
            gVar.eGi.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aDg();
            }
            if (this.eFP || !this.eFQ) {
                gVar.eGi.a(tbRichText, false);
            } else {
                gVar.eGi.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eFL.aPi() != 0) {
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
            if (this.eFL != null && this.eFL.aOX() != null && this.eFL.aOX().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eFL.aOX().getAuthor().getUserId();
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
                        if (gVar.eGu != null) {
                            gVar.eGu.setVisibility(0);
                            gVar.eGu.setText(d.l.manage);
                            gVar.eGu.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (gVar.eGu != null) {
                            gVar.eGu.setVisibility(0);
                            gVar.eGu.setText(d.l.delete);
                            gVar.eGu.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (gVar.eGu != null) {
                        gVar.eGu.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.bso() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFL.aPi()));
                        sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray2.put(d.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(d.h.tag_user_mute_visible, true);
                        sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eFL.aOX() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eFL.aOX().getId());
                        }
                        sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(d.h.tag_should_delete_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFL.aPi()));
                        sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_should_delete_visible, false);
                    }
                    a(gVar, postData, postData.bso() != 1, tbRichText);
                    b(gVar);
                    a(view, postData);
                    if (this.eFT == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.eFT.bwA();
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
            if (postData.bso() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(gVar, postData, postData.bso() != 1, tbRichText);
            b(gVar);
            a(view, postData);
            if (this.eFT == null) {
            }
        }
    }

    private void b(g gVar) {
        gVar.eGi.setTextViewOnTouchListener(this.aRz);
        gVar.eGi.setTextViewCheckSelection(false);
    }

    private void a(g gVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aVy() == null || g(postData)) {
            gVar.eGE.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aVy(), gVar.eGE, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eFS - (i - this.eFR));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean g(PostData postData) {
        return (this.eFL == null || this.eFL.aOX() == null || !this.eFL.aOX().sn() || this.eFL.aOX().rp() == null || postData.bso() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (g(postData) && view != null && this.eGQ != null) {
            if (this.eFT == null) {
                this.eFT = new com.baidu.tieba.vote.a(this.eGQ);
            }
            this.eFT.a(view, this.eFL);
        } else if (this.eFT != null) {
            this.eFT.setVisibility(8);
        }
    }

    private void c(g gVar) {
        gVar.bEL.setOnClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.eUh);
        gVar.eGc.setOnClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.eUh);
        gVar.eGb.setOnClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.eUh);
        gVar.eGm.setOnLongClickListener(this.avB);
        gVar.eGi.setOnLongClickListener(this.avB);
        gVar.eGm.setOnTouchListener(this.aRz);
        gVar.eGi.setOnTouchListener(this.aRz);
        gVar.eGi.setOnImageClickListener(this.aRy);
        gVar.eGi.setOnEmotionClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.eUj);
        gVar.cHC.setOnClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.czD);
        gVar.aoS.setOnClickListener(((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF.eUi);
        gVar.eGE.setOnClickListener(this.cUc);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eFL = fVar;
    }

    public void pf(int i) {
        this.eFI = i;
    }

    public void iS(boolean z) {
        this.eFJ = z;
    }

    public void iT(boolean z) {
        this.eFK = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void A(View.OnClickListener onClickListener) {
        this.eFO = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cUc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRy = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avB = onLongClickListener;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eGQ.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<be> list) {
        if (textView != null) {
            be beVar = (be) com.baidu.tbadk.core.util.v.c(list, i);
            if (beVar == null) {
                textView.setVisibility(8);
                return;
            }
            final String forumName = beVar.getForumName();
            final String forumId = beVar.getForumId();
            textView.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.pd(forumName);
                    TiebaStatic.log(new ak("c12041").ad("fid", forumId));
                }
            });
        }
    }

    public void pd(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eGQ.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
