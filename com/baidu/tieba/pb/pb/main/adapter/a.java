package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
/* loaded from: classes16.dex */
public class a extends o<com.baidu.tieba.pb.data.a, C0768a> {
    private f kAn;
    private b kNf;
    private com.baidu.tieba.pb.data.a kNg;
    private View.OnClickListener kNh;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kNh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kNg != null && a.this.kNg.kwC != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.kzA.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.kNg);
                    if (a.this.kNg.kwC.cVk()) {
                        be.bju().a((TbPageContext<?>) a.this.kzA.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.kNg.kwC.cVj()) {
                        a.this.kNf.c(a.this.kNg);
                    }
                }
            }
        };
        this.kNf = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cl */
    public C0768a b(ViewGroup viewGroup) {
        C0768a c0768a = new C0768a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0768a.setOnClickListener(this.kNh);
        return c0768a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0768a c0768a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0768a);
        if (aVar != null && c0768a != null) {
            aVar.locate = i + 1;
            this.kNg = aVar;
            a(aVar);
            c0768a.a(this.mContext, aVar.kwC);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.kwC.kwD + "";
        com.baidu.tieba.s.c.dvJ().a(this.kzA.getUniqueId(), com.baidu.tieba.s.a.a(this.kAn.cVm().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.kAn.cVm(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dvJ().b(this.kzA.getUniqueId(), com.baidu.tieba.s.a.a(this.kAn.cVm(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.kwC.kwD + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.kNf != null) {
            this.kNf.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.kAn = fVar;
        if (this.kNf != null) {
            this.kNf.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0768a extends af.a {
        private TextView kNj;
        private TbImageView kNk;
        private TextView kNl;
        private ProgressBar kNm;
        private TextView kNn;
        private View kNo;
        private View.OnClickListener mOnItemClickListener;

        private C0768a(View view) {
            super(view);
            this.kNo = view.findViewById(R.id.bg_ad_card_gift);
            this.kNk = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.kNj = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.kNl = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.kNm = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.kNn = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.kNk.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.kNk.setConrers(5);
            this.kNk.setDefaultBgResource(R.color.cp_atp_a);
            this.kNk.setDrawCorner(true);
            this.kNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0768a.this.mOnItemClickListener != null) {
                        C0768a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.kNm.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.kNn.setText(bVar.card_name);
                this.kNk.startLoad(bVar.card_logo, 38, false);
                this.kNj.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.kNm.setProgress(i);
                if (bVar.cVj()) {
                    this.kNl.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.kNl, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.kNl, R.drawable.btn_pb_ad_card_gift_get);
                    this.kNl.setClickable(true);
                } else if (bVar.cVk()) {
                    this.kNl.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.kNl, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.kNl, R.drawable.btn_pb_ad_card_gift_watch);
                    this.kNl.setClickable(true);
                } else {
                    this.kNl.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.kNl, R.color.cp_cont_d);
                    this.kNl.setBackgroundResource(R.drawable.transparent_bg);
                    this.kNl.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.kNo, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.kNn, R.color.cp_cont_b);
            ap.setViewTextColor(this.kNj, R.color.cp_cont_j);
            this.kNm.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
