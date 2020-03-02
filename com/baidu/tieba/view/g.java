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
    private TextView cKR;
    private Context cVJ;
    private LinearLayout cVL;
    private View cVM;
    private TextView cVN;
    private RadioButton gAW;
    private RadioButton gAX;
    private RadioButton gAY;
    private RadioButton gAZ;
    private RadioButton gBa;
    private d kJc;
    private b kJd;
    private e kJe;
    private LinearLayout kJf;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gAW) {
                g.this.gAX.setChecked(false);
                g.this.gAY.setChecked(false);
                g.this.gAZ.setChecked(false);
                g.this.gBa.setChecked(false);
                g.this.mScore = 1;
            } else if (view == g.this.gAX) {
                g.this.gAW.setChecked(true);
                g.this.gAY.setChecked(false);
                g.this.gAZ.setChecked(false);
                g.this.gBa.setChecked(false);
                g.this.mScore = 2;
            } else if (view == g.this.gAY) {
                g.this.gAW.setChecked(true);
                g.this.gAX.setChecked(true);
                g.this.gAZ.setChecked(false);
                g.this.gBa.setChecked(false);
                g.this.mScore = 3;
            } else if (view == g.this.gAZ) {
                g.this.gAW.setChecked(true);
                g.this.gAX.setChecked(true);
                g.this.gAY.setChecked(true);
                g.this.gBa.setChecked(false);
                g.this.mScore = 4;
            } else if (view == g.this.gBa) {
                g.this.gAW.setChecked(true);
                g.this.gAX.setChecked(true);
                g.this.gAY.setChecked(true);
                g.this.gAZ.setChecked(true);
                g.this.mScore = 5;
            }
            if (g.this.kJe != null) {
                g.this.kJe.AP(g.this.mScore);
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
            this.cVJ = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cVL = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cKR = (TextView) this.view.findViewById(R.id.title);
            this.cVM = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cVN = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.gAW = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.gAW.setOnClickListener(this.mOnClickListener);
            this.gAX = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.gAX.setOnClickListener(this.mOnClickListener);
            this.gAY = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.gAY.setOnClickListener(this.mOnClickListener);
            this.gAZ = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.gAZ.setOnClickListener(this.mOnClickListener);
            this.gBa = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.gBa.setOnClickListener(this.mOnClickListener);
            this.kJf = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.cVJ;
    }

    public ViewGroup getView() {
        return this.cVL;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void tC(boolean z) {
        this.gAW.setEnabled(z);
        this.gAX.setEnabled(z);
        this.gAY.setEnabled(z);
        this.gAZ.setEnabled(z);
        this.gBa.setEnabled(z);
    }

    public void DS(int i) {
        switch (i) {
            case 1:
                this.gAW.setChecked(true);
                this.gAX.setChecked(false);
                this.gAY.setChecked(false);
                this.gAZ.setChecked(false);
                this.gBa.setChecked(false);
                return;
            case 2:
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(false);
                this.gAZ.setChecked(false);
                this.gBa.setChecked(false);
                return;
            case 3:
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(true);
                this.gAZ.setChecked(false);
                this.gBa.setChecked(false);
                return;
            case 4:
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(true);
                this.gAZ.setChecked(true);
                this.gBa.setChecked(false);
                return;
            case 5:
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(true);
                this.gAZ.setChecked(true);
                this.gBa.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void DT(int i) {
        this.kJf.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.kJf.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.cKR.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.cKR.setTextSize(0, l.getDimens(this.cVJ, i));
    }

    public d cTA() {
        return this.kJc;
    }

    public void az(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cVL.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cVL.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kJd = bVar;
    }

    public void a(e eVar) {
        this.kJe = eVar;
    }

    public void DU(int i) {
        this.cVN.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.cKR, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cKR, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cVM, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVN, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cVN, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.kJf, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aER() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKR.setText(this.titleText);
        } else {
            this.cKR.setVisibility(8);
        }
        if (this.kJd != null) {
            this.cVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.kJd.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View cVu;
        private g kJh;
        private c kJi;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int cVv = R.drawable.person_more_pop_item_bg_selector;
        private int cVw = 17;
        private boolean cVy = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kJi != null) {
                    a.this.kJi.onClick();
                }
                if (a.this.kJh != null && a.this.kJh.cTA() != null) {
                    a.this.kJh.cTA().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, g gVar) {
            this.mText = str;
            this.kJh = gVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.kJi = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.cVu, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kJh != null && this.kJh.getContext() != null) {
                this.mView = LayoutInflater.from(this.kJh.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kJh.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cVw);
                this.cVu = this.mView.findViewById(R.id.divider_line);
                if (this.cVy) {
                    this.cVu.setVisibility(0);
                } else {
                    this.cVu.setVisibility(8);
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
