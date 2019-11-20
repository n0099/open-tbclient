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
import android.util.Log;
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
import com.baidu.live.data.af;
import com.baidu.live.k.a;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.realAuthen.RealAuthen;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.utils.d;
import com.baidu.live.utils.j;
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
/* loaded from: classes6.dex */
public class FaceRecognitionActivity extends BaseActivity<FaceRecognitionActivity> implements View.OnClickListener {
    private ImageView BO;
    private BaseActivity atk;
    private String iFW;
    private EditText iFX;
    private EditText iFY;
    private TextView iFZ;
    private TextView iGa;
    private a iGb;
    private TextView iGc;
    private String iGd;
    private LinearLayout iGe;
    private TextView iGf;
    private af iGg;
    private RelativeLayout iGh;
    private Context mContext;
    private String mUid;
    private String mUserName;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = true;
    private b iGi = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.iFW = realAuthenSpResponseMessage.iFW;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.iGm;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if (obj instanceof RealAuthenCertifyInfoResponseMessage) {
                    RealAuthenCertifyInfoResponseMessage realAuthenCertifyInfoResponseMessage = (RealAuthenCertifyInfoResponseMessage) obj;
                    if (realAuthenCertifyInfoResponseMessage.errno == 0 && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(realAuthenCertifyInfoResponseMessage.errmsg)) {
                        FaceRecognitionActivity.this.yg(0);
                    }
                }
            }
        }
    };
    private HttpMessageListener aky = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.cfq();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.atk = this;
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
        setupViews();
        this.iGb = new com.baidu.tieba.realauthen.a.a(this.iGi);
        this.iGb.cfr();
        MessageManager.getInstance().registerListener(this.aky);
    }

    private void setupViews() {
        this.iGh = (RelativeLayout) findViewById(a.g.rl_content);
        this.iGh.setOnClickListener(this);
        this.BO = (ImageView) findViewById(a.g.img_back);
        this.BO.setOnClickListener(this);
        this.iGg = com.baidu.live.l.a.uB().aku;
        this.selectorImg = (ImageView) findViewById(a.g.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.iGc = (TextView) findViewById(a.g.agreement);
        this.iGc.setMovementMethod(LinkMovementMethod.getInstance());
        cfq();
        this.iFX = (EditText) findViewById(a.g.name);
        com.baidu.tieba.realauthen.b.a.i(this.iFX);
        this.iFX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.iGa.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cfo();
            }
        });
        this.iFX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.iFX.getText().toString();
                FaceRecognitionActivity.this.cfo();
                if (!z && !TextUtils.isEmpty(obj) && !j.cX(obj)) {
                    FaceRecognitionActivity.this.aC(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.j(this.iFX);
        this.iFY = (EditText) findViewById(a.g.idno);
        this.iFY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.iGa.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cfo();
            }
        });
        this.iFY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.iFY.getText().toString();
                FaceRecognitionActivity.this.cfo();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String cT = d.cT(obj);
                    if (!HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(cT)) {
                        FaceRecognitionActivity.this.aC(0, cT);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.j(this.iFY);
        this.iFZ = (TextView) findViewById(a.g.toAuth_textView);
        this.iFZ.setOnClickListener(this);
        this.iGe = (LinearLayout) findViewById(a.g.ll_authen_retry);
        this.iGf = (TextView) findViewById(a.g.authen_retry);
        this.iGf.setOnClickListener(this);
        this.iGa = (TextView) findViewById(a.g.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iGh) {
            this.iFX.clearFocus();
            this.iFY.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.iGh.getWindowToken(), 2);
            }
        } else if (view == this.BO) {
            yg(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            cfo();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.f.icon_live_choose_s : a.f.icon_live_operatechoose_n);
        } else if (view == this.iFZ) {
            this.iGa.setVisibility(4);
            if (TextUtils.isEmpty(this.iFX.getText().toString()) || TextUtils.isEmpty(this.iFY.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            qa(false);
            cfp();
        } else if (view == this.iGf && this.iGg.TR != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(this.atk.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.iGg.TR.Uk)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfo() {
        if (!TextUtils.isEmpty(this.iFX.getText().toString()) && j.cX(this.iFX.getText().toString()) && !TextUtils.isEmpty(this.iFY.getText().toString()) && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(d.cT(this.iFY.getText().toString())) && this.mChosen) {
            qa(true);
        } else {
            qa(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (i == 0) {
            this.iGa.setVisibility(0);
            this.iGa.setText(str);
            this.iGe.setVisibility(0);
            return;
        }
        this.iGa.setVisibility(4);
        this.iGe.setVisibility(4);
    }

    private void qa(boolean z) {
        if (this.iFZ != null) {
            if (z) {
                this.iFZ.setClickable(true);
                this.iFZ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.iFZ.setBackgroundResource(a.f.bg_toauth_shape_corner);
                return;
            }
            this.iFZ.setClickable(false);
            this.iFZ.setTextColor(getResources().getColor(a.d.sdk_common_color_10259));
            this.iFZ.setBackgroundResource(a.f.bg_toauth_shape_corner_n);
        }
    }

    private void cfp() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.iFX.getText().toString();
        hashMap.put("realName", this.iFX.getText().toString());
        this.iGd = this.iFY.getText().toString();
        hashMap.put("idCardNo", this.iFY.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.ae(this.iFW, this.reqId, this.sign));
        Log.i("FaceRecognition", "-->参数 livenessRecognize:" + hashMap.toString());
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new RealAuthen.AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.RealAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.cfo();
                            if (map != null) {
                                Log.i("FaceRecognition", "-->认证返回 Map result:" + map.toString());
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.iGb != null) {
                                            FaceRecognitionActivity.this.iGb.w(FaceRecognitionActivity.this.mUid, str, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.iGd);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        FaceRecognitionActivity.this.aC(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), map.get("retMsg")));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.aC(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), map.get("retMsg")));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yg(int i) {
        Intent intent = new Intent();
        getActivity().setResult(-1, intent);
        intent.putExtra("resultCode", i);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfq() {
        if (this.iGc != null) {
            String str = "";
            if (this.iGg.TQ != null) {
                str = this.iGg.TQ.Va;
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
                            if (FaceRecognitionActivity.this.iGg.TQ != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.iGg.TQ.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.iGc.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && intent.getIntExtra("resultCode", -1) == 0) {
            yg(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aky);
    }
}
