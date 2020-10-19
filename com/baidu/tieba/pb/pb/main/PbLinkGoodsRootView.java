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
    private bw akp;
    private boolean esO;
    private BdRecyclerView jKT;
    private ImageView kLT;
    private PbFragment kXi;
    private b leg;
    private TextView leh;
    private RelativeLayout lei;
    private ThreadForumEnterGoodsButton lej;
    private LinearLayout lek;
    private int lel;
    private int lem;
    private int leo;
    private int lep;
    private int leq;
    private VideoPbFragment ler;
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
        this.esO = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.jKT = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.jKT.setNestedScrollingEnabled(false);
        this.lek = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.leh = (TextView) findViewById(R.id.tv_post);
        this.lei = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.kLT = (ImageView) findViewById(R.id.iv_arrow);
        this.lej = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lel = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lem = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.leo = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lep = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.leg = new b();
        this.jKT.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.jKT.setAdapter(this.leg);
        this.lei.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dfH();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, PbFragment pbFragment, boolean z) {
        this.kXi = pbFragment;
        a(fVar, list, str, z);
        if (this.kXi != null) {
            tU(this.kXi.dfp());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.ler = videoPbFragment;
        a(fVar, list, str, z);
        if (this.ler != null) {
            tU(this.ler.dfp());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, boolean z) {
        this.mData = list;
        this.akp = fVar.dcA();
        this.akp.Av(fVar.getForumName());
        this.akp.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.esO = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lek.setVisibility(8);
        } else {
            this.lek.setVisibility(0);
        }
        if (this.esO) {
            this.esO = z;
            this.lej.setFrom(1);
            this.lej.r(this.akp);
            this.lej.setVisibility(0);
            return;
        }
        this.lej.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfH() {
        if (this.kXi != null) {
            if (this.kXi.dfp()) {
                this.kXi.tO(false);
                tU(false);
                return;
            }
            this.kXi.tO(true);
            tU(true);
            dfI();
        } else if (this.ler != null) {
            if (this.ler.dfp()) {
                this.ler.tO(false);
                tU(false);
                return;
            }
            this.ler.tO(true);
            tU(true);
            dfI();
        }
    }

    private void dfI() {
        if (this.akp != null && this.esO) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13968").u("fid", this.akp.getFid()).dK("fname", this.akp.bil()).dK("tid", this.akp.getTid()));
        }
    }

    private void tU(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.leh.setText(this.esO ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.leq = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.leh.setText(this.esO ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.leq = R.drawable.icon_pure_unfold12_svg;
        }
        this.leg.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.leh, R.color.cp_link_tip_a);
        SvgManager.bmU().a(this.kLT, this.leq, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lek.setPadding(0, this.leo, 0, this.lep);
        } else {
            this.lek.setPadding(0, this.lel, 0, this.lem);
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
                    if (PbLinkGoodsRootView.this.kXi == null || PbLinkGoodsRootView.this.kXi.dfp() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.ler == null || PbLinkGoodsRootView.this.ler.dfp() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.eTP.setVisibility(8);
                        } else {
                            aVar.eTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dfH();
                                }
                            });
                            aVar.eTP.setVisibility(0);
                            com.baidu.tbadk.core.util.e.a.bnv().oO(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bf(aVar.eTP);
                        }
                    } else {
                        aVar.eTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dfH();
                            }
                        });
                        aVar.eTP.setVisibility(0);
                        com.baidu.tbadk.core.util.e.a.bnv().oO(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bf(aVar.eTP);
                    }
                    aVar.let.a((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.let.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                        }
                    });
                    if (!(PbLinkGoodsRootView.this.mData.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.mData.get(i) == null) {
                        if (PbLinkGoodsRootView.this.mData.get(i) instanceof PbGoodsData) {
                            PbLinkGoodsRootView.this.bx("c13961", 2);
                        }
                    } else if (((PbLinkData) PbLinkGoodsRootView.this.mData.get(i)).urlType == 2) {
                        PbLinkGoodsRootView.this.bx("c13961", 1);
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
                    com.baidu.tbadk.core.util.be.bmY().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    com.baidu.tbadk.core.util.be.bmY().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    bx("c13962", 1);
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
                            com.baidu.tbadk.core.util.be.bmY().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    com.baidu.tbadk.core.util.be.bmY().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bx("c13962", 2);
            }
        }
    }

    /* loaded from: classes22.dex */
    class a extends RecyclerView.ViewHolder {
        private View eTP;
        private SingleLinkCardView let;

        public a(View view) {
            super(view);
            this.eTP = view.findViewById(R.id.mask_view);
            this.let = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, int i) {
        if (this.akp != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(str).aj("obj_type", i).u("fid", this.akp.getFid()).dK("fname", this.akp.bil()).dK("tid", this.akp.getTid()));
        }
    }
}
