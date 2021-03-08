package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a iUq;
    private SearchEmotionModel mgk;
    private String mgl;
    private Runnable mgm = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.mgl) && b.this.iUq != null) {
                if (b.this.mgk == null) {
                    b.this.mgk = new SearchEmotionModel();
                }
                b.this.mgk.a(b.this.mgl, 0, 30, b.this.iUq);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void PZ(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mgl = "";
            return;
        }
        this.mHandler.removeCallbacks(this.mgm);
        this.mHandler.postDelayed(this.mgm, 300L);
        this.mgl = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iUq = aVar;
    }

    public void cFK() {
        if (this.mgk != null) {
            this.mgk.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.mgm);
    }
}
