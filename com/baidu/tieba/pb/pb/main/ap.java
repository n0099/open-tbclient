package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.ew;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes.dex */
class ap implements ew.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.ew.a
    public void ci(List<PostData> list) {
        PbModel pbModel;
        gg ggVar;
        PbModel pbModel2;
        gg ggVar2;
        gg ggVar3;
        gg ggVar4;
        PbModel pbModel3;
        PbModel pbModel4;
        PbModel pbModel5;
        PbModel pbModel6;
        pbModel = this.ewh.eue;
        if (pbModel.getPbData().aMF() != null) {
            pbModel3 = this.ewh.eue;
            List<PostData> list2 = pbModel3.getPbData().aMF().ess;
            int size = list2.size();
            if (!com.baidu.tbadk.core.util.z.t(list2)) {
                pbModel6 = this.ewh.eue;
                pbModel6.getPbData().aMF().ess.addAll(size, list);
            }
            pbModel4 = this.ewh.eue;
            pbModel5 = this.ewh.eue;
            pbModel4.a(pbModel5.getPbData(), size);
        }
        ggVar = this.ewh.euU;
        dc aQs = ggVar.aQs();
        pbModel2 = this.ewh.eue;
        aQs.a(pbModel2.getPbData(), true);
        ggVar2 = this.ewh.euU;
        if (ggVar2 != null) {
            ggVar3 = this.ewh.euU;
            if (ggVar3.aQs() != null) {
                ggVar4 = this.ewh.euU;
                ggVar4.aQs().notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.ew.a
    public void h(int i, String str, String str2) {
        gg ggVar;
        if (!StringUtils.isNull(str)) {
            ggVar = this.ewh.euU;
            ggVar.showToast(str);
        }
    }
}
