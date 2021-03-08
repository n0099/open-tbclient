package com.baidu.tieba.videoEasterEgg;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eWd;
    private a.b eWe;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private boolean nFI;
    private ImageView nWa;
    private ViewGroup nWb;
    private TbCheckBox nWc;
    private TextView nWd;
    private Button nWe;
    private Button nWf;
    private String nWg;
    private String nWh;
    private String nWi;
    private String nWj;
    private CompoundButton.OnCheckedChangeListener nWk;
    private TbCheckBox.a nWl;
    private final c<com.baidu.adp.widget.ImageView.a> nWm;

    public a(Activity activity) {
        super(activity);
        this.nFI = false;
        this.nWl = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nWk != null) {
                    a.this.nWk.onCheckedChanged(null, z);
                }
            }
        };
        this.nWm = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nWa.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nWa.setBackgroundResource(0);
                a.this.nWa.setImageDrawable(null);
                aVar.drawImageTo(a.this.nWa);
            }
        };
        Zo();
        nB(1);
        jG(false);
        jF(false);
    }

    private void Zo() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nWa = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nWf = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nWf.setOnClickListener(this);
        this.nWe = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nWe.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nWb = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nWd = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nWc = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nWc.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nWc.setStatedChangedListener(this.nWl);
        this.nWc.setTagData(new C0901a());
        this.nWb.setClickable(true);
        this.nWb.setOnClickListener(this);
        bn(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        if (!this.nFI) {
            this.nFI = true;
            super.b(fVar);
            if (!au.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!au.isEmpty(this.nWj)) {
                this.nWd.setText(this.nWj);
            } else {
                this.nWb.setVisibility(4);
            }
            if (!au.isEmpty(this.nWi)) {
                this.nWf.setText(this.nWi);
            }
            if (!au.isEmpty(this.nWh)) {
                this.nWe.setText(this.nWh);
            }
            if (!TextUtils.isEmpty(this.nWg)) {
                d.mw().a(this.nWg, 10, this.nWm, fVar.getUniqueId());
            } else {
                this.nWa.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            getRealView().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.positive_btn) {
                if (this.eWd != null) {
                    this.eWd.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eWe != null) {
                    this.eWe.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nWc.setChecked(!this.nWc.isChecked());
            }
        }
    }

    public a UU(String str) {
        this.nWg = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: UV */
    public a AB(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nWj = this.mActivity.getResources().getString(i);
            this.nWk = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nWi = str;
        this.eWe = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nWi = this.mActivity.getResources().getString(i);
            this.eWe = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nWh = this.mActivity.getResources().getString(i);
            this.eWd = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nWh = str;
        this.eWd = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0901a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0901a() {
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
