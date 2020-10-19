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
public class a extends o<com.baidu.tieba.pb.data.a, C0783a> {
    private f kXV;
    private b lkS;
    private com.baidu.tieba.pb.data.a lkT;
    private View.OnClickListener lkU;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lkU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lkT != null && a.this.lkT.kUm != null && !l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.kXi.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lkT);
                    if (a.this.lkT.kUm.dcy()) {
                        be.bmY().a((TbPageContext<?>) a.this.kXi.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lkT.kUm.dcx()) {
                        a.this.lkS.c(a.this.lkT);
                    }
                }
            }
        };
        this.lkS = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: co */
    public C0783a c(ViewGroup viewGroup) {
        C0783a c0783a = new C0783a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0783a.setOnClickListener(this.lkU);
        return c0783a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0783a c0783a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0783a);
        if (aVar != null && c0783a != null) {
            aVar.locate = i + 1;
            this.lkT = aVar;
            a(aVar);
            c0783a.a(this.mContext, aVar.kUm);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.kUm.kUn + "";
        com.baidu.tieba.s.c.dDn().a(this.kXi.getUniqueId(), com.baidu.tieba.s.a.a(this.kXV.dcA().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.kXV.dcA(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dDn().b(this.kXi.getUniqueId(), com.baidu.tieba.s.a.a(this.kXV.dcA(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.kUm.kUn + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lkS != null) {
            this.lkS.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.kXV = fVar;
        if (this.lkS != null) {
            this.lkS.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0783a extends af.a {
        private TextView lkW;
        private TbImageView lkX;
        private TextView lkY;
        private ProgressBar lkZ;
        private TextView lla;
        private View llb;
        private View.OnClickListener mOnItemClickListener;

        private C0783a(View view) {
            super(view);
            this.llb = view.findViewById(R.id.bg_ad_card_gift);
            this.lkX = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lkW = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lkY = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lkZ = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lla = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lkX.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lkX.setConrers(5);
            this.lkX.setDefaultBgResource(R.color.cp_atp_a);
            this.lkX.setDrawCorner(true);
            this.lkY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0783a.this.mOnItemClickListener != null) {
                        C0783a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lkZ.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lla.setText(bVar.card_name);
                this.lkX.startLoad(bVar.card_logo, 38, false);
                this.lkW.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lkZ.setProgress(i);
                if (bVar.dcx()) {
                    this.lkY.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.lkY, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.lkY, R.drawable.btn_pb_ad_card_gift_get);
                    this.lkY.setClickable(true);
                } else if (bVar.dcy()) {
                    this.lkY.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.lkY, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.lkY, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lkY.setClickable(true);
                } else {
                    this.lkY.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.lkY, R.color.cp_cont_d);
                    this.lkY.setBackgroundResource(R.drawable.transparent_bg);
                    this.lkY.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.llb, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.lla, R.color.cp_cont_b);
            ap.setViewTextColor(this.lkW, R.color.cp_cont_j);
            this.lkZ.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
