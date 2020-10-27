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
    private View.OnClickListener aYF;
    private TbRichTextView.i fAg;
    private com.baidu.tieba.pb.a.c fbT;
    protected int lkC;
    private View.OnClickListener lkE;
    protected com.baidu.tieba.pb.data.f lku;
    protected boolean lkv;
    private TbRichTextView.c llk;
    private com.baidu.tieba.pb.pb.sub.b lll;
    private com.baidu.tieba.pb.a.c lmA;
    private com.baidu.tieba.card.ab<AbsThreadDataSupport> lmB;
    private b.a lmC;
    private boolean lmw;
    private boolean lmx;
    private final boolean lmy;
    private boolean lmz;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lkC = 0;
        this.lkv = true;
        this.lmw = true;
        this.lku = null;
        this.lll = null;
        this.lkE = null;
        this.aYF = null;
        this.fAg = null;
        this.fbT = null;
        this.mOnLongClickListener = null;
        this.llk = null;
        this.lmx = false;
        this.lmy = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.lmz = false;
        this.pageFromType = 0;
        this.lmA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.fbT != null) {
                    s.this.fbT.Z(view);
                    s.this.fbT.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lmB = new com.baidu.tieba.card.ab<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null && absThreadDataSupport.bhz().eAy != null && s.this.lku != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bhz().eAy;
                    String threadId = s.this.lku.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12602").dR("tid", threadId).dR("obj_source", str).aj("obj_type", i));
                    }
                }
            }
        };
        this.lmC = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null && absThreadDataSupport.bhz().eAy != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bhz().eAy;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dgX() != null) {
            this.pageFromType = pbFragment.dgX().djF();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.eCA, R.color.cp_bg_line_c);
                tVar.lmH.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                tVar.alA.onChangeSkinType();
                if (tVar.lmR != null) {
                    tVar.lmR.onChangeSkinType();
                }
                if (tVar.lmS != null) {
                    tVar.lmS.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.lmM, R.color.cp_cont_j);
                tVar.lmT.uu(skinType);
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
    /* renamed from: ch */
    public t c(ViewGroup viewGroup) {
        t tVar = new t(this.ljH.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.lkv, this.lkC);
        a(tVar);
        tVar.lmO.FB(this.pageFromType);
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
            postData2.blm();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.ljH.getUniqueId(), this.lku, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.lmx && this.lmy && tVar != null && tVar.lmH.bEd() && (listView = this.ljH.getListView()) != null) {
            this.lmx = true;
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
        if (this.lku != null) {
            if (postData.dHx() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.lmH.setOnClickListener(this.aYF);
                    tVar.lmH.setTextViewOnClickListener(this.aYF);
                } else {
                    tVar.lmH.setOnClickListener(null);
                    tVar.lmH.setTextViewOnClickListener(null);
                }
                tVar.llw.setOnClickListener(this.aYF);
            } else {
                tVar.llw.setOnClickListener(null);
            }
            if (postData.dHx() == 1) {
                tVar.a(this.lku, this.ljH.dgO(), postData.mRy);
                a(tVar.lmH, view, this.lmz);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bka() != null) {
                    j = postData.bka().getUserIdLong();
                    str = postData.bka().getUserName();
                    str2 = postData.bka().getName_show();
                }
                if (this.lku != null && this.lku.dfI() != null) {
                    tVar.lmO.a(postData.dHF(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lku.dfI().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.ljH.dhN().dlP()) {
                    tVar.lmH.setVisibility(8);
                }
                if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().bkl() != null) {
                    ci bkl = this.lku.dfI().bkl();
                    String bmv = bkl.bmv();
                    if (!StringUtils.isNull(bkl.bmw())) {
                        if (!StringUtils.isNull(bmv)) {
                            tVar.lmJ.setVisibility(0);
                            tVar.lmJ.startLoad(bmv, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.lmJ.setVisibility(8);
                }
                if (tVar.lmK != null) {
                    tVar.lmK.setVisibility(8);
                }
                if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().biG() && tVar.lmR != null) {
                    tVar.lmR.setPadding(tVar.lmR.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.lmR.getPaddingRight(), tVar.lmR.getPaddingBottom());
                }
            }
            tVar.lmH.getLayoutStrategy().sc(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dHx()));
            if (postData.dHB() > 0 && postData.dHu() != null && postData.dHu().size() > 0) {
                if (this.lll == null) {
                    this.lll = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.lll.setIsFromCDN(this.mIsFromCDN);
                    this.lll.W(this.lkE);
                    if (this.lku != null) {
                        this.lll.af(this.lku.dfX(), TextUtils.equals(this.lku.dfI().bka().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.lll.setThreadData(this.lku.dfI());
                    }
                }
                this.lll.PN(postData.getId());
            }
            tVar.lmH.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            if (this.lkv) {
                tVar.lmH.getLayoutStrategy().sf(R.drawable.transparent_bg);
            } else {
                tVar.lmH.getLayoutStrategy().sf(R.drawable.icon_click);
            }
            tVar.lmH.setIsFromCDN(this.mIsFromCDN);
            if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().isLinkThread()) {
                a(tVar, this.lku.dfI().blE());
            }
            boolean z7 = false;
            if (this.lku != null && this.lku.dfI() != null) {
                z7 = this.lku.dfI().isShareThread && postData.dHI() != null;
            }
            if (z7) {
                if (postData.dHI().item != null) {
                    tVar.lmH.getLayoutStrategy().sl(aT(R.dimen.tbds24));
                } else {
                    tVar.lmH.getLayoutStrategy().sl(aT(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.lmH.getLayoutStrategy().sl(aT(R.dimen.tbds24));
            }
            TbRichText dHz = postData.dHz();
            if (this.lku != null && this.lku.dgi()) {
                dHz = null;
            }
            if (this.lku.dfI() != null) {
                tVar.lmH.setIsUseGridImage(this.lku.dfI().blV());
                tVar.lmH.setmIsGridImageSupportLongPress(true);
            }
            if (this.lku != null && 3 == this.lku.dgo()) {
                if (this.lmx || !this.lmy) {
                    tVar.lmH.setText(dHz, false, this.llk, true, false);
                } else {
                    tVar.lmH.setText(dHz, true, this.llk, true, false);
                }
            } else if (this.lmx || !this.lmy) {
                tVar.lmH.setText(dHz, false, this.llk, false, true);
            } else {
                tVar.lmH.setText(dHz, true, this.llk, false, true);
            }
            a(tVar, postData, dHz);
            boolean z8 = !StringUtils.isNull(postData.bka().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.lku != null && this.lku.dfX() != 0) {
                if (this.lku.dfX() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.bka() != null) {
                    String userId = postData.bka().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().bka() != null && postData.bka() != null) {
                String userId2 = this.lku.dfI().bka().getUserId();
                String userId3 = postData.bka().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.bka() == null && UtilHelper.isCurrentAccount(postData.bka().getUserId())) {
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
                    if (postData.dHx() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.bka() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bka().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bka().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bka().getPortrait());
                        }
                        if (this.lku != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lku.dfX()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bka() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bka().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bka().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bka().getName_show());
                        }
                        if (this.lku != null && this.lku.dfI() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lku.dfI().getId());
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
                        if (this.lku != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lku.dfX()));
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
            if (postData.bka() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dHx() == 1) {
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
            tVar.lmH.setTag(sparseArray);
            tVar.llw.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.lmH.setIsHost(true);
            if (this.lmw) {
                tVar.eCA.setVisibility(0);
            } else {
                tVar.eCA.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lkv) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.lmH.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.lmH.setLayoutParams(layoutParams);
                tVar.lmH.Ew(null);
                this.lmz = false;
                a(tVar, postData, view, i);
            } else {
                this.lmz = true;
                tVar.lmH.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bEj() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.lmH.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.lmH.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().biG() && this.lku.dfI().bks() != null && com.baidu.tbadk.core.util.at.isEmpty(this.lku.getForum().getName())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dHz() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dHz().bDj())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dHz() != null) {
                if (postData.dHz().ayy() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.alA.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.alA.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.alA.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.alA.setLayoutParams(layoutParams3);
                }
            }
            if (this.lku != null && aH(this.lku.dfI())) {
                tVar.aiE.setDataForPb(this.lku.dfI().bmf(), this.lku.dfI().getTid(), this.lku.getForumId());
                if (postData.dHz() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dHz().bDj())) {
                    tVar.aiE.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.aiE.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.aiE.setVisibility(0);
            } else {
                tVar.aiE.setVisibility(8);
            }
            if (this.lku != null && this.lku.dfI() != null && this.lku.dfI().bkP() != null && this.lku.dfI().bks() == null) {
                tVar.alA.setData(this.lku.dfI().bkP());
                tVar.alA.setVisibility(0);
                if (this.lku != null && this.lku.getForum() != null) {
                    tVar.alA.setForumId(String.valueOf(this.lku.getForum().getId()));
                }
                if (this.lku != null && this.lku.getThreadId() != null) {
                    tVar.alA.setThreadId(this.lku.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.alA;
                AppletsCellView appletsCellView2 = tVar.alA;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.alA.setVisibility(8);
            }
            if (this.lku != null && this.lku.dfI() != null && (this.lku.dfI().bko() != 0 || this.lku.dfI().biG())) {
                tVar.b(this.lku, this.lku.dfI().bjW() == 1, this.lku.dfI().bjV() == 1);
            }
            if (this.lku != null && this.lku.lgZ != null) {
                if (tVar.lmM != null) {
                    if (TextUtils.isEmpty(this.lku.lgZ.dgw())) {
                        tVar.lmM.setVisibility(8);
                    } else {
                        tVar.lmM.setVisibility(0);
                        tVar.lmM.setText(this.lku.lgZ.dgw());
                    }
                }
                if (tVar.lmL != null && tVar.lmT.getRootView() == null) {
                    tVar.lmL.addView(tVar.lmT.H(this.lku));
                    String fromPageKey = UtilHelper.getFromPageKey(this.ljH.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 1).boK();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 3).boK();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 2).boK();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 4).boK();
                        }
                    }
                }
            }
            if (tVar.lmN != null) {
                tVar.lmN.removeAllViews();
            }
            if (this.lku != null && this.lku.dfI() != null && !aH(this.lku.dfI()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.lku.dfI().bmg()) || !com.baidu.tbadk.core.util.y.isEmpty(this.lku.dfI().bmh()))) {
                com.baidu.tbadk.util.ag agVar = new com.baidu.tbadk.util.ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lku, agVar.m(this.lku.dfI().bmg(), this.lku.dfI().bmh()), this.lku.getForumName(), this.ljH, agVar.bBx());
                tVar.lmN.addView(pbLinkGoodsRootView);
                tVar.lmN.setVisibility(0);
                return;
            }
            tVar.lmN.setVisibility(8);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.lmP.setVisibility(0);
            if (tVar.lmQ == null) {
                tVar.lmQ = m(postData);
            }
            if (tVar.lmP.getChildCount() <= 0 && (view = tVar.lmQ.getView()) != null) {
                tVar.lmP.addView(view);
            }
            tVar.lmQ.a(this.lmB);
            tVar.lmQ.a(this.lmC);
            tVar.lmQ.g(postData.dHI());
            tVar.lmQ.onChangeSkinType(this.ljH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dHI() != null && postData.dHI().biD()) {
            BaijiahaoData baijiahaoData = postData.dHI().oriUgcInfo;
            Item item = postData.dHI().item;
            if (postData.dHI().euX) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.ljH.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.ljH.getPageContext());
            } else if (baijiahaoData != null && postData.dHI().biK()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.ljH.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.ljH.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.ljH.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.ljH.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.ljH.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dHI().showType == 0 || postData.dHI().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.ljH.getPageContext(), this.pageFromType);
            } else if (postData.dHI().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.ljH.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.ljH.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl()) && amVar.biv() == com.baidu.tbadk.core.data.am.evB) {
            if (!amVar.biw()) {
                tVar.lmH.getLayoutStrategy().sl(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.lmO.a(amVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dnF() == null) {
            tVar.lma.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dnF(), tVar.lma, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.lmH.setTextViewOnTouchListener(this.lmA);
        tVar.lmH.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.lkC);
            tbRichTextView.getLayoutStrategy().sd(min);
            tbRichTextView.getLayoutStrategy().se((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.llw.setOnTouchListener(this.fbT);
        tVar.llw.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.lml.diC().ljT;
        tVar.lmH.setOnLongClickListener(this.mOnLongClickListener);
        tVar.lmH.setOnTouchListener(this.lmA);
        tVar.lmH.setCommonTextViewOnClickListener(this.aYF);
        tVar.lmH.setOnImageClickListener(this.fAg);
        tVar.lmH.setOnImageTouchListener(this.lmA);
        tVar.lmH.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.lmH.setOnEmotionClickListener(aVar.lAg);
        tVar.lma.setOnClickListener(this.aYF);
        tVar.lmR.setAfterItemClickListener(this.aYF);
        tVar.lmS.setAfterItemClickListener(this.aYF);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lku = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.lkC = i;
    }

    public void tK(boolean z) {
        this.lkv = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lkE = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fbT = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.llk = cVar;
    }

    public void tX(boolean z) {
        this.lmw = z;
    }

    public void release() {
        if (this.Vy != 0) {
            ((t) this.Vy).lmO.destroy();
            ((t) this.Vy).lmS.destroy();
        }
    }

    public void resume() {
        if (this.Vy != 0) {
            ((t) this.Vy).lmO.resume();
        }
    }

    public void pause() {
        if (this.Vy != 0) {
            ((t) this.Vy).lmO.pause();
        }
    }

    public t dhC() {
        return (t) this.Vy;
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.bmf() == null || bwVar.bmf().getOptions() == null || bwVar.bmf().getOptions().size() <= 0) ? false : true;
    }
}
