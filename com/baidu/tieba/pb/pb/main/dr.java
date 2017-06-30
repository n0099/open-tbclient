package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements d.a {
    final /* synthetic */ Cdo exx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(Cdo cdo) {
        this.exx = cdo;
    }

    @Override // com.baidu.tieba.pb.a.d.a
    public boolean a(View view, MotionEvent motionEvent) {
        if (view != null && (this.exx.euf == null || this.exx.euf.aNy() == null || this.exx.euf.aNy().aQf())) {
            if (!(view instanceof NoPressedLinearLayout)) {
                ViewParent parent = view.getParent();
                int i = 0;
                while (true) {
                    if (parent == null || i >= 10) {
                        break;
                    } else if (!(parent instanceof NoPressedLinearLayout)) {
                        i++;
                        parent = parent.getParent();
                    } else {
                        this.exx.a((NoPressedLinearLayout) parent);
                        break;
                    }
                }
            } else {
                this.exx.a((NoPressedLinearLayout) view);
            }
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
        dVar = this.exx.aPs;
        if (dVar != null) {
            if (view instanceof TbListTextView) {
                onClickListener = this.exx.cDj;
                if (onClickListener != null) {
                    onClickListener2 = this.exx.cDj;
                    onClickListener2.onClick(view);
                    return true;
                }
            }
            dVar2 = this.exx.aPs;
            dVar2.aS(view);
            dVar3 = this.exx.aPs;
            dVar3.onSingleTapConfirmed(motionEvent);
            return true;
        }
        return true;
    }
}
