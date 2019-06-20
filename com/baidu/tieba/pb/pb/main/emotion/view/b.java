package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eXG;
    private SearchEmotionModel hRA;
    private String hRB;
    private Runnable hRC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hRB) && b.this.eXG != null) {
                if (b.this.hRA == null) {
                    b.this.hRA = new SearchEmotionModel();
                }
                b.this.hRA.a(b.this.hRB, 0, 30, b.this.eXG);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Bz(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hRB = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hRC);
        this.mHandler.postDelayed(this.hRC, 300L);
        this.hRB = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eXG = aVar;
    }

    public void bmr() {
        if (this.hRA != null) {
            this.hRA.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hRC);
    }
}
