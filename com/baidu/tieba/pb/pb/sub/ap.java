package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ez;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao evz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.evz = aoVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void c(String str, String str2, String str3, String str4, String str5) {
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
        jVar = this.evz.etQ;
        if (jVar != null) {
            postData = this.evz.eio;
            if (postData != null) {
                jVar2 = this.evz.etQ;
                if (jVar2.aJU() != null) {
                    jVar3 = this.evz.etQ;
                    if (jVar3.JN() != null) {
                        postData2 = this.evz.eio;
                        if (postData2.bhL() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            postData3 = this.evz.eio;
                            long templateId = postData3.bhL().getTemplateId();
                            postData4 = this.evz.eio;
                            String bhi = postData4.bhL().bhi();
                            jVar4 = this.evz.etQ;
                            String id = jVar4.aJU().getId();
                            jVar5 = this.evz.etQ;
                            String name = jVar5.aJU().getName();
                            jVar6 = this.evz.etQ;
                            com.baidu.tieba.pb.b.a(templateId, bhi, str, "PB", str2, str3, "tpoint", str4, str5, id, name, jVar6.JN().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aIS() {
        PostData postData;
        PostData postData2;
        postData = this.evz.eio;
        if (ez.g(postData)) {
            postData2 = this.evz.eio;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> bhf = postData2.bhL().bhf();
            if (bhf == null) {
                return 0;
            }
            return bhf.size();
        }
        return 0;
    }
}
