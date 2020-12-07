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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.ck;
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
    private View.OnClickListener bbH;
    private TbRichTextView.i fNk;
    private com.baidu.tieba.pb.a.c fos;
    protected int lEB;
    private View.OnClickListener lED;
    protected com.baidu.tieba.pb.data.f lEt;
    protected boolean lEu;
    private TbRichTextView.c lFj;
    private com.baidu.tieba.pb.pb.sub.b lFk;
    private boolean lGA;
    private final boolean lGB;
    private boolean lGC;
    private com.baidu.tieba.pb.a.c lGD;
    private com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> lGE;
    private b.a lGF;
    private boolean lGz;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lEB = 0;
        this.lEu = true;
        this.lGz = true;
        this.lEt = null;
        this.lFk = null;
        this.lED = null;
        this.bbH = null;
        this.fNk = null;
        this.fos = null;
        this.mOnLongClickListener = null;
        this.lFj = null;
        this.lGA = false;
        this.lGB = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lGC = false;
        this.pageFromType = 0;
        this.lGD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.fos != null) {
                    s.this.fos.ad(view);
                    s.this.fos.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lGE = new com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.bmn() != null && aVar.bmn().eLH != null && s.this.lEt != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bmn().eLH;
                    String threadId = s.this.lEt.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12602").dY("tid", threadId).dY("obj_source", str).al("obj_type", i));
                    }
                }
            }
        };
        this.lGF = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar) {
                if (aVar != null && aVar.bmn() != null && aVar.bmn().eLH != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bmn().eLH;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dok() != null) {
            this.pageFromType = pbFragment.dok().dqU();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.eNL, R.color.CAM_X0204);
                tVar.lGK.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                tVar.amE.onChangeSkinType();
                if (tVar.lGU != null) {
                    tVar.lGU.onChangeSkinType();
                }
                if (tVar.lGV != null) {
                    tVar.lGV.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.lGP, R.color.CAM_X0107);
                tVar.lGW.vJ(skinType);
                if (tVar.ajI != null) {
                    tVar.ajI.onChangeSkinType(skinType);
                }
            }
            tVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public t c(ViewGroup viewGroup) {
        t tVar = new t(this.lDG.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lEu, this.lEB);
        a(tVar);
        tVar.lGR.Hb(this.pageFromType);
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
            postData2.bqd();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.lDG.getUniqueId(), this.lEt, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.lGA && this.lGB && tVar != null && tVar.lGK.bJv() && (listView = this.lDG.getListView()) != null) {
            this.lGA = true;
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
        if (this.lEt != null) {
            if (postData.dPg() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.lGK.setOnClickListener(this.bbH);
                    tVar.lGK.setTextViewOnClickListener(this.bbH);
                } else {
                    tVar.lGK.setOnClickListener(null);
                    tVar.lGK.setTextViewOnClickListener(null);
                }
                tVar.lFs.setOnClickListener(this.bbH);
            } else {
                tVar.lFs.setOnClickListener(null);
            }
            if (postData.dPg() == 1) {
                tVar.a(this.lEt, this.lDG.doc(), postData.nmr);
                a(tVar.lGK, view, this.lGC);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.boP() != null) {
                    j = postData.boP().getUserIdLong();
                    str = postData.boP().getUserName();
                    str2 = postData.boP().getName_show();
                }
                if (this.lEt != null && this.lEt.dmT() != null) {
                    tVar.lGR.a(postData.dPo(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lEt.dmT().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lDG.dpb().dth()) {
                    tVar.lGK.setVisibility(8);
                }
                if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().bpa() != null) {
                    ck bpa = this.lEt.dmT().bpa();
                    String bro = bpa.bro();
                    if (!StringUtils.isNull(bpa.brp())) {
                        if (!StringUtils.isNull(bro)) {
                            tVar.lGM.setVisibility(0);
                            tVar.lGM.startLoad(bro, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.lGM.setVisibility(8);
                }
                if (tVar.lGN != null) {
                    tVar.lGN.setVisibility(8);
                }
                if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().bnv() && tVar.lGU != null) {
                    tVar.lGU.setPadding(tVar.lGU.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.lGU.getPaddingRight(), tVar.lGU.getPaddingBottom());
                }
            }
            tVar.lGK.getLayoutStrategy().tn(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPg()));
            if (postData.dPk() > 0 && postData.dPd() != null && postData.dPd().size() > 0) {
                if (this.lFk == null) {
                    this.lFk = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lFk.setIsFromCDN(this.mIsFromCDN);
                    this.lFk.W(this.lED);
                    if (this.lEt != null) {
                        this.lFk.af(this.lEt.dni(), TextUtils.equals(this.lEt.dmT().boP().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lFk.setThreadData(this.lEt.dmT());
                    }
                }
                this.lFk.QI(postData.getId());
            }
            tVar.lGK.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            if (this.lEu) {
                tVar.lGK.getLayoutStrategy().tq(R.drawable.transparent_bg);
            } else {
                tVar.lGK.getLayoutStrategy().tq(R.drawable.icon_click);
            }
            tVar.lGK.setIsFromCDN(this.mIsFromCDN);
            if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().isLinkThread()) {
                a(tVar, this.lEt.dmT().bqv());
            }
            boolean z7 = false;
            if (this.lEt != null && this.lEt.dmT() != null) {
                z7 = this.lEt.dmT().isShareThread && postData.dPr() != null;
            }
            if (z7) {
                if (postData.dPr().item != null) {
                    tVar.lGK.getLayoutStrategy().tw(getDimens(R.dimen.tbds24));
                } else {
                    tVar.lGK.getLayoutStrategy().tw(getDimens(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.lGK.getLayoutStrategy().tw(getDimens(R.dimen.tbds24));
            }
            TbRichText dPi = postData.dPi();
            if (this.lEt != null && this.lEt.dnu()) {
                dPi = null;
            }
            if (this.lEt.dmT() != null) {
                tVar.lGK.setIsUseGridImage(this.lEt.dmT().bqM());
                tVar.lGK.setmIsGridImageSupportLongPress(true);
            }
            if (this.lEt != null && 3 == this.lEt.dnA()) {
                if (this.lGA || !this.lGB) {
                    tVar.lGK.setText(dPi, false, this.lFj, true, false);
                } else {
                    tVar.lGK.setText(dPi, true, this.lFj, true, false);
                }
            } else if (this.lGA || !this.lGB) {
                tVar.lGK.setText(dPi, false, this.lFj, false, true);
            } else {
                tVar.lGK.setText(dPi, true, this.lFj, false, true);
            }
            a(tVar, postData, dPi);
            boolean z8 = !StringUtils.isNull(postData.boP().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.lEt != null && this.lEt.dni() != 0) {
                if (this.lEt.dni() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.boP() != null) {
                    String userId = postData.boP().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().boP() != null && postData.boP() != null) {
                String userId2 = this.lEt.dmT().boP().getUserId();
                String userId3 = postData.boP().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.boP() == null && UtilHelper.isCurrentAccount(postData.boP().getUserId())) {
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
                    if (postData.dPg() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.boP() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.boP().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.boP().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.boP().getPortrait());
                        }
                        if (this.lEt != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEt.dni()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.boP() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.boP().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.boP().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.boP().getName_show());
                        }
                        if (this.lEt != null && this.lEt.dmT() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lEt.dmT().getId());
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
                        if (this.lEt != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEt.dni()));
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
            if (postData.boP() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dPg() == 1) {
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
            tVar.lGK.setTag(sparseArray);
            tVar.lFs.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.lGK.setIsHost(true);
            if (this.lGz) {
                tVar.eNL.setVisibility(0);
            } else {
                tVar.eNL.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lEu) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.lGK.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.lGK.setLayoutParams(layoutParams);
                tVar.lGK.EZ(null);
                this.lGC = false;
                a(tVar, postData, view, i);
            } else {
                this.lGC = true;
                tVar.lGK.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bJB() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.lGK.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.lGK.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().bnv() && this.lEt.dmT().bph() != null && com.baidu.tbadk.core.util.au.isEmpty(this.lEt.getForum().getName())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dPi() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dPi().bIC())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dPi() != null) {
                if (postData.dPi().aDz() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.amE.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.amE.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.amE.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.amE.setLayoutParams(layoutParams3);
                }
            }
            if (this.lEt != null && aJ(this.lEt.dmT())) {
                tVar.ajI.setDataForPb(this.lEt.dmT().bqX(), this.lEt.dmT().getTid(), this.lEt.getForumId());
                if (postData.dPi() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dPi().bIC())) {
                    tVar.ajI.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.ajI.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.ajI.setVisibility(0);
            } else {
                tVar.ajI.setVisibility(8);
            }
            if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().bpE() != null && this.lEt.dmT().bph() == null) {
                tVar.amE.setData(this.lEt.dmT().bpE());
                tVar.amE.setVisibility(0);
                if (this.lEt != null && this.lEt.getForum() != null) {
                    tVar.amE.setForumId(String.valueOf(this.lEt.getForum().getId()));
                }
                if (this.lEt != null && this.lEt.getThreadId() != null) {
                    tVar.amE.setThreadId(this.lEt.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.amE;
                AppletsCellView appletsCellView2 = tVar.amE;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.amE.setVisibility(8);
            }
            doP();
            if (this.lEt != null && this.lEt.lAL != null) {
                if (tVar.lGP != null) {
                    if (TextUtils.isEmpty(this.lEt.lAL.dnK())) {
                        tVar.lGP.setVisibility(8);
                    } else {
                        tVar.lGP.setVisibility(0);
                        tVar.lGP.setText(this.lEt.lAL.dnK());
                    }
                }
                if (tVar.lGO != null && tVar.lGW.getRootView() == null) {
                    tVar.lGO.addView(tVar.lGW.K(this.lEt));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lDG.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.ar("c13445").al("obj_source", 1).btT();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.ar("c13445").al("obj_source", 3).btT();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.ar("c13445").al("obj_source", 2).btT();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.ar("c13445").al("obj_source", 4).btT();
                        }
                    }
                }
            }
            if (tVar.lGQ != null) {
                tVar.lGQ.removeAllViews();
            }
            if (this.lEt != null && this.lEt.dmT() != null && !aJ(this.lEt.dmT()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lEt.dmT().bqY()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lEt.dmT().bqZ()))) {
                com.baidu.tbadk.util.af afVar = new com.baidu.tbadk.util.af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lEt, afVar.n(this.lEt.dmT().bqY(), this.lEt.dmT().bqZ()), this.lEt.getForumName(), this.lDG, afVar.bGQ());
                tVar.lGQ.addView(pbLinkGoodsRootView);
                tVar.lGQ.setVisibility(0);
                return;
            }
            tVar.lGQ.setVisibility(8);
        }
    }

    public void doP() {
        t doQ = doQ();
        if (this.lEt != null && this.lEt.dmT() != null && doQ != null) {
            doQ.b(this.lEt, this.lEt.dmT().boL() == 1, this.lEt.dmT().boK() == 1);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.lGS.setVisibility(0);
            if (tVar.lGT == null) {
                tVar.lGT = m(postData);
            }
            if (tVar.lGS.getChildCount() <= 0 && (view = tVar.lGT.getView()) != null) {
                tVar.lGS.addView(view);
            }
            tVar.lGT.a(this.lGE);
            tVar.lGT.a(this.lGF);
            tVar.lGT.g(postData.dPr());
            tVar.lGT.onChangeSkinType(this.lDG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dPr() != null && postData.dPr().bns()) {
            BaijiahaoData baijiahaoData = postData.dPr().oriUgcInfo;
            Item item = postData.dPr().item;
            if (postData.dPr().eGg) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lDG.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dPr().showType == 0 || postData.dPr().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lDG.getPageContext()) : postData.dPr().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lDG.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lDG.getPageContext());
            } else if (baijiahaoData != null && postData.dPr().bnz()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lDG.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lDG.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lDG.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lDG.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lDG.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dPr().showType == 0 || postData.dPr().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lDG.getPageContext(), this.pageFromType);
            } else if (postData.dPr().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lDG.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lDG.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.au.isEmpty(aoVar.getLinkUrl()) && aoVar.bnk() == com.baidu.tbadk.core.data.ao.eGK) {
            if (!aoVar.bnl()) {
                tVar.lGK.getLayoutStrategy().tw(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.lGR.a(aoVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.duY() == null) {
            tVar.lFW.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.duY(), tVar.lFW, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.lGK.setTextViewOnTouchListener(this.lGD);
        tVar.lGK.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lEB);
            tbRichTextView.getLayoutStrategy().to(min);
            tbRichTextView.getLayoutStrategy().tp((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.lFs.setOnTouchListener(this.fos);
        tVar.lFs.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lGo.dpQ().lDS;
        tVar.lGK.setOnLongClickListener(this.mOnLongClickListener);
        tVar.lGK.setOnTouchListener(this.lGD);
        tVar.lGK.setCommonTextViewOnClickListener(this.bbH);
        tVar.lGK.setOnImageClickListener(this.fNk);
        tVar.lGK.setOnImageTouchListener(this.lGD);
        tVar.lGK.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.lGK.setOnEmotionClickListener(aVar.lUm);
        tVar.lFW.setOnClickListener(this.bbH);
        tVar.lGU.setAfterItemClickListener(this.bbH);
        tVar.lGV.setAfterItemClickListener(this.bbH);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEt = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lEB = i;
    }

    public void uy(boolean z) {
        this.lEu = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lED = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fos = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.lFj = cVar;
    }

    public void uL(boolean z) {
        this.lGz = z;
    }

    public void release() {
        if (this.Wx != 0) {
            ((t) this.Wx).lGR.destroy();
            ((t) this.Wx).lGV.destroy();
        }
    }

    public void resume() {
        if (this.Wx != 0) {
            ((t) this.Wx).lGR.resume();
        }
    }

    public void pause() {
        if (this.Wx != 0) {
            ((t) this.Wx).lGR.pause();
        }
    }

    public t doQ() {
        return (t) this.Wx;
    }

    private boolean aJ(by byVar) {
        return (byVar == null || byVar.bqX() == null || byVar.bqX().getOptions() == null || byVar.bqX().getOptions().size() <= 0) ? false : true;
    }
}
