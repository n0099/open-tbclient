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
    private w aFN;
    private TextView bPe;
    private TextView bPf;
    private TextView bWw;
    private ImageView eCd;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private final e onm;
    private EditText onn;
    private EditText ono;
    int onp = 12;
    int onq = 300;
    Runnable onr = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.8
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.onn);
        }
    };

    public c(Context context) {
        this.mContext = context;
        this.onm = new e(this.mContext);
        initDialog();
    }

    public void b(w wVar, String str, String str2) {
        try {
            this.aFN = wVar;
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.onn.setText(str);
                this.onn.setSelection(str.length());
                this.ono.setText(str2);
                this.onn.requestFocus();
                this.onn.post(this.onr);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                BdUtilHelper.hideSoftKeyPad(this.mContext, this.eCd);
                this.mDialog.dismiss();
                this.mDialog = null;
            }
        } catch (Exception e) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bPf || view == this.eCd) {
            dismiss();
        }
        if (view == this.bPe && this.onm != null && this.aFN != null && this.aFN.aKL != null) {
            this.onm.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.1
                @Override // com.baidu.tieba.yuyinala.liveroom.introduce.e.a
                public void a(AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage) {
                    c.this.dismiss();
                    BdUtilHelper.showToast(c.this.mContext, "公告更新成功", 3000);
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.introduce.e.a
                public void p(int i, String str, String str2) {
                    if (i == 210009) {
                        BdUtilHelper.showToast(c.this.mContext, str2, 3000);
                    } else {
                        BdUtilHelper.showToast(c.this.mContext, str, 3000);
                    }
                }
            });
            this.onm.L(this.onn.getText().toString().trim(), this.ono.getText().toString().trim(), this.aFN.aKL.aUg, this.aFN.aKL.live_id);
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.yuyin_room_introduce_modify_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.onn = (EditText) this.mRootView.findViewById(a.f.et_title);
        this.ono = (EditText) this.mRootView.findViewById(a.f.edit_content);
        this.bPe = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bPf = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.eCd = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.bWw = (TextView) this.mRootView.findViewById(a.f.tv_count);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bPe.setOnClickListener(this);
        this.bPf.setOnClickListener(this);
        this.eCd.setOnClickListener(this);
        this.onn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.bWw != null) {
                    try {
                        c.this.bWw.setText(c.this.mContext.getString(a.h.yuyin_ala_modify_room_introoduce_limit, Integer.valueOf(com.baidu.tieba.yuyinala.liveroom.rename.b.w(charSequence))));
                        if (com.baidu.tieba.yuyinala.liveroom.rename.b.w(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.w(c.this.ono.getText().toString().trim()) > 0) {
                            c.this.bPe.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                            c.this.bPe.setEnabled(true);
                        } else {
                            c.this.bPe.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                            c.this.bPe.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.ono.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    if (com.baidu.tieba.yuyinala.liveroom.rename.b.w(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.w(c.this.onn.getText().toString().trim()) > 0) {
                        c.this.bPe.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                        c.this.bPe.setEnabled(true);
                    } else {
                        c.this.bPe.setTextColor(c.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                        c.this.bPe.setEnabled(false);
                    }
                } catch (Exception e) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.onn.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.w(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.w(charSequence) > c.this.onp) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.ono.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.w(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.w(charSequence) > c.this.onq) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.ono.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.ono.requestFocus();
                    c.this.ono.post(c.this.onr);
                } catch (Exception e) {
                }
            }
        });
        this.onn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.onn.requestFocus();
                    c.this.onn.post(c.this.onr);
                } catch (Exception e) {
                }
            }
        });
    }
}
