package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class w {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(NH(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(NG(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(NJ(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(NI(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(NK(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!as.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                xj.asyncSet(NK(str), writeData.toDraftString(), 604800000L);
            } else {
                xj.asyncRemove(NK(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!as.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.pb_editor");
            if (writeData != null) {
                xj.asyncSet(NL(str), writeData.toDraftString(), 604800000L);
            } else {
                xj.asyncRemove(NL(str));
            }
        }
    }

    public static void f(String str, a aVar) {
        if (as.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(NL(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!as.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        xj.set(w.NJ(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    xj.remove(w.NJ(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!as.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        xj.set(w.NI(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    xj.remove(w.NI(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void f(final String str, final WriteData writeData) {
        if (!as.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        xj.set(w.NH(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    xj.remove(w.NH(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(final String str, final WriteData writeData) {
        if (!as.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> xj = com.baidu.tbadk.core.c.a.aYG().xj("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        xj.set(w.NG(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    xj.remove(w.NG(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String NG(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String NH(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String NI(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String NJ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String NK(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String NL(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a lMf;

        public b(String str, a aVar) {
            setPriority(3);
            this.lMf = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.aYG().xj("tb.pb_editor").get(this.cacheKey);
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
            if (this.lMf != null) {
                this.lMf.a(writeData);
            }
        }
    }
}
