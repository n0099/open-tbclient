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
    private TbRichTextView.h bLF;
    private com.baidu.tieba.pb.a.c bLG;
    private View.OnLongClickListener bmh;
    private ArrayList<IconData> eEr;
    private int fIB;
    private boolean fIC;
    private boolean fID;
    private com.baidu.tieba.pb.data.d fIE;
    private com.baidu.tieba.pb.pb.sub.d fIF;
    private ArrayList<IconData> fIG;
    private View.OnClickListener fIH;
    private boolean fII;
    private final boolean fIJ;
    private int fIK;
    private int fIL;
    private com.baidu.tieba.vote.a fIM;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fIB = 0;
        this.fIC = true;
        this.fID = true;
        this.fIE = null;
        this.mHostId = null;
        this.fIF = null;
        this.fIG = null;
        this.eEr = null;
        this.fIH = null;
        this.mCommonClickListener = null;
        this.bLF = null;
        this.bLG = null;
        this.bmh = null;
        this.fII = false;
        this.fIJ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.e(fVar.fJk, d.C0141d.common_color_10005, 1);
                aj.e(fVar.fJm, d.C0141d.cp_link_tip_c, 3);
                aj.e(fVar.cqi, d.C0141d.cp_cont_f, 1);
                aj.e(fVar.fIW, d.C0141d.cp_cont_i, 1);
                aj.e(fVar.fIX, d.C0141d.cp_cont_i, 1);
                aj.e(fVar.fIY, d.C0141d.cp_cont_d, 1);
                aj.e(fVar.fIZ, d.C0141d.cp_cont_d, 1);
                aj.t(fVar.fJc, d.C0141d.cp_bg_line_e);
                aj.t(fVar.fJd, d.C0141d.cp_bg_line_e);
                aj.c(fVar.fJd, d.C0141d.cp_bg_line_b);
                aj.t(fVar.fJf, d.C0141d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.fIK = getDimensionPixelSize(d.e.ds30);
        this.fIL = l.ao(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.fIC, this.fIB, false);
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
        if (!this.fII && this.fIJ && fVar != null && fVar.fJb.RW() && (listView = ((PbActivity) this.fMQ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fII = true;
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
            aj.t(fVar.fJi, d.C0141d.cp_bg_line_b);
            fVar.fIV.setTag(null);
            fVar.fIV.setUserId(null);
            fVar.cqi.setText((CharSequence) null);
            fVar.fIX.setVisibility(8);
            fVar.fJf.setVisibility(0);
            fVar.fJa.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.chr.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.chr.setTag(sparseArray);
                fVar.fJb.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.fJb, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIC || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.fJb.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.fJb.setLayoutParams(layoutParams);
                fVar.fJb.setPadding(0, 0, 0, 0);
                fVar.fJb.hB(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.fJb.hB(postData.getBimg_url());
                if (postData.bwT() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.fJb.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.fJb.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.fJb.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.fJb.setLayoutParams(layoutParams3);
                }
            }
            fVar.fIZ.setText(am.z(postData.getTime()));
            fVar.fJe.setVisibility(8);
            if (postData.bwT() == 1) {
                aj.t(fVar.fIR, d.C0141d.cp_bg_line_d);
                fVar.fIS.setVisibility(8);
                fVar.fJi.setVisibility(8);
                fVar.chr.setVisibility(8);
                fVar.fIZ.setVisibility(8);
                fVar.fJe.setVisibility(0);
                fVar.fJg.setVisibility(8);
                fVar.fJh.setVisibility(8);
                fVar.fJx.setVisibility(8);
                fVar.fJr.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                fVar.fJe.a(postData.bxc(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIE.bat().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.fJe.onChangeSkinType();
                if (this.fID) {
                    PraiseData zc = this.fIE.bat().zc();
                    if (zc != null && zc.getUser() != null && zc.getUser().size() > 0) {
                        fVar.fJc.setVisibility(0);
                        fVar.fJd.setVisibility(0);
                        fVar.fJc.setIsFromPb(true);
                        fVar.fJc.a(zc, this.fIE.bat().getId(), zc.getPostId(), true);
                        fVar.fJc.gB(this.mSkinType);
                    } else {
                        fVar.fJc.setVisibility(8);
                        fVar.fJd.setVisibility(8);
                    }
                    fVar.fJc.setVisibility(8);
                    fVar.fJd.setVisibility(0);
                } else {
                    fVar.fJc.setVisibility(8);
                    fVar.fJd.setVisibility(8);
                }
                a(fVar.fJb, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.fJi.setVisibility(0);
                aj.t(fVar.fIR, d.C0141d.cp_bg_line_e);
                fVar.fIS.setVisibility(0);
                com.baidu.tbadk.data.f bwX = postData.bwX();
                fVar.fJr.setVisibility(8);
                if (bwX != null && !TextUtils.isEmpty(bwX.getName()) && !TextUtils.isEmpty(bwX.getName().trim())) {
                    final String name = bwX.getName();
                    final String lat = bwX.getLat();
                    final String lng = bwX.getLng();
                    fVar.fJv.setText(bwX.getName());
                    aj.e(fVar.fJv, d.C0141d.cp_cont_c, 1);
                    fVar.fJv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.oJ()) {
                                    e.this.fMQ.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.b.R(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.fJv.setVisibility(8);
                }
                fVar.fJc.setVisibility(8);
                fVar.fJd.setVisibility(8);
                fVar.chr.setVisibility(0);
                fVar.fIZ.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwT()));
                fVar.fIY.setVisibility(0);
                fVar.fIY.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zn().getUserId())) {
                fVar.fJa.setVisibility(0);
                aj.r(fVar.fJa, d.C0141d.cp_link_tip_a);
            } else {
                fVar.fJa.setVisibility(8);
            }
            aj.s(fVar.fIT, d.f.bg_floor_new_middle);
            fVar.fJb.getLayoutStrategy().iK(d.f.pic_video);
            fVar.fJb.setTextColor(aj.getColor(d.C0141d.common_color_10039));
            fVar.fJb.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwT()));
            if (postData.bwY() > 0) {
                if (this.fIF == null) {
                    this.fIF = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIF.setIsFromCDN(this.mIsFromCDN);
                    this.fIF.H(this.fIH);
                    boolean z8 = false;
                    String userId4 = this.fIE.bat().zn().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.fIF.P(this.fIE.baF(), z8);
                    this.fIF.T(this.fIE.bat());
                }
                this.fIF.qK(postData.getId());
                fVar.fJf.setVisibility(0);
                fVar.fJf.a(postData, view);
                fVar.fJf.setChildOnClickListener(this.mCommonClickListener);
                fVar.fJf.setChildOnLongClickListener(this.bmh);
                fVar.fJf.setChildOnTouchListener(this.bLG);
                fVar.fJf.setSubPbAdapter(this.fIF);
                fVar.fJf.setVisibility(0);
                fVar.fJh.setPadding(0, 0, 0, l.t(this.mContext, d.e.ds24));
                fVar.fJx.setVisibility(0);
            } else {
                fVar.fJh.setPadding(0, 0, 0, l.t(this.mContext, d.e.ds40));
                fVar.fJf.setVisibility(8);
                fVar.fJx.setVisibility(8);
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
                    fVar.cqi.setText(af(postData.zn().getSealPrefix(), name_show));
                } else {
                    fVar.cqi.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.zn().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.e(fVar.cqi, d.C0141d.cp_cont_h, 1);
                } else {
                    aj.e(fVar.cqi, d.C0141d.cp_cont_f, 1);
                }
                int level_id = postData.zn().getLevel_id();
                int is_bawu = postData.zn().getIs_bawu();
                String bawu_type = postData.zn().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.fIW.setVisibility(0);
                    aj.c(fVar.fIW, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.fIW.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.fIW.setOnClickListener(null);
                } else {
                    fVar.fIW.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.fIX, d.f.pb_manager);
                        fVar.fIW.setVisibility(8);
                        fVar.fIX.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.fIX, d.f.pb_assist);
                        fVar.fIW.setVisibility(8);
                        fVar.fIX.setVisibility(0);
                    }
                }
                int hs2 = w.hs(postData.zn().getName_show());
                if (hs2 >= 14 && fVar.fIW.getVisibility() == 0 && fVar.fJa.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.zn().getSealPrefix()) || hs2 < 12 || fVar.fIW.getVisibility() != 0 || fVar.fJa.getVisibility() != 0) ? i3 : i3 - 1;
                this.fIG = postData.zn().getIconInfo();
                this.eEr = postData.zn().getTShowInfoNew();
                if (fVar.dXU != null) {
                    fVar.dXU.setTag(d.g.tag_user_id, postData.zn().getUserId());
                    fVar.dXU.setOnClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXP);
                    fVar.dXU.a(this.fIG, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.bes != null) {
                    fVar.bes.setOnClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXQ);
                    fVar.bes.a(this.eEr, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.zn() != null && postData.zn().getPendantData() != null && !StringUtils.isNull(postData.zn().getPendantData().ya())) {
                fVar.fIV.setVisibility(4);
                fVar.fIU.setVisibility(0);
                fVar.fIU.eS(postData.zn().getPendantData().ya());
                fVar.fIU.getHeadView().startLoad(portrait, 28, false);
                fVar.fIU.setTag(d.g.tag_user_id, postData.zn().getUserId());
                fVar.fIU.setTag(d.g.tag_user_name, postData.zn().getUserName());
            } else {
                fVar.fIV.setVisibility(0);
                fVar.fIU.setVisibility(8);
                fVar.fIV.setUserId(postData.zn().getUserId());
                fVar.fIV.setUserName(postData.zn().getUserName());
                fVar.fIV.setImageDrawable(null);
                fVar.fIV.startLoad(portrait, 28, false);
            }
            fVar.cqi.setTag(d.g.tag_user_id, postData.zn().getUserId());
            fVar.cqi.setTag(d.g.tag_user_name, postData.zn().getUserName());
            fVar.fJb.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            if (this.fIC) {
                fVar.fJb.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                fVar.fJb.getLayoutStrategy().iN(d.f.icon_click);
            }
            fVar.fJb.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwW();
            }
            if (this.fII || !this.fIJ) {
                fVar.fJb.a(tbRichText, false);
            } else {
                fVar.fJb.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.fIE.baF() != 0) {
                if (this.fIE.baF() != 1002) {
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
                    if (this.fIE != null && this.fIE.bat() != null && this.fIE.bat().zn() != null && postData.zn() != null) {
                        userId2 = this.fIE.bat().zn().getUserId();
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
                                if (fVar.fJm != null) {
                                    fVar.fJm.setVisibility(0);
                                    fVar.fJm.setText(d.j.manage);
                                    fVar.fJm.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.fJm != null) {
                                    fVar.fJm.setVisibility(0);
                                    fVar.fJm.setText(d.j.delete);
                                    fVar.fJm.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.fJm != null) {
                                fVar.fJm.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bwT() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIE.baF()));
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
                                if (this.fIE.bat() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.fIE.bat().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIE.baF()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bwT() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.fIM == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.fIM.bEO();
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
                    if (postData.bwT() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwT() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fIM == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.fIE != null) {
                userId2 = this.fIE.bat().zn().getUserId();
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
                    if (postData.bwT() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwT() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fIM == null) {
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
            if (postData.bwT() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bwT() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.fIM == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.fJb.setTextViewOnTouchListener(this.bLG);
        fVar.fJb.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.bgZ() == null || e(postData)) {
            fVar.fJw.setVisibility(8);
        } else {
            g.a(postData.bgZ(), fVar.fJw, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iL(this.fIL - (i - this.fIK));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.fIE == null || this.fIE.bat() == null || !this.fIE.bat().zZ() || this.fIE.bat().yZ() == null || postData.bwT() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.fMQ != null) {
            if (this.fIM == null) {
                this.fIM = new com.baidu.tieba.vote.a(this.fMQ);
            }
            this.fIM.a(view, this.fIE);
        } else if (this.fIM != null) {
            this.fIM.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.cqi.setOnClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXO);
        fVar.fIV.setOnClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXO);
        fVar.fIU.setOnClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXO);
        fVar.chr.setOnLongClickListener(this.bmh);
        fVar.fJb.setOnLongClickListener(this.bmh);
        fVar.chr.setOnTouchListener(this.bLG);
        fVar.fJb.setOnTouchListener(this.bLG);
        fVar.fJb.setOnImageClickListener(this.bLF);
        fVar.fJb.setOnEmotionClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXR);
        fVar.dXU.setOnClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXP);
        fVar.bes.setOnClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXQ);
        fVar.fJw.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIE = dVar;
    }

    public void sF(int i) {
        this.fIB = i;
    }

    public void jP(boolean z) {
        this.fIC = z;
    }

    public void jQ(boolean z) {
        this.fID = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIH = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLF = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmh = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str));
            return com.baidu.tieba.card.j.a((Context) this.fMQ.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
