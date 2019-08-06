package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a fdh;
    private SearchEmotionModel hYJ;
    private String hYK;
    private Runnable hYL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hYK) && b.this.fdh != null) {
                if (b.this.hYJ == null) {
                    b.this.hYJ = new SearchEmotionModel();
                }
                b.this.hYJ.a(b.this.hYK, 0, 30, b.this.fdh);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Cm(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hYK = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hYL);
        this.mHandler.postDelayed(this.hYL, 300L);
        this.hYK = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.fdh = aVar;
    }

    public void boF() {
        if (this.hYJ != null) {
            this.hYJ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hYL);
    }
}
