package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes.dex */
public class e {
    private SearchEmotionModel.a cmz;
    private SearchEmotionModel eXX;
    private String eXY;
    private Runnable eXZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(e.this.eXY) && e.this.cmz != null) {
                if (e.this.eXX == null) {
                    e.this.eXX = new SearchEmotionModel();
                }
                e.this.eXX.a(e.this.eXY, 0, 30, e.this.cmz);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void pR(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eXY = "";
            return;
        }
        this.mHandler.removeCallbacks(this.eXZ);
        this.mHandler.postDelayed(this.eXZ, 300L);
        this.eXY = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cmz = aVar;
    }

    public void akY() {
        if (this.eXX != null) {
            this.eXX.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.eXZ);
    }
}
