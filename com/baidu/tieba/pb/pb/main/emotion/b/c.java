package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class c {
    private SearchEmotionModel.a drL;
    private SearchEmotionModel fXU;
    private String fXV;
    private Runnable fXW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.fXV) && c.this.drL != null) {
                if (c.this.fXU == null) {
                    c.this.fXU = new SearchEmotionModel();
                }
                c.this.fXU.a(c.this.fXV, 0, 30, c.this.drL);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qH(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fXV = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fXW);
        this.mHandler.postDelayed(this.fXW, 300L);
        this.fXV = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.drL = aVar;
    }

    public void awP() {
        if (this.fXU != null) {
            this.fXU.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fXW);
    }
}
