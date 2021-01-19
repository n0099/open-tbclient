package com.baidu.tieba.yuyinala.liveroom.rename;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.message.RenameRoom;
import com.baidu.live.message.YuyinRenameRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.yuyinala.liveroom.rename.e;
/* loaded from: classes10.dex */
public class c implements View.OnClickListener {
    private x aBr;
    private TextView bPw;
    private TextView bPx;
    private EditText hKK;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView oos;
    private e oou;
    private a oov;
    int oot = 10;
    Runnable omb = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.4
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.hKK);
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void call(String str);
    }

    public c(Context context, a aVar) {
        this.mContext = context;
        this.oov = aVar;
        initDialog();
    }

    public void af(x xVar) {
        this.aBr = xVar;
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.hKK.setText(xVar.aGy.room_name.trim());
                this.hKK.setSelection(xVar.aGy.room_name.trim().length());
                this.hKK.requestFocus();
                this.hKK.post(this.omb);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            cjV();
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bPx) {
            cjV();
            dismiss();
        }
        if (view == this.bPw && this.oou != null && this.aBr != null && this.aBr.aGy != null) {
            this.oou.e(this.aBr.aGy.aQH, 1, String.valueOf(this.aBr.aGy.live_id), this.hKK.getText().toString());
            this.oou.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.1
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    if (c.this.oov != null) {
                        c.this.oov.call(c.this.hKK.getText().toString());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinRenameRoomMessage(new RenameRoom(c.this.hKK.getText().toString())));
                    c.this.dismiss();
                    BdUtilHelper.showToast(c.this.mContext, "房间名称修改成功", 3000);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void n(int i, String str, String str2) {
                    if (i == 210009) {
                        BdUtilHelper.showToast(c.this.mContext, str2, 3000);
                    } else {
                        BdUtilHelper.showToast(c.this.mContext, str, 3000);
                    }
                }
            });
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
        this.oou = new e(this.mContext);
        FP();
        initView();
    }

    private void FP() {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setSoftInputMode(16);
            if (((WindowManager) this.mDialog.getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = ScreenHelper.getRealScreenHeight(this.mContext) - UtilHelper.getStatusBarHeight();
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.yuyin_room_rename_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.hKK = (EditText) this.mRootView.findViewById(a.f.edit_rename);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.bPw = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bPx = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.oos = (TextView) this.mRootView.findViewById(a.f.tv_count);
        this.mRootView.setOnClickListener(this);
        this.bPw.setOnClickListener(this);
        this.bPx.setOnClickListener(this);
        this.hKK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.oos != null) {
                    c.this.oos.setText(c.this.mContext.getString(a.h.yuyin_ala_rename_room_title_limit, Integer.valueOf(b.w(charSequence))));
                    if (b.w(charSequence) == 0) {
                        c.this.bPw.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                        c.this.bPw.setEnabled(false);
                        return;
                    }
                    c.this.bPw.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    c.this.bPw.setEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.hKK.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.3
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(" ") || b.w(spanned) + b.w(charSequence) > c.this.oot) {
                    return "";
                }
                return charSequence;
            }
        }});
    }

    protected void cjV() {
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.mRootView);
    }
}
