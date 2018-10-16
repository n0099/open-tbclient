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
    private TextView aiy;
    private RadioButton dMA;
    private RadioButton dMB;
    private RadioButton dMC;
    private RadioButton dMD;
    private RadioButton dME;
    private Context hDK;
    private LinearLayout hDL;
    private View hDM;
    private TextView hDN;
    private d hES;
    private b hET;
    private e hEU;
    private LinearLayout hEV;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.dMA) {
                j.this.dMB.setChecked(false);
                j.this.dMC.setChecked(false);
                j.this.dMD.setChecked(false);
                j.this.dME.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.dMB) {
                j.this.dMA.setChecked(true);
                j.this.dMC.setChecked(false);
                j.this.dMD.setChecked(false);
                j.this.dME.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dMC) {
                j.this.dMA.setChecked(true);
                j.this.dMB.setChecked(true);
                j.this.dMD.setChecked(false);
                j.this.dME.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dMD) {
                j.this.dMA.setChecked(true);
                j.this.dMB.setChecked(true);
                j.this.dMC.setChecked(true);
                j.this.dME.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dME) {
                j.this.dMA.setChecked(true);
                j.this.dMB.setChecked(true);
                j.this.dMC.setChecked(true);
                j.this.dMD.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hEU != null) {
                j.this.hEU.sX(j.this.mScore);
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
        void hp(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void sX(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hDK = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hDL = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.aiy = (TextView) this.view.findViewById(e.g.title);
            this.hDM = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hDN = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
            this.dMA = (RadioButton) this.view.findViewById(e.g.comment_grade_1);
            this.dMA.setOnClickListener(this.mOnClickListener);
            this.dMB = (RadioButton) this.view.findViewById(e.g.comment_grade_2);
            this.dMB.setOnClickListener(this.mOnClickListener);
            this.dMC = (RadioButton) this.view.findViewById(e.g.comment_grade_3);
            this.dMC.setOnClickListener(this.mOnClickListener);
            this.dMD = (RadioButton) this.view.findViewById(e.g.comment_grade_4);
            this.dMD.setOnClickListener(this.mOnClickListener);
            this.dME = (RadioButton) this.view.findViewById(e.g.comment_grade_5);
            this.dME.setOnClickListener(this.mOnClickListener);
            this.hEV = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hDK;
    }

    public ViewGroup ajw() {
        return this.hDL;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void nX(boolean z) {
        this.dMA.setEnabled(z);
        this.dMB.setEnabled(z);
        this.dMC.setEnabled(z);
        this.dMD.setEnabled(z);
        this.dME.setEnabled(z);
    }

    public void vX(int i) {
        switch (i) {
            case 1:
                this.dMA.setChecked(true);
                this.dMB.setChecked(false);
                this.dMC.setChecked(false);
                this.dMD.setChecked(false);
                this.dME.setChecked(false);
                return;
            case 2:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(false);
                this.dMD.setChecked(false);
                this.dME.setChecked(false);
                return;
            case 3:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(true);
                this.dMD.setChecked(false);
                this.dME.setChecked(false);
                return;
            case 4:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(true);
                this.dMD.setChecked(true);
                this.dME.setChecked(false);
                return;
            case 5:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(true);
                this.dMD.setChecked(true);
                this.dME.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void vY(int i) {
        this.hEV.setVisibility(i);
    }

    public void y(int i, int i2, int i3, int i4) {
        this.hEV.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.aiy.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.aiy.setTextSize(0, l.h(this.hDK, i));
    }

    public d bKy() {
        return this.hES;
    }

    public void eb(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hDL.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hDL.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hET = bVar;
    }

    public void a(e eVar) {
        this.hEU = eVar;
    }

    public void vZ(int i) {
        this.hDN.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.aiy, e.d.cp_bg_line_d);
        al.h(this.aiy, e.d.cp_cont_j);
        al.j(this.hDM, e.d.cp_bg_line_c);
        al.i(this.hDN, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hDN, e.d.cp_cont_f);
        al.i(this.hEV, e.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bKv() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aiy.setText(this.titleText);
        } else {
            this.aiy.setVisibility(8);
        }
        if (this.hET != null) {
            this.hDN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hET.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View ejg;
        private j hEX;
        private c hEY;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hDS = e.f.person_more_pop_item_bg_selector;
        private int hDT = 17;
        private boolean hDV = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hEY != null) {
                    a.this.hEY.onClick();
                }
                if (a.this.hEX != null && a.this.hEX.bKy() != null) {
                    a.this.hEX.bKy().hp(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.hEX = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hEY = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.ejg, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hEX != null && this.hEX.getContext() != null) {
                this.mView = LayoutInflater.from(this.hEX.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hEX.ajw(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hDT);
                this.ejg = this.mView.findViewById(e.g.divider_line);
                if (this.hDV) {
                    this.ejg.setVisibility(0);
                } else {
                    this.ejg.setVisibility(8);
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
