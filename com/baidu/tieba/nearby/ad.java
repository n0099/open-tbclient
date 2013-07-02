package com.baidu.tieba.nearby;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask {
    final /* synthetic */ NearbyPbActivity a;
    private com.baidu.tieba.util.r b = null;
    private boolean c = false;

    public ad(NearbyPbActivity nearbyPbActivity, WriteModel writeModel) {
        this.a = nearbyPbActivity;
        nearbyPbActivity.A = writeModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        WriteModel writeModel;
        WriteModel writeModel2;
        WriteModel writeModel3;
        WriteModel writeModel4;
        WriteModel writeModel5;
        WriteModel writeModel6;
        WriteModel writeModel7;
        WriteModel writeModel8;
        WriteModel writeModel9;
        if (this.c) {
            return null;
        }
        this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/post/add");
        this.b.a("anonymous", "0");
        com.baidu.tieba.util.r rVar = this.b;
        writeModel = this.a.A;
        rVar.a("fid", writeModel.getForumId());
        com.baidu.tieba.util.r rVar2 = this.b;
        writeModel2 = this.a.A;
        rVar2.a("kw", writeModel2.getForumName());
        com.baidu.tieba.util.r rVar3 = this.b;
        writeModel3 = this.a.A;
        rVar3.a(PushConstants.EXTRA_CONTENT, writeModel3.getContent());
        com.baidu.tieba.util.r rVar4 = this.b;
        writeModel4 = this.a.A;
        rVar4.a("tid", writeModel4.getThreadId());
        writeModel5 = this.a.A;
        if (writeModel5.getVcode() != null) {
            writeModel8 = this.a.A;
            if (writeModel8.getVcode().length() > 0) {
                com.baidu.tieba.util.r rVar5 = this.b;
                writeModel9 = this.a.A;
                rVar5.a("vcode", writeModel9.getVcode());
            }
        }
        com.baidu.tieba.util.r rVar6 = this.b;
        writeModel6 = this.a.A;
        rVar6.a("quote_id", writeModel6.getFloor());
        com.baidu.tieba.util.r rVar7 = this.b;
        writeModel7 = this.a.A;
        rVar7.a("floor_num", String.valueOf(writeModel7.getFloorNum()));
        this.b.d(true);
        return this.b.j();
    }

    private void a(int i, String str, String str2) {
        WriteModel writeModel;
        WriteModel writeModel2;
        WriteModel writeModel3;
        if (i == 5 || i == 6) {
            com.baidu.tieba.data.be beVar = new com.baidu.tieba.data.be();
            beVar.a(str2);
            if (beVar.b() != null) {
                writeModel = this.a.A;
                writeModel.setVcodeMD5(beVar.a());
                writeModel2 = this.a.A;
                writeModel2.setVcodeUrl(beVar.b());
                NearbyPbActivity nearbyPbActivity = this.a;
                writeModel3 = this.a.A;
                VcodeActivity.a(nearbyPbActivity, writeModel3, 1200006);
                return;
            }
            this.a.a(str);
            return;
        }
        this.a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((Object) str);
        this.a.h();
        this.a.k = null;
        if (this.b != null) {
            if (this.b.c()) {
                this.a.u();
            } else {
                a(this.b.e(), this.b.g(), str);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.k = null;
        this.a.h();
        this.c = true;
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }
}
