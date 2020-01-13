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
    private Button kDA;
    private String kDB;
    private String kDC;
    private String kDD;
    private String kDE;
    private CompoundButton.OnCheckedChangeListener kDF;
    private boolean kDG;
    private TbCheckBox.a kDH;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> kDI;
    private ImageView kDv;
    private ViewGroup kDw;
    private TbCheckBox kDx;
    private TextView kDy;
    private Button kDz;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.kDG = false;
        this.kDH = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.kDF != null) {
                    a.this.kDF.onCheckedChanged(null, z);
                }
            }
        };
        this.kDI = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.kDv.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.kDv.setBackgroundResource(0);
                a.this.kDv.setImageDrawable(null);
                aVar.drawImageTo(a.this.kDv);
            }
        };
        initContentView();
        jI(1);
        fA(false);
        fz(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.kDv = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.kDA = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.kDA.setOnClickListener(this);
        this.kDz = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.kDz.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.kDw = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.kDy = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.kDx = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.kDx.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.kDx.setStatedChangedListener(this.kDH);
        this.kDx.setTagData(new C0619a());
        this.kDw.setClickable(true);
        this.kDw.setOnClickListener(this);
        aO(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.kDG) {
            this.kDG = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.kDE)) {
                this.kDy.setText(this.kDE);
            } else {
                this.kDw.setVisibility(4);
            }
            if (!aq.isEmpty(this.kDD)) {
                this.kDA.setText(this.kDD);
            }
            if (!aq.isEmpty(this.kDC)) {
                this.kDz.setText(this.kDC);
            }
            if (!TextUtils.isEmpty(this.kDB)) {
                c.gr().a(this.kDB, 10, this.kDI, eVar.getUniqueId());
            } else {
                this.kDv.setImageResource(R.drawable.frs_luhan_moren_background);
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
                this.kDx.setChecked(!this.kDx.isChecked());
            }
        }
    }

    public a Kf(String str) {
        this.kDB = str;
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
            this.kDE = this.mActivity.getResources().getString(i);
            this.kDF = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.kDD = str;
        this.cQT = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kDD = this.mActivity.getResources().getString(i);
            this.cQT = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.kDC = this.mActivity.getResources().getString(i);
            this.cQS = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.kDC = str;
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
