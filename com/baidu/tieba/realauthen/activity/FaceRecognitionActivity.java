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
import com.baidu.live.data.bn;
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
import com.baidu.live.utils.l;
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
    private BaseActivity bNs;
    private ImageView mBack;
    private Context mContext;
    private String mUid;
    private String mUserName;
    private String msa;
    private String msb;
    private EditText msc;
    private EditText msd;
    private TextView mse;
    private TextView msf;
    private a msh;
    private TextView msi;
    private String msj;
    private LinearLayout msk;
    private TextView msl;
    private bn msm;
    private RelativeLayout msn;
    private String reqId;
    private ImageView selectorImg;
    private String sign;
    private boolean mChosen = false;
    private b mso = new b() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.6
        @Override // com.baidu.tieba.realauthen.a.b
        public void a(int i, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof RealAuthenSpResponseMessage) {
                    RealAuthenSpResponseMessage realAuthenSpResponseMessage = (RealAuthenSpResponseMessage) obj;
                    FaceRecognitionActivity.this.msb = realAuthenSpResponseMessage.msb;
                    FaceRecognitionActivity.this.reqId = realAuthenSpResponseMessage.msr;
                    FaceRecognitionActivity.this.sign = realAuthenSpResponseMessage.sign;
                }
                if ((obj instanceof RealAuthenCertifyInfoResponseMessage) && ((RealAuthenCertifyInfoResponseMessage) obj).errno == 0) {
                    FaceRecognitionActivity.this.showToast(FaceRecognitionActivity.this.mContext.getResources().getString(a.h.sdk_authen_suc), 17);
                    FaceRecognitionActivity.this.HQ(ResultCode.naCertifyDone.code);
                }
            }
        }
    };
    private HttpMessageListener btW = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    FaceRecognitionActivity.this.dzX();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.mContext = this;
            this.bNs = this;
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
            this.msa = getIntent().getStringExtra("retry");
            setupViews();
            this.msh = new com.baidu.tieba.realauthen.a.a(this.mso);
            this.msh.dzY();
            MessageManager.getInstance().registerListener(this.btW);
        }
    }

    private void setupViews() {
        this.msn = (RelativeLayout) findViewById(a.f.rl_content);
        this.msn.setOnClickListener(this);
        this.mBack = (ImageView) findViewById(a.f.img_back);
        this.mBack.setOnClickListener(this);
        this.msm = com.baidu.live.aa.a.PQ().btT;
        this.selectorImg = (ImageView) findViewById(a.f.selector_img);
        this.selectorImg.setOnClickListener(this);
        this.msi = (TextView) findViewById(a.f.agreement);
        this.msi.setMovementMethod(LinkMovementMethod.getInstance());
        dzX();
        this.msc = (EditText) findViewById(a.f.name);
        com.baidu.tieba.realauthen.b.a.g(this.msc);
        this.msc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.msf.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.dzV();
            }
        });
        this.msc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.msc.getText().toString();
                FaceRecognitionActivity.this.dzV();
                if (!z && !TextUtils.isEmpty(obj) && !l.iF(obj)) {
                    FaceRecognitionActivity.this.bO(0, "请输入正确的姓名！");
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.msc);
        this.msd = (EditText) findViewById(a.f.idno);
        this.msd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FaceRecognitionActivity.this.msf.setVisibility(4);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FaceRecognitionActivity.this.dzV();
            }
        });
        this.msd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                String obj = FaceRecognitionActivity.this.msd.getText().toString();
                FaceRecognitionActivity.this.dzV();
                if (!z && !TextUtils.isEmpty(obj)) {
                    String iz = f.iz(obj);
                    if (!"Success".equals(iz)) {
                        FaceRecognitionActivity.this.bO(0, iz);
                    }
                }
            }
        });
        com.baidu.tieba.realauthen.b.a.h(this.msd);
        this.mse = (TextView) findViewById(a.f.toAuth_textView);
        this.mse.setOnClickListener(this);
        this.msk = (LinearLayout) findViewById(a.f.ll_authen_retry);
        this.msl = (TextView) findViewById(a.f.authen_retry);
        this.msl.setOnClickListener(this);
        this.msf = (TextView) findViewById(a.f.authen_fail_tip);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.msn) {
            this.msc.clearFocus();
            this.msd.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.msn.getWindowToken(), 2);
            }
        } else if (view == this.mBack) {
            HQ(-1);
        } else if (view == this.selectorImg) {
            this.mChosen = this.mChosen ? false : true;
            dzV();
            SkinManager.setImageResource(this.selectorImg, this.mChosen ? a.e.icon_live_choose_s : a.e.icon_live_operatechoose_n);
        } else if (view == this.mse) {
            if (!this.mChosen) {
                CustomToast.newInstance().showToast(a.h.authen_need_agreement);
                return;
            }
            this.msf.setVisibility(4);
            if (TextUtils.isEmpty(this.msc.getText().toString()) || TextUtils.isEmpty(this.msd.getText().toString())) {
                Toast.makeText(this.mContext, "输入参数不能为空", 1).show();
                return;
            }
            wD(false);
            dzW();
        } else if (view == this.msl && this.msm.aPD != null) {
            CommonWebViewActivityConfig commonWebViewActivityConfig = new CommonWebViewActivityConfig(this.bNs.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW, this.msm.aPD.aQM);
            if (!TextUtils.isEmpty(this.msa)) {
                commonWebViewActivityConfig.setCertRetryTag(this.msa);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, commonWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzV() {
        if (!TextUtils.isEmpty(this.msc.getText().toString()) && l.iF(this.msc.getText().toString()) && !TextUtils.isEmpty(this.msd.getText().toString()) && "Success".equals(f.iz(this.msd.getText().toString()))) {
            wD(true);
        } else {
            wD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, String str) {
        if (i == 0) {
            this.msf.setVisibility(0);
            this.msf.setText(str);
            this.msk.setVisibility(0);
            return;
        }
        this.msf.setVisibility(4);
        this.msk.setVisibility(4);
    }

    private void wD(boolean z) {
        if (this.mse != null) {
            if (z) {
                this.mse.setClickable(true);
                this.mse.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.mse.setBackgroundResource(a.e.bg_toauth_shape_corner);
                return;
            }
            this.mse.setClickable(false);
            this.mse.setTextColor(getResources().getColor(a.c.sdk_common_color_10259));
            this.mse.setBackgroundResource(a.e.bg_toauth_shape_corner_n);
        }
    }

    private void dzW() {
        final HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", "certinfo");
        this.mUserName = this.msc.getText().toString();
        hashMap.put("realName", this.msc.getText().toString());
        this.msj = this.msd.getText().toString();
        hashMap.put("idCardNo", this.msd.getText().toString());
        hashMap.put("exuid", this.mUid);
        hashMap.put("showGuidePage", "0");
        hashMap.put("imageFlag", "0");
        hashMap.put("spParams", c.aG(this.msb, this.reqId, this.sign));
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new AuthenCallback() { // from class: com.baidu.tieba.realauthen.activity.FaceRecognitionActivity.5.1
                        @Override // com.baidu.live.tbadk.realAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            FaceRecognitionActivity.this.dzV();
                            String str = "";
                            if (map.containsKey("retMsg")) {
                                str = (String) map.get("retMsg");
                            }
                            if (i == 0) {
                                if (map != null) {
                                    try {
                                        String str2 = (String) new JSONObject((String) map.get("result")).get("callbackkey");
                                        if (FaceRecognitionActivity.this.msh != null) {
                                            FaceRecognitionActivity.this.msh.H(FaceRecognitionActivity.this.mUid, str2, FaceRecognitionActivity.this.mUserName, FaceRecognitionActivity.this.msj);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (i == -302) {
                                if (map != null) {
                                    FaceRecognitionActivity.this.bO(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.h.authen_fail), str));
                                }
                            } else if (i == -204) {
                                if (map != null && !TextUtils.isEmpty(str)) {
                                    FaceRecognitionActivity.this.bO(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.h.authen_fail), str));
                                }
                            } else if (map != null) {
                                FaceRecognitionActivity.this.bO(0, String.format(FaceRecognitionActivity.this.mContext.getString(a.h.authen_fail), str));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HQ(int i) {
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
    public void dzX() {
        if (this.msi != null) {
            String str = "";
            if (this.msm.aPC != null) {
                str = this.msm.aPC.aSr;
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
                            if (FaceRecognitionActivity.this.msm.aPC != null) {
                                BrowserHelper.startInternalWebActivity(TbadkCoreApplication.getInst(), FaceRecognitionActivity.this.msm.aPC.link);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                        }
                    }, str.indexOf("《"), str.indexOf("》") + 1, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_color_4886E2)), str.indexOf("《"), str.indexOf("》") + 1, 33);
                }
                this.msi.setText(spannableString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25048 == i && intent != null && i2 == ResultCode.h5UploadDone.code) {
            HQ(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.btW);
    }
}
