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
    private a.b eHI;
    private a.b eHJ;
    private ImageView mCloseBtn;
    private ViewGroup mContentView;
    private String mMessage;
    private TextView mMessageView;
    private ImageView nvO;
    private ViewGroup nvP;
    private TbCheckBox nvQ;
    private TextView nvR;
    private Button nvS;
    private Button nvT;
    private String nvU;
    private String nvV;
    private String nvW;
    private String nvX;
    private CompoundButton.OnCheckedChangeListener nvY;
    private boolean nvZ;
    private TbCheckBox.a nwa;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> nwb;

    public a(Activity activity) {
        super(activity);
        this.nvZ = false;
        this.nwa = new TbCheckBox.a() { // from class: com.baidu.tieba.videoEasterEgg.a.1
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (a.this.nvY != null) {
                    a.this.nvY.onCheckedChanged(null, z);
                }
            }
        };
        this.nwb = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.videoEasterEgg.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar == null || !aVar.isValidNow()) {
                    a.this.nvO.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                a.this.nvO.setBackgroundResource(0);
                a.this.nvO.setImageDrawable(null);
                aVar.drawImageTo(a.this.nvO);
            }
        };
        XQ();
        oz(1);
        iW(false);
        iV(false);
    }

    private void XQ() {
        this.mContentView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.nvO = (ImageView) this.mContentView.findViewById(R.id.dialog_bg);
        this.mMessageView = (TextView) this.mContentView.findViewById(R.id.message);
        this.nvT = (Button) this.mContentView.findViewById(R.id.negative_btn);
        this.nvT.setOnClickListener(this);
        this.nvS = (Button) this.mContentView.findViewById(R.id.positive_btn);
        this.nvS.setOnClickListener(this);
        this.mCloseBtn = (ImageView) this.mContentView.findViewById(R.id.close);
        this.mCloseBtn.setOnClickListener(this);
        this.nvP = (ViewGroup) this.mContentView.findViewById(R.id.checkbox_container);
        this.nvR = (TextView) this.mContentView.findViewById(R.id.checkbox_text);
        this.nvQ = (TbCheckBox) this.mContentView.findViewById(R.id.checkbox);
        this.nvQ.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.nvQ.setStatedChangedListener(this.nwa);
        this.nvQ.setTagData(new C0867a());
        this.nvP.setClickable(true);
        this.nvP.setOnClickListener(this);
        bf(this.mContentView);
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        if (!this.nvZ) {
            this.nvZ = true;
            super.b(eVar);
            if (!at.isEmpty(this.mMessage)) {
                this.mMessageView.setText(this.mMessage);
            }
            if (!at.isEmpty(this.nvX)) {
                this.nvR.setText(this.nvX);
            } else {
                this.nvP.setVisibility(4);
            }
            if (!at.isEmpty(this.nvW)) {
                this.nvT.setText(this.nvW);
            }
            if (!at.isEmpty(this.nvV)) {
                this.nvS.setText(this.nvV);
            }
            if (!TextUtils.isEmpty(this.nvU)) {
                c.mS().a(this.nvU, 10, this.nwb, eVar.getUniqueId());
            } else {
                this.nvO.setImageResource(R.drawable.frs_luhan_moren_background);
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
                if (this.eHI != null) {
                    this.eHI.onClick(this);
                }
            } else if (id == R.id.negative_btn) {
                if (this.eHJ != null) {
                    this.eHJ.onClick(this);
                }
            } else if (id == R.id.close) {
                dismiss();
            } else if (id == R.id.checkbox_container) {
                this.nvQ.setChecked(!this.nvQ.isChecked());
            }
        }
    }

    public a Ui(String str) {
        this.nvU = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: Uj */
    public a Bo(String str) {
        this.mMessage = str;
        return this;
    }

    public a a(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (this.mActivity != null) {
            this.nvX = this.mActivity.getResources().getString(i);
            this.nvY = onCheckedChangeListener;
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(String str, a.b bVar) {
        this.nvW = str;
        this.eHJ = bVar;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a b(@StringRes int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nvW = this.mActivity.getResources().getString(i);
            this.eHJ = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: d */
    public a a(int i, a.b bVar) {
        if (this.mActivity != null) {
            this.nvV = this.mActivity.getResources().getString(i);
            this.eHI = bVar;
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.dialog.a
    /* renamed from: c */
    public a a(String str, a.b bVar) {
        this.nvV = str;
        this.eHI = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.videoEasterEgg.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0867a implements TbCheckBox.b {
        private boolean isChecked = false;

        C0867a() {
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
