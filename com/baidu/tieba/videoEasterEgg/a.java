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
    private a.b awp;
    private a.b awq;
    private ImageView cxu;
    private ImageView hNj;
    private ViewGroup hNk;
    private TbCheckBox hNl;
    private TextView hNm;
    private Button hNn;
    private Button hNo;
    private String hNp;
    private String hNq;
    private String hNr;
    private String hNs;
    private CompoundButton.OnCheckedChangeListener hNt;
    private boolean hNu;
    private TbCheckBox.a hNv;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hNw;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hNu = false;
        this.hNv = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hNt != null) {
                    a.this.hNt.onCheckedChanged(null, z);
                }
            }
        };
        this.hNw = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.oq()) {
                    a.this.hNj.setImageResource(e.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hNj.setBackgroundResource(0);
                a.this.hNj.setImageDrawable(null);
                aVar.a(a.this.hNj);
            }
        };
        bvV();
        dd(1);
        bg(false);
        bf(false);
    }

    private void bvV() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.easter_egg_dialog, (ViewGroup) null);
        this.hNj = (ImageView) this.mContentView.findViewById(e.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(e.g.message);
        this.hNo = (Button) this.mContentView.findViewById(e.g.negative_btn);
        this.hNo.setOnClickListener(this);
        this.hNn = (Button) this.mContentView.findViewById(e.g.positive_btn);
        this.hNn.setOnClickListener(this);
        this.cxu = (ImageView) this.mContentView.findViewById(e.g.close);
        this.cxu.setOnClickListener(this);
        this.hNk = (ViewGroup) this.mContentView.findViewById(e.g.checkbox_container);
        this.hNm = (TextView) this.mContentView.findViewById(e.g.checkbox_text);
        this.hNl = (TbCheckBox) this.mContentView.findViewById(e.g.checkbox);
        this.hNl.setBackgroundDrawableId(e.f.icon_frs_luhan_selct, e.f.icon_frs_luhan_selctguand);
        this.hNl.setStatedChangedListener(this.hNv);
        this.hNl.setTagData(new C0332a());
        this.hNk.setClickable(true);
        this.hNk.setOnClickListener(this);
        G(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(com.baidu.adp.base.e<?> eVar) {
        if (!this.hNu) {
            this.hNu = true;
            super.b(eVar);
            if (!ao.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ao.isEmpty(this.hNs)) {
                this.hNm.setText(this.hNs);
            } else {
                this.hNk.setVisibility(4);
            }
            if (!ao.isEmpty(this.hNr)) {
                this.hNo.setText(this.hNr);
            }
            if (!ao.isEmpty(this.hNq)) {
                this.hNn.setText(this.hNq);
            }
            if (!TextUtils.isEmpty(this.hNp)) {
                c.jA().a(this.hNp, 10, this.hNw, eVar.getUniqueId());
            } else {
                this.hNj.setImageResource(e.f.frs_luhan_moren_background);
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
                if (this.awp != null) {
                    this.awp.onClick(this);
                }
            } else if (id == e.g.negative_btn) {
                if (this.awq != null) {
                    this.awq.onClick(this);
                }
            } else if (id == e.g.close) {
                dismiss();
            } else if (id == e.g.checkbox_container) {
                this.hNl.setChecked(!this.hNl.isChecked());
            }
        }
    }

    public a xd(String str) {
        this.hNp = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: xe */
    public a eB(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hNs = this.mActivity.getResources().getString(i);
            this.hNt = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hNr = str;
        this.awq = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hNr = this.mActivity.getResources().getString(i);
            this.awq = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hNq = this.mActivity.getResources().getString(i);
            this.awp = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hNq = str;
        this.awp = bVar;
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
