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
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dh extends dn<PostData, dm> implements View.OnClickListener {
    private TbRichTextView.e aOb;
    private com.baidu.tieba.pb.a.d aOc;
    private View.OnLongClickListener atb;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bYA;
    private com.baidu.adp.lib.e.b<TbImageView> bYB;
    private View.OnClickListener cvw;
    private boolean eka;
    protected com.baidu.tieba.pb.data.f ekc;
    private com.baidu.tieba.pb.pb.sub.ba ekd;
    private View.OnClickListener ekf;
    private TbRichTextView.b eop;
    private com.baidu.tieba.pb.a.d eoq;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        if (noPressedLinearLayout.findViewById(w.h.view_floor_praise) != null && noPressedLinearLayout.findViewById(w.h.view_floor_praise).getTag(w.h.tag_clip_board) != null && this.cvw != null) {
            View findViewById = noPressedLinearLayout.findViewById(w.h.view_floor_praise);
            if (!((PostData) findViewById.getTag(w.h.tag_clip_board)).bit() && this.cvw != null) {
                this.cvw.onClick(findViewById);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public dh(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.eop = null;
        this.eka = true;
        this.mHostId = null;
        this.ekc = null;
        this.ekf = null;
        this.cvw = null;
        this.aOb = null;
        this.aOc = null;
        this.atb = null;
        this.ekd = null;
        this.bYA = new com.baidu.adp.lib.e.b<>(new di(this), 6, 0);
        this.bYB = new com.baidu.adp.lib.e.b<>(new dj(this), 12, 0);
        this.eoq = new com.baidu.tieba.pb.a.d(new dk(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public dm onCreateViewHolder(ViewGroup viewGroup) {
        dm dmVar = new dm(this.elf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_reply_floor_item_layout, viewGroup, false));
        dmVar.eoA.setConstrainLayoutPool(this.bYA);
        dmVar.eoA.setImageViewPool(this.bYB);
        a(dmVar);
        return dmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, dm dmVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, dmVar);
        a(dmVar);
        b(dmVar);
        c(dmVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.ss();
            a(dmVar, postData2, view, i);
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(dm dmVar, PostData postData, View view, int i) {
        if (dmVar != null && postData != null) {
            b(dmVar, postData, view, i);
            c(dmVar, postData);
            c(dmVar, postData, view, i);
            d(dmVar, postData, view, i);
            d(dmVar, postData);
            b(dmVar, postData);
            a(dmVar, postData);
        }
    }

    private void a(dm dmVar, PostData postData) {
        if (postData == null || postData.aOB() == null) {
            dmVar.ekV.setVisibility(8);
            return;
        }
        TbRichText avd = postData.avd();
        com.baidu.tieba.pb.view.aa.a(postData.aOB(), dmVar.ekV, false, false, avd != null && StringUtils.isNull(avd.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void b(dm dmVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.eka) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dmVar.eoz.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            dmVar.eoz.setLayoutParams(layoutParams);
            dmVar.eoz.setPadding(0, 0, 0, 0);
            dmVar.eoz.gs(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dmVar.eoz.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(w.f.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(w.f.ds20);
            dmVar.eoz.setLayoutParams(layoutParams2);
            dmVar.eoz.gs(postData.getBimg_url());
        }
        dmVar.eoz.setTextViewOnTouchListener(this.eoq);
        dmVar.eoz.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0591  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(dm dmVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (dmVar != null && postData != null) {
            if (postData.cdg) {
                com.baidu.tbadk.core.util.aq.k(dmVar.avx, w.e.cp_bg_line_c);
                dmVar.avx.setVisibility(0);
            } else {
                dmVar.avx.setVisibility(8);
            }
            dmVar.eoy.setTag(null);
            dmVar.eoy.setUserId(null);
            dmVar.aTT.setText((CharSequence) null);
            dmVar.eoE.getHeadView().setUserId(null);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                int gn = com.baidu.tbadk.util.x.gn(name_show);
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    if (gn > 12) {
                        name_show = String.valueOf(com.baidu.tbadk.util.x.d(name_show, 0, 12)) + "...";
                    }
                } else if (gn > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.x.d(name_show, 0, 14)) + "...";
                }
                int i2 = 0;
                if (!StringUtils.isNull(postData.getAuthor().getSealPrefix())) {
                    dmVar.aTT.setText(ae(postData.getAuthor().getSealPrefix(), name_show));
                    i2 = com.baidu.adp.lib.util.j.aF(postData.getAuthor().getSealPrefix()) + 2;
                } else {
                    dmVar.aTT.setText(name_show);
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
                if (dmVar.eoG != null) {
                    dmVar.eoG.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                    dmVar.eoG.setOnClickListener(this.elf.elV.ccV);
                    dmVar.eoG.a(iconInfo, i3, this.elf.getResources().getDimensionPixelSize(w.f.ds26), this.elf.getResources().getDimensionPixelSize(w.f.ds26), this.elf.getResources().getDimensionPixelSize(w.f.ds8));
                }
                if (dmVar.eoF != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        dmVar.eoF.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    dmVar.eoF.setOnClickListener(this.elf.elV.ewB);
                    dmVar.eoF.a(tShowInfoNew, 3, this.elf.getResources().getDimensionPixelSize(w.f.ds36), this.elf.getResources().getDimensionPixelSize(w.f.ds36), this.elf.getResources().getDimensionPixelSize(w.f.ds8), true);
                }
                if (!com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                    com.baidu.tbadk.core.util.aq.c(dmVar.aTT, w.e.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aq.c(dmVar.aTT, w.e.cp_cont_f, 1);
                }
                String portrait = postData.getAuthor().getPortrait();
                dmVar.aTT.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                dmVar.aTT.setTag(w.h.tag_user_name, postData.getAuthor().getUserName());
                dmVar.aTT.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                if (postData.getAuthor().getPendantData() != null && !StringUtils.isNull(postData.getAuthor().getPendantData().pL())) {
                    UtilHelper.showHeadImageViewBigV(dmVar.eoE.getHeadView(), postData.getAuthor());
                    dmVar.eoy.setVisibility(8);
                    dmVar.eoE.setVisibility(0);
                    dmVar.eoE.getHeadView().c(portrait, 28, false);
                    dmVar.eoE.getHeadView().setUserId(postData.getAuthor().getUserId());
                    dmVar.eoE.getHeadView().setUserName(postData.getAuthor().getUserName());
                    dmVar.eoE.dP(postData.getAuthor().getPendantData().pL());
                } else {
                    UtilHelper.showHeadImageViewBigV(dmVar.eoy, postData.getAuthor());
                    dmVar.eoy.setUserId(postData.getAuthor().getUserId());
                    dmVar.eoy.ac(postData.getAuthor().getUserName(), postData.biq());
                    dmVar.eoy.setTag(w.h.tag_virtual_user_url, postData.getAuthor().getVirtualUserUrl());
                    dmVar.eoy.setImageDrawable(null);
                    dmVar.eoy.c(portrait, 28, false);
                    dmVar.eoy.setVisibility(0);
                    dmVar.eoE.setVisibility(8);
                }
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.getAuthor().getUserId())) {
                    dmVar.eot.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.i(dmVar.eot, w.e.cp_link_tip_a);
                } else {
                    dmVar.eot.setVisibility(8);
                }
            }
            com.baidu.tbadk.data.g bij = postData.bij();
            if (bij != null && !StringUtils.isNull(bij.getName())) {
                String name = bij.getName();
                String lat = bij.getLat();
                String lng = bij.getLng();
                dmVar.eov.setVisibility(0);
                dmVar.eov.setText(bij.getName());
                dmVar.eov.setOnClickListener(new dl(this, lat, lng, name));
            } else {
                dmVar.eov.setVisibility(8);
            }
            dmVar.eou.setText(postData.bii());
            if (postData.biu() != null && !StringUtils.isNull(postData.biu().getForumName())) {
                dmVar.bOa.setText(this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(postData.biu().getForumName(), 5, true)));
                dmVar.bOa.setVisibility(0);
            } else {
                dmVar.bOa.setVisibility(8);
            }
            int i4 = 0;
            if (this.elf.aKl()) {
                if (postData.getAuthor() != null) {
                    i4 = postData.getAuthor().getLevel_id();
                }
            } else if (postData.biu() != null) {
                i4 = postData.biu().qQ();
            }
            if (i4 > 0) {
                dmVar.eoD.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(dmVar.eoD, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                dmVar.eoD.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_load_sub_data, postData);
            sparseArray.put(w.h.tag_load_sub_view, view);
            sparseArray.put(w.h.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(w.h.tag_pb_floor_number, Integer.valueOf(postData.big()));
            sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.getAuthor() != null && !StringUtils.isNull(postData.getAuthor().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.ekc != null && this.ekc.aIM() != 0) {
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
            if (this.ekc != null && this.ekc.aIB() != null && this.ekc.aIB().getAuthor() != null && postData.getAuthor() != null) {
                String userId2 = this.ekc.aIB().getAuthor().getUserId();
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
                    if (postData.big() == 1) {
                        i5 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(w.h.tag_should_manage_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ekc.aIM()));
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
                        if (this.ekc.aIB() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.ekc.aIB().getId());
                        }
                        sparseArray.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(w.h.tag_should_delete_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(this.ekc.aIM()));
                        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_should_delete_visible, false);
                    }
                    dmVar.eox.setTag(sparseArray);
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
            if (postData.big() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            dmVar.eox.setTag(sparseArray);
        }
    }

    private void c(dm dmVar, PostData postData) {
        if (dmVar != null && postData != null) {
            dmVar.eow.a(postData.bit(), postData.bis(), false);
            dmVar.eow.setTag(w.h.tag_clip_board, postData);
        }
    }

    private void d(dm dmVar, PostData postData) {
        if (dmVar != null && postData != null) {
            if (postData.big() > 0) {
                String format = String.format(this.mContext.getString(w.l.is_floor), Integer.valueOf(postData.big()));
                dmVar.eoC.setVisibility(0);
                dmVar.eoC.setText(format);
                return;
            }
            dmVar.eoC.setVisibility(8);
        }
    }

    private void c(dm dmVar, PostData postData, View view, int i) {
        if (dmVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dmVar.eoz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            dmVar.eoz.setPadding(0, 0, 0, 0);
            if (!this.eka) {
                dmVar.eoz.setIsSupportVitality(false);
                dmVar.eoz.setDefaultImageId(w.g.icon_click);
            } else {
                dmVar.eoz.gs(null);
                dmVar.eoz.setBackgroundDrawable(null);
                dmVar.eoz.setIsSupportVitality(false);
                dmVar.eoz.setDefaultImageId(w.g.transparent_bg);
            }
            dmVar.eoz.setVideoImageId(w.g.pic_video);
            a(dmVar.eoz, view, !StringUtils.isNull(postData.getBimg_url()));
            dmVar.eoz.setLayoutParams(layoutParams);
            dmVar.eoz.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            dmVar.eoz.setIsFromCDN(this.mIsFromCDN);
            dmVar.eoz.a(postData.avd(), true, this.eop);
            SparseArray sparseArray = (SparseArray) dmVar.eoz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            dmVar.eoz.setTag(sparseArray);
            dmVar.ekp.setTag(w.h.tag_from, sparseArray);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [656=5] */
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

    private void d(dm dmVar, PostData postData, View view, int i) {
        if (dmVar != null && postData != null) {
            if (postData.bik() > 0 && postData.bid() != null && postData.bid().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dmVar.eoB.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16);
                layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds116);
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds40);
                layoutParams.bottomMargin = 0;
                dmVar.eoB.setLayoutParams(layoutParams);
                if (this.ekd == null) {
                    this.ekd = new com.baidu.tieba.pb.pb.sub.ba(this.mContext);
                    this.ekd.setIsFromCDN(this.mIsFromCDN);
                    this.ekd.J(this.ekf);
                    String str = null;
                    if (this.ekc != null && this.ekc.aIB() != null && this.ekc.aIB().getAuthor() != null) {
                        str = this.ekc.aIB().getAuthor().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.ekc != null) {
                        this.ekd.A(this.ekc.aIM(), z);
                        this.ekd.N(this.ekc.aIB());
                    }
                }
                this.ekd.ok(postData.getId());
                dmVar.eoB.setVisibility(0);
                dmVar.eoB.a(postData, view);
                dmVar.eoB.setChildOnClickListener(this.cvw);
                dmVar.eoB.setChildOnLongClickListener(this.atb);
                dmVar.eoB.setChildOnTouchListener(this.eoq);
                dmVar.eoB.setSubPbAdapter(this.ekd);
                dmVar.eoB.setVisibility(0);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dmVar.eoB.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                dmVar.eoB.setLayoutParams(layoutParams2);
                dmVar.eoB.setVisibility(8);
            }
            if (postData.fCL) {
                dmVar.avy.setVisibility(0);
            } else {
                dmVar.avy.setVisibility(4);
            }
        }
    }

    private void a(dm dmVar) {
        if (dmVar != null) {
            if (dmVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aq.c(dmVar.aTT, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dmVar.eot, w.e.cp_link_tip_a, 1);
                com.baidu.tbadk.core.util.aq.c(dmVar.eou, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dmVar.eoC, w.e.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aq.c(dmVar.bOa, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.c(dmVar.eov, w.e.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aq.k(dmVar.avy, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aq.c(dmVar.eox, w.g.icon_floor_more_selector);
                dmVar.eoz.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
                com.baidu.tbadk.core.util.aq.k(dmVar.eoB, w.e.cp_bg_line_e);
                dmVar.eoA.onChangeSkinType();
                dmVar.eow.onChangeSkinType();
            }
            dmVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void b(dm dmVar) {
        dmVar.ekp.setOnTouchListener(this.eoq);
        dmVar.ekp.setOnLongClickListener(this.atb);
        if (this.elf.getPageContext() != null && this.elf.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.elf.getPageContext().getOrignalPage()).elV;
            dmVar.aTT.setOnClickListener(aVar.ewA);
            dmVar.eoy.setOnClickListener(aVar.ewA);
            dmVar.eoE.setOnClickListener(aVar.ewA);
            dmVar.eoE.getHeadView().setOnClickListener(aVar.ewA);
            dmVar.eoz.setOnLongClickListener(this.atb);
            dmVar.eoz.setOnTouchListener(this.eoq);
            dmVar.eoz.setCommonTextViewOnClickListener(this.cvw);
            dmVar.eoz.setOnImageClickListener(this.aOb);
            dmVar.eoz.setOnImageTouchListener(this.eoq);
            dmVar.eoz.setOnEmotionClickListener(aVar.ewC);
            dmVar.eox.setOnClickListener(this.cvw);
            dmVar.eow.setOnClickListener(this.cvw);
            dmVar.ekV.setOnClickListener(this.cvw);
        }
    }

    public void a(TbRichTextView.b bVar) {
        this.eop = bVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.ekc = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void hZ(boolean z) {
        this.eka = z;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.elf.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(dm dmVar) {
        dmVar.eoz.setTextViewOnTouchListener(this.aOc);
        dmVar.eoz.setTextViewCheckSelection(false);
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
}
