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
    private boolean bJu;
    private TbRichTextView.h bJx;
    private com.baidu.tieba.pb.a.c bJy;
    private View.OnLongClickListener bjN;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dCL;
    private com.baidu.adp.lib.e.b<TbImageView> dCM;
    private View.OnClickListener fDA;
    private boolean fDv;
    protected com.baidu.tieba.pb.data.f fDx;
    private com.baidu.tieba.pb.pb.sub.d fDy;
    private int fIG;
    private int fIH;
    private int fII;
    private TbRichTextView.c fIJ;
    private com.baidu.tieba.pb.a.c fIK;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NoPressedLinearLayout noPressedLinearLayout) {
        PostData cp;
        if (noPressedLinearLayout.findViewById(d.g.view_floor_praise) != null && noPressedLinearLayout.findViewById(d.g.view_floor_praise).getTag(d.g.tag_clip_board) != null && this.mCommonClickListener != null) {
            View findViewById = noPressedLinearLayout.findViewById(d.g.view_floor_praise);
            if (!((PostData) findViewById.getTag(d.g.tag_clip_board)).bCA() && this.mCommonClickListener != null && this.fHW != null && (cp = this.fHW.cp(findViewById)) != null) {
                TiebaStatic.log(this.fHW.bah().s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_locate", 5).s("obj_id", cp.bCA() ? 0 : 1));
            }
        }
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fIG = 0;
        this.fIH = 0;
        this.fII = 0;
        this.fIJ = null;
        this.fDv = true;
        this.mHostId = null;
        this.fDx = null;
        this.fDA = null;
        this.mCommonClickListener = null;
        this.bJx = null;
        this.bJy = null;
        this.bjN = null;
        this.fDy = null;
        this.bJu = true;
        this.dCL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avp */
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
        this.dCM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ek */
            public TbImageView nk() {
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
        this.fIK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.fHW == null || k.this.fHW.bad() == null || k.this.fHW.bad().bdc())) {
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
                if (k.this.bJy != null) {
                    if (!(view instanceof TbListTextView) || k.this.mCommonClickListener == null) {
                        k.this.bJy.cm(view);
                        k.this.bJy.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bm */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        l lVar = new l(this.fHW.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        lVar.fIY.setConstrainLayoutPool(this.dCL);
        lVar.fIY.setImageViewPool(this.dCM);
        a(lVar);
        this.fIG = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds12);
        this.fIH = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds20);
        this.fII = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds36);
        if (lVar.fIX != null) {
            lVar.fIX.setDuiEnabled(this.bJu);
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
            postData2.zW();
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.bJu = z;
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
            lVar.fJl.setVisibility(0);
            lVar.fJk.setVisibility(8);
            lVar.fJn.setText(d.j.expand_content);
            com.baidu.tbadk.core.util.aj.c(lVar.fJo, d.f.icon_arrow_gray_down_n);
            return;
        }
        lVar.fJl.setVisibility(8);
        lVar.fJk.setVisibility(0);
        lVar.fJn.setText(d.j.close_content);
        com.baidu.tbadk.core.util.aj.c(lVar.fJo, d.f.icon_arrow_gray_up_n);
    }

    private void a(final l lVar, final PostData postData) {
        if (postData.bCC() == 2) {
            lVar.fJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.fJk.getVisibility() == 8;
                    k.this.a(lVar, !z);
                    postData.nu(z ? false : true);
                    k.this.b(lVar, postData);
                    if (k.this.fHW.bad() != null && k.this.fHW.bad().bdY() != null && k.this.fHW.bad().getListView() != null && !z && lVar.getView().getTop() < k.this.fHW.bad().bdY().getMeasuredHeight()) {
                        k.this.fHW.bad().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(k.this.fHW.bad().getListView().getData(), postData) + k.this.fHW.bad().getListView().getHeaderViewsCount(), k.this.fHW.bad().bdY().getMeasuredHeight());
                    }
                }
            });
            lVar.fJl.setClickable(true);
            lVar.fJl.setText(this.fDx.aYJ());
            lVar.fJm.setVisibility(0);
            a(lVar, postData.bCf());
            a(true, lVar, postData);
        } else {
            lVar.fJl.setVisibility(8);
            lVar.fJm.setVisibility(8);
            lVar.fJk.setVisibility(0);
            a(false, lVar, postData);
        }
        b(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        boolean z2 = !com.baidu.tbadk.core.util.v.G(postData.bCi());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fJm.getLayoutParams();
        if (z) {
            lVar.fIX.getLayoutStrategy().iY(0);
            if (z2) {
                lVar.fIX.getLayoutStrategy().iX(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds6);
                }
            } else {
                lVar.fIX.getLayoutStrategy().iX(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            lVar.fJm.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds22);
                lVar.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        lVar.fIX.getLayoutStrategy().iX(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
        lVar.fIX.getLayoutStrategy().iY(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
            lVar.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar, PostData postData) {
        TbRichText bCo = postData.bCo();
        bCo.isChanged = true;
        lVar.fIX.a(bCo, true, this.fIJ);
    }

    private void g(PostData postData) {
        if (postData.aNW == 0 && postData.hjm) {
            com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12203");
            akVar.ab("post_id", postData.getId());
            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ab("cuid", TbadkCoreApplication.getInst().getCuid());
            akVar.f("exposure_time", System.currentTimeMillis());
            TiebaStatic.log(akVar);
        }
    }

    private void c(l lVar, PostData postData) {
        if (postData == null || postData.bfu() == null) {
            lVar.fEp.setVisibility(8);
            return;
        }
        TbRichText bCo = postData.bCo();
        com.baidu.tieba.pb.view.g.a(postData.bfu(), lVar.fEp, false, false, bCo != null && StringUtils.isNull(bCo.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void d(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fDv) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fIX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.fIX.setLayoutParams(layoutParams);
            lVar.fIX.setPadding(0, 0, 0, 0);
            lVar.fIX.hj(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fIX.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            lVar.fIX.setLayoutParams(layoutParams2);
            lVar.fIX.hj(postData.getBimg_url());
        }
        lVar.fIX.setTextViewOnTouchListener(this.fIK);
        lVar.fIX.setTextViewCheckSelection(false);
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
            if (postData.hjr) {
                com.baidu.tbadk.core.util.aj.t(lVar.bmk, d.C0108d.cp_bg_line_c);
                lVar.bmk.setVisibility(0);
            } else {
                lVar.bmk.setVisibility(8);
            }
            lVar.fIW.setTag(null);
            lVar.fIW.setUserId(null);
            lVar.bQl.setText((CharSequence) null);
            lVar.fJc.getHeadView().setUserId(null);
            lVar.fIX.setIsHost(false);
            if (postData.yX() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.yX().getUserId())) {
                    lVar.fIX.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.yX().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.yX().getTShowInfoNew();
                if (lVar.fJe != null) {
                    lVar.fJe.setTag(d.g.tag_user_id, postData.yX().getUserId());
                    lVar.fJe.setOnClickListener(this.fHW.fGa.fST);
                    lVar.fJe.a(iconInfo, 2, this.fII, this.fII, this.fIG);
                }
                if (lVar.fJd != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.fJd.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    lVar.fJd.setOnClickListener(this.fHW.fGa.fSU);
                    lVar.fJd.a(tShowInfoNew, 3, this.fII, this.fII, this.fIG, true);
                }
                if (!com.baidu.tbadk.core.util.v.G(tShowInfoNew) || postData.yX().isBigV()) {
                    com.baidu.tbadk.core.util.aj.e(lVar.bQl, d.C0108d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aj.e(lVar.bQl, d.C0108d.cp_cont_f, 1);
                }
                String portrait = postData.yX().getPortrait();
                lVar.bQl.setTag(d.g.tag_user_id, postData.yX().getUserId());
                lVar.bQl.setTag(d.g.tag_user_name, postData.yX().getUserName());
                lVar.bQl.setTag(d.g.tag_virtual_user_url, postData.yX().getVirtualUserUrl());
                String name_show = postData.yX().getName_show();
                String userName = postData.yX().getUserName();
                if (com.baidu.tbadk.o.ac.nu() && name_show != null && !name_show.equals(userName)) {
                    lVar.bQl.setText(com.baidu.tieba.pb.c.am(this.mContext, lVar.bQl.getText().toString()));
                    lVar.bQl.setGravity(16);
                    lVar.bQl.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYc());
                    com.baidu.tbadk.core.util.aj.e(lVar.bQl, d.C0108d.cp_other_e, 1);
                }
                if (postData.yX().getPendantData() != null && !StringUtils.isNull(postData.yX().getPendantData().xu())) {
                    UtilHelper.showHeadImageViewBigV(lVar.fJc.getHeadView(), postData.yX());
                    lVar.fIW.setVisibility(8);
                    lVar.fJc.setVisibility(0);
                    lVar.fJc.getHeadView().startLoad(portrait, 28, false);
                    lVar.fJc.getHeadView().setUserId(postData.yX().getUserId());
                    lVar.fJc.getHeadView().setUserName(postData.yX().getUserName());
                    lVar.fJc.ez(postData.yX().getPendantData().xu());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.fIW, postData.yX());
                    lVar.fIW.setUserId(postData.yX().getUserId());
                    lVar.fIW.ad(postData.yX().getUserName(), postData.bCx());
                    lVar.fIW.setTag(d.g.tag_virtual_user_url, postData.yX().getVirtualUserUrl());
                    lVar.fIW.setImageDrawable(null);
                    lVar.fIW.startLoad(portrait, 28, false);
                    lVar.fIW.setVisibility(0);
                    lVar.fJc.setVisibility(8);
                }
                if (postData.yX() != null) {
                    MetaData yX = postData.yX();
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(yX.getUserId())) {
                        lVar.fIP.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fIP, d.f.icon_id_louzhu);
                        lVar.fIP.setTag(Integer.valueOf(d.f.icon_id_louzhu));
                    } else if (yX.getIs_bawu() == 1 && "manager".equals(yX.getBawu_type())) {
                        lVar.fIP.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fIP, d.f.icon_id_bazhu);
                        lVar.fIP.setTag(Integer.valueOf(d.f.icon_id_bazhu));
                    } else if (yX.getIs_bawu() == 1 && "assist".equals(yX.getBawu_type())) {
                        lVar.fIP.setVisibility(0);
                        com.baidu.tbadk.core.util.aj.c(lVar.fIP, d.f.icon_id_xiaobazhu);
                        lVar.fIP.setTag(Integer.valueOf(d.f.icon_id_xiaobazhu));
                    } else {
                        lVar.fIP.setVisibility(8);
                        lVar.fIP.setTag(null);
                    }
                } else {
                    lVar.fIP.setVisibility(8);
                    lVar.fIP.setTag(null);
                }
            }
            int i2 = 0;
            if (this.fHW.baP()) {
                if (postData.yX() != null) {
                    i2 = postData.yX().getLevel_id();
                }
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                lVar.fJb.setVisibility(0);
                com.baidu.tbadk.core.util.aj.c(lVar.fJb, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                lVar.fJb.setVisibility(8);
            }
            int i3 = 20;
            if (lVar.fJe.getChildCount() == 1) {
                i3 = 18;
            } else if (lVar.fJe.getChildCount() > 1) {
                i3 = 16;
            }
            if (lVar.fIP.getVisibility() == 0) {
                i3 -= 2;
            }
            if (lVar.fJd.getChildCount() > 0) {
                i3 -= 2;
            }
            String name_show2 = postData.yX().getName_show();
            int hb = com.baidu.tbadk.util.w.hb(name_show2);
            if (!StringUtils.isNull(postData.yX().getSealPrefix())) {
                if (hb > i3 - 2) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3 - 2) + "...";
                }
                str = name_show2;
            } else {
                if (hb > i3) {
                    str = com.baidu.tbadk.util.w.I(name_show2, i3) + "...";
                }
                str = name_show2;
            }
            if (!StringUtils.isNull(postData.yX().getSealPrefix())) {
                lVar.bQl.setText(af(postData.yX().getSealPrefix(), str));
            } else {
                lVar.bQl.setText(str);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.bCl()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z7 = false;
            if (postData.yX() != null && !StringUtils.isNull(postData.yX().getVirtualUserUrl())) {
                z7 = true;
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            if (this.fDx != null && this.fDx.aYN() != 0) {
                if (this.fDx.aYN() != 1002) {
                    z8 = true;
                }
                z9 = true;
                if (postData != null && postData.yX() != null) {
                    String userId = postData.yX().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z8 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z8 = false;
                    }
                }
            }
            if (this.fDx != null && this.fDx.aYA() != null && this.fDx.aYA().yX() != null && postData.yX() != null) {
                String userId2 = this.fDx.aYA().yX().getUserId();
                String userId3 = postData.yX().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z = true;
                    z2 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z2 = false;
                        z10 = true;
                    }
                    if (postData == null && postData.yX() != null && UtilHelper.isCurrentAccount(postData.yX().getUserId())) {
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
                    if (postData.bCl() == 1) {
                        i4 = 0;
                    }
                    if (!z8) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fDx.aYN()));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yX().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z5) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yX() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yX().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.yX().getUserName());
                        }
                        if (this.fDx.aYA() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fDx.aYA().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fDx.aYN()));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i4));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_should_delete_visible, false);
                    }
                    lVar.fIV.setTag(sparseArray);
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
            if (postData.bCl() == 1) {
            }
            if (!z8) {
            }
            if (!z5) {
            }
            if (!z6) {
            }
            lVar.fIV.setTag(sparseArray);
        }
    }

    private void e(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.fIU.a(postData.bCA(), postData.bCz(), false);
            lVar.fIU.setTag(d.g.tag_clip_board, postData);
        }
    }

    private void f(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.bCl() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.bCl()));
                lVar.fJa.setVisibility(0);
                lVar.fJa.setText(format);
                z = true;
            } else {
                lVar.fJa.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f bCp = postData.bCp();
            boolean z2 = (bCp == null || StringUtils.isNull(bCp.getName())) ? false : true;
            if (z) {
                lVar.fIR.setVisibility(0);
                i = this.fIH;
            } else {
                lVar.fIR.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.fIS.setVisibility(0);
                i2 = this.fIH;
            } else {
                lVar.fIS.setVisibility(8);
                i2 = 0;
            }
            lVar.fIQ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.fIQ.setText(com.baidu.tbadk.core.util.am.A(postData.getTime()));
            } else {
                lVar.fIQ.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            }
            if (z2) {
                final String name = bCp.getName();
                final String lat = bCp.getLat();
                final String lng = bCp.getLng();
                lVar.fIT.setVisibility(0);
                lVar.fIT.setPadding(this.fIH, 0, 0, 0);
                lVar.fIT.setText(bCp.getName());
                lVar.fIT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.oI()) {
                                com.baidu.tbadk.browser.a.R(k.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, k.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                k.this.fHW.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            lVar.fIT.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fIX.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds50);
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds154);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.fIX.setPadding(s, 0, s, 0);
            if (!this.fDv) {
                lVar.fIX.getLayoutStrategy().iU(d.f.icon_click);
            } else {
                lVar.fIX.hj(null);
                lVar.fIX.setBackgroundDrawable(null);
                lVar.fIX.getLayoutStrategy().iU(d.f.transparent_bg);
            }
            lVar.fIX.getLayoutStrategy().iR(d.f.pic_video);
            a(lVar.fIX, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.fIX.setLayoutParams(layoutParams);
            lVar.fIX.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
            lVar.fIX.setIsFromCDN(this.mIsFromCDN);
            lVar.fIX.a(postData.bCo(), true, this.fIJ);
            SparseArray sparseArray = (SparseArray) lVar.fIX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            lVar.fIX.setTag(sparseArray);
            lVar.fDK.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int ao = (((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                ao = (ao - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            tbRichTextView.getLayoutStrategy().iS(ao - (z ? getDimensionPixelSize(d.e.tbds90) : 0));
            tbRichTextView.getLayoutStrategy().iT((int) (ao * 1.618f));
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.bCq() > 0 && postData.bCi() != null && postData.bCi().size() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.fIZ.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds154);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44);
                layoutParams.bottomMargin = 0;
                lVar.fIZ.setLayoutParams(layoutParams);
                if (this.fDy == null) {
                    this.fDy = new com.baidu.tieba.pb.pb.sub.d(this.mContext);
                    this.fDy.setIsFromCDN(this.mIsFromCDN);
                    this.fDy.G(this.fDA);
                    String str = null;
                    if (this.fDx != null && this.fDx.aYA() != null && this.fDx.aYA().yX() != null) {
                        str = this.fDx.aYA().yX().getUserId();
                    }
                    boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                    if (this.fDx != null) {
                        this.fDy.J(this.fDx.aYN(), z);
                        this.fDy.Q(this.fDx.aYA());
                    }
                }
                this.fDy.qs(postData.getId());
                lVar.fIZ.setSubPbAdapter(this.fDy);
                lVar.fIZ.setVisibility(0);
                lVar.fIZ.a(postData, view);
                lVar.fIZ.setChildOnClickListener(this.mCommonClickListener);
                lVar.fIZ.setChildOnLongClickListener(this.bjN);
                lVar.fIZ.setChildOnTouchListener(this.fIK);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.fIZ.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
                lVar.fIZ.setLayoutParams(layoutParams2);
                lVar.fIZ.setVisibility(8);
            }
            if (postData.hjq) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void g(l lVar, PostData postData) {
        if (lVar != null && lVar.fJi != null && lVar.fJf != null) {
            if (postData == null || postData.hjt == null || StringUtils.isNull(postData.hjt.liveTitle)) {
                lVar.fJf.setVisibility(8);
                return;
            }
            lVar.fJi.setText(postData.hjt.liveTitle);
            lVar.fJf.setTag(postData.hjt);
            lVar.fJf.setVisibility(0);
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
                com.baidu.tbadk.core.util.aj.e(lVar.bQl, d.C0108d.cp_cont_f, 1);
                if (lVar.fIP.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.aj.c(lVar.fIP, ((Integer) lVar.fIP.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.aj.e(lVar.fIQ, d.C0108d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.s(lVar.fIR, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.s(lVar.fIS, d.C0108d.cp_cont_e);
                com.baidu.tbadk.core.util.aj.e(lVar.fJa, d.C0108d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.e(lVar.fIT, d.C0108d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.aj.t(lVar.mBottomLine, d.C0108d.cp_bg_line_c);
                com.baidu.tbadk.core.util.aj.c(lVar.fIV, d.f.icon_floor_more_selector);
                lVar.fIX.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_b));
                com.baidu.tbadk.core.util.aj.t(lVar.fIZ, d.C0108d.cp_bg_line_e);
                lVar.fIZ.onChangeSkinType();
                lVar.fIY.onChangeSkinType();
                lVar.fIU.onChangeSkinType();
                com.baidu.tbadk.core.util.aj.e(lVar.fJi, d.C0108d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.aj.e(lVar.fJg, d.C0108d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.aj.s(lVar.fJf, d.C0108d.cp_bg_line_e);
                com.baidu.tbadk.core.util.aj.s(lVar.fJh, d.C0108d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.c(lVar.fJj, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.aj.r(lVar.fJl, d.C0108d.cp_cont_d);
                com.baidu.tbadk.core.util.aj.r(lVar.fJn, d.C0108d.cp_cont_j);
                if (lVar.fJk.getVisibility() == 8) {
                    lVar.fJn.setText(d.j.close_content);
                    com.baidu.tbadk.core.util.aj.c(lVar.fJo, d.f.icon_arrow_gray_up);
                } else {
                    lVar.fJn.setText(d.j.expand_content);
                    com.baidu.tbadk.core.util.aj.c(lVar.fJo, d.f.icon_arrow_gray_down);
                }
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.fDK.setOnTouchListener(this.fIK);
        lVar.fDK.setOnLongClickListener(this.bjN);
        if (this.fHW.getPageContext() != null && this.fHW.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.a.a aVar = ((PbActivity) this.fHW.getPageContext().getOrignalPage()).fGa;
            lVar.bQl.setOnClickListener(aVar.fSS);
            lVar.fIW.setOnClickListener(aVar.fSS);
            lVar.fJc.setOnClickListener(aVar.fSS);
            lVar.fJc.getHeadView().setOnClickListener(aVar.fSS);
            lVar.fIX.setOnLongClickListener(this.bjN);
            lVar.fIX.setOnTouchListener(this.fIK);
            lVar.fIX.setCommonTextViewOnClickListener(this.mCommonClickListener);
            lVar.fIX.setOnImageClickListener(this.bJx);
            lVar.fIX.setOnImageTouchListener(this.fIK);
            lVar.fIX.setOnEmotionClickListener(aVar.fSV);
            lVar.fIV.setOnClickListener(this.mCommonClickListener);
            lVar.fIU.setOnClickListener(this.mCommonClickListener);
            lVar.fEp.setOnClickListener(this.mCommonClickListener);
            lVar.fJf.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.fIJ = cVar;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.fDx = fVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void jA(boolean z) {
        this.fDv = z;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fHW.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.fIX.setTextViewOnTouchListener(this.bJy);
        lVar.fIX.setTextViewCheckSelection(false);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fDA = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJx = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJy = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjN = onLongClickListener;
    }
}
