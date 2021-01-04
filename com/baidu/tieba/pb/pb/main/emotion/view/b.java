package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a iRt;
    private SearchEmotionModel lZt;
    private String lZu;
    private Runnable lZv = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lZu) && b.this.iRt != null) {
                if (b.this.lZt == null) {
                    b.this.lZt = new SearchEmotionModel();
                }
                b.this.lZt.a(b.this.lZu, 0, 30, b.this.iRt);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Qj(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lZu = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lZv);
        this.mHandler.postDelayed(this.lZv, 300L);
        this.lZu = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iRt = aVar;
    }

    public void cIb() {
        if (this.lZt != null) {
            this.lZt.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lZv);
    }
}
