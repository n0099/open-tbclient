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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.IconData;
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
public class g extends l<PostData, h> implements View.OnClickListener {
    private TbRichTextView.e aRM;
    private com.baidu.tieba.pb.a.c aRN;
    private View.OnLongClickListener awn;
    private View.OnClickListener cLO;
    private ArrayList<IconData> dpA;
    private boolean eFA;
    private final boolean eFB;
    private int eFC;
    private int eFD;
    private com.baidu.tieba.vote.a eFE;
    private int eFt;
    private boolean eFu;
    private boolean eFv;
    private com.baidu.tieba.pb.data.f eFw;
    private com.baidu.tieba.pb.pb.sub.d eFx;
    private ArrayList<IconData> eFy;
    private View.OnClickListener eFz;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eFt = 0;
        this.eFu = true;
        this.eFv = true;
        this.eFw = null;
        this.mHostId = null;
        this.eFx = null;
        this.eFy = null;
        this.dpA = null;
        this.eFz = null;
        this.cLO = null;
        this.aRM = null;
        this.aRN = null;
        this.awn = null;
        this.eFA = false;
        this.eFB = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ai.c(hVar.eGd, d.e.common_color_10005, 1);
                ai.c(hVar.eGf, d.e.cp_link_tip_c, 3);
                ai.c(hVar.bGr, d.e.cp_cont_f, 1);
                ai.c((View) hVar.eFO, d.e.cp_cont_i, 1);
                ai.c((View) hVar.eFP, d.e.cp_cont_i, 1);
                ai.c(hVar.eFQ, d.e.cp_cont_d, 1);
                ai.c(hVar.eFR, d.e.cp_cont_d, 1);
                ai.k(hVar.eFU, d.e.cp_bg_line_e);
                ai.k(hVar.eFV, d.e.cp_bg_line_e);
                ai.c(hVar.eFV, d.e.cp_bg_line_b);
                ai.k(hVar.eFY, d.e.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eFC = getDimensionPixelSize(d.f.ds30);
        this.eFD = k.ag(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.eFu, this.eFt, false);
        a(hVar);
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, h hVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, hVar);
        a(hVar);
        c(hVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sD();
            a(hVar, postData2, view, i);
        }
        if (!this.eFA && this.eFB && hVar != null && hVar.eFT.Jb() && (listView = ((PbActivity) this.eGA.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eFA = true;
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
    private void a(h hVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (hVar != null && postData != null) {
            ai.k(hVar.eGb, d.e.cp_bg_line_b);
            hVar.eFN.setTag(null);
            hVar.eFN.setUserId(null);
            hVar.bGr.setText((CharSequence) null);
            hVar.eFP.setVisibility(8);
            hVar.eFY.setVisibility(0);
            hVar.eFS.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.eFX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.eFX.setTag(sparseArray);
                hVar.eFT.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(hVar.eFT, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eFu || g(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eFT.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eFT.setLayoutParams(layoutParams);
                hVar.eFT.setPadding(0, 0, 0, 0);
                hVar.eFT.ha(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                hVar.eFT.ha(postData.getBimg_url());
                if (postData.bsy() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eFT.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    hVar.eFT.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eFT.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    hVar.eFT.setLayoutParams(layoutParams3);
                }
            }
            hVar.eFR.setText(al.r(postData.getTime()));
            hVar.eFW.setVisibility(8);
            if (postData.bsy() == 1) {
                ai.k(hVar.eFJ, d.e.cp_bg_line_d);
                hVar.eFK.setVisibility(8);
                hVar.eGb.setVisibility(8);
                hVar.eFX.setVisibility(8);
                hVar.eFR.setVisibility(8);
                hVar.eFW.setVisibility(0);
                hVar.eFZ.setVisibility(8);
                hVar.eGa.setVisibility(8);
                hVar.eGq.setVisibility(8);
                hVar.eGk.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                hVar.eFW.a(postData.bsF(), str, str2, j, com.baidu.adp.lib.g.b.d(this.eFw.aPj().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                hVar.eFW.onChangeSkinType();
                if (this.eFv) {
                    PraiseData rv = this.eFw.aPj().rv();
                    if (rv != null && rv.getUser() != null && rv.getUser().size() > 0) {
                        hVar.eFU.setVisibility(0);
                        hVar.eFV.setVisibility(0);
                        hVar.eFU.setIsFromPb(true);
                        hVar.eFU.a(rv, this.eFw.aPj().getId(), rv.getPostId(), true);
                        hVar.eFU.dt(this.mSkinType);
                    } else {
                        hVar.eFU.setVisibility(8);
                        hVar.eFV.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.b.aq(hVar.eFU);
                    com.baidu.tieba.graffiti.b.aq(hVar.eFV);
                } else {
                    hVar.eFU.setVisibility(8);
                    hVar.eFV.setVisibility(8);
                }
                a(hVar.eFT, getDimensionPixelSize(d.f.ds30));
                if (!this.eGA.aQX()) {
                    if (this.eFw.aPE() != null && this.eFw.aPE().size() <= 4) {
                        hVar.eGv.setVisibility(0);
                        List<be> aPE = this.eFw.aPE();
                        for (int i2 = 0; i2 < aPE.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eGr, aPE);
                            } else if (i2 == 1) {
                                a(i2, hVar.eGs, aPE);
                            } else if (i2 == 2) {
                                a(i2, hVar.eGt, aPE);
                            } else if (i2 == 3) {
                                a(i2, hVar.eGu, aPE);
                            }
                        }
                    }
                } else {
                    hVar.eGv.setVisibility(8);
                }
            } else {
                hVar.eGv.setVisibility(8);
                hVar.eGb.setVisibility(0);
                ai.k(hVar.eFJ, d.e.cp_bg_line_e);
                hVar.eFK.setVisibility(0);
                com.baidu.tbadk.data.h bsB = postData.bsB();
                hVar.eGk.setVisibility(8);
                if (bsB != null && !TextUtils.isEmpty(bsB.getName()) && !TextUtils.isEmpty(bsB.getName().trim())) {
                    final String name = bsB.getName();
                    final String lat = bsB.getLat();
                    final String lng = bsB.getLng();
                    hVar.eGo.setText(bsB.getName());
                    ai.c(hVar.eGo, d.e.cp_cont_c, 1);
                    hVar.eGo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!i.hr()) {
                                    g.this.eGA.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.T(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eGo.setVisibility(8);
                }
                hVar.eFU.setVisibility(8);
                hVar.eFV.setVisibility(8);
                hVar.eFX.setVisibility(0);
                hVar.eFR.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsy()));
                hVar.eFQ.setVisibility(0);
                hVar.eFQ.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                hVar.eFS.setVisibility(0);
                ai.i(hVar.eFS, d.e.cp_link_tip_a);
            } else {
                hVar.eFS.setVisibility(8);
            }
            ai.j(hVar.eFL, d.g.bg_floor_new_middle);
            hVar.eFT.setVideoImageId(d.g.pic_video);
            hVar.eFT.setTextColor(ai.getColor(d.e.common_color_10039));
            hVar.eFT.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsy()));
            if (postData.bsC() > 0) {
                if (this.eFx == null) {
                    this.eFx = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eFx.setIsFromCDN(this.mIsFromCDN);
                    this.eFx.I(this.eFz);
                    boolean z6 = false;
                    String userId2 = this.eFw.aPj().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.eFx.C(this.eFw.aPu(), z6);
                    this.eFx.U(this.eFw.aPj());
                }
                this.eFx.pI(postData.getId());
                hVar.eFY.setVisibility(0);
                hVar.eFY.a(postData, view);
                hVar.eFY.setChildOnClickListener(this.cLO);
                hVar.eFY.setChildOnLongClickListener(this.awn);
                hVar.eFY.setChildOnTouchListener(this.aRN);
                hVar.eFY.setSubPbAdapter(this.eFx);
                hVar.eFY.setVisibility(0);
                hVar.eGa.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds24));
                hVar.eGq.setVisibility(0);
            } else {
                hVar.eGa.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds40));
                hVar.eFY.setVisibility(8);
                hVar.eGq.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = v.gT(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gT = v.gT(name_show);
                if (i3 > 0) {
                    if (gT > 12) {
                        name_show = v.d(name_show, 0, 14) + "...";
                    }
                } else if (gT > 14) {
                    name_show = v.d(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bGr.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    hVar.bGr.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    ai.c(hVar.bGr, d.e.cp_cont_h, 1);
                } else {
                    ai.c(hVar.bGr, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eFO.setVisibility(0);
                    ai.c(hVar.eFO, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eFO.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eFO.setOnClickListener(null);
                } else {
                    hVar.eFO.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ai.c(hVar.eFP, d.g.pb_manager);
                        hVar.eFO.setVisibility(8);
                        hVar.eFP.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        ai.c(hVar.eFP, d.g.pb_assist);
                        hVar.eFO.setVisibility(8);
                        hVar.eFP.setVisibility(0);
                    }
                }
                int gT2 = v.gT(postData.getAuthor().getName_show());
                if (gT2 >= 14 && hVar.eFO.getVisibility() == 0 && hVar.eFS.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gT2 < 12 || hVar.eFO.getVisibility() != 0 || hVar.eFS.getVisibility() != 0) ? i4 : i4 - 1;
                this.eFy = postData.getAuthor().getIconInfo();
                this.dpA = postData.getAuthor().getTShowInfoNew();
                if (hVar.czs != null) {
                    hVar.czs.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    hVar.czs.setOnClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.cst);
                    hVar.czs.a(this.eFy, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (hVar.apm != null) {
                    hVar.apm.setOnClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.eTM);
                    hVar.apm.a(this.dpA, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pV())) {
                hVar.eFN.setVisibility(4);
                hVar.eFM.setVisibility(0);
                hVar.eFM.et(postData.getAuthor().getPendantData().pV());
                hVar.eFM.getHeadView().c(portrait, 28, false);
                hVar.eFM.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                hVar.eFM.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                hVar.eFN.setVisibility(0);
                hVar.eFM.setVisibility(8);
                hVar.eFN.setUserId(postData.getAuthor().getUserId());
                hVar.eFN.setUserName(postData.getAuthor().getUserName());
                hVar.eFN.setImageDrawable(null);
                hVar.eFN.c(portrait, 28, false);
            }
            hVar.bGr.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            hVar.bGr.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            hVar.eFT.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            if (this.eFu) {
                hVar.eFT.setDefaultImageId(d.g.transparent_bg);
            } else {
                hVar.eFT.setDefaultImageId(d.g.icon_click);
            }
            hVar.eFT.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aAP();
            }
            if (this.eFA || !this.eFB) {
                hVar.eFT.a(tbRichText, false);
            } else {
                hVar.eFT.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eFw.aPu() != 0) {
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
            if (this.eFw != null && this.eFw.aPj() != null && this.eFw.aPj().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eFw.aPj().getAuthor().getUserId();
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
                        if (hVar.eGf != null) {
                            hVar.eGf.setVisibility(0);
                            hVar.eGf.setText(d.l.manage);
                            hVar.eGf.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (hVar.eGf != null) {
                            hVar.eGf.setVisibility(0);
                            hVar.eGf.setText(d.l.delete);
                            hVar.eGf.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (hVar.eGf != null) {
                        hVar.eGf.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.bsy() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFw.aPu()));
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
                        if (this.eFw.aPj() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eFw.aPj().getId());
                        }
                        sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(d.h.tag_should_delete_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFw.aPu()));
                        sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_should_delete_visible, false);
                    }
                    a(hVar, postData, postData.bsy() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eFE == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.eFE.bwJ();
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
            if (postData.bsy() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(hVar, postData, postData.bsy() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.eFE == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eFT.setTextViewOnTouchListener(this.aRN);
        hVar.eFT.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aVI() == null || g(postData)) {
            hVar.eGp.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aVI(), hVar.eGp, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eFD - (i - this.eFC));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean g(PostData postData) {
        return (this.eFw == null || this.eFw.aPj() == null || !this.eFw.aPj().sr() || this.eFw.aPj().rt() == null || postData.bsy() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (g(postData) && view != null && this.eGA != null) {
            if (this.eFE == null) {
                this.eFE = new com.baidu.tieba.vote.a(this.eGA);
            }
            this.eFE.a(view, this.eFw);
        } else if (this.eFE != null) {
            this.eFE.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bGr.setOnClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.eTL);
        hVar.eFN.setOnClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.eTL);
        hVar.eFM.setOnClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.eTL);
        hVar.eFX.setOnLongClickListener(this.awn);
        hVar.eFT.setOnLongClickListener(this.awn);
        hVar.eFX.setOnTouchListener(this.aRN);
        hVar.eFT.setOnTouchListener(this.aRN);
        hVar.eFT.setOnImageClickListener(this.aRM);
        hVar.eFT.setOnEmotionClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.eTN);
        hVar.czs.setOnClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.cst);
        hVar.apm.setOnClickListener(((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq.eTM);
        hVar.eGp.setOnClickListener(this.cLO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eFw = fVar;
    }

    public void oO(int i) {
        this.eFt = i;
    }

    public void iP(boolean z) {
        this.eFu = z;
    }

    public void iQ(boolean z) {
        this.eFv = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eFz = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cLO = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRM = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awn = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eGA.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<be> list) {
        if (textView != null) {
            be beVar = (be) u.c(list, i);
            if (beVar == null) {
                textView.setVisibility(8);
                return;
            }
            final String forumName = beVar.getForumName();
            final String forumId = beVar.getForumId();
            textView.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.pi(forumName);
                    TiebaStatic.log(new aj("c12041").aa("fid", forumId));
                }
            });
        }
    }

    public void pi(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eGA.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
