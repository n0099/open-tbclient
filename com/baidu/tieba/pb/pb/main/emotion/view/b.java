package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes22.dex */
public class b {
    private SearchEmotionModel.a iFf;
    private SearchEmotionModel lUf;
    private String lUg;
    private Runnable lUh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lUg) && b.this.iFf != null) {
                if (b.this.lUf == null) {
                    b.this.lUf = new SearchEmotionModel();
                }
                b.this.lUf.a(b.this.lUg, 0, 30, b.this.iFf);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void QD(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lUg = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lUh);
        this.mHandler.postDelayed(this.lUh, 300L);
        this.lUg = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iFf = aVar;
    }

    public void cFg() {
        if (this.lUf != null) {
            this.lUf.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lUh);
    }
}
