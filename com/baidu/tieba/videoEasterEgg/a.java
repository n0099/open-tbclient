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
    private ImageView gUc;
    private ViewGroup gUd;
    private TbCheckBox gUe;
    private TextView gUf;
    private Button gUg;
    private Button gUh;
    private String gUi;
    private String gUj;
    private String gUk;
    private String gUl;
    private CompoundButton.OnCheckedChangeListener gUm;
    private boolean gUn;
    private TbCheckBox.a gUo;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> gUp;
    private ImageView gnP;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.gUn = false;
        this.gUo = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.gUm != null) {
                    a.this.gUm.onCheckedChanged(null, z);
                }
            }
        };
        this.gUp = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.kn()) {
                    a.this.gUc.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.gUc.setBackgroundResource(0);
                a.this.gUc.setImageDrawable(null);
                aVar.a(a.this.gUc);
            }
        };
        initContentView();
        cb(1);
        as(false);
        ar(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.easter_egg_dialog, (ViewGroup) null);
        this.gUc = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.gUh = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.gUh.setOnClickListener(this);
        this.gUg = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.gUg.setOnClickListener(this);
        this.gnP = (ImageView) this.mContentView.findViewById(d.g.close);
        this.gnP.setOnClickListener(this);
        this.gUd = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.gUf = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.gUe = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.gUe.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.gUe.setStatedChangedListener(this.gUo);
        this.gUe.setTagData(new C0230a());
        this.gUd.setClickable(true);
        this.gUd.setOnClickListener(this);
        w(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.gUn) {
            this.gUn = true;
            super.b(eVar);
            if (!an.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!an.isEmpty(this.gUl)) {
                this.gUf.setText(this.gUl);
            } else {
                this.gUd.setVisibility(4);
            }
            if (!an.isEmpty(this.gUk)) {
                this.gUh.setText(this.gUk);
            }
            if (!an.isEmpty(this.gUj)) {
                this.gUg.setText(this.gUj);
            }
            if (!TextUtils.isEmpty(this.gUi)) {
                c.fp().a(this.gUi, 10, this.gUp, eVar.getUniqueId());
            } else {
                this.gUc.setImageResource(d.f.frs_luhan_moren_background);
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
                this.gUe.setChecked(!this.gUe.isChecked());
            }
        }
    }

    public a um(String str) {
        this.gUi = str;
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
            this.gUl = this.mActivity.getResources().getString(i);
            this.gUm = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.gUk = str;
        this.acy = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.gUk = this.mActivity.getResources().getString(i);
            this.acy = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.gUj = this.mActivity.getResources().getString(i);
            this.acx = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.gUj = str;
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
