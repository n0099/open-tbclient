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
import com.baidu.live.data.cs;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.yuyinala.data.h;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private int aTD;
    private int aTE;
    private int aTG;
    private long aTL;
    private int aTM;
    private Activity activity;
    private int dWJ;
    private View gSJ;
    private View gSK;
    private TextView gSL;
    private EditText gSM;
    private EditText gSN;
    private TextView gSO;
    private TextView gSP;
    private LinearLayout gSQ;
    private LinearLayout gSR;
    private LinearLayout gSS;
    private TextView gST;
    private TextView gSU;
    private ImageView gSV;
    private ImageView gSW;
    private TextView gSX;
    private TextView gSY;
    private RelativeLayout gSZ;
    private boolean gTA;
    private LinearLayout gTa;
    private LinearLayout gTb;
    private ScrollView gTc;
    private View gTd;
    private long gTf;
    private int gTg;
    private int gTh;
    private List<cs.a> gTi;
    private long gTk;
    private String gTl;
    private String gTm;
    private boolean gTp;
    private boolean gTq;
    private int gTr;
    private int gTs;
    private int gTu;
    private int gTv;
    private float gTw;
    private boolean gTx;
    private int gTz;
    private a otv;
    private int screenWidth;
    private int gTe = 2000;
    private long gTj = 2000;
    private boolean gTn = true;
    private boolean gTo = true;
    private int gTy = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.otv = aVar;
        initView();
        initData();
        bUj();
        bUk();
        this.gSZ.setVisibility(4);
        this.gSZ.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.dWJ = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.dWJ) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.dWJ;
                    b.this.dWJ = i;
                }
                b.this.gTu = b.this.screenWidth;
                b.this.gTs = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                b.this.gTv = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.gTs * 2);
                b.this.gTw = (i2 * 1.0f) / b.this.gSZ.getHeight();
                if (b.this.dWJ > b.this.gSZ.getHeight()) {
                    b.this.gTr = (b.this.dWJ - b.this.gSZ.getHeight()) / 2;
                }
                b.this.FQ();
                b.this.gSZ.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gSJ = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gSK = this.gSJ.findViewById(a.f.iv_send_red_q);
        this.gSL = (TextView) this.gSJ.findViewById(a.f.tv_red_broad_hint);
        this.gSM = (EditText) this.gSJ.findViewById(a.f.edt_t_num);
        this.gSN = (EditText) this.gSJ.findViewById(a.f.edt_pkt_num);
        this.gSO = (TextView) this.gSJ.findViewById(a.f.tv_send_t_num_hint);
        this.gSP = (TextView) this.gSJ.findViewById(a.f.tv_send_pkt_num_hint);
        this.gSQ = (LinearLayout) this.gSJ.findViewById(a.f.layout_red_pkt_condition);
        this.gSR = (LinearLayout) this.gSJ.findViewById(a.f.layout_condition_first);
        this.gSS = (LinearLayout) this.gSJ.findViewById(a.f.layout_condition_second);
        this.gSZ = (RelativeLayout) this.gSJ.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gSJ.findViewById(a.f.layout_send_red);
        this.gST = (TextView) this.gSJ.findViewById(a.f.tv_condition_first);
        this.gSU = (TextView) this.gSJ.findViewById(a.f.tv_condition_second);
        this.gSV = (ImageView) this.gSJ.findViewById(a.f.iv_condition_first);
        this.gSW = (ImageView) this.gSJ.findViewById(a.f.iv_condition_second);
        this.gSX = (TextView) this.gSJ.findViewById(a.f.tv_send_pkt_submit);
        this.gSY = (TextView) this.gSJ.findViewById(a.f.tv_send_pkt_time);
        this.gTa = (LinearLayout) this.gSJ.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gSJ.findViewById(a.f.layout_red_send_rule_content);
        this.gTb = (LinearLayout) this.gSJ.findViewById(a.f.layout_rule_desc);
        this.gTc = (ScrollView) this.gSJ.findViewById(a.f.layout_input_scroll);
        this.gTd = this.gSJ.findViewById(a.f.layout_send_red_close);
        this.gSJ.setOnClickListener(this);
        this.gSR.setOnClickListener(this);
        this.gSS.setOnClickListener(this);
        this.gSX.setOnClickListener(this);
        this.gSK.setOnClickListener(this);
        this.gTa.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gTd.setOnClickListener(this);
        ((ImageView) this.gSJ.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cs.a aVar;
        cs.a aVar2 = null;
        if (com.baidu.live.ae.a.Qm() == null || com.baidu.live.ae.a.Qm().bCs == null || com.baidu.live.ae.a.Qm().bCs.aRm == null || com.baidu.live.ae.a.Qm().bCs.aRm.aSV == null) {
            strArr = null;
            str = null;
        } else {
            cs csVar = com.baidu.live.ae.a.Qm().bCs.aRm.aSV;
            if (csVar.aTJ > 0) {
                this.gTj = csVar.aTJ;
            }
            if (csVar.aTK > 0) {
                this.gTy = csVar.aTK;
            }
            this.gTk = this.gTy;
            this.gTf = csVar.aTB;
            this.aTD = csVar.aTD;
            this.aTE = csVar.aTE;
            this.gTg = csVar.aTF;
            this.gTz = csVar.aTC;
            this.aTG = csVar.aTG;
            this.gTi = csVar.aTI;
            this.aTL = csVar.aTL;
            this.aTM = csVar.aTM;
            str = csVar.aTN;
            strArr = csVar.aTO;
            if (bUl()) {
                this.gTh = this.aTM;
            } else {
                this.gTh = this.gTz;
            }
        }
        this.gSM.setText(String.valueOf(this.gTj));
        this.gSN.setText(String.valueOf(this.gTk));
        this.gSM.setSelection(this.gSM.getText().toString().length());
        this.gSN.setSelection(this.gSN.getText().toString().length());
        TextView textView = this.gSL;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gTg));
        }
        textView.setText(str);
        this.gSY.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aTG)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aTG)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gTz))};
        }
        if (this.gTb != null) {
            this.gTb.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gTb.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gTb.addView(textView2, layoutParams);
            }
        }
        if (this.gTi != null && !this.gTi.isEmpty()) {
            if (this.gTi.size() == 1) {
                aVar = this.gTi.get(0);
            } else {
                aVar = this.gTi.get(0);
                aVar2 = this.gTi.get(1);
            }
            if (aVar == null) {
                this.gSR.setVisibility(8);
            } else {
                this.gST.setText(aVar.aTP);
                this.gSR.setVisibility(0);
                this.gTl = aVar.aTQ;
            }
            if (aVar2 == null) {
                this.gSS.setVisibility(8);
            } else {
                this.gSU.setText(aVar2.aTP);
                this.gSS.setVisibility(0);
                this.gTm = aVar2.aTQ;
            }
            if (this.gSR.getVisibility() == 0 || this.gSS.getVisibility() == 0) {
                this.gSQ.setVisibility(0);
                return;
            } else {
                this.gSQ.setVisibility(8);
                return;
            }
        }
        this.gSQ.setVisibility(8);
    }

    private void bUj() {
        this.gSM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.2
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
        this.gSN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.gSN.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.gSN.hasFocus()) {
                        b.this.gTA = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.gSN.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.gTk = parseLong;
                    if (parseLong >= b.this.aTD && parseLong <= b.this.aTE) {
                        b.this.gSP.setVisibility(8);
                        b.this.gTo = true;
                    } else {
                        b.this.gSP.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aTD), Integer.valueOf(b.this.aTE)));
                        b.this.gSP.setVisibility(0);
                        b.this.gTo = false;
                    }
                } else {
                    b.this.gSP.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aTD), Integer.valueOf(b.this.aTE)));
                    b.this.gSP.setVisibility(0);
                    b.this.gTk = 0L;
                    b.this.gTo = false;
                }
                b.this.gSN.setSelection(b.this.gSN.getText().toString().length());
                TextView textView = b.this.gSX;
                if (!b.this.gTn || !b.this.gTo) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.mW(false);
                b.this.mX(false);
            }
        });
    }

    private void bUk() {
        this.gSM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gSM.setText("");
                    b.this.gSM.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gSM.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gSN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gSN.setText("");
                    b.this.gSN.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gSN.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mW(boolean z) {
        boolean z2 = true;
        this.gTh = this.gTz;
        String obj = this.gSM.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gSO.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gTe), Long.valueOf(this.gTf)));
            this.gSO.setVisibility(0);
            this.gTj = 0L;
            this.gTn = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gSM.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gTj != parseLong && this.gTj > this.gTf && parseLong > this.gTf) {
                this.gSM.setText(String.valueOf(this.gTj));
                return true;
            } else {
                boolean z3 = bUl() && parseLong < this.aTL;
                this.gTj = parseLong;
                if (bUl()) {
                    this.gTh = this.aTM;
                }
                if (parseLong < this.gTe || parseLong > this.gTf) {
                    if (parseLong == 0) {
                        this.gSM.setText("0");
                    }
                    this.gSO.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gTe), Long.valueOf(this.gTf)));
                    this.gSO.setVisibility(0);
                    this.gTn = false;
                } else {
                    if (z && this.gSN != null && bUm() && !this.gSN.hasFocus()) {
                        boolean z4 = !this.gTA;
                        if (!z4 && this.gSN.getText() != null) {
                            String obj2 = this.gSN.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bUl()) {
                                long j = this.gTj / this.aTM;
                                if (this.aTE > 0 && j > this.aTE) {
                                    j = this.aTE;
                                }
                                this.gSN.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gSN.setText(String.valueOf(this.gTy));
                            }
                        }
                    }
                    this.gSO.setVisibility(8);
                    this.gTn = true;
                }
            }
        }
        this.gSM.setSelection(this.gSM.getText().toString().length());
        TextView textView = this.gSX;
        if (!this.gTn || !this.gTo) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        if (this.gTo && this.gTn && this.gTk != 0 && this.gTj / this.gTk < this.gTh) {
            this.gSO.setVisibility(0);
            if (z) {
                this.gSO.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gTk * this.gTh)));
            } else {
                this.gSO.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gTj / this.gTh)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gTa.getVisibility() == 0) {
            this.gTa.setVisibility(8);
            return;
        }
        if (view == this.gTd && !this.gTx) {
            this.activity.finish();
        } else if (view == this.gSJ && !this.gTx) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gSK) {
            this.gTa.setVisibility(0);
        } else if (view == this.gSR) {
            this.gTp = this.gTp ? false : true;
            if (this.gTp) {
                this.gSV.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gSV.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gSS) {
            this.gTq = this.gTq ? false : true;
            if (this.gTq) {
                this.gSW.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gSW.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gSX) {
            if (this.gTp && this.gTq) {
                str = this.gTl + "," + this.gTm;
            } else if (this.gTp) {
                str = this.gTl;
            } else if (this.gTq) {
                str = this.gTm;
            } else {
                str = "";
            }
            h hVar = new h();
            hVar.fo(this.gTj);
            hVar.fp(this.gTk);
            hVar.GM(str);
            if (this.otv != null) {
                this.otv.a(hVar);
            }
        }
        if (this.gTx && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void mY(boolean z) {
        if (this.gSX != null) {
            this.gSX.setEnabled(z);
        }
    }

    public View getView() {
        return this.gSJ;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gTx = z;
        if (!z) {
            if (this.gSN != null) {
                this.gSN.clearFocus();
            }
            if (this.gSM != null) {
                this.gSM.clearFocus();
            }
        }
        if (this.gSZ != null && this.gSZ.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSZ.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gTr;
                }
            } else {
                layoutParams.topMargin = this.gTs;
            }
            this.gSZ.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTd.setVisibility(0);
        } else {
            this.gTd.setVisibility(8);
        }
    }

    public void FQ() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gSJ);
        } else {
            i.af(this.gSJ);
        }
        if (this.gTc != null && this.gTc.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTc.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gTv;
            } else {
                layoutParams.height = -2;
            }
            this.gTc.setLayoutParams(layoutParams);
        }
        if (this.gSZ != null && this.gSZ.getLayoutParams() != null && this.gTu > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gSZ.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gSZ.setPivotX(this.gTu / 2);
            this.gSZ.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gSZ.setScaleX(this.gTw);
                this.gSZ.setScaleY(this.gTw);
            } else {
                layoutParams2.width = -1;
                this.gSZ.setScaleX(1.0f);
                this.gSZ.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gTx);
        }
    }

    private boolean bUl() {
        return bUm() && this.gTj >= this.aTL && this.gTj <= this.gTf;
    }

    private boolean bUm() {
        return this.aTL >= ((long) this.gTe) && this.aTM > 0;
    }
}
