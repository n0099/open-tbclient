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
    private TbRichTextView.f aSD;
    private com.baidu.tieba.pb.a.c aSE;
    private View.OnLongClickListener auZ;
    protected int eIi;
    protected boolean eIj;
    protected com.baidu.tieba.pb.data.f eIl;
    private com.baidu.tieba.pb.pb.sub.d eIm;
    private View.OnClickListener eIo;
    private boolean eIp;
    private final boolean eIq;
    private boolean eNO;
    private boolean eNP;
    private com.baidu.tieba.pb.a.c eNQ;
    private TbRichTextView.b eNo;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eIi = 0;
        this.eIj = true;
        this.eNO = true;
        this.eIl = null;
        this.eIm = null;
        this.eIo = null;
        this.mCommonClickListener = null;
        this.aSD = null;
        this.aSE = null;
        this.auZ = null;
        this.eNo = null;
        this.eIp = false;
        this.eIq = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eNP = false;
        this.eNQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.q.1
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
                if (q.this.aSE != null) {
                    q.this.aSE.bg(view);
                    q.this.aSE.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    private void a(r rVar) {
        if (rVar != null) {
            if (rVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(rVar.eIy, d.C0080d.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.j(rVar.eJf, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(rVar.eJg, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(rVar.eJh, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(rVar.eJi, d.f.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.k(rVar.dfj, d.C0080d.cp_bg_line_c);
                rVar.eII.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(rVar.eNV, d.C0080d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eJf, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eJg, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eJh, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(rVar.eJi, d.C0080d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.j(rVar.cmn, d.f.bg_first_floor_forum_name);
                com.baidu.tbadk.core.util.aj.c(rVar.cmn, d.C0080d.cp_cont_j, 1);
            }
            rVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public r onCreateViewHolder(ViewGroup viewGroup) {
        r rVar = new r(this.eMB.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.new_pb_list_first_floor_item, viewGroup, false), this.eIj, this.eIi);
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
        if (!this.eIp && this.eIq && rVar != null && rVar.eII.JI() && (listView = ((PbActivity) this.eMB.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eIp = true;
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
            rVar.eII.setTag(sparseArray);
            rVar.eIy.setTag(d.g.tag_from, sparseArray);
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            if (this.eNO) {
                rVar.dfj.setVisibility(0);
            } else {
                rVar.dfj.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eIj) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rVar.eII.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                rVar.eII.setLayoutParams(layoutParams);
                rVar.eII.hf(null);
                this.eNP = false;
            } else {
                this.eNP = true;
                rVar.eII.hf(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) rVar.eII.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.e.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.e.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                rVar.eII.setLayoutParams(layoutParams2);
            }
            if (postData.buG() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    rVar.eII.setOnClickListener(this.mCommonClickListener);
                    rVar.eII.setTextViewOnClickListener(this.mCommonClickListener);
                } else {
                    rVar.eII.setOnClickListener(null);
                    rVar.eII.setTextViewOnClickListener(null);
                }
                rVar.eIy.setOnClickListener(this.mCommonClickListener);
            } else {
                rVar.eIy.setOnClickListener(null);
            }
            if (postData.buG() == 1) {
                if (!this.eMB.aSd()) {
                    if (this.eIl != null && !com.baidu.tbadk.core.util.v.v(this.eIl.aQq())) {
                        rVar.eJj.setVisibility(0);
                        if (this.eIl.aQq().size() <= 4) {
                            subList = this.eIl.aQq();
                        } else {
                            subList = this.eIl.aQq().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, rVar.eJf, subList);
                            } else if (i2 == 1) {
                                a(i2, rVar.eJg, subList);
                            } else if (i2 == 2) {
                                a(i2, rVar.eJh, subList);
                            } else if (i2 == 3) {
                                a(i2, rVar.eJi, subList);
                            }
                        }
                    } else {
                        rVar.eJj.setVisibility(8);
                    }
                    rVar.cmn.setVisibility(8);
                } else {
                    rVar.eJj.setVisibility(8);
                    if (this.eIl.aPU() != null && !StringUtils.isNull(this.eIl.aPU().getName()) && com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !aSy()) {
                        rVar.cmn.setVisibility(0);
                        rVar.cmn.setText(this.eMB.getResources().getString(d.j.chosen_pb_original_bar, this.eIl.aPU().getName()));
                    } else {
                        rVar.cmn.setVisibility(8);
                    }
                }
                a(rVar.eII, view, this.eNP);
                rVar.eIz.setVisibility(8);
                rVar.eIL.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rt() != null) {
                    j = postData.rt().getUserIdLong();
                    str = postData.rt().getUserName();
                    str2 = postData.rt().getName_show();
                }
                if (this.eIl != null && this.eIl.aPW() != null) {
                    rVar.eIL.a(postData.buN(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eIl.aPW().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                rVar.eIL.onChangeSkinType();
                if (this.eMB.aRs().aVb()) {
                    rVar.eII.setVisibility(8);
                }
                if (this.eIl != null && this.eIl.aPW() != null && this.eIl.aPW().rG() != null) {
                    bq rG = this.eIl.aPW().rG();
                    final String activityUrl = rG.getActivityUrl();
                    String tb = rG.tb();
                    if (!StringUtils.isNull(rG.tc())) {
                        rVar.eNT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.q.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.P(q.this.eMB.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tb)) {
                            rVar.cAl.setVisibility(0);
                            rVar.cAl.startLoad(tb, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    rVar.cAl.setVisibility(8);
                }
                if (rVar.eNU != null) {
                    rVar.eNU.setVisibility(8);
                }
            }
            rVar.eII.getLayoutStrategy().fL(d.f.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.g.tag_clip_board, postData);
            sparseArray2.put(d.g.tag_load_sub_data, postData);
            sparseArray2.put(d.g.tag_load_sub_view, view);
            sparseArray2.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.buG()));
            if (postData.buK() > 0 && postData.buD() != null && postData.buD().size() > 0) {
                if (this.eIm == null) {
                    this.eIm = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eIm.setIsFromCDN(this.mIsFromCDN);
                    this.eIm.F(this.eIo);
                    if (this.eIl != null) {
                        this.eIm.z(this.eIl.aQh(), TextUtils.equals(this.eIl.aPW().rt().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eIm.M(this.eIl.aPW());
                    }
                }
                this.eIm.pU(postData.getId());
            }
            rVar.eII.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
            if (this.eIj) {
                rVar.eII.getLayoutStrategy().fO(d.f.transparent_bg);
            } else {
                rVar.eII.getLayoutStrategy().fO(d.f.icon_click);
            }
            rVar.eII.setIsFromCDN(this.mIsFromCDN);
            if (this.eIl != null && this.eIl.aPW() != null && this.eIl.aPW().isLinkThread()) {
                a(rVar, this.eIl.aPW().sM());
            }
            TbRichText aEx = postData.aEx();
            if (this.eIl != null && this.eIl.aQt()) {
                aEx = null;
            }
            if (this.eIp || !this.eIq) {
                rVar.eII.a(aEx, false, this.eNo);
            } else {
                rVar.eII.a(aEx, true, this.eNo);
            }
            a(rVar, postData, aEx);
            boolean z7 = !StringUtils.isNull(postData.rt().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eIl != null && this.eIl.aQh() != 0) {
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
            if (this.eIl != null && this.eIl.aPW() != null && this.eIl.aPW().rt() != null && postData.rt() != null) {
                String userId2 = this.eIl.aPW().rt().getUserId();
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
                    if (postData.buG() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.g.tag_should_manage_visible, true);
                        if (postData.rt() != null) {
                            sparseArray2.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                        }
                        if (this.eIl != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eIl.aQh()));
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
                        if (this.eIl != null && this.eIl.aPW() != null) {
                            sparseArray2.put(d.g.tag_user_mute_thread_id, this.eIl.aPW().getId());
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
                        if (this.eIl != null) {
                            sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.eIl.aQh()));
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
            if (postData.buG() == 1) {
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
        if (ahVar != null && !com.baidu.tbadk.core.util.am.isEmpty(ahVar.getLinkUrl()) && !rVar.eNX.getIsLoaded() && ahVar.qd() == com.baidu.tbadk.core.data.ah.WX) {
            if (ahVar.qe()) {
                rVar.eNW.setVisibility(8);
                rVar.eNX.setVisibility(8);
                return;
            }
            rVar.eII.getLayoutStrategy().fR(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds48));
            rVar.eNW.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(rVar.eNW, d.C0080d.cp_bg_line_c);
            rVar.eNX.setVisibility(0);
            rVar.eNX.setFocusable(false);
            rVar.eNX.setBackgroundColor(0);
            rVar.eNX.getSettings().setCacheMode(-1);
            rVar.eNX.setVerticalScrollBarEnabled(false);
            rVar.eNX.setHorizontalScrollBarEnabled(false);
            rVar.eNX.getSettings().setAllowFileAccess(true);
            rVar.eNX.getSettings().setAppCacheEnabled(true);
            rVar.eNX.getSettings().setDomStorageEnabled(true);
            rVar.eNX.getSettings().setDatabaseEnabled(true);
            rVar.eNX.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.q.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            rVar.eNX.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.q.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            rVar.eNX.loadUrl(ahVar.getLinkUrl());
        }
    }

    private void a(r rVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aWX() == null) {
            rVar.eJd.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aWX(), rVar.eJd, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(r rVar) {
        rVar.eII.setTextViewOnTouchListener(this.eNQ);
        rVar.eII.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ac = (((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.e.ds80);
            }
            int min = Math.min(ac - i, this.eIi);
            tbRichTextView.getLayoutStrategy().fM(min);
            tbRichTextView.getLayoutStrategy().fN((int) (min * 1.618f));
        }
    }

    private void c(r rVar) {
        rVar.eIy.setOnTouchListener(this.aSE);
        rVar.eIy.setOnLongClickListener(this.auZ);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eMB.getPageContext().getOrignalPage()).eKN;
        rVar.eII.setOnLongClickListener(this.auZ);
        rVar.eII.setOnTouchListener(this.eNQ);
        rVar.eII.setCommonTextViewOnClickListener(this.mCommonClickListener);
        rVar.eII.setOnImageClickListener(this.aSD);
        rVar.eII.setOnImageTouchListener(this.eNQ);
        rVar.eII.setOnEmotionClickListener(aVar.eYe);
        rVar.eJd.setOnClickListener(this.mCommonClickListener);
        rVar.cmn.setOnClickListener(this.mCommonClickListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eIl = fVar;
    }

    public void pu(int i) {
        this.eIi = i;
    }

    public void iE(boolean z) {
        this.eIj = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eIo = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSD = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auZ = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eNo = bVar;
    }

    public void ps(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eMB.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
                    q.this.ps(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12041").ac(ImageViewerConfig.FORUM_ID, forumId));
                    if (q.this.eIl != null && q.this.eIl.aPW() != null && q.this.eIl.aPW().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12123").ac(ImageViewerConfig.FORUM_ID, q.this.eIl.getForumId()).ac("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void iX(boolean z) {
        this.eNO = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((r) this.viewholder).eNX != null) {
            ((r) this.viewholder).eNX.removeAllViews();
            ((r) this.viewholder).eNX.getSettings().setBuiltInZoomControls(true);
            ((r) this.viewholder).eNX.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.q.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (q.this.viewholder != null && ((r) q.this.viewholder).eNX != null) {
                            ((r) q.this.viewholder).eNX.destroy();
                            ((r) q.this.viewholder).eNX = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((r) this.viewholder).eNX != null) {
            ((r) this.viewholder).eNX.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((r) this.viewholder).eNX != null) {
            ((r) this.viewholder).eNX.onPause();
        }
    }

    private boolean aSy() {
        return (this.eIl == null || this.eIl.aPW() == null || !this.eIl.aPW().sh() || this.eIl.aPW().rL() == null) ? false : true;
    }
}
