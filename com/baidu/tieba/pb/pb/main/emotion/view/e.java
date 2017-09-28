package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes.dex */
public class e {
    private SearchEmotionModel.a ceY;
    private SearchEmotionModel eOY;
    private String eOZ;
    private Runnable ePa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(e.this.eOZ) && e.this.ceY != null) {
                if (e.this.eOY == null) {
                    e.this.eOY = new SearchEmotionModel();
                }
                e.this.eOY.a(e.this.eOZ, 0, 30, e.this.ceY);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void pj(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eOZ = "";
            return;
        }
        this.mHandler.removeCallbacks(this.ePa);
        this.mHandler.postDelayed(this.ePa, 300L);
        this.eOZ = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.ceY = aVar;
    }

    public void aiD() {
        if (this.eOY != null) {
            this.eOY.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.ePa);
    }
}
