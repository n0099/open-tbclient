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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends l<PostData, h> implements View.OnClickListener {
    private TbRichTextView.e aRN;
    private com.baidu.tieba.pb.a.c aRO;
    private View.OnLongClickListener awo;
    private View.OnClickListener cNL;
    private ArrayList<IconData> drx;
    private int eHn;
    private boolean eHo;
    private boolean eHp;
    private com.baidu.tieba.pb.data.f eHq;
    private com.baidu.tieba.pb.pb.sub.d eHr;
    private ArrayList<IconData> eHs;
    private View.OnClickListener eHt;
    private boolean eHu;
    private final boolean eHv;
    private int eHw;
    private int eHx;
    private com.baidu.tieba.vote.a eHy;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eHn = 0;
        this.eHo = true;
        this.eHp = true;
        this.eHq = null;
        this.mHostId = null;
        this.eHr = null;
        this.eHs = null;
        this.drx = null;
        this.eHt = null;
        this.cNL = null;
        this.aRN = null;
        this.aRO = null;
        this.awo = null;
        this.eHu = false;
        this.eHv = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ai.c(hVar.eHX, d.e.common_color_10005, 1);
                ai.c(hVar.eHZ, d.e.cp_link_tip_c, 3);
                ai.c(hVar.bHa, d.e.cp_cont_f, 1);
                ai.c((View) hVar.eHI, d.e.cp_cont_i, 1);
                ai.c((View) hVar.eHJ, d.e.cp_cont_i, 1);
                ai.c(hVar.eHK, d.e.cp_cont_d, 1);
                ai.c(hVar.eHL, d.e.cp_cont_d, 1);
                ai.k(hVar.eHO, d.e.cp_bg_line_e);
                ai.k(hVar.eHP, d.e.cp_bg_line_e);
                ai.c(hVar.eHP, d.e.cp_bg_line_b);
                ai.k(hVar.eHS, d.e.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eHw = getDimensionPixelSize(d.f.ds30);
        this.eHx = k.ag(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.eHo, this.eHn, false);
        a(hVar);
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, h hVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, hVar);
        a(hVar);
        c(hVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sD();
            a(hVar, postData2, view, i);
        }
        if (!this.eHu && this.eHv && hVar != null && hVar.eHN.Jb() && (listView = ((PbActivity) this.eIu.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eHu = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x084a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0a70  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0aad  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0ab9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0ac5  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0ad1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(h hVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (hVar != null && postData != null) {
            ai.k(hVar.eHV, d.e.cp_bg_line_b);
            hVar.eHH.setTag(null);
            hVar.eHH.setUserId(null);
            hVar.bHa.setText((CharSequence) null);
            hVar.eHJ.setVisibility(8);
            hVar.eHS.setVisibility(0);
            hVar.eHM.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.eHR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.eHR.setTag(sparseArray);
                hVar.eHN.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(hVar.eHN, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHo || g(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eHN.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eHN.setLayoutParams(layoutParams);
                hVar.eHN.setPadding(0, 0, 0, 0);
                hVar.eHN.ha(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                hVar.eHN.ha(postData.getBimg_url());
                if (postData.btg() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eHN.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    hVar.eHN.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eHN.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    hVar.eHN.setLayoutParams(layoutParams3);
                }
            }
            hVar.eHL.setText(al.r(postData.getTime()));
            hVar.eHQ.setVisibility(8);
            if (postData.btg() == 1) {
                ai.k(hVar.eHD, d.e.cp_bg_line_d);
                hVar.eHE.setVisibility(8);
                hVar.eHV.setVisibility(8);
                hVar.eHR.setVisibility(8);
                hVar.eHL.setVisibility(8);
                hVar.eHQ.setVisibility(0);
                hVar.eHT.setVisibility(8);
                hVar.eHU.setVisibility(8);
                hVar.eIk.setVisibility(8);
                hVar.eIe.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                hVar.eHQ.a(postData.btn(), str, str2, j, com.baidu.adp.lib.g.b.d(this.eHq.aPQ().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                hVar.eHQ.onChangeSkinType();
                if (this.eHp) {
                    PraiseData rv = this.eHq.aPQ().rv();
                    if (rv != null && rv.getUser() != null && rv.getUser().size() > 0) {
                        hVar.eHO.setVisibility(0);
                        hVar.eHP.setVisibility(0);
                        hVar.eHO.setIsFromPb(true);
                        hVar.eHO.a(rv, this.eHq.aPQ().getId(), rv.getPostId(), true);
                        hVar.eHO.dt(this.mSkinType);
                    } else {
                        hVar.eHO.setVisibility(8);
                        hVar.eHP.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.b.as(hVar.eHO);
                    com.baidu.tieba.graffiti.b.as(hVar.eHP);
                } else {
                    hVar.eHO.setVisibility(8);
                    hVar.eHP.setVisibility(8);
                }
                a(hVar.eHN, getDimensionPixelSize(d.f.ds30));
                if (!this.eIu.aRE()) {
                    if (this.eHq.aQl() != null && this.eHq.aQl().size() <= 4) {
                        hVar.eIp.setVisibility(0);
                        List<be> aQl = this.eHq.aQl();
                        for (int i2 = 0; i2 < aQl.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eIl, aQl);
                            } else if (i2 == 1) {
                                a(i2, hVar.eIm, aQl);
                            } else if (i2 == 2) {
                                a(i2, hVar.eIn, aQl);
                            } else if (i2 == 3) {
                                a(i2, hVar.eIo, aQl);
                            }
                        }
                    }
                } else {
                    hVar.eIp.setVisibility(8);
                }
            } else {
                hVar.eIp.setVisibility(8);
                hVar.eHV.setVisibility(0);
                ai.k(hVar.eHD, d.e.cp_bg_line_e);
                hVar.eHE.setVisibility(0);
                com.baidu.tbadk.data.h btj = postData.btj();
                hVar.eIe.setVisibility(8);
                if (btj != null && !TextUtils.isEmpty(btj.getName()) && !TextUtils.isEmpty(btj.getName().trim())) {
                    final String name = btj.getName();
                    final String lat = btj.getLat();
                    final String lng = btj.getLng();
                    hVar.eIi.setText(btj.getName());
                    ai.c(hVar.eIi, d.e.cp_cont_c, 1);
                    hVar.eIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!i.hr()) {
                                    g.this.eIu.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.T(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eIi.setVisibility(8);
                }
                hVar.eHO.setVisibility(8);
                hVar.eHP.setVisibility(8);
                hVar.eHR.setVisibility(0);
                hVar.eHL.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.btg()));
                hVar.eHK.setVisibility(0);
                hVar.eHK.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                hVar.eHM.setVisibility(0);
                ai.i(hVar.eHM, d.e.cp_link_tip_a);
            } else {
                hVar.eHM.setVisibility(8);
            }
            ai.j(hVar.eHF, d.g.bg_floor_new_middle);
            hVar.eHN.setVideoImageId(d.g.pic_video);
            hVar.eHN.setTextColor(ai.getColor(d.e.common_color_10039));
            hVar.eHN.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.btg()));
            if (postData.btk() > 0) {
                if (this.eHr == null) {
                    this.eHr = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHr.setIsFromCDN(this.mIsFromCDN);
                    this.eHr.I(this.eHt);
                    boolean z6 = false;
                    String userId2 = this.eHq.aPQ().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.eHr.C(this.eHq.aQb(), z6);
                    this.eHr.U(this.eHq.aPQ());
                }
                this.eHr.pK(postData.getId());
                hVar.eHS.setVisibility(0);
                hVar.eHS.a(postData, view);
                hVar.eHS.setChildOnClickListener(this.cNL);
                hVar.eHS.setChildOnLongClickListener(this.awo);
                hVar.eHS.setChildOnTouchListener(this.aRO);
                hVar.eHS.setSubPbAdapter(this.eHr);
                hVar.eHS.setVisibility(0);
                hVar.eHU.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds24));
                hVar.eIk.setVisibility(0);
            } else {
                hVar.eHU.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds40));
                hVar.eHS.setVisibility(8);
                hVar.eIk.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = v.gT(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gT = v.gT(name_show);
                if (i3 > 0) {
                    if (gT > 12) {
                        name_show = v.d(name_show, 0, 14) + "...";
                    }
                } else if (gT > 14) {
                    name_show = v.d(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bHa.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    hVar.bHa.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    ai.c(hVar.bHa, d.e.cp_cont_h, 1);
                } else {
                    ai.c(hVar.bHa, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eHI.setVisibility(0);
                    ai.c(hVar.eHI, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eHI.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eHI.setOnClickListener(null);
                } else {
                    hVar.eHI.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ai.c(hVar.eHJ, d.g.pb_manager);
                        hVar.eHI.setVisibility(8);
                        hVar.eHJ.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        ai.c(hVar.eHJ, d.g.pb_assist);
                        hVar.eHI.setVisibility(8);
                        hVar.eHJ.setVisibility(0);
                    }
                }
                int gT2 = v.gT(postData.getAuthor().getName_show());
                if (gT2 >= 14 && hVar.eHI.getVisibility() == 0 && hVar.eHM.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gT2 < 12 || hVar.eHI.getVisibility() != 0 || hVar.eHM.getVisibility() != 0) ? i4 : i4 - 1;
                this.eHs = postData.getAuthor().getIconInfo();
                this.drx = postData.getAuthor().getTShowInfoNew();
                if (hVar.cBm != null) {
                    hVar.cBm.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    hVar.cBm.setOnClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.cta);
                    hVar.cBm.a(this.eHs, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (hVar.apn != null) {
                    hVar.apn.setOnClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.eVF);
                    hVar.apn.a(this.drx, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pV())) {
                hVar.eHH.setVisibility(4);
                hVar.eHG.setVisibility(0);
                hVar.eHG.et(postData.getAuthor().getPendantData().pV());
                hVar.eHG.getHeadView().c(portrait, 28, false);
                hVar.eHG.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                hVar.eHG.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                hVar.eHH.setVisibility(0);
                hVar.eHG.setVisibility(8);
                hVar.eHH.setUserId(postData.getAuthor().getUserId());
                hVar.eHH.setUserName(postData.getAuthor().getUserName());
                hVar.eHH.setImageDrawable(null);
                hVar.eHH.c(portrait, 28, false);
            }
            hVar.bHa.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            hVar.bHa.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            hVar.eHN.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            if (this.eHo) {
                hVar.eHN.setDefaultImageId(d.g.transparent_bg);
            } else {
                hVar.eHN.setDefaultImageId(d.g.icon_click);
            }
            hVar.eHN.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aBw();
            }
            if (this.eHu || !this.eHv) {
                hVar.eHN.a(tbRichText, false);
            } else {
                hVar.eHN.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eHq.aQb() != 0) {
                z7 = true;
                z8 = true;
                String userId3 = postData.getAuthor().getUserId();
                if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z7 = false;
                }
                if (userId3 == null || userId3.equals("0") || userId3.length() == 0) {
                    z7 = false;
                }
            }
            if (this.eHq != null && this.eHq.aPQ() != null && this.eHq.aPQ().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eHq.aPQ().getAuthor().getUserId();
                String userId5 = postData.getAuthor().getUserId();
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId5) || !userId5.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.getAuthor().getUserId();
                    if (userId == null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        z4 = z2;
                        z5 = z3;
                    }
                    if (!z7) {
                        if (hVar.eHZ != null) {
                            hVar.eHZ.setVisibility(0);
                            hVar.eHZ.setText(d.l.manage);
                            hVar.eHZ.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (hVar.eHZ != null) {
                            hVar.eHZ.setVisibility(0);
                            hVar.eHZ.setText(d.l.delete);
                            hVar.eHZ.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (hVar.eHZ != null) {
                        hVar.eHZ.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.btg() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHq.aQb()));
                        sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray2.put(d.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(d.h.tag_user_mute_visible, true);
                        sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eHq.aPQ() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eHq.aPQ().getId());
                        }
                        sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(d.h.tag_should_delete_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHq.aQb()));
                        sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_should_delete_visible, false);
                    }
                    a(hVar, postData, postData.btg() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eHy == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.eHy.bxr();
                        return;
                    }
                    return;
                }
            }
            z = false;
            z2 = z8;
            z3 = false;
            userId = postData.getAuthor().getUserId();
            if (userId == null) {
            }
            z4 = z2;
            z5 = z3;
            if (!z7) {
            }
            int i62 = 1;
            if (postData.btg() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(hVar, postData, postData.btg() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.eHy == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eHN.setTextViewOnTouchListener(this.aRO);
        hVar.eHN.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aWp() == null || g(postData)) {
            hVar.eIj.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aWp(), hVar.eIj, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eHx - (i - this.eHw));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean g(PostData postData) {
        return (this.eHq == null || this.eHq.aPQ() == null || !this.eHq.aPQ().sr() || this.eHq.aPQ().rt() == null || postData.btg() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (g(postData) && view != null && this.eIu != null) {
            if (this.eHy == null) {
                this.eHy = new com.baidu.tieba.vote.a(this.eIu);
            }
            this.eHy.a(view, this.eHq);
        } else if (this.eHy != null) {
            this.eHy.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bHa.setOnClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.eVE);
        hVar.eHH.setOnClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.eVE);
        hVar.eHG.setOnClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.eVE);
        hVar.eHR.setOnLongClickListener(this.awo);
        hVar.eHN.setOnLongClickListener(this.awo);
        hVar.eHR.setOnTouchListener(this.aRO);
        hVar.eHN.setOnTouchListener(this.aRO);
        hVar.eHN.setOnImageClickListener(this.aRN);
        hVar.eHN.setOnEmotionClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.eVG);
        hVar.cBm.setOnClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.cta);
        hVar.apn.setOnClickListener(((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk.eVF);
        hVar.eIj.setOnClickListener(this.cNL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHq = fVar;
    }

    public void oY(int i) {
        this.eHn = i;
    }

    public void iS(boolean z) {
        this.eHo = z;
    }

    public void iT(boolean z) {
        this.eHp = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eHt = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cNL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRN = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awo = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eIu.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<be> list) {
        if (textView != null) {
            be beVar = (be) u.c(list, i);
            if (beVar == null) {
                textView.setVisibility(8);
                return;
            }
            final String forumName = beVar.getForumName();
            final String forumId = beVar.getForumId();
            textView.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.pm(forumName);
                    TiebaStatic.log(new aj("c12041").aa("fid", forumId));
                }
            });
        }
    }

    public void pm(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eIu.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
