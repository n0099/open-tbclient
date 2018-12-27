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
    private List<AppData> gOr;

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId) {
        if (nVar != null && bdUniqueId == AdvertAppInfo.aoY) {
            return new com.baidu.tieba.recapp.b.e(nVar, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        if (baseActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.aph) {
            return new com.baidu.tieba.recapp.b.k(baseActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.apd) {
            return new com.baidu.tieba.recapp.b.i(baseActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.ape) {
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
    public j bve() {
        return b.buU();
    }

    @Override // com.baidu.tieba.recapp.o
    public l bvf() {
        return b.buU();
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.tieba.p.a bvg() {
        return com.baidu.tieba.ad.statis.a.Wp();
    }

    @Override // com.baidu.tieba.recapp.o
    public h bvh() {
        return com.baidu.tieba.ad.a.Wi();
    }

    @Override // com.baidu.tieba.recapp.o
    public List<AppData> bvi() {
        if (this.gOr == null) {
            this.gOr = new ArrayList();
        }
        return this.gOr;
    }

    @Override // com.baidu.tieba.recapp.o
    public void bvj() {
        AdDebugService.updateFloatView(this.gOr != null ? StringUtils.string(Integer.valueOf(this.gOr.size())) : "0");
    }
}
