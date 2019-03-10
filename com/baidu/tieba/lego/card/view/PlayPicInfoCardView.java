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
    public BannerFlowView gJB;
    private TextView gJC;
    private LinearLayout gJD;
    private TextView gJE;
    private TextView gJF;
    IndicatorView gJG;
    private TbImageView gJH;
    private RelativeLayout gJI;
    private TextView gJJ;
    private TbImageView gJK;
    private TextView gJL;
    private CommonImageButton gJM;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.tbadk.core.view.viewpager.bannerflow.a {
        private PlayPicInfoCard.b gJR;
        private String url;

        public a() {
        }

        public void b(PlayPicInfoCard.b bVar) {
            this.url = bVar.pic;
            this.gJR = bVar;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public String getImageUrl() {
            return this.url;
        }

        @Override // com.baidu.tbadk.core.view.viewpager.bannerflow.a
        public Object afs() {
            return this.gJR;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            al.j(this.gJF, d.C0236d.cp_btn_a);
        } else {
            a(this.gJF, bVar.gHo, bVar.gHp, d.C0236d.cp_btn_a);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.dcP = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.card_play_pic_info, (ViewGroup) null);
        this.gJB = (BannerFlowView) A(this.dcP, d.g.banner);
        if (this.mContext.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.gJB.setSwipeControlInterface((SwipeBackLayout.c) this.mContext.getOrignalPage());
        }
        this.gJB.setDisableParentEvent(false);
        this.gJB.setMaxScrollCountLimit(100);
        this.gJH = (TbImageView) A(this.dcP, d.g.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJB.getLayoutParams();
        layoutParams.height = (int) ((com.baidu.adp.lib.util.l.aO(getContext()) * 0.5f) + 0.5f);
        this.gJB.setLayoutParams(layoutParams);
        this.gJE = (TextView) A(this.dcP, d.g.title_bottom);
        this.gJD = (LinearLayout) A(this.dcP, d.g.ll_bottom);
        this.gJF = (TextView) A(this.dcP, d.g.title_on);
        this.gJG = (IndicatorView) A(this.dcP, d.g.indicator);
        this.gJC = (TextView) A(this.dcP, d.g.title_top);
        this.gJI = (RelativeLayout) A(this.dcP, d.g.bottom_relative_layout);
        this.gJJ = (TextView) A(this.gJI, d.g.forum_name);
        this.gJK = (TbImageView) A(this.gJI, d.g.icon);
        this.gJL = (TextView) A(this.gJI, d.g.text);
        this.gJM = (CommonImageButton) A(this.gJI, d.g.notice_button);
        return this.dcP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(PlayPicInfoCard playPicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.dcP, d.f.addresslist_item_bg);
        al.j(this.gJC, d.C0236d.cp_cont_b);
        al.j(this.gJE, d.C0236d.cp_cont_b);
        this.gJG.setSelector(al.getDrawable(d.f.dot_live_s));
        this.gJG.setDrawable(al.getDrawable(d.f.dot_live_n));
        al.j(this.gJJ, d.C0236d.cp_cont_g);
        al.k(this.gJJ, d.f.label_bg_tie_n);
        al.j(this.gJL, d.C0236d.cp_cont_e);
        a((PlayPicInfoCard.b) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final PlayPicInfoCard playPicInfoCard) {
        this.gJC.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJB.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * com.baidu.adp.lib.util.l.aO(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.gJB.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.aO(getContext()) * 0.5f) + 0.5f);
            this.gJB.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.gJB.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).desc));
        } else {
            this.gJB.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= TbConfig.NOTIFY_SOUND_INTERVAL) {
            this.gJB.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.gJB.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        }
        this.gJB.setData(d(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.gJF.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.gJE.setMaxWidth(((com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24)) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds20)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24) * playPicInfoCard.getImageResList().size()));
                this.gJE.setText(playPicInfoCard.getImageResList().get(0).desc);
                this.gJG.setVisibility(0);
                this.gJG.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.gJD.setVisibility(0);
                this.gJC.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.gJC.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.gJC.setVisibility(0);
                    this.gJD.setVisibility(8);
                } else {
                    this.gJD.setVisibility(0);
                    this.gJE.setMaxWidth(com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24));
                    this.gJE.setText(playPicInfoCard.getImageResList().get(0).desc);
                    this.gJC.setVisibility(8);
                    this.gJG.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.gJF.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.gJF.setMaxWidth(((com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24)) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds20)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.gJF.setMaxWidth(com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.ds24));
                }
                this.gJF.setText(playPicInfoCard.getImageResList().get(0).desc);
                a(playPicInfoCard.getImageResList().get(0));
            } else {
                this.gJF.setVisibility(8);
            }
            this.gJC.setVisibility(8);
            this.gJD.setVisibility(8);
        }
        this.gJB.setOnItemClickListener(new c.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0270a>() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.view.viewpager.c.a
            /* renamed from: a */
            public void c(a.C0270a c0270a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
                if (aVar.afs() instanceof PlayPicInfoCard.b) {
                    PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.afs();
                    if (!TextUtils.isEmpty(bVar.scheme)) {
                        t.aQG().go(true);
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
        this.gJB.setOnPageSelected(new BannerFlowView.a() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.2
            @Override // com.baidu.tieba.lego.card.view.j
            public void aI(float f) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.gJG.setPosition(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.j
            public void uY(int i) {
                if (playPicInfoCard.getDescOnPic() != 1) {
                    PlayPicInfoCardView.this.gJG.setCount(i);
                }
            }

            @Override // com.baidu.tieba.lego.view.BannerFlowView.a
            public void onPageSelected(int i) {
                List<PlayPicInfoCard.b> imageResList = playPicInfoCard.getImageResList();
                if (imageResList != null && imageResList.size() > i) {
                    if (playPicInfoCard.getDescOnPic() != 1) {
                        PlayPicInfoCardView.this.gJF.setVisibility(8);
                        if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                            PlayPicInfoCardView.this.gJE.setText(imageResList.get(i).desc);
                            return;
                        } else {
                            PlayPicInfoCardView.this.gJD.setVisibility(8);
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(imageResList.get(i).desc)) {
                        PlayPicInfoCardView.this.gJF.setText(imageResList.get(i).desc);
                        PlayPicInfoCardView.this.a(imageResList.get(i));
                        PlayPicInfoCardView.this.gJF.setVisibility(0);
                    } else {
                        PlayPicInfoCardView.this.gJF.setVisibility(8);
                    }
                    if (PlayPicInfoCardView.this.gJB != null) {
                        PlayPicInfoCardView.this.gJB.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).desc));
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
                        t.aQG().go(true);
                    }
                }
            });
        } else {
            setCardOnClickListener(null);
        }
        c(playPicInfoCard);
        b(playPicInfoCard);
        this.gJB.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        switch (playPicInfoCard.getShowDot()) {
            case 0:
                this.gJG.setVisibility(8);
                return;
            case 1:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJG.getLayoutParams();
                layoutParams.gravity = 85;
                this.gJG.setLayoutParams(layoutParams);
                this.gJG.setVisibility(0);
                return;
            case 2:
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gJG.getLayoutParams();
                layoutParams2.gravity = 81;
                this.gJG.setLayoutParams(layoutParams2);
                this.gJG.setVisibility(0);
                return;
            default:
                this.gJG.setVisibility(8);
                return;
        }
    }

    private void b(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.gJH.setVisibility(8);
            return;
        }
        this.gJH.setVisibility(0);
        String str = isNightMode() ? waterMark.gHq : waterMark.picUrl;
        ((RelativeLayout.LayoutParams) this.gJH.getLayoutParams()).setMargins(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), waterMark.gHr), com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), waterMark.gHs), 0, 0);
        this.gJH.startLoad(str, 10, false);
    }

    private void c(PlayPicInfoCard playPicInfoCard) {
        final PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo == null || !bottomInfo.isValid()) {
            this.gJI.setVisibility(8);
            return;
        }
        this.gJI.setVisibility(0);
        if (TextUtils.isEmpty(bottomInfo.mForumName)) {
            this.gJJ.setVisibility(8);
        } else {
            this.gJJ.setVisibility(0);
            this.gJJ.setText(bottomInfo.mForumName);
            this.gJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(bottomInfo.aSu)) {
                        q.f(PlayPicInfoCardView.this.mContext, bottomInfo.aSu);
                    }
                }
            });
        }
        if (bottomInfo.gHm != null) {
            a(this.gJL, this.gJK, bottomInfo.gHm);
        }
        if (bottomInfo.gHn != null) {
            this.gJM.setVisibility(0);
            com.baidu.adp.lib.util.l.b(this.mContext.getPageActivity(), this.gJM, 20, 20, 20, 20);
            final com.baidu.tieba.lego.card.model.a aVar = bottomInfo.gHn;
            this.gJM.a(bottomInfo.gHn);
            this.gJM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.PlayPicInfoCardView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bc.cZ(PlayPicInfoCardView.this.mContext.getPageActivity())) {
                        com.baidu.tieba.lego.a.b.bzA().g(bottomInfo.gHn, bottomInfo.gHn.bzQ());
                        ((CommonImageButton) view).a(aVar);
                    }
                }
            });
            return;
        }
        this.gJM.setVisibility(8);
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.gHc : bVar.url;
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
