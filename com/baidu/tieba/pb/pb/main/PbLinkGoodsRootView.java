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
    private bz ale;
    private boolean eRH;
    private BdRecyclerView kxL;
    private PbFragment lEi;
    private int lLA;
    private int lLB;
    private int lLC;
    private VideoPbFragment lLD;
    private b lLt;
    private TextView lLu;
    private RelativeLayout lLv;
    private ThreadForumEnterGoodsButton lLw;
    private LinearLayout lLx;
    private int lLy;
    private int lLz;
    private ImageView lsI;
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
        this.eRH = false;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        this.kxL = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.kxL.setNestedScrollingEnabled(false);
        this.lLx = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.lLu = (TextView) findViewById(R.id.tv_post);
        this.lLv = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.lsI = (ImageView) findViewById(R.id.iv_arrow);
        this.lLw = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.lLy = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
        this.lLz = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.lLA = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36);
        this.lLB = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        this.lLt = new b();
        this.kxL.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.kxL.setAdapter(this.lLt);
        this.lLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbLinkGoodsRootView.this.dlX();
            }
        });
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, PbFragment pbFragment, boolean z) {
        this.lEi = pbFragment;
        a(fVar, list, str, z);
        if (this.lEi != null) {
            uW(this.lEi.dlF());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, VideoPbFragment videoPbFragment, boolean z) {
        this.lLD = videoPbFragment;
        a(fVar, list, str, z);
        if (this.lLD != null) {
            uW(this.lLD.dlF());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, List<com.baidu.tieba.card.data.c> list, String str, boolean z) {
        this.mData = list;
        this.ale = fVar.diN();
        this.ale.zR(fVar.getForumName());
        this.ale.setFid(Long.valueOf(fVar.getForumId()).longValue());
        this.eRH = z;
        this.maxCount = list.size();
        if (list.size() < 4) {
            this.lLx.setVisibility(8);
        } else {
            this.lLx.setVisibility(0);
        }
        if (this.eRH) {
            this.eRH = z;
            this.lLw.setFrom(1);
            this.lLw.r(this.ale);
            this.lLw.setVisibility(0);
            return;
        }
        this.lLw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlX() {
        if (this.lEi != null) {
            if (this.lEi.dlF()) {
                this.lEi.uQ(false);
                uW(false);
                return;
            }
            this.lEi.uQ(true);
            uW(true);
            dlY();
        } else if (this.lLD != null) {
            if (this.lLD.dlF()) {
                this.lLD.uQ(false);
                uW(false);
                return;
            }
            this.lLD.uQ(true);
            uW(true);
            dlY();
        }
    }

    private void dlY() {
        if (this.ale != null && this.eRH) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13968").w("fid", this.ale.getFid()).dW("fname", this.ale.bnB()).dW("tid", this.ale.getTid()));
        }
    }

    private void uW(boolean z) {
        if (z) {
            this.maxCount = this.mData.size();
            this.lLu.setText(this.eRH ? getResources().getString(R.string.pb_first_goods_more_close) : getResources().getString(R.string.pb_first_link_more_close));
            this.lLC = R.drawable.icon_pure_fold12_svg;
        } else {
            if (this.maxCount > 3) {
                this.maxCount = 3;
            }
            this.lLu.setText(this.eRH ? getResources().getString(R.string.pb_first_goods_more_open) : getResources().getString(R.string.pb_first_link_more_open));
            this.lLC = R.drawable.icon_pure_unfold12_svg;
        }
        this.lLt.notifyDataSetChanged();
        setMarginTop(z);
        com.baidu.tbadk.core.util.ao.setViewTextColor(this.lLu, R.color.CAM_X0107);
        SvgManager.bsx().a(this.lsI, this.lLC, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setMarginTop(boolean z) {
        if (z) {
            this.lLx.setPadding(0, this.lLA, 0, this.lLB);
        } else {
            this.lLx.setPadding(0, this.lLy, 0, this.lLz);
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
                    if (PbLinkGoodsRootView.this.lEi == null || PbLinkGoodsRootView.this.lEi.dlF() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                        if (PbLinkGoodsRootView.this.lLD == null || PbLinkGoodsRootView.this.lLD.dlF() || i != 2 || PbLinkGoodsRootView.this.mData.size() <= 3) {
                            aVar.ftL.setVisibility(8);
                        } else {
                            aVar.ftL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    PbLinkGoodsRootView.this.dlX();
                                }
                            });
                            aVar.ftL.setVisibility(0);
                            com.baidu.tbadk.core.util.f.a.btb().oJ(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bz(aVar.ftL);
                        }
                    } else {
                        aVar.ftL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PbLinkGoodsRootView.this.dlX();
                            }
                        });
                        aVar.ftL.setVisibility(0);
                        com.baidu.tbadk.core.util.f.a.btb().oJ(0).m(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).bz(aVar.ftL);
                    }
                    aVar.lLF.a((com.baidu.tieba.card.data.c) PbLinkGoodsRootView.this.mData.get(i));
                    aVar.lLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView.b.3
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
                    be.bsB().b(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    be.bsB().b(tbPageContextSupport.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbLinkData.linkUrl)});
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
                            be.bsB().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    be.bsB().b(tbPageContextSupport2.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                bI("c13962", 2);
            }
        }
    }

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ViewHolder {
        private View ftL;
        private SingleLinkCardView lLF;

        public a(View view) {
            super(view);
            this.ftL = view.findViewById(R.id.mask_view);
            this.lLF = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, int i) {
        if (this.ale != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(str).an("obj_type", i).w("fid", this.ale.getFid()).dW("fname", this.ale.bnB()).dW("tid", this.ale.getTid()));
        }
    }
}
