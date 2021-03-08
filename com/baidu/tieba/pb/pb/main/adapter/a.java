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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
/* loaded from: classes2.dex */
public class a extends l<com.baidu.tieba.pb.data.a, C0841a> {
    private f lQk;
    private b mdA;
    private com.baidu.tieba.pb.data.a mdB;
    private View.OnClickListener mdC;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.mdC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mdB != null && a.this.mdB.lMc != null && !com.baidu.tbadk.util.l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bh.checkUpIsLogin(a.this.lPo.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.mdB);
                    if (a.this.mdB.lMc.dln()) {
                        bf.bsY().a((TbPageContext<?>) a.this.lPo.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.mdB.lMc.dlm()) {
                        a.this.mdA.c(a.this.mdB);
                    }
                }
            }
        };
        this.mdA = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cB */
    public C0841a e(ViewGroup viewGroup) {
        C0841a c0841a = new C0841a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0841a.setOnClickListener(this.mdC);
        return c0841a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0841a c0841a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0841a);
        if (aVar != null && c0841a != null) {
            aVar.locate = i + 1;
            this.mdB = aVar;
            a(aVar);
            c0841a.a(this.mContext, aVar.lMc);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.lMc.lMd + "";
        com.baidu.tieba.s.c.dMH().a(this.lPo.getUniqueId(), com.baidu.tieba.s.a.a(this.lQk.dlp().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.lQk.dlp(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dMH().b(this.lPo.getUniqueId(), com.baidu.tieba.s.a.a(this.lQk.dlp(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.lMc.lMd + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.mdA != null) {
            this.mdA.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.lQk = fVar;
        if (this.mdA != null) {
            this.mdA.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0841a extends TypeAdapter.ViewHolder {
        private View.OnClickListener mOnItemClickListener;
        private TextView mdE;
        private TbImageView mdF;
        private TextView mdG;
        private ProgressBar mdH;
        private TextView mdI;
        private View mdJ;

        private C0841a(View view) {
            super(view);
            this.mdJ = view.findViewById(R.id.bg_ad_card_gift);
            this.mdF = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.mdE = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.mdG = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.mdH = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.mdI = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.mdF.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.mdF.setConrers(5);
            this.mdF.setDefaultBgResource(R.color.cp_atp_a);
            this.mdF.setDrawCorner(true);
            this.mdG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0841a.this.mOnItemClickListener != null) {
                        C0841a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.mdH.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.mdI.setText(bVar.card_name);
                this.mdF.startLoad(bVar.card_logo, 38, false);
                this.mdE.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.mdH.setProgress(i);
                if (bVar.dlm()) {
                    this.mdG.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.mdG, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.mdG, R.drawable.btn_pb_ad_card_gift_get);
                    this.mdG.setClickable(true);
                } else if (bVar.dln()) {
                    this.mdG.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.mdG, R.color.CAM_X0101);
                    ap.setBackgroundResource(this.mdG, R.drawable.btn_pb_ad_card_gift_watch);
                    this.mdG.setClickable(true);
                } else {
                    this.mdG.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.mdG, R.color.CAM_X0109);
                    this.mdG.setBackgroundResource(R.drawable.transparent_bg);
                    this.mdG.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.mdJ, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.mdI, R.color.CAM_X0105);
            ap.setViewTextColor(this.mdE, R.color.CAM_X0107);
            this.mdH.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
