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
    private View.OnClickListener ZF;
    private int aeD;
    private String aeO;
    private TbRichTextView.h cTN;
    private boolean cWq;
    private com.baidu.tieba.pb.a.c cyE;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fzD;
    private com.baidu.adp.lib.e.b<TbImageView> fzE;
    private int hJB;
    private int hJC;
    private int hJD;
    private View.OnClickListener hNH;
    private int hNW;
    private int hNX;
    private TbRichTextView.c hNY;
    private com.baidu.tieba.pb.pb.sub.c hNZ;
    protected com.baidu.tieba.pb.data.d hNw;
    private boolean hNy;
    private com.baidu.tieba.pb.a.c hOa;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(View view) {
        if (view != null && (view.getTag() instanceof j)) {
            j jVar = (j) view.getTag();
            if (jVar.hOl != null && jVar.hOl.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.bWZ = 5;
                dVar.bXb = 2;
                jVar.hOl.setStatisticData(dVar);
                jVar.hOl.ans();
            }
        }
    }

    public i(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aeD = 0;
        this.hJB = 0;
        this.hNW = 0;
        this.hJC = 0;
        this.hNX = 0;
        this.hJD = 0;
        this.hNY = null;
        this.hNy = true;
        this.aeO = null;
        this.hNw = null;
        this.hNH = null;
        this.ZF = null;
        this.cTN = null;
        this.cyE = null;
        this.mOnLongClickListener = null;
        this.hNZ = null;
        this.cWq = true;
        this.fzD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: blZ */
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
        this.fzE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoc */
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
        this.hOa = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.i.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (i.this.hNh == null || i.this.hNh.bRV() == null || i.this.hNh.bRV().bUZ())) {
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
                if (i.this.cyE != null) {
                    if (!(view instanceof TbListTextView) || i.this.ZF == null) {
                        i.this.cyE.N(view);
                        i.this.cyE.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    i.this.ZF.onClick(view);
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
        j jVar = new j(this.hNh.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false));
        jVar.hOo.setConstrainLayoutPool(this.fzD);
        jVar.hOo.setImageViewPool(this.fzE);
        a(jVar);
        this.aeD = getDimensionPixelSize(R.dimen.tbds10);
        this.hJB = getDimensionPixelSize(R.dimen.tbds12);
        this.hNW = getDimensionPixelSize(R.dimen.tbds14);
        this.hJC = getDimensionPixelSize(R.dimen.tbds16);
        this.hNX = getDimensionPixelSize(R.dimen.tbds36);
        this.hJD = getDimensionPixelSize(R.dimen.tbds40);
        if (jVar.hOn != null) {
            jVar.hOn.setDuiEnabled(this.cWq);
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
            postData2.ajI();
            g(postData2);
            a(jVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.cWq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.isEmpty(postData.cok())) {
            int i = 8;
            if (postData.jis) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.hNw, postData, postData.locate, i, 6);
            postData.jit = b;
            Iterator<PostData> it = postData.cok().iterator();
            while (it.hasNext()) {
                it.next().jit = b;
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
        if (jVar != null && this.hNh != null && this.hNh.bRD() != null && this.hNh.bRD().bUo() && com.baidu.tbadk.core.util.aq.equals(this.hNh.bRD().bTx(), postData.getId())) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(jVar.hOe, R.color.cp_other_g);
        } else {
            jVar.hOe.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar, boolean z, String str) {
        if (z) {
            jVar.hOD.setVisibility(8);
            if (StringUtils.isNull(str)) {
                jVar.hOF.setText(R.string.expand_content);
                return;
            } else {
                jVar.hOF.setText(str);
                return;
            }
        }
        jVar.hOD.setVisibility(0);
        jVar.hOF.setText(R.string.close_content);
    }

    private void c(final j jVar, final PostData postData) {
        if (postData.coz() == 2 || postData.coz() == 4) {
            jVar.hOE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = jVar.hOD.getVisibility() == 8;
                    i.this.a(jVar, !z, postData.bQF());
                    postData.qN(z ? false : true);
                    i.this.d(jVar, postData);
                    if (i.this.hNh.bRV() != null && i.this.hNh.bRV().bVZ() != null && i.this.hNh.bRV().getListView() != null && !z && jVar.getView().getTop() < i.this.hNh.bRV().bVZ().getMeasuredHeight()) {
                        i.this.hNh.bRV().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(i.this.hNh.bRV().getListView().getData(), postData) + i.this.hNh.bRV().getListView().getHeaderViewsCount(), i.this.hNh.bRV().bVZ().getMeasuredHeight());
                    }
                }
            });
            jVar.hOE.setVisibility(0);
            a(jVar, postData.coi(), postData.bQF());
            a(true, jVar, postData);
        } else {
            jVar.hOE.setVisibility(8);
            jVar.hOD.setVisibility(0);
            a(false, jVar, postData);
        }
        d(jVar, postData);
    }

    private void a(boolean z, j jVar, PostData postData) {
        if (jVar != null && jVar.mBottomLine != null && jVar.hOE != null && (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (jVar.hOE.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cok());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) jVar.hOE.getLayoutParams();
            if (z) {
                jVar.hOn.getLayoutStrategy().kK(0);
                if (z2) {
                    jVar.hOn.getLayoutStrategy().kJ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    jVar.hOn.getLayoutStrategy().kJ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                jVar.hOE.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    jVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            jVar.hOn.getLayoutStrategy().kJ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            jVar.hOn.getLayoutStrategy().kK(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                jVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(j jVar, PostData postData) {
        TbRichText cop = postData.cop();
        cop.isChanged = true;
        jVar.hOn.setText(cop, true, this.hNY);
    }

    private void h(PostData postData) {
        if (postData.cbV == 0 && postData.fCi) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.bS("post_id", postData.getId());
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bS("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.bS("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.bS("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.p(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.hNh != null) {
                int bUh = this.hNh.bRD().bUh();
                if (1 == bUh || 2 == bUh) {
                    anVar.bS("obj_source", "1");
                } else if (3 == bUh) {
                    anVar.bS("obj_source", "2");
                } else {
                    anVar.bS("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        com.baidu.tieba.pb.c.a.a(this.hNh.getUniqueId(), this.hNw, postData, postData.locate, postData.jis ? 2 : 8);
    }

    private void a(j jVar, PostData postData) {
        if (postData == null || postData.bXD() == null) {
            jVar.hOx.setVisibility(8);
            return;
        }
        TbRichText cop = postData.cop();
        com.baidu.tieba.pb.view.b.a(postData.bXD(), jVar.hOx, false, false, cop != null && StringUtils.isNull(cop.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(j jVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hNy) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOn.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            jVar.hOn.setLayoutParams(layoutParams);
            jVar.hOn.setPadding(0, 0, 0, 0);
            jVar.hOn.qx(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hOn.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            jVar.hOn.setLayoutParams(layoutParams2);
            jVar.hOn.qx(postData.getBimg_url());
        }
        jVar.hOn.setTextViewOnTouchListener(this.hOa);
        jVar.hOn.setTextViewCheckSelection(false);
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
            if (postData.jii) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(jVar.mTopLine, R.color.cp_bg_line_c);
                jVar.mTopLine.setVisibility(0);
            } else {
                jVar.mTopLine.setVisibility(8);
            }
            jVar.hOm.setTag(null);
            jVar.hOm.setUserId(null);
            jVar.ezp.setText((CharSequence) null);
            jVar.hOu.getHeadView().setUserId(null);
            jVar.hOn.setIsHost(false);
            if (postData.aiE() != null) {
                if (this.aeO != null && !this.aeO.equals("0") && this.aeO.equals(postData.aiE().getUserId())) {
                    jVar.hOn.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aiE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aiE().getTShowInfoNew();
                if (jVar.hOw != null) {
                    jVar.hOw.setTag(R.id.tag_user_id, postData.aiE().getUserId());
                    jVar.hOw.setOnClickListener(this.hNh.hLg.hYC);
                    jVar.hOw.a(iconInfo, 2, this.hJD, this.hJD, this.aeD);
                }
                if (jVar.hOv != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        jVar.hOv.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    jVar.hOv.setOnClickListener(this.hNh.hLg.hYD);
                    jVar.hOv.a(tShowInfoNew, 3, this.hJD, this.hJD, this.aeD, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aiE().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.ezp, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.ezp, R.color.cp_cont_b, 1);
                }
                String portrait = postData.aiE().getPortrait();
                int i2 = 8;
                if (postData.jis) {
                    i2 = 2;
                }
                jVar.ezp.setTag(R.id.tag_user_id, postData.aiE().getUserId());
                jVar.ezp.setTag(R.id.tag_user_name, postData.aiE().getUserName());
                jVar.ezp.setTag(R.id.tag_virtual_user_url, postData.aiE().getVirtualUserUrl());
                jVar.ezp.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hNw, postData, postData.locate, i2, 2));
                String name_show = postData.aiE().getName_show();
                String userName = postData.aiE().getUserName();
                if (com.baidu.tbadk.t.as.isOn() && name_show != null && !name_show.equals(userName)) {
                    jVar.ezp.setText(com.baidu.tieba.pb.c.aI(this.mContext, jVar.ezp.getText().toString()));
                    jVar.ezp.setGravity(16);
                    jVar.ezp.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQe());
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.ezp, R.color.cp_other_e, 1);
                }
                if (postData.aiE().getPendantData() != null && !StringUtils.isNull(postData.aiE().getPendantData().ahd())) {
                    jVar.hOu.b(postData.aiE());
                    jVar.hOm.setVisibility(8);
                    jVar.hOu.setVisibility(0);
                    jVar.hOu.getHeadView().startLoad(portrait, 28, false);
                    jVar.hOu.getHeadView().setUserId(postData.aiE().getUserId());
                    jVar.hOu.getHeadView().setUserName(postData.aiE().getUserName());
                    jVar.hOu.getHeadView().setFid(this.hNw != null ? this.hNw.getForumId() : "");
                    jVar.hOu.getHeadView().setTid(postData.getId());
                    jVar.hOu.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hNw, postData, postData.locate, i2, 2));
                    jVar.hOu.ou(postData.aiE().getPendantData().ahd());
                } else {
                    UtilHelper.showHeadImageViewBigV(jVar.hOm, postData.aiE());
                    jVar.hOm.setUserId(postData.aiE().getUserId());
                    jVar.hOm.setFid(this.hNw != null ? this.hNw.getForumId() : "");
                    jVar.hOm.setTid(postData.getId());
                    jVar.hOm.setUserName(postData.aiE().getUserName(), postData.cox());
                    jVar.hOm.setTag(R.id.tag_virtual_user_url, postData.aiE().getVirtualUserUrl());
                    jVar.hOm.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.hNw, postData, postData.locate, i2, 2));
                    jVar.hOm.setImageDrawable(null);
                    jVar.hOm.startLoad(portrait, 28, false);
                    jVar.hOm.setVisibility(0);
                    jVar.hOu.setVisibility(8);
                }
                if (postData.aiE() != null) {
                    MetaData aiE = postData.aiE();
                    com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOg, (int) R.color.cp_cont_a);
                    if (this.aeO != null && !this.aeO.equals("0") && this.aeO.equals(aiE.getUserId())) {
                        int ir = com.baidu.tbadk.core.util.am.ir(R.drawable.author_floor_host);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOg, ir);
                        jVar.hOg.setTag(Integer.valueOf(ir));
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.host_name);
                    } else if (aiE.getIs_bawu() == 1 && postData.cof()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOg, R.drawable.brand_official_btn);
                        jVar.hOg.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.brand_Official);
                    } else if (aiE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aiE.getBawu_type())) {
                        int ir2 = com.baidu.tbadk.core.util.am.ir(R.drawable.author_bazhu_bg);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOg, ir2);
                        jVar.hOg.setTag(Integer.valueOf(ir2));
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aiE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aiE.getBawu_type())) {
                        int ir3 = com.baidu.tbadk.core.util.am.ir(R.drawable.author_small_bazhu);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOg, ir3);
                        jVar.hOg.setTag(Integer.valueOf(ir3));
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aiE.getIs_bawu() == 1 && "pri_content_assist".equals(aiE.getBawu_type())) {
                        int ir4 = com.baidu.tbadk.core.util.am.ir(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOg, ir4);
                        jVar.hOg.setTag(Integer.valueOf(ir4));
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_content_assist_tip);
                    } else if (aiE.getIs_bawu() == 1 && "pri_manage_assist".equals(aiE.getBawu_type())) {
                        int ir5 = com.baidu.tbadk.core.util.am.ir(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOg, ir5);
                        jVar.hOg.setTag(Integer.valueOf(ir5));
                        jVar.hOg.setVisibility(0);
                        jVar.hOg.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        jVar.hOg.setVisibility(8);
                        jVar.hOg.setTag(null);
                    }
                } else {
                    jVar.hOg.setVisibility(8);
                    jVar.hOg.setTag(null);
                }
            }
            int i3 = 0;
            if (this.hNh.bRt()) {
                if (postData.aiE() != null) {
                    i3 = postData.aiE().getLevel_id();
                }
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                jVar.hOt.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(jVar.hOt, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                jVar.hOt.setVisibility(8);
            }
            int i4 = 15;
            if (jVar.hOw.getChildCount() == 1) {
                i4 = 13;
            } else if (jVar.hOw.getChildCount() > 1) {
                i4 = 11;
            }
            if (jVar.hOg.getVisibility() == 0) {
                i4 -= 2;
            }
            if (jVar.hOv.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.ajX() > 1000) {
                i4 -= 2;
            }
            if (postData.ajX() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                jVar.hOw.setVisibility(8);
                if (jVar.hOw.getChildCount() == 1) {
                    i4 += 2;
                } else if (jVar.hOw.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && jVar.hOg.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hOg.setVisibility(8);
                }
                if (i4 < 10 && jVar.hOt.getVisibility() == 0) {
                    i4 += 2;
                    jVar.hOt.setVisibility(8);
                }
            }
            String name_show2 = postData.aiE() != null ? postData.aiE().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.aa.getTextLengthWithEmoji(name_show2);
            if (postData.aiE() != null && !StringUtils.isNull(postData.aiE().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.aa.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.aa.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aiE() != null && !StringUtils.isNull(postData.aiE().getSealPrefix())) {
                jVar.ezp.setText(bV(postData.aiE().getSealPrefix(), name_show2));
            } else {
                jVar.ezp.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.con()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aiE() != null && !StringUtils.isNull(postData.aiE().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.hNw != null && this.hNw.bQJ() != 0) {
                if (this.hNw.bQJ() != 1002 && this.hNw.bQJ() != 3) {
                    z10 = true;
                }
                if (this.hNw.bQJ() != 3) {
                    z11 = true;
                }
                if (postData != null && postData.aiE() != null) {
                    String userId2 = postData.aiE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQx().aiE() != null && postData.aiE() != null) {
                            userId = this.hNw.bQx().aiE().getUserId();
                            String userId3 = postData.aiE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aiE() != null && UtilHelper.isCurrentAccount(postData.aiE().getUserId())) {
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
                                if (postData.con() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNw.bQJ()));
                                    if (postData.aiE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aiE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aiE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiE().getName_show());
                                    }
                                    if (this.hNw.bQx() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.hNw.bQx().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.hNw.bQJ()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                jVar.hOn.setTag(sparseArray);
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
                        if (postData.con() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        jVar.hOn.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.hNw != null) {
                userId = this.hNw.bQx().aiE().getUserId();
                String userId32 = postData.aiE().getUserId();
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
            if (postData.con() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            jVar.hOn.setTag(sparseArray);
        }
    }

    private void f(j jVar, PostData postData) {
        if (jVar != null && postData != null && postData.akt() != null) {
            postData.akt().threadId = this.hNh.bRD().bTy();
            postData.akt().objType = 1;
            postData.akt().isInPost = true;
            jVar.hOl.setData(postData.akt());
        }
    }

    private void g(j jVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (jVar != null && postData != null) {
            if (postData.con() > 0) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.con()));
                jVar.hOs.setVisibility(0);
                jVar.hOs.setText(format);
                z = true;
            } else {
                jVar.hOs.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f coq = postData.coq();
            boolean z2 = (coq == null || StringUtils.isNull(coq.getName())) ? false : true;
            if (z) {
                jVar.hOi.setVisibility(0);
                i = this.hNW;
            } else {
                jVar.hOi.setVisibility(8);
                i = 0;
            }
            if (z2) {
                jVar.hOj.setVisibility(0);
                i2 = this.hNW;
            } else {
                jVar.hOj.setVisibility(8);
                i2 = 0;
            }
            jVar.hOh.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                jVar.hOh.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                jVar.hOh.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                jVar.hOk.setVisibility(0);
                jVar.hOk.setPadding(this.hNW, 0, 0, 0);
                if (postData.jiq) {
                    jVar.hOk.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(coq.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    jVar.hOk.setText(coq.getName());
                    return;
                }
            }
            jVar.hOk.setVisibility(8);
        }
    }

    private void a(j jVar, PostData postData, View view) {
        if (jVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOn.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            jVar.hOn.setPadding(0, 0, 0, 0);
            if (!this.hNy) {
                jVar.hOn.getLayoutStrategy().kE(R.drawable.icon_click);
            } else {
                jVar.hOn.qx(null);
                jVar.hOn.setBackgroundDrawable(null);
                jVar.hOn.getLayoutStrategy().kE(R.drawable.transparent_bg);
            }
            jVar.hOn.getLayoutStrategy().kB(R.drawable.pic_video);
            a(jVar.hOn, view, !StringUtils.isNull(postData.getBimg_url()));
            jVar.hOn.setLayoutParams(layoutParams);
            jVar.hOn.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            jVar.hOn.setIsFromCDN(this.mIsFromCDN);
            TbRichText cop = postData.cop();
            jVar.hOn.setIsUseGridImage(postData.coA());
            jVar.hOn.setText(cop, true, this.hNY);
            SparseArray sparseArray = (SparseArray) jVar.hOn.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            jVar.hOn.setTag(sparseArray);
            jVar.hOe.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().kC(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().cVr = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().kD((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            if (postData.cor() > 0) {
                jVar.hOr.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) jVar.hOr.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    jVar.hOr.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.coz() == 2) {
                    jVar.hOr.setVisibility(8);
                } else {
                    jVar.hOr.setVisibility(0);
                }
                jVar.hOq.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cor() > 0) {
                    jVar.hOq.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cor())));
                    SparseArray sparseArray2 = (SparseArray) jVar.hOq.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        jVar.hOq.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    jVar.hOq.setVisibility(0);
                    jVar.hOr.setVisibility(8);
                    jVar.hOp.setVisibility(8);
                }
            } else {
                jVar.hOq.setVisibility(8);
                if (postData.cor() > 0 && postData.cok() != null && postData.cok().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) jVar.hOp.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    jVar.hOp.setLayoutParams(layoutParams);
                    if (this.hNZ == null) {
                        this.hNZ = new com.baidu.tieba.pb.pb.sub.c(this.mContext);
                        this.hNZ.setIsFromCDN(this.mIsFromCDN);
                        this.hNZ.setOnLongClickListener(this.mOnLongClickListener);
                        this.hNZ.R(this.hNH);
                        this.hNZ.w(this.ZF);
                        String str = null;
                        if (this.hNw != null && this.hNw.bQx() != null && this.hNw.bQx().aiE() != null) {
                            str = this.hNw.bQx().aiE().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.hNw != null) {
                            this.hNZ.N(this.hNw.bQJ(), z);
                            this.hNZ.ai(this.hNw.bQx());
                        }
                    }
                    this.hNZ.Bi(postData.getId());
                    jVar.hOp.setSubPbAdapter(this.hNZ);
                    jVar.hOp.setVisibility(0);
                    jVar.hOp.setData(postData, view);
                    jVar.hOp.setChildOnClickListener(this.ZF);
                    jVar.hOp.setChildOnLongClickListener(this.mOnLongClickListener);
                    jVar.hOp.setChildOnTouchListener(this.hOa);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.hOp.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    jVar.hOp.setLayoutParams(layoutParams2);
                    jVar.hOp.setVisibility(8);
                }
            }
            if (postData.jih) {
                jVar.mBottomLine.setVisibility(0);
            } else {
                jVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(j jVar, PostData postData) {
        if (jVar != null && jVar.hOB != null && jVar.hOy != null) {
            if (postData == null || postData.jik == null || StringUtils.isNull(postData.jik.liveTitle)) {
                jVar.hOy.setVisibility(8);
                return;
            }
            jVar.hOB.setText(postData.jik.liveTitle);
            jVar.hOy.setTag(postData.jik);
            jVar.hOy.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hOG.setVisibility(postData.jiq ? 0 : 8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.ezp, R.color.cp_cont_b, 1);
                if (jVar.hOg.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOg, ((Integer) jVar.hOg.getTag()).intValue());
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOh, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOi, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOj, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOs, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOk, R.color.cp_cont_d, 1);
                jVar.hOn.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(jVar.hOp, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOq, (int) R.color.cp_cont_c);
                jVar.hOq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOr, (int) R.color.cp_cont_c);
                jVar.hOp.onChangeSkinType();
                jVar.hOo.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOB, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOz, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOy, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(jVar.hOA, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(jVar.hOC, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(jVar.hOF, (int) R.color.cp_cont_c);
                if (jVar.hOD.getVisibility() == 8) {
                    jVar.hOF.setText(R.string.close_content);
                } else if (this.hNw != null && StringUtils.isNull(this.hNw.bQF())) {
                    jVar.hOF.setText(this.hNw.bQF());
                } else {
                    jVar.hOF.setText(R.string.expand_content);
                }
            }
            jVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(j jVar) {
        jVar.hOe.setOnTouchListener(this.hOa);
        jVar.hOe.setOnLongClickListener(this.mOnLongClickListener);
        if (this.hNh.getPageContext() != null && this.hNh.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = ((PbActivity) this.hNh.getPageContext().getOrignalPage()).hLg;
            jVar.ezp.setOnClickListener(aVar.fXf);
            jVar.hOm.setOnClickListener(aVar.fXf);
            jVar.hOu.setOnClickListener(aVar.fXf);
            jVar.hOu.getHeadView().setOnClickListener(aVar.fXf);
            jVar.hOn.setOnLongClickListener(this.mOnLongClickListener);
            jVar.hOn.setOnTouchListener(this.hOa);
            jVar.hOn.setCommonTextViewOnClickListener(this.ZF);
            jVar.hOn.setOnImageClickListener(this.cTN);
            jVar.hOn.setOnImageTouchListener(this.hOa);
            jVar.hOn.setOnEmotionClickListener(aVar.hYE);
            jVar.hOn.setOnVoiceAfterClickListener(this.ZF);
            jVar.hOx.setOnClickListener(this.ZF);
            jVar.hOy.setOnClickListener(this.ZF);
            jVar.hOq.setOnClickListener(this.ZF);
            jVar.hOr.setOnClickListener(this.ZF);
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.hNY = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.d dVar) {
        this.hNw = dVar;
    }

    public void cD(String str) {
        this.aeO = str;
    }

    public void nT(boolean z) {
        this.hNy = z;
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.hNh.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(j jVar) {
        jVar.hOn.setTextViewOnTouchListener(this.cyE);
        jVar.hOn.setTextViewCheckSelection(false);
    }

    public void O(View.OnClickListener onClickListener) {
        this.hNH = onClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cTN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cyE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
