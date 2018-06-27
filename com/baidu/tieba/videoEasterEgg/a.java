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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b alb;
    private a.b alc;
    private ImageView gEj;
    private ImageView hkL;
    private ViewGroup hkM;
    private TbCheckBox hkN;
    private TextView hkO;
    private Button hkP;
    private Button hkQ;
    private String hkR;
    private String hkS;
    private String hkT;
    private String hkU;
    private CompoundButton.OnCheckedChangeListener hkV;
    private boolean hkW;
    private TbCheckBox.a hkX;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> hkY;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hkW = false;
        this.hkX = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.hkV != null) {
                    a.this.hkV.onCheckedChanged(null, z);
                }
            }
        };
        this.hkY = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.na()) {
                    a.this.hkL.setImageResource(d.f.frs_luhan_moren_background);
                    return;
                }
                a.this.hkL.setBackgroundResource(0);
                a.this.hkL.setImageDrawable(null);
                aVar.a(a.this.hkL);
            }
        };
        initContentView();
        cf(1);
        ax(false);
        aw(false);
    }

    private void initContentView() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(d.i.easter_egg_dialog, (ViewGroup) null);
        this.hkL = (ImageView) this.mContentView.findViewById(d.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(d.g.message);
        this.hkQ = (Button) this.mContentView.findViewById(d.g.negative_btn);
        this.hkQ.setOnClickListener(this);
        this.hkP = (Button) this.mContentView.findViewById(d.g.positive_btn);
        this.hkP.setOnClickListener(this);
        this.gEj = (ImageView) this.mContentView.findViewById(d.g.close);
        this.gEj.setOnClickListener(this);
        this.hkM = (ViewGroup) this.mContentView.findViewById(d.g.checkbox_container);
        this.hkO = (TextView) this.mContentView.findViewById(d.g.checkbox_text);
        this.hkN = (TbCheckBox) this.mContentView.findViewById(d.g.checkbox);
        this.hkN.setBackgroundDrawableId(d.f.icon_frs_luhan_selct, d.f.icon_frs_luhan_selctguand);
        this.hkN.setStatedChangedListener(this.hkX);
        this.hkN.setTagData(new C0249a());
        this.hkM.setClickable(true);
        this.hkM.setOnClickListener(this);
        w(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.hkW) {
            this.hkW = true;
            super.b(eVar);
            if (!ap.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ap.isEmpty(this.hkU)) {
                this.hkO.setText(this.hkU);
            } else {
                this.hkM.setVisibility(4);
            }
            if (!ap.isEmpty(this.hkT)) {
                this.hkQ.setText(this.hkT);
            }
            if (!ap.isEmpty(this.hkS)) {
                this.hkP.setText(this.hkS);
            }
            if (!TextUtils.isEmpty(this.hkR)) {
                c.ig().a(this.hkR, 10, this.hkY, eVar.getUniqueId());
            } else {
                this.hkL.setImageResource(d.f.frs_luhan_moren_background);
            }
            xo().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.positive_btn) {
                if (this.alb != null) {
                    this.alb.onClick(this);
                }
            } else if (id == d.g.negative_btn) {
                if (this.alc != null) {
                    this.alc.onClick(this);
                }
            } else if (id == d.g.close) {
                dismiss();
            } else if (id == d.g.checkbox_container) {
                this.hkN.setChecked(!this.hkN.isChecked());
            }
        }
    }

    public a vf(String str) {
        this.hkR = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: vg */
    public a dE(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.hkU = this.mActivity.getResources().getString(i);
            this.hkV = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.hkT = str;
        this.alc = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hkT = this.mActivity.getResources().getString(i);
            this.alc = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.hkS = this.mActivity.getResources().getString(i);
            this.alb = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.hkS = str;
        this.alb = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0249a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0249a() {
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
