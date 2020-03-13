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
public class a extends l<com.baidu.tieba.pb.data.a, C0575a> {
    private e iEU;
    private b iQn;
    private com.baidu.tieba.pb.data.a iQo;
    private View.OnClickListener iQp;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iQp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iQo != null && a.this.iQo.iBE != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.iEk.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.iQo);
                    if (a.this.iQo.iBE.cks()) {
                        ba.aGG().a((TbPageContext<?>) a.this.iEk.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.iQo.iBE.ckr()) {
                        a.this.iQn.c(a.this.iQo);
                    }
                }
            }
        };
        this.iQn = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public C0575a b(ViewGroup viewGroup) {
        C0575a c0575a = new C0575a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0575a.setOnClickListener(this.iQp);
        return c0575a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0575a c0575a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0575a);
        if (aVar != null && c0575a != null) {
            aVar.locate = i + 1;
            this.iQo = aVar;
            a(aVar);
            c0575a.a(this.mContext, aVar.iBE);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.iBE.iBF + "";
        com.baidu.tieba.s.c.cKb().a(this.iEk.getUniqueId(), com.baidu.tieba.s.a.a(this.iEU.ckv().getTid(), str, "", null), com.baidu.tieba.s.a.a(this.iEU.ckv(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.cKb().b(this.iEk.getUniqueId(), com.baidu.tieba.s.a.a(this.iEU.ckv(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.iBE.iBF + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.iQn != null) {
            this.iQn.onDestroy();
        }
    }

    public void setData(e eVar) {
        this.iEU = eVar;
        if (this.iQn != null) {
            this.iQn.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0575a extends v.a {
        private TextView iQr;
        private TbImageView iQs;
        private TextView iQt;
        private ProgressBar iQu;
        private TextView iQv;
        private View iQw;
        private View.OnClickListener mOnItemClickListener;

        private C0575a(View view) {
            super(view);
            this.iQw = view.findViewById(R.id.bg_ad_card_gift);
            this.iQs = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.iQr = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.iQt = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.iQu = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.iQv = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.iQs.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.iQs.setConrers(5);
            this.iQs.setDefaultBgResource(R.color.cp_atp_a);
            this.iQs.setDrawCorner(true);
            this.iQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0575a.this.mOnItemClickListener != null) {
                        C0575a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.iQu.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.iQv.setText(bVar.card_name);
                this.iQs.startLoad(bVar.card_logo, 38, false);
                this.iQr.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.iQu.setProgress(i);
                if (bVar.ckr()) {
                    this.iQt.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.iQt, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iQt, R.drawable.btn_pb_ad_card_gift_get);
                    this.iQt.setClickable(true);
                } else if (bVar.cks()) {
                    this.iQt.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.iQt, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iQt, R.drawable.btn_pb_ad_card_gift_watch);
                    this.iQt.setClickable(true);
                } else {
                    this.iQt.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.iQt, (int) R.color.cp_cont_d);
                    this.iQt.setBackgroundResource(R.drawable.transparent_bg);
                    this.iQt.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.iQw, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.iQv, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iQr, (int) R.color.cp_cont_j);
            this.iQu.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
