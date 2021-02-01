package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes2.dex */
public class a extends l<com.baidu.tieba.pb.data.a, C0834a> {
    private f lNT;
    private b mbj;
    private com.baidu.tieba.pb.data.a mbk;
    private View.OnClickListener mbl;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.mbl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mbk != null && a.this.mbk.lJM != null && !com.baidu.tbadk.util.l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bh.checkUpIsLogin(a.this.lMX.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.mbk);
                    if (a.this.mbk.lJM.dkX()) {
                        bf.bsV().a((TbPageContext<?>) a.this.lMX.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.mbk.lJM.dkW()) {
                        a.this.mbj.c(a.this.mbk);
                    }
                }
            }
        };
        this.mbj = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cC */
    public C0834a e(ViewGroup viewGroup) {
        C0834a c0834a = new C0834a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0834a.setOnClickListener(this.mbl);
        return c0834a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0834a c0834a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0834a);
        if (aVar != null && c0834a != null) {
            aVar.locate = i + 1;
            this.mbk = aVar;
            a(aVar);
            c0834a.a(this.mContext, aVar.lJM);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lJM.lJN + "";
        com.baidu.tieba.s.c.dMr().a(this.lMX.getUniqueId(), com.baidu.tieba.s.a.a(this.lNT.dkZ().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lNT.dkZ(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dMr().b(this.lMX.getUniqueId(), com.baidu.tieba.s.a.a(this.lNT.dkZ(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lJM.lJN + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.mbj != null) {
            this.mbj.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lNT = fVar;
        if (this.mbj != null) {
            this.mbj.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0834a extends TypeAdapter.ViewHolder {
        private View.OnClickListener mOnItemClickListener;
        private TextView mbn;
        private TbImageView mbo;
        private TextView mbp;
        private ProgressBar mbq;
        private TextView mbr;
        private View mbs;

        private C0834a(View view) {
            super(view);
            this.mbs = view.findViewById(R.id.bg_ad_card_gift);
            this.mbo = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.mbn = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.mbp = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.mbq = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.mbr = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.mbo.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.mbo.setConrers(5);
            this.mbo.setDefaultBgResource(R.color.cp_atp_a);
            this.mbo.setDrawCorner(true);
            this.mbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0834a.this.mOnItemClickListener != null) {
                        C0834a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.mbq.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.mbr.setText(bVar.card_name);
                this.mbo.startLoad(bVar.card_logo, 38, false);
                this.mbn.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.mbq.setProgress(i);
                if (bVar.dkW()) {
                    this.mbp.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.mbp, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.mbp, R.drawable.btn_pb_ad_card_gift_get);
                    this.mbp.setClickable(true);
                } else if (bVar.dkX()) {
                    this.mbp.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.mbp, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.mbp, R.drawable.btn_pb_ad_card_gift_watch);
                    this.mbp.setClickable(true);
                } else {
                    this.mbp.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.mbp, R.color.CAM_X0109);
                    this.mbp.setBackgroundResource(R.drawable.transparent_bg);
                    this.mbp.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.mbs, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.mbr, R.color.CAM_X0105);
            ap.setViewTextColor(this.mbn, R.color.CAM_X0107);
            this.mbq.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
