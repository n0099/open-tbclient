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
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b bNc;
    private a.b bNd;
    private ImageView jEP;
    private ViewGroup jEQ;
    private TbCheckBox jER;
    private TextView jES;
    private Button jET;
    private Button jEU;
    private String jEV;
    private String jEW;
    private String jEX;
    private String jEY;
    private CompoundButton.OnCheckedChangeListener jEZ;
    private boolean jFa;
    private TbCheckBox.a jFb;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jFc;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jFa = false;
        this.jFb = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jEZ != null) {
                    a.this.jEZ.onCheckedChanged(null, z);
                }
            }
        };
        this.jFc = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.nL()) {
                    a.this.jEP.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.jEP.setBackgroundResource(0);
                a.this.jEP.setImageDrawable(null);
                aVar.a(a.this.jEP);
            }
        };
        ciG();
        hx(1);
        dR(false);
        dQ(false);
    }

    private void ciG() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.jEP = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.jEU = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.jEU.setOnClickListener(this);
        this.jET = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.jET.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.jEQ = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.jES = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.jER = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.jER.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.jER.setStatedChangedListener(this.jFb);
        this.jER.setTagData(new C0429a());
        this.jEQ.setClickable(true);
        this.jEQ.setOnClickListener(this);
        aH(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jFa) {
            this.jFa = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.jEY)) {
                this.jES.setText(this.jEY);
            } else {
                this.jEQ.setVisibility(4);
            }
            if (!aq.isEmpty(this.jEX)) {
                this.jEU.setText(this.jEX);
            }
            if (!aq.isEmpty(this.jEW)) {
                this.jET.setText(this.jEW);
            }
            if (!TextUtils.isEmpty(this.jEV)) {
                c.iE().a(this.jEV, 10, this.jFc, eVar.getUniqueId());
            } else {
                this.jEP.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            agL().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.positive_btn) {
                if (this.bNc != null) {
                    this.bNc.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.bNd != null) {
                    this.bNd.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.jER.setChecked(!this.jER.isChecked());
            }
        }
    }

    public a Gh(String str) {
        this.jEV = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Gi */
    public a mO(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jEY = this.mActivity.getResources().getString(i);
            this.jEZ = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jEX = str;
        this.bNd = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jEX = this.mActivity.getResources().getString(i);
            this.bNd = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jEW = this.mActivity.getResources().getString(i);
            this.bNc = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jEW = str;
        this.bNc = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0429a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0429a() {
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
