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
import com.baidu.live.data.ch;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.yuyinala.data.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private int aRA;
    private int aRC;
    private long aRH;
    private int aRI;
    private int aRz;
    private Activity activity;
    private int dJG;
    private TextView gyA;
    private TextView gyB;
    private LinearLayout gyC;
    private LinearLayout gyD;
    private LinearLayout gyE;
    private TextView gyF;
    private TextView gyG;
    private ImageView gyH;
    private ImageView gyI;
    private TextView gyJ;
    private TextView gyK;
    private RelativeLayout gyL;
    private LinearLayout gyM;
    private LinearLayout gyN;
    private ScrollView gyO;
    private View gyP;
    private long gyR;
    private int gyS;
    private int gyT;
    private List<ch.a> gyU;
    private long gyW;
    private String gyX;
    private String gyY;
    private View gyv;
    private View gyw;
    private TextView gyx;
    private EditText gyy;
    private EditText gyz;
    private boolean gzb;
    private boolean gzc;
    private int gzd;
    private int gze;
    private int gzg;
    private int gzh;
    private float gzi;
    private boolean gzj;
    private int gzl;
    private boolean gzm;
    private a nTk;
    private int screenWidth;
    private int gyQ = 2000;
    private long gyV = 2000;
    private boolean gyZ = true;
    private boolean gza = true;
    private int gzk = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.nTk = aVar;
        initView();
        initData();
        bRB();
        bRC();
        this.gyL.setVisibility(4);
        this.gyL.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.dJG = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.dJG) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.dJG;
                    b.this.dJG = i;
                }
                b.this.gzg = b.this.screenWidth;
                b.this.gze = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                b.this.gzh = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.gze * 2);
                b.this.gzi = (i2 * 1.0f) / b.this.gyL.getHeight();
                if (b.this.dJG > b.this.gyL.getHeight()) {
                    b.this.gzd = (b.this.dJG - b.this.gyL.getHeight()) / 2;
                }
                b.this.HJ();
                b.this.gyL.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gyv = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gyw = this.gyv.findViewById(a.f.iv_send_red_q);
        this.gyx = (TextView) this.gyv.findViewById(a.f.tv_red_broad_hint);
        this.gyy = (EditText) this.gyv.findViewById(a.f.edt_t_num);
        this.gyz = (EditText) this.gyv.findViewById(a.f.edt_pkt_num);
        this.gyA = (TextView) this.gyv.findViewById(a.f.tv_send_t_num_hint);
        this.gyB = (TextView) this.gyv.findViewById(a.f.tv_send_pkt_num_hint);
        this.gyC = (LinearLayout) this.gyv.findViewById(a.f.layout_red_pkt_condition);
        this.gyD = (LinearLayout) this.gyv.findViewById(a.f.layout_condition_first);
        this.gyE = (LinearLayout) this.gyv.findViewById(a.f.layout_condition_second);
        this.gyL = (RelativeLayout) this.gyv.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gyv.findViewById(a.f.layout_send_red);
        this.gyF = (TextView) this.gyv.findViewById(a.f.tv_condition_first);
        this.gyG = (TextView) this.gyv.findViewById(a.f.tv_condition_second);
        this.gyH = (ImageView) this.gyv.findViewById(a.f.iv_condition_first);
        this.gyI = (ImageView) this.gyv.findViewById(a.f.iv_condition_second);
        this.gyJ = (TextView) this.gyv.findViewById(a.f.tv_send_pkt_submit);
        this.gyK = (TextView) this.gyv.findViewById(a.f.tv_send_pkt_time);
        this.gyM = (LinearLayout) this.gyv.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gyv.findViewById(a.f.layout_red_send_rule_content);
        this.gyN = (LinearLayout) this.gyv.findViewById(a.f.layout_rule_desc);
        this.gyO = (ScrollView) this.gyv.findViewById(a.f.layout_input_scroll);
        this.gyP = this.gyv.findViewById(a.f.layout_send_red_close);
        this.gyv.setOnClickListener(this);
        this.gyD.setOnClickListener(this);
        this.gyE.setOnClickListener(this);
        this.gyJ.setOnClickListener(this);
        this.gyw.setOnClickListener(this);
        this.gyM.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gyP.setOnClickListener(this);
        ((ImageView) this.gyv.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        ch.a aVar;
        ch.a aVar2 = null;
        if (com.baidu.live.aa.a.PQ() == null || com.baidu.live.aa.a.PQ().btT == null || com.baidu.live.aa.a.PQ().btT.aPx == null || com.baidu.live.aa.a.PQ().btT.aPx.aQU == null) {
            strArr = null;
            str = null;
        } else {
            ch chVar = com.baidu.live.aa.a.PQ().btT.aPx.aQU;
            if (chVar.aRF > 0) {
                this.gyV = chVar.aRF;
            }
            if (chVar.aRG > 0) {
                this.gzk = chVar.aRG;
            }
            this.gyW = this.gzk;
            this.gyR = chVar.aRx;
            this.aRz = chVar.aRz;
            this.aRA = chVar.aRA;
            this.gyS = chVar.aRB;
            this.gzl = chVar.aRy;
            this.aRC = chVar.aRC;
            this.gyU = chVar.aRE;
            this.aRH = chVar.aRH;
            this.aRI = chVar.aRI;
            str = chVar.aRJ;
            strArr = chVar.aRK;
            if (bRD()) {
                this.gyT = this.aRI;
            } else {
                this.gyT = this.gzl;
            }
        }
        this.gyy.setText(String.valueOf(this.gyV));
        this.gyz.setText(String.valueOf(this.gyW));
        this.gyy.setSelection(this.gyy.getText().toString().length());
        this.gyz.setSelection(this.gyz.getText().toString().length());
        TextView textView = this.gyx;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gyS));
        }
        textView.setText(str);
        this.gyK.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aRC)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aRC)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gzl))};
        }
        if (this.gyN != null) {
            this.gyN.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gyN.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gyN.addView(textView2, layoutParams);
            }
        }
        if (this.gyU != null && !this.gyU.isEmpty()) {
            if (this.gyU.size() == 1) {
                aVar = this.gyU.get(0);
            } else {
                aVar = this.gyU.get(0);
                aVar2 = this.gyU.get(1);
            }
            if (aVar == null) {
                this.gyD.setVisibility(8);
            } else {
                this.gyF.setText(aVar.aRL);
                this.gyD.setVisibility(0);
                this.gyX = aVar.aRM;
            }
            if (aVar2 == null) {
                this.gyE.setVisibility(8);
            } else {
                this.gyG.setText(aVar2.aRL);
                this.gyE.setVisibility(0);
                this.gyY = aVar2.aRM;
            }
            if (this.gyD.getVisibility() == 0 || this.gyE.getVisibility() == 0) {
                this.gyC.setVisibility(0);
                return;
            } else {
                this.gyC.setVisibility(8);
                return;
            }
        }
        this.gyC.setVisibility(8);
    }

    private void bRB() {
        this.gyy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.ma(true)) {
                    b.this.mb(true);
                }
            }
        });
        this.gyz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.gyz.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.gyz.hasFocus()) {
                        b.this.gzm = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.gyz.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.gyW = parseLong;
                    if (parseLong >= b.this.aRz && parseLong <= b.this.aRA) {
                        b.this.gyB.setVisibility(8);
                        b.this.gza = true;
                    } else {
                        b.this.gyB.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aRz), Integer.valueOf(b.this.aRA)));
                        b.this.gyB.setVisibility(0);
                        b.this.gza = false;
                    }
                } else {
                    b.this.gyB.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aRz), Integer.valueOf(b.this.aRA)));
                    b.this.gyB.setVisibility(0);
                    b.this.gyW = 0L;
                    b.this.gza = false;
                }
                b.this.gyz.setSelection(b.this.gyz.getText().toString().length());
                TextView textView = b.this.gyJ;
                if (!b.this.gyZ || !b.this.gza) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.ma(false);
                b.this.mb(false);
            }
        });
    }

    private void bRC() {
        this.gyy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gyy.setText("");
                    b.this.gyy.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gyy.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gyz.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gyz.setText("");
                    b.this.gyz.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gyz.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ma(boolean z) {
        boolean z2 = true;
        this.gyT = this.gzl;
        String obj = this.gyy.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gyA.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gyQ), Long.valueOf(this.gyR)));
            this.gyA.setVisibility(0);
            this.gyV = 0L;
            this.gyZ = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gyy.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gyV != parseLong && this.gyV > this.gyR && parseLong > this.gyR) {
                this.gyy.setText(String.valueOf(this.gyV));
                return true;
            } else {
                boolean z3 = bRD() && parseLong < this.aRH;
                this.gyV = parseLong;
                if (bRD()) {
                    this.gyT = this.aRI;
                }
                if (parseLong < this.gyQ || parseLong > this.gyR) {
                    if (parseLong == 0) {
                        this.gyy.setText("0");
                    }
                    this.gyA.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gyQ), Long.valueOf(this.gyR)));
                    this.gyA.setVisibility(0);
                    this.gyZ = false;
                } else {
                    if (z && this.gyz != null && bRE() && !this.gyz.hasFocus()) {
                        boolean z4 = !this.gzm;
                        if (!z4 && this.gyz.getText() != null) {
                            String obj2 = this.gyz.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bRD()) {
                                long j = this.gyV / this.aRI;
                                if (this.aRA > 0 && j > this.aRA) {
                                    j = this.aRA;
                                }
                                this.gyz.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gyz.setText(String.valueOf(this.gzk));
                            }
                        }
                    }
                    this.gyA.setVisibility(8);
                    this.gyZ = true;
                }
            }
        }
        this.gyy.setSelection(this.gyy.getText().toString().length());
        TextView textView = this.gyJ;
        if (!this.gyZ || !this.gza) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(boolean z) {
        if (this.gza && this.gyZ && this.gyW != 0 && this.gyV / this.gyW < this.gyT) {
            this.gyA.setVisibility(0);
            if (z) {
                this.gyA.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gyW * this.gyT)));
            } else {
                this.gyA.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gyV / this.gyT)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gyM.getVisibility() == 0) {
            this.gyM.setVisibility(8);
            return;
        }
        if (view == this.gyP && !this.gzj) {
            this.activity.finish();
        } else if (view == this.gyv && !this.gzj) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gyw) {
            this.gyM.setVisibility(0);
        } else if (view == this.gyD) {
            this.gzb = this.gzb ? false : true;
            if (this.gzb) {
                this.gyH.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gyH.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gyE) {
            this.gzc = this.gzc ? false : true;
            if (this.gzc) {
                this.gyI.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gyI.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gyJ) {
            if (this.gzb && this.gzc) {
                str = this.gyX + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gyY;
            } else if (this.gzb) {
                str = this.gyX;
            } else if (this.gzc) {
                str = this.gyY;
            } else {
                str = "";
            }
            h hVar = new h();
            hVar.eE(this.gyV);
            hVar.eF(this.gyW);
            hVar.Ha(str);
            if (this.nTk != null) {
                this.nTk.a(hVar);
            }
        }
        if (this.gzj && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void mc(boolean z) {
        if (this.gyJ != null) {
            this.gyJ.setEnabled(z);
        }
    }

    public View getView() {
        return this.gyv;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gzj = z;
        if (!z) {
            if (this.gyz != null) {
                this.gyz.clearFocus();
            }
            if (this.gyy != null) {
                this.gyy.clearFocus();
            }
        }
        if (this.gyL != null && this.gyL.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gyL.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gzd;
                }
            } else {
                layoutParams.topMargin = this.gze;
            }
            this.gyL.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gyP.setVisibility(0);
        } else {
            this.gyP.setVisibility(8);
        }
    }

    public void HJ() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gyv);
        } else {
            i.af(this.gyv);
        }
        if (this.gyO != null && this.gyO.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gyO.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gzh;
            } else {
                layoutParams.height = -2;
            }
            this.gyO.setLayoutParams(layoutParams);
        }
        if (this.gyL != null && this.gyL.getLayoutParams() != null && this.gzg > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gyL.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gyL.setPivotX(this.gzg / 2);
            this.gyL.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gyL.setScaleX(this.gzi);
                this.gyL.setScaleY(this.gzi);
            } else {
                layoutParams2.width = -1;
                this.gyL.setScaleX(1.0f);
                this.gyL.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gzj);
        }
    }

    private boolean bRD() {
        return bRE() && this.gyV >= this.aRH && this.gyV <= this.gyR;
    }

    private boolean bRE() {
        return this.aRH >= ((long) this.gyQ) && this.aRI > 0;
    }
}
