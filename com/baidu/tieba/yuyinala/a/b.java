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
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private int aPb;
    private int aPc;
    private int aPe;
    private long aPj;
    private int aPk;
    private Activity activity;
    private int dTc;
    private View gOA;
    private long gOC;
    private int gOD;
    private int gOE;
    private List<cl.a> gOF;
    private long gOH;
    private String gOI;
    private String gOJ;
    private boolean gOM;
    private boolean gON;
    private int gOO;
    private int gOP;
    private int gOR;
    private int gOS;
    private float gOT;
    private boolean gOU;
    private int gOW;
    private boolean gOX;
    private View gOg;
    private View gOh;
    private TextView gOi;
    private EditText gOj;
    private EditText gOk;
    private TextView gOl;
    private TextView gOm;
    private LinearLayout gOn;
    private LinearLayout gOo;
    private LinearLayout gOp;
    private TextView gOq;
    private TextView gOr;
    private ImageView gOs;
    private ImageView gOt;
    private TextView gOu;
    private TextView gOv;
    private RelativeLayout gOw;
    private LinearLayout gOx;
    private LinearLayout gOy;
    private ScrollView gOz;
    private a ogW;
    private int screenWidth;
    private int gOB = 2000;
    private long gOG = 2000;
    private boolean gOK = true;
    private boolean gOL = true;
    private int gOV = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.ogW = aVar;
        initView();
        initData();
        bTs();
        bTt();
        this.gOw.setVisibility(4);
        this.gOw.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.dTc = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.dTc) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.dTc;
                    b.this.dTc = i;
                }
                b.this.gOR = b.this.screenWidth;
                b.this.gOP = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                b.this.gOS = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.gOP * 2);
                b.this.gOT = (i2 * 1.0f) / b.this.gOw.getHeight();
                if (b.this.dTc > b.this.gOw.getHeight()) {
                    b.this.gOO = (b.this.dTc - b.this.gOw.getHeight()) / 2;
                }
                b.this.Ex();
                b.this.gOw.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gOg = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gOh = this.gOg.findViewById(a.f.iv_send_red_q);
        this.gOi = (TextView) this.gOg.findViewById(a.f.tv_red_broad_hint);
        this.gOj = (EditText) this.gOg.findViewById(a.f.edt_t_num);
        this.gOk = (EditText) this.gOg.findViewById(a.f.edt_pkt_num);
        this.gOl = (TextView) this.gOg.findViewById(a.f.tv_send_t_num_hint);
        this.gOm = (TextView) this.gOg.findViewById(a.f.tv_send_pkt_num_hint);
        this.gOn = (LinearLayout) this.gOg.findViewById(a.f.layout_red_pkt_condition);
        this.gOo = (LinearLayout) this.gOg.findViewById(a.f.layout_condition_first);
        this.gOp = (LinearLayout) this.gOg.findViewById(a.f.layout_condition_second);
        this.gOw = (RelativeLayout) this.gOg.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gOg.findViewById(a.f.layout_send_red);
        this.gOq = (TextView) this.gOg.findViewById(a.f.tv_condition_first);
        this.gOr = (TextView) this.gOg.findViewById(a.f.tv_condition_second);
        this.gOs = (ImageView) this.gOg.findViewById(a.f.iv_condition_first);
        this.gOt = (ImageView) this.gOg.findViewById(a.f.iv_condition_second);
        this.gOu = (TextView) this.gOg.findViewById(a.f.tv_send_pkt_submit);
        this.gOv = (TextView) this.gOg.findViewById(a.f.tv_send_pkt_time);
        this.gOx = (LinearLayout) this.gOg.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gOg.findViewById(a.f.layout_red_send_rule_content);
        this.gOy = (LinearLayout) this.gOg.findViewById(a.f.layout_rule_desc);
        this.gOz = (ScrollView) this.gOg.findViewById(a.f.layout_input_scroll);
        this.gOA = this.gOg.findViewById(a.f.layout_send_red_close);
        this.gOg.setOnClickListener(this);
        this.gOo.setOnClickListener(this);
        this.gOp.setOnClickListener(this);
        this.gOu.setOnClickListener(this);
        this.gOh.setOnClickListener(this);
        this.gOx.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gOA.setOnClickListener(this);
        ((ImageView) this.gOg.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cl.a aVar;
        cl.a aVar2 = null;
        if (com.baidu.live.af.a.OJ() == null || com.baidu.live.af.a.OJ().bxp == null || com.baidu.live.af.a.OJ().bxp.aMO == null || com.baidu.live.af.a.OJ().bxp.aMO.aOt == null) {
            strArr = null;
            str = null;
        } else {
            cl clVar = com.baidu.live.af.a.OJ().bxp.aMO.aOt;
            if (clVar.aPh > 0) {
                this.gOG = clVar.aPh;
            }
            if (clVar.aPi > 0) {
                this.gOV = clVar.aPi;
            }
            this.gOH = this.gOV;
            this.gOC = clVar.aOZ;
            this.aPb = clVar.aPb;
            this.aPc = clVar.aPc;
            this.gOD = clVar.aPd;
            this.gOW = clVar.aPa;
            this.aPe = clVar.aPe;
            this.gOF = clVar.aPg;
            this.aPj = clVar.aPj;
            this.aPk = clVar.aPk;
            str = clVar.aPl;
            strArr = clVar.aPm;
            if (bTu()) {
                this.gOE = this.aPk;
            } else {
                this.gOE = this.gOW;
            }
        }
        this.gOj.setText(String.valueOf(this.gOG));
        this.gOk.setText(String.valueOf(this.gOH));
        this.gOj.setSelection(this.gOj.getText().toString().length());
        this.gOk.setSelection(this.gOk.getText().toString().length());
        TextView textView = this.gOi;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gOD));
        }
        textView.setText(str);
        this.gOv.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aPe)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aPe)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gOW))};
        }
        if (this.gOy != null) {
            this.gOy.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gOy.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gOy.addView(textView2, layoutParams);
            }
        }
        if (this.gOF != null && !this.gOF.isEmpty()) {
            if (this.gOF.size() == 1) {
                aVar = this.gOF.get(0);
            } else {
                aVar = this.gOF.get(0);
                aVar2 = this.gOF.get(1);
            }
            if (aVar == null) {
                this.gOo.setVisibility(8);
            } else {
                this.gOq.setText(aVar.aPn);
                this.gOo.setVisibility(0);
                this.gOI = aVar.aPo;
            }
            if (aVar2 == null) {
                this.gOp.setVisibility(8);
            } else {
                this.gOr.setText(aVar2.aPn);
                this.gOp.setVisibility(0);
                this.gOJ = aVar2.aPo;
            }
            if (this.gOo.getVisibility() == 0 || this.gOp.getVisibility() == 0) {
                this.gOn.setVisibility(0);
                return;
            } else {
                this.gOn.setVisibility(8);
                return;
            }
        }
        this.gOn.setVisibility(8);
    }

    private void bTs() {
        this.gOj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.mS(true)) {
                    b.this.mT(true);
                }
            }
        });
        this.gOk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.gOk.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.gOk.hasFocus()) {
                        b.this.gOX = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.gOk.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.gOH = parseLong;
                    if (parseLong >= b.this.aPb && parseLong <= b.this.aPc) {
                        b.this.gOm.setVisibility(8);
                        b.this.gOL = true;
                    } else {
                        b.this.gOm.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aPb), Integer.valueOf(b.this.aPc)));
                        b.this.gOm.setVisibility(0);
                        b.this.gOL = false;
                    }
                } else {
                    b.this.gOm.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aPb), Integer.valueOf(b.this.aPc)));
                    b.this.gOm.setVisibility(0);
                    b.this.gOH = 0L;
                    b.this.gOL = false;
                }
                b.this.gOk.setSelection(b.this.gOk.getText().toString().length());
                TextView textView = b.this.gOu;
                if (!b.this.gOK || !b.this.gOL) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.mS(false);
                b.this.mT(false);
            }
        });
    }

    private void bTt() {
        this.gOj.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gOj.setText("");
                    b.this.gOj.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gOj.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gOk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gOk.setText("");
                    b.this.gOk.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gOk.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mS(boolean z) {
        boolean z2 = true;
        this.gOE = this.gOW;
        String obj = this.gOj.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gOl.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gOB), Long.valueOf(this.gOC)));
            this.gOl.setVisibility(0);
            this.gOG = 0L;
            this.gOK = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gOj.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gOG != parseLong && this.gOG > this.gOC && parseLong > this.gOC) {
                this.gOj.setText(String.valueOf(this.gOG));
                return true;
            } else {
                boolean z3 = bTu() && parseLong < this.aPj;
                this.gOG = parseLong;
                if (bTu()) {
                    this.gOE = this.aPk;
                }
                if (parseLong < this.gOB || parseLong > this.gOC) {
                    if (parseLong == 0) {
                        this.gOj.setText("0");
                    }
                    this.gOl.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gOB), Long.valueOf(this.gOC)));
                    this.gOl.setVisibility(0);
                    this.gOK = false;
                } else {
                    if (z && this.gOk != null && bTv() && !this.gOk.hasFocus()) {
                        boolean z4 = !this.gOX;
                        if (!z4 && this.gOk.getText() != null) {
                            String obj2 = this.gOk.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bTu()) {
                                long j = this.gOG / this.aPk;
                                if (this.aPc > 0 && j > this.aPc) {
                                    j = this.aPc;
                                }
                                this.gOk.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gOk.setText(String.valueOf(this.gOV));
                            }
                        }
                    }
                    this.gOl.setVisibility(8);
                    this.gOK = true;
                }
            }
        }
        this.gOj.setSelection(this.gOj.getText().toString().length());
        TextView textView = this.gOu;
        if (!this.gOK || !this.gOL) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(boolean z) {
        if (this.gOL && this.gOK && this.gOH != 0 && this.gOG / this.gOH < this.gOE) {
            this.gOl.setVisibility(0);
            if (z) {
                this.gOl.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gOH * this.gOE)));
            } else {
                this.gOl.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gOG / this.gOE)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gOx.getVisibility() == 0) {
            this.gOx.setVisibility(8);
            return;
        }
        if (view == this.gOA && !this.gOU) {
            this.activity.finish();
        } else if (view == this.gOg && !this.gOU) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gOh) {
            this.gOx.setVisibility(0);
        } else if (view == this.gOo) {
            this.gOM = this.gOM ? false : true;
            if (this.gOM) {
                this.gOs.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gOs.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gOp) {
            this.gON = this.gON ? false : true;
            if (this.gON) {
                this.gOt.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gOt.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gOu) {
            if (this.gOM && this.gON) {
                str = this.gOI + "," + this.gOJ;
            } else if (this.gOM) {
                str = this.gOI;
            } else if (this.gON) {
                str = this.gOJ;
            } else {
                str = "";
            }
            h hVar = new h();
            hVar.fi(this.gOG);
            hVar.fj(this.gOH);
            hVar.Gd(str);
            if (this.ogW != null) {
                this.ogW.a(hVar);
            }
        }
        if (this.gOU && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void mU(boolean z) {
        if (this.gOu != null) {
            this.gOu.setEnabled(z);
        }
    }

    public View getView() {
        return this.gOg;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gOU = z;
        if (!z) {
            if (this.gOk != null) {
                this.gOk.clearFocus();
            }
            if (this.gOj != null) {
                this.gOj.clearFocus();
            }
        }
        if (this.gOw != null && this.gOw.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gOw.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gOO;
                }
            } else {
                layoutParams.topMargin = this.gOP;
            }
            this.gOw.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gOA.setVisibility(0);
        } else {
            this.gOA.setVisibility(8);
        }
    }

    public void Ex() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gOg);
        } else {
            i.af(this.gOg);
        }
        if (this.gOz != null && this.gOz.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gOz.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gOS;
            } else {
                layoutParams.height = -2;
            }
            this.gOz.setLayoutParams(layoutParams);
        }
        if (this.gOw != null && this.gOw.getLayoutParams() != null && this.gOR > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gOw.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gOw.setPivotX(this.gOR / 2);
            this.gOw.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gOw.setScaleX(this.gOT);
                this.gOw.setScaleY(this.gOT);
            } else {
                layoutParams2.width = -1;
                this.gOw.setScaleX(1.0f);
                this.gOw.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gOU);
        }
    }

    private boolean bTu() {
        return bTv() && this.gOG >= this.aPj && this.gOG <= this.gOC;
    }

    private boolean bTv() {
        return this.aPj >= ((long) this.gOB) && this.aPk > 0;
    }
}
