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
    private View.OnClickListener akt;
    private int aqI;
    private int aqJ;
    private String aqV;
    private TbRichTextView.i dMx;
    private boolean dPf;
    private com.baidu.tieba.pb.a.c dqK;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gtl;
    private com.baidu.adp.lib.d.b<TbImageView> gtm;
    private int iDo;
    private LayerDrawable iDp;
    protected com.baidu.tieba.pb.data.e iEI;
    private boolean iEJ;
    private View.OnClickListener iES;
    private com.baidu.tieba.pb.a.c iFA;
    private int iFx;
    private TbRichTextView.c iFy;
    private com.baidu.tieba.pb.pb.sub.b iFz;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(View view) {
        if (view != null && (view.getTag() instanceof k)) {
            k kVar = (k) view.getTag();
            if (kVar.iFK != null && kVar.iFK.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNB = 5;
                dVar.cND = 2;
                kVar.iFK.setStatisticData(dVar);
                kVar.iFK.aHs();
            }
        }
    }

    public j(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aqJ = 0;
        this.iFx = 0;
        this.iDo = 0;
        this.aqI = 0;
        this.iFy = null;
        this.iEJ = true;
        this.aqV = null;
        this.iEI = null;
        this.iES = null;
        this.akt = null;
        this.dMx = null;
        this.dqK = null;
        this.mOnLongClickListener = null;
        this.iFz = null;
        this.dPf = true;
        this.gtl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGc */
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
        this.gtm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIg */
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
        this.iFA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.iDY == null || j.this.iDY.cmt() == null || j.this.iDY.cmt().cpl())) {
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
                if (j.this.dqK != null) {
                    if (!(view instanceof TbListTextView) || j.this.akt == null) {
                        j.this.dqK.Q(view);
                        j.this.dqK.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.akt.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.clB() != null) {
            this.Yv = bVar.clB().coh();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.iGg.cni().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.Yv);
        kVar.iFN.setConstrainLayoutPool(this.gtl);
        kVar.iFN.setImageViewPool(this.gtm);
        a(kVar);
        this.aqJ = getDimensionPixelSize(R.dimen.tbds10);
        this.iFx = getDimensionPixelSize(R.dimen.tbds14);
        this.iDo = getDimensionPixelSize(R.dimen.tbds40);
        this.aqI = getDimensionPixelSize(R.dimen.tbds6);
        if (kVar.iFM != null) {
            kVar.iFM.setDuiEnabled(this.dPf);
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
        this.dPf = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.khq) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.iEI, postData, postData.locate, i, 6);
            postData.khr = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.cKX())) {
                Iterator<PostData> it = postData.cKX().iterator();
                while (it.hasNext()) {
                    it.next().khr = b;
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
        if (kVar != null && kVar.iFE != null) {
            if (this.iGg != null && this.iGg.clB() != null && this.iGg.clB().cop() && com.baidu.tbadk.core.util.aq.equals(this.iGg.clB().cnx(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFE, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFE, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, boolean z, String str) {
        if (z) {
            kVar.iGc.setVisibility(8);
            if (StringUtils.isNull(str)) {
                kVar.iGe.setText(R.string.expand_content);
                return;
            } else {
                kVar.iGe.setText(str);
                return;
            }
        }
        kVar.iGc.setVisibility(0);
        kVar.iGe.setText(R.string.close_content);
    }

    private void c(final k kVar, final PostData postData) {
        if (postData.cLm() == 2 || postData.cLm() == 4) {
            kVar.iGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = kVar.iGc.getVisibility() == 8;
                    j.this.a(kVar, !z, postData.ckC());
                    postData.sL(z ? false : true);
                    j.this.d(kVar, postData);
                    if (j.this.iDY != null && j.this.iDY.cmt() != null && j.this.iDY.cmt().cqn() != null && j.this.iDY.cmt().getListView() != null && !z && kVar.getView().getTop() < j.this.iDY.cmt().cqn().getMeasuredHeight()) {
                        j.this.iDY.cmt().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(j.this.iDY.cmt().getListView().getData(), postData) + j.this.iDY.cmt().getListView().getHeaderViewsCount(), j.this.iDY.cmt().cqn().getMeasuredHeight());
                    }
                }
            });
            kVar.iGd.setVisibility(0);
            a(kVar, postData.cKV(), postData.ckC());
            a(true, kVar, postData);
        } else {
            kVar.iGd.setVisibility(8);
            kVar.iGc.setVisibility(0);
            a(false, kVar, postData);
        }
        d(kVar, postData);
    }

    private void a(boolean z, k kVar, PostData postData) {
        if (kVar != null && kVar.mBottomLine != null && kVar.iGd != null && (kVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (kVar.iGd.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cKX());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) kVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) kVar.iGd.getLayoutParams();
            if (z) {
                kVar.iFM.getLayoutStrategy().nq(0);
                if (z2) {
                    kVar.iFM.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    kVar.iFM.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                kVar.iGd.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    kVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            kVar.iFM.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            kVar.iFM.getLayoutStrategy().nq(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                kVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, PostData postData) {
        TbRichText cLc = postData.cLc();
        cLc.isChanged = true;
        kVar.iFM.setText(cLc, true, this.iFy);
    }

    private void h(PostData postData) {
        if (postData.cSK == 0 && postData.gvF) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cy("post_id", postData.getId());
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cy("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cy("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.iGg != null) {
                int coh = this.iGg.clB().coh();
                if (1 == coh || 2 == coh) {
                    anVar.cy("obj_source", "1");
                } else if (3 == coh) {
                    anVar.cy("obj_source", "2");
                } else {
                    anVar.cy("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.iEI != null) {
            if (this.iEI.aHK()) {
                if (this.iGh != null) {
                    com.baidu.tieba.pb.c.a.a(this.iGh.getUniqueId(), this.iEI, postData, postData.locate, postData.khq ? 2 : 8);
                }
            } else if (this.iDY != null) {
                com.baidu.tieba.pb.c.a.a(this.iDY.getUniqueId(), this.iEI, postData, postData.locate, postData.khq ? 2 : 8);
            }
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.crZ() == null) {
            kVar.iFW.setVisibility(8);
            return;
        }
        TbRichText cLc = postData.cLc();
        com.baidu.tieba.pb.view.b.a(postData.crZ(), kVar.iFW, false, false, cLc != null && StringUtils.isNull(cLc.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEJ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iFM.setLayoutParams(layoutParams);
            kVar.iFM.setPadding(0, 0, 0, 0);
            kVar.iFM.wh(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iFM.setLayoutParams(layoutParams2);
            kVar.iFM.wh(postData.getBimg_url());
        }
        kVar.iFM.setTextViewOnTouchListener(this.iFA);
        kVar.iFM.setTextViewCheckSelection(false);
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
            if (postData.khg) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            kVar.iFL.setTag(null);
            kVar.iFL.setUserId(null);
            kVar.fwB.setText((CharSequence) null);
            kVar.iFT.getHeadView().setUserId(null);
            kVar.iFM.setIsHost(false);
            if (postData.aCo() != null) {
                if (this.aqV != null && !this.aqV.equals("0") && this.aqV.equals(postData.aCo().getUserId())) {
                    kVar.iFM.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCo().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCo().getTShowInfoNew();
                if (kVar.iFV != null) {
                    kVar.iFV.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                    if (this.iGg != null && this.iGg.cni() != null) {
                        kVar.iFV.setOnClickListener(this.iGg.cni().iEk.iSE);
                    }
                    kVar.iFV.a(iconInfo, 2, this.iDo, this.iDo, this.aqJ);
                }
                if (kVar.iFU != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iFU.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.iGg != null && this.iGg.cni() != null) {
                        kVar.iFU.setOnClickListener(this.iGg.cni().iEk.iSF);
                    }
                    kVar.iFU.a(tShowInfoNew, 3, this.iDo, this.iDo, this.aqJ, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aCo().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwB, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwB, R.color.cp_cont_b, 1);
                }
                String avater = postData.aCo().getAvater();
                int i2 = 8;
                if (postData.khq) {
                    i2 = 2;
                }
                kVar.fwB.setTag(R.id.tag_user_id, postData.aCo().getUserId());
                kVar.fwB.setTag(R.id.tag_user_name, postData.aCo().getUserName());
                kVar.fwB.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                kVar.fwB.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEI, postData, postData.locate, i2, 2));
                String name_show = postData.aCo().getName_show();
                String userName = postData.aCo().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fwB.setText(com.baidu.tieba.pb.c.ba(this.mContext, kVar.fwB.getText().toString()));
                    kVar.fwB.setGravity(16);
                    kVar.fwB.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.ckd());
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwB, R.color.cp_other_f, 1);
                }
                if (postData.aCo().getPendantData() != null && !StringUtils.isNull(postData.aCo().getPendantData().aAG())) {
                    kVar.iFT.b(postData.aCo());
                    kVar.iFL.setVisibility(8);
                    kVar.iFT.setVisibility(0);
                    kVar.iFT.getHeadView().startLoad(avater, 28, false);
                    kVar.iFT.getHeadView().setUserId(postData.aCo().getUserId());
                    kVar.iFT.getHeadView().setUserName(postData.aCo().getUserName());
                    kVar.iFT.getHeadView().setFid(this.iEI != null ? this.iEI.getForumId() : "");
                    kVar.iFT.getHeadView().setTid(postData.getId());
                    kVar.iFT.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEI, postData, postData.locate, i2, 2));
                    kVar.iFT.tS(postData.aCo().getPendantData().aAG());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iFL, postData.aCo(), 0);
                    kVar.iFL.setUserId(postData.aCo().getUserId());
                    kVar.iFL.setFid(this.iEI != null ? this.iEI.getForumId() : "");
                    kVar.iFL.setTid(postData.getId());
                    kVar.iFL.setUserName(postData.aCo().getUserName(), postData.cLk());
                    kVar.iFL.setTag(R.id.tag_virtual_user_url, postData.aCo().getVirtualUserUrl());
                    kVar.iFL.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEI, postData, postData.locate, i2, 2));
                    kVar.iFL.setImageDrawable(null);
                    kVar.iFL.startLoad(avater, 28, false);
                    kVar.iFL.setVisibility(0);
                    kVar.iFT.setVisibility(8);
                }
                if (this.iEI != null && this.iEI.ckS()) {
                    kVar.iFF.setVisibility(8);
                    kVar.iFF.setTag(null);
                } else if (postData.aCo() != null) {
                    MetaData aCo = postData.aCo();
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFF, (int) R.color.cp_cont_a);
                    if (this.aqV != null && !this.aqV.equals("0") && this.aqV.equals(aCo.getUserId())) {
                        kVar.iFF.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (this.iDp.getDrawable(1) != null) {
                                this.iDp.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.iDp.getDrawable(1) != null) {
                            this.iDp.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(this.iDp);
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.host_name);
                    } else if (aCo.getIs_bawu() == 1 && postData.cKS()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFF, R.drawable.brand_official_btn);
                        kVar.iFF.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.brand_Official);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                        kVar.iFF.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nu.getDrawable(1) != null) {
                                this.Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nu.getDrawable(1) != null) {
                            this.Nu.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(this.Nu);
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                        kVar.iFF.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(this.Nv);
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aCo.getIs_bawu() == 1 && "pri_content_assist".equals(aCo.getBawu_type())) {
                        int ku = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFF, ku);
                        kVar.iFF.setTag(Integer.valueOf(ku));
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_content_assist_tip);
                    } else if (aCo.getIs_bawu() == 1 && "pri_manage_assist".equals(aCo.getBawu_type())) {
                        int ku2 = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFF, ku2);
                        kVar.iFF.setTag(Integer.valueOf(ku2));
                        kVar.iFF.setVisibility(0);
                        kVar.iFF.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iFF.setVisibility(8);
                        kVar.iFF.setTag(null);
                    }
                } else {
                    kVar.iFF.setVisibility(8);
                    kVar.iFF.setTag(null);
                }
            }
            int i3 = 0;
            if (this.iGg != null && this.iGg.cni() != null && this.iGg.cni().clr() && postData.aCo() != null) {
                i3 = postData.aCo().getLevel_id();
            }
            if (this.iEI != null && this.iEI.ckS()) {
                i3 = 0;
            }
            if (i3 > 0) {
                kVar.iFS.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iFS, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                kVar.iFS.setVisibility(8);
            }
            int i4 = 15;
            if (kVar.iFV.getChildCount() == 1) {
                i4 = 13;
            } else if (kVar.iFV.getChildCount() > 1) {
                i4 = 11;
            }
            if (kVar.iFF.getVisibility() == 0) {
                i4 -= 2;
            }
            if (kVar.iFU.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aDI() > 1000) {
                i4 -= 2;
            }
            if (postData.aDI() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                kVar.iFV.setVisibility(8);
                if (kVar.iFV.getChildCount() == 1) {
                    i4 += 2;
                } else if (kVar.iFV.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && kVar.iFF.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iFF.setVisibility(8);
                }
                if (i4 < 10 && kVar.iFS.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iFS.setVisibility(8);
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
                kVar.fwB.setText(cB(postData.aCo().getSealPrefix(), name_show2));
            } else {
                kVar.fwB.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLa()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aCo() != null && !StringUtils.isNull(postData.aCo().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.iEI != null && this.iEI.ckG() != 0) {
                if (this.iEI.ckG() != 1002 && this.iEI.ckG() != 3) {
                    z10 = true;
                }
                if (this.iEI.ckG() != 3 && !this.iEI.ckS()) {
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
                        if (this.iEI != null && this.iEI.cku() != null && this.iEI.cku().aCo() != null && postData.aCo() != null) {
                            userId = this.iEI.cku().aCo().getUserId();
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
                                if (postData.cLa() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEI.ckG()));
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
                                    if (this.iEI.cku() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.iEI.cku().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEI.ckG()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iFM.setTag(sparseArray);
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
                        if (postData.cLa() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        kVar.iFM.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.iEI != null) {
                userId = this.iEI.cku().aCo().getUserId();
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
            if (postData.cLa() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            kVar.iFM.setTag(sparseArray);
        }
    }

    private void f(k kVar, PostData postData) {
        if (kVar != null && postData != null && postData.aEa() != null) {
            postData.aEa().threadId = this.iGg.clB().cny();
            postData.aEa().objType = 1;
            postData.aEa().isInPost = true;
            bj bjVar = null;
            if (this.iEI != null && this.iEI.cku() != null) {
                bjVar = this.iEI.cku();
            }
            if (bjVar != null && bjVar.aEi()) {
                kVar.iFK.setAgreeAlone(true);
            }
            kVar.iFK.setData(postData.aEa());
        }
    }

    private void g(k kVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cLa() > 0 && this.iEI != null && !this.iEI.ckS()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cLa()));
                kVar.iFR.setVisibility(0);
                kVar.iFR.setText(format);
                z = true;
            } else {
                kVar.iFR.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cLd = postData.cLd();
            boolean z2 = (cLd == null || StringUtils.isNull(cLd.getName()) || this.iEI == null || this.iEI.ckS()) ? false : true;
            if (z) {
                kVar.iFH.setVisibility(0);
                i = this.iFx;
            } else {
                kVar.iFH.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iFI.setVisibility(0);
                i2 = this.iFx;
            } else {
                kVar.iFI.setVisibility(8);
                i2 = 0;
            }
            kVar.iFG.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iFG.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iFG.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iFJ.setVisibility(0);
                kVar.iFJ.setPadding(this.iFx, 0, 0, 0);
                if (postData.kho) {
                    kVar.iFJ.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cLd.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    kVar.iFJ.setText(cLd.getName());
                    return;
                }
            }
            kVar.iFJ.setVisibility(8);
        }
    }

    private void a(k kVar, PostData postData, View view) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.iFM.setPadding(0, 0, 0, 0);
            if (!this.iEJ) {
                kVar.iFM.getLayoutStrategy().nk(R.drawable.icon_click);
            } else {
                kVar.iFM.wh(null);
                kVar.iFM.setBackgroundDrawable(null);
                kVar.iFM.getLayoutStrategy().nk(R.drawable.transparent_bg);
            }
            kVar.iFM.getLayoutStrategy().nh(R.drawable.pic_video);
            a(kVar.iFM, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.iFM.setLayoutParams(layoutParams);
            kVar.iFM.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            kVar.iFM.setIsFromCDN(this.mIsFromCDN);
            TbRichText cLc = postData.cLc();
            kVar.iFM.setIsUseGridImage(postData.cLn());
            kVar.iFM.setText(cLc, true, this.iFy);
            SparseArray sparseArray = (SparseArray) kVar.iFM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            kVar.iFM.setTag(sparseArray);
            kVar.iFE.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().dNZ = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nj((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.cLe() > 0) {
                kVar.iFQ.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) kVar.iFQ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    kVar.iFQ.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cLm() == 2) {
                    kVar.iFQ.setVisibility(8);
                } else {
                    kVar.iFQ.setVisibility(0);
                }
                kVar.iFP.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cLe() > 0) {
                    kVar.iFP.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cLe())));
                    SparseArray sparseArray2 = (SparseArray) kVar.iFP.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        kVar.iFP.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    kVar.iFP.setVisibility(0);
                    kVar.iFQ.setVisibility(8);
                    kVar.iFO.setVisibility(8);
                }
            } else {
                kVar.iFP.setVisibility(8);
                if (postData.cLe() > 0 && postData.cKX() != null && postData.cKX().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFO.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    kVar.iFO.setLayoutParams(layoutParams);
                    if (this.iFz == null) {
                        this.iFz = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.iFz.setIsFromCDN(this.mIsFromCDN);
                        this.iFz.setOnLongClickListener(this.mOnLongClickListener);
                        this.iFz.S(this.iES);
                        this.iFz.y(this.akt);
                        String str = null;
                        if (this.iEI != null && this.iEI.cku() != null && this.iEI.cku().aCo() != null) {
                            str = this.iEI.cku().aCo().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.iEI != null) {
                            this.iFz.O(this.iEI.ckG(), z);
                            this.iFz.setThreadData(this.iEI.cku());
                        }
                    }
                    this.iFz.Gr(postData.getId());
                    kVar.iFO.setSubPbAdapter(this.iFz);
                    kVar.iFO.setVisibility(0);
                    kVar.iFO.setData(postData, view);
                    kVar.iFO.setChildOnClickListener(this.akt);
                    kVar.iFO.setChildOnLongClickListener(this.mOnLongClickListener);
                    kVar.iFO.setChildOnTouchListener(this.iFA);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFO.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    kVar.iFO.setLayoutParams(layoutParams2);
                    kVar.iFO.setVisibility(8);
                }
            }
            if (postData.khe) {
                kVar.mBottomLine.setVisibility(0);
            } else {
                kVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(k kVar, PostData postData) {
        if (kVar != null && kVar.iGa != null && kVar.iFX != null) {
            if (postData == null || postData.khi == null || StringUtils.isNull(postData.khi.liveTitle)) {
                kVar.iFX.setVisibility(8);
                return;
            }
            kVar.iGa.setText(postData.khi.liveTitle);
            kVar.iFX.setTag(postData.khi);
            kVar.iFX.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.iGf.setVisibility(postData.kho ? 0 : 8);
        }
    }

    private void a(k kVar) {
        LayerDrawable layerDrawable;
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwB, R.color.cp_cont_b, 1);
                if (kVar.iFF.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFF, ((Integer) kVar.iFF.getTag()).intValue());
                } else if (kVar.iFF.getTag() instanceof String) {
                    if (kVar.iFF.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.Nu;
                    } else if (kVar.iFF.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.Nv;
                    } else {
                        layerDrawable = kVar.iFF.getTag().equals("HOST") ? this.iDp : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFF.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFG, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFH, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFI, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFR, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFJ, R.color.cp_cont_d, 1);
                kVar.iFM.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFO, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFP, (int) R.color.cp_cont_c);
                kVar.iFP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFQ, (int) R.color.cp_cont_c);
                kVar.iFO.onChangeSkinType();
                kVar.iFN.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGa, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFY, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFX, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFZ, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iGb, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGe, (int) R.color.cp_cont_c);
                if (kVar.iGc.getVisibility() == 8) {
                    kVar.iGe.setText(R.string.close_content);
                } else if (this.iEI != null && StringUtils.isNull(this.iEI.ckC())) {
                    kVar.iGe.setText(this.iEI.ckC());
                } else {
                    kVar.iGe.setText(R.string.expand_content);
                }
                kVar.iFK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.iFE.setOnTouchListener(this.iFA);
        kVar.iFE.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iGg.cni() != null && this.iGg.cni().getPageContext() != null && this.iGg.cni().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.iGg.cni().iEk;
            kVar.fwB.setOnClickListener(aVar.gQW);
            kVar.iFL.setOnClickListener(aVar.gQW);
            kVar.iFT.setOnClickListener(aVar.gQW);
            kVar.iFT.getHeadView().setOnClickListener(aVar.gQW);
            kVar.iFM.setOnLongClickListener(this.mOnLongClickListener);
            kVar.iFM.setOnTouchListener(this.iFA);
            kVar.iFM.setCommonTextViewOnClickListener(this.akt);
            kVar.iFM.setOnImageClickListener(this.dMx);
            kVar.iFM.setOnImageTouchListener(this.iFA);
            kVar.iFM.setOnEmotionClickListener(aVar.iSG);
            kVar.iFM.setOnVoiceAfterClickListener(this.akt);
            kVar.iFW.setOnClickListener(this.akt);
            kVar.iFX.setOnClickListener(this.akt);
            kVar.iFP.setOnClickListener(this.akt);
            kVar.iFQ.setOnClickListener(this.akt);
        }
    }

    private void nw() {
        this.Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).tM("#4D000000").aHd()});
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).tM("#4D000000").aHd()});
        this.iDp = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(this.aqI).tM("#4D000000").aHd()});
    }

    public void a(TbRichTextView.c cVar) {
        this.iFy = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEI = eVar;
    }

    public void dI(String str) {
        this.aqV = str;
    }

    public void pw(boolean z) {
        this.iEJ = z;
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iGg.cni(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.iFM.setTextViewOnTouchListener(this.dqK);
        kVar.iFM.setTextViewCheckSelection(false);
    }

    public void P(View.OnClickListener onClickListener) {
        this.iES = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMx = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
