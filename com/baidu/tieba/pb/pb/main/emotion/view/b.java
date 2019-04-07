package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eHv;
    private SearchEmotionModel hzL;
    private String hzM;
    private Runnable hzN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hzM) && b.this.eHv != null) {
                if (b.this.hzL == null) {
                    b.this.hzL = new SearchEmotionModel();
                }
                b.this.hzL.a(b.this.hzM, 0, 30, b.this.eHv);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Ah(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hzM = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hzN);
        this.mHandler.postDelayed(this.hzN, 300L);
        this.hzM = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eHv = aVar;
    }

    public void beW() {
        if (this.hzL != null) {
            this.hzL.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hzN);
    }
}
