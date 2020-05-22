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
    private RadioButton hAA;
    private RadioButton hAw;
    private RadioButton hAx;
    private RadioButton hAy;
    private RadioButton hAz;
    private d lOf;
    private b lOg;
    private e lOh;
    private LinearLayout lOi;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.hAw) {
                h.this.hAx.setChecked(false);
                h.this.hAy.setChecked(false);
                h.this.hAz.setChecked(false);
                h.this.hAA.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.hAx) {
                h.this.hAw.setChecked(true);
                h.this.hAy.setChecked(false);
                h.this.hAz.setChecked(false);
                h.this.hAA.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.hAy) {
                h.this.hAw.setChecked(true);
                h.this.hAx.setChecked(true);
                h.this.hAz.setChecked(false);
                h.this.hAA.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.hAz) {
                h.this.hAw.setChecked(true);
                h.this.hAx.setChecked(true);
                h.this.hAy.setChecked(true);
                h.this.hAA.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.hAA) {
                h.this.hAw.setChecked(true);
                h.this.hAx.setChecked(true);
                h.this.hAy.setChecked(true);
                h.this.hAz.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.lOh != null) {
                h.this.lOh.Ch(h.this.mScore);
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
        void Ch(int i);
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
            this.hAw = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.hAw.setOnClickListener(this.mOnClickListener);
            this.hAx = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.hAx.setOnClickListener(this.mOnClickListener);
            this.hAy = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.hAy.setOnClickListener(this.mOnClickListener);
            this.hAz = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.hAz.setOnClickListener(this.mOnClickListener);
            this.hAA = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.hAA.setOnClickListener(this.mOnClickListener);
            this.lOi = (LinearLayout) this.view.findViewById(R.id.comment_grade);
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
        this.hAw.setEnabled(z);
        this.hAx.setEnabled(z);
        this.hAy.setEnabled(z);
        this.hAz.setEnabled(z);
        this.hAA.setEnabled(z);
    }

    public void Fn(int i) {
        switch (i) {
            case 1:
                this.hAw.setChecked(true);
                this.hAx.setChecked(false);
                this.hAy.setChecked(false);
                this.hAz.setChecked(false);
                this.hAA.setChecked(false);
                return;
            case 2:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(false);
                this.hAz.setChecked(false);
                this.hAA.setChecked(false);
                return;
            case 3:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(true);
                this.hAz.setChecked(false);
                this.hAA.setChecked(false);
                return;
            case 4:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(true);
                this.hAz.setChecked(true);
                this.hAA.setChecked(false);
                return;
            case 5:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(true);
                this.hAz.setChecked(true);
                this.hAA.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Fo(int i) {
        this.lOi.setVisibility(i);
    }

    public void G(int i, int i2, int i3, int i4) {
        this.lOi.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dyo.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dyo.setTextSize(0, l.getDimens(this.dJh, i));
    }

    public d dlY() {
        return this.lOf;
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
        this.lOg = bVar;
    }

    public void a(e eVar) {
        this.lOh = eVar;
    }

    public void Fp(int i) {
        this.dJl.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dyo, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dyo, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.dJk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dJl, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.dJl, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.lOi, R.drawable.bg_bottom_up_list_dialog_item);
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
        if (this.lOg != null) {
            this.dJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.lOg.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View dIS;
        private h lOk;
        private c lOl;
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
                if (a.this.lOl != null) {
                    a.this.lOl.onClick();
                }
                if (a.this.lOk != null && a.this.lOk.dlY() != null) {
                    a.this.lOk.dlY().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.lOk = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.lOl = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.dIS, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.lOk != null && this.lOk.getContext() != null) {
                this.mView = LayoutInflater.from(this.lOk.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.lOk.getView(), false);
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
