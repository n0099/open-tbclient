package com.baidu.tieba.videoEasterEgg;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b bEC;
    private a.b bED;
    private ImageView dMo;
    private ImageView jeB;
    private ViewGroup jeC;
    private TbCheckBox jeD;
    private TextView jeE;
    private Button jeF;
    private Button jeG;
    private String jeH;
    private String jeI;
    private String jeJ;
    private String jeK;
    private CompoundButton.OnCheckedChangeListener jeL;
    private boolean jeM;
    private TbCheckBox.a jeN;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jeO;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jeM = false;
        this.jeN = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jeL != null) {
                    a.this.jeL.onCheckedChanged(null, z);
                }
            }
        };
        this.jeO = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.oz()) {
                    a.this.jeB.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.jeB.setBackgroundResource(0);
                a.this.jeB.setImageDrawable(null);
                aVar.a(a.this.jeB);
            }
        };
        bXq();
        gE(1);
        dr(false);
        dq(false);
    }

    private void bXq() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.easter_egg_dialog, (ViewGroup) null);
        this.jeB = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.jeG = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.jeG.setOnClickListener(this);
        this.jeF = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.jeF.setOnClickListener(this);
        this.dMo = (ImageView) this.mContentView.findViewById(d.g.close);
        this.dMo.setOnClickListener(this);
        this.jeC = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.jeE = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.jeD = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.jeD.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.jeD.setStatedChangedListener(this.jeN);
        this.jeD.setTagData(new C0405a());
        this.jeC.setClickable(true);
        this.jeC.setOnClickListener(this);
        az(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jeM) {
            this.jeM = true;
            super.b(eVar);
            if (!ap.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ap.isEmpty(this.jeK)) {
                this.jeE.setText(this.jeK);
            } else {
                this.jeC.setVisibility(4);
            }
            if (!ap.isEmpty(this.jeJ)) {
                this.jeG.setText(this.jeJ);
            }
            if (!ap.isEmpty(this.jeI)) {
                this.jeF.setText(this.jeI);
            }
            if (!TextUtils.isEmpty(this.jeH)) {
                c.jB().a(this.jeH, 10, this.jeO, eVar.getUniqueId());
            } else {
                this.jeB.setImageResource(d.f.frs_luhan_moren_background);
            }
            aaX().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.positive_btn) {
                if (this.bEC != null) {
                    this.bEC.onClick(this);
                }
            } else if (id == d.g.negative_btn) {
                if (this.bED != null) {
                    this.bED.onClick(this);
                }
            } else if (id == d.g.close) {
                dismiss();
            } else if (id == d.g.checkbox_container) {
                this.jeD.setChecked(!this.jeD.isChecked());
            }
        }
    }

    public a DT(String str) {
        this.jeH = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: DU */
    public a lz(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jeK = this.mActivity.getResources().getString(i);
            this.jeL = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jeJ = str;
        this.bED = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jeJ = this.mActivity.getResources().getString(i);
            this.bED = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jeI = this.mActivity.getResources().getString(i);
            this.bEC = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jeI = str;
        this.bEC = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0405a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0405a() {
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public boolean isChecked() {
            return this.isChecked;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void setChecked(boolean z) {
            this.isChecked = z;
        }
    }
}
