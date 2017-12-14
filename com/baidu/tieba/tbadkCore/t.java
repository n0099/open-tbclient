package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class t {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (am.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(sZ(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (am.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(sY(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (am.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(ta(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        new c(tb(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        com.baidu.adp.lib.cache.l<String> cP = com.baidu.tbadk.core.c.a.td().cP("bottom_write_story");
        if (writeData != null && writeData.hasContentToSave()) {
            cP.b(tb(str), writeData.toDraftString(), 86400000L);
        } else {
            cP.X(tb(str));
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!am.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cP = com.baidu.tbadk.core.c.a.td().cP("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cP.a(t.ta(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cP.remove(t.ta(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!am.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cP = com.baidu.tbadk.core.c.a.td().cP("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cP.a(t.sZ(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cP.remove(t.sZ(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!am.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cP = com.baidu.tbadk.core.c.a.td().cP("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cP.a(t.sY(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cP.remove(t.sY(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String sY(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String sZ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String ta(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String tb(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@story" + str;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a gAR;

        public b(String str, a aVar) {
            setPriority(3);
            this.gAR = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.td().cP("tb.pb_editor").get(this.cacheKey);
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
            if (this.gAR != null) {
                this.gAR.a(writeData);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class c extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a gAR;

        public c(String str, a aVar) {
            setPriority(3);
            this.gAR = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.td().cP("bottom_write_story").get(this.cacheKey);
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
            if (this.gAR != null) {
                this.gAR.a(writeData);
            }
        }
    }
}
