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
    protected PbEditorToolButtonContainer crc;
    protected TextView crd;
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
        return this.crd;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    protected void initialize() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.pb_editor_tool_view, this, true);
        this.crc = (PbEditorToolButtonContainer) findViewById(com.baidu.tieba.q.tool_button_container);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.q.reply_content);
        this.crd = (TextView) findViewById(com.baidu.tieba.q.pb_reply_post);
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
        this.crc.setOnActionListener(new x(this, vVar));
        this.mEditText.setOnTouchListener(new y(this, vVar));
        this.mEditText.addTextChangedListener(new z(this, vVar));
        this.crd.setOnClickListener(new aa(this, vVar));
    }

    public void clearData() {
        this.crc.zJ();
        this.mEditText.setText("");
        anP();
    }

    public void anO() {
        this.crd.setEnabled(true);
        ay.b(this.crd, com.baidu.tieba.n.cp_cont_f, 1);
    }

    public void anP() {
        this.crd.setEnabled(false);
        ay.b(this.crd, com.baidu.tieba.n.black_alpha40, 1);
    }

    public void aod() {
        this.crc.aod();
    }

    public void aoe() {
        this.crc.aoe();
    }

    public void ane() {
        this.crc.ane();
    }

    public void setMoreFocusable(boolean z) {
        this.crc.setMoreFocusable(z);
    }

    public void changeSkinType(int i) {
        if (i == 1) {
            this.mEditText.setHintTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_e));
            this.crd.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.btn_pb_editor_post_btn));
        } else {
            this.crd.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.p.btn_pb_editor_post_btn));
            this.mEditText.setHintTextColor(this.mContext.getResources().getColor(com.baidu.tieba.n.cp_cont_e));
        }
        if (this.crd.isEnabled()) {
            anO();
        } else {
            anP();
        }
        this.crc.changeSkinType(i);
    }
}
