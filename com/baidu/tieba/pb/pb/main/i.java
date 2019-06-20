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
    private TbRichTextView.h cIN;
    private boolean cLy;
    private com.baidu.tieba.pb.a.c ckh;
    private View.OnLongClickListener cll;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ftY;
    private com.baidu.adp.lib.e.b<TbImageView> ftZ;
    private int hCL;
    private int hCM;
    private int hCN;
    protected com.baidu.tieba.pb.data.d hGF;
    private boolean hGG;
    private View.OnClickListener hGP;
    private int hHe;
    private int hHf;
    private TbRichTextView.c hHg;
    private com.baidu.tieba.pb.pb.sub.c hHh;
    private com.baidu.tieba.pb.a.c hHi;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hHt != null && jVar.hHt.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bEz = 5;
                dVar.bEB = 2;
                jVar.hHt.setStatisticData(dVar);
                jVar.hHt.aja();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.TBDS10 = 0;
        this.hCL = 0;
        this.hHe = 0;
        this.hCM = 0;
        this.hHf = 0;
        this.hCN = 0;
        this.hHg = null;
        this.hGG = true;
        this.mHostId = null;
        this.hGF = null;
        this.hGP = null;
        this.mCommonClickListener = null;
        this.cIN = null;
        this.ckh = null;
        this.cll = null;
        this.hHh = null;
        this.cLy = true;
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
        this.hHi = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hGq == null || i.this.hGq.bRi() == null || i.this.hGq.bRi().bUi())) {
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
                if (i.this.ckh != null) {
                    if (!(view instanceof TbListTextView) || i.this.mCommonClickListener == null) {
                        i.this.ckh.cq(view);
                        i.this.ckh.onSingleTapConfirmed(motionEvent);
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
        j jVar = new j(this.hGq.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hHw.setConstrainLayoutPool(this.ftY);
        jVar.hHw.setImageViewPool(this.ftZ);
        a(jVar);
        this.TBDS10 = getDimensionPixelSize(R.dimen.tbds10);
        this.hCL = getDimensionPixelSize(R.dimen.tbds12);
        this.hHe = getDimensionPixelSize(R.dimen.tbds14);
        this.hCM = getDimensionPixelSize(R.dimen.tbds16);
        this.hHf = getDimensionPixelSize(R.dimen.tbds36);
        this.hCN = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hHv != null) {
            jVar.hHv.setDuiEnabled(this.cLy);
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
        this.cLy = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.aa(postData.cmu())) {
            int i = 8;
            if (postData.iZB) {
                i = 2;
            }
            com.baidu.tbadk.core.util.am b = com.baidu.tieba.pb.c.a.b(this.hGF, postData, postData.locate, i, 6);
            postData.iZC = b;
            Iterator<PostData> it = postData.cmu().iterator();
            while (it.hasNext()) {
                it.next().iZC = b;
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
        if (jVar != null && this.hGq != null && this.hGq.bQS() != null && this.hGq.bQS().bTy() && com.baidu.tbadk.core.util.ap.equals(this.hGq.bQS().bSI(), postData.getId())) {
            com.baidu.tbadk.core.util.al.l(jVar.hHm, R.color.cp_other_g);
        } else {
            jVar.hHm.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hHL.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hHN.setText(R.string.expand_content);
                return;
            } else {
                jVar.hHN.setText(str);
                return;
            }
        }
        jVar.hHL.setVisibility(0);
        jVar.hHN.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.cmJ() == 2 || postData.cmJ() == 4) {
            jVar.hHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hHL.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bPU());
                    postData.qL(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hGq.bRi() != null && i.this.hGq.bRi().bVh() != null && i.this.hGq.bRi().getListView() != null && !z && jVar.getView().getTop() < i.this.hGq.bRi().bVh().getMeasuredHeight()) {
                        i.this.hGq.bRi().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.a(i.this.hGq.bRi().getListView().getData(), postData) + i.this.hGq.bRi().getListView().getHeaderViewsCount(), i.this.hGq.bRi().bVh().getMeasuredHeight());
                    }
                }
            });
            jVar.hHM.setVisibility(0);
            a(jVar, postData.cms(), postData.bPU());
            a(true, jVar, postData);
        } else {
            jVar.hHM.setVisibility(8);
            jVar.hHL.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hHM != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hHM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.aa(postData.cmu());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hHM.getLayoutParams();
            if (z) {
                jVar.hHv.getLayoutStrategy().lv(0);
                if (z2) {
                    jVar.hHv.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hHv.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hHM.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hHv.getLayoutStrategy().lu(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hHv.getLayoutStrategy().lv(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cmz = postData.cmz();
        cmz.isChanged = true;
        jVar.hHv.setText(cmz, true, this.hHg);
    }

    private void h(PostData postData) {
        if (postData.bJB == 0 && postData.fwl) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12203");
            amVar.bT("post_id", postData.getId());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("cuid", TbadkCoreApplication.getInst().getCuid());
            amVar.bT("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            amVar.bT("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            amVar.l("exposure_time", System.currentTimeMillis());
            if (this.hGq != null) {
                int bTr = this.hGq.bQS().bTr();
                if (1 == bTr || 2 == bTr) {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                } else if (3 == bTr) {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2");
                } else {
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                }
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hGq.getUniqueId(), this.hGF, postData, postData.locate, postData.iZB ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bWI() == null) {
            jVar.hHF.setVisibility(8);
            return;
        }
        TbRichText cmz = postData.cmz();
        com.baidu.tieba.pb.view.b.a(postData.bWI(), jVar.hHF, false, false, cmz != null && StringUtils.isNull(cmz.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGG) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHv.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hHv.setLayoutParams(layoutParams);
            jVar.hHv.setPadding(0, 0, 0, 0);
            jVar.hHv.rk(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hHv.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hHv.setLayoutParams(layoutParams2);
            jVar.hHv.rk(postData.getBimg_url());
        }
        jVar.hHv.setTextViewOnTouchListener(this.hHi);
        jVar.hHv.setTextViewCheckSelection(false);
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
            if (postData.iZr) {
                com.baidu.tbadk.core.util.al.l(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hHu.setTag(null);
            jVar.hHu.setUserId(null);
            jVar.ejs.setText((CharSequence) null);
            jVar.hHC.getHeadView().setUserId(null);
            jVar.hHv.setIsHost(false);
            if (postData.adv() != null) {
                if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(postData.adv().getUserId())) {
                    jVar.hHv.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.adv().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.adv().getTShowInfoNew();
                if (jVar.hHE != null) {
                    jVar.hHE.setTag(R.id.tag_user_id, postData.adv().getUserId());
                    jVar.hHE.setOnClickListener(this.hGq.hEq.hRG);
                    jVar.hHE.a(iconInfo, 2, this.hCN, this.hCN, this.TBDS10);
                }
                if (jVar.hHD != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hHD.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hHD.setOnClickListener(this.hGq.hEq.hRH);
                    jVar.hHD.a(tShowInfoNew, 3, this.hCN, this.hCN, this.TBDS10, true);
                }
                if (!com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || postData.adv().isBigV()) {
                    com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_cont_b, 1);
                }
                String portrait = postData.adv().getPortrait();
                int i2 = 8;
                if (postData.iZB) {
                    i2 = 2;
                }
                jVar.ejs.setTag(R.id.tag_user_id, postData.adv().getUserId());
                jVar.ejs.setTag(R.id.tag_user_name, postData.adv().getUserName());
                jVar.ejs.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                jVar.ejs.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGF, postData, postData.locate, i2, 2));
                String name_show = postData.adv().getName_show();
                String userName = postData.adv().getUserName();
                if (com.baidu.tbadk.t.as.iE() && name_show != null && !name_show.equals(userName)) {
                    jVar.ejs.setText(com.baidu.tieba.pb.c.aD(this.mContext, jVar.ejs.getText().toString()));
                    jVar.ejs.setGravity(16);
                    jVar.ejs.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPv());
                    com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_other_e, 1);
                }
                if (postData.adv().getPendantData() != null && !StringUtils.isNull(postData.adv().getPendantData().abS())) {
                    jVar.hHC.b(postData.adv());
                    jVar.hHu.setVisibility(8);
                    jVar.hHC.setVisibility(0);
                    jVar.hHC.getHeadView().startLoad(portrait, 28, false);
                    jVar.hHC.getHeadView().setUserId(postData.adv().getUserId());
                    jVar.hHC.getHeadView().setUserName(postData.adv().getUserName());
                    jVar.hHC.getHeadView().setFid(this.hGF != null ? this.hGF.getForumId() : "");
                    jVar.hHC.getHeadView().setTid(postData.getId());
                    jVar.hHC.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGF, postData, postData.locate, i2, 2));
                    jVar.hHC.ow(postData.adv().getPendantData().abS());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hHu, postData.adv());
                    jVar.hHu.setUserId(postData.adv().getUserId());
                    jVar.hHu.setFid(this.hGF != null ? this.hGF.getForumId() : "");
                    jVar.hHu.setTid(postData.getId());
                    jVar.hHu.setUserName(postData.adv().getUserName(), postData.cmH());
                    jVar.hHu.setTag(R.id.tag_virtual_user_url, postData.adv().getVirtualUserUrl());
                    jVar.hHu.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hGF, postData, postData.locate, i2, 2));
                    jVar.hHu.setImageDrawable(null);
                    jVar.hHu.startLoad(portrait, 28, false);
                    jVar.hHu.setVisibility(0);
                    jVar.hHC.setVisibility(8);
                }
                if (postData.adv() != null) {
                    MetaData adv = postData.adv();
                    com.baidu.tbadk.core.util.al.j(jVar.hHo, R.color.cp_btn_a);
                    if (this.mHostId != null && !this.mHostId.equals("0") && this.mHostId.equals(adv.getUserId())) {
                        int ih = com.baidu.tbadk.core.util.al.ih(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.al.k(jVar.hHo, ih);
                        jVar.hHo.setTag(Integer.valueOf(ih));
                        jVar.hHo.setVisibility(0);
                        jVar.hHo.setText(R.string.host_name);
                    } else if (adv.getIs_bawu() == 1 && postData.cmp()) {
                        com.baidu.tbadk.core.util.al.k(jVar.hHo, R.drawable.brand_official_btn);
                        jVar.hHo.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hHo.setVisibility(0);
                        jVar.hHo.setText(R.string.brand_Official);
                    } else if (adv.getIs_bawu() == 1 && "manager".equals(adv.getBawu_type())) {
                        int ih2 = com.baidu.tbadk.core.util.al.ih(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.al.k(jVar.hHo, ih2);
                        jVar.hHo.setTag(Integer.valueOf(ih2));
                        jVar.hHo.setVisibility(0);
                        jVar.hHo.setText(R.string.bawu_member_bazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "assist".equals(adv.getBawu_type())) {
                        int ih3 = com.baidu.tbadk.core.util.al.ih(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.al.k(jVar.hHo, ih3);
                        jVar.hHo.setTag(Integer.valueOf(ih3));
                        jVar.hHo.setVisibility(0);
                        jVar.hHo.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_content_assist".equals(adv.getBawu_type())) {
                        int ih4 = com.baidu.tbadk.core.util.al.ih(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.al.k(jVar.hHo, ih4);
                        jVar.hHo.setTag(Integer.valueOf(ih4));
                        jVar.hHo.setVisibility(0);
                        jVar.hHo.setText(R.string.bawu_content_assist_tip);
                    } else if (adv.getIs_bawu() == 1 && "pri_manage_assist".equals(adv.getBawu_type())) {
                        int ih5 = com.baidu.tbadk.core.util.al.ih(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.al.k(jVar.hHo, ih5);
                        jVar.hHo.setTag(Integer.valueOf(ih5));
                        jVar.hHo.setVisibility(0);
                        jVar.hHo.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hHo.setVisibility(8);
                        jVar.hHo.setTag(null);
                    }
                } else {
                    jVar.hHo.setVisibility(8);
                    jVar.hHo.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hGq.bQI()) {
                if (postData.adv() != null) {
                    i3 = postData.adv().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hHB.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(jVar.hHB, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hHB.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hHE.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hHE.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hHo.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hHD.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aeP() > 1000) {
                i4 -= 2;
            }
            if (postData.aeP() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hHE.setVisibility(8);
                if (jVar.hHE.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hHE.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hHo.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hHo.setVisibility(8);
                }
                if (i4 < 10 && jVar.hHB.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hHB.setVisibility(8);
                }
            }
            String name_show2 = postData.adv() != null ? postData.adv().getName_show() : "";
            int qW = com.baidu.tbadk.util.ab.qW(name_show2);
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getSealPrefix())) {
                if (qW > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ab.ad(name_show2, i4 - 2) + "...";
                }
            } else if (qW > i4) {
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
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cmx()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.adv() != null && !StringUtils.isNull(postData.adv().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hGF != null && this.hGF.bPY() != 0) {
                if (this.hGF.bPY() != 1002 && this.hGF.bPY() != 3) {
                    z10 = true;
                }
                if (this.hGF.bPY() != 3) {
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
                        if (this.hGF != null && this.hGF.bPM() != null && this.hGF.bPM().adv() != null && postData.adv() != null) {
                            userId = this.hGF.bPM().adv().getUserId();
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
                                if (postData.cmx() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGF.bPY()));
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
                                    if (this.hGF.bPM() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hGF.bPM().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hGF.bPY()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hHv.setTag(sparseArray);
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
                        if (postData.cmx() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hHv.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hGF != null) {
                userId = this.hGF.bPM().adv().getUserId();
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
            if (postData.cmx() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hHv.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.afl() != null) {
            postData.afl().threadId = this.hGq.bQS().bSJ();
            postData.afl().objType = 1;
            postData.afl().isInPost = true;
            jVar.hHt.setData(postData.afl());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cmx() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cmx()));
                jVar.hHA.setVisibility(0);
                jVar.hHA.setText(format);
                z = true;
            } else {
                jVar.hHA.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cmA = postData.cmA();
            boolean z2 = (cmA == null || StringUtils.isNull(cmA.getName())) ? false : true;
            if (z) {
                jVar.hHq.setVisibility(0);
                i = this.hHe;
            } else {
                jVar.hHq.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hHr.setVisibility(0);
                i2 = this.hHe;
            } else {
                jVar.hHr.setVisibility(8);
                i2 = 0;
            }
            jVar.hHp.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hHp.setText(com.baidu.tbadk.core.util.ap.aE(postData.getTime()));
            } else {
                jVar.hHp.setText(com.baidu.tbadk.core.util.ap.aC(postData.getTime()));
            }
            if (z2) {
                jVar.hHs.setVisibility(0);
                jVar.hHs.setPadding(this.hHe, 0, 0, 0);
                if (postData.iZz) {
                    jVar.hHs.setText(com.baidu.tbadk.core.util.ap.i(cmA.getName(), 7, "..."));
                    return;
                } else {
                    jVar.hHs.setText(cmA.getName());
                    return;
                }
            }
            jVar.hHs.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHv.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hHv.setPadding(0, 0, 0, 0);
            if (!this.hGG) {
                jVar.hHv.getLayoutStrategy().lp(R.drawable.icon_click);
            } else {
                jVar.hHv.rk(null);
                jVar.hHv.setBackgroundDrawable(null);
                jVar.hHv.getLayoutStrategy().lp(R.drawable.transparent_bg);
            }
            jVar.hHv.getLayoutStrategy().lm(R.drawable.pic_video);
            a(jVar.hHv, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hHv.setLayoutParams(layoutParams);
            jVar.hHv.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            jVar.hHv.setIsFromCDN(this.mIsFromCDN);
            TbRichText cmz = postData.cmz();
            jVar.hHv.setIsUseGridImage(postData.cmK());
            jVar.hHv.setText(cmz, true, this.hHg);
            SparseArray sparseArray = (SparseArray) jVar.hHv.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hHv.setTag(sparseArray);
            jVar.hHm.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().cKz = (af - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().lo((int) (af * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cmB() > 0) {
                jVar.hHz.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hHz.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hHz.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cmJ() == 2) {
                    jVar.hHz.setVisibility(8);
                } else {
                    jVar.hHz.setVisibility(0);
                }
                jVar.hHy.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cmB() > 0) {
                    jVar.hHy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cmB())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hHy.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hHy.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hHy.setVisibility(0);
                    jVar.hHz.setVisibility(8);
                    jVar.hHx.setVisibility(8);
                }
            } else {
                jVar.hHy.setVisibility(8);
                if (postData.cmB() > 0 && postData.cmu() != null && postData.cmu().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hHx.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hHx.setLayoutParams(layoutParams);
                    if (this.hHh == null) {
                        this.hHh = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hHh.setIsFromCDN(this.mIsFromCDN);
                        this.hHh.setOnLongClickListener(this.cll);
                        this.hHh.O(this.hGP);
                        this.hHh.v(this.mCommonClickListener);
                        String str = null;
                        if (this.hGF != null && this.hGF.bPM() != null && this.hGF.bPM().adv() != null) {
                            str = this.hGF.bPM().adv().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hGF != null) {
                            this.hHh.M(this.hGF.bPY(), z);
                            this.hHh.ai(this.hGF.bPM());
                        }
                    }
                    this.hHh.BD(postData.getId());
                    jVar.hHx.setSubPbAdapter(this.hHh);
                    jVar.hHx.setVisibility(0);
                    jVar.hHx.setData(postData, view);
                    jVar.hHx.setChildOnClickListener(this.mCommonClickListener);
                    jVar.hHx.setChildOnLongClickListener(this.cll);
                    jVar.hHx.setChildOnTouchListener(this.hHi);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hHx.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hHx.setLayoutParams(layoutParams2);
                    jVar.hHx.setVisibility(8);
                }
            }
            if (postData.iZq) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hHJ != null && jVar.hHG != null) {
            if (postData == null || postData.iZt == null || StringUtils.isNull(postData.iZt.liveTitle)) {
                jVar.hHG.setVisibility(8);
                return;
            }
            jVar.hHJ.setText(postData.iZt.liveTitle);
            jVar.hHG.setTag(postData.iZt);
            jVar.hHG.setVisibility(0);
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hHO.setVisibility(postData.iZz ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.al.f(jVar.ejs, R.color.cp_cont_b, 1);
                if (jVar.hHo.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.al.k(jVar.hHo, ((Integer) jVar.hHo.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.al.f(jVar.hHp, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.j(jVar.hHq, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.j(jVar.hHr, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.f(jVar.hHA, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.al.f(jVar.hHs, R.color.cp_cont_d, 1);
                jVar.hHv.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.al.l(jVar.hHx, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.j(jVar.hHy, R.color.cp_cont_c);
                jVar.hHy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.al.j(jVar.hHz, R.color.cp_cont_c);
                jVar.hHx.onChangeSkinType();
                jVar.hHw.onChangeSkinType();
                com.baidu.tbadk.core.util.al.f(jVar.hHJ, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.al.f(jVar.hHH, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.al.k(jVar.hHG, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.al.k(jVar.hHI, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.c(jVar.hHK, (int) R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.al.j(jVar.hHN, R.color.cp_cont_c);
                if (jVar.hHL.getVisibility() == 8) {
                    jVar.hHN.setText(R.string.close_content);
                } else if (this.hGF != null && StringUtils.isNull(this.hGF.bPU())) {
                    jVar.hHN.setText(this.hGF.bPU());
                } else {
                    jVar.hHN.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hHm.setOnTouchListener(this.hHi);
        jVar.hHm.setOnLongClickListener(this.cll);
        if (this.hGq.getPageContext() != null && this.hGq.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hGq.getPageContext().getOrignalPage()).hEq;
            jVar.ejs.setOnClickListener(aVar.fQX);
            jVar.hHu.setOnClickListener(aVar.fQX);
            jVar.hHC.setOnClickListener(aVar.fQX);
            jVar.hHC.getHeadView().setOnClickListener(aVar.fQX);
            jVar.hHv.setOnLongClickListener(this.cll);
            jVar.hHv.setOnTouchListener(this.hHi);
            jVar.hHv.setCommonTextViewOnClickListener(this.mCommonClickListener);
            jVar.hHv.setOnImageClickListener(this.cIN);
            jVar.hHv.setOnImageTouchListener(this.hHi);
            jVar.hHv.setOnEmotionClickListener(aVar.hRI);
            jVar.hHv.setOnVoiceAfterClickListener(this.mCommonClickListener);
            jVar.hHF.setOnClickListener(this.mCommonClickListener);
            jVar.hHG.setOnClickListener(this.mCommonClickListener);
            jVar.hHy.setOnClickListener(this.mCommonClickListener);
            jVar.hHz.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hHg = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hGF = dVar;
    }

    public void setHostId(String str) {
        this.mHostId = str;
    }

    public void nS(boolean z) {
        this.hGG = z;
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hGq.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hHv.setTextViewOnTouchListener(this.ckh);
        jVar.hHv.setTextViewCheckSelection(false);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGP = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ckh = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cll = onLongClickListener;
    }
}
