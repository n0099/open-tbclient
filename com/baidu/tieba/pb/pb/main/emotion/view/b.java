package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes16.dex */
public class b {
    private SearchEmotionModel.a hFe;
    private SearchEmotionModel kPG;
    private String kPH;
    private Runnable kPI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.kPH) && b.this.hFe != null) {
                if (b.this.kPG == null) {
                    b.this.kPG = new SearchEmotionModel();
                }
                b.this.kPG.a(b.this.kPH, 0, 30, b.this.hFe);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void NU(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kPH = "";
            return;
        }
        this.mHandler.removeCallbacks(this.kPI);
        this.mHandler.postDelayed(this.kPI, 300L);
        this.kPH = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.hFe = aVar;
    }

    public void coV() {
        if (this.kPG != null) {
            this.kPG.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.kPI);
    }
}
