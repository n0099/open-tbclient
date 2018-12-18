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
    private a.b awo;
    private a.b awp;
    private ImageView cwp;
    private ImageView hJY;
    private ViewGroup hJZ;
    private TbCheckBox hKa;
    private TextView hKb;
    private Button hKc;
    private Button hKd;
    private String hKe;
    private String hKf;
    private String hKg;
    private String hKh;
    private CompoundButton.OnCheckedChangeListener hKi;
    private boolean hKj;
    private TbCheckBox.a hKk;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hKl;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hKj = false;
        this.hKk = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hKi != null) {
                    a.this.hKi.onCheckedChanged(null, z);
                }
            }
        };
        this.hKl = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.oq()) {
                    a.this.hJY.setImageResource(e.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hJY.setBackgroundResource(0);
                a.this.hJY.setImageDrawable(null);
                aVar.a(a.this.hJY);
            }
        };
        bvj();
        dd(1);
        bg(false);
        bf(false);
    }

    private void bvj() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.easter_egg_dialog, (ViewGroup) null);
        this.hJY = (ImageView) this.mContentView.findViewById(e.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(e.g.message);
        this.hKd = (Button) this.mContentView.findViewById(e.g.negative_btn);
        this.hKd.setOnClickListener(this);
        this.hKc = (Button) this.mContentView.findViewById(e.g.positive_btn);
        this.hKc.setOnClickListener(this);
        this.cwp = (ImageView) this.mContentView.findViewById(e.g.close);
        this.cwp.setOnClickListener(this);
        this.hJZ = (ViewGroup) this.mContentView.findViewById(e.g.checkbox_container);
        this.hKb = (TextView) this.mContentView.findViewById(e.g.checkbox_text);
        this.hKa = (TbCheckBox) this.mContentView.findViewById(e.g.checkbox);
        this.hKa.setBackgroundDrawableId(e.f.icon_frs_luhan_selct, e.f.icon_frs_luhan_selctguand);
        this.hKa.setStatedChangedListener(this.hKk);
        this.hKa.setTagData(new C0332a());
        this.hJZ.setClickable(true);
        this.hJZ.setOnClickListener(this);
        G(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(com.baidu.adp.base.e<?> eVar) {
        if (!this.hKj) {
            this.hKj = true;
            super.b(eVar);
            if (!ao.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ao.isEmpty(this.hKh)) {
                this.hKb.setText(this.hKh);
            } else {
                this.hJZ.setVisibility(4);
            }
            if (!ao.isEmpty(this.hKg)) {
                this.hKd.setText(this.hKg);
            }
            if (!ao.isEmpty(this.hKf)) {
                this.hKc.setText(this.hKf);
            }
            if (!TextUtils.isEmpty(this.hKe)) {
                c.jA().a(this.hKe, 10, this.hKl, eVar.getUniqueId());
            } else {
                this.hJY.setImageResource(e.f.frs_luhan_moren_background);
            }
            BG().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == e.g.positive_btn) {
                if (this.awo != null) {
                    this.awo.onClick(this);
                }
            } else if (id == e.g.negative_btn) {
                if (this.awp != null) {
                    this.awp.onClick(this);
                }
            } else if (id == e.g.close) {
                dismiss();
            } else if (id == e.g.checkbox_container) {
                this.hKa.setChecked(!this.hKa.isChecked());
            }
        }
    }

    public a xa(String str) {
        this.hKe = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: xb */
    public a eB(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hKh = this.mActivity.getResources().getString(i);
            this.hKi = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hKg = str;
        this.awp = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hKg = this.mActivity.getResources().getString(i);
            this.awp = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hKf = this.mActivity.getResources().getString(i);
            this.awo = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hKf = str;
        this.awo = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0332a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0332a() {
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
