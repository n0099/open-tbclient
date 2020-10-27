package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends a {
    private boolean isCancelled;

    public c(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public d d(ArrayList<Integer> arrayList, String str, int i) {
        d dVar = new d();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            int i2 = 0;
            int size = arrayList.size();
            Iterator<Integer> it = arrayList.iterator();
            while (true) {
                int i3 = i2;
                d dVar2 = dVar;
                if (!it.hasNext()) {
                    return dVar2;
                }
                i2 = i3 + 1;
                dVar = a(randomAccessFile, it.next().intValue(), i, str);
                if (dVar == null) {
                    return null;
                }
                JG((int) (30.0f + ((50.0f * i2) / size)));
                if (!StringUtils.isNull(dVar.videoUrl) || dVar.errorNo != 0) {
                    return dVar;
                }
            }
        } catch (FileNotFoundException e) {
            return dVar;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public boolean isCancelled() {
        return this.isCancelled;
    }
}
