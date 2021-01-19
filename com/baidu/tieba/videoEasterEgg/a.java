package com.baidu.tieba.videoEasterEgg;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b eSp;
    private a.b eSq;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView nJO;
    private ViewGroup nJP;
    private TbCheckBox nJQ;
    private TextView nJR;
    private Button nJS;
    private Button nJT;
    private String nJU;
    private String nJV;
    private String nJW;
    private String nJX;
    private CompoundButton.OnCheckedChangeListener nJY;
    private boolean nJZ;
    private TbCheckBox.a nKa;
    private final c<com.baidu.adp.widget.ImageView.a> nKb;

    public a(Activity activity) {
        super(activity);
        this.nJZ = false;
        this.nKa = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nJY != null) {
                    a.this.nJY.onCheckedChanged(null, z);
                }
            }
        };
        this.nKb = new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nJO.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nJO.setBackgroundResource(0);
                a.this.nJO.setImageDrawable(null);
                aVar.drawImageTo(a.this.nJO);
            }
        };
        Xv();
        nx(1);
        jE(false);
        jD(false);
    }

    private void Xv() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nJO = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nJT = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nJT.setOnClickListener(this);
        this.nJS = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nJS.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nJP = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nJR = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nJQ = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nJQ.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nJQ.setStatedChangedListener(this.nKa);
        this.nJQ.setTagData(new C0890a());
        this.nJP.setClickable(true);
        this.nJP.setOnClickListener(this);
        br(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        if (!this.nJZ) {
            this.nJZ = true;
            super.b(fVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.nJX)) {
                this.nJR.setText(this.nJX);
            } else {
                this.nJP.setVisibility(4);
            }
            if (!at.isEmpty(this.nJW)) {
                this.nJT.setText(this.nJW);
            }
            if (!at.isEmpty(this.nJV)) {
                this.nJS.setText(this.nJV);
            }
            if (!TextUtils.isEmpty(this.nJU)) {
                d.mx().a(this.nJU, 10, this.nKb, fVar.getUniqueId());
            } else {
                this.nJO.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eSp != null) {
                    this.eSp.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eSq != null) {
                    this.eSq.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nJQ.setChecked(!this.nJQ.isChecked());
            }
        }
    }

    public a TE(String str) {
        this.nJU = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: TF */
    public a Ad(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nJX = this.mActivity.getResources().getString(i);
            this.nJY = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nJW = str;
        this.eSq = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nJW = this.mActivity.getResources().getString(i);
            this.eSq = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nJV = this.mActivity.getResources().getString(i);
            this.eSp = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nJV = str;
        this.eSp = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0890a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0890a() {
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
