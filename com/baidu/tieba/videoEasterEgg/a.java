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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eNd;
    private a.b eNe;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView nKW;
    private ViewGroup nKX;
    private TbCheckBox nKY;
    private TextView nKZ;
    private Button nLa;
    private Button nLb;
    private String nLc;
    private String nLd;
    private String nLe;
    private String nLf;
    private CompoundButton.OnCheckedChangeListener nLg;
    private boolean nLh;
    private TbCheckBox.a nLi;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nLj;

    public a(Activity activity) {
        super(activity);
        this.nLh = false;
        this.nLi = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nLg != null) {
                    a.this.nLg.onCheckedChanged(null, z);
                }
            }
        };
        this.nLj = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nKW.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nKW.setBackgroundResource(0);
                a.this.nKW.setImageDrawable(null);
                aVar.drawImageTo(a.this.nKW);
            }
        };
        ZG();
        oT(1);
        jm(false);
        jl(false);
    }

    private void ZG() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nKW = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nLb = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nLb.setOnClickListener(this);
        this.nLa = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nLa.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nKX = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nKZ = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nKY = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nKY.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nKY.setStatedChangedListener(this.nLi);
        this.nKY.setTagData(new C0886a());
        this.nKX.setClickable(true);
        this.nKX.setOnClickListener(this);
        bi(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.nLh) {
            this.nLh = true;
            super.b(eVar);
            if (!au.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!au.isEmpty(this.nLf)) {
                this.nKZ.setText(this.nLf);
            } else {
                this.nKX.setVisibility(4);
            }
            if (!au.isEmpty(this.nLe)) {
                this.nLb.setText(this.nLe);
            }
            if (!au.isEmpty(this.nLd)) {
                this.nLa.setText(this.nLd);
            }
            if (!TextUtils.isEmpty(this.nLc)) {
                c.mS().a(this.nLc, 10, this.nLj, eVar.getUniqueId());
            } else {
                this.nKW.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eNd != null) {
                    this.eNd.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eNe != null) {
                    this.eNe.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nKY.setChecked(!this.nKY.isChecked());
            }
        }
    }

    public a Vi(String str) {
        this.nLc = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Vj */
    public a Bq(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nLf = this.mActivity.getResources().getString(i);
            this.nLg = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nLe = str;
        this.eNe = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nLe = this.mActivity.getResources().getString(i);
            this.eNe = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nLd = this.mActivity.getResources().getString(i);
            this.eNd = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nLd = str;
        this.eNd = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0886a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0886a() {
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
