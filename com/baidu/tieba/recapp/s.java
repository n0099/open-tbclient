package com.baidu.tieba.recapp;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.request.ShowStatisticUploadRequest;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.ArrayList;
import java.util.List;
import tbclient.VideoInfo;
/* loaded from: classes25.dex */
public class s implements p {
    private List<AppData> mtw;

    @Override // com.baidu.tieba.recapp.p
    public com.baidu.adp.widget.ListView.a<?, ?> a(o oVar, BdUniqueId bdUniqueId) {
        if (oVar != null && bdUniqueId == AdvertAppInfo.ewL) {
            return new com.baidu.tieba.recapp.b.e(oVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.p
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.ewU) {
            return new com.baidu.tieba.recapp.b.k(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.ewQ) {
            return new com.baidu.tieba.recapp.b.i(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.p
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.ewR) {
            return new com.baidu.tieba.recapp.b.a(tbPageContext, bdUniqueId);
        }
        if (bdUniqueId != null) {
            return new com.baidu.tieba.recapp.b.c(tbPageContext, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.p
    public void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // com.baidu.tieba.recapp.p
    public k dzI() {
        return a.dzz();
    }

    @Override // com.baidu.tieba.recapp.p
    public m dzJ() {
        return a.dzz();
    }

    @Override // com.baidu.tieba.recapp.p
    public com.baidu.tieba.s.a dzK() {
        return com.baidu.tieba.ad.statis.a.bJb();
    }

    @Override // com.baidu.tieba.recapp.p
    public h dzL() {
        return com.baidu.tieba.ad.a.bIE();
    }

    @Override // com.baidu.tieba.recapp.p
    public List<AppData> dzM() {
        if (this.mtw == null) {
            this.mtw = new ArrayList();
        }
        return this.mtw;
    }

    @Override // com.baidu.tieba.recapp.p
    public void dzN() {
        AdDebugService.updateFloatView(this.mtw != null ? StringUtils.string(Integer.valueOf(this.mtw.size())) : "0");
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, Context context) {
        VideoInfo videoInfo;
        AdCard adCard;
        if (advertAppInfo != null) {
            if (advertAppInfo.legoCard instanceof AdCard) {
                AdCard adCard2 = (AdCard) advertAppInfo.legoCard;
                videoInfo = adCard2.videoInfo;
                adCard = adCard2;
            } else {
                videoInfo = null;
                adCard = null;
            }
            if (adCard != null && videoInfo != null) {
                NewWebVideoActivity.a(advertAppInfo, 0, "DETAIL");
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(context, "", r.QL(adCard.getScheme()), true, true, true, videoInfo.video_url, videoInfo.thumbnail_url, videoInfo.video_width.intValue() / videoInfo.video_height.intValue(), videoInfo.video_duration.intValue(), advertAppInfo.exf);
                if (adCard.tailFrame != null) {
                    adCard.tailFrame.buttonText = adCard.buttonText;
                    newWebVideoActivityConfig.setTailFrame(adCard.tailFrame.toJsonString());
                }
                newWebVideoActivityConfig.setGoodStyle(adCard.goodsStyle);
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.p
    public g a(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        if (iLegoAdvert instanceof AdCard) {
            return new com.baidu.tieba.recapp.lego.view.a.c(tbPageContext, iLegoAdvert, i, z, str, str2);
        }
        return null;
    }
}
