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
    private ImageView nKY;
    private ViewGroup nKZ;
    private TbCheckBox nLa;
    private TextView nLb;
    private Button nLc;
    private Button nLd;
    private String nLe;
    private String nLf;
    private String nLg;
    private String nLh;
    private CompoundButton.OnCheckedChangeListener nLi;
    private boolean nLj;
    private TbCheckBox.a nLk;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nLl;

    public a(Activity activity) {
        super(activity);
        this.nLj = false;
        this.nLk = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nLi != null) {
                    a.this.nLi.onCheckedChanged(null, z);
                }
            }
        };
        this.nLl = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nKY.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nKY.setBackgroundResource(0);
                a.this.nKY.setImageDrawable(null);
                aVar.drawImageTo(a.this.nKY);
            }
        };
        ZG();
        oT(1);
        jm(false);
        jl(false);
    }

    private void ZG() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nKY = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nLd = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nLd.setOnClickListener(this);
        this.nLc = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nLc.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nKZ = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nLb = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nLa = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nLa.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nLa.setStatedChangedListener(this.nLk);
        this.nLa.setTagData(new C0886a());
        this.nKZ.setClickable(true);
        this.nKZ.setOnClickListener(this);
        bi(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.nLj) {
            this.nLj = true;
            super.b(eVar);
            if (!au.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!au.isEmpty(this.nLh)) {
                this.nLb.setText(this.nLh);
            } else {
                this.nKZ.setVisibility(4);
            }
            if (!au.isEmpty(this.nLg)) {
                this.nLd.setText(this.nLg);
            }
            if (!au.isEmpty(this.nLf)) {
                this.nLc.setText(this.nLf);
            }
            if (!TextUtils.isEmpty(this.nLe)) {
                c.mS().a(this.nLe, 10, this.nLl, eVar.getUniqueId());
            } else {
                this.nKY.setImageResource(R.drawable.frs_luhan_moren_background);
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
                this.nLa.setChecked(!this.nLa.isChecked());
            }
        }
    }

    public a Vi(String str) {
        this.nLe = str;
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
            this.nLh = this.mActivity.getResources().getString(i);
            this.nLi = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nLg = str;
        this.eNe = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nLg = this.mActivity.getResources().getString(i);
            this.eNe = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nLf = this.mActivity.getResources().getString(i);
            this.eNd = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nLf = str;
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
