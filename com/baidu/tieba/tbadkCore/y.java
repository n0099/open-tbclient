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
        new b(Tj(str), aVar).execute(new String[0]);
    }

    public static void b(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bn.set(y.Tj(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bn.remove(y.Tj(str));
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
        new b(Tk(str), aVar).execute(new String[0]);
    }

    public static void c(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        String draftString = WriteData.this.toDraftString();
                        Bn.set(y.Tk(str), draftString, 604800000L);
                        Bn.set(y.Tk("0"), draftString, 604800000L);
                        return null;
                    }
                    Bn.remove(y.Tk(str));
                    Bn.remove(y.Tk("0"));
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
        new b(Tn(str), aVar).execute(new String[0]);
    }

    public static void d(String str, WriteData writeData) {
        if (str != null) {
            com.baidu.adp.lib.cache.l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                Bn.set(Tn(str), writeData.toDraftString(), 604800000L);
                Bn.set(Tn(""), writeData.toDraftString(), 604800000L);
                return;
            }
            Bn.remove(Tn(str));
            Bn.remove(Tn(""));
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
        new b(Tl(str), aVar).execute(new String[0]);
    }

    public static void e(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                Bn.asyncSet(Tl(str), writeData.toDraftString(), 604800000L);
            } else {
                Bn.asyncRemove(Tl(str));
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
        new b(Ti(str), aVar).execute(new String[0]);
    }

    public static void f(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bn.set(y.Ti(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bn.remove(y.Ti(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bn = com.baidu.tbadk.core.c.a.btS().Bn("tb.pb_editor");
            if (writeData != null) {
                Bn.asyncSet(Tm(str), writeData.toDraftString(), 604800000L);
            } else {
                Bn.asyncRemove(Tm(str));
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
        new b(Tm(str), aVar).execute(new String[0]);
    }

    protected static String Ti(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String Tj(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Tk(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
    }

    protected static String Tl(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String Tm(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    protected static String Tn(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a nqu;

        public b(String str, a aVar) {
            setPriority(3);
            this.nqu = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ab */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.btS().Bn("tb.pb_editor").get(this.cacheKey);
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
            if (this.nqu != null) {
                this.nqu.b(writeData);
            }
        }
    }
}
