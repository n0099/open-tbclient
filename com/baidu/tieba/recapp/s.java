package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.request.ShowStatisticUploadRequest;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class s implements n {
    private List<AppData> kKD;

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.adp.widget.ListView.a<?, ?> a(m mVar, BdUniqueId bdUniqueId) {
        if (mVar != null && bdUniqueId == AdvertAppInfo.dAd) {
            return new com.baidu.tieba.recapp.b.e(mVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.dAm) {
            return new com.baidu.tieba.recapp.b.k(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.dAi) {
            return new com.baidu.tieba.recapp.b.i(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.dAj) {
            return new com.baidu.tieba.recapp.b.a(tbPageContext, bdUniqueId);
        }
        if (bdUniqueId != null) {
            return new com.baidu.tieba.recapp.b.c(tbPageContext, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.n
    public void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // com.baidu.tieba.recapp.n
    public i cUw() {
        return a.cUn();
    }

    @Override // com.baidu.tieba.recapp.n
    public k cUx() {
        return a.cUn();
    }

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.tieba.r.a cUy() {
        return com.baidu.tieba.ad.statis.a.bmR();
    }

    @Override // com.baidu.tieba.recapp.n
    public g cUz() {
        return com.baidu.tieba.ad.a.bmu();
    }

    @Override // com.baidu.tieba.recapp.n
    public List<AppData> cUA() {
        if (this.kKD == null) {
            this.kKD = new ArrayList();
        }
        return this.kKD;
    }

    @Override // com.baidu.tieba.recapp.n
    public void cUB() {
        AdDebugService.updateFloatView(this.kKD != null ? StringUtils.string(Integer.valueOf(this.kKD.size())) : "0");
    }
}
