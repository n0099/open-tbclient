package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class x {

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
        new b(Sm(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Sl(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(So(str), aVar).execute(new String[0]);
    }

    public static void d(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Sn(str), aVar).execute(new String[0]);
    }

    public static void e(String str, a aVar) {
        if (au.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(Sp(str), aVar).execute(new String[0]);
    }

    public static void b(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                AH.asyncSet(Sp(str), writeData.toDraftString(), 604800000L);
            } else {
                AH.asyncRemove(Sp(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!au.isEmpty(str)) {
            com.baidu.adp.lib.cache.l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.pb_editor");
            if (writeData != null) {
                AH.asyncSet(Sq(str), writeData.toDraftString(), 604800000L);
            } else {
                AH.asyncRemove(Sq(str));
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
        new b(Sq(str), aVar).execute(new String[0]);
    }

    public static void d(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AH.set(x.So(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AH.remove(x.So(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void e(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AH.set(x.Sn(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AH.remove(x.Sn(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void f(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AH.set(x.Sm(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AH.remove(x.Sm(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void g(final String str, final WriteData writeData) {
        if (!au.isEmpty(str)) {
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.tbadkCore.x.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    com.baidu.adp.lib.cache.l<String> AH = com.baidu.tbadk.core.c.a.bob().AH("tb.pb_editor");
                    if (WriteData.this != null && WriteData.this.hasContentToSave()) {
                        AH.set(x.Sl(str), WriteData.this.toDraftString(), 604800000L);
                        return null;
                    }
                    AH.remove(x.Sl(str));
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    protected static String Sl(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
    }

    protected static String Sm(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
    }

    protected static String Sn(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@dynamic";
    }

    protected static String So(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@frs";
    }

    protected static String Sp(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
    }

    protected static String Sq(String str) {
        return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a mWL;

        public b(String str, a aVar) {
            setPriority(3);
            this.mWL = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: V */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.c.a.bob().AH("tb.pb_editor").get(this.cacheKey);
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
            if (this.mWL != null) {
                this.mWL.a(writeData);
            }
        }
    }
}
