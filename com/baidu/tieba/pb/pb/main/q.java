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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bo;
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
    private TbRichTextView.h bJx;
    private com.baidu.tieba.pb.a.c bJy;
    private View.OnLongClickListener bjN;
    private int cDG;
    private View.OnClickListener fDA;
    private boolean fDB;
    private final boolean fDC;
    protected int fDu;
    protected boolean fDv;
    protected com.baidu.tieba.pb.data.f fDx;
    private com.baidu.tieba.pb.pb.sub.d fDy;
    private TbRichTextView.c fIJ;
    private boolean fJA;
    private int fJB;
    private int fJC;
    private com.baidu.tieba.pb.a.c fJD;
    private OriginalThreadCardView.a fJE;
    private final int fJy;
    private boolean fJz;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fJy = 3;
        this.fDu = 0;
        this.fDv = true;
        this.fJz = true;
        this.fDx = null;
        this.fDy = null;
        this.fDA = null;
        this.mCommonClickListener = null;
        this.bJx = null;
        this.bJy = null;
        this.bjN = null;
        this.fIJ = null;
        this.fDB = false;
        this.fDC = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fJA = false;
        this.fJB = 0;
        this.fJC = 0;
        this.cDG = 0;
        this.pageFromType = 0;
        this.fJD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.bJy != null) {
                    q.this.bJy.cm(view);
                    q.this.bJy.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fJE = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.q.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && q.this.fDx != null) {
                    String threadId = q.this.fDx.getThreadId();
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
        this.fJC = com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds60);
        this.cDG = com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aZK() != null) {
            this.pageFromType = pbActivity.aZK().bch();
        }
        this.fJB = com.baidu.adp.lib.util.l.ao(pbActivity) - com.baidu.adp.lib.util.l.s(pbActivity, d.e.ds130);
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.t(rVar.fDK, d.C0108d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.t(rVar.ebi, d.C0108d.cp_bg_line_c);
                rVar.fDU.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.e(rVar.djB, d.C0108d.cp_cont_f, 1);
                rVar.djB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_pb_jump), (Drawable) null);
                rVar.cQU.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(rVar.fJN, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fJO, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fJP, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.e(rVar.fJQ, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.t(rVar.fJR, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.t(rVar.fJS, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(rVar.fJV, d.C0108d.cp_cont_d, 1);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.fHW.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.fDv, this.fDu);
        a(rVar);
        if (rVar.cQU != null) {
            rVar.cQU.cRx = this.pageFromType;
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
            postData2.zW();
            b(rVar, postData2, view, i);
        }
        if (!this.fDB && this.fDC && rVar != null && rVar.fDU.RD() && (listView = ((PbActivity) this.fHW.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fDB = true;
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
        if (postData.bCl() != 1) {
            if (TextUtils.isEmpty(postData.getBimg_url())) {
                rVar.fDU.setOnClickListener(this.mCommonClickListener);
                rVar.fDU.setTextViewOnClickListener(this.mCommonClickListener);
            } else {
                rVar.fDU.setOnClickListener(null);
                rVar.fDU.setTextViewOnClickListener(null);
            }
            rVar.fDK.setOnClickListener(this.mCommonClickListener);
        } else {
            rVar.fDK.setOnClickListener(null);
        }
        if (postData.bCl() == 1) {
            rVar.fJV.setVisibility(8);
            if (this.fDx != null) {
                StringBuilder sb = null;
                List<az> aYW = this.fDx.aYW();
                if (com.baidu.tbadk.core.util.v.F(aYW) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (az azVar : aYW) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (tVar = azVar.aMT) != null && tVar.isDeleted && ((tVar.aKY && (tVar.type == 1 || tVar.type == 2)) || (this.fDx.aYA() != null && this.fDx.aYA().yX() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fDx.aYA().yX().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.k(azVar.getForumName(), 12)).append(this.fHW.getString(d.j.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    rVar.fJV.setVisibility(0);
                    rVar.fJV.setText(String.format(this.fHW.getString(d.j.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            if (!this.fHW.baP()) {
                rVar.djB.setVisibility(8);
                if (com.baidu.tbadk.core.util.v.G(this.fDx.aYW())) {
                    rVar.fJM.setVisibility(8);
                    rVar.fJV.setVisibility(8);
                } else {
                    int F = com.baidu.tbadk.core.util.v.F(this.fDx.aYW());
                    if (F > 3) {
                        F = 3;
                    }
                    int i2 = this.fJB / F;
                    switch (F) {
                        case 1:
                            rVar.fJO.setMaxWidth(i2);
                            rVar.fJO.setText(this.fHW.getString(d.j.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 0)).getForumName()}));
                            rVar.fJO.setTag(((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 0)).getForumName());
                            rVar.fJO.setVisibility(0);
                            rVar.fJP.setVisibility(0);
                            rVar.fJQ.setVisibility(0);
                            rVar.fJR.setVisibility(8);
                            rVar.fJS.setVisibility(8);
                            break;
                        case 2:
                            rVar.fJO.setMaxWidth(i2);
                            rVar.fJO.setText(this.fHW.getString(d.j.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 0)).getForumName()}));
                            rVar.fJO.setTag(((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 0)).getForumName());
                            rVar.fJO.setVisibility(0);
                            rVar.fJP.setMaxWidth(i2);
                            rVar.fJP.setText(this.fHW.getString(d.j.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 1)).getForumName()}));
                            rVar.fJP.setTag(((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 1)).getForumName());
                            rVar.fJP.setVisibility(0);
                            rVar.fJQ.setVisibility(8);
                            rVar.fJR.setVisibility(0);
                            rVar.fJS.setVisibility(8);
                            break;
                        case 3:
                            rVar.fJO.setMaxWidth(i2);
                            rVar.fJO.setText(this.fHW.getString(d.j.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 0)).getForumName()}));
                            rVar.fJO.setTag(((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 0)).getForumName());
                            rVar.fJO.setVisibility(0);
                            rVar.fJP.setMaxWidth(i2);
                            rVar.fJP.setText(this.fHW.getString(d.j.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 1)).getForumName()}));
                            rVar.fJP.setTag(((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 1)).getForumName());
                            rVar.fJP.setVisibility(0);
                            rVar.fJQ.setMaxWidth(i2);
                            rVar.fJQ.setText(this.fHW.getString(d.j.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 2)).getForumName()}));
                            rVar.fJQ.setTag(((az) com.baidu.tbadk.core.util.v.f(this.fDx.aYW(), 2)).getForumName());
                            rVar.fJQ.setVisibility(0);
                            rVar.fJR.setVisibility(0);
                            rVar.fJS.setVisibility(0);
                            break;
                    }
                    rVar.fJM.setVisibility(0);
                }
            } else {
                rVar.fJM.setVisibility(8);
                rVar.fJV.setVisibility(8);
                if (this.fDx.aYy() != null && !StringUtils.isNull(this.fDx.aYy().getName()) && !bbl()) {
                    rVar.djB.setVisibility(0);
                    rVar.djB.setText(this.fHW.getResources().getString(d.j.pb_original_bar_from, this.fDx.aYy().getName()));
                } else {
                    rVar.djB.setVisibility(8);
                }
            }
            a(rVar.fDU, view, this.fJA);
            rVar.fDL.setVisibility(8);
            rVar.fDX.setVisibility(0);
            String str = null;
            String str2 = null;
            long j = 0;
            if (postData.yX() != null) {
                j = postData.yX().getUserIdLong();
                str = postData.yX().getUserName();
                str2 = postData.yX().getName_show();
            }
            if (this.fDx != null && this.fDx.aYA() != null) {
                rVar.fDX.a(postData.bCu(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fDx.aYA().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
            }
            rVar.fDX.onChangeSkinType();
            if (this.fHW.bad().bea()) {
                rVar.fDU.setVisibility(8);
            }
            if (this.fDx != null && this.fDx.aYA() != null && this.fDx.aYA().zk() != null) {
                bo zk = this.fDx.aYA().zk();
                final String activityUrl = zk.getActivityUrl();
                String AC = zk.AC();
                if (!StringUtils.isNull(zk.AD())) {
                    rVar.fJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.oZ()) {
                                TiebaStatic.log("c10854");
                                com.baidu.tbadk.browser.a.S(q.this.fHW.getActivity(), activityUrl);
                            }
                        }
                    });
                    if (!StringUtils.isNull(AC)) {
                        rVar.fJJ.setVisibility(0);
                        rVar.fJJ.startLoad(AC, 10, true);
                    }
                } else {
                    return;
                }
            } else {
                rVar.fJJ.setVisibility(8);
            }
            if (rVar.fJL != null) {
                rVar.fJL.setVisibility(8);
            }
        }
        rVar.fDU.getLayoutStrategy().iR(d.f.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_clip_board, postData);
        sparseArray.put(d.g.tag_load_sub_data, postData);
        sparseArray.put(d.g.tag_load_sub_view, view);
        sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
        sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bCl()));
        if (postData.bCq() > 0 && postData.bCi() != null && postData.bCi().size() > 0) {
            if (this.fDy == null) {
                this.fDy = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                this.fDy.setIsFromCDN(this.mIsFromCDN);
                this.fDy.G(this.fDA);
                if (this.fDx != null) {
                    this.fDy.J(this.fDx.aYN(), TextUtils.equals(this.fDx.aYA().yX().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.fDy.Q(this.fDx.aYA());
                }
            }
            this.fDy.qs(postData.getId());
        }
        rVar.fDU.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
        if (this.fDv) {
            rVar.fDU.getLayoutStrategy().iU(d.f.transparent_bg);
        } else {
            rVar.fDU.getLayoutStrategy().iU(d.f.icon_click);
        }
        rVar.fDU.setIsFromCDN(this.mIsFromCDN);
        if (this.fDx != null && this.fDx.aYA() != null && this.fDx.aYA().isLinkThread()) {
            a(rVar, this.fDx.aYA().Ap());
        }
        a(rVar, postData);
        TbRichText bCo = postData.bCo();
        if (this.fDx != null && this.fDx.aYZ()) {
            bCo = null;
        }
        if (this.fDB || !this.fDC) {
            rVar.fDU.a(bCo, false, this.fIJ);
        } else {
            rVar.fDU.a(bCo, true, this.fIJ);
        }
        a(rVar, postData, bCo);
        boolean z7 = !StringUtils.isNull(postData.yX().getVirtualUserUrl());
        boolean z8 = false;
        boolean z9 = false;
        if (this.fDx != null && this.fDx.aYN() != 0) {
            z8 = true;
            z9 = true;
            if (postData.yX() != null) {
                String userId = postData.yX().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z8 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z8 = false;
                }
            }
        }
        if (this.fDx != null && this.fDx.aYA() != null && this.fDx.aYA().yX() != null && postData.yX() != null) {
            String userId2 = this.fDx.aYA().yX().getUserId();
            String userId3 = postData.yX().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                z2 = true;
                if (!UtilHelper.isCurrentAccount(userId3)) {
                    z = true;
                    z3 = false;
                } else {
                    z = false;
                    z3 = true;
                }
                if (postData.yX() == null && UtilHelper.isCurrentAccount(postData.yX().getUserId())) {
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
                if (postData.bCl() == 1) {
                    i3 = 0;
                }
                sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                if (!z8) {
                    sparseArray.put(d.g.tag_should_manage_visible, true);
                    if (postData.yX() != null) {
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yX().getUserName());
                    }
                    if (this.fDx != null) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fDx.aYN()));
                    }
                } else {
                    sparseArray.put(d.g.tag_should_manage_visible, false);
                }
                if (!z) {
                    sparseArray.put(d.g.tag_user_mute_visible, true);
                    sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yX() != null) {
                        sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yX().getUserId());
                        sparseArray.put(d.g.tag_user_mute_mute_username, postData.yX().getUserName());
                    }
                    if (this.fDx != null && this.fDx.aYA() != null) {
                        sparseArray.put(d.g.tag_user_mute_thread_id, this.fDx.aYA().getId());
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
                    if (this.fDx != null) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fDx.aYN()));
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
        if (postData.yX() == null) {
        }
        boolean z102 = z3;
        z4 = z2;
        z5 = z102;
        if (z7) {
        }
        int i32 = 1;
        if (postData.bCl() == 1) {
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
            rVar.fDU.setTag(sparseArray);
            rVar.fDK.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            rVar.fDU.setIsHost(true);
            if (this.fJz) {
                rVar.ebi.setVisibility(0);
            } else {
                rVar.ebi.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fDv) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.fDU.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.fDU.setLayoutParams(layoutParams);
                rVar.fDU.hj(null);
                this.fJA = false;
                a(rVar, postData, view, i);
                return;
            }
            this.fJA = true;
            rVar.fDU.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                public void RI() {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.fDU.getLayoutParams();
                    layoutParams2.topMargin = q.this.getDimensionPixelSize(d.e.ds16);
                    int dimensionPixelSize = q.this.getDimensionPixelSize(d.e.ds34);
                    layoutParams2.bottomMargin = dimensionPixelSize;
                    layoutParams2.leftMargin = dimensionPixelSize;
                    layoutParams2.rightMargin = dimensionPixelSize;
                    rVar.fDU.setLayoutParams(layoutParams2);
                    q.this.a(rVar, postData, view, i);
                }
            });
        }
    }

    private void a(r rVar, PostData postData) {
        if (rVar != null && postData != null) {
            if (postData.bCB() == null) {
                rVar.cQU.setVisibility(8);
                rVar.fDU.getLayoutStrategy().iY(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            rVar.cQU.b(postData.bCB());
            rVar.cQU.setVisibility(0);
            if (rVar.cQU.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.cQU.getLayoutParams();
                if (rVar.djB.getVisibility() != 0 && rVar.fJM.getVisibility() != 0) {
                    layoutParams.bottomMargin = this.fJC;
                } else {
                    layoutParams.bottomMargin = this.cDG;
                }
                rVar.cQU.setLayoutParams(layoutParams);
            }
            rVar.fDU.getLayoutStrategy().iY(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ae aeVar) {
        if (aeVar != null && !com.baidu.tbadk.core.util.am.isEmpty(aeVar.getLinkUrl()) && !rVar.fJU.getIsLoaded() && aeVar.xH() == com.baidu.tbadk.core.data.ae.aLL) {
            if (aeVar.xI()) {
                rVar.fJT.setVisibility(8);
                rVar.fJU.setVisibility(8);
                return;
            }
            rVar.fDU.getLayoutStrategy().iY(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds48));
            rVar.fJT.setVisibility(0);
            com.baidu.tbadk.core.util.aj.t(rVar.fJT, d.C0108d.cp_bg_line_c);
            rVar.fJU.setVisibility(0);
            rVar.fJU.setFocusable(false);
            rVar.fJU.setBackgroundColor(0);
            rVar.fJU.getSettings().setCacheMode(-1);
            rVar.fJU.setVerticalScrollBarEnabled(false);
            rVar.fJU.setHorizontalScrollBarEnabled(false);
            rVar.fJU.getSettings().setAllowFileAccess(true);
            rVar.fJU.getSettings().setAppCacheEnabled(true);
            rVar.fJU.getSettings().setDomStorageEnabled(true);
            rVar.fJU.getSettings().setDatabaseEnabled(true);
            rVar.fJU.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.fJU.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.fJU.loadUrl(aeVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bfu() == null) {
            rVar.fEp.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.bfu(), rVar.fEp, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.fDU.setTextViewOnTouchListener(this.fJD);
        rVar.fDU.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ao - i, this.fDu);
            tbRichTextView.getLayoutStrategy().iS(min);
            tbRichTextView.getLayoutStrategy().iT((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.fDK.setOnTouchListener(this.bJy);
        rVar.fDK.setOnLongClickListener(this.bjN);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa;
        rVar.fDU.setOnLongClickListener(this.bjN);
        rVar.fDU.setOnTouchListener(this.fJD);
        rVar.fDU.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.fDU.setOnImageClickListener(this.bJx);
        rVar.fDU.setOnImageTouchListener(this.fJD);
        rVar.fDU.setOnEmotionClickListener(aVar.fSV);
        rVar.fEp.setOnClickListener(this.mCommonClickListener);
        rVar.djB.setOnClickListener(this.mCommonClickListener);
        rVar.fJO.setOnClickListener(this);
        rVar.fJP.setOnClickListener(this);
        rVar.fJQ.setOnClickListener(this);
        rVar.cQU.setSubClickListener(this.fJE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fHW.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fHW).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fDx = fVar;
    }

    public void sI(int i) {
        this.fDu = i;
    }

    public void jA(boolean z) {
        this.fDv = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.fDA = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJx = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJy = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjN = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fIJ = cVar;
    }

    public void jS(boolean z) {
        this.fJz = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).fJU != null) {
            ((r) this.viewholder).fJU.removeAllViews();
            ((r) this.viewholder).fJU.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).fJU.setVisibility(8);
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).fJU != null) {
                            ((r) q.this.viewholder).fJU.destroy();
                            ((r) q.this.viewholder).fJU = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).fJU != null) {
            ((r) this.viewholder).fJU.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).fJU != null) {
            ((r) this.viewholder).fJU.onPause();
        }
    }

    private boolean bbl() {
        return (this.fDx == null || this.fDx.aYA() == null || !this.fDx.aYA().zK() || this.fDx.aYA().zp() == null) ? false : true;
    }
}
