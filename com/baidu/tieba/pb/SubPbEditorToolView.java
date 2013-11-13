package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SubPbEditorToolView extends PbEditorToolView {
    @Override // com.baidu.tieba.pb.PbEditorToolView
    public void h() {
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    @Override // com.baidu.tieba.pb.PbEditorToolView
    public void i() {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    }

    public SubPbEditorToolView(Context context) {
        super(context);
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    public SubPbEditorToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }
}
