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
    private TbRichTextView.i eBC;
    private com.baidu.tieba.pb.a.c efF;
    protected int jHC;
    private View.OnClickListener jHE;
    protected com.baidu.tieba.pb.data.e jHu;
    protected boolean jHv;
    private TbRichTextView.c jIl;
    private com.baidu.tieba.pb.pb.sub.b jIm;
    private boolean jJl;
    private boolean jJm;
    private final boolean jJn;
    private boolean jJo;
    private com.baidu.tieba.pb.a.c jJp;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> jJq;
    private b.a jJr;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jHC = 0;
        this.jHv = true;
        this.jJl = true;
        this.jHu = null;
        this.jIm = null;
        this.jHE = null;
        this.aIH = null;
        this.eBC = null;
        this.efF = null;
        this.mOnLongClickListener = null;
        this.jIl = null;
        this.jJm = false;
        this.jJn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.jJo = false;
        this.pageFromType = 0;
        this.jJp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
        this.jJq = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null && q.this.jHu != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aOi().dHm;
                    String threadId = q.this.jHu.getThreadId();
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
        this.jJr = new b.a() { // from class: com.baidu.tieba.pb.pb.main.q.3
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
        if (pbFragment != null && pbFragment.cDy() != null) {
            this.pageFromType = pbFragment.cDy().cGd();
        }
    }

    private void a(r rVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (rVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(rVar.dIS, R.color.cp_bg_line_c);
                rVar.jJw.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                rVar.ahY.onChangeSkinType();
                if (rVar.jJF != null) {
                    rVar.jJF.onChangeSkinType();
                }
                if (rVar.jJG != null) {
                    rVar.jJG.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(rVar.jJB, (int) R.color.cp_cont_j);
                rVar.jJH.qi(skinType);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public r b(ViewGroup viewGroup) {
        r rVar = new r(this.jGF.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.jHv, this.jHC);
        a(rVar);
        rVar.jJC.Ae(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.jGF.getUniqueId(), this.jHu, postData2, postData2.locate, 1);
            b(rVar, postData2, view, i);
        }
        if (!this.jJm && this.jJn && rVar != null && rVar.jJw.bjg() && (listView = this.jGF.getListView()) != null) {
            this.jJm = true;
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
        if (this.jHu != null) {
            if (postData.ddu() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.jJw.setOnClickListener(this.aIH);
                    rVar.jJw.setTextViewOnClickListener(this.aIH);
                } else {
                    rVar.jJw.setOnClickListener(null);
                    rVar.jJw.setTextViewOnClickListener(null);
                }
                rVar.jIv.setOnClickListener(this.aIH);
            } else {
                rVar.jIv.setOnClickListener(null);
            }
            if (postData.ddu() == 1) {
                rVar.a(this.jHu, this.jGF.cDo(), postData.llv);
                a(rVar.jJw, view, this.jJo);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aQx() != null) {
                    j = postData.aQx().getUserIdLong();
                    str = postData.aQx().getUserName();
                    str2 = postData.aQx().getName_show();
                }
                if (this.jHu != null && this.jHu.cCi() != null) {
                    rVar.jJC.a(postData.ddC(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jHu.cCi().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.jGF.cEo().cIl()) {
                    rVar.jJw.setVisibility(8);
                }
                if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCi().aQJ() != null) {
                    bw aQJ = this.jHu.cCi().aQJ();
                    String aSQ = aQJ.aSQ();
                    if (!StringUtils.isNull(aQJ.aSR())) {
                        if (!StringUtils.isNull(aSQ)) {
                            rVar.jJy.setVisibility(0);
                            rVar.jJy.startLoad(aSQ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.jJy.setVisibility(8);
                }
                if (rVar.jJz != null) {
                    rVar.jJz.setVisibility(8);
                }
                if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCi().aPk() && rVar.jJF != null) {
                    rVar.jJF.setPadding(rVar.jJF.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), rVar.jJF.getPaddingRight(), rVar.jJF.getPaddingBottom());
                }
            }
            rVar.jJw.getLayoutStrategy().nY(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.ddu()));
            if (postData.ddy() > 0 && postData.ddr() != null && postData.ddr().size() > 0) {
                if (this.jIm == null) {
                    this.jIm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.jIm.setIsFromCDN(this.mIsFromCDN);
                    this.jIm.T(this.jHE);
                    if (this.jHu != null) {
                        this.jIm.Y(this.jHu.cCx(), TextUtils.equals(this.jHu.cCi().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.jIm.setThreadData(this.jHu.cCi());
                    }
                }
                this.jIm.JO(postData.getId());
            }
            rVar.jJw.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.jHv) {
                rVar.jJw.getLayoutStrategy().ob(R.drawable.transparent_bg);
            } else {
                rVar.jJw.getLayoutStrategy().ob(R.drawable.icon_click);
            }
            rVar.jJw.setIsFromCDN(this.mIsFromCDN);
            if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCi().isLinkThread()) {
                a(rVar, this.jHu.cCi().aSc());
            }
            boolean z7 = false;
            if (this.jHu != null && this.jHu.cCi() != null) {
                z7 = this.jHu.cCi().isShareThread && postData.ddF() != null;
            }
            if (z7) {
                rVar.jJw.getLayoutStrategy().oh(bb(R.dimen.tbds14));
                a(rVar, postData);
            } else {
                rVar.jJw.getLayoutStrategy().oh(bb(R.dimen.tbds24));
            }
            TbRichText ddw = postData.ddw();
            if (this.jHu != null && this.jHu.aWi()) {
                ddw = null;
            }
            if (this.jHu.cCi() != null) {
                rVar.jJw.setIsUseGridImage(this.jHu.cCi().aSv());
                rVar.jJw.setmIsGridImageSupportLongPress(true);
            }
            if (this.jHu != null && 3 == this.jHu.cCM()) {
                if (this.jJm || !this.jJn) {
                    rVar.jJw.setText(ddw, false, this.jIl, true, false);
                } else {
                    rVar.jJw.setText(ddw, true, this.jIl, true, false);
                }
            } else if (this.jJm || !this.jJn) {
                rVar.jJw.setText(ddw, false, this.jIl, false, true);
            } else {
                rVar.jJw.setText(ddw, true, this.jIl, false, true);
            }
            a(rVar, postData, ddw);
            boolean z8 = !StringUtils.isNull(postData.aQx().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.jHu != null && this.jHu.cCx() != 0) {
                if (this.jHu.cCx() != 3) {
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
            if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCi().aQx() != null && postData.aQx() != null) {
                String userId2 = this.jHu.cCi().aQx().getUserId();
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
                    if (postData.ddu() == 1) {
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
                        if (this.jHu != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHu.cCx()));
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
                        if (this.jHu != null && this.jHu.cCi() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jHu.cCi().getId());
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
                        if (this.jHu != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHu.cCx()));
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
            if (postData.ddu() == 1) {
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
            rVar.jJw.setTag(sparseArray);
            rVar.jIv.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            rVar.jJw.setIsHost(true);
            if (this.jJl) {
                rVar.dIS.setVisibility(0);
            } else {
                rVar.dIS.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jHv) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.jJw.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.jJw.setLayoutParams(layoutParams);
                rVar.jJw.ze(null);
                this.jJo = false;
                a(rVar, postData, view, i);
            } else {
                this.jJo = true;
                rVar.jJw.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.q.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bjm() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.jJw.getLayoutParams();
                        layoutParams2.topMargin = q.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = q.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        rVar.jJw.setLayoutParams(layoutParams2);
                        q.this.a(rVar, postData, view, i);
                    }
                });
            }
            if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCi().aPk() && this.jHu.cCi().aQQ() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.jHu.getForum().getName())) {
                rVar.A(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.ddw() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.ddw().biq())) {
                rVar.A(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                rVar.A(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.ddw() != null) {
                if (postData.ddw().aja() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.ahY.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    rVar.ahY.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.ahY.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    rVar.ahY.setLayoutParams(layoutParams3);
                }
            }
            if (this.jHu.cCi() != null && this.jHu.cCi().aRn() != null && this.jHu.cCi().aQQ() == null) {
                rVar.ahY.setVisibility(0);
                rVar.ahY.setData(this.jHu.cCi().aRn());
                if (this.jHu.getForum() != null) {
                    rVar.ahY.setForumId(String.valueOf(this.jHu.getForum().getId()));
                }
                if (this.jHu.getThreadId() != null) {
                    rVar.ahY.setThreadId(this.jHu.getThreadId());
                }
                AppletsCellView appletsCellView = rVar.ahY;
                AppletsCellView appletsCellView2 = rVar.ahY;
                appletsCellView.setFrom("PB_card");
            } else {
                rVar.ahY.setVisibility(8);
            }
            if (this.jHu != null && this.jHu.cCi() != null && (this.jHu.cCi().aQM() != 0 || this.jHu.cCi().aPk())) {
                rVar.b(this.jHu, this.jHu.cCi().aQt() == 1, this.jHu.cCi().aQs() == 1);
            }
            if (this.jHu != null && this.jHu.jDX != null) {
                if (rVar.jJB != null) {
                    if (TextUtils.isEmpty(this.jHu.jDX.cCU())) {
                        rVar.jJB.setVisibility(8);
                    } else {
                        rVar.jJB.setVisibility(0);
                        rVar.jJB.setText(this.jHu.jDX.cCU());
                    }
                }
                if (rVar.jJA != null && rVar.jJH.getRootView() == null) {
                    rVar.jJA.addView(rVar.jJH.G(this.jHu));
                    String fromPageKey = UtilHelper.getFromPageKey(this.jGF.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 1).aUS();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 3).aUS();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 2).aUS();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").ag("obj_source", 4).aUS();
                        }
                    }
                }
            }
        }
    }

    private void a(r rVar, PostData postData) {
        View view;
        if (rVar != null && postData != null) {
            rVar.jJD.setVisibility(0);
            if (rVar.jJE == null) {
                rVar.jJE = m(postData);
            }
            if (rVar.jJD.getChildCount() <= 0 && (view = rVar.jJE.getView()) != null) {
                rVar.jJD.addView(view);
            }
            rVar.jJE.a(this.jJq);
            rVar.jJE.a(this.jJr);
            rVar.jJE.g(postData.ddF());
            rVar.jJE.onChangeSkinType(this.jGF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.ddF() != null && postData.ddF().aPh()) {
            BaijiahaoData baijiahaoData = postData.ddF().oriUgcInfo;
            if (postData.ddF().dCi) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.jGF.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.jGF.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jGF.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jGF.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jGF.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.jGF.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.ddF().showType == 0 || postData.ddF().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jGF.getPageContext(), this.pageFromType);
            } else if (postData.ddF().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jGF.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.jGF.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int bb(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(r rVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl()) && afVar.aOZ() == com.baidu.tbadk.core.data.af.dCM) {
            if (!afVar.aPa()) {
                rVar.jJw.getLayoutStrategy().oh(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            rVar.jJC.a(afVar);
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cJX() == null) {
            rVar.jIP.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cJX(), rVar.jIP, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.jJw.setTextViewOnTouchListener(this.jJp);
        rVar.jJw.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.jHC);
            tbRichTextView.getLayoutStrategy().nZ(min);
            tbRichTextView.getLayoutStrategy().oa((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.jIv.setOnTouchListener(this.efF);
        rVar.jIv.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.jJa.cFc().jGR;
        rVar.jJw.setOnLongClickListener(this.mOnLongClickListener);
        rVar.jJw.setOnTouchListener(this.jJp);
        rVar.jJw.setCommonTextViewOnClickListener(this.aIH);
        rVar.jJw.setOnImageClickListener(this.eBC);
        rVar.jJw.setOnImageTouchListener(this.jJp);
        rVar.jJw.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        rVar.jJw.setOnEmotionClickListener(aVar.jWf);
        rVar.jIP.setOnClickListener(this.aIH);
        rVar.jJF.setAfterItemClickListener(this.aIH);
        rVar.jJG.setAfterItemClickListener(this.aIH);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jHu = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.jHC = i;
    }

    public void re(boolean z) {
        this.jHv = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jHE = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.efF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.jIl = cVar;
    }

    public void rr(boolean z) {
        this.jJl = z;
    }

    public void release() {
        if (this.TM != 0) {
            ((r) this.TM).jJC.destroy();
            ((r) this.TM).jJG.destroy();
        }
    }

    public void resume() {
        if (this.TM != 0) {
            ((r) this.TM).jJC.resume();
        }
    }

    public void pause() {
        if (this.TM != 0) {
            ((r) this.TM).jJC.pause();
        }
    }

    public r cEd() {
        return (r) this.TM;
    }
}
