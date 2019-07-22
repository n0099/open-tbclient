package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a fcH;
    private SearchEmotionModel hXN;
    private String hXO;
    private Runnable hXP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hXO) && b.this.fcH != null) {
                if (b.this.hXN == null) {
                    b.this.hXN = new SearchEmotionModel();
                }
                b.this.hXN.a(b.this.hXO, 0, 30, b.this.fcH);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Cl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hXO = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hXP);
        this.mHandler.postDelayed(this.hXP, 300L);
        this.hXO = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.fcH = aVar;
    }

    public void bos() {
        if (this.hXN != null) {
            this.hXN.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hXP);
    }
}
