package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ae {

    /* loaded from: classes.dex */
    public interface a {
        void a(WriteData writeData);
    }

    public static void a(String str, a aVar) {
        if (ay.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(nS(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ay.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(nR(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ay.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(nT(str), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, a aVar) {
        if (ay.isEmpty(str) || ay.isEmpty(str2)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(bI(str, str2), aVar).execute(new String[0]);
    }

    public static void a(String str, String str2, WriteData writeData) {
        if (!ay.isEmpty(str) && !ay.isEmpty(str2)) {
            com.baidu.adp.lib.cache.o<String> cx = com.baidu.tbadk.core.b.a.rS().cx("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cx.b(bI(str, str2), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cx.R(bI(str, str2));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ay.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cx = com.baidu.tbadk.core.b.a.rS().cx("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cx.b(nT(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cx.R(nT(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!ay.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cx = com.baidu.tbadk.core.b.a.rS().cx("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cx.b(nS(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cx.R(nS(str));
            }
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!ay.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cx = com.baidu.tbadk.core.b.a.rS().cx("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cx.b(nR(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cx.R(nR(str));
            }
        }
    }

    protected static String nR(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String nS(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String nT(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String bI(String str, String str2) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a erH;

        public b(String str, a aVar) {
            setPriority(3);
            this.erH = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.rS().cx("tb.pb_editor").get(this.cacheKey);
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
            if (this.erH != null) {
                this.erH.a(writeData);
            }
        }
    }
}
