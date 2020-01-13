package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.m;
/* loaded from: classes7.dex */
public class a extends m<com.baidu.tieba.pb.data.b, C0568a> {
    private f iCZ;
    private b iOE;
    private com.baidu.tieba.pb.data.b iOF;
    private View.OnClickListener iOG;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.iOG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iOF != null && a.this.iOF.izy != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bc.checkUpIsLogin(a.this.iCe.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.iOF);
                    if (a.this.iOF.izy.ciP()) {
                        ba.aEt().a((TbPageContext<?>) a.this.iCe.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.iOF.izy.ciO()) {
                        a.this.iOE.c(a.this.iOF);
                    }
                }
            }
        };
        this.iOE = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public C0568a b(ViewGroup viewGroup) {
        C0568a c0568a = new C0568a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0568a.setOnClickListener(this.iOG);
        return c0568a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.b bVar, C0568a c0568a) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tieba.pb.data.b) c0568a);
        if (bVar != null && c0568a != null) {
            bVar.locate = i + 1;
            this.iOF = bVar;
            a(bVar);
            c0568a.a(this.mContext, bVar.izy);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.b bVar) {
        String str = bVar.izy.izz + "";
        com.baidu.tieba.r.c.cIs().a(this.iCe.getUniqueId(), com.baidu.tieba.r.a.a(this.iCZ.ciS().getTid(), str, "", null), com.baidu.tieba.r.a.a(this.iCZ.ciS(), PageStayDurationConstants.PageName.PB, "common_exp", bVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.b bVar) {
        com.baidu.tieba.r.c.cIs().b(this.iCe.getUniqueId(), com.baidu.tieba.r.a.a(this.iCZ.ciS(), PageStayDurationConstants.PageName.PB, "common_click", 1, bVar.locate, true, bVar.izy.izz + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.iOE != null) {
            this.iOE.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.iCZ = fVar;
        if (this.iOE != null) {
            this.iOE.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0568a extends v.a {
        private TextView iOI;
        private TbImageView iOJ;
        private TextView iOK;
        private ProgressBar iOL;
        private TextView iOM;
        private View iON;
        private View.OnClickListener mOnItemClickListener;

        private C0568a(View view) {
            super(view);
            this.iON = view.findViewById(R.id.bg_ad_card_gift);
            this.iOJ = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.iOI = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.iOK = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.iOL = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.iOM = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.iOJ.setRadius(l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.iOJ.setConrers(5);
            this.iOJ.setDefaultBgResource(R.color.cp_atp_a);
            this.iOJ.setDrawCorner(true);
            this.iOK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0568a.this.mOnItemClickListener != null) {
                        C0568a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.iOL.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.c cVar) {
            int i = 100;
            if (cVar != null) {
                this.iOM.setText(cVar.card_name);
                this.iOJ.startLoad(cVar.card_logo, 38, false);
                this.iOI.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, cVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(cVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.iOL.setProgress(i);
                if (cVar.ciO()) {
                    this.iOK.setText(R.string.pb_ad_card_gift_get);
                    am.setViewTextColor(this.iOK, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iOK, R.drawable.btn_pb_ad_card_gift_get);
                    this.iOK.setClickable(true);
                } else if (cVar.ciP()) {
                    this.iOK.setText(R.string.pb_ad_card_gift_watch_btn);
                    am.setViewTextColor(this.iOK, (int) R.color.cp_cont_a);
                    am.setBackgroundResource(this.iOK, R.drawable.btn_pb_ad_card_gift_watch);
                    this.iOK.setClickable(true);
                } else {
                    this.iOK.setText(R.string.pb_ad_card_gift_over_btn);
                    am.setViewTextColor(this.iOK, (int) R.color.cp_cont_d);
                    this.iOK.setBackgroundResource(R.drawable.transparent_bg);
                    this.iOK.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            am.setBackgroundResource(this.iON, R.drawable.bg_pb_ad_card_gift);
            am.setViewTextColor(this.iOM, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iOI, (int) R.color.cp_cont_j);
            this.iOL.setProgressDrawable(am.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
