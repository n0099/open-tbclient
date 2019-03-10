package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eHN;
    private SearchEmotionModel hAf;
    private String hAg;
    private Runnable hAh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hAg) && b.this.eHN != null) {
                if (b.this.hAf == null) {
                    b.this.hAf = new SearchEmotionModel();
                }
                b.this.hAf.a(b.this.hAg, 0, 30, b.this.eHN);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Ak(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hAg = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hAh);
        this.mHandler.postDelayed(this.hAh, 300L);
        this.hAg = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eHN = aVar;
    }

    public void beZ() {
        if (this.hAf != null) {
            this.hAf.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hAh);
    }
}
