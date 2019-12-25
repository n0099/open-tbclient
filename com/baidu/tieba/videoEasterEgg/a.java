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
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b cQI;
    private a.b cQJ;
    private String kAa;
    private String kAb;
    private String kAc;
    private CompoundButton.OnCheckedChangeListener kAd;
    private boolean kAe;
    private TbCheckBox.a kAf;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kAg;
    private ImageView kzT;
    private ViewGroup kzU;
    private TbCheckBox kzV;
    private TextView kzW;
    private Button kzX;
    private Button kzY;
    private String kzZ;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.kAe = false;
        this.kAf = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.kAd != null) {
                    a.this.kAd.onCheckedChanged(null, z);
                }
            }
        };
        this.kAg = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.kzT.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.kzT.setBackgroundResource(0);
                a.this.kzT.setImageDrawable(null);
                aVar.drawImageTo(a.this.kzT);
            }
        };
        initContentView();
        jI(1);
        fv(false);
        fu(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.kzT = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.kzY = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.kzY.setOnClickListener(this);
        this.kzX = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.kzX.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.kzU = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.kzW = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.kzV = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.kzV.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.kzV.setStatedChangedListener(this.kAf);
        this.kzV.setTagData(new C0614a());
        this.kzU.setClickable(true);
        this.kzU.setOnClickListener(this);
        aK(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.kAe) {
            this.kAe = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.kAc)) {
                this.kzW.setText(this.kAc);
            } else {
                this.kzU.setVisibility(4);
            }
            if (!aq.isEmpty(this.kAb)) {
                this.kzY.setText(this.kAb);
            }
            if (!aq.isEmpty(this.kAa)) {
                this.kzX.setText(this.kAa);
            }
            if (!TextUtils.isEmpty(this.kzZ)) {
                c.gs().a(this.kzZ, 10, this.kAg, eVar.getUniqueId());
            } else {
                this.kzT.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.cQI != null) {
                    this.cQI.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.cQJ != null) {
                    this.cQJ.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.kzV.setChecked(!this.kzV.isChecked());
            }
        }
    }

    public a JV(String str) {
        this.kzZ = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: JW */
    public a sz(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.kAc = this.mActivity.getResources().getString(i);
            this.kAd = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.kAb = str;
        this.cQJ = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kAb = this.mActivity.getResources().getString(i);
            this.cQJ = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kAa = this.mActivity.getResources().getString(i);
            this.cQI = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.kAa = str;
        this.cQI = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0614a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0614a() {
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
