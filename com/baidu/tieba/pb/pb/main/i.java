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
public class i extends k<PostData, j> implements View.OnClickListener {
    private TbRichTextView.f aSw;
    private com.baidu.tieba.pb.a.c aSx;
    private View.OnLongClickListener auG;
    private int cWi;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwD;
    private com.baidu.adp.lib.e.b<TbImageView> cwE;
    private boolean eAa;
    protected com.baidu.tieba.pb.data.f eAc;
    private com.baidu.tieba.pb.pb.sub.d eAd;
    private View.OnClickListener eAf;
    private View.OnClickListener eAg;
    private int eEv;
    private int eEw;
    private TbRichTextView.b eEx;
    private com.baidu.tieba.pb.a.c eEy;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData be;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.eAg != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).brL() && this.eAg != null && this.eDC != null && (be = this.eDC.be(findViewById)) != null) {
                TiebaStatic.log(this.eDC.aOl().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", be.brL() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eEv = 0;
        this.cWi = 0;
        this.eEw = 0;
        this.eEx = null;
        this.eAa = true;
        this.mHostId = null;
        this.eAc = null;
        this.eAf = null;
        this.eAg = null;
        this.aSw = null;
        this.aSx = null;
        this.auG = null;
        this.eAd = null;
        this.cwD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajm */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cwE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
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
        this.eEy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.eDC == null || i.this.eDC.aOh() == null || i.this.eDC.aOh().aQV())) {
                    if (view instanceof NoPressedLinearLayout) {
                        i.this.a((NoPressedLinearLayout) view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof NoPressedLinearLayout) {
                                i.this.a((NoPressedLinearLayout) parent);
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
                if (i.this.aSx != null) {
                    if (!(view instanceof TbListTextView) || i.this.eAg == null) {
                        i.this.aSx.bb(view);
                        i.this.aSx.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    i.this.eAg.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.eDC.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        jVar.eEJ.setConstrainLayoutPool(this.cwD);
        jVar.eEJ.setImageViewPool(this.cwE);
        a(jVar);
        this.eEv = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds8);
        this.cWi = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds20);
        this.eEw = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds34);
        return jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, j jVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, jVar);
        a(jVar);
        b(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            h(postData2);
            postData2.st();
            a(jVar, postData2, view, i);
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            b(jVar, postData, view, i);
            c(jVar, postData);
            c(jVar, postData, view, i);
            d(jVar, postData, view, i);
            d(jVar, postData);
            b(jVar, postData);
            a(jVar, postData);
        }
    }

    private void h(PostData postData) {
        if (postData.YY == 0 && postData.ght) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ad("post_id", postData.getId());
            akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ad("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.aTS() == null) {
            jVar.eAW.setVisibility(8);
            return;
        }
        TbRichText aCd = postData.aCd();
        com.baidu.tieba.pb.view.g.a(postData.aTS(), jVar.eAW, false, false, aCd != null && StringUtils.isNull(aCd.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eAa) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.eEI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.eEI.setLayoutParams(layoutParams);
            jVar.eEI.setPadding(0, 0, 0, 0);
            jVar.eEI.gX(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.eEI.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            jVar.eEI.setLayoutParams(layoutParams2);
            jVar.eEI.gX(postData.getBimg_url());
        }
        jVar.eEI.setTextViewOnTouchListener(this.eEy);
        jVar.eEI.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x05ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(j jVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (jVar != null && postData != null) {
            if (postData.cBz) {
                com.baidu.tbadk.core.util.aj.k(jVar.axd, d.e.cp_bg_line_c);
                jVar.axd.setVisibility(0);
            } else {
                jVar.axd.setVisibility(8);
            }
            jVar.eEH.setTag(null);
            jVar.eEH.setUserId(null);
            jVar.aYX.setText((CharSequence) null);
            jVar.eEN.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gQ = com.baidu.tbadk.util.u.gQ(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gQ > 12) {
                        name_show = com.baidu.tbadk.util.u.E(name_show, 12) + "...";
                    }
                } else if (gQ > 14) {
                    name_show = com.baidu.tbadk.util.u.E(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    jVar.aYX.setText(ah(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.k.aP(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    jVar.aYX.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aP = com.baidu.adp.lib.util.k.aP(postData.getAuthor().getName_show());
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
                if (jVar.eEP != null) {
                    jVar.eEP.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    jVar.eEP.setOnClickListener(this.eDC.eBT.cBo);
                    jVar.eEP.a(iconInfo, i3, this.eDC.getResources().getDimensionPixelSize(d.f.ds26), this.eDC.getResources().getDimensionPixelSize(d.f.ds26), this.eDC.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (jVar.eEO != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.eEO.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.eEO.setOnClickListener(this.eDC.eBT.ePe);
                    jVar.eEO.a(tShowInfoNew, 3, this.eDC.getResources().getDimensionPixelSize(d.f.ds36), this.eDC.getResources().getDimensionPixelSize(d.f.ds36), this.eDC.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.v.u(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(jVar.aYX, d.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(jVar.aYX, d.e.cp_cont_j, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                jVar.aYX.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                jVar.aYX.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                jVar.aYX.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.o.ac.fS() && name_show2 != null && !name_show2.equals(userName)) {
                    jVar.aYX.setText(com.baidu.tieba.pb.c.aq(this.mContext, jVar.aYX.getText().toString()));
                    jVar.aYX.setGravity(16);
                    jVar.aYX.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMD());
                    com.baidu.tbadk.core.util.aj.c(jVar.aYX, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pS())) {
                    UtilHelper.showHeadImageViewBigV(jVar.eEN.getHeadView(), postData.getAuthor());
                    jVar.eEH.setVisibility(8);
                    jVar.eEN.setVisibility(0);
                    jVar.eEN.getHeadView().c(portrait, 28, false);
                    jVar.eEN.getHeadView().setUserId(postData.getAuthor().getUserId());
                    jVar.eEN.getHeadView().setUserName(postData.getAuthor().getUserName());
                    jVar.eEN.ei(postData.getAuthor().getPendantData().pS());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.eEH, postData.getAuthor());
                    jVar.eEH.setUserId(postData.getAuthor().getUserId());
                    jVar.eEH.af(postData.getAuthor().getUserName(), postData.brI());
                    jVar.eEH.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    jVar.eEH.setImageDrawable(null);
                    jVar.eEH.c(portrait, 28, false);
                    jVar.eEH.setVisibility(0);
                    jVar.eEN.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    jVar.eEB.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(jVar.eEB, d.e.cp_link_tip_a);
                } else {
                    jVar.eEB.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.g brB = postData.brB();
            if (brB != null && !StringUtils.isNull(brB.getName())) {
                final String name = brB.getName();
                final String lat = brB.getLat();
                final String lng = brB.getLng();
                jVar.eEE.setVisibility(0);
                jVar.eEE.setText(brB.getName());
                jVar.eEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.hh()) {
                                com.baidu.tbadk.browser.a.T(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                i.this.eDC.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                jVar.eEE.setVisibility(8);
            }
            if (postData.brM() != null && !StringUtils.isNull(postData.brM().getForumName())) {
                jVar.ceM.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.brM().getForumName(), 5, true)));
                jVar.ceM.setVisibility(0);
            } else {
                jVar.ceM.setVisibility(8);
            }
            int i4 = 0;
            if (this.eDC.aOT()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.brM() != null) {
                i4 = postData.brM().qQ();
            }
            if (i4 > 0) {
                jVar.eEM.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(jVar.eEM, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.eEM.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bry()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eAc != null && this.eAc.aNm() != 0) {
                if (this.eAc.aNm() != 1002) {
                    z8 = true;
                }
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
            if (this.eAc != null && this.eAc.aNb() != null && this.eAc.aNb().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eAc.aNb().getAuthor().getUserId();
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
                    if (postData.bry() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eAc.aNm()));
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
                        if (this.eAc.aNb() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eAc.aNb().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eAc.aNm()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    jVar.eEG.setTag(sparseArray);
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
            if (postData.bry() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.eEG.setTag(sparseArray);
        }
    }

    private void c(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.eEF.a(postData.brL(), postData.brK(), false);
            jVar.eEF.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(j jVar, PostData postData) {
        boolean z = true;
        if (jVar != null && postData != null) {
            if (postData.bry() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bry()));
                jVar.eEL.setVisibility(0);
                jVar.eEL.setText(format);
            } else {
                jVar.eEL.setVisibility(8);
                z = false;
            }
            if (z) {
                jVar.eED.setVisibility(0);
                jVar.eEC.setPadding(this.eEv, 0, 0, 0);
            } else {
                jVar.eED.setVisibility(8);
                jVar.eEC.setPadding(0, 0, 0, 0);
            }
            jVar.eEC.setText(postData.brA());
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.eEI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds120);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.eEI.setPadding(0, 0, 0, 0);
            if (!this.eAa) {
                jVar.eEI.setIsSupportVitality(false);
                jVar.eEI.setDefaultImageId(d.g.icon_click);
            } else {
                jVar.eEI.gX(null);
                jVar.eEI.setBackgroundDrawable(null);
                jVar.eEI.setIsSupportVitality(false);
                jVar.eEI.setDefaultImageId(d.g.transparent_bg);
            }
            jVar.eEI.setVideoImageId(d.g.pic_video);
            a(jVar.eEI, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.eEI.setLayoutParams(layoutParams);
            jVar.eEI.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            jVar.eEI.setIsFromCDN(this.mIsFromCDN);
            jVar.eEI.a(postData.aCd(), true, this.eEx);
            SparseArray sparseArray = (SparseArray) jVar.eEI.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            jVar.eEI.setTag(sparseArray);
            jVar.eAq.setTag(d.h.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ad = (((com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ad = (ad - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.setMaxImageWidth(ad - (z ? getDimensionPixelSize(d.f.ds70) : 0));
            tbRichTextView.setMaxImageHeight((int) (ad * 1.618f));
        }
    }

    private void d(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.brC() > 0 && postData.brv() != null && postData.brv().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.eEK.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds10);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds120);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds34);
                layoutParams.bottomMargin = 0;
                jVar.eEK.setLayoutParams(layoutParams);
                if (this.eAd == null) {
                    this.eAd = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eAd.setIsFromCDN(this.mIsFromCDN);
                    this.eAd.E(this.eAf);
                    String str = null;
                    if (this.eAc != null && this.eAc.aNb() != null && this.eAc.aNb().getAuthor() != null) {
                        str = this.eAc.aNb().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eAc != null) {
                        this.eAd.x(this.eAc.aNm(), z);
                        this.eAd.U(this.eAc.aNb());
                    }
                }
                this.eAd.pm(postData.getId());
                jVar.eEK.setSubPbAdapter(this.eAd);
                jVar.eEK.setVisibility(0);
                jVar.eEK.a(postData, view);
                jVar.eEK.setChildOnClickListener(this.eAg);
                jVar.eEK.setChildOnLongClickListener(this.auG);
                jVar.eEK.setChildOnTouchListener(this.eEy);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.eEK.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.eEK.setLayoutParams(layoutParams2);
                jVar.eEK.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            layoutParams3.topMargin = this.cWi;
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.bottomMargin = 0;
            if (jVar.eEK.getVisibility() == 0) {
                layoutParams3.topMargin = this.eEw;
            } else if (jVar.eEE.getVisibility() == 0) {
                layoutParams3.topMargin = this.eEw;
            }
            jVar.mBottomLine.setLayoutParams(layoutParams3);
            if (postData.ghx) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(jVar.aYX, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.eEB, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.eEC, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.j(jVar.eED, d.e.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(jVar.eEL, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.ceM, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.eEE, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.k(jVar.mBottomLine, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(jVar.eEG, d.g.icon_floor_more_selector);
                jVar.eEI.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(jVar.eEK, d.e.cp_bg_line_e);
                jVar.eEJ.onChangeSkinType();
                jVar.eEF.onChangeSkinType();
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.eAq.setOnTouchListener(this.eEy);
        jVar.eAq.setOnLongClickListener(this.auG);
        if (this.eDC.getPageContext() != null && this.eDC.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT;
            jVar.aYX.setOnClickListener(aVar.ePd);
            jVar.eEH.setOnClickListener(aVar.ePd);
            jVar.eEN.setOnClickListener(aVar.ePd);
            jVar.eEN.getHeadView().setOnClickListener(aVar.ePd);
            jVar.eEI.setOnLongClickListener(this.auG);
            jVar.eEI.setOnTouchListener(this.eEy);
            jVar.eEI.setCommonTextViewOnClickListener(this.eAg);
            jVar.eEI.setOnImageClickListener(this.aSw);
            jVar.eEI.setOnImageTouchListener(this.eEy);
            jVar.eEI.setOnEmotionClickListener(aVar.ePf);
            jVar.eEG.setOnClickListener(this.eAg);
            jVar.eEF.setOnClickListener(this.eAg);
            jVar.eAW.setOnClickListener(this.eAg);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eEx = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eAc = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iE(boolean z) {
        this.eAa = z;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eDC.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.eEI.setTextViewOnTouchListener(this.aSx);
        jVar.eEI.setTextViewCheckSelection(false);
    }

    public void C(View.OnClickListener onClickListener) {
        this.eAf = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eAg = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSw = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auG = onLongClickListener;
    }
}
