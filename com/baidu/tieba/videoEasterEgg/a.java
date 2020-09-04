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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eeZ;
    private a.b efa;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private ImageView mEa;
    private ViewGroup mEb;
    private TbCheckBox mEc;
    private TextView mEd;
    private Button mEe;
    private Button mEf;
    private String mEg;
    private String mEh;
    private String mEi;
    private String mEj;
    private CompoundButton.OnCheckedChangeListener mEk;
    private boolean mEl;
    private TbCheckBox.a mEm;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mEn;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.mEl = false;
        this.mEm = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.mEk != null) {
                    a.this.mEk.onCheckedChanged(null, z);
                }
            }
        };
        this.mEn = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.mEa.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.mEa.setBackgroundResource(0);
                a.this.mEa.setImageDrawable(null);
                aVar.drawImageTo(a.this.mEa);
            }
        };
        VH();
        nw(1);
        ih(false);
        ig(false);
    }

    private void VH() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.mEa = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.mEf = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.mEf.setOnClickListener(this);
        this.mEe = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.mEe.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.mEb = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.mEd = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.mEc = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.mEc.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.mEc.setStatedChangedListener(this.mEm);
        this.mEc.setTagData(new C0822a());
        this.mEb.setClickable(true);
        this.mEb.setOnClickListener(this);
        aX(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.mEl) {
            this.mEl = true;
            super.b(eVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.mEj)) {
                this.mEd.setText(this.mEj);
            } else {
                this.mEb.setVisibility(4);
            }
            if (!at.isEmpty(this.mEi)) {
                this.mEf.setText(this.mEi);
            }
            if (!at.isEmpty(this.mEh)) {
                this.mEe.setText(this.mEh);
            }
            if (!TextUtils.isEmpty(this.mEg)) {
                c.mM().a(this.mEg, 10, this.mEn, eVar.getUniqueId());
            } else {
                this.mEa.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eeZ != null) {
                    this.eeZ.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.efa != null) {
                    this.efa.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.mEc.setChecked(!this.mEc.isChecked());
            }
        }
    }

    public a Se(String str) {
        this.mEg = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Sf */
    public a zA(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.mEj = this.mActivity.getResources().getString(i);
            this.mEk = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.mEi = str;
        this.efa = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mEi = this.mActivity.getResources().getString(i);
            this.efa = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mEh = this.mActivity.getResources().getString(i);
            this.eeZ = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.mEh = str;
        this.eeZ = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0822a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0822a() {
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
