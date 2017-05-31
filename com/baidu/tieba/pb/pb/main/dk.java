package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements d.a {
    final /* synthetic */ dh eor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dh dhVar) {
        this.eor = dhVar;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        if (view != null) {
            if (!(view instanceof NoPressedLinearLayout)) {
                int i = 0;
                for (ViewParent parent = view.getParent(); parent != null && i < 10; parent = parent.getParent()) {
                    if (!(parent instanceof NoPressedLinearLayout)) {
                        i++;
                    } else {
                        this.eor.a((NoPressedLinearLayout) parent);
                        return true;
                    }
                }
                return true;
            }
            this.eor.a((NoPressedLinearLayout) view);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean c(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.a.d dVar;
        com.baidu.tieba.pb.a.d dVar2;
        com.baidu.tieba.pb.a.d dVar3;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        dVar = this.eor.aOc;
        if (dVar != null) {
            if (view instanceof TbListTextView) {
                onClickListener = this.eor.cvw;
                if (onClickListener != null) {
                    onClickListener2 = this.eor.cvw;
                    onClickListener2.onClick(view);
                    return true;
                }
            }
            dVar2 = this.eor.aOc;
            dVar2.aQ(view);
            dVar3 = this.eor.aOc;
            dVar3.onSingleTapConfirmed(motionEvent);
            return true;
        }
        return true;
    }
}
