package com.baidu.tieba.pb.pb.main;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class dr extends dn<PostData, dx> implements View.OnClickListener {
    private TbRichTextView.e aOb;
    private com.baidu.tieba.pb.a.d aOc;
    private View.OnLongClickListener atb;
    private ArrayList<IconData> cXF;
    private View.OnClickListener cvw;
    protected int ejZ;
    protected boolean eka;
    private boolean ekb;
    protected com.baidu.tieba.pb.data.f ekc;
    private com.baidu.tieba.pb.pb.sub.ba ekd;
    private ArrayList<IconData> eke;
    private View.OnClickListener ekf;
    private boolean ekg;
    private final boolean ekh;
    private boolean elH;
    private boolean eoO;
    private boolean eoP;
    private String eoQ;
    private com.baidu.tieba.pb.a.d eoR;
    private TbRichTextView.b eop;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ejZ = 0;
        this.eka = true;
        this.ekb = true;
        this.eoO = true;
        this.ekc = null;
        this.mHostId = null;
        this.ekd = null;
        this.eke = null;
        this.cXF = null;
        this.ekf = null;
        this.cvw = null;
        this.aOb = null;
        this.aOc = null;
        this.atb = null;
        this.eop = null;
        this.ekg = false;
        this.ekh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.eoP = false;
        this.elH = false;
        this.isBigV = false;
        this.eoR = new com.baidu.tieba.pb.a.d(new ds(this));
    }

    public void ox(int i) {
        this.eoQ = com.baidu.tbadk.core.util.au.x(i);
    }

    private void a(dx dxVar) {
        if (dxVar != null) {
            if (dxVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.k(dxVar.ekp, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.j(dxVar.ekX, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.j(dxVar.ekY, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.j(dxVar.ekZ, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.j(dxVar.ela, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.k(dxVar.cvI, w.e.cp_bg_line_c);
                dxVar.ekz.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
                com.baidu.tbadk.core.util.aq.c(dxVar.eoW, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.c(dxVar.ekX, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dxVar.ekY, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dxVar.ekZ, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dxVar.ela, w.e.cp_cont_f, 1);
            }
            dxVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public dx onCreateViewHolder(ViewGroup viewGroup) {
        dx dxVar = new dx(this.elf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_first_floor_item, viewGroup, false), this.eka, this.ejZ);
        a(dxVar);
        return dxVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, dx dxVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, dxVar);
        a(dxVar);
        c(dxVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.ss();
            a(dxVar, postData2, view, i);
        }
        if (!this.ekg && this.ekh && dxVar != null && dxVar.ekz.Ik() && (listView = ((PbActivity) this.elf.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ekg = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(dx dxVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        List<com.baidu.tbadk.core.data.be> subList;
        if (dxVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            dxVar.ekz.setTag(sparseArray);
            dxVar.ekp.setTag(w.h.tag_from, sparseArray);
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            if (this.eoO) {
                dxVar.cvI.setVisibility(0);
            } else {
                dxVar.cvI.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eka) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dxVar.ekz.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                dxVar.ekz.setLayoutParams(layoutParams);
                dxVar.ekz.gs(null);
                this.eoP = false;
            } else {
                this.eoP = true;
                dxVar.ekz.gs(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dxVar.ekz.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(w.f.ds40);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                dxVar.ekz.setLayoutParams(layoutParams2);
            }
            dxVar.ekz.setIsSupportNewFirstFloor(true);
            if (postData.big() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    dxVar.ekz.setOnClickListener(this.cvw);
                    dxVar.ekz.setTextViewOnClickListener(this.cvw);
                } else {
                    dxVar.ekz.setOnClickListener(null);
                    dxVar.ekz.setTextViewOnClickListener(null);
                }
                dxVar.ekp.setOnClickListener(this.cvw);
            } else {
                dxVar.ekp.setOnClickListener(null);
            }
            if (postData.big() == 1) {
                if (!this.elf.aKl()) {
                    if (this.ekc != null && !com.baidu.tbadk.core.util.x.r(this.ekc.aIW())) {
                        dxVar.elb.setVisibility(0);
                        if (this.ekc.aIW().size() <= 4) {
                            subList = this.ekc.aIW();
                        } else {
                            subList = this.ekc.aIW().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, dxVar.ekX, subList);
                            } else if (i2 == 1) {
                                a(i2, dxVar.ekY, subList);
                            } else if (i2 == 2) {
                                a(i2, dxVar.ekZ, subList);
                            } else if (i2 == 3) {
                                a(i2, dxVar.ela, subList);
                            }
                        }
                    } else {
                        dxVar.elb.setVisibility(8);
                    }
                } else {
                    dxVar.elb.setVisibility(8);
                }
                a(dxVar.ekz, view, this.eoP);
                dxVar.ekq.setVisibility(8);
                dxVar.ekC.setVisibility(0);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                if (this.ekc != null && this.ekc.aIB() != null) {
                    dxVar.ekC.a(postData.bin(), str, j, com.baidu.adp.lib.g.b.c(this.ekc.aIB().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                dxVar.ekC.onChangeSkinType();
                if (this.elf.aJE().aMV()) {
                    dxVar.ekz.setVisibility(8);
                }
                if (this.ekc != null && this.ekc.aIB() != null && this.ekc.aIB().rG() != null) {
                    com.baidu.tbadk.core.data.bv rG = this.ekc.aIB().rG();
                    String activityUrl = rG.getActivityUrl();
                    String sW = rG.sW();
                    if (!StringUtils.isNull(rG.sX())) {
                        dxVar.eoU.setOnClickListener(new dt(this, activityUrl));
                        if (!StringUtils.isNull(sW)) {
                            dxVar.bWj.setVisibility(0);
                            dxVar.bWj.c(sW, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    dxVar.bWj.setVisibility(8);
                }
                if (dxVar.eoV != null) {
                    dxVar.eoV.setVisibility(8);
                }
            }
            dxVar.ekz.setVideoImageId(w.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.big()));
            if (postData.bik() > 0 && postData.bid() != null && postData.bid().size() > 0) {
                if (this.ekd == null) {
                    this.ekd = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.ekd.setIsFromCDN(this.mIsFromCDN);
                    this.ekd.J(this.ekf);
                    if (this.ekc != null) {
                        this.ekd.A(this.ekc.aIM(), TextUtils.equals(this.ekc.aIB().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.ekd.N(this.ekc.aIB());
                    }
                }
                this.ekd.ok(postData.getId());
            }
            dxVar.ekz.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            if (this.eka) {
                dxVar.ekz.setDefaultImageId(w.g.transparent_bg);
            } else {
                dxVar.ekz.setDefaultImageId(w.g.icon_click);
            }
            dxVar.ekz.setIsFromCDN(this.mIsFromCDN);
            if (this.ekc != null && this.ekc.aIB() != null && this.ekc.aIB().isLinkThread()) {
                a(dxVar, this.ekc.aIB().sH());
            }
            TbRichText avd = postData.avd();
            if (this.ekg || !this.ekh) {
                dxVar.ekz.a(avd, false, this.eop);
            } else {
                dxVar.ekz.a(avd, true, this.eop);
            }
            a(dxVar, postData, avd);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.ekc != null && this.ekc.aIM() != 0) {
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
            if (this.ekc != null && this.ekc.aIB() != null && this.ekc.aIB().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.ekc.aIB().getAuthor().getUserId();
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
                    if (postData.big() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.ekc != null) {
                            sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ekc.aIM()));
                        }
                    } else {
                        sparseArray2.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray2.put(w.h.tag_user_mute_visible, true);
                        sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.ekc != null && this.ekc.aIB() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.ekc.aIB().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                        if (this.ekc != null) {
                            sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ekc.aIM()));
                        }
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    b(dxVar);
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
            if (postData.big() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(dxVar);
        }
    }

    private void a(dx dxVar, com.baidu.tbadk.core.data.aj ajVar) {
        if (ajVar != null && !com.baidu.tbadk.core.util.au.isEmpty(ajVar.getLinkUrl()) && !dxVar.eoY.getIsLoaded() && ajVar.qf() == com.baidu.tbadk.core.data.aj.VS) {
            if (ajVar.qg()) {
                dxVar.eoX.setVisibility(8);
                dxVar.eoY.setVisibility(8);
                return;
            }
            dxVar.ekz.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds48));
            dxVar.eoX.setVisibility(0);
            com.baidu.tbadk.core.util.aq.k(dxVar.eoX, w.e.cp_bg_line_c);
            dxVar.eoY.setVisibility(0);
            dxVar.eoY.setBackgroundColor(0);
            dxVar.eoY.getSettings().setCacheMode(-1);
            dxVar.eoY.setVerticalScrollBarEnabled(false);
            dxVar.eoY.setHorizontalScrollBarEnabled(false);
            dxVar.eoY.getSettings().setAllowFileAccess(true);
            dxVar.eoY.getSettings().setAppCacheEnabled(true);
            dxVar.eoY.getSettings().setDomStorageEnabled(true);
            dxVar.eoY.getSettings().setDatabaseEnabled(true);
            dxVar.eoY.setOnLoadUrlListener(new du(this));
            dxVar.eoY.setOnPageFinishedListener(new dv(this));
            dxVar.eoY.loadUrl(ajVar.getLinkUrl());
        }
    }

    private void a(dx dxVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aOB() == null) {
            dxVar.ekV.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.aa.a(postData.aOB(), dxVar.ekV, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(dx dxVar) {
        dxVar.ekz.setTextViewOnTouchListener(this.eoR);
        dxVar.ekz.setTextViewCheckSelection(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [583=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? getDimensionPixelSize(w.f.ds80) : 0), this.ejZ);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void c(dx dxVar) {
        dxVar.ekp.setOnTouchListener(this.aOc);
        dxVar.ekp.setOnLongClickListener(this.atb);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.elf.getPageContext().getOrignalPage()).elV;
        dxVar.ekz.setOnLongClickListener(this.atb);
        dxVar.ekz.setOnTouchListener(this.eoR);
        dxVar.ekz.setCommonTextViewOnClickListener(this.cvw);
        dxVar.ekz.setOnImageClickListener(this.aOb);
        dxVar.ekz.setOnImageTouchListener(this.eoR);
        dxVar.ekz.setOnEmotionClickListener(aVar.ewC);
        dxVar.ekV.setOnClickListener(this.cvw);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ekc = fVar;
    }

    public void op(int i) {
        this.ejZ = i;
    }

    public void hZ(boolean z) {
        this.eka = z;
    }

    public void ia(boolean z) {
        this.ekb = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ekf = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cvw = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOb = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.d dVar) {
        this.aOc = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atb = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eop = bVar;
    }

    public void nM(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.elf.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }

    public void a(int i, TextView textView, List<com.baidu.tbadk.core.data.be> list) {
        if (textView != null) {
            com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) com.baidu.tbadk.core.util.x.c(list, i);
            if (beVar == null) {
                textView.setVisibility(8);
                return;
            }
            String forumName = beVar.getForumName();
            String forumId = beVar.getForumId();
            textView.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new dw(this, forumName, forumId));
        }
    }

    public void ip(boolean z) {
        this.eoO = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((dx) this.viewholder).eoY != null) {
            ((dx) this.viewholder).eoY.removeAllViews();
            ((dx) this.viewholder).eoY.destroy();
            ((dx) this.viewholder).eoY = null;
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((dx) this.viewholder).eoY != null) {
            ((dx) this.viewholder).eoY.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((dx) this.viewholder).eoY != null) {
            ((dx) this.viewholder).eoY.onPause();
        }
    }
}
