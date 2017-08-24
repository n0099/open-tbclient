package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends l<PostData, k> implements View.OnClickListener {
    private TbRichTextView.e aRO;
    private com.baidu.tieba.pb.a.c aRP;
    private View.OnLongClickListener awp;
    private View.OnClickListener cNL;
    private com.baidu.adp.lib.e.b<TbImageView> coA;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> coz;
    private boolean eHq;
    protected com.baidu.tieba.pb.data.f eHs;
    private com.baidu.tieba.pb.pb.sub.d eHt;
    private View.OnClickListener eHv;
    private TbRichTextView.b eLO;
    private com.baidu.tieba.pb.a.c eLP;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bb;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.cNL != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).btm() && this.cNL != null && this.eIw != null && (bb = this.eIw.bb(findViewById)) != null) {
                TiebaStatic.log(this.eIw.aQS().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", bb.btm() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eLO = null;
        this.eHq = true;
        this.mHostId = null;
        this.eHs = null;
        this.eHv = null;
        this.cNL = null;
        this.aRO = null;
        this.aRP = null;
        this.awp = null;
        this.eHt = null;
        this.coz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ahk */
            public com.baidu.tbadk.widget.layout.b fT() {
                return new com.baidu.tbadk.widget.layout.b(j.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void o(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b q(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.coA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xm */
            public TbImageView fT() {
                TbImageView tbImageView = new TbImageView(j.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.ai.getColor(d.e.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView p(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.eLP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.eIw == null || j.this.eIw.aQO() == null || j.this.eIw.aQO().aTw())) {
                    if (view instanceof NoPressedLinearLayout) {
                        j.this.a((NoPressedLinearLayout) view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof NoPressedLinearLayout) {
                                j.this.a((NoPressedLinearLayout) parent);
                                break;
                            } else {
                                i++;
                                parent = parent.getParent();
                            }
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (j.this.aRP != null) {
                    if (!(view instanceof TbListTextView) || j.this.cNL == null) {
                        j.this.aRP.aY(view);
                        j.this.aRP.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.cNL.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        k kVar = new k(this.eIw.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        kVar.eLZ.setConstrainLayoutPool(this.coz);
        kVar.eLZ.setImageViewPool(this.coA);
        a(kVar);
        return kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, kVar);
        a(kVar);
        b(kVar);
        c(kVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            i(postData2);
            postData2.sE();
            a(kVar, postData2, view, i);
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            b(kVar, postData, view, i);
            c(kVar, postData);
            c(kVar, postData, view, i);
            d(kVar, postData, view, i);
            d(kVar, postData);
            b(kVar, postData);
            a(kVar, postData);
        }
    }

    private void i(PostData postData) {
        if (postData.ZU == 0 || postData.gkp) {
            com.baidu.tbadk.core.util.aj ajVar = new com.baidu.tbadk.core.util.aj("c12203");
            ajVar.aa("post_id", postData.getId());
            ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            ajVar.aa("cuid", TbadkCoreApplication.getInst().getCuid());
            ajVar.g("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(ajVar);
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.aWk() == null) {
            kVar.eIl.setVisibility(8);
            return;
        }
        TbRichText aBr = postData.aBr();
        com.baidu.tieba.pb.view.h.a(postData.aWk(), kVar.eIl, false, false, aBr != null && StringUtils.isNull(aBr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHq) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLY.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.eLY.setLayoutParams(layoutParams);
            kVar.eLY.setPadding(0, 0, 0, 0);
            kVar.eLY.hd(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eLY.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            kVar.eLY.setLayoutParams(layoutParams2);
            kVar.eLY.hd(postData.getBimg_url());
        }
        kVar.eLY.setTextViewOnTouchListener(this.eLP);
        kVar.eLY.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(k kVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (kVar != null && postData != null) {
            if (postData.ctl) {
                com.baidu.tbadk.core.util.ai.k(kVar.ayL, d.e.cp_bg_line_c);
                kVar.ayL.setVisibility(0);
            } else {
                kVar.ayL.setVisibility(8);
            }
            kVar.eLX.setTag(null);
            kVar.eLX.setUserId(null);
            kVar.aXA.setText((CharSequence) null);
            kVar.eMd.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gX = com.baidu.tbadk.util.v.gX(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gX > 12) {
                        name_show = com.baidu.tbadk.util.v.E(name_show, 12) + "...";
                    }
                } else if (gX > 14) {
                    name_show = com.baidu.tbadk.util.v.E(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    kVar.aXA.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aT(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    kVar.aXA.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aT = com.baidu.adp.lib.util.j.aT(postData.getAuthor().getName_show());
                    if (aT + i2 > 14) {
                        i3 = 0;
                    } else if (aT + i2 >= 12) {
                        i3 = 1;
                    } else if (aT + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (kVar.eMf != null) {
                    kVar.eMf.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    kVar.eMf.setOnClickListener(this.eIw.eJm.cta);
                    kVar.eMf.a(iconInfo, i3, this.eIw.getResources().getDimensionPixelSize(d.f.ds26), this.eIw.getResources().getDimensionPixelSize(d.f.ds26), this.eIw.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (kVar.eMe != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.eMe.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.eMe.setOnClickListener(this.eIw.eJm.eVH);
                    kVar.eMe.a(tShowInfoNew, 3, this.eIw.getResources().getDimensionPixelSize(d.f.ds36), this.eIw.getResources().getDimensionPixelSize(d.f.ds36), this.eIw.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.u.v(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.ai.c(kVar.aXA, d.e.cp_cont_r, 1);
                } else {
                    com.baidu.tbadk.core.util.ai.c(kVar.aXA, d.e.cp_cont_f, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                kVar.aXA.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                kVar.aXA.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                kVar.aXA.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.p.ab.ge() && name_show2 != null && !name_show2.equals(userName)) {
                    kVar.aXA.setText(com.baidu.tieba.pb.d.ao(this.mContext, kVar.aXA.getText().toString()));
                    kVar.aXA.setGravity(16);
                    kVar.aXA.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPm());
                    com.baidu.tbadk.core.util.ai.c(kVar.aXA, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pW())) {
                    UtilHelper.showHeadImageViewBigV(kVar.eMd.getHeadView(), postData.getAuthor());
                    kVar.eLX.setVisibility(8);
                    kVar.eMd.setVisibility(0);
                    kVar.eMd.getHeadView().c(portrait, 28, false);
                    kVar.eMd.getHeadView().setUserId(postData.getAuthor().getUserId());
                    kVar.eMd.getHeadView().setUserName(postData.getAuthor().getUserName());
                    kVar.eMd.ex(postData.getAuthor().getPendantData().pW());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.eLX, postData.getAuthor());
                    kVar.eLX.setUserId(postData.getAuthor().getUserId());
                    kVar.eLX.ac(postData.getAuthor().getUserName(), postData.btj());
                    kVar.eLX.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    kVar.eLX.setImageDrawable(null);
                    kVar.eLX.c(portrait, 28, false);
                    kVar.eLX.setVisibility(0);
                    kVar.eMd.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    kVar.eLS.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.i(kVar.eLS, d.e.cp_link_tip_a);
                } else {
                    kVar.eLS.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.h btc = postData.btc();
            if (btc != null && !StringUtils.isNull(btc.getName())) {
                final String name = btc.getName();
                final String lat = btc.getLat();
                final String lng = btc.getLng();
                kVar.eLU.setVisibility(0);
                kVar.eLU.setText(btc.getName());
                kVar.eLU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.i.hr()) {
                                com.baidu.tbadk.browser.a.T(j.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, j.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                j.this.eIw.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                kVar.eLU.setVisibility(8);
            }
            kVar.eLT.setText(postData.btb());
            if (postData.btn() != null && !StringUtils.isNull(postData.btn().getForumName())) {
                kVar.cbc.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.btn().getForumName(), 5, true)));
                kVar.cbc.setVisibility(0);
            } else {
                kVar.cbc.setVisibility(8);
            }
            int i4 = 0;
            if (this.eIw.aRz()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.btn() != null) {
                i4 = postData.btn().rb();
            }
            if (i4 > 0) {
                kVar.eMc.setVisibility(0);
                com.baidu.tbadk.core.util.ai.c(kVar.eMc, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                kVar.eMc.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsZ()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eHs != null && this.eHs.aPW() != 0) {
                z8 = true;
                z9 = true;
                if (postData != null && postData.getAuthor() != null) {
                    String userId = postData.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eHs != null && this.eHs.aPL() != null && this.eHs.aPL().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eHs.aPL().getAuthor().getUserId();
                String userId3 = postData.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.getAuthor() != null && UtilHelper.isCurrentAccount(postData.getAuthor().getUserId())) {
                        z3 = true;
                        z4 = true;
                    } else {
                        boolean z11 = z10;
                        z3 = z;
                        z4 = z11;
                    }
                    if (z7) {
                        z5 = z2;
                        z6 = z3;
                    } else {
                        z8 = false;
                        z6 = false;
                        z5 = false;
                    }
                    int i5 = 1;
                    if (postData.bsZ() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHs.aPW()));
                        sparseArray.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray.put(d.h.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.h.tag_user_mute_visible, true);
                        sparseArray.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eHs.aPL() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eHs.aPL().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHs.aPW()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    kVar.eLW.setTag(sparseArray);
                }
            }
            z = z9;
            z2 = false;
            if (postData == null) {
            }
            boolean z112 = z10;
            z3 = z;
            z4 = z112;
            if (z7) {
            }
            int i52 = 1;
            if (postData.bsZ() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            kVar.eLW.setTag(sparseArray);
        }
    }

    private void c(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.eLV.a(postData.btm(), postData.btl(), false);
            kVar.eLV.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            if (postData.bsZ() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsZ()));
                kVar.eMb.setVisibility(0);
                kVar.eMb.setText(format);
                return;
            }
            kVar.eMb.setVisibility(8);
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLY.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds110);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.eLY.setPadding(0, 0, 0, 0);
            if (!this.eHq) {
                kVar.eLY.setIsSupportVitality(false);
                kVar.eLY.setDefaultImageId(d.g.icon_click);
            } else {
                kVar.eLY.hd(null);
                kVar.eLY.setBackgroundDrawable(null);
                kVar.eLY.setIsSupportVitality(false);
                kVar.eLY.setDefaultImageId(d.g.transparent_bg);
            }
            kVar.eLY.setVideoImageId(d.g.pic_video);
            a(kVar.eLY, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.eLY.setLayoutParams(layoutParams);
            kVar.eLY.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            kVar.eLY.setIsFromCDN(this.mIsFromCDN);
            kVar.eLY.a(postData.aBr(), true, this.eLO);
            SparseArray sparseArray = (SparseArray) kVar.eLY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            kVar.eLY.setTag(sparseArray);
            kVar.eHF.setTag(d.h.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ag = (((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ag = (ag - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.setMaxImageWidth(ag - (z ? getDimensionPixelSize(d.f.ds70) : 0));
            tbRichTextView.setMaxImageHeight((int) (ag * 1.618f));
        }
    }

    private void d(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.btd() > 0 && postData.bsW() != null && postData.bsW().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eMa.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds116);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
                layoutParams.bottomMargin = 0;
                kVar.eMa.setLayoutParams(layoutParams);
                if (this.eHt == null) {
                    this.eHt = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHt.setIsFromCDN(this.mIsFromCDN);
                    this.eHt.E(this.eHv);
                    String str = null;
                    if (this.eHs != null && this.eHs.aPL() != null && this.eHs.aPL().getAuthor() != null) {
                        str = this.eHs.aPL().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eHs != null) {
                        this.eHt.C(this.eHs.aPW(), z);
                        this.eHt.U(this.eHs.aPL());
                    }
                }
                this.eHt.pP(postData.getId());
                kVar.eMa.setVisibility(0);
                kVar.eMa.a(postData, view);
                kVar.eMa.setChildOnClickListener(this.cNL);
                kVar.eMa.setChildOnLongClickListener(this.awp);
                kVar.eMa.setChildOnTouchListener(this.eLP);
                kVar.eMa.setSubPbAdapter(this.eHt);
                kVar.eMa.setVisibility(0);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eMa.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                kVar.eMa.setLayoutParams(layoutParams2);
                kVar.eMa.setVisibility(8);
            }
            if (postData.gks) {
                kVar.ayM.setVisibility(0);
            } else {
                kVar.ayM.setVisibility(4);
            }
        }
    }

    private void a(k kVar) {
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.c(kVar.aXA, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eLS, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eLT, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eMb, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.cbc, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eLU, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.k(kVar.ayM, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(kVar.eLW, d.g.icon_floor_more_selector);
                kVar.eLY.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.k(kVar.eMa, d.e.cp_bg_line_e);
                kVar.eLZ.onChangeSkinType();
                kVar.eLV.onChangeSkinType();
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.eHF.setOnTouchListener(this.eLP);
        kVar.eHF.setOnLongClickListener(this.awp);
        if (this.eIw.getPageContext() != null && this.eIw.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm;
            kVar.aXA.setOnClickListener(aVar.eVG);
            kVar.eLX.setOnClickListener(aVar.eVG);
            kVar.eMd.setOnClickListener(aVar.eVG);
            kVar.eMd.getHeadView().setOnClickListener(aVar.eVG);
            kVar.eLY.setOnLongClickListener(this.awp);
            kVar.eLY.setOnTouchListener(this.eLP);
            kVar.eLY.setCommonTextViewOnClickListener(this.cNL);
            kVar.eLY.setOnImageClickListener(this.aRO);
            kVar.eLY.setOnImageTouchListener(this.eLP);
            kVar.eLY.setOnEmotionClickListener(aVar.eVI);
            kVar.eLW.setOnClickListener(this.cNL);
            kVar.eLV.setOnClickListener(this.cNL);
            kVar.eIl.setOnClickListener(this.cNL);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eLO = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHs = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iS(boolean z) {
        this.eHq = z;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eIw.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.eLY.setTextViewOnTouchListener(this.aRP);
        kVar.eLY.setTextViewCheckSelection(false);
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

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awp = onLongClickListener;
    }
}
