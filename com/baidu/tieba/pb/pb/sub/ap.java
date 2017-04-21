package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ex;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao evV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.evV = aoVar;
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
        jVar = this.evV.eul;
        if (jVar != null) {
            postData = this.evV.eiL;
            if (postData != null) {
                jVar2 = this.evV.eul;
                if (jVar2.aLc() != null) {
                    jVar3 = this.evV.eul;
                    if (jVar3.Kn() != null) {
                        postData2 = this.evV.eiL;
                        if (postData2.bjx() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            postData3 = this.evV.eiL;
                            long templateId = postData3.bjx().getTemplateId();
                            postData4 = this.evV.eiL;
                            String biU = postData4.bjx().biU();
                            jVar4 = this.evV.eul;
                            String id = jVar4.aLc().getId();
                            jVar5 = this.evV.eul;
                            String name = jVar5.aLc().getName();
                            jVar6 = this.evV.eul;
                            com.baidu.tieba.pb.b.a(templateId, biU, str, "PB", str2, str3, "tpoint", str4, str5, id, name, jVar6.Kn().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aKa() {
        PostData postData;
        PostData postData2;
        postData = this.evV.eiL;
        if (ex.g(postData)) {
            postData2 = this.evV.eiL;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> biR = postData2.bjx().biR();
            if (biR == null) {
                return 0;
            }
            return biR.size();
        }
        return 0;
    }
}
