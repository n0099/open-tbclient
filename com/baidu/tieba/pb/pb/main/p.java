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
    protected com.baidu.tieba.pb.data.f lJH;
    protected boolean lJI;
    protected int lJP;
    private View.OnClickListener lJR;
    private TbRichTextView.c lKA;
    private com.baidu.tieba.pb.pb.sub.b lKB;
    private boolean lLP;
    private boolean lLQ;
    private final boolean lLR;
    private boolean lLS;
    private com.baidu.tieba.pb.a.c lLT;
    private com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> lLU;
    private a.InterfaceC0089a lLV;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lJP = 0;
        this.lJI = true;
        this.lLP = true;
        this.lJH = null;
        this.lKB = null;
        this.lJR = null;
        this.bdp = null;
        this.fWO = null;
        this.fyb = null;
        this.mOnLongClickListener = null;
        this.lKA = null;
        this.lLQ = false;
        this.lLR = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lLS = false;
        this.pageFromType = 0;
        this.lLT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
        this.lLU = new com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.boP() != null && aVar.boP().eVB != null && p.this.lJH != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.boP().eVB;
                    String threadId = p.this.lJH.getThreadId();
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
        this.lLV = new a.InterfaceC0089a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.boP() != null && aVar.boP().eVB != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.boP().eVB;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dnW() != null) {
            this.pageFromType = pbFragment.dnW().dqI();
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbFirstFloorViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbFirstFloorViewHolder.eXI, R.color.CAM_X0204);
                pbFirstFloorViewHolder.lMa.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
                pbFirstFloorViewHolder.ani.onChangeSkinType();
                if (pbFirstFloorViewHolder.lMk != null) {
                    pbFirstFloorViewHolder.lMk.onChangeSkinType();
                }
                if (pbFirstFloorViewHolder.lMl != null) {
                    pbFirstFloorViewHolder.lMl.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbFirstFloorViewHolder.lMf, R.color.CAM_X0107);
                pbFirstFloorViewHolder.lMm.vU(skinType);
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
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.lIN.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lJI, this.lJP);
        a(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.lMh.GT(this.pageFromType);
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
            postData2.bsF();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lIN.getUniqueId(), this.lJH, postData2, postData2.locate, 1);
            b(pbFirstFloorViewHolder, postData2, view, i);
        }
        if (!this.lLQ && this.lLR && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.lMa.bLO() && (listView = this.lIN.getListView()) != null) {
            this.lLQ = true;
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
        if (this.lJH != null) {
            if (postData.dPe() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pbFirstFloorViewHolder.lMa.setOnClickListener(this.bdp);
                    pbFirstFloorViewHolder.lMa.setTextViewOnClickListener(this.bdp);
                } else {
                    pbFirstFloorViewHolder.lMa.setOnClickListener(null);
                    pbFirstFloorViewHolder.lMa.setTextViewOnClickListener(null);
                }
                pbFirstFloorViewHolder.lKJ.setOnClickListener(this.bdp);
            } else {
                pbFirstFloorViewHolder.lKJ.setOnClickListener(null);
            }
            if (postData.dPe() == 1) {
                pbFirstFloorViewHolder.a(this.lJH, this.lIN.dnO(), postData.nse);
                a(pbFirstFloorViewHolder.lMa, view, this.lLS);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.brr() != null) {
                    j = postData.brr().getUserIdLong();
                    str = postData.brr().getUserName();
                    str2 = postData.brr().getName_show();
                }
                if (this.lJH != null && this.lJH.dmF() != null) {
                    pbFirstFloorViewHolder.lMh.a(postData.dPm(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lJH.dmF().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lIN.doP().dsX()) {
                    pbFirstFloorViewHolder.lMa.setVisibility(8);
                }
                if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().brC() != null) {
                    cl brC = this.lJH.dmF().brC();
                    String btR = brC.btR();
                    if (!StringUtils.isNull(brC.btS())) {
                        if (!StringUtils.isNull(btR)) {
                            pbFirstFloorViewHolder.lMc.setVisibility(0);
                            pbFirstFloorViewHolder.lMc.startLoad(btR, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pbFirstFloorViewHolder.lMc.setVisibility(8);
                }
                if (pbFirstFloorViewHolder.lMd != null) {
                    pbFirstFloorViewHolder.lMd.setVisibility(8);
                }
                if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().bpW() && pbFirstFloorViewHolder.lMk != null) {
                    pbFirstFloorViewHolder.lMk.setPadding(pbFirstFloorViewHolder.lMk.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.lMk.getPaddingRight(), pbFirstFloorViewHolder.lMk.getPaddingBottom());
                }
            }
            pbFirstFloorViewHolder.lMa.getLayoutStrategy().ty(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPe()));
            if (postData.dPi() > 0 && postData.dPb() != null && postData.dPb().size() > 0) {
                if (this.lKB == null) {
                    this.lKB = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lKB.setIsFromCDN(this.mIsFromCDN);
                    this.lKB.Y(this.lJR);
                    if (this.lJH != null) {
                        this.lKB.ad(this.lJH.dmU(), TextUtils.equals(this.lJH.dmF().brr().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lKB.setThreadData(this.lJH.dmF());
                    }
                }
                this.lKB.Qn(postData.getId());
            }
            pbFirstFloorViewHolder.lMa.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            if (this.lJI) {
                pbFirstFloorViewHolder.lMa.getLayoutStrategy().tB(R.drawable.transparent_bg);
            } else {
                pbFirstFloorViewHolder.lMa.getLayoutStrategy().tB(R.drawable.icon_click);
            }
            pbFirstFloorViewHolder.lMa.setIsFromCDN(this.mIsFromCDN);
            if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().isLinkThread()) {
                a(pbFirstFloorViewHolder, this.lJH.dmF().bsY());
            }
            boolean z4 = false;
            if (this.lJH != null && this.lJH.dmF() != null) {
                z4 = this.lJH.dmF().isShareThread && postData.dPp() != null;
            }
            if (z4) {
                if (postData.dPp().item != null) {
                    pbFirstFloorViewHolder.lMa.getLayoutStrategy().tH(getDimens(R.dimen.tbds24));
                } else {
                    pbFirstFloorViewHolder.lMa.getLayoutStrategy().tH(getDimens(R.dimen.tbds14));
                }
                a(pbFirstFloorViewHolder, postData);
            } else {
                pbFirstFloorViewHolder.lMa.getLayoutStrategy().tH(getDimens(R.dimen.tbds24));
            }
            TbRichText dPg = postData.dPg();
            if (this.lJH != null && this.lJH.dnf()) {
                dPg = null;
            }
            if (this.lJH.dmF() != null) {
                pbFirstFloorViewHolder.lMa.setIsUseGridImage(this.lJH.dmF().btp());
                pbFirstFloorViewHolder.lMa.setmIsGridImageSupportLongPress(true);
            }
            if (this.lJH != null && 3 == this.lJH.dnl()) {
                if (this.lLQ || !this.lLR) {
                    pbFirstFloorViewHolder.lMa.setText(dPg, false, this.lKA, true, false);
                } else {
                    pbFirstFloorViewHolder.lMa.setText(dPg, true, this.lKA, true, false);
                }
            } else if (this.lLQ || !this.lLR) {
                pbFirstFloorViewHolder.lMa.setText(dPg, false, this.lKA, false, true);
            } else {
                pbFirstFloorViewHolder.lMa.setText(dPg, true, this.lKA, false, true);
            }
            a(pbFirstFloorViewHolder, postData, dPg);
            boolean z5 = !StringUtils.isNull(postData.brr().getVirtualUserUrl());
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            if (this.lJH != null && this.lJH.dmU() != 0) {
                if (this.lJH.dmU() != 3) {
                    z6 = true;
                    z7 = true;
                }
                if (postData.brr() != null) {
                    String userId = postData.brr().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z6 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z6 = false;
                    }
                }
            }
            if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().brr() != null && postData.brr() != null) {
                String userId2 = this.lJH.dmF().brr().getUserId();
                String userId3 = postData.brr().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z8 = true;
                    } else {
                        z8 = false;
                        z9 = true;
                    }
                    if (postData.brr() == null && UtilHelper.isCurrentAccount(postData.brr().getUserId())) {
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
                    if (postData.dPe() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.brr() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.brr().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.brr().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.brr().getPortrait());
                        }
                        if (this.lJH != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJH.dmU()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z8) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.brr() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brr().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.brr().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brr().getName_show());
                        }
                        if (this.lJH != null && this.lJH.dmF() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lJH.dmF().getId());
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
                        if (this.lJH != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJH.dmU()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(pbFirstFloorViewHolder);
                }
            }
            z = z7;
            if (postData.brr() == null) {
            }
            z2 = z;
            if (z5) {
            }
            int i22 = 1;
            if (postData.dPe() == 1) {
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
            pbFirstFloorViewHolder.lMa.setTag(sparseArray);
            pbFirstFloorViewHolder.lKJ.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbFirstFloorViewHolder.lMa.setIsHost(true);
            if (this.lLP) {
                pbFirstFloorViewHolder.eXI.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.eXI.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lJI) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lMa.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.lMa.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.lMa.EV(null);
                this.lLS = false;
                a(pbFirstFloorViewHolder, postData, view, i);
            } else {
                this.lLS = true;
                pbFirstFloorViewHolder.lMa.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bLU() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lMa.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pbFirstFloorViewHolder.lMa.setLayoutParams(layoutParams2);
                        p.this.a(pbFirstFloorViewHolder, postData, view, i);
                    }
                });
            }
            if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().bpW() && this.lJH.dmF().brI() != null && com.baidu.tbadk.core.util.at.isEmpty(this.lJH.getForum().getName())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dPg() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dPg().bKX())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dPg() != null) {
                if (postData.dPg().aET() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.ani.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pbFirstFloorViewHolder.ani.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.ani.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pbFirstFloorViewHolder.ani.setLayoutParams(layoutParams3);
                }
            }
            if (this.lJH != null && aK(this.lJH.dmF())) {
                pbFirstFloorViewHolder.akk.setDataForPb(this.lJH.dmF().btA(), this.lJH.dmF().getTid(), this.lJH.getForumId());
                if (postData.dPg() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dPg().bKX())) {
                    pbFirstFloorViewHolder.akk.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    pbFirstFloorViewHolder.akk.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                pbFirstFloorViewHolder.akk.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.akk.setVisibility(8);
            }
            if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().bsg() != null && this.lJH.dmF().brI() == null) {
                pbFirstFloorViewHolder.ani.setData(this.lJH.dmF().bsg());
                pbFirstFloorViewHolder.ani.setVisibility(0);
                if (this.lJH != null && this.lJH.getForum() != null) {
                    pbFirstFloorViewHolder.ani.setForumId(String.valueOf(this.lJH.getForum().getId()));
                }
                if (this.lJH != null && this.lJH.getThreadId() != null) {
                    pbFirstFloorViewHolder.ani.setThreadId(this.lJH.getThreadId());
                }
                AppletsCellView appletsCellView = pbFirstFloorViewHolder.ani;
                AppletsCellView appletsCellView2 = pbFirstFloorViewHolder.ani;
                appletsCellView.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.ani.setVisibility(8);
            }
            doD();
            if (this.lJH != null && this.lJH.lFS != null) {
                if (pbFirstFloorViewHolder.lMf != null) {
                    if (TextUtils.isEmpty(this.lJH.lFS.dnw())) {
                        pbFirstFloorViewHolder.lMf.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.lMf.setVisibility(0);
                        pbFirstFloorViewHolder.lMf.setText(this.lJH.lFS.dnw());
                    }
                }
                if (pbFirstFloorViewHolder.lMe != null && pbFirstFloorViewHolder.lMm.getRootView() == null) {
                    pbFirstFloorViewHolder.lMe.addView(pbFirstFloorViewHolder.lMm.K(this.lJH));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lIN.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 1).bwo();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 3).bwo();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 2).bwo();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 4).bwo();
                        }
                    }
                }
            }
            if (pbFirstFloorViewHolder.lMg != null) {
                pbFirstFloorViewHolder.lMg.removeAllViews();
            }
            if (this.lJH != null && this.lJH.dmF() != null && !aK(this.lJH.dmF()) && (!com.baidu.tbadk.core.util.x.isEmpty(this.lJH.dmF().btB()) || !com.baidu.tbadk.core.util.x.isEmpty(this.lJH.dmF().btC()))) {
                com.baidu.tbadk.util.ae aeVar = new com.baidu.tbadk.util.ae();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lJH, aeVar.p(this.lJH.dmF().btB(), this.lJH.dmF().btC()), this.lJH.getForumName(), this.lIN, aeVar.bJk());
                pbFirstFloorViewHolder.lMg.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.lMg.setVisibility(0);
                return;
            }
            pbFirstFloorViewHolder.lMg.setVisibility(8);
        }
    }

    public void doD() {
        PbFirstFloorViewHolder doE = doE();
        if (this.lJH != null && this.lJH.dmF() != null && doE != null) {
            doE.b(this.lJH, this.lJH.dmF().brn() == 1, this.lJH.dmF().brm() == 1);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View view;
        if (pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.lMi.setVisibility(0);
            if (pbFirstFloorViewHolder.lMj == null) {
                pbFirstFloorViewHolder.lMj = m(postData);
            }
            if (pbFirstFloorViewHolder.lMi.getChildCount() <= 0 && (view = pbFirstFloorViewHolder.lMj.getView()) != null) {
                pbFirstFloorViewHolder.lMi.addView(view);
            }
            pbFirstFloorViewHolder.lMj.a(this.lLU);
            pbFirstFloorViewHolder.lMj.a(this.lLV);
            pbFirstFloorViewHolder.lMj.g(postData.dPp());
            pbFirstFloorViewHolder.lMj.onChangeSkinType(this.lIN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dPp() != null && postData.dPp().bpT()) {
            BaijiahaoData baijiahaoData = postData.dPp().oriUgcInfo;
            Item item = postData.dPp().item;
            if (postData.dPp().ePW) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lIN.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dPp().showType == 0 || postData.dPp().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lIN.getPageContext()) : postData.dPp().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lIN.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lIN.getPageContext());
            } else if (baijiahaoData != null && postData.dPp().bqa()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lIN.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lIN.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lIN.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lIN.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lIN.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dPp().showType == 0 || postData.dPp().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lIN.getPageContext(), this.pageFromType);
            } else if (postData.dPp().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lIN.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lIN.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.at.isEmpty(aoVar.getLinkUrl()) && aoVar.bpK() == com.baidu.tbadk.core.data.ao.eQA) {
            if (!aoVar.bpL()) {
                pbFirstFloorViewHolder.lMa.getLayoutStrategy().tH(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pbFirstFloorViewHolder.lMh.a(aoVar);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.duP() == null) {
            pbFirstFloorViewHolder.lLm.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.duP(), pbFirstFloorViewHolder.lLm, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lMa.setTextViewOnTouchListener(this.lLT);
        pbFirstFloorViewHolder.lMa.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lJP);
            tbRichTextView.getLayoutStrategy().tz(min);
            tbRichTextView.getLayoutStrategy().tA((int) (min * 1.618f));
        }
    }

    private void c(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lKJ.setOnTouchListener(this.fyb);
        pbFirstFloorViewHolder.lKJ.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lLE.dpE().lIZ;
        pbFirstFloorViewHolder.lMa.setOnLongClickListener(this.mOnLongClickListener);
        pbFirstFloorViewHolder.lMa.setOnTouchListener(this.lLT);
        pbFirstFloorViewHolder.lMa.setCommonTextViewOnClickListener(this.bdp);
        pbFirstFloorViewHolder.lMa.setOnImageClickListener(this.fWO);
        pbFirstFloorViewHolder.lMa.setOnImageTouchListener(this.lLT);
        pbFirstFloorViewHolder.lMa.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        pbFirstFloorViewHolder.lMa.setOnEmotionClickListener(aVar.lZz);
        pbFirstFloorViewHolder.lLm.setOnClickListener(this.bdp);
        pbFirstFloorViewHolder.lMk.setAfterItemClickListener(this.bdp);
        pbFirstFloorViewHolder.lMl.setAfterItemClickListener(this.bdp);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lJH = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lJP = i;
    }

    public void uz(boolean z) {
        this.lJI = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJR = onClickListener;
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
        this.lKA = cVar;
    }

    public void uM(boolean z) {
        this.lLP = z;
    }

    public void release() {
        if (this.Wu != 0) {
            ((PbFirstFloorViewHolder) this.Wu).lMh.destroy();
            ((PbFirstFloorViewHolder) this.Wu).lMl.destroy();
        }
    }

    public void resume() {
        if (this.Wu != 0) {
            ((PbFirstFloorViewHolder) this.Wu).lMh.resume();
        }
    }

    public void pause() {
        if (this.Wu != 0) {
            ((PbFirstFloorViewHolder) this.Wu).lMh.pause();
        }
    }

    public PbFirstFloorViewHolder doE() {
        return (PbFirstFloorViewHolder) this.Wu;
    }

    private boolean aK(bz bzVar) {
        return (bzVar == null || bzVar.btA() == null || bzVar.btA().getOptions() == null || bzVar.btA().getOptions().size() <= 0) ? false : true;
    }
}
