package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    private cb akU;
    private boolean eTV;
    private BdRecyclerView kFR;
    private ImageView lAN;
    private PbFragment lMX;
    private b lUp;
    private TextView lUq;
    private RelativeLayout lUr;
    private ThreadForumEnterGoodsButton lUs;
    private LinearLayout lUt;
    private int lUu;
    private int lUv;
    private int lUw;
    private int lUx;
    private int lUy;
    private VideoPbFragment lUz;
    private Context mContext;
    private List<com.baidu.tieba.card.data.c> mData;
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
        this.eTV = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.kFR = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.kFR.setNestedScrollingEnabled(false);
        this.lUt = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lUq = (TextView) findViewById(R.id.tv_post);
        this.lUr = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.lAN = (ImageView) findViewById(R.id.iv_arrow);
        this.lUs = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lUu = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lUv = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lUw = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lUx = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lUp = new b();
        this.kFR.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.kFR.setAdapter(this.lUp);
        this.lUr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dom();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, PbFragment pbFragment, boolean z) {
        this.lMX = pbFragment;
        a(fVar, list, str, z);
        if (this.lMX != null) {
            vl(this.lMX.dnU());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lUz = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lUz != null) {
            vl(this.lUz.dnU());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, boolean z) {
        this.mData = list;
        this.akU = fVar.dkZ();
        this.akU.Ai(fVar.getForumName());
        this.akU.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eTV = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lUt.setVisibility(8);
        } else {
            this.lUt.setVisibility(0);
        }
        if (this.eTV) {
            this.eTV = z;
            this.lUs.setFrom(1);
            this.lUs.r(this.akU);
            this.lUs.setVisibility(0);
            return;
        }
        this.lUs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dom() {
        if (this.lMX != null) {
            if (this.lMX.dnU()) {
                this.lMX.vf(false);
                vl(false);
                return;
            }
            this.lMX.vf(true);
            vl(true);
            don();
        } else if (this.lUz != null) {
            if (this.lUz.dnU()) {
                this.lUz.vf(false);
                vl(false);
                return;
            }
            this.lUz.vf(true);
            vl(true);
            don();
        }
    }

    private void don() {
        if (this.akU != null && this.eTV) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13968").v("fid", this.akU.getFid()).dR("fname", this.akU.bnU()).dR("tid", this.akU.getTid()));
        }
    }

    private void vl(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lUq.setText(this.eTV ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lUy = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lUq.setText(this.eTV ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lUy = R.drawable.icon_pure_unfold12_svg;
        }
        this.lUp.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUq, R.color.CAM_X0107);
        SvgManager.bsR().a(this.lAN, this.lUy, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lUt.setPadding(0, this.lUw, 0, this.lUx);
        } else {
            this.lUt.setPadding(0, this.lUu, 0, this.lUv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.Adapter {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(PbLinkGoodsRootView.this.mContext).inflate(R.layout.pb_link_goods_item_layout, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                if (i < PbLinkGoodsRootView.this.mData.size() && PbLinkGoodsRootView.this.mData.get(i) != null) {
                    if (PbLinkGoodsRootView.this.lMX == null || PbLinkGoodsRootView.this.lMX.dnU() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lUz == null || PbLinkGoodsRootView.this.lUz.dnU() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.fwb.setVisibility(8);
                        } else {
                            aVar.fwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dom();
                                }
                            });
                            aVar.fwb.setVisibility(0);
                            com.baidu.tbadk.core.util.f.a.btv().oO(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bv(aVar.fwb);
                        }
                    } else {
                        aVar.fwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dom();
                            }
                        });
                        aVar.fwb.setVisibility(0);
                        com.baidu.tbadk.core.util.f.a.btv().oO(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bv(aVar.fwb);
                    }
                    aVar.lUB.a((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lUB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                        }
                    });
                    if (!(PbLinkGoodsRootView.this.mData.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.mData.get(i) == null) {
                        if (PbLinkGoodsRootView.this.mData.get(i) instanceof PbGoodsData) {
                            PbLinkGoodsRootView.this.bI("c13961", 2);
                        }
                    } else if (((PbLinkData) PbLinkGoodsRootView.this.mData.get(i)).urlType == 2) {
                        PbLinkGoodsRootView.this.bI("c13961", 1);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PbLinkGoodsRootView.this.maxCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) cVar;
            if (pbLinkData != null) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.mContext;
                if (pbLinkData.urlType == 1) {
                    bf.bsV().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    bf.bsV().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    bI("c13962", 1);
                }
            }
        } else if (cVar instanceof PbGoodsData) {
            TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.mContext;
            PbGoodsData pbGoodsData = (PbGoodsData) cVar;
            if (pbGoodsData != null) {
                if (!TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    if (pbGoodsData.linkUrl.startsWith("tiebaclient://")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, pbGoodsData.linkUrl));
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pbGoodsData.linkUrl));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.mContext.startActivity(intent);
                        } else if (!TextUtils.isEmpty(((PbGoodsData) cVar).goodsUrlH5)) {
                            bf.bsV().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    bf.bsV().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bI("c13962", 2);
            }
        }
    }

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ViewHolder {
        private View fwb;
        private SingleLinkCardView lUB;

        public a(View view) {
            super(view);
            this.fwb = view.findViewById(R.id.mask_view);
            this.lUB = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, int i) {
        if (this.akU != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str).ap("obj_type", i).v("fid", this.akU.getFid()).dR("fname", this.akU.bnU()).dR("tid", this.akU.getTid()));
        }
    }
}
