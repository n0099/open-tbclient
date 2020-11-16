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
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
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
/* loaded from: classes21.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aIJ;
    private View.OnClickListener aYm;
    private String bgd;
    private TbRichTextView.i fFy;
    private boolean fII;
    private com.baidu.tieba.pb.a.c fgS;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iOy;
    private com.baidu.adp.lib.d.b<TbImageView> iOz;
    protected com.baidu.tieba.pb.data.f lqK;
    private boolean lqL;
    private View.OnClickListener lqU;
    private int lrA;
    private TbRichTextView.c lrB;
    private com.baidu.tieba.pb.pb.sub.b lrC;
    private boolean lrD;
    private boolean lrE;
    private boolean lrF;
    private com.baidu.tieba.pb.a.c lrG;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.lrD && nVar.lsk != null && nVar.lsk.getData() != null) {
                nVar.lsk.brs();
            }
            if (nVar.lrT != null && nVar.lrT.getData() != null) {
                nVar.lrT.brs();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lrA = 0;
        this.lrB = null;
        this.lqL = true;
        this.bgd = null;
        this.lqK = null;
        this.lqU = null;
        this.aYm = null;
        this.fFy = null;
        this.fgS = null;
        this.mOnLongClickListener = null;
        this.lrC = null;
        this.fII = true;
        this.lrD = com.baidu.tbadk.a.d.bhn();
        this.lrE = com.baidu.tbadk.a.d.bho();
        this.lrF = com.baidu.tbadk.a.d.bhi();
        this.iOy = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAy */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(m.this.mContext);
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
        this.iOz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsp */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(m.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.common_color_10043));
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
        this.lrG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.lpX == null || m.this.lpX.djM() == null || m.this.lpX.djM().dmL())) {
                    if (view instanceof RelativeLayout) {
                        m.this.dl(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.dl((RelativeLayout) parent);
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
                if (m.this.fgS != null) {
                    if (!(view instanceof TbListTextView) || m.this.aYm == null) {
                        m.this.fgS.ad(view);
                        m.this.fgS.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aYm.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.diV() != null) {
            this.aIJ = bVar.diV().dlE();
        }
        this.lrA = getDimensionPixelSize(R.dimen.tbds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lsC.dkB().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aIJ, this.lrD, this.lrE);
        nVar.lrW.setConstrainLayoutPool(this.iOy);
        nVar.lrW.setImageViewPool(this.iOz);
        if (nVar.lrY != null) {
            nVar.lrY.setShowChildComment(this.lrE);
        }
        a(nVar);
        if (nVar.lrV != null) {
            nVar.lrV.setDuiEnabled(this.fII);
        }
        return nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, n nVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) nVar);
        a(nVar);
        b(nVar);
        c(nVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            j(postData2);
            l(postData2);
            postData2.bmQ();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fII = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.mYD) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ar b = com.baidu.tieba.pb.c.a.b(this.lqK, postData, postData.locate, i, 6);
            postData.mYE = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dJN())) {
                Iterator<PostData> it = postData.dJN().iterator();
                while (it.hasNext()) {
                    it.next().mYE = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.lrD && this.lrE) {
                nVar.lrX.setVisibility(8);
                nVar.lsc.setVisibility(0);
            } else if (this.lrD) {
                nVar.lsc.setVisibility(0);
                nVar.lrX.setVisibility(0);
                nVar.lsb.setVisibility(8);
                nVar.jKJ.setVisibility(8);
                nVar.lrT.setVisibility(8);
            } else {
                nVar.lsc.setVisibility(8);
                nVar.lrX.setVisibility(0);
                nVar.lsb.setVisibility(0);
                nVar.jKJ.setVisibility(0);
                nVar.lrT.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.lrD);
            a(nVar, postData, view);
            c(nVar, postData, view, i);
            g(nVar, postData);
            a(nVar, postData);
            h(nVar, postData);
            c(nVar, postData);
            e(nVar, postData);
            i(nVar, postData);
            b(nVar, postData);
        }
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.lrN != null) {
            if (this.lsC != null && this.lsC.diV() != null && this.lsC.diV().dlM() && com.baidu.tbadk.core.util.au.equals(this.lsC.diV().dkT(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lrN, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lrN, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.lsx.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.lsz.setText(R.string.expand_content);
                return;
            } else {
                nVar.lsz.setText(str);
                return;
            }
        }
        nVar.lsx.setVisibility(0);
        nVar.lsz.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dKc() == 2 || postData.dKc() == 4) {
            nVar.lsy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.lsx.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.dhS());
                    postData.xv(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.lpX != null && m.this.lpX.djM() != null && m.this.lpX.djM().dnP() != null && m.this.lpX.djM().getListView() != null && !z && nVar.getView().getTop() < m.this.lpX.djM().dnP().getMeasuredHeight()) {
                        m.this.lpX.djM().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.lpX.djM().getListView().getData(), postData) + m.this.lpX.djM().getListView().getHeaderViewsCount(), m.this.lpX.djM().dnP().getMeasuredHeight());
                    }
                }
            });
            nVar.lsy.setVisibility(0);
            a(nVar, postData.dJL(), postData.dhS());
            a(true, nVar, postData);
        } else {
            nVar.lsy.setVisibility(8);
            nVar.lsx.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.lsy != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.lsy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dJN());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.lsy.getLayoutParams();
            if (z) {
                nVar.lrV.getLayoutStrategy().sT(0);
                if (z2) {
                    nVar.lrV.getLayoutStrategy().sS(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.lrV.getLayoutStrategy().sS(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.lsy.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.lrV.getLayoutStrategy().sS(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.lrV.getLayoutStrategy().sT(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.lrD) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0);
                } else {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                }
                nVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, PostData postData) {
        TbRichText dJS = postData.dJS();
        dJS.isChanged = true;
        nVar.lrV.setText(dJS, true, this.lrB);
    }

    private void j(PostData postData) {
        if (postData.eDz == 0 && postData.iQX) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12203");
            arVar.dR("post_id", postData.getId());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("cuid", TbadkCoreApplication.getInst().getCuid());
            arVar.dR("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            arVar.dR("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            arVar.dR("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            arVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lsC != null) {
                int dlE = this.lsC.diV().dlE();
                if (1 == dlE || 2 == dlE) {
                    arVar.dR("obj_source", "1");
                } else if (3 == dlE) {
                    arVar.dR("obj_source", "2");
                } else {
                    arVar.dR("obj_source", "0");
                }
            }
            TiebaStatic.log(arVar);
            if (postData.blC() != null && postData.blC().getAlaInfo() != null && postData.blC().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.blC().getUserId();
        String forumId = this.lqK != null ? this.lqK.getForumId() : "";
        String forumName = this.lqK != null ? this.lqK.getForumName() : "";
        int dJQ = postData.dJQ();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13714");
        arVar.dR("fid", forumId);
        arVar.dR("fname", forumName);
        arVar.dR("obj_param1", userId);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("tid", id);
        arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, dJQ);
        TiebaStatic.log(arVar);
    }

    private void l(PostData postData) {
        if (this.lqK != null) {
            if (this.lqK.dih()) {
                if (this.lsD != null) {
                    com.baidu.tieba.pb.c.a.a(this.lsD.getUniqueId(), this.lqK, postData, postData.locate, postData.mYD ? 2 : 8);
                }
            } else if (this.lpX != null) {
                com.baidu.tieba.pb.c.a.a(this.lpX.getUniqueId(), this.lqK, postData, postData.locate, postData.mYD ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.dpH() == null) {
            nVar.lsr.setVisibility(8);
            return;
        }
        TbRichText dJS = postData.dJS();
        com.baidu.tieba.pb.view.b.a(postData.dpH(), nVar.lsr, false, false, dJS != null && StringUtils.isNull(dJS.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lqL) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrV.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lrV.setLayoutParams(layoutParams);
            nVar.lrV.setPadding(0, 0, 0, 0);
            nVar.lrV.El(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lrV.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lrV.setLayoutParams(layoutParams2);
            nVar.lrV.El(postData.getBimg_url());
        }
        nVar.lrV.setTextViewOnTouchListener(this.lrG);
        nVar.lrV.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:245:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(n nVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (nVar != null && postData != null) {
            if (postData.blC() == null || postData.blC().isBaijiahaoUser()) {
            }
            if (postData.mYu) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.CAM_X0204);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.lrU.setTag(null);
            nVar.lrU.setUserId(null);
            nVar.hGe.setText((CharSequence) null);
            nVar.lsn.getHeadView().setUserId(null);
            nVar.lrV.setIsHost(false);
            if (postData.blC() != null) {
                if (this.bgd != null && !this.bgd.equals("0") && this.bgd.equals(postData.blC().getUserId())) {
                    nVar.lrV.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.blC().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.blC().getTShowInfoNew();
                if (nVar.lsp != null) {
                    nVar.lsp.setTag(R.id.tag_user_id, postData.blC().getUserId());
                    if (this.lsC != null && this.lsC.dkB() != null) {
                        nVar.lsp.setOnClickListener(this.lsC.dkB().lqj.lGr);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    nVar.lsp.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (nVar.lso != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lso.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lsC != null && this.lsC.dkB() != null) {
                        nVar.lso.setOnClickListener(this.lsC.dkB().lqj.lGs);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    nVar.lso.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.blC().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGe, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGe, R.color.CAM_X0107, 1);
                }
                String avater = postData.blC().getAvater();
                int i2 = 8;
                if (postData.mYD) {
                    i2 = 2;
                }
                nVar.hGe.setTag(R.id.tag_user_id, postData.blC().getUserId());
                nVar.hGe.setTag(R.id.tag_user_name, postData.blC().getUserName());
                nVar.hGe.setTag(R.id.tag_virtual_user_url, postData.blC().getVirtualUserUrl());
                nVar.hGe.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lqK, postData, postData.locate, i2, 2));
                String name_show = postData.blC().getName_show();
                String userName = postData.blC().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hGe.setText(com.baidu.tieba.pb.c.aR(this.mContext, nVar.hGe.getText().toString()));
                    nVar.hGe.setGravity(16);
                    nVar.hGe.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhr());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGe, R.color.CAM_X0312, 1);
                }
                if (postData.blC().getPendantData() != null && !StringUtils.isNull(postData.blC().getPendantData().bjy())) {
                    nVar.lsn.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lsn.a(postData.blC(), 4);
                    nVar.lrU.setVisibility(8);
                    nVar.lsn.setVisibility(0);
                    nVar.lsn.getHeadView().startLoad(avater, 28, false);
                    nVar.lsn.getHeadView().setUserId(postData.blC().getUserId());
                    nVar.lsn.getHeadView().setUserName(postData.blC().getUserName());
                    nVar.lsn.getHeadView().setFid(this.lqK != null ? this.lqK.getForumId() : "");
                    nVar.lsn.getHeadView().setFName(this.lqK != null ? this.lqK.getForumName() : "");
                    nVar.lsn.getHeadView().setFloor(postData.dJQ());
                    nVar.lsn.getHeadView().setTid(postData.getId());
                    nVar.lsn.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lqK, postData, postData.locate, i2, 2));
                    nVar.lsn.BO(postData.blC().getPendantData().bjy());
                } else {
                    nVar.lrU.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lrU, postData.blC(), 4);
                    nVar.lrU.setUserId(postData.blC().getUserId());
                    nVar.lrU.setFid(this.lqK != null ? this.lqK.getForumId() : "");
                    nVar.lrU.setFName(this.lqK != null ? this.lqK.getForumName() : "");
                    nVar.lrU.setFloor(postData.dJQ());
                    nVar.lrU.setTid(postData.getId());
                    nVar.lrU.setUserName(postData.blC().getUserName(), postData.dKa());
                    nVar.lrU.setTag(R.id.tag_virtual_user_url, postData.blC().getVirtualUserUrl());
                    nVar.lrU.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lqK, postData, postData.locate, i2, 2));
                    nVar.lrU.setImageDrawable(null);
                    nVar.lrU.startLoad(avater, 28, false);
                    nVar.lrU.setVisibility(0);
                    nVar.lsn.setVisibility(8);
                }
                if (postData.blC() != null && postData.blC().getAlaInfo() != null && postData.blC().getAlaUserData() != null && postData.blC().getAlaUserData().live_status == 1) {
                    nVar.sN(true);
                    nVar.lrU.setLiveStatus(1);
                    nVar.lrU.setAlaInfo(postData.blC().getAlaInfo());
                    nVar.lsn.getHeadView().setLiveStatus(1);
                    nVar.lsn.getHeadView().setAlaInfo(postData.blC().getAlaInfo());
                } else {
                    nVar.sN(false);
                    nVar.lrU.setLiveStatus(0);
                    nVar.lrU.setAlaInfo(null);
                    nVar.lsn.getHeadView().setLiveStatus(0);
                    nVar.lsn.getHeadView().setAlaInfo(null);
                }
                a(nVar.lrO, postData);
            }
            int i3 = 0;
            if (this.lsC != null && this.lsC.dkB() != null && this.lsC.dkB().diN() && postData.blC() != null) {
                i3 = postData.blC().getLevel_id();
            }
            if (this.lqK != null && this.lqK.dik()) {
                i3 = 0;
            }
            if (i3 > 0) {
                nVar.lsm.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lsm, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                nVar.lsm.setVisibility(8);
            }
            int i4 = 15;
            if (nVar.lsp.getChildCount() == 1) {
                i4 = 13;
            } else if (nVar.lsp.getChildCount() > 1) {
                i4 = 11;
            }
            if (nVar.lrO.getVisibility() == 0) {
                i4 -= 2;
            }
            if (nVar.lso.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bnd() > 1000) {
                i4 -= 2;
            }
            if (postData.bnd() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                nVar.lsp.setVisibility(8);
                if (nVar.lsp.getChildCount() == 1) {
                    i4 += 2;
                } else if (nVar.lsp.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && nVar.lrO.getVisibility() == 0) {
                    i4 += 2;
                    nVar.lrO.setVisibility(8);
                }
                if (i4 < 10 && nVar.lsm.getVisibility() == 0) {
                    i4 += 2;
                    nVar.lsm.setVisibility(8);
                }
            }
            String name_show2 = postData.blC() != null ? postData.blC().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ae.getTextLengthWithEmoji(name_show2);
            if (postData.blC() != null && !StringUtils.isNull(postData.blC().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.blC() != null && !StringUtils.isNull(postData.blC().getSealPrefix())) {
                nVar.hGe.setText(dT(postData.blC().getSealPrefix(), name_show2));
            } else {
                nVar.hGe.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dJQ()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.blC() != null && !StringUtils.isNull(postData.blC().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.lqK != null && this.lqK.dhW() != 0) {
                if (this.lqK.dhW() != 1002 && this.lqK.dhW() != 3) {
                    z10 = true;
                }
                if (this.lqK.dhW() != 3 && !this.lqK.dik()) {
                    z11 = true;
                }
                if (postData != null && postData.blC() != null) {
                    String userId2 = postData.blC().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().blC() != null && postData.blC() != null) {
                            userId = this.lqK.dhH().blC().getUserId();
                            String userId3 = postData.blC().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.blC() != null && UtilHelper.isCurrentAccount(postData.blC().getUserId())) {
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
                                if (postData.dJQ() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqK.dhW()));
                                    if (postData.blC() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.blC().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.blC().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.blC().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.blC() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.blC().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.blC().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.blC().getName_show());
                                    }
                                    if (this.lqK.dhH() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.lqK.dhH().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqK.dhW()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lrV.setTag(sparseArray);
                                if (this.lrD) {
                                    nVar.lsq.setTag(sparseArray);
                                    return;
                                }
                                return;
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
                        if (postData.dJQ() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.lrV.setTag(sparseArray);
                        if (this.lrD) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.lqK != null) {
                userId = this.lqK.dhH().blC().getUserId();
                String userId32 = postData.blC().getUserId();
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
            if (postData.dJQ() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.lrV.setTag(sparseArray);
            if (this.lrD) {
            }
        }
    }

    private void l(TextView textView) {
        if (textView != null) {
            Object tag = textView.getTag();
            if (tag instanceof PostData) {
                a(textView, (PostData) tag);
            }
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lqK != null && this.lqK.dik()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.blC() != null) {
                MetaData blC = postData.blC();
                if (this.bgd != null && !this.bgd.equals("0") && this.bgd.equals(blC.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).pb(R.string.J_X04).pd(R.dimen.L_X01).oT(R.color.CAM_X0302).pc(R.color.CAM_X0302);
                } else if (blC.getIs_bawu() == 1 && postData.dJI()) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (blC.getIs_bawu() == 1 && "pri_content_assist".equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (blC.getIs_bawu() == 1 && "pri_manage_assist".equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.lsq != null && this.lqK != null) {
            if (this.lrD && !this.lqK.dik()) {
                nVar.lsq.setVisibility(0);
                nVar.lsq.setOnClickListener(this.aYm);
                return;
            }
            nVar.lsq.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.bnv() != null) {
            postData.bnv().threadId = this.lsC.diV().dkU();
            postData.bnv().objType = 1;
            postData.bnv().isInPost = true;
            bx bxVar = null;
            if (this.lqK != null && this.lqK.dhH() != null) {
                bxVar = this.lqK.dhH();
            }
            if (z) {
                nVar.lsk.setAgreeAlone(true);
                nVar.lsk.setThreadData(bxVar);
                nVar.lsk.setData(postData.bnv());
            }
            if (bxVar != null && bxVar.bkm()) {
                nVar.lrT.setAgreeAlone(true);
            }
            nVar.lrT.setThreadData(bxVar);
            nVar.lrT.setData(postData.bnv());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dJQ() > 0 && this.lqK != null && !this.lqK.dik()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dJQ()));
                nVar.lsl.setVisibility(0);
                nVar.lsl.setText(format);
                z = true;
            } else {
                nVar.lsl.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dJT = postData.dJT();
            boolean z2 = (dJT == null || StringUtils.isNull(dJT.getName()) || this.lqK == null || this.lqK.dik()) ? false : true;
            if (z) {
                nVar.lrQ.setVisibility(0);
                i = this.lrA;
            } else {
                nVar.lrQ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lrR.setVisibility(0);
                i2 = this.lrA;
            } else {
                nVar.lrR.setVisibility(8);
                i2 = 0;
            }
            nVar.lrP.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lrP.setText(com.baidu.tbadk.core.util.au.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lrP.setText(com.baidu.tbadk.core.util.au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lrS.setVisibility(0);
                nVar.lrS.setPadding(this.lrA, 0, 0, 0);
                if (postData.mYC) {
                    nVar.lrS.setText(com.baidu.tbadk.core.util.au.cutStringWithSuffix(dJT.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.lrS.setText(dJT.getName());
                    return;
                }
            }
            nVar.lrS.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.lrV.setPadding(0, 0, 0, 0);
            if (!this.lqL) {
                nVar.lrV.getLayoutStrategy().sN(R.drawable.icon_click);
            } else {
                nVar.lrV.El(null);
                nVar.lrV.setBackgroundDrawable(null);
                nVar.lrV.getLayoutStrategy().sN(R.drawable.transparent_bg);
            }
            nVar.lrV.getLayoutStrategy().sK(R.drawable.pic_video);
            a(nVar.lrV, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.lrV.setLayoutParams(layoutParams);
            nVar.lrV.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            nVar.lrV.setIsFromCDN(this.mIsFromCDN);
            nVar.lrV.setText(postData.dJS(), true, this.lrB);
            SparseArray sparseArray = (SparseArray) nVar.lrV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.lrV.setTag(sparseArray);
            nVar.lrN.setTag(R.id.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds115) : 0;
            if (this.lrF) {
                tbRichTextView.getLayoutStrategy().sL(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().sL(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fHC = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (this.lrF) {
                tbRichTextView.getLayoutStrategy().sM((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().sM((int) (equipmentWidth * 1.618f));
            }
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dJU() > 0) {
                nVar.lsa.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.lsa.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lsa.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dKc() == 2) {
                    nVar.lsa.setVisibility(8);
                } else if (this.lrD) {
                    nVar.lrX.setVisibility(8);
                } else {
                    nVar.lsa.setVisibility(0);
                }
                nVar.lrZ.setVisibility(8);
            }
            if (this.lrD) {
                if (com.baidu.tbadk.a.d.bhe()) {
                    string = postData.dJU() > 0 ? String.valueOf(postData.dJU()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.lsj.setText(string);
                if (nVar.lse != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.lse.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.lse.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.lsd != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.lsd.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.lsd.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.lsb != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.lsb.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.lsb.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.jKJ != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.jKJ.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.jKJ.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dJU() > 0 && !this.lrE) {
                nVar.lrZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dJU())));
                SparseArray sparseArray6 = (SparseArray) nVar.lrZ.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.lrZ.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.lrZ.setVisibility(0);
                nVar.lsa.setVisibility(8);
                nVar.lrY.setVisibility(8);
            } else {
                nVar.lrZ.setVisibility(8);
                if (this.lrE) {
                    nVar.lsa.setVisibility(8);
                }
                if (postData.dJU() > 0 && postData.dJN() != null && postData.dJN().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrY.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    nVar.lrY.setLayoutParams(layoutParams);
                    if (this.lrC == null) {
                        this.lrC = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lrC.setIsFromCDN(this.mIsFromCDN);
                        this.lrC.setOnLongClickListener(this.mOnLongClickListener);
                        this.lrC.W(this.lqU);
                        this.lrC.B(this.aYm);
                        String str = null;
                        if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhH().blC() != null) {
                            str = this.lqK.dhH().blC().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lqK != null) {
                            this.lrC.af(this.lqK.dhW(), z);
                            this.lrC.setThreadData(this.lqK.dhH());
                        }
                    }
                    this.lrC.PA(postData.getId());
                    nVar.lrY.setSubPbAdapter(this.lrC);
                    nVar.lrY.setVisibility(0);
                    nVar.lrY.setData(postData, view);
                    nVar.lrY.setChildOnClickListener(this.aYm);
                    nVar.lrY.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.lrY.setChildOnTouchListener(this.lrG);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lrY.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.lrY.setLayoutParams(layoutParams2);
                    nVar.lrY.setVisibility(8);
                }
            }
            if (postData.mYs) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.lsv != null && nVar.lss != null) {
            if (postData == null || postData.mYw == null || StringUtils.isNull(postData.mYw.liveTitle)) {
                nVar.lss.setVisibility(8);
                return;
            }
            nVar.lsv.setText(postData.mYw.liveTitle);
            nVar.lss.setTag(postData.mYw);
            nVar.lss.setVisibility(0);
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(arVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lsA.setVisibility(postData.mYC ? 0 : 8);
        }
    }

    private void a(n nVar) {
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                l(nVar.lrO);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGe, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrP, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrQ, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrR, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsl, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrS, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsa, R.color.CAM_X0108);
                nVar.lrV.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ap.c(nVar.lrY, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrZ, R.color.CAM_X0108);
                nVar.lrZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0108), (WebPManager.ResourceStateType) null), (Drawable) null);
                if (this.lrD) {
                    SvgManager.bqB().a(nVar.lsq, R.drawable.ic_icon_pure_close24, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lsi, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.lsg, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    nVar.lsk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsh, R.color.CAM_X0109);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsj, R.color.CAM_X0109);
                } else {
                    WebPManager.a(nVar.lsb, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                    WebPManager.a(nVar.jKJ, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
                nVar.lrY.onChangeSkinType();
                nVar.lrW.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsv, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lst, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lss, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lsu, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lsw, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsz, R.color.CAM_X0107);
                if (nVar.lsx.getVisibility() == 8) {
                    nVar.lsz.setText(R.string.close_content);
                } else if (this.lqK != null && StringUtils.isNull(this.lqK.dhS())) {
                    nVar.lsz.setText(this.lqK.dhS());
                } else {
                    nVar.lsz.setText(R.string.expand_content);
                }
                nVar.lrT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.En(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.CAM_X0203);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.lrN.setOnTouchListener(this.lrG);
        nVar.lrN.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lsC.dkB() != null && this.lsC.dkB().getPageContext() != null && this.lsC.dkB().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lsC.dkB().lqj;
            nVar.hGe.setOnClickListener(aVar.iry);
            nVar.lrU.setOnClickListener(aVar.iry);
            nVar.lsn.setOnClickListener(aVar.iry);
            nVar.lsn.getHeadView().setOnClickListener(aVar.iry);
            nVar.lrV.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lrV.setOnTouchListener(this.lrG);
            nVar.lrV.setCommonTextViewOnClickListener(this.aYm);
            nVar.lrV.setOnImageClickListener(this.fFy);
            nVar.lrV.setOnImageTouchListener(this.lrG);
            nVar.lrV.setOnEmotionClickListener(aVar.lGt);
            nVar.lrV.setOnVoiceAfterClickListener(this.aYm);
            nVar.lsr.setOnClickListener(this.aYm);
            nVar.lss.setOnClickListener(this.aYm);
            nVar.lrZ.setOnClickListener(this.aYm);
            nVar.lsa.setOnClickListener(this.aYm);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lsC.dkB().lqk;
            if (this.lrD) {
                nVar.lse.setOnClickListener(this.aYm);
                nVar.lsd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrN != null && cVar != null) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.lGI.a(m.this.lqK, null, postData, nVar.lrV.getLayoutStrategy());
                                    }
                                }, 100L);
                                String threadId = m.this.lqK.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqK.getThreadId())) && m.this.lqK.dhH() != null) {
                                    threadId = m.this.lqK.dhH().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", m.this.lqK.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ak("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.lsk.eQc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.lqK != null && nVar != null && nVar.lsk != null && nVar.lsk.getData() != null) {
                            int i = view == nVar.lsk.getImgAgree() ? 1 : 2;
                            String threadId = m.this.lqK.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqK.getThreadId())) && m.this.lqK.dhH() != null) {
                                threadId = m.this.lqK.dhH().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", m.this.lqK.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lsk.getData().postId).ak("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.lsb.setOnClickListener(this.aYm);
            nVar.jKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrN != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lGI.a(m.this.lqK, null, postData, nVar.lrV.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = m.this.lqK.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqK.getThreadId())) && m.this.lqK.dhH() != null) {
                                threadId = m.this.lqK.dhH().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", m.this.lqK.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ak("obj_type", 4));
                        }
                    }
                }
            });
            nVar.lrT.eQc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.lqK != null && nVar != null && nVar.lrT != null && nVar.lrT.getData() != null) {
                        int i = view == nVar.lrT.getImgAgree() ? 1 : 2;
                        String threadId = m.this.lqK.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqK.getThreadId())) && m.this.lqK.dhH() != null) {
                            threadId = m.this.lqK.dhH().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", m.this.lqK.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lrT.getData().postId).ak("obj_type", i));
                    }
                }
            };
        }
    }

    public void a(TbRichTextView.c cVar) {
        this.lrB = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqK = fVar;
    }

    public void hy(String str) {
        this.bgd = str;
    }

    public void tW(boolean z) {
        this.lqL = z;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.lsC.dkB(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.lrV.setTextViewOnTouchListener(this.fgS);
        nVar.lrV.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lqU = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
