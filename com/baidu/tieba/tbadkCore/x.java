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
        new b(Rh(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Rg(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Rj(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Ri(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Rk(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                zT.asyncSet(Rk(str), writeData.toDraftString(), 604800000L);
            } else {
                zT.asyncRemove(Rk(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.pb_editor");
            if (writeData != null) {
                zT.asyncSet(Rl(str), writeData.toDraftString(), 604800000L);
            } else {
                zT.asyncRemove(Rl(str));
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
        new b(Rl(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zT.set(x.Rj(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zT.remove(x.Rj(str));
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
                    com.baidu.adp.lib.cache.l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zT.set(x.Ri(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zT.remove(x.Ri(str));
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
                    com.baidu.adp.lib.cache.l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zT.set(x.Rh(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zT.remove(x.Rh(str));
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
                    com.baidu.adp.lib.cache.l<String> zT = com.baidu.tbadk.core.c.a.bhV().zT("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zT.set(x.Rg(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zT.remove(x.Rg(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String Rg(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String Rh(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Ri(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String Rj(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String Rk(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String Rl(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a mnD;

        public b(String str, a aVar) {
            setPriority(3);
            this.mnD = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Q */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.bhV().zT("tb.pb_editor").get(this.cacheKey);
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
            if (this.mnD != null) {
                this.mnD.a(writeData);
            }
        }
    }
}
