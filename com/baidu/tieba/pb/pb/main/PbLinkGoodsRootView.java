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
    private boolean eHd;
    private BdRecyclerView kdo;
    private ImageView leo;
    private PbFragment lpI;
    private b lwG;
    private TextView lwH;
    private RelativeLayout lwI;
    private ThreadForumEnterGoodsButton lwJ;
    private LinearLayout lwK;
    private int lwL;
    private int lwM;
    private int lwN;
    private int lwO;
    private int lwP;
    private VideoPbFragment lwQ;
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
        this.eHd = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.kdo = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.kdo.setNestedScrollingEnabled(false);
        this.lwK = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lwH = (TextView) findViewById(R.id.tv_post);
        this.lwI = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.leo = (ImageView) findViewById(R.id.iv_arrow);
        this.lwJ = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lwL = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lwM = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lwN = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lwO = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lwG = new b();
        this.kdo.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.kdo.setAdapter(this.lwG);
        this.lwI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dlq();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, PbFragment pbFragment, boolean z) {
        this.lpI = pbFragment;
        a(fVar, list, str, z);
        if (this.lpI != null) {
            uu(this.lpI.dkY());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lwQ = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lwQ != null) {
            uu(this.lwQ.dkY());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.d> list, String str, boolean z) {
        this.mData = list;
        this.akq = fVar.dik();
        this.akq.Bc(fVar.getForumName());
        this.akq.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eHd = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lwK.setVisibility(8);
        } else {
            this.lwK.setVisibility(0);
        }
        if (this.eHd) {
            this.eHd = z;
            this.lwJ.setFrom(1);
            this.lwJ.r(this.akq);
            this.lwJ.setVisibility(0);
            return;
        }
        this.lwJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlq() {
        if (this.lpI != null) {
            if (this.lpI.dkY()) {
                this.lpI.uo(false);
                uu(false);
                return;
            }
            this.lpI.uo(true);
            uu(true);
            dlr();
        } else if (this.lwQ != null) {
            if (this.lwQ.dkY()) {
                this.lwQ.uo(false);
                uu(false);
                return;
            }
            this.lwQ.uo(true);
            uu(true);
            dlr();
        }
    }

    private void dlr() {
        if (this.akq != null && this.eHd) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13968").w("fid", this.akq.getFid()).dR("fname", this.akq.bmE()).dR("tid", this.akq.getTid()));
        }
    }

    private void uu(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lwH.setText(this.eHd ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lwP = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lwH.setText(this.eHd ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lwP = R.drawable.icon_pure_unfold12_svg;
        }
        this.lwG.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwH, R.color.cp_link_tip_a);
        SvgManager.brn().a(this.leo, this.lwP, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lwK.setPadding(0, this.lwN, 0, this.lwO);
        } else {
            this.lwK.setPadding(0, this.lwL, 0, this.lwM);
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
                    if (PbLinkGoodsRootView.this.lpI == null || PbLinkGoodsRootView.this.lpI.dkY() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lwQ == null || PbLinkGoodsRootView.this.lwQ.dkY() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.fic.setVisibility(8);
                        } else {
                            aVar.fic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dlq();
                                }
                            });
                            aVar.fic.setVisibility(0);
                            com.baidu.tbadk.core.util.e.a.brO().pj(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bk(aVar.fic);
                        }
                    } else {
                        aVar.fic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dlq();
                            }
                        });
                        aVar.fic.setVisibility(0);
                        com.baidu.tbadk.core.util.e.a.brO().pj(0).i(R.color.cp_bg_line_d_alpha70, R.color.cp_bg_line_d).bk(aVar.fic);
                    }
                    aVar.lwS.a((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lwS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.d) PbLinkGoodsRootView.this.mData.get(i));
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
    public void b(com.baidu.tieba.card.data.d dVar) {
        if (dVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) dVar;
            if (pbLinkData != null) {
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.mContext;
                if (pbLinkData.urlType == 1) {
                    com.baidu.tbadk.core.util.be.brr().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    com.baidu.tbadk.core.util.be.brr().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    bA("c13962", 1);
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
                            com.baidu.tbadk.core.util.be.brr().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    com.baidu.tbadk.core.util.be.brr().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bA("c13962", 2);
            }
        }
    }

    /* loaded from: classes22.dex */
    class a extends RecyclerView.ViewHolder {
        private View fic;
        private SingleLinkCardView lwS;

        public a(View view) {
            super(view);
            this.fic = view.findViewById(R.id.mask_view);
            this.lwS = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(String str, int i) {
        if (this.akq != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(str).al("obj_type", i).w("fid", this.akq.getFid()).dR("fname", this.akq.bmE()).dR("tid", this.akq.getTid()));
        }
    }
}
