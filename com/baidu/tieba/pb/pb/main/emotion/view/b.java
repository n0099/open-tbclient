package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes16.dex */
public class b {
    private SearchEmotionModel.a hrI;
    private SearchEmotionModel kzS;
    private String kzT;
    private Runnable kzU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.kzT) && b.this.hrI != null) {
                if (b.this.kzS == null) {
                    b.this.kzS = new SearchEmotionModel();
                }
                b.this.kzS.a(b.this.kzT, 0, 30, b.this.hrI);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void La(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kzT = "";
            return;
        }
        this.mHandler.removeCallbacks(this.kzU);
        this.mHandler.postDelayed(this.kzU, 300L);
        this.kzT = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.hrI = aVar;
    }

    public void ceq() {
        if (this.kzS != null) {
            this.kzS.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.kzU);
    }
}
