package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a cVs;
    private SearchEmotionModel fIQ;
    private String fIR;
    private Runnable fIS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fIR) && b.this.cVs != null) {
                if (b.this.fIQ == null) {
                    b.this.fIQ = new SearchEmotionModel();
                }
                b.this.fIQ.a(b.this.fIR, 0, 30, b.this.cVs);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void rx(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fIR = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fIS);
        this.mHandler.postDelayed(this.fIS, 300L);
        this.fIR = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cVs = aVar;
    }

    public void aws() {
        if (this.fIQ != null) {
            this.fIQ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fIS);
    }
}
