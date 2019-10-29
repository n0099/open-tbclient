package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a fhE;
    private SearchEmotionModel hZo;
    private String hZp;
    private Runnable hZq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hZp) && b.this.fhE != null) {
                if (b.this.hZo == null) {
                    b.this.hZo = new SearchEmotionModel();
                }
                b.this.hZo.a(b.this.hZp, 0, 30, b.this.fhE);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Be(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hZp = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hZq);
        this.mHandler.postDelayed(this.hZq, 300L);
        this.hZp = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.fhE = aVar;
    }

    public void bmv() {
        if (this.hZo != null) {
            this.hZo.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hZq);
    }
}
