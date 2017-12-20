package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class q extends m<PostData, r> implements View.OnClickListener {
    private TbRichTextView.g aVG;
    private com.baidu.tieba.pb.a.c aVH;
    private View.OnLongClickListener avF;
    private int bOX;
    protected int eQO;
    protected boolean eQP;
    protected com.baidu.tieba.pb.data.f eQR;
    private com.baidu.tieba.pb.pb.sub.d eQS;
    private View.OnClickListener eQU;
    private boolean eQV;
    private final boolean eQW;
    private final int eWJ;
    private boolean eWK;
    private boolean eWL;
    private int eWM;
    private int eWN;
    private com.baidu.tieba.pb.a.c eWO;
    private OriginalThreadCardView.a eWP;
    private TbRichTextView.c eWb;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eWJ = 3;
        this.eQO = 0;
        this.eQP = true;
        this.eWK = true;
        this.eQR = null;
        this.eQS = null;
        this.eQU = null;
        this.mCommonClickListener = null;
        this.aVG = null;
        this.aVH = null;
        this.avF = null;
        this.eWb = null;
        this.eQV = false;
        this.eQW = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eWL = false;
        this.eWM = 0;
        this.eWN = 0;
        this.bOX = 0;
        this.pageFromType = 0;
        this.eWO = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (q.this.aVH != null) {
                    q.this.aVH.bb(view);
                    q.this.aVH.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.eWP = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.q.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && q.this.eQR != null) {
                    String threadId = q.this.eQR.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12602").ac("tid", threadId).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).r("obj_type", i));
                    }
                }
            }
        };
        this.eWN = com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds60);
        this.bOX = com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aSw() != null) {
            this.pageFromType = pbActivity.aSw().aUT();
        }
        this.eWM = com.baidu.adp.lib.util.l.ac(pbActivity) - com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds130);
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(rVar.eRe, d.C0096d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.k(rVar.doW, d.C0096d.cp_bg_line_c);
                rVar.eRo.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(rVar.cvb, d.C0096d.cp_cont_f, 1);
                rVar.cvb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                rVar.ccm.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.c(rVar.eWV, d.C0096d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eWW, d.C0096d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eWX, d.C0096d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eWY, d.C0096d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.k(rVar.eWZ, d.C0096d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.k(rVar.eXa, d.C0096d.cp_cont_e);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.eVp.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.eQP, this.eQO);
        a(rVar);
        if (rVar.ccm != null) {
            rVar.ccm.ccQ = this.pageFromType;
        }
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, r rVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, rVar);
        a(rVar);
        c(rVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.su();
            a(rVar, postData2, view, i);
        }
        if (!this.eQV && this.eQW && rVar != null && rVar.eRo.Kg() && (listView = ((PbActivity) this.eVp.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eQV = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x07a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(r rVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (rVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            rVar.eRo.setTag(sparseArray);
            rVar.eRe.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            if (this.eWK) {
                rVar.doW.setVisibility(0);
            } else {
                rVar.doW.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eQP) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.eRo.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.eRo.setLayoutParams(layoutParams);
                rVar.eRo.hg(null);
                this.eWL = false;
            } else {
                this.eWL = true;
                rVar.eRo.hg(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.eRo.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.e.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                rVar.eRo.setLayoutParams(layoutParams2);
            }
            if (postData.bwU() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.eRo.setOnClickListener(this.mCommonClickListener);
                    rVar.eRo.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    rVar.eRo.setOnClickListener(null);
                    rVar.eRo.setTextViewOnClickListener(null);
                }
                rVar.eRe.setOnClickListener(this.mCommonClickListener);
            } else {
                rVar.eRe.setOnClickListener(null);
            }
            if (postData.bwU() == 1) {
                if (!this.eVp.aTC()) {
                    rVar.cvb.setVisibility(8);
                    if (com.baidu.tbadk.core.util.v.w(this.eQR.aRJ())) {
                        rVar.eWU.setVisibility(8);
                    } else {
                        int v = com.baidu.tbadk.core.util.v.v(this.eQR.aRJ());
                        if (v > 3) {
                            v = 3;
                        }
                        int i2 = this.eWM / v;
                        switch (v) {
                            case 1:
                                rVar.eWW.setMaxWidth(i2);
                                rVar.eWW.setText(this.eVp.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 0)).getForumName()}));
                                rVar.eWW.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 0)).getForumName());
                                rVar.eWW.setVisibility(0);
                                rVar.eWX.setVisibility(0);
                                rVar.eWY.setVisibility(0);
                                rVar.eWZ.setVisibility(8);
                                rVar.eXa.setVisibility(8);
                                break;
                            case 2:
                                rVar.eWW.setMaxWidth(i2);
                                rVar.eWW.setText(this.eVp.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 0)).getForumName()}));
                                rVar.eWW.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 0)).getForumName());
                                rVar.eWW.setVisibility(0);
                                rVar.eWX.setMaxWidth(i2);
                                rVar.eWX.setText(this.eVp.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 1)).getForumName()}));
                                rVar.eWX.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 1)).getForumName());
                                rVar.eWX.setVisibility(0);
                                rVar.eWY.setVisibility(8);
                                rVar.eWZ.setVisibility(0);
                                rVar.eXa.setVisibility(8);
                                break;
                            case 3:
                                rVar.eWW.setMaxWidth(i2);
                                rVar.eWW.setText(this.eVp.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 0)).getForumName()}));
                                rVar.eWW.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 0)).getForumName());
                                rVar.eWW.setVisibility(0);
                                rVar.eWX.setMaxWidth(i2);
                                rVar.eWX.setText(this.eVp.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 1)).getForumName()}));
                                rVar.eWX.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 1)).getForumName());
                                rVar.eWX.setVisibility(0);
                                rVar.eWY.setMaxWidth(i2);
                                rVar.eWY.setText(this.eVp.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 2)).getForumName()}));
                                rVar.eWY.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQR.aRJ(), 2)).getForumName());
                                rVar.eWY.setVisibility(0);
                                rVar.eWZ.setVisibility(0);
                                rVar.eXa.setVisibility(0);
                                break;
                        }
                        rVar.eWU.setVisibility(0);
                    }
                } else {
                    rVar.eWU.setVisibility(8);
                    if (this.eQR.aRn() != null && !StringUtils.isNull(this.eQR.aRn().getName()) && !aTZ()) {
                        rVar.cvb.setVisibility(0);
                        rVar.cvb.setText(this.eVp.getResources().getString(d.j.pb_original_bar_from, this.eQR.aRn().getName()));
                    } else {
                        rVar.cvb.setVisibility(8);
                    }
                }
                a(rVar.eRo, view, this.eWL);
                rVar.eRf.setVisibility(8);
                rVar.eRr.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rv() != null) {
                    j = postData.rv().getUserIdLong();
                    str = postData.rv().getUserName();
                    str2 = postData.rv().getName_show();
                }
                if (this.eQR != null && this.eQR.aRp() != null) {
                    rVar.eRr.a(postData.bxc(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eQR.aRp().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                rVar.eRr.onChangeSkinType();
                if (this.eVp.aSQ().aWK()) {
                    rVar.eRo.setVisibility(8);
                }
                if (this.eQR != null && this.eQR.aRp() != null && this.eQR.aRp().rI() != null) {
                    bn rI = this.eQR.aRp().rI();
                    final String activityUrl = rI.getActivityUrl();
                    String tb = rI.tb();
                    if (!StringUtils.isNull(rI.tc())) {
                        rVar.eWS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.P(q.this.eVp.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tb)) {
                            rVar.cJz.setVisibility(0);
                            rVar.cJz.startLoad(tb, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.cJz.setVisibility(8);
                }
                if (rVar.eWT != null) {
                    rVar.eWT.setVisibility(8);
                }
            }
            rVar.eRo.getLayoutStrategy().fS(d.f.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwU()));
            if (postData.bwZ() > 0 && postData.bwR() != null && postData.bwR().size() > 0) {
                if (this.eQS == null) {
                    this.eQS = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eQS.setIsFromCDN(this.mIsFromCDN);
                    this.eQS.G(this.eQU);
                    if (this.eQR != null) {
                        this.eQS.y(this.eQR.aRA(), TextUtils.equals(this.eQR.aRp().rv().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eQS.R(this.eQR.aRp());
                    }
                }
                this.eQS.qh(postData.getId());
            }
            rVar.eRo.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_link_tip_c));
            if (this.eQP) {
                rVar.eRo.getLayoutStrategy().fV(d.f.transparent_bg);
            } else {
                rVar.eRo.getLayoutStrategy().fV(d.f.icon_click);
            }
            rVar.eRo.setIsFromCDN(this.mIsFromCDN);
            if (this.eQR != null && this.eQR.aRp() != null && this.eQR.aRp().isLinkThread()) {
                a(rVar, this.eQR.aRp().sN());
            }
            a(rVar, postData);
            TbRichText bwX = postData.bwX();
            if (this.eQR != null && this.eQR.aRM()) {
                bwX = null;
            }
            if (this.eQV || !this.eQW) {
                rVar.eRo.a(bwX, false, this.eWb);
            } else {
                rVar.eRo.a(bwX, true, this.eWb);
            }
            a(rVar, postData, bwX);
            boolean z7 = !StringUtils.isNull(postData.rv().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eQR != null && this.eQR.aRA() != 0) {
                z8 = true;
                z9 = true;
                if (postData.rv() != null) {
                    String userId = postData.rv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eQR != null && this.eQR.aRp() != null && this.eQR.aRp().rv() != null && postData.rv() != null) {
                String userId2 = this.eQR.aRp().rv().getUserId();
                String userId3 = postData.rv().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.rv() == null && UtilHelper.isCurrentAccount(postData.rv().getUserId())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        boolean z10 = z3;
                        z4 = z2;
                        z5 = z10;
                    }
                    if (z7) {
                        z6 = z4;
                    } else {
                        z8 = false;
                        z6 = false;
                        z = false;
                    }
                    int i3 = 1;
                    if (postData.bwU() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.g.tag_should_manage_visible, true);
                        if (postData.rv() != null) {
                            sparseArray2.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
                        }
                        if (this.eQR != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQR.aRA()));
                        }
                    } else {
                        sparseArray2.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(d.g.tag_user_mute_visible, true);
                        sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rv() != null) {
                            sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rv().getUserId());
                            sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rv().getUserName());
                        }
                        if (this.eQR != null && this.eQR.aRp() != null) {
                            sparseArray2.put(d.g.tag_user_mute_thread_id, this.eQR.aRp().getId());
                        }
                        sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray2.put(d.g.tag_should_delete_visible, true);
                        sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                        if (this.eQR != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQR.aRA()));
                        }
                    } else {
                        sparseArray2.put(d.g.tag_should_delete_visible, false);
                    }
                    b(rVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.rv() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.bwU() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(rVar);
        }
    }

    private void a(r rVar, PostData postData) {
        if (rVar != null && postData != null) {
            if (postData.bxj() == null) {
                rVar.ccm.setVisibility(8);
                rVar.eRo.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            rVar.ccm.b(postData.bxj());
            rVar.ccm.setVisibility(0);
            if (rVar.ccm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.ccm.getLayoutParams();
                if (rVar.cvb.getVisibility() != 0 && rVar.eWU.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.eWN;
                } else {
                    layoutParams.bottomMargin = this.bOX;
                }
                rVar.ccm.setLayoutParams(layoutParams);
            }
            rVar.eRo.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !rVar.eXc.getIsLoaded() && adVar.qe() == com.baidu.tbadk.core.data.ad.Xk) {
            if (adVar.qf()) {
                rVar.eXb.setVisibility(8);
                rVar.eXc.setVisibility(8);
                return;
            }
            rVar.eRo.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds48));
            rVar.eXb.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(rVar.eXb, d.C0096d.cp_bg_line_c);
            rVar.eXc.setVisibility(0);
            rVar.eXc.setFocusable(false);
            rVar.eXc.setBackgroundColor(0);
            rVar.eXc.getSettings().setCacheMode(-1);
            rVar.eXc.setVerticalScrollBarEnabled(false);
            rVar.eXc.setHorizontalScrollBarEnabled(false);
            rVar.eXc.getSettings().setAllowFileAccess(true);
            rVar.eXc.getSettings().setAppCacheEnabled(true);
            rVar.eXc.getSettings().setDomStorageEnabled(true);
            rVar.eXc.getSettings().setDatabaseEnabled(true);
            rVar.eXc.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.eXc.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.eXc.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aYd() == null) {
            rVar.eRJ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aYd(), rVar.eRJ, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.eRo.setTextViewOnTouchListener(this.eWO);
        rVar.eRo.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ac - i, this.eQO);
            tbRichTextView.getLayoutStrategy().fT(min);
            tbRichTextView.getLayoutStrategy().fU((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.eRe.setOnTouchListener(this.aVH);
        rVar.eRe.setOnLongClickListener(this.avF);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eVp.getPageContext().getOrignalPage()).eTu;
        rVar.eRo.setOnLongClickListener(this.avF);
        rVar.eRo.setOnTouchListener(this.eWO);
        rVar.eRo.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.eRo.setOnImageClickListener(this.aVG);
        rVar.eRo.setOnImageTouchListener(this.eWO);
        rVar.eRo.setOnEmotionClickListener(aVar.ffU);
        rVar.eRJ.setOnClickListener(this.mCommonClickListener);
        rVar.cvb.setOnClickListener(this.mCommonClickListener);
        rVar.eWW.setOnClickListener(this);
        rVar.eWX.setOnClickListener(this);
        rVar.eWY.setOnClickListener(this);
        rVar.ccm.setSubClickListener(this.eWP);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.eVp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eVp).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eQR = fVar;
    }

    public void pO(int i) {
        this.eQO = i;
    }

    public void iY(boolean z) {
        this.eQP = z;
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

    public void a(TbRichTextView.c cVar) {
        this.eWb = cVar;
    }

    public void jq(boolean z) {
        this.eWK = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).eXc != null) {
            ((r) this.viewholder).eXc.removeAllViews();
            ((r) this.viewholder).eXc.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).eXc.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).eXc != null) {
                            ((r) q.this.viewholder).eXc.destroy();
                            ((r) q.this.viewholder).eXc = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).eXc != null) {
            ((r) this.viewholder).eXc.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).eXc != null) {
            ((r) this.viewholder).eXc.onPause();
        }
    }

    private boolean aTZ() {
        return (this.eQR == null || this.eQR.aRp() == null || !this.eQR.aRp().si() || this.eQR.aRp().rN() == null) ? false : true;
    }
}
