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
public class a extends l<com.baidu.tieba.pb.data.a, C0635a> {
    private b jCb;
    private com.baidu.tieba.pb.data.a jCc;
    private View.OnClickListener jCd;
    private e jqG;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.jCd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jCc != null && a.this.jCc.jno != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.jpW.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.jCc);
                    if (a.this.jCc.jno.cvo()) {
                        ba.aOV().a((TbPageContext<?>) a.this.jpW.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.jCc.jno.cvn()) {
                        a.this.jCb.c(a.this.jCc);
                    }
                }
            }
        };
        this.jCb = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
    public C0635a b(ViewGroup viewGroup) {
        C0635a c0635a = new C0635a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0635a.setOnClickListener(this.jCd);
        return c0635a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0635a c0635a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0635a);
        if (aVar != null && c0635a != null) {
            aVar.locate = i + 1;
            this.jCc = aVar;
            a(aVar);
            c0635a.a(this.mContext, aVar.jno);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.jno.jnp + "";
        com.baidu.tieba.s.c.cVo().a(this.jpW.getUniqueId(), com.baidu.tieba.s.a.a(this.jqG.cvr().getTid(), str, "", null), com.baidu.tieba.s.a.a(this.jqG.cvr(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.cVo().b(this.jpW.getUniqueId(), com.baidu.tieba.s.a.a(this.jqG.cvr(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.jno.jnp + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.jCb != null) {
            this.jCb.onDestroy();
        }
    }

    public void setData(e eVar) {
        this.jqG = eVar;
        if (this.jCb != null) {
            this.jCb.setData(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0635a extends y.a {
        private TextView jCf;
        private TbImageView jCg;
        private TextView jCh;
        private ProgressBar jCi;
        private TextView jCj;
        private View jCk;
        private View.OnClickListener mOnItemClickListener;

        private C0635a(View view) {
            super(view);
            this.jCk = view.findViewById(R.id.bg_ad_card_gift);
            this.jCg = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.jCf = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.jCh = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.jCi = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.jCj = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.jCg.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.jCg.setConrers(5);
            this.jCg.setDefaultBgResource(R.color.cp_atp_a);
            this.jCg.setDrawCorner(true);
            this.jCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0635a.this.mOnItemClickListener != null) {
                        C0635a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.jCi.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.jCj.setText(bVar.card_name);
                this.jCg.startLoad(bVar.card_logo, 38, false);
                this.jCf.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.jCi.setProgress(i);
                if (bVar.cvn()) {
                    this.jCh.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.jCh, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jCh, R.drawable.btn_pb_ad_card_gift_get);
                    this.jCh.setClickable(true);
                } else if (bVar.cvo()) {
                    this.jCh.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.jCh, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.jCh, R.drawable.btn_pb_ad_card_gift_watch);
                    this.jCh.setClickable(true);
                } else {
                    this.jCh.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.jCh, (int) R.color.cp_cont_d);
                    this.jCh.setBackgroundResource(R.drawable.transparent_bg);
                    this.jCh.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.jCk, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.jCj, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jCf, (int) R.color.cp_cont_j);
            this.jCi.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
