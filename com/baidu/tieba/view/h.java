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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private TextView dJr;
    private Context dWp;
    private LinearLayout dWr;
    private View dWs;
    private TextView dWt;
    private RadioButton hUq;
    private RadioButton hUr;
    private RadioButton hUs;
    private RadioButton hUt;
    private RadioButton hUu;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.hUq) {
                h.this.hUr.setChecked(false);
                h.this.hUs.setChecked(false);
                h.this.hUt.setChecked(false);
                h.this.hUu.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.hUr) {
                h.this.hUq.setChecked(true);
                h.this.hUs.setChecked(false);
                h.this.hUt.setChecked(false);
                h.this.hUu.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.hUs) {
                h.this.hUq.setChecked(true);
                h.this.hUr.setChecked(true);
                h.this.hUt.setChecked(false);
                h.this.hUu.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.hUt) {
                h.this.hUq.setChecked(true);
                h.this.hUr.setChecked(true);
                h.this.hUs.setChecked(true);
                h.this.hUu.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.hUu) {
                h.this.hUq.setChecked(true);
                h.this.hUr.setChecked(true);
                h.this.hUs.setChecked(true);
                h.this.hUt.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.mrp != null) {
                h.this.mrp.DH(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d mrn;
    private b mro;
    private e mrp;
    private LinearLayout mrq;
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
        void DH(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.dWp = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.dWr = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dJr = (TextView) this.view.findViewById(R.id.title);
            this.dWs = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dWt = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.hUq = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.hUq.setOnClickListener(this.mOnClickListener);
            this.hUr = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.hUr.setOnClickListener(this.mOnClickListener);
            this.hUs = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.hUs.setOnClickListener(this.mOnClickListener);
            this.hUt = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.hUt.setOnClickListener(this.mOnClickListener);
            this.hUu = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.hUu.setOnClickListener(this.mOnClickListener);
            this.mrq = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.dWp;
    }

    public ViewGroup getView() {
        return this.dWr;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void we(boolean z) {
        this.hUq.setEnabled(z);
        this.hUr.setEnabled(z);
        this.hUs.setEnabled(z);
        this.hUt.setEnabled(z);
        this.hUu.setEnabled(z);
    }

    public void GP(int i) {
        switch (i) {
            case 1:
                this.hUq.setChecked(true);
                this.hUr.setChecked(false);
                this.hUs.setChecked(false);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                return;
            case 2:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(false);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                return;
            case 3:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(true);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                return;
            case 4:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(false);
                return;
            case 5:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void GQ(int i) {
        this.mrq.setVisibility(i);
    }

    public void H(int i, int i2, int i3, int i4) {
        this.mrq.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dJr.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dJr.setTextSize(0, l.getDimens(this.dWp, i));
    }

    public d dtQ() {
        return this.mrn;
    }

    public void aS(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.dWr.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.dWr.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mro = bVar;
    }

    public void a(e eVar) {
        this.mrp = eVar;
    }

    public void GR(int i) {
        this.dWt.setVisibility(i);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.dJr, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.dJr, R.color.cp_cont_j);
        ao.setBackgroundColor(this.dWs, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.dWt, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.dWt, R.color.cp_cont_f);
        ao.setBackgroundResource(this.mrq, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aZb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dJr.setText(this.titleText);
        } else {
            this.dJr.setVisibility(8);
        }
        if (this.mro != null) {
            this.dWt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.mro.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View dWa;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h mrs;
        private c mrt;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int dWb = R.drawable.person_more_pop_item_bg_selector;
        private int dWc = 17;
        private boolean dWe = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mrt != null) {
                    a.this.mrt.onClick();
                }
                if (a.this.mrs != null && a.this.mrs.dtQ() != null) {
                    a.this.mrs.dtQ().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.mrs = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.mrt = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ao.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ao.setBackgroundColor(this.dWa, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mrs != null && this.mrs.getContext() != null) {
                this.mView = LayoutInflater.from(this.mrs.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mrs.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.dWc);
                this.dWa = this.mView.findViewById(R.id.divider_line);
                if (this.dWe) {
                    this.dWa.setVisibility(0);
                } else {
                    this.dWa.setVisibility(8);
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
