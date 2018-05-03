package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a cKq;
    private SearchEmotionModel fsc;
    private String fsd;
    private Runnable fse = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fsd) && b.this.cKq != null) {
                if (b.this.fsc == null) {
                    b.this.fsc = new SearchEmotionModel();
                }
                b.this.fsc.a(b.this.fsd, 0, 30, b.this.cKq);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qN(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fsd = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fse);
        this.mHandler.postDelayed(this.fse, 300L);
        this.fsd = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cKq = aVar;
    }

    public void arg() {
        if (this.fsc != null) {
            this.fsc.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fse);
    }
}
