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
import com.baidu.live.data.cj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.yuyinala.data.h;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private int aSQ;
    private int aSR;
    private int aST;
    private long aSY;
    private int aSZ;
    private Activity activity;
    private int dOW;
    private long gHB;
    private String gHC;
    private String gHD;
    private boolean gHG;
    private boolean gHH;
    private int gHI;
    private int gHJ;
    private int gHL;
    private int gHM;
    private float gHN;
    private boolean gHO;
    private int gHQ;
    private boolean gHR;
    private View gHa;
    private View gHb;
    private TextView gHc;
    private EditText gHd;
    private EditText gHe;
    private TextView gHf;
    private TextView gHg;
    private LinearLayout gHh;
    private LinearLayout gHi;
    private LinearLayout gHj;
    private TextView gHk;
    private TextView gHl;
    private ImageView gHm;
    private ImageView gHn;
    private TextView gHo;
    private TextView gHp;
    private RelativeLayout gHq;
    private LinearLayout gHr;
    private LinearLayout gHs;
    private ScrollView gHt;
    private View gHu;
    private long gHw;
    private int gHx;
    private int gHy;
    private List<cj.a> gHz;
    private a ojN;
    private int screenWidth;
    private int gHv = 2000;
    private long gHA = 2000;
    private boolean gHE = true;
    private boolean gHF = true;
    private int gHP = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.ojN = aVar;
        initView();
        initData();
        bUF();
        bUG();
        this.gHq.setVisibility(4);
        this.gHq.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.dOW = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.dOW) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.dOW;
                    b.this.dOW = i;
                }
                b.this.gHL = b.this.screenWidth;
                b.this.gHJ = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                b.this.gHM = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.gHJ * 2);
                b.this.gHN = (i2 * 1.0f) / b.this.gHq.getHeight();
                if (b.this.dOW > b.this.gHq.getHeight()) {
                    b.this.gHI = (b.this.dOW - b.this.gHq.getHeight()) / 2;
                }
                b.this.IR();
                b.this.gHq.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gHa = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gHb = this.gHa.findViewById(a.f.iv_send_red_q);
        this.gHc = (TextView) this.gHa.findViewById(a.f.tv_red_broad_hint);
        this.gHd = (EditText) this.gHa.findViewById(a.f.edt_t_num);
        this.gHe = (EditText) this.gHa.findViewById(a.f.edt_pkt_num);
        this.gHf = (TextView) this.gHa.findViewById(a.f.tv_send_t_num_hint);
        this.gHg = (TextView) this.gHa.findViewById(a.f.tv_send_pkt_num_hint);
        this.gHh = (LinearLayout) this.gHa.findViewById(a.f.layout_red_pkt_condition);
        this.gHi = (LinearLayout) this.gHa.findViewById(a.f.layout_condition_first);
        this.gHj = (LinearLayout) this.gHa.findViewById(a.f.layout_condition_second);
        this.gHq = (RelativeLayout) this.gHa.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gHa.findViewById(a.f.layout_send_red);
        this.gHk = (TextView) this.gHa.findViewById(a.f.tv_condition_first);
        this.gHl = (TextView) this.gHa.findViewById(a.f.tv_condition_second);
        this.gHm = (ImageView) this.gHa.findViewById(a.f.iv_condition_first);
        this.gHn = (ImageView) this.gHa.findViewById(a.f.iv_condition_second);
        this.gHo = (TextView) this.gHa.findViewById(a.f.tv_send_pkt_submit);
        this.gHp = (TextView) this.gHa.findViewById(a.f.tv_send_pkt_time);
        this.gHr = (LinearLayout) this.gHa.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gHa.findViewById(a.f.layout_red_send_rule_content);
        this.gHs = (LinearLayout) this.gHa.findViewById(a.f.layout_rule_desc);
        this.gHt = (ScrollView) this.gHa.findViewById(a.f.layout_input_scroll);
        this.gHu = this.gHa.findViewById(a.f.layout_send_red_close);
        this.gHa.setOnClickListener(this);
        this.gHi.setOnClickListener(this);
        this.gHj.setOnClickListener(this);
        this.gHo.setOnClickListener(this);
        this.gHb.setOnClickListener(this);
        this.gHr.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gHu.setOnClickListener(this);
        ((ImageView) this.gHa.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cj.a aVar;
        cj.a aVar2 = null;
        if (com.baidu.live.ae.a.RB() == null || com.baidu.live.ae.a.RB().bxq == null || com.baidu.live.ae.a.RB().bxq.aQM == null || com.baidu.live.ae.a.RB().bxq.aQM.aSl == null) {
            strArr = null;
            str = null;
        } else {
            cj cjVar = com.baidu.live.ae.a.RB().bxq.aQM.aSl;
            if (cjVar.aSW > 0) {
                this.gHA = cjVar.aSW;
            }
            if (cjVar.aSX > 0) {
                this.gHP = cjVar.aSX;
            }
            this.gHB = this.gHP;
            this.gHw = cjVar.aSO;
            this.aSQ = cjVar.aSQ;
            this.aSR = cjVar.aSR;
            this.gHx = cjVar.aSS;
            this.gHQ = cjVar.aSP;
            this.aST = cjVar.aST;
            this.gHz = cjVar.aSV;
            this.aSY = cjVar.aSY;
            this.aSZ = cjVar.aSZ;
            str = cjVar.aTa;
            strArr = cjVar.aTb;
            if (bUH()) {
                this.gHy = this.aSZ;
            } else {
                this.gHy = this.gHQ;
            }
        }
        this.gHd.setText(String.valueOf(this.gHA));
        this.gHe.setText(String.valueOf(this.gHB));
        this.gHd.setSelection(this.gHd.getText().toString().length());
        this.gHe.setSelection(this.gHe.getText().toString().length());
        TextView textView = this.gHc;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gHx));
        }
        textView.setText(str);
        this.gHp.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aST)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aST)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gHQ))};
        }
        if (this.gHs != null) {
            this.gHs.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gHs.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gHs.addView(textView2, layoutParams);
            }
        }
        if (this.gHz != null && !this.gHz.isEmpty()) {
            if (this.gHz.size() == 1) {
                aVar = this.gHz.get(0);
            } else {
                aVar = this.gHz.get(0);
                aVar2 = this.gHz.get(1);
            }
            if (aVar == null) {
                this.gHi.setVisibility(8);
            } else {
                this.gHk.setText(aVar.aTc);
                this.gHi.setVisibility(0);
                this.gHC = aVar.aTd;
            }
            if (aVar2 == null) {
                this.gHj.setVisibility(8);
            } else {
                this.gHl.setText(aVar2.aTc);
                this.gHj.setVisibility(0);
                this.gHD = aVar2.aTd;
            }
            if (this.gHi.getVisibility() == 0 || this.gHj.getVisibility() == 0) {
                this.gHh.setVisibility(0);
                return;
            } else {
                this.gHh.setVisibility(8);
                return;
            }
        }
        this.gHh.setVisibility(8);
    }

    private void bUF() {
        this.gHd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.mw(true)) {
                    b.this.mx(true);
                }
            }
        });
        this.gHe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.gHe.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.gHe.hasFocus()) {
                        b.this.gHR = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.gHe.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.gHB = parseLong;
                    if (parseLong >= b.this.aSQ && parseLong <= b.this.aSR) {
                        b.this.gHg.setVisibility(8);
                        b.this.gHF = true;
                    } else {
                        b.this.gHg.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aSQ), Integer.valueOf(b.this.aSR)));
                        b.this.gHg.setVisibility(0);
                        b.this.gHF = false;
                    }
                } else {
                    b.this.gHg.setText(String.format(b.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(b.this.aSQ), Integer.valueOf(b.this.aSR)));
                    b.this.gHg.setVisibility(0);
                    b.this.gHB = 0L;
                    b.this.gHF = false;
                }
                b.this.gHe.setSelection(b.this.gHe.getText().toString().length());
                TextView textView = b.this.gHo;
                if (!b.this.gHE || !b.this.gHF) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.mw(false);
                b.this.mx(false);
            }
        });
    }

    private void bUG() {
        this.gHd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gHd.setText("");
                    b.this.gHd.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gHd.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gHe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gHe.setText("");
                    b.this.gHe.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gHe.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mw(boolean z) {
        boolean z2 = true;
        this.gHy = this.gHQ;
        String obj = this.gHd.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gHf.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gHv), Long.valueOf(this.gHw)));
            this.gHf.setVisibility(0);
            this.gHA = 0L;
            this.gHE = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gHd.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gHA != parseLong && this.gHA > this.gHw && parseLong > this.gHw) {
                this.gHd.setText(String.valueOf(this.gHA));
                return true;
            } else {
                boolean z3 = bUH() && parseLong < this.aSY;
                this.gHA = parseLong;
                if (bUH()) {
                    this.gHy = this.aSZ;
                }
                if (parseLong < this.gHv || parseLong > this.gHw) {
                    if (parseLong == 0) {
                        this.gHd.setText("0");
                    }
                    this.gHf.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gHv), Long.valueOf(this.gHw)));
                    this.gHf.setVisibility(0);
                    this.gHE = false;
                } else {
                    if (z && this.gHe != null && bUI() && !this.gHe.hasFocus()) {
                        boolean z4 = !this.gHR;
                        if (!z4 && this.gHe.getText() != null) {
                            String obj2 = this.gHe.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bUH()) {
                                long j = this.gHA / this.aSZ;
                                if (this.aSR > 0 && j > this.aSR) {
                                    j = this.aSR;
                                }
                                this.gHe.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gHe.setText(String.valueOf(this.gHP));
                            }
                        }
                    }
                    this.gHf.setVisibility(8);
                    this.gHE = true;
                }
            }
        }
        this.gHd.setSelection(this.gHd.getText().toString().length());
        TextView textView = this.gHo;
        if (!this.gHE || !this.gHF) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(boolean z) {
        if (this.gHF && this.gHE && this.gHB != 0 && this.gHA / this.gHB < this.gHy) {
            this.gHf.setVisibility(0);
            if (z) {
                this.gHf.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gHB * this.gHy)));
            } else {
                this.gHf.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gHA / this.gHy)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gHr.getVisibility() == 0) {
            this.gHr.setVisibility(8);
            return;
        }
        if (view == this.gHu && !this.gHO) {
            this.activity.finish();
        } else if (view == this.gHa && !this.gHO) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gHb) {
            this.gHr.setVisibility(0);
        } else if (view == this.gHi) {
            this.gHG = this.gHG ? false : true;
            if (this.gHG) {
                this.gHm.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gHm.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gHj) {
            this.gHH = this.gHH ? false : true;
            if (this.gHH) {
                this.gHn.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gHn.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gHo) {
            if (this.gHG && this.gHH) {
                str = this.gHC + "," + this.gHD;
            } else if (this.gHG) {
                str = this.gHC;
            } else if (this.gHH) {
                str = this.gHD;
            } else {
                str = "";
            }
            h hVar = new h();
            hVar.fi(this.gHA);
            hVar.fj(this.gHB);
            hVar.Hp(str);
            if (this.ojN != null) {
                this.ojN.a(hVar);
            }
        }
        if (this.gHO && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void my(boolean z) {
        if (this.gHo != null) {
            this.gHo.setEnabled(z);
        }
    }

    public View getView() {
        return this.gHa;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gHO = z;
        if (!z) {
            if (this.gHe != null) {
                this.gHe.clearFocus();
            }
            if (this.gHd != null) {
                this.gHd.clearFocus();
            }
        }
        if (this.gHq != null && this.gHq.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHq.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gHI;
                }
            } else {
                layoutParams.topMargin = this.gHJ;
            }
            this.gHq.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gHu.setVisibility(0);
        } else {
            this.gHu.setVisibility(8);
        }
    }

    public void IR() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gHa);
        } else {
            i.af(this.gHa);
        }
        if (this.gHt != null && this.gHt.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHt.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gHM;
            } else {
                layoutParams.height = -2;
            }
            this.gHt.setLayoutParams(layoutParams);
        }
        if (this.gHq != null && this.gHq.getLayoutParams() != null && this.gHL > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gHq.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gHq.setPivotX(this.gHL / 2);
            this.gHq.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gHq.setScaleX(this.gHN);
                this.gHq.setScaleY(this.gHN);
            } else {
                layoutParams2.width = -1;
                this.gHq.setScaleX(1.0f);
                this.gHq.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gHO);
        }
    }

    private boolean bUH() {
        return bUI() && this.gHA >= this.aSY && this.gHA <= this.gHw;
    }

    private boolean bUI() {
        return this.aSY >= ((long) this.gHv) && this.aSZ > 0;
    }
}
