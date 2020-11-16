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
    protected EditText htL;
    private LinearLayout htM;
    private CheckBox htO;
    private TextView htP;
    protected Button htQ;
    public boolean htS;
    protected String hwh;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    protected TextView oaF;
    protected TextView obW;
    protected c obX;
    protected d.b obY;
    private boolean htT = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.htL) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.htL);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.htL);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.obX = new c(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgS() {
        this.htL = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.oaF = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit);
        this.obW = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title_limit_max);
        this.htM = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.obX.aC(this.htM);
        this.htO = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.htP = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.htQ = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        FS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v(CharSequence charSequence) {
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

    protected boolean cgU() {
        return false;
    }

    protected boolean cgV() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cgX() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_title_toast);
            return false;
        } else if (TextUtils.isEmpty(this.hwh)) {
            this.mPageContext.showToast(a.h.yuyin_ala_createroom_upload_cover_toast);
            return false;
        } else {
            boolean cgV = cgV();
            boolean cgU = cgU();
            if (cgV || cgU) {
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                return cgY();
            }
            this.mPageContext.showToast(a.h.ala_create_to_retry);
            return false;
        }
    }

    private boolean cgY() {
        if (this.obY != null) {
            this.htS = true;
            this.obY.cez();
            return true;
        }
        return false;
    }

    private void FS() {
        if (this.htO != null) {
            this.htO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.htO.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.htO.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.htP != null) {
            this.htP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.obY.ceC();
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
        this.htL.setOnFocusChangeListener(this.focusChangeListener);
        this.htL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.oaF != null) {
                    a.this.oaF.setText(a.this.mPageContext.getResources().getString(a.h.yuyin_ala_createroom_title_limit, Integer.valueOf(a.this.v(charSequence))));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    int v = a.this.v(editable);
                    int selectionStart = a.this.htL.getSelectionStart();
                    int selectionEnd = a.this.htL.getSelectionEnd();
                    if (v > 10) {
                        editable.delete(selectionStart - 1, selectionEnd);
                        a.this.htL.setTextKeepState(editable);
                    }
                    if (v == 0) {
                        a.this.oaF.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                        a.this.obW.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha30));
                    } else if (v < 10) {
                        a.this.oaF.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                        a.this.obW.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    } else {
                        a.this.oaF.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_color_ffeaaa));
                        a.this.obW.setTextColor(a.this.mPageContext.getResources().getColor(a.c.sdk_white_alpha100));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.htL.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.4
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
    public void cha() {
        if (this.htT) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.htL.getText().toString();
    }

    public boolean caD() {
        return this.obX.isShowLocation();
    }

    public void a(d.b bVar) {
        this.obY = bVar;
    }

    public boolean caA() {
        return false;
    }

    public boolean caB() {
        return this.htO.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htT != z) {
            this.htT = z;
        }
    }
}
