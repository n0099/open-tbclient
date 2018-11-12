package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a dkw;
    private SearchEmotionModel fZp;
    private String fZq;
    private Runnable fZr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fZq) && b.this.dkw != null) {
                if (b.this.fZp == null) {
                    b.this.fZp = new SearchEmotionModel();
                }
                b.this.fZp.a(b.this.fZq, 0, 30, b.this.dkw);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void sJ(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fZq = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fZr);
        this.mHandler.postDelayed(this.fZr, 300L);
        this.fZq = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.dkw = aVar;
    }

    public void aBt() {
        if (this.fZp != null) {
            this.fZp.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fZr);
    }
}
