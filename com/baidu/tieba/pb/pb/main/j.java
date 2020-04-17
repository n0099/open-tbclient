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
    private View.OnClickListener aDc;
    private int aJB;
    private String aJP;
    private LayerDrawable agg;
    private LayerDrawable agh;
    private int aqP;
    private com.baidu.tieba.pb.a.c dRh;
    private TbRichTextView.i emS;
    private boolean epD;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hdn;
    private com.baidu.adp.lib.d.b<TbImageView> hdo;
    private int jph;
    private int jpi;
    private LayerDrawable jpj;
    protected com.baidu.tieba.pb.data.e jqC;
    private boolean jqD;
    private View.OnClickListener jqM;
    private int jrr;
    private TbRichTextView.c jrs;
    private com.baidu.tieba.pb.pb.sub.b jrt;
    private com.baidu.tieba.pb.a.c jru;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        if (view != null && (view.getTag() instanceof k)) {
            k kVar = (k) view.getTag();
            if (kVar.jrE != null && kVar.jrE.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.dmT = 5;
                dVar.dmV = 2;
                kVar.jrE.setStatisticData(dVar);
                kVar.jrE.aPP();
            }
        }
    }

    public j(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aJB = 0;
        this.jrr = 0;
        this.jph = 0;
        this.jpi = 0;
        this.jrs = null;
        this.jqD = true;
        this.aJP = null;
        this.jqC = null;
        this.jqM = null;
        this.aDc = null;
        this.emS = null;
        this.dRh = null;
        this.mOnLongClickListener = null;
        this.jrt = null;
        this.epD = true;
        this.hdn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQQ */
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
        this.hdo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aQH */
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
        this.jru = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.jpS == null || j.this.jpS.cxv() == null || j.this.jpS.cxv().cAn())) {
                    if (view instanceof RelativeLayout) {
                        j.this.cA(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                j.this.cA((RelativeLayout) parent);
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
                if (j.this.dRh != null) {
                    if (!(view instanceof TbListTextView) || j.this.aDc == null) {
                        j.this.dRh.S(view);
                        j.this.dRh.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.aDc.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.cwD() != null) {
            this.aqP = bVar.cwD().czj();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.jsa.cyk().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aqP);
        kVar.jrH.setConstrainLayoutPool(this.hdn);
        kVar.jrH.setImageViewPool(this.hdo);
        a(kVar);
        this.aJB = getDimensionPixelSize(R.dimen.tbds10);
        this.jrr = getDimensionPixelSize(R.dimen.tbds14);
        this.jph = getDimensionPixelSize(R.dimen.tbds40);
        this.jpi = getDimensionPixelSize(R.dimen.tbds6);
        if (kVar.jrG != null) {
            kVar.jrG.setDuiEnabled(this.epD);
        }
        rP();
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
            postData2.aLN();
            g(postData2);
            a(kVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.epD = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.kTl) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.jqC, postData, postData.locate, i, 6);
            postData.kTm = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.cWo())) {
                Iterator<PostData> it = postData.cWo().iterator();
                while (it.hasNext()) {
                    it.next().kTm = b;
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
        if (kVar != null && kVar.jry != null) {
            if (this.jsa != null && this.jsa.cwD() != null && this.jsa.cwD().czr() && com.baidu.tbadk.core.util.aq.equals(this.jsa.cwD().cyz(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.jry, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.jry, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, boolean z, String str) {
        if (z) {
            kVar.jrW.setVisibility(8);
            if (StringUtils.isNull(str)) {
                kVar.jrY.setText(R.string.expand_content);
                return;
            } else {
                kVar.jrY.setText(str);
                return;
            }
        }
        kVar.jrW.setVisibility(0);
        kVar.jrY.setText(R.string.close_content);
    }

    private void c(final k kVar, final PostData postData) {
        if (postData.cWD() == 2 || postData.cWD() == 4) {
            kVar.jrX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = kVar.jrW.getVisibility() == 8;
                    j.this.a(kVar, !z, postData.cvC());
                    postData.tT(z ? false : true);
                    j.this.d(kVar, postData);
                    if (j.this.jpS != null && j.this.jpS.cxv() != null && j.this.jpS.cxv().cBp() != null && j.this.jpS.cxv().getListView() != null && !z && kVar.getView().getTop() < j.this.jpS.cxv().cBp().getMeasuredHeight()) {
                        j.this.jpS.cxv().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(j.this.jpS.cxv().getListView().getData(), postData) + j.this.jpS.cxv().getListView().getHeaderViewsCount(), j.this.jpS.cxv().cBp().getMeasuredHeight());
                    }
                }
            });
            kVar.jrX.setVisibility(0);
            a(kVar, postData.cWm(), postData.cvC());
            a(true, kVar, postData);
        } else {
            kVar.jrX.setVisibility(8);
            kVar.jrW.setVisibility(0);
            a(false, kVar, postData);
        }
        d(kVar, postData);
    }

    private void a(boolean z, k kVar, PostData postData) {
        if (kVar != null && kVar.mBottomLine != null && kVar.jrX != null && (kVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (kVar.jrX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cWo());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) kVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) kVar.jrX.getLayoutParams();
            if (z) {
                kVar.jrG.getLayoutStrategy().nE(0);
                if (z2) {
                    kVar.jrG.getLayoutStrategy().nD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    kVar.jrG.getLayoutStrategy().nD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                kVar.jrX.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    kVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            kVar.jrG.getLayoutStrategy().nD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            kVar.jrG.getLayoutStrategy().nE(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                kVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, PostData postData) {
        TbRichText cWt = postData.cWt();
        cWt.isChanged = true;
        kVar.jrG.setText(cWt, true, this.jrs);
    }

    private void h(PostData postData) {
        if (postData.dsh == 0 && postData.hfJ) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cI("post_id", postData.getId());
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cI("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cI("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.t(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.jsa != null) {
                int czj = this.jsa.cwD().czj();
                if (1 == czj || 2 == czj) {
                    anVar.cI("obj_source", "1");
                } else if (3 == czj) {
                    anVar.cI("obj_source", "2");
                } else {
                    anVar.cI("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.jqC != null) {
            if (this.jqC.aQh()) {
                if (this.jsb != null) {
                    com.baidu.tieba.pb.c.a.a(this.jsb.getUniqueId(), this.jqC, postData, postData.locate, postData.kTl ? 2 : 8);
                }
            } else if (this.jpS != null) {
                com.baidu.tieba.pb.c.a.a(this.jpS.getUniqueId(), this.jqC, postData, postData.locate, postData.kTl ? 2 : 8);
            }
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.cDb() == null) {
            kVar.jrQ.setVisibility(8);
            return;
        }
        TbRichText cWt = postData.cWt();
        com.baidu.tieba.pb.view.b.a(postData.cDb(), kVar.jrQ, false, false, cWt != null && StringUtils.isNull(cWt.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jqD) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrG.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.jrG.setLayoutParams(layoutParams);
            kVar.jrG.setPadding(0, 0, 0, 0);
            kVar.jrG.xv(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.jrG.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.jrG.setLayoutParams(layoutParams2);
            kVar.jrG.xv(postData.getBimg_url());
        }
        kVar.jrG.setTextViewOnTouchListener(this.jru);
        kVar.jrG.setTextViewCheckSelection(false);
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
            if (postData.aKE() == null || postData.aKE().isBaijiahaoUser()) {
            }
            if (postData.kTb) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            kVar.jrF.setTag(null);
            kVar.jrF.setUserId(null);
            kVar.gbU.setText((CharSequence) null);
            kVar.jrN.getHeadView().setUserId(null);
            kVar.jrG.setIsHost(false);
            if (postData.aKE() != null) {
                if (this.aJP != null && !this.aJP.equals("0") && this.aJP.equals(postData.aKE().getUserId())) {
                    kVar.jrG.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aKE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aKE().getTShowInfoNew();
                if (kVar.jrP != null) {
                    kVar.jrP.setTag(R.id.tag_user_id, postData.aKE().getUserId());
                    if (this.jsa != null && this.jsa.cyk() != null) {
                        kVar.jrP.setOnClickListener(this.jsa.cyk().jqe.jEA);
                    }
                    kVar.jrP.a(iconInfo, 2, this.jph, this.jph, this.aJB);
                }
                if (kVar.jrO != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.jrO.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.jsa != null && this.jsa.cyk() != null) {
                        kVar.jrO.setOnClickListener(this.jsa.cyk().jqe.jEB);
                    }
                    kVar.jrO.a(tShowInfoNew, 3, this.jph, this.jph, this.aJB, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aKE().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbU, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbU, R.color.cp_cont_b, 1);
                }
                String avater = postData.aKE().getAvater();
                int i2 = 8;
                if (postData.kTl) {
                    i2 = 2;
                }
                kVar.gbU.setTag(R.id.tag_user_id, postData.aKE().getUserId());
                kVar.gbU.setTag(R.id.tag_user_name, postData.aKE().getUserName());
                kVar.gbU.setTag(R.id.tag_virtual_user_url, postData.aKE().getVirtualUserUrl());
                kVar.gbU.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jqC, postData, postData.locate, i2, 2));
                String name_show = postData.aKE().getName_show();
                String userName = postData.aKE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.gbU.setText(com.baidu.tieba.pb.c.aV(this.mContext, kVar.gbU.getText().toString()));
                    kVar.gbU.setGravity(16);
                    kVar.gbU.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvd());
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbU, R.color.cp_other_f, 1);
                }
                if (postData.aKE().getPendantData() != null && !StringUtils.isNull(postData.aKE().getPendantData().aIW())) {
                    kVar.jrN.b(postData.aKE());
                    kVar.jrF.setVisibility(8);
                    kVar.jrN.setVisibility(0);
                    kVar.jrN.getHeadView().startLoad(avater, 28, false);
                    kVar.jrN.getHeadView().setUserId(postData.aKE().getUserId());
                    kVar.jrN.getHeadView().setUserName(postData.aKE().getUserName());
                    kVar.jrN.getHeadView().setFid(this.jqC != null ? this.jqC.getForumId() : "");
                    kVar.jrN.getHeadView().setTid(postData.getId());
                    kVar.jrN.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jqC, postData, postData.locate, i2, 2));
                    kVar.jrN.vg(postData.aKE().getPendantData().aIW());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.jrF, postData.aKE(), 0);
                    kVar.jrF.setUserId(postData.aKE().getUserId());
                    kVar.jrF.setFid(this.jqC != null ? this.jqC.getForumId() : "");
                    kVar.jrF.setTid(postData.getId());
                    kVar.jrF.setUserName(postData.aKE().getUserName(), postData.cWB());
                    kVar.jrF.setTag(R.id.tag_virtual_user_url, postData.aKE().getVirtualUserUrl());
                    kVar.jrF.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jqC, postData, postData.locate, i2, 2));
                    kVar.jrF.setImageDrawable(null);
                    kVar.jrF.startLoad(avater, 28, false);
                    kVar.jrF.setVisibility(0);
                    kVar.jrN.setVisibility(8);
                }
                if (this.jqC != null && this.jqC.cvS()) {
                    kVar.jrz.setVisibility(8);
                    kVar.jrz.setTag(null);
                } else if (postData.aKE() != null) {
                    MetaData aKE = postData.aKE();
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrz, (int) R.color.cp_cont_a);
                    if (this.aJP != null && !this.aJP.equals("0") && this.aJP.equals(aKE.getUserId())) {
                        kVar.jrz.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (this.jpj.getDrawable(1) != null) {
                                this.jpj.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.jpj.getDrawable(1) != null) {
                            this.jpj.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(this.jpj);
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.host_name);
                    } else if (aKE.getIs_bawu() == 1 && postData.cWj()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrz, R.drawable.brand_official_btn);
                        kVar.jrz.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.brand_Official);
                    } else if (aKE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aKE.getBawu_type())) {
                        kVar.jrz.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.agg.getDrawable(1) != null) {
                                this.agg.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agg.getDrawable(1) != null) {
                            this.agg.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(this.agg);
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aKE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aKE.getBawu_type())) {
                        kVar.jrz.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.agh.getDrawable(1) != null) {
                                this.agh.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agh.getDrawable(1) != null) {
                            this.agh.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(this.agh);
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aKE.getIs_bawu() == 1 && "pri_content_assist".equals(aKE.getBawu_type())) {
                        int kB = com.baidu.tbadk.core.util.am.kB(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrz, kB);
                        kVar.jrz.setTag(Integer.valueOf(kB));
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_content_assist_tip);
                    } else if (aKE.getIs_bawu() == 1 && "pri_manage_assist".equals(aKE.getBawu_type())) {
                        int kB2 = com.baidu.tbadk.core.util.am.kB(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrz, kB2);
                        kVar.jrz.setTag(Integer.valueOf(kB2));
                        kVar.jrz.setVisibility(0);
                        kVar.jrz.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.jrz.setVisibility(8);
                        kVar.jrz.setTag(null);
                    }
                } else {
                    kVar.jrz.setVisibility(8);
                    kVar.jrz.setTag(null);
                }
            }
            int i3 = 0;
            if (this.jsa != null && this.jsa.cyk() != null && this.jsa.cyk().cwt() && postData.aKE() != null) {
                i3 = postData.aKE().getLevel_id();
            }
            if (this.jqC != null && this.jqC.cvS()) {
                i3 = 0;
            }
            if (i3 > 0) {
                kVar.jrM.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.jrM, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                kVar.jrM.setVisibility(8);
            }
            int i4 = 15;
            if (kVar.jrP.getChildCount() == 1) {
                i4 = 13;
            } else if (kVar.jrP.getChildCount() > 1) {
                i4 = 11;
            }
            if (kVar.jrz.getVisibility() == 0) {
                i4 -= 2;
            }
            if (kVar.jrO.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aMa() > 1000) {
                i4 -= 2;
            }
            if (postData.aMa() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                kVar.jrP.setVisibility(8);
                if (kVar.jrP.getChildCount() == 1) {
                    i4 += 2;
                } else if (kVar.jrP.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && kVar.jrz.getVisibility() == 0) {
                    i4 += 2;
                    kVar.jrz.setVisibility(8);
                }
                if (i4 < 10 && kVar.jrM.getVisibility() == 0) {
                    i4 += 2;
                    kVar.jrM.setVisibility(8);
                }
            }
            String name_show2 = postData.aKE() != null ? postData.aKE().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.aKE() != null && !StringUtils.isNull(postData.aKE().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aKE() != null && !StringUtils.isNull(postData.aKE().getSealPrefix())) {
                kVar.gbU.setText(cL(postData.aKE().getSealPrefix(), name_show2));
            } else {
                kVar.gbU.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cWr()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aKE() != null && !StringUtils.isNull(postData.aKE().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.jqC != null && this.jqC.cvG() != 0) {
                if (this.jqC.cvG() != 1002 && this.jqC.cvG() != 3) {
                    z10 = true;
                }
                if (this.jqC.cvG() != 3 && !this.jqC.cvS()) {
                    z11 = true;
                }
                if (postData != null && postData.aKE() != null) {
                    String userId2 = postData.aKE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvu().aKE() != null && postData.aKE() != null) {
                            userId = this.jqC.cvu().aKE().getUserId();
                            String userId3 = postData.aKE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aKE() != null && UtilHelper.isCurrentAccount(postData.aKE().getUserId())) {
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
                                if (postData.cWr() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqC.cvG()));
                                    if (postData.aKE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aKE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aKE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKE().getName_show());
                                    }
                                    if (this.jqC.cvu() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.jqC.cvu().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqC.cvG()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.jrG.setTag(sparseArray);
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
                        if (postData.cWr() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        kVar.jrG.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.jqC != null) {
                userId = this.jqC.cvu().aKE().getUserId();
                String userId32 = postData.aKE().getUserId();
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
            if (postData.cWr() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            kVar.jrG.setTag(sparseArray);
        }
    }

    private void f(k kVar, PostData postData) {
        if (kVar != null && postData != null && postData.aMs() != null) {
            postData.aMs().threadId = this.jsa.cwD().cyA();
            postData.aMs().objType = 1;
            postData.aMs().isInPost = true;
            bj bjVar = null;
            if (this.jqC != null && this.jqC.cvu() != null) {
                bjVar = this.jqC.cvu();
            }
            if (bjVar != null && bjVar.aMA()) {
                kVar.jrE.setAgreeAlone(true);
            }
            kVar.jrE.setData(postData.aMs());
        }
    }

    private void g(k kVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cWr() > 0 && this.jqC != null && !this.jqC.cvS()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cWr()));
                kVar.jrL.setVisibility(0);
                kVar.jrL.setText(format);
                z = true;
            } else {
                kVar.jrL.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cWu = postData.cWu();
            boolean z2 = (cWu == null || StringUtils.isNull(cWu.getName()) || this.jqC == null || this.jqC.cvS()) ? false : true;
            if (z) {
                kVar.jrB.setVisibility(0);
                i = this.jrr;
            } else {
                kVar.jrB.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.jrC.setVisibility(0);
                i2 = this.jrr;
            } else {
                kVar.jrC.setVisibility(8);
                i2 = 0;
            }
            kVar.jrA.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                kVar.jrA.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.jrA.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.jrD.setVisibility(0);
                kVar.jrD.setPadding(this.jrr, 0, 0, 0);
                if (postData.kTj) {
                    kVar.jrD.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cWu.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    kVar.jrD.setText(cWu.getName());
                    return;
                }
            }
            kVar.jrD.setVisibility(8);
        }
    }

    private void a(k kVar, PostData postData, View view) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrG.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.jrG.setPadding(0, 0, 0, 0);
            if (!this.jqD) {
                kVar.jrG.getLayoutStrategy().ny(R.drawable.icon_click);
            } else {
                kVar.jrG.xv(null);
                kVar.jrG.setBackgroundDrawable(null);
                kVar.jrG.getLayoutStrategy().ny(R.drawable.transparent_bg);
            }
            kVar.jrG.getLayoutStrategy().nv(R.drawable.pic_video);
            a(kVar.jrG, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.jrG.setLayoutParams(layoutParams);
            kVar.jrG.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            kVar.jrG.setIsFromCDN(this.mIsFromCDN);
            TbRichText cWt = postData.cWt();
            kVar.jrG.setIsUseGridImage(postData.cWE());
            kVar.jrG.setText(cWt, true, this.jrs);
            SparseArray sparseArray = (SparseArray) kVar.jrG.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            kVar.jrG.setTag(sparseArray);
            kVar.jry.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().nw(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eox = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nx((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.cWv() > 0) {
                kVar.jrK.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) kVar.jrK.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    kVar.jrK.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cWD() == 2) {
                    kVar.jrK.setVisibility(8);
                } else {
                    kVar.jrK.setVisibility(0);
                }
                kVar.jrJ.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cWv() > 0) {
                    kVar.jrJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cWv())));
                    SparseArray sparseArray2 = (SparseArray) kVar.jrJ.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        kVar.jrJ.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    kVar.jrJ.setVisibility(0);
                    kVar.jrK.setVisibility(8);
                    kVar.jrI.setVisibility(8);
                }
            } else {
                kVar.jrJ.setVisibility(8);
                if (postData.cWv() > 0 && postData.cWo() != null && postData.cWo().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrI.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    kVar.jrI.setLayoutParams(layoutParams);
                    if (this.jrt == null) {
                        this.jrt = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.jrt.setIsFromCDN(this.mIsFromCDN);
                        this.jrt.setOnLongClickListener(this.mOnLongClickListener);
                        this.jrt.T(this.jqM);
                        this.jrt.z(this.aDc);
                        String str = null;
                        if (this.jqC != null && this.jqC.cvu() != null && this.jqC.cvu().aKE() != null) {
                            str = this.jqC.cvu().aKE().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.jqC != null) {
                            this.jrt.U(this.jqC.cvG(), z);
                            this.jrt.setThreadData(this.jqC.cvu());
                        }
                    }
                    this.jrt.HZ(postData.getId());
                    kVar.jrI.setSubPbAdapter(this.jrt);
                    kVar.jrI.setVisibility(0);
                    kVar.jrI.setData(postData, view);
                    kVar.jrI.setChildOnClickListener(this.aDc);
                    kVar.jrI.setChildOnLongClickListener(this.mOnLongClickListener);
                    kVar.jrI.setChildOnTouchListener(this.jru);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.jrI.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    kVar.jrI.setLayoutParams(layoutParams2);
                    kVar.jrI.setVisibility(8);
                }
            }
            if (postData.kSZ) {
                kVar.mBottomLine.setVisibility(0);
            } else {
                kVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(k kVar, PostData postData) {
        if (kVar != null && kVar.jrU != null && kVar.jrR != null) {
            if (postData == null || postData.kTd == null || StringUtils.isNull(postData.kTd.liveTitle)) {
                kVar.jrR.setVisibility(8);
                return;
            }
            kVar.jrU.setText(postData.kTd.liveTitle);
            kVar.jrR.setTag(postData.kTd);
            kVar.jrR.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.jrZ.setVisibility(postData.kTj ? 0 : 8);
        }
    }

    private void a(k kVar) {
        LayerDrawable layerDrawable;
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbU, R.color.cp_cont_b, 1);
                if (kVar.jrz.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrz, ((Integer) kVar.jrz.getTag()).intValue());
                } else if (kVar.jrz.getTag() instanceof String) {
                    if (kVar.jrz.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.agg;
                    } else if (kVar.jrz.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.agh;
                    } else {
                        layerDrawable = kVar.jrz.getTag().equals("HOST") ? this.jpj : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrz.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrA, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrB, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrC, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrL, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrD, R.color.cp_cont_d, 1);
                kVar.jrG.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.jrI, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrJ, (int) R.color.cp_cont_c);
                kVar.jrJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrK, (int) R.color.cp_cont_c);
                kVar.jrI.onChangeSkinType();
                kVar.jrH.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrU, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrS, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrR, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrT, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.jrV, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrY, (int) R.color.cp_cont_c);
                if (kVar.jrW.getVisibility() == 8) {
                    kVar.jrY.setText(R.string.close_content);
                } else if (this.jqC != null && StringUtils.isNull(this.jqC.cvC())) {
                    kVar.jrY.setText(this.jqC.cvC());
                } else {
                    kVar.jrY.setText(R.string.expand_content);
                }
                kVar.jrE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.jry.setOnTouchListener(this.jru);
        kVar.jry.setOnLongClickListener(this.mOnLongClickListener);
        if (this.jsa.cyk() != null && this.jsa.cyk().getPageContext() != null && this.jsa.cyk().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.jsa.cyk().jqe;
            kVar.gbU.setOnClickListener(aVar.gHS);
            kVar.jrF.setOnClickListener(aVar.gHS);
            kVar.jrN.setOnClickListener(aVar.gHS);
            kVar.jrN.getHeadView().setOnClickListener(aVar.gHS);
            kVar.jrG.setOnLongClickListener(this.mOnLongClickListener);
            kVar.jrG.setOnTouchListener(this.jru);
            kVar.jrG.setCommonTextViewOnClickListener(this.aDc);
            kVar.jrG.setOnImageClickListener(this.emS);
            kVar.jrG.setOnImageTouchListener(this.jru);
            kVar.jrG.setOnEmotionClickListener(aVar.jEC);
            kVar.jrG.setOnVoiceAfterClickListener(this.aDc);
            kVar.jrQ.setOnClickListener(this.aDc);
            kVar.jrR.setOnClickListener(this.aDc);
            kVar.jrJ.setOnClickListener(this.aDc);
            kVar.jrK.setOnClickListener(this.aDc);
        }
    }

    private void rP() {
        this.agg = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.jpi).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPA(), com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.jpi).va("#4D000000").aPA()});
        this.agh = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.jpi).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPA(), com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.jpi).va("#4D000000").aPA()});
        this.jpj = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.jpi).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aPA(), com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.jpi).va("#4D000000").aPA()});
    }

    public void a(TbRichTextView.c cVar) {
        this.jrs = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqC = eVar;
    }

    public void eA(String str) {
        this.aJP = str;
    }

    public void qG(boolean z) {
        this.jqD = z;
    }

    private SpannableStringBuilder cL(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.jsa.cyk(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.jrG.setTextViewOnTouchListener(this.dRh);
        kVar.jrG.setTextViewCheckSelection(false);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqM = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emS = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRh = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
