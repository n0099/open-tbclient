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
    private a.b bNB;
    private a.b bNC;
    private ImageView jHl;
    private ViewGroup jHm;
    private TbCheckBox jHn;
    private TextView jHo;
    private Button jHp;
    private Button jHq;
    private String jHr;
    private String jHs;
    private String jHt;
    private String jHu;
    private CompoundButton.OnCheckedChangeListener jHv;
    private boolean jHw;
    private TbCheckBox.a jHx;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> jHy;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.jHw = false;
        this.jHx = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.jHv != null) {
                    a.this.jHv.onCheckedChanged(null, z);
                }
            }
        };
        this.jHy = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.nL()) {
                    a.this.jHl.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.jHl.setBackgroundResource(0);
                a.this.jHl.setImageDrawable(null);
                aVar.a(a.this.jHl);
            }
        };
        cju();
        hy(1);
        dR(false);
        dQ(false);
    }

    private void cju() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.jHl = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.jHq = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.jHq.setOnClickListener(this);
        this.jHp = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.jHp.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.jHm = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.jHo = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.jHn = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.jHn.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.jHn.setStatedChangedListener(this.jHx);
        this.jHn.setTagData(new C0440a());
        this.jHm.setClickable(true);
        this.jHm.setOnClickListener(this);
        aH(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.jHw) {
            this.jHw = true;
            super.b(eVar);
            if (!aq.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!aq.isEmpty(this.jHu)) {
                this.jHo.setText(this.jHu);
            } else {
                this.jHm.setVisibility(4);
            }
            if (!aq.isEmpty(this.jHt)) {
                this.jHq.setText(this.jHt);
            }
            if (!aq.isEmpty(this.jHs)) {
                this.jHp.setText(this.jHs);
            }
            if (!TextUtils.isEmpty(this.jHr)) {
                c.iE().a(this.jHr, 10, this.jHy, eVar.getUniqueId());
            } else {
                this.jHl.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            agP().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.positive_btn) {
                if (this.bNB != null) {
                    this.bNB.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.bNC != null) {
                    this.bNC.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.jHn.setChecked(!this.jHn.isChecked());
            }
        }
    }

    public a GH(String str) {
        this.jHr = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: GI */
    public a mQ(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.jHu = this.mActivity.getResources().getString(i);
            this.jHv = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.jHt = str;
        this.bNC = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jHt = this.mActivity.getResources().getString(i);
            this.bNC = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.jHs = this.mActivity.getResources().getString(i);
            this.bNB = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.jHs = str;
        this.bNB = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0440a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0440a() {
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
