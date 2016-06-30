package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class af {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ba.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(pA(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ba.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(pz(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ba.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(pB(str), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, a aVar) {
        if (ba.isEmpty(str) || ba.isEmpty(str2)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(bK(str, str2), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, WriteData writeData) {
        if (!ba.isEmpty(str) && !ba.isEmpty(str2)) {
            com.baidu.adp.lib.cache.o<String> cw = com.baidu.tbadk.core.b.a.rP().cw("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cw.b(bK(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cw.R(bK(str, str2));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ba.isEmpty(str)) {
            new ag(writeData, str).execute(new Void[0]);
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!ba.isEmpty(str)) {
            new ah(writeData, str).execute(new Void[0]);
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!ba.isEmpty(str)) {
            new ai(writeData, str).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String pz(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String pA(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String pB(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String bK(String str, String str2) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a eWx;

        public b(String str, a aVar) {
            setPriority(3);
            this.eWx = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.rP().cw("tb.pb_editor").get(this.cacheKey);
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
            if (this.eWx != null) {
                this.eWx.a(writeData);
            }
        }
    }
}
