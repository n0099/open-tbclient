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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class o extends k<PostData, p> implements View.OnClickListener {
    private View.OnLongClickListener aHj;
    private TbRichTextView.h bge;
    private com.baidu.tieba.pb.a.c bgf;
    protected com.baidu.tieba.pb.data.d fxB;
    protected boolean fxC;
    protected int fxJ;
    private View.OnClickListener fxK;
    private boolean fyW;
    private boolean fyX;
    private final boolean fyY;
    private boolean fyZ;
    private TbRichTextView.c fyc;
    private com.baidu.tieba.pb.pb.sub.c fyd;
    private com.baidu.tieba.pb.a.c fza;
    private OriginalThreadCardView.a fzb;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fxJ = 0;
        this.fxC = true;
        this.fyW = true;
        this.fxB = null;
        this.fyd = null;
        this.fxK = null;
        this.mCommonClickListener = null;
        this.bge = null;
        this.bgf = null;
        this.aHj = null;
        this.fyc = null;
        this.fyX = false;
        this.fyY = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fyZ = false;
        this.pageFromType = 0;
        this.fza = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bgf != null) {
                    o.this.bgf.ba(view);
                    o.this.bgf.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fzb = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fxB != null) {
                    String threadId = o.this.fxB.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").ae("tid", threadId).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).r("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bao() != null) {
            this.pageFromType = pbActivity.bao().bcJ();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.j(pVar.dTU, f.d.cp_bg_line_c);
                pVar.fzf.setTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_cont_b));
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fxm.getPageContext(), LayoutInflater.from(this.mContext).inflate(f.h.new_pb_list_first_floor_item, viewGroup, false), this.fxC, this.fxJ);
        a(pVar);
        pVar.fzk.qC(this.pageFromType);
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
            postData2.we();
            b(pVar, postData2, view, i);
        }
        if (!this.fyX && this.fyY && pVar != null && pVar.fzf.Om() && (listView = ((PbActivity) this.fxm.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fyX = true;
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
        if (this.fxB != null) {
            if (postData.bwg() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fzf.setOnClickListener(this.mCommonClickListener);
                    pVar.fzf.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fzf.setOnClickListener(null);
                    pVar.fzf.setTextViewOnClickListener(null);
                }
                pVar.fyl.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fyl.setOnClickListener(null);
            }
            if (postData.bwg() == 1) {
                pVar.fzk.a(this.fxB, this.fxm.bbp(), this.mContext);
                a(pVar.fzf, view, this.fyZ);
                pVar.fze.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vj() != null) {
                    j = postData.vj().getUserIdLong();
                    str = postData.vj().getUserName();
                    str2 = postData.vj().getName_show();
                }
                if (this.fxB != null && this.fxB.aZi() != null) {
                    pVar.fzk.a(postData.bwo(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fxB.aZi().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                if (this.fxm.baF().beB()) {
                    pVar.fzf.setVisibility(8);
                }
                if (this.fxB != null && this.fxB.aZi() != null && this.fxB.aZi().vw() != null) {
                    bk vw = this.fxB.aZi().vw();
                    vw.getActivityUrl();
                    String wY = vw.wY();
                    if (!StringUtils.isNull(vw.wZ())) {
                        if (!StringUtils.isNull(wY)) {
                            pVar.fzh.setVisibility(0);
                            pVar.fzh.startLoad(wY, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fzh.setVisibility(8);
                }
                if (pVar.fzi != null) {
                    pVar.fzi.setVisibility(8);
                }
            }
            pVar.fzf.getLayoutStrategy().fN(f.C0146f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(f.g.tag_clip_board, postData);
            sparseArray.put(f.g.tag_load_sub_data, postData);
            sparseArray.put(f.g.tag_load_sub_view, view);
            sparseArray.put(f.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(f.g.tag_pb_floor_number, Integer.valueOf(postData.bwg()));
            if (postData.bwk() > 0 && postData.bwd() != null && postData.bwd().size() > 0) {
                if (this.fyd == null) {
                    this.fyd = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fyd.setIsFromCDN(this.mIsFromCDN);
                    this.fyd.K(this.fxK);
                    if (this.fxB != null) {
                        this.fyd.A(this.fxB.aZu(), TextUtils.equals(this.fxB.aZi().vj().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fyd.Z(this.fxB.aZi());
                    }
                }
                this.fyd.rF(postData.getId());
            }
            pVar.fzf.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_link_tip_c));
            if (this.fxC) {
                pVar.fzf.getLayoutStrategy().fQ(f.C0146f.transparent_bg);
            } else {
                pVar.fzf.getLayoutStrategy().fQ(f.C0146f.icon_click);
            }
            pVar.fzf.setIsFromCDN(this.mIsFromCDN);
            if (this.fxB != null && this.fxB.aZi() != null && this.fxB.aZi().isLinkThread()) {
                a(pVar, this.fxB.aZi().wx());
            }
            a(pVar, postData);
            TbRichText bwi = postData.bwi();
            if (this.fxB != null && this.fxB.aZH()) {
                bwi = null;
            }
            if (this.fyX || !this.fyY) {
                pVar.fzf.setText(bwi, false, this.fyc);
            } else {
                pVar.fzf.setText(bwi, true, this.fyc);
            }
            a(pVar, postData, bwi);
            boolean z7 = !StringUtils.isNull(postData.vj().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fxB != null && this.fxB.aZu() != 0) {
                z8 = true;
                z9 = true;
                if (postData.vj() != null) {
                    String userId = postData.vj().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fxB != null && this.fxB.aZi() != null && this.fxB.aZi().vj() != null && postData.vj() != null) {
                String userId2 = this.fxB.aZi().vj().getUserId();
                String userId3 = postData.vj().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.vj() == null && UtilHelper.isCurrentAccount(postData.vj().getUserId())) {
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
                    if (postData.bwg() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(f.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(f.g.tag_should_manage_visible, true);
                        if (postData.vj() != null) {
                            sparseArray.put(f.g.tag_forbid_user_name, postData.vj().getUserName());
                            sparseArray.put(f.g.tag_forbid_user_name_show, postData.vj().getName_show());
                            sparseArray.put(f.g.tag_forbid_user_portrait, postData.vj().getPortrait());
                        }
                        if (this.fxB != null) {
                            sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(this.fxB.aZu()));
                        }
                    } else {
                        sparseArray.put(f.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(f.g.tag_user_mute_visible, true);
                        sparseArray.put(f.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vj() != null) {
                            sparseArray.put(f.g.tag_user_mute_mute_userid, postData.vj().getUserId());
                            sparseArray.put(f.g.tag_user_mute_mute_username, postData.vj().getUserName());
                            sparseArray.put(f.g.tag_user_mute_mute_nameshow, postData.vj().getName_show());
                        }
                        if (this.fxB != null && this.fxB.aZi() != null) {
                            sparseArray.put(f.g.tag_user_mute_thread_id, this.fxB.aZi().getId());
                        }
                        sparseArray.put(f.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(f.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(f.g.tag_should_delete_visible, true);
                        sparseArray.put(f.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(f.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(f.g.tag_del_post_id, postData.getId());
                        if (this.fxB != null) {
                            sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(this.fxB.aZu()));
                        }
                    } else {
                        sparseArray.put(f.g.tag_should_delete_visible, false);
                    }
                    b(pVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.vj() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bwg() == 1) {
            }
            sparseArray.put(f.g.tag_forbid_user_post_id, postData.getId());
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
            pVar.fzf.setTag(sparseArray);
            pVar.fyl.setTag(f.g.tag_from, sparseArray);
            sparseArray.put(f.g.tag_clip_board, postData);
            sparseArray.put(f.g.tag_is_subpb, false);
            pVar.fzf.setIsHost(true);
            if (this.fyW) {
                pVar.dTU.setVisibility(0);
            } else {
                pVar.dTU.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxC) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fzf.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fzf.setLayoutParams(layoutParams);
                pVar.fzf.hV(null);
                this.fyZ = false;
                a(pVar, postData, view, i);
            } else {
                this.fyZ = true;
                pVar.fzf.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void Or() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fzf.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(f.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(f.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fzf.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fzj.setData(this.fxB.aZK());
            pVar.fzj.setPageContext(this.fxm.getPageContext());
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bwt() == null) {
                pVar.fzf.getLayoutStrategy().fV(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds44));
            } else {
                pVar.fzf.getLayoutStrategy().fV(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds34));
            }
            pVar.fzk.f(postData.bwt());
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(adVar.getLinkUrl()) && adVar.ue() == com.baidu.tbadk.core.data.ad.agf) {
            if (!adVar.uf()) {
                pVar.fzf.getLayoutStrategy().fV(com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds48));
            }
            pVar.fzk.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bfU() == null) {
            pVar.fyD.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.d.a(postData.bfU(), pVar.fyD, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fzf.setTextViewOnTouchListener(this.fza);
        pVar.fzf.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ah = (((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(f.e.ds80);
            }
            int min = Math.min(ah - i, this.fxJ);
            tbRichTextView.getLayoutStrategy().fO(min);
            tbRichTextView.getLayoutStrategy().fP((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fyl.setOnTouchListener(this.bgf);
        pVar.fyl.setOnLongClickListener(this.aHj);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fxm.getPageContext().getOrignalPage()).fvp;
        pVar.fzf.setOnLongClickListener(this.aHj);
        pVar.fzf.setOnTouchListener(this.fza);
        pVar.fzf.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fzf.setOnImageClickListener(this.bge);
        pVar.fzf.setOnImageTouchListener(this.fza);
        pVar.fzf.setOnEmotionClickListener(aVar.fIR);
        pVar.fyD.setOnClickListener(this.mCommonClickListener);
        pVar.fzk.a(this.fzb);
        pVar.fzk.I(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == f.g.view_forum1 || id == f.g.view_forum2 || id == f.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fxm.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fxm).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxB = dVar;
    }

    public void qp(int i) {
        this.fxJ = i;
    }

    public void jt(boolean z) {
        this.fxC = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fxK = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bge = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bgf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHj = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fyc = cVar;
    }

    public void jL(boolean z) {
        this.fyW = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzk.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzk.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fzk.pause();
        }
    }
}
