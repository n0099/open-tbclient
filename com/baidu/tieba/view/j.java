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
    private TextView adB;
    private List<a> anw;
    private RadioButton dEB;
    private RadioButton dEC;
    private RadioButton dED;
    private RadioButton dEE;
    private RadioButton dEF;
    private View hwA;
    private TextView hwB;
    private Context hwy;
    private LinearLayout hwz;
    private d hxF;
    private b hxG;
    private e hxH;
    private LinearLayout hxI;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dEB) {
                j.this.dEC.setChecked(false);
                j.this.dED.setChecked(false);
                j.this.dEE.setChecked(false);
                j.this.dEF.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dEC) {
                j.this.dEB.setChecked(true);
                j.this.dED.setChecked(false);
                j.this.dEE.setChecked(false);
                j.this.dEF.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dED) {
                j.this.dEB.setChecked(true);
                j.this.dEC.setChecked(true);
                j.this.dEE.setChecked(false);
                j.this.dEF.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dEE) {
                j.this.dEB.setChecked(true);
                j.this.dEC.setChecked(true);
                j.this.dED.setChecked(true);
                j.this.dEF.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dEF) {
                j.this.dEB.setChecked(true);
                j.this.dEC.setChecked(true);
                j.this.dED.setChecked(true);
                j.this.dEE.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hxH != null) {
                j.this.hxH.sA(j.this.mScore);
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
        void ju(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void sA(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hwy = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hwz = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.adB = (TextView) this.view.findViewById(e.g.title);
            this.hwA = this.view.findViewById(e.g.title_divide_line);
            this.anw = new ArrayList();
            this.hwB = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
            this.dEB = (RadioButton) this.view.findViewById(e.g.comment_grade_1);
            this.dEB.setOnClickListener(this.mOnClickListener);
            this.dEC = (RadioButton) this.view.findViewById(e.g.comment_grade_2);
            this.dEC.setOnClickListener(this.mOnClickListener);
            this.dED = (RadioButton) this.view.findViewById(e.g.comment_grade_3);
            this.dED.setOnClickListener(this.mOnClickListener);
            this.dEE = (RadioButton) this.view.findViewById(e.g.comment_grade_4);
            this.dEE.setOnClickListener(this.mOnClickListener);
            this.dEF = (RadioButton) this.view.findViewById(e.g.comment_grade_5);
            this.dEF.setOnClickListener(this.mOnClickListener);
            this.hxI = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hwy;
    }

    public ViewGroup afQ() {
        return this.hwz;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void nH(boolean z) {
        this.dEB.setEnabled(z);
        this.dEC.setEnabled(z);
        this.dED.setEnabled(z);
        this.dEE.setEnabled(z);
        this.dEF.setEnabled(z);
    }

    public void vA(int i) {
        switch (i) {
            case 1:
                this.dEB.setChecked(true);
                this.dEC.setChecked(false);
                this.dED.setChecked(false);
                this.dEE.setChecked(false);
                this.dEF.setChecked(false);
                return;
            case 2:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(false);
                this.dEE.setChecked(false);
                this.dEF.setChecked(false);
                return;
            case 3:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(true);
                this.dEE.setChecked(false);
                this.dEF.setChecked(false);
                return;
            case 4:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(true);
                this.dEE.setChecked(true);
                this.dEF.setChecked(false);
                return;
            case 5:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(true);
                this.dEE.setChecked(true);
                this.dEF.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void vB(int i) {
        this.hxI.setVisibility(i);
    }

    public void y(int i, int i2, int i3, int i4) {
        this.hxI.setPadding(i, i2, i3, i4);
    }

    public void z(int i, int i2, int i3, int i4) {
        this.adB.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.adB.setTextSize(0, l.h(this.hwy, i));
    }

    public d bHm() {
        return this.hxF;
    }

    public void dN(List<a> list) {
        if (list != null) {
            this.anw = list;
            this.hwz.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hwz.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hxG = bVar;
    }

    public void a(e eVar) {
        this.hxH = eVar;
    }

    public void vC(int i) {
        this.hwB.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.adB, e.d.cp_bg_line_d);
        al.h(this.adB, e.d.cp_cont_j);
        al.j(this.hwA, e.d.cp_bg_line_c);
        al.i(this.hwB, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hwB, e.d.cp_cont_f);
        al.i(this.hxI, e.f.bg_bottom_up_list_dialog_item);
        if (this.anw != null) {
            for (a aVar : this.anw) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bHj() {
        if (!StringUtils.isNull(this.titleText)) {
            this.adB.setText(this.titleText);
        } else {
            this.adB.setVisibility(8);
        }
        if (this.hxG != null) {
            this.hwB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hxG.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aqV;
        private View ebn;
        private j hxK;
        private c hxL;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hwG = e.f.person_more_pop_item_bg_selector;
        private int hwH = 17;
        private boolean hwJ = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hxL != null) {
                    a.this.hxL.onClick();
                }
                if (a.this.hxK != null && a.this.hxK.bHm() != null) {
                    a.this.hxK.bHm().ju(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.aqV = str;
            this.hxK = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hxL = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.ebn, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hxK != null && this.hxK.getContext() != null) {
                this.mView = LayoutInflater.from(this.hxK.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hxK.afQ(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.aqV);
                this.mTextView.setGravity(this.hwH);
                this.ebn = this.mView.findViewById(e.g.divider_line);
                if (this.hwJ) {
                    this.ebn.setVisibility(0);
                } else {
                    this.ebn.setVisibility(8);
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
