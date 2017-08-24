package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class r {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (al.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(se(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (al.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(sd(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (al.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(sf(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        new c(sg(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        com.baidu.adp.lib.cache.l<String> cT = com.baidu.tbadk.core.c.a.to().cT("bottom_write_story");
        if (writeData != null && writeData.hasContentToSave()) {
            cT.b(sg(str), writeData.toDraftString(), 86400000L);
        } else {
            cT.ae(sg(str));
        }
    }

    public static void a(String str, String str2, a aVar) {
        if (al.isEmpty(str) || al.isEmpty(str2)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(ci(str, str2), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, WriteData writeData) {
        if (!al.isEmpty(str) && !al.isEmpty(str2)) {
            com.baidu.adp.lib.cache.l<String> cT = com.baidu.tbadk.core.c.a.to().cT("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cT.b(ci(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cT.ae(ci(str, str2));
            }
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!al.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.r.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cT = com.baidu.tbadk.core.c.a.to().cT("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cT.a(r.sf(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cT.remove(r.sf(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!al.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.r.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cT = com.baidu.tbadk.core.c.a.to().cT("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cT.a(r.se(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cT.remove(r.se(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!al.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.r.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cT = com.baidu.tbadk.core.c.a.to().cT("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cT.a(r.sd(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cT.remove(r.sd(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String sd(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String se(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String sf(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String sg(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@story" + str;
    }

    protected static String ci(String str, String str2) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs" + str + "_" + str2;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a giJ;

        public b(String str, a aVar) {
            setPriority(3);
            this.giJ = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.to().cT("tb.pb_editor").get(this.cacheKey);
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
            if (this.giJ != null) {
                this.giJ.a(writeData);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class c extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a giJ;

        public c(String str, a aVar) {
            setPriority(3);
            this.giJ = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.to().cT("bottom_write_story").get(this.cacheKey);
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
            if (this.giJ != null) {
                this.giJ.a(writeData);
            }
        }
    }
}
