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
    private View.OnClickListener akt;
    private TbRichTextView.i dMw;
    private com.baidu.tieba.pb.a.c dqJ;
    protected com.baidu.tieba.pb.data.e iEG;
    protected boolean iEH;
    protected int iEO;
    private View.OnClickListener iEQ;
    private TbRichTextView.c iFw;
    private com.baidu.tieba.pb.pb.sub.b iFx;
    private boolean iGp;
    private boolean iGq;
    private final boolean iGr;
    private boolean iGs;
    private com.baidu.tieba.pb.a.c iGt;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> iGu;
    private b.a iGv;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iEO = 0;
        this.iEH = true;
        this.iGp = true;
        this.iEG = null;
        this.iFx = null;
        this.iEQ = null;
        this.akt = null;
        this.dMw = null;
        this.dqJ = null;
        this.mOnLongClickListener = null;
        this.iFw = null;
        this.iGq = false;
        this.iGr = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.iGs = false;
        this.pageFromType = 0;
        this.iGt = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.dqJ != null) {
                    p.this.dqJ.Q(view);
                    p.this.dqJ.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.iGu = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.aAe() != null && aVar.aAe().cTP != null && p.this.iEG != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAe().cTP;
                    String threadId = p.this.iEG.getThreadId();
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
        this.iGv = new b.a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.aAe() != null && aVar.aAe().cTP != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAe().cTP;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.clz() != null) {
            this.pageFromType = pbFragment.clz().cof();
        }
    }

    private void a(q qVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (qVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(qVar.cVt, R.color.cp_bg_line_c);
                qVar.iGA.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                qVar.OO.onChangeSkinType();
                if (qVar.iGJ != null) {
                    qVar.iGJ.onChangeSkinType();
                }
                if (qVar.iGK != null) {
                    qVar.iGK.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(qVar.iGF, (int) R.color.cp_cont_j);
                qVar.iGL.pk(skinType);
            }
            qVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public q b(ViewGroup viewGroup) {
        q qVar = new q(this.iDW.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.iEH, this.iEO);
        a(qVar);
        qVar.iGG.yM(this.pageFromType);
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
            postData2.aDu();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iDW.getUniqueId(), this.iEG, postData2, postData2.locate, 1);
            b(qVar, postData2, view, i);
        }
        if (!this.iGq && this.iGr && qVar != null && qVar.iGA.aUG() && (listView = this.iDW.getListView()) != null) {
            this.iGq = true;
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
        if (this.iEG != null) {
            if (postData.cKY() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    qVar.iGA.setOnClickListener(this.akt);
                    qVar.iGA.setTextViewOnClickListener(this.akt);
                } else {
                    qVar.iGA.setOnClickListener(null);
                    qVar.iGA.setTextViewOnClickListener(null);
                }
                qVar.iFC.setOnClickListener(this.akt);
            } else {
                qVar.iFC.setOnClickListener(null);
            }
            if (postData.cKY() == 1) {
                qVar.a(this.iEG, this.iDW.clp(), postData.khd);
                a(qVar.iGA, view, this.iGs);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCm() != null) {
                    j = postData.aCm().getUserIdLong();
                    str = postData.aCm().getUserName();
                    str2 = postData.aCm().getName_show();
                }
                if (this.iEG != null && this.iEG.cks() != null) {
                    qVar.iGG.a(postData.cLg(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iEG.cks().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.iDW.cmr().cqn()) {
                    qVar.iGA.setVisibility(8);
                }
                if (this.iEG != null && this.iEG.cks() != null && this.iEG.cks().aCy() != null) {
                    bv aCy = this.iEG.cks().aCy();
                    String aEx = aCy.aEx();
                    if (!StringUtils.isNull(aCy.aEy())) {
                        if (!StringUtils.isNull(aEx)) {
                            qVar.iGC.setVisibility(0);
                            qVar.iGC.startLoad(aEx, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    qVar.iGC.setVisibility(8);
                }
                if (qVar.iGD != null) {
                    qVar.iGD.setVisibility(8);
                }
                if (this.iEG != null && this.iEG.cks() != null && this.iEG.cks().aAZ() && qVar.iGJ != null) {
                    qVar.iGJ.setPadding(qVar.iGJ.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), qVar.iGJ.getPaddingRight(), qVar.iGJ.getPaddingBottom());
                }
            }
            qVar.iGA.getLayoutStrategy().nh(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cKY()));
            if (postData.cLc() > 0 && postData.cKV() != null && postData.cKV().size() > 0) {
                if (this.iFx == null) {
                    this.iFx = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.iFx.setIsFromCDN(this.mIsFromCDN);
                    this.iFx.S(this.iEQ);
                    if (this.iEG != null) {
                        this.iFx.O(this.iEG.ckE(), TextUtils.equals(this.iEG.cks().aCm().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.iFx.setThreadData(this.iEG.cks());
                    }
                }
                this.iFx.Gr(postData.getId());
            }
            qVar.iGA.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.iEH) {
                qVar.iGA.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                qVar.iGA.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            qVar.iGA.setIsFromCDN(this.mIsFromCDN);
            if (this.iEG != null && this.iEG.cks() != null && this.iEG.cks().isLinkThread()) {
                a(qVar, this.iEG.cks().aDL());
            }
            boolean z7 = false;
            if (this.iEG != null && this.iEG.cks() != null) {
                z7 = this.iEG.cks().isShareThread && postData.cLj() != null;
            }
            if (z7) {
                qVar.iGA.getLayoutStrategy().nq(yL(R.dimen.tbds14));
                a(qVar, postData);
            } else {
                qVar.iGA.getLayoutStrategy().nq(yL(R.dimen.tbds24));
            }
            TbRichText cLa = postData.cLa();
            if (this.iEG != null && this.iEG.aHI()) {
                cLa = null;
            }
            if (this.iEG.cks() != null) {
                qVar.iGA.setIsUseGridImage(this.iEG.cks().aEe());
                qVar.iGA.setmIsGridImageSupportLongPress(true);
            }
            if (this.iEG != null && 3 == this.iEG.ckT()) {
                if (this.iGq || !this.iGr) {
                    qVar.iGA.setText(cLa, false, this.iFw, true, false);
                } else {
                    qVar.iGA.setText(cLa, true, this.iFw, true, false);
                }
            } else if (this.iGq || !this.iGr) {
                qVar.iGA.setText(cLa, false, this.iFw, false, true);
            } else {
                qVar.iGA.setText(cLa, true, this.iFw, false, true);
            }
            a(qVar, postData, cLa);
            boolean z8 = !StringUtils.isNull(postData.aCm().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.iEG != null && this.iEG.ckE() != 0) {
                if (this.iEG.ckE() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aCm() != null) {
                    String userId = postData.aCm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.iEG != null && this.iEG.cks() != null && this.iEG.cks().aCm() != null && postData.aCm() != null) {
                String userId2 = this.iEG.cks().aCm().getUserId();
                String userId3 = postData.aCm().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aCm() == null && UtilHelper.isCurrentAccount(postData.aCm().getUserId())) {
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
                    if (postData.cKY() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aCm() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCm().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCm().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCm().getPortrait());
                        }
                        if (this.iEG != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEG.ckE()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aCm() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCm().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCm().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCm().getName_show());
                        }
                        if (this.iEG != null && this.iEG.cks() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iEG.cks().getId());
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
                        if (this.iEG != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEG.ckE()));
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
            if (postData.aCm() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.cKY() == 1) {
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
            qVar.iGA.setTag(sparseArray);
            qVar.iFC.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            qVar.iGA.setIsHost(true);
            if (this.iGp) {
                qVar.cVt.setVisibility(0);
            } else {
                qVar.cVt.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEH) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.iGA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                qVar.iGA.setLayoutParams(layoutParams);
                qVar.iGA.wh(null);
                this.iGs = false;
                a(qVar, postData, view, i);
            } else {
                this.iGs = true;
                qVar.iGA.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void aUM() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.iGA.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        qVar.iGA.setLayoutParams(layoutParams2);
                        p.this.a(qVar, postData, view, i);
                    }
                });
            }
            if (this.iEG != null && this.iEG.cks() != null && this.iEG.cks().aAZ() && this.iEG.cks().aCD() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.iEG.getForum().getName())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cLa() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cLa().aTQ())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cLa() != null) {
                if (postData.cLa().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.OO.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    qVar.OO.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) qVar.OO.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    qVar.OO.setLayoutParams(layoutParams3);
                }
            }
            if (this.iEG.cks() != null && this.iEG.cks().aCY() != null && this.iEG.cks().aCD() == null) {
                qVar.OO.setVisibility(0);
                qVar.OO.setData(this.iEG.cks().aCY());
                if (this.iEG.getForum() != null) {
                    qVar.OO.setForumId(String.valueOf(this.iEG.getForum().getId()));
                }
                if (this.iEG.getThreadId() != null) {
                    qVar.OO.setThreadId(this.iEG.getThreadId());
                }
                AppletsCellView appletsCellView = qVar.OO;
                AppletsCellView appletsCellView2 = qVar.OO;
                appletsCellView.setFrom("PB_card");
            } else {
                qVar.OO.setVisibility(8);
            }
            if (this.iEG != null && this.iEG.cks() != null && (this.iEG.cks().aCB() != 0 || this.iEG.cks().aAZ())) {
                qVar.b(this.iEG, this.iEG.cks().aCi() == 1, this.iEG.cks().aCh() == 1);
            }
            if (this.iEG != null && this.iEG.iBD != null) {
                if (qVar.iGF != null) {
                    if (TextUtils.isEmpty(this.iEG.iBD.ckZ())) {
                        qVar.iGF.setVisibility(8);
                    } else {
                        qVar.iGF.setVisibility(0);
                        qVar.iGF.setText(this.iEG.iBD.ckZ());
                    }
                }
                if (qVar.iGE != null && qVar.iGL.getRootView() == null) {
                    qVar.iGE.addView(qVar.iGL.E(this.iEG));
                    String fromPageKey = UtilHelper.getFromPageKey(this.iDW.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 1).aGx();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 3).aGx();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 2).aGx();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 4).aGx();
                        }
                    }
                }
            }
        }
    }

    private void a(q qVar, PostData postData) {
        View view;
        if (qVar != null && postData != null) {
            qVar.iGH.setVisibility(0);
            if (qVar.iGI == null) {
                qVar.iGI = j(postData);
            }
            if (qVar.iGH.getChildCount() <= 0 && (view = qVar.iGI.getView()) != null) {
                qVar.iGH.addView(view);
            }
            qVar.iGI.a(this.iGu);
            qVar.iGI.a(this.iGv);
            qVar.iGI.g(postData.cLj());
            qVar.iGI.onChangeSkinType(this.iDW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cLj() != null && postData.cLj().aAW()) {
            BaijiahaoData baijiahaoData = postData.cLj().oriUgcInfo;
            if (postData.cLj().cOJ) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.iDW.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.iDW.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iDW.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iDW.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iDW.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.iDW.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cLj().showType == 0 || postData.cLj().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iDW.getPageContext(), this.pageFromType);
            } else if (postData.cLj().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iDW.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.iDW.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int yL(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(q qVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.aAO() == com.baidu.tbadk.core.data.ag.cPo) {
            if (!agVar.aAP()) {
                qVar.iGA.getLayoutStrategy().nq(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            qVar.iGG.a(agVar);
        }
    }

    private void a(q qVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.crX() == null) {
            qVar.iFU.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.crX(), qVar.iFU, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(q qVar) {
        qVar.iGA.setTextViewOnTouchListener(this.iGt);
        qVar.iGA.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.iEO);
            tbRichTextView.getLayoutStrategy().ni(min);
            tbRichTextView.getLayoutStrategy().nj((int) (min * 1.618f));
        }
    }

    private void c(q qVar) {
        qVar.iFC.setOnTouchListener(this.dqJ);
        qVar.iFC.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.iGe.cng().iEi;
        qVar.iGA.setOnLongClickListener(this.mOnLongClickListener);
        qVar.iGA.setOnTouchListener(this.iGt);
        qVar.iGA.setCommonTextViewOnClickListener(this.akt);
        qVar.iGA.setOnImageClickListener(this.dMw);
        qVar.iGA.setOnImageTouchListener(this.iGt);
        qVar.iGA.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        qVar.iGA.setOnEmotionClickListener(aVar.iSE);
        qVar.iFU.setOnClickListener(this.akt);
        qVar.iGJ.setAfterItemClickListener(this.akt);
        qVar.iGK.setAfterItemClickListener(this.akt);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEG = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.iEO = i;
    }

    public void pw(boolean z) {
        this.iEH = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iEQ = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqJ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.iFw = cVar;
    }

    public void pJ(boolean z) {
        this.iGp = z;
    }

    public void release() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGG.destroy();
            ((q) this.Ai).iGK.destroy();
        }
    }

    public void resume() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGG.resume();
        }
    }

    public void pause() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGG.pause();
        }
    }

    public q cmg() {
        return (q) this.Ai;
    }
}
