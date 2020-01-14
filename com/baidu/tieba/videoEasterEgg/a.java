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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b cQS;
    private a.b cQT;
    private ImageView kDA;
    private ViewGroup kDB;
    private TbCheckBox kDC;
    private TextView kDD;
    private Button kDE;
    private Button kDF;
    private String kDG;
    private String kDH;
    private String kDI;
    private String kDJ;
    private CompoundButton.OnCheckedChangeListener kDK;
    private boolean kDL;
    private TbCheckBox.a kDM;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kDN;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.kDL = false;
        this.kDM = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.kDK != null) {
                    a.this.kDK.onCheckedChanged(null, z);
                }
            }
        };
        this.kDN = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.kDA.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.kDA.setBackgroundResource(0);
                a.this.kDA.setImageDrawable(null);
                aVar.drawImageTo(a.this.kDA);
            }
        };
        initContentView();
        jI(1);
        fA(false);
        fz(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.kDA = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.kDF = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.kDF.setOnClickListener(this);
        this.kDE = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.kDE.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.kDB = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.kDD = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.kDC = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.kDC.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.kDC.setStatedChangedListener(this.kDM);
        this.kDC.setTagData(new C0619a());
        this.kDB.setClickable(true);
        this.kDB.setOnClickListener(this);
        aO(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.kDL) {
            this.kDL = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.kDJ)) {
                this.kDD.setText(this.kDJ);
            } else {
                this.kDB.setVisibility(4);
            }
            if (!aq.isEmpty(this.kDI)) {
                this.kDF.setText(this.kDI);
            }
            if (!aq.isEmpty(this.kDH)) {
                this.kDE.setText(this.kDH);
            }
            if (!TextUtils.isEmpty(this.kDG)) {
                c.gr().a(this.kDG, 10, this.kDN, eVar.getUniqueId());
            } else {
                this.kDA.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.cQS != null) {
                    this.cQS.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.cQT != null) {
                    this.cQT.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.kDC.setChecked(!this.kDC.isChecked());
            }
        }
    }

    public a Kf(String str) {
        this.kDG = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Kg */
    public a sC(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.kDJ = this.mActivity.getResources().getString(i);
            this.kDK = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.kDI = str;
        this.cQT = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kDI = this.mActivity.getResources().getString(i);
            this.cQT = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kDH = this.mActivity.getResources().getString(i);
            this.cQS = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.kDH = str;
        this.cQS = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0619a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0619a() {
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
