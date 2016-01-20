package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ae {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(ms(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(mr(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(mt(str), aVar).execute(new String[0]);
    }

    public static void a(int i, a aVar) {
        new b(mT(i), aVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.o<String> cC = com.baidu.tbadk.core.b.a.tc().cC("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            cC.b(mT(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            cC.ab(mT(i));
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cC = com.baidu.tbadk.core.b.a.tc().cC("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cC.b(mt(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cC.ab(mt(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cC = com.baidu.tbadk.core.b.a.tc().cC("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cC.b(ms(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cC.ab(ms(str));
            }
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cC = com.baidu.tbadk.core.b.a.tc().cC("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cC.b(mr(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cC.ab(mr(str));
            }
        }
    }

    protected static String mr(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String ms(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String mt(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String mT(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a dFQ;

        public b(String str, a aVar) {
            setPriority(3);
            this.dFQ = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.tc().cC("tb.pb_editor").get(this.cacheKey);
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
            if (this.dFQ != null) {
                this.dFQ.a(writeData);
            }
        }
    }
}
