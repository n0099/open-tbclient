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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends k<PostData, h> implements View.OnClickListener {
    private TbRichTextView.f aSw;
    private com.baidu.tieba.pb.a.c aSx;
    private View.OnLongClickListener auG;
    private ArrayList<IconData> dvl;
    private boolean eAa;
    private boolean eAb;
    private com.baidu.tieba.pb.data.f eAc;
    private com.baidu.tieba.pb.pb.sub.d eAd;
    private ArrayList<IconData> eAe;
    private View.OnClickListener eAf;
    private View.OnClickListener eAg;
    private boolean eAh;
    private final boolean eAi;
    private int eAj;
    private int eAk;
    private com.baidu.tieba.vote.a eAl;
    private int ezZ;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ezZ = 0;
        this.eAa = true;
        this.eAb = true;
        this.eAc = null;
        this.mHostId = null;
        this.eAd = null;
        this.eAe = null;
        this.dvl = null;
        this.eAf = null;
        this.eAg = null;
        this.aSw = null;
        this.aSx = null;
        this.auG = null;
        this.eAh = false;
        this.eAi = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(hVar.eAK, d.e.common_color_10005, 1);
                aj.c(hVar.eAM, d.e.cp_link_tip_c, 3);
                aj.c(hVar.bHn, d.e.cp_cont_f, 1);
                aj.c(hVar.eAv, d.e.cp_cont_i, 1);
                aj.c(hVar.eAw, d.e.cp_cont_i, 1);
                aj.c(hVar.eAx, d.e.cp_cont_d, 1);
                aj.c(hVar.eAy, d.e.cp_cont_d, 1);
                aj.k(hVar.eAB, d.e.cp_bg_line_e);
                aj.k(hVar.eAC, d.e.cp_bg_line_e);
                aj.c(hVar.eAC, d.e.cp_bg_line_b);
                aj.k(hVar.eAF, d.e.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eAj = getDimensionPixelSize(d.f.ds30);
        this.eAk = l.ad(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.eAa, this.ezZ, false);
        a(hVar);
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, h hVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, hVar);
        a(hVar);
        c(hVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.st();
            a(hVar, postData2, view, i);
        }
        if (!this.eAh && this.eAi && hVar != null && hVar.eAA.Js() && (listView = ((PbActivity) this.eDC.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eAh = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0895  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x08ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0abd  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0ac9  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0ae1  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(h hVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        String userId2;
        String userId3;
        if (hVar != null && postData != null) {
            aj.k(hVar.eAI, d.e.cp_bg_line_b);
            hVar.eAu.setTag(null);
            hVar.eAu.setUserId(null);
            hVar.bHn.setText((CharSequence) null);
            hVar.eAw.setVisibility(8);
            hVar.eAF.setVisibility(0);
            hVar.eAz.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.eAE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.eAE.setTag(sparseArray);
                hVar.eAA.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(hVar.eAA, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eAa || f(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eAA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eAA.setLayoutParams(layoutParams);
                hVar.eAA.setPadding(0, 0, 0, 0);
                hVar.eAA.gX(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                hVar.eAA.gX(postData.getBimg_url());
                if (postData.bry() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eAA.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    hVar.eAA.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eAA.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    hVar.eAA.setLayoutParams(layoutParams3);
                }
            }
            hVar.eAy.setText(am.q(postData.getTime()));
            hVar.eAD.setVisibility(8);
            if (postData.bry() == 1) {
                aj.k(hVar.eAq, d.e.cp_bg_line_d);
                hVar.eAr.setVisibility(8);
                hVar.eAI.setVisibility(8);
                hVar.eAE.setVisibility(8);
                hVar.eAy.setVisibility(8);
                hVar.eAD.setVisibility(0);
                hVar.eAG.setVisibility(8);
                hVar.eAH.setVisibility(8);
                hVar.eAX.setVisibility(8);
                hVar.eAR.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                hVar.eAD.a(postData.brF(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eAc.aNb().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                hVar.eAD.onChangeSkinType();
                if (this.eAb) {
                    PraiseData rl = this.eAc.aNb().rl();
                    if (rl != null && rl.getUser() != null && rl.getUser().size() > 0) {
                        hVar.eAB.setVisibility(0);
                        hVar.eAC.setVisibility(0);
                        hVar.eAB.setIsFromPb(true);
                        hVar.eAB.a(rl, this.eAc.aNb().getId(), rl.getPostId(), true);
                        hVar.eAB.dE(this.mSkinType);
                    } else {
                        hVar.eAB.setVisibility(8);
                        hVar.eAC.setVisibility(8);
                    }
                    hVar.eAB.setVisibility(8);
                    hVar.eAC.setVisibility(0);
                } else {
                    hVar.eAB.setVisibility(8);
                    hVar.eAC.setVisibility(8);
                }
                a(hVar.eAA, getDimensionPixelSize(d.f.ds30));
                if (!this.eDC.aOT()) {
                    if (this.eAc.aNv() != null && this.eAc.aNv().size() <= 4) {
                        hVar.eBc.setVisibility(0);
                        List<bc> aNv = this.eAc.aNv();
                        for (int i2 = 0; i2 < aNv.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eAY, aNv);
                            } else if (i2 == 1) {
                                a(i2, hVar.eAZ, aNv);
                            } else if (i2 == 2) {
                                a(i2, hVar.eBa, aNv);
                            } else if (i2 == 3) {
                                a(i2, hVar.eBb, aNv);
                            }
                        }
                    }
                } else {
                    hVar.eBc.setVisibility(8);
                }
            } else {
                hVar.eBc.setVisibility(8);
                hVar.eAI.setVisibility(0);
                aj.k(hVar.eAq, d.e.cp_bg_line_e);
                hVar.eAr.setVisibility(0);
                com.baidu.tbadk.data.g brB = postData.brB();
                hVar.eAR.setVisibility(8);
                if (brB != null && !TextUtils.isEmpty(brB.getName()) && !TextUtils.isEmpty(brB.getName().trim())) {
                    final String name = brB.getName();
                    final String lat = brB.getLat();
                    final String lng = brB.getLng();
                    hVar.eAV.setText(brB.getName());
                    aj.c(hVar.eAV, d.e.cp_cont_c, 1);
                    hVar.eAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.hh()) {
                                    g.this.eDC.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.T(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eAV.setVisibility(8);
                }
                hVar.eAB.setVisibility(8);
                hVar.eAC.setVisibility(8);
                hVar.eAE.setVisibility(0);
                hVar.eAy.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bry()));
                hVar.eAx.setVisibility(0);
                hVar.eAx.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                hVar.eAz.setVisibility(0);
                aj.i(hVar.eAz, d.e.cp_link_tip_a);
            } else {
                hVar.eAz.setVisibility(8);
            }
            aj.j(hVar.eAs, d.g.bg_floor_new_middle);
            hVar.eAA.setVideoImageId(d.g.pic_video);
            hVar.eAA.setTextColor(aj.getColor(d.e.common_color_10039));
            hVar.eAA.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bry()));
            if (postData.brC() > 0) {
                if (this.eAd == null) {
                    this.eAd = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eAd.setIsFromCDN(this.mIsFromCDN);
                    this.eAd.E(this.eAf);
                    boolean z8 = false;
                    String userId4 = this.eAc.aNb().getAuthor().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.eAd.x(this.eAc.aNm(), z8);
                    this.eAd.U(this.eAc.aNb());
                }
                this.eAd.pm(postData.getId());
                hVar.eAF.setVisibility(0);
                hVar.eAF.a(postData, view);
                hVar.eAF.setChildOnClickListener(this.eAg);
                hVar.eAF.setChildOnLongClickListener(this.auG);
                hVar.eAF.setChildOnTouchListener(this.aSx);
                hVar.eAF.setSubPbAdapter(this.eAd);
                hVar.eAF.setVisibility(0);
                hVar.eAH.setPadding(0, 0, 0, l.f(this.mContext, d.f.ds24));
                hVar.eAX.setVisibility(0);
            } else {
                hVar.eAH.setPadding(0, 0, 0, l.f(this.mContext, d.f.ds40));
                hVar.eAF.setVisibility(8);
                hVar.eAX.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = u.gP(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gP = u.gP(name_show);
                if (i3 > 0) {
                    if (gP > 12) {
                        name_show = u.e(name_show, 0, 14) + "...";
                    }
                } else if (gP > 14) {
                    name_show = u.e(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bHn.setText(ah(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    hVar.bHn.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(hVar.bHn, d.e.cp_cont_h, 1);
                } else {
                    aj.c(hVar.bHn, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eAv.setVisibility(0);
                    aj.c(hVar.eAv, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eAv.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eAv.setOnClickListener(null);
                } else {
                    hVar.eAv.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(hVar.eAw, d.g.pb_manager);
                        hVar.eAv.setVisibility(8);
                        hVar.eAw.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(hVar.eAw, d.g.pb_assist);
                        hVar.eAv.setVisibility(8);
                        hVar.eAw.setVisibility(0);
                    }
                }
                int gP2 = u.gP(postData.getAuthor().getName_show());
                if (gP2 >= 14 && hVar.eAv.getVisibility() == 0 && hVar.eAz.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gP2 < 12 || hVar.eAv.getVisibility() != 0 || hVar.eAz.getVisibility() != 0) ? i4 : i4 - 1;
                this.eAe = postData.getAuthor().getIconInfo();
                this.dvl = postData.getAuthor().getTShowInfoNew();
                if (hVar.cJm != null) {
                    hVar.cJm.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    hVar.cJm.setOnClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.cBo);
                    hVar.cJm.a(this.eAe, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (hVar.aoa != null) {
                    hVar.aoa.setOnClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.ePe);
                    hVar.aoa.a(this.dvl, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pS())) {
                hVar.eAu.setVisibility(4);
                hVar.eAt.setVisibility(0);
                hVar.eAt.ei(postData.getAuthor().getPendantData().pS());
                hVar.eAt.getHeadView().c(portrait, 28, false);
                hVar.eAt.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                hVar.eAt.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                hVar.eAu.setVisibility(0);
                hVar.eAt.setVisibility(8);
                hVar.eAu.setUserId(postData.getAuthor().getUserId());
                hVar.eAu.setUserName(postData.getAuthor().getUserName());
                hVar.eAu.setImageDrawable(null);
                hVar.eAu.c(portrait, 28, false);
            }
            hVar.bHn.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            hVar.bHn.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            hVar.eAA.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            if (this.eAa) {
                hVar.eAA.setDefaultImageId(d.g.transparent_bg);
            } else {
                hVar.eAA.setDefaultImageId(d.g.icon_click);
            }
            hVar.eAA.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aCd();
            }
            if (this.eAh || !this.eAi) {
                hVar.eAA.a(tbRichText, false);
            } else {
                hVar.eAA.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.eAc.aNm() != 0) {
                if (this.eAc.aNm() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.getAuthor().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.eAc != null && this.eAc.aNb() != null && this.eAc.aNb().getAuthor() != null && postData.getAuthor() != null) {
                        userId2 = this.eAc.aNb().getAuthor().getUserId();
                        userId3 = postData.getAuthor().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.getAuthor().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (hVar.eAM != null) {
                                    hVar.eAM.setVisibility(0);
                                    hVar.eAM.setText(d.l.manage);
                                    hVar.eAM.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (hVar.eAM != null) {
                                    hVar.eAM.setVisibility(0);
                                    hVar.eAM.setText(d.l.delete);
                                    hVar.eAM.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (hVar.eAM != null) {
                                hVar.eAM.setVisibility(8);
                            }
                            int i6 = 1;
                            if (postData.bry() == 1) {
                                i6 = 0;
                            }
                            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.h.tag_should_manage_visible, true);
                                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eAc.aNm()));
                                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                            } else {
                                sparseArray2.put(d.h.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.h.tag_user_mute_visible, true);
                                sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.getAuthor() != null) {
                                    sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                                    sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                                }
                                if (this.eAc.aNb() != null) {
                                    sparseArray2.put(d.h.tag_user_mute_thread_id, this.eAc.aNb().getId());
                                }
                                sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.h.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.h.tag_should_delete_visible, true);
                                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eAc.aNm()));
                                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.h.tag_should_delete_visible, false);
                            }
                            a(hVar, postData, postData.bry() != 1, tbRichText);
                            b(hVar);
                            a(view, postData);
                            if (this.eAl == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.eAl.bya();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.getAuthor().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i62 = 1;
                    if (postData.bry() == 1) {
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.bry() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eAl == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.eAc != null) {
                userId2 = this.eAc.aNb().getAuthor().getUserId();
                userId3 = postData.getAuthor().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.getAuthor().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i622 = 1;
                    if (postData.bry() == 1) {
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.bry() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eAl == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.getAuthor().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i6222 = 1;
            if (postData.bry() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(hVar, postData, postData.bry() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.eAl == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eAA.setTextViewOnTouchListener(this.aSx);
        hVar.eAA.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aTS() == null || f(postData)) {
            hVar.eAW.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aTS(), hVar.eAW, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eAk - (i - this.eAj));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean f(PostData postData) {
        return (this.eAc == null || this.eAc.aNb() == null || !this.eAc.aNb().sh() || this.eAc.aNb().rj() == null || postData.bry() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (f(postData) && view != null && this.eDC != null) {
            if (this.eAl == null) {
                this.eAl = new com.baidu.tieba.vote.a(this.eDC);
            }
            this.eAl.a(view, this.eAc);
        } else if (this.eAl != null) {
            this.eAl.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bHn.setOnClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.ePd);
        hVar.eAu.setOnClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.ePd);
        hVar.eAt.setOnClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.ePd);
        hVar.eAE.setOnLongClickListener(this.auG);
        hVar.eAA.setOnLongClickListener(this.auG);
        hVar.eAE.setOnTouchListener(this.aSx);
        hVar.eAA.setOnTouchListener(this.aSx);
        hVar.eAA.setOnImageClickListener(this.aSw);
        hVar.eAA.setOnEmotionClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.ePf);
        hVar.cJm.setOnClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.cBo);
        hVar.aoa.setOnClickListener(((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT.ePe);
        hVar.eAW.setOnClickListener(this.eAg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eAc = fVar;
    }

    public void pa(int i) {
        this.ezZ = i;
    }

    public void iE(boolean z) {
        this.eAa = z;
    }

    public void iF(boolean z) {
        this.eAb = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void C(View.OnClickListener onClickListener) {
        this.eAf = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eAg = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSw = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auG = onLongClickListener;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eDC.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<bc> list) {
        if (textView != null) {
            bc bcVar = (bc) v.c(list, i);
            if (bcVar == null) {
                textView.setVisibility(8);
                return;
            }
            final String forumName = bcVar.getForumName();
            final String forumId = bcVar.getForumId();
            textView.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.oJ(forumName);
                    TiebaStatic.log(new ak("c12041").ad("fid", forumId));
                }
            });
        }
    }

    public void oJ(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eDC.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
