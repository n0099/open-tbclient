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
/* loaded from: classes11.dex */
public class t implements o {
    private List<AppData> jFd;

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId) {
        if (nVar != null && bdUniqueId == AdvertAppInfo.cIB) {
            return new com.baidu.tieba.recapp.b.e(nVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.cIK) {
            return new com.baidu.tieba.recapp.b.k(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.cIG) {
            return new com.baidu.tieba.recapp.b.i(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.cIH) {
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
    public j cAP() {
        return b.cAG();
    }

    @Override // com.baidu.tieba.recapp.o
    public l cAQ() {
        return b.cAG();
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.tieba.q.a cAR() {
        return com.baidu.tieba.ad.statis.a.aWg();
    }

    @Override // com.baidu.tieba.recapp.o
    public h cAS() {
        return com.baidu.tieba.ad.a.aVI();
    }

    @Override // com.baidu.tieba.recapp.o
    public List<AppData> cAT() {
        if (this.jFd == null) {
            this.jFd = new ArrayList();
        }
        return this.jFd;
    }

    @Override // com.baidu.tieba.recapp.o
    public void cAU() {
        AdDebugService.updateFloatView(this.jFd != null ? StringUtils.string(Integer.valueOf(this.jFd.size())) : "0");
    }
}
