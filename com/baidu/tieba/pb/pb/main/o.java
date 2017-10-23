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
    private TbRichTextView.f aSj;
    private com.baidu.tieba.pb.a.c aSk;
    private View.OnLongClickListener auu;
    private ArrayList<IconData> duX;
    private boolean eEJ;
    private boolean eEK;
    private boolean eEL;
    private String eEM;
    private com.baidu.tieba.pb.a.c eEN;
    private TbRichTextView.b eEj;
    protected int ezL;
    protected boolean ezM;
    private boolean ezN;
    protected com.baidu.tieba.pb.data.f ezO;
    private com.baidu.tieba.pb.pb.sub.d ezP;
    private ArrayList<IconData> ezQ;
    private View.OnClickListener ezR;
    private View.OnClickListener ezS;
    private boolean ezT;
    private final boolean ezU;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ezL = 0;
        this.ezM = true;
        this.ezN = true;
        this.eEJ = true;
        this.ezO = null;
        this.mHostId = null;
        this.ezP = null;
        this.ezQ = null;
        this.duX = null;
        this.ezR = null;
        this.ezS = null;
        this.aSj = null;
        this.aSk = null;
        this.auu = null;
        this.eEj = null;
        this.ezT = false;
        this.ezU = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eEK = false;
        this.eEL = false;
        this.isBigV = false;
        this.eEN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.o.1
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
                if (o.this.aSk != null) {
                    o.this.aSk.bb(view);
                    o.this.aSk.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
        });
    }

    public void pi(int i) {
        this.eEM = com.baidu.tbadk.core.util.am.y(i);
    }

    private void a(p pVar) {
        if (pVar != null) {
            if (pVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.k(pVar.eAc, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aj.j(pVar.eAK, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eAL, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eAM, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.j(pVar.eAN, d.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aj.k(pVar.cUK, d.e.cp_bg_line_c);
                pVar.eAm.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_cont_b));
                com.baidu.tbadk.core.util.aj.c(pVar.eES, d.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eAK, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eAL, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eAM, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.c(pVar.eAN, d.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.j(pVar.ceA, d.g.bg_first_floor_forum_name);
                com.baidu.tbadk.core.util.aj.c(pVar.ceA, d.e.cp_cont_j, 1);
            }
            pVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        p pVar = new p(this.eDo.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.new_pb_list_first_floor_item, viewGroup, false), this.ezM, this.ezL);
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
            postData2.sm();
            a(pVar, postData2, view, i);
        }
        if (!this.ezT && this.ezU && pVar != null && pVar.eAm.Jm() && (listView = ((PbActivity) this.eDo.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ezT = true;
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
            pVar.eAm.setTag(sparseArray);
            pVar.eAc.setTag(d.h.tag_from, sparseArray);
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            if (this.eEJ) {
                pVar.cUK.setVisibility(0);
            } else {
                pVar.cUK.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ezM) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.eAm.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pVar.eAm.setLayoutParams(layoutParams);
                pVar.eAm.gW(null);
                this.eEK = false;
            } else {
                this.eEK = true;
                pVar.eAm.gW(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.eAm.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(d.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(d.f.ds34);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                pVar.eAm.setLayoutParams(layoutParams2);
            }
            pVar.eAm.setIsSupportNewFirstFloor(true);
            if (postData.brq() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    pVar.eAm.setOnClickListener(this.ezS);
                    pVar.eAm.setTextViewOnClickListener(this.ezS);
                } else {
                    pVar.eAm.setOnClickListener(null);
                    pVar.eAm.setTextViewOnClickListener(null);
                }
                pVar.eAc.setOnClickListener(this.ezS);
            } else {
                pVar.eAc.setOnClickListener(null);
            }
            if (postData.brq() == 1) {
                if (!this.eDo.aOO()) {
                    if (this.ezO != null && !com.baidu.tbadk.core.util.v.u(this.ezO.aNq())) {
                        pVar.eAO.setVisibility(0);
                        if (this.ezO.aNq().size() <= 4) {
                            subList = this.ezO.aNq();
                        } else {
                            subList = this.ezO.aNq().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, pVar.eAK, subList);
                            } else if (i2 == 1) {
                                a(i2, pVar.eAL, subList);
                            } else if (i2 == 2) {
                                a(i2, pVar.eAM, subList);
                            } else if (i2 == 3) {
                                a(i2, pVar.eAN, subList);
                            }
                        }
                    } else {
                        pVar.eAO.setVisibility(8);
                    }
                    pVar.ceA.setVisibility(8);
                } else {
                    pVar.eAO.setVisibility(8);
                    if (this.ezO.aMU() != null && !StringUtils.isNull(this.ezO.aMU().getName()) && com.baidu.adp.lib.b.d.eV().af("pb_v89_smallflow_open") == 1 && !aPk()) {
                        pVar.ceA.setVisibility(0);
                        pVar.ceA.setText(this.eDo.getResources().getString(d.l.chosen_pb_original_bar, this.ezO.aMU().getName()));
                    } else {
                        pVar.ceA.setVisibility(8);
                    }
                }
                a(pVar.eAm, view, this.eEK);
                pVar.eAd.setVisibility(8);
                pVar.eAp.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                    str2 = postData.getAuthor().getName_show();
                }
                if (this.ezO != null && this.ezO.aMW() != null) {
                    pVar.eAp.a(postData.brx(), str, str2, j, com.baidu.adp.lib.g.b.c(this.ezO.aMW().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                pVar.eAp.onChangeSkinType();
                if (this.eDo.aOc().aRK()) {
                    pVar.eAm.setVisibility(8);
                }
                if (this.ezO != null && this.ezO.aMW() != null && this.ezO.aMW().rA() != null) {
                    bq rA = this.ezO.aMW().rA();
                    final String activityUrl = rA.getActivityUrl();
                    String sV = rA.sV();
                    if (!StringUtils.isNull(rA.sW())) {
                        pVar.eEQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.o.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (!StringUtils.isNull(activityUrl) && com.baidu.adp.lib.util.l.hy()) {
                                    TiebaStatic.log("c10854");
                                    com.baidu.tbadk.browser.a.P(o.this.eDo.getActivity(), activityUrl);
                                }
                            }
                        });
                        if (!StringUtils.isNull(sV)) {
                            pVar.csv.setVisibility(0);
                            pVar.csv.c(sV, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    pVar.csv.setVisibility(8);
                }
                if (pVar.eER != null) {
                    pVar.eER.setVisibility(8);
                }
            }
            pVar.eAm.setVideoImageId(d.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(d.h.tag_clip_board, postData);
            sparseArray2.put(d.h.tag_load_sub_data, postData);
            sparseArray2.put(d.h.tag_load_sub_view, view);
            sparseArray2.put(d.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(d.h.tag_pb_floor_number, Integer.valueOf(postData.brq()));
            if (postData.bru() > 0 && postData.brn() != null && postData.brn().size() > 0) {
                if (this.ezP == null) {
                    this.ezP = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.ezP.setIsFromCDN(this.mIsFromCDN);
                    this.ezP.E(this.ezR);
                    if (this.ezO != null) {
                        this.ezP.x(this.ezO.aNh(), TextUtils.equals(this.ezO.aMW().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.ezP.U(this.ezO.aMW());
                    }
                }
                this.ezP.pl(postData.getId());
            }
            pVar.eAm.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_link_tip_c));
            if (this.ezM) {
                pVar.eAm.setDefaultImageId(d.g.transparent_bg);
            } else {
                pVar.eAm.setDefaultImageId(d.g.icon_click);
            }
            pVar.eAm.setIsFromCDN(this.mIsFromCDN);
            if (this.ezO != null && this.ezO.aMW() != null && this.ezO.aMW().isLinkThread()) {
                a(pVar, this.ezO.aMW().sF());
            }
            TbRichText aBY = postData.aBY();
            if (this.ezT || !this.ezU) {
                pVar.eAm.a(aBY, false, this.eEj);
            } else {
                pVar.eAm.a(aBY, true, this.eEj);
            }
            a(pVar, postData, aBY);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.ezO != null && this.ezO.aNh() != 0) {
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
            if (this.ezO != null && this.ezO.aMW() != null && this.ezO.aMW().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.ezO.aMW().getAuthor().getUserId();
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
                    if (postData.brq() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(d.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.ezO != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.ezO.aNh()));
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
                        if (this.ezO != null && this.ezO.aMW() != null) {
                            sparseArray2.put(d.h.tag_user_mute_thread_id, this.ezO.aMW().getId());
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
                        if (this.ezO != null) {
                            sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.ezO.aNh()));
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
            if (postData.brq() == 1) {
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
        if (ahVar != null && !com.baidu.tbadk.core.util.am.isEmpty(ahVar.getLinkUrl()) && !pVar.eEU.getIsLoaded() && ahVar.pY() == com.baidu.tbadk.core.data.ah.WF) {
            if (ahVar.pZ()) {
                pVar.eET.setVisibility(8);
                pVar.eEU.setVisibility(8);
                return;
            }
            pVar.eAm.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds48));
            pVar.eET.setVisibility(0);
            com.baidu.tbadk.core.util.aj.k(pVar.eET, d.e.cp_bg_line_c);
            pVar.eEU.setVisibility(0);
            pVar.eEU.setFocusable(false);
            pVar.eEU.setBackgroundColor(0);
            pVar.eEU.getSettings().setCacheMode(-1);
            pVar.eEU.setVerticalScrollBarEnabled(false);
            pVar.eEU.setHorizontalScrollBarEnabled(false);
            pVar.eEU.getSettings().setAllowFileAccess(true);
            pVar.eEU.getSettings().setAppCacheEnabled(true);
            pVar.eEU.getSettings().setDomStorageEnabled(true);
            pVar.eEU.getSettings().setDatabaseEnabled(true);
            pVar.eEU.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.pb.pb.main.o.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return true;
                }
            });
            pVar.eEU.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.pb.pb.main.o.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
                }
            });
            pVar.eEU.loadUrl(ahVar.getLinkUrl());
        }
    }

    private void a(p pVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aTN() == null) {
            pVar.eAI.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.g.a(postData.aTN(), pVar.eAI, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(p pVar) {
        pVar.eAm.setTextViewOnTouchListener(this.eEN);
        pVar.eAm.setTextViewCheckSelection(false);
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null) {
            int ad = (((com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            int i = 0;
            if (z) {
                i = getDimensionPixelSize(d.f.ds80);
            }
            int min = Math.min(ad - i, this.ezL);
            tbRichTextView.setMaxImageWidth(min);
            tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
        }
    }

    private void c(p pVar) {
        pVar.eAc.setOnTouchListener(this.aSk);
        pVar.eAc.setOnLongClickListener(this.auu);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.eDo.getPageContext().getOrignalPage()).eBF;
        pVar.eAm.setOnLongClickListener(this.auu);
        pVar.eAm.setOnTouchListener(this.eEN);
        pVar.eAm.setCommonTextViewOnClickListener(this.ezS);
        pVar.eAm.setOnImageClickListener(this.aSj);
        pVar.eAm.setOnImageTouchListener(this.eEN);
        pVar.eAm.setOnEmotionClickListener(aVar.eOR);
        pVar.eAI.setOnClickListener(this.ezS);
        pVar.ceA.setOnClickListener(this.ezS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ezO = fVar;
    }

    public void oZ(int i) {
        this.ezL = i;
    }

    public void iD(boolean z) {
        this.ezM = z;
    }

    public void iE(boolean z) {
        this.ezN = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void C(View.OnClickListener onClickListener) {
        this.ezR = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.ezS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSj = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSk = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auu = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eEj = bVar;
    }

    public void oI(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eDo.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
                    o.this.oI(forumName);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12041").ac("fid", forumId));
                    if (o.this.ezO != null && o.this.ezO.aMW() != null && o.this.ezO.aMW().getThreadType() == 40) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12123").ac("fid", o.this.ezO.getForumId()).ac("obj_param1", forumName));
                    }
                }
            });
        }
    }

    public void iV(boolean z) {
        this.eEJ = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((p) this.viewholder).eEU != null) {
            ((p) this.viewholder).eEU.removeAllViews();
            ((p) this.viewholder).eEU.getSettings().setBuiltInZoomControls(true);
            ((p) this.viewholder).eEU.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.o.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (o.this.viewholder != null && ((p) o.this.viewholder).eEU != null) {
                            ((p) o.this.viewholder).eEU.destroy();
                            ((p) o.this.viewholder).eEU = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((p) this.viewholder).eEU != null) {
            ((p) this.viewholder).eEU.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((p) this.viewholder).eEU != null) {
            ((p) this.viewholder).eEU.onPause();
        }
    }

    private boolean aPk() {
        return (this.ezO == null || this.ezO.aMW() == null || !this.ezO.aMW().sb() || this.ezO.aMW().rF() == null) ? false : true;
    }
}
