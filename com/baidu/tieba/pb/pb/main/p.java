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
    private View.OnClickListener aDc;
    private com.baidu.tieba.pb.a.c dRh;
    private TbRichTextView.i emS;
    protected com.baidu.tieba.pb.data.e jqC;
    protected boolean jqD;
    protected int jqK;
    private View.OnClickListener jqM;
    private TbRichTextView.c jrs;
    private com.baidu.tieba.pb.pb.sub.b jrt;
    private boolean jsl;
    private boolean jsm;
    private final boolean jsn;
    private boolean jso;
    private com.baidu.tieba.pb.a.c jsp;
    private com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a> jsq;
    private b.a jsr;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jqK = 0;
        this.jqD = true;
        this.jsl = true;
        this.jqC = null;
        this.jrt = null;
        this.jqM = null;
        this.aDc = null;
        this.emS = null;
        this.dRh = null;
        this.mOnLongClickListener = null;
        this.jrs = null;
        this.jsm = false;
        this.jsn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.jso = false;
        this.pageFromType = 0;
        this.jsp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.dRh != null) {
                    p.this.dRh.S(view);
                    p.this.dRh.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.jsq = new com.baidu.tieba.card.z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.aIw() != null && aVar.aIw().dto != null && p.this.jqC != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aIw().dto;
                    String threadId = p.this.jqC.getThreadId();
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
        this.jsr = new b.a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.aIw() != null && aVar.aIw().dto != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.aIw().dto;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.cwD() != null) {
            this.pageFromType = pbFragment.cwD().czj();
        }
    }

    private void a(q qVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (qVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(qVar.duT, R.color.cp_bg_line_c);
                qVar.jsw.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                qVar.ahs.onChangeSkinType();
                if (qVar.jsF != null) {
                    qVar.jsF.onChangeSkinType();
                }
                if (qVar.jsG != null) {
                    qVar.jsG.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(qVar.jsB, (int) R.color.cp_cont_j);
                qVar.jsH.pH(skinType);
            }
            qVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public q b(ViewGroup viewGroup) {
        q qVar = new q(this.jpS.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.jqD, this.jqK);
        a(qVar);
        qVar.jsC.zv(this.pageFromType);
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
            postData2.aLN();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.jpS.getUniqueId(), this.jqC, postData2, postData2.locate, 1);
            b(qVar, postData2, view, i);
        }
        if (!this.jsm && this.jsn && qVar != null && qVar.jsw.bcX() && (listView = this.jpS.getListView()) != null) {
            this.jsm = true;
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
        if (this.jqC != null) {
            if (postData.cWr() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    qVar.jsw.setOnClickListener(this.aDc);
                    qVar.jsw.setTextViewOnClickListener(this.aDc);
                } else {
                    qVar.jsw.setOnClickListener(null);
                    qVar.jsw.setTextViewOnClickListener(null);
                }
                qVar.jry.setOnClickListener(this.aDc);
            } else {
                qVar.jry.setOnClickListener(null);
            }
            if (postData.cWr() == 1) {
                qVar.a(this.jqC, this.jpS.cwt(), postData.kTa);
                a(qVar.jsw, view, this.jso);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aKE() != null) {
                    j = postData.aKE().getUserIdLong();
                    str = postData.aKE().getUserName();
                    str2 = postData.aKE().getName_show();
                }
                if (this.jqC != null && this.jqC.cvu() != null) {
                    qVar.jsC.a(postData.cWz(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jqC.cvu().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.jpS.cxv().cBr()) {
                    qVar.jsw.setVisibility(8);
                }
                if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvu().aKQ() != null) {
                    bv aKQ = this.jqC.cvu().aKQ();
                    String aMR = aKQ.aMR();
                    if (!StringUtils.isNull(aKQ.aMS())) {
                        if (!StringUtils.isNull(aMR)) {
                            qVar.jsy.setVisibility(0);
                            qVar.jsy.startLoad(aMR, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    qVar.jsy.setVisibility(8);
                }
                if (qVar.jsz != null) {
                    qVar.jsz.setVisibility(8);
                }
                if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvu().aJr() && qVar.jsF != null) {
                    qVar.jsF.setPadding(qVar.jsF.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), qVar.jsF.getPaddingRight(), qVar.jsF.getPaddingBottom());
                }
            }
            qVar.jsw.getLayoutStrategy().nv(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cWr()));
            if (postData.cWv() > 0 && postData.cWo() != null && postData.cWo().size() > 0) {
                if (this.jrt == null) {
                    this.jrt = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.jrt.setIsFromCDN(this.mIsFromCDN);
                    this.jrt.T(this.jqM);
                    if (this.jqC != null) {
                        this.jrt.U(this.jqC.cvG(), TextUtils.equals(this.jqC.cvu().aKE().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.jrt.setThreadData(this.jqC.cvu());
                    }
                }
                this.jrt.HZ(postData.getId());
            }
            qVar.jsw.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.jqD) {
                qVar.jsw.getLayoutStrategy().ny(R.drawable.transparent_bg);
            } else {
                qVar.jsw.getLayoutStrategy().ny(R.drawable.icon_click);
            }
            qVar.jsw.setIsFromCDN(this.mIsFromCDN);
            if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvu().isLinkThread()) {
                a(qVar, this.jqC.cvu().aMf());
            }
            boolean z7 = false;
            if (this.jqC != null && this.jqC.cvu() != null) {
                z7 = this.jqC.cvu().isShareThread && postData.cWC() != null;
            }
            if (z7) {
                qVar.jsw.getLayoutStrategy().nE(zu(R.dimen.tbds14));
                a(qVar, postData);
            } else {
                qVar.jsw.getLayoutStrategy().nE(zu(R.dimen.tbds24));
            }
            TbRichText cWt = postData.cWt();
            if (this.jqC != null && this.jqC.aQh()) {
                cWt = null;
            }
            if (this.jqC.cvu() != null) {
                qVar.jsw.setIsUseGridImage(this.jqC.cvu().aMy());
                qVar.jsw.setmIsGridImageSupportLongPress(true);
            }
            if (this.jqC != null && 3 == this.jqC.cvV()) {
                if (this.jsm || !this.jsn) {
                    qVar.jsw.setText(cWt, false, this.jrs, true, false);
                } else {
                    qVar.jsw.setText(cWt, true, this.jrs, true, false);
                }
            } else if (this.jsm || !this.jsn) {
                qVar.jsw.setText(cWt, false, this.jrs, false, true);
            } else {
                qVar.jsw.setText(cWt, true, this.jrs, false, true);
            }
            a(qVar, postData, cWt);
            boolean z8 = !StringUtils.isNull(postData.aKE().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.jqC != null && this.jqC.cvG() != 0) {
                if (this.jqC.cvG() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aKE() != null) {
                    String userId = postData.aKE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvu().aKE() != null && postData.aKE() != null) {
                String userId2 = this.jqC.cvu().aKE().getUserId();
                String userId3 = postData.aKE().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aKE() == null && UtilHelper.isCurrentAccount(postData.aKE().getUserId())) {
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
                    if (postData.cWr() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aKE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aKE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKE().getPortrait());
                        }
                        if (this.jqC != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqC.cvG()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aKE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKE().getName_show());
                        }
                        if (this.jqC != null && this.jqC.cvu() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jqC.cvu().getId());
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
                        if (this.jqC != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqC.cvG()));
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
            if (postData.aKE() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.cWr() == 1) {
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
            qVar.jsw.setTag(sparseArray);
            qVar.jry.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            qVar.jsw.setIsHost(true);
            if (this.jsl) {
                qVar.duT.setVisibility(0);
            } else {
                qVar.duT.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jqD) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.jsw.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                qVar.jsw.setLayoutParams(layoutParams);
                qVar.jsw.xv(null);
                this.jso = false;
                a(qVar, postData, view, i);
            } else {
                this.jso = true;
                qVar.jsw.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bdd() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.jsw.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        qVar.jsw.setLayoutParams(layoutParams2);
                        p.this.a(qVar, postData, view, i);
                    }
                });
            }
            if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvu().aJr() && this.jqC.cvu().aKV() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.jqC.getForum().getName())) {
                qVar.x(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cWt() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cWt().bch())) {
                qVar.x(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                qVar.x(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.cWt() != null) {
                if (postData.cWt().afM() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.ahs.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    qVar.ahs.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) qVar.ahs.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    qVar.ahs.setLayoutParams(layoutParams3);
                }
            }
            if (this.jqC.cvu() != null && this.jqC.cvu().aLq() != null && this.jqC.cvu().aKV() == null) {
                qVar.ahs.setVisibility(0);
                qVar.ahs.setData(this.jqC.cvu().aLq());
                if (this.jqC.getForum() != null) {
                    qVar.ahs.setForumId(String.valueOf(this.jqC.getForum().getId()));
                }
                if (this.jqC.getThreadId() != null) {
                    qVar.ahs.setThreadId(this.jqC.getThreadId());
                }
                AppletsCellView appletsCellView = qVar.ahs;
                AppletsCellView appletsCellView2 = qVar.ahs;
                appletsCellView.setFrom("PB_card");
            } else {
                qVar.ahs.setVisibility(8);
            }
            if (this.jqC != null && this.jqC.cvu() != null && (this.jqC.cvu().aKT() != 0 || this.jqC.cvu().aJr())) {
                qVar.b(this.jqC, this.jqC.cvu().aKA() == 1, this.jqC.cvu().aKz() == 1);
            }
            if (this.jqC != null && this.jqC.jnx != null) {
                if (qVar.jsB != null) {
                    if (TextUtils.isEmpty(this.jqC.jnx.cwd())) {
                        qVar.jsB.setVisibility(8);
                    } else {
                        qVar.jsB.setVisibility(0);
                        qVar.jsB.setText(this.jqC.jnx.cwd());
                    }
                }
                if (qVar.jsA != null && qVar.jsH.getRootView() == null) {
                    qVar.jsA.addView(qVar.jsH.E(this.jqC));
                    String fromPageKey = UtilHelper.getFromPageKey(this.jpS.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 1).aOR();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 3).aOR();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 2).aOR();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").af("obj_source", 4).aOR();
                        }
                    }
                }
            }
        }
    }

    private void a(q qVar, PostData postData) {
        View view;
        if (qVar != null && postData != null) {
            qVar.jsD.setVisibility(0);
            if (qVar.jsE == null) {
                qVar.jsE = j(postData);
            }
            if (qVar.jsD.getChildCount() <= 0 && (view = qVar.jsE.getView()) != null) {
                qVar.jsD.addView(view);
            }
            qVar.jsE.a(this.jsq);
            qVar.jsE.a(this.jsr);
            qVar.jsE.g(postData.cWC());
            qVar.jsE.onChangeSkinType(this.jpS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a j(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.cWC() != null && postData.cWC().aJo()) {
            BaijiahaoData baijiahaoData = postData.cWC().oriUgcInfo;
            if (postData.cWC().doe) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.jpS.getPageContext(), this.pageFromType);
            } else if (baijiahaoData != null) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.jpS.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jpS.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jpS.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jpS.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.jpS.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.cWC().showType == 0 || postData.cWC().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.jpS.getPageContext(), this.pageFromType);
            } else if (postData.cWC().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.jpS.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.jpS.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int zu(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(q qVar, com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(agVar.getLinkUrl()) && agVar.aJg() == com.baidu.tbadk.core.data.ag.doJ) {
            if (!agVar.aJh()) {
                qVar.jsw.getLayoutStrategy().nE(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            qVar.jsC.a(agVar);
        }
    }

    private void a(q qVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cDb() == null) {
            qVar.jrQ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cDb(), qVar.jrQ, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(q qVar) {
        qVar.jsw.setTextViewOnTouchListener(this.jsp);
        qVar.jsw.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.jqK);
            tbRichTextView.getLayoutStrategy().nw(min);
            tbRichTextView.getLayoutStrategy().nx((int) (min * 1.618f));
        }
    }

    private void c(q qVar) {
        qVar.jry.setOnTouchListener(this.dRh);
        qVar.jry.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.jsa.cyk().jqe;
        qVar.jsw.setOnLongClickListener(this.mOnLongClickListener);
        qVar.jsw.setOnTouchListener(this.jsp);
        qVar.jsw.setCommonTextViewOnClickListener(this.aDc);
        qVar.jsw.setOnImageClickListener(this.emS);
        qVar.jsw.setOnImageTouchListener(this.jsp);
        qVar.jsw.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        qVar.jsw.setOnEmotionClickListener(aVar.jEC);
        qVar.jrQ.setOnClickListener(this.aDc);
        qVar.jsF.setAfterItemClickListener(this.aDc);
        qVar.jsG.setAfterItemClickListener(this.aDc);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqC = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.jqK = i;
    }

    public void qG(boolean z) {
        this.jqD = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqM = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emS = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRh = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.jrs = cVar;
    }

    public void qT(boolean z) {
        this.jsl = z;
    }

    public void release() {
        if (this.Tx != 0) {
            ((q) this.Tx).jsC.destroy();
            ((q) this.Tx).jsG.destroy();
        }
    }

    public void resume() {
        if (this.Tx != 0) {
            ((q) this.Tx).jsC.resume();
        }
    }

    public void pause() {
        if (this.Tx != 0) {
            ((q) this.Tx).jsC.pause();
        }
    }

    public q cxk() {
        return (q) this.Tx;
    }
}
