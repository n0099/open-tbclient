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
    private f kkM;
    private b kxr;
    private com.baidu.tieba.pb.data.a kxs;
    private View.OnClickListener kxt;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kxt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kxs != null && a.this.kxs.kha != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bf.checkUpIsLogin(a.this.kjZ.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.kxs);
                    if (a.this.kxs.kha.cKv()) {
                        bd.baV().a((TbPageContext<?>) a.this.kjZ.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.kxs.kha.cKu()) {
                        a.this.kxr.c(a.this.kxs);
                    }
                }
            }
        };
        this.kxr = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public C0717a b(ViewGroup viewGroup) {
        C0717a c0717a = new C0717a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0717a.setOnClickListener(this.kxt);
        return c0717a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0717a c0717a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0717a);
        if (aVar != null && c0717a != null) {
            aVar.locate = i + 1;
            this.kxs = aVar;
            a(aVar);
            c0717a.a(this.mContext, aVar.kha);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.kha.khb + "";
        com.baidu.tieba.s.c.dkh().a(this.kjZ.getUniqueId(), com.baidu.tieba.s.a.a(this.kkM.cKx().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.kkM.cKx(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dkh().b(this.kjZ.getUniqueId(), com.baidu.tieba.s.a.a(this.kkM.cKx(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.kha.khb + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.kxr != null) {
            this.kxr.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.kkM = fVar;
        if (this.kxr != null) {
            this.kxr.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0717a extends ad.a {
        private View kxA;
        private TextView kxv;
        private TbImageView kxw;
        private TextView kxx;
        private ProgressBar kxy;
        private TextView kxz;
        private View.OnClickListener mOnItemClickListener;

        private C0717a(View view) {
            super(view);
            this.kxA = view.findViewById(R.id.bg_ad_card_gift);
            this.kxw = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.kxv = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.kxx = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.kxy = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.kxz = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.kxw.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.kxw.setConrers(5);
            this.kxw.setDefaultBgResource(R.color.cp_atp_a);
            this.kxw.setDrawCorner(true);
            this.kxx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0717a.this.mOnItemClickListener != null) {
                        C0717a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.kxy.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.kxz.setText(bVar.card_name);
                this.kxw.startLoad(bVar.card_logo, 38, false);
                this.kxv.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.kxy.setProgress(i);
                if (bVar.cKu()) {
                    this.kxx.setText(R.string.pb_ad_card_gift_get);
                    ao.setViewTextColor(this.kxx, R.color.cp_cont_a);
                    ao.setBackgroundResource(this.kxx, R.drawable.btn_pb_ad_card_gift_get);
                    this.kxx.setClickable(true);
                } else if (bVar.cKv()) {
                    this.kxx.setText(R.string.pb_ad_card_gift_watch_btn);
                    ao.setViewTextColor(this.kxx, R.color.cp_cont_a);
                    ao.setBackgroundResource(this.kxx, R.drawable.btn_pb_ad_card_gift_watch);
                    this.kxx.setClickable(true);
                } else {
                    this.kxx.setText(R.string.pb_ad_card_gift_over_btn);
                    ao.setViewTextColor(this.kxx, R.color.cp_cont_d);
                    this.kxx.setBackgroundResource(R.drawable.transparent_bg);
                    this.kxx.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ao.setBackgroundResource(this.kxA, R.drawable.bg_pb_ad_card_gift);
            ao.setViewTextColor(this.kxz, R.color.cp_cont_b);
            ao.setViewTextColor(this.kxv, R.color.cp_cont_j);
            this.kxy.setProgressDrawable(ao.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
