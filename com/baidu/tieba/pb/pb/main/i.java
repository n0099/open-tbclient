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
    private int hlt;
    private int hlu;
    private int hlv;
    private View.OnClickListener hpB;
    private int hpQ;
    private int hpR;
    private TbRichTextView.c hpS;
    private com.baidu.tieba.pb.pb.sub.c hpT;
    private com.baidu.tieba.pb.a.c hpU;
    protected com.baidu.tieba.pb.data.d hpr;
    private boolean hps;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hqf != null && jVar.hqf.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bxh = 5;
                dVar.bxj = 2;
                jVar.hqf.setStatisticData(dVar);
                jVar.hqf.aee();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hlt = 0;
        this.hpQ = 0;
        this.hlu = 0;
        this.hpR = 0;
        this.hlv = 0;
        this.hpS = null;
        this.hps = true;
        this.mHostId = null;
        this.hpr = null;
        this.hpB = null;
        this.mCommonClickListener = null;
        this.cAE = null;
        this.cbY = null;
        this.cdd = null;
        this.hpT = null;
        this.cDp = true;
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
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
        this.hpU = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hpc == null || i.this.hpc.bJq() == null || i.this.hpc.bJq().bMq())) {
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
        j jVar = new j(this.hpc.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hqi.setConstrainLayoutPool(this.fdX);
        jVar.hqi.setImageViewPool(this.fdY);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(d.e.tbds10);
        this.hlt = getDimensionPixelSize(d.e.tbds12);
        this.hpQ = getDimensionPixelSize(d.e.tbds14);
        this.hlu = getDimensionPixelSize(d.e.tbds16);
        this.hpR = getDimensionPixelSize(d.e.tbds36);
        this.hlv = getDimensionPixelSize(d.e.tbds40);
        if (jVar.hqh != null) {
            jVar.hqh.setDuiEnabled(this.cDp);
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
        if (postData != null && !com.baidu.tbadk.core.util.v.T(postData.cen())) {
            int i = 8;
            if (postData.iHc) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hpr, postData, postData.locate, i, 6);
            postData.iHd = b;
            Iterator<PostData> it = postData.cen().iterator();
            while (it.hasNext()) {
                it.next().iHd = b;
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
        if (jVar != null && this.hpc != null && this.hpc.bJa() != null && this.hpc.bJa().bLG() && com.baidu.tbadk.core.util.ap.equals(this.hpc.bJa().bKQ(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hpY, d.C0236d.cp_other_g);
        } else {
            jVar.hpY.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hqx.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hqz.setText(d.j.expand_content);
                return;
            } else {
                jVar.hqz.setText(str);
                return;
            }
        }
        jVar.hqx.setVisibility(0);
        jVar.hqz.setText(d.j.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.ceC() == 2 || postData.ceC() == 4) {
            jVar.hqy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hqx.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bIh());
                    postData.pV(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hpc.bJq() != null && i.this.hpc.bJq().bNn() != null && i.this.hpc.bJq().getListView() != null && !z && jVar.getView().getTop() < i.this.hpc.bJq().bNn().getMeasuredHeight()) {
                        i.this.hpc.bJq().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hpc.bJq().getListView().getData(), postData) + i.this.hpc.bJq().getListView().getHeaderViewsCount(), i.this.hpc.bJq().bNn().getMeasuredHeight());
                    }
                }
            });
            jVar.hqy.setVisibility(0);
            a(jVar, postData.cel(), postData.bIh());
            a(true, jVar, postData);
        } else {
            jVar.hqy.setVisibility(8);
            jVar.hqx.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hqy != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hqy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.T(postData.cen());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hqy.getLayoutParams();
            if (z) {
                jVar.hqh.getLayoutStrategy().kH(0);
                if (z2) {
                    jVar.hqh.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds26);
                    }
                } else {
                    jVar.hqh.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hqy.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hqh.getLayoutStrategy().kG(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds30));
            jVar.hqh.getLayoutStrategy().kH(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText ces = postData.ces();
        ces.isChanged = true;
        jVar.hqh.setText(ces, true, this.hpS);
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
            if (this.hpc != null) {
                int bLz = this.hpc.bJa().bLz();
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
        com.baidu.tieba.pb.c.a.a(this.hpc.getUniqueId(), this.hpr, postData, postData.locate, postData.iHc ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bON() == null) {
            jVar.hqr.setVisibility(8);
            return;
        }
        TbRichText ces = postData.ces();
        com.baidu.tieba.pb.view.b.a(postData.bON(), jVar.hqr, false, false, ces != null && StringUtils.isNull(ces.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hps) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqh.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hqh.setLayoutParams(layoutParams);
            jVar.hqh.setPadding(0, 0, 0, 0);
            jVar.hqh.qc(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqh.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(d.e.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(d.e.ds20);
            jVar.hqh.setLayoutParams(layoutParams2);
            jVar.hqh.qc(postData.getBimg_url());
        }
        jVar.hqh.setTextViewOnTouchListener(this.hpU);
        jVar.hqh.setTextViewCheckSelection(false);
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
            if (postData.iGS) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, d.C0236d.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hqg.setTag(null);
            jVar.hqg.setUserId(null);
            jVar.dZy.setText((CharSequence) null);
            jVar.hqo.getHeadView().setUserId(null);
            jVar.hqh.setIsHost(false);
            if (postData.YR() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.YR().getUserId())) {
                    jVar.hqh.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.YR().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.YR().getTShowInfoNew();
                if (jVar.hqq != null) {
                    jVar.hqq.setTag(d.g.tag_user_id, postData.YR().getUserId());
                    jVar.hqq.setOnClickListener(this.hpc.hnd.hAk);
                    jVar.hqq.a(iconInfo, 2, this.hlv, this.hlv, this.TBDS10);
                }
                if (jVar.hqp != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hqp.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hqp.setOnClickListener(this.hpc.hnd.hAl);
                    jVar.hqp.a(tShowInfoNew, 3, this.hlv, this.hlv, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.T(tShowInfoNew) || postData.YR().isBigV()) {
                    com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_cont_b, 1);
                }
                String portrait = postData.YR().getPortrait();
                int i2 = 8;
                if (postData.iHc) {
                    i2 = 2;
                }
                jVar.dZy.setTag(d.g.tag_user_id, postData.YR().getUserId());
                jVar.dZy.setTag(d.g.tag_user_name, postData.YR().getUserName());
                jVar.dZy.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                jVar.dZy.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hpr, postData, postData.locate, i2, 2));
                String name_show = postData.YR().getName_show();
                String userName = postData.YR().getUserName();
                if (com.baidu.tbadk.s.ao.jK() && name_show != null && !name_show.equals(userName)) {
                    jVar.dZy.setText(com.baidu.tieba.pb.c.aQ(this.mContext, jVar.dZy.getText().toString()));
                    jVar.dZy.setGravity(16);
                    jVar.dZy.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHK());
                    com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_other_e, 1);
                }
                if (postData.YR().getPendantData() != null && !StringUtils.isNull(postData.YR().getPendantData().Xn())) {
                    jVar.hqo.b(postData.YR());
                    jVar.hqg.setVisibility(8);
                    jVar.hqo.setVisibility(0);
                    jVar.hqo.getHeadView().startLoad(portrait, 28, false);
                    jVar.hqo.getHeadView().setUserId(postData.YR().getUserId());
                    jVar.hqo.getHeadView().setUserName(postData.YR().getUserName());
                    jVar.hqo.getHeadView().setFid(this.hpr != null ? this.hpr.getForumId() : "");
                    jVar.hqo.getHeadView().setTid(postData.getId());
                    jVar.hqo.getHeadView().setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hpr, postData, postData.locate, i2, 2));
                    jVar.hqo.nm(postData.YR().getPendantData().Xn());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hqg, postData.YR());
                    jVar.hqg.setUserId(postData.YR().getUserId());
                    jVar.hqg.setFid(this.hpr != null ? this.hpr.getForumId() : "");
                    jVar.hqg.setTid(postData.getId());
                    jVar.hqg.setUserName(postData.YR().getUserName(), postData.ceA());
                    jVar.hqg.setTag(d.g.tag_virtual_user_url, postData.YR().getVirtualUserUrl());
                    jVar.hqg.setTag(d.g.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hpr, postData, postData.locate, i2, 2));
                    jVar.hqg.setImageDrawable(null);
                    jVar.hqg.startLoad(portrait, 28, false);
                    jVar.hqg.setVisibility(0);
                    jVar.hqo.setVisibility(8);
                }
                if (postData.YR() != null) {
                    MetaData YR = postData.YR();
                    int hu = postData.cei() ? d.f.brand_official_btn : com.baidu.tbadk.core.util.al.hu(d.f.bg_user_identity_btn);
                    int hu2 = postData.cei() ? d.C0236d.cp_btn_a : com.baidu.tbadk.core.util.al.hu(d.C0236d.cp_bg_line_d);
                    com.baidu.tbadk.core.util.al.k(jVar.hqa, hu);
                    com.baidu.tbadk.core.util.al.j(jVar.hqa, hu2);
                    jVar.hqa.setTag(Integer.valueOf(hu));
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(YR.getUserId())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.host_name);
                    } else if (YR.getIs_bawu() == 1 && postData.cei()) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.brand_Official);
                    } else if (YR.getIs_bawu() == 1 && "manager".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_member_bazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "assist".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_member_xbazhu_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_content_assist".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_content_assist_tip);
                    } else if (YR.getIs_bawu() == 1 && "pri_manage_assist".equals(YR.getBawu_type())) {
                        jVar.hqa.setVisibility(0);
                        jVar.hqa.setText(d.j.bawu_manage_assist_tip);
                    } else {
                        jVar.hqa.setVisibility(8);
                        jVar.hqa.setTag(null);
                    }
                } else {
                    jVar.hqa.setVisibility(8);
                    jVar.hqa.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hpc.bIQ()) {
                if (postData.YR() != null) {
                    i3 = postData.YR().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hqn.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hqn, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hqn.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hqq.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hqq.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hqa.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hqp.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aal() > 1000) {
                i4 -= 2;
            }
            if (postData.aal() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hqq.setVisibility(8);
                if (jVar.hqq.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hqq.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hqa.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hqa.setVisibility(8);
                }
                if (i4 < 10 && jVar.hqn.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hqn.setVisibility(8);
                }
            }
            String name_show2 = postData.YR() != null ? postData.YR().getName_show() : "";
            int pO = com.baidu.tbadk.util.ab.pO(name_show2);
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getSealPrefix())) {
                if (pO > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ah(name_show2, i4 - 2) + "...";
                }
            } else if (pO > i4) {
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
            sparseArray.put(d.g.tag_pb_floor_number, Integer.valueOf(postData.ceq()));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.YR() != null && !StringUtils.isNull(postData.YR().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hpr != null && this.hpr.bIl() != 0) {
                if (this.hpr.bIl() != 1002 && this.hpr.bIl() != 3) {
                    z10 = true;
                }
                if (this.hpr.bIl() != 3) {
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
                        if (this.hpr != null && this.hpr.bHZ() != null && this.hpr.bHZ().YR() != null && postData.YR() != null) {
                            userId = this.hpr.bHZ().YR().getUserId();
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
                                if (postData.ceq() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(d.g.tag_should_manage_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hpr.bIl()));
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
                                    if (this.hpr.bHZ() != null) {
                                        sparseArray.put(d.g.tag_user_mute_thread_id, this.hpr.bHZ().getId());
                                    }
                                    sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(d.g.tag_should_delete_visible, true);
                                    sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(this.hpr.bIl()));
                                    sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(d.g.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(d.g.tag_should_delete_visible, false);
                                }
                                jVar.hqh.setTag(sparseArray);
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
                        if (postData.ceq() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hqh.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hpr != null) {
                userId = this.hpr.bHZ().YR().getUserId();
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
            if (postData.ceq() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hqh.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.aaH() != null) {
            postData.aaH().threadId = this.hpc.bJa().bKR();
            postData.aaH().objType = 1;
            postData.aaH().isInPost = true;
            jVar.hqf.setData(postData.aaH());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.ceq() > 0) {
                String format = String.format(this.mContext.getString(d.j.is_floor), Integer.valueOf(postData.ceq()));
                jVar.hqm.setVisibility(0);
                jVar.hqm.setText(format);
                z = true;
            } else {
                jVar.hqm.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cet = postData.cet();
            boolean z2 = (cet == null || StringUtils.isNull(cet.getName())) ? false : true;
            if (z) {
                jVar.hqc.setVisibility(0);
                i = this.hpQ;
            } else {
                jVar.hqc.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hqd.setVisibility(0);
                i2 = this.hpQ;
            } else {
                jVar.hqd.setVisibility(8);
                i2 = 0;
            }
            jVar.hqb.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hqb.setText(com.baidu.tbadk.core.util.ap.aq(postData.getTime()));
            } else {
                jVar.hqb.setText(com.baidu.tbadk.core.util.ap.ao(postData.getTime()));
            }
            if (z2) {
                final String name = cet.getName();
                final String lat = cet.getLat();
                final String lng = cet.getLng();
                jVar.hqe.setVisibility(0);
                jVar.hqe.setPadding(this.hpQ, 0, 0, 0);
                if (postData.iHa) {
                    jVar.hqe.setText(com.baidu.tbadk.core.util.ap.f(cet.getName(), 7, "..."));
                } else {
                    jVar.hqe.setText(cet.getName());
                }
                jVar.hqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                            if (com.baidu.adp.lib.util.j.kY()) {
                                com.baidu.tbadk.browser.a.ar(i.this.mContext, String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, i.this.mContext.getString(d.j.app_info_for_map)));
                            } else {
                                i.this.hpc.showToast(d.j.neterror);
                            }
                        }
                    }
                });
                return;
            }
            jVar.hqe.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqh.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hqh.setPadding(0, 0, 0, 0);
            if (!this.hps) {
                jVar.hqh.getLayoutStrategy().kB(d.f.icon_click);
            } else {
                jVar.hqh.qc(null);
                jVar.hqh.setBackgroundDrawable(null);
                jVar.hqh.getLayoutStrategy().kB(d.f.transparent_bg);
            }
            jVar.hqh.getLayoutStrategy().ky(d.f.pic_video);
            a(jVar.hqh, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hqh.setLayoutParams(layoutParams);
            jVar.hqh.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_link_tip_c));
            jVar.hqh.setIsFromCDN(this.mIsFromCDN);
            TbRichText ces = postData.ces();
            jVar.hqh.setIsUseGridImage(postData.ceD());
            jVar.hqh.setText(ces, true, this.hpS);
            SparseArray sparseArray = (SparseArray) jVar.hqh.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            jVar.hqh.setTag(sparseArray);
            jVar.hpY.setTag(d.g.tag_from, sparseArray);
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
            if (postData.ceu() > 0) {
                jVar.hql.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hql.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hql.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_load_sub_data, postData);
                if (postData.ceC() == 2) {
                    jVar.hql.setVisibility(8);
                } else {
                    jVar.hql.setVisibility(0);
                }
                jVar.hqk.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.ceu() > 0) {
                    jVar.hqk.setText(TbadkCoreApplication.getInst().getResources().getString(d.j.sub_pb_load_more, Integer.valueOf(postData.ceu())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hqk.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hqk.setTag(sparseArray2);
                    }
                    sparseArray2.put(d.g.tag_load_sub_data, postData);
                    jVar.hqk.setVisibility(0);
                    jVar.hql.setVisibility(8);
                    jVar.hqj.setVisibility(8);
                }
            } else {
                jVar.hqk.setVisibility(8);
                if (postData.ceu() > 0 && postData.cen() != null && postData.cen().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hqj.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hqj.setLayoutParams(layoutParams);
                    if (this.hpT == null) {
                        this.hpT = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hpT.setIsFromCDN(this.mIsFromCDN);
                        this.hpT.setOnLongClickListener(this.cdd);
                        this.hpT.M(this.hpB);
                        this.hpT.t(this.mCommonClickListener);
                        String str = null;
                        if (this.hpr != null && this.hpr.bHZ() != null && this.hpr.bHZ().YR() != null) {
                            str = this.hpr.bHZ().YR().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hpr != null) {
                            this.hpT.H(this.hpr.bIl(), z);
                            this.hpT.aj(this.hpr.bHZ());
                        }
                    }
                    this.hpT.An(postData.getId());
                    jVar.hqj.setSubPbAdapter(this.hpT);
                    jVar.hqj.setVisibility(0);
                    jVar.hqj.setData(postData, view);
                    jVar.hqj.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hqj.setChildOnLongClickListener(this.cdd);
                    jVar.hqj.setChildOnTouchListener(this.hpU);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hqj.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hqj.setLayoutParams(layoutParams2);
                    jVar.hqj.setVisibility(8);
                }
            }
            if (postData.iGR) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hqv != null && jVar.hqs != null) {
            if (postData == null || postData.iGU == null || StringUtils.isNull(postData.iGU.liveTitle)) {
                jVar.hqs.setVisibility(8);
                return;
            }
            jVar.hqv.setText(postData.iGU.liveTitle);
            jVar.hqs.setTag(postData.iGU);
            jVar.hqs.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hqA.setVisibility(postData.iHa ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.d(jVar.dZy, d.C0236d.cp_cont_b, 1);
                if (jVar.hqa.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hqa, ((Integer) jVar.hqa.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.d(jVar.hqb, d.C0236d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hqc, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hqd, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.d(jVar.hqm, d.C0236d.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hqe, d.C0236d.cp_cont_d, 1);
                jVar.hqh.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hqj, d.C0236d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hqk, d.C0236d.cp_cont_c);
                jVar.hqk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hql, d.C0236d.cp_cont_c);
                jVar.hqj.onChangeSkinType();
                jVar.hqi.onChangeSkinType();
                com.baidu.tbadk.core.util.al.d(jVar.hqv, d.C0236d.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.d(jVar.hqt, d.C0236d.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hqs, d.C0236d.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hqu, d.C0236d.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hqw, d.f.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hqz, d.C0236d.cp_cont_c);
                if (jVar.hqx.getVisibility() == 8) {
                    jVar.hqz.setText(d.j.close_content);
                } else if (this.hpr != null && StringUtils.isNull(this.hpr.bIh())) {
                    jVar.hqz.setText(this.hpr.bIh());
                } else {
                    jVar.hqz.setText(d.j.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hpY.setOnTouchListener(this.hpU);
        jVar.hpY.setOnLongClickListener(this.cdd);
        if (this.hpc.getPageContext() != null && this.hpc.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hpc.getPageContext().getOrignalPage()).hnd;
            jVar.dZy.setOnClickListener(aVar.fAk);
            jVar.hqg.setOnClickListener(aVar.fAk);
            jVar.hqo.setOnClickListener(aVar.fAk);
            jVar.hqo.getHeadView().setOnClickListener(aVar.fAk);
            jVar.hqh.setOnLongClickListener(this.cdd);
            jVar.hqh.setOnTouchListener(this.hpU);
            jVar.hqh.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hqh.setOnImageClickListener(this.cAE);
            jVar.hqh.setOnImageTouchListener(this.hpU);
            jVar.hqh.setOnEmotionClickListener(aVar.hAm);
            jVar.hqh.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hqr.setOnClickListener(this.mCommonClickListener);
            jVar.hqs.setOnClickListener(this.mCommonClickListener);
            jVar.hqk.setOnClickListener(this.mCommonClickListener);
            jVar.hql.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hpS = cVar;
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hpr = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nc(boolean z) {
        this.hps = z;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hpc.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hqh.setTextViewOnTouchListener(this.cbY);
        jVar.hqh.setTextViewCheckSelection(false);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpB = onClickListener;
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
