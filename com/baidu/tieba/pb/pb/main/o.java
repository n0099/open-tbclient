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
    private View.OnLongClickListener aTo;
    private TbRichTextView.h brM;
    private com.baidu.tieba.pb.a.c brN;
    private TbRichTextView.c fVH;
    private com.baidu.tieba.pb.pb.sub.c fVI;
    protected com.baidu.tieba.pb.data.d fVj;
    protected boolean fVk;
    protected int fVr;
    private View.OnClickListener fVs;
    private final boolean fWA;
    private boolean fWB;
    private com.baidu.tieba.pb.a.c fWC;
    private OriginalThreadCardView.a fWD;
    private boolean fWy;
    private boolean fWz;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fVr = 0;
        this.fVk = true;
        this.fWy = true;
        this.fVj = null;
        this.fVI = null;
        this.fVs = null;
        this.mCommonClickListener = null;
        this.brM = null;
        this.brN = null;
        this.aTo = null;
        this.fVH = null;
        this.fWz = false;
        this.fWA = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.fWB = false;
        this.pageFromType = 0;
        this.fWC = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.brN != null) {
                    o.this.brN.bq(view);
                    o.this.brN.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.fWD = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.fVj != null) {
                    String threadId = o.this.fVj.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").aA("tid", threadId).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).x("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bhn() != null) {
            this.pageFromType = pbActivity.bhn().bjI();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.j(pVar.erw, e.d.cp_bg_line_c);
                pVar.fWI.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_b));
                pVar.dRv.onChangeSkinType();
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.fUU.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.new_pb_list_first_floor_item, viewGroup, false), this.fVk, this.fVr);
        a(pVar);
        pVar.fWN.sm(this.pageFromType);
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
            postData2.AD();
            b(pVar, postData2, view, i);
        }
        if (!this.fWz && this.fWA && pVar != null && pVar.fWI.SP() && (listView = ((PbActivity) this.fUU.getPageContext().getOrignalPage()).getListView()) != null) {
            this.fWz = true;
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
        if (this.fVj != null) {
            if (postData.bDr() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.fWI.setOnClickListener(this.mCommonClickListener);
                    pVar.fWI.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.fWI.setOnClickListener(null);
                    pVar.fWI.setTextViewOnClickListener(null);
                }
                pVar.fVN.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.fVN.setOnClickListener(null);
            }
            if (postData.bDr() == 1) {
                pVar.fWN.a(this.fVj, this.fUU.bhd(), this.mContext);
                a(pVar.fWI, view, this.fWB);
                pVar.fWH.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zG() != null) {
                    j = postData.zG().getUserIdLong();
                    str = postData.zG().getUserName();
                    str2 = postData.zG().getName_show();
                }
                if (this.fVj != null && this.fVj.bgj() != null) {
                    pVar.fWN.a(postData.bDz(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fVj.bgj().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                if (this.fUU.bhE().blB()) {
                    pVar.fWI.setVisibility(8);
                }
                if (this.fVj != null && this.fVj.bgj() != null && this.fVj.bgj().zT() != null) {
                    bk zT = this.fVj.bgj().zT();
                    zT.getActivityUrl();
                    String Bz = zT.Bz();
                    if (!StringUtils.isNull(zT.BA())) {
                        if (!StringUtils.isNull(Bz)) {
                            pVar.fWK.setVisibility(0);
                            pVar.fWK.startLoad(Bz, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.fWK.setVisibility(8);
                }
                if (pVar.fWL != null) {
                    pVar.fWL.setVisibility(8);
                }
            }
            pVar.fWI.getLayoutStrategy().gJ(e.f.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_load_sub_data, postData);
            sparseArray.put(e.g.tag_load_sub_view, view);
            sparseArray.put(e.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(e.g.tag_pb_floor_number, Integer.valueOf(postData.bDr()));
            if (postData.bDv() > 0 && postData.bDo() != null && postData.bDo().size() > 0) {
                if (this.fVI == null) {
                    this.fVI = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.fVI.setIsFromCDN(this.mIsFromCDN);
                    this.fVI.M(this.fVs);
                    if (this.fVj != null) {
                        this.fVI.B(this.fVj.bgv(), TextUtils.equals(this.fVj.bgj().zG().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.fVI.aa(this.fVj.bgj());
                    }
                }
                this.fVI.tp(postData.getId());
            }
            pVar.fWI.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            if (this.fVk) {
                pVar.fWI.getLayoutStrategy().gM(e.f.transparent_bg);
            } else {
                pVar.fWI.getLayoutStrategy().gM(e.f.icon_click);
            }
            pVar.fWI.setIsFromCDN(this.mIsFromCDN);
            if (this.fVj != null && this.fVj.bgj() != null && this.fVj.bgj().isLinkThread()) {
                a(pVar, this.fVj.bgj().AY());
            }
            a(pVar, postData);
            TbRichText bDt = postData.bDt();
            if (this.fVj != null && this.fVj.bgI()) {
                bDt = null;
            }
            if (this.fWz || !this.fWA) {
                pVar.fWI.setText(bDt, false, this.fVH);
            } else {
                pVar.fWI.setText(bDt, true, this.fVH);
            }
            a(pVar, postData, bDt);
            boolean z7 = !StringUtils.isNull(postData.zG().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.fVj != null && this.fVj.bgv() != 0) {
                z8 = true;
                z9 = true;
                if (postData.zG() != null) {
                    String userId = postData.zG().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fVj != null && this.fVj.bgj() != null && this.fVj.bgj().zG() != null && postData.zG() != null) {
                String userId2 = this.fVj.bgj().zG().getUserId();
                String userId3 = postData.zG().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.zG() == null && UtilHelper.isCurrentAccount(postData.zG().getUserId())) {
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
                    if (postData.bDr() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                        }
                        if (this.fVj != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fVj.bgv()));
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zG().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zG().getName_show());
                        }
                        if (this.fVj != null && this.fVj.bgj() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fVj.bgj().getId());
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
                        if (this.fVj != null) {
                            sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.fVj.bgv()));
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
            if (postData.zG() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.bDr() == 1) {
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
            pVar.fWI.setTag(sparseArray);
            pVar.fVN.setTag(e.g.tag_from, sparseArray);
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            pVar.fWI.setIsHost(true);
            if (this.fWy) {
                pVar.erw.setVisibility(0);
            } else {
                pVar.erw.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fVk) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.fWI.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.fWI.setLayoutParams(layoutParams);
                pVar.fWI.ja(null);
                this.fWB = false;
                a(pVar, postData, view, i);
            } else {
                this.fWB = true;
                pVar.fWI.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void SU() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.fWI.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(e.C0210e.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(e.C0210e.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.fWI.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            pVar.fWM.setData(this.fVj.bgL());
            pVar.fWM.setPageContext(this.fUU.getPageContext());
            if (postData.bDt() != null) {
                if (postData.bDt().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.dRv.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(e.C0210e.tbds26);
                    pVar.dRv.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.dRv.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(e.C0210e.tbds16);
                    pVar.dRv.setLayoutParams(layoutParams3);
                }
            }
            if (this.fVj.bgj() != null && this.fVj.bgj().Am() != null) {
                pVar.dRv.setVisibility(0);
                pVar.dRv.setData(this.fVj.bgj().Am());
                if (this.fVj.bgh() != null) {
                    pVar.dRv.setForumId(String.valueOf(this.fVj.bgh().getId()));
                }
                AppletsCellView appletsCellView = pVar.dRv;
                AppletsCellView appletsCellView2 = pVar.dRv;
                appletsCellView.setFrom("PB_card");
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.bDC() == null) {
                pVar.fWI.getLayoutStrategy().gR(kY(e.C0210e.tbds24));
            } else {
                pVar.fWI.getLayoutStrategy().gR(kY(e.C0210e.tbds14));
            }
            pVar.fWN.f(postData.bDC());
        }
    }

    private int kY(int i) {
        return com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !com.baidu.tbadk.core.util.ao.isEmpty(adVar.getLinkUrl()) && adVar.yC() == com.baidu.tbadk.core.data.ad.arO) {
            if (!adVar.yD()) {
                pVar.fWI.getLayoutStrategy().gR(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds48));
            }
            pVar.fWN.a(adVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bmX() == null) {
            pVar.fWg.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.c.a(postData.bmX(), pVar.fWg, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.fWI.setTextViewOnTouchListener(this.fWC);
        pVar.fWI.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(e.C0210e.ds80);
            }
            int min = Math.min(aO - i, this.fVr);
            tbRichTextView.getLayoutStrategy().gK(min);
            tbRichTextView.getLayoutStrategy().gL((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.fVN.setOnTouchListener(this.brN);
        pVar.fVN.setOnLongClickListener(this.aTo);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.fUU.getPageContext().getOrignalPage()).fSY;
        pVar.fWI.setOnLongClickListener(this.aTo);
        pVar.fWI.setOnTouchListener(this.fWC);
        pVar.fWI.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.fWI.setOnImageClickListener(this.brM);
        pVar.fWI.setOnImageTouchListener(this.fWC);
        pVar.fWI.setOnEmotionClickListener(aVar.ggo);
        pVar.fWg.setOnClickListener(this.mCommonClickListener);
        pVar.fWN.a(this.fWD);
        pVar.fWN.K(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if ((id == e.g.view_forum1 || id == e.g.view_forum2 || id == e.g.view_forum3) && (view.getTag() instanceof String)) {
                this.fUU.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fUU).createNormalCfg((String) view.getTag(), FrsActivityConfig.FRS_FROM_PB)));
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fVj = dVar;
    }

    public void setImageMaxWidth(int i) {
        this.fVr = i;
    }

    public void kz(boolean z) {
        this.fVk = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fVs = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brM = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.brN = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTo = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.fVH = cVar;
    }

    public void kQ(boolean z) {
        this.fWy = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fWN.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fWN.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).fWN.pause();
        }
    }
}
