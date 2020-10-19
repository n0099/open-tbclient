package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes22.dex */
public class b {
    private SearchEmotionModel.a iba;
    private SearchEmotionModel lnw;
    private String lnx;
    private Runnable lny = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lnx) && b.this.iba != null) {
                if (b.this.lnw == null) {
                    b.this.lnw = new SearchEmotionModel();
                }
                b.this.lnw.a(b.this.lnx, 0, 30, b.this.iba);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Pk(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lnx = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lny);
        this.mHandler.postDelayed(this.lny, 300L);
        this.lnx = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iba = aVar;
    }

    public void cvF() {
        if (this.lnw != null) {
            this.lnw.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lny);
    }
}
