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
import com.baidu.live.data.w;
import com.baidu.live.message.RenameRoom;
import com.baidu.live.message.YuyinRenameRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.yuyinala.liveroom.rename.e;
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {
    private w aEc;
    private TextView bGd;
    private TextView bGe;
    private EditText hog;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView nRP;
    private e nRR;
    private a nRS;
    int nRQ = 10;
    Runnable nPF = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.4
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.hog);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void call(String str);
    }

    public c(Context context, a aVar) {
        this.mContext = context;
        this.nRS = aVar;
        initDialog();
    }

    public void P(w wVar) {
        this.aEc = wVar;
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.hog.setText(wVar.aIS.room_name.trim());
                this.hog.setSelection(wVar.aIS.room_name.trim().length());
                this.hog.requestFocus();
                this.hog.post(this.nPF);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            cfe();
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bGe) {
            cfe();
            dismiss();
        }
        if (view == this.bGd && this.nRR != null && this.aEc != null && this.aEc.aIS != null) {
            this.nRR.e(this.aEc.aIS.aRy, 1, String.valueOf(this.aEc.aIS.live_id), this.hog.getText().toString());
            this.nRR.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.1
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    if (c.this.nRS != null) {
                        c.this.nRS.call(c.this.hog.getText().toString());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinRenameRoomMessage(new RenameRoom(c.this.hog.getText().toString())));
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
        this.nRR = new e(this.mContext);
        OE();
        initView();
    }

    private void OE() {
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.yuyin_room_rename_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.hog = (EditText) this.mRootView.findViewById(a.g.edit_rename);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.g.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.bGd = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.bGe = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.nRP = (TextView) this.mRootView.findViewById(a.g.tv_count);
        this.mRootView.setOnClickListener(this);
        this.bGd.setOnClickListener(this);
        this.bGe.setOnClickListener(this);
        this.hog.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.nRP != null) {
                    c.this.nRP.setText(c.this.mContext.getString(a.i.yuyin_ala_rename_room_title_limit, Integer.valueOf(b.u(charSequence))));
                    if (b.u(charSequence) == 0) {
                        c.this.bGd.setTextColor(c.this.mContext.getResources().getColor(a.d.sdk_color_B8B8B8));
                        c.this.bGd.setEnabled(false);
                        return;
                    }
                    c.this.bGd.setTextColor(c.this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                    c.this.bGd.setEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.hog.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.3
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(" ") || b.u(spanned) + b.u(charSequence) > c.this.nRQ) {
                    return "";
                }
                return charSequence;
            }
        }});
    }

    protected void cfe() {
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.mRootView);
    }
}
