package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends DefaultBaiduListener {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ boolean b;
    final /* synthetic */ bb dWn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bb bbVar, IBaiduListener iBaiduListener, ShareContent shareContent, boolean z) {
        super(iBaiduListener);
        this.dWn = bbVar;
        this.a = shareContent;
        this.b = z;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.dWn.share(this.a, this.mListener, this.b);
    }
}
