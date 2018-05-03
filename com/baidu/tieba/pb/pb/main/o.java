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
    private int bXR;
    protected com.baidu.tieba.pb.data.d fgY;
    protected boolean fgZ;
    private TbRichTextView.c fhB;
    private com.baidu.tieba.pb.pb.sub.c fhC;
    protected int fhg;
    private View.OnClickListener fhh;
    private final boolean fiA;
    private boolean fiB;
    private int fiC;
    private int fiD;
    private com.baidu.tieba.pb.a.c fiE;
    private OriginalThreadCardView.a fiF;
    private final int fiw;
    private boolean fiy;
    private boolean fiz;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fiw = 3;
        this.fhg = 0;
        this.fgZ = true;
        this.fiy = true;
        this.fgY = null;
        this.fhC = null;
        this.fhh = null;
        this.mCommonClickListener = null;
        this.aWw = null;
        this.aWx = null;
        this.axW = null;
        this.fhB = null;
        this.fiz = false;
        this.fiA = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fiB = false;
        this.fiC = 0;
        this.fiD = 0;
        this.bXR = 0;
        this.pageFromType = 0;
        this.fiE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
        this.fiF = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fgY != null) {
                    String threadId = o.this.fgY.getThreadId();
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
        this.fiD = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds60);
        this.bXR = com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds34);
        if (pbActivity != null && pbActivity.aWx() != null) {
            this.pageFromType = pbActivity.aWx().aYP();
        }
        this.fiC = com.baidu.adp.lib.util.l.af(pbActivity) - com.baidu.adp.lib.util.l.e(pbActivity, d.e.ds130);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ak.j(pVar.fhK, d.C0126d.cp_bg_line_d);
                com.baidu.tbadk.core.util.ak.j(pVar.dBG, d.C0126d.cp_bg_line_c);
                pVar.fiK.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_b));
                pVar.cqh.onChangeSkinType();
                com.baidu.tbadk.core.util.ak.c(pVar.fiR, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fiS, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fiT, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.c(pVar.fiU, d.C0126d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ak.j(pVar.fiV, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.j(pVar.fiW, d.C0126d.cp_cont_e);
                com.baidu.tbadk.core.util.ak.c(pVar.fiZ, d.C0126d.cp_cont_d, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fgJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_first_floor_item, viewGroup, false), this.fgZ, this.fhg);
        a(pVar);
        if (pVar.cqh != null) {
            pVar.cqh.cqS = this.pageFromType;
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
        if (!this.fiz && this.fiA && pVar != null && pVar.fiK.Kx() && (xj = ((PbActivity) this.fgJ.getPageContext().getOrignalPage()).xj()) != null) {
            this.fiz = true;
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
        if (this.fgY != null) {
            if (postData.brZ() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fiK.setOnClickListener(this.mCommonClickListener);
                    pVar.fiK.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fiK.setOnClickListener(null);
                    pVar.fiK.setTextViewOnClickListener(null);
                }
                pVar.fhK.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fhK.setOnClickListener(null);
            }
            if (postData.brZ() == 1) {
                pVar.fiZ.setVisibility(8);
                StringBuilder sb = null;
                List<az> aVM = this.fgY.aVM();
                if (com.baidu.tbadk.core.util.v.v(aVM) > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (az azVar : aVM) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ZA) != null && uVar.isDeleted && ((uVar.XE && (uVar.type == 1 || uVar.type == 2)) || (this.fgY.aVs() != null && this.fgY.aVs().rQ() != null && TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.fgY.aVs().rQ().getUserId())))) {
                            sb2.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.fgJ.getString(d.k.forum)).append("、");
                        }
                    }
                    sb = sb2;
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    pVar.fiZ.setVisibility(0);
                    pVar.fiZ.setText(String.format(this.fgJ.getString(d.k.first_floor_del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
                if (!this.fgJ.aXy()) {
                    if (com.baidu.tbadk.core.util.v.w(this.fgY.aVM())) {
                        pVar.fiQ.setVisibility(8);
                        pVar.fiZ.setVisibility(8);
                    } else {
                        int v = com.baidu.tbadk.core.util.v.v(this.fgY.aVM());
                        if (v > 3) {
                            v = 3;
                        }
                        int i2 = this.fiC / v;
                        switch (v) {
                            case 1:
                                pVar.fiS.setMaxWidth(i2);
                                pVar.fiS.setText(this.fgJ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 0)).getForumName()}));
                                pVar.fiS.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 0)).getForumName());
                                pVar.fiS.setVisibility(0);
                                pVar.fiT.setVisibility(0);
                                pVar.fiU.setVisibility(0);
                                pVar.fiV.setVisibility(8);
                                pVar.fiW.setVisibility(8);
                                break;
                            case 2:
                                pVar.fiS.setMaxWidth(i2);
                                pVar.fiS.setText(this.fgJ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 0)).getForumName()}));
                                pVar.fiS.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 0)).getForumName());
                                pVar.fiS.setVisibility(0);
                                pVar.fiT.setMaxWidth(i2);
                                pVar.fiT.setText(this.fgJ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 1)).getForumName()}));
                                pVar.fiT.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 1)).getForumName());
                                pVar.fiT.setVisibility(0);
                                pVar.fiU.setVisibility(8);
                                pVar.fiV.setVisibility(0);
                                pVar.fiW.setVisibility(8);
                                break;
                            case 3:
                                pVar.fiS.setMaxWidth(i2);
                                pVar.fiS.setText(this.fgJ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 0)).getForumName()}));
                                pVar.fiS.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 0)).getForumName());
                                pVar.fiS.setVisibility(0);
                                pVar.fiT.setMaxWidth(i2);
                                pVar.fiT.setText(this.fgJ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 1)).getForumName()}));
                                pVar.fiT.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 1)).getForumName());
                                pVar.fiT.setVisibility(0);
                                pVar.fiU.setMaxWidth(i2);
                                pVar.fiU.setText(this.fgJ.getString(d.k.chosen_pb_original_bar, new Object[]{((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 2)).getForumName()}));
                                pVar.fiU.setTag(((az) com.baidu.tbadk.core.util.v.c(this.fgY.aVM(), 2)).getForumName());
                                pVar.fiU.setVisibility(0);
                                pVar.fiV.setVisibility(0);
                                pVar.fiW.setVisibility(0);
                                break;
                        }
                        pVar.fiQ.setVisibility(0);
                    }
                } else {
                    pVar.fiQ.setVisibility(8);
                    pVar.fiZ.setVisibility(8);
                    if (this.fgY.aVq() == null || StringUtils.isNull(this.fgY.aVq().getName()) || !aXU()) {
                    }
                }
                a(pVar.fiK, view2, this.fiB);
                pVar.fiJ.setVisibility(8);
                pVar.fiL.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rQ() != null) {
                    j = postData.rQ().getUserIdLong();
                    str = postData.rQ().getUserName();
                    str2 = postData.rQ().getName_show();
                }
                if (this.fgY != null && this.fgY.aVs() != null) {
                    pVar.fiL.a(postData.bsh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fgY.aVs().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.fiL.onChangeSkinType();
                if (this.fgJ.aWO().baH()) {
                    pVar.fiK.setVisibility(8);
                }
                if (this.fgY != null && this.fgY.aVs() != null && this.fgY.aVs().sc() != null) {
                    bm sc = this.fgY.aVs().sc();
                    final String activityUrl = sc.getActivityUrl();
                    String tx = sc.tx();
                    if (!StringUtils.isNull(sc.ty())) {
                        pVar.fiO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hg()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.N(o.this.fgJ.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tx)) {
                            pVar.fiN.setVisibility(0);
                            pVar.fiN.startLoad(tx, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fiN.setVisibility(8);
                }
                if (pVar.fiP != null) {
                    pVar.fiP.setVisibility(8);
                }
            }
            pVar.fiK.getLayoutStrategy().fK(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view2);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.brZ()));
            if (postData.bsd() > 0 && postData.brW() != null && postData.brW().size() > 0) {
                if (this.fhC == null) {
                    this.fhC = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fhC.setIsFromCDN(this.mIsFromCDN);
                    this.fhC.I(this.fhh);
                    if (this.fgY != null) {
                        this.fhC.B(this.fgY.aVE(), TextUtils.equals(this.fgY.aVs().rQ().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fhC.T(this.fgY.aVs());
                    }
                }
                this.fhC.qQ(postData.getId());
            }
            pVar.fiK.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            if (this.fgZ) {
                pVar.fiK.getLayoutStrategy().fN(d.f.transparent_bg);
            } else {
                pVar.fiK.getLayoutStrategy().fN(d.f.icon_click);
            }
            pVar.fiK.setIsFromCDN(this.mIsFromCDN);
            if (this.fgY != null && this.fgY.aVs() != null && this.fgY.aVs().isLinkThread()) {
                a(pVar, this.fgY.aVs().td());
            }
            a(pVar, postData);
            TbRichText bsb = postData.bsb();
            if (this.fgY != null && this.fgY.aVP()) {
                bsb = null;
            }
            if (this.fiz || !this.fiA) {
                pVar.fiK.setText(bsb, false, this.fhB);
            } else {
                pVar.fiK.setText(bsb, true, this.fhB);
            }
            a(pVar, postData, bsb);
            boolean z7 = !StringUtils.isNull(postData.rQ().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fgY != null && this.fgY.aVE() != 0) {
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
            if (this.fgY != null && this.fgY.aVs() != null && this.fgY.aVs().rQ() != null && postData.rQ() != null) {
                String userId2 = this.fgY.aVs().rQ().getUserId();
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
                        if (this.fgY != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fgY.aVE()));
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
                        if (this.fgY != null && this.fgY.aVs() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fgY.aVs().getId());
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
                        if (this.fgY != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fgY.aVE()));
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
            pVar.fiK.setTag(sparseArray);
            pVar.fhK.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fiK.setIsHost(true);
            if (this.fiy) {
                pVar.dBG.setVisibility(0);
            } else {
                pVar.dBG.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fgZ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fiK.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fiK.setLayoutParams(layoutParams);
                pVar.fiK.hu(null);
                this.fiB = false;
                a(pVar, postData, view2, i);
            } else {
                this.fiB = true;
                pVar.fiK.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void KC() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fiK.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fiK.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view2, i);
                    }
                });
            }
            pVar.fja.setData(this.fgY.aVS());
            pVar.fja.setPageContext(this.fgJ.getPageContext());
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bsm() == null) {
                pVar.cqh.setVisibility(8);
                pVar.fiK.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
                return;
            }
            pVar.cqh.b(postData.bsm());
            pVar.cqh.setVisibility(0);
            if (pVar.cqh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.cqh.getLayoutParams();
                layoutParams.bottomMargin = this.bXR;
                pVar.cqh.setLayoutParams(layoutParams);
            }
            pVar.fiK.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ae aeVar) {
        if (aeVar != null && !com.baidu.tbadk.core.util.an.isEmpty(aeVar.getLinkUrl()) && !pVar.fiY.getIsLoaded() && aeVar.qR() == com.baidu.tbadk.core.data.ae.Yu) {
            if (aeVar.qS()) {
                pVar.fiX.setVisibility(8);
                pVar.fiY.setVisibility(8);
                return;
            }
            pVar.fiK.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds48));
            pVar.fiX.setVisibility(0);
            com.baidu.tbadk.core.util.ak.j(pVar.fiX, d.C0126d.cp_bg_line_c);
            pVar.fiY.setVisibility(0);
            pVar.fiY.setFocusable(false);
            pVar.fiY.setBackgroundColor(0);
            pVar.fiY.getSettings().setCacheMode(-1);
            pVar.fiY.setVerticalScrollBarEnabled(false);
            pVar.fiY.setHorizontalScrollBarEnabled(false);
            pVar.fiY.getSettings().setAllowFileAccess(true);
            pVar.fiY.getSettings().setAppCacheEnabled(true);
            pVar.fiY.getSettings().setDomStorageEnabled(true);
            pVar.fiY.getSettings().setDatabaseEnabled(true);
            pVar.fiY.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.fiY.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.fiY.loadUrl(aeVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bbZ() == null) {
            pVar.fic.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(postData.bbZ(), pVar.fic, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fiK.setTextViewOnTouchListener(this.fiE);
        pVar.fiK.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view2, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(af - i, this.fhg);
            tbRichTextView.getLayoutStrategy().fL(min);
            tbRichTextView.getLayoutStrategy().fM((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fhK.setOnTouchListener(this.aWx);
        pVar.fhK.setOnLongClickListener(this.axW);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fgJ.getPageContext().getOrignalPage()).feM;
        pVar.fiK.setOnLongClickListener(this.axW);
        pVar.fiK.setOnTouchListener(this.fiE);
        pVar.fiK.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fiK.setOnImageClickListener(this.aWw);
        pVar.fiK.setOnImageTouchListener(this.fiE);
        pVar.fiK.setOnEmotionClickListener(aVar.fsk);
        pVar.fic.setOnClickListener(this.mCommonClickListener);
        pVar.fiS.setOnClickListener(this);
        pVar.fiT.setOnClickListener(this);
        pVar.fiU.setOnClickListener(this);
        pVar.cqh.setSubClickListener(this.fiF);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            int id = view2.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view2.getTag() instanceof String)) {
                this.fgJ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fgJ).createNormalCfg((String) view2.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fgY = dVar;
    }

    public void qa(int i) {
        this.fhg = i;
    }

    public void jq(boolean z) {
        this.fgZ = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fhh = onClickListener;
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
        this.fhB = cVar;
    }

    public void jI(boolean z) {
        this.fiy = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).fiY != null) {
            ((p) this.viewholder).fiY.removeAllViews();
            ((p) this.viewholder).fiY.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).fiY.setVisibility(8);
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).fiY != null) {
                            ((p) o.this.viewholder).fiY.destroy();
                            ((p) o.this.viewholder).fiY = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).fiY != null) {
            ((p) this.viewholder).fiY.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).fiY != null) {
            ((p) this.viewholder).fiY.onPause();
        }
    }

    private boolean aXU() {
        return (this.fgY == null || this.fgY.aVs() == null || !this.fgY.aVs().sB() || this.fgY.aVs().sh() == null) ? false : true;
    }
}
