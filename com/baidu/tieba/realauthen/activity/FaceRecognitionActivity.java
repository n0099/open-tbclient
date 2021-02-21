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
import com.baidu.live.data.bv;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.realAuthen.AuthenCallback;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.utils.ResultCode;
import com.baidu.live.utils.f;
import com.baidu.live.utils.m;
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
/* loaded from: classes11.dex */
public class FaceRecognitionActivity extends BaseActivity<FaceRecognitionActivity> implements View.OnClickListener {
    private BaseActivity bVA;
    private ImageView mBack;
    private Context mContext;
    private String mQJ;
    private String mQK;
    private EditText mQL;
    private EditText mQM;
    private TextView mQN;
    private TextView mQO;
    private a mQP;
    private TextView mQQ;
    private String mQR;
    private LinearLayout mQS;
    private TextView mQT;
    private bv mQU;
    private RelativeLayout mQV;
    private String mUid;
    private String mUserName;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = false;
    private b mQW = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.mQK = realAuthenSpResponseMessage.mQK;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.mQZ;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if ((obj instanceof RealAuthenCertifyInfoResponseMessage) && ((RealAuthenCertifyInfoResponseMessage) obj).errno == 0) {
                    FaceRecognitionActivity.this.showToast(FaceRecognitionActivity.this.mContext.getResources().getString(a.h.sdk_authen_suc), 17);
                    FaceRecognitionActivity.this.HK(ResultCode.naCertifyDone.code);
                }
            }
        }
    };
    private HttpMessageListener bAV = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.dDc();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.mContext = this;
            this.bVA = this;
            setContentView(a.g.facedetection_activity);
            View findViewById = findViewById(a.f.view_status_bar);
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
            this.mQJ = getIntent().getStringExtra("retry");
            setupViews();
            this.mQP = new com.baidu.tieba.realauthen.a.a(this.mQW);
            this.mQP.dDd();
            MessageManager.getInstance().registerListener(this.bAV);
        }
    }

    private void setupViews() {
        this.mQV = (RelativeLayout) findViewById(a.f.rl_content);
        this.mQV.setOnClickListener(this);
        this.mBack = (ImageView) findViewById(a.f.img_back);
        this.mBack.setOnClickListener(this);
        this.mQU = com.baidu.live.ae.a.Qj().bAS;
        this.selectorImg = (ImageView) findViewById(a.f.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.mQQ = (TextView) findViewById(a.f.agreement);
        this.mQQ.setMovementMethod(LinkMovementMethod.getInstance());
        dDc();
        this.mQL = (EditText) findViewById(a.f.name);
        com.baidu.tieba.realauthen.b.a.h(this.mQL);
        this.mQL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.mQO.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.dDa();
            }
        });
        this.mQL.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.mQL.getText().toString();
                FaceRecognitionActivity.this.dDa();
                if (!z && !TextUtils.isEmpty(obj) && !m.id(obj)) {
                    FaceRecognitionActivity.this.bU(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.i(this.mQL);
        this.mQM = (EditText) findViewById(a.f.idno);
        this.mQM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.mQO.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.dDa();
            }
        });
        this.mQM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.mQM.getText().toString();
                FaceRecognitionActivity.this.dDa();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String hX = f.hX(obj);
                    if (!HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(hX)) {
                        FaceRecognitionActivity.this.bU(0, hX);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.i(this.mQM);
        this.mQN = (TextView) findViewById(a.f.toAuth_textView);
        this.mQN.setOnClickListener(this);
        this.mQS = (LinearLayout) findViewById(a.f.ll_authen_retry);
        this.mQT = (TextView) findViewById(a.f.authen_retry);
        this.mQT.setOnClickListener(this);
        this.mQO = (TextView) findViewById(a.f.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mQV) {
            this.mQL.clearFocus();
            this.mQM.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mQV.getWindowToken(), 2);
            }
        } else if (view == this.mBack) {
            HK(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            dDa();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.e.icon_live_choose_s : a.e.icon_live_operatechoose_n);
        } else if (view == this.mQN) {
            if (!this.mChosen) {
                CustomToast.newInstance().showToast(a.h.authen_need_agreement);
                return;
            }
            this.mQO.setVisibility(4);
            if (TextUtils.isEmpty(this.mQL.getText().toString()) || TextUtils.isEmpty(this.mQM.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            xA(false);
            dDb();
        } else if (view == this.mQT && this.mQU.aPS != null) {
            CommonWebViewActivityConfig commonWebViewActivityConfig = new CommonWebViewActivityConfig(this.bVA.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.mQU.aPS.aRo);
            if (!TextUtils.isEmpty(this.mQJ)) {
                commonWebViewActivityConfig.setCertRetryTag(this.mQJ);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, commonWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDa() {
        if (!TextUtils.isEmpty(this.mQL.getText().toString()) && m.id(this.mQL.getText().toString()) && !TextUtils.isEmpty(this.mQM.getText().toString()) && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(f.hX(this.mQM.getText().toString()))) {
            xA(true);
        } else {
            xA(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(int i, String str) {
        if (i == 0) {
            this.mQO.setVisibility(0);
            this.mQO.setText(str);
            this.mQS.setVisibility(0);
            return;
        }
        this.mQO.setVisibility(4);
        this.mQS.setVisibility(4);
    }

    private void xA(boolean z) {
        if (this.mQN != null) {
            if (z) {
                this.mQN.setClickable(true);
                this.mQN.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.mQN.setBackgroundResource(a.e.bg_toauth_shape_corner);
                return;
            }
            this.mQN.setClickable(false);
            this.mQN.setTextColor(getResources().getColor(a.c.sdk_common_color_10259));
            this.mQN.setBackgroundResource(a.e.bg_toauth_shape_corner_n);
        }
    }

    private void dDb() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.mQL.getText().toString();
        hashMap.put("realName", this.mQL.getText().toString());
        this.mQR = this.mQM.getText().toString();
        hashMap.put("idCardNo", this.mQM.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.aN(this.mQK, this.reqId, this.sign));
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.dDa();
                            String str = "";
                            if (map.containsKey("retMsg")) {
                                str = (String) map.get("retMsg");
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.mQP != null) {
                                            FaceRecognitionActivity.this.mQP.E(FaceRecognitionActivity.this.mUid, str2, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.mQR);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    FaceRecognitionActivity.this.bU(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.h.authen_fail), str));
                                }
                            } else if (i == -204) {
                                if (map != null && !TextUtils.isEmpty(str)) {
                                    FaceRecognitionActivity.this.bU(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.h.authen_fail), str));
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.bU(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.h.authen_fail), str));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK(int i) {
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
    public void dDc() {
        if (this.mQQ != null) {
            String str = "";
            if (this.mQU.aPR != null) {
                str = this.mQU.aPR.aSW;
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
                            if (FaceRecognitionActivity.this.mQU.aPR != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.mQU.aPR.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.mQQ.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && i2 == ResultCode.h5UploadDone.code) {
            HK(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bAV);
    }
}
