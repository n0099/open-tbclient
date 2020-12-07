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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    private by alu;
    private boolean eMx;
    private BdRecyclerView krz;
    private PbFragment lDG;
    private b lKJ;
    private TextView lKK;
    private RelativeLayout lKL;
    private ThreadForumEnterGoodsButton lKM;
    private LinearLayout lKN;
    private int lKO;
    private int lKP;
    private int lKQ;
    private int lKR;
    private int lKS;
    private VideoPbFragment lKT;
    private ImageView lse;
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
        this.eMx = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.krz = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.krz.setNestedScrollingEnabled(false);
        this.lKN = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lKK = (TextView) findViewById(R.id.tv_post);
        this.lKL = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.lse = (ImageView) findViewById(R.id.iv_arrow);
        this.lKM = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lKO = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lKP = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lKQ = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lKR = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lKJ = new b();
        this.krz.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.krz.setAdapter(this.lKJ);
        this.lKL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dqc();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, PbFragment pbFragment, boolean z) {
        this.lDG = pbFragment;
        a(fVar, list, str, z);
        if (this.lDG != null) {
            uZ(this.lDG.dpK());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lKT = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lKT != null) {
            uZ(this.lKT.dpK());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, boolean z) {
        this.mData = list;
        this.alu = fVar.dmT();
        this.alu.Be(fVar.getForumName());
        this.alu.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eMx = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lKN.setVisibility(8);
        } else {
            this.lKN.setVisibility(0);
        }
        if (this.eMx) {
            this.eMx = z;
            this.lKM.setFrom(1);
            this.lKM.r(this.alu);
            this.lKM.setVisibility(0);
            return;
        }
        this.lKM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqc() {
        if (this.lDG != null) {
            if (this.lDG.dpK()) {
                this.lDG.uT(false);
                uZ(false);
                return;
            }
            this.lDG.uT(true);
            uZ(true);
            dqd();
        } else if (this.lKT != null) {
            if (this.lKT.dpK()) {
                this.lKT.uT(false);
                uZ(false);
                return;
            }
            this.lKT.uT(true);
            uZ(true);
            dqd();
        }
    }

    private void dqd() {
        if (this.alu != null && this.eMx) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13968").w("fid", this.alu.getFid()).dY("fname", this.alu.boT()).dY("tid", this.alu.getTid()));
        }
    }

    private void uZ(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lKK.setText(this.eMx ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lKS = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lKK.setText(this.eMx ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lKS = R.drawable.icon_pure_unfold12_svg;
        }
        this.lKJ.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lKK, R.color.CAM_X0107);
        SvgManager.btW().a(this.lse, this.lKS, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lKN.setPadding(0, this.lKQ, 0, this.lKR);
        } else {
            this.lKN.setPadding(0, this.lKO, 0, this.lKP);
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
                    if (PbLinkGoodsRootView.this.lDG == null || PbLinkGoodsRootView.this.lDG.dpK() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lKT == null || PbLinkGoodsRootView.this.lKT.dpK() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.foK.setVisibility(8);
                        } else {
                            aVar.foK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dqc();
                                }
                            });
                            aVar.foK.setVisibility(0);
                            com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bq(aVar.foK);
                        }
                    } else {
                        aVar.foK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dqc();
                            }
                        });
                        aVar.foK.setVisibility(0);
                        com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bq(aVar.foK);
                    }
                    aVar.lKV.a((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                        }
                    });
                    if (!(PbLinkGoodsRootView.this.mData.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.mData.get(i) == null) {
                        if (PbLinkGoodsRootView.this.mData.get(i) instanceof PbGoodsData) {
                            PbLinkGoodsRootView.this.bA("c13961", 2);
                        }
                    } else if (((PbLinkData) PbLinkGoodsRootView.this.mData.get(i)).urlType == 2) {
                        PbLinkGoodsRootView.this.bA("c13961", 1);
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
    public void b(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) cVar;
            if (pbLinkData != null) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.mContext;
                if (pbLinkData.urlType == 1) {
                    bf.bua().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    bf.bua().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    bA("c13962", 1);
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
                            bf.bua().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    bf.bua().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bA("c13962", 2);
            }
        }
    }

    /* loaded from: classes22.dex */
    class a extends RecyclerView.ViewHolder {
        private View foK;
        private SingleLinkCardView lKV;

        public a(View view) {
            super(view);
            this.foK = view.findViewById(R.id.mask_view);
            this.lKV = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(String str, int i) {
        if (this.alu != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str).al("obj_type", i).w("fid", this.alu.getFid()).dY("fname", this.alu.boT()).dY("tid", this.alu.getTid()));
        }
    }
}
