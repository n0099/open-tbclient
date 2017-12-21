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
    private TbRichTextView.g aVJ;
    private com.baidu.tieba.pb.a.c aVK;
    private View.OnLongClickListener avI;
    private ArrayList<IconData> dMf;
    private int eQT;
    private boolean eQU;
    private boolean eQV;
    private com.baidu.tieba.pb.data.f eQW;
    private com.baidu.tieba.pb.pb.sub.d eQX;
    private ArrayList<IconData> eQY;
    private View.OnClickListener eQZ;
    private boolean eRa;
    private final boolean eRb;
    private int eRc;
    private int eRd;
    private com.baidu.tieba.vote.a eRe;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eQT = 0;
        this.eQU = true;
        this.eQV = true;
        this.eQW = null;
        this.mHostId = null;
        this.eQX = null;
        this.eQY = null;
        this.dMf = null;
        this.eQZ = null;
        this.mCommonClickListener = null;
        this.aVJ = null;
        this.aVK = null;
        this.avI = null;
        this.eRa = false;
        this.eRb = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(fVar.eRC, d.C0095d.common_color_10005, 1);
                aj.c(fVar.eRE, d.C0095d.cp_link_tip_c, 3);
                aj.c(fVar.bWF, d.C0095d.cp_cont_f, 1);
                aj.c(fVar.eRo, d.C0095d.cp_cont_i, 1);
                aj.c(fVar.eRp, d.C0095d.cp_cont_i, 1);
                aj.c(fVar.eRq, d.C0095d.cp_cont_d, 1);
                aj.c(fVar.eRr, d.C0095d.cp_cont_d, 1);
                aj.k(fVar.eRu, d.C0095d.cp_bg_line_e);
                aj.k(fVar.eRv, d.C0095d.cp_bg_line_e);
                aj.c(fVar.eRv, d.C0095d.cp_bg_line_b);
                aj.k(fVar.eRx, d.C0095d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eRc = getDimensionPixelSize(d.e.ds30);
        this.eRd = l.ac(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.eQU, this.eQT, false);
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
        if (!this.eRa && this.eRb && fVar != null && fVar.eRt.Kg() && (listView = ((PbActivity) this.eVu.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eRa = true;
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
            aj.k(fVar.eRA, d.C0095d.cp_bg_line_b);
            fVar.eRn.setTag(null);
            fVar.eRn.setUserId(null);
            fVar.bWF.setText((CharSequence) null);
            fVar.eRp.setVisibility(8);
            fVar.eRx.setVisibility(0);
            fVar.eRs.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.bqc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.bqc.setTag(sparseArray);
                fVar.eRt.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.eRt, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eQU || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.eRt.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.eRt.setLayoutParams(layoutParams);
                fVar.eRt.setPadding(0, 0, 0, 0);
                fVar.eRt.hg(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.eRt.hg(postData.getBimg_url());
                if (postData.bwV() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.eRt.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.eRt.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.eRt.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.eRt.setLayoutParams(layoutParams3);
                }
            }
            fVar.eRr.setText(am.r(postData.getTime()));
            fVar.eRw.setVisibility(8);
            if (postData.bwV() == 1) {
                aj.k(fVar.eRj, d.C0095d.cp_bg_line_d);
                fVar.eRk.setVisibility(8);
                fVar.eRA.setVisibility(8);
                fVar.bqc.setVisibility(8);
                fVar.eRr.setVisibility(8);
                fVar.eRw.setVisibility(0);
                fVar.eRy.setVisibility(8);
                fVar.eRz.setVisibility(8);
                fVar.eRP.setVisibility(8);
                fVar.eRJ.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rv() != null) {
                    j = postData.rv().getUserIdLong();
                    str = postData.rv().getUserName();
                    str2 = postData.rv().getName_show();
                }
                fVar.eRw.a(postData.bxd(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eQW.aRq().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.eRw.onChangeSkinType();
                if (this.eQV) {
                    PraiseData rk = this.eQW.aRq().rk();
                    if (rk != null && rk.getUser() != null && rk.getUser().size() > 0) {
                        fVar.eRu.setVisibility(0);
                        fVar.eRv.setVisibility(0);
                        fVar.eRu.setIsFromPb(true);
                        fVar.eRu.a(rk, this.eQW.aRq().getId(), rk.getPostId(), true);
                        fVar.eRu.dE(this.mSkinType);
                    } else {
                        fVar.eRu.setVisibility(8);
                        fVar.eRv.setVisibility(8);
                    }
                    fVar.eRu.setVisibility(8);
                    fVar.eRv.setVisibility(0);
                } else {
                    fVar.eRu.setVisibility(8);
                    fVar.eRv.setVisibility(8);
                }
                a(fVar.eRt, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.eRA.setVisibility(0);
                aj.k(fVar.eRj, d.C0095d.cp_bg_line_e);
                fVar.eRk.setVisibility(0);
                i bwZ = postData.bwZ();
                fVar.eRJ.setVisibility(8);
                if (bwZ != null && !TextUtils.isEmpty(bwZ.getName()) && !TextUtils.isEmpty(bwZ.getName().trim())) {
                    final String name = bwZ.getName();
                    final String lat = bwZ.getLat();
                    final String lng = bwZ.getLng();
                    fVar.eRN.setText(bwZ.getName());
                    aj.c(fVar.eRN, d.C0095d.cp_cont_c, 1);
                    fVar.eRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.hh()) {
                                    e.this.eVu.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.O(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.eRN.setVisibility(8);
                }
                fVar.eRu.setVisibility(8);
                fVar.eRv.setVisibility(8);
                fVar.bqc.setVisibility(0);
                fVar.eRr.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwV()));
                fVar.eRq.setVisibility(0);
                fVar.eRq.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rv().getUserId())) {
                fVar.eRs.setVisibility(0);
                aj.i(fVar.eRs, d.C0095d.cp_link_tip_a);
            } else {
                fVar.eRs.setVisibility(8);
            }
            aj.j(fVar.eRl, d.f.bg_floor_new_middle);
            fVar.eRt.getLayoutStrategy().fS(d.f.pic_video);
            fVar.eRt.setTextColor(aj.getColor(d.C0095d.common_color_10039));
            fVar.eRt.setLinkTextColor(aj.getColor(d.C0095d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwV()));
            if (postData.bxa() > 0) {
                if (this.eQX == null) {
                    this.eQX = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eQX.setIsFromCDN(this.mIsFromCDN);
                    this.eQX.G(this.eQZ);
                    boolean z8 = false;
                    String userId4 = this.eQW.aRq().rv().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.eQX.y(this.eQW.aRB(), z8);
                    this.eQX.R(this.eQW.aRq());
                }
                this.eQX.qh(postData.getId());
                fVar.eRx.setVisibility(0);
                fVar.eRx.a(postData, view);
                fVar.eRx.setChildOnClickListener(this.mCommonClickListener);
                fVar.eRx.setChildOnLongClickListener(this.avI);
                fVar.eRx.setChildOnTouchListener(this.aVK);
                fVar.eRx.setSubPbAdapter(this.eQX);
                fVar.eRx.setVisibility(0);
                fVar.eRz.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds24));
                fVar.eRP.setVisibility(0);
            } else {
                fVar.eRz.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds40));
                fVar.eRx.setVisibility(8);
                fVar.eRP.setVisibility(8);
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
                    fVar.bWF.setText(ag(postData.rv().getSealPrefix(), name_show));
                } else {
                    fVar.bWF.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.rv().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(fVar.bWF, d.C0095d.cp_cont_h, 1);
                } else {
                    aj.c(fVar.bWF, d.C0095d.cp_cont_f, 1);
                }
                int level_id = postData.rv().getLevel_id();
                int is_bawu = postData.rv().getIs_bawu();
                String bawu_type = postData.rv().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.eRo.setVisibility(0);
                    aj.c(fVar.eRo, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.eRo.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.eRo.setOnClickListener(null);
                } else {
                    fVar.eRo.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.eRp, d.f.pb_manager);
                        fVar.eRo.setVisibility(8);
                        fVar.eRp.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.eRp, d.f.pb_assist);
                        fVar.eRo.setVisibility(8);
                        fVar.eRp.setVisibility(0);
                    }
                }
                int gX2 = w.gX(postData.rv().getName_show());
                if (gX2 >= 14 && fVar.eRo.getVisibility() == 0 && fVar.eRs.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.rv().getSealPrefix()) || gX2 < 12 || fVar.eRo.getVisibility() != 0 || fVar.eRs.getVisibility() != 0) ? i3 : i3 - 1;
                this.eQY = postData.rv().getIconInfo();
                this.dMf = postData.rv().getTShowInfoNew();
                if (fVar.dcX != null) {
                    fVar.dcX.setTag(d.g.tag_user_id, postData.rv().getUserId());
                    fVar.dcX.setOnClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.cSX);
                    fVar.dcX.a(this.eQY, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.aoA != null) {
                    fVar.aoA.setOnClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.ffY);
                    fVar.aoA.a(this.dMf, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.rv() != null && postData.rv().getPendantData() != null && !StringUtils.isNull(postData.rv().getPendantData().pR())) {
                fVar.eRn.setVisibility(4);
                fVar.eRm.setVisibility(0);
                fVar.eRm.es(postData.rv().getPendantData().pR());
                fVar.eRm.getHeadView().startLoad(portrait, 28, false);
                fVar.eRm.setTag(d.g.tag_user_id, postData.rv().getUserId());
                fVar.eRm.setTag(d.g.tag_user_name, postData.rv().getUserName());
            } else {
                fVar.eRn.setVisibility(0);
                fVar.eRm.setVisibility(8);
                fVar.eRn.setUserId(postData.rv().getUserId());
                fVar.eRn.setUserName(postData.rv().getUserName());
                fVar.eRn.setImageDrawable(null);
                fVar.eRn.startLoad(portrait, 28, false);
            }
            fVar.bWF.setTag(d.g.tag_user_id, postData.rv().getUserId());
            fVar.bWF.setTag(d.g.tag_user_name, postData.rv().getUserName());
            fVar.eRt.setLinkTextColor(aj.getColor(d.C0095d.cp_link_tip_c));
            if (this.eQU) {
                fVar.eRt.getLayoutStrategy().fV(d.f.transparent_bg);
            } else {
                fVar.eRt.getLayoutStrategy().fV(d.f.icon_click);
            }
            fVar.eRt.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwY();
            }
            if (this.eRa || !this.eRb) {
                fVar.eRt.a(tbRichText, false);
            } else {
                fVar.eRt.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.eQW.aRB() != 0) {
                if (this.eQW.aRB() != 1002) {
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
                    if (this.eQW != null && this.eQW.aRq() != null && this.eQW.aRq().rv() != null && postData.rv() != null) {
                        userId2 = this.eQW.aRq().rv().getUserId();
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
                                if (fVar.eRE != null) {
                                    fVar.eRE.setVisibility(0);
                                    fVar.eRE.setText(d.j.manage);
                                    fVar.eRE.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.eRE != null) {
                                    fVar.eRE.setVisibility(0);
                                    fVar.eRE.setText(d.j.delete);
                                    fVar.eRE.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.eRE != null) {
                                fVar.eRE.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bwV() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQW.aRB()));
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
                                if (this.eQW.aRq() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.eQW.aRq().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQW.aRB()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bwV() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.eRe == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.eRe.bEO();
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
                    if (this.eRe == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.eQW != null) {
                userId2 = this.eQW.aRq().rv().getUserId();
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
                    if (this.eRe == null) {
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
            if (this.eRe == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.eRt.setTextViewOnTouchListener(this.aVK);
        fVar.eRt.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aYe() == null || e(postData)) {
            fVar.eRO.setVisibility(8);
        } else {
            g.a(postData.aYe(), fVar.eRO, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fT(this.eRd - (i - this.eRc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.eQW == null || this.eQW.aRq() == null || !this.eQW.aRq().sh() || this.eQW.aRq().rh() == null || postData.bwV() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.eVu != null) {
            if (this.eRe == null) {
                this.eRe = new com.baidu.tieba.vote.a(this.eVu);
            }
            this.eRe.a(view, this.eQW);
        } else if (this.eRe != null) {
            this.eRe.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.bWF.setOnClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.ffX);
        fVar.eRn.setOnClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.ffX);
        fVar.eRm.setOnClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.ffX);
        fVar.bqc.setOnLongClickListener(this.avI);
        fVar.eRt.setOnLongClickListener(this.avI);
        fVar.bqc.setOnTouchListener(this.aVK);
        fVar.eRt.setOnTouchListener(this.aVK);
        fVar.eRt.setOnImageClickListener(this.aVJ);
        fVar.eRt.setOnEmotionClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.ffZ);
        fVar.dcX.setOnClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.cSX);
        fVar.aoA.setOnClickListener(((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz.ffY);
        fVar.eRO.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eQW = fVar;
    }

    public void pO(int i) {
        this.eQT = i;
    }

    public void iY(boolean z) {
        this.eQU = z;
    }

    public void iZ(boolean z) {
        this.eQV = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQZ = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVJ = gVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avI = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return k.a((Context) this.eVu.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
