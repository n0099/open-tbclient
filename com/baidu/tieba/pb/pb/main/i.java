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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class i extends k<PostData, j> implements View.OnClickListener {
    private int TBDS10;
    private TbRichTextView.h cLe;
    private boolean cNP;
    private com.baidu.tieba.pb.a.c cmw;
    private View.OnLongClickListener cnB;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fBg;
    private com.baidu.adp.lib.e.b<TbImageView> fBh;
    private int hLO;
    private int hLP;
    private int hLQ;
    protected com.baidu.tieba.pb.data.d hPJ;
    private boolean hPK;
    private View.OnClickListener hPT;
    private int hQi;
    private int hQj;
    private TbRichTextView.c hQk;
    private com.baidu.tieba.pb.pb.sub.c hQl;
    private com.baidu.tieba.pb.a.c hQm;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hQx != null && jVar.hQx.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bFY = 5;
                dVar.bGa = 2;
                jVar.hQx.setStatisticData(dVar);
                jVar.hQx.aks();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hLO = 0;
        this.hQi = 0;
        this.hLP = 0;
        this.hQj = 0;
        this.hLQ = 0;
        this.hQk = null;
        this.hPK = true;
        this.mHostId = null;
        this.hPJ = null;
        this.hPT = null;
        this.mCommonClickListener = null;
        this.cLe = null;
        this.cmw = null;
        this.cnB = null;
        this.hQl = null;
        this.cNP = true;
        this.fBg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: boX */
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
        this.fBh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alq */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
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
        this.hQm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hPu == null || i.this.hPu.bUW() == null || i.this.hPu.bUW().bXZ())) {
                    if (view instanceof RelativeLayout) {
                        i.this.cC(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                i.this.cC((RelativeLayout) parent);
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
                if (i.this.cmw != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.cmw.cu(view);
                        i.this.cmw.onSingleTapConfirmed(motionEvent);
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
    /* renamed from: bC */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.hPu.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hQA.setConstrainLayoutPool(this.fBg);
        jVar.hQA.setImageViewPool(this.fBh);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(R.dimen.tbds10);
        this.hLO = getDimensionPixelSize(R.dimen.tbds12);
        this.hQi = getDimensionPixelSize(R.dimen.tbds14);
        this.hLP = getDimensionPixelSize(R.dimen.tbds16);
        this.hQj = getDimensionPixelSize(R.dimen.tbds36);
        this.hLQ = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hQz != null) {
            jVar.hQz.setDuiEnabled(this.cNP);
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
            postData2.afG();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cNP = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.aa(postData.cqw())) {
            int i = 8;
            if (postData.jjv) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.hPJ, postData, postData.locate, i, 6);
            postData.jjw = b;
            Iterator<PostData> it = postData.cqw().iterator();
            while (it.hasNext()) {
                it.next().jjw = b;
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
        if (jVar != null && this.hPu != null && this.hPu.bUE() != null && this.hPu.bUE().bXo() && com.baidu.tbadk.core.util.aq.bV(this.hPu.bUE().bWx(), postData.getId())) {
            com.baidu.tbadk.core.util.am.l(jVar.hQq, R.color.cp_other_g);
        } else {
            jVar.hQq.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hQP.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hQR.setText(R.string.expand_content);
                return;
            } else {
                jVar.hQR.setText(str);
                return;
            }
        }
        jVar.hQP.setVisibility(0);
        jVar.hQR.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.cqL() == 2 || postData.cqL() == 4) {
            jVar.hQQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hQP.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bTG());
                    postData.re(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hPu.bUW() != null && i.this.hPu.bUW().bYZ() != null && i.this.hPu.bUW().getListView() != null && !z && jVar.getView().getTop() < i.this.hPu.bUW().bYZ().getMeasuredHeight()) {
                        i.this.hPu.bUW().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hPu.bUW().getListView().getData(), postData) + i.this.hPu.bUW().getListView().getHeaderViewsCount(), i.this.hPu.bUW().bYZ().getMeasuredHeight());
                    }
                }
            });
            jVar.hQQ.setVisibility(0);
            a(jVar, postData.cqu(), postData.bTG());
            a(true, jVar, postData);
        } else {
            jVar.hQQ.setVisibility(8);
            jVar.hQP.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hQQ != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hQQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.aa(postData.cqw());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hQQ.getLayoutParams();
            if (z) {
                jVar.hQz.getLayoutStrategy().lG(0);
                if (z2) {
                    jVar.hQz.getLayoutStrategy().lF(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hQz.getLayoutStrategy().lF(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hQQ.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hQz.getLayoutStrategy().lF(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hQz.getLayoutStrategy().lG(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cqB = postData.cqB();
        cqB.isChanged = true;
        jVar.hQz.setText(cqB, true, this.hQk);
    }

    private void h(PostData postData) {
        if (postData.bLe == 0 && postData.fDI) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.bT("post_id", postData.getId());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT(DpStatConstants.KEY_CUID, TbadkCoreApplication.getInst().getCuid());
            anVar.bT("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.bT("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.n("exposure_time", System.currentTimeMillis());
            if (this.hPu != null) {
                int bXh = this.hPu.bUE().bXh();
                if (1 == bXh || 2 == bXh) {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bXh) {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hPu.getUniqueId(), this.hPJ, postData, postData.locate, postData.jjv ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.caC() == null) {
            jVar.hQJ.setVisibility(8);
            return;
        }
        TbRichText cqB = postData.cqB();
        com.baidu.tieba.pb.view.b.a(postData.caC(), jVar.hQJ, false, false, cqB != null && StringUtils.isNull(cqB.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hPK) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hQz.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hQz.setLayoutParams(layoutParams);
            jVar.hQz.setPadding(0, 0, 0, 0);
            jVar.hQz.rN(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hQz.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hQz.setLayoutParams(layoutParams2);
            jVar.hQz.rN(postData.getBimg_url());
        }
        jVar.hQz.setTextViewOnTouchListener(this.hQm);
        jVar.hQz.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x07e5  */
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
            if (postData.jjl) {
                com.baidu.tbadk.core.util.am.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hQy.setTag(null);
            jVar.hQy.setUserId(null);
            jVar.epQ.setText((CharSequence) null);
            jVar.hQG.getHeadView().setUserId(null);
            jVar.hQz.setIsHost(false);
            if (postData.aeC() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.aeC().getUserId())) {
                    jVar.hQz.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aeC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aeC().getTShowInfoNew();
                if (jVar.hQI != null) {
                    jVar.hQI.setTag(R.id.tag_user_id, postData.aeC().getUserId());
                    jVar.hQI.setOnClickListener(this.hPu.hNu.iaM);
                    jVar.hQI.a(iconInfo, 2, this.hLQ, this.hLQ, this.TBDS10);
                }
                if (jVar.hQH != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hQH.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hQH.setOnClickListener(this.hPu.hNu.iaN);
                    jVar.hQH.a(tShowInfoNew, 3, this.hLQ, this.hLQ, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || postData.aeC().isBigV()) {
                    com.baidu.tbadk.core.util.am.f(jVar.epQ, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.f(jVar.epQ, R.color.cp_cont_b, 1);
                }
                String portrait = postData.aeC().getPortrait();
                int i2 = 8;
                if (postData.jjv) {
                    i2 = 2;
                }
                jVar.epQ.setTag(R.id.tag_user_id, postData.aeC().getUserId());
                jVar.epQ.setTag(R.id.tag_user_name, postData.aeC().getUserName());
                jVar.epQ.setTag(R.id.tag_virtual_user_url, postData.aeC().getVirtualUserUrl());
                jVar.epQ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hPJ, postData, postData.locate, i2, 2));
                String name_show = postData.aeC().getName_show();
                String userName = postData.aeC().getUserName();
                if (com.baidu.tbadk.t.as.iN() && name_show != null && !name_show.equals(userName)) {
                    jVar.epQ.setText(com.baidu.tieba.pb.c.aL(this.mContext, jVar.epQ.getText().toString()));
                    jVar.epQ.setGravity(16);
                    jVar.epQ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bTh());
                    com.baidu.tbadk.core.util.am.f(jVar.epQ, R.color.cp_other_e, 1);
                }
                if (postData.aeC().getPendantData() != null && !StringUtils.isNull(postData.aeC().getPendantData().acZ())) {
                    jVar.hQG.b(postData.aeC());
                    jVar.hQy.setVisibility(8);
                    jVar.hQG.setVisibility(0);
                    jVar.hQG.getHeadView().startLoad(portrait, 28, false);
                    jVar.hQG.getHeadView().setUserId(postData.aeC().getUserId());
                    jVar.hQG.getHeadView().setUserName(postData.aeC().getUserName());
                    jVar.hQG.getHeadView().setFid(this.hPJ != null ? this.hPJ.getForumId() : "");
                    jVar.hQG.getHeadView().setTid(postData.getId());
                    jVar.hQG.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hPJ, postData, postData.locate, i2, 2));
                    jVar.hQG.oV(postData.aeC().getPendantData().acZ());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hQy, postData.aeC());
                    jVar.hQy.setUserId(postData.aeC().getUserId());
                    jVar.hQy.setFid(this.hPJ != null ? this.hPJ.getForumId() : "");
                    jVar.hQy.setTid(postData.getId());
                    jVar.hQy.setUserName(postData.aeC().getUserName(), postData.cqJ());
                    jVar.hQy.setTag(R.id.tag_virtual_user_url, postData.aeC().getVirtualUserUrl());
                    jVar.hQy.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hPJ, postData, postData.locate, i2, 2));
                    jVar.hQy.setImageDrawable(null);
                    jVar.hQy.startLoad(portrait, 28, false);
                    jVar.hQy.setVisibility(0);
                    jVar.hQG.setVisibility(8);
                }
                if (postData.aeC() != null) {
                    MetaData aeC = postData.aeC();
                    com.baidu.tbadk.core.util.am.j(jVar.hQs, R.color.cp_cont_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(aeC.getUserId())) {
                        int in = com.baidu.tbadk.core.util.am.in(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.am.k(jVar.hQs, in);
                        jVar.hQs.setTag(Integer.valueOf(in));
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.host_name);
                    } else if (aeC.getIs_bawu() == 1 && postData.cqr()) {
                        com.baidu.tbadk.core.util.am.k(jVar.hQs, R.drawable.brand_official_btn);
                        jVar.hQs.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.brand_Official);
                    } else if (aeC.getIs_bawu() == 1 && "manager".equals(aeC.getBawu_type())) {
                        int in2 = com.baidu.tbadk.core.util.am.in(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.am.k(jVar.hQs, in2);
                        jVar.hQs.setTag(Integer.valueOf(in2));
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aeC.getIs_bawu() == 1 && "assist".equals(aeC.getBawu_type())) {
                        int in3 = com.baidu.tbadk.core.util.am.in(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.am.k(jVar.hQs, in3);
                        jVar.hQs.setTag(Integer.valueOf(in3));
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aeC.getIs_bawu() == 1 && "pri_content_assist".equals(aeC.getBawu_type())) {
                        int in4 = com.baidu.tbadk.core.util.am.in(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.k(jVar.hQs, in4);
                        jVar.hQs.setTag(Integer.valueOf(in4));
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_content_assist_tip);
                    } else if (aeC.getIs_bawu() == 1 && "pri_manage_assist".equals(aeC.getBawu_type())) {
                        int in5 = com.baidu.tbadk.core.util.am.in(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.k(jVar.hQs, in5);
                        jVar.hQs.setTag(Integer.valueOf(in5));
                        jVar.hQs.setVisibility(0);
                        jVar.hQs.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hQs.setVisibility(8);
                        jVar.hQs.setTag(null);
                    }
                } else {
                    jVar.hQs.setVisibility(8);
                    jVar.hQs.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hPu.bUu()) {
                if (postData.aeC() != null) {
                    i3 = postData.aeC().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hQF.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(jVar.hQF, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hQF.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hQI.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hQI.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hQs.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hQH.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.afW() > 1000) {
                i4 -= 2;
            }
            if (postData.afW() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hQI.setVisibility(8);
                if (jVar.hQI.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hQI.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hQs.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hQs.setVisibility(8);
                }
                if (i4 < 10 && jVar.hQF.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hQF.setVisibility(8);
                }
            }
            String name_show2 = postData.aeC() != null ? postData.aeC().getName_show() : "";
            int rz = com.baidu.tbadk.util.aa.rz(name_show2);
            if (postData.aeC() != null && !StringUtils.isNull(postData.aeC().getSealPrefix())) {
                if (rz > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.aa.ad(name_show2, i4 - 2) + "...";
                }
            } else if (rz > i4) {
                name_show2 = com.baidu.tbadk.util.aa.ad(name_show2, i4) + "...";
            }
            if (postData.aeC() != null && !StringUtils.isNull(postData.aeC().getSealPrefix())) {
                jVar.epQ.setText(bY(postData.aeC().getSealPrefix(), name_show2));
            } else {
                jVar.epQ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cqz()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aeC() != null && !StringUtils.isNull(postData.aeC().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hPJ != null && this.hPJ.bTK() != 0) {
                if (this.hPJ.bTK() != 1002 && this.hPJ.bTK() != 3) {
                    z10 = true;
                }
                if (this.hPJ.bTK() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.aeC() != null) {
                    String userId2 = postData.aeC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTy().aeC() != null && postData.aeC() != null) {
                            userId = this.hPJ.bTy().aeC().getUserId();
                            String userId3 = postData.aeC().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aeC() != null && UtilHelper.isCurrentAccount(postData.aeC().getUserId())) {
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
                                if (postData.cqz() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hPJ.bTK()));
                                    if (postData.aeC() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aeC().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aeC().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aeC().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aeC() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aeC().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aeC().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aeC().getName_show());
                                    }
                                    if (this.hPJ.bTy() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hPJ.bTy().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hPJ.bTK()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hQz.setTag(sparseArray);
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
                        if (postData.cqz() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hQz.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hPJ != null) {
                userId = this.hPJ.bTy().aeC().getUserId();
                String userId32 = postData.aeC().getUserId();
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
            if (postData.cqz() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hQz.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.ags() != null) {
            postData.ags().threadId = this.hPu.bUE().bWy();
            postData.ags().objType = 1;
            postData.ags().isInPost = true;
            jVar.hQx.setData(postData.ags());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cqz() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cqz()));
                jVar.hQE.setVisibility(0);
                jVar.hQE.setText(format);
                z = true;
            } else {
                jVar.hQE.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cqC = postData.cqC();
            boolean z2 = (cqC == null || StringUtils.isNull(cqC.getName())) ? false : true;
            if (z) {
                jVar.hQu.setVisibility(0);
                i = this.hQi;
            } else {
                jVar.hQu.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hQv.setVisibility(0);
                i2 = this.hQi;
            } else {
                jVar.hQv.setVisibility(8);
                i2 = 0;
            }
            jVar.hQt.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hQt.setText(com.baidu.tbadk.core.util.aq.aF(postData.getTime()));
            } else {
                jVar.hQt.setText(com.baidu.tbadk.core.util.aq.aD(postData.getTime()));
            }
            if (z2) {
                jVar.hQw.setVisibility(0);
                jVar.hQw.setPadding(this.hQi, 0, 0, 0);
                if (postData.jjt) {
                    jVar.hQw.setText(com.baidu.tbadk.core.util.aq.i(cqC.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hQw.setText(cqC.getName());
                    return;
                }
            }
            jVar.hQw.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hQz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hQz.setPadding(0, 0, 0, 0);
            if (!this.hPK) {
                jVar.hQz.getLayoutStrategy().lA(R.drawable.icon_click);
            } else {
                jVar.hQz.rN(null);
                jVar.hQz.setBackgroundDrawable(null);
                jVar.hQz.getLayoutStrategy().lA(R.drawable.transparent_bg);
            }
            jVar.hQz.getLayoutStrategy().lx(R.drawable.pic_video);
            a(jVar.hQz, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hQz.setLayoutParams(layoutParams);
            jVar.hQz.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            jVar.hQz.setIsFromCDN(this.mIsFromCDN);
            TbRichText cqB = postData.cqB();
            jVar.hQz.setIsUseGridImage(postData.cqM());
            jVar.hQz.setText(cqB, true, this.hQk);
            SparseArray sparseArray = (SparseArray) jVar.hQz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hQz.setTag(sparseArray);
            jVar.hQq.setTag(R.id.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int af = (((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                af = (af - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().ly(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cMQ = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lz((int) (af * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cqD() > 0) {
                jVar.hQD.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hQD.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hQD.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cqL() == 2) {
                    jVar.hQD.setVisibility(8);
                } else {
                    jVar.hQD.setVisibility(0);
                }
                jVar.hQC.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cqD() > 0) {
                    jVar.hQC.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cqD())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hQC.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hQC.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hQC.setVisibility(0);
                    jVar.hQD.setVisibility(8);
                    jVar.hQB.setVisibility(8);
                }
            } else {
                jVar.hQC.setVisibility(8);
                if (postData.cqD() > 0 && postData.cqw() != null && postData.cqw().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hQB.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hQB.setLayoutParams(layoutParams);
                    if (this.hQl == null) {
                        this.hQl = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hQl.setIsFromCDN(this.mIsFromCDN);
                        this.hQl.setOnLongClickListener(this.cnB);
                        this.hQl.Q(this.hPT);
                        this.hQl.v(this.mCommonClickListener);
                        String str = null;
                        if (this.hPJ != null && this.hPJ.bTy() != null && this.hPJ.bTy().aeC() != null) {
                            str = this.hPJ.bTy().aeC().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hPJ != null) {
                            this.hQl.P(this.hPJ.bTK(), z);
                            this.hQl.ak(this.hPJ.bTy());
                        }
                    }
                    this.hQl.CP(postData.getId());
                    jVar.hQB.setSubPbAdapter(this.hQl);
                    jVar.hQB.setVisibility(0);
                    jVar.hQB.setData(postData, view);
                    jVar.hQB.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hQB.setChildOnLongClickListener(this.cnB);
                    jVar.hQB.setChildOnTouchListener(this.hQm);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hQB.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hQB.setLayoutParams(layoutParams2);
                    jVar.hQB.setVisibility(8);
                }
            }
            if (postData.jjk) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hQN != null && jVar.hQK != null) {
            if (postData == null || postData.jjn == null || StringUtils.isNull(postData.jjn.liveTitle)) {
                jVar.hQK.setVisibility(8);
                return;
            }
            jVar.hQN.setText(postData.jjn.liveTitle);
            jVar.hQK.setTag(postData.jjn);
            jVar.hQK.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hQS.setVisibility(postData.jjt ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.f(jVar.epQ, R.color.cp_cont_b, 1);
                if (jVar.hQs.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.k(jVar.hQs, ((Integer) jVar.hQs.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.f(jVar.hQt, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.j(jVar.hQu, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.j(jVar.hQv, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.f(jVar.hQE, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.f(jVar.hQw, R.color.cp_cont_d, 1);
                jVar.hQz.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.l(jVar.hQB, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.j(jVar.hQC, R.color.cp_cont_c);
                jVar.hQC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.j(jVar.hQD, R.color.cp_cont_c);
                jVar.hQB.onChangeSkinType();
                jVar.hQA.onChangeSkinType();
                com.baidu.tbadk.core.util.am.f(jVar.hQN, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.f(jVar.hQL, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.k(jVar.hQK, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.k(jVar.hQM, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.c(jVar.hQO, (int) R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.j(jVar.hQR, R.color.cp_cont_c);
                if (jVar.hQP.getVisibility() == 8) {
                    jVar.hQR.setText(R.string.close_content);
                } else if (this.hPJ != null && StringUtils.isNull(this.hPJ.bTG())) {
                    jVar.hQR.setText(this.hPJ.bTG());
                } else {
                    jVar.hQR.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hQq.setOnTouchListener(this.hQm);
        jVar.hQq.setOnLongClickListener(this.cnB);
        if (this.hPu.getPageContext() != null && this.hPu.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hPu.getPageContext().getOrignalPage()).hNu;
            jVar.epQ.setOnClickListener(aVar.fYB);
            jVar.hQy.setOnClickListener(aVar.fYB);
            jVar.hQG.setOnClickListener(aVar.fYB);
            jVar.hQG.getHeadView().setOnClickListener(aVar.fYB);
            jVar.hQz.setOnLongClickListener(this.cnB);
            jVar.hQz.setOnTouchListener(this.hQm);
            jVar.hQz.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hQz.setOnImageClickListener(this.cLe);
            jVar.hQz.setOnImageTouchListener(this.hQm);
            jVar.hQz.setOnEmotionClickListener(aVar.iaO);
            jVar.hQz.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hQJ.setOnClickListener(this.mCommonClickListener);
            jVar.hQK.setOnClickListener(this.mCommonClickListener);
            jVar.hQC.setOnClickListener(this.mCommonClickListener);
            jVar.hQD.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hQk = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hPJ = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void ok(boolean z) {
        this.hPK = z;
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hPu.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hQz.setTextViewOnTouchListener(this.cmw);
        jVar.hQz.setTextViewCheckSelection(false);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hPT = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cLe = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cmw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnB = onLongClickListener;
    }
}
