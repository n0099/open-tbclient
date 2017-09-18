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
    private TbRichTextView.e aRv;
    private com.baidu.tieba.pb.a.c aRw;
    private View.OnLongClickListener avy;
    private View.OnClickListener cUW;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvV;
    private com.baidu.adp.lib.e.b<TbImageView> cvW;
    private boolean eGD;
    protected com.baidu.tieba.pb.data.f eGF;
    private com.baidu.tieba.pb.pb.sub.d eGG;
    private View.OnClickListener eGI;
    private int eKV;
    private int eKW;
    private int eKX;
    private TbRichTextView.b eKY;
    private com.baidu.tieba.pb.a.c eKZ;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bi;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.cUW != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).bsM() && this.cUW != null && this.eHK != null && (bi = this.eHK.bi(findViewById)) != null) {
                TiebaStatic.log(this.eHK.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", bi.bsM() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eKV = 0;
        this.eKW = 0;
        this.eKX = 0;
        this.eKY = null;
        this.eGD = true;
        this.mHostId = null;
        this.eGF = null;
        this.eGI = null;
        this.cUW = null;
        this.aRv = null;
        this.aRw = null;
        this.avy = null;
        this.eGG = null;
        this.cvV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aji */
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
        this.cvW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
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
        this.eKZ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.eHK == null || j.this.eHK.aQm() == null || j.this.eHK.aQm().aSR())) {
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
                if (j.this.aRw != null) {
                    if (!(view instanceof TbListTextView) || j.this.cUW == null) {
                        j.this.aRw.bf(view);
                        j.this.aRw.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.cUW.onClick(view);
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
        k kVar = new k(this.eHK.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        kVar.eLk.setConstrainLayoutPool(this.cvV);
        kVar.eLk.setImageViewPool(this.cvW);
        a(kVar);
        this.eKV = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds8);
        this.eKW = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds20);
        this.eKX = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds34);
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
        if (postData.YY == 0 && postData.gjJ) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ad("post_id", postData.getId());
            akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ad("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.aVJ() == null) {
            kVar.eHy.setVisibility(8);
            return;
        }
        TbRichText aDr = postData.aDr();
        com.baidu.tieba.pb.view.g.a(postData.aVJ(), kVar.eHy, false, false, aDr != null && StringUtils.isNull(aDr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eGD) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLj.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.eLj.setLayoutParams(layoutParams);
            kVar.eLj.setPadding(0, 0, 0, 0);
            kVar.eLj.gZ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eLj.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            kVar.eLj.setLayoutParams(layoutParams2);
            kVar.eLj.gZ(postData.getBimg_url());
        }
        kVar.eLj.setTextViewOnTouchListener(this.eKZ);
        kVar.eLj.setTextViewCheckSelection(false);
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
            if (postData.cAG) {
                com.baidu.tbadk.core.util.aj.k(kVar.axT, d.e.cp_bg_line_c);
                kVar.axT.setVisibility(0);
            } else {
                kVar.axT.setVisibility(8);
            }
            kVar.eLi.setTag(null);
            kVar.eLi.setUserId(null);
            kVar.aXj.setText((CharSequence) null);
            kVar.eLo.getHeadView().setUserId(null);
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
                    kVar.aXj.setText(ah(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aP(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    kVar.aXj.setText(name_show);
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
                if (kVar.eLq != null) {
                    kVar.eLq.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    kVar.eLq.setOnClickListener(this.eHK.eIz.cAv);
                    kVar.eLq.a(iconInfo, i3, this.eHK.getResources().getDimensionPixelSize(d.f.ds26), this.eHK.getResources().getDimensionPixelSize(d.f.ds26), this.eHK.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (kVar.eLp != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.eLp.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.eLp.setOnClickListener(this.eHK.eIz.eVc);
                    kVar.eLp.a(tShowInfoNew, 3, this.eHK.getResources().getDimensionPixelSize(d.f.ds36), this.eHK.getResources().getDimensionPixelSize(d.f.ds36), this.eHK.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.v.v(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(kVar.aXj, d.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(kVar.aXj, d.e.cp_cont_j, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                kVar.aXj.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                kVar.aXj.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                kVar.aXj.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.p.ac.fT() && name_show2 != null && !name_show2.equals(userName)) {
                    kVar.aXj.setText(com.baidu.tieba.pb.d.ao(this.mContext, kVar.aXj.getText().toString()));
                    kVar.aXj.setGravity(16);
                    kVar.aXj.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOJ());
                    com.baidu.tbadk.core.util.aj.c(kVar.aXj, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pR())) {
                    UtilHelper.showHeadImageViewBigV(kVar.eLo.getHeadView(), postData.getAuthor());
                    kVar.eLi.setVisibility(8);
                    kVar.eLo.setVisibility(0);
                    kVar.eLo.getHeadView().c(portrait, 28, false);
                    kVar.eLo.getHeadView().setUserId(postData.getAuthor().getUserId());
                    kVar.eLo.getHeadView().setUserName(postData.getAuthor().getUserName());
                    kVar.eLo.eq(postData.getAuthor().getPendantData().pR());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.eLi, postData.getAuthor());
                    kVar.eLi.setUserId(postData.getAuthor().getUserId());
                    kVar.eLi.af(postData.getAuthor().getUserName(), postData.bsJ());
                    kVar.eLi.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    kVar.eLi.setImageDrawable(null);
                    kVar.eLi.c(portrait, 28, false);
                    kVar.eLi.setVisibility(0);
                    kVar.eLo.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    kVar.eLc.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(kVar.eLc, d.e.cp_link_tip_a);
                } else {
                    kVar.eLc.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.h bsC = postData.bsC();
            if (bsC != null && !StringUtils.isNull(bsC.getName())) {
                final String name = bsC.getName();
                final String lat = bsC.getLat();
                final String lng = bsC.getLng();
                kVar.eLf.setVisibility(0);
                kVar.eLf.setText(bsC.getName());
                kVar.eLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.i.hi()) {
                                com.baidu.tbadk.browser.a.T(j.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, j.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                j.this.eHK.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                kVar.eLf.setVisibility(8);
            }
            if (postData.bsN() != null && !StringUtils.isNull(postData.bsN().getForumName())) {
                kVar.ceL.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.bsN().getForumName(), 5, true)));
                kVar.ceL.setVisibility(0);
            } else {
                kVar.ceL.setVisibility(8);
            }
            int i4 = 0;
            if (this.eHK.aQY()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.bsN() != null) {
                i4 = postData.bsN().qW();
            }
            if (i4 > 0) {
                kVar.eLn.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(kVar.eLn, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                kVar.eLn.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsz()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eGF != null && this.eGF.aPt() != 0) {
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
            if (this.eGF != null && this.eGF.aPi() != null && this.eGF.aPi().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eGF.aPi().getAuthor().getUserId();
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
                    if (postData.bsz() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eGF.aPt()));
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
                        if (this.eGF.aPi() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eGF.aPi().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eGF.aPt()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    kVar.eLh.setTag(sparseArray);
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
            if (postData.bsz() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            kVar.eLh.setTag(sparseArray);
        }
    }

    private void c(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.eLg.a(postData.bsM(), postData.bsL(), false);
            kVar.eLg.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(k kVar, PostData postData) {
        boolean z = true;
        if (kVar != null && postData != null) {
            if (postData.bsz() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsz()));
                kVar.eLm.setVisibility(0);
                kVar.eLm.setText(format);
            } else {
                kVar.eLm.setVisibility(8);
                z = false;
            }
            if (z) {
                kVar.eLe.setVisibility(0);
                kVar.eLd.setPadding(this.eKV, 0, 0, 0);
            } else {
                kVar.eLe.setVisibility(8);
                kVar.eLd.setPadding(0, 0, 0, 0);
            }
            kVar.eLd.setText(postData.bsB());
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLj.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds120);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.eLj.setPadding(0, 0, 0, 0);
            if (!this.eGD) {
                kVar.eLj.setIsSupportVitality(false);
                kVar.eLj.setDefaultImageId(d.g.icon_click);
            } else {
                kVar.eLj.gZ(null);
                kVar.eLj.setBackgroundDrawable(null);
                kVar.eLj.setIsSupportVitality(false);
                kVar.eLj.setDefaultImageId(d.g.transparent_bg);
            }
            kVar.eLj.setVideoImageId(d.g.pic_video);
            a(kVar.eLj, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.eLj.setLayoutParams(layoutParams);
            kVar.eLj.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            kVar.eLj.setIsFromCDN(this.mIsFromCDN);
            kVar.eLj.a(postData.aDr(), true, this.eKY);
            SparseArray sparseArray = (SparseArray) kVar.eLj.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            kVar.eLj.setTag(sparseArray);
            kVar.eGS.setTag(d.h.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ae = (((com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ae = (ae - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.setMaxImageWidth(ae - (z ? getDimensionPixelSize(d.f.ds70) : 0));
            tbRichTextView.setMaxImageHeight((int) (ae * 1.618f));
        }
    }

    private void d(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.bsD() > 0 && postData.bsw() != null && postData.bsw().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eLl.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds10);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds120);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds34);
                layoutParams.bottomMargin = 0;
                kVar.eLl.setLayoutParams(layoutParams);
                if (this.eGG == null) {
                    this.eGG = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eGG.setIsFromCDN(this.mIsFromCDN);
                    this.eGG.C(this.eGI);
                    String str = null;
                    if (this.eGF != null && this.eGF.aPi() != null && this.eGF.aPi().getAuthor() != null) {
                        str = this.eGF.aPi().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eGF != null) {
                        this.eGG.z(this.eGF.aPt(), z);
                        this.eGG.Z(this.eGF.aPi());
                    }
                }
                this.eGG.pD(postData.getId());
                kVar.eLl.setSubPbAdapter(this.eGG);
                kVar.eLl.setVisibility(0);
                kVar.eLl.a(postData, view);
                kVar.eLl.setChildOnClickListener(this.cUW);
                kVar.eLl.setChildOnLongClickListener(this.avy);
                kVar.eLl.setChildOnTouchListener(this.eKZ);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eLl.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                kVar.eLl.setLayoutParams(layoutParams2);
                kVar.eLl.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) kVar.axU.getLayoutParams();
            layoutParams3.topMargin = this.eKW;
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.bottomMargin = 0;
            if (kVar.eLl.getVisibility() == 0) {
                layoutParams3.topMargin = this.eKX;
            } else if (kVar.eLf.getVisibility() == 0) {
                layoutParams3.topMargin = this.eKX;
            }
            kVar.axU.setLayoutParams(layoutParams3);
            if (postData.gjN) {
                kVar.axU.setVisibility(0);
            } else {
                kVar.axU.setVisibility(4);
            }
        }
    }

    private void a(k kVar) {
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(kVar.aXj, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.eLc, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.eLd, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.j(kVar.eLe, d.e.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(kVar.eLm, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.ceL, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(kVar.eLf, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.k(kVar.axU, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(kVar.eLh, d.g.icon_floor_more_selector);
                kVar.eLj.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(kVar.eLl, d.e.cp_bg_line_e);
                kVar.eLk.onChangeSkinType();
                kVar.eLg.onChangeSkinType();
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.eGS.setOnTouchListener(this.eKZ);
        kVar.eGS.setOnLongClickListener(this.avy);
        if (this.eHK.getPageContext() != null && this.eHK.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz;
            kVar.aXj.setOnClickListener(aVar.eVb);
            kVar.eLi.setOnClickListener(aVar.eVb);
            kVar.eLo.setOnClickListener(aVar.eVb);
            kVar.eLo.getHeadView().setOnClickListener(aVar.eVb);
            kVar.eLj.setOnLongClickListener(this.avy);
            kVar.eLj.setOnTouchListener(this.eKZ);
            kVar.eLj.setCommonTextViewOnClickListener(this.cUW);
            kVar.eLj.setOnImageClickListener(this.aRv);
            kVar.eLj.setOnImageTouchListener(this.eKZ);
            kVar.eLj.setOnEmotionClickListener(aVar.eVd);
            kVar.eLh.setOnClickListener(this.cUW);
            kVar.eLg.setOnClickListener(this.cUW);
            kVar.eHy.setOnClickListener(this.cUW);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eKY = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eGF = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iT(boolean z) {
        this.eGD = z;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eHK.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.eLj.setTextViewOnTouchListener(this.aRw);
        kVar.eLj.setTextViewCheckSelection(false);
    }

    public void A(View.OnClickListener onClickListener) {
        this.eGI = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cUW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRv = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avy = onLongClickListener;
    }
}
