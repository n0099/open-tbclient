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
public class dl extends dh<PostData, Cdo> implements View.OnClickListener {
    private TbRichTextView.e aOe;
    private boolean aia;
    private View.OnLongClickListener atr;
    private ArrayList<IconData> cSi;
    private View.OnClickListener coZ;
    private boolean eeA;
    protected com.baidu.tieba.pb.data.f eeB;
    private com.baidu.tieba.pb.pb.sub.ba eeC;
    private ArrayList<IconData> eeD;
    private View.OnClickListener eeE;
    private com.baidu.tieba.pb.a.d eeF;
    private boolean eeG;
    private final boolean eeH;
    protected int eey;
    protected boolean eez;
    private boolean egi;
    private TbRichTextView.b eiH;
    private boolean ejf;
    private boolean ejg;
    private String ejh;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dl(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.eey = 0;
        this.eez = true;
        this.eeA = true;
        this.ejf = true;
        this.eeB = null;
        this.mHostId = null;
        this.eeC = null;
        this.eeD = null;
        this.cSi = null;
        this.eeE = null;
        this.coZ = null;
        this.aOe = null;
        this.eeF = null;
        this.atr = null;
        this.eiH = null;
        this.eeG = false;
        this.eeH = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.ejg = false;
        this.egi = false;
        this.aia = false;
    }

    public void oe(int i) {
        this.ejh = com.baidu.tbadk.core.util.au.x(i);
    }

    private void a(Cdo cdo) {
        if (cdo != null) {
            if (cdo.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.k(cdo.eeP, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.j(cdo.efx, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.j(cdo.efy, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.j(cdo.efz, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.j(cdo.efA, w.g.belong_ba_bg);
                com.baidu.tbadk.core.util.aq.k(cdo.cpl, w.e.cp_bg_line_c);
                cdo.eeZ.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
                com.baidu.tbadk.core.util.aq.c(cdo.ejm, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.c(cdo.efx, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(cdo.efy, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(cdo.efz, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(cdo.efA, w.e.cp_cont_f, 1);
            }
            cdo.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public Cdo onCreateViewHolder(ViewGroup viewGroup) {
        Cdo cdo = new Cdo(this.efF.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.new_pb_list_first_floor_item, viewGroup, false), this.eez, this.eey);
        a(cdo);
        return cdo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, Cdo cdo) {
        BdListView listView;
        super.onFillViewHolder(i, view, viewGroup, postData, cdo);
        a(cdo);
        c(cdo);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sw();
            a(cdo, postData2, view, i);
        }
        if (!this.eeG && this.eeH && cdo != null && cdo.eeZ.Ip() && (listView = ((PbActivity) this.efF.getPageContext().getOrignalPage()).getListView()) != null) {
            this.eeG = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Cdo cdo, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        List<com.baidu.tbadk.core.data.bd> subList;
        if (cdo != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            cdo.eeZ.setTag(sparseArray);
            cdo.eeP.setTag(w.h.tag_from, sparseArray);
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            if (this.ejf) {
                cdo.cpl.setVisibility(0);
            } else {
                cdo.cpl.setVisibility(8);
            }
            if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eez) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cdo.eeZ.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cdo.eeZ.setLayoutParams(layoutParams);
                cdo.eeZ.gt(null);
                this.ejg = false;
            } else {
                this.ejg = true;
                cdo.eeZ.gt(postData.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cdo.eeZ.getLayoutParams();
                layoutParams2.topMargin = getDimensionPixelSize(w.f.ds16);
                int dimensionPixelSize = getDimensionPixelSize(w.f.ds40);
                layoutParams2.bottomMargin = dimensionPixelSize;
                layoutParams2.leftMargin = dimensionPixelSize;
                layoutParams2.rightMargin = dimensionPixelSize;
                cdo.eeZ.setLayoutParams(layoutParams2);
            }
            cdo.eeZ.setIsSupportNewFirstFloor(true);
            if (postData.bgM() != 1) {
                if (TextUtils.isEmpty(postData.getBimg_url())) {
                    cdo.eeZ.setOnClickListener(this.coZ);
                    cdo.eeZ.setTextViewOnClickListener(this.coZ);
                } else {
                    cdo.eeZ.setOnClickListener(null);
                    cdo.eeZ.setTextViewOnClickListener(null);
                }
                cdo.eeP.setOnClickListener(this.coZ);
            } else {
                cdo.eeP.setOnClickListener(null);
            }
            if (postData.bgM() == 1) {
                if (!this.efF.aJt()) {
                    if (!com.baidu.tbadk.core.util.x.r(this.eeB.aIb())) {
                        cdo.efB.setVisibility(0);
                        if (this.eeB.aIb().size() <= 4) {
                            subList = this.eeB.aIb();
                        } else {
                            subList = this.eeB.aIb().subList(0, 4);
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            if (i2 == 0) {
                                a(i2, cdo.efx, subList);
                            } else if (i2 == 1) {
                                a(i2, cdo.efy, subList);
                            } else if (i2 == 2) {
                                a(i2, cdo.efz, subList);
                            } else if (i2 == 3) {
                                a(i2, cdo.efA, subList);
                            }
                        }
                    } else {
                        cdo.efB.setVisibility(8);
                    }
                } else {
                    cdo.efB.setVisibility(8);
                }
                a(cdo.eeZ, view, this.ejg);
                cdo.eeQ.setVisibility(8);
                cdo.efc.setVisibility(0);
                String str = null;
                long j = 0;
                if (postData.getAuthor() != null) {
                    j = postData.getAuthor().getUserIdLong();
                    str = postData.getAuthor().getUserName();
                }
                if (this.eeB != null && this.eeB.aHG() != null) {
                    cdo.efc.a(postData.bgT(), str, j, com.baidu.adp.lib.g.b.c(this.eeB.aHG().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                }
                cdo.efc.onChangeSkinType();
                if (this.efF.aIM().aMb()) {
                    cdo.eeZ.setVisibility(8);
                }
                if (this.eeB.aHG() != null && this.eeB.aHG().rK() != null) {
                    com.baidu.tbadk.core.data.bu rK = this.eeB.aHG().rK();
                    String activityUrl = rK.getActivityUrl();
                    String sX = rK.sX();
                    if (!StringUtils.isNull(rK.sY())) {
                        cdo.ejk.setOnClickListener(new dm(this, activityUrl));
                        if (!StringUtils.isNull(sX)) {
                            cdo.bQs.setVisibility(0);
                            cdo.bQs.c(sX, 10, true);
                        }
                    } else {
                        return;
                    }
                } else {
                    cdo.bQs.setVisibility(8);
                }
                if (cdo.ejl != null) {
                    cdo.ejl.setVisibility(8);
                }
            }
            cdo.eeZ.setVideoImageId(w.g.pic_video);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(w.h.tag_clip_board, postData);
            sparseArray2.put(w.h.tag_load_sub_data, postData);
            sparseArray2.put(w.h.tag_load_sub_view, view);
            sparseArray2.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray2.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bgM()));
            if (postData.bgQ() > 0 && postData.bgJ() != null && postData.bgJ().size() > 0) {
                if (this.eeC == null) {
                    this.eeC = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.eeC.setIsFromCDN(this.mIsFromCDN);
                    this.eeC.J(this.eeE);
                    this.eeC.A(this.eeB.aHR(), TextUtils.equals(this.eeB.aHG().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.eeC.m(this.eeB.aHG());
                }
                this.eeC.nW(postData.getId());
            }
            cdo.eeZ.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            if (this.eez) {
                cdo.eeZ.setDefaultImageId(w.g.transparent_bg);
            } else {
                cdo.eeZ.setDefaultImageId(w.g.icon_click);
            }
            cdo.eeZ.setIsFromCDN(this.mIsFromCDN);
            TbRichText aui = postData.aui();
            if (this.eeG || !this.eeH) {
                cdo.eeZ.a(aui, false, this.eiH);
            } else {
                cdo.eeZ.a(aui, true, this.eiH);
            }
            a(cdo, postData, aui);
            boolean z7 = !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl());
            boolean z8 = false;
            boolean z9 = false;
            if (this.eeB != null && this.eeB.aHR() != 0) {
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
            if (this.eeB != null && this.eeB.aHG() != null && this.eeB.aHG().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eeB.aHG().getAuthor().getUserId();
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
                    if (postData.bgM() == 1) {
                        i3 = 0;
                    }
                    sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z8) {
                        sparseArray2.put(w.h.tag_should_manage_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eeB.aHR()));
                        sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
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
                        if (this.eeB.aHG() != null) {
                            sparseArray2.put(w.h.tag_user_mute_thread_id, this.eeB.aHG().getId());
                        }
                        sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray2.put(w.h.tag_should_delete_visible, true);
                        sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eeB.aHR()));
                        sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray2.put(w.h.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(w.h.tag_should_delete_visible, false);
                    }
                    b(cdo);
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
            if (postData.bgM() == 1) {
            }
            sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z8) {
            }
            if (!z) {
            }
            if (!z6) {
            }
            b(cdo);
        }
    }

    private void a(Cdo cdo, PostData postData, TbRichText tbRichText) {
        if (postData == null || postData.aNs() == null) {
            cdo.efv.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.k.a(postData.aNs(), cdo.efv, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.getBimg_url()));
        }
    }

    private void b(Cdo cdo) {
        cdo.eeZ.setTextViewOnTouchListener(this.eeF);
        cdo.eeZ.setTextViewCheckSelection(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [492=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? getDimensionPixelSize(w.f.ds80) : 0), this.eey);
        tbRichTextView.setMaxImageWidth(min);
        tbRichTextView.setMaxImageHeight((int) (min * 1.618f));
    }

    private void c(Cdo cdo) {
        cdo.eeP.setOnTouchListener(this.eeF);
        cdo.eeP.setOnLongClickListener(this.atr);
        com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.efF.getPageContext().getOrignalPage()).egu;
        cdo.eeZ.setOnLongClickListener(this.atr);
        cdo.eeZ.setOnTouchListener(this.eeF);
        cdo.eeZ.setCommonTextViewOnClickListener(this.coZ);
        cdo.eeZ.setOnImageClickListener(this.aOe);
        cdo.eeZ.setOnEmotionClickListener(aVar.epD);
        cdo.efv.setOnClickListener(this.coZ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eeB = fVar;
    }

    public void nW(int i) {
        this.eey = i;
    }

    public void hL(boolean z) {
        this.eez = z;
    }

    public void hM(boolean z) {
        this.eeA = z;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.eeE = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.coZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOe = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.eeF = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atr = onLongClickListener;
    }

    public void a(TbRichTextView.b bVar) {
        this.eiH = bVar;
    }

    public void nA(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.efF.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
    }

    public void a(int i, TextView textView, List<com.baidu.tbadk.core.data.bd> list) {
        if (textView != null) {
            com.baidu.tbadk.core.data.bd bdVar = (com.baidu.tbadk.core.data.bd) com.baidu.tbadk.core.util.x.c(list, i);
            if (bdVar == null) {
                textView.setVisibility(8);
                return;
            }
            String forumName = bdVar.getForumName();
            String forumId = bdVar.getForumId();
            textView.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(forumName, 7, true)));
            textView.setVisibility(0);
            textView.setOnClickListener(new dn(this, forumName, forumId));
        }
    }

    public void ia(boolean z) {
        this.ejf = z;
    }
}
