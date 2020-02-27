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
    private e iEG;
    private b iPZ;
    private com.baidu.tieba.pb.data.a iQa;
    private View.OnClickListener iQb;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iQb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iQa != null && a.this.iQa.iBq != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.iDW.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.iQa);
                    if (a.this.iQa.iBq.ckp()) {
                        ba.aGE().a((TbPageContext<?>) a.this.iDW.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.iQa.iBq.cko()) {
                        a.this.iPZ.c(a.this.iQa);
                    }
                }
            }
        };
        this.iPZ = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public C0575a b(ViewGroup viewGroup) {
        C0575a c0575a = new C0575a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0575a.setOnClickListener(this.iQb);
        return c0575a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0575a c0575a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0575a);
        if (aVar != null && c0575a != null) {
            aVar.locate = i + 1;
            this.iQa = aVar;
            a(aVar);
            c0575a.a(this.mContext, aVar.iBq);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.iBq.iBr + "";
        com.baidu.tieba.s.c.cJY().a(this.iDW.getUniqueId(), com.baidu.tieba.s.a.a(this.iEG.cks().getTid(), str, "", null), com.baidu.tieba.s.a.a(this.iEG.cks(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.cJY().b(this.iDW.getUniqueId(), com.baidu.tieba.s.a.a(this.iEG.cks(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.iBq.iBr + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.iPZ != null) {
            this.iPZ.onDestroy();
        }
    }

    public void setData(e eVar) {
        this.iEG = eVar;
        if (this.iPZ != null) {
            this.iPZ.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0575a extends v.a {
        private TextView iQd;
        private TbImageView iQe;
        private TextView iQf;
        private ProgressBar iQg;
        private TextView iQh;
        private View iQi;
        private View.OnClickListener mOnItemClickListener;

        private C0575a(View view) {
            super(view);
            this.iQi = view.findViewById(R.id.bg_ad_card_gift);
            this.iQe = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.iQd = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.iQf = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.iQg = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.iQh = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.iQe.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.iQe.setConrers(5);
            this.iQe.setDefaultBgResource(R.color.cp_atp_a);
            this.iQe.setDrawCorner(true);
            this.iQf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0575a.this.mOnItemClickListener != null) {
                        C0575a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.iQg.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.iQh.setText(bVar.card_name);
                this.iQe.startLoad(bVar.card_logo, 38, false);
                this.iQd.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.iQg.setProgress(i);
                if (bVar.cko()) {
                    this.iQf.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.iQf, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iQf, R.drawable.btn_pb_ad_card_gift_get);
                    this.iQf.setClickable(true);
                } else if (bVar.ckp()) {
                    this.iQf.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.iQf, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iQf, R.drawable.btn_pb_ad_card_gift_watch);
                    this.iQf.setClickable(true);
                } else {
                    this.iQf.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.iQf, (int) R.color.cp_cont_d);
                    this.iQf.setBackgroundResource(R.drawable.transparent_bg);
                    this.iQf.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.iQi, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.iQh, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iQd, (int) R.color.cp_cont_j);
            this.iQg.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
