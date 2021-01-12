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
public class a extends l<com.baidu.tieba.pb.data.a, C0831a> {
    private f lFd;
    private b lSk;
    private com.baidu.tieba.pb.data.a lSl;
    private View.OnClickListener lSm;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.lSm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lSl != null && a.this.lSl.lAZ != null && !k.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.lEi.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.lSl);
                    if (a.this.lSl.lAZ.diL()) {
                        be.bsB().a((TbPageContext<?>) a.this.lEi.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.lSl.lAZ.diK()) {
                        a.this.lSk.c(a.this.lSl);
                    }
                }
            }
        };
        this.lSk = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cC */
    public C0831a e(ViewGroup viewGroup) {
        C0831a c0831a = new C0831a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0831a.setOnClickListener(this.lSm);
        return c0831a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0831a c0831a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0831a);
        if (aVar != null && c0831a != null) {
            aVar.locate = i + 1;
            this.lSl = aVar;
            a(aVar);
            c0831a.a(this.mContext, aVar.lAZ);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lAZ.lBa + "";
        com.baidu.tieba.s.c.dKg().a(this.lEi.getUniqueId(), com.baidu.tieba.s.a.a(this.lFd.diN().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lFd.diN(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dKg().b(this.lEi.getUniqueId(), com.baidu.tieba.s.a.a(this.lFd.diN(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lAZ.lBa + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.lSk != null) {
            this.lSk.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lFd = fVar;
        if (this.lSk != null) {
            this.lSk.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0831a extends TypeAdapter.ViewHolder {
        private TextView lSo;
        private TbImageView lSp;
        private TextView lSq;
        private ProgressBar lSr;
        private TextView lSs;
        private View lSt;
        private View.OnClickListener mOnItemClickListener;

        private C0831a(View view) {
            super(view);
            this.lSt = view.findViewById(R.id.bg_ad_card_gift);
            this.lSp = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.lSo = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.lSq = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.lSr = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.lSs = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.lSp.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.lSp.setConrers(5);
            this.lSp.setDefaultBgResource(R.color.cp_atp_a);
            this.lSp.setDrawCorner(true);
            this.lSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0831a.this.mOnItemClickListener != null) {
                        C0831a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.lSr.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.lSs.setText(bVar.card_name);
                this.lSp.startLoad(bVar.card_logo, 38, false);
                this.lSo.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.lSr.setProgress(i);
                if (bVar.diK()) {
                    this.lSq.setText(R.string.pb_ad_card_gift_get);
                    ao.setViewTextColor(this.lSq, R.color.CAM_X0101);
                    ao.setBackgroundResource(this.lSq, R.drawable.btn_pb_ad_card_gift_get);
                    this.lSq.setClickable(true);
                } else if (bVar.diL()) {
                    this.lSq.setText(R.string.pb_ad_card_gift_watch_btn);
                    ao.setViewTextColor(this.lSq, R.color.CAM_X0101);
                    ao.setBackgroundResource(this.lSq, R.drawable.btn_pb_ad_card_gift_watch);
                    this.lSq.setClickable(true);
                } else {
                    this.lSq.setText(R.string.pb_ad_card_gift_over_btn);
                    ao.setViewTextColor(this.lSq, R.color.CAM_X0109);
                    this.lSq.setBackgroundResource(R.drawable.transparent_bg);
                    this.lSq.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ao.setBackgroundResource(this.lSt, R.drawable.bg_pb_ad_card_gift);
            ao.setViewTextColor(this.lSs, R.color.CAM_X0105);
            ao.setViewTextColor(this.lSo, R.color.CAM_X0107);
            this.lSr.setProgressDrawable(ao.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
