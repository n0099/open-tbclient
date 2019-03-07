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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.PlayPicInfoCard;
import com.baidu.tieba.lego.view.BannerFlowView;
import com.baidu.tieba.lego.view.CommonImageButton;
import com.baidu.tieba.lego.view.a;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    private View dcP;
    public BannerFlowView gJA;
    private TextView gJB;
    private LinearLayout gJC;
    private TextView gJD;
    private TextView gJE;
    IndicatorView gJF;
    private TbImageView gJG;
    private RelativeLayout gJH;
    private TextView gJI;
    private TbImageView gJJ;
    private TextView gJK;
    private CommonImageButton gJL;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.tbadk.core.view.viewpager.bannerflow.a {
        private PlayPicInfoCard.b gJQ;
        private String url;

        public a() {
        }

        public void b(PlayPicInfoCard.b bVar) {
            this.url = bVar.pic;
            this.gJQ = bVar;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public Object afs() {
            return this.gJQ;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            al.j(this.gJE, d.C0236d.cp_btn_a);
        } else {
            a(this.gJE, bVar.gHn, bVar.gHo, d.C0236d.cp_btn_a);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.dcP = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.card_play_pic_info, (ViewGroup) null);
        this.gJA = (BannerFlowView) A(this.dcP, d.g.banner);
        if (this.mContext.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.gJA.setSwipeControlInterface((SwipeBackLayout.c) this.mContext.getOrignalPage());
        }
        this.gJA.setDisableParentEvent(false);
        this.gJA.setMaxScrollCountLimit(100);
        this.gJG = (TbImageView) A(this.dcP, d.g.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJA.getLayoutParams();
        layoutParams.height = (int) ((com.baidu.adp.lib.util.l.aO(getContext()) * 0.5f) + 0.5f);
        this.gJA.setLayoutParams(layoutParams);
        this.gJD = (TextView) A(this.dcP, d.g.title_bottom);
        this.gJC = (LinearLayout) A(this.dcP, d.g.ll_bottom);
        this.gJE = (TextView) A(this.dcP, d.g.title_on);
        this.gJF = (IndicatorView) A(this.dcP, d.g.indicator);
        this.gJB = (TextView) A(this.dcP, d.g.title_top);
        this.gJH = (RelativeLayout) A(this.dcP, d.g.bottom_relative_layout);
        this.gJI = (TextView) A(this.gJH, d.g.forum_name);
        this.gJJ = (TbImageView) A(this.gJH, d.g.icon);
        this.gJK = (TextView) A(this.gJH, d.g.text);
        this.gJL = (CommonImageButton) A(this.gJH, d.g.notice_button);
        return this.dcP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(PlayPicInfoCard playPicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.dcP, d.f.addresslist_item_bg);
        al.j(this.gJB, d.C0236d.cp_cont_b);
        al.j(this.gJD, d.C0236d.cp_cont_b);
        this.gJF.setSelector(al.getDrawable(d.f.dot_live_s));
        this.gJF.setDrawable(al.getDrawable(d.f.dot_live_n));
        al.j(this.gJI, d.C0236d.cp_cont_g);
        al.k(this.gJI, d.f.label_bg_tie_n);
        al.j(this.gJK, d.C0236d.cp_cont_e);
        a((PlayPicInfoCard.b) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final PlayPicInfoCard playPicInfoCard) {
        this.gJB.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJA.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * com.baidu.adp.lib.util.l.aO(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.gJA.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.aO(getContext()) * 0.5f) + 0.5f);
            this.gJA.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.gJA.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).desc));
        } else {
            this.gJA.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= TbConfig.NOTIFY_SOUND_INTERVAL) {
            this.gJA.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.gJA.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        }
        this.gJA.setData(d(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.gJE.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.gJD.setMaxWidth(((com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24)) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds20)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24) * playPicInfoCard.getImageResList().size()));
                this.gJD.setText(playPicInfoCard.getImageResList().get(0).desc);
                this.gJF.setVisibility(0);
                this.gJF.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.gJC.setVisibility(0);
                this.gJB.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.gJB.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.gJB.setVisibility(0);
                    this.gJC.setVisibility(8);
                } else {
                    this.gJC.setVisibility(0);
                    this.gJD.setMaxWidth(com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24));
                    this.gJD.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.gJB.setVisibility(8);
                    this.gJF.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.gJE.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.gJE.setMaxWidth(((com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24)) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds20)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.gJE.setMaxWidth(com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24));
                }
                this.gJE.setText(playPicInfoCard.getImageResList().get(0).desc);
                a(playPicInfoCard.getImageResList().get(0));
            } else {
                this.gJE.setVisibility(8);
            }
            this.gJB.setVisibility(8);
            this.gJC.setVisibility(8);
        }
        this.gJA.setOnItemClickListener(new c.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0270a>() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.view.viewpager.c.a
            /* renamed from: a */
            public void c(a.C0270a c0270a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
                if (aVar.afs() instanceof PlayPicInfoCard.b) {
                    PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.afs();
                    if (!TextUtils.isEmpty(bVar.scheme)) {
                        t.aQF().go(true);
                        com.baidu.tieba.lego.e d = com.baidu.tieba.lego.i.d(bVar.statistics, bVar.statTab, playPicInfoCard.getCardType(), playPicInfoCard.getItemId());
                        d.di(VideoPlayActivityConfig.OBJ_ID, bVar.picId);
                        d.di("obj_url", bVar.scheme);
                        d.bb("obj_locate", PlayPicInfoCardView.this.getStatPosition());
                        d.a(playPicInfoCard);
                        q.f(PlayPicInfoCardView.this.mContext, bVar.scheme);
                    }
                }
            }
        });
        this.gJA.setOnPageSelected(new BannerFlowView.a() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.2
            @Override // com.baidu.tieba.lego.card.view.j
            public void aI(float f) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.gJF.setPosition(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.j
            public void uY(int i) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.gJF.setCount(i);
                }
            }

            @Override // com.baidu.tieba.lego.view.BannerFlowView.a
            public void onPageSelected(int i) {
                List<PlayPicInfoCard.b> imageResList = playPicInfoCard.getImageResList();
                if (imageResList != null && imageResList.size() > i) {
                    if (playPicInfoCard.getDescOnPic() != 1) {
                        PlayPicInfoCardView.this.gJE.setVisibility(8);
                        if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                            PlayPicInfoCardView.this.gJD.setText(imageResList.get(i).desc);
                            return;
                        } else {
                            PlayPicInfoCardView.this.gJC.setVisibility(8);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                        PlayPicInfoCardView.this.gJE.setText(imageResList.get(i).desc);
                        PlayPicInfoCardView.this.a(imageResList.get(i));
                        PlayPicInfoCardView.this.gJE.setVisibility(0);
                    } else {
                        PlayPicInfoCardView.this.gJE.setVisibility(8);
                    }
                    if (PlayPicInfoCardView.this.gJA != null) {
                        PlayPicInfoCardView.this.gJA.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).desc));
                    }
                }
            }
        });
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
            setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (playPicInfoCard.getImageResList().get(0) != null) {
                        q.f(PlayPicInfoCardView.this.mContext, playPicInfoCard.getImageResList().get(0).scheme);
                        t.aQF().go(true);
                    }
                }
            });
        } else {
            setCardOnClickListener(null);
        }
        c(playPicInfoCard);
        b(playPicInfoCard);
        this.gJA.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        switch (playPicInfoCard.getShowDot()) {
            case 0:
                this.gJF.setVisibility(8);
                return;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJF.getLayoutParams();
                layoutParams.gravity = 85;
                this.gJF.setLayoutParams(layoutParams);
                this.gJF.setVisibility(0);
                return;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gJF.getLayoutParams();
                layoutParams2.gravity = 81;
                this.gJF.setLayoutParams(layoutParams2);
                this.gJF.setVisibility(0);
                return;
            default:
                this.gJF.setVisibility(8);
                return;
        }
    }

    private void b(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.gJG.setVisibility(8);
            return;
        }
        this.gJG.setVisibility(0);
        String str = isNightMode() ? waterMark.gHp : waterMark.picUrl;
        ((RelativeLayout.LayoutParams) this.gJG.getLayoutParams()).setMargins(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), waterMark.gHq), com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), waterMark.gHr), 0, 0);
        this.gJG.startLoad(str, 10, false);
    }

    private void c(PlayPicInfoCard playPicInfoCard) {
        final PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo == null || !bottomInfo.isValid()) {
            this.gJH.setVisibility(8);
            return;
        }
        this.gJH.setVisibility(0);
        if (TextUtils.isEmpty(bottomInfo.mForumName)) {
            this.gJI.setVisibility(8);
        } else {
            this.gJI.setVisibility(0);
            this.gJI.setText(bottomInfo.mForumName);
            this.gJI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(bottomInfo.aSu)) {
                        q.f(PlayPicInfoCardView.this.mContext, bottomInfo.aSu);
                    }
                }
            });
        }
        if (bottomInfo.gHl != null) {
            a(this.gJK, this.gJJ, bottomInfo.gHl);
        }
        if (bottomInfo.gHm != null) {
            this.gJL.setVisibility(0);
            com.baidu.adp.lib.util.l.b(this.mContext.getPageActivity(), this.gJL, 20, 20, 20, 20);
            final com.baidu.tieba.lego.card.model.a aVar = bottomInfo.gHm;
            this.gJL.a(bottomInfo.gHm);
            this.gJL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bc.cZ(PlayPicInfoCardView.this.mContext.getPageActivity())) {
                        com.baidu.tieba.lego.a.b.bzz().g(bottomInfo.gHm, bottomInfo.gHm.bzP());
                        ((CommonImageButton) view).a(aVar);
                    }
                }
            });
            return;
        }
        this.gJL.setVisibility(8);
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.gHb : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(com.baidu.tieba.lego.card.f.hu(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setText(bVar.content);
    }

    private List<com.baidu.adp.widget.ListView.m> d(PlayPicInfoCard playPicInfoCard) {
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
