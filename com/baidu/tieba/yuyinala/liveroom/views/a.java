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
    protected EditText hDo;
    private LinearLayout hDp;
    private CheckBox hDr;
    private TextView hDs;
    protected Button hDt;
    public boolean hDv;
    protected String hFL;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    protected TextView opG;
    protected TextView oqW;
    protected c oqX;
    protected d.b oqY;
    private boolean hDw = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hDo) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hDo);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hDo);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.oqX = new c(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckM() {
        this.hDo = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.opG = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit);
        this.oqW = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit_max);
        this.hDp = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.oqX.aC(this.hDp);
        this.hDr = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hDs = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.hDt = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        HH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w(CharSequence charSequence) {
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

    protected boolean ckO() {
        return false;
    }

    protected boolean ckP() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ckR() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_title_toast);
            return false;
        } else if (TextUtils.isEmpty(this.hFL)) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_upload_cover_toast);
            return false;
        } else {
            boolean ckP = ckP();
            boolean ckO = ckO();
            if (ckP || ckO) {
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                return ckS();
            }
            this.mPageContext.showToast(a.h.ala_create_to_retry);
            return false;
        }
    }

    private boolean ckS() {
        if (this.oqY != null) {
            this.hDv = true;
            this.oqY.ciu();
            return true;
        }
        return false;
    }

    private void HH() {
        if (this.hDr != null) {
            this.hDr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.hDr.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hDr.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hDs != null) {
            this.hDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.oqY.cix();
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
        this.hDo.setOnFocusChangeListener(this.focusChangeListener);
        this.hDo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.opG != null) {
                    a.this.opG.setText(a.this.mPageContext.getResources().getString(a.h.yuyin_ala_createroom_title_limit, Integer.valueOf(a.this.w(charSequence))));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    int w = a.this.w(editable);
                    int selectionStart = a.this.hDo.getSelectionStart();
                    int selectionEnd = a.this.hDo.getSelectionEnd();
                    if (w > 10) {
                        editable.delete(selectionStart - 1, selectionEnd);
                        a.this.hDo.setTextKeepState(editable);
                    }
                    if (w == 0) {
                        a.this.opG.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                        a.this.oqW.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                    } else if (w < 10) {
                        a.this.opG.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                        a.this.oqW.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    } else {
                        a.this.opG.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_color_ffeaaa));
                        a.this.oqW.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.hDo.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.4
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
    public void ckU() {
        if (this.hDw) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hDo.getText().toString();
    }

    public boolean cey() {
        return this.oqX.isShowLocation();
    }

    public void a(d.b bVar) {
        this.oqY = bVar;
    }

    public boolean cev() {
        return false;
    }

    public boolean cew() {
        return this.hDr.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hDw != z) {
            this.hDw = z;
        }
    }
}
