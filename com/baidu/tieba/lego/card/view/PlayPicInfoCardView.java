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
/* loaded from: classes9.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    private View epV;
    public BannerFlowView laN;
    private TextView laO;
    private LinearLayout laP;
    private TextView laQ;
    private TextView laR;
    IndicatorView laS;
    private TbImageView laT;
    private RelativeLayout laU;
    private TextView laV;
    private TbImageView laW;
    private TextView laX;
    private CommonImageButton laY;

    /* loaded from: classes9.dex */
    public class a extends com.baidu.tbadk.core.view.viewpager.bannerflow.a {
        private PlayPicInfoCard.b lbd;
        private String url;

        public a() {
        }

        public void b(PlayPicInfoCard.b bVar) {
            this.url = bVar.pic;
            this.lbd = bVar;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public Object bzc() {
            return this.lbd;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            ao.setViewTextColor(this.laR, R.color.CAM_X0101);
        } else {
            a(this.laR, bVar.kYB, bVar.kYC, R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.epV = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
        this.laN = (BannerFlowView) z(this.epV, R.id.banner);
        if (this.eXu.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.laN.setSwipeControlInterface((SwipeBackLayout.c) this.eXu.getOrignalPage());
        }
        this.laN.setDisableParentEvent(false);
        this.laN.setMaxScrollCountLimit(100);
        this.laT = (TbImageView) z(this.epV, R.id.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.laN.getLayoutParams();
        layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
        this.laN.setLayoutParams(layoutParams);
        this.laQ = (TextView) z(this.epV, R.id.title_bottom);
        this.laP = (LinearLayout) z(this.epV, R.id.ll_bottom);
        this.laR = (TextView) z(this.epV, R.id.title_on);
        this.laS = (IndicatorView) z(this.epV, R.id.indicator);
        this.laO = (TextView) z(this.epV, R.id.title_top);
        this.laU = (RelativeLayout) z(this.epV, R.id.bottom_relative_layout);
        this.laV = (TextView) z(this.laU, R.id.forum_name);
        this.laW = (TbImageView) z(this.laU, R.id.icon);
        this.laX = (TextView) z(this.laU, R.id.text);
        this.laY = (CommonImageButton) z(this.laU, R.id.notice_button);
        return this.epV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(PlayPicInfoCard playPicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eXu, getRootView());
        ao.setBackgroundResource(this.epV, R.drawable.addresslist_item_bg);
        ao.setViewTextColor(this.laO, R.color.CAM_X0105);
        ao.setViewTextColor(this.laQ, R.color.CAM_X0105);
        this.laS.setSelector(ao.getDrawable(R.drawable.dot_live_s));
        this.laS.setDrawable(ao.getDrawable(R.drawable.dot_live_n));
        ao.setViewTextColor(this.laV, R.color.CAM_X0111);
        ao.setBackgroundResource(this.laV, R.drawable.label_bg_tie_n);
        ao.setViewTextColor(this.laX, R.color.CAM_X0110);
        a((PlayPicInfoCard.b) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final PlayPicInfoCard playPicInfoCard) {
        this.laO.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.laN.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.laN.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.laN.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.laN.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).desc));
        } else {
            this.laN.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= 5000) {
            this.laN.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.laN.setAutoScrollIntervalTime(5000L);
        }
        this.laN.setData(d(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.laR.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.laQ.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                this.laQ.setText(playPicInfoCard.getImageResList().get(0).desc);
                this.laS.setVisibility(0);
                this.laS.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.laP.setVisibility(0);
                this.laO.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.laO.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.laO.setVisibility(0);
                    this.laP.setVisibility(8);
                } else {
                    this.laP.setVisibility(0);
                    this.laQ.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                    this.laQ.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.laO.setVisibility(8);
                    this.laS.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.laR.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.laR.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.laR.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                }
                this.laR.setText(playPicInfoCard.getImageResList().get(0).desc);
                a(playPicInfoCard.getImageResList().get(0));
            } else {
                this.laR.setVisibility(8);
            }
            this.laO.setVisibility(8);
            this.laP.setVisibility(8);
        }
        this.laN.setOnItemClickListener(new b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0792a>() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.view.viewpager.b.a
            /* renamed from: a */
            public void c(a.C0792a c0792a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
                if (aVar.bzc() instanceof PlayPicInfoCard.b) {
                    PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.bzc();
                    if (!TextUtils.isEmpty(bVar.scheme)) {
                        s.cvb().mG(true);
                        com.baidu.tieba.lego.e d = com.baidu.tieba.lego.i.d(bVar.statistics, bVar.statTab, playPicInfoCard.getCardType(), playPicInfoCard.getItemId());
                        d.fG("obj_id", bVar.picId);
                        d.fG(TiebaInitialize.Params.OBJ_URL, bVar.scheme);
                        d.bz("obj_locate", PlayPicInfoCardView.this.getStatPosition());
                        d.a(playPicInfoCard);
                        v.h(PlayPicInfoCardView.this.eXu, bVar.scheme);
                    }
                }
            }
        });
        this.laN.setOnPageSelected(new BannerFlowView.a() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.2
            @Override // com.baidu.tieba.lego.card.view.l
            public void aP(float f) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.laS.setPosition(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Fr(int i) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.laS.setCount(i);
                }
            }

            @Override // com.baidu.tieba.lego.view.BannerFlowView.a
            public void onPageSelected(int i) {
                List<PlayPicInfoCard.b> imageResList = playPicInfoCard.getImageResList();
                if (imageResList != null && imageResList.size() > i) {
                    if (playPicInfoCard.getDescOnPic() != 1) {
                        PlayPicInfoCardView.this.laR.setVisibility(8);
                        if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                            PlayPicInfoCardView.this.laQ.setText(imageResList.get(i).desc);
                            return;
                        } else {
                            PlayPicInfoCardView.this.laP.setVisibility(8);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                        PlayPicInfoCardView.this.laR.setText(imageResList.get(i).desc);
                        PlayPicInfoCardView.this.a(imageResList.get(i));
                        PlayPicInfoCardView.this.laR.setVisibility(0);
                    } else {
                        PlayPicInfoCardView.this.laR.setVisibility(8);
                    }
                    if (PlayPicInfoCardView.this.laN != null) {
                        PlayPicInfoCardView.this.laN.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).desc));
                    }
                }
            }
        });
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
            setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (playPicInfoCard.getImageResList().get(0) != null) {
                        v.h(PlayPicInfoCardView.this.eXu, playPicInfoCard.getImageResList().get(0).scheme);
                        s.cvb().mG(true);
                    }
                }
            });
        } else {
            setCardOnClickListener(null);
        }
        c(playPicInfoCard);
        b(playPicInfoCard);
        this.laN.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        switch (playPicInfoCard.getShowDot()) {
            case 0:
                this.laS.setVisibility(8);
                return;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.laS.getLayoutParams();
                layoutParams.gravity = 85;
                this.laS.setLayoutParams(layoutParams);
                this.laS.setVisibility(0);
                return;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.laS.getLayoutParams();
                layoutParams2.gravity = 81;
                this.laS.setLayoutParams(layoutParams2);
                this.laS.setVisibility(0);
                return;
            default:
                this.laS.setVisibility(8);
                return;
        }
    }

    private void b(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.laT.setVisibility(8);
            return;
        }
        this.laT.setVisibility(0);
        String str = isNightMode() ? waterMark.kYE : waterMark.picUrl;
        ((RelativeLayout.LayoutParams) this.laT.getLayoutParams()).setMargins(com.baidu.adp.lib.util.l.dip2px(this.eXu.getPageActivity(), waterMark.kYF), com.baidu.adp.lib.util.l.dip2px(this.eXu.getPageActivity(), waterMark.kYG), 0, 0);
        this.laT.startLoad(str, 10, false);
    }

    private void c(PlayPicInfoCard playPicInfoCard) {
        final PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo == null || !bottomInfo.isValid()) {
            this.laU.setVisibility(8);
            return;
        }
        this.laU.setVisibility(0);
        if (TextUtils.isEmpty(bottomInfo.mForumName)) {
            this.laV.setVisibility(8);
        } else {
            this.laV.setVisibility(0);
            this.laV.setText(bottomInfo.mForumName);
            this.laV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(bottomInfo.mScheme)) {
                        v.h(PlayPicInfoCardView.this.eXu, bottomInfo.mScheme);
                    }
                }
            });
        }
        if (bottomInfo.kYz != null) {
            a(this.laX, this.laW, bottomInfo.kYz);
        }
        if (bottomInfo.kYA != null) {
            this.laY.setVisibility(0);
            com.baidu.adp.lib.util.l.addToParentArea(this.eXu.getPageActivity(), this.laY, 20, 20, 20, 20);
            final com.baidu.tieba.lego.card.model.a aVar = bottomInfo.kYA;
            this.laY.a(bottomInfo.kYA);
            this.laY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bg.checkUpIsLogin(PlayPicInfoCardView.this.eXu.getPageActivity())) {
                        com.baidu.tieba.lego.a.b.dde().k(bottomInfo.kYA, bottomInfo.kYA.ddu());
                        ((CommonImageButton) view).a(aVar);
                    }
                }
            });
            return;
        }
        this.laY.setVisibility(8);
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.kYp : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(com.baidu.tieba.lego.card.f.qc(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
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
