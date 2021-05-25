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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.ufosdk.R;
import com.baidu.ufosdk.UfoSDK;
import com.tencent.connect.common.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ev extends Dialog implements DialogInterface.OnDismissListener, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public View f22821a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f22822b;

    /* renamed from: c  reason: collision with root package name */
    public Button f22823c;

    /* renamed from: d  reason: collision with root package name */
    public String f22824d;

    /* renamed from: e  reason: collision with root package name */
    public int f22825e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22826f;

    /* renamed from: g  reason: collision with root package name */
    public Context f22827g;

    /* renamed from: h  reason: collision with root package name */
    public int f22828h;

    /* renamed from: i  reason: collision with root package name */
    public int f22829i;
    public String j;
    public int k;
    public JSONArray l;
    public ArrayList m;
    public Handler n;
    public List o;
    public CheckBox p;
    public CheckBox q;
    public CheckBox r;
    public CheckBox s;
    public CheckBox t;

    public ev(Context context, int i2, JSONArray jSONArray, int i3, String str, Handler handler, List list) {
        super(context, i2);
        this.f22828h = -1;
        this.f22829i = -1;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = new ArrayList();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.f22827g = context;
        this.l = jSONArray;
        this.k = i3;
        this.j = str;
        this.n = handler;
        this.o = list;
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setOnDismissListener(this);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.dialog_animation);
        View inflate = View.inflate(this.f22827g, R.layout.ufo_evaluate_dialog, null);
        inflate.findViewById(R.id.btn_dialog_close).setOnClickListener(this);
        inflate.findViewById(R.id.header_transparent).setOnClickListener(this);
        window.setContentView(inflate);
        this.f22821a = com.baidu.ufosdk.f.i.b(this.f22827g, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f22821a.setVisibility(8);
        ((RelativeLayout) inflate.findViewById(R.id.rl_root)).addView(this.f22821a, layoutParams);
        window.setLayout(-1, -2);
        Button button = (Button) inflate.findViewById(R.id.btn_sumbit_evaluate);
        this.f22823c = button;
        button.setOnClickListener(this);
        EditText editText = (EditText) inflate.findViewById(R.id.et_input);
        this.f22822b = editText;
        editText.setOnClickListener(this);
        JSONArray jSONArray2 = this.l;
        if (jSONArray2 != null && jSONArray2.length() > 0) {
            this.f22828h = 0;
            inflate.findViewById(R.id.ll_checkboxs).setVisibility(0);
            int length = this.l.length();
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            if (length == 5) {
                                inflate.findViewById(R.id.ll_checkboxs_3).setVisibility(0);
                                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.cb_31);
                                this.t = checkBox;
                                checkBox.setVisibility(0);
                                this.t.setText(this.l.optString(4));
                                this.t.setOnCheckedChangeListener(this);
                                this.t.setOnClickListener(this);
                            }
                        }
                        inflate.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.cb_22);
                        this.s = checkBox2;
                        checkBox2.setVisibility(0);
                        this.s.setText(this.l.optString(3));
                        this.s.setOnCheckedChangeListener(this);
                        this.s.setOnClickListener(this);
                    }
                    inflate.findViewById(R.id.ll_checkboxs_2).setVisibility(0);
                    CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.cb_21);
                    this.r = checkBox3;
                    checkBox3.setVisibility(0);
                    this.r.setText(this.l.optString(2));
                    this.r.setOnCheckedChangeListener(this);
                    this.r.setOnClickListener(this);
                }
                inflate.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
                CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.cb_12);
                this.q = checkBox4;
                checkBox4.setVisibility(0);
                this.q.setText(this.l.optString(1));
                this.q.setOnCheckedChangeListener(this);
                this.q.setOnClickListener(this);
            }
            inflate.findViewById(R.id.ll_checkboxs_1).setVisibility(0);
            CheckBox checkBox5 = (CheckBox) inflate.findViewById(R.id.cb_11);
            this.p = checkBox5;
            checkBox5.setVisibility(0);
            this.p.setText(this.l.optString(0));
            this.p.setOnCheckedChangeListener(this);
            this.p.setOnClickListener(this);
        }
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        this.f22829i = 0;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_input);
        relativeLayout.setVisibility(0);
        this.f22822b.setHint(this.j);
        this.f22822b.clearFocus();
        this.f22822b.setFocusable(false);
        relativeLayout.setBackgroundResource(R.drawable.dialog_checkbox_bg_normal);
        this.f22822b.setOnClickListener(this);
        this.f22822b.addTextChangedListener(this);
        this.f22822b.setOnFocusChangeListener(new ew(this, relativeLayout));
        if (this.k == 0) {
            this.f22823c.setBackgroundResource(R.drawable.dialog_btn_selector);
            this.f22823c.setTextColor(-1);
            this.f22823c.setClickable(true);
        }
    }

    public static void a(CheckBox checkBox) {
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
    }

    public static /* synthetic */ void a(ev evVar, String str, JSONArray jSONArray) {
        com.baidu.ufosdk.f.c.a("getEvaluateConfig url: https://ufosdk.baidu.com/?m=Index&a=recordDiscontent");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put(IAdRequestParam.OS, "android");
        hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
        hashMap.put("uid", com.baidu.ufosdk.b.f22474d);
        hashMap.put("username", com.baidu.ufosdk.b.f22472b);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f22474d);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        hashMap.put("extra", com.baidu.ufosdk.b.f22476f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.j));
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put("id", evVar.f22824d);
        if (str != null) {
            hashMap.put("discontent_reason", str);
        }
        if (jSONArray != null) {
            hashMap.put("discontent_labels", jSONArray.toString());
        }
        hashMap.put("baiducuid", com.baidu.ufosdk.b.f22473c);
        String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
        int i2 = 1;
        try {
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=recordDiscontent", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            if (!TextUtils.isEmpty(a3)) {
                JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a3));
                com.baidu.ufosdk.f.c.c("submit response is -----------------> " + jSONObject.toString());
                i2 = jSONObject.optInt("errno", 1);
                if (i2 == 0) {
                    com.baidu.ufosdk.f.c.b("submitEvaluation success!");
                    if (str != null) {
                        ((Map) evVar.o.get(evVar.f22825e)).put("discontent_reason", str);
                    }
                    if (jSONArray != null) {
                        ((Map) evVar.o.get(evVar.f22825e)).put("discontent_labels", jSONArray);
                    }
                }
            }
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("Evaluatioin error!", e2);
        }
        evVar.n.obtainMessage(11, Integer.valueOf(i2)).sendToTarget();
    }

    private void b() {
        this.f22821a.setVisibility(0);
        this.f22821a.bringToFront();
        this.f22823c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
        this.f22823c.setTextColor(872415231);
        this.f22823c.setClickable(false);
        this.f22822b.clearFocus();
        this.f22822b.setFocusable(false);
        new Thread(new ex(this)).start();
    }

    public final void a() {
        this.m.clear();
        this.f22822b.setText("");
        a(this.p);
        a(this.q);
        a(this.r);
        a(this.s);
        a(this.t);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (this.f22822b.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            String substring = this.f22822b.getText().toString().substring(0, com.baidu.ufosdk.b.aa);
            this.f22822b.setText(substring);
            this.f22822b.setSelection(substring.length());
            Toast.makeText(this.f22827g, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        }
        if (this.f22822b.getText().toString().trim().length() >= 4) {
            this.f22829i = 2;
        } else if (this.f22822b.getText().toString().trim().length() > 0) {
            this.f22829i = 1;
        } else {
            this.f22829i = 0;
        }
        if (this.k == 1) {
            if (this.f22829i == 2) {
                this.f22823c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.f22823c.setTextColor(-1);
            } else {
                this.f22823c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                this.f22823c.setTextColor(872415231);
            }
        }
        if (this.k == 3) {
            if (this.f22829i == 2 && this.f22828h == 1) {
                this.f22823c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.f22823c.setTextColor(-1);
                return;
            }
            this.f22823c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
            this.f22823c.setTextColor(872415231);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.m.add(compoundButton.getText().toString());
        } else {
            this.m.remove(compoundButton.getText().toString());
        }
        if (this.m.size() > 0) {
            this.f22828h = 1;
        } else {
            this.f22828h = 0;
        }
        if (this.k == 2) {
            if (this.f22828h == 1) {
                this.f22823c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.f22823c.setTextColor(-1);
            } else {
                this.f22823c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                this.f22823c.setTextColor(872415231);
            }
        }
        if (this.k == 3) {
            if (this.f22828h == 1 && this.f22829i == 2) {
                this.f22823c.setBackgroundResource(R.drawable.dialog_btn_selector);
                this.f22823c.setTextColor(-1);
                return;
            }
            this.f22823c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
            this.f22823c.setTextColor(872415231);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ba, code lost:
        if (r7 == 2) goto L31;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        Context context;
        Context context2;
        Toast makeText;
        if (view.getId() == R.id.btn_dialog_close) {
            dismiss();
        }
        if (view.getId() == R.id.header_transparent) {
            dismiss();
        }
        if (view.getId() != R.id.et_input) {
            this.f22822b.clearFocus();
            this.f22822b.setFocusable(false);
        } else {
            this.n.obtainMessage(18, "focus true").sendToTarget();
            this.f22822b.setFocusable(true);
            this.f22822b.setFocusableInTouchMode(true);
            this.f22822b.requestFocus();
        }
        if (view.getId() == R.id.btn_sumbit_evaluate) {
            int i2 = this.f22828h;
            String str = "无反馈内容，无法提交哦~";
            if (i2 == -1) {
                int i3 = this.f22829i;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            b();
                            return;
                        }
                        context2 = this.f22827g;
                        makeText = Toast.makeText(context2, str, 0);
                    }
                    makeText = Toast.makeText(this.f22827g, "评价内容过少，无法提交哦~", 0);
                }
                makeText = Toast.makeText(this.f22827g, "未输入评论，无法提交哦~", 0);
            } else {
                int i4 = this.f22829i;
                if (i4 == -1) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            b();
                            return;
                        }
                        context2 = this.f22827g;
                        makeText = Toast.makeText(context2, str, 0);
                    }
                } else if (i2 == -1 || i4 == -1) {
                    return;
                } else {
                    int i5 = this.k;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3) {
                                    return;
                                }
                                if (i2 == 1) {
                                    if (i4 != 0) {
                                        if (i4 != 1) {
                                            if (i4 == 2) {
                                                b();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    makeText = Toast.makeText(this.f22827g, "未输入评论，无法提交哦~", 0);
                                } else {
                                    context = this.f22827g;
                                }
                            } else if (i2 != 0) {
                                if (i4 != 1) {
                                    if (i2 == 1) {
                                        b();
                                        return;
                                    }
                                    return;
                                }
                            }
                            makeText = Toast.makeText(this.f22827g, "评价内容过少，无法提交哦~", 0);
                        } else {
                            if (i4 != 0) {
                                if (i4 != 1) {
                                    if (i4 == 2) {
                                        b();
                                        return;
                                    }
                                    return;
                                }
                                makeText = Toast.makeText(this.f22827g, "评价内容过少，无法提交哦~", 0);
                            }
                            makeText = Toast.makeText(this.f22827g, "未输入评论，无法提交哦~", 0);
                        }
                    } else if (i4 == 1) {
                        context2 = this.f22827g;
                        str = "评论内容过少，无法提交哦~";
                        makeText = Toast.makeText(context2, str, 0);
                    } else if (i2 != 0 || i4 != 0) {
                        b();
                        return;
                    } else {
                        context = this.f22827g;
                    }
                    makeText = Toast.makeText(context, "尚未选择标签或评论，无法提交哦~", 0);
                }
                context = this.f22827g;
                makeText = Toast.makeText(context, "未选择标签，无法提交哦~", 0);
            }
            makeText.show();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.f22826f) {
            this.n.obtainMessage(17).sendToTarget();
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
