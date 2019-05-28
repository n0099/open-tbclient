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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class o extends k<PostData, p> {
    private TbRichTextView.h cIM;
    private com.baidu.tieba.pb.a.c ckg;
    private View.OnLongClickListener clk;
    protected com.baidu.tieba.pb.data.d hGE;
    protected boolean hGF;
    protected int hGM;
    private View.OnClickListener hGO;
    private boolean hHX;
    private boolean hHY;
    private final boolean hHZ;
    private TbRichTextView.c hHf;
    private com.baidu.tieba.pb.pb.sub.c hHg;
    private boolean hIa;
    private com.baidu.tieba.pb.a.c hIb;
    private OriginalThreadCardView.a hIc;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hGM = 0;
        this.hGF = true;
        this.hHX = true;
        this.hGE = null;
        this.hHg = null;
        this.hGO = null;
        this.mCommonClickListener = null;
        this.cIM = null;
        this.ckg = null;
        this.clk = null;
        this.hHf = null;
        this.hHY = false;
        this.hHZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hIa = false;
        this.pageFromType = 0;
        this.hIb = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                if (o.this.ckg != null) {
                    o.this.ckg.cq(view);
                    o.this.ckg.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hIc = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hGE != null) {
                    String threadId = o.this.hGE.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12602").bT("tid", threadId).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).P("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bQR() != null) {
            this.pageFromType = pbActivity.bQR().bTq();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.al.l(pVar.bMQ, R.color.cp_bg_line_c);
                pVar.hIi.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_b));
                pVar.YB.onChangeSkinType();
                if (pVar.hIo != null) {
                    pVar.hIo.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.al.j(pVar.hIm, R.color.cp_cont_j);
                pVar.hIp.nq(skinType);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.hGp.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.hGF, this.hGM);
        a(pVar);
        pVar.hIn.xo(this.pageFromType);
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, p pVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, pVar);
        a(pVar);
        c(pVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.aez();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hGp.getUniqueId(), this.hGE, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hHY && this.hHZ && pVar != null && pVar.hIi.ayp() && (listView = ((PbActivity) this.hGp.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hHY = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(p pVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.hGE != null) {
            if (postData.cmw() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hIi.setOnClickListener(this.mCommonClickListener);
                    pVar.hIi.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hIi.setOnClickListener(null);
                    pVar.hIi.setTextViewOnClickListener(null);
                }
                pVar.hHl.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hHl.setOnClickListener(null);
            }
            if (postData.cmw() == 1) {
                pVar.b(this.hGE, this.hGp.bQH());
                a(pVar.hIi, view, this.hIa);
                pVar.hIf.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.adv() != null) {
                    j = postData.adv().getUserIdLong();
                    str = postData.adv().getUserName();
                    str2 = postData.adv().getName_show();
                }
                if (this.hGE != null && this.hGE.bPL() != null) {
                    pVar.hIn.a(postData.cmE(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hGE.bPL().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                if (this.hGp.bRh().bVi()) {
                    pVar.hIi.setVisibility(8);
                }
                if (this.hGE != null && this.hGE.bPL() != null && this.hGE.bPL().adH() != null) {
                    bp adH = this.hGE.bPL().adH();
                    adH.getActivityUrl();
                    String afB = adH.afB();
                    if (!StringUtils.isNull(adH.afC())) {
                        if (!StringUtils.isNull(afB)) {
                            pVar.hIk.setVisibility(0);
                            pVar.hIk.startLoad(afB, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hIk.setVisibility(8);
                }
                if (pVar.hIl != null) {
                    pVar.hIl.setVisibility(8);
                }
                if (this.hGE != null && this.hGE.bPL() != null && this.hGE.bPL().aep() && pVar.hIo != null) {
                    pVar.hIo.setPadding(pVar.hIo.getPaddingLeft(), com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pVar.hIo.getPaddingRight(), pVar.hIo.getPaddingBottom());
                }
            }
            pVar.hIi.getLayoutStrategy().lm(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cmw()));
            if (postData.cmA() > 0 && postData.cmt() != null && postData.cmt().size() > 0) {
                if (this.hHg == null) {
                    this.hHg = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hHg.setIsFromCDN(this.mIsFromCDN);
                    this.hHg.O(this.hGO);
                    if (this.hGE != null) {
                        this.hHg.M(this.hGE.bPX(), TextUtils.equals(this.hGE.bPL().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hHg.ai(this.hGE.bPL());
                    }
                }
                this.hHg.BB(postData.getId());
            }
            pVar.hIi.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            if (this.hGF) {
                pVar.hIi.getLayoutStrategy().lp(R.drawable.transparent_bg);
            } else {
                pVar.hIi.getLayoutStrategy().lp(R.drawable.icon_click);
            }
            pVar.hIi.setIsFromCDN(this.mIsFromCDN);
            if (this.hGE != null && this.hGE.bPL() != null && this.hGE.bPL().isLinkThread()) {
                a(pVar, this.hGE.bPL().aeU());
            }
            a(pVar, postData);
            TbRichText cmy = postData.cmy();
            if (this.hGE != null && this.hGE.bQj()) {
                cmy = null;
            }
            if (this.hHY || !this.hHZ) {
                pVar.hIi.setText(cmy, false, this.hHf);
            } else {
                pVar.hIi.setText(cmy, true, this.hHf);
            }
            a(pVar, postData, cmy);
            boolean z7 = !StringUtils.isNull(postData.adv().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hGE != null && this.hGE.bPX() != 0) {
                if (this.hGE.bPX() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.adv() != null) {
                    String userId = postData.adv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hGE != null && this.hGE.bPL() != null && this.hGE.bPL().adv() != null && postData.adv() != null) {
                String userId2 = this.hGE.bPL().adv().getUserId();
                String userId3 = postData.adv().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.adv() == null && UtilHelper.isCurrentAccount(postData.adv().getUserId())) {
                        z4 = true;
                        z5 = true;
                    } else {
                        boolean z10 = z3;
                        z4 = z2;
                        z5 = z10;
                    }
                    if (z7) {
                        z6 = z4;
                    } else {
                        z8 = false;
                        z6 = false;
                        z = false;
                    }
                    int i2 = 1;
                    if (postData.cmw() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.adv() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.adv().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.adv().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.adv().getPortrait());
                        }
                        if (this.hGE != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGE.bPX()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.adv() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.adv().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.adv().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.adv().getName_show());
                        }
                        if (this.hGE != null && this.hGE.bPL() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hGE.bPL().getId());
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
                        if (this.hGE != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGE.bPX()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, false);
                    }
                    b(pVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.adv() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.cmw() == 1) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(pVar);
        }
    }

    private void b(final p pVar, final PostData postData, final View view, final int i) {
        boolean z = false;
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.hIi.setTag(sparseArray);
            pVar.hHl.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pVar.hIi.setIsHost(true);
            if (this.hHX) {
                pVar.bMQ.setVisibility(0);
            } else {
                pVar.bMQ.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGF) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hIi.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hIi.setLayoutParams(layoutParams);
                pVar.hIi.rl(null);
                this.hIa = false;
                a(pVar, postData, view, i);
            } else {
                this.hIa = true;
                pVar.hIi.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void ayu() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hIi.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hIi.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hGE != null && this.hGE.bPL() != null && this.hGE.bPL().aep() && this.hGE.bPL().adM() != null && com.baidu.tbadk.core.util.ap.isEmpty(this.hGE.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cmy() == null || com.baidu.tbadk.core.util.v.aa(postData.cmy().axz())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cmy() != null) {
                if (postData.cmy().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.YB.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pVar.YB.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.YB.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pVar.YB.setLayoutParams(layoutParams3);
                }
            }
            if (this.hGE.bPL() != null && this.hGE.bPL().aeh() != null && this.hGE.bPL().adM() == null) {
                pVar.YB.setVisibility(0);
                pVar.YB.setData(this.hGE.bPL().aeh());
                if (this.hGE.getForum() != null) {
                    pVar.YB.setForumId(String.valueOf(this.hGE.getForum().getId()));
                }
                if (this.hGE.getThreadId() != null) {
                    pVar.YB.setThreadId(this.hGE.getThreadId());
                }
                AppletsCellView appletsCellView = pVar.YB;
                AppletsCellView appletsCellView2 = pVar.YB;
                appletsCellView.setFrom("PB_card");
            } else {
                pVar.YB.setVisibility(8);
            }
            if (this.hGE != null && this.hGE.bPL() != null && (this.hGE.bPL().adK() != 0 || this.hGE.bPL().aep())) {
                pVar.T(this.hGE.bPL().adr() == 1, this.hGE.bPL().adq() == 1);
            }
            if (this.hGE != null && this.hGE.hBG != null) {
                if (pVar.hIm != null) {
                    if (TextUtils.isEmpty(this.hGE.hBG.bQq())) {
                        pVar.hIm.setVisibility(8);
                    } else {
                        pVar.hIm.setVisibility(0);
                        pVar.hIm.setText(this.hGE.hBG.bQq());
                    }
                }
                if (pVar.hHm != null && pVar.hIp.getRootView() == null) {
                    pVar.hHm.addView(pVar.hIp.s(this.hGE));
                    String fromPageKey = UtilHelper.getFromPageKey(this.hGp.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.am("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).aif();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals("a002")) {
                            new com.baidu.tbadk.core.util.am("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).aif();
                        } else if (fromPageKey.equals("a006")) {
                            new com.baidu.tbadk.core.util.am("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).aif();
                        } else if (fromPageKey.equals("a026")) {
                            new com.baidu.tbadk.core.util.am("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 4).aif();
                        }
                    }
                }
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.cmH() == null) {
                pVar.hIi.getLayoutStrategy().lv(pO(R.dimen.tbds24));
            } else {
                pVar.hIi.getLayoutStrategy().lv(pO(R.dimen.tbds14));
            }
            pVar.hIn.f(postData.cmH());
        }
    }

    private int pO(int i) {
        return com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl()) && afVar.acc() == com.baidu.tbadk.core.data.af.bGw) {
            if (!afVar.acd()) {
                pVar.hIi.getLayoutStrategy().lv(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds48));
            }
            pVar.hIn.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bWH() == null) {
            pVar.hHE.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bWH(), pVar.hHE, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hIi.setTextViewOnTouchListener(this.hIb);
        pVar.hIi.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(af - i, this.hGM);
            tbRichTextView.getLayoutStrategy().ln(min);
            tbRichTextView.getLayoutStrategy().lo((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hHl.setOnTouchListener(this.ckg);
        pVar.hHl.setOnLongClickListener(this.clk);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hGp.getPageContext().getOrignalPage()).hEp;
        pVar.hIi.setOnLongClickListener(this.clk);
        pVar.hIi.setOnTouchListener(this.hIb);
        pVar.hIi.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hIi.setOnImageClickListener(this.cIM);
        pVar.hIi.setOnImageTouchListener(this.hIb);
        pVar.hIi.setOnEmotionClickListener(aVar.hRH);
        pVar.hHE.setOnClickListener(this.mCommonClickListener);
        pVar.hIn.a(this.hIc);
        pVar.hIo.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hGE = dVar;
    }

    public void xc(int i) {
        this.hGM = i;
    }

    public void nR(boolean z) {
        this.hGF = z;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGO = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIM = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ckg = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.clk = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hHf = cVar;
    }

    public void oj(boolean z) {
        this.hHX = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hIn.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hIn.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hIn.pause();
        }
    }

    public p bSu() {
        return (p) this.viewholder;
    }
}
