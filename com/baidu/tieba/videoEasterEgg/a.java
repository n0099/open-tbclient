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
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.core.dialog.a implements View.OnClickListener {
    private a.b ang;
    private a.b anh;
    private ImageView gMY;
    private ImageView htP;
    private ViewGroup htQ;
    private TbCheckBox htR;
    private TextView htS;
    private Button htT;
    private Button htU;
    private String htV;
    private String htW;
    private String htX;
    private String htY;
    private CompoundButton.OnCheckedChangeListener htZ;
    private boolean hua;
    private TbCheckBox.a hub;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> huc;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;

    public a(Activity activity) {
        super(activity);
        this.hua = false;
        this.hub = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.htZ != null) {
                    a.this.htZ.onCheckedChanged(null, z);
                }
            }
        };
        this.huc = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.oi()) {
                    a.this.htP.setImageResource(e.f.frs_luhan_moren_background);
                    return;
                }
                a.this.htP.setBackgroundResource(0);
                a.this.htP.setImageDrawable(null);
                aVar.a(a.this.htP);
            }
        };
        bqG();
        cr(1);
        aF(false);
        aE(false);
    }

    private void bqG() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(e.h.easter_egg_dialog, (ViewGroup) null);
        this.htP = (ImageView) this.mContentView.findViewById(e.g.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(e.g.message);
        this.htU = (Button) this.mContentView.findViewById(e.g.negative_btn);
        this.htU.setOnClickListener(this);
        this.htT = (Button) this.mContentView.findViewById(e.g.positive_btn);
        this.htT.setOnClickListener(this);
        this.gMY = (ImageView) this.mContentView.findViewById(e.g.close);
        this.gMY.setOnClickListener(this);
        this.htQ = (ViewGroup) this.mContentView.findViewById(e.g.checkbox_container);
        this.htS = (TextView) this.mContentView.findViewById(e.g.checkbox_text);
        this.htR = (TbCheckBox) this.mContentView.findViewById(e.g.checkbox);
        this.htR.setBackgroundDrawableId(e.f.icon_frs_luhan_selct, e.f.icon_frs_luhan_selctguand);
        this.htR.setStatedChangedListener(this.hub);
        this.htR.setTagData(new C0255a());
        this.htQ.setClickable(true);
        this.htQ.setOnClickListener(this);
        G(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(com.baidu.adp.base.e<?> eVar) {
        if (!this.hua) {
            this.hua = true;
            super.b(eVar);
            if (!ao.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!ao.isEmpty(this.htY)) {
                this.htS.setText(this.htY);
            } else {
                this.htQ.setVisibility(4);
            }
            if (!ao.isEmpty(this.htX)) {
                this.htU.setText(this.htX);
            }
            if (!ao.isEmpty(this.htW)) {
                this.htT.setText(this.htW);
            }
            if (!TextUtils.isEmpty(this.htV)) {
                c.jn().a(this.htV, 10, this.huc, eVar.getUniqueId());
            } else {
                this.htP.setImageResource(e.f.frs_luhan_moren_background);
            }
            ym().setBackgroundDrawable(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == e.g.positive_btn) {
                if (this.ang != null) {
                    this.ang.onClick(this);
                }
            } else if (id == e.g.negative_btn) {
                if (this.anh != null) {
                    this.anh.onClick(this);
                }
            } else if (id == e.g.close) {
                dismiss();
            } else if (id == e.g.checkbox_container) {
                this.htR.setChecked(!this.htR.isChecked());
            }
        }
    }

    public a vR(String str) {
        this.htV = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: vS */
    public a dT(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.htY = this.mActivity.getResources().getString(i);
            this.htZ = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.htX = str;
        this.anh = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.htX = this.mActivity.getResources().getString(i);
            this.anh = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.htW = this.mActivity.getResources().getString(i);
            this.ang = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.htW = str;
        this.ang = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0255a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0255a() {
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
