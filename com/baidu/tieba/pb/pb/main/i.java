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
    private TbRichTextView.h cAD;
    private boolean cDo;
    private com.baidu.tieba.pb.a.c cca;
    private View.OnLongClickListener cdf;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdJ;
    private com.baidu.adp.lib.e.b<TbImageView> fdK;
    private int hlg;
    private int hlh;
    private int hli;
    protected com.baidu.tieba.pb.data.d hoY;
    private boolean hoZ;
    private com.baidu.tieba.pb.pb.sub.c hpA;
    private com.baidu.tieba.pb.a.c hpB;
    private View.OnClickListener hpi;
    private int hpx;
    private int hpy;
    private TbRichTextView.c hpz;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hpM != null && jVar.hpM.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxm = 5;
                dVar.bxo = 2;
                jVar.hpM.setStatisticData(dVar);
                jVar.hpM.aeb();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hlg = 0;
        this.hpx = 0;
        this.hlh = 0;
        this.hpy = 0;
        this.hli = 0;
        this.hpz = null;
        this.hoZ = true;
        this.mHostId = null;
        this.hoY = null;
        this.hpi = null;
        this.mCommonClickListener = null;
        this.cAD = null;
        this.cca = null;
        this.cdf = null;
        this.hpA = null;
        this.cDo = true;
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
        this.hpB = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hoJ == null || i.this.hoJ.bJn() == null || i.this.hoJ.bJn().bMn())) {
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
                if (i.this.cca != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.cca.ci(view);
                        i.this.cca.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.hoJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hpP.setConstrainLayoutPool(this.fdJ);
        jVar.hpP.setImageViewPool(this.fdK);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(d.e.tbds10);
        this.hlg = getDimensionPixelSize(d.e.tbds12);
        this.hpx = getDimensionPixelSize(d.e.tbds14);
        this.hlh = getDimensionPixelSize(d.e.tbds16);
        this.hpy = getDimensionPixelSize(d.e.tbds36);
        this.hli = getDimensionPixelSize(d.e.tbds40);
        if (jVar.hpO != null) {
            jVar.hpO.setDuiEnabled(this.cDo);
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
        this.cDo = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.T(postData.cem())) {
            int i = 8;
            if (postData.iGF) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hoY, postData, postData.locate, i, 6);
            postData.iGG = b;
            Iterator<PostData> it = postData.cem().iterator();
            while (it.hasNext()) {
                it.next().iGG = b;
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
        if (jVar != null && this.hoJ != null && this.hoJ.bIX() != null && this.hoJ.bIX().bLD() && com.baidu.tbadk.core.util.ap.equals(this.hoJ.bIX().bKN(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hpF, d.C0277d.cp_other_g);
        } else {
            jVar.hpF.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hqe.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hqg.setText(d.j.expand_content);
                return;
            } else {
                jVar.hqg.setText(str);
                return;
            }
        }
        jVar.hqe.setVisibility(0);
        jVar.hqg.setText(d.j.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.ceB() == 2 || postData.ceB() == 4) {
            jVar.hqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hqe.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bIe());
                    postData.pV(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hoJ.bJn() != null && i.this.hoJ.bJn().bNl() != null && i.this.hoJ.bJn().getListView() != null && !z && jVar.getView().getTop() < i.this.hoJ.bJn().bNl().getMeasuredHeight()) {
                        i.this.hoJ.bJn().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hoJ.bJn().getListView().getData(), postData) + i.this.hoJ.bJn().getListView().getHeaderViewsCount(), i.this.hoJ.bJn().bNl().getMeasuredHeight());
                    }
                }
            });
            jVar.hqf.setVisibility(0);
            a(jVar, postData.cek(), postData.bIe());
            a(true, jVar, postData);
        } else {
            jVar.hqf.setVisibility(8);
            jVar.hqe.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hqf != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hqf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.T(postData.cem());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hqf.getLayoutParams();
            if (z) {
                jVar.hpO.getLayoutStrategy().kG(0);
                if (z2) {
                    jVar.hpO.getLayoutStrategy().kF(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                    }
                } else {
                    jVar.hpO.getLayoutStrategy().kF(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hqf.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hpO.getLayoutStrategy().kF(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
            jVar.hpO.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
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
        jVar.hpO.setText(cer, true, this.hpz);
    }

    private void h(PostData postData) {
        if (postData.bCj == 0 && postData.ffX) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.bJ("post_id", postData.getId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.bJ("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.bJ("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.k("exposure_time", System.currentTimeMillis());
            if (this.hoJ != null) {
                int bLw = this.hoJ.bIX().bLw();
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
        com.baidu.tieba.pb.c.a.a(this.hoJ.getUniqueId(), this.hoY, postData, postData.locate, postData.iGF ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bOL() == null) {
            jVar.hpY.setVisibility(8);
            return;
        }
        TbRichText cer = postData.cer();
        com.baidu.tieba.pb.view.b.a(postData.bOL(), jVar.hpY, false, false, cer != null && StringUtils.isNull(cer.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hoZ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpO.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hpO.setLayoutParams(layoutParams);
            jVar.hpO.setPadding(0, 0, 0, 0);
            jVar.hpO.qc(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hpO.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hpO.setLayoutParams(layoutParams2);
            jVar.hpO.qc(postData.getBimg_url());
        }
        jVar.hpO.setTextViewOnTouchListener(this.hpB);
        jVar.hpO.setTextViewCheckSelection(false);
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
            if (postData.iGv) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, d.C0277d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hpN.setTag(null);
            jVar.hpN.setUserId(null);
            jVar.dYR.setText((CharSequence) null);
            jVar.hpV.getHeadView().setUserId(null);
            jVar.hpO.setIsHost(false);
            if (postData.YO() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.YO().getUserId())) {
                    jVar.hpO.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YO().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YO().getTShowInfoNew();
                if (jVar.hpX != null) {
                    jVar.hpX.setTag(d.g.tag_user_id, postData.YO().getUserId());
                    jVar.hpX.setOnClickListener(this.hoJ.hmK.hzR);
                    jVar.hpX.a(iconInfo, 2, this.hli, this.hli, this.TBDS10);
                }
                if (jVar.hpW != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hpW.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hpW.setOnClickListener(this.hoJ.hmK.hzS);
                    jVar.hpW.a(tShowInfoNew, 3, this.hli, this.hli, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.T(tShowInfoNew) || postData.YO().isBigV()) {
                    com.baidu.tbadk.core.util.al.d(jVar.dYR, d.C0277d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.d(jVar.dYR, d.C0277d.cp_cont_b, 1);
                }
                String portrait = postData.YO().getPortrait();
                int i2 = 8;
                if (postData.iGF) {
                    i2 = 2;
                }
                jVar.dYR.setTag(d.g.tag_user_id, postData.YO().getUserId());
                jVar.dYR.setTag(d.g.tag_user_name, postData.YO().getUserName());
                jVar.dYR.setTag(d.g.tag_virtual_user_url, postData.YO().getVirtualUserUrl());
                jVar.dYR.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hoY, postData, postData.locate, i2, 2));
                String name_show = postData.YO().getName_show();
                String userName = postData.YO().getUserName();
                if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dYR.setText(com.baidu.tieba.pb.c.aP(this.mContext, jVar.dYR.getText().toString()));
                    jVar.dYR.setGravity(16);
                    jVar.dYR.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                    com.baidu.tbadk.core.util.al.d(jVar.dYR, d.C0277d.cp_other_e, 1);
                }
                if (postData.YO().getPendantData() != null && !StringUtils.isNull(postData.YO().getPendantData().Xk())) {
                    jVar.hpV.b(postData.YO());
                    jVar.hpN.setVisibility(8);
                    jVar.hpV.setVisibility(0);
                    jVar.hpV.getHeadView().startLoad(portrait, 28, false);
                    jVar.hpV.getHeadView().setUserId(postData.YO().getUserId());
                    jVar.hpV.getHeadView().setUserName(postData.YO().getUserName());
                    jVar.hpV.getHeadView().setFid(this.hoY != null ? this.hoY.getForumId() : "");
                    jVar.hpV.getHeadView().setTid(postData.getId());
                    jVar.hpV.getHeadView().setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hoY, postData, postData.locate, i2, 2));
                    jVar.hpV.nn(postData.YO().getPendantData().Xk());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hpN, postData.YO());
                    jVar.hpN.setUserId(postData.YO().getUserId());
                    jVar.hpN.setFid(this.hoY != null ? this.hoY.getForumId() : "");
                    jVar.hpN.setTid(postData.getId());
                    jVar.hpN.setUserName(postData.YO().getUserName(), postData.cez());
                    jVar.hpN.setTag(d.g.tag_virtual_user_url, postData.YO().getVirtualUserUrl());
                    jVar.hpN.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hoY, postData, postData.locate, i2, 2));
                    jVar.hpN.setImageDrawable(null);
                    jVar.hpN.startLoad(portrait, 28, false);
                    jVar.hpN.setVisibility(0);
                    jVar.hpV.setVisibility(8);
                }
                if (postData.YO() != null) {
                    MetaData YO = postData.YO();
                    int ht = postData.ceh() ? d.f.brand_official_btn : com.baidu.tbadk.core.util.al.ht(d.f.bg_user_identity_btn);
                    int ht2 = postData.ceh() ? d.C0277d.cp_btn_a : com.baidu.tbadk.core.util.al.ht(d.C0277d.cp_bg_line_d);
                    com.baidu.tbadk.core.util.al.k(jVar.hpH, ht);
                    com.baidu.tbadk.core.util.al.j(jVar.hpH, ht2);
                    jVar.hpH.setTag(Integer.valueOf(ht));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(YO.getUserId())) {
                        jVar.hpH.setVisibility(0);
                        jVar.hpH.setText(d.j.host_name);
                    } else if (YO.getIs_bawu() == 1 && postData.ceh()) {
                        jVar.hpH.setVisibility(0);
                        jVar.hpH.setText(d.j.brand_Official);
                    } else if (YO.getIs_bawu() == 1 && "manager".equals(YO.getBawu_type())) {
                        jVar.hpH.setVisibility(0);
                        jVar.hpH.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YO.getIs_bawu() == 1 && "assist".equals(YO.getBawu_type())) {
                        jVar.hpH.setVisibility(0);
                        jVar.hpH.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YO.getIs_bawu() == 1 && "pri_content_assist".equals(YO.getBawu_type())) {
                        jVar.hpH.setVisibility(0);
                        jVar.hpH.setText(d.j.bawu_content_assist_tip);
                    } else if (YO.getIs_bawu() == 1 && "pri_manage_assist".equals(YO.getBawu_type())) {
                        jVar.hpH.setVisibility(0);
                        jVar.hpH.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hpH.setVisibility(8);
                        jVar.hpH.setTag(null);
                    }
                } else {
                    jVar.hpH.setVisibility(8);
                    jVar.hpH.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hoJ.bIN()) {
                if (postData.YO() != null) {
                    i3 = postData.YO().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hpU.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hpU, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hpU.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hpX.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hpX.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hpH.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hpW.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aai() > 1000) {
                i4 -= 2;
            }
            if (postData.aai() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hpX.setVisibility(8);
                if (jVar.hpX.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hpX.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hpH.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hpH.setVisibility(8);
                }
                if (i4 < 10 && jVar.hpU.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hpU.setVisibility(8);
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
                jVar.dYR.setText(bN(postData.YO().getSealPrefix(), name_show2));
            } else {
                jVar.dYR.setText(name_show2);
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
            if (this.hoY != null && this.hoY.bIi() != 0) {
                if (this.hoY.bIi() != 1002 && this.hoY.bIi() != 3) {
                    z10 = true;
                }
                if (this.hoY.bIi() != 3) {
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
                        if (this.hoY != null && this.hoY.bHW() != null && this.hoY.bHW().YO() != null && postData.YO() != null) {
                            userId = this.hoY.bHW().YO().getUserId();
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
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoY.bIi()));
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
                                    if (this.hoY.bHW() != null) {
                                        sparseArray.put(d.g.tag_user_mute_thread_id, this.hoY.bHW().getId());
                                    }
                                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(d.g.tag_should_delete_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hoY.bIi()));
                                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_should_delete_visible, false);
                                }
                                jVar.hpO.setTag(sparseArray);
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
                        jVar.hpO.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hoY != null) {
                userId = this.hoY.bHW().YO().getUserId();
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
            jVar.hpO.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.aaE() != null) {
            postData.aaE().threadId = this.hoJ.bIX().bKO();
            postData.aaE().objType = 1;
            postData.aaE().isInPost = true;
            jVar.hpM.setData(postData.aaE());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cep() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.cep()));
                jVar.hpT.setVisibility(0);
                jVar.hpT.setText(format);
                z = true;
            } else {
                jVar.hpT.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f ces = postData.ces();
            boolean z2 = (ces == null || StringUtils.isNull(ces.getName())) ? false : true;
            if (z) {
                jVar.hpJ.setVisibility(0);
                i = this.hpx;
            } else {
                jVar.hpJ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hpK.setVisibility(0);
                i2 = this.hpx;
            } else {
                jVar.hpK.setVisibility(8);
                i2 = 0;
            }
            jVar.hpI.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hpI.setText(com.baidu.tbadk.core.util.ap.aq(postData.getTime()));
            } else {
                jVar.hpI.setText(com.baidu.tbadk.core.util.ap.ao(postData.getTime()));
            }
            if (z2) {
                jVar.hpL.setVisibility(0);
                jVar.hpL.setPadding(this.hpx, 0, 0, 0);
                if (postData.iGD) {
                    jVar.hpL.setText(com.baidu.tbadk.core.util.ap.f(ces.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hpL.setText(ces.getName());
                    return;
                }
            }
            jVar.hpL.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpO.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hpO.setPadding(0, 0, 0, 0);
            if (!this.hoZ) {
                jVar.hpO.getLayoutStrategy().kA(d.f.icon_click);
            } else {
                jVar.hpO.qc(null);
                jVar.hpO.setBackgroundDrawable(null);
                jVar.hpO.getLayoutStrategy().kA(d.f.transparent_bg);
            }
            jVar.hpO.getLayoutStrategy().kx(d.f.pic_video);
            a(jVar.hpO, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hpO.setLayoutParams(layoutParams);
            jVar.hpO.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            jVar.hpO.setIsFromCDN(this.mIsFromCDN);
            TbRichText cer = postData.cer();
            jVar.hpO.setIsUseGridImage(postData.ceC());
            jVar.hpO.setText(cer, true, this.hpz);
            SparseArray sparseArray = (SparseArray) jVar.hpO.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.hpO.setTag(sparseArray);
            jVar.hpF.setTag(d.g.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().cCp = (aO - dimensionPixelSize) - getDimensionPixelSize(d.e.tbds122);
            tbRichTextView.getLayoutStrategy().kz((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cet() > 0) {
                jVar.hpS.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hpS.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hpS.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_load_sub_data, postData);
                if (postData.ceB() == 2) {
                    jVar.hpS.setVisibility(8);
                } else {
                    jVar.hpS.setVisibility(0);
                }
                jVar.hpR.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cet() > 0) {
                    jVar.hpR.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.sub_pb_load_more, Integer.valueOf(postData.cet())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hpR.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hpR.setTag(sparseArray2);
                    }
                    sparseArray2.put(d.g.tag_load_sub_data, postData);
                    jVar.hpR.setVisibility(0);
                    jVar.hpS.setVisibility(8);
                    jVar.hpQ.setVisibility(8);
                }
            } else {
                jVar.hpR.setVisibility(8);
                if (postData.cet() > 0 && postData.cem() != null && postData.cem().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hpQ.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hpQ.setLayoutParams(layoutParams);
                    if (this.hpA == null) {
                        this.hpA = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hpA.setIsFromCDN(this.mIsFromCDN);
                        this.hpA.setOnLongClickListener(this.cdf);
                        this.hpA.M(this.hpi);
                        this.hpA.t(this.mCommonClickListener);
                        String str = null;
                        if (this.hoY != null && this.hoY.bHW() != null && this.hoY.bHW().YO() != null) {
                            str = this.hoY.bHW().YO().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hoY != null) {
                            this.hpA.H(this.hoY.bIi(), z);
                            this.hpA.ai(this.hoY.bHW());
                        }
                    }
                    this.hpA.Al(postData.getId());
                    jVar.hpQ.setSubPbAdapter(this.hpA);
                    jVar.hpQ.setVisibility(0);
                    jVar.hpQ.setData(postData, view);
                    jVar.hpQ.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hpQ.setChildOnLongClickListener(this.cdf);
                    jVar.hpQ.setChildOnTouchListener(this.hpB);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hpQ.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hpQ.setLayoutParams(layoutParams2);
                    jVar.hpQ.setVisibility(8);
                }
            }
            if (postData.iGu) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hqc != null && jVar.hpZ != null) {
            if (postData == null || postData.iGx == null || StringUtils.isNull(postData.iGx.liveTitle)) {
                jVar.hpZ.setVisibility(8);
                return;
            }
            jVar.hqc.setText(postData.iGx.liveTitle);
            jVar.hpZ.setTag(postData.iGx);
            jVar.hpZ.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hqh.setVisibility(postData.iGD ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.d(jVar.dYR, d.C0277d.cp_cont_b, 1);
                if (jVar.hpH.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hpH, ((Integer) jVar.hpH.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.d(jVar.hpI, d.C0277d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hpJ, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hpK, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.d(jVar.hpT, d.C0277d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hpL, d.C0277d.cp_cont_d, 1);
                jVar.hpO.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hpQ, d.C0277d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hpR, d.C0277d.cp_cont_c);
                jVar.hpR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hpS, d.C0277d.cp_cont_c);
                jVar.hpQ.onChangeSkinType();
                jVar.hpP.onChangeSkinType();
                com.baidu.tbadk.core.util.al.d(jVar.hqc, d.C0277d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hqa, d.C0277d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hpZ, d.C0277d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hqb, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hqd, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hqg, d.C0277d.cp_cont_c);
                if (jVar.hqe.getVisibility() == 8) {
                    jVar.hqg.setText(d.j.close_content);
                } else if (this.hoY != null && StringUtils.isNull(this.hoY.bIe())) {
                    jVar.hqg.setText(this.hoY.bIe());
                } else {
                    jVar.hqg.setText(d.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hpF.setOnTouchListener(this.hpB);
        jVar.hpF.setOnLongClickListener(this.cdf);
        if (this.hoJ.getPageContext() != null && this.hoJ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hoJ.getPageContext().getOrignalPage()).hmK;
            jVar.dYR.setOnClickListener(aVar.fzX);
            jVar.hpN.setOnClickListener(aVar.fzX);
            jVar.hpV.setOnClickListener(aVar.fzX);
            jVar.hpV.getHeadView().setOnClickListener(aVar.fzX);
            jVar.hpO.setOnLongClickListener(this.cdf);
            jVar.hpO.setOnTouchListener(this.hpB);
            jVar.hpO.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hpO.setOnImageClickListener(this.cAD);
            jVar.hpO.setOnImageTouchListener(this.hpB);
            jVar.hpO.setOnEmotionClickListener(aVar.hzT);
            jVar.hpO.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hpY.setOnClickListener(this.mCommonClickListener);
            jVar.hpZ.setOnClickListener(this.mCommonClickListener);
            jVar.hpR.setOnClickListener(this.mCommonClickListener);
            jVar.hpS.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hpz = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hoY = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nc(boolean z) {
        this.hoZ = z;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hoJ.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hpO.setTextViewOnTouchListener(this.cca);
        jVar.hpO.setTextViewCheckSelection(false);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpi = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cca = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdf = onLongClickListener;
    }
}
