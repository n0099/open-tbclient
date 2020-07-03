package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class w {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(MZ(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(MY(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Nb(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Na(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Nc(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!ar.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                wc.asyncSet(Nc(str), writeData.toDraftString(), 604800000L);
            } else {
                wc.asyncRemove(Nc(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!ar.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.pb_editor");
            if (writeData != null) {
                wc.asyncSet(Nd(str), writeData.toDraftString(), 604800000L);
            } else {
                wc.asyncRemove(Nd(str));
            }
        }
    }

    public static void f(String str, a aVar) {
        if (ar.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Nd(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!ar.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        wc.set(w.Nb(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    wc.remove(w.Nb(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!ar.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        wc.set(w.Na(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    wc.remove(w.Na(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void f(final String str, final WriteData writeData) {
        if (!ar.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        wc.set(w.MZ(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    wc.remove(w.MZ(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(final String str, final WriteData writeData) {
        if (!ar.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> wc = com.baidu.tbadk.core.c.a.aUM().wc("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        wc.set(w.MY(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    wc.remove(w.MY(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String MY(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String MZ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Na(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String Nb(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String Nc(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String Nd(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a lEO;

        public b(String str, a aVar) {
            setPriority(3);
            this.lEO = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.aUM().wc("tb.pb_editor").get(this.cacheKey);
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
            if (this.lEO != null) {
                this.lEO.a(writeData);
            }
        }
    }
}
