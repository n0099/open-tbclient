package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ex;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao etF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.etF = aoVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void d(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.j jVar;
        PostData postData;
        com.baidu.tieba.pb.data.j jVar2;
        com.baidu.tieba.pb.data.j jVar3;
        PostData postData2;
        PostData postData3;
        PostData postData4;
        com.baidu.tieba.pb.data.j jVar4;
        com.baidu.tieba.pb.data.j jVar5;
        com.baidu.tieba.pb.data.j jVar6;
        jVar = this.etF.erT;
        if (jVar != null) {
            postData = this.etF.egv;
            if (postData != null) {
                jVar2 = this.etF.erT;
                if (jVar2.aKb() != null) {
                    jVar3 = this.etF.erT;
                    if (jVar3.Kn() != null) {
                        postData2 = this.etF.egv;
                        if (postData2.biw() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            postData3 = this.etF.egv;
                            long templateId = postData3.biw().getTemplateId();
                            postData4 = this.etF.egv;
                            String bhT = postData4.biw().bhT();
                            jVar4 = this.etF.erT;
                            String id = jVar4.aKb().getId();
                            jVar5 = this.etF.erT;
                            String name = jVar5.aKb().getName();
                            jVar6 = this.etF.erT;
                            com.baidu.tieba.pb.b.a(templateId, bhT, str, "PB", str2, str3, "tpoint", str4, str5, id, name, jVar6.Kn().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aIZ() {
        PostData postData;
        PostData postData2;
        postData = this.etF.egv;
        if (ex.g(postData)) {
            postData2 = this.etF.egv;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> bhQ = postData2.biw().bhQ();
            if (bhQ == null) {
                return 0;
            }
            return bhQ.size();
        }
        return 0;
    }
}
