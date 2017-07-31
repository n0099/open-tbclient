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
    private TbRichTextView.e aRM;
    private com.baidu.tieba.pb.a.c aRN;
    private View.OnLongClickListener awn;
    private View.OnClickListener cLO;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cnQ;
    private com.baidu.adp.lib.e.b<TbImageView> cnR;
    private boolean eFu;
    protected com.baidu.tieba.pb.data.f eFw;
    private com.baidu.tieba.pb.pb.sub.d eFx;
    private View.OnClickListener eFz;
    private TbRichTextView.b eJS;
    private com.baidu.tieba.pb.a.c eJT;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData ba;
        if (noPressedLinearLayout.findViewById(d.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.h.view_floor_praise).getTag(d.h.tag_clip_board) != null && this.cLO != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.h.tag_clip_board)).bsL() && this.cLO != null && this.eGA != null && (ba = this.eGA.ba(findViewById)) != null) {
                TiebaStatic.log(this.eGA.aQq().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", ba.bsL() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eJS = null;
        this.eFu = true;
        this.mHostId = null;
        this.eFw = null;
        this.eFz = null;
        this.cLO = null;
        this.aRM = null;
        this.aRN = null;
        this.awn = null;
        this.eFx = null;
        this.cnQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agV */
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
        this.cnR = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
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
        this.eJT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.eGA == null || j.this.eGA.aQm() == null || j.this.eGA.aQm().aSU())) {
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
                if (j.this.aRN != null) {
                    if (!(view instanceof TbListTextView) || j.this.cLO == null) {
                        j.this.aRN.aX(view);
                        j.this.aRN.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.cLO.onClick(view);
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
        k kVar = new k(this.eGA.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_floor_item_layout, viewGroup, false));
        kVar.eKd.setConstrainLayoutPool(this.cnQ);
        kVar.eKd.setImageViewPool(this.cnR);
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
        if (postData.ZS == 0 || postData.gix) {
            com.baidu.tbadk.core.util.aj ajVar = new com.baidu.tbadk.core.util.aj("c12203");
            ajVar.aa("post_id", postData.getId());
            ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            ajVar.aa("cuid", TbadkCoreApplication.getInst().getCuid());
            ajVar.g("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(ajVar);
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.aVI() == null) {
            kVar.eGp.setVisibility(8);
            return;
        }
        TbRichText aAP = postData.aAP();
        com.baidu.tieba.pb.view.h.a(postData.aVI(), kVar.eGp, false, false, aAP != null && StringUtils.isNull(aAP.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eFu) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eKc.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.eKc.setLayoutParams(layoutParams);
            kVar.eKc.setPadding(0, 0, 0, 0);
            kVar.eKc.ha(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eKc.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.f.ds20);
            kVar.eKc.setLayoutParams(layoutParams2);
            kVar.eKc.ha(postData.getBimg_url());
        }
        kVar.eKc.setTextViewOnTouchListener(this.eJT);
        kVar.eKc.setTextViewCheckSelection(false);
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
            if (postData.csE) {
                com.baidu.tbadk.core.util.ai.k(kVar.ayJ, d.e.cp_bg_line_c);
                kVar.ayJ.setVisibility(0);
            } else {
                kVar.ayJ.setVisibility(8);
            }
            kVar.eKb.setTag(null);
            kVar.eKb.setUserId(null);
            kVar.aXy.setText((CharSequence) null);
            kVar.eKh.getHeadView().setUserId(null);
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
                    kVar.aXy.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aS(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    kVar.aXy.setText(name_show);
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
                if (kVar.eKj != null) {
                    kVar.eKj.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                    kVar.eKj.setOnClickListener(this.eGA.eHq.cst);
                    kVar.eKj.a(iconInfo, i3, this.eGA.getResources().getDimensionPixelSize(d.f.ds26), this.eGA.getResources().getDimensionPixelSize(d.f.ds26), this.eGA.getResources().getDimensionPixelSize(d.f.ds8));
                }
                if (kVar.eKi != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.eKi.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    kVar.eKi.setOnClickListener(this.eGA.eHq.eTM);
                    kVar.eKi.a(tShowInfoNew, 3, this.eGA.getResources().getDimensionPixelSize(d.f.ds36), this.eGA.getResources().getDimensionPixelSize(d.f.ds36), this.eGA.getResources().getDimensionPixelSize(d.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.u.v(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.ai.c(kVar.aXy, d.e.cp_cont_r, 1);
                } else {
                    com.baidu.tbadk.core.util.ai.c(kVar.aXy, d.e.cp_cont_f, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                kVar.aXy.setTag(d.h.tag_user_id, postData.getAuthor().getUserId());
                kVar.aXy.setTag(d.h.tag_user_name, postData.getAuthor().getUserName());
                kVar.aXy.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.p.ab.ge() && name_show2 != null && !name_show2.equals(userName)) {
                    kVar.aXy.setText(com.baidu.tieba.pb.c.ao(this.mContext, kVar.aXy.getText().toString()));
                    kVar.aXy.setGravity(16);
                    kVar.aXy.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aOK());
                    com.baidu.tbadk.core.util.ai.c(kVar.aXy, d.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pV())) {
                    UtilHelper.showHeadImageViewBigV(kVar.eKh.getHeadView(), postData.getAuthor());
                    kVar.eKb.setVisibility(8);
                    kVar.eKh.setVisibility(0);
                    kVar.eKh.getHeadView().c(portrait, 28, false);
                    kVar.eKh.getHeadView().setUserId(postData.getAuthor().getUserId());
                    kVar.eKh.getHeadView().setUserName(postData.getAuthor().getUserName());
                    kVar.eKh.et(postData.getAuthor().getPendantData().pV());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.eKb, postData.getAuthor());
                    kVar.eKb.setUserId(postData.getAuthor().getUserId());
                    kVar.eKb.ac(postData.getAuthor().getUserName(), postData.bsI());
                    kVar.eKb.setTag(d.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    kVar.eKb.setImageDrawable(null);
                    kVar.eKb.c(portrait, 28, false);
                    kVar.eKb.setVisibility(0);
                    kVar.eKh.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    kVar.eJW.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.i(kVar.eJW, d.e.cp_link_tip_a);
                } else {
                    kVar.eJW.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.h bsB = postData.bsB();
            if (bsB != null && !StringUtils.isNull(bsB.getName())) {
                final String name = bsB.getName();
                final String lat = bsB.getLat();
                final String lng = bsB.getLng();
                kVar.eJY.setVisibility(0);
                kVar.eJY.setText(bsB.getName());
                kVar.eJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.i.hr()) {
                                com.baidu.tbadk.browser.a.T(j.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, j.this.mContext.getString(d.l.app_info_for_map)));
                            } else {
                                j.this.eGA.showToast(d.l.neterror);
                            }
                        }
                    }
                });
            } else {
                kVar.eJY.setVisibility(8);
            }
            kVar.eJX.setText(postData.bsA());
            if (postData.bsM() != null && !StringUtils.isNull(postData.bsM().getForumName())) {
                kVar.cap.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.bsM().getForumName(), 5, true)));
                kVar.cap.setVisibility(0);
            } else {
                kVar.cap.setVisibility(8);
            }
            int i4 = 0;
            if (this.eGA.aQX()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.bsM() != null) {
                i4 = postData.bsM().ra();
            }
            if (i4 > 0) {
                kVar.eKg.setVisibility(0);
                com.baidu.tbadk.core.util.ai.c(kVar.eKg, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                kVar.eKg.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_load_sub_data, postData);
            sparseArray.put(d.h.tag_load_sub_view, view);
            sparseArray.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsy()));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eFw != null && this.eFw.aPu() != 0) {
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
            if (this.eFw != null && this.eFw.aPj() != null && this.eFw.aPj().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eFw.aPj().getAuthor().getUserId();
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
                    if (postData.bsy() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFw.aPu()));
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
                        if (this.eFw.aPj() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eFw.aPj().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFw.aPu()));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_should_delete_visible, false);
                    }
                    kVar.eKa.setTag(sparseArray);
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
            if (postData.bsy() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            kVar.eKa.setTag(sparseArray);
        }
    }

    private void c(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.eJZ.a(postData.bsL(), postData.bsK(), false);
            kVar.eJZ.setTag(d.h.tag_clip_board, postData);
        }
    }

    private void d(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            if (postData.bsy() > 0) {
                String format = String.format(this.mContext.getString(d.l.is_floor), Integer.valueOf(postData.bsy()));
                kVar.eKf.setVisibility(0);
                kVar.eKf.setText(format);
                return;
            }
            kVar.eKf.setVisibility(8);
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eKc.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds110);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.eKc.setPadding(0, 0, 0, 0);
            if (!this.eFu) {
                kVar.eKc.setIsSupportVitality(false);
                kVar.eKc.setDefaultImageId(d.g.icon_click);
            } else {
                kVar.eKc.ha(null);
                kVar.eKc.setBackgroundDrawable(null);
                kVar.eKc.setIsSupportVitality(false);
                kVar.eKc.setDefaultImageId(d.g.transparent_bg);
            }
            kVar.eKc.setVideoImageId(d.g.pic_video);
            a(kVar.eKc, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.eKc.setLayoutParams(layoutParams);
            kVar.eKc.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            kVar.eKc.setIsFromCDN(this.mIsFromCDN);
            kVar.eKc.a(postData.aAP(), true, this.eJS);
            SparseArray sparseArray = (SparseArray) kVar.eKc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            kVar.eKc.setTag(sparseArray);
            kVar.eFJ.setTag(d.h.tag_from, sparseArray);
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
            if (postData.bsC() > 0 && postData.bsv() != null && postData.bsv().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.eKe.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds116);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds40);
                layoutParams.bottomMargin = 0;
                kVar.eKe.setLayoutParams(layoutParams);
                if (this.eFx == null) {
                    this.eFx = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eFx.setIsFromCDN(this.mIsFromCDN);
                    this.eFx.I(this.eFz);
                    String str = null;
                    if (this.eFw != null && this.eFw.aPj() != null && this.eFw.aPj().getAuthor() != null) {
                        str = this.eFw.aPj().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eFw != null) {
                        this.eFx.C(this.eFw.aPu(), z);
                        this.eFx.U(this.eFw.aPj());
                    }
                }
                this.eFx.pI(postData.getId());
                kVar.eKe.setVisibility(0);
                kVar.eKe.a(postData, view);
                kVar.eKe.setChildOnClickListener(this.cLO);
                kVar.eKe.setChildOnLongClickListener(this.awn);
                kVar.eKe.setChildOnTouchListener(this.eJT);
                kVar.eKe.setSubPbAdapter(this.eFx);
                kVar.eKe.setVisibility(0);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.eKe.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                kVar.eKe.setLayoutParams(layoutParams2);
                kVar.eKe.setVisibility(8);
            }
            if (postData.giA) {
                kVar.ayK.setVisibility(0);
            } else {
                kVar.ayK.setVisibility(4);
            }
        }
    }

    private void a(k kVar) {
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.c(kVar.aXy, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eJW, d.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eJX, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eKf, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.cap, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(kVar.eJY, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.k(kVar.ayK, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(kVar.eKa, d.g.icon_floor_more_selector);
                kVar.eKc.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.k(kVar.eKe, d.e.cp_bg_line_e);
                kVar.eKd.onChangeSkinType();
                kVar.eJZ.onChangeSkinType();
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.eFJ.setOnTouchListener(this.eJT);
        kVar.eFJ.setOnLongClickListener(this.awn);
        if (this.eGA.getPageContext() != null && this.eGA.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq;
            kVar.aXy.setOnClickListener(aVar.eTL);
            kVar.eKb.setOnClickListener(aVar.eTL);
            kVar.eKh.setOnClickListener(aVar.eTL);
            kVar.eKh.getHeadView().setOnClickListener(aVar.eTL);
            kVar.eKc.setOnLongClickListener(this.awn);
            kVar.eKc.setOnTouchListener(this.eJT);
            kVar.eKc.setCommonTextViewOnClickListener(this.cLO);
            kVar.eKc.setOnImageClickListener(this.aRM);
            kVar.eKc.setOnImageTouchListener(this.eJT);
            kVar.eKc.setOnEmotionClickListener(aVar.eTN);
            kVar.eKa.setOnClickListener(this.cLO);
            kVar.eJZ.setOnClickListener(this.cLO);
            kVar.eGp.setOnClickListener(this.cLO);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eJS = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eFw = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iP(boolean z) {
        this.eFu = z;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eGA.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.eKc.setTextViewOnTouchListener(this.aRN);
        kVar.eKc.setTextViewCheckSelection(false);
    }

    public void G(View.OnClickListener onClickListener) {
        this.eFz = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cLO = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRM = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRN = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awn = onLongClickListener;
    }
}
