package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.en;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes.dex */
class ap implements en.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.en.a
    public void onSuccess(List<PostData> list) {
        PbModel pbModel;
        fx fxVar;
        PbModel pbModel2;
        fx fxVar2;
        fx fxVar3;
        fx fxVar4;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        PbModel pbModel6;
        pbModel = this.enc.ele;
        if (pbModel.getPbData().aIL() != null) {
            pbModel3 = this.enc.ele;
            List<PostData> list2 = pbModel3.getPbData().aIL().eju;
            int size = list2.size();
            if (!com.baidu.tbadk.core.util.x.r(list2)) {
                pbModel6 = this.enc.ele;
                pbModel6.getPbData().aIL().eju.addAll(size, list);
            }
            pbModel4 = this.enc.ele;
            pbModel5 = this.enc.ele;
            pbModel4.a(pbModel5.getPbData(), size);
        }
        fxVar = this.enc.elU;
        cv aMu = fxVar.aMu();
        pbModel2 = this.enc.ele;
        aMu.a(pbModel2.getPbData(), true);
        fxVar2 = this.enc.elU;
        if (fxVar2 != null) {
            fxVar3 = this.enc.elU;
            if (fxVar3.aMu() != null) {
                fxVar4 = this.enc.elU;
                fxVar4.aMu().notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.en.a
    public void d(int i, String str, String str2) {
        fx fxVar;
        if (!StringUtils.isNull(str)) {
            fxVar = this.enc.elU;
            fxVar.showToast(str);
        }
    }
}
