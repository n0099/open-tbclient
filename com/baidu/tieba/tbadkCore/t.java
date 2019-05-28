package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class t {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(DP(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(DO(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(DQ(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (ap.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(DR(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!ap.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                mB.b(DR(str), writeData.toDraftString(), 604800000L);
            } else {
                mB.aq(DR(str));
            }
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!ap.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        mB.a(t.DQ(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    mB.remove(t.DQ(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!ap.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        mB.a(t.DP(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    mB.remove(t.DP(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!ap.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> mB = com.baidu.tbadk.core.c.a.afD().mB("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        mB.a(t.DO(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    mB.remove(t.DO(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String DO(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String DP(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String DQ(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String DR(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a iXF;

        public b(String str, a aVar) {
            setPriority(3);
            this.iXF = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.afD().mB("tb.pb_editor").get(this.cacheKey);
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
            if (this.iXF != null) {
                this.iXF.a(writeData);
            }
        }
    }
}
