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
    private TbRichTextView.h bJN;
    private com.baidu.tieba.pb.a.c bJO;
    private View.OnLongClickListener bkf;
    private int cEd;
    protected int fFp;
    protected boolean fFq;
    protected com.baidu.tieba.pb.data.f fFs;
    private com.baidu.tieba.pb.pb.sub.d fFt;
    private View.OnClickListener fFv;
    private boolean fFw;
    private final boolean fFx;
    private TbRichTextView.c fKE;
    private final int fLt;
    private boolean fLu;
    private boolean fLv;
    private int fLw;
    private int fLx;
    private com.baidu.tieba.pb.a.c fLy;
    private OriginalThreadCardView.a fLz;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fLt = 3;
        this.fFp = 0;
        this.fFq = true;
        this.fLu = true;
        this.fFs = null;
        this.fFt = null;
        this.fFv = null;
        this.mCommonClickListener = null;
        this.bJN = null;
        this.bJO = null;
        this.bkf = null;
        this.fKE = null;
        this.fFw = false;
        this.fFx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fLv = false;
        this.fLw = 0;
        this.fLx = 0;
        this.cEd = 0;
        this.pageFromType = 0;
        this.fLy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.bJO != null) {
                    q.this.bJO.co(view);
                    q.this.bJO.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fLz = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.q.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && q.this.fFs != null) {
                    String threadId = q.this.fFs.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12602").aa("tid", threadId).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).s("obj_type", i));
                    }
                }
            }
        };
        this.fLx = com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds60);
        this.cEd = com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aZT() != null) {
            this.pageFromType = pbActivity.aZT().bcq();
        }
        this.fLw = com.baidu.adp.lib.util.l.ao(pbActivity) - com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds130);
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.t(rVar.fFF, d.C0108d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.t(rVar.ecN, d.C0108d.cp_bg_line_c);
                rVar.fFP.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.e(rVar.bcH, d.C0108d.cp_cont_f, 1);
                rVar.bcH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                rVar.cVR.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(rVar.fLI, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fLJ, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fLK, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fLL, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.t(rVar.fLM, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.t(rVar.fLN, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(rVar.fLQ, d.C0108d.cp_cont_d, 1);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.fJR.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.fFq, this.fFp);
        a(rVar);
        if (rVar.cVR != null) {
            rVar.cVR.cWu = this.pageFromType;
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
            postData2.zP();
            b(rVar, postData2, view, i);
        }
        if (!this.fFw && this.fFx && rVar != null && rVar.fFP.Rt() && (listView = ((PbActivity) this.fJR.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fFw = true;
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
        if (postData.bvJ() != 1) {
            if (TextUtils.isEmpty(postData.getBimg_url())) {
                rVar.fFP.setOnClickListener(this.mCommonClickListener);
                rVar.fFP.setTextViewOnClickListener(this.mCommonClickListener);
            } else {
                rVar.fFP.setOnClickListener(null);
                rVar.fFP.setTextViewOnClickListener(null);
            }
            rVar.fFF.setOnClickListener(this.mCommonClickListener);
        } else {
            rVar.fFF.setOnClickListener(null);
        }
        if (postData.bvJ() == 1) {
            rVar.fLQ.setVisibility(8);
            if (this.fFs != null) {
                StringBuilder sb = null;
                List<ay> aZf = this.fFs.aZf();
                if (com.baidu.tbadk.core.util.v.D(aZf) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (ay ayVar : aZf) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aMS) != null && tVar.isDeleted && ((tVar.aKZ && (tVar.type == 1 || tVar.type == 2)) || (this.fFs.aYL() != null && this.fFs.aYL().yT() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fFs.aYL().yT().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fJR.getString(d.j.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    rVar.fLQ.setVisibility(0);
                    rVar.fLQ.setText(String.format(this.fJR.getString(d.j.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            if (!this.fJR.baY()) {
                rVar.bcH.setVisibility(8);
                if (com.baidu.tbadk.core.util.v.E(this.fFs.aZf())) {
                    rVar.fLH.setVisibility(8);
                    rVar.fLQ.setVisibility(8);
                } else {
                    int D = com.baidu.tbadk.core.util.v.D(this.fFs.aZf());
                    if (D > 3) {
                        D = 3;
                    }
                    int i2 = this.fLw / D;
                    switch (D) {
                        case 1:
                            rVar.fLJ.setMaxWidth(i2);
                            rVar.fLJ.setText(this.fJR.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 0)).getForumName()}));
                            rVar.fLJ.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 0)).getForumName());
                            rVar.fLJ.setVisibility(0);
                            rVar.fLK.setVisibility(0);
                            rVar.fLL.setVisibility(0);
                            rVar.fLM.setVisibility(8);
                            rVar.fLN.setVisibility(8);
                            break;
                        case 2:
                            rVar.fLJ.setMaxWidth(i2);
                            rVar.fLJ.setText(this.fJR.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 0)).getForumName()}));
                            rVar.fLJ.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 0)).getForumName());
                            rVar.fLJ.setVisibility(0);
                            rVar.fLK.setMaxWidth(i2);
                            rVar.fLK.setText(this.fJR.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 1)).getForumName()}));
                            rVar.fLK.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 1)).getForumName());
                            rVar.fLK.setVisibility(0);
                            rVar.fLL.setVisibility(8);
                            rVar.fLM.setVisibility(0);
                            rVar.fLN.setVisibility(8);
                            break;
                        case 3:
                            rVar.fLJ.setMaxWidth(i2);
                            rVar.fLJ.setText(this.fJR.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 0)).getForumName()}));
                            rVar.fLJ.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 0)).getForumName());
                            rVar.fLJ.setVisibility(0);
                            rVar.fLK.setMaxWidth(i2);
                            rVar.fLK.setText(this.fJR.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 1)).getForumName()}));
                            rVar.fLK.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 1)).getForumName());
                            rVar.fLK.setVisibility(0);
                            rVar.fLL.setMaxWidth(i2);
                            rVar.fLL.setText(this.fJR.getString(d.j.chosen_pb_original_bar, new Object[]{((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 2)).getForumName()}));
                            rVar.fLL.setTag(((ay) com.baidu.tbadk.core.util.v.f(this.fFs.aZf(), 2)).getForumName());
                            rVar.fLL.setVisibility(0);
                            rVar.fLM.setVisibility(0);
                            rVar.fLN.setVisibility(0);
                            break;
                    }
                    rVar.fLH.setVisibility(0);
                }
            } else {
                rVar.fLH.setVisibility(8);
                rVar.fLQ.setVisibility(8);
                if (this.fFs.aYJ() != null && !StringUtils.isNull(this.fFs.aYJ().getName()) && !bbu()) {
                    rVar.bcH.setVisibility(0);
                    rVar.bcH.setText(this.fJR.getResources().getString(d.j.pb_original_bar_from, this.fFs.aYJ().getName()));
                } else {
                    rVar.bcH.setVisibility(8);
                }
            }
            a(rVar.fFP, view, this.fLv);
            rVar.fFG.setVisibility(8);
            rVar.fFS.setVisibility(0);
            String str = null;
            String str2 = null;
            long j = 0;
            if (postData.yT() != null) {
                j = postData.yT().getUserIdLong();
                str = postData.yT().getUserName();
                str2 = postData.yT().getName_show();
            }
            if (this.fFs != null && this.fFs.aYL() != null) {
                rVar.fFS.a(postData.bvS(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fFs.aYL().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
            }
            rVar.fFS.onChangeSkinType();
            if (this.fJR.bam().bej()) {
                rVar.fFP.setVisibility(8);
            }
            if (this.fFs != null && this.fFs.aYL() != null && this.fFs.aYL().zg() != null) {
                bn zg = this.fFs.aYL().zg();
                final String activityUrl = zg.getActivityUrl();
                String Av = zg.Av();
                if (!StringUtils.isNull(zg.Aw())) {
                    rVar.fLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.pa()) {
                                TiebaStatic.log("c10854");
                                com.baidu.tbadk.browser.a.Q(q.this.fJR.getActivity(), activityUrl);
                            }
                        }
                    });
                    if (!StringUtils.isNull(Av)) {
                        rVar.fLE.setVisibility(0);
                        rVar.fLE.startLoad(Av, 10, true);
                    }
                } else {
                    return;
                }
            } else {
                rVar.fLE.setVisibility(8);
            }
            if (rVar.fLG != null) {
                rVar.fLG.setVisibility(8);
            }
        }
        rVar.fFP.getLayoutStrategy().iN(d.f.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_clip_board, postData);
        sparseArray.put(d.g.tag_load_sub_data, postData);
        sparseArray.put(d.g.tag_load_sub_view, view);
        sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
        sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bvJ()));
        if (postData.bvO() > 0 && postData.bvG() != null && postData.bvG().size() > 0) {
            if (this.fFt == null) {
                this.fFt = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                this.fFt.setIsFromCDN(this.mIsFromCDN);
                this.fFt.H(this.fFv);
                if (this.fFs != null) {
                    this.fFt.J(this.fFs.aYX(), TextUtils.equals(this.fFs.aYL().yT().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.fFt.Q(this.fFs.aYL());
                }
            }
            this.fFt.qB(postData.getId());
        }
        rVar.fFP.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
        if (this.fFq) {
            rVar.fFP.getLayoutStrategy().iQ(d.f.transparent_bg);
        } else {
            rVar.fFP.getLayoutStrategy().iQ(d.f.icon_click);
        }
        rVar.fFP.setIsFromCDN(this.mIsFromCDN);
        if (this.fFs != null && this.fFs.aYL() != null && this.fFs.aYL().isLinkThread()) {
            a(rVar, this.fFs.aYL().Ai());
        }
        a(rVar, postData);
        TbRichText bvM = postData.bvM();
        if (this.fFs != null && this.fFs.aZi()) {
            bvM = null;
        }
        if (this.fFw || !this.fFx) {
            rVar.fFP.a(bvM, false, this.fKE);
        } else {
            rVar.fFP.a(bvM, true, this.fKE);
        }
        a(rVar, postData, bvM);
        boolean z7 = !StringUtils.isNull(postData.yT().getVirtualUserUrl());
        boolean z8 = false;
        boolean z9 = false;
        if (this.fFs != null && this.fFs.aYX() != 0) {
            z8 = true;
            z9 = true;
            if (postData.yT() != null) {
                String userId = postData.yT().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z8 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z8 = false;
                }
            }
        }
        if (this.fFs != null && this.fFs.aYL() != null && this.fFs.aYL().yT() != null && postData.yT() != null) {
            String userId2 = this.fFs.aYL().yT().getUserId();
            String userId3 = postData.yT().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                z2 = true;
                if (!UtilHelper.isCurrentAccount(userId3)) {
                    z = true;
                    z3 = false;
                } else {
                    z = false;
                    z3 = true;
                }
                if (postData.yT() == null && UtilHelper.isCurrentAccount(postData.yT().getUserId())) {
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
                if (postData.bvJ() == 1) {
                    i3 = 0;
                }
                sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                if (!z8) {
                    sparseArray.put(d.g.tag_should_manage_visible, true);
                    if (postData.yT() != null) {
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yT().getUserName());
                    }
                    if (this.fFs != null) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fFs.aYX()));
                    }
                } else {
                    sparseArray.put(d.g.tag_should_manage_visible, false);
                }
                if (!z) {
                    sparseArray.put(d.g.tag_user_mute_visible, true);
                    sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yT() != null) {
                        sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yT().getUserId());
                        sparseArray.put(d.g.tag_user_mute_mute_username, postData.yT().getUserName());
                    }
                    if (this.fFs != null && this.fFs.aYL() != null) {
                        sparseArray.put(d.g.tag_user_mute_thread_id, this.fFs.aYL().getId());
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
                    if (this.fFs != null) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fFs.aYX()));
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
        if (postData.yT() == null) {
        }
        boolean z102 = z3;
        z4 = z2;
        z5 = z102;
        if (z7) {
        }
        int i32 = 1;
        if (postData.bvJ() == 1) {
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
            rVar.fFP.setTag(sparseArray);
            rVar.fFF.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            rVar.fFP.setIsHost(true);
            if (this.fLu) {
                rVar.ecN.setVisibility(0);
            } else {
                rVar.ecN.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fFq) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.fFP.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.fFP.setLayoutParams(layoutParams);
                rVar.fFP.hr(null);
                this.fLv = false;
                a(rVar, postData, view, i);
                return;
            }
            this.fLv = true;
            rVar.fFP.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                public void Ry() {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.fFP.getLayoutParams();
                    layoutParams2.topMargin = q.this.getDimensionPixelSize(d.e.ds16);
                    int dimensionPixelSize = q.this.getDimensionPixelSize(d.e.ds34);
                    layoutParams2.bottomMargin = dimensionPixelSize;
                    layoutParams2.leftMargin = dimensionPixelSize;
                    layoutParams2.rightMargin = dimensionPixelSize;
                    rVar.fFP.setLayoutParams(layoutParams2);
                    q.this.a(rVar, postData, view, i);
                }
            });
        }
    }

    private void a(r rVar, PostData postData) {
        if (rVar != null && postData != null) {
            if (postData.bvZ() == null) {
                rVar.cVR.setVisibility(8);
                rVar.fFP.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            rVar.cVR.b(postData.bvZ());
            rVar.cVR.setVisibility(0);
            if (rVar.cVR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.cVR.getLayoutParams();
                if (rVar.bcH.getVisibility() != 0 && rVar.fLH.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.fLx;
                } else {
                    layoutParams.bottomMargin = this.cEd;
                }
                rVar.cVR.setLayoutParams(layoutParams);
            }
            rVar.fFP.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.am.isEmpty(adVar.getLinkUrl()) && !rVar.fLP.getIsLoaded() && adVar.xF() == com.baidu.tbadk.core.data.ad.aLK) {
            if (adVar.xG()) {
                rVar.fLO.setVisibility(8);
                rVar.fLP.setVisibility(8);
                return;
            }
            rVar.fFP.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds48));
            rVar.fLO.setVisibility(0);
            com.baidu.tbadk.core.util.aj.t(rVar.fLO, d.C0108d.cp_bg_line_c);
            rVar.fLP.setVisibility(0);
            rVar.fLP.setFocusable(false);
            rVar.fLP.setBackgroundColor(0);
            rVar.fLP.getSettings().setCacheMode(-1);
            rVar.fLP.setVerticalScrollBarEnabled(false);
            rVar.fLP.setHorizontalScrollBarEnabled(false);
            rVar.fLP.getSettings().setAllowFileAccess(true);
            rVar.fLP.getSettings().setAppCacheEnabled(true);
            rVar.fLP.getSettings().setDomStorageEnabled(true);
            rVar.fLP.getSettings().setDatabaseEnabled(true);
            rVar.fLP.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.fLP.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.fLP.loadUrl(adVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bfA() == null) {
            rVar.fGk.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.bfA(), rVar.fGk, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.fFP.setTextViewOnTouchListener(this.fLy);
        rVar.fFP.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ao - i, this.fFp);
            tbRichTextView.getLayoutStrategy().iO(min);
            tbRichTextView.getLayoutStrategy().iP((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.fFF.setOnTouchListener(this.bJO);
        rVar.fFF.setOnLongClickListener(this.bkf);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV;
        rVar.fFP.setOnLongClickListener(this.bkf);
        rVar.fFP.setOnTouchListener(this.fLy);
        rVar.fFP.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.fFP.setOnImageClickListener(this.bJN);
        rVar.fFP.setOnImageTouchListener(this.fLy);
        rVar.fFP.setOnEmotionClickListener(aVar.fUQ);
        rVar.fGk.setOnClickListener(this.mCommonClickListener);
        rVar.bcH.setOnClickListener(this.mCommonClickListener);
        rVar.fLJ.setOnClickListener(this);
        rVar.fLK.setOnClickListener(this);
        rVar.fLL.setOnClickListener(this);
        rVar.cVR.setSubClickListener(this.fLz);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fJR.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fJR).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fFs = fVar;
    }

    public void sB(int i) {
        this.fFp = i;
    }

    public void jF(boolean z) {
        this.fFq = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFv = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJO = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkf = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fKE = cVar;
    }

    public void jX(boolean z) {
        this.fLu = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).fLP != null) {
            ((r) this.viewholder).fLP.removeAllViews();
            ((r) this.viewholder).fLP.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).fLP.setVisibility(8);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).fLP != null) {
                            ((r) q.this.viewholder).fLP.destroy();
                            ((r) q.this.viewholder).fLP = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).fLP != null) {
            ((r) this.viewholder).fLP.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).fLP != null) {
            ((r) this.viewholder).fLP.onPause();
        }
    }

    private boolean bbu() {
        return (this.fFs == null || this.fFs.aYL() == null || !this.fFs.aYL().zG() || this.fFs.aYL().zl() == null) ? false : true;
    }
}
