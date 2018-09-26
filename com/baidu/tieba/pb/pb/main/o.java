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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class o extends k<PostData, p> implements View.OnClickListener {
    private View.OnLongClickListener aKx;
    private com.baidu.tieba.pb.a.c bjA;
    private TbRichTextView.h bjz;
    protected int fFA;
    private View.OnClickListener fFB;
    private TbRichTextView.c fFQ;
    private com.baidu.tieba.pb.pb.sub.c fFR;
    protected com.baidu.tieba.pb.data.d fFs;
    protected boolean fFt;
    private boolean fGH;
    private boolean fGI;
    private final boolean fGJ;
    private boolean fGK;
    private com.baidu.tieba.pb.a.c fGL;
    private OriginalThreadCardView.a fGM;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fFA = 0;
        this.fFt = true;
        this.fGH = true;
        this.fFs = null;
        this.fFR = null;
        this.fFB = null;
        this.mCommonClickListener = null;
        this.bjz = null;
        this.bjA = null;
        this.aKx = null;
        this.fFQ = null;
        this.fGI = false;
        this.fGJ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fGK = false;
        this.pageFromType = 0;
        this.fGL = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bjA != null) {
                    o.this.bjA.bo(view);
                    o.this.bjA.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fGM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fFs != null) {
                    String threadId = o.this.fFs.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").al("tid", threadId).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).w("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bcO() != null) {
            this.pageFromType = pbActivity.bcO().bfi();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.j(pVar.ebn, e.d.cp_bg_line_c);
                pVar.fGR.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                pVar.dBO.onChangeSkinType();
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fFd.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_first_floor_item, viewGroup, false), this.fFt, this.fFA);
        a(pVar);
        pVar.fGW.rc(this.pageFromType);
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
            postData2.xj();
            b(pVar, postData2, view, i);
        }
        if (!this.fGI && this.fGJ && pVar != null && pVar.fGR.PF() && (listView = ((PbActivity) this.fFd.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fGI = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x045a  */
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
        if (this.fFs != null) {
            if (postData.byM() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fGR.setOnClickListener(this.mCommonClickListener);
                    pVar.fGR.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fGR.setOnClickListener(null);
                    pVar.fGR.setTextViewOnClickListener(null);
                }
                pVar.fFW.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fFW.setOnClickListener(null);
            }
            if (postData.byM() == 1) {
                pVar.fGW.a(this.fFs, this.fFd.bcE(), this.mContext);
                a(pVar.fGR, view, this.fGK);
                pVar.fGQ.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.wm() != null) {
                    j = postData.wm().getUserIdLong();
                    str = postData.wm().getUserName();
                    str2 = postData.wm().getName_show();
                }
                if (this.fFs != null && this.fFs.bbJ() != null) {
                    pVar.fGW.a(postData.byU(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fFs.bbJ().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.fFd.bdf().bha()) {
                    pVar.fGR.setVisibility(8);
                }
                if (this.fFs != null && this.fFs.bbJ() != null && this.fFs.bbJ().wz() != null) {
                    bk wz = this.fFs.bbJ().wz();
                    wz.getActivityUrl();
                    String yf = wz.yf();
                    if (!StringUtils.isNull(wz.yg())) {
                        if (!StringUtils.isNull(yf)) {
                            pVar.fGT.setVisibility(0);
                            pVar.fGT.startLoad(yf, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fGT.setVisibility(8);
                }
                if (pVar.fGU != null) {
                    pVar.fGU.setVisibility(8);
                }
            }
            pVar.fGR.getLayoutStrategy().fZ(e.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.byM()));
            if (postData.byQ() > 0 && postData.byJ() != null && postData.byJ().size() > 0) {
                if (this.fFR == null) {
                    this.fFR = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fFR.setIsFromCDN(this.mIsFromCDN);
                    this.fFR.K(this.fFB);
                    if (this.fFs != null) {
                        this.fFR.B(this.fFs.bbV(), TextUtils.equals(this.fFs.bbJ().wm().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fFR.aa(this.fFs.bbJ());
                    }
                }
                this.fFR.sl(postData.getId());
            }
            pVar.fGR.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            if (this.fFt) {
                pVar.fGR.getLayoutStrategy().gc(e.f.transparent_bg);
            } else {
                pVar.fGR.getLayoutStrategy().gc(e.f.icon_click);
            }
            pVar.fGR.setIsFromCDN(this.mIsFromCDN);
            if (this.fFs != null && this.fFs.bbJ() != null && this.fFs.bbJ().isLinkThread()) {
                a(pVar, this.fFs.bbJ().xE());
            }
            a(pVar, postData);
            TbRichText byO = postData.byO();
            if (this.fFs != null && this.fFs.bci()) {
                byO = null;
            }
            if (this.fGI || !this.fGJ) {
                pVar.fGR.setText(byO, false, this.fFQ);
            } else {
                pVar.fGR.setText(byO, true, this.fFQ);
            }
            a(pVar, postData, byO);
            boolean z7 = !StringUtils.isNull(postData.wm().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fFs != null && this.fFs.bbV() != 0) {
                z8 = true;
                z9 = true;
                if (postData.wm() != null) {
                    String userId = postData.wm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fFs != null && this.fFs.bbJ() != null && this.fFs.bbJ().wm() != null && postData.wm() != null) {
                String userId2 = this.fFs.bbJ().wm().getUserId();
                String userId3 = postData.wm().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.wm() == null && UtilHelper.isCurrentAccount(postData.wm().getUserId())) {
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
                    if (postData.byM() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        if (postData.wm() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.wm().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.wm().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.wm().getPortrait());
                        }
                        if (this.fFs != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fFs.bbV()));
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.wm() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.wm().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.wm().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.wm().getName_show());
                        }
                        if (this.fFs != null && this.fFs.bbJ() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fFs.bbJ().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                        if (this.fFs != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fFs.bbV()));
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_delete_visible, false);
                    }
                    b(pVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.wm() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.byM() == 1) {
            }
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
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
            pVar.fGR.setTag(sparseArray);
            pVar.fFW.setTag(e.g.tag_from, sparseArray);
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            pVar.fGR.setIsHost(true);
            if (this.fGH) {
                pVar.ebn.setVisibility(0);
            } else {
                pVar.ebn.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fFt) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fGR.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fGR.setLayoutParams(layoutParams);
                pVar.fGR.it(null);
                this.fGK = false;
                a(pVar, postData, view, i);
            } else {
                this.fGK = true;
                pVar.fGR.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void PK() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fGR.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(e.C0141e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(e.C0141e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fGR.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fGV.setData(this.fFs.bcl());
            pVar.fGV.setPageContext(this.fFd.getPageContext());
            if (postData.byO() != null) {
                if (postData.byO().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.dBO.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(e.C0141e.tbds26);
                    pVar.dBO.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.dBO.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(e.C0141e.tbds16);
                    pVar.dBO.setLayoutParams(layoutParams3);
                }
            }
            if (this.fFs.bbJ() != null && this.fFs.bbJ().wS() != null) {
                pVar.dBO.setVisibility(0);
                pVar.dBO.setData(this.fFs.bbJ().wS());
                if (this.fFs.bbH() != null) {
                    pVar.dBO.setForumId(String.valueOf(this.fFs.bbH().getId()));
                }
                AppletsCellView appletsCellView = pVar.dBO;
                AppletsCellView appletsCellView2 = pVar.dBO;
                appletsCellView.setFrom("PB_card");
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.byX() == null) {
                pVar.fGR.getLayoutStrategy().gh(jS(e.C0141e.tbds24));
            } else {
                pVar.fGR.getLayoutStrategy().gh(jS(e.C0141e.tbds14));
            }
            pVar.fGW.f(postData.byX());
        }
    }

    private int jS(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl()) && adVar.vh() == com.baidu.tbadk.core.data.ad.aiF) {
            if (!adVar.vi()) {
                pVar.fGR.getLayoutStrategy().gh(com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds48));
            }
            pVar.fGW.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bix() == null) {
            pVar.fGp.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.c.a(postData.bix(), pVar.fGp, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fGR.setTextViewOnTouchListener(this.fGL);
        pVar.fGR.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(e.C0141e.ds80);
            }
            int min = Math.min(aO - i, this.fFA);
            tbRichTextView.getLayoutStrategy().ga(min);
            tbRichTextView.getLayoutStrategy().gb((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fFW.setOnTouchListener(this.bjA);
        pVar.fFW.setOnLongClickListener(this.aKx);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fFd.getPageContext().getOrignalPage()).fDh;
        pVar.fGR.setOnLongClickListener(this.aKx);
        pVar.fGR.setOnTouchListener(this.fGL);
        pVar.fGR.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fGR.setOnImageClickListener(this.bjz);
        pVar.fGR.setOnImageTouchListener(this.fGL);
        pVar.fGR.setOnEmotionClickListener(aVar.fQx);
        pVar.fGp.setOnClickListener(this.mCommonClickListener);
        pVar.fGW.a(this.fGM);
        pVar.fGW.I(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == e.g.view_forum1 || id == e.g.view_forum2 || id == e.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fFd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fFd).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fFs = dVar;
    }

    public void qQ(int i) {
        this.fFA = i;
    }

    public void jU(boolean z) {
        this.fFt = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fFB = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bjz = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bjA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aKx = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fFQ = cVar;
    }

    public void kl(boolean z) {
        this.fGH = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fGW.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fGW.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fGW.pause();
        }
    }
}
