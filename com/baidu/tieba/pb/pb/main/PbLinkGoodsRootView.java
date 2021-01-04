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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    private bz alW;
    private boolean eWs;
    private BdRecyclerView kCq;
    private PbFragment lIO;
    private b lPY;
    private TextView lPZ;
    private RelativeLayout lQa;
    private ThreadForumEnterGoodsButton lQb;
    private LinearLayout lQc;
    private int lQd;
    private int lQe;
    private int lQf;
    private int lQg;
    private int lQh;
    private VideoPbFragment lQi;
    private ImageView lxo;
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
        this.eWs = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.kCq = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.kCq.setNestedScrollingEnabled(false);
        this.lQc = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lPZ = (TextView) findViewById(R.id.tv_post);
        this.lQa = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.lxo = (ImageView) findViewById(R.id.iv_arrow);
        this.lQb = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lQd = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lQe = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lQf = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lQg = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lPY = new b();
        this.kCq.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.kCq.setAdapter(this.lPY);
        this.lQa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dpP();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, PbFragment pbFragment, boolean z) {
        this.lIO = pbFragment;
        a(fVar, list, str, z);
        if (this.lIO != null) {
            va(this.lIO.dpx());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lQi = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lQi != null) {
            va(this.lQi.dpx());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, boolean z) {
        this.mData = list;
        this.alW = fVar.dmE();
        this.alW.Bd(fVar.getForumName());
        this.alW.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eWs = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lQc.setVisibility(8);
        } else {
            this.lQc.setVisibility(0);
        }
        if (this.eWs) {
            this.eWs = z;
            this.lQb.setFrom(1);
            this.lQb.r(this.alW);
            this.lQb.setVisibility(0);
            return;
        }
        this.lQb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpP() {
        if (this.lIO != null) {
            if (this.lIO.dpx()) {
                this.lIO.uU(false);
                va(false);
                return;
            }
            this.lIO.uU(true);
            va(true);
            dpQ();
        } else if (this.lQi != null) {
            if (this.lQi.dpx()) {
                this.lQi.uU(false);
                va(false);
                return;
            }
            this.lQi.uU(true);
            va(true);
            dpQ();
        }
    }

    private void dpQ() {
        if (this.alW != null && this.eWs) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13968").w("fid", this.alW.getFid()).dX("fname", this.alW.bru()).dX("tid", this.alW.getTid()));
        }
    }

    private void va(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lPZ.setText(this.eWs ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lQh = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lPZ.setText(this.eWs ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lQh = R.drawable.icon_pure_unfold12_svg;
        }
        this.lPY.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPZ, R.color.CAM_X0107);
        SvgManager.bwq().a(this.lxo, this.lQh, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lQc.setPadding(0, this.lQf, 0, this.lQg);
        } else {
            this.lQc.setPadding(0, this.lQd, 0, this.lQe);
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
                    if (PbLinkGoodsRootView.this.lIO == null || PbLinkGoodsRootView.this.lIO.dpx() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lQi == null || PbLinkGoodsRootView.this.lQi.dpx() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.fyt.setVisibility(8);
                        } else {
                            aVar.fyt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dpP();
                                }
                            });
                            aVar.fyt.setVisibility(0);
                            com.baidu.tbadk.core.util.f.a.bwU().qq(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bz(aVar.fyt);
                        }
                    } else {
                        aVar.fyt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dpP();
                            }
                        });
                        aVar.fyt.setVisibility(0);
                        com.baidu.tbadk.core.util.f.a.bwU().qq(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bz(aVar.fyt);
                    }
                    aVar.lQk.a((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lQk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                        }
                    });
                    if (!(PbLinkGoodsRootView.this.mData.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.mData.get(i) == null) {
                        if (PbLinkGoodsRootView.this.mData.get(i) instanceof PbGoodsData) {
                            PbLinkGoodsRootView.this.bH("c13961", 2);
                        }
                    } else if (((PbLinkData) PbLinkGoodsRootView.this.mData.get(i)).urlType == 2) {
                        PbLinkGoodsRootView.this.bH("c13961", 1);
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
                    be.bwu().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    be.bwu().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    bH("c13962", 1);
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
                            be.bwu().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    be.bwu().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bH("c13962", 2);
            }
        }
    }

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ViewHolder {
        private View fyt;
        private SingleLinkCardView lQk;

        public a(View view) {
            super(view);
            this.fyt = view.findViewById(R.id.mask_view);
            this.lQk = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(String str, int i) {
        if (this.alW != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(str).an("obj_type", i).w("fid", this.alW.getFid()).dX("fname", this.alW.bru()).dX("tid", this.alW.getTid()));
        }
    }
}
