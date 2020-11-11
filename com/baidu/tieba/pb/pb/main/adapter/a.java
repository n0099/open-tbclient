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
public class a extends o<com.baidu.tieba.pb.data.a, C0813a> {
    private b lDs;
    private com.baidu.tieba.pb.data.a lDt;
    private View.OnClickListener lDu;
    private f lqv;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lDu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lDt != null && a.this.lDt.lmH != null && !l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.lpI.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lDt);
                    if (a.this.lDt.lmH.dii()) {
                        be.brr().a((TbPageContext<?>) a.this.lpI.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lDt.lmH.dih()) {
                        a.this.lDs.c(a.this.lDt);
                    }
                }
            }
        };
        this.lDs = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public C0813a c(ViewGroup viewGroup) {
        C0813a c0813a = new C0813a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0813a.setOnClickListener(this.lDu);
        return c0813a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0813a c0813a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0813a);
        if (aVar != null && c0813a != null) {
            aVar.locate = i + 1;
            this.lDt = aVar;
            a(aVar);
            c0813a.a(this.mContext, aVar.lmH);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lmH.lmI + "";
        com.baidu.tieba.s.c.dIX().a(this.lpI.getUniqueId(), com.baidu.tieba.s.a.a(this.lqv.dik().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lqv.dik(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dIX().b(this.lpI.getUniqueId(), com.baidu.tieba.s.a.a(this.lqv.dik(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lmH.lmI + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lDs != null) {
            this.lDs.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lqv = fVar;
        if (this.lDs != null) {
            this.lDs.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0813a extends af.a {
        private TextView lDA;
        private View lDB;
        private TextView lDw;
        private TbImageView lDx;
        private TextView lDy;
        private ProgressBar lDz;
        private View.OnClickListener mOnItemClickListener;

        private C0813a(View view) {
            super(view);
            this.lDB = view.findViewById(R.id.bg_ad_card_gift);
            this.lDx = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lDw = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lDy = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lDz = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lDA = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lDx.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lDx.setConrers(5);
            this.lDx.setDefaultBgResource(R.color.cp_atp_a);
            this.lDx.setDrawCorner(true);
            this.lDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0813a.this.mOnItemClickListener != null) {
                        C0813a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lDz.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lDA.setText(bVar.card_name);
                this.lDx.startLoad(bVar.card_logo, 38, false);
                this.lDw.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lDz.setProgress(i);
                if (bVar.dih()) {
                    this.lDy.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.lDy, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.lDy, R.drawable.btn_pb_ad_card_gift_get);
                    this.lDy.setClickable(true);
                } else if (bVar.dii()) {
                    this.lDy.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.lDy, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.lDy, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lDy.setClickable(true);
                } else {
                    this.lDy.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.lDy, R.color.cp_cont_d);
                    this.lDy.setBackgroundResource(R.drawable.transparent_bg);
                    this.lDy.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.lDB, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.lDA, R.color.cp_cont_b);
            ap.setViewTextColor(this.lDw, R.color.cp_cont_j);
            this.lDz.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
