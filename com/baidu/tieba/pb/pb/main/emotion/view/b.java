package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a iRt;
    private SearchEmotionModel lZs;
    private String lZt;
    private Runnable lZu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lZt) && b.this.iRt != null) {
                if (b.this.lZs == null) {
                    b.this.lZs = new SearchEmotionModel();
                }
                b.this.lZs.a(b.this.lZt, 0, 30, b.this.iRt);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Qi(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lZt = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lZu);
        this.mHandler.postDelayed(this.lZu, 300L);
        this.lZt = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iRt = aVar;
    }

    public void cIc() {
        if (this.lZs != null) {
            this.lZs.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lZu);
    }
}
