package com.baidu.tieba.pb.image;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ao;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.ai;
import com.baidu.tieba.util.AntiHelper;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ ImagePbActivity a;
    private WriteData b;
    private an c = null;
    private boolean d = false;

    public v(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.a = imagePbActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("new_vcode", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        this.c.a("content", this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (ai.c().z() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.a().a().a = true;
        return this.c.i();
    }

    private void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.b.getForumName());
            antiData.setBlock_forum_id(this.b.getForumId());
            antiData.setUser_id(TbadkApplication.getCurrentAccount());
            antiData.setUser_name(TbadkApplication.getCurrentAccountName());
            AntiHelper.a(this.a, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.IMAGE_PB);
            return;
        }
        this.a.showToast(str);
    }

    private void a(int i, String str, String str2, AntiData antiData) {
        if (i == 5 || i == 6) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.a(str2);
            if (AntiHelper.c(antiData)) {
                a(antiData, str);
                return;
            } else if (fVar.b() != null) {
                this.b.setVcodeMD5(fVar.a());
                this.b.setVcodeUrl(fVar.b());
                if (fVar.c().equals("4")) {
                    if (this.b != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new ao(this.a, 12006, this.b, false)));
                        return;
                    }
                    return;
                } else if (this.b != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bg(this.a, this.b, 12006)));
                    return;
                } else {
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
    /* renamed from: a */
    public void onPostExecute(String str) {
        AntiData antiData;
        super.onPostExecute(str);
        this.a.closeLoadingDialog();
        this.a.t = null;
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
            if (!this.c.a().b().b()) {
                a(this.c.d(), this.c.f(), str, antiData);
            } else {
                this.a.h();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.t = null;
        this.a.closeLoadingDialog();
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
