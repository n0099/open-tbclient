package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    private bw akq;
    private boolean eBo;
    private BdRecyclerView jXr;
    private ImageView kYq;
    private PbFragment ljH;
    private b lqJ;
    private TextView lqK;
    private RelativeLayout lqL;
    private ThreadForumEnterGoodsButton lqM;
    private LinearLayout lqN;
    private int lqO;
    private int lqP;
    private int lqQ;
    private int lqR;
    private int lqS;
    private VideoPbFragment lqT;
    private Context mContext;
    private List<com.baidu.tieba.card.data.d> mData;
    private int maxCount;

    public PbLinkGoodsRootView(Context context) {
        this(context, null);
    }

    public PbLinkGoodsRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbLinkGoodsRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mData = new ArrayList();
        this.maxCount = 3;
        this.eBo = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.jXr = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.jXr.setNestedScrollingEnabled(false);
        this.lqN = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lqK = (TextView) findViewById(R.id.tv_post);
        this.lqL = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.kYq = (ImageView) findViewById(R.id.iv_arrow);
        this.lqM = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lqO = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lqP = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lqQ = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lqR = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lqJ = new b();
        this.jXr.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.jXr.setAdapter(this.lqJ);
        this.lqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.diO();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, PbFragment pbFragment, boolean z) {
        this.ljH = pbFragment;
        a(fVar, list, str, z);
        if (this.ljH != null) {
            ul(this.ljH.diw());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lqT = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lqT != null) {
            ul(this.lqT.diw());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, boolean z) {
        this.mData = list;
        this.akq = fVar.dfI();
        this.akq.AO(fVar.getForumName());
        this.akq.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eBo = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lqN.setVisibility(8);
        } else {
            this.lqN.setVisibility(0);
        }
        if (this.eBo) {
            this.eBo = z;
            this.lqM.setFrom(1);
            this.lqM.r(this.akq);
            this.lqM.setVisibility(0);
            return;
        }
        this.lqM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diO() {
        if (this.ljH != null) {
            if (this.ljH.diw()) {
                this.ljH.uf(false);
                ul(false);
                return;
            }
            this.ljH.uf(true);
            ul(true);
            diP();
        } else if (this.lqT != null) {
            if (this.lqT.diw()) {
                this.lqT.uf(false);
                ul(false);
                return;
            }
            this.lqT.uf(true);
            ul(true);
            diP();
        }
    }

    private void diP() {
        if (this.akq != null && this.eBo) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13968").w("fid", this.akq.getFid()).dR("fname", this.akq.bke()).dR("tid", this.akq.getTid()));
        }
    }

    private void ul(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lqK.setText(this.eBo ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lqS = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lqK.setText(this.eBo ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lqS = R.drawable.icon_pure_unfold12_svg;
        }
        this.lqJ.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lqK, R.color.cp_link_tip_a);
        SvgManager.boN().a(this.kYq, this.lqS, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lqN.setPadding(0, this.lqQ, 0, this.lqR);
        } else {
            this.lqN.setPadding(0, this.lqO, 0, this.lqP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.Adapter {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(PbLinkGoodsRootView.this.mContext).inflate(R.layout.pb_link_goods_item_layout, (ViewGroup) null));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                if (i < PbLinkGoodsRootView.this.mData.size() && PbLinkGoodsRootView.this.mData.get(i) != null) {
                    if (PbLinkGoodsRootView.this.ljH == null || PbLinkGoodsRootView.this.ljH.diw() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lqT == null || PbLinkGoodsRootView.this.lqT.diw() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.fcl.setVisibility(8);
                        } else {
                            aVar.fcl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.diO();
                                }
                            });
                            aVar.fcl.setVisibility(0);
                            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bg(aVar.fcl);
                        }
                    } else {
                        aVar.fcl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.diO();
                            }
                        });
                        aVar.fcl.setVisibility(0);
                        com.baidu.tbadk.core.util.e.a.bpo().oZ(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bg(aVar.fcl);
                    }
                    aVar.lqV.a((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lqV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                        }
                    });
                    if (!(PbLinkGoodsRootView.this.mData.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.mData.get(i) == null) {
                        if (PbLinkGoodsRootView.this.mData.get(i) instanceof PbGoodsData) {
                            PbLinkGoodsRootView.this.by("c13961", 2);
                        }
                    } else if (((PbLinkData) PbLinkGoodsRootView.this.mData.get(i)).urlType == 2) {
                        PbLinkGoodsRootView.this.by("c13961", 1);
                    }
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PbLinkGoodsRootView.this.maxCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.d dVar) {
        if (dVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) dVar;
            if (pbLinkData != null) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.mContext;
                if (pbLinkData.urlType == 1) {
                    com.baidu.tbadk.core.util.be.boR().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    com.baidu.tbadk.core.util.be.boR().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    by("c13962", 1);
                }
            }
        } else if (dVar instanceof PbGoodsData) {
            TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.mContext;
            PbGoodsData pbGoodsData = (PbGoodsData) dVar;
            if (pbGoodsData != null) {
                if (!TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    if (pbGoodsData.linkUrl.startsWith("tiebaclient://")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, pbGoodsData.linkUrl));
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pbGoodsData.linkUrl));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.mContext.startActivity(intent);
                        } else if (!TextUtils.isEmpty(((PbGoodsData) dVar).goodsUrlH5)) {
                            com.baidu.tbadk.core.util.be.boR().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    com.baidu.tbadk.core.util.be.boR().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                by("c13962", 2);
            }
        }
    }

    /* loaded from: classes22.dex */
    class a extends RecyclerView.ViewHolder {
        private View fcl;
        private SingleLinkCardView lqV;

        public a(View view) {
            super(view);
            this.fcl = view.findViewById(R.id.mask_view);
            this.lqV = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(String str, int i) {
        if (this.akq != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(str).aj("obj_type", i).w("fid", this.akq.getFid()).dR("fname", this.akq.bke()).dR("tid", this.akq.getTid()));
        }
    }
}
