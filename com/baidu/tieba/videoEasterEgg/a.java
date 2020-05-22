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
    private a.b dIt;
    private a.b dIu;
    private ImageView lJB;
    private ViewGroup lJC;
    private TbCheckBox lJD;
    private TextView lJE;
    private Button lJF;
    private Button lJG;
    private String lJH;
    private String lJI;
    private String lJJ;
    private String lJK;
    private CompoundButton.OnCheckedChangeListener lJL;
    private boolean lJM;
    private TbCheckBox.a lJN;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lJO;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.lJM = false;
        this.lJN = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.lJL != null) {
                    a.this.lJL.onCheckedChanged(null, z);
                }
            }
        };
        this.lJO = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.lJB.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.lJB.setBackgroundResource(0);
                a.this.lJB.setImageDrawable(null);
                aVar.drawImageTo(a.this.lJB);
            }
        };
        Or();
        kG(1);
        gX(false);
        gW(false);
    }

    private void Or() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.lJB = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.lJG = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.lJG.setOnClickListener(this);
        this.lJF = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.lJF.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.lJC = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.lJE = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.lJD = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.lJD.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.lJD.setStatedChangedListener(this.lJN);
        this.lJD.setTagData(new C0743a());
        this.lJC.setClickable(true);
        this.lJC.setOnClickListener(this);
        aP(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.lJM) {
            this.lJM = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.lJK)) {
                this.lJE.setText(this.lJK);
            } else {
                this.lJC.setVisibility(4);
            }
            if (!aq.isEmpty(this.lJJ)) {
                this.lJG.setText(this.lJJ);
            }
            if (!aq.isEmpty(this.lJI)) {
                this.lJF.setText(this.lJI);
            }
            if (!TextUtils.isEmpty(this.lJH)) {
                c.kX().a(this.lJH, 10, this.lJO, eVar.getUniqueId());
            } else {
                this.lJB.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.dIt != null) {
                    this.dIt.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.dIu != null) {
                    this.dIu.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.lJD.setChecked(!this.lJD.isChecked());
            }
        }
    }

    public a NU(String str) {
        this.lJH = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: NV */
    public a vO(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.lJK = this.mActivity.getResources().getString(i);
            this.lJL = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.lJJ = str;
        this.dIu = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lJJ = this.mActivity.getResources().getString(i);
            this.dIu = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lJI = this.mActivity.getResources().getString(i);
            this.dIt = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.lJI = str;
        this.dIt = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0743a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0743a() {
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
