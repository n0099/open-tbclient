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
    private TbRichTextView.e aRv;
    private com.baidu.tieba.pb.a.c aRw;
    private View.OnLongClickListener avy;
    private View.OnClickListener cUW;
    private ArrayList<IconData> dyW;
    private int eGC;
    private boolean eGD;
    private boolean eGE;
    private com.baidu.tieba.pb.data.f eGF;
    private com.baidu.tieba.pb.pb.sub.d eGG;
    private ArrayList<IconData> eGH;
    private View.OnClickListener eGI;
    private boolean eGJ;
    private final boolean eGK;
    private int eGL;
    private int eGM;
    private com.baidu.tieba.vote.a eGN;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eGC = 0;
        this.eGD = true;
        this.eGE = true;
        this.eGF = null;
        this.mHostId = null;
        this.eGG = null;
        this.eGH = null;
        this.dyW = null;
        this.eGI = null;
        this.cUW = null;
        this.aRv = null;
        this.aRw = null;
        this.avy = null;
        this.eGJ = false;
        this.eGK = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(g gVar) {
        if (gVar != null) {
            if (gVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(gVar.eHm, d.e.common_color_10005, 1);
                aj.c(gVar.eHo, d.e.cp_link_tip_c, 3);
                aj.c(gVar.bFC, d.e.cp_cont_f, 1);
                aj.c(gVar.eGX, d.e.cp_cont_i, 1);
                aj.c(gVar.eGY, d.e.cp_cont_i, 1);
                aj.c(gVar.eGZ, d.e.cp_cont_d, 1);
                aj.c(gVar.eHa, d.e.cp_cont_d, 1);
                aj.k(gVar.eHd, d.e.cp_bg_line_e);
                aj.k(gVar.eHe, d.e.cp_bg_line_e);
                aj.c(gVar.eHe, d.e.cp_bg_line_b);
                aj.k(gVar.eHh, d.e.cp_bg_line_c);
            }
            gVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eGL = getDimensionPixelSize(d.f.ds30);
        this.eGM = k.ae(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public g onCreateViewHolder(ViewGroup viewGroup) {
        g gVar = new g(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.eGD, this.eGC, false);
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
        if (!this.eGJ && this.eGK && gVar != null && gVar.eHc.Jj() && (listView = ((PbActivity) this.eHK.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eGJ = true;
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
            aj.k(gVar.eHk, d.e.cp_bg_line_b);
            gVar.eGW.setTag(null);
            gVar.eGW.setUserId(null);
            gVar.bFC.setText((CharSequence) null);
            gVar.eGY.setVisibility(8);
            gVar.eHh.setVisibility(0);
            gVar.eHb.setVisibility(8);
            SparseArray sparseArray = (SparseArray) gVar.eHg.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                gVar.eHg.setTag(sparseArray);
                gVar.eHc.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(gVar.eHc, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eGD || g(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.eHc.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                gVar.eHc.setLayoutParams(layoutParams);
                gVar.eHc.setPadding(0, 0, 0, 0);
                gVar.eHc.gZ(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                gVar.eHc.gZ(postData.getBimg_url());
                if (postData.bsz() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.eHc.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    gVar.eHc.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) gVar.eHc.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    gVar.eHc.setLayoutParams(layoutParams3);
                }
            }
            gVar.eHa.setText(am.r(postData.getTime()));
            gVar.eHf.setVisibility(8);
            if (postData.bsz() == 1) {
                aj.k(gVar.eGS, d.e.cp_bg_line_d);
                gVar.eGT.setVisibility(8);
                gVar.eHk.setVisibility(8);
                gVar.eHg.setVisibility(8);
                gVar.eHa.setVisibility(8);
                gVar.eHf.setVisibility(0);
                gVar.eHi.setVisibility(8);
                gVar.eHj.setVisibility(8);
                gVar.eHz.setVisibility(8);
                gVar.eHt.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                gVar.eHf.a(postData.bsG(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eGF.aPi().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                gVar.eHf.onChangeSkinType();
                if (this.eGE) {
                    PraiseData rr = this.eGF.aPi().rr();
                    if (rr != null && rr.getUser() != null && rr.getUser().size() > 0) {
                        gVar.eHd.setVisibility(0);
                        gVar.eHe.setVisibility(0);
                        gVar.eHd.setIsFromPb(true);
                        gVar.eHd.a(rr, this.eGF.aPi().getId(), rr.getPostId(), true);
                        gVar.eHd.du(this.mSkinType);
                    } else {
                        gVar.eHd.setVisibility(8);
                        gVar.eHe.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.b.az(gVar.eHd);
                    com.baidu.tieba.graffiti.b.az(gVar.eHe);
                } else {
                    gVar.eHd.setVisibility(8);
                    gVar.eHe.setVisibility(8);
                }
                a(gVar.eHc, getDimensionPixelSize(d.f.ds30));
                if (!this.eHK.aQY()) {
                    if (this.eGF.aPC() != null && this.eGF.aPC().size() <= 4) {
                        gVar.eHE.setVisibility(0);
                        List<be> aPC = this.eGF.aPC();
                        for (int i2 = 0; i2 < aPC.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, gVar.eHA, aPC);
                            } else if (i2 == 1) {
                                a(i2, gVar.eHB, aPC);
                            } else if (i2 == 2) {
                                a(i2, gVar.eHC, aPC);
                            } else if (i2 == 3) {
                                a(i2, gVar.eHD, aPC);
                            }
                        }
                    }
                } else {
                    gVar.eHE.setVisibility(8);
                }
            } else {
                gVar.eHE.setVisibility(8);
                gVar.eHk.setVisibility(0);
                aj.k(gVar.eGS, d.e.cp_bg_line_e);
                gVar.eGT.setVisibility(0);
                h bsC = postData.bsC();
                gVar.eHt.setVisibility(8);
                if (bsC != null && !TextUtils.isEmpty(bsC.getName()) && !TextUtils.isEmpty(bsC.getName().trim())) {
                    final String name = bsC.getName();
                    final String lat = bsC.getLat();
                    final String lng = bsC.getLng();
                    gVar.eHx.setText(bsC.getName());
                    aj.c(gVar.eHx, d.e.cp_cont_c, 1);
                    gVar.eHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.f.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!i.hi()) {
                                    f.this.eHK.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.T(f.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, f.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    gVar.eHx.setVisibility(8);
                }
                gVar.eHd.setVisibility(8);
                gVar.eHe.setVisibility(8);
                gVar.eHg.setVisibility(0);
                gVar.eHa.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsz()));
                gVar.eGZ.setVisibility(0);
                gVar.eGZ.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                gVar.eHb.setVisibility(0);
                aj.i(gVar.eHb, d.e.cp_link_tip_a);
            } else {
                gVar.eHb.setVisibility(8);
            }
            aj.j(gVar.eGU, d.g.bg_floor_new_middle);
            gVar.eHc.setVideoImageId(d.g.pic_video);
            gVar.eHc.setTextColor(aj.getColor(d.e.common_color_10039));
            gVar.eHc.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsz()));
            if (postData.bsD() > 0) {
                if (this.eGG == null) {
                    this.eGG = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eGG.setIsFromCDN(this.mIsFromCDN);
                    this.eGG.C(this.eGI);
                    boolean z6 = false;
                    String userId2 = this.eGF.aPi().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.eGG.z(this.eGF.aPt(), z6);
                    this.eGG.Z(this.eGF.aPi());
                }
                this.eGG.pD(postData.getId());
                gVar.eHh.setVisibility(0);
                gVar.eHh.a(postData, view);
                gVar.eHh.setChildOnClickListener(this.cUW);
                gVar.eHh.setChildOnLongClickListener(this.avy);
                gVar.eHh.setChildOnTouchListener(this.aRw);
                gVar.eHh.setSubPbAdapter(this.eGG);
                gVar.eHh.setVisibility(0);
                gVar.eHj.setPadding(0, 0, 0, k.f(this.mContext, d.f.ds24));
                gVar.eHz.setVisibility(0);
            } else {
                gVar.eHj.setPadding(0, 0, 0, k.f(this.mContext, d.f.ds40));
                gVar.eHh.setVisibility(8);
                gVar.eHz.setVisibility(8);
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
                    gVar.bFC.setText(ah(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    gVar.bFC.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(gVar.bFC, d.e.cp_cont_h, 1);
                } else {
                    aj.c(gVar.bFC, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    gVar.eGX.setVisibility(0);
                    aj.c(gVar.eGX, BitmapHelper.getGradeResourceIdNew(level_id));
                    gVar.eGX.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    gVar.eGX.setOnClickListener(null);
                } else {
                    gVar.eGX.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(gVar.eGY, d.g.pb_manager);
                        gVar.eGX.setVisibility(8);
                        gVar.eGY.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(gVar.eGY, d.g.pb_assist);
                        gVar.eGX.setVisibility(8);
                        gVar.eGY.setVisibility(0);
                    }
                }
                int gS2 = v.gS(postData.getAuthor().getName_show());
                if (gS2 >= 14 && gVar.eGX.getVisibility() == 0 && gVar.eHb.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gS2 < 12 || gVar.eGX.getVisibility() != 0 || gVar.eHb.getVisibility() != 0) ? i4 : i4 - 1;
                this.eGH = postData.getAuthor().getIconInfo();
                this.dyW = postData.getAuthor().getTShowInfoNew();
                if (gVar.cIw != null) {
                    gVar.cIw.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    gVar.cIw.setOnClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.cAv);
                    gVar.cIw.a(this.eGH, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (gVar.aoQ != null) {
                    gVar.aoQ.setOnClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.eVc);
                    gVar.aoQ.a(this.dyW, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pR())) {
                gVar.eGW.setVisibility(4);
                gVar.eGV.setVisibility(0);
                gVar.eGV.eq(postData.getAuthor().getPendantData().pR());
                gVar.eGV.getHeadView().c(portrait, 28, false);
                gVar.eGV.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                gVar.eGV.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                gVar.eGW.setVisibility(0);
                gVar.eGV.setVisibility(8);
                gVar.eGW.setUserId(postData.getAuthor().getUserId());
                gVar.eGW.setUserName(postData.getAuthor().getUserName());
                gVar.eGW.setImageDrawable(null);
                gVar.eGW.c(portrait, 28, false);
            }
            gVar.bFC.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            gVar.bFC.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            gVar.eHc.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            if (this.eGD) {
                gVar.eHc.setDefaultImageId(d.g.transparent_bg);
            } else {
                gVar.eHc.setDefaultImageId(d.g.icon_click);
            }
            gVar.eHc.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aDr();
            }
            if (this.eGJ || !this.eGK) {
                gVar.eHc.a(tbRichText, false);
            } else {
                gVar.eHc.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eGF.aPt() != 0) {
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
            if (this.eGF != null && this.eGF.aPi() != null && this.eGF.aPi().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eGF.aPi().getAuthor().getUserId();
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
                        if (gVar.eHo != null) {
                            gVar.eHo.setVisibility(0);
                            gVar.eHo.setText(d.l.manage);
                            gVar.eHo.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (gVar.eHo != null) {
                            gVar.eHo.setVisibility(0);
                            gVar.eHo.setText(d.l.delete);
                            gVar.eHo.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (gVar.eHo != null) {
                        gVar.eHo.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.bsz() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eGF.aPt()));
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
                        if (this.eGF.aPi() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eGF.aPi().getId());
                        }
                        sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(d.h.tag_should_delete_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eGF.aPt()));
                        sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_should_delete_visible, false);
                    }
                    a(gVar, postData, postData.bsz() != 1, tbRichText);
                    b(gVar);
                    a(view, postData);
                    if (this.eGN == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.eGN.bwL();
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
            if (postData.bsz() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(gVar, postData, postData.bsz() != 1, tbRichText);
            b(gVar);
            a(view, postData);
            if (this.eGN == null) {
            }
        }
    }

    private void b(g gVar) {
        gVar.eHc.setTextViewOnTouchListener(this.aRw);
        gVar.eHc.setTextViewCheckSelection(false);
    }

    private void a(g gVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aVJ() == null || g(postData)) {
            gVar.eHy.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aVJ(), gVar.eHy, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eGM - (i - this.eGL));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean g(PostData postData) {
        return (this.eGF == null || this.eGF.aPi() == null || !this.eGF.aPi().sn() || this.eGF.aPi().rp() == null || postData.bsz() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (g(postData) && view != null && this.eHK != null) {
            if (this.eGN == null) {
                this.eGN = new com.baidu.tieba.vote.a(this.eHK);
            }
            this.eGN.a(view, this.eGF);
        } else if (this.eGN != null) {
            this.eGN.setVisibility(8);
        }
    }

    private void c(g gVar) {
        gVar.bFC.setOnClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.eVb);
        gVar.eGW.setOnClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.eVb);
        gVar.eGV.setOnClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.eVb);
        gVar.eHg.setOnLongClickListener(this.avy);
        gVar.eHc.setOnLongClickListener(this.avy);
        gVar.eHg.setOnTouchListener(this.aRw);
        gVar.eHc.setOnTouchListener(this.aRw);
        gVar.eHc.setOnImageClickListener(this.aRv);
        gVar.eHc.setOnEmotionClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.eVd);
        gVar.cIw.setOnClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.cAv);
        gVar.aoQ.setOnClickListener(((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz.eVc);
        gVar.eHy.setOnClickListener(this.cUW);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eGF = fVar;
    }

    public void ph(int i) {
        this.eGC = i;
    }

    public void iT(boolean z) {
        this.eGD = z;
    }

    public void iU(boolean z) {
        this.eGE = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void A(View.OnClickListener onClickListener) {
        this.eGI = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cUW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRv = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avy = onLongClickListener;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eHK.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
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
                    f.this.pf(forumName);
                    TiebaStatic.log(new ak("c12041").ad("fid", forumId));
                }
            });
        }
    }

    public void pf(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eHK.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
