package com.baidu.tieba.realauthen.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ao;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.realAuthen.AuthenCallback;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.utils.ResultCode;
import com.baidu.live.utils.e;
import com.baidu.live.utils.k;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.tieba.realauthen.a.a;
import com.baidu.tieba.realauthen.a.b;
import com.baidu.tieba.realauthen.b.c;
import com.baidu.tieba.realauthen.message.RealAuthenCertifyInfoResponseMessage;
import com.baidu.tieba.realauthen.message.RealAuthenSpResponseMessage;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FaceRecognitionActivity extends BaseActivity<FaceRecognitionActivity> implements View.OnClickListener {
    private ImageView Ez;
    private BaseActivity aBW;
    private String jDU;
    private String jDV;
    private EditText jDW;
    private EditText jDX;
    private TextView jDY;
    private TextView jDZ;
    private a jEa;
    private TextView jEb;
    private String jEc;
    private LinearLayout jEd;
    private TextView jEe;
    private ao jEf;
    private RelativeLayout jEg;
    private Context mContext;
    private String mUid;
    private String mUserName;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = true;
    private b jEh = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.jDV = realAuthenSpResponseMessage.jDV;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.jEl;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if ((obj instanceof RealAuthenCertifyInfoResponseMessage) && ((RealAuthenCertifyInfoResponseMessage) obj).errno == 0) {
                    FaceRecognitionActivity.this.showToast(FaceRecognitionActivity.this.mContext.getResources().getString(a.i.sdk_authen_suc), 17);
                    FaceRecognitionActivity.this.AH(ResultCode.naCertifyDone.code);
                }
            }
        }
    };
    private HttpMessageListener ato = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.cAF();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.aBW = this;
        setContentView(a.h.facedetection_activity);
        View findViewById = findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.mUid = getIntent().getStringExtra("uid");
        if (TextUtils.isEmpty(this.mUid)) {
            this.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        this.jDU = getIntent().getStringExtra("retry");
        setupViews();
        this.jEa = new com.baidu.tieba.realauthen.a.a(this.jEh);
        this.jEa.cAG();
        MessageManager.getInstance().registerListener(this.ato);
    }

    private void setupViews() {
        this.jEg = (RelativeLayout) findViewById(a.g.rl_content);
        this.jEg.setOnClickListener(this);
        this.Ez = (ImageView) findViewById(a.g.img_back);
        this.Ez.setOnClickListener(this);
        this.jEf = com.baidu.live.s.a.wR().atk;
        this.selectorImg = (ImageView) findViewById(a.g.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.jEb = (TextView) findViewById(a.g.agreement);
        this.jEb.setMovementMethod(LinkMovementMethod.getInstance());
        cAF();
        this.jDW = (EditText) findViewById(a.g.name);
        com.baidu.tieba.realauthen.b.a.g(this.jDW);
        this.jDW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.jDZ.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cAD();
            }
        });
        this.jDW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.jDW.getText().toString();
                FaceRecognitionActivity.this.cAD();
                if (!z && !TextUtils.isEmpty(obj) && !k.dS(obj)) {
                    FaceRecognitionActivity.this.aY(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.jDW);
        this.jDX = (EditText) findViewById(a.g.idno);
        this.jDX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.jDZ.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cAD();
            }
        });
        this.jDX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.jDX.getText().toString();
                FaceRecognitionActivity.this.cAD();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String dO = e.dO(obj);
                    if (!HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(dO)) {
                        FaceRecognitionActivity.this.aY(0, dO);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.jDX);
        this.jDY = (TextView) findViewById(a.g.toAuth_textView);
        this.jDY.setOnClickListener(this);
        this.jEd = (LinearLayout) findViewById(a.g.ll_authen_retry);
        this.jEe = (TextView) findViewById(a.g.authen_retry);
        this.jEe.setOnClickListener(this);
        this.jDZ = (TextView) findViewById(a.g.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jEg) {
            this.jDW.clearFocus();
            this.jDX.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.jEg.getWindowToken(), 2);
            }
        } else if (view == this.Ez) {
            AH(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            cAD();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.f.icon_live_choose_s : a.f.icon_live_operatechoose_n);
        } else if (view == this.jDY) {
            this.jDZ.setVisibility(4);
            if (TextUtils.isEmpty(this.jDW.getText().toString()) || TextUtils.isEmpty(this.jDX.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            rV(false);
            cAE();
        } else if (view == this.jEe && this.jEf.aba != null) {
            CommonWebViewActivityConfig commonWebViewActivityConfig = new CommonWebViewActivityConfig(this.aBW.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.jEf.aba.abD);
            if (!TextUtils.isEmpty(this.jDU)) {
                commonWebViewActivityConfig.setCertRetryTag(this.jDU);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, commonWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAD() {
        if (!TextUtils.isEmpty(this.jDW.getText().toString()) && k.dS(this.jDW.getText().toString()) && !TextUtils.isEmpty(this.jDX.getText().toString()) && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(e.dO(this.jDX.getText().toString())) && this.mChosen) {
            rV(true);
        } else {
            rV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, String str) {
        if (i == 0) {
            this.jDZ.setVisibility(0);
            this.jDZ.setText(str);
            this.jEd.setVisibility(0);
            return;
        }
        this.jDZ.setVisibility(4);
        this.jEd.setVisibility(4);
    }

    private void rV(boolean z) {
        if (this.jDY != null) {
            if (z) {
                this.jDY.setClickable(true);
                this.jDY.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.jDY.setBackgroundResource(a.f.bg_toauth_shape_corner);
                return;
            }
            this.jDY.setClickable(false);
            this.jDY.setTextColor(getResources().getColor(a.d.sdk_common_color_10259));
            this.jDY.setBackgroundResource(a.f.bg_toauth_shape_corner_n);
        }
    }

    private void cAE() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.jDW.getText().toString();
        hashMap.put("realName", this.jDW.getText().toString());
        this.jEc = this.jDX.getText().toString();
        hashMap.put("idCardNo", this.jDX.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.as(this.jDV, this.reqId, this.sign));
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.cAD();
                            String str = "";
                            if (map.containsKey("retMsg")) {
                                str = (String) map.get("retMsg");
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.jEa != null) {
                                            FaceRecognitionActivity.this.jEa.y(FaceRecognitionActivity.this.mUid, str2, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.jEc);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    FaceRecognitionActivity.this.aY(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (i == -204) {
                                if (map != null && !TextUtils.isEmpty(str)) {
                                    FaceRecognitionActivity.this.aY(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.aY(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(int i) {
        getActivity().setResult(i, new Intent());
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str, int i) {
        Toast makeText = Toast.makeText(this.mContext, (CharSequence) null, 0);
        makeText.setGravity(i, 0, 0);
        makeText.setText(str);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAF() {
        if (this.jEb != null) {
            String str = "";
            if (this.jEf.aaZ != null) {
                str = this.jEf.aaZ.acJ;
            }
            if (TextUtils.isEmpty(str)) {
                str = "我已阅读并同意《主播协议》";
            }
            if (!TextUtils.isEmpty(str)) {
                SpannableString spannableString = new SpannableString(str);
                if (str.contains("《") && str.contains("》")) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.8
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            if (FaceRecognitionActivity.this.jEf.aaZ != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.jEf.aaZ.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.jEb.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && i2 == ResultCode.h5UploadDone.code) {
            AH(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ato);
    }
}
