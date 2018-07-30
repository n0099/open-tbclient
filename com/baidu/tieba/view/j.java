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
    private TextView aaW;
    private List<a> akQ;
    private RadioButton dxU;
    private RadioButton dxV;
    private RadioButton dxW;
    private RadioButton dxX;
    private RadioButton dxY;
    private Context hoF;
    private LinearLayout hoG;
    private View hoH;
    private TextView hoI;
    private d hpM;
    private b hpN;
    private e hpO;
    private LinearLayout hpP;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dxU) {
                j.this.dxV.setChecked(false);
                j.this.dxW.setChecked(false);
                j.this.dxX.setChecked(false);
                j.this.dxY.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dxV) {
                j.this.dxU.setChecked(true);
                j.this.dxW.setChecked(false);
                j.this.dxX.setChecked(false);
                j.this.dxY.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dxW) {
                j.this.dxU.setChecked(true);
                j.this.dxV.setChecked(true);
                j.this.dxX.setChecked(false);
                j.this.dxY.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dxX) {
                j.this.dxU.setChecked(true);
                j.this.dxV.setChecked(true);
                j.this.dxW.setChecked(true);
                j.this.dxY.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dxY) {
                j.this.dxU.setChecked(true);
                j.this.dxV.setChecked(true);
                j.this.dxW.setChecked(true);
                j.this.dxX.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hpO != null) {
                j.this.hpO.sd(j.this.mScore);
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
        void iW(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void sd(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hoF = context;
            this.view = LayoutInflater.from(context).inflate(d.h.rate_list_dialog_view, (ViewGroup) null);
            this.hoG = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aaW = (TextView) this.view.findViewById(d.g.title);
            this.hoH = this.view.findViewById(d.g.title_divide_line);
            this.akQ = new ArrayList();
            this.hoI = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
            this.dxU = (RadioButton) this.view.findViewById(d.g.comment_grade_1);
            this.dxU.setOnClickListener(this.mOnClickListener);
            this.dxV = (RadioButton) this.view.findViewById(d.g.comment_grade_2);
            this.dxV.setOnClickListener(this.mOnClickListener);
            this.dxW = (RadioButton) this.view.findViewById(d.g.comment_grade_3);
            this.dxW.setOnClickListener(this.mOnClickListener);
            this.dxX = (RadioButton) this.view.findViewById(d.g.comment_grade_4);
            this.dxX.setOnClickListener(this.mOnClickListener);
            this.dxY = (RadioButton) this.view.findViewById(d.g.comment_grade_5);
            this.dxY.setOnClickListener(this.mOnClickListener);
            this.hpP = (LinearLayout) this.view.findViewById(d.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hoF;
    }

    public ViewGroup aec() {
        return this.hoG;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void nk(boolean z) {
        this.dxU.setEnabled(z);
        this.dxV.setEnabled(z);
        this.dxW.setEnabled(z);
        this.dxX.setEnabled(z);
        this.dxY.setEnabled(z);
    }

    public void va(int i) {
        switch (i) {
            case 1:
                this.dxU.setChecked(true);
                this.dxV.setChecked(false);
                this.dxW.setChecked(false);
                this.dxX.setChecked(false);
                this.dxY.setChecked(false);
                return;
            case 2:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(false);
                this.dxX.setChecked(false);
                this.dxY.setChecked(false);
                return;
            case 3:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(true);
                this.dxX.setChecked(false);
                this.dxY.setChecked(false);
                return;
            case 4:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(true);
                this.dxX.setChecked(true);
                this.dxY.setChecked(false);
                return;
            case 5:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(true);
                this.dxX.setChecked(true);
                this.dxY.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void vb(int i) {
        this.hpP.setVisibility(i);
    }

    public void x(int i, int i2, int i3, int i4) {
        this.hpP.setPadding(i, i2, i3, i4);
    }

    public void y(int i, int i2, int i3, int i4) {
        this.aaW.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.aaW.setTextSize(0, l.f(this.hoF, i));
    }

    public d bEt() {
        return this.hpM;
    }

    public void dM(List<a> list) {
        if (list != null) {
            this.akQ = list;
            this.hoG.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hoG.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hpN = bVar;
    }

    public void a(e eVar) {
        this.hpO = eVar;
    }

    public void vc(int i) {
        this.hoI.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.j(this.aaW, d.C0140d.cp_bg_line_d);
        am.h(this.aaW, d.C0140d.cp_cont_j);
        am.j(this.hoH, d.C0140d.cp_bg_line_c);
        am.i(this.hoI, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.hoI, d.C0140d.cp_cont_f);
        am.i(this.hpP, d.f.bg_bottom_up_list_dialog_item);
        if (this.akQ != null) {
            for (a aVar : this.akQ) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bEq() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aaW.setText(this.titleText);
        } else {
            this.aaW.setVisibility(8);
        }
        if (this.hpN != null) {
            this.hoI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hpN.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aoo;
        private View dTZ;
        private j hpR;
        private c hpS;
        private TextView mTextView;
        private View mView;
        private int mTextColor = d.f.person_more_pop_cancel_text_selector;
        private int hoN = d.f.person_more_pop_item_bg_selector;
        private int hoO = 17;
        private boolean hoQ = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hpS != null) {
                    a.this.hpS.onClick();
                }
                if (a.this.hpR != null && a.this.hpR.bEt() != null) {
                    a.this.hpR.bEt().iW(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.aoo = str;
            this.hpR = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hpS = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            am.h(this.mTextView, d.C0140d.cp_cont_f);
            am.j(this.dTZ, d.C0140d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hpR != null && this.hpR.getContext() != null) {
                this.mView = LayoutInflater.from(this.hpR.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hpR.aec(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.aoo);
                this.mTextView.setGravity(this.hoO);
                this.dTZ = this.mView.findViewById(d.g.divider_line);
                if (this.hoQ) {
                    this.dTZ.setVisibility(0);
                } else {
                    this.dTZ.setVisibility(8);
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
