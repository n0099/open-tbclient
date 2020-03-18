package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gby;
    private SearchEmotionModel iUm;
    private String iUn;
    private Runnable iUo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.iUn) && b.this.gby != null) {
                if (b.this.iUm == null) {
                    b.this.iUm = new SearchEmotionModel();
                }
                b.this.iUm.a(b.this.iUn, 0, 30, b.this.gby);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void Go(String str) {
        if (TextUtils.isEmpty(str)) {
            this.iUn = "";
            return;
        }
        this.mHandler.removeCallbacks(this.iUo);
        this.mHandler.postDelayed(this.iUo, 300L);
        this.iUn = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gby = aVar;
    }

    public void bGI() {
        if (this.iUm != null) {
            this.iUm.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.iUo);
    }
}
