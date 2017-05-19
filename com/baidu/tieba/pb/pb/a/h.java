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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends dh<PostData, k> implements View.OnClickListener {
    private TbRichTextView.e aOe;
    private View.OnLongClickListener atr;
    private ArrayList<IconData> cSi;
    private View.OnClickListener coZ;
    private boolean eeA;
    private com.baidu.tieba.pb.data.f eeB;
    private ba eeC;
    private ArrayList<IconData> eeD;
    private View.OnClickListener eeE;
    private com.baidu.tieba.pb.a.d eeF;
    private boolean eeG;
    private final boolean eeH;
    private int eeI;
    private int eeJ;
    private com.baidu.tieba.vote.a eeK;
    private int eey;
    private boolean eez;
    private String mHostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eey = 0;
        this.eez = true;
        this.eeA = true;
        this.eeB = null;
        this.mHostId = null;
        this.eeC = null;
        this.eeD = null;
        this.cSi = null;
        this.eeE = null;
        this.coZ = null;
        this.aOe = null;
        this.eeF = null;
        this.atr = null;
        this.eeG = false;
        this.eeH = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void a(k kVar) {
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                aq.c(kVar.efj, w.e.common_color_10005, 1);
                aq.c(kVar.efl, w.e.cp_link_tip_c, 3);
                aq.c(kVar.but, w.e.cp_cont_f, 1);
                aq.c((View) kVar.eeU, w.e.cp_cont_i, 1);
                aq.c((View) kVar.eeV, w.e.cp_cont_i, 1);
                aq.c(kVar.eeW, w.e.cp_cont_d, 1);
                aq.c(kVar.eeX, w.e.cp_cont_d, 1);
                aq.k(kVar.efa, w.e.cp_bg_line_e);
                aq.k(kVar.efb, w.e.cp_bg_line_e);
                aq.c(kVar.efb, w.e.cp_bg_line_b);
                aq.k(kVar.efe, w.e.cp_bg_line_c);
            }
            kVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void init() {
        this.eeI = getDimensionPixelSize(w.f.ds30);
        this.eeJ = com.baidu.adp.lib.util.k.af(this.mContext) - getDimensionPixelSize(w.f.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        k kVar = new k(LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_item, viewGroup, false), this.eez, this.eey, false);
        a(kVar);
        return kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, k kVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, kVar);
        a(kVar);
        c(kVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sw();
            a(kVar, postData2, view, i);
        }
        if (!this.eeG && this.eeH && kVar != null && kVar.eeZ.Ip() && (listView = ((PbActivity) this.efF.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eeG = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x062c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0981  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x098d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(k kVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (kVar != null && postData != null) {
            aq.k(kVar.efh, w.e.cp_bg_line_b);
            kVar.eeT.setTag(null);
            kVar.eeT.setUserId(null);
            kVar.but.setText((CharSequence) null);
            kVar.eeV.setVisibility(8);
            kVar.efe.setVisibility(0);
            kVar.eeY.setVisibility(8);
            SparseArray sparseArray = (SparseArray) kVar.efd.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                kVar.efd.setTag(sparseArray);
                kVar.eeZ.setTag(sparseArray);
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(kVar.eeZ, getDimensionPixelSize(w.f.ds30));
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eez || e(postData)) {
                sparseArray.put(w.h.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eeZ.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                kVar.eeZ.setLayoutParams(layoutParams);
                kVar.eeZ.setPadding(0, 0, 0, 0);
                kVar.eeZ.gt(null);
            } else {
                sparseArray.put(w.h.tag_richtext_bg, postData.getBimg_url());
                kVar.eeZ.gt(postData.getBimg_url());
                if (postData.bgM() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eeZ.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                    layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds40);
                    kVar.eeZ.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) kVar.eeZ.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(w.f.ds20);
                    layoutParams3.bottomMargin = getDimensionPixelSize(w.f.ds20);
                    kVar.eeZ.setLayoutParams(layoutParams3);
                }
            }
            kVar.eeX.setText(au.q(postData.getTime()));
            kVar.efc.setVisibility(8);
            if (postData.bgM() == 1) {
                aq.k(kVar.eeP, w.e.cp_bg_line_d);
                kVar.eeQ.setVisibility(8);
                kVar.efh.setVisibility(8);
                kVar.efd.setVisibility(8);
                kVar.eeX.setVisibility(8);
                kVar.efc.setVisibility(0);
                kVar.eff.setVisibility(8);
                kVar.efg.setVisibility(8);
                kVar.efw.setVisibility(8);
                kVar.efq.setVisibility(8);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                kVar.efc.a(postData.bgT(), str, j, com.baidu.adp.lib.g.b.c(this.eeB.aHG().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                kVar.efc.onChangeSkinType();
                if (this.eeA) {
                    PraiseData ro = this.eeB.aHG().ro();
                    if (ro != null && ro.getUser() != null && ro.getUser().size() > 0) {
                        kVar.efa.setVisibility(0);
                        kVar.efb.setVisibility(0);
                        kVar.efa.setIsFromPb(true);
                        kVar.efa.a(ro, this.eeB.aHG().getId(), ro.getPostId(), true);
                        kVar.efa.dm(this.mSkinType);
                    } else {
                        kVar.efa.setVisibility(8);
                        kVar.efb.setVisibility(8);
                    }
                    com.baidu.tieba.graffiti.c.aj(kVar.efa);
                    com.baidu.tieba.graffiti.c.aj(kVar.efb);
                } else {
                    kVar.efa.setVisibility(8);
                    kVar.efb.setVisibility(8);
                }
                a(kVar.eeZ, getDimensionPixelSize(w.f.ds30));
                if (!this.efF.aJt()) {
                    if (this.eeB.aIb() != null && this.eeB.aIb().size() <= 4) {
                        kVar.efB.setVisibility(0);
                        List<bd> aIb = this.eeB.aIb();
                        for (int i2 = 0; i2 < aIb.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, kVar.efx, aIb);
                            } else if (i2 == 1) {
                                a(i2, kVar.efy, aIb);
                            } else if (i2 == 2) {
                                a(i2, kVar.efz, aIb);
                            } else if (i2 == 3) {
                                a(i2, kVar.efA, aIb);
                            }
                        }
                    }
                } else {
                    kVar.efB.setVisibility(8);
                }
            } else {
                kVar.efB.setVisibility(8);
                kVar.efh.setVisibility(0);
                aq.k(kVar.eeP, w.e.cp_bg_line_e);
                kVar.eeQ.setVisibility(0);
                com.baidu.tbadk.data.f bgP = postData.bgP();
                kVar.efq.setVisibility(8);
                if (bgP != null && !TextUtils.isEmpty(bgP.getName()) && !TextUtils.isEmpty(bgP.getName().trim())) {
                    String name = bgP.getName();
                    String lat = bgP.getLat();
                    String lng = bgP.getLng();
                    kVar.efu.setText(bgP.getName());
                    aq.c(kVar.efu, w.e.cp_cont_c, 1);
                    kVar.efu.setOnClickListener(new i(this, lat, lng, name));
                } else {
                    kVar.efu.setVisibility(8);
                }
                kVar.efa.setVisibility(8);
                kVar.efb.setVisibility(8);
                kVar.efd.setVisibility(0);
                kVar.eeX.setVisibility(0);
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bgM()));
                kVar.eeW.setVisibility(0);
                kVar.eeW.setText(format);
            }
            if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                kVar.eeY.setVisibility(0);
                aq.i(kVar.eeY, w.e.cp_link_tip_a);
            } else {
                kVar.eeY.setVisibility(8);
            }
            aq.j(kVar.eeR, w.g.bg_floor_new_middle);
            kVar.eeZ.setVideoImageId(w.g.pic_video);
            kVar.eeZ.setTextColor(aq.getColor(w.e.common_color_10039));
            kVar.eeZ.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bgM()));
            if (postData.bgQ() > 0) {
                if (this.eeC == null) {
                    this.eeC = new ba(this.mContext);
                    this.eeC.setIsFromCDN(this.mIsFromCDN);
                    this.eeC.J(this.eeE);
                    boolean z6 = false;
                    String userId2 = this.eeB.aHG().getAuthor().getUserId();
                    if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z6 = true;
                    }
                    this.eeC.A(this.eeB.aHR(), z6);
                    this.eeC.m(this.eeB.aHG());
                }
                this.eeC.nW(postData.getId());
                kVar.efe.setVisibility(0);
                kVar.efe.a(postData, view);
                kVar.efe.setChildOnClickListener(this.coZ);
                kVar.efe.setChildOnLongClickListener(this.atr);
                kVar.efe.setChildOnTouchListener(this.eeF);
                kVar.efe.setSubPbAdapter(this.eeC);
                kVar.efe.setVisibility(0);
                kVar.efg.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds24));
                kVar.efw.setVisibility(0);
            } else {
                kVar.efg.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40));
                kVar.efe.setVisibility(8);
                kVar.efw.setVisibility(8);
            }
            String portrait = postData.getAuthor().getPortrait();
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int i3 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    i3 = x.go(postData.getAuthor().getSealPrefix()) + 2;
                }
                int go = x.go(name_show);
                if (i3 > 0) {
                    if (go > 12) {
                        name_show = String.valueOf(x.d(name_show, 0, 14)) + "...";
                    }
                } else if (go > 14) {
                    name_show = String.valueOf(x.d(name_show, 0, 14)) + "...";
                }
                if (i3 > 0) {
                    kVar.but.setText(af(postData.getAuthor().getSealPrefix(), name_show));
                } else {
                    kVar.but.setText(name_show);
                }
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    aq.c(kVar.but, w.e.cp_cont_h, 1);
                } else {
                    aq.c(kVar.but, w.e.cp_cont_f, 1);
                }
                int level_id = postData.getAuthor().getLevel_id();
                int is_bawu = postData.getAuthor().getIs_bawu();
                String bawu_type = postData.getAuthor().getBawu_type();
                int i4 = 3;
                if (level_id != 0) {
                    kVar.eeU.setVisibility(0);
                    aq.c(kVar.eeU, BitmapHelper.getGradeResourceIdNew(level_id));
                    kVar.eeU.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id)));
                    kVar.eeU.setOnClickListener(null);
                } else {
                    kVar.eeU.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        aq.c(kVar.eeV, w.g.pb_manager);
                        kVar.eeU.setVisibility(8);
                        kVar.eeV.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        aq.c(kVar.eeV, w.g.pb_assist);
                        kVar.eeU.setVisibility(8);
                        kVar.eeV.setVisibility(0);
                    }
                }
                int go2 = x.go(postData.getAuthor().getName_show());
                if (go2 >= 14 && kVar.eeU.getVisibility() == 0 && kVar.eeY.getVisibility() == 0) {
                    i4 = 2;
                }
                int i5 = (StringUtils.isNull(postData.getAuthor().getSealPrefix()) || go2 < 12 || kVar.eeU.getVisibility() != 0 || kVar.eeY.getVisibility() != 0) ? i4 : i4 - 1;
                this.eeD = postData.getAuthor().getIconInfo();
                this.cSi = postData.getAuthor().getTShowInfoNew();
                if (kVar.ccw != null) {
                    kVar.ccw.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    kVar.ccw.setOnClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.bWW);
                    kVar.ccw.a(this.eeD, i5, getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds30), getDimensionPixelSize(w.f.ds10));
                }
                if (kVar.amq != null) {
                    kVar.amq.setOnClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.epC);
                    kVar.amq.a(this.cSi, 3, getDimensionPixelSize(w.f.ds36), getDimensionPixelSize(w.f.ds32), getDimensionPixelSize(w.f.ds8), true);
                }
            }
            if (postData != null && postData.getAuthor() != null && postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pT())) {
                kVar.eeT.setVisibility(4);
                kVar.eeS.setVisibility(0);
                kVar.eeS.dS(postData.getAuthor().getPendantData().pT());
                kVar.eeS.getHeadView().c(portrait, 28, false);
                kVar.eeS.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                kVar.eeS.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            } else {
                kVar.eeT.setVisibility(0);
                kVar.eeS.setVisibility(8);
                kVar.eeT.setUserId(postData.getAuthor().getUserId());
                kVar.eeT.setUserName(postData.getAuthor().getUserName());
                kVar.eeT.setImageDrawable(null);
                kVar.eeT.c(portrait, 28, false);
            }
            kVar.but.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
            kVar.but.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
            kVar.eeZ.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
            if (this.eez) {
                kVar.eeZ.setDefaultImageId(w.g.transparent_bg);
            } else {
                kVar.eeZ.setDefaultImageId(w.g.icon_click);
            }
            kVar.eeZ.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.aui();
            }
            if (this.eeG || !this.eeH) {
                kVar.eeZ.a(tbRichText, false);
            } else {
                kVar.eeZ.a(tbRichText, true);
            }
            boolean z7 = false;
            boolean z8 = false;
            if (this.eeB.aHR() != 0) {
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
            if (this.eeB != null && this.eeB.aHG() != null && this.eeB.aHG().getAuthor() != null && postData.getAuthor() != null) {
                String userId4 = this.eeB.aHG().getAuthor().getUserId();
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
                        if (kVar.efl != null) {
                            kVar.efl.setVisibility(0);
                            kVar.efl.setText(w.l.manage);
                            kVar.efl.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (z4) {
                        if (kVar.efl != null) {
                            kVar.efl.setVisibility(0);
                            kVar.efl.setText(w.l.delete);
                            kVar.efl.setCompoundDrawablesWithIntrinsicBounds(getDrawable(w.g.btn_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    } else if (kVar.efl != null) {
                        kVar.efl.setVisibility(8);
                    }
                    int i6 = 1;
                    if (postData.bgM() == 1) {
                        i6 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z7) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eeB.aHR()));
                        sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray2.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(w.h.tag_user_mute_visible, true);
                        sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eeB.aHG() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.eeB.aHG().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eeB.aHR()));
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    a(kVar, postData, postData.bgM() != 1, tbRichText);
                    b(kVar);
                    a(view, postData);
                    if (this.eeK == null && tbRichText != null && !TextUtils.isEmpty(tbRichText.toString())) {
                        this.eeK.bkZ();
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
            if (postData.bgM() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z7) {
            }
            if (!z) {
            }
            if (!z4) {
            }
            a(kVar, postData, postData.bgM() != 1, tbRichText);
            b(kVar);
            a(view, postData);
            if (this.eeK == null) {
            }
        }
    }

    private void b(k kVar) {
        kVar.eeZ.setTextViewOnTouchListener(this.eeF);
        kVar.eeZ.setTextViewCheckSelection(false);
    }

    private void a(k kVar, PostData postData, boolean z, TbRichText tbRichText) {
        if (postData == null || postData.aNs() == null || e(postData)) {
            kVar.efv.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aNs(), kVar.efv, false, z, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.eeJ - (i - this.eeI));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private boolean e(PostData postData) {
        return (this.eeB == null || this.eeB.aHG() == null || !this.eeB.aHG().sk() || this.eeB.aHG().rn() == null || postData.bgM() != 1) ? false : true;
    }

    private void a(View view, PostData postData) {
        if (e(postData) && view != null && this.efF != null) {
            if (this.eeK == null) {
                this.eeK = new com.baidu.tieba.vote.a(this.efF);
            }
            this.eeK.a(view, this.eeB);
        } else if (this.eeK != null) {
            this.eeK.setVisibility(8);
        }
    }

    private void c(k kVar) {
        kVar.but.setOnClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.epB);
        kVar.eeT.setOnClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.epB);
        kVar.eeS.setOnClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.epB);
        kVar.efd.setOnLongClickListener(this.atr);
        kVar.eeZ.setOnLongClickListener(this.atr);
        kVar.efd.setOnTouchListener(this.eeF);
        kVar.eeZ.setOnTouchListener(this.eeF);
        kVar.eeZ.setOnImageClickListener(this.aOe);
        kVar.eeZ.setOnEmotionClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.epD);
        kVar.ccw.setOnClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.bWW);
        kVar.amq.setOnClickListener(((PbActivity) this.efF.getPageContext().getOrignalPage()).egu.epC);
        kVar.efv.setOnClickListener(this.coZ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eeB = fVar;
    }

    public void nW(int i) {
        this.eey = i;
    }

    public void hL(boolean z) {
        this.eez = z;
    }

    public void hM(boolean z) {
        this.eeA = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.eeE = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.coZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOe = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.eeF = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atr = onLongClickListener;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str));
            return ap.a((Context) this.efF.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public void a(int i, TextView textView, List<bd> list) {
        if (textView != null) {
            bd bdVar = (bd) com.baidu.tbadk.core.util.x.c(list, i);
            if (bdVar == null) {
                textView.setVisibility(8);
                return;
            }
            String forumName = bdVar.getForumName();
            String forumId = bdVar.getForumId();
            textView.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new j(this, forumName, forumId));
        }
    }

    public void nA(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.efF.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }
}
