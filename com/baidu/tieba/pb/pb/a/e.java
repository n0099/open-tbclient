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
import com.baidu.tieba.card.j;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.view.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e extends k<PostData, f> implements View.OnClickListener {
    private TbRichTextView.h bLS;
    private com.baidu.tieba.pb.a.c bLT;
    private View.OnLongClickListener bmu;
    private ArrayList<IconData> eED;
    private int fIM;
    private boolean fIN;
    private boolean fIO;
    private com.baidu.tieba.pb.data.d fIP;
    private com.baidu.tieba.pb.pb.sub.d fIQ;
    private ArrayList<IconData> fIR;
    private View.OnClickListener fIS;
    private boolean fIT;
    private final boolean fIU;
    private int fIV;
    private int fIW;
    private com.baidu.tieba.vote.a fIX;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fIM = 0;
        this.fIN = true;
        this.fIO = true;
        this.fIP = null;
        this.mHostId = null;
        this.fIQ = null;
        this.fIR = null;
        this.eED = null;
        this.fIS = null;
        this.mCommonClickListener = null;
        this.bLS = null;
        this.bLT = null;
        this.bmu = null;
        this.fIT = false;
        this.fIU = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.e(fVar.fJv, d.C0140d.common_color_10005, 1);
                aj.e(fVar.fJx, d.C0140d.cp_link_tip_c, 3);
                aj.e(fVar.cqu, d.C0140d.cp_cont_f, 1);
                aj.e(fVar.fJh, d.C0140d.cp_cont_i, 1);
                aj.e(fVar.fJi, d.C0140d.cp_cont_i, 1);
                aj.e(fVar.fJj, d.C0140d.cp_cont_d, 1);
                aj.e(fVar.fJk, d.C0140d.cp_cont_d, 1);
                aj.t(fVar.fJn, d.C0140d.cp_bg_line_e);
                aj.t(fVar.fJo, d.C0140d.cp_bg_line_e);
                aj.c(fVar.fJo, d.C0140d.cp_bg_line_b);
                aj.t(fVar.fJq, d.C0140d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.fIV = getDimensionPixelSize(d.e.ds30);
        this.fIW = l.ao(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.fIN, this.fIM, false);
        a(fVar);
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, f fVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, fVar);
        a(fVar);
        c(fVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.Ai();
            a(fVar, postData2, view, i);
        }
        if (!this.fIT && this.fIU && fVar != null && fVar.fJm.RX() && (listView = ((PbActivity) this.fNb.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fIT = true;
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
            aj.t(fVar.fJt, d.C0140d.cp_bg_line_b);
            fVar.fJg.setTag(null);
            fVar.fJg.setUserId(null);
            fVar.cqu.setText((CharSequence) null);
            fVar.fJi.setVisibility(8);
            fVar.fJq.setVisibility(0);
            fVar.fJl.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.chD.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.chD.setTag(sparseArray);
                fVar.fJm.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.fJm, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIN || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.fJm.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.fJm.setLayoutParams(layoutParams);
                fVar.fJm.setPadding(0, 0, 0, 0);
                fVar.fJm.hB(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.fJm.hB(postData.getBimg_url());
                if (postData.bwU() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.fJm.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.fJm.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.fJm.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.fJm.setLayoutParams(layoutParams3);
                }
            }
            fVar.fJk.setText(am.z(postData.getTime()));
            fVar.fJp.setVisibility(8);
            if (postData.bwU() == 1) {
                aj.t(fVar.fJc, d.C0140d.cp_bg_line_d);
                fVar.fJd.setVisibility(8);
                fVar.fJt.setVisibility(8);
                fVar.chD.setVisibility(8);
                fVar.fJk.setVisibility(8);
                fVar.fJp.setVisibility(0);
                fVar.fJr.setVisibility(8);
                fVar.fJs.setVisibility(8);
                fVar.fJI.setVisibility(8);
                fVar.fJC.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                fVar.fJp.a(postData.bxd(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIP.bau().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.fJp.onChangeSkinType();
                if (this.fIO) {
                    PraiseData zc = this.fIP.bau().zc();
                    if (zc != null && zc.getUser() != null && zc.getUser().size() > 0) {
                        fVar.fJn.setVisibility(0);
                        fVar.fJo.setVisibility(0);
                        fVar.fJn.setIsFromPb(true);
                        fVar.fJn.a(zc, this.fIP.bau().getId(), zc.getPostId(), true);
                        fVar.fJn.gB(this.mSkinType);
                    } else {
                        fVar.fJn.setVisibility(8);
                        fVar.fJo.setVisibility(8);
                    }
                    fVar.fJn.setVisibility(8);
                    fVar.fJo.setVisibility(0);
                } else {
                    fVar.fJn.setVisibility(8);
                    fVar.fJo.setVisibility(8);
                }
                a(fVar.fJm, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.fJt.setVisibility(0);
                aj.t(fVar.fJc, d.C0140d.cp_bg_line_e);
                fVar.fJd.setVisibility(0);
                com.baidu.tbadk.data.f bwY = postData.bwY();
                fVar.fJC.setVisibility(8);
                if (bwY != null && !TextUtils.isEmpty(bwY.getName()) && !TextUtils.isEmpty(bwY.getName().trim())) {
                    final String name = bwY.getName();
                    final String lat = bwY.getLat();
                    final String lng = bwY.getLng();
                    fVar.fJG.setText(bwY.getName());
                    aj.e(fVar.fJG, d.C0140d.cp_cont_c, 1);
                    fVar.fJG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.oJ()) {
                                    e.this.fNb.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.b.R(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.fJG.setVisibility(8);
                }
                fVar.fJn.setVisibility(8);
                fVar.fJo.setVisibility(8);
                fVar.chD.setVisibility(0);
                fVar.fJk.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwU()));
                fVar.fJj.setVisibility(0);
                fVar.fJj.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zn().getUserId())) {
                fVar.fJl.setVisibility(0);
                aj.r(fVar.fJl, d.C0140d.cp_link_tip_a);
            } else {
                fVar.fJl.setVisibility(8);
            }
            aj.s(fVar.fJe, d.f.bg_floor_new_middle);
            fVar.fJm.getLayoutStrategy().iK(d.f.pic_video);
            fVar.fJm.setTextColor(aj.getColor(d.C0140d.common_color_10039));
            fVar.fJm.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwU()));
            if (postData.bwZ() > 0) {
                if (this.fIQ == null) {
                    this.fIQ = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIQ.setIsFromCDN(this.mIsFromCDN);
                    this.fIQ.H(this.fIS);
                    boolean z8 = false;
                    String userId4 = this.fIP.bau().zn().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.fIQ.P(this.fIP.baG(), z8);
                    this.fIQ.T(this.fIP.bau());
                }
                this.fIQ.qK(postData.getId());
                fVar.fJq.setVisibility(0);
                fVar.fJq.a(postData, view);
                fVar.fJq.setChildOnClickListener(this.mCommonClickListener);
                fVar.fJq.setChildOnLongClickListener(this.bmu);
                fVar.fJq.setChildOnTouchListener(this.bLT);
                fVar.fJq.setSubPbAdapter(this.fIQ);
                fVar.fJq.setVisibility(0);
                fVar.fJs.setPadding(0, 0, 0, l.t(this.mContext, d.e.ds24));
                fVar.fJI.setVisibility(0);
            } else {
                fVar.fJs.setPadding(0, 0, 0, l.t(this.mContext, d.e.ds40));
                fVar.fJq.setVisibility(8);
                fVar.fJI.setVisibility(8);
            }
            String portrait = postData.zn().getPortrait();
            if (postData.zn() != null) {
                String name_show = postData.zn().getName_show();
                int i2 = 0;
                if (!StringUtils.isNull(postData.zn().getSealPrefix())) {
                    i2 = w.hs(postData.zn().getSealPrefix()) + 2;
                }
                int hs = w.hs(name_show);
                if (i2 > 0) {
                    if (hs > 12) {
                        name_show = w.j(name_show, 0, 14) + "...";
                    }
                } else if (hs > 14) {
                    name_show = w.j(name_show, 0, 14) + "...";
                }
                if (i2 > 0) {
                    fVar.cqu.setText(af(postData.zn().getSealPrefix(), name_show));
                } else {
                    fVar.cqu.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.zn().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.e(fVar.cqu, d.C0140d.cp_cont_h, 1);
                } else {
                    aj.e(fVar.cqu, d.C0140d.cp_cont_f, 1);
                }
                int level_id = postData.zn().getLevel_id();
                int is_bawu = postData.zn().getIs_bawu();
                String bawu_type = postData.zn().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.fJh.setVisibility(0);
                    aj.c(fVar.fJh, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.fJh.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.fJh.setOnClickListener(null);
                } else {
                    fVar.fJh.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.fJi, d.f.pb_manager);
                        fVar.fJh.setVisibility(8);
                        fVar.fJi.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.fJi, d.f.pb_assist);
                        fVar.fJh.setVisibility(8);
                        fVar.fJi.setVisibility(0);
                    }
                }
                int hs2 = w.hs(postData.zn().getName_show());
                if (hs2 >= 14 && fVar.fJh.getVisibility() == 0 && fVar.fJl.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.zn().getSealPrefix()) || hs2 < 12 || fVar.fJh.getVisibility() != 0 || fVar.fJl.getVisibility() != 0) ? i3 : i3 - 1;
                this.fIR = postData.zn().getIconInfo();
                this.eED = postData.zn().getTShowInfoNew();
                if (fVar.dYg != null) {
                    fVar.dYg.setTag(d.g.tag_user_id, postData.zn().getUserId());
                    fVar.dYg.setOnClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fYa);
                    fVar.dYg.a(this.fIR, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.beF != null) {
                    fVar.beF.setOnClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fYb);
                    fVar.beF.a(this.eED, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.zn() != null && postData.zn().getPendantData() != null && !StringUtils.isNull(postData.zn().getPendantData().ya())) {
                fVar.fJg.setVisibility(4);
                fVar.fJf.setVisibility(0);
                fVar.fJf.eS(postData.zn().getPendantData().ya());
                fVar.fJf.getHeadView().startLoad(portrait, 28, false);
                fVar.fJf.setTag(d.g.tag_user_id, postData.zn().getUserId());
                fVar.fJf.setTag(d.g.tag_user_name, postData.zn().getUserName());
            } else {
                fVar.fJg.setVisibility(0);
                fVar.fJf.setVisibility(8);
                fVar.fJg.setUserId(postData.zn().getUserId());
                fVar.fJg.setUserName(postData.zn().getUserName());
                fVar.fJg.setImageDrawable(null);
                fVar.fJg.startLoad(portrait, 28, false);
            }
            fVar.cqu.setTag(d.g.tag_user_id, postData.zn().getUserId());
            fVar.cqu.setTag(d.g.tag_user_name, postData.zn().getUserName());
            fVar.fJm.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
            if (this.fIN) {
                fVar.fJm.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                fVar.fJm.getLayoutStrategy().iN(d.f.icon_click);
            }
            fVar.fJm.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwX();
            }
            if (this.fIT || !this.fIU) {
                fVar.fJm.a(tbRichText, false);
            } else {
                fVar.fJm.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.fIP.baG() != 0) {
                if (this.fIP.baG() != 1002) {
                    z9 = true;
                }
                z10 = true;
                String userId5 = postData.zn().getUserId();
                if (userId5 != null && userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
                if (userId5 == null || userId5.equals("0") || userId5.length() == 0) {
                    z = false;
                    z2 = true;
                    if (this.fIP != null && this.fIP.bau() != null && this.fIP.bau().zn() != null && postData.zn() != null) {
                        userId2 = this.fIP.bau().zn().getUserId();
                        userId3 = postData.zn().getUserId();
                        if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z4 = true;
                            if (!StringUtils.isNull(userId3) || !userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z3 = true;
                                z5 = false;
                            } else {
                                z3 = false;
                                z5 = true;
                            }
                            userId = postData.zn().getUserId();
                            if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                                z6 = true;
                                z7 = true;
                            } else {
                                z6 = z4;
                                z7 = z5;
                            }
                            if (!z) {
                                if (fVar.fJx != null) {
                                    fVar.fJx.setVisibility(0);
                                    fVar.fJx.setText(d.j.manage);
                                    fVar.fJx.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.fJx != null) {
                                    fVar.fJx.setVisibility(0);
                                    fVar.fJx.setText(d.j.delete);
                                    fVar.fJx.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.fJx != null) {
                                fVar.fJx.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bwU() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIP.baG()));
                                sparseArray2.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                            } else {
                                sparseArray2.put(d.g.tag_should_manage_visible, false);
                            }
                            if (!z3) {
                                sparseArray2.put(d.g.tag_user_mute_visible, true);
                                sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                if (postData.zn() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                                    sparseArray2.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                                }
                                if (this.fIP.bau() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.fIP.bau().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIP.baG()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bwU() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.fIX == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.fIX.bEP();
                                return;
                            }
                            return;
                        }
                    }
                    z3 = false;
                    z4 = z2;
                    z5 = false;
                    userId = postData.zn().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i52 = 1;
                    if (postData.bwU() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwU() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fIX == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.fIP != null) {
                userId2 = this.fIP.bau().zn().getUserId();
                userId3 = postData.zn().getUserId();
                if (!StringUtils.isNull(userId2)) {
                    z4 = true;
                    if (!StringUtils.isNull(userId3)) {
                    }
                    z3 = true;
                    z5 = false;
                    userId = postData.zn().getUserId();
                    if (userId == null) {
                    }
                    z6 = z4;
                    z7 = z5;
                    if (!z) {
                    }
                    int i522 = 1;
                    if (postData.bwU() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwU() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fIX == null) {
                    }
                }
            }
            z3 = false;
            z4 = z2;
            z5 = false;
            userId = postData.zn().getUserId();
            if (userId == null) {
            }
            z6 = z4;
            z7 = z5;
            if (!z) {
            }
            int i5222 = 1;
            if (postData.bwU() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bwU() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.fIX == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.fJm.setTextViewOnTouchListener(this.bLT);
        fVar.fJm.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.bha() == null || e(postData)) {
            fVar.fJH.setVisibility(8);
        } else {
            g.a(postData.bha(), fVar.fJH, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iL(this.fIW - (i - this.fIV));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.fIP == null || this.fIP.bau() == null || !this.fIP.bau().zZ() || this.fIP.bau().yZ() == null || postData.bwU() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.fNb != null) {
            if (this.fIX == null) {
                this.fIX = new com.baidu.tieba.vote.a(this.fNb);
            }
            this.fIX.a(view, this.fIP);
        } else if (this.fIX != null) {
            this.fIX.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.cqu.setOnClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fXZ);
        fVar.fJg.setOnClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fXZ);
        fVar.fJf.setOnClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fXZ);
        fVar.chD.setOnLongClickListener(this.bmu);
        fVar.fJm.setOnLongClickListener(this.bmu);
        fVar.chD.setOnTouchListener(this.bLT);
        fVar.fJm.setOnTouchListener(this.bLT);
        fVar.fJm.setOnImageClickListener(this.bLS);
        fVar.fJm.setOnEmotionClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fYc);
        fVar.dYg.setOnClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fYa);
        fVar.beF.setOnClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fYb);
        fVar.fJH.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIP = dVar;
    }

    public void sE(int i) {
        this.fIM = i;
    }

    public void jP(boolean z) {
        this.fIN = z;
    }

    public void jQ(boolean z) {
        this.fIO = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIS = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLS = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmu = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str));
            return com.baidu.tieba.card.j.a((Context) this.fNb.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
