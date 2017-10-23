package com.baidu.tieba.pb.pb.main.emotion.view;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes.dex */
public class e {
    private SearchEmotionModel.a ceM;
    private SearchEmotionModel eOK;
    private String eOL;
    private Runnable eOM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(e.this.eOL) && e.this.ceM != null) {
                if (e.this.eOK == null) {
                    e.this.eOK = new SearchEmotionModel();
                }
                e.this.eOK.a(e.this.eOL, 0, 30, e.this.ceM);
            }
        }
    };
    private Handler mHandler = new Handler();

    public void pi(String str) {
        if (TextUtils.isEmpty(str)) {
            this.eOL = "";
            return;
        }
        this.mHandler.removeCallbacks(this.eOM);
        this.mHandler.postDelayed(this.eOM, 300L);
        this.eOL = str;
    }

    public void a(SearchEmotionModel.a aVar) {
        this.ceM = aVar;
    }

    public void aiy() {
        if (this.eOK != null) {
            this.eOK.cancelLoadData();
        }
        this.mHandler.removeCallbacks(this.eOM);
    }
}
