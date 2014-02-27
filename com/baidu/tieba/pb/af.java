package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private WriteData b;
    private com.baidu.tieba.util.ba c = null;
    private boolean d = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/add");
        this.c.a("anonymous", SocialConstants.FALSE);
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a(PushConstants.EXTRA_CONTENT, this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.g().ah() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.e(true);
        return this.c.l();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        AntiData antiData;
        String str2 = str;
        super.a((af) str2);
        this.a.closeLoadingDialog();
        this.a.u = null;
        if (this.c != null) {
            try {
                antiData = new AntiData();
                try {
                    antiData.parserJson(new JSONObject(str2).optJSONObject("anti_stat"));
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                antiData = null;
            }
            if (this.c.c()) {
                this.a.c();
                return;
            }
            int e3 = this.c.e();
            String i = this.c.i();
            if (e3 == 5 || e3 == 6) {
                com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
                bdVar.a(str2);
                if (!AntiHelper.c(antiData)) {
                    if (bdVar.b() == null) {
                        a(antiData, i);
                        return;
                    }
                    this.b.setVcodeMD5(bdVar.a());
                    this.b.setVcodeUrl(bdVar.b());
                    if (bdVar.c().equals("4")) {
                        NewVcodeActivity.a(this.a, this.b, 12006);
                        return;
                    } else {
                        VcodeActivity.a(this.a, this.b, 12006);
                        return;
                    }
                }
            }
            a(antiData, i);
        }
    }

    public af(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.a = imagePbActivity;
        this.b = null;
        this.b = writeData;
    }

    private void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.b.getForumName());
            antiData.setBlock_forum_id(this.b.getForumId());
            antiData.setUser_id(TiebaApplication.v());
            antiData.setUser_name(TiebaApplication.z());
            AntiHelper.a(this.a, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.IMAGE_PB);
            return;
        }
        this.a.showToast(str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.u = null;
        this.a.closeLoadingDialog();
        this.d = true;
        if (this.c != null) {
            this.c.j();
        }
        super.cancel(true);
    }
}
