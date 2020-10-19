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
    private a.b etu;
    private a.b etv;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private String ndA;
    private CompoundButton.OnCheckedChangeListener ndB;
    private boolean ndC;
    private TbCheckBox.a ndD;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> ndE;
    private ImageView ndr;
    private ViewGroup nds;
    private TbCheckBox ndt;
    private TextView ndu;
    private Button ndv;
    private Button ndw;
    private String ndx;
    private String ndy;
    private String ndz;

    public a(Activity activity) {
        super(activity);
        this.ndC = false;
        this.ndD = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.ndB != null) {
                    a.this.ndB.onCheckedChanged(null, z);
                }
            }
        };
        this.ndE = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.ndr.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.ndr.setBackgroundResource(0);
                a.this.ndr.setImageDrawable(null);
                aVar.drawImageTo(a.this.ndr);
            }
        };
        Yn();
        oe(1);
        iA(false);
        iz(false);
    }

    private void Yn() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.ndr = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.ndw = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.ndw.setOnClickListener(this);
        this.ndv = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.ndv.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nds = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.ndu = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.ndt = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.ndt.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.ndt.setStatedChangedListener(this.ndD);
        this.ndt.setTagData(new C0837a());
        this.nds.setClickable(true);
        this.nds.setOnClickListener(this);
        ba(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.ndC) {
            this.ndC = true;
            super.b(eVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.ndA)) {
                this.ndu.setText(this.ndA);
            } else {
                this.nds.setVisibility(4);
            }
            if (!at.isEmpty(this.ndz)) {
                this.ndw.setText(this.ndz);
            }
            if (!at.isEmpty(this.ndy)) {
                this.ndv.setText(this.ndy);
            }
            if (!TextUtils.isEmpty(this.ndx)) {
                c.mS().a(this.ndx, 10, this.ndE, eVar.getUniqueId());
            } else {
                this.ndr.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.etu != null) {
                    this.etu.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.etv != null) {
                    this.etv.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.ndt.setChecked(!this.ndt.isChecked());
            }
        }
    }

    public a Ts(String str) {
        this.ndx = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Tt */
    public a AH(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.ndA = this.mActivity.getResources().getString(i);
            this.ndB = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.ndz = str;
        this.etv = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.ndz = this.mActivity.getResources().getString(i);
            this.etv = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.ndy = this.mActivity.getResources().getString(i);
            this.etu = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.ndy = str;
        this.etu = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0837a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0837a() {
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
