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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes2.dex */
public class a extends l<com.baidu.tieba.pb.data.a, C0815a> {
    private f lJI;
    private b lWP;
    private com.baidu.tieba.pb.data.a lWQ;
    private View.OnClickListener lWR;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lWR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lWQ != null && a.this.lWQ.lFF != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.lIO.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lWQ);
                    if (a.this.lWQ.lFF.dmC()) {
                        be.bwu().a((TbPageContext<?>) a.this.lIO.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lWQ.lFF.dmB()) {
                        a.this.lWP.c(a.this.lWQ);
                    }
                }
            }
        };
        this.lWP = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cC */
    public C0815a e(ViewGroup viewGroup) {
        C0815a c0815a = new C0815a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0815a.setOnClickListener(this.lWR);
        return c0815a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0815a c0815a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0815a);
        if (aVar != null && c0815a != null) {
            aVar.locate = i + 1;
            this.lWQ = aVar;
            a(aVar);
            c0815a.a(this.mContext, aVar.lFF);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lFF.lFG + "";
        com.baidu.tieba.s.c.dNX().a(this.lIO.getUniqueId(), com.baidu.tieba.s.a.a(this.lJI.dmE().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lJI.dmE(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dNX().b(this.lIO.getUniqueId(), com.baidu.tieba.s.a.a(this.lJI.dmE(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lFF.lFG + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lWP != null) {
            this.lWP.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lJI = fVar;
        if (this.lWP != null) {
            this.lWP.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0815a extends TypeAdapter.ViewHolder {
        private TextView lWT;
        private TbImageView lWU;
        private TextView lWV;
        private ProgressBar lWW;
        private TextView lWX;
        private View lWY;
        private View.OnClickListener mOnItemClickListener;

        private C0815a(View view) {
            super(view);
            this.lWY = view.findViewById(R.id.bg_ad_card_gift);
            this.lWU = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lWT = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lWV = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lWW = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lWX = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lWU.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lWU.setConrers(5);
            this.lWU.setDefaultBgResource(R.color.cp_atp_a);
            this.lWU.setDrawCorner(true);
            this.lWV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0815a.this.mOnItemClickListener != null) {
                        C0815a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lWW.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lWX.setText(bVar.card_name);
                this.lWU.startLoad(bVar.card_logo, 38, false);
                this.lWT.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lWW.setProgress(i);
                if (bVar.dmB()) {
                    this.lWV.setText(R.string.pb_ad_card_gift_get);
                    ao.setViewTextColor(this.lWV, R.color.CAM_X0101);
                    ao.setBackgroundResource(this.lWV, R.drawable.btn_pb_ad_card_gift_get);
                    this.lWV.setClickable(true);
                } else if (bVar.dmC()) {
                    this.lWV.setText(R.string.pb_ad_card_gift_watch_btn);
                    ao.setViewTextColor(this.lWV, R.color.CAM_X0101);
                    ao.setBackgroundResource(this.lWV, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lWV.setClickable(true);
                } else {
                    this.lWV.setText(R.string.pb_ad_card_gift_over_btn);
                    ao.setViewTextColor(this.lWV, R.color.CAM_X0109);
                    this.lWV.setBackgroundResource(R.drawable.transparent_bg);
                    this.lWV.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ao.setBackgroundResource(this.lWY, R.drawable.bg_pb_ad_card_gift);
            ao.setViewTextColor(this.lWX, R.color.CAM_X0105);
            ao.setViewTextColor(this.lWT, R.color.CAM_X0107);
            this.lWW.setProgressDrawable(ao.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
