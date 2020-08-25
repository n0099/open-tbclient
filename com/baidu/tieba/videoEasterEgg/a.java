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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eeV;
    private a.b eeW;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private ImageView mDI;
    private ViewGroup mDJ;
    private TbCheckBox mDK;
    private TextView mDL;
    private Button mDM;
    private Button mDN;
    private String mDO;
    private String mDP;
    private String mDQ;
    private String mDR;
    private CompoundButton.OnCheckedChangeListener mDS;
    private boolean mDT;
    private TbCheckBox.a mDU;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mDV;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.mDT = false;
        this.mDU = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.mDS != null) {
                    a.this.mDS.onCheckedChanged(null, z);
                }
            }
        };
        this.mDV = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.mDI.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.mDI.setBackgroundResource(0);
                a.this.mDI.setImageDrawable(null);
                aVar.drawImageTo(a.this.mDI);
            }
        };
        VH();
        nw(1);
        ig(false);
        m39if(false);
    }

    private void VH() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.mDI = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.mDN = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.mDN.setOnClickListener(this);
        this.mDM = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.mDM.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.mDJ = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.mDL = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.mDK = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.mDK.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.mDK.setStatedChangedListener(this.mDU);
        this.mDK.setTagData(new C0822a());
        this.mDJ.setClickable(true);
        this.mDJ.setOnClickListener(this);
        aX(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.mDT) {
            this.mDT = true;
            super.b(eVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.mDR)) {
                this.mDL.setText(this.mDR);
            } else {
                this.mDJ.setVisibility(4);
            }
            if (!at.isEmpty(this.mDQ)) {
                this.mDN.setText(this.mDQ);
            }
            if (!at.isEmpty(this.mDP)) {
                this.mDM.setText(this.mDP);
            }
            if (!TextUtils.isEmpty(this.mDO)) {
                c.mM().a(this.mDO, 10, this.mDV, eVar.getUniqueId());
            } else {
                this.mDI.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eeV != null) {
                    this.eeV.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eeW != null) {
                    this.eeW.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.mDK.setChecked(!this.mDK.isChecked());
            }
        }
    }

    public a Se(String str) {
        this.mDO = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Sf */
    public a zz(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.mDR = this.mActivity.getResources().getString(i);
            this.mDS = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.mDQ = str;
        this.eeW = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mDQ = this.mActivity.getResources().getString(i);
            this.eeW = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mDP = this.mActivity.getResources().getString(i);
            this.eeV = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.mDP = str;
        this.eeV = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0822a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0822a() {
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
