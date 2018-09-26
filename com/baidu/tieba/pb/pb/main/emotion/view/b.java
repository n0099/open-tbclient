package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a dbh;
    private SearchEmotionModel fQp;
    private String fQq;
    private Runnable fQr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fQq) && b.this.dbh != null) {
                if (b.this.fQp == null) {
                    b.this.fQp = new SearchEmotionModel();
                }
                b.this.fQp.a(b.this.fQq, 0, 30, b.this.dbh);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void sh(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fQq = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fQr);
        this.mHandler.postDelayed(this.fQr, 300L);
        this.fQq = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.dbh = aVar;
    }

    public void ayC() {
        if (this.fQp != null) {
            this.fQp.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fQr);
    }
}
