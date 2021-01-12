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
import com.baidu.tbadk.core.data.bz;
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
    private int aHt;
    private View.OnClickListener aYB;
    private String bhj;
    private TbRichTextView.i fSh;
    private boolean fVp;
    private com.baidu.tieba.pb.a.c ftt;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jgX;
    private com.baidu.adp.lib.d.b<TbImageView> jgY;
    private int jro;
    private TbRichTextView.c lFW;
    private com.baidu.tieba.pb.pb.sub.b lFX;
    private boolean lFY;
    private com.baidu.tieba.pb.a.c lFZ;
    protected com.baidu.tieba.pb.data.f lFd;
    private boolean lFe;
    private View.OnClickListener lFn;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(View view) {
        if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
            if (com.baidu.tbadk.a.d.biX() || com.baidu.tbadk.a.d.biY()) {
                if (pbCommenFloorItemViewHolder.lGT != null && pbCommenFloorItemViewHolder.lGT.getData() != null) {
                    pbCommenFloorItemViewHolder.lGT.btr();
                }
            } else if (pbCommenFloorItemViewHolder.lGl != null && pbCommenFloorItemViewHolder.lGl.getData() != null) {
                pbCommenFloorItemViewHolder.lGl.btr();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jro = 0;
        this.lFW = null;
        this.lFe = true;
        this.bhj = null;
        this.lFd = null;
        this.lFn = null;
        this.aYB = null;
        this.fSh = null;
        this.ftt = null;
        this.mOnLongClickListener = null;
        this.lFX = null;
        this.fVp = true;
        this.lFY = com.baidu.tbadk.a.d.biN();
        this.jgX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cDT */
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
        this.jgY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bur */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.common_color_10043));
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
        this.lFZ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.lEi == null || k.this.lEi.dkW() == null || k.this.lEi.dkW().dnY())) {
                    if (view instanceof RelativeLayout) {
                        k.this.dC(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                k.this.dC((RelativeLayout) parent);
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
                if (k.this.ftt != null) {
                    if (!(view instanceof TbListTextView) || k.this.aYB == null) {
                        k.this.ftt.ad(view);
                        k.this.ftt.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.aYB.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.dkd() != null) {
            this.aHt = bVar.dkd().dmP();
        }
        this.jro = getDimensionPixelSize(R.dimen.tbds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate;
        View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate2.findViewById(R.id.pb_post_reply_container);
        if (com.baidu.tbadk.a.d.biZ()) {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_c, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null);
        }
        viewGroup2.addView(inflate);
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.lHa.dlL().getPageContext(), inflate2, this.aHt, this.lFY);
        pbCommenFloorItemViewHolder.lGo.setConstrainLayoutPool(this.jgX);
        pbCommenFloorItemViewHolder.lGo.setImageViewPool(this.jgY);
        if (pbCommenFloorItemViewHolder.lGq != null) {
            pbCommenFloorItemViewHolder.lGq.setShowChildComment(this.lFY);
        }
        a(pbCommenFloorItemViewHolder);
        if (pbCommenFloorItemViewHolder.lGn != null) {
            pbCommenFloorItemViewHolder.lGn.setDuiEnabled(this.fVp);
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
            postData2.boL();
            i(postData2);
            a(pbCommenFloorItemViewHolder, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fVp = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.nnH) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b2 = com.baidu.tieba.pb.c.a.b(this.lFd, postData, postData.locate, i, 6);
            postData.nnI = b2;
            if (!com.baidu.tbadk.core.util.x.isEmpty(postData.dLj())) {
                Iterator<PostData> it = postData.dLj().iterator();
                while (it.hasNext()) {
                    it.next().nnI = b2;
                }
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lGt.setVisibility(8);
            if (com.baidu.tbadk.a.d.biX()) {
                pbCommenFloorItemViewHolder.lGS.setVisibility(0);
                pbCommenFloorItemViewHolder.lGp.setVisibility(0);
                pbCommenFloorItemViewHolder.lGV.setVisibility(8);
                pbCommenFloorItemViewHolder.jMo.setVisibility(8);
                pbCommenFloorItemViewHolder.jMm.setVisibility(8);
                pbCommenFloorItemViewHolder.lGl.setVisibility(8);
                pbCommenFloorItemViewHolder.lGY.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.biY()) {
                pbCommenFloorItemViewHolder.lGS.setVisibility(0);
                pbCommenFloorItemViewHolder.lGp.setVisibility(0);
                pbCommenFloorItemViewHolder.lGV.setVisibility(0);
                pbCommenFloorItemViewHolder.jMo.setVisibility(8);
                pbCommenFloorItemViewHolder.jMm.setVisibility(8);
                pbCommenFloorItemViewHolder.lGl.setVisibility(8);
                pbCommenFloorItemViewHolder.lGY.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.biZ()) {
                pbCommenFloorItemViewHolder.lGV.setVisibility(8);
                pbCommenFloorItemViewHolder.lGS.setVisibility(8);
                pbCommenFloorItemViewHolder.lGp.setVisibility(0);
                pbCommenFloorItemViewHolder.jMo.setVisibility(0);
                pbCommenFloorItemViewHolder.jMm.setVisibility(0);
                pbCommenFloorItemViewHolder.lGl.setVisibility(0);
                pbCommenFloorItemViewHolder.lGY.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.lGS.setVisibility(8);
                pbCommenFloorItemViewHolder.lGV.setVisibility(8);
                pbCommenFloorItemViewHolder.lGp.setVisibility(0);
                pbCommenFloorItemViewHolder.jMo.setVisibility(0);
                pbCommenFloorItemViewHolder.jMm.setVisibility(0);
                pbCommenFloorItemViewHolder.lGl.setVisibility(0);
                pbCommenFloorItemViewHolder.lGY.setVisibility(8);
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
        }
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lGf != null) {
            if (this.lHa != null && this.lHa.dkd() != null && this.lHa.dkd().dmX() && com.baidu.tbadk.core.util.at.equals(this.lHa.dkd().dmd(), postData.getId())) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.lGf, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.lGf, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        if (z) {
            pbCommenFloorItemViewHolder.lGO.setVisibility(8);
            if (StringUtils.isNull(str)) {
                pbCommenFloorItemViewHolder.lGQ.setText(R.string.expand_content);
                return;
            } else {
                pbCommenFloorItemViewHolder.lGQ.setText(str);
                return;
            }
        }
        pbCommenFloorItemViewHolder.lGO.setVisibility(0);
        pbCommenFloorItemViewHolder.lGQ.setText(R.string.close_content);
    }

    private void c(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final PostData postData) {
        if (postData.dLy() == 2 || postData.dLy() == 4) {
            pbCommenFloorItemViewHolder.lGP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = pbCommenFloorItemViewHolder.lGO.getVisibility() == 8;
                    k.this.a(pbCommenFloorItemViewHolder, !z, postData.diY());
                    postData.ya(z ? false : true);
                    k.this.d(pbCommenFloorItemViewHolder, postData);
                    if (k.this.lEi != null && k.this.lEi.dkW() != null && k.this.lEi.dkW().dpd() != null && k.this.lEi.dkW().getListView() != null && !z && pbCommenFloorItemViewHolder.getView().getTop() < k.this.lEi.dkW().dpd().getMeasuredHeight()) {
                        k.this.lEi.dkW().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.x.getPosition(k.this.lEi.dkW().getListView().getData(), postData) + k.this.lEi.dkW().getListView().getHeaderViewsCount(), k.this.lEi.dkW().dpd().getMeasuredHeight());
                    }
                }
            });
            pbCommenFloorItemViewHolder.lGP.setVisibility(0);
            a(pbCommenFloorItemViewHolder, postData.dLh(), postData.diY());
            a(true, pbCommenFloorItemViewHolder, postData);
        } else {
            pbCommenFloorItemViewHolder.lGP.setVisibility(8);
            pbCommenFloorItemViewHolder.lGO.setVisibility(0);
            a(false, pbCommenFloorItemViewHolder, postData);
        }
        d(pbCommenFloorItemViewHolder, postData);
    }

    private void a(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.mBottomLine != null && pbCommenFloorItemViewHolder.lGP != null && (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.lGP.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.x.isEmpty(postData.dLj());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.lGP.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().sb(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().sa(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().sa(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.lGP.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().sa(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().sb(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        TbRichText dLo = postData.dLo();
        dLo.isChanged = true;
        pbCommenFloorItemViewHolder.lGn.setText(dLo, true, this.lFW);
    }

    private void j(PostData postData) {
        if (postData.ePK == 0 && postData.jjz) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dW("post_id", postData.getId());
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dW("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dW("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dW("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lHa != null) {
                int dmP = this.lHa.dkd().dmP();
                if (1 == dmP || 2 == dmP) {
                    aqVar.dW("obj_source", "1");
                } else if (3 == dmP) {
                    aqVar.dW("obj_source", "2");
                } else {
                    aqVar.dW("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.bnx() != null && postData.bnx().getAlaInfo() != null && postData.bnx().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.bnx().getUserId();
        String forumId = this.lFd != null ? this.lFd.getForumId() : "";
        String forumName = this.lFd != null ? this.lFd.getForumName() : "";
        int dLm = postData.dLm();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dW("fid", forumId);
        aqVar.dW("fname", forumName);
        aqVar.dW("obj_param1", userId);
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dW("tid", id);
        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, dLm);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.lFd != null) {
            if (this.lFd.djn()) {
                if (this.lHb != null) {
                    com.baidu.tieba.pb.c.a.a(this.lHb.getUniqueId(), this.lFd, postData, postData.locate, postData.nnH ? 2 : 8);
                }
            } else if (this.lEi != null) {
                com.baidu.tieba.pb.c.a.a(this.lEi.getUniqueId(), this.lFd, postData, postData.locate, postData.nnH ? 2 : 8);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.dqX() == null) {
            pbCommenFloorItemViewHolder.lGI.setVisibility(8);
            return;
        }
        TbRichText dLo = postData.dLo();
        com.baidu.tieba.pb.view.b.a(postData.dqX(), pbCommenFloorItemViewHolder.lGI, false, false, dLo != null && StringUtils.isNull(dLo.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lFe) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGn.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lGn.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lGn.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lGn.DK(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGn.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lGn.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lGn.DK(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lGn.setTextViewOnTouchListener(this.lFZ);
        pbCommenFloorItemViewHolder.lGn.setTextViewCheckSelection(false);
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.bnx() == null || postData.bnx().isBaijiahaoUser()) {
            }
            if (postData.nny) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lGm.setTag(null);
            pbCommenFloorItemViewHolder.lGm.setUserId(null);
            pbCommenFloorItemViewHolder.hXC.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lGE.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lGn.setIsHost(false);
            if (postData.bnx() != null) {
                if (this.bhj != null && !this.bhj.equals("0") && this.bhj.equals(postData.bnx().getUserId())) {
                    pbCommenFloorItemViewHolder.lGn.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bnx().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bnx().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lGG != null) {
                    pbCommenFloorItemViewHolder.lGG.setTag(R.id.tag_user_id, postData.bnx().getUserId());
                    if (this.lHa != null && this.lHa.dlL() != null) {
                        pbCommenFloorItemViewHolder.lGG.setOnClickListener(this.lHa.dlL().lEu.lUT);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lGG.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lGF != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lGF.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lHa != null && this.lHa.dlL() != null) {
                        pbCommenFloorItemViewHolder.lGF.setOnClickListener(this.lHa.dlL().lEu.lUU);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lGF.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.x.isEmpty(tShowInfoNew) || postData.bnx().isBigV()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0107, 1);
                }
                String avater = postData.bnx().getAvater();
                int i2 = 8;
                if (postData.nnH) {
                    i2 = 2;
                }
                pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_user_id, postData.bnx().getUserId());
                pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_user_name, postData.bnx().getUserName());
                pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_virtual_user_url, postData.bnx().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lFd, postData, postData.locate, i2, 2));
                String name_show = postData.bnx().getName_show();
                String userName = postData.bnx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.hXC.setText(com.baidu.tieba.pb.c.bb(this.mContext, pbCommenFloorItemViewHolder.hXC.getText().toString()));
                    pbCommenFloorItemViewHolder.hXC.setGravity(16);
                    pbCommenFloorItemViewHolder.hXC.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dix());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0312, 1);
                }
                if (postData.bnx().getPendantData() != null && !StringUtils.isNull(postData.bnx().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lGE.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lGE.a(postData.bnx(), 4);
                    pbCommenFloorItemViewHolder.lGm.setVisibility(8);
                    pbCommenFloorItemViewHolder.lGE.setVisibility(0);
                    pbCommenFloorItemViewHolder.lGE.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setUserId(postData.bnx().getUserId());
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setUserName(postData.bnx().getUserName());
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setFid(this.lFd != null ? this.lFd.getForumId() : "");
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setFName(this.lFd != null ? this.lFd.getForumName() : "");
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setFloor(postData.dLm());
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lFd, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lGE.Bi(postData.bnx().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lGm.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lGm, postData.bnx(), 4);
                    pbCommenFloorItemViewHolder.lGm.setUserId(postData.bnx().getUserId());
                    pbCommenFloorItemViewHolder.lGm.setFid(this.lFd != null ? this.lFd.getForumId() : "");
                    pbCommenFloorItemViewHolder.lGm.setFName(this.lFd != null ? this.lFd.getForumName() : "");
                    pbCommenFloorItemViewHolder.lGm.setFloor(postData.dLm());
                    pbCommenFloorItemViewHolder.lGm.setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lGm.setUserName(postData.bnx().getUserName(), postData.dLw());
                    pbCommenFloorItemViewHolder.lGm.setTag(R.id.tag_virtual_user_url, postData.bnx().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lGm.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lFd, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lGm.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lGm.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lGm.setVisibility(0);
                    pbCommenFloorItemViewHolder.lGE.setVisibility(8);
                }
                if (postData.bnx() != null && postData.bnx().getAlaInfo() != null && postData.bnx().getAlaUserData() != null && postData.bnx().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.tm(true);
                    pbCommenFloorItemViewHolder.lGm.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lGm.setAlaInfo(postData.bnx().getAlaInfo());
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setAlaInfo(postData.bnx().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.tm(false);
                    pbCommenFloorItemViewHolder.lGm.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lGm.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lGE.getHeadView().setAlaInfo(null);
                }
                a(pbCommenFloorItemViewHolder.lGg, postData);
            }
            int i3 = 0;
            if (this.lHa != null && this.lHa.dlL() != null && this.lHa.dlL().djV() && postData.bnx() != null) {
                i3 = postData.bnx().getLevel_id();
            }
            if (this.lFd != null && this.lFd.djq()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.lGD.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(pbCommenFloorItemViewHolder.lGD, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                pbCommenFloorItemViewHolder.lGD.setVisibility(8);
            }
            int i4 = 15;
            if (pbCommenFloorItemViewHolder.lGG.getChildCount() == 1) {
                i4 = 13;
            } else if (pbCommenFloorItemViewHolder.lGG.getChildCount() > 1) {
                i4 = 11;
            }
            if (pbCommenFloorItemViewHolder.lGg.getVisibility() == 0) {
                i4 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lGF.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.boZ() > 1000) {
                i4 -= 2;
            }
            if (postData.boZ() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                pbCommenFloorItemViewHolder.lGG.setVisibility(8);
                if (pbCommenFloorItemViewHolder.lGG.getChildCount() == 1) {
                    i4 += 2;
                } else if (pbCommenFloorItemViewHolder.lGG.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lGg.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lGg.setVisibility(8);
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lGD.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lGD.setVisibility(8);
                }
            }
            String name_show2 = postData.bnx() != null ? postData.bnx().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.bnx() != null && !StringUtils.isNull(postData.bnx().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.bnx() != null && !StringUtils.isNull(postData.bnx().getSealPrefix())) {
                pbCommenFloorItemViewHolder.hXC.setText(dY(postData.bnx().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.hXC.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dLm()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.lGl);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.lGT);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.jMo);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.jMm);
            bz bzVar = null;
            if (this.lFd != null && this.lFd.diN() != null) {
                bzVar = this.lFd.diN();
            }
            if (bzVar != null && bzVar.bmg()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, true);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, false);
            }
            boolean z4 = false;
            if (postData.bnx() != null && !StringUtils.isNull(postData.bnx().getVirtualUserUrl())) {
                z4 = true;
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (this.lFd != null && this.lFd.djc() != 0) {
                if (this.lFd.djc() != 1002 && this.lFd.djc() != 3) {
                    z5 = true;
                }
                if (this.lFd.djc() != 3 && !this.lFd.djq()) {
                    z6 = true;
                }
                if (postData != null && postData.bnx() != null) {
                    String userId = postData.bnx().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z5 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z5 = false;
                    }
                }
            }
            if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().bnx() != null && postData.bnx() != null) {
                String userId2 = this.lFd.diN().bnx().getUserId();
                String userId3 = postData.bnx().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z6 = true;
                    z7 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z7 = false;
                        z8 = true;
                    }
                }
            }
            if (postData == null || postData.bnx() == null || !UtilHelper.isCurrentAccount(postData.bnx().getUserId())) {
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
            if (postData.dLm() == 1) {
                i5 = 0;
            }
            if (z3) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lFd.djc()));
                if (postData.bnx() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.bnx().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnx().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnx().getPortrait());
                }
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            if (z2) {
                sparseArray.put(R.id.tag_user_mute_visible, true);
                sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.bnx() != null) {
                    sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnx().getUserId());
                    sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnx().getUserName());
                    sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnx().getName_show());
                }
                if (this.lFd.diN() != null) {
                    sparseArray.put(R.id.tag_user_mute_thread_id, this.lFd.diN().getId());
                }
                sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z6) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lFd.djc()));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            pbCommenFloorItemViewHolder.lGn.setTag(sparseArray);
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
            if (this.lFd != null && this.lFd.djq()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnx() != null) {
                MetaData bnx = postData.bnx();
                if (this.bhj != null && !this.bhj.equals("0") && this.bhj.equals(bnx.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).od(R.string.J_X04).og(R.dimen.L_X01).nV(R.color.CAM_X0302).of(R.color.CAM_X0302);
                } else if (bnx.getIs_bawu() == 1 && postData.dLe()) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnx.getIs_bawu() == 1 && "pri_content_assist".equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnx.getIs_bawu() == 1 && "pri_manage_assist".equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
        if (pbCommenFloorItemViewHolder != null && postData != null && pbCommenFloorItemViewHolder.lGH != null && this.lFd != null) {
            pbCommenFloorItemViewHolder.lGH.setVisibility(8);
        }
    }

    private void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.bpr() != null) {
            postData.bpr().threadId = this.lHa.dkd().dme();
            postData.bpr().objType = 1;
            postData.bpr().isInPost = true;
            bz bzVar = null;
            if (this.lFd != null && this.lFd.diN() != null) {
                bzVar = this.lFd.diN();
            }
            if (bzVar != null && bzVar.bmg()) {
                pbCommenFloorItemViewHolder.lGl.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lGl.setThreadData(bzVar);
            pbCommenFloorItemViewHolder.lGl.setData(postData.bpr());
            pbCommenFloorItemViewHolder.lGT.setThreadData(bzVar);
            pbCommenFloorItemViewHolder.lGT.setData(postData.bpr());
        }
    }

    private void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dLm() > 0 && this.lFd != null && !this.lFd.djq()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dLm()));
                pbCommenFloorItemViewHolder.lGC.setVisibility(0);
                pbCommenFloorItemViewHolder.lGC.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lGC.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dLp = postData.dLp();
            boolean z2 = (dLp == null || StringUtils.isNull(dLp.getName()) || this.lFd == null || this.lFd.djq()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lGi.setVisibility(0);
                i = this.jro;
            } else {
                pbCommenFloorItemViewHolder.lGi.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lGj.setVisibility(0);
                i2 = this.jro;
            } else {
                pbCommenFloorItemViewHolder.lGj.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lGh.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lGh.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lGh.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lGk.setVisibility(0);
                pbCommenFloorItemViewHolder.lGk.setPadding(this.jro, 0, 0, 0);
                if (postData.nnG) {
                    pbCommenFloorItemViewHolder.lGk.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dLp.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    pbCommenFloorItemViewHolder.lGk.setText(dLp.getName());
                }
            } else {
                pbCommenFloorItemViewHolder.lGk.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lGW.setText(((Object) pbCommenFloorItemViewHolder.lGh.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.biY()) {
                if (z) {
                    pbCommenFloorItemViewHolder.lGW.setVisibility(0);
                    pbCommenFloorItemViewHolder.lGh.setVisibility(8);
                    pbCommenFloorItemViewHolder.lGi.setVisibility(8);
                    return;
                }
                pbCommenFloorItemViewHolder.lGW.setVisibility(8);
                pbCommenFloorItemViewHolder.lGh.setVisibility(0);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGn.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.lGn.setPadding(0, 0, 0, 0);
            if (!this.lFe) {
                pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().rV(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.lGn.DK(null);
                pbCommenFloorItemViewHolder.lGn.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().rV(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.lGn.getLayoutStrategy().rS(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lGn, view, !StringUtils.isNull(postData.getBimg_url()));
            pbCommenFloorItemViewHolder.lGn.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lGn.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lGn.setIsFromCDN(this.mIsFromCDN);
            pbCommenFloorItemViewHolder.lGn.setText(postData.dLo(), true, this.lFW);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lGn.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbCommenFloorItemViewHolder.lGn.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lGf.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.lGY.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lGU.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().rT(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fUk = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().rU((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dLq() > 0) {
                pbCommenFloorItemViewHolder.lGs.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lGs.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lGs.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dLy() == 2) {
                    pbCommenFloorItemViewHolder.lGs.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lGs.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.lGr.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.jMo != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.jMo.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.jMo.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.jMm != null) {
                SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jMm.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.jMm.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            if (postData.dLq() > 0 && !this.lFY) {
                pbCommenFloorItemViewHolder.lGr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dLq())));
                SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.lGr.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.lGr.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                pbCommenFloorItemViewHolder.lGr.setVisibility(0);
                pbCommenFloorItemViewHolder.lGs.setVisibility(8);
                pbCommenFloorItemViewHolder.lGq.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.lGr.setVisibility(8);
                if (postData.dLq() > 0 && postData.dLj() != null && postData.dLj().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGq.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.lGq.setLayoutParams(layoutParams);
                    if (this.lFX == null) {
                        this.lFX = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lFX.setIsFromCDN(this.mIsFromCDN);
                        this.lFX.setOnLongClickListener(this.mOnLongClickListener);
                        this.lFX.Y(this.lFn);
                        this.lFX.C(this.aYB);
                        String str = null;
                        if (this.lFd != null && this.lFd.diN() != null && this.lFd.diN().bnx() != null) {
                            str = this.lFd.diN().bnx().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lFd != null) {
                            this.lFX.ad(this.lFd.djc(), z);
                            this.lFX.setThreadData(this.lFd.diN());
                        }
                    }
                    this.lFX.Pf(postData.getId());
                    pbCommenFloorItemViewHolder.lGq.setSubPbAdapter(this.lFX);
                    pbCommenFloorItemViewHolder.lGq.setVisibility(0);
                    pbCommenFloorItemViewHolder.lGq.setData(postData, view);
                    pbCommenFloorItemViewHolder.lGq.setChildOnClickListener(this.aYB);
                    pbCommenFloorItemViewHolder.lGq.setChildOnLongClickListener(this.mOnLongClickListener);
                    pbCommenFloorItemViewHolder.lGq.setChildOnTouchListener(this.lFZ);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGq.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    pbCommenFloorItemViewHolder.lGq.setLayoutParams(layoutParams2);
                    pbCommenFloorItemViewHolder.lGq.setVisibility(8);
                }
            }
            if (postData.nnw) {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bja()) {
                pbCommenFloorItemViewHolder.lGs.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.biX()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGp.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lGr.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lGp.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lGp.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.biY()) {
                ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGp.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lGr.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lGp.setVisibility(8);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGV.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    pbCommenFloorItemViewHolder.lGp.setVisibility(0);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGV.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.biZ()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lGp.getLayoutParams();
                if (pbCommenFloorItemViewHolder.lGr.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.lGX.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lGM != null && pbCommenFloorItemViewHolder.lGJ != null) {
            if (postData == null || postData.nnA == null || StringUtils.isNull(postData.nnA.liveTitle)) {
                pbCommenFloorItemViewHolder.lGJ.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.lGM.setText(postData.nnA.liveTitle);
            pbCommenFloorItemViewHolder.lGJ.setTag(postData.nnA);
            pbCommenFloorItemViewHolder.lGJ.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lGR.setVisibility(postData.nnG ? 0 : 8);
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        if (pbCommenFloorItemViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
                n(pbCommenFloorItemViewHolder.lGg);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.hXC, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGh, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGi, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGj, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGC, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGk, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGs, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.lGn.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGW, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGX, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ao.d(pbCommenFloorItemViewHolder.lGq, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGr, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bja()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGr, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304);
                }
                pbCommenFloorItemViewHolder.lGr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(pbCommenFloorItemViewHolder.jMo, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jMm, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.lGq.onChangeSkinType();
                pbCommenFloorItemViewHolder.lGo.onChangeSkinType();
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGM, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGK, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(pbCommenFloorItemViewHolder.lGJ, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(pbCommenFloorItemViewHolder.lGL, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setImageResource(pbCommenFloorItemViewHolder.lGN, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lGQ, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.lGO.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lGQ.setText(R.string.close_content);
                } else if (this.lFd != null && StringUtils.isNull(this.lFd.diY())) {
                    pbCommenFloorItemViewHolder.lGQ.setText(this.lFd.diY());
                } else {
                    pbCommenFloorItemViewHolder.lGQ.setText(R.string.expand_content);
                }
                pbCommenFloorItemViewHolder.lGl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                pbCommenFloorItemViewHolder.Dq(skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(pbCommenFloorItemViewHolder.lGU, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.lGY, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            pbCommenFloorItemViewHolder.mSkinType = skinType;
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lGf.setOnTouchListener(this.lFZ);
        pbCommenFloorItemViewHolder.lGf.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lHa.dlL() != null && this.lHa.dlL().getPageContext() != null && this.lHa.dlL().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lHa.dlL().lEu;
            pbCommenFloorItemViewHolder.hXC.setOnClickListener(aVar.iJX);
            pbCommenFloorItemViewHolder.lGm.setOnClickListener(aVar.iJX);
            pbCommenFloorItemViewHolder.lGE.setOnClickListener(aVar.iJX);
            pbCommenFloorItemViewHolder.lGE.getHeadView().setOnClickListener(aVar.iJX);
            pbCommenFloorItemViewHolder.lGn.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lGn.setOnTouchListener(this.lFZ);
            pbCommenFloorItemViewHolder.lGn.setCommonTextViewOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGn.setOnImageClickListener(this.fSh);
            pbCommenFloorItemViewHolder.lGn.setOnImageTouchListener(this.lFZ);
            pbCommenFloorItemViewHolder.lGn.setOnEmotionClickListener(aVar.lUV);
            pbCommenFloorItemViewHolder.lGn.setOnVoiceAfterClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGI.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGJ.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGr.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGs.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGU.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGY.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pbCommenFloorItemViewHolder.jMo.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lHa.dlL().lEv;
            pbCommenFloorItemViewHolder.jMo.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.jMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lGf != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lVk.a(k.this.lFd, null, postData, pbCommenFloorItemViewHolder.lGn.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = k.this.lFd.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.lFd.getThreadId())) && k.this.lFd.diN() != null) {
                                threadId = k.this.lFd.diN().blV();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dW("tid", threadId).dW("fid", k.this.lFd.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", postData.getId()).dW("obj_source", k.this.dD(view)).an("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lGl.fcj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lFd != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lGl != null && pbCommenFloorItemViewHolder.lGl.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lGl.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lFd.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lFd.getThreadId())) && k.this.lFd.diN() != null) {
                            threadId = k.this.lFd.diN().blV();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dW("tid", threadId).dW("fid", k.this.lFd.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", pbCommenFloorItemViewHolder.lGl.getData().postId).dW("obj_source", k.this.dD(pbCommenFloorItemViewHolder.lGl)).an("obj_type", i));
                    }
                }
            };
            pbCommenFloorItemViewHolder.lGT.fcj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lFd != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lGT != null && pbCommenFloorItemViewHolder.lGT.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lGT.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lFd.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lFd.getThreadId())) && k.this.lFd.diN() != null) {
                            threadId = k.this.lFd.diN().blV();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dW("tid", threadId).dW("fid", k.this.lFd.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", pbCommenFloorItemViewHolder.lGT.getData().postId).dW("obj_source", k.this.dD(pbCommenFloorItemViewHolder.lGT)).an("obj_type", i));
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dD(View view) {
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
        this.lFW = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lFd = fVar;
    }

    public void gy(String str) {
        this.bhj = str;
    }

    public void uv(boolean z) {
        this.lFe = z;
    }

    private SpannableStringBuilder dY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.lHa.dlL(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lGn.setTextViewOnTouchListener(this.ftt);
        pbCommenFloorItemViewHolder.lGn.setTextViewCheckSelection(false);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lFn = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ftt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
