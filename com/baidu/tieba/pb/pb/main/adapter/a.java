package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
/* loaded from: classes16.dex */
public class a extends o<com.baidu.tieba.pb.data.a, C0768a> {
    private f kAg;
    private b kMY;
    private com.baidu.tieba.pb.data.a kMZ;
    private View.OnClickListener kNa;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kNa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kMZ != null && a.this.kMZ.kwv != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.kzt.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.kMZ);
                    if (a.this.kMZ.kwv.cVj()) {
                        be.bju().a((TbPageContext<?>) a.this.kzt.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.kMZ.kwv.cVi()) {
                        a.this.kMY.c(a.this.kMZ);
                    }
                }
            }
        };
        this.kMY = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cl */
    public C0768a b(ViewGroup viewGroup) {
        C0768a c0768a = new C0768a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0768a.setOnClickListener(this.kNa);
        return c0768a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0768a c0768a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0768a);
        if (aVar != null && c0768a != null) {
            aVar.locate = i + 1;
            this.kMZ = aVar;
            a(aVar);
            c0768a.a(this.mContext, aVar.kwv);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.kwv.kww + "";
        com.baidu.tieba.s.c.dvE().a(this.kzt.getUniqueId(), com.baidu.tieba.s.a.a(this.kAg.cVl().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.kAg.cVl(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dvE().b(this.kzt.getUniqueId(), com.baidu.tieba.s.a.a(this.kAg.cVl(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.kwv.kww + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.kMY != null) {
            this.kMY.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.kAg = fVar;
        if (this.kMY != null) {
            this.kMY.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0768a extends af.a {
        private TextView kNc;
        private TbImageView kNd;
        private TextView kNe;
        private ProgressBar kNf;
        private TextView kNg;
        private View kNh;
        private View.OnClickListener mOnItemClickListener;

        private C0768a(View view) {
            super(view);
            this.kNh = view.findViewById(R.id.bg_ad_card_gift);
            this.kNd = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.kNc = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.kNe = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.kNf = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.kNg = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.kNd.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.kNd.setConrers(5);
            this.kNd.setDefaultBgResource(R.color.cp_atp_a);
            this.kNd.setDrawCorner(true);
            this.kNe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0768a.this.mOnItemClickListener != null) {
                        C0768a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.kNf.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.kNg.setText(bVar.card_name);
                this.kNd.startLoad(bVar.card_logo, 38, false);
                this.kNc.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.kNf.setProgress(i);
                if (bVar.cVi()) {
                    this.kNe.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.kNe, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.kNe, R.drawable.btn_pb_ad_card_gift_get);
                    this.kNe.setClickable(true);
                } else if (bVar.cVj()) {
                    this.kNe.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.kNe, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.kNe, R.drawable.btn_pb_ad_card_gift_watch);
                    this.kNe.setClickable(true);
                } else {
                    this.kNe.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.kNe, R.color.cp_cont_d);
                    this.kNe.setBackgroundResource(R.drawable.transparent_bg);
                    this.kNe.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.kNh, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.kNg, R.color.cp_cont_b);
            ap.setViewTextColor(this.kNc, R.color.cp_cont_j);
            this.kNf.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
