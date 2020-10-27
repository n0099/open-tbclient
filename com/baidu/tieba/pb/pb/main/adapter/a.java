package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
/* loaded from: classes22.dex */
public class a extends o<com.baidu.tieba.pb.data.a, C0798a> {
    private f lku;
    private b lxv;
    private com.baidu.tieba.pb.data.a lxw;
    private View.OnClickListener lxx;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lxx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lxw != null && a.this.lxw.lgL != null && !l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.ljH.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lxw);
                    if (a.this.lxw.lgL.dfG()) {
                        be.boR().a((TbPageContext<?>) a.this.ljH.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lxw.lgL.dfF()) {
                        a.this.lxv.c(a.this.lxw);
                    }
                }
            }
        };
        this.lxv = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public C0798a c(ViewGroup viewGroup) {
        C0798a c0798a = new C0798a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0798a.setOnClickListener(this.lxx);
        return c0798a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0798a c0798a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0798a);
        if (aVar != null && c0798a != null) {
            aVar.locate = i + 1;
            this.lxw = aVar;
            a(aVar);
            c0798a.a(this.mContext, aVar.lgL);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lgL.lgM + "";
        com.baidu.tieba.s.c.dGv().a(this.ljH.getUniqueId(), com.baidu.tieba.s.a.a(this.lku.dfI().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lku.dfI(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dGv().b(this.ljH.getUniqueId(), com.baidu.tieba.s.a.a(this.lku.dfI(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lgL.lgM + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lxv != null) {
            this.lxv.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lku = fVar;
        if (this.lxv != null) {
            this.lxv.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0798a extends af.a {
        private TbImageView lxA;
        private TextView lxB;
        private ProgressBar lxC;
        private TextView lxD;
        private View lxE;
        private TextView lxz;
        private View.OnClickListener mOnItemClickListener;

        private C0798a(View view) {
            super(view);
            this.lxE = view.findViewById(R.id.bg_ad_card_gift);
            this.lxA = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lxz = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lxB = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lxC = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lxD = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lxA.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lxA.setConrers(5);
            this.lxA.setDefaultBgResource(R.color.cp_atp_a);
            this.lxA.setDrawCorner(true);
            this.lxB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0798a.this.mOnItemClickListener != null) {
                        C0798a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lxC.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lxD.setText(bVar.card_name);
                this.lxA.startLoad(bVar.card_logo, 38, false);
                this.lxz.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lxC.setProgress(i);
                if (bVar.dfF()) {
                    this.lxB.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.lxB, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.lxB, R.drawable.btn_pb_ad_card_gift_get);
                    this.lxB.setClickable(true);
                } else if (bVar.dfG()) {
                    this.lxB.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.lxB, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.lxB, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lxB.setClickable(true);
                } else {
                    this.lxB.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.lxB, R.color.cp_cont_d);
                    this.lxB.setBackgroundResource(R.drawable.transparent_bg);
                    this.lxB.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.lxE, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.lxD, R.color.cp_cont_b);
            ap.setViewTextColor(this.lxz, R.color.cp_cont_j);
            this.lxC.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
