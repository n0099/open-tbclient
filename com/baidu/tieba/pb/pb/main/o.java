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
    private TbRichTextView.h aWx;
    private com.baidu.tieba.pb.a.c aWy;
    private View.OnLongClickListener axX;
    private int bYQ;
    private TbRichTextView.c fiK;
    private com.baidu.tieba.pb.pb.sub.c fiL;
    protected com.baidu.tieba.pb.data.d fig;
    protected boolean fih;
    protected int fio;
    private View.OnClickListener fip;
    private final int fjE;
    private boolean fjF;
    private boolean fjG;
    private final boolean fjH;
    private boolean fjI;
    private int fjJ;
    private int fjK;
    private com.baidu.tieba.pb.a.c fjL;
    private OriginalThreadCardView.a fjM;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fjE = 3;
        this.fio = 0;
        this.fih = true;
        this.fjF = true;
        this.fig = null;
        this.fiL = null;
        this.fip = null;
        this.mCommonClickListener = null;
        this.aWx = null;
        this.aWy = null;
        this.axX = null;
        this.fiK = null;
        this.fjG = false;
        this.fjH = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fjI = false;
        this.fjJ = 0;
        this.fjK = 0;
        this.bYQ = 0;
        this.pageFromType = 0;
        this.fjL = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view2, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view2, MotionEvent motionEvent) {
                if (o.this.aWy != null) {
                    o.this.aWy.aT(view2);
                    o.this.aWy.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fjM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fig != null) {
                    String threadId = o.this.fig.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12602").ac("tid", threadId).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).r("obj_type", i));
                    }
                }
            }
        };
        this.fjK = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds60);
        this.bYQ = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aWx() != null) {
            this.pageFromType = pbActivity.aWx().aYP();
        }
        this.fjJ = com.baidu.adp.lib.util.l.af(pbActivity) - com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds130);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ak.j(pVar.fiT, d.C0126d.cp_bg_line_d);
                com.baidu.tbadk.core.util.ak.j(pVar.dCN, d.C0126d.cp_bg_line_c);
                pVar.fjR.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_b));
                pVar.crr.onChangeSkinType();
                com.baidu.tbadk.core.util.ak.c(pVar.fjY, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fjZ, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fka, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fkb, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.j(pVar.fkc, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.j(pVar.fkd, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.c(pVar.fkg, d.C0126d.cp_cont_d, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fhQ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_first_floor_item, viewGroup, false), this.fih, this.fio);
        a(pVar);
        if (pVar.crr != null) {
            pVar.crr.csc = this.pageFromType;
        }
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, p pVar) {
        BdListView xi;
        super.onFillViewHolder(i, view2, viewGroup, postData, pVar);
        a(pVar);
        c(pVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sJ();
            b(pVar, postData2, view2, i);
        }
        if (!this.fjG && this.fjH && pVar != null && pVar.fjR.Kv() && (xi = ((PbActivity) this.fhQ.getPageContext().getOrignalPage()).xi()) != null) {
            this.fjG = true;
            CompatibleUtile.getInstance().closeViewGpu(xi);
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:145:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x079f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x07ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(p pVar, PostData postData, View view2, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        com.baidu.tbadk.core.data.u uVar;
        if (this.fig != null) {
            if (postData.brX() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fjR.setOnClickListener(this.mCommonClickListener);
                    pVar.fjR.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fjR.setOnClickListener(null);
                    pVar.fjR.setTextViewOnClickListener(null);
                }
                pVar.fiT.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fiT.setOnClickListener(null);
            }
            if (postData.brX() == 1) {
                pVar.fkg.setVisibility(8);
                StringBuilder sb = null;
                List<az> aVM = this.fig.aVM();
                if (com.baidu.tbadk.core.util.v.v(aVM) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (az azVar : aVM) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ZA) != null && uVar.isDeleted && ((uVar.XF && (uVar.type == 1 || uVar.type == 2)) || (this.fig.aVs() != null && this.fig.aVs().rP() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fig.aVs().rP().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.fhQ.getString(d.k.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    pVar.fkg.setVisibility(0);
                    pVar.fkg.setText(String.format(this.fhQ.getString(d.k.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
                if (!this.fhQ.aXy()) {
                    if (com.baidu.tbadk.core.util.v.w(this.fig.aVM())) {
                        pVar.fjX.setVisibility(8);
                        pVar.fkg.setVisibility(8);
                    } else {
                        int v = com.baidu.tbadk.core.util.v.v(this.fig.aVM());
                        if (v > 3) {
                            v = 3;
                        }
                        int i2 = this.fjJ / v;
                        switch (v) {
                            case 1:
                                pVar.fjZ.setMaxWidth(i2);
                                pVar.fjZ.setText(this.fhQ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 0)).getForumName()}));
                                pVar.fjZ.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 0)).getForumName());
                                pVar.fjZ.setVisibility(0);
                                pVar.fka.setVisibility(0);
                                pVar.fkb.setVisibility(0);
                                pVar.fkc.setVisibility(8);
                                pVar.fkd.setVisibility(8);
                                break;
                            case 2:
                                pVar.fjZ.setMaxWidth(i2);
                                pVar.fjZ.setText(this.fhQ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 0)).getForumName()}));
                                pVar.fjZ.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 0)).getForumName());
                                pVar.fjZ.setVisibility(0);
                                pVar.fka.setMaxWidth(i2);
                                pVar.fka.setText(this.fhQ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 1)).getForumName()}));
                                pVar.fka.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 1)).getForumName());
                                pVar.fka.setVisibility(0);
                                pVar.fkb.setVisibility(8);
                                pVar.fkc.setVisibility(0);
                                pVar.fkd.setVisibility(8);
                                break;
                            case 3:
                                pVar.fjZ.setMaxWidth(i2);
                                pVar.fjZ.setText(this.fhQ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 0)).getForumName()}));
                                pVar.fjZ.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 0)).getForumName());
                                pVar.fjZ.setVisibility(0);
                                pVar.fka.setMaxWidth(i2);
                                pVar.fka.setText(this.fhQ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 1)).getForumName()}));
                                pVar.fka.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 1)).getForumName());
                                pVar.fka.setVisibility(0);
                                pVar.fkb.setMaxWidth(i2);
                                pVar.fkb.setText(this.fhQ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 2)).getForumName()}));
                                pVar.fkb.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fig.aVM(), 2)).getForumName());
                                pVar.fkb.setVisibility(0);
                                pVar.fkc.setVisibility(0);
                                pVar.fkd.setVisibility(0);
                                break;
                        }
                        pVar.fjX.setVisibility(0);
                    }
                } else {
                    pVar.fjX.setVisibility(8);
                    pVar.fkg.setVisibility(8);
                    if (this.fig.aVq() == null || StringUtils.isNull(this.fig.aVq().getName()) || !aXU()) {
                    }
                }
                a(pVar.fjR, view2, this.fjI);
                pVar.fjQ.setVisibility(8);
                pVar.fjS.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rP() != null) {
                    j = postData.rP().getUserIdLong();
                    str = postData.rP().getUserName();
                    str2 = postData.rP().getName_show();
                }
                if (this.fig != null && this.fig.aVs() != null) {
                    pVar.fjS.a(postData.bsf(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fig.aVs().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.fjS.onChangeSkinType();
                if (this.fhQ.aWO().baH()) {
                    pVar.fjR.setVisibility(8);
                }
                if (this.fig != null && this.fig.aVs() != null && this.fig.aVs().sb() != null) {
                    bm sb3 = this.fig.aVs().sb();
                    final String activityUrl = sb3.getActivityUrl();
                    String tw = sb3.tw();
                    if (!StringUtils.isNull(sb3.tx())) {
                        pVar.fjV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hg()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.N(o.this.fhQ.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tw)) {
                            pVar.fjU.setVisibility(0);
                            pVar.fjU.startLoad(tw, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fjU.setVisibility(8);
                }
                if (pVar.fjW != null) {
                    pVar.fjW.setVisibility(8);
                }
            }
            pVar.fjR.getLayoutStrategy().fL(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view2);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.brX()));
            if (postData.bsb() > 0 && postData.brU() != null && postData.brU().size() > 0) {
                if (this.fiL == null) {
                    this.fiL = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fiL.setIsFromCDN(this.mIsFromCDN);
                    this.fiL.I(this.fip);
                    if (this.fig != null) {
                        this.fiL.B(this.fig.aVE(), TextUtils.equals(this.fig.aVs().rP().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fiL.T(this.fig.aVs());
                    }
                }
                this.fiL.qT(postData.getId());
            }
            pVar.fjR.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            if (this.fih) {
                pVar.fjR.getLayoutStrategy().fO(d.f.transparent_bg);
            } else {
                pVar.fjR.getLayoutStrategy().fO(d.f.icon_click);
            }
            pVar.fjR.setIsFromCDN(this.mIsFromCDN);
            if (this.fig != null && this.fig.aVs() != null && this.fig.aVs().isLinkThread()) {
                a(pVar, this.fig.aVs().tc());
            }
            a(pVar, postData);
            TbRichText brZ = postData.brZ();
            if (this.fig != null && this.fig.aVP()) {
                brZ = null;
            }
            if (this.fjG || !this.fjH) {
                pVar.fjR.setText(brZ, false, this.fiK);
            } else {
                pVar.fjR.setText(brZ, true, this.fiK);
            }
            a(pVar, postData, brZ);
            boolean z7 = !StringUtils.isNull(postData.rP().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fig != null && this.fig.aVE() != 0) {
                z8 = true;
                z9 = true;
                if (postData.rP() != null) {
                    String userId = postData.rP().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fig != null && this.fig.aVs() != null && this.fig.aVs().rP() != null && postData.rP() != null) {
                String userId2 = this.fig.aVs().rP().getUserId();
                String userId3 = postData.rP().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.rP() == null && UtilHelper.isCurrentAccount(postData.rP().getUserId())) {
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
                    if (postData.brX() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.rP() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.rP().getUserName());
                        }
                        if (this.fig != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fig.aVE()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rP() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rP().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rP().getUserName());
                        }
                        if (this.fig != null && this.fig.aVs() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fig.aVs().getId());
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
                        if (this.fig != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fig.aVE()));
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
            if (postData.rP() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.brX() == 1) {
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
    private void b(final p pVar, final PostData postData, final View view2, final int i) {
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.fjR.setTag(sparseArray);
            pVar.fiT.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fjR.setIsHost(true);
            if (this.fjF) {
                pVar.dCN.setVisibility(0);
            } else {
                pVar.dCN.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fih) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fjR.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fjR.setLayoutParams(layoutParams);
                pVar.fjR.hv(null);
                this.fjI = false;
                a(pVar, postData, view2, i);
            } else {
                this.fjI = true;
                pVar.fjR.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void KA() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fjR.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fjR.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view2, i);
                    }
                });
            }
            pVar.fkh.setData(this.fig.aVS());
            pVar.fkh.setPageContext(this.fhQ.getPageContext());
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bsk() == null) {
                pVar.crr.setVisibility(8);
                pVar.fjR.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            pVar.crr.b(postData.bsk());
            pVar.crr.setVisibility(0);
            if (pVar.crr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.crr.getLayoutParams();
                layoutParams.bottomMargin = this.bYQ;
                pVar.crr.setLayoutParams(layoutParams);
            }
            pVar.fjR.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ae aeVar) {
        if (aeVar != null && !com.baidu.tbadk.core.util.an.isEmpty(aeVar.getLinkUrl()) && !pVar.fkf.getIsLoaded() && aeVar.qQ() == com.baidu.tbadk.core.data.ae.Yu) {
            if (aeVar.qR()) {
                pVar.fke.setVisibility(8);
                pVar.fkf.setVisibility(8);
                return;
            }
            pVar.fjR.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds48));
            pVar.fke.setVisibility(0);
            com.baidu.tbadk.core.util.ak.j(pVar.fke, d.C0126d.cp_bg_line_c);
            pVar.fkf.setVisibility(0);
            pVar.fkf.setFocusable(false);
            pVar.fkf.setBackgroundColor(0);
            pVar.fkf.getSettings().setCacheMode(-1);
            pVar.fkf.setVerticalScrollBarEnabled(false);
            pVar.fkf.setHorizontalScrollBarEnabled(false);
            pVar.fkf.getSettings().setAllowFileAccess(true);
            pVar.fkf.getSettings().setAppCacheEnabled(true);
            pVar.fkf.getSettings().setDomStorageEnabled(true);
            pVar.fkf.getSettings().setDatabaseEnabled(true);
            pVar.fkf.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.fkf.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.fkf.loadUrl(aeVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bbZ() == null) {
            pVar.fjl.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(postData.bbZ(), pVar.fjl, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fjR.setTextViewOnTouchListener(this.fjL);
        pVar.fjR.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view2, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(af - i, this.fio);
            tbRichTextView.getLayoutStrategy().fM(min);
            tbRichTextView.getLayoutStrategy().fN((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fiT.setOnTouchListener(this.aWy);
        pVar.fiT.setOnLongClickListener(this.axX);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fhQ.getPageContext().getOrignalPage()).ffT;
        pVar.fjR.setOnLongClickListener(this.axX);
        pVar.fjR.setOnTouchListener(this.fjL);
        pVar.fjR.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fjR.setOnImageClickListener(this.aWx);
        pVar.fjR.setOnImageTouchListener(this.fjL);
        pVar.fjR.setOnEmotionClickListener(aVar.ftr);
        pVar.fjl.setOnClickListener(this.mCommonClickListener);
        pVar.fjZ.setOnClickListener(this);
        pVar.fka.setOnClickListener(this);
        pVar.fkb.setOnClickListener(this);
        pVar.crr.setSubClickListener(this.fjM);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            int id = view2.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view2.getTag() instanceof String)) {
                this.fhQ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fhQ).createNormalCfg((String) view2.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fig = dVar;
    }

    public void pZ(int i) {
        this.fio = i;
    }

    public void jr(boolean z) {
        this.fih = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fip = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWx = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aWy = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axX = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fiK = cVar;
    }

    public void jJ(boolean z) {
        this.fjF = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).fkf != null) {
            ((p) this.viewholder).fkf.removeAllViews();
            ((p) this.viewholder).fkf.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).fkf.setVisibility(8);
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).fkf != null) {
                            ((p) o.this.viewholder).fkf.destroy();
                            ((p) o.this.viewholder).fkf = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).fkf != null) {
            ((p) this.viewholder).fkf.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).fkf != null) {
            ((p) this.viewholder).fkf.onPause();
        }
    }

    private boolean aXU() {
        return (this.fig == null || this.fig.aVs() == null || !this.fig.aVs().sA() || this.fig.aVs().sg() == null) ? false : true;
    }
}
