package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a iSt;
    private SearchEmotionModel mdS;
    private String mdT;
    private Runnable mdU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.mdT) && b.this.iSt != null) {
                if (b.this.mdS == null) {
                    b.this.mdS = new SearchEmotionModel();
                }
                b.this.mdS.a(b.this.mdT, 0, 30, b.this.iSt);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void PS(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mdT = "";
            return;
        }
        this.mHandler.removeCallbacks(this.mdU);
        this.mHandler.postDelayed(this.mdU, 300L);
        this.mdT = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iSt = aVar;
    }

    public void cFx() {
        if (this.mdS != null) {
            this.mdS.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.mdU);
    }
}
