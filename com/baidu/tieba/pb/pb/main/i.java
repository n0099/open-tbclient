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
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ftY;
    private com.baidu.adp.lib.e.b<TbImageView> ftZ;
    private int hCK;
    private int hCL;
    private int hCM;
    protected com.baidu.tieba.pb.data.d hGE;
    private boolean hGF;
    private View.OnClickListener hGO;
    private int hHd;
    private int hHe;
    private TbRichTextView.c hHf;
    private com.baidu.tieba.pb.pb.sub.c hHg;
    private com.baidu.tieba.pb.a.c hHh;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hHs != null && jVar.hHs.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bEy = 5;
                dVar.bEA = 2;
                jVar.hHs.setStatisticData(dVar);
                jVar.hHs.aja();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hCK = 0;
        this.hHd = 0;
        this.hCL = 0;
        this.hHe = 0;
        this.hCM = 0;
        this.hHf = null;
        this.hGF = true;
        this.mHostId = null;
        this.hGE = null;
        this.hGO = null;
        this.mCommonClickListener = null;
        this.cIM = null;
        this.ckg = null;
        this.clk = null;
        this.hHg = null;
        this.cLx = true;
        this.ftY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bmb */
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
        this.ftZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
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
        this.hHh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hGp == null || i.this.hGp.bRh() == null || i.this.hGp.bRh().bUh())) {
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
        j jVar = new j(this.hGp.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hHv.setConstrainLayoutPool(this.ftY);
        jVar.hHv.setImageViewPool(this.ftZ);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(R.dimen.tbds10);
        this.hCK = getDimensionPixelSize(R.dimen.tbds12);
        this.hHd = getDimensionPixelSize(R.dimen.tbds14);
        this.hCL = getDimensionPixelSize(R.dimen.tbds16);
        this.hHe = getDimensionPixelSize(R.dimen.tbds36);
        this.hCM = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hHu != null) {
            jVar.hHu.setDuiEnabled(this.cLx);
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
        if (postData != null && !com.baidu.tbadk.core.util.v.aa(postData.cmt())) {
            int i = 8;
            if (postData.iZx) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hGE, postData, postData.locate, i, 6);
            postData.iZy = b;
            Iterator<PostData> it = postData.cmt().iterator();
            while (it.hasNext()) {
                it.next().iZy = b;
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
        if (jVar != null && this.hGp != null && this.hGp.bQR() != null && this.hGp.bQR().bTx() && com.baidu.tbadk.core.util.ap.equals(this.hGp.bQR().bSH(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hHl, R.color.cp_other_g);
        } else {
            jVar.hHl.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hHK.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hHM.setText(R.string.expand_content);
                return;
            } else {
                jVar.hHM.setText(str);
                return;
            }
        }
        jVar.hHK.setVisibility(0);
        jVar.hHM.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.cmI() == 2 || postData.cmI() == 4) {
            jVar.hHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hHK.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bPT());
                    postData.qK(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hGp.bRh() != null && i.this.hGp.bRh().bVg() != null && i.this.hGp.bRh().getListView() != null && !z && jVar.getView().getTop() < i.this.hGp.bRh().bVg().getMeasuredHeight()) {
                        i.this.hGp.bRh().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hGp.bRh().getListView().getData(), postData) + i.this.hGp.bRh().getListView().getHeaderViewsCount(), i.this.hGp.bRh().bVg().getMeasuredHeight());
                    }
                }
            });
            jVar.hHL.setVisibility(0);
            a(jVar, postData.cmr(), postData.bPT());
            a(true, jVar, postData);
        } else {
            jVar.hHL.setVisibility(8);
            jVar.hHK.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hHL != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hHL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.aa(postData.cmt());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hHL.getLayoutParams();
            if (z) {
                jVar.hHu.getLayoutStrategy().lv(0);
                if (z2) {
                    jVar.hHu.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hHu.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hHL.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hHu.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hHu.getLayoutStrategy().lv(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cmy = postData.cmy();
        cmy.isChanged = true;
        jVar.hHu.setText(cmy, true, this.hHf);
    }

    private void h(PostData postData) {
        if (postData.bJA == 0 && postData.fwl) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.bT("post_id", postData.getId());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.bT("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.bT("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.l("exposure_time", System.currentTimeMillis());
            if (this.hGp != null) {
                int bTq = this.hGp.bQR().bTq();
                if (1 == bTq || 2 == bTq) {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bTq) {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hGp.getUniqueId(), this.hGE, postData, postData.locate, postData.iZx ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bWH() == null) {
            jVar.hHE.setVisibility(8);
            return;
        }
        TbRichText cmy = postData.cmy();
        com.baidu.tieba.pb.view.b.a(postData.bWH(), jVar.hHE, false, false, cmy != null && StringUtils.isNull(cmy.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGF) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHu.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hHu.setLayoutParams(layoutParams);
            jVar.hHu.setPadding(0, 0, 0, 0);
            jVar.hHu.rl(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hHu.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hHu.setLayoutParams(layoutParams2);
            jVar.hHu.rl(postData.getBimg_url());
        }
        jVar.hHu.setTextViewOnTouchListener(this.hHh);
        jVar.hHu.setTextViewCheckSelection(false);
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
            if (postData.iZn) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hHt.setTag(null);
            jVar.hHt.setUserId(null);
            jVar.ejs.setText((CharSequence) null);
            jVar.hHB.getHeadView().setUserId(null);
            jVar.hHu.setIsHost(false);
            if (postData.adv() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.adv().getUserId())) {
                    jVar.hHu.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.adv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.adv().getTShowInfoNew();
                if (jVar.hHD != null) {
                    jVar.hHD.setTag(R.id.tag_user_id, postData.adv().getUserId());
                    jVar.hHD.setOnClickListener(this.hGp.hEp.hRF);
                    jVar.hHD.a(iconInfo, 2, this.hCM, this.hCM, this.TBDS10);
                }
                if (jVar.hHC != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hHC.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hHC.setOnClickListener(this.hGp.hEp.hRG);
                    jVar.hHC.a(tShowInfoNew, 3, this.hCM, this.hCM, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || postData.adv().isBigV()) {
                    com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_cont_b, 1);
                }
                String portrait = postData.adv().getPortrait();
                int i2 = 8;
                if (postData.iZx) {
                    i2 = 2;
                }
                jVar.ejs.setTag(R.id.tag_user_id, postData.adv().getUserId());
                jVar.ejs.setTag(R.id.tag_user_name, postData.adv().getUserName());
                jVar.ejs.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                jVar.ejs.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGE, postData, postData.locate, i2, 2));
                String name_show = postData.adv().getName_show();
                String userName = postData.adv().getUserName();
                if (com.baidu.tbadk.t.as.iE() && name_show != null && !name_show.equals(userName)) {
                    jVar.ejs.setText(com.baidu.tieba.pb.c.aD(this.mContext, jVar.ejs.getText().toString()));
                    jVar.ejs.setGravity(16);
                    jVar.ejs.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPu());
                    com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_other_e, 1);
                }
                if (postData.adv().getPendantData() != null && !StringUtils.isNull(postData.adv().getPendantData().abS())) {
                    jVar.hHB.b(postData.adv());
                    jVar.hHt.setVisibility(8);
                    jVar.hHB.setVisibility(0);
                    jVar.hHB.getHeadView().startLoad(portrait, 28, false);
                    jVar.hHB.getHeadView().setUserId(postData.adv().getUserId());
                    jVar.hHB.getHeadView().setUserName(postData.adv().getUserName());
                    jVar.hHB.getHeadView().setFid(this.hGE != null ? this.hGE.getForumId() : "");
                    jVar.hHB.getHeadView().setTid(postData.getId());
                    jVar.hHB.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGE, postData, postData.locate, i2, 2));
                    jVar.hHB.ox(postData.adv().getPendantData().abS());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hHt, postData.adv());
                    jVar.hHt.setUserId(postData.adv().getUserId());
                    jVar.hHt.setFid(this.hGE != null ? this.hGE.getForumId() : "");
                    jVar.hHt.setTid(postData.getId());
                    jVar.hHt.setUserName(postData.adv().getUserName(), postData.cmG());
                    jVar.hHt.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                    jVar.hHt.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGE, postData, postData.locate, i2, 2));
                    jVar.hHt.setImageDrawable(null);
                    jVar.hHt.startLoad(portrait, 28, false);
                    jVar.hHt.setVisibility(0);
                    jVar.hHB.setVisibility(8);
                }
                if (postData.adv() != null) {
                    MetaData adv = postData.adv();
                    com.baidu.tbadk.core.util.al.j(jVar.hHn, R.color.cp_btn_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(adv.getUserId())) {
                        int ih = com.baidu.tbadk.core.util.al.ih(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.al.k(jVar.hHn, ih);
                        jVar.hHn.setTag(Integer.valueOf(ih));
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.host_name);
                    } else if (adv.getIs_bawu() == 1 && postData.cmo()) {
                        com.baidu.tbadk.core.util.al.k(jVar.hHn, R.drawable.brand_official_btn);
                        jVar.hHn.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.brand_Official);
                    } else if (adv.getIs_bawu() == 1 && "manager".equals(adv.getBawu_type())) {
                        int ih2 = com.baidu.tbadk.core.util.al.ih(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.al.k(jVar.hHn, ih2);
                        jVar.hHn.setTag(Integer.valueOf(ih2));
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_member_bazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "assist".equals(adv.getBawu_type())) {
                        int ih3 = com.baidu.tbadk.core.util.al.ih(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.al.k(jVar.hHn, ih3);
                        jVar.hHn.setTag(Integer.valueOf(ih3));
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_content_assist".equals(adv.getBawu_type())) {
                        int ih4 = com.baidu.tbadk.core.util.al.ih(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.al.k(jVar.hHn, ih4);
                        jVar.hHn.setTag(Integer.valueOf(ih4));
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_content_assist_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_manage_assist".equals(adv.getBawu_type())) {
                        int ih5 = com.baidu.tbadk.core.util.al.ih(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.al.k(jVar.hHn, ih5);
                        jVar.hHn.setTag(Integer.valueOf(ih5));
                        jVar.hHn.setVisibility(0);
                        jVar.hHn.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hHn.setVisibility(8);
                        jVar.hHn.setTag(null);
                    }
                } else {
                    jVar.hHn.setVisibility(8);
                    jVar.hHn.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hGp.bQH()) {
                if (postData.adv() != null) {
                    i3 = postData.adv().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hHA.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hHA, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hHA.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hHD.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hHD.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hHn.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hHC.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aeP() > 1000) {
                i4 -= 2;
            }
            if (postData.aeP() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hHD.setVisibility(8);
                if (jVar.hHD.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hHD.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hHn.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hHn.setVisibility(8);
                }
                if (i4 < 10 && jVar.hHA.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hHA.setVisibility(8);
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
                jVar.ejs.setText(bX(postData.adv().getSealPrefix(), name_show2));
            } else {
                jVar.ejs.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cmw()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hGE != null && this.hGE.bPX() != 0) {
                if (this.hGE.bPX() != 1002 && this.hGE.bPX() != 3) {
                    z10 = true;
                }
                if (this.hGE.bPX() != 3) {
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
                        if (this.hGE != null && this.hGE.bPL() != null && this.hGE.bPL().adv() != null && postData.adv() != null) {
                            userId = this.hGE.bPL().adv().getUserId();
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
                                if (postData.cmw() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGE.bPX()));
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
                                    if (this.hGE.bPL() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hGE.bPL().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGE.bPX()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hHu.setTag(sparseArray);
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
                        if (postData.cmw() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hHu.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hGE != null) {
                userId = this.hGE.bPL().adv().getUserId();
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
            if (postData.cmw() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hHu.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.afl() != null) {
            postData.afl().threadId = this.hGp.bQR().bSI();
            postData.afl().objType = 1;
            postData.afl().isInPost = true;
            jVar.hHs.setData(postData.afl());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cmw() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cmw()));
                jVar.hHz.setVisibility(0);
                jVar.hHz.setText(format);
                z = true;
            } else {
                jVar.hHz.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cmz = postData.cmz();
            boolean z2 = (cmz == null || StringUtils.isNull(cmz.getName())) ? false : true;
            if (z) {
                jVar.hHp.setVisibility(0);
                i = this.hHd;
            } else {
                jVar.hHp.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hHq.setVisibility(0);
                i2 = this.hHd;
            } else {
                jVar.hHq.setVisibility(8);
                i2 = 0;
            }
            jVar.hHo.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hHo.setText(com.baidu.tbadk.core.util.ap.aE(postData.getTime()));
            } else {
                jVar.hHo.setText(com.baidu.tbadk.core.util.ap.aC(postData.getTime()));
            }
            if (z2) {
                jVar.hHr.setVisibility(0);
                jVar.hHr.setPadding(this.hHd, 0, 0, 0);
                if (postData.iZv) {
                    jVar.hHr.setText(com.baidu.tbadk.core.util.ap.i(cmz.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hHr.setText(cmz.getName());
                    return;
                }
            }
            jVar.hHr.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHu.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hHu.setPadding(0, 0, 0, 0);
            if (!this.hGF) {
                jVar.hHu.getLayoutStrategy().lp(R.drawable.icon_click);
            } else {
                jVar.hHu.rl(null);
                jVar.hHu.setBackgroundDrawable(null);
                jVar.hHu.getLayoutStrategy().lp(R.drawable.transparent_bg);
            }
            jVar.hHu.getLayoutStrategy().lm(R.drawable.pic_video);
            a(jVar.hHu, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hHu.setLayoutParams(layoutParams);
            jVar.hHu.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            jVar.hHu.setIsFromCDN(this.mIsFromCDN);
            TbRichText cmy = postData.cmy();
            jVar.hHu.setIsUseGridImage(postData.cmJ());
            jVar.hHu.setText(cmy, true, this.hHf);
            SparseArray sparseArray = (SparseArray) jVar.hHu.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hHu.setTag(sparseArray);
            jVar.hHl.setTag(R.id.tag_from, sparseArray);
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
            if (postData.cmA() > 0) {
                jVar.hHy.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hHy.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hHy.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cmI() == 2) {
                    jVar.hHy.setVisibility(8);
                } else {
                    jVar.hHy.setVisibility(0);
                }
                jVar.hHx.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cmA() > 0) {
                    jVar.hHx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cmA())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hHx.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hHx.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hHx.setVisibility(0);
                    jVar.hHy.setVisibility(8);
                    jVar.hHw.setVisibility(8);
                }
            } else {
                jVar.hHx.setVisibility(8);
                if (postData.cmA() > 0 && postData.cmt() != null && postData.cmt().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHw.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hHw.setLayoutParams(layoutParams);
                    if (this.hHg == null) {
                        this.hHg = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hHg.setIsFromCDN(this.mIsFromCDN);
                        this.hHg.setOnLongClickListener(this.clk);
                        this.hHg.O(this.hGO);
                        this.hHg.v(this.mCommonClickListener);
                        String str = null;
                        if (this.hGE != null && this.hGE.bPL() != null && this.hGE.bPL().adv() != null) {
                            str = this.hGE.bPL().adv().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hGE != null) {
                            this.hHg.M(this.hGE.bPX(), z);
                            this.hHg.ai(this.hGE.bPL());
                        }
                    }
                    this.hHg.BB(postData.getId());
                    jVar.hHw.setSubPbAdapter(this.hHg);
                    jVar.hHw.setVisibility(0);
                    jVar.hHw.setData(postData, view);
                    jVar.hHw.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hHw.setChildOnLongClickListener(this.clk);
                    jVar.hHw.setChildOnTouchListener(this.hHh);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hHw.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hHw.setLayoutParams(layoutParams2);
                    jVar.hHw.setVisibility(8);
                }
            }
            if (postData.iZm) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hHI != null && jVar.hHF != null) {
            if (postData == null || postData.iZp == null || StringUtils.isNull(postData.iZp.liveTitle)) {
                jVar.hHF.setVisibility(8);
                return;
            }
            jVar.hHI.setText(postData.iZp.liveTitle);
            jVar.hHF.setTag(postData.iZp);
            jVar.hHF.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hHN.setVisibility(postData.iZv ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_cont_b, 1);
                if (jVar.hHn.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hHn, ((Integer) jVar.hHn.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.f(jVar.hHo, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hHp, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hHq, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.f(jVar.hHz, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.f(jVar.hHr, R.color.cp_cont_d, 1);
                jVar.hHu.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hHw, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hHx, R.color.cp_cont_c);
                jVar.hHx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hHy, R.color.cp_cont_c);
                jVar.hHw.onChangeSkinType();
                jVar.hHv.onChangeSkinType();
                com.baidu.tbadk.core.util.al.f(jVar.hHI, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.f(jVar.hHG, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hHF, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hHH, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hHJ, (int) R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hHM, R.color.cp_cont_c);
                if (jVar.hHK.getVisibility() == 8) {
                    jVar.hHM.setText(R.string.close_content);
                } else if (this.hGE != null && StringUtils.isNull(this.hGE.bPT())) {
                    jVar.hHM.setText(this.hGE.bPT());
                } else {
                    jVar.hHM.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hHl.setOnTouchListener(this.hHh);
        jVar.hHl.setOnLongClickListener(this.clk);
        if (this.hGp.getPageContext() != null && this.hGp.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hGp.getPageContext().getOrignalPage()).hEp;
            jVar.ejs.setOnClickListener(aVar.fQV);
            jVar.hHt.setOnClickListener(aVar.fQV);
            jVar.hHB.setOnClickListener(aVar.fQV);
            jVar.hHB.getHeadView().setOnClickListener(aVar.fQV);
            jVar.hHu.setOnLongClickListener(this.clk);
            jVar.hHu.setOnTouchListener(this.hHh);
            jVar.hHu.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hHu.setOnImageClickListener(this.cIM);
            jVar.hHu.setOnImageTouchListener(this.hHh);
            jVar.hHu.setOnEmotionClickListener(aVar.hRH);
            jVar.hHu.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hHE.setOnClickListener(this.mCommonClickListener);
            jVar.hHF.setOnClickListener(this.mCommonClickListener);
            jVar.hHx.setOnClickListener(this.mCommonClickListener);
            jVar.hHy.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hHf = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hGE = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nR(boolean z) {
        this.hGF = z;
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hGp.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hHu.setTextViewOnTouchListener(this.ckg);
        jVar.hHu.setTextViewCheckSelection(false);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGO = onClickListener;
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
