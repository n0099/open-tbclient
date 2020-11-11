package com.baidu.tieba.yuyinala.liveroom.views;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.views.d;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a implements d {
    protected EditText hue;
    private LinearLayout huf;
    private CheckBox huh;
    private TextView hui;
    protected Button huj;
    public boolean hul;
    protected String hwA;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    protected TextView nZc;
    protected TextView oas;
    protected c oat;
    protected d.b oau;
    private boolean hum = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hue) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hue);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hue);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.oat = new c(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void chz() {
        this.hue = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.nZc = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit);
        this.oas = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit_max);
        this.huf = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.oat.aG(this.huf);
        this.huh = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hui = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.huj = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        GB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(CharSequence charSequence) {
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

    protected boolean chB() {
        return false;
    }

    protected boolean chC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean chE() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_title_toast);
            return false;
        } else if (TextUtils.isEmpty(this.hwA)) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_upload_cover_toast);
            return false;
        } else {
            boolean chC = chC();
            boolean chB = chB();
            if (chC || chB) {
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                return chF();
            }
            this.mPageContext.showToast(a.h.ala_create_to_retry);
            return false;
        }
    }

    private boolean chF() {
        if (this.oau != null) {
            this.hul = true;
            this.oau.cfg();
            return true;
        }
        return false;
    }

    private void GB() {
        if (this.huh != null) {
            this.huh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.huh.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.huh.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hui != null) {
            this.hui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.oau.cfj();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_CREATE_ROOM, "livetext_clk").setContentExt(jSONObject));
                }
            });
        }
        this.hue.setOnFocusChangeListener(this.focusChangeListener);
        this.hue.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.nZc != null) {
                    a.this.nZc.setText(a.this.mPageContext.getResources().getString(a.h.yuyin_ala_createroom_title_limit, Integer.valueOf(a.this.u(charSequence))));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    int u = a.this.u(editable);
                    int selectionStart = a.this.hue.getSelectionStart();
                    int selectionEnd = a.this.hue.getSelectionEnd();
                    if (u > 10) {
                        editable.delete(selectionStart - 1, selectionEnd);
                        a.this.hue.setTextKeepState(editable);
                    }
                    if (u == 0) {
                        a.this.nZc.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                        a.this.oas.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                    } else if (u < 10) {
                        a.this.nZc.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                        a.this.oas.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    } else {
                        a.this.nZc.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_color_ffeaaa));
                        a.this.oas.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.hue.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.toString().contentEquals("\n")) {
                    return "";
                }
                return charSequence;
            }
        }});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void chH() {
        if (this.hum) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hue.getText().toString();
    }

    public boolean cbk() {
        return this.oat.isShowLocation();
    }

    public void a(d.b bVar) {
        this.oau = bVar;
    }

    public boolean cbh() {
        return false;
    }

    public boolean cbi() {
        return this.huh.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hum != z) {
            this.hum = z;
        }
    }
}
