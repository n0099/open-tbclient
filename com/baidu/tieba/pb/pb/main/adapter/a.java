package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes9.dex */
public class a extends l<com.baidu.tieba.pb.data.a, C0614a> {
    private b jBX;
    private com.baidu.tieba.pb.data.a jBY;
    private View.OnClickListener jBZ;
    private e jqC;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.jBZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jBY != null && a.this.jBY.jnk != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.jpS.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.jBY);
                    if (a.this.jBY.jnk.cvr()) {
                        ba.aOY().a((TbPageContext<?>) a.this.jpS.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.jBY.jnk.cvq()) {
                        a.this.jBX.c(a.this.jBY);
                    }
                }
            }
        };
        this.jBX = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
    public C0614a b(ViewGroup viewGroup) {
        C0614a c0614a = new C0614a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0614a.setOnClickListener(this.jBZ);
        return c0614a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0614a c0614a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0614a);
        if (aVar != null && c0614a != null) {
            aVar.locate = i + 1;
            this.jBY = aVar;
            a(aVar);
            c0614a.a(this.mContext, aVar.jnk);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.jnk.jnl + "";
        com.baidu.tieba.s.c.cVr().a(this.jpS.getUniqueId(), com.baidu.tieba.s.a.a(this.jqC.cvu().getTid(), str, "", null), com.baidu.tieba.s.a.a(this.jqC.cvu(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.cVr().b(this.jpS.getUniqueId(), com.baidu.tieba.s.a.a(this.jqC.cvu(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.jnk.jnl + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.jBX != null) {
            this.jBX.onDestroy();
        }
    }

    public void setData(e eVar) {
        this.jqC = eVar;
        if (this.jBX != null) {
            this.jBX.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0614a extends y.a {
        private TextView jCb;
        private TbImageView jCc;
        private TextView jCd;
        private ProgressBar jCe;
        private TextView jCf;
        private View jCg;
        private View.OnClickListener mOnItemClickListener;

        private C0614a(View view) {
            super(view);
            this.jCg = view.findViewById(R.id.bg_ad_card_gift);
            this.jCc = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.jCb = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.jCd = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.jCe = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.jCf = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.jCc.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.jCc.setConrers(5);
            this.jCc.setDefaultBgResource(R.color.cp_atp_a);
            this.jCc.setDrawCorner(true);
            this.jCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0614a.this.mOnItemClickListener != null) {
                        C0614a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.jCe.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.jCf.setText(bVar.card_name);
                this.jCc.startLoad(bVar.card_logo, 38, false);
                this.jCb.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.jCe.setProgress(i);
                if (bVar.cvq()) {
                    this.jCd.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.jCd, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jCd, R.drawable.btn_pb_ad_card_gift_get);
                    this.jCd.setClickable(true);
                } else if (bVar.cvr()) {
                    this.jCd.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.jCd, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jCd, R.drawable.btn_pb_ad_card_gift_watch);
                    this.jCd.setClickable(true);
                } else {
                    this.jCd.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.jCd, (int) R.color.cp_cont_d);
                    this.jCd.setBackgroundResource(R.drawable.transparent_bg);
                    this.jCd.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.jCg, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.jCf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jCb, (int) R.color.cp_cont_j);
            this.jCe.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
