package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes.dex */
public class c {
    private SearchEmotionModel.a cvn;
    private SearchEmotionModel feM;
    private String feN;
    private Runnable feO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.feN) && c.this.cvn != null) {
                if (c.this.feM == null) {
                    c.this.feM = new SearchEmotionModel();
                }
                c.this.feM.a(c.this.feN, 0, 30, c.this.cvn);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qe(String str) {
        if (TextUtils.isEmpty(str)) {
            this.feN = "";
            return;
        }
        this.mHandler.removeCallbacks(this.feO);
        this.mHandler.postDelayed(this.feO, 300L);
        this.feN = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cvn = aVar;
    }

    public void amU() {
        if (this.feM != null) {
            this.feM.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.feO);
    }
}
