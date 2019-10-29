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
    private ImageView Co;
    private BaseActivity atC;
    private String iGN;
    private EditText iGO;
    private EditText iGP;
    private TextView iGQ;
    private TextView iGR;
    private a iGS;
    private TextView iGT;
    private String iGU;
    private LinearLayout iGV;
    private TextView iGW;
    private af iGX;
    private RelativeLayout iGY;
    private Context mContext;
    private String mUid;
    private String mUserName;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = true;
    private b iGZ = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.iGN = realAuthenSpResponseMessage.iGN;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.iHd;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if (obj instanceof RealAuthenCertifyInfoResponseMessage) {
                    RealAuthenCertifyInfoResponseMessage realAuthenCertifyInfoResponseMessage = (RealAuthenCertifyInfoResponseMessage) obj;
                    if (realAuthenCertifyInfoResponseMessage.errno == 0 && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(realAuthenCertifyInfoResponseMessage.errmsg)) {
                        FaceRecognitionActivity.this.yh(0);
                    }
                }
            }
        }
    };
    private HttpMessageListener akQ = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.cfs();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.atC = this;
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
        this.iGS = new com.baidu.tieba.realauthen.a.a(this.iGZ);
        this.iGS.cft();
        MessageManager.getInstance().registerListener(this.akQ);
    }

    private void setupViews() {
        this.iGY = (RelativeLayout) findViewById(a.g.rl_content);
        this.iGY.setOnClickListener(this);
        this.Co = (ImageView) findViewById(a.g.img_back);
        this.Co.setOnClickListener(this);
        this.iGX = com.baidu.live.l.a.uA().akM;
        this.selectorImg = (ImageView) findViewById(a.g.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.iGT = (TextView) findViewById(a.g.agreement);
        this.iGT.setMovementMethod(LinkMovementMethod.getInstance());
        cfs();
        this.iGO = (EditText) findViewById(a.g.name);
        com.baidu.tieba.realauthen.b.a.i(this.iGO);
        this.iGO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.iGR.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cfq();
            }
        });
        this.iGO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.iGO.getText().toString();
                FaceRecognitionActivity.this.cfq();
                if (!z && !TextUtils.isEmpty(obj) && !j.cX(obj)) {
                    FaceRecognitionActivity.this.aD(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.j(this.iGO);
        this.iGP = (EditText) findViewById(a.g.idno);
        this.iGP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.iGR.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.cfq();
            }
        });
        this.iGP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.iGP.getText().toString();
                FaceRecognitionActivity.this.cfq();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String cT = d.cT(obj);
                    if (!HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(cT)) {
                        FaceRecognitionActivity.this.aD(0, cT);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.j(this.iGP);
        this.iGQ = (TextView) findViewById(a.g.toAuth_textView);
        this.iGQ.setOnClickListener(this);
        this.iGV = (LinearLayout) findViewById(a.g.ll_authen_retry);
        this.iGW = (TextView) findViewById(a.g.authen_retry);
        this.iGW.setOnClickListener(this);
        this.iGR = (TextView) findViewById(a.g.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iGY) {
            this.iGO.clearFocus();
            this.iGP.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.iGY.getWindowToken(), 2);
            }
        } else if (view == this.Co) {
            yh(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            cfq();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.f.icon_live_choose_s : a.f.icon_live_operatechoose_n);
        } else if (view == this.iGQ) {
            this.iGR.setVisibility(4);
            if (TextUtils.isEmpty(this.iGO.getText().toString()) || TextUtils.isEmpty(this.iGP.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            qa(false);
            cfr();
        } else if (view == this.iGW && this.iGX.Uk != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(this.atC.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.iGX.Uk.UE)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfq() {
        if (!TextUtils.isEmpty(this.iGO.getText().toString()) && j.cX(this.iGO.getText().toString()) && !TextUtils.isEmpty(this.iGP.getText().toString()) && HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS.equals(d.cT(this.iGP.getText().toString())) && this.mChosen) {
            qa(true);
        } else {
            qa(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(int i, String str) {
        if (i == 0) {
            this.iGR.setVisibility(0);
            this.iGR.setText(str);
            this.iGV.setVisibility(0);
            return;
        }
        this.iGR.setVisibility(4);
        this.iGV.setVisibility(4);
    }

    private void qa(boolean z) {
        if (this.iGQ != null) {
            if (z) {
                this.iGQ.setClickable(true);
                this.iGQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.iGQ.setBackgroundResource(a.f.bg_toauth_shape_corner);
                return;
            }
            this.iGQ.setClickable(false);
            this.iGQ.setTextColor(getResources().getColor(a.d.sdk_common_color_10259));
            this.iGQ.setBackgroundResource(a.f.bg_toauth_shape_corner_n);
        }
    }

    private void cfr() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.iGO.getText().toString();
        hashMap.put("realName", this.iGO.getText().toString());
        this.iGU = this.iGP.getText().toString();
        hashMap.put("idCardNo", this.iGP.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.ae(this.iGN, this.reqId, this.sign));
        Log.i("FaceRecognition", "-->参数 livenessRecognize:" + hashMap.toString());
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new RealAuthen.AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.RealAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.cfq();
                            if (map != null) {
                                Log.i("FaceRecognition", "-->认证返回 Map result:" + map.toString());
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.iGS != null) {
                                            FaceRecognitionActivity.this.iGS.w(FaceRecognitionActivity.this.mUid, str, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.iGU);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        FaceRecognitionActivity.this.aD(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), map.get("retMsg")));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.aD(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.i.authen_fail), map.get("retMsg")));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(int i) {
        Intent intent = new Intent();
        getActivity().setResult(-1, intent);
        intent.putExtra("resultCode", i);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfs() {
        if (this.iGT != null) {
            String str = "";
            if (this.iGX.Uj != null) {
                str = this.iGX.Uj.Vt;
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
                            if (FaceRecognitionActivity.this.iGX.Uj != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.iGX.Uj.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.iGT.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && intent.getIntExtra("resultCode", -1) == 0) {
            yh(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.akQ);
    }
}
