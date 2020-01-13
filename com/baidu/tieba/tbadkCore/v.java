package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class v {

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
        new b(IJ(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(II(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(IK(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(IL(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!aq.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                sA.asyncSet(IL(str), writeData.toDraftString(), 604800000L);
            } else {
                sA.asyncRemove(IL(str));
            }
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.v.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        sA.set(v.IK(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    sA.remove(v.IK(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.v.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        sA.set(v.IJ(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    sA.remove(v.IJ(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.v.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> sA = com.baidu.tbadk.core.c.a.aCo().sA("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        sA.set(v.II(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    sA.remove(v.II(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String II(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String IJ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String IK(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String IL(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a ker;

        public b(String str, a aVar) {
            setPriority(3);
            this.ker = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.aCo().sA("tb.pb_editor").get(this.cacheKey);
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
            if (this.ker != null) {
                this.ker.a(writeData);
            }
        }
    }
}
