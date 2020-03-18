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
    private View.OnClickListener akE;
    private TbRichTextView.i dNb;
    private com.baidu.tieba.pb.a.c drk;
    protected int iGD;
    private View.OnClickListener iGF;
    protected com.baidu.tieba.pb.data.e iGv;
    protected boolean iGw;
    private TbRichTextView.c iHl;
    private com.baidu.tieba.pb.pb.sub.b iHm;
    private boolean iIe;
    private boolean iIf;
    private final boolean iIg;
    private boolean iIh;
    private com.baidu.tieba.pb.a.c iIi;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> iIj;
    private b.a iIk;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iGD = 0;
        this.iGw = true;
        this.iIe = true;
        this.iGv = null;
        this.iHm = null;
        this.iGF = null;
        this.akE = null;
        this.dNb = null;
        this.drk = null;
        this.mOnLongClickListener = null;
        this.iHl = null;
        this.iIf = false;
        this.iIg = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.iIh = false;
        this.pageFromType = 0;
        this.iIi = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.drk != null) {
                    p.this.drk.Q(view);
                    p.this.drk.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.iIj = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.aAj() != null && aVar.aAj().cUe != null && p.this.iGv != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAj().cUe;
                    String threadId = p.this.iGv.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").cx("tid", threadId).cx("obj_source", str).X("obj_type", i));
                    }
                }
            }
        };
        this.iIk = new b.a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.aAj() != null && aVar.aAj().cUe != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAj().cUe;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.clX() != null) {
            this.pageFromType = pbFragment.clX().coD();
        }
    }

    private void a(q qVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (qVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(qVar.cVI, R.color.cp_bg_line_c);
                qVar.iIp.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                qVar.OP.onChangeSkinType();
                if (qVar.iIy != null) {
                    qVar.iIy.onChangeSkinType();
                }
                if (qVar.iIz != null) {
                    qVar.iIz.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(qVar.iIu, (int) R.color.cp_cont_j);
                qVar.iIA.pm(skinType);
            }
            qVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public q b(ViewGroup viewGroup) {
        q qVar = new q(this.iFL.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.iGw, this.iGD);
        a(qVar);
        qVar.iIv.yU(this.pageFromType);
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
            postData2.aDA();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iFL.getUniqueId(), this.iGv, postData2, postData2.locate, 1);
            b(qVar, postData2, view, i);
        }
        if (!this.iIf && this.iIg && qVar != null && qVar.iIp.aUN() && (listView = this.iFL.getListView()) != null) {
            this.iIf = true;
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
        if (this.iGv != null) {
            if (postData.cLv() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    qVar.iIp.setOnClickListener(this.akE);
                    qVar.iIp.setTextViewOnClickListener(this.akE);
                } else {
                    qVar.iIp.setOnClickListener(null);
                    qVar.iIp.setTextViewOnClickListener(null);
                }
                qVar.iHr.setOnClickListener(this.akE);
            } else {
                qVar.iHr.setOnClickListener(null);
            }
            if (postData.cLv() == 1) {
                qVar.a(this.iGv, this.iFL.clN(), postData.kiU);
                a(qVar.iIp, view, this.iIh);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCr() != null) {
                    j = postData.aCr().getUserIdLong();
                    str = postData.aCr().getUserName();
                    str2 = postData.aCr().getName_show();
                }
                if (this.iGv != null && this.iGv.ckP() != null) {
                    qVar.iIv.a(postData.cLD(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iGv.ckP().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.iFL.cmP().cqL()) {
                    qVar.iIp.setVisibility(8);
                }
                if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckP().aCD() != null) {
                    bv aCD = this.iGv.ckP().aCD();
                    String aED = aCD.aED();
                    if (!StringUtils.isNull(aCD.aEE())) {
                        if (!StringUtils.isNull(aED)) {
                            qVar.iIr.setVisibility(0);
                            qVar.iIr.startLoad(aED, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    qVar.iIr.setVisibility(8);
                }
                if (qVar.iIs != null) {
                    qVar.iIs.setVisibility(8);
                }
                if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckP().aBe() && qVar.iIy != null) {
                    qVar.iIy.setPadding(qVar.iIy.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), qVar.iIy.getPaddingRight(), qVar.iIy.getPaddingBottom());
                }
            }
            qVar.iIp.getLayoutStrategy().nj(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLv()));
            if (postData.cLz() > 0 && postData.cLs() != null && postData.cLs().size() > 0) {
                if (this.iHm == null) {
                    this.iHm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.iHm.setIsFromCDN(this.mIsFromCDN);
                    this.iHm.S(this.iGF);
                    if (this.iGv != null) {
                        this.iHm.O(this.iGv.clb(), TextUtils.equals(this.iGv.ckP().aCr().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.iHm.setThreadData(this.iGv.ckP());
                    }
                }
                this.iHm.Gr(postData.getId());
            }
            qVar.iIp.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.iGw) {
                qVar.iIp.getLayoutStrategy().nm(R.drawable.transparent_bg);
            } else {
                qVar.iIp.getLayoutStrategy().nm(R.drawable.icon_click);
            }
            qVar.iIp.setIsFromCDN(this.mIsFromCDN);
            if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckP().isLinkThread()) {
                a(qVar, this.iGv.ckP().aDR());
            }
            boolean z7 = false;
            if (this.iGv != null && this.iGv.ckP() != null) {
                z7 = this.iGv.ckP().isShareThread && postData.cLG() != null;
            }
            if (z7) {
                qVar.iIp.getLayoutStrategy().ns(yT(R.dimen.tbds14));
                a(qVar, postData);
            } else {
                qVar.iIp.getLayoutStrategy().ns(yT(R.dimen.tbds24));
            }
            TbRichText cLx = postData.cLx();
            if (this.iGv != null && this.iGv.aHP()) {
                cLx = null;
            }
            if (this.iGv.ckP() != null) {
                qVar.iIp.setIsUseGridImage(this.iGv.ckP().aEk());
                qVar.iIp.setmIsGridImageSupportLongPress(true);
            }
            if (this.iGv != null && 3 == this.iGv.clq()) {
                if (this.iIf || !this.iIg) {
                    qVar.iIp.setText(cLx, false, this.iHl, true, false);
                } else {
                    qVar.iIp.setText(cLx, true, this.iHl, true, false);
                }
            } else if (this.iIf || !this.iIg) {
                qVar.iIp.setText(cLx, false, this.iHl, false, true);
            } else {
                qVar.iIp.setText(cLx, true, this.iHl, false, true);
            }
            a(qVar, postData, cLx);
            boolean z8 = !StringUtils.isNull(postData.aCr().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.iGv != null && this.iGv.clb() != 0) {
                if (this.iGv.clb() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aCr() != null) {
                    String userId = postData.aCr().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckP().aCr() != null && postData.aCr() != null) {
                String userId2 = this.iGv.ckP().aCr().getUserId();
                String userId3 = postData.aCr().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aCr() == null && UtilHelper.isCurrentAccount(postData.aCr().getUserId())) {
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
                    if (postData.cLv() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aCr() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCr().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCr().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCr().getPortrait());
                        }
                        if (this.iGv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iGv.clb()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aCr() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCr().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCr().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCr().getName_show());
                        }
                        if (this.iGv != null && this.iGv.ckP() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iGv.ckP().getId());
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
                        if (this.iGv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iGv.clb()));
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
            if (postData.aCr() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.cLv() == 1) {
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
            qVar.iIp.setTag(sparseArray);
            qVar.iHr.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            qVar.iIp.setIsHost(true);
            if (this.iIe) {
                qVar.cVI.setVisibility(0);
            } else {
                qVar.cVI.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iGw) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.iIp.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                qVar.iIp.setLayoutParams(layoutParams);
                qVar.iIp.wi(null);
                this.iIh = false;
                a(qVar, postData, view, i);
            } else {
                this.iIh = true;
                qVar.iIp.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void aUT() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.iIp.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        qVar.iIp.setLayoutParams(layoutParams2);
                        p.this.a(qVar, postData, view, i);
                    }
                });
            }
            if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckP().aBe() && this.iGv.ckP().aCI() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.iGv.getForum().getName())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cLx() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cLx().aTX())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cLx() != null) {
                if (postData.cLx().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.OP.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    qVar.OP.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) qVar.OP.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    qVar.OP.setLayoutParams(layoutParams3);
                }
            }
            if (this.iGv.ckP() != null && this.iGv.ckP().aDd() != null && this.iGv.ckP().aCI() == null) {
                qVar.OP.setVisibility(0);
                qVar.OP.setData(this.iGv.ckP().aDd());
                if (this.iGv.getForum() != null) {
                    qVar.OP.setForumId(String.valueOf(this.iGv.getForum().getId()));
                }
                if (this.iGv.getThreadId() != null) {
                    qVar.OP.setThreadId(this.iGv.getThreadId());
                }
                AppletsCellView appletsCellView = qVar.OP;
                AppletsCellView appletsCellView2 = qVar.OP;
                appletsCellView.setFrom("PB_card");
            } else {
                qVar.OP.setVisibility(8);
            }
            if (this.iGv != null && this.iGv.ckP() != null && (this.iGv.ckP().aCG() != 0 || this.iGv.ckP().aBe())) {
                qVar.b(this.iGv, this.iGv.ckP().aCn() == 1, this.iGv.ckP().aCm() == 1);
            }
            if (this.iGv != null && this.iGv.iDr != null) {
                if (qVar.iIu != null) {
                    if (TextUtils.isEmpty(this.iGv.iDr.clx())) {
                        qVar.iIu.setVisibility(8);
                    } else {
                        qVar.iIu.setVisibility(0);
                        qVar.iIu.setText(this.iGv.iDr.clx());
                    }
                }
                if (qVar.iIt != null && qVar.iIA.getRootView() == null) {
                    qVar.iIt.addView(qVar.iIA.E(this.iGv));
                    String fromPageKey = UtilHelper.getFromPageKey(this.iFL.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 1).aGD();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 3).aGD();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 2).aGD();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").X("obj_source", 4).aGD();
                        }
                    }
                }
            }
        }
    }

    private void a(q qVar, PostData postData) {
        View view;
        if (qVar != null && postData != null) {
            qVar.iIw.setVisibility(0);
            if (qVar.iIx == null) {
                qVar.iIx = j(postData);
            }
            if (qVar.iIw.getChildCount() <= 0 && (view = qVar.iIx.getView()) != null) {
                qVar.iIw.addView(view);
            }
            qVar.iIx.a(this.iIj);
            qVar.iIx.a(this.iIk);
            qVar.iIx.g(postData.cLG());
            qVar.iIx.onChangeSkinType(this.iFL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cLG() != null && postData.cLG().aBb()) {
            BaijiahaoData baijiahaoData = postData.cLG().oriUgcInfo;
            if (postData.cLG().cOY) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.iFL.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.iFL.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iFL.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iFL.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iFL.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.iFL.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cLG().showType == 0 || postData.cLG().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iFL.getPageContext(), this.pageFromType);
            } else if (postData.cLG().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iFL.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.iFL.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int yT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(q qVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.aAT() == com.baidu.tbadk.core.data.ag.cPD) {
            if (!agVar.aAU()) {
                qVar.iIp.getLayoutStrategy().ns(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            qVar.iIv.a(agVar);
        }
    }

    private void a(q qVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.csv() == null) {
            qVar.iHJ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.csv(), qVar.iHJ, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(q qVar) {
        qVar.iIp.setTextViewOnTouchListener(this.iIi);
        qVar.iIp.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.iGD);
            tbRichTextView.getLayoutStrategy().nk(min);
            tbRichTextView.getLayoutStrategy().nl((int) (min * 1.618f));
        }
    }

    private void c(q qVar) {
        qVar.iHr.setOnTouchListener(this.drk);
        qVar.iHr.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.iHT.cnE().iFX;
        qVar.iIp.setOnLongClickListener(this.mOnLongClickListener);
        qVar.iIp.setOnTouchListener(this.iIi);
        qVar.iIp.setCommonTextViewOnClickListener(this.akE);
        qVar.iIp.setOnImageClickListener(this.dNb);
        qVar.iIp.setOnImageTouchListener(this.iIi);
        qVar.iIp.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        qVar.iIp.setOnEmotionClickListener(aVar.iUt);
        qVar.iHJ.setOnClickListener(this.akE);
        qVar.iIy.setAfterItemClickListener(this.akE);
        qVar.iIz.setAfterItemClickListener(this.akE);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iGv = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.iGD = i;
    }

    public void pC(boolean z) {
        this.iGw = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iGF = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dNb = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.drk = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.iHl = cVar;
    }

    public void pP(boolean z) {
        this.iIe = z;
    }

    public void release() {
        if (this.Ai != 0) {
            ((q) this.Ai).iIv.destroy();
            ((q) this.Ai).iIz.destroy();
        }
    }

    public void resume() {
        if (this.Ai != 0) {
            ((q) this.Ai).iIv.resume();
        }
    }

    public void pause() {
        if (this.Ai != 0) {
            ((q) this.Ai).iIv.pause();
        }
    }

    public q cmE() {
        return (q) this.Ai;
    }
}
