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
    private TextView cLd;
    private Context cVX;
    private LinearLayout cVZ;
    private View cWa;
    private TextView cWb;
    private RadioButton gCg;
    private RadioButton gCh;
    private RadioButton gCi;
    private RadioButton gCj;
    private RadioButton gCk;
    private d kKV;
    private b kKW;
    private e kKX;
    private LinearLayout kKY;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gCg) {
                g.this.gCh.setChecked(false);
                g.this.gCi.setChecked(false);
                g.this.gCj.setChecked(false);
                g.this.gCk.setChecked(false);
                g.this.mScore = 1;
            } else if (view == g.this.gCh) {
                g.this.gCg.setChecked(true);
                g.this.gCi.setChecked(false);
                g.this.gCj.setChecked(false);
                g.this.gCk.setChecked(false);
                g.this.mScore = 2;
            } else if (view == g.this.gCi) {
                g.this.gCg.setChecked(true);
                g.this.gCh.setChecked(true);
                g.this.gCj.setChecked(false);
                g.this.gCk.setChecked(false);
                g.this.mScore = 3;
            } else if (view == g.this.gCj) {
                g.this.gCg.setChecked(true);
                g.this.gCh.setChecked(true);
                g.this.gCi.setChecked(true);
                g.this.gCk.setChecked(false);
                g.this.mScore = 4;
            } else if (view == g.this.gCk) {
                g.this.gCg.setChecked(true);
                g.this.gCh.setChecked(true);
                g.this.gCi.setChecked(true);
                g.this.gCj.setChecked(true);
                g.this.mScore = 5;
            }
            if (g.this.kKX != null) {
                g.this.kKX.AX(g.this.mScore);
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
        void AX(int i);
    }

    public g(Context context) {
        if (context != null) {
            this.cVX = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cVZ = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cLd = (TextView) this.view.findViewById(R.id.title);
            this.cWa = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cWb = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.gCg = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.gCg.setOnClickListener(this.mOnClickListener);
            this.gCh = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.gCh.setOnClickListener(this.mOnClickListener);
            this.gCi = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.gCi.setOnClickListener(this.mOnClickListener);
            this.gCj = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.gCj.setOnClickListener(this.mOnClickListener);
            this.gCk = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.gCk.setOnClickListener(this.mOnClickListener);
            this.kKY = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.cVX;
    }

    public ViewGroup getView() {
        return this.cVZ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void tI(boolean z) {
        this.gCg.setEnabled(z);
        this.gCh.setEnabled(z);
        this.gCi.setEnabled(z);
        this.gCj.setEnabled(z);
        this.gCk.setEnabled(z);
    }

    public void Ea(int i) {
        switch (i) {
            case 1:
                this.gCg.setChecked(true);
                this.gCh.setChecked(false);
                this.gCi.setChecked(false);
                this.gCj.setChecked(false);
                this.gCk.setChecked(false);
                return;
            case 2:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(false);
                this.gCj.setChecked(false);
                this.gCk.setChecked(false);
                return;
            case 3:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(true);
                this.gCj.setChecked(false);
                this.gCk.setChecked(false);
                return;
            case 4:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(true);
                this.gCj.setChecked(true);
                this.gCk.setChecked(false);
                return;
            case 5:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(true);
                this.gCj.setChecked(true);
                this.gCk.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Eb(int i) {
        this.kKY.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.kKY.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.cLd.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.cLd.setTextSize(0, l.getDimens(this.cVX, i));
    }

    public d cTV() {
        return this.kKV;
    }

    public void az(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cVZ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cVZ.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kKW = bVar;
    }

    public void a(e eVar) {
        this.kKX = eVar;
    }

    public void Ec(int i) {
        this.cWb.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.cLd, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cLd, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cWa, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cWb, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cWb, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.kKY, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aEV() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cLd.setText(this.titleText);
        } else {
            this.cLd.setVisibility(8);
        }
        if (this.kKW != null) {
            this.cWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.kKW.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View cVI;
        private g kLa;
        private c kLb;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int cVJ = R.drawable.person_more_pop_item_bg_selector;
        private int cVK = 17;
        private boolean cVM = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kLb != null) {
                    a.this.kLb.onClick();
                }
                if (a.this.kLa != null && a.this.kLa.cTV() != null) {
                    a.this.kLa.cTV().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, g gVar) {
            this.mText = str;
            this.kLa = gVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.kLb = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.cVI, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kLa != null && this.kLa.getContext() != null) {
                this.mView = LayoutInflater.from(this.kLa.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kLa.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cVK);
                this.cVI = this.mView.findViewById(R.id.divider_line);
                if (this.cVM) {
                    this.cVI.setVisibility(0);
                } else {
                    this.cVI.setVisibility(8);
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
