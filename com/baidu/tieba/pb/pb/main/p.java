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
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bv;
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
public class p extends l<PostData, q> {
    private View.OnClickListener aku;
    private TbRichTextView.i dMK;
    private com.baidu.tieba.pb.a.c dqX;
    protected com.baidu.tieba.pb.data.e iEU;
    protected boolean iEV;
    private TbRichTextView.c iFK;
    private com.baidu.tieba.pb.pb.sub.b iFL;
    protected int iFc;
    private View.OnClickListener iFe;
    private boolean iGD;
    private boolean iGE;
    private final boolean iGF;
    private boolean iGG;
    private com.baidu.tieba.pb.a.c iGH;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> iGI;
    private b.a iGJ;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iFc = 0;
        this.iEV = true;
        this.iGD = true;
        this.iEU = null;
        this.iFL = null;
        this.iFe = null;
        this.aku = null;
        this.dMK = null;
        this.dqX = null;
        this.mOnLongClickListener = null;
        this.iFK = null;
        this.iGE = false;
        this.iGF = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.iGG = false;
        this.pageFromType = 0;
        this.iGH = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.dqX != null) {
                    p.this.dqX.Q(view);
                    p.this.dqX.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.iGI = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.aAg() != null && aVar.aAg().cTR != null && p.this.iEU != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAg().cTR;
                    String threadId = p.this.iEU.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").cy("tid", threadId).cy("obj_source", str).X("obj_type", i));
                    }
                }
            }
        };
        this.iGJ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.aAg() != null && aVar.aAg().cTR != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAg().cTR;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.clC() != null) {
            this.pageFromType = pbFragment.clC().coi();
        }
    }

    private void a(q qVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (qVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(qVar.cVv, R.color.cp_bg_line_c);
                qVar.iGO.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                qVar.OO.onChangeSkinType();
                if (qVar.iGX != null) {
                    qVar.iGX.onChangeSkinType();
                }
                if (qVar.iGY != null) {
                    qVar.iGY.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(qVar.iGT, (int) R.color.cp_cont_j);
                qVar.iGZ.pk(skinType);
            }
            qVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public q b(ViewGroup viewGroup) {
        q qVar = new q(this.iEk.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.iEV, this.iFc);
        a(qVar);
        qVar.iGU.yM(this.pageFromType);
        return qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, q qVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) qVar);
        a(qVar);
        c(qVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.aDw();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iEk.getUniqueId(), this.iEU, postData2, postData2.locate, 1);
            b(qVar, postData2, view, i);
        }
        if (!this.iGE && this.iGF && qVar != null && qVar.iGO.aUJ() && (listView = this.iEk.getListView()) != null) {
            this.iGE = true;
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
    public void a(q qVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.iEU != null) {
            if (postData.cLb() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    qVar.iGO.setOnClickListener(this.aku);
                    qVar.iGO.setTextViewOnClickListener(this.aku);
                } else {
                    qVar.iGO.setOnClickListener(null);
                    qVar.iGO.setTextViewOnClickListener(null);
                }
                qVar.iFQ.setOnClickListener(this.aku);
            } else {
                qVar.iFQ.setOnClickListener(null);
            }
            if (postData.cLb() == 1) {
                qVar.a(this.iEU, this.iEk.cls(), postData.khr);
                a(qVar.iGO, view, this.iGG);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCo() != null) {
                    j = postData.aCo().getUserIdLong();
                    str = postData.aCo().getUserName();
                    str2 = postData.aCo().getName_show();
                }
                if (this.iEU != null && this.iEU.ckv() != null) {
                    qVar.iGU.a(postData.cLj(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iEU.ckv().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.iEk.cmu().cqq()) {
                    qVar.iGO.setVisibility(8);
                }
                if (this.iEU != null && this.iEU.ckv() != null && this.iEU.ckv().aCA() != null) {
                    bv aCA = this.iEU.ckv().aCA();
                    String aEz = aCA.aEz();
                    if (!StringUtils.isNull(aCA.aEA())) {
                        if (!StringUtils.isNull(aEz)) {
                            qVar.iGQ.setVisibility(0);
                            qVar.iGQ.startLoad(aEz, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    qVar.iGQ.setVisibility(8);
                }
                if (qVar.iGR != null) {
                    qVar.iGR.setVisibility(8);
                }
                if (this.iEU != null && this.iEU.ckv() != null && this.iEU.ckv().aBb() && qVar.iGX != null) {
                    qVar.iGX.setPadding(qVar.iGX.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), qVar.iGX.getPaddingRight(), qVar.iGX.getPaddingBottom());
                }
            }
            qVar.iGO.getLayoutStrategy().nh(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLb()));
            if (postData.cLf() > 0 && postData.cKY() != null && postData.cKY().size() > 0) {
                if (this.iFL == null) {
                    this.iFL = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.iFL.setIsFromCDN(this.mIsFromCDN);
                    this.iFL.S(this.iFe);
                    if (this.iEU != null) {
                        this.iFL.O(this.iEU.ckH(), TextUtils.equals(this.iEU.ckv().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.iFL.setThreadData(this.iEU.ckv());
                    }
                }
                this.iFL.Gs(postData.getId());
            }
            qVar.iGO.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.iEV) {
                qVar.iGO.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                qVar.iGO.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            qVar.iGO.setIsFromCDN(this.mIsFromCDN);
            if (this.iEU != null && this.iEU.ckv() != null && this.iEU.ckv().isLinkThread()) {
                a(qVar, this.iEU.ckv().aDN());
            }
            boolean z7 = false;
            if (this.iEU != null && this.iEU.ckv() != null) {
                z7 = this.iEU.ckv().isShareThread && postData.cLm() != null;
            }
            if (z7) {
                qVar.iGO.getLayoutStrategy().nq(yL(R.dimen.tbds14));
                a(qVar, postData);
            } else {
                qVar.iGO.getLayoutStrategy().nq(yL(R.dimen.tbds24));
            }
            TbRichText cLd = postData.cLd();
            if (this.iEU != null && this.iEU.aHL()) {
                cLd = null;
            }
            if (this.iEU.ckv() != null) {
                qVar.iGO.setIsUseGridImage(this.iEU.ckv().aEg());
                qVar.iGO.setmIsGridImageSupportLongPress(true);
            }
            if (this.iEU != null && 3 == this.iEU.ckW()) {
                if (this.iGE || !this.iGF) {
                    qVar.iGO.setText(cLd, false, this.iFK, true, false);
                } else {
                    qVar.iGO.setText(cLd, true, this.iFK, true, false);
                }
            } else if (this.iGE || !this.iGF) {
                qVar.iGO.setText(cLd, false, this.iFK, false, true);
            } else {
                qVar.iGO.setText(cLd, true, this.iFK, false, true);
            }
            a(qVar, postData, cLd);
            boolean z8 = !StringUtils.isNull(postData.aCo().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.iEU != null && this.iEU.ckH() != 0) {
                if (this.iEU.ckH() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aCo() != null) {
                    String userId = postData.aCo().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.iEU != null && this.iEU.ckv() != null && this.iEU.ckv().aCo() != null && postData.aCo() != null) {
                String userId2 = this.iEU.ckv().aCo().getUserId();
                String userId3 = postData.aCo().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aCo() == null && UtilHelper.isCurrentAccount(postData.aCo().getUserId())) {
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
                    if (postData.cLb() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
                        }
                        if (this.iEU != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEU.ckH()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCo().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCo().getName_show());
                        }
                        if (this.iEU != null && this.iEU.ckv() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iEU.ckv().getId());
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
                        if (this.iEU != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEU.ckH()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(qVar);
                }
            }
            z = false;
            z2 = z10;
            z3 = false;
            if (postData.aCo() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.cLb() == 1) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z9) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(qVar);
        }
    }

    private void b(final q qVar, final PostData postData, final View view, final int i) {
        boolean z = false;
        if (qVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            qVar.iGO.setTag(sparseArray);
            qVar.iFQ.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            qVar.iGO.setIsHost(true);
            if (this.iGD) {
                qVar.cVv.setVisibility(0);
            } else {
                qVar.cVv.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEV) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.iGO.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                qVar.iGO.setLayoutParams(layoutParams);
                qVar.iGO.wi(null);
                this.iGG = false;
                a(qVar, postData, view, i);
            } else {
                this.iGG = true;
                qVar.iGO.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void aUP() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.iGO.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        qVar.iGO.setLayoutParams(layoutParams2);
                        p.this.a(qVar, postData, view, i);
                    }
                });
            }
            if (this.iEU != null && this.iEU.ckv() != null && this.iEU.ckv().aBb() && this.iEU.ckv().aCF() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.iEU.getForum().getName())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cLd() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cLd().aTT())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cLd() != null) {
                if (postData.cLd().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.OO.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    qVar.OO.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) qVar.OO.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    qVar.OO.setLayoutParams(layoutParams3);
                }
            }
            if (this.iEU.ckv() != null && this.iEU.ckv().aDa() != null && this.iEU.ckv().aCF() == null) {
                qVar.OO.setVisibility(0);
                qVar.OO.setData(this.iEU.ckv().aDa());
                if (this.iEU.getForum() != null) {
                    qVar.OO.setForumId(String.valueOf(this.iEU.getForum().getId()));
                }
                if (this.iEU.getThreadId() != null) {
                    qVar.OO.setThreadId(this.iEU.getThreadId());
                }
                AppletsCellView appletsCellView = qVar.OO;
                AppletsCellView appletsCellView2 = qVar.OO;
                appletsCellView.setFrom("PB_card");
            } else {
                qVar.OO.setVisibility(8);
            }
            if (this.iEU != null && this.iEU.ckv() != null && (this.iEU.ckv().aCD() != 0 || this.iEU.ckv().aBb())) {
                qVar.b(this.iEU, this.iEU.ckv().aCk() == 1, this.iEU.ckv().aCj() == 1);
            }
            if (this.iEU != null && this.iEU.iBR != null) {
                if (qVar.iGT != null) {
                    if (TextUtils.isEmpty(this.iEU.iBR.clc())) {
                        qVar.iGT.setVisibility(8);
                    } else {
                        qVar.iGT.setVisibility(0);
                        qVar.iGT.setText(this.iEU.iBR.clc());
                    }
                }
                if (qVar.iGS != null && qVar.iGZ.getRootView() == null) {
                    qVar.iGS.addView(qVar.iGZ.E(this.iEU));
                    String fromPageKey = UtilHelper.getFromPageKey(this.iEk.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 1).aGz();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 3).aGz();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 2).aGz();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 4).aGz();
                        }
                    }
                }
            }
        }
    }

    private void a(q qVar, PostData postData) {
        View view;
        if (qVar != null && postData != null) {
            qVar.iGV.setVisibility(0);
            if (qVar.iGW == null) {
                qVar.iGW = j(postData);
            }
            if (qVar.iGV.getChildCount() <= 0 && (view = qVar.iGW.getView()) != null) {
                qVar.iGV.addView(view);
            }
            qVar.iGW.a(this.iGI);
            qVar.iGW.a(this.iGJ);
            qVar.iGW.g(postData.cLm());
            qVar.iGW.onChangeSkinType(this.iEk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cLm() != null && postData.cLm().aAY()) {
            BaijiahaoData baijiahaoData = postData.cLm().oriUgcInfo;
            if (postData.cLm().cOL) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.iEk.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.iEk.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iEk.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iEk.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iEk.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.iEk.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cLm().showType == 0 || postData.cLm().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iEk.getPageContext(), this.pageFromType);
            } else if (postData.cLm().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iEk.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.iEk.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int yL(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(q qVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.aAQ() == com.baidu.tbadk.core.data.ag.cPq) {
            if (!agVar.aAR()) {
                qVar.iGO.getLayoutStrategy().nq(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            qVar.iGU.a(agVar);
        }
    }

    private void a(q qVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.csa() == null) {
            qVar.iGi.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.csa(), qVar.iGi, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(q qVar) {
        qVar.iGO.setTextViewOnTouchListener(this.iGH);
        qVar.iGO.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.iFc);
            tbRichTextView.getLayoutStrategy().ni(min);
            tbRichTextView.getLayoutStrategy().nj((int) (min * 1.618f));
        }
    }

    private void c(q qVar) {
        qVar.iFQ.setOnTouchListener(this.dqX);
        qVar.iFQ.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.iGs.cnj().iEw;
        qVar.iGO.setOnLongClickListener(this.mOnLongClickListener);
        qVar.iGO.setOnTouchListener(this.iGH);
        qVar.iGO.setCommonTextViewOnClickListener(this.aku);
        qVar.iGO.setOnImageClickListener(this.dMK);
        qVar.iGO.setOnImageTouchListener(this.iGH);
        qVar.iGO.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        qVar.iGO.setOnEmotionClickListener(aVar.iSS);
        qVar.iGi.setOnClickListener(this.aku);
        qVar.iGX.setAfterItemClickListener(this.aku);
        qVar.iGY.setAfterItemClickListener(this.aku);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEU = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.iFc = i;
    }

    public void pw(boolean z) {
        this.iEV = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iFe = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMK = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqX = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.iFK = cVar;
    }

    public void pJ(boolean z) {
        this.iGD = z;
    }

    public void release() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGU.destroy();
            ((q) this.Ai).iGY.destroy();
        }
    }

    public void resume() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGU.resume();
        }
    }

    public void pause() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGU.pause();
        }
    }

    public q cmj() {
        return (q) this.Ai;
    }
}
