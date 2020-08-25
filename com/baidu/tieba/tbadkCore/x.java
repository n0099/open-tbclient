package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes2.dex */
public class x {

    /* loaded from: classes2.dex */
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
        new b(QH(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(QG(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(QJ(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(QI(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(QK(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                zx.asyncSet(QK(str), writeData.toDraftString(), 604800000L);
            } else {
                zx.asyncRemove(QK(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_editor");
            if (writeData != null) {
                zx.asyncSet(QL(str), writeData.toDraftString(), 604800000L);
            } else {
                zx.asyncRemove(QL(str));
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
        new b(QL(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zx.set(x.QJ(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zx.remove(x.QJ(str));
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
                    com.baidu.adp.lib.cache.l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zx.set(x.QI(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zx.remove(x.QI(str));
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
                    com.baidu.adp.lib.cache.l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zx.set(x.QH(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zx.remove(x.QH(str));
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
                    com.baidu.adp.lib.cache.l<String> zx = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        zx.set(x.QG(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    zx.remove(x.QG(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String QG(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String QH(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String QI(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String QJ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String QK(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String QL(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a mdP;

        public b(String str, a aVar) {
            setPriority(3);
            this.mdP = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Q */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.bhb().zx("tb.pb_editor").get(this.cacheKey);
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
            if (this.mdP != null) {
                this.mdP.a(writeData);
            }
        }
    }
}
