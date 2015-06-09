package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected PbEditorToolButtonContainer crd;
    protected TextView cre;
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
        return this.cre;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    protected void initialize() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.pb_editor_tool_view, this, true);
        this.crd = (PbEditorToolButtonContainer) findViewById(com.baidu.tieba.q.tool_button_container);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.q.reply_content);
        this.cre = (TextView) findViewById(com.baidu.tieba.q.pb_reply_post);
        this.mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
    }

    public void T(ArrayList<String> arrayList) {
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
        this.crd.setOnActionListener(new x(this, vVar));
        this.mEditText.setOnTouchListener(new y(this, vVar));
        this.mEditText.addTextChangedListener(new z(this, vVar));
        this.cre.setOnClickListener(new aa(this, vVar));
    }

    public void clearData() {
        this.crd.zK();
        this.mEditText.setText("");
        anQ();
    }

    public void anP() {
        this.cre.setEnabled(true);
        ay.b(this.cre, com.baidu.tieba.n.cp_cont_f, 1);
    }

    public void anQ() {
        this.cre.setEnabled(false);
        ay.b(this.cre, com.baidu.tieba.n.black_alpha40, 1);
    }

    public void aoe() {
        this.crd.aoe();
    }

    public void aof() {
        this.crd.aof();
    }

    public void anf() {
        this.crd.anf();
    }

    public void setMoreFocusable(boolean z) {
        this.crd.setMoreFocusable(z);
    }

    public void changeSkinType(int i) {
        if (i == 1) {
            this.mEditText.setHintTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_e));
            this.cre.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.btn_pb_editor_post_btn));
        } else {
            this.cre.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.p.btn_pb_editor_post_btn));
            this.mEditText.setHintTextColor(this.mContext.getResources().getColor(com.baidu.tieba.n.cp_cont_e));
        }
        if (this.cre.isEnabled()) {
            anP();
        } else {
            anQ();
        }
        this.crd.changeSkinType(i);
    }
}
