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
    private View.OnLongClickListener aOZ;
    private TbRichTextView.h bnD;
    private com.baidu.tieba.pb.a.c bnE;
    protected com.baidu.tieba.pb.data.d fMU;
    protected boolean fMV;
    protected int fNc;
    private View.OnClickListener fNd;
    private TbRichTextView.c fNs;
    private com.baidu.tieba.pb.pb.sub.c fNt;
    private boolean fOj;
    private boolean fOk;
    private final boolean fOl;
    private boolean fOm;
    private com.baidu.tieba.pb.a.c fOn;
    private OriginalThreadCardView.a fOo;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fNc = 0;
        this.fMV = true;
        this.fOj = true;
        this.fMU = null;
        this.fNt = null;
        this.fNd = null;
        this.mCommonClickListener = null;
        this.bnD = null;
        this.bnE = null;
        this.aOZ = null;
        this.fNs = null;
        this.fOk = false;
        this.fOl = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fOm = false;
        this.pageFromType = 0;
        this.fOn = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.bnE != null) {
                    o.this.bnE.bo(view);
                    o.this.bnE.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fOo = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fMU != null) {
                    String threadId = o.this.fMU.getThreadId();
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
        if (pbActivity != null && pbActivity.bga() != null) {
            this.pageFromType = pbActivity.bga().biu();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.j(pVar.ejh, e.d.cp_bg_line_c);
                pVar.fOt.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                pVar.dJO.onChangeSkinType();
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fMF.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_first_floor_item, viewGroup, false), this.fMV, this.fNc);
        a(pVar);
        pVar.fOy.rz(this.pageFromType);
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
            postData2.zs();
            b(pVar, postData2, view, i);
        }
        if (!this.fOk && this.fOl && pVar != null && pVar.fOt.RA() && (listView = ((PbActivity) this.fMF.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fOk = true;
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
        if (this.fMU != null) {
            if (postData.bCb() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fOt.setOnClickListener(this.mCommonClickListener);
                    pVar.fOt.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fOt.setOnClickListener(null);
                    pVar.fOt.setTextViewOnClickListener(null);
                }
                pVar.fNy.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fNy.setOnClickListener(null);
            }
            if (postData.bCb() == 1) {
                pVar.fOy.a(this.fMU, this.fMF.bfQ(), this.mContext);
                a(pVar.fOt, view, this.fOm);
                pVar.fOs.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.yv() != null) {
                    j = postData.yv().getUserIdLong();
                    str = postData.yv().getUserName();
                    str2 = postData.yv().getName_show();
                }
                if (this.fMU != null && this.fMU.beV() != null) {
                    pVar.fOy.a(postData.bCj(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fMU.beV().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.fMF.bgr().bkm()) {
                    pVar.fOt.setVisibility(8);
                }
                if (this.fMU != null && this.fMU.beV() != null && this.fMU.beV().yI() != null) {
                    bk yI = this.fMU.beV().yI();
                    yI.getActivityUrl();
                    String Ao = yI.Ao();
                    if (!StringUtils.isNull(yI.Ap())) {
                        if (!StringUtils.isNull(Ao)) {
                            pVar.fOv.setVisibility(0);
                            pVar.fOv.startLoad(Ao, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fOv.setVisibility(8);
                }
                if (pVar.fOw != null) {
                    pVar.fOw.setVisibility(8);
                }
            }
            pVar.fOt.getLayoutStrategy().gh(e.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bCb()));
            if (postData.bCf() > 0 && postData.bBY() != null && postData.bBY().size() > 0) {
                if (this.fNt == null) {
                    this.fNt = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fNt.setIsFromCDN(this.mIsFromCDN);
                    this.fNt.K(this.fNd);
                    if (this.fMU != null) {
                        this.fNt.B(this.fMU.bfh(), TextUtils.equals(this.fMU.beV().yv().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fNt.aa(this.fMU.beV());
                    }
                }
                this.fNt.sM(postData.getId());
            }
            pVar.fOt.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            if (this.fMV) {
                pVar.fOt.getLayoutStrategy().gk(e.f.transparent_bg);
            } else {
                pVar.fOt.getLayoutStrategy().gk(e.f.icon_click);
            }
            pVar.fOt.setIsFromCDN(this.mIsFromCDN);
            if (this.fMU != null && this.fMU.beV() != null && this.fMU.beV().isLinkThread()) {
                a(pVar, this.fMU.beV().zN());
            }
            a(pVar, postData);
            TbRichText bCd = postData.bCd();
            if (this.fMU != null && this.fMU.bfu()) {
                bCd = null;
            }
            if (this.fOk || !this.fOl) {
                pVar.fOt.setText(bCd, false, this.fNs);
            } else {
                pVar.fOt.setText(bCd, true, this.fNs);
            }
            a(pVar, postData, bCd);
            boolean z7 = !StringUtils.isNull(postData.yv().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fMU != null && this.fMU.bfh() != 0) {
                z8 = true;
                z9 = true;
                if (postData.yv() != null) {
                    String userId = postData.yv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fMU != null && this.fMU.beV() != null && this.fMU.beV().yv() != null && postData.yv() != null) {
                String userId2 = this.fMU.beV().yv().getUserId();
                String userId3 = postData.yv().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.yv() == null && UtilHelper.isCurrentAccount(postData.yv().getUserId())) {
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
                    if (postData.bCb() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        if (postData.yv() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yv().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yv().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yv().getPortrait());
                        }
                        if (this.fMU != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fMU.bfh()));
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yv() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yv().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.yv().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yv().getName_show());
                        }
                        if (this.fMU != null && this.fMU.beV() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fMU.beV().getId());
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
                        if (this.fMU != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fMU.bfh()));
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
            if (postData.yv() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bCb() == 1) {
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
            pVar.fOt.setTag(sparseArray);
            pVar.fNy.setTag(e.g.tag_from, sparseArray);
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            pVar.fOt.setIsHost(true);
            if (this.fOj) {
                pVar.ejh.setVisibility(0);
            } else {
                pVar.ejh.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fMV) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fOt.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fOt.setLayoutParams(layoutParams);
                pVar.fOt.iG(null);
                this.fOm = false;
                a(pVar, postData, view, i);
            } else {
                this.fOm = true;
                pVar.fOt.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void RF() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fOt.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(e.C0175e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(e.C0175e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fOt.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fOx.setData(this.fMU.bfx());
            pVar.fOx.setPageContext(this.fMF.getPageContext());
            if (postData.bCd() != null) {
                if (postData.bCd().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.dJO.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(e.C0175e.tbds26);
                    pVar.dJO.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.dJO.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(e.C0175e.tbds16);
                    pVar.dJO.setLayoutParams(layoutParams3);
                }
            }
            if (this.fMU.beV() != null && this.fMU.beV().zb() != null) {
                pVar.dJO.setVisibility(0);
                pVar.dJO.setData(this.fMU.beV().zb());
                if (this.fMU.beT() != null) {
                    pVar.dJO.setForumId(String.valueOf(this.fMU.beT().getId()));
                }
                AppletsCellView appletsCellView = pVar.dJO;
                AppletsCellView appletsCellView2 = pVar.dJO;
                appletsCellView.setFrom("PB_card");
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bCm() == null) {
                pVar.fOt.getLayoutStrategy().gp(kq(e.C0175e.tbds24));
            } else {
                pVar.fOt.getLayoutStrategy().gp(kq(e.C0175e.tbds14));
            }
            pVar.fOy.f(postData.bCm());
        }
    }

    private int kq(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl()) && adVar.xq() == com.baidu.tbadk.core.data.ad.anA) {
            if (!adVar.xr()) {
                pVar.fOt.getLayoutStrategy().gp(com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds48));
            }
            pVar.fOy.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.blJ() == null) {
            pVar.fNR.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.c.a(postData.blJ(), pVar.fNR, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fOt.setTextViewOnTouchListener(this.fOn);
        pVar.fOt.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(e.C0175e.ds80);
            }
            int min = Math.min(aO - i, this.fNc);
            tbRichTextView.getLayoutStrategy().gi(min);
            tbRichTextView.getLayoutStrategy().gj((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fNy.setOnTouchListener(this.bnE);
        pVar.fNy.setOnLongClickListener(this.aOZ);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fMF.getPageContext().getOrignalPage()).fKJ;
        pVar.fOt.setOnLongClickListener(this.aOZ);
        pVar.fOt.setOnTouchListener(this.fOn);
        pVar.fOt.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fOt.setOnImageClickListener(this.bnD);
        pVar.fOt.setOnImageTouchListener(this.fOn);
        pVar.fOt.setOnEmotionClickListener(aVar.fXY);
        pVar.fNR.setOnClickListener(this.mCommonClickListener);
        pVar.fOy.a(this.fOo);
        pVar.fOy.I(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == e.g.view_forum1 || id == e.g.view_forum2 || id == e.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fMF.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fMF).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fMU = dVar;
    }

    public void setImageMaxWidth(int i) {
        this.fNc = i;
    }

    public void kl(boolean z) {
        this.fMV = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fNd = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bnD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bnE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fNs = cVar;
    }

    public void kC(boolean z) {
        this.fOj = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fOy.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fOy.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fOy.pause();
        }
    }
}
