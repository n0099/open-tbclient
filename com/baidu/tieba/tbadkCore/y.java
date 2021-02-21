package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class y {

    /* loaded from: classes.dex */
    public interface a {
        void b(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tk(str), aVar).execute(new String[0]);
    }

    public static void b(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        As.set(y.Tk(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    As.remove(y.Tk(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void b(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tl(str), aVar).execute(new String[0]);
    }

    public static void c(String str, WriteData writeData) {
        a(str, writeData, false);
    }

    public static void a(final String str, final WriteData writeData, final boolean z) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave() && !z) {
                        String draftString = WriteData.this.toDraftString();
                        As.set(y.Tl(str), draftString, 604800000L);
                        if (!"0".equals(str) && WriteData.this != null && WriteData.this.getStatisticFrom() == 1) {
                            As.set(y.Tl("0"), draftString, 604800000L);
                            return null;
                        }
                        return null;
                    }
                    As.remove(y.Tl(str));
                    if (!"0".equals(str) && WriteData.this != null && WriteData.this.getStatisticFrom() == 1) {
                        As.remove(y.Tl("0"));
                        return null;
                    }
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
        new b(To(str), aVar).execute(new String[0]);
    }

    public static void d(String str, WriteData writeData) {
        if (str != null) {
            com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                As.set(To(str), writeData.toDraftString(), 604800000L);
                As.set(To(""), writeData.toDraftString(), 604800000L);
                return;
            }
            As.remove(To(str));
            As.remove(To(""));
        }
    }

    public static void d(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tm(str), aVar).execute(new String[0]);
    }

    public static void e(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                As.asyncSet(Tm(str), writeData.toDraftString(), 604800000L);
            } else {
                As.asyncRemove(Tm(str));
            }
        }
    }

    public static void e(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tj(str), aVar).execute(new String[0]);
    }

    public static void f(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        As.set(y.Tj(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    As.remove(y.Tj(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> As = com.baidu.tbadk.core.c.a.bqr().As("tb.pb_editor");
            if (writeData != null) {
                As.asyncSet(Tn(str), writeData.toDraftString(), 604800000L);
            } else {
                As.asyncRemove(Tn(str));
            }
        }
    }

    public static void f(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.b(null);
                return;
            }
            return;
        }
        new b(Tn(str), aVar).execute(new String[0]);
    }

    protected static String Tj(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String Tk(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Tl(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
    }

    protected static String Tm(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String Tn(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    protected static String To(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a nvW;

        public b(String str, a aVar) {
            setPriority(3);
            this.nvW = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ab */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.bqr().As("tb.pb_editor").get(this.cacheKey);
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
            if (this.nvW != null) {
                this.nvW.b(writeData);
            }
        }
    }
}
