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
    protected EditText hog;
    private LinearLayout hoh;
    private CheckBox hoj;
    private TextView hok;
    protected Button hol;
    public boolean hon;
    protected String hqD;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    protected TextView nRP;
    protected TextView nTf;
    protected c nTg;
    protected d.b nTh;
    private boolean hoo = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hog) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hog);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hog);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.nTg = new c(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceW() {
        this.hog = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.nRP = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title_limit);
        this.nTf = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title_limit_max);
        this.hoh = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.nTg.aE(this.hoh);
        this.hoj = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.hok = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.hol = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        Ga();
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

    protected boolean ceY() {
        return false;
    }

    protected boolean ceZ() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cfb() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.mPageContext.showToast(a.i.yuyin_ala_createroom_title_toast);
            return false;
        } else if (TextUtils.isEmpty(this.hqD)) {
            this.mPageContext.showToast(a.i.yuyin_ala_createroom_upload_cover_toast);
            return false;
        } else {
            boolean ceZ = ceZ();
            boolean ceY = ceY();
            if (ceZ || ceY) {
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                return cfc();
            }
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        }
    }

    private boolean cfc() {
        if (this.nTh != null) {
            this.hon = true;
            this.nTh.ccF();
            return true;
        }
        return false;
    }

    private void Ga() {
        if (this.hoj != null) {
            this.hoj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.hoj.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hoj.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hok != null) {
            this.hok.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nTh.ccI();
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
        this.hog.setOnFocusChangeListener(this.focusChangeListener);
        this.hog.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.nRP != null) {
                    a.this.nRP.setText(a.this.mPageContext.getResources().getString(a.i.yuyin_ala_createroom_title_limit, Integer.valueOf(a.this.u(charSequence))));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    int u = a.this.u(editable);
                    int selectionStart = a.this.hog.getSelectionStart();
                    int selectionEnd = a.this.hog.getSelectionEnd();
                    if (u > 10) {
                        editable.delete(selectionStart - 1, selectionEnd);
                        a.this.hog.setTextKeepState(editable);
                    }
                    if (u == 0) {
                        a.this.nRP.setTextColor(a.this.mPageContext.getResources().getColor(a.d.sdk_white_alpha30));
                        a.this.nTf.setTextColor(a.this.mPageContext.getResources().getColor(a.d.sdk_white_alpha30));
                    } else if (u < 10) {
                        a.this.nRP.setTextColor(a.this.mPageContext.getResources().getColor(a.d.sdk_white_alpha100));
                        a.this.nTf.setTextColor(a.this.mPageContext.getResources().getColor(a.d.sdk_white_alpha100));
                    } else {
                        a.this.nRP.setTextColor(a.this.mPageContext.getResources().getColor(a.d.sdk_color_ffeaaa));
                        a.this.nTf.setTextColor(a.this.mPageContext.getResources().getColor(a.d.sdk_white_alpha100));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.hog.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.yuyinala.liveroom.views.a.4
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
    public void cfe() {
        if (this.hoo) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hog.getText().toString();
    }

    public boolean bYI() {
        return this.nTg.isShowLocation();
    }

    public void a(d.b bVar) {
        this.nTh = bVar;
    }

    public boolean bYF() {
        return false;
    }

    public boolean bYG() {
        return this.hoj.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hoo != z) {
            this.hoo = z;
        }
    }
}
