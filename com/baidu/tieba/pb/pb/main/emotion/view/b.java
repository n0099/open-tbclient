package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eHJ;
    private String hAa;
    private SearchEmotionModel hzZ;
    private Runnable hAb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hAa) && b.this.eHJ != null) {
                if (b.this.hzZ == null) {
                    b.this.hzZ = new SearchEmotionModel();
                }
                b.this.hzZ.a(b.this.hAa, 0, 30, b.this.eHJ);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Ai(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hAa = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hAb);
        this.mHandler.postDelayed(this.hAb, 300L);
        this.hAa = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eHJ = aVar;
    }

    public void beY() {
        if (this.hzZ != null) {
            this.hzZ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hAb);
    }
}
