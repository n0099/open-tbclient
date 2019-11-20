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
    private View.OnClickListener ZF;
    private TbRichTextView.h cTN;
    private com.baidu.tieba.pb.a.c cyE;
    protected int hNF;
    private View.OnClickListener hNH;
    private TbRichTextView.c hNY;
    private com.baidu.tieba.pb.pb.sub.c hNZ;
    protected com.baidu.tieba.pb.data.d hNw;
    protected boolean hNy;
    private boolean hOQ;
    private boolean hOR;
    private final boolean hOS;
    private boolean hOT;
    private com.baidu.tieba.pb.a.c hOU;
    private OriginalThreadCardView.a hOV;
    private View.OnLongClickListener mOnLongClickListener;
    private int pageFromType;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hNF = 0;
        this.hNy = true;
        this.hOQ = true;
        this.hNw = null;
        this.hNZ = null;
        this.hNH = null;
        this.ZF = null;
        this.cTN = null;
        this.cyE = null;
        this.mOnLongClickListener = null;
        this.hNY = null;
        this.hOR = false;
        this.hOS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.hOT = false;
        this.pageFromType = 0;
        this.hOU = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.cyE != null) {
                    o.this.cyE.N(view);
                    o.this.cyE.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
        this.hOV = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.pb.pb.main.o.2
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                int i = 3;
                if (originalThreadInfo != null && o.this.hNw != null) {
                    String threadId = o.this.hNw.getThreadId();
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
        if (pbActivity != null && pbActivity.bRD() != null) {
            this.pageFromType = pbActivity.bRD().bUh();
        }
    }

    private void a(p pVar) {
        if (pVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(pVar.ceJ, R.color.cp_bg_line_c);
                pVar.hPb.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                pVar.Ir.onChangeSkinType();
                if (pVar.hPh != null) {
                    pVar.hPh.onChangeSkinType();
                }
                if (pVar.hPi != null) {
                    pVar.hPi.onChangeSkinType();
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(pVar.hPf, (int) R.color.cp_cont_j);
                pVar.hPj.mD(skinType);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public p b(ViewGroup viewGroup) {
        p pVar = new p(this.hNh.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_first_floor_item, viewGroup, false), this.hNy, this.hNF);
        a(pVar);
        pVar.hPg.wC(this.pageFromType);
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
            postData2.ajI();
            postData2.locate = i + 1;
            com.baidu.tieba.pb.c.a.a(this.hNh.getUniqueId(), this.hNw, postData2, postData2.locate, 1);
            b(pVar, postData2, view, i);
        }
        if (!this.hOR && this.hOS && pVar != null && pVar.hPb.azW() && (listView = ((PbActivity) this.hNh.getPageContext().getOrignalPage()).getListView()) != null) {
            this.hOR = true;
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
        if (this.hNw != null) {
            if (postData.con() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.hPb.setOnClickListener(this.ZF);
                    pVar.hPb.setTextViewOnClickListener(this.ZF);
                } else {
                    pVar.hPb.setOnClickListener(null);
                    pVar.hPb.setTextViewOnClickListener(null);
                }
                pVar.hOe.setOnClickListener(this.ZF);
            } else {
                pVar.hOe.setOnClickListener(null);
            }
            if (postData.con() == 1) {
                pVar.b(this.hNw, this.hNh.bRt());
                a(pVar.hPb, view, this.hOT);
                pVar.hOY.setVisibility(8);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aiE() != null) {
                    j = postData.aiE().getUserIdLong();
                    str = postData.aiE().getUserName();
                    str2 = postData.aiE().getName_show();
                }
                if (this.hNw != null && this.hNw.bQx() != null) {
                    pVar.hPg.a(postData.cov(), str, str2, j, com.baidu.adp.lib.g.b.toLong(this.hNw.bQx().getId(), 0L), com.baidu.adp.lib.g.b.toLong(postData.getId(), 0L));
                }
                if (this.hNh.bRV().bWb()) {
                    pVar.hPb.setVisibility(8);
                }
                if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQx().aiQ() != null) {
                    bq aiQ = this.hNw.bQx().aiQ();
                    aiQ.getActivityUrl();
                    String akJ = aiQ.akJ();
                    if (!StringUtils.isNull(aiQ.akK())) {
                        if (!StringUtils.isNull(akJ)) {
                            pVar.hPd.setVisibility(0);
                            pVar.hPd.startLoad(akJ, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.hPd.setVisibility(8);
                }
                if (pVar.hPe != null) {
                    pVar.hPe.setVisibility(8);
                }
                if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQx().ajy() && pVar.hPh != null) {
                    pVar.hPh.setPadding(pVar.hPh.getPaddingLeft(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds29), pVar.hPh.getPaddingRight(), pVar.hPh.getPaddingBottom());
                }
            }
            pVar.hPb.getLayoutStrategy().kB(R.drawable.pic_video);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.con()));
            if (postData.cor() > 0 && postData.cok() != null && postData.cok().size() > 0) {
                if (this.hNZ == null) {
                    this.hNZ = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                    this.hNZ.setIsFromCDN(this.mIsFromCDN);
                    this.hNZ.R(this.hNH);
                    if (this.hNw != null) {
                        this.hNZ.N(this.hNw.bQJ(), TextUtils.equals(this.hNw.bQx().aiE().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.hNZ.ai(this.hNw.bQx());
                    }
                }
                this.hNZ.Bi(postData.getId());
            }
            pVar.hPb.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            if (this.hNy) {
                pVar.hPb.getLayoutStrategy().kE(R.drawable.transparent_bg);
            } else {
                pVar.hPb.getLayoutStrategy().kE(R.drawable.icon_click);
            }
            pVar.hPb.setIsFromCDN(this.mIsFromCDN);
            if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQx().isLinkThread()) {
                a(pVar, this.hNw.bQx().akc());
            }
            a(pVar, postData);
            TbRichText cop = postData.cop();
            if (this.hNw != null && this.hNw.bQV()) {
                cop = null;
            }
            if (this.hOR || !this.hOS) {
                pVar.hPb.setText(cop, false, this.hNY);
            } else {
                pVar.hPb.setText(cop, true, this.hNY);
            }
            a(pVar, postData, cop);
            boolean z7 = !StringUtils.isNull(postData.aiE().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.hNw != null && this.hNw.bQJ() != 0) {
                if (this.hNw.bQJ() != 3) {
                    z8 = true;
                    z9 = true;
                }
                if (postData.aiE() != null) {
                    String userId = postData.aiE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQx().aiE() != null && postData.aiE() != null) {
                String userId2 = this.hNw.bQx().aiE().getUserId();
                String userId3 = postData.aiE().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.aiE() == null && UtilHelper.isCurrentAccount(postData.aiE().getUserId())) {
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
                    if (postData.con() == 1) {
                        i2 = 0;
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        if (postData.aiE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aiE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiE().getPortrait());
                        }
                        if (this.hNw != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNw.bQJ()));
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aiE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiE().getName_show());
                        }
                        if (this.hNw != null && this.hNw.bQx() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hNw.bQx().getId());
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
                        if (this.hNw != null) {
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNw.bQJ()));
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
            if (postData.aiE() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i22 = 1;
            if (postData.con() == 1) {
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
            pVar.hPb.setTag(sparseArray);
            pVar.hOe.setTag(R.id.tag_from, sparseArray);
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pVar.hPb.setIsHost(true);
            if (this.hOQ) {
                pVar.ceJ.setVisibility(0);
            } else {
                pVar.ceJ.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hNy) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.hPb.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.hPb.setLayoutParams(layoutParams);
                pVar.hPb.qx(null);
                this.hOT = false;
                a(pVar, postData, view, i);
            } else {
                this.hOT = true;
                pVar.hPb.a(postData.getBimg_url(), new TbRichTextView.e() { // from class: com.baidu.tieba.pb.pb.main.o.3
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
                    public void aAb() {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.hPb.getLayoutParams();
                        layoutParams2.topMargin = o.this.getDimensionPixelSize(R.dimen.ds16);
                        int dimensionPixelSize = o.this.getDimensionPixelSize(R.dimen.ds34);
                        layoutParams2.bottomMargin = dimensionPixelSize;
                        layoutParams2.leftMargin = dimensionPixelSize;
                        layoutParams2.rightMargin = dimensionPixelSize;
                        pVar.hPb.setLayoutParams(layoutParams2);
                        o.this.a(pVar, postData, view, i);
                    }
                });
            }
            if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQx().ajy() && this.hNw.bQx().aiV() != null && com.baidu.tbadk.core.util.aq.isEmpty(this.hNw.getForum().getName())) {
                pVar.r(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.cop() == null || com.baidu.tbadk.core.util.v.isEmpty(postData.cop().azf())) {
                pVar.r(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            } else {
                pVar.r(false, 0);
            }
            if (postData.cop() != null) {
                if (postData.cop().azg() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.Ir.getLayoutParams();
                    layoutParams2.topMargin = getDimensionPixelSize(R.dimen.tbds26);
                    pVar.Ir.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pVar.Ir.getLayoutParams();
                    layoutParams3.topMargin = getDimensionPixelSize(R.dimen.tbds16);
                    pVar.Ir.setLayoutParams(layoutParams3);
                }
            }
            if (this.hNw.bQx() != null && this.hNw.bQx().ajq() != null && this.hNw.bQx().aiV() == null) {
                pVar.Ir.setVisibility(0);
                pVar.Ir.setData(this.hNw.bQx().ajq());
                if (this.hNw.getForum() != null) {
                    pVar.Ir.setForumId(String.valueOf(this.hNw.getForum().getId()));
                }
                if (this.hNw.getThreadId() != null) {
                    pVar.Ir.setThreadId(this.hNw.getThreadId());
                }
                AppletsCellView appletsCellView = pVar.Ir;
                AppletsCellView appletsCellView2 = pVar.Ir;
                appletsCellView.setFrom("PB_card");
            } else {
                pVar.Ir.setVisibility(8);
            }
            if (this.hNw != null && this.hNw.bQx() != null && (this.hNw.bQx().aiT() != 0 || this.hNw.bQx().ajy())) {
                pVar.a(this.hNw, this.hNw.bQx().aiA() == 1, this.hNw.bQx().aiz() == 1);
            }
            if (this.hNw != null && this.hNw.hIx != null) {
                if (pVar.hPf != null) {
                    if (TextUtils.isEmpty(this.hNw.hIx.bRc())) {
                        pVar.hPf.setVisibility(8);
                    } else {
                        pVar.hPf.setVisibility(0);
                        pVar.hPf.setText(this.hNw.hIx.bRc());
                    }
                }
                if (pVar.hOf != null && pVar.hPj.getRootView() == null) {
                    pVar.hOf.addView(pVar.hPj.s(this.hNw));
                    String fromPageKey = UtilHelper.getFromPageKey(this.hNh.getPageContext());
                    if ((this.mContext instanceof PbActivity) && ((PbActivity) this.mContext).getIntent() != null && (z = ((PbActivity) this.mContext).getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_FROM_BAR_VOTE, false))) {
                        new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 1).amI();
                    }
                    if (fromPageKey != null && !z) {
                        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
                            new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 3).amI();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
                            new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 2).amI();
                        } else if (fromPageKey.equals(PageStayDurationConstants.PageName.SEARCH_RESULT)) {
                            new com.baidu.tbadk.core.util.an("c13445").O("obj_source", 4).amI();
                        }
                    }
                }
            }
        }
    }

    private void a(p pVar, PostData postData) {
        if (pVar != null && postData != null) {
            if (postData.coy() == null) {
                pVar.hPb.getLayoutStrategy().kK(wB(R.dimen.tbds24));
            } else {
                pVar.hPb.getLayoutStrategy().kK(wB(R.dimen.tbds14));
            }
            pVar.hPg.f(postData.coy());
        }
    }

    private int wB(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    private void a(p pVar, com.baidu.tbadk.core.data.af afVar) {
        if (afVar != null && !com.baidu.tbadk.core.util.aq.isEmpty(afVar.getLinkUrl()) && afVar.ahn() == com.baidu.tbadk.core.data.af.bYQ) {
            if (!afVar.aho()) {
                pVar.hPb.getLayoutStrategy().kK(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds48));
            }
            pVar.hPg.a(afVar);
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.bXD() == null) {
            pVar.hOx.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.b.a(postData.bXD(), pVar.hOx, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.hPb.setTextViewOnTouchListener(this.hOU);
        pVar.hPb.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(R.dimen.ds80);
            }
            int min = Math.min(equipmentWidth - i, this.hNF);
            tbRichTextView.getLayoutStrategy().kC(min);
            tbRichTextView.getLayoutStrategy().kD((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.hOe.setOnTouchListener(this.cyE);
        pVar.hOe.setOnLongClickListener(this.mOnLongClickListener);
        com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hNh.getPageContext().getOrignalPage()).hLg;
        pVar.hPb.setOnLongClickListener(this.mOnLongClickListener);
        pVar.hPb.setOnTouchListener(this.hOU);
        pVar.hPb.setCommonTextViewOnClickListener(this.ZF);
        pVar.hPb.setOnImageClickListener(this.cTN);
        pVar.hPb.setOnImageTouchListener(this.hOU);
        pVar.hPb.setOnEmotionClickListener(aVar.hYE);
        pVar.hOx.setOnClickListener(this.ZF);
        pVar.hPg.a(this.hOV);
        pVar.hPh.setAfterItemClickListener(this.ZF);
        pVar.hPi.setAfterItemClickListener(this.ZF);
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hNw = dVar;
    }

    public void wp(int i) {
        this.hNF = i;
    }

    public void nT(boolean z) {
        this.hNy = z;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hNH = onClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cTN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cyE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void a(TbRichTextView.c cVar) {
        this.hNY = cVar;
    }

    public void ol(boolean z) {
        this.hOQ = z;
    }

    public void release() {
        if (this.xn != 0) {
            ((p) this.xn).hPg.destroy();
            ((p) this.xn).hPi.destroy();
        }
    }

    public void resume() {
        if (this.xn != 0) {
            ((p) this.xn).hPg.resume();
        }
    }

    public void pause() {
        if (this.xn != 0) {
            ((p) this.xn).hPg.pause();
        }
    }

    public p bTk() {
        return (p) this.xn;
    }
}
