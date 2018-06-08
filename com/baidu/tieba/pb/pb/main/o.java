package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.data.bm;
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
public class o extends k<PostData, p> implements View.OnClickListener {
    private View.OnLongClickListener aGs;
    private TbRichTextView.h beD;
    private com.baidu.tieba.pb.a.c beE;
    private int cgT;
    protected com.baidu.tieba.pb.data.d ftE;
    protected boolean ftF;
    protected int ftM;
    private View.OnClickListener ftN;
    private final int fuZ;
    private TbRichTextView.c fuf;
    private com.baidu.tieba.pb.pb.sub.c fug;
    private boolean fva;
    private boolean fvb;
    private final boolean fvc;
    private boolean fvd;
    private int fve;
    private int fvf;
    private com.baidu.tieba.pb.a.c fvg;
    private OriginalThreadCardView.a fvh;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fuZ = 3;
        this.ftM = 0;
        this.ftF = true;
        this.fva = true;
        this.ftE = null;
        this.fug = null;
        this.ftN = null;
        this.mCommonClickListener = null;
        this.beD = null;
        this.beE = null;
        this.aGs = null;
        this.fuf = null;
        this.fvb = false;
        this.fvc = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fvd = false;
        this.fve = 0;
        this.fvf = 0;
        this.cgT = 0;
        this.pageFromType = 0;
        this.fvg = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (o.this.beE != null) {
                    o.this.beE.aW(view);
                    o.this.beE.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fvh = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.ftE != null) {
                    String threadId = o.this.ftE.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").ah("tid", threadId).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).r("obj_type", i));
                    }
                }
            }
        };
        this.fvf = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds60);
        this.cgT = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.bbt() != null) {
            this.pageFromType = pbActivity.bbt().bdN();
        }
        this.fve = com.baidu.adp.lib.util.l.ah(pbActivity) - com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds130);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.j(pVar.fuo, d.C0141d.cp_bg_line_d);
                com.baidu.tbadk.core.util.al.j(pVar.dNV, d.C0141d.cp_bg_line_c);
                pVar.fvm.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_cont_b));
                pVar.czT.onChangeSkinType();
                com.baidu.tbadk.core.util.al.c(pVar.fvt, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.c(pVar.fvu, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.c(pVar.fvv, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.c(pVar.fvw, d.C0141d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.j(pVar.fvx, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.al.j(pVar.fvy, d.C0141d.cp_cont_e);
                com.baidu.tbadk.core.util.al.c(pVar.fvB, d.C0141d.cp_cont_d, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.ftp.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_first_floor_item, viewGroup, false), this.ftF, this.ftM);
        a(pVar);
        if (pVar.czT != null) {
            pVar.czT.cAF = this.pageFromType;
        }
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, p pVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, pVar);
        a(pVar);
        c(pVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.wg();
            b(pVar, postData2, view, i);
        }
        if (!this.fvb && this.fvc && pVar != null && pVar.fvm.NU() && (listView = ((PbActivity) this.ftp.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fvb = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:145:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x07c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(p pVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        com.baidu.tbadk.core.data.u uVar;
        if (this.ftE != null) {
            if (postData.bwZ() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fvm.setOnClickListener(this.mCommonClickListener);
                    pVar.fvm.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fvm.setOnClickListener(null);
                    pVar.fvm.setTextViewOnClickListener(null);
                }
                pVar.fuo.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fuo.setOnClickListener(null);
            }
            if (postData.bwZ() == 1) {
                pVar.fvB.setVisibility(8);
                StringBuilder sb = null;
                List<az> baI = this.ftE.baI();
                if (com.baidu.tbadk.core.util.w.y(baI) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (az azVar : baI) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ahC) != null && uVar.isDeleted && ((uVar.afG && (uVar.type == 1 || uVar.type == 2)) || (this.ftE.bao() != null && this.ftE.bao().vm() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.ftE.bao().vm().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.ftp.getString(d.k.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    pVar.fvB.setVisibility(0);
                    pVar.fvB.setText(String.format(this.ftp.getString(d.k.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
                if (!this.ftp.bcu()) {
                    if (com.baidu.tbadk.core.util.w.z(this.ftE.baI())) {
                        pVar.fvs.setVisibility(8);
                        pVar.fvB.setVisibility(8);
                    } else {
                        int y = com.baidu.tbadk.core.util.w.y(this.ftE.baI());
                        if (y > 3) {
                            y = 3;
                        }
                        int i2 = this.fve / y;
                        switch (y) {
                            case 1:
                                pVar.fvu.setMaxWidth(i2);
                                pVar.fvu.setText(this.ftp.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 0)).getForumName()}));
                                pVar.fvu.setTag(((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 0)).getForumName());
                                pVar.fvu.setVisibility(0);
                                pVar.fvv.setVisibility(0);
                                pVar.fvw.setVisibility(0);
                                pVar.fvx.setVisibility(8);
                                pVar.fvy.setVisibility(8);
                                break;
                            case 2:
                                pVar.fvu.setMaxWidth(i2);
                                pVar.fvu.setText(this.ftp.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 0)).getForumName()}));
                                pVar.fvu.setTag(((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 0)).getForumName());
                                pVar.fvu.setVisibility(0);
                                pVar.fvv.setMaxWidth(i2);
                                pVar.fvv.setText(this.ftp.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 1)).getForumName()}));
                                pVar.fvv.setTag(((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 1)).getForumName());
                                pVar.fvv.setVisibility(0);
                                pVar.fvw.setVisibility(8);
                                pVar.fvx.setVisibility(0);
                                pVar.fvy.setVisibility(8);
                                break;
                            case 3:
                                pVar.fvu.setMaxWidth(i2);
                                pVar.fvu.setText(this.ftp.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 0)).getForumName()}));
                                pVar.fvu.setTag(((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 0)).getForumName());
                                pVar.fvu.setVisibility(0);
                                pVar.fvv.setMaxWidth(i2);
                                pVar.fvv.setText(this.ftp.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 1)).getForumName()}));
                                pVar.fvv.setTag(((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 1)).getForumName());
                                pVar.fvv.setVisibility(0);
                                pVar.fvw.setMaxWidth(i2);
                                pVar.fvw.setText(this.ftp.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 2)).getForumName()}));
                                pVar.fvw.setTag(((az) com.baidu.tbadk.core.util.w.c(this.ftE.baI(), 2)).getForumName());
                                pVar.fvw.setVisibility(0);
                                pVar.fvx.setVisibility(0);
                                pVar.fvy.setVisibility(0);
                                break;
                        }
                        pVar.fvs.setVisibility(0);
                    }
                } else {
                    pVar.fvs.setVisibility(8);
                    pVar.fvB.setVisibility(8);
                    if (this.ftE.bam() == null || StringUtils.isNull(this.ftE.bam().getName()) || !bcS()) {
                    }
                }
                a(pVar.fvm, view, this.fvd);
                pVar.fvl.setVisibility(8);
                pVar.fvn.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vm() != null) {
                    j = postData.vm().getUserIdLong();
                    str = postData.vm().getUserName();
                    str2 = postData.vm().getName_show();
                }
                if (this.ftE != null && this.ftE.bao() != null) {
                    pVar.fvn.a(postData.bxh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.ftE.bao().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.fvn.onChangeSkinType();
                if (this.ftp.bbK().bfF()) {
                    pVar.fvm.setVisibility(8);
                }
                if (this.ftE != null && this.ftE.bao() != null && this.ftE.bao().vy() != null) {
                    bm vy = this.ftE.bao().vy();
                    final String activityUrl = vy.getActivityUrl();
                    String wU = vy.wU();
                    if (!StringUtils.isNull(vy.wV())) {
                        pVar.fvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.jU()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.Q(o.this.ftp.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(wU)) {
                            pVar.fvp.setVisibility(0);
                            pVar.fvp.startLoad(wU, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fvp.setVisibility(8);
                }
                if (pVar.fvr != null) {
                    pVar.fvr.setVisibility(8);
                }
            }
            pVar.fvm.getLayoutStrategy().fM(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwZ()));
            if (postData.bxd() > 0 && postData.bwW() != null && postData.bwW().size() > 0) {
                if (this.fug == null) {
                    this.fug = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fug.setIsFromCDN(this.mIsFromCDN);
                    this.fug.I(this.ftN);
                    if (this.ftE != null) {
                        this.fug.B(this.ftE.baA(), TextUtils.equals(this.ftE.bao().vm().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fug.T(this.ftE.bao());
                    }
                }
                this.fug.rJ(postData.getId());
            }
            pVar.fvm.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_link_tip_c));
            if (this.ftF) {
                pVar.fvm.getLayoutStrategy().fP(d.f.transparent_bg);
            } else {
                pVar.fvm.getLayoutStrategy().fP(d.f.icon_click);
            }
            pVar.fvm.setIsFromCDN(this.mIsFromCDN);
            if (this.ftE != null && this.ftE.bao() != null && this.ftE.bao().isLinkThread()) {
                a(pVar, this.ftE.bao().wz());
            }
            a(pVar, postData);
            TbRichText bxb = postData.bxb();
            if (this.ftE != null && this.ftE.baL()) {
                bxb = null;
            }
            if (this.fvb || !this.fvc) {
                pVar.fvm.setText(bxb, false, this.fuf);
            } else {
                pVar.fvm.setText(bxb, true, this.fuf);
            }
            a(pVar, postData, bxb);
            boolean z7 = !StringUtils.isNull(postData.vm().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.ftE != null && this.ftE.baA() != 0) {
                z8 = true;
                z9 = true;
                if (postData.vm() != null) {
                    String userId = postData.vm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.ftE != null && this.ftE.bao() != null && this.ftE.bao().vm() != null && postData.vm() != null) {
                String userId2 = this.ftE.bao().vm().getUserId();
                String userId3 = postData.vm().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.vm() == null && UtilHelper.isCurrentAccount(postData.vm().getUserId())) {
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
                    if (postData.bwZ() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.vm() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vm().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vm().getName_show());
                        }
                        if (this.ftE != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ftE.baA()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vm() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vm().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vm().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vm().getName_show());
                        }
                        if (this.ftE != null && this.ftE.bao() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.ftE.bao().getId());
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
                        if (this.ftE != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.ftE.baA()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    b(pVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.vm() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.bwZ() == 1) {
            }
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(pVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(final p pVar, final PostData postData, final View view, final int i) {
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.fvm.setTag(sparseArray);
            pVar.fuo.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fvm.setIsHost(true);
            if (this.fva) {
                pVar.dNV.setVisibility(0);
            } else {
                pVar.dNV.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ftF) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fvm.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fvm.setLayoutParams(layoutParams);
                pVar.fvm.hT(null);
                this.fvd = false;
                a(pVar, postData, view, i);
            } else {
                this.fvd = true;
                pVar.fvm.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void NZ() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fvm.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fvm.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fvC.setData(this.ftE.baO());
            pVar.fvC.setPageContext(this.ftp.getPageContext());
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bxm() == null) {
                pVar.czT.setVisibility(8);
                pVar.fvm.getLayoutStrategy().fT(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            pVar.czT.b(postData.bxm());
            pVar.czT.setVisibility(0);
            if (pVar.czT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.czT.getLayoutParams();
                layoutParams.bottomMargin = this.cgT;
                pVar.czT.setLayoutParams(layoutParams);
            }
            pVar.fvm.getLayoutStrategy().fT(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ae aeVar) {
        if (aeVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(aeVar.getLinkUrl()) && !pVar.fvA.getIsLoaded() && aeVar.um() == com.baidu.tbadk.core.data.ae.agw) {
            if (aeVar.un()) {
                pVar.fvz.setVisibility(8);
                pVar.fvA.setVisibility(8);
                return;
            }
            pVar.fvm.getLayoutStrategy().fT(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds48));
            pVar.fvz.setVisibility(0);
            com.baidu.tbadk.core.util.al.j(pVar.fvz, d.C0141d.cp_bg_line_c);
            pVar.fvA.setVisibility(0);
            pVar.fvA.setFocusable(false);
            pVar.fvA.setBackgroundColor(0);
            pVar.fvA.getSettings().setCacheMode(-1);
            pVar.fvA.setVerticalScrollBarEnabled(false);
            pVar.fvA.setHorizontalScrollBarEnabled(false);
            pVar.fvA.getSettings().setAllowFileAccess(true);
            pVar.fvA.getSettings().setAppCacheEnabled(true);
            pVar.fvA.getSettings().setDomStorageEnabled(true);
            pVar.fvA.getSettings().setDatabaseEnabled(true);
            pVar.fvA.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.fvA.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.fvA.loadUrl(aeVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bgZ() == null) {
            pVar.fuG.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(postData.bgZ(), pVar.fuG, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fvm.setTextViewOnTouchListener(this.fvg);
        pVar.fvm.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ah - i, this.ftM);
            tbRichTextView.getLayoutStrategy().fN(min);
            tbRichTextView.getLayoutStrategy().fO((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fuo.setOnTouchListener(this.beE);
        pVar.fuo.setOnLongClickListener(this.aGs);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.ftp.getPageContext().getOrignalPage()).frr;
        pVar.fvm.setOnLongClickListener(this.aGs);
        pVar.fvm.setOnTouchListener(this.fvg);
        pVar.fvm.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fvm.setOnImageClickListener(this.beD);
        pVar.fvm.setOnImageTouchListener(this.fvg);
        pVar.fvm.setOnEmotionClickListener(aVar.fEI);
        pVar.fuG.setOnClickListener(this.mCommonClickListener);
        pVar.fvu.setOnClickListener(this);
        pVar.fvv.setOnClickListener(this);
        pVar.fvw.setOnClickListener(this);
        pVar.czT.setSubClickListener(this.fvh);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.ftp.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ftp).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.ftE = dVar;
    }

    public void ql(int i) {
        this.ftM = i;
    }

    public void jx(boolean z) {
        this.ftF = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.ftN = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.beD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.beE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aGs = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fuf = cVar;
    }

    public void jP(boolean z) {
        this.fva = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).fvA != null) {
            ((p) this.viewholder).fvA.removeAllViews();
            ((p) this.viewholder).fvA.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).fvA.setVisibility(8);
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).fvA != null) {
                            ((p) o.this.viewholder).fvA.destroy();
                            ((p) o.this.viewholder).fvA = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).fvA != null) {
            ((p) this.viewholder).fvA.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).fvA != null) {
            ((p) this.viewholder).fvA.onPause();
        }
    }

    private boolean bcS() {
        return (this.ftE == null || this.ftE.bao() == null || !this.ftE.bao().vX() || this.ftE.bao().vD() == null) ? false : true;
    }
}
