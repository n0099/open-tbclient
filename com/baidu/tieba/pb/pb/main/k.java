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
    private boolean bJC;
    private TbRichTextView.h bJF;
    private com.baidu.tieba.pb.a.c bJG;
    private View.OnLongClickListener bjX;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHm;
    private com.baidu.adp.lib.e.b<TbImageView> dHn;
    private boolean fEV;
    protected com.baidu.tieba.pb.data.f fEX;
    private com.baidu.tieba.pb.pb.sub.d fEY;
    private View.OnClickListener fFa;
    private int fKg;
    private int fKh;
    private int fKi;
    private TbRichTextView.c fKj;
    private com.baidu.tieba.pb.a.c fKk;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData cr;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bvW() && this.mCommonClickListener != null && this.fJw != null && (cr = this.fJw.cr(findViewById)) != null) {
                TiebaStatic.log(this.fJw.bal().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 5).s("obj_id", cr.bvW() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fKg = 0;
        this.fKh = 0;
        this.fKi = 0;
        this.fKj = null;
        this.fEV = true;
        this.mHostId = null;
        this.fEX = null;
        this.fFa = null;
        this.mCommonClickListener = null;
        this.bJF = null;
        this.bJG = null;
        this.bjX = null;
        this.fEY = null;
        this.bJC = true;
        this.dHm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aws */
            public com.baidu.tbadk.widget.layout.b nk() {
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
        this.dHn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Eb */
            public TbImageView nk() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.common_color_10043));
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
        this.fKk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.fJw == null || k.this.fJw.bah() == null || k.this.fJw.bah().bdg())) {
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
                if (k.this.bJG != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.bJG.co(view);
                        k.this.bJG.onSingleTapConfirmed(motionEvent);
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
        l lVar = new l(this.fJw.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.fKy.setConstrainLayoutPool(this.dHm);
        lVar.fKy.setImageViewPool(this.dHn);
        a(lVar);
        this.fKg = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds12);
        this.fKh = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds20);
        this.fKi = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds36);
        if (lVar.fKx != null) {
            lVar.fKx.setDuiEnabled(this.bJC);
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
            postData2.zO();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bJC = z;
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
            lVar.fKL.setVisibility(0);
            lVar.fKK.setVisibility(8);
            lVar.fKN.setText(d.j.expand_content);
            com.baidu.tbadk.core.util.aj.c(lVar.fKO, d.f.icon_arrow_gray_down_n);
            return;
        }
        lVar.fKL.setVisibility(8);
        lVar.fKK.setVisibility(0);
        lVar.fKN.setText(d.j.close_content);
        com.baidu.tbadk.core.util.aj.c(lVar.fKO, d.f.icon_arrow_gray_up_n);
    }

    private void a(final l lVar, final PostData postData) {
        if (postData.bvY() == 2) {
            lVar.fKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.fKK.getVisibility() == 8;
                    k.this.a(lVar, !z);
                    postData.mw(z ? false : true);
                    k.this.b(lVar, postData);
                    if (k.this.fJw.bah() != null && k.this.fJw.bah().bec() != null && k.this.fJw.bah().getListView() != null && !z && lVar.getView().getTop() < k.this.fJw.bah().bec().getMeasuredHeight()) {
                        k.this.fJw.bah().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(k.this.fJw.bah().getListView().getData(), postData) + k.this.fJw.bah().getListView().getHeaderViewsCount(), k.this.fJw.bah().bec().getMeasuredHeight());
                    }
                }
            });
            lVar.fKL.setClickable(true);
            lVar.fKL.setText(this.fEX.aYO());
            lVar.fKM.setVisibility(0);
            a(lVar, postData.bvB());
            a(true, lVar, postData);
        } else {
            lVar.fKL.setVisibility(8);
            lVar.fKM.setVisibility(8);
            lVar.fKK.setVisibility(0);
            a(false, lVar, postData);
        }
        b(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.E(postData.bvE());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fKM.getLayoutParams();
        if (z) {
            lVar.fKx.getLayoutStrategy().iU(0);
            if (z2) {
                lVar.fKx.getLayoutStrategy().iT(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds6);
                }
            } else {
                lVar.fKx.getLayoutStrategy().iT(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            lVar.fKM.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds22);
                lVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        lVar.fKx.getLayoutStrategy().iT(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        lVar.fKx.getLayoutStrategy().iU(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
            lVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar, PostData postData) {
        TbRichText bvK = postData.bvK();
        bvK.isChanged = true;
        lVar.fKx.a(bvK, true, this.fKj);
    }

    private void g(PostData postData) {
        if (postData.aNS == 0 && postData.gYM) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ab("post_id", postData.getId());
            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ab("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void c(l lVar, PostData postData) {
        if (postData == null || postData.bfv() == null) {
            lVar.fFP.setVisibility(8);
            return;
        }
        TbRichText bvK = postData.bvK();
        com.baidu.tieba.pb.view.g.a(postData.bfv(), lVar.fFP, false, false, bvK != null && StringUtils.isNull(bvK.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fEV) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fKx.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.fKx.setLayoutParams(layoutParams);
            lVar.fKx.setPadding(0, 0, 0, 0);
            lVar.fKx.hk(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fKx.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.fKx.setLayoutParams(layoutParams2);
            lVar.fKx.hk(postData.getBimg_url());
        }
        lVar.fKx.setTextViewOnTouchListener(this.fKk);
        lVar.fKx.setTextViewCheckSelection(false);
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
            if (postData.gYR) {
                com.baidu.tbadk.core.util.aj.t(lVar.bmt, d.C0107d.cp_bg_line_c);
                lVar.bmt.setVisibility(0);
            } else {
                lVar.bmt.setVisibility(8);
            }
            lVar.fKw.setTag(null);
            lVar.fKw.setUserId(null);
            lVar.bQs.setText((CharSequence) null);
            lVar.fKC.getHeadView().setUserId(null);
            lVar.fKx.setIsHost(false);
            if (postData.yS() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yS().getUserId())) {
                    lVar.fKx.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.yS().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.yS().getTShowInfoNew();
                if (lVar.fKE != null) {
                    lVar.fKE.setTag(d.g.tag_user_id, postData.yS().getUserId());
                    lVar.fKE.setOnClickListener(this.fJw.fHA.fUt);
                    lVar.fKE.a(iconInfo, 2, this.fKi, this.fKi, this.fKg);
                }
                if (lVar.fKD != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.fKD.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.fKD.setOnClickListener(this.fJw.fHA.fUu);
                    lVar.fKD.a(tShowInfoNew, 3, this.fKi, this.fKi, this.fKg, true);
                }
                if (!com.baidu.tbadk.core.util.v.E(tShowInfoNew) || postData.yS().isBigV()) {
                    com.baidu.tbadk.core.util.aj.e(lVar.bQs, d.C0107d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.e(lVar.bQs, d.C0107d.cp_cont_f, 1);
                }
                String portrait = postData.yS().getPortrait();
                lVar.bQs.setTag(d.g.tag_user_id, postData.yS().getUserId());
                lVar.bQs.setTag(d.g.tag_user_name, postData.yS().getUserName());
                lVar.bQs.setTag(d.g.tag_virtual_user_url, postData.yS().getVirtualUserUrl());
                String name_show = postData.yS().getName_show();
                String userName = postData.yS().getUserName();
                if (com.baidu.tbadk.o.ac.nu() && name_show != null && !name_show.equals(userName)) {
                    lVar.bQs.setText(com.baidu.tieba.pb.c.al(this.mContext, lVar.bQs.getText().toString()));
                    lVar.bQs.setGravity(16);
                    lVar.bQs.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYi());
                    com.baidu.tbadk.core.util.aj.e(lVar.bQs, d.C0107d.cp_other_e, 1);
                }
                if (postData.yS().getPendantData() != null && !StringUtils.isNull(postData.yS().getPendantData().xt())) {
                    UtilHelper.showHeadImageViewBigV(lVar.fKC.getHeadView(), postData.yS());
                    lVar.fKw.setVisibility(8);
                    lVar.fKC.setVisibility(0);
                    lVar.fKC.getHeadView().startLoad(portrait, 28, false);
                    lVar.fKC.getHeadView().setUserId(postData.yS().getUserId());
                    lVar.fKC.getHeadView().setUserName(postData.yS().getUserName());
                    lVar.fKC.ez(postData.yS().getPendantData().xt());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.fKw, postData.yS());
                    lVar.fKw.setUserId(postData.yS().getUserId());
                    lVar.fKw.ad(postData.yS().getUserName(), postData.bvT());
                    lVar.fKw.setTag(d.g.tag_virtual_user_url, postData.yS().getVirtualUserUrl());
                    lVar.fKw.setImageDrawable(null);
                    lVar.fKw.startLoad(portrait, 28, false);
                    lVar.fKw.setVisibility(0);
                    lVar.fKC.setVisibility(8);
                }
                if (postData.yS() != null) {
                    MetaData yS = postData.yS();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(yS.getUserId())) {
                        lVar.fKp.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fKp, d.f.icon_id_louzhu);
                        lVar.fKp.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (yS.getIs_bawu() == 1 && "manager".equals(yS.getBawu_type())) {
                        lVar.fKp.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fKp, d.f.icon_id_bazhu);
                        lVar.fKp.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (yS.getIs_bawu() == 1 && "assist".equals(yS.getBawu_type())) {
                        lVar.fKp.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fKp, d.f.icon_id_xiaobazhu);
                        lVar.fKp.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        lVar.fKp.setVisibility(8);
                        lVar.fKp.setTag(null);
                    }
                } else {
                    lVar.fKp.setVisibility(8);
                    lVar.fKp.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fJw.baT()) {
                if (postData.yS() != null) {
                    i2 = postData.yS().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.fKB.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.fKB, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.fKB.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.fKE.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.fKE.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.fKp.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.fKD.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.yS().getName_show();
            int hc = com.baidu.tbadk.util.w.hc(name_show2);
            if (!StringUtils.isNull(postData.yS().getSealPrefix())) {
                if (hc > i3 - 2) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (hc > i3) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.yS().getSealPrefix())) {
                lVar.bQs.setText(af(postData.yS().getSealPrefix(), str));
            } else {
                lVar.bQs.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bvH()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.yS() != null && !StringUtils.isNull(postData.yS().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fEX != null && this.fEX.aYS() != 0) {
                if (this.fEX.aYS() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.yS() != null) {
                    String userId = postData.yS().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fEX != null && this.fEX.aYG() != null && this.fEX.aYG().yS() != null && postData.yS() != null) {
                String userId2 = this.fEX.aYG().yS().getUserId();
                String userId3 = postData.yS().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.yS() != null && UtilHelper.isCurrentAccount(postData.yS().getUserId())) {
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
                    if (postData.bvH() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fEX.aYS()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yS().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yS() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yS().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.yS().getUserName());
                        }
                        if (this.fEX.aYG() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fEX.aYG().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fEX.aYS()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.fKv.setTag(sparseArray);
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
            if (postData.bvH() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.fKv.setTag(sparseArray);
        }
    }

    private void e(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.fKu.a(postData.bvW(), postData.bvV(), false);
            lVar.fKu.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.bvH() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bvH()));
                lVar.fKA.setVisibility(0);
                lVar.fKA.setText(format);
                z = true;
            } else {
                lVar.fKA.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bvL = postData.bvL();
            boolean z2 = (bvL == null || StringUtils.isNull(bvL.getName())) ? false : true;
            if (z) {
                lVar.fKr.setVisibility(0);
                i = this.fKh;
            } else {
                lVar.fKr.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.fKs.setVisibility(0);
                i2 = this.fKh;
            } else {
                lVar.fKs.setVisibility(8);
                i2 = 0;
            }
            lVar.fKq.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.fKq.setText(com.baidu.tbadk.core.util.am.A(postData.getTime()));
            } else {
                lVar.fKq.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            }
            if (z2) {
                final String name = bvL.getName();
                final String lat = bvL.getLat();
                final String lng = bvL.getLng();
                lVar.fKt.setVisibility(0);
                lVar.fKt.setPadding(this.fKh, 0, 0, 0);
                lVar.fKt.setText(bvL.getName());
                lVar.fKt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.oI()) {
                                com.baidu.tbadk.browser.a.Q(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.fJw.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            lVar.fKt.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fKx.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.fKx.setPadding(s, 0, s, 0);
            if (!this.fEV) {
                lVar.fKx.getLayoutStrategy().iQ(d.f.icon_click);
            } else {
                lVar.fKx.hk(null);
                lVar.fKx.setBackgroundDrawable(null);
                lVar.fKx.getLayoutStrategy().iQ(d.f.transparent_bg);
            }
            lVar.fKx.getLayoutStrategy().iN(d.f.pic_video);
            a(lVar.fKx, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.fKx.setLayoutParams(layoutParams);
            lVar.fKx.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_link_tip_c));
            lVar.fKx.setIsFromCDN(this.mIsFromCDN);
            lVar.fKx.a(postData.bvK(), true, this.fKj);
            SparseArray sparseArray = (SparseArray) lVar.fKx.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.fKx.setTag(sparseArray);
            lVar.fFk.setTag(d.g.tag_from, sparseArray);
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
            if (postData.bvM() > 0 && postData.bvE() != null && postData.bvE().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fKz.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                lVar.fKz.setLayoutParams(layoutParams);
                if (this.fEY == null) {
                    this.fEY = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fEY.setIsFromCDN(this.mIsFromCDN);
                    this.fEY.H(this.fFa);
                    String str = null;
                    if (this.fEX != null && this.fEX.aYG() != null && this.fEX.aYG().yS() != null) {
                        str = this.fEX.aYG().yS().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fEX != null) {
                        this.fEY.J(this.fEX.aYS(), z);
                        this.fEY.Q(this.fEX.aYG());
                    }
                }
                this.fEY.qu(postData.getId());
                lVar.fKz.setSubPbAdapter(this.fEY);
                lVar.fKz.setVisibility(0);
                lVar.fKz.a(postData, view);
                lVar.fKz.setChildOnClickListener(this.mCommonClickListener);
                lVar.fKz.setChildOnLongClickListener(this.bjX);
                lVar.fKz.setChildOnTouchListener(this.fKk);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fKz.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.fKz.setLayoutParams(layoutParams2);
                lVar.fKz.setVisibility(8);
            }
            if (postData.gYQ) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(l lVar, PostData postData) {
        if (lVar != null && lVar.fKI != null && lVar.fKF != null) {
            if (postData == null || postData.gYT == null || StringUtils.isNull(postData.gYT.liveTitle)) {
                lVar.fKF.setVisibility(8);
                return;
            }
            lVar.fKI.setText(postData.gYT.liveTitle);
            lVar.fKF.setTag(postData.gYT);
            lVar.fKF.setVisibility(0);
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(akVar);
        }
    }

    private void a(l lVar) {
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.aj.e(lVar.bQs, d.C0107d.cp_cont_f, 1);
                if (lVar.fKp.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(lVar.fKp, ((Integer) lVar.fKp.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.e(lVar.fKq, d.C0107d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.s(lVar.fKr, d.C0107d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.s(lVar.fKs, d.C0107d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(lVar.fKA, d.C0107d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.e(lVar.fKt, d.C0107d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.t(lVar.mBottomLine, d.C0107d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.fKv, d.f.icon_floor_more_selector);
                lVar.fKx.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.t(lVar.fKz, d.C0107d.cp_bg_line_e);
                lVar.fKz.onChangeSkinType();
                lVar.fKy.onChangeSkinType();
                lVar.fKu.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(lVar.fKI, d.C0107d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.e(lVar.fKG, d.C0107d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.s(lVar.fKF, d.C0107d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.s(lVar.fKH, d.C0107d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(lVar.fKJ, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.aj.r(lVar.fKL, d.C0107d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.r(lVar.fKN, d.C0107d.cp_cont_j);
                if (lVar.fKK.getVisibility() == 8) {
                    lVar.fKN.setText(d.j.close_content);
                    com.baidu.tbadk.core.util.aj.c(lVar.fKO, d.f.icon_arrow_gray_up);
                } else {
                    lVar.fKN.setText(d.j.expand_content);
                    com.baidu.tbadk.core.util.aj.c(lVar.fKO, d.f.icon_arrow_gray_down);
                }
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.fFk.setOnTouchListener(this.fKk);
        lVar.fFk.setOnLongClickListener(this.bjX);
        if (this.fJw.getPageContext() != null && this.fJw.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fJw.getPageContext().getOrignalPage()).fHA;
            lVar.bQs.setOnClickListener(aVar.fUs);
            lVar.fKw.setOnClickListener(aVar.fUs);
            lVar.fKC.setOnClickListener(aVar.fUs);
            lVar.fKC.getHeadView().setOnClickListener(aVar.fUs);
            lVar.fKx.setOnLongClickListener(this.bjX);
            lVar.fKx.setOnTouchListener(this.fKk);
            lVar.fKx.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.fKx.setOnImageClickListener(this.bJF);
            lVar.fKx.setOnImageTouchListener(this.fKk);
            lVar.fKx.setOnEmotionClickListener(aVar.fUv);
            lVar.fKv.setOnClickListener(this.mCommonClickListener);
            lVar.fKu.setOnClickListener(this.mCommonClickListener);
            lVar.fFP.setOnClickListener(this.mCommonClickListener);
            lVar.fKF.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fKj = cVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fEX = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jD(boolean z) {
        this.fEV = z;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fJw.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.fKx.setTextViewOnTouchListener(this.bJG);
        lVar.fKx.setTextViewCheckSelection(false);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFa = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJF = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjX = onLongClickListener;
    }
}
