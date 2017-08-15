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
    private TbRichTextView.e aRN;
    private com.baidu.tieba.pb.a.c aRO;
    private View.OnLongClickListener awo;
    private View.OnClickListener cNL;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> coy;
    private com.baidu.adp.lib.e.b<TbImageView> coz;
    private boolean eHo;
    protected com.baidu.tieba.pb.data.f eHq;
    private com.baidu.tieba.pb.pb.sub.d eHr;
    private View.OnClickListener eHt;
    private TbRichTextView.b eLM;
    private com.baidu.tieba.pb.a.c eLN;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bc;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.cNL != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).btt() && this.cNL != null && this.eIu != null && (bc = this.eIu.bc(findViewById)) != null) {
                TiebaStatic.log(this.eIu.aQX().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", bc.btt() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eLM = null;
        this.eHo = true;
        this.mHostId = null;
        this.eHq = null;
        this.eHt = null;
        this.cNL = null;
        this.aRN = null;
        this.aRO = null;
        this.awo = null;
        this.eHr = null;
        this.coy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ahq */
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
        this.coz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
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
        this.eLN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.eIu == null || j.this.eIu.aQT() == null || j.this.eIu.aQT().aTB())) {
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
                if (j.this.aRO != null) {
                    if (!(view instanceof TbListTextView) || j.this.cNL == null) {
                        j.this.aRO.aZ(view);
                        j.this.aRO.onSingleTapConfirmed(motionEvent);
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
        k kVar = new k(this.eIu.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        kVar.eLX.setConstrainLayoutPool(this.coy);
        kVar.eLX.setImageViewPool(this.coz);
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
            postData2.sD();
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
        if (postData == null || postData.aWp() == null) {
            kVar.eIj.setVisibility(8);
            return;
        }
        TbRichText aBw = postData.aBw();
        com.baidu.tieba.pb.view.h.a(postData.aWp(), kVar.eIj, false, false, aBw != null && StringUtils.isNull(aBw.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHo) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLW.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.eLW.setLayoutParams(layoutParams);
            kVar.eLW.setPadding(0, 0, 0, 0);
            kVar.eLW.ha(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eLW.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            kVar.eLW.setLayoutParams(layoutParams2);
            kVar.eLW.ha(postData.getBimg_url());
        }
        kVar.eLW.setTextViewOnTouchListener(this.eLN);
        kVar.eLW.setTextViewCheckSelection(false);
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
                com.baidu.tbadk.core.util.ai.k(kVar.ayK, d.e.cp_bg_line_c);
                kVar.ayK.setVisibility(0);
            } else {
                kVar.ayK.setVisibility(8);
            }
            kVar.eLV.setTag(null);
            kVar.eLV.setUserId(null);
            kVar.aXz.setText((CharSequence) null);
            kVar.eMb.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gU = com.baidu.tbadk.util.v.gU(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gU > 12) {
                        name_show = com.baidu.tbadk.util.v.E(name_show, 12) + "...";
                    }
                } else if (gU > 14) {
                    name_show = com.baidu.tbadk.util.v.E(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    kVar.aXz.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aS(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    kVar.aXz.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aS = com.baidu.adp.lib.util.j.aS(postData.getAuthor().getName_show());
                    if (aS + i2 > 14) {
                        i3 = 0;
                    } else if (aS + i2 >= 12) {
                        i3 = 1;
                    } else if (aS + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (kVar.eMd != null) {
                    kVar.eMd.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    kVar.eMd.setOnClickListener(this.eIu.eJk.cta);
                    kVar.eMd.a(iconInfo, i3, this.eIu.getResources().getDimensionPixelSize(d.f.ds26), this.eIu.getResources().getDimensionPixelSize(d.f.ds26), this.eIu.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (kVar.eMc != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.eMc.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.eMc.setOnClickListener(this.eIu.eJk.eVF);
                    kVar.eMc.a(tShowInfoNew, 3, this.eIu.getResources().getDimensionPixelSize(d.f.ds36), this.eIu.getResources().getDimensionPixelSize(d.f.ds36), this.eIu.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.u.v(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.ai.c(kVar.aXz, d.e.cp_cont_r, 1);
                } else {
                    com.baidu.tbadk.core.util.ai.c(kVar.aXz, d.e.cp_cont_f, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                kVar.aXz.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                kVar.aXz.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                kVar.aXz.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.p.ab.ge() && name_show2 != null && !name_show2.equals(userName)) {
                    kVar.aXz.setText(com.baidu.tieba.pb.d.ao(this.mContext, kVar.aXz.getText().toString()));
                    kVar.aXz.setGravity(16);
                    kVar.aXz.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPr());
                    com.baidu.tbadk.core.util.ai.c(kVar.aXz, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pV())) {
                    UtilHelper.showHeadImageViewBigV(kVar.eMb.getHeadView(), postData.getAuthor());
                    kVar.eLV.setVisibility(8);
                    kVar.eMb.setVisibility(0);
                    kVar.eMb.getHeadView().c(portrait, 28, false);
                    kVar.eMb.getHeadView().setUserId(postData.getAuthor().getUserId());
                    kVar.eMb.getHeadView().setUserName(postData.getAuthor().getUserName());
                    kVar.eMb.et(postData.getAuthor().getPendantData().pV());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.eLV, postData.getAuthor());
                    kVar.eLV.setUserId(postData.getAuthor().getUserId());
                    kVar.eLV.ac(postData.getAuthor().getUserName(), postData.btq());
                    kVar.eLV.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    kVar.eLV.setImageDrawable(null);
                    kVar.eLV.c(portrait, 28, false);
                    kVar.eLV.setVisibility(0);
                    kVar.eMb.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    kVar.eLQ.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.i(kVar.eLQ, d.e.cp_link_tip_a);
                } else {
                    kVar.eLQ.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.h btj = postData.btj();
            if (btj != null && !StringUtils.isNull(btj.getName())) {
                final String name = btj.getName();
                final String lat = btj.getLat();
                final String lng = btj.getLng();
                kVar.eLS.setVisibility(0);
                kVar.eLS.setText(btj.getName());
                kVar.eLS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.i.hr()) {
                                com.baidu.tbadk.browser.a.T(j.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, j.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                j.this.eIu.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                kVar.eLS.setVisibility(8);
            }
            kVar.eLR.setText(postData.bti());
            if (postData.btu() != null && !StringUtils.isNull(postData.btu().getForumName())) {
                kVar.cbb.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.btu().getForumName(), 5, true)));
                kVar.cbb.setVisibility(0);
            } else {
                kVar.cbb.setVisibility(8);
            }
            int i4 = 0;
            if (this.eIu.aRE()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.btu() != null) {
                i4 = postData.btu().ra();
            }
            if (i4 > 0) {
                kVar.eMa.setVisibility(0);
                com.baidu.tbadk.core.util.ai.c(kVar.eMa, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                kVar.eMa.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.btg()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eHq != null && this.eHq.aQb() != 0) {
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
            if (this.eHq != null && this.eHq.aPQ() != null && this.eHq.aPQ().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eHq.aPQ().getAuthor().getUserId();
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
                    if (postData.btg() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHq.aQb()));
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
                        if (this.eHq.aPQ() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eHq.aPQ().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHq.aQb()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    kVar.eLU.setTag(sparseArray);
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
            if (postData.btg() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            kVar.eLU.setTag(sparseArray);
        }
    }

    private void c(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.eLT.a(postData.btt(), postData.bts(), false);
            kVar.eLT.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            if (postData.btg() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.btg()));
                kVar.eLZ.setVisibility(0);
                kVar.eLZ.setText(format);
                return;
            }
            kVar.eLZ.setVisibility(8);
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLW.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds110);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.eLW.setPadding(0, 0, 0, 0);
            if (!this.eHo) {
                kVar.eLW.setIsSupportVitality(false);
                kVar.eLW.setDefaultImageId(d.g.icon_click);
            } else {
                kVar.eLW.ha(null);
                kVar.eLW.setBackgroundDrawable(null);
                kVar.eLW.setIsSupportVitality(false);
                kVar.eLW.setDefaultImageId(d.g.transparent_bg);
            }
            kVar.eLW.setVideoImageId(d.g.pic_video);
            a(kVar.eLW, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.eLW.setLayoutParams(layoutParams);
            kVar.eLW.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            kVar.eLW.setIsFromCDN(this.mIsFromCDN);
            kVar.eLW.a(postData.aBw(), true, this.eLM);
            SparseArray sparseArray = (SparseArray) kVar.eLW.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            kVar.eLW.setTag(sparseArray);
            kVar.eHD.setTag(d.h.tag_from, sparseArray);
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
            if (postData.btk() > 0 && postData.btd() != null && postData.btd().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLY.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds116);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
                layoutParams.bottomMargin = 0;
                kVar.eLY.setLayoutParams(layoutParams);
                if (this.eHr == null) {
                    this.eHr = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHr.setIsFromCDN(this.mIsFromCDN);
                    this.eHr.I(this.eHt);
                    String str = null;
                    if (this.eHq != null && this.eHq.aPQ() != null && this.eHq.aPQ().getAuthor() != null) {
                        str = this.eHq.aPQ().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eHq != null) {
                        this.eHr.C(this.eHq.aQb(), z);
                        this.eHr.U(this.eHq.aPQ());
                    }
                }
                this.eHr.pK(postData.getId());
                kVar.eLY.setVisibility(0);
                kVar.eLY.a(postData, view);
                kVar.eLY.setChildOnClickListener(this.cNL);
                kVar.eLY.setChildOnLongClickListener(this.awo);
                kVar.eLY.setChildOnTouchListener(this.eLN);
                kVar.eLY.setSubPbAdapter(this.eHr);
                kVar.eLY.setVisibility(0);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eLY.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                kVar.eLY.setLayoutParams(layoutParams2);
                kVar.eLY.setVisibility(8);
            }
            if (postData.gks) {
                kVar.ayL.setVisibility(0);
            } else {
                kVar.ayL.setVisibility(4);
            }
        }
    }

    private void a(k kVar) {
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.c(kVar.aXz, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eLQ, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eLR, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eLZ, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.cbb, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eLS, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.k(kVar.ayL, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(kVar.eLU, d.g.icon_floor_more_selector);
                kVar.eLW.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.k(kVar.eLY, d.e.cp_bg_line_e);
                kVar.eLX.onChangeSkinType();
                kVar.eLT.onChangeSkinType();
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.eHD.setOnTouchListener(this.eLN);
        kVar.eHD.setOnLongClickListener(this.awo);
        if (this.eIu.getPageContext() != null && this.eIu.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk;
            kVar.aXz.setOnClickListener(aVar.eVE);
            kVar.eLV.setOnClickListener(aVar.eVE);
            kVar.eMb.setOnClickListener(aVar.eVE);
            kVar.eMb.getHeadView().setOnClickListener(aVar.eVE);
            kVar.eLW.setOnLongClickListener(this.awo);
            kVar.eLW.setOnTouchListener(this.eLN);
            kVar.eLW.setCommonTextViewOnClickListener(this.cNL);
            kVar.eLW.setOnImageClickListener(this.aRN);
            kVar.eLW.setOnImageTouchListener(this.eLN);
            kVar.eLW.setOnEmotionClickListener(aVar.eVG);
            kVar.eLU.setOnClickListener(this.cNL);
            kVar.eLT.setOnClickListener(this.cNL);
            kVar.eIj.setOnClickListener(this.cNL);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eLM = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHq = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iS(boolean z) {
        this.eHo = z;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eIu.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.eLW.setTextViewOnTouchListener(this.aRO);
        kVar.eLW.setTextViewCheckSelection(false);
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

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRO = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awo = onLongClickListener;
    }
}
