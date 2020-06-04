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
import com.baidu.card.b;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class q extends m<PostData, r> {
    private View.OnClickListener aIH;
    private TbRichTextView.i eBN;
    private com.baidu.tieba.pb.a.c efF;
    protected com.baidu.tieba.pb.data.e jIA;
    protected boolean jIB;
    protected int jII;
    private View.OnClickListener jIK;
    private TbRichTextView.c jJr;
    private com.baidu.tieba.pb.pb.sub.b jJs;
    private boolean jKr;
    private boolean jKs;
    private final boolean jKt;
    private boolean jKu;
    private com.baidu.tieba.pb.a.c jKv;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> jKw;
    private b.a jKx;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jII = 0;
        this.jIB = true;
        this.jKr = true;
        this.jIA = null;
        this.jJs = null;
        this.jIK = null;
        this.aIH = null;
        this.eBN = null;
        this.efF = null;
        this.mOnLongClickListener = null;
        this.jJr = null;
        this.jKs = false;
        this.jKt = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.jKu = false;
        this.pageFromType = 0;
        this.jKv = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (q.this.efF != null) {
                    q.this.efF.R(view);
                    q.this.efF.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.jKw = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null && q.this.jIA != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aOi().dHm;
                    String threadId = q.this.jIA.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").dh("tid", threadId).dh("obj_source", str).ag("obj_type", i));
                    }
                }
            }
        };
        this.jKx = new b.a() { // from class: com.baidu.tieba.pb.pb.main.q.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aOi().dHm;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(q.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(q.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.cDO() != null) {
            this.pageFromType = pbFragment.cDO().cGt();
        }
    }

    private void a(r rVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (rVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(rVar.dIS, R.color.cp_bg_line_c);
                rVar.jKC.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                rVar.ahY.onChangeSkinType();
                if (rVar.jKL != null) {
                    rVar.jKL.onChangeSkinType();
                }
                if (rVar.jKM != null) {
                    rVar.jKM.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(rVar.jKH, (int) R.color.cp_cont_j);
                rVar.jKN.qk(skinType);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public r b(ViewGroup viewGroup) {
        r rVar = new r(this.jHL.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.jIB, this.jII);
        a(rVar);
        rVar.jKI.Ag(this.pageFromType);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, r rVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) rVar);
        a(rVar);
        c(rVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.aRK();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.jHL.getUniqueId(), this.jIA, postData2, postData2.locate, 1);
            b(rVar, postData2, view, i);
        }
        if (!this.jKs && this.jKt && rVar != null && rVar.jKC.bji() && (listView = this.jHL.getListView()) != null) {
            this.jKs = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x055d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(r rVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.jIA != null) {
            if (postData.ddJ() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.jKC.setOnClickListener(this.aIH);
                    rVar.jKC.setTextViewOnClickListener(this.aIH);
                } else {
                    rVar.jKC.setOnClickListener(null);
                    rVar.jKC.setTextViewOnClickListener(null);
                }
                rVar.jJB.setOnClickListener(this.aIH);
            } else {
                rVar.jJB.setOnClickListener(null);
            }
            if (postData.ddJ() == 1) {
                rVar.a(this.jIA, this.jHL.cDE(), postData.lmE);
                a(rVar.jKC, view, this.jKu);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aQx() != null) {
                    j = postData.aQx().getUserIdLong();
                    str = postData.aQx().getUserName();
                    str2 = postData.aQx().getName_show();
                }
                if (this.jIA != null && this.jIA.cCy() != null) {
                    rVar.jKI.a(postData.ddR(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jIA.cCy().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.jHL.cEE().cIB()) {
                    rVar.jKC.setVisibility(8);
                }
                if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCy().aQJ() != null) {
                    bw aQJ = this.jIA.cCy().aQJ();
                    String aSQ = aQJ.aSQ();
                    if (!StringUtils.isNull(aQJ.aSR())) {
                        if (!StringUtils.isNull(aSQ)) {
                            rVar.jKE.setVisibility(0);
                            rVar.jKE.startLoad(aSQ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.jKE.setVisibility(8);
                }
                if (rVar.jKF != null) {
                    rVar.jKF.setVisibility(8);
                }
                if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCy().aPk() && rVar.jKL != null) {
                    rVar.jKL.setPadding(rVar.jKL.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), rVar.jKL.getPaddingRight(), rVar.jKL.getPaddingBottom());
                }
            }
            rVar.jKC.getLayoutStrategy().oa(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.ddJ()));
            if (postData.ddN() > 0 && postData.ddG() != null && postData.ddG().size() > 0) {
                if (this.jJs == null) {
                    this.jJs = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.jJs.setIsFromCDN(this.mIsFromCDN);
                    this.jJs.T(this.jIK);
                    if (this.jIA != null) {
                        this.jJs.Y(this.jIA.cCN(), TextUtils.equals(this.jIA.cCy().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.jJs.setThreadData(this.jIA.cCy());
                    }
                }
                this.jJs.JP(postData.getId());
            }
            rVar.jKC.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.jIB) {
                rVar.jKC.getLayoutStrategy().od(R.drawable.transparent_bg);
            } else {
                rVar.jKC.getLayoutStrategy().od(R.drawable.icon_click);
            }
            rVar.jKC.setIsFromCDN(this.mIsFromCDN);
            if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCy().isLinkThread()) {
                a(rVar, this.jIA.cCy().aSc());
            }
            boolean z7 = false;
            if (this.jIA != null && this.jIA.cCy() != null) {
                z7 = this.jIA.cCy().isShareThread && postData.ddU() != null;
            }
            if (z7) {
                rVar.jKC.getLayoutStrategy().oj(bb(R.dimen.tbds14));
                a(rVar, postData);
            } else {
                rVar.jKC.getLayoutStrategy().oj(bb(R.dimen.tbds24));
            }
            TbRichText ddL = postData.ddL();
            if (this.jIA != null && this.jIA.aWj()) {
                ddL = null;
            }
            if (this.jIA.cCy() != null) {
                rVar.jKC.setIsUseGridImage(this.jIA.cCy().aSv());
                rVar.jKC.setmIsGridImageSupportLongPress(true);
            }
            if (this.jIA != null && 3 == this.jIA.cDc()) {
                if (this.jKs || !this.jKt) {
                    rVar.jKC.setText(ddL, false, this.jJr, true, false);
                } else {
                    rVar.jKC.setText(ddL, true, this.jJr, true, false);
                }
            } else if (this.jKs || !this.jKt) {
                rVar.jKC.setText(ddL, false, this.jJr, false, true);
            } else {
                rVar.jKC.setText(ddL, true, this.jJr, false, true);
            }
            a(rVar, postData, ddL);
            boolean z8 = !StringUtils.isNull(postData.aQx().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.jIA != null && this.jIA.cCN() != 0) {
                if (this.jIA.cCN() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aQx() != null) {
                    String userId = postData.aQx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCy().aQx() != null && postData.aQx() != null) {
                String userId2 = this.jIA.cCy().aQx().getUserId();
                String userId3 = postData.aQx().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aQx() == null && UtilHelper.isCurrentAccount(postData.aQx().getUserId())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        boolean z11 = z3;
                        z4 = z2;
                        z5 = z11;
                    }
                    if (z8) {
                        z6 = z4;
                    } else {
                        z9 = false;
                        z6 = false;
                        z = false;
                    }
                    int i2 = 1;
                    if (postData.ddJ() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
                        }
                        if (this.jIA != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jIA.cCN()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aQx().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aQx().getName_show());
                        }
                        if (this.jIA != null && this.jIA.cCy() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jIA.cCy().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        if (this.jIA != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jIA.cCN()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(rVar);
                }
            }
            z = false;
            z2 = z10;
            z3 = false;
            if (postData.aQx() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.ddJ() == 1) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z9) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(rVar);
        }
    }

    private void b(final r rVar, final PostData postData, final View view, final int i) {
        boolean z = false;
        if (rVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            rVar.jKC.setTag(sparseArray);
            rVar.jJB.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            rVar.jKC.setIsHost(true);
            if (this.jKr) {
                rVar.dIS.setVisibility(0);
            } else {
                rVar.dIS.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jIB) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.jKC.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.jKC.setLayoutParams(layoutParams);
                rVar.jKC.ze(null);
                this.jKu = false;
                a(rVar, postData, view, i);
            } else {
                this.jKu = true;
                rVar.jKC.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.q.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bjo() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.jKC.getLayoutParams();
                        layoutParams2.topMargin = q.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = q.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        rVar.jKC.setLayoutParams(layoutParams2);
                        q.this.a(rVar, postData, view, i);
                    }
                });
            }
            if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCy().aPk() && this.jIA.cCy().aQQ() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.jIA.getForum().getName())) {
                rVar.A(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.ddL() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.ddL().bis())) {
                rVar.A(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                rVar.A(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.ddL() != null) {
                if (postData.ddL().aja() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.ahY.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    rVar.ahY.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.ahY.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    rVar.ahY.setLayoutParams(layoutParams3);
                }
            }
            if (this.jIA.cCy() != null && this.jIA.cCy().aRn() != null && this.jIA.cCy().aQQ() == null) {
                rVar.ahY.setVisibility(0);
                rVar.ahY.setData(this.jIA.cCy().aRn());
                if (this.jIA.getForum() != null) {
                    rVar.ahY.setForumId(String.valueOf(this.jIA.getForum().getId()));
                }
                if (this.jIA.getThreadId() != null) {
                    rVar.ahY.setThreadId(this.jIA.getThreadId());
                }
                AppletsCellView appletsCellView = rVar.ahY;
                AppletsCellView appletsCellView2 = rVar.ahY;
                appletsCellView.setFrom("PB_card");
            } else {
                rVar.ahY.setVisibility(8);
            }
            if (this.jIA != null && this.jIA.cCy() != null && (this.jIA.cCy().aQM() != 0 || this.jIA.cCy().aPk())) {
                rVar.b(this.jIA, this.jIA.cCy().aQt() == 1, this.jIA.cCy().aQs() == 1);
            }
            if (this.jIA != null && this.jIA.jFd != null) {
                if (rVar.jKH != null) {
                    if (TextUtils.isEmpty(this.jIA.jFd.cDk())) {
                        rVar.jKH.setVisibility(8);
                    } else {
                        rVar.jKH.setVisibility(0);
                        rVar.jKH.setText(this.jIA.jFd.cDk());
                    }
                }
                if (rVar.jKG != null && rVar.jKN.getRootView() == null) {
                    rVar.jKG.addView(rVar.jKN.G(this.jIA));
                    String fromPageKey = UtilHelper.getFromPageKey(this.jHL.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 1).aUT();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 3).aUT();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 2).aUT();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 4).aUT();
                        }
                    }
                }
            }
        }
    }

    private void a(r rVar, PostData postData) {
        View view;
        if (rVar != null && postData != null) {
            rVar.jKJ.setVisibility(0);
            if (rVar.jKK == null) {
                rVar.jKK = m(postData);
            }
            if (rVar.jKJ.getChildCount() <= 0 && (view = rVar.jKK.getView()) != null) {
                rVar.jKJ.addView(view);
            }
            rVar.jKK.a(this.jKw);
            rVar.jKK.a(this.jKx);
            rVar.jKK.g(postData.ddU());
            rVar.jKK.onChangeSkinType(this.jHL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.ddU() != null && postData.ddU().aPh()) {
            BaijiahaoData baijiahaoData = postData.ddU().oriUgcInfo;
            if (postData.ddU().dCi) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.jHL.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.jHL.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jHL.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jHL.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jHL.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.jHL.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.ddU().showType == 0 || postData.ddU().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jHL.getPageContext(), this.pageFromType);
            } else if (postData.ddU().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jHL.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.jHL.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int bb(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(r rVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl()) && afVar.aOZ() == com.baidu.tbadk.core.data.af.dCM) {
            if (!afVar.aPa()) {
                rVar.jKC.getLayoutStrategy().oj(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            rVar.jKI.a(afVar);
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cKn() == null) {
            rVar.jJV.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cKn(), rVar.jJV, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.jKC.setTextViewOnTouchListener(this.jKv);
        rVar.jKC.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.jII);
            tbRichTextView.getLayoutStrategy().ob(min);
            tbRichTextView.getLayoutStrategy().oc((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.jJB.setOnTouchListener(this.efF);
        rVar.jJB.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.jKg.cFs().jHX;
        rVar.jKC.setOnLongClickListener(this.mOnLongClickListener);
        rVar.jKC.setOnTouchListener(this.jKv);
        rVar.jKC.setCommonTextViewOnClickListener(this.aIH);
        rVar.jKC.setOnImageClickListener(this.eBN);
        rVar.jKC.setOnImageTouchListener(this.jKv);
        rVar.jKC.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        rVar.jKC.setOnEmotionClickListener(aVar.jXl);
        rVar.jJV.setOnClickListener(this.aIH);
        rVar.jKL.setAfterItemClickListener(this.aIH);
        rVar.jKM.setAfterItemClickListener(this.aIH);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jIA = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.jII = i;
    }

    public void re(boolean z) {
        this.jIB = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jIK = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBN = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.efF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.jJr = cVar;
    }

    public void rr(boolean z) {
        this.jKr = z;
    }

    public void release() {
        if (this.TM != 0) {
            ((r) this.TM).jKI.destroy();
            ((r) this.TM).jKM.destroy();
        }
    }

    public void resume() {
        if (this.TM != 0) {
            ((r) this.TM).jKI.resume();
        }
    }

    public void pause() {
        if (this.TM != 0) {
            ((r) this.TM).jKI.pause();
        }
    }

    public r cEt() {
        return (r) this.TM;
    }
}
