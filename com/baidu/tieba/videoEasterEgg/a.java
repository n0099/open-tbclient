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
    private a.b bMX;
    private a.b bMY;
    private ImageView jDI;
    private ViewGroup jDJ;
    private TbCheckBox jDK;
    private TextView jDL;
    private Button jDM;
    private Button jDN;
    private String jDO;
    private String jDP;
    private String jDQ;
    private String jDR;
    private CompoundButton.OnCheckedChangeListener jDS;
    private boolean jDT;
    private TbCheckBox.a jDU;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jDV;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jDT = false;
        this.jDU = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jDS != null) {
                    a.this.jDS.onCheckedChanged(null, z);
                }
            }
        };
        this.jDV = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.nL()) {
                    a.this.jDI.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.jDI.setBackgroundResource(0);
                a.this.jDI.setImageDrawable(null);
                aVar.a(a.this.jDI);
            }
        };
        cio();
        hx(1);
        dR(false);
        dQ(false);
    }

    private void cio() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.jDI = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.jDN = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.jDN.setOnClickListener(this);
        this.jDM = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.jDM.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.jDJ = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.jDL = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.jDK = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.jDK.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.jDK.setStatedChangedListener(this.jDU);
        this.jDK.setTagData(new C0429a());
        this.jDJ.setClickable(true);
        this.jDJ.setOnClickListener(this);
        aH(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jDT) {
            this.jDT = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.jDR)) {
                this.jDL.setText(this.jDR);
            } else {
                this.jDJ.setVisibility(4);
            }
            if (!aq.isEmpty(this.jDQ)) {
                this.jDN.setText(this.jDQ);
            }
            if (!aq.isEmpty(this.jDP)) {
                this.jDM.setText(this.jDP);
            }
            if (!TextUtils.isEmpty(this.jDO)) {
                c.iE().a(this.jDO, 10, this.jDV, eVar.getUniqueId());
            } else {
                this.jDI.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            agJ().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.positive_btn) {
                if (this.bMX != null) {
                    this.bMX.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.bMY != null) {
                    this.bMY.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.jDK.setChecked(!this.jDK.isChecked());
            }
        }
    }

    public a Gg(String str) {
        this.jDO = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Gh */
    public a mO(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jDR = this.mActivity.getResources().getString(i);
            this.jDS = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jDQ = str;
        this.bMY = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jDQ = this.mActivity.getResources().getString(i);
            this.bMY = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jDP = this.mActivity.getResources().getString(i);
            this.bMX = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jDP = str;
        this.bMX = bVar;
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
