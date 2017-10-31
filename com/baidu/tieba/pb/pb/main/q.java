package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class q extends m<PostData, r> implements View.OnClickListener {
    private TbRichTextView.f aSv;
    private com.baidu.tieba.pb.a.c aSw;
    private View.OnLongClickListener auR;
    protected int eHO;
    protected boolean eHP;
    protected com.baidu.tieba.pb.data.f eHR;
    private com.baidu.tieba.pb.pb.sub.d eHS;
    private View.OnClickListener eHU;
    private boolean eHV;
    private final boolean eHW;
    private TbRichTextView.b eMU;
    private boolean eNu;
    private boolean eNv;
    private com.baidu.tieba.pb.a.c eNw;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eHO = 0;
        this.eHP = true;
        this.eNu = true;
        this.eHR = null;
        this.eHS = null;
        this.eHU = null;
        this.mCommonClickListener = null;
        this.aSv = null;
        this.aSw = null;
        this.auR = null;
        this.eMU = null;
        this.eHV = false;
        this.eHW = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eNv = false;
        this.eNw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, 2));
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (q.this.aSw != null) {
                    q.this.aSw.bf(view);
                    q.this.aSw.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(rVar.eIe, d.C0080d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.j(rVar.eIL, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(rVar.eIM, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(rVar.eIN, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(rVar.eIO, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.k(rVar.deP, d.C0080d.cp_bg_line_c);
                rVar.eIo.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(rVar.eNB, d.C0080d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eIL, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eIM, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eIN, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eIO, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.j(rVar.clT, d.f.bg_first_floor_forum_name);
                com.baidu.tbadk.core.util.aj.c(rVar.clT, d.C0080d.cp_cont_j, 1);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.eMh.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.eHP, this.eHO);
        a(rVar);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, r rVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, rVar);
        a(rVar);
        c(rVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.st();
            a(rVar, postData2, view, i);
        }
        if (!this.eHV && this.eHW && rVar != null && rVar.eIo.Jx() && (listView = ((PbActivity) this.eMh.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eHV = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(r rVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        List<bc> subList;
        if (rVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            rVar.eIo.setTag(sparseArray);
            rVar.eIe.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            if (this.eNu) {
                rVar.deP.setVisibility(0);
            } else {
                rVar.deP.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHP) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.eIo.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.eIo.setLayoutParams(layoutParams);
                rVar.eIo.he(null);
                this.eNv = false;
            } else {
                this.eNv = true;
                rVar.eIo.he(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.eIo.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.e.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                rVar.eIo.setLayoutParams(layoutParams2);
            }
            if (postData.buu() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.eIo.setOnClickListener(this.mCommonClickListener);
                    rVar.eIo.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    rVar.eIo.setOnClickListener(null);
                    rVar.eIo.setTextViewOnClickListener(null);
                }
                rVar.eIe.setOnClickListener(this.mCommonClickListener);
            } else {
                rVar.eIe.setOnClickListener(null);
            }
            if (postData.buu() == 1) {
                if (!this.eMh.aRV()) {
                    if (this.eHR != null && !com.baidu.tbadk.core.util.v.v(this.eHR.aQi())) {
                        rVar.eIP.setVisibility(0);
                        if (this.eHR.aQi().size() <= 4) {
                            subList = this.eHR.aQi();
                        } else {
                            subList = this.eHR.aQi().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, rVar.eIL, subList);
                            } else if (i2 == 1) {
                                a(i2, rVar.eIM, subList);
                            } else if (i2 == 2) {
                                a(i2, rVar.eIN, subList);
                            } else if (i2 == 3) {
                                a(i2, rVar.eIO, subList);
                            }
                        }
                    } else {
                        rVar.eIP.setVisibility(8);
                    }
                    rVar.clT.setVisibility(8);
                } else {
                    rVar.eIP.setVisibility(8);
                    if (this.eHR.aPM() != null && !StringUtils.isNull(this.eHR.aPM().getName()) && com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !aSq()) {
                        rVar.clT.setVisibility(0);
                        rVar.clT.setText(this.eMh.getResources().getString(d.j.chosen_pb_original_bar, this.eHR.aPM().getName()));
                    } else {
                        rVar.clT.setVisibility(8);
                    }
                }
                a(rVar.eIo, view, this.eNv);
                rVar.eIf.setVisibility(8);
                rVar.eIr.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rt() != null) {
                    j = postData.rt().getUserIdLong();
                    str = postData.rt().getUserName();
                    str2 = postData.rt().getName_show();
                }
                if (this.eHR != null && this.eHR.aPO() != null) {
                    rVar.eIr.a(postData.buB(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eHR.aPO().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                rVar.eIr.onChangeSkinType();
                if (this.eMh.aRk().aUT()) {
                    rVar.eIo.setVisibility(8);
                }
                if (this.eHR != null && this.eHR.aPO() != null && this.eHR.aPO().rG() != null) {
                    bq rG = this.eHR.aPO().rG();
                    final String activityUrl = rG.getActivityUrl();
                    String tb = rG.tb();
                    if (!StringUtils.isNull(rG.tc())) {
                        rVar.eNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.P(q.this.eMh.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tb)) {
                            rVar.czS.setVisibility(0);
                            rVar.czS.startLoad(tb, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.czS.setVisibility(8);
                }
                if (rVar.eNA != null) {
                    rVar.eNA.setVisibility(8);
                }
            }
            rVar.eIo.getLayoutStrategy().fM(d.f.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.buu()));
            if (postData.buy() > 0 && postData.bur() != null && postData.bur().size() > 0) {
                if (this.eHS == null) {
                    this.eHS = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHS.setIsFromCDN(this.mIsFromCDN);
                    this.eHS.F(this.eHU);
                    if (this.eHR != null) {
                        this.eHS.y(this.eHR.aPZ(), TextUtils.equals(this.eHR.aPO().rt().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eHS.M(this.eHR.aPO());
                    }
                }
                this.eHS.pQ(postData.getId());
            }
            rVar.eIo.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            if (this.eHP) {
                rVar.eIo.getLayoutStrategy().fP(d.f.transparent_bg);
            } else {
                rVar.eIo.getLayoutStrategy().fP(d.f.icon_click);
            }
            rVar.eIo.setIsFromCDN(this.mIsFromCDN);
            if (this.eHR != null && this.eHR.aPO() != null && this.eHR.aPO().isLinkThread()) {
                a(rVar, this.eHR.aPO().sM());
            }
            TbRichText aEt = postData.aEt();
            if (this.eHR != null && this.eHR.aQl()) {
                aEt = null;
            }
            if (this.eHV || !this.eHW) {
                rVar.eIo.a(aEt, false, this.eMU);
            } else {
                rVar.eIo.a(aEt, true, this.eMU);
            }
            a(rVar, postData, aEt);
            boolean z7 = !StringUtils.isNull(postData.rt().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eHR != null && this.eHR.aPZ() != 0) {
                z8 = true;
                z9 = true;
                if (postData.rt() != null) {
                    String userId = postData.rt().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eHR != null && this.eHR.aPO() != null && this.eHR.aPO().rt() != null && postData.rt() != null) {
                String userId2 = this.eHR.aPO().rt().getUserId();
                String userId3 = postData.rt().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.rt() == null && UtilHelper.isCurrentAccount(postData.rt().getUserId())) {
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
                    int i3 = 1;
                    if (postData.buu() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.g.tag_should_manage_visible, true);
                        if (postData.rt() != null) {
                            sparseArray2.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                        }
                        if (this.eHR != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eHR.aPZ()));
                        }
                    } else {
                        sparseArray2.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(d.g.tag_user_mute_visible, true);
                        sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rt() != null) {
                            sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                            sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                        }
                        if (this.eHR != null && this.eHR.aPO() != null) {
                            sparseArray2.put(d.g.tag_user_mute_thread_id, this.eHR.aPO().getId());
                        }
                        sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray2.put(d.g.tag_should_delete_visible, true);
                        sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.g.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(d.g.tag_del_post_id, postData.getId());
                        if (this.eHR != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eHR.aPZ()));
                        }
                    } else {
                        sparseArray2.put(d.g.tag_should_delete_visible, false);
                    }
                    b(rVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.rt() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.buu() == 1) {
            }
            sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(rVar);
        }
    }

    private void a(r rVar, com.baidu.tbadk.core.data.ah ahVar) {
        if (ahVar != null && !com.baidu.tbadk.core.util.am.isEmpty(ahVar.getLinkUrl()) && !rVar.eND.getIsLoaded() && ahVar.qd() == com.baidu.tbadk.core.data.ah.WX) {
            if (ahVar.qe()) {
                rVar.eNC.setVisibility(8);
                rVar.eND.setVisibility(8);
                return;
            }
            rVar.eIo.getLayoutStrategy().fS(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds48));
            rVar.eNC.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(rVar.eNC, d.C0080d.cp_bg_line_c);
            rVar.eND.setVisibility(0);
            rVar.eND.setFocusable(false);
            rVar.eND.setBackgroundColor(0);
            rVar.eND.getSettings().setCacheMode(-1);
            rVar.eND.setVerticalScrollBarEnabled(false);
            rVar.eND.setHorizontalScrollBarEnabled(false);
            rVar.eND.getSettings().setAllowFileAccess(true);
            rVar.eND.getSettings().setAppCacheEnabled(true);
            rVar.eND.getSettings().setDomStorageEnabled(true);
            rVar.eND.getSettings().setDatabaseEnabled(true);
            rVar.eND.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.eND.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.eND.loadUrl(ahVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aWP() == null) {
            rVar.eIJ.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aWP(), rVar.eIJ, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.eIo.setTextViewOnTouchListener(this.eNw);
        rVar.eIo.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ac - i, this.eHO);
            tbRichTextView.getLayoutStrategy().fN(min);
            tbRichTextView.getLayoutStrategy().fO((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.eIe.setOnTouchListener(this.aSw);
        rVar.eIe.setOnLongClickListener(this.auR);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eMh.getPageContext().getOrignalPage()).eKt;
        rVar.eIo.setOnLongClickListener(this.auR);
        rVar.eIo.setOnTouchListener(this.eNw);
        rVar.eIo.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.eIo.setOnImageClickListener(this.aSv);
        rVar.eIo.setOnImageTouchListener(this.eNw);
        rVar.eIo.setOnEmotionClickListener(aVar.eXJ);
        rVar.eIJ.setOnClickListener(this.mCommonClickListener);
        rVar.clT.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHR = fVar;
    }

    public void pt(int i) {
        this.eHO = i;
    }

    public void iy(boolean z) {
        this.eHP = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eHU = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSv = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auR = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eMU = bVar;
    }

    public void po(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eMh.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }

    public void a(int i, TextView textView, List<bc> list) {
        if (textView != null) {
            bc bcVar = (bc) com.baidu.tbadk.core.util.v.c(list, i);
            if (bcVar == null) {
                textView.setVisibility(8);
                return;
            }
            final String forumName = bcVar.getForumName();
            final String forumId = bcVar.getForumId();
            textView.setText(this.mContext.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    q.this.po(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12041").ac(ImageViewerConfig.FORUM_ID, forumId));
                    if (q.this.eHR != null && q.this.eHR.aPO() != null && q.this.eHR.aPO().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12123").ac(ImageViewerConfig.FORUM_ID, q.this.eHR.getForumId()).ac("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void iR(boolean z) {
        this.eNu = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).eND != null) {
            ((r) this.viewholder).eND.removeAllViews();
            ((r) this.viewholder).eND.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).eND.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).eND != null) {
                            ((r) q.this.viewholder).eND.destroy();
                            ((r) q.this.viewholder).eND = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).eND != null) {
            ((r) this.viewholder).eND.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).eND != null) {
            ((r) this.viewholder).eND.onPause();
        }
    }

    private boolean aSq() {
        return (this.eHR == null || this.eHR.aPO() == null || !this.eHR.aPO().sh() || this.eHR.aPO().rL() == null) ? false : true;
    }
}
