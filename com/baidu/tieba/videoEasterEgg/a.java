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
    private a.b duu;
    private a.b duv;
    private ImageView lqS;
    private ViewGroup lqT;
    private TbCheckBox lqU;
    private TextView lqV;
    private Button lqW;
    private Button lqX;
    private String lqY;
    private String lqZ;
    private String lra;
    private String lrb;
    private CompoundButton.OnCheckedChangeListener lrc;
    private boolean lrd;
    private TbCheckBox.a lre;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lrf;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.lrd = false;
        this.lre = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.lrc != null) {
                    a.this.lrc.onCheckedChanged(null, z);
                }
            }
        };
        this.lrf = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.lqS.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.lqS.setBackgroundResource(0);
                a.this.lqS.setImageDrawable(null);
                aVar.drawImageTo(a.this.lqS);
            }
        };
        Mf();
        kg(1);
        gF(false);
        gE(false);
    }

    private void Mf() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.lqS = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.lqX = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.lqX.setOnClickListener(this);
        this.lqW = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.lqW.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.lqT = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.lqV = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.lqU = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.lqU.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.lqU.setStatedChangedListener(this.lre);
        this.lqU.setTagData(new C0669a());
        this.lqT.setClickable(true);
        this.lqT.setOnClickListener(this);
        aP(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.lrd) {
            this.lrd = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.lrb)) {
                this.lqV.setText(this.lrb);
            } else {
                this.lqT.setVisibility(4);
            }
            if (!aq.isEmpty(this.lra)) {
                this.lqX.setText(this.lra);
            }
            if (!aq.isEmpty(this.lqZ)) {
                this.lqW.setText(this.lqZ);
            }
            if (!TextUtils.isEmpty(this.lqY)) {
                c.kV().a(this.lqY, 10, this.lrf, eVar.getUniqueId());
            } else {
                this.lqS.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.duu != null) {
                    this.duu.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.duv != null) {
                    this.duv.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.lqU.setChecked(!this.lqU.isChecked());
            }
        }
    }

    public a Me(String str) {
        this.lqY = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Mf */
    public a uf(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.lrb = this.mActivity.getResources().getString(i);
            this.lrc = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.lra = str;
        this.duv = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lra = this.mActivity.getResources().getString(i);
            this.duv = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lqZ = this.mActivity.getResources().getString(i);
            this.duu = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.lqZ = str;
        this.duu = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0669a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0669a() {
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
