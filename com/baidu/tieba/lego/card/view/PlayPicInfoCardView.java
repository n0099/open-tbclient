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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.viewpager.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
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
    private View eno;
    private TextView leA;
    private LinearLayout leB;
    private TextView leC;
    private TextView leD;
    IndicatorView leE;
    private TbImageView leF;
    private RelativeLayout leG;
    private TextView leH;
    private TbImageView leI;
    private TextView leJ;
    private CommonImageButton leK;
    public BannerFlowView lez;

    /* loaded from: classes9.dex */
    public class a extends com.baidu.tbadk.core.view.viewpager.bannerflow.a {
        private PlayPicInfoCard.b leP;
        private String url;

        public a() {
        }

        public void b(PlayPicInfoCard.b bVar) {
            this.url = bVar.pic;
            this.leP = bVar;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public Object bvC() {
            return this.leP;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            ap.setViewTextColor(this.leD, R.color.CAM_X0101);
        } else {
            a(this.leD, bVar.lcn, bVar.lco, R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.eno = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
        this.lez = (BannerFlowView) z(this.eno, R.id.banner);
        if (this.eUY.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.lez.setSwipeControlInterface((SwipeBackLayout.c) this.eUY.getOrignalPage());
        }
        this.lez.setDisableParentEvent(false);
        this.lez.setMaxScrollCountLimit(100);
        this.leF = (TbImageView) z(this.eno, R.id.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lez.getLayoutParams();
        layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
        this.lez.setLayoutParams(layoutParams);
        this.leC = (TextView) z(this.eno, R.id.title_bottom);
        this.leB = (LinearLayout) z(this.eno, R.id.ll_bottom);
        this.leD = (TextView) z(this.eno, R.id.title_on);
        this.leE = (IndicatorView) z(this.eno, R.id.indicator);
        this.leA = (TextView) z(this.eno, R.id.title_top);
        this.leG = (RelativeLayout) z(this.eno, R.id.bottom_relative_layout);
        this.leH = (TextView) z(this.leG, R.id.forum_name);
        this.leI = (TbImageView) z(this.leG, R.id.icon);
        this.leJ = (TextView) z(this.leG, R.id.text);
        this.leK = (CommonImageButton) z(this.leG, R.id.notice_button);
        return this.eno;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(PlayPicInfoCard playPicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.eno, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.leA, R.color.CAM_X0105);
        ap.setViewTextColor(this.leC, R.color.CAM_X0105);
        this.leE.setSelector(ap.getDrawable(R.drawable.dot_live_s));
        this.leE.setDrawable(ap.getDrawable(R.drawable.dot_live_n));
        ap.setViewTextColor(this.leH, R.color.CAM_X0111);
        ap.setBackgroundResource(this.leH, R.drawable.label_bg_tie_n);
        ap.setViewTextColor(this.leJ, R.color.CAM_X0110);
        a((PlayPicInfoCard.b) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final PlayPicInfoCard playPicInfoCard) {
        this.leA.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lez.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.lez.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.lez.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.lez.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).desc));
        } else {
            this.lez.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= 5000) {
            this.lez.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.lez.setAutoScrollIntervalTime(5000L);
        }
        this.lez.setData(d(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.leD.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.leC.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                this.leC.setText(playPicInfoCard.getImageResList().get(0).desc);
                this.leE.setVisibility(0);
                this.leE.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.leB.setVisibility(0);
                this.leA.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.leA.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.leA.setVisibility(0);
                    this.leB.setVisibility(8);
                } else {
                    this.leB.setVisibility(0);
                    this.leC.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                    this.leC.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.leA.setVisibility(8);
                    this.leE.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.leD.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.leD.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.leD.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                }
                this.leD.setText(playPicInfoCard.getImageResList().get(0).desc);
                a(playPicInfoCard.getImageResList().get(0));
            } else {
                this.leD.setVisibility(8);
            }
            this.leA.setVisibility(8);
            this.leB.setVisibility(8);
        }
        this.lez.setOnItemClickListener(new b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0778a>() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.view.viewpager.b.a
            /* renamed from: a */
            public void c(a.C0778a c0778a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
                if (aVar.bvC() instanceof PlayPicInfoCard.b) {
                    PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.bvC();
                    if (!TextUtils.isEmpty(bVar.scheme)) {
                        t.csB().mG(true);
                        com.baidu.tieba.lego.e d = com.baidu.tieba.lego.i.d(bVar.statistics, bVar.statTab, playPicInfoCard.getCardType(), playPicInfoCard.getItemId());
                        d.fF("obj_id", bVar.picId);
                        d.fF(TiebaInitialize.Params.OBJ_URL, bVar.scheme);
                        d.bA("obj_locate", PlayPicInfoCardView.this.getStatPosition());
                        d.a(playPicInfoCard);
                        v.j(PlayPicInfoCardView.this.eUY, bVar.scheme);
                    }
                }
            }
        });
        this.lez.setOnPageSelected(new BannerFlowView.a() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.2
            @Override // com.baidu.tieba.lego.card.view.l
            public void aS(float f) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.leE.setPosition(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Ed(int i) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.leE.setCount(i);
                }
            }

            @Override // com.baidu.tieba.lego.view.BannerFlowView.a
            public void onPageSelected(int i) {
                List<PlayPicInfoCard.b> imageResList = playPicInfoCard.getImageResList();
                if (imageResList != null && imageResList.size() > i) {
                    if (playPicInfoCard.getDescOnPic() != 1) {
                        PlayPicInfoCardView.this.leD.setVisibility(8);
                        if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                            PlayPicInfoCardView.this.leC.setText(imageResList.get(i).desc);
                            return;
                        } else {
                            PlayPicInfoCardView.this.leB.setVisibility(8);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                        PlayPicInfoCardView.this.leD.setText(imageResList.get(i).desc);
                        PlayPicInfoCardView.this.a(imageResList.get(i));
                        PlayPicInfoCardView.this.leD.setVisibility(0);
                    } else {
                        PlayPicInfoCardView.this.leD.setVisibility(8);
                    }
                    if (PlayPicInfoCardView.this.lez != null) {
                        PlayPicInfoCardView.this.lez.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).desc));
                    }
                }
            }
        });
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
            setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (playPicInfoCard.getImageResList().get(0) != null) {
                        v.j(PlayPicInfoCardView.this.eUY, playPicInfoCard.getImageResList().get(0).scheme);
                        t.csB().mG(true);
                    }
                }
            });
        } else {
            setCardOnClickListener(null);
        }
        c(playPicInfoCard);
        b(playPicInfoCard);
        this.lez.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        switch (playPicInfoCard.getShowDot()) {
            case 0:
                this.leE.setVisibility(8);
                return;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.leE.getLayoutParams();
                layoutParams.gravity = 85;
                this.leE.setLayoutParams(layoutParams);
                this.leE.setVisibility(0);
                return;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.leE.getLayoutParams();
                layoutParams2.gravity = 81;
                this.leE.setLayoutParams(layoutParams2);
                this.leE.setVisibility(0);
                return;
            default:
                this.leE.setVisibility(8);
                return;
        }
    }

    private void b(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.leF.setVisibility(8);
            return;
        }
        this.leF.setVisibility(0);
        String str = isNightMode() ? waterMark.lcq : waterMark.picUrl;
        ((RelativeLayout.LayoutParams) this.leF.getLayoutParams()).setMargins(com.baidu.adp.lib.util.l.dip2px(this.eUY.getPageActivity(), waterMark.lcr), com.baidu.adp.lib.util.l.dip2px(this.eUY.getPageActivity(), waterMark.lcs), 0, 0);
        this.leF.startLoad(str, 10, false);
    }

    private void c(PlayPicInfoCard playPicInfoCard) {
        final PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo == null || !bottomInfo.isValid()) {
            this.leG.setVisibility(8);
            return;
        }
        this.leG.setVisibility(0);
        if (TextUtils.isEmpty(bottomInfo.mForumName)) {
            this.leH.setVisibility(8);
        } else {
            this.leH.setVisibility(0);
            this.leH.setText(bottomInfo.mForumName);
            this.leH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(bottomInfo.mScheme)) {
                        v.j(PlayPicInfoCardView.this.eUY, bottomInfo.mScheme);
                    }
                }
            });
        }
        if (bottomInfo.lcl != null) {
            a(this.leJ, this.leI, bottomInfo.lcl);
        }
        if (bottomInfo.lcm != null) {
            this.leK.setVisibility(0);
            com.baidu.adp.lib.util.l.addToParentArea(this.eUY.getPageActivity(), this.leK, 20, 20, 20, 20);
            final com.baidu.tieba.lego.card.model.a aVar = bottomInfo.lcm;
            this.leK.a(bottomInfo.lcm);
            this.leK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(PlayPicInfoCardView.this.eUY.getPageActivity())) {
                        com.baidu.tieba.lego.a.b.dbr().k(bottomInfo.lcm, bottomInfo.lcm.dbH());
                        ((CommonImageButton) view).a(aVar);
                    }
                }
            });
            return;
        }
        this.leK.setVisibility(8);
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.lcb : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(com.baidu.tieba.lego.card.f.oA(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
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
