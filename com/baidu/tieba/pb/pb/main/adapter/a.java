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
    private e iEI;
    private b iQb;
    private com.baidu.tieba.pb.data.a iQc;
    private View.OnClickListener iQd;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iQd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iQc != null && a.this.iQc.iBs != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.iDY.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.iQc);
                    if (a.this.iQc.iBs.ckr()) {
                        ba.aGG().a((TbPageContext<?>) a.this.iDY.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.iQc.iBs.ckq()) {
                        a.this.iQb.c(a.this.iQc);
                    }
                }
            }
        };
        this.iQb = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public C0575a b(ViewGroup viewGroup) {
        C0575a c0575a = new C0575a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0575a.setOnClickListener(this.iQd);
        return c0575a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0575a c0575a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0575a);
        if (aVar != null && c0575a != null) {
            aVar.locate = i + 1;
            this.iQc = aVar;
            a(aVar);
            c0575a.a(this.mContext, aVar.iBs);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.iBs.iBt + "";
        com.baidu.tieba.s.c.cKa().a(this.iDY.getUniqueId(), com.baidu.tieba.s.a.a(this.iEI.cku().getTid(), str, "", null), com.baidu.tieba.s.a.a(this.iEI.cku(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.cKa().b(this.iDY.getUniqueId(), com.baidu.tieba.s.a.a(this.iEI.cku(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.iBs.iBt + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.iQb != null) {
            this.iQb.onDestroy();
        }
    }

    public void setData(e eVar) {
        this.iEI = eVar;
        if (this.iQb != null) {
            this.iQb.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0575a extends v.a {
        private TextView iQf;
        private TbImageView iQg;
        private TextView iQh;
        private ProgressBar iQi;
        private TextView iQj;
        private View iQk;
        private View.OnClickListener mOnItemClickListener;

        private C0575a(View view) {
            super(view);
            this.iQk = view.findViewById(R.id.bg_ad_card_gift);
            this.iQg = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.iQf = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.iQh = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.iQi = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.iQj = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.iQg.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.iQg.setConrers(5);
            this.iQg.setDefaultBgResource(R.color.cp_atp_a);
            this.iQg.setDrawCorner(true);
            this.iQh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0575a.this.mOnItemClickListener != null) {
                        C0575a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.iQi.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.iQj.setText(bVar.card_name);
                this.iQg.startLoad(bVar.card_logo, 38, false);
                this.iQf.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.iQi.setProgress(i);
                if (bVar.ckq()) {
                    this.iQh.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.iQh, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iQh, R.drawable.btn_pb_ad_card_gift_get);
                    this.iQh.setClickable(true);
                } else if (bVar.ckr()) {
                    this.iQh.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.iQh, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iQh, R.drawable.btn_pb_ad_card_gift_watch);
                    this.iQh.setClickable(true);
                } else {
                    this.iQh.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.iQh, (int) R.color.cp_cont_d);
                    this.iQh.setBackgroundResource(R.drawable.transparent_bg);
                    this.iQh.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.iQk, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.iQj, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iQf, (int) R.color.cp_cont_j);
            this.iQi.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
