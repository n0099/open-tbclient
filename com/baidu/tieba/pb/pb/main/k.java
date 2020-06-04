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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
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
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class k extends m<PostData, l> implements View.OnClickListener {
    private View.OnClickListener aIH;
    private String aPJ;
    private int aPq;
    private LayerDrawable agG;
    private LayerDrawable agH;
    private int avV;
    private TbRichTextView.i eBN;
    private boolean eEu;
    private com.baidu.tieba.pb.a.c efF;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hss;
    private com.baidu.adp.lib.d.b<TbImageView> hst;
    private int jHa;
    private int jHb;
    private LayerDrawable jHc;
    protected com.baidu.tieba.pb.data.e jIA;
    private boolean jIB;
    private View.OnClickListener jIK;
    private int jJq;
    private TbRichTextView.c jJr;
    private com.baidu.tieba.pb.pb.sub.b jJs;
    private boolean jJt;
    private boolean jJu;
    private com.baidu.tieba.pb.a.c jJv;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        if (view != null && (view.getTag() instanceof l)) {
            l lVar = (l) view.getTag();
            if (lVar.jJH != null && lVar.jJH.getData() != null) {
                if (!this.jJt) {
                    com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                    cVar.dAZ = 5;
                    cVar.dBb = 2;
                    lVar.jJH.setStatisticData(cVar);
                }
                lVar.jJH.aVQ();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aPq = 0;
        this.jJq = 0;
        this.jHa = 0;
        this.jHb = 0;
        this.jJr = null;
        this.jIB = true;
        this.aPJ = null;
        this.jIA = null;
        this.jIK = null;
        this.aIH = null;
        this.eBN = null;
        this.efF = null;
        this.mOnLongClickListener = null;
        this.jJs = null;
        this.eEu = true;
        this.jJt = com.baidu.tbadk.a.d.aMp();
        this.jJu = com.baidu.tbadk.a.d.aMo();
        this.hss = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bXn */
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
        this.hst = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aWN */
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
        this.jJv = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.jHL == null || k.this.jHL.cEE() == null || k.this.jHL.cEE().cHx())) {
                    if (view instanceof RelativeLayout) {
                        k.this.cA(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                k.this.cA((RelativeLayout) parent);
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
                if (k.this.efF != null) {
                    if (!(view instanceof TbListTextView) || k.this.aIH == null) {
                        k.this.efF.R(view);
                        k.this.efF.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.aIH.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.cDO() != null) {
            this.avV = bVar.cDO().cGt();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.jKg.cFs().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.avV, this.jJt);
        lVar.jJL.setConstrainLayoutPool(this.hss);
        lVar.jJL.setImageViewPool(this.hst);
        a(lVar);
        this.aPq = getDimensionPixelSize(R.dimen.tbds10);
        this.jJq = getDimensionPixelSize(R.dimen.tbds14);
        this.jHa = getDimensionPixelSize(R.dimen.tbds36);
        this.jHb = getDimensionPixelSize(R.dimen.tbds6);
        if (lVar.jJK != null) {
            lVar.jJK.setDuiEnabled(this.eEu);
        }
        rY();
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
            j(postData2);
            l(postData2);
            postData2.aRK();
            i(postData2);
            a(lVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.eEu = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.lmP) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.jIA, postData, postData.locate, i, 6);
            postData.lmQ = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.ddG())) {
                Iterator<PostData> it = postData.ddG().iterator();
                while (it.hasNext()) {
                    it.next().lmQ = b;
                }
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
        if (lVar != null && lVar.jJB != null) {
            if (this.jKg != null && this.jKg.cDO() != null && this.jKg.cDO().cGB() && com.baidu.tbadk.core.util.aq.equals(this.jKg.cDO().cFI(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.jJB, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.jJB, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, boolean z, String str) {
        if (z) {
            lVar.jKb.setVisibility(8);
            if (StringUtils.isNull(str)) {
                lVar.jKd.setText(R.string.expand_content);
                return;
            } else {
                lVar.jKd.setText(str);
                return;
            }
        }
        lVar.jKb.setVisibility(0);
        lVar.jKd.setText(R.string.close_content);
    }

    private void c(final l lVar, final PostData postData) {
        if (postData.ddV() == 2 || postData.ddV() == 4) {
            lVar.jKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.jKb.getVisibility() == 8;
                    k.this.a(lVar, !z, postData.cCJ());
                    postData.ur(z ? false : true);
                    k.this.d(lVar, postData);
                    if (k.this.jHL != null && k.this.jHL.cEE() != null && k.this.jHL.cEE().cIz() != null && k.this.jHL.cEE().getListView() != null && !z && lVar.getView().getTop() < k.this.jHL.cEE().cIz().getMeasuredHeight()) {
                        k.this.jHL.cEE().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(k.this.jHL.cEE().getListView().getData(), postData) + k.this.jHL.cEE().getListView().getHeaderViewsCount(), k.this.jHL.cEE().cIz().getMeasuredHeight());
                    }
                }
            });
            lVar.jKc.setVisibility(0);
            a(lVar, postData.ddE(), postData.cCJ());
            a(true, lVar, postData);
        } else {
            lVar.jKc.setVisibility(8);
            lVar.jKb.setVisibility(0);
            a(false, lVar, postData);
        }
        d(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        if (lVar != null && lVar.mBottomLine != null && lVar.jKc != null && (lVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (lVar.jKc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.ddG());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) lVar.jKc.getLayoutParams();
            if (z) {
                lVar.jJK.getLayoutStrategy().oj(0);
                if (z2) {
                    lVar.jJK.getLayoutStrategy().oi(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    lVar.jJK.getLayoutStrategy().oi(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                lVar.jKc.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    lVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            lVar.jJK.getLayoutStrategy().oi(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            lVar.jJK.getLayoutStrategy().oj(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                lVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(l lVar, PostData postData) {
        TbRichText ddL = postData.ddL();
        ddL.isChanged = true;
        lVar.jJK.setText(ddL, true, this.jJr);
    }

    private void j(PostData postData) {
        if (postData.dGg == 0 && postData.huO) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.dh("post_id", postData.getId());
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.dh("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.dh("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            anVar.dh("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.jKg != null) {
                int cGt = this.jKg.cDO().cGt();
                if (1 == cGt || 2 == cGt) {
                    anVar.dh("obj_source", "1");
                } else if (3 == cGt) {
                    anVar.dh("obj_source", "2");
                } else {
                    anVar.dh("obj_source", "0");
                }
            }
            TiebaStatic.log(anVar);
            if (postData.aQx() != null && postData.aQx().getAlaInfo() != null && postData.aQx().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.aQx().getUserId();
        String forumId = this.jIA != null ? this.jIA.getForumId() : "";
        String forumName = this.jIA != null ? this.jIA.getForumName() : "";
        int ddJ = postData.ddJ();
        String id = postData.getId();
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13714");
        anVar.dh("fid", forumId);
        anVar.dh("fname", forumName);
        anVar.dh("obj_param1", userId);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("tid", id);
        anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, ddJ);
        TiebaStatic.log(anVar);
    }

    private void l(PostData postData) {
        if (this.jIA != null) {
            if (this.jIA.aWj()) {
                if (this.jKh != null) {
                    com.baidu.tieba.pb.c.a.a(this.jKh.getUniqueId(), this.jIA, postData, postData.locate, postData.lmP ? 2 : 8);
                }
            } else if (this.jHL != null) {
                com.baidu.tieba.pb.c.a.a(this.jHL.getUniqueId(), this.jIA, postData, postData.locate, postData.lmP ? 2 : 8);
            }
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.cKn() == null) {
            lVar.jJV.setVisibility(8);
            return;
        }
        TbRichText ddL = postData.ddL();
        com.baidu.tieba.pb.view.b.a(postData.cKn(), lVar.jJV, false, false, ddL != null && StringUtils.isNull(ddL.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jIB) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jJK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.jJK.setLayoutParams(layoutParams);
            lVar.jJK.setPadding(0, 0, 0, 0);
            lVar.jJK.ze(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.jJK.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.jJK.setLayoutParams(layoutParams2);
            lVar.jJK.ze(postData.getBimg_url());
        }
        lVar.jJK.setTextViewOnTouchListener(this.jJv);
        lVar.jJK.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0968  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0982  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x098f  */
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
            if (postData.aQx() == null || postData.aQx().isBaijiahaoUser()) {
            }
            if (postData.lmF) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            lVar.jJJ.setTag(null);
            lVar.jJJ.setUserId(null);
            lVar.gre.setText((CharSequence) null);
            lVar.jJS.getHeadView().setUserId(null);
            lVar.jJK.setIsHost(false);
            if (postData.aQx() != null) {
                if (this.aPJ != null && !this.aPJ.equals("0") && this.aPJ.equals(postData.aQx().getUserId())) {
                    lVar.jJK.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aQx().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aQx().getTShowInfoNew();
                if (lVar.jJU != null) {
                    lVar.jJU.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                    if (this.jKg != null && this.jKg.cFs() != null) {
                        lVar.jJU.setOnClickListener(this.jKg.cFs().jHX.jXj);
                    }
                    lVar.jJU.a(iconInfo, 2, this.jHa, this.jHa, this.aPq);
                }
                if (lVar.jJT != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.jJT.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.jKg != null && this.jKg.cFs() != null) {
                        lVar.jJT.setOnClickListener(this.jKg.cFs().jHX.jXk);
                    }
                    lVar.jJT.a(tShowInfoNew, 3, this.jHa, this.jHa, this.aPq, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aQx().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gre, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gre, R.color.cp_cont_b, 1);
                }
                String avater = postData.aQx().getAvater();
                int i2 = 8;
                if (postData.lmP) {
                    i2 = 2;
                }
                lVar.gre.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                lVar.gre.setTag(R.id.tag_user_name, postData.aQx().getUserName());
                lVar.gre.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                lVar.gre.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jIA, postData, postData.locate, i2, 2));
                String name_show = postData.aQx().getName_show();
                String userName = postData.aQx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.gre.setText(com.baidu.tieba.pb.c.aK(this.mContext, lVar.gre.getText().toString()));
                    lVar.gre.setGravity(16);
                    lVar.gre.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cCh());
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gre, R.color.cp_other_f, 1);
                }
                if (postData.aQx().getPendantData() != null && !StringUtils.isNull(postData.aQx().getPendantData().aOP())) {
                    lVar.jJS.a(postData.aQx(), 4);
                    lVar.jJJ.setVisibility(8);
                    lVar.jJS.setVisibility(0);
                    lVar.jJS.getHeadView().startLoad(avater, 28, false);
                    lVar.jJS.getHeadView().setUserId(postData.aQx().getUserId());
                    lVar.jJS.getHeadView().setUserName(postData.aQx().getUserName());
                    lVar.jJS.getHeadView().setFid(this.jIA != null ? this.jIA.getForumId() : "");
                    lVar.jJS.getHeadView().setFName(this.jIA != null ? this.jIA.getForumName() : "");
                    lVar.jJS.getHeadView().setFloor(postData.ddJ());
                    lVar.jJS.getHeadView().setTid(postData.getId());
                    lVar.jJS.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jIA, postData, postData.locate, i2, 2));
                    lVar.jJS.wP(postData.aQx().getPendantData().aOP());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.jJJ, postData.aQx(), 4);
                    lVar.jJJ.setUserId(postData.aQx().getUserId());
                    lVar.jJJ.setFid(this.jIA != null ? this.jIA.getForumId() : "");
                    lVar.jJJ.setFName(this.jIA != null ? this.jIA.getForumName() : "");
                    lVar.jJJ.setFloor(postData.ddJ());
                    lVar.jJJ.setTid(postData.getId());
                    lVar.jJJ.setUserName(postData.aQx().getUserName(), postData.ddT());
                    lVar.jJJ.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                    lVar.jJJ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jIA, postData, postData.locate, i2, 2));
                    lVar.jJJ.setImageDrawable(null);
                    lVar.jJJ.startLoad(avater, 28, false);
                    lVar.jJJ.setVisibility(0);
                    lVar.jJS.setVisibility(8);
                }
                if (postData.aQx() != null && postData.aQx().getAlaInfo() != null && postData.aQx().getAlaUserData() != null && postData.aQx().getAlaUserData().live_status == 1) {
                    lVar.pW(true);
                    lVar.jJJ.setLiveStatus(1);
                    lVar.jJJ.setAlaInfo(postData.aQx().getAlaInfo());
                    lVar.jJS.getHeadView().setLiveStatus(1);
                    lVar.jJS.getHeadView().setAlaInfo(postData.aQx().getAlaInfo());
                } else {
                    lVar.pW(false);
                    lVar.jJJ.setLiveStatus(0);
                    lVar.jJJ.setAlaInfo(null);
                    lVar.jJS.getHeadView().setLiveStatus(0);
                    lVar.jJS.getHeadView().setAlaInfo(null);
                }
                if (this.jIA != null && this.jIA.cCZ()) {
                    lVar.jJC.setVisibility(8);
                    lVar.jJC.setTag(null);
                } else if (postData.aQx() != null) {
                    MetaData aQx = postData.aQx();
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJC, (int) R.color.cp_cont_a);
                    if (this.aPJ != null && !this.aPJ.equals("0") && this.aPJ.equals(aQx.getUserId())) {
                        lVar.jJC.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (this.jHc.getDrawable(1) != null) {
                                this.jHc.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.jHc.getDrawable(1) != null) {
                            this.jHc.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(this.jHc);
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.host_name);
                    } else if (aQx.getIs_bawu() == 1 && postData.ddB()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jJC, R.drawable.brand_official_btn);
                        lVar.jJC.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.brand_Official);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                        lVar.jJC.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.agG.getDrawable(1) != null) {
                                this.agG.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agG.getDrawable(1) != null) {
                            this.agG.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(this.agG);
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                        lVar.jJC.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.agH.getDrawable(1) != null) {
                                this.agH.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agH.getDrawable(1) != null) {
                            this.agH.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(this.agH);
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aQx.getIs_bawu() == 1 && "pri_content_assist".equals(aQx.getBawu_type())) {
                        int ld = com.baidu.tbadk.core.util.am.ld(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jJC, ld);
                        lVar.jJC.setTag(Integer.valueOf(ld));
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_content_assist_tip);
                    } else if (aQx.getIs_bawu() == 1 && "pri_manage_assist".equals(aQx.getBawu_type())) {
                        int ld2 = com.baidu.tbadk.core.util.am.ld(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jJC, ld2);
                        lVar.jJC.setTag(Integer.valueOf(ld2));
                        lVar.jJC.setVisibility(0);
                        lVar.jJC.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.jJC.setVisibility(8);
                        lVar.jJC.setTag(null);
                    }
                } else {
                    lVar.jJC.setVisibility(8);
                    lVar.jJC.setTag(null);
                }
            }
            int i3 = 0;
            if (this.jKg != null && this.jKg.cFs() != null && this.jKg.cFs().cDE() && postData.aQx() != null) {
                i3 = postData.aQx().getLevel_id();
            }
            if (this.jIA != null && this.jIA.cCZ()) {
                i3 = 0;
            }
            if (i3 > 0) {
                lVar.jJR.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.jJR, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                lVar.jJR.setVisibility(8);
            }
            int i4 = 15;
            if (lVar.jJU.getChildCount() == 1) {
                i4 = 13;
            } else if (lVar.jJU.getChildCount() > 1) {
                i4 = 11;
            }
            if (lVar.jJC.getVisibility() == 0) {
                i4 -= 2;
            }
            if (lVar.jJT.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aRX() > 1000) {
                i4 -= 2;
            }
            if (postData.aRX() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                lVar.jJU.setVisibility(8);
                if (lVar.jJU.getChildCount() == 1) {
                    i4 += 2;
                } else if (lVar.jJU.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && lVar.jJC.getVisibility() == 0) {
                    i4 += 2;
                    lVar.jJC.setVisibility(8);
                }
                if (i4 < 10 && lVar.jJR.getVisibility() == 0) {
                    i4 += 2;
                    lVar.jJR.setVisibility(8);
                }
            }
            String name_show2 = postData.aQx() != null ? postData.aQx().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ae.getTextLengthWithEmoji(name_show2);
            if (postData.aQx() != null && !StringUtils.isNull(postData.aQx().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.aQx() != null && !StringUtils.isNull(postData.aQx().getSealPrefix())) {
                lVar.gre.setText(dk(postData.aQx().getSealPrefix(), name_show2));
            } else {
                lVar.gre.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.ddJ()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aQx() != null && !StringUtils.isNull(postData.aQx().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.jIA != null && this.jIA.cCN() != 0) {
                if (this.jIA.cCN() != 1002 && this.jIA.cCN() != 3) {
                    z10 = true;
                }
                if (this.jIA.cCN() != 3 && !this.jIA.cCZ()) {
                    z11 = true;
                }
                if (postData != null && postData.aQx() != null) {
                    String userId2 = postData.aQx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCy().aQx() != null && postData.aQx() != null) {
                            userId = this.jIA.cCy().aQx().getUserId();
                            String userId3 = postData.aQx().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aQx() != null && UtilHelper.isCurrentAccount(postData.aQx().getUserId())) {
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
                                if (postData.ddJ() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jIA.cCN()));
                                    if (postData.aQx() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aQx() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aQx().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aQx().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aQx().getName_show());
                                    }
                                    if (this.jIA.cCy() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.jIA.cCy().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jIA.cCN()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.jJK.setTag(sparseArray);
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
                        if (postData.ddJ() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        lVar.jJK.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.jIA != null) {
                userId = this.jIA.cCy().aQx().getUserId();
                String userId32 = postData.aQx().getUserId();
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
            if (postData.ddJ() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            lVar.jJK.setTag(sparseArray);
        }
    }

    private void f(l lVar, PostData postData) {
        if (lVar != null && postData != null && postData.aSp() != null) {
            postData.aSp().threadId = this.jKg.cDO().cFJ();
            postData.aSp().objType = 1;
            postData.aSp().isInPost = true;
            bk bkVar = null;
            if (this.jIA != null && this.jIA.cCy() != null) {
                bkVar = this.jIA.cCy();
            }
            if (bkVar != null && bkVar.aSx()) {
                lVar.jJH.setAgreeAlone(true);
            }
            lVar.jJH.setThreadData(bkVar);
            lVar.jJH.setData(postData.aSp());
        }
    }

    private void g(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.ddJ() > 0 && this.jIA != null && !this.jIA.cCZ()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.ddJ()));
                lVar.jJQ.setVisibility(0);
                lVar.jJQ.setText(format);
                z = true;
            } else {
                lVar.jJQ.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f ddM = postData.ddM();
            boolean z2 = (ddM == null || StringUtils.isNull(ddM.getName()) || this.jIA == null || this.jIA.cCZ()) ? false : true;
            if (z) {
                lVar.jJE.setVisibility(0);
                i = this.jJq;
            } else {
                lVar.jJE.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.jJF.setVisibility(0);
                i2 = this.jJq;
            } else {
                lVar.jJF.setVisibility(8);
                i2 = 0;
            }
            lVar.jJD.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.jJD.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.jJD.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.jJG.setVisibility(0);
                lVar.jJG.setPadding(this.jJq, 0, 0, 0);
                if (postData.lmN) {
                    lVar.jJG.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(ddM.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    lVar.jJG.setText(ddM.getName());
                    return;
                }
            }
            lVar.jJG.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jJK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.jJK.setPadding(0, 0, 0, 0);
            if (!this.jIB) {
                lVar.jJK.getLayoutStrategy().od(R.drawable.icon_click);
            } else {
                lVar.jJK.ze(null);
                lVar.jJK.setBackgroundDrawable(null);
                lVar.jJK.getLayoutStrategy().od(R.drawable.transparent_bg);
            }
            lVar.jJK.getLayoutStrategy().oa(R.drawable.pic_video);
            a(lVar.jJK, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.jJK.setLayoutParams(layoutParams);
            lVar.jJK.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            lVar.jJK.setIsFromCDN(this.mIsFromCDN);
            TbRichText ddL = postData.ddL();
            lVar.jJK.setIsUseGridImage(postData.ddW());
            lVar.jJK.setText(ddL, true, this.jJr);
            SparseArray sparseArray = (SparseArray) lVar.jJK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            lVar.jJK.setTag(sparseArray);
            lVar.jJB.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().ob(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eDp = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oc((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.ddN() > 0) {
                lVar.jJO.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) lVar.jJO.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    lVar.jJO.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.ddV() == 2) {
                    lVar.jJO.setVisibility(8);
                } else {
                    lVar.jJO.setVisibility(0);
                }
                lVar.jJN.setVisibility(8);
            }
            if (this.jJt) {
                if (lVar.jJP != null) {
                    SparseArray sparseArray2 = (SparseArray) lVar.jJP.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        lVar.jJP.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (lVar.ihG != null) {
                    SparseArray sparseArray3 = (SparseArray) lVar.ihG.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        lVar.ihG.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.ddN() > 0) {
                    lVar.jJN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.ddN())));
                    SparseArray sparseArray4 = (SparseArray) lVar.jJN.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        lVar.jJN.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                    lVar.jJN.setVisibility(0);
                    lVar.jJO.setVisibility(8);
                    lVar.jJM.setVisibility(8);
                }
            } else {
                lVar.jJN.setVisibility(8);
                if (postData.ddN() > 0 && postData.ddG() != null && postData.ddG().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jJM.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    lVar.jJM.setLayoutParams(layoutParams);
                    if (this.jJs == null) {
                        this.jJs = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.jJs.setIsFromCDN(this.mIsFromCDN);
                        this.jJs.setOnLongClickListener(this.mOnLongClickListener);
                        this.jJs.T(this.jIK);
                        this.jJs.y(this.aIH);
                        String str = null;
                        if (this.jIA != null && this.jIA.cCy() != null && this.jIA.cCy().aQx() != null) {
                            str = this.jIA.cCy().aQx().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.jIA != null) {
                            this.jJs.Y(this.jIA.cCN(), z);
                            this.jJs.setThreadData(this.jIA.cCy());
                        }
                    }
                    this.jJs.JP(postData.getId());
                    lVar.jJM.setSubPbAdapter(this.jJs);
                    lVar.jJM.setVisibility(0);
                    lVar.jJM.setData(postData, view);
                    lVar.jJM.setChildOnClickListener(this.aIH);
                    lVar.jJM.setChildOnLongClickListener(this.mOnLongClickListener);
                    lVar.jJM.setChildOnTouchListener(this.jJv);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.jJM.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    lVar.jJM.setLayoutParams(layoutParams2);
                    lVar.jJM.setVisibility(8);
                }
            }
            if (postData.lmD) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(l lVar, PostData postData) {
        if (lVar != null && lVar.jJZ != null && lVar.jJW != null) {
            if (postData == null || postData.lmH == null || StringUtils.isNull(postData.lmH.liveTitle)) {
                lVar.jJW.setVisibility(8);
                return;
            }
            lVar.jJZ.setText(postData.lmH.liveTitle);
            lVar.jJW.setTag(postData.lmH);
            lVar.jJW.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.jKe.setVisibility((!postData.lmN || this.jJu) ? 8 : 0);
        }
    }

    private void a(l lVar) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (lVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gre, R.color.cp_cont_b, 1);
                if (lVar.jJC.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jJC, ((Integer) lVar.jJC.getTag()).intValue());
                } else if (lVar.jJC.getTag() instanceof String) {
                    if (lVar.jJC.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.agG;
                    } else if (lVar.jJC.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.agH;
                    } else {
                        layerDrawable = lVar.jJC.getTag().equals("HOST") ? this.jHc : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.jJC.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJD, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJE, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJF, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJQ, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJG, R.color.cp_cont_d, 1);
                lVar.jJK.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.jJM, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJN, (int) R.color.cp_cont_c);
                lVar.jJN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJO, (int) R.color.cp_cont_c);
                if (this.jJt) {
                    SvgManager.aUW().a(lVar.jJP, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUW().a(lVar.ihG, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                lVar.jJM.onChangeSkinType();
                lVar.jJL.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJZ, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jJX, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jJW, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jJY, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.jKa, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jKd, (int) R.color.cp_cont_c);
                if (lVar.jKb.getVisibility() == 8) {
                    lVar.jKd.setText(R.string.close_content);
                } else if (this.jIA != null && StringUtils.isNull(this.jIA.cCJ())) {
                    lVar.jKd.setText(this.jIA.cCJ());
                } else {
                    lVar.jKd.setText(R.string.expand_content);
                }
                lVar.jJH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                lVar.yy(skinType);
            }
            lVar.mSkinType = skinType;
        }
    }

    private void b(final l lVar) {
        lVar.jJB.setOnTouchListener(this.jJv);
        lVar.jJB.setOnLongClickListener(this.mOnLongClickListener);
        if (this.jKg.cFs() != null && this.jKg.cFs().getPageContext() != null && this.jKg.cFs().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.jKg.cFs().jHX;
            lVar.gre.setOnClickListener(aVar.gWU);
            lVar.jJJ.setOnClickListener(aVar.gWU);
            lVar.jJS.setOnClickListener(aVar.gWU);
            lVar.jJS.getHeadView().setOnClickListener(aVar.gWU);
            lVar.jJK.setOnLongClickListener(this.mOnLongClickListener);
            lVar.jJK.setOnTouchListener(this.jJv);
            lVar.jJK.setCommonTextViewOnClickListener(this.aIH);
            lVar.jJK.setOnImageClickListener(this.eBN);
            lVar.jJK.setOnImageTouchListener(this.jJv);
            lVar.jJK.setOnEmotionClickListener(aVar.jXl);
            lVar.jJK.setOnVoiceAfterClickListener(this.aIH);
            lVar.jJV.setOnClickListener(this.aIH);
            lVar.jJW.setOnClickListener(this.aIH);
            lVar.jJN.setOnClickListener(this.aIH);
            lVar.jJO.setOnClickListener(this.aIH);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.jKg.cFs().jHY;
            if (this.jJt) {
                lVar.jJP.setOnClickListener(this.aIH);
                lVar.ihG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && lVar.jJB != null && cVar != null) {
                                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.jXA.a(k.this.jIA, null, postData, lVar.jJB);
                                    }
                                }, 100L);
                                String threadId = k.this.jIA.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(k.this.jIA.getThreadId())) && k.this.jIA.cCy() != null) {
                                    threadId = k.this.jIA.cCy().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13700").dh("tid", threadId).dh("fid", k.this.jIA.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData.getId()).ag("obj_type", 4));
                            }
                        }
                    }
                });
                lVar.jJH.dRF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && k.this.jIA != null && lVar != null && lVar.jJH != null && lVar.jJH.getData() != null) {
                            int i = view == lVar.jJH.getImgAgree() ? 1 : 2;
                            String threadId = k.this.jIA.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.jIA.getThreadId())) && k.this.jIA.cCy() != null) {
                                threadId = k.this.jIA.cCy().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13700").dh("tid", threadId).dh("fid", k.this.jIA.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", lVar.jJH.getData().postId).ag("obj_type", i));
                        }
                    }
                };
            }
        }
    }

    private void rY() {
        this.agG = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(this.jHb).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVC(), com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(this.jHb).wJ("#4D000000").aVC()});
        this.agH = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(this.jHb).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVC(), com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(this.jHb).wJ("#4D000000").aVC()});
        this.jHc = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(this.jHb).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aVC(), com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(this.jHb).wJ("#4D000000").aVC()});
    }

    public void a(TbRichTextView.c cVar) {
        this.jJr = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jIA = eVar;
    }

    public void fl(String str) {
        this.aPJ = str;
    }

    public void re(boolean z) {
        this.jIB = z;
    }

    private SpannableStringBuilder dk(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.jKg.cFs(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.jJK.setTextViewOnTouchListener(this.efF);
        lVar.jJK.setTextViewCheckSelection(false);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jIK = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBN = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.efF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
