package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a cSF;
    private SearchEmotionModel fIB;
    private String fIC;
    private Runnable fID = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fIC) && b.this.cSF != null) {
                if (b.this.fIB == null) {
                    b.this.fIB = new SearchEmotionModel();
                }
                b.this.fIB.a(b.this.fIC, 0, 30, b.this.cSF);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void rD(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fIC = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fID);
        this.mHandler.postDelayed(this.fID, 300L);
        this.fIC = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cSF = aVar;
    }

    public void avN() {
        if (this.fIB != null) {
            this.fIB.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fID);
    }
}
