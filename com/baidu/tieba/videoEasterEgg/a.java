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
    private a.b ceh;
    private a.b cei;
    private ImageView jGk;
    private ViewGroup jGl;
    private TbCheckBox jGm;
    private TextView jGn;
    private Button jGo;
    private Button jGp;
    private String jGq;
    private String jGr;
    private String jGs;
    private String jGt;
    private CompoundButton.OnCheckedChangeListener jGu;
    private boolean jGv;
    private TbCheckBox.a jGw;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jGx;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jGv = false;
        this.jGw = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jGu != null) {
                    a.this.jGu.onCheckedChanged(null, z);
                }
            }
        };
        this.jGx = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.jGk.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.jGk.setBackgroundResource(0);
                a.this.jGk.setImageDrawable(null);
                aVar.drawImageTo(a.this.jGk);
            }
        };
        cgw();
        hW(1);
        eh(false);
        eg(false);
    }

    private void cgw() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.jGk = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.jGp = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.jGp.setOnClickListener(this);
        this.jGo = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.jGo.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.jGl = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.jGn = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.jGm = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.jGm.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.jGm.setStatedChangedListener(this.jGw);
        this.jGm.setTagData(new C0535a());
        this.jGl.setClickable(true);
        this.jGl.setOnClickListener(this);
        aM(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jGv) {
            this.jGv = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.jGt)) {
                this.jGn.setText(this.jGt);
            } else {
                this.jGl.setVisibility(4);
            }
            if (!aq.isEmpty(this.jGs)) {
                this.jGp.setText(this.jGs);
            }
            if (!aq.isEmpty(this.jGr)) {
                this.jGo.setText(this.jGr);
            }
            if (!TextUtils.isEmpty(this.jGq)) {
                c.fT().a(this.jGq, 10, this.jGx, eVar.getUniqueId());
            } else {
                this.jGk.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.ceh != null) {
                    this.ceh.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.cei != null) {
                    this.cei.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.jGm.setChecked(!this.jGm.isChecked());
            }
        }
    }

    public a Fj(String str) {
        this.jGq = str;
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
            this.jGt = this.mActivity.getResources().getString(i);
            this.jGu = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jGs = str;
        this.cei = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jGs = this.mActivity.getResources().getString(i);
            this.cei = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jGr = this.mActivity.getResources().getString(i);
            this.ceh = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jGr = str;
        this.ceh = bVar;
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
