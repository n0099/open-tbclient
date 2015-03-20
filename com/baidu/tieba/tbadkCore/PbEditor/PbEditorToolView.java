package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected PbEditorToolButtonContainer cmO;
    protected TextView cmP;
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

    public TextView getPostButton() {
        return this.cmP;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    protected void initialize() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_editor_tool_view, this, true);
        this.cmO = (PbEditorToolButtonContainer) findViewById(com.baidu.tieba.v.tool_button_container);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.v.reply_content);
        this.cmP = (TextView) findViewById(com.baidu.tieba.v.pb_reply_post);
        this.mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
    }

    public void V(ArrayList<String> arrayList) {
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

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.cmO.setOnActionListener(new x(this, vVar));
        this.mEditText.setOnTouchListener(new y(this, vVar));
        this.mEditText.addTextChangedListener(new z(this, vVar));
        this.cmP.setOnClickListener(new aa(this, vVar));
    }

    public void clearData() {
        this.cmO.amb();
        this.mEditText.setText("");
        alO();
    }

    public void aaZ() {
        this.cmO.eN(true);
    }

    public void aaY() {
        this.cmO.eN(false);
    }

    public void alN() {
        this.cmP.setEnabled(true);
    }

    public void alO() {
        this.cmP.setEnabled(false);
    }

    public void ama() {
        this.cmO.ama();
    }

    public void amb() {
        this.cmO.amb();
    }

    public void amc() {
        this.cmO.amc();
    }

    public void amd() {
        this.cmO.amd();
    }

    public void ale() {
        this.cmO.ale();
    }

    public void setAudioFocusable(boolean z) {
        this.cmO.setAudioFocusable(z);
    }

    public void setMoreFocusable(boolean z) {
        this.cmO.setMoreFocusable(z);
    }

    public void changeSkinType(int i) {
        if (i == 1) {
            this.mEditText.setHintTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_e));
            this.cmP.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.btn_pb_editor_post_btn));
        } else {
            this.cmP.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.btn_pb_editor_post_btn));
            this.mEditText.setHintTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_e));
        }
        if (this.cmP.isEnabled()) {
            alN();
        } else {
            alO();
        }
        this.cmO.changeSkinType(i);
    }
}
