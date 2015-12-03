package com.baidu.tieba.imMessageCenter.mention;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ bc cfn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bc bcVar) {
        this.cfn = bcVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        try {
            CustomViewPager adp = this.cfn.adI().adp();
            if (adp != null) {
                i5 = adp.getHeight();
            }
            int height = this.cfn.getFragmentActivity().getWindow().getDecorView().getRootView().getHeight();
            z = this.cfn.mLayoutHasInit;
            if (!z) {
                this.cfn.mLayoutHasInit = true;
                this.cfn.mMaxHeight = i5;
            } else {
                bc bcVar = this.cfn;
                i = this.cfn.mMaxHeight;
                bcVar.mMaxHeight = i < i5 ? i5 : this.cfn.mMaxHeight;
            }
            z2 = this.cfn.mLayoutHasInit;
            if (z2) {
                i2 = this.cfn.mMaxHeight;
                if (i2 > i5) {
                    i3 = this.cfn.mPreHeight;
                    if (i5 != i3) {
                        i4 = this.cfn.mMaxHeight;
                        int i6 = i4 - i5;
                        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanSet(i6) && i6 < (height * 2) / 3 && TbadkCoreApplication.m411getInst().getKeyboardHeight() != i6) {
                            TbadkCoreApplication.m411getInst().setKeyboardHeight(i6);
                            this.cfn.onKeyboardHeightChanged(i6);
                        }
                    }
                }
            }
            this.cfn.mPreHeight = i5;
        } catch (Exception e) {
        }
    }
}
