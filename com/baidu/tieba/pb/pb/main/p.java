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
    private View.OnClickListener bbI;
    private TbRichTextView.i fUw;
    private com.baidu.tieba.pb.a.c fvK;
    protected com.baidu.tieba.pb.data.f lNT;
    protected boolean lNU;
    private TbRichTextView.c lOM;
    private com.baidu.tieba.pb.pb.sub.b lON;
    protected int lOb;
    private View.OnClickListener lOd;
    private boolean lQf;
    private boolean lQg;
    private final boolean lQh;
    private boolean lQi;
    private com.baidu.tieba.pb.a.c lQj;
    private com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> lQk;
    private a.InterfaceC0088a lQl;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lOb = 0;
        this.lNU = true;
        this.lQf = true;
        this.lNT = null;
        this.lON = null;
        this.lOd = null;
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lOM = null;
        this.lQg = false;
        this.lQh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lQi = false;
        this.pageFromType = 0;
        this.lQj = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
                if (p.this.fvK != null) {
                    p.this.fvK.ad(view);
                    p.this.fvK.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lQk = new com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.bln() != null && aVar.bln().eTc != null && p.this.lNT != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bln().eTc;
                    String threadId = p.this.lNT.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12602").dR("tid", threadId).dR("obj_source", str).ap("obj_type", i));
                    }
                }
            }
        };
        this.lQl = new a.InterfaceC0088a() { // from class: com.baidu.tieba.pb.pb.main.p.3
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.bln() != null && aVar.bln().eTc != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bln().eTc;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(p.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(p.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dmq() != null) {
            this.pageFromType = pbFragment.dmq().dpe();
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbFirstFloorViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbFirstFloorViewHolder.eVm, R.color.CAM_X0204);
                pbFirstFloorViewHolder.lQq.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                pbFirstFloorViewHolder.amh.onChangeSkinType();
                if (pbFirstFloorViewHolder.lQA != null) {
                    pbFirstFloorViewHolder.lQA.onChangeSkinType();
                }
                if (pbFirstFloorViewHolder.lQB != null) {
                    pbFirstFloorViewHolder.lQB.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbFirstFloorViewHolder.lQv, R.color.CAM_X0107);
                pbFirstFloorViewHolder.lQC.uu(skinType);
                if (pbFirstFloorViewHolder.aji != null) {
                    pbFirstFloorViewHolder.aji.onChangeSkinType(skinType);
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
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.lMX.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lNU, this.lOb);
        a(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.lQx.FG(this.pageFromType);
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
            postData2.bpd();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lMX.getUniqueId(), this.lNT, postData2, postData2.locate, 1);
            b(pbFirstFloorViewHolder, postData2, view, i);
        }
        if (!this.lQg && this.lQh && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.lQq.bIp() && (listView = this.lMX.getListView()) != null) {
            this.lQg = true;
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
        if (this.lNT != null) {
            if (postData.dNx() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pbFirstFloorViewHolder.lQq.setOnClickListener(this.bbI);
                    pbFirstFloorViewHolder.lQq.setTextViewOnClickListener(this.bbI);
                } else {
                    pbFirstFloorViewHolder.lQq.setOnClickListener(null);
                    pbFirstFloorViewHolder.lQq.setTextViewOnClickListener(null);
                }
                pbFirstFloorViewHolder.lOW.setOnClickListener(this.bbI);
            } else {
                pbFirstFloorViewHolder.lOW.setOnClickListener(null);
            }
            if (postData.dNx() == 1) {
                pbFirstFloorViewHolder.a(this.lNT, this.lMX.dmi(), postData.nxi);
                a(pbFirstFloorViewHolder.lQq, view, this.lQi);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnQ() != null) {
                    j = postData.bnQ().getUserIdLong();
                    str = postData.bnQ().getUserName();
                    str2 = postData.bnQ().getName_show();
                }
                if (this.lNT != null && this.lNT.dkZ() != null) {
                    pbFirstFloorViewHolder.lQx.a(postData.dNF(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lNT.dkZ().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lMX.dnk().drt()) {
                    pbFirstFloorViewHolder.lQq.setVisibility(8);
                }
                if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().bob() != null) {
                    cn bob = this.lNT.dkZ().bob();
                    String bqp = bob.bqp();
                    if (!StringUtils.isNull(bob.bqq())) {
                        if (!StringUtils.isNull(bqp)) {
                            pbFirstFloorViewHolder.lQs.setVisibility(0);
                            pbFirstFloorViewHolder.lQs.startLoad(bqp, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pbFirstFloorViewHolder.lQs.setVisibility(8);
                }
                if (pbFirstFloorViewHolder.lQt != null) {
                    pbFirstFloorViewHolder.lQt.setVisibility(8);
                }
                if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().bmv() && pbFirstFloorViewHolder.lQA != null) {
                    pbFirstFloorViewHolder.lQA.setPadding(pbFirstFloorViewHolder.lQA.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.lQA.getPaddingRight(), pbFirstFloorViewHolder.lQA.getPaddingBottom());
                }
            }
            pbFirstFloorViewHolder.lQq.getLayoutStrategy().rX(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNx()));
            if (postData.dNB() > 0 && postData.dNu() != null && postData.dNu().size() > 0) {
                if (this.lON == null) {
                    this.lON = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lON.setIsFromCDN(this.mIsFromCDN);
                    this.lON.Y(this.lOd);
                    if (this.lNT != null) {
                        this.lON.ad(this.lNT.dlo(), TextUtils.equals(this.lNT.dkZ().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lON.setThreadData(this.lNT.dkZ());
                    }
                }
                this.lON.PX(postData.getId());
            }
            pbFirstFloorViewHolder.lQq.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            if (this.lNU) {
                pbFirstFloorViewHolder.lQq.getLayoutStrategy().sa(R.drawable.transparent_bg);
            } else {
                pbFirstFloorViewHolder.lQq.getLayoutStrategy().sa(R.drawable.icon_click);
            }
            pbFirstFloorViewHolder.lQq.setIsFromCDN(this.mIsFromCDN);
            if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().isLinkThread()) {
                a(pbFirstFloorViewHolder, this.lNT.dkZ().bpw());
            }
            boolean z4 = false;
            if (this.lNT != null && this.lNT.dkZ() != null) {
                z4 = this.lNT.dkZ().isShareThread && postData.dNI() != null;
            }
            if (z4) {
                if (postData.dNI().item != null) {
                    pbFirstFloorViewHolder.lQq.getLayoutStrategy().sg(getDimens(R.dimen.tbds24));
                } else {
                    pbFirstFloorViewHolder.lQq.getLayoutStrategy().sg(getDimens(R.dimen.tbds14));
                }
                a(pbFirstFloorViewHolder, postData);
            } else {
                pbFirstFloorViewHolder.lQq.getLayoutStrategy().sg(getDimens(R.dimen.tbds24));
            }
            TbRichText dNz = postData.dNz();
            if (this.lNT != null && this.lNT.dlz()) {
                dNz = null;
            }
            if (this.lNT.dkZ() != null) {
                pbFirstFloorViewHolder.lQq.setIsUseGridImage(this.lNT.dkZ().bpN());
                pbFirstFloorViewHolder.lQq.setmIsGridImageSupportLongPress(true);
            }
            if (this.lNT != null && 3 == this.lNT.dlF()) {
                if (this.lQg || !this.lQh) {
                    pbFirstFloorViewHolder.lQq.setText(dNz, false, this.lOM, true, false);
                } else {
                    pbFirstFloorViewHolder.lQq.setText(dNz, true, this.lOM, true, false);
                }
            } else if (this.lQg || !this.lQh) {
                pbFirstFloorViewHolder.lQq.setText(dNz, false, this.lOM, false, true);
            } else {
                pbFirstFloorViewHolder.lQq.setText(dNz, true, this.lOM, false, true);
            }
            a(pbFirstFloorViewHolder, postData, dNz);
            boolean z5 = !StringUtils.isNull(postData.bnQ().getVirtualUserUrl());
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            if (this.lNT != null && this.lNT.dlo() != 0) {
                if (this.lNT.dlo() != 3) {
                    z6 = true;
                    z7 = true;
                }
                if (postData.bnQ() != null) {
                    String userId = postData.bnQ().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z6 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z6 = false;
                    }
                }
            }
            if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().bnQ() != null && postData.bnQ() != null) {
                String userId2 = this.lNT.dkZ().bnQ().getUserId();
                String userId3 = postData.bnQ().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z8 = true;
                    } else {
                        z8 = false;
                        z9 = true;
                    }
                    if (postData.bnQ() == null && UtilHelper.isCurrentAccount(postData.bnQ().getUserId())) {
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
                    if (postData.dNx() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.bnQ() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnQ().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnQ().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnQ().getPortrait());
                        }
                        if (this.lNT != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lNT.dlo()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z8) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bnQ() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnQ().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnQ().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnQ().getName_show());
                        }
                        if (this.lNT != null && this.lNT.dkZ() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lNT.dkZ().getId());
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
                        if (this.lNT != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lNT.dlo()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(pbFirstFloorViewHolder);
                }
            }
            z = z7;
            if (postData.bnQ() == null) {
            }
            z2 = z;
            if (z5) {
            }
            int i22 = 1;
            if (postData.dNx() == 1) {
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
            pbFirstFloorViewHolder.lQq.setTag(sparseArray);
            pbFirstFloorViewHolder.lOW.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbFirstFloorViewHolder.lQq.setIsHost(true);
            if (this.lQf) {
                pbFirstFloorViewHolder.eVm.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.eVm.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lNU) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lQq.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.lQq.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.lQq.Eh(null);
                this.lQi = false;
                a(pbFirstFloorViewHolder, postData, view, i);
            } else {
                this.lQi = true;
                pbFirstFloorViewHolder.lQq.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bIv() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lQq.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pbFirstFloorViewHolder.lQq.setLayoutParams(layoutParams2);
                        p.this.a(pbFirstFloorViewHolder, postData, view, i);
                    }
                });
            }
            if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().bmv() && this.lNT.dkZ().boh() != null && com.baidu.tbadk.core.util.au.isEmpty(this.lNT.getForum().getName())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dNz() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dNz().bHz())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dNz() != null) {
                if (postData.dNz().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.amh.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pbFirstFloorViewHolder.amh.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.amh.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pbFirstFloorViewHolder.amh.setLayoutParams(layoutParams3);
                }
            }
            if (this.lNT != null && aL(this.lNT.dkZ())) {
                pbFirstFloorViewHolder.aji.setDataForPb(this.lNT.dkZ().bpY(), this.lNT.dkZ().getTid(), this.lNT.getForumId());
                if (postData.dNz() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dNz().bHz())) {
                    pbFirstFloorViewHolder.aji.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    pbFirstFloorViewHolder.aji.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                pbFirstFloorViewHolder.aji.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.aji.setVisibility(8);
            }
            if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().boE() != null && this.lNT.dkZ().boh() == null) {
                pbFirstFloorViewHolder.amh.setData(this.lNT.dkZ().boE());
                pbFirstFloorViewHolder.amh.setVisibility(0);
                if (this.lNT != null && this.lNT.getForum() != null) {
                    pbFirstFloorViewHolder.amh.setForumId(String.valueOf(this.lNT.getForum().getId()));
                }
                if (this.lNT != null && this.lNT.getThreadId() != null) {
                    pbFirstFloorViewHolder.amh.setThreadId(this.lNT.getThreadId());
                }
                AppletsCellView appletsCellView = pbFirstFloorViewHolder.amh;
                AppletsCellView appletsCellView2 = pbFirstFloorViewHolder.amh;
                appletsCellView.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.amh.setVisibility(8);
            }
            dmY();
            if (this.lNT != null && this.lNT.lKa != null) {
                if (pbFirstFloorViewHolder.lQv != null) {
                    if (TextUtils.isEmpty(this.lNT.lKa.dlP())) {
                        pbFirstFloorViewHolder.lQv.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.lQv.setVisibility(0);
                        pbFirstFloorViewHolder.lQv.setText(this.lNT.lKa.dlP());
                    }
                }
                if (pbFirstFloorViewHolder.lQu != null && pbFirstFloorViewHolder.lQC.getRootView() == null) {
                    pbFirstFloorViewHolder.lQu.addView(pbFirstFloorViewHolder.lQC.K(this.lNT));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lMX.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.ar("c13445").ap("obj_source", 1).bsO();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.ar("c13445").ap("obj_source", 3).bsO();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.ar("c13445").ap("obj_source", 2).bsO();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.ar("c13445").ap("obj_source", 4).bsO();
                        }
                    }
                }
            }
            if (pbFirstFloorViewHolder.lQw != null) {
                pbFirstFloorViewHolder.lQw.removeAllViews();
            }
            if (this.lNT != null && this.lNT.dkZ() != null && !aL(this.lNT.dkZ()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lNT.dkZ().bpZ()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lNT.dkZ().bqa()))) {
                com.baidu.tbadk.util.ah ahVar = new com.baidu.tbadk.util.ah();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lNT, ahVar.o(this.lNT.dkZ().bpZ(), this.lNT.dkZ().bqa()), this.lNT.getForumName(), this.lMX, ahVar.bFM());
                pbFirstFloorViewHolder.lQw.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.lQw.setVisibility(0);
                return;
            }
            pbFirstFloorViewHolder.lQw.setVisibility(8);
        }
    }

    public void dmY() {
        PbFirstFloorViewHolder dmZ = dmZ();
        if (this.lNT != null && this.lNT.dkZ() != null && dmZ != null) {
            dmZ.b(this.lNT, this.lNT.dkZ().bnM() == 1, this.lNT.dkZ().bnL() == 1);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View view;
        if (pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.lQy.setVisibility(0);
            if (pbFirstFloorViewHolder.lQz == null) {
                pbFirstFloorViewHolder.lQz = m(postData);
            }
            if (pbFirstFloorViewHolder.lQy.getChildCount() <= 0 && (view = pbFirstFloorViewHolder.lQz.getView()) != null) {
                pbFirstFloorViewHolder.lQy.addView(view);
            }
            pbFirstFloorViewHolder.lQz.a(this.lQk);
            pbFirstFloorViewHolder.lQz.a(this.lQl);
            pbFirstFloorViewHolder.lQz.g(postData.dNI());
            pbFirstFloorViewHolder.lQz.onChangeSkinType(this.lMX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dNI() != null && postData.dNI().bms()) {
            BaijiahaoData baijiahaoData = postData.dNI().oriUgcInfo;
            Item item = postData.dNI().item;
            if (postData.dNI().eNx) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lMX.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dNI().showType == 0 || postData.dNI().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lMX.getPageContext()) : postData.dNI().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lMX.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lMX.getPageContext());
            } else if (baijiahaoData != null && postData.dNI().bmz()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lMX.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lMX.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lMX.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lMX.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lMX.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dNI().showType == 0 || postData.dNI().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lMX.getPageContext(), this.pageFromType);
            } else if (postData.dNI().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lMX.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lMX.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null && !com.baidu.tbadk.core.util.au.isEmpty(apVar.getLinkUrl()) && apVar.bmi() == com.baidu.tbadk.core.data.ap.eOa) {
            if (!apVar.bmj()) {
                pbFirstFloorViewHolder.lQq.getLayoutStrategy().sg(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pbFirstFloorViewHolder.lQx.a(apVar);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dtl() == null) {
            pbFirstFloorViewHolder.lPz.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dtl(), pbFirstFloorViewHolder.lPz, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lQq.setTextViewOnTouchListener(this.lQj);
        pbFirstFloorViewHolder.lQq.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lOb);
            tbRichTextView.getLayoutStrategy().rY(min);
            tbRichTextView.getLayoutStrategy().rZ((int) (min * 1.618f));
        }
    }

    private void c(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lOW.setOnTouchListener(this.fvK);
        pbFirstFloorViewHolder.lOW.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lPU.doa().lNj;
        pbFirstFloorViewHolder.lQq.setOnLongClickListener(this.mOnLongClickListener);
        pbFirstFloorViewHolder.lQq.setOnTouchListener(this.lQj);
        pbFirstFloorViewHolder.lQq.setCommonTextViewOnClickListener(this.bbI);
        pbFirstFloorViewHolder.lQq.setOnImageClickListener(this.fUw);
        pbFirstFloorViewHolder.lQq.setOnImageTouchListener(this.lQj);
        pbFirstFloorViewHolder.lQq.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        pbFirstFloorViewHolder.lQq.setOnEmotionClickListener(aVar.mdZ);
        pbFirstFloorViewHolder.lPz.setOnClickListener(this.bbI);
        pbFirstFloorViewHolder.lQA.setAfterItemClickListener(this.bbI);
        pbFirstFloorViewHolder.lQB.setAfterItemClickListener(this.bbI);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lNT = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lOb = i;
    }

    public void uJ(boolean z) {
        this.lNU = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOd = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fvK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.lOM = cVar;
    }

    public void uX(boolean z) {
        this.lQf = z;
    }

    public void release() {
        if (this.Wo != 0) {
            ((PbFirstFloorViewHolder) this.Wo).lQx.destroy();
            ((PbFirstFloorViewHolder) this.Wo).lQB.destroy();
        }
    }

    public void resume() {
        if (this.Wo != 0) {
            ((PbFirstFloorViewHolder) this.Wo).lQx.resume();
        }
    }

    public void pause() {
        if (this.Wo != 0) {
            ((PbFirstFloorViewHolder) this.Wo).lQx.pause();
        }
    }

    public PbFirstFloorViewHolder dmZ() {
        return (PbFirstFloorViewHolder) this.Wo;
    }

    private boolean aL(cb cbVar) {
        return (cbVar == null || cbVar.bpY() == null || cbVar.bpY().getOptions() == null || cbVar.bpY().getOptions().size() <= 0) ? false : true;
    }
}
