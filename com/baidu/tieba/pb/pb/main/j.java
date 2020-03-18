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
    private LayerDrawable Nv;
    private LayerDrawable Nw;
    private int YF;
    private View.OnClickListener akE;
    private int aqT;
    private int aqU;
    private String arg;
    private TbRichTextView.i dNb;
    private boolean dPJ;
    private com.baidu.tieba.pb.a.c drk;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> guc;
    private com.baidu.adp.lib.d.b<TbImageView> gud;
    private int iFb;
    private LayerDrawable iFc;
    private View.OnClickListener iGF;
    protected com.baidu.tieba.pb.data.e iGv;
    private boolean iGw;
    private int iHk;
    private TbRichTextView.c iHl;
    private com.baidu.tieba.pb.pb.sub.b iHm;
    private com.baidu.tieba.pb.a.c iHn;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(View view) {
        if (view != null && (view.getTag() instanceof k)) {
            k kVar = (k) view.getTag();
            if (kVar.iHx != null && kVar.iHx.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cNP = 5;
                dVar.cNR = 2;
                kVar.iHx.setStatisticData(dVar);
                kVar.iHx.aHx();
            }
        }
    }

    public j(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aqU = 0;
        this.iHk = 0;
        this.iFb = 0;
        this.aqT = 0;
        this.iHl = null;
        this.iGw = true;
        this.arg = null;
        this.iGv = null;
        this.iGF = null;
        this.akE = null;
        this.dNb = null;
        this.drk = null;
        this.mOnLongClickListener = null;
        this.iHm = null;
        this.dPJ = true;
        this.guc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGo */
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
        this.gud = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIl */
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
        this.iHn = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.j.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (j.this.iFL == null || j.this.iFL.cmP() == null || j.this.iFL.cmP().cpH())) {
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
                if (j.this.drk != null) {
                    if (!(view instanceof TbListTextView) || j.this.akE == null) {
                        j.this.drk.Q(view);
                        j.this.drk.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    j.this.akE.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.clX() != null) {
            this.YF = bVar.clX().coD();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.iHT.cnE().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.YF);
        kVar.iHA.setConstrainLayoutPool(this.guc);
        kVar.iHA.setImageViewPool(this.gud);
        a(kVar);
        this.aqU = getDimensionPixelSize(R.dimen.tbds10);
        this.iHk = getDimensionPixelSize(R.dimen.tbds14);
        this.iFb = getDimensionPixelSize(R.dimen.tbds40);
        this.aqT = getDimensionPixelSize(R.dimen.tbds6);
        if (kVar.iHz != null) {
            kVar.iHz.setDuiEnabled(this.dPJ);
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
            postData2.aDA();
            g(postData2);
            a(kVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.dPJ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.kjf) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.iGv, postData, postData.locate, i, 6);
            postData.kjg = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.cLs())) {
                Iterator<PostData> it = postData.cLs().iterator();
                while (it.hasNext()) {
                    it.next().kjg = b;
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
        if (kVar != null && kVar.iHr != null) {
            if (this.iHT != null && this.iHT.clX() != null && this.iHT.clX().coL() && com.baidu.tbadk.core.util.aq.equals(this.iHT.clX().cnT(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iHr, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iHr, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, boolean z, String str) {
        if (z) {
            kVar.iHP.setVisibility(8);
            if (StringUtils.isNull(str)) {
                kVar.iHR.setText(R.string.expand_content);
                return;
            } else {
                kVar.iHR.setText(str);
                return;
            }
        }
        kVar.iHP.setVisibility(0);
        kVar.iHR.setText(R.string.close_content);
    }

    private void c(final k kVar, final PostData postData) {
        if (postData.cLH() == 2 || postData.cLH() == 4) {
            kVar.iHQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = kVar.iHP.getVisibility() == 8;
                    j.this.a(kVar, !z, postData.ckX());
                    postData.sR(z ? false : true);
                    j.this.d(kVar, postData);
                    if (j.this.iFL != null && j.this.iFL.cmP() != null && j.this.iFL.cmP().cqJ() != null && j.this.iFL.cmP().getListView() != null && !z && kVar.getView().getTop() < j.this.iFL.cmP().cqJ().getMeasuredHeight()) {
                        j.this.iFL.cmP().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(j.this.iFL.cmP().getListView().getData(), postData) + j.this.iFL.cmP().getListView().getHeaderViewsCount(), j.this.iFL.cmP().cqJ().getMeasuredHeight());
                    }
                }
            });
            kVar.iHQ.setVisibility(0);
            a(kVar, postData.cLq(), postData.ckX());
            a(true, kVar, postData);
        } else {
            kVar.iHQ.setVisibility(8);
            kVar.iHP.setVisibility(0);
            a(false, kVar, postData);
        }
        d(kVar, postData);
    }

    private void a(boolean z, k kVar, PostData postData) {
        if (kVar != null && kVar.mBottomLine != null && kVar.iHQ != null && (kVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (kVar.iHQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cLs());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) kVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) kVar.iHQ.getLayoutParams();
            if (z) {
                kVar.iHz.getLayoutStrategy().ns(0);
                if (z2) {
                    kVar.iHz.getLayoutStrategy().nr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    kVar.iHz.getLayoutStrategy().nr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                kVar.iHQ.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    kVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            kVar.iHz.getLayoutStrategy().nr(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            kVar.iHz.getLayoutStrategy().ns(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                kVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, PostData postData) {
        TbRichText cLx = postData.cLx();
        cLx.isChanged = true;
        kVar.iHz.setText(cLx, true, this.iHl);
    }

    private void h(PostData postData) {
        if (postData.cSY == 0 && postData.gwy) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cx("post_id", postData.getId());
            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cx("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cx("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cx("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.iHT != null) {
                int coD = this.iHT.clX().coD();
                if (1 == coD || 2 == coD) {
                    anVar.cx("obj_source", "1");
                } else if (3 == coD) {
                    anVar.cx("obj_source", "2");
                } else {
                    anVar.cx("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.iGv != null) {
            if (this.iGv.aHP()) {
                if (this.iHU != null) {
                    com.baidu.tieba.pb.c.a.a(this.iHU.getUniqueId(), this.iGv, postData, postData.locate, postData.kjf ? 2 : 8);
                }
            } else if (this.iFL != null) {
                com.baidu.tieba.pb.c.a.a(this.iFL.getUniqueId(), this.iGv, postData, postData.locate, postData.kjf ? 2 : 8);
            }
        }
    }

    private void a(k kVar, PostData postData) {
        if (postData == null || postData.csv() == null) {
            kVar.iHJ.setVisibility(8);
            return;
        }
        TbRichText cLx = postData.cLx();
        com.baidu.tieba.pb.view.b.a(postData.csv(), kVar.iHJ, false, false, cLx != null && StringUtils.isNull(cLx.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(k kVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iGw) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iHz.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            kVar.iHz.setLayoutParams(layoutParams);
            kVar.iHz.setPadding(0, 0, 0, 0);
            kVar.iHz.wi(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iHz.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            kVar.iHz.setLayoutParams(layoutParams2);
            kVar.iHz.wi(postData.getBimg_url());
        }
        kVar.iHz.setTextViewOnTouchListener(this.iHn);
        kVar.iHz.setTextViewCheckSelection(false);
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
            if (postData.aCr() == null || postData.aCr().isBaijiahaoUser()) {
            }
            if (postData.kiV) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.mTopLine, R.color.cp_bg_line_c);
                kVar.mTopLine.setVisibility(0);
            } else {
                kVar.mTopLine.setVisibility(8);
            }
            kVar.iHy.setTag(null);
            kVar.iHy.setUserId(null);
            kVar.fxu.setText((CharSequence) null);
            kVar.iHG.getHeadView().setUserId(null);
            kVar.iHz.setIsHost(false);
            if (postData.aCr() != null) {
                if (this.arg != null && !this.arg.equals("0") && this.arg.equals(postData.aCr().getUserId())) {
                    kVar.iHz.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aCr().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aCr().getTShowInfoNew();
                if (kVar.iHI != null) {
                    kVar.iHI.setTag(R.id.tag_user_id, postData.aCr().getUserId());
                    if (this.iHT != null && this.iHT.cnE() != null) {
                        kVar.iHI.setOnClickListener(this.iHT.cnE().iFX.iUr);
                    }
                    kVar.iHI.a(iconInfo, 2, this.iFb, this.iFb, this.aqU);
                }
                if (kVar.iHH != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        kVar.iHH.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.iHT != null && this.iHT.cnE() != null) {
                        kVar.iHH.setOnClickListener(this.iHT.cnE().iFX.iUs);
                    }
                    kVar.iHH.a(tShowInfoNew, 3, this.iFb, this.iFb, this.aqU, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aCr().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fxu, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fxu, R.color.cp_cont_b, 1);
                }
                String avater = postData.aCr().getAvater();
                int i2 = 8;
                if (postData.kjf) {
                    i2 = 2;
                }
                kVar.fxu.setTag(R.id.tag_user_id, postData.aCr().getUserId());
                kVar.fxu.setTag(R.id.tag_user_name, postData.aCr().getUserName());
                kVar.fxu.setTag(R.id.tag_virtual_user_url, postData.aCr().getVirtualUserUrl());
                kVar.fxu.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iGv, postData, postData.locate, i2, 2));
                String name_show = postData.aCr().getName_show();
                String userName = postData.aCr().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    kVar.fxu.setText(com.baidu.tieba.pb.c.ba(this.mContext, kVar.fxu.getText().toString()));
                    kVar.fxu.setGravity(16);
                    kVar.fxu.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cky());
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fxu, R.color.cp_other_f, 1);
                }
                if (postData.aCr().getPendantData() != null && !StringUtils.isNull(postData.aCr().getPendantData().aAJ())) {
                    kVar.iHG.b(postData.aCr());
                    kVar.iHy.setVisibility(8);
                    kVar.iHG.setVisibility(0);
                    kVar.iHG.getHeadView().startLoad(avater, 28, false);
                    kVar.iHG.getHeadView().setUserId(postData.aCr().getUserId());
                    kVar.iHG.getHeadView().setUserName(postData.aCr().getUserName());
                    kVar.iHG.getHeadView().setFid(this.iGv != null ? this.iGv.getForumId() : "");
                    kVar.iHG.getHeadView().setTid(postData.getId());
                    kVar.iHG.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iGv, postData, postData.locate, i2, 2));
                    kVar.iHG.tS(postData.aCr().getPendantData().aAJ());
                } else {
                    UtilHelper.showHeadImageViewBigV(kVar.iHy, postData.aCr(), 0);
                    kVar.iHy.setUserId(postData.aCr().getUserId());
                    kVar.iHy.setFid(this.iGv != null ? this.iGv.getForumId() : "");
                    kVar.iHy.setTid(postData.getId());
                    kVar.iHy.setUserName(postData.aCr().getUserName(), postData.cLF());
                    kVar.iHy.setTag(R.id.tag_virtual_user_url, postData.aCr().getVirtualUserUrl());
                    kVar.iHy.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.iGv, postData, postData.locate, i2, 2));
                    kVar.iHy.setImageDrawable(null);
                    kVar.iHy.startLoad(avater, 28, false);
                    kVar.iHy.setVisibility(0);
                    kVar.iHG.setVisibility(8);
                }
                if (this.iGv != null && this.iGv.cln()) {
                    kVar.iHs.setVisibility(8);
                    kVar.iHs.setTag(null);
                } else if (postData.aCr() != null) {
                    MetaData aCr = postData.aCr();
                    com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHs, (int) R.color.cp_cont_a);
                    if (this.arg != null && !this.arg.equals("0") && this.arg.equals(aCr.getUserId())) {
                        kVar.iHs.setTag("HOST");
                        if (kVar.mSkinType == 1) {
                            if (this.iFc.getDrawable(1) != null) {
                                this.iFc.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.iFc.getDrawable(1) != null) {
                            this.iFc.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(this.iFc);
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.host_name);
                    } else if (aCr.getIs_bawu() == 1 && postData.cLn()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iHs, R.drawable.brand_official_btn);
                        kVar.iHs.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.brand_Official);
                    } else if (aCr.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCr.getBawu_type())) {
                        kVar.iHs.setTag("BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(this.Nv);
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aCr.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCr.getBawu_type())) {
                        kVar.iHs.setTag("XIAO_BA_ZHU_BG");
                        if (kVar.mSkinType == 1) {
                            if (this.Nw.getDrawable(1) != null) {
                                this.Nw.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nw.getDrawable(1) != null) {
                            this.Nw.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(this.Nw);
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aCr.getIs_bawu() == 1 && "pri_content_assist".equals(aCr.getBawu_type())) {
                        int ku = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iHs, ku);
                        kVar.iHs.setTag(Integer.valueOf(ku));
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_content_assist_tip);
                    } else if (aCr.getIs_bawu() == 1 && "pri_manage_assist".equals(aCr.getBawu_type())) {
                        int ku2 = com.baidu.tbadk.core.util.am.ku(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iHs, ku2);
                        kVar.iHs.setTag(Integer.valueOf(ku2));
                        kVar.iHs.setVisibility(0);
                        kVar.iHs.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        kVar.iHs.setVisibility(8);
                        kVar.iHs.setTag(null);
                    }
                } else {
                    kVar.iHs.setVisibility(8);
                    kVar.iHs.setTag(null);
                }
            }
            int i3 = 0;
            if (this.iHT != null && this.iHT.cnE() != null && this.iHT.cnE().clN() && postData.aCr() != null) {
                i3 = postData.aCr().getLevel_id();
            }
            if (this.iGv != null && this.iGv.cln()) {
                i3 = 0;
            }
            if (i3 > 0) {
                kVar.iHF.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iHF, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                kVar.iHF.setVisibility(8);
            }
            int i4 = 15;
            if (kVar.iHI.getChildCount() == 1) {
                i4 = 13;
            } else if (kVar.iHI.getChildCount() > 1) {
                i4 = 11;
            }
            if (kVar.iHs.getVisibility() == 0) {
                i4 -= 2;
            }
            if (kVar.iHH.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aDM() > 1000) {
                i4 -= 2;
            }
            if (postData.aDM() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                kVar.iHI.setVisibility(8);
                if (kVar.iHI.getChildCount() == 1) {
                    i4 += 2;
                } else if (kVar.iHI.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && kVar.iHs.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iHs.setVisibility(8);
                }
                if (i4 < 10 && kVar.iHF.getVisibility() == 0) {
                    i4 += 2;
                    kVar.iHF.setVisibility(8);
                }
            }
            String name_show2 = postData.aCr() != null ? postData.aCr().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.aCr() != null && !StringUtils.isNull(postData.aCr().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aCr() != null && !StringUtils.isNull(postData.aCr().getSealPrefix())) {
                kVar.fxu.setText(cA(postData.aCr().getSealPrefix(), name_show2));
            } else {
                kVar.fxu.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cLv()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aCr() != null && !StringUtils.isNull(postData.aCr().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.iGv != null && this.iGv.clb() != 0) {
                if (this.iGv.clb() != 1002 && this.iGv.clb() != 3) {
                    z10 = true;
                }
                if (this.iGv.clb() != 3 && !this.iGv.cln()) {
                    z11 = true;
                }
                if (postData != null && postData.aCr() != null) {
                    String userId2 = postData.aCr().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckP().aCr() != null && postData.aCr() != null) {
                            userId = this.iGv.ckP().aCr().getUserId();
                            String userId3 = postData.aCr().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aCr() != null && UtilHelper.isCurrentAccount(postData.aCr().getUserId())) {
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
                                if (postData.cLv() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iGv.clb()));
                                    if (postData.aCr() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aCr().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCr().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCr().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aCr() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCr().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCr().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCr().getName_show());
                                    }
                                    if (this.iGv.ckP() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.iGv.ckP().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iGv.clb()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                kVar.iHz.setTag(sparseArray);
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
                        if (postData.cLv() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        kVar.iHz.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.iGv != null) {
                userId = this.iGv.ckP().aCr().getUserId();
                String userId32 = postData.aCr().getUserId();
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
            if (postData.cLv() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            kVar.iHz.setTag(sparseArray);
        }
    }

    private void f(k kVar, PostData postData) {
        if (kVar != null && postData != null && postData.aEe() != null) {
            postData.aEe().threadId = this.iHT.clX().cnU();
            postData.aEe().objType = 1;
            postData.aEe().isInPost = true;
            bj bjVar = null;
            if (this.iGv != null && this.iGv.ckP() != null) {
                bjVar = this.iGv.ckP();
            }
            if (bjVar != null && bjVar.aEm()) {
                kVar.iHx.setAgreeAlone(true);
            }
            kVar.iHx.setData(postData.aEe());
        }
    }

    private void g(k kVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (kVar != null && postData != null) {
            if (postData.cLv() > 0 && this.iGv != null && !this.iGv.cln()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cLv()));
                kVar.iHE.setVisibility(0);
                kVar.iHE.setText(format);
                z = true;
            } else {
                kVar.iHE.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cLy = postData.cLy();
            boolean z2 = (cLy == null || StringUtils.isNull(cLy.getName()) || this.iGv == null || this.iGv.cln()) ? false : true;
            if (z) {
                kVar.iHu.setVisibility(0);
                i = this.iHk;
            } else {
                kVar.iHu.setVisibility(8);
                i = 0;
            }
            if (z2) {
                kVar.iHv.setVisibility(0);
                i2 = this.iHk;
            } else {
                kVar.iHv.setVisibility(8);
                i2 = 0;
            }
            kVar.iHt.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                kVar.iHt.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                kVar.iHt.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                kVar.iHw.setVisibility(0);
                kVar.iHw.setPadding(this.iHk, 0, 0, 0);
                if (postData.kjd) {
                    kVar.iHw.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cLy.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    kVar.iHw.setText(cLy.getName());
                    return;
                }
            }
            kVar.iHw.setVisibility(8);
        }
    }

    private void a(k kVar, PostData postData, View view) {
        if (kVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iHz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            kVar.iHz.setPadding(0, 0, 0, 0);
            if (!this.iGw) {
                kVar.iHz.getLayoutStrategy().nm(R.drawable.icon_click);
            } else {
                kVar.iHz.wi(null);
                kVar.iHz.setBackgroundDrawable(null);
                kVar.iHz.getLayoutStrategy().nm(R.drawable.transparent_bg);
            }
            kVar.iHz.getLayoutStrategy().nj(R.drawable.pic_video);
            a(kVar.iHz, view, !StringUtils.isNull(postData.getBimg_url()));
            kVar.iHz.setLayoutParams(layoutParams);
            kVar.iHz.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            kVar.iHz.setIsFromCDN(this.mIsFromCDN);
            TbRichText cLx = postData.cLx();
            kVar.iHz.setIsUseGridImage(postData.cLI());
            kVar.iHz.setText(cLx, true, this.iHl);
            SparseArray sparseArray = (SparseArray) kVar.iHz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            kVar.iHz.setTag(sparseArray);
            kVar.iHr.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().nk(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().dOD = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().nl((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            if (postData.cLz() > 0) {
                kVar.iHD.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) kVar.iHD.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    kVar.iHD.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cLH() == 2) {
                    kVar.iHD.setVisibility(8);
                } else {
                    kVar.iHD.setVisibility(0);
                }
                kVar.iHC.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cLz() > 0) {
                    kVar.iHC.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cLz())));
                    SparseArray sparseArray2 = (SparseArray) kVar.iHC.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        kVar.iHC.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    kVar.iHC.setVisibility(0);
                    kVar.iHD.setVisibility(8);
                    kVar.iHB.setVisibility(8);
                }
            } else {
                kVar.iHC.setVisibility(8);
                if (postData.cLz() > 0 && postData.cLs() != null && postData.cLs().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.iHB.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    kVar.iHB.setLayoutParams(layoutParams);
                    if (this.iHm == null) {
                        this.iHm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.iHm.setIsFromCDN(this.mIsFromCDN);
                        this.iHm.setOnLongClickListener(this.mOnLongClickListener);
                        this.iHm.S(this.iGF);
                        this.iHm.y(this.akE);
                        String str = null;
                        if (this.iGv != null && this.iGv.ckP() != null && this.iGv.ckP().aCr() != null) {
                            str = this.iGv.ckP().aCr().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.iGv != null) {
                            this.iHm.O(this.iGv.clb(), z);
                            this.iHm.setThreadData(this.iGv.ckP());
                        }
                    }
                    this.iHm.Gr(postData.getId());
                    kVar.iHB.setSubPbAdapter(this.iHm);
                    kVar.iHB.setVisibility(0);
                    kVar.iHB.setData(postData, view);
                    kVar.iHB.setChildOnClickListener(this.akE);
                    kVar.iHB.setChildOnLongClickListener(this.mOnLongClickListener);
                    kVar.iHB.setChildOnTouchListener(this.iHn);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) kVar.iHB.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    kVar.iHB.setLayoutParams(layoutParams2);
                    kVar.iHB.setVisibility(8);
                }
            }
            if (postData.kiT) {
                kVar.mBottomLine.setVisibility(0);
            } else {
                kVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(k kVar, PostData postData) {
        if (kVar != null && kVar.iHN != null && kVar.iHK != null) {
            if (postData == null || postData.kiX == null || StringUtils.isNull(postData.kiX.liveTitle)) {
                kVar.iHK.setVisibility(8);
                return;
            }
            kVar.iHN.setText(postData.kiX.liveTitle);
            kVar.iHK.setTag(postData.kiX);
            kVar.iHK.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.iHS.setVisibility(postData.kjd ? 0 : 8);
        }
    }

    private void a(k kVar) {
        LayerDrawable layerDrawable;
        if (kVar != null) {
            if (kVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.fxu, R.color.cp_cont_b, 1);
                if (kVar.iHs.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iHs, ((Integer) kVar.iHs.getTag()).intValue());
                } else if (kVar.iHs.getTag() instanceof String) {
                    if (kVar.iHs.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.Nv;
                    } else if (kVar.iHs.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.Nw;
                    } else {
                        layerDrawable = kVar.iHs.getTag().equals("HOST") ? this.iFc : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (kVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        kVar.iHs.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHt, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHu, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHv, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHE, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHw, R.color.cp_cont_d, 1);
                kVar.iHz.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(kVar.iHB, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHC, (int) R.color.cp_cont_c);
                kVar.iHC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHD, (int) R.color.cp_cont_c);
                kVar.iHB.onChangeSkinType();
                kVar.iHA.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHN, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHL, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iHK, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(kVar.iHM, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(kVar.iHO, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(kVar.iHR, (int) R.color.cp_cont_c);
                if (kVar.iHP.getVisibility() == 8) {
                    kVar.iHR.setText(R.string.close_content);
                } else if (this.iGv != null && StringUtils.isNull(this.iGv.ckX())) {
                    kVar.iHR.setText(this.iGv.ckX());
                } else {
                    kVar.iHR.setText(R.string.expand_content);
                }
                kVar.iHx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            kVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(k kVar) {
        kVar.iHr.setOnTouchListener(this.iHn);
        kVar.iHr.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iHT.cnE() != null && this.iHT.cnE().getPageContext() != null && this.iHT.cnE().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.iHT.cnE().iFX;
            kVar.fxu.setOnClickListener(aVar.gSp);
            kVar.iHy.setOnClickListener(aVar.gSp);
            kVar.iHG.setOnClickListener(aVar.gSp);
            kVar.iHG.getHeadView().setOnClickListener(aVar.gSp);
            kVar.iHz.setOnLongClickListener(this.mOnLongClickListener);
            kVar.iHz.setOnTouchListener(this.iHn);
            kVar.iHz.setCommonTextViewOnClickListener(this.akE);
            kVar.iHz.setOnImageClickListener(this.dNb);
            kVar.iHz.setOnImageTouchListener(this.iHn);
            kVar.iHz.setOnEmotionClickListener(aVar.iUt);
            kVar.iHz.setOnVoiceAfterClickListener(this.akE);
            kVar.iHJ.setOnClickListener(this.akE);
            kVar.iHK.setOnClickListener(this.akE);
            kVar.iHC.setOnClickListener(this.akE);
            kVar.iHD.setOnClickListener(this.akE);
        }
    }

    private void nw() {
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).tM("#4D000000").aHi()});
        this.Nw = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).tM("#4D000000").aHi()});
        this.iFc = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aHi(), com.baidu.tbadk.core.util.e.a.b.aHg().kB(0).af(this.aqT).tM("#4D000000").aHi()});
    }

    public void a(TbRichTextView.c cVar) {
        this.iHl = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iGv = eVar;
    }

    public void dH(String str) {
        this.arg = str;
    }

    public void pC(boolean z) {
        this.iGw = z;
    }

    private SpannableStringBuilder cA(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iHT.cnE(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(k kVar) {
        kVar.iHz.setTextViewOnTouchListener(this.drk);
        kVar.iHz.setTextViewCheckSelection(false);
    }

    public void P(View.OnClickListener onClickListener) {
        this.iGF = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dNb = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.drk = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
