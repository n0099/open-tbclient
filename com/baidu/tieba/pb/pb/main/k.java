package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private boolean bJK;
    private TbRichTextView.h bJN;
    private com.baidu.tieba.pb.a.c bJO;
    private View.OnLongClickListener bkf;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHH;
    private com.baidu.adp.lib.e.b<TbImageView> dHI;
    private boolean fFq;
    protected com.baidu.tieba.pb.data.f fFs;
    private com.baidu.tieba.pb.pb.sub.d fFt;
    private View.OnClickListener fFv;
    private int fKB;
    private int fKC;
    private int fKD;
    private TbRichTextView.c fKE;
    private com.baidu.tieba.pb.a.c fKF;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData cr;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bvY() && this.mCommonClickListener != null && this.fJR != null && (cr = this.fJR.cr(findViewById)) != null) {
                TiebaStatic.log(this.fJR.baq().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 5).s("obj_id", cr.bvY() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fKB = 0;
        this.fKC = 0;
        this.fKD = 0;
        this.fKE = null;
        this.fFq = true;
        this.mHostId = null;
        this.fFs = null;
        this.fFv = null;
        this.mCommonClickListener = null;
        this.bJN = null;
        this.bJO = null;
        this.bkf = null;
        this.fFt = null;
        this.bJK = true;
        this.dHH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awx */
            public com.baidu.tbadk.widget.layout.b nl() {
                return new com.baidu.tbadk.widget.layout.b(k.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b at(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b au(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.dHI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ed */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView at(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView au(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.fKF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.fJR == null || k.this.fJR.bam() == null || k.this.fJR.bam().bdl())) {
                    if (view instanceof NoPressedLinearLayout) {
                        k.this.a((NoPressedLinearLayout) view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof NoPressedLinearLayout) {
                                k.this.a((NoPressedLinearLayout) parent);
                                break;
                            } else {
                                i++;
                                parent = parent.getParent();
                            }
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean e(View view, MotionEvent motionEvent) {
                if (k.this.bJO != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.bJO.co(view);
                        k.this.bJO.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.mCommonClickListener.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(this.fJR.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.fKT.setConstrainLayoutPool(this.dHH);
        lVar.fKT.setImageViewPool(this.dHI);
        a(lVar);
        this.fKB = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds12);
        this.fKC = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds20);
        this.fKD = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds36);
        if (lVar.fKS != null) {
            lVar.fKS.setDuiEnabled(this.bJK);
        }
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, lVar);
        a(lVar);
        b(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            g(postData2);
            postData2.zP();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bJK = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            b(lVar, postData, view, i);
            e(lVar, postData);
            a(lVar, postData, view);
            c(lVar, postData, view, i);
            f(lVar, postData);
            d(lVar, postData);
            c(lVar, postData);
            g(lVar, postData);
            a(lVar, postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, boolean z) {
        if (z) {
            lVar.fLg.setVisibility(0);
            lVar.fLf.setVisibility(8);
            lVar.fLi.setText(d.j.expand_content);
            com.baidu.tbadk.core.util.aj.c(lVar.fLj, d.f.icon_arrow_gray_down_n);
            return;
        }
        lVar.fLg.setVisibility(8);
        lVar.fLf.setVisibility(0);
        lVar.fLi.setText(d.j.close_content);
        com.baidu.tbadk.core.util.aj.c(lVar.fLj, d.f.icon_arrow_gray_up_n);
    }

    private void a(final l lVar, final PostData postData) {
        if (postData.bwa() == 2) {
            lVar.fLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.fLf.getVisibility() == 8;
                    k.this.a(lVar, !z);
                    postData.mz(z ? false : true);
                    k.this.b(lVar, postData);
                    if (k.this.fJR.bam() != null && k.this.fJR.bam().beh() != null && k.this.fJR.bam().getListView() != null && !z && lVar.getView().getTop() < k.this.fJR.bam().beh().getMeasuredHeight()) {
                        k.this.fJR.bam().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(k.this.fJR.bam().getListView().getData(), postData) + k.this.fJR.bam().getListView().getHeaderViewsCount(), k.this.fJR.bam().beh().getMeasuredHeight());
                    }
                }
            });
            lVar.fLg.setClickable(true);
            lVar.fLg.setText(this.fFs.aYT());
            lVar.fLh.setVisibility(0);
            a(lVar, postData.bvD());
            a(true, lVar, postData);
        } else {
            lVar.fLg.setVisibility(8);
            lVar.fLh.setVisibility(8);
            lVar.fLf.setVisibility(0);
            a(false, lVar, postData);
        }
        b(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.E(postData.bvG());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fLh.getLayoutParams();
        if (z) {
            lVar.fKS.getLayoutStrategy().iU(0);
            if (z2) {
                lVar.fKS.getLayoutStrategy().iT(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds6);
                }
            } else {
                lVar.fKS.getLayoutStrategy().iT(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            lVar.fLh.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds22);
                lVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        lVar.fKS.getLayoutStrategy().iT(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        lVar.fKS.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
            lVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar, PostData postData) {
        TbRichText bvM = postData.bvM();
        bvM.isChanged = true;
        lVar.fKS.a(bvM, true, this.fKE);
    }

    private void g(PostData postData) {
        if (postData.aNV == 0 && postData.gZg) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.aa("post_id", postData.getId());
            akVar.aa("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.aa("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void c(l lVar, PostData postData) {
        if (postData == null || postData.bfA() == null) {
            lVar.fGk.setVisibility(8);
            return;
        }
        TbRichText bvM = postData.bvM();
        com.baidu.tieba.pb.view.g.a(postData.bfA(), lVar.fGk, false, false, bvM != null && StringUtils.isNull(bvM.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fFq) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fKS.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.fKS.setLayoutParams(layoutParams);
            lVar.fKS.setPadding(0, 0, 0, 0);
            lVar.fKS.hs(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fKS.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.fKS.setLayoutParams(layoutParams2);
            lVar.fKS.hs(postData.getBimg_url());
        }
        lVar.fKS.setTextViewOnTouchListener(this.fKF);
        lVar.fKS.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(l lVar, PostData postData, View view, int i) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (lVar != null && postData != null) {
            if (postData.gZl) {
                com.baidu.tbadk.core.util.aj.t(lVar.bmB, d.C0108d.cp_bg_line_c);
                lVar.bmB.setVisibility(0);
            } else {
                lVar.bmB.setVisibility(8);
            }
            lVar.fKR.setTag(null);
            lVar.fKR.setUserId(null);
            lVar.bQA.setText((CharSequence) null);
            lVar.fKX.getHeadView().setUserId(null);
            lVar.fKS.setIsHost(false);
            if (postData.yT() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yT().getUserId())) {
                    lVar.fKS.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.yT().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.yT().getTShowInfoNew();
                if (lVar.fKZ != null) {
                    lVar.fKZ.setTag(d.g.tag_user_id, postData.yT().getUserId());
                    lVar.fKZ.setOnClickListener(this.fJR.fHV.fUO);
                    lVar.fKZ.a(iconInfo, 2, this.fKD, this.fKD, this.fKB);
                }
                if (lVar.fKY != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.fKY.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.fKY.setOnClickListener(this.fJR.fHV.fUP);
                    lVar.fKY.a(tShowInfoNew, 3, this.fKD, this.fKD, this.fKB, true);
                }
                if (!com.baidu.tbadk.core.util.v.E(tShowInfoNew) || postData.yT().isBigV()) {
                    com.baidu.tbadk.core.util.aj.e(lVar.bQA, d.C0108d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.e(lVar.bQA, d.C0108d.cp_cont_f, 1);
                }
                String portrait = postData.yT().getPortrait();
                lVar.bQA.setTag(d.g.tag_user_id, postData.yT().getUserId());
                lVar.bQA.setTag(d.g.tag_user_name, postData.yT().getUserName());
                lVar.bQA.setTag(d.g.tag_virtual_user_url, postData.yT().getVirtualUserUrl());
                String name_show = postData.yT().getName_show();
                String userName = postData.yT().getUserName();
                if (com.baidu.tbadk.o.ac.nv() && name_show != null && !name_show.equals(userName)) {
                    lVar.bQA.setText(com.baidu.tieba.pb.c.ak(this.mContext, lVar.bQA.getText().toString()));
                    lVar.bQA.setGravity(16);
                    lVar.bQA.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYn());
                    com.baidu.tbadk.core.util.aj.e(lVar.bQA, d.C0108d.cp_other_e, 1);
                }
                if (postData.yT().getPendantData() != null && !StringUtils.isNull(postData.yT().getPendantData().xu())) {
                    UtilHelper.showHeadImageViewBigV(lVar.fKX.getHeadView(), postData.yT());
                    lVar.fKR.setVisibility(8);
                    lVar.fKX.setVisibility(0);
                    lVar.fKX.getHeadView().startLoad(portrait, 28, false);
                    lVar.fKX.getHeadView().setUserId(postData.yT().getUserId());
                    lVar.fKX.getHeadView().setUserName(postData.yT().getUserName());
                    lVar.fKX.eH(postData.yT().getPendantData().xu());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.fKR, postData.yT());
                    lVar.fKR.setUserId(postData.yT().getUserId());
                    lVar.fKR.ac(postData.yT().getUserName(), postData.bvV());
                    lVar.fKR.setTag(d.g.tag_virtual_user_url, postData.yT().getVirtualUserUrl());
                    lVar.fKR.setImageDrawable(null);
                    lVar.fKR.startLoad(portrait, 28, false);
                    lVar.fKR.setVisibility(0);
                    lVar.fKX.setVisibility(8);
                }
                if (postData.yT() != null) {
                    MetaData yT = postData.yT();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(yT.getUserId())) {
                        lVar.fKK.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fKK, d.f.icon_id_louzhu);
                        lVar.fKK.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (yT.getIs_bawu() == 1 && "manager".equals(yT.getBawu_type())) {
                        lVar.fKK.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fKK, d.f.icon_id_bazhu);
                        lVar.fKK.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (yT.getIs_bawu() == 1 && "assist".equals(yT.getBawu_type())) {
                        lVar.fKK.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fKK, d.f.icon_id_xiaobazhu);
                        lVar.fKK.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        lVar.fKK.setVisibility(8);
                        lVar.fKK.setTag(null);
                    }
                } else {
                    lVar.fKK.setVisibility(8);
                    lVar.fKK.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fJR.baY()) {
                if (postData.yT() != null) {
                    i2 = postData.yT().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.fKW.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.fKW, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.fKW.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.fKZ.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.fKZ.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.fKK.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.fKY.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.yT().getName_show();
            int hk = com.baidu.tbadk.util.w.hk(name_show2);
            if (!StringUtils.isNull(postData.yT().getSealPrefix())) {
                if (hk > i3 - 2) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (hk > i3) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.yT().getSealPrefix())) {
                lVar.bQA.setText(ae(postData.yT().getSealPrefix(), str));
            } else {
                lVar.bQA.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bvJ()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.yT() != null && !StringUtils.isNull(postData.yT().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fFs != null && this.fFs.aYX() != 0) {
                if (this.fFs.aYX() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.yT() != null) {
                    String userId = postData.yT().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fFs != null && this.fFs.aYL() != null && this.fFs.aYL().yT() != null && postData.yT() != null) {
                String userId2 = this.fFs.aYL().yT().getUserId();
                String userId3 = postData.yT().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.yT() != null && UtilHelper.isCurrentAccount(postData.yT().getUserId())) {
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
                    int i4 = 1;
                    if (postData.bvJ() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fFs.aYX()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yT().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yT() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yT().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.yT().getUserName());
                        }
                        if (this.fFs.aYL() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fFs.aYL().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fFs.aYX()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.fKQ.setTag(sparseArray);
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
            int i42 = 1;
            if (postData.bvJ() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.fKQ.setTag(sparseArray);
        }
    }

    private void e(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.fKP.a(postData.bvY(), postData.bvX(), false);
            lVar.fKP.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.bvJ() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bvJ()));
                lVar.fKV.setVisibility(0);
                lVar.fKV.setText(format);
                z = true;
            } else {
                lVar.fKV.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bvN = postData.bvN();
            boolean z2 = (bvN == null || StringUtils.isNull(bvN.getName())) ? false : true;
            if (z) {
                lVar.fKM.setVisibility(0);
                i = this.fKC;
            } else {
                lVar.fKM.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.fKN.setVisibility(0);
                i2 = this.fKC;
            } else {
                lVar.fKN.setVisibility(8);
                i2 = 0;
            }
            lVar.fKL.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.fKL.setText(com.baidu.tbadk.core.util.am.A(postData.getTime()));
            } else {
                lVar.fKL.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            }
            if (z2) {
                final String name = bvN.getName();
                final String lat = bvN.getLat();
                final String lng = bvN.getLng();
                lVar.fKO.setVisibility(0);
                lVar.fKO.setPadding(this.fKC, 0, 0, 0);
                lVar.fKO.setText(bvN.getName());
                lVar.fKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.oJ()) {
                                com.baidu.tbadk.browser.a.P(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.fJR.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            lVar.fKO.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fKS.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.fKS.setPadding(s, 0, s, 0);
            if (!this.fFq) {
                lVar.fKS.getLayoutStrategy().iQ(d.f.icon_click);
            } else {
                lVar.fKS.hs(null);
                lVar.fKS.setBackgroundDrawable(null);
                lVar.fKS.getLayoutStrategy().iQ(d.f.transparent_bg);
            }
            lVar.fKS.getLayoutStrategy().iN(d.f.pic_video);
            a(lVar.fKS, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.fKS.setLayoutParams(layoutParams);
            lVar.fKS.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
            lVar.fKS.setIsFromCDN(this.mIsFromCDN);
            lVar.fKS.a(postData.bvM(), true, this.fKE);
            SparseArray sparseArray = (SparseArray) lVar.fKS.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.fKS.setTag(sparseArray);
            lVar.fFF.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ao = (ao - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().iO(ao - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().iP((int) (ao * 1.618f));
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.bvO() > 0 && postData.bvG() != null && postData.bvG().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fKU.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                lVar.fKU.setLayoutParams(layoutParams);
                if (this.fFt == null) {
                    this.fFt = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fFt.setIsFromCDN(this.mIsFromCDN);
                    this.fFt.H(this.fFv);
                    String str = null;
                    if (this.fFs != null && this.fFs.aYL() != null && this.fFs.aYL().yT() != null) {
                        str = this.fFs.aYL().yT().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fFs != null) {
                        this.fFt.J(this.fFs.aYX(), z);
                        this.fFt.Q(this.fFs.aYL());
                    }
                }
                this.fFt.qC(postData.getId());
                lVar.fKU.setSubPbAdapter(this.fFt);
                lVar.fKU.setVisibility(0);
                lVar.fKU.a(postData, view);
                lVar.fKU.setChildOnClickListener(this.mCommonClickListener);
                lVar.fKU.setChildOnLongClickListener(this.bkf);
                lVar.fKU.setChildOnTouchListener(this.fKF);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fKU.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.fKU.setLayoutParams(layoutParams2);
                lVar.fKU.setVisibility(8);
            }
            if (postData.gZk) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(l lVar, PostData postData) {
        if (lVar != null && lVar.fLd != null && lVar.fLa != null) {
            if (postData == null || postData.gZn == null || StringUtils.isNull(postData.gZn.liveTitle)) {
                lVar.fLa.setVisibility(8);
                return;
            }
            lVar.fLd.setText(postData.gZn.liveTitle);
            lVar.fLa.setTag(postData.gZn);
            lVar.fLa.setVisibility(0);
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                akVar.aa("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.e(lVar.bQA, d.C0108d.cp_cont_f, 1);
                if (lVar.fKK.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(lVar.fKK, ((Integer) lVar.fKK.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.e(lVar.fKL, d.C0108d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.s(lVar.fKM, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.s(lVar.fKN, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(lVar.fKV, d.C0108d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.e(lVar.fKO, d.C0108d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.t(lVar.mBottomLine, d.C0108d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.fKQ, d.f.icon_floor_more_selector);
                lVar.fKS.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.t(lVar.fKU, d.C0108d.cp_bg_line_e);
                lVar.fKU.onChangeSkinType();
                lVar.fKT.onChangeSkinType();
                lVar.fKP.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(lVar.fLd, d.C0108d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.e(lVar.fLb, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.s(lVar.fLa, d.C0108d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.s(lVar.fLc, d.C0108d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(lVar.fLe, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.aj.r(lVar.fLg, d.C0108d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.r(lVar.fLi, d.C0108d.cp_cont_j);
                if (lVar.fLf.getVisibility() == 8) {
                    lVar.fLi.setText(d.j.close_content);
                    com.baidu.tbadk.core.util.aj.c(lVar.fLj, d.f.icon_arrow_gray_up);
                } else {
                    lVar.fLi.setText(d.j.expand_content);
                    com.baidu.tbadk.core.util.aj.c(lVar.fLj, d.f.icon_arrow_gray_down);
                }
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.fFF.setOnTouchListener(this.fKF);
        lVar.fFF.setOnLongClickListener(this.bkf);
        if (this.fJR.getPageContext() != null && this.fJR.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fJR.getPageContext().getOrignalPage()).fHV;
            lVar.bQA.setOnClickListener(aVar.fUN);
            lVar.fKR.setOnClickListener(aVar.fUN);
            lVar.fKX.setOnClickListener(aVar.fUN);
            lVar.fKX.getHeadView().setOnClickListener(aVar.fUN);
            lVar.fKS.setOnLongClickListener(this.bkf);
            lVar.fKS.setOnTouchListener(this.fKF);
            lVar.fKS.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.fKS.setOnImageClickListener(this.bJN);
            lVar.fKS.setOnImageTouchListener(this.fKF);
            lVar.fKS.setOnEmotionClickListener(aVar.fUQ);
            lVar.fKQ.setOnClickListener(this.mCommonClickListener);
            lVar.fKP.setOnClickListener(this.mCommonClickListener);
            lVar.fGk.setOnClickListener(this.mCommonClickListener);
            lVar.fLa.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fKE = cVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fFs = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jG(boolean z) {
        this.fFq = z;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fJR.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.fKS.setTextViewOnTouchListener(this.bJO);
        lVar.fKS.setTextViewCheckSelection(false);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFv = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJO = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkf = onLongClickListener;
    }
}
