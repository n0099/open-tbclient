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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eXa;
    private a.b eXb;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private String nOA;
    private String nOB;
    private CompoundButton.OnCheckedChangeListener nOC;
    private boolean nOD;
    private TbCheckBox.a nOE;
    private final c<com.baidu.adp.widget.ImageView.a> nOF;
    private ImageView nOs;
    private ViewGroup nOt;
    private TbCheckBox nOu;
    private TextView nOv;
    private Button nOw;
    private Button nOx;
    private String nOy;
    private String nOz;

    public a(Activity activity) {
        super(activity);
        this.nOD = false;
        this.nOE = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nOC != null) {
                    a.this.nOC.onCheckedChanged(null, z);
                }
            }
        };
        this.nOF = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nOs.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nOs.setBackgroundResource(0);
                a.this.nOs.setImageDrawable(null);
                aVar.drawImageTo(a.this.nOs);
            }
        };
        abo();
        pd(1);
        jI(false);
        jH(false);
    }

    private void abo() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nOs = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nOx = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nOx.setOnClickListener(this);
        this.nOw = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nOw.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nOt = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nOv = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nOu = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nOu.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nOu.setStatedChangedListener(this.nOE);
        this.nOu.setTagData(new C0907a());
        this.nOt.setClickable(true);
        this.nOt.setOnClickListener(this);
        br(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        if (!this.nOD) {
            this.nOD = true;
            super.b(fVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.nOB)) {
                this.nOv.setText(this.nOB);
            } else {
                this.nOt.setVisibility(4);
            }
            if (!at.isEmpty(this.nOA)) {
                this.nOx.setText(this.nOA);
            }
            if (!at.isEmpty(this.nOz)) {
                this.nOw.setText(this.nOz);
            }
            if (!TextUtils.isEmpty(this.nOy)) {
                d.mx().a(this.nOy, 10, this.nOF, fVar.getUniqueId());
            } else {
                this.nOs.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eXa != null) {
                    this.eXa.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eXb != null) {
                    this.eXb.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nOu.setChecked(!this.nOu.isChecked());
            }
        }
    }

    public a UL(String str) {
        this.nOy = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: UM */
    public a Bo(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nOB = this.mActivity.getResources().getString(i);
            this.nOC = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nOA = str;
        this.eXb = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nOA = this.mActivity.getResources().getString(i);
            this.eXb = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nOz = this.mActivity.getResources().getString(i);
            this.eXa = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nOz = str;
        this.eXa = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0907a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0907a() {
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
