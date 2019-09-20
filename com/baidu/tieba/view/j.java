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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private List<a> aPP;
    private TextView bCB;
    private Context bOL;
    private LinearLayout bON;
    private View bOO;
    private TextView bOP;
    private RadioButton fIQ;
    private RadioButton fIR;
    private RadioButton fIS;
    private RadioButton fIT;
    private RadioButton fIU;
    private d jLf;
    private b jLg;
    private e jLh;
    private LinearLayout jLi;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fIQ) {
                j.this.fIR.setChecked(false);
                j.this.fIS.setChecked(false);
                j.this.fIT.setChecked(false);
                j.this.fIU.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fIR) {
                j.this.fIQ.setChecked(true);
                j.this.fIS.setChecked(false);
                j.this.fIT.setChecked(false);
                j.this.fIU.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fIS) {
                j.this.fIQ.setChecked(true);
                j.this.fIR.setChecked(true);
                j.this.fIT.setChecked(false);
                j.this.fIU.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fIT) {
                j.this.fIQ.setChecked(true);
                j.this.fIR.setChecked(true);
                j.this.fIS.setChecked(true);
                j.this.fIU.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fIU) {
                j.this.fIQ.setChecked(true);
                j.this.fIR.setChecked(true);
                j.this.fIS.setChecked(true);
                j.this.fIT.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jLh != null) {
                j.this.jLh.zB(j.this.mScore);
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
        void mG(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void zB(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.bOL = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.bON = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bCB = (TextView) this.view.findViewById(R.id.title);
            this.bOO = this.view.findViewById(R.id.title_divide_line);
            this.aPP = new ArrayList();
            this.bOP = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.fIQ = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.fIQ.setOnClickListener(this.mOnClickListener);
            this.fIR = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.fIR.setOnClickListener(this.mOnClickListener);
            this.fIS = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.fIS.setOnClickListener(this.mOnClickListener);
            this.fIT = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.fIT.setOnClickListener(this.mOnClickListener);
            this.fIU = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.fIU.setOnClickListener(this.mOnClickListener);
            this.jLi = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.bOL;
    }

    public ViewGroup ahf() {
        return this.bON;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void rY(boolean z) {
        this.fIQ.setEnabled(z);
        this.fIR.setEnabled(z);
        this.fIS.setEnabled(z);
        this.fIT.setEnabled(z);
        this.fIU.setEnabled(z);
    }

    public void CG(int i) {
        switch (i) {
            case 1:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(false);
                this.fIS.setChecked(false);
                this.fIT.setChecked(false);
                this.fIU.setChecked(false);
                return;
            case 2:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(false);
                this.fIT.setChecked(false);
                this.fIU.setChecked(false);
                return;
            case 3:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(true);
                this.fIT.setChecked(false);
                this.fIU.setChecked(false);
                return;
            case 4:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(true);
                this.fIT.setChecked(true);
                this.fIU.setChecked(false);
                return;
            case 5:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(true);
                this.fIT.setChecked(true);
                this.fIU.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void CH(int i) {
        this.jLi.setVisibility(i);
    }

    public void G(int i, int i2, int i3, int i4) {
        this.jLi.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bCB.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bCB.setTextSize(0, l.g(this.bOL, i));
    }

    public d cze() {
        return this.jLf;
    }

    public void W(List<a> list) {
        if (list != null) {
            this.aPP = list;
            this.bON.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bON.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jLg = bVar;
    }

    public void a(e eVar) {
        this.jLh = eVar;
    }

    public void CI(int i) {
        this.bOP.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.l(this.bCB, R.color.cp_bg_line_d);
        am.j(this.bCB, R.color.cp_cont_j);
        am.l(this.bOO, R.color.cp_bg_line_c);
        am.k(this.bOP, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.bOP, R.color.cp_cont_f);
        am.k(this.jLi, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.aPP != null) {
            for (a aVar : this.aPP) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View ahh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCB.setText(this.titleText);
        } else {
            this.bCB.setVisibility(8);
        }
        if (this.jLg != null) {
            this.bOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jLg.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String anb;
        private View bOw;
        private j jLk;
        private c jLl;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int bOx = R.drawable.person_more_pop_item_bg_selector;
        private int bOy = 17;
        private boolean bOA = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jLl != null) {
                    a.this.jLl.onClick();
                }
                if (a.this.jLk != null && a.this.jLk.cze() != null) {
                    a.this.jLk.cze().mG(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.anb = str;
            this.jLk = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jLl = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.j(this.mTextView, R.color.cp_cont_f);
            am.l(this.bOw, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jLk != null && this.jLk.getContext() != null) {
                this.mView = LayoutInflater.from(this.jLk.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jLk.ahf(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.anb);
                this.mTextView.setGravity(this.bOy);
                this.bOw = this.mView.findViewById(R.id.divider_line);
                if (this.bOA) {
                    this.bOw.setVisibility(0);
                } else {
                    this.bOw.setVisibility(8);
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
