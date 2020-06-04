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
public class h {
    private Context dJh;
    private LinearLayout dJj;
    private View dJk;
    private TextView dJl;
    private TextView dyo;
    private RadioButton hBj;
    private RadioButton hBk;
    private RadioButton hBl;
    private RadioButton hBm;
    private RadioButton hBn;
    private d lPn;
    private b lPo;
    private e lPp;
    private LinearLayout lPq;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.hBj) {
                h.this.hBk.setChecked(false);
                h.this.hBl.setChecked(false);
                h.this.hBm.setChecked(false);
                h.this.hBn.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.hBk) {
                h.this.hBj.setChecked(true);
                h.this.hBl.setChecked(false);
                h.this.hBm.setChecked(false);
                h.this.hBn.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.hBl) {
                h.this.hBj.setChecked(true);
                h.this.hBk.setChecked(true);
                h.this.hBm.setChecked(false);
                h.this.hBn.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.hBm) {
                h.this.hBj.setChecked(true);
                h.this.hBk.setChecked(true);
                h.this.hBl.setChecked(true);
                h.this.hBn.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.hBn) {
                h.this.hBj.setChecked(true);
                h.this.hBk.setChecked(true);
                h.this.hBl.setChecked(true);
                h.this.hBm.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.lPp != null) {
                h.this.lPp.Cj(h.this.mScore);
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
        void Cj(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.dJh = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.dJj = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dyo = (TextView) this.view.findViewById(R.id.title);
            this.dJk = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dJl = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.hBj = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.hBj.setOnClickListener(this.mOnClickListener);
            this.hBk = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.hBk.setOnClickListener(this.mOnClickListener);
            this.hBl = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.hBl.setOnClickListener(this.mOnClickListener);
            this.hBm = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.hBm.setOnClickListener(this.mOnClickListener);
            this.hBn = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.hBn.setOnClickListener(this.mOnClickListener);
            this.lPq = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.dJh;
    }

    public ViewGroup getView() {
        return this.dJj;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void vi(boolean z) {
        this.hBj.setEnabled(z);
        this.hBk.setEnabled(z);
        this.hBl.setEnabled(z);
        this.hBm.setEnabled(z);
        this.hBn.setEnabled(z);
    }

    public void Fp(int i) {
        switch (i) {
            case 1:
                this.hBj.setChecked(true);
                this.hBk.setChecked(false);
                this.hBl.setChecked(false);
                this.hBm.setChecked(false);
                this.hBn.setChecked(false);
                return;
            case 2:
                this.hBj.setChecked(true);
                this.hBk.setChecked(true);
                this.hBl.setChecked(false);
                this.hBm.setChecked(false);
                this.hBn.setChecked(false);
                return;
            case 3:
                this.hBj.setChecked(true);
                this.hBk.setChecked(true);
                this.hBl.setChecked(true);
                this.hBm.setChecked(false);
                this.hBn.setChecked(false);
                return;
            case 4:
                this.hBj.setChecked(true);
                this.hBk.setChecked(true);
                this.hBl.setChecked(true);
                this.hBm.setChecked(true);
                this.hBn.setChecked(false);
                return;
            case 5:
                this.hBj.setChecked(true);
                this.hBk.setChecked(true);
                this.hBl.setChecked(true);
                this.hBm.setChecked(true);
                this.hBn.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Fq(int i) {
        this.lPq.setVisibility(i);
    }

    public void G(int i, int i2, int i3, int i4) {
        this.lPq.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dyo.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dyo.setTextSize(0, l.getDimens(this.dJh, i));
    }

    public d dmn() {
        return this.lPn;
    }

    public void aD(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.dJj.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.dJj.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.lPo = bVar;
    }

    public void a(e eVar) {
        this.lPp = eVar;
    }

    public void Fr(int i) {
        this.dJl.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dyo, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dyo, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.dJk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dJl, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.dJl, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.lPq, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aTh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dyo.setText(this.titleText);
        } else {
            this.dyo.setVisibility(8);
        }
        if (this.lPo != null) {
            this.dJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.lPo.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View dIS;
        private h lPs;
        private c lPt;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int dIT = R.drawable.person_more_pop_item_bg_selector;
        private int dIU = 17;
        private boolean dIW = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lPt != null) {
                    a.this.lPt.onClick();
                }
                if (a.this.lPs != null && a.this.lPs.dmn() != null) {
                    a.this.lPs.dmn().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.lPs = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.lPt = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.dIS, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.lPs != null && this.lPs.getContext() != null) {
                this.mView = LayoutInflater.from(this.lPs.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.lPs.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.dIU);
                this.dIS = this.mView.findViewById(R.id.divider_line);
                if (this.dIW) {
                    this.dIS.setVisibility(0);
                } else {
                    this.dIS.setVisibility(8);
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
