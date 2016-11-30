package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ad {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(rD(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(rC(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(rE(str), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, a aVar) {
        if (ax.isEmpty(str) || ax.isEmpty(str2)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(bT(str, str2), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, WriteData writeData) {
        if (!ax.isEmpty(str) && !ax.isEmpty(str2)) {
            com.baidu.adp.lib.cache.o<String> cC = com.baidu.tbadk.core.b.a.tm().cC("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cC.b(bT(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cC.U(bT(str, str2));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            new ae(writeData, str).execute(new Void[0]);
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            new af(writeData, str).execute(new Void[0]);
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            new ag(writeData, str).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String rC(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String rD(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String rE(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String bT(String str, String str2) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a fBm;

        public b(String str, a aVar) {
            setPriority(3);
            this.fBm = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.tm().cC("tb.pb_editor").get(this.cacheKey);
            } catch (Exception e) {
                str = null;
            }
            return WriteData.fromDraftString(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(WriteData writeData) {
            super.onPostExecute(writeData);
            if (this.fBm != null) {
                this.fBm.a(writeData);
            }
        }
    }
}
