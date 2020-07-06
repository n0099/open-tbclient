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
    private ImageView meD;
    private ViewGroup meE;
    private TbCheckBox meF;
    private TextView meG;
    private Button meH;
    private Button meI;
    private String meJ;
    private String meK;
    private String meL;
    private String meM;
    private CompoundButton.OnCheckedChangeListener meN;
    private boolean meO;
    private TbCheckBox.a meP;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> meQ;

    public a(Activity activity) {
        super(activity);
        this.meO = false;
        this.meP = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.meN != null) {
                    a.this.meN.onCheckedChanged(null, z);
                }
            }
        };
        this.meQ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.meD.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.meD.setBackgroundResource(0);
                a.this.meD.setImageDrawable(null);
                aVar.drawImageTo(a.this.meD);
            }
        };
        Px();
        kW(1);
        hg(false);
        hf(false);
    }

    private void Px() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.meD = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.meI = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.meI.setOnClickListener(this);
        this.meH = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.meH.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.meE = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.meG = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.meF = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.meF.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.meF.setStatedChangedListener(this.meP);
        this.meF.setTagData(new C0760a());
        this.meE.setClickable(true);
        this.meE.setOnClickListener(this);
        aP(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.meO) {
            this.meO = true;
            super.b(eVar);
            if (!ar.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ar.isEmpty(this.meM)) {
                this.meG.setText(this.meM);
            } else {
                this.meE.setVisibility(4);
            }
            if (!ar.isEmpty(this.meL)) {
                this.meI.setText(this.meL);
            }
            if (!ar.isEmpty(this.meK)) {
                this.meH.setText(this.meK);
            }
            if (!TextUtils.isEmpty(this.meJ)) {
                c.ln().a(this.meJ, 10, this.meQ, eVar.getUniqueId());
            } else {
                this.meD.setImageResource(R.drawable.frs_luhan_moren_background);
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
                this.meF.setChecked(!this.meF.isChecked());
            }
        }
    }

    public a Oy(String str) {
        this.meJ = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Oz */
    public a we(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.meM = this.mActivity.getResources().getString(i);
            this.meN = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.meL = str;
        this.dPk = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.meL = this.mActivity.getResources().getString(i);
            this.dPk = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.meK = this.mActivity.getResources().getString(i);
            this.dPj = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.meK = str;
        this.dPj = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0760a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0760a() {
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
