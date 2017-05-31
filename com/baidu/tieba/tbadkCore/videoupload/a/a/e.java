package com.baidu.tieba.tbadkCore.videoupload.a.a;

import com.baidu.adp.lib.util.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends a {
    private boolean isCancelled;

    public e(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.a
    public f b(ArrayList<Integer> arrayList, String str, int i) {
        f fVar = new f();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            int size = arrayList.size();
            Iterator<Integer> it = arrayList.iterator();
            int i2 = 0;
            f fVar2 = fVar;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                fVar2 = a(randomAccessFile, it.next().intValue(), i, str);
                if (fVar2 == null) {
                    return null;
                }
                sy((int) (30.0f + ((50.0f * i3) / size)));
                if (!StringUtils.isNull(fVar2.videoUrl) || fVar2.errorNo != 0) {
                    return fVar2;
                }
                i2 = i3;
            }
            return fVar2;
        } catch (FileNotFoundException e) {
            return fVar;
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
