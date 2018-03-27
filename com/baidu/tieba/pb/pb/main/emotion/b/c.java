package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class c {
    private SearchEmotionModel.a drC;
    private SearchEmotionModel fXZ;
    private String fYa;
    private Runnable fYb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.fYa) && c.this.drC != null) {
                if (c.this.fXZ == null) {
                    c.this.fXZ = new SearchEmotionModel();
                }
                c.this.fXZ.a(c.this.fYa, 0, 30, c.this.drC);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qH(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fYa = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fYb);
        this.mHandler.postDelayed(this.fYb, 300L);
        this.fYa = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.drC = aVar;
    }

    public void awQ() {
        if (this.fXZ != null) {
            this.fXZ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fYb);
    }
}
