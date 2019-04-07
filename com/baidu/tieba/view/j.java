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
    private List<a> aMJ;
    private Context bFC;
    private LinearLayout bFE;
    private View bFF;
    private TextView bFG;
    private TextView buc;
    private RadioButton fkT;
    private RadioButton fkU;
    private RadioButton fkV;
    private RadioButton fkW;
    private RadioButton fkX;
    private LinearLayout jiA;
    private d jix;
    private b jiy;
    private e jiz;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fkT) {
                j.this.fkU.setChecked(false);
                j.this.fkV.setChecked(false);
                j.this.fkW.setChecked(false);
                j.this.fkX.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fkU) {
                j.this.fkT.setChecked(true);
                j.this.fkV.setChecked(false);
                j.this.fkW.setChecked(false);
                j.this.fkX.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fkV) {
                j.this.fkT.setChecked(true);
                j.this.fkU.setChecked(true);
                j.this.fkW.setChecked(false);
                j.this.fkX.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fkW) {
                j.this.fkT.setChecked(true);
                j.this.fkU.setChecked(true);
                j.this.fkV.setChecked(true);
                j.this.fkX.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fkX) {
                j.this.fkT.setChecked(true);
                j.this.fkU.setChecked(true);
                j.this.fkV.setChecked(true);
                j.this.fkW.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jiz != null) {
                j.this.jiz.xK(j.this.mScore);
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
        void lH(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void xK(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.bFC = context;
            this.view = LayoutInflater.from(context).inflate(d.h.rate_list_dialog_view, (ViewGroup) null);
            this.bFE = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.buc = (TextView) this.view.findViewById(d.g.title);
            this.bFF = this.view.findViewById(d.g.title_divide_line);
            this.aMJ = new ArrayList();
            this.bFG = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
            this.fkT = (RadioButton) this.view.findViewById(d.g.comment_grade_1);
            this.fkT.setOnClickListener(this.mOnClickListener);
            this.fkU = (RadioButton) this.view.findViewById(d.g.comment_grade_2);
            this.fkU.setOnClickListener(this.mOnClickListener);
            this.fkV = (RadioButton) this.view.findViewById(d.g.comment_grade_3);
            this.fkV.setOnClickListener(this.mOnClickListener);
            this.fkW = (RadioButton) this.view.findViewById(d.g.comment_grade_4);
            this.fkW.setOnClickListener(this.mOnClickListener);
            this.fkX = (RadioButton) this.view.findViewById(d.g.comment_grade_5);
            this.fkX.setOnClickListener(this.mOnClickListener);
            this.jiA = (LinearLayout) this.view.findViewById(d.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.bFC;
    }

    public ViewGroup abf() {
        return this.bFE;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void qR(boolean z) {
        this.fkT.setEnabled(z);
        this.fkU.setEnabled(z);
        this.fkV.setEnabled(z);
        this.fkW.setEnabled(z);
        this.fkX.setEnabled(z);
    }

    public void AK(int i) {
        switch (i) {
            case 1:
                this.fkT.setChecked(true);
                this.fkU.setChecked(false);
                this.fkV.setChecked(false);
                this.fkW.setChecked(false);
                this.fkX.setChecked(false);
                return;
            case 2:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(false);
                this.fkW.setChecked(false);
                this.fkX.setChecked(false);
                return;
            case 3:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(true);
                this.fkW.setChecked(false);
                this.fkX.setChecked(false);
                return;
            case 4:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(true);
                this.fkW.setChecked(true);
                this.fkX.setChecked(false);
                return;
            case 5:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(true);
                this.fkW.setChecked(true);
                this.fkX.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void AL(int i) {
        this.jiA.setVisibility(i);
    }

    public void C(int i, int i2, int i3, int i4) {
        this.jiA.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.buc.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.buc.setTextSize(0, l.h(this.bFC, i));
    }

    public d cna() {
        return this.jix;
    }

    public void P(List<a> list) {
        if (list != null) {
            this.aMJ = list;
            this.bFE.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bFE.addView(aVar.getView());
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

    public void AM(int i) {
        this.bFG.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.l(this.buc, d.C0277d.cp_bg_line_d);
        al.j(this.buc, d.C0277d.cp_cont_j);
        al.l(this.bFF, d.C0277d.cp_bg_line_c);
        al.k(this.bFG, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFG, d.C0277d.cp_cont_f);
        al.k(this.jiA, d.f.bg_bottom_up_list_dialog_item);
        if (this.aMJ != null) {
            for (a aVar : this.aMJ) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View abh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.buc.setText(this.titleText);
        } else {
            this.buc.setVisibility(8);
        }
        if (this.jiy != null) {
            this.bFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
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
        private String alN;
        private View bFs;
        private j jiC;
        private c jiD;
        private TextView mTextView;
        private View mView;
        private int mTextColor = d.f.person_more_pop_cancel_text_selector;
        private int bFt = d.f.person_more_pop_item_bg_selector;
        private int bFu = 17;
        private boolean bFw = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jiD != null) {
                    a.this.jiD.onClick();
                }
                if (a.this.jiC != null && a.this.jiC.cna() != null) {
                    a.this.jiC.cna().lH(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.alN = str;
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
            al.j(this.mTextView, d.C0277d.cp_cont_f);
            al.l(this.bFs, d.C0277d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jiC != null && this.jiC.getContext() != null) {
                this.mView = LayoutInflater.from(this.jiC.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jiC.abf(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alN);
                this.mTextView.setGravity(this.bFu);
                this.bFs = this.mView.findViewById(d.g.divider_line);
                if (this.bFw) {
                    this.bFs.setVisibility(0);
                } else {
                    this.bFs.setVisibility(8);
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
