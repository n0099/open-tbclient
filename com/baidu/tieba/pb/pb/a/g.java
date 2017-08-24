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
    private TbRichTextView.e aRO;
    private com.baidu.tieba.pb.a.c aRP;
    private View.OnLongClickListener awp;
    private View.OnClickListener cNL;
    private ArrayList<IconData> drx;
    private com.baidu.tieba.vote.a eHA;
    private int eHp;
    private boolean eHq;
    private boolean eHr;
    private com.baidu.tieba.pb.data.f eHs;
    private com.baidu.tieba.pb.pb.sub.d eHt;
    private ArrayList<IconData> eHu;
    private View.OnClickListener eHv;
    private boolean eHw;
    private final boolean eHx;
    private int eHy;
    private int eHz;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eHp = 0;
        this.eHq = true;
        this.eHr = true;
        this.eHs = null;
        this.mHostId = null;
        this.eHt = null;
        this.eHu = null;
        this.drx = null;
        this.eHv = null;
        this.cNL = null;
        this.aRO = null;
        this.aRP = null;
        this.awp = null;
        this.eHw = false;
        this.eHx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                ai.c(hVar.eHZ, d.e.common_color_10005, 1);
                ai.c(hVar.eIb, d.e.cp_link_tip_c, 3);
                ai.c(hVar.bHb, d.e.cp_cont_f, 1);
                ai.c((View) hVar.eHK, d.e.cp_cont_i, 1);
                ai.c((View) hVar.eHL, d.e.cp_cont_i, 1);
                ai.c(hVar.eHM, d.e.cp_cont_d, 1);
                ai.c(hVar.eHN, d.e.cp_cont_d, 1);
                ai.k(hVar.eHQ, d.e.cp_bg_line_e);
                ai.k(hVar.eHR, d.e.cp_bg_line_e);
                ai.c(hVar.eHR, d.e.cp_bg_line_b);
                ai.k(hVar.eHU, d.e.cp_bg_line_c);
            }
            hVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void init() {
        this.eHy = getDimensionPixelSize(d.f.ds30);
        this.eHz = k.ag(this.mContext) - getDimensionPixelSize(d.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_item, viewGroup, false), this.eHq, this.eHp, false);
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
            postData2.sE();
            a(hVar, postData2, view, i);
        }
        if (!this.eHw && this.eHx && hVar != null && hVar.eHP.Jb() && (listView = ((PbActivity) this.eIw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eHw = true;
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
            ai.k(hVar.eHX, d.e.cp_bg_line_b);
            hVar.eHJ.setTag(null);
            hVar.eHJ.setUserId(null);
            hVar.bHb.setText((CharSequence) null);
            hVar.eHL.setVisibility(8);
            hVar.eHU.setVisibility(0);
            hVar.eHO.setVisibility(8);
            SparseArray sparseArray = (SparseArray) hVar.eHT.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                hVar.eHT.setTag(sparseArray);
                hVar.eHP.setTag(sparseArray);
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(hVar.eHP, getDimensionPixelSize(d.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHq || g(postData)) {
                sparseArray.put(d.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.eHP.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                hVar.eHP.setLayoutParams(layoutParams);
                hVar.eHP.setPadding(0, 0, 0, 0);
                hVar.eHP.hd(null);
            } else {
                sparseArray.put(d.h.tag_richtext_bg, postData.getBimg_url());
                hVar.eHP.hd(postData.getBimg_url());
                if (postData.bsZ() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.eHP.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds40);
                    hVar.eHP.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) hVar.eHP.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(d.f.ds20);
                    hVar.eHP.setLayoutParams(layoutParams3);
                }
            }
            hVar.eHN.setText(al.r(postData.getTime()));
            hVar.eHS.setVisibility(8);
            if (postData.bsZ() == 1) {
                ai.k(hVar.eHF, d.e.cp_bg_line_d);
                hVar.eHG.setVisibility(8);
                hVar.eHX.setVisibility(8);
                hVar.eHT.setVisibility(8);
                hVar.eHN.setVisibility(8);
                hVar.eHS.setVisibility(0);
                hVar.eHV.setVisibility(8);
                hVar.eHW.setVisibility(8);
                hVar.eIm.setVisibility(8);
                hVar.eIg.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                hVar.eHS.a(postData.btg(), str, str2, j, com.baidu.adp.lib.g.b.d(this.eHs.aPL().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                hVar.eHS.onChangeSkinType();
                if (this.eHr) {
                    PraiseData rw = this.eHs.aPL().rw();
                    if (rw != null && rw.getUser() != null && rw.getUser().size() > 0) {
                        hVar.eHQ.setVisibility(0);
                        hVar.eHR.setVisibility(0);
                        hVar.eHQ.setIsFromPb(true);
                        hVar.eHQ.a(rw, this.eHs.aPL().getId(), rw.getPostId(), true);
                        hVar.eHQ.dt(this.mSkinType);
                    } else {
                        hVar.eHQ.setVisibility(8);
                        hVar.eHR.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.b.ar(hVar.eHQ);
                    com.baidu.tieba.graffiti.b.ar(hVar.eHR);
                } else {
                    hVar.eHQ.setVisibility(8);
                    hVar.eHR.setVisibility(8);
                }
                a(hVar.eHP, getDimensionPixelSize(d.f.ds30));
                if (!this.eIw.aRz()) {
                    if (this.eHs.aQg() != null && this.eHs.aQg().size() <= 4) {
                        hVar.eIr.setVisibility(0);
                        List<be> aQg = this.eHs.aQg();
                        for (int i2 = 0; i2 < aQg.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, hVar.eIn, aQg);
                            } else if (i2 == 1) {
                                a(i2, hVar.eIo, aQg);
                            } else if (i2 == 2) {
                                a(i2, hVar.eIp, aQg);
                            } else if (i2 == 3) {
                                a(i2, hVar.eIq, aQg);
                            }
                        }
                    }
                } else {
                    hVar.eIr.setVisibility(8);
                }
            } else {
                hVar.eIr.setVisibility(8);
                hVar.eHX.setVisibility(0);
                ai.k(hVar.eHF, d.e.cp_bg_line_e);
                hVar.eHG.setVisibility(0);
                com.baidu.tbadk.data.h btc = postData.btc();
                hVar.eIg.setVisibility(8);
                if (btc != null && !TextUtils.isEmpty(btc.getName()) && !TextUtils.isEmpty(btc.getName().trim())) {
                    final String name = btc.getName();
                    final String lat = btc.getLat();
                    final String lng = btc.getLng();
                    hVar.eIk.setText(btc.getName());
                    ai.c(hVar.eIk, d.e.cp_cont_c, 1);
                    hVar.eIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.a.g.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                if (!i.hr()) {
                                    g.this.eIw.showToast(d.l.neterror);
                                } else {
                                    com.baidu.tbadk.browser.a.T(g.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, g.this.mContext.getString(d.l.app_info_for_map)));
                                }
                            }
                        }
                    });
                } else {
                    hVar.eIk.setVisibility(8);
                }
                hVar.eHQ.setVisibility(8);
                hVar.eHR.setVisibility(8);
                hVar.eHT.setVisibility(0);
                hVar.eHN.setVisibility(0);
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsZ()));
                hVar.eHM.setVisibility(0);
                hVar.eHM.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                hVar.eHO.setVisibility(0);
                ai.i(hVar.eHO, d.e.cp_link_tip_a);
            } else {
                hVar.eHO.setVisibility(8);
            }
            ai.j(hVar.eHH, d.g.bg_floor_new_middle);
            hVar.eHP.setVideoImageId(d.g.pic_video);
            hVar.eHP.setTextColor(ai.getColor(d.e.common_color_10039));
            hVar.eHP.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsZ()));
            if (postData.btd() > 0) {
                if (this.eHt == null) {
                    this.eHt = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHt.setIsFromCDN(this.mIsFromCDN);
                    this.eHt.E(this.eHv);
                    boolean z6 = false;
                    String userId2 = this.eHs.aPL().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.eHt.C(this.eHs.aPW(), z6);
                    this.eHt.U(this.eHs.aPL());
                }
                this.eHt.pP(postData.getId());
                hVar.eHU.setVisibility(0);
                hVar.eHU.a(postData, view);
                hVar.eHU.setChildOnClickListener(this.cNL);
                hVar.eHU.setChildOnLongClickListener(this.awp);
                hVar.eHU.setChildOnTouchListener(this.aRP);
                hVar.eHU.setSubPbAdapter(this.eHt);
                hVar.eHU.setVisibility(0);
                hVar.eHW.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds24));
                hVar.eIm.setVisibility(0);
            } else {
                hVar.eHW.setPadding(0, 0, 0, k.g(this.mContext, d.f.ds40));
                hVar.eHU.setVisibility(8);
                hVar.eIm.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = v.gW(postData.getAuthor().getSealPrefix()) + 2;
                }
                int gW = v.gW(name_show);
                if (i3 > 0) {
                    if (gW > 12) {
                        name_show = v.e(name_show, 0, 14) + "...";
                    }
                } else if (gW > 14) {
                    name_show = v.e(name_show, 0, 14) + "...";
                }
                if (i3 > 0) {
                    hVar.bHb.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    hVar.bHb.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    ai.c(hVar.bHb, d.e.cp_cont_h, 1);
                } else {
                    ai.c(hVar.bHb, d.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    hVar.eHK.setVisibility(0);
                    ai.c(hVar.eHK, BitmapHelper.getGradeResourceIdNew(level_id));
                    hVar.eHK.setContentDescription(String.format(TbadkCoreApplication.getInst().getString(d.l.degree_in_forum), Integer.valueOf(level_id)));
                    hVar.eHK.setOnClickListener(null);
                } else {
                    hVar.eHK.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        ai.c(hVar.eHL, d.g.pb_manager);
                        hVar.eHK.setVisibility(8);
                        hVar.eHL.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        ai.c(hVar.eHL, d.g.pb_assist);
                        hVar.eHK.setVisibility(8);
                        hVar.eHL.setVisibility(0);
                    }
                }
                int gW2 = v.gW(postData.getAuthor().getName_show());
                if (gW2 >= 14 && hVar.eHK.getVisibility() == 0 && hVar.eHO.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || gW2 < 12 || hVar.eHK.getVisibility() != 0 || hVar.eHO.getVisibility() != 0) ? i4 : i4 - 1;
                this.eHu = postData.getAuthor().getIconInfo();
                this.drx = postData.getAuthor().getTShowInfoNew();
                if (hVar.cBm != null) {
                    hVar.cBm.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    hVar.cBm.setOnClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.cta);
                    hVar.cBm.a(this.eHu, i5, getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds30), getDimensionPixelSize(d.f.ds10));
                }
                if (hVar.apn != null) {
                    hVar.apn.setOnClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.eVH);
                    hVar.apn.a(this.drx, 3, getDimensionPixelSize(d.f.ds36), getDimensionPixelSize(d.f.ds32), getDimensionPixelSize(d.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pW())) {
                hVar.eHJ.setVisibility(4);
                hVar.eHI.setVisibility(0);
                hVar.eHI.ex(postData.getAuthor().getPendantData().pW());
                hVar.eHI.getHeadView().c(portrait, 28, false);
                hVar.eHI.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                hVar.eHI.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                hVar.eHJ.setVisibility(0);
                hVar.eHI.setVisibility(8);
                hVar.eHJ.setUserId(postData.getAuthor().getUserId());
                hVar.eHJ.setUserName(postData.getAuthor().getUserName());
                hVar.eHJ.setImageDrawable(null);
                hVar.eHJ.c(portrait, 28, false);
            }
            hVar.bHb.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
            hVar.bHb.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
            hVar.eHP.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            if (this.eHq) {
                hVar.eHP.setDefaultImageId(d.g.transparent_bg);
            } else {
                hVar.eHP.setDefaultImageId(d.g.icon_click);
            }
            hVar.eHP.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aBr();
            }
            if (this.eHw || !this.eHx) {
                hVar.eHP.a(tbRichText, false);
            } else {
                hVar.eHP.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eHs.aPW() != 0) {
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
            if (this.eHs != null && this.eHs.aPL() != null && this.eHs.aPL().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eHs.aPL().getAuthor().getUserId();
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
                        if (hVar.eIb != null) {
                            hVar.eIb.setVisibility(0);
                            hVar.eIb.setText(d.l.manage);
                            hVar.eIb.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (hVar.eIb != null) {
                            hVar.eIb.setVisibility(0);
                            hVar.eIb.setText(d.l.delete);
                            hVar.eIb.setCompoundDrawablesWithIntrinsicBounds(getDrawable(d.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (hVar.eIb != null) {
                        hVar.eIb.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.bsZ() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHs.aPW()));
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
                        if (this.eHs.aPL() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eHs.aPL().getId());
                        }
                        sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(d.h.tag_should_delete_visible, true);
                        sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHs.aPW()));
                        sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_should_delete_visible, false);
                    }
                    a(hVar, postData, postData.bsZ() != 1, tbRichText);
                    b(hVar);
                    a(view, postData);
                    if (this.eHA == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.eHA.bxk();
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
            if (postData.bsZ() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(hVar, postData, postData.bsZ() != 1, tbRichText);
            b(hVar);
            a(view, postData);
            if (this.eHA == null) {
            }
        }
    }

    private void b(h hVar) {
        hVar.eHP.setTextViewOnTouchListener(this.aRP);
        hVar.eHP.setTextViewCheckSelection(false);
    }

    private void a(h hVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aWk() == null || g(postData)) {
            hVar.eIl.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aWk(), hVar.eIl, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eHz - (i - this.eHy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean g(PostData postData) {
        return (this.eHs == null || this.eHs.aPL() == null || !this.eHs.aPL().ss() || this.eHs.aPL().ru() == null || postData.bsZ() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (g(postData) && view != null && this.eIw != null) {
            if (this.eHA == null) {
                this.eHA = new com.baidu.tieba.vote.a(this.eIw);
            }
            this.eHA.a(view, this.eHs);
        } else if (this.eHA != null) {
            this.eHA.setVisibility(8);
        }
    }

    private void c(h hVar) {
        hVar.bHb.setOnClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.eVG);
        hVar.eHJ.setOnClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.eVG);
        hVar.eHI.setOnClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.eVG);
        hVar.eHT.setOnLongClickListener(this.awp);
        hVar.eHP.setOnLongClickListener(this.awp);
        hVar.eHT.setOnTouchListener(this.aRP);
        hVar.eHP.setOnTouchListener(this.aRP);
        hVar.eHP.setOnImageClickListener(this.aRO);
        hVar.eHP.setOnEmotionClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.eVI);
        hVar.cBm.setOnClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.cta);
        hVar.apn.setOnClickListener(((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm.eVH);
        hVar.eIl.setOnClickListener(this.cNL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHs = fVar;
    }

    public void oY(int i) {
        this.eHp = i;
    }

    public void iS(boolean z) {
        this.eHq = z;
    }

    public void iT(boolean z) {
        this.eHr = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void C(View.OnClickListener onClickListener) {
        this.eHv = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cNL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRO = eVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awp = onLongClickListener;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.eIw.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
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
                    g.this.pr(forumName);
                    TiebaStatic.log(new aj("c12041").aa("fid", forumId));
                }
            });
        }
    }

    public void pr(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eIw.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
