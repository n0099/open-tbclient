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
    private View.OnClickListener aDi;
    private com.baidu.tieba.pb.a.c dRm;
    private TbRichTextView.i emX;
    protected com.baidu.tieba.pb.data.e jqG;
    protected boolean jqH;
    protected int jqO;
    private View.OnClickListener jqQ;
    private TbRichTextView.c jrw;
    private com.baidu.tieba.pb.pb.sub.b jrx;
    private boolean jsp;
    private boolean jsq;
    private final boolean jsr;
    private boolean jss;
    private com.baidu.tieba.pb.a.c jst;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> jsu;
    private b.a jsv;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jqO = 0;
        this.jqH = true;
        this.jsp = true;
        this.jqG = null;
        this.jrx = null;
        this.jqQ = null;
        this.aDi = null;
        this.emX = null;
        this.dRm = null;
        this.mOnLongClickListener = null;
        this.jrw = null;
        this.jsq = false;
        this.jsr = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.jss = false;
        this.pageFromType = 0;
        this.jst = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.dRm != null) {
                    p.this.dRm.S(view);
                    p.this.dRm.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.jsu = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.aIu() != null && aVar.aIu().dtt != null && p.this.jqG != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aIu().dtt;
                    String threadId = p.this.jqG.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").cI("tid", threadId).cI("obj_source", str).af("obj_type", i));
                    }
                }
            }
        };
        this.jsv = new b.a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.aIu() != null && aVar.aIu().dtt != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aIu().dtt;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.cwA() != null) {
            this.pageFromType = pbFragment.cwA().czg();
        }
    }

    private void a(q qVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (qVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(qVar.duX, R.color.cp_bg_line_c);
                qVar.jsA.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                qVar.ahv.onChangeSkinType();
                if (qVar.jsJ != null) {
                    qVar.jsJ.onChangeSkinType();
                }
                if (qVar.jsK != null) {
                    qVar.jsK.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(qVar.jsF, (int) R.color.cp_cont_j);
                qVar.jsL.pH(skinType);
            }
            qVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public q b(ViewGroup viewGroup) {
        q qVar = new q(this.jpW.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.jqH, this.jqO);
        a(qVar);
        qVar.jsG.zv(this.pageFromType);
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
            postData2.aLL();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.jpW.getUniqueId(), this.jqG, postData2, postData2.locate, 1);
            b(qVar, postData2, view, i);
        }
        if (!this.jsq && this.jsr && qVar != null && qVar.jsA.bcV() && (listView = this.jpW.getListView()) != null) {
            this.jsq = true;
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
        if (this.jqG != null) {
            if (postData.cWo() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    qVar.jsA.setOnClickListener(this.aDi);
                    qVar.jsA.setTextViewOnClickListener(this.aDi);
                } else {
                    qVar.jsA.setOnClickListener(null);
                    qVar.jsA.setTextViewOnClickListener(null);
                }
                qVar.jrC.setOnClickListener(this.aDi);
            } else {
                qVar.jrC.setOnClickListener(null);
            }
            if (postData.cWo() == 1) {
                qVar.a(this.jqG, this.jpW.cwq(), postData.kTe);
                a(qVar.jsA, view, this.jss);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aKC() != null) {
                    j = postData.aKC().getUserIdLong();
                    str = postData.aKC().getUserName();
                    str2 = postData.aKC().getName_show();
                }
                if (this.jqG != null && this.jqG.cvr() != null) {
                    qVar.jsG.a(postData.cWw(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jqG.cvr().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.jpW.cxs().cBo()) {
                    qVar.jsA.setVisibility(8);
                }
                if (this.jqG != null && this.jqG.cvr() != null && this.jqG.cvr().aKO() != null) {
                    bv aKO = this.jqG.cvr().aKO();
                    String aMP = aKO.aMP();
                    if (!StringUtils.isNull(aKO.aMQ())) {
                        if (!StringUtils.isNull(aMP)) {
                            qVar.jsC.setVisibility(0);
                            qVar.jsC.startLoad(aMP, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    qVar.jsC.setVisibility(8);
                }
                if (qVar.jsD != null) {
                    qVar.jsD.setVisibility(8);
                }
                if (this.jqG != null && this.jqG.cvr() != null && this.jqG.cvr().aJp() && qVar.jsJ != null) {
                    qVar.jsJ.setPadding(qVar.jsJ.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), qVar.jsJ.getPaddingRight(), qVar.jsJ.getPaddingBottom());
                }
            }
            qVar.jsA.getLayoutStrategy().nv(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cWo()));
            if (postData.cWs() > 0 && postData.cWl() != null && postData.cWl().size() > 0) {
                if (this.jrx == null) {
                    this.jrx = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.jrx.setIsFromCDN(this.mIsFromCDN);
                    this.jrx.T(this.jqQ);
                    if (this.jqG != null) {
                        this.jrx.U(this.jqG.cvD(), TextUtils.equals(this.jqG.cvr().aKC().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.jrx.setThreadData(this.jqG.cvr());
                    }
                }
                this.jrx.Ic(postData.getId());
            }
            qVar.jsA.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.jqH) {
                qVar.jsA.getLayoutStrategy().ny(R.drawable.transparent_bg);
            } else {
                qVar.jsA.getLayoutStrategy().ny(R.drawable.icon_click);
            }
            qVar.jsA.setIsFromCDN(this.mIsFromCDN);
            if (this.jqG != null && this.jqG.cvr() != null && this.jqG.cvr().isLinkThread()) {
                a(qVar, this.jqG.cvr().aMd());
            }
            boolean z7 = false;
            if (this.jqG != null && this.jqG.cvr() != null) {
                z7 = this.jqG.cvr().isShareThread && postData.cWz() != null;
            }
            if (z7) {
                qVar.jsA.getLayoutStrategy().nE(zu(R.dimen.tbds14));
                a(qVar, postData);
            } else {
                qVar.jsA.getLayoutStrategy().nE(zu(R.dimen.tbds24));
            }
            TbRichText cWq = postData.cWq();
            if (this.jqG != null && this.jqG.aQe()) {
                cWq = null;
            }
            if (this.jqG.cvr() != null) {
                qVar.jsA.setIsUseGridImage(this.jqG.cvr().aMw());
                qVar.jsA.setmIsGridImageSupportLongPress(true);
            }
            if (this.jqG != null && 3 == this.jqG.cvS()) {
                if (this.jsq || !this.jsr) {
                    qVar.jsA.setText(cWq, false, this.jrw, true, false);
                } else {
                    qVar.jsA.setText(cWq, true, this.jrw, true, false);
                }
            } else if (this.jsq || !this.jsr) {
                qVar.jsA.setText(cWq, false, this.jrw, false, true);
            } else {
                qVar.jsA.setText(cWq, true, this.jrw, false, true);
            }
            a(qVar, postData, cWq);
            boolean z8 = !StringUtils.isNull(postData.aKC().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.jqG != null && this.jqG.cvD() != 0) {
                if (this.jqG.cvD() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aKC() != null) {
                    String userId = postData.aKC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.jqG != null && this.jqG.cvr() != null && this.jqG.cvr().aKC() != null && postData.aKC() != null) {
                String userId2 = this.jqG.cvr().aKC().getUserId();
                String userId3 = postData.aKC().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aKC() == null && UtilHelper.isCurrentAccount(postData.aKC().getUserId())) {
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
                    if (postData.cWo() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aKC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aKC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKC().getPortrait());
                        }
                        if (this.jqG != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqG.cvD()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aKC() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKC().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKC().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKC().getName_show());
                        }
                        if (this.jqG != null && this.jqG.cvr() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jqG.cvr().getId());
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
                        if (this.jqG != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqG.cvD()));
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
            if (postData.aKC() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.cWo() == 1) {
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
            qVar.jsA.setTag(sparseArray);
            qVar.jrC.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            qVar.jsA.setIsHost(true);
            if (this.jsp) {
                qVar.duX.setVisibility(0);
            } else {
                qVar.duX.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jqH) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.jsA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                qVar.jsA.setLayoutParams(layoutParams);
                qVar.jsA.xy(null);
                this.jss = false;
                a(qVar, postData, view, i);
            } else {
                this.jss = true;
                qVar.jsA.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bdb() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.jsA.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        qVar.jsA.setLayoutParams(layoutParams2);
                        p.this.a(qVar, postData, view, i);
                    }
                });
            }
            if (this.jqG != null && this.jqG.cvr() != null && this.jqG.cvr().aJp() && this.jqG.cvr().aKT() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.jqG.getForum().getName())) {
                qVar.x(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cWq() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cWq().bcf())) {
                qVar.x(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                qVar.x(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cWq() != null) {
                if (postData.cWq().afL() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.ahv.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    qVar.ahv.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) qVar.ahv.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    qVar.ahv.setLayoutParams(layoutParams3);
                }
            }
            if (this.jqG.cvr() != null && this.jqG.cvr().aLo() != null && this.jqG.cvr().aKT() == null) {
                qVar.ahv.setVisibility(0);
                qVar.ahv.setData(this.jqG.cvr().aLo());
                if (this.jqG.getForum() != null) {
                    qVar.ahv.setForumId(String.valueOf(this.jqG.getForum().getId()));
                }
                if (this.jqG.getThreadId() != null) {
                    qVar.ahv.setThreadId(this.jqG.getThreadId());
                }
                AppletsCellView appletsCellView = qVar.ahv;
                AppletsCellView appletsCellView2 = qVar.ahv;
                appletsCellView.setFrom("PB_card");
            } else {
                qVar.ahv.setVisibility(8);
            }
            if (this.jqG != null && this.jqG.cvr() != null && (this.jqG.cvr().aKR() != 0 || this.jqG.cvr().aJp())) {
                qVar.b(this.jqG, this.jqG.cvr().aKy() == 1, this.jqG.cvr().aKx() == 1);
            }
            if (this.jqG != null && this.jqG.jnB != null) {
                if (qVar.jsF != null) {
                    if (TextUtils.isEmpty(this.jqG.jnB.cwa())) {
                        qVar.jsF.setVisibility(8);
                    } else {
                        qVar.jsF.setVisibility(0);
                        qVar.jsF.setText(this.jqG.jnB.cwa());
                    }
                }
                if (qVar.jsE != null && qVar.jsL.getRootView() == null) {
                    qVar.jsE.addView(qVar.jsL.E(this.jqG));
                    String fromPageKey = UtilHelper.getFromPageKey(this.jpW.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 1).aOO();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 3).aOO();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 2).aOO();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 4).aOO();
                        }
                    }
                }
            }
        }
    }

    private void a(q qVar, PostData postData) {
        View view;
        if (qVar != null && postData != null) {
            qVar.jsH.setVisibility(0);
            if (qVar.jsI == null) {
                qVar.jsI = j(postData);
            }
            if (qVar.jsH.getChildCount() <= 0 && (view = qVar.jsI.getView()) != null) {
                qVar.jsH.addView(view);
            }
            qVar.jsI.a(this.jsu);
            qVar.jsI.a(this.jsv);
            qVar.jsI.g(postData.cWz());
            qVar.jsI.onChangeSkinType(this.jpW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cWz() != null && postData.cWz().aJm()) {
            BaijiahaoData baijiahaoData = postData.cWz().oriUgcInfo;
            if (postData.cWz().doi) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.jpW.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.jpW.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jpW.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jpW.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jpW.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.jpW.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cWz().showType == 0 || postData.cWz().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jpW.getPageContext(), this.pageFromType);
            } else if (postData.cWz().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jpW.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.jpW.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int zu(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(q qVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.aJe() == com.baidu.tbadk.core.data.ag.doN) {
            if (!agVar.aJf()) {
                qVar.jsA.getLayoutStrategy().nE(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            qVar.jsG.a(agVar);
        }
    }

    private void a(q qVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cCY() == null) {
            qVar.jrU.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cCY(), qVar.jrU, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(q qVar) {
        qVar.jsA.setTextViewOnTouchListener(this.jst);
        qVar.jsA.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.jqO);
            tbRichTextView.getLayoutStrategy().nw(min);
            tbRichTextView.getLayoutStrategy().nx((int) (min * 1.618f));
        }
    }

    private void c(q qVar) {
        qVar.jrC.setOnTouchListener(this.dRm);
        qVar.jrC.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.jse.cyh().jqi;
        qVar.jsA.setOnLongClickListener(this.mOnLongClickListener);
        qVar.jsA.setOnTouchListener(this.jst);
        qVar.jsA.setCommonTextViewOnClickListener(this.aDi);
        qVar.jsA.setOnImageClickListener(this.emX);
        qVar.jsA.setOnImageTouchListener(this.jst);
        qVar.jsA.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        qVar.jsA.setOnEmotionClickListener(aVar.jEG);
        qVar.jrU.setOnClickListener(this.aDi);
        qVar.jsJ.setAfterItemClickListener(this.aDi);
        qVar.jsK.setAfterItemClickListener(this.aDi);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqG = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.jqO = i;
    }

    public void qG(boolean z) {
        this.jqH = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqQ = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emX = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.jrw = cVar;
    }

    public void qT(boolean z) {
        this.jsp = z;
    }

    public void release() {
        if (this.TA != 0) {
            ((q) this.TA).jsG.destroy();
            ((q) this.TA).jsK.destroy();
        }
    }

    public void resume() {
        if (this.TA != 0) {
            ((q) this.TA).jsG.resume();
        }
    }

    public void pause() {
        if (this.TA != 0) {
            ((q) this.TA).jsG.pause();
        }
    }

    public q cxh() {
        return (q) this.TA;
    }
}
