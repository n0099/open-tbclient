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
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b dPj;
    private a.b dPk;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView meA;
    private ViewGroup meB;
    private TbCheckBox meC;
    private TextView meD;
    private Button meE;
    private Button meF;
    private String meG;
    private String meH;
    private String meI;
    private String meJ;
    private CompoundButton.OnCheckedChangeListener meK;
    private boolean meL;
    private TbCheckBox.a meM;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> meN;

    public a(Activity activity) {
        super(activity);
        this.meL = false;
        this.meM = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.meK != null) {
                    a.this.meK.onCheckedChanged(null, z);
                }
            }
        };
        this.meN = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.meA.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.meA.setBackgroundResource(0);
                a.this.meA.setImageDrawable(null);
                aVar.drawImageTo(a.this.meA);
            }
        };
        Px();
        kW(1);
        hg(false);
        hf(false);
    }

    private void Px() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.meA = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.meF = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.meF.setOnClickListener(this);
        this.meE = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.meE.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.meB = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.meD = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.meC = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.meC.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.meC.setStatedChangedListener(this.meM);
        this.meC.setTagData(new C0759a());
        this.meB.setClickable(true);
        this.meB.setOnClickListener(this);
        aP(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.meL) {
            this.meL = true;
            super.b(eVar);
            if (!ar.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ar.isEmpty(this.meJ)) {
                this.meD.setText(this.meJ);
            } else {
                this.meB.setVisibility(4);
            }
            if (!ar.isEmpty(this.meI)) {
                this.meF.setText(this.meI);
            }
            if (!ar.isEmpty(this.meH)) {
                this.meE.setText(this.meH);
            }
            if (!TextUtils.isEmpty(this.meG)) {
                c.ln().a(this.meG, 10, this.meN, eVar.getUniqueId());
            } else {
                this.meA.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.dPj != null) {
                    this.dPj.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.dPk != null) {
                    this.dPk.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.meC.setChecked(!this.meC.isChecked());
            }
        }
    }

    public a Ox(String str) {
        this.meG = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Oy */
    public a we(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.meJ = this.mActivity.getResources().getString(i);
            this.meK = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.meI = str;
        this.dPk = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.meI = this.mActivity.getResources().getString(i);
            this.dPk = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.meH = this.mActivity.getResources().getString(i);
            this.dPj = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.meH = str;
        this.dPj = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0759a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0759a() {
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
