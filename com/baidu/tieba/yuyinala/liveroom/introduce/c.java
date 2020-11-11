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
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.e;
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {
    private w aES;
    private TextView bLI;
    private TextView bLJ;
    private TextView bSQ;
    private ImageView ewK;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private final e nWJ;
    private EditText nWK;
    private EditText nWL;
    int nWM = 12;
    int nWN = 300;
    Runnable nWO = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.8
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.nWK);
        }
    };

    public c(Context context) {
        this.mContext = context;
        this.nWJ = new e(this.mContext);
        initDialog();
    }

    public void b(w wVar, String str, String str2) {
        try {
            this.aES = wVar;
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.nWK.setText(str);
                this.nWK.setSelection(str.length());
                this.nWL.setText(str2);
                this.nWK.requestFocus();
                this.nWK.post(this.nWO);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                BdUtilHelper.hideSoftKeyPad(this.mContext, this.ewK);
                this.mDialog.dismiss();
                this.mDialog = null;
            }
        } catch (Exception e) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bLJ || view == this.ewK) {
            dismiss();
        }
        if (view == this.bLI && this.nWJ != null && this.aES != null && this.aES.aJK != null) {
            this.nWJ.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.1
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
            this.nWJ.L(this.nWK.getText().toString().trim(), this.nWL.getText().toString().trim(), this.aES.aJK.aSP, this.aES.aJK.live_id);
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
        Pe();
        initView();
    }

    private void Pe() {
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
        this.nWK = (EditText) this.mRootView.findViewById(a.f.et_title);
        this.nWL = (EditText) this.mRootView.findViewById(a.f.edit_content);
        this.bLI = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bLJ = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.ewK = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.bSQ = (TextView) this.mRootView.findViewById(a.f.tv_count);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bLI.setOnClickListener(this);
        this.bLJ.setOnClickListener(this);
        this.ewK.setOnClickListener(this);
        this.nWK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.bSQ != null) {
                    try {
                        c.this.bSQ.setText(c.this.mContext.getString(a.h.yuyin_ala_modify_room_introoduce_limit, Integer.valueOf(com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence))));
                        if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.u(c.this.nWL.getText().toString().trim()) > 0) {
                            c.this.bLI.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                            c.this.bLI.setEnabled(true);
                        } else {
                            c.this.bLI.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                            c.this.bLI.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nWL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.u(c.this.nWK.getText().toString().trim()) > 0) {
                        c.this.bLI.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                        c.this.bLI.setEnabled(true);
                    } else {
                        c.this.bLI.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                        c.this.bLI.setEnabled(false);
                    }
                } catch (Exception e) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nWK.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > c.this.nWM) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.nWL.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > c.this.nWN) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.nWL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.nWL.requestFocus();
                    c.this.nWL.post(c.this.nWO);
                } catch (Exception e) {
                }
            }
        });
        this.nWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.nWK.requestFocus();
                    c.this.nWK.post(c.this.nWO);
                } catch (Exception e) {
                }
            }
        });
    }
}
