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
    private TbRichTextView.i eBC;
    private boolean eEj;
    private com.baidu.tieba.pb.a.c efF;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hsh;
    private com.baidu.adp.lib.d.b<TbImageView> hsi;
    private int jFU;
    private int jFV;
    private LayerDrawable jFW;
    private View.OnClickListener jHE;
    protected com.baidu.tieba.pb.data.e jHu;
    private boolean jHv;
    private int jIk;
    private TbRichTextView.c jIl;
    private com.baidu.tieba.pb.pb.sub.b jIm;
    private boolean jIn;
    private boolean jIo;
    private com.baidu.tieba.pb.a.c jIp;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        if (view != null && (view.getTag() instanceof l)) {
            l lVar = (l) view.getTag();
            if (lVar.jIB != null && lVar.jIB.getData() != null) {
                if (!this.jIn) {
                    com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
                    cVar.dAZ = 5;
                    cVar.dBb = 2;
                    lVar.jIB.setStatisticData(cVar);
                }
                lVar.jIB.aVP();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aPq = 0;
        this.jIk = 0;
        this.jFU = 0;
        this.jFV = 0;
        this.jIl = null;
        this.jHv = true;
        this.aPJ = null;
        this.jHu = null;
        this.jHE = null;
        this.aIH = null;
        this.eBC = null;
        this.efF = null;
        this.mOnLongClickListener = null;
        this.jIm = null;
        this.eEj = true;
        this.jIn = com.baidu.tbadk.a.d.aMp();
        this.jIo = com.baidu.tbadk.a.d.aMo();
        this.hsh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bXl */
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
        this.hsi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aWM */
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
        this.jIp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.jGF == null || k.this.jGF.cEo() == null || k.this.jGF.cEo().cHh())) {
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
        if (bVar != null && bVar.cDy() != null) {
            this.avV = bVar.cDy().cGd();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.jJa.cFc().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.avV, this.jIn);
        lVar.jIF.setConstrainLayoutPool(this.hsh);
        lVar.jIF.setImageViewPool(this.hsi);
        a(lVar);
        this.aPq = getDimensionPixelSize(R.dimen.tbds10);
        this.jIk = getDimensionPixelSize(R.dimen.tbds14);
        this.jFU = getDimensionPixelSize(R.dimen.tbds36);
        this.jFV = getDimensionPixelSize(R.dimen.tbds6);
        if (lVar.jIE != null) {
            lVar.jIE.setDuiEnabled(this.eEj);
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
        this.eEj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.llG) {
                i = 2;
            }
            com.baidu.tbadk.core.util.an b = com.baidu.tieba.pb.c.a.b(this.jHu, postData, postData.locate, i, 6);
            postData.llH = b;
            if (!com.baidu.tbadk.core.util.v.isEmpty(postData.ddr())) {
                Iterator<PostData> it = postData.ddr().iterator();
                while (it.hasNext()) {
                    it.next().llH = b;
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
        if (lVar != null && lVar.jIv != null) {
            if (this.jJa != null && this.jJa.cDy() != null && this.jJa.cDy().cGl() && com.baidu.tbadk.core.util.aq.equals(this.jJa.cDy().cFs(), postData.getId())) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.jIv, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.jIv, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, boolean z, String str) {
        if (z) {
            lVar.jIV.setVisibility(8);
            if (StringUtils.isNull(str)) {
                lVar.jIX.setText(R.string.expand_content);
                return;
            } else {
                lVar.jIX.setText(str);
                return;
            }
        }
        lVar.jIV.setVisibility(0);
        lVar.jIX.setText(R.string.close_content);
    }

    private void c(final l lVar, final PostData postData) {
        if (postData.ddG() == 2 || postData.ddG() == 4) {
            lVar.jIW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = lVar.jIV.getVisibility() == 8;
                    k.this.a(lVar, !z, postData.cCt());
                    postData.ur(z ? false : true);
                    k.this.d(lVar, postData);
                    if (k.this.jGF != null && k.this.jGF.cEo() != null && k.this.jGF.cEo().cIj() != null && k.this.jGF.cEo().getListView() != null && !z && lVar.getView().getTop() < k.this.jGF.cEo().cIj().getMeasuredHeight()) {
                        k.this.jGF.cEo().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.v.getPosition(k.this.jGF.cEo().getListView().getData(), postData) + k.this.jGF.cEo().getListView().getHeaderViewsCount(), k.this.jGF.cEo().cIj().getMeasuredHeight());
                    }
                }
            });
            lVar.jIW.setVisibility(0);
            a(lVar, postData.ddp(), postData.cCt());
            a(true, lVar, postData);
        } else {
            lVar.jIW.setVisibility(8);
            lVar.jIV.setVisibility(0);
            a(false, lVar, postData);
        }
        d(lVar, postData);
    }

    private void a(boolean z, l lVar, PostData postData) {
        if (lVar != null && lVar.mBottomLine != null && lVar.jIW != null && (lVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (lVar.jIW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.v.isEmpty(postData.ddr());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) lVar.jIW.getLayoutParams();
            if (z) {
                lVar.jIE.getLayoutStrategy().oh(0);
                if (z2) {
                    lVar.jIE.getLayoutStrategy().og(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    lVar.jIE.getLayoutStrategy().og(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                lVar.jIW.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    lVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            lVar.jIE.getLayoutStrategy().og(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            lVar.jIE.getLayoutStrategy().oh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                lVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(l lVar, PostData postData) {
        TbRichText ddw = postData.ddw();
        ddw.isChanged = true;
        lVar.jIE.setText(ddw, true, this.jIl);
    }

    private void j(PostData postData) {
        if (postData.dGg == 0 && postData.huD) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12203");
            anVar.dh("post_id", postData.getId());
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("cuid", TbadkCoreApplication.getInst().getCuid());
            anVar.dh("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            anVar.dh("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            anVar.dh("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            anVar.s(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.jJa != null) {
                int cGd = this.jJa.cDy().cGd();
                if (1 == cGd || 2 == cGd) {
                    anVar.dh("obj_source", "1");
                } else if (3 == cGd) {
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
        String forumId = this.jHu != null ? this.jHu.getForumId() : "";
        String forumName = this.jHu != null ? this.jHu.getForumName() : "";
        int ddu = postData.ddu();
        String id = postData.getId();
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13714");
        anVar.dh("fid", forumId);
        anVar.dh("fname", forumName);
        anVar.dh("obj_param1", userId);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("tid", id);
        anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, ddu);
        TiebaStatic.log(anVar);
    }

    private void l(PostData postData) {
        if (this.jHu != null) {
            if (this.jHu.aWi()) {
                if (this.jJb != null) {
                    com.baidu.tieba.pb.c.a.a(this.jJb.getUniqueId(), this.jHu, postData, postData.locate, postData.llG ? 2 : 8);
                }
            } else if (this.jGF != null) {
                com.baidu.tieba.pb.c.a.a(this.jGF.getUniqueId(), this.jHu, postData, postData.locate, postData.llG ? 2 : 8);
            }
        }
    }

    private void a(l lVar, PostData postData) {
        if (postData == null || postData.cJX() == null) {
            lVar.jIP.setVisibility(8);
            return;
        }
        TbRichText ddw = postData.ddw();
        com.baidu.tieba.pb.view.b.a(postData.cJX(), lVar.jIP, false, false, ddw != null && StringUtils.isNull(ddw.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(l lVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jHv) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jIE.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            lVar.jIE.setLayoutParams(layoutParams);
            lVar.jIE.setPadding(0, 0, 0, 0);
            lVar.jIE.ze(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.jIE.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            lVar.jIE.setLayoutParams(layoutParams2);
            lVar.jIE.ze(postData.getBimg_url());
        }
        lVar.jIE.setTextViewOnTouchListener(this.jIp);
        lVar.jIE.setTextViewCheckSelection(false);
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
            if (postData.llw) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.mTopLine, R.color.cp_bg_line_c);
                lVar.mTopLine.setVisibility(0);
            } else {
                lVar.mTopLine.setVisibility(8);
            }
            lVar.jID.setTag(null);
            lVar.jID.setUserId(null);
            lVar.gqT.setText((CharSequence) null);
            lVar.jIM.getHeadView().setUserId(null);
            lVar.jIE.setIsHost(false);
            if (postData.aQx() != null) {
                if (this.aPJ != null && !this.aPJ.equals("0") && this.aPJ.equals(postData.aQx().getUserId())) {
                    lVar.jIE.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aQx().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aQx().getTShowInfoNew();
                if (lVar.jIO != null) {
                    lVar.jIO.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                    if (this.jJa != null && this.jJa.cFc() != null) {
                        lVar.jIO.setOnClickListener(this.jJa.cFc().jGR.jWd);
                    }
                    lVar.jIO.a(iconInfo, 2, this.jFU, this.jFU, this.aPq);
                }
                if (lVar.jIN != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        lVar.jIN.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.jJa != null && this.jJa.cFc() != null) {
                        lVar.jIN.setOnClickListener(this.jJa.cFc().jGR.jWe);
                    }
                    lVar.jIN.a(tShowInfoNew, 3, this.jFU, this.jFU, this.aPq, true);
                }
                if (!com.baidu.tbadk.core.util.v.isEmpty(tShowInfoNew) || postData.aQx().isBigV()) {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gqT, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gqT, R.color.cp_cont_b, 1);
                }
                String avater = postData.aQx().getAvater();
                int i2 = 8;
                if (postData.llG) {
                    i2 = 2;
                }
                lVar.gqT.setTag(R.id.tag_user_id, postData.aQx().getUserId());
                lVar.gqT.setTag(R.id.tag_user_name, postData.aQx().getUserName());
                lVar.gqT.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                lVar.gqT.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jHu, postData, postData.locate, i2, 2));
                String name_show = postData.aQx().getName_show();
                String userName = postData.aQx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    lVar.gqT.setText(com.baidu.tieba.pb.c.aK(this.mContext, lVar.gqT.getText().toString()));
                    lVar.gqT.setGravity(16);
                    lVar.gqT.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cBR());
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gqT, R.color.cp_other_f, 1);
                }
                if (postData.aQx().getPendantData() != null && !StringUtils.isNull(postData.aQx().getPendantData().aOP())) {
                    lVar.jIM.a(postData.aQx(), 4);
                    lVar.jID.setVisibility(8);
                    lVar.jIM.setVisibility(0);
                    lVar.jIM.getHeadView().startLoad(avater, 28, false);
                    lVar.jIM.getHeadView().setUserId(postData.aQx().getUserId());
                    lVar.jIM.getHeadView().setUserName(postData.aQx().getUserName());
                    lVar.jIM.getHeadView().setFid(this.jHu != null ? this.jHu.getForumId() : "");
                    lVar.jIM.getHeadView().setFName(this.jHu != null ? this.jHu.getForumName() : "");
                    lVar.jIM.getHeadView().setFloor(postData.ddu());
                    lVar.jIM.getHeadView().setTid(postData.getId());
                    lVar.jIM.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jHu, postData, postData.locate, i2, 2));
                    lVar.jIM.wP(postData.aQx().getPendantData().aOP());
                } else {
                    UtilHelper.showHeadImageViewBigV(lVar.jID, postData.aQx(), 4);
                    lVar.jID.setUserId(postData.aQx().getUserId());
                    lVar.jID.setFid(this.jHu != null ? this.jHu.getForumId() : "");
                    lVar.jID.setFName(this.jHu != null ? this.jHu.getForumName() : "");
                    lVar.jID.setFloor(postData.ddu());
                    lVar.jID.setTid(postData.getId());
                    lVar.jID.setUserName(postData.aQx().getUserName(), postData.ddE());
                    lVar.jID.setTag(R.id.tag_virtual_user_url, postData.aQx().getVirtualUserUrl());
                    lVar.jID.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.jHu, postData, postData.locate, i2, 2));
                    lVar.jID.setImageDrawable(null);
                    lVar.jID.startLoad(avater, 28, false);
                    lVar.jID.setVisibility(0);
                    lVar.jIM.setVisibility(8);
                }
                if (postData.aQx() != null && postData.aQx().getAlaInfo() != null && postData.aQx().getAlaUserData() != null && postData.aQx().getAlaUserData().live_status == 1) {
                    lVar.pW(true);
                    lVar.jID.setLiveStatus(1);
                    lVar.jID.setAlaInfo(postData.aQx().getAlaInfo());
                    lVar.jIM.getHeadView().setLiveStatus(1);
                    lVar.jIM.getHeadView().setAlaInfo(postData.aQx().getAlaInfo());
                } else {
                    lVar.pW(false);
                    lVar.jID.setLiveStatus(0);
                    lVar.jID.setAlaInfo(null);
                    lVar.jIM.getHeadView().setLiveStatus(0);
                    lVar.jIM.getHeadView().setAlaInfo(null);
                }
                if (this.jHu != null && this.jHu.cCJ()) {
                    lVar.jIw.setVisibility(8);
                    lVar.jIw.setTag(null);
                } else if (postData.aQx() != null) {
                    MetaData aQx = postData.aQx();
                    com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIw, (int) R.color.cp_cont_a);
                    if (this.aPJ != null && !this.aPJ.equals("0") && this.aPJ.equals(aQx.getUserId())) {
                        lVar.jIw.setTag("HOST");
                        if (lVar.mSkinType == 1) {
                            if (this.jFW.getDrawable(1) != null) {
                                this.jFW.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.jFW.getDrawable(1) != null) {
                            this.jFW.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(this.jFW);
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.host_name);
                    } else if (aQx.getIs_bawu() == 1 && postData.ddm()) {
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jIw, R.drawable.brand_official_btn);
                        lVar.jIw.setTag(Integer.valueOf((int) R.drawable.brand_official_btn));
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.brand_Official);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                        lVar.jIw.setTag("BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.agG.getDrawable(1) != null) {
                                this.agG.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agG.getDrawable(1) != null) {
                            this.agG.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(this.agG);
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                        lVar.jIw.setTag("XIAO_BA_ZHU_BG");
                        if (lVar.mSkinType == 1) {
                            if (this.agH.getDrawable(1) != null) {
                                this.agH.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agH.getDrawable(1) != null) {
                            this.agH.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(this.agH);
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aQx.getIs_bawu() == 1 && "pri_content_assist".equals(aQx.getBawu_type())) {
                        int lb = com.baidu.tbadk.core.util.am.lb(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jIw, lb);
                        lVar.jIw.setTag(Integer.valueOf(lb));
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_content_assist_tip);
                    } else if (aQx.getIs_bawu() == 1 && "pri_manage_assist".equals(aQx.getBawu_type())) {
                        int lb2 = com.baidu.tbadk.core.util.am.lb(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jIw, lb2);
                        lVar.jIw.setTag(Integer.valueOf(lb2));
                        lVar.jIw.setVisibility(0);
                        lVar.jIw.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        lVar.jIw.setVisibility(8);
                        lVar.jIw.setTag(null);
                    }
                } else {
                    lVar.jIw.setVisibility(8);
                    lVar.jIw.setTag(null);
                }
            }
            int i3 = 0;
            if (this.jJa != null && this.jJa.cFc() != null && this.jJa.cFc().cDo() && postData.aQx() != null) {
                i3 = postData.aQx().getLevel_id();
            }
            if (this.jHu != null && this.jHu.cCJ()) {
                i3 = 0;
            }
            if (i3 > 0) {
                lVar.jIL.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.jIL, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                lVar.jIL.setVisibility(8);
            }
            int i4 = 15;
            if (lVar.jIO.getChildCount() == 1) {
                i4 = 13;
            } else if (lVar.jIO.getChildCount() > 1) {
                i4 = 11;
            }
            if (lVar.jIw.getVisibility() == 0) {
                i4 -= 2;
            }
            if (lVar.jIN.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.aRX() > 1000) {
                i4 -= 2;
            }
            if (postData.aRX() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                lVar.jIO.setVisibility(8);
                if (lVar.jIO.getChildCount() == 1) {
                    i4 += 2;
                } else if (lVar.jIO.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && lVar.jIw.getVisibility() == 0) {
                    i4 += 2;
                    lVar.jIw.setVisibility(8);
                }
                if (i4 < 10 && lVar.jIL.getVisibility() == 0) {
                    i4 += 2;
                    lVar.jIL.setVisibility(8);
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
                lVar.gqT.setText(dk(postData.aQx().getSealPrefix(), name_show2));
            } else {
                lVar.gqT.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.ddu()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aQx() != null && !StringUtils.isNull(postData.aQx().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.jHu != null && this.jHu.cCx() != 0) {
                if (this.jHu.cCx() != 1002 && this.jHu.cCx() != 3) {
                    z10 = true;
                }
                if (this.jHu.cCx() != 3 && !this.jHu.cCJ()) {
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
                        if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCi().aQx() != null && postData.aQx() != null) {
                            userId = this.jHu.cCi().aQx().getUserId();
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
                                if (postData.ddu() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHu.cCx()));
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
                                    if (this.jHu.cCi() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.jHu.cCi().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.jHu.cCx()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                lVar.jIE.setTag(sparseArray);
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
                        if (postData.ddu() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        lVar.jIE.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.jHu != null) {
                userId = this.jHu.cCi().aQx().getUserId();
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
            if (postData.ddu() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            lVar.jIE.setTag(sparseArray);
        }
    }

    private void f(l lVar, PostData postData) {
        if (lVar != null && postData != null && postData.aSp() != null) {
            postData.aSp().threadId = this.jJa.cDy().cFt();
            postData.aSp().objType = 1;
            postData.aSp().isInPost = true;
            bk bkVar = null;
            if (this.jHu != null && this.jHu.cCi() != null) {
                bkVar = this.jHu.cCi();
            }
            if (bkVar != null && bkVar.aSx()) {
                lVar.jIB.setAgreeAlone(true);
            }
            lVar.jIB.setThreadData(bkVar);
            lVar.jIB.setData(postData.aSp());
        }
    }

    private void g(l lVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (lVar != null && postData != null) {
            if (postData.ddu() > 0 && this.jHu != null && !this.jHu.cCJ()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.ddu()));
                lVar.jIK.setVisibility(0);
                lVar.jIK.setText(format);
                z = true;
            } else {
                lVar.jIK.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f ddx = postData.ddx();
            boolean z2 = (ddx == null || StringUtils.isNull(ddx.getName()) || this.jHu == null || this.jHu.cCJ()) ? false : true;
            if (z) {
                lVar.jIy.setVisibility(0);
                i = this.jIk;
            } else {
                lVar.jIy.setVisibility(8);
                i = 0;
            }
            if (z2) {
                lVar.jIz.setVisibility(0);
                i2 = this.jIk;
            } else {
                lVar.jIz.setVisibility(8);
                i2 = 0;
            }
            lVar.jIx.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                lVar.jIx.setText(com.baidu.tbadk.core.util.aq.getFormatTimeShort(postData.getTime()));
            } else {
                lVar.jIx.setText(com.baidu.tbadk.core.util.aq.getFormatTime(postData.getTime()));
            }
            if (z2) {
                lVar.jIA.setVisibility(0);
                lVar.jIA.setPadding(this.jIk, 0, 0, 0);
                if (postData.llE) {
                    lVar.jIA.setText(com.baidu.tbadk.core.util.aq.cutStringWithSuffix(ddx.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    lVar.jIA.setText(ddx.getName());
                    return;
                }
            }
            lVar.jIA.setVisibility(8);
        }
    }

    private void a(l lVar, PostData postData, View view) {
        if (lVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jIE.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            lVar.jIE.setPadding(0, 0, 0, 0);
            if (!this.jHv) {
                lVar.jIE.getLayoutStrategy().ob(R.drawable.icon_click);
            } else {
                lVar.jIE.ze(null);
                lVar.jIE.setBackgroundDrawable(null);
                lVar.jIE.getLayoutStrategy().ob(R.drawable.transparent_bg);
            }
            lVar.jIE.getLayoutStrategy().nY(R.drawable.pic_video);
            a(lVar.jIE, view, !StringUtils.isNull(postData.getBimg_url()));
            lVar.jIE.setLayoutParams(layoutParams);
            lVar.jIE.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            lVar.jIE.setIsFromCDN(this.mIsFromCDN);
            TbRichText ddw = postData.ddw();
            lVar.jIE.setIsUseGridImage(postData.ddH());
            lVar.jIE.setText(ddw, true, this.jIl);
            SparseArray sparseArray = (SparseArray) lVar.jIE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            lVar.jIE.setTag(sparseArray);
            lVar.jIv.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().nZ(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eDe = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oa((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            if (postData.ddy() > 0) {
                lVar.jII.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) lVar.jII.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    lVar.jII.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.ddG() == 2) {
                    lVar.jII.setVisibility(8);
                } else {
                    lVar.jII.setVisibility(0);
                }
                lVar.jIH.setVisibility(8);
            }
            if (this.jIn) {
                if (lVar.jIJ != null) {
                    SparseArray sparseArray2 = (SparseArray) lVar.jIJ.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        lVar.jIJ.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (lVar.igT != null) {
                    SparseArray sparseArray3 = (SparseArray) lVar.igT.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        lVar.igT.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (TbSingleton.getInstance().isPbFold()) {
                if (postData.ddy() > 0) {
                    lVar.jIH.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.ddy())));
                    SparseArray sparseArray4 = (SparseArray) lVar.jIH.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        lVar.jIH.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                    lVar.jIH.setVisibility(0);
                    lVar.jII.setVisibility(8);
                    lVar.jIG.setVisibility(8);
                }
            } else {
                lVar.jIH.setVisibility(8);
                if (postData.ddy() > 0 && postData.ddr() != null && postData.ddr().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lVar.jIG.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    lVar.jIG.setLayoutParams(layoutParams);
                    if (this.jIm == null) {
                        this.jIm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.jIm.setIsFromCDN(this.mIsFromCDN);
                        this.jIm.setOnLongClickListener(this.mOnLongClickListener);
                        this.jIm.T(this.jHE);
                        this.jIm.y(this.aIH);
                        String str = null;
                        if (this.jHu != null && this.jHu.cCi() != null && this.jHu.cCi().aQx() != null) {
                            str = this.jHu.cCi().aQx().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.jHu != null) {
                            this.jIm.Y(this.jHu.cCx(), z);
                            this.jIm.setThreadData(this.jHu.cCi());
                        }
                    }
                    this.jIm.JO(postData.getId());
                    lVar.jIG.setSubPbAdapter(this.jIm);
                    lVar.jIG.setVisibility(0);
                    lVar.jIG.setData(postData, view);
                    lVar.jIG.setChildOnClickListener(this.aIH);
                    lVar.jIG.setChildOnLongClickListener(this.mOnLongClickListener);
                    lVar.jIG.setChildOnTouchListener(this.jIp);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) lVar.jIG.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    lVar.jIG.setLayoutParams(layoutParams2);
                    lVar.jIG.setVisibility(8);
                }
            }
            if (postData.llu) {
                lVar.mBottomLine.setVisibility(0);
            } else {
                lVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(l lVar, PostData postData) {
        if (lVar != null && lVar.jIT != null && lVar.jIQ != null) {
            if (postData == null || postData.lly == null || StringUtils.isNull(postData.lly.liveTitle)) {
                lVar.jIQ.setVisibility(8);
                return;
            }
            lVar.jIT.setText(postData.lly.liveTitle);
            lVar.jIQ.setTag(postData.lly);
            lVar.jIQ.setVisibility(0);
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.jIY.setVisibility((!postData.llE || this.jIo) ? 8 : 0);
        }
    }

    private void a(l lVar) {
        LayerDrawable layerDrawable;
        if (lVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (lVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.gqT, R.color.cp_cont_b, 1);
                if (lVar.jIw.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jIw, ((Integer) lVar.jIw.getTag()).intValue());
                } else if (lVar.jIw.getTag() instanceof String) {
                    if (lVar.jIw.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.agG;
                    } else if (lVar.jIw.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.agH;
                    } else {
                        layerDrawable = lVar.jIw.getTag().equals("HOST") ? this.jFW : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (lVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        lVar.jIw.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIx, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIy, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIz, (int) R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIK, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIA, R.color.cp_cont_d, 1);
                lVar.jIE.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.am.setBackgroundColor(lVar.jIG, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIH, (int) R.color.cp_cont_c);
                lVar.jIH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jII, (int) R.color.cp_cont_c);
                if (this.jIn) {
                    SvgManager.aUV().a(lVar.jIJ, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUV().a(lVar.igT, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                lVar.jIG.onChangeSkinType();
                lVar.jIF.onChangeSkinType();
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIT, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIR, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jIQ, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.am.setBackgroundResource(lVar.jIS, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.setImageResource(lVar.jIU, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.am.setViewTextColor(lVar.jIX, (int) R.color.cp_cont_c);
                if (lVar.jIV.getVisibility() == 8) {
                    lVar.jIX.setText(R.string.close_content);
                } else if (this.jHu != null && StringUtils.isNull(this.jHu.cCt())) {
                    lVar.jIX.setText(this.jHu.cCt());
                } else {
                    lVar.jIX.setText(R.string.expand_content);
                }
                lVar.jIB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                lVar.yw(skinType);
            }
            lVar.mSkinType = skinType;
        }
    }

    private void b(final l lVar) {
        lVar.jIv.setOnTouchListener(this.jIp);
        lVar.jIv.setOnLongClickListener(this.mOnLongClickListener);
        if (this.jJa.cFc() != null && this.jJa.cFc().getPageContext() != null && this.jJa.cFc().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.jJa.cFc().jGR;
            lVar.gqT.setOnClickListener(aVar.gWJ);
            lVar.jID.setOnClickListener(aVar.gWJ);
            lVar.jIM.setOnClickListener(aVar.gWJ);
            lVar.jIM.getHeadView().setOnClickListener(aVar.gWJ);
            lVar.jIE.setOnLongClickListener(this.mOnLongClickListener);
            lVar.jIE.setOnTouchListener(this.jIp);
            lVar.jIE.setCommonTextViewOnClickListener(this.aIH);
            lVar.jIE.setOnImageClickListener(this.eBC);
            lVar.jIE.setOnImageTouchListener(this.jIp);
            lVar.jIE.setOnEmotionClickListener(aVar.jWf);
            lVar.jIE.setOnVoiceAfterClickListener(this.aIH);
            lVar.jIP.setOnClickListener(this.aIH);
            lVar.jIQ.setOnClickListener(this.aIH);
            lVar.jIH.setOnClickListener(this.aIH);
            lVar.jII.setOnClickListener(this.aIH);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.jJa.cFc().jGS;
            if (this.jIn) {
                lVar.jIJ.setOnClickListener(this.aIH);
                lVar.igT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && lVar.jIv != null && cVar != null) {
                                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.jWu.a(k.this.jHu, null, postData, lVar.jIv);
                                    }
                                }, 100L);
                                String threadId = k.this.jHu.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(k.this.jHu.getThreadId())) && k.this.jHu.cCi() != null) {
                                    threadId = k.this.jHu.cCi().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13700").dh("tid", threadId).dh("fid", k.this.jHu.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData.getId()).ag("obj_type", 4));
                            }
                        }
                    }
                });
                lVar.jIB.dRF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && k.this.jHu != null && lVar != null && lVar.jIB != null && lVar.jIB.getData() != null) {
                            int i = view == lVar.jIB.getImgAgree() ? 1 : 2;
                            String threadId = k.this.jHu.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.jHu.getThreadId())) && k.this.jHu.cCi() != null) {
                                threadId = k.this.jHu.cCi().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13700").dh("tid", threadId).dh("fid", k.this.jHu.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", lVar.jIB.getData().postId).ag("obj_type", i));
                        }
                    }
                };
            }
        }
    }

    private void rY() {
        this.agG = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(this.jFV).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVB(), com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(this.jFV).wJ("#4D000000").aVB()});
        this.agH = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(this.jFV).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVB(), com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(this.jFV).wJ("#4D000000").aVB()});
        this.jFW = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(this.jFV).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).aVB(), com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(this.jFV).wJ("#4D000000").aVB()});
    }

    public void a(TbRichTextView.c cVar) {
        this.jIl = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jHu = eVar;
    }

    public void fl(String str) {
        this.aPJ = str;
    }

    public void re(boolean z) {
        this.jHv = z;
    }

    private SpannableStringBuilder dk(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.jJa.cFc(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(l lVar) {
        lVar.jIE.setTextViewOnTouchListener(this.efF);
        lVar.jIE.setTextViewCheckSelection(false);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jHE = onClickListener;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.efF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
