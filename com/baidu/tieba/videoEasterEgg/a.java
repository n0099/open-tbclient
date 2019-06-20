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
    private a.b bLX;
    private a.b bLY;
    private ImageView dWO;
    private ViewGroup jxA;
    private TbCheckBox jxB;
    private TextView jxC;
    private Button jxD;
    private Button jxE;
    private String jxF;
    private String jxG;
    private String jxH;
    private String jxI;
    private CompoundButton.OnCheckedChangeListener jxJ;
    private boolean jxK;
    private TbCheckBox.a jxL;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jxM;
    private ImageView jxz;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jxK = false;
        this.jxL = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jxJ != null) {
                    a.this.jxJ.onCheckedChanged(null, z);
                }
            }
        };
        this.jxM = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.nt()) {
                    a.this.jxz.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.jxz.setBackgroundResource(0);
                a.this.jxz.setImageDrawable(null);
                aVar.a(a.this.jxz);
            }
        };
        cfx();
        hr(1);
        dN(false);
        dM(false);
    }

    private void cfx() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.jxz = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.jxE = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.jxE.setOnClickListener(this);
        this.jxD = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.jxD.setOnClickListener(this);
        this.dWO = (ImageView) this.mContentView.findViewById(R.id.close);
        this.dWO.setOnClickListener(this);
        this.jxA = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.jxC = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.jxB = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.jxB.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.jxB.setStatedChangedListener(this.jxL);
        this.jxB.setTagData(new C0424a());
        this.jxA.setClickable(true);
        this.jxA.setOnClickListener(this);
        aF(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jxK) {
            this.jxK = true;
            super.b(eVar);
            if (!ap.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ap.isEmpty(this.jxI)) {
                this.jxC.setText(this.jxI);
            } else {
                this.jxA.setVisibility(4);
            }
            if (!ap.isEmpty(this.jxH)) {
                this.jxE.setText(this.jxH);
            }
            if (!ap.isEmpty(this.jxG)) {
                this.jxD.setText(this.jxG);
            }
            if (!TextUtils.isEmpty(this.jxF)) {
                c.iv().a(this.jxF, 10, this.jxM, eVar.getUniqueId());
            } else {
                this.jxz.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.bLX != null) {
                    this.bLX.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.bLY != null) {
                    this.bLY.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.jxB.setChecked(!this.jxB.isChecked());
            }
        }
    }

    public a Fr(String str) {
        this.jxF = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Fs */
    public a mD(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jxI = this.mActivity.getResources().getString(i);
            this.jxJ = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jxH = str;
        this.bLY = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jxH = this.mActivity.getResources().getString(i);
            this.bLY = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jxG = this.mActivity.getResources().getString(i);
            this.bLX = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jxG = str;
        this.bLX = bVar;
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
