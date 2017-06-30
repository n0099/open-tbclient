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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends du<PostData, dt> implements View.OnClickListener {
    private TbRichTextView.e aPr;
    private com.baidu.tieba.pb.a.d aPs;
    private View.OnLongClickListener aue;
    private View.OnClickListener cDj;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> cgJ;
    private com.baidu.adp.lib.e.b<TbImageView> cgK;
    private boolean esY;
    protected com.baidu.tieba.pb.data.f eta;
    private com.baidu.tieba.pb.pb.sub.ba etb;
    private View.OnClickListener ete;
    private TbRichTextView.b exv;
    private com.baidu.tieba.pb.a.d exw;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData aV;
        if (noPressedLinearLayout.findViewById(w.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(w.h.view_floor_praise).getTag(w.h.tag_clip_board) != null && this.cDj != null) {
            View findViewById = noPressedLinearLayout.findViewById(w.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(w.h.tag_clip_board)).bmH() && this.cDj != null && this.euf != null && (aV = this.euf.aV(findViewById)) != null) {
                TiebaStatic.log(this.euf.aNC().r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_locate", 5).r("obj_id", aV.bmH() ? 0 : 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cdo(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.exv = null;
        this.esY = true;
        this.mHostId = null;
        this.eta = null;
        this.ete = null;
        this.cDj = null;
        this.aPr = null;
        this.aPs = null;
        this.aue = null;
        this.etb = null;
        this.cgJ = new com.baidu.adp.lib.e.b<>(new dp(this), 6, 0);
        this.cgK = new com.baidu.adp.lib.e.b<>(new dq(this), 12, 0);
        this.exw = new com.baidu.tieba.pb.a.d(new dr(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public dt onCreateViewHolder(ViewGroup viewGroup) {
        dt dtVar = new dt(this.euf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_reply_floor_item_layout, viewGroup, false));
        dtVar.exG.setConstrainLayoutPool(this.cgJ);
        dtVar.exG.setImageViewPool(this.cgK);
        a(dtVar);
        return dtVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, dt dtVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, dtVar);
        a(dtVar);
        b(dtVar);
        c(dtVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            i(postData2);
            postData2.sp();
            a(dtVar, postData2, view, i);
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(dt dtVar, PostData postData, View view, int i) {
        if (dtVar != null && postData != null) {
            b(dtVar, postData, view, i);
            c(dtVar, postData);
            c(dtVar, postData, view, i);
            d(dtVar, postData, view, i);
            d(dtVar, postData);
            b(dtVar, postData);
            a(dtVar, postData);
        }
    }

    private void i(PostData postData) {
        if (postData.Yf == 0 || postData.fMN) {
            com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c12203");
            auVar.Z("post_id", postData.getId());
            auVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            auVar.Z("cuid", TbadkCoreApplication.m9getInst().getCuid());
            auVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(auVar);
        }
    }

    private void a(dt dtVar, PostData postData) {
        if (postData == null || postData.aSA() == null) {
            dtVar.etU.setVisibility(8);
            return;
        }
        TbRichText azb = postData.azb();
        com.baidu.tieba.pb.view.aa.a(postData.aSA(), dtVar.etU, false, false, azb != null && StringUtils.isNull(azb.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(dt dtVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.esY) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dtVar.exF.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            dtVar.exF.setLayoutParams(layoutParams);
            dtVar.exF.setPadding(0, 0, 0, 0);
            dtVar.exF.gP(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dtVar.exF.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(w.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds20);
            dtVar.exF.setLayoutParams(layoutParams2);
            dtVar.exF.gP(postData.getBimg_url());
        }
        dtVar.exF.setTextViewOnTouchListener(this.exw);
        dtVar.exF.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(dt dtVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (dtVar != null && postData != null) {
            if (postData.cls) {
                com.baidu.tbadk.core.util.as.k(dtVar.awA, w.e.cp_bg_line_c);
                dtVar.awA.setVisibility(0);
            } else {
                dtVar.awA.setVisibility(8);
            }
            dtVar.exE.setTag(null);
            dtVar.exE.setUserId(null);
            dtVar.aVm.setText((CharSequence) null);
            dtVar.exK.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gJ = com.baidu.tbadk.util.y.gJ(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gJ > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.y.D(name_show, 12)) + "...";
                    }
                } else if (gJ > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.y.D(name_show, 14)) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    dtVar.aVm.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aK(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    dtVar.aVm.setText(name_show);
                }
                int i3 = 3;
                if (!StringUtils.isNull(name_show)) {
                    int aK = com.baidu.adp.lib.util.j.aK(postData.getAuthor().getName_show());
                    if (aK + i2 > 14) {
                        i3 = 0;
                    } else if (aK + i2 >= 12) {
                        i3 = 1;
                    } else if (aK + i2 >= 10) {
                        i3 = 2;
                    }
                }
                ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                if (dtVar.exM != null) {
                    dtVar.exM.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    dtVar.exM.setOnClickListener(this.euf.euV.clh);
                    dtVar.exM.a(iconInfo, i3, this.euf.getResources().getDimensionPixelSize(w.f.ds26), this.euf.getResources().getDimensionPixelSize(w.f.ds26), this.euf.getResources().getDimensionPixelSize(w.f.ds8));
                }
                if (dtVar.exL != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        dtVar.exL.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    dtVar.exL.setOnClickListener(this.euf.euV.eFX);
                    dtVar.exL.a(tShowInfoNew, 3, this.euf.getResources().getDimensionPixelSize(w.f.ds36), this.euf.getResources().getDimensionPixelSize(w.f.ds36), this.euf.getResources().getDimensionPixelSize(w.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.z.t(tShowInfoNew) || postData.getAuthor().isBigV()) {
                    com.baidu.tbadk.core.util.as.c(dtVar.aVm, w.e.cp_cont_r, 1);
                } else {
                    com.baidu.tbadk.core.util.as.c(dtVar.aVm, w.e.cp_cont_f, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                dtVar.aVm.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                dtVar.aVm.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
                dtVar.aVm.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                String name_show2 = postData.getAuthor().getName_show();
                String userName = postData.getAuthor().getUserName();
                if (com.baidu.tbadk.n.ab.fU() && name_show2 != null && !name_show2.equals(userName)) {
                    dtVar.aVm.setText(com.baidu.tieba.pb.d.ao(this.mContext, dtVar.aVm.getText().toString()));
                    dtVar.aVm.setGravity(16);
                    dtVar.aVm.setTag(w.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aLW());
                    com.baidu.tbadk.core.util.as.c(dtVar.aVm, w.e.cp_other_e, 1);
                }
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pI())) {
                    UtilHelper.showHeadImageViewBigV(dtVar.exK.getHeadView(), postData.getAuthor());
                    dtVar.exE.setVisibility(8);
                    dtVar.exK.setVisibility(0);
                    dtVar.exK.getHeadView().c(portrait, 28, false);
                    dtVar.exK.getHeadView().setUserId(postData.getAuthor().getUserId());
                    dtVar.exK.getHeadView().setUserName(postData.getAuthor().getUserName());
                    dtVar.exK.ek(postData.getAuthor().getPendantData().pI());
                } else {
                    UtilHelper.showHeadImageViewBigV(dtVar.exE, postData.getAuthor());
                    dtVar.exE.setUserId(postData.getAuthor().getUserId());
                    dtVar.exE.ac(postData.getAuthor().getUserName(), postData.bmE());
                    dtVar.exE.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    dtVar.exE.setImageDrawable(null);
                    dtVar.exE.c(portrait, 28, false);
                    dtVar.exE.setVisibility(0);
                    dtVar.exK.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    dtVar.exz.setVisibility(0);
                    com.baidu.tbadk.core.util.as.i(dtVar.exz, w.e.cp_link_tip_a);
                } else {
                    dtVar.exz.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.g bmx = postData.bmx();
            if (bmx != null && !StringUtils.isNull(bmx.getName())) {
                String name = bmx.getName();
                String lat = bmx.getLat();
                String lng = bmx.getLng();
                dtVar.exB.setVisibility(0);
                dtVar.exB.setText(bmx.getName());
                dtVar.exB.setOnClickListener(new ds(this, lat, lng, name));
            } else {
                dtVar.exB.setVisibility(8);
            }
            dtVar.exA.setText(postData.bmw());
            if (postData.bmI() != null && !StringUtils.isNull(postData.bmI().getForumName())) {
                dtVar.bUV.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.bmI().getForumName(), 5, true)));
                dtVar.bUV.setVisibility(0);
            } else {
                dtVar.bUV.setVisibility(8);
            }
            int i4 = 0;
            if (this.euf.aOi()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.bmI() != null) {
                i4 = postData.bmI().qN();
            }
            if (i4 > 0) {
                dtVar.exJ.setVisibility(0);
                com.baidu.tbadk.core.util.as.c(dtVar.exJ, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                dtVar.exJ.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_load_sub_data, postData);
            sparseArray.put(w.h.tag_load_sub_view, view);
            sparseArray.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.bmu()));
            sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.eta != null && this.eta.aMG() != 0) {
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
            if (this.eta != null && this.eta.aMv() != null && this.eta.aMv().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.eta.aMv().getAuthor().getUserId();
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
                    if (postData.bmu() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(w.h.tag_should_manage_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eta.aMG()));
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
                        if (this.eta.aMv() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.eta.aMv().getId());
                        }
                        sparseArray.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(w.h.tag_should_delete_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(this.eta.aMG()));
                        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_should_delete_visible, false);
                    }
                    dtVar.exD.setTag(sparseArray);
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
            if (postData.bmu() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            dtVar.exD.setTag(sparseArray);
        }
    }

    private void c(dt dtVar, PostData postData) {
        if (dtVar != null && postData != null) {
            dtVar.exC.a(postData.bmH(), postData.bmG(), false);
            dtVar.exC.setTag(w.h.tag_clip_board, postData);
        }
    }

    private void d(dt dtVar, PostData postData) {
        if (dtVar != null && postData != null) {
            if (postData.bmu() > 0) {
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.bmu()));
                dtVar.exI.setVisibility(0);
                dtVar.exI.setText(format);
                return;
            }
            dtVar.exI.setVisibility(8);
        }
    }

    private void c(dt dtVar, PostData postData, View view, int i) {
        if (dtVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dtVar.exF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            dtVar.exF.setPadding(0, 0, 0, 0);
            if (!this.esY) {
                dtVar.exF.setIsSupportVitality(false);
                dtVar.exF.setDefaultImageId(w.g.icon_click);
            } else {
                dtVar.exF.gP(null);
                dtVar.exF.setBackgroundDrawable(null);
                dtVar.exF.setIsSupportVitality(false);
                dtVar.exF.setDefaultImageId(w.g.transparent_bg);
            }
            dtVar.exF.setVideoImageId(w.g.pic_video);
            a(dtVar.exF, view, !StringUtils.isNull(postData.getBimg_url()));
            dtVar.exF.setLayoutParams(layoutParams);
            dtVar.exF.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c));
            dtVar.exF.setIsFromCDN(this.mIsFromCDN);
            dtVar.exF.a(postData.azb(), true, this.exv);
            SparseArray sparseArray = (SparseArray) dtVar.exF.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            dtVar.exF.setTag(sparseArray);
            dtVar.eto.setTag(w.h.tag_from, sparseArray);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [701=5] */
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

    private void d(dt dtVar, PostData postData, View view, int i) {
        if (dtVar != null && postData != null) {
            if (postData.bmy() > 0 && postData.bmr() != null && postData.bmr().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dtVar.exH.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
                layoutParams.bottomMargin = 0;
                dtVar.exH.setLayoutParams(layoutParams);
                if (this.etb == null) {
                    this.etb = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.etb.setIsFromCDN(this.mIsFromCDN);
                    this.etb.K(this.ete);
                    String str = null;
                    if (this.eta != null && this.eta.aMv() != null && this.eta.aMv().getAuthor() != null) {
                        str = this.eta.aMv().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.eta != null) {
                        this.etb.A(this.eta.aMG(), z);
                        this.etb.O(this.eta.aMv());
                    }
                }
                this.etb.pe(postData.getId());
                dtVar.exH.setVisibility(0);
                dtVar.exH.a(postData, view);
                dtVar.exH.setChildOnClickListener(this.cDj);
                dtVar.exH.setChildOnLongClickListener(this.aue);
                dtVar.exH.setChildOnTouchListener(this.exw);
                dtVar.exH.setSubPbAdapter(this.etb);
                dtVar.exH.setVisibility(0);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dtVar.exH.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                dtVar.exH.setLayoutParams(layoutParams2);
                dtVar.exH.setVisibility(8);
            }
            if (postData.fMQ) {
                dtVar.awB.setVisibility(0);
            } else {
                dtVar.awB.setVisibility(4);
            }
        }
    }

    private void a(dt dtVar) {
        if (dtVar != null) {
            if (dtVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.as.c(dtVar.aVm, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.as.c(dtVar.exz, w.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.as.c(dtVar.exA, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.as.c(dtVar.exI, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.as.c(dtVar.bUV, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.as.c(dtVar.exB, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.as.k(dtVar.awB, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.as.c(dtVar.exD, w.g.icon_floor_more_selector);
                dtVar.exF.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_b));
                com.baidu.tbadk.core.util.as.k(dtVar.exH, w.e.cp_bg_line_e);
                dtVar.exG.onChangeSkinType();
                dtVar.exC.onChangeSkinType();
            }
            dtVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void b(dt dtVar) {
        dtVar.eto.setOnTouchListener(this.exw);
        dtVar.eto.setOnLongClickListener(this.aue);
        if (this.euf.getPageContext() != null && this.euf.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.euf.getPageContext().getOrignalPage()).euV;
            dtVar.aVm.setOnClickListener(aVar.eFW);
            dtVar.exE.setOnClickListener(aVar.eFW);
            dtVar.exK.setOnClickListener(aVar.eFW);
            dtVar.exK.getHeadView().setOnClickListener(aVar.eFW);
            dtVar.exF.setOnLongClickListener(this.aue);
            dtVar.exF.setOnTouchListener(this.exw);
            dtVar.exF.setCommonTextViewOnClickListener(this.cDj);
            dtVar.exF.setOnImageClickListener(this.aPr);
            dtVar.exF.setOnImageTouchListener(this.exw);
            dtVar.exF.setOnEmotionClickListener(aVar.eFY);
            dtVar.exD.setOnClickListener(this.cDj);
            dtVar.exC.setOnClickListener(this.cDj);
            dtVar.etU.setOnClickListener(this.cDj);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.exv = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.eta = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void iv(boolean z) {
        this.esY = z;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.euf.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(dt dtVar) {
        dtVar.exF.setTextViewOnTouchListener(this.aPs);
        dtVar.exF.setTextViewCheckSelection(false);
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
}
