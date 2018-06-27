package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.view.DistributeVrVideoView;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AdCardVrVideoView extends AdCardBaseView implements k {
    public DistributeVrVideoView gpL;
    private TbPageContext mTbPageContext;

    public AdCardVrVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.ad_card_vr_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bv(View view) {
        this.gpL = (DistributeVrVideoView) view.findViewById(d.g.advert_video);
        this.gpL.setHolderView(view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.getAdvertAppInfo() != null && adCard.vrVideoInfo != null) {
            this.gpL.setData(this.mTbPageContext, adCard, this.mMaxWidth);
            final VideoInfo videoInfo = adCard.vrVideoInfo.videoInfo;
            final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null && videoInfo != null && !ap.isEmpty(videoInfo.video_url)) {
                this.gpL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVrVideoView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.bpD().a(e.c(advertAppInfo, 2, advertAppInfo.advertAppContext.pn));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VrPlayerActivityConfig(AdCardVrVideoView.this.getContext(), 1, false, videoInfo.video_url)));
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return d.i.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        return this.gpL;
    }
}
