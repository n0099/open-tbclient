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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cl;
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
    private View.OnClickListener bdp;
    private TbRichTextView.i fWO;
    private com.baidu.tieba.pb.a.c fyb;
    protected com.baidu.tieba.pb.data.f lJI;
    protected boolean lJJ;
    protected int lJQ;
    private View.OnClickListener lJS;
    private TbRichTextView.c lKB;
    private com.baidu.tieba.pb.pb.sub.b lKC;
    private boolean lLQ;
    private boolean lLR;
    private final boolean lLS;
    private boolean lLT;
    private com.baidu.tieba.pb.a.c lLU;
    private com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> lLV;
    private a.InterfaceC0089a lLW;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lJQ = 0;
        this.lJJ = true;
        this.lLQ = true;
        this.lJI = null;
        this.lKC = null;
        this.lJS = null;
        this.bdp = null;
        this.fWO = null;
        this.fyb = null;
        this.mOnLongClickListener = null;
        this.lKB = null;
        this.lLR = false;
        this.lLS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lLT = false;
        this.pageFromType = 0;
        this.lLU = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.fyb != null) {
                    p.this.fyb.ad(view);
                    p.this.fyb.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lLV = new com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.boO() != null && aVar.boO().eVB != null && p.this.lJI != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.boO().eVB;
                    String threadId = p.this.lJI.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12602").dX("tid", threadId).dX("obj_source", str).an("obj_type", i));
                    }
                }
            }
        };
        this.lLW = new a.InterfaceC0089a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.boO() != null && aVar.boO().eVB != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.boO().eVB;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dnV() != null) {
            this.pageFromType = pbFragment.dnV().dqH();
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbFirstFloorViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbFirstFloorViewHolder.eXI, R.color.CAM_X0204);
                pbFirstFloorViewHolder.lMb.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
                pbFirstFloorViewHolder.ani.onChangeSkinType();
                if (pbFirstFloorViewHolder.lMl != null) {
                    pbFirstFloorViewHolder.lMl.onChangeSkinType();
                }
                if (pbFirstFloorViewHolder.lMm != null) {
                    pbFirstFloorViewHolder.lMm.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbFirstFloorViewHolder.lMg, R.color.CAM_X0107);
                pbFirstFloorViewHolder.lMn.vU(skinType);
                if (pbFirstFloorViewHolder.akk != null) {
                    pbFirstFloorViewHolder.akk.onChangeSkinType(skinType);
                }
            }
            pbFirstFloorViewHolder.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cu */
    public PbFirstFloorViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.lIO.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lJJ, this.lJQ);
        a(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.lMi.GT(this.pageFromType);
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
            postData2.bsE();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lIO.getUniqueId(), this.lJI, postData2, postData2.locate, 1);
            b(pbFirstFloorViewHolder, postData2, view, i);
        }
        if (!this.lLR && this.lLS && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.lMb.bLN() && (listView = this.lIO.getListView()) != null) {
            this.lLR = true;
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
        if (this.lJI != null) {
            if (postData.dPd() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pbFirstFloorViewHolder.lMb.setOnClickListener(this.bdp);
                    pbFirstFloorViewHolder.lMb.setTextViewOnClickListener(this.bdp);
                } else {
                    pbFirstFloorViewHolder.lMb.setOnClickListener(null);
                    pbFirstFloorViewHolder.lMb.setTextViewOnClickListener(null);
                }
                pbFirstFloorViewHolder.lKK.setOnClickListener(this.bdp);
            } else {
                pbFirstFloorViewHolder.lKK.setOnClickListener(null);
            }
            if (postData.dPd() == 1) {
                pbFirstFloorViewHolder.a(this.lJI, this.lIO.dnN(), postData.nsf);
                a(pbFirstFloorViewHolder.lMb, view, this.lLT);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.brq() != null) {
                    j = postData.brq().getUserIdLong();
                    str = postData.brq().getUserName();
                    str2 = postData.brq().getName_show();
                }
                if (this.lJI != null && this.lJI.dmE() != null) {
                    pbFirstFloorViewHolder.lMi.a(postData.dPl(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lJI.dmE().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lIO.doO().dsW()) {
                    pbFirstFloorViewHolder.lMb.setVisibility(8);
                }
                if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().brB() != null) {
                    cl brB = this.lJI.dmE().brB();
                    String btQ = brB.btQ();
                    if (!StringUtils.isNull(brB.btR())) {
                        if (!StringUtils.isNull(btQ)) {
                            pbFirstFloorViewHolder.lMd.setVisibility(0);
                            pbFirstFloorViewHolder.lMd.startLoad(btQ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pbFirstFloorViewHolder.lMd.setVisibility(8);
                }
                if (pbFirstFloorViewHolder.lMe != null) {
                    pbFirstFloorViewHolder.lMe.setVisibility(8);
                }
                if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().bpV() && pbFirstFloorViewHolder.lMl != null) {
                    pbFirstFloorViewHolder.lMl.setPadding(pbFirstFloorViewHolder.lMl.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.lMl.getPaddingRight(), pbFirstFloorViewHolder.lMl.getPaddingBottom());
                }
            }
            pbFirstFloorViewHolder.lMb.getLayoutStrategy().ty(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPd()));
            if (postData.dPh() > 0 && postData.dPa() != null && postData.dPa().size() > 0) {
                if (this.lKC == null) {
                    this.lKC = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lKC.setIsFromCDN(this.mIsFromCDN);
                    this.lKC.Y(this.lJS);
                    if (this.lJI != null) {
                        this.lKC.ad(this.lJI.dmT(), TextUtils.equals(this.lJI.dmE().brq().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lKC.setThreadData(this.lJI.dmE());
                    }
                }
                this.lKC.Qo(postData.getId());
            }
            pbFirstFloorViewHolder.lMb.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            if (this.lJJ) {
                pbFirstFloorViewHolder.lMb.getLayoutStrategy().tB(R.drawable.transparent_bg);
            } else {
                pbFirstFloorViewHolder.lMb.getLayoutStrategy().tB(R.drawable.icon_click);
            }
            pbFirstFloorViewHolder.lMb.setIsFromCDN(this.mIsFromCDN);
            if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().isLinkThread()) {
                a(pbFirstFloorViewHolder, this.lJI.dmE().bsX());
            }
            boolean z4 = false;
            if (this.lJI != null && this.lJI.dmE() != null) {
                z4 = this.lJI.dmE().isShareThread && postData.dPo() != null;
            }
            if (z4) {
                if (postData.dPo().item != null) {
                    pbFirstFloorViewHolder.lMb.getLayoutStrategy().tH(getDimens(R.dimen.tbds24));
                } else {
                    pbFirstFloorViewHolder.lMb.getLayoutStrategy().tH(getDimens(R.dimen.tbds14));
                }
                a(pbFirstFloorViewHolder, postData);
            } else {
                pbFirstFloorViewHolder.lMb.getLayoutStrategy().tH(getDimens(R.dimen.tbds24));
            }
            TbRichText dPf = postData.dPf();
            if (this.lJI != null && this.lJI.dne()) {
                dPf = null;
            }
            if (this.lJI.dmE() != null) {
                pbFirstFloorViewHolder.lMb.setIsUseGridImage(this.lJI.dmE().bto());
                pbFirstFloorViewHolder.lMb.setmIsGridImageSupportLongPress(true);
            }
            if (this.lJI != null && 3 == this.lJI.dnk()) {
                if (this.lLR || !this.lLS) {
                    pbFirstFloorViewHolder.lMb.setText(dPf, false, this.lKB, true, false);
                } else {
                    pbFirstFloorViewHolder.lMb.setText(dPf, true, this.lKB, true, false);
                }
            } else if (this.lLR || !this.lLS) {
                pbFirstFloorViewHolder.lMb.setText(dPf, false, this.lKB, false, true);
            } else {
                pbFirstFloorViewHolder.lMb.setText(dPf, true, this.lKB, false, true);
            }
            a(pbFirstFloorViewHolder, postData, dPf);
            boolean z5 = !StringUtils.isNull(postData.brq().getVirtualUserUrl());
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            if (this.lJI != null && this.lJI.dmT() != 0) {
                if (this.lJI.dmT() != 3) {
                    z6 = true;
                    z7 = true;
                }
                if (postData.brq() != null) {
                    String userId = postData.brq().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z6 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z6 = false;
                    }
                }
            }
            if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().brq() != null && postData.brq() != null) {
                String userId2 = this.lJI.dmE().brq().getUserId();
                String userId3 = postData.brq().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z8 = true;
                    } else {
                        z8 = false;
                        z9 = true;
                    }
                    if (postData.brq() == null && UtilHelper.isCurrentAccount(postData.brq().getUserId())) {
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
                    if (postData.dPd() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.brq() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.brq().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.brq().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.brq().getPortrait());
                        }
                        if (this.lJI != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJI.dmT()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z8) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.brq() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brq().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.brq().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brq().getName_show());
                        }
                        if (this.lJI != null && this.lJI.dmE() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lJI.dmE().getId());
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
                        if (this.lJI != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJI.dmT()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(pbFirstFloorViewHolder);
                }
            }
            z = z7;
            if (postData.brq() == null) {
            }
            z2 = z;
            if (z5) {
            }
            int i22 = 1;
            if (postData.dPd() == 1) {
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
            pbFirstFloorViewHolder.lMb.setTag(sparseArray);
            pbFirstFloorViewHolder.lKK.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbFirstFloorViewHolder.lMb.setIsHost(true);
            if (this.lLQ) {
                pbFirstFloorViewHolder.eXI.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.eXI.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lJJ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lMb.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.lMb.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.lMb.EW(null);
                this.lLT = false;
                a(pbFirstFloorViewHolder, postData, view, i);
            } else {
                this.lLT = true;
                pbFirstFloorViewHolder.lMb.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bLT() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lMb.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pbFirstFloorViewHolder.lMb.setLayoutParams(layoutParams2);
                        p.this.a(pbFirstFloorViewHolder, postData, view, i);
                    }
                });
            }
            if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().bpV() && this.lJI.dmE().brH() != null && com.baidu.tbadk.core.util.at.isEmpty(this.lJI.getForum().getName())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dPf() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dPf().bKW())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dPf() != null) {
                if (postData.dPf().aES() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.ani.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pbFirstFloorViewHolder.ani.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.ani.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pbFirstFloorViewHolder.ani.setLayoutParams(layoutParams3);
                }
            }
            if (this.lJI != null && aK(this.lJI.dmE())) {
                pbFirstFloorViewHolder.akk.setDataForPb(this.lJI.dmE().btz(), this.lJI.dmE().getTid(), this.lJI.getForumId());
                if (postData.dPf() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dPf().bKW())) {
                    pbFirstFloorViewHolder.akk.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    pbFirstFloorViewHolder.akk.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                pbFirstFloorViewHolder.akk.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.akk.setVisibility(8);
            }
            if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().bsf() != null && this.lJI.dmE().brH() == null) {
                pbFirstFloorViewHolder.ani.setData(this.lJI.dmE().bsf());
                pbFirstFloorViewHolder.ani.setVisibility(0);
                if (this.lJI != null && this.lJI.getForum() != null) {
                    pbFirstFloorViewHolder.ani.setForumId(String.valueOf(this.lJI.getForum().getId()));
                }
                if (this.lJI != null && this.lJI.getThreadId() != null) {
                    pbFirstFloorViewHolder.ani.setThreadId(this.lJI.getThreadId());
                }
                AppletsCellView appletsCellView = pbFirstFloorViewHolder.ani;
                AppletsCellView appletsCellView2 = pbFirstFloorViewHolder.ani;
                appletsCellView.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.ani.setVisibility(8);
            }
            doC();
            if (this.lJI != null && this.lJI.lFT != null) {
                if (pbFirstFloorViewHolder.lMg != null) {
                    if (TextUtils.isEmpty(this.lJI.lFT.dnv())) {
                        pbFirstFloorViewHolder.lMg.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.lMg.setVisibility(0);
                        pbFirstFloorViewHolder.lMg.setText(this.lJI.lFT.dnv());
                    }
                }
                if (pbFirstFloorViewHolder.lMf != null && pbFirstFloorViewHolder.lMn.getRootView() == null) {
                    pbFirstFloorViewHolder.lMf.addView(pbFirstFloorViewHolder.lMn.K(this.lJI));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lIO.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 1).bwn();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 3).bwn();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 2).bwn();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 4).bwn();
                        }
                    }
                }
            }
            if (pbFirstFloorViewHolder.lMh != null) {
                pbFirstFloorViewHolder.lMh.removeAllViews();
            }
            if (this.lJI != null && this.lJI.dmE() != null && !aK(this.lJI.dmE()) && (!com.baidu.tbadk.core.util.x.isEmpty(this.lJI.dmE().btA()) || !com.baidu.tbadk.core.util.x.isEmpty(this.lJI.dmE().btB()))) {
                com.baidu.tbadk.util.ae aeVar = new com.baidu.tbadk.util.ae();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lJI, aeVar.p(this.lJI.dmE().btA(), this.lJI.dmE().btB()), this.lJI.getForumName(), this.lIO, aeVar.bJj());
                pbFirstFloorViewHolder.lMh.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.lMh.setVisibility(0);
                return;
            }
            pbFirstFloorViewHolder.lMh.setVisibility(8);
        }
    }

    public void doC() {
        PbFirstFloorViewHolder doD = doD();
        if (this.lJI != null && this.lJI.dmE() != null && doD != null) {
            doD.b(this.lJI, this.lJI.dmE().brm() == 1, this.lJI.dmE().brl() == 1);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View view;
        if (pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.lMj.setVisibility(0);
            if (pbFirstFloorViewHolder.lMk == null) {
                pbFirstFloorViewHolder.lMk = m(postData);
            }
            if (pbFirstFloorViewHolder.lMj.getChildCount() <= 0 && (view = pbFirstFloorViewHolder.lMk.getView()) != null) {
                pbFirstFloorViewHolder.lMj.addView(view);
            }
            pbFirstFloorViewHolder.lMk.a(this.lLV);
            pbFirstFloorViewHolder.lMk.a(this.lLW);
            pbFirstFloorViewHolder.lMk.g(postData.dPo());
            pbFirstFloorViewHolder.lMk.onChangeSkinType(this.lIO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dPo() != null && postData.dPo().bpS()) {
            BaijiahaoData baijiahaoData = postData.dPo().oriUgcInfo;
            Item item = postData.dPo().item;
            if (postData.dPo().ePW) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lIO.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dPo().showType == 0 || postData.dPo().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lIO.getPageContext()) : postData.dPo().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lIO.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lIO.getPageContext());
            } else if (baijiahaoData != null && postData.dPo().bpZ()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lIO.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lIO.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lIO.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lIO.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lIO.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dPo().showType == 0 || postData.dPo().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lIO.getPageContext(), this.pageFromType);
            } else if (postData.dPo().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lIO.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lIO.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.at.isEmpty(aoVar.getLinkUrl()) && aoVar.bpJ() == com.baidu.tbadk.core.data.ao.eQA) {
            if (!aoVar.bpK()) {
                pbFirstFloorViewHolder.lMb.getLayoutStrategy().tH(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pbFirstFloorViewHolder.lMi.a(aoVar);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.duO() == null) {
            pbFirstFloorViewHolder.lLn.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.duO(), pbFirstFloorViewHolder.lLn, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lMb.setTextViewOnTouchListener(this.lLU);
        pbFirstFloorViewHolder.lMb.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lJQ);
            tbRichTextView.getLayoutStrategy().tz(min);
            tbRichTextView.getLayoutStrategy().tA((int) (min * 1.618f));
        }
    }

    private void c(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lKK.setOnTouchListener(this.fyb);
        pbFirstFloorViewHolder.lKK.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lLF.dpD().lJa;
        pbFirstFloorViewHolder.lMb.setOnLongClickListener(this.mOnLongClickListener);
        pbFirstFloorViewHolder.lMb.setOnTouchListener(this.lLU);
        pbFirstFloorViewHolder.lMb.setCommonTextViewOnClickListener(this.bdp);
        pbFirstFloorViewHolder.lMb.setOnImageClickListener(this.fWO);
        pbFirstFloorViewHolder.lMb.setOnImageTouchListener(this.lLU);
        pbFirstFloorViewHolder.lMb.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        pbFirstFloorViewHolder.lMb.setOnEmotionClickListener(aVar.lZA);
        pbFirstFloorViewHolder.lLn.setOnClickListener(this.bdp);
        pbFirstFloorViewHolder.lMl.setAfterItemClickListener(this.bdp);
        pbFirstFloorViewHolder.lMm.setAfterItemClickListener(this.bdp);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lJI = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lJQ = i;
    }

    public void uz(boolean z) {
        this.lJJ = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJS = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fyb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.lKB = cVar;
    }

    public void uM(boolean z) {
        this.lLQ = z;
    }

    public void release() {
        if (this.Wu != 0) {
            ((PbFirstFloorViewHolder) this.Wu).lMi.destroy();
            ((PbFirstFloorViewHolder) this.Wu).lMm.destroy();
        }
    }

    public void resume() {
        if (this.Wu != 0) {
            ((PbFirstFloorViewHolder) this.Wu).lMi.resume();
        }
    }

    public void pause() {
        if (this.Wu != 0) {
            ((PbFirstFloorViewHolder) this.Wu).lMi.pause();
        }
    }

    public PbFirstFloorViewHolder doD() {
        return (PbFirstFloorViewHolder) this.Wu;
    }

    private boolean aK(bz bzVar) {
        return (bzVar == null || bzVar.btz() == null || bzVar.btz().getOptions() == null || bzVar.btz().getOptions().size() <= 0) ? false : true;
    }
}
