package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.m;
/* loaded from: classes9.dex */
public class a extends m<com.baidu.tieba.pb.data.a, C0705a> {
    private com.baidu.tieba.pb.data.e kck;
    private b kot;
    private com.baidu.tieba.pb.data.a kou;
    private View.OnClickListener kov;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kov = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kou != null && a.this.kou.jYA != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        be.checkUpIsLogin(a.this.kbv.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.kou);
                    if (a.this.kou.jYA.cGL()) {
                        bc.aWU().a((TbPageContext<?>) a.this.kbv.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.kou.jYA.cGK()) {
                        a.this.kot.c(a.this.kou);
                    }
                }
            }
        };
        this.kot = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cm */
    public C0705a b(ViewGroup viewGroup) {
        C0705a c0705a = new C0705a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0705a.setOnClickListener(this.kov);
        return c0705a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0705a c0705a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0705a);
        if (aVar != null && c0705a != null) {
            aVar.locate = i + 1;
            this.kou = aVar;
            a(aVar);
            c0705a.a(this.mContext, aVar.jYA);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.jYA.jYB + "";
        com.baidu.tieba.s.c.dgX().a(this.kbv.getUniqueId(), com.baidu.tieba.s.a.a(this.kck.cGN().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.kck.cGN(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dgX().b(this.kbv.getUniqueId(), com.baidu.tieba.s.a.a(this.kck.cGN(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.jYA.jYB + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.kot != null) {
            this.kot.onDestroy();
        }
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.kck = eVar;
        if (this.kot != null) {
            this.kot.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0705a extends ad.a {
        private ProgressBar koA;
        private TextView koB;
        private View koC;
        private TextView kox;
        private TbImageView koy;
        private TextView koz;
        private View.OnClickListener mOnItemClickListener;

        private C0705a(View view) {
            super(view);
            this.koC = view.findViewById(R.id.bg_ad_card_gift);
            this.koy = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.kox = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.koz = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.koA = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.koB = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.koy.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.koy.setConrers(5);
            this.koy.setDefaultBgResource(R.color.cp_atp_a);
            this.koy.setDrawCorner(true);
            this.koz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0705a.this.mOnItemClickListener != null) {
                        C0705a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.koA.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.koB.setText(bVar.card_name);
                this.koy.startLoad(bVar.card_logo, 38, false);
                this.kox.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.koA.setProgress(i);
                if (bVar.cGK()) {
                    this.koz.setText(R.string.pb_ad_card_gift_get);
                    an.setViewTextColor(this.koz, (int) R.color.cp_cont_a);
                    an.setBackgroundResource(this.koz, R.drawable.btn_pb_ad_card_gift_get);
                    this.koz.setClickable(true);
                } else if (bVar.cGL()) {
                    this.koz.setText(R.string.pb_ad_card_gift_watch_btn);
                    an.setViewTextColor(this.koz, (int) R.color.cp_cont_a);
                    an.setBackgroundResource(this.koz, R.drawable.btn_pb_ad_card_gift_watch);
                    this.koz.setClickable(true);
                } else {
                    this.koz.setText(R.string.pb_ad_card_gift_over_btn);
                    an.setViewTextColor(this.koz, (int) R.color.cp_cont_d);
                    this.koz.setBackgroundResource(R.drawable.transparent_bg);
                    this.koz.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            an.setBackgroundResource(this.koC, R.drawable.bg_pb_ad_card_gift);
            an.setViewTextColor(this.koB, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.kox, (int) R.color.cp_cont_j);
            this.koA.setProgressDrawable(an.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
