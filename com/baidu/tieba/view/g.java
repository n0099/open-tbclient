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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private TextView cGB;
    private TextView cRA;
    private Context cRw;
    private LinearLayout cRy;
    private View cRz;
    private RadioButton gvK;
    private RadioButton gvL;
    private RadioButton gvM;
    private RadioButton gvN;
    private RadioButton gvO;
    private b kEA;
    private e kEB;
    private LinearLayout kEC;
    private d kEz;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gvK) {
                g.this.gvL.setChecked(false);
                g.this.gvM.setChecked(false);
                g.this.gvN.setChecked(false);
                g.this.gvO.setChecked(false);
                g.this.mScore = 1;
            } else if (view == g.this.gvL) {
                g.this.gvK.setChecked(true);
                g.this.gvM.setChecked(false);
                g.this.gvN.setChecked(false);
                g.this.gvO.setChecked(false);
                g.this.mScore = 2;
            } else if (view == g.this.gvM) {
                g.this.gvK.setChecked(true);
                g.this.gvL.setChecked(true);
                g.this.gvN.setChecked(false);
                g.this.gvO.setChecked(false);
                g.this.mScore = 3;
            } else if (view == g.this.gvN) {
                g.this.gvK.setChecked(true);
                g.this.gvL.setChecked(true);
                g.this.gvM.setChecked(true);
                g.this.gvO.setChecked(false);
                g.this.mScore = 4;
            } else if (view == g.this.gvO) {
                g.this.gvK.setChecked(true);
                g.this.gvL.setChecked(true);
                g.this.gvM.setChecked(true);
                g.this.gvN.setChecked(true);
                g.this.mScore = 5;
            }
            if (g.this.kEB != null) {
                g.this.kEB.AB(g.this.mScore);
            }
        }
    };
    private int mScore;
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
        void onItemClick(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void AB(int i);
    }

    public g(Context context) {
        if (context != null) {
            this.cRw = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cRy = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cGB = (TextView) this.view.findViewById(R.id.title);
            this.cRz = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cRA = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.gvK = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.gvK.setOnClickListener(this.mOnClickListener);
            this.gvL = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.gvL.setOnClickListener(this.mOnClickListener);
            this.gvM = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.gvM.setOnClickListener(this.mOnClickListener);
            this.gvN = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.gvN.setOnClickListener(this.mOnClickListener);
            this.gvO = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.gvO.setOnClickListener(this.mOnClickListener);
            this.kEC = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.cRw;
    }

    public ViewGroup aCk() {
        return this.cRy;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void tm(boolean z) {
        this.gvK.setEnabled(z);
        this.gvL.setEnabled(z);
        this.gvM.setEnabled(z);
        this.gvN.setEnabled(z);
        this.gvO.setEnabled(z);
    }

    public void DG(int i) {
        switch (i) {
            case 1:
                this.gvK.setChecked(true);
                this.gvL.setChecked(false);
                this.gvM.setChecked(false);
                this.gvN.setChecked(false);
                this.gvO.setChecked(false);
                return;
            case 2:
                this.gvK.setChecked(true);
                this.gvL.setChecked(true);
                this.gvM.setChecked(false);
                this.gvN.setChecked(false);
                this.gvO.setChecked(false);
                return;
            case 3:
                this.gvK.setChecked(true);
                this.gvL.setChecked(true);
                this.gvM.setChecked(true);
                this.gvN.setChecked(false);
                this.gvO.setChecked(false);
                return;
            case 4:
                this.gvK.setChecked(true);
                this.gvL.setChecked(true);
                this.gvM.setChecked(true);
                this.gvN.setChecked(true);
                this.gvO.setChecked(false);
                return;
            case 5:
                this.gvK.setChecked(true);
                this.gvL.setChecked(true);
                this.gvM.setChecked(true);
                this.gvN.setChecked(true);
                this.gvO.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void DH(int i) {
        this.kEC.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.kEC.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.cGB.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.cGB.setTextSize(0, l.getDimens(this.cRw, i));
    }

    public d cQY() {
        return this.kEz;
    }

    public void aA(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cRy.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cRy.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kEA = bVar;
    }

    public void a(e eVar) {
        this.kEB = eVar;
    }

    public void DI(int i) {
        this.cRA.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.cGB, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cGB, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cRz, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cRA, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cRA, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.kEC, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aCm() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cGB.setText(this.titleText);
        } else {
            this.cGB.setVisibility(8);
        }
        if (this.kEA != null) {
            this.cRA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.kEA.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View cRh;
        private g kEE;
        private c kEF;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int cRi = R.drawable.person_more_pop_item_bg_selector;
        private int cRj = 17;
        private boolean cRl = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kEF != null) {
                    a.this.kEF.onClick();
                }
                if (a.this.kEE != null && a.this.kEE.cQY() != null) {
                    a.this.kEE.cQY().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, g gVar) {
            this.mText = str;
            this.kEE = gVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.kEF = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.cRh, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kEE != null && this.kEE.getContext() != null) {
                this.mView = LayoutInflater.from(this.kEE.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kEE.aCk(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cRj);
                this.cRh = this.mView.findViewById(R.id.divider_line);
                if (this.cRl) {
                    this.cRh.setVisibility(0);
                } else {
                    this.cRh.setVisibility(8);
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
