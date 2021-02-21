package com.baidu.tieba.recapp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.request.ShowStatisticUploadRequest;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class u implements r {
    private List<AppData> mRP;

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.adp.widget.ListView.a<?, ?> a(q qVar, BdUniqueId bdUniqueId) {
        if (qVar == null || bdUniqueId == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.eLa) {
            return new com.baidu.tieba.recapp.adapter.c(qVar, bdUniqueId);
        }
        return new com.baidu.tieba.recapp.adapter.d(qVar, bdUniqueId);
    }

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.eLj) {
            return new com.baidu.tieba.recapp.adapter.f(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.eLf) {
            return new com.baidu.tieba.recapp.adapter.e(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.adp.widget.ListView.a<?, ?> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId == AdvertAppInfo.eLg) {
            return new com.baidu.tieba.recapp.adapter.a(tbPageContext, bdUniqueId, str);
        }
        if (bdUniqueId != null) {
            return new com.baidu.tieba.recapp.adapter.b(tbPageContext, bdUniqueId, str);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // com.baidu.tieba.recapp.r
    public void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // com.baidu.tieba.recapp.r
    public m dDn() {
        return c.dDe();
    }

    @Override // com.baidu.tieba.recapp.r
    public o dDo() {
        return c.dDe();
    }

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.tieba.r.a dDp() {
        return com.baidu.tieba.ad.statis.a.bLM();
    }

    @Override // com.baidu.tieba.recapp.r
    public j dDq() {
        return com.baidu.tieba.ad.a.bLn();
    }

    @Override // com.baidu.tieba.recapp.r
    public List<AppData> dDr() {
        if (this.mRP == null) {
            this.mRP = new ArrayList();
        }
        return this.mRP;
    }

    @Override // com.baidu.tieba.recapp.r
    public void dDs() {
        AdDebugService.updateFloatView(this.mRP != null ? StringUtils.string(Integer.valueOf(this.mRP.size())) : "0");
    }

    @Override // com.baidu.tieba.recapp.r
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
                AdWebVideoActivity.a(advertAppInfo, 0, "DETAIL");
                String Rw = t.Rw(adCard.getScheme());
                Bundle bundle = new Bundle();
                bundle.putString("video_url", videoInfo.video_url);
                bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, videoInfo.thumbnail_url);
                bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, videoInfo.video_width.intValue() / videoInfo.video_height.intValue());
                bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration.intValue());
                String str = TextUtils.isEmpty(advertAppInfo.eLw) ? advertAppInfo.eLt : advertAppInfo.eLw;
                if (advertAppInfo.blF()) {
                    str = "";
                }
                bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str);
                bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, adCard.goodsStyle);
                if (adCard.tailFrame != null) {
                    adCard.tailFrame.buttonText = adCard.buttonText;
                    bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, adCard.tailFrame.toJsonString());
                }
                AdWebVideoActivity.a(new AdWebVideoActivityConfig(context, "", Rw, true, true, true, bundle));
            }
        }
    }

    @Override // com.baidu.tieba.recapp.r
    public i a(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        if (iLegoAdvert instanceof AdCard) {
            return new com.baidu.tieba.recapp.lego.view.a.c(tbPageContext, iLegoAdvert, i, z, str, str2);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public App a(App app, Cmatch cmatch) {
        return com.baidu.tieba.ad.a.a.bLI().a(app, cmatch);
    }
}
