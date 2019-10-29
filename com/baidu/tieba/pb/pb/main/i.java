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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private View.OnClickListener ZX;
    private int aeV;
    private String afg;
    private TbRichTextView.h cUE;
    private boolean cXh;
    private com.baidu.tieba.pb.a.c czv;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fAu;
    private com.baidu.adp.lib.e.b<TbImageView> fAv;
    private int hKs;
    private int hKt;
    private int hKu;
    private int hON;
    private int hOO;
    private TbRichTextView.c hOP;
    private com.baidu.tieba.pb.pb.sub.c hOQ;
    private com.baidu.tieba.pb.a.c hOR;
    protected com.baidu.tieba.pb.data.d hOn;
    private boolean hOp;
    private View.OnClickListener hOy;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hPc != null && jVar.hPc.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bXQ = 5;
                dVar.bXS = 2;
                jVar.hPc.setStatisticData(dVar);
                jVar.hPc.anu();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aeV = 0;
        this.hKs = 0;
        this.hON = 0;
        this.hKt = 0;
        this.hOO = 0;
        this.hKu = 0;
        this.hOP = null;
        this.hOp = true;
        this.afg = null;
        this.hOn = null;
        this.hOy = null;
        this.ZX = null;
        this.cUE = null;
        this.czv = null;
        this.mOnLongClickListener = null;
        this.hOQ = null;
        this.cXh = true;
        this.fAu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
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
        this.fAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoe */
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
        this.hOR = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hNY == null || i.this.hNY.bRX() == null || i.this.hNY.bRX().bVb())) {
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
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (i.this.czv != null) {
                    if (!(view instanceof TbListTextView) || i.this.ZX == null) {
                        i.this.czv.N(view);
                        i.this.czv.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    i.this.ZX.onClick(view);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public j b(ViewGroup viewGroup) {
        j jVar = new j(this.hNY.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hPf.setConstrainLayoutPool(this.fAu);
        jVar.hPf.setImageViewPool(this.fAv);
        a(jVar);
        this.aeV = getDimensionPixelSize(R.dimen.tbds10);
        this.hKs = getDimensionPixelSize(R.dimen.tbds12);
        this.hON = getDimensionPixelSize(R.dimen.tbds14);
        this.hKt = getDimensionPixelSize(R.dimen.tbds16);
        this.hOO = getDimensionPixelSize(R.dimen.tbds36);
        this.hKu = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hPe != null) {
            jVar.hPe.setDuiEnabled(this.cXh);
        }
        return jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, j jVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) jVar);
        a(jVar);
        b(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            h(postData2);
            i(postData2);
            postData2.ajK();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cXh = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.isEmpty(postData.com())) {
            int i = 8;
            if (postData.jjj) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.hOn, postData, postData.locate, i, 6);
            postData.jjk = b;
            Iterator<PostData> it = postData.com().iterator();
            while (it.hasNext()) {
                it.next().jjk = b;
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
        if (jVar != null && this.hNY != null && this.hNY.bRF() != null && this.hNY.bRF().bUq() && com.baidu.tbadk.core.util.aq.equals(this.hNY.bRF().bTz(), postData.getId())) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(jVar.hOV, R.color.cp_other_g);
        } else {
            jVar.hOV.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hPu.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hPw.setText(R.string.expand_content);
                return;
            } else {
                jVar.hPw.setText(str);
                return;
            }
        }
        jVar.hPu.setVisibility(0);
        jVar.hPw.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.coB() == 2 || postData.coB() == 4) {
            jVar.hPv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hPu.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bQH());
                    postData.qN(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hNY.bRX() != null && i.this.hNY.bRX().bWb() != null && i.this.hNY.bRX().getListView() != null && !z && jVar.getView().getTop() < i.this.hNY.bRX().bWb().getMeasuredHeight()) {
                        i.this.hNY.bRX().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(i.this.hNY.bRX().getListView().getData(), postData) + i.this.hNY.bRX().getListView().getHeaderViewsCount(), i.this.hNY.bRX().bWb().getMeasuredHeight());
                    }
                }
            });
            jVar.hPv.setVisibility(0);
            a(jVar, postData.cok(), postData.bQH());
            a(true, jVar, postData);
        } else {
            jVar.hPv.setVisibility(8);
            jVar.hPu.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hPv != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hPv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.com());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hPv.getLayoutParams();
            if (z) {
                jVar.hPe.getLayoutStrategy().kL(0);
                if (z2) {
                    jVar.hPe.getLayoutStrategy().kK(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hPe.getLayoutStrategy().kK(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hPv.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hPe.getLayoutStrategy().kK(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hPe.getLayoutStrategy().kL(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cor = postData.cor();
        cor.isChanged = true;
        jVar.hPe.setText(cor, true, this.hOP);
    }

    private void h(PostData postData) {
        if (postData.ccN == 0 && postData.fCZ) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.bS("post_id", postData.getId());
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bS("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.bS("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.bS("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.p(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.hNY != null) {
                int bUj = this.hNY.bRF().bUj();
                if (1 == bUj || 2 == bUj) {
                    anVar.bS("obj_source", "1");
                } else if (3 == bUj) {
                    anVar.bS("obj_source", "2");
                } else {
                    anVar.bS("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hNY.getUniqueId(), this.hOn, postData, postData.locate, postData.jjj ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bXF() == null) {
            jVar.hPo.setVisibility(8);
            return;
        }
        TbRichText cor = postData.cor();
        com.baidu.tieba.pb.view.b.a(postData.bXF(), jVar.hPo, false, false, cor != null && StringUtils.isNull(cor.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hOp) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hPe.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hPe.setLayoutParams(layoutParams);
            jVar.hPe.setPadding(0, 0, 0, 0);
            jVar.hPe.qx(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hPe.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hPe.setLayoutParams(layoutParams2);
            jVar.hPe.qx(postData.getBimg_url());
        }
        jVar.hPe.setTextViewOnTouchListener(this.hOR);
        jVar.hPe.setTextViewCheckSelection(false);
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
            if (postData.jiZ) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hPd.setTag(null);
            jVar.hPd.setUserId(null);
            jVar.eAg.setText((CharSequence) null);
            jVar.hPl.getHeadView().setUserId(null);
            jVar.hPe.setIsHost(false);
            if (postData.aiG() != null) {
                if (this.afg != null && !this.afg.equals("0") && this.afg.equals(postData.aiG().getUserId())) {
                    jVar.hPe.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aiG().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aiG().getTShowInfoNew();
                if (jVar.hPn != null) {
                    jVar.hPn.setTag(R.id.tag_user_id, postData.aiG().getUserId());
                    jVar.hPn.setOnClickListener(this.hNY.hLX.hZt);
                    jVar.hPn.a(iconInfo, 2, this.hKu, this.hKu, this.aeV);
                }
                if (jVar.hPm != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hPm.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hPm.setOnClickListener(this.hNY.hLX.hZu);
                    jVar.hPm.a(tShowInfoNew, 3, this.hKu, this.hKu, this.aeV, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aiG().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.eAg, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.eAg, R.color.cp_cont_b, 1);
                }
                String portrait = postData.aiG().getPortrait();
                int i2 = 8;
                if (postData.jjj) {
                    i2 = 2;
                }
                jVar.eAg.setTag(R.id.tag_user_id, postData.aiG().getUserId());
                jVar.eAg.setTag(R.id.tag_user_name, postData.aiG().getUserName());
                jVar.eAg.setTag(R.id.tag_virtual_user_url, postData.aiG().getVirtualUserUrl());
                jVar.eAg.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hOn, postData, postData.locate, i2, 2));
                String name_show = postData.aiG().getName_show();
                String userName = postData.aiG().getUserName();
                if (com.baidu.tbadk.t.as.isOn() && name_show != null && !name_show.equals(userName)) {
                    jVar.eAg.setText(com.baidu.tieba.pb.c.aI(this.mContext, jVar.eAg.getText().toString()));
                    jVar.eAg.setGravity(16);
                    jVar.eAg.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQg());
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.eAg, R.color.cp_other_e, 1);
                }
                if (postData.aiG().getPendantData() != null && !StringUtils.isNull(postData.aiG().getPendantData().ahf())) {
                    jVar.hPl.b(postData.aiG());
                    jVar.hPd.setVisibility(8);
                    jVar.hPl.setVisibility(0);
                    jVar.hPl.getHeadView().startLoad(portrait, 28, false);
                    jVar.hPl.getHeadView().setUserId(postData.aiG().getUserId());
                    jVar.hPl.getHeadView().setUserName(postData.aiG().getUserName());
                    jVar.hPl.getHeadView().setFid(this.hOn != null ? this.hOn.getForumId() : "");
                    jVar.hPl.getHeadView().setTid(postData.getId());
                    jVar.hPl.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hOn, postData, postData.locate, i2, 2));
                    jVar.hPl.ou(postData.aiG().getPendantData().ahf());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hPd, postData.aiG());
                    jVar.hPd.setUserId(postData.aiG().getUserId());
                    jVar.hPd.setFid(this.hOn != null ? this.hOn.getForumId() : "");
                    jVar.hPd.setTid(postData.getId());
                    jVar.hPd.setUserName(postData.aiG().getUserName(), postData.coz());
                    jVar.hPd.setTag(R.id.tag_virtual_user_url, postData.aiG().getVirtualUserUrl());
                    jVar.hPd.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hOn, postData, postData.locate, i2, 2));
                    jVar.hPd.setImageDrawable(null);
                    jVar.hPd.startLoad(portrait, 28, false);
                    jVar.hPd.setVisibility(0);
                    jVar.hPl.setVisibility(8);
                }
                if (postData.aiG() != null) {
                    MetaData aiG = postData.aiG();
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOX, (int) R.color.cp_cont_a);
                    if (this.afg != null && !this.afg.equals("0") && this.afg.equals(aiG.getUserId())) {
                        int is = com.baidu.tbadk.core.util.am.is(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOX, is);
                        jVar.hOX.setTag(Integer.valueOf(is));
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.host_name);
                    } else if (aiG.getIs_bawu() == 1 && postData.coh()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOX, R.drawable.brand_official_btn);
                        jVar.hOX.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.brand_Official);
                    } else if (aiG.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aiG.getBawu_type())) {
                        int is2 = com.baidu.tbadk.core.util.am.is(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOX, is2);
                        jVar.hOX.setTag(Integer.valueOf(is2));
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aiG.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aiG.getBawu_type())) {
                        int is3 = com.baidu.tbadk.core.util.am.is(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOX, is3);
                        jVar.hOX.setTag(Integer.valueOf(is3));
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aiG.getIs_bawu() == 1 && "pri_content_assist".equals(aiG.getBawu_type())) {
                        int is4 = com.baidu.tbadk.core.util.am.is(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOX, is4);
                        jVar.hOX.setTag(Integer.valueOf(is4));
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_content_assist_tip);
                    } else if (aiG.getIs_bawu() == 1 && "pri_manage_assist".equals(aiG.getBawu_type())) {
                        int is5 = com.baidu.tbadk.core.util.am.is(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOX, is5);
                        jVar.hOX.setTag(Integer.valueOf(is5));
                        jVar.hOX.setVisibility(0);
                        jVar.hOX.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hOX.setVisibility(8);
                        jVar.hOX.setTag(null);
                    }
                } else {
                    jVar.hOX.setVisibility(8);
                    jVar.hOX.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hNY.bRv()) {
                if (postData.aiG() != null) {
                    i3 = postData.aiG().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hPk.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(jVar.hPk, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hPk.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hPn.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hPn.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hOX.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hPm.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.ajZ() > 1000) {
                i4 -= 2;
            }
            if (postData.ajZ() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hPn.setVisibility(8);
                if (jVar.hPn.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hPn.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hOX.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hOX.setVisibility(8);
                }
                if (i4 < 10 && jVar.hPk.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hPk.setVisibility(8);
                }
            }
            String name_show2 = postData.aiG() != null ? postData.aiG().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.aa.getTextLengthWithEmoji(name_show2);
            if (postData.aiG() != null && !StringUtils.isNull(postData.aiG().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.aa.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.aa.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aiG() != null && !StringUtils.isNull(postData.aiG().getSealPrefix())) {
                jVar.eAg.setText(bV(postData.aiG().getSealPrefix(), name_show2));
            } else {
                jVar.eAg.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cop()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aiG() != null && !StringUtils.isNull(postData.aiG().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hOn != null && this.hOn.bQL() != 0) {
                if (this.hOn.bQL() != 1002 && this.hOn.bQL() != 3) {
                    z10 = true;
                }
                if (this.hOn.bQL() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.aiG() != null) {
                    String userId2 = postData.aiG().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQz().aiG() != null && postData.aiG() != null) {
                            userId = this.hOn.bQz().aiG().getUserId();
                            String userId3 = postData.aiG().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aiG() != null && UtilHelper.isCurrentAccount(postData.aiG().getUserId())) {
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
                                if (postData.cop() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hOn.bQL()));
                                    if (postData.aiG() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aiG().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiG().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiG().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aiG() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiG().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiG().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiG().getName_show());
                                    }
                                    if (this.hOn.bQz() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hOn.bQz().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hOn.bQL()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hPe.setTag(sparseArray);
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
                        if (postData.cop() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hPe.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hOn != null) {
                userId = this.hOn.bQz().aiG().getUserId();
                String userId32 = postData.aiG().getUserId();
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
            if (postData.cop() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hPe.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.akv() != null) {
            postData.akv().threadId = this.hNY.bRF().bTA();
            postData.akv().objType = 1;
            postData.akv().isInPost = true;
            jVar.hPc.setData(postData.akv());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.cop() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cop()));
                jVar.hPj.setVisibility(0);
                jVar.hPj.setText(format);
                z = true;
            } else {
                jVar.hPj.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cos = postData.cos();
            boolean z2 = (cos == null || StringUtils.isNull(cos.getName())) ? false : true;
            if (z) {
                jVar.hOZ.setVisibility(0);
                i = this.hON;
            } else {
                jVar.hOZ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hPa.setVisibility(0);
                i2 = this.hON;
            } else {
                jVar.hPa.setVisibility(8);
                i2 = 0;
            }
            jVar.hOY.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hOY.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                jVar.hOY.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                jVar.hPb.setVisibility(0);
                jVar.hPb.setPadding(this.hON, 0, 0, 0);
                if (postData.jjh) {
                    jVar.hPb.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cos.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    jVar.hPb.setText(cos.getName());
                    return;
                }
            }
            jVar.hPb.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hPe.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hPe.setPadding(0, 0, 0, 0);
            if (!this.hOp) {
                jVar.hPe.getLayoutStrategy().kF(R.drawable.icon_click);
            } else {
                jVar.hPe.qx(null);
                jVar.hPe.setBackgroundDrawable(null);
                jVar.hPe.getLayoutStrategy().kF(R.drawable.transparent_bg);
            }
            jVar.hPe.getLayoutStrategy().kC(R.drawable.pic_video);
            a(jVar.hPe, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hPe.setLayoutParams(layoutParams);
            jVar.hPe.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            jVar.hPe.setIsFromCDN(this.mIsFromCDN);
            TbRichText cor = postData.cor();
            jVar.hPe.setIsUseGridImage(postData.coC());
            jVar.hPe.setText(cor, true, this.hOP);
            SparseArray sparseArray = (SparseArray) jVar.hPe.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hPe.setTag(sparseArray);
            jVar.hOV.setTag(R.id.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds90) : 0;
            tbRichTextView.getLayoutStrategy().kD(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cWi = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().kE((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cot() > 0) {
                jVar.hPi.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hPi.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hPi.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.coB() == 2) {
                    jVar.hPi.setVisibility(8);
                } else {
                    jVar.hPi.setVisibility(0);
                }
                jVar.hPh.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cot() > 0) {
                    jVar.hPh.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cot())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hPh.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hPh.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hPh.setVisibility(0);
                    jVar.hPi.setVisibility(8);
                    jVar.hPg.setVisibility(8);
                }
            } else {
                jVar.hPh.setVisibility(8);
                if (postData.cot() > 0 && postData.com() != null && postData.com().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hPg.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hPg.setLayoutParams(layoutParams);
                    if (this.hOQ == null) {
                        this.hOQ = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hOQ.setIsFromCDN(this.mIsFromCDN);
                        this.hOQ.setOnLongClickListener(this.mOnLongClickListener);
                        this.hOQ.R(this.hOy);
                        this.hOQ.w(this.ZX);
                        String str = null;
                        if (this.hOn != null && this.hOn.bQz() != null && this.hOn.bQz().aiG() != null) {
                            str = this.hOn.bQz().aiG().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hOn != null) {
                            this.hOQ.N(this.hOn.bQL(), z);
                            this.hOQ.ai(this.hOn.bQz());
                        }
                    }
                    this.hOQ.Bi(postData.getId());
                    jVar.hPg.setSubPbAdapter(this.hOQ);
                    jVar.hPg.setVisibility(0);
                    jVar.hPg.setData(postData, view);
                    jVar.hPg.setChildOnClickListener(this.ZX);
                    jVar.hPg.setChildOnLongClickListener(this.mOnLongClickListener);
                    jVar.hPg.setChildOnTouchListener(this.hOR);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hPg.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hPg.setLayoutParams(layoutParams2);
                    jVar.hPg.setVisibility(8);
                }
            }
            if (postData.jiY) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hPs != null && jVar.hPp != null) {
            if (postData == null || postData.jjb == null || StringUtils.isNull(postData.jjb.liveTitle)) {
                jVar.hPp.setVisibility(8);
                return;
            }
            jVar.hPs.setText(postData.jjb.liveTitle);
            jVar.hPp.setTag(postData.jjb);
            jVar.hPp.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hPx.setVisibility(postData.jjh ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.eAg, R.color.cp_cont_b, 1);
                if (jVar.hOX.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOX, ((Integer) jVar.hOX.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOY, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOZ, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPa, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPj, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPb, R.color.cp_cont_d, 1);
                jVar.hPe.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(jVar.hPg, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPh, (int) R.color.cp_cont_c);
                jVar.hPh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPi, (int) R.color.cp_cont_c);
                jVar.hPg.onChangeSkinType();
                jVar.hPf.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPs, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPq, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hPp, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hPr, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(jVar.hPt, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hPw, (int) R.color.cp_cont_c);
                if (jVar.hPu.getVisibility() == 8) {
                    jVar.hPw.setText(R.string.close_content);
                } else if (this.hOn != null && StringUtils.isNull(this.hOn.bQH())) {
                    jVar.hPw.setText(this.hOn.bQH());
                } else {
                    jVar.hPw.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hOV.setOnTouchListener(this.hOR);
        jVar.hOV.setOnLongClickListener(this.mOnLongClickListener);
        if (this.hNY.getPageContext() != null && this.hNY.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hNY.getPageContext().getOrignalPage()).hLX;
            jVar.eAg.setOnClickListener(aVar.fXW);
            jVar.hPd.setOnClickListener(aVar.fXW);
            jVar.hPl.setOnClickListener(aVar.fXW);
            jVar.hPl.getHeadView().setOnClickListener(aVar.fXW);
            jVar.hPe.setOnLongClickListener(this.mOnLongClickListener);
            jVar.hPe.setOnTouchListener(this.hOR);
            jVar.hPe.setCommonTextViewOnClickListener(this.ZX);
            jVar.hPe.setOnImageClickListener(this.cUE);
            jVar.hPe.setOnImageTouchListener(this.hOR);
            jVar.hPe.setOnEmotionClickListener(aVar.hZv);
            jVar.hPe.setOnVoiceAfterClickListener(this.ZX);
            jVar.hPo.setOnClickListener(this.ZX);
            jVar.hPp.setOnClickListener(this.ZX);
            jVar.hPh.setOnClickListener(this.ZX);
            jVar.hPi.setOnClickListener(this.ZX);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hOP = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hOn = dVar;
    }

    public void cD(String str) {
        this.afg = str;
    }

    public void nT(boolean z) {
        this.hOp = z;
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hNY.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hPe.setTextViewOnTouchListener(this.czv);
        jVar.hPe.setTextViewCheckSelection(false);
    }

    public void O(View.OnClickListener onClickListener) {
        this.hOy = onClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZX = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cUE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.czv = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
