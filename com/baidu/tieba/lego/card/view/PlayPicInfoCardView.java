package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.viewpager.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.lego.card.model.PlayPicInfoCard;
import com.baidu.tieba.lego.view.BannerFlowView;
import com.baidu.tieba.lego.view.CommonImageButton;
import com.baidu.tieba.lego.view.a;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    private View elg;
    public BannerFlowView kWh;
    private TextView kWi;
    private LinearLayout kWj;
    private TextView kWk;
    private TextView kWl;
    IndicatorView kWm;
    private TbImageView kWn;
    private RelativeLayout kWo;
    private TextView kWp;
    private TbImageView kWq;
    private TextView kWr;
    private CommonImageButton kWs;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.tbadk.core.view.viewpager.bannerflow.a {
        private PlayPicInfoCard.b kWx;
        private String url;

        public a() {
        }

        public void b(PlayPicInfoCard.b bVar) {
            this.url = bVar.pic;
            this.kWx = bVar;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public Object bvi() {
            return this.kWx;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            ao.setViewTextColor(this.kWl, R.color.CAM_X0101);
        } else {
            a(this.kWl, bVar.kTW, bVar.kTX, R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.elg = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
        this.kWh = (BannerFlowView) z(this.elg, R.id.banner);
        if (this.eSJ.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.kWh.setSwipeControlInterface((SwipeBackLayout.c) this.eSJ.getOrignalPage());
        }
        this.kWh.setDisableParentEvent(false);
        this.kWh.setMaxScrollCountLimit(100);
        this.kWn = (TbImageView) z(this.elg, R.id.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kWh.getLayoutParams();
        layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
        this.kWh.setLayoutParams(layoutParams);
        this.kWk = (TextView) z(this.elg, R.id.title_bottom);
        this.kWj = (LinearLayout) z(this.elg, R.id.ll_bottom);
        this.kWl = (TextView) z(this.elg, R.id.title_on);
        this.kWm = (IndicatorView) z(this.elg, R.id.indicator);
        this.kWi = (TextView) z(this.elg, R.id.title_top);
        this.kWo = (RelativeLayout) z(this.elg, R.id.bottom_relative_layout);
        this.kWp = (TextView) z(this.kWo, R.id.forum_name);
        this.kWq = (TbImageView) z(this.kWo, R.id.icon);
        this.kWr = (TextView) z(this.kWo, R.id.text);
        this.kWs = (CommonImageButton) z(this.kWo, R.id.notice_button);
        return this.elg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(PlayPicInfoCard playPicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eSJ, getRootView());
        ao.setBackgroundResource(this.elg, R.drawable.addresslist_item_bg);
        ao.setViewTextColor(this.kWi, R.color.CAM_X0105);
        ao.setViewTextColor(this.kWk, R.color.CAM_X0105);
        this.kWm.setSelector(ao.getDrawable(R.drawable.dot_live_s));
        this.kWm.setDrawable(ao.getDrawable(R.drawable.dot_live_n));
        ao.setViewTextColor(this.kWp, R.color.CAM_X0111);
        ao.setBackgroundResource(this.kWp, R.drawable.label_bg_tie_n);
        ao.setViewTextColor(this.kWr, R.color.CAM_X0110);
        a((PlayPicInfoCard.b) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final PlayPicInfoCard playPicInfoCard) {
        this.kWi.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kWh.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.kWh.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.kWh.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.kWh.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).desc));
        } else {
            this.kWh.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= 5000) {
            this.kWh.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.kWh.setAutoScrollIntervalTime(5000L);
        }
        this.kWh.setData(d(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.kWl.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.kWk.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                this.kWk.setText(playPicInfoCard.getImageResList().get(0).desc);
                this.kWm.setVisibility(0);
                this.kWm.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.kWj.setVisibility(0);
                this.kWi.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.kWi.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.kWi.setVisibility(0);
                    this.kWj.setVisibility(8);
                } else {
                    this.kWj.setVisibility(0);
                    this.kWk.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                    this.kWk.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.kWi.setVisibility(8);
                    this.kWm.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.kWl.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.kWl.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.kWl.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                }
                this.kWl.setText(playPicInfoCard.getImageResList().get(0).desc);
                a(playPicInfoCard.getImageResList().get(0));
            } else {
                this.kWl.setVisibility(8);
            }
            this.kWi.setVisibility(8);
            this.kWj.setVisibility(8);
        }
        this.kWh.setOnItemClickListener(new b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0775a>() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.view.viewpager.b.a
            /* renamed from: a */
            public void c(a.C0775a c0775a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
                if (aVar.bvi() instanceof PlayPicInfoCard.b) {
                    PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.bvi();
                    if (!TextUtils.isEmpty(bVar.scheme)) {
                        s.crj().mC(true);
                        com.baidu.tieba.lego.e d = com.baidu.tieba.lego.i.d(bVar.statistics, bVar.statTab, playPicInfoCard.getCardType(), playPicInfoCard.getItemId());
                        d.fF("obj_id", bVar.picId);
                        d.fF(TiebaInitialize.Params.OBJ_URL, bVar.scheme);
                        d.bA("obj_locate", PlayPicInfoCardView.this.getStatPosition());
                        d.a(playPicInfoCard);
                        v.h(PlayPicInfoCardView.this.eSJ, bVar.scheme);
                    }
                }
            }
        });
        this.kWh.setOnPageSelected(new BannerFlowView.a() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.2
            @Override // com.baidu.tieba.lego.card.view.l
            public void aP(float f) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.kWm.setPosition(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void DL(int i) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.kWm.setCount(i);
                }
            }

            @Override // com.baidu.tieba.lego.view.BannerFlowView.a
            public void onPageSelected(int i) {
                List<PlayPicInfoCard.b> imageResList = playPicInfoCard.getImageResList();
                if (imageResList != null && imageResList.size() > i) {
                    if (playPicInfoCard.getDescOnPic() != 1) {
                        PlayPicInfoCardView.this.kWl.setVisibility(8);
                        if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                            PlayPicInfoCardView.this.kWk.setText(imageResList.get(i).desc);
                            return;
                        } else {
                            PlayPicInfoCardView.this.kWj.setVisibility(8);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                        PlayPicInfoCardView.this.kWl.setText(imageResList.get(i).desc);
                        PlayPicInfoCardView.this.a(imageResList.get(i));
                        PlayPicInfoCardView.this.kWl.setVisibility(0);
                    } else {
                        PlayPicInfoCardView.this.kWl.setVisibility(8);
                    }
                    if (PlayPicInfoCardView.this.kWh != null) {
                        PlayPicInfoCardView.this.kWh.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).desc));
                    }
                }
            }
        });
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
            setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (playPicInfoCard.getImageResList().get(0) != null) {
                        v.h(PlayPicInfoCardView.this.eSJ, playPicInfoCard.getImageResList().get(0).scheme);
                        s.crj().mC(true);
                    }
                }
            });
        } else {
            setCardOnClickListener(null);
        }
        c(playPicInfoCard);
        b(playPicInfoCard);
        this.kWh.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        switch (playPicInfoCard.getShowDot()) {
            case 0:
                this.kWm.setVisibility(8);
                return;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kWm.getLayoutParams();
                layoutParams.gravity = 85;
                this.kWm.setLayoutParams(layoutParams);
                this.kWm.setVisibility(0);
                return;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kWm.getLayoutParams();
                layoutParams2.gravity = 81;
                this.kWm.setLayoutParams(layoutParams2);
                this.kWm.setVisibility(0);
                return;
            default:
                this.kWm.setVisibility(8);
                return;
        }
    }

    private void b(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.kWn.setVisibility(8);
            return;
        }
        this.kWn.setVisibility(0);
        String str = isNightMode() ? waterMark.kTZ : waterMark.picUrl;
        ((RelativeLayout.LayoutParams) this.kWn.getLayoutParams()).setMargins(com.baidu.adp.lib.util.l.dip2px(this.eSJ.getPageActivity(), waterMark.kUa), com.baidu.adp.lib.util.l.dip2px(this.eSJ.getPageActivity(), waterMark.kUb), 0, 0);
        this.kWn.startLoad(str, 10, false);
    }

    private void c(PlayPicInfoCard playPicInfoCard) {
        final PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo == null || !bottomInfo.isValid()) {
            this.kWo.setVisibility(8);
            return;
        }
        this.kWo.setVisibility(0);
        if (TextUtils.isEmpty(bottomInfo.mForumName)) {
            this.kWp.setVisibility(8);
        } else {
            this.kWp.setVisibility(0);
            this.kWp.setText(bottomInfo.mForumName);
            this.kWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(bottomInfo.mScheme)) {
                        v.h(PlayPicInfoCardView.this.eSJ, bottomInfo.mScheme);
                    }
                }
            });
        }
        if (bottomInfo.kTU != null) {
            a(this.kWr, this.kWq, bottomInfo.kTU);
        }
        if (bottomInfo.kTV != null) {
            this.kWs.setVisibility(0);
            com.baidu.adp.lib.util.l.addToParentArea(this.eSJ.getPageActivity(), this.kWs, 20, 20, 20, 20);
            final com.baidu.tieba.lego.card.model.a aVar = bottomInfo.kTV;
            this.kWs.a(bottomInfo.kTV);
            this.kWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bg.checkUpIsLogin(PlayPicInfoCardView.this.eSJ.getPageActivity())) {
                        com.baidu.tieba.lego.a.b.cZm().k(bottomInfo.kTV, bottomInfo.kTV.cZC());
                        ((CommonImageButton) view).a(aVar);
                    }
                }
            });
            return;
        }
        this.kWs.setVisibility(8);
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.kTK : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(com.baidu.tieba.lego.card.f.ov(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setText(bVar.content);
    }

    private List<com.baidu.adp.widget.ListView.n> d(PlayPicInfoCard playPicInfoCard) {
        ArrayList arrayList = new ArrayList();
        if (playPicInfoCard.getImageResList() == null || playPicInfoCard.getImageResList().size() == 0) {
            return arrayList;
        }
        int size = playPicInfoCard.getImageResList().size();
        for (int i = 0; i < size; i++) {
            a aVar = new a();
            aVar.b(playPicInfoCard.getImageResList().get(i));
            arrayList.add(aVar);
        }
        return arrayList;
    }
}
