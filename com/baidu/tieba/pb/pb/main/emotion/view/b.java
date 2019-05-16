package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {
    private SearchEmotionModel.a eXF;
    private SearchEmotionModel hRw;
    private String hRx;
    private Runnable hRy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.hRx) && b.this.eXF != null) {
                if (b.this.hRw == null) {
                    b.this.hRw = new SearchEmotionModel();
                }
                b.this.hRw.a(b.this.hRx, 0, 30, b.this.eXF);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Bx(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hRx = "";
            return;
        }
        this.mHandler.removeCallbacks(this.hRy);
        this.mHandler.postDelayed(this.hRy, 300L);
        this.hRx = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.eXF = aVar;
    }

    public void bmo() {
        if (this.hRw != null) {
            this.hRw.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.hRy);
    }
}
