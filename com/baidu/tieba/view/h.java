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
    private TextView eIY;
    private Context eXh;
    private LinearLayout eXj;
    private View eXm;
    private TextView eXn;
    private RadioButton jAC;
    private RadioButton jAD;
    private RadioButton jAE;
    private RadioButton jAF;
    private RadioButton jAG;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.jAC) {
                h.this.jAD.setChecked(false);
                h.this.jAE.setChecked(false);
                h.this.jAF.setChecked(false);
                h.this.jAG.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.jAD) {
                h.this.jAC.setChecked(true);
                h.this.jAE.setChecked(false);
                h.this.jAF.setChecked(false);
                h.this.jAG.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.jAE) {
                h.this.jAC.setChecked(true);
                h.this.jAD.setChecked(true);
                h.this.jAF.setChecked(false);
                h.this.jAG.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.jAF) {
                h.this.jAC.setChecked(true);
                h.this.jAD.setChecked(true);
                h.this.jAE.setChecked(true);
                h.this.jAG.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.jAG) {
                h.this.jAC.setChecked(true);
                h.this.jAD.setChecked(true);
                h.this.jAE.setChecked(true);
                h.this.jAF.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.ocI != null) {
                h.this.ocI.HM(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d ocG;
    private b ocH;
    private e ocI;
    private LinearLayout ocJ;
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
        void dW(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void HM(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eXh = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eXj = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eIY = (TextView) this.view.findViewById(R.id.title);
            this.eXm = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eXn = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.jAC = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.jAC.setOnClickListener(this.mOnClickListener);
            this.jAD = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.jAD.setOnClickListener(this.mOnClickListener);
            this.jAE = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.jAE.setOnClickListener(this.mOnClickListener);
            this.jAF = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.jAF.setOnClickListener(this.mOnClickListener);
            this.jAG = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.jAG.setOnClickListener(this.mOnClickListener);
            this.ocJ = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eXh;
    }

    public ViewGroup getView() {
        return this.eXj;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void zo(boolean z) {
        this.jAC.setEnabled(z);
        this.jAD.setEnabled(z);
        this.jAE.setEnabled(z);
        this.jAF.setEnabled(z);
        this.jAG.setEnabled(z);
    }

    public void Lb(int i) {
        switch (i) {
            case 1:
                this.jAC.setChecked(true);
                this.jAD.setChecked(false);
                this.jAE.setChecked(false);
                this.jAF.setChecked(false);
                this.jAG.setChecked(false);
                return;
            case 2:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(false);
                this.jAF.setChecked(false);
                this.jAG.setChecked(false);
                return;
            case 3:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(true);
                this.jAF.setChecked(false);
                this.jAG.setChecked(false);
                return;
            case 4:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(true);
                this.jAF.setChecked(true);
                this.jAG.setChecked(false);
                return;
            case 5:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(true);
                this.jAF.setChecked(true);
                this.jAG.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Lc(int i) {
        this.ocJ.setVisibility(i);
    }

    public void L(int i, int i2, int i3, int i4) {
        this.ocJ.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.eIY.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.eIY.setTextSize(0, l.getDimens(this.eXh, i));
    }

    public d dWv() {
        return this.ocG;
    }

    public void bw(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eXj.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eXj.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.ocH = bVar;
    }

    public void a(e eVar) {
        this.ocI = eVar;
    }

    public void Ld(int i) {
        this.eXn.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eIY, R.color.CAM_X0201);
        ap.setViewTextColor(this.eIY, R.color.CAM_X0107);
        ap.setBackgroundColor(this.eXm, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eXn, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eXn, R.color.CAM_X0106);
        ap.setBackgroundResource(this.ocJ, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bqS() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eIY.setText(this.titleText);
        } else {
            this.eIY.setVisibility(8);
        }
        if (this.ocH != null) {
            this.eXn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.ocH.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eWL;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h ocL;
        private c ocM;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eWM = R.drawable.person_more_pop_item_bg_selector;
        private int eWN = 17;
        private boolean eWP = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ocM != null) {
                    a.this.ocM.onClick();
                }
                if (a.this.ocL != null && a.this.ocL.dWv() != null) {
                    a.this.ocL.dWv().dW(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.ocL = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.ocM = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0106);
            ap.setBackgroundColor(this.eWL, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.ocL != null && this.ocL.getContext() != null) {
                this.mView = LayoutInflater.from(this.ocL.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.ocL.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eWN);
                this.eWL = this.mView.findViewById(R.id.divider_line);
                if (this.eWP) {
                    this.eWL.setVisibility(0);
                } else {
                    this.eWL.setVisibility(8);
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
