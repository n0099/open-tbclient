package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private int TBDS10;
    private TbRichTextView.h cAE;
    private boolean cDp;
    private com.baidu.tieba.pb.a.c ccb;
    private View.OnLongClickListener cdg;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdJ;
    private com.baidu.adp.lib.e.b<TbImageView> fdK;
    private int hlh;
    private int hli;
    private int hlj;
    protected com.baidu.tieba.pb.data.d hoZ;
    private TbRichTextView.c hpA;
    private com.baidu.tieba.pb.pb.sub.c hpB;
    private com.baidu.tieba.pb.a.c hpC;
    private boolean hpa;
    private View.OnClickListener hpj;
    private int hpy;
    private int hpz;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hpN != null && jVar.hpN.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxn = 5;
                dVar.bxp = 2;
                jVar.hpN.setStatisticData(dVar);
                jVar.hpN.aeb();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hlh = 0;
        this.hpy = 0;
        this.hli = 0;
        this.hpz = 0;
        this.hlj = 0;
        this.hpA = null;
        this.hpa = true;
        this.mHostId = null;
        this.hoZ = null;
        this.hpj = null;
        this.mCommonClickListener = null;
        this.cAE = null;
        this.ccb = null;
        this.cdg = null;
        this.hpB = null;
        this.cDp = true;
        this.fdJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beG */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(i.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.fdK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aeY */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.hpC = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hoK == null || i.this.hoK.bJn() == null || i.this.hoK.bJn().bMn())) {
                    if (view instanceof RelativeLayout) {
                        i.this.cq(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                i.this.cq((RelativeLayout) parent);
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
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                if (i.this.ccb != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.ccb.ci(view);
                        i.this.ccb.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    i.this.mCommonClickListener.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.hoK.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hpQ.setConstrainLayoutPool(this.fdJ);
        jVar.hpQ.setImageViewPool(this.fdK);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(d.e.tbds10);
        this.hlh = getDimensionPixelSize(d.e.tbds12);
        this.hpy = getDimensionPixelSize(d.e.tbds14);
        this.hli = getDimensionPixelSize(d.e.tbds16);
        this.hpz = getDimensionPixelSize(d.e.tbds36);
        this.hlj = getDimensionPixelSize(d.e.tbds40);
        if (jVar.hpP != null) {
            jVar.hpP.setDuiEnabled(this.cDp);
        }
        return jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, j jVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, jVar);
        a(jVar);
        b(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            h(postData2);
            i(postData2);
            postData2.ZS();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cDp = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.T(postData.cem())) {
            int i = 8;
            if (postData.iGG) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hoZ, postData, postData.locate, i, 6);
            postData.iGH = b;
            Iterator<PostData> it = postData.cem().iterator();
            while (it.hasNext()) {
                it.next().iGH = b;
            }
        }
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            b(jVar, postData, view, i);
            f(jVar, postData);
            a(jVar, postData, view);
            c(jVar, postData, view, i);
            g(jVar, postData);
            a(jVar, postData);
            h(jVar, postData);
            c(jVar, postData);
            e(jVar, postData);
            i(jVar, postData);
            b(jVar, postData);
        }
    }

    private void b(j jVar, PostData postData) {
        if (jVar != null && this.hoK != null && this.hoK.bIX() != null && this.hoK.bIX().bLD() && com.baidu.tbadk.core.util.ap.equals(this.hoK.bIX().bKN(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hpG, d.C0277d.cp_other_g);
        } else {
            jVar.hpG.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hqf.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hqh.setText(d.j.expand_content);
                return;
            } else {
                jVar.hqh.setText(str);
                return;
            }
        }
        jVar.hqf.setVisibility(0);
        jVar.hqh.setText(d.j.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.ceB() == 2 || postData.ceB() == 4) {
            jVar.hqg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hqf.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bIe());
                    postData.pV(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hoK.bJn() != null && i.this.hoK.bJn().bNl() != null && i.this.hoK.bJn().getListView() != null && !z && jVar.getView().getTop() < i.this.hoK.bJn().bNl().getMeasuredHeight()) {
                        i.this.hoK.bJn().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hoK.bJn().getListView().getData(), postData) + i.this.hoK.bJn().getListView().getHeaderViewsCount(), i.this.hoK.bJn().bNl().getMeasuredHeight());
                    }
                }
            });
            jVar.hqg.setVisibility(0);
            a(jVar, postData.cek(), postData.bIe());
            a(true, jVar, postData);
        } else {
            jVar.hqg.setVisibility(8);
            jVar.hqf.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hqg != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hqg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.T(postData.cem());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hqg.getLayoutParams();
            if (z) {
                jVar.hpP.getLayoutStrategy().kG(0);
                if (z2) {
                    jVar.hpP.getLayoutStrategy().kF(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                    }
                } else {
                    jVar.hpP.getLayoutStrategy().kF(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hqg.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hpP.getLayoutStrategy().kF(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
            jVar.hpP.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cer = postData.cer();
        cer.isChanged = true;
        jVar.hpP.setText(cer, true, this.hpA);
    }

    private void h(PostData postData) {
        if (postData.bCk == 0 && postData.ffX) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.bJ("post_id", postData.getId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.bJ("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.bJ("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.k("exposure_time", System.currentTimeMillis());
            if (this.hoK != null) {
                int bLw = this.hoK.bIX().bLw();
                if (1 == bLw || 2 == bLw) {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bLw) {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hoK.getUniqueId(), this.hoZ, postData, postData.locate, postData.iGG ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bOL() == null) {
            jVar.hpZ.setVisibility(8);
            return;
        }
        TbRichText cer = postData.cer();
        com.baidu.tieba.pb.view.b.a(postData.bOL(), jVar.hpZ, false, false, cer != null && StringUtils.isNull(cer.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpa) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpP.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hpP.setLayoutParams(layoutParams);
            jVar.hpP.setPadding(0, 0, 0, 0);
            jVar.hpP.qc(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hpP.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hpP.setLayoutParams(layoutParams2);
            jVar.hpP.qc(postData.getBimg_url());
        }
        jVar.hpP.setTextViewOnTouchListener(this.hpC);
        jVar.hpP.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0769  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(j jVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (jVar != null && postData != null) {
            if (postData.iGw) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, d.C0277d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hpO.setTag(null);
            jVar.hpO.setUserId(null);
            jVar.dYS.setText((CharSequence) null);
            jVar.hpW.getHeadView().setUserId(null);
            jVar.hpP.setIsHost(false);
            if (postData.YO() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.YO().getUserId())) {
                    jVar.hpP.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YO().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YO().getTShowInfoNew();
                if (jVar.hpY != null) {
                    jVar.hpY.setTag(d.g.tag_user_id, postData.YO().getUserId());
                    jVar.hpY.setOnClickListener(this.hoK.hmL.hzS);
                    jVar.hpY.a(iconInfo, 2, this.hlj, this.hlj, this.TBDS10);
                }
                if (jVar.hpX != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hpX.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hpX.setOnClickListener(this.hoK.hmL.hzT);
                    jVar.hpX.a(tShowInfoNew, 3, this.hlj, this.hlj, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.T(tShowInfoNew) || postData.YO().isBigV()) {
                    com.baidu.tbadk.core.util.al.d(jVar.dYS, d.C0277d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.d(jVar.dYS, d.C0277d.cp_cont_b, 1);
                }
                String portrait = postData.YO().getPortrait();
                int i2 = 8;
                if (postData.iGG) {
                    i2 = 2;
                }
                jVar.dYS.setTag(d.g.tag_user_id, postData.YO().getUserId());
                jVar.dYS.setTag(d.g.tag_user_name, postData.YO().getUserName());
                jVar.dYS.setTag(d.g.tag_virtual_user_url, postData.YO().getVirtualUserUrl());
                jVar.dYS.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hoZ, postData, postData.locate, i2, 2));
                String name_show = postData.YO().getName_show();
                String userName = postData.YO().getUserName();
                if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dYS.setText(com.baidu.tieba.pb.c.aP(this.mContext, jVar.dYS.getText().toString()));
                    jVar.dYS.setGravity(16);
                    jVar.dYS.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                    com.baidu.tbadk.core.util.al.d(jVar.dYS, d.C0277d.cp_other_e, 1);
                }
                if (postData.YO().getPendantData() != null && !StringUtils.isNull(postData.YO().getPendantData().Xk())) {
                    jVar.hpW.b(postData.YO());
                    jVar.hpO.setVisibility(8);
                    jVar.hpW.setVisibility(0);
                    jVar.hpW.getHeadView().startLoad(portrait, 28, false);
                    jVar.hpW.getHeadView().setUserId(postData.YO().getUserId());
                    jVar.hpW.getHeadView().setUserName(postData.YO().getUserName());
                    jVar.hpW.getHeadView().setFid(this.hoZ != null ? this.hoZ.getForumId() : "");
                    jVar.hpW.getHeadView().setTid(postData.getId());
                    jVar.hpW.getHeadView().setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hoZ, postData, postData.locate, i2, 2));
                    jVar.hpW.nn(postData.YO().getPendantData().Xk());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hpO, postData.YO());
                    jVar.hpO.setUserId(postData.YO().getUserId());
                    jVar.hpO.setFid(this.hoZ != null ? this.hoZ.getForumId() : "");
                    jVar.hpO.setTid(postData.getId());
                    jVar.hpO.setUserName(postData.YO().getUserName(), postData.cez());
                    jVar.hpO.setTag(d.g.tag_virtual_user_url, postData.YO().getVirtualUserUrl());
                    jVar.hpO.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hoZ, postData, postData.locate, i2, 2));
                    jVar.hpO.setImageDrawable(null);
                    jVar.hpO.startLoad(portrait, 28, false);
                    jVar.hpO.setVisibility(0);
                    jVar.hpW.setVisibility(8);
                }
                if (postData.YO() != null) {
                    MetaData YO = postData.YO();
                    int ht = postData.ceh() ? d.f.brand_official_btn : com.baidu.tbadk.core.util.al.ht(d.f.bg_user_identity_btn);
                    int ht2 = postData.ceh() ? d.C0277d.cp_btn_a : com.baidu.tbadk.core.util.al.ht(d.C0277d.cp_bg_line_d);
                    com.baidu.tbadk.core.util.al.k(jVar.hpI, ht);
                    com.baidu.tbadk.core.util.al.j(jVar.hpI, ht2);
                    jVar.hpI.setTag(Integer.valueOf(ht));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(YO.getUserId())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.host_name);
                    } else if (YO.getIs_bawu() == 1 && postData.ceh()) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.brand_Official);
                    } else if (YO.getIs_bawu() == 1 && "manager".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YO.getIs_bawu() == 1 && "assist".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YO.getIs_bawu() == 1 && "pri_content_assist".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_content_assist_tip);
                    } else if (YO.getIs_bawu() == 1 && "pri_manage_assist".equals(YO.getBawu_type())) {
                        jVar.hpI.setVisibility(0);
                        jVar.hpI.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hpI.setVisibility(8);
                        jVar.hpI.setTag(null);
                    }
                } else {
                    jVar.hpI.setVisibility(8);
                    jVar.hpI.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hoK.bIN()) {
                if (postData.YO() != null) {
                    i3 = postData.YO().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hpV.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hpV, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hpV.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hpY.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hpY.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hpI.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hpX.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aai() > 1000) {
                i4 -= 2;
            }
            if (postData.aai() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hpY.setVisibility(8);
                if (jVar.hpY.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hpY.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hpI.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hpI.setVisibility(8);
                }
                if (i4 < 10 && jVar.hpV.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hpV.setVisibility(8);
                }
            }
            String name_show2 = postData.YO() != null ? postData.YO().getName_show() : "";
            int pO = com.baidu.tbadk.util.ab.pO(name_show2);
            if (postData.YO() != null && !StringUtils.isNull(postData.YO().getSealPrefix())) {
                if (pO > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ah(name_show2, i4 - 2) + "...";
                }
            } else if (pO > i4) {
                name_show2 = com.baidu.tbadk.util.ab.ah(name_show2, i4) + "...";
            }
            if (postData.YO() != null && !StringUtils.isNull(postData.YO().getSealPrefix())) {
                jVar.dYS.setText(bN(postData.YO().getSealPrefix(), name_show2));
            } else {
                jVar.dYS.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cep()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.YO() != null && !StringUtils.isNull(postData.YO().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hoZ != null && this.hoZ.bIi() != 0) {
                if (this.hoZ.bIi() != 1002 && this.hoZ.bIi() != 3) {
                    z10 = true;
                }
                if (this.hoZ.bIi() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.YO() != null) {
                    String userId2 = postData.YO().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hoZ != null && this.hoZ.bHW() != null && this.hoZ.bHW().YO() != null && postData.YO() != null) {
                            userId = this.hoZ.bHW().YO().getUserId();
                            String userId3 = postData.YO().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.YO() != null && UtilHelper.isCurrentAccount(postData.YO().getUserId())) {
                                    z5 = true;
                                    z6 = true;
                                } else {
                                    boolean z14 = z12;
                                    z5 = z3;
                                    z6 = z14;
                                }
                                if (z9) {
                                    z = false;
                                    z8 = false;
                                    z7 = false;
                                } else {
                                    z7 = z4;
                                    z8 = z5;
                                }
                                int i5 = 1;
                                if (postData.cep() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(d.g.tag_should_manage_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoZ.bIi()));
                                    if (postData.YO() != null) {
                                        sparseArray.put(d.g.tag_forbid_user_name, postData.YO().getUserName());
                                        sparseArray.put(d.g.tag_forbid_user_name_show, postData.YO().getName_show());
                                        sparseArray.put(d.g.tag_forbid_user_portrait, postData.YO().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(d.g.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(d.g.tag_user_mute_visible, true);
                                    sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.YO() != null) {
                                        sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YO().getUserId());
                                        sparseArray.put(d.g.tag_user_mute_mute_username, postData.YO().getUserName());
                                        sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YO().getName_show());
                                    }
                                    if (this.hoZ.bHW() != null) {
                                        sparseArray.put(d.g.tag_user_mute_thread_id, this.hoZ.bHW().getId());
                                    }
                                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(d.g.tag_should_delete_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoZ.bIi()));
                                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_should_delete_visible, false);
                                }
                                jVar.hpP.setTag(sparseArray);
                            }
                        }
                        z3 = z2;
                        z4 = false;
                        if (postData == null) {
                        }
                        boolean z142 = z12;
                        z5 = z3;
                        z6 = z142;
                        if (z9) {
                        }
                        int i52 = 1;
                        if (postData.cep() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hpP.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hoZ != null) {
                userId = this.hoZ.bHW().YO().getUserId();
                String userId32 = postData.YO().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z3 = z2;
            z4 = false;
            if (postData == null) {
            }
            boolean z1422 = z12;
            z5 = z3;
            z6 = z1422;
            if (z9) {
            }
            int i522 = 1;
            if (postData.cep() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hpP.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.aaE() != null) {
            postData.aaE().threadId = this.hoK.bIX().bKO();
            postData.aaE().objType = 1;
            postData.aaE().isInPost = true;
            jVar.hpN.setData(postData.aaE());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cep() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.cep()));
                jVar.hpU.setVisibility(0);
                jVar.hpU.setText(format);
                z = true;
            } else {
                jVar.hpU.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f ces = postData.ces();
            boolean z2 = (ces == null || StringUtils.isNull(ces.getName())) ? false : true;
            if (z) {
                jVar.hpK.setVisibility(0);
                i = this.hpy;
            } else {
                jVar.hpK.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hpL.setVisibility(0);
                i2 = this.hpy;
            } else {
                jVar.hpL.setVisibility(8);
                i2 = 0;
            }
            jVar.hpJ.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hpJ.setText(com.baidu.tbadk.core.util.ap.aq(postData.getTime()));
            } else {
                jVar.hpJ.setText(com.baidu.tbadk.core.util.ap.ao(postData.getTime()));
            }
            if (z2) {
                jVar.hpM.setVisibility(0);
                jVar.hpM.setPadding(this.hpy, 0, 0, 0);
                if (postData.iGE) {
                    jVar.hpM.setText(com.baidu.tbadk.core.util.ap.f(ces.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hpM.setText(ces.getName());
                    return;
                }
            }
            jVar.hpM.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpP.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hpP.setPadding(0, 0, 0, 0);
            if (!this.hpa) {
                jVar.hpP.getLayoutStrategy().kA(d.f.icon_click);
            } else {
                jVar.hpP.qc(null);
                jVar.hpP.setBackgroundDrawable(null);
                jVar.hpP.getLayoutStrategy().kA(d.f.transparent_bg);
            }
            jVar.hpP.getLayoutStrategy().kx(d.f.pic_video);
            a(jVar.hpP, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hpP.setLayoutParams(layoutParams);
            jVar.hpP.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            jVar.hpP.setIsFromCDN(this.mIsFromCDN);
            TbRichText cer = postData.cer();
            jVar.hpP.setIsUseGridImage(postData.ceC());
            jVar.hpP.setText(cer, true, this.hpA);
            SparseArray sparseArray = (SparseArray) jVar.hpP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.hpP.setTag(sparseArray);
            jVar.hpG.setTag(d.g.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                aO = (aO - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(d.e.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().ky(aO - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cCq = (aO - dimensionPixelSize) - getDimensionPixelSize(d.e.tbds122);
            tbRichTextView.getLayoutStrategy().kz((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cet() > 0) {
                jVar.hpT.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hpT.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hpT.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_load_sub_data, postData);
                if (postData.ceB() == 2) {
                    jVar.hpT.setVisibility(8);
                } else {
                    jVar.hpT.setVisibility(0);
                }
                jVar.hpS.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cet() > 0) {
                    jVar.hpS.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.sub_pb_load_more, Integer.valueOf(postData.cet())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hpS.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hpS.setTag(sparseArray2);
                    }
                    sparseArray2.put(d.g.tag_load_sub_data, postData);
                    jVar.hpS.setVisibility(0);
                    jVar.hpT.setVisibility(8);
                    jVar.hpR.setVisibility(8);
                }
            } else {
                jVar.hpS.setVisibility(8);
                if (postData.cet() > 0 && postData.cem() != null && postData.cem().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpR.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hpR.setLayoutParams(layoutParams);
                    if (this.hpB == null) {
                        this.hpB = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hpB.setIsFromCDN(this.mIsFromCDN);
                        this.hpB.setOnLongClickListener(this.cdg);
                        this.hpB.M(this.hpj);
                        this.hpB.t(this.mCommonClickListener);
                        String str = null;
                        if (this.hoZ != null && this.hoZ.bHW() != null && this.hoZ.bHW().YO() != null) {
                            str = this.hoZ.bHW().YO().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hoZ != null) {
                            this.hpB.H(this.hoZ.bIi(), z);
                            this.hpB.ai(this.hoZ.bHW());
                        }
                    }
                    this.hpB.Al(postData.getId());
                    jVar.hpR.setSubPbAdapter(this.hpB);
                    jVar.hpR.setVisibility(0);
                    jVar.hpR.setData(postData, view);
                    jVar.hpR.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hpR.setChildOnLongClickListener(this.cdg);
                    jVar.hpR.setChildOnTouchListener(this.hpC);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hpR.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hpR.setLayoutParams(layoutParams2);
                    jVar.hpR.setVisibility(8);
                }
            }
            if (postData.iGv) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hqd != null && jVar.hqa != null) {
            if (postData == null || postData.iGy == null || StringUtils.isNull(postData.iGy.liveTitle)) {
                jVar.hqa.setVisibility(8);
                return;
            }
            jVar.hqd.setText(postData.iGy.liveTitle);
            jVar.hqa.setTag(postData.iGy);
            jVar.hqa.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hqi.setVisibility(postData.iGE ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.d(jVar.dYS, d.C0277d.cp_cont_b, 1);
                if (jVar.hpI.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hpI, ((Integer) jVar.hpI.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.d(jVar.hpJ, d.C0277d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hpK, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hpL, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.d(jVar.hpU, d.C0277d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hpM, d.C0277d.cp_cont_d, 1);
                jVar.hpP.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hpR, d.C0277d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hpS, d.C0277d.cp_cont_c);
                jVar.hpS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hpT, d.C0277d.cp_cont_c);
                jVar.hpR.onChangeSkinType();
                jVar.hpQ.onChangeSkinType();
                com.baidu.tbadk.core.util.al.d(jVar.hqd, d.C0277d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hqb, d.C0277d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hqa, d.C0277d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hqc, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hqe, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hqh, d.C0277d.cp_cont_c);
                if (jVar.hqf.getVisibility() == 8) {
                    jVar.hqh.setText(d.j.close_content);
                } else if (this.hoZ != null && StringUtils.isNull(this.hoZ.bIe())) {
                    jVar.hqh.setText(this.hoZ.bIe());
                } else {
                    jVar.hqh.setText(d.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hpG.setOnTouchListener(this.hpC);
        jVar.hpG.setOnLongClickListener(this.cdg);
        if (this.hoK.getPageContext() != null && this.hoK.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hoK.getPageContext().getOrignalPage()).hmL;
            jVar.dYS.setOnClickListener(aVar.fzX);
            jVar.hpO.setOnClickListener(aVar.fzX);
            jVar.hpW.setOnClickListener(aVar.fzX);
            jVar.hpW.getHeadView().setOnClickListener(aVar.fzX);
            jVar.hpP.setOnLongClickListener(this.cdg);
            jVar.hpP.setOnTouchListener(this.hpC);
            jVar.hpP.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hpP.setOnImageClickListener(this.cAE);
            jVar.hpP.setOnImageTouchListener(this.hpC);
            jVar.hpP.setOnEmotionClickListener(aVar.hzU);
            jVar.hpP.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hpZ.setOnClickListener(this.mCommonClickListener);
            jVar.hqa.setOnClickListener(this.mCommonClickListener);
            jVar.hpS.setOnClickListener(this.mCommonClickListener);
            jVar.hpT.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hpA = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hoZ = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nc(boolean z) {
        this.hpa = z;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hoK.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hpP.setTextViewOnTouchListener(this.ccb);
        jVar.hpP.setTextViewCheckSelection(false);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpj = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ccb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdg = onLongClickListener;
    }
}
