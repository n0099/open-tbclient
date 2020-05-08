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
    private a.b duy;
    private a.b duz;
    private ImageView lqW;
    private ViewGroup lqX;
    private TbCheckBox lqY;
    private TextView lqZ;
    private Button lra;
    private Button lrb;
    private String lrc;
    private String lrd;
    private String lre;
    private String lrf;
    private CompoundButton.OnCheckedChangeListener lrg;
    private boolean lrh;
    private TbCheckBox.a lri;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lrj;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.lrh = false;
        this.lri = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.lrg != null) {
                    a.this.lrg.onCheckedChanged(null, z);
                }
            }
        };
        this.lrj = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.lqW.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.lqW.setBackgroundResource(0);
                a.this.lqW.setImageDrawable(null);
                aVar.drawImageTo(a.this.lqW);
            }
        };
        Me();
        kg(1);
        gF(false);
        gE(false);
    }

    private void Me() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.lqW = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.lrb = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.lrb.setOnClickListener(this);
        this.lra = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.lra.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.lqX = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.lqZ = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.lqY = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.lqY.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.lqY.setStatedChangedListener(this.lri);
        this.lqY.setTagData(new C0690a());
        this.lqX.setClickable(true);
        this.lqX.setOnClickListener(this);
        aP(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.lrh) {
            this.lrh = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.lrf)) {
                this.lqZ.setText(this.lrf);
            } else {
                this.lqX.setVisibility(4);
            }
            if (!aq.isEmpty(this.lre)) {
                this.lrb.setText(this.lre);
            }
            if (!aq.isEmpty(this.lrd)) {
                this.lra.setText(this.lrd);
            }
            if (!TextUtils.isEmpty(this.lrc)) {
                c.kV().a(this.lrc, 10, this.lrj, eVar.getUniqueId());
            } else {
                this.lqW.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.duy != null) {
                    this.duy.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.duz != null) {
                    this.duz.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.lqY.setChecked(!this.lqY.isChecked());
            }
        }
    }

    public a Mh(String str) {
        this.lrc = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Mi */
    public a ui(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.lrf = this.mActivity.getResources().getString(i);
            this.lrg = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.lre = str;
        this.duz = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lre = this.mActivity.getResources().getString(i);
            this.duz = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.lrd = this.mActivity.getResources().getString(i);
            this.duy = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.lrd = str;
        this.duy = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0690a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0690a() {
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
