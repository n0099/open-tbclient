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
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b cUW;
    private a.b cUX;
    private ImageView kEJ;
    private ViewGroup kEK;
    private TbCheckBox kEL;
    private TextView kEM;
    private Button kEN;
    private Button kEO;
    private String kEP;
    private String kEQ;
    private String kER;
    private String kES;
    private CompoundButton.OnCheckedChangeListener kET;
    private boolean kEU;
    private TbCheckBox.a kEV;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kEW;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.kEU = false;
        this.kEV = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.kET != null) {
                    a.this.kET.onCheckedChanged(null, z);
                }
            }
        };
        this.kEW = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.kEJ.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.kEJ.setBackgroundResource(0);
                a.this.kEJ.setImageDrawable(null);
                aVar.drawImageTo(a.this.kEJ);
            }
        };
        initContentView();
        jZ(1);
        fH(false);
        fG(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.kEJ = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.kEO = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.kEO.setOnClickListener(this);
        this.kEN = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.kEN.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.kEK = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.kEM = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.kEL = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.kEL.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.kEL.setStatedChangedListener(this.kEV);
        this.kEL.setTagData(new C0627a());
        this.kEK.setClickable(true);
        this.kEK.setOnClickListener(this);
        aO(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.kEU) {
            this.kEU = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.kES)) {
                this.kEM.setText(this.kES);
            } else {
                this.kEK.setVisibility(4);
            }
            if (!aq.isEmpty(this.kER)) {
                this.kEO.setText(this.kER);
            }
            if (!aq.isEmpty(this.kEQ)) {
                this.kEN.setText(this.kEQ);
            }
            if (!TextUtils.isEmpty(this.kEP)) {
                c.gr().a(this.kEP, 10, this.kEW, eVar.getUniqueId());
            } else {
                this.kEJ.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.cUW != null) {
                    this.cUW.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.cUX != null) {
                    this.cUX.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.kEL.setChecked(!this.kEL.isChecked());
            }
        }
    }

    public a Kt(String str) {
        this.kEP = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Ku */
    public a sS(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.kES = this.mActivity.getResources().getString(i);
            this.kET = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.kER = str;
        this.cUX = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kER = this.mActivity.getResources().getString(i);
            this.cUX = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kEQ = this.mActivity.getResources().getString(i);
            this.cUW = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.kEQ = str;
        this.cUW = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0627a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0627a() {
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
