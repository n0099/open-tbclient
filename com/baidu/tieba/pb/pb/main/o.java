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
    private TbRichTextView.h aWw;
    private com.baidu.tieba.pb.a.c aWx;
    private View.OnLongClickListener axW;
    private int bXU;
    private TbRichTextView.c fhE;
    private com.baidu.tieba.pb.pb.sub.c fhF;
    protected com.baidu.tieba.pb.data.d fhb;
    protected boolean fhc;
    protected int fhj;
    private View.OnClickListener fhk;
    private final int fiA;
    private boolean fiB;
    private boolean fiC;
    private final boolean fiD;
    private boolean fiE;
    private int fiF;
    private int fiG;
    private com.baidu.tieba.pb.a.c fiH;
    private OriginalThreadCardView.a fiI;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fiA = 3;
        this.fhj = 0;
        this.fhc = true;
        this.fiB = true;
        this.fhb = null;
        this.fhF = null;
        this.fhk = null;
        this.mCommonClickListener = null;
        this.aWw = null;
        this.aWx = null;
        this.axW = null;
        this.fhE = null;
        this.fiC = false;
        this.fiD = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fiE = false;
        this.fiF = 0;
        this.fiG = 0;
        this.bXU = 0;
        this.pageFromType = 0;
        this.fiH = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aWx != null) {
                    o.this.aWx.aT(view2);
                    o.this.aWx.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fiI = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fhb != null) {
                    String threadId = o.this.fhb.getThreadId();
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
        this.fiG = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds60);
        this.bXU = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aWx() != null) {
            this.pageFromType = pbActivity.aWx().aYP();
        }
        this.fiF = com.baidu.adp.lib.util.l.af(pbActivity) - com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds130);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ak.j(pVar.fhN, d.C0126d.cp_bg_line_d);
                com.baidu.tbadk.core.util.ak.j(pVar.dBJ, d.C0126d.cp_bg_line_c);
                pVar.fiN.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_b));
                pVar.cqk.onChangeSkinType();
                com.baidu.tbadk.core.util.ak.c(pVar.fiU, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fiV, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fiW, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fiX, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.j(pVar.fiY, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.j(pVar.fiZ, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.c(pVar.fjc, d.C0126d.cp_cont_d, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fgM.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_first_floor_item, viewGroup, false), this.fhc, this.fhj);
        a(pVar);
        if (pVar.cqk != null) {
            pVar.cqk.cqV = this.pageFromType;
        }
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, p pVar) {
        BdListView xj;
        super.onFillViewHolder(i, view2, viewGroup, postData, pVar);
        a(pVar);
        c(pVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sK();
            b(pVar, postData2, view2, i);
        }
        if (!this.fiC && this.fiD && pVar != null && pVar.fiN.Kx() && (xj = ((PbActivity) this.fgM.getPageContext().getOrignalPage()).xj()) != null) {
            this.fiC = true;
            CompatibleUtile.getInstance().closeViewGpu(xj);
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
        if (this.fhb != null) {
            if (postData.brZ() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fiN.setOnClickListener(this.mCommonClickListener);
                    pVar.fiN.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fiN.setOnClickListener(null);
                    pVar.fiN.setTextViewOnClickListener(null);
                }
                pVar.fhN.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fhN.setOnClickListener(null);
            }
            if (postData.brZ() == 1) {
                pVar.fjc.setVisibility(8);
                StringBuilder sb = null;
                List<az> aVM = this.fhb.aVM();
                if (com.baidu.tbadk.core.util.v.v(aVM) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (az azVar : aVM) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ZA) != null && uVar.isDeleted && ((uVar.XE && (uVar.type == 1 || uVar.type == 2)) || (this.fhb.aVs() != null && this.fhb.aVs().rQ() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fhb.aVs().rQ().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.fgM.getString(d.k.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    pVar.fjc.setVisibility(0);
                    pVar.fjc.setText(String.format(this.fgM.getString(d.k.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
                if (!this.fgM.aXy()) {
                    if (com.baidu.tbadk.core.util.v.w(this.fhb.aVM())) {
                        pVar.fiT.setVisibility(8);
                        pVar.fjc.setVisibility(8);
                    } else {
                        int v = com.baidu.tbadk.core.util.v.v(this.fhb.aVM());
                        if (v > 3) {
                            v = 3;
                        }
                        int i2 = this.fiF / v;
                        switch (v) {
                            case 1:
                                pVar.fiV.setMaxWidth(i2);
                                pVar.fiV.setText(this.fgM.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 0)).getForumName()}));
                                pVar.fiV.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 0)).getForumName());
                                pVar.fiV.setVisibility(0);
                                pVar.fiW.setVisibility(0);
                                pVar.fiX.setVisibility(0);
                                pVar.fiY.setVisibility(8);
                                pVar.fiZ.setVisibility(8);
                                break;
                            case 2:
                                pVar.fiV.setMaxWidth(i2);
                                pVar.fiV.setText(this.fgM.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 0)).getForumName()}));
                                pVar.fiV.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 0)).getForumName());
                                pVar.fiV.setVisibility(0);
                                pVar.fiW.setMaxWidth(i2);
                                pVar.fiW.setText(this.fgM.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 1)).getForumName()}));
                                pVar.fiW.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 1)).getForumName());
                                pVar.fiW.setVisibility(0);
                                pVar.fiX.setVisibility(8);
                                pVar.fiY.setVisibility(0);
                                pVar.fiZ.setVisibility(8);
                                break;
                            case 3:
                                pVar.fiV.setMaxWidth(i2);
                                pVar.fiV.setText(this.fgM.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 0)).getForumName()}));
                                pVar.fiV.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 0)).getForumName());
                                pVar.fiV.setVisibility(0);
                                pVar.fiW.setMaxWidth(i2);
                                pVar.fiW.setText(this.fgM.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 1)).getForumName()}));
                                pVar.fiW.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 1)).getForumName());
                                pVar.fiW.setVisibility(0);
                                pVar.fiX.setMaxWidth(i2);
                                pVar.fiX.setText(this.fgM.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 2)).getForumName()}));
                                pVar.fiX.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fhb.aVM(), 2)).getForumName());
                                pVar.fiX.setVisibility(0);
                                pVar.fiY.setVisibility(0);
                                pVar.fiZ.setVisibility(0);
                                break;
                        }
                        pVar.fiT.setVisibility(0);
                    }
                } else {
                    pVar.fiT.setVisibility(8);
                    pVar.fjc.setVisibility(8);
                    if (this.fhb.aVq() == null || StringUtils.isNull(this.fhb.aVq().getName()) || !aXU()) {
                    }
                }
                a(pVar.fiN, view2, this.fiE);
                pVar.fiM.setVisibility(8);
                pVar.fiO.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rQ() != null) {
                    j = postData.rQ().getUserIdLong();
                    str = postData.rQ().getUserName();
                    str2 = postData.rQ().getName_show();
                }
                if (this.fhb != null && this.fhb.aVs() != null) {
                    pVar.fiO.a(postData.bsh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fhb.aVs().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.fiO.onChangeSkinType();
                if (this.fgM.aWO().baH()) {
                    pVar.fiN.setVisibility(8);
                }
                if (this.fhb != null && this.fhb.aVs() != null && this.fhb.aVs().sc() != null) {
                    bm sc = this.fhb.aVs().sc();
                    final String activityUrl = sc.getActivityUrl();
                    String tx = sc.tx();
                    if (!StringUtils.isNull(sc.ty())) {
                        pVar.fiR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hg()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.N(o.this.fgM.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tx)) {
                            pVar.fiQ.setVisibility(0);
                            pVar.fiQ.startLoad(tx, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fiQ.setVisibility(8);
                }
                if (pVar.fiS != null) {
                    pVar.fiS.setVisibility(8);
                }
            }
            pVar.fiN.getLayoutStrategy().fL(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view2);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.brZ()));
            if (postData.bsd() > 0 && postData.brW() != null && postData.brW().size() > 0) {
                if (this.fhF == null) {
                    this.fhF = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fhF.setIsFromCDN(this.mIsFromCDN);
                    this.fhF.I(this.fhk);
                    if (this.fhb != null) {
                        this.fhF.B(this.fhb.aVE(), TextUtils.equals(this.fhb.aVs().rQ().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fhF.T(this.fhb.aVs());
                    }
                }
                this.fhF.qQ(postData.getId());
            }
            pVar.fiN.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            if (this.fhc) {
                pVar.fiN.getLayoutStrategy().fO(d.f.transparent_bg);
            } else {
                pVar.fiN.getLayoutStrategy().fO(d.f.icon_click);
            }
            pVar.fiN.setIsFromCDN(this.mIsFromCDN);
            if (this.fhb != null && this.fhb.aVs() != null && this.fhb.aVs().isLinkThread()) {
                a(pVar, this.fhb.aVs().td());
            }
            a(pVar, postData);
            TbRichText bsb = postData.bsb();
            if (this.fhb != null && this.fhb.aVP()) {
                bsb = null;
            }
            if (this.fiC || !this.fiD) {
                pVar.fiN.setText(bsb, false, this.fhE);
            } else {
                pVar.fiN.setText(bsb, true, this.fhE);
            }
            a(pVar, postData, bsb);
            boolean z7 = !StringUtils.isNull(postData.rQ().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fhb != null && this.fhb.aVE() != 0) {
                z8 = true;
                z9 = true;
                if (postData.rQ() != null) {
                    String userId = postData.rQ().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fhb != null && this.fhb.aVs() != null && this.fhb.aVs().rQ() != null && postData.rQ() != null) {
                String userId2 = this.fhb.aVs().rQ().getUserId();
                String userId3 = postData.rQ().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.rQ() == null && UtilHelper.isCurrentAccount(postData.rQ().getUserId())) {
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
                    if (postData.brZ() == 1) {
                        i3 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.rQ() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.rQ().getUserName());
                        }
                        if (this.fhb != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fhb.aVE()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rQ() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rQ().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rQ().getUserName());
                        }
                        if (this.fhb != null && this.fhb.aVs() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fhb.aVs().getId());
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
                        if (this.fhb != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fhb.aVE()));
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
            if (postData.rQ() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.brZ() == 1) {
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
            pVar.fiN.setTag(sparseArray);
            pVar.fhN.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fiN.setIsHost(true);
            if (this.fiB) {
                pVar.dBJ.setVisibility(0);
            } else {
                pVar.dBJ.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fhc) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fiN.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fiN.setLayoutParams(layoutParams);
                pVar.fiN.hu(null);
                this.fiE = false;
                a(pVar, postData, view2, i);
            } else {
                this.fiE = true;
                pVar.fiN.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void KC() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fiN.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fiN.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view2, i);
                    }
                });
            }
            pVar.fjd.setData(this.fhb.aVS());
            pVar.fjd.setPageContext(this.fgM.getPageContext());
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bsm() == null) {
                pVar.cqk.setVisibility(8);
                pVar.fiN.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            pVar.cqk.b(postData.bsm());
            pVar.cqk.setVisibility(0);
            if (pVar.cqk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.cqk.getLayoutParams();
                layoutParams.bottomMargin = this.bXU;
                pVar.cqk.setLayoutParams(layoutParams);
            }
            pVar.fiN.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ae aeVar) {
        if (aeVar != null && !com.baidu.tbadk.core.util.an.isEmpty(aeVar.getLinkUrl()) && !pVar.fjb.getIsLoaded() && aeVar.qR() == com.baidu.tbadk.core.data.ae.Yu) {
            if (aeVar.qS()) {
                pVar.fja.setVisibility(8);
                pVar.fjb.setVisibility(8);
                return;
            }
            pVar.fiN.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds48));
            pVar.fja.setVisibility(0);
            com.baidu.tbadk.core.util.ak.j(pVar.fja, d.C0126d.cp_bg_line_c);
            pVar.fjb.setVisibility(0);
            pVar.fjb.setFocusable(false);
            pVar.fjb.setBackgroundColor(0);
            pVar.fjb.getSettings().setCacheMode(-1);
            pVar.fjb.setVerticalScrollBarEnabled(false);
            pVar.fjb.setHorizontalScrollBarEnabled(false);
            pVar.fjb.getSettings().setAllowFileAccess(true);
            pVar.fjb.getSettings().setAppCacheEnabled(true);
            pVar.fjb.getSettings().setDomStorageEnabled(true);
            pVar.fjb.getSettings().setDatabaseEnabled(true);
            pVar.fjb.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.fjb.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.fjb.loadUrl(aeVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bbZ() == null) {
            pVar.fig.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(postData.bbZ(), pVar.fig, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fiN.setTextViewOnTouchListener(this.fiH);
        pVar.fiN.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view2, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(af - i, this.fhj);
            tbRichTextView.getLayoutStrategy().fM(min);
            tbRichTextView.getLayoutStrategy().fN((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fhN.setOnTouchListener(this.aWx);
        pVar.fhN.setOnLongClickListener(this.axW);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fgM.getPageContext().getOrignalPage()).feP;
        pVar.fiN.setOnLongClickListener(this.axW);
        pVar.fiN.setOnTouchListener(this.fiH);
        pVar.fiN.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fiN.setOnImageClickListener(this.aWw);
        pVar.fiN.setOnImageTouchListener(this.fiH);
        pVar.fiN.setOnEmotionClickListener(aVar.fsn);
        pVar.fig.setOnClickListener(this.mCommonClickListener);
        pVar.fiV.setOnClickListener(this);
        pVar.fiW.setOnClickListener(this);
        pVar.fiX.setOnClickListener(this);
        pVar.cqk.setSubClickListener(this.fiI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            int id = view2.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view2.getTag() instanceof String)) {
                this.fgM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fgM).createNormalCfg((String) view2.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fhb = dVar;
    }

    public void qb(int i) {
        this.fhj = i;
    }

    public void jq(boolean z) {
        this.fhc = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fhk = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWw = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aWx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axW = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fhE = cVar;
    }

    public void jI(boolean z) {
        this.fiB = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).fjb != null) {
            ((p) this.viewholder).fjb.removeAllViews();
            ((p) this.viewholder).fjb.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).fjb.setVisibility(8);
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).fjb != null) {
                            ((p) o.this.viewholder).fjb.destroy();
                            ((p) o.this.viewholder).fjb = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).fjb != null) {
            ((p) this.viewholder).fjb.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).fjb != null) {
            ((p) this.viewholder).fjb.onPause();
        }
    }

    private boolean aXU() {
        return (this.fhb == null || this.fhb.aVs() == null || !this.fhb.aVs().sB() || this.fhb.aVs().sh() == null) ? false : true;
    }
}
