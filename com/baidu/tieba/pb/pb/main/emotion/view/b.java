package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes2.dex */
public class b {
    private SearchEmotionModel.a iSH;
    private SearchEmotionModel meh;
    private String mei;
    private Runnable mej = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(b.this.mei) && b.this.iSH != null) {
                if (b.this.meh == null) {
                    b.this.meh = new SearchEmotionModel();
                }
                b.this.meh.a(b.this.mei, 0, 30, b.this.iSH);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void PT(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mei = "";
            return;
        }
        this.mHandler.removeCallbacks(this.mej);
        this.mHandler.postDelayed(this.mej, 300L);
        this.mei = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.iSH = aVar;
    }

    public void cFE() {
        if (this.meh != null) {
            this.meh.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.mej);
    }
}
