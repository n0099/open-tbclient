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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bq;
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
public class o extends k<PostData, p> implements View.OnClickListener {
    private TbRichTextView.f aSw;
    private com.baidu.tieba.pb.a.c aSx;
    private View.OnLongClickListener auG;
    private ArrayList<IconData> dvl;
    protected boolean eAa;
    private boolean eAb;
    protected com.baidu.tieba.pb.data.f eAc;
    private com.baidu.tieba.pb.pb.sub.d eAd;
    private ArrayList<IconData> eAe;
    private View.OnClickListener eAf;
    private View.OnClickListener eAg;
    private boolean eAh;
    private final boolean eAi;
    private boolean eEX;
    private boolean eEY;
    private boolean eEZ;
    private TbRichTextView.b eEx;
    private String eFa;
    private com.baidu.tieba.pb.a.c eFb;
    protected int ezZ;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ezZ = 0;
        this.eAa = true;
        this.eAb = true;
        this.eEX = true;
        this.eAc = null;
        this.mHostId = null;
        this.eAd = null;
        this.eAe = null;
        this.dvl = null;
        this.eAf = null;
        this.eAg = null;
        this.aSw = null;
        this.aSx = null;
        this.auG = null;
        this.eEx = null;
        this.eAh = false;
        this.eAi = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eEY = false;
        this.eEZ = false;
        this.isBigV = false;
        this.eFb = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aSx != null) {
                    o.this.aSx.bb(view);
                    o.this.aSx.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void pj(int i) {
        this.eFa = com.baidu.tbadk.core.util.am.x(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(pVar.eAq, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.j(pVar.eAY, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eAZ, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eBa, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eBb, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.k(pVar.cUW, d.e.cp_bg_line_c);
                pVar.eAA.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(pVar.eFg, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eAY, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eAZ, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eBa, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eBb, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.j(pVar.ceM, d.g.bg_first_floor_forum_name);
                com.baidu.tbadk.core.util.aj.c(pVar.ceM, d.e.cp_cont_j, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eDC.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.eAa, this.ezZ);
        a(pVar);
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
            postData2.st();
            a(pVar, postData2, view, i);
        }
        if (!this.eAh && this.eAi && pVar != null && pVar.eAA.Js() && (listView = ((PbActivity) this.eDC.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eAh = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x05c8  */
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
        List<bc> subList;
        if (pVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pVar.eAA.setTag(sparseArray);
            pVar.eAq.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eEX) {
                pVar.cUW.setVisibility(0);
            } else {
                pVar.cUW.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eAa) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eAA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eAA.setLayoutParams(layoutParams);
                pVar.eAA.gX(null);
                this.eEY = false;
            } else {
                this.eEY = true;
                pVar.eAA.gX(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eAA.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eAA.setLayoutParams(layoutParams2);
            }
            pVar.eAA.setIsSupportNewFirstFloor(true);
            if (postData.brx() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eAA.setOnClickListener(this.eAg);
                    pVar.eAA.setTextViewOnClickListener(this.eAg);
                } else {
                    pVar.eAA.setOnClickListener(null);
                    pVar.eAA.setTextViewOnClickListener(null);
                }
                pVar.eAq.setOnClickListener(this.eAg);
            } else {
                pVar.eAq.setOnClickListener(null);
            }
            if (postData.brx() == 1) {
                if (!this.eDC.aOT()) {
                    if (this.eAc != null && !com.baidu.tbadk.core.util.v.u(this.eAc.aNv())) {
                        pVar.eBc.setVisibility(0);
                        if (this.eAc.aNv().size() <= 4) {
                            subList = this.eAc.aNv();
                        } else {
                            subList = this.eAc.aNv().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eAY, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eAZ, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eBa, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eBb, subList);
                            }
                        }
                    } else {
                        pVar.eBc.setVisibility(8);
                    }
                    pVar.ceM.setVisibility(8);
                } else {
                    pVar.eBc.setVisibility(8);
                    if (this.eAc.aMZ() != null && !StringUtils.isNull(this.eAc.aMZ().getName()) && com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !aPp()) {
                        pVar.ceM.setVisibility(0);
                        pVar.ceM.setText(this.eDC.getResources().getString(d.l.chosen_pb_original_bar, this.eAc.aMZ().getName()));
                    } else {
                        pVar.ceM.setVisibility(8);
                    }
                }
                a(pVar.eAA, view, this.eEY);
                pVar.eAr.setVisibility(8);
                pVar.eAD.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.eAc != null && this.eAc.aNb() != null) {
                    pVar.eAD.a(postData.brE(), str, str2, j, com.baidu.adp.lib.g.b.c(this.eAc.aNb().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.eAD.onChangeSkinType();
                if (this.eDC.aOh().aRP()) {
                    pVar.eAA.setVisibility(8);
                }
                if (this.eAc != null && this.eAc.aNb() != null && this.eAc.aNb().rH() != null) {
                    bq rH = this.eAc.aNb().rH();
                    final String activityUrl = rH.getActivityUrl();
                    String tc = rH.tc();
                    if (!StringUtils.isNull(rH.td())) {
                        pVar.eFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.U(o.this.eDC.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tc)) {
                            pVar.csH.setVisibility(0);
                            pVar.csH.c(tc, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.csH.setVisibility(8);
                }
                if (pVar.eFf != null) {
                    pVar.eFf.setVisibility(8);
                }
            }
            pVar.eAA.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.brx()));
            if (postData.brB() > 0 && postData.bru() != null && postData.bru().size() > 0) {
                if (this.eAd == null) {
                    this.eAd = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eAd.setIsFromCDN(this.mIsFromCDN);
                    this.eAd.E(this.eAf);
                    if (this.eAc != null) {
                        this.eAd.x(this.eAc.aNm(), TextUtils.equals(this.eAc.aNb().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eAd.U(this.eAc.aNb());
                    }
                }
                this.eAd.pm(postData.getId());
            }
            pVar.eAA.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            if (this.eAa) {
                pVar.eAA.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eAA.setDefaultImageId(d.g.icon_click);
            }
            pVar.eAA.setIsFromCDN(this.mIsFromCDN);
            if (this.eAc != null && this.eAc.aNb() != null && this.eAc.aNb().isLinkThread()) {
                a(pVar, this.eAc.aNb().sM());
            }
            TbRichText aCd = postData.aCd();
            if (this.eAh || !this.eAi) {
                pVar.eAA.a(aCd, false, this.eEx);
            } else {
                pVar.eAA.a(aCd, true, this.eEx);
            }
            a(pVar, postData, aCd);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eAc != null && this.eAc.aNm() != 0) {
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
            if (this.eAc != null && this.eAc.aNb() != null && this.eAc.aNb().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eAc.aNb().getAuthor().getUserId();
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
                    if (postData.brx() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eAc != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eAc.aNm()));
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
                        if (this.eAc != null && this.eAc.aNb() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eAc.aNb().getId());
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
                        if (this.eAc != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eAc.aNm()));
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
            if (postData.brx() == 1) {
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

    private void a(p pVar, com.baidu.tbadk.core.data.ah ahVar) {
        if (ahVar != null && !com.baidu.tbadk.core.util.am.isEmpty(ahVar.getLinkUrl()) && !pVar.eFi.getIsLoaded() && ahVar.qf() == com.baidu.tbadk.core.data.ah.WR) {
            if (ahVar.qg()) {
                pVar.eFh.setVisibility(8);
                pVar.eFi.setVisibility(8);
                return;
            }
            pVar.eAA.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds48));
            pVar.eFh.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(pVar.eFh, d.e.cp_bg_line_c);
            pVar.eFi.setVisibility(0);
            pVar.eFi.setFocusable(false);
            pVar.eFi.setBackgroundColor(0);
            pVar.eFi.getSettings().setCacheMode(-1);
            pVar.eFi.setVerticalScrollBarEnabled(false);
            pVar.eFi.setHorizontalScrollBarEnabled(false);
            pVar.eFi.getSettings().setAllowFileAccess(true);
            pVar.eFi.getSettings().setAppCacheEnabled(true);
            pVar.eFi.getSettings().setDomStorageEnabled(true);
            pVar.eFi.getSettings().setDatabaseEnabled(true);
            pVar.eFi.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eFi.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eFi.loadUrl(ahVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aTS() == null) {
            pVar.eAW.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aTS(), pVar.eAW, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eAA.setTextViewOnTouchListener(this.eFb);
        pVar.eAA.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ad = (((com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(ad - i, this.ezZ);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eAq.setOnTouchListener(this.aSx);
        pVar.eAq.setOnLongClickListener(this.auG);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eDC.getPageContext().getOrignalPage()).eBT;
        pVar.eAA.setOnLongClickListener(this.auG);
        pVar.eAA.setOnTouchListener(this.eFb);
        pVar.eAA.setCommonTextViewOnClickListener(this.eAg);
        pVar.eAA.setOnImageClickListener(this.aSw);
        pVar.eAA.setOnImageTouchListener(this.eFb);
        pVar.eAA.setOnEmotionClickListener(aVar.ePf);
        pVar.eAW.setOnClickListener(this.eAg);
        pVar.ceM.setOnClickListener(this.eAg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eAc = fVar;
    }

    public void pa(int i) {
        this.ezZ = i;
    }

    public void iE(boolean z) {
        this.eAa = z;
    }

    public void iF(boolean z) {
        this.eAb = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void C(View.OnClickListener onClickListener) {
        this.eAf = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eAg = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSw = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auG = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eEx = bVar;
    }

    public void oJ(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eDC.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
            textView.setText(this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    o.this.oJ(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12041").ad("fid", forumId));
                    if (o.this.eAc != null && o.this.eAc.aNb() != null && o.this.eAc.aNb().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12123").ad("fid", o.this.eAc.getForumId()).ad("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void iW(boolean z) {
        this.eEX = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eFi != null) {
            ((p) this.viewholder).eFi.removeAllViews();
            ((p) this.viewholder).eFi.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eFi.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eFi != null) {
                            ((p) o.this.viewholder).eFi.destroy();
                            ((p) o.this.viewholder).eFi = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eFi != null) {
            ((p) this.viewholder).eFi.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eFi != null) {
            ((p) this.viewholder).eFi.onPause();
        }
    }

    private boolean aPp() {
        return (this.eAc == null || this.eAc.aNb() == null || !this.eAc.aNb().si() || this.eAc.aNb().rM() == null) ? false : true;
    }
}
