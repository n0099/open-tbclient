package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a djr;
    private SearchEmotionModel fXQ;
    private String fXR;
    private Runnable fXS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fXR) && b.this.djr != null) {
                if (b.this.fXQ == null) {
                    b.this.fXQ = new SearchEmotionModel();
                }
                b.this.fXQ.a(b.this.fXR, 0, 30, b.this.djr);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void sI(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fXR = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fXS);
        this.mHandler.postDelayed(this.fXS, 300L);
        this.fXR = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.djr = aVar;
    }

    public void aBW() {
        if (this.fXQ != null) {
            this.fXQ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fXS);
    }
}
