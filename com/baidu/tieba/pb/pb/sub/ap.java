package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.fl;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements b.a {
    final /* synthetic */ ao erD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.erD = aoVar;
    }

    @Override // com.baidu.tieba.pb.b.a
    public void d(String str, String str2, String str3, String str4, String str5) {
        com.baidu.tieba.pb.data.l lVar;
        PostData postData;
        com.baidu.tieba.pb.data.l lVar2;
        com.baidu.tieba.pb.data.l lVar3;
        PostData postData2;
        PostData postData3;
        PostData postData4;
        com.baidu.tieba.pb.data.l lVar4;
        com.baidu.tieba.pb.data.l lVar5;
        com.baidu.tieba.pb.data.l lVar6;
        lVar = this.erD.epO;
        if (lVar != null) {
            postData = this.erD.edM;
            if (postData != null) {
                lVar2 = this.erD.epO;
                if (lVar2.aIx() != null) {
                    lVar3 = this.erD.epO;
                    if (lVar3.JB() != null) {
                        postData2 = this.erD.edM;
                        if (postData2.bgU() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                            postData3 = this.erD.edM;
                            long templateId = postData3.bgU().getTemplateId();
                            postData4 = this.erD.edM;
                            String bgr = postData4.bgU().bgr();
                            lVar4 = this.erD.epO;
                            String id = lVar4.aIx().getId();
                            lVar5 = this.erD.epO;
                            String name = lVar5.aIx().getName();
                            lVar6 = this.erD.epO;
                            com.baidu.tieba.pb.b.a(templateId, bgr, str, "PB", str2, str3, "tpoint", str4, str5, id, name, lVar6.JB().getTid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.a
    public int aHh() {
        PostData postData;
        PostData postData2;
        postData = this.erD.edM;
        if (fl.h(postData)) {
            postData2 = this.erD.edM;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> bgo = postData2.bgU().bgo();
            if (bgo == null) {
                return 0;
            }
            return bgo.size();
        }
        return 0;
    }
}
