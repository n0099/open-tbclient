package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class t {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Cw(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Cv(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Cx(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Cy(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!ap.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                lv.b(Cy(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                lv.aG(Cy(str));
            }
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!ap.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        lv.a(t.Cx(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    lv.remove(t.Cx(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!ap.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        lv.a(t.Cw(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    lv.remove(t.Cw(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!ap.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> lv = com.baidu.tbadk.core.c.a.aaW().lv("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        lv.a(t.Cv(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    lv.remove(t.Cv(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String Cv(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String Cw(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Cx(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String Cy(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a iFm;

        public b(String str, a aVar) {
            setPriority(3);
            this.iFm = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.aaW().lv("tb.pb_editor").get(this.cacheKey);
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
            if (this.iFm != null) {
                this.iFm.a(writeData);
            }
        }
    }
}
