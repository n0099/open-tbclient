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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.view.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e extends m<PostData, f> implements View.OnClickListener {
    private TbRichTextView.h bJx;
    private com.baidu.tieba.pb.a.c bJy;
    private View.OnLongClickListener bjN;
    private ArrayList<IconData> eyn;
    private View.OnClickListener fDA;
    private boolean fDB;
    private final boolean fDC;
    private int fDD;
    private int fDE;
    private com.baidu.tieba.vote.a fDF;
    private int fDu;
    private boolean fDv;
    private boolean fDw;
    private com.baidu.tieba.pb.data.f fDx;
    private com.baidu.tieba.pb.pb.sub.d fDy;
    private ArrayList<IconData> fDz;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fDu = 0;
        this.fDv = true;
        this.fDw = true;
        this.fDx = null;
        this.mHostId = null;
        this.fDy = null;
        this.fDz = null;
        this.eyn = null;
        this.fDA = null;
        this.mCommonClickListener = null;
        this.bJx = null;
        this.bJy = null;
        this.bjN = null;
        this.fDB = false;
        this.fDC = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.e(fVar.fEd, d.C0108d.common_color_10005, 1);
                aj.e(fVar.fEf, d.C0108d.cp_link_tip_c, 3);
                aj.e(fVar.cLm, d.C0108d.cp_cont_f, 1);
                aj.e(fVar.fDP, d.C0108d.cp_cont_i, 1);
                aj.e(fVar.fDQ, d.C0108d.cp_cont_i, 1);
                aj.e(fVar.fDR, d.C0108d.cp_cont_d, 1);
                aj.e(fVar.fDS, d.C0108d.cp_cont_d, 1);
                aj.t(fVar.fDV, d.C0108d.cp_bg_line_e);
                aj.t(fVar.fDW, d.C0108d.cp_bg_line_e);
                aj.c(fVar.fDW, d.C0108d.cp_bg_line_b);
                aj.t(fVar.fDY, d.C0108d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.fDD = getDimensionPixelSize(d.e.ds30);
        this.fDE = l.ao(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.fDv, this.fDu, false);
        a(fVar);
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, f fVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, fVar);
        a(fVar);
        c(fVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.zW();
            a(fVar, postData2, view, i);
        }
        if (!this.fDB && this.fDC && fVar != null && fVar.fDU.RD() && (listView = ((PbActivity) this.fHW.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fDB = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x07bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0a18  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0a55  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0a61  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0a6d  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0a79  */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(f fVar, PostData postData, View view, int i) {
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
        if (fVar != null && postData != null) {
            aj.t(fVar.fEb, d.C0108d.cp_bg_line_b);
            fVar.fDO.setTag(null);
            fVar.fDO.setUserId(null);
            fVar.cLm.setText((CharSequence) null);
            fVar.fDQ.setVisibility(8);
            fVar.fDY.setVisibility(0);
            fVar.fDT.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.cdx.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.cdx.setTag(sparseArray);
                fVar.fDU.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.fDU, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fDv || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.fDU.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.fDU.setLayoutParams(layoutParams);
                fVar.fDU.setPadding(0, 0, 0, 0);
                fVar.fDU.hj(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.fDU.hj(postData.getBimg_url());
                if (postData.bCl() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.fDU.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.fDU.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.fDU.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.fDU.setLayoutParams(layoutParams3);
                }
            }
            fVar.fDS.setText(am.z(postData.getTime()));
            fVar.fDX.setVisibility(8);
            if (postData.bCl() == 1) {
                aj.t(fVar.fDK, d.C0108d.cp_bg_line_d);
                fVar.fDL.setVisibility(8);
                fVar.fEb.setVisibility(8);
                fVar.cdx.setVisibility(8);
                fVar.fDS.setVisibility(8);
                fVar.fDX.setVisibility(0);
                fVar.fDZ.setVisibility(8);
                fVar.fEa.setVisibility(8);
                fVar.fEq.setVisibility(8);
                fVar.fEk.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.yX() != null) {
                    j = postData.yX().getUserIdLong();
                    str = postData.yX().getUserName();
                    str2 = postData.yX().getName_show();
                }
                fVar.fDX.a(postData.bCu(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fDx.aYA().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.fDX.onChangeSkinType();
                if (this.fDw) {
                    PraiseData yM = this.fDx.aYA().yM();
                    if (yM != null && yM.getUser() != null && yM.getUser().size() > 0) {
                        fVar.fDV.setVisibility(0);
                        fVar.fDW.setVisibility(0);
                        fVar.fDV.setIsFromPb(true);
                        fVar.fDV.a(yM, this.fDx.aYA().getId(), yM.getPostId(), true);
                        fVar.fDV.gC(this.mSkinType);
                    } else {
                        fVar.fDV.setVisibility(8);
                        fVar.fDW.setVisibility(8);
                    }
                    fVar.fDV.setVisibility(8);
                    fVar.fDW.setVisibility(0);
                } else {
                    fVar.fDV.setVisibility(8);
                    fVar.fDW.setVisibility(8);
                }
                a(fVar.fDU, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.fEb.setVisibility(0);
                aj.t(fVar.fDK, d.C0108d.cp_bg_line_e);
                fVar.fDL.setVisibility(0);
                com.baidu.tbadk.data.f bCp = postData.bCp();
                fVar.fEk.setVisibility(8);
                if (bCp != null && !TextUtils.isEmpty(bCp.getName()) && !TextUtils.isEmpty(bCp.getName().trim())) {
                    final String name = bCp.getName();
                    final String lat = bCp.getLat();
                    final String lng = bCp.getLng();
                    fVar.fEo.setText(bCp.getName());
                    aj.e(fVar.fEo, d.C0108d.cp_cont_c, 1);
                    fVar.fEo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.oI()) {
                                    e.this.fHW.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.R(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.fEo.setVisibility(8);
                }
                fVar.fDV.setVisibility(8);
                fVar.fDW.setVisibility(8);
                fVar.cdx.setVisibility(0);
                fVar.fDS.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bCl()));
                fVar.fDR.setVisibility(0);
                fVar.fDR.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yX().getUserId())) {
                fVar.fDT.setVisibility(0);
                aj.r(fVar.fDT, d.C0108d.cp_link_tip_a);
            } else {
                fVar.fDT.setVisibility(8);
            }
            aj.s(fVar.fDM, d.f.bg_floor_new_middle);
            fVar.fDU.getLayoutStrategy().iR(d.f.pic_video);
            fVar.fDU.setTextColor(aj.getColor(d.C0108d.common_color_10039));
            fVar.fDU.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bCl()));
            if (postData.bCq() > 0) {
                if (this.fDy == null) {
                    this.fDy = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fDy.setIsFromCDN(this.mIsFromCDN);
                    this.fDy.G(this.fDA);
                    boolean z8 = false;
                    String userId4 = this.fDx.aYA().yX().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.fDy.J(this.fDx.aYN(), z8);
                    this.fDy.Q(this.fDx.aYA());
                }
                this.fDy.qs(postData.getId());
                fVar.fDY.setVisibility(0);
                fVar.fDY.a(postData, view);
                fVar.fDY.setChildOnClickListener(this.mCommonClickListener);
                fVar.fDY.setChildOnLongClickListener(this.bjN);
                fVar.fDY.setChildOnTouchListener(this.bJy);
                fVar.fDY.setSubPbAdapter(this.fDy);
                fVar.fDY.setVisibility(0);
                fVar.fEa.setPadding(0, 0, 0, l.s(this.mContext, d.e.ds24));
                fVar.fEq.setVisibility(0);
            } else {
                fVar.fEa.setPadding(0, 0, 0, l.s(this.mContext, d.e.ds40));
                fVar.fDY.setVisibility(8);
                fVar.fEq.setVisibility(8);
            }
            String portrait = postData.yX().getPortrait();
            if (postData.yX() != null) {
                String name_show = postData.yX().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.yX().getSealPrefix())) {
                    i2 = w.ha(postData.yX().getSealPrefix()) + 2;
                }
                int ha = w.ha(name_show);
                if (i2 > 0) {
                    if (ha > 12) {
                        name_show = w.j(name_show, 0, 14) + "...";
                    }
                } else if (ha > 14) {
                    name_show = w.j(name_show, 0, 14) + "...";
                }
                if (i2 > 0) {
                    fVar.cLm.setText(af(postData.yX().getSealPrefix(), name_show));
                } else {
                    fVar.cLm.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.yX().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.e(fVar.cLm, d.C0108d.cp_cont_h, 1);
                } else {
                    aj.e(fVar.cLm, d.C0108d.cp_cont_f, 1);
                }
                int level_id = postData.yX().getLevel_id();
                int is_bawu = postData.yX().getIs_bawu();
                String bawu_type = postData.yX().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.fDP.setVisibility(0);
                    aj.c(fVar.fDP, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.fDP.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.fDP.setOnClickListener(null);
                } else {
                    fVar.fDP.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.fDQ, d.f.pb_manager);
                        fVar.fDP.setVisibility(8);
                        fVar.fDQ.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.fDQ, d.f.pb_assist);
                        fVar.fDP.setVisibility(8);
                        fVar.fDQ.setVisibility(0);
                    }
                }
                int ha2 = w.ha(postData.yX().getName_show());
                if (ha2 >= 14 && fVar.fDP.getVisibility() == 0 && fVar.fDT.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.yX().getSealPrefix()) || ha2 < 12 || fVar.fDP.getVisibility() != 0 || fVar.fDT.getVisibility() != 0) ? i3 : i3 - 1;
                this.fDz = postData.yX().getIconInfo();
                this.eyn = postData.yX().getTShowInfoNew();
                if (fVar.dPi != null) {
                    fVar.dPi.setTag(d.g.tag_user_id, postData.yX().getUserId());
                    fVar.dPi.setOnClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fST);
                    fVar.dPi.a(this.fDz, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.bcz != null) {
                    fVar.bcz.setOnClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fSU);
                    fVar.bcz.a(this.eyn, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.yX() != null && postData.yX().getPendantData() != null && !StringUtils.isNull(postData.yX().getPendantData().xu())) {
                fVar.fDO.setVisibility(4);
                fVar.fDN.setVisibility(0);
                fVar.fDN.ez(postData.yX().getPendantData().xu());
                fVar.fDN.getHeadView().startLoad(portrait, 28, false);
                fVar.fDN.setTag(d.g.tag_user_id, postData.yX().getUserId());
                fVar.fDN.setTag(d.g.tag_user_name, postData.yX().getUserName());
            } else {
                fVar.fDO.setVisibility(0);
                fVar.fDN.setVisibility(8);
                fVar.fDO.setUserId(postData.yX().getUserId());
                fVar.fDO.setUserName(postData.yX().getUserName());
                fVar.fDO.setImageDrawable(null);
                fVar.fDO.startLoad(portrait, 28, false);
            }
            fVar.cLm.setTag(d.g.tag_user_id, postData.yX().getUserId());
            fVar.cLm.setTag(d.g.tag_user_name, postData.yX().getUserName());
            fVar.fDU.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
            if (this.fDv) {
                fVar.fDU.getLayoutStrategy().iU(d.f.transparent_bg);
            } else {
                fVar.fDU.getLayoutStrategy().iU(d.f.icon_click);
            }
            fVar.fDU.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bCo();
            }
            if (this.fDB || !this.fDC) {
                fVar.fDU.a(tbRichText, false);
            } else {
                fVar.fDU.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.fDx.aYN() != 0) {
                if (this.fDx.aYN() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.yX().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.fDx != null && this.fDx.aYA() != null && this.fDx.aYA().yX() != null && postData.yX() != null) {
                        userId2 = this.fDx.aYA().yX().getUserId();
                        userId3 = postData.yX().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.yX().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (fVar.fEf != null) {
                                    fVar.fEf.setVisibility(0);
                                    fVar.fEf.setText(d.j.manage);
                                    fVar.fEf.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.fEf != null) {
                                    fVar.fEf.setVisibility(0);
                                    fVar.fEf.setText(d.j.delete);
                                    fVar.fEf.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.fEf != null) {
                                fVar.fEf.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bCl() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fDx.aYN()));
                                sparseArray2.put(d.g.tag_forbid_user_name, postData.yX().getUserName());
                            } else {
                                sparseArray2.put(d.g.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.g.tag_user_mute_visible, true);
                                sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.yX() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.yX().getUserId());
                                    sparseArray2.put(d.g.tag_user_mute_mute_username, postData.yX().getUserName());
                                }
                                if (this.fDx.aYA() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.fDx.aYA().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fDx.aYN()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bCl() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.fDF == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.fDF.bKx();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.yX().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i52 = 1;
                    if (postData.bCl() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bCl() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fDF == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.fDx != null) {
                userId2 = this.fDx.aYA().yX().getUserId();
                userId3 = postData.yX().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.yX().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i522 = 1;
                    if (postData.bCl() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bCl() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fDF == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.yX().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i5222 = 1;
            if (postData.bCl() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bCl() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.fDF == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.fDU.setTextViewOnTouchListener(this.bJy);
        fVar.fDU.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.bfu() == null || e(postData)) {
            fVar.fEp.setVisibility(8);
        } else {
            g.a(postData.bfu(), fVar.fEp, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iS(this.fDE - (i - this.fDD));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.fDx == null || this.fDx.aYA() == null || !this.fDx.aYA().zJ() || this.fDx.aYA().yJ() == null || postData.bCl() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.fHW != null) {
            if (this.fDF == null) {
                this.fDF = new com.baidu.tieba.vote.a(this.fHW);
            }
            this.fDF.a(view, this.fDx);
        } else if (this.fDF != null) {
            this.fDF.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.cLm.setOnClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fSS);
        fVar.fDO.setOnClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fSS);
        fVar.fDN.setOnClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fSS);
        fVar.cdx.setOnLongClickListener(this.bjN);
        fVar.fDU.setOnLongClickListener(this.bjN);
        fVar.cdx.setOnTouchListener(this.bJy);
        fVar.fDU.setOnTouchListener(this.bJy);
        fVar.fDU.setOnImageClickListener(this.bJx);
        fVar.fDU.setOnEmotionClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fSV);
        fVar.dPi.setOnClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fST);
        fVar.bcz.setOnClickListener(((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa.fSU);
        fVar.fEp.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fDx = fVar;
    }

    public void sI(int i) {
        this.fDu = i;
    }

    public void jA(boolean z) {
        this.fDv = z;
    }

    public void jB(boolean z) {
        this.fDw = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void D(View.OnClickListener onClickListener) {
        this.fDA = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJx = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjN = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return k.a((Context) this.fHW.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
