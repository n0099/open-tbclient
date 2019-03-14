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
    private TbRichTextView.h cAB;
    private com.baidu.tieba.pb.a.c cbY;
    private View.OnLongClickListener cdd;
    private TbRichTextView.c hpM;
    private com.baidu.tieba.pb.pb.sub.c hpN;
    protected com.baidu.tieba.pb.data.d hpl;
    protected boolean hpm;
    protected int hpt;
    private View.OnClickListener hpv;
    private boolean hqE;
    private boolean hqF;
    private final boolean hqG;
    private boolean hqH;
    private com.baidu.tieba.pb.a.c hqI;
    private OriginalThreadCardView.a hqJ;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hpt = 0;
        this.hpm = true;
        this.hqE = true;
        this.hpl = null;
        this.hpN = null;
        this.hpv = null;
        this.mCommonClickListener = null;
        this.cAB = null;
        this.cbY = null;
        this.cdd = null;
        this.hpM = null;
        this.hqF = false;
        this.hqG = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hqH = false;
        this.pageFromType = 0;
        this.hqI = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
        this.hqJ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hpl != null) {
                    String threadId = o.this.hpl.getThreadId();
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
        if (pbActivity != null && pbActivity.bJa() != null) {
            this.pageFromType = pbActivity.bJa().bLz();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.l(pVar.bFq, d.C0277d.cp_bg_line_c);
                pVar.hqP.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_b));
                pVar.aaH.onChangeSkinType();
                if (pVar.hqU != null) {
                    pVar.hqU.onChangeSkinType();
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
        p pVar = new p(this.hoW.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.hpm, this.hpt);
        a(pVar);
        pVar.hqT.wm(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.hoW.getUniqueId(), this.hpl, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hqF && this.hqG && pVar != null && pVar.hqP.atm() && (listView = ((PbActivity) this.hoW.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hqF = true;
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
        if (this.hpl != null) {
            if (postData.cet() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hqP.setOnClickListener(this.mCommonClickListener);
                    pVar.hqP.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hqP.setOnClickListener(null);
                    pVar.hqP.setTextViewOnClickListener(null);
                }
                pVar.hpS.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hpS.setOnClickListener(null);
            }
            if (postData.cet() == 1) {
                pVar.b(this.hpl, this.hoW.bIQ());
                a(pVar.hqP, view, this.hqH);
                pVar.hqM.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.YR() != null) {
                    j = postData.YR().getUserIdLong();
                    str = postData.YR().getUserName();
                    str2 = postData.YR().getName_show();
                }
                if (this.hpl != null && this.hpl.bHZ() != null) {
                    pVar.hqT.a(postData.ceB(), str, str2, j, com.baidu.adp.lib.g.b.d(this.hpl.bHZ().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.hoW.bJq().bNq()) {
                    pVar.hqP.setVisibility(8);
                }
                if (this.hpl != null && this.hpl.bHZ() != null && this.hpl.bHZ().Zd() != null) {
                    bp Zd = this.hpl.bHZ().Zd();
                    Zd.getActivityUrl();
                    String aaU = Zd.aaU();
                    if (!StringUtils.isNull(Zd.aaV())) {
                        if (!StringUtils.isNull(aaU)) {
                            pVar.hqR.setVisibility(0);
                            pVar.hqR.startLoad(aaU, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hqR.setVisibility(8);
                }
                if (pVar.hqS != null) {
                    pVar.hqS.setVisibility(8);
                }
                if (this.hpl != null && this.hpl.bHZ() != null && this.hpl.bHZ().ZL() && pVar.hqU != null) {
                    pVar.hqU.setPadding(pVar.hqU.getPaddingLeft(), com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds29), pVar.hqU.getPaddingRight(), pVar.hqU.getPaddingBottom());
                }
            }
            pVar.hqP.getLayoutStrategy().ky(d.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cet()));
            if (postData.cex() > 0 && postData.ceq() != null && postData.ceq().size() > 0) {
                if (this.hpN == null) {
                    this.hpN = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hpN.setIsFromCDN(this.mIsFromCDN);
                    this.hpN.M(this.hpv);
                    if (this.hpl != null) {
                        this.hpN.H(this.hpl.bIl(), TextUtils.equals(this.hpl.bHZ().YR().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hpN.aj(this.hpl.bHZ());
                    }
                }
                this.hpN.Am(postData.getId());
            }
            pVar.hqP.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            if (this.hpm) {
                pVar.hqP.getLayoutStrategy().kB(d.f.transparent_bg);
            } else {
                pVar.hqP.getLayoutStrategy().kB(d.f.icon_click);
            }
            pVar.hqP.setIsFromCDN(this.mIsFromCDN);
            if (this.hpl != null && this.hpl.bHZ() != null && this.hpl.bHZ().isLinkThread()) {
                a(pVar, this.hpl.bHZ().aaq());
            }
            a(pVar, postData);
            TbRichText cev = postData.cev();
            if (this.hpl != null && this.hpl.bIx()) {
                cev = null;
            }
            if (this.hqF || !this.hqG) {
                pVar.hqP.setText(cev, false, this.hpM);
            } else {
                pVar.hqP.setText(cev, true, this.hpM);
            }
            a(pVar, postData, cev);
            boolean z7 = !StringUtils.isNull(postData.YR().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hpl != null && this.hpl.bIl() != 0) {
                if (this.hpl.bIl() != 3) {
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
            if (this.hpl != null && this.hpl.bHZ() != null && this.hpl.bHZ().YR() != null && postData.YR() != null) {
                String userId2 = this.hpl.bHZ().YR().getUserId();
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
                    if (postData.cet() == 1) {
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
                        if (this.hpl != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hpl.bIl()));
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
                        if (this.hpl != null && this.hpl.bHZ() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hpl.bHZ().getId());
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
                        if (this.hpl != null) {
                            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hpl.bIl()));
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
            if (postData.cet() == 1) {
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
            pVar.hqP.setTag(sparseArray);
            pVar.hpS.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            pVar.hqP.setIsHost(true);
            if (this.hqE) {
                pVar.bFq.setVisibility(0);
            } else {
                pVar.bFq.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpm) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hqP.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hqP.setLayoutParams(layoutParams);
                pVar.hqP.qb(null);
                this.hqH = false;
                a(pVar, postData, view, i);
            } else {
                this.hqH = true;
                pVar.hqP.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void atr() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hqP.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(d.e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(d.e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hqP.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hpl != null && this.hpl.bHZ() != null && this.hpl.bHZ().ZL() && this.hpl.bHZ().Zi() != null && com.baidu.tbadk.core.util.ap.isEmpty(this.hpl.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds28));
            } else if (postData.cev() == null || com.baidu.tbadk.core.util.v.T(postData.cev().asw())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cev() != null) {
                if (postData.cev().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.aaH.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(d.e.tbds26);
                    pVar.aaH.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.aaH.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(d.e.tbds16);
                    pVar.aaH.setLayoutParams(layoutParams3);
                }
            }
            if (this.hpl.bHZ() != null && this.hpl.bHZ().ZD() != null) {
                pVar.aaH.setVisibility(0);
                pVar.aaH.setData(this.hpl.bHZ().ZD());
                if (this.hpl.getForum() != null) {
                    pVar.aaH.setForumId(String.valueOf(this.hpl.getForum().getId()));
                }
                AppletsCellView appletsCellView = pVar.aaH;
                AppletsCellView appletsCellView2 = pVar.aaH;
                appletsCellView.setFrom("PB_card");
            }
            if (this.hpl == null || this.hpl.bHZ() == null) {
                return;
            }
            if (this.hpl.bHZ().Zg() != 0 || this.hpl.bHZ().ZL()) {
                pVar.U(this.hpl.bHZ().YN() == 1, this.hpl.bHZ().YM() == 1);
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.ceE() == null) {
                pVar.hqP.getLayoutStrategy().kH(oO(d.e.tbds24));
            } else {
                pVar.hqP.getLayoutStrategy().kH(oO(d.e.tbds14));
            }
            pVar.hqT.f(postData.ceE());
        }
    }

    private int oO(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl()) && afVar.Xy() == com.baidu.tbadk.core.data.af.bzh) {
            if (!afVar.Xz()) {
                pVar.hqP.getLayoutStrategy().kH(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds48));
            }
            pVar.hqT.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bOO() == null) {
            pVar.hql.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bOO(), pVar.hql, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hqP.setTextViewOnTouchListener(this.hqI);
        pVar.hqP.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(aO - i, this.hpt);
            tbRichTextView.getLayoutStrategy().kz(min);
            tbRichTextView.getLayoutStrategy().kA((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hpS.setOnTouchListener(this.cbY);
        pVar.hpS.setOnLongClickListener(this.cdd);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hoW.getPageContext().getOrignalPage()).hmX;
        pVar.hqP.setOnLongClickListener(this.cdd);
        pVar.hqP.setOnTouchListener(this.hqI);
        pVar.hqP.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hqP.setOnImageClickListener(this.cAB);
        pVar.hqP.setOnImageTouchListener(this.hqI);
        pVar.hqP.setOnEmotionClickListener(aVar.hAh);
        pVar.hql.setOnClickListener(this.mCommonClickListener);
        pVar.hqT.a(this.hqJ);
        pVar.hqU.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hpl = dVar;
    }

    public void wa(int i) {
        this.hpt = i;
    }

    public void nc(boolean z) {
        this.hpm = z;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpv = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAB = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cbY = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hpM = cVar;
    }

    public void nu(boolean z) {
        this.hqE = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqT.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqT.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hqT.pause();
        }
    }

    public p bKD() {
        return (p) this.viewholder;
    }
}
