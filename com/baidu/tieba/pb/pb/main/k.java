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
/* loaded from: classes6.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private LayerDrawable MR;
    private LayerDrawable MS;
    private int Wq;
    private View.OnClickListener ahD;
    private int amD;
    private int amE;
    private String amQ;
    private TbRichTextView.i dIi;
    private boolean dKS;
    private com.baidu.tieba.pb.a.c dmm;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gnZ;
    private com.baidu.adp.lib.d.b<TbImageView> goa;
    private int iAn;
    private TbRichTextView.c iAo;
    private com.baidu.tieba.pb.pb.sub.b iAp;
    private com.baidu.tieba.pb.a.c iAq;
    private int ixP;
    private LayerDrawable ixQ;
    private View.OnClickListener izF;
    protected com.baidu.tieba.pb.data.f izv;
    private boolean izw;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void co(View view) {
        if (view != null && (view.getTag() instanceof l)) {
            l lVar = (l) view.getTag();
            if (lVar.iAA != null && lVar.iAA.getData() != null) {
                com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
                dVar.cJm = 5;
                dVar.cJo = 2;
                lVar.iAA.setStatisticData(dVar);
                lVar.iAA.aEL();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.amE = 0;
        this.iAn = 0;
        this.ixP = 0;
        this.amD = 0;
        this.iAo = null;
        this.izw = true;
        this.amQ = null;
        this.izv = null;
        this.izF = null;
        this.ahD = null;
        this.dIi = null;
        this.dmm = null;
        this.mOnLongClickListener = null;
        this.iAp = null;
        this.dKS = true;
        this.gnZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bDw */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(k.this.mContext);
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
        this.goa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aFw */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
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
        this.iAq = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.iyA == null || k.this.iyA.cjP() == null || k.this.iyA.cjP().cmL())) {
                    if (view instanceof RelativeLayout) {
                        k.this.co(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                k.this.co((RelativeLayout) parent);
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
                if (k.this.dmm != null) {
                    if (!(view instanceof TbListTextView) || k.this.ahD == null) {
                        k.this.dmm.O(view);
                        k.this.dmm.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.ahD.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.ciU() != null) {
            this.Wq = bVar.ciU().clG();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.iAW.ckE().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.Wq);
        lVar.iAD.setConstrainLayoutPool(this.gnZ);
        lVar.iAD.setImageViewPool(this.goa);
        a(lVar);
        this.amE = getDimensionPixelSize(R.dimen.tbds10);
        this.iAn = getDimensionPixelSize(R.dimen.tbds14);
        this.ixP = getDimensionPixelSize(R.dimen.tbds40);
        this.amD = getDimensionPixelSize(R.dimen.tbds6);
        if (lVar.iAC != null) {
            lVar.iAC.setDuiEnabled(this.dKS);
        }
        ne();
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) lVar);
        a(lVar);
        b(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            h(postData2);
            i(postData2);
            postData2.aAO();
            g(postData2);
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.dKS = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g(PostData postData) {
        if (postData != null && !com.baidu.tbadk.core.util.v.isEmpty(postData.cIq())) {
            int i = 8;
            if (postData.kcF) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.izv, postData, postData.locate, i, 6);
            postData.kcG = b;
            Iterator<PostData> it = postData.cIq().iterator();
            while (it.hasNext()) {
                it.next().kcG = b;
            }
        }
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            b(lVar, postData, view, i);
            f(lVar, postData);
            a(lVar, postData, view);
            c(lVar, postData, view, i);
            g(lVar, postData);
            a(lVar, postData);
            h(lVar, postData);
            c(lVar, postData);
            e(lVar, postData);
            i(lVar, postData);
            b(lVar, postData);
        }
    }

    private void b(l lVar, PostData postData) {
        if (lVar != null && lVar.iAu != null) {
            if (this.iAW != null && this.iAW.ciU() != null && this.iAW.ciU().clO() && com.baidu.tbadk.core.util.aq.equals(this.iAW.ciU().ckT(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.iAu, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.iAu, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, boolean z, String str) {
        if (z) {
            lVar.iAS.setVisibility(8);
            if (StringUtils.isNull(str)) {
                lVar.iAU.setText(R.string.expand_content);
                return;
            } else {
                lVar.iAU.setText(str);
                return;
            }
        }
        lVar.iAS.setVisibility(0);
        lVar.iAU.setText(R.string.close_content);
    }

    private void c(final l lVar, final PostData postData) {
        if (postData.cIF() == 2 || postData.cIF() == 4) {
            lVar.iAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.iAS.getVisibility() == 8;
                    k.this.a(lVar, !z, postData.chS());
                    postData.sv(z ? false : true);
                    k.this.d(lVar, postData);
                    if (k.this.iyA != null && k.this.iyA.cjP() != null && k.this.iyA.cjP().cnM() != null && k.this.iyA.cjP().getListView() != null && !z && lVar.getView().getTop() < k.this.iyA.cjP().cnM().getMeasuredHeight()) {
                        k.this.iyA.cjP().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(k.this.iyA.cjP().getListView().getData(), postData) + k.this.iyA.cjP().getListView().getHeaderViewsCount(), k.this.iyA.cjP().cnM().getMeasuredHeight());
                    }
                }
            });
            lVar.iAT.setVisibility(0);
            a(lVar, postData.cIo(), postData.chS());
            a(true, lVar, postData);
        } else {
            lVar.iAT.setVisibility(8);
            lVar.iAS.setVisibility(0);
            a(false, lVar, postData);
        }
        d(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        if (lVar != null && lVar.mBottomLine != null && lVar.iAT != null && (lVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (lVar.iAT.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.cIq());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) lVar.iAT.getLayoutParams();
            if (z) {
                lVar.iAC.getLayoutStrategy().mZ(0);
                if (z2) {
                    lVar.iAC.getLayoutStrategy().mY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    lVar.iAC.getLayoutStrategy().mY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                lVar.iAT.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    lVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            lVar.iAC.getLayoutStrategy().mY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            lVar.iAC.getLayoutStrategy().mZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                lVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(l lVar, PostData postData) {
        TbRichText cIv = postData.cIv();
        cIv.isChanged = true;
        lVar.iAC.setText(cIv, true, this.iAo);
    }

    private void h(PostData postData) {
        if (postData.cOx == 0 && postData.gqt) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.cp("post_id", postData.getId());
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.cp("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.cp("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.iAW != null) {
                int clG = this.iAW.ciU().clG();
                if (1 == clG || 2 == clG) {
                    anVar.cp("obj_source", "1");
                } else if (3 == clG) {
                    anVar.cp("obj_source", "2");
                } else {
                    anVar.cp("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(PostData postData) {
        if (this.iyA != null) {
            com.baidu.tieba.pb.c.a.a(this.iyA.getUniqueId(), this.izv, postData, postData.locate, postData.kcF ? 2 : 8);
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.cpy() == null) {
            lVar.iAM.setVisibility(8);
            return;
        }
        TbRichText cIv = postData.cIv();
        com.baidu.tieba.pb.view.b.a(postData.cpy(), lVar.iAM, false, false, cIv != null && StringUtils.isNull(cIv.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.izw) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iAC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.iAC.setLayoutParams(layoutParams);
            lVar.iAC.setPadding(0, 0, 0, 0);
            lVar.iAC.vJ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.iAC.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.iAC.setLayoutParams(layoutParams2);
            lVar.iAC.vJ(postData.getBimg_url());
        }
        lVar.iAC.setTextViewOnTouchListener(this.iAq);
        lVar.iAC.setTextViewCheckSelection(false);
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
    private void b(l lVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (lVar != null && postData != null) {
            if (postData.azE() == null || postData.azE().getBaijiahaoInfo() != null) {
            }
            if (postData.kcv) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            lVar.iAB.setTag(null);
            lVar.iAB.setUserId(null);
            lVar.fqP.setText((CharSequence) null);
            lVar.iAJ.getHeadView().setUserId(null);
            lVar.iAC.setIsHost(false);
            if (postData.azE() != null) {
                if (this.amQ != null && !this.amQ.equals("0") && this.amQ.equals(postData.azE().getUserId())) {
                    lVar.iAC.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.azE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.azE().getTShowInfoNew();
                if (lVar.iAL != null) {
                    lVar.iAL.setTag(R.id.tag_user_id, postData.azE().getUserId());
                    if (this.iAW != null && this.iAW.ckE() != null) {
                        lVar.iAL.setOnClickListener(this.iAW.ckE().iyV.iND);
                    }
                    lVar.iAL.a(iconInfo, 2, this.ixP, this.ixP, this.amE);
                }
                if (lVar.iAK != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.iAK.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.iAW != null && this.iAW.ckE() != null) {
                        lVar.iAK.setOnClickListener(this.iAW.ckE().iyV.iNE);
                    }
                    lVar.iAK.a(tShowInfoNew, 3, this.ixP, this.ixP, this.amE, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.azE().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.fqP, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.fqP, R.color.cp_cont_b, 1);
                }
                String avater = postData.azE().getAvater();
                int i2 = 8;
                if (postData.kcF) {
                    i2 = 2;
                }
                lVar.fqP.setTag(R.id.tag_user_id, postData.azE().getUserId());
                lVar.fqP.setTag(R.id.tag_user_name, postData.azE().getUserName());
                lVar.fqP.setTag(R.id.tag_virtual_user_url, postData.azE().getVirtualUserUrl());
                lVar.fqP.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.izv, postData, postData.locate, i2, 2));
                String name_show = postData.azE().getName_show();
                String userName = postData.azE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.fqP.setText(com.baidu.tieba.pb.d.aZ(this.mContext, lVar.fqP.getText().toString()));
                    lVar.fqP.setGravity(16);
                    lVar.fqP.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.chp());
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.fqP, R.color.cp_other_f, 1);
                }
                if (postData.azE().getPendantData() != null && !StringUtils.isNull(postData.azE().getPendantData().axX())) {
                    lVar.iAJ.b(postData.azE());
                    lVar.iAB.setVisibility(8);
                    lVar.iAJ.setVisibility(0);
                    lVar.iAJ.getHeadView().startLoad(avater, 28, false);
                    lVar.iAJ.getHeadView().setUserId(postData.azE().getUserId());
                    lVar.iAJ.getHeadView().setUserName(postData.azE().getUserName());
                    lVar.iAJ.getHeadView().setFid(this.izv != null ? this.izv.getForumId() : "");
                    lVar.iAJ.getHeadView().setTid(postData.getId());
                    lVar.iAJ.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.izv, postData, postData.locate, i2, 2));
                    lVar.iAJ.ty(postData.azE().getPendantData().axX());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.iAB, postData.azE(), 0);
                    lVar.iAB.setUserId(postData.azE().getUserId());
                    lVar.iAB.setFid(this.izv != null ? this.izv.getForumId() : "");
                    lVar.iAB.setTid(postData.getId());
                    lVar.iAB.setUserName(postData.azE().getUserName(), postData.cID());
                    lVar.iAB.setTag(R.id.tag_virtual_user_url, postData.azE().getVirtualUserUrl());
                    lVar.iAB.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.izv, postData, postData.locate, i2, 2));
                    lVar.iAB.setImageDrawable(null);
                    lVar.iAB.startLoad(avater, 28, false);
                    lVar.iAB.setVisibility(0);
                    lVar.iAJ.setVisibility(8);
                }
                if (this.izv != null && this.izv.cik()) {
                    lVar.iAv.setVisibility(8);
                    lVar.iAv.setTag(null);
                } else if (postData.azE() != null) {
                    MetaData azE = postData.azE();
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAv, (int) R.color.cp_cont_a);
                    if (this.amQ != null && !this.amQ.equals("0") && this.amQ.equals(azE.getUserId())) {
                        lVar.iAv.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (this.ixQ.getDrawable(1) != null) {
                                this.ixQ.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ixQ.getDrawable(1) != null) {
                            this.ixQ.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(this.ixQ);
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.host_name);
                    } else if (azE.getIs_bawu() == 1 && postData.cIl()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iAv, R.drawable.brand_official_btn);
                        lVar.iAv.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.brand_Official);
                    } else if (azE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(azE.getBawu_type())) {
                        lVar.iAv.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.MR.getDrawable(1) != null) {
                                this.MR.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MR.getDrawable(1) != null) {
                            this.MR.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(this.MR);
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_member_bazhu_tip);
                    } else if (azE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(azE.getBawu_type())) {
                        lVar.iAv.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.MS.getDrawable(1) != null) {
                                this.MS.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MS.getDrawable(1) != null) {
                            this.MS.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(this.MS);
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (azE.getIs_bawu() == 1 && "pri_content_assist".equals(azE.getBawu_type())) {
                        int kd = com.baidu.tbadk.core.util.am.kd(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iAv, kd);
                        lVar.iAv.setTag(Integer.valueOf(kd));
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_content_assist_tip);
                    } else if (azE.getIs_bawu() == 1 && "pri_manage_assist".equals(azE.getBawu_type())) {
                        int kd2 = com.baidu.tbadk.core.util.am.kd(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iAv, kd2);
                        lVar.iAv.setTag(Integer.valueOf(kd2));
                        lVar.iAv.setVisibility(0);
                        lVar.iAv.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.iAv.setVisibility(8);
                        lVar.iAv.setTag(null);
                    }
                } else {
                    lVar.iAv.setVisibility(8);
                    lVar.iAv.setTag(null);
                }
            }
            int i3 = 0;
            if (this.iAW != null && this.iAW.ckE() != null && this.iAW.ckE().ciJ() && postData.azE() != null) {
                i3 = postData.azE().getLevel_id();
            }
            if (this.izv != null && this.izv.cik()) {
                i3 = 0;
            }
            if (i3 > 0) {
                lVar.iAI.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.iAI, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                lVar.iAI.setVisibility(8);
            }
            int i4 = 15;
            if (lVar.iAL.getChildCount() == 1) {
                i4 = 13;
            } else if (lVar.iAL.getChildCount() > 1) {
                i4 = 11;
            }
            if (lVar.iAv.getVisibility() == 0) {
                i4 -= 2;
            }
            if (lVar.iAK.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aBa() > 1000) {
                i4 -= 2;
            }
            if (postData.aBa() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                lVar.iAL.setVisibility(8);
                if (lVar.iAL.getChildCount() == 1) {
                    i4 += 2;
                } else if (lVar.iAL.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && lVar.iAv.getVisibility() == 0) {
                    i4 += 2;
                    lVar.iAv.setVisibility(8);
                }
                if (i4 < 10 && lVar.iAI.getVisibility() == 0) {
                    i4 += 2;
                    lVar.iAI.setVisibility(8);
                }
            }
            String name_show2 = postData.azE() != null ? postData.azE().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.azE() != null && !StringUtils.isNull(postData.azE().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.azE() != null && !StringUtils.isNull(postData.azE().getSealPrefix())) {
                lVar.fqP.setText(cs(postData.azE().getSealPrefix(), name_show2));
            } else {
                lVar.fqP.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.cIt()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.azE() != null && !StringUtils.isNull(postData.azE().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.izv != null && this.izv.chW() != 0) {
                if (this.izv.chW() != 1002 && this.izv.chW() != 3) {
                    z10 = true;
                }
                if (this.izv.chW() != 3 && !this.izv.cik()) {
                    z11 = true;
                }
                if (postData != null && postData.azE() != null) {
                    String userId2 = postData.azE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.izv != null && this.izv.chK() != null && this.izv.chK().azE() != null && postData.azE() != null) {
                            userId = this.izv.chK().azE().getUserId();
                            String userId3 = postData.azE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.azE() != null && UtilHelper.isCurrentAccount(postData.azE().getUserId())) {
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
                                if (postData.cIt() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.izv.chW()));
                                    if (postData.azE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.azE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.azE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.azE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.azE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.azE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azE().getName_show());
                                    }
                                    if (this.izv.chK() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.izv.chK().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.izv.chW()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.iAC.setTag(sparseArray);
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
                        if (postData.cIt() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        lVar.iAC.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.izv != null) {
                userId = this.izv.chK().azE().getUserId();
                String userId32 = postData.azE().getUserId();
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
            if (postData.cIt() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            lVar.iAC.setTag(sparseArray);
        }
    }

    private void f(l lVar, PostData postData) {
        if (lVar != null && postData != null && postData.aBt() != null) {
            postData.aBt().threadId = this.iAW.ciU().ckU();
            postData.aBt().objType = 1;
            postData.aBt().isInPost = true;
            bj bjVar = null;
            if (this.izv != null && this.izv.chK() != null) {
                bjVar = this.izv.chK();
            }
            if (bjVar != null && bjVar.aBC()) {
                lVar.iAA.setAgreeAlone(true);
            }
            lVar.iAA.setData(postData.aBt());
        }
    }

    private void g(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.cIt() > 0 && this.izv != null && !this.izv.cik()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.cIt()));
                lVar.iAH.setVisibility(0);
                lVar.iAH.setText(format);
                z = true;
            } else {
                lVar.iAH.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f cIw = postData.cIw();
            boolean z2 = (cIw == null || StringUtils.isNull(cIw.getName()) || this.izv == null || this.izv.cik()) ? false : true;
            if (z) {
                lVar.iAx.setVisibility(0);
                i = this.iAn;
            } else {
                lVar.iAx.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.iAy.setVisibility(0);
                i2 = this.iAn;
            } else {
                lVar.iAy.setVisibility(8);
                i2 = 0;
            }
            lVar.iAw.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                lVar.iAw.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.iAw.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.iAz.setVisibility(0);
                lVar.iAz.setPadding(this.iAn, 0, 0, 0);
                if (postData.kcD) {
                    lVar.iAz.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(cIw.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    lVar.iAz.setText(cIw.getName());
                    return;
                }
            }
            lVar.iAz.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iAC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.iAC.setPadding(0, 0, 0, 0);
            if (!this.izw) {
                lVar.iAC.getLayoutStrategy().mT(R.drawable.icon_click);
            } else {
                lVar.iAC.vJ(null);
                lVar.iAC.setBackgroundDrawable(null);
                lVar.iAC.getLayoutStrategy().mT(R.drawable.transparent_bg);
            }
            lVar.iAC.getLayoutStrategy().mQ(R.drawable.pic_video);
            a(lVar.iAC, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.iAC.setLayoutParams(layoutParams);
            lVar.iAC.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            lVar.iAC.setIsFromCDN(this.mIsFromCDN);
            TbRichText cIv = postData.cIv();
            lVar.iAC.setIsUseGridImage(postData.cIG());
            lVar.iAC.setText(cIv, true, this.iAo);
            SparseArray sparseArray = (SparseArray) lVar.iAC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            lVar.iAC.setTag(sparseArray);
            lVar.iAu.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().mR(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().dJK = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().mS((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.cIx() > 0) {
                lVar.iAG.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) lVar.iAG.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    lVar.iAG.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.cIF() == 2) {
                    lVar.iAG.setVisibility(8);
                } else {
                    lVar.iAG.setVisibility(0);
                }
                lVar.iAF.setVisibility(8);
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.cIx() > 0) {
                    lVar.iAF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.cIx())));
                    SparseArray sparseArray2 = (SparseArray) lVar.iAF.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        lVar.iAF.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                    lVar.iAF.setVisibility(0);
                    lVar.iAG.setVisibility(8);
                    lVar.iAE.setVisibility(8);
                }
            } else {
                lVar.iAF.setVisibility(8);
                if (postData.cIx() > 0 && postData.cIq() != null && postData.cIq().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.iAE.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    lVar.iAE.setLayoutParams(layoutParams);
                    if (this.iAp == null) {
                        this.iAp = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.iAp.setIsFromCDN(this.mIsFromCDN);
                        this.iAp.setOnLongClickListener(this.mOnLongClickListener);
                        this.iAp.T(this.izF);
                        this.iAp.y(this.ahD);
                        String str = null;
                        if (this.izv != null && this.izv.chK() != null && this.izv.chK().azE() != null) {
                            str = this.izv.chK().azE().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.izv != null) {
                            this.iAp.P(this.izv.chW(), z);
                            this.iAp.setThreadData(this.izv.chK());
                        }
                    }
                    this.iAp.FS(postData.getId());
                    lVar.iAE.setSubPbAdapter(this.iAp);
                    lVar.iAE.setVisibility(0);
                    lVar.iAE.setData(postData, view);
                    lVar.iAE.setChildOnClickListener(this.ahD);
                    lVar.iAE.setChildOnLongClickListener(this.mOnLongClickListener);
                    lVar.iAE.setChildOnTouchListener(this.iAq);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.iAE.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    lVar.iAE.setLayoutParams(layoutParams2);
                    lVar.iAE.setVisibility(8);
                }
            }
            if (postData.kct) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(l lVar, PostData postData) {
        if (lVar != null && lVar.iAQ != null && lVar.iAN != null) {
            if (postData == null || postData.kcx == null || StringUtils.isNull(postData.kcx.liveTitle)) {
                lVar.iAN.setVisibility(8);
                return;
            }
            lVar.iAQ.setText(postData.kcx.liveTitle);
            lVar.iAN.setTag(postData.kcx);
            lVar.iAN.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.iAV.setVisibility(postData.kcD ? 0 : 8);
        }
    }

    private void a(l lVar) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            if (lVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.fqP, R.color.cp_cont_b, 1);
                if (lVar.iAv.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iAv, ((Integer) lVar.iAv.getTag()).intValue());
                } else if (lVar.iAv.getTag() instanceof String) {
                    if (lVar.iAv.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.MR;
                    } else if (lVar.iAv.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.MS;
                    } else {
                        layerDrawable = lVar.iAv.getTag().equals("HOST") ? this.ixQ : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.iAv.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAw, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAx, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAy, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAH, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAz, R.color.cp_cont_d, 1);
                lVar.iAC.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.iAE, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAF, (int) R.color.cp_cont_c);
                lVar.iAF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAG, (int) R.color.cp_cont_c);
                lVar.iAE.onChangeSkinType();
                lVar.iAD.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAQ, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAO, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iAN, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.iAP, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.iAR, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.iAU, (int) R.color.cp_cont_c);
                if (lVar.iAS.getVisibility() == 8) {
                    lVar.iAU.setText(R.string.close_content);
                } else if (this.izv != null && StringUtils.isNull(this.izv.chS())) {
                    lVar.iAU.setText(this.izv.chS());
                } else {
                    lVar.iAU.setText(R.string.expand_content);
                }
                lVar.iAA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            lVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void b(l lVar) {
        lVar.iAu.setOnTouchListener(this.iAq);
        lVar.iAu.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iAW.ckE() != null && this.iAW.ckE().getPageContext() != null && this.iAW.ckE().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.iAW.ckE().iyV;
            lVar.fqP.setOnClickListener(aVar.gLG);
            lVar.iAB.setOnClickListener(aVar.gLG);
            lVar.iAJ.setOnClickListener(aVar.gLG);
            lVar.iAJ.getHeadView().setOnClickListener(aVar.gLG);
            lVar.iAC.setOnLongClickListener(this.mOnLongClickListener);
            lVar.iAC.setOnTouchListener(this.iAq);
            lVar.iAC.setCommonTextViewOnClickListener(this.ahD);
            lVar.iAC.setOnImageClickListener(this.dIi);
            lVar.iAC.setOnImageTouchListener(this.iAq);
            lVar.iAC.setOnEmotionClickListener(aVar.iNF);
            lVar.iAC.setOnVoiceAfterClickListener(this.ahD);
            lVar.iAM.setOnClickListener(this.ahD);
            lVar.iAN.setOnClickListener(this.ahD);
            lVar.iAF.setOnClickListener(this.ahD);
            lVar.iAG.setOnClickListener(this.ahD);
        }
    }

    private void ne() {
        this.MR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).ts("#4D000000").aEw()});
        this.MS = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).ts("#4D000000").aEw()});
        this.ixQ = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.amD).ts("#4D000000").aEw()});
    }

    public void a(TbRichTextView.c cVar) {
        this.iAo = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.izv = fVar;
    }

    public void dv(String str) {
        this.amQ = str;
    }

    public void ph(boolean z) {
        this.izw = z;
    }

    private SpannableStringBuilder cs(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iAW.ckE(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.iAC.setTextViewOnTouchListener(this.dmm);
        lVar.iAC.setTextViewCheckSelection(false);
    }

    public void P(View.OnClickListener onClickListener) {
        this.izF = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
