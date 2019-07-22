package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class t {

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
        new b(EE(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(ED(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(EF(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(EG(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!aq.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                mL.b(EG(str), writeData.toDraftString(), 604800000L);
            } else {
                mL.ar(EG(str));
            }
        }
    }

    public static void c(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        mL.a(t.EF(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    mL.remove(t.EF(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void d(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        mL.a(t.EE(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    mL.remove(t.EE(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.t.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> mL = com.baidu.tbadk.core.d.a.agF().mL("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        mL.a(t.ED(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    mL.remove(t.ED(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String ED(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String EE(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String EF(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String EG(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a jea;

        public b(String str, a aVar) {
            setPriority(3);
            this.jea = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.d.a.agF().mL("tb.pb_editor").get(this.cacheKey);
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
            if (this.jea != null) {
                this.jea.a(writeData);
            }
        }
    }
}
