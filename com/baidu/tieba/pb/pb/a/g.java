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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends m<PostData, h> implements View.OnClickListener {
    private TbRichTextView.f aSv;
    private com.baidu.tieba.pb.a.c aSw;
    private View.OnLongClickListener auR;
    private ArrayList<IconData> dCM;
    private int eHO;
    private boolean eHP;
    private boolean eHQ;
    private com.baidu.tieba.pb.data.f eHR;
    private com.baidu.tieba.pb.pb.sub.d eHS;
    private ArrayList<IconData> eHT;
    private View.OnClickListener eHU;
    private boolean eHV;
    private final boolean eHW;
    private int eHX;
    private int eHY;
    private com.baidu.tieba.vote.a eHZ;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eHO = 0;
        this.eHP = true;
        this.eHQ = true;
        this.eHR = null;
        this.mHostId = null;
        this.eHS = null;
        this.eHT = null;
        this.dCM = null;
        this.eHU = null;
        this.mCommonClickListener = null;
        this.aSv = null;
        this.aSw = null;
        this.auR = null;
        this.eHV = false;
        this.eHW = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(hVar.eIx, d.C0080d.common_color_10005, 1);
                aj.c(hVar.eIz, d.C0080d.cp_link_tip_c, 3);
                aj.c(hVar.bOl, d.C0080d.cp_cont_f, 1);
                aj.c(hVar.eIj, d.C0080d.cp_cont_i, 1);
                aj.c(hVar.eIk, d.C0080d.cp_cont_i, 1);
                aj.c(hVar.eIl, d.C0080d.cp_cont_d, 1);
                aj.c(hVar.eIm, d.C0080d.cp_cont_d, 1);
                aj.k(hVar.eIp, d.C0080d.cp_bg_line_e);
                aj.k(hVar.eIq, d.C0080d.cp_bg_line_e);
                aj.c(hVar.eIq, d.C0080d.cp_bg_line_b);
                aj.k(hVar.eIs, d.C0080d.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eHX = getDimensionPixelSize(d.e.ds30);
        this.eHY = l.ac(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.eHP, this.eHO, false);
        a(hVar);
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
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
        if (!this.eHV && this.eHW && hVar != null && hVar.eIo.Jx() && (listView = ((PbActivity) this.eMh.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eHV = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07e1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0862  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x089d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x08b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0a8c  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0ac9  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0ae1  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0aed  */
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
            aj.k(hVar.eIv, d.C0080d.cp_bg_line_b);
            hVar.eIi.setTag(null);
            hVar.eIi.setUserId(null);
            hVar.bOl.setText((CharSequence) null);
            hVar.eIk.setVisibility(8);
            hVar.eIs.setVisibility(0);
            hVar.eIn.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.bjf.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.bjf.setTag(sparseArray);
                hVar.eIo.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(hVar.eIo, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHP || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eIo.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eIo.setLayoutParams(layoutParams);
                hVar.eIo.setPadding(0, 0, 0, 0);
                hVar.eIo.he(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                hVar.eIo.he(postData.getBimg_url());
                if (postData.buu() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eIo.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    hVar.eIo.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eIo.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    hVar.eIo.setLayoutParams(layoutParams3);
                }
            }
            hVar.eIm.setText(am.r(postData.getTime()));
            hVar.eIr.setVisibility(8);
            if (postData.buu() == 1) {
                aj.k(hVar.eIe, d.C0080d.cp_bg_line_d);
                hVar.eIf.setVisibility(8);
                hVar.eIv.setVisibility(8);
                hVar.bjf.setVisibility(8);
                hVar.eIm.setVisibility(8);
                hVar.eIr.setVisibility(0);
                hVar.eIt.setVisibility(8);
                hVar.eIu.setVisibility(8);
                hVar.eIK.setVisibility(8);
                hVar.eIE.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rt() != null) {
                    j = postData.rt().getUserIdLong();
                    str = postData.rt().getUserName();
                    str2 = postData.rt().getName_show();
                }
                hVar.eIr.a(postData.buB(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eHR.aPO().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                hVar.eIr.onChangeSkinType();
                if (this.eHQ) {
                    PraiseData ri = this.eHR.aPO().ri();
                    if (ri != null && ri.getUser() != null && ri.getUser().size() > 0) {
                        hVar.eIp.setVisibility(0);
                        hVar.eIq.setVisibility(0);
                        hVar.eIp.setIsFromPb(true);
                        hVar.eIp.a(ri, this.eHR.aPO().getId(), ri.getPostId(), true);
                        hVar.eIp.dE(this.mSkinType);
                    } else {
                        hVar.eIp.setVisibility(8);
                        hVar.eIq.setVisibility(8);
                    }
                    hVar.eIp.setVisibility(8);
                    hVar.eIq.setVisibility(0);
                } else {
                    hVar.eIp.setVisibility(8);
                    hVar.eIq.setVisibility(8);
                }
                a(hVar.eIo, getDimensionPixelSize(d.e.ds30));
                if (!this.eMh.aRV()) {
                    if (this.eHR.aQi() != null && this.eHR.aQi().size() <= 4) {
                        hVar.eIP.setVisibility(0);
                        List<bc> aQi = this.eHR.aQi();
                        for (int i2 = 0; i2 < aQi.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eIL, aQi);
                            } else if (i2 == 1) {
                                a(i2, hVar.eIM, aQi);
                            } else if (i2 == 2) {
                                a(i2, hVar.eIN, aQi);
                            } else if (i2 == 3) {
                                a(i2, hVar.eIO, aQi);
                            }
                        }
                    }
                } else {
                    hVar.eIP.setVisibility(8);
                }
            } else {
                hVar.eIP.setVisibility(8);
                hVar.eIv.setVisibility(0);
                aj.k(hVar.eIe, d.C0080d.cp_bg_line_e);
                hVar.eIf.setVisibility(0);
                i bux = postData.bux();
                hVar.eIE.setVisibility(8);
                if (bux != null && !TextUtils.isEmpty(bux.getName()) && !TextUtils.isEmpty(bux.getName().trim())) {
                    final String name = bux.getName();
                    final String lat = bux.getLat();
                    final String lng = bux.getLng();
                    hVar.eII.setText(bux.getName());
                    aj.c(hVar.eII, d.C0080d.cp_cont_c, 1);
                    hVar.eII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.hh()) {
                                    g.this.eMh.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.O(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eII.setVisibility(8);
                }
                hVar.eIp.setVisibility(8);
                hVar.eIq.setVisibility(8);
                hVar.bjf.setVisibility(0);
                hVar.eIm.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.buu()));
                hVar.eIl.setVisibility(0);
                hVar.eIl.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rt().getUserId())) {
                hVar.eIn.setVisibility(0);
                aj.i(hVar.eIn, d.C0080d.cp_link_tip_a);
            } else {
                hVar.eIn.setVisibility(8);
            }
            aj.j(hVar.eIg, d.f.bg_floor_new_middle);
            hVar.eIo.getLayoutStrategy().fM(d.f.pic_video);
            hVar.eIo.setTextColor(aj.getColor(d.C0080d.common_color_10039));
            hVar.eIo.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.buu()));
            if (postData.buy() > 0) {
                if (this.eHS == null) {
                    this.eHS = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHS.setIsFromCDN(this.mIsFromCDN);
                    this.eHS.F(this.eHU);
                    boolean z8 = false;
                    String userId4 = this.eHR.aPO().rt().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.eHS.y(this.eHR.aPZ(), z8);
                    this.eHS.M(this.eHR.aPO());
                }
                this.eHS.pQ(postData.getId());
                hVar.eIs.setVisibility(0);
                hVar.eIs.a(postData, view);
                hVar.eIs.setChildOnClickListener(this.mCommonClickListener);
                hVar.eIs.setChildOnLongClickListener(this.auR);
                hVar.eIs.setChildOnTouchListener(this.aSw);
                hVar.eIs.setSubPbAdapter(this.eHS);
                hVar.eIs.setVisibility(0);
                hVar.eIu.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds24));
                hVar.eIK.setVisibility(0);
            } else {
                hVar.eIu.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds40));
                hVar.eIs.setVisibility(8);
                hVar.eIK.setVisibility(8);
            }
            String portrait = postData.rt().getPortrait();
            if (postData.rt() != null) {
                String name_show = postData.rt().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.rt().getSealPrefix())) {
                    i3 = w.gV(postData.rt().getSealPrefix()) + 2;
                }
                int gV = w.gV(name_show);
                if (i3 > 0) {
                    if (gV > 12) {
                        name_show = w.e(name_show, 0, 14) + "...";
                    }
                } else if (gV > 14) {
                    name_show = w.e(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bOl.setText(ag(postData.rt().getSealPrefix(), name_show));
                } else {
                    hVar.bOl.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.rt().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(hVar.bOl, d.C0080d.cp_cont_h, 1);
                } else {
                    aj.c(hVar.bOl, d.C0080d.cp_cont_f, 1);
                }
                int level_id = postData.rt().getLevel_id();
                int is_bawu = postData.rt().getIs_bawu();
                String bawu_type = postData.rt().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eIj.setVisibility(0);
                    aj.c(hVar.eIj, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eIj.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eIj.setOnClickListener(null);
                } else {
                    hVar.eIj.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(hVar.eIk, d.f.pb_manager);
                        hVar.eIj.setVisibility(8);
                        hVar.eIk.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(hVar.eIk, d.f.pb_assist);
                        hVar.eIj.setVisibility(8);
                        hVar.eIk.setVisibility(0);
                    }
                }
                int gV2 = w.gV(postData.rt().getName_show());
                if (gV2 >= 14 && hVar.eIj.getVisibility() == 0 && hVar.eIn.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.rt().getSealPrefix()) || gV2 < 12 || hVar.eIj.getVisibility() != 0 || hVar.eIn.getVisibility() != 0) ? i4 : i4 - 1;
                this.eHT = postData.rt().getIconInfo();
                this.dCM = postData.rt().getTShowInfoNew();
                if (hVar.cSm != null) {
                    hVar.cSm.setTag(d.g.tag_user_id, postData.rt().getUserId());
                    hVar.cSm.setOnClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.cIR);
                    hVar.cSm.a(this.eHT, i5, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (hVar.aoj != null) {
                    hVar.aoj.setOnClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.eXI);
                    hVar.aoj.a(this.dCM, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.rt() != null && postData.rt().getPendantData() != null && !StringUtils.isNull(postData.rt().getPendantData().pQ())) {
                hVar.eIi.setVisibility(4);
                hVar.eIh.setVisibility(0);
                hVar.eIh.en(postData.rt().getPendantData().pQ());
                hVar.eIh.getHeadView().startLoad(portrait, 28, false);
                hVar.eIh.setTag(d.g.tag_user_id, postData.rt().getUserId());
                hVar.eIh.setTag(d.g.tag_user_name, postData.rt().getUserName());
            } else {
                hVar.eIi.setVisibility(0);
                hVar.eIh.setVisibility(8);
                hVar.eIi.setUserId(postData.rt().getUserId());
                hVar.eIi.setUserName(postData.rt().getUserName());
                hVar.eIi.setImageDrawable(null);
                hVar.eIi.startLoad(portrait, 28, false);
            }
            hVar.bOl.setTag(d.g.tag_user_id, postData.rt().getUserId());
            hVar.bOl.setTag(d.g.tag_user_name, postData.rt().getUserName());
            hVar.eIo.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
            if (this.eHP) {
                hVar.eIo.getLayoutStrategy().fP(d.f.transparent_bg);
            } else {
                hVar.eIo.getLayoutStrategy().fP(d.f.icon_click);
            }
            hVar.eIo.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aEt();
            }
            if (this.eHV || !this.eHW) {
                hVar.eIo.a(tbRichText, false);
            } else {
                hVar.eIo.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.eHR.aPZ() != 0) {
                if (this.eHR.aPZ() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.rt().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.eHR != null && this.eHR.aPO() != null && this.eHR.aPO().rt() != null && postData.rt() != null) {
                        userId2 = this.eHR.aPO().rt().getUserId();
                        userId3 = postData.rt().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.rt().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (hVar.eIz != null) {
                                    hVar.eIz.setVisibility(0);
                                    hVar.eIz.setText(d.j.manage);
                                    hVar.eIz.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (hVar.eIz != null) {
                                    hVar.eIz.setVisibility(0);
                                    hVar.eIz.setText(d.j.delete);
                                    hVar.eIz.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (hVar.eIz != null) {
                                hVar.eIz.setVisibility(8);
                            }
                            int i6 = 1;
                            if (postData.buu() == 1) {
                                i6 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eHR.aPZ()));
                                sparseArray2.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                            } else {
                                sparseArray2.put(d.g.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.g.tag_user_mute_visible, true);
                                sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.rt() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                                    sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                                }
                                if (this.eHR.aPO() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.eHR.aPO().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eHR.aPZ()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i6));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(hVar, postData, postData.buu() != 1, tbRichText);
                            b(hVar);
                            a(view, postData);
                            if (this.eHZ == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.eHZ.bBk();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.rt().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i62 = 1;
                    if (postData.buu() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.buu() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eHZ == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.eHR != null) {
                userId2 = this.eHR.aPO().rt().getUserId();
                userId3 = postData.rt().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.rt().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i622 = 1;
                    if (postData.buu() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.buu() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eHZ == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.rt().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i6222 = 1;
            if (postData.buu() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(hVar, postData, postData.buu() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.eHZ == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eIo.setTextViewOnTouchListener(this.aSw);
        hVar.eIo.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aWP() == null || e(postData)) {
            hVar.eIJ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aWP(), hVar.eIJ, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fN(this.eHY - (i - this.eHX));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.eHR == null || this.eHR.aPO() == null || !this.eHR.aPO().sg() || this.eHR.aPO().rf() == null || postData.buu() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.eMh != null) {
            if (this.eHZ == null) {
                this.eHZ = new com.baidu.tieba.vote.a(this.eMh);
            }
            this.eHZ.a(view, this.eHR);
        } else if (this.eHZ != null) {
            this.eHZ.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bOl.setOnClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.eXH);
        hVar.eIi.setOnClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.eXH);
        hVar.eIh.setOnClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.eXH);
        hVar.bjf.setOnLongClickListener(this.auR);
        hVar.eIo.setOnLongClickListener(this.auR);
        hVar.bjf.setOnTouchListener(this.aSw);
        hVar.eIo.setOnTouchListener(this.aSw);
        hVar.eIo.setOnImageClickListener(this.aSv);
        hVar.eIo.setOnEmotionClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.eXJ);
        hVar.cSm.setOnClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.cIR);
        hVar.aoj.setOnClickListener(((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt.eXI);
        hVar.eIJ.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHR = fVar;
    }

    public void pt(int i) {
        this.eHO = i;
    }

    public void iy(boolean z) {
        this.eHP = z;
    }

    public void iz(boolean z) {
        this.eHQ = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eHU = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSv = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auR = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eMh.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
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
            textView.setText(this.mContext.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.po(forumName);
                    TiebaStatic.log(new ak("c12041").ac(ImageViewerConfig.FORUM_ID, forumId));
                }
            });
        }
    }

    public void po(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eMh.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
