package com.baidu.tieba.videoEasterEgg;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eUE;
    private a.b eUF;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private Button nTA;
    private String nTB;
    private String nTC;
    private String nTD;
    private String nTE;
    private CompoundButton.OnCheckedChangeListener nTF;
    private boolean nTG;
    private TbCheckBox.a nTH;
    private final c<com.baidu.adp.widget.ImageView.a> nTI;
    private ImageView nTv;
    private ViewGroup nTw;
    private TbCheckBox nTx;
    private TextView nTy;
    private Button nTz;

    public a(Activity activity) {
        super(activity);
        this.nTG = false;
        this.nTH = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nTF != null) {
                    a.this.nTF.onCheckedChanged(null, z);
                }
            }
        };
        this.nTI = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nTv.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nTv.setBackgroundResource(0);
                a.this.nTv.setImageDrawable(null);
                aVar.drawImageTo(a.this.nTv);
            }
        };
        Zl();
        nA(1);
        jG(false);
        jF(false);
    }

    private void Zl() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nTv = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nTA = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nTA.setOnClickListener(this);
        this.nTz = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nTz.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nTw = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nTy = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nTx = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nTx.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nTx.setStatedChangedListener(this.nTH);
        this.nTx.setTagData(new C0893a());
        this.nTw.setClickable(true);
        this.nTw.setOnClickListener(this);
        bn(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        if (!this.nTG) {
            this.nTG = true;
            super.b(fVar);
            if (!au.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!au.isEmpty(this.nTE)) {
                this.nTy.setText(this.nTE);
            } else {
                this.nTw.setVisibility(4);
            }
            if (!au.isEmpty(this.nTD)) {
                this.nTA.setText(this.nTD);
            }
            if (!au.isEmpty(this.nTC)) {
                this.nTz.setText(this.nTC);
            }
            if (!TextUtils.isEmpty(this.nTB)) {
                d.mw().a(this.nTB, 10, this.nTI, fVar.getUniqueId());
            } else {
                this.nTv.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eUE != null) {
                    this.eUE.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eUF != null) {
                    this.eUF.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nTx.setChecked(!this.nTx.isChecked());
            }
        }
    }

    public a UB(String str) {
        this.nTB = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: UC */
    public a Au(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nTE = this.mActivity.getResources().getString(i);
            this.nTF = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nTD = str;
        this.eUF = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nTD = this.mActivity.getResources().getString(i);
            this.eUF = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nTC = this.mActivity.getResources().getString(i);
            this.eUE = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nTC = str;
        this.eUE = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0893a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0893a() {
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
