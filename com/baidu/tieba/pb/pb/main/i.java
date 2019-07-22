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
    private TbRichTextView.h cKh;
    private boolean cMS;
    private com.baidu.tieba.pb.a.c clt;
    private View.OnLongClickListener cmy;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fyU;
    private com.baidu.adp.lib.e.b<TbImageView> fyV;
    private int hIY;
    private int hIZ;
    private int hJa;
    protected com.baidu.tieba.pb.data.d hMS;
    private boolean hMT;
    private View.OnClickListener hNc;
    private int hNr;
    private int hNs;
    private TbRichTextView.c hNt;
    private com.baidu.tieba.pb.pb.sub.c hNu;
    private com.baidu.tieba.pb.a.c hNv;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hNG != null && jVar.hNG.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bFz = 5;
                dVar.bFB = 2;
                jVar.hNG.setStatisticData(dVar);
                jVar.hNG.ake();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hIY = 0;
        this.hNr = 0;
        this.hIZ = 0;
        this.hNs = 0;
        this.hJa = 0;
        this.hNt = null;
        this.hMT = true;
        this.mHostId = null;
        this.hMS = null;
        this.hNc = null;
        this.mCommonClickListener = null;
        this.cKh = null;
        this.clt = null;
        this.cmy = null;
        this.hNu = null;
        this.cMS = true;
        this.fyU = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: boc */
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
        this.fyV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alc */
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
        this.hNv = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hMD == null || i.this.hMD.bTU() == null || i.this.hMD.bTU().bWV())) {
                    if (view instanceof RelativeLayout) {
                        i.this.cB(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                i.this.cB((RelativeLayout) parent);
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
                if (i.this.clt != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.clt.ct(view);
                        i.this.clt.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.hMD.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hNJ.setConstrainLayoutPool(this.fyU);
        jVar.hNJ.setImageViewPool(this.fyV);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(R.dimen.tbds10);
        this.hIY = getDimensionPixelSize(R.dimen.tbds12);
        this.hNr = getDimensionPixelSize(R.dimen.tbds14);
        this.hIZ = getDimensionPixelSize(R.dimen.tbds16);
        this.hNs = getDimensionPixelSize(R.dimen.tbds36);
        this.hJa = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hNI != null) {
            jVar.hNI.setDuiEnabled(this.cMS);
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
            postData2.afB();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cMS = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.aa(postData.cpm())) {
            int i = 8;
            if (postData.jfS) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.hMS, postData, postData.locate, i, 6);
            postData.jfT = b;
            Iterator<PostData> it = postData.cpm().iterator();
            while (it.hasNext()) {
                it.next().jfT = b;
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
        if (jVar != null && this.hMD != null && this.hMD.bTD() != null && this.hMD.bTD().bWl() && com.baidu.tbadk.core.util.aq.bV(this.hMD.bTD().bVu(), postData.getId())) {
            com.baidu.tbadk.core.util.am.l(jVar.hNz, R.color.cp_other_g);
        } else {
            jVar.hNz.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hNY.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hOa.setText(R.string.expand_content);
                return;
            } else {
                jVar.hOa.setText(str);
                return;
            }
        }
        jVar.hNY.setVisibility(0);
        jVar.hOa.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.cpB() == 2 || postData.cpB() == 4) {
            jVar.hNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hNY.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bSF());
                    postData.ra(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hMD.bTU() != null && i.this.hMD.bTU().bXV() != null && i.this.hMD.bTU().getListView() != null && !z && jVar.getView().getTop() < i.this.hMD.bTU().bXV().getMeasuredHeight()) {
                        i.this.hMD.bTU().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hMD.bTU().getListView().getData(), postData) + i.this.hMD.bTU().getListView().getHeaderViewsCount(), i.this.hMD.bTU().bXV().getMeasuredHeight());
                    }
                }
            });
            jVar.hNZ.setVisibility(0);
            a(jVar, postData.cpk(), postData.bSF());
            a(true, jVar, postData);
        } else {
            jVar.hNZ.setVisibility(8);
            jVar.hNY.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hNZ != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hNZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.aa(postData.cpm());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hNZ.getLayoutParams();
            if (z) {
                jVar.hNI.getLayoutStrategy().lB(0);
                if (z2) {
                    jVar.hNI.getLayoutStrategy().lA(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hNI.getLayoutStrategy().lA(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hNZ.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hNI.getLayoutStrategy().lA(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hNI.getLayoutStrategy().lB(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cpr = postData.cpr();
        cpr.isChanged = true;
        jVar.hNI.setText(cpr, true, this.hNt);
    }

    private void h(PostData postData) {
        if (postData.bKB == 0 && postData.fBh) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.bT("post_id", postData.getId());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.bT("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.bT("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.l("exposure_time", System.currentTimeMillis());
            if (this.hMD != null) {
                int bWe = this.hMD.bTD().bWe();
                if (1 == bWe || 2 == bWe) {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bWe) {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hMD.getUniqueId(), this.hMS, postData, postData.locate, postData.jfS ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bZx() == null) {
            jVar.hNS.setVisibility(8);
            return;
        }
        TbRichText cpr = postData.cpr();
        com.baidu.tieba.pb.view.b.a(postData.bZx(), jVar.hNS, false, false, cpr != null && StringUtils.isNull(cpr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hMT) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hNI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hNI.setLayoutParams(layoutParams);
            jVar.hNI.setPadding(0, 0, 0, 0);
            jVar.hNI.rC(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hNI.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hNI.setLayoutParams(layoutParams2);
            jVar.hNI.rC(postData.getBimg_url());
        }
        jVar.hNI.setTextViewOnTouchListener(this.hNv);
        jVar.hNI.setTextViewCheckSelection(false);
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
            if (postData.jfI) {
                com.baidu.tbadk.core.util.am.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hNH.setTag(null);
            jVar.hNH.setUserId(null);
            jVar.enZ.setText((CharSequence) null);
            jVar.hNP.getHeadView().setUserId(null);
            jVar.hNI.setIsHost(false);
            if (postData.aex() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.aex().getUserId())) {
                    jVar.hNI.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aex().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aex().getTShowInfoNew();
                if (jVar.hNR != null) {
                    jVar.hNR.setTag(R.id.tag_user_id, postData.aex().getUserId());
                    jVar.hNR.setOnClickListener(this.hMD.hKD.hXT);
                    jVar.hNR.a(iconInfo, 2, this.hJa, this.hJa, this.TBDS10);
                }
                if (jVar.hNQ != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hNQ.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hNQ.setOnClickListener(this.hMD.hKD.hXU);
                    jVar.hNQ.a(tShowInfoNew, 3, this.hJa, this.hJa, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || postData.aex().isBigV()) {
                    com.baidu.tbadk.core.util.am.f(jVar.enZ, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.f(jVar.enZ, R.color.cp_cont_b, 1);
                }
                String portrait = postData.aex().getPortrait();
                int i2 = 8;
                if (postData.jfS) {
                    i2 = 2;
                }
                jVar.enZ.setTag(R.id.tag_user_id, postData.aex().getUserId());
                jVar.enZ.setTag(R.id.tag_user_name, postData.aex().getUserName());
                jVar.enZ.setTag(R.id.tag_virtual_user_url, postData.aex().getVirtualUserUrl());
                jVar.enZ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hMS, postData, postData.locate, i2, 2));
                String name_show = postData.aex().getName_show();
                String userName = postData.aex().getUserName();
                if (com.baidu.tbadk.t.as.iN() && name_show != null && !name_show.equals(userName)) {
                    jVar.enZ.setText(com.baidu.tieba.pb.c.aE(this.mContext, jVar.enZ.getText().toString()));
                    jVar.enZ.setGravity(16);
                    jVar.enZ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSg());
                    com.baidu.tbadk.core.util.am.f(jVar.enZ, R.color.cp_other_e, 1);
                }
                if (postData.aex().getPendantData() != null && !StringUtils.isNull(postData.aex().getPendantData().acU())) {
                    jVar.hNP.b(postData.aex());
                    jVar.hNH.setVisibility(8);
                    jVar.hNP.setVisibility(0);
                    jVar.hNP.getHeadView().startLoad(portrait, 28, false);
                    jVar.hNP.getHeadView().setUserId(postData.aex().getUserId());
                    jVar.hNP.getHeadView().setUserName(postData.aex().getUserName());
                    jVar.hNP.getHeadView().setFid(this.hMS != null ? this.hMS.getForumId() : "");
                    jVar.hNP.getHeadView().setTid(postData.getId());
                    jVar.hNP.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hMS, postData, postData.locate, i2, 2));
                    jVar.hNP.oN(postData.aex().getPendantData().acU());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hNH, postData.aex());
                    jVar.hNH.setUserId(postData.aex().getUserId());
                    jVar.hNH.setFid(this.hMS != null ? this.hMS.getForumId() : "");
                    jVar.hNH.setTid(postData.getId());
                    jVar.hNH.setUserName(postData.aex().getUserName(), postData.cpz());
                    jVar.hNH.setTag(R.id.tag_virtual_user_url, postData.aex().getVirtualUserUrl());
                    jVar.hNH.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hMS, postData, postData.locate, i2, 2));
                    jVar.hNH.setImageDrawable(null);
                    jVar.hNH.startLoad(portrait, 28, false);
                    jVar.hNH.setVisibility(0);
                    jVar.hNP.setVisibility(8);
                }
                if (postData.aex() != null) {
                    MetaData aex = postData.aex();
                    com.baidu.tbadk.core.util.am.j(jVar.hNB, R.color.cp_btn_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(aex.getUserId())) {
                        int in = com.baidu.tbadk.core.util.am.in(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.am.k(jVar.hNB, in);
                        jVar.hNB.setTag(Integer.valueOf(in));
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.host_name);
                    } else if (aex.getIs_bawu() == 1 && postData.cph()) {
                        com.baidu.tbadk.core.util.am.k(jVar.hNB, R.drawable.brand_official_btn);
                        jVar.hNB.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.brand_Official);
                    } else if (aex.getIs_bawu() == 1 && "manager".equals(aex.getBawu_type())) {
                        int in2 = com.baidu.tbadk.core.util.am.in(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.am.k(jVar.hNB, in2);
                        jVar.hNB.setTag(Integer.valueOf(in2));
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aex.getIs_bawu() == 1 && "assist".equals(aex.getBawu_type())) {
                        int in3 = com.baidu.tbadk.core.util.am.in(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.am.k(jVar.hNB, in3);
                        jVar.hNB.setTag(Integer.valueOf(in3));
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aex.getIs_bawu() == 1 && "pri_content_assist".equals(aex.getBawu_type())) {
                        int in4 = com.baidu.tbadk.core.util.am.in(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.k(jVar.hNB, in4);
                        jVar.hNB.setTag(Integer.valueOf(in4));
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_content_assist_tip);
                    } else if (aex.getIs_bawu() == 1 && "pri_manage_assist".equals(aex.getBawu_type())) {
                        int in5 = com.baidu.tbadk.core.util.am.in(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.k(jVar.hNB, in5);
                        jVar.hNB.setTag(Integer.valueOf(in5));
                        jVar.hNB.setVisibility(0);
                        jVar.hNB.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hNB.setVisibility(8);
                        jVar.hNB.setTag(null);
                    }
                } else {
                    jVar.hNB.setVisibility(8);
                    jVar.hNB.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hMD.bTt()) {
                if (postData.aex() != null) {
                    i3 = postData.aex().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hNO.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(jVar.hNO, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hNO.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hNR.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hNR.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hNB.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hNQ.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.afR() > 1000) {
                i4 -= 2;
            }
            if (postData.afR() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hNR.setVisibility(8);
                if (jVar.hNR.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hNR.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hNB.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hNB.setVisibility(8);
                }
                if (i4 < 10 && jVar.hNO.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hNO.setVisibility(8);
                }
            }
            String name_show2 = postData.aex() != null ? postData.aex().getName_show() : "";
            int ro = com.baidu.tbadk.util.ab.ro(name_show2);
            if (postData.aex() != null && !StringUtils.isNull(postData.aex().getSealPrefix())) {
                if (ro > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ad(name_show2, i4 - 2) + "...";
                }
            } else if (ro > i4) {
                name_show2 = com.baidu.tbadk.util.ab.ad(name_show2, i4) + "...";
            }
            if (postData.aex() != null && !StringUtils.isNull(postData.aex().getSealPrefix())) {
                jVar.enZ.setText(bY(postData.aex().getSealPrefix(), name_show2));
            } else {
                jVar.enZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cpp()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aex() != null && !StringUtils.isNull(postData.aex().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hMS != null && this.hMS.bSJ() != 0) {
                if (this.hMS.bSJ() != 1002 && this.hMS.bSJ() != 3) {
                    z10 = true;
                }
                if (this.hMS.bSJ() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.aex() != null) {
                    String userId2 = postData.aex().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hMS != null && this.hMS.bSx() != null && this.hMS.bSx().aex() != null && postData.aex() != null) {
                            userId = this.hMS.bSx().aex().getUserId();
                            String userId3 = postData.aex().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aex() != null && UtilHelper.isCurrentAccount(postData.aex().getUserId())) {
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
                                if (postData.cpp() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hMS.bSJ()));
                                    if (postData.aex() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aex().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aex().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aex().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aex() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aex().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aex().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aex().getName_show());
                                    }
                                    if (this.hMS.bSx() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hMS.bSx().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hMS.bSJ()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hNI.setTag(sparseArray);
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
                        if (postData.cpp() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hNI.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hMS != null) {
                userId = this.hMS.bSx().aex().getUserId();
                String userId32 = postData.aex().getUserId();
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
            if (postData.cpp() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hNI.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.agn() != null) {
            postData.agn().threadId = this.hMD.bTD().bVv();
            postData.agn().objType = 1;
            postData.agn().isInPost = true;
            jVar.hNG.setData(postData.agn());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cpp() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cpp()));
                jVar.hNN.setVisibility(0);
                jVar.hNN.setText(format);
                z = true;
            } else {
                jVar.hNN.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cps = postData.cps();
            boolean z2 = (cps == null || StringUtils.isNull(cps.getName())) ? false : true;
            if (z) {
                jVar.hND.setVisibility(0);
                i = this.hNr;
            } else {
                jVar.hND.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hNE.setVisibility(0);
                i2 = this.hNr;
            } else {
                jVar.hNE.setVisibility(8);
                i2 = 0;
            }
            jVar.hNC.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hNC.setText(com.baidu.tbadk.core.util.aq.aF(postData.getTime()));
            } else {
                jVar.hNC.setText(com.baidu.tbadk.core.util.aq.aD(postData.getTime()));
            }
            if (z2) {
                jVar.hNF.setVisibility(0);
                jVar.hNF.setPadding(this.hNr, 0, 0, 0);
                if (postData.jfQ) {
                    jVar.hNF.setText(com.baidu.tbadk.core.util.aq.i(cps.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hNF.setText(cps.getName());
                    return;
                }
            }
            jVar.hNF.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hNI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hNI.setPadding(0, 0, 0, 0);
            if (!this.hMT) {
                jVar.hNI.getLayoutStrategy().lv(R.drawable.icon_click);
            } else {
                jVar.hNI.rC(null);
                jVar.hNI.setBackgroundDrawable(null);
                jVar.hNI.getLayoutStrategy().lv(R.drawable.transparent_bg);
            }
            jVar.hNI.getLayoutStrategy().ls(R.drawable.pic_video);
            a(jVar.hNI, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hNI.setLayoutParams(layoutParams);
            jVar.hNI.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            jVar.hNI.setIsFromCDN(this.mIsFromCDN);
            TbRichText cpr = postData.cpr();
            jVar.hNI.setIsUseGridImage(postData.cpC());
            jVar.hNI.setText(cpr, true, this.hNt);
            SparseArray sparseArray = (SparseArray) jVar.hNI.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hNI.setTag(sparseArray);
            jVar.hNz.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().lt(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cLT = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lu((int) (af * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cpt() > 0) {
                jVar.hNM.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hNM.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hNM.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cpB() == 2) {
                    jVar.hNM.setVisibility(8);
                } else {
                    jVar.hNM.setVisibility(0);
                }
                jVar.hNL.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cpt() > 0) {
                    jVar.hNL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cpt())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hNL.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hNL.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hNL.setVisibility(0);
                    jVar.hNM.setVisibility(8);
                    jVar.hNK.setVisibility(8);
                }
            } else {
                jVar.hNL.setVisibility(8);
                if (postData.cpt() > 0 && postData.cpm() != null && postData.cpm().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hNK.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hNK.setLayoutParams(layoutParams);
                    if (this.hNu == null) {
                        this.hNu = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hNu.setIsFromCDN(this.mIsFromCDN);
                        this.hNu.setOnLongClickListener(this.cmy);
                        this.hNu.Q(this.hNc);
                        this.hNu.v(this.mCommonClickListener);
                        String str = null;
                        if (this.hMS != null && this.hMS.bSx() != null && this.hMS.bSx().aex() != null) {
                            str = this.hMS.bSx().aex().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hMS != null) {
                            this.hNu.O(this.hMS.bSJ(), z);
                            this.hNu.ai(this.hMS.bSx());
                        }
                    }
                    this.hNu.Cp(postData.getId());
                    jVar.hNK.setSubPbAdapter(this.hNu);
                    jVar.hNK.setVisibility(0);
                    jVar.hNK.setData(postData, view);
                    jVar.hNK.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hNK.setChildOnLongClickListener(this.cmy);
                    jVar.hNK.setChildOnTouchListener(this.hNv);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hNK.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hNK.setLayoutParams(layoutParams2);
                    jVar.hNK.setVisibility(8);
                }
            }
            if (postData.jfH) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hNW != null && jVar.hNT != null) {
            if (postData == null || postData.jfK == null || StringUtils.isNull(postData.jfK.liveTitle)) {
                jVar.hNT.setVisibility(8);
                return;
            }
            jVar.hNW.setText(postData.jfK.liveTitle);
            jVar.hNT.setTag(postData.jfK);
            jVar.hNT.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hOb.setVisibility(postData.jfQ ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.f(jVar.enZ, R.color.cp_cont_b, 1);
                if (jVar.hNB.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.k(jVar.hNB, ((Integer) jVar.hNB.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.f(jVar.hNC, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.j(jVar.hND, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.j(jVar.hNE, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.f(jVar.hNN, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.f(jVar.hNF, R.color.cp_cont_d, 1);
                jVar.hNI.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.l(jVar.hNK, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.j(jVar.hNL, R.color.cp_cont_c);
                jVar.hNL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.j(jVar.hNM, R.color.cp_cont_c);
                jVar.hNK.onChangeSkinType();
                jVar.hNJ.onChangeSkinType();
                com.baidu.tbadk.core.util.am.f(jVar.hNW, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.f(jVar.hNU, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.k(jVar.hNT, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.k(jVar.hNV, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.c(jVar.hNX, (int) R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.j(jVar.hOa, R.color.cp_cont_c);
                if (jVar.hNY.getVisibility() == 8) {
                    jVar.hOa.setText(R.string.close_content);
                } else if (this.hMS != null && StringUtils.isNull(this.hMS.bSF())) {
                    jVar.hOa.setText(this.hMS.bSF());
                } else {
                    jVar.hOa.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hNz.setOnTouchListener(this.hNv);
        jVar.hNz.setOnLongClickListener(this.cmy);
        if (this.hMD.getPageContext() != null && this.hMD.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hMD.getPageContext().getOrignalPage()).hKD;
            jVar.enZ.setOnClickListener(aVar.fVU);
            jVar.hNH.setOnClickListener(aVar.fVU);
            jVar.hNP.setOnClickListener(aVar.fVU);
            jVar.hNP.getHeadView().setOnClickListener(aVar.fVU);
            jVar.hNI.setOnLongClickListener(this.cmy);
            jVar.hNI.setOnTouchListener(this.hNv);
            jVar.hNI.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hNI.setOnImageClickListener(this.cKh);
            jVar.hNI.setOnImageTouchListener(this.hNv);
            jVar.hNI.setOnEmotionClickListener(aVar.hXV);
            jVar.hNI.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hNS.setOnClickListener(this.mCommonClickListener);
            jVar.hNT.setOnClickListener(this.mCommonClickListener);
            jVar.hNL.setOnClickListener(this.mCommonClickListener);
            jVar.hNM.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hNt = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hMS = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void og(boolean z) {
        this.hMT = z;
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hMD.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hNI.setTextViewOnTouchListener(this.clt);
        jVar.hNI.setTextViewCheckSelection(false);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hNc = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKh = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.clt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmy = onLongClickListener;
    }
}
