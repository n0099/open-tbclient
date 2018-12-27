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
/* loaded from: classes6.dex */
public class o extends k<PostData, p> implements View.OnClickListener {
    private View.OnLongClickListener aTr;
    private TbRichTextView.h brP;
    private com.baidu.tieba.pb.a.c brQ;
    private com.baidu.tieba.pb.pb.sub.c fYA;
    protected com.baidu.tieba.pb.data.d fYb;
    protected boolean fYc;
    protected int fYj;
    private View.OnClickListener fYk;
    private TbRichTextView.c fYz;
    private boolean fZq;
    private boolean fZr;
    private final boolean fZs;
    private boolean fZt;
    private com.baidu.tieba.pb.a.c fZu;
    private OriginalThreadCardView.a fZv;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fYj = 0;
        this.fYc = true;
        this.fZq = true;
        this.fYb = null;
        this.fYA = null;
        this.fYk = null;
        this.mCommonClickListener = null;
        this.brP = null;
        this.brQ = null;
        this.aTr = null;
        this.fYz = null;
        this.fZr = false;
        this.fZs = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fZt = false;
        this.pageFromType = 0;
        this.fZu = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.brQ != null) {
                    o.this.brQ.bt(view);
                    o.this.brQ.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fZv = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fYb != null) {
                    String threadId = o.this.fYb.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").aA("tid", threadId).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).x("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bhZ() != null) {
            this.pageFromType = pbActivity.bhZ().bku();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.j(pVar.eun, e.d.cp_bg_line_c);
                pVar.fZA.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                pVar.dUm.onChangeSkinType();
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fXM.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_first_floor_item, viewGroup, false), this.fYc, this.fYj);
        a(pVar);
        pVar.fZF.sz(this.pageFromType);
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
            postData2.AD();
            b(pVar, postData2, view, i);
        }
        if (!this.fZr && this.fZs && pVar != null && pVar.fZA.SR() && (listView = ((PbActivity) this.fXM.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fZr = true;
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
        if (this.fYb != null) {
            if (postData.bEj() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fZA.setOnClickListener(this.mCommonClickListener);
                    pVar.fZA.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fZA.setOnClickListener(null);
                    pVar.fZA.setTextViewOnClickListener(null);
                }
                pVar.fYF.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fYF.setOnClickListener(null);
            }
            if (postData.bEj() == 1) {
                pVar.fZF.a(this.fYb, this.fXM.bhP(), this.mContext);
                a(pVar.fZA, view, this.fZt);
                pVar.fZz.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zG() != null) {
                    j = postData.zG().getUserIdLong();
                    str = postData.zG().getUserName();
                    str2 = postData.zG().getName_show();
                }
                if (this.fYb != null && this.fYb.bgV() != null) {
                    pVar.fZF.a(postData.bEr(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fYb.bgV().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.fXM.biq().bmn()) {
                    pVar.fZA.setVisibility(8);
                }
                if (this.fYb != null && this.fYb.bgV() != null && this.fYb.bgV().zT() != null) {
                    bk zT = this.fYb.bgV().zT();
                    zT.getActivityUrl();
                    String Bz = zT.Bz();
                    if (!StringUtils.isNull(zT.BA())) {
                        if (!StringUtils.isNull(Bz)) {
                            pVar.fZC.setVisibility(0);
                            pVar.fZC.startLoad(Bz, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fZC.setVisibility(8);
                }
                if (pVar.fZD != null) {
                    pVar.fZD.setVisibility(8);
                }
            }
            pVar.fZA.getLayoutStrategy().gK(e.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bEj()));
            if (postData.bEn() > 0 && postData.bEg() != null && postData.bEg().size() > 0) {
                if (this.fYA == null) {
                    this.fYA = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fYA.setIsFromCDN(this.mIsFromCDN);
                    this.fYA.M(this.fYk);
                    if (this.fYb != null) {
                        this.fYA.B(this.fYb.bhh(), TextUtils.equals(this.fYb.bgV().zG().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fYA.aa(this.fYb.bgV());
                    }
                }
                this.fYA.ts(postData.getId());
            }
            pVar.fZA.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            if (this.fYc) {
                pVar.fZA.getLayoutStrategy().gN(e.f.transparent_bg);
            } else {
                pVar.fZA.getLayoutStrategy().gN(e.f.icon_click);
            }
            pVar.fZA.setIsFromCDN(this.mIsFromCDN);
            if (this.fYb != null && this.fYb.bgV() != null && this.fYb.bgV().isLinkThread()) {
                a(pVar, this.fYb.bgV().AY());
            }
            a(pVar, postData);
            TbRichText bEl = postData.bEl();
            if (this.fYb != null && this.fYb.bhu()) {
                bEl = null;
            }
            if (this.fZr || !this.fZs) {
                pVar.fZA.setText(bEl, false, this.fYz);
            } else {
                pVar.fZA.setText(bEl, true, this.fYz);
            }
            a(pVar, postData, bEl);
            boolean z7 = !StringUtils.isNull(postData.zG().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fYb != null && this.fYb.bhh() != 0) {
                z8 = true;
                z9 = true;
                if (postData.zG() != null) {
                    String userId = postData.zG().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fYb != null && this.fYb.bgV() != null && this.fYb.bgV().zG() != null && postData.zG() != null) {
                String userId2 = this.fYb.bgV().zG().getUserId();
                String userId3 = postData.zG().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.zG() == null && UtilHelper.isCurrentAccount(postData.zG().getUserId())) {
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
                    if (postData.bEj() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                        }
                        if (this.fYb != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYb.bhh()));
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zG().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zG().getName_show());
                        }
                        if (this.fYb != null && this.fYb.bgV() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fYb.bgV().getId());
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
                        if (this.fYb != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYb.bhh()));
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
            if (postData.zG() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bEj() == 1) {
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
            pVar.fZA.setTag(sparseArray);
            pVar.fYF.setTag(e.g.tag_from, sparseArray);
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            pVar.fZA.setIsHost(true);
            if (this.fZq) {
                pVar.eun.setVisibility(0);
            } else {
                pVar.eun.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fYc) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fZA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fZA.setLayoutParams(layoutParams);
                pVar.fZA.jb(null);
                this.fZt = false;
                a(pVar, postData, view, i);
            } else {
                this.fZt = true;
                pVar.fZA.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void SW() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fZA.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(e.C0210e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(e.C0210e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fZA.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fZE.setData(this.fYb.bhx());
            pVar.fZE.setPageContext(this.fXM.getPageContext());
            if (postData.bEl() != null) {
                if (postData.bEl().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.dUm.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.tbds26);
                    pVar.dUm.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.dUm.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(e.C0210e.tbds16);
                    pVar.dUm.setLayoutParams(layoutParams3);
                }
            }
            if (this.fYb.bgV() != null && this.fYb.bgV().Am() != null) {
                pVar.dUm.setVisibility(0);
                pVar.dUm.setData(this.fYb.bgV().Am());
                if (this.fYb.bgT() != null) {
                    pVar.dUm.setForumId(String.valueOf(this.fYb.bgT().getId()));
                }
                AppletsCellView appletsCellView = pVar.dUm;
                AppletsCellView appletsCellView2 = pVar.dUm;
                appletsCellView.setFrom("PB_card");
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bEu() == null) {
                pVar.fZA.getLayoutStrategy().gS(ll(e.C0210e.tbds24));
            } else {
                pVar.fZA.getLayoutStrategy().gS(ll(e.C0210e.tbds14));
            }
            pVar.fZF.f(postData.bEu());
        }
    }

    private int ll(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl()) && adVar.yC() == com.baidu.tbadk.core.data.ad.arO) {
            if (!adVar.yD()) {
                pVar.fZA.getLayoutStrategy().gS(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds48));
            }
            pVar.fZF.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bnJ() == null) {
            pVar.fYY.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.c.a(postData.bnJ(), pVar.fYY, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fZA.setTextViewOnTouchListener(this.fZu);
        pVar.fZA.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(e.C0210e.ds80);
            }
            int min = Math.min(aO - i, this.fYj);
            tbRichTextView.getLayoutStrategy().gL(min);
            tbRichTextView.getLayoutStrategy().gM((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fYF.setOnTouchListener(this.brQ);
        pVar.fYF.setOnLongClickListener(this.aTr);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fXM.getPageContext().getOrignalPage()).fVQ;
        pVar.fZA.setOnLongClickListener(this.aTr);
        pVar.fZA.setOnTouchListener(this.fZu);
        pVar.fZA.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fZA.setOnImageClickListener(this.brP);
        pVar.fZA.setOnImageTouchListener(this.fZu);
        pVar.fZA.setOnEmotionClickListener(aVar.gjh);
        pVar.fYY.setOnClickListener(this.mCommonClickListener);
        pVar.fZF.a(this.fZv);
        pVar.fZF.K(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == e.g.view_forum1 || id == e.g.view_forum2 || id == e.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fXM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fXM).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fYb = dVar;
    }

    public void setImageMaxWidth(int i) {
        this.fYj = i;
    }

    public void kC(boolean z) {
        this.fYc = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fYk = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brP = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.brQ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTr = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fYz = cVar;
    }

    public void kT(boolean z) {
        this.fZq = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fZF.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fZF.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fZF.pause();
        }
    }
}
