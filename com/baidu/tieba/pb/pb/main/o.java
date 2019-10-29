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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bq;
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
    private View.OnClickListener ZX;
    private TbRichTextView.h cUE;
    private com.baidu.tieba.pb.a.c czv;
    private TbRichTextView.c hOP;
    private com.baidu.tieba.pb.pb.sub.c hOQ;
    protected com.baidu.tieba.pb.data.d hOn;
    protected boolean hOp;
    protected int hOw;
    private View.OnClickListener hOy;
    private boolean hPH;
    private boolean hPI;
    private final boolean hPJ;
    private boolean hPK;
    private com.baidu.tieba.pb.a.c hPL;
    private OriginalThreadCardView.a hPM;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hOw = 0;
        this.hOp = true;
        this.hPH = true;
        this.hOn = null;
        this.hOQ = null;
        this.hOy = null;
        this.ZX = null;
        this.cUE = null;
        this.czv = null;
        this.mOnLongClickListener = null;
        this.hOP = null;
        this.hPI = false;
        this.hPJ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hPK = false;
        this.pageFromType = 0;
        this.hPL = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.czv != null) {
                    o.this.czv.N(view);
                    o.this.czv.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hPM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hOn != null) {
                    String threadId = o.this.hOn.getThreadId();
                    String str = originalThreadInfo.threadId;
                    if (originalThreadInfo.showType == 3) {
                        i = 2;
                    } else if (originalThreadInfo.showType != 4) {
                        i = 1;
                    }
                    if (!StringUtils.isNull(threadId) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12602").bS("tid", threadId).bS("obj_source", str).O("obj_type", i));
                    }
                }
            }
        };
        if (pbActivity != null && pbActivity.bRF() != null) {
            this.pageFromType = pbActivity.bRF().bUj();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(pVar.cfA, R.color.cp_bg_line_c);
                pVar.hPS.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                pVar.IU.onChangeSkinType();
                if (pVar.hPY != null) {
                    pVar.hPY.onChangeSkinType();
                }
                if (pVar.hPZ != null) {
                    pVar.hPZ.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(pVar.hPW, (int) R.color.cp_cont_j);
                pVar.hQa.mE(skinType);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public p b(ViewGroup viewGroup) {
        p pVar = new p(this.hNY.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.hOp, this.hOw);
        a(pVar);
        pVar.hPX.wD(this.pageFromType);
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, p pVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) pVar);
        a(pVar);
        c(pVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.ajK();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hNY.getUniqueId(), this.hOn, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hPI && this.hPJ && pVar != null && pVar.hPS.azY() && (listView = ((PbActivity) this.hNY.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hPI = true;
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
        if (this.hOn != null) {
            if (postData.cop() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hPS.setOnClickListener(this.ZX);
                    pVar.hPS.setTextViewOnClickListener(this.ZX);
                } else {
                    pVar.hPS.setOnClickListener(null);
                    pVar.hPS.setTextViewOnClickListener(null);
                }
                pVar.hOV.setOnClickListener(this.ZX);
            } else {
                pVar.hOV.setOnClickListener(null);
            }
            if (postData.cop() == 1) {
                pVar.b(this.hOn, this.hNY.bRv());
                a(pVar.hPS, view, this.hPK);
                pVar.hPP.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aiG() != null) {
                    j = postData.aiG().getUserIdLong();
                    str = postData.aiG().getUserName();
                    str2 = postData.aiG().getName_show();
                }
                if (this.hOn != null && this.hOn.bQz() != null) {
                    pVar.hPX.a(postData.cox(), str, str2, j, com.baidu.adp.lib.g.b.toLong(this.hOn.bQz().getId(), 0L), com.baidu.adp.lib.g.b.toLong(postData.getId(), 0L));
                }
                if (this.hNY.bRX().bWd()) {
                    pVar.hPS.setVisibility(8);
                }
                if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQz().aiS() != null) {
                    bq aiS = this.hOn.bQz().aiS();
                    aiS.getActivityUrl();
                    String akL = aiS.akL();
                    if (!StringUtils.isNull(aiS.akM())) {
                        if (!StringUtils.isNull(akL)) {
                            pVar.hPU.setVisibility(0);
                            pVar.hPU.startLoad(akL, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hPU.setVisibility(8);
                }
                if (pVar.hPV != null) {
                    pVar.hPV.setVisibility(8);
                }
                if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQz().ajA() && pVar.hPY != null) {
                    pVar.hPY.setPadding(pVar.hPY.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pVar.hPY.getPaddingRight(), pVar.hPY.getPaddingBottom());
                }
            }
            pVar.hPS.getLayoutStrategy().kC(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cop()));
            if (postData.cot() > 0 && postData.com() != null && postData.com().size() > 0) {
                if (this.hOQ == null) {
                    this.hOQ = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hOQ.setIsFromCDN(this.mIsFromCDN);
                    this.hOQ.R(this.hOy);
                    if (this.hOn != null) {
                        this.hOQ.N(this.hOn.bQL(), TextUtils.equals(this.hOn.bQz().aiG().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hOQ.ai(this.hOn.bQz());
                    }
                }
                this.hOQ.Bi(postData.getId());
            }
            pVar.hPS.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.hOp) {
                pVar.hPS.getLayoutStrategy().kF(R.drawable.transparent_bg);
            } else {
                pVar.hPS.getLayoutStrategy().kF(R.drawable.icon_click);
            }
            pVar.hPS.setIsFromCDN(this.mIsFromCDN);
            if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQz().isLinkThread()) {
                a(pVar, this.hOn.bQz().ake());
            }
            a(pVar, postData);
            TbRichText cor = postData.cor();
            if (this.hOn != null && this.hOn.bQX()) {
                cor = null;
            }
            if (this.hPI || !this.hPJ) {
                pVar.hPS.setText(cor, false, this.hOP);
            } else {
                pVar.hPS.setText(cor, true, this.hOP);
            }
            a(pVar, postData, cor);
            boolean z7 = !StringUtils.isNull(postData.aiG().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hOn != null && this.hOn.bQL() != 0) {
                if (this.hOn.bQL() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.aiG() != null) {
                    String userId = postData.aiG().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQz().aiG() != null && postData.aiG() != null) {
                String userId2 = this.hOn.bQz().aiG().getUserId();
                String userId3 = postData.aiG().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aiG() == null && UtilHelper.isCurrentAccount(postData.aiG().getUserId())) {
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
                    if (postData.cop() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aiG() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aiG().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiG().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiG().getPortrait());
                        }
                        if (this.hOn != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hOn.bQL()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aiG() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiG().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiG().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiG().getName_show());
                        }
                        if (this.hOn != null && this.hOn.bQz() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hOn.bQz().getId());
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
                        if (this.hOn != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hOn.bQL()));
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
            if (postData.aiG() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.cop() == 1) {
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
            pVar.hPS.setTag(sparseArray);
            pVar.hOV.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pVar.hPS.setIsHost(true);
            if (this.hPH) {
                pVar.cfA.setVisibility(0);
            } else {
                pVar.cfA.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hOp) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hPS.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hPS.setLayoutParams(layoutParams);
                pVar.hPS.qx(null);
                this.hPK = false;
                a(pVar, postData, view, i);
            } else {
                this.hPK = true;
                pVar.hPS.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void aAd() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hPS.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hPS.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQz().ajA() && this.hOn.bQz().aiX() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.hOn.getForum().getName())) {
                pVar.r(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cor() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cor().azh())) {
                pVar.r(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pVar.r(false, 0);
            }
            if (postData.cor() != null) {
                if (postData.cor().azi() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.IU.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pVar.IU.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.IU.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pVar.IU.setLayoutParams(layoutParams3);
                }
            }
            if (this.hOn.bQz() != null && this.hOn.bQz().ajs() != null && this.hOn.bQz().aiX() == null) {
                pVar.IU.setVisibility(0);
                pVar.IU.setData(this.hOn.bQz().ajs());
                if (this.hOn.getForum() != null) {
                    pVar.IU.setForumId(String.valueOf(this.hOn.getForum().getId()));
                }
                if (this.hOn.getThreadId() != null) {
                    pVar.IU.setThreadId(this.hOn.getThreadId());
                }
                AppletsCellView appletsCellView = pVar.IU;
                AppletsCellView appletsCellView2 = pVar.IU;
                appletsCellView.setFrom("PB_card");
            } else {
                pVar.IU.setVisibility(8);
            }
            if (this.hOn != null && this.hOn.bQz() != null && (this.hOn.bQz().aiV() != 0 || this.hOn.bQz().ajA())) {
                pVar.a(this.hOn, this.hOn.bQz().aiC() == 1, this.hOn.bQz().aiB() == 1);
            }
            if (this.hOn != null && this.hOn.hJo != null) {
                if (pVar.hPW != null) {
                    if (TextUtils.isEmpty(this.hOn.hJo.bRe())) {
                        pVar.hPW.setVisibility(8);
                    } else {
                        pVar.hPW.setVisibility(0);
                        pVar.hPW.setText(this.hOn.hJo.bRe());
                    }
                }
                if (pVar.hOW != null && pVar.hQa.getRootView() == null) {
                    pVar.hOW.addView(pVar.hQa.s(this.hOn));
                    String fromPageKey = UtilHelper.getFromPageKey(this.hNY.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 1).amK();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 3).amK();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 2).amK();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 4).amK();
                        }
                    }
                }
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.coA() == null) {
                pVar.hPS.getLayoutStrategy().kL(wC(R.dimen.tbds24));
            } else {
                pVar.hPS.getLayoutStrategy().kL(wC(R.dimen.tbds14));
            }
            pVar.hPX.f(postData.coA());
        }
    }

    private int wC(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl()) && afVar.ahp() == com.baidu.tbadk.core.data.af.bZH) {
            if (!afVar.ahq()) {
                pVar.hPS.getLayoutStrategy().kL(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pVar.hPX.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bXF() == null) {
            pVar.hPo.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bXF(), pVar.hPo, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hPS.setTextViewOnTouchListener(this.hPL);
        pVar.hPS.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.hOw);
            tbRichTextView.getLayoutStrategy().kD(min);
            tbRichTextView.getLayoutStrategy().kE((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hOV.setOnTouchListener(this.czv);
        pVar.hOV.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hNY.getPageContext().getOrignalPage()).hLX;
        pVar.hPS.setOnLongClickListener(this.mOnLongClickListener);
        pVar.hPS.setOnTouchListener(this.hPL);
        pVar.hPS.setCommonTextViewOnClickListener(this.ZX);
        pVar.hPS.setOnImageClickListener(this.cUE);
        pVar.hPS.setOnImageTouchListener(this.hPL);
        pVar.hPS.setOnEmotionClickListener(aVar.hZv);
        pVar.hPo.setOnClickListener(this.ZX);
        pVar.hPX.a(this.hPM);
        pVar.hPY.setAfterItemClickListener(this.ZX);
        pVar.hPZ.setAfterItemClickListener(this.ZX);
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hOn = dVar;
    }

    public void wq(int i) {
        this.hOw = i;
    }

    public void nT(boolean z) {
        this.hOp = z;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hOy = onClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZX = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cUE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.czv = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hOP = cVar;
    }

    public void ol(boolean z) {
        this.hPH = z;
    }

    public void release() {
        if (this.xN != 0) {
            ((p) this.xN).hPX.destroy();
            ((p) this.xN).hPZ.destroy();
        }
    }

    public void resume() {
        if (this.xN != 0) {
            ((p) this.xN).hPX.resume();
        }
    }

    public void pause() {
        if (this.xN != 0) {
            ((p) this.xN).hPX.pause();
        }
    }

    public p bTm() {
        return (p) this.xN;
    }
}
