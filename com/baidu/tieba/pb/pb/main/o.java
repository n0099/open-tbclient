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
    private TbRichTextView.h cIN;
    private com.baidu.tieba.pb.a.c ckh;
    private View.OnLongClickListener cll;
    protected com.baidu.tieba.pb.data.d hGF;
    protected boolean hGG;
    protected int hGN;
    private View.OnClickListener hGP;
    private boolean hHY;
    private boolean hHZ;
    private TbRichTextView.c hHg;
    private com.baidu.tieba.pb.pb.sub.c hHh;
    private final boolean hIa;
    private boolean hIb;
    private com.baidu.tieba.pb.a.c hIc;
    private OriginalThreadCardView.a hId;
    private View.OnClickListener mCommonClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hGN = 0;
        this.hGG = true;
        this.hHY = true;
        this.hGF = null;
        this.hHh = null;
        this.hGP = null;
        this.mCommonClickListener = null;
        this.cIN = null;
        this.ckh = null;
        this.cll = null;
        this.hHg = null;
        this.hHZ = false;
        this.hIa = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hIb = false;
        this.pageFromType = 0;
        this.hIc = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.ckh != null) {
                    o.this.ckh.cq(view);
                    o.this.ckh.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hId = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hGF != null) {
                    String threadId = o.this.hGF.getThreadId();
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
        if (pbActivity != null && pbActivity.bQS() != null) {
            this.pageFromType = pbActivity.bQS().bTr();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.al.l(pVar.bMR, R.color.cp_bg_line_c);
                pVar.hIj.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_b));
                pVar.YA.onChangeSkinType();
                if (pVar.hIp != null) {
                    pVar.hIp.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.al.j(pVar.hIn, R.color.cp_cont_j);
                pVar.hIq.nq(skinType);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.hGq.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.hGG, this.hGN);
        a(pVar);
        pVar.hIo.xo(this.pageFromType);
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
            com.baidu.tieba.pb.c.a.a(this.hGq.getUniqueId(), this.hGF, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hHZ && this.hIa && pVar != null && pVar.hIj.ayp() && (listView = ((PbActivity) this.hGq.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hHZ = true;
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
        if (this.hGF != null) {
            if (postData.cmx() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hIj.setOnClickListener(this.mCommonClickListener);
                    pVar.hIj.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    pVar.hIj.setOnClickListener(null);
                    pVar.hIj.setTextViewOnClickListener(null);
                }
                pVar.hHm.setOnClickListener(this.mCommonClickListener);
            } else {
                pVar.hHm.setOnClickListener(null);
            }
            if (postData.cmx() == 1) {
                pVar.b(this.hGF, this.hGq.bQI());
                a(pVar.hIj, view, this.hIb);
                pVar.hIg.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.adv() != null) {
                    j = postData.adv().getUserIdLong();
                    str = postData.adv().getUserName();
                    str2 = postData.adv().getName_show();
                }
                if (this.hGF != null && this.hGF.bPM() != null) {
                    pVar.hIo.a(postData.cmF(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hGF.bPM().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                if (this.hGq.bRi().bVj()) {
                    pVar.hIj.setVisibility(8);
                }
                if (this.hGF != null && this.hGF.bPM() != null && this.hGF.bPM().adH() != null) {
                    bp adH = this.hGF.bPM().adH();
                    adH.getActivityUrl();
                    String afB = adH.afB();
                    if (!StringUtils.isNull(adH.afC())) {
                        if (!StringUtils.isNull(afB)) {
                            pVar.hIl.setVisibility(0);
                            pVar.hIl.startLoad(afB, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hIl.setVisibility(8);
                }
                if (pVar.hIm != null) {
                    pVar.hIm.setVisibility(8);
                }
                if (this.hGF != null && this.hGF.bPM() != null && this.hGF.bPM().aep() && pVar.hIp != null) {
                    pVar.hIp.setPadding(pVar.hIp.getPaddingLeft(), com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds29), pVar.hIp.getPaddingRight(), pVar.hIp.getPaddingBottom());
                }
            }
            pVar.hIj.getLayoutStrategy().lm(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cmx()));
            if (postData.cmB() > 0 && postData.cmu() != null && postData.cmu().size() > 0) {
                if (this.hHh == null) {
                    this.hHh = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hHh.setIsFromCDN(this.mIsFromCDN);
                    this.hHh.O(this.hGP);
                    if (this.hGF != null) {
                        this.hHh.M(this.hGF.bPY(), TextUtils.equals(this.hGF.bPM().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hHh.ai(this.hGF.bPM());
                    }
                }
                this.hHh.BD(postData.getId());
            }
            pVar.hIj.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            if (this.hGG) {
                pVar.hIj.getLayoutStrategy().lp(R.drawable.transparent_bg);
            } else {
                pVar.hIj.getLayoutStrategy().lp(R.drawable.icon_click);
            }
            pVar.hIj.setIsFromCDN(this.mIsFromCDN);
            if (this.hGF != null && this.hGF.bPM() != null && this.hGF.bPM().isLinkThread()) {
                a(pVar, this.hGF.bPM().aeU());
            }
            a(pVar, postData);
            TbRichText cmz = postData.cmz();
            if (this.hGF != null && this.hGF.bQk()) {
                cmz = null;
            }
            if (this.hHZ || !this.hIa) {
                pVar.hIj.setText(cmz, false, this.hHg);
            } else {
                pVar.hIj.setText(cmz, true, this.hHg);
            }
            a(pVar, postData, cmz);
            boolean z7 = !StringUtils.isNull(postData.adv().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hGF != null && this.hGF.bPY() != 0) {
                if (this.hGF.bPY() != 3) {
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
            if (this.hGF != null && this.hGF.bPM() != null && this.hGF.bPM().adv() != null && postData.adv() != null) {
                String userId2 = this.hGF.bPM().adv().getUserId();
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
                    if (postData.cmx() == 1) {
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
                        if (this.hGF != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGF.bPY()));
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
                        if (this.hGF != null && this.hGF.bPM() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hGF.bPM().getId());
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
                        if (this.hGF != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGF.bPY()));
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
            if (postData.cmx() == 1) {
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
            pVar.hIj.setTag(sparseArray);
            pVar.hHm.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pVar.hIj.setIsHost(true);
            if (this.hHY) {
                pVar.bMR.setVisibility(0);
            } else {
                pVar.bMR.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGG) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hIj.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hIj.setLayoutParams(layoutParams);
                pVar.hIj.rk(null);
                this.hIb = false;
                a(pVar, postData, view, i);
            } else {
                this.hIb = true;
                pVar.hIj.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void ayu() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hIj.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hIj.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hGF != null && this.hGF.bPM() != null && this.hGF.bPM().aep() && this.hGF.bPM().adM() != null && com.baidu.tbadk.core.util.ap.isEmpty(this.hGF.getForum().getName())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cmz() == null || com.baidu.tbadk.core.util.v.aa(postData.cmz().axz())) {
                pVar.q(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pVar.q(false, 0);
            }
            if (postData.cmz() != null) {
                if (postData.cmz().getImageCount() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.YA.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pVar.YA.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.YA.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pVar.YA.setLayoutParams(layoutParams3);
                }
            }
            if (this.hGF.bPM() != null && this.hGF.bPM().aeh() != null && this.hGF.bPM().adM() == null) {
                pVar.YA.setVisibility(0);
                pVar.YA.setData(this.hGF.bPM().aeh());
                if (this.hGF.getForum() != null) {
                    pVar.YA.setForumId(String.valueOf(this.hGF.getForum().getId()));
                }
                if (this.hGF.getThreadId() != null) {
                    pVar.YA.setThreadId(this.hGF.getThreadId());
                }
                AppletsCellView appletsCellView = pVar.YA;
                AppletsCellView appletsCellView2 = pVar.YA;
                appletsCellView.setFrom("PB_card");
            } else {
                pVar.YA.setVisibility(8);
            }
            if (this.hGF != null && this.hGF.bPM() != null && (this.hGF.bPM().adK() != 0 || this.hGF.bPM().aep())) {
                pVar.T(this.hGF.bPM().adr() == 1, this.hGF.bPM().adq() == 1);
            }
            if (this.hGF != null && this.hGF.hBH != null) {
                if (pVar.hIn != null) {
                    if (TextUtils.isEmpty(this.hGF.hBH.bQr())) {
                        pVar.hIn.setVisibility(8);
                    } else {
                        pVar.hIn.setVisibility(0);
                        pVar.hIn.setText(this.hGF.hBH.bQr());
                    }
                }
                if (pVar.hHn != null && pVar.hIq.getRootView() == null) {
                    pVar.hHn.addView(pVar.hIq.s(this.hGF));
                    String fromPageKey = UtilHelper.getFromPageKey(this.hGq.getPageContext());
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
            if (postData.cmI() == null) {
                pVar.hIj.getLayoutStrategy().lv(pO(R.dimen.tbds24));
            } else {
                pVar.hIj.getLayoutStrategy().lv(pO(R.dimen.tbds14));
            }
            pVar.hIo.f(postData.cmI());
        }
    }

    private int pO(int i) {
        return com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.ap.isEmpty(afVar.getLinkUrl()) && afVar.acc() == com.baidu.tbadk.core.data.af.bGx) {
            if (!afVar.acd()) {
                pVar.hIj.getLayoutStrategy().lv(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds48));
            }
            pVar.hIo.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bWI() == null) {
            pVar.hHF.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bWI(), pVar.hHF, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hIj.setTextViewOnTouchListener(this.hIc);
        pVar.hIj.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(af - i, this.hGN);
            tbRichTextView.getLayoutStrategy().ln(min);
            tbRichTextView.getLayoutStrategy().lo((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hHm.setOnTouchListener(this.ckh);
        pVar.hHm.setOnLongClickListener(this.cll);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hGq.getPageContext().getOrignalPage()).hEq;
        pVar.hIj.setOnLongClickListener(this.cll);
        pVar.hIj.setOnTouchListener(this.hIc);
        pVar.hIj.setCommonTextViewOnClickListener(this.mCommonClickListener);
        pVar.hIj.setOnImageClickListener(this.cIN);
        pVar.hIj.setOnImageTouchListener(this.hIc);
        pVar.hIj.setOnEmotionClickListener(aVar.hRI);
        pVar.hHF.setOnClickListener(this.mCommonClickListener);
        pVar.hIo.a(this.hId);
        pVar.hIp.setAfterItemClickListener(this.mCommonClickListener);
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hGF = dVar;
    }

    public void xc(int i) {
        this.hGN = i;
    }

    public void nS(boolean z) {
        this.hGG = z;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGP = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ckh = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cll = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hHg = cVar;
    }

    public void ok(boolean z) {
        this.hHY = z;
    }

    public void release() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hIo.destroy();
        }
    }

    public void resume() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hIo.resume();
        }
    }

    public void pause() {
        if (this.viewholder != 0) {
            ((p) this.viewholder).hIo.pause();
        }
    }

    public p bSv() {
        return (p) this.viewholder;
    }
}
