package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class z {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(pJ(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(pI(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(pK(str), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, a aVar) {
        if (au.isEmpty(str) || au.isEmpty(str2)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(bZ(str, str2), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, WriteData writeData) {
        if (!au.isEmpty(str) && !au.isEmpty(str2)) {
            com.baidu.adp.lib.cache.o<String> cu = com.baidu.tbadk.core.c.a.to().cu("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cu.b(bZ(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cu.T(bZ(str, str2));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            new aa(writeData, str).execute(new Void[0]);
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            new ab(writeData, str).execute(new Void[0]);
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            new ac(writeData, str).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String pI(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String pJ(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String pK(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String bZ(String str, String str2) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a fti;

        public b(String str, a aVar) {
            setPriority(3);
            this.fti = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.to().cu("tb.pb_editor").get(this.cacheKey);
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
            if (this.fti != null) {
                this.fti.a(writeData);
            }
        }
    }
}
