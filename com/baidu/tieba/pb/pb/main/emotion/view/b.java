package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes9.dex */
public class b {
    private SearchEmotionModel.a gKH;
    private SearchEmotionModel jEv;
    private String jEw;
    private Runnable jEx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.jEw) && b.this.gKH != null) {
                if (b.this.jEv == null) {
                    b.this.jEv = new SearchEmotionModel();
                }
                b.this.jEv.a(b.this.jEw, 0, 30, b.this.gKH);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void HW(String str) {
        if (TextUtils.isEmpty(str)) {
            this.jEw = "";
            return;
        }
        this.mHandler.removeCallbacks(this.jEx);
        this.mHandler.postDelayed(this.jEx, 300L);
        this.jEw = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.gKH = aVar;
    }

    public void bRj() {
        if (this.jEv != null) {
            this.jEv.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.jEx);
    }
}
