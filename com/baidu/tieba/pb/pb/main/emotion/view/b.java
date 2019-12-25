package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a fVs;
    private SearchEmotionModel iNy;
    private String iNz;
    private Runnable iNA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.iNz) && b.this.fVs != null) {
                if (b.this.iNy == null) {
                    b.this.iNy = new SearchEmotionModel();
                }
                b.this.iNy.a(b.this.iNz, 0, 30, b.this.fVs);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void FP(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iNz = "";
            return;
        }
        this.mHandler.removeCallbacks(this.iNA);
        this.mHandler.postDelayed(this.iNA, 300L);
        this.iNz = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.fVs = aVar;
    }

    public void bDP() {
        if (this.iNy != null) {
            this.iNy.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.iNA);
    }
}
