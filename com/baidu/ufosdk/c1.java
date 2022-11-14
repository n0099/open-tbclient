package com.baidu.ufosdk;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c1 extends Dialog implements View.OnClickListener, DialogInterface.OnDismissListener, CompoundButton.OnCheckedChangeListener, TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public int c;
    public String d;
    public int e;
    public JSONArray f;
    public ArrayList<String> g;
    public Handler h;
    public List<Map<String, Object>> i;
    public View j;
    public EditText k;
    public Button l;
    public String m;
    public String n;
    public int o;
    public boolean p;
    public CheckBox q;
    public CheckBox r;
    public CheckBox s;
    public CheckBox t;
    public CheckBox u;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, charSequence, i, i2, i3) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, i, i2, i3) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeLayout a;

        public a(c1 c1Var, RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1Var, relativeLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = relativeLayout;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z) {
                    this.a.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_edit_bg_selected);
                } else {
                    this.a.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_checkbox_bg_normal);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c1 a;

        public b(c1 c1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            JSONArray jSONArray;
            String str2;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c1 c1Var = this.a;
                if (c1Var.c != -1) {
                    str = c1Var.k.getText().toString().trim();
                } else {
                    str = null;
                }
                if (this.a.b != -1) {
                    jSONArray = new JSONArray((Collection) this.a.g);
                } else {
                    jSONArray = null;
                }
                c1 c1Var2 = this.a;
                if (c1Var2 != null) {
                    String str3 = s1.l;
                    String str4 = "getEvaluateConfig url: " + str3;
                    HashMap hashMap = new HashMap();
                    e0 a = e0.a(c1Var2.a);
                    hashMap.put("clientid", a.a);
                    if (TextUtils.isEmpty(c1Var2.n)) {
                        str2 = a.b;
                    } else {
                        str2 = c1Var2.n;
                    }
                    hashMap.put("appid", str2);
                    hashMap.put("devid", a.c);
                    hashMap.put(Constants.PHONE_BRAND, "");
                    hashMap.put("model", "");
                    hashMap.put("sdkvn", "4.1.9.1");
                    hashMap.put("os", "android");
                    hashMap.put("appvn", c.b());
                    hashMap.put("baiducuid", com.baidu.ufosdk.b.f());
                    hashMap.put("extra", com.baidu.ufosdk.b.g());
                    hashMap.put("uid", com.baidu.ufosdk.b.c());
                    hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.c());
                    hashMap.put("username", com.baidu.ufosdk.b.b());
                    hashMap.put("extend_feedback_channel", com.baidu.ufosdk.b.h());
                    hashMap.put("osvn", "");
                    hashMap.put("id", c1Var2.m);
                    if (str != null) {
                        hashMap.put("discontent_reason", str);
                    }
                    if (jSONArray != null) {
                        hashMap.put("discontent_labels", jSONArray.toString());
                    }
                    String b = com.baidu.ufosdk.b.b(com.baidu.ufosdk.b.a(hashMap));
                    int i = 1;
                    try {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("sdk_encrypt", b);
                        String a2 = d0.a(str3, d0.a(hashMap2));
                        if (!TextUtils.isEmpty(a2)) {
                            String str5 = "submit response is -----------------> " + jSONObject.toString();
                            i = new JSONObject(com.baidu.ufosdk.b.a(a2)).optInt("errno", 1);
                            if (i == 0) {
                                if (str != null) {
                                    c1Var2.i.get(c1Var2.o).put("discontent_reason", str);
                                }
                                if (jSONArray != null) {
                                    c1Var2.i.get(c1Var2.o).put("discontent_labels", jSONArray);
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                    c1Var2.h.obtainMessage(11, Integer.valueOf(i)).sendToTarget();
                    return;
                }
                throw null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(Context context, int i, JSONArray jSONArray, int i2, String str, Handler handler, List<Map<String, Object>> list) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), jSONArray, Integer.valueOf(i2), str, handler, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.c = -1;
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = new ArrayList<>();
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.a = context;
        this.f = jSONArray;
        this.e = i2;
        this.d = str;
        this.h = handler;
        this.i = list;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            setOnDismissListener(this);
            Window window = getWindow();
            window.setGravity(80);
            window.setWindowAnimations(com.baidu.tieba.R.style.obfuscated_res_0x7f100421);
            View inflate = View.inflate(this.a, com.baidu.tieba.R.layout.ufo_evaluate_dialog, null);
            inflate.findViewById(com.baidu.tieba.R.id.btn_dialog_close).setOnClickListener(this);
            inflate.findViewById(com.baidu.tieba.R.id.header_transparent).setOnClickListener(this);
            window.setContentView(inflate);
            this.j = p1.c(this.a, t1.a("25"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.j.setVisibility(8);
            ((RelativeLayout) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091cb7)).addView(this.j, layoutParams);
            window.setLayout(-1, -2);
            Button button = (Button) inflate.findViewById(com.baidu.tieba.R.id.btn_sumbit_evaluate);
            this.l = button;
            button.setOnClickListener(this);
            EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.R.id.et_input);
            this.k = editText;
            editText.setOnClickListener(this);
            JSONArray jSONArray = this.f;
            if (jSONArray != null && jSONArray.length() > 0) {
                this.b = 0;
                inflate.findViewById(com.baidu.tieba.R.id.ll_checkboxs).setVisibility(0);
                int length = this.f.length();
                if (length != 1) {
                    if (length != 2) {
                        if (length != 3) {
                            if (length != 4) {
                                if (length == 5) {
                                    inflate.findViewById(com.baidu.tieba.R.id.ll_checkboxs_3).setVisibility(0);
                                    CheckBox checkBox = (CheckBox) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0905ce);
                                    this.u = checkBox;
                                    checkBox.setVisibility(0);
                                    this.u.setText(this.f.optString(4));
                                    this.u.setOnCheckedChangeListener(this);
                                    this.u.setOnClickListener(this);
                                }
                            } else {
                                inflate.findViewById(com.baidu.tieba.R.id.ll_checkboxs_2).setVisibility(0);
                                CheckBox checkBox2 = (CheckBox) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0905cd);
                                this.t = checkBox2;
                                checkBox2.setVisibility(0);
                                this.t.setText(this.f.optString(3));
                                this.t.setOnCheckedChangeListener(this);
                                this.t.setOnClickListener(this);
                            }
                        } else {
                            inflate.findViewById(com.baidu.tieba.R.id.ll_checkboxs_2).setVisibility(0);
                            CheckBox checkBox3 = (CheckBox) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0905cc);
                            this.s = checkBox3;
                            checkBox3.setVisibility(0);
                            this.s.setText(this.f.optString(2));
                            this.s.setOnCheckedChangeListener(this);
                            this.s.setOnClickListener(this);
                        }
                    } else {
                        inflate.findViewById(com.baidu.tieba.R.id.ll_checkboxs_1).setVisibility(0);
                        CheckBox checkBox4 = (CheckBox) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0905cb);
                        this.r = checkBox4;
                        checkBox4.setVisibility(0);
                        this.r.setText(this.f.optString(1));
                        this.r.setOnCheckedChangeListener(this);
                        this.r.setOnClickListener(this);
                    }
                } else {
                    inflate.findViewById(com.baidu.tieba.R.id.ll_checkboxs_1).setVisibility(0);
                    CheckBox checkBox5 = (CheckBox) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0905ca);
                    this.q = checkBox5;
                    checkBox5.setVisibility(0);
                    this.q.setText(this.f.optString(0));
                    this.q.setOnCheckedChangeListener(this);
                    this.q.setOnClickListener(this);
                }
            }
            if (!TextUtils.isEmpty(this.d)) {
                this.c = 0;
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(com.baidu.tieba.R.id.rl_input);
                relativeLayout.setVisibility(0);
                this.k.setHint(this.d);
                this.k.clearFocus();
                this.k.setFocusable(false);
                relativeLayout.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_checkbox_bg_normal);
                this.k.setOnClickListener(this);
                this.k.addTextChangedListener(this);
                this.k.setOnFocusChangeListener(new a(this, relativeLayout));
                if (this.e == 0) {
                    this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_selector);
                    this.l.setTextColor(-1);
                    this.l.setClickable(true);
                }
            }
        }
    }

    public final void a(CheckBox checkBox) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, checkBox) == null) && checkBox != null) {
            checkBox.setChecked(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, dialogInterface) == null) && this.p) {
            this.h.obtainMessage(17).sendToTarget();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, editable) == null) {
            if (this.k.getText().toString().trim().length() > 200) {
                String substring = this.k.getText().toString().substring(0, 200);
                this.k.setText(substring);
                this.k.setSelection(substring.length());
                Toast.makeText(this.a, t1.a("16"), 0).show();
            }
            if (this.k.getText().toString().trim().length() >= 4) {
                this.c = 2;
            } else if (this.k.getText().toString().trim().length() > 0) {
                this.c = 1;
            } else {
                this.c = 0;
            }
            if (this.e == 1) {
                if (this.c == 2) {
                    this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_selector);
                    this.l.setTextColor(-1);
                } else {
                    this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_bg_normal);
                    this.l.setTextColor(872415231);
                }
            }
            if (this.e == 3) {
                if (this.c == 2 && this.b == 1) {
                    this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_selector);
                    this.l.setTextColor(-1);
                    return;
                }
                this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_bg_normal);
                this.l.setTextColor(872415231);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.setVisibility(0);
            this.j.bringToFront();
            this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_bg_normal);
            this.l.setTextColor(872415231);
            this.l.setClickable(false);
            this.k.clearFocus();
            this.k.setFocusable(false);
            new Thread(new b(this)).start();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, compoundButton, z) == null) {
            if (z) {
                this.g.add(compoundButton.getText().toString());
            } else {
                this.g.remove(compoundButton.getText().toString());
            }
            if (this.g.size() > 0) {
                this.b = 1;
            } else {
                this.b = 0;
            }
            if (this.e == 2) {
                if (this.b == 1) {
                    this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_selector);
                    this.l.setTextColor(-1);
                } else {
                    this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_bg_normal);
                    this.l.setTextColor(872415231);
                }
            }
            if (this.e == 3) {
                if (this.b == 1 && this.c == 2) {
                    this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_selector);
                    this.l.setTextColor(-1);
                    return;
                }
                this.l.setBackgroundResource(com.baidu.tieba.R.drawable.dialog_btn_bg_normal);
                this.l.setTextColor(872415231);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2.getId() == com.baidu.tieba.R.id.btn_dialog_close) {
                dismiss();
            }
            if (view2.getId() == com.baidu.tieba.R.id.header_transparent) {
                dismiss();
            }
            if (view2.getId() != com.baidu.tieba.R.id.et_input) {
                this.k.clearFocus();
                this.k.setFocusable(false);
            } else {
                this.h.obtainMessage(18, "focus true").sendToTarget();
                this.k.setFocusable(true);
                this.k.setFocusableInTouchMode(true);
                this.k.requestFocus();
            }
            if (view2.getId() == com.baidu.tieba.R.id.btn_sumbit_evaluate) {
                int i = this.b;
                if (i == -1) {
                    int i2 = this.c;
                    if (i2 == 0) {
                        Toast.makeText(this.a, "未输入评论，无法提交哦~", 0).show();
                        return;
                    } else if (i2 == 1) {
                        Toast.makeText(this.a, "评价内容过少，无法提交哦~", 0).show();
                        return;
                    } else if (i2 == 2) {
                        b();
                        return;
                    } else {
                        Toast.makeText(this.a, "无反馈内容，无法提交哦~", 0).show();
                        return;
                    }
                }
                int i3 = this.c;
                if (i3 == -1) {
                    if (i == 0) {
                        Toast.makeText(this.a, "未选择标签，无法提交哦~", 0).show();
                    } else if (i == 1) {
                        b();
                    } else {
                        Toast.makeText(this.a, "无反馈内容，无法提交哦~", 0).show();
                    }
                } else if (i != -1 && i3 != -1) {
                    int i4 = this.e;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                if (i4 == 3) {
                                    if (i == 1) {
                                        if (i3 == 0) {
                                            Toast.makeText(this.a, "未输入评论，无法提交哦~", 0).show();
                                        } else if (i3 == 1) {
                                            Toast.makeText(this.a, "评价内容过少，无法提交哦~", 0).show();
                                        } else if (i3 == 2) {
                                            b();
                                        }
                                    } else if (i3 == 2) {
                                        Toast.makeText(this.a, "未选择标签，无法提交哦~", 0).show();
                                    } else {
                                        Toast.makeText(this.a, "尚未选择标签或评论，无法提交哦~", 0).show();
                                    }
                                }
                            } else if (i == 0) {
                                Toast.makeText(this.a, "未选择标签，无法提交哦~", 0).show();
                            } else if (i3 == 1) {
                                Toast.makeText(this.a, "评价内容过少，无法提交哦~", 0).show();
                            } else if (i == 1) {
                                b();
                            }
                        } else if (i3 == 0) {
                            Toast.makeText(this.a, "未输入评论，无法提交哦~", 0).show();
                        } else if (i3 == 1) {
                            Toast.makeText(this.a, "评价内容过少，无法提交哦~", 0).show();
                        } else if (i3 == 2) {
                            b();
                        }
                    } else if (i3 == 1) {
                        Toast.makeText(this.a, "评论内容过少，无法提交哦~", 0).show();
                    } else if (i == 0 && i3 == 0) {
                        Toast.makeText(this.a, "尚未选择标签或评论，无法提交哦~", 0).show();
                    } else {
                        b();
                    }
                }
            }
        }
    }
}
