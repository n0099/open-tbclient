package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.f;
import com.baidu.tieba.recapp.view.DistributeVrVideoView;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AdCardVrVideoView extends AdCardBaseView implements k {
    public DistributeVrVideoView iJX;
    private TbPageContext mTbPageContext;

    public AdCardVrVideoView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_vr_video_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cM(View view) {
        this.iJX = (DistributeVrVideoView) view.findViewById(R.id.advert_video);
        this.iJX.setHolderView(view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard != null && adCard.getAdvertAppInfo() != null && adCard.vrVideoInfo != null) {
            this.iJX.setData(this.mTbPageContext, adCard, this.mMaxWidth);
            final VideoInfo videoInfo = adCard.vrVideoInfo.videoInfo;
            final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null && videoInfo != null && !aq.isEmpty(videoInfo.video_url)) {
                this.iJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardVrVideoView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.cgG().a(f.c(advertAppInfo, 2, advertAppInfo.advertAppContext.pn));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VrPlayerActivityConfig(AdCardVrVideoView.this.getContext(), 1, false, videoInfo.video_url)));
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        return this.iJX;
    }
}
