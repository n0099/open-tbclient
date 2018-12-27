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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private TextView amN;
    private RadioButton dWY;
    private RadioButton dWZ;
    private RadioButton dXa;
    private RadioButton dXb;
    private RadioButton dXc;
    private Context hPR;
    private LinearLayout hPS;
    private View hPT;
    private TextView hPU;
    private d hQZ;
    private b hRa;
    private e hRb;
    private LinearLayout hRc;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dWY) {
                j.this.dWZ.setChecked(false);
                j.this.dXa.setChecked(false);
                j.this.dXb.setChecked(false);
                j.this.dXc.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dWZ) {
                j.this.dWY.setChecked(true);
                j.this.dXa.setChecked(false);
                j.this.dXb.setChecked(false);
                j.this.dXc.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dXa) {
                j.this.dWY.setChecked(true);
                j.this.dWZ.setChecked(true);
                j.this.dXb.setChecked(false);
                j.this.dXc.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dXb) {
                j.this.dWY.setChecked(true);
                j.this.dWZ.setChecked(true);
                j.this.dXa.setChecked(true);
                j.this.dXc.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dXc) {
                j.this.dWY.setChecked(true);
                j.this.dWZ.setChecked(true);
                j.this.dXa.setChecked(true);
                j.this.dXb.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hRb != null) {
                j.this.hRb.tX(j.this.mScore);
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
        void hR(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void tX(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hPR = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hPS = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.amN = (TextView) this.view.findViewById(e.g.title);
            this.hPT = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hPU = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
            this.dWY = (RadioButton) this.view.findViewById(e.g.comment_grade_1);
            this.dWY.setOnClickListener(this.mOnClickListener);
            this.dWZ = (RadioButton) this.view.findViewById(e.g.comment_grade_2);
            this.dWZ.setOnClickListener(this.mOnClickListener);
            this.dXa = (RadioButton) this.view.findViewById(e.g.comment_grade_3);
            this.dXa.setOnClickListener(this.mOnClickListener);
            this.dXb = (RadioButton) this.view.findViewById(e.g.comment_grade_4);
            this.dXb.setOnClickListener(this.mOnClickListener);
            this.dXc = (RadioButton) this.view.findViewById(e.g.comment_grade_5);
            this.dXc.setOnClickListener(this.mOnClickListener);
            this.hRc = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hPR;
    }

    public ViewGroup aky() {
        return this.hPS;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void oq(boolean z) {
        this.dWY.setEnabled(z);
        this.dWZ.setEnabled(z);
        this.dXa.setEnabled(z);
        this.dXb.setEnabled(z);
        this.dXc.setEnabled(z);
    }

    public void xa(int i) {
        switch (i) {
            case 1:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(false);
                this.dXa.setChecked(false);
                this.dXb.setChecked(false);
                this.dXc.setChecked(false);
                return;
            case 2:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(false);
                this.dXb.setChecked(false);
                this.dXc.setChecked(false);
                return;
            case 3:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(true);
                this.dXb.setChecked(false);
                this.dXc.setChecked(false);
                return;
            case 4:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(true);
                this.dXb.setChecked(true);
                this.dXc.setChecked(false);
                return;
            case 5:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(true);
                this.dXb.setChecked(true);
                this.dXc.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void xb(int i) {
        this.hRc.setVisibility(i);
    }

    public void z(int i, int i2, int i3, int i4) {
        this.hRc.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.amN.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.amN.setTextSize(0, l.h(this.hPR, i));
    }

    public d bMR() {
        return this.hQZ;
    }

    public void ee(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hPS.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hPS.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hRa = bVar;
    }

    public void a(e eVar) {
        this.hRb = eVar;
    }

    public void xc(int i) {
        this.hPU.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.amN, e.d.cp_bg_line_d);
        al.h(this.amN, e.d.cp_cont_j);
        al.j(this.hPT, e.d.cp_bg_line_c);
        al.i(this.hPU, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hPU, e.d.cp_cont_f);
        al.i(this.hRc, e.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bMO() {
        if (!StringUtils.isNull(this.titleText)) {
            this.amN.setText(this.titleText);
        } else {
            this.amN.setVisibility(8);
        }
        if (this.hRa != null) {
            this.hPU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hRa.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eun;
        private j hRe;
        private c hRf;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hPZ = e.f.person_more_pop_item_bg_selector;
        private int hQa = 17;
        private boolean hQc = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hRf != null) {
                    a.this.hRf.onClick();
                }
                if (a.this.hRe != null && a.this.hRe.bMR() != null) {
                    a.this.hRe.bMR().hR(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.hRe = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hRf = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.eun, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hRe != null && this.hRe.getContext() != null) {
                this.mView = LayoutInflater.from(this.hRe.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hRe.aky(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hQa);
                this.eun = this.mView.findViewById(e.g.divider_line);
                if (this.hQc) {
                    this.eun.setVisibility(0);
                } else {
                    this.eun.setVisibility(8);
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
