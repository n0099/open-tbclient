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
    private TbRichTextView.h cKh;
    private com.baidu.tieba.pb.a.c clt;
    private View.OnLongClickListener cmy;
    protected com.baidu.tieba.pb.data.d hMS;
    protected boolean hMT;
    protected int hNa;
    private View.OnClickListener hNc;
    private TbRichTextView.c hNt;
    private com.baidu.tieba.pb.pb.sub.c hNu;
    private boolean hOl;
    private boolean hOm;
    private final boolean hOn;
    private boolean hOo;
    private com.baidu.tieba.pb.a.c hOp;
    private OriginalThreadCardView.a hOq;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hNa = 0;
        this.hMT = true;
        this.hOl = true;
        this.hMS = null;
        this.hNu = null;
        this.hNc = null;
        this.mCommonClickListener = null;
        this.cKh = null;
        this.clt = null;
        this.cmy = null;
        this.hNt = null;
        this.hOm = false;
        this.hOn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hOo = false;
        this.pageFromType = 0;
        this.hOp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.clt != null) {
                    o.this.clt.ct(view);
                    o.this.clt.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hOq = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hMS != null) {
                    String threadId = o.this.hMS.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").bT("tid", threadId).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).P("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bTD() != null) {
            this.pageFromType = pbActivity.bTD().bWe();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.l(pVar.bNS, R.color.cp_bg_line_c);
                pVar.hOw.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                pVar.YV.onChangeSkinType();
                if (pVar.hOC != null) {
                    pVar.hOC.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.j(pVar.hOA, R.color.cp_cont_j);
                pVar.hOD.nz(skinType);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.hMD.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.hMT, this.hNa);
        a(pVar);
        pVar.hOB.xS(this.pageFromType);
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
            postData2.afB();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hMD.getUniqueId(), this.hMS, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hOm && this.hOn && pVar != null && pVar.hOw.azB() && (listView = ((PbActivity) this.hMD.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hOm = true;
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
        if (this.hMS != null) {
            if (postData.cpp() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hOw.setOnClickListener(this.mCommonClickListener);
                    pVar.hOw.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hOw.setOnClickListener(null);
                    pVar.hOw.setTextViewOnClickListener(null);
                }
                pVar.hNz.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hNz.setOnClickListener(null);
            }
            if (postData.cpp() == 1) {
                pVar.b(this.hMS, this.hMD.bTt());
                a(pVar.hOw, view, this.hOo);
                pVar.hOt.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aex() != null) {
                    j = postData.aex().getUserIdLong();
                    str = postData.aex().getUserName();
                    str2 = postData.aex().getName_show();
                }
                if (this.hMS != null && this.hMS.bSx() != null) {
                    pVar.hOB.a(postData.cpx(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hMS.bSx().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                if (this.hMD.bTU().bXX()) {
                    pVar.hOw.setVisibility(8);
                }
                if (this.hMS != null && this.hMS.bSx() != null && this.hMS.bSx().aeJ() != null) {
                    bp aeJ = this.hMS.bSx().aeJ();
                    aeJ.getActivityUrl();
                    String agD = aeJ.agD();
                    if (!StringUtils.isNull(aeJ.agE())) {
                        if (!StringUtils.isNull(agD)) {
                            pVar.hOy.setVisibility(0);
                            pVar.hOy.startLoad(agD, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hOy.setVisibility(8);
                }
                if (pVar.hOz != null) {
                    pVar.hOz.setVisibility(8);
                }
                if (this.hMS != null && this.hMS.bSx() != null && this.hMS.bSx().afr() && pVar.hOC != null) {
                    pVar.hOC.setPadding(pVar.hOC.getPaddingLeft(), com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pVar.hOC.getPaddingRight(), pVar.hOC.getPaddingBottom());
                }
            }
            pVar.hOw.getLayoutStrategy().ls(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cpp()));
            if (postData.cpt() > 0 && postData.cpm() != null && postData.cpm().size() > 0) {
                if (this.hNu == null) {
                    this.hNu = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hNu.setIsFromCDN(this.mIsFromCDN);
                    this.hNu.Q(this.hNc);
                    if (this.hMS != null) {
                        this.hNu.O(this.hMS.bSJ(), TextUtils.equals(this.hMS.bSx().aex().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hNu.ai(this.hMS.bSx());
                    }
                }
                this.hNu.Cp(postData.getId());
            }
            pVar.hOw.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.hMT) {
                pVar.hOw.getLayoutStrategy().lv(R.drawable.transparent_bg);
            } else {
                pVar.hOw.getLayoutStrategy().lv(R.drawable.icon_click);
            }
            pVar.hOw.setIsFromCDN(this.mIsFromCDN);
            if (this.hMS != null && this.hMS.bSx() != null && this.hMS.bSx().isLinkThread()) {
                a(pVar, this.hMS.bSx().afW());
            }
            a(pVar, postData);
            TbRichText cpr = postData.cpr();
            if (this.hMS != null && this.hMS.bSV()) {
                cpr = null;
            }
            if (this.hOm || !this.hOn) {
                pVar.hOw.setText(cpr, false, this.hNt);
            } else {
                pVar.hOw.setText(cpr, true, this.hNt);
            }
            a(pVar, postData, cpr);
            boolean z7 = !StringUtils.isNull(postData.aex().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hMS != null && this.hMS.bSJ() != 0) {
                if (this.hMS.bSJ() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.aex() != null) {
                    String userId = postData.aex().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hMS != null && this.hMS.bSx() != null && this.hMS.bSx().aex() != null && postData.aex() != null) {
                String userId2 = this.hMS.bSx().aex().getUserId();
                String userId3 = postData.aex().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aex() == null && UtilHelper.isCurrentAccount(postData.aex().getUserId())) {
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
                    if (postData.cpp() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aex() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aex().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aex().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aex().getPortrait());
                        }
                        if (this.hMS != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hMS.bSJ()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aex() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aex().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aex().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aex().getName_show());
                        }
                        if (this.hMS != null && this.hMS.bSx() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hMS.bSx().getId());
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
                        if (this.hMS != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hMS.bSJ()));
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
            if (postData.aex() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.cpp() == 1) {
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
            pVar.hOw.setTag(sparseArray);
            pVar.hNz.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pVar.hOw.setIsHost(true);
            if (this.hOl) {
                pVar.bNS.setVisibility(0);
            } else {
                pVar.bNS.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hMT) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hOw.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hOw.setLayoutParams(layoutParams);
                pVar.hOw.rC(null);
                this.hOo = false;
                a(pVar, postData, view, i);
            } else {
                this.hOo = true;
                pVar.hOw.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void azG() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hOw.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hOw.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hMS != null && this.hMS.bSx() != null && this.hMS.bSx().afr() && this.hMS.bSx().aeO() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.hMS.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cpr() == null || com.baidu.tbadk.core.util.v.aa(postData.cpr().ayL())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cpr() != null) {
                if (postData.cpr().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.YV.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pVar.YV.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.YV.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pVar.YV.setLayoutParams(layoutParams3);
                }
            }
            if (this.hMS.bSx() != null && this.hMS.bSx().afj() != null && this.hMS.bSx().aeO() == null) {
                pVar.YV.setVisibility(0);
                pVar.YV.setData(this.hMS.bSx().afj());
                if (this.hMS.getForum() != null) {
                    pVar.YV.setForumId(String.valueOf(this.hMS.getForum().getId()));
                }
                if (this.hMS.getThreadId() != null) {
                    pVar.YV.setThreadId(this.hMS.getThreadId());
                }
                AppletsCellView appletsCellView = pVar.YV;
                AppletsCellView appletsCellView2 = pVar.YV;
                appletsCellView.setFrom("PB_card");
            } else {
                pVar.YV.setVisibility(8);
            }
            if (this.hMS != null && this.hMS.bSx() != null && (this.hMS.bSx().aeM() != 0 || this.hMS.bSx().afr())) {
                pVar.W(this.hMS.bSx().aet() == 1, this.hMS.bSx().aes() == 1);
            }
            if (this.hMS != null && this.hMS.hHV != null) {
                if (pVar.hOA != null) {
                    if (TextUtils.isEmpty(this.hMS.hHV.bTc())) {
                        pVar.hOA.setVisibility(8);
                    } else {
                        pVar.hOA.setVisibility(0);
                        pVar.hOA.setText(this.hMS.hHV.bTc());
                    }
                }
                if (pVar.hNA != null && pVar.hOD.getRootView() == null) {
                    pVar.hNA.addView(pVar.hOD.s(this.hMS));
                    String fromPageKey = UtilHelper.getFromPageKey(this.hMD.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).aji();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals("a002")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 3).aji();
                        } else if (fromPageKey.equals("a006")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).aji();
                        } else if (fromPageKey.equals("a026")) {
                            new com.baidu.tbadk.core.util.an("c13445").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 4).aji();
                        }
                    }
                }
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.cpA() == null) {
                pVar.hOw.getLayoutStrategy().lB(qf(R.dimen.tbds24));
            } else {
                pVar.hOw.getLayoutStrategy().lB(qf(R.dimen.tbds14));
            }
            pVar.hOB.f(postData.cpA());
        }
    }

    private int qf(int i) {
        return com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl()) && afVar.ade() == com.baidu.tbadk.core.data.af.bHx) {
            if (!afVar.adf()) {
                pVar.hOw.getLayoutStrategy().lB(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds48));
            }
            pVar.hOB.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bZx() == null) {
            pVar.hNS.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bZx(), pVar.hNS, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hOw.setTextViewOnTouchListener(this.hOp);
        pVar.hOw.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(af - i, this.hNa);
            tbRichTextView.getLayoutStrategy().lt(min);
            tbRichTextView.getLayoutStrategy().lu((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hNz.setOnTouchListener(this.clt);
        pVar.hNz.setOnLongClickListener(this.cmy);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hMD.getPageContext().getOrignalPage()).hKD;
        pVar.hOw.setOnLongClickListener(this.cmy);
        pVar.hOw.setOnTouchListener(this.hOp);
        pVar.hOw.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hOw.setOnImageClickListener(this.cKh);
        pVar.hOw.setOnImageTouchListener(this.hOp);
        pVar.hOw.setOnEmotionClickListener(aVar.hXV);
        pVar.hNS.setOnClickListener(this.mCommonClickListener);
        pVar.hOB.a(this.hOq);
        pVar.hOC.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hMS = dVar;
    }

    public void xG(int i) {
        this.hNa = i;
    }

    public void og(boolean z) {
        this.hMT = z;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hNc = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKh = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.clt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmy = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hNt = cVar;
    }

    public void oy(boolean z) {
        this.hOl = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hOB.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hOB.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hOB.pause();
        }
    }

    public p bVh() {
        return (p) this.viewholder;
    }
}
