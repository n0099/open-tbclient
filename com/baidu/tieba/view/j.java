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
    private TextView anp;
    private RadioButton dXE;
    private RadioButton dXF;
    private RadioButton dXG;
    private RadioButton dXH;
    private RadioButton dXI;
    private Context hQY;
    private LinearLayout hQZ;
    private View hRa;
    private TextView hRb;
    private d hSg;
    private b hSh;
    private e hSi;
    private LinearLayout hSj;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dXE) {
                j.this.dXF.setChecked(false);
                j.this.dXG.setChecked(false);
                j.this.dXH.setChecked(false);
                j.this.dXI.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dXF) {
                j.this.dXE.setChecked(true);
                j.this.dXG.setChecked(false);
                j.this.dXH.setChecked(false);
                j.this.dXI.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dXG) {
                j.this.dXE.setChecked(true);
                j.this.dXF.setChecked(true);
                j.this.dXH.setChecked(false);
                j.this.dXI.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dXH) {
                j.this.dXE.setChecked(true);
                j.this.dXF.setChecked(true);
                j.this.dXG.setChecked(true);
                j.this.dXI.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dXI) {
                j.this.dXE.setChecked(true);
                j.this.dXF.setChecked(true);
                j.this.dXG.setChecked(true);
                j.this.dXH.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hSi != null) {
                j.this.hSi.ub(j.this.mScore);
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
        void ub(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hQY = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hQZ = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.anp = (TextView) this.view.findViewById(e.g.title);
            this.hRa = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hRb = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
            this.dXE = (RadioButton) this.view.findViewById(e.g.comment_grade_1);
            this.dXE.setOnClickListener(this.mOnClickListener);
            this.dXF = (RadioButton) this.view.findViewById(e.g.comment_grade_2);
            this.dXF.setOnClickListener(this.mOnClickListener);
            this.dXG = (RadioButton) this.view.findViewById(e.g.comment_grade_3);
            this.dXG.setOnClickListener(this.mOnClickListener);
            this.dXH = (RadioButton) this.view.findViewById(e.g.comment_grade_4);
            this.dXH.setOnClickListener(this.mOnClickListener);
            this.dXI = (RadioButton) this.view.findViewById(e.g.comment_grade_5);
            this.dXI.setOnClickListener(this.mOnClickListener);
            this.hSj = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hQY;
    }

    public ViewGroup akV() {
        return this.hQZ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void or(boolean z) {
        this.dXE.setEnabled(z);
        this.dXF.setEnabled(z);
        this.dXG.setEnabled(z);
        this.dXH.setEnabled(z);
        this.dXI.setEnabled(z);
    }

    public void xc(int i) {
        switch (i) {
            case 1:
                this.dXE.setChecked(true);
                this.dXF.setChecked(false);
                this.dXG.setChecked(false);
                this.dXH.setChecked(false);
                this.dXI.setChecked(false);
                return;
            case 2:
                this.dXE.setChecked(true);
                this.dXF.setChecked(true);
                this.dXG.setChecked(false);
                this.dXH.setChecked(false);
                this.dXI.setChecked(false);
                return;
            case 3:
                this.dXE.setChecked(true);
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(false);
                this.dXI.setChecked(false);
                return;
            case 4:
                this.dXE.setChecked(true);
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(false);
                return;
            case 5:
                this.dXE.setChecked(true);
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void xd(int i) {
        this.hSj.setVisibility(i);
    }

    public void z(int i, int i2, int i3, int i4) {
        this.hSj.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.anp.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.anp.setTextSize(0, l.h(this.hQY, i));
    }

    public d bNz() {
        return this.hSg;
    }

    public void ef(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hQZ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hQZ.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hSh = bVar;
    }

    public void a(e eVar) {
        this.hSi = eVar;
    }

    public void xe(int i) {
        this.hRb.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.anp, e.d.cp_bg_line_d);
        al.h(this.anp, e.d.cp_cont_j);
        al.j(this.hRa, e.d.cp_bg_line_c);
        al.i(this.hRb, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hRb, e.d.cp_cont_f);
        al.i(this.hSj, e.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bNw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.anp.setText(this.titleText);
        } else {
            this.anp.setVisibility(8);
        }
        if (this.hSh != null) {
            this.hRb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hSh.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View euT;
        private j hSl;
        private c hSm;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hRg = e.f.person_more_pop_item_bg_selector;
        private int hRh = 17;
        private boolean hRj = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hSm != null) {
                    a.this.hSm.onClick();
                }
                if (a.this.hSl != null && a.this.hSl.bNz() != null) {
                    a.this.hSl.bNz().hR(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.hSl = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hSm = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.euT, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hSl != null && this.hSl.getContext() != null) {
                this.mView = LayoutInflater.from(this.hSl.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hSl.akV(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hRh);
                this.euT = this.mView.findViewById(e.g.divider_line);
                if (this.hRj) {
                    this.euT.setVisibility(0);
                } else {
                    this.euT.setVisibility(8);
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
