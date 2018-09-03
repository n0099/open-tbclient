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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private TextView aaX;
    private List<a> akQ;
    private RadioButton dxR;
    private RadioButton dxS;
    private RadioButton dxT;
    private RadioButton dxU;
    private RadioButton dxV;
    private Context hoG;
    private LinearLayout hoH;
    private View hoI;
    private TextView hoJ;
    private d hpN;
    private b hpO;
    private e hpP;
    private LinearLayout hpQ;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dxR) {
                j.this.dxS.setChecked(false);
                j.this.dxT.setChecked(false);
                j.this.dxU.setChecked(false);
                j.this.dxV.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dxS) {
                j.this.dxR.setChecked(true);
                j.this.dxT.setChecked(false);
                j.this.dxU.setChecked(false);
                j.this.dxV.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dxT) {
                j.this.dxR.setChecked(true);
                j.this.dxS.setChecked(true);
                j.this.dxU.setChecked(false);
                j.this.dxV.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dxU) {
                j.this.dxR.setChecked(true);
                j.this.dxS.setChecked(true);
                j.this.dxT.setChecked(true);
                j.this.dxV.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dxV) {
                j.this.dxR.setChecked(true);
                j.this.dxS.setChecked(true);
                j.this.dxT.setChecked(true);
                j.this.dxU.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hpP != null) {
                j.this.hpP.sd(j.this.mScore);
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
        void iV(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void sd(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hoG = context;
            this.view = LayoutInflater.from(context).inflate(f.h.rate_list_dialog_view, (ViewGroup) null);
            this.hoH = (LinearLayout) this.view.findViewById(f.g.content_view);
            this.aaX = (TextView) this.view.findViewById(f.g.title);
            this.hoI = this.view.findViewById(f.g.title_divide_line);
            this.akQ = new ArrayList();
            this.hoJ = (TextView) this.view.findViewById(f.g.dialog_bottom_cancel_button);
            this.dxR = (RadioButton) this.view.findViewById(f.g.comment_grade_1);
            this.dxR.setOnClickListener(this.mOnClickListener);
            this.dxS = (RadioButton) this.view.findViewById(f.g.comment_grade_2);
            this.dxS.setOnClickListener(this.mOnClickListener);
            this.dxT = (RadioButton) this.view.findViewById(f.g.comment_grade_3);
            this.dxT.setOnClickListener(this.mOnClickListener);
            this.dxU = (RadioButton) this.view.findViewById(f.g.comment_grade_4);
            this.dxU.setOnClickListener(this.mOnClickListener);
            this.dxV = (RadioButton) this.view.findViewById(f.g.comment_grade_5);
            this.dxV.setOnClickListener(this.mOnClickListener);
            this.hpQ = (LinearLayout) this.view.findViewById(f.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hoG;
    }

    public ViewGroup aee() {
        return this.hoH;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void nk(boolean z) {
        this.dxR.setEnabled(z);
        this.dxS.setEnabled(z);
        this.dxT.setEnabled(z);
        this.dxU.setEnabled(z);
        this.dxV.setEnabled(z);
    }

    public void va(int i) {
        switch (i) {
            case 1:
                this.dxR.setChecked(true);
                this.dxS.setChecked(false);
                this.dxT.setChecked(false);
                this.dxU.setChecked(false);
                this.dxV.setChecked(false);
                return;
            case 2:
                this.dxR.setChecked(true);
                this.dxS.setChecked(true);
                this.dxT.setChecked(false);
                this.dxU.setChecked(false);
                this.dxV.setChecked(false);
                return;
            case 3:
                this.dxR.setChecked(true);
                this.dxS.setChecked(true);
                this.dxT.setChecked(true);
                this.dxU.setChecked(false);
                this.dxV.setChecked(false);
                return;
            case 4:
                this.dxR.setChecked(true);
                this.dxS.setChecked(true);
                this.dxT.setChecked(true);
                this.dxU.setChecked(true);
                this.dxV.setChecked(false);
                return;
            case 5:
                this.dxR.setChecked(true);
                this.dxS.setChecked(true);
                this.dxT.setChecked(true);
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void vb(int i) {
        this.hpQ.setVisibility(i);
    }

    public void x(int i, int i2, int i3, int i4) {
        this.hpQ.setPadding(i, i2, i3, i4);
    }

    public void y(int i, int i2, int i3, int i4) {
        this.aaX.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.aaX.setTextSize(0, l.f(this.hoG, i));
    }

    public d bEv() {
        return this.hpN;
    }

    public void dM(List<a> list) {
        if (list != null) {
            this.akQ = list;
            this.hoH.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hoH.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hpO = bVar;
    }

    public void a(e eVar) {
        this.hpP = eVar;
    }

    public void vc(int i) {
        this.hoJ.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.j(this.aaX, f.d.cp_bg_line_d);
        am.h(this.aaX, f.d.cp_cont_j);
        am.j(this.hoI, f.d.cp_bg_line_c);
        am.i(this.hoJ, f.C0146f.bg_bottom_up_list_dialog_item);
        am.h(this.hoJ, f.d.cp_cont_f);
        am.i(this.hpQ, f.C0146f.bg_bottom_up_list_dialog_item);
        if (this.akQ != null) {
            for (a aVar : this.akQ) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bEs() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aaX.setText(this.titleText);
        } else {
            this.aaX.setVisibility(8);
        }
        if (this.hpO != null) {
            this.hoJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hpO.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aop;
        private View dTU;
        private j hpS;
        private c hpT;
        private TextView mTextView;
        private View mView;
        private int mTextColor = f.C0146f.person_more_pop_cancel_text_selector;
        private int hoO = f.C0146f.person_more_pop_item_bg_selector;
        private int hoP = 17;
        private boolean hoR = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hpT != null) {
                    a.this.hpT.onClick();
                }
                if (a.this.hpS != null && a.this.hpS.bEv() != null) {
                    a.this.hpS.bEv().iV(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.aop = str;
            this.hpS = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hpT = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.i(this.mTextView, f.C0146f.bg_bottom_up_list_dialog_item);
            am.h(this.mTextView, f.d.cp_cont_f);
            am.j(this.dTU, f.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hpS != null && this.hpS.getContext() != null) {
                this.mView = LayoutInflater.from(this.hpS.getContext()).inflate(f.h.bottom_up_list_dialog_item, this.hpS.aee(), false);
                this.mTextView = (TextView) this.mView.findViewById(f.g.item_view);
                this.mTextView.setText(this.aop);
                this.mTextView.setGravity(this.hoP);
                this.dTU = this.mView.findViewById(f.g.divider_line);
                if (this.hoR) {
                    this.dTU.setVisibility(0);
                } else {
                    this.dTU.setVisibility(8);
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
