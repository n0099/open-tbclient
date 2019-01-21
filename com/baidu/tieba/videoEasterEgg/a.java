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
    private a.b awS;
    private a.b awT;
    private ImageView cyg;
    private String hOA;
    private CompoundButton.OnCheckedChangeListener hOB;
    private boolean hOC;
    private TbCheckBox.a hOD;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hOE;
    private ImageView hOr;
    private ViewGroup hOs;
    private TbCheckBox hOt;
    private TextView hOu;
    private Button hOv;
    private Button hOw;
    private String hOx;
    private String hOy;
    private String hOz;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hOC = false;
        this.hOD = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hOB != null) {
                    a.this.hOB.onCheckedChanged(null, z);
                }
            }
        };
        this.hOE = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.ou()) {
                    a.this.hOr.setImageResource(e.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hOr.setBackgroundResource(0);
                a.this.hOr.setImageDrawable(null);
                aVar.a(a.this.hOr);
            }
        };
        bwE();
        dd(1);
        bh(false);
        bg(false);
    }

    private void bwE() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.easter_egg_dialog, (ViewGroup) null);
        this.hOr = (ImageView) this.mContentView.findViewById(e.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(e.g.message);
        this.hOw = (Button) this.mContentView.findViewById(e.g.negative_btn);
        this.hOw.setOnClickListener(this);
        this.hOv = (Button) this.mContentView.findViewById(e.g.positive_btn);
        this.hOv.setOnClickListener(this);
        this.cyg = (ImageView) this.mContentView.findViewById(e.g.close);
        this.cyg.setOnClickListener(this);
        this.hOs = (ViewGroup) this.mContentView.findViewById(e.g.checkbox_container);
        this.hOu = (TextView) this.mContentView.findViewById(e.g.checkbox_text);
        this.hOt = (TbCheckBox) this.mContentView.findViewById(e.g.checkbox);
        this.hOt.setBackgroundDrawableId(e.f.icon_frs_luhan_selct, e.f.icon_frs_luhan_selctguand);
        this.hOt.setStatedChangedListener(this.hOD);
        this.hOt.setTagData(new C0331a());
        this.hOs.setClickable(true);
        this.hOs.setOnClickListener(this);
        G(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(com.baidu.adp.base.e<?> eVar) {
        if (!this.hOC) {
            this.hOC = true;
            super.b(eVar);
            if (!ao.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ao.isEmpty(this.hOA)) {
                this.hOu.setText(this.hOA);
            } else {
                this.hOs.setVisibility(4);
            }
            if (!ao.isEmpty(this.hOz)) {
                this.hOw.setText(this.hOz);
            }
            if (!ao.isEmpty(this.hOy)) {
                this.hOv.setText(this.hOy);
            }
            if (!TextUtils.isEmpty(this.hOx)) {
                c.jA().a(this.hOx, 10, this.hOE, eVar.getUniqueId());
            } else {
                this.hOr.setImageResource(e.f.frs_luhan_moren_background);
            }
            BT().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == e.g.positive_btn) {
                if (this.awS != null) {
                    this.awS.onClick(this);
                }
            } else if (id == e.g.negative_btn) {
                if (this.awT != null) {
                    this.awT.onClick(this);
                }
            } else if (id == e.g.close) {
                dismiss();
            } else if (id == e.g.checkbox_container) {
                this.hOt.setChecked(!this.hOt.isChecked());
            }
        }
    }

    public a xt(String str) {
        this.hOx = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: xu */
    public a eK(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hOA = this.mActivity.getResources().getString(i);
            this.hOB = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hOz = str;
        this.awT = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hOz = this.mActivity.getResources().getString(i);
            this.awT = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hOy = this.mActivity.getResources().getString(i);
            this.awS = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hOy = str;
        this.awS = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0331a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0331a() {
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
