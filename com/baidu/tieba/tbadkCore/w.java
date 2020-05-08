package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class w {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(KK(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(KJ(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(KL(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(KM(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!aq.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                ug.asyncSet(KM(str), writeData.toDraftString(), 604800000L);
            } else {
                ug.asyncRemove(KM(str));
            }
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        ug.set(w.KL(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    ug.remove(w.KL(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        ug.set(w.KK(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    ug.remove(w.KK(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.w.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> ug = com.baidu.tbadk.core.c.a.aMR().ug("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        ug.set(w.KJ(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    ug.remove(w.KJ(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String KJ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String KK(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String KL(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String KM(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a kRv;

        public b(String str, a aVar) {
            setPriority(3);
            this.kRv = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Q */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.aMR().ug("tb.pb_editor").get(this.cacheKey);
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
            if (this.kRv != null) {
                this.kRv.a(writeData);
            }
        }
    }
}
