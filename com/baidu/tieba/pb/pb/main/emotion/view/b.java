package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eHN;
    private SearchEmotionModel hAe;
    private String hAf;
    private Runnable hAg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hAf) && b.this.eHN != null) {
                if (b.this.hAe == null) {
                    b.this.hAe = new SearchEmotionModel();
                }
                b.this.hAe.a(b.this.hAf, 0, 30, b.this.eHN);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Aj(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hAf = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hAg);
        this.mHandler.postDelayed(this.hAg, 300L);
        this.hAf = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eHN = aVar;
    }

    public void beY() {
        if (this.hAe != null) {
            this.hAe.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hAg);
    }
}
