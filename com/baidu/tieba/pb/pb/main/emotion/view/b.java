package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes7.dex */
public class b {
    private SearchEmotionModel.a fYB;
    private SearchEmotionModel iRc;
    private String iRd;
    private Runnable iRe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.iRd) && b.this.fYB != null) {
                if (b.this.iRc == null) {
                    b.this.iRc = new SearchEmotionModel();
                }
                b.this.iRc.a(b.this.iRd, 0, 30, b.this.fYB);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void FZ(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iRd = "";
            return;
        }
        this.mHandler.removeCallbacks(this.iRe);
        this.mHandler.postDelayed(this.iRe, 300L);
        this.iRd = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.fYB = aVar;
    }

    public void bER() {
        if (this.iRc != null) {
            this.iRc.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.iRe);
    }
}
