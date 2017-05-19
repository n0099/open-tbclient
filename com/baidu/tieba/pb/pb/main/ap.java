package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.ee;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes.dex */
class ap implements ee.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.ee.a
    public void onSuccess(List<PostData> list) {
        PbModel pbModel;
        fm fmVar;
        PbModel pbModel2;
        fm fmVar2;
        fm fmVar3;
        fm fmVar4;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        PbModel pbModel6;
        pbModel = this.ehy.efE;
        if (pbModel.getPbData().aHQ() != null) {
            pbModel3 = this.ehy.efE;
            List<PostData> list2 = pbModel3.getPbData().aHQ().edU;
            int size = list2.size();
            if (!com.baidu.tbadk.core.util.x.r(list2)) {
                pbModel6 = this.ehy.efE;
                pbModel6.getPbData().aHQ().edU.addAll(size, list);
            }
            pbModel4 = this.ehy.efE;
            pbModel5 = this.ehy.efE;
            pbModel4.a(pbModel5.getPbData(), size);
        }
        fmVar = this.ehy.egt;
        cq aLy = fmVar.aLy();
        pbModel2 = this.ehy.efE;
        aLy.a(pbModel2.getPbData(), true);
        fmVar2 = this.ehy.egt;
        if (fmVar2 != null) {
            fmVar3 = this.ehy.egt;
            if (fmVar3.aLy() != null) {
                fmVar4 = this.ehy.egt;
                fmVar4.aLy().notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.ee.a
    public void h(int i, String str, String str2) {
        fm fmVar;
        if (!StringUtils.isNull(str)) {
            fmVar = this.ehy.egt;
            fmVar.showToast(str);
        }
    }
}
