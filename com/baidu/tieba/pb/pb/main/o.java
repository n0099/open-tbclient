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
    private TbRichTextView.e aRO;
    private com.baidu.tieba.pb.a.c aRP;
    private View.OnLongClickListener awp;
    private View.OnClickListener cNL;
    private ArrayList<IconData> drx;
    protected int eHp;
    protected boolean eHq;
    private boolean eHr;
    protected com.baidu.tieba.pb.data.f eHs;
    private com.baidu.tieba.pb.pb.sub.d eHt;
    private ArrayList<IconData> eHu;
    private View.OnClickListener eHv;
    private boolean eHw;
    private final boolean eHx;
    private boolean eIY;
    private TbRichTextView.b eLO;
    private boolean eMn;
    private boolean eMo;
    private String eMp;
    private com.baidu.tieba.pb.a.c eMq;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eHp = 0;
        this.eHq = true;
        this.eHr = true;
        this.eMn = true;
        this.eHs = null;
        this.mHostId = null;
        this.eHt = null;
        this.eHu = null;
        this.drx = null;
        this.eHv = null;
        this.cNL = null;
        this.aRO = null;
        this.aRP = null;
        this.awp = null;
        this.eLO = null;
        this.eHw = false;
        this.eHx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eMo = false;
        this.eIY = false;
        this.isBigV = false;
        this.eMq = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aRP != null) {
                    o.this.aRP.aY(view);
                    o.this.aRP.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void ph(int i) {
        this.eMp = com.baidu.tbadk.core.util.al.z(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.ai.k(pVar.eHF, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.j(pVar.eIn, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eIo, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eIp, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.j(pVar.eIq, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.ai.k(pVar.cNX, d.e.cp_bg_line_c);
                pVar.eHP.setTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.ai.c(pVar.eMv, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIn, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIo, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIp, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ai.c(pVar.eIq, d.e.cp_cont_f, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eIw.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.eHq, this.eHp);
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
            postData2.sE();
            a(pVar, postData2, view, i);
        }
        if (!this.eHw && this.eHx && pVar != null && pVar.eHP.Jb() && (listView = ((PbActivity) this.eIw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eHw = true;
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
            pVar.eHP.setTag(sparseArray);
            pVar.eHF.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eMn) {
                pVar.cNX.setVisibility(0);
            } else {
                pVar.cNX.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eHq) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eHP.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eHP.setLayoutParams(layoutParams);
                pVar.eHP.hd(null);
                this.eMo = false;
            } else {
                this.eMo = true;
                pVar.eHP.hd(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eHP.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eHP.setLayoutParams(layoutParams2);
            }
            pVar.eHP.setIsSupportNewFirstFloor(true);
            if (postData.bsZ() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eHP.setOnClickListener(this.cNL);
                    pVar.eHP.setTextViewOnClickListener(this.cNL);
                } else {
                    pVar.eHP.setOnClickListener(null);
                    pVar.eHP.setTextViewOnClickListener(null);
                }
                pVar.eHF.setOnClickListener(this.cNL);
            } else {
                pVar.eHF.setOnClickListener(null);
            }
            if (postData.bsZ() == 1) {
                if (!this.eIw.aRz()) {
                    if (this.eHs != null && !com.baidu.tbadk.core.util.u.v(this.eHs.aQg())) {
                        pVar.eIr.setVisibility(0);
                        if (this.eHs.aQg().size() <= 4) {
                            subList = this.eHs.aQg();
                        } else {
                            subList = this.eHs.aQg().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eIn, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eIo, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eIp, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eIq, subList);
                            }
                        }
                    } else {
                        pVar.eIr.setVisibility(8);
                    }
                } else {
                    pVar.eIr.setVisibility(8);
                }
                a(pVar.eHP, view, this.eMo);
                pVar.eHG.setVisibility(8);
                pVar.eHS.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.eHs != null && this.eHs.aPL() != null) {
                    pVar.eHS.a(postData.btg(), str, str2, j, com.baidu.adp.lib.g.b.d(this.eHs.aPL().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                }
                pVar.eHS.onChangeSkinType();
                if (this.eIw.aQO().aUk()) {
                    pVar.eHP.setVisibility(8);
                }
                if (this.eHs != null && this.eHs.aPL() != null && this.eHs.aPL().rS() != null) {
                    bu rS = this.eHs.aPL().rS();
                    final String activityUrl = rS.getActivityUrl();
                    String tm = rS.tm();
                    if (!StringUtils.isNull(rS.tn())) {
                        pVar.eMt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.k.hI()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.U(o.this.eIw.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(tm)) {
                            pVar.clX.setVisibility(0);
                            pVar.clX.c(tm, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.clX.setVisibility(8);
                }
                if (pVar.eMu != null) {
                    pVar.eMu.setVisibility(8);
                }
            }
            pVar.eHP.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.bsZ()));
            if (postData.btd() > 0 && postData.bsW() != null && postData.bsW().size() > 0) {
                if (this.eHt == null) {
                    this.eHt = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.eHt.setIsFromCDN(this.mIsFromCDN);
                    this.eHt.E(this.eHv);
                    if (this.eHs != null) {
                        this.eHt.C(this.eHs.aPW(), TextUtils.equals(this.eHs.aPL().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.eHt.U(this.eHs.aPL());
                    }
                }
                this.eHt.pP(postData.getId());
            }
            pVar.eHP.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            if (this.eHq) {
                pVar.eHP.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eHP.setDefaultImageId(d.g.icon_click);
            }
            pVar.eHP.setIsFromCDN(this.mIsFromCDN);
            if (this.eHs != null && this.eHs.aPL() != null && this.eHs.aPL().isLinkThread()) {
                a(pVar, this.eHs.aPL().sW());
            }
            TbRichText aBr = postData.aBr();
            if (this.eHw || !this.eHx) {
                pVar.eHP.a(aBr, false, this.eLO);
            } else {
                pVar.eHP.a(aBr, true, this.eLO);
            }
            a(pVar, postData, aBr);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eHs != null && this.eHs.aPW() != 0) {
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
            if (this.eHs != null && this.eHs.aPL() != null && this.eHs.aPL().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eHs.aPL().getAuthor().getUserId();
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
                    if (postData.bsZ() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eHs != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHs.aPW()));
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
                        if (this.eHs != null && this.eHs.aPL() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.eHs.aPL().getId());
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
                        if (this.eHs != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eHs.aPW()));
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
            if (postData.bsZ() == 1) {
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
        if (ajVar != null && !com.baidu.tbadk.core.util.al.isEmpty(ajVar.getLinkUrl()) && !pVar.eMx.getIsLoaded() && ajVar.qq() == com.baidu.tbadk.core.data.aj.XH) {
            if (ajVar.qr()) {
                pVar.eMw.setVisibility(8);
                pVar.eMx.setVisibility(8);
                return;
            }
            pVar.eHP.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48));
            pVar.eMw.setVisibility(0);
            com.baidu.tbadk.core.util.ai.k(pVar.eMw, d.e.cp_bg_line_c);
            pVar.eMx.setVisibility(0);
            pVar.eMx.setFocusable(false);
            pVar.eMx.setBackgroundColor(0);
            pVar.eMx.getSettings().setCacheMode(-1);
            pVar.eMx.setVerticalScrollBarEnabled(false);
            pVar.eMx.setHorizontalScrollBarEnabled(false);
            pVar.eMx.getSettings().setAllowFileAccess(true);
            pVar.eMx.getSettings().setAppCacheEnabled(true);
            pVar.eMx.getSettings().setDomStorageEnabled(true);
            pVar.eMx.getSettings().setDatabaseEnabled(true);
            pVar.eMx.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eMx.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eMx.loadUrl(ajVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aWk() == null) {
            pVar.eIl.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(postData.aWk(), pVar.eIl, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eHP.setTextViewOnTouchListener(this.eMq);
        pVar.eHP.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ag = (((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(ag - i, this.eHp);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eHF.setOnTouchListener(this.aRP);
        pVar.eHF.setOnLongClickListener(this.awp);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eIw.getPageContext().getOrignalPage()).eJm;
        pVar.eHP.setOnLongClickListener(this.awp);
        pVar.eHP.setOnTouchListener(this.eMq);
        pVar.eHP.setCommonTextViewOnClickListener(this.cNL);
        pVar.eHP.setOnImageClickListener(this.aRO);
        pVar.eHP.setOnImageTouchListener(this.eMq);
        pVar.eHP.setOnEmotionClickListener(aVar.eVI);
        pVar.eIl.setOnClickListener(this.cNL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eHs = fVar;
    }

    public void oY(int i) {
        this.eHp = i;
    }

    public void iS(boolean z) {
        this.eHq = z;
    }

    public void iT(boolean z) {
        this.eHr = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void C(View.OnClickListener onClickListener) {
        this.eHv = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cNL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRO = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awp = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eLO = bVar;
    }

    public void pr(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eIw.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
                    o.this.pr(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12041").aa("fid", forumId));
                    if (o.this.eHs != null && o.this.eHs.aPL() != null && o.this.eHs.aPL().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12123").aa("fid", o.this.eHs.getForumId()).aa("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void ji(boolean z) {
        this.eMn = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eMx != null) {
            ((p) this.viewholder).eMx.removeAllViews();
            ((p) this.viewholder).eMx.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eMx.setVisibility(8);
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eMx != null) {
                            ((p) o.this.viewholder).eMx.destroy();
                            ((p) o.this.viewholder).eMx = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eMx != null) {
            ((p) this.viewholder).eMx.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eMx != null) {
            ((p) this.viewholder).eMx.onPause();
        }
    }
}
