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
    private a.b bEy;
    private a.b bEz;
    private ImageView dMW;
    private ImageView jeM;
    private ViewGroup jeN;
    private TbCheckBox jeO;
    private TextView jeP;
    private Button jeQ;
    private Button jeR;
    private String jeS;
    private String jeT;
    private String jeU;
    private String jeV;
    private CompoundButton.OnCheckedChangeListener jeW;
    private boolean jeX;
    private TbCheckBox.a jeY;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jeZ;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jeX = false;
        this.jeY = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jeW != null) {
                    a.this.jeW.onCheckedChanged(null, z);
                }
            }
        };
        this.jeZ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.oz()) {
                    a.this.jeM.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.jeM.setBackgroundResource(0);
                a.this.jeM.setImageDrawable(null);
                aVar.a(a.this.jeM);
            }
        };
        bXu();
        gF(1);
        dr(false);
        dq(false);
    }

    private void bXu() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.easter_egg_dialog, (ViewGroup) null);
        this.jeM = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.jeR = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.jeR.setOnClickListener(this);
        this.jeQ = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.jeQ.setOnClickListener(this);
        this.dMW = (ImageView) this.mContentView.findViewById(d.g.close);
        this.dMW.setOnClickListener(this);
        this.jeN = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.jeP = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.jeO = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.jeO.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.jeO.setStatedChangedListener(this.jeY);
        this.jeO.setTagData(new C0405a());
        this.jeN.setClickable(true);
        this.jeN.setOnClickListener(this);
        az(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jeX) {
            this.jeX = true;
            super.b(eVar);
            if (!ap.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ap.isEmpty(this.jeV)) {
                this.jeP.setText(this.jeV);
            } else {
                this.jeN.setVisibility(4);
            }
            if (!ap.isEmpty(this.jeU)) {
                this.jeR.setText(this.jeU);
            }
            if (!ap.isEmpty(this.jeT)) {
                this.jeQ.setText(this.jeT);
            }
            if (!TextUtils.isEmpty(this.jeS)) {
                c.jB().a(this.jeS, 10, this.jeZ, eVar.getUniqueId());
            } else {
                this.jeM.setImageResource(d.f.frs_luhan_moren_background);
            }
            aba().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.positive_btn) {
                if (this.bEy != null) {
                    this.bEy.onClick(this);
                }
            } else if (id == d.g.negative_btn) {
                if (this.bEz != null) {
                    this.bEz.onClick(this);
                }
            } else if (id == d.g.close) {
                dismiss();
            } else if (id == d.g.checkbox_container) {
                this.jeO.setChecked(!this.jeO.isChecked());
            }
        }
    }

    public a DU(String str) {
        this.jeS = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: DV */
    public a ly(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jeV = this.mActivity.getResources().getString(i);
            this.jeW = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jeU = str;
        this.bEz = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jeU = this.mActivity.getResources().getString(i);
            this.bEz = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jeT = this.mActivity.getResources().getString(i);
            this.bEy = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jeT = str;
        this.bEy = bVar;
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
