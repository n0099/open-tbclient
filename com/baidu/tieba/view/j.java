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
    private Context hDL;
    private LinearLayout hDM;
    private View hDN;
    private TextView hDO;
    private d hET;
    private b hEU;
    private e hEV;
    private LinearLayout hEW;
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
            if (j.this.hEV != null) {
                j.this.hEV.sX(j.this.mScore);
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
            this.hDL = context;
            this.view = LayoutInflater.from(context).inflate(e.h.rate_list_dialog_view, (ViewGroup) null);
            this.hDM = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.aiy = (TextView) this.view.findViewById(e.g.title);
            this.hDN = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hDO = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
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
            this.hEW = (LinearLayout) this.view.findViewById(e.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hDL;
    }

    public ViewGroup ajx() {
        return this.hDM;
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
        this.hEW.setVisibility(i);
    }

    public void y(int i, int i2, int i3, int i4) {
        this.hEW.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.aiy.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.aiy.setTextSize(0, l.h(this.hDL, i));
    }

    public d bKy() {
        return this.hET;
    }

    public void eb(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hDM.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hDM.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hEU = bVar;
    }

    public void a(e eVar) {
        this.hEV = eVar;
    }

    public void vZ(int i) {
        this.hDO.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.aiy, e.d.cp_bg_line_d);
        al.h(this.aiy, e.d.cp_cont_j);
        al.j(this.hDN, e.d.cp_bg_line_c);
        al.i(this.hDO, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hDO, e.d.cp_cont_f);
        al.i(this.hEW, e.f.bg_bottom_up_list_dialog_item);
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
        if (this.hEU != null) {
            this.hDO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hEU.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View ejh;
        private j hEY;
        private c hEZ;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = e.f.person_more_pop_cancel_text_selector;
        private int hDT = e.f.person_more_pop_item_bg_selector;
        private int hDU = 17;
        private boolean hDW = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hEZ != null) {
                    a.this.hEZ.onClick();
                }
                if (a.this.hEY != null && a.this.hEY.bKy() != null) {
                    a.this.hEY.bKy().hp(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.hEY = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hEZ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_f);
            al.j(this.ejh, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hEY != null && this.hEY.getContext() != null) {
                this.mView = LayoutInflater.from(this.hEY.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hEY.ajx(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hDU);
                this.ejh = this.mView.findViewById(e.g.divider_line);
                if (this.hDW) {
                    this.ejh.setVisibility(0);
                } else {
                    this.ejh.setVisibility(8);
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
