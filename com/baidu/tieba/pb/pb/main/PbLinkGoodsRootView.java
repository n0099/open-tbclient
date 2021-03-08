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
    private cb amn;
    private boolean eVw;
    private BdRecyclerView kIh;
    private ImageView lDd;
    private PbFragment lPo;
    private b lWG;
    private TextView lWH;
    private RelativeLayout lWI;
    private ThreadForumEnterGoodsButton lWJ;
    private LinearLayout lWK;
    private int lWL;
    private int lWM;
    private int lWN;
    private int lWO;
    private int lWP;
    private VideoPbFragment lWQ;
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
        this.eVw = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.kIh = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.kIh.setNestedScrollingEnabled(false);
        this.lWK = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lWH = (TextView) findViewById(R.id.tv_post);
        this.lWI = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.lDd = (ImageView) findViewById(R.id.iv_arrow);
        this.lWJ = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lWL = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lWM = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lWN = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lWO = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lWG = new b();
        this.kIh.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.kIh.setAdapter(this.lWG);
        this.lWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.doC();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, PbFragment pbFragment, boolean z) {
        this.lPo = pbFragment;
        a(fVar, list, str, z);
        if (this.lPo != null) {
            vl(this.lPo.dok());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lWQ = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lWQ != null) {
            vl(this.lWQ.dok());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, boolean z) {
        this.mData = list;
        this.amn = fVar.dlp();
        this.amn.Ap(fVar.getForumName());
        this.amn.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eVw = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lWK.setVisibility(8);
        } else {
            this.lWK.setVisibility(0);
        }
        if (this.eVw) {
            this.eVw = z;
            this.lWJ.setFrom(1);
            this.lWJ.r(this.amn);
            this.lWJ.setVisibility(0);
            return;
        }
        this.lWJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doC() {
        if (this.lPo != null) {
            if (this.lPo.dok()) {
                this.lPo.vf(false);
                vl(false);
                return;
            }
            this.lPo.vf(true);
            vl(true);
            doD();
        } else if (this.lWQ != null) {
            if (this.lWQ.dok()) {
                this.lWQ.vf(false);
                vl(false);
                return;
            }
            this.lWQ.vf(true);
            vl(true);
            doD();
        }
    }

    private void doD() {
        if (this.amn != null && this.eVw) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13968").v("fid", this.amn.getFid()).dR("fname", this.amn.bnW()).dR("tid", this.amn.getTid()));
        }
    }

    private void vl(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lWH.setText(this.eVw ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lWP = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lWH.setText(this.eVw ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lWP = R.drawable.icon_pure_unfold12_svg;
        }
        this.lWG.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWH, R.color.CAM_X0107);
        SvgManager.bsU().a(this.lDd, this.lWP, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lWK.setPadding(0, this.lWN, 0, this.lWO);
        } else {
            this.lWK.setPadding(0, this.lWL, 0, this.lWM);
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
                    if (PbLinkGoodsRootView.this.lPo == null || PbLinkGoodsRootView.this.lPo.dok() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lWQ == null || PbLinkGoodsRootView.this.lWQ.dok() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.fxA.setVisibility(8);
                        } else {
                            aVar.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.doC();
                                }
                            });
                            aVar.fxA.setVisibility(0);
                            com.baidu.tbadk.core.util.f.a.bty().oP(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bv(aVar.fxA);
                        }
                    } else {
                        aVar.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.doC();
                            }
                        });
                        aVar.fxA.setVisibility(0);
                        com.baidu.tbadk.core.util.f.a.bty().oP(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bv(aVar.fxA);
                    }
                    aVar.lWS.a((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lWS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
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
                    bf.bsY().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    bf.bsY().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
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
                            bf.bsY().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    bf.bsY().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bI("c13962", 2);
            }
        }
    }

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ViewHolder {
        private View fxA;
        private SingleLinkCardView lWS;

        public a(View view) {
            super(view);
            this.fxA = view.findViewById(R.id.mask_view);
            this.lWS = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, int i) {
        if (this.amn != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str).aq("obj_type", i).v("fid", this.amn.getFid()).dR("fname", this.amn.bnW()).dR("tid", this.amn.getTid()));
        }
    }
}
