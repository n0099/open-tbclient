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
    private View.OnClickListener aYB;
    private TbRichTextView.i fSh;
    private com.baidu.tieba.pb.a.c ftt;
    private TbRichTextView.c lFW;
    private com.baidu.tieba.pb.pb.sub.b lFX;
    protected com.baidu.tieba.pb.data.f lFd;
    protected boolean lFe;
    protected int lFl;
    private View.OnClickListener lFn;
    private boolean lHl;
    private boolean lHm;
    private final boolean lHn;
    private boolean lHo;
    private com.baidu.tieba.pb.a.c lHp;
    private com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a> lHq;
    private a.InterfaceC0088a lHr;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lFl = 0;
        this.lFe = true;
        this.lHl = true;
        this.lFd = null;
        this.lFX = null;
        this.lFn = null;
        this.aYB = null;
        this.fSh = null;
        this.ftt = null;
        this.mOnLongClickListener = null;
        this.lFW = null;
        this.lHm = false;
        this.lHn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lHo = false;
        this.pageFromType = 0;
        this.lHp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.ftt != null) {
                    p.this.ftt.ad(view);
                    p.this.ftt.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lHq = new com.baidu.tieba.card.aa<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.bkV() != null && aVar.bkV().eQQ != null && p.this.lFd != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bkV().eQQ;
                    String threadId = p.this.lFd.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12602").dW("tid", threadId).dW("obj_source", str).an("obj_type", i));
                    }
                }
            }
        };
        this.lHr = new a.InterfaceC0088a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.bkV() != null && aVar.bkV().eQQ != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bkV().eQQ;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dkd() != null) {
            this.pageFromType = pbFragment.dkd().dmP();
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbFirstFloorViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbFirstFloorViewHolder.eSX, R.color.CAM_X0204);
                pbFirstFloorViewHolder.lHw.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
                pbFirstFloorViewHolder.amr.onChangeSkinType();
                if (pbFirstFloorViewHolder.lHG != null) {
                    pbFirstFloorViewHolder.lHG.onChangeSkinType();
                }
                if (pbFirstFloorViewHolder.lHH != null) {
                    pbFirstFloorViewHolder.lHH.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbFirstFloorViewHolder.lHB, R.color.CAM_X0107);
                pbFirstFloorViewHolder.lHI.uo(skinType);
                if (pbFirstFloorViewHolder.ajt != null) {
                    pbFirstFloorViewHolder.ajt.onChangeSkinType(skinType);
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
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.lEi.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lFe, this.lFl);
        a(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.lHD.Fn(this.pageFromType);
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
            postData2.boL();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lEi.getUniqueId(), this.lFd, postData2, postData2.locate, 1);
            b(pbFirstFloorViewHolder, postData2, view, i);
        }
        if (!this.lHm && this.lHn && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.lHw.bHW() && (listView = this.lEi.getListView()) != null) {
            this.lHm = true;
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
        if (this.lFd != null) {
            if (postData.dLm() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pbFirstFloorViewHolder.lHw.setOnClickListener(this.aYB);
                    pbFirstFloorViewHolder.lHw.setTextViewOnClickListener(this.aYB);
                } else {
                    pbFirstFloorViewHolder.lHw.setOnClickListener(null);
                    pbFirstFloorViewHolder.lHw.setTextViewOnClickListener(null);
                }
                pbFirstFloorViewHolder.lGf.setOnClickListener(this.aYB);
            } else {
                pbFirstFloorViewHolder.lGf.setOnClickListener(null);
            }
            if (postData.dLm() == 1) {
                pbFirstFloorViewHolder.a(this.lFd, this.lEi.djV(), postData.nny);
                a(pbFirstFloorViewHolder.lHw, view, this.lHo);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnx() != null) {
                    j = postData.bnx().getUserIdLong();
                    str = postData.bnx().getUserName();
                    str2 = postData.bnx().getName_show();
                }
                if (this.lFd != null && this.lFd.diN() != null) {
                    pbFirstFloorViewHolder.lHD.a(postData.dLu(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lFd.diN().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lEi.dkW().dpf()) {
                    pbFirstFloorViewHolder.lHw.setVisibility(8);
                }
                if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().bnI() != null) {
                    cl bnI = this.lFd.diN().bnI();
                    String bpX = bnI.bpX();
                    if (!StringUtils.isNull(bnI.bpY())) {
                        if (!StringUtils.isNull(bpX)) {
                            pbFirstFloorViewHolder.lHy.setVisibility(0);
                            pbFirstFloorViewHolder.lHy.startLoad(bpX, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pbFirstFloorViewHolder.lHy.setVisibility(8);
                }
                if (pbFirstFloorViewHolder.lHz != null) {
                    pbFirstFloorViewHolder.lHz.setVisibility(8);
                }
                if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().bmc() && pbFirstFloorViewHolder.lHG != null) {
                    pbFirstFloorViewHolder.lHG.setPadding(pbFirstFloorViewHolder.lHG.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.lHG.getPaddingRight(), pbFirstFloorViewHolder.lHG.getPaddingBottom());
                }
            }
            pbFirstFloorViewHolder.lHw.getLayoutStrategy().rS(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dLm()));
            if (postData.dLq() > 0 && postData.dLj() != null && postData.dLj().size() > 0) {
                if (this.lFX == null) {
                    this.lFX = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lFX.setIsFromCDN(this.mIsFromCDN);
                    this.lFX.Y(this.lFn);
                    if (this.lFd != null) {
                        this.lFX.ad(this.lFd.djc(), TextUtils.equals(this.lFd.diN().bnx().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lFX.setThreadData(this.lFd.diN());
                    }
                }
                this.lFX.Pg(postData.getId());
            }
            pbFirstFloorViewHolder.lHw.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            if (this.lFe) {
                pbFirstFloorViewHolder.lHw.getLayoutStrategy().rV(R.drawable.transparent_bg);
            } else {
                pbFirstFloorViewHolder.lHw.getLayoutStrategy().rV(R.drawable.icon_click);
            }
            pbFirstFloorViewHolder.lHw.setIsFromCDN(this.mIsFromCDN);
            if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().isLinkThread()) {
                a(pbFirstFloorViewHolder, this.lFd.diN().bpe());
            }
            boolean z4 = false;
            if (this.lFd != null && this.lFd.diN() != null) {
                z4 = this.lFd.diN().isShareThread && postData.dLx() != null;
            }
            if (z4) {
                if (postData.dLx().item != null) {
                    pbFirstFloorViewHolder.lHw.getLayoutStrategy().sb(getDimens(R.dimen.tbds24));
                } else {
                    pbFirstFloorViewHolder.lHw.getLayoutStrategy().sb(getDimens(R.dimen.tbds14));
                }
                a(pbFirstFloorViewHolder, postData);
            } else {
                pbFirstFloorViewHolder.lHw.getLayoutStrategy().sb(getDimens(R.dimen.tbds24));
            }
            TbRichText dLo = postData.dLo();
            if (this.lFd != null && this.lFd.djn()) {
                dLo = null;
            }
            if (this.lFd.diN() != null) {
                pbFirstFloorViewHolder.lHw.setIsUseGridImage(this.lFd.diN().bpv());
                pbFirstFloorViewHolder.lHw.setmIsGridImageSupportLongPress(true);
            }
            if (this.lFd != null && 3 == this.lFd.djt()) {
                if (this.lHm || !this.lHn) {
                    pbFirstFloorViewHolder.lHw.setText(dLo, false, this.lFW, true, false);
                } else {
                    pbFirstFloorViewHolder.lHw.setText(dLo, true, this.lFW, true, false);
                }
            } else if (this.lHm || !this.lHn) {
                pbFirstFloorViewHolder.lHw.setText(dLo, false, this.lFW, false, true);
            } else {
                pbFirstFloorViewHolder.lHw.setText(dLo, true, this.lFW, false, true);
            }
            a(pbFirstFloorViewHolder, postData, dLo);
            boolean z5 = !StringUtils.isNull(postData.bnx().getVirtualUserUrl());
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            if (this.lFd != null && this.lFd.djc() != 0) {
                if (this.lFd.djc() != 3) {
                    z6 = true;
                    z7 = true;
                }
                if (postData.bnx() != null) {
                    String userId = postData.bnx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z6 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z6 = false;
                    }
                }
            }
            if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().bnx() != null && postData.bnx() != null) {
                String userId2 = this.lFd.diN().bnx().getUserId();
                String userId3 = postData.bnx().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z8 = true;
                    } else {
                        z8 = false;
                        z9 = true;
                    }
                    if (postData.bnx() == null && UtilHelper.isCurrentAccount(postData.bnx().getUserId())) {
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
                    if (postData.dLm() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.bnx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnx().getPortrait());
                        }
                        if (this.lFd != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lFd.djc()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z8) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bnx() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnx().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnx().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnx().getName_show());
                        }
                        if (this.lFd != null && this.lFd.diN() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lFd.diN().getId());
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
                        if (this.lFd != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lFd.djc()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(pbFirstFloorViewHolder);
                }
            }
            z = z7;
            if (postData.bnx() == null) {
            }
            z2 = z;
            if (z5) {
            }
            int i22 = 1;
            if (postData.dLm() == 1) {
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
            pbFirstFloorViewHolder.lHw.setTag(sparseArray);
            pbFirstFloorViewHolder.lGf.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbFirstFloorViewHolder.lHw.setIsHost(true);
            if (this.lHl) {
                pbFirstFloorViewHolder.eSX.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.eSX.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lFe) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lHw.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.lHw.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.lHw.DK(null);
                this.lHo = false;
                a(pbFirstFloorViewHolder, postData, view, i);
            } else {
                this.lHo = true;
                pbFirstFloorViewHolder.lHw.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bIc() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lHw.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pbFirstFloorViewHolder.lHw.setLayoutParams(layoutParams2);
                        p.this.a(pbFirstFloorViewHolder, postData, view, i);
                    }
                });
            }
            if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().bmc() && this.lFd.diN().bnO() != null && com.baidu.tbadk.core.util.at.isEmpty(this.lFd.getForum().getName())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dLo() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dLo().bHf())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dLo() != null) {
                if (postData.dLo().aAZ() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.amr.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pbFirstFloorViewHolder.amr.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.amr.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pbFirstFloorViewHolder.amr.setLayoutParams(layoutParams3);
                }
            }
            if (this.lFd != null && aK(this.lFd.diN())) {
                pbFirstFloorViewHolder.ajt.setDataForPb(this.lFd.diN().bpG(), this.lFd.diN().getTid(), this.lFd.getForumId());
                if (postData.dLo() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dLo().bHf())) {
                    pbFirstFloorViewHolder.ajt.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    pbFirstFloorViewHolder.ajt.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                pbFirstFloorViewHolder.ajt.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.ajt.setVisibility(8);
            }
            if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().bom() != null && this.lFd.diN().bnO() == null) {
                pbFirstFloorViewHolder.amr.setData(this.lFd.diN().bom());
                pbFirstFloorViewHolder.amr.setVisibility(0);
                if (this.lFd != null && this.lFd.getForum() != null) {
                    pbFirstFloorViewHolder.amr.setForumId(String.valueOf(this.lFd.getForum().getId()));
                }
                if (this.lFd != null && this.lFd.getThreadId() != null) {
                    pbFirstFloorViewHolder.amr.setThreadId(this.lFd.getThreadId());
                }
                AppletsCellView appletsCellView = pbFirstFloorViewHolder.amr;
                AppletsCellView appletsCellView2 = pbFirstFloorViewHolder.amr;
                appletsCellView.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.amr.setVisibility(8);
            }
            dkK();
            if (this.lFd != null && this.lFd.lBn != null) {
                if (pbFirstFloorViewHolder.lHB != null) {
                    if (TextUtils.isEmpty(this.lFd.lBn.djD())) {
                        pbFirstFloorViewHolder.lHB.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.lHB.setVisibility(0);
                        pbFirstFloorViewHolder.lHB.setText(this.lFd.lBn.djD());
                    }
                }
                if (pbFirstFloorViewHolder.lHA != null && pbFirstFloorViewHolder.lHI.getRootView() == null) {
                    pbFirstFloorViewHolder.lHA.addView(pbFirstFloorViewHolder.lHI.K(this.lFd));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lEi.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 1).bsu();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 3).bsu();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 2).bsu();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").an("obj_source", 4).bsu();
                        }
                    }
                }
            }
            if (pbFirstFloorViewHolder.lHC != null) {
                pbFirstFloorViewHolder.lHC.removeAllViews();
            }
            if (this.lFd != null && this.lFd.diN() != null && !aK(this.lFd.diN()) && (!com.baidu.tbadk.core.util.x.isEmpty(this.lFd.diN().bpH()) || !com.baidu.tbadk.core.util.x.isEmpty(this.lFd.diN().bpI()))) {
                com.baidu.tbadk.util.ae aeVar = new com.baidu.tbadk.util.ae();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lFd, aeVar.p(this.lFd.diN().bpH(), this.lFd.diN().bpI()), this.lFd.getForumName(), this.lEi, aeVar.bFs());
                pbFirstFloorViewHolder.lHC.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.lHC.setVisibility(0);
                return;
            }
            pbFirstFloorViewHolder.lHC.setVisibility(8);
        }
    }

    public void dkK() {
        PbFirstFloorViewHolder dkL = dkL();
        if (this.lFd != null && this.lFd.diN() != null && dkL != null) {
            dkL.b(this.lFd, this.lFd.diN().bnt() == 1, this.lFd.diN().bns() == 1);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View view;
        if (pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.lHE.setVisibility(0);
            if (pbFirstFloorViewHolder.lHF == null) {
                pbFirstFloorViewHolder.lHF = m(postData);
            }
            if (pbFirstFloorViewHolder.lHE.getChildCount() <= 0 && (view = pbFirstFloorViewHolder.lHF.getView()) != null) {
                pbFirstFloorViewHolder.lHE.addView(view);
            }
            pbFirstFloorViewHolder.lHF.a(this.lHq);
            pbFirstFloorViewHolder.lHF.a(this.lHr);
            pbFirstFloorViewHolder.lHF.g(postData.dLx());
            pbFirstFloorViewHolder.lHF.onChangeSkinType(this.lEi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dLx() != null && postData.dLx().blZ()) {
            BaijiahaoData baijiahaoData = postData.dLx().oriUgcInfo;
            Item item = postData.dLx().item;
            if (postData.dLx().eLl) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lEi.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dLx().showType == 0 || postData.dLx().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lEi.getPageContext()) : postData.dLx().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lEi.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lEi.getPageContext());
            } else if (baijiahaoData != null && postData.dLx().bmg()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lEi.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lEi.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lEi.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lEi.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lEi.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dLx().showType == 0 || postData.dLx().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lEi.getPageContext(), this.pageFromType);
            } else if (postData.dLx().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lEi.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lEi.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.at.isEmpty(aoVar.getLinkUrl()) && aoVar.blQ() == com.baidu.tbadk.core.data.ao.eLP) {
            if (!aoVar.blR()) {
                pbFirstFloorViewHolder.lHw.getLayoutStrategy().sb(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pbFirstFloorViewHolder.lHD.a(aoVar);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dqX() == null) {
            pbFirstFloorViewHolder.lGI.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dqX(), pbFirstFloorViewHolder.lGI, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lHw.setTextViewOnTouchListener(this.lHp);
        pbFirstFloorViewHolder.lHw.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lFl);
            tbRichTextView.getLayoutStrategy().rT(min);
            tbRichTextView.getLayoutStrategy().rU((int) (min * 1.618f));
        }
    }

    private void c(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lGf.setOnTouchListener(this.ftt);
        pbFirstFloorViewHolder.lGf.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lHa.dlL().lEu;
        pbFirstFloorViewHolder.lHw.setOnLongClickListener(this.mOnLongClickListener);
        pbFirstFloorViewHolder.lHw.setOnTouchListener(this.lHp);
        pbFirstFloorViewHolder.lHw.setCommonTextViewOnClickListener(this.aYB);
        pbFirstFloorViewHolder.lHw.setOnImageClickListener(this.fSh);
        pbFirstFloorViewHolder.lHw.setOnImageTouchListener(this.lHp);
        pbFirstFloorViewHolder.lHw.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        pbFirstFloorViewHolder.lHw.setOnEmotionClickListener(aVar.lUV);
        pbFirstFloorViewHolder.lGI.setOnClickListener(this.aYB);
        pbFirstFloorViewHolder.lHG.setAfterItemClickListener(this.aYB);
        pbFirstFloorViewHolder.lHH.setAfterItemClickListener(this.aYB);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lFd = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lFl = i;
    }

    public void uv(boolean z) {
        this.lFe = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lFn = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ftt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.lFW = cVar;
    }

    public void uI(boolean z) {
        this.lHl = z;
    }

    public void release() {
        if (this.Ws != 0) {
            ((PbFirstFloorViewHolder) this.Ws).lHD.destroy();
            ((PbFirstFloorViewHolder) this.Ws).lHH.destroy();
        }
    }

    public void resume() {
        if (this.Ws != 0) {
            ((PbFirstFloorViewHolder) this.Ws).lHD.resume();
        }
    }

    public void pause() {
        if (this.Ws != 0) {
            ((PbFirstFloorViewHolder) this.Ws).lHD.pause();
        }
    }

    public PbFirstFloorViewHolder dkL() {
        return (PbFirstFloorViewHolder) this.Ws;
    }

    private boolean aK(bz bzVar) {
        return (bzVar == null || bzVar.bpG() == null || bzVar.bpG().getOptions() == null || bzVar.bpG().getOptions().size() <= 0) ? false : true;
    }
}
