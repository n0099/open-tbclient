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
    private int aMg;
    private View.OnClickListener bdp;
    private String blY;
    private TbRichTextView.i fWO;
    private boolean fZW;
    private com.baidu.tieba.pb.a.c fyb;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jlE;
    private com.baidu.adp.lib.d.b<TbImageView> jlF;
    private int jvU;
    protected com.baidu.tieba.pb.data.f lJI;
    private boolean lJJ;
    private View.OnClickListener lJS;
    private TbRichTextView.c lKB;
    private com.baidu.tieba.pb.pb.sub.b lKC;
    private boolean lKD;
    private com.baidu.tieba.pb.a.c lKE;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(View view) {
        if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
            if (com.baidu.tbadk.a.d.bmQ() || com.baidu.tbadk.a.d.bmR()) {
                if (pbCommenFloorItemViewHolder.lLy != null && pbCommenFloorItemViewHolder.lLy.getData() != null) {
                    pbCommenFloorItemViewHolder.lLy.bxk();
                }
            } else if (pbCommenFloorItemViewHolder.lKQ != null && pbCommenFloorItemViewHolder.lKQ.getData() != null) {
                pbCommenFloorItemViewHolder.lKQ.bxk();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jvU = 0;
        this.lKB = null;
        this.lJJ = true;
        this.blY = null;
        this.lJI = null;
        this.lJS = null;
        this.bdp = null;
        this.fWO = null;
        this.fyb = null;
        this.mOnLongClickListener = null;
        this.lKC = null;
        this.fZW = true;
        this.lKD = com.baidu.tbadk.a.d.bmG();
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHK */
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
        this.jlF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byk */
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
        this.lKE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.lIO == null || k.this.lIO.doO() == null || k.this.lIO.doO().drP())) {
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
                if (k.this.fyb != null) {
                    if (!(view instanceof TbListTextView) || k.this.bdp == null) {
                        k.this.fyb.ad(view);
                        k.this.fyb.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.bdp.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.dnV() != null) {
            this.aMg = bVar.dnV().dqH();
        }
        this.jvU = getDimensionPixelSize(R.dimen.tbds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate;
        View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate2.findViewById(R.id.pb_post_reply_container);
        if (com.baidu.tbadk.a.d.bmS()) {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_c, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null);
        }
        viewGroup2.addView(inflate);
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.lLF.dpD().getPageContext(), inflate2, this.aMg, this.lKD);
        pbCommenFloorItemViewHolder.lKT.setConstrainLayoutPool(this.jlE);
        pbCommenFloorItemViewHolder.lKT.setImageViewPool(this.jlF);
        if (pbCommenFloorItemViewHolder.lKV != null) {
            pbCommenFloorItemViewHolder.lKV.setShowChildComment(this.lKD);
        }
        a(pbCommenFloorItemViewHolder);
        if (pbCommenFloorItemViewHolder.lKS != null) {
            pbCommenFloorItemViewHolder.lKS.setDuiEnabled(this.fZW);
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
            postData2.bsE();
            i(postData2);
            a(pbCommenFloorItemViewHolder, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fZW = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.nsp) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b2 = com.baidu.tieba.pb.c.a.b(this.lJI, postData, postData.locate, i, 6);
            postData.nsq = b2;
            if (!com.baidu.tbadk.core.util.x.isEmpty(postData.dPa())) {
                Iterator<PostData> it = postData.dPa().iterator();
                while (it.hasNext()) {
                    it.next().nsq = b2;
                }
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lKY.setVisibility(8);
            if (com.baidu.tbadk.a.d.bmQ()) {
                pbCommenFloorItemViewHolder.lLx.setVisibility(0);
                pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                pbCommenFloorItemViewHolder.lLA.setVisibility(8);
                pbCommenFloorItemViewHolder.jQT.setVisibility(8);
                pbCommenFloorItemViewHolder.jQR.setVisibility(8);
                pbCommenFloorItemViewHolder.lKQ.setVisibility(8);
                pbCommenFloorItemViewHolder.lLD.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bmR()) {
                pbCommenFloorItemViewHolder.lLx.setVisibility(0);
                pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                pbCommenFloorItemViewHolder.lLA.setVisibility(0);
                pbCommenFloorItemViewHolder.jQT.setVisibility(8);
                pbCommenFloorItemViewHolder.jQR.setVisibility(8);
                pbCommenFloorItemViewHolder.lKQ.setVisibility(8);
                pbCommenFloorItemViewHolder.lLD.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bmS()) {
                pbCommenFloorItemViewHolder.lLA.setVisibility(8);
                pbCommenFloorItemViewHolder.lLx.setVisibility(8);
                pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                pbCommenFloorItemViewHolder.jQT.setVisibility(0);
                pbCommenFloorItemViewHolder.jQR.setVisibility(0);
                pbCommenFloorItemViewHolder.lKQ.setVisibility(0);
                pbCommenFloorItemViewHolder.lLD.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.lLx.setVisibility(8);
                pbCommenFloorItemViewHolder.lLA.setVisibility(8);
                pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                pbCommenFloorItemViewHolder.jQT.setVisibility(0);
                pbCommenFloorItemViewHolder.jQR.setVisibility(0);
                pbCommenFloorItemViewHolder.lKQ.setVisibility(0);
                pbCommenFloorItemViewHolder.lLD.setVisibility(8);
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
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lKK != null) {
            if (this.lLF != null && this.lLF.dnV() != null && this.lLF.dnV().dqP() && com.baidu.tbadk.core.util.at.equals(this.lLF.dnV().dpV(), postData.getId())) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.lKK, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.lKK, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        if (z) {
            pbCommenFloorItemViewHolder.lLt.setVisibility(8);
            if (StringUtils.isNull(str)) {
                pbCommenFloorItemViewHolder.lLv.setText(R.string.expand_content);
                return;
            } else {
                pbCommenFloorItemViewHolder.lLv.setText(str);
                return;
            }
        }
        pbCommenFloorItemViewHolder.lLt.setVisibility(0);
        pbCommenFloorItemViewHolder.lLv.setText(R.string.close_content);
    }

    private void c(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final PostData postData) {
        if (postData.dPp() == 2 || postData.dPp() == 4) {
            pbCommenFloorItemViewHolder.lLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = pbCommenFloorItemViewHolder.lLt.getVisibility() == 8;
                    k.this.a(pbCommenFloorItemViewHolder, !z, postData.dmP());
                    postData.ye(z ? false : true);
                    k.this.d(pbCommenFloorItemViewHolder, postData);
                    if (k.this.lIO != null && k.this.lIO.doO() != null && k.this.lIO.doO().dsU() != null && k.this.lIO.doO().getListView() != null && !z && pbCommenFloorItemViewHolder.getView().getTop() < k.this.lIO.doO().dsU().getMeasuredHeight()) {
                        k.this.lIO.doO().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.x.getPosition(k.this.lIO.doO().getListView().getData(), postData) + k.this.lIO.doO().getListView().getHeaderViewsCount(), k.this.lIO.doO().dsU().getMeasuredHeight());
                    }
                }
            });
            pbCommenFloorItemViewHolder.lLu.setVisibility(0);
            a(pbCommenFloorItemViewHolder, postData.dOY(), postData.dmP());
            a(true, pbCommenFloorItemViewHolder, postData);
        } else {
            pbCommenFloorItemViewHolder.lLu.setVisibility(8);
            pbCommenFloorItemViewHolder.lLt.setVisibility(0);
            a(false, pbCommenFloorItemViewHolder, postData);
        }
        d(pbCommenFloorItemViewHolder, postData);
    }

    private void a(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.mBottomLine != null && pbCommenFloorItemViewHolder.lLu != null && (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.lLu.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.x.isEmpty(postData.dPa());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.lLu.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().tH(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().tG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().tG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.lLu.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().tG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().tH(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        TbRichText dPf = postData.dPf();
        dPf.isChanged = true;
        pbCommenFloorItemViewHolder.lKS.setText(dPf, true, this.lKB);
    }

    private void j(PostData postData) {
        if (postData.eUv == 0 && postData.jog) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dX("post_id", postData.getId());
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dX("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dX("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dX("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dX("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lLF != null) {
                int dqH = this.lLF.dnV().dqH();
                if (1 == dqH || 2 == dqH) {
                    aqVar.dX("obj_source", "1");
                } else if (3 == dqH) {
                    aqVar.dX("obj_source", "2");
                } else {
                    aqVar.dX("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.brq() != null && postData.brq().getAlaInfo() != null && postData.brq().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.brq().getUserId();
        String forumId = this.lJI != null ? this.lJI.getForumId() : "";
        String forumName = this.lJI != null ? this.lJI.getForumName() : "";
        int dPd = postData.dPd();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dX("fid", forumId);
        aqVar.dX("fname", forumName);
        aqVar.dX("obj_param1", userId);
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("tid", id);
        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, dPd);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.lJI != null) {
            if (this.lJI.dne()) {
                if (this.lLG != null) {
                    com.baidu.tieba.pb.c.a.a(this.lLG.getUniqueId(), this.lJI, postData, postData.locate, postData.nsp ? 2 : 8);
                }
            } else if (this.lIO != null) {
                com.baidu.tieba.pb.c.a.a(this.lIO.getUniqueId(), this.lJI, postData, postData.locate, postData.nsp ? 2 : 8);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.duO() == null) {
            pbCommenFloorItemViewHolder.lLn.setVisibility(8);
            return;
        }
        TbRichText dPf = postData.dPf();
        com.baidu.tieba.pb.view.b.a(postData.duO(), pbCommenFloorItemViewHolder.lLn, false, false, dPf != null && StringUtils.isNull(dPf.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lJJ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKS.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lKS.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lKS.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lKS.EW(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKS.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lKS.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lKS.EW(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lKS.setTextViewOnTouchListener(this.lKE);
        pbCommenFloorItemViewHolder.lKS.setTextViewCheckSelection(false);
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.brq() == null || postData.brq().isBaijiahaoUser()) {
            }
            if (postData.nsg) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lKR.setTag(null);
            pbCommenFloorItemViewHolder.lKR.setUserId(null);
            pbCommenFloorItemViewHolder.icj.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lLj.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lKS.setIsHost(false);
            if (postData.brq() != null) {
                if (this.blY != null && !this.blY.equals("0") && this.blY.equals(postData.brq().getUserId())) {
                    pbCommenFloorItemViewHolder.lKS.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.brq().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.brq().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lLl != null) {
                    pbCommenFloorItemViewHolder.lLl.setTag(R.id.tag_user_id, postData.brq().getUserId());
                    if (this.lLF != null && this.lLF.dpD() != null) {
                        pbCommenFloorItemViewHolder.lLl.setOnClickListener(this.lLF.dpD().lJa.lZy);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lLl.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lLk != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lLk.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lLF != null && this.lLF.dpD() != null) {
                        pbCommenFloorItemViewHolder.lLk.setOnClickListener(this.lLF.dpD().lJa.lZz);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lLk.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.x.isEmpty(tShowInfoNew) || postData.brq().isBigV()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0107, 1);
                }
                String avater = postData.brq().getAvater();
                int i2 = 8;
                if (postData.nsp) {
                    i2 = 2;
                }
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_user_id, postData.brq().getUserId());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_user_name, postData.brq().getUserName());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_virtual_user_url, postData.brq().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lJI, postData, postData.locate, i2, 2));
                String name_show = postData.brq().getName_show();
                String userName = postData.brq().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.icj.setText(com.baidu.tieba.pb.c.bb(this.mContext, pbCommenFloorItemViewHolder.icj.getText().toString()));
                    pbCommenFloorItemViewHolder.icj.setGravity(16);
                    pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmo());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0312, 1);
                }
                if (postData.brq().getPendantData() != null && !StringUtils.isNull(postData.brq().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lLj.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lLj.a(postData.brq(), 4);
                    pbCommenFloorItemViewHolder.lKR.setVisibility(8);
                    pbCommenFloorItemViewHolder.lLj.setVisibility(0);
                    pbCommenFloorItemViewHolder.lLj.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setUserId(postData.brq().getUserId());
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setUserName(postData.brq().getUserName());
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setFid(this.lJI != null ? this.lJI.getForumId() : "");
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setFName(this.lJI != null ? this.lJI.getForumName() : "");
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setFloor(postData.dPd());
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lJI, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lLj.Cu(postData.brq().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lKR.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lKR, postData.brq(), 4);
                    pbCommenFloorItemViewHolder.lKR.setUserId(postData.brq().getUserId());
                    pbCommenFloorItemViewHolder.lKR.setFid(this.lJI != null ? this.lJI.getForumId() : "");
                    pbCommenFloorItemViewHolder.lKR.setFName(this.lJI != null ? this.lJI.getForumName() : "");
                    pbCommenFloorItemViewHolder.lKR.setFloor(postData.dPd());
                    pbCommenFloorItemViewHolder.lKR.setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lKR.setUserName(postData.brq().getUserName(), postData.dPn());
                    pbCommenFloorItemViewHolder.lKR.setTag(R.id.tag_virtual_user_url, postData.brq().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lKR.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lJI, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lKR.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lKR.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lKR.setVisibility(0);
                    pbCommenFloorItemViewHolder.lLj.setVisibility(8);
                }
                if (postData.brq() != null && postData.brq().getAlaInfo() != null && postData.brq().getAlaUserData() != null && postData.brq().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.tq(true);
                    pbCommenFloorItemViewHolder.lKR.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lKR.setAlaInfo(postData.brq().getAlaInfo());
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setAlaInfo(postData.brq().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.tq(false);
                    pbCommenFloorItemViewHolder.lKR.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lKR.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lLj.getHeadView().setAlaInfo(null);
                }
                a(pbCommenFloorItemViewHolder.lKL, postData);
            }
            int i3 = 0;
            if (this.lLF != null && this.lLF.dpD() != null && this.lLF.dpD().dnN() && postData.brq() != null) {
                i3 = postData.brq().getLevel_id();
            }
            if (this.lJI != null && this.lJI.dnh()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.lLi.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(pbCommenFloorItemViewHolder.lLi, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                pbCommenFloorItemViewHolder.lLi.setVisibility(8);
            }
            int i4 = 15;
            if (pbCommenFloorItemViewHolder.lLl.getChildCount() == 1) {
                i4 = 13;
            } else if (pbCommenFloorItemViewHolder.lLl.getChildCount() > 1) {
                i4 = 11;
            }
            if (pbCommenFloorItemViewHolder.lKL.getVisibility() == 0) {
                i4 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lLk.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bsS() > 1000) {
                i4 -= 2;
            }
            if (postData.bsS() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                pbCommenFloorItemViewHolder.lLl.setVisibility(8);
                if (pbCommenFloorItemViewHolder.lLl.getChildCount() == 1) {
                    i4 += 2;
                } else if (pbCommenFloorItemViewHolder.lLl.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lKL.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lKL.setVisibility(8);
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lLi.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lLi.setVisibility(8);
                }
            }
            String name_show2 = postData.brq() != null ? postData.brq().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.brq() != null && !StringUtils.isNull(postData.brq().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.brq() != null && !StringUtils.isNull(postData.brq().getSealPrefix())) {
                pbCommenFloorItemViewHolder.icj.setText(dZ(postData.brq().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.icj.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPd()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.lKQ);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.lLy);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.jQT);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.jQR);
            bz bzVar = null;
            if (this.lJI != null && this.lJI.dmE() != null) {
                bzVar = this.lJI.dmE();
            }
            if (bzVar != null && bzVar.bpZ()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, true);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, false);
            }
            boolean z4 = false;
            if (postData.brq() != null && !StringUtils.isNull(postData.brq().getVirtualUserUrl())) {
                z4 = true;
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (this.lJI != null && this.lJI.dmT() != 0) {
                if (this.lJI.dmT() != 1002 && this.lJI.dmT() != 3) {
                    z5 = true;
                }
                if (this.lJI.dmT() != 3 && !this.lJI.dnh()) {
                    z6 = true;
                }
                if (postData != null && postData.brq() != null) {
                    String userId = postData.brq().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z5 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z5 = false;
                    }
                }
            }
            if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().brq() != null && postData.brq() != null) {
                String userId2 = this.lJI.dmE().brq().getUserId();
                String userId3 = postData.brq().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z6 = true;
                    z7 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z7 = false;
                        z8 = true;
                    }
                }
            }
            if (postData == null || postData.brq() == null || !UtilHelper.isCurrentAccount(postData.brq().getUserId())) {
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
            if (postData.dPd() == 1) {
                i5 = 0;
            }
            if (z3) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJI.dmT()));
                if (postData.brq() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.brq().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.brq().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.brq().getPortrait());
                }
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            if (z2) {
                sparseArray.put(R.id.tag_user_mute_visible, true);
                sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.brq() != null) {
                    sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brq().getUserId());
                    sparseArray.put(R.id.tag_user_mute_mute_username, postData.brq().getUserName());
                    sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brq().getName_show());
                }
                if (this.lJI.dmE() != null) {
                    sparseArray.put(R.id.tag_user_mute_thread_id, this.lJI.dmE().getId());
                }
                sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z6) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJI.dmT()));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            pbCommenFloorItemViewHolder.lKS.setTag(sparseArray);
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
            if (this.lJI != null && this.lJI.dnh()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.brq() != null) {
                MetaData brq = postData.brq();
                if (this.blY != null && !this.blY.equals("0") && this.blY.equals(brq.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pK(R.string.J_X04).pN(R.dimen.L_X01).pC(R.color.CAM_X0302).pM(R.color.CAM_X0302);
                } else if (brq.getIs_bawu() == 1 && postData.dOV()) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (brq.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(brq.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (brq.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(brq.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (brq.getIs_bawu() == 1 && "pri_content_assist".equals(brq.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (brq.getIs_bawu() == 1 && "pri_manage_assist".equals(brq.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
        if (pbCommenFloorItemViewHolder != null && postData != null && pbCommenFloorItemViewHolder.lLm != null && this.lJI != null) {
            pbCommenFloorItemViewHolder.lLm.setVisibility(8);
        }
    }

    private void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.btk() != null) {
            postData.btk().threadId = this.lLF.dnV().dpW();
            postData.btk().objType = 1;
            postData.btk().isInPost = true;
            bz bzVar = null;
            if (this.lJI != null && this.lJI.dmE() != null) {
                bzVar = this.lJI.dmE();
            }
            if (bzVar != null && bzVar.bpZ()) {
                pbCommenFloorItemViewHolder.lKQ.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lKQ.setThreadData(bzVar);
            pbCommenFloorItemViewHolder.lKQ.setData(postData.btk());
            pbCommenFloorItemViewHolder.lLy.setThreadData(bzVar);
            pbCommenFloorItemViewHolder.lLy.setData(postData.btk());
        }
    }

    private void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dPd() > 0 && this.lJI != null && !this.lJI.dnh()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dPd()));
                pbCommenFloorItemViewHolder.lLh.setVisibility(0);
                pbCommenFloorItemViewHolder.lLh.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lLh.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dPg = postData.dPg();
            boolean z2 = (dPg == null || StringUtils.isNull(dPg.getName()) || this.lJI == null || this.lJI.dnh()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lKN.setVisibility(0);
                i = this.jvU;
            } else {
                pbCommenFloorItemViewHolder.lKN.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lKO.setVisibility(0);
                i2 = this.jvU;
            } else {
                pbCommenFloorItemViewHolder.lKO.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lKM.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lKM.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lKM.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lKP.setVisibility(0);
                pbCommenFloorItemViewHolder.lKP.setPadding(this.jvU, 0, 0, 0);
                if (postData.nso) {
                    pbCommenFloorItemViewHolder.lKP.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dPg.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    pbCommenFloorItemViewHolder.lKP.setText(dPg.getName());
                }
            } else {
                pbCommenFloorItemViewHolder.lKP.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lLB.setText(((Object) pbCommenFloorItemViewHolder.lKM.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.bmR()) {
                if (z) {
                    pbCommenFloorItemViewHolder.lLB.setVisibility(0);
                    pbCommenFloorItemViewHolder.lKM.setVisibility(8);
                    pbCommenFloorItemViewHolder.lKN.setVisibility(8);
                    return;
                }
                pbCommenFloorItemViewHolder.lLB.setVisibility(8);
                pbCommenFloorItemViewHolder.lKM.setVisibility(0);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKS.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.lKS.setPadding(0, 0, 0, 0);
            if (!this.lJJ) {
                pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().tB(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.lKS.EW(null);
                pbCommenFloorItemViewHolder.lKS.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().tB(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.lKS.getLayoutStrategy().ty(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lKS, view, !StringUtils.isNull(postData.getBimg_url()));
            pbCommenFloorItemViewHolder.lKS.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lKS.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lKS.setIsFromCDN(this.mIsFromCDN);
            pbCommenFloorItemViewHolder.lKS.setText(postData.dPf(), true, this.lKB);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lKS.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbCommenFloorItemViewHolder.lKS.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lKK.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.lLD.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lLz.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().tz(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fYR = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().tA((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dPh() > 0) {
                pbCommenFloorItemViewHolder.lKX.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lKX.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lKX.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dPp() == 2) {
                    pbCommenFloorItemViewHolder.lKX.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lKX.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.lKW.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.jQT != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.jQT.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.jQT.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.jQR != null) {
                SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jQR.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.jQR.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            if (postData.dPh() > 0 && !this.lKD) {
                pbCommenFloorItemViewHolder.lKW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dPh())));
                SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.lKW.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.lKW.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                pbCommenFloorItemViewHolder.lKW.setVisibility(0);
                pbCommenFloorItemViewHolder.lKX.setVisibility(8);
                pbCommenFloorItemViewHolder.lKV.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.lKW.setVisibility(8);
                if (postData.dPh() > 0 && postData.dPa() != null && postData.dPa().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKV.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.lKV.setLayoutParams(layoutParams);
                    if (this.lKC == null) {
                        this.lKC = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lKC.setIsFromCDN(this.mIsFromCDN);
                        this.lKC.setOnLongClickListener(this.mOnLongClickListener);
                        this.lKC.Y(this.lJS);
                        this.lKC.C(this.bdp);
                        String str = null;
                        if (this.lJI != null && this.lJI.dmE() != null && this.lJI.dmE().brq() != null) {
                            str = this.lJI.dmE().brq().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lJI != null) {
                            this.lKC.ad(this.lJI.dmT(), z);
                            this.lKC.setThreadData(this.lJI.dmE());
                        }
                    }
                    this.lKC.Qo(postData.getId());
                    pbCommenFloorItemViewHolder.lKV.setSubPbAdapter(this.lKC);
                    pbCommenFloorItemViewHolder.lKV.setVisibility(0);
                    pbCommenFloorItemViewHolder.lKV.setData(postData, view);
                    pbCommenFloorItemViewHolder.lKV.setChildOnClickListener(this.bdp);
                    pbCommenFloorItemViewHolder.lKV.setChildOnLongClickListener(this.mOnLongClickListener);
                    pbCommenFloorItemViewHolder.lKV.setChildOnTouchListener(this.lKE);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKV.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    pbCommenFloorItemViewHolder.lKV.setLayoutParams(layoutParams2);
                    pbCommenFloorItemViewHolder.lKV.setVisibility(8);
                }
            }
            if (postData.nse) {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bmT()) {
                pbCommenFloorItemViewHolder.lKX.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.bmQ()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKU.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lKW.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lKU.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.bmR()) {
                ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKU.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lKW.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lKU.setVisibility(8);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lLA.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lLA.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.bmS()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKU.getLayoutParams();
                if (pbCommenFloorItemViewHolder.lKW.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.lLC.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lLr != null && pbCommenFloorItemViewHolder.lLo != null) {
            if (postData == null || postData.nsi == null || StringUtils.isNull(postData.nsi.liveTitle)) {
                pbCommenFloorItemViewHolder.lLo.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.lLr.setText(postData.nsi.liveTitle);
            pbCommenFloorItemViewHolder.lLo.setTag(postData.nsi);
            pbCommenFloorItemViewHolder.lLo.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lLw.setVisibility(postData.nso ? 0 : 8);
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        if (pbCommenFloorItemViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
                n(pbCommenFloorItemViewHolder.lKL);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKM, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKN, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKO, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLh, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKP, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKX, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.lKS.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLB, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLC, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ao.d(pbCommenFloorItemViewHolder.lKV, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKW, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bmT()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKW, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304);
                }
                pbCommenFloorItemViewHolder.lKW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(pbCommenFloorItemViewHolder.jQT, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jQR, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.lKV.onChangeSkinType();
                pbCommenFloorItemViewHolder.lKT.onChangeSkinType();
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLr, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLp, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(pbCommenFloorItemViewHolder.lLo, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(pbCommenFloorItemViewHolder.lLq, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setImageResource(pbCommenFloorItemViewHolder.lLs, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLv, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.lLt.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lLv.setText(R.string.close_content);
                } else if (this.lJI != null && StringUtils.isNull(this.lJI.dmP())) {
                    pbCommenFloorItemViewHolder.lLv.setText(this.lJI.dmP());
                } else {
                    pbCommenFloorItemViewHolder.lLv.setText(R.string.expand_content);
                }
                pbCommenFloorItemViewHolder.lKQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                pbCommenFloorItemViewHolder.EW(skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(pbCommenFloorItemViewHolder.lLz, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.lLD, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            pbCommenFloorItemViewHolder.mSkinType = skinType;
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lKK.setOnTouchListener(this.lKE);
        pbCommenFloorItemViewHolder.lKK.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lLF.dpD() != null && this.lLF.dpD().getPageContext() != null && this.lLF.dpD().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lLF.dpD().lJa;
            pbCommenFloorItemViewHolder.icj.setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lKR.setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lLj.setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lLj.getHeadView().setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lKS.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lKS.setOnTouchListener(this.lKE);
            pbCommenFloorItemViewHolder.lKS.setCommonTextViewOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lKS.setOnImageClickListener(this.fWO);
            pbCommenFloorItemViewHolder.lKS.setOnImageTouchListener(this.lKE);
            pbCommenFloorItemViewHolder.lKS.setOnEmotionClickListener(aVar.lZA);
            pbCommenFloorItemViewHolder.lKS.setOnVoiceAfterClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLn.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLo.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lKW.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lKX.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLz.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLD.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pbCommenFloorItemViewHolder.jQT.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lLF.dpD().lJb;
            pbCommenFloorItemViewHolder.jQT.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.jQR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lKK != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lZP.a(k.this.lJI, null, postData, pbCommenFloorItemViewHolder.lKS.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = k.this.lJI.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.lJI.getThreadId())) && k.this.lJI.dmE() != null) {
                                threadId = k.this.lJI.dmE().bpO();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", threadId).dX("fid", k.this.lJI.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData.getId()).dX("obj_source", k.this.dD(view)).an("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lKQ.fgS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lJI != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lKQ != null && pbCommenFloorItemViewHolder.lKQ.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lKQ.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lJI.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lJI.getThreadId())) && k.this.lJI.dmE() != null) {
                            threadId = k.this.lJI.dmE().bpO();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", threadId).dX("fid", k.this.lJI.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", pbCommenFloorItemViewHolder.lKQ.getData().postId).dX("obj_source", k.this.dD(pbCommenFloorItemViewHolder.lKQ)).an("obj_type", i));
                    }
                }
            };
            pbCommenFloorItemViewHolder.lLy.fgS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lJI != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lLy != null && pbCommenFloorItemViewHolder.lLy.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lLy.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lJI.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lJI.getThreadId())) && k.this.lJI.dmE() != null) {
                            threadId = k.this.lJI.dmE().bpO();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", threadId).dX("fid", k.this.lJI.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", pbCommenFloorItemViewHolder.lLy.getData().postId).dX("obj_source", k.this.dD(pbCommenFloorItemViewHolder.lLy)).an("obj_type", i));
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
        this.lKB = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lJI = fVar;
    }

    public void hJ(String str) {
        this.blY = str;
    }

    public void uz(boolean z) {
        this.lJJ = z;
    }

    private SpannableStringBuilder dZ(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.lLF.dpD(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lKS.setTextViewOnTouchListener(this.fyb);
        pbCommenFloorItemViewHolder.lKS.setTextViewCheckSelection(false);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJS = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fyb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
