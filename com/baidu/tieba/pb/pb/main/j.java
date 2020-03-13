package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
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
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class j extends l<PostData, k> implements View.OnClickListener {
    private LayerDrawable Nu;
    private LayerDrawable Nv;
    private int Yv;
    private View.OnClickListener aku;
    private int aqJ;
    private int aqK;
    private String aqW;
    private TbRichTextView.i dMK;
    private boolean dPs;
    private com.baidu.tieba.pb.a.c dqX;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gty;
    private com.baidu.adp.lib.d.b<TbImageView> gtz;
    private int iDA;
    private LayerDrawable iDB;
    protected com.baidu.tieba.pb.data.e iEU;
    private boolean iEV;
    private int iFJ;
    private TbRichTextView.c iFK;
    private com.baidu.tieba.pb.pb.sub.b iFL;
    private com.baidu.tieba.pb.a.c iFM;
    private View.OnClickListener iFe;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(View view) {
        if (view != null && (view.getTag() instanceof k)) {
            k kVar = (k) view.getTag();
            if (kVar.iFW != null && kVar.iFW.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNC = 5;
                dVar.cNE = 2;
                kVar.iFW.setStatisticData(dVar);
                kVar.iFW.aHt();
            }
        }
    }

    public j(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aqK = 0;
        this.iFJ = 0;
        this.iDA = 0;
        this.aqJ = 0;
        this.iFK = null;
        this.iEV = true;
        this.aqW = null;
        this.iEU = null;
        this.iFe = null;
        this.aku = null;
        this.dMK = null;
        this.dqX = null;
        this.mOnLongClickListener = null;
        this.iFL = null;
        this.dPs = true;
        this.gty = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGd */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(j.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.gtz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIh */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(j.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.iFM = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.iEk == null || j.this.iEk.cmu() == null || j.this.iEk.cmu().cpm())) {
                    if (view instanceof RelativeLayout) {
                        j.this.cs(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                j.this.cs((RelativeLayout) parent);
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
                if (j.this.dqX != null) {
                    if (!(view instanceof TbListTextView) || j.this.aku == null) {
                        j.this.dqX.Q(view);
                        j.this.dqX.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.aku.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.clC() != null) {
            this.Yv = bVar.clC().coi();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.iGs.cnj().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.Yv);
        kVar.iFZ.setConstrainLayoutPool(this.gty);
        kVar.iFZ.setImageViewPool(this.gtz);
        a(kVar);
        this.aqK = getDimensionPixelSize(R.dimen.tbds10);
        this.iFJ = getDimensionPixelSize(R.dimen.tbds14);
        this.iDA = getDimensionPixelSize(R.dimen.tbds40);
        this.aqJ = getDimensionPixelSize(R.dimen.tbds6);
        if (kVar.iFY != null) {
            kVar.iFY.setDuiEnabled(this.dPs);
        }
        nw();
        return kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) kVar);
        a(kVar);
        b(kVar);
        c(kVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            h(postData2);
            i(postData2);
            postData2.aDw();
            g(postData2);
            a(kVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.dPs = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.khC) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.iEU, postData, postData.locate, i, 6);
            postData.khD = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.cKY())) {
                Iterator<PostData> it = postData.cKY().iterator();
                while (it.hasNext()) {
                    it.next().khD = b;
                }
            }
        }
    }

    private void a(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            b(kVar, postData, view, i);
            f(kVar, postData);
            a(kVar, postData, view);
            c(kVar, postData, view, i);
            g(kVar, postData);
            a(kVar, postData);
            h(kVar, postData);
            c(kVar, postData);
            e(kVar, postData);
            i(kVar, postData);
            b(kVar, postData);
        }
    }

    private void b(k kVar, PostData postData) {
        if (kVar != null && kVar.iFQ != null) {
            if (this.iGs != null && this.iGs.clC() != null && this.iGs.clC().coq() && com.baidu.tbadk.core.util.aq.equals(this.iGs.clC().cny(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFQ, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFQ, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, boolean z, String str) {
        if (z) {
            kVar.iGo.setVisibility(8);
            if (StringUtils.isNull(str)) {
                kVar.iGq.setText(R.string.expand_content);
                return;
            } else {
                kVar.iGq.setText(str);
                return;
            }
        }
        kVar.iGo.setVisibility(0);
        kVar.iGq.setText(R.string.close_content);
    }

    private void c(final k kVar, final PostData postData) {
        if (postData.cLn() == 2 || postData.cLn() == 4) {
            kVar.iGp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = kVar.iGo.getVisibility() == 8;
                    j.this.a(kVar, !z, postData.ckD());
                    postData.sL(z ? false : true);
                    j.this.d(kVar, postData);
                    if (j.this.iEk != null && j.this.iEk.cmu() != null && j.this.iEk.cmu().cqo() != null && j.this.iEk.cmu().getListView() != null && !z && kVar.getView().getTop() < j.this.iEk.cmu().cqo().getMeasuredHeight()) {
                        j.this.iEk.cmu().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(j.this.iEk.cmu().getListView().getData(), postData) + j.this.iEk.cmu().getListView().getHeaderViewsCount(), j.this.iEk.cmu().cqo().getMeasuredHeight());
                    }
                }
            });
            kVar.iGp.setVisibility(0);
            a(kVar, postData.cKW(), postData.ckD());
            a(true, kVar, postData);
        } else {
            kVar.iGp.setVisibility(8);
            kVar.iGo.setVisibility(0);
            a(false, kVar, postData);
        }
        d(kVar, postData);
    }

    private void a(boolean z, k kVar, PostData postData) {
        if (kVar != null && kVar.mBottomLine != null && kVar.iGp != null && (kVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (kVar.iGp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cKY());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) kVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) kVar.iGp.getLayoutParams();
            if (z) {
                kVar.iFY.getLayoutStrategy().nq(0);
                if (z2) {
                    kVar.iFY.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    kVar.iFY.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                kVar.iGp.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    kVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            kVar.iFY.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            kVar.iFY.getLayoutStrategy().nq(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                kVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, PostData postData) {
        TbRichText cLd = postData.cLd();
        cLd.isChanged = true;
        kVar.iFY.setText(cLd, true, this.iFK);
    }

    private void h(PostData postData) {
        if (postData.cSL == 0 && postData.gvR) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cy("post_id", postData.getId());
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cy("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cy("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.iGs != null) {
                int coi = this.iGs.clC().coi();
                if (1 == coi || 2 == coi) {
                    anVar.cy("obj_source", "1");
                } else if (3 == coi) {
                    anVar.cy("obj_source", "2");
                } else {
                    anVar.cy("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.iEU != null) {
            if (this.iEU.aHL()) {
                if (this.iGt != null) {
                    com.baidu.tieba.pb.c.a.a(this.iGt.getUniqueId(), this.iEU, postData, postData.locate, postData.khC ? 2 : 8);
                }
            } else if (this.iEk != null) {
                com.baidu.tieba.pb.c.a.a(this.iEk.getUniqueId(), this.iEU, postData, postData.locate, postData.khC ? 2 : 8);
            }
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.csa() == null) {
            kVar.iGi.setVisibility(8);
            return;
        }
        TbRichText cLd = postData.cLd();
        com.baidu.tieba.pb.view.b.a(postData.csa(), kVar.iGi, false, false, cLd != null && StringUtils.isNull(cLd.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEV) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFY.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iFY.setLayoutParams(layoutParams);
            kVar.iFY.setPadding(0, 0, 0, 0);
            kVar.iFY.wi(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFY.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iFY.setLayoutParams(layoutParams2);
            kVar.iFY.wi(postData.getBimg_url());
        }
        kVar.iFY.setTextViewOnTouchListener(this.iFM);
        kVar.iFY.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x08ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(k kVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (kVar != null && postData != null) {
            if (postData.aCo() == null || postData.aCo().isBaijiahaoUser()) {
            }
            if (postData.khs) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            kVar.iFX.setTag(null);
            kVar.iFX.setUserId(null);
            kVar.fwO.setText((CharSequence) null);
            kVar.iGf.getHeadView().setUserId(null);
            kVar.iFY.setIsHost(false);
            if (postData.aCo() != null) {
                if (this.aqW != null && !this.aqW.equals("0") && this.aqW.equals(postData.aCo().getUserId())) {
                    kVar.iFY.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCo().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCo().getTShowInfoNew();
                if (kVar.iGh != null) {
                    kVar.iGh.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                    if (this.iGs != null && this.iGs.cnj() != null) {
                        kVar.iGh.setOnClickListener(this.iGs.cnj().iEw.iSQ);
                    }
                    kVar.iGh.a(iconInfo, 2, this.iDA, this.iDA, this.aqK);
                }
                if (kVar.iGg != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iGg.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.iGs != null && this.iGs.cnj() != null) {
                        kVar.iGg.setOnClickListener(this.iGs.cnj().iEw.iSR);
                    }
                    kVar.iGg.a(tShowInfoNew, 3, this.iDA, this.iDA, this.aqK, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aCo().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwO, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwO, R.color.cp_cont_b, 1);
                }
                String avater = postData.aCo().getAvater();
                int i2 = 8;
                if (postData.khC) {
                    i2 = 2;
                }
                kVar.fwO.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                kVar.fwO.setTag(R.id.tag_user_name, postData.aCo().getUserName());
                kVar.fwO.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                kVar.fwO.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEU, postData, postData.locate, i2, 2));
                String name_show = postData.aCo().getName_show();
                String userName = postData.aCo().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fwO.setText(com.baidu.tieba.pb.c.ba(this.mContext, kVar.fwO.getText().toString()));
                    kVar.fwO.setGravity(16);
                    kVar.fwO.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cke());
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwO, R.color.cp_other_f, 1);
                }
                if (postData.aCo().getPendantData() != null && !StringUtils.isNull(postData.aCo().getPendantData().aAG())) {
                    kVar.iGf.b(postData.aCo());
                    kVar.iFX.setVisibility(8);
                    kVar.iGf.setVisibility(0);
                    kVar.iGf.getHeadView().startLoad(avater, 28, false);
                    kVar.iGf.getHeadView().setUserId(postData.aCo().getUserId());
                    kVar.iGf.getHeadView().setUserName(postData.aCo().getUserName());
                    kVar.iGf.getHeadView().setFid(this.iEU != null ? this.iEU.getForumId() : "");
                    kVar.iGf.getHeadView().setTid(postData.getId());
                    kVar.iGf.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEU, postData, postData.locate, i2, 2));
                    kVar.iGf.tT(postData.aCo().getPendantData().aAG());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iFX, postData.aCo(), 0);
                    kVar.iFX.setUserId(postData.aCo().getUserId());
                    kVar.iFX.setFid(this.iEU != null ? this.iEU.getForumId() : "");
                    kVar.iFX.setTid(postData.getId());
                    kVar.iFX.setUserName(postData.aCo().getUserName(), postData.cLl());
                    kVar.iFX.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                    kVar.iFX.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEU, postData, postData.locate, i2, 2));
                    kVar.iFX.setImageDrawable(null);
                    kVar.iFX.startLoad(avater, 28, false);
                    kVar.iFX.setVisibility(0);
                    kVar.iGf.setVisibility(8);
                }
                if (this.iEU != null && this.iEU.ckT()) {
                    kVar.iFR.setVisibility(8);
                    kVar.iFR.setTag(null);
                } else if (postData.aCo() != null) {
                    MetaData aCo = postData.aCo();
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFR, (int) R.color.cp_cont_a);
                    if (this.aqW != null && !this.aqW.equals("0") && this.aqW.equals(aCo.getUserId())) {
                        kVar.iFR.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (this.iDB.getDrawable(1) != null) {
                                this.iDB.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.iDB.getDrawable(1) != null) {
                            this.iDB.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(this.iDB);
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.host_name);
                    } else if (aCo.getIs_bawu() == 1 && postData.cKT()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFR, R.drawable.brand_official_btn);
                        kVar.iFR.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.brand_Official);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                        kVar.iFR.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nu.getDrawable(1) != null) {
                                this.Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nu.getDrawable(1) != null) {
                            this.Nu.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(this.Nu);
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                        kVar.iFR.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(this.Nv);
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aCo.getIs_bawu() == 1 && "pri_content_assist".equals(aCo.getBawu_type())) {
                        int ku = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFR, ku);
                        kVar.iFR.setTag(Integer.valueOf(ku));
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_content_assist_tip);
                    } else if (aCo.getIs_bawu() == 1 && "pri_manage_assist".equals(aCo.getBawu_type())) {
                        int ku2 = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFR, ku2);
                        kVar.iFR.setTag(Integer.valueOf(ku2));
                        kVar.iFR.setVisibility(0);
                        kVar.iFR.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iFR.setVisibility(8);
                        kVar.iFR.setTag(null);
                    }
                } else {
                    kVar.iFR.setVisibility(8);
                    kVar.iFR.setTag(null);
                }
            }
            int i3 = 0;
            if (this.iGs != null && this.iGs.cnj() != null && this.iGs.cnj().cls() && postData.aCo() != null) {
                i3 = postData.aCo().getLevel_id();
            }
            if (this.iEU != null && this.iEU.ckT()) {
                i3 = 0;
            }
            if (i3 > 0) {
                kVar.iGe.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iGe, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                kVar.iGe.setVisibility(8);
            }
            int i4 = 15;
            if (kVar.iGh.getChildCount() == 1) {
                i4 = 13;
            } else if (kVar.iGh.getChildCount() > 1) {
                i4 = 11;
            }
            if (kVar.iFR.getVisibility() == 0) {
                i4 -= 2;
            }
            if (kVar.iGg.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aDI() > 1000) {
                i4 -= 2;
            }
            if (postData.aDI() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                kVar.iGh.setVisibility(8);
                if (kVar.iGh.getChildCount() == 1) {
                    i4 += 2;
                } else if (kVar.iGh.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && kVar.iFR.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iFR.setVisibility(8);
                }
                if (i4 < 10 && kVar.iGe.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iGe.setVisibility(8);
                }
            }
            String name_show2 = postData.aCo() != null ? postData.aCo().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.aCo() != null && !StringUtils.isNull(postData.aCo().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aCo() != null && !StringUtils.isNull(postData.aCo().getSealPrefix())) {
                kVar.fwO.setText(cB(postData.aCo().getSealPrefix(), name_show2));
            } else {
                kVar.fwO.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLb()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aCo() != null && !StringUtils.isNull(postData.aCo().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.iEU != null && this.iEU.ckH() != 0) {
                if (this.iEU.ckH() != 1002 && this.iEU.ckH() != 3) {
                    z10 = true;
                }
                if (this.iEU.ckH() != 3 && !this.iEU.ckT()) {
                    z11 = true;
                }
                if (postData != null && postData.aCo() != null) {
                    String userId2 = postData.aCo().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.iEU != null && this.iEU.ckv() != null && this.iEU.ckv().aCo() != null && postData.aCo() != null) {
                            userId = this.iEU.ckv().aCo().getUserId();
                            String userId3 = postData.aCo().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aCo() != null && UtilHelper.isCurrentAccount(postData.aCo().getUserId())) {
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
                                if (postData.cLb() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEU.ckH()));
                                    if (postData.aCo() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aCo() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCo().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCo().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCo().getName_show());
                                    }
                                    if (this.iEU.ckv() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.iEU.ckv().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEU.ckH()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iFY.setTag(sparseArray);
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
                        if (postData.cLb() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        kVar.iFY.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.iEU != null) {
                userId = this.iEU.ckv().aCo().getUserId();
                String userId32 = postData.aCo().getUserId();
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
            if (postData.cLb() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            kVar.iFY.setTag(sparseArray);
        }
    }

    private void f(k kVar, PostData postData) {
        if (kVar != null && postData != null && postData.aEa() != null) {
            postData.aEa().threadId = this.iGs.clC().cnz();
            postData.aEa().objType = 1;
            postData.aEa().isInPost = true;
            bj bjVar = null;
            if (this.iEU != null && this.iEU.ckv() != null) {
                bjVar = this.iEU.ckv();
            }
            if (bjVar != null && bjVar.aEi()) {
                kVar.iFW.setAgreeAlone(true);
            }
            kVar.iFW.setData(postData.aEa());
        }
    }

    private void g(k kVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cLb() > 0 && this.iEU != null && !this.iEU.ckT()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cLb()));
                kVar.iGd.setVisibility(0);
                kVar.iGd.setText(format);
                z = true;
            } else {
                kVar.iGd.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cLe = postData.cLe();
            boolean z2 = (cLe == null || StringUtils.isNull(cLe.getName()) || this.iEU == null || this.iEU.ckT()) ? false : true;
            if (z) {
                kVar.iFT.setVisibility(0);
                i = this.iFJ;
            } else {
                kVar.iFT.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iFU.setVisibility(0);
                i2 = this.iFJ;
            } else {
                kVar.iFU.setVisibility(8);
                i2 = 0;
            }
            kVar.iFS.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iFS.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iFS.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iFV.setVisibility(0);
                kVar.iFV.setPadding(this.iFJ, 0, 0, 0);
                if (postData.khA) {
                    kVar.iFV.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cLe.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    kVar.iFV.setText(cLe.getName());
                    return;
                }
            }
            kVar.iFV.setVisibility(8);
        }
    }

    private void a(k kVar, PostData postData, View view) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFY.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.iFY.setPadding(0, 0, 0, 0);
            if (!this.iEV) {
                kVar.iFY.getLayoutStrategy().nk(R.drawable.icon_click);
            } else {
                kVar.iFY.wi(null);
                kVar.iFY.setBackgroundDrawable(null);
                kVar.iFY.getLayoutStrategy().nk(R.drawable.transparent_bg);
            }
            kVar.iFY.getLayoutStrategy().nh(R.drawable.pic_video);
            a(kVar.iFY, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.iFY.setLayoutParams(layoutParams);
            kVar.iFY.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            kVar.iFY.setIsFromCDN(this.mIsFromCDN);
            TbRichText cLd = postData.cLd();
            kVar.iFY.setIsUseGridImage(postData.cLo());
            kVar.iFY.setText(cLd, true, this.iFK);
            SparseArray sparseArray = (SparseArray) kVar.iFY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            kVar.iFY.setTag(sparseArray);
            kVar.iFQ.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().ni(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().dOm = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nj((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.cLf() > 0) {
                kVar.iGc.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) kVar.iGc.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    kVar.iGc.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cLn() == 2) {
                    kVar.iGc.setVisibility(8);
                } else {
                    kVar.iGc.setVisibility(0);
                }
                kVar.iGb.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cLf() > 0) {
                    kVar.iGb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cLf())));
                    SparseArray sparseArray2 = (SparseArray) kVar.iGb.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        kVar.iGb.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    kVar.iGb.setVisibility(0);
                    kVar.iGc.setVisibility(8);
                    kVar.iGa.setVisibility(8);
                }
            } else {
                kVar.iGb.setVisibility(8);
                if (postData.cLf() > 0 && postData.cKY() != null && postData.cKY().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iGa.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    kVar.iGa.setLayoutParams(layoutParams);
                    if (this.iFL == null) {
                        this.iFL = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.iFL.setIsFromCDN(this.mIsFromCDN);
                        this.iFL.setOnLongClickListener(this.mOnLongClickListener);
                        this.iFL.S(this.iFe);
                        this.iFL.y(this.aku);
                        String str = null;
                        if (this.iEU != null && this.iEU.ckv() != null && this.iEU.ckv().aCo() != null) {
                            str = this.iEU.ckv().aCo().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.iEU != null) {
                            this.iFL.O(this.iEU.ckH(), z);
                            this.iFL.setThreadData(this.iEU.ckv());
                        }
                    }
                    this.iFL.Gs(postData.getId());
                    kVar.iGa.setSubPbAdapter(this.iFL);
                    kVar.iGa.setVisibility(0);
                    kVar.iGa.setData(postData, view);
                    kVar.iGa.setChildOnClickListener(this.aku);
                    kVar.iGa.setChildOnLongClickListener(this.mOnLongClickListener);
                    kVar.iGa.setChildOnTouchListener(this.iFM);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iGa.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    kVar.iGa.setLayoutParams(layoutParams2);
                    kVar.iGa.setVisibility(8);
                }
            }
            if (postData.khq) {
                kVar.mBottomLine.setVisibility(0);
            } else {
                kVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(k kVar, PostData postData) {
        if (kVar != null && kVar.iGm != null && kVar.iGj != null) {
            if (postData == null || postData.khu == null || StringUtils.isNull(postData.khu.liveTitle)) {
                kVar.iGj.setVisibility(8);
                return;
            }
            kVar.iGm.setText(postData.khu.liveTitle);
            kVar.iGj.setTag(postData.khu);
            kVar.iGj.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.iGr.setVisibility(postData.khA ? 0 : 8);
        }
    }

    private void a(k kVar) {
        LayerDrawable layerDrawable;
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwO, R.color.cp_cont_b, 1);
                if (kVar.iFR.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFR, ((Integer) kVar.iFR.getTag()).intValue());
                } else if (kVar.iFR.getTag() instanceof String) {
                    if (kVar.iFR.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.Nu;
                    } else if (kVar.iFR.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.Nv;
                    } else {
                        layerDrawable = kVar.iFR.getTag().equals("HOST") ? this.iDB : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFR.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFS, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFT, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFU, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGd, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFV, R.color.cp_cont_d, 1);
                kVar.iFY.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iGa, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGb, (int) R.color.cp_cont_c);
                kVar.iGb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGc, (int) R.color.cp_cont_c);
                kVar.iGa.onChangeSkinType();
                kVar.iFZ.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGm, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGk, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iGj, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iGl, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iGn, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGq, (int) R.color.cp_cont_c);
                if (kVar.iGo.getVisibility() == 8) {
                    kVar.iGq.setText(R.string.close_content);
                } else if (this.iEU != null && StringUtils.isNull(this.iEU.ckD())) {
                    kVar.iGq.setText(this.iEU.ckD());
                } else {
                    kVar.iGq.setText(R.string.expand_content);
                }
                kVar.iFW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.iFQ.setOnTouchListener(this.iFM);
        kVar.iFQ.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iGs.cnj() != null && this.iGs.cnj().getPageContext() != null && this.iGs.cnj().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.iGs.cnj().iEw;
            kVar.fwO.setOnClickListener(aVar.gRi);
            kVar.iFX.setOnClickListener(aVar.gRi);
            kVar.iGf.setOnClickListener(aVar.gRi);
            kVar.iGf.getHeadView().setOnClickListener(aVar.gRi);
            kVar.iFY.setOnLongClickListener(this.mOnLongClickListener);
            kVar.iFY.setOnTouchListener(this.iFM);
            kVar.iFY.setCommonTextViewOnClickListener(this.aku);
            kVar.iFY.setOnImageClickListener(this.dMK);
            kVar.iFY.setOnImageTouchListener(this.iFM);
            kVar.iFY.setOnEmotionClickListener(aVar.iSS);
            kVar.iFY.setOnVoiceAfterClickListener(this.aku);
            kVar.iGi.setOnClickListener(this.aku);
            kVar.iGj.setOnClickListener(this.aku);
            kVar.iGb.setOnClickListener(this.aku);
            kVar.iGc.setOnClickListener(this.aku);
        }
    }

    private void nw() {
        this.Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).tN("#4D000000").aHe()});
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).tN("#4D000000").aHe()});
        this.iDB = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHe(), com.baidu.tbadk.core.util.e.a.b.aHc().kB(0).af(this.aqJ).tN("#4D000000").aHe()});
    }

    public void a(TbRichTextView.c cVar) {
        this.iFK = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEU = eVar;
    }

    public void dI(String str) {
        this.aqW = str;
    }

    public void pw(boolean z) {
        this.iEV = z;
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iGs.cnj(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.iFY.setTextViewOnTouchListener(this.dqX);
        kVar.iFY.setTextViewCheckSelection(false);
    }

    public void P(View.OnClickListener onClickListener) {
        this.iFe = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMK = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqX = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
