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
    private TbRichTextView.h cAB;
    private boolean cDm;
    private com.baidu.tieba.pb.a.c cbY;
    private View.OnLongClickListener cdd;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdW;
    private com.baidu.adp.lib.e.b<TbImageView> fdX;
    private int hlt;
    private int hlu;
    private int hlv;
    private int hpK;
    private int hpL;
    private TbRichTextView.c hpM;
    private com.baidu.tieba.pb.pb.sub.c hpN;
    private com.baidu.tieba.pb.a.c hpO;
    protected com.baidu.tieba.pb.data.d hpl;
    private boolean hpm;
    private View.OnClickListener hpv;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hpZ != null && jVar.hpZ.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxj = 5;
                dVar.bxl = 2;
                jVar.hpZ.setStatisticData(dVar);
                jVar.hpZ.aee();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hlt = 0;
        this.hpK = 0;
        this.hlu = 0;
        this.hpL = 0;
        this.hlv = 0;
        this.hpM = null;
        this.hpm = true;
        this.mHostId = null;
        this.hpl = null;
        this.hpv = null;
        this.mCommonClickListener = null;
        this.cAB = null;
        this.cbY = null;
        this.cdd = null;
        this.hpN = null;
        this.cDm = true;
        this.fdW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beI */
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
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
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
        this.hpO = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hoW == null || i.this.hoW.bJq() == null || i.this.hoW.bJq().bMq())) {
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
                if (i.this.cbY != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.cbY.ci(view);
                        i.this.cbY.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.hoW.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hqc.setConstrainLayoutPool(this.fdW);
        jVar.hqc.setImageViewPool(this.fdX);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(d.e.tbds10);
        this.hlt = getDimensionPixelSize(d.e.tbds12);
        this.hpK = getDimensionPixelSize(d.e.tbds14);
        this.hlu = getDimensionPixelSize(d.e.tbds16);
        this.hpL = getDimensionPixelSize(d.e.tbds36);
        this.hlv = getDimensionPixelSize(d.e.tbds40);
        if (jVar.hqb != null) {
            jVar.hqb.setDuiEnabled(this.cDm);
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
            postData2.ZV();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cDm = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.T(postData.ceq())) {
            int i = 8;
            if (postData.iGV) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hpl, postData, postData.locate, i, 6);
            postData.iGW = b;
            Iterator<PostData> it = postData.ceq().iterator();
            while (it.hasNext()) {
                it.next().iGW = b;
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
        if (jVar != null && this.hoW != null && this.hoW.bJa() != null && this.hoW.bJa().bLG() && com.baidu.tbadk.core.util.ap.equals(this.hoW.bJa().bKQ(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hpS, d.C0277d.cp_other_g);
        } else {
            jVar.hpS.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hqr.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hqt.setText(d.j.expand_content);
                return;
            } else {
                jVar.hqt.setText(str);
                return;
            }
        }
        jVar.hqr.setVisibility(0);
        jVar.hqt.setText(d.j.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.ceF() == 2 || postData.ceF() == 4) {
            jVar.hqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hqr.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bIh());
                    postData.pV(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hoW.bJq() != null && i.this.hoW.bJq().bNo() != null && i.this.hoW.bJq().getListView() != null && !z && jVar.getView().getTop() < i.this.hoW.bJq().bNo().getMeasuredHeight()) {
                        i.this.hoW.bJq().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hoW.bJq().getListView().getData(), postData) + i.this.hoW.bJq().getListView().getHeaderViewsCount(), i.this.hoW.bJq().bNo().getMeasuredHeight());
                    }
                }
            });
            jVar.hqs.setVisibility(0);
            a(jVar, postData.ceo(), postData.bIh());
            a(true, jVar, postData);
        } else {
            jVar.hqs.setVisibility(8);
            jVar.hqr.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hqs != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hqs.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.T(postData.ceq());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hqs.getLayoutParams();
            if (z) {
                jVar.hqb.getLayoutStrategy().kH(0);
                if (z2) {
                    jVar.hqb.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                    }
                } else {
                    jVar.hqb.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hqs.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hqb.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
            jVar.hqb.getLayoutStrategy().kH(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cev = postData.cev();
        cev.isChanged = true;
        jVar.hqb.setText(cev, true, this.hpM);
    }

    private void h(PostData postData) {
        if (postData.bCg == 0 && postData.fgk) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.bJ("post_id", postData.getId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.bJ("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.bJ("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.k("exposure_time", System.currentTimeMillis());
            if (this.hoW != null) {
                int bLz = this.hoW.bJa().bLz();
                if (1 == bLz || 2 == bLz) {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bLz) {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hoW.getUniqueId(), this.hpl, postData, postData.locate, postData.iGV ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bOO() == null) {
            jVar.hql.setVisibility(8);
            return;
        }
        TbRichText cev = postData.cev();
        com.baidu.tieba.pb.view.b.a(postData.bOO(), jVar.hql, false, false, cev != null && StringUtils.isNull(cev.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpm) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqb.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hqb.setLayoutParams(layoutParams);
            jVar.hqb.setPadding(0, 0, 0, 0);
            jVar.hqb.qb(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqb.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hqb.setLayoutParams(layoutParams2);
            jVar.hqb.qb(postData.getBimg_url());
        }
        jVar.hqb.setTextViewOnTouchListener(this.hpO);
        jVar.hqb.setTextViewCheckSelection(false);
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
            if (postData.iGL) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, d.C0277d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hqa.setTag(null);
            jVar.hqa.setUserId(null);
            jVar.dZu.setText((CharSequence) null);
            jVar.hqi.getHeadView().setUserId(null);
            jVar.hqb.setIsHost(false);
            if (postData.YR() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.YR().getUserId())) {
                    jVar.hqb.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YR().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YR().getTShowInfoNew();
                if (jVar.hqk != null) {
                    jVar.hqk.setTag(d.g.tag_user_id, postData.YR().getUserId());
                    jVar.hqk.setOnClickListener(this.hoW.hmX.hAf);
                    jVar.hqk.a(iconInfo, 2, this.hlv, this.hlv, this.TBDS10);
                }
                if (jVar.hqj != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hqj.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hqj.setOnClickListener(this.hoW.hmX.hAg);
                    jVar.hqj.a(tShowInfoNew, 3, this.hlv, this.hlv, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.T(tShowInfoNew) || postData.YR().isBigV()) {
                    com.baidu.tbadk.core.util.al.d(jVar.dZu, d.C0277d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.d(jVar.dZu, d.C0277d.cp_cont_b, 1);
                }
                String portrait = postData.YR().getPortrait();
                int i2 = 8;
                if (postData.iGV) {
                    i2 = 2;
                }
                jVar.dZu.setTag(d.g.tag_user_id, postData.YR().getUserId());
                jVar.dZu.setTag(d.g.tag_user_name, postData.YR().getUserName());
                jVar.dZu.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                jVar.dZu.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hpl, postData, postData.locate, i2, 2));
                String name_show = postData.YR().getName_show();
                String userName = postData.YR().getUserName();
                if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dZu.setText(com.baidu.tieba.pb.c.aP(this.mContext, jVar.dZu.getText().toString()));
                    jVar.dZu.setGravity(16);
                    jVar.dZu.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHK());
                    com.baidu.tbadk.core.util.al.d(jVar.dZu, d.C0277d.cp_other_e, 1);
                }
                if (postData.YR().getPendantData() != null && !StringUtils.isNull(postData.YR().getPendantData().Xn())) {
                    jVar.hqi.b(postData.YR());
                    jVar.hqa.setVisibility(8);
                    jVar.hqi.setVisibility(0);
                    jVar.hqi.getHeadView().startLoad(portrait, 28, false);
                    jVar.hqi.getHeadView().setUserId(postData.YR().getUserId());
                    jVar.hqi.getHeadView().setUserName(postData.YR().getUserName());
                    jVar.hqi.getHeadView().setFid(this.hpl != null ? this.hpl.getForumId() : "");
                    jVar.hqi.getHeadView().setTid(postData.getId());
                    jVar.hqi.getHeadView().setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hpl, postData, postData.locate, i2, 2));
                    jVar.hqi.nm(postData.YR().getPendantData().Xn());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hqa, postData.YR());
                    jVar.hqa.setUserId(postData.YR().getUserId());
                    jVar.hqa.setFid(this.hpl != null ? this.hpl.getForumId() : "");
                    jVar.hqa.setTid(postData.getId());
                    jVar.hqa.setUserName(postData.YR().getUserName(), postData.ceD());
                    jVar.hqa.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                    jVar.hqa.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hpl, postData, postData.locate, i2, 2));
                    jVar.hqa.setImageDrawable(null);
                    jVar.hqa.startLoad(portrait, 28, false);
                    jVar.hqa.setVisibility(0);
                    jVar.hqi.setVisibility(8);
                }
                if (postData.YR() != null) {
                    MetaData YR = postData.YR();
                    int hu = postData.cel() ? d.f.brand_official_btn : com.baidu.tbadk.core.util.al.hu(d.f.bg_user_identity_btn);
                    int hu2 = postData.cel() ? d.C0277d.cp_btn_a : com.baidu.tbadk.core.util.al.hu(d.C0277d.cp_bg_line_d);
                    com.baidu.tbadk.core.util.al.k(jVar.hpU, hu);
                    com.baidu.tbadk.core.util.al.j(jVar.hpU, hu2);
                    jVar.hpU.setTag(Integer.valueOf(hu));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(YR.getUserId())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.host_name);
                    } else if (YR.getIs_bawu() == 1 && postData.cel()) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.brand_Official);
                    } else if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_content_assist".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_content_assist_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_manage_assist".equals(YR.getBawu_type())) {
                        jVar.hpU.setVisibility(0);
                        jVar.hpU.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hpU.setVisibility(8);
                        jVar.hpU.setTag(null);
                    }
                } else {
                    jVar.hpU.setVisibility(8);
                    jVar.hpU.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hoW.bIQ()) {
                if (postData.YR() != null) {
                    i3 = postData.YR().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hqh.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hqh, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hqh.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hqk.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hqk.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hpU.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hqj.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aal() > 1000) {
                i4 -= 2;
            }
            if (postData.aal() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hqk.setVisibility(8);
                if (jVar.hqk.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hqk.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hpU.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hpU.setVisibility(8);
                }
                if (i4 < 10 && jVar.hqh.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hqh.setVisibility(8);
                }
            }
            String name_show2 = postData.YR() != null ? postData.YR().getName_show() : "";
            int pN = com.baidu.tbadk.util.ab.pN(name_show2);
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                if (pN > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ah(name_show2, i4 - 2) + "...";
                }
            } else if (pN > i4) {
                name_show2 = com.baidu.tbadk.util.ab.ah(name_show2, i4) + "...";
            }
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                jVar.dZu.setText(bN(postData.YR().getSealPrefix(), name_show2));
            } else {
                jVar.dZu.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cet()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hpl != null && this.hpl.bIl() != 0) {
                if (this.hpl.bIl() != 1002 && this.hpl.bIl() != 3) {
                    z10 = true;
                }
                if (this.hpl.bIl() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.YR() != null) {
                    String userId2 = postData.YR().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hpl != null && this.hpl.bHZ() != null && this.hpl.bHZ().YR() != null && postData.YR() != null) {
                            userId = this.hpl.bHZ().YR().getUserId();
                            String userId3 = postData.YR().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.YR() != null && UtilHelper.isCurrentAccount(postData.YR().getUserId())) {
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
                                if (postData.cet() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(d.g.tag_should_manage_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hpl.bIl()));
                                    if (postData.YR() != null) {
                                        sparseArray.put(d.g.tag_forbid_user_name, postData.YR().getUserName());
                                        sparseArray.put(d.g.tag_forbid_user_name_show, postData.YR().getName_show());
                                        sparseArray.put(d.g.tag_forbid_user_portrait, postData.YR().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(d.g.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(d.g.tag_user_mute_visible, true);
                                    sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.YR() != null) {
                                        sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YR().getUserId());
                                        sparseArray.put(d.g.tag_user_mute_mute_username, postData.YR().getUserName());
                                        sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YR().getName_show());
                                    }
                                    if (this.hpl.bHZ() != null) {
                                        sparseArray.put(d.g.tag_user_mute_thread_id, this.hpl.bHZ().getId());
                                    }
                                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(d.g.tag_should_delete_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hpl.bIl()));
                                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_should_delete_visible, false);
                                }
                                jVar.hqb.setTag(sparseArray);
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
                        if (postData.cet() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hqb.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hpl != null) {
                userId = this.hpl.bHZ().YR().getUserId();
                String userId32 = postData.YR().getUserId();
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
            if (postData.cet() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hqb.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.aaH() != null) {
            postData.aaH().threadId = this.hoW.bJa().bKR();
            postData.aaH().objType = 1;
            postData.aaH().isInPost = true;
            jVar.hpZ.setData(postData.aaH());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cet() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.cet()));
                jVar.hqg.setVisibility(0);
                jVar.hqg.setText(format);
                z = true;
            } else {
                jVar.hqg.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cew = postData.cew();
            boolean z2 = (cew == null || StringUtils.isNull(cew.getName())) ? false : true;
            if (z) {
                jVar.hpW.setVisibility(0);
                i = this.hpK;
            } else {
                jVar.hpW.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hpX.setVisibility(0);
                i2 = this.hpK;
            } else {
                jVar.hpX.setVisibility(8);
                i2 = 0;
            }
            jVar.hpV.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hpV.setText(com.baidu.tbadk.core.util.ap.aq(postData.getTime()));
            } else {
                jVar.hpV.setText(com.baidu.tbadk.core.util.ap.ao(postData.getTime()));
            }
            if (z2) {
                jVar.hpY.setVisibility(0);
                jVar.hpY.setPadding(this.hpK, 0, 0, 0);
                if (postData.iGT) {
                    jVar.hpY.setText(com.baidu.tbadk.core.util.ap.f(cew.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hpY.setText(cew.getName());
                    return;
                }
            }
            jVar.hpY.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqb.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hqb.setPadding(0, 0, 0, 0);
            if (!this.hpm) {
                jVar.hqb.getLayoutStrategy().kB(d.f.icon_click);
            } else {
                jVar.hqb.qb(null);
                jVar.hqb.setBackgroundDrawable(null);
                jVar.hqb.getLayoutStrategy().kB(d.f.transparent_bg);
            }
            jVar.hqb.getLayoutStrategy().ky(d.f.pic_video);
            a(jVar.hqb, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hqb.setLayoutParams(layoutParams);
            jVar.hqb.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_link_tip_c));
            jVar.hqb.setIsFromCDN(this.mIsFromCDN);
            TbRichText cev = postData.cev();
            jVar.hqb.setIsUseGridImage(postData.ceG());
            jVar.hqb.setText(cev, true, this.hpM);
            SparseArray sparseArray = (SparseArray) jVar.hqb.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.hqb.setTag(sparseArray);
            jVar.hpS.setTag(d.g.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().kz(aO - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cCn = (aO - dimensionPixelSize) - getDimensionPixelSize(d.e.tbds122);
            tbRichTextView.getLayoutStrategy().kA((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cex() > 0) {
                jVar.hqf.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hqf.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hqf.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_load_sub_data, postData);
                if (postData.ceF() == 2) {
                    jVar.hqf.setVisibility(8);
                } else {
                    jVar.hqf.setVisibility(0);
                }
                jVar.hqe.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cex() > 0) {
                    jVar.hqe.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.sub_pb_load_more, Integer.valueOf(postData.cex())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hqe.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hqe.setTag(sparseArray2);
                    }
                    sparseArray2.put(d.g.tag_load_sub_data, postData);
                    jVar.hqe.setVisibility(0);
                    jVar.hqf.setVisibility(8);
                    jVar.hqd.setVisibility(8);
                }
            } else {
                jVar.hqe.setVisibility(8);
                if (postData.cex() > 0 && postData.ceq() != null && postData.ceq().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqd.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hqd.setLayoutParams(layoutParams);
                    if (this.hpN == null) {
                        this.hpN = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hpN.setIsFromCDN(this.mIsFromCDN);
                        this.hpN.setOnLongClickListener(this.cdd);
                        this.hpN.M(this.hpv);
                        this.hpN.t(this.mCommonClickListener);
                        String str = null;
                        if (this.hpl != null && this.hpl.bHZ() != null && this.hpl.bHZ().YR() != null) {
                            str = this.hpl.bHZ().YR().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hpl != null) {
                            this.hpN.H(this.hpl.bIl(), z);
                            this.hpN.aj(this.hpl.bHZ());
                        }
                    }
                    this.hpN.Am(postData.getId());
                    jVar.hqd.setSubPbAdapter(this.hpN);
                    jVar.hqd.setVisibility(0);
                    jVar.hqd.setData(postData, view);
                    jVar.hqd.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hqd.setChildOnLongClickListener(this.cdd);
                    jVar.hqd.setChildOnTouchListener(this.hpO);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqd.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hqd.setLayoutParams(layoutParams2);
                    jVar.hqd.setVisibility(8);
                }
            }
            if (postData.iGK) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hqp != null && jVar.hqm != null) {
            if (postData == null || postData.iGN == null || StringUtils.isNull(postData.iGN.liveTitle)) {
                jVar.hqm.setVisibility(8);
                return;
            }
            jVar.hqp.setText(postData.iGN.liveTitle);
            jVar.hqm.setTag(postData.iGN);
            jVar.hqm.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hqu.setVisibility(postData.iGT ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.d(jVar.dZu, d.C0277d.cp_cont_b, 1);
                if (jVar.hpU.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hpU, ((Integer) jVar.hpU.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.d(jVar.hpV, d.C0277d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hpW, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hpX, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.d(jVar.hqg, d.C0277d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hpY, d.C0277d.cp_cont_d, 1);
                jVar.hqb.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hqd, d.C0277d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hqe, d.C0277d.cp_cont_c);
                jVar.hqe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hqf, d.C0277d.cp_cont_c);
                jVar.hqd.onChangeSkinType();
                jVar.hqc.onChangeSkinType();
                com.baidu.tbadk.core.util.al.d(jVar.hqp, d.C0277d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hqn, d.C0277d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hqm, d.C0277d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hqo, d.C0277d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hqq, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hqt, d.C0277d.cp_cont_c);
                if (jVar.hqr.getVisibility() == 8) {
                    jVar.hqt.setText(d.j.close_content);
                } else if (this.hpl != null && StringUtils.isNull(this.hpl.bIh())) {
                    jVar.hqt.setText(this.hpl.bIh());
                } else {
                    jVar.hqt.setText(d.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hpS.setOnTouchListener(this.hpO);
        jVar.hpS.setOnLongClickListener(this.cdd);
        if (this.hoW.getPageContext() != null && this.hoW.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hoW.getPageContext().getOrignalPage()).hmX;
            jVar.dZu.setOnClickListener(aVar.fAj);
            jVar.hqa.setOnClickListener(aVar.fAj);
            jVar.hqi.setOnClickListener(aVar.fAj);
            jVar.hqi.getHeadView().setOnClickListener(aVar.fAj);
            jVar.hqb.setOnLongClickListener(this.cdd);
            jVar.hqb.setOnTouchListener(this.hpO);
            jVar.hqb.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hqb.setOnImageClickListener(this.cAB);
            jVar.hqb.setOnImageTouchListener(this.hpO);
            jVar.hqb.setOnEmotionClickListener(aVar.hAh);
            jVar.hqb.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hql.setOnClickListener(this.mCommonClickListener);
            jVar.hqm.setOnClickListener(this.mCommonClickListener);
            jVar.hqe.setOnClickListener(this.mCommonClickListener);
            jVar.hqf.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hpM = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hpl = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nc(boolean z) {
        this.hpm = z;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hoW.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hqb.setTextViewOnTouchListener(this.cbY);
        jVar.hqb.setTextViewCheckSelection(false);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpv = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAB = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cbY = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }
}
