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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private int TBDS10;
    private TbRichTextView.h cAE;
    private boolean cDp;
    private com.baidu.tieba.pb.a.c cbY;
    private View.OnLongClickListener cdd;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdX;
    private com.baidu.adp.lib.e.b<TbImageView> fdY;
    private int hlu;
    private int hlv;
    private int hlw;
    private View.OnClickListener hpC;
    private int hpR;
    private int hpS;
    private TbRichTextView.c hpT;
    private com.baidu.tieba.pb.pb.sub.c hpU;
    private com.baidu.tieba.pb.a.c hpV;
    protected com.baidu.tieba.pb.data.d hps;
    private boolean hpt;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hqg != null && jVar.hqg.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxh = 5;
                dVar.bxj = 2;
                jVar.hqg.setStatisticData(dVar);
                jVar.hqg.aee();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hlu = 0;
        this.hpR = 0;
        this.hlv = 0;
        this.hpS = 0;
        this.hlw = 0;
        this.hpT = null;
        this.hpt = true;
        this.mHostId = null;
        this.hps = null;
        this.hpC = null;
        this.mCommonClickListener = null;
        this.cAE = null;
        this.cbY = null;
        this.cdd = null;
        this.hpU = null;
        this.cDp = true;
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beJ */
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
        this.fdY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.common_color_10043));
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
        this.hpV = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hpd == null || i.this.hpd.bJr() == null || i.this.hpd.bJr().bMr())) {
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
        j jVar = new j(this.hpd.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hqj.setConstrainLayoutPool(this.fdX);
        jVar.hqj.setImageViewPool(this.fdY);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(d.e.tbds10);
        this.hlu = getDimensionPixelSize(d.e.tbds12);
        this.hpR = getDimensionPixelSize(d.e.tbds14);
        this.hlv = getDimensionPixelSize(d.e.tbds16);
        this.hpS = getDimensionPixelSize(d.e.tbds36);
        this.hlw = getDimensionPixelSize(d.e.tbds40);
        if (jVar.hqi != null) {
            jVar.hqi.setDuiEnabled(this.cDp);
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
        this.cDp = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.T(postData.ceo())) {
            int i = 8;
            if (postData.iHd) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hps, postData, postData.locate, i, 6);
            postData.iHe = b;
            Iterator<PostData> it = postData.ceo().iterator();
            while (it.hasNext()) {
                it.next().iHe = b;
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
        if (jVar != null && this.hpd != null && this.hpd.bJb() != null && this.hpd.bJb().bLH() && com.baidu.tbadk.core.util.ap.equals(this.hpd.bJb().bKR(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hpZ, d.C0236d.cp_other_g);
        } else {
            jVar.hpZ.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hqy.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hqA.setText(d.j.expand_content);
                return;
            } else {
                jVar.hqA.setText(str);
                return;
            }
        }
        jVar.hqy.setVisibility(0);
        jVar.hqA.setText(d.j.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.ceD() == 2 || postData.ceD() == 4) {
            jVar.hqz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hqy.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bIi());
                    postData.pV(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hpd.bJr() != null && i.this.hpd.bJr().bNo() != null && i.this.hpd.bJr().getListView() != null && !z && jVar.getView().getTop() < i.this.hpd.bJr().bNo().getMeasuredHeight()) {
                        i.this.hpd.bJr().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hpd.bJr().getListView().getData(), postData) + i.this.hpd.bJr().getListView().getHeaderViewsCount(), i.this.hpd.bJr().bNo().getMeasuredHeight());
                    }
                }
            });
            jVar.hqz.setVisibility(0);
            a(jVar, postData.cem(), postData.bIi());
            a(true, jVar, postData);
        } else {
            jVar.hqz.setVisibility(8);
            jVar.hqy.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hqz != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hqz.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.T(postData.ceo());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hqz.getLayoutParams();
            if (z) {
                jVar.hqi.getLayoutStrategy().kH(0);
                if (z2) {
                    jVar.hqi.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                    }
                } else {
                    jVar.hqi.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hqz.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hqi.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
            jVar.hqi.getLayoutStrategy().kH(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cet = postData.cet();
        cet.isChanged = true;
        jVar.hqi.setText(cet, true, this.hpT);
    }

    private void h(PostData postData) {
        if (postData.bCe == 0 && postData.fgl) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.bJ("post_id", postData.getId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.bJ("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.bJ("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.k("exposure_time", System.currentTimeMillis());
            if (this.hpd != null) {
                int bLA = this.hpd.bJb().bLA();
                if (1 == bLA || 2 == bLA) {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bLA) {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hpd.getUniqueId(), this.hps, postData, postData.locate, postData.iHd ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bOO() == null) {
            jVar.hqs.setVisibility(8);
            return;
        }
        TbRichText cet = postData.cet();
        com.baidu.tieba.pb.view.b.a(postData.bOO(), jVar.hqs, false, false, cet != null && StringUtils.isNull(cet.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpt) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hqi.setLayoutParams(layoutParams);
            jVar.hqi.setPadding(0, 0, 0, 0);
            jVar.hqi.qd(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqi.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hqi.setLayoutParams(layoutParams2);
            jVar.hqi.qd(postData.getBimg_url());
        }
        jVar.hqi.setTextViewOnTouchListener(this.hpV);
        jVar.hqi.setTextViewCheckSelection(false);
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
            if (postData.iGT) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, d.C0236d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hqh.setTag(null);
            jVar.hqh.setUserId(null);
            jVar.dZy.setText((CharSequence) null);
            jVar.hqp.getHeadView().setUserId(null);
            jVar.hqi.setIsHost(false);
            if (postData.YR() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.YR().getUserId())) {
                    jVar.hqi.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YR().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YR().getTShowInfoNew();
                if (jVar.hqr != null) {
                    jVar.hqr.setTag(d.g.tag_user_id, postData.YR().getUserId());
                    jVar.hqr.setOnClickListener(this.hpd.hne.hAl);
                    jVar.hqr.a(iconInfo, 2, this.hlw, this.hlw, this.TBDS10);
                }
                if (jVar.hqq != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hqq.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hqq.setOnClickListener(this.hpd.hne.hAm);
                    jVar.hqq.a(tShowInfoNew, 3, this.hlw, this.hlw, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.T(tShowInfoNew) || postData.YR().isBigV()) {
                    com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_cont_b, 1);
                }
                String portrait = postData.YR().getPortrait();
                int i2 = 8;
                if (postData.iHd) {
                    i2 = 2;
                }
                jVar.dZy.setTag(d.g.tag_user_id, postData.YR().getUserId());
                jVar.dZy.setTag(d.g.tag_user_name, postData.YR().getUserName());
                jVar.dZy.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                jVar.dZy.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hps, postData, postData.locate, i2, 2));
                String name_show = postData.YR().getName_show();
                String userName = postData.YR().getUserName();
                if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dZy.setText(com.baidu.tieba.pb.c.aQ(this.mContext, jVar.dZy.getText().toString()));
                    jVar.dZy.setGravity(16);
                    jVar.dZy.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHL());
                    com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_other_e, 1);
                }
                if (postData.YR().getPendantData() != null && !StringUtils.isNull(postData.YR().getPendantData().Xn())) {
                    jVar.hqp.b(postData.YR());
                    jVar.hqh.setVisibility(8);
                    jVar.hqp.setVisibility(0);
                    jVar.hqp.getHeadView().startLoad(portrait, 28, false);
                    jVar.hqp.getHeadView().setUserId(postData.YR().getUserId());
                    jVar.hqp.getHeadView().setUserName(postData.YR().getUserName());
                    jVar.hqp.getHeadView().setFid(this.hps != null ? this.hps.getForumId() : "");
                    jVar.hqp.getHeadView().setTid(postData.getId());
                    jVar.hqp.getHeadView().setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hps, postData, postData.locate, i2, 2));
                    jVar.hqp.nm(postData.YR().getPendantData().Xn());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hqh, postData.YR());
                    jVar.hqh.setUserId(postData.YR().getUserId());
                    jVar.hqh.setFid(this.hps != null ? this.hps.getForumId() : "");
                    jVar.hqh.setTid(postData.getId());
                    jVar.hqh.setUserName(postData.YR().getUserName(), postData.ceB());
                    jVar.hqh.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                    jVar.hqh.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hps, postData, postData.locate, i2, 2));
                    jVar.hqh.setImageDrawable(null);
                    jVar.hqh.startLoad(portrait, 28, false);
                    jVar.hqh.setVisibility(0);
                    jVar.hqp.setVisibility(8);
                }
                if (postData.YR() != null) {
                    MetaData YR = postData.YR();
                    int hu = postData.cej() ? d.f.brand_official_btn : com.baidu.tbadk.core.util.al.hu(d.f.bg_user_identity_btn);
                    int hu2 = postData.cej() ? d.C0236d.cp_btn_a : com.baidu.tbadk.core.util.al.hu(d.C0236d.cp_bg_line_d);
                    com.baidu.tbadk.core.util.al.k(jVar.hqb, hu);
                    com.baidu.tbadk.core.util.al.j(jVar.hqb, hu2);
                    jVar.hqb.setTag(Integer.valueOf(hu));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(YR.getUserId())) {
                        jVar.hqb.setVisibility(0);
                        jVar.hqb.setText(d.j.host_name);
                    } else if (YR.getIs_bawu() == 1 && postData.cej()) {
                        jVar.hqb.setVisibility(0);
                        jVar.hqb.setText(d.j.brand_Official);
                    } else if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                        jVar.hqb.setVisibility(0);
                        jVar.hqb.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                        jVar.hqb.setVisibility(0);
                        jVar.hqb.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_content_assist".equals(YR.getBawu_type())) {
                        jVar.hqb.setVisibility(0);
                        jVar.hqb.setText(d.j.bawu_content_assist_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_manage_assist".equals(YR.getBawu_type())) {
                        jVar.hqb.setVisibility(0);
                        jVar.hqb.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hqb.setVisibility(8);
                        jVar.hqb.setTag(null);
                    }
                } else {
                    jVar.hqb.setVisibility(8);
                    jVar.hqb.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hpd.bIR()) {
                if (postData.YR() != null) {
                    i3 = postData.YR().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hqo.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hqo, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hqo.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hqr.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hqr.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hqb.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hqq.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aal() > 1000) {
                i4 -= 2;
            }
            if (postData.aal() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hqr.setVisibility(8);
                if (jVar.hqr.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hqr.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hqb.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hqb.setVisibility(8);
                }
                if (i4 < 10 && jVar.hqo.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hqo.setVisibility(8);
                }
            }
            String name_show2 = postData.YR() != null ? postData.YR().getName_show() : "";
            int pP = com.baidu.tbadk.util.ab.pP(name_show2);
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                if (pP > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ah(name_show2, i4 - 2) + "...";
                }
            } else if (pP > i4) {
                name_show2 = com.baidu.tbadk.util.ab.ah(name_show2, i4) + "...";
            }
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                jVar.dZy.setText(bN(postData.YR().getSealPrefix(), name_show2));
            } else {
                jVar.dZy.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_load_sub_data, postData);
            sparseArray.put(d.g.tag_load_sub_view, view);
            sparseArray.put(d.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.cer()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hps != null && this.hps.bIm() != 0) {
                if (this.hps.bIm() != 1002 && this.hps.bIm() != 3) {
                    z10 = true;
                }
                if (this.hps.bIm() != 3) {
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
                        if (this.hps != null && this.hps.bIa() != null && this.hps.bIa().YR() != null && postData.YR() != null) {
                            userId = this.hps.bIa().YR().getUserId();
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
                                if (postData.cer() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(d.g.tag_should_manage_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hps.bIm()));
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
                                    if (this.hps.bIa() != null) {
                                        sparseArray.put(d.g.tag_user_mute_thread_id, this.hps.bIa().getId());
                                    }
                                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(d.g.tag_should_delete_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hps.bIm()));
                                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_should_delete_visible, false);
                                }
                                jVar.hqi.setTag(sparseArray);
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
                        if (postData.cer() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hqi.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hps != null) {
                userId = this.hps.bIa().YR().getUserId();
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
            if (postData.cer() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hqi.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.aaH() != null) {
            postData.aaH().threadId = this.hpd.bJb().bKS();
            postData.aaH().objType = 1;
            postData.aaH().isInPost = true;
            jVar.hqg.setData(postData.aaH());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cer() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.cer()));
                jVar.hqn.setVisibility(0);
                jVar.hqn.setText(format);
                z = true;
            } else {
                jVar.hqn.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f ceu = postData.ceu();
            boolean z2 = (ceu == null || StringUtils.isNull(ceu.getName())) ? false : true;
            if (z) {
                jVar.hqd.setVisibility(0);
                i = this.hpR;
            } else {
                jVar.hqd.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hqe.setVisibility(0);
                i2 = this.hpR;
            } else {
                jVar.hqe.setVisibility(8);
                i2 = 0;
            }
            jVar.hqc.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hqc.setText(com.baidu.tbadk.core.util.ap.aq(postData.getTime()));
            } else {
                jVar.hqc.setText(com.baidu.tbadk.core.util.ap.ao(postData.getTime()));
            }
            if (z2) {
                final String name = ceu.getName();
                final String lat = ceu.getLat();
                final String lng = ceu.getLng();
                jVar.hqf.setVisibility(0);
                jVar.hqf.setPadding(this.hpR, 0, 0, 0);
                if (postData.iHb) {
                    jVar.hqf.setText(com.baidu.tbadk.core.util.ap.f(ceu.getName(), 7, "..."));
                } else {
                    jVar.hqf.setText(ceu.getName());
                }
                jVar.hqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kY()) {
                                com.baidu.tbadk.browser.a.ar(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                i.this.hpd.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.hqf.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqi.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hqi.setPadding(0, 0, 0, 0);
            if (!this.hpt) {
                jVar.hqi.getLayoutStrategy().kB(d.f.icon_click);
            } else {
                jVar.hqi.qd(null);
                jVar.hqi.setBackgroundDrawable(null);
                jVar.hqi.getLayoutStrategy().kB(d.f.transparent_bg);
            }
            jVar.hqi.getLayoutStrategy().ky(d.f.pic_video);
            a(jVar.hqi, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hqi.setLayoutParams(layoutParams);
            jVar.hqi.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_c));
            jVar.hqi.setIsFromCDN(this.mIsFromCDN);
            TbRichText cet = postData.cet();
            jVar.hqi.setIsUseGridImage(postData.ceE());
            jVar.hqi.setText(cet, true, this.hpT);
            SparseArray sparseArray = (SparseArray) jVar.hqi.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.hqi.setTag(sparseArray);
            jVar.hpZ.setTag(d.g.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().cCq = (aO - dimensionPixelSize) - getDimensionPixelSize(d.e.tbds122);
            tbRichTextView.getLayoutStrategy().kA((int) (aO * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cev() > 0) {
                jVar.hqm.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hqm.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hqm.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_load_sub_data, postData);
                if (postData.ceD() == 2) {
                    jVar.hqm.setVisibility(8);
                } else {
                    jVar.hqm.setVisibility(0);
                }
                jVar.hql.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cev() > 0) {
                    jVar.hql.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.sub_pb_load_more, Integer.valueOf(postData.cev())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hql.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hql.setTag(sparseArray2);
                    }
                    sparseArray2.put(d.g.tag_load_sub_data, postData);
                    jVar.hql.setVisibility(0);
                    jVar.hqm.setVisibility(8);
                    jVar.hqk.setVisibility(8);
                }
            } else {
                jVar.hql.setVisibility(8);
                if (postData.cev() > 0 && postData.ceo() != null && postData.ceo().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqk.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hqk.setLayoutParams(layoutParams);
                    if (this.hpU == null) {
                        this.hpU = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hpU.setIsFromCDN(this.mIsFromCDN);
                        this.hpU.setOnLongClickListener(this.cdd);
                        this.hpU.M(this.hpC);
                        this.hpU.t(this.mCommonClickListener);
                        String str = null;
                        if (this.hps != null && this.hps.bIa() != null && this.hps.bIa().YR() != null) {
                            str = this.hps.bIa().YR().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hps != null) {
                            this.hpU.H(this.hps.bIm(), z);
                            this.hpU.aj(this.hps.bIa());
                        }
                    }
                    this.hpU.Ao(postData.getId());
                    jVar.hqk.setSubPbAdapter(this.hpU);
                    jVar.hqk.setVisibility(0);
                    jVar.hqk.setData(postData, view);
                    jVar.hqk.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hqk.setChildOnLongClickListener(this.cdd);
                    jVar.hqk.setChildOnTouchListener(this.hpV);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqk.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hqk.setLayoutParams(layoutParams2);
                    jVar.hqk.setVisibility(8);
                }
            }
            if (postData.iGS) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hqw != null && jVar.hqt != null) {
            if (postData == null || postData.iGV == null || StringUtils.isNull(postData.iGV.liveTitle)) {
                jVar.hqt.setVisibility(8);
                return;
            }
            jVar.hqw.setText(postData.iGV.liveTitle);
            jVar.hqt.setTag(postData.iGV);
            jVar.hqt.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hqB.setVisibility(postData.iHb ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_cont_b, 1);
                if (jVar.hqb.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hqb, ((Integer) jVar.hqb.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.d(jVar.hqc, d.C0236d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hqd, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hqe, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.d(jVar.hqn, d.C0236d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hqf, d.C0236d.cp_cont_d, 1);
                jVar.hqi.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hqk, d.C0236d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hql, d.C0236d.cp_cont_c);
                jVar.hql.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hqm, d.C0236d.cp_cont_c);
                jVar.hqk.onChangeSkinType();
                jVar.hqj.onChangeSkinType();
                com.baidu.tbadk.core.util.al.d(jVar.hqw, d.C0236d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hqu, d.C0236d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hqt, d.C0236d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hqv, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hqx, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hqA, d.C0236d.cp_cont_c);
                if (jVar.hqy.getVisibility() == 8) {
                    jVar.hqA.setText(d.j.close_content);
                } else if (this.hps != null && StringUtils.isNull(this.hps.bIi())) {
                    jVar.hqA.setText(this.hps.bIi());
                } else {
                    jVar.hqA.setText(d.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hpZ.setOnTouchListener(this.hpV);
        jVar.hpZ.setOnLongClickListener(this.cdd);
        if (this.hpd.getPageContext() != null && this.hpd.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hpd.getPageContext().getOrignalPage()).hne;
            jVar.dZy.setOnClickListener(aVar.fAk);
            jVar.hqh.setOnClickListener(aVar.fAk);
            jVar.hqp.setOnClickListener(aVar.fAk);
            jVar.hqp.getHeadView().setOnClickListener(aVar.fAk);
            jVar.hqi.setOnLongClickListener(this.cdd);
            jVar.hqi.setOnTouchListener(this.hpV);
            jVar.hqi.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hqi.setOnImageClickListener(this.cAE);
            jVar.hqi.setOnImageTouchListener(this.hpV);
            jVar.hqi.setOnEmotionClickListener(aVar.hAn);
            jVar.hqi.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hqs.setOnClickListener(this.mCommonClickListener);
            jVar.hqt.setOnClickListener(this.mCommonClickListener);
            jVar.hql.setOnClickListener(this.mCommonClickListener);
            jVar.hqm.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hpT = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hps = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nc(boolean z) {
        this.hpt = z;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hpd.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hqi.setTextViewOnTouchListener(this.cbY);
        jVar.hqi.setTextViewCheckSelection(false);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpC = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cbY = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }
}
