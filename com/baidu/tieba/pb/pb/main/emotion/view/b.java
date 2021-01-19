package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a iMM;
    private SearchEmotionModel lUO;
    private String lUP;
    private Runnable lUQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lUP) && b.this.iMM != null) {
                if (b.this.lUO == null) {
                    b.this.lUO = new SearchEmotionModel();
                }
                b.this.lUO.a(b.this.lUP, 0, 30, b.this.iMM);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Pb(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lUP = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lUQ);
        this.mHandler.postDelayed(this.lUQ, 300L);
        this.lUP = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iMM = aVar;
    }

    public void cEk() {
        if (this.lUO != null) {
            this.lUO.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lUQ);
    }
}
