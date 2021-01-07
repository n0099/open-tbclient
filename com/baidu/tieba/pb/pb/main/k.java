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
    protected com.baidu.tieba.pb.data.f lJH;
    private boolean lJI;
    private View.OnClickListener lJR;
    private TbRichTextView.c lKA;
    private com.baidu.tieba.pb.pb.sub.b lKB;
    private boolean lKC;
    private com.baidu.tieba.pb.a.c lKD;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(View view) {
        if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
            if (com.baidu.tbadk.a.d.bmR() || com.baidu.tbadk.a.d.bmS()) {
                if (pbCommenFloorItemViewHolder.lLx != null && pbCommenFloorItemViewHolder.lLx.getData() != null) {
                    pbCommenFloorItemViewHolder.lLx.bxl();
                }
            } else if (pbCommenFloorItemViewHolder.lKP != null && pbCommenFloorItemViewHolder.lKP.getData() != null) {
                pbCommenFloorItemViewHolder.lKP.bxl();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jvU = 0;
        this.lKA = null;
        this.lJI = true;
        this.blY = null;
        this.lJH = null;
        this.lJR = null;
        this.bdp = null;
        this.fWO = null;
        this.fyb = null;
        this.mOnLongClickListener = null;
        this.lKB = null;
        this.fZW = true;
        this.lKC = com.baidu.tbadk.a.d.bmH();
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHL */
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
            /* renamed from: byl */
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
        this.lKD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.lIN == null || k.this.lIN.doP() == null || k.this.lIN.doP().drQ())) {
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
        if (bVar != null && bVar.dnW() != null) {
            this.aMg = bVar.dnW().dqI();
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
        if (com.baidu.tbadk.a.d.bmT()) {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_c, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null);
        }
        viewGroup2.addView(inflate);
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.lLE.dpE().getPageContext(), inflate2, this.aMg, this.lKC);
        pbCommenFloorItemViewHolder.lKS.setConstrainLayoutPool(this.jlE);
        pbCommenFloorItemViewHolder.lKS.setImageViewPool(this.jlF);
        if (pbCommenFloorItemViewHolder.lKU != null) {
            pbCommenFloorItemViewHolder.lKU.setShowChildComment(this.lKC);
        }
        a(pbCommenFloorItemViewHolder);
        if (pbCommenFloorItemViewHolder.lKR != null) {
            pbCommenFloorItemViewHolder.lKR.setDuiEnabled(this.fZW);
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
            postData2.bsF();
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
            if (postData.nso) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b2 = com.baidu.tieba.pb.c.a.b(this.lJH, postData, postData.locate, i, 6);
            postData.nsp = b2;
            if (!com.baidu.tbadk.core.util.x.isEmpty(postData.dPb())) {
                Iterator<PostData> it = postData.dPb().iterator();
                while (it.hasNext()) {
                    it.next().nsp = b2;
                }
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lKX.setVisibility(8);
            if (com.baidu.tbadk.a.d.bmR()) {
                pbCommenFloorItemViewHolder.lLw.setVisibility(0);
                pbCommenFloorItemViewHolder.lKT.setVisibility(0);
                pbCommenFloorItemViewHolder.lLz.setVisibility(8);
                pbCommenFloorItemViewHolder.jQT.setVisibility(8);
                pbCommenFloorItemViewHolder.jQR.setVisibility(8);
                pbCommenFloorItemViewHolder.lKP.setVisibility(8);
                pbCommenFloorItemViewHolder.lLC.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bmS()) {
                pbCommenFloorItemViewHolder.lLw.setVisibility(0);
                pbCommenFloorItemViewHolder.lKT.setVisibility(0);
                pbCommenFloorItemViewHolder.lLz.setVisibility(0);
                pbCommenFloorItemViewHolder.jQT.setVisibility(8);
                pbCommenFloorItemViewHolder.jQR.setVisibility(8);
                pbCommenFloorItemViewHolder.lKP.setVisibility(8);
                pbCommenFloorItemViewHolder.lLC.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bmT()) {
                pbCommenFloorItemViewHolder.lLz.setVisibility(8);
                pbCommenFloorItemViewHolder.lLw.setVisibility(8);
                pbCommenFloorItemViewHolder.lKT.setVisibility(0);
                pbCommenFloorItemViewHolder.jQT.setVisibility(0);
                pbCommenFloorItemViewHolder.jQR.setVisibility(0);
                pbCommenFloorItemViewHolder.lKP.setVisibility(0);
                pbCommenFloorItemViewHolder.lLC.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.lLw.setVisibility(8);
                pbCommenFloorItemViewHolder.lLz.setVisibility(8);
                pbCommenFloorItemViewHolder.lKT.setVisibility(0);
                pbCommenFloorItemViewHolder.jQT.setVisibility(0);
                pbCommenFloorItemViewHolder.jQR.setVisibility(0);
                pbCommenFloorItemViewHolder.lKP.setVisibility(0);
                pbCommenFloorItemViewHolder.lLC.setVisibility(8);
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
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lKJ != null) {
            if (this.lLE != null && this.lLE.dnW() != null && this.lLE.dnW().dqQ() && com.baidu.tbadk.core.util.at.equals(this.lLE.dnW().dpW(), postData.getId())) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.lKJ, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.lKJ, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        if (z) {
            pbCommenFloorItemViewHolder.lLs.setVisibility(8);
            if (StringUtils.isNull(str)) {
                pbCommenFloorItemViewHolder.lLu.setText(R.string.expand_content);
                return;
            } else {
                pbCommenFloorItemViewHolder.lLu.setText(str);
                return;
            }
        }
        pbCommenFloorItemViewHolder.lLs.setVisibility(0);
        pbCommenFloorItemViewHolder.lLu.setText(R.string.close_content);
    }

    private void c(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final PostData postData) {
        if (postData.dPq() == 2 || postData.dPq() == 4) {
            pbCommenFloorItemViewHolder.lLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = pbCommenFloorItemViewHolder.lLs.getVisibility() == 8;
                    k.this.a(pbCommenFloorItemViewHolder, !z, postData.dmQ());
                    postData.ye(z ? false : true);
                    k.this.d(pbCommenFloorItemViewHolder, postData);
                    if (k.this.lIN != null && k.this.lIN.doP() != null && k.this.lIN.doP().dsV() != null && k.this.lIN.doP().getListView() != null && !z && pbCommenFloorItemViewHolder.getView().getTop() < k.this.lIN.doP().dsV().getMeasuredHeight()) {
                        k.this.lIN.doP().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.x.getPosition(k.this.lIN.doP().getListView().getData(), postData) + k.this.lIN.doP().getListView().getHeaderViewsCount(), k.this.lIN.doP().dsV().getMeasuredHeight());
                    }
                }
            });
            pbCommenFloorItemViewHolder.lLt.setVisibility(0);
            a(pbCommenFloorItemViewHolder, postData.dOZ(), postData.dmQ());
            a(true, pbCommenFloorItemViewHolder, postData);
        } else {
            pbCommenFloorItemViewHolder.lLt.setVisibility(8);
            pbCommenFloorItemViewHolder.lLs.setVisibility(0);
            a(false, pbCommenFloorItemViewHolder, postData);
        }
        d(pbCommenFloorItemViewHolder, postData);
    }

    private void a(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.mBottomLine != null && pbCommenFloorItemViewHolder.lLt != null && (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.lLt.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.x.isEmpty(postData.dPb());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.lLt.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tH(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.lLt.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tG(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tH(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        TbRichText dPg = postData.dPg();
        dPg.isChanged = true;
        pbCommenFloorItemViewHolder.lKR.setText(dPg, true, this.lKA);
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
            if (this.lLE != null) {
                int dqI = this.lLE.dnW().dqI();
                if (1 == dqI || 2 == dqI) {
                    aqVar.dX("obj_source", "1");
                } else if (3 == dqI) {
                    aqVar.dX("obj_source", "2");
                } else {
                    aqVar.dX("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.brr() != null && postData.brr().getAlaInfo() != null && postData.brr().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.brr().getUserId();
        String forumId = this.lJH != null ? this.lJH.getForumId() : "";
        String forumName = this.lJH != null ? this.lJH.getForumName() : "";
        int dPe = postData.dPe();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dX("fid", forumId);
        aqVar.dX("fname", forumName);
        aqVar.dX("obj_param1", userId);
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("tid", id);
        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, dPe);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.lJH != null) {
            if (this.lJH.dnf()) {
                if (this.lLF != null) {
                    com.baidu.tieba.pb.c.a.a(this.lLF.getUniqueId(), this.lJH, postData, postData.locate, postData.nso ? 2 : 8);
                }
            } else if (this.lIN != null) {
                com.baidu.tieba.pb.c.a.a(this.lIN.getUniqueId(), this.lJH, postData, postData.locate, postData.nso ? 2 : 8);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.duP() == null) {
            pbCommenFloorItemViewHolder.lLm.setVisibility(8);
            return;
        }
        TbRichText dPg = postData.dPg();
        com.baidu.tieba.pb.view.b.a(postData.duP(), pbCommenFloorItemViewHolder.lLm, false, false, dPg != null && StringUtils.isNull(dPg.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lJI) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKR.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lKR.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lKR.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lKR.EV(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKR.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lKR.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lKR.EV(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lKR.setTextViewOnTouchListener(this.lKD);
        pbCommenFloorItemViewHolder.lKR.setTextViewCheckSelection(false);
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.brr() == null || postData.brr().isBaijiahaoUser()) {
            }
            if (postData.nsf) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lKQ.setTag(null);
            pbCommenFloorItemViewHolder.lKQ.setUserId(null);
            pbCommenFloorItemViewHolder.icj.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lLi.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lKR.setIsHost(false);
            if (postData.brr() != null) {
                if (this.blY != null && !this.blY.equals("0") && this.blY.equals(postData.brr().getUserId())) {
                    pbCommenFloorItemViewHolder.lKR.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.brr().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.brr().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lLk != null) {
                    pbCommenFloorItemViewHolder.lLk.setTag(R.id.tag_user_id, postData.brr().getUserId());
                    if (this.lLE != null && this.lLE.dpE() != null) {
                        pbCommenFloorItemViewHolder.lLk.setOnClickListener(this.lLE.dpE().lIZ.lZx);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lLk.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lLj != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lLj.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lLE != null && this.lLE.dpE() != null) {
                        pbCommenFloorItemViewHolder.lLj.setOnClickListener(this.lLE.dpE().lIZ.lZy);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lLj.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.x.isEmpty(tShowInfoNew) || postData.brr().isBigV()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0107, 1);
                }
                String avater = postData.brr().getAvater();
                int i2 = 8;
                if (postData.nso) {
                    i2 = 2;
                }
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_user_id, postData.brr().getUserId());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_user_name, postData.brr().getUserName());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_virtual_user_url, postData.brr().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lJH, postData, postData.locate, i2, 2));
                String name_show = postData.brr().getName_show();
                String userName = postData.brr().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.icj.setText(com.baidu.tieba.pb.c.bb(this.mContext, pbCommenFloorItemViewHolder.icj.getText().toString()));
                    pbCommenFloorItemViewHolder.icj.setGravity(16);
                    pbCommenFloorItemViewHolder.icj.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmp());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0312, 1);
                }
                if (postData.brr().getPendantData() != null && !StringUtils.isNull(postData.brr().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lLi.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lLi.a(postData.brr(), 4);
                    pbCommenFloorItemViewHolder.lKQ.setVisibility(8);
                    pbCommenFloorItemViewHolder.lLi.setVisibility(0);
                    pbCommenFloorItemViewHolder.lLi.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setUserId(postData.brr().getUserId());
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setUserName(postData.brr().getUserName());
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setFid(this.lJH != null ? this.lJH.getForumId() : "");
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setFName(this.lJH != null ? this.lJH.getForumName() : "");
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setFloor(postData.dPe());
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lJH, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lLi.Ct(postData.brr().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lKQ.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lKQ, postData.brr(), 4);
                    pbCommenFloorItemViewHolder.lKQ.setUserId(postData.brr().getUserId());
                    pbCommenFloorItemViewHolder.lKQ.setFid(this.lJH != null ? this.lJH.getForumId() : "");
                    pbCommenFloorItemViewHolder.lKQ.setFName(this.lJH != null ? this.lJH.getForumName() : "");
                    pbCommenFloorItemViewHolder.lKQ.setFloor(postData.dPe());
                    pbCommenFloorItemViewHolder.lKQ.setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lKQ.setUserName(postData.brr().getUserName(), postData.dPo());
                    pbCommenFloorItemViewHolder.lKQ.setTag(R.id.tag_virtual_user_url, postData.brr().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lKQ.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lJH, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lKQ.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lKQ.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lKQ.setVisibility(0);
                    pbCommenFloorItemViewHolder.lLi.setVisibility(8);
                }
                if (postData.brr() != null && postData.brr().getAlaInfo() != null && postData.brr().getAlaUserData() != null && postData.brr().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.tq(true);
                    pbCommenFloorItemViewHolder.lKQ.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lKQ.setAlaInfo(postData.brr().getAlaInfo());
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setAlaInfo(postData.brr().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.tq(false);
                    pbCommenFloorItemViewHolder.lKQ.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lKQ.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lLi.getHeadView().setAlaInfo(null);
                }
                a(pbCommenFloorItemViewHolder.lKK, postData);
            }
            int i3 = 0;
            if (this.lLE != null && this.lLE.dpE() != null && this.lLE.dpE().dnO() && postData.brr() != null) {
                i3 = postData.brr().getLevel_id();
            }
            if (this.lJH != null && this.lJH.dni()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.lLh.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(pbCommenFloorItemViewHolder.lLh, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                pbCommenFloorItemViewHolder.lLh.setVisibility(8);
            }
            int i4 = 15;
            if (pbCommenFloorItemViewHolder.lLk.getChildCount() == 1) {
                i4 = 13;
            } else if (pbCommenFloorItemViewHolder.lLk.getChildCount() > 1) {
                i4 = 11;
            }
            if (pbCommenFloorItemViewHolder.lKK.getVisibility() == 0) {
                i4 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lLj.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bsT() > 1000) {
                i4 -= 2;
            }
            if (postData.bsT() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                pbCommenFloorItemViewHolder.lLk.setVisibility(8);
                if (pbCommenFloorItemViewHolder.lLk.getChildCount() == 1) {
                    i4 += 2;
                } else if (pbCommenFloorItemViewHolder.lLk.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lKK.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lKK.setVisibility(8);
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lLh.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lLh.setVisibility(8);
                }
            }
            String name_show2 = postData.brr() != null ? postData.brr().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ad.getTextLengthWithEmoji(name_show2);
            if (postData.brr() != null && !StringUtils.isNull(postData.brr().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ad.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.brr() != null && !StringUtils.isNull(postData.brr().getSealPrefix())) {
                pbCommenFloorItemViewHolder.icj.setText(dZ(postData.brr().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.icj.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPe()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.lKP);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.lLx);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.jQT);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.jQR);
            bz bzVar = null;
            if (this.lJH != null && this.lJH.dmF() != null) {
                bzVar = this.lJH.dmF();
            }
            if (bzVar != null && bzVar.bqa()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, true);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, false);
            }
            boolean z4 = false;
            if (postData.brr() != null && !StringUtils.isNull(postData.brr().getVirtualUserUrl())) {
                z4 = true;
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (this.lJH != null && this.lJH.dmU() != 0) {
                if (this.lJH.dmU() != 1002 && this.lJH.dmU() != 3) {
                    z5 = true;
                }
                if (this.lJH.dmU() != 3 && !this.lJH.dni()) {
                    z6 = true;
                }
                if (postData != null && postData.brr() != null) {
                    String userId = postData.brr().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z5 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z5 = false;
                    }
                }
            }
            if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().brr() != null && postData.brr() != null) {
                String userId2 = this.lJH.dmF().brr().getUserId();
                String userId3 = postData.brr().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z6 = true;
                    z7 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z7 = false;
                        z8 = true;
                    }
                }
            }
            if (postData == null || postData.brr() == null || !UtilHelper.isCurrentAccount(postData.brr().getUserId())) {
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
            if (postData.dPe() == 1) {
                i5 = 0;
            }
            if (z3) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJH.dmU()));
                if (postData.brr() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.brr().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.brr().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.brr().getPortrait());
                }
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            if (z2) {
                sparseArray.put(R.id.tag_user_mute_visible, true);
                sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.brr() != null) {
                    sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brr().getUserId());
                    sparseArray.put(R.id.tag_user_mute_mute_username, postData.brr().getUserName());
                    sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brr().getName_show());
                }
                if (this.lJH.dmF() != null) {
                    sparseArray.put(R.id.tag_user_mute_thread_id, this.lJH.dmF().getId());
                }
                sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z6) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lJH.dmU()));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            pbCommenFloorItemViewHolder.lKR.setTag(sparseArray);
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
            if (this.lJH != null && this.lJH.dni()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.brr() != null) {
                MetaData brr = postData.brr();
                if (this.blY != null && !this.blY.equals("0") && this.blY.equals(brr.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pK(R.string.J_X04).pN(R.dimen.L_X01).pC(R.color.CAM_X0302).pM(R.color.CAM_X0302);
                } else if (brr.getIs_bawu() == 1 && postData.dOW()) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(brr.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(brr.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (brr.getIs_bawu() == 1 && "pri_content_assist".equals(brr.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (brr.getIs_bawu() == 1 && "pri_manage_assist".equals(brr.getBawu_type())) {
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
        if (pbCommenFloorItemViewHolder != null && postData != null && pbCommenFloorItemViewHolder.lLl != null && this.lJH != null) {
            pbCommenFloorItemViewHolder.lLl.setVisibility(8);
        }
    }

    private void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.btl() != null) {
            postData.btl().threadId = this.lLE.dnW().dpX();
            postData.btl().objType = 1;
            postData.btl().isInPost = true;
            bz bzVar = null;
            if (this.lJH != null && this.lJH.dmF() != null) {
                bzVar = this.lJH.dmF();
            }
            if (bzVar != null && bzVar.bqa()) {
                pbCommenFloorItemViewHolder.lKP.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lKP.setThreadData(bzVar);
            pbCommenFloorItemViewHolder.lKP.setData(postData.btl());
            pbCommenFloorItemViewHolder.lLx.setThreadData(bzVar);
            pbCommenFloorItemViewHolder.lLx.setData(postData.btl());
        }
    }

    private void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dPe() > 0 && this.lJH != null && !this.lJH.dni()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dPe()));
                pbCommenFloorItemViewHolder.lLg.setVisibility(0);
                pbCommenFloorItemViewHolder.lLg.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lLg.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dPh = postData.dPh();
            boolean z2 = (dPh == null || StringUtils.isNull(dPh.getName()) || this.lJH == null || this.lJH.dni()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lKM.setVisibility(0);
                i = this.jvU;
            } else {
                pbCommenFloorItemViewHolder.lKM.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lKN.setVisibility(0);
                i2 = this.jvU;
            } else {
                pbCommenFloorItemViewHolder.lKN.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lKL.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lKL.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lKL.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lKO.setVisibility(0);
                pbCommenFloorItemViewHolder.lKO.setPadding(this.jvU, 0, 0, 0);
                if (postData.nsn) {
                    pbCommenFloorItemViewHolder.lKO.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dPh.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    pbCommenFloorItemViewHolder.lKO.setText(dPh.getName());
                }
            } else {
                pbCommenFloorItemViewHolder.lKO.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lLA.setText(((Object) pbCommenFloorItemViewHolder.lKL.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.bmS()) {
                if (z) {
                    pbCommenFloorItemViewHolder.lLA.setVisibility(0);
                    pbCommenFloorItemViewHolder.lKL.setVisibility(8);
                    pbCommenFloorItemViewHolder.lKM.setVisibility(8);
                    return;
                }
                pbCommenFloorItemViewHolder.lLA.setVisibility(8);
                pbCommenFloorItemViewHolder.lKL.setVisibility(0);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKR.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.lKR.setPadding(0, 0, 0, 0);
            if (!this.lJI) {
                pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tB(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.lKR.EV(null);
                pbCommenFloorItemViewHolder.lKR.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().tB(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.lKR.getLayoutStrategy().ty(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lKR, view, !StringUtils.isNull(postData.getBimg_url()));
            pbCommenFloorItemViewHolder.lKR.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lKR.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lKR.setIsFromCDN(this.mIsFromCDN);
            pbCommenFloorItemViewHolder.lKR.setText(postData.dPg(), true, this.lKA);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lKR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbCommenFloorItemViewHolder.lKR.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lKJ.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.lLC.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lLy.setTag(sparseArray);
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
            if (postData.dPi() > 0) {
                pbCommenFloorItemViewHolder.lKW.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lKW.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lKW.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dPq() == 2) {
                    pbCommenFloorItemViewHolder.lKW.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lKW.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.lKV.setVisibility(8);
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
            if (postData.dPi() > 0 && !this.lKC) {
                pbCommenFloorItemViewHolder.lKV.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dPi())));
                SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.lKV.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.lKV.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                pbCommenFloorItemViewHolder.lKV.setVisibility(0);
                pbCommenFloorItemViewHolder.lKW.setVisibility(8);
                pbCommenFloorItemViewHolder.lKU.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.lKV.setVisibility(8);
                if (postData.dPi() > 0 && postData.dPb() != null && postData.dPb().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKU.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.lKU.setLayoutParams(layoutParams);
                    if (this.lKB == null) {
                        this.lKB = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lKB.setIsFromCDN(this.mIsFromCDN);
                        this.lKB.setOnLongClickListener(this.mOnLongClickListener);
                        this.lKB.Y(this.lJR);
                        this.lKB.C(this.bdp);
                        String str = null;
                        if (this.lJH != null && this.lJH.dmF() != null && this.lJH.dmF().brr() != null) {
                            str = this.lJH.dmF().brr().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lJH != null) {
                            this.lKB.ad(this.lJH.dmU(), z);
                            this.lKB.setThreadData(this.lJH.dmF());
                        }
                    }
                    this.lKB.Qn(postData.getId());
                    pbCommenFloorItemViewHolder.lKU.setSubPbAdapter(this.lKB);
                    pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                    pbCommenFloorItemViewHolder.lKU.setData(postData, view);
                    pbCommenFloorItemViewHolder.lKU.setChildOnClickListener(this.bdp);
                    pbCommenFloorItemViewHolder.lKU.setChildOnLongClickListener(this.mOnLongClickListener);
                    pbCommenFloorItemViewHolder.lKU.setChildOnTouchListener(this.lKD);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKU.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    pbCommenFloorItemViewHolder.lKU.setLayoutParams(layoutParams2);
                    pbCommenFloorItemViewHolder.lKU.setVisibility(8);
                }
            }
            if (postData.nsd) {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bmU()) {
                pbCommenFloorItemViewHolder.lKW.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.bmR()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKT.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lKV.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lKT.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lKT.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.bmS()) {
                ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKT.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lKV.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lKT.setVisibility(8);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lLz.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    pbCommenFloorItemViewHolder.lKT.setVisibility(0);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lLz.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.bmT()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lKT.getLayoutParams();
                if (pbCommenFloorItemViewHolder.lKV.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.lLB.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lLq != null && pbCommenFloorItemViewHolder.lLn != null) {
            if (postData == null || postData.nsh == null || StringUtils.isNull(postData.nsh.liveTitle)) {
                pbCommenFloorItemViewHolder.lLn.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.lLq.setText(postData.nsh.liveTitle);
            pbCommenFloorItemViewHolder.lLn.setTag(postData.nsh);
            pbCommenFloorItemViewHolder.lLn.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lLv.setVisibility(postData.nsn ? 0 : 8);
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        if (pbCommenFloorItemViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
                n(pbCommenFloorItemViewHolder.lKK);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.icj, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKL, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKM, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKN, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLg, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKO, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKW, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.lKR.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLA, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLB, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ao.d(pbCommenFloorItemViewHolder.lKU, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKV, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bmU()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lKV, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304);
                }
                pbCommenFloorItemViewHolder.lKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(pbCommenFloorItemViewHolder.jQT, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jQR, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.lKU.onChangeSkinType();
                pbCommenFloorItemViewHolder.lKS.onChangeSkinType();
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLq, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLo, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(pbCommenFloorItemViewHolder.lLn, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(pbCommenFloorItemViewHolder.lLp, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ao.setImageResource(pbCommenFloorItemViewHolder.lLr, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbCommenFloorItemViewHolder.lLu, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.lLs.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lLu.setText(R.string.close_content);
                } else if (this.lJH != null && StringUtils.isNull(this.lJH.dmQ())) {
                    pbCommenFloorItemViewHolder.lLu.setText(this.lJH.dmQ());
                } else {
                    pbCommenFloorItemViewHolder.lLu.setText(R.string.expand_content);
                }
                pbCommenFloorItemViewHolder.lKP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                pbCommenFloorItemViewHolder.EW(skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(pbCommenFloorItemViewHolder.lLy, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.lLC, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            pbCommenFloorItemViewHolder.mSkinType = skinType;
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lKJ.setOnTouchListener(this.lKD);
        pbCommenFloorItemViewHolder.lKJ.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lLE.dpE() != null && this.lLE.dpE().getPageContext() != null && this.lLE.dpE().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lLE.dpE().lIZ;
            pbCommenFloorItemViewHolder.icj.setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lKQ.setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lLi.setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lLi.getHeadView().setOnClickListener(aVar.iOE);
            pbCommenFloorItemViewHolder.lKR.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lKR.setOnTouchListener(this.lKD);
            pbCommenFloorItemViewHolder.lKR.setCommonTextViewOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lKR.setOnImageClickListener(this.fWO);
            pbCommenFloorItemViewHolder.lKR.setOnImageTouchListener(this.lKD);
            pbCommenFloorItemViewHolder.lKR.setOnEmotionClickListener(aVar.lZz);
            pbCommenFloorItemViewHolder.lKR.setOnVoiceAfterClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLm.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLn.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lKV.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lKW.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLy.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLC.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pbCommenFloorItemViewHolder.jQT.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lLE.dpE().lJa;
            pbCommenFloorItemViewHolder.jQT.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.jQR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lKJ != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lZO.a(k.this.lJH, null, postData, pbCommenFloorItemViewHolder.lKR.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = k.this.lJH.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.lJH.getThreadId())) && k.this.lJH.dmF() != null) {
                                threadId = k.this.lJH.dmF().bpP();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", threadId).dX("fid", k.this.lJH.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData.getId()).dX("obj_source", k.this.dD(view)).an("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lKP.fgS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lJH != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lKP != null && pbCommenFloorItemViewHolder.lKP.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lKP.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lJH.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lJH.getThreadId())) && k.this.lJH.dmF() != null) {
                            threadId = k.this.lJH.dmF().bpP();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", threadId).dX("fid", k.this.lJH.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", pbCommenFloorItemViewHolder.lKP.getData().postId).dX("obj_source", k.this.dD(pbCommenFloorItemViewHolder.lKP)).an("obj_type", i));
                    }
                }
            };
            pbCommenFloorItemViewHolder.lLx.fgS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lJH != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lLx != null && pbCommenFloorItemViewHolder.lLx.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lLx.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lJH.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lJH.getThreadId())) && k.this.lJH.dmF() != null) {
                            threadId = k.this.lJH.dmF().bpP();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", threadId).dX("fid", k.this.lJH.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", pbCommenFloorItemViewHolder.lLx.getData().postId).dX("obj_source", k.this.dD(pbCommenFloorItemViewHolder.lLx)).an("obj_type", i));
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
        this.lKA = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lJH = fVar;
    }

    public void hJ(String str) {
        this.blY = str;
    }

    public void uz(boolean z) {
        this.lJI = z;
    }

    private SpannableStringBuilder dZ(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.lLE.dpE(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lKR.setTextViewOnTouchListener(this.fyb);
        pbCommenFloorItemViewHolder.lKR.setTextViewCheckSelection(false);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJR = onClickListener;
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
