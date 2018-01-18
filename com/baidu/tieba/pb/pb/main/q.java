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
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class q extends m<PostData, r> implements View.OnClickListener {
    private TbRichTextView.h bJF;
    private com.baidu.tieba.pb.a.c bJG;
    private View.OnLongClickListener bjX;
    private int cDQ;
    protected int fEU;
    protected boolean fEV;
    protected com.baidu.tieba.pb.data.f fEX;
    private com.baidu.tieba.pb.pb.sub.d fEY;
    private View.OnClickListener fFa;
    private boolean fFb;
    private final boolean fFc;
    private final int fKY;
    private boolean fKZ;
    private TbRichTextView.c fKj;
    private boolean fLa;
    private int fLb;
    private int fLc;
    private com.baidu.tieba.pb.a.c fLd;
    private OriginalThreadCardView.a fLe;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fKY = 3;
        this.fEU = 0;
        this.fEV = true;
        this.fKZ = true;
        this.fEX = null;
        this.fEY = null;
        this.fFa = null;
        this.mCommonClickListener = null;
        this.bJF = null;
        this.bJG = null;
        this.bjX = null;
        this.fKj = null;
        this.fFb = false;
        this.fFc = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fLa = false;
        this.fLb = 0;
        this.fLc = 0;
        this.cDQ = 0;
        this.pageFromType = 0;
        this.fLd = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean e(View view, MotionEvent motionEvent) {
                if (q.this.bJG != null) {
                    q.this.bJG.co(view);
                    q.this.bJG.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fLe = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.q.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && q.this.fEX != null) {
                    String threadId = q.this.fEX.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12602").ab("tid", threadId).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).s("obj_type", i));
                    }
                }
            }
        };
        this.fLc = com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds60);
        this.cDQ = com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aZO() != null) {
            this.pageFromType = pbActivity.aZO().bcl();
        }
        this.fLb = com.baidu.adp.lib.util.l.ao(pbActivity) - com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds130);
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.t(rVar.fFk, d.C0107d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.t(rVar.ecs, d.C0107d.cp_bg_line_c);
                rVar.fFu.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.e(rVar.bcz, d.C0107d.cp_cont_f, 1);
                rVar.bcz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                rVar.cVw.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(rVar.fLn, d.C0107d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fLo, d.C0107d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fLp, d.C0107d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fLq, d.C0107d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.t(rVar.fLr, d.C0107d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.t(rVar.fLs, d.C0107d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(rVar.fLv, d.C0107d.cp_cont_d, 1);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.fJw.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.fEV, this.fEU);
        a(rVar);
        if (rVar.cVw != null) {
            rVar.cVw.cVZ = this.pageFromType;
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
            postData2.zO();
            b(rVar, postData2, view, i);
        }
        if (!this.fFb && this.fFc && rVar != null && rVar.fFu.Rr() && (listView = ((PbActivity) this.fJw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fFb = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:162:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x07c6  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07d2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x07e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(r rVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        com.baidu.tbadk.core.data.t tVar;
        if (postData.bvH() != 1) {
            if (TextUtils.isEmpty(postData.getBimg_url())) {
                rVar.fFu.setOnClickListener(this.mCommonClickListener);
                rVar.fFu.setTextViewOnClickListener(this.mCommonClickListener);
            } else {
                rVar.fFu.setOnClickListener(null);
                rVar.fFu.setTextViewOnClickListener(null);
            }
            rVar.fFk.setOnClickListener(this.mCommonClickListener);
        } else {
            rVar.fFk.setOnClickListener(null);
        }
        if (postData.bvH() == 1) {
            rVar.fLv.setVisibility(8);
            if (this.fEX != null) {
                StringBuilder sb = null;
                List<ay> aZa = this.fEX.aZa();
                if (com.baidu.tbadk.core.util.v.D(aZa) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (ay ayVar : aZa) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aMP) != null && tVar.isDeleted && ((tVar.aKW && (tVar.type == 1 || tVar.type == 2)) || (this.fEX.aYG() != null && this.fEX.aYG().yS() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fEX.aYG().yS().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fJw.getString(d.j.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    rVar.fLv.setVisibility(0);
                    rVar.fLv.setText(String.format(this.fJw.getString(d.j.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            if (!this.fJw.baT()) {
                rVar.bcz.setVisibility(8);
                if (com.baidu.tbadk.core.util.v.E(this.fEX.aZa())) {
                    rVar.fLm.setVisibility(8);
                    rVar.fLv.setVisibility(8);
                } else {
                    int D = com.baidu.tbadk.core.util.v.D(this.fEX.aZa());
                    if (D > 3) {
                        D = 3;
                    }
                    int i2 = this.fLb / D;
                    switch (D) {
                        case 1:
                            rVar.fLo.setMaxWidth(i2);
                            rVar.fLo.setText(this.fJw.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 0)).getForumName()}));
                            rVar.fLo.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 0)).getForumName());
                            rVar.fLo.setVisibility(0);
                            rVar.fLp.setVisibility(0);
                            rVar.fLq.setVisibility(0);
                            rVar.fLr.setVisibility(8);
                            rVar.fLs.setVisibility(8);
                            break;
                        case 2:
                            rVar.fLo.setMaxWidth(i2);
                            rVar.fLo.setText(this.fJw.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 0)).getForumName()}));
                            rVar.fLo.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 0)).getForumName());
                            rVar.fLo.setVisibility(0);
                            rVar.fLp.setMaxWidth(i2);
                            rVar.fLp.setText(this.fJw.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 1)).getForumName()}));
                            rVar.fLp.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 1)).getForumName());
                            rVar.fLp.setVisibility(0);
                            rVar.fLq.setVisibility(8);
                            rVar.fLr.setVisibility(0);
                            rVar.fLs.setVisibility(8);
                            break;
                        case 3:
                            rVar.fLo.setMaxWidth(i2);
                            rVar.fLo.setText(this.fJw.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 0)).getForumName()}));
                            rVar.fLo.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 0)).getForumName());
                            rVar.fLo.setVisibility(0);
                            rVar.fLp.setMaxWidth(i2);
                            rVar.fLp.setText(this.fJw.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 1)).getForumName()}));
                            rVar.fLp.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 1)).getForumName());
                            rVar.fLp.setVisibility(0);
                            rVar.fLq.setMaxWidth(i2);
                            rVar.fLq.setText(this.fJw.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 2)).getForumName()}));
                            rVar.fLq.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fEX.aZa(), 2)).getForumName());
                            rVar.fLq.setVisibility(0);
                            rVar.fLr.setVisibility(0);
                            rVar.fLs.setVisibility(0);
                            break;
                    }
                    rVar.fLm.setVisibility(0);
                }
            } else {
                rVar.fLm.setVisibility(8);
                rVar.fLv.setVisibility(8);
                if (this.fEX.aYE() != null && !StringUtils.isNull(this.fEX.aYE().getName()) && !bbp()) {
                    rVar.bcz.setVisibility(0);
                    rVar.bcz.setText(this.fJw.getResources().getString(d.j.pb_original_bar_from, this.fEX.aYE().getName()));
                } else {
                    rVar.bcz.setVisibility(8);
                }
            }
            a(rVar.fFu, view, this.fLa);
            rVar.fFl.setVisibility(8);
            rVar.fFx.setVisibility(0);
            String str = null;
            String str2 = null;
            long j = 0;
            if (postData.yS() != null) {
                j = postData.yS().getUserIdLong();
                str = postData.yS().getUserName();
                str2 = postData.yS().getName_show();
            }
            if (this.fEX != null && this.fEX.aYG() != null) {
                rVar.fFx.a(postData.bvQ(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fEX.aYG().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
            }
            rVar.fFx.onChangeSkinType();
            if (this.fJw.bah().bee()) {
                rVar.fFu.setVisibility(8);
            }
            if (this.fEX != null && this.fEX.aYG() != null && this.fEX.aYG().zf() != null) {
                bn zf = this.fEX.aYG().zf();
                final String activityUrl = zf.getActivityUrl();
                String Au = zf.Au();
                if (!StringUtils.isNull(zf.Av())) {
                    rVar.fLk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.oZ()) {
                                TiebaStatic.log("c10854");
                                com.baidu.tbadk.browser.a.R(q.this.fJw.getActivity(), activityUrl);
                            }
                        }
                    });
                    if (!StringUtils.isNull(Au)) {
                        rVar.fLj.setVisibility(0);
                        rVar.fLj.startLoad(Au, 10, true);
                    }
                } else {
                    return;
                }
            } else {
                rVar.fLj.setVisibility(8);
            }
            if (rVar.fLl != null) {
                rVar.fLl.setVisibility(8);
            }
        }
        rVar.fFu.getLayoutStrategy().iN(d.f.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_clip_board, postData);
        sparseArray.put(d.g.tag_load_sub_data, postData);
        sparseArray.put(d.g.tag_load_sub_view, view);
        sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
        sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bvH()));
        if (postData.bvM() > 0 && postData.bvE() != null && postData.bvE().size() > 0) {
            if (this.fEY == null) {
                this.fEY = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                this.fEY.setIsFromCDN(this.mIsFromCDN);
                this.fEY.H(this.fFa);
                if (this.fEX != null) {
                    this.fEY.J(this.fEX.aYS(), TextUtils.equals(this.fEX.aYG().yS().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.fEY.Q(this.fEX.aYG());
                }
            }
            this.fEY.qu(postData.getId());
        }
        rVar.fFu.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_link_tip_c));
        if (this.fEV) {
            rVar.fFu.getLayoutStrategy().iQ(d.f.transparent_bg);
        } else {
            rVar.fFu.getLayoutStrategy().iQ(d.f.icon_click);
        }
        rVar.fFu.setIsFromCDN(this.mIsFromCDN);
        if (this.fEX != null && this.fEX.aYG() != null && this.fEX.aYG().isLinkThread()) {
            a(rVar, this.fEX.aYG().Ah());
        }
        a(rVar, postData);
        TbRichText bvK = postData.bvK();
        if (this.fEX != null && this.fEX.aZd()) {
            bvK = null;
        }
        if (this.fFb || !this.fFc) {
            rVar.fFu.a(bvK, false, this.fKj);
        } else {
            rVar.fFu.a(bvK, true, this.fKj);
        }
        a(rVar, postData, bvK);
        boolean z7 = !StringUtils.isNull(postData.yS().getVirtualUserUrl());
        boolean z8 = false;
        boolean z9 = false;
        if (this.fEX != null && this.fEX.aYS() != 0) {
            z8 = true;
            z9 = true;
            if (postData.yS() != null) {
                String userId = postData.yS().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z8 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z8 = false;
                }
            }
        }
        if (this.fEX != null && this.fEX.aYG() != null && this.fEX.aYG().yS() != null && postData.yS() != null) {
            String userId2 = this.fEX.aYG().yS().getUserId();
            String userId3 = postData.yS().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                z2 = true;
                if (!UtilHelper.isCurrentAccount(userId3)) {
                    z = true;
                    z3 = false;
                } else {
                    z = false;
                    z3 = true;
                }
                if (postData.yS() == null && UtilHelper.isCurrentAccount(postData.yS().getUserId())) {
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
                if (postData.bvH() == 1) {
                    i3 = 0;
                }
                sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                if (!z8) {
                    sparseArray.put(d.g.tag_should_manage_visible, true);
                    if (postData.yS() != null) {
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yS().getUserName());
                    }
                    if (this.fEX != null) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fEX.aYS()));
                    }
                } else {
                    sparseArray.put(d.g.tag_should_manage_visible, false);
                }
                if (!z) {
                    sparseArray.put(d.g.tag_user_mute_visible, true);
                    sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yS() != null) {
                        sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yS().getUserId());
                        sparseArray.put(d.g.tag_user_mute_mute_username, postData.yS().getUserName());
                    }
                    if (this.fEX != null && this.fEX.aYG() != null) {
                        sparseArray.put(d.g.tag_user_mute_thread_id, this.fEX.aYG().getId());
                    }
                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                } else {
                    sparseArray.put(d.g.tag_user_mute_visible, false);
                }
                if (!z6) {
                    sparseArray.put(d.g.tag_should_delete_visible, true);
                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i3));
                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    if (this.fEX != null) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fEX.aYS()));
                    }
                } else {
                    sparseArray.put(d.g.tag_should_delete_visible, false);
                }
                b(rVar);
            }
        }
        z = false;
        z2 = z9;
        z3 = false;
        if (postData.yS() == null) {
        }
        boolean z102 = z3;
        z4 = z2;
        z5 = z102;
        if (z7) {
        }
        int i32 = 1;
        if (postData.bvH() == 1) {
        }
        sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
        if (!z8) {
        }
        if (!z) {
        }
        if (!z6) {
        }
        b(rVar);
    }

    private void b(final r rVar, final PostData postData, final View view, final int i) {
        if (rVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            rVar.fFu.setTag(sparseArray);
            rVar.fFk.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            rVar.fFu.setIsHost(true);
            if (this.fKZ) {
                rVar.ecs.setVisibility(0);
            } else {
                rVar.ecs.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fEV) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.fFu.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.fFu.setLayoutParams(layoutParams);
                rVar.fFu.hk(null);
                this.fLa = false;
                a(rVar, postData, view, i);
                return;
            }
            this.fLa = true;
            rVar.fFu.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                public void Rw() {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.fFu.getLayoutParams();
                    layoutParams2.topMargin = q.this.getDimensionPixelSize(d.e.ds16);
                    int dimensionPixelSize = q.this.getDimensionPixelSize(d.e.ds34);
                    layoutParams2.bottomMargin = dimensionPixelSize;
                    layoutParams2.leftMargin = dimensionPixelSize;
                    layoutParams2.rightMargin = dimensionPixelSize;
                    rVar.fFu.setLayoutParams(layoutParams2);
                    q.this.a(rVar, postData, view, i);
                }
            });
        }
    }

    private void a(r rVar, PostData postData) {
        if (rVar != null && postData != null) {
            if (postData.bvX() == null) {
                rVar.cVw.setVisibility(8);
                rVar.fFu.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            rVar.cVw.b(postData.bvX());
            rVar.cVw.setVisibility(0);
            if (rVar.cVw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.cVw.getLayoutParams();
                if (rVar.bcz.getVisibility() != 0 && rVar.fLm.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.fLc;
                } else {
                    layoutParams.bottomMargin = this.cDQ;
                }
                rVar.cVw.setLayoutParams(layoutParams);
            }
            rVar.fFu.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !rVar.fLu.getIsLoaded() && adVar.xE() == com.baidu.tbadk.core.data.ad.aLH) {
            if (adVar.xF()) {
                rVar.fLt.setVisibility(8);
                rVar.fLu.setVisibility(8);
                return;
            }
            rVar.fFu.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds48));
            rVar.fLt.setVisibility(0);
            com.baidu.tbadk.core.util.aj.t(rVar.fLt, d.C0107d.cp_bg_line_c);
            rVar.fLu.setVisibility(0);
            rVar.fLu.setFocusable(false);
            rVar.fLu.setBackgroundColor(0);
            rVar.fLu.getSettings().setCacheMode(-1);
            rVar.fLu.setVerticalScrollBarEnabled(false);
            rVar.fLu.setHorizontalScrollBarEnabled(false);
            rVar.fLu.getSettings().setAllowFileAccess(true);
            rVar.fLu.getSettings().setAppCacheEnabled(true);
            rVar.fLu.getSettings().setDomStorageEnabled(true);
            rVar.fLu.getSettings().setDatabaseEnabled(true);
            rVar.fLu.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.fLu.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.fLu.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bfv() == null) {
            rVar.fFP.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.bfv(), rVar.fFP, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.fFu.setTextViewOnTouchListener(this.fLd);
        rVar.fFu.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ao - i, this.fEU);
            tbRichTextView.getLayoutStrategy().iO(min);
            tbRichTextView.getLayoutStrategy().iP((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.fFk.setOnTouchListener(this.bJG);
        rVar.fFk.setOnLongClickListener(this.bjX);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA;
        rVar.fFu.setOnLongClickListener(this.bjX);
        rVar.fFu.setOnTouchListener(this.fLd);
        rVar.fFu.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.fFu.setOnImageClickListener(this.bJF);
        rVar.fFu.setOnImageTouchListener(this.fLd);
        rVar.fFu.setOnEmotionClickListener(aVar.fUv);
        rVar.fFP.setOnClickListener(this.mCommonClickListener);
        rVar.bcz.setOnClickListener(this.mCommonClickListener);
        rVar.fLo.setOnClickListener(this);
        rVar.fLp.setOnClickListener(this);
        rVar.fLq.setOnClickListener(this);
        rVar.cVw.setSubClickListener(this.fLe);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fJw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fJw).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fEX = fVar;
    }

    public void sB(int i) {
        this.fEU = i;
    }

    public void jD(boolean z) {
        this.fEV = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFa = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJF = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjX = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fKj = cVar;
    }

    public void jV(boolean z) {
        this.fKZ = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).fLu != null) {
            ((r) this.viewholder).fLu.removeAllViews();
            ((r) this.viewholder).fLu.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).fLu.setVisibility(8);
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).fLu != null) {
                            ((r) q.this.viewholder).fLu.destroy();
                            ((r) q.this.viewholder).fLu = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).fLu != null) {
            ((r) this.viewholder).fLu.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).fLu != null) {
            ((r) this.viewholder).fLu.onPause();
        }
    }

    private boolean bbp() {
        return (this.fEX == null || this.fEX.aYG() == null || !this.fEX.aYG().zF() || this.fEX.aYG().zk() == null) ? false : true;
    }
}
