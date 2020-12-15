package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes22.dex */
public class b {
    private SearchEmotionModel.a iFh;
    private SearchEmotionModel lUh;
    private String lUi;
    private Runnable lUj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.lUi) && b.this.iFh != null) {
                if (b.this.lUh == null) {
                    b.this.lUh = new SearchEmotionModel();
                }
                b.this.lUh.a(b.this.lUi, 0, 30, b.this.iFh);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void QD(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lUi = "";
            return;
        }
        this.mHandler.removeCallbacks(this.lUj);
        this.mHandler.postDelayed(this.lUj, 300L);
        this.lUi = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iFh = aVar;
    }

    public void cFh() {
        if (this.lUh != null) {
            this.lUh.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.lUj);
    }
}
