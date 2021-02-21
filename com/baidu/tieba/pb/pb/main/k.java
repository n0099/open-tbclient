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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.BitmapHelper;
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
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class k extends l<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    private int aJY;
    private View.OnClickListener bbI;
    private String bkB;
    private TbRichTextView.i fUw;
    private boolean fXF;
    private com.baidu.tieba.pb.a.c fvK;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmT;
    private com.baidu.adp.lib.d.b<TbImageView> jmU;
    private int jxi;
    protected com.baidu.tieba.pb.data.f lOi;
    private boolean lOj;
    private View.OnClickListener lOs;
    private TbRichTextView.c lPb;
    private com.baidu.tieba.pb.pb.sub.b lPc;
    private boolean lPd;
    private boolean lPe;
    private com.baidu.tieba.pb.a.c lPf;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(View view) {
        if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
            if (com.baidu.tbadk.a.d.bjj() || com.baidu.tbadk.a.d.bjk()) {
                if (pbCommenFloorItemViewHolder.lPZ != null && pbCommenFloorItemViewHolder.lPZ.getData() != null) {
                    pbCommenFloorItemViewHolder.lPZ.btL();
                }
            } else if (pbCommenFloorItemViewHolder.lPr != null && pbCommenFloorItemViewHolder.lPr.getData() != null) {
                pbCommenFloorItemViewHolder.lPr.btL();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jxi = 0;
        this.lPb = null;
        this.lOj = true;
        this.bkB = null;
        this.lOi = null;
        this.lOs = null;
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lPc = null;
        this.fXF = true;
        this.lPd = com.baidu.tbadk.a.d.biZ();
        this.lPe = false;
        this.jmT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFm */
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
        this.jmU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buL */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
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
        this.lPf = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.lNm == null || k.this.lNm.dnr() == null || k.this.lNm.dnr().dqt())) {
                    if (view instanceof RelativeLayout) {
                        k.this.dA(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                k.this.dA((RelativeLayout) parent);
                                break;
                            } else {
                                parent = parent.getParent();
                                i++;
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
                if (k.this.fvK != null) {
                    if (!(view instanceof TbListTextView) || k.this.bbI == null) {
                        k.this.fvK.ad(view);
                        k.this.fvK.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.bbI.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.dmx() != null) {
            this.aJY = bVar.dmx().dpl();
        }
        this.jxi = getDimensionPixelSize(R.dimen.tbds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate;
        View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate2.findViewById(R.id.pb_post_reply_container);
        if (com.baidu.tbadk.a.d.bjl()) {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_c, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null);
        }
        viewGroup2.addView(inflate);
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.lQj.doh().getPageContext(), inflate2, this.aJY, this.lPd);
        pbCommenFloorItemViewHolder.lPu.setConstrainLayoutPool(this.jmT);
        pbCommenFloorItemViewHolder.lPu.setImageViewPool(this.jmU);
        if (pbCommenFloorItemViewHolder.lPw != null) {
            pbCommenFloorItemViewHolder.lPw.setShowChildComment(this.lPd);
        }
        a(pbCommenFloorItemViewHolder);
        if (pbCommenFloorItemViewHolder.lPt != null) {
            pbCommenFloorItemViewHolder.lPt.setDuiEnabled(this.fXF);
        }
        return pbCommenFloorItemViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) pbCommenFloorItemViewHolder);
        a(pbCommenFloorItemViewHolder);
        b(pbCommenFloorItemViewHolder);
        c(pbCommenFloorItemViewHolder);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            j(postData2);
            l(postData2);
            postData2.bpd();
            i(postData2);
            a(pbCommenFloorItemViewHolder, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fXF = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.nxS) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ar b2 = com.baidu.tieba.pb.c.a.b(this.lOi, postData, postData.locate, i, 6);
            postData.nxT = b2;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dNC())) {
                Iterator<PostData> it = postData.dNC().iterator();
                while (it.hasNext()) {
                    it.next().nxT = b2;
                }
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lPz.setVisibility(8);
            if (com.baidu.tbadk.a.d.bjj()) {
                pbCommenFloorItemViewHolder.lPY.setVisibility(0);
                pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                pbCommenFloorItemViewHolder.lQb.setVisibility(8);
                pbCommenFloorItemViewHolder.jTF.setVisibility(8);
                pbCommenFloorItemViewHolder.jTD.setVisibility(8);
                pbCommenFloorItemViewHolder.lPr.setVisibility(8);
                pbCommenFloorItemViewHolder.lQe.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bjk()) {
                pbCommenFloorItemViewHolder.lPY.setVisibility(0);
                pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                pbCommenFloorItemViewHolder.lQb.setVisibility(0);
                pbCommenFloorItemViewHolder.jTF.setVisibility(8);
                pbCommenFloorItemViewHolder.jTD.setVisibility(8);
                pbCommenFloorItemViewHolder.lPr.setVisibility(8);
                pbCommenFloorItemViewHolder.lQe.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bjl()) {
                pbCommenFloorItemViewHolder.lQb.setVisibility(8);
                pbCommenFloorItemViewHolder.lPY.setVisibility(8);
                pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                pbCommenFloorItemViewHolder.jTF.setVisibility(0);
                pbCommenFloorItemViewHolder.jTD.setVisibility(0);
                pbCommenFloorItemViewHolder.lPr.setVisibility(0);
                pbCommenFloorItemViewHolder.lQe.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.lPY.setVisibility(8);
                pbCommenFloorItemViewHolder.lQb.setVisibility(8);
                pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                pbCommenFloorItemViewHolder.jTF.setVisibility(0);
                pbCommenFloorItemViewHolder.jTD.setVisibility(0);
                pbCommenFloorItemViewHolder.lPr.setVisibility(0);
                pbCommenFloorItemViewHolder.lQe.setVisibility(8);
            }
            b(pbCommenFloorItemViewHolder, postData, view, i);
            f(pbCommenFloorItemViewHolder, postData);
            g(pbCommenFloorItemViewHolder, postData);
            a(pbCommenFloorItemViewHolder, postData, view);
            c(pbCommenFloorItemViewHolder, postData, view, i);
            h(pbCommenFloorItemViewHolder, postData);
            a(pbCommenFloorItemViewHolder, postData);
            i(pbCommenFloorItemViewHolder, postData);
            c(pbCommenFloorItemViewHolder, postData);
            e(pbCommenFloorItemViewHolder, postData);
            j(pbCommenFloorItemViewHolder, postData);
            b(pbCommenFloorItemViewHolder, postData);
            k(pbCommenFloorItemViewHolder, postData);
        }
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPl != null) {
            if (this.lQj != null && this.lQj.dmx() != null && this.lQj.dmx().dpt() && com.baidu.tbadk.core.util.au.equals(this.lQj.dmx().doz(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.lPl, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.lPl, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        if (z) {
            pbCommenFloorItemViewHolder.lPU.setVisibility(8);
            if (StringUtils.isNull(str)) {
                pbCommenFloorItemViewHolder.lPW.setText(R.string.expand_content);
                return;
            } else {
                pbCommenFloorItemViewHolder.lPW.setText(str);
                return;
            }
        }
        pbCommenFloorItemViewHolder.lPU.setVisibility(0);
        pbCommenFloorItemViewHolder.lPW.setText(R.string.close_content);
    }

    private void c(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final PostData postData) {
        if (postData.dNR() == 2 || postData.dNR() == 4) {
            pbCommenFloorItemViewHolder.lPV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = pbCommenFloorItemViewHolder.lPU.getVisibility() == 8;
                    k.this.a(pbCommenFloorItemViewHolder, !z, postData.dlr());
                    postData.yt(z ? false : true);
                    k.this.d(pbCommenFloorItemViewHolder, postData);
                    if (k.this.lNm != null && k.this.lNm.dnr() != null && k.this.lNm.dnr().dry() != null && k.this.lNm.dnr().getListView() != null && !z && pbCommenFloorItemViewHolder.getView().getTop() < k.this.lNm.dnr().dry().getMeasuredHeight()) {
                        k.this.lNm.dnr().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(k.this.lNm.dnr().getListView().getData(), postData) + k.this.lNm.dnr().getListView().getHeaderViewsCount(), k.this.lNm.dnr().dry().getMeasuredHeight());
                    }
                }
            });
            pbCommenFloorItemViewHolder.lPV.setVisibility(0);
            a(pbCommenFloorItemViewHolder, postData.dNA(), postData.dlr());
            a(true, pbCommenFloorItemViewHolder, postData);
        } else {
            pbCommenFloorItemViewHolder.lPV.setVisibility(8);
            pbCommenFloorItemViewHolder.lPU.setVisibility(0);
            a(false, pbCommenFloorItemViewHolder, postData);
        }
        d(pbCommenFloorItemViewHolder, postData);
    }

    private void a(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.mBottomLine != null && pbCommenFloorItemViewHolder.lPV != null && (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.lPV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dNC());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.lPV.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sg(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.lPV.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        TbRichText dNH = postData.dNH();
        dNH.isChanged = true;
        pbCommenFloorItemViewHolder.lPt.setText(dNH, true, this.lPb);
    }

    private void j(PostData postData) {
        if (postData.eRW == 0 && postData.jpu) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12203");
            arVar.dR("post_id", postData.getId());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("cuid", TbadkCoreApplication.getInst().getCuid());
            arVar.dR("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            arVar.dR("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            arVar.dR("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            arVar.v(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lQj != null) {
                int dpl = this.lQj.dmx().dpl();
                if (1 == dpl || 2 == dpl) {
                    arVar.dR("obj_source", "1");
                } else if (3 == dpl) {
                    arVar.dR("obj_source", "2");
                } else {
                    arVar.dR("obj_source", "0");
                }
            }
            TiebaStatic.log(arVar);
            if (postData.bnQ() != null && postData.bnQ().getAlaInfo() != null && postData.bnQ().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.bnQ().getUserId();
        String forumId = this.lOi != null ? this.lOi.getForumId() : "";
        String forumName = this.lOi != null ? this.lOi.getForumName() : "";
        int dNF = postData.dNF();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13714");
        arVar.dR("fid", forumId);
        arVar.dR("fname", forumName);
        arVar.dR("obj_param1", userId);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("tid", id);
        arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, dNF);
        TiebaStatic.log(arVar);
    }

    private void l(PostData postData) {
        if (this.lOi != null) {
            if (this.lOi.dlG()) {
                if (this.lQk != null) {
                    com.baidu.tieba.pb.c.a.a(this.lQk.getUniqueId(), this.lOi, postData, postData.locate, postData.nxS ? 2 : 8);
                }
            } else if (this.lNm != null) {
                com.baidu.tieba.pb.c.a.a(this.lNm.getUniqueId(), this.lOi, postData, postData.locate, postData.nxS ? 2 : 8);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.dts() == null) {
            pbCommenFloorItemViewHolder.lPO.setVisibility(8);
            return;
        }
        TbRichText dNH = postData.dNH();
        com.baidu.tieba.pb.view.b.a(postData.dts(), pbCommenFloorItemViewHolder.lPO, false, false, dNH != null && StringUtils.isNull(dNH.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lOj) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPt.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lPt.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lPt.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lPt.Ef(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPt.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lPt.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lPt.Ef(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lPt.setTextViewOnTouchListener(this.lPf);
        pbCommenFloorItemViewHolder.lPt.setTextViewCheckSelection(false);
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.bnQ() == null || postData.bnQ().isBaijiahaoUser()) {
            }
            if (postData.nxJ) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lPs.setTag(null);
            pbCommenFloorItemViewHolder.lPs.setUserId(null);
            pbCommenFloorItemViewHolder.ick.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lPK.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lPt.setIsHost(false);
            if (postData.bnQ() != null) {
                if (this.bkB != null && !this.bkB.equals("0") && this.bkB.equals(postData.bnQ().getUserId())) {
                    pbCommenFloorItemViewHolder.lPt.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bnQ().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bnQ().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lPM != null) {
                    pbCommenFloorItemViewHolder.lPM.setTag(R.id.tag_user_id, postData.bnQ().getUserId());
                    if (this.lQj != null && this.lQj.doh() != null) {
                        pbCommenFloorItemViewHolder.lPM.setOnClickListener(this.lQj.doh().lNy.men);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lPM.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lPL != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lPL.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lQj != null && this.lQj.doh() != null) {
                        pbCommenFloorItemViewHolder.lPL.setOnClickListener(this.lQj.doh().lNy.meo);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lPL.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.bnQ().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0107, 1);
                }
                String avater = postData.bnQ().getAvater();
                int i2 = 8;
                if (postData.nxS) {
                    i2 = 2;
                }
                pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_user_id, postData.bnQ().getUserId());
                pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_user_name, postData.bnQ().getUserName());
                pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_virtual_user_url, postData.bnQ().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lOi, postData, postData.locate, i2, 2));
                String name_show = postData.bnQ().getName_show();
                String userName = postData.bnQ().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.ick.setText(com.baidu.tieba.pb.c.aY(this.mContext, pbCommenFloorItemViewHolder.ick.getText().toString()));
                    pbCommenFloorItemViewHolder.ick.setGravity(16);
                    pbCommenFloorItemViewHolder.ick.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkQ());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0312, 1);
                }
                if (postData.bnQ().getPendantData() != null && !StringUtils.isNull(postData.bnQ().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lPK.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lPK.a(postData.bnQ(), 4);
                    pbCommenFloorItemViewHolder.lPs.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPK.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPK.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setUserId(postData.bnQ().getUserId());
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setUserName(postData.bnQ().getUserName());
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setFid(this.lOi != null ? this.lOi.getForumId() : "");
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setFName(this.lOi != null ? this.lOi.getForumName() : "");
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setFloor(postData.dNF());
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lOi, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lPK.Bz(postData.bnQ().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lPs.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lPs, postData.bnQ(), 4);
                    pbCommenFloorItemViewHolder.lPs.setUserId(postData.bnQ().getUserId());
                    pbCommenFloorItemViewHolder.lPs.setFid(this.lOi != null ? this.lOi.getForumId() : "");
                    pbCommenFloorItemViewHolder.lPs.setFName(this.lOi != null ? this.lOi.getForumName() : "");
                    pbCommenFloorItemViewHolder.lPs.setFloor(postData.dNF());
                    pbCommenFloorItemViewHolder.lPs.setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lPs.setUserName(postData.bnQ().getUserName(), postData.dNP());
                    pbCommenFloorItemViewHolder.lPs.setTag(R.id.tag_virtual_user_url, postData.bnQ().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lPs.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lOi, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lPs.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lPs.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lPs.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPK.setVisibility(8);
                }
                if (postData.bnQ() != null && postData.bnQ().getAlaInfo() != null && postData.bnQ().getAlaUserData() != null && postData.bnQ().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.tz(true);
                    pbCommenFloorItemViewHolder.lPs.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lPs.setAlaInfo(postData.bnQ().getAlaInfo());
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setAlaInfo(postData.bnQ().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.tz(false);
                    pbCommenFloorItemViewHolder.lPs.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lPs.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lPK.getHeadView().setAlaInfo(null);
                }
                a(pbCommenFloorItemViewHolder.lPm, postData);
            }
            int i3 = 0;
            if (this.lQj != null && this.lQj.doh() != null && this.lQj.doh().dmp() && postData.bnQ() != null) {
                i3 = postData.bnQ().getLevel_id();
            }
            if (this.lOi != null && this.lOi.dlJ()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.lPJ.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(pbCommenFloorItemViewHolder.lPJ, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                pbCommenFloorItemViewHolder.lPJ.setVisibility(8);
            }
            int i4 = 15;
            if (pbCommenFloorItemViewHolder.lPM.getChildCount() == 1) {
                i4 = 13;
            } else if (pbCommenFloorItemViewHolder.lPM.getChildCount() > 1) {
                i4 = 11;
            }
            if (pbCommenFloorItemViewHolder.lPm.getVisibility() == 0) {
                i4 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lPL.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bpr() > 1000) {
                i4 -= 2;
            }
            if (postData.bpr() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                pbCommenFloorItemViewHolder.lPM.setVisibility(8);
                if (pbCommenFloorItemViewHolder.lPM.getChildCount() == 1) {
                    i4 += 2;
                } else if (pbCommenFloorItemViewHolder.lPM.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lPm.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lPm.setVisibility(8);
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lPJ.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lPJ.setVisibility(8);
                }
            }
            String name_show2 = postData.bnQ() != null ? postData.bnQ().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ag.getTextLengthWithEmoji(name_show2);
            if (postData.bnQ() != null && !StringUtils.isNull(postData.bnQ().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ag.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ag.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.bnQ() != null && !StringUtils.isNull(postData.bnQ().getSealPrefix())) {
                pbCommenFloorItemViewHolder.ick.setText(dT(postData.bnQ().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.ick.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNF()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.lPr);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.lPZ);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.jTF);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.jTD);
            cb cbVar = null;
            if (this.lOi != null && this.lOi.dlg() != null) {
                cbVar = this.lOi.dlg();
            }
            if (cbVar != null && cbVar.bmz()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, true);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, false);
            }
            boolean z4 = false;
            if (postData.bnQ() != null && !StringUtils.isNull(postData.bnQ().getVirtualUserUrl())) {
                z4 = true;
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (this.lOi != null && this.lOi.dlv() != 0) {
                if (this.lOi.dlv() != 1002 && this.lOi.dlv() != 3) {
                    z5 = true;
                }
                if (this.lOi.dlv() != 3 && !this.lOi.dlJ()) {
                    z6 = true;
                }
                if (postData != null && postData.bnQ() != null) {
                    String userId = postData.bnQ().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z5 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z5 = false;
                    }
                }
            }
            if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().bnQ() != null && postData.bnQ() != null) {
                String userId2 = this.lOi.dlg().bnQ().getUserId();
                String userId3 = postData.bnQ().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z6 = true;
                    z7 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z7 = false;
                        z8 = true;
                    }
                }
            }
            if (postData == null || postData.bnQ() == null || !UtilHelper.isCurrentAccount(postData.bnQ().getUserId())) {
                z = z8;
            } else {
                z6 = true;
                z = true;
            }
            if (z4) {
                z2 = false;
                z6 = false;
                z3 = false;
            } else {
                z2 = z7;
                z3 = z5;
            }
            int i5 = 1;
            if (postData.dNF() == 1) {
                i5 = 0;
            }
            if (z3) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lOi.dlv()));
                if (postData.bnQ() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.bnQ().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnQ().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnQ().getPortrait());
                }
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            if (z2) {
                sparseArray.put(R.id.tag_user_mute_visible, true);
                sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.bnQ() != null) {
                    sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnQ().getUserId());
                    sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnQ().getUserName());
                    sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnQ().getName_show());
                }
                if (this.lOi.dlg() != null) {
                    sparseArray.put(R.id.tag_user_mute_thread_id, this.lOi.dlg().getId());
                }
                sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z6) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lOi.dlv()));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            pbCommenFloorItemViewHolder.lPt.setTag(sparseArray);
        }
    }

    private void n(TextView textView) {
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
            if (this.lOi != null && this.lOi.dlJ()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnQ() != null) {
                MetaData bnQ = postData.bnQ();
                if (this.bkB != null && !this.bkB.equals("0") && this.bkB.equals(bnQ.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).og(R.string.J_X04).ok(R.dimen.L_X01).nY(R.color.CAM_X0302).oj(R.color.CAM_X0302);
                } else if (bnQ.getIs_bawu() == 1 && postData.dNx()) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnQ.getIs_bawu() == 1 && "pri_content_assist".equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnQ.getIs_bawu() == 1 && "pri_manage_assist".equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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

    private void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null && pbCommenFloorItemViewHolder.lPN != null && this.lOi != null) {
            pbCommenFloorItemViewHolder.lPN.setVisibility(8);
        }
    }

    private void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.bpJ() != null) {
            postData.bpJ().threadId = this.lQj.dmx().doA();
            postData.bpJ().objType = 1;
            postData.bpJ().isInPost = true;
            cb cbVar = null;
            if (this.lOi != null && this.lOi.dlg() != null) {
                cbVar = this.lOi.dlg();
            }
            if (cbVar != null && cbVar.bmz()) {
                pbCommenFloorItemViewHolder.lPr.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lPr.setThreadData(cbVar);
            pbCommenFloorItemViewHolder.lPr.setData(postData.bpJ());
            pbCommenFloorItemViewHolder.lPZ.setThreadData(cbVar);
            pbCommenFloorItemViewHolder.lPZ.setData(postData.bpJ());
        }
    }

    private void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dNF() > 0 && this.lOi != null && !this.lOi.dlJ()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dNF()));
                pbCommenFloorItemViewHolder.lPI.setVisibility(0);
                pbCommenFloorItemViewHolder.lPI.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lPI.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dNI = postData.dNI();
            boolean z2 = (dNI == null || StringUtils.isNull(dNI.getName()) || this.lOi == null || this.lOi.dlJ()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lPo.setVisibility(0);
                i = this.jxi;
            } else {
                pbCommenFloorItemViewHolder.lPo.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lPp.setVisibility(0);
                i2 = this.jxi;
            } else {
                pbCommenFloorItemViewHolder.lPp.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lPn.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lPn.setText(com.baidu.tbadk.core.util.au.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lPn.setText(com.baidu.tbadk.core.util.au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lPq.setVisibility(0);
                pbCommenFloorItemViewHolder.lPq.setPadding(this.jxi, 0, 0, 0);
                if (postData.nxR) {
                    pbCommenFloorItemViewHolder.lPq.setText(com.baidu.tbadk.core.util.au.cutStringWithSuffix(dNI.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    pbCommenFloorItemViewHolder.lPq.setText(dNI.getName());
                }
            } else {
                pbCommenFloorItemViewHolder.lPq.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lQc.setText(((Object) pbCommenFloorItemViewHolder.lPn.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.bjk()) {
                if (z) {
                    pbCommenFloorItemViewHolder.lQc.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPn.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPo.setVisibility(8);
                    return;
                }
                pbCommenFloorItemViewHolder.lQc.setVisibility(8);
                pbCommenFloorItemViewHolder.lPn.setVisibility(0);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPt.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.lPt.setPadding(0, 0, 0, 0);
            if (!this.lOj) {
                pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sa(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.lPt.Ef(null);
                pbCommenFloorItemViewHolder.lPt.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().sa(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.lPt.getLayoutStrategy().rX(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lPt, view, !StringUtils.isNull(postData.getBimg_url()));
            pbCommenFloorItemViewHolder.lPt.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lPt.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lPt.setIsFromCDN(this.mIsFromCDN);
            pbCommenFloorItemViewHolder.lPt.setText(postData.dNH(), true, this.lPb);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lPt.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbCommenFloorItemViewHolder.lPt.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lPl.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.lQe.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lQa.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().rY(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fWz = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().rZ((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dNJ() > 0) {
                pbCommenFloorItemViewHolder.lPy.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lPy.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lPy.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dNR() == 2) {
                    pbCommenFloorItemViewHolder.lPy.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lPy.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.lPx.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.jTF != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.jTF.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.jTF.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.jTD != null) {
                SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jTD.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.jTD.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            if (postData.dNJ() > 0 && !this.lPd) {
                pbCommenFloorItemViewHolder.lPx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dNJ())));
                SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.lPx.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.lPx.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                pbCommenFloorItemViewHolder.lPx.setVisibility(0);
                pbCommenFloorItemViewHolder.lPy.setVisibility(8);
                pbCommenFloorItemViewHolder.lPw.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.lPx.setVisibility(8);
                if (postData.dNJ() > 0 && postData.dNC() != null && postData.dNC().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPw.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.lPw.setLayoutParams(layoutParams);
                    if (this.lPc == null) {
                        this.lPc = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lPc.setIsFromCDN(this.mIsFromCDN);
                        this.lPc.setOnLongClickListener(this.mOnLongClickListener);
                        this.lPc.Y(this.lOs);
                        this.lPc.C(this.bbI);
                        String str = null;
                        if (this.lOi != null && this.lOi.dlg() != null && this.lOi.dlg().bnQ() != null) {
                            str = this.lOi.dlg().bnQ().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lOi != null) {
                            this.lPc.ad(this.lOi.dlv(), z);
                            this.lPc.setThreadData(this.lOi.dlg());
                        }
                    }
                    this.lPc.PY(postData.getId());
                    pbCommenFloorItemViewHolder.lPw.setSubPbAdapter(this.lPc);
                    pbCommenFloorItemViewHolder.lPw.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPw.setData(postData, view);
                    pbCommenFloorItemViewHolder.lPw.setChildOnClickListener(this.bbI);
                    pbCommenFloorItemViewHolder.lPw.setChildOnLongClickListener(this.mOnLongClickListener);
                    pbCommenFloorItemViewHolder.lPw.setChildOnTouchListener(this.lPf);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPw.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    pbCommenFloorItemViewHolder.lPw.setLayoutParams(layoutParams2);
                    pbCommenFloorItemViewHolder.lPw.setVisibility(8);
                }
            }
            if (postData.nxH) {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bjm()) {
                pbCommenFloorItemViewHolder.lPy.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.bjj()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPv.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lPx.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lPv.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.bjk()) {
                ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPv.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lPx.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lPv.setVisibility(8);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lQb.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lQb.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.bjl()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPv.getLayoutParams();
                if (pbCommenFloorItemViewHolder.lPx.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.lQd.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPS != null && pbCommenFloorItemViewHolder.lPP != null) {
            if (postData == null || postData.nxL == null || StringUtils.isNull(postData.nxL.liveTitle)) {
                pbCommenFloorItemViewHolder.lPP.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.lPS.setText(postData.nxL.liveTitle);
            pbCommenFloorItemViewHolder.lPP.setTag(postData.nxL);
            pbCommenFloorItemViewHolder.lPP.setVisibility(0);
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(arVar);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lPX.setVisibility(postData.nxR ? 0 : 8);
        }
    }

    private void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.c(postData.nxK, postData.getId(), this.lPe);
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        if (pbCommenFloorItemViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
                n(pbCommenFloorItemViewHolder.lPm);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ick, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPn, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPo, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPp, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPI, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPq, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPy, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.lPt.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lQc, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lQd, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ap.d(pbCommenFloorItemViewHolder.lPw, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPx, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bjm()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPx, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304);
                }
                pbCommenFloorItemViewHolder.lPx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(pbCommenFloorItemViewHolder.jTF, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jTD, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.lPw.onChangeSkinType();
                pbCommenFloorItemViewHolder.lPu.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPS, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPQ, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(pbCommenFloorItemViewHolder.lPP, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(pbCommenFloorItemViewHolder.lPR, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setImageResource(pbCommenFloorItemViewHolder.lPT, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPW, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.lPU.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lPW.setText(R.string.close_content);
                } else if (this.lOi != null && StringUtils.isNull(this.lOi.dlr())) {
                    pbCommenFloorItemViewHolder.lPW.setText(this.lOi.dlr());
                } else {
                    pbCommenFloorItemViewHolder.lPW.setText(R.string.expand_content);
                }
                pbCommenFloorItemViewHolder.lPr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                pbCommenFloorItemViewHolder.DI(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(pbCommenFloorItemViewHolder.lQa, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.lQe, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.dne();
            }
            pbCommenFloorItemViewHolder.mSkinType = skinType;
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lPl.setOnTouchListener(this.lPf);
        pbCommenFloorItemViewHolder.lPl.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lQj.doh() != null && this.lQj.doh().getPageContext() != null && this.lQj.doh().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lQj.doh().lNy;
            pbCommenFloorItemViewHolder.ick.setOnClickListener(aVar.iPT);
            pbCommenFloorItemViewHolder.lPs.setOnClickListener(aVar.iPT);
            pbCommenFloorItemViewHolder.lPK.setOnClickListener(aVar.iPT);
            pbCommenFloorItemViewHolder.lPK.getHeadView().setOnClickListener(aVar.iPT);
            pbCommenFloorItemViewHolder.lPt.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lPt.setOnTouchListener(this.lPf);
            pbCommenFloorItemViewHolder.lPt.setCommonTextViewOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPt.setOnImageClickListener(this.fUw);
            pbCommenFloorItemViewHolder.lPt.setOnImageTouchListener(this.lPf);
            pbCommenFloorItemViewHolder.lPt.setOnEmotionClickListener(aVar.mep);
            pbCommenFloorItemViewHolder.lPt.setOnVoiceAfterClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPO.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPP.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPx.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPy.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lQa.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lQe.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pbCommenFloorItemViewHolder.jTF.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lQj.doh().lNz;
            pbCommenFloorItemViewHolder.jTF.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.jTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lPl != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.meE.a(k.this.lOi, null, postData, pbCommenFloorItemViewHolder.lPt.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = k.this.lOi.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.lOi.getThreadId())) && k.this.lOi.dlg() != null) {
                                threadId = k.this.lOi.dlg().bmo();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lOi.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).dR("obj_source", k.this.dB(view)).ap("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lPr.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lOi != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPr != null && pbCommenFloorItemViewHolder.lPr.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lPr.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lOi.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lOi.getThreadId())) && k.this.lOi.dlg() != null) {
                            threadId = k.this.lOi.dlg().bmo();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lOi.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPr.getData().postId).dR("obj_source", k.this.dB(pbCommenFloorItemViewHolder.lPr)).ap("obj_type", i));
                    }
                }
            };
            pbCommenFloorItemViewHolder.lPZ.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lOi != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPZ != null && pbCommenFloorItemViewHolder.lPZ.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lPZ.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lOi.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lOi.getThreadId())) && k.this.lOi.dlg() != null) {
                            threadId = k.this.lOi.dlg().bmo();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lOi.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPZ.getData().postId).dR("obj_source", k.this.dB(pbCommenFloorItemViewHolder.lPZ)).ap("obj_type", i));
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dB(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return "1";
        }
        Object obj = sparseArray.get(R.id.pb_track_more_obj_source);
        if (obj == null) {
            obj = "1";
        }
        sparseArray.remove(R.id.pb_track_more_obj_source);
        view.setTag(sparseArray);
        return obj.toString();
    }

    public void a(TbRichTextView.c cVar) {
        this.lPb = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lOi = fVar;
    }

    public void gW(String str) {
        this.bkB = str;
    }

    public void uJ(boolean z) {
        this.lOj = z;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.lQj.doh(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lPt.setTextViewOnTouchListener(this.fvK);
        pbCommenFloorItemViewHolder.lPt.setTextViewCheckSelection(false);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOs = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fvK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void uT(boolean z) {
        this.lPe = z;
    }
}
