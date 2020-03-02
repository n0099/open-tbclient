package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gaD;
    private String iSA;
    private SearchEmotionModel iSz;
    private Runnable iSB = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.iSA) && b.this.gaD != null) {
                if (b.this.iSz == null) {
                    b.this.iSz = new SearchEmotionModel();
                }
                b.this.iSz.a(b.this.iSA, 0, 30, b.this.gaD);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Go(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iSA = "";
            return;
        }
        this.mHandler.removeCallbacks(this.iSB);
        this.mHandler.postDelayed(this.iSB, 300L);
        this.iSA = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gaD = aVar;
    }

    public void bGv() {
        if (this.iSz != null) {
            this.iSz.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.iSB);
    }
}
