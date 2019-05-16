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
    private TbRichTextView.h cIM;
    private boolean cLx;
    private com.baidu.tieba.pb.a.c ckg;
    private View.OnLongClickListener clk;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ftX;
    private com.baidu.adp.lib.e.b<TbImageView> ftY;
    private int hCH;
    private int hCI;
    private int hCJ;
    protected com.baidu.tieba.pb.data.d hGB;
    private boolean hGC;
    private View.OnClickListener hGL;
    private int hHa;
    private int hHb;
    private TbRichTextView.c hHc;
    private com.baidu.tieba.pb.pb.sub.c hHd;
    private com.baidu.tieba.pb.a.c hHe;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hHp != null && jVar.hHp.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bEy = 5;
                dVar.bEA = 2;
                jVar.hHp.setStatisticData(dVar);
                jVar.hHp.aja();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hCH = 0;
        this.hHa = 0;
        this.hCI = 0;
        this.hHb = 0;
        this.hCJ = 0;
        this.hHc = null;
        this.hGC = true;
        this.mHostId = null;
        this.hGB = null;
        this.hGL = null;
        this.mCommonClickListener = null;
        this.cIM = null;
        this.ckg = null;
        this.clk = null;
        this.hHd = null;
        this.cLx = true;
        this.ftX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: blY */
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
        this.ftY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajX */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(i.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.al.getColor(R.color.common_color_10043));
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
        this.hHe = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hGm == null || i.this.hGm.bRe() == null || i.this.hGm.bRe().bUe())) {
                    if (view instanceof RelativeLayout) {
                        i.this.cy(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                i.this.cy((RelativeLayout) parent);
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
                if (i.this.ckg != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.ckg.cq(view);
                        i.this.ckg.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.hGm.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hHs.setConstrainLayoutPool(this.ftX);
        jVar.hHs.setImageViewPool(this.ftY);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(R.dimen.tbds10);
        this.hCH = getDimensionPixelSize(R.dimen.tbds12);
        this.hHa = getDimensionPixelSize(R.dimen.tbds14);
        this.hCI = getDimensionPixelSize(R.dimen.tbds16);
        this.hHb = getDimensionPixelSize(R.dimen.tbds36);
        this.hCJ = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hHr != null) {
            jVar.hHr.setDuiEnabled(this.cLx);
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
            postData2.aez();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cLx = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.aa(postData.cmr())) {
            int i = 8;
            if (postData.iZv) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hGB, postData, postData.locate, i, 6);
            postData.iZw = b;
            Iterator<PostData> it = postData.cmr().iterator();
            while (it.hasNext()) {
                it.next().iZw = b;
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
        if (jVar != null && this.hGm != null && this.hGm.bQO() != null && this.hGm.bQO().bTu() && com.baidu.tbadk.core.util.ap.equals(this.hGm.bQO().bSE(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hHi, R.color.cp_other_g);
        } else {
            jVar.hHi.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hHH.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hHJ.setText(R.string.expand_content);
                return;
            } else {
                jVar.hHJ.setText(str);
                return;
            }
        }
        jVar.hHH.setVisibility(0);
        jVar.hHJ.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.cmG() == 2 || postData.cmG() == 4) {
            jVar.hHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hHH.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bPQ());
                    postData.qK(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hGm.bRe() != null && i.this.hGm.bRe().bVd() != null && i.this.hGm.bRe().getListView() != null && !z && jVar.getView().getTop() < i.this.hGm.bRe().bVd().getMeasuredHeight()) {
                        i.this.hGm.bRe().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hGm.bRe().getListView().getData(), postData) + i.this.hGm.bRe().getListView().getHeaderViewsCount(), i.this.hGm.bRe().bVd().getMeasuredHeight());
                    }
                }
            });
            jVar.hHI.setVisibility(0);
            a(jVar, postData.cmp(), postData.bPQ());
            a(true, jVar, postData);
        } else {
            jVar.hHI.setVisibility(8);
            jVar.hHH.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hHI != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hHI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.aa(postData.cmr());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hHI.getLayoutParams();
            if (z) {
                jVar.hHr.getLayoutStrategy().lv(0);
                if (z2) {
                    jVar.hHr.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hHr.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hHI.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hHr.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hHr.getLayoutStrategy().lv(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cmw = postData.cmw();
        cmw.isChanged = true;
        jVar.hHr.setText(cmw, true, this.hHc);
    }

    private void h(PostData postData) {
        if (postData.bJA == 0 && postData.fwk) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.bT("post_id", postData.getId());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.bT("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.bT("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.l("exposure_time", System.currentTimeMillis());
            if (this.hGm != null) {
                int bTn = this.hGm.bQO().bTn();
                if (1 == bTn || 2 == bTn) {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bTn) {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hGm.getUniqueId(), this.hGB, postData, postData.locate, postData.iZv ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bWE() == null) {
            jVar.hHB.setVisibility(8);
            return;
        }
        TbRichText cmw = postData.cmw();
        com.baidu.tieba.pb.view.b.a(postData.bWE(), jVar.hHB, false, false, cmw != null && StringUtils.isNull(cmw.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGC) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHr.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hHr.setLayoutParams(layoutParams);
            jVar.hHr.setPadding(0, 0, 0, 0);
            jVar.hHr.rl(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hHr.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hHr.setLayoutParams(layoutParams2);
            jVar.hHr.rl(postData.getBimg_url());
        }
        jVar.hHr.setTextViewOnTouchListener(this.hHe);
        jVar.hHr.setTextViewCheckSelection(false);
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
            if (postData.iZl) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hHq.setTag(null);
            jVar.hHq.setUserId(null);
            jVar.ejr.setText((CharSequence) null);
            jVar.hHy.getHeadView().setUserId(null);
            jVar.hHr.setIsHost(false);
            if (postData.adv() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.adv().getUserId())) {
                    jVar.hHr.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.adv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.adv().getTShowInfoNew();
                if (jVar.hHA != null) {
                    jVar.hHA.setTag(R.id.tag_user_id, postData.adv().getUserId());
                    jVar.hHA.setOnClickListener(this.hGm.hEm.hRC);
                    jVar.hHA.a(iconInfo, 2, this.hCJ, this.hCJ, this.TBDS10);
                }
                if (jVar.hHz != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hHz.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hHz.setOnClickListener(this.hGm.hEm.hRD);
                    jVar.hHz.a(tShowInfoNew, 3, this.hCJ, this.hCJ, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || postData.adv().isBigV()) {
                    com.baidu.tbadk.core.util.al.f(jVar.ejr, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.f(jVar.ejr, R.color.cp_cont_b, 1);
                }
                String portrait = postData.adv().getPortrait();
                int i2 = 8;
                if (postData.iZv) {
                    i2 = 2;
                }
                jVar.ejr.setTag(R.id.tag_user_id, postData.adv().getUserId());
                jVar.ejr.setTag(R.id.tag_user_name, postData.adv().getUserName());
                jVar.ejr.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                jVar.ejr.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGB, postData, postData.locate, i2, 2));
                String name_show = postData.adv().getName_show();
                String userName = postData.adv().getUserName();
                if (com.baidu.tbadk.t.as.iE() && name_show != null && !name_show.equals(userName)) {
                    jVar.ejr.setText(com.baidu.tieba.pb.c.aD(this.mContext, jVar.ejr.getText().toString()));
                    jVar.ejr.setGravity(16);
                    jVar.ejr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPr());
                    com.baidu.tbadk.core.util.al.f(jVar.ejr, R.color.cp_other_e, 1);
                }
                if (postData.adv().getPendantData() != null && !StringUtils.isNull(postData.adv().getPendantData().abS())) {
                    jVar.hHy.b(postData.adv());
                    jVar.hHq.setVisibility(8);
                    jVar.hHy.setVisibility(0);
                    jVar.hHy.getHeadView().startLoad(portrait, 28, false);
                    jVar.hHy.getHeadView().setUserId(postData.adv().getUserId());
                    jVar.hHy.getHeadView().setUserName(postData.adv().getUserName());
                    jVar.hHy.getHeadView().setFid(this.hGB != null ? this.hGB.getForumId() : "");
                    jVar.hHy.getHeadView().setTid(postData.getId());
                    jVar.hHy.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGB, postData, postData.locate, i2, 2));
                    jVar.hHy.ox(postData.adv().getPendantData().abS());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hHq, postData.adv());
                    jVar.hHq.setUserId(postData.adv().getUserId());
                    jVar.hHq.setFid(this.hGB != null ? this.hGB.getForumId() : "");
                    jVar.hHq.setTid(postData.getId());
                    jVar.hHq.setUserName(postData.adv().getUserName(), postData.cmE());
                    jVar.hHq.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                    jVar.hHq.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGB, postData, postData.locate, i2, 2));
                    jVar.hHq.setImageDrawable(null);
                    jVar.hHq.startLoad(portrait, 28, false);
                    jVar.hHq.setVisibility(0);
                    jVar.hHy.setVisibility(8);
                }
                if (postData.adv() != null) {
                    MetaData adv = postData.adv();
                    com.baidu.tbadk.core.util.al.j(jVar.hHk, R.color.cp_btn_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(adv.getUserId())) {
                        int ih = com.baidu.tbadk.core.util.al.ih(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.al.k(jVar.hHk, ih);
                        jVar.hHk.setTag(Integer.valueOf(ih));
                        jVar.hHk.setVisibility(0);
                        jVar.hHk.setText(R.string.host_name);
                    } else if (adv.getIs_bawu() == 1 && postData.cmm()) {
                        com.baidu.tbadk.core.util.al.k(jVar.hHk, R.drawable.brand_official_btn);
                        jVar.hHk.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hHk.setVisibility(0);
                        jVar.hHk.setText(R.string.brand_Official);
                    } else if (adv.getIs_bawu() == 1 && "manager".equals(adv.getBawu_type())) {
                        int ih2 = com.baidu.tbadk.core.util.al.ih(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.al.k(jVar.hHk, ih2);
                        jVar.hHk.setTag(Integer.valueOf(ih2));
                        jVar.hHk.setVisibility(0);
                        jVar.hHk.setText(R.string.bawu_member_bazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "assist".equals(adv.getBawu_type())) {
                        int ih3 = com.baidu.tbadk.core.util.al.ih(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.al.k(jVar.hHk, ih3);
                        jVar.hHk.setTag(Integer.valueOf(ih3));
                        jVar.hHk.setVisibility(0);
                        jVar.hHk.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_content_assist".equals(adv.getBawu_type())) {
                        int ih4 = com.baidu.tbadk.core.util.al.ih(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.al.k(jVar.hHk, ih4);
                        jVar.hHk.setTag(Integer.valueOf(ih4));
                        jVar.hHk.setVisibility(0);
                        jVar.hHk.setText(R.string.bawu_content_assist_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_manage_assist".equals(adv.getBawu_type())) {
                        int ih5 = com.baidu.tbadk.core.util.al.ih(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.al.k(jVar.hHk, ih5);
                        jVar.hHk.setTag(Integer.valueOf(ih5));
                        jVar.hHk.setVisibility(0);
                        jVar.hHk.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hHk.setVisibility(8);
                        jVar.hHk.setTag(null);
                    }
                } else {
                    jVar.hHk.setVisibility(8);
                    jVar.hHk.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hGm.bQE()) {
                if (postData.adv() != null) {
                    i3 = postData.adv().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hHx.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hHx, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hHx.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hHA.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hHA.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hHk.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hHz.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aeP() > 1000) {
                i4 -= 2;
            }
            if (postData.aeP() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hHA.setVisibility(8);
                if (jVar.hHA.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hHA.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hHk.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hHk.setVisibility(8);
                }
                if (i4 < 10 && jVar.hHx.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hHx.setVisibility(8);
                }
            }
            String name_show2 = postData.adv() != null ? postData.adv().getName_show() : "";
            int qX = com.baidu.tbadk.util.ab.qX(name_show2);
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getSealPrefix())) {
                if (qX > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ad(name_show2, i4 - 2) + "...";
                }
            } else if (qX > i4) {
                name_show2 = com.baidu.tbadk.util.ab.ad(name_show2, i4) + "...";
            }
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getSealPrefix())) {
                jVar.ejr.setText(bX(postData.adv().getSealPrefix(), name_show2));
            } else {
                jVar.ejr.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cmu()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hGB != null && this.hGB.bPU() != 0) {
                if (this.hGB.bPU() != 1002 && this.hGB.bPU() != 3) {
                    z10 = true;
                }
                if (this.hGB.bPU() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.adv() != null) {
                    String userId2 = postData.adv().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hGB != null && this.hGB.bPI() != null && this.hGB.bPI().adv() != null && postData.adv() != null) {
                            userId = this.hGB.bPI().adv().getUserId();
                            String userId3 = postData.adv().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.adv() != null && UtilHelper.isCurrentAccount(postData.adv().getUserId())) {
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
                                if (postData.cmu() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGB.bPU()));
                                    if (postData.adv() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.adv().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.adv().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.adv().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.adv() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.adv().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.adv().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.adv().getName_show());
                                    }
                                    if (this.hGB.bPI() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hGB.bPI().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGB.bPU()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hHr.setTag(sparseArray);
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
                        if (postData.cmu() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hHr.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hGB != null) {
                userId = this.hGB.bPI().adv().getUserId();
                String userId32 = postData.adv().getUserId();
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
            if (postData.cmu() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hHr.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.afl() != null) {
            postData.afl().threadId = this.hGm.bQO().bSF();
            postData.afl().objType = 1;
            postData.afl().isInPost = true;
            jVar.hHp.setData(postData.afl());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cmu() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cmu()));
                jVar.hHw.setVisibility(0);
                jVar.hHw.setText(format);
                z = true;
            } else {
                jVar.hHw.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cmx = postData.cmx();
            boolean z2 = (cmx == null || StringUtils.isNull(cmx.getName())) ? false : true;
            if (z) {
                jVar.hHm.setVisibility(0);
                i = this.hHa;
            } else {
                jVar.hHm.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hHn.setVisibility(0);
                i2 = this.hHa;
            } else {
                jVar.hHn.setVisibility(8);
                i2 = 0;
            }
            jVar.hHl.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hHl.setText(com.baidu.tbadk.core.util.ap.aE(postData.getTime()));
            } else {
                jVar.hHl.setText(com.baidu.tbadk.core.util.ap.aC(postData.getTime()));
            }
            if (z2) {
                jVar.hHo.setVisibility(0);
                jVar.hHo.setPadding(this.hHa, 0, 0, 0);
                if (postData.iZt) {
                    jVar.hHo.setText(com.baidu.tbadk.core.util.ap.i(cmx.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hHo.setText(cmx.getName());
                    return;
                }
            }
            jVar.hHo.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHr.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hHr.setPadding(0, 0, 0, 0);
            if (!this.hGC) {
                jVar.hHr.getLayoutStrategy().lp(R.drawable.icon_click);
            } else {
                jVar.hHr.rl(null);
                jVar.hHr.setBackgroundDrawable(null);
                jVar.hHr.getLayoutStrategy().lp(R.drawable.transparent_bg);
            }
            jVar.hHr.getLayoutStrategy().lm(R.drawable.pic_video);
            a(jVar.hHr, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hHr.setLayoutParams(layoutParams);
            jVar.hHr.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            jVar.hHr.setIsFromCDN(this.mIsFromCDN);
            TbRichText cmw = postData.cmw();
            jVar.hHr.setIsUseGridImage(postData.cmH());
            jVar.hHr.setText(cmw, true, this.hHc);
            SparseArray sparseArray = (SparseArray) jVar.hHr.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hHr.setTag(sparseArray);
            jVar.hHi.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().ln(af - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cKy = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lo((int) (af * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cmy() > 0) {
                jVar.hHv.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hHv.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hHv.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cmG() == 2) {
                    jVar.hHv.setVisibility(8);
                } else {
                    jVar.hHv.setVisibility(0);
                }
                jVar.hHu.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cmy() > 0) {
                    jVar.hHu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cmy())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hHu.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hHu.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hHu.setVisibility(0);
                    jVar.hHv.setVisibility(8);
                    jVar.hHt.setVisibility(8);
                }
            } else {
                jVar.hHu.setVisibility(8);
                if (postData.cmy() > 0 && postData.cmr() != null && postData.cmr().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHt.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hHt.setLayoutParams(layoutParams);
                    if (this.hHd == null) {
                        this.hHd = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hHd.setIsFromCDN(this.mIsFromCDN);
                        this.hHd.setOnLongClickListener(this.clk);
                        this.hHd.O(this.hGL);
                        this.hHd.v(this.mCommonClickListener);
                        String str = null;
                        if (this.hGB != null && this.hGB.bPI() != null && this.hGB.bPI().adv() != null) {
                            str = this.hGB.bPI().adv().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hGB != null) {
                            this.hHd.M(this.hGB.bPU(), z);
                            this.hHd.ai(this.hGB.bPI());
                        }
                    }
                    this.hHd.BB(postData.getId());
                    jVar.hHt.setSubPbAdapter(this.hHd);
                    jVar.hHt.setVisibility(0);
                    jVar.hHt.setData(postData, view);
                    jVar.hHt.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hHt.setChildOnLongClickListener(this.clk);
                    jVar.hHt.setChildOnTouchListener(this.hHe);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hHt.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hHt.setLayoutParams(layoutParams2);
                    jVar.hHt.setVisibility(8);
                }
            }
            if (postData.iZk) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hHF != null && jVar.hHC != null) {
            if (postData == null || postData.iZn == null || StringUtils.isNull(postData.iZn.liveTitle)) {
                jVar.hHC.setVisibility(8);
                return;
            }
            jVar.hHF.setText(postData.iZn.liveTitle);
            jVar.hHC.setTag(postData.iZn);
            jVar.hHC.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hHK.setVisibility(postData.iZt ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.f(jVar.ejr, R.color.cp_cont_b, 1);
                if (jVar.hHk.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hHk, ((Integer) jVar.hHk.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.f(jVar.hHl, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hHm, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hHn, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.f(jVar.hHw, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.f(jVar.hHo, R.color.cp_cont_d, 1);
                jVar.hHr.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hHt, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hHu, R.color.cp_cont_c);
                jVar.hHu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hHv, R.color.cp_cont_c);
                jVar.hHt.onChangeSkinType();
                jVar.hHs.onChangeSkinType();
                com.baidu.tbadk.core.util.al.f(jVar.hHF, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.f(jVar.hHD, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hHC, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hHE, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hHG, (int) R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hHJ, R.color.cp_cont_c);
                if (jVar.hHH.getVisibility() == 8) {
                    jVar.hHJ.setText(R.string.close_content);
                } else if (this.hGB != null && StringUtils.isNull(this.hGB.bPQ())) {
                    jVar.hHJ.setText(this.hGB.bPQ());
                } else {
                    jVar.hHJ.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hHi.setOnTouchListener(this.hHe);
        jVar.hHi.setOnLongClickListener(this.clk);
        if (this.hGm.getPageContext() != null && this.hGm.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hGm.getPageContext().getOrignalPage()).hEm;
            jVar.ejr.setOnClickListener(aVar.fQU);
            jVar.hHq.setOnClickListener(aVar.fQU);
            jVar.hHy.setOnClickListener(aVar.fQU);
            jVar.hHy.getHeadView().setOnClickListener(aVar.fQU);
            jVar.hHr.setOnLongClickListener(this.clk);
            jVar.hHr.setOnTouchListener(this.hHe);
            jVar.hHr.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hHr.setOnImageClickListener(this.cIM);
            jVar.hHr.setOnImageTouchListener(this.hHe);
            jVar.hHr.setOnEmotionClickListener(aVar.hRE);
            jVar.hHr.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hHB.setOnClickListener(this.mCommonClickListener);
            jVar.hHC.setOnClickListener(this.mCommonClickListener);
            jVar.hHu.setOnClickListener(this.mCommonClickListener);
            jVar.hHv.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hHc = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hGB = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nR(boolean z) {
        this.hGC = z;
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hGm.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hHr.setTextViewOnTouchListener(this.ckg);
        jVar.hHr.setTextViewCheckSelection(false);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGL = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIM = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ckg = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.clk = onLongClickListener;
    }
}
