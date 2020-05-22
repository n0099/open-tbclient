package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.m;
/* loaded from: classes9.dex */
public class a extends m<com.baidu.tieba.pb.data.a, C0688a> {
    private com.baidu.tieba.pb.data.e jHu;
    private b jTx;
    private com.baidu.tieba.pb.data.a jTy;
    private View.OnClickListener jTz;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.jTz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jTy != null && a.this.jTy.jDK != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.jGF.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.jTy);
                    if (a.this.jTy.jDK.cCf()) {
                        ba.aUZ().a((TbPageContext<?>) a.this.jGF.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.jTy.jDK.cCe()) {
                        a.this.jTx.c(a.this.jTy);
                    }
                }
            }
        };
        this.jTx = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ca */
    public C0688a b(ViewGroup viewGroup) {
        C0688a c0688a = new C0688a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0688a.setOnClickListener(this.jTz);
        return c0688a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0688a c0688a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0688a);
        if (aVar != null && c0688a != null) {
            aVar.locate = i + 1;
            this.jTy = aVar;
            a(aVar);
            c0688a.a(this.mContext, aVar.jDK);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.jDK.jDL + "";
        com.baidu.tieba.s.c.dct().a(this.jGF.getUniqueId(), com.baidu.tieba.s.a.a(this.jHu.cCi().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.jHu.cCi(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dct().b(this.jGF.getUniqueId(), com.baidu.tieba.s.a.a(this.jHu.cCi(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.jDK.jDL + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.jTx != null) {
            this.jTx.onDestroy();
        }
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jHu = eVar;
        if (this.jTx != null) {
            this.jTx.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0688a extends aa.a {
        private TextView jTB;
        private TbImageView jTC;
        private TextView jTD;
        private ProgressBar jTE;
        private TextView jTF;
        private View jTG;
        private View.OnClickListener mOnItemClickListener;

        private C0688a(View view) {
            super(view);
            this.jTG = view.findViewById(R.id.bg_ad_card_gift);
            this.jTC = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.jTB = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.jTD = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.jTE = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.jTF = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.jTC.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.jTC.setConrers(5);
            this.jTC.setDefaultBgResource(R.color.cp_atp_a);
            this.jTC.setDrawCorner(true);
            this.jTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0688a.this.mOnItemClickListener != null) {
                        C0688a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.jTE.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.jTF.setText(bVar.card_name);
                this.jTC.startLoad(bVar.card_logo, 38, false);
                this.jTB.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.jTE.setProgress(i);
                if (bVar.cCe()) {
                    this.jTD.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.jTD, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jTD, R.drawable.btn_pb_ad_card_gift_get);
                    this.jTD.setClickable(true);
                } else if (bVar.cCf()) {
                    this.jTD.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.jTD, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jTD, R.drawable.btn_pb_ad_card_gift_watch);
                    this.jTD.setClickable(true);
                } else {
                    this.jTD.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.jTD, (int) R.color.cp_cont_d);
                    this.jTD.setBackgroundResource(R.drawable.transparent_bg);
                    this.jTD.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.jTG, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.jTF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jTB, (int) R.color.cp_cont_j);
            this.jTE.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
