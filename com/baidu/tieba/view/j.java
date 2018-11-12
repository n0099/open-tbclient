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
    private TextView ajl;
    private RadioButton dNE;
    private RadioButton dNF;
    private RadioButton dNG;
    private RadioButton dNH;
    private RadioButton dNI;
    private Context hFv;
    private LinearLayout hFw;
    private View hFx;
    private TextView hFy;
    private d hGD;
    private b hGE;
    private e hGF;
    private LinearLayout hGG;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dNE) {
                j.this.dNF.setChecked(false);
                j.this.dNG.setChecked(false);
                j.this.dNH.setChecked(false);
                j.this.dNI.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dNF) {
                j.this.dNE.setChecked(true);
                j.this.dNG.setChecked(false);
                j.this.dNH.setChecked(false);
                j.this.dNI.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dNG) {
                j.this.dNE.setChecked(true);
                j.this.dNF.setChecked(true);
                j.this.dNH.setChecked(false);
                j.this.dNI.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dNH) {
                j.this.dNE.setChecked(true);
                j.this.dNF.setChecked(true);
                j.this.dNG.setChecked(true);
                j.this.dNI.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dNI) {
                j.this.dNE.setChecked(true);
                j.this.dNF.setChecked(true);
                j.this.dNG.setChecked(true);
                j.this.dNH.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hGF != null) {
                j.this.hGF.tq(j.this.mScore);
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
        void hC(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void tq(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hFv = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hFw = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.ajl = (TextView) this.view.findViewById(e.g.title);
            this.hFx = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hFy = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
            this.dNE = (RadioButton) this.view.findViewById(e.g.comment_grade_1);
            this.dNE.setOnClickListener(this.mOnClickListener);
            this.dNF = (RadioButton) this.view.findViewById(e.g.comment_grade_2);
            this.dNF.setOnClickListener(this.mOnClickListener);
            this.dNG = (RadioButton) this.view.findViewById(e.g.comment_grade_3);
            this.dNG.setOnClickListener(this.mOnClickListener);
            this.dNH = (RadioButton) this.view.findViewById(e.g.comment_grade_4);
            this.dNH.setOnClickListener(this.mOnClickListener);
            this.dNI = (RadioButton) this.view.findViewById(e.g.comment_grade_5);
            this.dNI.setOnClickListener(this.mOnClickListener);
            this.hGG = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hFv;
    }

    public ViewGroup aiX() {
        return this.hFw;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void ol(boolean z) {
        this.dNE.setEnabled(z);
        this.dNF.setEnabled(z);
        this.dNG.setEnabled(z);
        this.dNH.setEnabled(z);
        this.dNI.setEnabled(z);
    }

    public void wq(int i) {
        switch (i) {
            case 1:
                this.dNE.setChecked(true);
                this.dNF.setChecked(false);
                this.dNG.setChecked(false);
                this.dNH.setChecked(false);
                this.dNI.setChecked(false);
                return;
            case 2:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(false);
                this.dNH.setChecked(false);
                this.dNI.setChecked(false);
                return;
            case 3:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(true);
                this.dNH.setChecked(false);
                this.dNI.setChecked(false);
                return;
            case 4:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(true);
                this.dNH.setChecked(true);
                this.dNI.setChecked(false);
                return;
            case 5:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(true);
                this.dNH.setChecked(true);
                this.dNI.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void wr(int i) {
        this.hGG.setVisibility(i);
    }

    public void y(int i, int i2, int i3, int i4) {
        this.hGG.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.ajl.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.ajl.setTextSize(0, l.h(this.hFv, i));
    }

    public d bJX() {
        return this.hGD;
    }

    public void dZ(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hFw.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hFw.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hGE = bVar;
    }

    public void a(e eVar) {
        this.hGF = eVar;
    }

    public void ws(int i) {
        this.hFy.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.ajl, e.d.cp_bg_line_d);
        al.h(this.ajl, e.d.cp_cont_j);
        al.j(this.hFx, e.d.cp_bg_line_c);
        al.i(this.hFy, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hFy, e.d.cp_cont_f);
        al.i(this.hGG, e.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bJU() {
        if (!StringUtils.isNull(this.titleText)) {
            this.ajl.setText(this.titleText);
        } else {
            this.ajl.setVisibility(8);
        }
        if (this.hGE != null) {
            this.hFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hGE.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View ekB;
        private j hGI;
        private c hGJ;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hFD = e.f.person_more_pop_item_bg_selector;
        private int hFE = 17;
        private boolean hFG = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hGJ != null) {
                    a.this.hGJ.onClick();
                }
                if (a.this.hGI != null && a.this.hGI.bJX() != null) {
                    a.this.hGI.bJX().hC(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.hGI = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hGJ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.ekB, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hGI != null && this.hGI.getContext() != null) {
                this.mView = LayoutInflater.from(this.hGI.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hGI.aiX(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hFE);
                this.ekB = this.mView.findViewById(e.g.divider_line);
                if (this.hFG) {
                    this.ekB.setVisibility(0);
                } else {
                    this.ekB.setVisibility(8);
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
