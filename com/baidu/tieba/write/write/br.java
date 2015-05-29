package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class br implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(WriteActivity writeActivity) {
        this.cCP = writeActivity;
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
        EditText editText2;
        TextView textView;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText6;
        EditText editText7;
        View view2;
        TextView textView2;
        editText = this.cCP.cAu;
        if (view != editText) {
            view2 = this.cCP.mBack;
            if (view != view2) {
                textView2 = this.cCP.cAz;
            }
        }
        if (!z) {
            editText2 = this.cCP.cAu;
            if (view == editText2) {
                textView = this.cCP.cAA;
                textView.setVisibility(0);
            }
        } else {
            this.cCP.cCN = true;
            this.cCP.atf();
            tbEditorToolButtonContainer = this.cCP.cCx;
            tbEditorToolButtonContainer.ane();
            editorToolComponetContainer = this.cCP.cqO;
            editText3 = this.cCP.cAu;
            editorToolComponetContainer.ab(editText3);
        }
        editText4 = this.cCP.cAy;
        if (view == editText4) {
            if (!z) {
                writeData = this.cCP.cuo;
                if (writeData.getType() == 0) {
                    editText5 = this.cCP.cAy;
                    editText5.setHint(com.baidu.tieba.t.content);
                    return;
                }
                return;
            }
            this.cCP.cCN = false;
            writeData2 = this.cCP.cuo;
            if (writeData2.getType() == 0) {
                editText7 = this.cCP.cAy;
                editText7.setHint((CharSequence) null);
            }
            this.cCP.atf();
            tbEditorToolButtonContainer2 = this.cCP.cCx;
            tbEditorToolButtonContainer2.ane();
            editorToolComponetContainer2 = this.cCP.cqO;
            editText6 = this.cCP.cAy;
            editorToolComponetContainer2.ab(editText6);
        }
    }
}
