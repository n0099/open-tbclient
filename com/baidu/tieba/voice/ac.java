package com.baidu.tieba.voice;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.FileNotFoundException;
import java.io.FileReader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2718a;

    private ac(VoiceManager voiceManager) {
        this.f2718a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(VoiceManager voiceManager, s sVar) {
        this(voiceManager);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1745=4, 1746=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/sys/class/switch/h2w/state");
        } catch (FileNotFoundException e) {
            fileReader = null;
        } catch (Exception e2) {
            fileReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[1024];
            this.f2718a.l = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue() != 0;
            if (this.f2718a.l) {
                this.f2718a.d(false);
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e3) {
                }
            }
        } catch (FileNotFoundException e4) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e5) {
                }
            }
            return null;
        } catch (Exception e6) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e7) {
                }
            }
            return null;
        } catch (Throwable th2) {
            fileReader2 = fileReader;
            th = th2;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (Exception e8) {
                }
            }
            throw th;
        }
        return null;
    }
}
