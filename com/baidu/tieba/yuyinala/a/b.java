package com.baidu.tieba.yuyinala.a;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.live.data.cl;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.yuyinala.data.h;
import java.util.List;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private int aTO;
    private int aTP;
    private int aTR;
    private long aTW;
    private int aTX;
    private Activity activity;
    private int dXO;
    private View gSM;
    private View gSN;
    private TextView gSO;
    private EditText gSP;
    private EditText gSQ;
    private TextView gSR;
    private TextView gSS;
    private LinearLayout gST;
    private LinearLayout gSU;
    private LinearLayout gSV;
    private TextView gSW;
    private TextView gSX;
    private ImageView gSY;
    private ImageView gSZ;
    private boolean gTA;
    private int gTC;
    private boolean gTD;
    private TextView gTa;
    private TextView gTb;
    private RelativeLayout gTc;
    private LinearLayout gTd;
    private LinearLayout gTe;
    private ScrollView gTf;
    private View gTg;
    private long gTi;
    private int gTj;
    private int gTk;
    private List<cl.a> gTl;
    private long gTn;
    private String gTo;
    private String gTp;
    private boolean gTs;
    private boolean gTt;
    private int gTu;
    private int gTv;
    private int gTx;
    private int gTy;
    private float gTz;
    private a olB;
    private int screenWidth;
    private int gTh = 2000;
    private long gTm = 2000;
    private boolean gTq = true;
    private boolean gTr = true;
    private int gTB = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.olB = aVar;
        initView();
        initData();
        bXj();
        bXk();
        this.gTc.setVisibility(4);
        this.gTc.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.dXO = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.dXO) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.dXO;
                    b.this.dXO = i;
                }
                b.this.gTx = b.this.screenWidth;
                b.this.gTv = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                b.this.gTy = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.gTv * 2);
                b.this.gTz = (i2 * 1.0f) / b.this.gTc.getHeight();
                if (b.this.dXO > b.this.gTc.getHeight()) {
                    b.this.gTu = (b.this.dXO - b.this.gTc.getHeight()) / 2;
                }
                b.this.Is();
                b.this.gTc.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gSM = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gSN = this.gSM.findViewById(a.f.iv_send_red_q);
        this.gSO = (TextView) this.gSM.findViewById(a.f.tv_red_broad_hint);
        this.gSP = (EditText) this.gSM.findViewById(a.f.edt_t_num);
        this.gSQ = (EditText) this.gSM.findViewById(a.f.edt_pkt_num);
        this.gSR = (TextView) this.gSM.findViewById(a.f.tv_send_t_num_hint);
        this.gSS = (TextView) this.gSM.findViewById(a.f.tv_send_pkt_num_hint);
        this.gST = (LinearLayout) this.gSM.findViewById(a.f.layout_red_pkt_condition);
        this.gSU = (LinearLayout) this.gSM.findViewById(a.f.layout_condition_first);
        this.gSV = (LinearLayout) this.gSM.findViewById(a.f.layout_condition_second);
        this.gTc = (RelativeLayout) this.gSM.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gSM.findViewById(a.f.layout_send_red);
        this.gSW = (TextView) this.gSM.findViewById(a.f.tv_condition_first);
        this.gSX = (TextView) this.gSM.findViewById(a.f.tv_condition_second);
        this.gSY = (ImageView) this.gSM.findViewById(a.f.iv_condition_first);
        this.gSZ = (ImageView) this.gSM.findViewById(a.f.iv_condition_second);
        this.gTa = (TextView) this.gSM.findViewById(a.f.tv_send_pkt_submit);
        this.gTb = (TextView) this.gSM.findViewById(a.f.tv_send_pkt_time);
        this.gTd = (LinearLayout) this.gSM.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gSM.findViewById(a.f.layout_red_send_rule_content);
        this.gTe = (LinearLayout) this.gSM.findViewById(a.f.layout_rule_desc);
        this.gTf = (ScrollView) this.gSM.findViewById(a.f.layout_input_scroll);
        this.gTg = this.gSM.findViewById(a.f.layout_send_red_close);
        this.gSM.setOnClickListener(this);
        this.gSU.setOnClickListener(this);
        this.gSV.setOnClickListener(this);
        this.gTa.setOnClickListener(this);
        this.gSN.setOnClickListener(this);
        this.gTd.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gTg.setOnClickListener(this);
        ((ImageView) this.gSM.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cl.a aVar;
        cl.a aVar2 = null;
        if (com.baidu.live.af.a.SE() == null || com.baidu.live.af.a.SE().bCb == null || com.baidu.live.af.a.SE().bCb.aRB == null || com.baidu.live.af.a.SE().bCb.aRB.aTg == null) {
            strArr = null;
            str = null;
        } else {
            cl clVar = com.baidu.live.af.a.SE().bCb.aRB.aTg;
            if (clVar.aTU > 0) {
                this.gTm = clVar.aTU;
            }
            if (clVar.aTV > 0) {
                this.gTB = clVar.aTV;
            }
            this.gTn = this.gTB;
            this.gTi = clVar.aTM;
            this.aTO = clVar.aTO;
            this.aTP = clVar.aTP;
            this.gTj = clVar.aTQ;
            this.gTC = clVar.aTN;
            this.aTR = clVar.aTR;
            this.gTl = clVar.aTT;
            this.aTW = clVar.aTW;
            this.aTX = clVar.aTX;
            str = clVar.aTY;
            strArr = clVar.aTZ;
            if (bXl()) {
                this.gTk = this.aTX;
            } else {
                this.gTk = this.gTC;
            }
        }
        this.gSP.setText(String.valueOf(this.gTm));
        this.gSQ.setText(String.valueOf(this.gTn));
        this.gSP.setSelection(this.gSP.getText().toString().length());
        this.gSQ.setSelection(this.gSQ.getText().toString().length());
        TextView textView = this.gSO;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gTj));
        }
        textView.setText(str);
        this.gTb.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aTR)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aTR)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gTC))};
        }
        if (this.gTe != null) {
            this.gTe.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gTe.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gTe.addView(textView2, layoutParams);
            }
        }
        if (this.gTl != null && !this.gTl.isEmpty()) {
            if (this.gTl.size() == 1) {
                aVar = this.gTl.get(0);
            } else {
                aVar = this.gTl.get(0);
                aVar2 = this.gTl.get(1);
            }
            if (aVar == null) {
                this.gSU.setVisibility(8);
            } else {
                this.gSW.setText(aVar.aUa);
                this.gSU.setVisibility(0);
                this.gTo = aVar.aUb;
            }
            if (aVar2 == null) {
                this.gSV.setVisibility(8);
            } else {
                this.gSX.setText(aVar2.aUa);
                this.gSV.setVisibility(0);
                this.gTp = aVar2.aUb;
            }
            if (this.gSU.getVisibility() == 0 || this.gSV.getVisibility() == 0) {
                this.gST.setVisibility(0);
                return;
            } else {
                this.gST.setVisibility(8);
                return;
            }
        }
        this.gST.setVisibility(8);
    }

    private void bXj() {
        this.gSP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.mW(true)) {
                    b.this.mX(true);
                }
            }
        });
        this.gSQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.gSQ.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.gSQ.hasFocus()) {
                        b.this.gTD = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.gSQ.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.gTn = parseLong;
                    if (parseLong >= b.this.aTO && parseLong <= b.this.aTP) {
                        b.this.gSS.setVisibility(8);
                        b.this.gTr = true;
                    } else {
                        b.this.gSS.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aTO), Integer.valueOf(b.this.aTP)));
                        b.this.gSS.setVisibility(0);
                        b.this.gTr = false;
                    }
                } else {
                    b.this.gSS.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aTO), Integer.valueOf(b.this.aTP)));
                    b.this.gSS.setVisibility(0);
                    b.this.gTn = 0L;
                    b.this.gTr = false;
                }
                b.this.gSQ.setSelection(b.this.gSQ.getText().toString().length());
                TextView textView = b.this.gTa;
                if (!b.this.gTq || !b.this.gTr) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.mW(false);
                b.this.mX(false);
            }
        });
    }

    private void bXk() {
        this.gSP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gSP.setText("");
                    b.this.gSP.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gSP.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gSQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gSQ.setText("");
                    b.this.gSQ.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gSQ.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mW(boolean z) {
        boolean z2 = true;
        this.gTk = this.gTC;
        String obj = this.gSP.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gSR.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gTh), Long.valueOf(this.gTi)));
            this.gSR.setVisibility(0);
            this.gTm = 0L;
            this.gTq = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gSP.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gTm != parseLong && this.gTm > this.gTi && parseLong > this.gTi) {
                this.gSP.setText(String.valueOf(this.gTm));
                return true;
            } else {
                boolean z3 = bXl() && parseLong < this.aTW;
                this.gTm = parseLong;
                if (bXl()) {
                    this.gTk = this.aTX;
                }
                if (parseLong < this.gTh || parseLong > this.gTi) {
                    if (parseLong == 0) {
                        this.gSP.setText("0");
                    }
                    this.gSR.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gTh), Long.valueOf(this.gTi)));
                    this.gSR.setVisibility(0);
                    this.gTq = false;
                } else {
                    if (z && this.gSQ != null && bXm() && !this.gSQ.hasFocus()) {
                        boolean z4 = !this.gTD;
                        if (!z4 && this.gSQ.getText() != null) {
                            String obj2 = this.gSQ.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bXl()) {
                                long j = this.gTm / this.aTX;
                                if (this.aTP > 0 && j > this.aTP) {
                                    j = this.aTP;
                                }
                                this.gSQ.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gSQ.setText(String.valueOf(this.gTB));
                            }
                        }
                    }
                    this.gSR.setVisibility(8);
                    this.gTq = true;
                }
            }
        }
        this.gSP.setSelection(this.gSP.getText().toString().length());
        TextView textView = this.gTa;
        if (!this.gTq || !this.gTr) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        if (this.gTr && this.gTq && this.gTn != 0 && this.gTm / this.gTn < this.gTk) {
            this.gSR.setVisibility(0);
            if (z) {
                this.gSR.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gTn * this.gTk)));
            } else {
                this.gSR.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gTm / this.gTk)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gTd.getVisibility() == 0) {
            this.gTd.setVisibility(8);
            return;
        }
        if (view == this.gTg && !this.gTA) {
            this.activity.finish();
        } else if (view == this.gSM && !this.gTA) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gSN) {
            this.gTd.setVisibility(0);
        } else if (view == this.gSU) {
            this.gTs = this.gTs ? false : true;
            if (this.gTs) {
                this.gSY.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gSY.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gSV) {
            this.gTt = this.gTt ? false : true;
            if (this.gTt) {
                this.gSZ.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gSZ.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gTa) {
            if (this.gTs && this.gTt) {
                str = this.gTo + "," + this.gTp;
            } else if (this.gTs) {
                str = this.gTo;
            } else if (this.gTt) {
                str = this.gTp;
            } else {
                str = "";
            }
            h hVar = new h();
            hVar.fi(this.gTm);
            hVar.fj(this.gTn);
            hVar.Hp(str);
            if (this.olB != null) {
                this.olB.a(hVar);
            }
        }
        if (this.gTA && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void mY(boolean z) {
        if (this.gTa != null) {
            this.gTa.setEnabled(z);
        }
    }

    public View getView() {
        return this.gSM;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gTA = z;
        if (!z) {
            if (this.gSQ != null) {
                this.gSQ.clearFocus();
            }
            if (this.gSP != null) {
                this.gSP.clearFocus();
            }
        }
        if (this.gTc != null && this.gTc.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTc.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gTu;
                }
            } else {
                layoutParams.topMargin = this.gTv;
            }
            this.gTc.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTg.setVisibility(0);
        } else {
            this.gTg.setVisibility(8);
        }
    }

    public void Is() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gSM);
        } else {
            i.af(this.gSM);
        }
        if (this.gTf != null && this.gTf.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTf.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gTy;
            } else {
                layoutParams.height = -2;
            }
            this.gTf.setLayoutParams(layoutParams);
        }
        if (this.gTc != null && this.gTc.getLayoutParams() != null && this.gTx > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gTc.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gTc.setPivotX(this.gTx / 2);
            this.gTc.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gTc.setScaleX(this.gTz);
                this.gTc.setScaleY(this.gTz);
            } else {
                layoutParams2.width = -1;
                this.gTc.setScaleX(1.0f);
                this.gTc.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gTA);
        }
    }

    private boolean bXl() {
        return bXm() && this.gTm >= this.aTW && this.gTm <= this.gTi;
    }

    private boolean bXm() {
        return this.aTW >= ((long) this.gTh) && this.aTX > 0;
    }
}
