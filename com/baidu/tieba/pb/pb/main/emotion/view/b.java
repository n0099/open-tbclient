package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gaQ;
    private SearchEmotionModel iSL;
    private String iSM;
    private Runnable iSN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.iSM) && b.this.gaQ != null) {
                if (b.this.iSL == null) {
                    b.this.iSL = new SearchEmotionModel();
                }
                b.this.iSL.a(b.this.iSM, 0, 30, b.this.gaQ);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Gp(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iSM = "";
            return;
        }
        this.mHandler.removeCallbacks(this.iSN);
        this.mHandler.postDelayed(this.iSN, 300L);
        this.iSM = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gaQ = aVar;
    }

    public void bGw() {
        if (this.iSL != null) {
            this.iSL.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.iSN);
    }
}
