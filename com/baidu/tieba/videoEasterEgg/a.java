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
    private a.b ceY;
    private a.b ceZ;
    private ImageView jHb;
    private ViewGroup jHc;
    private TbCheckBox jHd;
    private TextView jHe;
    private Button jHf;
    private Button jHg;
    private String jHh;
    private String jHi;
    private String jHj;
    private String jHk;
    private CompoundButton.OnCheckedChangeListener jHl;
    private boolean jHm;
    private TbCheckBox.a jHn;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jHo;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jHm = false;
        this.jHn = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jHl != null) {
                    a.this.jHl.onCheckedChanged(null, z);
                }
            }
        };
        this.jHo = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.jHb.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.jHb.setBackgroundResource(0);
                a.this.jHb.setImageDrawable(null);
                aVar.drawImageTo(a.this.jHb);
            }
        };
        cgy();
        hX(1);
        eh(false);
        eg(false);
    }

    private void cgy() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.jHb = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.jHg = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.jHg.setOnClickListener(this);
        this.jHf = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.jHf.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.jHc = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.jHe = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.jHd = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.jHd.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.jHd.setStatedChangedListener(this.jHn);
        this.jHd.setTagData(new C0535a());
        this.jHc.setClickable(true);
        this.jHc.setOnClickListener(this);
        aM(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jHm) {
            this.jHm = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.jHk)) {
                this.jHe.setText(this.jHk);
            } else {
                this.jHc.setVisibility(4);
            }
            if (!aq.isEmpty(this.jHj)) {
                this.jHg.setText(this.jHj);
            }
            if (!aq.isEmpty(this.jHi)) {
                this.jHf.setText(this.jHi);
            }
            if (!TextUtils.isEmpty(this.jHh)) {
                c.fT().a(this.jHh, 10, this.jHo, eVar.getUniqueId());
            } else {
                this.jHb.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.ceY != null) {
                    this.ceY.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.ceZ != null) {
                    this.ceZ.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.jHd.setChecked(!this.jHd.isChecked());
            }
        }
    }

    public a Fj(String str) {
        this.jHh = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Fk */
    public a nn(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jHk = this.mActivity.getResources().getString(i);
            this.jHl = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jHj = str;
        this.ceZ = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jHj = this.mActivity.getResources().getString(i);
            this.ceZ = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jHi = this.mActivity.getResources().getString(i);
            this.ceY = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jHi = str;
        this.ceY = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0535a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0535a() {
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
