package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ad {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(lE(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(lD(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(lF(str), aVar).execute(new String[0]);
    }

    public static void a(int i, a aVar) {
        new b(lh(i), aVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            cr.b(lh(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            cr.ab(lh(i));
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!as.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cr.b(lF(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cr.ab(lF(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!as.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cr.b(lE(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cr.ab(lE(str));
            }
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!as.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cr.b(lD(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cr.ab(lD(str));
            }
        }
    }

    protected static String lD(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String lE(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String lF(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String lh(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final a cZI;
        private final String cacheKey;

        public b(String str, a aVar) {
            setPriority(3);
            this.cZI = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.sO().cr("tb.pb_editor").get(this.cacheKey);
            } catch (Exception e) {
                str = null;
            }
            return WriteData.fromDraftString(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(WriteData writeData) {
            super.onPostExecute(writeData);
            if (this.cZI != null) {
                this.cZI.a(writeData);
            }
        }
    }
}
