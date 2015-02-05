package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected PbEditorToolButtonContainer bWx;
    protected TextView bWy;
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
        return this.bWy;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.pb_editor_tool_view, this, true);
        this.bWx = (PbEditorToolButtonContainer) findViewById(com.baidu.tieba.w.tool_button_container);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.w.reply_content);
        this.bWy = (TextView) findViewById(com.baidu.tieba.w.pb_reply_post);
        this.mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
    }

    public void P(ArrayList<String> arrayList) {
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
        this.bWx.setOnActionListener(new ag(this, wVar));
        this.mEditText.setOnTouchListener(new ah(this, wVar));
        this.mEditText.addTextChangedListener(new ai(this, wVar));
        this.bWy.setOnClickListener(new aj(this, wVar));
    }

    public void clearData() {
        this.bWx.agn();
        this.mEditText.setText("");
        agb();
    }

    public void YP() {
        this.bWx.ey(true);
    }

    public void YO() {
        this.bWx.ey(false);
    }

    public void aga() {
        this.bWy.setEnabled(true);
    }

    public void agb() {
        this.bWy.setEnabled(false);
    }

    public void agm() {
        this.bWx.agm();
    }

    public void agn() {
        this.bWx.agn();
    }

    public void ago() {
        this.bWx.ago();
    }

    public void agp() {
        this.bWx.agp();
    }

    public void afr() {
        this.bWx.afr();
    }

    public void setAudioFocusable(boolean z) {
        this.bWx.setAudioFocusable(z);
    }

    public void setMoreFocusable(boolean z) {
        this.bWx.setMoreFocusable(z);
    }

    public void changeSkinType(int i) {
        if (i == 1) {
            this.mEditText.setHintTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_e));
            this.bWy.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.v.btn_pb_editor_post_btn));
        } else {
            this.bWy.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.btn_pb_editor_post_btn));
            this.mEditText.setHintTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_e));
        }
        if (this.bWy.isEnabled()) {
            aga();
        } else {
            agb();
        }
        this.bWx.changeSkinType(i);
    }
}
