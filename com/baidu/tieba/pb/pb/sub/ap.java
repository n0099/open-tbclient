package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao eIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.eIl = aoVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void d(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.n nVar;
        PostData postData;
        com.baidu.tieba.pb.data.n nVar2;
        com.baidu.tieba.pb.data.n nVar3;
        PostData postData2;
        PostData postData3;
        PostData postData4;
        com.baidu.tieba.pb.data.n nVar4;
        com.baidu.tieba.pb.data.n nVar5;
        com.baidu.tieba.pb.data.n nVar6;
        nVar = this.eIl.eGs;
        if (nVar != null) {
            postData = this.eIl.esk;
            if (postData != null) {
                nVar2 = this.eIl.eGs;
                if (nVar2.aNj() != null) {
                    nVar3 = this.eIl.eGs;
                    if (nVar3.Mv() != null) {
                        postData2 = this.eIl.esk;
                        if (postData2.bmC() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            postData3 = this.eIl.esk;
                            long templateId = postData3.bmC().getTemplateId();
                            postData4 = this.eIl.esk;
                            String bmc = postData4.bmC().bmc();
                            nVar4 = this.eIl.eGs;
                            String id = nVar4.aNj().getId();
                            nVar5 = this.eIl.eGs;
                            String name = nVar5.aNj().getName();
                            nVar6 = this.eIl.eGs;
                            com.baidu.tieba.pb.b.a(templateId, bmc, str, "PB", str2, str3, "tpoint", str4, str5, id, name, nVar6.Mv().getTid());
                        }
                    }
                }
            }
        }
    }
}
