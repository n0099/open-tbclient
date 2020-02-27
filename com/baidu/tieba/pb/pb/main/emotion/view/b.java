package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gaB;
    private SearchEmotionModel iSx;
    private String iSy;
    private Runnable iSz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.iSy) && b.this.gaB != null) {
                if (b.this.iSx == null) {
                    b.this.iSx = new SearchEmotionModel();
                }
                b.this.iSx.a(b.this.iSy, 0, 30, b.this.gaB);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Go(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iSy = "";
            return;
        }
        this.mHandler.removeCallbacks(this.iSz);
        this.mHandler.postDelayed(this.iSz, 300L);
        this.iSy = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gaB = aVar;
    }

    public void bGt() {
        if (this.iSx != null) {
            this.iSx.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.iSz);
    }
}
