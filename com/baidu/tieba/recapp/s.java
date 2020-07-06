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
    private List<AppData> ley;

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.adp.widget.ListView.a<?, ?> a(m mVar, BdUniqueId bdUniqueId) {
        if (mVar != null && bdUniqueId == AdvertAppInfo.dGu) {
            return new com.baidu.tieba.recapp.b.e(mVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.dGD) {
            return new com.baidu.tieba.recapp.b.k(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.dGz) {
            return new com.baidu.tieba.recapp.b.i(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.dGA) {
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
    public i cYN() {
        return a.cYE();
    }

    @Override // com.baidu.tieba.recapp.n
    public k cYO() {
        return a.cYE();
    }

    @Override // com.baidu.tieba.recapp.n
    public com.baidu.tieba.r.a cYP() {
        return com.baidu.tieba.ad.statis.a.bps();
    }

    @Override // com.baidu.tieba.recapp.n
    public g cYQ() {
        return com.baidu.tieba.ad.a.boU();
    }

    @Override // com.baidu.tieba.recapp.n
    public List<AppData> cYR() {
        if (this.ley == null) {
            this.ley = new ArrayList();
        }
        return this.ley;
    }

    @Override // com.baidu.tieba.recapp.n
    public void cYS() {
        AdDebugService.updateFloatView(this.ley != null ? StringUtils.string(Integer.valueOf(this.ley.size())) : "0");
    }
}
