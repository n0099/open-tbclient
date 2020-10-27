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
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eBT;
    private a.b eBU;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView npT;
    private ViewGroup npU;
    private TbCheckBox npV;
    private TextView npW;
    private Button npX;
    private Button npY;
    private String npZ;
    private String nqa;
    private String nqb;
    private String nqc;
    private CompoundButton.OnCheckedChangeListener nqd;
    private boolean nqe;
    private TbCheckBox.a nqf;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nqg;

    public a(Activity activity) {
        super(activity);
        this.nqe = false;
        this.nqf = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nqd != null) {
                    a.this.nqd.onCheckedChanged(null, z);
                }
            }
        };
        this.nqg = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.npT.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.npT.setBackgroundResource(0);
                a.this.npT.setImageDrawable(null);
                aVar.drawImageTo(a.this.npT);
            }
        };
        Vr();
        op(1);
        iN(false);
        iM(false);
    }

    private void Vr() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.npT = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.npY = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.npY.setOnClickListener(this);
        this.npX = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.npX.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.npU = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.npW = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.npV = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.npV.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.npV.setStatedChangedListener(this.nqf);
        this.npV.setTagData(new C0852a());
        this.npU.setClickable(true);
        this.npU.setOnClickListener(this);
        bb(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.nqe) {
            this.nqe = true;
            super.b(eVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.nqc)) {
                this.npW.setText(this.nqc);
            } else {
                this.npU.setVisibility(4);
            }
            if (!at.isEmpty(this.nqb)) {
                this.npY.setText(this.nqb);
            }
            if (!at.isEmpty(this.nqa)) {
                this.npX.setText(this.nqa);
            }
            if (!TextUtils.isEmpty(this.npZ)) {
                c.mS().a(this.npZ, 10, this.nqg, eVar.getUniqueId());
            } else {
                this.npT.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eBT != null) {
                    this.eBT.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eBU != null) {
                    this.eBU.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.npV.setChecked(!this.npV.isChecked());
            }
        }
    }

    public a TR(String str) {
        this.npZ = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: TS */
    public a Ba(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nqc = this.mActivity.getResources().getString(i);
            this.nqd = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nqb = str;
        this.eBU = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nqb = this.mActivity.getResources().getString(i);
            this.eBU = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nqa = this.mActivity.getResources().getString(i);
            this.eBT = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nqa = str;
        this.eBT = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0852a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0852a() {
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
