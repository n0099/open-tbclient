package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ac {

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
        new b(ku(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(kt(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (aq.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(kv(str), aVar).execute(new String[0]);
    }

    public static void a(int i, a aVar) {
        new b(jG(i), aVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.o<String> ck = com.baidu.tbadk.core.b.a.sM().ck("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            ck.b(jG(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            ck.ad(jG(i));
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!aq.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> ck = com.baidu.tbadk.core.b.a.sM().ck("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                ck.b(kv(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                ck.ad(kv(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!aq.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> ck = com.baidu.tbadk.core.b.a.sM().ck("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                ck.b(ku(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                ck.ad(ku(str));
            }
        }
    }

    protected static String kt(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String ku(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String kv(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String jG(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<String, String, WriteData> {
        private final a cHS;
        private final String cacheKey;

        public b(String str, a aVar) {
            setPriority(3);
            this.cHS = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.sM().ck("tb.pb_editor").get(this.cacheKey);
            } catch (Exception e) {
                str = null;
            }
            return WriteData.fromDraftString(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(WriteData writeData) {
            super.onPostExecute(writeData);
            if (this.cHS != null) {
                this.cHS.a(writeData);
            }
        }
    }
}
