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
/* loaded from: classes10.dex */
public abstract class a implements d {
    protected EditText hRb;
    private LinearLayout hRc;
    private CheckBox hRe;
    private TextView hRf;
    protected Button hRg;
    public boolean hRi;
    protected String hTy;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    protected TextView oAN;
    protected TextView oEL;
    protected c oEM;
    protected d.b oEN;
    private boolean hRj = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hRb) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hRb);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hRb);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.oEM = new c(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckY() {
        this.hRb = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.oAN = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit);
        this.oEL = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit_max);
        this.hRc = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.oEM.aO(this.hRc);
        this.hRe = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hRf = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.hRg = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        EG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x(CharSequence charSequence) {
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

    protected boolean cla() {
        return false;
    }

    protected boolean clb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cld() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_title_toast);
            return false;
        } else if (TextUtils.isEmpty(this.hTy)) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_upload_cover_toast);
            return false;
        } else {
            boolean clb = clb();
            boolean cla = cla();
            if (clb || cla) {
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                return cle();
            }
            this.mPageContext.showToast(a.h.ala_create_to_retry);
            return false;
        }
    }

    private boolean cle() {
        if (this.oEN != null) {
            this.hRi = true;
            this.oEN.cix();
            return true;
        }
        return false;
    }

    private void EG() {
        if (this.hRe != null) {
            this.hRe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.hRe.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hRe.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hRf != null) {
            this.hRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.oEN.ciA();
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
        this.hRb.setOnFocusChangeListener(this.focusChangeListener);
        this.hRb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.oAN != null) {
                    a.this.oAN.setText(a.this.mPageContext.getResources().getString(a.h.yuyin_ala_createroom_title_limit, Integer.valueOf(a.this.x(charSequence))));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    int x = a.this.x(editable);
                    int selectionStart = a.this.hRb.getSelectionStart();
                    int selectionEnd = a.this.hRb.getSelectionEnd();
                    if (x > 10) {
                        editable.delete(selectionStart - 1, selectionEnd);
                        a.this.hRb.setTextKeepState(editable);
                    }
                    if (x == 0) {
                        a.this.oAN.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                        a.this.oEL.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                    } else if (x < 10) {
                        a.this.oAN.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                        a.this.oEL.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    } else {
                        a.this.oAN.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_color_ffeaaa));
                        a.this.oEL.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.hRb.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.4
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
    public void clg() {
        if (this.hRj) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hRb.getText().toString();
    }

    public boolean ceG() {
        return this.oEM.isShowLocation();
    }

    public void a(d.b bVar) {
        this.oEN = bVar;
    }

    public boolean ceD() {
        return false;
    }

    public boolean ceE() {
        return this.hRe.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hRj != z) {
            this.hRj = z;
        }
    }
}
