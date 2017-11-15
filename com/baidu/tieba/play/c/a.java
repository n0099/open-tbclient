package com.baidu.tieba.play.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.play.c.b;
import java.io.File;
import java.util.HashSet;
/* loaded from: classes.dex */
public class a {
    private String aMq;
    private InterfaceC0120a fGq;
    private boolean fHw = false;
    private boolean fHx = false;
    private HashSet<String> fHy = new HashSet<>();
    private String mLocalPath;

    /* renamed from: com.baidu.tieba.play.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0120a {
        void bN(String str, String str2);

        void j(String str, String str2, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void lz(boolean z);
    }

    public a(InterfaceC0120a interfaceC0120a) {
        this.fGq = interfaceC0120a;
    }

    public void bP(String str, String str2) {
        if (f.AA() && !TextUtils.equals(str, this.mLocalPath)) {
            clearPath();
            this.mLocalPath = str;
            this.aMq = str2;
        }
    }

    public void clearPath() {
        if (f.AA()) {
            if (this.fHx && this.fHw) {
                bhY();
            }
            this.mLocalPath = null;
            this.fHw = false;
            this.fHx = false;
        }
    }

    public void bhW() {
        if (f.AA() && !StringUtils.isNull(this.mLocalPath) && rb(this.mLocalPath) && !this.fHy.contains(this.mLocalPath)) {
            com.baidu.tieba.play.c.b.a(this.mLocalPath, new b.InterfaceC0121b() { // from class: com.baidu.tieba.play.c.a.1
                @Override // com.baidu.tieba.play.c.b.InterfaceC0121b
                public void sf(int i) {
                    a.this.fHy.add(a.this.mLocalPath);
                    if (i == 1) {
                        a.this.fHw = true;
                        a.this.bhX();
                        if (a.this.fGq != null) {
                            a.this.fGq.bN(a.this.mLocalPath, a.this.aMq);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhX() {
        if (f.AA() && !StringUtils.isNull(this.mLocalPath) && rb(this.mLocalPath)) {
            com.baidu.tieba.play.c.b.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new b.a() { // from class: com.baidu.tieba.play.c.a.2
                @Override // com.baidu.tieba.play.c.b.a
                public void ly(boolean z) {
                    if (a.this.fHw && z) {
                        a.this.fHx = true;
                    }
                    if (a.this.fGq != null) {
                        a.this.fGq.j(a.this.mLocalPath, a.this.aMq, z);
                    }
                }
            });
        }
    }

    public void bhY() {
        if (f.AA() && !StringUtils.isNull(this.mLocalPath) && new File(this.mLocalPath).exists() && new File(this.mLocalPath + "_moov_head_suffix").exists() && this.fHw && this.fHx) {
            new BdAsyncTask<String, Void, Boolean>() { // from class: com.baidu.tieba.play.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(String... strArr) {
                    if (strArr == null || strArr.length != 1) {
                        return false;
                    }
                    return Boolean.valueOf(new File(strArr[0] + "_moov_head_suffix").renameTo(new File(strArr[0])));
                }
            }.execute(this.mLocalPath);
        }
    }

    public static boolean rb(String str) {
        return (StringUtils.isNull(str) || str.contains("http")) ? false : true;
    }

    public void a(final b bVar) {
        if (StringUtils.isNull(this.mLocalPath) || !rb(this.mLocalPath) || this.fHy.contains(this.mLocalPath)) {
            if (bVar != null) {
                bVar.lz(true);
                return;
            }
            return;
        }
        new BdAsyncTask<String, Void, Integer>() { // from class: com.baidu.tieba.play.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: A */
            public Integer doInBackground(String... strArr) {
                if (strArr == null || strArr.length != 1) {
                    return null;
                }
                String str = strArr[0];
                if (com.baidu.tieba.play.c.b.rc(str) == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 0);
                    TiebaStatic.log(akVar);
                    if (com.baidu.tieba.play.c.b.bQ(str, str + "_moov_head_suffix")) {
                        return Integer.valueOf(new File(new StringBuilder().append(str).append("_moov_head_suffix").toString()).renameTo(new File(str)) ? 1 : 0);
                    }
                }
                return 2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Integer num) {
                boolean z = false;
                super.onPostExecute((AnonymousClass4) num);
                if (num != null && (num.intValue() == 0 || num.intValue() == 1)) {
                    ak akVar = new ak("c12621");
                    akVar.r("obj_locate", 0);
                    akVar.r("obj_param1", num.intValue());
                    TiebaStatic.log(akVar);
                }
                if (bVar != null) {
                    if (num == null || num.intValue() != 0) {
                        z = true;
                    }
                    bVar.lz(z);
                }
            }
        }.execute(this.mLocalPath);
    }
}
