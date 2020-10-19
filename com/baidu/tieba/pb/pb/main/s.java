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
    private View.OnClickListener aXk;
    private com.baidu.tieba.pb.a.c eTx;
    private TbRichTextView.i frJ;
    protected com.baidu.tieba.pb.data.f kXV;
    protected boolean kXW;
    private TbRichTextView.c kYL;
    private com.baidu.tieba.pb.pb.sub.b kYM;
    protected int kYd;
    private View.OnClickListener kYf;
    private boolean kZX;
    private boolean kZY;
    private final boolean kZZ;
    private boolean laa;
    private com.baidu.tieba.pb.a.c lab;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> lac;
    private b.a lad;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kYd = 0;
        this.kXW = true;
        this.kZX = true;
        this.kXV = null;
        this.kYM = null;
        this.kYf = null;
        this.aXk = null;
        this.frJ = null;
        this.eTx = null;
        this.mOnLongClickListener = null;
        this.kYL = null;
        this.kZY = false;
        this.kZZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.laa = false;
        this.pageFromType = 0;
        this.lab = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
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
                if (s.this.eTx != null) {
                    s.this.eTx.Z(view);
                    s.this.eTx.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.lac = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null && absThreadDataSupport.bfG().erY != null && s.this.kXV != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bfG().erY;
                    String threadId = s.this.kXV.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12602").dK("tid", threadId).dK("obj_source", str).aj("obj_type", i));
                    }
                }
            }
        };
        this.lad = new b.a() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null && absThreadDataSupport.bfG().erY != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.bfG().erY;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(s.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(s.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.ddQ() != null) {
            this.pageFromType = pbFragment.ddQ().dgy();
        }
    }

    private void a(t tVar) {
        if (tVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (tVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(tVar.eub, R.color.cp_bg_line_c);
                tVar.lai.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                tVar.alz.onChangeSkinType();
                if (tVar.las != null) {
                    tVar.las.onChangeSkinType();
                }
                if (tVar.lau != null) {
                    tVar.lau.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.lan, R.color.cp_cont_j);
                tVar.lav.uc(skinType);
                if (tVar.aiD != null) {
                    tVar.aiD.onChangeSkinType(skinType);
                }
            }
            tVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public t c(ViewGroup viewGroup) {
        t tVar = new t(this.kXi.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.kXW, this.kYd);
        a(tVar);
        tVar.lap.Fi(this.pageFromType);
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
            postData2.bjt();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kXi.getUniqueId(), this.kXV, postData2, postData2.locate, 1);
            b(tVar, postData2, view, i);
        }
        if (!this.kZY && this.kZZ && tVar != null && tVar.lai.bCk() && (listView = this.kXi.getListView()) != null) {
            this.kZY = true;
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
        if (this.kXV != null) {
            if (postData.dEp() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    tVar.lai.setOnClickListener(this.aXk);
                    tVar.lai.setTextViewOnClickListener(this.aXk);
                } else {
                    tVar.lai.setOnClickListener(null);
                    tVar.lai.setTextViewOnClickListener(null);
                }
                tVar.kYX.setOnClickListener(this.aXk);
            } else {
                tVar.kYX.setOnClickListener(null);
            }
            if (postData.dEp() == 1) {
                tVar.a(this.kXV, this.kXi.ddG(), postData.mER);
                a(tVar.lai, view, this.laa);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bih() != null) {
                    j = postData.bih().getUserIdLong();
                    str = postData.bih().getUserName();
                    str2 = postData.bih().getName_show();
                }
                if (this.kXV != null && this.kXV.dcA() != null) {
                    tVar.lap.a(postData.dEx(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kXV.dcA().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.kXi.deG().diI()) {
                    tVar.lai.setVisibility(8);
                }
                if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().bis() != null) {
                    ci bis = this.kXV.dcA().bis();
                    String bkC = bis.bkC();
                    if (!StringUtils.isNull(bis.bkD())) {
                        if (!StringUtils.isNull(bkC)) {
                            tVar.lak.setVisibility(0);
                            tVar.lak.startLoad(bkC, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    tVar.lak.setVisibility(8);
                }
                if (tVar.lal != null) {
                    tVar.lal.setVisibility(8);
                }
                if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().bgN() && tVar.las != null) {
                    tVar.las.setPadding(tVar.las.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), tVar.las.getPaddingRight(), tVar.las.getPaddingBottom());
                }
            }
            tVar.lai.getLayoutStrategy().rR(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dEp()));
            if (postData.dEt() > 0 && postData.dEm() != null && postData.dEm().size() > 0) {
                if (this.kYM == null) {
                    this.kYM = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.kYM.setIsFromCDN(this.mIsFromCDN);
                    this.kYM.W(this.kYf);
                    if (this.kXV != null) {
                        this.kYM.af(this.kXV.dcP(), TextUtils.equals(this.kXV.dcA().bih().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.kYM.setThreadData(this.kXV.dcA());
                    }
                }
                this.kYM.Pp(postData.getId());
            }
            tVar.lai.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            if (this.kXW) {
                tVar.lai.getLayoutStrategy().rU(R.drawable.transparent_bg);
            } else {
                tVar.lai.getLayoutStrategy().rU(R.drawable.icon_click);
            }
            tVar.lai.setIsFromCDN(this.mIsFromCDN);
            if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().isLinkThread()) {
                a(tVar, this.kXV.dcA().bjL());
            }
            boolean z7 = false;
            if (this.kXV != null && this.kXV.dcA() != null) {
                z7 = this.kXV.dcA().isShareThread && postData.dEA() != null;
            }
            if (z7) {
                if (postData.dEA().item != null) {
                    tVar.lai.getLayoutStrategy().sa(aT(R.dimen.tbds24));
                } else {
                    tVar.lai.getLayoutStrategy().sa(aT(R.dimen.tbds14));
                }
                a(tVar, postData);
            } else {
                tVar.lai.getLayoutStrategy().sa(aT(R.dimen.tbds24));
            }
            TbRichText dEr = postData.dEr();
            if (this.kXV != null && this.kXV.dda()) {
                dEr = null;
            }
            if (this.kXV.dcA() != null) {
                tVar.lai.setIsUseGridImage(this.kXV.dcA().bkc());
                tVar.lai.setmIsGridImageSupportLongPress(true);
            }
            if (this.kXV != null && 3 == this.kXV.ddg()) {
                if (this.kZY || !this.kZZ) {
                    tVar.lai.setText(dEr, false, this.kYL, true, false);
                } else {
                    tVar.lai.setText(dEr, true, this.kYL, true, false);
                }
            } else if (this.kZY || !this.kZZ) {
                tVar.lai.setText(dEr, false, this.kYL, false, true);
            } else {
                tVar.lai.setText(dEr, true, this.kYL, false, true);
            }
            a(tVar, postData, dEr);
            boolean z8 = !StringUtils.isNull(postData.bih().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.kXV != null && this.kXV.dcP() != 0) {
                if (this.kXV.dcP() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.bih() != null) {
                    String userId = postData.bih().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().bih() != null && postData.bih() != null) {
                String userId2 = this.kXV.dcA().bih().getUserId();
                String userId3 = postData.bih().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.bih() == null && UtilHelper.isCurrentAccount(postData.bih().getUserId())) {
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
                    if (postData.dEp() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.bih() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bih().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bih().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bih().getPortrait());
                        }
                        if (this.kXV != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kXV.dcP()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bih() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bih().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bih().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bih().getName_show());
                        }
                        if (this.kXV != null && this.kXV.dcA() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kXV.dcA().getId());
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
                        if (this.kXV != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kXV.dcP()));
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
            if (postData.bih() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dEp() == 1) {
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
            tVar.lai.setTag(sparseArray);
            tVar.kYX.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            tVar.lai.setIsHost(true);
            if (this.kZX) {
                tVar.eub.setVisibility(0);
            } else {
                tVar.eub.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kXW) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tVar.lai.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                tVar.lai.setLayoutParams(layoutParams);
                tVar.lai.Ed(null);
                this.laa = false;
                a(tVar, postData, view, i);
            } else {
                this.laa = true;
                tVar.lai.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.s.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void bCq() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.lai.getLayoutParams();
                        layoutParams2.topMargin = s.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = s.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        tVar.lai.setLayoutParams(layoutParams2);
                        s.this.a(tVar, postData, view, i);
                    }
                });
            }
            if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().bgN() && this.kXV.dcA().biz() != null && com.baidu.tbadk.core.util.at.isEmpty(this.kXV.getForum().getName())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dEr() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dEr().bBq())) {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                tVar.G(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dEr() != null) {
                if (postData.dEr().awE() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tVar.alz.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    tVar.alz.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tVar.alz.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    tVar.alz.setLayoutParams(layoutParams3);
                }
            }
            if (this.kXV != null && aH(this.kXV.dcA())) {
                tVar.aiD.setDataForPb(this.kXV.dcA().bkm(), this.kXV.dcA().getTid(), this.kXV.getForumId());
                if (postData.dEr() == null || com.baidu.tbadk.core.util.y.isEmpty(postData.dEr().bBq())) {
                    tVar.aiD.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    tVar.aiD.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                tVar.aiD.setVisibility(0);
            } else {
                tVar.aiD.setVisibility(8);
            }
            if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcA().biW() != null && this.kXV.dcA().biz() == null) {
                tVar.alz.setData(this.kXV.dcA().biW());
                tVar.alz.setVisibility(0);
                if (this.kXV != null && this.kXV.getForum() != null) {
                    tVar.alz.setForumId(String.valueOf(this.kXV.getForum().getId()));
                }
                if (this.kXV != null && this.kXV.getThreadId() != null) {
                    tVar.alz.setThreadId(this.kXV.getThreadId());
                }
                AppletsCellView appletsCellView = tVar.alz;
                AppletsCellView appletsCellView2 = tVar.alz;
                appletsCellView.setFrom("PB_card");
            } else {
                tVar.alz.setVisibility(8);
            }
            if (this.kXV != null && this.kXV.dcA() != null && (this.kXV.dcA().biv() != 0 || this.kXV.dcA().bgN())) {
                tVar.b(this.kXV, this.kXV.dcA().bid() == 1, this.kXV.dcA().bic() == 1);
            }
            if (this.kXV != null && this.kXV.kUA != null) {
                if (tVar.lan != null) {
                    if (TextUtils.isEmpty(this.kXV.kUA.ddo())) {
                        tVar.lan.setVisibility(8);
                    } else {
                        tVar.lan.setVisibility(0);
                        tVar.lan.setText(this.kXV.kUA.ddo());
                    }
                }
                if (tVar.lam != null && tVar.lav.getRootView() == null) {
                    tVar.lam.addView(tVar.lav.H(this.kXV));
                    String fromPageKey = UtilHelper.getFromPageKey(this.kXi.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 1).bmR();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 3).bmR();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 2).bmR();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.aq("c13445").aj("obj_source", 4).bmR();
                        }
                    }
                }
            }
            if (tVar.lao != null) {
                tVar.lao.removeAllViews();
            }
            if (this.kXV != null && this.kXV.dcA() != null && !aH(this.kXV.dcA()) && (!com.baidu.tbadk.core.util.y.isEmpty(this.kXV.dcA().bkn()) || !com.baidu.tbadk.core.util.y.isEmpty(this.kXV.dcA().bko()))) {
                com.baidu.tbadk.util.ag agVar = new com.baidu.tbadk.util.ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.kXV, agVar.k(this.kXV.dcA().bkn(), this.kXV.dcA().bko()), this.kXV.getForumName(), this.kXi, agVar.bzE());
                tVar.lao.addView(pbLinkGoodsRootView);
                tVar.lao.setVisibility(0);
                return;
            }
            tVar.lao.setVisibility(8);
        }
    }

    private void a(t tVar, PostData postData) {
        View view;
        if (tVar != null && postData != null) {
            tVar.laq.setVisibility(0);
            if (tVar.lar == null) {
                tVar.lar = m(postData);
            }
            if (tVar.laq.getChildCount() <= 0 && (view = tVar.lar.getView()) != null) {
                tVar.laq.addView(view);
            }
            tVar.lar.a(this.lac);
            tVar.lar.a(this.lad);
            tVar.lar.g(postData.dEA());
            tVar.lar.onChangeSkinType(this.kXi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dEA() != null && postData.dEA().bgK()) {
            BaijiahaoData baijiahaoData = postData.dEA().oriUgcInfo;
            Item item = postData.dEA().item;
            if (postData.dEA().emx) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.kXi.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.kXi.getPageContext());
            } else if (baijiahaoData != null && postData.dEA().bgR()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.kXi.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kXi.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kXi.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kXi.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.kXi.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dEA().showType == 0 || postData.dEA().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kXi.getPageContext(), this.pageFromType);
            } else if (postData.dEA().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kXi.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.kXi.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int aT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(t tVar, com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !com.baidu.tbadk.core.util.at.isEmpty(amVar.getLinkUrl()) && amVar.bgC() == com.baidu.tbadk.core.data.am.enb) {
            if (!amVar.bgD()) {
                tVar.lai.getLayoutStrategy().sa(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            tVar.lap.a(amVar);
        }
    }

    private void a(t tVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.dkx() == null) {
            tVar.kZB.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.dkx(), tVar.kZB, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(t tVar) {
        tVar.lai.setTextViewOnTouchListener(this.lab);
        tVar.lai.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.kYd);
            tbRichTextView.getLayoutStrategy().rS(min);
            tbRichTextView.getLayoutStrategy().rT((int) (min * 1.618f));
        }
    }

    private void c(t tVar) {
        tVar.kYX.setOnTouchListener(this.eTx);
        tVar.kYX.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.kZM.dfv().kXu;
        tVar.lai.setOnLongClickListener(this.mOnLongClickListener);
        tVar.lai.setOnTouchListener(this.lab);
        tVar.lai.setCommonTextViewOnClickListener(this.aXk);
        tVar.lai.setOnImageClickListener(this.frJ);
        tVar.lai.setOnImageTouchListener(this.lab);
        tVar.lai.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        tVar.lai.setOnEmotionClickListener(aVar.lnD);
        tVar.kZB.setOnClickListener(this.aXk);
        tVar.las.setAfterItemClickListener(this.aXk);
        tVar.lau.setAfterItemClickListener(this.aXk);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kXV = fVar;
    }

    public void setImageMaxWidth(int i) {
        this.kYd = i;
    }

    public void tt(boolean z) {
        this.kXW = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kYf = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eTx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.kYL = cVar;
    }

    public void tG(boolean z) {
        this.kZX = z;
    }

    public void release() {
        if (this.Vx != 0) {
            ((t) this.Vx).lap.destroy();
            ((t) this.Vx).lau.destroy();
        }
    }

    public void resume() {
        if (this.Vx != 0) {
            ((t) this.Vx).lap.resume();
        }
    }

    public void pause() {
        if (this.Vx != 0) {
            ((t) this.Vx).lap.pause();
        }
    }

    public t dev() {
        return (t) this.Vx;
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.bkm() == null || bwVar.bkm().getOptions() == null || bwVar.bkm().getOptions().size() <= 0) ? false : true;
    }
}
