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
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b asb;
    private a.b asc;
    private ImageView gUv;
    private ImageView hBb;
    private ViewGroup hBc;
    private TbCheckBox hBd;
    private TextView hBe;
    private Button hBf;
    private Button hBg;
    private String hBh;
    private String hBi;
    private String hBj;
    private String hBk;
    private CompoundButton.OnCheckedChangeListener hBl;
    private boolean hBm;
    private TbCheckBox.a hBn;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hBo;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hBm = false;
        this.hBn = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hBl != null) {
                    a.this.hBl.onCheckedChanged(null, z);
                }
            }
        };
        this.hBo = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.ot()) {
                    a.this.hBb.setImageResource(e.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hBb.setBackgroundResource(0);
                a.this.hBb.setImageDrawable(null);
                aVar.a(a.this.hBb);
            }
        };
        btV();
        cB(1);
        aP(false);
        aO(false);
    }

    private void btV() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.easter_egg_dialog, (ViewGroup) null);
        this.hBb = (ImageView) this.mContentView.findViewById(e.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(e.g.message);
        this.hBg = (Button) this.mContentView.findViewById(e.g.negative_btn);
        this.hBg.setOnClickListener(this);
        this.hBf = (Button) this.mContentView.findViewById(e.g.positive_btn);
        this.hBf.setOnClickListener(this);
        this.gUv = (ImageView) this.mContentView.findViewById(e.g.close);
        this.gUv.setOnClickListener(this);
        this.hBc = (ViewGroup) this.mContentView.findViewById(e.g.checkbox_container);
        this.hBe = (TextView) this.mContentView.findViewById(e.g.checkbox_text);
        this.hBd = (TbCheckBox) this.mContentView.findViewById(e.g.checkbox);
        this.hBd.setBackgroundDrawableId(e.f.icon_frs_luhan_selct, e.f.icon_frs_luhan_selctguand);
        this.hBd.setStatedChangedListener(this.hBn);
        this.hBd.setTagData(new C0290a());
        this.hBc.setClickable(true);
        this.hBc.setOnClickListener(this);
        G(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(com.baidu.adp.base.e<?> eVar) {
        if (!this.hBm) {
            this.hBm = true;
            super.b(eVar);
            if (!ao.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ao.isEmpty(this.hBk)) {
                this.hBe.setText(this.hBk);
            } else {
                this.hBc.setVisibility(4);
            }
            if (!ao.isEmpty(this.hBj)) {
                this.hBg.setText(this.hBj);
            }
            if (!ao.isEmpty(this.hBi)) {
                this.hBf.setText(this.hBi);
            }
            if (!TextUtils.isEmpty(this.hBh)) {
                c.jC().a(this.hBh, 10, this.hBo, eVar.getUniqueId());
            } else {
                this.hBb.setImageResource(e.f.frs_luhan_moren_background);
            }
            Av().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == e.g.positive_btn) {
                if (this.asb != null) {
                    this.asb.onClick(this);
                }
            } else if (id == e.g.negative_btn) {
                if (this.asc != null) {
                    this.asc.onClick(this);
                }
            } else if (id == e.g.close) {
                dismiss();
            } else if (id == e.g.checkbox_container) {
                this.hBd.setChecked(!this.hBd.isChecked());
            }
        }
    }

    public a ws(String str) {
        this.hBh = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: wt */
    public a ej(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hBk = this.mActivity.getResources().getString(i);
            this.hBl = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hBj = str;
        this.asc = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hBj = this.mActivity.getResources().getString(i);
            this.asc = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hBi = this.mActivity.getResources().getString(i);
            this.asb = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hBi = str;
        this.asb = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0290a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0290a() {
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
