package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gKN;
    private String jEA;
    private SearchEmotionModel jEz;
    private Runnable jEB = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.jEA) && b.this.gKN != null) {
                if (b.this.jEz == null) {
                    b.this.jEz = new SearchEmotionModel();
                }
                b.this.jEz.a(b.this.jEA, 0, 30, b.this.gKN);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void HZ(String str) {
        if (TextUtils.isEmpty(str)) {
            this.jEA = "";
            return;
        }
        this.mHandler.removeCallbacks(this.jEB);
        this.mHandler.postDelayed(this.jEB, 300L);
        this.jEA = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gKN = aVar;
    }

    public void bRh() {
        if (this.jEz != null) {
            this.jEz.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.jEB);
    }
}
