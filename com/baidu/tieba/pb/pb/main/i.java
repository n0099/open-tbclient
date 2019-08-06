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
    private TbRichTextView.h cKo;
    private boolean cMZ;
    private com.baidu.tieba.pb.a.c clA;
    private View.OnLongClickListener cmF;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fzt;
    private com.baidu.adp.lib.e.b<TbImageView> fzu;
    private int hJR;
    private int hJS;
    private int hJT;
    protected com.baidu.tieba.pb.data.d hNM;
    private boolean hNN;
    private View.OnClickListener hNW;
    private int hOl;
    private int hOm;
    private TbRichTextView.c hOn;
    private com.baidu.tieba.pb.pb.sub.c hOo;
    private com.baidu.tieba.pb.a.c hOp;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hOA != null && jVar.hOA.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bFA = 5;
                dVar.bFC = 2;
                jVar.hOA.setStatisticData(dVar);
                jVar.hOA.akg();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hJR = 0;
        this.hOl = 0;
        this.hJS = 0;
        this.hOm = 0;
        this.hJT = 0;
        this.hOn = null;
        this.hNN = true;
        this.mHostId = null;
        this.hNM = null;
        this.hNW = null;
        this.mCommonClickListener = null;
        this.cKo = null;
        this.clA = null;
        this.cmF = null;
        this.hOo = null;
        this.cMZ = true;
        this.fzt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bom */
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
        this.fzu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ale */
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
        this.hOp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hNx == null || i.this.hNx.bUj() == null || i.this.hNx.bUj().bXm())) {
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
                if (i.this.clA != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.clA.cu(view);
                        i.this.clA.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.hNx.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hOD.setConstrainLayoutPool(this.fzt);
        jVar.hOD.setImageViewPool(this.fzu);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(R.dimen.tbds10);
        this.hJR = getDimensionPixelSize(R.dimen.tbds12);
        this.hOl = getDimensionPixelSize(R.dimen.tbds14);
        this.hJS = getDimensionPixelSize(R.dimen.tbds16);
        this.hOm = getDimensionPixelSize(R.dimen.tbds36);
        this.hJT = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hOC != null) {
            jVar.hOC.setDuiEnabled(this.cMZ);
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
            postData2.afC();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cMZ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.aa(postData.cpI())) {
            int i = 8;
            if (postData.jgZ) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.hNM, postData, postData.locate, i, 6);
            postData.jha = b;
            Iterator<PostData> it = postData.cpI().iterator();
            while (it.hasNext()) {
                it.next().jha = b;
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
        if (jVar != null && this.hNx != null && this.hNx.bTR() != null && this.hNx.bTR().bWB() && com.baidu.tbadk.core.util.aq.bV(this.hNx.bTR().bVK(), postData.getId())) {
            com.baidu.tbadk.core.util.am.l(jVar.hOt, R.color.cp_other_g);
        } else {
            jVar.hOt.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hOS.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hOU.setText(R.string.expand_content);
                return;
            } else {
                jVar.hOU.setText(str);
                return;
            }
        }
        jVar.hOS.setVisibility(0);
        jVar.hOU.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.cpX() == 2 || postData.cpX() == 4) {
            jVar.hOT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hOS.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bST());
                    postData.rb(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hNx.bUj() != null && i.this.hNx.bUj().bYm() != null && i.this.hNx.bUj().getListView() != null && !z && jVar.getView().getTop() < i.this.hNx.bUj().bYm().getMeasuredHeight()) {
                        i.this.hNx.bUj().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hNx.bUj().getListView().getData(), postData) + i.this.hNx.bUj().getListView().getHeaderViewsCount(), i.this.hNx.bUj().bYm().getMeasuredHeight());
                    }
                }
            });
            jVar.hOT.setVisibility(0);
            a(jVar, postData.cpG(), postData.bST());
            a(true, jVar, postData);
        } else {
            jVar.hOT.setVisibility(8);
            jVar.hOS.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hOT != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hOT.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.aa(postData.cpI());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hOT.getLayoutParams();
            if (z) {
                jVar.hOC.getLayoutStrategy().lC(0);
                if (z2) {
                    jVar.hOC.getLayoutStrategy().lB(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hOC.getLayoutStrategy().lB(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hOT.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hOC.getLayoutStrategy().lB(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hOC.getLayoutStrategy().lC(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cpN = postData.cpN();
        cpN.isChanged = true;
        jVar.hOC.setText(cpN, true, this.hOn);
    }

    private void h(PostData postData) {
        if (postData.bKG == 0 && postData.fBV) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.bT("post_id", postData.getId());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.bT("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.bT("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.l("exposure_time", System.currentTimeMillis());
            if (this.hNx != null) {
                int bWu = this.hNx.bTR().bWu();
                if (1 == bWu || 2 == bWu) {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bWu) {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hNx.getUniqueId(), this.hNM, postData, postData.locate, postData.jgZ ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bZO() == null) {
            jVar.hOM.setVisibility(8);
            return;
        }
        TbRichText cpN = postData.cpN();
        com.baidu.tieba.pb.view.b.a(postData.bZO(), jVar.hOM, false, false, cpN != null && StringUtils.isNull(cpN.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hNN) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hOC.setLayoutParams(layoutParams);
            jVar.hOC.setPadding(0, 0, 0, 0);
            jVar.hOC.rC(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hOC.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hOC.setLayoutParams(layoutParams2);
            jVar.hOC.rC(postData.getBimg_url());
        }
        jVar.hOC.setTextViewOnTouchListener(this.hOp);
        jVar.hOC.setTextViewCheckSelection(false);
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
            if (postData.jgP) {
                com.baidu.tbadk.core.util.am.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hOB.setTag(null);
            jVar.hOB.setUserId(null);
            jVar.eog.setText((CharSequence) null);
            jVar.hOJ.getHeadView().setUserId(null);
            jVar.hOC.setIsHost(false);
            if (postData.aey() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.aey().getUserId())) {
                    jVar.hOC.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aey().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aey().getTShowInfoNew();
                if (jVar.hOL != null) {
                    jVar.hOL.setTag(R.id.tag_user_id, postData.aey().getUserId());
                    jVar.hOL.setOnClickListener(this.hNx.hLx.hYP);
                    jVar.hOL.a(iconInfo, 2, this.hJT, this.hJT, this.TBDS10);
                }
                if (jVar.hOK != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hOK.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hOK.setOnClickListener(this.hNx.hLx.hYQ);
                    jVar.hOK.a(tShowInfoNew, 3, this.hJT, this.hJT, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || postData.aey().isBigV()) {
                    com.baidu.tbadk.core.util.am.f(jVar.eog, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.f(jVar.eog, R.color.cp_cont_b, 1);
                }
                String portrait = postData.aey().getPortrait();
                int i2 = 8;
                if (postData.jgZ) {
                    i2 = 2;
                }
                jVar.eog.setTag(R.id.tag_user_id, postData.aey().getUserId());
                jVar.eog.setTag(R.id.tag_user_name, postData.aey().getUserName());
                jVar.eog.setTag(R.id.tag_virtual_user_url, postData.aey().getVirtualUserUrl());
                jVar.eog.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hNM, postData, postData.locate, i2, 2));
                String name_show = postData.aey().getName_show();
                String userName = postData.aey().getUserName();
                if (com.baidu.tbadk.t.as.iN() && name_show != null && !name_show.equals(userName)) {
                    jVar.eog.setText(com.baidu.tieba.pb.c.aE(this.mContext, jVar.eog.getText().toString()));
                    jVar.eog.setGravity(16);
                    jVar.eog.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSu());
                    com.baidu.tbadk.core.util.am.f(jVar.eog, R.color.cp_other_e, 1);
                }
                if (postData.aey().getPendantData() != null && !StringUtils.isNull(postData.aey().getPendantData().acV())) {
                    jVar.hOJ.b(postData.aey());
                    jVar.hOB.setVisibility(8);
                    jVar.hOJ.setVisibility(0);
                    jVar.hOJ.getHeadView().startLoad(portrait, 28, false);
                    jVar.hOJ.getHeadView().setUserId(postData.aey().getUserId());
                    jVar.hOJ.getHeadView().setUserName(postData.aey().getUserName());
                    jVar.hOJ.getHeadView().setFid(this.hNM != null ? this.hNM.getForumId() : "");
                    jVar.hOJ.getHeadView().setTid(postData.getId());
                    jVar.hOJ.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hNM, postData, postData.locate, i2, 2));
                    jVar.hOJ.oN(postData.aey().getPendantData().acV());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hOB, postData.aey());
                    jVar.hOB.setUserId(postData.aey().getUserId());
                    jVar.hOB.setFid(this.hNM != null ? this.hNM.getForumId() : "");
                    jVar.hOB.setTid(postData.getId());
                    jVar.hOB.setUserName(postData.aey().getUserName(), postData.cpV());
                    jVar.hOB.setTag(R.id.tag_virtual_user_url, postData.aey().getVirtualUserUrl());
                    jVar.hOB.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hNM, postData, postData.locate, i2, 2));
                    jVar.hOB.setImageDrawable(null);
                    jVar.hOB.startLoad(portrait, 28, false);
                    jVar.hOB.setVisibility(0);
                    jVar.hOJ.setVisibility(8);
                }
                if (postData.aey() != null) {
                    MetaData aey = postData.aey();
                    com.baidu.tbadk.core.util.am.j(jVar.hOv, R.color.cp_btn_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(aey.getUserId())) {
                        int in = com.baidu.tbadk.core.util.am.in(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.am.k(jVar.hOv, in);
                        jVar.hOv.setTag(Integer.valueOf(in));
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.host_name);
                    } else if (aey.getIs_bawu() == 1 && postData.cpD()) {
                        com.baidu.tbadk.core.util.am.k(jVar.hOv, R.drawable.brand_official_btn);
                        jVar.hOv.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.brand_Official);
                    } else if (aey.getIs_bawu() == 1 && "manager".equals(aey.getBawu_type())) {
                        int in2 = com.baidu.tbadk.core.util.am.in(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.am.k(jVar.hOv, in2);
                        jVar.hOv.setTag(Integer.valueOf(in2));
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aey.getIs_bawu() == 1 && "assist".equals(aey.getBawu_type())) {
                        int in3 = com.baidu.tbadk.core.util.am.in(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.am.k(jVar.hOv, in3);
                        jVar.hOv.setTag(Integer.valueOf(in3));
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aey.getIs_bawu() == 1 && "pri_content_assist".equals(aey.getBawu_type())) {
                        int in4 = com.baidu.tbadk.core.util.am.in(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.k(jVar.hOv, in4);
                        jVar.hOv.setTag(Integer.valueOf(in4));
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_content_assist_tip);
                    } else if (aey.getIs_bawu() == 1 && "pri_manage_assist".equals(aey.getBawu_type())) {
                        int in5 = com.baidu.tbadk.core.util.am.in(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.k(jVar.hOv, in5);
                        jVar.hOv.setTag(Integer.valueOf(in5));
                        jVar.hOv.setVisibility(0);
                        jVar.hOv.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hOv.setVisibility(8);
                        jVar.hOv.setTag(null);
                    }
                } else {
                    jVar.hOv.setVisibility(8);
                    jVar.hOv.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hNx.bTH()) {
                if (postData.aey() != null) {
                    i3 = postData.aey().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hOI.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(jVar.hOI, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hOI.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hOL.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hOL.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hOv.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hOK.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.afS() > 1000) {
                i4 -= 2;
            }
            if (postData.afS() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hOL.setVisibility(8);
                if (jVar.hOL.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hOL.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hOv.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hOv.setVisibility(8);
                }
                if (i4 < 10 && jVar.hOI.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hOI.setVisibility(8);
                }
            }
            String name_show2 = postData.aey() != null ? postData.aey().getName_show() : "";
            int ro = com.baidu.tbadk.util.ab.ro(name_show2);
            if (postData.aey() != null && !StringUtils.isNull(postData.aey().getSealPrefix())) {
                if (ro > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ad(name_show2, i4 - 2) + "...";
                }
            } else if (ro > i4) {
                name_show2 = com.baidu.tbadk.util.ab.ad(name_show2, i4) + "...";
            }
            if (postData.aey() != null && !StringUtils.isNull(postData.aey().getSealPrefix())) {
                jVar.eog.setText(bY(postData.aey().getSealPrefix(), name_show2));
            } else {
                jVar.eog.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cpL()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aey() != null && !StringUtils.isNull(postData.aey().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hNM != null && this.hNM.bSX() != 0) {
                if (this.hNM.bSX() != 1002 && this.hNM.bSX() != 3) {
                    z10 = true;
                }
                if (this.hNM.bSX() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.aey() != null) {
                    String userId2 = postData.aey().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hNM != null && this.hNM.bSL() != null && this.hNM.bSL().aey() != null && postData.aey() != null) {
                            userId = this.hNM.bSL().aey().getUserId();
                            String userId3 = postData.aey().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aey() != null && UtilHelper.isCurrentAccount(postData.aey().getUserId())) {
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
                                if (postData.cpL() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNM.bSX()));
                                    if (postData.aey() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aey().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aey().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aey().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aey() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aey().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aey().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aey().getName_show());
                                    }
                                    if (this.hNM.bSL() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hNM.bSL().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNM.bSX()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hOC.setTag(sparseArray);
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
                        if (postData.cpL() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hOC.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hNM != null) {
                userId = this.hNM.bSL().aey().getUserId();
                String userId32 = postData.aey().getUserId();
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
            if (postData.cpL() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hOC.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.ago() != null) {
            postData.ago().threadId = this.hNx.bTR().bVL();
            postData.ago().objType = 1;
            postData.ago().isInPost = true;
            jVar.hOA.setData(postData.ago());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cpL() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cpL()));
                jVar.hOH.setVisibility(0);
                jVar.hOH.setText(format);
                z = true;
            } else {
                jVar.hOH.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cpO = postData.cpO();
            boolean z2 = (cpO == null || StringUtils.isNull(cpO.getName())) ? false : true;
            if (z) {
                jVar.hOx.setVisibility(0);
                i = this.hOl;
            } else {
                jVar.hOx.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hOy.setVisibility(0);
                i2 = this.hOl;
            } else {
                jVar.hOy.setVisibility(8);
                i2 = 0;
            }
            jVar.hOw.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hOw.setText(com.baidu.tbadk.core.util.aq.aF(postData.getTime()));
            } else {
                jVar.hOw.setText(com.baidu.tbadk.core.util.aq.aD(postData.getTime()));
            }
            if (z2) {
                jVar.hOz.setVisibility(0);
                jVar.hOz.setPadding(this.hOl, 0, 0, 0);
                if (postData.jgX) {
                    jVar.hOz.setText(com.baidu.tbadk.core.util.aq.i(cpO.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hOz.setText(cpO.getName());
                    return;
                }
            }
            jVar.hOz.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hOC.setPadding(0, 0, 0, 0);
            if (!this.hNN) {
                jVar.hOC.getLayoutStrategy().lw(R.drawable.icon_click);
            } else {
                jVar.hOC.rC(null);
                jVar.hOC.setBackgroundDrawable(null);
                jVar.hOC.getLayoutStrategy().lw(R.drawable.transparent_bg);
            }
            jVar.hOC.getLayoutStrategy().lt(R.drawable.pic_video);
            a(jVar.hOC, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hOC.setLayoutParams(layoutParams);
            jVar.hOC.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            jVar.hOC.setIsFromCDN(this.mIsFromCDN);
            TbRichText cpN = postData.cpN();
            jVar.hOC.setIsUseGridImage(postData.cpY());
            jVar.hOC.setText(cpN, true, this.hOn);
            SparseArray sparseArray = (SparseArray) jVar.hOC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hOC.setTag(sparseArray);
            jVar.hOt.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().lu(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cMa = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lv((int) (af * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cpP() > 0) {
                jVar.hOG.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hOG.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hOG.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cpX() == 2) {
                    jVar.hOG.setVisibility(8);
                } else {
                    jVar.hOG.setVisibility(0);
                }
                jVar.hOF.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cpP() > 0) {
                    jVar.hOF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cpP())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hOF.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hOF.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hOF.setVisibility(0);
                    jVar.hOG.setVisibility(8);
                    jVar.hOE.setVisibility(8);
                }
            } else {
                jVar.hOF.setVisibility(8);
                if (postData.cpP() > 0 && postData.cpI() != null && postData.cpI().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOE.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hOE.setLayoutParams(layoutParams);
                    if (this.hOo == null) {
                        this.hOo = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hOo.setIsFromCDN(this.mIsFromCDN);
                        this.hOo.setOnLongClickListener(this.cmF);
                        this.hOo.Q(this.hNW);
                        this.hOo.v(this.mCommonClickListener);
                        String str = null;
                        if (this.hNM != null && this.hNM.bSL() != null && this.hNM.bSL().aey() != null) {
                            str = this.hNM.bSL().aey().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hNM != null) {
                            this.hOo.O(this.hNM.bSX(), z);
                            this.hOo.aj(this.hNM.bSL());
                        }
                    }
                    this.hOo.Cq(postData.getId());
                    jVar.hOE.setSubPbAdapter(this.hOo);
                    jVar.hOE.setVisibility(0);
                    jVar.hOE.setData(postData, view);
                    jVar.hOE.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hOE.setChildOnLongClickListener(this.cmF);
                    jVar.hOE.setChildOnTouchListener(this.hOp);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hOE.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hOE.setLayoutParams(layoutParams2);
                    jVar.hOE.setVisibility(8);
                }
            }
            if (postData.jgO) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hOQ != null && jVar.hON != null) {
            if (postData == null || postData.jgR == null || StringUtils.isNull(postData.jgR.liveTitle)) {
                jVar.hON.setVisibility(8);
                return;
            }
            jVar.hOQ.setText(postData.jgR.liveTitle);
            jVar.hON.setTag(postData.jgR);
            jVar.hON.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hOV.setVisibility(postData.jgX ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.f(jVar.eog, R.color.cp_cont_b, 1);
                if (jVar.hOv.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.k(jVar.hOv, ((Integer) jVar.hOv.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.f(jVar.hOw, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.j(jVar.hOx, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.j(jVar.hOy, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.f(jVar.hOH, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.f(jVar.hOz, R.color.cp_cont_d, 1);
                jVar.hOC.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.l(jVar.hOE, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.j(jVar.hOF, R.color.cp_cont_c);
                jVar.hOF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.j(jVar.hOG, R.color.cp_cont_c);
                jVar.hOE.onChangeSkinType();
                jVar.hOD.onChangeSkinType();
                com.baidu.tbadk.core.util.am.f(jVar.hOQ, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.f(jVar.hOO, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.k(jVar.hON, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.k(jVar.hOP, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.c(jVar.hOR, (int) R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.j(jVar.hOU, R.color.cp_cont_c);
                if (jVar.hOS.getVisibility() == 8) {
                    jVar.hOU.setText(R.string.close_content);
                } else if (this.hNM != null && StringUtils.isNull(this.hNM.bST())) {
                    jVar.hOU.setText(this.hNM.bST());
                } else {
                    jVar.hOU.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hOt.setOnTouchListener(this.hOp);
        jVar.hOt.setOnLongClickListener(this.cmF);
        if (this.hNx.getPageContext() != null && this.hNx.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hNx.getPageContext().getOrignalPage()).hLx;
            jVar.eog.setOnClickListener(aVar.fWK);
            jVar.hOB.setOnClickListener(aVar.fWK);
            jVar.hOJ.setOnClickListener(aVar.fWK);
            jVar.hOJ.getHeadView().setOnClickListener(aVar.fWK);
            jVar.hOC.setOnLongClickListener(this.cmF);
            jVar.hOC.setOnTouchListener(this.hOp);
            jVar.hOC.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hOC.setOnImageClickListener(this.cKo);
            jVar.hOC.setOnImageTouchListener(this.hOp);
            jVar.hOC.setOnEmotionClickListener(aVar.hYR);
            jVar.hOC.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hOM.setOnClickListener(this.mCommonClickListener);
            jVar.hON.setOnClickListener(this.mCommonClickListener);
            jVar.hOF.setOnClickListener(this.mCommonClickListener);
            jVar.hOG.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hOn = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hNM = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void og(boolean z) {
        this.hNN = z;
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hNx.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hOC.setTextViewOnTouchListener(this.clA);
        jVar.hOC.setTextViewCheckSelection(false);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hNW = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKo = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.clA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmF = onLongClickListener;
    }
}
