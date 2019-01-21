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
    private TextView anq;
    private RadioButton dXF;
    private RadioButton dXG;
    private RadioButton dXH;
    private RadioButton dXI;
    private RadioButton dXJ;
    private Context hQZ;
    private LinearLayout hRa;
    private View hRb;
    private TextView hRc;
    private d hSh;
    private b hSi;
    private e hSj;
    private LinearLayout hSk;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dXF) {
                j.this.dXG.setChecked(false);
                j.this.dXH.setChecked(false);
                j.this.dXI.setChecked(false);
                j.this.dXJ.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dXG) {
                j.this.dXF.setChecked(true);
                j.this.dXH.setChecked(false);
                j.this.dXI.setChecked(false);
                j.this.dXJ.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dXH) {
                j.this.dXF.setChecked(true);
                j.this.dXG.setChecked(true);
                j.this.dXI.setChecked(false);
                j.this.dXJ.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dXI) {
                j.this.dXF.setChecked(true);
                j.this.dXG.setChecked(true);
                j.this.dXH.setChecked(true);
                j.this.dXJ.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dXJ) {
                j.this.dXF.setChecked(true);
                j.this.dXG.setChecked(true);
                j.this.dXH.setChecked(true);
                j.this.dXI.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hSj != null) {
                j.this.hSj.ub(j.this.mScore);
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
        void hR(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void ub(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hQZ = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hRa = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.anq = (TextView) this.view.findViewById(e.g.title);
            this.hRb = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hRc = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
            this.dXF = (RadioButton) this.view.findViewById(e.g.comment_grade_1);
            this.dXF.setOnClickListener(this.mOnClickListener);
            this.dXG = (RadioButton) this.view.findViewById(e.g.comment_grade_2);
            this.dXG.setOnClickListener(this.mOnClickListener);
            this.dXH = (RadioButton) this.view.findViewById(e.g.comment_grade_3);
            this.dXH.setOnClickListener(this.mOnClickListener);
            this.dXI = (RadioButton) this.view.findViewById(e.g.comment_grade_4);
            this.dXI.setOnClickListener(this.mOnClickListener);
            this.dXJ = (RadioButton) this.view.findViewById(e.g.comment_grade_5);
            this.dXJ.setOnClickListener(this.mOnClickListener);
            this.hSk = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hQZ;
    }

    public ViewGroup akV() {
        return this.hRa;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void or(boolean z) {
        this.dXF.setEnabled(z);
        this.dXG.setEnabled(z);
        this.dXH.setEnabled(z);
        this.dXI.setEnabled(z);
        this.dXJ.setEnabled(z);
    }

    public void xc(int i) {
        switch (i) {
            case 1:
                this.dXF.setChecked(true);
                this.dXG.setChecked(false);
                this.dXH.setChecked(false);
                this.dXI.setChecked(false);
                this.dXJ.setChecked(false);
                return;
            case 2:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(false);
                this.dXI.setChecked(false);
                this.dXJ.setChecked(false);
                return;
            case 3:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(false);
                this.dXJ.setChecked(false);
                return;
            case 4:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(true);
                this.dXJ.setChecked(false);
                return;
            case 5:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(true);
                this.dXJ.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void xd(int i) {
        this.hSk.setVisibility(i);
    }

    public void z(int i, int i2, int i3, int i4) {
        this.hSk.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.anq.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.anq.setTextSize(0, l.h(this.hQZ, i));
    }

    public d bNz() {
        return this.hSh;
    }

    public void ef(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hRa.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hRa.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hSi = bVar;
    }

    public void a(e eVar) {
        this.hSj = eVar;
    }

    public void xe(int i) {
        this.hRc.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.anq, e.d.cp_bg_line_d);
        al.h(this.anq, e.d.cp_cont_j);
        al.j(this.hRb, e.d.cp_bg_line_c);
        al.i(this.hRc, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hRc, e.d.cp_cont_f);
        al.i(this.hSk, e.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bNw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.anq.setText(this.titleText);
        } else {
            this.anq.setVisibility(8);
        }
        if (this.hSi != null) {
            this.hRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hSi.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View euU;
        private j hSm;
        private c hSn;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hRh = e.f.person_more_pop_item_bg_selector;
        private int hRi = 17;
        private boolean hRk = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hSn != null) {
                    a.this.hSn.onClick();
                }
                if (a.this.hSm != null && a.this.hSm.bNz() != null) {
                    a.this.hSm.bNz().hR(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.hSm = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hSn = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.euU, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hSm != null && this.hSm.getContext() != null) {
                this.mView = LayoutInflater.from(this.hSm.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hSm.akV(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hRi);
                this.euU = this.mView.findViewById(e.g.divider_line);
                if (this.hRk) {
                    this.euU.setVisibility(0);
                } else {
                    this.euU.setVisibility(8);
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
