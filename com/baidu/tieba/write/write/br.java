package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class br implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
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
        editText = this.cCQ.cAv;
        if (view != editText) {
            view2 = this.cCQ.mBack;
            if (view != view2) {
                textView2 = this.cCQ.cAA;
            }
        }
        if (!z) {
            editText2 = this.cCQ.cAv;
            if (view == editText2) {
                textView = this.cCQ.cAB;
                textView.setVisibility(0);
            }
        } else {
            this.cCQ.cCO = true;
            this.cCQ.atg();
            tbEditorToolButtonContainer = this.cCQ.cCy;
            tbEditorToolButtonContainer.anf();
            editorToolComponetContainer = this.cCQ.cqP;
            editText3 = this.cCQ.cAv;
            editorToolComponetContainer.ab(editText3);
        }
        editText4 = this.cCQ.cAz;
        if (view == editText4) {
            if (!z) {
                writeData = this.cCQ.cup;
                if (writeData.getType() == 0) {
                    editText5 = this.cCQ.cAz;
                    editText5.setHint(com.baidu.tieba.t.content);
                    return;
                }
                return;
            }
            this.cCQ.cCO = false;
            writeData2 = this.cCQ.cup;
            if (writeData2.getType() == 0) {
                editText7 = this.cCQ.cAz;
                editText7.setHint((CharSequence) null);
            }
            this.cCQ.atg();
            tbEditorToolButtonContainer2 = this.cCQ.cCy;
            tbEditorToolButtonContainer2.anf();
            editorToolComponetContainer2 = this.cCQ.cqP;
            editText6 = this.cCQ.cAz;
            editorToolComponetContainer2.ab(editText6);
        }
    }
}
