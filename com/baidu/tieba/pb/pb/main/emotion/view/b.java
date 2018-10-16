package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a djr;
    private SearchEmotionModel fXP;
    private String fXQ;
    private Runnable fXR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fXQ) && b.this.djr != null) {
                if (b.this.fXP == null) {
                    b.this.fXP = new SearchEmotionModel();
                }
                b.this.fXP.a(b.this.fXQ, 0, 30, b.this.djr);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void sI(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fXQ = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fXR);
        this.mHandler.postDelayed(this.fXR, 300L);
        this.fXQ = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.djr = aVar;
    }

    public void aBV() {
        if (this.fXP != null) {
            this.fXP.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fXR);
    }
}
