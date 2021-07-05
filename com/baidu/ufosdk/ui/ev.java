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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.R;
import com.baidu.ufosdk.UfoSDK;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ev extends Dialog implements DialogInterface.OnDismissListener, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f23522a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f23523b;

    /* renamed from: c  reason: collision with root package name */
    public Button f23524c;

    /* renamed from: d  reason: collision with root package name */
    public String f23525d;

    /* renamed from: e  reason: collision with root package name */
    public int f23526e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23527f;

    /* renamed from: g  reason: collision with root package name */
    public Context f23528g;

    /* renamed from: h  reason: collision with root package name */
    public int f23529h;

    /* renamed from: i  reason: collision with root package name */
    public int f23530i;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ev(Context context, int i2, JSONArray jSONArray, int i3, String str, Handler handler, List list) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), jSONArray, Integer.valueOf(i3), str, handler, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23529h = -1;
        this.f23530i = -1;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = new ArrayList();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.f23528g = context;
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
        View inflate = View.inflate(this.f23528g, R.layout.ufo_evaluate_dialog, null);
        inflate.findViewById(R.id.btn_dialog_close).setOnClickListener(this);
        inflate.findViewById(R.id.header_transparent).setOnClickListener(this);
        window.setContentView(inflate);
        this.f23522a = com.baidu.ufosdk.f.i.b(this.f23528g, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f23522a.setVisibility(8);
        ((RelativeLayout) inflate.findViewById(R.id.rl_root)).addView(this.f23522a, layoutParams);
        window.setLayout(-1, -2);
        Button button = (Button) inflate.findViewById(R.id.btn_sumbit_evaluate);
        this.f23524c = button;
        button.setOnClickListener(this);
        EditText editText = (EditText) inflate.findViewById(R.id.et_input);
        this.f23523b = editText;
        editText.setOnClickListener(this);
        JSONArray jSONArray2 = this.l;
        if (jSONArray2 != null && jSONArray2.length() > 0) {
            this.f23529h = 0;
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
        this.f23530i = 0;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_input);
        relativeLayout.setVisibility(0);
        this.f23523b.setHint(this.j);
        this.f23523b.clearFocus();
        this.f23523b.setFocusable(false);
        relativeLayout.setBackgroundResource(R.drawable.dialog_checkbox_bg_normal);
        this.f23523b.setOnClickListener(this);
        this.f23523b.addTextChangedListener(this);
        this.f23523b.setOnFocusChangeListener(new ew(this, relativeLayout));
        if (this.k == 0) {
            this.f23524c.setBackgroundResource(R.drawable.dialog_btn_selector);
            this.f23524c.setTextColor(-1);
            this.f23524c.setClickable(true);
        }
    }

    public static void a(CheckBox checkBox) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, checkBox) == null) || checkBox == null) {
            return;
        }
        checkBox.setChecked(false);
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
        hashMap.put("uid", com.baidu.ufosdk.b.f23175d);
        hashMap.put("username", com.baidu.ufosdk.b.f23173b);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f23175d);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        hashMap.put("extra", com.baidu.ufosdk.b.f23177f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.j));
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put("id", evVar.f23525d);
        if (str != null) {
            hashMap.put("discontent_reason", str);
        }
        if (jSONArray != null) {
            hashMap.put("discontent_labels", jSONArray.toString());
        }
        hashMap.put("baiducuid", com.baidu.ufosdk.b.f23174c);
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
                        ((Map) evVar.o.get(evVar.f23526e)).put("discontent_reason", str);
                    }
                    if (jSONArray != null) {
                        ((Map) evVar.o.get(evVar.f23526e)).put("discontent_labels", jSONArray);
                    }
                }
            }
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("Evaluatioin error!", e2);
        }
        evVar.n.obtainMessage(11, Integer.valueOf(i2)).sendToTarget();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f23522a.setVisibility(0);
            this.f23522a.bringToFront();
            this.f23524c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
            this.f23524c.setTextColor(872415231);
            this.f23524c.setClickable(false);
            this.f23523b.clearFocus();
            this.f23523b.setFocusable(false);
            new Thread(new ex(this)).start();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m.clear();
            this.f23523b.setText("");
            a(this.p);
            a(this.q);
            a(this.r);
            a(this.s);
            a(this.t);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
            if (this.f23523b.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
                String substring = this.f23523b.getText().toString().substring(0, com.baidu.ufosdk.b.aa);
                this.f23523b.setText(substring);
                this.f23523b.setSelection(substring.length());
                Toast.makeText(this.f23528g, com.baidu.ufosdk.f.s.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
            }
            if (this.f23523b.getText().toString().trim().length() >= 4) {
                this.f23530i = 2;
            } else if (this.f23523b.getText().toString().trim().length() > 0) {
                this.f23530i = 1;
            } else {
                this.f23530i = 0;
            }
            if (this.k == 1) {
                if (this.f23530i == 2) {
                    this.f23524c.setBackgroundResource(R.drawable.dialog_btn_selector);
                    this.f23524c.setTextColor(-1);
                } else {
                    this.f23524c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                    this.f23524c.setTextColor(872415231);
                }
            }
            if (this.k == 3) {
                if (this.f23530i == 2 && this.f23529h == 1) {
                    this.f23524c.setBackgroundResource(R.drawable.dialog_btn_selector);
                    this.f23524c.setTextColor(-1);
                    return;
                }
                this.f23524c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                this.f23524c.setTextColor(872415231);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, compoundButton, z) == null) {
            if (z) {
                this.m.add(compoundButton.getText().toString());
            } else {
                this.m.remove(compoundButton.getText().toString());
            }
            if (this.m.size() > 0) {
                this.f23529h = 1;
            } else {
                this.f23529h = 0;
            }
            if (this.k == 2) {
                if (this.f23529h == 1) {
                    this.f23524c.setBackgroundResource(R.drawable.dialog_btn_selector);
                    this.f23524c.setTextColor(-1);
                } else {
                    this.f23524c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                    this.f23524c.setTextColor(872415231);
                }
            }
            if (this.k == 3) {
                if (this.f23529h == 1 && this.f23530i == 2) {
                    this.f23524c.setBackgroundResource(R.drawable.dialog_btn_selector);
                    this.f23524c.setTextColor(-1);
                    return;
                }
                this.f23524c.setBackgroundResource(R.drawable.dialog_btn_bg_normal);
                this.f23524c.setTextColor(872415231);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bf, code lost:
        if (r7 == 2) goto L33;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        Context context;
        Context context2;
        Toast makeText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getId() == R.id.btn_dialog_close) {
                dismiss();
            }
            if (view.getId() == R.id.header_transparent) {
                dismiss();
            }
            if (view.getId() != R.id.et_input) {
                this.f23523b.clearFocus();
                this.f23523b.setFocusable(false);
            } else {
                this.n.obtainMessage(18, "focus true").sendToTarget();
                this.f23523b.setFocusable(true);
                this.f23523b.setFocusableInTouchMode(true);
                this.f23523b.requestFocus();
            }
            if (view.getId() == R.id.btn_sumbit_evaluate) {
                int i2 = this.f23529h;
                String str = "无反馈内容，无法提交哦~";
                if (i2 == -1) {
                    int i3 = this.f23530i;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                b();
                                return;
                            }
                            context2 = this.f23528g;
                            makeText = Toast.makeText(context2, str, 0);
                        }
                        makeText = Toast.makeText(this.f23528g, "评价内容过少，无法提交哦~", 0);
                    }
                    makeText = Toast.makeText(this.f23528g, "未输入评论，无法提交哦~", 0);
                } else {
                    int i4 = this.f23530i;
                    if (i4 == -1) {
                        if (i2 != 0) {
                            if (i2 == 1) {
                                b();
                                return;
                            }
                            context2 = this.f23528g;
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
                                        makeText = Toast.makeText(this.f23528g, "未输入评论，无法提交哦~", 0);
                                    } else {
                                        context = this.f23528g;
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
                                makeText = Toast.makeText(this.f23528g, "评价内容过少，无法提交哦~", 0);
                            } else {
                                if (i4 != 0) {
                                    if (i4 != 1) {
                                        if (i4 == 2) {
                                            b();
                                            return;
                                        }
                                        return;
                                    }
                                    makeText = Toast.makeText(this.f23528g, "评价内容过少，无法提交哦~", 0);
                                }
                                makeText = Toast.makeText(this.f23528g, "未输入评论，无法提交哦~", 0);
                            }
                        } else if (i4 == 1) {
                            context2 = this.f23528g;
                            str = "评论内容过少，无法提交哦~";
                            makeText = Toast.makeText(context2, str, 0);
                        } else if (i2 != 0 || i4 != 0) {
                            b();
                            return;
                        } else {
                            context = this.f23528g;
                        }
                        makeText = Toast.makeText(context, "尚未选择标签或评论，无法提交哦~", 0);
                    }
                    context = this.f23528g;
                    makeText = Toast.makeText(context, "未选择标签，无法提交哦~", 0);
                }
                makeText.show();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dialogInterface) == null) && this.f23527f) {
            this.n.obtainMessage(17).sendToTarget();
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, charSequence, i2, i3, i4) == null) {
        }
    }
}
