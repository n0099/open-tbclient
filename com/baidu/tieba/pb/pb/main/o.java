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
    private TbRichTextView.e aRN;
    private com.baidu.tieba.pb.a.c aRO;
    private View.OnLongClickListener awo;
    private View.OnClickListener cNL;
    private ArrayList<IconData> drx;
    protected int eHn;
    protected boolean eHo;
    private boolean eHp;
    protected com.baidu.tieba.pb.data.f eHq;
    private com.baidu.tieba.pb.pb.sub.d eHr;
    private ArrayList<IconData> eHs;
    private View.OnClickListener eHt;
    private boolean eHu;
    private final boolean eHv;
    private boolean eIW;
    private TbRichTextView.b eLM;
    private boolean eMl;
    private boolean eMm;
    private String eMn;
    private com.baidu.tieba.pb.a.c eMo;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eHn = 0;
        this.eHo = true;
        this.eHp = true;
        this.eMl = true;
        this.eHq = null;
        this.mHostId = null;
        this.eHr = null;
        this.eHs = null;
        this.drx = null;
        this.eHt = null;
        this.cNL = null;
        this.aRN = null;
        this.aRO = null;
        this.awo = null;
        this.eLM = null;
        this.eHu = false;
        this.eHv = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eMm = false;
        this.eIW = false;
        this.isBigV = false;
        this.eMo = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aRO != null) {
                    o.this.aRO.aZ(view);
                    o.this.aRO.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void ph(int i) {
        this.eMn = com.baidu.tbadk.core.util.al.z(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.k(pVar.eHD, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.j(pVar.eIl, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eIm, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eIn, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eIo, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.k(pVar.cNX, d.e.cp_bg_line_c);
                pVar.eHN.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.c(pVar.eMt, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIl, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIm, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIn, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIo, d.e.cp_cont_f, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eIu.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.eHo, this.eHn);
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
        if (!this.eHu && this.eHv && pVar != null && pVar.eHN.Jb() && (listView = ((PbActivity) this.eIu.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eHu = true;
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
            pVar.eHN.setTag(sparseArray);
            pVar.eHD.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eMl) {
                pVar.cNX.setVisibility(0);
            } else {
                pVar.cNX.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHo) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eHN.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eHN.setLayoutParams(layoutParams);
                pVar.eHN.ha(null);
                this.eMm = false;
            } else {
                this.eMm = true;
                pVar.eHN.ha(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eHN.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eHN.setLayoutParams(layoutParams2);
            }
            pVar.eHN.setIsSupportNewFirstFloor(true);
            if (postData.btg() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eHN.setOnClickListener(this.cNL);
                    pVar.eHN.setTextViewOnClickListener(this.cNL);
                } else {
                    pVar.eHN.setOnClickListener(null);
                    pVar.eHN.setTextViewOnClickListener(null);
                }
                pVar.eHD.setOnClickListener(this.cNL);
            } else {
                pVar.eHD.setOnClickListener(null);
            }
            if (postData.btg() == 1) {
                if (!this.eIu.aRE()) {
                    if (this.eHq != null && !com.baidu.tbadk.core.util.u.v(this.eHq.aQl())) {
                        pVar.eIp.setVisibility(0);
                        if (this.eHq.aQl().size() <= 4) {
                            subList = this.eHq.aQl();
                        } else {
                            subList = this.eHq.aQl().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eIl, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eIm, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eIn, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eIo, subList);
                            }
                        }
                    } else {
                        pVar.eIp.setVisibility(8);
                    }
                } else {
                    pVar.eIp.setVisibility(8);
                }
                a(pVar.eHN, view, this.eMm);
                pVar.eHE.setVisibility(8);
                pVar.eHQ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.eHq != null && this.eHq.aPQ() != null) {
                    pVar.eHQ.a(postData.btn(), str, str2, j, com.baidu.adp.lib.g.b.d(this.eHq.aPQ().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                pVar.eHQ.onChangeSkinType();
                if (this.eIu.aQT().aUp()) {
                    pVar.eHN.setVisibility(8);
                }
                if (this.eHq != null && this.eHq.aPQ() != null && this.eHq.aPQ().rR() != null) {
                    bu rR = this.eHq.aPQ().rR();
                    final String activityUrl = rR.getActivityUrl();
                    String tl = rR.tl();
                    if (!StringUtils.isNull(rR.tm())) {
                        pVar.eMr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.k.hI()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.U(o.this.eIu.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tl)) {
                            pVar.clW.setVisibility(0);
                            pVar.clW.c(tl, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.clW.setVisibility(8);
                }
                if (pVar.eMs != null) {
                    pVar.eMs.setVisibility(8);
                }
            }
            pVar.eHN.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.btg()));
            if (postData.btk() > 0 && postData.btd() != null && postData.btd().size() > 0) {
                if (this.eHr == null) {
                    this.eHr = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHr.setIsFromCDN(this.mIsFromCDN);
                    this.eHr.I(this.eHt);
                    if (this.eHq != null) {
                        this.eHr.C(this.eHq.aQb(), TextUtils.equals(this.eHq.aPQ().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eHr.U(this.eHq.aPQ());
                    }
                }
                this.eHr.pK(postData.getId());
            }
            pVar.eHN.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            if (this.eHo) {
                pVar.eHN.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eHN.setDefaultImageId(d.g.icon_click);
            }
            pVar.eHN.setIsFromCDN(this.mIsFromCDN);
            if (this.eHq != null && this.eHq.aPQ() != null && this.eHq.aPQ().isLinkThread()) {
                a(pVar, this.eHq.aPQ().sV());
            }
            TbRichText aBw = postData.aBw();
            if (this.eHu || !this.eHv) {
                pVar.eHN.a(aBw, false, this.eLM);
            } else {
                pVar.eHN.a(aBw, true, this.eLM);
            }
            a(pVar, postData, aBw);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eHq != null && this.eHq.aQb() != 0) {
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
            if (this.eHq != null && this.eHq.aPQ() != null && this.eHq.aPQ().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eHq.aPQ().getAuthor().getUserId();
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
                    if (postData.btg() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eHq != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHq.aQb()));
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
                        if (this.eHq != null && this.eHq.aPQ() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eHq.aPQ().getId());
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
                        if (this.eHq != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHq.aQb()));
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
            if (postData.btg() == 1) {
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
        if (ajVar != null && !com.baidu.tbadk.core.util.al.isEmpty(ajVar.getLinkUrl()) && !pVar.eMv.getIsLoaded() && ajVar.qp() == com.baidu.tbadk.core.data.aj.XG) {
            if (ajVar.qq()) {
                pVar.eMu.setVisibility(8);
                pVar.eMv.setVisibility(8);
                return;
            }
            pVar.eHN.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48));
            pVar.eMu.setVisibility(0);
            com.baidu.tbadk.core.util.ai.k(pVar.eMu, d.e.cp_bg_line_c);
            pVar.eMv.setVisibility(0);
            pVar.eMv.setFocusable(false);
            pVar.eMv.setBackgroundColor(0);
            pVar.eMv.getSettings().setCacheMode(-1);
            pVar.eMv.setVerticalScrollBarEnabled(false);
            pVar.eMv.setHorizontalScrollBarEnabled(false);
            pVar.eMv.getSettings().setAllowFileAccess(true);
            pVar.eMv.getSettings().setAppCacheEnabled(true);
            pVar.eMv.getSettings().setDomStorageEnabled(true);
            pVar.eMv.getSettings().setDatabaseEnabled(true);
            pVar.eMv.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eMv.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eMv.loadUrl(ajVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aWp() == null) {
            pVar.eIj.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aWp(), pVar.eIj, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eHN.setTextViewOnTouchListener(this.eMo);
        pVar.eHN.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ag = (((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(ag - i, this.eHn);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eHD.setOnTouchListener(this.aRO);
        pVar.eHD.setOnLongClickListener(this.awo);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eIu.getPageContext().getOrignalPage()).eJk;
        pVar.eHN.setOnLongClickListener(this.awo);
        pVar.eHN.setOnTouchListener(this.eMo);
        pVar.eHN.setCommonTextViewOnClickListener(this.cNL);
        pVar.eHN.setOnImageClickListener(this.aRN);
        pVar.eHN.setOnImageTouchListener(this.eMo);
        pVar.eHN.setOnEmotionClickListener(aVar.eVG);
        pVar.eIj.setOnClickListener(this.cNL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHq = fVar;
    }

    public void oY(int i) {
        this.eHn = i;
    }

    public void iS(boolean z) {
        this.eHo = z;
    }

    public void iT(boolean z) {
        this.eHp = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eHt = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cNL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRN = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRO = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awo = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eLM = bVar;
    }

    public void pm(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eIu.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
                    o.this.pm(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12041").aa("fid", forumId));
                    if (o.this.eHq != null && o.this.eHq.aPQ() != null && o.this.eHq.aPQ().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12123").aa("fid", o.this.eHq.getForumId()).aa("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void ji(boolean z) {
        this.eMl = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eMv != null) {
            ((p) this.viewholder).eMv.removeAllViews();
            ((p) this.viewholder).eMv.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eMv.setVisibility(8);
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eMv != null) {
                            ((p) o.this.viewholder).eMv.destroy();
                            ((p) o.this.viewholder).eMv = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eMv != null) {
            ((p) this.viewholder).eMv.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eMv != null) {
            ((p) this.viewholder).eMv.onPause();
        }
    }
}
