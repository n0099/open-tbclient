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
    protected PbEditorToolButtonContainer cne;
    protected TextView cnf;
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
        return this.cnf;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    protected void initialize() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.pb_editor_tool_view, this, true);
        this.cne = (PbEditorToolButtonContainer) findViewById(com.baidu.tieba.v.tool_button_container);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.v.reply_content);
        this.cnf = (TextView) findViewById(com.baidu.tieba.v.pb_reply_post);
        this.mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
    }

    public void X(ArrayList<String> arrayList) {
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
        this.cne.setOnActionListener(new x(this, vVar));
        this.mEditText.setOnTouchListener(new y(this, vVar));
        this.mEditText.addTextChangedListener(new z(this, vVar));
        this.cnf.setOnClickListener(new aa(this, vVar));
    }

    public void clearData() {
        this.cne.amq();
        this.mEditText.setText("");
        amd();
    }

    public void abn() {
        this.cne.eL(true);
    }

    public void abm() {
        this.cne.eL(false);
    }

    public void amc() {
        this.cnf.setEnabled(true);
    }

    public void amd() {
        this.cnf.setEnabled(false);
    }

    public void amp() {
        this.cne.amp();
    }

    public void amq() {
        this.cne.amq();
    }

    public void amr() {
        this.cne.amr();
    }

    public void ams() {
        this.cne.ams();
    }

    public void alt() {
        this.cne.alt();
    }

    public void setAudioFocusable(boolean z) {
        this.cne.setAudioFocusable(z);
    }

    public void setMoreFocusable(boolean z) {
        this.cne.setMoreFocusable(z);
    }

    public void changeSkinType(int i) {
        if (i == 1) {
            this.mEditText.setHintTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_e));
            this.cnf.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.btn_pb_editor_post_btn));
        } else {
            this.cnf.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.btn_pb_editor_post_btn));
            this.mEditText.setHintTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_e));
        }
        if (this.cnf.isEnabled()) {
            amc();
        } else {
            amd();
        }
        this.cne.changeSkinType(i);
    }
}
