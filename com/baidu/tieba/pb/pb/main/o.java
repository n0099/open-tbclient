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
import com.baidu.tbadk.core.data.bs;
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
    private TbRichTextView.e aRy;
    private com.baidu.tieba.pb.a.c aRz;
    private View.OnLongClickListener avB;
    private View.OnClickListener cUc;
    private ArrayList<IconData> dyb;
    protected int eFI;
    protected boolean eFJ;
    private boolean eFK;
    protected com.baidu.tieba.pb.data.f eFL;
    private com.baidu.tieba.pb.pb.sub.d eFM;
    private ArrayList<IconData> eFN;
    private View.OnClickListener eFO;
    private boolean eFP;
    private final boolean eFQ;
    private boolean eHs;
    private boolean eKE;
    private boolean eKF;
    private String eKG;
    private com.baidu.tieba.pb.a.c eKH;
    private TbRichTextView.b eKe;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eFI = 0;
        this.eFJ = true;
        this.eFK = true;
        this.eKE = true;
        this.eFL = null;
        this.mHostId = null;
        this.eFM = null;
        this.eFN = null;
        this.dyb = null;
        this.eFO = null;
        this.cUc = null;
        this.aRy = null;
        this.aRz = null;
        this.avB = null;
        this.eKe = null;
        this.eFP = false;
        this.eFQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eKF = false;
        this.eHs = false;
        this.isBigV = false;
        this.eKH = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aRz != null) {
                    o.this.aRz.bf(view);
                    o.this.aRz.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void po(int i) {
        this.eKG = com.baidu.tbadk.core.util.am.y(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(pVar.eFY, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.j(pVar.eGG, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eGH, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eGI, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eGJ, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.k(pVar.cUo, d.e.cp_bg_line_c);
                pVar.eGi.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(pVar.eKM, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eGG, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eGH, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eGI, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eGJ, d.e.cp_cont_f, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eGQ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.eFJ, this.eFI);
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
            postData2.sz();
            a(pVar, postData2, view, i);
        }
        if (!this.eFP && this.eFQ && pVar != null && pVar.eGi.Jj() && (listView = ((PbActivity) this.eGQ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eFP = true;
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
            pVar.eGi.setTag(sparseArray);
            pVar.eFY.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eKE) {
                pVar.cUo.setVisibility(0);
            } else {
                pVar.cUo.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eFJ) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eGi.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eGi.setLayoutParams(layoutParams);
                pVar.eGi.gZ(null);
                this.eKF = false;
            } else {
                this.eKF = true;
                pVar.eGi.gZ(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eGi.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eGi.setLayoutParams(layoutParams2);
            }
            pVar.eGi.setIsSupportNewFirstFloor(true);
            if (postData.bso() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eGi.setOnClickListener(this.cUc);
                    pVar.eGi.setTextViewOnClickListener(this.cUc);
                } else {
                    pVar.eGi.setOnClickListener(null);
                    pVar.eGi.setTextViewOnClickListener(null);
                }
                pVar.eFY.setOnClickListener(this.cUc);
            } else {
                pVar.eFY.setOnClickListener(null);
            }
            if (postData.bso() == 1) {
                if (!this.eGQ.aQN()) {
                    if (this.eFL != null && !com.baidu.tbadk.core.util.v.v(this.eFL.aPr())) {
                        pVar.eGK.setVisibility(0);
                        if (this.eFL.aPr().size() <= 4) {
                            subList = this.eFL.aPr();
                        } else {
                            subList = this.eFL.aPr().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eGG, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eGH, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eGI, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eGJ, subList);
                            }
                        }
                    } else {
                        pVar.eGK.setVisibility(8);
                    }
                } else {
                    pVar.eGK.setVisibility(8);
                }
                a(pVar.eGi, view, this.eKF);
                pVar.eFZ.setVisibility(8);
                pVar.eGl.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.eFL != null && this.eFL.aOX() != null) {
                    pVar.eGl.a(postData.bsv(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eFL.aOX().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.eGl.onChangeSkinType();
                if (this.eGQ.aQb().aTu()) {
                    pVar.eGi.setVisibility(8);
                }
                if (this.eFL != null && this.eFL.aOX() != null && this.eFL.aOX().rN() != null) {
                    bs rN = this.eFL.aOX().rN();
                    final String activityUrl = rN.getActivityUrl();
                    String ti = rN.ti();
                    if (!StringUtils.isNull(rN.tj())) {
                        pVar.eKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.k.hz()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.U(o.this.eGQ.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(ti)) {
                            pVar.crs.setVisibility(0);
                            pVar.crs.c(ti, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.crs.setVisibility(8);
                }
                if (pVar.eKL != null) {
                    pVar.eKL.setVisibility(8);
                }
            }
            pVar.eGi.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bso()));
            if (postData.bss() > 0 && postData.bsl() != null && postData.bsl().size() > 0) {
                if (this.eFM == null) {
                    this.eFM = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eFM.setIsFromCDN(this.mIsFromCDN);
                    this.eFM.C(this.eFO);
                    if (this.eFL != null) {
                        this.eFM.z(this.eFL.aPi(), TextUtils.equals(this.eFL.aOX().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eFM.Z(this.eFL.aOX());
                    }
                }
                this.eFM.pB(postData.getId());
            }
            pVar.eGi.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            if (this.eFJ) {
                pVar.eGi.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eGi.setDefaultImageId(d.g.icon_click);
            }
            pVar.eGi.setIsFromCDN(this.mIsFromCDN);
            if (this.eFL != null && this.eFL.aOX() != null && this.eFL.aOX().isLinkThread()) {
                a(pVar, this.eFL.aOX().sS());
            }
            TbRichText aDg = postData.aDg();
            if (this.eFP || !this.eFQ) {
                pVar.eGi.a(aDg, false, this.eKe);
            } else {
                pVar.eGi.a(aDg, true, this.eKe);
            }
            a(pVar, postData, aDg);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eFL != null && this.eFL.aPi() != 0) {
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
            if (this.eFL != null && this.eFL.aOX() != null && this.eFL.aOX().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eFL.aOX().getAuthor().getUserId();
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
                    if (postData.bso() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eFL != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFL.aPi()));
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
                        if (this.eFL != null && this.eFL.aOX() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eFL.aOX().getId());
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
                        if (this.eFL != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFL.aPi()));
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
            if (postData.bso() == 1) {
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
        if (ajVar != null && !com.baidu.tbadk.core.util.am.isEmpty(ajVar.getLinkUrl()) && !pVar.eKO.getIsLoaded() && ajVar.ql() == com.baidu.tbadk.core.data.aj.WQ) {
            if (ajVar.qm()) {
                pVar.eKN.setVisibility(8);
                pVar.eKO.setVisibility(8);
                return;
            }
            pVar.eGi.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48));
            pVar.eKN.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(pVar.eKN, d.e.cp_bg_line_c);
            pVar.eKO.setVisibility(0);
            pVar.eKO.setFocusable(false);
            pVar.eKO.setBackgroundColor(0);
            pVar.eKO.getSettings().setCacheMode(-1);
            pVar.eKO.setVerticalScrollBarEnabled(false);
            pVar.eKO.setHorizontalScrollBarEnabled(false);
            pVar.eKO.getSettings().setAllowFileAccess(true);
            pVar.eKO.getSettings().setAppCacheEnabled(true);
            pVar.eKO.getSettings().setDomStorageEnabled(true);
            pVar.eKO.getSettings().setDatabaseEnabled(true);
            pVar.eKO.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eKO.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eKO.loadUrl(ajVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aVy() == null) {
            pVar.eGE.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aVy(), pVar.eGE, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eGi.setTextViewOnTouchListener(this.eKH);
        pVar.eGi.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ad = (((com.baidu.adp.lib.util.k.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(ad - i, this.eFI);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eFY.setOnTouchListener(this.aRz);
        pVar.eFY.setOnLongClickListener(this.avB);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eGQ.getPageContext().getOrignalPage()).eHF;
        pVar.eGi.setOnLongClickListener(this.avB);
        pVar.eGi.setOnTouchListener(this.eKH);
        pVar.eGi.setCommonTextViewOnClickListener(this.cUc);
        pVar.eGi.setOnImageClickListener(this.aRy);
        pVar.eGi.setOnImageTouchListener(this.eKH);
        pVar.eGi.setOnEmotionClickListener(aVar.eUj);
        pVar.eGE.setOnClickListener(this.cUc);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eFL = fVar;
    }

    public void pf(int i) {
        this.eFI = i;
    }

    public void iS(boolean z) {
        this.eFJ = z;
    }

    public void iT(boolean z) {
        this.eFK = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void A(View.OnClickListener onClickListener) {
        this.eFO = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cUc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRy = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRz = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avB = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eKe = bVar;
    }

    public void pd(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eGQ.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }

    public void a(int i, TextView textView, List<be> list) {
        if (textView != null) {
            be beVar = (be) com.baidu.tbadk.core.util.v.c(list, i);
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
                    o.this.pd(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12041").ad("fid", forumId));
                    if (o.this.eFL != null && o.this.eFL.aOX() != null && o.this.eFL.aOX().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12123").ad("fid", o.this.eFL.getForumId()).ad("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void jj(boolean z) {
        this.eKE = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eKO != null) {
            ((p) this.viewholder).eKO.removeAllViews();
            ((p) this.viewholder).eKO.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eKO.setVisibility(8);
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eKO != null) {
                            ((p) o.this.viewholder).eKO.destroy();
                            ((p) o.this.viewholder).eKO = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eKO != null) {
            ((p) this.viewholder).eKO.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eKO != null) {
            ((p) this.viewholder).eKO.onPause();
        }
    }
}
