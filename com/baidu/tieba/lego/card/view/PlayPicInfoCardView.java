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
    public BannerFlowView lek;
    private TextView lel;
    private LinearLayout lem;
    private TextView leo;
    private TextView lep;
    IndicatorView leq;
    private TbImageView ler;
    private RelativeLayout les;
    private TextView let;
    private TbImageView leu;
    private TextView lev;
    private CommonImageButton lew;

    /* loaded from: classes9.dex */
    public class a extends com.baidu.tbadk.core.view.viewpager.bannerflow.a {
        private PlayPicInfoCard.b leB;
        private String url;

        public a() {
        }

        public void b(PlayPicInfoCard.b bVar) {
            this.url = bVar.pic;
            this.leB = bVar;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public Object bvC() {
            return this.leB;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            ap.setViewTextColor(this.lep, R.color.CAM_X0101);
        } else {
            a(this.lep, bVar.lbZ, bVar.lca, R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.eno = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
        this.lek = (BannerFlowView) z(this.eno, R.id.banner);
        if (this.eUY.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.lek.setSwipeControlInterface((SwipeBackLayout.c) this.eUY.getOrignalPage());
        }
        this.lek.setDisableParentEvent(false);
        this.lek.setMaxScrollCountLimit(100);
        this.ler = (TbImageView) z(this.eno, R.id.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lek.getLayoutParams();
        layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
        this.lek.setLayoutParams(layoutParams);
        this.leo = (TextView) z(this.eno, R.id.title_bottom);
        this.lem = (LinearLayout) z(this.eno, R.id.ll_bottom);
        this.lep = (TextView) z(this.eno, R.id.title_on);
        this.leq = (IndicatorView) z(this.eno, R.id.indicator);
        this.lel = (TextView) z(this.eno, R.id.title_top);
        this.les = (RelativeLayout) z(this.eno, R.id.bottom_relative_layout);
        this.let = (TextView) z(this.les, R.id.forum_name);
        this.leu = (TbImageView) z(this.les, R.id.icon);
        this.lev = (TextView) z(this.les, R.id.text);
        this.lew = (CommonImageButton) z(this.les, R.id.notice_button);
        return this.eno;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(PlayPicInfoCard playPicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.eno, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.lel, R.color.CAM_X0105);
        ap.setViewTextColor(this.leo, R.color.CAM_X0105);
        this.leq.setSelector(ap.getDrawable(R.drawable.dot_live_s));
        this.leq.setDrawable(ap.getDrawable(R.drawable.dot_live_n));
        ap.setViewTextColor(this.let, R.color.CAM_X0111);
        ap.setBackgroundResource(this.let, R.drawable.label_bg_tie_n);
        ap.setViewTextColor(this.lev, R.color.CAM_X0110);
        a((PlayPicInfoCard.b) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final PlayPicInfoCard playPicInfoCard) {
        this.lel.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lek.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.lek.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.lek.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.lek.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).desc));
        } else {
            this.lek.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= 5000) {
            this.lek.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.lek.setAutoScrollIntervalTime(5000L);
        }
        this.lek.setData(d(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.lep.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.leo.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                this.leo.setText(playPicInfoCard.getImageResList().get(0).desc);
                this.leq.setVisibility(0);
                this.leq.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.lem.setVisibility(0);
                this.lel.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.lel.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.lel.setVisibility(0);
                    this.lem.setVisibility(8);
                } else {
                    this.lem.setVisibility(0);
                    this.leo.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                    this.leo.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.lel.setVisibility(8);
                    this.leq.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.lep.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.lep.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.lep.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                }
                this.lep.setText(playPicInfoCard.getImageResList().get(0).desc);
                a(playPicInfoCard.getImageResList().get(0));
            } else {
                this.lep.setVisibility(8);
            }
            this.lel.setVisibility(8);
            this.lem.setVisibility(8);
        }
        this.lek.setOnItemClickListener(new b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0777a>() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.view.viewpager.b.a
            /* renamed from: a */
            public void c(a.C0777a c0777a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
                if (aVar.bvC() instanceof PlayPicInfoCard.b) {
                    PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.bvC();
                    if (!TextUtils.isEmpty(bVar.scheme)) {
                        t.csu().mG(true);
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
        this.lek.setOnPageSelected(new BannerFlowView.a() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.2
            @Override // com.baidu.tieba.lego.card.view.l
            public void aS(float f) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.leq.setPosition(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Ed(int i) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.leq.setCount(i);
                }
            }

            @Override // com.baidu.tieba.lego.view.BannerFlowView.a
            public void onPageSelected(int i) {
                List<PlayPicInfoCard.b> imageResList = playPicInfoCard.getImageResList();
                if (imageResList != null && imageResList.size() > i) {
                    if (playPicInfoCard.getDescOnPic() != 1) {
                        PlayPicInfoCardView.this.lep.setVisibility(8);
                        if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                            PlayPicInfoCardView.this.leo.setText(imageResList.get(i).desc);
                            return;
                        } else {
                            PlayPicInfoCardView.this.lem.setVisibility(8);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                        PlayPicInfoCardView.this.lep.setText(imageResList.get(i).desc);
                        PlayPicInfoCardView.this.a(imageResList.get(i));
                        PlayPicInfoCardView.this.lep.setVisibility(0);
                    } else {
                        PlayPicInfoCardView.this.lep.setVisibility(8);
                    }
                    if (PlayPicInfoCardView.this.lek != null) {
                        PlayPicInfoCardView.this.lek.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).desc));
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
                        t.csu().mG(true);
                    }
                }
            });
        } else {
            setCardOnClickListener(null);
        }
        c(playPicInfoCard);
        b(playPicInfoCard);
        this.lek.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        switch (playPicInfoCard.getShowDot()) {
            case 0:
                this.leq.setVisibility(8);
                return;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.leq.getLayoutParams();
                layoutParams.gravity = 85;
                this.leq.setLayoutParams(layoutParams);
                this.leq.setVisibility(0);
                return;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.leq.getLayoutParams();
                layoutParams2.gravity = 81;
                this.leq.setLayoutParams(layoutParams2);
                this.leq.setVisibility(0);
                return;
            default:
                this.leq.setVisibility(8);
                return;
        }
    }

    private void b(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.ler.setVisibility(8);
            return;
        }
        this.ler.setVisibility(0);
        String str = isNightMode() ? waterMark.lcc : waterMark.picUrl;
        ((RelativeLayout.LayoutParams) this.ler.getLayoutParams()).setMargins(com.baidu.adp.lib.util.l.dip2px(this.eUY.getPageActivity(), waterMark.lcd), com.baidu.adp.lib.util.l.dip2px(this.eUY.getPageActivity(), waterMark.lce), 0, 0);
        this.ler.startLoad(str, 10, false);
    }

    private void c(PlayPicInfoCard playPicInfoCard) {
        final PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo == null || !bottomInfo.isValid()) {
            this.les.setVisibility(8);
            return;
        }
        this.les.setVisibility(0);
        if (TextUtils.isEmpty(bottomInfo.mForumName)) {
            this.let.setVisibility(8);
        } else {
            this.let.setVisibility(0);
            this.let.setText(bottomInfo.mForumName);
            this.let.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(bottomInfo.mScheme)) {
                        v.j(PlayPicInfoCardView.this.eUY, bottomInfo.mScheme);
                    }
                }
            });
        }
        if (bottomInfo.lbX != null) {
            a(this.lev, this.leu, bottomInfo.lbX);
        }
        if (bottomInfo.lbY != null) {
            this.lew.setVisibility(0);
            com.baidu.adp.lib.util.l.addToParentArea(this.eUY.getPageActivity(), this.lew, 20, 20, 20, 20);
            final com.baidu.tieba.lego.card.model.a aVar = bottomInfo.lbY;
            this.lew.a(bottomInfo.lbY);
            this.lew.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(PlayPicInfoCardView.this.eUY.getPageActivity())) {
                        com.baidu.tieba.lego.a.b.dbk().k(bottomInfo.lbY, bottomInfo.lbY.dbA());
                        ((CommonImageButton) view).a(aVar);
                    }
                }
            });
            return;
        }
        this.lew.setVisibility(8);
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.lbN : bVar.url;
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
