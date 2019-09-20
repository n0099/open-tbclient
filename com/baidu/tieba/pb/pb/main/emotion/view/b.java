package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a feU;
    private SearchEmotionModel iaG;
    private String iaH;
    private Runnable iaI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.iaH) && b.this.feU != null) {
                if (b.this.iaG == null) {
                    b.this.iaG = new SearchEmotionModel();
                }
                b.this.iaG.a(b.this.iaH, 0, 30, b.this.feU);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void CL(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iaH = "";
            return;
        }
        this.mHandler.removeCallbacks(this.iaI);
        this.mHandler.postDelayed(this.iaI, 300L);
        this.iaH = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.feU = aVar;
    }

    public void bpq() {
        if (this.iaG != null) {
            this.iaG.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.iaI);
    }
}
