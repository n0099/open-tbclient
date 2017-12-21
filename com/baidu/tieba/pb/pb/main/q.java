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
    private TbRichTextView.g aVJ;
    private com.baidu.tieba.pb.a.c aVK;
    private View.OnLongClickListener avI;
    private int bPb;
    protected int eQT;
    protected boolean eQU;
    protected com.baidu.tieba.pb.data.f eQW;
    private com.baidu.tieba.pb.pb.sub.d eQX;
    private View.OnClickListener eQZ;
    private boolean eRa;
    private final boolean eRb;
    private final int eWO;
    private boolean eWP;
    private boolean eWQ;
    private int eWR;
    private int eWS;
    private com.baidu.tieba.pb.a.c eWT;
    private OriginalThreadCardView.a eWU;
    private TbRichTextView.c eWg;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eWO = 3;
        this.eQT = 0;
        this.eQU = true;
        this.eWP = true;
        this.eQW = null;
        this.eQX = null;
        this.eQZ = null;
        this.mCommonClickListener = null;
        this.aVJ = null;
        this.aVK = null;
        this.avI = null;
        this.eWg = null;
        this.eRa = false;
        this.eRb = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eWQ = false;
        this.eWR = 0;
        this.eWS = 0;
        this.bPb = 0;
        this.pageFromType = 0;
        this.eWT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.aVK != null) {
                    q.this.aVK.bb(view);
                    q.this.aVK.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.eWU = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.q.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && q.this.eQW != null) {
                    String threadId = q.this.eQW.getThreadId();
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
        this.eWS = com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds60);
        this.bPb = com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aSx() != null) {
            this.pageFromType = pbActivity.aSx().aUU();
        }
        this.eWR = com.baidu.adp.lib.util.l.ac(pbActivity) - com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds130);
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(rVar.eRj, d.C0095d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.k(rVar.dpa, d.C0095d.cp_bg_line_c);
                rVar.eRt.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(rVar.cvf, d.C0095d.cp_cont_f, 1);
                rVar.cvf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                rVar.ccq.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.c(rVar.eXa, d.C0095d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eXb, d.C0095d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eXc, d.C0095d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eXd, d.C0095d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.k(rVar.eXe, d.C0095d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.k(rVar.eXf, d.C0095d.cp_cont_e);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.eVu.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.eQU, this.eQT);
        a(rVar);
        if (rVar.ccq != null) {
            rVar.ccq.ccU = this.pageFromType;
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
        if (!this.eRa && this.eRb && rVar != null && rVar.eRt.Kg() && (listView = ((PbActivity) this.eVu.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eRa = true;
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
            rVar.eRt.setTag(sparseArray);
            rVar.eRj.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            if (this.eWP) {
                rVar.dpa.setVisibility(0);
            } else {
                rVar.dpa.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eQU) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.eRt.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.eRt.setLayoutParams(layoutParams);
                rVar.eRt.hg(null);
                this.eWQ = false;
            } else {
                this.eWQ = true;
                rVar.eRt.hg(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.eRt.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.e.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                rVar.eRt.setLayoutParams(layoutParams2);
            }
            if (postData.bwV() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.eRt.setOnClickListener(this.mCommonClickListener);
                    rVar.eRt.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    rVar.eRt.setOnClickListener(null);
                    rVar.eRt.setTextViewOnClickListener(null);
                }
                rVar.eRj.setOnClickListener(this.mCommonClickListener);
            } else {
                rVar.eRj.setOnClickListener(null);
            }
            if (postData.bwV() == 1) {
                if (!this.eVu.aTD()) {
                    rVar.cvf.setVisibility(8);
                    if (com.baidu.tbadk.core.util.v.w(this.eQW.aRK())) {
                        rVar.eWZ.setVisibility(8);
                    } else {
                        int v = com.baidu.tbadk.core.util.v.v(this.eQW.aRK());
                        if (v > 3) {
                            v = 3;
                        }
                        int i2 = this.eWR / v;
                        switch (v) {
                            case 1:
                                rVar.eXb.setMaxWidth(i2);
                                rVar.eXb.setText(this.eVu.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 0)).getForumName()}));
                                rVar.eXb.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 0)).getForumName());
                                rVar.eXb.setVisibility(0);
                                rVar.eXc.setVisibility(0);
                                rVar.eXd.setVisibility(0);
                                rVar.eXe.setVisibility(8);
                                rVar.eXf.setVisibility(8);
                                break;
                            case 2:
                                rVar.eXb.setMaxWidth(i2);
                                rVar.eXb.setText(this.eVu.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 0)).getForumName()}));
                                rVar.eXb.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 0)).getForumName());
                                rVar.eXb.setVisibility(0);
                                rVar.eXc.setMaxWidth(i2);
                                rVar.eXc.setText(this.eVu.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 1)).getForumName()}));
                                rVar.eXc.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 1)).getForumName());
                                rVar.eXc.setVisibility(0);
                                rVar.eXd.setVisibility(8);
                                rVar.eXe.setVisibility(0);
                                rVar.eXf.setVisibility(8);
                                break;
                            case 3:
                                rVar.eXb.setMaxWidth(i2);
                                rVar.eXb.setText(this.eVu.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 0)).getForumName()}));
                                rVar.eXb.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 0)).getForumName());
                                rVar.eXb.setVisibility(0);
                                rVar.eXc.setMaxWidth(i2);
                                rVar.eXc.setText(this.eVu.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 1)).getForumName()}));
                                rVar.eXc.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 1)).getForumName());
                                rVar.eXc.setVisibility(0);
                                rVar.eXd.setMaxWidth(i2);
                                rVar.eXd.setText(this.eVu.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 2)).getForumName()}));
                                rVar.eXd.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.eQW.aRK(), 2)).getForumName());
                                rVar.eXd.setVisibility(0);
                                rVar.eXe.setVisibility(0);
                                rVar.eXf.setVisibility(0);
                                break;
                        }
                        rVar.eWZ.setVisibility(0);
                    }
                } else {
                    rVar.eWZ.setVisibility(8);
                    if (this.eQW.aRo() != null && !StringUtils.isNull(this.eQW.aRo().getName()) && !aUa()) {
                        rVar.cvf.setVisibility(0);
                        rVar.cvf.setText(this.eVu.getResources().getString(d.j.pb_original_bar_from, this.eQW.aRo().getName()));
                    } else {
                        rVar.cvf.setVisibility(8);
                    }
                }
                a(rVar.eRt, view, this.eWQ);
                rVar.eRk.setVisibility(8);
                rVar.eRw.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rv() != null) {
                    j = postData.rv().getUserIdLong();
                    str = postData.rv().getUserName();
                    str2 = postData.rv().getName_show();
                }
                if (this.eQW != null && this.eQW.aRq() != null) {
                    rVar.eRw.a(postData.bxd(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eQW.aRq().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                rVar.eRw.onChangeSkinType();
                if (this.eVu.aSR().aWL()) {
                    rVar.eRt.setVisibility(8);
                }
                if (this.eQW != null && this.eQW.aRq() != null && this.eQW.aRq().rI() != null) {
                    bn rI = this.eQW.aRq().rI();
                    final String activityUrl = rI.getActivityUrl();
                    String tb = rI.tb();
                    if (!StringUtils.isNull(rI.tc())) {
                        rVar.eWX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.P(q.this.eVu.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tb)) {
                            rVar.cJD.setVisibility(0);
                            rVar.cJD.startLoad(tb, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.cJD.setVisibility(8);
                }
                if (rVar.eWY != null) {
                    rVar.eWY.setVisibility(8);
                }
            }
            rVar.eRt.getLayoutStrategy().fS(d.f.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwV()));
            if (postData.bxa() > 0 && postData.bwS() != null && postData.bwS().size() > 0) {
                if (this.eQX == null) {
                    this.eQX = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eQX.setIsFromCDN(this.mIsFromCDN);
                    this.eQX.G(this.eQZ);
                    if (this.eQW != null) {
                        this.eQX.y(this.eQW.aRB(), TextUtils.equals(this.eQW.aRq().rv().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eQX.R(this.eQW.aRq());
                    }
                }
                this.eQX.qh(postData.getId());
            }
            rVar.eRt.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_link_tip_c));
            if (this.eQU) {
                rVar.eRt.getLayoutStrategy().fV(d.f.transparent_bg);
            } else {
                rVar.eRt.getLayoutStrategy().fV(d.f.icon_click);
            }
            rVar.eRt.setIsFromCDN(this.mIsFromCDN);
            if (this.eQW != null && this.eQW.aRq() != null && this.eQW.aRq().isLinkThread()) {
                a(rVar, this.eQW.aRq().sN());
            }
            a(rVar, postData);
            TbRichText bwY = postData.bwY();
            if (this.eQW != null && this.eQW.aRN()) {
                bwY = null;
            }
            if (this.eRa || !this.eRb) {
                rVar.eRt.a(bwY, false, this.eWg);
            } else {
                rVar.eRt.a(bwY, true, this.eWg);
            }
            a(rVar, postData, bwY);
            boolean z7 = !StringUtils.isNull(postData.rv().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eQW != null && this.eQW.aRB() != 0) {
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
            if (this.eQW != null && this.eQW.aRq() != null && this.eQW.aRq().rv() != null && postData.rv() != null) {
                String userId2 = this.eQW.aRq().rv().getUserId();
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
                    if (postData.bwV() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.g.tag_should_manage_visible, true);
                        if (postData.rv() != null) {
                            sparseArray2.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
                        }
                        if (this.eQW != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQW.aRB()));
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
                        if (this.eQW != null && this.eQW.aRq() != null) {
                            sparseArray2.put(d.g.tag_user_mute_thread_id, this.eQW.aRq().getId());
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
                        if (this.eQW != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eQW.aRB()));
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
            if (postData.bwV() == 1) {
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
            if (postData.bxk() == null) {
                rVar.ccq.setVisibility(8);
                rVar.eRt.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            rVar.ccq.b(postData.bxk());
            rVar.ccq.setVisibility(0);
            if (rVar.ccq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.ccq.getLayoutParams();
                if (rVar.cvf.getVisibility() != 0 && rVar.eWZ.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.eWS;
                } else {
                    layoutParams.bottomMargin = this.bPb;
                }
                rVar.ccq.setLayoutParams(layoutParams);
            }
            rVar.eRt.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !rVar.eXh.getIsLoaded() && adVar.qe() == com.baidu.tbadk.core.data.ad.Xn) {
            if (adVar.qf()) {
                rVar.eXg.setVisibility(8);
                rVar.eXh.setVisibility(8);
                return;
            }
            rVar.eRt.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds48));
            rVar.eXg.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(rVar.eXg, d.C0095d.cp_bg_line_c);
            rVar.eXh.setVisibility(0);
            rVar.eXh.setFocusable(false);
            rVar.eXh.setBackgroundColor(0);
            rVar.eXh.getSettings().setCacheMode(-1);
            rVar.eXh.setVerticalScrollBarEnabled(false);
            rVar.eXh.setHorizontalScrollBarEnabled(false);
            rVar.eXh.getSettings().setAllowFileAccess(true);
            rVar.eXh.getSettings().setAppCacheEnabled(true);
            rVar.eXh.getSettings().setDomStorageEnabled(true);
            rVar.eXh.getSettings().setDatabaseEnabled(true);
            rVar.eXh.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.eXh.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.eXh.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aYe() == null) {
            rVar.eRO.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aYe(), rVar.eRO, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.eRt.setTextViewOnTouchListener(this.eWT);
        rVar.eRt.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ac - i, this.eQT);
            tbRichTextView.getLayoutStrategy().fT(min);
            tbRichTextView.getLayoutStrategy().fU((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.eRj.setOnTouchListener(this.aVK);
        rVar.eRj.setOnLongClickListener(this.avI);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eVu.getPageContext().getOrignalPage()).eTz;
        rVar.eRt.setOnLongClickListener(this.avI);
        rVar.eRt.setOnTouchListener(this.eWT);
        rVar.eRt.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.eRt.setOnImageClickListener(this.aVJ);
        rVar.eRt.setOnImageTouchListener(this.eWT);
        rVar.eRt.setOnEmotionClickListener(aVar.ffZ);
        rVar.eRO.setOnClickListener(this.mCommonClickListener);
        rVar.cvf.setOnClickListener(this.mCommonClickListener);
        rVar.eXb.setOnClickListener(this);
        rVar.eXc.setOnClickListener(this);
        rVar.eXd.setOnClickListener(this);
        rVar.ccq.setSubClickListener(this.eWU);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.eVu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eVu).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eQW = fVar;
    }

    public void pO(int i) {
        this.eQT = i;
    }

    public void iY(boolean z) {
        this.eQU = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQZ = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVJ = gVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avI = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.eWg = cVar;
    }

    public void jq(boolean z) {
        this.eWP = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).eXh != null) {
            ((r) this.viewholder).eXh.removeAllViews();
            ((r) this.viewholder).eXh.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).eXh.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).eXh != null) {
                            ((r) q.this.viewholder).eXh.destroy();
                            ((r) q.this.viewholder).eXh = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).eXh != null) {
            ((r) this.viewholder).eXh.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).eXh != null) {
            ((r) this.viewholder).eXh.onPause();
        }
    }

    private boolean aUa() {
        return (this.eQW == null || this.eQW.aRq() == null || !this.eQW.aRq().si() || this.eQW.aRq().rN() == null) ? false : true;
    }
}
