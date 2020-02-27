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
    private a.b cUU;
    private a.b cUV;
    private Button kEA;
    private String kEB;
    private String kEC;
    private String kED;
    private String kEE;
    private CompoundButton.OnCheckedChangeListener kEF;
    private boolean kEG;
    private TbCheckBox.a kEH;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kEI;
    private ImageView kEv;
    private ViewGroup kEw;
    private TbCheckBox kEx;
    private TextView kEy;
    private Button kEz;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.kEG = false;
        this.kEH = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.kEF != null) {
                    a.this.kEF.onCheckedChanged(null, z);
                }
            }
        };
        this.kEI = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.kEv.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.kEv.setBackgroundResource(0);
                a.this.kEv.setImageDrawable(null);
                aVar.drawImageTo(a.this.kEv);
            }
        };
        initContentView();
        jZ(1);
        fH(false);
        fG(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.kEv = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.kEA = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.kEA.setOnClickListener(this);
        this.kEz = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.kEz.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.kEw = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.kEy = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.kEx = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.kEx.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.kEx.setStatedChangedListener(this.kEH);
        this.kEx.setTagData(new C0627a());
        this.kEw.setClickable(true);
        this.kEw.setOnClickListener(this);
        aO(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.kEG) {
            this.kEG = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.kEE)) {
                this.kEy.setText(this.kEE);
            } else {
                this.kEw.setVisibility(4);
            }
            if (!aq.isEmpty(this.kED)) {
                this.kEA.setText(this.kED);
            }
            if (!aq.isEmpty(this.kEC)) {
                this.kEz.setText(this.kEC);
            }
            if (!TextUtils.isEmpty(this.kEB)) {
                c.gr().a(this.kEB, 10, this.kEI, eVar.getUniqueId());
            } else {
                this.kEv.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.cUU != null) {
                    this.cUU.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.cUV != null) {
                    this.cUV.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.kEx.setChecked(!this.kEx.isChecked());
            }
        }
    }

    public a Ks(String str) {
        this.kEB = str;
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
            this.kEE = this.mActivity.getResources().getString(i);
            this.kEF = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.kED = str;
        this.cUV = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kED = this.mActivity.getResources().getString(i);
            this.cUV = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kEC = this.mActivity.getResources().getString(i);
            this.cUU = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.kEC = str;
        this.cUU = bVar;
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
