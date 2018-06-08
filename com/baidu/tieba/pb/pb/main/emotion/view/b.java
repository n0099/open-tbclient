package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a cUD;
    private SearchEmotionModel fEA;
    private String fEB;
    private Runnable fEC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fEB) && b.this.cUD != null) {
                if (b.this.fEA == null) {
                    b.this.fEA = new SearchEmotionModel();
                }
                b.this.fEA.a(b.this.fEB, 0, 30, b.this.cUD);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void rE(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fEB = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fEC);
        this.mHandler.postDelayed(this.fEC, 300L);
        this.fEB = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cUD = aVar;
    }

    public void avk() {
        if (this.fEA != null) {
            this.fEA.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fEC);
    }
}
