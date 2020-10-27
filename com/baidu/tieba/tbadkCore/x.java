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
        new b(Su(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(St(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Sw(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Sv(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (at.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Sx(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                AY.asyncSet(Sx(str), writeData.toDraftString(), 604800000L);
            } else {
                AY.asyncRemove(Sx(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!at.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.pb_editor");
            if (writeData != null) {
                AY.asyncSet(Sy(str), writeData.toDraftString(), 604800000L);
            } else {
                AY.asyncRemove(Sy(str));
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
        new b(Sy(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AY.set(x.Sw(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AY.remove(x.Sw(str));
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
                    com.baidu.adp.lib.cache.l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AY.set(x.Sv(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AY.remove(x.Sv(str));
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
                    com.baidu.adp.lib.cache.l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AY.set(x.Su(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AY.remove(x.Su(str));
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
                    com.baidu.adp.lib.cache.l<String> AY = com.baidu.tbadk.core.c.a.bmx().AY("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AY.set(x.St(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AY.remove(x.St(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String St(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String Su(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Sv(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String Sw(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String Sx(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String Sy(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a mPQ;

        public b(String str, a aVar) {
            setPriority(3);
            this.mPQ = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: U */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.bmx().AY("tb.pb_editor").get(this.cacheKey);
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
            if (this.mPQ != null) {
                this.mPQ.a(writeData);
            }
        }
    }
}
