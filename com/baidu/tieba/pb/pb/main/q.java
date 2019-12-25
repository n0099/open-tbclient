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
/* loaded from: classes6.dex */
public class q extends m<PostData, r> {
    private View.OnClickListener ahD;
    private TbRichTextView.i dIi;
    private com.baidu.tieba.pb.a.c dmm;
    private TbRichTextView.c iAo;
    private com.baidu.tieba.pb.pb.sub.b iAp;
    private boolean iBh;
    private boolean iBi;
    private final boolean iBj;
    private boolean iBk;
    private com.baidu.tieba.pb.a.c iBl;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> iBm;
    private b.a iBn;
    protected int izD;
    private View.OnClickListener izF;
    protected com.baidu.tieba.pb.data.f izv;
    protected boolean izw;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.izD = 0;
        this.izw = true;
        this.iBh = true;
        this.izv = null;
        this.iAp = null;
        this.izF = null;
        this.ahD = null;
        this.dIi = null;
        this.dmm = null;
        this.mOnLongClickListener = null;
        this.iAo = null;
        this.iBi = false;
        this.iBj = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.iBk = false;
        this.pageFromType = 0;
        this.iBl = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.dmm != null) {
                    q.this.dmm.O(view);
                    q.this.dmm.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.iBm = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.axx() != null && aVar.axx().cPD != null && q.this.izv != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.axx().cPD;
                    String threadId = q.this.izv.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").cp("tid", threadId).cp("obj_source", str).Z("obj_type", i));
                    }
                }
            }
        };
        this.iBn = new b.a() { // from class: com.baidu.tieba.pb.pb.main.q.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.axx() != null && aVar.axx().cPD != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.axx().cPD;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(q.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(q.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.ciU() != null) {
            this.pageFromType = pbFragment.ciU().clG();
        }
    }

    private void a(r rVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (rVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(rVar.cRh, R.color.cp_bg_line_c);
                rVar.iBs.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                rVar.Oi.onChangeSkinType();
                if (rVar.iBB != null) {
                    rVar.iBB.onChangeSkinType();
                }
                if (rVar.iBC != null) {
                    rVar.iBC.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(rVar.iBx, (int) R.color.cp_cont_j);
                rVar.iBD.oT(skinType);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public r b(ViewGroup viewGroup) {
        r rVar = new r(this.iyA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.izw, this.izD);
        a(rVar);
        rVar.iBy.yA(this.pageFromType);
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
            postData2.aAO();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iyA.getUniqueId(), this.izv, postData2, postData2.locate, 1);
            b(rVar, postData2, view, i);
        }
        if (!this.iBi && this.iBj && rVar != null && rVar.iBs.aRV() && (listView = this.iyA.getListView()) != null) {
            this.iBi = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x053c  */
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
        if (this.izv != null) {
            if (postData.cIt() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.iBs.setOnClickListener(this.ahD);
                    rVar.iBs.setTextViewOnClickListener(this.ahD);
                } else {
                    rVar.iBs.setOnClickListener(null);
                    rVar.iBs.setTextViewOnClickListener(null);
                }
                rVar.iAu.setOnClickListener(this.ahD);
            } else {
                rVar.iAu.setOnClickListener(null);
            }
            if (postData.cIt() == 1) {
                rVar.a(this.izv, this.iyA.ciJ(), postData.kcu);
                a(rVar.iBs, view, this.iBk);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.azE() != null) {
                    j = postData.azE().getUserIdLong();
                    str = postData.azE().getUserName();
                    str2 = postData.azE().getName_show();
                }
                if (this.izv != null && this.izv.chK() != null) {
                    rVar.iBy.a(postData.cIB(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.izv.chK().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.iyA.cjP().cnO()) {
                    rVar.iBs.setVisibility(8);
                }
                if (this.izv != null && this.izv.chK() != null && this.izv.chK().azQ() != null) {
                    bv azQ = this.izv.chK().azQ();
                    String aBT = azQ.aBT();
                    if (!StringUtils.isNull(azQ.aBU())) {
                        if (!StringUtils.isNull(aBT)) {
                            rVar.iBu.setVisibility(0);
                            rVar.iBu.startLoad(aBT, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.iBu.setVisibility(8);
                }
                if (rVar.iBv != null) {
                    rVar.iBv.setVisibility(8);
                }
                if (this.izv != null && this.izv.chK() != null && this.izv.chK().aAE() && rVar.iBB != null) {
                    rVar.iBB.setPadding(rVar.iBB.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), rVar.iBB.getPaddingRight(), rVar.iBB.getPaddingBottom());
                }
            }
            rVar.iBs.getLayoutStrategy().mQ(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cIt()));
            if (postData.cIx() > 0 && postData.cIq() != null && postData.cIq().size() > 0) {
                if (this.iAp == null) {
                    this.iAp = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.iAp.setIsFromCDN(this.mIsFromCDN);
                    this.iAp.T(this.izF);
                    if (this.izv != null) {
                        this.iAp.P(this.izv.chW(), TextUtils.equals(this.izv.chK().azE().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.iAp.setThreadData(this.izv.chK());
                    }
                }
                this.iAp.FS(postData.getId());
            }
            rVar.iBs.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.izw) {
                rVar.iBs.getLayoutStrategy().mT(R.drawable.transparent_bg);
            } else {
                rVar.iBs.getLayoutStrategy().mT(R.drawable.icon_click);
            }
            rVar.iBs.setIsFromCDN(this.mIsFromCDN);
            if (this.izv != null && this.izv.chK() != null && this.izv.chK().isLinkThread()) {
                a(rVar, this.izv.chK().aBf());
            }
            boolean z7 = false;
            if (this.izv != null && this.izv.chK() != null) {
                z7 = this.izv.chK().isShareThread && postData.cIE() != null;
            }
            if (z7) {
                rVar.iBs.getLayoutStrategy().mZ(yz(R.dimen.tbds14));
                a(rVar, postData);
            } else {
                rVar.iBs.getLayoutStrategy().mZ(yz(R.dimen.tbds24));
            }
            TbRichText cIv = postData.cIv();
            if (this.izv != null && this.izv.cih()) {
                cIv = null;
            }
            if (this.izv != null && 3 == this.izv.cin()) {
                if (this.iBi || !this.iBj) {
                    rVar.iBs.setText(cIv, false, this.iAo, true, false);
                } else {
                    rVar.iBs.setText(cIv, true, this.iAo, true, false);
                }
            } else if (this.iBi || !this.iBj) {
                rVar.iBs.setText(cIv, false, this.iAo, false, true);
            } else {
                rVar.iBs.setText(cIv, true, this.iAo, false, true);
            }
            a(rVar, postData, cIv);
            boolean z8 = !StringUtils.isNull(postData.azE().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.izv != null && this.izv.chW() != 0) {
                if (this.izv.chW() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.azE() != null) {
                    String userId = postData.azE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.izv != null && this.izv.chK() != null && this.izv.chK().azE() != null && postData.azE() != null) {
                String userId2 = this.izv.chK().azE().getUserId();
                String userId3 = postData.azE().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.azE() == null && UtilHelper.isCurrentAccount(postData.azE().getUserId())) {
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
                    if (postData.cIt() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.azE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.azE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.azE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.azE().getPortrait());
                        }
                        if (this.izv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.izv.chW()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.azE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.azE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azE().getName_show());
                        }
                        if (this.izv != null && this.izv.chK() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.izv.chK().getId());
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
                        if (this.izv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.izv.chW()));
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
            if (postData.azE() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.cIt() == 1) {
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
            rVar.iBs.setTag(sparseArray);
            rVar.iAu.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            rVar.iBs.setIsHost(true);
            if (this.iBh) {
                rVar.cRh.setVisibility(0);
            } else {
                rVar.cRh.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.izw) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.iBs.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.iBs.setLayoutParams(layoutParams);
                rVar.iBs.vJ(null);
                this.iBk = false;
                a(rVar, postData, view, i);
            } else {
                this.iBk = true;
                rVar.iBs.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.q.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void aSb() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.iBs.getLayoutParams();
                        layoutParams2.topMargin = q.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = q.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        rVar.iBs.setLayoutParams(layoutParams2);
                        q.this.a(rVar, postData, view, i);
                    }
                });
            }
            if (this.izv != null && this.izv.chK() != null && this.izv.chK().aAE() && this.izv.chK().azV() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.izv.getForum().getName())) {
                rVar.u(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cIv() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cIv().aRf())) {
                rVar.u(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                rVar.u(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cIv() != null) {
                if (postData.cIv().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.Oi.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    rVar.Oi.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.Oi.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    rVar.Oi.setLayoutParams(layoutParams3);
                }
            }
            if (this.izv.chK() != null && this.izv.chK().aAq() != null && this.izv.chK().azV() == null) {
                rVar.Oi.setVisibility(0);
                rVar.Oi.setData(this.izv.chK().aAq());
                if (this.izv.getForum() != null) {
                    rVar.Oi.setForumId(String.valueOf(this.izv.getForum().getId()));
                }
                if (this.izv.getThreadId() != null) {
                    rVar.Oi.setThreadId(this.izv.getThreadId());
                }
                AppletsCellView appletsCellView = rVar.Oi;
                AppletsCellView appletsCellView2 = rVar.Oi;
                appletsCellView.setFrom("PB_card");
            } else {
                rVar.Oi.setVisibility(8);
            }
            if (this.izv != null && this.izv.chK() != null && (this.izv.chK().azT() != 0 || this.izv.chK().aAE())) {
                rVar.b(this.izv, this.izv.chK().azA() == 1, this.izv.chK().azz() == 1);
            }
            if (this.izv != null && this.izv.iwh != null) {
                if (rVar.iBx != null) {
                    if (TextUtils.isEmpty(this.izv.iwh.cit())) {
                        rVar.iBx.setVisibility(8);
                    } else {
                        rVar.iBx.setVisibility(0);
                        rVar.iBx.setText(this.izv.iwh.cit());
                    }
                }
                if (rVar.iBw != null && rVar.iBD.getRootView() == null) {
                    rVar.iBw.addView(rVar.iBD.D(this.izv));
                    String fromPageKey = UtilHelper.getFromPageKey(this.iyA.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 1).aDT();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 3).aDT();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 2).aDT();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 4).aDT();
                        }
                    }
                }
            }
        }
    }

    private void a(r rVar, PostData postData) {
        View view;
        if (rVar != null && postData != null) {
            rVar.iBz.setVisibility(0);
            if (rVar.iBA == null) {
                rVar.iBA = j(postData);
            }
            if (rVar.iBz.getChildCount() <= 0 && (view = rVar.iBA.getView()) != null) {
                rVar.iBz.addView(view);
            }
            rVar.iBA.a(this.iBm);
            rVar.iBA.a(this.iBn);
            rVar.iBA.f(postData.cIE());
            rVar.iBA.onChangeSkinType(this.iyA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cIE() != null && postData.cIE().ayp()) {
            BaijiahaoData baijiahaoData = postData.cIE().oriUgcInfo;
            if (postData.cIE().cKv) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.iyA.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.iyA.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iyA.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iyA.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iyA.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.iyA.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cIE().showType == 0 || postData.cIE().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iyA.getPageContext(), this.pageFromType);
            } else if (postData.cIE().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iyA.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.iyA.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int yz(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.ayh() == com.baidu.tbadk.core.data.ag.cLb) {
            if (!agVar.ayi()) {
                rVar.iBs.getLayoutStrategy().mZ(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            rVar.iBy.a(agVar);
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cpy() == null) {
            rVar.iAM.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cpy(), rVar.iAM, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.iBs.setTextViewOnTouchListener(this.iBl);
        rVar.iBs.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.izD);
            tbRichTextView.getLayoutStrategy().mR(min);
            tbRichTextView.getLayoutStrategy().mS((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.iAu.setOnTouchListener(this.dmm);
        rVar.iAu.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.iAW.ckE().iyV;
        rVar.iBs.setOnLongClickListener(this.mOnLongClickListener);
        rVar.iBs.setOnTouchListener(this.iBl);
        rVar.iBs.setCommonTextViewOnClickListener(this.ahD);
        rVar.iBs.setOnImageClickListener(this.dIi);
        rVar.iBs.setOnImageTouchListener(this.iBl);
        rVar.iBs.setOnEmotionClickListener(aVar.iNF);
        rVar.iAM.setOnClickListener(this.ahD);
        rVar.iBB.setAfterItemClickListener(this.ahD);
        rVar.iBC.setAfterItemClickListener(this.ahD);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.izv = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.izD = i;
    }

    public void ph(boolean z) {
        this.izw = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.izF = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.iAo = cVar;
    }

    public void pu(boolean z) {
        this.iBh = z;
    }

    public void release() {
        if (this.zL != 0) {
            ((r) this.zL).iBy.destroy();
            ((r) this.zL).iBC.destroy();
        }
    }

    public void resume() {
        if (this.zL != 0) {
            ((r) this.zL).iBy.resume();
        }
    }

    public void pause() {
        if (this.zL != 0) {
            ((r) this.zL).iBy.pause();
        }
    }

    public r cjE() {
        return (r) this.zL;
    }
}
