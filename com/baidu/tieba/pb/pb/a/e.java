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
import com.baidu.tbadk.data.i;
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
/* loaded from: classes.dex */
public class e extends m<PostData, f> implements View.OnClickListener {
    private TbRichTextView.g aVG;
    private com.baidu.tieba.pb.a.c aVH;
    private View.OnLongClickListener avF;
    private ArrayList<IconData> dMb;
    private int eQO;
    private boolean eQP;
    private boolean eQQ;
    private com.baidu.tieba.pb.data.f eQR;
    private com.baidu.tieba.pb.pb.sub.d eQS;
    private ArrayList<IconData> eQT;
    private View.OnClickListener eQU;
    private boolean eQV;
    private final boolean eQW;
    private int eQX;
    private int eQY;
    private com.baidu.tieba.vote.a eQZ;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eQO = 0;
        this.eQP = true;
        this.eQQ = true;
        this.eQR = null;
        this.mHostId = null;
        this.eQS = null;
        this.eQT = null;
        this.dMb = null;
        this.eQU = null;
        this.mCommonClickListener = null;
        this.aVG = null;
        this.aVH = null;
        this.avF = null;
        this.eQV = false;
        this.eQW = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(fVar.eRx, d.C0096d.common_color_10005, 1);
                aj.c(fVar.eRz, d.C0096d.cp_link_tip_c, 3);
                aj.c(fVar.bWB, d.C0096d.cp_cont_f, 1);
                aj.c(fVar.eRj, d.C0096d.cp_cont_i, 1);
                aj.c(fVar.eRk, d.C0096d.cp_cont_i, 1);
                aj.c(fVar.eRl, d.C0096d.cp_cont_d, 1);
                aj.c(fVar.eRm, d.C0096d.cp_cont_d, 1);
                aj.k(fVar.eRp, d.C0096d.cp_bg_line_e);
                aj.k(fVar.eRq, d.C0096d.cp_bg_line_e);
                aj.c(fVar.eRq, d.C0096d.cp_bg_line_b);
                aj.k(fVar.eRs, d.C0096d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eQX = getDimensionPixelSize(d.e.ds30);
        this.eQY = l.ac(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.eQP, this.eQO, false);
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
            postData2.su();
            a(fVar, postData2, view, i);
        }
        if (!this.eQV && this.eQW && fVar != null && fVar.eRo.Kg() && (listView = ((PbActivity) this.eVp.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eQV = true;
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
            aj.k(fVar.eRv, d.C0096d.cp_bg_line_b);
            fVar.eRi.setTag(null);
            fVar.eRi.setUserId(null);
            fVar.bWB.setText((CharSequence) null);
            fVar.eRk.setVisibility(8);
            fVar.eRs.setVisibility(0);
            fVar.eRn.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.bpY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.bpY.setTag(sparseArray);
                fVar.eRo.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.eRo, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eQP || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.eRo.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.eRo.setLayoutParams(layoutParams);
                fVar.eRo.setPadding(0, 0, 0, 0);
                fVar.eRo.hg(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.eRo.hg(postData.getBimg_url());
                if (postData.bwV() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.eRo.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.eRo.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.eRo.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.eRo.setLayoutParams(layoutParams3);
                }
            }
            fVar.eRm.setText(am.r(postData.getTime()));
            fVar.eRr.setVisibility(8);
            if (postData.bwV() == 1) {
                aj.k(fVar.eRe, d.C0096d.cp_bg_line_d);
                fVar.eRf.setVisibility(8);
                fVar.eRv.setVisibility(8);
                fVar.bpY.setVisibility(8);
                fVar.eRm.setVisibility(8);
                fVar.eRr.setVisibility(0);
                fVar.eRt.setVisibility(8);
                fVar.eRu.setVisibility(8);
                fVar.eRK.setVisibility(8);
                fVar.eRE.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rv() != null) {
                    j = postData.rv().getUserIdLong();
                    str = postData.rv().getUserName();
                    str2 = postData.rv().getName_show();
                }
                fVar.eRr.a(postData.bxd(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eQR.aRq().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.eRr.onChangeSkinType();
                if (this.eQQ) {
                    PraiseData rk = this.eQR.aRq().rk();
                    if (rk != null && rk.getUser() != null && rk.getUser().size() > 0) {
                        fVar.eRp.setVisibility(0);
                        fVar.eRq.setVisibility(0);
                        fVar.eRp.setIsFromPb(true);
                        fVar.eRp.a(rk, this.eQR.aRq().getId(), rk.getPostId(), true);
                        fVar.eRp.dE(this.mSkinType);
                    } else {
                        fVar.eRp.setVisibility(8);
                        fVar.eRq.setVisibility(8);
                    }
                    fVar.eRp.setVisibility(8);
                    fVar.eRq.setVisibility(0);
                } else {
                    fVar.eRp.setVisibility(8);
                    fVar.eRq.setVisibility(8);
                }
                a(fVar.eRo, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.eRv.setVisibility(0);
                aj.k(fVar.eRe, d.C0096d.cp_bg_line_e);
                fVar.eRf.setVisibility(0);
                i bwZ = postData.bwZ();
                fVar.eRE.setVisibility(8);
                if (bwZ != null && !TextUtils.isEmpty(bwZ.getName()) && !TextUtils.isEmpty(bwZ.getName().trim())) {
                    final String name = bwZ.getName();
                    final String lat = bwZ.getLat();
                    final String lng = bwZ.getLng();
                    fVar.eRI.setText(bwZ.getName());
                    aj.c(fVar.eRI, d.C0096d.cp_cont_c, 1);
                    fVar.eRI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.hh()) {
                                    e.this.eVp.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.O(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.eRI.setVisibility(8);
                }
                fVar.eRp.setVisibility(8);
                fVar.eRq.setVisibility(8);
                fVar.bpY.setVisibility(0);
                fVar.eRm.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwV()));
                fVar.eRl.setVisibility(0);
                fVar.eRl.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rv().getUserId())) {
                fVar.eRn.setVisibility(0);
                aj.i(fVar.eRn, d.C0096d.cp_link_tip_a);
            } else {
                fVar.eRn.setVisibility(8);
            }
            aj.j(fVar.eRg, d.f.bg_floor_new_middle);
            fVar.eRo.getLayoutStrategy().fS(d.f.pic_video);
            fVar.eRo.setTextColor(aj.getColor(d.C0096d.common_color_10039));
            fVar.eRo.setLinkTextColor(aj.getColor(d.C0096d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwV()));
            if (postData.bxa() > 0) {
                if (this.eQS == null) {
                    this.eQS = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eQS.setIsFromCDN(this.mIsFromCDN);
                    this.eQS.G(this.eQU);
                    boolean z8 = false;
                    String userId4 = this.eQR.aRq().rv().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.eQS.y(this.eQR.aRB(), z8);
                    this.eQS.R(this.eQR.aRq());
                }
                this.eQS.qh(postData.getId());
                fVar.eRs.setVisibility(0);
                fVar.eRs.a(postData, view);
                fVar.eRs.setChildOnClickListener(this.mCommonClickListener);
                fVar.eRs.setChildOnLongClickListener(this.avF);
                fVar.eRs.setChildOnTouchListener(this.aVH);
                fVar.eRs.setSubPbAdapter(this.eQS);
                fVar.eRs.setVisibility(0);
                fVar.eRu.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds24));
                fVar.eRK.setVisibility(0);
            } else {
                fVar.eRu.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds40));
                fVar.eRs.setVisibility(8);
                fVar.eRK.setVisibility(8);
            }
            String portrait = postData.rv().getPortrait();
            if (postData.rv() != null) {
                String name_show = postData.rv().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.rv().getSealPrefix())) {
                    i2 = w.gX(postData.rv().getSealPrefix()) + 2;
                }
                int gX = w.gX(name_show);
                if (i2 > 0) {
                    if (gX > 12) {
                        name_show = w.e(name_show, 0, 14) + "...";
                    }
                } else if (gX > 14) {
                    name_show = w.e(name_show, 0, 14) + "...";
                }
                if (i2 > 0) {
                    fVar.bWB.setText(ag(postData.rv().getSealPrefix(), name_show));
                } else {
                    fVar.bWB.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.rv().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(fVar.bWB, d.C0096d.cp_cont_h, 1);
                } else {
                    aj.c(fVar.bWB, d.C0096d.cp_cont_f, 1);
                }
                int level_id = postData.rv().getLevel_id();
                int is_bawu = postData.rv().getIs_bawu();
                String bawu_type = postData.rv().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.eRj.setVisibility(0);
                    aj.c(fVar.eRj, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.eRj.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.eRj.setOnClickListener(null);
                } else {
                    fVar.eRj.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.eRk, d.f.pb_manager);
                        fVar.eRj.setVisibility(8);
                        fVar.eRk.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.eRk, d.f.pb_assist);
                        fVar.eRj.setVisibility(8);
                        fVar.eRk.setVisibility(0);
                    }
                }
                int gX2 = w.gX(postData.rv().getName_show());
                if (gX2 >= 14 && fVar.eRj.getVisibility() == 0 && fVar.eRn.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.rv().getSealPrefix()) || gX2 < 12 || fVar.eRj.getVisibility() != 0 || fVar.eRn.getVisibility() != 0) ? i3 : i3 - 1;
                this.eQT = postData.rv().getIconInfo();
                this.dMb = postData.rv().getTShowInfoNew();
                if (fVar.dcT != null) {
                    fVar.dcT.setTag(d.g.tag_user_id, postData.rv().getUserId());
                    fVar.dcT.setOnClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.cST);
                    fVar.dcT.a(this.eQT, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.aox != null) {
                    fVar.aox.setOnClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.ffT);
                    fVar.aox.a(this.dMb, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.rv() != null && postData.rv().getPendantData() != null && !StringUtils.isNull(postData.rv().getPendantData().pR())) {
                fVar.eRi.setVisibility(4);
                fVar.eRh.setVisibility(0);
                fVar.eRh.es(postData.rv().getPendantData().pR());
                fVar.eRh.getHeadView().startLoad(portrait, 28, false);
                fVar.eRh.setTag(d.g.tag_user_id, postData.rv().getUserId());
                fVar.eRh.setTag(d.g.tag_user_name, postData.rv().getUserName());
            } else {
                fVar.eRi.setVisibility(0);
                fVar.eRh.setVisibility(8);
                fVar.eRi.setUserId(postData.rv().getUserId());
                fVar.eRi.setUserName(postData.rv().getUserName());
                fVar.eRi.setImageDrawable(null);
                fVar.eRi.startLoad(portrait, 28, false);
            }
            fVar.bWB.setTag(d.g.tag_user_id, postData.rv().getUserId());
            fVar.bWB.setTag(d.g.tag_user_name, postData.rv().getUserName());
            fVar.eRo.setLinkTextColor(aj.getColor(d.C0096d.cp_link_tip_c));
            if (this.eQP) {
                fVar.eRo.getLayoutStrategy().fV(d.f.transparent_bg);
            } else {
                fVar.eRo.getLayoutStrategy().fV(d.f.icon_click);
            }
            fVar.eRo.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwY();
            }
            if (this.eQV || !this.eQW) {
                fVar.eRo.a(tbRichText, false);
            } else {
                fVar.eRo.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.eQR.aRB() != 0) {
                if (this.eQR.aRB() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.rv().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.eQR != null && this.eQR.aRq() != null && this.eQR.aRq().rv() != null && postData.rv() != null) {
                        userId2 = this.eQR.aRq().rv().getUserId();
                        userId3 = postData.rv().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.rv().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (fVar.eRz != null) {
                                    fVar.eRz.setVisibility(0);
                                    fVar.eRz.setText(d.j.manage);
                                    fVar.eRz.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.eRz != null) {
                                    fVar.eRz.setVisibility(0);
                                    fVar.eRz.setText(d.j.delete);
                                    fVar.eRz.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.eRz != null) {
                                fVar.eRz.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bwV() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQR.aRB()));
                                sparseArray2.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
                            } else {
                                sparseArray2.put(d.g.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.g.tag_user_mute_visible, true);
                                sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.rv() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rv().getUserId());
                                    sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rv().getUserName());
                                }
                                if (this.eQR.aRq() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.eQR.aRq().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQR.aRB()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bwV() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.eQZ == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.eQZ.bEO();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.rv().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i52 = 1;
                    if (postData.bwV() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwV() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.eQZ == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.eQR != null) {
                userId2 = this.eQR.aRq().rv().getUserId();
                userId3 = postData.rv().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.rv().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i522 = 1;
                    if (postData.bwV() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwV() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.eQZ == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.rv().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i5222 = 1;
            if (postData.bwV() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bwV() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.eQZ == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.eRo.setTextViewOnTouchListener(this.aVH);
        fVar.eRo.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aYe() == null || e(postData)) {
            fVar.eRJ.setVisibility(8);
        } else {
            g.a(postData.aYe(), fVar.eRJ, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fT(this.eQY - (i - this.eQX));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.eQR == null || this.eQR.aRq() == null || !this.eQR.aRq().sh() || this.eQR.aRq().rh() == null || postData.bwV() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.eVp != null) {
            if (this.eQZ == null) {
                this.eQZ = new com.baidu.tieba.vote.a(this.eVp);
            }
            this.eQZ.a(view, this.eQR);
        } else if (this.eQZ != null) {
            this.eQZ.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.bWB.setOnClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.ffS);
        fVar.eRi.setOnClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.ffS);
        fVar.eRh.setOnClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.ffS);
        fVar.bpY.setOnLongClickListener(this.avF);
        fVar.eRo.setOnLongClickListener(this.avF);
        fVar.bpY.setOnTouchListener(this.aVH);
        fVar.eRo.setOnTouchListener(this.aVH);
        fVar.eRo.setOnImageClickListener(this.aVG);
        fVar.eRo.setOnEmotionClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.ffU);
        fVar.dcT.setOnClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.cST);
        fVar.aox.setOnClickListener(((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu.ffT);
        fVar.eRJ.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eQR = fVar;
    }

    public void pO(int i) {
        this.eQO = i;
    }

    public void iY(boolean z) {
        this.eQP = z;
    }

    public void iZ(boolean z) {
        this.eQQ = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQU = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVG = gVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avF = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return k.a((Context) this.eVp.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
