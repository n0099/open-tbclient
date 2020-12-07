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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private TextView eAz;
    private Context eOg;
    private LinearLayout eOi;
    private View eOl;
    private TextView eOm;
    private RadioButton jle;
    private RadioButton jlf;
    private RadioButton jlg;
    private RadioButton jlh;
    private RadioButton jli;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.jle) {
                h.this.jlf.setChecked(false);
                h.this.jlg.setChecked(false);
                h.this.jlh.setChecked(false);
                h.this.jli.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.jlf) {
                h.this.jle.setChecked(true);
                h.this.jlg.setChecked(false);
                h.this.jlh.setChecked(false);
                h.this.jli.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.jlg) {
                h.this.jle.setChecked(true);
                h.this.jlf.setChecked(true);
                h.this.jlh.setChecked(false);
                h.this.jli.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.jlh) {
                h.this.jle.setChecked(true);
                h.this.jlf.setChecked(true);
                h.this.jlg.setChecked(true);
                h.this.jli.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.jli) {
                h.this.jle.setChecked(true);
                h.this.jlf.setChecked(true);
                h.this.jlg.setChecked(true);
                h.this.jlh.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.nRf != null) {
                h.this.nRf.Je(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d nRd;
    private b nRe;
    private e nRf;
    private LinearLayout nRg;
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
        void Je(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eOg = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eOi = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eAz = (TextView) this.view.findViewById(R.id.title);
            this.eOl = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eOm = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.jle = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.jle.setOnClickListener(this.mOnClickListener);
            this.jlf = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.jlf.setOnClickListener(this.mOnClickListener);
            this.jlg = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.jlg.setOnClickListener(this.mOnClickListener);
            this.jlh = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.jlh.setOnClickListener(this.mOnClickListener);
            this.jli = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.jli.setOnClickListener(this.mOnClickListener);
            this.nRg = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eOg;
    }

    public ViewGroup getView() {
        return this.eOi;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void yX(boolean z) {
        this.jle.setEnabled(z);
        this.jlf.setEnabled(z);
        this.jlg.setEnabled(z);
        this.jlh.setEnabled(z);
        this.jli.setEnabled(z);
    }

    public void Mv(int i) {
        switch (i) {
            case 1:
                this.jle.setChecked(true);
                this.jlf.setChecked(false);
                this.jlg.setChecked(false);
                this.jlh.setChecked(false);
                this.jli.setChecked(false);
                return;
            case 2:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(false);
                this.jlh.setChecked(false);
                this.jli.setChecked(false);
                return;
            case 3:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(true);
                this.jlh.setChecked(false);
                this.jli.setChecked(false);
                return;
            case 4:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(true);
                this.jlh.setChecked(true);
                this.jli.setChecked(false);
                return;
            case 5:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(true);
                this.jlh.setChecked(true);
                this.jli.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Mw(int i) {
        this.nRg.setVisibility(i);
    }

    public void N(int i, int i2, int i3, int i4) {
        this.nRg.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.eAz.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.eAz.setTextSize(0, l.getDimens(this.eOg, i));
    }

    public d dYe() {
        return this.nRd;
    }

    public void bu(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eOi.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eOi.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nRe = bVar;
    }

    public void a(e eVar) {
        this.nRf = eVar;
    }

    public void Mx(int i) {
        this.eOm.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eAz, R.color.CAM_X0201);
        ap.setViewTextColor(this.eAz, R.color.CAM_X0107);
        ap.setBackgroundColor(this.eOl, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eOm, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eOm, R.color.CAM_X0106);
        ap.setBackgroundResource(this.nRg, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View brP() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eAz.setText(this.titleText);
        } else {
            this.eAz.setVisibility(8);
        }
        if (this.nRe != null) {
            this.eOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.nRe.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eNL;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h nRi;
        private c nRj;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eNM = R.drawable.person_more_pop_item_bg_selector;
        private int eNN = 17;
        private boolean eNP = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nRj != null) {
                    a.this.nRj.onClick();
                }
                if (a.this.nRi != null && a.this.nRi.dYe() != null) {
                    a.this.nRi.dYe().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.nRi = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nRj = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0106);
            ap.setBackgroundColor(this.eNL, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nRi != null && this.nRi.getContext() != null) {
                this.mView = LayoutInflater.from(this.nRi.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nRi.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eNN);
                this.eNL = this.mView.findViewById(R.id.divider_line);
                if (this.eNP) {
                    this.eNL.setVisibility(0);
                } else {
                    this.eNL.setVisibility(8);
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
