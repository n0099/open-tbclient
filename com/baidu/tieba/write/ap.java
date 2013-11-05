package com.baidu.tieba.write;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ap implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.f2637a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r4 == r0) goto L22;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        GridView gridView;
        EditText editText2;
        WriteData writeData;
        EditText editText3;
        WriteData writeData2;
        EditText editText4;
        ImageView imageView;
        Button button;
        editText = this.f2637a.e;
        if (view != editText) {
            imageView = this.f2637a.k;
            if (view != imageView) {
                button = this.f2637a.l;
            }
        }
        if (z) {
            gridView = this.f2637a.u;
            gridView.setVisibility(8);
            this.f2637a.f();
            this.f2637a.W = true;
            this.f2637a.e();
            this.f2637a.d(8);
        }
        editText2 = this.f2637a.g;
        if (view == editText2) {
            if (z) {
                this.f2637a.W = false;
                this.f2637a.e();
                writeData2 = this.f2637a.f2619a;
                if (writeData2.getType() == 0) {
                    editText4 = this.f2637a.g;
                    editText4.setHint((CharSequence) null);
                    return;
                }
                return;
            }
            writeData = this.f2637a.f2619a;
            if (writeData.getType() == 0) {
                editText3 = this.f2637a.g;
                editText3.setHint(R.string.content);
            }
        }
    }
}
