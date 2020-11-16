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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    private bx akt;
    private boolean eFv;
    private BdRecyclerView kdY;
    private ImageView leF;
    private PbFragment lpX;
    private b lwW;
    private TextView lwX;
    private RelativeLayout lwY;
    private ThreadForumEnterGoodsButton lwZ;
    private LinearLayout lxa;
    private int lxb;
    private int lxc;
    private int lxd;
    private int lxe;
    private int lxf;
    private VideoPbFragment lxg;
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
        this.eFv = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.kdY = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.kdY.setNestedScrollingEnabled(false);
        this.lxa = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lwX = (TextView) findViewById(R.id.tv_post);
        this.lwY = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.leF = (ImageView) findViewById(R.id.iv_arrow);
        this.lwZ = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lxb = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lxc = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lxd = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lxe = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lwW = new b();
        this.kdY.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.kdY.setAdapter(this.lwW);
        this.lwY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dkN();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, PbFragment pbFragment, boolean z) {
        this.lpX = pbFragment;
        a(fVar, list, str, z);
        if (this.lpX != null) {
            ux(this.lpX.dkv());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lxg = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lxg != null) {
            ux(this.lxg.dkv());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, boolean z) {
        this.mData = list;
        this.akt = fVar.dhH();
        this.akt.Ax(fVar.getForumName());
        this.akt.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eFv = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lxa.setVisibility(8);
        } else {
            this.lxa.setVisibility(0);
        }
        if (this.eFv) {
            this.eFv = z;
            this.lwZ.setFrom(1);
            this.lwZ.r(this.akt);
            this.lwZ.setVisibility(0);
            return;
        }
        this.lwZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkN() {
        if (this.lpX != null) {
            if (this.lpX.dkv()) {
                this.lpX.ur(false);
                ux(false);
                return;
            }
            this.lpX.ur(true);
            ux(true);
            dkO();
        } else if (this.lxg != null) {
            if (this.lxg.dkv()) {
                this.lxg.ur(false);
                ux(false);
                return;
            }
            this.lxg.ur(true);
            ux(true);
            dkO();
        }
    }

    private void dkO() {
        if (this.akt != null && this.eFv) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13968").w("fid", this.akt.getFid()).dR("fname", this.akt.blG()).dR("tid", this.akt.getTid()));
        }
    }

    private void ux(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lwX.setText(this.eFv ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lxf = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lwX.setText(this.eFv ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lxf = R.drawable.icon_pure_unfold12_svg;
        }
        this.lwW.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwX, R.color.CAM_X0107);
        SvgManager.bqB().a(this.leF, this.lxf, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lxa.setPadding(0, this.lxd, 0, this.lxe);
        } else {
            this.lxa.setPadding(0, this.lxb, 0, this.lxc);
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
                    if (PbLinkGoodsRootView.this.lpX == null || PbLinkGoodsRootView.this.lpX.dkv() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lxg == null || PbLinkGoodsRootView.this.lxg.dkv() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.fhk.setVisibility(8);
                        } else {
                            aVar.fhk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dkN();
                                }
                            });
                            aVar.fhk.setVisibility(0);
                            com.baidu.tbadk.core.util.e.a.brc().pF(0).l(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bn(aVar.fhk);
                        }
                    } else {
                        aVar.fhk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dkN();
                            }
                        });
                        aVar.fhk.setVisibility(0);
                        com.baidu.tbadk.core.util.e.a.brc().pF(0).l(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bn(aVar.fhk);
                    }
                    aVar.lxi.a((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lxi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            PbLinkGoodsRootView.this.b((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                        }
                    });
                    if (!(PbLinkGoodsRootView.this.mData.get(i) instanceof PbLinkData) || PbLinkGoodsRootView.this.mData.get(i) == null) {
                        if (PbLinkGoodsRootView.this.mData.get(i) instanceof PbGoodsData) {
                            PbLinkGoodsRootView.this.bz("c13961", 2);
                        }
                    } else if (((PbLinkData) PbLinkGoodsRootView.this.mData.get(i)).urlType == 2) {
                        PbLinkGoodsRootView.this.bz("c13961", 1);
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
                    bf.bqF().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    bf.bqF().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    bz("c13962", 1);
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
                            bf.bqF().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    bf.bqF().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bz("c13962", 2);
            }
        }
    }

    /* loaded from: classes21.dex */
    class a extends RecyclerView.ViewHolder {
        private View fhk;
        private SingleLinkCardView lxi;

        public a(View view) {
            super(view);
            this.fhk = view.findViewById(R.id.mask_view);
            this.lxi = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(String str, int i) {
        if (this.akt != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str).ak("obj_type", i).w("fid", this.akt.getFid()).dR("fname", this.akt.blG()).dR("tid", this.akt.getTid()));
        }
    }
}
