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
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    private bw ajX;
    private boolean egI;
    private BdRecyclerView jvW;
    private PbFragment kHX;
    private b kOU;
    private TextView kOV;
    private RelativeLayout kOW;
    private ThreadForumEnterGoodsButton kOX;
    private LinearLayout kOY;
    private int kOZ;
    private int kPa;
    private int kPb;
    private int kPc;
    private int kPd;
    private VideoPbFragment kPe;
    private ImageView kwH;
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
        this.egI = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.jvW = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.jvW.setNestedScrollingEnabled(false);
        this.kOY = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.kOV = (TextView) findViewById(R.id.tv_post);
        this.kOW = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.kwH = (ImageView) findViewById(R.id.iv_arrow);
        this.kOX = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.kOZ = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.kPa = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.kPb = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.kPc = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.kOU = new b();
        this.jvW.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.jvW.setAdapter(this.kOU);
        this.kOW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dbY();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, PbFragment pbFragment, boolean z) {
        this.kHX = pbFragment;
        a(fVar, list, str, z);
        if (this.kHX != null) {
            tn(this.kHX.dbG());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.kPe = videoPbFragment;
        a(fVar, list, str, z);
        if (this.kPe != null) {
            tn(this.kPe.dbG());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, boolean z) {
        this.mData = list;
        this.ajX = fVar.cYR();
        this.ajX.zJ(fVar.getForumName());
        this.ajX.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.egI = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.kOY.setVisibility(8);
        } else {
            this.kOY.setVisibility(0);
        }
        if (this.egI) {
            this.egI = z;
            this.kOX.setFrom(1);
            this.kOX.r(this.ajX);
            this.kOX.setVisibility(0);
            return;
        }
        this.kOX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbY() {
        if (this.kHX != null) {
            if (this.kHX.dbG()) {
                this.kHX.th(false);
                tn(false);
                return;
            }
            this.kHX.th(true);
            tn(true);
            dbZ();
        } else if (this.kPe != null) {
            if (this.kPe.dbG()) {
                this.kPe.th(false);
                tn(false);
                return;
            }
            this.kPe.th(true);
            tn(true);
            dbZ();
        }
    }

    private void dbZ() {
        if (this.ajX != null && this.egI) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13968").u("fid", this.ajX.getFid()).dF("fname", this.ajX.bfC()).dF("tid", this.ajX.getTid()));
        }
    }

    private void tn(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.kOV.setText(this.egI ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.kPd = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.kOV.setText(this.egI ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.kPd = R.drawable.icon_pure_unfold12_svg;
        }
        this.kOU.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.kOV, R.color.cp_link_tip_a);
        SvgManager.bkl().a(this.kwH, this.kPd, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.kOY.setPadding(0, this.kPb, 0, this.kPc);
        } else {
            this.kOY.setPadding(0, this.kOZ, 0, this.kPa);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
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
                    if (PbLinkGoodsRootView.this.kHX == null || PbLinkGoodsRootView.this.kHX.dbG() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.kPe == null || PbLinkGoodsRootView.this.kPe.dbG() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.eHI.setVisibility(8);
                        } else {
                            aVar.eHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dbY();
                                }
                            });
                            aVar.eHI.setVisibility(0);
                            com.baidu.tbadk.core.util.e.a.bkL().oq(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bb(aVar.eHI);
                        }
                    } else {
                        aVar.eHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dbY();
                            }
                        });
                        aVar.eHI.setVisibility(0);
                        com.baidu.tbadk.core.util.e.a.bkL().oq(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bb(aVar.eHI);
                    }
                    aVar.kPg.a((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.kPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
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
                    com.baidu.tbadk.core.util.be.bkp().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    com.baidu.tbadk.core.util.be.bkp().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
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
                        com.baidu.tbadk.core.util.be.bkp().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                    }
                } else {
                    com.baidu.tbadk.core.util.be.bkp().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bw("c13962", 2);
            }
        }
    }

    /* loaded from: classes21.dex */
    class a extends RecyclerView.ViewHolder {
        private View eHI;
        private SingleLinkCardView kPg;

        public a(View view) {
            super(view);
            this.eHI = view.findViewById(R.id.mask_view);
            this.kPg = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(String str, int i) {
        if (this.ajX != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(str).ai("obj_type", i).u("fid", this.ajX.getFid()).dF("fname", this.ajX.bfC()).dF("tid", this.ajX.getTid()));
        }
    }
}
