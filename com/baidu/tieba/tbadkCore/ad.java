package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ad {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (aw.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(mI(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (aw.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(mH(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (aw.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(mJ(str), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, a aVar) {
        if (aw.isEmpty(str) || aw.isEmpty(str2)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(bm(str, str2), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, WriteData writeData) {
        if (!aw.isEmpty(str) && !aw.isEmpty(str2)) {
            com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.b.a.ug().cB("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cB.b(bm(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cB.aa(bm(str, str2));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!aw.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.b.a.ug().cB("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cB.b(mJ(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cB.aa(mJ(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!aw.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.b.a.ug().cB("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cB.b(mI(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cB.aa(mI(str));
            }
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!aw.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.b.a.ug().cB("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cB.b(mH(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cB.aa(mH(str));
            }
        }
    }

    protected static String mH(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String mI(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String mJ(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String bm(String str, String str2) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a dVL;

        public b(String str, a aVar) {
            setPriority(3);
            this.dVL = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.ug().cB("tb.pb_editor").get(this.cacheKey);
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
            if (this.dVL != null) {
                this.dVL.a(writeData);
            }
        }
    }
}
