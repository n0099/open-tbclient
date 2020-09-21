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
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b ehn;
    private a.b eho;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView mNL;
    private ViewGroup mNM;
    private TbCheckBox mNN;
    private TextView mNO;
    private Button mNP;
    private Button mNQ;
    private String mNR;
    private String mNS;
    private String mNT;
    private String mNU;
    private CompoundButton.OnCheckedChangeListener mNV;
    private boolean mNW;
    private TbCheckBox.a mNX;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mNY;

    public a(Activity activity) {
        super(activity);
        this.mNW = false;
        this.mNX = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.mNV != null) {
                    a.this.mNV.onCheckedChanged(null, z);
                }
            }
        };
        this.mNY = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.mNL.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.mNL.setBackgroundResource(0);
                a.this.mNL.setImageDrawable(null);
                aVar.drawImageTo(a.this.mNL);
            }
        };
        Wq();
        nH(1);
        ie(false);
        id(false);
    }

    private void Wq() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.mNL = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.mNQ = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.mNQ.setOnClickListener(this);
        this.mNP = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.mNP.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.mNM = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.mNO = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.mNN = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.mNN.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.mNN.setStatedChangedListener(this.mNX);
        this.mNN.setTagData(new C0819a());
        this.mNM.setClickable(true);
        this.mNM.setOnClickListener(this);
        aZ(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.mNW) {
            this.mNW = true;
            super.b(eVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.mNU)) {
                this.mNO.setText(this.mNU);
            } else {
                this.mNM.setVisibility(4);
            }
            if (!at.isEmpty(this.mNT)) {
                this.mNQ.setText(this.mNT);
            }
            if (!at.isEmpty(this.mNS)) {
                this.mNP.setText(this.mNS);
            }
            if (!TextUtils.isEmpty(this.mNR)) {
                c.mR().a(this.mNR, 10, this.mNY, eVar.getUniqueId());
            } else {
                this.mNL.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.ehn != null) {
                    this.ehn.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eho != null) {
                    this.eho.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.mNN.setChecked(!this.mNN.isChecked());
            }
        }
    }

    public a SE(String str) {
        this.mNR = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: SF */
    public a zV(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.mNU = this.mActivity.getResources().getString(i);
            this.mNV = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.mNT = str;
        this.eho = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mNT = this.mActivity.getResources().getString(i);
            this.eho = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.mNS = this.mActivity.getResources().getString(i);
            this.ehn = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.mNS = str;
        this.ehn = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C0819a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0819a() {
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
