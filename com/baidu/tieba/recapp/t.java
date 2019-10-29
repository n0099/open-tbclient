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
    private List<AppData> iIa;

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId) {
        if (nVar != null && bdUniqueId == AdvertAppInfo.bWT) {
            return new com.baidu.tieba.recapp.b.e(nVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        if (baseActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.bXc) {
            return new com.baidu.tieba.recapp.b.k(baseActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.bWY) {
            return new com.baidu.tieba.recapp.b.i(baseActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.bWZ) {
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
    public j cfF() {
        return b.cfv();
    }

    @Override // com.baidu.tieba.recapp.o
    public l cfG() {
        return b.cfv();
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.tieba.p.a cfH() {
        return com.baidu.tieba.ad.statis.a.aDW();
    }

    @Override // com.baidu.tieba.recapp.o
    public h cfI() {
        return com.baidu.tieba.ad.a.aDy();
    }

    @Override // com.baidu.tieba.recapp.o
    public List<AppData> cfJ() {
        if (this.iIa == null) {
            this.iIa = new ArrayList();
        }
        return this.iIa;
    }

    @Override // com.baidu.tieba.recapp.o
    public void cfK() {
        AdDebugService.updateFloatView(this.iIa != null ? StringUtils.string(Integer.valueOf(this.iIa.size())) : "0");
    }
}
