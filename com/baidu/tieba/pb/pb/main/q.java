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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.cg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
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
/* loaded from: classes9.dex */
public class q extends m<PostData, r> {
    private View.OnClickListener aLl;
    private TbRichTextView.i eLw;
    private com.baidu.tieba.pb.a.c eor;
    private TbRichTextView.c kcZ;
    protected com.baidu.tieba.pb.data.e kck;
    protected boolean kcl;
    protected int kcs;
    private View.OnClickListener kcu;
    private boolean kdZ;
    private com.baidu.tieba.pb.pb.sub.b kda;
    private boolean kea;
    private final boolean keb;
    private boolean kec;
    private com.baidu.tieba.pb.a.c ked;
    private com.baidu.tieba.card.aa<AbsThreadDataSupport> kee;
    private b.a kef;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kcs = 0;
        this.kcl = true;
        this.kdZ = true;
        this.kck = null;
        this.kda = null;
        this.kcu = null;
        this.aLl = null;
        this.eLw = null;
        this.eor = null;
        this.mOnLongClickListener = null;
        this.kcZ = null;
        this.kea = false;
        this.keb = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.kec = false;
        this.pageFromType = 0;
        this.ked = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.eor != null) {
                    q.this.eor.T(view);
                    q.this.eor.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.kee = new com.baidu.tieba.card.aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.pb.pb.main.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                int i = 3;
                super.a(view, absThreadDataSupport);
                if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null && q.this.kck != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aPS().dNX;
                    String threadId = q.this.kck.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12602").dk("tid", threadId).dk("obj_source", str).ag("obj_type", i));
                    }
                }
            }
        };
        this.kef = new b.a() { // from class: com.baidu.tieba.pb.pb.main.q.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && absThreadDataSupport.aPS().dNX != null) {
                    OriginalThreadInfo originalThreadInfo = absThreadDataSupport.aPS().dNX;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(q.this.mContext);
                    pbActivityConfig.createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
                    pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.forumId));
                    pbActivityConfig.setStartFrom(q.this.pageFromType);
                    pbActivityConfig.setBjhData(originalThreadInfo.oriUgcInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
                }
            }
        };
        if (pbFragment != null && pbFragment.cIe() != null) {
            this.pageFromType = pbFragment.cIe().cKJ();
        }
    }

    private void a(r rVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (rVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.an.setBackgroundColor(rVar.dPI, R.color.cp_bg_line_c);
                rVar.kel.setTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_cont_b));
                rVar.ajv.onChangeSkinType();
                if (rVar.kev != null) {
                    rVar.kev.onChangeSkinType();
                }
                if (rVar.kew != null) {
                    rVar.kew.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.an.setViewTextColor(rVar.keq, (int) R.color.cp_cont_j);
                rVar.kex.qJ(skinType);
                if (rVar.agO != null) {
                    rVar.agO.onChangeSkinType(skinType);
                }
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public r b(ViewGroup viewGroup) {
        r rVar = new r(this.kbv.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.kcl, this.kcs);
        a(rVar);
        rVar.kes.Bi(this.pageFromType);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, r rVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) rVar);
        a(rVar);
        c(rVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.aTB();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.kbv.getUniqueId(), this.kck, postData2, postData2.locate, 1);
            b(rVar, postData2, view, i);
        }
        if (!this.kea && this.keb && rVar != null && rVar.kel.blH() && (listView = this.kbv.getListView()) != null) {
            this.kea = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:140:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0579  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(r rVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.kck != null) {
            if (postData.dhY() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.kel.setOnClickListener(this.aLl);
                    rVar.kel.setTextViewOnClickListener(this.aLl);
                } else {
                    rVar.kel.setOnClickListener(null);
                    rVar.kel.setTextViewOnClickListener(null);
                }
                rVar.kdj.setOnClickListener(this.aLl);
            } else {
                rVar.kdj.setOnClickListener(null);
            }
            if (postData.dhY() == 1) {
                rVar.a(this.kck, this.kbv.cHU(), postData.lGx);
                a(rVar.kel, view, this.kec);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aSp() != null) {
                    j = postData.aSp().getUserIdLong();
                    str = postData.aSp().getUserName();
                    str2 = postData.aSp().getName_show();
                }
                if (this.kck != null && this.kck.cGN() != null) {
                    rVar.kes.a(postData.dig(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kck.cGN().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                }
                if (this.kbv.cIU().cMS()) {
                    rVar.kel.setVisibility(8);
                }
                if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().aSA() != null) {
                    cg aSA = this.kck.cGN().aSA();
                    String aUK = aSA.aUK();
                    if (!StringUtils.isNull(aSA.aUL())) {
                        if (!StringUtils.isNull(aUK)) {
                            rVar.ken.setVisibility(0);
                            rVar.ken.startLoad(aUK, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.ken.setVisibility(8);
                }
                if (rVar.keo != null) {
                    rVar.keo.setVisibility(8);
                }
                if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().aQV() && rVar.kev != null) {
                    rVar.kev.setPadding(rVar.kev.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), rVar.kev.getPaddingRight(), rVar.kev.getPaddingBottom());
                }
            }
            rVar.kel.getLayoutStrategy().ox(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dhY()));
            if (postData.dic() > 0 && postData.dhV() != null && postData.dhV().size() > 0) {
                if (this.kda == null) {
                    this.kda = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                    this.kda.setIsFromCDN(this.mIsFromCDN);
                    this.kda.U(this.kcu);
                    if (this.kck != null) {
                        this.kda.ab(this.kck.cHc(), TextUtils.equals(this.kck.cGN().aSp().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.kda.setThreadData(this.kck.cGN());
                    }
                }
                this.kda.Kr(postData.getId());
            }
            rVar.kel.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_link_tip_c));
            if (this.kcl) {
                rVar.kel.getLayoutStrategy().oA(R.drawable.transparent_bg);
            } else {
                rVar.kel.getLayoutStrategy().oA(R.drawable.icon_click);
            }
            rVar.kel.setIsFromCDN(this.mIsFromCDN);
            if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().isLinkThread()) {
                a(rVar, this.kck.cGN().aTT());
            }
            boolean z7 = false;
            if (this.kck != null && this.kck.cGN() != null) {
                z7 = this.kck.cGN().isShareThread && postData.dij() != null;
            }
            if (z7) {
                if (postData.dij().item != null) {
                    rVar.kel.getLayoutStrategy().oG(bh(R.dimen.tbds24));
                } else {
                    rVar.kel.getLayoutStrategy().oG(bh(R.dimen.tbds14));
                }
                a(rVar, postData);
            } else {
                rVar.kel.getLayoutStrategy().oG(bh(R.dimen.tbds24));
            }
            TbRichText dia = postData.dia();
            if (this.kck != null && this.kck.cHm()) {
                dia = null;
            }
            if (this.kck.cGN() != null) {
                rVar.kel.setIsUseGridImage(this.kck.cGN().aUl());
                rVar.kel.setmIsGridImageSupportLongPress(true);
            }
            if (this.kck != null && 3 == this.kck.cHs()) {
                if (this.kea || !this.keb) {
                    rVar.kel.setText(dia, false, this.kcZ, true, false);
                } else {
                    rVar.kel.setText(dia, true, this.kcZ, true, false);
                }
            } else if (this.kea || !this.keb) {
                rVar.kel.setText(dia, false, this.kcZ, false, true);
            } else {
                rVar.kel.setText(dia, true, this.kcZ, false, true);
            }
            a(rVar, postData, dia);
            boolean z8 = !StringUtils.isNull(postData.aSp().getVirtualUserUrl());
            boolean z9 = false;
            boolean z10 = false;
            if (this.kck != null && this.kck.cHc() != 0) {
                if (this.kck.cHc() != 3) {
                    z9 = true;
                    z10 = true;
                }
                if (postData.aSp() != null) {
                    String userId = postData.aSp().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z9 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z9 = false;
                    }
                }
            }
            if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().aSp() != null && postData.aSp() != null) {
                String userId2 = this.kck.cGN().aSp().getUserId();
                String userId3 = postData.aSp().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aSp() == null && UtilHelper.isCurrentAccount(postData.aSp().getUserId())) {
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
                    if (postData.dhY() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z9) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aSp() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aSp().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aSp().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aSp().getPortrait());
                        }
                        if (this.kck != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kck.cHc()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aSp() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aSp().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aSp().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aSp().getName_show());
                        }
                        if (this.kck != null && this.kck.cGN() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kck.cGN().getId());
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
                        if (this.kck != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kck.cHc()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(rVar);
                }
            }
            z = false;
            z2 = z10;
            z3 = false;
            if (postData.aSp() == null) {
            }
            boolean z112 = z3;
            z4 = z2;
            z5 = z112;
            if (z8) {
            }
            int i22 = 1;
            if (postData.dhY() == 1) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z9) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(rVar);
        }
    }

    private void b(final r rVar, final PostData postData, final View view, final int i) {
        boolean z;
        if (rVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            rVar.kel.setTag(sparseArray);
            rVar.kdj.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            rVar.kel.setIsHost(true);
            if (this.kdZ) {
                rVar.dPI.setVisibility(0);
            } else {
                rVar.dPI.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kcl) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.kel.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.kel.setLayoutParams(layoutParams);
                rVar.kel.zx(null);
                this.kec = false;
                a(rVar, postData, view, i);
            } else {
                this.kec = true;
                rVar.kel.a(postData.getBimg_url(), new TbRichTextView.f() { // from class: com.baidu.tieba.pb.pb.main.q.4
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
                    public void blN() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.kel.getLayoutParams();
                        layoutParams2.topMargin = q.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = q.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        rVar.kel.setLayoutParams(layoutParams2);
                        q.this.a(rVar, postData, view, i);
                    }
                });
            }
            if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().aQV() && this.kck.cGN().aSH() != null && com.baidu.tbadk.core.util.ar.isEmpty(this.kck.getForum().getName())) {
                rVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.dia() == null || com.baidu.tbadk.core.util.w.isEmpty(postData.dia().bkO())) {
                rVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                rVar.D(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            }
            if (postData.dia() != null) {
                if (postData.dia().akg() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.ajv.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    rVar.ajv.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) rVar.ajv.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    rVar.ajv.setLayoutParams(layoutParams3);
                }
            }
            if (this.kck != null && aI(this.kck.cGN())) {
                rVar.agO.setDataForPb(this.kck.cGN().aUw(), this.kck.cGN().getTid(), this.kck.getForumId());
                if (postData.dia() == null || com.baidu.tbadk.core.util.w.isEmpty(postData.dia().bkO())) {
                    rVar.agO.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0));
                } else {
                    rVar.agO.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
                }
                rVar.agO.setVisibility(0);
            } else {
                rVar.agO.setVisibility(8);
            }
            if (this.kck != null && this.kck.cGN() != null && this.kck.cGN().aTe() != null && this.kck.cGN().aSH() == null) {
                rVar.ajv.setData(this.kck.cGN().aTe());
                rVar.ajv.setVisibility(0);
                if (this.kck != null && this.kck.getForum() != null) {
                    rVar.ajv.setForumId(String.valueOf(this.kck.getForum().getId()));
                }
                if (this.kck != null && this.kck.getThreadId() != null) {
                    rVar.ajv.setThreadId(this.kck.getThreadId());
                }
                AppletsCellView appletsCellView = rVar.ajv;
                AppletsCellView appletsCellView2 = rVar.ajv;
                appletsCellView.setFrom("PB_card");
            } else {
                rVar.ajv.setVisibility(8);
            }
            if (this.kck != null && this.kck.cGN() != null && (this.kck.cGN().aSD() != 0 || this.kck.cGN().aQV())) {
                rVar.b(this.kck, this.kck.cGN().aSl() == 1, this.kck.cGN().aSk() == 1);
            }
            if (this.kck != null && this.kck.jYN != null) {
                if (rVar.keq != null) {
                    if (TextUtils.isEmpty(this.kck.jYN.cHA())) {
                        rVar.keq.setVisibility(8);
                    } else {
                        rVar.keq.setVisibility(0);
                        rVar.keq.setText(this.kck.jYN.cHA());
                    }
                }
                if (rVar.kep != null && rVar.kex.getRootView() == null) {
                    rVar.kep.addView(rVar.kex.H(this.kck));
                    String fromPageKey = UtilHelper.getFromPageKey(this.kbv.getPageContext());
                    if (!(this.mContext instanceof PbActivity) || ((PbActivity) this.mContext).getIntent() == null) {
                        z = false;
                    } else {
                        z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false);
                        if (z) {
                            new com.baidu.tbadk.core.util.ao("c13445").ag("obj_source", 1).aWN();
                        }
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.ao("c13445").ag("obj_source", 3).aWN();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.ao("c13445").ag("obj_source", 2).aWN();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.ao("c13445").ag("obj_source", 4).aWN();
                        }
                    }
                }
            }
            if (rVar.ker != null) {
                rVar.ker.removeAllViews();
            }
            if (this.kck != null && this.kck.cGN() != null && !aI(this.kck.cGN()) && !com.baidu.tbadk.core.util.w.isEmpty(this.kck.cGN().aUx())) {
                for (final PbLinkData pbLinkData : this.kck.cGN().aUx()) {
                    SingleLinkCardView singleLinkCardView = new SingleLinkCardView(this.mContext);
                    singleLinkCardView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (!TextUtils.isEmpty(pbLinkData.linkUrl) && (q.this.mContext instanceof TbPageContextSupport)) {
                                bc.aWU().b(((TbPageContextSupport) q.this.mContext).getPageContext(), new String[]{pbLinkData.linkUrl});
                            }
                        }
                    });
                    singleLinkCardView.a(pbLinkData);
                    rVar.ker.addView(singleLinkCardView);
                    singleLinkCardView.setMarginTop(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
                }
                rVar.ker.setVisibility(0);
                return;
            }
            rVar.ker.setVisibility(8);
        }
    }

    private void a(r rVar, PostData postData) {
        View view;
        if (rVar != null && postData != null) {
            rVar.ket.setVisibility(0);
            if (rVar.keu == null) {
                rVar.keu = m(postData);
            }
            if (rVar.ket.getChildCount() <= 0 && (view = rVar.keu.getView()) != null) {
                rVar.ket.addView(view);
            }
            rVar.keu.a(this.kee);
            rVar.keu.a(this.kef);
            rVar.keu.g(postData.dij());
            rVar.keu.onChangeSkinType(this.kbv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private com.baidu.tieba.pb.pb.main.c.a m(PostData postData) {
        com.baidu.tieba.pb.pb.main.c.a aVar = null;
        if (postData != null && postData.dij() != null && postData.dij().aQS()) {
            BaijiahaoData baijiahaoData = postData.dij().oriUgcInfo;
            Item item = postData.dij().item;
            if (postData.dij().dID) {
                aVar = new com.baidu.tieba.pb.pb.main.c.d(this.kbv.getPageContext(), this.pageFromType);
            } else if (item != null && item.item_id.longValue() != 0) {
                aVar = new com.baidu.tieba.pb.pb.main.c.e(this.kbv.getPageContext());
            } else if (baijiahaoData != null && postData.dij().aQZ()) {
                switch (baijiahaoData.oriUgcType) {
                    case 1:
                        aVar = new com.baidu.tieba.pb.pb.main.c.b(this.kbv.getPageContext(), this.pageFromType);
                        break;
                    case 2:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kbv.getPageContext(), this.pageFromType);
                        break;
                    case 3:
                        aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kbv.getPageContext(), this.pageFromType);
                        break;
                    case 4:
                        aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kbv.getPageContext(), this.pageFromType);
                        break;
                    default:
                        aVar = new com.baidu.tieba.pb.pb.main.c.c(this.kbv.getPageContext(), this.pageFromType);
                        break;
                }
            } else if (postData.dij().showType == 0 || postData.dij().showType == 1) {
                aVar = new com.baidu.tieba.pb.pb.main.c.f(this.kbv.getPageContext(), this.pageFromType);
            } else if (postData.dij().showType == 3) {
                aVar = new com.baidu.tieba.pb.pb.main.c.g(this.kbv.getPageContext(), this.pageFromType);
            }
        }
        if (aVar == null) {
            return new com.baidu.tieba.pb.pb.main.c.c(this.kbv.getPageContext(), this.pageFromType);
        }
        return aVar;
    }

    private int bh(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ak akVar) {
        if (akVar != null && !com.baidu.tbadk.core.util.ar.isEmpty(akVar.getLinkUrl()) && akVar.aQK() == com.baidu.tbadk.core.data.ak.dJh) {
            if (!akVar.aQL()) {
                rVar.kel.getLayoutStrategy().oG(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            rVar.kes.a(akVar);
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.cOE() == null) {
            rVar.kdD.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.cOE(), rVar.kdD, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.kel.setTextViewOnTouchListener(this.ked);
        rVar.kel.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.kcs);
            tbRichTextView.getLayoutStrategy().oy(min);
            tbRichTextView.getLayoutStrategy().oz((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.kdj.setOnTouchListener(this.eor);
        rVar.kdj.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = this.kdO.cJI().kbH;
        rVar.kel.setOnLongClickListener(this.mOnLongClickListener);
        rVar.kel.setOnTouchListener(this.ked);
        rVar.kel.setCommonTextViewOnClickListener(this.aLl);
        rVar.kel.setOnImageClickListener(this.eLw);
        rVar.kel.setOnImageTouchListener(this.ked);
        rVar.kel.setmGridEmptyClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        rVar.kel.setOnEmotionClickListener(aVar.krb);
        rVar.kdD.setOnClickListener(this.aLl);
        rVar.kev.setAfterItemClickListener(this.aLl);
        rVar.kew.setAfterItemClickListener(this.aLl);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.kck = eVar;
    }

    public void setImageMaxWidth(int i) {
        this.kcs = i;
    }

    public void rr(boolean z) {
        this.kcl = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kcu = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eor = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.kcZ = cVar;
    }

    public void rE(boolean z) {
        this.kdZ = z;
    }

    public void release() {
        if (this.Up != 0) {
            ((r) this.Up).kes.destroy();
            ((r) this.Up).kew.destroy();
        }
    }

    public void resume() {
        if (this.Up != 0) {
            ((r) this.Up).kes.resume();
        }
    }

    public void pause() {
        if (this.Up != 0) {
            ((r) this.Up).kes.pause();
        }
    }

    public r cIJ() {
        return (r) this.Up;
    }

    private boolean aI(bu buVar) {
        return (buVar == null || buVar.aUw() == null || buVar.aUw().getOptions() == null || buVar.aUw().getOptions().size() <= 0) ? false : true;
    }
}
