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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private List<a> aMF;
    private LinearLayout bFA;
    private View bFB;
    private TextView bFC;
    private Context bFy;
    private TextView btX;
    private RadioButton fli;
    private RadioButton flj;
    private RadioButton flk;
    private RadioButton fll;
    private RadioButton flm;
    private LinearLayout jiA;
    private d jix;
    private b jiy;
    private e jiz;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fli) {
                j.this.flj.setChecked(false);
                j.this.flk.setChecked(false);
                j.this.fll.setChecked(false);
                j.this.flm.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.flj) {
                j.this.fli.setChecked(true);
                j.this.flk.setChecked(false);
                j.this.fll.setChecked(false);
                j.this.flm.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.flk) {
                j.this.fli.setChecked(true);
                j.this.flj.setChecked(true);
                j.this.fll.setChecked(false);
                j.this.flm.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fll) {
                j.this.fli.setChecked(true);
                j.this.flj.setChecked(true);
                j.this.flk.setChecked(true);
                j.this.flm.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.flm) {
                j.this.fli.setChecked(true);
                j.this.flj.setChecked(true);
                j.this.flk.setChecked(true);
                j.this.fll.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jiz != null) {
                j.this.jiz.xO(j.this.mScore);
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
        void lI(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void xO(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.bFy = context;
            this.view = LayoutInflater.from(context).inflate(d.h.rate_list_dialog_view, (ViewGroup) null);
            this.bFA = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.btX = (TextView) this.view.findViewById(d.g.title);
            this.bFB = this.view.findViewById(d.g.title_divide_line);
            this.aMF = new ArrayList();
            this.bFC = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
            this.fli = (RadioButton) this.view.findViewById(d.g.comment_grade_1);
            this.fli.setOnClickListener(this.mOnClickListener);
            this.flj = (RadioButton) this.view.findViewById(d.g.comment_grade_2);
            this.flj.setOnClickListener(this.mOnClickListener);
            this.flk = (RadioButton) this.view.findViewById(d.g.comment_grade_3);
            this.flk.setOnClickListener(this.mOnClickListener);
            this.fll = (RadioButton) this.view.findViewById(d.g.comment_grade_4);
            this.fll.setOnClickListener(this.mOnClickListener);
            this.flm = (RadioButton) this.view.findViewById(d.g.comment_grade_5);
            this.flm.setOnClickListener(this.mOnClickListener);
            this.jiA = (LinearLayout) this.view.findViewById(d.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.bFy;
    }

    public ViewGroup abi() {
        return this.bFA;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void qR(boolean z) {
        this.fli.setEnabled(z);
        this.flj.setEnabled(z);
        this.flk.setEnabled(z);
        this.fll.setEnabled(z);
        this.flm.setEnabled(z);
    }

    public void AN(int i) {
        switch (i) {
            case 1:
                this.fli.setChecked(true);
                this.flj.setChecked(false);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                this.flm.setChecked(false);
                return;
            case 2:
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                this.flm.setChecked(false);
                return;
            case 3:
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(true);
                this.fll.setChecked(false);
                this.flm.setChecked(false);
                return;
            case 4:
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(true);
                this.fll.setChecked(true);
                this.flm.setChecked(false);
                return;
            case 5:
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(true);
                this.fll.setChecked(true);
                this.flm.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void AO(int i) {
        this.jiA.setVisibility(i);
    }

    public void C(int i, int i2, int i3, int i4) {
        this.jiA.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.btX.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.btX.setTextSize(0, l.h(this.bFy, i));
    }

    public d cmP() {
        return this.jix;
    }

    public void P(List<a> list) {
        if (list != null) {
            this.aMF = list;
            this.bFA.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bFA.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jiy = bVar;
    }

    public void a(e eVar) {
        this.jiz = eVar;
    }

    public void AP(int i) {
        this.bFC.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.l(this.btX, d.C0236d.cp_bg_line_d);
        al.j(this.btX, d.C0236d.cp_cont_j);
        al.l(this.bFB, d.C0236d.cp_bg_line_c);
        al.k(this.bFC, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFC, d.C0236d.cp_cont_f);
        al.k(this.jiA, d.f.bg_bottom_up_list_dialog_item);
        if (this.aMF != null) {
            for (a aVar : this.aMF) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View abk() {
        if (!StringUtils.isNull(this.titleText)) {
            this.btX.setText(this.titleText);
        } else {
            this.btX.setVisibility(8);
        }
        if (this.jiy != null) {
            this.bFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jiy.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String alI;
        private View bFo;
        private j jiC;
        private c jiD;
        private TextView mTextView;
        private View mView;
        private int mTextColor = d.f.person_more_pop_cancel_text_selector;
        private int bFp = d.f.person_more_pop_item_bg_selector;
        private int bFq = 17;
        private boolean bFs = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jiD != null) {
                    a.this.jiD.onClick();
                }
                if (a.this.jiC != null && a.this.jiC.cmP() != null) {
                    a.this.jiC.cmP().lI(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.alI = str;
            this.jiC = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jiD = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.k(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            al.j(this.mTextView, d.C0236d.cp_cont_f);
            al.l(this.bFo, d.C0236d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jiC != null && this.jiC.getContext() != null) {
                this.mView = LayoutInflater.from(this.jiC.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jiC.abi(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alI);
                this.mTextView.setGravity(this.bFq);
                this.bFo = this.mView.findViewById(d.g.divider_line);
                if (this.bFs) {
                    this.bFo.setVisibility(0);
                } else {
                    this.bFo.setVisibility(8);
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
