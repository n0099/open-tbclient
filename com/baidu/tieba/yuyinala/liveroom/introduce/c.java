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
/* loaded from: classes11.dex */
public class c implements View.OnClickListener {
    private ab aDd;
    private TextView bTm;
    private TextView bTn;
    private TextView ccq;
    private ImageView eJb;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private final e owo;
    private EditText owp;
    private EditText owq;
    int owr = 12;
    int ows = 300;
    Runnable owt = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.8
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.owp);
        }
    };

    public c(Context context) {
        this.mContext = context;
        this.owo = new e(this.mContext);
        initDialog();
    }

    public void b(ab abVar, String str, String str2) {
        try {
            this.aDd = abVar;
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.owp.setText(str);
                this.owp.setSelection(str.length());
                this.owq.setText(str2);
                this.owp.requestFocus();
                this.owp.post(this.owt);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                BdUtilHelper.hideSoftKeyPad(this.mContext, this.eJb);
                this.mDialog.dismiss();
                this.mDialog = null;
            }
        } catch (Exception e) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bTn || view == this.eJb) {
            dismiss();
        }
        if (view == this.bTm && this.owo != null && this.aDd != null && this.aDd.aIU != null) {
            this.owo.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.1
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
            this.owo.I(this.owp.getText().toString().trim(), this.owq.getText().toString().trim(), this.aDd.aIU.aTK, this.aDd.aIU.live_id);
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.yuyin_room_introduce_modify_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.owp = (EditText) this.mRootView.findViewById(a.f.et_title);
        this.owq = (EditText) this.mRootView.findViewById(a.f.edit_content);
        this.bTm = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bTn = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.eJb = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.ccq = (TextView) this.mRootView.findViewById(a.f.tv_count);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bTm.setOnClickListener(this);
        this.bTn.setOnClickListener(this);
        this.eJb.setOnClickListener(this);
        this.owp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.ccq != null) {
                    try {
                        c.this.ccq.setText(c.this.mContext.getString(a.h.yuyin_ala_modify_room_introoduce_limit, Integer.valueOf(com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence))));
                        if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.x(c.this.owq.getText().toString().trim()) > 0) {
                            c.this.bTm.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                            c.this.bTm.setEnabled(true);
                        } else {
                            c.this.bTm.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                            c.this.bTm.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.owq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.x(c.this.owp.getText().toString().trim()) > 0) {
                        c.this.bTm.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                        c.this.bTm.setEnabled(true);
                    } else {
                        c.this.bTm.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                        c.this.bTm.setEnabled(false);
                    }
                } catch (Exception e) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.owp.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > c.this.owr) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.owq.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.x(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.x(charSequence) > c.this.ows) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.owq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.owq.requestFocus();
                    c.this.owq.post(c.this.owt);
                } catch (Exception e) {
                }
            }
        });
        this.owp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.owp.requestFocus();
                    c.this.owp.post(c.this.owt);
                } catch (Exception e) {
                }
            }
        });
    }
}
