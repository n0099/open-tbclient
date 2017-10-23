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
    private TbRichTextView.f aSj;
    private com.baidu.tieba.pb.a.c aSk;
    private View.OnLongClickListener auu;
    private int cVW;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwr;
    private com.baidu.adp.lib.e.b<TbImageView> cws;
    private int eEh;
    private int eEi;
    private TbRichTextView.b eEj;
    private com.baidu.tieba.pb.a.c eEk;
    private boolean ezM;
    protected com.baidu.tieba.pb.data.f ezO;
    private com.baidu.tieba.pb.pb.sub.d ezP;
    private View.OnClickListener ezR;
    private View.OnClickListener ezS;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData be;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.ezS != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).brD() && this.ezS != null && this.eDo != null && (be = this.eDo.be(findViewById)) != null) {
                TiebaStatic.log(this.eDo.aOg().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", be.brD() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eEh = 0;
        this.cVW = 0;
        this.eEi = 0;
        this.eEj = null;
        this.ezM = true;
        this.mHostId = null;
        this.ezO = null;
        this.ezR = null;
        this.ezS = null;
        this.aSj = null;
        this.aSk = null;
        this.auu = null;
        this.ezP = null;
        this.cwr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajh */
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
        this.cws = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wF */
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
        this.eEk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.eDo == null || i.this.eDo.aOc() == null || i.this.eDo.aOc().aQQ())) {
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
                if (i.this.aSk != null) {
                    if (!(view instanceof TbListTextView) || i.this.ezS == null) {
                        i.this.aSk.bb(view);
                        i.this.aSk.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    i.this.ezS.onClick(view);
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
        j jVar = new j(this.eDo.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        jVar.eEv.setConstrainLayoutPool(this.cwr);
        jVar.eEv.setImageViewPool(this.cws);
        a(jVar);
        this.eEh = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds8);
        this.cVW = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds20);
        this.eEi = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds34);
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
            postData2.sm();
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
        if (postData.YM == 0 && postData.ghe) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ac("post_id", postData.getId());
            akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.aTN() == null) {
            jVar.eAI.setVisibility(8);
            return;
        }
        TbRichText aBY = postData.aBY();
        com.baidu.tieba.pb.view.g.a(postData.aTN(), jVar.eAI, false, false, aBY != null && StringUtils.isNull(aBY.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ezM) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.eEu.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.eEu.setLayoutParams(layoutParams);
            jVar.eEu.setPadding(0, 0, 0, 0);
            jVar.eEu.gW(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.eEu.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            jVar.eEu.setLayoutParams(layoutParams2);
            jVar.eEu.gW(postData.getBimg_url());
        }
        jVar.eEu.setTextViewOnTouchListener(this.eEk);
        jVar.eEu.setTextViewCheckSelection(false);
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
            if (postData.cBn) {
                com.baidu.tbadk.core.util.aj.k(jVar.awR, d.e.cp_bg_line_c);
                jVar.awR.setVisibility(0);
            } else {
                jVar.awR.setVisibility(8);
            }
            jVar.eEt.setTag(null);
            jVar.eEt.setUserId(null);
            jVar.aYJ.setText((CharSequence) null);
            jVar.eEz.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gP = com.baidu.tbadk.util.u.gP(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gP > 12) {
                        name_show = com.baidu.tbadk.util.u.E(name_show, 12) + "...";
                    }
                } else if (gP > 14) {
                    name_show = com.baidu.tbadk.util.u.E(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    jVar.aYJ.setText(ag(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.k.aP(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    jVar.aYJ.setText(name_show);
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
                if (jVar.eEB != null) {
                    jVar.eEB.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    jVar.eEB.setOnClickListener(this.eDo.eBF.cBc);
                    jVar.eEB.a(iconInfo, i3, this.eDo.getResources().getDimensionPixelSize(d.f.ds26), this.eDo.getResources().getDimensionPixelSize(d.f.ds26), this.eDo.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (jVar.eEA != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.eEA.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.eEA.setOnClickListener(this.eDo.eBF.eOQ);
                    jVar.eEA.a(tShowInfoNew, 3, this.eDo.getResources().getDimensionPixelSize(d.f.ds36), this.eDo.getResources().getDimensionPixelSize(d.f.ds36), this.eDo.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.v.u(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(jVar.aYJ, d.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(jVar.aYJ, d.e.cp_cont_j, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                jVar.aYJ.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                jVar.aYJ.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                jVar.aYJ.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.o.ac.fS() && name_show2 != null && !name_show2.equals(userName)) {
                    jVar.aYJ.setText(com.baidu.tieba.pb.c.al(this.mContext, jVar.aYJ.getText().toString()));
                    jVar.aYJ.setGravity(16);
                    jVar.aYJ.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMy());
                    com.baidu.tbadk.core.util.aj.c(jVar.aYJ, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pL())) {
                    UtilHelper.showHeadImageViewBigV(jVar.eEz.getHeadView(), postData.getAuthor());
                    jVar.eEt.setVisibility(8);
                    jVar.eEz.setVisibility(0);
                    jVar.eEz.getHeadView().c(portrait, 28, false);
                    jVar.eEz.getHeadView().setUserId(postData.getAuthor().getUserId());
                    jVar.eEz.getHeadView().setUserName(postData.getAuthor().getUserName());
                    jVar.eEz.eh(postData.getAuthor().getPendantData().pL());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.eEt, postData.getAuthor());
                    jVar.eEt.setUserId(postData.getAuthor().getUserId());
                    jVar.eEt.ae(postData.getAuthor().getUserName(), postData.brA());
                    jVar.eEt.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    jVar.eEt.setImageDrawable(null);
                    jVar.eEt.c(portrait, 28, false);
                    jVar.eEt.setVisibility(0);
                    jVar.eEz.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    jVar.eEn.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(jVar.eEn, d.e.cp_link_tip_a);
                } else {
                    jVar.eEn.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.g brt = postData.brt();
            if (brt != null && !StringUtils.isNull(brt.getName())) {
                final String name = brt.getName();
                final String lat = brt.getLat();
                final String lng = brt.getLng();
                jVar.eEq.setVisibility(0);
                jVar.eEq.setText(brt.getName());
                jVar.eEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.hh()) {
                                com.baidu.tbadk.browser.a.O(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                i.this.eDo.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                jVar.eEq.setVisibility(8);
            }
            if (postData.brE() != null && !StringUtils.isNull(postData.brE().getForumName())) {
                jVar.ceA.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.brE().getForumName(), 5, true)));
                jVar.ceA.setVisibility(0);
            } else {
                jVar.ceA.setVisibility(8);
            }
            int i4 = 0;
            if (this.eDo.aOO()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.brE() != null) {
                i4 = postData.brE().qJ();
            }
            if (i4 > 0) {
                jVar.eEy.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(jVar.eEy, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                jVar.eEy.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.brq()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.ezO != null && this.ezO.aNh() != 0) {
                if (this.ezO.aNh() != 1002) {
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
            if (this.ezO != null && this.ezO.aMW() != null && this.ezO.aMW().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.ezO.aMW().getAuthor().getUserId();
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
                    if (postData.brq() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.ezO.aNh()));
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
                        if (this.ezO.aMW() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.ezO.aMW().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.ezO.aNh()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    jVar.eEs.setTag(sparseArray);
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
            if (postData.brq() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            jVar.eEs.setTag(sparseArray);
        }
    }

    private void c(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.eEr.a(postData.brD(), postData.brC(), false);
            jVar.eEr.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(j jVar, PostData postData) {
        boolean z = true;
        if (jVar != null && postData != null) {
            if (postData.brq() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.brq()));
                jVar.eEx.setVisibility(0);
                jVar.eEx.setText(format);
            } else {
                jVar.eEx.setVisibility(8);
                z = false;
            }
            if (z) {
                jVar.eEp.setVisibility(0);
                jVar.eEo.setPadding(this.eEh, 0, 0, 0);
            } else {
                jVar.eEp.setVisibility(8);
                jVar.eEo.setPadding(0, 0, 0, 0);
            }
            jVar.eEo.setText(postData.brs());
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.eEu.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds120);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.eEu.setPadding(0, 0, 0, 0);
            if (!this.ezM) {
                jVar.eEu.setIsSupportVitality(false);
                jVar.eEu.setDefaultImageId(d.g.icon_click);
            } else {
                jVar.eEu.gW(null);
                jVar.eEu.setBackgroundDrawable(null);
                jVar.eEu.setIsSupportVitality(false);
                jVar.eEu.setDefaultImageId(d.g.transparent_bg);
            }
            jVar.eEu.setVideoImageId(d.g.pic_video);
            a(jVar.eEu, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.eEu.setLayoutParams(layoutParams);
            jVar.eEu.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            jVar.eEu.setIsFromCDN(this.mIsFromCDN);
            jVar.eEu.a(postData.aBY(), true, this.eEj);
            SparseArray sparseArray = (SparseArray) jVar.eEu.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            jVar.eEu.setTag(sparseArray);
            jVar.eAc.setTag(d.h.tag_from, sparseArray);
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
            if (postData.bru() > 0 && postData.brn() != null && postData.brn().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.eEw.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds10);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds120);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds34);
                layoutParams.bottomMargin = 0;
                jVar.eEw.setLayoutParams(layoutParams);
                if (this.ezP == null) {
                    this.ezP = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.ezP.setIsFromCDN(this.mIsFromCDN);
                    this.ezP.E(this.ezR);
                    String str = null;
                    if (this.ezO != null && this.ezO.aMW() != null && this.ezO.aMW().getAuthor() != null) {
                        str = this.ezO.aMW().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.ezO != null) {
                        this.ezP.x(this.ezO.aNh(), z);
                        this.ezP.U(this.ezO.aMW());
                    }
                }
                this.ezP.pl(postData.getId());
                jVar.eEw.setSubPbAdapter(this.ezP);
                jVar.eEw.setVisibility(0);
                jVar.eEw.a(postData, view);
                jVar.eEw.setChildOnClickListener(this.ezS);
                jVar.eEw.setChildOnLongClickListener(this.auu);
                jVar.eEw.setChildOnTouchListener(this.eEk);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.eEw.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                jVar.eEw.setLayoutParams(layoutParams2);
                jVar.eEw.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            layoutParams3.topMargin = this.cVW;
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.bottomMargin = 0;
            if (jVar.eEw.getVisibility() == 0) {
                layoutParams3.topMargin = this.eEi;
            } else if (jVar.eEq.getVisibility() == 0) {
                layoutParams3.topMargin = this.eEi;
            }
            jVar.mBottomLine.setLayoutParams(layoutParams3);
            if (postData.ghi) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(jVar.aYJ, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.eEn, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.eEo, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.j(jVar.eEp, d.e.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(jVar.eEx, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.ceA, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(jVar.eEq, d.e.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.k(jVar.mBottomLine, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(jVar.eEs, d.g.icon_floor_more_selector);
                jVar.eEu.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(jVar.eEw, d.e.cp_bg_line_e);
                jVar.eEv.onChangeSkinType();
                jVar.eEr.onChangeSkinType();
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.eAc.setOnTouchListener(this.eEk);
        jVar.eAc.setOnLongClickListener(this.auu);
        if (this.eDo.getPageContext() != null && this.eDo.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF;
            jVar.aYJ.setOnClickListener(aVar.eOP);
            jVar.eEt.setOnClickListener(aVar.eOP);
            jVar.eEz.setOnClickListener(aVar.eOP);
            jVar.eEz.getHeadView().setOnClickListener(aVar.eOP);
            jVar.eEu.setOnLongClickListener(this.auu);
            jVar.eEu.setOnTouchListener(this.eEk);
            jVar.eEu.setCommonTextViewOnClickListener(this.ezS);
            jVar.eEu.setOnImageClickListener(this.aSj);
            jVar.eEu.setOnImageTouchListener(this.eEk);
            jVar.eEu.setOnEmotionClickListener(aVar.eOR);
            jVar.eEs.setOnClickListener(this.ezS);
            jVar.eEr.setOnClickListener(this.ezS);
            jVar.eAI.setOnClickListener(this.ezS);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eEj = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ezO = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iD(boolean z) {
        this.ezM = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eDo.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.eEu.setTextViewOnTouchListener(this.aSk);
        jVar.eEu.setTextViewCheckSelection(false);
    }

    public void C(View.OnClickListener onClickListener) {
        this.ezR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.ezS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSj = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSk = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auu = onLongClickListener;
    }
}
