package com.baidu.yuyinala.more;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private TextView bUM;
    private TextView bUN;
    private TextView cdT;
    private ImageView eKC;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private com.baidu.yuyinala.more.c.a oZr;
    private EditText oyu;
    int oyw = 20;
    Runnable oyy = new Runnable() { // from class: com.baidu.yuyinala.more.d.4
        @Override // java.lang.Runnable
        public void run() {
            BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.oyu);
        }
    };
    public CustomMessageListener bhY = new CustomMessageListener(2913097) { // from class: com.baidu.yuyinala.more.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                d.this.dismiss();
            }
        }
    };

    public d(Context context, com.baidu.yuyinala.more.c.a aVar) {
        this.mContext = context;
        this.oZr = aVar;
        initDialog();
    }

    public void show() {
        MessageManager.getInstance().registerListener(this.bhY);
        this.mDialog.show();
    }

    public void dismiss() {
        try {
            if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
                BdUtilHelper.hideSoftKeyPad(this.mContext, this.eKC);
                this.mDialog.dismiss();
                this.mDialog = null;
                MessageManager.getInstance().unRegisterListener(this.bhY);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bUN || view == this.eKC) {
            dismiss();
        }
        if (view == this.bUM && this.oZr != null) {
            this.oZr.ejR();
            this.oZr.Yr(this.oyu.getText().toString().trim());
            dismiss();
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.yuyin_room_close_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.oyu = (EditText) this.mRootView.findViewById(a.f.et_title);
        this.bUM = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bUN = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.eKC = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.cdT = (TextView) this.mRootView.findViewById(a.f.tv_count);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bUM.setOnClickListener(this);
        this.bUN.setOnClickListener(this);
        this.eKC.setOnClickListener(this);
        this.oyu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.yuyinala.more.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (d.this.cdT != null) {
                    try {
                        d.this.cdT.setText(d.this.mContext.getString(a.h.yuyin_ala_close_room_introoduce_limit, Integer.valueOf(d.x(charSequence))));
                        if (d.x(charSequence) > 0) {
                            d.this.bUM.setTextColor(d.this.mContext.getResources().getColor(a.c.sdk_color_ff1e66));
                            d.this.bUM.setEnabled(true);
                        } else {
                            d.this.bUM.setTextColor(d.this.mContext.getResources().getColor(a.c.sdk_color_B8B8B8));
                            d.this.bUM.setEnabled(false);
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.oyu.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.yuyinala.more.d.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (d.x(spanned) + d.x(charSequence) > d.this.oyw) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.oyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.more.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    d.this.oyu.requestFocus();
                    d.this.oyu.post(d.this.oyy);
                } catch (Exception e) {
                }
            }
        });
        this.oyu.setText("");
    }

    public static int x(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        Pattern compile = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);
        int i = 0;
        while (compile.matcher(charSequence).find()) {
            i++;
        }
        for (String str : compile.split(charSequence)) {
            i += str.length();
        }
        return i;
    }
}
