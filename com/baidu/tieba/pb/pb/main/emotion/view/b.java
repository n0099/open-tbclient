package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a duv;
    private SearchEmotionModel gkc;
    private String gkd;
    private Runnable gke = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.gkd) && b.this.duv != null) {
                if (b.this.gkc == null) {
                    b.this.gkc = new SearchEmotionModel();
                }
                b.this.gkc.a(b.this.gkd, 0, 30, b.this.duv);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void tE(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gkd = "";
            return;
        }
        this.mHandler.removeCallbacks(this.gke);
        this.mHandler.postDelayed(this.gke, 300L);
        this.gkd = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.duv = aVar;
    }

    public void aEp() {
        if (this.gkc != null) {
            this.gkc.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.gke);
    }
}
