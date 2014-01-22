package com.baidu.tieba.voice;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.by;
import java.io.FileNotFoundException;
import java.io.FileReader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ VoiceManager a;

    private ac(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(VoiceManager voiceManager, s sVar) {
        this(voiceManager);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1830=4, 1831=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void a(Void... voidArr) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            try {
                fileReader = new FileReader("/sys/class/switch/h2w/state");
                try {
                    char[] cArr = new char[1024];
                    this.a.l = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue() != 0;
                    if (this.a.l) {
                        this.a.d(false);
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    com.baidu.tieba.util.ac acVar = new com.baidu.tieba.util.ac();
                    acVar.a("path", "/sys/class/switch/h2w/state");
                    by.b("", -1111, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), acVar.toString());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.tieba.util.ac acVar2 = new com.baidu.tieba.util.ac();
                    acVar2.a("path", "/sys/class/switch/h2w/state");
                    by.b("", -1111, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), acVar2.toString());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileReader2.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileReader = null;
        } catch (Exception e8) {
            e = e8;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return null;
    }
}
