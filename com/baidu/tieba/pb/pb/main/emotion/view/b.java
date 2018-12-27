package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes6.dex */
public class b {
    private SearchEmotionModel.a dtM;
    private SearchEmotionModel giZ;
    private String gja;
    private Runnable gjb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.gja) && b.this.dtM != null) {
                if (b.this.giZ == null) {
                    b.this.giZ = new SearchEmotionModel();
                }
                b.this.giZ.a(b.this.gja, 0, 30, b.this.dtM);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void to(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gja = "";
            return;
        }
        this.mHandler.removeCallbacks(this.gjb);
        this.mHandler.postDelayed(this.gjb, 300L);
        this.gja = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.dtM = aVar;
    }

    public void aDS() {
        if (this.giZ != null) {
            this.giZ.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.gjb);
    }
}
