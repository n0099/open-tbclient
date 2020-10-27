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
    private w aEc;
    private TextView bGd;
    private TextView bGe;
    private TextView bNh;
    private ImageView eqR;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private final e nPA;
    private EditText nPB;
    private EditText nPC;
    int nPD = 12;
    int nPE = 300;
    Runnable nPF = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.8
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.nPB);
        }
    };

    public c(Context context) {
        this.mContext = context;
        this.nPA = new e(this.mContext);
        initDialog();
    }

    public void b(w wVar, String str, String str2) {
        try {
            this.aEc = wVar;
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                this.mDialog.show();
                this.nPB.setText(str);
                this.nPB.setSelection(str.length());
                this.nPC.setText(str2);
                this.nPB.requestFocus();
                this.nPB.post(this.nPF);
            }
        } catch (Exception e) {
        }
    }

    public void dismiss() {
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                BdUtilHelper.hideSoftKeyPad(this.mContext, this.eqR);
                this.mDialog.dismiss();
                this.mDialog = null;
            }
        } catch (Exception e) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bGe || view == this.eqR) {
            dismiss();
        }
        if (view == this.bGd && this.nPA != null && this.aEc != null && this.aEc.aIS != null) {
            this.nPA.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.1
                @Override // com.baidu.tieba.yuyinala.liveroom.introduce.e.a
                public void a(AlaModifyRoomIntroduceHttpResponseMessage alaModifyRoomIntroduceHttpResponseMessage) {
                    c.this.dismiss();
                    BdUtilHelper.showToast(c.this.mContext, "玩法介绍更新成功", 3000);
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
            this.nPA.L(this.nPB.getText().toString().trim(), this.nPC.getText().toString().trim(), this.aEc.aIS.aRy, this.aEc.aIS.live_id);
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.yuyin_room_introduce_modify_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.nPB = (EditText) this.mRootView.findViewById(a.g.et_title);
        this.nPC = (EditText) this.mRootView.findViewById(a.g.edit_content);
        this.bGd = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.bGe = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.eqR = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.bNh = (TextView) this.mRootView.findViewById(a.g.tv_count);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.g.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bGd.setOnClickListener(this);
        this.bGe.setOnClickListener(this);
        this.eqR.setOnClickListener(this);
        this.nPB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.bNh != null) {
                    try {
                        c.this.bNh.setText(c.this.mContext.getString(a.i.yuyin_ala_modify_room_introoduce_limit, Integer.valueOf(com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence))));
                        if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.u(c.this.nPC.getText().toString().trim()) > 0) {
                            c.this.bGd.setTextColor(c.this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                            c.this.bGd.setEnabled(true);
                        } else {
                            c.this.bGd.setTextColor(c.this.mContext.getResources().getColor(a.d.sdk_color_B8B8B8));
                            c.this.bGd.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nPC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > 0 && com.baidu.tieba.yuyinala.liveroom.rename.b.u(c.this.nPB.getText().toString().trim()) > 0) {
                        c.this.bGd.setTextColor(c.this.mContext.getResources().getColor(a.d.sdk_color_ff1e66));
                        c.this.bGd.setEnabled(true);
                    } else {
                        c.this.bGd.setTextColor(c.this.mContext.getResources().getColor(a.d.sdk_color_B8B8B8));
                        c.this.bGd.setEnabled(false);
                    }
                } catch (Exception e) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.nPB.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > c.this.nPD) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.nPC.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (com.baidu.tieba.yuyinala.liveroom.rename.b.u(spanned) + com.baidu.tieba.yuyinala.liveroom.rename.b.u(charSequence) > c.this.nPE) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.nPC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.nPC.requestFocus();
                    c.this.nPC.post(c.this.nPF);
                } catch (Exception e) {
                }
            }
        });
        this.nPB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.nPB.requestFocus();
                    c.this.nPB.post(c.this.nPF);
                } catch (Exception e) {
                }
            }
        });
    }
}
