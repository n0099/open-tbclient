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
/* loaded from: classes21.dex */
public class a extends o<com.baidu.tieba.pb.data.a, C0765a> {
    private f kIK;
    private b kVF;
    private com.baidu.tieba.pb.data.a kVG;
    private View.OnClickListener kVH;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.kVH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kVG != null && a.this.kVG.kFb != null && !l.isFastDoubleClick()) {
                    if (!TbadkCoreApplication.isLogin()) {
                        bg.checkUpIsLogin(a.this.kHX.getPageContext().getPageActivity());
                        return;
                    }
                    a.this.b(a.this.kVG);
                    if (a.this.kVG.kFb.cYP()) {
                        be.bkp().a((TbPageContext<?>) a.this.kHX.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    } else if (a.this.kVG.kFb.cYO()) {
                        a.this.kVF.c(a.this.kVG);
                    }
                }
            }
        };
        this.kVF = new b(pbFragment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cm */
    public C0765a c(ViewGroup viewGroup) {
        C0765a c0765a = new C0765a(LayoutInflater.from(this.mContext).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false));
        c0765a.setOnClickListener(this.kVH);
        return c0765a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.a aVar, C0765a c0765a) {
        super.a(i, view, viewGroup, (ViewGroup) aVar, (com.baidu.tieba.pb.data.a) c0765a);
        if (aVar != null && c0765a != null) {
            aVar.locate = i + 1;
            this.kVG = aVar;
            a(aVar);
            c0765a.a(this.mContext, aVar.kFb);
        }
        return view;
    }

    private void a(com.baidu.tieba.pb.data.a aVar) {
        String str = aVar.kFb.kFc + "";
        com.baidu.tieba.s.c.dzC().a(this.kHX.getUniqueId(), com.baidu.tieba.s.a.a(this.kIK.cYR().getTid(), str, "", (BaijiahaoData) null), com.baidu.tieba.s.a.a(this.kIK.cYR(), PageStayDurationConstants.PageName.PB, "common_exp", aVar.locate, true, str, "", 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.pb.data.a aVar) {
        com.baidu.tieba.s.c.dzC().b(this.kHX.getUniqueId(), com.baidu.tieba.s.a.a(this.kIK.cYR(), PageStayDurationConstants.PageName.PB, "common_click", 1, aVar.locate, true, aVar.kFb.kFc + "", (String) null, 18));
    }

    public void onDestroy() {
        if (this.kVF != null) {
            this.kVF.onDestroy();
        }
    }

    public void setData(f fVar) {
        this.kIK = fVar;
        if (this.kVF != null) {
            this.kVF.setData(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0765a extends af.a {
        private TextView kVJ;
        private TbImageView kVK;
        private TextView kVL;
        private ProgressBar kVM;
        private TextView kVN;
        private View kVO;
        private View.OnClickListener mOnItemClickListener;

        private C0765a(View view) {
            super(view);
            this.kVO = view.findViewById(R.id.bg_ad_card_gift);
            this.kVK = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.kVJ = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.kVL = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.kVM = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.kVN = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.kVK.setRadius(com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds20));
            this.kVK.setConrers(5);
            this.kVK.setDefaultBgResource(R.color.cp_atp_a);
            this.kVK.setDrawCorner(true);
            this.kVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0765a.this.mOnItemClickListener != null) {
                        C0765a.this.mOnItemClickListener.onClick(view2);
                    }
                }
            });
            this.kVM.setMax(100);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.mOnItemClickListener = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, com.baidu.tieba.pb.data.b bVar) {
            int i = 100;
            if (bVar != null) {
                this.kVN.setText(bVar.card_name);
                this.kVK.startLoad(bVar.card_logo, 38, false);
                this.kVJ.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.card_pro) + "%");
                int i2 = com.baidu.adp.lib.f.b.toInt(bVar.card_pro, 0);
                if (i2 <= 100) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.kVM.setProgress(i);
                if (bVar.cYO()) {
                    this.kVL.setText(R.string.pb_ad_card_gift_get);
                    ap.setViewTextColor(this.kVL, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.kVL, R.drawable.btn_pb_ad_card_gift_get);
                    this.kVL.setClickable(true);
                } else if (bVar.cYP()) {
                    this.kVL.setText(R.string.pb_ad_card_gift_watch_btn);
                    ap.setViewTextColor(this.kVL, R.color.cp_cont_a);
                    ap.setBackgroundResource(this.kVL, R.drawable.btn_pb_ad_card_gift_watch);
                    this.kVL.setClickable(true);
                } else {
                    this.kVL.setText(R.string.pb_ad_card_gift_over_btn);
                    ap.setViewTextColor(this.kVL, R.color.cp_cont_d);
                    this.kVL.setBackgroundResource(R.drawable.transparent_bg);
                    this.kVL.setClickable(false);
                }
                onChangeSkinType();
            }
        }

        private void onChangeSkinType() {
            ap.setBackgroundResource(this.kVO, R.drawable.bg_pb_ad_card_gift);
            ap.setViewTextColor(this.kVN, R.color.cp_cont_b);
            ap.setViewTextColor(this.kVJ, R.color.cp_cont_j);
            this.kVM.setProgressDrawable(ap.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }
    }
}
