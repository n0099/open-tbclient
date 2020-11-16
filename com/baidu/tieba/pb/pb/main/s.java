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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class s extends o<PostData, t> {
    private View.OnClickListener aYm;
    private TbRichTextView.i fFy;
    private com.baidu.tieba.pb.a.c fgS;
    protected com.baidu.tieba.pb.data.f lqK;
    protected boolean lqL;
    protected int lqS;
    private View.OnClickListener lqU;
    private TbRichTextView.c lrB;
    private com.baidu.tieba.pb.pb.sub.b lrC;
    private boolean lsN;
    private boolean lsO;
    private final boolean lsP;
    private boolean lsQ;
    private com.baidu.tieba.pb.a.c lsR;
    private com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> lsS;
    private b.a lsT;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lqS = 0;
        this.lqL = true;
        this.lsN = true;
        this.lqK = null;
        this.lrC = null;
        this.lqU = null;
        this.aYm = null;
        this.fFy = null;
        this.fgS = null;
        this.mOnLongClickListener = null;
        this.lrB = null;
        this.lsO = false;
        this.lsP = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lsQ = false;
        this.pageFromType = 0;
        this.lsR = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.fgS != null) {
                    s.this.fgS.ad(view);
                    s.this.fgS.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lsS = new com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.bjd() != null && aVar.bjd().eEF != null && s.this.lqK != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bjd().eEF;
                    String threadId = s.this.lqK.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12602").dR("tid", threadId).dR("obj_source", str).ak("obj_type", i));
                    }
                }
            }
        };
        this.lsT = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.bjd() != null && aVar.bjd().eEF != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bjd().eEF;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.diV() != null) {
            this.pageFromType = pbFragment.diV().dlE();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.eGI, R.color.CAM_X0204);
                tVar.lsY.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                tVar.alE.onChangeSkinType();
                if (tVar.lti != null) {
                    tVar.lti.onChangeSkinType();
                }
                if (tVar.ltj != null) {
                    tVar.ltj.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.ltd, R.color.CAM_X0107);
                tVar.ltk.vc(skinType);
                if (tVar.aiJ != null) {
                    tVar.aiJ.onChangeSkinType(skinType);
                }
            }
            tVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public t c(ViewGroup viewGroup) {
        t tVar = new t(this.lpX.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lqL, this.lqS);
        a(tVar);
        tVar.ltf.Gm(this.pageFromType);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, t tVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) tVar);
        a(tVar);
        c(tVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.bmQ();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lpX.getUniqueId(), this.lqK, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.lsO && this.lsP && tVar != null && tVar.lsY.bFV() && (listView = this.lpX.getListView()) != null) {
            this.lsO = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0557  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(t tVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.lqK != null) {
            if (postData.dJQ() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.lsY.setOnClickListener(this.aYm);
                    tVar.lsY.setTextViewOnClickListener(this.aYm);
                } else {
                    tVar.lsY.setOnClickListener(null);
                    tVar.lsY.setTextViewOnClickListener(null);
                }
                tVar.lrN.setOnClickListener(this.aYm);
            } else {
                tVar.lrN.setOnClickListener(null);
            }
            if (postData.dJQ() == 1) {
                tVar.a(this.lqK, this.lpX.diN(), postData.mYt);
                a(tVar.lsY, view, this.lsQ);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.blC() != null) {
                    j = postData.blC().getUserIdLong();
                    str = postData.blC().getUserName();
                    str2 = postData.blC().getName_show();
                }
                if (this.lqK != null && this.lqK.dhH() != null) {
                    tVar.ltf.a(postData.dJY(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lqK.dhH().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lpX.djM().dnR()) {
                    tVar.lsY.setVisibility(8);
                }
                if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().blN() != null) {
                    cj blN = this.lqK.dhH().blN();
                    String bnZ = blN.bnZ();
                    if (!StringUtils.isNull(blN.boa())) {
                        if (!StringUtils.isNull(bnZ)) {
                            tVar.lta.setVisibility(0);
                            tVar.lta.startLoad(bnZ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.lta.setVisibility(8);
                }
                if (tVar.ltb != null) {
                    tVar.ltb.setVisibility(8);
                }
                if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().bki() && tVar.lti != null) {
                    tVar.lti.setPadding(tVar.lti.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.lti.getPaddingRight(), tVar.lti.getPaddingBottom());
                }
            }
            tVar.lsY.getLayoutStrategy().sK(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dJQ()));
            if (postData.dJU() > 0 && postData.dJN() != null && postData.dJN().size() > 0) {
                if (this.lrC == null) {
                    this.lrC = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lrC.setIsFromCDN(this.mIsFromCDN);
                    this.lrC.W(this.lqU);
                    if (this.lqK != null) {
                        this.lrC.af(this.lqK.dhW(), TextUtils.equals(this.lqK.dhH().blC().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lrC.setThreadData(this.lqK.dhH());
                    }
                }
                this.lrC.PA(postData.getId());
            }
            tVar.lsY.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            if (this.lqL) {
                tVar.lsY.getLayoutStrategy().sN(R.drawable.transparent_bg);
            } else {
                tVar.lsY.getLayoutStrategy().sN(R.drawable.icon_click);
            }
            tVar.lsY.setIsFromCDN(this.mIsFromCDN);
            if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().isLinkThread()) {
                a(tVar, this.lqK.dhH().bni());
            }
            boolean z7 = false;
            if (this.lqK != null && this.lqK.dhH() != null) {
                z7 = this.lqK.dhH().isShareThread && postData.dKb() != null;
            }
            if (z7) {
                if (postData.dKb().item != null) {
                    tVar.lsY.getLayoutStrategy().sT(getDimens(R.dimen.tbds24));
                } else {
                    tVar.lsY.getLayoutStrategy().sT(getDimens(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.lsY.getLayoutStrategy().sT(getDimens(R.dimen.tbds24));
            }
            TbRichText dJS = postData.dJS();
            if (this.lqK != null && this.lqK.dih()) {
                dJS = null;
            }
            if (this.lqK.dhH() != null) {
                tVar.lsY.setIsUseGridImage(this.lqK.dhH().bnz());
                tVar.lsY.setmIsGridImageSupportLongPress(true);
            }
            if (this.lqK != null && 3 == this.lqK.din()) {
                if (this.lsO || !this.lsP) {
                    tVar.lsY.setText(dJS, false, this.lrB, true, false);
                } else {
                    tVar.lsY.setText(dJS, true, this.lrB, true, false);
                }
            } else if (this.lsO || !this.lsP) {
                tVar.lsY.setText(dJS, false, this.lrB, false, true);
            } else {
                tVar.lsY.setText(dJS, true, this.lrB, false, true);
            }
            a(tVar, postData, dJS);
            boolean z8 = !StringUtils.isNull(postData.blC().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.lqK != null && this.lqK.dhW() != 0) {
                if (this.lqK.dhW() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.blC() != null) {
                    String userId = postData.blC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().blC() != null && postData.blC() != null) {
                String userId2 = this.lqK.dhH().blC().getUserId();
                String userId3 = postData.blC().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.blC() == null && UtilHelper.isCurrentAccount(postData.blC().getUserId())) {
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
                    if (postData.dJQ() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.blC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.blC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.blC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.blC().getPortrait());
                        }
                        if (this.lqK != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqK.dhW()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.blC() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.blC().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.blC().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.blC().getName_show());
                        }
                        if (this.lqK != null && this.lqK.dhH() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lqK.dhH().getId());
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
                        if (this.lqK != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqK.dhW()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(tVar);
                }
            }
            z = false;
            z2 = z10;
            z3 = false;
            if (postData.blC() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dJQ() == 1) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z9) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(tVar);
        }
    }

    private void b(final t tVar, final PostData postData, final View view, final int i) {
        boolean z;
        if (tVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            tVar.lsY.setTag(sparseArray);
            tVar.lrN.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.lsY.setIsHost(true);
            if (this.lsN) {
                tVar.eGI.setVisibility(0);
            } else {
                tVar.eGI.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lqL) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.lsY.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.lsY.setLayoutParams(layoutParams);
                tVar.lsY.El(null);
                this.lsQ = false;
                a(tVar, postData, view, i);
            } else {
                this.lsQ = true;
                tVar.lsY.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bGb() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.lsY.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.lsY.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().bki() && this.lqK.dhH().blU() != null && com.baidu.tbadk.core.util.au.isEmpty(this.lqK.getForum().getName())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dJS() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dJS().bFb())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dJS() != null) {
                if (postData.dJS().aAq() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.alE.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.alE.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.alE.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.alE.setLayoutParams(layoutParams3);
                }
            }
            if (this.lqK != null && aJ(this.lqK.dhH())) {
                tVar.aiJ.setDataForPb(this.lqK.dhH().bnJ(), this.lqK.dhH().getTid(), this.lqK.getForumId());
                if (postData.dJS() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dJS().bFb())) {
                    tVar.aiJ.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.aiJ.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.aiJ.setVisibility(0);
            } else {
                tVar.aiJ.setVisibility(8);
            }
            if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().bmr() != null && this.lqK.dhH().blU() == null) {
                tVar.alE.setData(this.lqK.dhH().bmr());
                tVar.alE.setVisibility(0);
                if (this.lqK != null && this.lqK.getForum() != null) {
                    tVar.alE.setForumId(String.valueOf(this.lqK.getForum().getId()));
                }
                if (this.lqK != null && this.lqK.getThreadId() != null) {
                    tVar.alE.setThreadId(this.lqK.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.alE;
                AppletsCellView appletsCellView2 = tVar.alE;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.alE.setVisibility(8);
            }
            djA();
            if (this.lqK != null && this.lqK.lnm != null) {
                if (tVar.ltd != null) {
                    if (TextUtils.isEmpty(this.lqK.lnm.div())) {
                        tVar.ltd.setVisibility(8);
                    } else {
                        tVar.ltd.setVisibility(0);
                        tVar.ltd.setText(this.lqK.lnm.div());
                    }
                }
                if (tVar.ltc != null && tVar.ltk.getRootView() == null) {
                    tVar.ltc.addView(tVar.ltk.J(this.lqK));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lpX.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.ar("c13445").ak("obj_source", 1).bqy();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.ar("c13445").ak("obj_source", 3).bqy();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.ar("c13445").ak("obj_source", 2).bqy();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.ar("c13445").ak("obj_source", 4).bqy();
                        }
                    }
                }
            }
            if (tVar.lte != null) {
                tVar.lte.removeAllViews();
            }
            if (this.lqK != null && this.lqK.dhH() != null && !aJ(this.lqK.dhH()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lqK.dhH().bnK()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lqK.dhH().bnL()))) {
                com.baidu.tbadk.util.af afVar = new com.baidu.tbadk.util.af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lqK, afVar.n(this.lqK.dhH().bnK(), this.lqK.dhH().bnL()), this.lqK.getForumName(), this.lpX, afVar.bDp());
                tVar.lte.addView(pbLinkGoodsRootView);
                tVar.lte.setVisibility(0);
                return;
            }
            tVar.lte.setVisibility(8);
        }
    }

    public void djA() {
        t djB = djB();
        if (this.lqK != null && this.lqK.dhH() != null && djB != null) {
            djB.b(this.lqK, this.lqK.dhH().bly() == 1, this.lqK.dhH().blx() == 1);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.ltg.setVisibility(0);
            if (tVar.lth == null) {
                tVar.lth = m(postData);
            }
            if (tVar.ltg.getChildCount() <= 0 && (view = tVar.lth.getView()) != null) {
                tVar.ltg.addView(view);
            }
            tVar.lth.a(this.lsS);
            tVar.lth.a(this.lsT);
            tVar.lth.g(postData.dKb());
            tVar.lth.onChangeSkinType(this.lpX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dKb() != null && postData.dKb().bkf()) {
            BaijiahaoData baijiahaoData = postData.dKb().oriUgcInfo;
            Item item = postData.dKb().item;
            if (postData.dKb().ezh) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lpX.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.lpX.getPageContext());
            } else if (baijiahaoData != null && postData.dKb().bkm()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lpX.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.lpX.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.lpX.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.lpX.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lpX.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dKb().showType == 0 || postData.dKb().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.lpX.getPageContext(), this.pageFromType);
            } else if (postData.dKb().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.lpX.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lpX.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.an anVar) {
        if (anVar != null && !com.baidu.tbadk.core.util.au.isEmpty(anVar.getLinkUrl()) && anVar.bjX() == com.baidu.tbadk.core.data.an.ezL) {
            if (!anVar.bjY()) {
                tVar.lsY.getLayoutStrategy().sT(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.ltf.a(anVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dpH() == null) {
            tVar.lsr.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dpH(), tVar.lsr, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.lsY.setTextViewOnTouchListener(this.lsR);
        tVar.lsY.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lqS);
            tbRichTextView.getLayoutStrategy().sL(min);
            tbRichTextView.getLayoutStrategy().sM((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.lrN.setOnTouchListener(this.fgS);
        tVar.lrN.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lsC.dkB().lqj;
        tVar.lsY.setOnLongClickListener(this.mOnLongClickListener);
        tVar.lsY.setOnTouchListener(this.lsR);
        tVar.lsY.setCommonTextViewOnClickListener(this.aYm);
        tVar.lsY.setOnImageClickListener(this.fFy);
        tVar.lsY.setOnImageTouchListener(this.lsR);
        tVar.lsY.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.lsY.setOnEmotionClickListener(aVar.lGt);
        tVar.lsr.setOnClickListener(this.aYm);
        tVar.lti.setAfterItemClickListener(this.aYm);
        tVar.ltj.setAfterItemClickListener(this.aYm);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqK = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lqS = i;
    }

    public void tW(boolean z) {
        this.lqL = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lqU = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.lrB = cVar;
    }

    public void uj(boolean z) {
        this.lsN = z;
    }

    public void release() {
        if (this.Vz != 0) {
            ((t) this.Vz).ltf.destroy();
            ((t) this.Vz).ltj.destroy();
        }
    }

    public void resume() {
        if (this.Vz != 0) {
            ((t) this.Vz).ltf.resume();
        }
    }

    public void pause() {
        if (this.Vz != 0) {
            ((t) this.Vz).ltf.pause();
        }
    }

    public t djB() {
        return (t) this.Vz;
    }

    private boolean aJ(bx bxVar) {
        return (bxVar == null || bxVar.bnJ() == null || bxVar.bnJ().getOptions() == null || bxVar.bnJ().getOptions().size() <= 0) ? false : true;
    }
}
