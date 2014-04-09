package com.baidu.tieba.pb.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.au;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.util.AntiHelper;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private WriteData b;
    private ak c = null;
    private boolean d = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("new_vcode", "1");
        this.c.a("content", this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (com.baidu.tieba.p.c().u() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.a().a().a = true;
        return this.c.i();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        AntiData antiData;
        String str2 = str;
        super.a((v) str2);
        this.a.closeLoadingDialog();
        this.a.t = null;
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
            if (this.c.a().b().b()) {
                this.a.c();
                return;
            }
            int d = this.c.d();
            String f = this.c.f();
            if (d == 5 || d == 6) {
                com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                fVar.a(str2);
                if (!AntiHelper.c(antiData)) {
                    if (fVar.b() == null) {
                        a(antiData, f);
                        return;
                    }
                    this.b.setVcodeMD5(fVar.a());
                    this.b.setVcodeUrl(fVar.b());
                    if (fVar.c().equals("4")) {
                        if (this.b != null) {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ac(this.a, 12006, this.b, false)));
                            return;
                        }
                        return;
                    } else if (this.b != null) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new au(this.a, this.b, 12006)));
                        return;
                    } else {
                        return;
                    }
                }
            }
            a(antiData, f);
        }
    }

    public v(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.a = imagePbActivity;
        this.b = null;
        this.b = writeData;
    }

    private void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.b.getForumName());
            antiData.setBlock_forum_id(this.b.getForumId());
            antiData.setUser_id(TbadkApplication.E());
            antiData.setUser_name(TbadkApplication.O());
            AntiHelper.a(this.a, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.IMAGE_PB);
            return;
        }
        this.a.showToast(str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.t = null;
        this.a.closeLoadingDialog();
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
