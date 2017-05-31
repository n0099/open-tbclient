package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class x {

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
        new b(qj(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(qi(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(qk(str), aVar).execute(new String[0]);
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
            com.baidu.adp.lib.cache.o<String> cy = com.baidu.tbadk.core.c.a.sY().cy("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cy.b(bZ(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cy.Q(bZ(str, str2));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            new y(writeData, str).execute(new Void[0]);
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            new z(writeData, str).execute(new Void[0]);
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            new aa(writeData, str).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String qi(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String qj(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String qk(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs";
    }

    protected static String bZ(String str, String str2) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str + "_" + str2;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a fBe;

        public b(String str, a aVar) {
            setPriority(3);
            this.fBe = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.sY().cy("tb.pb_editor").get(this.cacheKey);
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
            if (this.fBe != null) {
                this.fBe.a(writeData);
            }
        }
    }
}
