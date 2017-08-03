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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class o extends l<PostData, p> implements View.OnClickListener {
    private TbRichTextView.e aQA;
    private com.baidu.tieba.pb.a.c aQB;
    private View.OnLongClickListener auW;
    private View.OnClickListener cKt;
    private ArrayList<IconData> doi;
    protected int eEg;
    protected boolean eEh;
    private boolean eEi;
    protected com.baidu.tieba.pb.data.f eEj;
    private com.baidu.tieba.pb.pb.sub.d eEk;
    private ArrayList<IconData> eEl;
    private View.OnClickListener eEm;
    private boolean eEn;
    private final boolean eEo;
    private boolean eFP;
    private TbRichTextView.b eIF;
    private boolean eJe;
    private boolean eJf;
    private String eJg;
    private com.baidu.tieba.pb.a.c eJh;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eEg = 0;
        this.eEh = true;
        this.eEi = true;
        this.eJe = true;
        this.eEj = null;
        this.mHostId = null;
        this.eEk = null;
        this.eEl = null;
        this.doi = null;
        this.eEm = null;
        this.cKt = null;
        this.aQA = null;
        this.aQB = null;
        this.auW = null;
        this.eIF = null;
        this.eEn = false;
        this.eEo = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eJf = false;
        this.eFP = false;
        this.isBigV = false;
        this.eJh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aQB != null) {
                    o.this.aQB.aX(view);
                    o.this.aQB.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void oX(int i) {
        this.eJg = com.baidu.tbadk.core.util.al.z(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.k(pVar.eEw, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.j(pVar.eFe, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eFf, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eFg, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eFh, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.k(pVar.cKF, d.e.cp_bg_line_c);
                pVar.eEG.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.c(pVar.eJm, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eFe, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eFf, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eFg, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eFh, d.e.cp_cont_f, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eFn.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.eEh, this.eEg);
        a(pVar);
        return pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, p pVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, pVar);
        a(pVar);
        c(pVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.st();
            a(pVar, postData2, view, i);
        }
        if (!this.eEn && this.eEo && pVar != null && pVar.eEG.IU() && (listView = ((PbActivity) this.eFn.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eEn = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x055c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(p pVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        List<be> subList;
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.eEG.setTag(sparseArray);
            pVar.eEw.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eJe) {
                pVar.cKF.setVisibility(0);
            } else {
                pVar.cKF.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eEh) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eEG.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eEG.setLayoutParams(layoutParams);
                pVar.eEG.gV(null);
                this.eJf = false;
            } else {
                this.eJf = true;
                pVar.eEG.gV(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eEG.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eEG.setLayoutParams(layoutParams2);
            }
            pVar.eEG.setIsSupportNewFirstFloor(true);
            if (postData.bsr() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eEG.setOnClickListener(this.cKt);
                    pVar.eEG.setTextViewOnClickListener(this.cKt);
                } else {
                    pVar.eEG.setOnClickListener(null);
                    pVar.eEG.setTextViewOnClickListener(null);
                }
                pVar.eEw.setOnClickListener(this.cKt);
            } else {
                pVar.eEw.setOnClickListener(null);
            }
            if (postData.bsr() == 1) {
                if (!this.eFn.aQM()) {
                    if (this.eEj != null && !com.baidu.tbadk.core.util.u.v(this.eEj.aPt())) {
                        pVar.eFi.setVisibility(0);
                        if (this.eEj.aPt().size() <= 4) {
                            subList = this.eEj.aPt();
                        } else {
                            subList = this.eEj.aPt().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eFe, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eFf, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eFg, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eFh, subList);
                            }
                        }
                    } else {
                        pVar.eFi.setVisibility(8);
                    }
                } else {
                    pVar.eFi.setVisibility(8);
                }
                a(pVar.eEG, view, this.eJf);
                pVar.eEx.setVisibility(8);
                pVar.eEJ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.eEj != null && this.eEj.aOY() != null) {
                    pVar.eEJ.a(postData.bsy(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eEj.aOY().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.eEJ.onChangeSkinType();
                if (this.eFn.aQb().aTx()) {
                    pVar.eEG.setVisibility(8);
                }
                if (this.eEj != null && this.eEj.aOY() != null && this.eEj.aOY().rH() != null) {
                    bu rH = this.eEj.aOY().rH();
                    final String activityUrl = rH.getActivityUrl();
                    String tb = rH.tb();
                    if (!StringUtils.isNull(rH.tc())) {
                        pVar.eJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.k.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.U(o.this.eFn.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tb)) {
                            pVar.ckd.setVisibility(0);
                            pVar.ckd.c(tb, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.ckd.setVisibility(8);
                }
                if (pVar.eJl != null) {
                    pVar.eJl.setVisibility(8);
                }
            }
            pVar.eEG.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsr()));
            if (postData.bsv() > 0 && postData.bso() != null && postData.bso().size() > 0) {
                if (this.eEk == null) {
                    this.eEk = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eEk.setIsFromCDN(this.mIsFromCDN);
                    this.eEk.I(this.eEm);
                    if (this.eEj != null) {
                        this.eEk.B(this.eEj.aPj(), TextUtils.equals(this.eEj.aOY().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eEk.U(this.eEj.aOY());
                    }
                }
                this.eEk.pD(postData.getId());
            }
            pVar.eEG.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            if (this.eEh) {
                pVar.eEG.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eEG.setDefaultImageId(d.g.icon_click);
            }
            pVar.eEG.setIsFromCDN(this.mIsFromCDN);
            if (this.eEj != null && this.eEj.aOY() != null && this.eEj.aOY().isLinkThread()) {
                a(pVar, this.eEj.aOY().sL());
            }
            TbRichText aAE = postData.aAE();
            if (this.eEn || !this.eEo) {
                pVar.eEG.a(aAE, false, this.eIF);
            } else {
                pVar.eEG.a(aAE, true, this.eIF);
            }
            a(pVar, postData, aAE);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eEj != null && this.eEj.aPj() != 0) {
                z8 = true;
                z9 = true;
                if (postData.getAuthor() != null) {
                    String userId = postData.getAuthor().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.eEj != null && this.eEj.aOY() != null && this.eEj.aOY().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eEj.aOY().getAuthor().getUserId();
                String userId3 = postData.getAuthor().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z2 = true;
                    if (!UtilHelper.isCurrentAccount(userId3)) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    if (postData.getAuthor() == null && UtilHelper.isCurrentAccount(postData.getAuthor().getUserId())) {
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
                    if (postData.bsr() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eEj != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eEj.aPj()));
                        }
                    } else {
                        sparseArray2.put(d.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(d.h.tag_user_mute_visible, true);
                        sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eEj != null && this.eEj.aOY() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eEj.aOY().getId());
                        }
                        sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray2.put(d.h.tag_should_delete_visible, true);
                        sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(d.h.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(d.h.tag_del_post_id, postData.getId());
                        if (this.eEj != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eEj.aPj()));
                        }
                    } else {
                        sparseArray2.put(d.h.tag_should_delete_visible, false);
                    }
                    b(pVar);
                }
            }
            z = false;
            z2 = z9;
            z3 = false;
            if (postData.getAuthor() == null) {
            }
            boolean z102 = z3;
            z4 = z2;
            z5 = z102;
            if (z7) {
            }
            int i32 = 1;
            if (postData.bsr() == 1) {
            }
            sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(pVar);
        }
    }

    private void a(p pVar, com.baidu.tbadk.core.data.aj ajVar) {
        if (ajVar != null && !com.baidu.tbadk.core.util.al.isEmpty(ajVar.getLinkUrl()) && !pVar.eJo.getIsLoaded() && ajVar.qf() == com.baidu.tbadk.core.data.aj.Wi) {
            if (ajVar.qg()) {
                pVar.eJn.setVisibility(8);
                pVar.eJo.setVisibility(8);
                return;
            }
            pVar.eEG.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48));
            pVar.eJn.setVisibility(0);
            com.baidu.tbadk.core.util.ai.k(pVar.eJn, d.e.cp_bg_line_c);
            pVar.eJo.setVisibility(0);
            pVar.eJo.setFocusable(false);
            pVar.eJo.setBackgroundColor(0);
            pVar.eJo.getSettings().setCacheMode(-1);
            pVar.eJo.setVerticalScrollBarEnabled(false);
            pVar.eJo.setHorizontalScrollBarEnabled(false);
            pVar.eJo.getSettings().setAllowFileAccess(true);
            pVar.eJo.getSettings().setAppCacheEnabled(true);
            pVar.eJo.getSettings().setDomStorageEnabled(true);
            pVar.eJo.getSettings().setDatabaseEnabled(true);
            pVar.eJo.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eJo.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eJo.loadUrl(ajVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aVx() == null) {
            pVar.eFc.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aVx(), pVar.eFc, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eEG.setTextViewOnTouchListener(this.eJh);
        pVar.eEG.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int af = (((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(af - i, this.eEg);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eEw.setOnTouchListener(this.aQB);
        pVar.eEw.setOnLongClickListener(this.auW);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eFn.getPageContext().getOrignalPage()).eGd;
        pVar.eEG.setOnLongClickListener(this.auW);
        pVar.eEG.setOnTouchListener(this.eJh);
        pVar.eEG.setCommonTextViewOnClickListener(this.cKt);
        pVar.eEG.setOnImageClickListener(this.aQA);
        pVar.eEG.setOnImageTouchListener(this.eJh);
        pVar.eEG.setOnEmotionClickListener(aVar.eSA);
        pVar.eFc.setOnClickListener(this.cKt);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eEj = fVar;
    }

    public void oO(int i) {
        this.eEg = i;
    }

    public void iP(boolean z) {
        this.eEh = z;
    }

    public void iQ(boolean z) {
        this.eEi = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eEm = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cKt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aQA = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aQB = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auW = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eIF = bVar;
    }

    public void pe(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eFn.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }

    public void a(int i, TextView textView, List<be> list) {
        if (textView != null) {
            be beVar = (be) com.baidu.tbadk.core.util.u.c(list, i);
            if (beVar == null) {
                textView.setVisibility(8);
                return;
            }
            final String forumName = beVar.getForumName();
            final String forumId = beVar.getForumId();
            textView.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    o.this.pe(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12041").aa("fid", forumId));
                    if (o.this.eEj != null && o.this.eEj.aOY() != null && o.this.eEj.aOY().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12123").aa("fid", o.this.eEj.getForumId()).aa("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void jf(boolean z) {
        this.eJe = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eJo != null) {
            ((p) this.viewholder).eJo.removeAllViews();
            ((p) this.viewholder).eJo.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eJo.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eJo != null) {
                            ((p) o.this.viewholder).eJo.destroy();
                            ((p) o.this.viewholder).eJo = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eJo != null) {
            ((p) this.viewholder).eJo.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eJo != null) {
            ((p) this.viewholder).eJo.onPause();
        }
    }
}
