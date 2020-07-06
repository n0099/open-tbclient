package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a hlW;
    private SearchEmotionModel kqU;
    private String kqV;
    private Runnable kqW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.kqV) && b.this.hlW != null) {
                if (b.this.kqU == null) {
                    b.this.kqU = new SearchEmotionModel();
                }
                b.this.kqU.a(b.this.kqV, 0, 30, b.this.hlW);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Kn(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kqV = "";
            return;
        }
        this.mHandler.removeCallbacks(this.kqW);
        this.mHandler.postDelayed(this.kqW, 300L);
        this.kqV = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.hlW = aVar;
    }

    public void caS() {
        if (this.kqU != null) {
            this.kqU.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.kqW);
    }
}
