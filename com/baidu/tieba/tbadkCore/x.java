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
        new b(RV(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(RU(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(RX(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(RW(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(RY(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                AF.asyncSet(RY(str), writeData.toDraftString(), 604800000L);
            } else {
                AF.asyncRemove(RY(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.pb_editor");
            if (writeData != null) {
                AF.asyncSet(RZ(str), writeData.toDraftString(), 604800000L);
            } else {
                AF.asyncRemove(RZ(str));
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
        new b(RZ(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AF.set(x.RX(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AF.remove(x.RX(str));
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
                    com.baidu.adp.lib.cache.l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AF.set(x.RW(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AF.remove(x.RW(str));
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
                    com.baidu.adp.lib.cache.l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AF.set(x.RV(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AF.remove(x.RV(str));
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
                    com.baidu.adp.lib.cache.l<String> AF = com.baidu.tbadk.core.c.a.bkE().AF("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AF.set(x.RU(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AF.remove(x.RU(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String RU(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String RV(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String RW(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String RX(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String RY(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String RZ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a mDi;

        public b(String str, a aVar) {
            setPriority(3);
            this.mDi = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: T */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.bkE().AF("tb.pb_editor").get(this.cacheKey);
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
            if (this.mDi != null) {
                this.mDi.a(writeData);
            }
        }
    }
}
