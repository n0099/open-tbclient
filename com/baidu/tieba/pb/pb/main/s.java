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
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.ch;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public class s extends o<PostData, t> {
    private View.OnClickListener aMH;
    private TbRichTextView.i eRR;
    private com.baidu.tieba.pb.a.c euG;
    protected com.baidu.tieba.pb.data.f kkM;
    protected boolean kkN;
    protected int kkU;
    private View.OnClickListener kkW;
    private TbRichTextView.c klC;
    private com.baidu.tieba.pb.pb.sub.b klD;
    private boolean kmN;
    private boolean kmO;
    private final boolean kmP;
    private boolean kmQ;
    private com.baidu.tieba.pb.a.c kmR;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> kmS;
    private b.a kmT;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kkU = 0;
        this.kkN = true;
        this.kmN = true;
        this.kkM = null;
        this.klD = null;
        this.kkW = null;
        this.aMH = null;
        this.eRR = null;
        this.euG = null;
        this.mOnLongClickListener = null;
        this.klC = null;
        this.kmO = false;
        this.kmP = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.kmQ = false;
        this.pageFromType = 0;
        this.kmR = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.euG != null) {
                    s.this.euG.W(view);
                    s.this.euG.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.kmS = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null && s.this.kkM != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aTN().dUi;
                    String threadId = s.this.kkM.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12602").dn("tid", threadId).dn("obj_source", str).ah("obj_type", i));
                    }
                }
            }
        };
        this.kmT = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aTN().dUi;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.cLP() != null) {
            this.pageFromType = pbFragment.cLP().cOv();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(tVar.dWa, R.color.cp_bg_line_c);
                tVar.kmZ.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_b));
                tVar.ajq.onChangeSkinType();
                if (tVar.knj != null) {
                    tVar.knj.onChangeSkinType();
                }
                if (tVar.knk != null) {
                    tVar.knk.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(tVar.kne, R.color.cp_cont_j);
                tVar.knl.qZ(skinType);
                if (tVar.agF != null) {
                    tVar.agF.onChangeSkinType(skinType);
                }
            }
            tVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public t b(ViewGroup viewGroup) {
        t tVar = new t(this.kjZ.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.kkN, this.kkU);
        a(tVar);
        tVar.kng.BH(this.pageFromType);
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
            postData2.aXx();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kjZ.getUniqueId(), this.kkM, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.kmO && this.kmP && tVar != null && tVar.kmZ.bpC() && (listView = this.kjZ.getListView()) != null) {
            this.kmO = true;
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
        if (this.kkM != null) {
            if (postData.dlh() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.kmZ.setOnClickListener(this.aMH);
                    tVar.kmZ.setTextViewOnClickListener(this.aMH);
                } else {
                    tVar.kmZ.setOnClickListener(null);
                    tVar.kmZ.setTextViewOnClickListener(null);
                }
                tVar.klN.setOnClickListener(this.aMH);
            } else {
                tVar.klN.setOnClickListener(null);
            }
            if (postData.dlh() == 1) {
                tVar.a(this.kkM, this.kjZ.cLF(), postData.lNL);
                a(tVar.kmZ, view, this.kmQ);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aWl() != null) {
                    j = postData.aWl().getUserIdLong();
                    str = postData.aWl().getUserName();
                    str2 = postData.aWl().getName_show();
                }
                if (this.kkM != null && this.kkM.cKx() != null) {
                    tVar.kng.a(postData.dlp(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kkM.cKx().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.kjZ.cMF().cQF()) {
                    tVar.kmZ.setVisibility(8);
                }
                if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().aWw() != null) {
                    ch aWw = this.kkM.cKx().aWw();
                    String aYE = aWw.aYE();
                    if (!StringUtils.isNull(aWw.aYF())) {
                        if (!StringUtils.isNull(aYE)) {
                            tVar.knb.setVisibility(0);
                            tVar.knb.startLoad(aYE, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.knb.setVisibility(8);
                }
                if (tVar.knc != null) {
                    tVar.knc.setVisibility(8);
                }
                if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().aUR() && tVar.knj != null) {
                    tVar.knj.setPadding(tVar.knj.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.knj.getPaddingRight(), tVar.knj.getPaddingBottom());
                }
            }
            tVar.kmZ.getLayoutStrategy().oQ(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dlh()));
            if (postData.dll() > 0 && postData.dle() != null && postData.dle().size() > 0) {
                if (this.klD == null) {
                    this.klD = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.klD.setIsFromCDN(this.mIsFromCDN);
                    this.klD.V(this.kkW);
                    if (this.kkM != null) {
                        this.klD.aa(this.kkM.cKM(), TextUtils.equals(this.kkM.cKx().aWl().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.klD.setThreadData(this.kkM.cKx());
                    }
                }
                this.klD.Lf(postData.getId());
            }
            tVar.kmZ.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_link_tip_c));
            if (this.kkN) {
                tVar.kmZ.getLayoutStrategy().oT(R.drawable.transparent_bg);
            } else {
                tVar.kmZ.getLayoutStrategy().oT(R.drawable.icon_click);
            }
            tVar.kmZ.setIsFromCDN(this.mIsFromCDN);
            if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().isLinkThread()) {
                a(tVar, this.kkM.cKx().aXP());
            }
            boolean z7 = false;
            if (this.kkM != null && this.kkM.cKx() != null) {
                z7 = this.kkM.cKx().isShareThread && postData.dls() != null;
            }
            if (z7) {
                if (postData.dls().item != null) {
                    tVar.kmZ.getLayoutStrategy().oZ(bj(R.dimen.tbds24));
                } else {
                    tVar.kmZ.getLayoutStrategy().oZ(bj(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.kmZ.getLayoutStrategy().oZ(bj(R.dimen.tbds24));
            }
            TbRichText dlj = postData.dlj();
            if (this.kkM != null && this.kkM.cKX()) {
                dlj = null;
            }
            if (this.kkM.cKx() != null) {
                tVar.kmZ.setIsUseGridImage(this.kkM.cKx().aYg());
                tVar.kmZ.setmIsGridImageSupportLongPress(true);
            }
            if (this.kkM != null && 3 == this.kkM.cLd()) {
                if (this.kmO || !this.kmP) {
                    tVar.kmZ.setText(dlj, false, this.klC, true, false);
                } else {
                    tVar.kmZ.setText(dlj, true, this.klC, true, false);
                }
            } else if (this.kmO || !this.kmP) {
                tVar.kmZ.setText(dlj, false, this.klC, false, true);
            } else {
                tVar.kmZ.setText(dlj, true, this.klC, false, true);
            }
            a(tVar, postData, dlj);
            boolean z8 = !StringUtils.isNull(postData.aWl().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.kkM != null && this.kkM.cKM() != 0) {
                if (this.kkM.cKM() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aWl() != null) {
                    String userId = postData.aWl().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().aWl() != null && postData.aWl() != null) {
                String userId2 = this.kkM.cKx().aWl().getUserId();
                String userId3 = postData.aWl().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aWl() == null && UtilHelper.isCurrentAccount(postData.aWl().getUserId())) {
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
                    if (postData.dlh() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aWl() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aWl().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aWl().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aWl().getPortrait());
                        }
                        if (this.kkM != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kkM.cKM()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aWl() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aWl().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aWl().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aWl().getName_show());
                        }
                        if (this.kkM != null && this.kkM.cKx() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kkM.cKx().getId());
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
                        if (this.kkM != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kkM.cKM()));
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
            if (postData.aWl() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dlh() == 1) {
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
            tVar.kmZ.setTag(sparseArray);
            tVar.klN.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.kmZ.setIsHost(true);
            if (this.kmN) {
                tVar.dWa.setVisibility(0);
            } else {
                tVar.dWa.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kkN) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.kmZ.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.kmZ.setLayoutParams(layoutParams);
                tVar.kmZ.AF(null);
                this.kmQ = false;
                a(tVar, postData, view, i);
            } else {
                this.kmQ = true;
                tVar.kmZ.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bpI() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.kmZ.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.kmZ.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().aUR() && this.kkM.cKx().aWD() != null && com.baidu.tbadk.core.util.as.isEmpty(this.kkM.getForum().getName())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dlj() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dlj().boJ())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dlj() != null) {
                if (postData.dlj().alw() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.ajq.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.ajq.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.ajq.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.ajq.setLayoutParams(layoutParams3);
                }
            }
            if (this.kkM != null && aF(this.kkM.cKx())) {
                tVar.agF.setDataForPb(this.kkM.cKx().aYq(), this.kkM.cKx().getTid(), this.kkM.getForumId());
                if (postData.dlj() == null || com.baidu.tbadk.core.util.x.isEmpty(postData.dlj().boJ())) {
                    tVar.agF.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.agF.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.agF.setVisibility(0);
            } else {
                tVar.agF.setVisibility(8);
            }
            if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().aXa() != null && this.kkM.cKx().aWD() == null) {
                tVar.ajq.setData(this.kkM.cKx().aXa());
                tVar.ajq.setVisibility(0);
                if (this.kkM != null && this.kkM.getForum() != null) {
                    tVar.ajq.setForumId(String.valueOf(this.kkM.getForum().getId()));
                }
                if (this.kkM != null && this.kkM.getThreadId() != null) {
                    tVar.ajq.setThreadId(this.kkM.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.ajq;
                AppletsCellView appletsCellView2 = tVar.ajq;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.ajq.setVisibility(8);
            }
            if (this.kkM != null && this.kkM.cKx() != null && (this.kkM.cKx().aWz() != 0 || this.kkM.cKx().aUR())) {
                tVar.b(this.kkM, this.kkM.cKx().aWh() == 1, this.kkM.cKx().aWg() == 1);
            }
            if (this.kkM != null && this.kkM.kho != null) {
                if (tVar.kne != null) {
                    if (TextUtils.isEmpty(this.kkM.kho.cLl())) {
                        tVar.kne.setVisibility(8);
                    } else {
                        tVar.kne.setVisibility(0);
                        tVar.kne.setText(this.kkM.kho.cLl());
                    }
                }
                if (tVar.knd != null && tVar.knl.getRootView() == null) {
                    tVar.knd.addView(tVar.knl.H(this.kkM));
                    String fromPageKey = UtilHelper.getFromPageKey(this.kjZ.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.ap("c13445").ah("obj_source", 1).baO();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.ap("c13445").ah("obj_source", 3).baO();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.ap("c13445").ah("obj_source", 2).baO();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.ap("c13445").ah("obj_source", 4).baO();
                        }
                    }
                }
            }
            if (tVar.knf != null) {
                tVar.knf.removeAllViews();
            }
            if (this.kkM != null && this.kkM.cKx() != null && !aF(this.kkM.cKx()) && !com.baidu.tbadk.core.util.x.isEmpty(this.kkM.cKx().aYr())) {
                for (final PbLinkData pbLinkData : this.kkM.cKx().aYr()) {
                    SingleLinkCardView singleLinkCardView = new SingleLinkCardView(this.mContext);
                    singleLinkCardView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!TextUtils.isEmpty(pbLinkData.linkUrl) && (s.this.mContext instanceof TbPageContextSupport)) {
                                com.baidu.tbadk.core.util.bd.baV().b(((TbPageContextSupport) s.this.mContext).getPageContext(), new String[]{pbLinkData.linkUrl});
                            }
                        }
                    });
                    singleLinkCardView.a(pbLinkData);
                    tVar.knf.addView(singleLinkCardView);
                    singleLinkCardView.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
                }
                tVar.knf.setVisibility(0);
                return;
            }
            tVar.knf.setVisibility(8);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.knh.setVisibility(0);
            if (tVar.kni == null) {
                tVar.kni = m(postData);
            }
            if (tVar.knh.getChildCount() <= 0 && (view = tVar.kni.getView()) != null) {
                tVar.knh.addView(view);
            }
            tVar.kni.a(this.kmS);
            tVar.kni.a(this.kmT);
            tVar.kni.g(postData.dls());
            tVar.kni.onChangeSkinType(this.kjZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dls() != null && postData.dls().aUO()) {
            BaijiahaoData baijiahaoData = postData.dls().oriUgcInfo;
            Item item = postData.dls().item;
            if (postData.dls().dOO) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.kjZ.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.kjZ.getPageContext());
            } else if (baijiahaoData != null && postData.dls().aUV()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.kjZ.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kjZ.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kjZ.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kjZ.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.kjZ.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dls().showType == 0 || postData.dls().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kjZ.getPageContext(), this.pageFromType);
            } else if (postData.dls().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kjZ.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.kjZ.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int bj(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.al alVar) {
        if (alVar != null && !com.baidu.tbadk.core.util.as.isEmpty(alVar.getLinkUrl()) && alVar.aUG() == com.baidu.tbadk.core.data.al.dPs) {
            if (!alVar.aUH()) {
                tVar.kmZ.getLayoutStrategy().oZ(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.kng.a(alVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cSs() == null) {
            tVar.kmr.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cSs(), tVar.kmr, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.kmZ.setTextViewOnTouchListener(this.kmR);
        tVar.kmZ.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.kkU);
            tbRichTextView.getLayoutStrategy().oR(min);
            tbRichTextView.getLayoutStrategy().oS((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.klN.setOnTouchListener(this.euG);
        tVar.klN.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.kmC.cNt().kkl;
        tVar.kmZ.setOnLongClickListener(this.mOnLongClickListener);
        tVar.kmZ.setOnTouchListener(this.kmR);
        tVar.kmZ.setCommonTextViewOnClickListener(this.aMH);
        tVar.kmZ.setOnImageClickListener(this.eRR);
        tVar.kmZ.setOnImageTouchListener(this.kmR);
        tVar.kmZ.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.kmZ.setOnEmotionClickListener(aVar.kzZ);
        tVar.kmr.setOnClickListener(this.aMH);
        tVar.knj.setAfterItemClickListener(this.aMH);
        tVar.knk.setAfterItemClickListener(this.aMH);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkM = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.kkU = i;
    }

    public void rW(boolean z) {
        this.kkN = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkW = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.euG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.klC = cVar;
    }

    public void sj(boolean z) {
        this.kmN = z;
    }

    public void release() {
        if (this.Uj != 0) {
            ((t) this.Uj).kng.destroy();
            ((t) this.Uj).knk.destroy();
        }
    }

    public void resume() {
        if (this.Uj != 0) {
            ((t) this.Uj).kng.resume();
        }
    }

    public void pause() {
        if (this.Uj != 0) {
            ((t) this.Uj).kng.pause();
        }
    }

    public t cMu() {
        return (t) this.Uj;
    }

    private boolean aF(bv bvVar) {
        return (bvVar == null || bvVar.aYq() == null || bvVar.aYq().getOptions() == null || bvVar.aYq().getOptions().size() <= 0) ? false : true;
    }
}
