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
public class j {
    private TextView bUf;
    private Context ceY;
    private LinearLayout cfa;
    private View cfb;
    private TextView cfc;
    private RadioButton fHr;
    private RadioButton fHs;
    private RadioButton fHt;
    private RadioButton fHu;
    private RadioButton fHv;
    private d jKd;
    private b jKe;
    private e jKf;
    private LinearLayout jKg;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fHr) {
                j.this.fHs.setChecked(false);
                j.this.fHt.setChecked(false);
                j.this.fHu.setChecked(false);
                j.this.fHv.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fHs) {
                j.this.fHr.setChecked(true);
                j.this.fHt.setChecked(false);
                j.this.fHu.setChecked(false);
                j.this.fHv.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fHt) {
                j.this.fHr.setChecked(true);
                j.this.fHs.setChecked(true);
                j.this.fHu.setChecked(false);
                j.this.fHv.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fHu) {
                j.this.fHr.setChecked(true);
                j.this.fHs.setChecked(true);
                j.this.fHt.setChecked(true);
                j.this.fHv.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fHv) {
                j.this.fHr.setChecked(true);
                j.this.fHs.setChecked(true);
                j.this.fHt.setChecked(true);
                j.this.fHu.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jKf != null) {
                j.this.jKf.yf(j.this.mScore);
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
        void lK(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void yf(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.ceY = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cfa = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bUf = (TextView) this.view.findViewById(R.id.title);
            this.cfb = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cfc = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.fHr = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.fHr.setOnClickListener(this.mOnClickListener);
            this.fHs = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.fHs.setOnClickListener(this.mOnClickListener);
            this.fHt = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.fHt.setOnClickListener(this.mOnClickListener);
            this.fHu = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.fHu.setOnClickListener(this.mOnClickListener);
            this.fHv = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.fHv.setOnClickListener(this.mOnClickListener);
            this.jKg = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.ceY;
    }

    public ViewGroup ala() {
        return this.cfa;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void rH(boolean z) {
        this.fHr.setEnabled(z);
        this.fHs.setEnabled(z);
        this.fHt.setEnabled(z);
        this.fHu.setEnabled(z);
        this.fHv.setEnabled(z);
    }

    public void Bk(int i) {
        switch (i) {
            case 1:
                this.fHr.setChecked(true);
                this.fHs.setChecked(false);
                this.fHt.setChecked(false);
                this.fHu.setChecked(false);
                this.fHv.setChecked(false);
                return;
            case 2:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(false);
                this.fHu.setChecked(false);
                this.fHv.setChecked(false);
                return;
            case 3:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(true);
                this.fHu.setChecked(false);
                this.fHv.setChecked(false);
                return;
            case 4:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(true);
                this.fHu.setChecked(true);
                this.fHv.setChecked(false);
                return;
            case 5:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(true);
                this.fHu.setChecked(true);
                this.fHv.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Bl(int i) {
        this.jKg.setVisibility(i);
    }

    public void B(int i, int i2, int i3, int i4) {
        this.jKg.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bUf.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bUf.setTextSize(0, l.getDimens(this.ceY, i));
    }

    public d cwQ() {
        return this.jKd;
    }

    public void at(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cfa.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cfa.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jKe = bVar;
    }

    public void a(e eVar) {
        this.jKf = eVar;
    }

    public void Bm(int i) {
        this.cfc.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.bUf, R.color.cp_bg_line_d);
        am.setViewTextColor(this.bUf, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cfb, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cfc, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cfc, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.jKg, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View alc() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bUf.setText(this.titleText);
        } else {
            this.bUf.setVisibility(8);
        }
        if (this.jKe != null) {
            this.cfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jKe.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View ceJ;
        private j jKi;
        private c jKj;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int ceK = R.drawable.person_more_pop_item_bg_selector;
        private int ceL = 17;
        private boolean ceN = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jKj != null) {
                    a.this.jKj.onClick();
                }
                if (a.this.jKi != null && a.this.jKi.cwQ() != null) {
                    a.this.jKi.cwQ().lK(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.jKi = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jKj = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.ceJ, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jKi != null && this.jKi.getContext() != null) {
                this.mView = LayoutInflater.from(this.jKi.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jKi.ala(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.ceL);
                this.ceJ = this.mView.findViewById(R.id.divider_line);
                if (this.ceN) {
                    this.ceJ.setVisibility(0);
                } else {
                    this.ceJ.setVisibility(8);
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
