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
    private com.baidu.tieba.pb.a.c ccb;
    private View.OnLongClickListener cdg;
    protected com.baidu.tieba.pb.data.d hoZ;
    private TbRichTextView.c hpA;
    private com.baidu.tieba.pb.pb.sub.c hpB;
    protected boolean hpa;
    protected int hph;
    private View.OnClickListener hpj;
    private boolean hqs;
    private boolean hqt;
    private final boolean hqu;
    private boolean hqv;
    private com.baidu.tieba.pb.a.c hqw;
    private OriginalThreadCardView.a hqx;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hph = 0;
        this.hpa = true;
        this.hqs = true;
        this.hoZ = null;
        this.hpB = null;
        this.hpj = null;
        this.mCommonClickListener = null;
        this.cAE = null;
        this.ccb = null;
        this.cdg = null;
        this.hpA = null;
        this.hqt = false;
        this.hqu = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hqv = false;
        this.pageFromType = 0;
        this.hqw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.ccb != null) {
                    o.this.ccb.ci(view);
                    o.this.ccb.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hqx = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hoZ != null) {
                    String threadId = o.this.hoZ.getThreadId();
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
        if (pbActivity != null && pbActivity.bIX() != null) {
            this.pageFromType = pbActivity.bIX().bLw();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.l(pVar.bFt, d.C0277d.cp_bg_line_c);
                pVar.hqD.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_b));
                pVar.aaJ.onChangeSkinType();
                if (pVar.hqI != null) {
                    pVar.hqI.onChangeSkinType();
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
        p pVar = new p(this.hoK.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.hpa, this.hph);
        a(pVar);
        pVar.hqH.wi(this.pageFromType);
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
            postData2.ZS();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hoK.getUniqueId(), this.hoZ, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hqt && this.hqu && pVar != null && pVar.hqD.atj() && (listView = ((PbActivity) this.hoK.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hqt = true;
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
        if (this.hoZ != null) {
            if (postData.cep() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hqD.setOnClickListener(this.mCommonClickListener);
                    pVar.hqD.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hqD.setOnClickListener(null);
                    pVar.hqD.setTextViewOnClickListener(null);
                }
                pVar.hpG.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hpG.setOnClickListener(null);
            }
            if (postData.cep() == 1) {
                pVar.b(this.hoZ, this.hoK.bIN());
                a(pVar.hqD, view, this.hqv);
                pVar.hqA.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.YO() != null) {
                    j = postData.YO().getUserIdLong();
                    str = postData.YO().getUserName();
                    str2 = postData.YO().getName_show();
                }
                if (this.hoZ != null && this.hoZ.bHW() != null) {
                    pVar.hqH.a(postData.cex(), str, str2, j, com.baidu.adp.lib.g.b.d(this.hoZ.bHW().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.hoK.bJn().bNn()) {
                    pVar.hqD.setVisibility(8);
                }
                if (this.hoZ != null && this.hoZ.bHW() != null && this.hoZ.bHW().Za() != null) {
                    bp Za = this.hoZ.bHW().Za();
                    Za.getActivityUrl();
                    String aaR = Za.aaR();
                    if (!StringUtils.isNull(Za.aaS())) {
                        if (!StringUtils.isNull(aaR)) {
                            pVar.hqF.setVisibility(0);
                            pVar.hqF.startLoad(aaR, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hqF.setVisibility(8);
                }
                if (pVar.hqG != null) {
                    pVar.hqG.setVisibility(8);
                }
                if (this.hoZ != null && this.hoZ.bHW() != null && this.hoZ.bHW().ZI() && pVar.hqI != null) {
                    pVar.hqI.setPadding(pVar.hqI.getPaddingLeft(), com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds29), pVar.hqI.getPaddingRight(), pVar.hqI.getPaddingBottom());
                }
            }
            pVar.hqD.getLayoutStrategy().kx(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cep()));
            if (postData.cet() > 0 && postData.cem() != null && postData.cem().size() > 0) {
                if (this.hpB == null) {
                    this.hpB = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hpB.setIsFromCDN(this.mIsFromCDN);
                    this.hpB.M(this.hpj);
                    if (this.hoZ != null) {
                        this.hpB.H(this.hoZ.bIi(), TextUtils.equals(this.hoZ.bHW().YO().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hpB.ai(this.hoZ.bHW());
                    }
                }
                this.hpB.Al(postData.getId());
            }
            pVar.hqD.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            if (this.hpa) {
                pVar.hqD.getLayoutStrategy().kA(d.f.transparent_bg);
            } else {
                pVar.hqD.getLayoutStrategy().kA(d.f.icon_click);
            }
            pVar.hqD.setIsFromCDN(this.mIsFromCDN);
            if (this.hoZ != null && this.hoZ.bHW() != null && this.hoZ.bHW().isLinkThread()) {
                a(pVar, this.hoZ.bHW().aan());
            }
            a(pVar, postData);
            TbRichText cer = postData.cer();
            if (this.hoZ != null && this.hoZ.bIu()) {
                cer = null;
            }
            if (this.hqt || !this.hqu) {
                pVar.hqD.setText(cer, false, this.hpA);
            } else {
                pVar.hqD.setText(cer, true, this.hpA);
            }
            a(pVar, postData, cer);
            boolean z7 = !StringUtils.isNull(postData.YO().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hoZ != null && this.hoZ.bIi() != 0) {
                if (this.hoZ.bIi() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.YO() != null) {
                    String userId = postData.YO().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hoZ != null && this.hoZ.bHW() != null && this.hoZ.bHW().YO() != null && postData.YO() != null) {
                String userId2 = this.hoZ.bHW().YO().getUserId();
                String userId3 = postData.YO().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.YO() == null && UtilHelper.isCurrentAccount(postData.YO().getUserId())) {
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
                    if (postData.cep() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        if (postData.YO() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.YO().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.YO().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.YO().getPortrait());
                        }
                        if (this.hoZ != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoZ.bIi()));
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.YO() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YO().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.YO().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YO().getName_show());
                        }
                        if (this.hoZ != null && this.hoZ.bHW() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hoZ.bHW().getId());
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
                        if (this.hoZ != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoZ.bIi()));
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
            if (postData.YO() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.cep() == 1) {
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
            pVar.hqD.setTag(sparseArray);
            pVar.hpG.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.hqD.setIsHost(true);
            if (this.hqs) {
                pVar.bFt.setVisibility(0);
            } else {
                pVar.bFt.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpa) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hqD.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hqD.setLayoutParams(layoutParams);
                pVar.hqD.qc(null);
                this.hqv = false;
                a(pVar, postData, view, i);
            } else {
                this.hqv = true;
                pVar.hqD.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void ato() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hqD.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hqD.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hoZ != null && this.hoZ.bHW() != null && this.hoZ.bHW().ZI() && this.hoZ.bHW().Zf() != null && com.baidu.tbadk.core.util.ap.isEmpty(this.hoZ.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds28));
            } else if (postData.cer() == null || com.baidu.tbadk.core.util.v.T(postData.cer().ast())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cer() != null) {
                if (postData.cer().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.aaJ.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.tbds26);
                    pVar.aaJ.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.aaJ.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.tbds16);
                    pVar.aaJ.setLayoutParams(layoutParams3);
                }
            }
            if (this.hoZ.bHW() != null && this.hoZ.bHW().ZA() != null) {
                pVar.aaJ.setVisibility(0);
                pVar.aaJ.setData(this.hoZ.bHW().ZA());
                if (this.hoZ.getForum() != null) {
                    pVar.aaJ.setForumId(String.valueOf(this.hoZ.getForum().getId()));
                }
                AppletsCellView appletsCellView = pVar.aaJ;
                AppletsCellView appletsCellView2 = pVar.aaJ;
                appletsCellView.setFrom("PB_card");
            }
            if (this.hoZ == null || this.hoZ.bHW() == null) {
                return;
            }
            if (this.hoZ.bHW().Zd() != 0 || this.hoZ.bHW().ZI()) {
                pVar.S(this.hoZ.bHW().YK() == 1, this.hoZ.bHW().YJ() == 1);
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.ceA() == null) {
                pVar.hqD.getLayoutStrategy().kG(oK(d.e.tbds24));
            } else {
                pVar.hqD.getLayoutStrategy().kG(oK(d.e.tbds14));
            }
            pVar.hqH.f(postData.ceA());
        }
    }

    private int oK(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl()) && afVar.Xv() == com.baidu.tbadk.core.data.af.bzl) {
            if (!afVar.Xw()) {
                pVar.hqD.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds48));
            }
            pVar.hqH.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bOL() == null) {
            pVar.hpZ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bOL(), pVar.hpZ, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hqD.setTextViewOnTouchListener(this.hqw);
        pVar.hqD.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(aO - i, this.hph);
            tbRichTextView.getLayoutStrategy().ky(min);
            tbRichTextView.getLayoutStrategy().kz((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hpG.setOnTouchListener(this.ccb);
        pVar.hpG.setOnLongClickListener(this.cdg);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hoK.getPageContext().getOrignalPage()).hmL;
        pVar.hqD.setOnLongClickListener(this.cdg);
        pVar.hqD.setOnTouchListener(this.hqw);
        pVar.hqD.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hqD.setOnImageClickListener(this.cAE);
        pVar.hqD.setOnImageTouchListener(this.hqw);
        pVar.hqD.setOnEmotionClickListener(aVar.hzU);
        pVar.hpZ.setOnClickListener(this.mCommonClickListener);
        pVar.hqH.a(this.hqx);
        pVar.hqI.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hoZ = dVar;
    }

    public void vW(int i) {
        this.hph = i;
    }

    public void nc(boolean z) {
        this.hpa = z;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpj = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ccb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdg = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hpA = cVar;
    }

    public void nu(boolean z) {
        this.hqs = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqH.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqH.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqH.pause();
        }
    }

    public p bKA() {
        return (p) this.viewholder;
    }
}
