package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class y {

    /* loaded from: classes.dex */
    public interface a {
        void b(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Ti(str), aVar).execute(new String[0]);
    }

    public static void b(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bm.set(y.Ti(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bm.remove(y.Ti(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void b(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tj(str), aVar).execute(new String[0]);
    }

    public static void c(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        String draftString = WriteData.this.toDraftString();
                        Bm.set(y.Tj(str), draftString, 604800000L);
                        Bm.set(y.Tj("0"), draftString, 604800000L);
                        return null;
                    }
                    Bm.remove(y.Tj(str));
                    Bm.remove(y.Tj("0"));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void c(String str, a aVar) {
        if (str == null) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tm(str), aVar).execute(new String[0]);
    }

    public static void d(String str, WriteData writeData) {
        if (str != null) {
            com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                Bm.set(Tm(str), writeData.toDraftString(), 604800000L);
                Bm.set(Tm(""), writeData.toDraftString(), 604800000L);
                return;
            }
            Bm.remove(Tm(str));
            Bm.remove(Tm(""));
        }
    }

    public static void d(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tk(str), aVar).execute(new String[0]);
    }

    public static void e(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                Bm.asyncSet(Tk(str), writeData.toDraftString(), 604800000L);
            } else {
                Bm.asyncRemove(Tk(str));
            }
        }
    }

    public static void e(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Th(str), aVar).execute(new String[0]);
    }

    public static void f(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bm.set(y.Th(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bm.remove(y.Th(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bm = com.baidu.tbadk.core.c.a.btT().Bm("tb.pb_editor");
            if (writeData != null) {
                Bm.asyncSet(Tl(str), writeData.toDraftString(), 604800000L);
            } else {
                Bm.asyncRemove(Tl(str));
            }
        }
    }

    public static void f(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tl(str), aVar).execute(new String[0]);
    }

    protected static String Th(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String Ti(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Tj(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
    }

    protected static String Tk(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String Tl(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    protected static String Tm(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a nqt;

        public b(String str, a aVar) {
            setPriority(3);
            this.nqt = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ab */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.btT().Bm("tb.pb_editor").get(this.cacheKey);
            } catch (Exception e) {
                str = null;
            }
            return WriteData.fromDraftString(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(WriteData writeData) {
            super.onPostExecute(writeData);
            if (this.nqt != null) {
                this.nqt.b(writeData);
            }
        }
    }
}
