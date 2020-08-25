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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    private bw ajx;
    private boolean eev;
    private BdRecyclerView jnn;
    private b kGo;
    private TextView kGp;
    private RelativeLayout kGq;
    private ThreadForumEnterGoodsButton kGr;
    private LinearLayout kGs;
    private int kGt;
    private int kGu;
    private int kGv;
    private int kGw;
    private int kGx;
    private ImageView kob;
    private PbFragment kzt;
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
        this.eev = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.jnn = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.jnn.setNestedScrollingEnabled(false);
        this.kGs = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.kGp = (TextView) findViewById(R.id.tv_post);
        this.kGq = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.kob = (ImageView) findViewById(R.id.iv_arrow);
        this.kGr = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.kGt = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.kGu = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.kGv = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.kGw = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.kGo = new b();
        this.jnn.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.jnn.setAdapter(this.kGo);
        this.kGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.cYu();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, PbFragment pbFragment, boolean z) {
        this.mData = list;
        this.ajx = fVar.cVl();
        this.ajx.zn(fVar.getForumName());
        this.ajx.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.kzt = pbFragment;
        this.eev = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.kGs.setVisibility(8);
        } else {
            this.kGs.setVisibility(0);
        }
        if (this.eev) {
            this.eev = z;
            this.kGr.setFrom(1);
            this.kGr.q(this.ajx);
            this.kGr.setVisibility(0);
        } else {
            this.kGr.setVisibility(8);
        }
        if (this.kzt != null) {
            te(this.kzt.cYc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYu() {
        if (this.kzt != null) {
            if (this.kzt.cYc()) {
                this.kzt.sY(false);
                te(false);
                return;
            }
            this.kzt.sY(true);
            te(true);
            cYv();
        }
    }

    private void cYv() {
        if (this.ajx != null && this.eev) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13968").u("fid", this.ajx.getFid()).dD("fname", this.ajx.beI()).dD("tid", this.ajx.getTid()));
        }
    }

    private void te(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.kGp.setText(this.eev ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.kGx = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.kGp.setText(this.eev ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.kGx = R.drawable.icon_pure_unfold12_svg;
        }
        this.kGo.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGp, R.color.cp_link_tip_a);
        SvgManager.bjq().a(this.kob, this.kGx, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.kGs.setPadding(0, this.kGv, 0, this.kGw);
        } else {
            this.kGs.setPadding(0, this.kGt, 0, this.kGu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
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
                    if (PbLinkGoodsRootView.this.kzt == null || PbLinkGoodsRootView.this.kzt.cYc() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        aVar.eFx.setVisibility(8);
                    } else {
                        aVar.eFx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.cYu();
                            }
                        });
                        aVar.eFx.setVisibility(0);
                        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).aZ(aVar.eFx);
                    }
                    aVar.kGz.a((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.kGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                        }
                    });
                    if (!(PbLinkGoodsRootView.this.mData.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.mData.get(i) == null) {
                        if (PbLinkGoodsRootView.this.mData.get(i) instanceof PbGoodsData) {
                            PbLinkGoodsRootView.this.bw("c13961", 2);
                        }
                    } else if (((PbLinkData) PbLinkGoodsRootView.this.mData.get(i)).urlType == 2) {
                        PbLinkGoodsRootView.this.bw("c13961", 1);
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
                    com.baidu.tbadk.core.util.be.bju().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    com.baidu.tbadk.core.util.be.bju().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    bw("c13962", 1);
                }
            }
        } else if (dVar instanceof PbGoodsData) {
            TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.mContext;
            PbGoodsData pbGoodsData = (PbGoodsData) dVar;
            if (pbGoodsData != null) {
                if (!TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pbGoodsData.linkUrl));
                    intent.addFlags(268468224);
                    if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                        this.mContext.startActivity(intent);
                    } else if (!TextUtils.isEmpty(((PbGoodsData) dVar).goodsUrlH5)) {
                        com.baidu.tbadk.core.util.be.bju().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                    }
                } else {
                    com.baidu.tbadk.core.util.be.bju().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bw("c13962", 2);
            }
        }
    }

    /* loaded from: classes16.dex */
    class a extends RecyclerView.ViewHolder {
        private View eFx;
        private SingleLinkCardView kGz;

        public a(View view) {
            super(view);
            this.eFx = view.findViewById(R.id.mask_view);
            this.kGz = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(String str, int i) {
        if (this.ajx != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(str).ai("obj_type", i).u("fid", this.ajx.getFid()).dD("fname", this.ajx.beI()).dD("tid", this.ajx.getTid()));
        }
    }
}
