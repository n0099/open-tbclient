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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private List<a> aOH;
    private TextView bBh;
    private Context bNe;
    private LinearLayout bNg;
    private View bNh;
    private TextView bNi;
    private RadioButton fBp;
    private RadioButton fBq;
    private RadioButton fBr;
    private RadioButton fBs;
    private RadioButton fBt;
    private d jBv;
    private b jBw;
    private e jBx;
    private LinearLayout jBy;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fBp) {
                j.this.fBq.setChecked(false);
                j.this.fBr.setChecked(false);
                j.this.fBs.setChecked(false);
                j.this.fBt.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fBq) {
                j.this.fBp.setChecked(true);
                j.this.fBr.setChecked(false);
                j.this.fBs.setChecked(false);
                j.this.fBt.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fBr) {
                j.this.fBp.setChecked(true);
                j.this.fBq.setChecked(true);
                j.this.fBs.setChecked(false);
                j.this.fBt.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fBs) {
                j.this.fBp.setChecked(true);
                j.this.fBq.setChecked(true);
                j.this.fBr.setChecked(true);
                j.this.fBt.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fBt) {
                j.this.fBp.setChecked(true);
                j.this.fBq.setChecked(true);
                j.this.fBr.setChecked(true);
                j.this.fBs.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jBx != null) {
                j.this.jBx.yR(j.this.mScore);
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
        void mu(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void yR(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.bNe = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.bNg = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bBh = (TextView) this.view.findViewById(R.id.title);
            this.bNh = this.view.findViewById(R.id.title_divide_line);
            this.aOH = new ArrayList();
            this.bNi = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.fBp = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.fBp.setOnClickListener(this.mOnClickListener);
            this.fBq = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.fBq.setOnClickListener(this.mOnClickListener);
            this.fBr = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.fBr.setOnClickListener(this.mOnClickListener);
            this.fBs = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.fBs.setOnClickListener(this.mOnClickListener);
            this.fBt = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.fBt.setOnClickListener(this.mOnClickListener);
            this.jBy = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.bNe;
    }

    public ViewGroup afX() {
        return this.bNg;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void rH(boolean z) {
        this.fBp.setEnabled(z);
        this.fBq.setEnabled(z);
        this.fBr.setEnabled(z);
        this.fBs.setEnabled(z);
        this.fBt.setEnabled(z);
    }

    public void BT(int i) {
        switch (i) {
            case 1:
                this.fBp.setChecked(true);
                this.fBq.setChecked(false);
                this.fBr.setChecked(false);
                this.fBs.setChecked(false);
                this.fBt.setChecked(false);
                return;
            case 2:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(false);
                this.fBs.setChecked(false);
                this.fBt.setChecked(false);
                return;
            case 3:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(false);
                this.fBt.setChecked(false);
                return;
            case 4:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(true);
                this.fBt.setChecked(false);
                return;
            case 5:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(true);
                this.fBt.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void BU(int i) {
        this.jBy.setVisibility(i);
    }

    public void C(int i, int i2, int i3, int i4) {
        this.jBy.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bBh.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bBh.setTextSize(0, l.g(this.bNe, i));
    }

    public d cve() {
        return this.jBv;
    }

    public void W(List<a> list) {
        if (list != null) {
            this.aOH = list;
            this.bNg.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bNg.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jBw = bVar;
    }

    public void a(e eVar) {
        this.jBx = eVar;
    }

    public void BV(int i) {
        this.bNi.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.l(this.bBh, R.color.cp_bg_line_d);
        al.j(this.bBh, R.color.cp_cont_j);
        al.l(this.bNh, R.color.cp_bg_line_c);
        al.k(this.bNi, R.drawable.bg_bottom_up_list_dialog_item);
        al.j(this.bNi, R.color.cp_cont_f);
        al.k(this.jBy, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.aOH != null) {
            for (a aVar : this.aOH) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View afZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bBh.setText(this.titleText);
        } else {
            this.bBh.setVisibility(8);
        }
        if (this.jBw != null) {
            this.bNi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jBw.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String ama;
        private View bMR;
        private j jBA;
        private c jBB;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int bMS = R.drawable.person_more_pop_item_bg_selector;
        private int bMT = 17;
        private boolean bMV = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jBB != null) {
                    a.this.jBB.onClick();
                }
                if (a.this.jBA != null && a.this.jBA.cve() != null) {
                    a.this.jBA.cve().mu(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.ama = str;
            this.jBA = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jBB = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            al.j(this.mTextView, R.color.cp_cont_f);
            al.l(this.bMR, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jBA != null && this.jBA.getContext() != null) {
                this.mView = LayoutInflater.from(this.jBA.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jBA.afX(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.ama);
                this.mTextView.setGravity(this.bMT);
                this.bMR = this.mView.findViewById(R.id.divider_line);
                if (this.bMV) {
                    this.bMR.setVisibility(0);
                } else {
                    this.bMR.setVisibility(8);
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
