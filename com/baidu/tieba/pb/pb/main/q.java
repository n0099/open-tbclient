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
/* loaded from: classes7.dex */
public class q extends m<PostData, r> {
    private View.OnClickListener ain;
    private TbRichTextView.i dIr;
    private com.baidu.tieba.pb.a.c dmA;
    protected com.baidu.tieba.pb.data.f iCZ;
    private TbRichTextView.c iDS;
    private com.baidu.tieba.pb.pb.sub.b iDT;
    protected boolean iDa;
    protected int iDh;
    private View.OnClickListener iDj;
    private boolean iEL;
    private boolean iEM;
    private final boolean iEN;
    private boolean iEO;
    private com.baidu.tieba.pb.a.c iEP;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> iEQ;
    private b.a iER;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iDh = 0;
        this.iDa = true;
        this.iEL = true;
        this.iCZ = null;
        this.iDT = null;
        this.iDj = null;
        this.ain = null;
        this.dIr = null;
        this.dmA = null;
        this.mOnLongClickListener = null;
        this.iDS = null;
        this.iEM = false;
        this.iEN = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.iEO = false;
        this.pageFromType = 0;
        this.iEP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.dmA != null) {
                    q.this.dmA.Q(view);
                    q.this.dmA.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.iEQ = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.axQ() != null && aVar.axQ().cPN != null && q.this.iCZ != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.axQ().cPN;
                    String threadId = q.this.iCZ.getThreadId();
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
        this.iER = new b.a() { // from class: com.baidu.tieba.pb.pb.main.q.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.axQ() != null && aVar.axQ().cPN != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.axQ().cPN;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(q.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(q.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.ckc() != null) {
            this.pageFromType = pbFragment.ckc().cmO();
        }
    }

    private void a(r rVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (rVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(rVar.cRr, R.color.cp_bg_line_c);
                rVar.iEW.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                rVar.Om.onChangeSkinType();
                if (rVar.iFf != null) {
                    rVar.iFf.onChangeSkinType();
                }
                if (rVar.iFg != null) {
                    rVar.iFg.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(rVar.iFb, (int) R.color.cp_cont_j);
                rVar.iFh.oU(skinType);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public r b(ViewGroup viewGroup) {
        r rVar = new r(this.iCe.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.iDa, this.iDh);
        a(rVar);
        rVar.iFc.yF(this.pageFromType);
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
            postData2.aBh();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.iCe.getUniqueId(), this.iCZ, postData2, postData2.locate, 1);
            b(rVar, postData2, view, i);
        }
        if (!this.iEM && this.iEN && rVar != null && rVar.iEW.aSp() && (listView = this.iCe.getListView()) != null) {
            this.iEM = true;
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
        if (this.iCZ != null) {
            if (postData.cJx() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.iEW.setOnClickListener(this.ain);
                    rVar.iEW.setTextViewOnClickListener(this.ain);
                } else {
                    rVar.iEW.setOnClickListener(null);
                    rVar.iEW.setTextViewOnClickListener(null);
                }
                rVar.iDY.setOnClickListener(this.ain);
            } else {
                rVar.iDY.setOnClickListener(null);
            }
            if (postData.cJx() == 1) {
                rVar.a(this.iCZ, this.iCe.cjR(), postData.kfX);
                a(rVar.iEW, view, this.iEO);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.azX() != null) {
                    j = postData.azX().getUserIdLong();
                    str = postData.azX().getUserName();
                    str2 = postData.azX().getName_show();
                }
                if (this.iCZ != null && this.iCZ.ciS() != null) {
                    rVar.iFc.a(postData.cJF(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iCZ.ciS().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.iCe.ckX().coV()) {
                    rVar.iEW.setVisibility(8);
                }
                if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciS().aAj() != null) {
                    bv aAj = this.iCZ.ciS().aAj();
                    String aCm = aAj.aCm();
                    if (!StringUtils.isNull(aAj.aCn())) {
                        if (!StringUtils.isNull(aCm)) {
                            rVar.iEY.setVisibility(0);
                            rVar.iEY.startLoad(aCm, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.iEY.setVisibility(8);
                }
                if (rVar.iEZ != null) {
                    rVar.iEZ.setVisibility(8);
                }
                if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciS().aAX() && rVar.iFf != null) {
                    rVar.iFf.setPadding(rVar.iFf.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), rVar.iFf.getPaddingRight(), rVar.iFf.getPaddingBottom());
                }
            }
            rVar.iEW.getLayoutStrategy().mQ(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cJx()));
            if (postData.cJB() > 0 && postData.cJu() != null && postData.cJu().size() > 0) {
                if (this.iDT == null) {
                    this.iDT = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.iDT.setIsFromCDN(this.mIsFromCDN);
                    this.iDT.S(this.iDj);
                    if (this.iCZ != null) {
                        this.iDT.P(this.iCZ.cje(), TextUtils.equals(this.iCZ.ciS().azX().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.iDT.setThreadData(this.iCZ.ciS());
                    }
                }
                this.iDT.Gc(postData.getId());
            }
            rVar.iEW.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.iDa) {
                rVar.iEW.getLayoutStrategy().mT(R.drawable.transparent_bg);
            } else {
                rVar.iEW.getLayoutStrategy().mT(R.drawable.icon_click);
            }
            rVar.iEW.setIsFromCDN(this.mIsFromCDN);
            if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciS().isLinkThread()) {
                a(rVar, this.iCZ.ciS().aBy());
            }
            boolean z7 = false;
            if (this.iCZ != null && this.iCZ.ciS() != null) {
                z7 = this.iCZ.ciS().isShareThread && postData.cJI() != null;
            }
            if (z7) {
                rVar.iEW.getLayoutStrategy().mZ(yE(R.dimen.tbds14));
                a(rVar, postData);
            } else {
                rVar.iEW.getLayoutStrategy().mZ(yE(R.dimen.tbds24));
            }
            TbRichText cJz = postData.cJz();
            if (this.iCZ != null && this.iCZ.cjp()) {
                cJz = null;
            }
            if (this.iCZ != null && 3 == this.iCZ.cjv()) {
                if (this.iEM || !this.iEN) {
                    rVar.iEW.setText(cJz, false, this.iDS, true, false);
                } else {
                    rVar.iEW.setText(cJz, true, this.iDS, true, false);
                }
            } else if (this.iEM || !this.iEN) {
                rVar.iEW.setText(cJz, false, this.iDS, false, true);
            } else {
                rVar.iEW.setText(cJz, true, this.iDS, false, true);
            }
            a(rVar, postData, cJz);
            boolean z8 = !StringUtils.isNull(postData.azX().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.iCZ != null && this.iCZ.cje() != 0) {
                if (this.iCZ.cje() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.azX() != null) {
                    String userId = postData.azX().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciS().azX() != null && postData.azX() != null) {
                String userId2 = this.iCZ.ciS().azX().getUserId();
                String userId3 = postData.azX().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.azX() == null && UtilHelper.isCurrentAccount(postData.azX().getUserId())) {
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
                    if (postData.cJx() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.azX() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.azX().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.azX().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.azX().getPortrait());
                        }
                        if (this.iCZ != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iCZ.cje()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.azX() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azX().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.azX().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azX().getName_show());
                        }
                        if (this.iCZ != null && this.iCZ.ciS() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iCZ.ciS().getId());
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
                        if (this.iCZ != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iCZ.cje()));
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
            if (postData.azX() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.cJx() == 1) {
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
            rVar.iEW.setTag(sparseArray);
            rVar.iDY.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            rVar.iEW.setIsHost(true);
            if (this.iEL) {
                rVar.cRr.setVisibility(0);
            } else {
                rVar.cRr.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iDa) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.iEW.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.iEW.setLayoutParams(layoutParams);
                rVar.iEW.vN(null);
                this.iEO = false;
                a(rVar, postData, view, i);
            } else {
                this.iEO = true;
                rVar.iEW.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.q.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void aSv() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.iEW.getLayoutParams();
                        layoutParams2.topMargin = q.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = q.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        rVar.iEW.setLayoutParams(layoutParams2);
                        q.this.a(rVar, postData, view, i);
                    }
                });
            }
            if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciS().aAX() && this.iCZ.ciS().aAo() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.iCZ.getForum().getName())) {
                rVar.v(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cJz() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cJz().aRz())) {
                rVar.v(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                rVar.v(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cJz() != null) {
                if (postData.cJz().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.Om.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    rVar.Om.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.Om.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    rVar.Om.setLayoutParams(layoutParams3);
                }
            }
            if (this.iCZ.ciS() != null && this.iCZ.ciS().aAJ() != null && this.iCZ.ciS().aAo() == null) {
                rVar.Om.setVisibility(0);
                rVar.Om.setData(this.iCZ.ciS().aAJ());
                if (this.iCZ.getForum() != null) {
                    rVar.Om.setForumId(String.valueOf(this.iCZ.getForum().getId()));
                }
                if (this.iCZ.getThreadId() != null) {
                    rVar.Om.setThreadId(this.iCZ.getThreadId());
                }
                AppletsCellView appletsCellView = rVar.Om;
                AppletsCellView appletsCellView2 = rVar.Om;
                appletsCellView.setFrom("PB_card");
            } else {
                rVar.Om.setVisibility(8);
            }
            if (this.iCZ != null && this.iCZ.ciS() != null && (this.iCZ.ciS().aAm() != 0 || this.iCZ.ciS().aAX())) {
                rVar.b(this.iCZ, this.iCZ.ciS().azT() == 1, this.iCZ.ciS().azS() == 1);
            }
            if (this.iCZ != null && this.iCZ.izL != null) {
                if (rVar.iFb != null) {
                    if (TextUtils.isEmpty(this.iCZ.izL.cjB())) {
                        rVar.iFb.setVisibility(8);
                    } else {
                        rVar.iFb.setVisibility(0);
                        rVar.iFb.setText(this.iCZ.izL.cjB());
                    }
                }
                if (rVar.iFa != null && rVar.iFh.getRootView() == null) {
                    rVar.iFa.addView(rVar.iFh.D(this.iCZ));
                    String fromPageKey = UtilHelper.getFromPageKey(this.iCe.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 1).aEm();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 3).aEm();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 2).aEm();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").Z("obj_source", 4).aEm();
                        }
                    }
                }
            }
        }
    }

    private void a(r rVar, PostData postData) {
        View view;
        if (rVar != null && postData != null) {
            rVar.iFd.setVisibility(0);
            if (rVar.iFe == null) {
                rVar.iFe = j(postData);
            }
            if (rVar.iFd.getChildCount() <= 0 && (view = rVar.iFe.getView()) != null) {
                rVar.iFd.addView(view);
            }
            rVar.iFe.a(this.iEQ);
            rVar.iFe.a(this.iER);
            rVar.iFe.f(postData.cJI());
            rVar.iFe.onChangeSkinType(this.iCe.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cJI() != null && postData.cJI().ayI()) {
            BaijiahaoData baijiahaoData = postData.cJI().oriUgcInfo;
            if (postData.cJI().cKG) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.iCe.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.iCe.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iCe.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iCe.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iCe.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.iCe.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cJI().showType == 0 || postData.cJI().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iCe.getPageContext(), this.pageFromType);
            } else if (postData.cJI().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iCe.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.iCe.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int yE(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.ayA() == com.baidu.tbadk.core.data.ag.cLl) {
            if (!agVar.ayB()) {
                rVar.iEW.getLayoutStrategy().mZ(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            rVar.iFc.a(agVar);
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cqF() == null) {
            rVar.iEq.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cqF(), rVar.iEq, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.iEW.setTextViewOnTouchListener(this.iEP);
        rVar.iEW.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.iDh);
            tbRichTextView.getLayoutStrategy().mR(min);
            tbRichTextView.getLayoutStrategy().mS((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.iDY.setOnTouchListener(this.dmA);
        rVar.iDY.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.iEA.clM().iCz;
        rVar.iEW.setOnLongClickListener(this.mOnLongClickListener);
        rVar.iEW.setOnTouchListener(this.iEP);
        rVar.iEW.setCommonTextViewOnClickListener(this.ain);
        rVar.iEW.setOnImageClickListener(this.dIr);
        rVar.iEW.setOnImageTouchListener(this.iEP);
        rVar.iEW.setOnEmotionClickListener(aVar.iRj);
        rVar.iEq.setOnClickListener(this.ain);
        rVar.iFf.setAfterItemClickListener(this.ain);
        rVar.iFg.setAfterItemClickListener(this.ain);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.iCZ = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.iDh = i;
    }

    public void pt(boolean z) {
        this.iDa = z;
    }

    public void O(View.OnClickListener onClickListener) {
        this.iDj = onClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIr = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.iDS = cVar;
    }

    public void pG(boolean z) {
        this.iEL = z;
    }

    public void release() {
        if (this.zP != 0) {
            ((r) this.zP).iFc.destroy();
            ((r) this.zP).iFg.destroy();
        }
    }

    public void resume() {
        if (this.zP != 0) {
            ((r) this.zP).iFc.resume();
        }
    }

    public void pause() {
        if (this.zP != 0) {
            ((r) this.zP).iFc.pause();
        }
    }

    public r ckM() {
        return (r) this.zP;
    }
}
