package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.m;
/* loaded from: classes6.dex */
public class a extends m<com.baidu.tieba.pb.data.b, C0563a> {
    private b iLa;
    private com.baidu.tieba.pb.data.b iLb;
    private View.OnClickListener iLc;
    private f izv;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iLc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iLb != null && a.this.iLb.ivU != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.iyA.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.iLb);
                    if (a.this.iLb.ivU.chH()) {
                        ba.aEa().a((TbPageContext<?>) a.this.iyA.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.iLb.ivU.chG()) {
                        a.this.iLa.c(a.this.iLb);
                    }
                }
            }
        };
        this.iLa = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public C0563a b(ViewGroup viewGroup) {
        C0563a c0563a = new C0563a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0563a.setOnClickListener(this.iLc);
        return c0563a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.b bVar, C0563a c0563a) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tieba.pb.data.b) c0563a);
        if (bVar != null && c0563a != null) {
            bVar.locate = i + 1;
            this.iLb = bVar;
            a(bVar);
            c0563a.a(this.mContext, bVar.ivU);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.b bVar) {
        String str = bVar.ivU.ivV + "";
        com.baidu.tieba.r.c.cHo().a(this.iyA.getUniqueId(), com.baidu.tieba.r.a.a(this.izv.chK().getTid(), str, "", null), com.baidu.tieba.r.a.a(this.izv.chK(), PageStayDurationConstants.PageName.PB, "common_exp", bVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.b bVar) {
        com.baidu.tieba.r.c.cHo().b(this.iyA.getUniqueId(), com.baidu.tieba.r.a.a(this.izv.chK(), PageStayDurationConstants.PageName.PB, "common_click", 1, bVar.locate, true, bVar.ivU.ivV + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.iLa != null) {
            this.iLa.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.izv = fVar;
        if (this.iLa != null) {
            this.iLa.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0563a extends v.a {
        private TextView iLe;
        private TbImageView iLf;
        private TextView iLg;
        private ProgressBar iLh;
        private TextView iLi;
        private View iLj;
        private View.OnClickListener mOnItemClickListener;

        private C0563a(View view) {
            super(view);
            this.iLj = view.findViewById(R.id.bg_ad_card_gift);
            this.iLf = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.iLe = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.iLg = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.iLh = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.iLi = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.iLf.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.iLf.setConrers(5);
            this.iLf.setDefaultBgResource(R.color.cp_atp_a);
            this.iLf.setDrawCorner(true);
            this.iLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0563a.this.mOnItemClickListener != null) {
                        C0563a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.iLh.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.c cVar) {
            int i = 100;
            if (cVar != null) {
                this.iLi.setText(cVar.card_name);
                this.iLf.startLoad(cVar.card_logo, 38, false);
                this.iLe.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, cVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(cVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.iLh.setProgress(i);
                if (cVar.chG()) {
                    this.iLg.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.iLg, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iLg, R.drawable.btn_pb_ad_card_gift_get);
                    this.iLg.setClickable(true);
                } else if (cVar.chH()) {
                    this.iLg.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.iLg, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iLg, R.drawable.btn_pb_ad_card_gift_watch);
                    this.iLg.setClickable(true);
                } else {
                    this.iLg.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.iLg, (int) R.color.cp_cont_d);
                    this.iLg.setBackgroundResource(R.drawable.transparent_bg);
                    this.iLg.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.iLj, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.iLi, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iLe, (int) R.color.cp_cont_j);
            this.iLh.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
