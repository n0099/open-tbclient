package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ag implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.f2663a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L22;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditText editText3;
        WriteData writeData;
        EditText editText4;
        WriteData writeData2;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText5;
        EditText editText6;
        ImageView imageView;
        TextView textView;
        editText = this.f2663a.f;
        if (view != editText) {
            imageView = this.f2663a.l;
            if (view != imageView) {
                textView = this.f2663a.m;
            }
        }
        if (z) {
            this.f2663a.G = true;
            this.f2663a.n();
            writeEditorToolButtonContainer = this.f2663a.A;
            writeEditorToolButtonContainer.c();
            editorToolComponetContainer = this.f2663a.B;
            editText2 = this.f2663a.f;
            editorToolComponetContainer.c(editText2);
        }
        editText3 = this.f2663a.h;
        if (view == editText3) {
            if (z) {
                this.f2663a.G = false;
                writeData2 = this.f2663a.b;
                if (writeData2.getType() == 0) {
                    editText6 = this.f2663a.h;
                    editText6.setHint((CharSequence) null);
                }
                this.f2663a.n();
                writeEditorToolButtonContainer2 = this.f2663a.A;
                writeEditorToolButtonContainer2.c();
                editorToolComponetContainer2 = this.f2663a.B;
                editText5 = this.f2663a.h;
                editorToolComponetContainer2.c(editText5);
                return;
            }
            writeData = this.f2663a.b;
            if (writeData.getType() == 0) {
                editText4 = this.f2663a.h;
                editText4.setHint(R.string.content);
            }
        }
    }
}
