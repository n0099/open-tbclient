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
    private TextView cKQ;
    private Context cVI;
    private LinearLayout cVK;
    private View cVL;
    private TextView cVM;
    private RadioButton gAU;
    private RadioButton gAV;
    private RadioButton gAW;
    private RadioButton gAX;
    private RadioButton gAY;
    private d kJa;
    private b kJb;
    private e kJc;
    private LinearLayout kJd;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gAU) {
                g.this.gAV.setChecked(false);
                g.this.gAW.setChecked(false);
                g.this.gAX.setChecked(false);
                g.this.gAY.setChecked(false);
                g.this.mScore = 1;
            } else if (view == g.this.gAV) {
                g.this.gAU.setChecked(true);
                g.this.gAW.setChecked(false);
                g.this.gAX.setChecked(false);
                g.this.gAY.setChecked(false);
                g.this.mScore = 2;
            } else if (view == g.this.gAW) {
                g.this.gAU.setChecked(true);
                g.this.gAV.setChecked(true);
                g.this.gAX.setChecked(false);
                g.this.gAY.setChecked(false);
                g.this.mScore = 3;
            } else if (view == g.this.gAX) {
                g.this.gAU.setChecked(true);
                g.this.gAV.setChecked(true);
                g.this.gAW.setChecked(true);
                g.this.gAY.setChecked(false);
                g.this.mScore = 4;
            } else if (view == g.this.gAY) {
                g.this.gAU.setChecked(true);
                g.this.gAV.setChecked(true);
                g.this.gAW.setChecked(true);
                g.this.gAX.setChecked(true);
                g.this.mScore = 5;
            }
            if (g.this.kJc != null) {
                g.this.kJc.AP(g.this.mScore);
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
        void AP(int i);
    }

    public g(Context context) {
        if (context != null) {
            this.cVI = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cVK = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cKQ = (TextView) this.view.findViewById(R.id.title);
            this.cVL = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cVM = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.gAU = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.gAU.setOnClickListener(this.mOnClickListener);
            this.gAV = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.gAV.setOnClickListener(this.mOnClickListener);
            this.gAW = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.gAW.setOnClickListener(this.mOnClickListener);
            this.gAX = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.gAX.setOnClickListener(this.mOnClickListener);
            this.gAY = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.gAY.setOnClickListener(this.mOnClickListener);
            this.kJd = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.cVI;
    }

    public ViewGroup getView() {
        return this.cVK;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void tC(boolean z) {
        this.gAU.setEnabled(z);
        this.gAV.setEnabled(z);
        this.gAW.setEnabled(z);
        this.gAX.setEnabled(z);
        this.gAY.setEnabled(z);
    }

    public void DS(int i) {
        switch (i) {
            case 1:
                this.gAU.setChecked(true);
                this.gAV.setChecked(false);
                this.gAW.setChecked(false);
                this.gAX.setChecked(false);
                this.gAY.setChecked(false);
                return;
            case 2:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(false);
                this.gAX.setChecked(false);
                this.gAY.setChecked(false);
                return;
            case 3:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(true);
                this.gAX.setChecked(false);
                this.gAY.setChecked(false);
                return;
            case 4:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(false);
                return;
            case 5:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void DT(int i) {
        this.kJd.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.kJd.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.cKQ.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.cKQ.setTextSize(0, l.getDimens(this.cVI, i));
    }

    public d cTy() {
        return this.kJa;
    }

    public void az(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cVK.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cVK.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kJb = bVar;
    }

    public void a(e eVar) {
        this.kJc = eVar;
    }

    public void DU(int i) {
        this.cVM.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.cKQ, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cKQ, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cVL, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVM, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cVM, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.kJd, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aEP() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKQ.setText(this.titleText);
        } else {
            this.cKQ.setVisibility(8);
        }
        if (this.kJb != null) {
            this.cVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.kJb.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View cVt;
        private g kJf;
        private c kJg;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int cVu = R.drawable.person_more_pop_item_bg_selector;
        private int cVv = 17;
        private boolean cVx = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kJg != null) {
                    a.this.kJg.onClick();
                }
                if (a.this.kJf != null && a.this.kJf.cTy() != null) {
                    a.this.kJf.cTy().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, g gVar) {
            this.mText = str;
            this.kJf = gVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.kJg = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.cVt, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kJf != null && this.kJf.getContext() != null) {
                this.mView = LayoutInflater.from(this.kJf.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kJf.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cVv);
                this.cVt = this.mView.findViewById(R.id.divider_line);
                if (this.cVx) {
                    this.cVt.setVisibility(0);
                } else {
                    this.cVt.setVisibility(8);
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
