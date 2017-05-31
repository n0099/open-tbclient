package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao eyO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.eyO = aoVar;
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
        nVar = this.eyO.ewW;
        if (nVar != null) {
            postData = this.eyO.ejm;
            if (postData != null) {
                nVar2 = this.eyO.ewW;
                if (nVar2.aJp() != null) {
                    nVar3 = this.eyO.ewW;
                    if (nVar3.LH() != null) {
                        postData2 = this.eyO.ejm;
                        if (postData2.bio() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            postData3 = this.eyO.ejm;
                            long templateId = postData3.bio().getTemplateId();
                            postData4 = this.eyO.ejm;
                            String bhO = postData4.bio().bhO();
                            nVar4 = this.eyO.ewW;
                            String id = nVar4.aJp().getId();
                            nVar5 = this.eyO.ewW;
                            String name = nVar5.aJp().getName();
                            nVar6 = this.eyO.ewW;
                            com.baidu.tieba.pb.b.a(templateId, bhO, str, "PB", str2, str3, "tpoint", str4, str5, id, name, nVar6.LH().getTid());
                        }
                    }
                }
            }
        }
    }
}
