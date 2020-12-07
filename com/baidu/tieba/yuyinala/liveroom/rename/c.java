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
    private w aFN;
    private TextView bPe;
    private TextView bPf;
    private EditText hDo;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView opG;
    private e opI;
    private a opJ;
    int opH = 10;
    Runnable onr = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.4
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.hDo);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void call(String str);
    }

    public c(Context context, a aVar) {
        this.mContext = context;
        this.opJ = aVar;
        initDialog();
    }

    public void ac(w wVar) {
        this.aFN = wVar;
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.hDo.setText(wVar.aKL.room_name.trim());
                this.hDo.setSelection(wVar.aKL.room_name.trim().length());
                this.hDo.requestFocus();
                this.hDo.post(this.onr);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            ckU();
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bPf) {
            ckU();
            dismiss();
        }
        if (view == this.bPe && this.opI != null && this.aFN != null && this.aFN.aKL != null) {
            this.opI.e(this.aFN.aKL.aUg, 1, String.valueOf(this.aFN.aKL.live_id), this.hDo.getText().toString());
            this.opI.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.1
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    if (c.this.opJ != null) {
                        c.this.opJ.call(c.this.hDo.getText().toString());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinRenameRoomMessage(new RenameRoom(c.this.hDo.getText().toString())));
                    c.this.dismiss();
                    BdUtilHelper.showToast(c.this.mContext, "房间名称修改成功", 3000);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void p(int i, String str, String str2) {
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
        this.opI = new e(this.mContext);
        Ki();
        initView();
    }

    private void Ki() {
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
        this.hDo = (EditText) this.mRootView.findViewById(a.f.edit_rename);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.bPe = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bPf = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.opG = (TextView) this.mRootView.findViewById(a.f.tv_count);
        this.mRootView.setOnClickListener(this);
        this.bPe.setOnClickListener(this);
        this.bPf.setOnClickListener(this);
        this.hDo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.opG != null) {
                    c.this.opG.setText(c.this.mContext.getString(a.h.yuyin_ala_rename_room_title_limit, Integer.valueOf(b.w(charSequence))));
                    if (b.w(charSequence) == 0) {
                        c.this.bPe.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                        c.this.bPe.setEnabled(false);
                        return;
                    }
                    c.this.bPe.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                    c.this.bPe.setEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.hDo.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.rename.c.3
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(" ") || b.w(spanned) + b.w(charSequence) > c.this.opH) {
                    return "";
                }
                return charSequence;
            }
        }});
    }

    protected void ckU() {
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.mRootView);
    }
}
