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
    private TbRichTextView.f aVE;
    private com.baidu.tieba.pb.a.c aVF;
    private View.OnLongClickListener avA;
    private int bOT;
    protected int ePL;
    protected boolean ePM;
    protected com.baidu.tieba.pb.data.f ePO;
    private com.baidu.tieba.pb.pb.sub.d ePP;
    private View.OnClickListener ePR;
    private boolean ePS;
    private final boolean ePT;
    private TbRichTextView.b eUY;
    private final int eVG;
    private boolean eVH;
    private boolean eVI;
    private int eVJ;
    private int eVK;
    private com.baidu.tieba.pb.a.c eVL;
    private OriginalThreadCardView.a eVM;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eVG = 3;
        this.ePL = 0;
        this.ePM = true;
        this.eVH = true;
        this.ePO = null;
        this.ePP = null;
        this.ePR = null;
        this.mCommonClickListener = null;
        this.aVE = null;
        this.aVF = null;
        this.avA = null;
        this.eUY = null;
        this.ePS = false;
        this.ePT = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eVI = false;
        this.eVJ = 0;
        this.eVK = 0;
        this.bOT = 0;
        this.pageFromType = 0;
        this.eVL = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.aVF != null) {
                    q.this.aVF.aX(view);
                    q.this.aVF.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.eVM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.q.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && q.this.ePO != null) {
                    String threadId = q.this.ePO.getThreadId();
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
        this.eVK = com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds60);
        this.bOT = com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aSo() != null) {
            this.pageFromType = pbActivity.aSo().aUL();
        }
        this.eVJ = com.baidu.adp.lib.util.l.ac(pbActivity) - com.baidu.adp.lib.util.l.f(pbActivity, d.e.ds130);
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(rVar.eQb, d.C0082d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.k(rVar.dnQ, d.C0082d.cp_bg_line_c);
                rVar.eQl.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(rVar.cuS, d.C0082d.cp_cont_f, 1);
                rVar.cuS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                rVar.cci.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.c(rVar.eVS, d.C0082d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eVT, d.C0082d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eVU, d.C0082d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eVV, d.C0082d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.k(rVar.eVW, d.C0082d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.k(rVar.eVX, d.C0082d.cp_cont_e);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.eUm.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.ePM, this.ePL);
        a(rVar);
        if (rVar.cci != null) {
            rVar.cci.ccL = this.pageFromType;
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
            postData2.sw();
            a(rVar, postData2, view, i);
        }
        if (!this.ePS && this.ePT && rVar != null && rVar.eQl.Kf() && (listView = ((PbActivity) this.eUm.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ePS = true;
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
            rVar.eQl.setTag(sparseArray);
            rVar.eQb.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            if (this.eVH) {
                rVar.dnQ.setVisibility(0);
            } else {
                rVar.dnQ.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ePM) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.eQl.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.eQl.setLayoutParams(layoutParams);
                rVar.eQl.hi(null);
                this.eVI = false;
            } else {
                this.eVI = true;
                rVar.eQl.hi(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.eQl.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.e.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                rVar.eQl.setLayoutParams(layoutParams2);
            }
            if (postData.bwo() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.eQl.setOnClickListener(this.mCommonClickListener);
                    rVar.eQl.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    rVar.eQl.setOnClickListener(null);
                    rVar.eQl.setTextViewOnClickListener(null);
                }
                rVar.eQb.setOnClickListener(this.mCommonClickListener);
            } else {
                rVar.eQb.setOnClickListener(null);
            }
            if (postData.bwo() == 1) {
                if (!this.eUm.aTu()) {
                    rVar.cuS.setVisibility(8);
                    if (com.baidu.tbadk.core.util.v.w(this.ePO.aRB())) {
                        rVar.eVR.setVisibility(8);
                    } else {
                        int v = com.baidu.tbadk.core.util.v.v(this.ePO.aRB());
                        if (v > 3) {
                            v = 3;
                        }
                        int i2 = this.eVJ / v;
                        switch (v) {
                            case 1:
                                rVar.eVT.setMaxWidth(i2);
                                rVar.eVT.setText(this.eUm.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 0)).getForumName()}));
                                rVar.eVT.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 0)).getForumName());
                                rVar.eVT.setVisibility(0);
                                rVar.eVU.setVisibility(0);
                                rVar.eVV.setVisibility(0);
                                rVar.eVW.setVisibility(8);
                                rVar.eVX.setVisibility(8);
                                break;
                            case 2:
                                rVar.eVT.setMaxWidth(i2);
                                rVar.eVT.setText(this.eUm.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 0)).getForumName()}));
                                rVar.eVT.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 0)).getForumName());
                                rVar.eVT.setVisibility(0);
                                rVar.eVU.setMaxWidth(i2);
                                rVar.eVU.setText(this.eUm.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 1)).getForumName()}));
                                rVar.eVU.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 1)).getForumName());
                                rVar.eVU.setVisibility(0);
                                rVar.eVV.setVisibility(8);
                                rVar.eVW.setVisibility(0);
                                rVar.eVX.setVisibility(8);
                                break;
                            case 3:
                                rVar.eVT.setMaxWidth(i2);
                                rVar.eVT.setText(this.eUm.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 0)).getForumName()}));
                                rVar.eVT.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 0)).getForumName());
                                rVar.eVT.setVisibility(0);
                                rVar.eVU.setMaxWidth(i2);
                                rVar.eVU.setText(this.eUm.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 1)).getForumName()}));
                                rVar.eVU.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 1)).getForumName());
                                rVar.eVU.setVisibility(0);
                                rVar.eVV.setMaxWidth(i2);
                                rVar.eVV.setText(this.eUm.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 2)).getForumName()}));
                                rVar.eVV.setTag(((ay) com.baidu.tbadk.core.util.v.c(this.ePO.aRB(), 2)).getForumName());
                                rVar.eVV.setVisibility(0);
                                rVar.eVW.setVisibility(0);
                                rVar.eVX.setVisibility(0);
                                break;
                        }
                        rVar.eVR.setVisibility(0);
                    }
                } else {
                    rVar.eVR.setVisibility(8);
                    if (this.ePO.aRf() != null && !StringUtils.isNull(this.ePO.aRf().getName()) && !aTR()) {
                        rVar.cuS.setVisibility(0);
                        rVar.cuS.setText(this.eUm.getResources().getString(d.j.pb_original_bar_from, this.ePO.aRf().getName()));
                    } else {
                        rVar.cuS.setVisibility(8);
                    }
                }
                a(rVar.eQl, view, this.eVI);
                rVar.eQc.setVisibility(8);
                rVar.eQo.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rx() != null) {
                    j = postData.rx().getUserIdLong();
                    str = postData.rx().getUserName();
                    str2 = postData.rx().getName_show();
                }
                if (this.ePO != null && this.ePO.aRh() != null) {
                    rVar.eQo.a(postData.bww(), str, str2, j, com.baidu.adp.lib.g.b.c(this.ePO.aRh().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                rVar.eQo.onChangeSkinType();
                if (this.eUm.aSI().aWC()) {
                    rVar.eQl.setVisibility(8);
                }
                if (this.ePO != null && this.ePO.aRh() != null && this.ePO.aRh().rK() != null) {
                    bn rK = this.ePO.aRh().rK();
                    final String activityUrl = rK.getActivityUrl();
                    String te = rK.te();
                    if (!StringUtils.isNull(rK.tf())) {
                        rVar.eVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.Q(q.this.eUm.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(te)) {
                            rVar.cJp.setVisibility(0);
                            rVar.cJp.startLoad(te, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.cJp.setVisibility(8);
                }
                if (rVar.eVQ != null) {
                    rVar.eVQ.setVisibility(8);
                }
            }
            rVar.eQl.getLayoutStrategy().fS(d.f.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwo()));
            if (postData.bwt() > 0 && postData.bwl() != null && postData.bwl().size() > 0) {
                if (this.ePP == null) {
                    this.ePP = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.ePP.setIsFromCDN(this.mIsFromCDN);
                    this.ePP.G(this.ePR);
                    if (this.ePO != null) {
                        this.ePP.y(this.ePO.aRs(), TextUtils.equals(this.ePO.aRh().rx().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.ePP.P(this.ePO.aRh());
                    }
                }
                this.ePP.qh(postData.getId());
            }
            rVar.eQl.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_link_tip_c));
            if (this.ePM) {
                rVar.eQl.getLayoutStrategy().fV(d.f.transparent_bg);
            } else {
                rVar.eQl.getLayoutStrategy().fV(d.f.icon_click);
            }
            rVar.eQl.setIsFromCDN(this.mIsFromCDN);
            if (this.ePO != null && this.ePO.aRh() != null && this.ePO.aRh().isLinkThread()) {
                a(rVar, this.ePO.aRh().sP());
            }
            a(rVar, postData);
            TbRichText bwr = postData.bwr();
            if (this.ePO != null && this.ePO.aRE()) {
                bwr = null;
            }
            if (this.ePS || !this.ePT) {
                rVar.eQl.a(bwr, false, this.eUY);
            } else {
                rVar.eQl.a(bwr, true, this.eUY);
            }
            a(rVar, postData, bwr);
            boolean z7 = !StringUtils.isNull(postData.rx().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.ePO != null && this.ePO.aRs() != 0) {
                z8 = true;
                z9 = true;
                if (postData.rx() != null) {
                    String userId = postData.rx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.ePO != null && this.ePO.aRh() != null && this.ePO.aRh().rx() != null && postData.rx() != null) {
                String userId2 = this.ePO.aRh().rx().getUserId();
                String userId3 = postData.rx().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.rx() == null && UtilHelper.isCurrentAccount(postData.rx().getUserId())) {
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
                    if (postData.bwo() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.g.tag_should_manage_visible, true);
                        if (postData.rx() != null) {
                            sparseArray2.put(d.g.tag_forbid_user_name, postData.rx().getUserName());
                        }
                        if (this.ePO != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ePO.aRs()));
                        }
                    } else {
                        sparseArray2.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(d.g.tag_user_mute_visible, true);
                        sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rx() != null) {
                            sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rx().getUserId());
                            sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rx().getUserName());
                        }
                        if (this.ePO != null && this.ePO.aRh() != null) {
                            sparseArray2.put(d.g.tag_user_mute_thread_id, this.ePO.aRh().getId());
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
                        if (this.ePO != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ePO.aRs()));
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
            if (postData.rx() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.bwo() == 1) {
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
            if (postData.bwD() == null) {
                rVar.cci.setVisibility(8);
                rVar.eQl.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            rVar.cci.b(postData.bwD());
            rVar.cci.setVisibility(0);
            if (rVar.cci.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.cci.getLayoutParams();
                if (rVar.cuS.getVisibility() != 0 && rVar.eVR.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.eVK;
                } else {
                    layoutParams.bottomMargin = this.bOT;
                }
                rVar.cci.setLayoutParams(layoutParams);
            }
            rVar.eQl.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !rVar.eVZ.getIsLoaded() && adVar.qg() == com.baidu.tbadk.core.data.ad.Xq) {
            if (adVar.qh()) {
                rVar.eVY.setVisibility(8);
                rVar.eVZ.setVisibility(8);
                return;
            }
            rVar.eQl.getLayoutStrategy().fZ(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds48));
            rVar.eVY.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(rVar.eVY, d.C0082d.cp_bg_line_c);
            rVar.eVZ.setVisibility(0);
            rVar.eVZ.setFocusable(false);
            rVar.eVZ.setBackgroundColor(0);
            rVar.eVZ.getSettings().setCacheMode(-1);
            rVar.eVZ.setVerticalScrollBarEnabled(false);
            rVar.eVZ.setHorizontalScrollBarEnabled(false);
            rVar.eVZ.getSettings().setAllowFileAccess(true);
            rVar.eVZ.getSettings().setAppCacheEnabled(true);
            rVar.eVZ.getSettings().setDomStorageEnabled(true);
            rVar.eVZ.getSettings().setDatabaseEnabled(true);
            rVar.eVZ.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.eVZ.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.eVZ.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aXW() == null) {
            rVar.eQG.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aXW(), rVar.eQG, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.eQl.setTextViewOnTouchListener(this.eVL);
        rVar.eQl.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ac - i, this.ePL);
            tbRichTextView.getLayoutStrategy().fT(min);
            tbRichTextView.getLayoutStrategy().fU((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.eQb.setOnTouchListener(this.aVF);
        rVar.eQb.setOnLongClickListener(this.avA);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eUm.getPageContext().getOrignalPage()).eSr;
        rVar.eQl.setOnLongClickListener(this.avA);
        rVar.eQl.setOnTouchListener(this.eVL);
        rVar.eQl.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.eQl.setOnImageClickListener(this.aVE);
        rVar.eQl.setOnImageTouchListener(this.eVL);
        rVar.eQl.setOnEmotionClickListener(aVar.feT);
        rVar.eQG.setOnClickListener(this.mCommonClickListener);
        rVar.cuS.setOnClickListener(this.mCommonClickListener);
        rVar.eVT.setOnClickListener(this);
        rVar.eVU.setOnClickListener(this);
        rVar.eVV.setOnClickListener(this);
        rVar.cci.setSubClickListener(this.eVM);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.eUm.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eUm).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ePO = fVar;
    }

    public void pH(int i) {
        this.ePL = i;
    }

    public void iX(boolean z) {
        this.ePM = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.ePR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aVE = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avA = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eUY = bVar;
    }

    public void jp(boolean z) {
        this.eVH = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).eVZ != null) {
            ((r) this.viewholder).eVZ.removeAllViews();
            ((r) this.viewholder).eVZ.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).eVZ.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).eVZ != null) {
                            ((r) q.this.viewholder).eVZ.destroy();
                            ((r) q.this.viewholder).eVZ = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).eVZ != null) {
            ((r) this.viewholder).eVZ.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).eVZ != null) {
            ((r) this.viewholder).eVZ.onPause();
        }
    }

    private boolean aTR() {
        return (this.ePO == null || this.ePO.aRh() == null || !this.ePO.aRh().sk() || this.ePO.aRh().rP() == null) ? false : true;
    }
}
