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
    private TbRichTextView.h bgd;
    private com.baidu.tieba.pb.a.c bge;
    protected com.baidu.tieba.pb.data.d fxI;
    protected boolean fxJ;
    protected int fxQ;
    private View.OnClickListener fxR;
    private TbRichTextView.c fyj;
    private com.baidu.tieba.pb.pb.sub.c fyk;
    private boolean fzd;
    private boolean fze;
    private final boolean fzf;
    private boolean fzg;
    private com.baidu.tieba.pb.a.c fzh;
    private OriginalThreadCardView.a fzi;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fxQ = 0;
        this.fxJ = true;
        this.fzd = true;
        this.fxI = null;
        this.fyk = null;
        this.fxR = null;
        this.mCommonClickListener = null;
        this.bgd = null;
        this.bge = null;
        this.aHk = null;
        this.fyj = null;
        this.fze = false;
        this.fzf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fzg = false;
        this.pageFromType = 0;
        this.fzh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bge != null) {
                    o.this.bge.ba(view);
                    o.this.bge.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fzi = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fxI != null) {
                    String threadId = o.this.fxI.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").af("tid", threadId).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).r("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bat() != null) {
            this.pageFromType = pbActivity.bat().bcO();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.j(pVar.dTZ, d.C0140d.cp_bg_line_c);
                pVar.fzm.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_cont_b));
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fxt.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.fxJ, this.fxQ);
        a(pVar);
        pVar.fzr.qC(this.pageFromType);
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
            postData2.wf();
            b(pVar, postData2, view, i);
        }
        if (!this.fze && this.fzf && pVar != null && pVar.fzm.On() && (listView = ((PbActivity) this.fxt.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fze = true;
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
        if (this.fxI != null) {
            if (postData.bwf() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fzm.setOnClickListener(this.mCommonClickListener);
                    pVar.fzm.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fzm.setOnClickListener(null);
                    pVar.fzm.setTextViewOnClickListener(null);
                }
                pVar.fys.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fys.setOnClickListener(null);
            }
            if (postData.bwf() == 1) {
                pVar.fzr.a(this.fxI, this.fxt.bbu(), this.mContext);
                a(pVar.fzm, view, this.fzg);
                pVar.fzl.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vk() != null) {
                    j = postData.vk().getUserIdLong();
                    str = postData.vk().getUserName();
                    str2 = postData.vk().getName_show();
                }
                if (this.fxI != null && this.fxI.aZn() != null) {
                    pVar.fzr.a(postData.bwn(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fxI.aZn().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                if (this.fxt.baK().beG()) {
                    pVar.fzm.setVisibility(8);
                }
                if (this.fxI != null && this.fxI.aZn() != null && this.fxI.aZn().vx() != null) {
                    bk vx = this.fxI.aZn().vx();
                    vx.getActivityUrl();
                    String wZ = vx.wZ();
                    if (!StringUtils.isNull(vx.xa())) {
                        if (!StringUtils.isNull(wZ)) {
                            pVar.fzo.setVisibility(0);
                            pVar.fzo.startLoad(wZ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fzo.setVisibility(8);
                }
                if (pVar.fzp != null) {
                    pVar.fzp.setVisibility(8);
                }
            }
            pVar.fzm.getLayoutStrategy().fO(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bwf()));
            if (postData.bwj() > 0 && postData.bwc() != null && postData.bwc().size() > 0) {
                if (this.fyk == null) {
                    this.fyk = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fyk.setIsFromCDN(this.mIsFromCDN);
                    this.fyk.K(this.fxR);
                    if (this.fxI != null) {
                        this.fyk.A(this.fxI.aZz(), TextUtils.equals(this.fxI.aZn().vk().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fyk.Z(this.fxI.aZn());
                    }
                }
                this.fyk.rC(postData.getId());
            }
            pVar.fzm.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_link_tip_c));
            if (this.fxJ) {
                pVar.fzm.getLayoutStrategy().fR(d.f.transparent_bg);
            } else {
                pVar.fzm.getLayoutStrategy().fR(d.f.icon_click);
            }
            pVar.fzm.setIsFromCDN(this.mIsFromCDN);
            if (this.fxI != null && this.fxI.aZn() != null && this.fxI.aZn().isLinkThread()) {
                a(pVar, this.fxI.aZn().wy());
            }
            a(pVar, postData);
            TbRichText bwh = postData.bwh();
            if (this.fxI != null && this.fxI.aZM()) {
                bwh = null;
            }
            if (this.fze || !this.fzf) {
                pVar.fzm.setText(bwh, false, this.fyj);
            } else {
                pVar.fzm.setText(bwh, true, this.fyj);
            }
            a(pVar, postData, bwh);
            boolean z7 = !StringUtils.isNull(postData.vk().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fxI != null && this.fxI.aZz() != 0) {
                z8 = true;
                z9 = true;
                if (postData.vk() != null) {
                    String userId = postData.vk().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fxI != null && this.fxI.aZn() != null && this.fxI.aZn().vk() != null && postData.vk() != null) {
                String userId2 = this.fxI.aZn().vk().getUserId();
                String userId3 = postData.vk().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.vk() == null && UtilHelper.isCurrentAccount(postData.vk().getUserId())) {
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
                    if (postData.bwf() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.vk() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vk().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vk().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vk().getPortrait());
                        }
                        if (this.fxI != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxI.aZz()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vk() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vk().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vk().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vk().getName_show());
                        }
                        if (this.fxI != null && this.fxI.aZn() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fxI.aZn().getId());
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
                        if (this.fxI != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fxI.aZz()));
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
            if (postData.vk() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bwf() == 1) {
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
            pVar.fzm.setTag(sparseArray);
            pVar.fys.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.fzm.setIsHost(true);
            if (this.fzd) {
                pVar.dTZ.setVisibility(0);
            } else {
                pVar.dTZ.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxJ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fzm.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fzm.setLayoutParams(layoutParams);
                pVar.fzm.hU(null);
                this.fzg = false;
                a(pVar, postData, view, i);
            } else {
                this.fzg = true;
                pVar.fzm.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void Os() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fzm.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fzm.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fzq.setData(this.fxI.aZP());
            pVar.fzq.setPageContext(this.fxt.getPageContext());
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bws() == null) {
                pVar.fzm.getLayoutStrategy().fW(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds44));
            } else {
                pVar.fzm.getLayoutStrategy().fW(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
            }
            pVar.fzr.f(postData.bws());
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(adVar.getLinkUrl()) && adVar.uf() == com.baidu.tbadk.core.data.ad.agf) {
            if (!adVar.ug()) {
                pVar.fzm.getLayoutStrategy().fW(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds48));
            }
            pVar.fzr.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bfZ() == null) {
            pVar.fyK.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(postData.bfZ(), pVar.fyK, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fzm.setTextViewOnTouchListener(this.fzh);
        pVar.fzm.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ah - i, this.fxQ);
            tbRichTextView.getLayoutStrategy().fP(min);
            tbRichTextView.getLayoutStrategy().fQ((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fys.setOnTouchListener(this.bge);
        pVar.fys.setOnLongClickListener(this.aHk);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fxt.getPageContext().getOrignalPage()).fvw;
        pVar.fzm.setOnLongClickListener(this.aHk);
        pVar.fzm.setOnTouchListener(this.fzh);
        pVar.fzm.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fzm.setOnImageClickListener(this.bgd);
        pVar.fzm.setOnImageTouchListener(this.fzh);
        pVar.fzm.setOnEmotionClickListener(aVar.fIY);
        pVar.fyK.setOnClickListener(this.mCommonClickListener);
        pVar.fzr.a(this.fzi);
        pVar.fzr.I(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == d.g.view_forum1 || id == d.g.view_forum2 || id == d.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fxt.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fxt).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxI = dVar;
    }

    public void qp(int i) {
        this.fxQ = i;
    }

    public void jt(boolean z) {
        this.fxJ = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fxR = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bgd = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bge = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fyj = cVar;
    }

    public void jL(boolean z) {
        this.fzd = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzr.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzr.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzr.pause();
        }
    }
}
