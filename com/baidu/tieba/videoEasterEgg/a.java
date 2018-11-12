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
    private a.b asO;
    private a.b asP;
    private ImageView csw;
    private ImageView hCM;
    private ViewGroup hCN;
    private TbCheckBox hCO;
    private TextView hCP;
    private Button hCQ;
    private Button hCR;
    private String hCS;
    private String hCT;
    private String hCU;
    private String hCV;
    private CompoundButton.OnCheckedChangeListener hCW;
    private boolean hCX;
    private TbCheckBox.a hCY;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hCZ;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hCX = false;
        this.hCY = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hCW != null) {
                    a.this.hCW.onCheckedChanged(null, z);
                }
            }
        };
        this.hCZ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.or()) {
                    a.this.hCM.setImageResource(e.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hCM.setBackgroundResource(0);
                a.this.hCM.setImageDrawable(null);
                aVar.a(a.this.hCM);
            }
        };
        btr();
        cP(1);
        bf(false);
        be(false);
    }

    private void btr() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.easter_egg_dialog, (ViewGroup) null);
        this.hCM = (ImageView) this.mContentView.findViewById(e.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(e.g.message);
        this.hCR = (Button) this.mContentView.findViewById(e.g.negative_btn);
        this.hCR.setOnClickListener(this);
        this.hCQ = (Button) this.mContentView.findViewById(e.g.positive_btn);
        this.hCQ.setOnClickListener(this);
        this.csw = (ImageView) this.mContentView.findViewById(e.g.close);
        this.csw.setOnClickListener(this);
        this.hCN = (ViewGroup) this.mContentView.findViewById(e.g.checkbox_container);
        this.hCP = (TextView) this.mContentView.findViewById(e.g.checkbox_text);
        this.hCO = (TbCheckBox) this.mContentView.findViewById(e.g.checkbox);
        this.hCO.setBackgroundDrawableId(e.f.icon_frs_luhan_selct, e.f.icon_frs_luhan_selctguand);
        this.hCO.setStatedChangedListener(this.hCY);
        this.hCO.setTagData(new C0318a());
        this.hCN.setClickable(true);
        this.hCN.setOnClickListener(this);
        G(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(com.baidu.adp.base.e<?> eVar) {
        if (!this.hCX) {
            this.hCX = true;
            super.b(eVar);
            if (!ao.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ao.isEmpty(this.hCV)) {
                this.hCP.setText(this.hCV);
            } else {
                this.hCN.setVisibility(4);
            }
            if (!ao.isEmpty(this.hCU)) {
                this.hCR.setText(this.hCU);
            }
            if (!ao.isEmpty(this.hCT)) {
                this.hCQ.setText(this.hCT);
            }
            if (!TextUtils.isEmpty(this.hCS)) {
                c.jA().a(this.hCS, 10, this.hCZ, eVar.getUniqueId());
            } else {
                this.hCM.setImageResource(e.f.frs_luhan_moren_background);
            }
            AC().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == e.g.positive_btn) {
                if (this.asO != null) {
                    this.asO.onClick(this);
                }
            } else if (id == e.g.negative_btn) {
                if (this.asP != null) {
                    this.asP.onClick(this);
                }
            } else if (id == e.g.close) {
                dismiss();
            } else if (id == e.g.checkbox_container) {
                this.hCO.setChecked(!this.hCO.isChecked());
            }
        }
    }

    public a wx(String str) {
        this.hCS = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: wy */
    public a ej(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hCV = this.mActivity.getResources().getString(i);
            this.hCW = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hCU = str;
        this.asP = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hCU = this.mActivity.getResources().getString(i);
            this.asP = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hCT = this.mActivity.getResources().getString(i);
            this.asO = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hCT = str;
        this.asO = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0318a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0318a() {
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
