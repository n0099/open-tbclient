package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class r {

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
        new b(rZ(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (am.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(rY(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (am.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(sa(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        new c(sb(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        com.baidu.adp.lib.cache.l<String> cJ = com.baidu.tbadk.core.c.a.tk().cJ("bottom_write_story");
        if (writeData != null && writeData.hasContentToSave()) {
            cJ.b(sb(str), writeData.toDraftString(), 86400000L);
        } else {
            cJ.X(sb(str));
        }
    }

    public static void a(String str, String str2, a aVar) {
        if (am.isEmpty(str) || am.isEmpty(str2)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(ch(str, str2), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, WriteData writeData) {
        if (!am.isEmpty(str) && !am.isEmpty(str2)) {
            com.baidu.adp.lib.cache.l<String> cJ = com.baidu.tbadk.core.c.a.tk().cJ("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cJ.b(ch(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cJ.X(ch(str, str2));
            }
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!am.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.r.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cJ = com.baidu.tbadk.core.c.a.tk().cJ("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cJ.a(r.sa(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cJ.remove(r.sa(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!am.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.r.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cJ = com.baidu.tbadk.core.c.a.tk().cJ("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cJ.a(r.rZ(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cJ.remove(r.rZ(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!am.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.r.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> cJ = com.baidu.tbadk.core.c.a.tk().cJ("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        cJ.a(r.rY(str), WriteData.this.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
                        return null;
                    }
                    cJ.remove(r.rY(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String rY(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String rZ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String sa(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String sb(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@story" + str;
    }

    protected static String ch(String str, String str2) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs" + str + "_" + str2;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a ghk;

        public b(String str, a aVar) {
            setPriority(3);
            this.ghk = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.tk().cJ("tb.pb_editor").get(this.cacheKey);
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
            if (this.ghk != null) {
                this.ghk.a(writeData);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class c extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a ghk;

        public c(String str, a aVar) {
            setPriority(3);
            this.ghk = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.tk().cJ("bottom_write_story").get(this.cacheKey);
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
            if (this.ghk != null) {
                this.ghk.a(writeData);
            }
        }
    }
}
