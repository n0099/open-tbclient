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
    private TbRichTextView.h cAD;
    private com.baidu.tieba.pb.a.c cca;
    private View.OnLongClickListener cdf;
    protected com.baidu.tieba.pb.data.d hoY;
    protected boolean hoZ;
    private com.baidu.tieba.pb.pb.sub.c hpA;
    protected int hpg;
    private View.OnClickListener hpi;
    private TbRichTextView.c hpz;
    private boolean hqr;
    private boolean hqs;
    private final boolean hqt;
    private boolean hqu;
    private com.baidu.tieba.pb.a.c hqv;
    private OriginalThreadCardView.a hqw;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hpg = 0;
        this.hoZ = true;
        this.hqr = true;
        this.hoY = null;
        this.hpA = null;
        this.hpi = null;
        this.mCommonClickListener = null;
        this.cAD = null;
        this.cca = null;
        this.cdf = null;
        this.hpz = null;
        this.hqs = false;
        this.hqt = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hqu = false;
        this.pageFromType = 0;
        this.hqv = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.cca != null) {
                    o.this.cca.ci(view);
                    o.this.cca.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hqw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hoY != null) {
                    String threadId = o.this.hoY.getThreadId();
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
                com.baidu.tbadk.core.util.al.l(pVar.bFs, d.C0277d.cp_bg_line_c);
                pVar.hqC.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_b));
                pVar.aaI.onChangeSkinType();
                if (pVar.hqH != null) {
                    pVar.hqH.onChangeSkinType();
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
        p pVar = new p(this.hoJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.hoZ, this.hpg);
        a(pVar);
        pVar.hqG.wi(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.hoJ.getUniqueId(), this.hoY, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hqs && this.hqt && pVar != null && pVar.hqC.atj() && (listView = ((PbActivity) this.hoJ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hqs = true;
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
        if (this.hoY != null) {
            if (postData.cep() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hqC.setOnClickListener(this.mCommonClickListener);
                    pVar.hqC.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hqC.setOnClickListener(null);
                    pVar.hqC.setTextViewOnClickListener(null);
                }
                pVar.hpF.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hpF.setOnClickListener(null);
            }
            if (postData.cep() == 1) {
                pVar.b(this.hoY, this.hoJ.bIN());
                a(pVar.hqC, view, this.hqu);
                pVar.hqz.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.YO() != null) {
                    j = postData.YO().getUserIdLong();
                    str = postData.YO().getUserName();
                    str2 = postData.YO().getName_show();
                }
                if (this.hoY != null && this.hoY.bHW() != null) {
                    pVar.hqG.a(postData.cex(), str, str2, j, com.baidu.adp.lib.g.b.d(this.hoY.bHW().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.hoJ.bJn().bNn()) {
                    pVar.hqC.setVisibility(8);
                }
                if (this.hoY != null && this.hoY.bHW() != null && this.hoY.bHW().Za() != null) {
                    bp Za = this.hoY.bHW().Za();
                    Za.getActivityUrl();
                    String aaR = Za.aaR();
                    if (!StringUtils.isNull(Za.aaS())) {
                        if (!StringUtils.isNull(aaR)) {
                            pVar.hqE.setVisibility(0);
                            pVar.hqE.startLoad(aaR, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hqE.setVisibility(8);
                }
                if (pVar.hqF != null) {
                    pVar.hqF.setVisibility(8);
                }
                if (this.hoY != null && this.hoY.bHW() != null && this.hoY.bHW().ZI() && pVar.hqH != null) {
                    pVar.hqH.setPadding(pVar.hqH.getPaddingLeft(), com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds29), pVar.hqH.getPaddingRight(), pVar.hqH.getPaddingBottom());
                }
            }
            pVar.hqC.getLayoutStrategy().kx(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cep()));
            if (postData.cet() > 0 && postData.cem() != null && postData.cem().size() > 0) {
                if (this.hpA == null) {
                    this.hpA = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hpA.setIsFromCDN(this.mIsFromCDN);
                    this.hpA.M(this.hpi);
                    if (this.hoY != null) {
                        this.hpA.H(this.hoY.bIi(), TextUtils.equals(this.hoY.bHW().YO().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hpA.ai(this.hoY.bHW());
                    }
                }
                this.hpA.Al(postData.getId());
            }
            pVar.hqC.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            if (this.hoZ) {
                pVar.hqC.getLayoutStrategy().kA(d.f.transparent_bg);
            } else {
                pVar.hqC.getLayoutStrategy().kA(d.f.icon_click);
            }
            pVar.hqC.setIsFromCDN(this.mIsFromCDN);
            if (this.hoY != null && this.hoY.bHW() != null && this.hoY.bHW().isLinkThread()) {
                a(pVar, this.hoY.bHW().aan());
            }
            a(pVar, postData);
            TbRichText cer = postData.cer();
            if (this.hoY != null && this.hoY.bIu()) {
                cer = null;
            }
            if (this.hqs || !this.hqt) {
                pVar.hqC.setText(cer, false, this.hpz);
            } else {
                pVar.hqC.setText(cer, true, this.hpz);
            }
            a(pVar, postData, cer);
            boolean z7 = !StringUtils.isNull(postData.YO().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hoY != null && this.hoY.bIi() != 0) {
                if (this.hoY.bIi() != 3) {
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
            if (this.hoY != null && this.hoY.bHW() != null && this.hoY.bHW().YO() != null && postData.YO() != null) {
                String userId2 = this.hoY.bHW().YO().getUserId();
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
                        if (this.hoY != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoY.bIi()));
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
                        if (this.hoY != null && this.hoY.bHW() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hoY.bHW().getId());
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
                        if (this.hoY != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoY.bIi()));
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
            pVar.hqC.setTag(sparseArray);
            pVar.hpF.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.hqC.setIsHost(true);
            if (this.hqr) {
                pVar.bFs.setVisibility(0);
            } else {
                pVar.bFs.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hoZ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hqC.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hqC.setLayoutParams(layoutParams);
                pVar.hqC.qc(null);
                this.hqu = false;
                a(pVar, postData, view, i);
            } else {
                this.hqu = true;
                pVar.hqC.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void ato() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hqC.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hqC.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hoY != null && this.hoY.bHW() != null && this.hoY.bHW().ZI() && this.hoY.bHW().Zf() != null && com.baidu.tbadk.core.util.ap.isEmpty(this.hoY.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds28));
            } else if (postData.cer() == null || com.baidu.tbadk.core.util.v.T(postData.cer().ast())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cer() != null) {
                if (postData.cer().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.aaI.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.tbds26);
                    pVar.aaI.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.aaI.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.tbds16);
                    pVar.aaI.setLayoutParams(layoutParams3);
                }
            }
            if (this.hoY.bHW() != null && this.hoY.bHW().ZA() != null) {
                pVar.aaI.setVisibility(0);
                pVar.aaI.setData(this.hoY.bHW().ZA());
                if (this.hoY.getForum() != null) {
                    pVar.aaI.setForumId(String.valueOf(this.hoY.getForum().getId()));
                }
                AppletsCellView appletsCellView = pVar.aaI;
                AppletsCellView appletsCellView2 = pVar.aaI;
                appletsCellView.setFrom("PB_card");
            }
            if (this.hoY == null || this.hoY.bHW() == null) {
                return;
            }
            if (this.hoY.bHW().Zd() != 0 || this.hoY.bHW().ZI()) {
                pVar.S(this.hoY.bHW().YK() == 1, this.hoY.bHW().YJ() == 1);
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.ceA() == null) {
                pVar.hqC.getLayoutStrategy().kG(oK(d.e.tbds24));
            } else {
                pVar.hqC.getLayoutStrategy().kG(oK(d.e.tbds14));
            }
            pVar.hqG.f(postData.ceA());
        }
    }

    private int oK(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl()) && afVar.Xv() == com.baidu.tbadk.core.data.af.bzk) {
            if (!afVar.Xw()) {
                pVar.hqC.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds48));
            }
            pVar.hqG.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bOL() == null) {
            pVar.hpY.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bOL(), pVar.hpY, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hqC.setTextViewOnTouchListener(this.hqv);
        pVar.hqC.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(aO - i, this.hpg);
            tbRichTextView.getLayoutStrategy().ky(min);
            tbRichTextView.getLayoutStrategy().kz((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hpF.setOnTouchListener(this.cca);
        pVar.hpF.setOnLongClickListener(this.cdf);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hoJ.getPageContext().getOrignalPage()).hmK;
        pVar.hqC.setOnLongClickListener(this.cdf);
        pVar.hqC.setOnTouchListener(this.hqv);
        pVar.hqC.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hqC.setOnImageClickListener(this.cAD);
        pVar.hqC.setOnImageTouchListener(this.hqv);
        pVar.hqC.setOnEmotionClickListener(aVar.hzT);
        pVar.hpY.setOnClickListener(this.mCommonClickListener);
        pVar.hqG.a(this.hqw);
        pVar.hqH.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hoY = dVar;
    }

    public void vW(int i) {
        this.hpg = i;
    }

    public void nc(boolean z) {
        this.hoZ = z;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpi = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cca = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdf = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hpz = cVar;
    }

    public void nu(boolean z) {
        this.hqr = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqG.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqG.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqG.pause();
        }
    }

    public p bKA() {
        return (p) this.viewholder;
    }
}
