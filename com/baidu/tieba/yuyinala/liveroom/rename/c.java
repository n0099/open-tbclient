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
import com.baidu.live.data.ab;
import com.baidu.live.message.RenameRoom;
import com.baidu.live.message.YuyinRenameRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.yuyinala.liveroom.rename.e;
/* loaded from: classes11.dex */
public class c implements View.OnClickListener {
    private ab aDd;
    private TextView bTm;
    private TextView bTn;
    private EditText hPs;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView oyI;
    private e oyK;
    private a oyL;
    int oyJ = 10;
    Runnable owt = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.4
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.hPs);
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void call(String str);
    }

    public c(Context context, a aVar) {
        this.mContext = context;
        this.oyL = aVar;
        initDialog();
    }

    public void ae(ab abVar) {
        this.aDd = abVar;
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.hPs.setText(abVar.aIU.room_name.trim());
                this.hPs.setSelection(abVar.aIU.room_name.trim().length());
                this.hPs.requestFocus();
                this.hPs.post(this.owt);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            cla();
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bTn) {
            cla();
            dismiss();
        }
        if (view == this.bTm && this.oyK != null && this.aDd != null && this.aDd.aIU != null) {
            this.oyK.e(this.aDd.aIU.aTK, 1, String.valueOf(this.aDd.aIU.live_id), this.hPs.getText().toString());
            this.oyK.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.1
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    if (c.this.oyL != null) {
                        c.this.oyL.call(c.this.hPs.getText().toString());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinRenameRoomMessage(new RenameRoom(c.this.hPs.getText().toString())));
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
        this.oyK = new e(this.mContext);
        Hf();
        initView();
    }

    private void Hf() {
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
        this.hPs = (EditText) this.mRootView.findViewById(a.f.edit_rename);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.bTm = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bTn = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.oyI = (TextView) this.mRootView.findViewById(a.f.tv_count);
        this.mRootView.setOnClickListener(this);
        this.bTm.setOnClickListener(this);
        this.bTn.setOnClickListener(this);
        this.hPs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.oyI != null) {
                    c.this.oyI.setText(c.this.mContext.getString(a.h.yuyin_ala_rename_room_title_limit, Integer.valueOf(b.x(charSequence))));
                    if (b.x(charSequence) == 0) {
                        c.this.bTm.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                        c.this.bTm.setEnabled(false);
                        return;
                    }
                    c.this.bTm.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    c.this.bTm.setEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.hPs.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.3
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(" ") || b.x(spanned) + b.x(charSequence) > c.this.oyJ) {
                    return "";
                }
                return charSequence;
            }
        }});
    }

    protected void cla() {
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.mRootView);
    }
}
