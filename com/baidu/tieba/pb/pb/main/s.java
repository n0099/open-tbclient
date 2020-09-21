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
/* loaded from: classes21.dex */
public class s extends o<PostData, t> {
    private View.OnClickListener aTZ;
    private com.baidu.tieba.pb.a.c eHq;
    private TbRichTextView.i ffu;
    protected com.baidu.tieba.pb.data.f kIK;
    protected boolean kIL;
    protected int kIS;
    private View.OnClickListener kIU;
    private TbRichTextView.c kJA;
    private com.baidu.tieba.pb.pb.sub.b kJB;
    private boolean kKM;
    private boolean kKN;
    private final boolean kKO;
    private boolean kKP;
    private com.baidu.tieba.pb.a.c kKQ;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> kKR;
    private b.a kKS;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kIS = 0;
        this.kIL = true;
        this.kKM = true;
        this.kIK = null;
        this.kJB = null;
        this.kIU = null;
        this.aTZ = null;
        this.ffu = null;
        this.eHq = null;
        this.mOnLongClickListener = null;
        this.kJA = null;
        this.kKN = false;
        this.kKO = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.kKP = false;
        this.pageFromType = 0;
        this.kKQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.eHq != null) {
                    s.this.eHq.Z(view);
                    s.this.eHq.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.kKR = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null && s.this.kIK != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bcY().efS;
                    String threadId = s.this.kIK.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12602").dF("tid", threadId).dF("obj_source", str).ai("obj_type", i));
                    }
                }
            }
        };
        this.kKS = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bcY().efS;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.dah() != null) {
            this.pageFromType = pbFragment.dah().dcP();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.ehT, R.color.cp_bg_line_c);
                tVar.kKX.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                tVar.alg.onChangeSkinType();
                if (tVar.kLh != null) {
                    tVar.kLh.onChangeSkinType();
                }
                if (tVar.kLi != null) {
                    tVar.kLi.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.kLc, R.color.cp_cont_j);
                tVar.kLj.tE(skinType);
                if (tVar.ail != null) {
                    tVar.ail.onChangeSkinType(skinType);
                }
            }
            tVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public t c(ViewGroup viewGroup) {
        t tVar = new t(this.kHX.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.kIL, this.kIS);
        a(tVar);
        tVar.kLe.EC(this.pageFromType);
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
            postData2.bgK();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kHX.getUniqueId(), this.kIK, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.kKN && this.kKO && tVar != null && tVar.kKX.bzA() && (listView = this.kHX.getListView()) != null) {
            this.kKN = true;
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
        if (this.kIK != null) {
            if (postData.dAD() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.kKX.setOnClickListener(this.aTZ);
                    tVar.kKX.setTextViewOnClickListener(this.aTZ);
                } else {
                    tVar.kKX.setOnClickListener(null);
                    tVar.kKX.setTextViewOnClickListener(null);
                }
                tVar.kJM.setOnClickListener(this.aTZ);
            } else {
                tVar.kJM.setOnClickListener(null);
            }
            if (postData.dAD() == 1) {
                tVar.a(this.kIK, this.kHX.cZX(), postData.mpl);
                a(tVar.kKX, view, this.kKP);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bfy() != null) {
                    j = postData.bfy().getUserIdLong();
                    str = postData.bfy().getUserName();
                    str2 = postData.bfy().getName_show();
                }
                if (this.kIK != null && this.kIK.cYR() != null) {
                    tVar.kLe.a(postData.dAL(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kIK.cYR().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.kHX.daX().deZ()) {
                    tVar.kKX.setVisibility(8);
                }
                if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().bfJ() != null) {
                    ci bfJ = this.kIK.cYR().bfJ();
                    String bhT = bfJ.bhT();
                    if (!StringUtils.isNull(bfJ.bhU())) {
                        if (!StringUtils.isNull(bhT)) {
                            tVar.kKZ.setVisibility(0);
                            tVar.kKZ.startLoad(bhT, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.kKZ.setVisibility(8);
                }
                if (tVar.kLa != null) {
                    tVar.kLa.setVisibility(8);
                }
                if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().bee() && tVar.kLh != null) {
                    tVar.kLh.setPadding(tVar.kLh.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.kLh.getPaddingRight(), tVar.kLh.getPaddingBottom());
                }
            }
            tVar.kKX.getLayoutStrategy().rt(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dAD()));
            if (postData.dAH() > 0 && postData.dAA() != null && postData.dAA().size() > 0) {
                if (this.kJB == null) {
                    this.kJB = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.kJB.setIsFromCDN(this.mIsFromCDN);
                    this.kJB.W(this.kIU);
                    if (this.kIK != null) {
                        this.kJB.ad(this.kIK.cZg(), TextUtils.equals(this.kIK.cYR().bfy().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.kJB.setThreadData(this.kIK.cYR());
                    }
                }
                this.kJB.OA(postData.getId());
            }
            tVar.kKX.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            if (this.kIL) {
                tVar.kKX.getLayoutStrategy().rw(R.drawable.transparent_bg);
            } else {
                tVar.kKX.getLayoutStrategy().rw(R.drawable.icon_click);
            }
            tVar.kKX.setIsFromCDN(this.mIsFromCDN);
            if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().isLinkThread()) {
                a(tVar, this.kIK.cYR().bhc());
            }
            boolean z7 = false;
            if (this.kIK != null && this.kIK.cYR() != null) {
                z7 = this.kIK.cYR().isShareThread && postData.dAO() != null;
            }
            if (z7) {
                if (postData.dAO().item != null) {
                    tVar.kKX.getLayoutStrategy().rC(aT(R.dimen.tbds24));
                } else {
                    tVar.kKX.getLayoutStrategy().rC(aT(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.kKX.getLayoutStrategy().rC(aT(R.dimen.tbds24));
            }
            TbRichText dAF = postData.dAF();
            if (this.kIK != null && this.kIK.cZr()) {
                dAF = null;
            }
            if (this.kIK.cYR() != null) {
                tVar.kKX.setIsUseGridImage(this.kIK.cYR().bht());
                tVar.kKX.setmIsGridImageSupportLongPress(true);
            }
            if (this.kIK != null && 3 == this.kIK.cZx()) {
                if (this.kKN || !this.kKO) {
                    tVar.kKX.setText(dAF, false, this.kJA, true, false);
                } else {
                    tVar.kKX.setText(dAF, true, this.kJA, true, false);
                }
            } else if (this.kKN || !this.kKO) {
                tVar.kKX.setText(dAF, false, this.kJA, false, true);
            } else {
                tVar.kKX.setText(dAF, true, this.kJA, false, true);
            }
            a(tVar, postData, dAF);
            boolean z8 = !StringUtils.isNull(postData.bfy().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.kIK != null && this.kIK.cZg() != 0) {
                if (this.kIK.cZg() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.bfy() != null) {
                    String userId = postData.bfy().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().bfy() != null && postData.bfy() != null) {
                String userId2 = this.kIK.cYR().bfy().getUserId();
                String userId3 = postData.bfy().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.bfy() == null && UtilHelper.isCurrentAccount(postData.bfy().getUserId())) {
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
                    if (postData.dAD() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.bfy() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bfy().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bfy().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bfy().getPortrait());
                        }
                        if (this.kIK != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kIK.cZg()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bfy() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bfy().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bfy().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bfy().getName_show());
                        }
                        if (this.kIK != null && this.kIK.cYR() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kIK.cYR().getId());
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
                        if (this.kIK != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kIK.cZg()));
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
            if (postData.bfy() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dAD() == 1) {
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
            tVar.kKX.setTag(sparseArray);
            tVar.kJM.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.kKX.setIsHost(true);
            if (this.kKM) {
                tVar.ehT.setVisibility(0);
            } else {
                tVar.ehT.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kIL) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.kKX.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.kKX.setLayoutParams(layoutParams);
                tVar.kKX.Dr(null);
                this.kKP = false;
                a(tVar, postData, view, i);
            } else {
                this.kKP = true;
                tVar.kKX.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bzG() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.kKX.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.kKX.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().bee() && this.kIK.cYR().bfQ() != null && com.baidu.tbadk.core.util.at.isEmpty(this.kIK.getForum().getName())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dAF() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dAF().byG())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dAF() != null) {
                if (postData.dAF().atT() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.alg.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.alg.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.alg.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.alg.setLayoutParams(layoutParams3);
                }
            }
            if (this.kIK != null && aH(this.kIK.cYR())) {
                tVar.ail.setDataForPb(this.kIK.cYR().bhD(), this.kIK.cYR().getTid(), this.kIK.getForumId());
                if (postData.dAF() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dAF().byG())) {
                    tVar.ail.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.ail.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.ail.setVisibility(0);
            } else {
                tVar.ail.setVisibility(8);
            }
            if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYR().bgn() != null && this.kIK.cYR().bfQ() == null) {
                tVar.alg.setData(this.kIK.cYR().bgn());
                tVar.alg.setVisibility(0);
                if (this.kIK != null && this.kIK.getForum() != null) {
                    tVar.alg.setForumId(String.valueOf(this.kIK.getForum().getId()));
                }
                if (this.kIK != null && this.kIK.getThreadId() != null) {
                    tVar.alg.setThreadId(this.kIK.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.alg;
                AppletsCellView appletsCellView2 = tVar.alg;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.alg.setVisibility(8);
            }
            if (this.kIK != null && this.kIK.cYR() != null && (this.kIK.cYR().bfM() != 0 || this.kIK.cYR().bee())) {
                tVar.b(this.kIK, this.kIK.cYR().bfu() == 1, this.kIK.cYR().bft() == 1);
            }
            if (this.kIK != null && this.kIK.kFp != null) {
                if (tVar.kLc != null) {
                    if (TextUtils.isEmpty(this.kIK.kFp.cZF())) {
                        tVar.kLc.setVisibility(8);
                    } else {
                        tVar.kLc.setVisibility(0);
                        tVar.kLc.setText(this.kIK.kFp.cZF());
                    }
                }
                if (tVar.kLb != null && tVar.kLj.getRootView() == null) {
                    tVar.kLb.addView(tVar.kLj.H(this.kIK));
                    String fromPageKey = UtilHelper.getFromPageKey(this.kHX.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 1).bki();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 3).bki();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 2).bki();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 4).bki();
                        }
                    }
                }
            }
            if (tVar.kLd != null) {
                tVar.kLd.removeAllViews();
            }
            if (this.kIK != null && this.kIK.cYR() != null && !aH(this.kIK.cYR()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.kIK.cYR().bhE()) || !com.baidu.tbadk.core.util.y.isEmpty(this.kIK.cYR().bhF()))) {
                com.baidu.tbadk.util.ag agVar = new com.baidu.tbadk.util.ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.kIK, agVar.k(this.kIK.cYR().bhE(), this.kIK.cYR().bhF()), this.kIK.getForumName(), this.kHX, agVar.bwU());
                tVar.kLd.addView(pbLinkGoodsRootView);
                tVar.kLd.setVisibility(0);
                return;
            }
            tVar.kLd.setVisibility(8);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.kLf.setVisibility(0);
            if (tVar.kLg == null) {
                tVar.kLg = m(postData);
            }
            if (tVar.kLf.getChildCount() <= 0 && (view = tVar.kLg.getView()) != null) {
                tVar.kLf.addView(view);
            }
            tVar.kLg.a(this.kKR);
            tVar.kLg.a(this.kKS);
            tVar.kLg.g(postData.dAO());
            tVar.kLg.onChangeSkinType(this.kHX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dAO() != null && postData.dAO().beb()) {
            BaijiahaoData baijiahaoData = postData.dAO().oriUgcInfo;
            Item item = postData.dAO().item;
            if (postData.dAO().eav) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.kHX.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.kHX.getPageContext());
            } else if (baijiahaoData != null && postData.dAO().bei()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.kHX.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kHX.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kHX.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kHX.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.kHX.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dAO().showType == 0 || postData.dAO().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kHX.getPageContext(), this.pageFromType);
            } else if (postData.dAO().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kHX.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.kHX.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl()) && amVar.bdT() == com.baidu.tbadk.core.data.am.eaZ) {
            if (!amVar.bdU()) {
                tVar.kKX.getLayoutStrategy().rC(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.kLe.a(amVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dgO() == null) {
            tVar.kKq.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dgO(), tVar.kKq, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.kKX.setTextViewOnTouchListener(this.kKQ);
        tVar.kKX.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.kIS);
            tbRichTextView.getLayoutStrategy().ru(min);
            tbRichTextView.getLayoutStrategy().rv((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.kJM.setOnTouchListener(this.eHq);
        tVar.kJM.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.kKB.dbM().kIj;
        tVar.kKX.setOnLongClickListener(this.mOnLongClickListener);
        tVar.kKX.setOnTouchListener(this.kKQ);
        tVar.kKX.setCommonTextViewOnClickListener(this.aTZ);
        tVar.kKX.setOnImageClickListener(this.ffu);
        tVar.kKX.setOnImageTouchListener(this.kKQ);
        tVar.kKX.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.kKX.setOnEmotionClickListener(aVar.kYp);
        tVar.kKq.setOnClickListener(this.aTZ);
        tVar.kLh.setAfterItemClickListener(this.aTZ);
        tVar.kLi.setAfterItemClickListener(this.aTZ);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kIK = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.kIS = i;
    }

    public void sM(boolean z) {
        this.kIL = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kIU = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eHq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.kJA = cVar;
    }

    public void sZ(boolean z) {
        this.kKM = z;
    }

    public void release() {
        if (this.Vh != 0) {
            ((t) this.Vh).kLe.destroy();
            ((t) this.Vh).kLi.destroy();
        }
    }

    public void resume() {
        if (this.Vh != 0) {
            ((t) this.Vh).kLe.resume();
        }
    }

    public void pause() {
        if (this.Vh != 0) {
            ((t) this.Vh).kLe.pause();
        }
    }

    public t daM() {
        return (t) this.Vh;
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.bhD() == null || bwVar.bhD().getOptions() == null || bwVar.bhD().getOptions().size() <= 0) ? false : true;
    }
}
