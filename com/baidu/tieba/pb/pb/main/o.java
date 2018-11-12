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
    private View.OnLongClickListener aPP;
    private TbRichTextView.h bop;
    private com.baidu.tieba.pb.a.c boq;
    protected int fOB;
    private View.OnClickListener fOC;
    private TbRichTextView.c fOR;
    private com.baidu.tieba.pb.pb.sub.c fOS;
    protected com.baidu.tieba.pb.data.d fOt;
    protected boolean fOu;
    private boolean fPI;
    private boolean fPJ;
    private final boolean fPK;
    private boolean fPL;
    private com.baidu.tieba.pb.a.c fPM;
    private OriginalThreadCardView.a fPN;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fOB = 0;
        this.fOu = true;
        this.fPI = true;
        this.fOt = null;
        this.fOS = null;
        this.fOC = null;
        this.mCommonClickListener = null;
        this.bop = null;
        this.boq = null;
        this.aPP = null;
        this.fOR = null;
        this.fPJ = false;
        this.fPK = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fPL = false;
        this.pageFromType = 0;
        this.fPM = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.boq != null) {
                    o.this.boq.bq(view);
                    o.this.boq.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fPN = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fOt != null) {
                    String threadId = o.this.fOt.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").ax("tid", threadId).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).x("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bfx() != null) {
            this.pageFromType = pbActivity.bfx().bhR();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.j(pVar.ekB, e.d.cp_bg_line_c);
                pVar.fPS.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                pVar.dKS.onChangeSkinType();
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fOe.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_first_floor_item, viewGroup, false), this.fOu, this.fOB);
        a(pVar);
        pVar.fPX.rS(this.pageFromType);
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
            postData2.zz();
            b(pVar, postData2, view, i);
        }
        if (!this.fPJ && this.fPK && pVar != null && pVar.fPS.RJ() && (listView = ((PbActivity) this.fOe.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fPJ = true;
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
        if (this.fOt != null) {
            if (postData.bBx() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fPS.setOnClickListener(this.mCommonClickListener);
                    pVar.fPS.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fPS.setOnClickListener(null);
                    pVar.fPS.setTextViewOnClickListener(null);
                }
                pVar.fOX.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fOX.setOnClickListener(null);
            }
            if (postData.bBx() == 1) {
                pVar.fPX.a(this.fOt, this.fOe.bfn(), this.mContext);
                a(pVar.fPS, view, this.fPL);
                pVar.fPR.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.yC() != null) {
                    j = postData.yC().getUserIdLong();
                    str = postData.yC().getUserName();
                    str2 = postData.yC().getName_show();
                }
                if (this.fOt != null && this.fOt.bet() != null) {
                    pVar.fPX.a(postData.bBF(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fOt.bet().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.fOe.bfO().bjJ()) {
                    pVar.fPS.setVisibility(8);
                }
                if (this.fOt != null && this.fOt.bet() != null && this.fOt.bet().yP() != null) {
                    bk yP = this.fOt.bet().yP();
                    yP.getActivityUrl();
                    String Av = yP.Av();
                    if (!StringUtils.isNull(yP.Aw())) {
                        if (!StringUtils.isNull(Av)) {
                            pVar.fPU.setVisibility(0);
                            pVar.fPU.startLoad(Av, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fPU.setVisibility(8);
                }
                if (pVar.fPV != null) {
                    pVar.fPV.setVisibility(8);
                }
            }
            pVar.fPS.getLayoutStrategy().gv(e.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bBx()));
            if (postData.bBB() > 0 && postData.bBu() != null && postData.bBu().size() > 0) {
                if (this.fOS == null) {
                    this.fOS = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fOS.setIsFromCDN(this.mIsFromCDN);
                    this.fOS.M(this.fOC);
                    if (this.fOt != null) {
                        this.fOS.B(this.fOt.beF(), TextUtils.equals(this.fOt.bet().yC().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fOS.aa(this.fOt.bet());
                    }
                }
                this.fOS.sN(postData.getId());
            }
            pVar.fPS.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            if (this.fOu) {
                pVar.fPS.getLayoutStrategy().gy(e.f.transparent_bg);
            } else {
                pVar.fPS.getLayoutStrategy().gy(e.f.icon_click);
            }
            pVar.fPS.setIsFromCDN(this.mIsFromCDN);
            if (this.fOt != null && this.fOt.bet() != null && this.fOt.bet().isLinkThread()) {
                a(pVar, this.fOt.bet().zU());
            }
            a(pVar, postData);
            TbRichText bBz = postData.bBz();
            if (this.fOt != null && this.fOt.beS()) {
                bBz = null;
            }
            if (this.fPJ || !this.fPK) {
                pVar.fPS.setText(bBz, false, this.fOR);
            } else {
                pVar.fPS.setText(bBz, true, this.fOR);
            }
            a(pVar, postData, bBz);
            boolean z7 = !StringUtils.isNull(postData.yC().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fOt != null && this.fOt.beF() != 0) {
                z8 = true;
                z9 = true;
                if (postData.yC() != null) {
                    String userId = postData.yC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fOt != null && this.fOt.bet() != null && this.fOt.bet().yC() != null && postData.yC() != null) {
                String userId2 = this.fOt.bet().yC().getUserId();
                String userId3 = postData.yC().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.yC() == null && UtilHelper.isCurrentAccount(postData.yC().getUserId())) {
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
                    if (postData.bBx() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        if (postData.yC() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yC().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yC().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yC().getPortrait());
                        }
                        if (this.fOt != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fOt.beF()));
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yC() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yC().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.yC().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yC().getName_show());
                        }
                        if (this.fOt != null && this.fOt.bet() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fOt.bet().getId());
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
                        if (this.fOt != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fOt.beF()));
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
            if (postData.yC() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bBx() == 1) {
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
            pVar.fPS.setTag(sparseArray);
            pVar.fOX.setTag(e.g.tag_from, sparseArray);
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            pVar.fPS.setIsHost(true);
            if (this.fPI) {
                pVar.ekB.setVisibility(0);
            } else {
                pVar.ekB.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fOu) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fPS.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fPS.setLayoutParams(layoutParams);
                pVar.fPS.iI(null);
                this.fPL = false;
                a(pVar, postData, view, i);
            } else {
                this.fPL = true;
                pVar.fPS.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void RO() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fPS.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(e.C0200e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(e.C0200e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fPS.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fPW.setData(this.fOt.beV());
            pVar.fPW.setPageContext(this.fOe.getPageContext());
            if (postData.bBz() != null) {
                if (postData.bBz().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.dKS.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(e.C0200e.tbds26);
                    pVar.dKS.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.dKS.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(e.C0200e.tbds16);
                    pVar.dKS.setLayoutParams(layoutParams3);
                }
            }
            if (this.fOt.bet() != null && this.fOt.bet().zi() != null) {
                pVar.dKS.setVisibility(0);
                pVar.dKS.setData(this.fOt.bet().zi());
                if (this.fOt.ber() != null) {
                    pVar.dKS.setForumId(String.valueOf(this.fOt.ber().getId()));
                }
                AppletsCellView appletsCellView = pVar.dKS;
                AppletsCellView appletsCellView2 = pVar.dKS;
                appletsCellView.setFrom("PB_card");
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bBI() == null) {
                pVar.fPS.getLayoutStrategy().gD(kI(e.C0200e.tbds24));
            } else {
                pVar.fPS.getLayoutStrategy().gD(kI(e.C0200e.tbds14));
            }
            pVar.fPX.f(postData.bBI());
        }
    }

    private int kI(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl()) && adVar.xy() == com.baidu.tbadk.core.data.ad.aon) {
            if (!adVar.xz()) {
                pVar.fPS.getLayoutStrategy().gD(com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds48));
            }
            pVar.fPX.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.blf() == null) {
            pVar.fPq.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.c.a(postData.blf(), pVar.fPq, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fPS.setTextViewOnTouchListener(this.fPM);
        pVar.fPS.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(e.C0200e.ds80);
            }
            int min = Math.min(aO - i, this.fOB);
            tbRichTextView.getLayoutStrategy().gw(min);
            tbRichTextView.getLayoutStrategy().gx((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fOX.setOnTouchListener(this.boq);
        pVar.fOX.setOnLongClickListener(this.aPP);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fOe.getPageContext().getOrignalPage()).fMi;
        pVar.fPS.setOnLongClickListener(this.aPP);
        pVar.fPS.setOnTouchListener(this.fPM);
        pVar.fPS.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fPS.setOnImageClickListener(this.bop);
        pVar.fPS.setOnImageTouchListener(this.fPM);
        pVar.fPS.setOnEmotionClickListener(aVar.fZx);
        pVar.fPq.setOnClickListener(this.mCommonClickListener);
        pVar.fPX.a(this.fPN);
        pVar.fPX.K(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == e.g.view_forum1 || id == e.g.view_forum2 || id == e.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fOe.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fOe).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fOt = dVar;
    }

    public void setImageMaxWidth(int i) {
        this.fOB = i;
    }

    public void kw(boolean z) {
        this.fOu = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fOC = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bop = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.boq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fOR = cVar;
    }

    public void kN(boolean z) {
        this.fPI = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fPX.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fPX.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fPX.pause();
        }
    }
}
