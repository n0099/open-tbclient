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
public class a extends m<com.baidu.tieba.pb.data.a, C0689a> {
    private com.baidu.tieba.pb.data.e jIA;
    private b jUD;
    private com.baidu.tieba.pb.data.a jUE;
    private View.OnClickListener jUF;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.jUF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jUE != null && a.this.jUE.jEQ != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.jHL.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.jUE);
                    if (a.this.jUE.jEQ.cCv()) {
                        ba.aVa().a((TbPageContext<?>) a.this.jHL.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.jUE.jEQ.cCu()) {
                        a.this.jUD.c(a.this.jUE);
                    }
                }
            }
        };
        this.jUD = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ca */
    public C0689a b(ViewGroup viewGroup) {
        C0689a c0689a = new C0689a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0689a.setOnClickListener(this.jUF);
        return c0689a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0689a c0689a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0689a);
        if (aVar != null && c0689a != null) {
            aVar.locate = i + 1;
            this.jUE = aVar;
            a(aVar);
            c0689a.a(this.mContext, aVar.jEQ);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.jEQ.jER + "";
        com.baidu.tieba.s.c.dcI().a(this.jHL.getUniqueId(), com.baidu.tieba.s.a.a(this.jIA.cCy().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.jIA.cCy(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dcI().b(this.jHL.getUniqueId(), com.baidu.tieba.s.a.a(this.jIA.cCy(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.jEQ.jER + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.jUD != null) {
            this.jUD.onDestroy();
        }
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.jIA = eVar;
        if (this.jUD != null) {
            this.jUD.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0689a extends aa.a {
        private TextView jUH;
        private TbImageView jUI;
        private TextView jUJ;
        private ProgressBar jUK;
        private TextView jUL;
        private View jUM;
        private View.OnClickListener mOnItemClickListener;

        private C0689a(View view) {
            super(view);
            this.jUM = view.findViewById(R.id.bg_ad_card_gift);
            this.jUI = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.jUH = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.jUJ = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.jUK = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.jUL = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.jUI.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.jUI.setConrers(5);
            this.jUI.setDefaultBgResource(R.color.cp_atp_a);
            this.jUI.setDrawCorner(true);
            this.jUJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0689a.this.mOnItemClickListener != null) {
                        C0689a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.jUK.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.jUL.setText(bVar.card_name);
                this.jUI.startLoad(bVar.card_logo, 38, false);
                this.jUH.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.jUK.setProgress(i);
                if (bVar.cCu()) {
                    this.jUJ.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.jUJ, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jUJ, R.drawable.btn_pb_ad_card_gift_get);
                    this.jUJ.setClickable(true);
                } else if (bVar.cCv()) {
                    this.jUJ.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.jUJ, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jUJ, R.drawable.btn_pb_ad_card_gift_watch);
                    this.jUJ.setClickable(true);
                } else {
                    this.jUJ.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.jUJ, (int) R.color.cp_cont_d);
                    this.jUJ.setBackgroundResource(R.drawable.transparent_bg);
                    this.jUJ.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.jUM, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.jUL, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jUH, (int) R.color.cp_cont_j);
            this.jUK.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
