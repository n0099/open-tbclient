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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b dVv;
    private a.b dVw;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView mlT;
    private ViewGroup mlU;
    private TbCheckBox mlV;
    private TextView mlW;
    private Button mlX;
    private Button mlY;
    private String mlZ;
    private String mma;
    private String mmb;
    private String mmc;
    private CompoundButton.OnCheckedChangeListener mmd;
    private boolean mme;
    private TbCheckBox.a mmf;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mmg;

    public a(Activity activity) {
        super(activity);
        this.mme = false;
        this.mmf = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.mmd != null) {
                    a.this.mmd.onCheckedChanged(null, z);
                }
            }
        };
        this.mmg = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.mlT.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.mlT.setBackgroundResource(0);
                a.this.mlT.setImageDrawable(null);
                aVar.drawImageTo(a.this.mlT);
            }
        };
        PM();
        lq(1);
        hK(false);
        hJ(false);
    }

    private void PM() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.mlT = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.mlY = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.mlY.setOnClickListener(this);
        this.mlX = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.mlX.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.mlU = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.mlW = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.mlV = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.mlV.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.mlV.setStatedChangedListener(this.mmf);
        this.mlV.setTagData(new C0770a());
        this.mlU.setClickable(true);
        this.mlU.setOnClickListener(this);
        aV(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.mme) {
            this.mme = true;
            super.b(eVar);
            if (!as.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!as.isEmpty(this.mmc)) {
                this.mlW.setText(this.mmc);
            } else {
                this.mlU.setVisibility(4);
            }
            if (!as.isEmpty(this.mmb)) {
                this.mlY.setText(this.mmb);
            }
            if (!as.isEmpty(this.mma)) {
                this.mlX.setText(this.mma);
            }
            if (!TextUtils.isEmpty(this.mlZ)) {
                c.ln().a(this.mlZ, 10, this.mmg, eVar.getUniqueId());
            } else {
                this.mlT.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.dVv != null) {
                    this.dVv.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.dVw != null) {
                    this.dVw.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.mlV.setChecked(!this.mlV.isChecked());
            }
        }
    }

    public a Pg(String str) {
        this.mlZ = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Ph */
    public a xl(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.mmc = this.mActivity.getResources().getString(i);
            this.mmd = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.mmb = str;
        this.dVw = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mmb = this.mActivity.getResources().getString(i);
            this.dVw = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mma = this.mActivity.getResources().getString(i);
            this.dVv = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.mma = str;
        this.dVv = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0770a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0770a() {
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
