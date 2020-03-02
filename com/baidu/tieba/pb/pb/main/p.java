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
    private TbRichTextView.i dMx;
    private com.baidu.tieba.pb.a.c dqK;
    protected com.baidu.tieba.pb.data.e iEI;
    protected boolean iEJ;
    protected int iEQ;
    private View.OnClickListener iES;
    private TbRichTextView.c iFy;
    private com.baidu.tieba.pb.pb.sub.b iFz;
    private boolean iGr;
    private boolean iGs;
    private final boolean iGt;
    private boolean iGu;
    private com.baidu.tieba.pb.a.c iGv;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> iGw;
    private b.a iGx;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iEQ = 0;
        this.iEJ = true;
        this.iGr = true;
        this.iEI = null;
        this.iFz = null;
        this.iES = null;
        this.akt = null;
        this.dMx = null;
        this.dqK = null;
        this.mOnLongClickListener = null;
        this.iFy = null;
        this.iGs = false;
        this.iGt = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.iGu = false;
        this.pageFromType = 0;
        this.iGv = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.dqK != null) {
                    p.this.dqK.Q(view);
                    p.this.dqK.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.iGw = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.aAg() != null && aVar.aAg().cTQ != null && p.this.iEI != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAg().cTQ;
                    String threadId = p.this.iEI.getThreadId();
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
        this.iGx = new b.a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.aAg() != null && aVar.aAg().cTQ != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aAg().cTQ;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.clB() != null) {
            this.pageFromType = pbFragment.clB().coh();
        }
    }

    private void a(q qVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (qVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(qVar.cVu, R.color.cp_bg_line_c);
                qVar.iGC.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                qVar.OO.onChangeSkinType();
                if (qVar.iGL != null) {
                    qVar.iGL.onChangeSkinType();
                }
                if (qVar.iGM != null) {
                    qVar.iGM.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(qVar.iGH, (int) R.color.cp_cont_j);
                qVar.iGN.pk(skinType);
            }
            qVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public q b(ViewGroup viewGroup) {
        q qVar = new q(this.iDY.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.iEJ, this.iEQ);
        a(qVar);
        qVar.iGI.yM(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.iDY.getUniqueId(), this.iEI, postData2, postData2.locate, 1);
            b(qVar, postData2, view, i);
        }
        if (!this.iGs && this.iGt && qVar != null && qVar.iGC.aUI() && (listView = this.iDY.getListView()) != null) {
            this.iGs = true;
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
        if (this.iEI != null) {
            if (postData.cLa() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    qVar.iGC.setOnClickListener(this.akt);
                    qVar.iGC.setTextViewOnClickListener(this.akt);
                } else {
                    qVar.iGC.setOnClickListener(null);
                    qVar.iGC.setTextViewOnClickListener(null);
                }
                qVar.iFE.setOnClickListener(this.akt);
            } else {
                qVar.iFE.setOnClickListener(null);
            }
            if (postData.cLa() == 1) {
                qVar.a(this.iEI, this.iDY.clr(), postData.khf);
                a(qVar.iGC, view, this.iGu);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCo() != null) {
                    j = postData.aCo().getUserIdLong();
                    str = postData.aCo().getUserName();
                    str2 = postData.aCo().getName_show();
                }
                if (this.iEI != null && this.iEI.cku() != null) {
                    qVar.iGI.a(postData.cLi(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iEI.cku().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.iDY.cmt().cqp()) {
                    qVar.iGC.setVisibility(8);
                }
                if (this.iEI != null && this.iEI.cku() != null && this.iEI.cku().aCA() != null) {
                    bv aCA = this.iEI.cku().aCA();
                    String aEz = aCA.aEz();
                    if (!StringUtils.isNull(aCA.aEA())) {
                        if (!StringUtils.isNull(aEz)) {
                            qVar.iGE.setVisibility(0);
                            qVar.iGE.startLoad(aEz, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    qVar.iGE.setVisibility(8);
                }
                if (qVar.iGF != null) {
                    qVar.iGF.setVisibility(8);
                }
                if (this.iEI != null && this.iEI.cku() != null && this.iEI.cku().aBb() && qVar.iGL != null) {
                    qVar.iGL.setPadding(qVar.iGL.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), qVar.iGL.getPaddingRight(), qVar.iGL.getPaddingBottom());
                }
            }
            qVar.iGC.getLayoutStrategy().nh(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLa()));
            if (postData.cLe() > 0 && postData.cKX() != null && postData.cKX().size() > 0) {
                if (this.iFz == null) {
                    this.iFz = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.iFz.setIsFromCDN(this.mIsFromCDN);
                    this.iFz.S(this.iES);
                    if (this.iEI != null) {
                        this.iFz.O(this.iEI.ckG(), TextUtils.equals(this.iEI.cku().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.iFz.setThreadData(this.iEI.cku());
                    }
                }
                this.iFz.Gr(postData.getId());
            }
            qVar.iGC.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.iEJ) {
                qVar.iGC.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                qVar.iGC.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            qVar.iGC.setIsFromCDN(this.mIsFromCDN);
            if (this.iEI != null && this.iEI.cku() != null && this.iEI.cku().isLinkThread()) {
                a(qVar, this.iEI.cku().aDN());
            }
            boolean z7 = false;
            if (this.iEI != null && this.iEI.cku() != null) {
                z7 = this.iEI.cku().isShareThread && postData.cLl() != null;
            }
            if (z7) {
                qVar.iGC.getLayoutStrategy().nq(yL(R.dimen.tbds14));
                a(qVar, postData);
            } else {
                qVar.iGC.getLayoutStrategy().nq(yL(R.dimen.tbds24));
            }
            TbRichText cLc = postData.cLc();
            if (this.iEI != null && this.iEI.aHK()) {
                cLc = null;
            }
            if (this.iEI.cku() != null) {
                qVar.iGC.setIsUseGridImage(this.iEI.cku().aEg());
                qVar.iGC.setmIsGridImageSupportLongPress(true);
            }
            if (this.iEI != null && 3 == this.iEI.ckV()) {
                if (this.iGs || !this.iGt) {
                    qVar.iGC.setText(cLc, false, this.iFy, true, false);
                } else {
                    qVar.iGC.setText(cLc, true, this.iFy, true, false);
                }
            } else if (this.iGs || !this.iGt) {
                qVar.iGC.setText(cLc, false, this.iFy, false, true);
            } else {
                qVar.iGC.setText(cLc, true, this.iFy, false, true);
            }
            a(qVar, postData, cLc);
            boolean z8 = !StringUtils.isNull(postData.aCo().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.iEI != null && this.iEI.ckG() != 0) {
                if (this.iEI.ckG() != 3) {
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
            if (this.iEI != null && this.iEI.cku() != null && this.iEI.cku().aCo() != null && postData.aCo() != null) {
                String userId2 = this.iEI.cku().aCo().getUserId();
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
                    if (postData.cLa() == 1) {
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
                        if (this.iEI != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEI.ckG()));
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
                        if (this.iEI != null && this.iEI.cku() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iEI.cku().getId());
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
                        if (this.iEI != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEI.ckG()));
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
            if (postData.cLa() == 1) {
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
            qVar.iGC.setTag(sparseArray);
            qVar.iFE.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            qVar.iGC.setIsHost(true);
            if (this.iGr) {
                qVar.cVu.setVisibility(0);
            } else {
                qVar.cVu.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEJ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.iGC.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                qVar.iGC.setLayoutParams(layoutParams);
                qVar.iGC.wh(null);
                this.iGu = false;
                a(qVar, postData, view, i);
            } else {
                this.iGu = true;
                qVar.iGC.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void aUO() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.iGC.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        qVar.iGC.setLayoutParams(layoutParams2);
                        p.this.a(qVar, postData, view, i);
                    }
                });
            }
            if (this.iEI != null && this.iEI.cku() != null && this.iEI.cku().aBb() && this.iEI.cku().aCF() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.iEI.getForum().getName())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cLc() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cLc().aTS())) {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                qVar.w(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cLc() != null) {
                if (postData.cLc().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.OO.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    qVar.OO.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) qVar.OO.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    qVar.OO.setLayoutParams(layoutParams3);
                }
            }
            if (this.iEI.cku() != null && this.iEI.cku().aDa() != null && this.iEI.cku().aCF() == null) {
                qVar.OO.setVisibility(0);
                qVar.OO.setData(this.iEI.cku().aDa());
                if (this.iEI.getForum() != null) {
                    qVar.OO.setForumId(String.valueOf(this.iEI.getForum().getId()));
                }
                if (this.iEI.getThreadId() != null) {
                    qVar.OO.setThreadId(this.iEI.getThreadId());
                }
                AppletsCellView appletsCellView = qVar.OO;
                AppletsCellView appletsCellView2 = qVar.OO;
                appletsCellView.setFrom("PB_card");
            } else {
                qVar.OO.setVisibility(8);
            }
            if (this.iEI != null && this.iEI.cku() != null && (this.iEI.cku().aCD() != 0 || this.iEI.cku().aBb())) {
                qVar.b(this.iEI, this.iEI.cku().aCk() == 1, this.iEI.cku().aCj() == 1);
            }
            if (this.iEI != null && this.iEI.iBF != null) {
                if (qVar.iGH != null) {
                    if (TextUtils.isEmpty(this.iEI.iBF.clb())) {
                        qVar.iGH.setVisibility(8);
                    } else {
                        qVar.iGH.setVisibility(0);
                        qVar.iGH.setText(this.iEI.iBF.clb());
                    }
                }
                if (qVar.iGG != null && qVar.iGN.getRootView() == null) {
                    qVar.iGG.addView(qVar.iGN.E(this.iEI));
                    String fromPageKey = UtilHelper.getFromPageKey(this.iDY.getPageContext());
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
            qVar.iGJ.setVisibility(0);
            if (qVar.iGK == null) {
                qVar.iGK = j(postData);
            }
            if (qVar.iGJ.getChildCount() <= 0 && (view = qVar.iGK.getView()) != null) {
                qVar.iGJ.addView(view);
            }
            qVar.iGK.a(this.iGw);
            qVar.iGK.a(this.iGx);
            qVar.iGK.g(postData.cLl());
            qVar.iGK.onChangeSkinType(this.iDY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cLl() != null && postData.cLl().aAY()) {
            BaijiahaoData baijiahaoData = postData.cLl().oriUgcInfo;
            if (postData.cLl().cOK) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.iDY.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.iDY.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iDY.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iDY.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iDY.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.iDY.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cLl().showType == 0 || postData.cLl().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.iDY.getPageContext(), this.pageFromType);
            } else if (postData.cLl().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.iDY.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.iDY.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int yL(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(q qVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.aAQ() == com.baidu.tbadk.core.data.ag.cPp) {
            if (!agVar.aAR()) {
                qVar.iGC.getLayoutStrategy().nq(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            qVar.iGI.a(agVar);
        }
    }

    private void a(q qVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.crZ() == null) {
            qVar.iFW.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.crZ(), qVar.iFW, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(q qVar) {
        qVar.iGC.setTextViewOnTouchListener(this.iGv);
        qVar.iGC.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.iEQ);
            tbRichTextView.getLayoutStrategy().ni(min);
            tbRichTextView.getLayoutStrategy().nj((int) (min * 1.618f));
        }
    }

    private void c(q qVar) {
        qVar.iFE.setOnTouchListener(this.dqK);
        qVar.iFE.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.iGg.cni().iEk;
        qVar.iGC.setOnLongClickListener(this.mOnLongClickListener);
        qVar.iGC.setOnTouchListener(this.iGv);
        qVar.iGC.setCommonTextViewOnClickListener(this.akt);
        qVar.iGC.setOnImageClickListener(this.dMx);
        qVar.iGC.setOnImageTouchListener(this.iGv);
        qVar.iGC.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        qVar.iGC.setOnEmotionClickListener(aVar.iSG);
        qVar.iFW.setOnClickListener(this.akt);
        qVar.iGL.setAfterItemClickListener(this.akt);
        qVar.iGM.setAfterItemClickListener(this.akt);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEI = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.iEQ = i;
    }

    public void pw(boolean z) {
        this.iEJ = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iES = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMx = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.iFy = cVar;
    }

    public void pJ(boolean z) {
        this.iGr = z;
    }

    public void release() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGI.destroy();
            ((q) this.Ai).iGM.destroy();
        }
    }

    public void resume() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGI.resume();
        }
    }

    public void pause() {
        if (this.Ai != 0) {
            ((q) this.Ai).iGI.pause();
        }
    }

    public q cmi() {
        return (q) this.Ai;
    }
}
