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
    private TbRichTextView.e aRv;
    private com.baidu.tieba.pb.a.c aRw;
    private View.OnLongClickListener avy;
    private View.OnClickListener cUW;
    private ArrayList<IconData> dyW;
    protected int eGC;
    protected boolean eGD;
    private boolean eGE;
    protected com.baidu.tieba.pb.data.f eGF;
    private com.baidu.tieba.pb.pb.sub.d eGG;
    private ArrayList<IconData> eGH;
    private View.OnClickListener eGI;
    private boolean eGJ;
    private final boolean eGK;
    private boolean eIm;
    private TbRichTextView.b eKY;
    private String eLA;
    private com.baidu.tieba.pb.a.c eLB;
    private boolean eLy;
    private boolean eLz;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eGC = 0;
        this.eGD = true;
        this.eGE = true;
        this.eLy = true;
        this.eGF = null;
        this.mHostId = null;
        this.eGG = null;
        this.eGH = null;
        this.dyW = null;
        this.eGI = null;
        this.cUW = null;
        this.aRv = null;
        this.aRw = null;
        this.avy = null;
        this.eKY = null;
        this.eGJ = false;
        this.eGK = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eLz = false;
        this.eIm = false;
        this.isBigV = false;
        this.eLB = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aRw != null) {
                    o.this.aRw.bf(view);
                    o.this.aRw.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void pq(int i) {
        this.eLA = com.baidu.tbadk.core.util.am.y(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(pVar.eGS, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.j(pVar.eHA, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eHB, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eHC, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eHD, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.k(pVar.cVi, d.e.cp_bg_line_c);
                pVar.eHc.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(pVar.eLG, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eHA, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eHB, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eHC, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eHD, d.e.cp_cont_f, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eHK.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.eGD, this.eGC);
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
        if (!this.eGJ && this.eGK && pVar != null && pVar.eHc.Jj() && (listView = ((PbActivity) this.eHK.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eGJ = true;
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
            pVar.eHc.setTag(sparseArray);
            pVar.eGS.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eLy) {
                pVar.cVi.setVisibility(0);
            } else {
                pVar.cVi.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eGD) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eHc.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eHc.setLayoutParams(layoutParams);
                pVar.eHc.gZ(null);
                this.eLz = false;
            } else {
                this.eLz = true;
                pVar.eHc.gZ(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eHc.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eHc.setLayoutParams(layoutParams2);
            }
            pVar.eHc.setIsSupportNewFirstFloor(true);
            if (postData.bsz() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eHc.setOnClickListener(this.cUW);
                    pVar.eHc.setTextViewOnClickListener(this.cUW);
                } else {
                    pVar.eHc.setOnClickListener(null);
                    pVar.eHc.setTextViewOnClickListener(null);
                }
                pVar.eGS.setOnClickListener(this.cUW);
            } else {
                pVar.eGS.setOnClickListener(null);
            }
            if (postData.bsz() == 1) {
                if (!this.eHK.aQY()) {
                    if (this.eGF != null && !com.baidu.tbadk.core.util.v.v(this.eGF.aPC())) {
                        pVar.eHE.setVisibility(0);
                        if (this.eGF.aPC().size() <= 4) {
                            subList = this.eGF.aPC();
                        } else {
                            subList = this.eGF.aPC().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eHA, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eHB, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eHC, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eHD, subList);
                            }
                        }
                    } else {
                        pVar.eHE.setVisibility(8);
                    }
                } else {
                    pVar.eHE.setVisibility(8);
                }
                a(pVar.eHc, view, this.eLz);
                pVar.eGT.setVisibility(8);
                pVar.eHf.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.eGF != null && this.eGF.aPi() != null) {
                    pVar.eHf.a(postData.bsG(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eGF.aPi().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.eHf.onChangeSkinType();
                if (this.eHK.aQm().aTF()) {
                    pVar.eHc.setVisibility(8);
                }
                if (this.eGF != null && this.eGF.aPi() != null && this.eGF.aPi().rN() != null) {
                    bs rN = this.eGF.aPi().rN();
                    final String activityUrl = rN.getActivityUrl();
                    String ti = rN.ti();
                    if (!StringUtils.isNull(rN.tj())) {
                        pVar.eLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.k.hz()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.U(o.this.eHK.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(ti)) {
                            pVar.csk.setVisibility(0);
                            pVar.csk.c(ti, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.csk.setVisibility(8);
                }
                if (pVar.eLF != null) {
                    pVar.eLF.setVisibility(8);
                }
            }
            pVar.eHc.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsz()));
            if (postData.bsD() > 0 && postData.bsw() != null && postData.bsw().size() > 0) {
                if (this.eGG == null) {
                    this.eGG = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eGG.setIsFromCDN(this.mIsFromCDN);
                    this.eGG.C(this.eGI);
                    if (this.eGF != null) {
                        this.eGG.z(this.eGF.aPt(), TextUtils.equals(this.eGF.aPi().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eGG.Z(this.eGF.aPi());
                    }
                }
                this.eGG.pD(postData.getId());
            }
            pVar.eHc.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            if (this.eGD) {
                pVar.eHc.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eHc.setDefaultImageId(d.g.icon_click);
            }
            pVar.eHc.setIsFromCDN(this.mIsFromCDN);
            if (this.eGF != null && this.eGF.aPi() != null && this.eGF.aPi().isLinkThread()) {
                a(pVar, this.eGF.aPi().sS());
            }
            TbRichText aDr = postData.aDr();
            if (this.eGJ || !this.eGK) {
                pVar.eHc.a(aDr, false, this.eKY);
            } else {
                pVar.eHc.a(aDr, true, this.eKY);
            }
            a(pVar, postData, aDr);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eGF != null && this.eGF.aPt() != 0) {
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
            if (this.eGF != null && this.eGF.aPi() != null && this.eGF.aPi().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eGF.aPi().getAuthor().getUserId();
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
                    if (postData.bsz() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eGF != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eGF.aPt()));
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
                        if (this.eGF != null && this.eGF.aPi() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eGF.aPi().getId());
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
                        if (this.eGF != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eGF.aPt()));
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
            if (postData.bsz() == 1) {
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
        if (ajVar != null && !com.baidu.tbadk.core.util.am.isEmpty(ajVar.getLinkUrl()) && !pVar.eLI.getIsLoaded() && ajVar.ql() == com.baidu.tbadk.core.data.aj.WQ) {
            if (ajVar.qm()) {
                pVar.eLH.setVisibility(8);
                pVar.eLI.setVisibility(8);
                return;
            }
            pVar.eHc.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds48));
            pVar.eLH.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(pVar.eLH, d.e.cp_bg_line_c);
            pVar.eLI.setVisibility(0);
            pVar.eLI.setFocusable(false);
            pVar.eLI.setBackgroundColor(0);
            pVar.eLI.getSettings().setCacheMode(-1);
            pVar.eLI.setVerticalScrollBarEnabled(false);
            pVar.eLI.setHorizontalScrollBarEnabled(false);
            pVar.eLI.getSettings().setAllowFileAccess(true);
            pVar.eLI.getSettings().setAppCacheEnabled(true);
            pVar.eLI.getSettings().setDomStorageEnabled(true);
            pVar.eLI.getSettings().setDatabaseEnabled(true);
            pVar.eLI.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eLI.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eLI.loadUrl(ajVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aVJ() == null) {
            pVar.eHy.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aVJ(), pVar.eHy, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eHc.setTextViewOnTouchListener(this.eLB);
        pVar.eHc.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ae = (((com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(ae - i, this.eGC);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eGS.setOnTouchListener(this.aRw);
        pVar.eGS.setOnLongClickListener(this.avy);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eHK.getPageContext().getOrignalPage()).eIz;
        pVar.eHc.setOnLongClickListener(this.avy);
        pVar.eHc.setOnTouchListener(this.eLB);
        pVar.eHc.setCommonTextViewOnClickListener(this.cUW);
        pVar.eHc.setOnImageClickListener(this.aRv);
        pVar.eHc.setOnImageTouchListener(this.eLB);
        pVar.eHc.setOnEmotionClickListener(aVar.eVd);
        pVar.eHy.setOnClickListener(this.cUW);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eGF = fVar;
    }

    public void ph(int i) {
        this.eGC = i;
    }

    public void iT(boolean z) {
        this.eGD = z;
    }

    public void iU(boolean z) {
        this.eGE = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void A(View.OnClickListener onClickListener) {
        this.eGI = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cUW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRv = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avy = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eKY = bVar;
    }

    public void pf(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eHK.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
                    o.this.pf(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12041").ad("fid", forumId));
                    if (o.this.eGF != null && o.this.eGF.aPi() != null && o.this.eGF.aPi().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12123").ad("fid", o.this.eGF.getForumId()).ad("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void jk(boolean z) {
        this.eLy = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eLI != null) {
            ((p) this.viewholder).eLI.removeAllViews();
            ((p) this.viewholder).eLI.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eLI.setVisibility(8);
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eLI != null) {
                            ((p) o.this.viewholder).eLI.destroy();
                            ((p) o.this.viewholder).eLI = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eLI != null) {
            ((p) this.viewholder).eLI.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eLI != null) {
            ((p) this.viewholder).eLI.onPause();
        }
    }
}
