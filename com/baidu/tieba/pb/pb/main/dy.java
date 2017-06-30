package com.baidu.tieba.pb.pb.main;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
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
public class dy extends du<PostData, ef> implements View.OnClickListener {
    private TbRichTextView.e aPr;
    private com.baidu.tieba.pb.a.d aPs;
    private View.OnLongClickListener aue;
    private View.OnClickListener cDj;
    private ArrayList<IconData> dfE;
    protected int esX;
    protected boolean esY;
    private boolean esZ;
    protected com.baidu.tieba.pb.data.f eta;
    private com.baidu.tieba.pb.pb.sub.ba etb;
    private ArrayList<IconData> etd;
    private View.OnClickListener ete;
    private boolean etf;
    private final boolean etg;
    private boolean euH;
    private boolean exU;
    private boolean exV;
    private String exW;
    private com.baidu.tieba.pb.a.d exX;
    private TbRichTextView.b exv;
    private boolean isBigV;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.esX = 0;
        this.esY = true;
        this.esZ = true;
        this.exU = true;
        this.eta = null;
        this.mHostId = null;
        this.etb = null;
        this.etd = null;
        this.dfE = null;
        this.ete = null;
        this.cDj = null;
        this.aPr = null;
        this.aPs = null;
        this.aue = null;
        this.exv = null;
        this.etf = false;
        this.etg = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.exV = false;
        this.euH = false;
        this.isBigV = false;
        this.exX = new com.baidu.tieba.pb.a.d(new dz(this));
    }

    public void oO(int i) {
        this.exW = com.baidu.tbadk.core.util.aw.y(i);
    }

    private void a(ef efVar) {
        if (efVar != null) {
            if (efVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.as.k(efVar.eto, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.as.j(efVar.etW, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.as.j(efVar.etX, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.as.j(efVar.etY, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.as.j(efVar.etZ, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.as.k(efVar.cDv, w.e.cp_bg_line_c);
                efVar.ety.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_b));
                com.baidu.tbadk.core.util.as.c(efVar.eyc, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.as.c(efVar.etW, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.as.c(efVar.etX, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.as.c(efVar.etY, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.as.c(efVar.etZ, w.e.cp_cont_f, 1);
            }
            efVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public ef onCreateViewHolder(ViewGroup viewGroup) {
        ef efVar = new ef(this.euf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_first_floor_item, viewGroup, false), this.esY, this.esX);
        a(efVar);
        return efVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, ef efVar) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, efVar);
        a(efVar);
        c(efVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sp();
            a(efVar, postData2, view, i);
        }
        if (!this.etf && this.etg && efVar != null && efVar.ety.II() && (listView = ((PbActivity) this.euf.getPageContext().getOrignalPage()).getListView()) != null) {
            this.etf = true;
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
    private void a(ef efVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        List<com.baidu.tbadk.core.data.bf> subList;
        if (efVar != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            efVar.ety.setTag(sparseArray);
            efVar.eto.setTag(w.h.tag_from, sparseArray);
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            if (this.exU) {
                efVar.cDv.setVisibility(0);
            } else {
                efVar.cDv.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.esY) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) efVar.ety.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                efVar.ety.setLayoutParams(layoutParams);
                efVar.ety.gP(null);
                this.exV = false;
            } else {
                this.exV = true;
                efVar.ety.gP(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) efVar.ety.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(w.f.ds40);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                efVar.ety.setLayoutParams(layoutParams2);
            }
            efVar.ety.setIsSupportNewFirstFloor(true);
            if (postData.bmu() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    efVar.ety.setOnClickListener(this.cDj);
                    efVar.ety.setTextViewOnClickListener(this.cDj);
                } else {
                    efVar.ety.setOnClickListener(null);
                    efVar.ety.setTextViewOnClickListener(null);
                }
                efVar.eto.setOnClickListener(this.cDj);
            } else {
                efVar.eto.setOnClickListener(null);
            }
            if (postData.bmu() == 1) {
                if (!this.euf.aOi()) {
                    if (this.eta != null && !com.baidu.tbadk.core.util.z.t(this.eta.aMQ())) {
                        efVar.eua.setVisibility(0);
                        if (this.eta.aMQ().size() <= 4) {
                            subList = this.eta.aMQ();
                        } else {
                            subList = this.eta.aMQ().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, efVar.etW, subList);
                            } else if (i2 == 1) {
                                a(i2, efVar.etX, subList);
                            } else if (i2 == 2) {
                                a(i2, efVar.etY, subList);
                            } else if (i2 == 3) {
                                a(i2, efVar.etZ, subList);
                            }
                        }
                    } else {
                        efVar.eua.setVisibility(8);
                    }
                } else {
                    efVar.eua.setVisibility(8);
                }
                a(efVar.ety, view, this.exV);
                efVar.etp.setVisibility(8);
                efVar.etB.setVisibility(0);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                if (this.eta != null && this.eta.aMv() != null) {
                    efVar.etB.a(postData.bmB(), str, j, com.baidu.adp.lib.g.b.c(this.eta.aMv().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                efVar.etB.onChangeSkinType();
                if (this.euf.aNy().aQT()) {
                    efVar.ety.setVisibility(8);
                }
                if (this.eta != null && this.eta.aMv() != null && this.eta.aMv().rD() != null) {
                    com.baidu.tbadk.core.data.bw rD = this.eta.aMv().rD();
                    String activityUrl = rD.getActivityUrl();
                    String sU = rD.sU();
                    if (!StringUtils.isNull(rD.sV())) {
                        efVar.eya.setOnClickListener(new ea(this, activityUrl));
                        if (!StringUtils.isNull(sU)) {
                            efVar.cer.setVisibility(0);
                            efVar.cer.c(sU, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    efVar.cer.setVisibility(8);
                }
                if (efVar.eyb != null) {
                    efVar.eyb.setVisibility(8);
                }
            }
            efVar.ety.setVideoImageId(w.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bmu()));
            if (postData.bmy() > 0 && postData.bmr() != null && postData.bmr().size() > 0) {
                if (this.etb == null) {
                    this.etb = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.etb.setIsFromCDN(this.mIsFromCDN);
                    this.etb.K(this.ete);
                    if (this.eta != null) {
                        this.etb.A(this.eta.aMG(), TextUtils.equals(this.eta.aMv().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                        this.etb.O(this.eta.aMv());
                    }
                }
                this.etb.pe(postData.getId());
            }
            efVar.ety.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c));
            if (this.esY) {
                efVar.ety.setDefaultImageId(w.g.transparent_bg);
            } else {
                efVar.ety.setDefaultImageId(w.g.icon_click);
            }
            efVar.ety.setIsFromCDN(this.mIsFromCDN);
            if (this.eta != null && this.eta.aMv() != null && this.eta.aMv().isLinkThread()) {
                a(efVar, this.eta.aMv().sF());
            }
            TbRichText azb = postData.azb();
            if (this.etf || !this.etg) {
                efVar.ety.a(azb, false, this.exv);
            } else {
                efVar.ety.a(azb, true, this.exv);
            }
            a(efVar, postData, azb);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eta != null && this.eta.aMG() != 0) {
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
            if (this.eta != null && this.eta.aMv() != null && this.eta.aMv().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eta.aMv().getAuthor().getUserId();
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
                    if (postData.bmu() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        if (postData.getAuthor() != null) {
                            sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        }
                        if (this.eta != null) {
                            sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eta.aMG()));
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
                        if (this.eta != null && this.eta.aMv() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.eta.aMv().getId());
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
                        if (this.eta != null) {
                            sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eta.aMG()));
                        }
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    b(efVar);
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
            if (postData.bmu() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(efVar);
        }
    }

    private void a(ef efVar, com.baidu.tbadk.core.data.ak akVar) {
        if (akVar != null && !com.baidu.tbadk.core.util.aw.isEmpty(akVar.getLinkUrl()) && !efVar.eye.getIsLoaded() && akVar.qc() == com.baidu.tbadk.core.data.ak.VS) {
            if (akVar.qd()) {
                efVar.eyd.setVisibility(8);
                efVar.eye.setVisibility(8);
                return;
            }
            efVar.ety.setPbFirstFloorLastTextToBottom(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds48));
            efVar.eyd.setVisibility(0);
            com.baidu.tbadk.core.util.as.k(efVar.eyd, w.e.cp_bg_line_c);
            efVar.eye.setVisibility(0);
            efVar.eye.setFocusable(false);
            efVar.eye.setBackgroundColor(0);
            efVar.eye.getSettings().setCacheMode(-1);
            efVar.eye.setVerticalScrollBarEnabled(false);
            efVar.eye.setHorizontalScrollBarEnabled(false);
            efVar.eye.getSettings().setAllowFileAccess(true);
            efVar.eye.getSettings().setAppCacheEnabled(true);
            efVar.eye.getSettings().setDomStorageEnabled(true);
            efVar.eye.getSettings().setDatabaseEnabled(true);
            efVar.eye.setOnLoadUrlListener(new eb(this));
            efVar.eye.setOnPageFinishedListener(new ec(this));
            efVar.eye.loadUrl(akVar.getLinkUrl());
        }
    }

    private void a(ef efVar, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aSA() == null) {
            efVar.etU.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.aa.a(postData.aSA(), efVar.etU, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(ef efVar) {
        efVar.ety.setTextViewOnTouchListener(this.exX);
        efVar.ety.setTextViewCheckSelection(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [587=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? getDimensionPixelSize(w.f.ds80) : 0), this.esX);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void c(ef efVar) {
        efVar.eto.setOnTouchListener(this.aPs);
        efVar.eto.setOnLongClickListener(this.aue);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.euf.getPageContext().getOrignalPage()).euV;
        efVar.ety.setOnLongClickListener(this.aue);
        efVar.ety.setOnTouchListener(this.exX);
        efVar.ety.setCommonTextViewOnClickListener(this.cDj);
        efVar.ety.setOnImageClickListener(this.aPr);
        efVar.ety.setOnImageTouchListener(this.exX);
        efVar.ety.setOnEmotionClickListener(aVar.eFY);
        efVar.etU.setOnClickListener(this.cDj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eta = fVar;
    }

    public void oF(int i) {
        this.esX = i;
    }

    public void iv(boolean z) {
        this.esY = z;
    }

    public void iw(boolean z) {
        this.esZ = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void I(View.OnClickListener onClickListener) {
        this.ete = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cDj = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aPr = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.d dVar) {
        this.aPs = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aue = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.exv = bVar;
    }

    public void oG(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.euf.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }

    public void a(int i, TextView textView, List<com.baidu.tbadk.core.data.bf> list) {
        if (textView != null) {
            com.baidu.tbadk.core.data.bf bfVar = (com.baidu.tbadk.core.data.bf) com.baidu.tbadk.core.util.z.c(list, i);
            if (bfVar == null) {
                textView.setVisibility(8);
                return;
            }
            String forumName = bfVar.getForumName();
            String forumId = bfVar.getForumId();
            textView.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new ed(this, forumName, forumId));
        }
    }

    public void iL(boolean z) {
        this.exU = z;
    }

    public void release() {
        if (this.viewholder != 0 && ((ef) this.viewholder).eye != null) {
            ((ef) this.viewholder).eye.removeAllViews();
            ((ef) this.viewholder).eye.getSettings().setBuiltInZoomControls(true);
            ((ef) this.viewholder).eye.setVisibility(8);
            com.baidu.adp.lib.g.h.fR().postDelayed(new ee(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    public void resume() {
        if (this.viewholder != 0 && ((ef) this.viewholder).eye != null) {
            ((ef) this.viewholder).eye.onResume();
        }
    }

    public void pause() {
        if (this.viewholder != 0 && ((ef) this.viewholder).eye != null) {
            ((ef) this.viewholder).eye.onPause();
        }
    }
}
