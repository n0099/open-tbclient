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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
/* loaded from: classes16.dex */
public class a extends o<com.baidu.tieba.pb.data.a, C0717a> {
    private f kkO;
    private b kxt;
    private com.baidu.tieba.pb.data.a kxu;
    private View.OnClickListener kxv;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kxv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kxu != null && a.this.kxu.khc != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bf.checkUpIsLogin(a.this.kkb.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.kxu);
                    if (a.this.kxu.khc.cKv()) {
                        bd.baV().a((TbPageContext<?>) a.this.kkb.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.kxu.khc.cKu()) {
                        a.this.kxt.c(a.this.kxu);
                    }
                }
            }
        };
        this.kxt = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public C0717a b(ViewGroup viewGroup) {
        C0717a c0717a = new C0717a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0717a.setOnClickListener(this.kxv);
        return c0717a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0717a c0717a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0717a);
        if (aVar != null && c0717a != null) {
            aVar.locate = i + 1;
            this.kxu = aVar;
            a(aVar);
            c0717a.a(this.mContext, aVar.khc);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.khc.khd + "";
        com.baidu.tieba.s.c.dkh().a(this.kkb.getUniqueId(), com.baidu.tieba.s.a.a(this.kkO.cKx().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.kkO.cKx(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dkh().b(this.kkb.getUniqueId(), com.baidu.tieba.s.a.a(this.kkO.cKx(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.khc.khd + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.kxt != null) {
            this.kxt.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.kkO = fVar;
        if (this.kxt != null) {
            this.kxt.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0717a extends ad.a {
        private ProgressBar kxA;
        private TextView kxB;
        private View kxC;
        private TextView kxx;
        private TbImageView kxy;
        private TextView kxz;
        private View.OnClickListener mOnItemClickListener;

        private C0717a(View view) {
            super(view);
            this.kxC = view.findViewById(R.id.bg_ad_card_gift);
            this.kxy = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.kxx = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.kxz = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.kxA = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.kxB = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.kxy.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.kxy.setConrers(5);
            this.kxy.setDefaultBgResource(R.color.cp_atp_a);
            this.kxy.setDrawCorner(true);
            this.kxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0717a.this.mOnItemClickListener != null) {
                        C0717a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.kxA.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.kxB.setText(bVar.card_name);
                this.kxy.startLoad(bVar.card_logo, 38, false);
                this.kxx.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.kxA.setProgress(i);
                if (bVar.cKu()) {
                    this.kxz.setText(R.string.pb_ad_card_gift_get);
                    ao.setViewTextColor(this.kxz, R.color.cp_cont_a);
                    ao.setBackgroundResource(this.kxz, R.drawable.btn_pb_ad_card_gift_get);
                    this.kxz.setClickable(true);
                } else if (bVar.cKv()) {
                    this.kxz.setText(R.string.pb_ad_card_gift_watch_btn);
                    ao.setViewTextColor(this.kxz, R.color.cp_cont_a);
                    ao.setBackgroundResource(this.kxz, R.drawable.btn_pb_ad_card_gift_watch);
                    this.kxz.setClickable(true);
                } else {
                    this.kxz.setText(R.string.pb_ad_card_gift_over_btn);
                    ao.setViewTextColor(this.kxz, R.color.cp_cont_d);
                    this.kxz.setBackgroundResource(R.drawable.transparent_bg);
                    this.kxz.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ao.setBackgroundResource(this.kxC, R.drawable.bg_pb_ad_card_gift);
            ao.setViewTextColor(this.kxB, R.color.cp_cont_b);
            ao.setViewTextColor(this.kxx, R.color.cp_cont_j);
            this.kxA.setProgressDrawable(ao.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
