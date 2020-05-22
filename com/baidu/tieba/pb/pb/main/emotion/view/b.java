package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gZz;
    private SearchEmotionModel jVY;
    private String jVZ;
    private Runnable jWa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.jVZ) && b.this.gZz != null) {
                if (b.this.jVY == null) {
                    b.this.jVY = new SearchEmotionModel();
                }
                b.this.jVY.a(b.this.jVZ, 0, 30, b.this.gZz);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void JK(String str) {
        if (TextUtils.isEmpty(str)) {
            this.jVZ = "";
            return;
        }
        this.mHandler.removeCallbacks(this.jWa);
        this.mHandler.postDelayed(this.jWa, 300L);
        this.jVZ = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gZz = aVar;
    }

    public void bXE() {
        if (this.jVY != null) {
            this.jVY.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.jWa);
    }
}
