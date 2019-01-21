package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a duw;
    private SearchEmotionModel gkd;
    private String gke;
    private Runnable gkf = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.gke) && b.this.duw != null) {
                if (b.this.gkd == null) {
                    b.this.gkd = new SearchEmotionModel();
                }
                b.this.gkd.a(b.this.gke, 0, 30, b.this.duw);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void tE(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gke = "";
            return;
        }
        this.mHandler.removeCallbacks(this.gkf);
        this.mHandler.postDelayed(this.gkf, 300L);
        this.gke = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.duw = aVar;
    }

    public void aEp() {
        if (this.gkd != null) {
            this.gkd.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.gkf);
    }
}
