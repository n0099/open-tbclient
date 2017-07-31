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
    private TbRichTextView.e aRM;
    private com.baidu.tieba.pb.a.c aRN;
    private View.OnLongClickListener awn;
    private View.OnClickListener cLO;
    private ArrayList<IconData> dpA;
    private boolean eFA;
    private final boolean eFB;
    protected int eFt;
    protected boolean eFu;
    private boolean eFv;
    protected com.baidu.tieba.pb.data.f eFw;
    private com.baidu.tieba.pb.pb.sub.d eFx;
    private ArrayList<IconData> eFy;
    private View.OnClickListener eFz;
    private boolean eHc;
    private TbRichTextView.b eJS;
    private boolean eKr;
    private boolean eKs;
    private String eKt;
    private com.baidu.tieba.pb.a.c eKu;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eFt = 0;
        this.eFu = true;
        this.eFv = true;
        this.eKr = true;
        this.eFw = null;
        this.mHostId = null;
        this.eFx = null;
        this.eFy = null;
        this.dpA = null;
        this.eFz = null;
        this.cLO = null;
        this.aRM = null;
        this.aRN = null;
        this.awn = null;
        this.eJS = null;
        this.eFA = false;
        this.eFB = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eKs = false;
        this.eHc = false;
        this.isBigV = false;
        this.eKu = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aRN != null) {
                    o.this.aRN.aX(view);
                    o.this.aRN.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void oX(int i) {
        this.eKt = com.baidu.tbadk.core.util.al.z(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.k(pVar.eFJ, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.j(pVar.eGr, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eGs, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eGt, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eGu, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.k(pVar.cMa, d.e.cp_bg_line_c);
                pVar.eFT.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.c(pVar.eKz, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eGr, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eGs, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eGt, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eGu, d.e.cp_cont_f, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eGA.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.eFu, this.eFt);
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
            postData2.sD();
            a(pVar, postData2, view, i);
        }
        if (!this.eFA && this.eFB && pVar != null && pVar.eFT.Jb() && (listView = ((PbActivity) this.eGA.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eFA = true;
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
            pVar.eFT.setTag(sparseArray);
            pVar.eFJ.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eKr) {
                pVar.cMa.setVisibility(0);
            } else {
                pVar.cMa.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eFu) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eFT.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eFT.setLayoutParams(layoutParams);
                pVar.eFT.ha(null);
                this.eKs = false;
            } else {
                this.eKs = true;
                pVar.eFT.ha(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eFT.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eFT.setLayoutParams(layoutParams2);
            }
            pVar.eFT.setIsSupportNewFirstFloor(true);
            if (postData.bsy() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eFT.setOnClickListener(this.cLO);
                    pVar.eFT.setTextViewOnClickListener(this.cLO);
                } else {
                    pVar.eFT.setOnClickListener(null);
                    pVar.eFT.setTextViewOnClickListener(null);
                }
                pVar.eFJ.setOnClickListener(this.cLO);
            } else {
                pVar.eFJ.setOnClickListener(null);
            }
            if (postData.bsy() == 1) {
                if (!this.eGA.aQX()) {
                    if (this.eFw != null && !com.baidu.tbadk.core.util.u.v(this.eFw.aPE())) {
                        pVar.eGv.setVisibility(0);
                        if (this.eFw.aPE().size() <= 4) {
                            subList = this.eFw.aPE();
                        } else {
                            subList = this.eFw.aPE().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eGr, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eGs, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eGt, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eGu, subList);
                            }
                        }
                    } else {
                        pVar.eGv.setVisibility(8);
                    }
                } else {
                    pVar.eGv.setVisibility(8);
                }
                a(pVar.eFT, view, this.eKs);
                pVar.eFK.setVisibility(8);
                pVar.eFW.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.eFw != null && this.eFw.aPj() != null) {
                    pVar.eFW.a(postData.bsF(), str, str2, j, com.baidu.adp.lib.g.b.d(this.eFw.aPj().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                pVar.eFW.onChangeSkinType();
                if (this.eGA.aQm().aTI()) {
                    pVar.eFT.setVisibility(8);
                }
                if (this.eFw != null && this.eFw.aPj() != null && this.eFw.aPj().rR() != null) {
                    bu rR = this.eFw.aPj().rR();
                    final String activityUrl = rR.getActivityUrl();
                    String tl = rR.tl();
                    if (!StringUtils.isNull(rR.tm())) {
                        pVar.eKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.k.hI()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.U(o.this.eGA.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tl)) {
                            pVar.cll.setVisibility(0);
                            pVar.cll.c(tl, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.cll.setVisibility(8);
                }
                if (pVar.eKy != null) {
                    pVar.eKy.setVisibility(8);
                }
            }
            pVar.eFT.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsy()));
            if (postData.bsC() > 0 && postData.bsv() != null && postData.bsv().size() > 0) {
                if (this.eFx == null) {
                    this.eFx = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eFx.setIsFromCDN(this.mIsFromCDN);
                    this.eFx.I(this.eFz);
                    if (this.eFw != null) {
                        this.eFx.C(this.eFw.aPu(), TextUtils.equals(this.eFw.aPj().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eFx.U(this.eFw.aPj());
                    }
                }
                this.eFx.pI(postData.getId());
            }
            pVar.eFT.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            if (this.eFu) {
                pVar.eFT.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eFT.setDefaultImageId(d.g.icon_click);
            }
            pVar.eFT.setIsFromCDN(this.mIsFromCDN);
            if (this.eFw != null && this.eFw.aPj() != null && this.eFw.aPj().isLinkThread()) {
                a(pVar, this.eFw.aPj().sV());
            }
            TbRichText aAP = postData.aAP();
            if (this.eFA || !this.eFB) {
                pVar.eFT.a(aAP, false, this.eJS);
            } else {
                pVar.eFT.a(aAP, true, this.eJS);
            }
            a(pVar, postData, aAP);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eFw != null && this.eFw.aPu() != 0) {
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
            if (this.eFw != null && this.eFw.aPj() != null && this.eFw.aPj().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eFw.aPj().getAuthor().getUserId();
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
                    if (postData.bsy() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eFw != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFw.aPu()));
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
                        if (this.eFw != null && this.eFw.aPj() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eFw.aPj().getId());
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
                        if (this.eFw != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eFw.aPu()));
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
            if (postData.bsy() == 1) {
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
        if (ajVar != null && !com.baidu.tbadk.core.util.al.isEmpty(ajVar.getLinkUrl()) && !pVar.eKB.getIsLoaded() && ajVar.qp() == com.baidu.tbadk.core.data.aj.XE) {
            if (ajVar.qq()) {
                pVar.eKA.setVisibility(8);
                pVar.eKB.setVisibility(8);
                return;
            }
            pVar.eFT.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48));
            pVar.eKA.setVisibility(0);
            com.baidu.tbadk.core.util.ai.k(pVar.eKA, d.e.cp_bg_line_c);
            pVar.eKB.setVisibility(0);
            pVar.eKB.setFocusable(false);
            pVar.eKB.setBackgroundColor(0);
            pVar.eKB.getSettings().setCacheMode(-1);
            pVar.eKB.setVerticalScrollBarEnabled(false);
            pVar.eKB.setHorizontalScrollBarEnabled(false);
            pVar.eKB.getSettings().setAllowFileAccess(true);
            pVar.eKB.getSettings().setAppCacheEnabled(true);
            pVar.eKB.getSettings().setDomStorageEnabled(true);
            pVar.eKB.getSettings().setDatabaseEnabled(true);
            pVar.eKB.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eKB.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eKB.loadUrl(ajVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aVI() == null) {
            pVar.eGp.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aVI(), pVar.eGp, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eFT.setTextViewOnTouchListener(this.eKu);
        pVar.eFT.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ag = (((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(ag - i, this.eFt);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eFJ.setOnTouchListener(this.aRN);
        pVar.eFJ.setOnLongClickListener(this.awn);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eGA.getPageContext().getOrignalPage()).eHq;
        pVar.eFT.setOnLongClickListener(this.awn);
        pVar.eFT.setOnTouchListener(this.eKu);
        pVar.eFT.setCommonTextViewOnClickListener(this.cLO);
        pVar.eFT.setOnImageClickListener(this.aRM);
        pVar.eFT.setOnImageTouchListener(this.eKu);
        pVar.eFT.setOnEmotionClickListener(aVar.eTN);
        pVar.eGp.setOnClickListener(this.cLO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eFw = fVar;
    }

    public void oO(int i) {
        this.eFt = i;
    }

    public void iP(boolean z) {
        this.eFu = z;
    }

    public void iQ(boolean z) {
        this.eFv = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eFz = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cLO = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRM = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRN = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awn = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eJS = bVar;
    }

    public void pi(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eGA.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
                    o.this.pi(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12041").aa("fid", forumId));
                    if (o.this.eFw != null && o.this.eFw.aPj() != null && o.this.eFw.aPj().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12123").aa("fid", o.this.eFw.getForumId()).aa("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void jf(boolean z) {
        this.eKr = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eKB != null) {
            ((p) this.viewholder).eKB.removeAllViews();
            ((p) this.viewholder).eKB.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eKB.setVisibility(8);
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eKB != null) {
                            ((p) o.this.viewholder).eKB.destroy();
                            ((p) o.this.viewholder).eKB = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eKB != null) {
            ((p) this.viewholder).eKB.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eKB != null) {
            ((p) this.viewholder).eKB.onPause();
        }
    }
}
