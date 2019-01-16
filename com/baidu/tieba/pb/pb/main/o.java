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
    private View.OnLongClickListener aTZ;
    private TbRichTextView.h bsD;
    private com.baidu.tieba.pb.a.c bsE;
    protected com.baidu.tieba.pb.data.d fYY;
    protected boolean fYZ;
    protected int fZg;
    private View.OnClickListener fZh;
    private TbRichTextView.c fZw;
    private com.baidu.tieba.pb.pb.sub.c fZx;
    private boolean gan;
    private boolean gao;
    private final boolean gap;
    private boolean gaq;
    private com.baidu.tieba.pb.a.c gar;
    private OriginalThreadCardView.a gas;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fZg = 0;
        this.fYZ = true;
        this.gan = true;
        this.fYY = null;
        this.fZx = null;
        this.fZh = null;
        this.mCommonClickListener = null;
        this.bsD = null;
        this.bsE = null;
        this.aTZ = null;
        this.fZw = null;
        this.gao = false;
        this.gap = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.gaq = false;
        this.pageFromType = 0;
        this.gar = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bsE != null) {
                    o.this.bsE.bt(view);
                    o.this.bsE.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.gas = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fYY != null) {
                    String threadId = o.this.fYY.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").aB("tid", threadId).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).y("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.biD() != null) {
            this.pageFromType = pbActivity.biD().blc();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.j(pVar.euT, e.d.cp_bg_line_c);
                pVar.gax.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                pVar.dUS.onChangeSkinType();
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fYJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_first_floor_item, viewGroup, false), this.fYZ, this.fZg);
        a(pVar);
        pVar.gaC.sD(this.pageFromType);
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
            postData2.AQ();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.fYJ.getUniqueId(), this.fYY, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.gao && this.gap && pVar != null && pVar.gax.Tn() && (listView = ((PbActivity) this.fYJ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.gao = true;
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
        if (this.fYY != null) {
            if (postData.bES() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.gax.setOnClickListener(this.mCommonClickListener);
                    pVar.gax.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.gax.setOnClickListener(null);
                    pVar.gax.setTextViewOnClickListener(null);
                }
                pVar.fZC.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fZC.setOnClickListener(null);
            }
            if (postData.bES() == 1) {
                pVar.gaC.a(this.fYY, this.fYJ.bit(), this.mContext);
                a(pVar.gax, view, this.gaq);
                pVar.gaw.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zT() != null) {
                    j = postData.zT().getUserIdLong();
                    str = postData.zT().getUserName();
                    str2 = postData.zT().getName_show();
                }
                if (this.fYY != null && this.fYY.bhz() != null) {
                    pVar.gaC.a(postData.bFa(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fYY.bhz().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.fYJ.biU().bmV()) {
                    pVar.gax.setVisibility(8);
                }
                if (this.fYY != null && this.fYY.bhz() != null && this.fYY.bhz().Ag() != null) {
                    bk Ag = this.fYY.bhz().Ag();
                    Ag.getActivityUrl();
                    String BM = Ag.BM();
                    if (!StringUtils.isNull(Ag.BN())) {
                        if (!StringUtils.isNull(BM)) {
                            pVar.gaz.setVisibility(0);
                            pVar.gaz.startLoad(BM, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.gaz.setVisibility(8);
                }
                if (pVar.gaA != null) {
                    pVar.gaA.setVisibility(8);
                }
            }
            pVar.gax.getLayoutStrategy().gK(e.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bES()));
            if (postData.bEW() > 0 && postData.bEP() != null && postData.bEP().size() > 0) {
                if (this.fZx == null) {
                    this.fZx = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fZx.setIsFromCDN(this.mIsFromCDN);
                    this.fZx.M(this.fZh);
                    if (this.fYY != null) {
                        this.fZx.B(this.fYY.bhL(), TextUtils.equals(this.fYY.bhz().zT().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fZx.aa(this.fYY.bhz());
                    }
                }
                this.fZx.tI(postData.getId());
            }
            pVar.gax.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            if (this.fYZ) {
                pVar.gax.getLayoutStrategy().gN(e.f.transparent_bg);
            } else {
                pVar.gax.getLayoutStrategy().gN(e.f.icon_click);
            }
            pVar.gax.setIsFromCDN(this.mIsFromCDN);
            if (this.fYY != null && this.fYY.bhz() != null && this.fYY.bhz().isLinkThread()) {
                a(pVar, this.fYY.bhz().Bl());
            }
            a(pVar, postData);
            TbRichText bEU = postData.bEU();
            if (this.fYY != null && this.fYY.bhY()) {
                bEU = null;
            }
            if (this.gao || !this.gap) {
                pVar.gax.setText(bEU, false, this.fZw);
            } else {
                pVar.gax.setText(bEU, true, this.fZw);
            }
            a(pVar, postData, bEU);
            boolean z7 = !StringUtils.isNull(postData.zT().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fYY != null && this.fYY.bhL() != 0) {
                z8 = true;
                z9 = true;
                if (postData.zT() != null) {
                    String userId = postData.zT().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fYY != null && this.fYY.bhz() != null && this.fYY.bhz().zT() != null && postData.zT() != null) {
                String userId2 = this.fYY.bhz().zT().getUserId();
                String userId3 = postData.zT().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.zT() == null && UtilHelper.isCurrentAccount(postData.zT().getUserId())) {
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
                    if (postData.bES() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        if (postData.zT() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zT().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zT().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zT().getPortrait());
                        }
                        if (this.fYY != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYY.bhL()));
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zT() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zT().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zT().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zT().getName_show());
                        }
                        if (this.fYY != null && this.fYY.bhz() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fYY.bhz().getId());
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
                        if (this.fYY != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fYY.bhL()));
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
            if (postData.zT() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bES() == 1) {
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
            pVar.gax.setTag(sparseArray);
            pVar.fZC.setTag(e.g.tag_from, sparseArray);
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            pVar.gax.setIsHost(true);
            if (this.gan) {
                pVar.euT.setVisibility(0);
            } else {
                pVar.euT.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fYZ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.gax.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.gax.setLayoutParams(layoutParams);
                pVar.gax.jr(null);
                this.gaq = false;
                a(pVar, postData, view, i);
            } else {
                this.gaq = true;
                pVar.gax.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void Ts() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.gax.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(e.C0210e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(e.C0210e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.gax.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.gaB.setData(this.fYY.bib());
            pVar.gaB.setPageContext(this.fYJ.getPageContext());
            if (postData.bEU() != null) {
                if (postData.bEU().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.dUS.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.tbds26);
                    pVar.dUS.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.dUS.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(e.C0210e.tbds16);
                    pVar.dUS.setLayoutParams(layoutParams3);
                }
            }
            if (this.fYY.bhz() != null && this.fYY.bhz().Az() != null) {
                pVar.dUS.setVisibility(0);
                pVar.dUS.setData(this.fYY.bhz().Az());
                if (this.fYY.bhx() != null) {
                    pVar.dUS.setForumId(String.valueOf(this.fYY.bhx().getId()));
                }
                AppletsCellView appletsCellView = pVar.dUS;
                AppletsCellView appletsCellView2 = pVar.dUS;
                appletsCellView.setFrom("PB_card");
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bFd() == null) {
                pVar.gax.getLayoutStrategy().gS(lm(e.C0210e.tbds24));
            } else {
                pVar.gax.getLayoutStrategy().gS(lm(e.C0210e.tbds14));
            }
            pVar.gaC.f(postData.bFd());
        }
    }

    private int lm(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl()) && adVar.yP() == com.baidu.tbadk.core.data.ad.asq) {
            if (!adVar.yQ()) {
                pVar.gax.getLayoutStrategy().gS(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds48));
            }
            pVar.gaC.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bor() == null) {
            pVar.fZV.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.c.a(postData.bor(), pVar.fZV, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.gax.setTextViewOnTouchListener(this.gar);
        pVar.gax.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(e.C0210e.ds80);
            }
            int min = Math.min(aO - i, this.fZg);
            tbRichTextView.getLayoutStrategy().gL(min);
            tbRichTextView.getLayoutStrategy().gM((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fZC.setOnTouchListener(this.bsE);
        pVar.fZC.setOnLongClickListener(this.aTZ);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fYJ.getPageContext().getOrignalPage()).fWN;
        pVar.gax.setOnLongClickListener(this.aTZ);
        pVar.gax.setOnTouchListener(this.gar);
        pVar.gax.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.gax.setOnImageClickListener(this.bsD);
        pVar.gax.setOnImageTouchListener(this.gar);
        pVar.gax.setOnEmotionClickListener(aVar.gkk);
        pVar.fZV.setOnClickListener(this.mCommonClickListener);
        pVar.gaC.a(this.gas);
        pVar.gaC.K(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == e.g.view_forum1 || id == e.g.view_forum2 || id == e.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fYJ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fYJ).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fYY = dVar;
    }

    public void setImageMaxWidth(int i) {
        this.fZg = i;
    }

    public void kC(boolean z) {
        this.fYZ = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fZh = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bsE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTZ = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fZw = cVar;
    }

    public void kT(boolean z) {
        this.gan = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).gaC.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).gaC.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).gaC.pause();
        }
    }
}
