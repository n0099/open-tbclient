package com.baidu.tieba.yuyinala.liveroom.introduce;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.e;
/* loaded from: classes10.dex */
public class c implements View.OnClickListener {
    private ab aED;
    private TextView bUM;
    private TextView bUN;
    private TextView cdT;
    private ImageView eKC;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private final e oyt;
    private EditText oyu;
    private EditText oyv;
    int oyw = 12;
    int oyx = 300;
    Runnable oyy = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.8
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.oyu);
        }
    };

    public c(Context context) {
        this.mContext = context;
        this.oyt = new e(this.mContext);
        initDialog();
    }

    public void b(ab abVar, String str, String str2) {
        try {
            this.aED = abVar;
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.oyu.setText(str);
                this.oyu.setSelection(str.length());
                this.oyv.setText(str2);
                this.oyu.requestFocus();
                this.oyu.post(this.oyy);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                BdUtilHelper.hideSoftKeyPad(this.mContext, this.eKC);
                this.mDialog.dismiss();
                this.mDialog = null;
            }
        } catch (Exception e) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bUN || view == this.eKC) {
            dismiss();
        }
        if (view == this.bUM && this.oyt != null && this.aED != null && this.aED.aKu != null) {
            this.oyt.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.1
                @Override // com.baidu.tieba.yuyinala.liveroom.introduce.e.a
                public void a(AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage) {
                    c.this.dismiss();
                    BdUtilHelper.showToast(c.this.mContext, "公告更新成功", 3000);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.introduce.e.a
                public void n(int i, String str, String str2) {
                    if (i == 210009) {
                        BdUtilHelper.showToast(c.this.mContext, str2, 3000);
                    } else {
                        BdUtilHelper.showToast(c.this.mContext, str, 3000);
                    }
                }
            });
            this.oyt.I(this.oyu.getText().toString().trim(), this.oyv.getText().toString().trim(), this.aED.aKu.aVk, this.aED.aKu.live_id);
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
        Hi();
        initView();
    }

    private void Hi() {
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.yuyin_room_introduce_modify_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.oyu = (EditText) this.mRootView.findViewById(a.f.et_title);
        this.oyv = (EditText) this.mRootView.findViewById(a.f.edit_content);
        this.bUM = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bUN = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.eKC = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.cdT = (TextView) this.mRootView.findViewById(a.f.tv_count);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bUM.setOnClickListener(this);
        this.bUN.setOnClickListener(this);
        this.eKC.setOnClickListener(this);
        this.oyu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cdT != null) {
                    try {
                        c.this.cdT.setText(c.this.mContext.getString(a.h.yuyin_ala_modify_room_introoduce_limit, Integer.valueOf(com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence))));
                        if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.x(c.this.oyv.getText().toString().trim()) > 0) {
                            c.this.bUM.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                            c.this.bUM.setEnabled(true);
                        } else {
                            c.this.bUM.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                            c.this.bUM.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.oyv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.x(c.this.oyu.getText().toString().trim()) > 0) {
                        c.this.bUM.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                        c.this.bUM.setEnabled(true);
                    } else {
                        c.this.bUM.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                        c.this.bUM.setEnabled(false);
                    }
                } catch (Exception e) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.oyu.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > c.this.oyw) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.oyv.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > c.this.oyx) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.oyv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.oyv.requestFocus();
                    c.this.oyv.post(c.this.oyy);
                } catch (Exception e) {
                }
            }
        });
        this.oyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.oyu.requestFocus();
                    c.this.oyu.post(c.this.oyy);
                } catch (Exception e) {
                }
            }
        });
    }
}
