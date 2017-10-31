package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes.dex */
public class e {
    private SearchEmotionModel.a cmg;
    private SearchEmotionModel eXC;
    private String eXD;
    private Runnable eXE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(e.this.eXD) && e.this.cmg != null) {
                if (e.this.eXC == null) {
                    e.this.eXC = new SearchEmotionModel();
                }
                e.this.eXC.a(e.this.eXD, 0, 30, e.this.cmg);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void pN(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eXD = "";
            return;
        }
        this.mHandler.removeCallbacks(this.eXE);
        this.mHandler.postDelayed(this.eXE, 300L);
        this.eXD = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cmg = aVar;
    }

    public void akK() {
        if (this.eXC != null) {
            this.eXC.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.eXE);
    }
}
