package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class c {
    private SearchEmotionModel.a dox;
    private SearchEmotionModel fUn;
    private String fUo;
    private Runnable fUp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.fUo) && c.this.dox != null) {
                if (c.this.fUn == null) {
                    c.this.fUn = new SearchEmotionModel();
                }
                c.this.fUn.a(c.this.fUo, 0, 30, c.this.dox);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qr(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fUo = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fUp);
        this.mHandler.postDelayed(this.fUp, 300L);
        this.fUo = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.dox = aVar;
    }

    public void avN() {
        if (this.fUn != null) {
            this.fUn.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fUp);
    }
}
