package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class c {
    private SearchEmotionModel.a doS;
    private SearchEmotionModel fUI;
    private String fUJ;
    private Runnable fUK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.fUJ) && c.this.doS != null) {
                if (c.this.fUI == null) {
                    c.this.fUI = new SearchEmotionModel();
                }
                c.this.fUI.a(c.this.fUJ, 0, 30, c.this.doS);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qz(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fUJ = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fUK);
        this.mHandler.postDelayed(this.fUK, 300L);
        this.fUJ = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.doS = aVar;
    }

    public void avS() {
        if (this.fUI != null) {
            this.fUI.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fUK);
    }
}
