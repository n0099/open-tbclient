package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private TextView eHx;
    private Context eVI;
    private LinearLayout eVK;
    private View eVN;
    private TextView eVO;
    private RadioButton jyT;
    private RadioButton jyU;
    private RadioButton jyV;
    private RadioButton jyW;
    private RadioButton jyX;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.jyT) {
                h.this.jyU.setChecked(false);
                h.this.jyV.setChecked(false);
                h.this.jyW.setChecked(false);
                h.this.jyX.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.jyU) {
                h.this.jyT.setChecked(true);
                h.this.jyV.setChecked(false);
                h.this.jyW.setChecked(false);
                h.this.jyX.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.jyV) {
                h.this.jyT.setChecked(true);
                h.this.jyU.setChecked(true);
                h.this.jyW.setChecked(false);
                h.this.jyX.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.jyW) {
                h.this.jyT.setChecked(true);
                h.this.jyU.setChecked(true);
                h.this.jyV.setChecked(true);
                h.this.jyX.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.jyX) {
                h.this.jyT.setChecked(true);
                h.this.jyU.setChecked(true);
                h.this.jyV.setChecked(true);
                h.this.jyW.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.oaB != null) {
                h.this.oaB.HJ(h.this.mScore);
            }
        }
    };
    private int mScore;
    private b oaA;
    private e oaB;
    private LinearLayout oaC;
    private d oaz;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void dV(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void HJ(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eVI = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eVK = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eHx = (TextView) this.view.findViewById(R.id.title);
            this.eVN = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eVO = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.jyT = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.jyT.setOnClickListener(this.mOnClickListener);
            this.jyU = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.jyU.setOnClickListener(this.mOnClickListener);
            this.jyV = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.jyV.setOnClickListener(this.mOnClickListener);
            this.jyW = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.jyW.setOnClickListener(this.mOnClickListener);
            this.jyX = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.jyX.setOnClickListener(this.mOnClickListener);
            this.oaC = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eVI;
    }

    public ViewGroup getView() {
        return this.eVK;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void zp(boolean z) {
        this.jyT.setEnabled(z);
        this.jyU.setEnabled(z);
        this.jyV.setEnabled(z);
        this.jyW.setEnabled(z);
        this.jyX.setEnabled(z);
    }

    public void KX(int i) {
        switch (i) {
            case 1:
                this.jyT.setChecked(true);
                this.jyU.setChecked(false);
                this.jyV.setChecked(false);
                this.jyW.setChecked(false);
                this.jyX.setChecked(false);
                return;
            case 2:
                this.jyT.setChecked(true);
                this.jyU.setChecked(true);
                this.jyV.setChecked(false);
                this.jyW.setChecked(false);
                this.jyX.setChecked(false);
                return;
            case 3:
                this.jyT.setChecked(true);
                this.jyU.setChecked(true);
                this.jyV.setChecked(true);
                this.jyW.setChecked(false);
                this.jyX.setChecked(false);
                return;
            case 4:
                this.jyT.setChecked(true);
                this.jyU.setChecked(true);
                this.jyV.setChecked(true);
                this.jyW.setChecked(true);
                this.jyX.setChecked(false);
                return;
            case 5:
                this.jyT.setChecked(true);
                this.jyU.setChecked(true);
                this.jyV.setChecked(true);
                this.jyW.setChecked(true);
                this.jyX.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void KY(int i) {
        this.oaC.setVisibility(i);
    }

    public void L(int i, int i2, int i3, int i4) {
        this.oaC.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.eHx.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.eHx.setTextSize(0, l.getDimens(this.eVI, i));
    }

    public d dWn() {
        return this.oaz;
    }

    public void bw(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eVK.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eVK.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.oaA = bVar;
    }

    public void a(e eVar) {
        this.oaB = eVar;
    }

    public void KZ(int i) {
        this.eVO.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eHx, R.color.CAM_X0201);
        ap.setViewTextColor(this.eHx, R.color.CAM_X0107);
        ap.setBackgroundColor(this.eVN, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eVO, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eVO, R.color.CAM_X0106);
        ap.setBackgroundResource(this.oaC, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bqR() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eHx.setText(this.titleText);
        } else {
            this.eHx.setVisibility(8);
        }
        if (this.oaA != null) {
            this.eVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.oaA.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eVm;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h oaE;
        private c oaF;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eVn = R.drawable.person_more_pop_item_bg_selector;
        private int eVo = 17;
        private boolean eVq = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oaF != null) {
                    a.this.oaF.onClick();
                }
                if (a.this.oaE != null && a.this.oaE.dWn() != null) {
                    a.this.oaE.dWn().dV(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.oaE = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.oaF = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0106);
            ap.setBackgroundColor(this.eVm, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.oaE != null && this.oaE.getContext() != null) {
                this.mView = LayoutInflater.from(this.oaE.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.oaE.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eVo);
                this.eVm = this.mView.findViewById(R.id.divider_line);
                if (this.eVq) {
                    this.eVm.setVisibility(0);
                } else {
                    this.eVm.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.mTextView != null) {
                this.mTextView.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
