package com.baidu.tieba.recapp;

import android.content.Context;
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
public class t implements o {
    private List<AppData> lLt;

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId) {
        if (nVar != null && bdUniqueId == AdvertAppInfo.dYc) {
            return new com.baidu.tieba.recapp.b.e(nVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.dYl) {
            return new com.baidu.tieba.recapp.b.k(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.dYh) {
            return new com.baidu.tieba.recapp.b.i(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.dYi) {
            return new com.baidu.tieba.recapp.b.a(tbPageContext, bdUniqueId);
        }
        if (bdUniqueId != null) {
            return new com.baidu.tieba.recapp.b.c(tbPageContext, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // com.baidu.tieba.recapp.o
    public j dqO() {
        return a.dqF();
    }

    @Override // com.baidu.tieba.recapp.o
    public l dqP() {
        return a.dqF();
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.tieba.r.a dqQ() {
        return com.baidu.tieba.ad.statis.a.bCE();
    }

    @Override // com.baidu.tieba.recapp.o
    public g dqR() {
        return com.baidu.tieba.ad.a.bCg();
    }

    @Override // com.baidu.tieba.recapp.o
    public List<AppData> dqS() {
        if (this.lLt == null) {
            this.lLt = new ArrayList();
        }
        return this.lLt;
    }

    @Override // com.baidu.tieba.recapp.o
    public void dqT() {
        AdDebugService.updateFloatView(this.lLt != null ? StringUtils.string(Integer.valueOf(this.lLt.size())) : "0");
    }

    @Override // com.baidu.tieba.recapp.o
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
                NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(context, "", s.PM(adCard.getScheme()), true, true, true, videoInfo.video_url, videoInfo.thumbnail_url, videoInfo.video_width.intValue() / videoInfo.video_height.intValue(), videoInfo.video_duration.intValue(), advertAppInfo.dYt);
                if (adCard.tailFrame != null) {
                    adCard.tailFrame.buttonText = adCard.buttonText;
                    newWebVideoActivityConfig.setTailFrame(adCard.tailFrame.toJsonString());
                }
                if (adCard != null) {
                    newWebVideoActivityConfig.setGoodStyle(adCard.goodsStyle);
                }
                NewWebVideoActivity.a(newWebVideoActivityConfig);
            }
        }
    }
}
