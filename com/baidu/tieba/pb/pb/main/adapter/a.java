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
    private f lEt;
    private b lRB;
    private com.baidu.tieba.pb.data.a lRC;
    private View.OnClickListener lRD;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lRD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lRC != null && a.this.lRC.lAx != null && !l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bh.checkUpIsLogin(a.this.lDG.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lRC);
                    if (a.this.lRC.lAx.dmR()) {
                        bf.bua().a((TbPageContext<?>) a.this.lDG.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lRC.lAx.dmQ()) {
                        a.this.lRB.c(a.this.lRC);
                    }
                }
            }
        };
        this.lRB = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public C0831a c(ViewGroup viewGroup) {
        C0831a c0831a = new C0831a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0831a.setOnClickListener(this.lRD);
        return c0831a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0831a c0831a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0831a);
        if (aVar != null && c0831a != null) {
            aVar.locate = i + 1;
            this.lRC = aVar;
            a(aVar);
            c0831a.a(this.mContext, aVar.lAx);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lAx.lAy + "";
        com.baidu.tieba.t.c.dOe().a(this.lDG.getUniqueId(), com.baidu.tieba.t.a.a(this.lEt.dmT().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.t.a.a(this.lEt.dmT(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.t.c.dOe().b(this.lDG.getUniqueId(), com.baidu.tieba.t.a.a(this.lEt.dmT(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lAx.lAy + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lRB != null) {
            this.lRB.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lEt = fVar;
        if (this.lRB != null) {
            this.lRB.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0831a extends af.a {
        private TextView lRF;
        private TbImageView lRG;
        private TextView lRH;
        private ProgressBar lRI;
        private TextView lRJ;
        private View lRK;
        private View.OnClickListener mOnItemClickListener;

        private C0831a(View view) {
            super(view);
            this.lRK = view.findViewById(R.id.bg_ad_card_gift);
            this.lRG = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lRF = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lRH = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lRI = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lRJ = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lRG.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lRG.setConrers(5);
            this.lRG.setDefaultBgResource(R.color.cp_atp_a);
            this.lRG.setDrawCorner(true);
            this.lRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0831a.this.mOnItemClickListener != null) {
                        C0831a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lRI.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lRJ.setText(bVar.card_name);
                this.lRG.startLoad(bVar.card_logo, 38, false);
                this.lRF.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lRI.setProgress(i);
                if (bVar.dmQ()) {
                    this.lRH.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.lRH, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.lRH, R.drawable.btn_pb_ad_card_gift_get);
                    this.lRH.setClickable(true);
                } else if (bVar.dmR()) {
                    this.lRH.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.lRH, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.lRH, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lRH.setClickable(true);
                } else {
                    this.lRH.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.lRH, R.color.CAM_X0109);
                    this.lRH.setBackgroundResource(R.drawable.transparent_bg);
                    this.lRH.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.lRK, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.lRJ, R.color.CAM_X0105);
            ap.setViewTextColor(this.lRF, R.color.CAM_X0107);
            this.lRI.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
