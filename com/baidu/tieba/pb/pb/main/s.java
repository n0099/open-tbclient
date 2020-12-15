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
    protected int lED;
    private View.OnClickListener lEF;
    protected com.baidu.tieba.pb.data.f lEv;
    protected boolean lEw;
    private TbRichTextView.c lFl;
    private com.baidu.tieba.pb.pb.sub.b lFm;
    private boolean lGB;
    private boolean lGC;
    private final boolean lGD;
    private boolean lGE;
    private com.baidu.tieba.pb.a.c lGF;
    private com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a> lGG;
    private b.a lGH;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lED = 0;
        this.lEw = true;
        this.lGB = true;
        this.lEv = null;
        this.lFm = null;
        this.lEF = null;
        this.bbH = null;
        this.fNk = null;
        this.fos = null;
        this.mOnLongClickListener = null;
        this.lFl = null;
        this.lGC = false;
        this.lGD = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lGE = false;
        this.pageFromType = 0;
        this.lGF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
        this.lGG = new com.baidu.tieba.card.ab<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar) {
                int i = 3;
                super.a(view, aVar);
                if (aVar != null && aVar.bmn() != null && aVar.bmn().eLH != null && s.this.lEv != null) {
                    OriginalThreadInfo originalThreadInfo = aVar.bmn().eLH;
                    String threadId = s.this.lEv.getThreadId();
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
        this.lGH = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
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
        if (pbFragment != null && pbFragment.dol() != null) {
            this.pageFromType = pbFragment.dol().dqV();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.eNL, R.color.CAM_X0204);
                tVar.lGM.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                tVar.amE.onChangeSkinType();
                if (tVar.lGW != null) {
                    tVar.lGW.onChangeSkinType();
                }
                if (tVar.lGX != null) {
                    tVar.lGX.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.lGR, R.color.CAM_X0107);
                tVar.lGY.vJ(skinType);
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
        t tVar = new t(this.lDI.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lEw, this.lED);
        a(tVar);
        tVar.lGT.Hb(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.lDI.getUniqueId(), this.lEv, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.lGC && this.lGD && tVar != null && tVar.lGM.bJv() && (listView = this.lDI.getListView()) != null) {
            this.lGC = true;
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
        if (this.lEv != null) {
            if (postData.dPh() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.lGM.setOnClickListener(this.bbH);
                    tVar.lGM.setTextViewOnClickListener(this.bbH);
                } else {
                    tVar.lGM.setOnClickListener(null);
                    tVar.lGM.setTextViewOnClickListener(null);
                }
                tVar.lFu.setOnClickListener(this.bbH);
            } else {
                tVar.lFu.setOnClickListener(null);
            }
            if (postData.dPh() == 1) {
                tVar.a(this.lEv, this.lDI.dod(), postData.nmt);
                a(tVar.lGM, view, this.lGE);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.boP() != null) {
                    j = postData.boP().getUserIdLong();
                    str = postData.boP().getUserName();
                    str2 = postData.boP().getName_show();
                }
                if (this.lEv != null && this.lEv.dmU() != null) {
                    tVar.lGT.a(postData.dPp(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lEv.dmU().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.lDI.dpc().dti()) {
                    tVar.lGM.setVisibility(8);
                }
                if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().bpa() != null) {
                    ck bpa = this.lEv.dmU().bpa();
                    String bro = bpa.bro();
                    if (!StringUtils.isNull(bpa.brp())) {
                        if (!StringUtils.isNull(bro)) {
                            tVar.lGO.setVisibility(0);
                            tVar.lGO.startLoad(bro, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.lGO.setVisibility(8);
                }
                if (tVar.lGP != null) {
                    tVar.lGP.setVisibility(8);
                }
                if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().bnv() && tVar.lGW != null) {
                    tVar.lGW.setPadding(tVar.lGW.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.lGW.getPaddingRight(), tVar.lGW.getPaddingBottom());
                }
            }
            tVar.lGM.getLayoutStrategy().tn(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPh()));
            if (postData.dPl() > 0 && postData.dPe() != null && postData.dPe().size() > 0) {
                if (this.lFm == null) {
                    this.lFm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lFm.setIsFromCDN(this.mIsFromCDN);
                    this.lFm.W(this.lEF);
                    if (this.lEv != null) {
                        this.lFm.af(this.lEv.dnj(), TextUtils.equals(this.lEv.dmU().boP().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lFm.setThreadData(this.lEv.dmU());
                    }
                }
                this.lFm.QI(postData.getId());
            }
            tVar.lGM.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            if (this.lEw) {
                tVar.lGM.getLayoutStrategy().tq(R.drawable.transparent_bg);
            } else {
                tVar.lGM.getLayoutStrategy().tq(R.drawable.icon_click);
            }
            tVar.lGM.setIsFromCDN(this.mIsFromCDN);
            if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().isLinkThread()) {
                a(tVar, this.lEv.dmU().bqv());
            }
            boolean z7 = false;
            if (this.lEv != null && this.lEv.dmU() != null) {
                z7 = this.lEv.dmU().isShareThread && postData.dPs() != null;
            }
            if (z7) {
                if (postData.dPs().item != null) {
                    tVar.lGM.getLayoutStrategy().tw(getDimens(R.dimen.tbds24));
                } else {
                    tVar.lGM.getLayoutStrategy().tw(getDimens(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.lGM.getLayoutStrategy().tw(getDimens(R.dimen.tbds24));
            }
            TbRichText dPj = postData.dPj();
            if (this.lEv != null && this.lEv.dnv()) {
                dPj = null;
            }
            if (this.lEv.dmU() != null) {
                tVar.lGM.setIsUseGridImage(this.lEv.dmU().bqM());
                tVar.lGM.setmIsGridImageSupportLongPress(true);
            }
            if (this.lEv != null && 3 == this.lEv.dnB()) {
                if (this.lGC || !this.lGD) {
                    tVar.lGM.setText(dPj, false, this.lFl, true, false);
                } else {
                    tVar.lGM.setText(dPj, true, this.lFl, true, false);
                }
            } else if (this.lGC || !this.lGD) {
                tVar.lGM.setText(dPj, false, this.lFl, false, true);
            } else {
                tVar.lGM.setText(dPj, true, this.lFl, false, true);
            }
            a(tVar, postData, dPj);
            boolean z8 = !StringUtils.isNull(postData.boP().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.lEv != null && this.lEv.dnj() != 0) {
                if (this.lEv.dnj() != 3) {
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
            if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().boP() != null && postData.boP() != null) {
                String userId2 = this.lEv.dmU().boP().getUserId();
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
                    if (postData.dPh() == 1) {
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
                        if (this.lEv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEv.dnj()));
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
                        if (this.lEv != null && this.lEv.dmU() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lEv.dmU().getId());
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
                        if (this.lEv != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEv.dnj()));
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
            if (postData.dPh() == 1) {
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
            tVar.lGM.setTag(sparseArray);
            tVar.lFu.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.lGM.setIsHost(true);
            if (this.lGB) {
                tVar.eNL.setVisibility(0);
            } else {
                tVar.eNL.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lEw) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.lGM.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.lGM.setLayoutParams(layoutParams);
                tVar.lGM.EZ(null);
                this.lGE = false;
                a(tVar, postData, view, i);
            } else {
                this.lGE = true;
                tVar.lGM.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bJB() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.lGM.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.lGM.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().bnv() && this.lEv.dmU().bph() != null && com.baidu.tbadk.core.util.au.isEmpty(this.lEv.getForum().getName())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dPj() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dPj().bIC())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dPj() != null) {
                if (postData.dPj().aDz() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.amE.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.amE.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.amE.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.amE.setLayoutParams(layoutParams3);
                }
            }
            if (this.lEv != null && aJ(this.lEv.dmU())) {
                tVar.ajI.setDataForPb(this.lEv.dmU().bqX(), this.lEv.dmU().getTid(), this.lEv.getForumId());
                if (postData.dPj() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dPj().bIC())) {
                    tVar.ajI.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.ajI.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.ajI.setVisibility(0);
            } else {
                tVar.ajI.setVisibility(8);
            }
            if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().bpE() != null && this.lEv.dmU().bph() == null) {
                tVar.amE.setData(this.lEv.dmU().bpE());
                tVar.amE.setVisibility(0);
                if (this.lEv != null && this.lEv.getForum() != null) {
                    tVar.amE.setForumId(String.valueOf(this.lEv.getForum().getId()));
                }
                if (this.lEv != null && this.lEv.getThreadId() != null) {
                    tVar.amE.setThreadId(this.lEv.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.amE;
                AppletsCellView appletsCellView2 = tVar.amE;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.amE.setVisibility(8);
            }
            doQ();
            if (this.lEv != null && this.lEv.lAN != null) {
                if (tVar.lGR != null) {
                    if (TextUtils.isEmpty(this.lEv.lAN.dnL())) {
                        tVar.lGR.setVisibility(8);
                    } else {
                        tVar.lGR.setVisibility(0);
                        tVar.lGR.setText(this.lEv.lAN.dnL());
                    }
                }
                if (tVar.lGQ != null && tVar.lGY.getRootView() == null) {
                    tVar.lGQ.addView(tVar.lGY.K(this.lEv));
                    String fromPageKey = UtilHelper.getFromPageKey(this.lDI.getPageContext());
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
            if (tVar.lGS != null) {
                tVar.lGS.removeAllViews();
            }
            if (this.lEv != null && this.lEv.dmU() != null && !aJ(this.lEv.dmU()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lEv.dmU().bqY()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lEv.dmU().bqZ()))) {
                com.baidu.tbadk.util.af afVar = new com.baidu.tbadk.util.af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lEv, afVar.n(this.lEv.dmU().bqY(), this.lEv.dmU().bqZ()), this.lEv.getForumName(), this.lDI, afVar.bGQ());
                tVar.lGS.addView(pbLinkGoodsRootView);
                tVar.lGS.setVisibility(0);
                return;
            }
            tVar.lGS.setVisibility(8);
        }
    }

    public void doQ() {
        t doR = doR();
        if (this.lEv != null && this.lEv.dmU() != null && doR != null) {
            doR.b(this.lEv, this.lEv.dmU().boL() == 1, this.lEv.dmU().boK() == 1);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.lGU.setVisibility(0);
            if (tVar.lGV == null) {
                tVar.lGV = m(postData);
            }
            if (tVar.lGU.getChildCount() <= 0 && (view = tVar.lGV.getView()) != null) {
                tVar.lGU.addView(view);
            }
            tVar.lGV.a(this.lGG);
            tVar.lGV.a(this.lGH);
            tVar.lGV.g(postData.dPs());
            tVar.lGV.onChangeSkinType(this.lDI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dPs() != null && postData.dPs().bns()) {
            BaijiahaoData baijiahaoData = postData.dPs().oriUgcInfo;
            Item item = postData.dPs().item;
            if (postData.dPs().eGg) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.lDI.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = (postData.dPs().showType == 0 || postData.dPs().showType == 1) ? new com.baidu.tieba.pb.pb.main.c.f(this.lDI.getPageContext()) : postData.dPs().showType == 3 ? new com.baidu.tieba.pb.pb.main.c.g(this.lDI.getPageContext()) : new com.baidu.tieba.pb.pb.main.c.e(this.lDI.getPageContext());
            } else if (baijiahaoData != null && postData.dPs().bnz()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.lDI.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lDI.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lDI.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lDI.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.lDI.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dPs().showType == 0 || postData.dPs().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.h(this.lDI.getPageContext(), this.pageFromType);
            } else if (postData.dPs().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.i(this.lDI.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.lDI.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null && !com.baidu.tbadk.core.util.au.isEmpty(aoVar.getLinkUrl()) && aoVar.bnk() == com.baidu.tbadk.core.data.ao.eGK) {
            if (!aoVar.bnl()) {
                tVar.lGM.getLayoutStrategy().tw(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.lGT.a(aoVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.duZ() == null) {
            tVar.lFY.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.duZ(), tVar.lFY, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.lGM.setTextViewOnTouchListener(this.lGF);
        tVar.lGM.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lED);
            tbRichTextView.getLayoutStrategy().to(min);
            tbRichTextView.getLayoutStrategy().tp((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.lFu.setOnTouchListener(this.fos);
        tVar.lFu.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lGq.dpR().lDU;
        tVar.lGM.setOnLongClickListener(this.mOnLongClickListener);
        tVar.lGM.setOnTouchListener(this.lGF);
        tVar.lGM.setCommonTextViewOnClickListener(this.bbH);
        tVar.lGM.setOnImageClickListener(this.fNk);
        tVar.lGM.setOnImageTouchListener(this.lGF);
        tVar.lGM.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.lGM.setOnEmotionClickListener(aVar.lUo);
        tVar.lFY.setOnClickListener(this.bbH);
        tVar.lGW.setAfterItemClickListener(this.bbH);
        tVar.lGX.setAfterItemClickListener(this.bbH);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEv = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lED = i;
    }

    public void uy(boolean z) {
        this.lEw = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lEF = onClickListener;
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
        this.lFl = cVar;
    }

    public void uL(boolean z) {
        this.lGB = z;
    }

    public void release() {
        if (this.Wx != 0) {
            ((t) this.Wx).lGT.destroy();
            ((t) this.Wx).lGX.destroy();
        }
    }

    public void resume() {
        if (this.Wx != 0) {
            ((t) this.Wx).lGT.resume();
        }
    }

    public void pause() {
        if (this.Wx != 0) {
            ((t) this.Wx).lGT.pause();
        }
    }

    public t doR() {
        return (t) this.Wx;
    }

    private boolean aJ(by byVar) {
        return (byVar == null || byVar.bqX() == null || byVar.bqX().getOptions() == null || byVar.bqX().getOptions().size() <= 0) ? false : true;
    }
}
