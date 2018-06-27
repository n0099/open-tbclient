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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class o extends k<PostData, p> implements View.OnClickListener {
    private View.OnLongClickListener aHk;
    private TbRichTextView.h bfR;
    private com.baidu.tieba.pb.a.c bfS;
    protected int fxE;
    private View.OnClickListener fxF;
    private TbRichTextView.c fxX;
    private com.baidu.tieba.pb.pb.sub.c fxY;
    protected com.baidu.tieba.pb.data.d fxw;
    protected boolean fxx;
    private boolean fyR;
    private boolean fyS;
    private final boolean fyT;
    private boolean fyU;
    private com.baidu.tieba.pb.a.c fyV;
    private OriginalThreadCardView.a fyW;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fxE = 0;
        this.fxx = true;
        this.fyR = true;
        this.fxw = null;
        this.fxY = null;
        this.fxF = null;
        this.mCommonClickListener = null;
        this.bfR = null;
        this.bfS = null;
        this.aHk = null;
        this.fxX = null;
        this.fyS = false;
        this.fyT = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fyU = false;
        this.pageFromType = 0;
        this.fyV = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bfS != null) {
                    o.this.bfS.aX(view);
                    o.this.bfS.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fyW = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fxw != null) {
                    String threadId = o.this.fxw.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").ah("tid", threadId).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).r("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bca() != null) {
            this.pageFromType = pbActivity.bca().bev();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.j(pVar.dRm, d.C0142d.cp_bg_line_c);
                pVar.fza.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_cont_b));
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fxh.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.new_pb_list_first_floor_item, viewGroup, false), this.fxx, this.fxE);
        a(pVar);
        pVar.fzf.qF(this.pageFromType);
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
            postData2.wq();
            b(pVar, postData2, view, i);
        }
        if (!this.fyS && this.fyT && pVar != null && pVar.fza.On() && (listView = ((PbActivity) this.fxh.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fyS = true;
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
        if (this.fxw != null) {
            if (postData.bxC() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fza.setOnClickListener(this.mCommonClickListener);
                    pVar.fza.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fza.setOnClickListener(null);
                    pVar.fza.setTextViewOnClickListener(null);
                }
                pVar.fyg.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fyg.setOnClickListener(null);
            }
            if (postData.bxC() == 1) {
                pVar.fzf.a(this.fxw, this.fxh.bdb(), this.mContext);
                a(pVar.fza, view, this.fyU);
                pVar.fyZ.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vw() != null) {
                    j = postData.vw().getUserIdLong();
                    str = postData.vw().getUserName();
                    str2 = postData.vw().getName_show();
                }
                if (this.fxw != null && this.fxw.baV() != null) {
                    pVar.fzf.a(postData.bxK(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fxw.baV().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                if (this.fxh.bcr().bgn()) {
                    pVar.fza.setVisibility(8);
                }
                if (this.fxw != null && this.fxw.baV() != null && this.fxw.baV().vI() != null) {
                    bl vI = this.fxw.baV().vI();
                    vI.getActivityUrl();
                    String xh = vI.xh();
                    if (!StringUtils.isNull(vI.xi())) {
                        if (!StringUtils.isNull(xh)) {
                            pVar.fzc.setVisibility(0);
                            pVar.fzc.startLoad(xh, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fzc.setVisibility(8);
                }
                if (pVar.fzd != null) {
                    pVar.fzd.setVisibility(8);
                }
            }
            pVar.fza.getLayoutStrategy().fN(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bxC()));
            if (postData.bxG() > 0 && postData.bxz() != null && postData.bxz().size() > 0) {
                if (this.fxY == null) {
                    this.fxY = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fxY.setIsFromCDN(this.mIsFromCDN);
                    this.fxY.M(this.fxF);
                    if (this.fxw != null) {
                        this.fxY.B(this.fxw.bbh(), TextUtils.equals(this.fxw.baV().vw().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fxY.X(this.fxw.baV());
                    }
                }
                this.fxY.rI(postData.getId());
            }
            pVar.fza.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_link_tip_c));
            if (this.fxx) {
                pVar.fza.getLayoutStrategy().fQ(d.f.transparent_bg);
            } else {
                pVar.fza.getLayoutStrategy().fQ(d.f.icon_click);
            }
            pVar.fza.setIsFromCDN(this.mIsFromCDN);
            if (this.fxw != null && this.fxw.baV() != null && this.fxw.baV().isLinkThread()) {
                a(pVar, this.fxw.baV().wJ());
            }
            a(pVar, postData);
            TbRichText bxE = postData.bxE();
            if (this.fxw != null && this.fxw.bbt()) {
                bxE = null;
            }
            if (this.fyS || !this.fyT) {
                pVar.fza.setText(bxE, false, this.fxX);
            } else {
                pVar.fza.setText(bxE, true, this.fxX);
            }
            a(pVar, postData, bxE);
            boolean z7 = !StringUtils.isNull(postData.vw().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fxw != null && this.fxw.bbh() != 0) {
                z8 = true;
                z9 = true;
                if (postData.vw() != null) {
                    String userId = postData.vw().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fxw != null && this.fxw.baV() != null && this.fxw.baV().vw() != null && postData.vw() != null) {
                String userId2 = this.fxw.baV().vw().getUserId();
                String userId3 = postData.vw().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.vw() == null && UtilHelper.isCurrentAccount(postData.vw().getUserId())) {
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
                    if (postData.bxC() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.vw() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vw().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vw().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vw().getPortrait());
                        }
                        if (this.fxw != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxw.bbh()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vw() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vw().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vw().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vw().getName_show());
                        }
                        if (this.fxw != null && this.fxw.baV() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fxw.baV().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        if (this.fxw != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxw.bbh()));
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
            if (postData.vw() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bxC() == 1) {
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
            pVar.fza.setTag(sparseArray);
            pVar.fyg.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fza.setIsHost(true);
            if (this.fyR) {
                pVar.dRm.setVisibility(0);
            } else {
                pVar.dRm.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxx) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fza.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fza.setLayoutParams(layoutParams);
                pVar.fza.hX(null);
                this.fyU = false;
                a(pVar, postData, view, i);
            } else {
                this.fyU = true;
                pVar.fza.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void Os() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fza.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fza.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fze.setData(this.fxw.bbw());
            pVar.fze.setPageContext(this.fxh.getPageContext());
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bxP() == null) {
                pVar.fza.getLayoutStrategy().fU(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
            } else {
                pVar.fza.getLayoutStrategy().fU(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
            }
            pVar.fzf.f(postData.bxP());
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ae aeVar) {
        if (aeVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(aeVar.getLinkUrl()) && aeVar.us() == com.baidu.tbadk.core.data.ae.agL) {
            if (!aeVar.ut()) {
                pVar.fza.getLayoutStrategy().fU(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds48));
            }
            pVar.fzf.a(aeVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bhG() == null) {
            pVar.fyy.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(postData.bhG(), pVar.fyy, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fza.setTextViewOnTouchListener(this.fyV);
        pVar.fza.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ah - i, this.fxE);
            tbRichTextView.getLayoutStrategy().fO(min);
            tbRichTextView.getLayoutStrategy().fP((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fyg.setOnTouchListener(this.bfS);
        pVar.fyg.setOnLongClickListener(this.aHk);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fxh.getPageContext().getOrignalPage()).fvk;
        pVar.fza.setOnLongClickListener(this.aHk);
        pVar.fza.setOnTouchListener(this.fyV);
        pVar.fza.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fza.setOnImageClickListener(this.bfR);
        pVar.fza.setOnImageTouchListener(this.fyV);
        pVar.fza.setOnEmotionClickListener(aVar.fIJ);
        pVar.fyy.setOnClickListener(this.mCommonClickListener);
        pVar.fzf.a(this.fyW);
        pVar.fzf.K(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fxh.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fxh).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxw = dVar;
    }

    public void qs(int i) {
        this.fxE = i;
    }

    public void jH(boolean z) {
        this.fxx = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fxF = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bfR = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bfS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fxX = cVar;
    }

    public void jZ(boolean z) {
        this.fyR = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzf.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzf.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzf.pause();
        }
    }
}
