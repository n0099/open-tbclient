package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes16.dex */
public class b {
    private SearchEmotionModel.a hrI;
    private SearchEmotionModel kzU;
    private String kzV;
    private Runnable kzW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.kzV) && b.this.hrI != null) {
                if (b.this.kzU == null) {
                    b.this.kzU = new SearchEmotionModel();
                }
                b.this.kzU.a(b.this.kzV, 0, 30, b.this.hrI);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void La(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kzV = "";
            return;
        }
        this.mHandler.removeCallbacks(this.kzW);
        this.mHandler.postDelayed(this.kzW, 300L);
        this.kzV = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.hrI = aVar;
    }

    public void ceq() {
        if (this.kzU != null) {
            this.kzU.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.kzW);
    }
}
