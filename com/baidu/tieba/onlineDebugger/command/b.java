package com.baidu.tieba.onlineDebugger.command;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
public class b implements h {
    private String msgContent;

    public b(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            this.msgContent = str.substring(indexOf + 1).trim();
        } else {
            this.msgContent = str;
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("send cmd msg content cannot be empty");
        }
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aCF() {
        if (this.msgContent.equals("-reboot")) {
            com.baidu.adp.lib.h.h.dM().postDelayed(new c(this), 2000L);
        }
        if (this.msgContent.equals("-startMain")) {
            com.baidu.adp.lib.h.h.dM().post(new d(this));
        }
        if (this.msgContent.equals("-clearCache")) {
            com.baidu.adp.lib.h.h.dM().post(new e(this));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: es */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().ag();
            com.baidu.tbadk.core.voice.a.b.vX();
            try {
                az.tY().tZ();
                az.tY().ua();
                MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_CLEARIMAGE, ""));
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aCG() {
        return !TextUtils.isEmpty(this.msgContent);
    }
}
