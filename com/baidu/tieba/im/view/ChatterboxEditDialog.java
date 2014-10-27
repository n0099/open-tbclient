package com.baidu.tieba.im.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class ChatterboxEditDialog extends Dialog implements View.OnClickListener {
    private final int SHOW_INPUT_METHOD;
    private Button mCancel;
    private Button mConfirm;
    private Context mContextt;
    private EditText mEditText;
    private final Handler mHandler;
    private c mOnSelectedClickListener;
    private String mSelectedContent;
    private String mSelectedText;
    private TextView mSizeTip;

    public void setSelectText(String str) {
        this.mSelectedText = str;
    }

    public void setSelectedContent(String str) {
        this.mSelectedContent = str;
    }

    public ChatterboxEditDialog(Context context) {
        super(context);
        this.mContextt = null;
        this.mConfirm = null;
        this.mCancel = null;
        this.mSizeTip = null;
        this.mEditText = null;
        this.mOnSelectedClickListener = null;
        this.mSelectedText = null;
        this.mSelectedContent = null;
        this.SHOW_INPUT_METHOD = 0;
        this.mHandler = new d(this);
        this.mContextt = context;
    }

    public ChatterboxEditDialog(Context context, int i) {
        super(context, i);
        this.mContextt = null;
        this.mConfirm = null;
        this.mCancel = null;
        this.mSizeTip = null;
        this.mEditText = null;
        this.mOnSelectedClickListener = null;
        this.mSelectedText = null;
        this.mSelectedContent = null;
        this.SHOW_INPUT_METHOD = 0;
        this.mHandler = new d(this);
        this.mContextt = context;
    }

    public void setOnSelectedClickListener(c cVar) {
        this.mOnSelectedClickListener = cVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.chatterbox_edit_dialog);
        this.mConfirm = (Button) findViewById(v.chatterbox_edit_confirm);
        this.mCancel = (Button) findViewById(v.chatterbox_edit_cancel);
        this.mCancel.setOnClickListener(this);
        this.mConfirm.setOnClickListener(this);
        this.mSizeTip = (TextView) findViewById(v.size_tip);
        this.mEditText = (EditText) findViewById(v.chat_editText);
        this.mSizeTip.setText(MessageFormat.format(this.mContextt.getResources().getString(y.chat_custom_default_text), "0"));
        this.mEditText.addTextChangedListener(new e(this));
    }

    @Override // android.app.Dialog
    public void show() {
        if (!(this.mContextt instanceof Activity) || com.baidu.adp.lib.g.j.e((Activity) this.mContextt)) {
            super.show();
            this.mHandler.sendEmptyMessage(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.mCancel && view == this.mConfirm) {
            this.mSelectedText = this.mEditText.getText().toString().trim().replace("\n", "").replace("\t", "");
            this.mSelectedContent = null;
            if (TextUtils.isEmpty(this.mSelectedText)) {
                UtilHelper.showToast(TbadkApplication.m251getInst().getApp().getApplicationContext(), y.chat_input);
                return;
            } else if (this.mOnSelectedClickListener != null) {
                this.mOnSelectedClickListener.f(this.mSelectedText, this.mSelectedContent, false);
            }
        }
        cancel();
    }
}
