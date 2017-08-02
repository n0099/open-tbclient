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
    private TbRichTextView.e aQA;
    private com.baidu.tieba.pb.a.c aQB;
    private View.OnLongClickListener auW;
    private View.OnClickListener cKt;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cmE;
    private com.baidu.adp.lib.e.b<TbImageView> cmF;
    private boolean eEh;
    protected com.baidu.tieba.pb.data.f eEj;
    private com.baidu.tieba.pb.pb.sub.d eEk;
    private View.OnClickListener eEm;
    private TbRichTextView.b eIF;
    private com.baidu.tieba.pb.a.c eIG;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData ba;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.cKt != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).bsE() && this.cKt != null && this.eFn != null && (ba = this.eFn.ba(findViewById)) != null) {
                TiebaStatic.log(this.eFn.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", ba.bsE() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eIF = null;
        this.eEh = true;
        this.mHostId = null;
        this.eEj = null;
        this.eEm = null;
        this.cKt = null;
        this.aQA = null;
        this.aQB = null;
        this.auW = null;
        this.eEk = null;
        this.cmE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agO */
            public com.baidu.tbadk.widget.layout.b fI() {
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
        this.cmF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xe */
            public TbImageView fI() {
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
        this.eIG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.eFn == null || j.this.eFn.aQb() == null || j.this.eFn.aQb().aSJ())) {
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
                if (j.this.aQB != null) {
                    if (!(view instanceof TbListTextView) || j.this.cKt == null) {
                        j.this.aQB.aX(view);
                        j.this.aQB.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.cKt.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        k kVar = new k(this.eFn.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        kVar.eIQ.setConstrainLayoutPool(this.cmE);
        kVar.eIQ.setImageViewPool(this.cmF);
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
            postData2.st();
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
        if (postData.Yw == 0 || postData.ghl) {
            com.baidu.tbadk.core.util.aj ajVar = new com.baidu.tbadk.core.util.aj("c12203");
            ajVar.aa("post_id", postData.getId());
            ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            ajVar.aa("cuid", TbadkCoreApplication.getInst().getCuid());
            ajVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(ajVar);
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.aVx() == null) {
            kVar.eFc.setVisibility(8);
            return;
        }
        TbRichText aAE = postData.aAE();
        com.baidu.tieba.pb.view.h.a(postData.aVx(), kVar.eFc, false, false, aAE != null && StringUtils.isNull(aAE.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eEh) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eIP.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.eIP.setLayoutParams(layoutParams);
            kVar.eIP.setPadding(0, 0, 0, 0);
            kVar.eIP.gV(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eIP.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            kVar.eIP.setLayoutParams(layoutParams2);
            kVar.eIP.gV(postData.getBimg_url());
        }
        kVar.eIP.setTextViewOnTouchListener(this.eIG);
        kVar.eIP.setTextViewCheckSelection(false);
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
            if (postData.crt) {
                com.baidu.tbadk.core.util.ai.k(kVar.axs, d.e.cp_bg_line_c);
                kVar.axs.setVisibility(0);
            } else {
                kVar.axs.setVisibility(8);
            }
            kVar.eIO.setTag(null);
            kVar.eIO.setUserId(null);
            kVar.aWn.setText((CharSequence) null);
            kVar.eIU.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gP = com.baidu.tbadk.util.v.gP(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gP > 12) {
                        name_show = com.baidu.tbadk.util.v.E(name_show, 12) + "...";
                    }
                } else if (gP > 14) {
                    name_show = com.baidu.tbadk.util.v.E(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    kVar.aWn.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aM(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    kVar.aWn.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aM = com.baidu.adp.lib.util.j.aM(postData.getAuthor().getName_show());
                    if (aM + i2 > 14) {
                        i3 = 0;
                    } else if (aM + i2 >= 12) {
                        i3 = 1;
                    } else if (aM + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (kVar.eIW != null) {
                    kVar.eIW.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    kVar.eIW.setOnClickListener(this.eFn.eGd.cri);
                    kVar.eIW.a(iconInfo, i3, this.eFn.getResources().getDimensionPixelSize(d.f.ds26), this.eFn.getResources().getDimensionPixelSize(d.f.ds26), this.eFn.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (kVar.eIV != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.eIV.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.eIV.setOnClickListener(this.eFn.eGd.eSz);
                    kVar.eIV.a(tShowInfoNew, 3, this.eFn.getResources().getDimensionPixelSize(d.f.ds36), this.eFn.getResources().getDimensionPixelSize(d.f.ds36), this.eFn.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.u.v(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.ai.c(kVar.aWn, d.e.cp_cont_r, 1);
                } else {
                    com.baidu.tbadk.core.util.ai.c(kVar.aWn, d.e.cp_cont_f, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                kVar.aWn.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                kVar.aWn.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                kVar.aWn.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.p.ab.fS() && name_show2 != null && !name_show2.equals(userName)) {
                    kVar.aWn.setText(com.baidu.tieba.pb.d.ao(this.mContext, kVar.aWn.getText().toString()));
                    kVar.aWn.setGravity(16);
                    kVar.aWn.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOz());
                    com.baidu.tbadk.core.util.ai.c(kVar.aWn, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pL())) {
                    UtilHelper.showHeadImageViewBigV(kVar.eIU.getHeadView(), postData.getAuthor());
                    kVar.eIO.setVisibility(8);
                    kVar.eIU.setVisibility(0);
                    kVar.eIU.getHeadView().c(portrait, 28, false);
                    kVar.eIU.getHeadView().setUserId(postData.getAuthor().getUserId());
                    kVar.eIU.getHeadView().setUserName(postData.getAuthor().getUserName());
                    kVar.eIU.en(postData.getAuthor().getPendantData().pL());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.eIO, postData.getAuthor());
                    kVar.eIO.setUserId(postData.getAuthor().getUserId());
                    kVar.eIO.ac(postData.getAuthor().getUserName(), postData.bsB());
                    kVar.eIO.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    kVar.eIO.setImageDrawable(null);
                    kVar.eIO.c(portrait, 28, false);
                    kVar.eIO.setVisibility(0);
                    kVar.eIU.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    kVar.eIJ.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.i(kVar.eIJ, d.e.cp_link_tip_a);
                } else {
                    kVar.eIJ.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.h bsu = postData.bsu();
            if (bsu != null && !StringUtils.isNull(bsu.getName())) {
                final String name = bsu.getName();
                final String lat = bsu.getLat();
                final String lng = bsu.getLng();
                kVar.eIL.setVisibility(0);
                kVar.eIL.setText(bsu.getName());
                kVar.eIL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.i.hh()) {
                                com.baidu.tbadk.browser.a.T(j.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, j.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                j.this.eFn.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                kVar.eIL.setVisibility(8);
            }
            kVar.eIK.setText(postData.bst());
            if (postData.bsF() != null && !StringUtils.isNull(postData.bsF().getForumName())) {
                kVar.bZj.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.bsF().getForumName(), 5, true)));
                kVar.bZj.setVisibility(0);
            } else {
                kVar.bZj.setVisibility(8);
            }
            int i4 = 0;
            if (this.eFn.aQM()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.bsF() != null) {
                i4 = postData.bsF().qQ();
            }
            if (i4 > 0) {
                kVar.eIT.setVisibility(0);
                com.baidu.tbadk.core.util.ai.c(kVar.eIT, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                kVar.eIT.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsr()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eEj != null && this.eEj.aPj() != 0) {
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
            if (this.eEj != null && this.eEj.aOY() != null && this.eEj.aOY().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eEj.aOY().getAuthor().getUserId();
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
                    if (postData.bsr() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eEj.aPj()));
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
                        if (this.eEj.aOY() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eEj.aOY().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eEj.aPj()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    kVar.eIN.setTag(sparseArray);
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
            if (postData.bsr() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            kVar.eIN.setTag(sparseArray);
        }
    }

    private void c(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.eIM.a(postData.bsE(), postData.bsD(), false);
            kVar.eIM.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            if (postData.bsr() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsr()));
                kVar.eIS.setVisibility(0);
                kVar.eIS.setText(format);
                return;
            }
            kVar.eIS.setVisibility(8);
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eIP.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds110);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.eIP.setPadding(0, 0, 0, 0);
            if (!this.eEh) {
                kVar.eIP.setIsSupportVitality(false);
                kVar.eIP.setDefaultImageId(d.g.icon_click);
            } else {
                kVar.eIP.gV(null);
                kVar.eIP.setBackgroundDrawable(null);
                kVar.eIP.setIsSupportVitality(false);
                kVar.eIP.setDefaultImageId(d.g.transparent_bg);
            }
            kVar.eIP.setVideoImageId(d.g.pic_video);
            a(kVar.eIP, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.eIP.setLayoutParams(layoutParams);
            kVar.eIP.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            kVar.eIP.setIsFromCDN(this.mIsFromCDN);
            kVar.eIP.a(postData.aAE(), true, this.eIF);
            SparseArray sparseArray = (SparseArray) kVar.eIP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            kVar.eIP.setTag(sparseArray);
            kVar.eEw.setTag(d.h.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int af = (((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                af = (af - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.setMaxImageWidth(af - (z ? getDimensionPixelSize(d.f.ds70) : 0));
            tbRichTextView.setMaxImageHeight((int) (af * 1.618f));
        }
    }

    private void d(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.bsv() > 0 && postData.bso() != null && postData.bso().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eIR.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds116);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
                layoutParams.bottomMargin = 0;
                kVar.eIR.setLayoutParams(layoutParams);
                if (this.eEk == null) {
                    this.eEk = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eEk.setIsFromCDN(this.mIsFromCDN);
                    this.eEk.I(this.eEm);
                    String str = null;
                    if (this.eEj != null && this.eEj.aOY() != null && this.eEj.aOY().getAuthor() != null) {
                        str = this.eEj.aOY().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eEj != null) {
                        this.eEk.B(this.eEj.aPj(), z);
                        this.eEk.U(this.eEj.aOY());
                    }
                }
                this.eEk.pD(postData.getId());
                kVar.eIR.setVisibility(0);
                kVar.eIR.a(postData, view);
                kVar.eIR.setChildOnClickListener(this.cKt);
                kVar.eIR.setChildOnLongClickListener(this.auW);
                kVar.eIR.setChildOnTouchListener(this.eIG);
                kVar.eIR.setSubPbAdapter(this.eEk);
                kVar.eIR.setVisibility(0);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eIR.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                kVar.eIR.setLayoutParams(layoutParams2);
                kVar.eIR.setVisibility(8);
            }
            if (postData.gho) {
                kVar.axt.setVisibility(0);
            } else {
                kVar.axt.setVisibility(4);
            }
        }
    }

    private void a(k kVar) {
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.c(kVar.aWn, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eIJ, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eIK, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eIS, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.bZj, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eIL, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.k(kVar.axt, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(kVar.eIN, d.g.icon_floor_more_selector);
                kVar.eIP.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.k(kVar.eIR, d.e.cp_bg_line_e);
                kVar.eIQ.onChangeSkinType();
                kVar.eIM.onChangeSkinType();
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.eEw.setOnTouchListener(this.eIG);
        kVar.eEw.setOnLongClickListener(this.auW);
        if (this.eFn.getPageContext() != null && this.eFn.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd;
            kVar.aWn.setOnClickListener(aVar.eSy);
            kVar.eIO.setOnClickListener(aVar.eSy);
            kVar.eIU.setOnClickListener(aVar.eSy);
            kVar.eIU.getHeadView().setOnClickListener(aVar.eSy);
            kVar.eIP.setOnLongClickListener(this.auW);
            kVar.eIP.setOnTouchListener(this.eIG);
            kVar.eIP.setCommonTextViewOnClickListener(this.cKt);
            kVar.eIP.setOnImageClickListener(this.aQA);
            kVar.eIP.setOnImageTouchListener(this.eIG);
            kVar.eIP.setOnEmotionClickListener(aVar.eSA);
            kVar.eIN.setOnClickListener(this.cKt);
            kVar.eIM.setOnClickListener(this.cKt);
            kVar.eFc.setOnClickListener(this.cKt);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eIF = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eEj = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iP(boolean z) {
        this.eEh = z;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eFn.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.eIP.setTextViewOnTouchListener(this.aQB);
        kVar.eIP.setTextViewCheckSelection(false);
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

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aQB = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auW = onLongClickListener;
    }
}
