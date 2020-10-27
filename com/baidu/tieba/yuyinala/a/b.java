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
import com.baidu.live.data.cf;
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
    private int aQA;
    private long aQF;
    private int aQG;
    private int aQx;
    private int aQy;
    private Activity activity;
    private int dDO;
    private View gsH;
    private View gsI;
    private TextView gsJ;
    private EditText gsK;
    private EditText gsL;
    private TextView gsM;
    private TextView gsN;
    private LinearLayout gsO;
    private LinearLayout gsP;
    private LinearLayout gsQ;
    private TextView gsR;
    private TextView gsS;
    private ImageView gsT;
    private ImageView gsU;
    private TextView gsV;
    private TextView gsW;
    private RelativeLayout gsX;
    private LinearLayout gsY;
    private LinearLayout gsZ;
    private ScrollView gta;
    private View gtb;
    private long gtd;
    private int gte;
    private int gtf;
    private List<cf.a> gtg;
    private long gti;
    private String gtj;
    private String gtk;
    private boolean gtn;
    private boolean gto;
    private int gtp;
    private int gtq;
    private int gts;
    private int gtt;
    private float gtu;
    private boolean gtv;
    private int gtx;
    private boolean gty;
    private a nNq;
    private int screenWidth;
    private int gtc = 2000;
    private long gth = 2000;
    private boolean gtl = true;
    private boolean gtm = true;
    private int gtw = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.nNq = aVar;
        initView();
        initData();
        bPb();
        bPc();
        this.gsX.setVisibility(4);
        this.gsX.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.dDO = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.dDO) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.dDO;
                    b.this.dDO = i;
                }
                b.this.gts = b.this.screenWidth;
                b.this.gtq = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.gtt = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.gtq * 2);
                b.this.gtu = (i2 * 1.0f) / b.this.gsX.getHeight();
                if (b.this.dDO > b.this.gsX.getHeight()) {
                    b.this.gtp = (b.this.dDO - b.this.gsX.getHeight()) / 2;
                }
                b.this.Hi();
                b.this.gsX.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gsH = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gsI = this.gsH.findViewById(a.g.iv_send_red_q);
        this.gsJ = (TextView) this.gsH.findViewById(a.g.tv_red_broad_hint);
        this.gsK = (EditText) this.gsH.findViewById(a.g.edt_t_num);
        this.gsL = (EditText) this.gsH.findViewById(a.g.edt_pkt_num);
        this.gsM = (TextView) this.gsH.findViewById(a.g.tv_send_t_num_hint);
        this.gsN = (TextView) this.gsH.findViewById(a.g.tv_send_pkt_num_hint);
        this.gsO = (LinearLayout) this.gsH.findViewById(a.g.layout_red_pkt_condition);
        this.gsP = (LinearLayout) this.gsH.findViewById(a.g.layout_condition_first);
        this.gsQ = (LinearLayout) this.gsH.findViewById(a.g.layout_condition_second);
        this.gsX = (RelativeLayout) this.gsH.findViewById(a.g.layout_send_red_content);
        View findViewById = this.gsH.findViewById(a.g.layout_send_red);
        this.gsR = (TextView) this.gsH.findViewById(a.g.tv_condition_first);
        this.gsS = (TextView) this.gsH.findViewById(a.g.tv_condition_second);
        this.gsT = (ImageView) this.gsH.findViewById(a.g.iv_condition_first);
        this.gsU = (ImageView) this.gsH.findViewById(a.g.iv_condition_second);
        this.gsV = (TextView) this.gsH.findViewById(a.g.tv_send_pkt_submit);
        this.gsW = (TextView) this.gsH.findViewById(a.g.tv_send_pkt_time);
        this.gsY = (LinearLayout) this.gsH.findViewById(a.g.layout_red_send_rule);
        View findViewById2 = this.gsH.findViewById(a.g.layout_red_send_rule_content);
        this.gsZ = (LinearLayout) this.gsH.findViewById(a.g.layout_rule_desc);
        this.gta = (ScrollView) this.gsH.findViewById(a.g.layout_input_scroll);
        this.gtb = this.gsH.findViewById(a.g.layout_send_red_close);
        this.gsH.setOnClickListener(this);
        this.gsP.setOnClickListener(this);
        this.gsQ.setOnClickListener(this);
        this.gsV.setOnClickListener(this);
        this.gsI.setOnClickListener(this);
        this.gsY.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gtb.setOnClickListener(this);
        ((ImageView) this.gsH.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cf.a aVar;
        cf.a aVar2 = null;
        if (com.baidu.live.z.a.Pq() == null || com.baidu.live.z.a.Pq().bsy == null || com.baidu.live.z.a.Pq().bsy.aOA == null || com.baidu.live.z.a.Pq().bsy.aOA.aPS == null) {
            strArr = null;
            str = null;
        } else {
            cf cfVar = com.baidu.live.z.a.Pq().bsy.aOA.aPS;
            if (cfVar.aQD > 0) {
                this.gth = cfVar.aQD;
            }
            if (cfVar.aQE > 0) {
                this.gtw = cfVar.aQE;
            }
            this.gti = this.gtw;
            this.gtd = cfVar.aQv;
            this.aQx = cfVar.aQx;
            this.aQy = cfVar.aQy;
            this.gte = cfVar.aQz;
            this.gtx = cfVar.aQw;
            this.aQA = cfVar.aQA;
            this.gtg = cfVar.aQC;
            this.aQF = cfVar.aQF;
            this.aQG = cfVar.aQG;
            str = cfVar.aQH;
            strArr = cfVar.aQI;
            if (bPd()) {
                this.gtf = this.aQG;
            } else {
                this.gtf = this.gtx;
            }
        }
        this.gsK.setText(String.valueOf(this.gth));
        this.gsL.setText(String.valueOf(this.gti));
        this.gsK.setSelection(this.gsK.getText().toString().length());
        this.gsL.setSelection(this.gsL.getText().toString().length());
        TextView textView = this.gsJ;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.gte));
        }
        textView.setText(str);
        this.gsW.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aQA)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aQA)), this.activity.getString(a.i.red_pkt_send_rule2), String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.gtx))};
        }
        if (this.gsZ != null) {
            this.gsZ.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gsZ.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                }
                this.gsZ.addView(textView2, layoutParams);
            }
        }
        if (this.gtg != null && !this.gtg.isEmpty()) {
            if (this.gtg.size() == 1) {
                aVar = this.gtg.get(0);
            } else {
                aVar = this.gtg.get(0);
                aVar2 = this.gtg.get(1);
            }
            if (aVar == null) {
                this.gsP.setVisibility(8);
            } else {
                this.gsR.setText(aVar.aQJ);
                this.gsP.setVisibility(0);
                this.gtj = aVar.aQK;
            }
            if (aVar2 == null) {
                this.gsQ.setVisibility(8);
            } else {
                this.gsS.setText(aVar2.aQJ);
                this.gsQ.setVisibility(0);
                this.gtk = aVar2.aQK;
            }
            if (this.gsP.getVisibility() == 0 || this.gsQ.getVisibility() == 0) {
                this.gsO.setVisibility(0);
                return;
            } else {
                this.gsO.setVisibility(8);
                return;
            }
        }
        this.gsO.setVisibility(8);
    }

    private void bPb() {
        this.gsK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.lR(true)) {
                    b.this.lS(true);
                }
            }
        });
        this.gsL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.yuyinala.a.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.gsL.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.gsL.hasFocus()) {
                        b.this.gty = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.gsL.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.gti = parseLong;
                    if (parseLong >= b.this.aQx && parseLong <= b.this.aQy) {
                        b.this.gsN.setVisibility(8);
                        b.this.gtm = true;
                    } else {
                        b.this.gsN.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aQx), Integer.valueOf(b.this.aQy)));
                        b.this.gsN.setVisibility(0);
                        b.this.gtm = false;
                    }
                } else {
                    b.this.gsN.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aQx), Integer.valueOf(b.this.aQy)));
                    b.this.gsN.setVisibility(0);
                    b.this.gti = 0L;
                    b.this.gtm = false;
                }
                b.this.gsL.setSelection(b.this.gsL.getText().toString().length());
                TextView textView = b.this.gsV;
                if (!b.this.gtl || !b.this.gtm) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.lR(false);
                b.this.lS(false);
            }
        });
    }

    private void bPc() {
        this.gsK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gsK.setText("");
                    b.this.gsK.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gsK.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gsL.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.yuyinala.a.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.gsL.setText("");
                    b.this.gsL.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.a.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gsL.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lR(boolean z) {
        boolean z2 = true;
        this.gtf = this.gtx;
        String obj = this.gsK.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gsM.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.gtc), Long.valueOf(this.gtd)));
            this.gsM.setVisibility(0);
            this.gth = 0L;
            this.gtl = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gsK.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gth != parseLong && this.gth > this.gtd && parseLong > this.gtd) {
                this.gsK.setText(String.valueOf(this.gth));
                return true;
            } else {
                boolean z3 = bPd() && parseLong < this.aQF;
                this.gth = parseLong;
                if (bPd()) {
                    this.gtf = this.aQG;
                }
                if (parseLong < this.gtc || parseLong > this.gtd) {
                    if (parseLong == 0) {
                        this.gsK.setText("0");
                    }
                    this.gsM.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.gtc), Long.valueOf(this.gtd)));
                    this.gsM.setVisibility(0);
                    this.gtl = false;
                } else {
                    if (z && this.gsL != null && bPe() && !this.gsL.hasFocus()) {
                        boolean z4 = !this.gty;
                        if (!z4 && this.gsL.getText() != null) {
                            String obj2 = this.gsL.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bPd()) {
                                long j = this.gth / this.aQG;
                                if (this.aQy > 0 && j > this.aQy) {
                                    j = this.aQy;
                                }
                                this.gsL.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gsL.setText(String.valueOf(this.gtw));
                            }
                        }
                    }
                    this.gsM.setVisibility(8);
                    this.gtl = true;
                }
            }
        }
        this.gsK.setSelection(this.gsK.getText().toString().length());
        TextView textView = this.gsV;
        if (!this.gtl || !this.gtm) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.gtm && this.gtl && this.gti != 0 && this.gth / this.gti < this.gtf) {
            this.gsM.setVisibility(0);
            if (z) {
                this.gsM.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.gti * this.gtf)));
            } else {
                this.gsM.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.gth / this.gtf)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gsY.getVisibility() == 0) {
            this.gsY.setVisibility(8);
            return;
        }
        if (view == this.gtb && !this.gtv) {
            this.activity.finish();
        } else if (view == this.gsH && !this.gtv) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gsI) {
            this.gsY.setVisibility(0);
        } else if (view == this.gsP) {
            this.gtn = this.gtn ? false : true;
            if (this.gtn) {
                this.gsT.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.gsT.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.gsQ) {
            this.gto = this.gto ? false : true;
            if (this.gto) {
                this.gsU.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.gsU.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.gsV) {
            if (this.gtn && this.gto) {
                str = this.gtj + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gtk;
            } else if (this.gtn) {
                str = this.gtj;
            } else if (this.gto) {
                str = this.gtk;
            } else {
                str = "";
            }
            h hVar = new h();
            hVar.ei(this.gth);
            hVar.ej(this.gti);
            hVar.GN(str);
            if (this.nNq != null) {
                this.nNq.a(hVar);
            }
        }
        if (this.gtv && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void lT(boolean z) {
        if (this.gsV != null) {
            this.gsV.setEnabled(z);
        }
    }

    public View getView() {
        return this.gsH;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gtv = z;
        if (!z) {
            if (this.gsL != null) {
                this.gsL.clearFocus();
            }
            if (this.gsK != null) {
                this.gsK.clearFocus();
            }
        }
        if (this.gsX != null && this.gsX.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsX.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gtp;
                }
            } else {
                layoutParams.topMargin = this.gtq;
            }
            this.gsX.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gtb.setVisibility(0);
        } else {
            this.gtb.setVisibility(8);
        }
    }

    public void Hi() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.aa(this.gsH);
        } else {
            i.ab(this.gsH);
        }
        if (this.gta != null && this.gta.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gta.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gtt;
            } else {
                layoutParams.height = -2;
            }
            this.gta.setLayoutParams(layoutParams);
        }
        if (this.gsX != null && this.gsX.getLayoutParams() != null && this.gts > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gsX.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gsX.setPivotX(this.gts / 2);
            this.gsX.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gsX.setScaleX(this.gtu);
                this.gsX.setScaleY(this.gtu);
            } else {
                layoutParams2.width = -1;
                this.gsX.setScaleX(1.0f);
                this.gsX.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gtv);
        }
    }

    private boolean bPd() {
        return bPe() && this.gth >= this.aQF && this.gth <= this.gtd;
    }

    private boolean bPe() {
        return this.aQF >= ((long) this.gtc) && this.aQG > 0;
    }
}
