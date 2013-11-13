package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
public class ae extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2062a;
    private WriteData b;
    private com.baidu.tieba.util.ap c = null;
    private boolean d = false;

    public ae(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.f2062a = imagePbActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/post/add");
        this.c.a("anonymous", SocialConstants.FALSE);
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a("content", this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.g().as() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.e(true);
        return this.c.j();
    }

    private void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.b.getForumName());
            antiData.setBlock_forum_id(this.b.getForumId());
            antiData.setUser_id(TiebaApplication.A());
            antiData.setUser_name(TiebaApplication.F());
            AntiHelper.a(this.f2062a, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.IMAGE_PB);
            return;
        }
        this.f2062a.showToast(str);
    }

    private void a(int i, String str, String str2, AntiData antiData) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.data.be beVar = new com.baidu.tieba.data.be();
            beVar.a(str2);
            if (AntiHelper.c(antiData)) {
                a(antiData, str);
                return;
            } else if (beVar.b() != null) {
                this.b.setVcodeMD5(beVar.a());
                this.b.setVcodeUrl(beVar.b());
                if (beVar.c().equals("4")) {
                    NewVcodeActivity.a(this.f2062a, this.b, 12006);
                    return;
                } else {
                    VcodeActivity.a(this.f2062a, this.b, 12006);
                    return;
                }
            } else {
                a(antiData, str);
                return;
            }
        }
        a(antiData, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        AntiData antiData;
        super.a((ae) str);
        this.f2062a.closeLoadingDialog();
        this.f2062a.u = null;
        if (this.c != null) {
            try {
                antiData = new AntiData();
                try {
                    antiData.parserJson(new JSONObject(str).optJSONObject("anti_stat"));
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                antiData = null;
            }
            if (this.c.c()) {
                this.f2062a.h();
            } else {
                a(this.c.e(), this.c.g(), str, antiData);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2062a.u = null;
        this.f2062a.closeLoadingDialog();
        this.d = true;
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }
}
