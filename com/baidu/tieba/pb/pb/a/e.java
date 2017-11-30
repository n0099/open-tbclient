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
    private TbRichTextView.f aVE;
    private com.baidu.tieba.pb.a.c aVF;
    private View.OnLongClickListener avA;
    private ArrayList<IconData> dKW;
    private int ePL;
    private boolean ePM;
    private boolean ePN;
    private com.baidu.tieba.pb.data.f ePO;
    private com.baidu.tieba.pb.pb.sub.d ePP;
    private ArrayList<IconData> ePQ;
    private View.OnClickListener ePR;
    private boolean ePS;
    private final boolean ePT;
    private int ePU;
    private int ePV;
    private com.baidu.tieba.vote.a ePW;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ePL = 0;
        this.ePM = true;
        this.ePN = true;
        this.ePO = null;
        this.mHostId = null;
        this.ePP = null;
        this.ePQ = null;
        this.dKW = null;
        this.ePR = null;
        this.mCommonClickListener = null;
        this.aVE = null;
        this.aVF = null;
        this.avA = null;
        this.ePS = false;
        this.ePT = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.c(fVar.eQu, d.C0082d.common_color_10005, 1);
                aj.c(fVar.eQw, d.C0082d.cp_link_tip_c, 3);
                aj.c(fVar.bWx, d.C0082d.cp_cont_f, 1);
                aj.c(fVar.eQg, d.C0082d.cp_cont_i, 1);
                aj.c(fVar.eQh, d.C0082d.cp_cont_i, 1);
                aj.c(fVar.eQi, d.C0082d.cp_cont_d, 1);
                aj.c(fVar.eQj, d.C0082d.cp_cont_d, 1);
                aj.k(fVar.eQm, d.C0082d.cp_bg_line_e);
                aj.k(fVar.eQn, d.C0082d.cp_bg_line_e);
                aj.c(fVar.eQn, d.C0082d.cp_bg_line_b);
                aj.k(fVar.eQp, d.C0082d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.ePU = getDimensionPixelSize(d.e.ds30);
        this.ePV = l.ac(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.ePM, this.ePL, false);
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
            postData2.sw();
            a(fVar, postData2, view, i);
        }
        if (!this.ePS && this.ePT && fVar != null && fVar.eQl.Kf() && (listView = ((PbActivity) this.eUm.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ePS = true;
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
            aj.k(fVar.eQs, d.C0082d.cp_bg_line_b);
            fVar.eQf.setTag(null);
            fVar.eQf.setUserId(null);
            fVar.bWx.setText((CharSequence) null);
            fVar.eQh.setVisibility(8);
            fVar.eQp.setVisibility(0);
            fVar.eQk.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.bpX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.bpX.setTag(sparseArray);
                fVar.eQl.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.eQl, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ePM || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.eQl.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.eQl.setLayoutParams(layoutParams);
                fVar.eQl.setPadding(0, 0, 0, 0);
                fVar.eQl.hi(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.eQl.hi(postData.getBimg_url());
                if (postData.bwo() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.eQl.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.eQl.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.eQl.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.eQl.setLayoutParams(layoutParams3);
                }
            }
            fVar.eQj.setText(am.r(postData.getTime()));
            fVar.eQo.setVisibility(8);
            if (postData.bwo() == 1) {
                aj.k(fVar.eQb, d.C0082d.cp_bg_line_d);
                fVar.eQc.setVisibility(8);
                fVar.eQs.setVisibility(8);
                fVar.bpX.setVisibility(8);
                fVar.eQj.setVisibility(8);
                fVar.eQo.setVisibility(0);
                fVar.eQq.setVisibility(8);
                fVar.eQr.setVisibility(8);
                fVar.eQH.setVisibility(8);
                fVar.eQB.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rx() != null) {
                    j = postData.rx().getUserIdLong();
                    str = postData.rx().getUserName();
                    str2 = postData.rx().getName_show();
                }
                fVar.eQo.a(postData.bww(), str, str2, j, com.baidu.adp.lib.g.b.c(this.ePO.aRh().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.eQo.onChangeSkinType();
                if (this.ePN) {
                    PraiseData rm = this.ePO.aRh().rm();
                    if (rm != null && rm.getUser() != null && rm.getUser().size() > 0) {
                        fVar.eQm.setVisibility(0);
                        fVar.eQn.setVisibility(0);
                        fVar.eQm.setIsFromPb(true);
                        fVar.eQm.a(rm, this.ePO.aRh().getId(), rm.getPostId(), true);
                        fVar.eQm.dE(this.mSkinType);
                    } else {
                        fVar.eQm.setVisibility(8);
                        fVar.eQn.setVisibility(8);
                    }
                    fVar.eQm.setVisibility(8);
                    fVar.eQn.setVisibility(0);
                } else {
                    fVar.eQm.setVisibility(8);
                    fVar.eQn.setVisibility(8);
                }
                a(fVar.eQl, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.eQs.setVisibility(0);
                aj.k(fVar.eQb, d.C0082d.cp_bg_line_e);
                fVar.eQc.setVisibility(0);
                i bws = postData.bws();
                fVar.eQB.setVisibility(8);
                if (bws != null && !TextUtils.isEmpty(bws.getName()) && !TextUtils.isEmpty(bws.getName().trim())) {
                    final String name = bws.getName();
                    final String lat = bws.getLat();
                    final String lng = bws.getLng();
                    fVar.eQF.setText(bws.getName());
                    aj.c(fVar.eQF, d.C0082d.cp_cont_c, 1);
                    fVar.eQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.hh()) {
                                    e.this.eUm.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.P(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.eQF.setVisibility(8);
                }
                fVar.eQm.setVisibility(8);
                fVar.eQn.setVisibility(8);
                fVar.bpX.setVisibility(0);
                fVar.eQj.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwo()));
                fVar.eQi.setVisibility(0);
                fVar.eQi.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.rx().getUserId())) {
                fVar.eQk.setVisibility(0);
                aj.i(fVar.eQk, d.C0082d.cp_link_tip_a);
            } else {
                fVar.eQk.setVisibility(8);
            }
            aj.j(fVar.eQd, d.f.bg_floor_new_middle);
            fVar.eQl.getLayoutStrategy().fS(d.f.pic_video);
            fVar.eQl.setTextColor(aj.getColor(d.C0082d.common_color_10039));
            fVar.eQl.setLinkTextColor(aj.getColor(d.C0082d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwo()));
            if (postData.bwt() > 0) {
                if (this.ePP == null) {
                    this.ePP = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.ePP.setIsFromCDN(this.mIsFromCDN);
                    this.ePP.G(this.ePR);
                    boolean z8 = false;
                    String userId4 = this.ePO.aRh().rx().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.ePP.y(this.ePO.aRs(), z8);
                    this.ePP.P(this.ePO.aRh());
                }
                this.ePP.qh(postData.getId());
                fVar.eQp.setVisibility(0);
                fVar.eQp.a(postData, view);
                fVar.eQp.setChildOnClickListener(this.mCommonClickListener);
                fVar.eQp.setChildOnLongClickListener(this.avA);
                fVar.eQp.setChildOnTouchListener(this.aVF);
                fVar.eQp.setSubPbAdapter(this.ePP);
                fVar.eQp.setVisibility(0);
                fVar.eQr.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds24));
                fVar.eQH.setVisibility(0);
            } else {
                fVar.eQr.setPadding(0, 0, 0, l.f(this.mContext, d.e.ds40));
                fVar.eQp.setVisibility(8);
                fVar.eQH.setVisibility(8);
            }
            String portrait = postData.rx().getPortrait();
            if (postData.rx() != null) {
                String name_show = postData.rx().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.rx().getSealPrefix())) {
                    i2 = w.gZ(postData.rx().getSealPrefix()) + 2;
                }
                int gZ = w.gZ(name_show);
                if (i2 > 0) {
                    if (gZ > 12) {
                        name_show = w.e(name_show, 0, 14) + "...";
                    }
                } else if (gZ > 14) {
                    name_show = w.e(name_show, 0, 14) + "...";
                }
                if (i2 > 0) {
                    fVar.bWx.setText(ag(postData.rx().getSealPrefix(), name_show));
                } else {
                    fVar.bWx.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.rx().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.c(fVar.bWx, d.C0082d.cp_cont_h, 1);
                } else {
                    aj.c(fVar.bWx, d.C0082d.cp_cont_f, 1);
                }
                int level_id = postData.rx().getLevel_id();
                int is_bawu = postData.rx().getIs_bawu();
                String bawu_type = postData.rx().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.eQg.setVisibility(0);
                    aj.c(fVar.eQg, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.eQg.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.eQg.setOnClickListener(null);
                } else {
                    fVar.eQg.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.eQh, d.f.pb_manager);
                        fVar.eQg.setVisibility(8);
                        fVar.eQh.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.eQh, d.f.pb_assist);
                        fVar.eQg.setVisibility(8);
                        fVar.eQh.setVisibility(0);
                    }
                }
                int gZ2 = w.gZ(postData.rx().getName_show());
                if (gZ2 >= 14 && fVar.eQg.getVisibility() == 0 && fVar.eQk.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.rx().getSealPrefix()) || gZ2 < 12 || fVar.eQg.getVisibility() != 0 || fVar.eQk.getVisibility() != 0) ? i3 : i3 - 1;
                this.ePQ = postData.rx().getIconInfo();
                this.dKW = postData.rx().getTShowInfoNew();
                if (fVar.dbM != null) {
                    fVar.dbM.setTag(d.g.tag_user_id, postData.rx().getUserId());
                    fVar.dbM.setOnClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.cSI);
                    fVar.dbM.a(this.ePQ, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.aov != null) {
                    fVar.aov.setOnClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.feS);
                    fVar.aov.a(this.dKW, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.rx() != null && postData.rx().getPendantData() != null && !StringUtils.isNull(postData.rx().getPendantData().pT())) {
                fVar.eQf.setVisibility(4);
                fVar.eQe.setVisibility(0);
                fVar.eQe.es(postData.rx().getPendantData().pT());
                fVar.eQe.getHeadView().startLoad(portrait, 28, false);
                fVar.eQe.setTag(d.g.tag_user_id, postData.rx().getUserId());
                fVar.eQe.setTag(d.g.tag_user_name, postData.rx().getUserName());
            } else {
                fVar.eQf.setVisibility(0);
                fVar.eQe.setVisibility(8);
                fVar.eQf.setUserId(postData.rx().getUserId());
                fVar.eQf.setUserName(postData.rx().getUserName());
                fVar.eQf.setImageDrawable(null);
                fVar.eQf.startLoad(portrait, 28, false);
            }
            fVar.bWx.setTag(d.g.tag_user_id, postData.rx().getUserId());
            fVar.bWx.setTag(d.g.tag_user_name, postData.rx().getUserName());
            fVar.eQl.setLinkTextColor(aj.getColor(d.C0082d.cp_link_tip_c));
            if (this.ePM) {
                fVar.eQl.getLayoutStrategy().fV(d.f.transparent_bg);
            } else {
                fVar.eQl.getLayoutStrategy().fV(d.f.icon_click);
            }
            fVar.eQl.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwr();
            }
            if (this.ePS || !this.ePT) {
                fVar.eQl.a(tbRichText, false);
            } else {
                fVar.eQl.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.ePO.aRs() != 0) {
                if (this.ePO.aRs() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.rx().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.ePO != null && this.ePO.aRh() != null && this.ePO.aRh().rx() != null && postData.rx() != null) {
                        userId2 = this.ePO.aRh().rx().getUserId();
                        userId3 = postData.rx().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.rx().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (fVar.eQw != null) {
                                    fVar.eQw.setVisibility(0);
                                    fVar.eQw.setText(d.j.manage);
                                    fVar.eQw.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.eQw != null) {
                                    fVar.eQw.setVisibility(0);
                                    fVar.eQw.setText(d.j.delete);
                                    fVar.eQw.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.eQw != null) {
                                fVar.eQw.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bwo() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ePO.aRs()));
                                sparseArray2.put(d.g.tag_forbid_user_name, postData.rx().getUserName());
                            } else {
                                sparseArray2.put(d.g.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.g.tag_user_mute_visible, true);
                                sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.rx() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rx().getUserId());
                                    sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rx().getUserName());
                                }
                                if (this.ePO.aRh() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.ePO.aRh().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ePO.aRs()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bwo() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.ePW == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.ePW.bEc();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.rx().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i52 = 1;
                    if (postData.bwo() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwo() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.ePW == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.ePO != null) {
                userId2 = this.ePO.aRh().rx().getUserId();
                userId3 = postData.rx().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.rx().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i522 = 1;
                    if (postData.bwo() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwo() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.ePW == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.rx().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i5222 = 1;
            if (postData.bwo() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bwo() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.ePW == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.eQl.setTextViewOnTouchListener(this.aVF);
        fVar.eQl.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aXW() == null || e(postData)) {
            fVar.eQG.setVisibility(8);
        } else {
            g.a(postData.aXW(), fVar.eQG, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fT(this.ePV - (i - this.ePU));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.ePO == null || this.ePO.aRh() == null || !this.ePO.aRh().sj() || this.ePO.aRh().rj() == null || postData.bwo() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.eUm != null) {
            if (this.ePW == null) {
                this.ePW = new com.baidu.tieba.vote.a(this.eUm);
            }
            this.ePW.a(view, this.ePO);
        } else if (this.ePW != null) {
            this.ePW.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.bWx.setOnClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.feR);
        fVar.eQf.setOnClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.feR);
        fVar.eQe.setOnClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.feR);
        fVar.bpX.setOnLongClickListener(this.avA);
        fVar.eQl.setOnLongClickListener(this.avA);
        fVar.bpX.setOnTouchListener(this.aVF);
        fVar.eQl.setOnTouchListener(this.aVF);
        fVar.eQl.setOnImageClickListener(this.aVE);
        fVar.eQl.setOnEmotionClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.feT);
        fVar.dbM.setOnClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.cSI);
        fVar.aov.setOnClickListener(((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr.feS);
        fVar.eQG.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ePO = fVar;
    }

    public void pH(int i) {
        this.ePL = i;
    }

    public void iX(boolean z) {
        this.ePM = z;
    }

    public void iY(boolean z) {
        this.ePN = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void D(View.OnClickListener onClickListener) {
        this.ePR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aVE = fVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avA = onLongClickListener;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return k.a((Context) this.eUm.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
