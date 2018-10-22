package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.request.ShowStatisticUploadRequest;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class t implements o {
    private List<AppData> gDj;

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId) {
        if (nVar != null && bdUniqueId == AdvertAppInfo.akK) {
            return new com.baidu.tieba.recapp.b.e(nVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        if (baseActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.akT) {
            return new com.baidu.tieba.recapp.b.k(baseActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.akP) {
            return new com.baidu.tieba.recapp.b.i(baseActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.akQ) {
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
    public j bte() {
        return b.bsU();
    }

    @Override // com.baidu.tieba.recapp.o
    public l btf() {
        return b.bsU();
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.tieba.p.a btg() {
        return com.baidu.tieba.ad.statis.a.UY();
    }

    @Override // com.baidu.tieba.recapp.o
    public h bth() {
        return com.baidu.tieba.ad.a.UR();
    }

    @Override // com.baidu.tieba.recapp.o
    public List<AppData> bti() {
        if (this.gDj == null) {
            this.gDj = new ArrayList();
        }
        return this.gDj;
    }

    @Override // com.baidu.tieba.recapp.o
    public void btj() {
        AdDebugService.updateFloatView(this.gDj != null ? StringUtils.string(Integer.valueOf(this.gDj.size())) : "0");
    }
}
