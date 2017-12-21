package com.baidu.tieba.pb.pb.main.emotion.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes.dex */
public class c {
    private SearchEmotionModel.a cvA;
    private SearchEmotionModel ffS;
    private String ffT;
    private Runnable ffU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(c.this.ffT) && c.this.cvA != null) {
                if (c.this.ffS == null) {
                    c.this.ffS = new SearchEmotionModel();
                }
                c.this.ffS.a(c.this.ffT, 0, 30, c.this.cvA);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qe(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ffT = "";
            return;
        }
        this.mHandler.removeCallbacks(this.ffU);
        this.mHandler.postDelayed(this.ffU, 300L);
        this.ffT = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cvA = aVar;
    }

    public void and() {
        if (this.ffS != null) {
            this.ffS.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.ffU);
    }
}
