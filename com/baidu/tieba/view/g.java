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
    private TextView cGN;
    private Context cRG;
    private LinearLayout cRI;
    private View cRJ;
    private TextView cRK;
    private RadioButton gyU;
    private RadioButton gyV;
    private RadioButton gyW;
    private RadioButton gyX;
    private RadioButton gyY;
    private d kIf;
    private b kIg;
    private e kIh;
    private LinearLayout kIi;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gyU) {
                g.this.gyV.setChecked(false);
                g.this.gyW.setChecked(false);
                g.this.gyX.setChecked(false);
                g.this.gyY.setChecked(false);
                g.this.mScore = 1;
            } else if (view == g.this.gyV) {
                g.this.gyU.setChecked(true);
                g.this.gyW.setChecked(false);
                g.this.gyX.setChecked(false);
                g.this.gyY.setChecked(false);
                g.this.mScore = 2;
            } else if (view == g.this.gyW) {
                g.this.gyU.setChecked(true);
                g.this.gyV.setChecked(true);
                g.this.gyX.setChecked(false);
                g.this.gyY.setChecked(false);
                g.this.mScore = 3;
            } else if (view == g.this.gyX) {
                g.this.gyU.setChecked(true);
                g.this.gyV.setChecked(true);
                g.this.gyW.setChecked(true);
                g.this.gyY.setChecked(false);
                g.this.mScore = 4;
            } else if (view == g.this.gyY) {
                g.this.gyU.setChecked(true);
                g.this.gyV.setChecked(true);
                g.this.gyW.setChecked(true);
                g.this.gyX.setChecked(true);
                g.this.mScore = 5;
            }
            if (g.this.kIh != null) {
                g.this.kIh.AG(g.this.mScore);
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
        void AG(int i);
    }

    public g(Context context) {
        if (context != null) {
            this.cRG = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cRI = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cGN = (TextView) this.view.findViewById(R.id.title);
            this.cRJ = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cRK = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.gyU = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.gyU.setOnClickListener(this.mOnClickListener);
            this.gyV = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.gyV.setOnClickListener(this.mOnClickListener);
            this.gyW = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.gyW.setOnClickListener(this.mOnClickListener);
            this.gyX = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.gyX.setOnClickListener(this.mOnClickListener);
            this.gyY = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.gyY.setOnClickListener(this.mOnClickListener);
            this.kIi = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.cRG;
    }

    public ViewGroup aCD() {
        return this.cRI;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void ty(boolean z) {
        this.gyU.setEnabled(z);
        this.gyV.setEnabled(z);
        this.gyW.setEnabled(z);
        this.gyX.setEnabled(z);
        this.gyY.setEnabled(z);
    }

    public void DM(int i) {
        switch (i) {
            case 1:
                this.gyU.setChecked(true);
                this.gyV.setChecked(false);
                this.gyW.setChecked(false);
                this.gyX.setChecked(false);
                this.gyY.setChecked(false);
                return;
            case 2:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(false);
                this.gyX.setChecked(false);
                this.gyY.setChecked(false);
                return;
            case 3:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(true);
                this.gyX.setChecked(false);
                this.gyY.setChecked(false);
                return;
            case 4:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(true);
                this.gyX.setChecked(true);
                this.gyY.setChecked(false);
                return;
            case 5:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(true);
                this.gyX.setChecked(true);
                this.gyY.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void DN(int i) {
        this.kIi.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.kIi.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.cGN.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.cGN.setTextSize(0, l.getDimens(this.cRG, i));
    }

    public d cSd() {
        return this.kIf;
    }

    public void az(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cRI.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cRI.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kIg = bVar;
    }

    public void a(e eVar) {
        this.kIh = eVar;
    }

    public void DO(int i) {
        this.cRK.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.cGN, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cGN, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cRJ, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cRK, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cRK, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.kIi, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aCF() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cGN.setText(this.titleText);
        } else {
            this.cGN.setVisibility(8);
        }
        if (this.kIg != null) {
            this.cRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.kIg.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View cRr;
        private g kIk;
        private c kIl;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int cRs = R.drawable.person_more_pop_item_bg_selector;
        private int cRt = 17;
        private boolean cRv = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kIl != null) {
                    a.this.kIl.onClick();
                }
                if (a.this.kIk != null && a.this.kIk.cSd() != null) {
                    a.this.kIk.cSd().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, g gVar) {
            this.mText = str;
            this.kIk = gVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.kIl = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.cRr, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kIk != null && this.kIk.getContext() != null) {
                this.mView = LayoutInflater.from(this.kIk.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kIk.aCD(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cRt);
                this.cRr = this.mView.findViewById(R.id.divider_line);
                if (this.cRv) {
                    this.cRr.setVisibility(0);
                } else {
                    this.cRr.setVisibility(8);
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
