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
    private a.b acy;
    private a.b acz;
    private ImageView gVd;
    private ViewGroup gVe;
    private TbCheckBox gVf;
    private TextView gVg;
    private Button gVh;
    private Button gVi;
    private String gVj;
    private String gVk;
    private String gVl;
    private String gVm;
    private CompoundButton.OnCheckedChangeListener gVn;
    private boolean gVo;
    private TbCheckBox.a gVp;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> gVq;
    private ImageView goS;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.gVo = false;
        this.gVp = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.gVn != null) {
                    a.this.gVn.onCheckedChanged(null, z);
                }
            }
        };
        this.gVq = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.km()) {
                    a.this.gVd.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.gVd.setBackgroundResource(0);
                a.this.gVd.setImageDrawable(null);
                aVar.a(a.this.gVd);
            }
        };
        initContentView();
        cc(1);
        as(false);
        ar(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.easter_egg_dialog, (ViewGroup) null);
        this.gVd = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.gVi = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.gVi.setOnClickListener(this);
        this.gVh = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.gVh.setOnClickListener(this);
        this.goS = (ImageView) this.mContentView.findViewById(d.g.close);
        this.goS.setOnClickListener(this);
        this.gVe = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.gVg = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.gVf = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.gVf.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.gVf.setStatedChangedListener(this.gVp);
        this.gVf.setTagData(new C0230a());
        this.gVe.setClickable(true);
        this.gVe.setOnClickListener(this);
        w(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.gVo) {
            this.gVo = true;
            super.b(eVar);
            if (!an.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!an.isEmpty(this.gVm)) {
                this.gVg.setText(this.gVm);
            } else {
                this.gVe.setVisibility(4);
            }
            if (!an.isEmpty(this.gVl)) {
                this.gVi.setText(this.gVl);
            }
            if (!an.isEmpty(this.gVk)) {
                this.gVh.setText(this.gVk);
            }
            if (!TextUtils.isEmpty(this.gVj)) {
                c.fp().a(this.gVj, 10, this.gVq, eVar.getUniqueId());
            } else {
                this.gVd.setImageResource(d.f.frs_luhan_moren_background);
            }
            tD().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            int id = view2.getId();
            if (id == d.g.positive_btn) {
                if (this.acy != null) {
                    this.acy.onClick(this);
                }
            } else if (id == d.g.negative_btn) {
                if (this.acz != null) {
                    this.acz.onClick(this);
                }
            } else if (id == d.g.close) {
                dismiss();
            } else if (id == d.g.checkbox_container) {
                this.gVf.setChecked(!this.gVf.isChecked());
            }
        }
    }

    public a up(String str) {
        this.gVj = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: uq */
    public a dc(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.gVm = this.mActivity.getResources().getString(i);
            this.gVn = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.gVl = str;
        this.acz = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.gVl = this.mActivity.getResources().getString(i);
            this.acz = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.gVk = this.mActivity.getResources().getString(i);
            this.acy = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.gVk = str;
        this.acy = bVar;
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
