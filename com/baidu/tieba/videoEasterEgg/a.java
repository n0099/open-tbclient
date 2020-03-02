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
    private a.b cUV;
    private a.b cUW;
    private TextView kEA;
    private Button kEB;
    private Button kEC;
    private String kED;
    private String kEE;
    private String kEF;
    private String kEG;
    private CompoundButton.OnCheckedChangeListener kEH;
    private boolean kEI;
    private TbCheckBox.a kEJ;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kEK;
    private ImageView kEx;
    private ViewGroup kEy;
    private TbCheckBox kEz;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.kEI = false;
        this.kEJ = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.kEH != null) {
                    a.this.kEH.onCheckedChanged(null, z);
                }
            }
        };
        this.kEK = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.kEx.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.kEx.setBackgroundResource(0);
                a.this.kEx.setImageDrawable(null);
                aVar.drawImageTo(a.this.kEx);
            }
        };
        initContentView();
        jZ(1);
        fH(false);
        fG(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.kEx = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.kEC = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.kEC.setOnClickListener(this);
        this.kEB = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.kEB.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.kEy = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.kEA = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.kEz = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.kEz.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.kEz.setStatedChangedListener(this.kEJ);
        this.kEz.setTagData(new C0627a());
        this.kEy.setClickable(true);
        this.kEy.setOnClickListener(this);
        aO(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.kEI) {
            this.kEI = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.kEG)) {
                this.kEA.setText(this.kEG);
            } else {
                this.kEy.setVisibility(4);
            }
            if (!aq.isEmpty(this.kEF)) {
                this.kEC.setText(this.kEF);
            }
            if (!aq.isEmpty(this.kEE)) {
                this.kEB.setText(this.kEE);
            }
            if (!TextUtils.isEmpty(this.kED)) {
                c.gr().a(this.kED, 10, this.kEK, eVar.getUniqueId());
            } else {
                this.kEx.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.cUV != null) {
                    this.cUV.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.cUW != null) {
                    this.cUW.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.kEz.setChecked(!this.kEz.isChecked());
            }
        }
    }

    public a Ks(String str) {
        this.kED = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Kt */
    public a sS(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.kEG = this.mActivity.getResources().getString(i);
            this.kEH = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.kEF = str;
        this.cUW = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kEF = this.mActivity.getResources().getString(i);
            this.cUW = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kEE = this.mActivity.getResources().getString(i);
            this.cUV = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.kEE = str;
        this.cUV = bVar;
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
