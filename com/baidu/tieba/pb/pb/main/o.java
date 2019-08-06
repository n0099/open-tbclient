package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class o extends k<PostData, p> {
    private TbRichTextView.h cKo;
    private com.baidu.tieba.pb.a.c clA;
    private View.OnLongClickListener cmF;
    protected com.baidu.tieba.pb.data.d hNM;
    protected boolean hNN;
    protected int hNU;
    private View.OnClickListener hNW;
    private TbRichTextView.c hOn;
    private com.baidu.tieba.pb.pb.sub.c hOo;
    private boolean hPf;
    private boolean hPg;
    private final boolean hPh;
    private boolean hPi;
    private com.baidu.tieba.pb.a.c hPj;
    private OriginalThreadCardView.a hPk;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hNU = 0;
        this.hNN = true;
        this.hPf = true;
        this.hNM = null;
        this.hOo = null;
        this.hNW = null;
        this.mCommonClickListener = null;
        this.cKo = null;
        this.clA = null;
        this.cmF = null;
        this.hOn = null;
        this.hPg = false;
        this.hPh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hPi = false;
        this.pageFromType = 0;
        this.hPj = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                if (o.this.clA != null) {
                    o.this.clA.cu(view);
                    o.this.clA.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hPk = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hNM != null) {
                    String threadId = o.this.hNM.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").bT("tid", threadId).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).P("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bTR() != null) {
            this.pageFromType = pbActivity.bTR().bWu();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.l(pVar.bNX, R.color.cp_bg_line_c);
                pVar.hPq.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                pVar.YV.onChangeSkinType();
                if (pVar.hPw != null) {
                    pVar.hPw.onChangeSkinType();
                }
                if (pVar.hPx != null) {
                    pVar.hPx.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.j(pVar.hPu, R.color.cp_cont_j);
                pVar.hPy.nA(skinType);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.hNx.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.hNN, this.hNU);
        a(pVar);
        pVar.hPv.xU(this.pageFromType);
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
            postData2.afC();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hNx.getUniqueId(), this.hNM, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hPg && this.hPh && pVar != null && pVar.hPq.azD() && (listView = ((PbActivity) this.hNx.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hPg = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04c5  */
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
        if (this.hNM != null) {
            if (postData.cpL() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hPq.setOnClickListener(this.mCommonClickListener);
                    pVar.hPq.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hPq.setOnClickListener(null);
                    pVar.hPq.setTextViewOnClickListener(null);
                }
                pVar.hOt.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hOt.setOnClickListener(null);
            }
            if (postData.cpL() == 1) {
                pVar.b(this.hNM, this.hNx.bTH());
                a(pVar.hPq, view, this.hPi);
                pVar.hPn.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aey() != null) {
                    j = postData.aey().getUserIdLong();
                    str = postData.aey().getUserName();
                    str2 = postData.aey().getName_show();
                }
                if (this.hNM != null && this.hNM.bSL() != null) {
                    pVar.hPv.a(postData.cpT(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hNM.bSL().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                if (this.hNx.bUj().bYo()) {
                    pVar.hPq.setVisibility(8);
                }
                if (this.hNM != null && this.hNM.bSL() != null && this.hNM.bSL().aeK() != null) {
                    bq aeK = this.hNM.bSL().aeK();
                    aeK.getActivityUrl();
                    String agF = aeK.agF();
                    if (!StringUtils.isNull(aeK.agG())) {
                        if (!StringUtils.isNull(agF)) {
                            pVar.hPs.setVisibility(0);
                            pVar.hPs.startLoad(agF, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hPs.setVisibility(8);
                }
                if (pVar.hPt != null) {
                    pVar.hPt.setVisibility(8);
                }
                if (this.hNM != null && this.hNM.bSL() != null && this.hNM.bSL().afs() && pVar.hPw != null) {
                    pVar.hPw.setPadding(pVar.hPw.getPaddingLeft(), com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pVar.hPw.getPaddingRight(), pVar.hPw.getPaddingBottom());
                }
            }
            pVar.hPq.getLayoutStrategy().lt(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cpL()));
            if (postData.cpP() > 0 && postData.cpI() != null && postData.cpI().size() > 0) {
                if (this.hOo == null) {
                    this.hOo = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hOo.setIsFromCDN(this.mIsFromCDN);
                    this.hOo.Q(this.hNW);
                    if (this.hNM != null) {
                        this.hOo.O(this.hNM.bSX(), TextUtils.equals(this.hNM.bSL().aey().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hOo.aj(this.hNM.bSL());
                    }
                }
                this.hOo.Cq(postData.getId());
            }
            pVar.hPq.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.hNN) {
                pVar.hPq.getLayoutStrategy().lw(R.drawable.transparent_bg);
            } else {
                pVar.hPq.getLayoutStrategy().lw(R.drawable.icon_click);
            }
            pVar.hPq.setIsFromCDN(this.mIsFromCDN);
            if (this.hNM != null && this.hNM.bSL() != null && this.hNM.bSL().isLinkThread()) {
                a(pVar, this.hNM.bSL().afX());
            }
            a(pVar, postData);
            TbRichText cpN = postData.cpN();
            if (this.hNM != null && this.hNM.bTj()) {
                cpN = null;
            }
            if (this.hPg || !this.hPh) {
                pVar.hPq.setText(cpN, false, this.hOn);
            } else {
                pVar.hPq.setText(cpN, true, this.hOn);
            }
            a(pVar, postData, cpN);
            boolean z7 = !StringUtils.isNull(postData.aey().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hNM != null && this.hNM.bSX() != 0) {
                if (this.hNM.bSX() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.aey() != null) {
                    String userId = postData.aey().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hNM != null && this.hNM.bSL() != null && this.hNM.bSL().aey() != null && postData.aey() != null) {
                String userId2 = this.hNM.bSL().aey().getUserId();
                String userId3 = postData.aey().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aey() == null && UtilHelper.isCurrentAccount(postData.aey().getUserId())) {
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
                    int i2 = 1;
                    if (postData.cpL() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aey() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aey().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aey().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aey().getPortrait());
                        }
                        if (this.hNM != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNM.bSX()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aey() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aey().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aey().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aey().getName_show());
                        }
                        if (this.hNM != null && this.hNM.bSL() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hNM.bSL().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        if (this.hNM != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNM.bSX()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(pVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.aey() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.cpL() == 1) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(pVar);
        }
    }

    private void b(final p pVar, final PostData postData, final View view, final int i) {
        boolean z = false;
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.hPq.setTag(sparseArray);
            pVar.hOt.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pVar.hPq.setIsHost(true);
            if (this.hPf) {
                pVar.bNX.setVisibility(0);
            } else {
                pVar.bNX.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hNN) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hPq.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hPq.setLayoutParams(layoutParams);
                pVar.hPq.rC(null);
                this.hPi = false;
                a(pVar, postData, view, i);
            } else {
                this.hPi = true;
                pVar.hPq.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void azI() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hPq.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hPq.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hNM != null && this.hNM.bSL() != null && this.hNM.bSL().afs() && this.hNM.bSL().aeP() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.hNM.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cpN() == null || com.baidu.tbadk.core.util.v.aa(postData.cpN().ayN())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cpN() != null) {
                if (postData.cpN().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.YV.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pVar.YV.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.YV.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pVar.YV.setLayoutParams(layoutParams3);
                }
            }
            if (this.hNM.bSL() != null && this.hNM.bSL().afk() != null && this.hNM.bSL().aeP() == null) {
                pVar.YV.setVisibility(0);
                pVar.YV.setData(this.hNM.bSL().afk());
                if (this.hNM.getForum() != null) {
                    pVar.YV.setForumId(String.valueOf(this.hNM.getForum().getId()));
                }
                if (this.hNM.getThreadId() != null) {
                    pVar.YV.setThreadId(this.hNM.getThreadId());
                }
                AppletsCellView appletsCellView = pVar.YV;
                AppletsCellView appletsCellView2 = pVar.YV;
                appletsCellView.setFrom("PB_card");
            } else {
                pVar.YV.setVisibility(8);
            }
            if (this.hNM != null && this.hNM.bSL() != null && (this.hNM.bSL().aeN() != 0 || this.hNM.bSL().afs())) {
                pVar.W(this.hNM.bSL().aeu() == 1, this.hNM.bSL().aet() == 1);
            }
            if (this.hNM != null && this.hNM.hIN != null) {
                if (pVar.hPu != null) {
                    if (TextUtils.isEmpty(this.hNM.hIN.bTq())) {
                        pVar.hPu.setVisibility(8);
                    } else {
                        pVar.hPu.setVisibility(0);
                        pVar.hPu.setText(this.hNM.hIN.bTq());
                    }
                }
                if (pVar.hOu != null && pVar.hPy.getRootView() == null) {
                    pVar.hOu.addView(pVar.hPy.s(this.hNM));
                    String fromPageKey = UtilHelper.getFromPageKey(this.hNx.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).ajk();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals("a002")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).ajk();
                        } else if (fromPageKey.equals("a006")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).ajk();
                        } else if (fromPageKey.equals("a026")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 4).ajk();
                        }
                    }
                }
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.cpW() == null) {
                pVar.hPq.getLayoutStrategy().lC(qg(R.dimen.tbds24));
            } else {
                pVar.hPq.getLayoutStrategy().lC(qg(R.dimen.tbds14));
            }
            pVar.hPv.f(postData.cpW());
        }
    }

    private int qg(int i) {
        return com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl()) && afVar.adf() == com.baidu.tbadk.core.data.af.bHy) {
            if (!afVar.adg()) {
                pVar.hPq.getLayoutStrategy().lC(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds48));
            }
            pVar.hPv.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bZO() == null) {
            pVar.hOM.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bZO(), pVar.hOM, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hPq.setTextViewOnTouchListener(this.hPj);
        pVar.hPq.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(af - i, this.hNU);
            tbRichTextView.getLayoutStrategy().lu(min);
            tbRichTextView.getLayoutStrategy().lv((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hOt.setOnTouchListener(this.clA);
        pVar.hOt.setOnLongClickListener(this.cmF);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hNx.getPageContext().getOrignalPage()).hLx;
        pVar.hPq.setOnLongClickListener(this.cmF);
        pVar.hPq.setOnTouchListener(this.hPj);
        pVar.hPq.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hPq.setOnImageClickListener(this.cKo);
        pVar.hPq.setOnImageTouchListener(this.hPj);
        pVar.hPq.setOnEmotionClickListener(aVar.hYR);
        pVar.hOM.setOnClickListener(this.mCommonClickListener);
        pVar.hPv.a(this.hPk);
        pVar.hPw.setAfterItemClickListener(this.mCommonClickListener);
        pVar.hPx.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hNM = dVar;
    }

    public void xI(int i) {
        this.hNU = i;
    }

    public void og(boolean z) {
        this.hNN = z;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hNW = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKo = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.clA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmF = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hOn = cVar;
    }

    public void oy(boolean z) {
        this.hPf = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hPv.destroy();
            ((p) this.viewholder).hPx.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hPv.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hPv.pause();
        }
    }

    public p bVx() {
        return (p) this.viewholder;
    }
}
