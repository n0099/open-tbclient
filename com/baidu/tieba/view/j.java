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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private TextView abu;
    private RadioButton dvh;
    private RadioButton dvi;
    private RadioButton dvj;
    private RadioButton dvk;
    private RadioButton dvl;
    private TextView hnA;
    private Context hnx;
    private LinearLayout hny;
    private View hnz;
    private d hoE;
    private b hoF;
    private e hoG;
    private LinearLayout hoH;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dvh) {
                j.this.dvi.setChecked(false);
                j.this.dvj.setChecked(false);
                j.this.dvk.setChecked(false);
                j.this.dvl.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dvi) {
                j.this.dvh.setChecked(true);
                j.this.dvj.setChecked(false);
                j.this.dvk.setChecked(false);
                j.this.dvl.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dvj) {
                j.this.dvh.setChecked(true);
                j.this.dvi.setChecked(true);
                j.this.dvk.setChecked(false);
                j.this.dvl.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dvk) {
                j.this.dvh.setChecked(true);
                j.this.dvi.setChecked(true);
                j.this.dvj.setChecked(true);
                j.this.dvl.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dvl) {
                j.this.dvh.setChecked(true);
                j.this.dvi.setChecked(true);
                j.this.dvj.setChecked(true);
                j.this.dvk.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hoG != null) {
                j.this.hoG.onClick(j.this.mScore);
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
        void onClick(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hnx = context;
            this.view = LayoutInflater.from(context).inflate(d.i.rate_list_dialog_view, (ViewGroup) null);
            this.hny = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.abu = (TextView) this.view.findViewById(d.g.title);
            this.hnz = this.view.findViewById(d.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hnA = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
            this.dvh = (RadioButton) this.view.findViewById(d.g.comment_grade_1);
            this.dvh.setOnClickListener(this.mOnClickListener);
            this.dvi = (RadioButton) this.view.findViewById(d.g.comment_grade_2);
            this.dvi.setOnClickListener(this.mOnClickListener);
            this.dvj = (RadioButton) this.view.findViewById(d.g.comment_grade_3);
            this.dvj.setOnClickListener(this.mOnClickListener);
            this.dvk = (RadioButton) this.view.findViewById(d.g.comment_grade_4);
            this.dvk.setOnClickListener(this.mOnClickListener);
            this.dvl = (RadioButton) this.view.findViewById(d.g.comment_grade_5);
            this.dvl.setOnClickListener(this.mOnClickListener);
            this.hoH = (LinearLayout) this.view.findViewById(d.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hnx;
    }

    public ViewGroup adO() {
        return this.hny;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void nw(boolean z) {
        this.dvh.setEnabled(z);
        this.dvi.setEnabled(z);
        this.dvj.setEnabled(z);
        this.dvk.setEnabled(z);
        this.dvl.setEnabled(z);
    }

    public void vb(int i) {
        switch (i) {
            case 1:
                this.dvh.setChecked(true);
                this.dvi.setChecked(false);
                this.dvj.setChecked(false);
                this.dvk.setChecked(false);
                this.dvl.setChecked(false);
                return;
            case 2:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(false);
                this.dvk.setChecked(false);
                this.dvl.setChecked(false);
                return;
            case 3:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(true);
                this.dvk.setChecked(false);
                this.dvl.setChecked(false);
                return;
            case 4:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(true);
                this.dvk.setChecked(true);
                this.dvl.setChecked(false);
                return;
            case 5:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(true);
                this.dvk.setChecked(true);
                this.dvl.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void vc(int i) {
        this.hoH.setVisibility(i);
    }

    public void A(int i, int i2, int i3, int i4) {
        this.hoH.setPadding(i, i2, i3, i4);
    }

    public void B(int i, int i2, int i3, int i4) {
        this.abu.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.abu.setTextSize(0, l.e(this.hnx, i));
    }

    public d bFI() {
        return this.hoE;
    }

    public void dQ(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hny.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hny.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hoF = bVar;
    }

    public void a(e eVar) {
        this.hoG = eVar;
    }

    public void vd(int i) {
        this.hnA.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.j(this.abu, d.C0142d.cp_bg_line_d);
        am.h(this.abu, d.C0142d.cp_cont_j);
        am.j(this.hnz, d.C0142d.cp_bg_line_c);
        am.i(this.hnA, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.hnA, d.C0142d.cp_cont_f);
        am.i(this.hoH, d.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bFF() {
        if (!StringUtils.isNull(this.titleText)) {
            this.abu.setText(this.titleText);
        } else {
            this.abu.setVisibility(8);
        }
        if (this.hoF != null) {
            this.hnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hoF.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aoM;
        private View dRm;
        private j hoJ;
        private c hoK;
        private TextView mTextView;
        private View mView;
        private int mTextColor = d.f.person_more_pop_cancel_text_selector;
        private int hnF = d.f.person_more_pop_item_bg_selector;
        private int hnG = 17;
        private boolean hnI = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hoK != null) {
                    a.this.hoK.onClick();
                }
                if (a.this.hoJ != null && a.this.hoJ.bFI() != null) {
                    a.this.hoJ.bFI().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.aoM = str;
            this.hoJ = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hoK = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            am.h(this.mTextView, d.C0142d.cp_cont_f);
            am.j(this.dRm, d.C0142d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hoJ != null && this.hoJ.getContext() != null) {
                this.mView = LayoutInflater.from(this.hoJ.getContext()).inflate(d.i.bottom_up_list_dialog_item, this.hoJ.adO(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.aoM);
                this.mTextView.setGravity(this.hnG);
                this.dRm = this.mView.findViewById(d.g.divider_line);
                if (this.hnI) {
                    this.dRm.setVisibility(0);
                } else {
                    this.dRm.setVisibility(8);
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
