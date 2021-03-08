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
import com.baidu.card.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.cn;
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
/* loaded from: classes2.dex */
public class p extends l<PostData, PbFirstFloorViewHolder> {
    private View.OnClickListener bdi;
    private TbRichTextView.i fVW;
    private com.baidu.tieba.pb.a.c fxj;
    protected com.baidu.tieba.pb.data.f lQk;
    protected boolean lQl;
    protected int lQs;
    private View.OnClickListener lQu;
    private TbRichTextView.c lRd;
    private com.baidu.tieba.pb.pb.sub.b lRe;
    private com.baidu.tieba.pb.a.c lSA;
    private com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> lSB;
    private a.InterfaceC0094a lSC;
    private boolean lSw;
    private boolean lSx;
    private final boolean lSy;
    private boolean lSz;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lQs = 0;
        this.lQl = true;
        this.lSw = true;
        this.lQk = null;
        this.lRe = null;
        this.lQu = null;
        this.bdi = null;
        this.fVW = null;
        this.fxj = null;
        this.mOnLongClickListener = null;
        this.lRd = null;
        this.lSx = false;
        this.lSy = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lSz = false;
        this.pageFromType = 0;
        this.lSA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.fxj != null) {
                    p.this.fxj.ad(view);
                    p.this.fxj.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lSB = new com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.blp() != null && aVar.blp().eUD != null && p.this.lQk != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.blp().eUD;
                    String threadId = p.this.lQk.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12602").dR("tid", threadId).dR("obj_source", str).aq("obj_type", i));
                    }
                }
            }
        };
        this.lSC = new a.InterfaceC0094a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.a.InterfaceC0094a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.blp() != null && aVar.blp().eUD != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.blp().eUD;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dmG() != null) {
            this.pageFromType = pbFragment.dmG().dpu();
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbFirstFloorViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbFirstFloorViewHolder.eWL, R.color.CAM_X0204);
                pbFirstFloorViewHolder.lSH.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                pbFirstFloorViewHolder.anz.onChangeSkinType();
                if (pbFirstFloorViewHolder.lSR != null) {
                    pbFirstFloorViewHolder.lSR.onChangeSkinType();
                }
                if (pbFirstFloorViewHolder.lSS != null) {
                    pbFirstFloorViewHolder.lSS.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbFirstFloorViewHolder.lSM, R.color.CAM_X0107);
                pbFirstFloorViewHolder.lST.uw(skinType);
                if (pbFirstFloorViewHolder.akA != null) {
                    pbFirstFloorViewHolder.akA.onChangeSkinType(skinType);
                }
            }
            pbFirstFloorViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbFirstFloorViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.lPo.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lQl, this.lQs);
        a(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.lSO.FJ(this.pageFromType);
        return pbFirstFloorViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) pbFirstFloorViewHolder);
        a(pbFirstFloorViewHolder);
        c(pbFirstFloorViewHolder);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.bpf();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lPo.getUniqueId(), this.lQk, postData2, postData2.locate, 1);
            b(pbFirstFloorViewHolder, postData2, view, i);
        }
        if (!this.lSx && this.lSy && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.lSH.bIt() && (listView = this.lPo.getListView()) != null) {
            this.lSx = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0502  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.lQk != null) {
            if (postData.dNO() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pbFirstFloorViewHolder.lSH.setOnClickListener(this.bdi);
                    pbFirstFloorViewHolder.lSH.setTextViewOnClickListener(this.bdi);
                } else {
                    pbFirstFloorViewHolder.lSH.setOnClickListener(null);
                    pbFirstFloorViewHolder.lSH.setTextViewOnClickListener(null);
                }
                pbFirstFloorViewHolder.lRn.setOnClickListener(this.bdi);
            } else {
                pbFirstFloorViewHolder.lRn.setOnClickListener(null);
            }
            if (postData.dNO() == 1) {
                pbFirstFloorViewHolder.a(this.lQk, this.lPo.dmy(), postData.nzN);
                a(pbFirstFloorViewHolder.lSH, view, this.lSz);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnS() != null) {
                    j = postData.bnS().getUserIdLong();
                    str = postData.bnS().getUserName();
                    str2 = postData.bnS().getName_show();
                }
                if (this.lQk != null && this.lQk.dlp() != null) {
                    pbFirstFloorViewHolder.lSO.a(postData.dNW(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lQk.dlp().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lPo.dnB().drJ()) {
                    pbFirstFloorViewHolder.lSH.setVisibility(8);
                }
                if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().bod() != null) {
                    cn bod = this.lQk.dlp().bod();
                    String bqr = bod.bqr();
                    if (!StringUtils.isNull(bod.bqs())) {
                        if (!StringUtils.isNull(bqr)) {
                            pbFirstFloorViewHolder.lSJ.setVisibility(0);
                            pbFirstFloorViewHolder.lSJ.startLoad(bqr, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pbFirstFloorViewHolder.lSJ.setVisibility(8);
                }
                if (pbFirstFloorViewHolder.lSK != null) {
                    pbFirstFloorViewHolder.lSK.setVisibility(8);
                }
                if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().bmx() && pbFirstFloorViewHolder.lSR != null) {
                    pbFirstFloorViewHolder.lSR.setPadding(pbFirstFloorViewHolder.lSR.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.lSR.getPaddingRight(), pbFirstFloorViewHolder.lSR.getPaddingBottom());
                }
            }
            pbFirstFloorViewHolder.lSH.getLayoutStrategy().rZ(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNO()));
            if (postData.dNS() > 0 && postData.dNL() != null && postData.dNL().size() > 0) {
                if (this.lRe == null) {
                    this.lRe = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lRe.setIsFromCDN(this.mIsFromCDN);
                    this.lRe.Z(this.lQu);
                    if (this.lQk != null) {
                        this.lRe.ad(this.lQk.dlE(), TextUtils.equals(this.lQk.dlp().bnS().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lRe.setThreadData(this.lQk.dlp());
                    }
                }
                this.lRe.Qe(postData.getId());
            }
            pbFirstFloorViewHolder.lSH.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            if (this.lQl) {
                pbFirstFloorViewHolder.lSH.getLayoutStrategy().sc(R.drawable.transparent_bg);
            } else {
                pbFirstFloorViewHolder.lSH.getLayoutStrategy().sc(R.drawable.icon_click);
            }
            pbFirstFloorViewHolder.lSH.setIsFromCDN(this.mIsFromCDN);
            if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().isLinkThread()) {
                a(pbFirstFloorViewHolder, this.lQk.dlp().bpy());
            }
            boolean z4 = false;
            if (this.lQk != null && this.lQk.dlp() != null) {
                z4 = this.lQk.dlp().isShareThread && postData.dNZ() != null;
            }
            if (z4) {
                if (postData.dNZ().item != null) {
                    pbFirstFloorViewHolder.lSH.getLayoutStrategy().si(getDimens(R.dimen.tbds24));
                } else {
                    pbFirstFloorViewHolder.lSH.getLayoutStrategy().si(getDimens(R.dimen.tbds14));
                }
                a(pbFirstFloorViewHolder, postData);
            } else {
                pbFirstFloorViewHolder.lSH.getLayoutStrategy().si(getDimens(R.dimen.tbds24));
            }
            TbRichText dNQ = postData.dNQ();
            if (this.lQk != null && this.lQk.dlP()) {
                dNQ = null;
            }
            if (this.lQk.dlp() != null) {
                pbFirstFloorViewHolder.lSH.setIsUseGridImage(this.lQk.dlp().bpP());
                pbFirstFloorViewHolder.lSH.setmIsGridImageSupportLongPress(true);
            }
            if (this.lQk != null && 3 == this.lQk.dlV()) {
                if (this.lSx || !this.lSy) {
                    pbFirstFloorViewHolder.lSH.setText(dNQ, false, this.lRd, true, false);
                } else {
                    pbFirstFloorViewHolder.lSH.setText(dNQ, true, this.lRd, true, false);
                }
            } else if (this.lSx || !this.lSy) {
                pbFirstFloorViewHolder.lSH.setText(dNQ, false, this.lRd, false, true);
            } else {
                pbFirstFloorViewHolder.lSH.setText(dNQ, true, this.lRd, false, true);
            }
            a(pbFirstFloorViewHolder, postData, dNQ);
            boolean z5 = !StringUtils.isNull(postData.bnS().getVirtualUserUrl());
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            if (this.lQk != null && this.lQk.dlE() != 0) {
                if (this.lQk.dlE() != 3) {
                    z6 = true;
                    z7 = true;
                }
                if (postData.bnS() != null) {
                    String userId = postData.bnS().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z6 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z6 = false;
                    }
                }
            }
            if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().bnS() != null && postData.bnS() != null) {
                String userId2 = this.lQk.dlp().bnS().getUserId();
                String userId3 = postData.bnS().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z8 = true;
                    } else {
                        z8 = false;
                        z9 = true;
                    }
                    if (postData.bnS() == null && UtilHelper.isCurrentAccount(postData.bnS().getUserId())) {
                        z9 = true;
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (z5) {
                        z3 = z2;
                    } else {
                        z6 = false;
                        z3 = false;
                        z8 = false;
                    }
                    int i2 = 1;
                    if (postData.dNO() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.bnS() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnS().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnS().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnS().getPortrait());
                        }
                        if (this.lQk != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lQk.dlE()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z8) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bnS() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnS().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnS().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnS().getName_show());
                        }
                        if (this.lQk != null && this.lQk.dlp() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lQk.dlp().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z9));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        if (this.lQk != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lQk.dlE()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(pbFirstFloorViewHolder);
                }
            }
            z = z7;
            if (postData.bnS() == null) {
            }
            z2 = z;
            if (z5) {
            }
            int i22 = 1;
            if (postData.dNO() == 1) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z8) {
            }
            if (!z3) {
            }
            b(pbFirstFloorViewHolder);
        }
    }

    private void b(final PbFirstFloorViewHolder pbFirstFloorViewHolder, final PostData postData, final View view, final int i) {
        boolean z;
        if (pbFirstFloorViewHolder != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pbFirstFloorViewHolder.lSH.setTag(sparseArray);
            pbFirstFloorViewHolder.lRn.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbFirstFloorViewHolder.lSH.setIsHost(true);
            if (this.lSw) {
                pbFirstFloorViewHolder.eWL.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.eWL.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lQl) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lSH.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.lSH.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.lSH.Em(null);
                this.lSz = false;
                a(pbFirstFloorViewHolder, postData, view, i);
            } else {
                this.lSz = true;
                pbFirstFloorViewHolder.lSH.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bIz() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lSH.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pbFirstFloorViewHolder.lSH.setLayoutParams(layoutParams2);
                        p.this.a(pbFirstFloorViewHolder, postData, view, i);
                    }
                });
            }
            if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().bmx() && this.lQk.dlp().boj() != null && com.baidu.tbadk.core.util.au.isEmpty(this.lQk.getForum().getName())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dNQ() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dNQ().bHD())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dNQ() != null) {
                if (postData.dNQ().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.anz.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pbFirstFloorViewHolder.anz.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.anz.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pbFirstFloorViewHolder.anz.setLayoutParams(layoutParams3);
                }
            }
            if (this.lQk != null && aL(this.lQk.dlp())) {
                pbFirstFloorViewHolder.akA.setDataForPb(this.lQk.dlp().bqa(), this.lQk.dlp().getTid(), this.lQk.getForumId());
                if (postData.dNQ() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dNQ().bHD())) {
                    pbFirstFloorViewHolder.akA.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    pbFirstFloorViewHolder.akA.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                pbFirstFloorViewHolder.akA.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.akA.setVisibility(8);
            }
            if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().boG() != null && this.lQk.dlp().boj() == null) {
                pbFirstFloorViewHolder.anz.setData(this.lQk.dlp().boG());
                pbFirstFloorViewHolder.anz.setVisibility(0);
                if (this.lQk != null && this.lQk.getForum() != null) {
                    pbFirstFloorViewHolder.anz.setForumId(String.valueOf(this.lQk.getForum().getId()));
                }
                if (this.lQk != null && this.lQk.getThreadId() != null) {
                    pbFirstFloorViewHolder.anz.setThreadId(this.lQk.getThreadId());
                }
                AppletsCellView appletsCellView = pbFirstFloorViewHolder.anz;
                AppletsCellView appletsCellView2 = pbFirstFloorViewHolder.anz;
                appletsCellView.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.anz.setVisibility(8);
            }
            dno();
            if (this.lQk != null && this.lQk.lMq != null) {
                if (pbFirstFloorViewHolder.lSM != null) {
                    if (TextUtils.isEmpty(this.lQk.lMq.dmf())) {
                        pbFirstFloorViewHolder.lSM.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.lSM.setVisibility(0);
                        pbFirstFloorViewHolder.lSM.setText(this.lQk.lMq.dmf());
                    }
                }
                if (pbFirstFloorViewHolder.lSL != null && pbFirstFloorViewHolder.lST.getRootView() == null) {
                    pbFirstFloorViewHolder.lSL.addView(pbFirstFloorViewHolder.lST.K(this.lQk));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lPo.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.ar("c13445").aq("obj_source", 1).bsR();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.ar("c13445").aq("obj_source", 3).bsR();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.ar("c13445").aq("obj_source", 2).bsR();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.ar("c13445").aq("obj_source", 4).bsR();
                        }
                    }
                }
            }
            if (pbFirstFloorViewHolder.lSN != null) {
                pbFirstFloorViewHolder.lSN.removeAllViews();
            }
            if (this.lQk != null && this.lQk.dlp() != null && !aL(this.lQk.dlp()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lQk.dlp().bqb()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lQk.dlp().bqc()))) {
                com.baidu.tbadk.util.ah ahVar = new com.baidu.tbadk.util.ah();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lQk, ahVar.n(this.lQk.dlp().bqb(), this.lQk.dlp().bqc()), this.lQk.getForumName(), this.lPo, ahVar.bFQ());
                pbFirstFloorViewHolder.lSN.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.lSN.setVisibility(0);
                return;
            }
            pbFirstFloorViewHolder.lSN.setVisibility(8);
        }
    }

    public void dno() {
        PbFirstFloorViewHolder dnp = dnp();
        if (this.lQk != null && this.lQk.dlp() != null && dnp != null) {
            dnp.b(this.lQk, this.lQk.dlp().bnO() == 1, this.lQk.dlp().bnN() == 1);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View view;
        if (pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.lSP.setVisibility(0);
            if (pbFirstFloorViewHolder.lSQ == null) {
                pbFirstFloorViewHolder.lSQ = m(postData);
            }
            if (pbFirstFloorViewHolder.lSP.getChildCount() <= 0 && (view = pbFirstFloorViewHolder.lSQ.getView()) != null) {
                pbFirstFloorViewHolder.lSP.addView(view);
            }
            pbFirstFloorViewHolder.lSQ.a(this.lSB);
            pbFirstFloorViewHolder.lSQ.a(this.lSC);
            pbFirstFloorViewHolder.lSQ.g(postData.dNZ());
            pbFirstFloorViewHolder.lSQ.onChangeSkinType(this.lPo.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dNZ() != null && postData.dNZ().bmu()) {
            BaijiahaoData baijiahaoData = postData.dNZ().oriUgcInfo;
            Item item = postData.dNZ().item;
            if (postData.dNZ().eOY) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lPo.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dNZ().showType == 0 || postData.dNZ().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lPo.getPageContext()) : postData.dNZ().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lPo.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lPo.getPageContext());
            } else if (baijiahaoData != null && postData.dNZ().bmB()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lPo.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lPo.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lPo.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lPo.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lPo.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dNZ().showType == 0 || postData.dNZ().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lPo.getPageContext(), this.pageFromType);
            } else if (postData.dNZ().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lPo.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lPo.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null && !com.baidu.tbadk.core.util.au.isEmpty(apVar.getLinkUrl()) && apVar.bmk() == com.baidu.tbadk.core.data.ap.ePB) {
            if (!apVar.bml()) {
                pbFirstFloorViewHolder.lSH.getLayoutStrategy().si(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pbFirstFloorViewHolder.lSO.a(apVar);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dtB() == null) {
            pbFirstFloorViewHolder.lRQ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dtB(), pbFirstFloorViewHolder.lRQ, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lSH.setTextViewOnTouchListener(this.lSA);
        pbFirstFloorViewHolder.lSH.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lQs);
            tbRichTextView.getLayoutStrategy().sa(min);
            tbRichTextView.getLayoutStrategy().sb((int) (min * 1.618f));
        }
    }

    private void c(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lRn.setOnTouchListener(this.fxj);
        pbFirstFloorViewHolder.lRn.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lSl.doq().lPA;
        pbFirstFloorViewHolder.lSH.setOnLongClickListener(this.mOnLongClickListener);
        pbFirstFloorViewHolder.lSH.setOnTouchListener(this.lSA);
        pbFirstFloorViewHolder.lSH.setCommonTextViewOnClickListener(this.bdi);
        pbFirstFloorViewHolder.lSH.setOnImageClickListener(this.fVW);
        pbFirstFloorViewHolder.lSH.setOnImageTouchListener(this.lSA);
        pbFirstFloorViewHolder.lSH.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        pbFirstFloorViewHolder.lSH.setOnEmotionClickListener(aVar.mgr);
        pbFirstFloorViewHolder.lRQ.setOnClickListener(this.bdi);
        pbFirstFloorViewHolder.lSR.setAfterItemClickListener(this.bdi);
        pbFirstFloorViewHolder.lSS.setAfterItemClickListener(this.bdi);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lQk = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lQs = i;
    }

    public void uJ(boolean z) {
        this.lQl = z;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lQu = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fxj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.lRd = cVar;
    }

    public void uX(boolean z) {
        this.lSw = z;
    }

    public void release() {
        if (this.XI != 0) {
            ((PbFirstFloorViewHolder) this.XI).lSO.destroy();
            ((PbFirstFloorViewHolder) this.XI).lSS.destroy();
        }
    }

    public void resume() {
        if (this.XI != 0) {
            ((PbFirstFloorViewHolder) this.XI).lSO.resume();
        }
    }

    public void pause() {
        if (this.XI != 0) {
            ((PbFirstFloorViewHolder) this.XI).lSO.pause();
        }
    }

    public PbFirstFloorViewHolder dnp() {
        return (PbFirstFloorViewHolder) this.XI;
    }

    private boolean aL(cb cbVar) {
        return (cbVar == null || cbVar.bqa() == null || cbVar.bqa().getOptions() == null || cbVar.bqa().getOptions().size() <= 0) ? false : true;
    }
}
