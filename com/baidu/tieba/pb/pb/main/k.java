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
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private boolean aVD;
    private TbRichTextView.g aVG;
    private com.baidu.tieba.pb.a.c aVH;
    private View.OnLongClickListener avF;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNG;
    private com.baidu.adp.lib.e.b<TbImageView> cNH;
    private boolean eQP;
    protected com.baidu.tieba.pb.data.f eQR;
    private com.baidu.tieba.pb.pb.sub.d eQS;
    private View.OnClickListener eQU;
    private int eVY;
    private int eVZ;
    private int eWa;
    private TbRichTextView.c eWb;
    private com.baidu.tieba.pb.a.c eWc;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData bd;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bxj() && this.mCommonClickListener != null && this.eVp != null && (bd = this.eVp.bd(findViewById)) != null) {
                TiebaStatic.log(this.eVp.aSV().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", bd.bxj() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eVY = 0;
        this.eVZ = 0;
        this.eWa = 0;
        this.eWb = null;
        this.eQP = true;
        this.mHostId = null;
        this.eQR = null;
        this.eQU = null;
        this.mCommonClickListener = null;
        this.aVG = null;
        this.aVH = null;
        this.avF = null;
        this.eQS = null;
        this.aVD = true;
        this.cNG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anM */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(k.this.mContext);
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
        this.cNH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.common_color_10043));
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
        this.eWc = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.eVp == null || k.this.eVp.aSR() == null || k.this.eVp.aSR().aVP())) {
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
                if (k.this.aVH != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.aVH.ba(view);
                        k.this.aVH.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bk */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(this.eVp.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.eWo.setConstrainLayoutPool(this.cNG);
        lVar.eWo.setImageViewPool(this.cNH);
        a(lVar);
        this.eVY = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds12);
        this.eVZ = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds20);
        this.eWa = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds36);
        if (lVar.eWn != null) {
            lVar.eWn.setDuiEnabled(this.aVD);
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
            postData2.su();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.aVD = z;
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
            e(lVar, postData);
        }
    }

    private void g(PostData postData) {
        if (postData.Zu == 0 && postData.gCu) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ac("post_id", postData.getId());
            akVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ac("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.aYe() == null) {
            lVar.eRJ.setVisibility(8);
            return;
        }
        TbRichText bwY = postData.bwY();
        com.baidu.tieba.pb.view.g.a(postData.aYe(), lVar.eRJ, false, false, bwY != null && StringUtils.isNull(bwY.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eQP) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eWn.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.eWn.setLayoutParams(layoutParams);
            lVar.eWn.setPadding(0, 0, 0, 0);
            lVar.eWn.hg(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eWn.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.eWn.setLayoutParams(layoutParams2);
            lVar.eWn.hg(postData.getBimg_url());
        }
        lVar.eWn.setTextViewOnTouchListener(this.eWc);
        lVar.eWn.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0594  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(l lVar, PostData postData, View view, int i) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (lVar != null && postData != null) {
            if (postData.cTd) {
                com.baidu.tbadk.core.util.aj.k(lVar.ayc, d.C0096d.cp_bg_line_c);
                lVar.ayc.setVisibility(0);
            } else {
                lVar.ayc.setVisibility(8);
            }
            lVar.eWm.setTag(null);
            lVar.eWm.setUserId(null);
            lVar.bcv.setText((CharSequence) null);
            lVar.eWs.getHeadView().setUserId(null);
            if (postData.rv() != null) {
                ArrayList<IconData> iconInfo = postData.rv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.rv().getTShowInfoNew();
                if (lVar.eWu != null) {
                    lVar.eWu.setTag(d.g.tag_user_id, postData.rv().getUserId());
                    lVar.eWu.setOnClickListener(this.eVp.eTu.cST);
                    lVar.eWu.a(iconInfo, 2, this.eWa, this.eWa, this.eVY);
                }
                if (lVar.eWt != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.eWt.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.eWt.setOnClickListener(this.eVp.eTu.ffT);
                    lVar.eWt.a(tShowInfoNew, 3, this.eWa, this.eWa, this.eVY, true);
                }
                if (!com.baidu.tbadk.core.util.v.w(tShowInfoNew) || postData.rv().isBigV()) {
                    com.baidu.tbadk.core.util.aj.c(lVar.bcv, d.C0096d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.c(lVar.bcv, d.C0096d.cp_cont_f, 1);
                }
                String portrait = postData.rv().getPortrait();
                lVar.bcv.setTag(d.g.tag_user_id, postData.rv().getUserId());
                lVar.bcv.setTag(d.g.tag_user_name, postData.rv().getUserName());
                lVar.bcv.setTag(d.g.tag_virtual_user_url, postData.rv().getVirtualUserUrl());
                String name_show = postData.rv().getName_show();
                String userName = postData.rv().getUserName();
                if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                    lVar.bcv.setText(com.baidu.tieba.pb.c.aj(this.mContext, lVar.bcv.getText().toString()));
                    lVar.bcv.setGravity(16);
                    lVar.bcv.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQS());
                    com.baidu.tbadk.core.util.aj.c(lVar.bcv, d.C0096d.cp_other_e, 1);
                }
                if (postData.rv().getPendantData() != null && !StringUtils.isNull(postData.rv().getPendantData().pR())) {
                    UtilHelper.showHeadImageViewBigV(lVar.eWs.getHeadView(), postData.rv());
                    lVar.eWm.setVisibility(8);
                    lVar.eWs.setVisibility(0);
                    lVar.eWs.getHeadView().startLoad(portrait, 28, false);
                    lVar.eWs.getHeadView().setUserId(postData.rv().getUserId());
                    lVar.eWs.getHeadView().setUserName(postData.rv().getUserName());
                    lVar.eWs.es(postData.rv().getPendantData().pR());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.eWm, postData.rv());
                    lVar.eWm.setUserId(postData.rv().getUserId());
                    lVar.eWm.ae(postData.rv().getUserName(), postData.bxg());
                    lVar.eWm.setTag(d.g.tag_virtual_user_url, postData.rv().getVirtualUserUrl());
                    lVar.eWm.setImageDrawable(null);
                    lVar.eWm.startLoad(portrait, 28, false);
                    lVar.eWm.setVisibility(0);
                    lVar.eWs.setVisibility(8);
                }
                if (postData.rv() != null) {
                    MetaData rv = postData.rv();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(rv.getUserId())) {
                        lVar.eWf.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eWf, d.f.icon_id_louzhu);
                        lVar.eWf.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (rv.getIs_bawu() == 1 && "manager".equals(rv.getBawu_type())) {
                        lVar.eWf.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eWf, d.f.icon_id_bazhu);
                        lVar.eWf.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (rv.getIs_bawu() == 1 && "assist".equals(rv.getBawu_type())) {
                        lVar.eWf.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.eWf, d.f.icon_id_xiaobazhu);
                        lVar.eWf.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        lVar.eWf.setVisibility(8);
                        lVar.eWf.setTag(null);
                    }
                } else {
                    lVar.eWf.setVisibility(8);
                    lVar.eWf.setTag(null);
                }
            }
            int i2 = 0;
            if (this.eVp.aTD()) {
                if (postData.rv() != null) {
                    i2 = postData.rv().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.eWr.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.eWr, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.eWr.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.eWu.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.eWu.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.eWf.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.eWt.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.rv().getName_show();
            int gY = com.baidu.tbadk.util.w.gY(name_show2);
            if (!StringUtils.isNull(postData.rv().getSealPrefix())) {
                if (gY > i3 - 2) {
                    str = com.baidu.tbadk.util.w.H(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (gY > i3) {
                    str = com.baidu.tbadk.util.w.H(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.rv().getSealPrefix())) {
                lVar.bcv.setText(ag(postData.rv().getSealPrefix(), str));
            } else {
                lVar.bcv.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwV()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.rv() != null && !StringUtils.isNull(postData.rv().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eQR != null && this.eQR.aRB() != 0) {
                if (this.eQR.aRB() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.rv() != null) {
                    String userId = postData.rv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eQR != null && this.eQR.aRq() != null && this.eQR.aRq().rv() != null && postData.rv() != null) {
                String userId2 = this.eQR.aRq().rv().getUserId();
                String userId3 = postData.rv().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.rv() != null && UtilHelper.isCurrentAccount(postData.rv().getUserId())) {
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
                    int i4 = 1;
                    if (postData.bwV() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQR.aRB()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rv() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rv().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rv().getUserName());
                        }
                        if (this.eQR.aRq() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.eQR.aRq().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQR.aRB()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.eWl.setTag(sparseArray);
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
            int i42 = 1;
            if (postData.bwV() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.eWl.setTag(sparseArray);
        }
    }

    private void c(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.eWk.a(postData.bxj(), postData.bxi(), false);
            lVar.eWk.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void d(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.bwV() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bwV()));
                lVar.eWq.setVisibility(0);
                lVar.eWq.setText(format);
                z = true;
            } else {
                lVar.eWq.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.i bwZ = postData.bwZ();
            boolean z2 = (bwZ == null || StringUtils.isNull(bwZ.getName())) ? false : true;
            if (z) {
                lVar.eWh.setVisibility(0);
                i = this.eVZ;
            } else {
                lVar.eWh.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.eWi.setVisibility(0);
                i2 = this.eVZ;
            } else {
                lVar.eWi.setVisibility(8);
                i2 = 0;
            }
            lVar.eWg.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.eWg.setText(com.baidu.tbadk.core.util.am.s(postData.getTime()));
            } else {
                lVar.eWg.setText(com.baidu.tbadk.core.util.am.r(postData.getTime()));
            }
            if (z2) {
                final String name = bwZ.getName();
                final String lat = bwZ.getLat();
                final String lng = bwZ.getLng();
                lVar.eWj.setVisibility(0);
                lVar.eWj.setPadding(this.eVZ, 0, 0, 0);
                lVar.eWj.setText(bwZ.getName());
                lVar.eWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.hh()) {
                                com.baidu.tbadk.browser.a.O(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.eVp.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            lVar.eWj.setVisibility(8);
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eWn.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.eWn.setPadding(0, 0, 0, 0);
            if (!this.eQP) {
                lVar.eWn.getLayoutStrategy().fV(d.f.icon_click);
            } else {
                lVar.eWn.hg(null);
                lVar.eWn.setBackgroundDrawable(null);
                lVar.eWn.getLayoutStrategy().fV(d.f.transparent_bg);
            }
            lVar.eWn.getLayoutStrategy().fS(d.f.pic_video);
            a(lVar.eWn, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.eWn.setLayoutParams(layoutParams);
            lVar.eWn.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_link_tip_c));
            lVar.eWn.setIsFromCDN(this.mIsFromCDN);
            lVar.eWn.a(postData.bwY(), true, this.eWb);
            SparseArray sparseArray = (SparseArray) lVar.eWn.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.eWn.setTag(sparseArray);
            lVar.eRe.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ac = (ac - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().fT(ac - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().fU((int) (ac * 1.618f));
        }
    }

    private void d(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.bxa() > 0 && postData.bwS() != null && postData.bwS().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.eWp.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                lVar.eWp.setLayoutParams(layoutParams);
                if (this.eQS == null) {
                    this.eQS = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eQS.setIsFromCDN(this.mIsFromCDN);
                    this.eQS.G(this.eQU);
                    String str = null;
                    if (this.eQR != null && this.eQR.aRq() != null && this.eQR.aRq().rv() != null) {
                        str = this.eQR.aRq().rv().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eQR != null) {
                        this.eQS.y(this.eQR.aRB(), z);
                        this.eQS.R(this.eQR.aRq());
                    }
                }
                this.eQS.qh(postData.getId());
                lVar.eWp.setSubPbAdapter(this.eQS);
                lVar.eWp.setVisibility(0);
                lVar.eWp.a(postData, view);
                lVar.eWp.setChildOnClickListener(this.mCommonClickListener);
                lVar.eWp.setChildOnLongClickListener(this.avF);
                lVar.eWp.setChildOnTouchListener(this.eWc);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.eWp.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.eWp.setLayoutParams(layoutParams2);
                lVar.eWp.setVisibility(8);
            }
            if (postData.gCy) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void e(l lVar, PostData postData) {
        if (lVar != null && lVar.eWy != null && lVar.eWv != null) {
            if (postData == null || postData.gCA == null || StringUtils.isNull(postData.gCA.liveTitle)) {
                lVar.eWv.setVisibility(8);
                return;
            }
            lVar.eWy.setText(postData.gCA.liveTitle);
            lVar.eWv.setTag(postData.gCA);
            lVar.eWv.setVisibility(0);
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                akVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.c(lVar.bcv, d.C0096d.cp_cont_f, 1);
                if (lVar.eWf.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(lVar.eWf, ((Integer) lVar.eWf.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.c(lVar.eWg, d.C0096d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eWh, d.C0096d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.j(lVar.eWi, d.C0096d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.c(lVar.eWq, d.C0096d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eWj, d.C0096d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.k(lVar.mBottomLine, d.C0096d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.eWl, d.f.icon_floor_more_selector);
                lVar.eWn.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.k(lVar.eWp, d.C0096d.cp_bg_line_e);
                lVar.eWp.onChangeSkinType();
                lVar.eWo.onChangeSkinType();
                lVar.eWk.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.c(lVar.eWy, d.C0096d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.c(lVar.eWw, d.C0096d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.j(lVar.eWv, d.C0096d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.j(lVar.eWx, d.C0096d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(lVar.eWz, d.f.icon_arrow_more_gray);
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.eRe.setOnTouchListener(this.eWc);
        lVar.eRe.setOnLongClickListener(this.avF);
        if (this.eVp.getPageContext() != null && this.eVp.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu;
            lVar.bcv.setOnClickListener(aVar.ffS);
            lVar.eWm.setOnClickListener(aVar.ffS);
            lVar.eWs.setOnClickListener(aVar.ffS);
            lVar.eWs.getHeadView().setOnClickListener(aVar.ffS);
            lVar.eWn.setOnLongClickListener(this.avF);
            lVar.eWn.setOnTouchListener(this.eWc);
            lVar.eWn.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.eWn.setOnImageClickListener(this.aVG);
            lVar.eWn.setOnImageTouchListener(this.eWc);
            lVar.eWn.setOnEmotionClickListener(aVar.ffU);
            lVar.eWl.setOnClickListener(this.mCommonClickListener);
            lVar.eWk.setOnClickListener(this.mCommonClickListener);
            lVar.eRJ.setOnClickListener(this.mCommonClickListener);
            lVar.eWv.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.eWb = cVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eQR = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iY(boolean z) {
        this.eQP = z;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.eVp.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.eWn.setTextViewOnTouchListener(this.aVH);
        lVar.eWn.setTextViewCheckSelection(false);
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQU = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVG = gVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVH = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avF = onLongClickListener;
    }
}
