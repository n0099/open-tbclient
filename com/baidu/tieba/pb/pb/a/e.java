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
    private TbRichTextView.h bJF;
    private com.baidu.tieba.pb.a.c bJG;
    private View.OnLongClickListener bjX;
    private ArrayList<IconData> ezM;
    private int fEU;
    private boolean fEV;
    private boolean fEW;
    private com.baidu.tieba.pb.data.f fEX;
    private com.baidu.tieba.pb.pb.sub.d fEY;
    private ArrayList<IconData> fEZ;
    private View.OnClickListener fFa;
    private boolean fFb;
    private final boolean fFc;
    private int fFd;
    private int fFe;
    private com.baidu.tieba.vote.a fFf;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fEU = 0;
        this.fEV = true;
        this.fEW = true;
        this.fEX = null;
        this.mHostId = null;
        this.fEY = null;
        this.fEZ = null;
        this.ezM = null;
        this.fFa = null;
        this.mCommonClickListener = null;
        this.bJF = null;
        this.bJG = null;
        this.bjX = null;
        this.fFb = false;
        this.fFc = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.e(fVar.fFD, d.C0107d.common_color_10005, 1);
                aj.e(fVar.fFF, d.C0107d.cp_link_tip_c, 3);
                aj.e(fVar.cPN, d.C0107d.cp_cont_f, 1);
                aj.e(fVar.fFp, d.C0107d.cp_cont_i, 1);
                aj.e(fVar.fFq, d.C0107d.cp_cont_i, 1);
                aj.e(fVar.fFr, d.C0107d.cp_cont_d, 1);
                aj.e(fVar.fFs, d.C0107d.cp_cont_d, 1);
                aj.t(fVar.fFv, d.C0107d.cp_bg_line_e);
                aj.t(fVar.fFw, d.C0107d.cp_bg_line_e);
                aj.c(fVar.fFw, d.C0107d.cp_bg_line_b);
                aj.t(fVar.fFy, d.C0107d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.fFd = getDimensionPixelSize(d.e.ds30);
        this.fFe = l.ao(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.fEV, this.fEU, false);
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
            postData2.zO();
            a(fVar, postData2, view, i);
        }
        if (!this.fFb && this.fFc && fVar != null && fVar.fFu.Rr() && (listView = ((PbActivity) this.fJw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fFb = true;
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
            aj.t(fVar.fFB, d.C0107d.cp_bg_line_b);
            fVar.fFo.setTag(null);
            fVar.fFo.setUserId(null);
            fVar.cPN.setText((CharSequence) null);
            fVar.fFq.setVisibility(8);
            fVar.fFy.setVisibility(0);
            fVar.fFt.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.cdE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.cdE.setTag(sparseArray);
                fVar.fFu.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.fFu, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fEV || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.fFu.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.fFu.setLayoutParams(layoutParams);
                fVar.fFu.setPadding(0, 0, 0, 0);
                fVar.fFu.hk(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.fFu.hk(postData.getBimg_url());
                if (postData.bvH() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.fFu.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.fFu.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.fFu.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.fFu.setLayoutParams(layoutParams3);
                }
            }
            fVar.fFs.setText(am.z(postData.getTime()));
            fVar.fFx.setVisibility(8);
            if (postData.bvH() == 1) {
                aj.t(fVar.fFk, d.C0107d.cp_bg_line_d);
                fVar.fFl.setVisibility(8);
                fVar.fFB.setVisibility(8);
                fVar.cdE.setVisibility(8);
                fVar.fFs.setVisibility(8);
                fVar.fFx.setVisibility(0);
                fVar.fFz.setVisibility(8);
                fVar.fFA.setVisibility(8);
                fVar.fFQ.setVisibility(8);
                fVar.fFK.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.yS() != null) {
                    j = postData.yS().getUserIdLong();
                    str = postData.yS().getUserName();
                    str2 = postData.yS().getName_show();
                }
                fVar.fFx.a(postData.bvQ(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fEX.aYG().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.fFx.onChangeSkinType();
                if (this.fEW) {
                    PraiseData yH = this.fEX.aYG().yH();
                    if (yH != null && yH.getUser() != null && yH.getUser().size() > 0) {
                        fVar.fFv.setVisibility(0);
                        fVar.fFw.setVisibility(0);
                        fVar.fFv.setIsFromPb(true);
                        fVar.fFv.a(yH, this.fEX.aYG().getId(), yH.getPostId(), true);
                        fVar.fFv.gz(this.mSkinType);
                    } else {
                        fVar.fFv.setVisibility(8);
                        fVar.fFw.setVisibility(8);
                    }
                    fVar.fFv.setVisibility(8);
                    fVar.fFw.setVisibility(0);
                } else {
                    fVar.fFv.setVisibility(8);
                    fVar.fFw.setVisibility(8);
                }
                a(fVar.fFu, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.fFB.setVisibility(0);
                aj.t(fVar.fFk, d.C0107d.cp_bg_line_e);
                fVar.fFl.setVisibility(0);
                com.baidu.tbadk.data.f bvL = postData.bvL();
                fVar.fFK.setVisibility(8);
                if (bvL != null && !TextUtils.isEmpty(bvL.getName()) && !TextUtils.isEmpty(bvL.getName().trim())) {
                    final String name = bvL.getName();
                    final String lat = bvL.getLat();
                    final String lng = bvL.getLng();
                    fVar.fFO.setText(bvL.getName());
                    aj.e(fVar.fFO, d.C0107d.cp_cont_c, 1);
                    fVar.fFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.oI()) {
                                    e.this.fJw.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.Q(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.fFO.setVisibility(8);
                }
                fVar.fFv.setVisibility(8);
                fVar.fFw.setVisibility(8);
                fVar.cdE.setVisibility(0);
                fVar.fFs.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bvH()));
                fVar.fFr.setVisibility(0);
                fVar.fFr.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yS().getUserId())) {
                fVar.fFt.setVisibility(0);
                aj.r(fVar.fFt, d.C0107d.cp_link_tip_a);
            } else {
                fVar.fFt.setVisibility(8);
            }
            aj.s(fVar.fFm, d.f.bg_floor_new_middle);
            fVar.fFu.getLayoutStrategy().iN(d.f.pic_video);
            fVar.fFu.setTextColor(aj.getColor(d.C0107d.common_color_10039));
            fVar.fFu.setLinkTextColor(aj.getColor(d.C0107d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bvH()));
            if (postData.bvM() > 0) {
                if (this.fEY == null) {
                    this.fEY = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fEY.setIsFromCDN(this.mIsFromCDN);
                    this.fEY.H(this.fFa);
                    boolean z8 = false;
                    String userId4 = this.fEX.aYG().yS().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.fEY.J(this.fEX.aYS(), z8);
                    this.fEY.Q(this.fEX.aYG());
                }
                this.fEY.qu(postData.getId());
                fVar.fFy.setVisibility(0);
                fVar.fFy.a(postData, view);
                fVar.fFy.setChildOnClickListener(this.mCommonClickListener);
                fVar.fFy.setChildOnLongClickListener(this.bjX);
                fVar.fFy.setChildOnTouchListener(this.bJG);
                fVar.fFy.setSubPbAdapter(this.fEY);
                fVar.fFy.setVisibility(0);
                fVar.fFA.setPadding(0, 0, 0, l.s(this.mContext, d.e.ds24));
                fVar.fFQ.setVisibility(0);
            } else {
                fVar.fFA.setPadding(0, 0, 0, l.s(this.mContext, d.e.ds40));
                fVar.fFy.setVisibility(8);
                fVar.fFQ.setVisibility(8);
            }
            String portrait = postData.yS().getPortrait();
            if (postData.yS() != null) {
                String name_show = postData.yS().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.yS().getSealPrefix())) {
                    i2 = w.hb(postData.yS().getSealPrefix()) + 2;
                }
                int hb = w.hb(name_show);
                if (i2 > 0) {
                    if (hb > 12) {
                        name_show = w.j(name_show, 0, 14) + "...";
                    }
                } else if (hb > 14) {
                    name_show = w.j(name_show, 0, 14) + "...";
                }
                if (i2 > 0) {
                    fVar.cPN.setText(af(postData.yS().getSealPrefix(), name_show));
                } else {
                    fVar.cPN.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.yS().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.e(fVar.cPN, d.C0107d.cp_cont_h, 1);
                } else {
                    aj.e(fVar.cPN, d.C0107d.cp_cont_f, 1);
                }
                int level_id = postData.yS().getLevel_id();
                int is_bawu = postData.yS().getIs_bawu();
                String bawu_type = postData.yS().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.fFp.setVisibility(0);
                    aj.c(fVar.fFp, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.fFp.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.fFp.setOnClickListener(null);
                } else {
                    fVar.fFp.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.fFq, d.f.pb_manager);
                        fVar.fFp.setVisibility(8);
                        fVar.fFq.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.fFq, d.f.pb_assist);
                        fVar.fFp.setVisibility(8);
                        fVar.fFq.setVisibility(0);
                    }
                }
                int hb2 = w.hb(postData.yS().getName_show());
                if (hb2 >= 14 && fVar.fFp.getVisibility() == 0 && fVar.fFt.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.yS().getSealPrefix()) || hb2 < 12 || fVar.fFp.getVisibility() != 0 || fVar.fFt.getVisibility() != 0) ? i3 : i3 - 1;
                this.fEZ = postData.yS().getIconInfo();
                this.ezM = postData.yS().getTShowInfoNew();
                if (fVar.dTW != null) {
                    fVar.dTW.setTag(d.g.tag_user_id, postData.yS().getUserId());
                    fVar.dTW.setOnClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUt);
                    fVar.dTW.a(this.fEZ, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.bcF != null) {
                    fVar.bcF.setOnClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUu);
                    fVar.bcF.a(this.ezM, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.yS() != null && postData.yS().getPendantData() != null && !StringUtils.isNull(postData.yS().getPendantData().xt())) {
                fVar.fFo.setVisibility(4);
                fVar.fFn.setVisibility(0);
                fVar.fFn.ez(postData.yS().getPendantData().xt());
                fVar.fFn.getHeadView().startLoad(portrait, 28, false);
                fVar.fFn.setTag(d.g.tag_user_id, postData.yS().getUserId());
                fVar.fFn.setTag(d.g.tag_user_name, postData.yS().getUserName());
            } else {
                fVar.fFo.setVisibility(0);
                fVar.fFn.setVisibility(8);
                fVar.fFo.setUserId(postData.yS().getUserId());
                fVar.fFo.setUserName(postData.yS().getUserName());
                fVar.fFo.setImageDrawable(null);
                fVar.fFo.startLoad(portrait, 28, false);
            }
            fVar.cPN.setTag(d.g.tag_user_id, postData.yS().getUserId());
            fVar.cPN.setTag(d.g.tag_user_name, postData.yS().getUserName());
            fVar.fFu.setLinkTextColor(aj.getColor(d.C0107d.cp_link_tip_c));
            if (this.fEV) {
                fVar.fFu.getLayoutStrategy().iQ(d.f.transparent_bg);
            } else {
                fVar.fFu.getLayoutStrategy().iQ(d.f.icon_click);
            }
            fVar.fFu.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bvK();
            }
            if (this.fFb || !this.fFc) {
                fVar.fFu.a(tbRichText, false);
            } else {
                fVar.fFu.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.fEX.aYS() != 0) {
                if (this.fEX.aYS() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.yS().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.fEX != null && this.fEX.aYG() != null && this.fEX.aYG().yS() != null && postData.yS() != null) {
                        userId2 = this.fEX.aYG().yS().getUserId();
                        userId3 = postData.yS().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.yS().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (fVar.fFF != null) {
                                    fVar.fFF.setVisibility(0);
                                    fVar.fFF.setText(d.j.manage);
                                    fVar.fFF.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.fFF != null) {
                                    fVar.fFF.setVisibility(0);
                                    fVar.fFF.setText(d.j.delete);
                                    fVar.fFF.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.fFF != null) {
                                fVar.fFF.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bvH() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fEX.aYS()));
                                sparseArray2.put(d.g.tag_forbid_user_name, postData.yS().getUserName());
                            } else {
                                sparseArray2.put(d.g.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.g.tag_user_mute_visible, true);
                                sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.yS() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.yS().getUserId());
                                    sparseArray2.put(d.g.tag_user_mute_mute_username, postData.yS().getUserName());
                                }
                                if (this.fEX.aYG() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.fEX.aYG().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fEX.aYS()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bvH() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.fFf == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.fFf.bDX();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.yS().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i52 = 1;
                    if (postData.bvH() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bvH() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fFf == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.fEX != null) {
                userId2 = this.fEX.aYG().yS().getUserId();
                userId3 = postData.yS().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.yS().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i522 = 1;
                    if (postData.bvH() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bvH() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fFf == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.yS().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i5222 = 1;
            if (postData.bvH() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bvH() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.fFf == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.fFu.setTextViewOnTouchListener(this.bJG);
        fVar.fFu.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.bfv() == null || e(postData)) {
            fVar.fFP.setVisibility(8);
        } else {
            g.a(postData.bfv(), fVar.fFP, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iO(this.fFe - (i - this.fFd));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.fEX == null || this.fEX.aYG() == null || !this.fEX.aYG().zE() || this.fEX.aYG().yE() == null || postData.bvH() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.fJw != null) {
            if (this.fFf == null) {
                this.fFf = new com.baidu.tieba.vote.a(this.fJw);
            }
            this.fFf.a(view, this.fEX);
        } else if (this.fFf != null) {
            this.fFf.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.cPN.setOnClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUs);
        fVar.fFo.setOnClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUs);
        fVar.fFn.setOnClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUs);
        fVar.cdE.setOnLongClickListener(this.bjX);
        fVar.fFu.setOnLongClickListener(this.bjX);
        fVar.cdE.setOnTouchListener(this.bJG);
        fVar.fFu.setOnTouchListener(this.bJG);
        fVar.fFu.setOnImageClickListener(this.bJF);
        fVar.fFu.setOnEmotionClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUv);
        fVar.dTW.setOnClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUt);
        fVar.bcF.setOnClickListener(((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA.fUu);
        fVar.fFP.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fEX = fVar;
    }

    public void sB(int i) {
        this.fEU = i;
    }

    public void jD(boolean z) {
        this.fEV = z;
    }

    public void jE(boolean z) {
        this.fEW = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFa = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJF = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjX = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return k.a((Context) this.fJw.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
