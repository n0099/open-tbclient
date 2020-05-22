package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0746a lQC;

    public f(Context context, a.C0746a c0746a) {
        super(context, c0746a);
        this.lQC = c0746a;
    }

    @Override // com.baidu.tieba.write.h
    public void dmo() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.lQI != null) {
                this.lQI.El(this.mState);
            }
            dml();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aiD() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.lQI != null) {
                this.lQI.El(this.mState);
            }
            dmn();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmp() {
        dmn();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void dml() {
        this.lQC.deP.setClickable(true);
        this.mState = 2;
        if (this.lQI != null) {
            this.lQI.El(this.mState);
        }
    }

    private void dmn() {
        this.lQC.deP.setClickable(false);
        this.mState = 4;
        if (this.lQI != null) {
            this.lQI.El(this.mState);
        }
    }
}
