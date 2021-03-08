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
/* loaded from: classes8.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    private View eoR;
    public BannerFlowView lgB;
    private TextView lgC;
    private LinearLayout lgD;
    private TextView lgE;
    private TextView lgF;
    IndicatorView lgG;
    private TbImageView lgH;
    private RelativeLayout lgI;
    private TextView lgJ;
    private TbImageView lgK;
    private TextView lgL;
    private CommonImageButton lgM;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.tbadk.core.view.viewpager.bannerflow.a {
        private PlayPicInfoCard.b lgR;
        private String url;

        public a() {
        }

        public void b(PlayPicInfoCard.b bVar) {
            this.url = bVar.pic;
            this.lgR = bVar;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public Object bvF() {
            return this.lgR;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            ap.setViewTextColor(this.lgF, R.color.CAM_X0101);
        } else {
            a(this.lgF, bVar.ler, bVar.les, R.color.CAM_X0101);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.eoR = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
        this.lgB = (BannerFlowView) z(this.eoR, R.id.banner);
        if (this.eWx.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.lgB.setSwipeControlInterface((SwipeBackLayout.c) this.eWx.getOrignalPage());
        }
        this.lgB.setDisableParentEvent(false);
        this.lgB.setMaxScrollCountLimit(100);
        this.lgH = (TbImageView) z(this.eoR, R.id.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lgB.getLayoutParams();
        layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
        this.lgB.setLayoutParams(layoutParams);
        this.lgE = (TextView) z(this.eoR, R.id.title_bottom);
        this.lgD = (LinearLayout) z(this.eoR, R.id.ll_bottom);
        this.lgF = (TextView) z(this.eoR, R.id.title_on);
        this.lgG = (IndicatorView) z(this.eoR, R.id.indicator);
        this.lgC = (TextView) z(this.eoR, R.id.title_top);
        this.lgI = (RelativeLayout) z(this.eoR, R.id.bottom_relative_layout);
        this.lgJ = (TextView) z(this.lgI, R.id.forum_name);
        this.lgK = (TbImageView) z(this.lgI, R.id.icon);
        this.lgL = (TextView) z(this.lgI, R.id.text);
        this.lgM = (CommonImageButton) z(this.lgI, R.id.notice_button);
        return this.eoR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(PlayPicInfoCard playPicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eWx, getRootView());
        ap.setBackgroundResource(this.eoR, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.lgC, R.color.CAM_X0105);
        ap.setViewTextColor(this.lgE, R.color.CAM_X0105);
        this.lgG.setSelector(ap.getDrawable(R.drawable.dot_live_s));
        this.lgG.setDrawable(ap.getDrawable(R.drawable.dot_live_n));
        ap.setViewTextColor(this.lgJ, R.color.CAM_X0111);
        ap.setBackgroundResource(this.lgJ, R.drawable.label_bg_tie_n);
        ap.setViewTextColor(this.lgL, R.color.CAM_X0110);
        a((PlayPicInfoCard.b) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final PlayPicInfoCard playPicInfoCard) {
        this.lgC.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lgB.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.lgB.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.lgB.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.lgB.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).desc));
        } else {
            this.lgB.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= 5000) {
            this.lgB.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.lgB.setAutoScrollIntervalTime(5000L);
        }
        this.lgB.setData(d(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.lgF.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.lgE.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                this.lgE.setText(playPicInfoCard.getImageResList().get(0).desc);
                this.lgG.setVisibility(0);
                this.lgG.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.lgD.setVisibility(0);
                this.lgC.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.lgC.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.lgC.setVisibility(0);
                    this.lgD.setVisibility(8);
                } else {
                    this.lgD.setVisibility(0);
                    this.lgE.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                    this.lgE.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.lgC.setVisibility(8);
                    this.lgG.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.lgF.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.lgF.setMaxWidth(((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24)) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds20)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.lgF.setMaxWidth(com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds24));
                }
                this.lgF.setText(playPicInfoCard.getImageResList().get(0).desc);
                a(playPicInfoCard.getImageResList().get(0));
            } else {
                this.lgF.setVisibility(8);
            }
            this.lgC.setVisibility(8);
            this.lgD.setVisibility(8);
        }
        this.lgB.setOnItemClickListener(new b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0784a>() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.view.viewpager.b.a
            /* renamed from: a */
            public void c(a.C0784a c0784a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
                if (aVar.bvF() instanceof PlayPicInfoCard.b) {
                    PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.bvF();
                    if (!TextUtils.isEmpty(bVar.scheme)) {
                        t.csH().mG(true);
                        com.baidu.tieba.lego.e d = com.baidu.tieba.lego.i.d(bVar.statistics, bVar.statTab, playPicInfoCard.getCardType(), playPicInfoCard.getItemId());
                        d.fF("obj_id", bVar.picId);
                        d.fF(TiebaInitialize.Params.OBJ_URL, bVar.scheme);
                        d.bA("obj_locate", PlayPicInfoCardView.this.getStatPosition());
                        d.a(playPicInfoCard);
                        v.j(PlayPicInfoCardView.this.eWx, bVar.scheme);
                    }
                }
            }
        });
        this.lgB.setOnPageSelected(new BannerFlowView.a() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.2
            @Override // com.baidu.tieba.lego.card.view.l
            public void aW(float f) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.lgG.setPosition(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Eg(int i) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.lgG.setCount(i);
                }
            }

            @Override // com.baidu.tieba.lego.view.BannerFlowView.a
            public void onPageSelected(int i) {
                List<PlayPicInfoCard.b> imageResList = playPicInfoCard.getImageResList();
                if (imageResList != null && imageResList.size() > i) {
                    if (playPicInfoCard.getDescOnPic() != 1) {
                        PlayPicInfoCardView.this.lgF.setVisibility(8);
                        if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                            PlayPicInfoCardView.this.lgE.setText(imageResList.get(i).desc);
                            return;
                        } else {
                            PlayPicInfoCardView.this.lgD.setVisibility(8);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                        PlayPicInfoCardView.this.lgF.setText(imageResList.get(i).desc);
                        PlayPicInfoCardView.this.a(imageResList.get(i));
                        PlayPicInfoCardView.this.lgF.setVisibility(0);
                    } else {
                        PlayPicInfoCardView.this.lgF.setVisibility(8);
                    }
                    if (PlayPicInfoCardView.this.lgB != null) {
                        PlayPicInfoCardView.this.lgB.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).desc));
                    }
                }
            }
        });
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
            setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (playPicInfoCard.getImageResList().get(0) != null) {
                        v.j(PlayPicInfoCardView.this.eWx, playPicInfoCard.getImageResList().get(0).scheme);
                        t.csH().mG(true);
                    }
                }
            });
        } else {
            setCardOnClickListener(null);
        }
        c(playPicInfoCard);
        b(playPicInfoCard);
        this.lgB.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        switch (playPicInfoCard.getShowDot()) {
            case 0:
                this.lgG.setVisibility(8);
                return;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lgG.getLayoutParams();
                layoutParams.gravity = 85;
                this.lgG.setLayoutParams(layoutParams);
                this.lgG.setVisibility(0);
                return;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lgG.getLayoutParams();
                layoutParams2.gravity = 81;
                this.lgG.setLayoutParams(layoutParams2);
                this.lgG.setVisibility(0);
                return;
            default:
                this.lgG.setVisibility(8);
                return;
        }
    }

    private void b(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.lgH.setVisibility(8);
            return;
        }
        this.lgH.setVisibility(0);
        String str = isNightMode() ? waterMark.leu : waterMark.picUrl;
        ((RelativeLayout.LayoutParams) this.lgH.getLayoutParams()).setMargins(com.baidu.adp.lib.util.l.dip2px(this.eWx.getPageActivity(), waterMark.lev), com.baidu.adp.lib.util.l.dip2px(this.eWx.getPageActivity(), waterMark.lew), 0, 0);
        this.lgH.startLoad(str, 10, false);
    }

    private void c(PlayPicInfoCard playPicInfoCard) {
        final PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo == null || !bottomInfo.isValid()) {
            this.lgI.setVisibility(8);
            return;
        }
        this.lgI.setVisibility(0);
        if (TextUtils.isEmpty(bottomInfo.mForumName)) {
            this.lgJ.setVisibility(8);
        } else {
            this.lgJ.setVisibility(0);
            this.lgJ.setText(bottomInfo.mForumName);
            this.lgJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(bottomInfo.mScheme)) {
                        v.j(PlayPicInfoCardView.this.eWx, bottomInfo.mScheme);
                    }
                }
            });
        }
        if (bottomInfo.lep != null) {
            a(this.lgL, this.lgK, bottomInfo.lep);
        }
        if (bottomInfo.leq != null) {
            this.lgM.setVisibility(0);
            com.baidu.adp.lib.util.l.addToParentArea(this.eWx.getPageActivity(), this.lgM, 20, 20, 20, 20);
            final com.baidu.tieba.lego.card.model.a aVar = bottomInfo.leq;
            this.lgM.a(bottomInfo.leq);
            this.lgM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(PlayPicInfoCardView.this.eWx.getPageActivity())) {
                        com.baidu.tieba.lego.a.b.dbA().l(bottomInfo.leq, bottomInfo.leq.dbQ());
                        ((CommonImageButton) view).a(aVar);
                    }
                }
            });
            return;
        }
        this.lgM.setVisibility(8);
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.lee : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(com.baidu.tieba.lego.card.f.oB(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
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
