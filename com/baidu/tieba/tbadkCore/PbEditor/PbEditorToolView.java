package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected PbEditorToolButtonContainer bUG;
    protected Button bUH;
    protected Context mContext;
    protected EditText mEditText;

    public PbEditorToolView(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public PbEditorToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    public Button getPostButton() {
        return this.bUH;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.pb_editor_tool_view, this, true);
        this.bUG = (PbEditorToolButtonContainer) findViewById(com.baidu.tieba.w.tool_button_container);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.w.reply_content);
        this.bUH = (Button) findViewById(com.baidu.tieba.w.pb_reply_post);
        this.mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
    }

    public void O(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.mEditText.getText().insert(this.mEditText.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.bUG.setOnActionListener(new ag(this, wVar));
        this.mEditText.setOnTouchListener(new ah(this, wVar));
        this.mEditText.addTextChangedListener(new ai(this, wVar));
        this.bUH.setOnClickListener(new aj(this, wVar));
    }

    public void clearData() {
        this.bUG.afO();
        this.mEditText.setText("");
        afC();
    }

    public void Yp() {
        this.bUG.er(true);
    }

    public void Yo() {
        this.bUG.er(false);
    }

    public void afB() {
        this.bUH.setEnabled(true);
        com.baidu.tbadk.core.util.ax.b(this.bUH, com.baidu.tieba.t.cp_cont_i, 3);
    }

    public void afC() {
        this.bUH.setEnabled(false);
        com.baidu.tbadk.core.util.ax.b(this.bUH, com.baidu.tieba.t.cp_cont_d, 3);
    }

    public void afN() {
        this.bUG.afN();
    }

    public void afO() {
        this.bUG.afO();
    }

    public void afP() {
        this.bUG.afP();
    }

    public void afQ() {
        this.bUG.afQ();
    }

    public void aeS() {
        this.bUG.aeS();
    }

    public void setAudioFocusable(boolean z) {
        this.bUG.setAudioFocusable(z);
    }

    public void setMoreFocusable(boolean z) {
        this.bUG.setMoreFocusable(z);
    }

    public void changeSkinType(int i) {
        this.mEditText.setHintTextColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.pb_editor_edittext_hint_text));
        this.bUH.setBackgroundDrawable(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.btn_pb_editor_post_btn));
        if (this.bUH.isEnabled()) {
            afB();
        } else {
            afC();
        }
        this.bUG.changeSkinType(i);
    }
}
