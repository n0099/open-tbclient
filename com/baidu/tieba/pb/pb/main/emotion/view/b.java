package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes22.dex */
public class b {
    private SearchEmotionModel.a inC;
    private String lAa;
    private SearchEmotionModel lzZ;
    private Runnable lAb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lAa) && b.this.inC != null) {
                if (b.this.lzZ == null) {
                    b.this.lzZ = new SearchEmotionModel();
                }
                b.this.lzZ.a(b.this.lAa, 0, 30, b.this.inC);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void PI(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lAa = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lAb);
        this.mHandler.postDelayed(this.lAb, 300L);
        this.lAa = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.inC = aVar;
    }

    public void cyM() {
        if (this.lzZ != null) {
            this.lzZ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lAb);
    }
}
