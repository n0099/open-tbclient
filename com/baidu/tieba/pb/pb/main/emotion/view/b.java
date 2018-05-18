package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a cLx;
    private SearchEmotionModel ftj;
    private String ftk;
    private Runnable ftl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.ftk) && b.this.cLx != null) {
                if (b.this.ftj == null) {
                    b.this.ftj = new SearchEmotionModel();
                }
                b.this.ftj.a(b.this.ftk, 0, 30, b.this.cLx);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qQ(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ftk = "";
            return;
        }
        this.mHandler.removeCallbacks(this.ftl);
        this.mHandler.postDelayed(this.ftl, 300L);
        this.ftk = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cLx = aVar;
    }

    public void arf() {
        if (this.ftj != null) {
            this.ftj.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.ftl);
    }
}
