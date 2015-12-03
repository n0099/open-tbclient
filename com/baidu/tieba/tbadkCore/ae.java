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
        new b(mu(str), aVar).execute(new String[0]);
    }

    public static void b(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(mt(str), aVar).execute(new String[0]);
    }

    public static void c(String str, a aVar) {
        if (ax.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        new b(mv(str), aVar).execute(new String[0]);
    }

    public static void a(int i, a aVar) {
        new b(ms(i), aVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.b.a.ts().cz("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            cz.b(ms(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            cz.ab(ms(i));
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.b.a.ts().cz("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cz.b(mv(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cz.ab(mv(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.b.a.ts().cz("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cz.b(mu(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cz.ab(mu(str));
            }
        }
    }

    public static void d(String str, WriteData writeData) {
        if (!ax.isEmpty(str)) {
            com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.b.a.ts().cz("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                cz.b(mt(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                cz.ab(mt(str));
            }
        }
    }

    protected static String mt(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String mu(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String mv(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String ms(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, String, WriteData> {
        private final String cacheKey;
        private final a dyw;

        public b(String str, a aVar) {
            setPriority(3);
            this.dyw = aVar;
            this.cacheKey = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public WriteData doInBackground(String... strArr) {
            String str;
            try {
                str = com.baidu.tbadk.core.b.a.ts().cz("tb.pb_editor").get(this.cacheKey);
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
            if (this.dyw != null) {
                this.dyw.a(writeData);
            }
        }
    }
}
