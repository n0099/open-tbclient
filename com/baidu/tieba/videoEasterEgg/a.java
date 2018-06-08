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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b akC;
    private a.b akD;
    private ImageView gAq;
    private ImageView hgE;
    private ViewGroup hgF;
    private TbCheckBox hgG;
    private TextView hgH;
    private Button hgI;
    private Button hgJ;
    private String hgK;
    private String hgL;
    private String hgM;
    private String hgN;
    private CompoundButton.OnCheckedChangeListener hgO;
    private boolean hgP;
    private TbCheckBox.a hgQ;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hgR;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hgP = false;
        this.hgQ = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hgO != null) {
                    a.this.hgO.onCheckedChanged(null, z);
                }
            }
        };
        this.hgR = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.na()) {
                    a.this.hgE.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hgE.setBackgroundResource(0);
                a.this.hgE.setImageDrawable(null);
                aVar.a(a.this.hgE);
            }
        };
        initContentView();
        ce(1);
        av(false);
        au(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.easter_egg_dialog, (ViewGroup) null);
        this.hgE = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.hgJ = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.hgJ.setOnClickListener(this);
        this.hgI = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.hgI.setOnClickListener(this);
        this.gAq = (ImageView) this.mContentView.findViewById(d.g.close);
        this.gAq.setOnClickListener(this);
        this.hgF = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.hgH = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.hgG = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.hgG.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.hgG.setStatedChangedListener(this.hgQ);
        this.hgG.setTagData(new C0247a());
        this.hgF.setClickable(true);
        this.hgF.setOnClickListener(this);
        w(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.hgP) {
            this.hgP = true;
            super.b(eVar);
            if (!ao.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ao.isEmpty(this.hgN)) {
                this.hgH.setText(this.hgN);
            } else {
                this.hgF.setVisibility(4);
            }
            if (!ao.isEmpty(this.hgM)) {
                this.hgJ.setText(this.hgM);
            }
            if (!ao.isEmpty(this.hgL)) {
                this.hgI.setText(this.hgL);
            }
            if (!TextUtils.isEmpty(this.hgK)) {
                c.ig().a(this.hgK, 10, this.hgR, eVar.getUniqueId());
            } else {
                this.hgE.setImageResource(d.f.frs_luhan_moren_background);
            }
            xb().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.positive_btn) {
                if (this.akC != null) {
                    this.akC.onClick(this);
                }
            } else if (id == d.g.negative_btn) {
                if (this.akD != null) {
                    this.akD.onClick(this);
                }
            } else if (id == d.g.close) {
                dismiss();
            } else if (id == d.g.checkbox_container) {
                this.hgG.setChecked(!this.hgG.isChecked());
            }
        }
    }

    public a vj(String str) {
        this.hgK = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: vk */
    public a dB(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hgN = this.mActivity.getResources().getString(i);
            this.hgO = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hgM = str;
        this.akD = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hgM = this.mActivity.getResources().getString(i);
            this.akD = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hgL = this.mActivity.getResources().getString(i);
            this.akC = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hgL = str;
        this.akC = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0247a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0247a() {
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
