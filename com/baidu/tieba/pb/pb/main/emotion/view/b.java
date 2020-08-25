package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes16.dex */
public class b {
    private SearchEmotionModel.a hEY;
    private String kPA;
    private SearchEmotionModel kPz;
    private Runnable kPB = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.kPA) && b.this.hEY != null) {
                if (b.this.kPz == null) {
                    b.this.kPz = new SearchEmotionModel();
                }
                b.this.kPz.a(b.this.kPA, 0, 30, b.this.hEY);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void NT(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kPA = "";
            return;
        }
        this.mHandler.removeCallbacks(this.kPB);
        this.mHandler.postDelayed(this.kPB, 300L);
        this.kPA = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.hEY = aVar;
    }

    public void coU() {
        if (this.kPz != null) {
            this.kPz.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.kPB);
    }
}
