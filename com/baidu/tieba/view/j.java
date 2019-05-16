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
    private Context bNd;
    private LinearLayout bNf;
    private View bNg;
    private TextView bNh;
    private RadioButton fBo;
    private RadioButton fBp;
    private RadioButton fBq;
    private RadioButton fBr;
    private RadioButton fBs;
    private d jBr;
    private b jBs;
    private e jBt;
    private LinearLayout jBu;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fBo) {
                j.this.fBp.setChecked(false);
                j.this.fBq.setChecked(false);
                j.this.fBr.setChecked(false);
                j.this.fBs.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fBp) {
                j.this.fBo.setChecked(true);
                j.this.fBq.setChecked(false);
                j.this.fBr.setChecked(false);
                j.this.fBs.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fBq) {
                j.this.fBo.setChecked(true);
                j.this.fBp.setChecked(true);
                j.this.fBr.setChecked(false);
                j.this.fBs.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fBr) {
                j.this.fBo.setChecked(true);
                j.this.fBp.setChecked(true);
                j.this.fBq.setChecked(true);
                j.this.fBs.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fBs) {
                j.this.fBo.setChecked(true);
                j.this.fBp.setChecked(true);
                j.this.fBq.setChecked(true);
                j.this.fBr.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jBt != null) {
                j.this.jBt.yR(j.this.mScore);
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
            this.bNd = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.bNf = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bBh = (TextView) this.view.findViewById(R.id.title);
            this.bNg = this.view.findViewById(R.id.title_divide_line);
            this.aOH = new ArrayList();
            this.bNh = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.fBo = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.fBo.setOnClickListener(this.mOnClickListener);
            this.fBp = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.fBp.setOnClickListener(this.mOnClickListener);
            this.fBq = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.fBq.setOnClickListener(this.mOnClickListener);
            this.fBr = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.fBr.setOnClickListener(this.mOnClickListener);
            this.fBs = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.fBs.setOnClickListener(this.mOnClickListener);
            this.jBu = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.bNd;
    }

    public ViewGroup afX() {
        return this.bNf;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void rG(boolean z) {
        this.fBo.setEnabled(z);
        this.fBp.setEnabled(z);
        this.fBq.setEnabled(z);
        this.fBr.setEnabled(z);
        this.fBs.setEnabled(z);
    }

    public void BT(int i) {
        switch (i) {
            case 1:
                this.fBo.setChecked(true);
                this.fBp.setChecked(false);
                this.fBq.setChecked(false);
                this.fBr.setChecked(false);
                this.fBs.setChecked(false);
                return;
            case 2:
                this.fBo.setChecked(true);
                this.fBp.setChecked(true);
                this.fBq.setChecked(false);
                this.fBr.setChecked(false);
                this.fBs.setChecked(false);
                return;
            case 3:
                this.fBo.setChecked(true);
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(false);
                this.fBs.setChecked(false);
                return;
            case 4:
                this.fBo.setChecked(true);
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(false);
                return;
            case 5:
                this.fBo.setChecked(true);
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void BU(int i) {
        this.jBu.setVisibility(i);
    }

    public void C(int i, int i2, int i3, int i4) {
        this.jBu.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bBh.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bBh.setTextSize(0, l.g(this.bNd, i));
    }

    public d cvd() {
        return this.jBr;
    }

    public void W(List<a> list) {
        if (list != null) {
            this.aOH = list;
            this.bNf.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bNf.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jBs = bVar;
    }

    public void a(e eVar) {
        this.jBt = eVar;
    }

    public void BV(int i) {
        this.bNh.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.l(this.bBh, R.color.cp_bg_line_d);
        al.j(this.bBh, R.color.cp_cont_j);
        al.l(this.bNg, R.color.cp_bg_line_c);
        al.k(this.bNh, R.drawable.bg_bottom_up_list_dialog_item);
        al.j(this.bNh, R.color.cp_cont_f);
        al.k(this.jBu, R.drawable.bg_bottom_up_list_dialog_item);
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
        if (this.jBs != null) {
            this.bNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jBs.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String ama;
        private View bMQ;
        private j jBw;
        private c jBx;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int bMR = R.drawable.person_more_pop_item_bg_selector;
        private int bMS = 17;
        private boolean bMU = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jBx != null) {
                    a.this.jBx.onClick();
                }
                if (a.this.jBw != null && a.this.jBw.cvd() != null) {
                    a.this.jBw.cvd().mu(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.ama = str;
            this.jBw = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jBx = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            al.j(this.mTextView, R.color.cp_cont_f);
            al.l(this.bMQ, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jBw != null && this.jBw.getContext() != null) {
                this.mView = LayoutInflater.from(this.jBw.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jBw.afX(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.ama);
                this.mTextView.setGravity(this.bMS);
                this.bMQ = this.mView.findViewById(R.id.divider_line);
                if (this.bMU) {
                    this.bMQ.setVisibility(0);
                } else {
                    this.bMQ.setVisibility(8);
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
