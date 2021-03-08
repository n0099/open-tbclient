package com.baidu.ufosdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.ufosdk.R;
import com.baidu.ufosdk.UfoSDK;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ev extends Dialog implements DialogInterface.OnDismissListener, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public View f3773a;
    public EditText b;
    public Button c;
    public String d;
    public int e;
    public boolean f;
    private Context g;
    private int h;
    private int i;
    private String j;
    private int k;
    private JSONArray l;
    private ArrayList m;
    private Handler n;
    private List o;
    private CheckBox p;
    private CheckBox q;
    private CheckBox r;
    private CheckBox s;
    private CheckBox t;

    public ev(Context context, int i, JSONArray jSONArray, int i2, String str, Handler handler, List list) {
        super(context, i);
        this.h = -1;
        this.i = -1;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = new ArrayList();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.g = context;
        this.l = jSONArray;
        this.k = i2;
        this.j = str;
        this.n = handler;
        this.o = list;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setOnDismissListener(this);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.dialog_animation);
        View inflate = View.inflate(this.g, R.layout.ufo_evaluate_dialog, null);
        inflate.findViewById(R.id.btn_dialog_close).setOnClickListener(this);
        inflate.findViewById(R.id.header_transparent).setOnClickListener(this);
        window.setContentView(inflate);
        this.f3773a = com.baidu.ufosdk.f.i.b(this.g, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f3773a.setVisibility(8);
        ((RelativeLayout) inflate.findViewById(R.id.rl_root)).addView(this.f3773a, layoutParams);
        window.setLayout(-1, -2);
        this.c = (Button) inflate.findViewById(R.id.btn_sumbit_evaluate);
        this.c.setOnClickListener(this);
        this.b = (EditText) inflate.findViewById(R.id.et_input);
        this.b.setOnClickListener(this);
        if (this.l != null && this.l.length() > 0) {
            this.h = 0;
            inflate.findViewById(R.id.ll_checkboxs).setVisibility(0);
            switch (this.l.length()) {
                case 5:
                    inflate.findViewById(R.id.ll_checkboxs_3).setVisibility(0);
                    this.t = (CheckBox) inflate.findViewById(R.id.cb_31);
                    this.t.setVisibility(0);
                    this.t.setText(this.l.optString(4));
                    this.t.setOnCheckedChangeListener(this);
                    this.t.setOnClickListener(this);
                case 4:
                    inflate.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                    this.s = (CheckBox) inflate.findViewById(R.id.cb_22);
                    this.s.setVisibility(0);
                    this.s.setText(this.l.optString(3));
                    this.s.setOnCheckedChangeListener(this);
                    this.s.setOnClickListener(this);
                case 3:
                    inflate.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                    this.r = (CheckBox) inflate.findViewById(R.id.cb_21);
                    this.r.setVisibility(0);
                    this.r.setText(this.l.optString(2));
                    this.r.setOnCheckedChangeListener(this);
                    this.r.setOnClickListener(this);
                case 2:
                    inflate.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                    this.q = (CheckBox) inflate.findViewById(R.id.cb_12);
                    this.q.setVisibility(0);
                    this.q.setText(this.l.optString(1));
                    this.q.setOnCheckedChangeListener(this);
                    this.q.setOnClickListener(this);
                case 1:
                    inflate.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                    this.p = (CheckBox) inflate.findViewById(R.id.cb_11);
                    this.p.setVisibility(0);
                    this.p.setText(this.l.optString(0));
                    this.p.setOnCheckedChangeListener(this);
                    this.p.setOnClickListener(this);
                    break;
            }
        }
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        this.i = 0;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_input);
        relativeLayout.setVisibility(0);
        this.b.setHint(this.j);
        this.b.clearFocus();
        this.b.setFocusable(false);
        relativeLayout.setBackgroundResource(R.drawable.dialog_checkbox_bg_normal);
        this.b.setOnClickListener(this);
        this.b.addTextChangedListener(this);
        this.b.setOnFocusChangeListener(new ew(this, relativeLayout));
        if (this.k == 0) {
            this.c.setBackgroundResource(R.drawable.dialog_btn_selector);
            this.c.setTextColor(-1);
            this.c.setClickable(true);
        }
    }

    private static void a(CheckBox checkBox) {
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ev evVar, String str, JSONArray jSONArray) {
        Exception e;
        int i = 1;
        com.baidu.ufosdk.f.c.a("getEvaluateConfig url: https://ufosdk.baidu.com/?m=Index&a=recordDiscontent");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put(Constants.PHONE_BRAND, Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.b);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        hashMap.put("extra", com.baidu.ufosdk.b.f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.j));
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put("id", evVar.d);
        if (str != null) {
            hashMap.put("discontent_reason", str);
        }
        if (jSONArray != null) {
            hashMap.put("discontent_labels", jSONArray.toString());
        }
        hashMap.put("baiducuid", com.baidu.ufosdk.b.c);
        try {
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=recordDiscontent", "sdk_encrypt=" + URLEncoder.encode(com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a2));
                com.baidu.ufosdk.f.c.c("submit response is -----------------> " + jSONObject.toString());
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, 1);
                if (optInt == 0) {
                    try {
                        com.baidu.ufosdk.f.c.b("submitEvaluation success!");
                        if (str != null) {
                            ((Map) evVar.o.get(evVar.e)).put("discontent_reason", str);
                        }
                        if (jSONArray != null) {
                            ((Map) evVar.o.get(evVar.e)).put("discontent_labels", jSONArray);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        i = optInt;
                        com.baidu.ufosdk.f.c.a("Evaluatioin error!", e);
                        evVar.n.obtainMessage(11, Integer.valueOf(i)).sendToTarget();
                    }
                }
                i = optInt;
            }
        } catch (Exception e3) {
            e = e3;
        }
        evVar.n.obtainMessage(11, Integer.valueOf(i)).sendToTarget();
    }

    private void b() {
        this.f3773a.setVisibility(0);
        this.f3773a.bringToFront();
        this.c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
        this.c.setTextColor(872415231);
        this.c.setClickable(false);
        this.b.clearFocus();
        this.b.setFocusable(false);
        new Thread(new ex(this)).start();
    }

    public final void a() {
        this.m.clear();
        this.b.setText("");
        a(this.p);
        a(this.q);
        a(this.r);
        a(this.s);
        a(this.t);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (this.b.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            String substring = this.b.getText().toString().substring(0, com.baidu.ufosdk.b.aa);
            this.b.setText(substring);
            this.b.setSelection(substring.length());
            Toast.makeText(this.g, com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        }
        if (this.b.getText().toString().trim().length() >= 4) {
            this.i = 2;
        } else if (this.b.getText().toString().trim().length() > 0) {
            this.i = 1;
        } else {
            this.i = 0;
        }
        if (this.k == 1) {
            if (this.i == 2) {
                this.c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.c.setTextColor(-1);
            } else {
                this.c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                this.c.setTextColor(872415231);
            }
        }
        if (this.k == 3) {
            if (this.i == 2 && this.h == 1) {
                this.c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.c.setTextColor(-1);
                return;
            }
            this.c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
            this.c.setTextColor(872415231);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.m.add(compoundButton.getText().toString());
        } else {
            this.m.remove(compoundButton.getText().toString());
        }
        if (this.m.size() > 0) {
            this.h = 1;
        } else {
            this.h = 0;
        }
        if (this.k == 2) {
            if (this.h == 1) {
                this.c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.c.setTextColor(-1);
            } else {
                this.c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                this.c.setTextColor(872415231);
            }
        }
        if (this.k == 3) {
            if (this.h == 1 && this.i == 2) {
                this.c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.c.setTextColor(-1);
                return;
            }
            this.c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
            this.c.setTextColor(872415231);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.btn_dialog_close) {
            dismiss();
        }
        if (view.getId() == R.id.header_transparent) {
            dismiss();
        }
        if (view.getId() != R.id.et_input) {
            this.b.clearFocus();
            this.b.setFocusable(false);
        } else {
            this.n.obtainMessage(18, "focus true").sendToTarget();
            this.b.setFocusable(true);
            this.b.setFocusableInTouchMode(true);
            this.b.requestFocus();
        }
        if (view.getId() == R.id.btn_sumbit_evaluate) {
            if (this.h == -1) {
                if (this.i == 0) {
                    Toast.makeText(this.g, "未输入评论，无法提交哦~", 0).show();
                } else if (this.i == 1) {
                    Toast.makeText(this.g, "评价内容过少，无法提交哦~", 0).show();
                } else if (this.i == 2) {
                    b();
                } else {
                    Toast.makeText(this.g, "无反馈内容，无法提交哦~", 0).show();
                }
            } else if (this.i == -1) {
                if (this.h == 0) {
                    Toast.makeText(this.g, "未选择标签，无法提交哦~", 0).show();
                } else if (this.h == 1) {
                    b();
                } else {
                    Toast.makeText(this.g, "无反馈内容，无法提交哦~", 0).show();
                }
            } else if (this.h == -1 || this.i == -1) {
            } else {
                switch (this.k) {
                    case 0:
                        if (this.i == 1) {
                            Toast.makeText(this.g, "评论内容过少，无法提交哦~", 0).show();
                            return;
                        } else if (this.h == 0 && this.i == 0) {
                            Toast.makeText(this.g, "尚未选择标签或评论，无法提交哦~", 0).show();
                            return;
                        } else {
                            b();
                            return;
                        }
                    case 1:
                        if (this.i == 0) {
                            Toast.makeText(this.g, "未输入评论，无法提交哦~", 0).show();
                            return;
                        } else if (this.i == 1) {
                            Toast.makeText(this.g, "评价内容过少，无法提交哦~", 0).show();
                            return;
                        } else if (this.i == 2) {
                            b();
                            return;
                        } else {
                            return;
                        }
                    case 2:
                        if (this.h == 0) {
                            Toast.makeText(this.g, "未选择标签，无法提交哦~", 0).show();
                            return;
                        } else if (this.i == 1) {
                            Toast.makeText(this.g, "评价内容过少，无法提交哦~", 0).show();
                            return;
                        } else if (this.h == 1) {
                            b();
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (this.h != 1) {
                            if (this.i == 2) {
                                Toast.makeText(this.g, "未选择标签，无法提交哦~", 0).show();
                                return;
                            } else {
                                Toast.makeText(this.g, "尚未选择标签或评论，无法提交哦~", 0).show();
                                return;
                            }
                        } else if (this.i == 0) {
                            Toast.makeText(this.g, "未输入评论，无法提交哦~", 0).show();
                            return;
                        } else if (this.i == 1) {
                            Toast.makeText(this.g, "评价内容过少，无法提交哦~", 0).show();
                            return;
                        } else if (this.i == 2) {
                            b();
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.f) {
            this.n.obtainMessage(17).sendToTarget();
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
