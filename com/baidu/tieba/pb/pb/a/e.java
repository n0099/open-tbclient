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
    private TbRichTextView.h bLI;
    private com.baidu.tieba.pb.a.c bLJ;
    private View.OnLongClickListener bmk;
    private ArrayList<IconData> eEH;
    private int fIR;
    private boolean fIS;
    private boolean fIT;
    private com.baidu.tieba.pb.data.d fIU;
    private com.baidu.tieba.pb.pb.sub.d fIV;
    private ArrayList<IconData> fIW;
    private View.OnClickListener fIX;
    private boolean fIY;
    private final boolean fIZ;
    private int fJa;
    private int fJb;
    private com.baidu.tieba.vote.a fJc;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fIR = 0;
        this.fIS = true;
        this.fIT = true;
        this.fIU = null;
        this.mHostId = null;
        this.fIV = null;
        this.fIW = null;
        this.eEH = null;
        this.fIX = null;
        this.mCommonClickListener = null;
        this.bLI = null;
        this.bLJ = null;
        this.bmk = null;
        this.fIY = false;
        this.fIZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                aj.e(fVar.fJA, d.C0141d.common_color_10005, 1);
                aj.e(fVar.fJC, d.C0141d.cp_link_tip_c, 3);
                aj.e(fVar.cql, d.C0141d.cp_cont_f, 1);
                aj.e(fVar.fJm, d.C0141d.cp_cont_i, 1);
                aj.e(fVar.fJn, d.C0141d.cp_cont_i, 1);
                aj.e(fVar.fJo, d.C0141d.cp_cont_d, 1);
                aj.e(fVar.fJp, d.C0141d.cp_cont_d, 1);
                aj.t(fVar.fJs, d.C0141d.cp_bg_line_e);
                aj.t(fVar.fJt, d.C0141d.cp_bg_line_e);
                aj.c(fVar.fJt, d.C0141d.cp_bg_line_b);
                aj.t(fVar.fJv, d.C0141d.cp_bg_line_c);
            }
            fVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.fJa = getDimensionPixelSize(d.e.ds30);
        this.fJb = l.ao(this.mContext) - getDimensionPixelSize(d.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public f onCreateViewHolder(ViewGroup viewGroup) {
        f fVar = new f(LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_item, viewGroup, false), this.fIS, this.fIR, false);
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
        if (!this.fIY && this.fIZ && fVar != null && fVar.fJr.RX() && (listView = ((PbActivity) this.fNg.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fIY = true;
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
            aj.t(fVar.fJy, d.C0141d.cp_bg_line_b);
            fVar.fJl.setTag(null);
            fVar.fJl.setUserId(null);
            fVar.cql.setText((CharSequence) null);
            fVar.fJn.setVisibility(8);
            fVar.fJv.setVisibility(0);
            fVar.fJq.setVisibility(8);
            SparseArray sparseArray = (SparseArray) fVar.chu.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                fVar.chu.setTag(sparseArray);
                fVar.fJr.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(fVar.fJr, getDimensionPixelSize(d.e.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIS || e(postData)) {
                sparseArray.put(d.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.fJr.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                fVar.fJr.setLayoutParams(layoutParams);
                fVar.fJr.setPadding(0, 0, 0, 0);
                fVar.fJr.hB(null);
            } else {
                sparseArray.put(d.g.tag_richtext_bg, postData.getBimg_url());
                fVar.fJr.hB(postData.getBimg_url());
                if (postData.bwY() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.fJr.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds40);
                    fVar.fJr.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fVar.fJr.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.e.ds20);
                    fVar.fJr.setLayoutParams(layoutParams3);
                }
            }
            fVar.fJp.setText(am.z(postData.getTime()));
            fVar.fJu.setVisibility(8);
            if (postData.bwY() == 1) {
                aj.t(fVar.fJh, d.C0141d.cp_bg_line_d);
                fVar.fJi.setVisibility(8);
                fVar.fJy.setVisibility(8);
                fVar.chu.setVisibility(8);
                fVar.fJp.setVisibility(8);
                fVar.fJu.setVisibility(0);
                fVar.fJw.setVisibility(8);
                fVar.fJx.setVisibility(8);
                fVar.fJN.setVisibility(8);
                fVar.fJH.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                fVar.fJu.a(postData.bxh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIU.bau().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                fVar.fJu.onChangeSkinType();
                if (this.fIT) {
                    PraiseData zc = this.fIU.bau().zc();
                    if (zc != null && zc.getUser() != null && zc.getUser().size() > 0) {
                        fVar.fJs.setVisibility(0);
                        fVar.fJt.setVisibility(0);
                        fVar.fJs.setIsFromPb(true);
                        fVar.fJs.a(zc, this.fIU.bau().getId(), zc.getPostId(), true);
                        fVar.fJs.gB(this.mSkinType);
                    } else {
                        fVar.fJs.setVisibility(8);
                        fVar.fJt.setVisibility(8);
                    }
                    fVar.fJs.setVisibility(8);
                    fVar.fJt.setVisibility(0);
                } else {
                    fVar.fJs.setVisibility(8);
                    fVar.fJt.setVisibility(8);
                }
                a(fVar.fJr, getDimensionPixelSize(d.e.ds30));
            } else {
                fVar.fJy.setVisibility(0);
                aj.t(fVar.fJh, d.C0141d.cp_bg_line_e);
                fVar.fJi.setVisibility(0);
                com.baidu.tbadk.data.f bxc = postData.bxc();
                fVar.fJH.setVisibility(8);
                if (bxc != null && !TextUtils.isEmpty(bxc.getName()) && !TextUtils.isEmpty(bxc.getName().trim())) {
                    final String name = bxc.getName();
                    final String lat = bxc.getLat();
                    final String lng = bxc.getLng();
                    fVar.fJL.setText(bxc.getName());
                    aj.e(fVar.fJL, d.C0141d.cp_cont_c, 1);
                    fVar.fJL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!j.oJ()) {
                                    e.this.fNg.showToast(d.j.neterror);
                                } else {
                                    com.baidu.tbadk.browser.b.R(e.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, e.this.mContext.getString(d.j.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    fVar.fJL.setVisibility(8);
                }
                fVar.fJs.setVisibility(8);
                fVar.fJt.setVisibility(8);
                fVar.chu.setVisibility(0);
                fVar.fJp.setVisibility(0);
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwY()));
                fVar.fJo.setVisibility(0);
                fVar.fJo.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.zn().getUserId())) {
                fVar.fJq.setVisibility(0);
                aj.r(fVar.fJq, d.C0141d.cp_link_tip_a);
            } else {
                fVar.fJq.setVisibility(8);
            }
            aj.s(fVar.fJj, d.f.bg_floor_new_middle);
            fVar.fJr.getLayoutStrategy().iK(d.f.pic_video);
            fVar.fJr.setTextColor(aj.getColor(d.C0141d.common_color_10039));
            fVar.fJr.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwY()));
            if (postData.bxd() > 0) {
                if (this.fIV == null) {
                    this.fIV = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fIV.setIsFromCDN(this.mIsFromCDN);
                    this.fIV.H(this.fIX);
                    boolean z8 = false;
                    String userId4 = this.fIU.bau().zn().getUserId();
                    if (userId4 != null && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z8 = true;
                    }
                    this.fIV.P(this.fIU.baG(), z8);
                    this.fIV.T(this.fIU.bau());
                }
                this.fIV.qK(postData.getId());
                fVar.fJv.setVisibility(0);
                fVar.fJv.a(postData, view);
                fVar.fJv.setChildOnClickListener(this.mCommonClickListener);
                fVar.fJv.setChildOnLongClickListener(this.bmk);
                fVar.fJv.setChildOnTouchListener(this.bLJ);
                fVar.fJv.setSubPbAdapter(this.fIV);
                fVar.fJv.setVisibility(0);
                fVar.fJx.setPadding(0, 0, 0, l.t(this.mContext, d.e.ds24));
                fVar.fJN.setVisibility(0);
            } else {
                fVar.fJx.setPadding(0, 0, 0, l.t(this.mContext, d.e.ds40));
                fVar.fJv.setVisibility(8);
                fVar.fJN.setVisibility(8);
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
                    fVar.cql.setText(af(postData.zn().getSealPrefix(), name_show));
                } else {
                    fVar.cql.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.zn().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aj.e(fVar.cql, d.C0141d.cp_cont_h, 1);
                } else {
                    aj.e(fVar.cql, d.C0141d.cp_cont_f, 1);
                }
                int level_id = postData.zn().getLevel_id();
                int is_bawu = postData.zn().getIs_bawu();
                String bawu_type = postData.zn().getBawu_type();
                int i3 = 4;
                if (level_id != 0) {
                    fVar.fJm.setVisibility(0);
                    aj.c(fVar.fJm, BitmapHelper.getGradeResourceIdNew(level_id));
                    fVar.fJm.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(level_id)));
                    fVar.fJm.setOnClickListener(null);
                } else {
                    fVar.fJm.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aj.c(fVar.fJn, d.f.pb_manager);
                        fVar.fJm.setVisibility(8);
                        fVar.fJn.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aj.c(fVar.fJn, d.f.pb_assist);
                        fVar.fJm.setVisibility(8);
                        fVar.fJn.setVisibility(0);
                    }
                }
                int hs2 = w.hs(postData.zn().getName_show());
                if (hs2 >= 14 && fVar.fJm.getVisibility() == 0 && fVar.fJq.getVisibility() == 0) {
                    i3 = 3;
                }
                int i4 = (StringUtils.isNull(postData.zn().getSealPrefix()) || hs2 < 12 || fVar.fJm.getVisibility() != 0 || fVar.fJq.getVisibility() != 0) ? i3 : i3 - 1;
                this.fIW = postData.zn().getIconInfo();
                this.eEH = postData.zn().getTShowInfoNew();
                if (fVar.dYa != null) {
                    fVar.dYa.setTag(d.g.tag_user_id, postData.zn().getUserId());
                    fVar.dYa.setOnClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYf);
                    fVar.dYa.a(this.fIW, i4, getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds30), getDimensionPixelSize(d.e.ds10));
                }
                if (fVar.bew != null) {
                    fVar.bew.setOnClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYg);
                    fVar.bew.a(this.eEH, 3, getDimensionPixelSize(d.e.ds36), getDimensionPixelSize(d.e.ds32), getDimensionPixelSize(d.e.ds8), true);
                }
            }
            if (postData != null && postData.zn() != null && postData.zn().getPendantData() != null && !StringUtils.isNull(postData.zn().getPendantData().ya())) {
                fVar.fJl.setVisibility(4);
                fVar.fJk.setVisibility(0);
                fVar.fJk.eS(postData.zn().getPendantData().ya());
                fVar.fJk.getHeadView().startLoad(portrait, 28, false);
                fVar.fJk.setTag(d.g.tag_user_id, postData.zn().getUserId());
                fVar.fJk.setTag(d.g.tag_user_name, postData.zn().getUserName());
            } else {
                fVar.fJl.setVisibility(0);
                fVar.fJk.setVisibility(8);
                fVar.fJl.setUserId(postData.zn().getUserId());
                fVar.fJl.setUserName(postData.zn().getUserName());
                fVar.fJl.setImageDrawable(null);
                fVar.fJl.startLoad(portrait, 28, false);
            }
            fVar.cql.setTag(d.g.tag_user_id, postData.zn().getUserId());
            fVar.cql.setTag(d.g.tag_user_name, postData.zn().getUserName());
            fVar.fJr.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            if (this.fIS) {
                fVar.fJr.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                fVar.fJr.getLayoutStrategy().iN(d.f.icon_click);
            }
            fVar.fJr.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bxb();
            }
            if (this.fIY || !this.fIZ) {
                fVar.fJr.a(tbRichText, false);
            } else {
                fVar.fJr.a(tbRichText, true);
            }
            boolean z9 = false;
            boolean z10 = false;
            if (this.fIU.baG() != 0) {
                if (this.fIU.baG() != 1002) {
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
                    if (this.fIU != null && this.fIU.bau() != null && this.fIU.bau().zn() != null && postData.zn() != null) {
                        userId2 = this.fIU.bau().zn().getUserId();
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
                                if (fVar.fJC != null) {
                                    fVar.fJC.setVisibility(0);
                                    fVar.fJC.setText(d.j.manage);
                                    fVar.fJC.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (z6) {
                                if (fVar.fJC != null) {
                                    fVar.fJC.setVisibility(0);
                                    fVar.fJC.setText(d.j.delete);
                                    fVar.fJC.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.f.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            } else if (fVar.fJC != null) {
                                fVar.fJC.setVisibility(8);
                            }
                            int i5 = 1;
                            if (postData.bwY() == 1) {
                                i5 = 0;
                            }
                            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                            if (!z) {
                                sparseArray2.put(d.g.tag_should_manage_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIU.baG()));
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
                                if (this.fIU.bau() != null) {
                                    sparseArray2.put(d.g.tag_user_mute_thread_id, this.fIU.bau().getId());
                                }
                                sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_user_mute_visible, false);
                            }
                            if (!z6) {
                                sparseArray2.put(d.g.tag_should_delete_visible, true);
                                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fIU.baG()));
                                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                            } else {
                                sparseArray2.put(d.g.tag_should_delete_visible, false);
                            }
                            a(fVar, postData, postData.bwY() != 1, tbRichText);
                            b(fVar);
                            a(view, postData);
                            if (this.fJc == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                                this.fJc.bET();
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
                    if (postData.bwY() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwY() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fJc == null) {
                        return;
                    }
                    return;
                }
            }
            boolean z11 = z10;
            z = z9;
            z2 = z11;
            if (this.fIU != null) {
                userId2 = this.fIU.bau().zn().getUserId();
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
                    if (postData.bwY() == 1) {
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z6) {
                    }
                    a(fVar, postData, postData.bwY() != 1, tbRichText);
                    b(fVar);
                    a(view, postData);
                    if (this.fJc == null) {
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
            if (postData.bwY() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            a(fVar, postData, postData.bwY() != 1, tbRichText);
            b(fVar);
            a(view, postData);
            if (this.fJc == null) {
            }
        }
    }

    private void b(f fVar) {
        fVar.fJr.setTextViewOnTouchListener(this.bLJ);
        fVar.fJr.setTextViewCheckSelection(false);
    }

    private void a(f fVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.bha() == null || e(postData)) {
            fVar.fJM.setVisibility(8);
        } else {
            g.a(postData.bha(), fVar.fJM, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iL(this.fJb - (i - this.fJa));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.fIU == null || this.fIU.bau() == null || !this.fIU.bau().zZ() || this.fIU.bau().yZ() == null || postData.bwY() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.fNg != null) {
            if (this.fJc == null) {
                this.fJc = new com.baidu.tieba.vote.a(this.fNg);
            }
            this.fJc.a(view, this.fIU);
        } else if (this.fJc != null) {
            this.fJc.setVisibility(8);
        }
    }

    private void c(f fVar) {
        fVar.cql.setOnClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYe);
        fVar.fJl.setOnClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYe);
        fVar.fJk.setOnClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYe);
        fVar.chu.setOnLongClickListener(this.bmk);
        fVar.fJr.setOnLongClickListener(this.bmk);
        fVar.chu.setOnTouchListener(this.bLJ);
        fVar.fJr.setOnTouchListener(this.bLJ);
        fVar.fJr.setOnImageClickListener(this.bLI);
        fVar.fJr.setOnEmotionClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYh);
        fVar.dYa.setOnClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYf);
        fVar.bew.setOnClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYg);
        fVar.fJM.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIU = dVar;
    }

    public void sF(int i) {
        this.fIR = i;
    }

    public void jU(boolean z) {
        this.fIS = z;
    }

    public void jV(boolean z) {
        this.fIT = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIX = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLI = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmk = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str));
            return com.baidu.tieba.card.j.a((Context) this.fNg.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
