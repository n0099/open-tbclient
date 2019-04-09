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
    private List<a> aMK;
    private Context bFD;
    private LinearLayout bFF;
    private View bFG;
    private TextView bFH;
    private TextView bud;
    private RadioButton fkT;
    private RadioButton fkU;
    private RadioButton fkV;
    private RadioButton fkW;
    private RadioButton fkX;
    private e jiA;
    private LinearLayout jiB;
    private d jiy;
    private b jiz;
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
            if (j.this.jiA != null) {
                j.this.jiA.xK(j.this.mScore);
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
            this.bFD = context;
            this.view = LayoutInflater.from(context).inflate(d.h.rate_list_dialog_view, (ViewGroup) null);
            this.bFF = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.bud = (TextView) this.view.findViewById(d.g.title);
            this.bFG = this.view.findViewById(d.g.title_divide_line);
            this.aMK = new ArrayList();
            this.bFH = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
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
            this.jiB = (LinearLayout) this.view.findViewById(d.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.bFD;
    }

    public ViewGroup abf() {
        return this.bFF;
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
        this.jiB.setVisibility(i);
    }

    public void C(int i, int i2, int i3, int i4) {
        this.jiB.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bud.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bud.setTextSize(0, l.h(this.bFD, i));
    }

    public d cna() {
        return this.jiy;
    }

    public void P(List<a> list) {
        if (list != null) {
            this.aMK = list;
            this.bFF.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bFF.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jiz = bVar;
    }

    public void a(e eVar) {
        this.jiA = eVar;
    }

    public void AM(int i) {
        this.bFH.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.l(this.bud, d.C0277d.cp_bg_line_d);
        al.j(this.bud, d.C0277d.cp_cont_j);
        al.l(this.bFG, d.C0277d.cp_bg_line_c);
        al.k(this.bFH, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFH, d.C0277d.cp_cont_f);
        al.k(this.jiB, d.f.bg_bottom_up_list_dialog_item);
        if (this.aMK != null) {
            for (a aVar : this.aMK) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View abh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bud.setText(this.titleText);
        } else {
            this.bud.setVisibility(8);
        }
        if (this.jiz != null) {
            this.bFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jiz.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String alO;
        private View bFt;
        private j jiD;
        private c jiE;
        private TextView mTextView;
        private View mView;
        private int mTextColor = d.f.person_more_pop_cancel_text_selector;
        private int bFu = d.f.person_more_pop_item_bg_selector;
        private int bFv = 17;
        private boolean bFx = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jiE != null) {
                    a.this.jiE.onClick();
                }
                if (a.this.jiD != null && a.this.jiD.cna() != null) {
                    a.this.jiD.cna().lH(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.alO = str;
            this.jiD = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jiE = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.k(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            al.j(this.mTextView, d.C0277d.cp_cont_f);
            al.l(this.bFt, d.C0277d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jiD != null && this.jiD.getContext() != null) {
                this.mView = LayoutInflater.from(this.jiD.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jiD.abf(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alO);
                this.mTextView.setGravity(this.bFv);
                this.bFt = this.mView.findViewById(d.g.divider_line);
                if (this.bFx) {
                    this.bFt.setVisibility(0);
                } else {
                    this.bFt.setVisibility(8);
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
