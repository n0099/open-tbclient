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
/* loaded from: classes21.dex */
public class a extends o<com.baidu.tieba.pb.data.a, C0815a> {
    private b lDK;
    private com.baidu.tieba.pb.data.a lDL;
    private View.OnClickListener lDM;
    private f lqK;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lDM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lDL != null && a.this.lDL.lmX != null && !l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bh.checkUpIsLogin(a.this.lpX.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lDL);
                    if (a.this.lDL.lmX.dhF()) {
                        bf.bqF().a((TbPageContext<?>) a.this.lpX.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lDL.lmX.dhE()) {
                        a.this.lDK.c(a.this.lDL);
                    }
                }
            }
        };
        this.lDK = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cn */
    public C0815a c(ViewGroup viewGroup) {
        C0815a c0815a = new C0815a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0815a.setOnClickListener(this.lDM);
        return c0815a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0815a c0815a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0815a);
        if (aVar != null && c0815a != null) {
            aVar.locate = i + 1;
            this.lDL = aVar;
            a(aVar);
            c0815a.a(this.mContext, aVar.lmX);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lmX.lmY + "";
        com.baidu.tieba.t.c.dIO().a(this.lpX.getUniqueId(), com.baidu.tieba.t.a.a(this.lqK.dhH().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.t.a.a(this.lqK.dhH(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.t.c.dIO().b(this.lpX.getUniqueId(), com.baidu.tieba.t.a.a(this.lqK.dhH(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lmX.lmY + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lDK != null) {
            this.lDK.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lqK = fVar;
        if (this.lDK != null) {
            this.lDK.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0815a extends af.a {
        private TextView lDO;
        private TbImageView lDP;
        private TextView lDQ;
        private ProgressBar lDR;
        private TextView lDS;
        private View lDT;
        private View.OnClickListener mOnItemClickListener;

        private C0815a(View view) {
            super(view);
            this.lDT = view.findViewById(R.id.bg_ad_card_gift);
            this.lDP = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lDO = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lDQ = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lDR = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lDS = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lDP.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lDP.setConrers(5);
            this.lDP.setDefaultBgResource(R.color.cp_atp_a);
            this.lDP.setDrawCorner(true);
            this.lDQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0815a.this.mOnItemClickListener != null) {
                        C0815a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lDR.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lDS.setText(bVar.card_name);
                this.lDP.startLoad(bVar.card_logo, 38, false);
                this.lDO.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lDR.setProgress(i);
                if (bVar.dhE()) {
                    this.lDQ.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.lDQ, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.lDQ, R.drawable.btn_pb_ad_card_gift_get);
                    this.lDQ.setClickable(true);
                } else if (bVar.dhF()) {
                    this.lDQ.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.lDQ, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.lDQ, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lDQ.setClickable(true);
                } else {
                    this.lDQ.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.lDQ, R.color.CAM_X0109);
                    this.lDQ.setBackgroundResource(R.drawable.transparent_bg);
                    this.lDQ.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.lDT, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.lDS, R.color.CAM_X0105);
            ap.setViewTextColor(this.lDO, R.color.CAM_X0107);
            this.lDR.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
