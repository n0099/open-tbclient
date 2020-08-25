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
/* loaded from: classes16.dex */
public class s extends o<PostData, t> {
    private View.OnClickListener aRU;
    private com.baidu.tieba.pb.a.c eFf;
    private TbRichTextView.i fcy;
    private TbRichTextView.c kAW;
    private com.baidu.tieba.pb.pb.sub.b kAX;
    protected com.baidu.tieba.pb.data.f kAg;
    protected boolean kAh;
    protected int kAo;
    private View.OnClickListener kAq;
    private boolean kCh;
    private boolean kCi;
    private final boolean kCj;
    private boolean kCk;
    private com.baidu.tieba.pb.a.c kCl;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> kCm;
    private b.a kCn;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kAo = 0;
        this.kAh = true;
        this.kCh = true;
        this.kAg = null;
        this.kAX = null;
        this.kAq = null;
        this.aRU = null;
        this.fcy = null;
        this.eFf = null;
        this.mOnLongClickListener = null;
        this.kAW = null;
        this.kCi = false;
        this.kCj = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.kCk = false;
        this.pageFromType = 0;
        this.kCl = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.eFf != null) {
                    s.this.eFf.X(view);
                    s.this.eFf.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.kCm = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null && s.this.kAg != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bce().edE;
                    String threadId = s.this.kAg.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12602").dD("tid", threadId).dD("obj_source", str).ai("obj_type", i));
                    }
                }
            }
        };
        this.kCn = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bce().edE;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.cWD() != null) {
            this.pageFromType = pbFragment.cWD().cZl();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.efA, R.color.cp_bg_line_c);
                tVar.kCs.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                tVar.akF.onChangeSkinType();
                if (tVar.kCC != null) {
                    tVar.kCC.onChangeSkinType();
                }
                if (tVar.kCD != null) {
                    tVar.kCD.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.kCx, R.color.cp_cont_j);
                tVar.kCE.tl(skinType);
                if (tVar.ahO != null) {
                    tVar.ahO.onChangeSkinType(skinType);
                }
            }
            tVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public t b(ViewGroup viewGroup) {
        t tVar = new t(this.kzt.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.kAh, this.kAo);
        a(tVar);
        tVar.kCz.Eb(this.pageFromType);
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
            postData2.bfQ();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kzt.getUniqueId(), this.kAg, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.kCi && this.kCj && tVar != null && tVar.kCs.byq() && (listView = this.kzt.getListView()) != null) {
            this.kCi = true;
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
        if (this.kAg != null) {
            if (postData.dwF() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.kCs.setOnClickListener(this.aRU);
                    tVar.kCs.setTextViewOnClickListener(this.aRU);
                } else {
                    tVar.kCs.setOnClickListener(null);
                    tVar.kCs.setTextViewOnClickListener(null);
                }
                tVar.kBh.setOnClickListener(this.aRU);
            } else {
                tVar.kBh.setOnClickListener(null);
            }
            if (postData.dwF() == 1) {
                tVar.a(this.kAg, this.kzt.cWt(), postData.mfx);
                a(tVar.kCs, view, this.kCk);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.beE() != null) {
                    j = postData.beE().getUserIdLong();
                    str = postData.beE().getUserName();
                    str2 = postData.beE().getName_show();
                }
                if (this.kAg != null && this.kAg.cVl() != null) {
                    tVar.kCz.a(postData.dwN(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kAg.cVl().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.kzt.cXt().dbv()) {
                    tVar.kCs.setVisibility(8);
                }
                if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().beP() != null) {
                    ci beP = this.kAg.cVl().beP();
                    String bgZ = beP.bgZ();
                    if (!StringUtils.isNull(beP.bha())) {
                        if (!StringUtils.isNull(bgZ)) {
                            tVar.kCu.setVisibility(0);
                            tVar.kCu.startLoad(bgZ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.kCu.setVisibility(8);
                }
                if (tVar.kCv != null) {
                    tVar.kCv.setVisibility(8);
                }
                if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().bdk() && tVar.kCC != null) {
                    tVar.kCC.setPadding(tVar.kCC.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.kCC.getPaddingRight(), tVar.kCC.getPaddingBottom());
                }
            }
            tVar.kCs.getLayoutStrategy().rc(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dwF()));
            if (postData.dwJ() > 0 && postData.dwC() != null && postData.dwC().size() > 0) {
                if (this.kAX == null) {
                    this.kAX = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.kAX.setIsFromCDN(this.mIsFromCDN);
                    this.kAX.W(this.kAq);
                    if (this.kAg != null) {
                        this.kAX.ac(this.kAg.cVA(), TextUtils.equals(this.kAg.cVl().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.kAX.setThreadData(this.kAg.cVl());
                    }
                }
                this.kAX.NY(postData.getId());
            }
            tVar.kCs.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            if (this.kAh) {
                tVar.kCs.getLayoutStrategy().rf(R.drawable.transparent_bg);
            } else {
                tVar.kCs.getLayoutStrategy().rf(R.drawable.icon_click);
            }
            tVar.kCs.setIsFromCDN(this.mIsFromCDN);
            if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().isLinkThread()) {
                a(tVar, this.kAg.cVl().bgi());
            }
            boolean z7 = false;
            if (this.kAg != null && this.kAg.cVl() != null) {
                z7 = this.kAg.cVl().isShareThread && postData.dwQ() != null;
            }
            if (z7) {
                if (postData.dwQ().item != null) {
                    tVar.kCs.getLayoutStrategy().rl(aP(R.dimen.tbds24));
                } else {
                    tVar.kCs.getLayoutStrategy().rl(aP(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.kCs.getLayoutStrategy().rl(aP(R.dimen.tbds24));
            }
            TbRichText dwH = postData.dwH();
            if (this.kAg != null && this.kAg.cVL()) {
                dwH = null;
            }
            if (this.kAg.cVl() != null) {
                tVar.kCs.setIsUseGridImage(this.kAg.cVl().bgz());
                tVar.kCs.setmIsGridImageSupportLongPress(true);
            }
            if (this.kAg != null && 3 == this.kAg.cVR()) {
                if (this.kCi || !this.kCj) {
                    tVar.kCs.setText(dwH, false, this.kAW, true, false);
                } else {
                    tVar.kCs.setText(dwH, true, this.kAW, true, false);
                }
            } else if (this.kCi || !this.kCj) {
                tVar.kCs.setText(dwH, false, this.kAW, false, true);
            } else {
                tVar.kCs.setText(dwH, true, this.kAW, false, true);
            }
            a(tVar, postData, dwH);
            boolean z8 = !StringUtils.isNull(postData.beE().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.kAg != null && this.kAg.cVA() != 0) {
                if (this.kAg.cVA() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.beE() != null) {
                    String userId = postData.beE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().beE() != null && postData.beE() != null) {
                String userId2 = this.kAg.cVl().beE().getUserId();
                String userId3 = postData.beE().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.beE() == null && UtilHelper.isCurrentAccount(postData.beE().getUserId())) {
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
                    if (postData.dwF() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.beE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.beE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.beE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.beE().getPortrait());
                        }
                        if (this.kAg != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAg.cVA()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.beE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.beE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.beE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.beE().getName_show());
                        }
                        if (this.kAg != null && this.kAg.cVl() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kAg.cVl().getId());
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
                        if (this.kAg != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAg.cVA()));
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
            if (postData.beE() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dwF() == 1) {
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
            tVar.kCs.setTag(sparseArray);
            tVar.kBh.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.kCs.setIsHost(true);
            if (this.kCh) {
                tVar.efA.setVisibility(0);
            } else {
                tVar.efA.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kAh) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.kCs.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.kCs.setLayoutParams(layoutParams);
                tVar.kCs.CU(null);
                this.kCk = false;
                a(tVar, postData, view, i);
            } else {
                this.kCk = true;
                tVar.kCs.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void byw() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.kCs.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.kCs.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().bdk() && this.kAg.cVl().beW() != null && com.baidu.tbadk.core.util.at.isEmpty(this.kAg.getForum().getName())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dwH() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dwH().bxw())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dwH() != null) {
                if (postData.dwH().atk() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.akF.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.akF.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.akF.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.akF.setLayoutParams(layoutParams3);
                }
            }
            if (this.kAg != null && aG(this.kAg.cVl())) {
                tVar.ahO.setDataForPb(this.kAg.cVl().bgJ(), this.kAg.cVl().getTid(), this.kAg.getForumId());
                if (postData.dwH() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dwH().bxw())) {
                    tVar.ahO.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.ahO.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.ahO.setVisibility(0);
            } else {
                tVar.ahO.setVisibility(8);
            }
            if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().bft() != null && this.kAg.cVl().beW() == null) {
                tVar.akF.setData(this.kAg.cVl().bft());
                tVar.akF.setVisibility(0);
                if (this.kAg != null && this.kAg.getForum() != null) {
                    tVar.akF.setForumId(String.valueOf(this.kAg.getForum().getId()));
                }
                if (this.kAg != null && this.kAg.getThreadId() != null) {
                    tVar.akF.setThreadId(this.kAg.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.akF;
                AppletsCellView appletsCellView2 = tVar.akF;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.akF.setVisibility(8);
            }
            if (this.kAg != null && this.kAg.cVl() != null && (this.kAg.cVl().beS() != 0 || this.kAg.cVl().bdk())) {
                tVar.b(this.kAg, this.kAg.cVl().beA() == 1, this.kAg.cVl().bez() == 1);
            }
            if (this.kAg != null && this.kAg.kwJ != null) {
                if (tVar.kCx != null) {
                    if (TextUtils.isEmpty(this.kAg.kwJ.cVZ())) {
                        tVar.kCx.setVisibility(8);
                    } else {
                        tVar.kCx.setVisibility(0);
                        tVar.kCx.setText(this.kAg.kwJ.cVZ());
                    }
                }
                if (tVar.kCw != null && tVar.kCE.getRootView() == null) {
                    tVar.kCw.addView(tVar.kCE.H(this.kAg));
                    String fromPageKey = UtilHelper.getFromPageKey(this.kzt.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 1).bjn();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 3).bjn();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 2).bjn();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").ai("obj_source", 4).bjn();
                        }
                    }
                }
            }
            if (tVar.kCy != null) {
                tVar.kCy.removeAllViews();
            }
            if (this.kAg != null && this.kAg.cVl() != null && !aG(this.kAg.cVl()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.kAg.cVl().bgK()) || !com.baidu.tbadk.core.util.y.isEmpty(this.kAg.cVl().bgL()))) {
                com.baidu.tbadk.util.af afVar = new com.baidu.tbadk.util.af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.kAg, afVar.j(this.kAg.cVl().bgK(), this.kAg.cVl().bgL()), this.kAg.getForumName(), this.kzt, afVar.bvK());
                tVar.kCy.addView(pbLinkGoodsRootView);
                tVar.kCy.setVisibility(0);
                return;
            }
            tVar.kCy.setVisibility(8);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.kCA.setVisibility(0);
            if (tVar.kCB == null) {
                tVar.kCB = m(postData);
            }
            if (tVar.kCA.getChildCount() <= 0 && (view = tVar.kCB.getView()) != null) {
                tVar.kCA.addView(view);
            }
            tVar.kCB.a(this.kCm);
            tVar.kCB.a(this.kCn);
            tVar.kCB.g(postData.dwQ());
            tVar.kCB.onChangeSkinType(this.kzt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dwQ() != null && postData.dwQ().bdh()) {
            BaijiahaoData baijiahaoData = postData.dwQ().oriUgcInfo;
            Item item = postData.dwQ().item;
            if (postData.dwQ().dYh) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.kzt.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.kzt.getPageContext());
            } else if (baijiahaoData != null && postData.dwQ().bdo()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.kzt.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kzt.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kzt.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kzt.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.kzt.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dwQ().showType == 0 || postData.dwQ().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kzt.getPageContext(), this.pageFromType);
            } else if (postData.dwQ().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kzt.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.kzt.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int aP(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl()) && amVar.bcZ() == com.baidu.tbadk.core.data.am.dYL) {
            if (!amVar.bda()) {
                tVar.kCs.getLayoutStrategy().rl(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.kCz.a(amVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.ddj() == null) {
            tVar.kBL.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.ddj(), tVar.kBL, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.kCs.setTextViewOnTouchListener(this.kCl);
        tVar.kCs.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.kAo);
            tbRichTextView.getLayoutStrategy().rd(min);
            tbRichTextView.getLayoutStrategy().re((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.kBh.setOnTouchListener(this.eFf);
        tVar.kBh.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.kBW.cYi().kzF;
        tVar.kCs.setOnLongClickListener(this.mOnLongClickListener);
        tVar.kCs.setOnTouchListener(this.kCl);
        tVar.kCs.setCommonTextViewOnClickListener(this.aRU);
        tVar.kCs.setOnImageClickListener(this.fcy);
        tVar.kCs.setOnImageTouchListener(this.kCl);
        tVar.kCs.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.kCs.setOnEmotionClickListener(aVar.kPG);
        tVar.kBL.setOnClickListener(this.aRU);
        tVar.kCC.setAfterItemClickListener(this.aRU);
        tVar.kCD.setAfterItemClickListener(this.aRU);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAg = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.kAo = i;
    }

    public void sD(boolean z) {
        this.kAh = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAq = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.kAW = cVar;
    }

    public void sQ(boolean z) {
        this.kCh = z;
    }

    public void release() {
        if (this.UO != 0) {
            ((t) this.UO).kCz.destroy();
            ((t) this.UO).kCD.destroy();
        }
    }

    public void resume() {
        if (this.UO != 0) {
            ((t) this.UO).kCz.resume();
        }
    }

    public void pause() {
        if (this.UO != 0) {
            ((t) this.UO).kCz.pause();
        }
    }

    public t cXi() {
        return (t) this.UO;
    }

    private boolean aG(bw bwVar) {
        return (bwVar == null || bwVar.bgJ() == null || bwVar.bgJ().getOptions() == null || bwVar.bgJ().getOptions().size() <= 0) ? false : true;
    }
}
