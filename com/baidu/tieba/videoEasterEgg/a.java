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
    private a.b eUE;
    private a.b eUF;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView nTV;
    private ViewGroup nTW;
    private TbCheckBox nTX;
    private TextView nTY;
    private Button nTZ;
    private Button nUa;
    private String nUb;
    private String nUc;
    private String nUd;
    private String nUe;
    private CompoundButton.OnCheckedChangeListener nUf;
    private boolean nUg;
    private TbCheckBox.a nUh;
    private final c<com.baidu.adp.widget.ImageView.a> nUi;

    public a(Activity activity) {
        super(activity);
        this.nUg = false;
        this.nUh = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nUf != null) {
                    a.this.nUf.onCheckedChanged(null, z);
                }
            }
        };
        this.nUi = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nTV.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nTV.setBackgroundResource(0);
                a.this.nTV.setImageDrawable(null);
                aVar.drawImageTo(a.this.nTV);
            }
        };
        Zl();
        nA(1);
        jG(false);
        jF(false);
    }

    private void Zl() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nTV = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nUa = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nUa.setOnClickListener(this);
        this.nTZ = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nTZ.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nTW = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nTY = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nTX = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nTX.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nTX.setStatedChangedListener(this.nUh);
        this.nTX.setTagData(new C0895a());
        this.nTW.setClickable(true);
        this.nTW.setOnClickListener(this);
        bn(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        if (!this.nUg) {
            this.nUg = true;
            super.b(fVar);
            if (!au.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!au.isEmpty(this.nUe)) {
                this.nTY.setText(this.nUe);
            } else {
                this.nTW.setVisibility(4);
            }
            if (!au.isEmpty(this.nUd)) {
                this.nUa.setText(this.nUd);
            }
            if (!au.isEmpty(this.nUc)) {
                this.nTZ.setText(this.nUc);
            }
            if (!TextUtils.isEmpty(this.nUb)) {
                d.mw().a(this.nUb, 10, this.nUi, fVar.getUniqueId());
            } else {
                this.nTV.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eUE != null) {
                    this.eUE.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eUF != null) {
                    this.eUF.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nTX.setChecked(!this.nTX.isChecked());
            }
        }
    }

    public a UN(String str) {
        this.nUb = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: UO */
    public a Au(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nUe = this.mActivity.getResources().getString(i);
            this.nUf = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nUd = str;
        this.eUF = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nUd = this.mActivity.getResources().getString(i);
            this.eUF = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nUc = this.mActivity.getResources().getString(i);
            this.eUE = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nUc = str;
        this.eUE = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0895a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0895a() {
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
