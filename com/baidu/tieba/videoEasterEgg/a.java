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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b acx;
    private a.b acy;
    private ImageView gTZ;
    private ViewGroup gUa;
    private TbCheckBox gUb;
    private TextView gUc;
    private Button gUd;
    private Button gUe;
    private String gUf;
    private String gUg;
    private String gUh;
    private String gUi;
    private CompoundButton.OnCheckedChangeListener gUj;
    private boolean gUk;
    private TbCheckBox.a gUl;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> gUm;
    private ImageView gnM;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.gUk = false;
        this.gUl = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.gUj != null) {
                    a.this.gUj.onCheckedChanged(null, z);
                }
            }
        };
        this.gUm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.kn()) {
                    a.this.gTZ.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.gTZ.setBackgroundResource(0);
                a.this.gTZ.setImageDrawable(null);
                aVar.a(a.this.gTZ);
            }
        };
        initContentView();
        cb(1);
        as(false);
        ar(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.easter_egg_dialog, (ViewGroup) null);
        this.gTZ = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.gUe = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.gUe.setOnClickListener(this);
        this.gUd = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.gUd.setOnClickListener(this);
        this.gnM = (ImageView) this.mContentView.findViewById(d.g.close);
        this.gnM.setOnClickListener(this);
        this.gUa = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.gUc = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.gUb = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.gUb.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.gUb.setStatedChangedListener(this.gUl);
        this.gUb.setTagData(new C0230a());
        this.gUa.setClickable(true);
        this.gUa.setOnClickListener(this);
        w(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.gUk) {
            this.gUk = true;
            super.b(eVar);
            if (!an.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!an.isEmpty(this.gUi)) {
                this.gUc.setText(this.gUi);
            } else {
                this.gUa.setVisibility(4);
            }
            if (!an.isEmpty(this.gUh)) {
                this.gUe.setText(this.gUh);
            }
            if (!an.isEmpty(this.gUg)) {
                this.gUd.setText(this.gUg);
            }
            if (!TextUtils.isEmpty(this.gUf)) {
                c.fp().a(this.gUf, 10, this.gUm, eVar.getUniqueId());
            } else {
                this.gTZ.setImageResource(d.f.frs_luhan_moren_background);
            }
            tE().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            int id = view2.getId();
            if (id == d.g.positive_btn) {
                if (this.acx != null) {
                    this.acx.onClick(this);
                }
            } else if (id == d.g.negative_btn) {
                if (this.acy != null) {
                    this.acy.onClick(this);
                }
            } else if (id == d.g.close) {
                dismiss();
            } else if (id == d.g.checkbox_container) {
                this.gUb.setChecked(!this.gUb.isChecked());
            }
        }
    }

    public a um(String str) {
        this.gUf = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: un */
    public a dc(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.gUi = this.mActivity.getResources().getString(i);
            this.gUj = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.gUh = str;
        this.acy = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.gUh = this.mActivity.getResources().getString(i);
            this.acy = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.gUg = this.mActivity.getResources().getString(i);
            this.acx = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.gUg = str;
        this.acx = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0230a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0230a() {
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
