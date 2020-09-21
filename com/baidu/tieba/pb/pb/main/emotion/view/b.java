package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes21.dex */
public class b {
    private SearchEmotionModel.a hMf;
    private SearchEmotionModel kYi;
    private String kYj;
    private Runnable kYk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.kYj) && b.this.hMf != null) {
                if (b.this.kYi == null) {
                    b.this.kYi = new SearchEmotionModel();
                }
                b.this.kYi.a(b.this.kYj, 0, 30, b.this.hMf);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Ov(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kYj = "";
            return;
        }
        this.mHandler.removeCallbacks(this.kYk);
        this.mHandler.postDelayed(this.kYk, 300L);
        this.kYj = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.hMf = aVar;
    }

    public void csi() {
        if (this.kYi != null) {
            this.kYi.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.kYk);
    }
}
