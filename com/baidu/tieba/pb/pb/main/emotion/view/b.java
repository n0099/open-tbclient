package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a cVo;
    private SearchEmotionModel fIJ;
    private String fIK;
    private Runnable fIL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.fIK) && b.this.cVo != null) {
                if (b.this.fIJ == null) {
                    b.this.fIJ = new SearchEmotionModel();
                }
                b.this.fIJ.a(b.this.fIK, 0, 30, b.this.cVo);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void rA(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fIK = "";
            return;
        }
        this.mHandler.removeCallbacks(this.fIL);
        this.mHandler.postDelayed(this.fIL, 300L);
        this.fIK = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.cVo = aVar;
    }

    public void awr() {
        if (this.fIJ != null) {
            this.fIJ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.fIL);
    }
}
