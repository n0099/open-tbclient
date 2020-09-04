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
    private View.OnClickListener aRW;
    private com.baidu.tieba.pb.a.c eFj;
    private TbRichTextView.i fcC;
    protected com.baidu.tieba.pb.data.f kAn;
    protected boolean kAo;
    protected int kAv;
    private View.OnClickListener kAx;
    private TbRichTextView.c kBd;
    private com.baidu.tieba.pb.pb.sub.b kBe;
    private boolean kCo;
    private boolean kCp;
    private final boolean kCq;
    private boolean kCr;
    private com.baidu.tieba.pb.a.c kCs;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> kCt;
    private b.a kCu;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kAv = 0;
        this.kAo = true;
        this.kCo = true;
        this.kAn = null;
        this.kBe = null;
        this.kAx = null;
        this.aRW = null;
        this.fcC = null;
        this.eFj = null;
        this.mOnLongClickListener = null;
        this.kBd = null;
        this.kCp = false;
        this.kCq = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.kCr = false;
        this.pageFromType = 0;
        this.kCs = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.eFj != null) {
                    s.this.eFj.X(view);
                    s.this.eFj.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.kCt = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edI != null && s.this.kAn != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bce().edI;
                    String threadId = s.this.kAn.getThreadId();
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
        this.kCu = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edI != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bce().edI;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.cWE() != null) {
            this.pageFromType = pbFragment.cWE().cZm();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.efE, R.color.cp_bg_line_c);
                tVar.kCz.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                tVar.akH.onChangeSkinType();
                if (tVar.kCJ != null) {
                    tVar.kCJ.onChangeSkinType();
                }
                if (tVar.kCK != null) {
                    tVar.kCK.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.kCE, R.color.cp_cont_j);
                tVar.kCL.tl(skinType);
                if (tVar.ahQ != null) {
                    tVar.ahQ.onChangeSkinType(skinType);
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
        t tVar = new t(this.kzA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.kAo, this.kAv);
        a(tVar);
        tVar.kCG.Eb(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.kzA.getUniqueId(), this.kAn, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.kCp && this.kCq && tVar != null && tVar.kCz.byr() && (listView = this.kzA.getListView()) != null) {
            this.kCp = true;
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
        if (this.kAn != null) {
            if (postData.dwK() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.kCz.setOnClickListener(this.aRW);
                    tVar.kCz.setTextViewOnClickListener(this.aRW);
                } else {
                    tVar.kCz.setOnClickListener(null);
                    tVar.kCz.setTextViewOnClickListener(null);
                }
                tVar.kBo.setOnClickListener(this.aRW);
            } else {
                tVar.kBo.setOnClickListener(null);
            }
            if (postData.dwK() == 1) {
                tVar.a(this.kAn, this.kzA.cWu(), postData.mfM);
                a(tVar.kCz, view, this.kCr);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.beE() != null) {
                    j = postData.beE().getUserIdLong();
                    str = postData.beE().getUserName();
                    str2 = postData.beE().getName_show();
                }
                if (this.kAn != null && this.kAn.cVm() != null) {
                    tVar.kCG.a(postData.dwS(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kAn.cVm().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.kzA.cXu().dbw()) {
                    tVar.kCz.setVisibility(8);
                }
                if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().beP() != null) {
                    ci beP = this.kAn.cVm().beP();
                    String bgZ = beP.bgZ();
                    if (!StringUtils.isNull(beP.bha())) {
                        if (!StringUtils.isNull(bgZ)) {
                            tVar.kCB.setVisibility(0);
                            tVar.kCB.startLoad(bgZ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.kCB.setVisibility(8);
                }
                if (tVar.kCC != null) {
                    tVar.kCC.setVisibility(8);
                }
                if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().bdk() && tVar.kCJ != null) {
                    tVar.kCJ.setPadding(tVar.kCJ.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.kCJ.getPaddingRight(), tVar.kCJ.getPaddingBottom());
                }
            }
            tVar.kCz.getLayoutStrategy().rc(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dwK()));
            if (postData.dwO() > 0 && postData.dwH() != null && postData.dwH().size() > 0) {
                if (this.kBe == null) {
                    this.kBe = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.kBe.setIsFromCDN(this.mIsFromCDN);
                    this.kBe.W(this.kAx);
                    if (this.kAn != null) {
                        this.kBe.ac(this.kAn.cVB(), TextUtils.equals(this.kAn.cVm().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.kBe.setThreadData(this.kAn.cVm());
                    }
                }
                this.kBe.NZ(postData.getId());
            }
            tVar.kCz.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            if (this.kAo) {
                tVar.kCz.getLayoutStrategy().rf(R.drawable.transparent_bg);
            } else {
                tVar.kCz.getLayoutStrategy().rf(R.drawable.icon_click);
            }
            tVar.kCz.setIsFromCDN(this.mIsFromCDN);
            if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().isLinkThread()) {
                a(tVar, this.kAn.cVm().bgi());
            }
            boolean z7 = false;
            if (this.kAn != null && this.kAn.cVm() != null) {
                z7 = this.kAn.cVm().isShareThread && postData.dwV() != null;
            }
            if (z7) {
                if (postData.dwV().item != null) {
                    tVar.kCz.getLayoutStrategy().rl(aP(R.dimen.tbds24));
                } else {
                    tVar.kCz.getLayoutStrategy().rl(aP(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.kCz.getLayoutStrategy().rl(aP(R.dimen.tbds24));
            }
            TbRichText dwM = postData.dwM();
            if (this.kAn != null && this.kAn.cVM()) {
                dwM = null;
            }
            if (this.kAn.cVm() != null) {
                tVar.kCz.setIsUseGridImage(this.kAn.cVm().bgz());
                tVar.kCz.setmIsGridImageSupportLongPress(true);
            }
            if (this.kAn != null && 3 == this.kAn.cVS()) {
                if (this.kCp || !this.kCq) {
                    tVar.kCz.setText(dwM, false, this.kBd, true, false);
                } else {
                    tVar.kCz.setText(dwM, true, this.kBd, true, false);
                }
            } else if (this.kCp || !this.kCq) {
                tVar.kCz.setText(dwM, false, this.kBd, false, true);
            } else {
                tVar.kCz.setText(dwM, true, this.kBd, false, true);
            }
            a(tVar, postData, dwM);
            boolean z8 = !StringUtils.isNull(postData.beE().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.kAn != null && this.kAn.cVB() != 0) {
                if (this.kAn.cVB() != 3) {
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
            if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().beE() != null && postData.beE() != null) {
                String userId2 = this.kAn.cVm().beE().getUserId();
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
                    if (postData.dwK() == 1) {
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
                        if (this.kAn != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAn.cVB()));
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
                        if (this.kAn != null && this.kAn.cVm() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kAn.cVm().getId());
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
                        if (this.kAn != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAn.cVB()));
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
            if (postData.dwK() == 1) {
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
            tVar.kCz.setTag(sparseArray);
            tVar.kBo.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.kCz.setIsHost(true);
            if (this.kCo) {
                tVar.efE.setVisibility(0);
            } else {
                tVar.efE.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kAo) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.kCz.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.kCz.setLayoutParams(layoutParams);
                tVar.kCz.CV(null);
                this.kCr = false;
                a(tVar, postData, view, i);
            } else {
                this.kCr = true;
                tVar.kCz.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void byx() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.kCz.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.kCz.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().bdk() && this.kAn.cVm().beW() != null && com.baidu.tbadk.core.util.at.isEmpty(this.kAn.getForum().getName())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dwM() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dwM().bxx())) {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dwM() != null) {
                if (postData.dwM().atk() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.akH.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.akH.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.akH.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.akH.setLayoutParams(layoutParams3);
                }
            }
            if (this.kAn != null && aG(this.kAn.cVm())) {
                tVar.ahQ.setDataForPb(this.kAn.cVm().bgJ(), this.kAn.cVm().getTid(), this.kAn.getForumId());
                if (postData.dwM() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dwM().bxx())) {
                    tVar.ahQ.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.ahQ.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.ahQ.setVisibility(0);
            } else {
                tVar.ahQ.setVisibility(8);
            }
            if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVm().bft() != null && this.kAn.cVm().beW() == null) {
                tVar.akH.setData(this.kAn.cVm().bft());
                tVar.akH.setVisibility(0);
                if (this.kAn != null && this.kAn.getForum() != null) {
                    tVar.akH.setForumId(String.valueOf(this.kAn.getForum().getId()));
                }
                if (this.kAn != null && this.kAn.getThreadId() != null) {
                    tVar.akH.setThreadId(this.kAn.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.akH;
                AppletsCellView appletsCellView2 = tVar.akH;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.akH.setVisibility(8);
            }
            if (this.kAn != null && this.kAn.cVm() != null && (this.kAn.cVm().beS() != 0 || this.kAn.cVm().bdk())) {
                tVar.b(this.kAn, this.kAn.cVm().beA() == 1, this.kAn.cVm().bez() == 1);
            }
            if (this.kAn != null && this.kAn.kwQ != null) {
                if (tVar.kCE != null) {
                    if (TextUtils.isEmpty(this.kAn.kwQ.cWa())) {
                        tVar.kCE.setVisibility(8);
                    } else {
                        tVar.kCE.setVisibility(0);
                        tVar.kCE.setText(this.kAn.kwQ.cWa());
                    }
                }
                if (tVar.kCD != null && tVar.kCL.getRootView() == null) {
                    tVar.kCD.addView(tVar.kCL.H(this.kAn));
                    String fromPageKey = UtilHelper.getFromPageKey(this.kzA.getPageContext());
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
            if (tVar.kCF != null) {
                tVar.kCF.removeAllViews();
            }
            if (this.kAn != null && this.kAn.cVm() != null && !aG(this.kAn.cVm()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.kAn.cVm().bgK()) || !com.baidu.tbadk.core.util.y.isEmpty(this.kAn.cVm().bgL()))) {
                com.baidu.tbadk.util.af afVar = new com.baidu.tbadk.util.af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.kAn, afVar.j(this.kAn.cVm().bgK(), this.kAn.cVm().bgL()), this.kAn.getForumName(), this.kzA, afVar.bvL());
                tVar.kCF.addView(pbLinkGoodsRootView);
                tVar.kCF.setVisibility(0);
                return;
            }
            tVar.kCF.setVisibility(8);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.kCH.setVisibility(0);
            if (tVar.kCI == null) {
                tVar.kCI = m(postData);
            }
            if (tVar.kCH.getChildCount() <= 0 && (view = tVar.kCI.getView()) != null) {
                tVar.kCH.addView(view);
            }
            tVar.kCI.a(this.kCt);
            tVar.kCI.a(this.kCu);
            tVar.kCI.g(postData.dwV());
            tVar.kCI.onChangeSkinType(this.kzA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dwV() != null && postData.dwV().bdh()) {
            BaijiahaoData baijiahaoData = postData.dwV().oriUgcInfo;
            Item item = postData.dwV().item;
            if (postData.dwV().dYl) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.kzA.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.kzA.getPageContext());
            } else if (baijiahaoData != null && postData.dwV().bdo()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.kzA.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kzA.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kzA.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kzA.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.kzA.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dwV().showType == 0 || postData.dwV().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kzA.getPageContext(), this.pageFromType);
            } else if (postData.dwV().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kzA.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.kzA.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int aP(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl()) && amVar.bcZ() == com.baidu.tbadk.core.data.am.dYP) {
            if (!amVar.bda()) {
                tVar.kCz.getLayoutStrategy().rl(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.kCG.a(amVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.ddk() == null) {
            tVar.kBS.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.ddk(), tVar.kBS, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.kCz.setTextViewOnTouchListener(this.kCs);
        tVar.kCz.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.kAv);
            tbRichTextView.getLayoutStrategy().rd(min);
            tbRichTextView.getLayoutStrategy().re((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.kBo.setOnTouchListener(this.eFj);
        tVar.kBo.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.kCd.cYj().kzM;
        tVar.kCz.setOnLongClickListener(this.mOnLongClickListener);
        tVar.kCz.setOnTouchListener(this.kCs);
        tVar.kCz.setCommonTextViewOnClickListener(this.aRW);
        tVar.kCz.setOnImageClickListener(this.fcC);
        tVar.kCz.setOnImageTouchListener(this.kCs);
        tVar.kCz.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.kCz.setOnEmotionClickListener(aVar.kPN);
        tVar.kBS.setOnClickListener(this.aRW);
        tVar.kCJ.setAfterItemClickListener(this.aRW);
        tVar.kCK.setAfterItemClickListener(this.aRW);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAn = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.kAv = i;
    }

    public void sF(boolean z) {
        this.kAo = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAx = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.kBd = cVar;
    }

    public void sS(boolean z) {
        this.kCo = z;
    }

    public void release() {
        if (this.UO != 0) {
            ((t) this.UO).kCG.destroy();
            ((t) this.UO).kCK.destroy();
        }
    }

    public void resume() {
        if (this.UO != 0) {
            ((t) this.UO).kCG.resume();
        }
    }

    public void pause() {
        if (this.UO != 0) {
            ((t) this.UO).kCG.pause();
        }
    }

    public t cXj() {
        return (t) this.UO;
    }

    private boolean aG(bw bwVar) {
        return (bwVar == null || bwVar.bgJ() == null || bwVar.bgJ().getOptions() == null || bwVar.bgJ().getOptions().size() <= 0) ? false : true;
    }
}
