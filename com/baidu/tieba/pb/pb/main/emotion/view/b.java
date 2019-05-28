package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eXG;
    private String hRA;
    private SearchEmotionModel hRz;
    private Runnable hRB = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hRA) && b.this.eXG != null) {
                if (b.this.hRz == null) {
                    b.this.hRz = new SearchEmotionModel();
                }
                b.this.hRz.a(b.this.hRA, 0, 30, b.this.eXG);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Bx(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hRA = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hRB);
        this.mHandler.postDelayed(this.hRB, 300L);
        this.hRA = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eXG = aVar;
    }

    public void bmr() {
        if (this.hRz != null) {
            this.hRz.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hRB);
    }
}
