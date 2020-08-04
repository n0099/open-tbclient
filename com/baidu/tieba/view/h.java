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
    private RadioButton hUs;
    private RadioButton hUt;
    private RadioButton hUu;
    private RadioButton hUv;
    private RadioButton hUw;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.hUs) {
                h.this.hUt.setChecked(false);
                h.this.hUu.setChecked(false);
                h.this.hUv.setChecked(false);
                h.this.hUw.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.hUt) {
                h.this.hUs.setChecked(true);
                h.this.hUu.setChecked(false);
                h.this.hUv.setChecked(false);
                h.this.hUw.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.hUu) {
                h.this.hUs.setChecked(true);
                h.this.hUt.setChecked(true);
                h.this.hUv.setChecked(false);
                h.this.hUw.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.hUv) {
                h.this.hUs.setChecked(true);
                h.this.hUt.setChecked(true);
                h.this.hUu.setChecked(true);
                h.this.hUw.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.hUw) {
                h.this.hUs.setChecked(true);
                h.this.hUt.setChecked(true);
                h.this.hUu.setChecked(true);
                h.this.hUv.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.mrr != null) {
                h.this.mrr.DH(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d mrp;
    private b mrq;
    private e mrr;
    private LinearLayout mrs;
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
            this.hUs = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.hUs.setOnClickListener(this.mOnClickListener);
            this.hUt = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.hUt.setOnClickListener(this.mOnClickListener);
            this.hUu = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.hUu.setOnClickListener(this.mOnClickListener);
            this.hUv = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.hUv.setOnClickListener(this.mOnClickListener);
            this.hUw = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.hUw.setOnClickListener(this.mOnClickListener);
            this.mrs = (LinearLayout) this.view.findViewById(R.id.comment_grade);
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
        this.hUs.setEnabled(z);
        this.hUt.setEnabled(z);
        this.hUu.setEnabled(z);
        this.hUv.setEnabled(z);
        this.hUw.setEnabled(z);
    }

    public void GP(int i) {
        switch (i) {
            case 1:
                this.hUs.setChecked(true);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                this.hUv.setChecked(false);
                this.hUw.setChecked(false);
                return;
            case 2:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(false);
                this.hUv.setChecked(false);
                this.hUw.setChecked(false);
                return;
            case 3:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                this.hUv.setChecked(false);
                this.hUw.setChecked(false);
                return;
            case 4:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                this.hUv.setChecked(true);
                this.hUw.setChecked(false);
                return;
            case 5:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                this.hUv.setChecked(true);
                this.hUw.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void GQ(int i) {
        this.mrs.setVisibility(i);
    }

    public void H(int i, int i2, int i3, int i4) {
        this.mrs.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dJr.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dJr.setTextSize(0, l.getDimens(this.dWp, i));
    }

    public d dtR() {
        return this.mrp;
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
        this.mrq = bVar;
    }

    public void a(e eVar) {
        this.mrr = eVar;
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
        ao.setBackgroundResource(this.mrs, R.drawable.bg_bottom_up_list_dialog_item);
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
        if (this.mrq != null) {
            this.dWt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.mrq.onClick();
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
        private h mru;
        private c mrv;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int dWb = R.drawable.person_more_pop_item_bg_selector;
        private int dWc = 17;
        private boolean dWe = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mrv != null) {
                    a.this.mrv.onClick();
                }
                if (a.this.mru != null && a.this.mru.dtR() != null) {
                    a.this.mru.dtR().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.mru = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.mrv = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ao.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ao.setBackgroundColor(this.dWa, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mru != null && this.mru.getContext() != null) {
                this.mView = LayoutInflater.from(this.mru.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mru.getView(), false);
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
