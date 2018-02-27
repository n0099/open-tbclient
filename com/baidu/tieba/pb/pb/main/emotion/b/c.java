package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class c {
    private SearchEmotionModel.a drz;
    private SearchEmotionModel fXJ;
    private String fXK;
    private Runnable fXL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.fXK) && c.this.drz != null) {
                if (c.this.fXJ == null) {
                    c.this.fXJ = new SearchEmotionModel();
                }
                c.this.fXJ.a(c.this.fXK, 0, 30, c.this.drz);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qH(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fXK = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fXL);
        this.mHandler.postDelayed(this.fXL, 300L);
        this.fXK = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.drz = aVar;
    }

    public void awO() {
        if (this.fXJ != null) {
            this.fXJ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fXL);
    }
}
