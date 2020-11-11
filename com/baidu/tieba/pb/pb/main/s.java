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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.ci;
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
/* loaded from: classes22.dex */
public class s extends o<PostData, t> {
    private View.OnClickListener aZX;
    private TbRichTextView.i fFW;
    private com.baidu.tieba.pb.a.c fhK;
    protected int lqD;
    private View.OnClickListener lqF;
    protected com.baidu.tieba.pb.data.f lqv;
    protected boolean lqw;
    private TbRichTextView.c lrl;
    private com.baidu.tieba.pb.pb.sub.b lrm;
    private boolean lsA;
    private com.baidu.tieba.pb.a.c lsB;
    private com.baidu.tieba.card.ab<AbsThreadDataSupport> lsC;
    private b.a lsD;
    private boolean lsx;
    private boolean lsy;
    private final boolean lsz;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lqD = 0;
        this.lqw = true;
        this.lsx = true;
        this.lqv = null;
        this.lrm = null;
        this.lqF = null;
        this.aZX = null;
        this.fFW = null;
        this.fhK = null;
        this.mOnLongClickListener = null;
        this.lrl = null;
        this.lsy = false;
        this.lsz = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lsA = false;
        this.pageFromType = 0;
        this.lsB = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.fhK != null) {
                    s.this.fhK.ad(view);
                    s.this.fhK.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lsC = new com.baidu.tieba.card.ab<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null && s.this.lqv != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bjZ().eGn;
                    String threadId = s.this.lqv.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12602").dR("tid", threadId).dR("obj_source", str).al("obj_type", i));
                    }
                }
            }
        };
        this.lsD = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bjZ().eGn;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.djz() != null) {
            this.pageFromType = pbFragment.djz().dmh();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.eIp, R.color.cp_bg_line_c);
                tVar.lsI.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                tVar.alA.onChangeSkinType();
                if (tVar.lsS != null) {
                    tVar.lsS.onChangeSkinType();
                }
                if (tVar.lsT != null) {
                    tVar.lsT.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.lsN, R.color.cp_cont_j);
                tVar.lsU.uE(skinType);
                if (tVar.aiE != null) {
                    tVar.aiE.onChangeSkinType(skinType);
                }
            }
            tVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cj */
    public t c(ViewGroup viewGroup) {
        t tVar = new t(this.lpI.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lqw, this.lqD);
        a(tVar);
        tVar.lsP.FO(this.pageFromType);
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
            postData2.bnM();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lpI.getUniqueId(), this.lqv, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.lsy && this.lsz && tVar != null && tVar.lsI.bGC() && (listView = this.lpI.getListView()) != null) {
            this.lsy = true;
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
        if (this.lqv != null) {
            if (postData.dJZ() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.lsI.setOnClickListener(this.aZX);
                    tVar.lsI.setTextViewOnClickListener(this.aZX);
                } else {
                    tVar.lsI.setOnClickListener(null);
                    tVar.lsI.setTextViewOnClickListener(null);
                }
                tVar.lrx.setOnClickListener(this.aZX);
            } else {
                tVar.lrx.setOnClickListener(null);
            }
            if (postData.dJZ() == 1) {
                tVar.a(this.lqv, this.lpI.djq(), postData.mXB);
                a(tVar.lsI, view, this.lsA);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bmA() != null) {
                    j = postData.bmA().getUserIdLong();
                    str = postData.bmA().getUserName();
                    str2 = postData.bmA().getName_show();
                }
                if (this.lqv != null && this.lqv.dik() != null) {
                    tVar.lsP.a(postData.dKh(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lqv.dik().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lpI.dkp().dos()) {
                    tVar.lsI.setVisibility(8);
                }
                if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().bmL() != null) {
                    ci bmL = this.lqv.dik().bmL();
                    String boV = bmL.boV();
                    if (!StringUtils.isNull(bmL.boW())) {
                        if (!StringUtils.isNull(boV)) {
                            tVar.lsK.setVisibility(0);
                            tVar.lsK.startLoad(boV, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.lsK.setVisibility(8);
                }
                if (tVar.lsL != null) {
                    tVar.lsL.setVisibility(8);
                }
                if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().blg() && tVar.lsS != null) {
                    tVar.lsS.setPadding(tVar.lsS.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.lsS.getPaddingRight(), tVar.lsS.getPaddingBottom());
                }
            }
            tVar.lsI.getLayoutStrategy().sm(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dJZ()));
            if (postData.dKd() > 0 && postData.dJW() != null && postData.dJW().size() > 0) {
                if (this.lrm == null) {
                    this.lrm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lrm.setIsFromCDN(this.mIsFromCDN);
                    this.lrm.X(this.lqF);
                    if (this.lqv != null) {
                        this.lrm.af(this.lqv.diz(), TextUtils.equals(this.lqv.dik().bmA().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lrm.setThreadData(this.lqv.dik());
                    }
                }
                this.lrm.Qe(postData.getId());
            }
            tVar.lsI.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            if (this.lqw) {
                tVar.lsI.getLayoutStrategy().sp(R.drawable.transparent_bg);
            } else {
                tVar.lsI.getLayoutStrategy().sp(R.drawable.icon_click);
            }
            tVar.lsI.setIsFromCDN(this.mIsFromCDN);
            if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().isLinkThread()) {
                a(tVar, this.lqv.dik().boe());
            }
            boolean z7 = false;
            if (this.lqv != null && this.lqv.dik() != null) {
                z7 = this.lqv.dik().isShareThread && postData.dKk() != null;
            }
            if (z7) {
                if (postData.dKk().item != null) {
                    tVar.lsI.getLayoutStrategy().sv(aT(R.dimen.tbds24));
                } else {
                    tVar.lsI.getLayoutStrategy().sv(aT(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.lsI.getLayoutStrategy().sv(aT(R.dimen.tbds24));
            }
            TbRichText dKb = postData.dKb();
            if (this.lqv != null && this.lqv.diK()) {
                dKb = null;
            }
            if (this.lqv.dik() != null) {
                tVar.lsI.setIsUseGridImage(this.lqv.dik().bov());
                tVar.lsI.setmIsGridImageSupportLongPress(true);
            }
            if (this.lqv != null && 3 == this.lqv.diQ()) {
                if (this.lsy || !this.lsz) {
                    tVar.lsI.setText(dKb, false, this.lrl, true, false);
                } else {
                    tVar.lsI.setText(dKb, true, this.lrl, true, false);
                }
            } else if (this.lsy || !this.lsz) {
                tVar.lsI.setText(dKb, false, this.lrl, false, true);
            } else {
                tVar.lsI.setText(dKb, true, this.lrl, false, true);
            }
            a(tVar, postData, dKb);
            boolean z8 = !StringUtils.isNull(postData.bmA().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.lqv != null && this.lqv.diz() != 0) {
                if (this.lqv.diz() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.bmA() != null) {
                    String userId = postData.bmA().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().bmA() != null && postData.bmA() != null) {
                String userId2 = this.lqv.dik().bmA().getUserId();
                String userId3 = postData.bmA().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.bmA() == null && UtilHelper.isCurrentAccount(postData.bmA().getUserId())) {
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
                    if (postData.dJZ() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.bmA() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bmA().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bmA().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bmA().getPortrait());
                        }
                        if (this.lqv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqv.diz()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bmA() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bmA().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bmA().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bmA().getName_show());
                        }
                        if (this.lqv != null && this.lqv.dik() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lqv.dik().getId());
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
                        if (this.lqv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqv.diz()));
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
            if (postData.bmA() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dJZ() == 1) {
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
            tVar.lsI.setTag(sparseArray);
            tVar.lrx.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.lsI.setIsHost(true);
            if (this.lsx) {
                tVar.eIp.setVisibility(0);
            } else {
                tVar.eIp.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lqw) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.lsI.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.lsI.setLayoutParams(layoutParams);
                tVar.lsI.EK(null);
                this.lsA = false;
                a(tVar, postData, view, i);
            } else {
                this.lsA = true;
                tVar.lsI.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bGI() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.lsI.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.lsI.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().blg() && this.lqv.dik().bmS() != null && com.baidu.tbadk.core.util.at.isEmpty(this.lqv.getForum().getName())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dKb() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dKb().bFI())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dKb() != null) {
                if (postData.dKb().aAY() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.alA.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.alA.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.alA.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.alA.setLayoutParams(layoutParams3);
                }
            }
            if (this.lqv != null && aH(this.lqv.dik())) {
                tVar.aiE.setDataForPb(this.lqv.dik().boF(), this.lqv.dik().getTid(), this.lqv.getForumId());
                if (postData.dKb() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dKb().bFI())) {
                    tVar.aiE.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.aiE.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.aiE.setVisibility(0);
            } else {
                tVar.aiE.setVisibility(8);
            }
            if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().bnp() != null && this.lqv.dik().bmS() == null) {
                tVar.alA.setData(this.lqv.dik().bnp());
                tVar.alA.setVisibility(0);
                if (this.lqv != null && this.lqv.getForum() != null) {
                    tVar.alA.setForumId(String.valueOf(this.lqv.getForum().getId()));
                }
                if (this.lqv != null && this.lqv.getThreadId() != null) {
                    tVar.alA.setThreadId(this.lqv.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.alA;
                AppletsCellView appletsCellView2 = tVar.alA;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.alA.setVisibility(8);
            }
            if (this.lqv != null && this.lqv.dik() != null && (this.lqv.dik().bmO() != 0 || this.lqv.dik().blg())) {
                tVar.b(this.lqv, this.lqv.dik().bmw() == 1, this.lqv.dik().bmv() == 1);
            }
            if (this.lqv != null && this.lqv.lmV != null) {
                if (tVar.lsN != null) {
                    if (TextUtils.isEmpty(this.lqv.lmV.diY())) {
                        tVar.lsN.setVisibility(8);
                    } else {
                        tVar.lsN.setVisibility(0);
                        tVar.lsN.setText(this.lqv.lmV.diY());
                    }
                }
                if (tVar.lsM != null && tVar.lsU.getRootView() == null) {
                    tVar.lsM.addView(tVar.lsU.H(this.lqv));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lpI.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").al("obj_source", 1).brk();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").al("obj_source", 3).brk();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").al("obj_source", 2).brk();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").al("obj_source", 4).brk();
                        }
                    }
                }
            }
            if (tVar.lsO != null) {
                tVar.lsO.removeAllViews();
            }
            if (this.lqv != null && this.lqv.dik() != null && !aH(this.lqv.dik()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lqv.dik().boG()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lqv.dik().boH()))) {
                com.baidu.tbadk.util.ag agVar = new com.baidu.tbadk.util.ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lqv, agVar.n(this.lqv.dik().boG(), this.lqv.dik().boH()), this.lqv.getForumName(), this.lpI, agVar.bDW());
                tVar.lsO.addView(pbLinkGoodsRootView);
                tVar.lsO.setVisibility(0);
                return;
            }
            tVar.lsO.setVisibility(8);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.lsQ.setVisibility(0);
            if (tVar.lsR == null) {
                tVar.lsR = m(postData);
            }
            if (tVar.lsQ.getChildCount() <= 0 && (view = tVar.lsR.getView()) != null) {
                tVar.lsQ.addView(view);
            }
            tVar.lsR.a(this.lsC);
            tVar.lsR.a(this.lsD);
            tVar.lsR.g(postData.dKk());
            tVar.lsR.onChangeSkinType(this.lpI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dKk() != null && postData.dKk().bld()) {
            BaijiahaoData baijiahaoData = postData.dKk().oriUgcInfo;
            Item item = postData.dKk().item;
            if (postData.dKk().eAQ) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lpI.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.lpI.getPageContext());
            } else if (baijiahaoData != null && postData.dKk().blk()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lpI.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.lpI.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.lpI.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.lpI.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lpI.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dKk().showType == 0 || postData.dKk().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.lpI.getPageContext(), this.pageFromType);
            } else if (postData.dKk().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.lpI.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lpI.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl()) && amVar.bkV() == com.baidu.tbadk.core.data.am.eBu) {
            if (!amVar.bkW()) {
                tVar.lsI.getLayoutStrategy().sv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.lsP.a(amVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dqh() == null) {
            tVar.lsb.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dqh(), tVar.lsb, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.lsI.setTextViewOnTouchListener(this.lsB);
        tVar.lsI.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lqD);
            tbRichTextView.getLayoutStrategy().sn(min);
            tbRichTextView.getLayoutStrategy().so((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.lrx.setOnTouchListener(this.fhK);
        tVar.lrx.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lsm.dle().lpU;
        tVar.lsI.setOnLongClickListener(this.mOnLongClickListener);
        tVar.lsI.setOnTouchListener(this.lsB);
        tVar.lsI.setCommonTextViewOnClickListener(this.aZX);
        tVar.lsI.setOnImageClickListener(this.fFW);
        tVar.lsI.setOnImageTouchListener(this.lsB);
        tVar.lsI.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.lsI.setOnEmotionClickListener(aVar.lGc);
        tVar.lsb.setOnClickListener(this.aZX);
        tVar.lsS.setAfterItemClickListener(this.aZX);
        tVar.lsT.setAfterItemClickListener(this.aZX);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqv = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lqD = i;
    }

    public void tT(boolean z) {
        this.lqw = z;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lqF = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fhK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.lrl = cVar;
    }

    public void ug(boolean z) {
        this.lsx = z;
    }

    public void release() {
        if (this.Vy != 0) {
            ((t) this.Vy).lsP.destroy();
            ((t) this.Vy).lsT.destroy();
        }
    }

    public void resume() {
        if (this.Vy != 0) {
            ((t) this.Vy).lsP.resume();
        }
    }

    public void pause() {
        if (this.Vy != 0) {
            ((t) this.Vy).lsP.pause();
        }
    }

    public t dke() {
        return (t) this.Vy;
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.boF() == null || bwVar.boF().getOptions() == null || bwVar.boF().getOptions().size() <= 0) ? false : true;
    }
}
