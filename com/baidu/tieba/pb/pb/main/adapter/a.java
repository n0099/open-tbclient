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
public class a extends l<com.baidu.tieba.pb.data.a, C0848a> {
    private f lJH;
    private b lWO;
    private com.baidu.tieba.pb.data.a lWP;
    private View.OnClickListener lWQ;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lWQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lWP != null && a.this.lWP.lFE != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.lIN.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lWP);
                    if (a.this.lWP.lFE.dmD()) {
                        be.bwv().a((TbPageContext<?>) a.this.lIN.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lWP.lFE.dmC()) {
                        a.this.lWO.c(a.this.lWP);
                    }
                }
            }
        };
        this.lWO = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cC */
    public C0848a e(ViewGroup viewGroup) {
        C0848a c0848a = new C0848a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0848a.setOnClickListener(this.lWQ);
        return c0848a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0848a c0848a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0848a);
        if (aVar != null && c0848a != null) {
            aVar.locate = i + 1;
            this.lWP = aVar;
            a(aVar);
            c0848a.a(this.mContext, aVar.lFE);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lFE.lFF + "";
        com.baidu.tieba.s.c.dNY().a(this.lIN.getUniqueId(), com.baidu.tieba.s.a.a(this.lJH.dmF().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lJH.dmF(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dNY().b(this.lIN.getUniqueId(), com.baidu.tieba.s.a.a(this.lJH.dmF(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lFE.lFF + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lWO != null) {
            this.lWO.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lJH = fVar;
        if (this.lWO != null) {
            this.lWO.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0848a extends TypeAdapter.ViewHolder {
        private TextView lWS;
        private TbImageView lWT;
        private TextView lWU;
        private ProgressBar lWV;
        private TextView lWW;
        private View lWX;
        private View.OnClickListener mOnItemClickListener;

        private C0848a(View view) {
            super(view);
            this.lWX = view.findViewById(R.id.bg_ad_card_gift);
            this.lWT = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lWS = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lWU = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lWV = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lWW = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lWT.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lWT.setConrers(5);
            this.lWT.setDefaultBgResource(R.color.cp_atp_a);
            this.lWT.setDrawCorner(true);
            this.lWU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0848a.this.mOnItemClickListener != null) {
                        C0848a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lWV.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lWW.setText(bVar.card_name);
                this.lWT.startLoad(bVar.card_logo, 38, false);
                this.lWS.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lWV.setProgress(i);
                if (bVar.dmC()) {
                    this.lWU.setText(R.string.pb_ad_card_gift_get);
                    ao.setViewTextColor(this.lWU, R.color.CAM_X0101);
                    ao.setBackgroundResource(this.lWU, R.drawable.btn_pb_ad_card_gift_get);
                    this.lWU.setClickable(true);
                } else if (bVar.dmD()) {
                    this.lWU.setText(R.string.pb_ad_card_gift_watch_btn);
                    ao.setViewTextColor(this.lWU, R.color.CAM_X0101);
                    ao.setBackgroundResource(this.lWU, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lWU.setClickable(true);
                } else {
                    this.lWU.setText(R.string.pb_ad_card_gift_over_btn);
                    ao.setViewTextColor(this.lWU, R.color.CAM_X0109);
                    this.lWU.setBackgroundResource(R.drawable.transparent_bg);
                    this.lWU.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ao.setBackgroundResource(this.lWX, R.drawable.bg_pb_ad_card_gift);
            ao.setViewTextColor(this.lWW, R.color.CAM_X0105);
            ao.setViewTextColor(this.lWS, R.color.CAM_X0107);
            this.lWV.setProgressDrawable(ao.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
