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
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eGa;
    private a.b eGb;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView nwV;
    private ViewGroup nwW;
    private TbCheckBox nwX;
    private TextView nwY;
    private Button nwZ;
    private Button nxa;
    private String nxb;
    private String nxc;
    private String nxd;
    private String nxe;
    private CompoundButton.OnCheckedChangeListener nxf;
    private boolean nxg;
    private TbCheckBox.a nxh;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nxi;

    public a(Activity activity) {
        super(activity);
        this.nxg = false;
        this.nxh = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nxf != null) {
                    a.this.nxf.onCheckedChanged(null, z);
                }
            }
        };
        this.nxi = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nwV.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nwV.setBackgroundResource(0);
                a.this.nwV.setImageDrawable(null);
                aVar.drawImageTo(a.this.nwV);
            }
        };
        Xh();
        ov(1);
        iX(false);
        iW(false);
    }

    private void Xh() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nwV = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nxa = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nxa.setOnClickListener(this);
        this.nwZ = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nwZ.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nwW = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nwY = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nwX = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nwX.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nwX.setStatedChangedListener(this.nxh);
        this.nwX.setTagData(new C0870a());
        this.nwW.setClickable(true);
        this.nwW.setOnClickListener(this);
        bg(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.nxg) {
            this.nxg = true;
            super.b(eVar);
            if (!au.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!au.isEmpty(this.nxe)) {
                this.nwY.setText(this.nxe);
            } else {
                this.nwW.setVisibility(4);
            }
            if (!au.isEmpty(this.nxd)) {
                this.nxa.setText(this.nxd);
            }
            if (!au.isEmpty(this.nxc)) {
                this.nwZ.setText(this.nxc);
            }
            if (!TextUtils.isEmpty(this.nxb)) {
                c.mS().a(this.nxb, 10, this.nxi, eVar.getUniqueId());
            } else {
                this.nwV.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            getRealView().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.positive_btn) {
                if (this.eGa != null) {
                    this.eGa.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eGb != null) {
                    this.eGb.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nwX.setChecked(!this.nwX.isChecked());
            }
        }
    }

    public a TT(String str) {
        this.nxb = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: TU */
    public a AJ(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nxe = this.mActivity.getResources().getString(i);
            this.nxf = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nxd = str;
        this.eGb = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nxd = this.mActivity.getResources().getString(i);
            this.eGb = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nxc = this.mActivity.getResources().getString(i);
            this.eGa = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nxc = str;
        this.eGa = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0870a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0870a() {
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
