package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gZK;
    private SearchEmotionModel jXe;
    private String jXf;
    private Runnable jXg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.jXf) && b.this.gZK != null) {
                if (b.this.jXe == null) {
                    b.this.jXe = new SearchEmotionModel();
                }
                b.this.jXe.a(b.this.jXf, 0, 30, b.this.gZK);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void JL(String str) {
        if (TextUtils.isEmpty(str)) {
            this.jXf = "";
            return;
        }
        this.mHandler.removeCallbacks(this.jXg);
        this.mHandler.postDelayed(this.jXg, 300L);
        this.jXf = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gZK = aVar;
    }

    public void bXG() {
        if (this.jXe != null) {
            this.jXe.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.jXg);
    }
}
