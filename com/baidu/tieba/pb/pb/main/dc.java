package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dc extends dh<PostData, dg> implements View.OnClickListener {
    private TbRichTextView.e aOe;
    private View.OnLongClickListener atr;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSJ;
    private com.baidu.adp.lib.e.b<TbImageView> bSK;
    private View.OnClickListener coZ;
    protected com.baidu.tieba.pb.data.f eeB;
    private com.baidu.tieba.pb.pb.sub.ba eeC;
    private View.OnClickListener eeE;
    private com.baidu.tieba.pb.a.d eeF;
    private boolean eez;
    private TbRichTextView.b eiH;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: protected */
    public dc(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eiH = null;
        this.eez = true;
        this.mHostId = null;
        this.eeB = null;
        this.eeE = null;
        this.coZ = null;
        this.aOe = null;
        this.eeF = null;
        this.atr = null;
        this.eeC = null;
        this.bSJ = new com.baidu.adp.lib.e.b<>(new dd(this), 6, 0);
        this.bSK = new com.baidu.adp.lib.e.b<>(new de(this), 12, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public dg onCreateViewHolder(ViewGroup viewGroup) {
        dg dgVar = new dg(this.efF.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_reply_floor_item_layout, viewGroup, false));
        dgVar.eiR.setConstrainLayoutPool(this.bSJ);
        dgVar.eiR.setImageViewPool(this.bSK);
        a(dgVar);
        return dgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, dg dgVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, dgVar);
        a(dgVar);
        b(dgVar);
        c(dgVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.sw();
            a(dgVar, postData2, view, i);
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(dg dgVar, PostData postData, View view, int i) {
        if (dgVar != null && postData != null) {
            b(dgVar, postData, view, i);
            c(dgVar, postData);
            c(dgVar, postData, view, i);
            d(dgVar, postData, view, i);
            d(dgVar, postData);
            b(dgVar, postData);
            a(dgVar, postData);
        }
    }

    private void a(dg dgVar, PostData postData) {
        if (postData == null || postData.aNs() == null) {
            dgVar.efv.setVisibility(8);
            return;
        }
        TbRichText aui = postData.aui();
        com.baidu.tieba.pb.view.k.a(postData.aNs(), dgVar.efv, false, false, aui != null && StringUtils.isNull(aui.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(dg dgVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eez) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dgVar.eiQ.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            dgVar.eiQ.setLayoutParams(layoutParams);
            dgVar.eiQ.setPadding(0, 0, 0, 0);
            dgVar.eiQ.gt(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dgVar.eiQ.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(w.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds20);
            dgVar.eiQ.setLayoutParams(layoutParams2);
            dgVar.eiQ.gt(postData.getBimg_url());
            dgVar.eiQ.setTextViewOnTouchListener(this.eeF);
            dgVar.eiQ.setTextViewCheckSelection(false);
        }
        dgVar.eiQ.setTextViewOnTouchListener(this.eeF);
        dgVar.eiQ.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x057b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(dg dgVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (dgVar != null && postData != null) {
            if (postData.bXh) {
                com.baidu.tbadk.core.util.aq.k(dgVar.avN, w.e.cp_bg_line_c);
                dgVar.avN.setVisibility(0);
            } else {
                dgVar.avN.setVisibility(8);
            }
            dgVar.eiP.setTag(null);
            dgVar.eiP.setUserId(null);
            dgVar.aWr.setText((CharSequence) null);
            dgVar.eiV.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int go = com.baidu.tbadk.util.x.go(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (go > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.x.d(name_show, 0, 12)) + "...";
                    }
                } else if (go > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.x.d(name_show, 0, 14)) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    dgVar.aWr.setText(af(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aF(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    dgVar.aWr.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aF = com.baidu.adp.lib.util.j.aF(postData.getAuthor().getName_show());
                    if (aF + i2 > 14) {
                        i3 = 0;
                    } else if (aF + i2 >= 12) {
                        i3 = 1;
                    } else if (aF + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (dgVar.eiX != null) {
                    dgVar.eiX.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    dgVar.eiX.setOnClickListener(this.efF.egu.bWW);
                    dgVar.eiX.a(iconInfo, i3, this.efF.getResources().getDimensionPixelSize(w.f.ds26), this.efF.getResources().getDimensionPixelSize(w.f.ds26), this.efF.getResources().getDimensionPixelSize(w.f.ds8));
                }
                if (dgVar.eiW != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        dgVar.eiW.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    dgVar.eiW.setOnClickListener(this.efF.egu.epC);
                    dgVar.eiW.a(tShowInfoNew, 3, this.efF.getResources().getDimensionPixelSize(w.f.ds36), this.efF.getResources().getDimensionPixelSize(w.f.ds36), this.efF.getResources().getDimensionPixelSize(w.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                    com.baidu.tbadk.core.util.aq.c(dgVar.aWr, w.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aq.c(dgVar.aWr, w.e.cp_cont_f, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                dgVar.aWr.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                dgVar.aWr.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
                dgVar.aWr.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pT())) {
                    dgVar.eiP.setVisibility(8);
                    dgVar.eiV.setVisibility(0);
                    dgVar.eiV.getHeadView().c(portrait, 28, false);
                    dgVar.eiV.getHeadView().setUserId(postData.getAuthor().getUserId());
                    dgVar.eiV.getHeadView().setUserName(postData.getAuthor().getUserName());
                    dgVar.eiV.dS(postData.getAuthor().getPendantData().pT());
                } else {
                    dgVar.eiP.setUserId(postData.getAuthor().getUserId());
                    dgVar.eiP.ad(postData.getAuthor().getUserName(), postData.bgW());
                    dgVar.eiP.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    dgVar.eiP.setImageDrawable(null);
                    dgVar.eiP.c(portrait, 28, false);
                    dgVar.eiP.setVisibility(0);
                    dgVar.eiV.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    dgVar.eiK.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.i(dgVar.eiK, w.e.cp_link_tip_a);
                } else {
                    dgVar.eiK.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.f bgP = postData.bgP();
            if (bgP != null && !StringUtils.isNull(bgP.getName())) {
                String name = bgP.getName();
                String lat = bgP.getLat();
                String lng = bgP.getLng();
                dgVar.eiM.setVisibility(0);
                dgVar.eiM.setText(bgP.getName());
                dgVar.eiM.setOnClickListener(new df(this, lat, lng, name));
            } else {
                dgVar.eiM.setVisibility(8);
            }
            dgVar.eiL.setText(postData.bgO());
            if (postData.bha() != null && !StringUtils.isNull(postData.bha().getForumName())) {
                dgVar.bIm.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.bha().getForumName(), 5, true)));
                dgVar.bIm.setVisibility(0);
            } else {
                dgVar.bIm.setVisibility(8);
            }
            int i4 = 0;
            if (this.efF.aJt()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.bha() != null) {
                i4 = postData.bha().qU();
            }
            if (i4 > 0) {
                dgVar.eiU.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(dgVar.eiU, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                dgVar.eiU.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_load_sub_data, postData);
            sparseArray.put(w.h.tag_load_sub_view, view);
            sparseArray.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bgM()));
            sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eeB != null && this.eeB.aHR() != 0) {
                z8 = true;
                z9 = true;
                if (postData != null && postData.getAuthor() != null) {
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
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.getAuthor() != null && UtilHelper.isCurrentAccount(postData.getAuthor().getUserId())) {
                        z3 = true;
                        z4 = true;
                    } else {
                        boolean z11 = z10;
                        z3 = z;
                        z4 = z11;
                    }
                    if (z7) {
                        z5 = z2;
                        z6 = z3;
                    } else {
                        z8 = false;
                        z6 = false;
                        z5 = false;
                    }
                    int i5 = 1;
                    if (postData.bgM() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(w.h.tag_should_manage_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eeB.aHR()));
                        sparseArray.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(w.h.tag_user_mute_visible, true);
                        sparseArray.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eeB.aHG() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.eeB.aHG().getId());
                        }
                        sparseArray.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(w.h.tag_should_delete_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eeB.aHR()));
                        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_should_delete_visible, false);
                    }
                    dgVar.eiO.setTag(sparseArray);
                }
            }
            z = z9;
            z2 = false;
            if (postData == null) {
            }
            boolean z112 = z10;
            z3 = z;
            z4 = z112;
            if (z7) {
            }
            int i52 = 1;
            if (postData.bgM() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            dgVar.eiO.setTag(sparseArray);
        }
    }

    private void c(dg dgVar, PostData postData) {
        if (dgVar != null && postData != null) {
            dgVar.eiN.a(postData.bgZ(), postData.bgY(), false);
            dgVar.eiN.setTag(w.h.tag_clip_board, postData);
        }
    }

    private void d(dg dgVar, PostData postData) {
        if (dgVar != null && postData != null) {
            if (postData.bgM() > 0) {
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bgM()));
                dgVar.eiT.setVisibility(0);
                dgVar.eiT.setText(format);
                return;
            }
            dgVar.eiT.setVisibility(8);
        }
    }

    private void c(dg dgVar, PostData postData, View view, int i) {
        if (dgVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dgVar.eiQ.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            dgVar.eiQ.setPadding(0, 0, 0, 0);
            if (!this.eez) {
                dgVar.eiQ.setIsSupportVitality(false);
                dgVar.eiQ.setDefaultImageId(w.g.icon_click);
            } else {
                dgVar.eiQ.gt(null);
                dgVar.eiQ.setBackgroundDrawable(null);
                dgVar.eiQ.setIsSupportVitality(false);
                dgVar.eiQ.setDefaultImageId(w.g.transparent_bg);
            }
            dgVar.eiQ.setVideoImageId(w.g.pic_video);
            a(dgVar.eiQ, view, !StringUtils.isNull(postData.getBimg_url()));
            dgVar.eiQ.setLayoutParams(layoutParams);
            dgVar.eiQ.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            dgVar.eiQ.setIsFromCDN(this.mIsFromCDN);
            dgVar.eiQ.a(postData.aui(), true, this.eiH);
            SparseArray sparseArray = (SparseArray) dgVar.eiQ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            dgVar.eiQ.setTag(sparseArray);
            dgVar.eeP.setTag(w.h.tag_from, sparseArray);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [598=5] */
    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView == null || view == null) {
            return;
        }
        int af = (((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            af = (af - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        tbRichTextView.setMaxImageWidth(af - (z ? getDimensionPixelSize(w.f.ds70) : 0));
        tbRichTextView.setMaxImageHeight((int) (af * 1.618f));
    }

    private void d(dg dgVar, PostData postData, View view, int i) {
        if (dgVar != null && postData != null) {
            if (postData.bgQ() > 0 && postData.bgJ() != null && postData.bgJ().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dgVar.eiS.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
                layoutParams.bottomMargin = 0;
                dgVar.eiS.setLayoutParams(layoutParams);
                if (this.eeC == null) {
                    this.eeC = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.eeC.setIsFromCDN(this.mIsFromCDN);
                    this.eeC.J(this.eeE);
                    String str = null;
                    if (this.eeB != null && this.eeB.aHG() != null && this.eeB.aHG().getAuthor() != null) {
                        str = this.eeB.aHG().getAuthor().getUserId();
                    }
                    this.eeC.A(this.eeB.aHR(), str != null && str.equals(TbadkCoreApplication.getCurrentAccount()));
                    this.eeC.m(this.eeB.aHG());
                }
                this.eeC.nW(postData.getId());
                dgVar.eiS.setVisibility(0);
                dgVar.eiS.a(postData, view);
                dgVar.eiS.setChildOnClickListener(this.coZ);
                dgVar.eiS.setChildOnLongClickListener(this.atr);
                dgVar.eiS.setChildOnTouchListener(this.eeF);
                dgVar.eiS.setSubPbAdapter(this.eeC);
                dgVar.eiS.setVisibility(0);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dgVar.eiS.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                dgVar.eiS.setLayoutParams(layoutParams2);
                dgVar.eiS.setVisibility(8);
            }
            if (postData.fuU) {
                dgVar.avO.setVisibility(0);
            } else {
                dgVar.avO.setVisibility(4);
            }
        }
    }

    private void a(dg dgVar) {
        if (dgVar != null) {
            if (dgVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.c(dgVar.aWr, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dgVar.eiK, w.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aq.c(dgVar.eiL, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dgVar.eiT, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dgVar.bIm, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.c(dgVar.eiM, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.k(dgVar.avO, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aq.c(dgVar.eiO, w.g.icon_floor_more_selector);
                dgVar.eiQ.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
                com.baidu.tbadk.core.util.aq.k(dgVar.eiS, w.e.cp_bg_line_e);
                dgVar.eiR.onChangeSkinType();
                dgVar.eiN.onChangeSkinType();
            }
            dgVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void b(dg dgVar) {
        dgVar.eeP.setOnTouchListener(this.eeF);
        dgVar.eeP.setOnLongClickListener(this.atr);
        if (this.efF.getPageContext() != null && this.efF.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.efF.getPageContext().getOrignalPage()).egu;
            dgVar.aWr.setOnClickListener(aVar.epB);
            dgVar.eiP.setOnClickListener(aVar.epB);
            dgVar.eiV.setOnClickListener(aVar.epB);
            dgVar.eiV.getHeadView().setOnClickListener(aVar.epB);
            dgVar.eiQ.setOnLongClickListener(this.atr);
            dgVar.eiQ.setOnTouchListener(this.eeF);
            dgVar.eiQ.setCommonTextViewOnClickListener(this.coZ);
            dgVar.eiQ.setOnImageClickListener(this.aOe);
            dgVar.eiQ.setOnEmotionClickListener(aVar.epD);
            dgVar.eiO.setOnClickListener(this.coZ);
            dgVar.eiN.setOnClickListener(this.coZ);
            dgVar.efv.setOnClickListener(this.coZ);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eiH = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eeB = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void hL(boolean z) {
        this.eez = z;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.ap.a((Context) this.efF.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(dg dgVar) {
        dgVar.eiQ.setTextViewOnTouchListener(this.eeF);
        dgVar.eiQ.setTextViewCheckSelection(false);
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
}
