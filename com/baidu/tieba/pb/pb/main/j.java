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
    private TbRichTextView.e aRy;
    private com.baidu.tieba.pb.a.c aRz;
    private View.OnLongClickListener avB;
    private View.OnClickListener cUc;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvd;
    private com.baidu.adp.lib.e.b<TbImageView> cve;
    private boolean eFJ;
    protected com.baidu.tieba.pb.data.f eFL;
    private com.baidu.tieba.pb.pb.sub.d eFM;
    private View.OnClickListener eFO;
    private int eKb;
    private int eKc;
    private int eKd;
    private TbRichTextView.b eKe;
    private com.baidu.tieba.pb.a.c eKf;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bi;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.cUc != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).bsB() && this.cUc != null && this.eGQ != null && (bi = this.eGQ.bi(findViewById)) != null) {
                TiebaStatic.log(this.eGQ.aQf().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", bi.bsB() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eKb = 0;
        this.eKc = 0;
        this.eKd = 0;
        this.eKe = null;
        this.eFJ = true;
        this.mHostId = null;
        this.eFL = null;
        this.eFO = null;
        this.cUc = null;
        this.aRy = null;
        this.aRz = null;
        this.avB = null;
        this.eFM = null;
        this.cvd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aiX */
            public com.baidu.tbadk.widget.layout.b fJ() {
                return new com.baidu.tbadk.widget.layout.b(j.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cve = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xo */
            public TbImageView fJ() {
                TbImageView tbImageView = new TbImageView(j.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.e.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView o(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView p(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.eKf = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.eGQ == null || j.this.eGQ.aQb() == null || j.this.eGQ.aQb().aSG())) {
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
                if (j.this.aRz != null) {
                    if (!(view instanceof TbListTextView) || j.this.cUc == null) {
                        j.this.aRz.bf(view);
                        j.this.aRz.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.cUc.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        k kVar = new k(this.eGQ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        kVar.eKq.setConstrainLayoutPool(this.cvd);
        kVar.eKq.setImageViewPool(this.cve);
        a(kVar);
        this.eKb = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8);
        this.eKc = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds20);
        this.eKd = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34);
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
            postData2.sz();
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
        if (postData.YY == 0 && postData.giP) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ad("post_id", postData.getId());
            akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ad("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.aVy() == null) {
            kVar.eGE.setVisibility(8);
            return;
        }
        TbRichText aDg = postData.aDg();
        com.baidu.tieba.pb.view.g.a(postData.aVy(), kVar.eGE, false, false, aDg != null && StringUtils.isNull(aDg.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eFJ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eKp.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.eKp.setLayoutParams(layoutParams);
            kVar.eKp.setPadding(0, 0, 0, 0);
            kVar.eKp.gZ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eKp.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            kVar.eKp.setLayoutParams(layoutParams2);
            kVar.eKp.gZ(postData.getBimg_url());
        }
        kVar.eKp.setTextViewOnTouchListener(this.eKf);
        kVar.eKp.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05e2  */
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
            if (postData.czO) {
                com.baidu.tbadk.core.util.aj.k(kVar.axW, d.e.cp_bg_line_c);
                kVar.axW.setVisibility(0);
            } else {
                kVar.axW.setVisibility(8);
            }
            kVar.eKo.setTag(null);
            kVar.eKo.setUserId(null);
            kVar.aXm.setText((CharSequence) null);
            kVar.eKu.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gT = com.baidu.tbadk.util.v.gT(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gT > 12) {
                        name_show = com.baidu.tbadk.util.v.E(name_show, 12) + "...";
                    }
                } else if (gT > 14) {
                    name_show = com.baidu.tbadk.util.v.E(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    kVar.aXm.setText(ah(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aP(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    kVar.aXm.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aP = com.baidu.adp.lib.util.j.aP(postData.getAuthor().getName_show());
                    if (aP + i2 > 14) {
                        i3 = 0;
                    } else if (aP + i2 >= 12) {
                        i3 = 1;
                    } else if (aP + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (kVar.eKw != null) {
                    kVar.eKw.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    kVar.eKw.setOnClickListener(this.eGQ.eHF.czD);
                    kVar.eKw.a(iconInfo, i3, this.eGQ.getResources().getDimensionPixelSize(d.f.ds26), this.eGQ.getResources().getDimensionPixelSize(d.f.ds26), this.eGQ.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (kVar.eKv != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.eKv.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.eKv.setOnClickListener(this.eGQ.eHF.eUi);
                    kVar.eKv.a(tShowInfoNew, 3, this.eGQ.getResources().getDimensionPixelSize(d.f.ds36), this.eGQ.getResources().getDimensionPixelSize(d.f.ds36), this.eGQ.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.v.v(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(kVar.aXm, d.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(kVar.aXm, d.e.cp_cont_j, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                kVar.aXm.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                kVar.aXm.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                kVar.aXm.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.p.ac.fT() && name_show2 != null && !name_show2.equals(userName)) {
                    kVar.aXm.setText(com.baidu.tieba.pb.d.ao(this.mContext, kVar.aXm.getText().toString()));
                    kVar.aXm.setGravity(16);
                    kVar.aXm.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOy());
                    com.baidu.tbadk.core.util.aj.c(kVar.aXm, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pR())) {
                    UtilHelper.showHeadImageViewBigV(kVar.eKu.getHeadView(), postData.getAuthor());
                    kVar.eKo.setVisibility(8);
                    kVar.eKu.setVisibility(0);
                    kVar.eKu.getHeadView().c(portrait, 28, false);
                    kVar.eKu.getHeadView().setUserId(postData.getAuthor().getUserId());
                    kVar.eKu.getHeadView().setUserName(postData.getAuthor().getUserName());
                    kVar.eKu.eq(postData.getAuthor().getPendantData().pR());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.eKo, postData.getAuthor());
                    kVar.eKo.setUserId(postData.getAuthor().getUserId());
                    kVar.eKo.af(postData.getAuthor().getUserName(), postData.bsy());
                    kVar.eKo.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    kVar.eKo.setImageDrawable(null);
                    kVar.eKo.c(portrait, 28, false);
                    kVar.eKo.setVisibility(0);
                    kVar.eKu.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    kVar.eKi.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(kVar.eKi, d.e.cp_link_tip_a);
                } else {
                    kVar.eKi.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.h bsr = postData.bsr();
            if (bsr != null && !StringUtils.isNull(bsr.getName())) {
                final String name = bsr.getName();
                final String lat = bsr.getLat();
                final String lng = bsr.getLng();
                kVar.eKl.setVisibility(0);
                kVar.eKl.setText(bsr.getName());
                kVar.eKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.i.hi()) {
                                com.baidu.tbadk.browser.a.T(j.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, j.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                j.this.eGQ.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                kVar.eKl.setVisibility(8);
            }
            if (postData.bsC() != null && !StringUtils.isNull(postData.bsC().getForumName())) {
                kVar.cdT.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.bsC().getForumName(), 5, true)));
                kVar.cdT.setVisibility(0);
            } else {
                kVar.cdT.setVisibility(8);
            }
            int i4 = 0;
            if (this.eGQ.aQN()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.bsC() != null) {
                i4 = postData.bsC().qW();
            }
            if (i4 > 0) {
                kVar.eKt.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(kVar.eKt, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                kVar.eKt.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bso()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eFL != null && this.eFL.aPi() != 0) {
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
            if (this.eFL != null && this.eFL.aOX() != null && this.eFL.aOX().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eFL.aOX().getAuthor().getUserId();
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
                    if (postData.bso() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFL.aPi()));
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
                        if (this.eFL.aOX() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eFL.aOX().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFL.aPi()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    kVar.eKn.setTag(sparseArray);
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
            if (postData.bso() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            kVar.eKn.setTag(sparseArray);
        }
    }

    private void c(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.eKm.a(postData.bsB(), postData.bsA(), false);
            kVar.eKm.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(k kVar, PostData postData) {
        boolean z = true;
        if (kVar != null && postData != null) {
            if (postData.bso() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bso()));
                kVar.eKs.setVisibility(0);
                kVar.eKs.setText(format);
            } else {
                kVar.eKs.setVisibility(8);
                z = false;
            }
            if (z) {
                kVar.eKk.setVisibility(0);
                kVar.eKj.setPadding(this.eKb, 0, 0, 0);
            } else {
                kVar.eKk.setVisibility(8);
                kVar.eKj.setPadding(0, 0, 0, 0);
            }
            kVar.eKj.setText(postData.bsq());
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eKp.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds120);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.eKp.setPadding(0, 0, 0, 0);
            if (!this.eFJ) {
                kVar.eKp.setIsSupportVitality(false);
                kVar.eKp.setDefaultImageId(d.g.icon_click);
            } else {
                kVar.eKp.gZ(null);
                kVar.eKp.setBackgroundDrawable(null);
                kVar.eKp.setIsSupportVitality(false);
                kVar.eKp.setDefaultImageId(d.g.transparent_bg);
            }
            kVar.eKp.setVideoImageId(d.g.pic_video);
            a(kVar.eKp, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.eKp.setLayoutParams(layoutParams);
            kVar.eKp.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            kVar.eKp.setIsFromCDN(this.mIsFromCDN);
            kVar.eKp.a(postData.aDg(), true, this.eKe);
            SparseArray sparseArray = (SparseArray) kVar.eKp.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            kVar.eKp.setTag(sparseArray);
            kVar.eFY.setTag(d.h.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ad = (((com.baidu.adp.lib.util.k.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ad = (ad - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.setMaxImageWidth(ad - (z ? getDimensionPixelSize(d.f.ds70) : 0));
            tbRichTextView.setMaxImageHeight((int) (ad * 1.618f));
        }
    }

    private void d(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.bss() > 0 && postData.bsl() != null && postData.bsl().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eKr.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds120);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34);
                layoutParams.bottomMargin = 0;
                kVar.eKr.setLayoutParams(layoutParams);
                if (this.eFM == null) {
                    this.eFM = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eFM.setIsFromCDN(this.mIsFromCDN);
                    this.eFM.C(this.eFO);
                    String str = null;
                    if (this.eFL != null && this.eFL.aOX() != null && this.eFL.aOX().getAuthor() != null) {
                        str = this.eFL.aOX().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eFL != null) {
                        this.eFM.z(this.eFL.aPi(), z);
                        this.eFM.Z(this.eFL.aOX());
                    }
                }
                this.eFM.pB(postData.getId());
                kVar.eKr.setSubPbAdapter(this.eFM);
                kVar.eKr.setVisibility(0);
                kVar.eKr.a(postData, view);
                kVar.eKr.setChildOnClickListener(this.cUc);
                kVar.eKr.setChildOnLongClickListener(this.avB);
                kVar.eKr.setChildOnTouchListener(this.eKf);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eKr.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                kVar.eKr.setLayoutParams(layoutParams2);
                kVar.eKr.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) kVar.axX.getLayoutParams();
            layoutParams3.topMargin = this.eKc;
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.bottomMargin = 0;
            if (kVar.eKr.getVisibility() == 0) {
                layoutParams3.topMargin = this.eKd;
            } else if (kVar.eKl.getVisibility() == 0) {
                layoutParams3.topMargin = this.eKd;
            }
            kVar.axX.setLayoutParams(layoutParams3);
            if (postData.giT) {
                kVar.axX.setVisibility(0);
            } else {
                kVar.axX.setVisibility(4);
            }
        }
    }

    private void a(k kVar) {
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(kVar.aXm, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.eKi, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.eKj, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.j(kVar.eKk, d.e.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(kVar.eKs, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.cdT, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.eKl, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.k(kVar.axX, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(kVar.eKn, d.g.icon_floor_more_selector);
                kVar.eKp.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(kVar.eKr, d.e.cp_bg_line_e);
                kVar.eKq.onChangeSkinType();
                kVar.eKm.onChangeSkinType();
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.eFY.setOnTouchListener(this.eKf);
        kVar.eFY.setOnLongClickListener(this.avB);
        if (this.eGQ.getPageContext() != null && this.eGQ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF;
            kVar.aXm.setOnClickListener(aVar.eUh);
            kVar.eKo.setOnClickListener(aVar.eUh);
            kVar.eKu.setOnClickListener(aVar.eUh);
            kVar.eKu.getHeadView().setOnClickListener(aVar.eUh);
            kVar.eKp.setOnLongClickListener(this.avB);
            kVar.eKp.setOnTouchListener(this.eKf);
            kVar.eKp.setCommonTextViewOnClickListener(this.cUc);
            kVar.eKp.setOnImageClickListener(this.aRy);
            kVar.eKp.setOnImageTouchListener(this.eKf);
            kVar.eKp.setOnEmotionClickListener(aVar.eUj);
            kVar.eKn.setOnClickListener(this.cUc);
            kVar.eKm.setOnClickListener(this.cUc);
            kVar.eGE.setOnClickListener(this.cUc);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eKe = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eFL = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iS(boolean z) {
        this.eFJ = z;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eGQ.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.eKp.setTextViewOnTouchListener(this.aRz);
        kVar.eKp.setTextViewCheckSelection(false);
    }

    public void A(View.OnClickListener onClickListener) {
        this.eFO = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cUc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRy = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRz = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avB = onLongClickListener;
    }
}
