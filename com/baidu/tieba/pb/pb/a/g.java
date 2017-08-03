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
    private TbRichTextView.e aQA;
    private com.baidu.tieba.pb.a.c aQB;
    private View.OnLongClickListener auW;
    private View.OnClickListener cKt;
    private ArrayList<IconData> doi;
    private int eEg;
    private boolean eEh;
    private boolean eEi;
    private com.baidu.tieba.pb.data.f eEj;
    private com.baidu.tieba.pb.pb.sub.d eEk;
    private ArrayList<IconData> eEl;
    private View.OnClickListener eEm;
    private boolean eEn;
    private final boolean eEo;
    private int eEp;
    private int eEq;
    private com.baidu.tieba.vote.a eEr;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eEg = 0;
        this.eEh = true;
        this.eEi = true;
        this.eEj = null;
        this.mHostId = null;
        this.eEk = null;
        this.eEl = null;
        this.doi = null;
        this.eEm = null;
        this.cKt = null;
        this.aQA = null;
        this.aQB = null;
        this.auW = null;
        this.eEn = false;
        this.eEo = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ai.c(hVar.eEQ, d.e.common_color_10005, 1);
                ai.c(hVar.eES, d.e.cp_link_tip_c, 3);
                ai.c(hVar.bFh, d.e.cp_cont_f, 1);
                ai.c((View) hVar.eEB, d.e.cp_cont_i, 1);
                ai.c((View) hVar.eEC, d.e.cp_cont_i, 1);
                ai.c(hVar.eED, d.e.cp_cont_d, 1);
                ai.c(hVar.eEE, d.e.cp_cont_d, 1);
                ai.k(hVar.eEH, d.e.cp_bg_line_e);
                ai.k(hVar.eEI, d.e.cp_bg_line_e);
                ai.c(hVar.eEI, d.e.cp_bg_line_b);
                ai.k(hVar.eEL, d.e.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eEp = getDimensionPixelSize(d.f.ds30);
        this.eEq = k.af(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.eEh, this.eEg, false);
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
            postData2.st();
            a(hVar, postData2, view, i);
        }
        if (!this.eEn && this.eEo && hVar != null && hVar.eEG.IU() && (listView = ((PbActivity) this.eFn.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eEn = true;
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
            ai.k(hVar.eEO, d.e.cp_bg_line_b);
            hVar.eEA.setTag(null);
            hVar.eEA.setUserId(null);
            hVar.bFh.setText((CharSequence) null);
            hVar.eEC.setVisibility(8);
            hVar.eEL.setVisibility(0);
            hVar.eEF.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.eEK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.eEK.setTag(sparseArray);
                hVar.eEG.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(hVar.eEG, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eEh || g(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eEG.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eEG.setLayoutParams(layoutParams);
                hVar.eEG.setPadding(0, 0, 0, 0);
                hVar.eEG.gV(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                hVar.eEG.gV(postData.getBimg_url());
                if (postData.bsr() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eEG.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    hVar.eEG.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eEG.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    hVar.eEG.setLayoutParams(layoutParams3);
                }
            }
            hVar.eEE.setText(al.r(postData.getTime()));
            hVar.eEJ.setVisibility(8);
            if (postData.bsr() == 1) {
                ai.k(hVar.eEw, d.e.cp_bg_line_d);
                hVar.eEx.setVisibility(8);
                hVar.eEO.setVisibility(8);
                hVar.eEK.setVisibility(8);
                hVar.eEE.setVisibility(8);
                hVar.eEJ.setVisibility(0);
                hVar.eEM.setVisibility(8);
                hVar.eEN.setVisibility(8);
                hVar.eFd.setVisibility(8);
                hVar.eEX.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                hVar.eEJ.a(postData.bsy(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eEj.aOY().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                hVar.eEJ.onChangeSkinType();
                if (this.eEi) {
                    PraiseData rl = this.eEj.aOY().rl();
                    if (rl != null && rl.getUser() != null && rl.getUser().size() > 0) {
                        hVar.eEH.setVisibility(0);
                        hVar.eEI.setVisibility(0);
                        hVar.eEH.setIsFromPb(true);
                        hVar.eEH.a(rl, this.eEj.aOY().getId(), rl.getPostId(), true);
                        hVar.eEH.dr(this.mSkinType);
                    } else {
                        hVar.eEH.setVisibility(8);
                        hVar.eEI.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.b.aq(hVar.eEH);
                    com.baidu.tieba.graffiti.b.aq(hVar.eEI);
                } else {
                    hVar.eEH.setVisibility(8);
                    hVar.eEI.setVisibility(8);
                }
                a(hVar.eEG, getDimensionPixelSize(d.f.ds30));
                if (!this.eFn.aQM()) {
                    if (this.eEj.aPt() != null && this.eEj.aPt().size() <= 4) {
                        hVar.eFi.setVisibility(0);
                        List<be> aPt = this.eEj.aPt();
                        for (int i2 = 0; i2 < aPt.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eFe, aPt);
                            } else if (i2 == 1) {
                                a(i2, hVar.eFf, aPt);
                            } else if (i2 == 2) {
                                a(i2, hVar.eFg, aPt);
                            } else if (i2 == 3) {
                                a(i2, hVar.eFh, aPt);
                            }
                        }
                    }
                } else {
                    hVar.eFi.setVisibility(8);
                }
            } else {
                hVar.eFi.setVisibility(8);
                hVar.eEO.setVisibility(0);
                ai.k(hVar.eEw, d.e.cp_bg_line_e);
                hVar.eEx.setVisibility(0);
                com.baidu.tbadk.data.h bsu = postData.bsu();
                hVar.eEX.setVisibility(8);
                if (bsu != null && !TextUtils.isEmpty(bsu.getName()) && !TextUtils.isEmpty(bsu.getName().trim())) {
                    final String name = bsu.getName();
                    final String lat = bsu.getLat();
                    final String lng = bsu.getLng();
                    hVar.eFb.setText(bsu.getName());
                    ai.c(hVar.eFb, d.e.cp_cont_c, 1);
                    hVar.eFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!i.hh()) {
                                    g.this.eFn.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.T(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eFb.setVisibility(8);
                }
                hVar.eEH.setVisibility(8);
                hVar.eEI.setVisibility(8);
                hVar.eEK.setVisibility(0);
                hVar.eEE.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsr()));
                hVar.eED.setVisibility(0);
                hVar.eED.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                hVar.eEF.setVisibility(0);
                ai.i(hVar.eEF, d.e.cp_link_tip_a);
            } else {
                hVar.eEF.setVisibility(8);
            }
            ai.j(hVar.eEy, d.g.bg_floor_new_middle);
            hVar.eEG.setVideoImageId(d.g.pic_video);
            hVar.eEG.setTextColor(ai.getColor(d.e.common_color_10039));
            hVar.eEG.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsr()));
            if (postData.bsv() > 0) {
                if (this.eEk == null) {
                    this.eEk = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eEk.setIsFromCDN(this.mIsFromCDN);
                    this.eEk.I(this.eEm);
                    boolean z6 = false;
                    String userId2 = this.eEj.aOY().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.eEk.B(this.eEj.aPj(), z6);
                    this.eEk.U(this.eEj.aOY());
                }
                this.eEk.pD(postData.getId());
                hVar.eEL.setVisibility(0);
                hVar.eEL.a(postData, view);
                hVar.eEL.setChildOnClickListener(this.cKt);
                hVar.eEL.setChildOnLongClickListener(this.auW);
                hVar.eEL.setChildOnTouchListener(this.aQB);
                hVar.eEL.setSubPbAdapter(this.eEk);
                hVar.eEL.setVisibility(0);
                hVar.eEN.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds24));
                hVar.eFd.setVisibility(0);
            } else {
                hVar.eEN.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds40));
                hVar.eEL.setVisibility(8);
                hVar.eFd.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = v.gO(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gO = v.gO(name_show);
                if (i3 > 0) {
                    if (gO > 12) {
                        name_show = v.d(name_show, 0, 14) + "...";
                    }
                } else if (gO > 14) {
                    name_show = v.d(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bFh.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    hVar.bFh.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    ai.c(hVar.bFh, d.e.cp_cont_h, 1);
                } else {
                    ai.c(hVar.bFh, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eEB.setVisibility(0);
                    ai.c(hVar.eEB, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eEB.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eEB.setOnClickListener(null);
                } else {
                    hVar.eEB.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ai.c(hVar.eEC, d.g.pb_manager);
                        hVar.eEB.setVisibility(8);
                        hVar.eEC.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        ai.c(hVar.eEC, d.g.pb_assist);
                        hVar.eEB.setVisibility(8);
                        hVar.eEC.setVisibility(0);
                    }
                }
                int gO2 = v.gO(postData.getAuthor().getName_show());
                if (gO2 >= 14 && hVar.eEB.getVisibility() == 0 && hVar.eEF.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gO2 < 12 || hVar.eEB.getVisibility() != 0 || hVar.eEF.getVisibility() != 0) ? i4 : i4 - 1;
                this.eEl = postData.getAuthor().getIconInfo();
                this.doi = postData.getAuthor().getTShowInfoNew();
                if (hVar.cxU != null) {
                    hVar.cxU.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    hVar.cxU.setOnClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.cri);
                    hVar.cxU.a(this.eEl, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (hVar.anT != null) {
                    hVar.anT.setOnClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.eSz);
                    hVar.anT.a(this.doi, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pL())) {
                hVar.eEA.setVisibility(4);
                hVar.eEz.setVisibility(0);
                hVar.eEz.en(postData.getAuthor().getPendantData().pL());
                hVar.eEz.getHeadView().c(portrait, 28, false);
                hVar.eEz.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                hVar.eEz.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                hVar.eEA.setVisibility(0);
                hVar.eEz.setVisibility(8);
                hVar.eEA.setUserId(postData.getAuthor().getUserId());
                hVar.eEA.setUserName(postData.getAuthor().getUserName());
                hVar.eEA.setImageDrawable(null);
                hVar.eEA.c(portrait, 28, false);
            }
            hVar.bFh.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            hVar.bFh.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            hVar.eEG.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            if (this.eEh) {
                hVar.eEG.setDefaultImageId(d.g.transparent_bg);
            } else {
                hVar.eEG.setDefaultImageId(d.g.icon_click);
            }
            hVar.eEG.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aAE();
            }
            if (this.eEn || !this.eEo) {
                hVar.eEG.a(tbRichText, false);
            } else {
                hVar.eEG.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eEj.aPj() != 0) {
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
            if (this.eEj != null && this.eEj.aOY() != null && this.eEj.aOY().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eEj.aOY().getAuthor().getUserId();
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
                        if (hVar.eES != null) {
                            hVar.eES.setVisibility(0);
                            hVar.eES.setText(d.l.manage);
                            hVar.eES.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (hVar.eES != null) {
                            hVar.eES.setVisibility(0);
                            hVar.eES.setText(d.l.delete);
                            hVar.eES.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (hVar.eES != null) {
                        hVar.eES.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.bsr() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eEj.aPj()));
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
                        if (this.eEj.aOY() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eEj.aOY().getId());
                        }
                        sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(d.h.tag_should_delete_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eEj.aPj()));
                        sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_should_delete_visible, false);
                    }
                    a(hVar, postData, postData.bsr() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eEr == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.eEr.bwC();
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
            if (postData.bsr() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(hVar, postData, postData.bsr() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.eEr == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eEG.setTextViewOnTouchListener(this.aQB);
        hVar.eEG.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aVx() == null || g(postData)) {
            hVar.eFc.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aVx(), hVar.eFc, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eEq - (i - this.eEp));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean g(PostData postData) {
        return (this.eEj == null || this.eEj.aOY() == null || !this.eEj.aOY().sh() || this.eEj.aOY().rj() == null || postData.bsr() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (g(postData) && view != null && this.eFn != null) {
            if (this.eEr == null) {
                this.eEr = new com.baidu.tieba.vote.a(this.eFn);
            }
            this.eEr.a(view, this.eEj);
        } else if (this.eEr != null) {
            this.eEr.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bFh.setOnClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.eSy);
        hVar.eEA.setOnClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.eSy);
        hVar.eEz.setOnClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.eSy);
        hVar.eEK.setOnLongClickListener(this.auW);
        hVar.eEG.setOnLongClickListener(this.auW);
        hVar.eEK.setOnTouchListener(this.aQB);
        hVar.eEG.setOnTouchListener(this.aQB);
        hVar.eEG.setOnImageClickListener(this.aQA);
        hVar.eEG.setOnEmotionClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.eSA);
        hVar.cxU.setOnClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.cri);
        hVar.anT.setOnClickListener(((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd.eSz);
        hVar.eFc.setOnClickListener(this.cKt);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eEj = fVar;
    }

    public void oO(int i) {
        this.eEg = i;
    }

    public void iP(boolean z) {
        this.eEh = z;
    }

    public void iQ(boolean z) {
        this.eEi = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eEm = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cKt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aQA = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auW = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eFn.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
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
                    g.this.pe(forumName);
                    TiebaStatic.log(new aj("c12041").aa("fid", forumId));
                }
            });
        }
    }

    public void pe(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eFn.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
