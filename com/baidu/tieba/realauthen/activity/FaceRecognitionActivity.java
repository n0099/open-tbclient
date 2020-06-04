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
import com.baidu.live.data.ax;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
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
import com.baidu.live.u.a;
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
/* loaded from: classes3.dex */
public class FaceRecognitionActivity extends BaseActivity<FaceRecognitionActivity> implements View.OnClickListener {
    private BaseActivity bjI;
    private EditText kJA;
    private TextView kJB;
    private TextView kJC;
    private a kJD;
    private TextView kJE;
    private String kJF;
    private LinearLayout kJG;
    private TextView kJH;
    private ax kJI;
    private RelativeLayout kJJ;
    private String kJx;
    private String kJy;
    private EditText kJz;
    private ImageView mBack;
    private Context mContext;
    private String mUid;
    private String mUserName;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = false;
    private b kJK = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.kJy = realAuthenSpResponseMessage.kJy;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.kJO;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if ((obj instanceof RealAuthenCertifyInfoResponseMessage) && ((RealAuthenCertifyInfoResponseMessage) obj).errno == 0) {
                    FaceRecognitionActivity.this.showToast(FaceRecognitionActivity.this.mContext.getResources().getString(a.i.sdk_authen_suc), 17);
                    FaceRecognitionActivity.this.Ck(ResultCode.naCertifyDone.code);
                }
            }
        }
    };
    private HttpMessageListener aYS = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.cUl();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.mContext = this;
            this.bjI = this;
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
            this.kJx = getIntent().getStringExtra("retry");
            setupViews();
            this.kJD = new com.baidu.tieba.realauthen.a.a(this.kJK);
            this.kJD.cUm();
            MessageManager.getInstance().registerListener(this.aYS);
        }
    }

    private void setupViews() {
        this.kJJ = (RelativeLayout) findViewById(a.g.rl_content);
        this.kJJ.setOnClickListener(this);
        this.mBack = (ImageView) findViewById(a.g.img_back);
        this.mBack.setOnClickListener(this);
        this.kJI = com.baidu.live.v.a.Ge().aYP;
        this.selectorImg = (ImageView) findViewById(a.g.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.kJE = (TextView) findViewById(a.g.agreement);
        this.kJE.setMovementMethod(LinkMovementMethod.getInstance());
        cUl();
        this.kJz = (EditText) findViewById(a.g.name);
        com.baidu.tieba.realauthen.b.a.g(this.kJz);
        this.kJz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.kJC.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cUj();
            }
        });
        this.kJz.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.kJz.getText().toString();
                FaceRecognitionActivity.this.cUj();
                if (!z && !TextUtils.isEmpty(obj) && !k.fL(obj)) {
                    FaceRecognitionActivity.this.bs(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.kJz);
        this.kJA = (EditText) findViewById(a.g.idno);
        this.kJA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.kJC.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cUj();
            }
        });
        this.kJA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.kJA.getText().toString();
                FaceRecognitionActivity.this.cUj();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String fH = e.fH(obj);
                    if (!HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(fH)) {
                        FaceRecognitionActivity.this.bs(0, fH);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.kJA);
        this.kJB = (TextView) findViewById(a.g.toAuth_textView);
        this.kJB.setOnClickListener(this);
        this.kJG = (LinearLayout) findViewById(a.g.ll_authen_retry);
        this.kJH = (TextView) findViewById(a.g.authen_retry);
        this.kJH.setOnClickListener(this);
        this.kJC = (TextView) findViewById(a.g.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kJJ) {
            this.kJz.clearFocus();
            this.kJA.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.kJJ.getWindowToken(), 2);
            }
        } else if (view == this.mBack) {
            Ck(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            cUj();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.f.icon_live_choose_s : a.f.icon_live_operatechoose_n);
        } else if (view == this.kJB) {
            if (!this.mChosen) {
                CustomToast.newInstance().showToast(a.i.authen_need_agreement);
                return;
            }
            this.kJC.setVisibility(4);
            if (TextUtils.isEmpty(this.kJz.getText().toString()) || TextUtils.isEmpty(this.kJA.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            tG(false);
            cUk();
        } else if (view == this.kJH && this.kJI.aAO != null) {
            CommonWebViewActivityConfig commonWebViewActivityConfig = new CommonWebViewActivityConfig(this.bjI.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.kJI.aAO.aBy);
            if (!TextUtils.isEmpty(this.kJx)) {
                commonWebViewActivityConfig.setCertRetryTag(this.kJx);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, commonWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUj() {
        if (!TextUtils.isEmpty(this.kJz.getText().toString()) && k.fL(this.kJz.getText().toString()) && !TextUtils.isEmpty(this.kJA.getText().toString()) && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(e.fH(this.kJA.getText().toString()))) {
            tG(true);
        } else {
            tG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(int i, String str) {
        if (i == 0) {
            this.kJC.setVisibility(0);
            this.kJC.setText(str);
            this.kJG.setVisibility(0);
            return;
        }
        this.kJC.setVisibility(4);
        this.kJG.setVisibility(4);
    }

    private void tG(boolean z) {
        if (this.kJB != null) {
            if (z) {
                this.kJB.setClickable(true);
                this.kJB.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.kJB.setBackgroundResource(a.f.bg_toauth_shape_corner);
                return;
            }
            this.kJB.setClickable(false);
            this.kJB.setTextColor(getResources().getColor(a.d.sdk_common_color_10259));
            this.kJB.setBackgroundResource(a.f.bg_toauth_shape_corner_n);
        }
    }

    private void cUk() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.kJz.getText().toString();
        hashMap.put("realName", this.kJz.getText().toString());
        this.kJF = this.kJA.getText().toString();
        hashMap.put("idCardNo", this.kJA.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.aw(this.kJy, this.reqId, this.sign));
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.cUj();
                            String str = "";
                            if (map.containsKey("retMsg")) {
                                str = (String) map.get("retMsg");
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.kJD != null) {
                                            FaceRecognitionActivity.this.kJD.C(FaceRecognitionActivity.this.mUid, str2, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.kJF);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    FaceRecognitionActivity.this.bs(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (i == -204) {
                                if (map != null && !TextUtils.isEmpty(str)) {
                                    FaceRecognitionActivity.this.bs(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.bs(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck(int i) {
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
    public void cUl() {
        if (this.kJE != null) {
            String str = "";
            if (this.kJI.aAN != null) {
                str = this.kJI.aAN.aCH;
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
                            if (FaceRecognitionActivity.this.kJI.aAN != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.kJI.aAN.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.kJE.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && i2 == ResultCode.h5UploadDone.code) {
            Ck(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aYS);
    }
}
