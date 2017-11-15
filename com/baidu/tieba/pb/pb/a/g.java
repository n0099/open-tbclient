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
    private TbRichTextView.f aSD;
    private com.baidu.tieba.pb.a.c aSE;
    private View.OnLongClickListener auZ;
    private ArrayList<IconData> dDi;
    private int eIi;
    private boolean eIj;
    private boolean eIk;
    private com.baidu.tieba.pb.data.f eIl;
    private com.baidu.tieba.pb.pb.sub.d eIm;
    private ArrayList<IconData> eIn;
    private View.OnClickListener eIo;
    private boolean eIp;
    private final boolean eIq;
    private int eIr;
    private int eIs;
    private com.baidu.tieba.vote.a eIt;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eIi = 0;
        this.eIj = true;
        this.eIk = true;
        this.eIl = null;
        this.mHostId = null;
        this.eIm = null;
        this.eIn = null;
        this.dDi = null;
        this.eIo = null;
        this.mCommonClickListener = null;
        this.aSD = null;
        this.aSE = null;
        this.auZ = null;
        this.eIp = false;
        this.eIq = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(hVar.eIR, d.C0080d.common_color_10005, 1);
                aj.c(hVar.eIT, d.C0080d.cp_link_tip_c, 3);
                aj.c(hVar.bOy, d.C0080d.cp_cont_f, 1);
                aj.c(hVar.eID, d.C0080d.cp_cont_i, 1);
                aj.c(hVar.eIE, d.C0080d.cp_cont_i, 1);
                aj.c(hVar.eIF, d.C0080d.cp_cont_d, 1);
                aj.c(hVar.eIG, d.C0080d.cp_cont_d, 1);
                aj.k(hVar.eIJ, d.C0080d.cp_bg_line_e);
                aj.k(hVar.eIK, d.C0080d.cp_bg_line_e);
                aj.c(hVar.eIK, d.C0080d.cp_bg_line_b);
                aj.k(hVar.eIM, d.C0080d.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eIr = getDimensionPixelSize(d.e.ds30);
        this.eIs = l.ac(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.eIj, this.eIi, false);
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
        if (!this.eIp && this.eIq && hVar != null && hVar.eII.JI() && (listView = ((PbActivity) this.eMB.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eIp = true;
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
            aj.k(hVar.eIP, d.C0080d.cp_bg_line_b);
            hVar.eIC.setTag(null);
            hVar.eIC.setUserId(null);
            hVar.bOy.setText((CharSequence) null);
            hVar.eIE.setVisibility(8);
            hVar.eIM.setVisibility(0);
            hVar.eIH.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.bjo.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.bjo.setTag(sparseArray);
                hVar.eII.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(hVar.eII, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eIj || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eII.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eII.setLayoutParams(layoutParams);
                hVar.eII.setPadding(0, 0, 0, 0);
                hVar.eII.hf(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                hVar.eII.hf(postData.getBimg_url());
                if (postData.buG() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eII.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    hVar.eII.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eII.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    hVar.eII.setLayoutParams(layoutParams3);
                }
            }
            hVar.eIG.setText(am.r(postData.getTime()));
            hVar.eIL.setVisibility(8);
            if (postData.buG() == 1) {
                aj.k(hVar.eIy, d.C0080d.cp_bg_line_d);
                hVar.eIz.setVisibility(8);
                hVar.eIP.setVisibility(8);
                hVar.bjo.setVisibility(8);
                hVar.eIG.setVisibility(8);
                hVar.eIL.setVisibility(0);
                hVar.eIN.setVisibility(8);
                hVar.eIO.setVisibility(8);
                hVar.eJe.setVisibility(8);
                hVar.eIY.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rt() != null) {
                    j = postData.rt().getUserIdLong();
                    str = postData.rt().getUserName();
                    str2 = postData.rt().getName_show();
                }
                hVar.eIL.a(postData.buN(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eIl.aPW().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                hVar.eIL.onChangeSkinType();
                if (this.eIk) {
                    PraiseData ri = this.eIl.aPW().ri();
                    if (ri != null && ri.getUser() != null && ri.getUser().size() > 0) {
                        hVar.eIJ.setVisibility(0);
                        hVar.eIK.setVisibility(0);
                        hVar.eIJ.setIsFromPb(true);
                        hVar.eIJ.a(ri, this.eIl.aPW().getId(), ri.getPostId(), true);
                        hVar.eIJ.dD(this.mSkinType);
                    } else {
                        hVar.eIJ.setVisibility(8);
                        hVar.eIK.setVisibility(8);
                    }
                    hVar.eIJ.setVisibility(8);
                    hVar.eIK.setVisibility(0);
                } else {
                    hVar.eIJ.setVisibility(8);
                    hVar.eIK.setVisibility(8);
                }
                a(hVar.eII, getDimensionPixelSize(d.e.ds30));
                if (!this.eMB.aSd()) {
                    if (this.eIl.aQq() != null && this.eIl.aQq().size() <= 4) {
                        hVar.eJj.setVisibility(0);
                        List<bc> aQq = this.eIl.aQq();
                        for (int i2 = 0; i2 < aQq.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eJf, aQq);
                            } else if (i2 == 1) {
                                a(i2, hVar.eJg, aQq);
                            } else if (i2 == 2) {
                                a(i2, hVar.eJh, aQq);
                            } else if (i2 == 3) {
                                a(i2, hVar.eJi, aQq);
                            }
                        }
                    }
                } else {
                    hVar.eJj.setVisibility(8);
                }
            } else {
                hVar.eJj.setVisibility(8);
                hVar.eIP.setVisibility(0);
                aj.k(hVar.eIy, d.C0080d.cp_bg_line_e);
                hVar.eIz.setVisibility(0);
                i buJ = postData.buJ();
                hVar.eIY.setVisibility(8);
                if (buJ != null && !TextUtils.isEmpty(buJ.getName()) && !TextUtils.isEmpty(buJ.getName().trim())) {
                    final String name = buJ.getName();
                    final String lat = buJ.getLat();
                    final String lng = buJ.getLng();
                    hVar.eJc.setText(buJ.getName());
                    aj.c(hVar.eJc, d.C0080d.cp_cont_c, 1);
                    hVar.eJc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.hh()) {
                                    g.this.eMB.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.O(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eJc.setVisibility(8);
                }
                hVar.eIJ.setVisibility(8);
                hVar.eIK.setVisibility(8);
                hVar.bjo.setVisibility(0);
                hVar.eIG.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.buG()));
                hVar.eIF.setVisibility(0);
                hVar.eIF.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rt().getUserId())) {
                hVar.eIH.setVisibility(0);
                aj.i(hVar.eIH, d.C0080d.cp_link_tip_a);
            } else {
                hVar.eIH.setVisibility(8);
            }
            aj.j(hVar.eIA, d.f.bg_floor_new_middle);
            hVar.eII.getLayoutStrategy().fL(d.f.pic_video);
            hVar.eII.setTextColor(aj.getColor(d.C0080d.common_color_10039));
            hVar.eII.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.buG()));
            if (postData.buK() > 0) {
                if (this.eIm == null) {
                    this.eIm = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eIm.setIsFromCDN(this.mIsFromCDN);
                    this.eIm.F(this.eIo);
                    boolean z8 = false;
                    String userId4 = this.eIl.aPW().rt().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.eIm.z(this.eIl.aQh(), z8);
                    this.eIm.M(this.eIl.aPW());
                }
                this.eIm.pU(postData.getId());
                hVar.eIM.setVisibility(0);
                hVar.eIM.a(postData, view);
                hVar.eIM.setChildOnClickListener(this.mCommonClickListener);
                hVar.eIM.setChildOnLongClickListener(this.auZ);
                hVar.eIM.setChildOnTouchListener(this.aSE);
                hVar.eIM.setSubPbAdapter(this.eIm);
                hVar.eIM.setVisibility(0);
                hVar.eIO.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds24));
                hVar.eJe.setVisibility(0);
            } else {
                hVar.eIO.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds40));
                hVar.eIM.setVisibility(8);
                hVar.eJe.setVisibility(8);
            }
            String portrait = postData.rt().getPortrait();
            if (postData.rt() != null) {
                String name_show = postData.rt().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.rt().getSealPrefix())) {
                    i3 = w.gW(postData.rt().getSealPrefix()) + 2;
                }
                int gW = w.gW(name_show);
                if (i3 > 0) {
                    if (gW > 12) {
                        name_show = w.e(name_show, 0, 14) + "...";
                    }
                } else if (gW > 14) {
                    name_show = w.e(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bOy.setText(ag(postData.rt().getSealPrefix(), name_show));
                } else {
                    hVar.bOy.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.rt().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(hVar.bOy, d.C0080d.cp_cont_h, 1);
                } else {
                    aj.c(hVar.bOy, d.C0080d.cp_cont_f, 1);
                }
                int level_id = postData.rt().getLevel_id();
                int is_bawu = postData.rt().getIs_bawu();
                String bawu_type = postData.rt().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eID.setVisibility(0);
                    aj.c(hVar.eID, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eID.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eID.setOnClickListener(null);
                } else {
                    hVar.eID.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(hVar.eIE, d.f.pb_manager);
                        hVar.eID.setVisibility(8);
                        hVar.eIE.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(hVar.eIE, d.f.pb_assist);
                        hVar.eID.setVisibility(8);
                        hVar.eIE.setVisibility(0);
                    }
                }
                int gW2 = w.gW(postData.rt().getName_show());
                if (gW2 >= 14 && hVar.eID.getVisibility() == 0 && hVar.eIH.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.rt().getSealPrefix()) || gW2 < 12 || hVar.eID.getVisibility() != 0 || hVar.eIH.getVisibility() != 0) ? i4 : i4 - 1;
                this.eIn = postData.rt().getIconInfo();
                this.dDi = postData.rt().getTShowInfoNew();
                if (hVar.cSG != null) {
                    hVar.cSG.setTag(d.g.tag_user_id, postData.rt().getUserId());
                    hVar.cSG.setOnClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.cJk);
                    hVar.cSG.a(this.eIn, i5, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (hVar.aoi != null) {
                    hVar.aoi.setOnClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.eYd);
                    hVar.aoi.a(this.dDi, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.rt() != null && postData.rt().getPendantData() != null && !StringUtils.isNull(postData.rt().getPendantData().pQ())) {
                hVar.eIC.setVisibility(4);
                hVar.eIB.setVisibility(0);
                hVar.eIB.en(postData.rt().getPendantData().pQ());
                hVar.eIB.getHeadView().startLoad(portrait, 28, false);
                hVar.eIB.setTag(d.g.tag_user_id, postData.rt().getUserId());
                hVar.eIB.setTag(d.g.tag_user_name, postData.rt().getUserName());
            } else {
                hVar.eIC.setVisibility(0);
                hVar.eIB.setVisibility(8);
                hVar.eIC.setUserId(postData.rt().getUserId());
                hVar.eIC.setUserName(postData.rt().getUserName());
                hVar.eIC.setImageDrawable(null);
                hVar.eIC.startLoad(portrait, 28, false);
            }
            hVar.bOy.setTag(d.g.tag_user_id, postData.rt().getUserId());
            hVar.bOy.setTag(d.g.tag_user_name, postData.rt().getUserName());
            hVar.eII.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
            if (this.eIj) {
                hVar.eII.getLayoutStrategy().fO(d.f.transparent_bg);
            } else {
                hVar.eII.getLayoutStrategy().fO(d.f.icon_click);
            }
            hVar.eII.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aEx();
            }
            if (this.eIp || !this.eIq) {
                hVar.eII.a(tbRichText, false);
            } else {
                hVar.eII.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.eIl.aQh() != 0) {
                if (this.eIl.aQh() != 1002) {
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
                    if (this.eIl != null && this.eIl.aPW() != null && this.eIl.aPW().rt() != null && postData.rt() != null) {
                        userId2 = this.eIl.aPW().rt().getUserId();
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
                                if (hVar.eIT != null) {
                                    hVar.eIT.setVisibility(0);
                                    hVar.eIT.setText(d.j.manage);
                                    hVar.eIT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (hVar.eIT != null) {
                                    hVar.eIT.setVisibility(0);
                                    hVar.eIT.setText(d.j.delete);
                                    hVar.eIT.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (hVar.eIT != null) {
                                hVar.eIT.setVisibility(8);
                            }
                            int i6 = 1;
                            if (postData.buG() == 1) {
                                i6 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eIl.aQh()));
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
                                if (this.eIl.aPW() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.eIl.aPW().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eIl.aQh()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i6));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(hVar, postData, postData.buG() != 1, tbRichText);
                            b(hVar);
                            a(view, postData);
                            if (this.eIt == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.eIt.bBw();
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
                    if (postData.buG() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.buG() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eIt == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.eIl != null) {
                userId2 = this.eIl.aPW().rt().getUserId();
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
                    if (postData.buG() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(hVar, postData, postData.buG() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eIt == null) {
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
            if (postData.buG() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(hVar, postData, postData.buG() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.eIt == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eII.setTextViewOnTouchListener(this.aSE);
        hVar.eII.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aWX() == null || e(postData)) {
            hVar.eJd.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aWX(), hVar.eJd, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fM(this.eIs - (i - this.eIr));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.eIl == null || this.eIl.aPW() == null || !this.eIl.aPW().sg() || this.eIl.aPW().rf() == null || postData.buG() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.eMB != null) {
            if (this.eIt == null) {
                this.eIt = new com.baidu.tieba.vote.a(this.eMB);
            }
            this.eIt.a(view, this.eIl);
        } else if (this.eIt != null) {
            this.eIt.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bOy.setOnClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.eYc);
        hVar.eIC.setOnClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.eYc);
        hVar.eIB.setOnClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.eYc);
        hVar.bjo.setOnLongClickListener(this.auZ);
        hVar.eII.setOnLongClickListener(this.auZ);
        hVar.bjo.setOnTouchListener(this.aSE);
        hVar.eII.setOnTouchListener(this.aSE);
        hVar.eII.setOnImageClickListener(this.aSD);
        hVar.eII.setOnEmotionClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.eYe);
        hVar.cSG.setOnClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.cJk);
        hVar.aoi.setOnClickListener(((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN.eYd);
        hVar.eJd.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eIl = fVar;
    }

    public void pu(int i) {
        this.eIi = i;
    }

    public void iE(boolean z) {
        this.eIj = z;
    }

    public void iF(boolean z) {
        this.eIk = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eIo = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSD = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auZ = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eMB.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
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
                    g.this.ps(forumName);
                    TiebaStatic.log(new ak("c12041").ac(ImageViewerConfig.FORUM_ID, forumId));
                }
            });
        }
    }

    public void ps(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eMB.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
