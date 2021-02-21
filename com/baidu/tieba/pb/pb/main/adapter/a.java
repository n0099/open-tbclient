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
public class a extends l<com.baidu.tieba.pb.data.a, C0835a> {
    private f lOi;
    private View.OnClickListener mbA;
    private b mby;
    private com.baidu.tieba.pb.data.a mbz;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.mbA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mbz != null && a.this.mbz.lKa != null && !com.baidu.tbadk.util.l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bh.checkUpIsLogin(a.this.lNm.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.mbz);
                    if (a.this.mbz.lKa.dle()) {
                        bf.bsV().a((TbPageContext<?>) a.this.lNm.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.mbz.lKa.dld()) {
                        a.this.mby.c(a.this.mbz);
                    }
                }
            }
        };
        this.mby = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cC */
    public C0835a e(ViewGroup viewGroup) {
        C0835a c0835a = new C0835a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0835a.setOnClickListener(this.mbA);
        return c0835a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0835a c0835a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0835a);
        if (aVar != null && c0835a != null) {
            aVar.locate = i + 1;
            this.mbz = aVar;
            a(aVar);
            c0835a.a(this.mContext, aVar.lKa);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lKa.lKb + "";
        com.baidu.tieba.s.c.dMz().a(this.lNm.getUniqueId(), com.baidu.tieba.s.a.a(this.lOi.dlg().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lOi.dlg(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dMz().b(this.lNm.getUniqueId(), com.baidu.tieba.s.a.a(this.lOi.dlg(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lKa.lKb + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.mby != null) {
            this.mby.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lOi = fVar;
        if (this.mby != null) {
            this.mby.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0835a extends TypeAdapter.ViewHolder {
        private View.OnClickListener mOnItemClickListener;
        private TextView mbC;
        private TbImageView mbD;
        private TextView mbE;
        private ProgressBar mbF;
        private TextView mbG;
        private View mbH;

        private C0835a(View view) {
            super(view);
            this.mbH = view.findViewById(R.id.bg_ad_card_gift);
            this.mbD = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.mbC = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.mbE = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.mbF = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.mbG = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.mbD.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.mbD.setConrers(5);
            this.mbD.setDefaultBgResource(R.color.cp_atp_a);
            this.mbD.setDrawCorner(true);
            this.mbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0835a.this.mOnItemClickListener != null) {
                        C0835a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.mbF.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.mbG.setText(bVar.card_name);
                this.mbD.startLoad(bVar.card_logo, 38, false);
                this.mbC.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.mbF.setProgress(i);
                if (bVar.dld()) {
                    this.mbE.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.mbE, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.mbE, R.drawable.btn_pb_ad_card_gift_get);
                    this.mbE.setClickable(true);
                } else if (bVar.dle()) {
                    this.mbE.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.mbE, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.mbE, R.drawable.btn_pb_ad_card_gift_watch);
                    this.mbE.setClickable(true);
                } else {
                    this.mbE.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.mbE, R.color.CAM_X0109);
                    this.mbE.setBackgroundResource(R.drawable.transparent_bg);
                    this.mbE.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.mbH, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.mbG, R.color.CAM_X0105);
            ap.setViewTextColor(this.mbC, R.color.CAM_X0107);
            this.mbF.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
