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
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmF;
    private com.baidu.adp.lib.d.b<TbImageView> jmG;
    private int jwU;
    protected com.baidu.tieba.pb.data.f lNT;
    private boolean lNU;
    private TbRichTextView.c lOM;
    private com.baidu.tieba.pb.pb.sub.b lON;
    private boolean lOO;
    private boolean lOP;
    private com.baidu.tieba.pb.a.c lOQ;
    private View.OnClickListener lOd;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(View view) {
        if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
            if (com.baidu.tbadk.a.d.bjj() || com.baidu.tbadk.a.d.bjk()) {
                if (pbCommenFloorItemViewHolder.lPK != null && pbCommenFloorItemViewHolder.lPK.getData() != null) {
                    pbCommenFloorItemViewHolder.lPK.btL();
                }
            } else if (pbCommenFloorItemViewHolder.lPc != null && pbCommenFloorItemViewHolder.lPc.getData() != null) {
                pbCommenFloorItemViewHolder.lPc.btL();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jwU = 0;
        this.lOM = null;
        this.lNU = true;
        this.bkB = null;
        this.lNT = null;
        this.lOd = null;
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lON = null;
        this.fXF = true;
        this.lOO = com.baidu.tbadk.a.d.biZ();
        this.lOP = false;
        this.jmF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFf */
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
        this.jmG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
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
        this.lOQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.lMX == null || k.this.lMX.dnk() == null || k.this.lMX.dnk().dqm())) {
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
        if (bVar != null && bVar.dmq() != null) {
            this.aJY = bVar.dmq().dpe();
        }
        this.jwU = getDimensionPixelSize(R.dimen.tbds14);
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
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.lPU.doa().getPageContext(), inflate2, this.aJY, this.lOO);
        pbCommenFloorItemViewHolder.lPf.setConstrainLayoutPool(this.jmF);
        pbCommenFloorItemViewHolder.lPf.setImageViewPool(this.jmG);
        if (pbCommenFloorItemViewHolder.lPh != null) {
            pbCommenFloorItemViewHolder.lPh.setShowChildComment(this.lOO);
        }
        a(pbCommenFloorItemViewHolder);
        if (pbCommenFloorItemViewHolder.lPe != null) {
            pbCommenFloorItemViewHolder.lPe.setDuiEnabled(this.fXF);
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
            if (postData.nxs) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ar b2 = com.baidu.tieba.pb.c.a.b(this.lNT, postData, postData.locate, i, 6);
            postData.nxt = b2;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dNu())) {
                Iterator<PostData> it = postData.dNu().iterator();
                while (it.hasNext()) {
                    it.next().nxt = b2;
                }
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lPk.setVisibility(8);
            if (com.baidu.tbadk.a.d.bjj()) {
                pbCommenFloorItemViewHolder.lPJ.setVisibility(0);
                pbCommenFloorItemViewHolder.lPg.setVisibility(0);
                pbCommenFloorItemViewHolder.lPM.setVisibility(8);
                pbCommenFloorItemViewHolder.jTr.setVisibility(8);
                pbCommenFloorItemViewHolder.jTp.setVisibility(8);
                pbCommenFloorItemViewHolder.lPc.setVisibility(8);
                pbCommenFloorItemViewHolder.lPP.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bjk()) {
                pbCommenFloorItemViewHolder.lPJ.setVisibility(0);
                pbCommenFloorItemViewHolder.lPg.setVisibility(0);
                pbCommenFloorItemViewHolder.lPM.setVisibility(0);
                pbCommenFloorItemViewHolder.jTr.setVisibility(8);
                pbCommenFloorItemViewHolder.jTp.setVisibility(8);
                pbCommenFloorItemViewHolder.lPc.setVisibility(8);
                pbCommenFloorItemViewHolder.lPP.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bjl()) {
                pbCommenFloorItemViewHolder.lPM.setVisibility(8);
                pbCommenFloorItemViewHolder.lPJ.setVisibility(8);
                pbCommenFloorItemViewHolder.lPg.setVisibility(0);
                pbCommenFloorItemViewHolder.jTr.setVisibility(0);
                pbCommenFloorItemViewHolder.jTp.setVisibility(0);
                pbCommenFloorItemViewHolder.lPc.setVisibility(0);
                pbCommenFloorItemViewHolder.lPP.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.lPJ.setVisibility(8);
                pbCommenFloorItemViewHolder.lPM.setVisibility(8);
                pbCommenFloorItemViewHolder.lPg.setVisibility(0);
                pbCommenFloorItemViewHolder.jTr.setVisibility(0);
                pbCommenFloorItemViewHolder.jTp.setVisibility(0);
                pbCommenFloorItemViewHolder.lPc.setVisibility(0);
                pbCommenFloorItemViewHolder.lPP.setVisibility(8);
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
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lOW != null) {
            if (this.lPU != null && this.lPU.dmq() != null && this.lPU.dmq().dpm() && com.baidu.tbadk.core.util.au.equals(this.lPU.dmq().dos(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.lOW, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.lOW, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        if (z) {
            pbCommenFloorItemViewHolder.lPF.setVisibility(8);
            if (StringUtils.isNull(str)) {
                pbCommenFloorItemViewHolder.lPH.setText(R.string.expand_content);
                return;
            } else {
                pbCommenFloorItemViewHolder.lPH.setText(str);
                return;
            }
        }
        pbCommenFloorItemViewHolder.lPF.setVisibility(0);
        pbCommenFloorItemViewHolder.lPH.setText(R.string.close_content);
    }

    private void c(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final PostData postData) {
        if (postData.dNJ() == 2 || postData.dNJ() == 4) {
            pbCommenFloorItemViewHolder.lPG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = pbCommenFloorItemViewHolder.lPF.getVisibility() == 8;
                    k.this.a(pbCommenFloorItemViewHolder, !z, postData.dlk());
                    postData.yt(z ? false : true);
                    k.this.d(pbCommenFloorItemViewHolder, postData);
                    if (k.this.lMX != null && k.this.lMX.dnk() != null && k.this.lMX.dnk().drr() != null && k.this.lMX.dnk().getListView() != null && !z && pbCommenFloorItemViewHolder.getView().getTop() < k.this.lMX.dnk().drr().getMeasuredHeight()) {
                        k.this.lMX.dnk().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(k.this.lMX.dnk().getListView().getData(), postData) + k.this.lMX.dnk().getListView().getHeaderViewsCount(), k.this.lMX.dnk().drr().getMeasuredHeight());
                    }
                }
            });
            pbCommenFloorItemViewHolder.lPG.setVisibility(0);
            a(pbCommenFloorItemViewHolder, postData.dNs(), postData.dlk());
            a(true, pbCommenFloorItemViewHolder, postData);
        } else {
            pbCommenFloorItemViewHolder.lPG.setVisibility(8);
            pbCommenFloorItemViewHolder.lPF.setVisibility(0);
            a(false, pbCommenFloorItemViewHolder, postData);
        }
        d(pbCommenFloorItemViewHolder, postData);
    }

    private void a(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.mBottomLine != null && pbCommenFloorItemViewHolder.lPG != null && (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.lPG.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dNu());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.lPG.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().sg(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().sf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().sf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.lPG.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().sf(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().sg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        TbRichText dNz = postData.dNz();
        dNz.isChanged = true;
        pbCommenFloorItemViewHolder.lPe.setText(dNz, true, this.lOM);
    }

    private void j(PostData postData) {
        if (postData.eRW == 0 && postData.jpg) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12203");
            arVar.dR("post_id", postData.getId());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("cuid", TbadkCoreApplication.getInst().getCuid());
            arVar.dR("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            arVar.dR("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            arVar.dR("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            arVar.v(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lPU != null) {
                int dpe = this.lPU.dmq().dpe();
                if (1 == dpe || 2 == dpe) {
                    arVar.dR("obj_source", "1");
                } else if (3 == dpe) {
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
        String forumId = this.lNT != null ? this.lNT.getForumId() : "";
        String forumName = this.lNT != null ? this.lNT.getForumName() : "";
        int dNx = postData.dNx();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13714");
        arVar.dR("fid", forumId);
        arVar.dR("fname", forumName);
        arVar.dR("obj_param1", userId);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("tid", id);
        arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, dNx);
        TiebaStatic.log(arVar);
    }

    private void l(PostData postData) {
        if (this.lNT != null) {
            if (this.lNT.dlz()) {
                if (this.lPV != null) {
                    com.baidu.tieba.pb.c.a.a(this.lPV.getUniqueId(), this.lNT, postData, postData.locate, postData.nxs ? 2 : 8);
                }
            } else if (this.lMX != null) {
                com.baidu.tieba.pb.c.a.a(this.lMX.getUniqueId(), this.lNT, postData, postData.locate, postData.nxs ? 2 : 8);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.dtl() == null) {
            pbCommenFloorItemViewHolder.lPz.setVisibility(8);
            return;
        }
        TbRichText dNz = postData.dNz();
        com.baidu.tieba.pb.view.b.a(postData.dtl(), pbCommenFloorItemViewHolder.lPz, false, false, dNz != null && StringUtils.isNull(dNz.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lNU) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPe.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lPe.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lPe.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lPe.Eh(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPe.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lPe.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lPe.Eh(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lPe.setTextViewOnTouchListener(this.lOQ);
        pbCommenFloorItemViewHolder.lPe.setTextViewCheckSelection(false);
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.bnQ() == null || postData.bnQ().isBaijiahaoUser()) {
            }
            if (postData.nxj) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lPd.setTag(null);
            pbCommenFloorItemViewHolder.lPd.setUserId(null);
            pbCommenFloorItemViewHolder.ibW.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lPv.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lPe.setIsHost(false);
            if (postData.bnQ() != null) {
                if (this.bkB != null && !this.bkB.equals("0") && this.bkB.equals(postData.bnQ().getUserId())) {
                    pbCommenFloorItemViewHolder.lPe.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bnQ().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bnQ().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lPx != null) {
                    pbCommenFloorItemViewHolder.lPx.setTag(R.id.tag_user_id, postData.bnQ().getUserId());
                    if (this.lPU != null && this.lPU.doa() != null) {
                        pbCommenFloorItemViewHolder.lPx.setOnClickListener(this.lPU.doa().lNj.mdX);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lPx.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lPw != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lPw.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lPU != null && this.lPU.doa() != null) {
                        pbCommenFloorItemViewHolder.lPw.setOnClickListener(this.lPU.doa().lNj.mdY);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lPw.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.bnQ().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ibW, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ibW, R.color.CAM_X0107, 1);
                }
                String avater = postData.bnQ().getAvater();
                int i2 = 8;
                if (postData.nxs) {
                    i2 = 2;
                }
                pbCommenFloorItemViewHolder.ibW.setTag(R.id.tag_user_id, postData.bnQ().getUserId());
                pbCommenFloorItemViewHolder.ibW.setTag(R.id.tag_user_name, postData.bnQ().getUserName());
                pbCommenFloorItemViewHolder.ibW.setTag(R.id.tag_virtual_user_url, postData.bnQ().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.ibW.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lNT, postData, postData.locate, i2, 2));
                String name_show = postData.bnQ().getName_show();
                String userName = postData.bnQ().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.ibW.setText(com.baidu.tieba.pb.c.ba(this.mContext, pbCommenFloorItemViewHolder.ibW.getText().toString()));
                    pbCommenFloorItemViewHolder.ibW.setGravity(16);
                    pbCommenFloorItemViewHolder.ibW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkJ());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ibW, R.color.CAM_X0312, 1);
                }
                if (postData.bnQ().getPendantData() != null && !StringUtils.isNull(postData.bnQ().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lPv.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lPv.a(postData.bnQ(), 4);
                    pbCommenFloorItemViewHolder.lPd.setVisibility(8);
                    pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPv.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setUserId(postData.bnQ().getUserId());
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setUserName(postData.bnQ().getUserName());
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setFid(this.lNT != null ? this.lNT.getForumId() : "");
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setFName(this.lNT != null ? this.lNT.getForumName() : "");
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setFloor(postData.dNx());
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lNT, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lPv.Bz(postData.bnQ().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lPd.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lPd, postData.bnQ(), 4);
                    pbCommenFloorItemViewHolder.lPd.setUserId(postData.bnQ().getUserId());
                    pbCommenFloorItemViewHolder.lPd.setFid(this.lNT != null ? this.lNT.getForumId() : "");
                    pbCommenFloorItemViewHolder.lPd.setFName(this.lNT != null ? this.lNT.getForumName() : "");
                    pbCommenFloorItemViewHolder.lPd.setFloor(postData.dNx());
                    pbCommenFloorItemViewHolder.lPd.setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lPd.setUserName(postData.bnQ().getUserName(), postData.dNH());
                    pbCommenFloorItemViewHolder.lPd.setTag(R.id.tag_virtual_user_url, postData.bnQ().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lPd.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lNT, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lPd.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lPd.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lPd.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPv.setVisibility(8);
                }
                if (postData.bnQ() != null && postData.bnQ().getAlaInfo() != null && postData.bnQ().getAlaUserData() != null && postData.bnQ().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.tz(true);
                    pbCommenFloorItemViewHolder.lPd.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lPd.setAlaInfo(postData.bnQ().getAlaInfo());
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setAlaInfo(postData.bnQ().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.tz(false);
                    pbCommenFloorItemViewHolder.lPd.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lPd.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lPv.getHeadView().setAlaInfo(null);
                }
                a(pbCommenFloorItemViewHolder.lOX, postData);
            }
            int i3 = 0;
            if (this.lPU != null && this.lPU.doa() != null && this.lPU.doa().dmi() && postData.bnQ() != null) {
                i3 = postData.bnQ().getLevel_id();
            }
            if (this.lNT != null && this.lNT.dlC()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.lPu.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(pbCommenFloorItemViewHolder.lPu, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                pbCommenFloorItemViewHolder.lPu.setVisibility(8);
            }
            int i4 = 15;
            if (pbCommenFloorItemViewHolder.lPx.getChildCount() == 1) {
                i4 = 13;
            } else if (pbCommenFloorItemViewHolder.lPx.getChildCount() > 1) {
                i4 = 11;
            }
            if (pbCommenFloorItemViewHolder.lOX.getVisibility() == 0) {
                i4 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lPw.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bpr() > 1000) {
                i4 -= 2;
            }
            if (postData.bpr() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                pbCommenFloorItemViewHolder.lPx.setVisibility(8);
                if (pbCommenFloorItemViewHolder.lPx.getChildCount() == 1) {
                    i4 += 2;
                } else if (pbCommenFloorItemViewHolder.lPx.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lOX.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lOX.setVisibility(8);
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lPu.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lPu.setVisibility(8);
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
                pbCommenFloorItemViewHolder.ibW.setText(dT(postData.bnQ().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.ibW.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNx()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.lPc);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.lPK);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.jTr);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.jTp);
            cb cbVar = null;
            if (this.lNT != null && this.lNT.dkZ() != null) {
                cbVar = this.lNT.dkZ();
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
            if (this.lNT != null && this.lNT.dlo() != 0) {
                if (this.lNT.dlo() != 1002 && this.lNT.dlo() != 3) {
                    z5 = true;
                }
                if (this.lNT.dlo() != 3 && !this.lNT.dlC()) {
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
            if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().bnQ() != null && postData.bnQ() != null) {
                String userId2 = this.lNT.dkZ().bnQ().getUserId();
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
            if (postData.dNx() == 1) {
                i5 = 0;
            }
            if (z3) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lNT.dlo()));
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
                if (this.lNT.dkZ() != null) {
                    sparseArray.put(R.id.tag_user_mute_thread_id, this.lNT.dkZ().getId());
                }
                sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z6) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lNT.dlo()));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            pbCommenFloorItemViewHolder.lPe.setTag(sparseArray);
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
            if (this.lNT != null && this.lNT.dlC()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnQ() != null) {
                MetaData bnQ = postData.bnQ();
                if (this.bkB != null && !this.bkB.equals("0") && this.bkB.equals(bnQ.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).og(R.string.J_X04).ok(R.dimen.L_X01).nY(R.color.CAM_X0302).oj(R.color.CAM_X0302);
                } else if (bnQ.getIs_bawu() == 1 && postData.dNp()) {
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
        if (pbCommenFloorItemViewHolder != null && postData != null && pbCommenFloorItemViewHolder.lPy != null && this.lNT != null) {
            pbCommenFloorItemViewHolder.lPy.setVisibility(8);
        }
    }

    private void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.bpJ() != null) {
            postData.bpJ().threadId = this.lPU.dmq().dot();
            postData.bpJ().objType = 1;
            postData.bpJ().isInPost = true;
            cb cbVar = null;
            if (this.lNT != null && this.lNT.dkZ() != null) {
                cbVar = this.lNT.dkZ();
            }
            if (cbVar != null && cbVar.bmz()) {
                pbCommenFloorItemViewHolder.lPc.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lPc.setThreadData(cbVar);
            pbCommenFloorItemViewHolder.lPc.setData(postData.bpJ());
            pbCommenFloorItemViewHolder.lPK.setThreadData(cbVar);
            pbCommenFloorItemViewHolder.lPK.setData(postData.bpJ());
        }
    }

    private void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dNx() > 0 && this.lNT != null && !this.lNT.dlC()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dNx()));
                pbCommenFloorItemViewHolder.lPt.setVisibility(0);
                pbCommenFloorItemViewHolder.lPt.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lPt.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dNA = postData.dNA();
            boolean z2 = (dNA == null || StringUtils.isNull(dNA.getName()) || this.lNT == null || this.lNT.dlC()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lOZ.setVisibility(0);
                i = this.jwU;
            } else {
                pbCommenFloorItemViewHolder.lOZ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lPa.setVisibility(0);
                i2 = this.jwU;
            } else {
                pbCommenFloorItemViewHolder.lPa.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lOY.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lOY.setText(com.baidu.tbadk.core.util.au.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lOY.setText(com.baidu.tbadk.core.util.au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lPb.setVisibility(0);
                pbCommenFloorItemViewHolder.lPb.setPadding(this.jwU, 0, 0, 0);
                if (postData.nxr) {
                    pbCommenFloorItemViewHolder.lPb.setText(com.baidu.tbadk.core.util.au.cutStringWithSuffix(dNA.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    pbCommenFloorItemViewHolder.lPb.setText(dNA.getName());
                }
            } else {
                pbCommenFloorItemViewHolder.lPb.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lPN.setText(((Object) pbCommenFloorItemViewHolder.lOY.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.bjk()) {
                if (z) {
                    pbCommenFloorItemViewHolder.lPN.setVisibility(0);
                    pbCommenFloorItemViewHolder.lOY.setVisibility(8);
                    pbCommenFloorItemViewHolder.lOZ.setVisibility(8);
                    return;
                }
                pbCommenFloorItemViewHolder.lPN.setVisibility(8);
                pbCommenFloorItemViewHolder.lOY.setVisibility(0);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPe.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.lPe.setPadding(0, 0, 0, 0);
            if (!this.lNU) {
                pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().sa(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.lPe.Eh(null);
                pbCommenFloorItemViewHolder.lPe.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().sa(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.lPe.getLayoutStrategy().rX(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lPe, view, !StringUtils.isNull(postData.getBimg_url()));
            pbCommenFloorItemViewHolder.lPe.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lPe.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lPe.setIsFromCDN(this.mIsFromCDN);
            pbCommenFloorItemViewHolder.lPe.setText(postData.dNz(), true, this.lOM);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lPe.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbCommenFloorItemViewHolder.lPe.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lOW.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.lPP.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lPL.setTag(sparseArray);
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
            if (postData.dNB() > 0) {
                pbCommenFloorItemViewHolder.lPj.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lPj.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lPj.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dNJ() == 2) {
                    pbCommenFloorItemViewHolder.lPj.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lPj.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.lPi.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.jTr != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.jTr.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.jTr.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.jTp != null) {
                SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jTp.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.jTp.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            if (postData.dNB() > 0 && !this.lOO) {
                pbCommenFloorItemViewHolder.lPi.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dNB())));
                SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.lPi.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.lPi.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                pbCommenFloorItemViewHolder.lPi.setVisibility(0);
                pbCommenFloorItemViewHolder.lPj.setVisibility(8);
                pbCommenFloorItemViewHolder.lPh.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.lPi.setVisibility(8);
                if (postData.dNB() > 0 && postData.dNu() != null && postData.dNu().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPh.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.lPh.setLayoutParams(layoutParams);
                    if (this.lON == null) {
                        this.lON = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lON.setIsFromCDN(this.mIsFromCDN);
                        this.lON.setOnLongClickListener(this.mOnLongClickListener);
                        this.lON.Y(this.lOd);
                        this.lON.C(this.bbI);
                        String str = null;
                        if (this.lNT != null && this.lNT.dkZ() != null && this.lNT.dkZ().bnQ() != null) {
                            str = this.lNT.dkZ().bnQ().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lNT != null) {
                            this.lON.ad(this.lNT.dlo(), z);
                            this.lON.setThreadData(this.lNT.dkZ());
                        }
                    }
                    this.lON.PX(postData.getId());
                    pbCommenFloorItemViewHolder.lPh.setSubPbAdapter(this.lON);
                    pbCommenFloorItemViewHolder.lPh.setVisibility(0);
                    pbCommenFloorItemViewHolder.lPh.setData(postData, view);
                    pbCommenFloorItemViewHolder.lPh.setChildOnClickListener(this.bbI);
                    pbCommenFloorItemViewHolder.lPh.setChildOnLongClickListener(this.mOnLongClickListener);
                    pbCommenFloorItemViewHolder.lPh.setChildOnTouchListener(this.lOQ);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPh.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    pbCommenFloorItemViewHolder.lPh.setLayoutParams(layoutParams2);
                    pbCommenFloorItemViewHolder.lPh.setVisibility(8);
                }
            }
            if (postData.nxh) {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bjm()) {
                pbCommenFloorItemViewHolder.lPj.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.bjj()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPg.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lPi.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lPg.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lPg.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.bjk()) {
                ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPg.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lPi.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lPg.setVisibility(8);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPM.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    pbCommenFloorItemViewHolder.lPg.setVisibility(0);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPM.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.bjl()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lPg.getLayoutParams();
                if (pbCommenFloorItemViewHolder.lPi.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.lPO.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPD != null && pbCommenFloorItemViewHolder.lPA != null) {
            if (postData == null || postData.nxl == null || StringUtils.isNull(postData.nxl.liveTitle)) {
                pbCommenFloorItemViewHolder.lPA.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.lPD.setText(postData.nxl.liveTitle);
            pbCommenFloorItemViewHolder.lPA.setTag(postData.nxl);
            pbCommenFloorItemViewHolder.lPA.setVisibility(0);
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(arVar);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lPI.setVisibility(postData.nxr ? 0 : 8);
        }
    }

    private void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.c(postData.nxk, postData.getId(), this.lOP);
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        if (pbCommenFloorItemViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
                n(pbCommenFloorItemViewHolder.lOX);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.ibW, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lOY, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lOZ, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPa, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPt, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPb, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPj, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.lPe.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPN, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPO, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ap.d(pbCommenFloorItemViewHolder.lPh, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPi, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bjm()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPi, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304);
                }
                pbCommenFloorItemViewHolder.lPi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(pbCommenFloorItemViewHolder.jTr, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jTp, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.lPh.onChangeSkinType();
                pbCommenFloorItemViewHolder.lPf.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPD, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPB, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(pbCommenFloorItemViewHolder.lPA, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(pbCommenFloorItemViewHolder.lPC, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setImageResource(pbCommenFloorItemViewHolder.lPE, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lPH, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.lPF.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lPH.setText(R.string.close_content);
                } else if (this.lNT != null && StringUtils.isNull(this.lNT.dlk())) {
                    pbCommenFloorItemViewHolder.lPH.setText(this.lNT.dlk());
                } else {
                    pbCommenFloorItemViewHolder.lPH.setText(R.string.expand_content);
                }
                pbCommenFloorItemViewHolder.lPc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                pbCommenFloorItemViewHolder.DI(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(pbCommenFloorItemViewHolder.lPL, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.lPP, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.dmX();
            }
            pbCommenFloorItemViewHolder.mSkinType = skinType;
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lOW.setOnTouchListener(this.lOQ);
        pbCommenFloorItemViewHolder.lOW.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lPU.doa() != null && this.lPU.doa().getPageContext() != null && this.lPU.doa().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lPU.doa().lNj;
            pbCommenFloorItemViewHolder.ibW.setOnClickListener(aVar.iPF);
            pbCommenFloorItemViewHolder.lPd.setOnClickListener(aVar.iPF);
            pbCommenFloorItemViewHolder.lPv.setOnClickListener(aVar.iPF);
            pbCommenFloorItemViewHolder.lPv.getHeadView().setOnClickListener(aVar.iPF);
            pbCommenFloorItemViewHolder.lPe.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lPe.setOnTouchListener(this.lOQ);
            pbCommenFloorItemViewHolder.lPe.setCommonTextViewOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPe.setOnImageClickListener(this.fUw);
            pbCommenFloorItemViewHolder.lPe.setOnImageTouchListener(this.lOQ);
            pbCommenFloorItemViewHolder.lPe.setOnEmotionClickListener(aVar.mdZ);
            pbCommenFloorItemViewHolder.lPe.setOnVoiceAfterClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPz.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPA.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPi.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPj.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPL.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPP.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pbCommenFloorItemViewHolder.jTr.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lPU.doa().lNk;
            pbCommenFloorItemViewHolder.jTr.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.jTp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lOW != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.mep.a(k.this.lNT, null, postData, pbCommenFloorItemViewHolder.lPe.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = k.this.lNT.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.lNT.getThreadId())) && k.this.lNT.dkZ() != null) {
                                threadId = k.this.lNT.dkZ().bmo();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lNT.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).dR("obj_source", k.this.dB(view)).ap("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lPc.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lNT != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPc != null && pbCommenFloorItemViewHolder.lPc.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lPc.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lNT.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lNT.getThreadId())) && k.this.lNT.dkZ() != null) {
                            threadId = k.this.lNT.dkZ().bmo();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lNT.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPc.getData().postId).dR("obj_source", k.this.dB(pbCommenFloorItemViewHolder.lPc)).ap("obj_type", i));
                    }
                }
            };
            pbCommenFloorItemViewHolder.lPK.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lNT != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPK != null && pbCommenFloorItemViewHolder.lPK.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lPK.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lNT.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lNT.getThreadId())) && k.this.lNT.dkZ() != null) {
                            threadId = k.this.lNT.dkZ().bmo();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lNT.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPK.getData().postId).dR("obj_source", k.this.dB(pbCommenFloorItemViewHolder.lPK)).ap("obj_type", i));
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
        this.lOM = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lNT = fVar;
    }

    public void gW(String str) {
        this.bkB = str;
    }

    public void uJ(boolean z) {
        this.lNU = z;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.lPU.doa(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lPe.setTextViewOnTouchListener(this.fvK);
        pbCommenFloorItemViewHolder.lPe.setTextViewCheckSelection(false);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOd = onClickListener;
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
        this.lOP = z;
    }
}
