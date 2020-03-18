package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes9.dex */
public class a extends l<com.baidu.tieba.pb.data.a, C0576a> {
    private e iGv;
    private b iRO;
    private com.baidu.tieba.pb.data.a iRP;
    private View.OnClickListener iRQ;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iRQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iRP != null && a.this.iRP.iDe != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.iFL.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.iRP);
                    if (a.this.iRP.iDe.ckM()) {
                        ba.aGK().a((TbPageContext<?>) a.this.iFL.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.iRP.iDe.ckL()) {
                        a.this.iRO.c(a.this.iRP);
                    }
                }
            }
        };
        this.iRO = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public C0576a b(ViewGroup viewGroup) {
        C0576a c0576a = new C0576a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0576a.setOnClickListener(this.iRQ);
        return c0576a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0576a c0576a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0576a);
        if (aVar != null && c0576a != null) {
            aVar.locate = i + 1;
            this.iRP = aVar;
            a(aVar);
            c0576a.a(this.mContext, aVar.iDe);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.iDe.iDf + "";
        com.baidu.tieba.s.c.cKv().a(this.iFL.getUniqueId(), com.baidu.tieba.s.a.a(this.iGv.ckP().getTid(), str, "", null), com.baidu.tieba.s.a.a(this.iGv.ckP(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.cKv().b(this.iFL.getUniqueId(), com.baidu.tieba.s.a.a(this.iGv.ckP(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.iDe.iDf + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.iRO != null) {
            this.iRO.onDestroy();
        }
    }

    public void setData(e eVar) {
        this.iGv = eVar;
        if (this.iRO != null) {
            this.iRO.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0576a extends v.a {
        private TextView iRS;
        private TbImageView iRT;
        private TextView iRU;
        private ProgressBar iRV;
        private TextView iRW;
        private View iRX;
        private View.OnClickListener mOnItemClickListener;

        private C0576a(View view) {
            super(view);
            this.iRX = view.findViewById(R.id.bg_ad_card_gift);
            this.iRT = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.iRS = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.iRU = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.iRV = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.iRW = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.iRT.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.iRT.setConrers(5);
            this.iRT.setDefaultBgResource(R.color.cp_atp_a);
            this.iRT.setDrawCorner(true);
            this.iRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0576a.this.mOnItemClickListener != null) {
                        C0576a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.iRV.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.iRW.setText(bVar.card_name);
                this.iRT.startLoad(bVar.card_logo, 38, false);
                this.iRS.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.iRV.setProgress(i);
                if (bVar.ckL()) {
                    this.iRU.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.iRU, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iRU, R.drawable.btn_pb_ad_card_gift_get);
                    this.iRU.setClickable(true);
                } else if (bVar.ckM()) {
                    this.iRU.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.iRU, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iRU, R.drawable.btn_pb_ad_card_gift_watch);
                    this.iRU.setClickable(true);
                } else {
                    this.iRU.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.iRU, (int) R.color.cp_cont_d);
                    this.iRU.setBackgroundResource(R.drawable.transparent_bg);
                    this.iRU.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.iRX, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.iRW, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iRS, (int) R.color.cp_cont_j);
            this.iRV.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
