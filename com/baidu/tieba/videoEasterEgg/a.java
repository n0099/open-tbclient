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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b akA;
    private a.b akB;
    private ImageView gFs;
    private ImageView hlZ;
    private ViewGroup hma;
    private TbCheckBox hmb;
    private TextView hmc;
    private Button hmd;
    private Button hme;
    private String hmf;
    private String hmg;
    private String hmh;
    private String hmi;
    private CompoundButton.OnCheckedChangeListener hmj;
    private boolean hmk;
    private TbCheckBox.a hml;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hmm;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hmk = false;
        this.hml = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hmj != null) {
                    a.this.hmj.onCheckedChanged(null, z);
                }
            }
        };
        this.hmm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.nc()) {
                    a.this.hlZ.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hlZ.setBackgroundResource(0);
                a.this.hlZ.setImageDrawable(null);
                aVar.a(a.this.hlZ);
            }
        };
        bnY();
        ch(1);
        av(false);
        au(false);
    }

    private void bnY() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.h.easter_egg_dialog, (ViewGroup) null);
        this.hlZ = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.hme = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.hme.setOnClickListener(this);
        this.hmd = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.hmd.setOnClickListener(this);
        this.gFs = (ImageView) this.mContentView.findViewById(d.g.close);
        this.gFs.setOnClickListener(this);
        this.hma = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.hmc = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.hmb = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.hmb.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.hmb.setStatedChangedListener(this.hml);
        this.hmb.setTagData(new C0249a());
        this.hma.setClickable(true);
        this.hma.setOnClickListener(this);
        w(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.hmk) {
            this.hmk = true;
            super.b(eVar);
            if (!ap.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ap.isEmpty(this.hmi)) {
                this.hmc.setText(this.hmi);
            } else {
                this.hma.setVisibility(4);
            }
            if (!ap.isEmpty(this.hmh)) {
                this.hme.setText(this.hmh);
            }
            if (!ap.isEmpty(this.hmg)) {
                this.hmd.setText(this.hmg);
            }
            if (!TextUtils.isEmpty(this.hmf)) {
                c.ih().a(this.hmf, 10, this.hmm, eVar.getUniqueId());
            } else {
                this.hlZ.setImageResource(d.f.frs_luhan_moren_background);
            }
            xg().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.positive_btn) {
                if (this.akA != null) {
                    this.akA.onClick(this);
                }
            } else if (id == d.g.negative_btn) {
                if (this.akB != null) {
                    this.akB.onClick(this);
                }
            } else if (id == d.g.close) {
                dismiss();
            } else if (id == d.g.checkbox_container) {
                this.hmb.setChecked(!this.hmb.isChecked());
            }
        }
    }

    public a ve(String str) {
        this.hmf = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: vf */
    public a dB(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hmi = this.mActivity.getResources().getString(i);
            this.hmj = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hmh = str;
        this.akB = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hmh = this.mActivity.getResources().getString(i);
            this.akB = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hmg = this.mActivity.getResources().getString(i);
            this.akA = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hmg = str;
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
