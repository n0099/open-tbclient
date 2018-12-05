package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a dqY;
    private SearchEmotionModel ggg;
    private String ggh;
    private Runnable ggi = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.ggh) && b.this.dqY != null) {
                if (b.this.ggg == null) {
                    b.this.ggg = new SearchEmotionModel();
                }
                b.this.ggg.a(b.this.ggh, 0, 30, b.this.dqY);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void tl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ggh = "";
            return;
        }
        this.mHandler.removeCallbacks(this.ggi);
        this.mHandler.postDelayed(this.ggi, 300L);
        this.ggh = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.dqY = aVar;
    }

    public void aDd() {
        if (this.ggg != null) {
            this.ggg.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.ggi);
    }
}
