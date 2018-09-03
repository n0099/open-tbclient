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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b akA;
    private a.b akB;
    private ImageView gFv;
    private ImageView hma;
    private ViewGroup hmb;
    private TbCheckBox hmc;
    private TextView hmd;
    private Button hme;
    private Button hmf;
    private String hmg;
    private String hmh;
    private String hmi;
    private String hmj;
    private CompoundButton.OnCheckedChangeListener hmk;
    private boolean hml;
    private TbCheckBox.a hmm;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hmn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hml = false;
        this.hmm = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hmk != null) {
                    a.this.hmk.onCheckedChanged(null, z);
                }
            }
        };
        this.hmn = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.nc()) {
                    a.this.hma.setImageResource(f.C0146f.frs_luhan_moren_background);
                    return;
                }
                a.this.hma.setBackgroundResource(0);
                a.this.hma.setImageDrawable(null);
                aVar.a(a.this.hma);
            }
        };
        bnZ();
        ch(1);
        aw(false);
        av(false);
    }

    private void bnZ() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(f.h.easter_egg_dialog, (ViewGroup) null);
        this.hma = (ImageView) this.mContentView.findViewById(f.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(f.g.message);
        this.hmf = (Button) this.mContentView.findViewById(f.g.negative_btn);
        this.hmf.setOnClickListener(this);
        this.hme = (Button) this.mContentView.findViewById(f.g.positive_btn);
        this.hme.setOnClickListener(this);
        this.gFv = (ImageView) this.mContentView.findViewById(f.g.close);
        this.gFv.setOnClickListener(this);
        this.hmb = (ViewGroup) this.mContentView.findViewById(f.g.checkbox_container);
        this.hmd = (TextView) this.mContentView.findViewById(f.g.checkbox_text);
        this.hmc = (TbCheckBox) this.mContentView.findViewById(f.g.checkbox);
        this.hmc.setBackgroundDrawableId(f.C0146f.icon_frs_luhan_selct, f.C0146f.icon_frs_luhan_selctguand);
        this.hmc.setStatedChangedListener(this.hmm);
        this.hmc.setTagData(new C0249a());
        this.hmb.setClickable(true);
        this.hmb.setOnClickListener(this);
        w(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.hml) {
            this.hml = true;
            super.b(eVar);
            if (!ap.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ap.isEmpty(this.hmj)) {
                this.hmd.setText(this.hmj);
            } else {
                this.hmb.setVisibility(4);
            }
            if (!ap.isEmpty(this.hmi)) {
                this.hmf.setText(this.hmi);
            }
            if (!ap.isEmpty(this.hmh)) {
                this.hme.setText(this.hmh);
            }
            if (!TextUtils.isEmpty(this.hmg)) {
                c.ih().a(this.hmg, 10, this.hmn, eVar.getUniqueId());
            } else {
                this.hma.setImageResource(f.C0146f.frs_luhan_moren_background);
            }
            xf().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == f.g.positive_btn) {
                if (this.akA != null) {
                    this.akA.onClick(this);
                }
            } else if (id == f.g.negative_btn) {
                if (this.akB != null) {
                    this.akB.onClick(this);
                }
            } else if (id == f.g.close) {
                dismiss();
            } else if (id == f.g.checkbox_container) {
                this.hmc.setChecked(!this.hmc.isChecked());
            }
        }
    }

    public a vi(String str) {
        this.hmg = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: vj */
    public a dB(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hmj = this.mActivity.getResources().getString(i);
            this.hmk = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hmi = str;
        this.akB = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hmi = this.mActivity.getResources().getString(i);
            this.akB = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hmh = this.mActivity.getResources().getString(i);
            this.akA = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hmh = str;
        this.akA = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0249a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0249a() {
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
