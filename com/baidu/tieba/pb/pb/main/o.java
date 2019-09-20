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
    private TbRichTextView.h cLe;
    private com.baidu.tieba.pb.a.c cmw;
    private View.OnLongClickListener cnB;
    protected com.baidu.tieba.pb.data.d hPJ;
    protected boolean hPK;
    protected int hPR;
    private View.OnClickListener hPT;
    private TbRichTextView.c hQk;
    private com.baidu.tieba.pb.pb.sub.c hQl;
    private boolean hRc;
    private boolean hRd;
    private final boolean hRe;
    private boolean hRf;
    private com.baidu.tieba.pb.a.c hRg;
    private OriginalThreadCardView.a hRh;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hPR = 0;
        this.hPK = true;
        this.hRc = true;
        this.hPJ = null;
        this.hQl = null;
        this.hPT = null;
        this.mCommonClickListener = null;
        this.cLe = null;
        this.cmw = null;
        this.cnB = null;
        this.hQk = null;
        this.hRd = false;
        this.hRe = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hRf = false;
        this.pageFromType = 0;
        this.hRg = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.cmw != null) {
                    o.this.cmw.cu(view);
                    o.this.cmw.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hRh = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hPJ != null) {
                    String threadId = o.this.hPJ.getThreadId();
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
        if (pbActivity != null && pbActivity.bUE() != null) {
            this.pageFromType = pbActivity.bUE().bXh();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.l(pVar.bOw, R.color.cp_bg_line_c);
                pVar.hRn.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                pVar.YV.onChangeSkinType();
                if (pVar.hRt != null) {
                    pVar.hRt.onChangeSkinType();
                }
                if (pVar.hRu != null) {
                    pVar.hRu.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.j(pVar.hRr, R.color.cp_cont_j);
                pVar.hRv.nE(skinType);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.hPu.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.hPK, this.hPR);
        a(pVar);
        pVar.hRs.xX(this.pageFromType);
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
            postData2.afG();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hPu.getUniqueId(), this.hPJ, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hRd && this.hRe && pVar != null && pVar.hRn.azP() && (listView = ((PbActivity) this.hPu.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hRd = true;
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
        if (this.hPJ != null) {
            if (postData.cqz() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hRn.setOnClickListener(this.mCommonClickListener);
                    pVar.hRn.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hRn.setOnClickListener(null);
                    pVar.hRn.setTextViewOnClickListener(null);
                }
                pVar.hQq.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hQq.setOnClickListener(null);
            }
            if (postData.cqz() == 1) {
                pVar.b(this.hPJ, this.hPu.bUu());
                a(pVar.hRn, view, this.hRf);
                pVar.hRk.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aeC() != null) {
                    j = postData.aeC().getUserIdLong();
                    str = postData.aeC().getUserName();
                    str2 = postData.aeC().getName_show();
                }
                if (this.hPJ != null && this.hPJ.bTy() != null) {
                    pVar.hRs.a(postData.cqH(), str, str2, j, com.baidu.adp.lib.g.b.e(this.hPJ.bTy().getId(), 0L), com.baidu.adp.lib.g.b.e(postData.getId(), 0L));
                }
                if (this.hPu.bUW().bZb()) {
                    pVar.hRn.setVisibility(8);
                }
                if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTy().aeO() != null) {
                    bq aeO = this.hPJ.bTy().aeO();
                    aeO.getActivityUrl();
                    String agJ = aeO.agJ();
                    if (!StringUtils.isNull(aeO.agK())) {
                        if (!StringUtils.isNull(agJ)) {
                            pVar.hRp.setVisibility(0);
                            pVar.hRp.startLoad(agJ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hRp.setVisibility(8);
                }
                if (pVar.hRq != null) {
                    pVar.hRq.setVisibility(8);
                }
                if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTy().afw() && pVar.hRt != null) {
                    pVar.hRt.setPadding(pVar.hRt.getPaddingLeft(), com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pVar.hRt.getPaddingRight(), pVar.hRt.getPaddingBottom());
                }
            }
            pVar.hRn.getLayoutStrategy().lx(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cqz()));
            if (postData.cqD() > 0 && postData.cqw() != null && postData.cqw().size() > 0) {
                if (this.hQl == null) {
                    this.hQl = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hQl.setIsFromCDN(this.mIsFromCDN);
                    this.hQl.Q(this.hPT);
                    if (this.hPJ != null) {
                        this.hQl.P(this.hPJ.bTK(), TextUtils.equals(this.hPJ.bTy().aeC().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hQl.ak(this.hPJ.bTy());
                    }
                }
                this.hQl.CP(postData.getId());
            }
            pVar.hRn.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.hPK) {
                pVar.hRn.getLayoutStrategy().lA(R.drawable.transparent_bg);
            } else {
                pVar.hRn.getLayoutStrategy().lA(R.drawable.icon_click);
            }
            pVar.hRn.setIsFromCDN(this.mIsFromCDN);
            if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTy().isLinkThread()) {
                a(pVar, this.hPJ.bTy().agb());
            }
            a(pVar, postData);
            TbRichText cqB = postData.cqB();
            if (this.hPJ != null && this.hPJ.bTW()) {
                cqB = null;
            }
            if (this.hRd || !this.hRe) {
                pVar.hRn.setText(cqB, false, this.hQk);
            } else {
                pVar.hRn.setText(cqB, true, this.hQk);
            }
            a(pVar, postData, cqB);
            boolean z7 = !StringUtils.isNull(postData.aeC().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hPJ != null && this.hPJ.bTK() != 0) {
                if (this.hPJ.bTK() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.aeC() != null) {
                    String userId = postData.aeC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTy().aeC() != null && postData.aeC() != null) {
                String userId2 = this.hPJ.bTy().aeC().getUserId();
                String userId3 = postData.aeC().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aeC() == null && UtilHelper.isCurrentAccount(postData.aeC().getUserId())) {
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
                    if (postData.cqz() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aeC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aeC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aeC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aeC().getPortrait());
                        }
                        if (this.hPJ != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hPJ.bTK()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aeC() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aeC().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aeC().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aeC().getName_show());
                        }
                        if (this.hPJ != null && this.hPJ.bTy() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hPJ.bTy().getId());
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
                        if (this.hPJ != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hPJ.bTK()));
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
            if (postData.aeC() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.cqz() == 1) {
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
            pVar.hRn.setTag(sparseArray);
            pVar.hQq.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pVar.hRn.setIsHost(true);
            if (this.hRc) {
                pVar.bOw.setVisibility(0);
            } else {
                pVar.bOw.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hPK) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hRn.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hRn.setLayoutParams(layoutParams);
                pVar.hRn.rN(null);
                this.hRf = false;
                a(pVar, postData, view, i);
            } else {
                this.hRf = true;
                pVar.hRn.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void azU() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hRn.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hRn.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTy().afw() && this.hPJ.bTy().aeT() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.hPJ.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cqB() == null || com.baidu.tbadk.core.util.v.aa(postData.cqB().ayZ())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cqB() != null) {
                if (postData.cqB().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.YV.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pVar.YV.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.YV.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pVar.YV.setLayoutParams(layoutParams3);
                }
            }
            if (this.hPJ.bTy() != null && this.hPJ.bTy().afo() != null && this.hPJ.bTy().aeT() == null) {
                pVar.YV.setVisibility(0);
                pVar.YV.setData(this.hPJ.bTy().afo());
                if (this.hPJ.getForum() != null) {
                    pVar.YV.setForumId(String.valueOf(this.hPJ.getForum().getId()));
                }
                if (this.hPJ.getThreadId() != null) {
                    pVar.YV.setThreadId(this.hPJ.getThreadId());
                }
                AppletsCellView appletsCellView = pVar.YV;
                AppletsCellView appletsCellView2 = pVar.YV;
                appletsCellView.setFrom("PB_card");
            } else {
                pVar.YV.setVisibility(8);
            }
            if (this.hPJ != null && this.hPJ.bTy() != null && (this.hPJ.bTy().aeR() != 0 || this.hPJ.bTy().afw())) {
                pVar.a(this.hPJ, this.hPJ.bTy().aey() == 1, this.hPJ.bTy().aex() == 1);
            }
            if (this.hPJ != null && this.hPJ.hKJ != null) {
                if (pVar.hRr != null) {
                    if (TextUtils.isEmpty(this.hPJ.hKJ.bUd())) {
                        pVar.hRr.setVisibility(8);
                    } else {
                        pVar.hRr.setVisibility(0);
                        pVar.hRr.setText(this.hPJ.hKJ.bUd());
                    }
                }
                if (pVar.hQr != null && pVar.hRv.getRootView() == null) {
                    pVar.hQr.addView(pVar.hRv.s(this.hPJ));
                    String fromPageKey = UtilHelper.getFromPageKey(this.hPu.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).ajq();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals("a002")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).ajq();
                        } else if (fromPageKey.equals("a006")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).ajq();
                        } else if (fromPageKey.equals("a026")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 4).ajq();
                        }
                    }
                }
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.cqK() == null) {
                pVar.hRn.getLayoutStrategy().lG(qj(R.dimen.tbds24));
            } else {
                pVar.hRn.getLayoutStrategy().lG(qj(R.dimen.tbds14));
            }
            pVar.hRs.f(postData.cqK());
        }
    }

    private int qj(int i) {
        return com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl()) && afVar.adj() == com.baidu.tbadk.core.data.af.bHW) {
            if (!afVar.adk()) {
                pVar.hRn.getLayoutStrategy().lG(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds48));
            }
            pVar.hRs.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.caC() == null) {
            pVar.hQJ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.caC(), pVar.hQJ, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hRn.setTextViewOnTouchListener(this.hRg);
        pVar.hRn.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(af - i, this.hPR);
            tbRichTextView.getLayoutStrategy().ly(min);
            tbRichTextView.getLayoutStrategy().lz((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hQq.setOnTouchListener(this.cmw);
        pVar.hQq.setOnLongClickListener(this.cnB);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hPu.getPageContext().getOrignalPage()).hNu;
        pVar.hRn.setOnLongClickListener(this.cnB);
        pVar.hRn.setOnTouchListener(this.hRg);
        pVar.hRn.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hRn.setOnImageClickListener(this.cLe);
        pVar.hRn.setOnImageTouchListener(this.hRg);
        pVar.hRn.setOnEmotionClickListener(aVar.iaO);
        pVar.hQJ.setOnClickListener(this.mCommonClickListener);
        pVar.hRs.a(this.hRh);
        pVar.hRt.setAfterItemClickListener(this.mCommonClickListener);
        pVar.hRu.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hPJ = dVar;
    }

    public void xL(int i) {
        this.hPR = i;
    }

    public void ok(boolean z) {
        this.hPK = z;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hPT = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cLe = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cmw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnB = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hQk = cVar;
    }

    public void oC(boolean z) {
        this.hRc = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hRs.destroy();
            ((p) this.viewholder).hRu.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hRs.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hRs.pause();
        }
    }

    public p bWk() {
        return (p) this.viewholder;
    }
}
