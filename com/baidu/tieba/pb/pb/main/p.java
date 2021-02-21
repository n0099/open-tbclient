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
    protected com.baidu.tieba.pb.data.f lOi;
    protected boolean lOj;
    protected int lOq;
    private View.OnClickListener lOs;
    private TbRichTextView.c lPb;
    private com.baidu.tieba.pb.pb.sub.b lPc;
    private a.InterfaceC0088a lQA;
    private boolean lQu;
    private boolean lQv;
    private final boolean lQw;
    private boolean lQx;
    private com.baidu.tieba.pb.a.c lQy;
    private com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> lQz;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lOq = 0;
        this.lOj = true;
        this.lQu = true;
        this.lOi = null;
        this.lPc = null;
        this.lOs = null;
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lPb = null;
        this.lQv = false;
        this.lQw = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lQx = false;
        this.pageFromType = 0;
        this.lQy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.p.1
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
        this.lQz = new com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.bln() != null && aVar.bln().eTc != null && p.this.lOi != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bln().eTc;
                    String threadId = p.this.lOi.getThreadId();
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
        this.lQA = new a.InterfaceC0088a() { // from class: com.baidu.tieba.pb.pb.main.p.3
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
        if (pbFragment != null && pbFragment.dmx() != null) {
            this.pageFromType = pbFragment.dmx().dpl();
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        if (pbFirstFloorViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbFirstFloorViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbFirstFloorViewHolder.eVm, R.color.CAM_X0204);
                pbFirstFloorViewHolder.lQF.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                pbFirstFloorViewHolder.amh.onChangeSkinType();
                if (pbFirstFloorViewHolder.lQP != null) {
                    pbFirstFloorViewHolder.lQP.onChangeSkinType();
                }
                if (pbFirstFloorViewHolder.lQQ != null) {
                    pbFirstFloorViewHolder.lQQ.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbFirstFloorViewHolder.lQK, R.color.CAM_X0107);
                pbFirstFloorViewHolder.lQR.uu(skinType);
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
        PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.lNm.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lOj, this.lOq);
        a(pbFirstFloorViewHolder);
        pbFirstFloorViewHolder.lQM.FG(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.lNm.getUniqueId(), this.lOi, postData2, postData2.locate, 1);
            b(pbFirstFloorViewHolder, postData2, view, i);
        }
        if (!this.lQv && this.lQw && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.lQF.bIp() && (listView = this.lNm.getListView()) != null) {
            this.lQv = true;
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
        if (this.lOi != null) {
            if (postData.dNF() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pbFirstFloorViewHolder.lQF.setOnClickListener(this.bbI);
                    pbFirstFloorViewHolder.lQF.setTextViewOnClickListener(this.bbI);
                } else {
                    pbFirstFloorViewHolder.lQF.setOnClickListener(null);
                    pbFirstFloorViewHolder.lQF.setTextViewOnClickListener(null);
                }
                pbFirstFloorViewHolder.lPl.setOnClickListener(this.bbI);
            } else {
                pbFirstFloorViewHolder.lPl.setOnClickListener(null);
            }
            if (postData.dNF() == 1) {
                pbFirstFloorViewHolder.a(this.lOi, this.lNm.dmp(), postData.nxI);
                a(pbFirstFloorViewHolder.lQF, view, this.lQx);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bnQ() != null) {
                    j = postData.bnQ().getUserIdLong();
                    str = postData.bnQ().getUserName();
                    str2 = postData.bnQ().getName_show();
                }
                if (this.lOi != null && this.lOi.dlg() != null) {
                    pbFirstFloorViewHolder.lQM.a(postData.dNN(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lOi.dlg().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lNm.dnr().drA()) {
                    pbFirstFloorViewHolder.lQF.setVisibility(8);
                }
                if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().bob() != null) {
                    cn bob = this.lOi.dlg().bob();
                    String bqp = bob.bqp();
                    if (!StringUtils.isNull(bob.bqq())) {
                        if (!StringUtils.isNull(bqp)) {
                            pbFirstFloorViewHolder.lQH.setVisibility(0);
                            pbFirstFloorViewHolder.lQH.startLoad(bqp, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pbFirstFloorViewHolder.lQH.setVisibility(8);
                }
                if (pbFirstFloorViewHolder.lQI != null) {
                    pbFirstFloorViewHolder.lQI.setVisibility(8);
                }
                if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().bmv() && pbFirstFloorViewHolder.lQP != null) {
                    pbFirstFloorViewHolder.lQP.setPadding(pbFirstFloorViewHolder.lQP.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.lQP.getPaddingRight(), pbFirstFloorViewHolder.lQP.getPaddingBottom());
                }
            }
            pbFirstFloorViewHolder.lQF.getLayoutStrategy().rX(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNF()));
            if (postData.dNJ() > 0 && postData.dNC() != null && postData.dNC().size() > 0) {
                if (this.lPc == null) {
                    this.lPc = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lPc.setIsFromCDN(this.mIsFromCDN);
                    this.lPc.Y(this.lOs);
                    if (this.lOi != null) {
                        this.lPc.ad(this.lOi.dlv(), TextUtils.equals(this.lOi.dlg().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lPc.setThreadData(this.lOi.dlg());
                    }
                }
                this.lPc.PY(postData.getId());
            }
            pbFirstFloorViewHolder.lQF.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            if (this.lOj) {
                pbFirstFloorViewHolder.lQF.getLayoutStrategy().sa(R.drawable.transparent_bg);
            } else {
                pbFirstFloorViewHolder.lQF.getLayoutStrategy().sa(R.drawable.icon_click);
            }
            pbFirstFloorViewHolder.lQF.setIsFromCDN(this.mIsFromCDN);
            if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().isLinkThread()) {
                a(pbFirstFloorViewHolder, this.lOi.dlg().bpw());
            }
            boolean z4 = false;
            if (this.lOi != null && this.lOi.dlg() != null) {
                z4 = this.lOi.dlg().isShareThread && postData.dNQ() != null;
            }
            if (z4) {
                if (postData.dNQ().item != null) {
                    pbFirstFloorViewHolder.lQF.getLayoutStrategy().sg(getDimens(R.dimen.tbds24));
                } else {
                    pbFirstFloorViewHolder.lQF.getLayoutStrategy().sg(getDimens(R.dimen.tbds14));
                }
                a(pbFirstFloorViewHolder, postData);
            } else {
                pbFirstFloorViewHolder.lQF.getLayoutStrategy().sg(getDimens(R.dimen.tbds24));
            }
            TbRichText dNH = postData.dNH();
            if (this.lOi != null && this.lOi.dlG()) {
                dNH = null;
            }
            if (this.lOi.dlg() != null) {
                pbFirstFloorViewHolder.lQF.setIsUseGridImage(this.lOi.dlg().bpN());
                pbFirstFloorViewHolder.lQF.setmIsGridImageSupportLongPress(true);
            }
            if (this.lOi != null && 3 == this.lOi.dlM()) {
                if (this.lQv || !this.lQw) {
                    pbFirstFloorViewHolder.lQF.setText(dNH, false, this.lPb, true, false);
                } else {
                    pbFirstFloorViewHolder.lQF.setText(dNH, true, this.lPb, true, false);
                }
            } else if (this.lQv || !this.lQw) {
                pbFirstFloorViewHolder.lQF.setText(dNH, false, this.lPb, false, true);
            } else {
                pbFirstFloorViewHolder.lQF.setText(dNH, true, this.lPb, false, true);
            }
            a(pbFirstFloorViewHolder, postData, dNH);
            boolean z5 = !StringUtils.isNull(postData.bnQ().getVirtualUserUrl());
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            if (this.lOi != null && this.lOi.dlv() != 0) {
                if (this.lOi.dlv() != 3) {
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
            if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().bnQ() != null && postData.bnQ() != null) {
                String userId2 = this.lOi.dlg().bnQ().getUserId();
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
                    if (postData.dNF() == 1) {
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
                        if (this.lOi != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lOi.dlv()));
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
                        if (this.lOi != null && this.lOi.dlg() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lOi.dlg().getId());
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
                        if (this.lOi != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lOi.dlv()));
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
            if (postData.dNF() == 1) {
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
            pbFirstFloorViewHolder.lQF.setTag(sparseArray);
            pbFirstFloorViewHolder.lPl.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbFirstFloorViewHolder.lQF.setIsHost(true);
            if (this.lQu) {
                pbFirstFloorViewHolder.eVm.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.eVm.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lOj) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lQF.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.lQF.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.lQF.Ef(null);
                this.lQx = false;
                a(pbFirstFloorViewHolder, postData, view, i);
            } else {
                this.lQx = true;
                pbFirstFloorViewHolder.lQF.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.p.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bIv() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.lQF.getLayoutParams();
                        layoutParams2.topMargin = p.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = p.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pbFirstFloorViewHolder.lQF.setLayoutParams(layoutParams2);
                        p.this.a(pbFirstFloorViewHolder, postData, view, i);
                    }
                });
            }
            if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().bmv() && this.lOi.dlg().boh() != null && com.baidu.tbadk.core.util.au.isEmpty(this.lOi.getForum().getName())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dNH() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dNH().bHz())) {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pbFirstFloorViewHolder.F(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dNH() != null) {
                if (postData.dNH().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.amh.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pbFirstFloorViewHolder.amh.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.amh.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pbFirstFloorViewHolder.amh.setLayoutParams(layoutParams3);
                }
            }
            if (this.lOi != null && aL(this.lOi.dlg())) {
                pbFirstFloorViewHolder.aji.setDataForPb(this.lOi.dlg().bpY(), this.lOi.dlg().getTid(), this.lOi.getForumId());
                if (postData.dNH() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dNH().bHz())) {
                    pbFirstFloorViewHolder.aji.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    pbFirstFloorViewHolder.aji.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                pbFirstFloorViewHolder.aji.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.aji.setVisibility(8);
            }
            if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().boE() != null && this.lOi.dlg().boh() == null) {
                pbFirstFloorViewHolder.amh.setData(this.lOi.dlg().boE());
                pbFirstFloorViewHolder.amh.setVisibility(0);
                if (this.lOi != null && this.lOi.getForum() != null) {
                    pbFirstFloorViewHolder.amh.setForumId(String.valueOf(this.lOi.getForum().getId()));
                }
                if (this.lOi != null && this.lOi.getThreadId() != null) {
                    pbFirstFloorViewHolder.amh.setThreadId(this.lOi.getThreadId());
                }
                AppletsCellView appletsCellView = pbFirstFloorViewHolder.amh;
                AppletsCellView appletsCellView2 = pbFirstFloorViewHolder.amh;
                appletsCellView.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.amh.setVisibility(8);
            }
            dnf();
            if (this.lOi != null && this.lOi.lKo != null) {
                if (pbFirstFloorViewHolder.lQK != null) {
                    if (TextUtils.isEmpty(this.lOi.lKo.dlW())) {
                        pbFirstFloorViewHolder.lQK.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.lQK.setVisibility(0);
                        pbFirstFloorViewHolder.lQK.setText(this.lOi.lKo.dlW());
                    }
                }
                if (pbFirstFloorViewHolder.lQJ != null && pbFirstFloorViewHolder.lQR.getRootView() == null) {
                    pbFirstFloorViewHolder.lQJ.addView(pbFirstFloorViewHolder.lQR.K(this.lOi));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lNm.getPageContext());
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
            if (pbFirstFloorViewHolder.lQL != null) {
                pbFirstFloorViewHolder.lQL.removeAllViews();
            }
            if (this.lOi != null && this.lOi.dlg() != null && !aL(this.lOi.dlg()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lOi.dlg().bpZ()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lOi.dlg().bqa()))) {
                com.baidu.tbadk.util.ah ahVar = new com.baidu.tbadk.util.ah();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lOi, ahVar.o(this.lOi.dlg().bpZ(), this.lOi.dlg().bqa()), this.lOi.getForumName(), this.lNm, ahVar.bFM());
                pbFirstFloorViewHolder.lQL.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.lQL.setVisibility(0);
                return;
            }
            pbFirstFloorViewHolder.lQL.setVisibility(8);
        }
    }

    public void dnf() {
        PbFirstFloorViewHolder dng = dng();
        if (this.lOi != null && this.lOi.dlg() != null && dng != null) {
            dng.b(this.lOi, this.lOi.dlg().bnM() == 1, this.lOi.dlg().bnL() == 1);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View view;
        if (pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.lQN.setVisibility(0);
            if (pbFirstFloorViewHolder.lQO == null) {
                pbFirstFloorViewHolder.lQO = m(postData);
            }
            if (pbFirstFloorViewHolder.lQN.getChildCount() <= 0 && (view = pbFirstFloorViewHolder.lQO.getView()) != null) {
                pbFirstFloorViewHolder.lQN.addView(view);
            }
            pbFirstFloorViewHolder.lQO.a(this.lQz);
            pbFirstFloorViewHolder.lQO.a(this.lQA);
            pbFirstFloorViewHolder.lQO.g(postData.dNQ());
            pbFirstFloorViewHolder.lQO.onChangeSkinType(this.lNm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dNQ() != null && postData.dNQ().bms()) {
            BaijiahaoData baijiahaoData = postData.dNQ().oriUgcInfo;
            Item item = postData.dNQ().item;
            if (postData.dNQ().eNx) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lNm.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dNQ().showType == 0 || postData.dNQ().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lNm.getPageContext()) : postData.dNQ().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lNm.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lNm.getPageContext());
            } else if (baijiahaoData != null && postData.dNQ().bmz()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lNm.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lNm.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lNm.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lNm.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lNm.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dNQ().showType == 0 || postData.dNQ().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lNm.getPageContext(), this.pageFromType);
            } else if (postData.dNQ().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lNm.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lNm.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null && !com.baidu.tbadk.core.util.au.isEmpty(apVar.getLinkUrl()) && apVar.bmi() == com.baidu.tbadk.core.data.ap.eOa) {
            if (!apVar.bmj()) {
                pbFirstFloorViewHolder.lQF.getLayoutStrategy().sg(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pbFirstFloorViewHolder.lQM.a(apVar);
        }
    }

    private void a(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dts() == null) {
            pbFirstFloorViewHolder.lPO.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dts(), pbFirstFloorViewHolder.lPO, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lQF.setTextViewOnTouchListener(this.lQy);
        pbFirstFloorViewHolder.lQF.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lOq);
            tbRichTextView.getLayoutStrategy().rY(min);
            tbRichTextView.getLayoutStrategy().rZ((int) (min * 1.618f));
        }
    }

    private void c(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        pbFirstFloorViewHolder.lPl.setOnTouchListener(this.fvK);
        pbFirstFloorViewHolder.lPl.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lQj.doh().lNy;
        pbFirstFloorViewHolder.lQF.setOnLongClickListener(this.mOnLongClickListener);
        pbFirstFloorViewHolder.lQF.setOnTouchListener(this.lQy);
        pbFirstFloorViewHolder.lQF.setCommonTextViewOnClickListener(this.bbI);
        pbFirstFloorViewHolder.lQF.setOnImageClickListener(this.fUw);
        pbFirstFloorViewHolder.lQF.setOnImageTouchListener(this.lQy);
        pbFirstFloorViewHolder.lQF.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        pbFirstFloorViewHolder.lQF.setOnEmotionClickListener(aVar.mep);
        pbFirstFloorViewHolder.lPO.setOnClickListener(this.bbI);
        pbFirstFloorViewHolder.lQP.setAfterItemClickListener(this.bbI);
        pbFirstFloorViewHolder.lQQ.setAfterItemClickListener(this.bbI);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lOi = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lOq = i;
    }

    public void uJ(boolean z) {
        this.lOj = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOs = onClickListener;
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
        this.lPb = cVar;
    }

    public void uX(boolean z) {
        this.lQu = z;
    }

    public void release() {
        if (this.Wo != 0) {
            ((PbFirstFloorViewHolder) this.Wo).lQM.destroy();
            ((PbFirstFloorViewHolder) this.Wo).lQQ.destroy();
        }
    }

    public void resume() {
        if (this.Wo != 0) {
            ((PbFirstFloorViewHolder) this.Wo).lQM.resume();
        }
    }

    public void pause() {
        if (this.Wo != 0) {
            ((PbFirstFloorViewHolder) this.Wo).lQM.pause();
        }
    }

    public PbFirstFloorViewHolder dng() {
        return (PbFirstFloorViewHolder) this.Wo;
    }

    private boolean aL(cb cbVar) {
        return (cbVar == null || cbVar.bpY() == null || cbVar.bpY().getOptions() == null || cbVar.bpY().getOptions().size() <= 0) ? false : true;
    }
}
