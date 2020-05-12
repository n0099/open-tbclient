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
    private View.OnClickListener aDi;
    private int aJH;
    private String aJV;
    private LayerDrawable agj;
    private LayerDrawable agk;
    private int aqV;
    private com.baidu.tieba.pb.a.c dRm;
    private TbRichTextView.i emX;
    private boolean epI;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hdt;
    private com.baidu.adp.lib.d.b<TbImageView> hdu;
    private int jpl;
    private int jpm;
    private LayerDrawable jpn;
    protected com.baidu.tieba.pb.data.e jqG;
    private boolean jqH;
    private View.OnClickListener jqQ;
    private int jrv;
    private TbRichTextView.c jrw;
    private com.baidu.tieba.pb.pb.sub.b jrx;
    private com.baidu.tieba.pb.a.c jry;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        if (view != null && (view.getTag() instanceof k)) {
            k kVar = (k) view.getTag();
            if (kVar.jrI != null && kVar.jrI.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.dmX = 5;
                dVar.dmZ = 2;
                kVar.jrI.setStatisticData(dVar);
                kVar.jrI.aPM();
            }
        }
    }

    public j(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aJH = 0;
        this.jrv = 0;
        this.jpl = 0;
        this.jpm = 0;
        this.jrw = null;
        this.jqH = true;
        this.aJV = null;
        this.jqG = null;
        this.jqQ = null;
        this.aDi = null;
        this.emX = null;
        this.dRm = null;
        this.mOnLongClickListener = null;
        this.jrx = null;
        this.epI = true;
        this.hdt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQP */
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
        this.hdu = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aQE */
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
        this.jry = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.jpW == null || j.this.jpW.cxt() == null || j.this.jpW.cxt().cAl())) {
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
                if (j.this.dRm != null) {
                    if (!(view instanceof TbListTextView) || j.this.aDi == null) {
                        j.this.dRm.S(view);
                        j.this.dRm.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.aDi.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.cwB() != null) {
            this.aqV = bVar.cwB().czh();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.jse.cyi().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aqV);
        kVar.jrL.setConstrainLayoutPool(this.hdt);
        kVar.jrL.setImageViewPool(this.hdu);
        a(kVar);
        this.aJH = getDimensionPixelSize(R.dimen.tbds10);
        this.jrv = getDimensionPixelSize(R.dimen.tbds14);
        this.jpl = getDimensionPixelSize(R.dimen.tbds40);
        this.jpm = getDimensionPixelSize(R.dimen.tbds6);
        if (kVar.jrK != null) {
            kVar.jrK.setDuiEnabled(this.epI);
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
            postData2.aLL();
            g(postData2);
            a(kVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.epI = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.kTp) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.jqG, postData, postData.locate, i, 6);
            postData.kTq = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.cWm())) {
                Iterator<PostData> it = postData.cWm().iterator();
                while (it.hasNext()) {
                    it.next().kTq = b;
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
        if (kVar != null && kVar.jrC != null) {
            if (this.jse != null && this.jse.cwB() != null && this.jse.cwB().czp() && com.baidu.tbadk.core.util.aq.equals(this.jse.cwB().cyx(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.jrC, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.jrC, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, boolean z, String str) {
        if (z) {
            kVar.jsa.setVisibility(8);
            if (StringUtils.isNull(str)) {
                kVar.jsc.setText(R.string.expand_content);
                return;
            } else {
                kVar.jsc.setText(str);
                return;
            }
        }
        kVar.jsa.setVisibility(0);
        kVar.jsc.setText(R.string.close_content);
    }

    private void c(final k kVar, final PostData postData) {
        if (postData.cWB() == 2 || postData.cWB() == 4) {
            kVar.jsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = kVar.jsa.getVisibility() == 8;
                    j.this.a(kVar, !z, postData.cvA());
                    postData.tT(z ? false : true);
                    j.this.d(kVar, postData);
                    if (j.this.jpW != null && j.this.jpW.cxt() != null && j.this.jpW.cxt().cBn() != null && j.this.jpW.cxt().getListView() != null && !z && kVar.getView().getTop() < j.this.jpW.cxt().cBn().getMeasuredHeight()) {
                        j.this.jpW.cxt().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(j.this.jpW.cxt().getListView().getData(), postData) + j.this.jpW.cxt().getListView().getHeaderViewsCount(), j.this.jpW.cxt().cBn().getMeasuredHeight());
                    }
                }
            });
            kVar.jsb.setVisibility(0);
            a(kVar, postData.cWk(), postData.cvA());
            a(true, kVar, postData);
        } else {
            kVar.jsb.setVisibility(8);
            kVar.jsa.setVisibility(0);
            a(false, kVar, postData);
        }
        d(kVar, postData);
    }

    private void a(boolean z, k kVar, PostData postData) {
        if (kVar != null && kVar.mBottomLine != null && kVar.jsb != null && (kVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (kVar.jsb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cWm());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) kVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) kVar.jsb.getLayoutParams();
            if (z) {
                kVar.jrK.getLayoutStrategy().nE(0);
                if (z2) {
                    kVar.jrK.getLayoutStrategy().nD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    kVar.jrK.getLayoutStrategy().nD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                kVar.jsb.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    kVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            kVar.jrK.getLayoutStrategy().nD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            kVar.jrK.getLayoutStrategy().nE(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                kVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, PostData postData) {
        TbRichText cWr = postData.cWr();
        cWr.isChanged = true;
        kVar.jrK.setText(cWr, true, this.jrw);
    }

    private void h(PostData postData) {
        if (postData.dsl == 0 && postData.hfP) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cI("post_id", postData.getId());
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cI("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cI("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cI("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.t(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.jse != null) {
                int czh = this.jse.cwB().czh();
                if (1 == czh || 2 == czh) {
                    anVar.cI("obj_source", "1");
                } else if (3 == czh) {
                    anVar.cI("obj_source", "2");
                } else {
                    anVar.cI("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.jqG != null) {
            if (this.jqG.aQe()) {
                if (this.jsf != null) {
                    com.baidu.tieba.pb.c.a.a(this.jsf.getUniqueId(), this.jqG, postData, postData.locate, postData.kTp ? 2 : 8);
                }
            } else if (this.jpW != null) {
                com.baidu.tieba.pb.c.a.a(this.jpW.getUniqueId(), this.jqG, postData, postData.locate, postData.kTp ? 2 : 8);
            }
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.cCZ() == null) {
            kVar.jrU.setVisibility(8);
            return;
        }
        TbRichText cWr = postData.cWr();
        com.baidu.tieba.pb.view.b.a(postData.cCZ(), kVar.jrU, false, false, cWr != null && StringUtils.isNull(cWr.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jqH) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.jrK.setLayoutParams(layoutParams);
            kVar.jrK.setPadding(0, 0, 0, 0);
            kVar.jrK.xy(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.jrK.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.jrK.setLayoutParams(layoutParams2);
            kVar.jrK.xy(postData.getBimg_url());
        }
        kVar.jrK.setTextViewOnTouchListener(this.jry);
        kVar.jrK.setTextViewCheckSelection(false);
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
            if (postData.aKC() == null || postData.aKC().isBaijiahaoUser()) {
            }
            if (postData.kTf) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            kVar.jrJ.setTag(null);
            kVar.jrJ.setUserId(null);
            kVar.gbZ.setText((CharSequence) null);
            kVar.jrR.getHeadView().setUserId(null);
            kVar.jrK.setIsHost(false);
            if (postData.aKC() != null) {
                if (this.aJV != null && !this.aJV.equals("0") && this.aJV.equals(postData.aKC().getUserId())) {
                    kVar.jrK.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aKC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aKC().getTShowInfoNew();
                if (kVar.jrT != null) {
                    kVar.jrT.setTag(R.id.tag_user_id, postData.aKC().getUserId());
                    if (this.jse != null && this.jse.cyi() != null) {
                        kVar.jrT.setOnClickListener(this.jse.cyi().jqi.jEE);
                    }
                    kVar.jrT.a(iconInfo, 2, this.jpl, this.jpl, this.aJH);
                }
                if (kVar.jrS != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.jrS.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.jse != null && this.jse.cyi() != null) {
                        kVar.jrS.setOnClickListener(this.jse.cyi().jqi.jEF);
                    }
                    kVar.jrS.a(tShowInfoNew, 3, this.jpl, this.jpl, this.aJH, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aKC().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbZ, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbZ, R.color.cp_cont_b, 1);
                }
                String avater = postData.aKC().getAvater();
                int i2 = 8;
                if (postData.kTp) {
                    i2 = 2;
                }
                kVar.gbZ.setTag(R.id.tag_user_id, postData.aKC().getUserId());
                kVar.gbZ.setTag(R.id.tag_user_name, postData.aKC().getUserName());
                kVar.gbZ.setTag(R.id.tag_virtual_user_url, postData.aKC().getVirtualUserUrl());
                kVar.gbZ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jqG, postData, postData.locate, i2, 2));
                String name_show = postData.aKC().getName_show();
                String userName = postData.aKC().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.gbZ.setText(com.baidu.tieba.pb.c.aJ(this.mContext, kVar.gbZ.getText().toString()));
                    kVar.gbZ.setGravity(16);
                    kVar.gbZ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvb());
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbZ, R.color.cp_other_f, 1);
                }
                if (postData.aKC().getPendantData() != null && !StringUtils.isNull(postData.aKC().getPendantData().aIU())) {
                    kVar.jrR.b(postData.aKC());
                    kVar.jrJ.setVisibility(8);
                    kVar.jrR.setVisibility(0);
                    kVar.jrR.getHeadView().startLoad(avater, 28, false);
                    kVar.jrR.getHeadView().setUserId(postData.aKC().getUserId());
                    kVar.jrR.getHeadView().setUserName(postData.aKC().getUserName());
                    kVar.jrR.getHeadView().setFid(this.jqG != null ? this.jqG.getForumId() : "");
                    kVar.jrR.getHeadView().setTid(postData.getId());
                    kVar.jrR.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jqG, postData, postData.locate, i2, 2));
                    kVar.jrR.vj(postData.aKC().getPendantData().aIU());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.jrJ, postData.aKC(), 0);
                    kVar.jrJ.setUserId(postData.aKC().getUserId());
                    kVar.jrJ.setFid(this.jqG != null ? this.jqG.getForumId() : "");
                    kVar.jrJ.setTid(postData.getId());
                    kVar.jrJ.setUserName(postData.aKC().getUserName(), postData.cWz());
                    kVar.jrJ.setTag(R.id.tag_virtual_user_url, postData.aKC().getVirtualUserUrl());
                    kVar.jrJ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jqG, postData, postData.locate, i2, 2));
                    kVar.jrJ.setImageDrawable(null);
                    kVar.jrJ.startLoad(avater, 28, false);
                    kVar.jrJ.setVisibility(0);
                    kVar.jrR.setVisibility(8);
                }
                if (this.jqG != null && this.jqG.cvQ()) {
                    kVar.jrD.setVisibility(8);
                    kVar.jrD.setTag(null);
                } else if (postData.aKC() != null) {
                    MetaData aKC = postData.aKC();
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrD, (int) R.color.cp_cont_a);
                    if (this.aJV != null && !this.aJV.equals("0") && this.aJV.equals(aKC.getUserId())) {
                        kVar.jrD.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (this.jpn.getDrawable(1) != null) {
                                this.jpn.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.jpn.getDrawable(1) != null) {
                            this.jpn.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(this.jpn);
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.host_name);
                    } else if (aKC.getIs_bawu() == 1 && postData.cWh()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrD, R.drawable.brand_official_btn);
                        kVar.jrD.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.brand_Official);
                    } else if (aKC.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aKC.getBawu_type())) {
                        kVar.jrD.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.agj.getDrawable(1) != null) {
                                this.agj.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agj.getDrawable(1) != null) {
                            this.agj.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(this.agj);
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aKC.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aKC.getBawu_type())) {
                        kVar.jrD.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.agk.getDrawable(1) != null) {
                                this.agk.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agk.getDrawable(1) != null) {
                            this.agk.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(this.agk);
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aKC.getIs_bawu() == 1 && "pri_content_assist".equals(aKC.getBawu_type())) {
                        int kB = com.baidu.tbadk.core.util.am.kB(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrD, kB);
                        kVar.jrD.setTag(Integer.valueOf(kB));
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_content_assist_tip);
                    } else if (aKC.getIs_bawu() == 1 && "pri_manage_assist".equals(aKC.getBawu_type())) {
                        int kB2 = com.baidu.tbadk.core.util.am.kB(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrD, kB2);
                        kVar.jrD.setTag(Integer.valueOf(kB2));
                        kVar.jrD.setVisibility(0);
                        kVar.jrD.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.jrD.setVisibility(8);
                        kVar.jrD.setTag(null);
                    }
                } else {
                    kVar.jrD.setVisibility(8);
                    kVar.jrD.setTag(null);
                }
            }
            int i3 = 0;
            if (this.jse != null && this.jse.cyi() != null && this.jse.cyi().cwr() && postData.aKC() != null) {
                i3 = postData.aKC().getLevel_id();
            }
            if (this.jqG != null && this.jqG.cvQ()) {
                i3 = 0;
            }
            if (i3 > 0) {
                kVar.jrQ.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.jrQ, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                kVar.jrQ.setVisibility(8);
            }
            int i4 = 15;
            if (kVar.jrT.getChildCount() == 1) {
                i4 = 13;
            } else if (kVar.jrT.getChildCount() > 1) {
                i4 = 11;
            }
            if (kVar.jrD.getVisibility() == 0) {
                i4 -= 2;
            }
            if (kVar.jrS.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aLY() > 1000) {
                i4 -= 2;
            }
            if (postData.aLY() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                kVar.jrT.setVisibility(8);
                if (kVar.jrT.getChildCount() == 1) {
                    i4 += 2;
                } else if (kVar.jrT.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && kVar.jrD.getVisibility() == 0) {
                    i4 += 2;
                    kVar.jrD.setVisibility(8);
                }
                if (i4 < 10 && kVar.jrQ.getVisibility() == 0) {
                    i4 += 2;
                    kVar.jrQ.setVisibility(8);
                }
            }
            String name_show2 = postData.aKC() != null ? postData.aKC().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.aKC() != null && !StringUtils.isNull(postData.aKC().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aKC() != null && !StringUtils.isNull(postData.aKC().getSealPrefix())) {
                kVar.gbZ.setText(cL(postData.aKC().getSealPrefix(), name_show2));
            } else {
                kVar.gbZ.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cWp()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aKC() != null && !StringUtils.isNull(postData.aKC().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.jqG != null && this.jqG.cvE() != 0) {
                if (this.jqG.cvE() != 1002 && this.jqG.cvE() != 3) {
                    z10 = true;
                }
                if (this.jqG.cvE() != 3 && !this.jqG.cvQ()) {
                    z11 = true;
                }
                if (postData != null && postData.aKC() != null) {
                    String userId2 = postData.aKC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.jqG != null && this.jqG.cvs() != null && this.jqG.cvs().aKC() != null && postData.aKC() != null) {
                            userId = this.jqG.cvs().aKC().getUserId();
                            String userId3 = postData.aKC().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aKC() != null && UtilHelper.isCurrentAccount(postData.aKC().getUserId())) {
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
                                if (postData.cWp() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqG.cvE()));
                                    if (postData.aKC() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aKC().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKC().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKC().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aKC() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKC().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKC().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKC().getName_show());
                                    }
                                    if (this.jqG.cvs() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.jqG.cvs().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jqG.cvE()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.jrK.setTag(sparseArray);
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
                        if (postData.cWp() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        kVar.jrK.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.jqG != null) {
                userId = this.jqG.cvs().aKC().getUserId();
                String userId32 = postData.aKC().getUserId();
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
            if (postData.cWp() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            kVar.jrK.setTag(sparseArray);
        }
    }

    private void f(k kVar, PostData postData) {
        if (kVar != null && postData != null && postData.aMq() != null) {
            postData.aMq().threadId = this.jse.cwB().cyy();
            postData.aMq().objType = 1;
            postData.aMq().isInPost = true;
            bj bjVar = null;
            if (this.jqG != null && this.jqG.cvs() != null) {
                bjVar = this.jqG.cvs();
            }
            if (bjVar != null && bjVar.aMy()) {
                kVar.jrI.setAgreeAlone(true);
            }
            kVar.jrI.setData(postData.aMq());
        }
    }

    private void g(k kVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cWp() > 0 && this.jqG != null && !this.jqG.cvQ()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cWp()));
                kVar.jrP.setVisibility(0);
                kVar.jrP.setText(format);
                z = true;
            } else {
                kVar.jrP.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cWs = postData.cWs();
            boolean z2 = (cWs == null || StringUtils.isNull(cWs.getName()) || this.jqG == null || this.jqG.cvQ()) ? false : true;
            if (z) {
                kVar.jrF.setVisibility(0);
                i = this.jrv;
            } else {
                kVar.jrF.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.jrG.setVisibility(0);
                i2 = this.jrv;
            } else {
                kVar.jrG.setVisibility(8);
                i2 = 0;
            }
            kVar.jrE.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                kVar.jrE.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.jrE.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.jrH.setVisibility(0);
                kVar.jrH.setPadding(this.jrv, 0, 0, 0);
                if (postData.kTn) {
                    kVar.jrH.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cWs.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    kVar.jrH.setText(cWs.getName());
                    return;
                }
            }
            kVar.jrH.setVisibility(8);
        }
    }

    private void a(k kVar, PostData postData, View view) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.jrK.setPadding(0, 0, 0, 0);
            if (!this.jqH) {
                kVar.jrK.getLayoutStrategy().ny(R.drawable.icon_click);
            } else {
                kVar.jrK.xy(null);
                kVar.jrK.setBackgroundDrawable(null);
                kVar.jrK.getLayoutStrategy().ny(R.drawable.transparent_bg);
            }
            kVar.jrK.getLayoutStrategy().nv(R.drawable.pic_video);
            a(kVar.jrK, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.jrK.setLayoutParams(layoutParams);
            kVar.jrK.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            kVar.jrK.setIsFromCDN(this.mIsFromCDN);
            TbRichText cWr = postData.cWr();
            kVar.jrK.setIsUseGridImage(postData.cWC());
            kVar.jrK.setText(cWr, true, this.jrw);
            SparseArray sparseArray = (SparseArray) kVar.jrK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            kVar.jrK.setTag(sparseArray);
            kVar.jrC.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().eoC = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nx((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.cWt() > 0) {
                kVar.jrO.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) kVar.jrO.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    kVar.jrO.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cWB() == 2) {
                    kVar.jrO.setVisibility(8);
                } else {
                    kVar.jrO.setVisibility(0);
                }
                kVar.jrN.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cWt() > 0) {
                    kVar.jrN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cWt())));
                    SparseArray sparseArray2 = (SparseArray) kVar.jrN.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        kVar.jrN.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    kVar.jrN.setVisibility(0);
                    kVar.jrO.setVisibility(8);
                    kVar.jrM.setVisibility(8);
                }
            } else {
                kVar.jrN.setVisibility(8);
                if (postData.cWt() > 0 && postData.cWm() != null && postData.cWm().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.jrM.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    kVar.jrM.setLayoutParams(layoutParams);
                    if (this.jrx == null) {
                        this.jrx = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.jrx.setIsFromCDN(this.mIsFromCDN);
                        this.jrx.setOnLongClickListener(this.mOnLongClickListener);
                        this.jrx.T(this.jqQ);
                        this.jrx.z(this.aDi);
                        String str = null;
                        if (this.jqG != null && this.jqG.cvs() != null && this.jqG.cvs().aKC() != null) {
                            str = this.jqG.cvs().aKC().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.jqG != null) {
                            this.jrx.U(this.jqG.cvE(), z);
                            this.jrx.setThreadData(this.jqG.cvs());
                        }
                    }
                    this.jrx.Ic(postData.getId());
                    kVar.jrM.setSubPbAdapter(this.jrx);
                    kVar.jrM.setVisibility(0);
                    kVar.jrM.setData(postData, view);
                    kVar.jrM.setChildOnClickListener(this.aDi);
                    kVar.jrM.setChildOnLongClickListener(this.mOnLongClickListener);
                    kVar.jrM.setChildOnTouchListener(this.jry);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.jrM.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    kVar.jrM.setLayoutParams(layoutParams2);
                    kVar.jrM.setVisibility(8);
                }
            }
            if (postData.kTd) {
                kVar.mBottomLine.setVisibility(0);
            } else {
                kVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(k kVar, PostData postData) {
        if (kVar != null && kVar.jrY != null && kVar.jrV != null) {
            if (postData == null || postData.kTh == null || StringUtils.isNull(postData.kTh.liveTitle)) {
                kVar.jrV.setVisibility(8);
                return;
            }
            kVar.jrY.setText(postData.kTh.liveTitle);
            kVar.jrV.setTag(postData.kTh);
            kVar.jrV.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.jsd.setVisibility(postData.kTn ? 0 : 8);
        }
    }

    private void a(k kVar) {
        LayerDrawable layerDrawable;
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.gbZ, R.color.cp_cont_b, 1);
                if (kVar.jrD.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrD, ((Integer) kVar.jrD.getTag()).intValue());
                } else if (kVar.jrD.getTag() instanceof String) {
                    if (kVar.jrD.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.agj;
                    } else if (kVar.jrD.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.agk;
                    } else {
                        layerDrawable = kVar.jrD.getTag().equals("HOST") ? this.jpn : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.jrD.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrE, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrF, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrG, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrP, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrH, R.color.cp_cont_d, 1);
                kVar.jrK.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.jrM, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrN, (int) R.color.cp_cont_c);
                kVar.jrN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrO, (int) R.color.cp_cont_c);
                kVar.jrM.onChangeSkinType();
                kVar.jrL.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrY, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jrW, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrV, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.jrX, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.jrZ, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.jsc, (int) R.color.cp_cont_c);
                if (kVar.jsa.getVisibility() == 8) {
                    kVar.jsc.setText(R.string.close_content);
                } else if (this.jqG != null && StringUtils.isNull(this.jqG.cvA())) {
                    kVar.jsc.setText(this.jqG.cvA());
                } else {
                    kVar.jsc.setText(R.string.expand_content);
                }
                kVar.jrI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.jrC.setOnTouchListener(this.jry);
        kVar.jrC.setOnLongClickListener(this.mOnLongClickListener);
        if (this.jse.cyi() != null && this.jse.cyi().getPageContext() != null && this.jse.cyi().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.jse.cyi().jqi;
            kVar.gbZ.setOnClickListener(aVar.gHY);
            kVar.jrJ.setOnClickListener(aVar.gHY);
            kVar.jrR.setOnClickListener(aVar.gHY);
            kVar.jrR.getHeadView().setOnClickListener(aVar.gHY);
            kVar.jrK.setOnLongClickListener(this.mOnLongClickListener);
            kVar.jrK.setOnTouchListener(this.jry);
            kVar.jrK.setCommonTextViewOnClickListener(this.aDi);
            kVar.jrK.setOnImageClickListener(this.emX);
            kVar.jrK.setOnImageTouchListener(this.jry);
            kVar.jrK.setOnEmotionClickListener(aVar.jEG);
            kVar.jrK.setOnVoiceAfterClickListener(this.aDi);
            kVar.jrU.setOnClickListener(this.aDi);
            kVar.jrV.setOnClickListener(this.aDi);
            kVar.jrN.setOnClickListener(this.aDi);
            kVar.jrO.setOnClickListener(this.aDi);
        }
    }

    private void rP() {
        this.agj = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.jpm).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPx(), com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.jpm).vd("#4D000000").aPx()});
        this.agk = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.jpm).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPx(), com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.jpm).vd("#4D000000").aPx()});
        this.jpn = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.jpm).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aPx(), com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.jpm).vd("#4D000000").aPx()});
    }

    public void a(TbRichTextView.c cVar) {
        this.jrw = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jqG = eVar;
    }

    public void eA(String str) {
        this.aJV = str;
    }

    public void qG(boolean z) {
        this.jqH = z;
    }

    private SpannableStringBuilder cL(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.jse.cyi(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.jrK.setTextViewOnTouchListener(this.dRm);
        kVar.jrK.setTextViewCheckSelection(false);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqQ = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emX = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
