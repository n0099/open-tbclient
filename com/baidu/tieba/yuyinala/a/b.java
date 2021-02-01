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
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private int aSd;
    private int aSe;
    private int aSg;
    private long aSl;
    private int aSm;
    private Activity activity;
    private int dVi;
    private View gQM;
    private View gQN;
    private TextView gQO;
    private EditText gQP;
    private EditText gQQ;
    private TextView gQR;
    private TextView gQS;
    private LinearLayout gQT;
    private LinearLayout gQU;
    private LinearLayout gQV;
    private TextView gQW;
    private TextView gQX;
    private ImageView gQY;
    private ImageView gQZ;
    private boolean gRA;
    private int gRC;
    private boolean gRD;
    private TextView gRa;
    private TextView gRb;
    private RelativeLayout gRc;
    private LinearLayout gRd;
    private LinearLayout gRe;
    private ScrollView gRf;
    private View gRg;
    private long gRi;
    private int gRj;
    private int gRk;
    private List<cs.a> gRl;
    private long gRn;
    private String gRo;
    private String gRp;
    private boolean gRs;
    private boolean gRt;
    private int gRu;
    private int gRv;
    private int gRx;
    private int gRy;
    private float gRz;
    private a oqP;
    private int screenWidth;
    private int gRh = 2000;
    private long gRm = 2000;
    private boolean gRq = true;
    private boolean gRr = true;
    private int gRB = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.oqP = aVar;
        initView();
        initData();
        bTW();
        bTX();
        this.gRc.setVisibility(4);
        this.gRc.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.dVi = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.dVi) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.dVi;
                    b.this.dVi = i;
                }
                b.this.gRx = b.this.screenWidth;
                b.this.gRv = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                b.this.gRy = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.gRv * 2);
                b.this.gRz = (i2 * 1.0f) / b.this.gRc.getHeight();
                if (b.this.dVi > b.this.gRc.getHeight()) {
                    b.this.gRu = (b.this.dVi - b.this.gRc.getHeight()) / 2;
                }
                b.this.FN();
                b.this.gRc.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gQM = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gQN = this.gQM.findViewById(a.f.iv_send_red_q);
        this.gQO = (TextView) this.gQM.findViewById(a.f.tv_red_broad_hint);
        this.gQP = (EditText) this.gQM.findViewById(a.f.edt_t_num);
        this.gQQ = (EditText) this.gQM.findViewById(a.f.edt_pkt_num);
        this.gQR = (TextView) this.gQM.findViewById(a.f.tv_send_t_num_hint);
        this.gQS = (TextView) this.gQM.findViewById(a.f.tv_send_pkt_num_hint);
        this.gQT = (LinearLayout) this.gQM.findViewById(a.f.layout_red_pkt_condition);
        this.gQU = (LinearLayout) this.gQM.findViewById(a.f.layout_condition_first);
        this.gQV = (LinearLayout) this.gQM.findViewById(a.f.layout_condition_second);
        this.gRc = (RelativeLayout) this.gQM.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gQM.findViewById(a.f.layout_send_red);
        this.gQW = (TextView) this.gQM.findViewById(a.f.tv_condition_first);
        this.gQX = (TextView) this.gQM.findViewById(a.f.tv_condition_second);
        this.gQY = (ImageView) this.gQM.findViewById(a.f.iv_condition_first);
        this.gQZ = (ImageView) this.gQM.findViewById(a.f.iv_condition_second);
        this.gRa = (TextView) this.gQM.findViewById(a.f.tv_send_pkt_submit);
        this.gRb = (TextView) this.gQM.findViewById(a.f.tv_send_pkt_time);
        this.gRd = (LinearLayout) this.gQM.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gQM.findViewById(a.f.layout_red_send_rule_content);
        this.gRe = (LinearLayout) this.gQM.findViewById(a.f.layout_rule_desc);
        this.gRf = (ScrollView) this.gQM.findViewById(a.f.layout_input_scroll);
        this.gRg = this.gQM.findViewById(a.f.layout_send_red_close);
        this.gQM.setOnClickListener(this);
        this.gQU.setOnClickListener(this);
        this.gQV.setOnClickListener(this);
        this.gRa.setOnClickListener(this);
        this.gQN.setOnClickListener(this);
        this.gRd.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gRg.setOnClickListener(this);
        ((ImageView) this.gQM.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cs.a aVar;
        cs.a aVar2 = null;
        if (com.baidu.live.ae.a.Qj() == null || com.baidu.live.ae.a.Qj().bAS == null || com.baidu.live.ae.a.Qj().bAS.aPM == null || com.baidu.live.ae.a.Qj().bAS.aPM.aRv == null) {
            strArr = null;
            str = null;
        } else {
            cs csVar = com.baidu.live.ae.a.Qj().bAS.aPM.aRv;
            if (csVar.aSj > 0) {
                this.gRm = csVar.aSj;
            }
            if (csVar.aSk > 0) {
                this.gRB = csVar.aSk;
            }
            this.gRn = this.gRB;
            this.gRi = csVar.aSb;
            this.aSd = csVar.aSd;
            this.aSe = csVar.aSe;
            this.gRj = csVar.aSf;
            this.gRC = csVar.aSc;
            this.aSg = csVar.aSg;
            this.gRl = csVar.aSi;
            this.aSl = csVar.aSl;
            this.aSm = csVar.aSm;
            str = csVar.aSn;
            strArr = csVar.aSo;
            if (bTY()) {
                this.gRk = this.aSm;
            } else {
                this.gRk = this.gRC;
            }
        }
        this.gQP.setText(String.valueOf(this.gRm));
        this.gQQ.setText(String.valueOf(this.gRn));
        this.gQP.setSelection(this.gQP.getText().toString().length());
        this.gQQ.setSelection(this.gQQ.getText().toString().length());
        TextView textView = this.gQO;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gRj));
        }
        textView.setText(str);
        this.gRb.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aSg)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aSg)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gRC))};
        }
        if (this.gRe != null) {
            this.gRe.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gRe.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gRe.addView(textView2, layoutParams);
            }
        }
        if (this.gRl != null && !this.gRl.isEmpty()) {
            if (this.gRl.size() == 1) {
                aVar = this.gRl.get(0);
            } else {
                aVar = this.gRl.get(0);
                aVar2 = this.gRl.get(1);
            }
            if (aVar == null) {
                this.gQU.setVisibility(8);
            } else {
                this.gQW.setText(aVar.aSp);
                this.gQU.setVisibility(0);
                this.gRo = aVar.aSq;
            }
            if (aVar2 == null) {
                this.gQV.setVisibility(8);
            } else {
                this.gQX.setText(aVar2.aSp);
                this.gQV.setVisibility(0);
                this.gRp = aVar2.aSq;
            }
            if (this.gQU.getVisibility() == 0 || this.gQV.getVisibility() == 0) {
                this.gQT.setVisibility(0);
                return;
            } else {
                this.gQT.setVisibility(8);
                return;
            }
        }
        this.gQT.setVisibility(8);
    }

    private void bTW() {
        this.gQP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.2
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
        this.gQQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.gQQ.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.gQQ.hasFocus()) {
                        b.this.gRD = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.gQQ.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.gRn = parseLong;
                    if (parseLong >= b.this.aSd && parseLong <= b.this.aSe) {
                        b.this.gQS.setVisibility(8);
                        b.this.gRr = true;
                    } else {
                        b.this.gQS.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aSd), Integer.valueOf(b.this.aSe)));
                        b.this.gQS.setVisibility(0);
                        b.this.gRr = false;
                    }
                } else {
                    b.this.gQS.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aSd), Integer.valueOf(b.this.aSe)));
                    b.this.gQS.setVisibility(0);
                    b.this.gRn = 0L;
                    b.this.gRr = false;
                }
                b.this.gQQ.setSelection(b.this.gQQ.getText().toString().length());
                TextView textView = b.this.gRa;
                if (!b.this.gRq || !b.this.gRr) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.mW(false);
                b.this.mX(false);
            }
        });
    }

    private void bTX() {
        this.gQP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gQP.setText("");
                    b.this.gQP.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gQP.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gQQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gQQ.setText("");
                    b.this.gQQ.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gQQ.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mW(boolean z) {
        boolean z2 = true;
        this.gRk = this.gRC;
        String obj = this.gQP.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gQR.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gRh), Long.valueOf(this.gRi)));
            this.gQR.setVisibility(0);
            this.gRm = 0L;
            this.gRq = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gQP.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gRm != parseLong && this.gRm > this.gRi && parseLong > this.gRi) {
                this.gQP.setText(String.valueOf(this.gRm));
                return true;
            } else {
                boolean z3 = bTY() && parseLong < this.aSl;
                this.gRm = parseLong;
                if (bTY()) {
                    this.gRk = this.aSm;
                }
                if (parseLong < this.gRh || parseLong > this.gRi) {
                    if (parseLong == 0) {
                        this.gQP.setText("0");
                    }
                    this.gQR.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gRh), Long.valueOf(this.gRi)));
                    this.gQR.setVisibility(0);
                    this.gRq = false;
                } else {
                    if (z && this.gQQ != null && bTZ() && !this.gQQ.hasFocus()) {
                        boolean z4 = !this.gRD;
                        if (!z4 && this.gQQ.getText() != null) {
                            String obj2 = this.gQQ.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bTY()) {
                                long j = this.gRm / this.aSm;
                                if (this.aSe > 0 && j > this.aSe) {
                                    j = this.aSe;
                                }
                                this.gQQ.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gQQ.setText(String.valueOf(this.gRB));
                            }
                        }
                    }
                    this.gQR.setVisibility(8);
                    this.gRq = true;
                }
            }
        }
        this.gQP.setSelection(this.gQP.getText().toString().length());
        TextView textView = this.gRa;
        if (!this.gRq || !this.gRr) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        if (this.gRr && this.gRq && this.gRn != 0 && this.gRm / this.gRn < this.gRk) {
            this.gQR.setVisibility(0);
            if (z) {
                this.gQR.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gRn * this.gRk)));
            } else {
                this.gQR.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gRm / this.gRk)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gRd.getVisibility() == 0) {
            this.gRd.setVisibility(8);
            return;
        }
        if (view == this.gRg && !this.gRA) {
            this.activity.finish();
        } else if (view == this.gQM && !this.gRA) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gQN) {
            this.gRd.setVisibility(0);
        } else if (view == this.gQU) {
            this.gRs = this.gRs ? false : true;
            if (this.gRs) {
                this.gQY.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gQY.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gQV) {
            this.gRt = this.gRt ? false : true;
            if (this.gRt) {
                this.gQZ.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gQZ.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gRa) {
            if (this.gRs && this.gRt) {
                str = this.gRo + "," + this.gRp;
            } else if (this.gRs) {
                str = this.gRo;
            } else if (this.gRt) {
                str = this.gRp;
            } else {
                str = "";
            }
            h hVar = new h();
            hVar.fo(this.gRm);
            hVar.fp(this.gRn);
            hVar.GC(str);
            if (this.oqP != null) {
                this.oqP.a(hVar);
            }
        }
        if (this.gRA && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void mY(boolean z) {
        if (this.gRa != null) {
            this.gRa.setEnabled(z);
        }
    }

    public View getView() {
        return this.gQM;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gRA = z;
        if (!z) {
            if (this.gQQ != null) {
                this.gQQ.clearFocus();
            }
            if (this.gQP != null) {
                this.gQP.clearFocus();
            }
        }
        if (this.gRc != null && this.gRc.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRc.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gRu;
                }
            } else {
                layoutParams.topMargin = this.gRv;
            }
            this.gRc.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gRg.setVisibility(0);
        } else {
            this.gRg.setVisibility(8);
        }
    }

    public void FN() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gQM);
        } else {
            i.af(this.gQM);
        }
        if (this.gRf != null && this.gRf.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRf.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gRy;
            } else {
                layoutParams.height = -2;
            }
            this.gRf.setLayoutParams(layoutParams);
        }
        if (this.gRc != null && this.gRc.getLayoutParams() != null && this.gRx > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gRc.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gRc.setPivotX(this.gRx / 2);
            this.gRc.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gRc.setScaleX(this.gRz);
                this.gRc.setScaleY(this.gRz);
            } else {
                layoutParams2.width = -1;
                this.gRc.setScaleX(1.0f);
                this.gRc.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gRA);
        }
    }

    private boolean bTY() {
        return bTZ() && this.gRm >= this.aSl && this.gRm <= this.gRi;
    }

    private boolean bTZ() {
        return this.aSl >= ((long) this.gRh) && this.aSm > 0;
    }
}
