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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
/* loaded from: classes22.dex */
public class a extends o<com.baidu.tieba.pb.data.a, C0831a> {
    private f lEv;
    private b lRD;
    private com.baidu.tieba.pb.data.a lRE;
    private View.OnClickListener lRF;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lRF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lRE != null && a.this.lRE.lAz != null && !l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bh.checkUpIsLogin(a.this.lDI.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lRE);
                    if (a.this.lRE.lAz.dmS()) {
                        bf.bua().a((TbPageContext<?>) a.this.lDI.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lRE.lAz.dmR()) {
                        a.this.lRD.c(a.this.lRE);
                    }
                }
            }
        };
        this.lRD = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public C0831a c(ViewGroup viewGroup) {
        C0831a c0831a = new C0831a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0831a.setOnClickListener(this.lRF);
        return c0831a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0831a c0831a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0831a);
        if (aVar != null && c0831a != null) {
            aVar.locate = i + 1;
            this.lRE = aVar;
            a(aVar);
            c0831a.a(this.mContext, aVar.lAz);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lAz.lAA + "";
        com.baidu.tieba.t.c.dOf().a(this.lDI.getUniqueId(), com.baidu.tieba.t.a.a(this.lEv.dmU().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.t.a.a(this.lEv.dmU(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.t.c.dOf().b(this.lDI.getUniqueId(), com.baidu.tieba.t.a.a(this.lEv.dmU(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lAz.lAA + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lRD != null) {
            this.lRD.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lEv = fVar;
        if (this.lRD != null) {
            this.lRD.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0831a extends af.a {
        private TextView lRH;
        private TbImageView lRI;
        private TextView lRJ;
        private ProgressBar lRK;
        private TextView lRL;
        private View lRM;
        private View.OnClickListener mOnItemClickListener;

        private C0831a(View view) {
            super(view);
            this.lRM = view.findViewById(R.id.bg_ad_card_gift);
            this.lRI = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lRH = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lRJ = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lRK = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lRL = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lRI.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lRI.setConrers(5);
            this.lRI.setDefaultBgResource(R.color.cp_atp_a);
            this.lRI.setDrawCorner(true);
            this.lRJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0831a.this.mOnItemClickListener != null) {
                        C0831a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lRK.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lRL.setText(bVar.card_name);
                this.lRI.startLoad(bVar.card_logo, 38, false);
                this.lRH.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lRK.setProgress(i);
                if (bVar.dmR()) {
                    this.lRJ.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.lRJ, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.lRJ, R.drawable.btn_pb_ad_card_gift_get);
                    this.lRJ.setClickable(true);
                } else if (bVar.dmS()) {
                    this.lRJ.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.lRJ, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.lRJ, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lRJ.setClickable(true);
                } else {
                    this.lRJ.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.lRJ, R.color.CAM_X0109);
                    this.lRJ.setBackgroundResource(R.drawable.transparent_bg);
                    this.lRJ.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.lRM, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.lRL, R.color.CAM_X0105);
            ap.setViewTextColor(this.lRH, R.color.CAM_X0107);
            this.lRK.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
