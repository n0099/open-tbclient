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
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class o extends k<PostData, p> {
    private TbRichTextView.h cAE;
    private com.baidu.tieba.pb.a.c cbY;
    private View.OnLongClickListener cdd;
    protected int hpA;
    private View.OnClickListener hpC;
    private TbRichTextView.c hpT;
    private com.baidu.tieba.pb.pb.sub.c hpU;
    protected com.baidu.tieba.pb.data.d hps;
    protected boolean hpt;
    private boolean hqL;
    private boolean hqM;
    private final boolean hqN;
    private boolean hqO;
    private com.baidu.tieba.pb.a.c hqP;
    private OriginalThreadCardView.a hqQ;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hpA = 0;
        this.hpt = true;
        this.hqL = true;
        this.hps = null;
        this.hpU = null;
        this.hpC = null;
        this.mCommonClickListener = null;
        this.cAE = null;
        this.cbY = null;
        this.cdd = null;
        this.hpT = null;
        this.hqM = false;
        this.hqN = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hqO = false;
        this.pageFromType = 0;
        this.hqP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.cbY != null) {
                    o.this.cbY.ci(view);
                    o.this.cbY.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hqQ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hps != null) {
                    String threadId = o.this.hps.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").bJ("tid", threadId).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).T("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bJb() != null) {
            this.pageFromType = pbActivity.bJb().bLA();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.l(pVar.bFo, d.C0236d.cp_bg_line_c);
                pVar.hqW.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_b));
                pVar.aaG.onChangeSkinType();
                if (pVar.hrb != null) {
                    pVar.hrb.onChangeSkinType();
                }
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.hpd.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.hpt, this.hpA);
        a(pVar);
        pVar.hra.wm(this.pageFromType);
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
            postData2.ZV();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hpd.getUniqueId(), this.hps, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hqM && this.hqN && pVar != null && pVar.hqW.atn() && (listView = ((PbActivity) this.hpd.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hqM = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04a6  */
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
        if (this.hps != null) {
            if (postData.cer() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hqW.setOnClickListener(this.mCommonClickListener);
                    pVar.hqW.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hqW.setOnClickListener(null);
                    pVar.hqW.setTextViewOnClickListener(null);
                }
                pVar.hpZ.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hpZ.setOnClickListener(null);
            }
            if (postData.cer() == 1) {
                pVar.b(this.hps, this.hpd.bIR());
                a(pVar.hqW, view, this.hqO);
                pVar.hqT.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.YR() != null) {
                    j = postData.YR().getUserIdLong();
                    str = postData.YR().getUserName();
                    str2 = postData.YR().getName_show();
                }
                if (this.hps != null && this.hps.bIa() != null) {
                    pVar.hra.a(postData.cez(), str, str2, j, com.baidu.adp.lib.g.b.d(this.hps.bIa().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.hpd.bJr().bNq()) {
                    pVar.hqW.setVisibility(8);
                }
                if (this.hps != null && this.hps.bIa() != null && this.hps.bIa().Zd() != null) {
                    bp Zd = this.hps.bIa().Zd();
                    Zd.getActivityUrl();
                    String aaU = Zd.aaU();
                    if (!StringUtils.isNull(Zd.aaV())) {
                        if (!StringUtils.isNull(aaU)) {
                            pVar.hqY.setVisibility(0);
                            pVar.hqY.startLoad(aaU, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hqY.setVisibility(8);
                }
                if (pVar.hqZ != null) {
                    pVar.hqZ.setVisibility(8);
                }
                if (this.hps != null && this.hps.bIa() != null && this.hps.bIa().ZL() && pVar.hrb != null) {
                    pVar.hrb.setPadding(pVar.hrb.getPaddingLeft(), com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds29), pVar.hrb.getPaddingRight(), pVar.hrb.getPaddingBottom());
                }
            }
            pVar.hqW.getLayoutStrategy().ky(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cer()));
            if (postData.cev() > 0 && postData.ceo() != null && postData.ceo().size() > 0) {
                if (this.hpU == null) {
                    this.hpU = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hpU.setIsFromCDN(this.mIsFromCDN);
                    this.hpU.M(this.hpC);
                    if (this.hps != null) {
                        this.hpU.H(this.hps.bIm(), TextUtils.equals(this.hps.bIa().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hpU.aj(this.hps.bIa());
                    }
                }
                this.hpU.Ao(postData.getId());
            }
            pVar.hqW.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_c));
            if (this.hpt) {
                pVar.hqW.getLayoutStrategy().kB(d.f.transparent_bg);
            } else {
                pVar.hqW.getLayoutStrategy().kB(d.f.icon_click);
            }
            pVar.hqW.setIsFromCDN(this.mIsFromCDN);
            if (this.hps != null && this.hps.bIa() != null && this.hps.bIa().isLinkThread()) {
                a(pVar, this.hps.bIa().aaq());
            }
            a(pVar, postData);
            TbRichText cet = postData.cet();
            if (this.hps != null && this.hps.bIy()) {
                cet = null;
            }
            if (this.hqM || !this.hqN) {
                pVar.hqW.setText(cet, false, this.hpT);
            } else {
                pVar.hqW.setText(cet, true, this.hpT);
            }
            a(pVar, postData, cet);
            boolean z7 = !StringUtils.isNull(postData.YR().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hps != null && this.hps.bIm() != 0) {
                if (this.hps.bIm() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.YR() != null) {
                    String userId = postData.YR().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hps != null && this.hps.bIa() != null && this.hps.bIa().YR() != null && postData.YR() != null) {
                String userId2 = this.hps.bIa().YR().getUserId();
                String userId3 = postData.YR().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.YR() == null && UtilHelper.isCurrentAccount(postData.YR().getUserId())) {
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
                    if (postData.cer() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.YR() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.YR().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.YR().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.YR().getPortrait());
                        }
                        if (this.hps != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hps.bIm()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.YR() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YR().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.YR().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YR().getName_show());
                        }
                        if (this.hps != null && this.hps.bIa() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hps.bIa().getId());
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
                        if (this.hps != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hps.bIm()));
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
            if (postData.YR() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.cer() == 1) {
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

    private void b(final p pVar, final PostData postData, final View view, final int i) {
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.hqW.setTag(sparseArray);
            pVar.hpZ.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.hqW.setIsHost(true);
            if (this.hqL) {
                pVar.bFo.setVisibility(0);
            } else {
                pVar.bFo.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpt) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hqW.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hqW.setLayoutParams(layoutParams);
                pVar.hqW.qd(null);
                this.hqO = false;
                a(pVar, postData, view, i);
            } else {
                this.hqO = true;
                pVar.hqW.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void ats() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hqW.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hqW.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hps != null && this.hps.bIa() != null && this.hps.bIa().ZL() && this.hps.bIa().Zi() != null && com.baidu.tbadk.core.util.ap.isEmpty(this.hps.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds28));
            } else if (postData.cet() == null || com.baidu.tbadk.core.util.v.T(postData.cet().asx())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cet() != null) {
                if (postData.cet().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.aaG.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.tbds26);
                    pVar.aaG.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.aaG.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.tbds16);
                    pVar.aaG.setLayoutParams(layoutParams3);
                }
            }
            if (this.hps.bIa() != null && this.hps.bIa().ZD() != null) {
                pVar.aaG.setVisibility(0);
                pVar.aaG.setData(this.hps.bIa().ZD());
                if (this.hps.getForum() != null) {
                    pVar.aaG.setForumId(String.valueOf(this.hps.getForum().getId()));
                }
                AppletsCellView appletsCellView = pVar.aaG;
                AppletsCellView appletsCellView2 = pVar.aaG;
                appletsCellView.setFrom("PB_card");
            }
            if (this.hps == null || this.hps.bIa() == null) {
                return;
            }
            if (this.hps.bIa().Zg() != 0 || this.hps.bIa().ZL()) {
                pVar.U(this.hps.bIa().YN() == 1, this.hps.bIa().YM() == 1);
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.ceC() == null) {
                pVar.hqW.getLayoutStrategy().kH(oO(d.e.tbds24));
            } else {
                pVar.hqW.getLayoutStrategy().kH(oO(d.e.tbds14));
            }
            pVar.hra.f(postData.ceC());
        }
    }

    private int oO(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl()) && afVar.Xy() == com.baidu.tbadk.core.data.af.bzf) {
            if (!afVar.Xz()) {
                pVar.hqW.getLayoutStrategy().kH(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds48));
            }
            pVar.hra.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bOO() == null) {
            pVar.hqs.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bOO(), pVar.hqs, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hqW.setTextViewOnTouchListener(this.hqP);
        pVar.hqW.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(aO - i, this.hpA);
            tbRichTextView.getLayoutStrategy().kz(min);
            tbRichTextView.getLayoutStrategy().kA((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hpZ.setOnTouchListener(this.cbY);
        pVar.hpZ.setOnLongClickListener(this.cdd);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hpd.getPageContext().getOrignalPage()).hne;
        pVar.hqW.setOnLongClickListener(this.cdd);
        pVar.hqW.setOnTouchListener(this.hqP);
        pVar.hqW.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hqW.setOnImageClickListener(this.cAE);
        pVar.hqW.setOnImageTouchListener(this.hqP);
        pVar.hqW.setOnEmotionClickListener(aVar.hAn);
        pVar.hqs.setOnClickListener(this.mCommonClickListener);
        pVar.hra.a(this.hqQ);
        pVar.hrb.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hps = dVar;
    }

    public void wa(int i) {
        this.hpA = i;
    }

    public void nc(boolean z) {
        this.hpt = z;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpC = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cbY = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hpT = cVar;
    }

    public void nu(boolean z) {
        this.hqL = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hra.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hra.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hra.pause();
        }
    }

    public p bKE() {
        return (p) this.viewholder;
    }
}
