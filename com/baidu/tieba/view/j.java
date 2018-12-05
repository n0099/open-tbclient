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
    private RadioButton dUh;
    private RadioButton dUi;
    private RadioButton dUj;
    private RadioButton dUk;
    private RadioButton dUl;
    private Context hMG;
    private LinearLayout hMH;
    private View hMI;
    private TextView hMJ;
    private d hNO;
    private b hNP;
    private e hNQ;
    private LinearLayout hNR;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dUh) {
                j.this.dUi.setChecked(false);
                j.this.dUj.setChecked(false);
                j.this.dUk.setChecked(false);
                j.this.dUl.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dUi) {
                j.this.dUh.setChecked(true);
                j.this.dUj.setChecked(false);
                j.this.dUk.setChecked(false);
                j.this.dUl.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dUj) {
                j.this.dUh.setChecked(true);
                j.this.dUi.setChecked(true);
                j.this.dUk.setChecked(false);
                j.this.dUl.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dUk) {
                j.this.dUh.setChecked(true);
                j.this.dUi.setChecked(true);
                j.this.dUj.setChecked(true);
                j.this.dUl.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dUl) {
                j.this.dUh.setChecked(true);
                j.this.dUi.setChecked(true);
                j.this.dUj.setChecked(true);
                j.this.dUk.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hNQ != null) {
                j.this.hNQ.tK(j.this.mScore);
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
        void hQ(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void tK(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hMG = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hMH = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.amN = (TextView) this.view.findViewById(e.g.title);
            this.hMI = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hMJ = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
            this.dUh = (RadioButton) this.view.findViewById(e.g.comment_grade_1);
            this.dUh.setOnClickListener(this.mOnClickListener);
            this.dUi = (RadioButton) this.view.findViewById(e.g.comment_grade_2);
            this.dUi.setOnClickListener(this.mOnClickListener);
            this.dUj = (RadioButton) this.view.findViewById(e.g.comment_grade_3);
            this.dUj.setOnClickListener(this.mOnClickListener);
            this.dUk = (RadioButton) this.view.findViewById(e.g.comment_grade_4);
            this.dUk.setOnClickListener(this.mOnClickListener);
            this.dUl = (RadioButton) this.view.findViewById(e.g.comment_grade_5);
            this.dUl.setOnClickListener(this.mOnClickListener);
            this.hNR = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hMG;
    }

    public ViewGroup akg() {
        return this.hMH;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void on(boolean z) {
        this.dUh.setEnabled(z);
        this.dUi.setEnabled(z);
        this.dUj.setEnabled(z);
        this.dUk.setEnabled(z);
        this.dUl.setEnabled(z);
    }

    public void wN(int i) {
        switch (i) {
            case 1:
                this.dUh.setChecked(true);
                this.dUi.setChecked(false);
                this.dUj.setChecked(false);
                this.dUk.setChecked(false);
                this.dUl.setChecked(false);
                return;
            case 2:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(false);
                this.dUk.setChecked(false);
                this.dUl.setChecked(false);
                return;
            case 3:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(true);
                this.dUk.setChecked(false);
                this.dUl.setChecked(false);
                return;
            case 4:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(true);
                this.dUk.setChecked(true);
                this.dUl.setChecked(false);
                return;
            case 5:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(true);
                this.dUk.setChecked(true);
                this.dUl.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void wO(int i) {
        this.hNR.setVisibility(i);
    }

    public void z(int i, int i2, int i3, int i4) {
        this.hNR.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.amN.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.amN.setTextSize(0, l.h(this.hMG, i));
    }

    public d bMc() {
        return this.hNO;
    }

    public void ed(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hMH.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hMH.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hNP = bVar;
    }

    public void a(e eVar) {
        this.hNQ = eVar;
    }

    public void wP(int i) {
        this.hMJ.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.amN, e.d.cp_bg_line_d);
        al.h(this.amN, e.d.cp_cont_j);
        al.j(this.hMI, e.d.cp_bg_line_c);
        al.i(this.hMJ, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hMJ, e.d.cp_cont_f);
        al.i(this.hNR, e.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bLZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.amN.setText(this.titleText);
        } else {
            this.amN.setVisibility(8);
        }
        if (this.hNP != null) {
            this.hMJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hNP.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View erw;
        private j hNT;
        private c hNU;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hMO = e.f.person_more_pop_item_bg_selector;
        private int hMP = 17;
        private boolean hMR = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hNU != null) {
                    a.this.hNU.onClick();
                }
                if (a.this.hNT != null && a.this.hNT.bMc() != null) {
                    a.this.hNT.bMc().hQ(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.hNT = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hNU = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.erw, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hNT != null && this.hNT.getContext() != null) {
                this.mView = LayoutInflater.from(this.hNT.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hNT.akg(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hMP);
                this.erw = this.mView.findViewById(e.g.divider_line);
                if (this.hMR) {
                    this.erw.setVisibility(0);
                } else {
                    this.erw.setVisibility(8);
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
