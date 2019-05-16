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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b bLW;
    private a.b bLX;
    private ImageView dWN;
    private Button jxA;
    private String jxB;
    private String jxC;
    private String jxD;
    private String jxE;
    private CompoundButton.OnCheckedChangeListener jxF;
    private boolean jxG;
    private TbCheckBox.a jxH;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jxI;
    private ImageView jxv;
    private ViewGroup jxw;
    private TbCheckBox jxx;
    private TextView jxy;
    private Button jxz;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jxG = false;
        this.jxH = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jxF != null) {
                    a.this.jxF.onCheckedChanged(null, z);
                }
            }
        };
        this.jxI = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.nt()) {
                    a.this.jxv.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.jxv.setBackgroundResource(0);
                a.this.jxv.setImageDrawable(null);
                aVar.a(a.this.jxv);
            }
        };
        cfu();
        hr(1);
        dN(false);
        dM(false);
    }

    private void cfu() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.jxv = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.jxA = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.jxA.setOnClickListener(this);
        this.jxz = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.jxz.setOnClickListener(this);
        this.dWN = (ImageView) this.mContentView.findViewById(R.id.close);
        this.dWN.setOnClickListener(this);
        this.jxw = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.jxy = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.jxx = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.jxx.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.jxx.setStatedChangedListener(this.jxH);
        this.jxx.setTagData(new C0424a());
        this.jxw.setClickable(true);
        this.jxw.setOnClickListener(this);
        aF(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jxG) {
            this.jxG = true;
            super.b(eVar);
            if (!ap.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ap.isEmpty(this.jxE)) {
                this.jxy.setText(this.jxE);
            } else {
                this.jxw.setVisibility(4);
            }
            if (!ap.isEmpty(this.jxD)) {
                this.jxA.setText(this.jxD);
            }
            if (!ap.isEmpty(this.jxC)) {
                this.jxz.setText(this.jxC);
            }
            if (!TextUtils.isEmpty(this.jxB)) {
                c.iv().a(this.jxB, 10, this.jxI, eVar.getUniqueId());
            } else {
                this.jxv.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            afH().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.positive_btn) {
                if (this.bLW != null) {
                    this.bLW.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.bLX != null) {
                    this.bLX.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.jxx.setChecked(!this.jxx.isChecked());
            }
        }
    }

    public a Fp(String str) {
        this.jxB = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Fq */
    public a mE(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jxE = this.mActivity.getResources().getString(i);
            this.jxF = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jxD = str;
        this.bLX = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jxD = this.mActivity.getResources().getString(i);
            this.bLX = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jxC = this.mActivity.getResources().getString(i);
            this.bLW = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jxC = str;
        this.bLW = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0424a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0424a() {
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
