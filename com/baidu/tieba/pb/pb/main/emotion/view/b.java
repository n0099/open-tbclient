package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a cKt;
    private SearchEmotionModel fsf;
    private String fsg;
    private Runnable fsh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fsg) && b.this.cKt != null) {
                if (b.this.fsf == null) {
                    b.this.fsf = new SearchEmotionModel();
                }
                b.this.fsf.a(b.this.fsg, 0, 30, b.this.cKt);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void qN(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fsg = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fsh);
        this.mHandler.postDelayed(this.fsh, 300L);
        this.fsg = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cKt = aVar;
    }

    public void arg() {
        if (this.fsf != null) {
            this.fsf.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fsh);
    }
}
