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
import com.baidu.live.data.bc;
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
/* loaded from: classes4.dex */
public class FaceRecognitionActivity extends BaseActivity<FaceRecognitionActivity> implements View.OnClickListener {
    private BaseActivity bpg;
    private String lkG;
    private String lkH;
    private EditText lkI;
    private EditText lkJ;
    private TextView lkK;
    private TextView lkL;
    private a lkM;
    private TextView lkN;
    private String lkO;
    private LinearLayout lkP;
    private TextView lkQ;
    private bc lkR;
    private RelativeLayout lkS;
    private ImageView mBack;
    private Context mContext;
    private String mUid;
    private String mUserName;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = false;
    private b lkT = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.lkH = realAuthenSpResponseMessage.lkH;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.lkW;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if ((obj instanceof RealAuthenCertifyInfoResponseMessage) && ((RealAuthenCertifyInfoResponseMessage) obj).errno == 0) {
                    FaceRecognitionActivity.this.showToast(FaceRecognitionActivity.this.mContext.getResources().getString(a.i.sdk_authen_suc), 17);
                    FaceRecognitionActivity.this.DI(ResultCode.naCertifyDone.code);
                }
            }
        }
    };
    private HttpMessageListener ber = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.dbJ();
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
            this.bpg = this;
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
            this.lkG = getIntent().getStringExtra("retry");
            setupViews();
            this.lkM = new com.baidu.tieba.realauthen.a.a(this.lkT);
            this.lkM.dbK();
            MessageManager.getInstance().registerListener(this.ber);
        }
    }

    private void setupViews() {
        this.lkS = (RelativeLayout) findViewById(a.g.rl_content);
        this.lkS.setOnClickListener(this);
        this.mBack = (ImageView) findViewById(a.g.img_back);
        this.mBack.setOnClickListener(this);
        this.lkR = com.baidu.live.v.a.Hs().beo;
        this.selectorImg = (ImageView) findViewById(a.g.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.lkN = (TextView) findViewById(a.g.agreement);
        this.lkN.setMovementMethod(LinkMovementMethod.getInstance());
        dbJ();
        this.lkI = (EditText) findViewById(a.g.name);
        com.baidu.tieba.realauthen.b.a.g(this.lkI);
        this.lkI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.lkL.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.dbH();
            }
        });
        this.lkI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.lkI.getText().toString();
                FaceRecognitionActivity.this.dbH();
                if (!z && !TextUtils.isEmpty(obj) && !k.fT(obj)) {
                    FaceRecognitionActivity.this.by(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.lkI);
        this.lkJ = (EditText) findViewById(a.g.idno);
        this.lkJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.lkL.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.dbH();
            }
        });
        this.lkJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.lkJ.getText().toString();
                FaceRecognitionActivity.this.dbH();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String fN = e.fN(obj);
                    if (!HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(fN)) {
                        FaceRecognitionActivity.this.by(0, fN);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.lkJ);
        this.lkK = (TextView) findViewById(a.g.toAuth_textView);
        this.lkK.setOnClickListener(this);
        this.lkP = (LinearLayout) findViewById(a.g.ll_authen_retry);
        this.lkQ = (TextView) findViewById(a.g.authen_retry);
        this.lkQ.setOnClickListener(this);
        this.lkL = (TextView) findViewById(a.g.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lkS) {
            this.lkI.clearFocus();
            this.lkJ.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.lkS.getWindowToken(), 2);
            }
        } else if (view == this.mBack) {
            DI(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            dbH();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.f.icon_live_choose_s : a.f.icon_live_operatechoose_n);
        } else if (view == this.lkK) {
            if (!this.mChosen) {
                CustomToast.newInstance().showToast(a.i.authen_need_agreement);
                return;
            }
            this.lkL.setVisibility(4);
            if (TextUtils.isEmpty(this.lkI.getText().toString()) || TextUtils.isEmpty(this.lkJ.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            uz(false);
            dbI();
        } else if (view == this.lkQ && this.lkR.aEu != null) {
            CommonWebViewActivityConfig commonWebViewActivityConfig = new CommonWebViewActivityConfig(this.bpg.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.lkR.aEu.aFd);
            if (!TextUtils.isEmpty(this.lkG)) {
                commonWebViewActivityConfig.setCertRetryTag(this.lkG);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, commonWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbH() {
        if (!TextUtils.isEmpty(this.lkI.getText().toString()) && k.fT(this.lkI.getText().toString()) && !TextUtils.isEmpty(this.lkJ.getText().toString()) && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(e.fN(this.lkJ.getText().toString()))) {
            uz(true);
        } else {
            uz(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, String str) {
        if (i == 0) {
            this.lkL.setVisibility(0);
            this.lkL.setText(str);
            this.lkP.setVisibility(0);
            return;
        }
        this.lkL.setVisibility(4);
        this.lkP.setVisibility(4);
    }

    private void uz(boolean z) {
        if (this.lkK != null) {
            if (z) {
                this.lkK.setClickable(true);
                this.lkK.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.lkK.setBackgroundResource(a.f.bg_toauth_shape_corner);
                return;
            }
            this.lkK.setClickable(false);
            this.lkK.setTextColor(getResources().getColor(a.d.sdk_common_color_10259));
            this.lkK.setBackgroundResource(a.f.bg_toauth_shape_corner_n);
        }
    }

    private void dbI() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.lkI.getText().toString();
        hashMap.put("realName", this.lkI.getText().toString());
        this.lkO = this.lkJ.getText().toString();
        hashMap.put("idCardNo", this.lkJ.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.aw(this.lkH, this.reqId, this.sign));
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.dbH();
                            String str = "";
                            if (map.containsKey("retMsg")) {
                                str = (String) map.get("retMsg");
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.lkM != null) {
                                            FaceRecognitionActivity.this.lkM.C(FaceRecognitionActivity.this.mUid, str2, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.lkO);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    FaceRecognitionActivity.this.by(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (i == -204) {
                                if (map != null && !TextUtils.isEmpty(str)) {
                                    FaceRecognitionActivity.this.by(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.by(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), str));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DI(int i) {
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
    public void dbJ() {
        if (this.lkN != null) {
            String str = "";
            if (this.lkR.aEt != null) {
                str = this.lkR.aEt.aGu;
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
                            if (FaceRecognitionActivity.this.lkR.aEt != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.lkR.aEt.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.lkN.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && i2 == ResultCode.h5UploadDone.code) {
            DI(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ber);
    }
}
