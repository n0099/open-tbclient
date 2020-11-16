package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes21.dex */
public class b {
    private SearchEmotionModel.a iun;
    private SearchEmotionModel lGm;
    private String lGn;
    private Runnable lGo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lGn) && b.this.iun != null) {
                if (b.this.lGm == null) {
                    b.this.lGm = new SearchEmotionModel();
                }
                b.this.lGm.a(b.this.lGn, 0, 30, b.this.iun);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Pv(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lGn = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lGo);
        this.mHandler.postDelayed(this.lGo, 300L);
        this.lGn = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iun = aVar;
    }

    public void cAQ() {
        if (this.lGm != null) {
            this.lGm.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lGo);
    }
}
