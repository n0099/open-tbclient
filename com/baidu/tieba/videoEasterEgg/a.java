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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b dIt;
    private a.b dIu;
    private ImageView lKJ;
    private ViewGroup lKK;
    private TbCheckBox lKL;
    private TextView lKM;
    private Button lKN;
    private Button lKO;
    private String lKP;
    private String lKQ;
    private String lKR;
    private String lKS;
    private CompoundButton.OnCheckedChangeListener lKT;
    private boolean lKU;
    private TbCheckBox.a lKV;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lKW;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.lKU = false;
        this.lKV = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.lKT != null) {
                    a.this.lKT.onCheckedChanged(null, z);
                }
            }
        };
        this.lKW = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.lKJ.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.lKJ.setBackgroundResource(0);
                a.this.lKJ.setImageDrawable(null);
                aVar.drawImageTo(a.this.lKJ);
            }
        };
        Or();
        kI(1);
        gX(false);
        gW(false);
    }

    private void Or() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.lKJ = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.lKO = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.lKO.setOnClickListener(this);
        this.lKN = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.lKN.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.lKK = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.lKM = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.lKL = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.lKL.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.lKL.setStatedChangedListener(this.lKV);
        this.lKL.setTagData(new C0744a());
        this.lKK.setClickable(true);
        this.lKK.setOnClickListener(this);
        aP(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.lKU) {
            this.lKU = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.lKS)) {
                this.lKM.setText(this.lKS);
            } else {
                this.lKK.setVisibility(4);
            }
            if (!aq.isEmpty(this.lKR)) {
                this.lKO.setText(this.lKR);
            }
            if (!aq.isEmpty(this.lKQ)) {
                this.lKN.setText(this.lKQ);
            }
            if (!TextUtils.isEmpty(this.lKP)) {
                c.kX().a(this.lKP, 10, this.lKW, eVar.getUniqueId());
            } else {
                this.lKJ.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.dIt != null) {
                    this.dIt.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.dIu != null) {
                    this.dIu.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.lKL.setChecked(!this.lKL.isChecked());
            }
        }
    }

    public a NV(String str) {
        this.lKP = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: NW */
    public a vO(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.lKS = this.mActivity.getResources().getString(i);
            this.lKT = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.lKR = str;
        this.dIu = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lKR = this.mActivity.getResources().getString(i);
            this.dIu = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lKQ = this.mActivity.getResources().getString(i);
            this.dIt = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.lKQ = str;
        this.dIt = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0744a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0744a() {
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
