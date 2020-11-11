package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes22.dex */
public class b {
    private SearchEmotionModel.a itz;
    private SearchEmotionModel lFV;
    private String lFW;
    private Runnable lFX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lFW) && b.this.itz != null) {
                if (b.this.lFV == null) {
                    b.this.lFV = new SearchEmotionModel();
                }
                b.this.lFV.a(b.this.lFW, 0, 30, b.this.itz);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void PZ(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lFW = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lFX);
        this.mHandler.postDelayed(this.lFX, 300L);
        this.lFW = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.itz = aVar;
    }

    public void cBn() {
        if (this.lFV != null) {
            this.lFV.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lFX);
    }
}
