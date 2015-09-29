package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ad {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(lx(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(lw(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(ly(str), aVar).execute(new String[0]);
    }

    public static void a(int i, a aVar) {
        new b(kR(i), aVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.o<String> cq = com.baidu.tbadk.core.b.a.sO().cq("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            cq.b(kR(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            cq.ad(kR(i));
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ar.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cq = com.baidu.tbadk.core.b.a.sO().cq("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cq.b(ly(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cq.ad(ly(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!ar.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cq = com.baidu.tbadk.core.b.a.sO().cq("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cq.b(lx(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cq.ad(lx(str));
            }
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!ar.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cq = com.baidu.tbadk.core.b.a.sO().cq("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cq.b(lw(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cq.ad(lw(str));
            }
        }
    }

    protected static String lw(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String lx(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String ly(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String kR(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final a cXL;
        private final String cacheKey;

        public b(String str, a aVar) {
            setPriority(3);
            this.cXL = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.sO().cq("tb.pb_editor").get(this.cacheKey);
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
            if (this.cXL != null) {
                this.cXL.a(writeData);
            }
        }
    }
}
