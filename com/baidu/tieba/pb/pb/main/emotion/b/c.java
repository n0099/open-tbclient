package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes.dex */
public class c {
    private SearchEmotionModel.a cvw;
    private SearchEmotionModel ffN;
    private String ffO;
    private Runnable ffP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.ffO) && c.this.cvw != null) {
                if (c.this.ffN == null) {
                    c.this.ffN = new SearchEmotionModel();
                }
                c.this.ffN.a(c.this.ffO, 0, 30, c.this.cvw);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qe(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ffO = "";
            return;
        }
        this.mHandler.removeCallbacks(this.ffP);
        this.mHandler.postDelayed(this.ffP, 300L);
        this.ffO = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cvw = aVar;
    }

    public void and() {
        if (this.ffN != null) {
            this.ffN.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.ffP);
    }
}
