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
/* loaded from: classes2.dex */
public class h {
    private TextView dSz;
    private Context efP;
    private LinearLayout efR;
    private View efS;
    private TextView efT;
    private RadioButton iiA;
    private RadioButton iiB;
    private RadioButton iiC;
    private RadioButton iiD;
    private RadioButton iiz;
    private List<a> mItems;
    private d mJB;
    private b mJC;
    private e mJD;
    private LinearLayout mJE;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iiz) {
                h.this.iiA.setChecked(false);
                h.this.iiB.setChecked(false);
                h.this.iiC.setChecked(false);
                h.this.iiD.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.iiA) {
                h.this.iiz.setChecked(true);
                h.this.iiB.setChecked(false);
                h.this.iiC.setChecked(false);
                h.this.iiD.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.iiB) {
                h.this.iiz.setChecked(true);
                h.this.iiA.setChecked(true);
                h.this.iiC.setChecked(false);
                h.this.iiD.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.iiC) {
                h.this.iiz.setChecked(true);
                h.this.iiA.setChecked(true);
                h.this.iiB.setChecked(true);
                h.this.iiD.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.iiD) {
                h.this.iiz.setChecked(true);
                h.this.iiA.setChecked(true);
                h.this.iiB.setChecked(true);
                h.this.iiC.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.mJD != null) {
                h.this.mJD.Gc(h.this.mScore);
            }
        }
    };
    private int mScore;
    private String titleText;
    private View view;

    /* loaded from: classes2.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onItemClick(int i);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void Gc(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.efP = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.efR = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dSz = (TextView) this.view.findViewById(R.id.title);
            this.efS = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.efT = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.iiz = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.iiz.setOnClickListener(this.mOnClickListener);
            this.iiA = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.iiA.setOnClickListener(this.mOnClickListener);
            this.iiB = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.iiB.setOnClickListener(this.mOnClickListener);
            this.iiC = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.iiC.setOnClickListener(this.mOnClickListener);
            this.iiD = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.iiD.setOnClickListener(this.mOnClickListener);
            this.mJE = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.efP;
    }

    public ViewGroup getView() {
        return this.efR;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void wT(boolean z) {
        this.iiz.setEnabled(z);
        this.iiA.setEnabled(z);
        this.iiB.setEnabled(z);
        this.iiC.setEnabled(z);
        this.iiD.setEnabled(z);
    }

    public void Jl(int i) {
        switch (i) {
            case 1:
                this.iiz.setChecked(true);
                this.iiA.setChecked(false);
                this.iiB.setChecked(false);
                this.iiC.setChecked(false);
                this.iiD.setChecked(false);
                return;
            case 2:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(false);
                this.iiC.setChecked(false);
                this.iiD.setChecked(false);
                return;
            case 3:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(true);
                this.iiC.setChecked(false);
                this.iiD.setChecked(false);
                return;
            case 4:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(true);
                this.iiC.setChecked(true);
                this.iiD.setChecked(false);
                return;
            case 5:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(true);
                this.iiC.setChecked(true);
                this.iiD.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Jm(int i) {
        this.mJE.setVisibility(i);
    }

    public void H(int i, int i2, int i3, int i4) {
        this.mJE.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dSz.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dSz.setTextSize(0, l.getDimens(this.efP, i));
    }

    public d dFm() {
        return this.mJB;
    }

    public void aT(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.efR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.efR.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mJC = bVar;
    }

    public void a(e eVar) {
        this.mJD = eVar;
    }

    public void Jn(int i) {
        this.efT.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.dSz, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dSz, R.color.cp_cont_j);
        ap.setBackgroundColor(this.efS, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.efT, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.efT, R.color.cp_cont_f);
        ap.setBackgroundResource(this.mJE, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bhw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dSz.setText(this.titleText);
        } else {
            this.dSz.setVisibility(8);
        }
        if (this.mJC != null) {
            this.efT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.mJC.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private View efA;
        private h mJG;
        private c mJH;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int efB = R.drawable.person_more_pop_item_bg_selector;
        private int efC = 17;
        private boolean efE = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mJH != null) {
                    a.this.mJH.onClick();
                }
                if (a.this.mJG != null && a.this.mJG.dFm() != null) {
                    a.this.mJG.dFm().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.mJG = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.mJH = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ap.setBackgroundColor(this.efA, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mJG != null && this.mJG.getContext() != null) {
                this.mView = LayoutInflater.from(this.mJG.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mJG.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.efC);
                this.efA = this.mView.findViewById(R.id.divider_line);
                if (this.efE) {
                    this.efA.setVisibility(0);
                } else {
                    this.efA.setVisibility(8);
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
