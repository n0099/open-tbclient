package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eHw;
    private SearchEmotionModel hzM;
    private String hzN;
    private Runnable hzO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hzN) && b.this.eHw != null) {
                if (b.this.hzM == null) {
                    b.this.hzM = new SearchEmotionModel();
                }
                b.this.hzM.a(b.this.hzN, 0, 30, b.this.eHw);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Ah(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hzN = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hzO);
        this.mHandler.postDelayed(this.hzO, 300L);
        this.hzN = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eHw = aVar;
    }

    public void beW() {
        if (this.hzM != null) {
            this.hzM.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hzO);
    }
}
