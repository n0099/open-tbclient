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
    private int aLy;
    private View.OnClickListener bdi;
    private String bmb;
    private TbRichTextView.i fVW;
    private boolean fZf;
    private com.baidu.tieba.pb.a.c fxj;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> joC;
    private com.baidu.adp.lib.d.b<TbImageView> joD;
    private int jyR;
    protected com.baidu.tieba.pb.data.f lQk;
    private boolean lQl;
    private View.OnClickListener lQu;
    private TbRichTextView.c lRd;
    private com.baidu.tieba.pb.pb.sub.b lRe;
    private boolean lRf;
    private boolean lRg;
    private com.baidu.tieba.pb.a.c lRh;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(View view) {
        if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
            if (com.baidu.tbadk.a.d.bjl() || com.baidu.tbadk.a.d.bjm()) {
                if (pbCommenFloorItemViewHolder.lSb != null && pbCommenFloorItemViewHolder.lSb.getData() != null) {
                    pbCommenFloorItemViewHolder.lSb.btO();
                }
            } else if (pbCommenFloorItemViewHolder.lRt != null && pbCommenFloorItemViewHolder.lRt.getData() != null) {
                pbCommenFloorItemViewHolder.lRt.btO();
            }
        }
    }

    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jyR = 0;
        this.lRd = null;
        this.lQl = true;
        this.bmb = null;
        this.lQk = null;
        this.lQu = null;
        this.bdi = null;
        this.fVW = null;
        this.fxj = null;
        this.mOnLongClickListener = null;
        this.lRe = null;
        this.fZf = true;
        this.lRf = com.baidu.tbadk.a.d.bjb();
        this.lRg = false;
        this.joC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFs */
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
        this.joD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buO */
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
        this.lRh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.k.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (k.this.lPo == null || k.this.lPo.dnB() == null || k.this.lPo.dnB().dqC())) {
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
                if (k.this.fxj != null) {
                    if (!(view instanceof TbListTextView) || k.this.bdi == null) {
                        k.this.fxj.ad(view);
                        k.this.fxj.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    k.this.bdi.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.dmG() != null) {
            this.aLy = bVar.dmG().dpu();
        }
        this.jyR = getDimensionPixelSize(R.dimen.tbds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cs */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate;
        View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate2.findViewById(R.id.pb_post_reply_container);
        if (com.baidu.tbadk.a.d.bjn()) {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_c, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null);
        }
        viewGroup2.addView(inflate);
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.lSl.doq().getPageContext(), inflate2, this.aLy, this.lRf);
        pbCommenFloorItemViewHolder.lRw.setConstrainLayoutPool(this.joC);
        pbCommenFloorItemViewHolder.lRw.setImageViewPool(this.joD);
        if (pbCommenFloorItemViewHolder.lRy != null) {
            pbCommenFloorItemViewHolder.lRy.setShowChildComment(this.lRf);
        }
        a(pbCommenFloorItemViewHolder);
        if (pbCommenFloorItemViewHolder.lRv != null) {
            pbCommenFloorItemViewHolder.lRv.setDuiEnabled(this.fZf);
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
            postData2.bpf();
            i(postData2);
            a(pbCommenFloorItemViewHolder, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fZf = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.nzX) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ar b = com.baidu.tieba.pb.c.a.b(this.lQk, postData, postData.locate, i, 6);
            postData.nzY = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dNL())) {
                Iterator<PostData> it = postData.dNL().iterator();
                while (it.hasNext()) {
                    it.next().nzY = b;
                }
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lRB.setVisibility(8);
            if (com.baidu.tbadk.a.d.bjl()) {
                pbCommenFloorItemViewHolder.lSa.setVisibility(0);
                pbCommenFloorItemViewHolder.lRx.setVisibility(0);
                pbCommenFloorItemViewHolder.lSd.setVisibility(8);
                pbCommenFloorItemViewHolder.jVW.setVisibility(8);
                pbCommenFloorItemViewHolder.jVU.setVisibility(8);
                pbCommenFloorItemViewHolder.lRt.setVisibility(8);
                pbCommenFloorItemViewHolder.lSg.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bjm()) {
                pbCommenFloorItemViewHolder.lSa.setVisibility(0);
                pbCommenFloorItemViewHolder.lRx.setVisibility(0);
                pbCommenFloorItemViewHolder.lSd.setVisibility(0);
                pbCommenFloorItemViewHolder.jVW.setVisibility(8);
                pbCommenFloorItemViewHolder.jVU.setVisibility(8);
                pbCommenFloorItemViewHolder.lRt.setVisibility(8);
                pbCommenFloorItemViewHolder.lSg.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bjn()) {
                pbCommenFloorItemViewHolder.lSd.setVisibility(8);
                pbCommenFloorItemViewHolder.lSa.setVisibility(8);
                pbCommenFloorItemViewHolder.lRx.setVisibility(0);
                pbCommenFloorItemViewHolder.jVW.setVisibility(0);
                pbCommenFloorItemViewHolder.jVU.setVisibility(0);
                pbCommenFloorItemViewHolder.lRt.setVisibility(0);
                pbCommenFloorItemViewHolder.lSg.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.lSa.setVisibility(8);
                pbCommenFloorItemViewHolder.lSd.setVisibility(8);
                pbCommenFloorItemViewHolder.lRx.setVisibility(0);
                pbCommenFloorItemViewHolder.jVW.setVisibility(0);
                pbCommenFloorItemViewHolder.jVU.setVisibility(0);
                pbCommenFloorItemViewHolder.lRt.setVisibility(0);
                pbCommenFloorItemViewHolder.lSg.setVisibility(8);
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
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lRn != null) {
            if (this.lSl != null && this.lSl.dmG() != null && this.lSl.dmG().dpC() && com.baidu.tbadk.core.util.au.equals(this.lSl.dmG().doI(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.lRn, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.lRn, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        if (z) {
            pbCommenFloorItemViewHolder.lRW.setVisibility(8);
            if (StringUtils.isNull(str)) {
                pbCommenFloorItemViewHolder.lRY.setText(R.string.expand_content);
                return;
            } else {
                pbCommenFloorItemViewHolder.lRY.setText(str);
                return;
            }
        }
        pbCommenFloorItemViewHolder.lRW.setVisibility(0);
        pbCommenFloorItemViewHolder.lRY.setText(R.string.close_content);
    }

    private void c(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final PostData postData) {
        if (postData.dOa() == 2 || postData.dOa() == 4) {
            pbCommenFloorItemViewHolder.lRX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = pbCommenFloorItemViewHolder.lRW.getVisibility() == 8;
                    k.this.a(pbCommenFloorItemViewHolder, !z, postData.dlA());
                    postData.ys(z ? false : true);
                    k.this.d(pbCommenFloorItemViewHolder, postData);
                    if (k.this.lPo != null && k.this.lPo.dnB() != null && k.this.lPo.dnB().drH() != null && k.this.lPo.dnB().getListView() != null && !z && pbCommenFloorItemViewHolder.getView().getTop() < k.this.lPo.dnB().drH().getMeasuredHeight()) {
                        k.this.lPo.dnB().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(k.this.lPo.dnB().getListView().getData(), postData) + k.this.lPo.dnB().getListView().getHeaderViewsCount(), k.this.lPo.dnB().drH().getMeasuredHeight());
                    }
                }
            });
            pbCommenFloorItemViewHolder.lRX.setVisibility(0);
            a(pbCommenFloorItemViewHolder, postData.dNJ(), postData.dlA());
            a(true, pbCommenFloorItemViewHolder, postData);
        } else {
            pbCommenFloorItemViewHolder.lRX.setVisibility(8);
            pbCommenFloorItemViewHolder.lRW.setVisibility(0);
            a(false, pbCommenFloorItemViewHolder, postData);
        }
        d(pbCommenFloorItemViewHolder, postData);
    }

    private void a(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.mBottomLine != null && pbCommenFloorItemViewHolder.lRX != null && (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.lRX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dNL());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.lRX.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().si(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().sh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().sh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.lRX.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().sh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().si(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        TbRichText dNQ = postData.dNQ();
        dNQ.isChanged = true;
        pbCommenFloorItemViewHolder.lRv.setText(dNQ, true, this.lRd);
    }

    private void j(PostData postData) {
        if (postData.eTx == 0 && postData.jrd) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12203");
            arVar.dR("post_id", postData.getId());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("cuid", TbadkCoreApplication.getInst().getCuid());
            arVar.dR("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            arVar.dR("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            arVar.dR("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            arVar.v(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lSl != null) {
                int dpu = this.lSl.dmG().dpu();
                if (1 == dpu || 2 == dpu) {
                    arVar.dR("obj_source", "1");
                } else if (3 == dpu) {
                    arVar.dR("obj_source", "2");
                } else {
                    arVar.dR("obj_source", "0");
                }
            }
            TiebaStatic.log(arVar);
            if (postData.bnS() != null && postData.bnS().getAlaInfo() != null && postData.bnS().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.bnS().getUserId();
        String forumId = this.lQk != null ? this.lQk.getForumId() : "";
        String forumName = this.lQk != null ? this.lQk.getForumName() : "";
        int dNO = postData.dNO();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13714");
        arVar.dR("fid", forumId);
        arVar.dR("fname", forumName);
        arVar.dR("obj_param1", userId);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("tid", id);
        arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, dNO);
        TiebaStatic.log(arVar);
    }

    private void l(PostData postData) {
        if (this.lQk != null) {
            if (this.lQk.dlP()) {
                if (this.lSm != null) {
                    com.baidu.tieba.pb.c.a.a(this.lSm.getUniqueId(), this.lQk, postData, postData.locate, postData.nzX ? 2 : 8);
                }
            } else if (this.lPo != null) {
                com.baidu.tieba.pb.c.a.a(this.lPo.getUniqueId(), this.lQk, postData, postData.locate, postData.nzX ? 2 : 8);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (postData == null || postData.dtB() == null) {
            pbCommenFloorItemViewHolder.lRQ.setVisibility(8);
            return;
        }
        TbRichText dNQ = postData.dNQ();
        com.baidu.tieba.pb.view.b.a(postData.dtB(), pbCommenFloorItemViewHolder.lRQ, false, false, dNQ != null && StringUtils.isNull(dNQ.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lQl) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRv.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbCommenFloorItemViewHolder.lRv.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lRv.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.lRv.Em(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRv.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            pbCommenFloorItemViewHolder.lRv.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.lRv.Em(postData.getBimg_url());
        }
        pbCommenFloorItemViewHolder.lRv.setTextViewOnTouchListener(this.lRh);
        pbCommenFloorItemViewHolder.lRv.setTextViewCheckSelection(false);
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.bnS() == null || postData.bnS().isBaijiahaoUser()) {
            }
            if (postData.nzO) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lRu.setTag(null);
            pbCommenFloorItemViewHolder.lRu.setUserId(null);
            pbCommenFloorItemViewHolder.idX.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.lRM.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.lRv.setIsHost(false);
            if (postData.bnS() != null) {
                if (this.bmb != null && !this.bmb.equals("0") && this.bmb.equals(postData.bnS().getUserId())) {
                    pbCommenFloorItemViewHolder.lRv.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bnS().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bnS().getTShowInfoNew();
                if (pbCommenFloorItemViewHolder.lRO != null) {
                    pbCommenFloorItemViewHolder.lRO.setTag(R.id.tag_user_id, postData.bnS().getUserId());
                    if (this.lSl != null && this.lSl.doq() != null) {
                        pbCommenFloorItemViewHolder.lRO.setOnClickListener(this.lSl.doq().lPA.mgp);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.lRO.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pbCommenFloorItemViewHolder.lRN != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.lRN.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lSl != null && this.lSl.doq() != null) {
                        pbCommenFloorItemViewHolder.lRN.setOnClickListener(this.lSl.doq().lPA.mgq);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.lRN.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.bnS().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0107, 1);
                }
                String avater = postData.bnS().getAvater();
                int i2 = 8;
                if (postData.nzX) {
                    i2 = 2;
                }
                pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_user_id, postData.bnS().getUserId());
                pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_user_name, postData.bnS().getUserName());
                pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_virtual_user_url, postData.bnS().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lQk, postData, postData.locate, i2, 2));
                String name_show = postData.bnS().getName_show();
                String userName = postData.bnS().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.idX.setText(com.baidu.tieba.pb.c.aY(this.mContext, pbCommenFloorItemViewHolder.idX.getText().toString()));
                    pbCommenFloorItemViewHolder.idX.setGravity(16);
                    pbCommenFloorItemViewHolder.idX.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkZ());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0312, 1);
                }
                if (postData.bnS().getPendantData() != null && !StringUtils.isNull(postData.bnS().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.lRM.setBigVDimenSize(R.dimen.tbds32);
                    pbCommenFloorItemViewHolder.lRM.a(postData.bnS(), 4);
                    pbCommenFloorItemViewHolder.lRu.setVisibility(8);
                    pbCommenFloorItemViewHolder.lRM.setVisibility(0);
                    pbCommenFloorItemViewHolder.lRM.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setUserId(postData.bnS().getUserId());
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setUserName(postData.bnS().getUserName());
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setFid(this.lQk != null ? this.lQk.getForumId() : "");
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setFName(this.lQk != null ? this.lQk.getForumName() : "");
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setFloor(postData.dNO());
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lQk, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lRM.BG(postData.bnS().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.lRu.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.lRu, postData.bnS(), 4);
                    pbCommenFloorItemViewHolder.lRu.setUserId(postData.bnS().getUserId());
                    pbCommenFloorItemViewHolder.lRu.setFid(this.lQk != null ? this.lQk.getForumId() : "");
                    pbCommenFloorItemViewHolder.lRu.setFName(this.lQk != null ? this.lQk.getForumName() : "");
                    pbCommenFloorItemViewHolder.lRu.setFloor(postData.dNO());
                    pbCommenFloorItemViewHolder.lRu.setTid(postData.getId());
                    pbCommenFloorItemViewHolder.lRu.setUserName(postData.bnS().getUserName(), postData.dNY());
                    pbCommenFloorItemViewHolder.lRu.setTag(R.id.tag_virtual_user_url, postData.bnS().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.lRu.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lQk, postData, postData.locate, i2, 2));
                    pbCommenFloorItemViewHolder.lRu.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.lRu.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.lRu.setVisibility(0);
                    pbCommenFloorItemViewHolder.lRM.setVisibility(8);
                }
                if (postData.bnS() != null && postData.bnS().getAlaInfo() != null && postData.bnS().getAlaUserData() != null && postData.bnS().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.tz(true);
                    pbCommenFloorItemViewHolder.lRu.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lRu.setAlaInfo(postData.bnS().getAlaInfo());
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setAlaInfo(postData.bnS().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.tz(false);
                    pbCommenFloorItemViewHolder.lRu.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lRu.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.lRM.getHeadView().setAlaInfo(null);
                }
                a(pbCommenFloorItemViewHolder.lRo, postData);
            }
            int i3 = 0;
            if (this.lSl != null && this.lSl.doq() != null && this.lSl.doq().dmy() && postData.bnS() != null) {
                i3 = postData.bnS().getLevel_id();
            }
            if (this.lQk != null && this.lQk.dlS()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.lRL.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(pbCommenFloorItemViewHolder.lRL, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                pbCommenFloorItemViewHolder.lRL.setVisibility(8);
            }
            int i4 = 15;
            if (pbCommenFloorItemViewHolder.lRO.getChildCount() == 1) {
                i4 = 13;
            } else if (pbCommenFloorItemViewHolder.lRO.getChildCount() > 1) {
                i4 = 11;
            }
            if (pbCommenFloorItemViewHolder.lRo.getVisibility() == 0) {
                i4 -= 2;
            }
            if (pbCommenFloorItemViewHolder.lRN.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bpt() > 1000) {
                i4 -= 2;
            }
            if (postData.bpt() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                pbCommenFloorItemViewHolder.lRO.setVisibility(8);
                if (pbCommenFloorItemViewHolder.lRO.getChildCount() == 1) {
                    i4 += 2;
                } else if (pbCommenFloorItemViewHolder.lRO.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lRo.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lRo.setVisibility(8);
                }
                if (i4 < 10 && pbCommenFloorItemViewHolder.lRL.getVisibility() == 0) {
                    i4 += 2;
                    pbCommenFloorItemViewHolder.lRL.setVisibility(8);
                }
            }
            String name_show2 = postData.bnS() != null ? postData.bnS().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ag.getTextLengthWithEmoji(name_show2);
            if (postData.bnS() != null && !StringUtils.isNull(postData.bnS().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ag.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ag.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.bnS() != null && !StringUtils.isNull(postData.bnS().getSealPrefix())) {
                pbCommenFloorItemViewHolder.idX.setText(dT(postData.bnS().getSealPrefix(), name_show2));
            } else {
                pbCommenFloorItemViewHolder.idX.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dNO()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.lRt);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.lSb);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.jVW);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.jVU);
            cb cbVar = null;
            if (this.lQk != null && this.lQk.dlp() != null) {
                cbVar = this.lQk.dlp();
            }
            if (cbVar != null && cbVar.bmB()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, true);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, false);
            }
            boolean z4 = false;
            if (postData.bnS() != null && !StringUtils.isNull(postData.bnS().getVirtualUserUrl())) {
                z4 = true;
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            if (this.lQk != null && this.lQk.dlE() != 0) {
                if (this.lQk.dlE() != 1002 && this.lQk.dlE() != 3) {
                    z5 = true;
                }
                if (this.lQk.dlE() != 3 && !this.lQk.dlS()) {
                    z6 = true;
                }
                if (postData != null && postData.bnS() != null) {
                    String userId = postData.bnS().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z5 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z5 = false;
                    }
                }
            }
            if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().bnS() != null && postData.bnS() != null) {
                String userId2 = this.lQk.dlp().bnS().getUserId();
                String userId3 = postData.bnS().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z6 = true;
                    z7 = true;
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z7 = false;
                        z8 = true;
                    }
                }
            }
            if (postData == null || postData.bnS() == null || !UtilHelper.isCurrentAccount(postData.bnS().getUserId())) {
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
            if (postData.dNO() == 1) {
                i5 = 0;
            }
            if (z3) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lQk.dlE()));
                if (postData.bnS() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.bnS().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnS().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnS().getPortrait());
                }
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            if (z2) {
                sparseArray.put(R.id.tag_user_mute_visible, true);
                sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (postData.bnS() != null) {
                    sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnS().getUserId());
                    sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnS().getUserName());
                    sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnS().getName_show());
                }
                if (this.lQk.dlp() != null) {
                    sparseArray.put(R.id.tag_user_mute_thread_id, this.lQk.dlp().getId());
                }
                sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z6) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lQk.dlE()));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            pbCommenFloorItemViewHolder.lRv.setTag(sparseArray);
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
            if (this.lQk != null && this.lQk.dlS()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnS() != null) {
                MetaData bnS = postData.bnS();
                if (this.bmb != null && !this.bmb.equals("0") && this.bmb.equals(bnS.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).oh(R.string.J_X04).ol(R.dimen.L_X01).nZ(R.color.CAM_X0302).ok(R.color.CAM_X0302);
                } else if (bnS.getIs_bawu() == 1 && postData.dNG()) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnS.getIs_bawu() == 1 && "pri_content_assist".equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnS.getIs_bawu() == 1 && "pri_manage_assist".equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
        if (pbCommenFloorItemViewHolder != null && postData != null && pbCommenFloorItemViewHolder.lRP != null && this.lQk != null) {
            pbCommenFloorItemViewHolder.lRP.setVisibility(8);
        }
    }

    private void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null && postData.bpL() != null) {
            postData.bpL().threadId = this.lSl.dmG().doJ();
            postData.bpL().objType = 1;
            postData.bpL().isInPost = true;
            cb cbVar = null;
            if (this.lQk != null && this.lQk.dlp() != null) {
                cbVar = this.lQk.dlp();
            }
            if (cbVar != null && cbVar.bmB()) {
                pbCommenFloorItemViewHolder.lRt.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.lRt.setThreadData(cbVar);
            pbCommenFloorItemViewHolder.lRt.setData(postData.bpL());
            pbCommenFloorItemViewHolder.lSb.setThreadData(cbVar);
            pbCommenFloorItemViewHolder.lSb.setData(postData.bpL());
        }
    }

    private void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dNO() > 0 && this.lQk != null && !this.lQk.dlS()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dNO()));
                pbCommenFloorItemViewHolder.lRK.setVisibility(0);
                pbCommenFloorItemViewHolder.lRK.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.lRK.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dNR = postData.dNR();
            boolean z2 = (dNR == null || StringUtils.isNull(dNR.getName()) || this.lQk == null || this.lQk.dlS()) ? false : true;
            if (z) {
                pbCommenFloorItemViewHolder.lRq.setVisibility(0);
                i = this.jyR;
            } else {
                pbCommenFloorItemViewHolder.lRq.setVisibility(8);
                i = 0;
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lRr.setVisibility(0);
                i2 = this.jyR;
            } else {
                pbCommenFloorItemViewHolder.lRr.setVisibility(8);
                i2 = 0;
            }
            pbCommenFloorItemViewHolder.lRp.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                pbCommenFloorItemViewHolder.lRp.setText(com.baidu.tbadk.core.util.au.getFormatTimeShort(postData.getTime()));
            } else {
                pbCommenFloorItemViewHolder.lRp.setText(com.baidu.tbadk.core.util.au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.lRs.setVisibility(0);
                pbCommenFloorItemViewHolder.lRs.setPadding(this.jyR, 0, 0, 0);
                if (postData.nzW) {
                    pbCommenFloorItemViewHolder.lRs.setText(com.baidu.tbadk.core.util.au.cutStringWithSuffix(dNR.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    pbCommenFloorItemViewHolder.lRs.setText(dNR.getName());
                }
            } else {
                pbCommenFloorItemViewHolder.lRs.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.lSe.setText(((Object) pbCommenFloorItemViewHolder.lRp.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.bjm()) {
                if (z) {
                    pbCommenFloorItemViewHolder.lSe.setVisibility(0);
                    pbCommenFloorItemViewHolder.lRp.setVisibility(8);
                    pbCommenFloorItemViewHolder.lRq.setVisibility(8);
                    return;
                }
                pbCommenFloorItemViewHolder.lSe.setVisibility(8);
                pbCommenFloorItemViewHolder.lRp.setVisibility(0);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRv.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.lRv.setPadding(0, 0, 0, 0);
            if (!this.lQl) {
                pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().sc(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.lRv.Em(null);
                pbCommenFloorItemViewHolder.lRv.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().sc(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.lRv.getLayoutStrategy().rZ(R.drawable.pic_video);
            a(pbCommenFloorItemViewHolder.lRv, view, !StringUtils.isNull(postData.getBimg_url()));
            pbCommenFloorItemViewHolder.lRv.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.lRv.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.lRv.setIsFromCDN(this.mIsFromCDN);
            pbCommenFloorItemViewHolder.lRv.setText(postData.dNQ(), true, this.lRd);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lRv.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            pbCommenFloorItemViewHolder.lRv.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lRn.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.lSg.setTag(sparseArray);
            pbCommenFloorItemViewHolder.lSc.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().sa(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fXZ = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().sb((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.dNS() > 0) {
                pbCommenFloorItemViewHolder.lRA.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lRA.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lRA.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dOa() == 2) {
                    pbCommenFloorItemViewHolder.lRA.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lRA.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.lRz.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.jVW != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.jVW.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.jVW.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.jVU != null) {
                SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jVU.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.jVU.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            if (postData.dNS() > 0 && !this.lRf) {
                pbCommenFloorItemViewHolder.lRz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dNS())));
                SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.lRz.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.lRz.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                pbCommenFloorItemViewHolder.lRz.setVisibility(0);
                pbCommenFloorItemViewHolder.lRA.setVisibility(8);
                pbCommenFloorItemViewHolder.lRy.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.lRz.setVisibility(8);
                if (postData.dNS() > 0 && postData.dNL() != null && postData.dNL().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRy.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.lRy.setLayoutParams(layoutParams);
                    if (this.lRe == null) {
                        this.lRe = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lRe.setIsFromCDN(this.mIsFromCDN);
                        this.lRe.setOnLongClickListener(this.mOnLongClickListener);
                        this.lRe.Z(this.lQu);
                        this.lRe.C(this.bdi);
                        String str = null;
                        if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlp().bnS() != null) {
                            str = this.lQk.dlp().bnS().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lQk != null) {
                            this.lRe.ad(this.lQk.dlE(), z);
                            this.lRe.setThreadData(this.lQk.dlp());
                        }
                    }
                    this.lRe.Qe(postData.getId());
                    pbCommenFloorItemViewHolder.lRy.setSubPbAdapter(this.lRe);
                    pbCommenFloorItemViewHolder.lRy.setVisibility(0);
                    pbCommenFloorItemViewHolder.lRy.setData(postData, view);
                    pbCommenFloorItemViewHolder.lRy.setChildOnClickListener(this.bdi);
                    pbCommenFloorItemViewHolder.lRy.setChildOnLongClickListener(this.mOnLongClickListener);
                    pbCommenFloorItemViewHolder.lRy.setChildOnTouchListener(this.lRh);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRy.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    pbCommenFloorItemViewHolder.lRy.setLayoutParams(layoutParams2);
                    pbCommenFloorItemViewHolder.lRy.setVisibility(8);
                }
            }
            if (postData.nzM) {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bjo()) {
                pbCommenFloorItemViewHolder.lRA.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.bjl()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRx.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lRz.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lRx.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lRx.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.bjm()) {
                ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRx.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (pbCommenFloorItemViewHolder.lRz.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lRx.setVisibility(8);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lSd.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    pbCommenFloorItemViewHolder.lRx.setVisibility(0);
                    ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lSd.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.bjn()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.lRx.getLayoutParams();
                if (pbCommenFloorItemViewHolder.lRz.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.lSf.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lRU != null && pbCommenFloorItemViewHolder.lRR != null) {
            if (postData == null || postData.nzQ == null || StringUtils.isNull(postData.nzQ.liveTitle)) {
                pbCommenFloorItemViewHolder.lRR.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.lRU.setText(postData.nzQ.liveTitle);
            pbCommenFloorItemViewHolder.lRR.setTag(postData.nzQ);
            pbCommenFloorItemViewHolder.lRR.setVisibility(0);
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(arVar);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lRZ.setVisibility(postData.nzW ? 0 : 8);
        }
    }

    private void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.c(postData.nzP, postData.getId(), this.lRg);
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        if (pbCommenFloorItemViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
                n(pbCommenFloorItemViewHolder.lRo);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.idX, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRp, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRq, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRr, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRK, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRs, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRA, R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.lRv.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lSe, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lSf, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ap.d(pbCommenFloorItemViewHolder.lRy, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRz, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bjo()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRz, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304);
                }
                pbCommenFloorItemViewHolder.lRz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(pbCommenFloorItemViewHolder.jVW, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.jVU, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.lRy.onChangeSkinType();
                pbCommenFloorItemViewHolder.lRw.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRU, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRS, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(pbCommenFloorItemViewHolder.lRR, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(pbCommenFloorItemViewHolder.lRT, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setImageResource(pbCommenFloorItemViewHolder.lRV, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbCommenFloorItemViewHolder.lRY, R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.lRW.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.lRY.setText(R.string.close_content);
                } else if (this.lQk != null && StringUtils.isNull(this.lQk.dlA())) {
                    pbCommenFloorItemViewHolder.lRY.setText(this.lQk.dlA());
                } else {
                    pbCommenFloorItemViewHolder.lRY.setText(R.string.expand_content);
                }
                pbCommenFloorItemViewHolder.lRt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                pbCommenFloorItemViewHolder.DL(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(pbCommenFloorItemViewHolder.lSc, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(pbCommenFloorItemViewHolder.lSg, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.dnn();
            }
            pbCommenFloorItemViewHolder.mSkinType = skinType;
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lRn.setOnTouchListener(this.lRh);
        pbCommenFloorItemViewHolder.lRn.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lSl.doq() != null && this.lSl.doq().getPageContext() != null && this.lSl.doq().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lSl.doq().lPA;
            pbCommenFloorItemViewHolder.idX.setOnClickListener(aVar.iRC);
            pbCommenFloorItemViewHolder.lRu.setOnClickListener(aVar.iRC);
            pbCommenFloorItemViewHolder.lRM.setOnClickListener(aVar.iRC);
            pbCommenFloorItemViewHolder.lRM.getHeadView().setOnClickListener(aVar.iRC);
            pbCommenFloorItemViewHolder.lRv.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lRv.setOnTouchListener(this.lRh);
            pbCommenFloorItemViewHolder.lRv.setCommonTextViewOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lRv.setOnImageClickListener(this.fVW);
            pbCommenFloorItemViewHolder.lRv.setOnImageTouchListener(this.lRh);
            pbCommenFloorItemViewHolder.lRv.setOnEmotionClickListener(aVar.mgr);
            pbCommenFloorItemViewHolder.lRv.setOnVoiceAfterClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lRQ.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lRR.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lRz.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lRA.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lSc.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lSg.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lSd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    pbCommenFloorItemViewHolder.jVW.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lSl.doq().lPB;
            pbCommenFloorItemViewHolder.jVW.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.jVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lRn != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.k.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.mgG.a(k.this.lQk, null, postData, pbCommenFloorItemViewHolder.lRv.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = k.this.lQk.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(k.this.lQk.getThreadId())) && k.this.lQk.dlp() != null) {
                                threadId = k.this.lQk.dlp().bmq();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lQk.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).dR("obj_source", k.this.dB(view)).aq("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lRt.ffY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lQk != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lRt != null && pbCommenFloorItemViewHolder.lRt.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lRt.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lQk.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lQk.getThreadId())) && k.this.lQk.dlp() != null) {
                            threadId = k.this.lQk.dlp().bmq();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lQk.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lRt.getData().postId).dR("obj_source", k.this.dB(pbCommenFloorItemViewHolder.lRt)).aq("obj_type", i));
                    }
                }
            };
            pbCommenFloorItemViewHolder.lSb.ffY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.k.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && k.this.lQk != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lSb != null && pbCommenFloorItemViewHolder.lSb.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lSb.getImgAgree() ? 1 : 2;
                        String threadId = k.this.lQk.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(k.this.lQk.getThreadId())) && k.this.lQk.dlp() != null) {
                            threadId = k.this.lQk.dlp().bmq();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", threadId).dR("fid", k.this.lQk.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lSb.getData().postId).dR("obj_source", k.this.dB(pbCommenFloorItemViewHolder.lSb)).aq("obj_type", i));
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
        this.lRd = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lQk = fVar;
    }

    public void hc(String str) {
        this.bmb = str;
    }

    public void uJ(boolean z) {
        this.lQl = z;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.lSl.doq(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lRv.setTextViewOnTouchListener(this.fxj);
        pbCommenFloorItemViewHolder.lRv.setTextViewCheckSelection(false);
    }

    public void V(View.OnClickListener onClickListener) {
        this.lQu = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fxj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void uT(boolean z) {
        this.lRg = z;
    }
}
