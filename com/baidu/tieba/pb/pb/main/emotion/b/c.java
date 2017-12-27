package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class c {
    private SearchEmotionModel.a djW;
    private SearchEmotionModel fSN;
    private String fSO;
    private Runnable fSP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.fSO) && c.this.djW != null) {
                if (c.this.fSN == null) {
                    c.this.fSN = new SearchEmotionModel();
                }
                c.this.fSN.a(c.this.fSO, 0, 30, c.this.djW);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qp(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fSO = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fSP);
        this.mHandler.postDelayed(this.fSP, 300L);
        this.fSO = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.djW = aVar;
    }

    public void auK() {
        if (this.fSN != null) {
            this.fSN.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fSP);
    }
}
