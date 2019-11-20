package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a fgN;
    private SearchEmotionModel hYx;
    private String hYy;
    private Runnable hYz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hYy) && b.this.fgN != null) {
                if (b.this.hYx == null) {
                    b.this.hYx = new SearchEmotionModel();
                }
                b.this.hYx.a(b.this.hYy, 0, 30, b.this.fgN);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Be(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hYy = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hYz);
        this.mHandler.postDelayed(this.hYz, 300L);
        this.hYy = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.fgN = aVar;
    }

    public void bmt() {
        if (this.hYx != null) {
            this.hYx.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hYz);
    }
}
