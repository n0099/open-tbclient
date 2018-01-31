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
    private TbRichTextView.h bJN;
    private com.baidu.tieba.pb.a.c bJO;
    private View.OnLongClickListener bkf;
    private ArrayList<IconData> eAh;
    private com.baidu.tieba.vote.a fFA;
    private int fFp;
    private boolean fFq;
    private boolean fFr;
    private com.baidu.tieba.pb.data.f fFs;
    private com.baidu.tieba.pb.pb.sub.d fFt;
    private ArrayList<IconData> fFu;
    private View.OnClickListener fFv;
    private boolean fFw;
    private final boolean fFx;
    private int fFy;
    private int fFz;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fFp = 0;
        this.fFq = true;
        this.fFr = true;
        this.fFs = null;
        this.mHostId = null;
        this.fFt = null;
        this.fFu = null;
        this.eAh = null;
        this.fFv = null;
        this.mCommonClickListener = null;
        this.bJN = null;
        this.bJO = null;
        this.bkf = null;
        this.fFw = false;
        this.fFx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.e(fVar.fFY, d.C0108d.common_color_10005, 1);
                aj.e(fVar.fGa, d.C0108d.cp_link_tip_c, 3);
                aj.e(fVar.cQi, d.C0108d.cp_cont_f, 1);
                aj.e(fVar.fFK, d.C0108d.cp_cont_i, 1);
                aj.e(fVar.fFL, d.C0108d.cp_cont_i, 1);
                aj.e(fVar.fFM, d.C0108d.cp_cont_d, 1);
                aj.e(fVar.fFN, d.C0108d.cp_cont_d, 1);
                aj.t(fVar.fFQ, d.C0108d.cp_bg_line_e);
                aj.t(fVar.fFR, d.C0108d.cp_bg_line_e);
                aj.c(fVar.fFR, d.C0108d.cp_bg_line_b);
                aj.t(fVar.fFT, d.C0108d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.fFy = getDimensionPixelSize(d.e.ds30);
        this.fFz = l.ao(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.fFq, this.fFp, false);
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
            postData2.zP();
            a(fVar, postData2, view, i);
        }
        if (!this.fFw && this.fFx && fVar != null && fVar.fFP.Rt() && (listView = ((PbActivity) this.fJR.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fFw = true;
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
            aj.t(fVar.fFW, d.C0108d.cp_bg_line_b);
            fVar.fFJ.setTag(null);
            fVar.fFJ.setUserId(null);
            fVar.cQi.setText((CharSequence) null);
            fVar.fFL.setVisibility(8);
            fVar.fFT.setVisibility(0);
            fVar.fFO.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.cdM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.cdM.setTag(sparseArray);
                fVar.fFP.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.fFP, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fFq || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.fFP.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.fFP.setLayoutParams(layoutParams);
                fVar.fFP.setPadding(0, 0, 0, 0);
                fVar.fFP.hr(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.fFP.hr(postData.getBimg_url());
                if (postData.bvJ() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.fFP.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.fFP.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.fFP.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.fFP.setLayoutParams(layoutParams3);
                }
            }
            fVar.fFN.setText(am.z(postData.getTime()));
            fVar.fFS.setVisibility(8);
            if (postData.bvJ() == 1) {
                aj.t(fVar.fFF, d.C0108d.cp_bg_line_d);
                fVar.fFG.setVisibility(8);
                fVar.fFW.setVisibility(8);
                fVar.cdM.setVisibility(8);
                fVar.fFN.setVisibility(8);
                fVar.fFS.setVisibility(0);
                fVar.fFU.setVisibility(8);
                fVar.fFV.setVisibility(8);
                fVar.fGl.setVisibility(8);
                fVar.fGf.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.yT() != null) {
                    j = postData.yT().getUserIdLong();
                    str = postData.yT().getUserName();
                    str2 = postData.yT().getName_show();
                }
                fVar.fFS.a(postData.bvS(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fFs.aYL().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.fFS.onChangeSkinType();
                if (this.fFr) {
                    PraiseData yI = this.fFs.aYL().yI();
                    if (yI != null && yI.getUser() != null && yI.getUser().size() > 0) {
                        fVar.fFQ.setVisibility(0);
                        fVar.fFR.setVisibility(0);
                        fVar.fFQ.setIsFromPb(true);
                        fVar.fFQ.a(yI, this.fFs.aYL().getId(), yI.getPostId(), true);
                        fVar.fFQ.gz(this.mSkinType);
                    } else {
                        fVar.fFQ.setVisibility(8);
                        fVar.fFR.setVisibility(8);
                    }
                    fVar.fFQ.setVisibility(8);
                    fVar.fFR.setVisibility(0);
                } else {
                    fVar.fFQ.setVisibility(8);
                    fVar.fFR.setVisibility(8);
                }
                a(fVar.fFP, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.fFW.setVisibility(0);
                aj.t(fVar.fFF, d.C0108d.cp_bg_line_e);
                fVar.fFG.setVisibility(0);
                com.baidu.tbadk.data.f bvN = postData.bvN();
                fVar.fGf.setVisibility(8);
                if (bvN != null && !TextUtils.isEmpty(bvN.getName()) && !TextUtils.isEmpty(bvN.getName().trim())) {
                    final String name = bvN.getName();
                    final String lat = bvN.getLat();
                    final String lng = bvN.getLng();
                    fVar.fGj.setText(bvN.getName());
                    aj.e(fVar.fGj, d.C0108d.cp_cont_c, 1);
                    fVar.fGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.oJ()) {
                                    e.this.fJR.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.P(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.fGj.setVisibility(8);
                }
                fVar.fFQ.setVisibility(8);
                fVar.fFR.setVisibility(8);
                fVar.cdM.setVisibility(0);
                fVar.fFN.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bvJ()));
                fVar.fFM.setVisibility(0);
                fVar.fFM.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yT().getUserId())) {
                fVar.fFO.setVisibility(0);
                aj.r(fVar.fFO, d.C0108d.cp_link_tip_a);
            } else {
                fVar.fFO.setVisibility(8);
            }
            aj.s(fVar.fFH, d.f.bg_floor_new_middle);
            fVar.fFP.getLayoutStrategy().iN(d.f.pic_video);
            fVar.fFP.setTextColor(aj.getColor(d.C0108d.common_color_10039));
            fVar.fFP.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bvJ()));
            if (postData.bvO() > 0) {
                if (this.fFt == null) {
                    this.fFt = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fFt.setIsFromCDN(this.mIsFromCDN);
                    this.fFt.H(this.fFv);
                    boolean z8 = false;
                    String userId4 = this.fFs.aYL().yT().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.fFt.J(this.fFs.aYX(), z8);
                    this.fFt.Q(this.fFs.aYL());
                }
                this.fFt.qB(postData.getId());
                fVar.fFT.setVisibility(0);
                fVar.fFT.a(postData, view);
                fVar.fFT.setChildOnClickListener(this.mCommonClickListener);
                fVar.fFT.setChildOnLongClickListener(this.bkf);
                fVar.fFT.setChildOnTouchListener(this.bJO);
                fVar.fFT.setSubPbAdapter(this.fFt);
                fVar.fFT.setVisibility(0);
                fVar.fFV.setPadding(0, 0, 0, l.s(this.mContext, d.e.ds24));
                fVar.fGl.setVisibility(0);
            } else {
                fVar.fFV.setPadding(0, 0, 0, l.s(this.mContext, d.e.ds40));
                fVar.fFT.setVisibility(8);
                fVar.fGl.setVisibility(8);
            }
            String portrait = postData.yT().getPortrait();
            if (postData.yT() != null) {
                String name_show = postData.yT().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.yT().getSealPrefix())) {
                    i2 = w.hi(postData.yT().getSealPrefix()) + 2;
                }
                int hi = w.hi(name_show);
                if (i2 > 0) {
                    if (hi > 12) {
                        name_show = w.j(name_show, 0, 14) + "...";
                    }
                } else if (hi > 14) {
                    name_show = w.j(name_show, 0, 14) + "...";
                }
                if (i2 > 0) {
                    fVar.cQi.setText(ae(postData.yT().getSealPrefix(), name_show));
                } else {
                    fVar.cQi.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.yT().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.e(fVar.cQi, d.C0108d.cp_cont_h, 1);
                } else {
                    aj.e(fVar.cQi, d.C0108d.cp_cont_f, 1);
                }
                int level_id = postData.yT().getLevel_id();
                int is_bawu = postData.yT().getIs_bawu();
                String bawu_type = postData.yT().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.fFK.setVisibility(0);
                    aj.c(fVar.fFK, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.fFK.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.fFK.setOnClickListener(null);
                } else {
                    fVar.fFK.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.fFL, d.f.pb_manager);
                        fVar.fFK.setVisibility(8);
                        fVar.fFL.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.fFL, d.f.pb_assist);
                        fVar.fFK.setVisibility(8);
                        fVar.fFL.setVisibility(0);
                    }
                }
                int hi2 = w.hi(postData.yT().getName_show());
                if (hi2 >= 14 && fVar.fFK.getVisibility() == 0 && fVar.fFO.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.yT().getSealPrefix()) || hi2 < 12 || fVar.fFK.getVisibility() != 0 || fVar.fFO.getVisibility() != 0) ? i3 : i3 - 1;
                this.fFu = postData.yT().getIconInfo();
                this.eAh = postData.yT().getTShowInfoNew();
                if (fVar.dUr != null) {
                    fVar.dUr.setTag(d.g.tag_user_id, postData.yT().getUserId());
                    fVar.dUr.setOnClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUO);
                    fVar.dUr.a(this.fFu, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.bcN != null) {
                    fVar.bcN.setOnClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUP);
                    fVar.bcN.a(this.eAh, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.yT() != null && postData.yT().getPendantData() != null && !StringUtils.isNull(postData.yT().getPendantData().xu())) {
                fVar.fFJ.setVisibility(4);
                fVar.fFI.setVisibility(0);
                fVar.fFI.eG(postData.yT().getPendantData().xu());
                fVar.fFI.getHeadView().startLoad(portrait, 28, false);
                fVar.fFI.setTag(d.g.tag_user_id, postData.yT().getUserId());
                fVar.fFI.setTag(d.g.tag_user_name, postData.yT().getUserName());
            } else {
                fVar.fFJ.setVisibility(0);
                fVar.fFI.setVisibility(8);
                fVar.fFJ.setUserId(postData.yT().getUserId());
                fVar.fFJ.setUserName(postData.yT().getUserName());
                fVar.fFJ.setImageDrawable(null);
                fVar.fFJ.startLoad(portrait, 28, false);
            }
            fVar.cQi.setTag(d.g.tag_user_id, postData.yT().getUserId());
            fVar.cQi.setTag(d.g.tag_user_name, postData.yT().getUserName());
            fVar.fFP.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
            if (this.fFq) {
                fVar.fFP.getLayoutStrategy().iQ(d.f.transparent_bg);
            } else {
                fVar.fFP.getLayoutStrategy().iQ(d.f.icon_click);
            }
            fVar.fFP.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bvM();
            }
            if (this.fFw || !this.fFx) {
                fVar.fFP.a(tbRichText, false);
            } else {
                fVar.fFP.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.fFs.aYX() != 0) {
                if (this.fFs.aYX() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.yT().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.fFs != null && this.fFs.aYL() != null && this.fFs.aYL().yT() != null && postData.yT() != null) {
                        userId2 = this.fFs.aYL().yT().getUserId();
                        userId3 = postData.yT().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.yT().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (fVar.fGa != null) {
                                    fVar.fGa.setVisibility(0);
                                    fVar.fGa.setText(d.j.manage);
                                    fVar.fGa.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.fGa != null) {
                                    fVar.fGa.setVisibility(0);
                                    fVar.fGa.setText(d.j.delete);
                                    fVar.fGa.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.fGa != null) {
                                fVar.fGa.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bvJ() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fFs.aYX()));
                                sparseArray2.put(d.g.tag_forbid_user_name, postData.yT().getUserName());
                            } else {
                                sparseArray2.put(d.g.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.g.tag_user_mute_visible, true);
                                sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.yT() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.yT().getUserId());
                                    sparseArray2.put(d.g.tag_user_mute_mute_username, postData.yT().getUserName());
                                }
                                if (this.fFs.aYL() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.fFs.aYL().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fFs.aYX()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bvJ() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.fFA == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.fFA.bDZ();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.yT().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i52 = 1;
                    if (postData.bvJ() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bvJ() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fFA == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.fFs != null) {
                userId2 = this.fFs.aYL().yT().getUserId();
                userId3 = postData.yT().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.yT().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i522 = 1;
                    if (postData.bvJ() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bvJ() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fFA == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.yT().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i5222 = 1;
            if (postData.bvJ() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bvJ() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.fFA == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.fFP.setTextViewOnTouchListener(this.bJO);
        fVar.fFP.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.bfA() == null || e(postData)) {
            fVar.fGk.setVisibility(8);
        } else {
            g.a(postData.bfA(), fVar.fGk, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iO(this.fFz - (i - this.fFy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.fFs == null || this.fFs.aYL() == null || !this.fFs.aYL().zF() || this.fFs.aYL().yF() == null || postData.bvJ() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.fJR != null) {
            if (this.fFA == null) {
                this.fFA = new com.baidu.tieba.vote.a(this.fJR);
            }
            this.fFA.a(view, this.fFs);
        } else if (this.fFA != null) {
            this.fFA.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.cQi.setOnClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUN);
        fVar.fFJ.setOnClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUN);
        fVar.fFI.setOnClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUN);
        fVar.cdM.setOnLongClickListener(this.bkf);
        fVar.fFP.setOnLongClickListener(this.bkf);
        fVar.cdM.setOnTouchListener(this.bJO);
        fVar.fFP.setOnTouchListener(this.bJO);
        fVar.fFP.setOnImageClickListener(this.bJN);
        fVar.fFP.setOnEmotionClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUQ);
        fVar.dUr.setOnClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUO);
        fVar.bcN.setOnClickListener(((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV.fUP);
        fVar.fGk.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fFs = fVar;
    }

    public void sB(int i) {
        this.fFp = i;
    }

    public void jF(boolean z) {
        this.fFq = z;
    }

    public void jG(boolean z) {
        this.fFr = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFv = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJN = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkf = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return k.a((Context) this.fJR.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
