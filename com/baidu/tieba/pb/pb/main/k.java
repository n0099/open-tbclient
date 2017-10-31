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
import com.baidu.tbadk.core.data.MetaData;
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
public class k extends m<PostData, l> implements View.OnClickListener {
    private int DS20;
    private int DS8;
    private boolean aSs;
    private TbRichTextView.f aSv;
    private com.baidu.tieba.pb.a.c aSw;
    private View.OnLongClickListener auR;
    private int bGG;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cDY;
    private com.baidu.adp.lib.e.b<TbImageView> cDZ;
    private boolean eHP;
    protected com.baidu.tieba.pb.data.f eHR;
    private com.baidu.tieba.pb.pb.sub.d eHS;
    private View.OnClickListener eHU;
    private TbRichTextView.b eMU;
    private com.baidu.tieba.pb.a.c eMV;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bi;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).buH() && this.mCommonClickListener != null && this.eMh != null && (bi = this.eMh.bi(findViewById)) != null) {
                TiebaStatic.log(this.eMh.aRo().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", bi.buH() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.DS8 = 0;
        this.DS20 = 0;
        this.bGG = 0;
        this.eMU = null;
        this.eHP = true;
        this.mHostId = null;
        this.eHR = null;
        this.eHU = null;
        this.mCommonClickListener = null;
        this.aSv = null;
        this.aSw = null;
        this.auR = null;
        this.eHS = null;
        this.aSs = true;
        this.cDY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alu */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(k.this.mContext);
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
        this.cDZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
        this.eMV = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.eMh == null || k.this.eMh.aRk() == null || k.this.eMh.aRk().aTX())) {
                    if (view instanceof NoPressedLinearLayout) {
                        k.this.a((NoPressedLinearLayout) view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof NoPressedLinearLayout) {
                                k.this.a((NoPressedLinearLayout) parent);
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
                if (k.this.aSw != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.aSw.bf(view);
                        k.this.aSw.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.mCommonClickListener.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(this.eMh.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.eNg.setConstrainLayoutPool(this.cDY);
        lVar.eNg.setImageViewPool(this.cDZ);
        a(lVar);
        this.DS8 = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds8);
        this.DS20 = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds20);
        this.bGG = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds34);
        if (lVar.eNf != null) {
            lVar.eNf.setDuiEnabled(this.aSs);
        }
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, lVar);
        a(lVar);
        b(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            g(postData2);
            postData2.st();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.aSs = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            b(lVar, postData, view, i);
            c(lVar, postData);
            c(lVar, postData, view, i);
            d(lVar, postData, view, i);
            d(lVar, postData);
            b(lVar, postData);
            a(lVar, postData);
        }
    }

    private void g(PostData postData) {
        if (postData.Zh == 0 && postData.gpP) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ac("post_id", postData.getId());
            akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.aWP() == null) {
            lVar.eIJ.setVisibility(8);
            return;
        }
        TbRichText aEt = postData.aEt();
        com.baidu.tieba.pb.view.g.a(postData.aWP(), lVar.eIJ, false, false, aEt != null && StringUtils.isNull(aEt.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHP) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eNf.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.eNf.setLayoutParams(layoutParams);
            lVar.eNf.setPadding(0, 0, 0, 0);
            lVar.eNf.he(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eNf.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.eNf.setLayoutParams(layoutParams2);
            lVar.eNf.he(postData.getBimg_url());
        }
        lVar.eNf.setTextViewOnTouchListener(this.eMV);
        lVar.eNf.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x063c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(l lVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (lVar != null && postData != null) {
            if (postData.cJc) {
                com.baidu.tbadk.core.util.aj.k(lVar.axo, d.C0080d.cp_bg_line_c);
                lVar.axo.setVisibility(0);
            } else {
                lVar.axo.setVisibility(8);
            }
            lVar.eNe.setTag(null);
            lVar.eNe.setUserId(null);
            lVar.aYZ.setText((CharSequence) null);
            lVar.eNk.getHeadView().setUserId(null);
            if (postData.rt() != null) {
                String name_show = postData.rt().getName_show();
                int gW = com.baidu.tbadk.util.w.gW(name_show);
                if (!StringUtils.isNull(postData.rt().getSealPrefix())) {
                    if (gW > 12) {
                        name_show = com.baidu.tbadk.util.w.H(name_show, 12) + "...";
                    }
                } else if (gW > 14) {
                    name_show = com.baidu.tbadk.util.w.H(name_show, 14) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.rt().getSealPrefix())) {
                    lVar.aYZ.setText(ag(postData.rt().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.k.aP(postData.rt().getSealPrefix()) + 2;
                } else {
                    lVar.aYZ.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aP = com.baidu.adp.lib.util.k.aP(postData.rt().getName_show());
                    if (aP + i2 > 14) {
                        i3 = 0;
                    } else if (aP + i2 >= 12) {
                        i3 = 1;
                    } else if (aP + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.rt().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rt().getTShowInfoNew();
                if (lVar.eNm != null) {
                    lVar.eNm.setTag(d.g.tag_user_id, postData.rt().getUserId());
                    lVar.eNm.setOnClickListener(this.eMh.eKt.cIR);
                    lVar.eNm.a(iconInfo, i3, this.eMh.getResources().getDimensionPixelSize(d.e.ds26), this.eMh.getResources().getDimensionPixelSize(d.e.ds26), this.eMh.getResources().getDimensionPixelSize(d.e.ds8));
                }
                if (lVar.eNl != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.eNl.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.eNl.setOnClickListener(this.eMh.eKt.eXI);
                    lVar.eNl.a(tShowInfoNew, 3, this.eMh.getResources().getDimensionPixelSize(d.e.ds36), this.eMh.getResources().getDimensionPixelSize(d.e.ds36), this.eMh.getResources().getDimensionPixelSize(d.e.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.v.v(tShowInfoNew) || postData.rt().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(lVar.aYZ, d.C0080d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(lVar.aYZ, d.C0080d.cp_cont_j, 1);
                }
                String portrait = postData.rt().getPortrait();
                lVar.aYZ.setTag(d.g.tag_user_id, postData.rt().getUserId());
                lVar.aYZ.setTag(d.g.tag_user_name, postData.rt().getUserName());
                lVar.aYZ.setTag(d.g.tag_virtual_user_url, postData.rt().getVirtualUserUrl());
                String name_show2 = postData.rt().getName_show();
                String userName = postData.rt().getUserName();
                if (com.baidu.tbadk.p.ac.fS() && name_show2 != null && !name_show2.equals(userName)) {
                    lVar.aYZ.setText(com.baidu.tieba.pb.c.al(this.mContext, lVar.aYZ.getText().toString()));
                    lVar.aYZ.setGravity(16);
                    lVar.aYZ.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPq());
                    com.baidu.tbadk.core.util.aj.c(lVar.aYZ, d.C0080d.cp_other_e, 1);
                }
                if (postData.rt().getPendantData() != null && !StringUtils.isNull(postData.rt().getPendantData().pQ())) {
                    UtilHelper.showHeadImageViewBigV(lVar.eNk.getHeadView(), postData.rt());
                    lVar.eNe.setVisibility(8);
                    lVar.eNk.setVisibility(0);
                    lVar.eNk.getHeadView().startLoad(portrait, 28, false);
                    lVar.eNk.getHeadView().setUserId(postData.rt().getUserId());
                    lVar.eNk.getHeadView().setUserName(postData.rt().getUserName());
                    lVar.eNk.en(postData.rt().getPendantData().pQ());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.eNe, postData.rt());
                    lVar.eNe.setUserId(postData.rt().getUserId());
                    lVar.eNe.ae(postData.rt().getUserName(), postData.buE());
                    lVar.eNe.setTag(d.g.tag_virtual_user_url, postData.rt().getVirtualUserUrl());
                    lVar.eNe.setImageDrawable(null);
                    lVar.eNe.startLoad(portrait, 28, false);
                    lVar.eNe.setVisibility(0);
                    lVar.eNk.setVisibility(8);
                }
                if (postData.rt() != null) {
                    MetaData rt = postData.rt();
                    lVar.eMY.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(lVar.eMY, d.C0080d.cp_link_tip_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rt.getUserId())) {
                        lVar.eMY.setText(d.j.host_name);
                    } else if (rt.getIs_bawu() == 1 && "manager".equals(rt.getBawu_type())) {
                        lVar.eMY.setText(d.j.bawu_manager);
                    } else if (rt.getIs_bawu() == 1 && "assist".equals(rt.getBawu_type())) {
                        lVar.eMY.setText(d.j.bawu_assist);
                    } else {
                        lVar.eMY.setVisibility(8);
                    }
                } else {
                    lVar.eMY.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.i bux = postData.bux();
            if (bux != null && !StringUtils.isNull(bux.getName())) {
                final String name = bux.getName();
                final String lat = bux.getLat();
                final String lng = bux.getLng();
                lVar.eNb.setVisibility(0);
                lVar.eNb.setText(bux.getName());
                lVar.eNb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.hh()) {
                                com.baidu.tbadk.browser.a.O(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.eMh.showToast(d.j.neterror);
                            }
                        }
                    }
                });
            } else {
                lVar.eNb.setVisibility(8);
            }
            if (postData.buI() != null && !StringUtils.isNull(postData.buI().getForumName())) {
                lVar.clT.setText(this.mContext.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.buI().getForumName(), 5, true)));
                lVar.clT.setVisibility(0);
            } else {
                lVar.clT.setVisibility(8);
            }
            int i4 = 0;
            if (this.eMh.aRV()) {
                if (postData.rt() != null) {
                    i4 = postData.rt().getLevel_id();
                }
            } else if (postData.buI() != null) {
                i4 = postData.buI().qO();
            }
            if (i4 > 0) {
                lVar.eNj.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.eNj, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                lVar.eNj.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.buu()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.rt() != null && !StringUtils.isNull(postData.rt().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eHR != null && this.eHR.aPZ() != 0) {
                if (this.eHR.aPZ() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.rt() != null) {
                    String userId = postData.rt().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eHR != null && this.eHR.aPO() != null && this.eHR.aPO().rt() != null && postData.rt() != null) {
                String userId2 = this.eHR.aPO().rt().getUserId();
                String userId3 = postData.rt().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.rt() != null && UtilHelper.isCurrentAccount(postData.rt().getUserId())) {
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
                    if (postData.buu() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eHR.aPZ()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rt() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                        }
                        if (this.eHR.aPO() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.eHR.aPO().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eHR.aPZ()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.eNd.setTag(sparseArray);
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
            if (postData.buu() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.eNd.setTag(sparseArray);
        }
    }

    private void c(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.eNc.a(postData.buH(), postData.buG(), false);
            lVar.eNc.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void d(l lVar, PostData postData) {
        boolean z = true;
        if (lVar != null && postData != null) {
            if (postData.buu() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.buu()));
                lVar.eNi.setVisibility(0);
                lVar.eNi.setText(format);
            } else {
                lVar.eNi.setVisibility(8);
                z = false;
            }
            if (z) {
                lVar.eNa.setVisibility(0);
                lVar.eMZ.setPadding(this.DS8, 0, 0, 0);
            } else {
                lVar.eNa.setVisibility(8);
                lVar.eMZ.setPadding(0, 0, 0, 0);
            }
            lVar.eMZ.setText(postData.buw());
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eNf.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds34);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds120);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.eNf.setPadding(0, 0, 0, 0);
            if (!this.eHP) {
                lVar.eNf.getLayoutStrategy().fP(d.f.icon_click);
            } else {
                lVar.eNf.he(null);
                lVar.eNf.setBackgroundDrawable(null);
                lVar.eNf.getLayoutStrategy().fP(d.f.transparent_bg);
            }
            lVar.eNf.getLayoutStrategy().fM(d.f.pic_video);
            a(lVar.eNf, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.eNf.setLayoutParams(layoutParams);
            lVar.eNf.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            lVar.eNf.setIsFromCDN(this.mIsFromCDN);
            lVar.eNf.a(postData.aEt(), true, this.eMU);
            SparseArray sparseArray = (SparseArray) lVar.eNf.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.eNf.setTag(sparseArray);
            lVar.eIe.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ac = (ac - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fN(ac - (z ? getDimensionPixelSize(d.e.ds70) : 0));
            tbRichTextView.getLayoutStrategy().fO((int) (ac * 1.618f));
        }
    }

    private void d(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.buy() > 0 && postData.bur() != null && postData.bur().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eNh.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds10);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds120);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds34);
                layoutParams.bottomMargin = 0;
                lVar.eNh.setLayoutParams(layoutParams);
                if (this.eHS == null) {
                    this.eHS = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHS.setIsFromCDN(this.mIsFromCDN);
                    this.eHS.F(this.eHU);
                    String str = null;
                    if (this.eHR != null && this.eHR.aPO() != null && this.eHR.aPO().rt() != null) {
                        str = this.eHR.aPO().rt().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eHR != null) {
                        this.eHS.y(this.eHR.aPZ(), z);
                        this.eHS.M(this.eHR.aPO());
                    }
                }
                this.eHS.pQ(postData.getId());
                lVar.eNh.setSubPbAdapter(this.eHS);
                lVar.eNh.setVisibility(0);
                lVar.eNh.a(postData, view);
                lVar.eNh.setChildOnClickListener(this.mCommonClickListener);
                lVar.eNh.setChildOnLongClickListener(this.auR);
                lVar.eNh.setChildOnTouchListener(this.eMV);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eNh.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.eNh.setLayoutParams(layoutParams2);
                lVar.eNh.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
            layoutParams3.topMargin = this.DS20;
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.bottomMargin = 0;
            if (lVar.eNh.getVisibility() == 0) {
                layoutParams3.topMargin = this.bGG;
            } else if (lVar.eNb.getVisibility() == 0) {
                layoutParams3.topMargin = this.bGG;
            }
            lVar.mBottomLine.setLayoutParams(layoutParams3);
            if (postData.gpT) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(lVar.aYZ, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eMY, d.C0080d.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eMZ, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eNa, d.C0080d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(lVar.eNi, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.clT, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eNb, d.C0080d.cp_cont_j, 1);
                com.baidu.tbadk.core.util.aj.k(lVar.mBottomLine, d.C0080d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.eNd, d.f.icon_floor_more_selector);
                lVar.eNf.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(lVar.eNh, d.C0080d.cp_bg_line_e);
                lVar.eNg.onChangeSkinType();
                lVar.eNc.onChangeSkinType();
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.eIe.setOnTouchListener(this.eMV);
        lVar.eIe.setOnLongClickListener(this.auR);
        if (this.eMh.getPageContext() != null && this.eMh.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt;
            lVar.aYZ.setOnClickListener(aVar.eXH);
            lVar.eNe.setOnClickListener(aVar.eXH);
            lVar.eNk.setOnClickListener(aVar.eXH);
            lVar.eNk.getHeadView().setOnClickListener(aVar.eXH);
            lVar.eNf.setOnLongClickListener(this.auR);
            lVar.eNf.setOnTouchListener(this.eMV);
            lVar.eNf.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.eNf.setOnImageClickListener(this.aSv);
            lVar.eNf.setOnImageTouchListener(this.eMV);
            lVar.eNf.setOnEmotionClickListener(aVar.eXJ);
            lVar.eNd.setOnClickListener(this.mCommonClickListener);
            lVar.eNc.setOnClickListener(this.mCommonClickListener);
            lVar.eIJ.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eMU = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHR = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iy(boolean z) {
        this.eHP = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eMh.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.eNf.setTextViewOnTouchListener(this.aSw);
        lVar.eNf.setTextViewCheckSelection(false);
    }

    public void D(View.OnClickListener onClickListener) {
        this.eHU = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSv = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auR = onLongClickListener;
    }
}
