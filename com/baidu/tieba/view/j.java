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
    private List<a> aMG;
    private Context bFA;
    private LinearLayout bFC;
    private View bFD;
    private TextView bFE;
    private TextView btZ;
    private RadioButton flh;
    private RadioButton fli;
    private RadioButton flj;
    private RadioButton flk;
    private RadioButton fll;
    private d jiJ;
    private b jiK;
    private e jiL;
    private LinearLayout jiM;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.flh) {
                j.this.fli.setChecked(false);
                j.this.flj.setChecked(false);
                j.this.flk.setChecked(false);
                j.this.fll.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fli) {
                j.this.flh.setChecked(true);
                j.this.flj.setChecked(false);
                j.this.flk.setChecked(false);
                j.this.fll.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.flj) {
                j.this.flh.setChecked(true);
                j.this.fli.setChecked(true);
                j.this.flk.setChecked(false);
                j.this.fll.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.flk) {
                j.this.flh.setChecked(true);
                j.this.fli.setChecked(true);
                j.this.flj.setChecked(true);
                j.this.fll.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fll) {
                j.this.flh.setChecked(true);
                j.this.fli.setChecked(true);
                j.this.flj.setChecked(true);
                j.this.flk.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jiL != null) {
                j.this.jiL.xO(j.this.mScore);
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
            this.bFA = context;
            this.view = LayoutInflater.from(context).inflate(d.h.rate_list_dialog_view, (ViewGroup) null);
            this.bFC = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.btZ = (TextView) this.view.findViewById(d.g.title);
            this.bFD = this.view.findViewById(d.g.title_divide_line);
            this.aMG = new ArrayList();
            this.bFE = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
            this.flh = (RadioButton) this.view.findViewById(d.g.comment_grade_1);
            this.flh.setOnClickListener(this.mOnClickListener);
            this.fli = (RadioButton) this.view.findViewById(d.g.comment_grade_2);
            this.fli.setOnClickListener(this.mOnClickListener);
            this.flj = (RadioButton) this.view.findViewById(d.g.comment_grade_3);
            this.flj.setOnClickListener(this.mOnClickListener);
            this.flk = (RadioButton) this.view.findViewById(d.g.comment_grade_4);
            this.flk.setOnClickListener(this.mOnClickListener);
            this.fll = (RadioButton) this.view.findViewById(d.g.comment_grade_5);
            this.fll.setOnClickListener(this.mOnClickListener);
            this.jiM = (LinearLayout) this.view.findViewById(d.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.bFA;
    }

    public ViewGroup abi() {
        return this.bFC;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void qR(boolean z) {
        this.flh.setEnabled(z);
        this.fli.setEnabled(z);
        this.flj.setEnabled(z);
        this.flk.setEnabled(z);
        this.fll.setEnabled(z);
    }

    public void AO(int i) {
        switch (i) {
            case 1:
                this.flh.setChecked(true);
                this.fli.setChecked(false);
                this.flj.setChecked(false);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                return;
            case 2:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(false);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                return;
            case 3:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                return;
            case 4:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(true);
                this.fll.setChecked(false);
                return;
            case 5:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(true);
                this.fll.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void AP(int i) {
        this.jiM.setVisibility(i);
    }

    public void C(int i, int i2, int i3, int i4) {
        this.jiM.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.btZ.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.btZ.setTextSize(0, l.h(this.bFA, i));
    }

    public d cnc() {
        return this.jiJ;
    }

    public void P(List<a> list) {
        if (list != null) {
            this.aMG = list;
            this.bFC.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bFC.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jiK = bVar;
    }

    public void a(e eVar) {
        this.jiL = eVar;
    }

    public void AQ(int i) {
        this.bFE.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.l(this.btZ, d.C0277d.cp_bg_line_d);
        al.j(this.btZ, d.C0277d.cp_cont_j);
        al.l(this.bFD, d.C0277d.cp_bg_line_c);
        al.k(this.bFE, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFE, d.C0277d.cp_cont_f);
        al.k(this.jiM, d.f.bg_bottom_up_list_dialog_item);
        if (this.aMG != null) {
            for (a aVar : this.aMG) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View abk() {
        if (!StringUtils.isNull(this.titleText)) {
            this.btZ.setText(this.titleText);
        } else {
            this.btZ.setVisibility(8);
        }
        if (this.jiK != null) {
            this.bFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jiK.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String alJ;
        private View bFq;
        private j jiO;
        private c jiP;
        private TextView mTextView;
        private View mView;
        private int mTextColor = d.f.person_more_pop_cancel_text_selector;
        private int bFr = d.f.person_more_pop_item_bg_selector;
        private int bFs = 17;
        private boolean bFu = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jiP != null) {
                    a.this.jiP.onClick();
                }
                if (a.this.jiO != null && a.this.jiO.cnc() != null) {
                    a.this.jiO.cnc().lI(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.alJ = str;
            this.jiO = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jiP = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.k(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            al.j(this.mTextView, d.C0277d.cp_cont_f);
            al.l(this.bFq, d.C0277d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jiO != null && this.jiO.getContext() != null) {
                this.mView = LayoutInflater.from(this.jiO.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jiO.abi(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alJ);
                this.mTextView.setGravity(this.bFs);
                this.bFq = this.mView.findViewById(d.g.divider_line);
                if (this.bFu) {
                    this.bFq.setVisibility(0);
                } else {
                    this.bFq.setVisibility(8);
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
