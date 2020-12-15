package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class y {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(TA(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Tz(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(TC(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(TB(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(TD(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                Bo.asyncSet(TD(str), writeData.toDraftString(), 604800000L);
            } else {
                Bo.asyncRemove(TD(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.pb_editor");
            if (writeData != null) {
                Bo.asyncSet(TE(str), writeData.toDraftString(), 604800000L);
            } else {
                Bo.asyncRemove(TE(str));
            }
        }
    }

    public static void f(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(TE(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bo.set(y.TC(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bo.remove(y.TC(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bo.set(y.TB(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bo.remove(y.TB(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void f(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bo.set(y.TA(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bo.remove(y.TA(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.y.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> Bo = com.baidu.tbadk.core.c.a.brq().Bo("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        Bo.set(y.Tz(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    Bo.remove(y.Tz(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String Tz(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String TA(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String TB(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String TC(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String TD(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String TE(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a nkM;

        public b(String str, a aVar) {
            setPriority(3);
            this.nkM = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: V */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.brq().Bo("tb.pb_editor").get(this.cacheKey);
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
            if (this.nkM != null) {
                this.nkM.a(writeData);
            }
        }
    }
}
