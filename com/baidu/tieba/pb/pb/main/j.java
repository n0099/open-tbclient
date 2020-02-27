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
    private TbRichTextView.i dMw;
    private boolean dPe;
    private com.baidu.tieba.pb.a.c dqJ;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gtj;
    private com.baidu.adp.lib.d.b<TbImageView> gtk;
    private int iDm;
    private LayerDrawable iDn;
    protected com.baidu.tieba.pb.data.e iEG;
    private boolean iEH;
    private View.OnClickListener iEQ;
    private int iFv;
    private TbRichTextView.c iFw;
    private com.baidu.tieba.pb.pb.sub.b iFx;
    private com.baidu.tieba.pb.a.c iFy;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(View view) {
        if (view != null && (view.getTag() instanceof k)) {
            k kVar = (k) view.getTag();
            if (kVar.iFI != null && kVar.iFI.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNA = 5;
                dVar.cNC = 2;
                kVar.iFI.setStatisticData(dVar);
                kVar.iFI.aHq();
            }
        }
    }

    public j(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aqJ = 0;
        this.iFv = 0;
        this.iDm = 0;
        this.aqI = 0;
        this.iFw = null;
        this.iEH = true;
        this.aqV = null;
        this.iEG = null;
        this.iEQ = null;
        this.akt = null;
        this.dMw = null;
        this.dqJ = null;
        this.mOnLongClickListener = null;
        this.iFx = null;
        this.dPe = true;
        this.gtj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGa */
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
        this.gtk = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIe */
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
        this.iFy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.iDW == null || j.this.iDW.cmr() == null || j.this.iDW.cmr().cpj())) {
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
                if (j.this.dqJ != null) {
                    if (!(view instanceof TbListTextView) || j.this.akt == null) {
                        j.this.dqJ.Q(view);
                        j.this.dqJ.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.akt.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.clz() != null) {
            this.Yv = bVar.clz().cof();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.iGe.cng().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.Yv);
        kVar.iFL.setConstrainLayoutPool(this.gtj);
        kVar.iFL.setImageViewPool(this.gtk);
        a(kVar);
        this.aqJ = getDimensionPixelSize(R.dimen.tbds10);
        this.iFv = getDimensionPixelSize(R.dimen.tbds14);
        this.iDm = getDimensionPixelSize(R.dimen.tbds40);
        this.aqI = getDimensionPixelSize(R.dimen.tbds6);
        if (kVar.iFK != null) {
            kVar.iFK.setDuiEnabled(this.dPe);
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
            postData2.aDu();
            g(postData2);
            a(kVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.dPe = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.kho) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.iEG, postData, postData.locate, i, 6);
            postData.khp = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.cKV())) {
                Iterator<PostData> it = postData.cKV().iterator();
                while (it.hasNext()) {
                    it.next().khp = b;
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
        if (kVar != null && kVar.iFC != null) {
            if (this.iGe != null && this.iGe.clz() != null && this.iGe.clz().con() && com.baidu.tbadk.core.util.aq.equals(this.iGe.clz().cnv(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFC, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFC, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, boolean z, String str) {
        if (z) {
            kVar.iGa.setVisibility(8);
            if (StringUtils.isNull(str)) {
                kVar.iGc.setText(R.string.expand_content);
                return;
            } else {
                kVar.iGc.setText(str);
                return;
            }
        }
        kVar.iGa.setVisibility(0);
        kVar.iGc.setText(R.string.close_content);
    }

    private void c(final k kVar, final PostData postData) {
        if (postData.cLk() == 2 || postData.cLk() == 4) {
            kVar.iGb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = kVar.iGa.getVisibility() == 8;
                    j.this.a(kVar, !z, postData.ckA());
                    postData.sL(z ? false : true);
                    j.this.d(kVar, postData);
                    if (j.this.iDW != null && j.this.iDW.cmr() != null && j.this.iDW.cmr().cql() != null && j.this.iDW.cmr().getListView() != null && !z && kVar.getView().getTop() < j.this.iDW.cmr().cql().getMeasuredHeight()) {
                        j.this.iDW.cmr().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(j.this.iDW.cmr().getListView().getData(), postData) + j.this.iDW.cmr().getListView().getHeaderViewsCount(), j.this.iDW.cmr().cql().getMeasuredHeight());
                    }
                }
            });
            kVar.iGb.setVisibility(0);
            a(kVar, postData.cKT(), postData.ckA());
            a(true, kVar, postData);
        } else {
            kVar.iGb.setVisibility(8);
            kVar.iGa.setVisibility(0);
            a(false, kVar, postData);
        }
        d(kVar, postData);
    }

    private void a(boolean z, k kVar, PostData postData) {
        if (kVar != null && kVar.mBottomLine != null && kVar.iGb != null && (kVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (kVar.iGb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cKV());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) kVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) kVar.iGb.getLayoutParams();
            if (z) {
                kVar.iFK.getLayoutStrategy().nq(0);
                if (z2) {
                    kVar.iFK.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    kVar.iFK.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                kVar.iGb.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    kVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            kVar.iFK.getLayoutStrategy().np(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            kVar.iFK.getLayoutStrategy().nq(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                kVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, PostData postData) {
        TbRichText cLa = postData.cLa();
        cLa.isChanged = true;
        kVar.iFK.setText(cLa, true, this.iFw);
    }

    private void h(PostData postData) {
        if (postData.cSJ == 0 && postData.gvD) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cy("post_id", postData.getId());
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cy("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cy("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.iGe != null) {
                int cof = this.iGe.clz().cof();
                if (1 == cof || 2 == cof) {
                    anVar.cy("obj_source", "1");
                } else if (3 == cof) {
                    anVar.cy("obj_source", "2");
                } else {
                    anVar.cy("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.iEG != null) {
            if (this.iEG.aHI()) {
                if (this.iGf != null) {
                    com.baidu.tieba.pb.c.a.a(this.iGf.getUniqueId(), this.iEG, postData, postData.locate, postData.kho ? 2 : 8);
                }
            } else if (this.iDW != null) {
                com.baidu.tieba.pb.c.a.a(this.iDW.getUniqueId(), this.iEG, postData, postData.locate, postData.kho ? 2 : 8);
            }
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.crX() == null) {
            kVar.iFU.setVisibility(8);
            return;
        }
        TbRichText cLa = postData.cLa();
        com.baidu.tieba.pb.view.b.a(postData.crX(), kVar.iFU, false, false, cLa != null && StringUtils.isNull(cLa.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEH) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iFK.setLayoutParams(layoutParams);
            kVar.iFK.setPadding(0, 0, 0, 0);
            kVar.iFK.wh(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFK.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iFK.setLayoutParams(layoutParams2);
            kVar.iFK.wh(postData.getBimg_url());
        }
        kVar.iFK.setTextViewOnTouchListener(this.iFy);
        kVar.iFK.setTextViewCheckSelection(false);
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
            if (postData.aCm() == null || postData.aCm().isBaijiahaoUser()) {
            }
            if (postData.khe) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            kVar.iFJ.setTag(null);
            kVar.iFJ.setUserId(null);
            kVar.fwA.setText((CharSequence) null);
            kVar.iFR.getHeadView().setUserId(null);
            kVar.iFK.setIsHost(false);
            if (postData.aCm() != null) {
                if (this.aqV != null && !this.aqV.equals("0") && this.aqV.equals(postData.aCm().getUserId())) {
                    kVar.iFK.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCm().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCm().getTShowInfoNew();
                if (kVar.iFT != null) {
                    kVar.iFT.setTag(R.id.tag_user_id, postData.aCm().getUserId());
                    if (this.iGe != null && this.iGe.cng() != null) {
                        kVar.iFT.setOnClickListener(this.iGe.cng().iEi.iSC);
                    }
                    kVar.iFT.a(iconInfo, 2, this.iDm, this.iDm, this.aqJ);
                }
                if (kVar.iFS != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iFS.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.iGe != null && this.iGe.cng() != null) {
                        kVar.iFS.setOnClickListener(this.iGe.cng().iEi.iSD);
                    }
                    kVar.iFS.a(tShowInfoNew, 3, this.iDm, this.iDm, this.aqJ, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aCm().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwA, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwA, R.color.cp_cont_b, 1);
                }
                String avater = postData.aCm().getAvater();
                int i2 = 8;
                if (postData.kho) {
                    i2 = 2;
                }
                kVar.fwA.setTag(R.id.tag_user_id, postData.aCm().getUserId());
                kVar.fwA.setTag(R.id.tag_user_name, postData.aCm().getUserName());
                kVar.fwA.setTag(R.id.tag_virtual_user_url, postData.aCm().getVirtualUserUrl());
                kVar.fwA.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEG, postData, postData.locate, i2, 2));
                String name_show = postData.aCm().getName_show();
                String userName = postData.aCm().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fwA.setText(com.baidu.tieba.pb.c.ba(this.mContext, kVar.fwA.getText().toString()));
                    kVar.fwA.setGravity(16);
                    kVar.fwA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.ckb());
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwA, R.color.cp_other_f, 1);
                }
                if (postData.aCm().getPendantData() != null && !StringUtils.isNull(postData.aCm().getPendantData().aAE())) {
                    kVar.iFR.b(postData.aCm());
                    kVar.iFJ.setVisibility(8);
                    kVar.iFR.setVisibility(0);
                    kVar.iFR.getHeadView().startLoad(avater, 28, false);
                    kVar.iFR.getHeadView().setUserId(postData.aCm().getUserId());
                    kVar.iFR.getHeadView().setUserName(postData.aCm().getUserName());
                    kVar.iFR.getHeadView().setFid(this.iEG != null ? this.iEG.getForumId() : "");
                    kVar.iFR.getHeadView().setTid(postData.getId());
                    kVar.iFR.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEG, postData, postData.locate, i2, 2));
                    kVar.iFR.tS(postData.aCm().getPendantData().aAE());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iFJ, postData.aCm(), 0);
                    kVar.iFJ.setUserId(postData.aCm().getUserId());
                    kVar.iFJ.setFid(this.iEG != null ? this.iEG.getForumId() : "");
                    kVar.iFJ.setTid(postData.getId());
                    kVar.iFJ.setUserName(postData.aCm().getUserName(), postData.cLi());
                    kVar.iFJ.setTag(R.id.tag_virtual_user_url, postData.aCm().getVirtualUserUrl());
                    kVar.iFJ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iEG, postData, postData.locate, i2, 2));
                    kVar.iFJ.setImageDrawable(null);
                    kVar.iFJ.startLoad(avater, 28, false);
                    kVar.iFJ.setVisibility(0);
                    kVar.iFR.setVisibility(8);
                }
                if (this.iEG != null && this.iEG.ckQ()) {
                    kVar.iFD.setVisibility(8);
                    kVar.iFD.setTag(null);
                } else if (postData.aCm() != null) {
                    MetaData aCm = postData.aCm();
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFD, (int) R.color.cp_cont_a);
                    if (this.aqV != null && !this.aqV.equals("0") && this.aqV.equals(aCm.getUserId())) {
                        kVar.iFD.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (this.iDn.getDrawable(1) != null) {
                                this.iDn.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.iDn.getDrawable(1) != null) {
                            this.iDn.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(this.iDn);
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.host_name);
                    } else if (aCm.getIs_bawu() == 1 && postData.cKQ()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFD, R.drawable.brand_official_btn);
                        kVar.iFD.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.brand_Official);
                    } else if (aCm.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCm.getBawu_type())) {
                        kVar.iFD.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nu.getDrawable(1) != null) {
                                this.Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nu.getDrawable(1) != null) {
                            this.Nu.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(this.Nu);
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aCm.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCm.getBawu_type())) {
                        kVar.iFD.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(this.Nv);
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aCm.getIs_bawu() == 1 && "pri_content_assist".equals(aCm.getBawu_type())) {
                        int ku = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFD, ku);
                        kVar.iFD.setTag(Integer.valueOf(ku));
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_content_assist_tip);
                    } else if (aCm.getIs_bawu() == 1 && "pri_manage_assist".equals(aCm.getBawu_type())) {
                        int ku2 = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFD, ku2);
                        kVar.iFD.setTag(Integer.valueOf(ku2));
                        kVar.iFD.setVisibility(0);
                        kVar.iFD.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iFD.setVisibility(8);
                        kVar.iFD.setTag(null);
                    }
                } else {
                    kVar.iFD.setVisibility(8);
                    kVar.iFD.setTag(null);
                }
            }
            int i3 = 0;
            if (this.iGe != null && this.iGe.cng() != null && this.iGe.cng().clp() && postData.aCm() != null) {
                i3 = postData.aCm().getLevel_id();
            }
            if (this.iEG != null && this.iEG.ckQ()) {
                i3 = 0;
            }
            if (i3 > 0) {
                kVar.iFQ.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iFQ, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                kVar.iFQ.setVisibility(8);
            }
            int i4 = 15;
            if (kVar.iFT.getChildCount() == 1) {
                i4 = 13;
            } else if (kVar.iFT.getChildCount() > 1) {
                i4 = 11;
            }
            if (kVar.iFD.getVisibility() == 0) {
                i4 -= 2;
            }
            if (kVar.iFS.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aDG() > 1000) {
                i4 -= 2;
            }
            if (postData.aDG() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                kVar.iFT.setVisibility(8);
                if (kVar.iFT.getChildCount() == 1) {
                    i4 += 2;
                } else if (kVar.iFT.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && kVar.iFD.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iFD.setVisibility(8);
                }
                if (i4 < 10 && kVar.iFQ.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iFQ.setVisibility(8);
                }
            }
            String name_show2 = postData.aCm() != null ? postData.aCm().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.aCm() != null && !StringUtils.isNull(postData.aCm().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aCm() != null && !StringUtils.isNull(postData.aCm().getSealPrefix())) {
                kVar.fwA.setText(cB(postData.aCm().getSealPrefix(), name_show2));
            } else {
                kVar.fwA.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cKY()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aCm() != null && !StringUtils.isNull(postData.aCm().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.iEG != null && this.iEG.ckE() != 0) {
                if (this.iEG.ckE() != 1002 && this.iEG.ckE() != 3) {
                    z10 = true;
                }
                if (this.iEG.ckE() != 3 && !this.iEG.ckQ()) {
                    z11 = true;
                }
                if (postData != null && postData.aCm() != null) {
                    String userId2 = postData.aCm().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.iEG != null && this.iEG.cks() != null && this.iEG.cks().aCm() != null && postData.aCm() != null) {
                            userId = this.iEG.cks().aCm().getUserId();
                            String userId3 = postData.aCm().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aCm() != null && UtilHelper.isCurrentAccount(postData.aCm().getUserId())) {
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
                                if (postData.cKY() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEG.ckE()));
                                    if (postData.aCm() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aCm().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCm().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCm().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aCm() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCm().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCm().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCm().getName_show());
                                    }
                                    if (this.iEG.cks() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.iEG.cks().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iEG.ckE()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iFK.setTag(sparseArray);
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
                        if (postData.cKY() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        kVar.iFK.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.iEG != null) {
                userId = this.iEG.cks().aCm().getUserId();
                String userId32 = postData.aCm().getUserId();
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
            if (postData.cKY() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            kVar.iFK.setTag(sparseArray);
        }
    }

    private void f(k kVar, PostData postData) {
        if (kVar != null && postData != null && postData.aDY() != null) {
            postData.aDY().threadId = this.iGe.clz().cnw();
            postData.aDY().objType = 1;
            postData.aDY().isInPost = true;
            bj bjVar = null;
            if (this.iEG != null && this.iEG.cks() != null) {
                bjVar = this.iEG.cks();
            }
            if (bjVar != null && bjVar.aEg()) {
                kVar.iFI.setAgreeAlone(true);
            }
            kVar.iFI.setData(postData.aDY());
        }
    }

    private void g(k kVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cKY() > 0 && this.iEG != null && !this.iEG.ckQ()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cKY()));
                kVar.iFP.setVisibility(0);
                kVar.iFP.setText(format);
                z = true;
            } else {
                kVar.iFP.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cLb = postData.cLb();
            boolean z2 = (cLb == null || StringUtils.isNull(cLb.getName()) || this.iEG == null || this.iEG.ckQ()) ? false : true;
            if (z) {
                kVar.iFF.setVisibility(0);
                i = this.iFv;
            } else {
                kVar.iFF.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iFG.setVisibility(0);
                i2 = this.iFv;
            } else {
                kVar.iFG.setVisibility(8);
                i2 = 0;
            }
            kVar.iFE.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iFE.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iFE.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iFH.setVisibility(0);
                kVar.iFH.setPadding(this.iFv, 0, 0, 0);
                if (postData.khm) {
                    kVar.iFH.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cLb.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    kVar.iFH.setText(cLb.getName());
                    return;
                }
            }
            kVar.iFH.setVisibility(8);
        }
    }

    private void a(k kVar, PostData postData, View view) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.iFK.setPadding(0, 0, 0, 0);
            if (!this.iEH) {
                kVar.iFK.getLayoutStrategy().nk(R.drawable.icon_click);
            } else {
                kVar.iFK.wh(null);
                kVar.iFK.setBackgroundDrawable(null);
                kVar.iFK.getLayoutStrategy().nk(R.drawable.transparent_bg);
            }
            kVar.iFK.getLayoutStrategy().nh(R.drawable.pic_video);
            a(kVar.iFK, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.iFK.setLayoutParams(layoutParams);
            kVar.iFK.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            kVar.iFK.setIsFromCDN(this.mIsFromCDN);
            TbRichText cLa = postData.cLa();
            kVar.iFK.setIsUseGridImage(postData.cLl());
            kVar.iFK.setText(cLa, true, this.iFw);
            SparseArray sparseArray = (SparseArray) kVar.iFK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            kVar.iFK.setTag(sparseArray);
            kVar.iFC.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().dNY = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nj((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.cLc() > 0) {
                kVar.iFO.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) kVar.iFO.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    kVar.iFO.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cLk() == 2) {
                    kVar.iFO.setVisibility(8);
                } else {
                    kVar.iFO.setVisibility(0);
                }
                kVar.iFN.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cLc() > 0) {
                    kVar.iFN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cLc())));
                    SparseArray sparseArray2 = (SparseArray) kVar.iFN.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        kVar.iFN.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    kVar.iFN.setVisibility(0);
                    kVar.iFO.setVisibility(8);
                    kVar.iFM.setVisibility(8);
                }
            } else {
                kVar.iFN.setVisibility(8);
                if (postData.cLc() > 0 && postData.cKV() != null && postData.cKV().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    kVar.iFM.setLayoutParams(layoutParams);
                    if (this.iFx == null) {
                        this.iFx = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.iFx.setIsFromCDN(this.mIsFromCDN);
                        this.iFx.setOnLongClickListener(this.mOnLongClickListener);
                        this.iFx.S(this.iEQ);
                        this.iFx.y(this.akt);
                        String str = null;
                        if (this.iEG != null && this.iEG.cks() != null && this.iEG.cks().aCm() != null) {
                            str = this.iEG.cks().aCm().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.iEG != null) {
                            this.iFx.O(this.iEG.ckE(), z);
                            this.iFx.setThreadData(this.iEG.cks());
                        }
                    }
                    this.iFx.Gr(postData.getId());
                    kVar.iFM.setSubPbAdapter(this.iFx);
                    kVar.iFM.setVisibility(0);
                    kVar.iFM.setData(postData, view);
                    kVar.iFM.setChildOnClickListener(this.akt);
                    kVar.iFM.setChildOnLongClickListener(this.mOnLongClickListener);
                    kVar.iFM.setChildOnTouchListener(this.iFy);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iFM.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    kVar.iFM.setLayoutParams(layoutParams2);
                    kVar.iFM.setVisibility(8);
                }
            }
            if (postData.khc) {
                kVar.mBottomLine.setVisibility(0);
            } else {
                kVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(k kVar, PostData postData) {
        if (kVar != null && kVar.iFY != null && kVar.iFV != null) {
            if (postData == null || postData.khg == null || StringUtils.isNull(postData.khg.liveTitle)) {
                kVar.iFV.setVisibility(8);
                return;
            }
            kVar.iFY.setText(postData.khg.liveTitle);
            kVar.iFV.setTag(postData.khg);
            kVar.iFV.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.iGd.setVisibility(postData.khm ? 0 : 8);
        }
    }

    private void a(k kVar) {
        LayerDrawable layerDrawable;
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fwA, R.color.cp_cont_b, 1);
                if (kVar.iFD.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFD, ((Integer) kVar.iFD.getTag()).intValue());
                } else if (kVar.iFD.getTag() instanceof String) {
                    if (kVar.iFD.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.Nu;
                    } else if (kVar.iFD.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.Nv;
                    } else {
                        layerDrawable = kVar.iFD.getTag().equals("HOST") ? this.iDn : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iFD.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFE, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFF, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFG, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFP, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFH, R.color.cp_cont_d, 1);
                kVar.iFK.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iFM, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFN, (int) R.color.cp_cont_c);
                kVar.iFN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFO, (int) R.color.cp_cont_c);
                kVar.iFM.onChangeSkinType();
                kVar.iFL.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFY, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iFW, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFV, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iFX, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iFZ, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iGc, (int) R.color.cp_cont_c);
                if (kVar.iGa.getVisibility() == 8) {
                    kVar.iGc.setText(R.string.close_content);
                } else if (this.iEG != null && StringUtils.isNull(this.iEG.ckA())) {
                    kVar.iGc.setText(this.iEG.ckA());
                } else {
                    kVar.iGc.setText(R.string.expand_content);
                }
                kVar.iFI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.iFC.setOnTouchListener(this.iFy);
        kVar.iFC.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iGe.cng() != null && this.iGe.cng().getPageContext() != null && this.iGe.cng().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.iGe.cng().iEi;
            kVar.fwA.setOnClickListener(aVar.gQU);
            kVar.iFJ.setOnClickListener(aVar.gQU);
            kVar.iFR.setOnClickListener(aVar.gQU);
            kVar.iFR.getHeadView().setOnClickListener(aVar.gQU);
            kVar.iFK.setOnLongClickListener(this.mOnLongClickListener);
            kVar.iFK.setOnTouchListener(this.iFy);
            kVar.iFK.setCommonTextViewOnClickListener(this.akt);
            kVar.iFK.setOnImageClickListener(this.dMw);
            kVar.iFK.setOnImageTouchListener(this.iFy);
            kVar.iFK.setOnEmotionClickListener(aVar.iSE);
            kVar.iFK.setOnVoiceAfterClickListener(this.akt);
            kVar.iFU.setOnClickListener(this.akt);
            kVar.iFV.setOnClickListener(this.akt);
            kVar.iFN.setOnClickListener(this.akt);
            kVar.iFO.setOnClickListener(this.akt);
        }
    }

    private void nw() {
        this.Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).tM("#4D000000").aHb()});
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).tM("#4D000000").aHb()});
        this.iDn = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(this.aqI).tM("#4D000000").aHb()});
    }

    public void a(TbRichTextView.c cVar) {
        this.iFw = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEG = eVar;
    }

    public void dI(String str) {
        this.aqV = str;
    }

    public void pw(boolean z) {
        this.iEH = z;
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iGe.cng(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.iFK.setTextViewOnTouchListener(this.dqJ);
        kVar.iFK.setTextViewCheckSelection(false);
    }

    public void P(View.OnClickListener onClickListener) {
        this.iEQ = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqJ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
