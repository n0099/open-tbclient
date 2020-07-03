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
import com.baidu.live.data.bb;
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
    private BaseActivity boL;
    private LinearLayout ldA;
    private TextView ldB;
    private bb ldC;
    private RelativeLayout ldD;
    private String ldr;
    private String lds;
    private EditText ldt;
    private EditText ldu;
    private TextView ldv;
    private TextView ldw;
    private a ldx;
    private TextView ldy;
    private String ldz;
    private ImageView mBack;
    private Context mContext;
    private String mUid;
    private String mUserName;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = false;
    private b ldE = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.lds = realAuthenSpResponseMessage.lds;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.ldI;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if ((obj instanceof RealAuthenCertifyInfoResponseMessage) && ((RealAuthenCertifyInfoResponseMessage) obj).errno == 0) {
                    FaceRecognitionActivity.this.showToast(FaceRecognitionActivity.this.mContext.getResources().getString(a.i.sdk_authen_suc), 17);
                    FaceRecognitionActivity.this.Dm(ResultCode.naCertifyDone.code);
                }
            }
        }
    };
    private HttpMessageListener bdY = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.cYB();
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
            this.boL = this;
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
            this.ldr = getIntent().getStringExtra("retry");
            setupViews();
            this.ldx = new com.baidu.tieba.realauthen.a.a(this.ldE);
            this.ldx.cYC();
            MessageManager.getInstance().registerListener(this.bdY);
        }
    }

    private void setupViews() {
        this.ldD = (RelativeLayout) findViewById(a.g.rl_content);
        this.ldD.setOnClickListener(this);
        this.mBack = (ImageView) findViewById(a.g.img_back);
        this.mBack.setOnClickListener(this);
        this.ldC = com.baidu.live.v.a.Hm().bdV;
        this.selectorImg = (ImageView) findViewById(a.g.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.ldy = (TextView) findViewById(a.g.agreement);
        this.ldy.setMovementMethod(LinkMovementMethod.getInstance());
        cYB();
        this.ldt = (EditText) findViewById(a.g.name);
        com.baidu.tieba.realauthen.b.a.g(this.ldt);
        this.ldt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.ldw.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cYz();
            }
        });
        this.ldt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.ldt.getText().toString();
                FaceRecognitionActivity.this.cYz();
                if (!z && !TextUtils.isEmpty(obj) && !k.fU(obj)) {
                    FaceRecognitionActivity.this.bx(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.ldt);
        this.ldu = (EditText) findViewById(a.g.idno);
        this.ldu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.ldw.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cYz();
            }
        });
        this.ldu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.ldu.getText().toString();
                FaceRecognitionActivity.this.cYz();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String fP = e.fP(obj);
                    if (!HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(fP)) {
                        FaceRecognitionActivity.this.bx(0, fP);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.ldu);
        this.ldv = (TextView) findViewById(a.g.toAuth_textView);
        this.ldv.setOnClickListener(this);
        this.ldA = (LinearLayout) findViewById(a.g.ll_authen_retry);
        this.ldB = (TextView) findViewById(a.g.authen_retry);
        this.ldB.setOnClickListener(this);
        this.ldw = (TextView) findViewById(a.g.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ldD) {
            this.ldt.clearFocus();
            this.ldu.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.ldD.getWindowToken(), 2);
            }
        } else if (view == this.mBack) {
            Dm(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            cYz();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.f.icon_live_choose_s : a.f.icon_live_operatechoose_n);
        } else if (view == this.ldv) {
            if (!this.mChosen) {
                CustomToast.newInstance().showToast(a.i.authen_need_agreement);
                return;
            }
            this.ldw.setVisibility(4);
            if (TextUtils.isEmpty(this.ldt.getText().toString()) || TextUtils.isEmpty(this.ldu.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            tV(false);
            cYA();
        } else if (view == this.ldB && this.ldC.aCZ != null) {
            CommonWebViewActivityConfig commonWebViewActivityConfig = new CommonWebViewActivityConfig(this.boL.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.ldC.aCZ.aDJ);
            if (!TextUtils.isEmpty(this.ldr)) {
                commonWebViewActivityConfig.setCertRetryTag(this.ldr);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, commonWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYz() {
        if (!TextUtils.isEmpty(this.ldt.getText().toString()) && k.fU(this.ldt.getText().toString()) && !TextUtils.isEmpty(this.ldu.getText().toString()) && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(e.fP(this.ldu.getText().toString()))) {
            tV(true);
        } else {
            tV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, String str) {
        if (i == 0) {
            this.ldw.setVisibility(0);
            this.ldw.setText(str);
            this.ldA.setVisibility(0);
            return;
        }
        this.ldw.setVisibility(4);
        this.ldA.setVisibility(4);
    }

    private void tV(boolean z) {
        if (this.ldv != null) {
            if (z) {
                this.ldv.setClickable(true);
                this.ldv.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.ldv.setBackgroundResource(a.f.bg_toauth_shape_corner);
                return;
            }
            this.ldv.setClickable(false);
            this.ldv.setTextColor(getResources().getColor(a.d.sdk_common_color_10259));
            this.ldv.setBackgroundResource(a.f.bg_toauth_shape_corner_n);
        }
    }

    private void cYA() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.ldt.getText().toString();
        hashMap.put("realName", this.ldt.getText().toString());
        this.ldz = this.ldu.getText().toString();
        hashMap.put("idCardNo", this.ldu.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.ax(this.lds, this.reqId, this.sign));
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.cYz();
                            String str = "";
                            if (map.containsKey("retMsg")) {
                                str = (String) map.get("retMsg");
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.ldx != null) {
                                            FaceRecognitionActivity.this.ldx.C(FaceRecognitionActivity.this.mUid, str2, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.ldz);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    FaceRecognitionActivity.this.bx(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (i == -204) {
                                if (map != null && !TextUtils.isEmpty(str)) {
                                    FaceRecognitionActivity.this.bx(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.bx(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm(int i) {
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
    public void cYB() {
        if (this.ldy != null) {
            String str = "";
            if (this.ldC.aCY != null) {
                str = this.ldC.aCY.aEZ;
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
                            if (FaceRecognitionActivity.this.ldC.aCY != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.ldC.aCY.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.ldy.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && i2 == ResultCode.h5UploadDone.code) {
            Dm(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bdY);
    }
}
