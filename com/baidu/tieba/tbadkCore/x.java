package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class x {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(SL(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(SK(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(SN(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(SM(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(SO(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                Bm.asyncSet(SO(str), writeData.toDraftString(), 604800000L);
            } else {
                Bm.asyncRemove(SO(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.pb_editor");
            if (writeData != null) {
                Bm.asyncSet(SP(str), writeData.toDraftString(), 604800000L);
            } else {
                Bm.asyncRemove(SP(str));
            }
        }
    }

    public static void f(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(SP(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bm.set(x.SN(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bm.remove(x.SN(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bm.set(x.SM(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bm.remove(x.SM(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void f(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bm.set(x.SL(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bm.remove(x.SL(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.boX().Bm("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bm.set(x.SK(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bm.remove(x.SK(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String SK(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String SL(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String SM(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String SN(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String SO(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String SP(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a mVT;

        public b(String str, a aVar) {
            setPriority(3);
            this.mVT = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: U */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.boX().Bm("tb.pb_editor").get(this.cacheKey);
            } catch (Exception e) {
                str = null;
            }
            return WriteData.fromDraftString(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(WriteData writeData) {
            super.onPostExecute(writeData);
            if (this.mVT != null) {
                this.mVT.a(writeData);
            }
        }
    }
}
