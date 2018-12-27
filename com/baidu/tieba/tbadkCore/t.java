package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class t {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ao.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(vC(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ao.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(vB(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ao.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(vD(str), aVar).execute(new String[0]);
    }

    public static void b(final String str, final WriteData writeData) {
        if (!ao.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> ey = com.baidu.tbadk.core.c.a.BB().ey("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        ey.a(t.vD(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    ey.remove(t.vD(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!ao.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> ey = com.baidu.tbadk.core.c.a.BB().ey("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        ey.a(t.vC(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    ey.remove(t.vC(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!ao.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> ey = com.baidu.tbadk.core.c.a.BB().ey("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        ey.a(t.vB(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    ey.remove(t.vB(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String vB(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String vC(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String vD(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a hnz;

        public b(String str, a aVar) {
            setPriority(3);
            this.hnz = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.BB().ey("tb.pb_editor").get(this.cacheKey);
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
            if (this.hnz != null) {
                this.hnz.a(writeData);
            }
        }
    }
}
