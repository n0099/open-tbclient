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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private TextView abq;
    private RadioButton drY;
    private RadioButton drZ;
    private RadioButton dsa;
    private RadioButton dsb;
    private RadioButton dsc;
    private Context hjs;
    private LinearLayout hjt;
    private View hju;
    private TextView hjv;
    private b hkA;
    private e hkB;
    private LinearLayout hkC;
    private d hkz;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.drY) {
                j.this.drZ.setChecked(false);
                j.this.dsa.setChecked(false);
                j.this.dsb.setChecked(false);
                j.this.dsc.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.drZ) {
                j.this.drY.setChecked(true);
                j.this.dsa.setChecked(false);
                j.this.dsb.setChecked(false);
                j.this.dsc.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.dsa) {
                j.this.drY.setChecked(true);
                j.this.drZ.setChecked(true);
                j.this.dsb.setChecked(false);
                j.this.dsc.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.dsb) {
                j.this.drY.setChecked(true);
                j.this.drZ.setChecked(true);
                j.this.dsa.setChecked(true);
                j.this.dsc.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.dsc) {
                j.this.drY.setChecked(true);
                j.this.drZ.setChecked(true);
                j.this.dsa.setChecked(true);
                j.this.dsb.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.hkB != null) {
                j.this.hkB.onClick(j.this.mScore);
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
        void onItemClick(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onClick(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.hjs = context;
            this.view = LayoutInflater.from(context).inflate(d.i.rate_list_dialog_view, (ViewGroup) null);
            this.hjt = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.abq = (TextView) this.view.findViewById(d.g.title);
            this.hju = this.view.findViewById(d.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hjv = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
            this.drY = (RadioButton) this.view.findViewById(d.g.comment_grade_1);
            this.drY.setOnClickListener(this.mOnClickListener);
            this.drZ = (RadioButton) this.view.findViewById(d.g.comment_grade_2);
            this.drZ.setOnClickListener(this.mOnClickListener);
            this.dsa = (RadioButton) this.view.findViewById(d.g.comment_grade_3);
            this.dsa.setOnClickListener(this.mOnClickListener);
            this.dsb = (RadioButton) this.view.findViewById(d.g.comment_grade_4);
            this.dsb.setOnClickListener(this.mOnClickListener);
            this.dsc = (RadioButton) this.view.findViewById(d.g.comment_grade_5);
            this.dsc.setOnClickListener(this.mOnClickListener);
            this.hkC = (LinearLayout) this.view.findViewById(d.g.comment_grade);
        }
    }

    public Context getContext() {
        return this.hjs;
    }

    public ViewGroup adg() {
        return this.hjt;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void no(boolean z) {
        this.drY.setEnabled(z);
        this.drZ.setEnabled(z);
        this.dsa.setEnabled(z);
        this.dsb.setEnabled(z);
        this.dsc.setEnabled(z);
    }

    public void uT(int i) {
        switch (i) {
            case 1:
                this.drY.setChecked(true);
                this.drZ.setChecked(false);
                this.dsa.setChecked(false);
                this.dsb.setChecked(false);
                this.dsc.setChecked(false);
                return;
            case 2:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(false);
                this.dsb.setChecked(false);
                this.dsc.setChecked(false);
                return;
            case 3:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(true);
                this.dsb.setChecked(false);
                this.dsc.setChecked(false);
                return;
            case 4:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(true);
                this.dsb.setChecked(true);
                this.dsc.setChecked(false);
                return;
            case 5:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(true);
                this.dsb.setChecked(true);
                this.dsc.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void uU(int i) {
        this.hkC.setVisibility(i);
    }

    public void A(int i, int i2, int i3, int i4) {
        this.hkC.setPadding(i, i2, i3, i4);
    }

    public void B(int i, int i2, int i3, int i4) {
        this.abq.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.abq.setTextSize(0, l.e(this.hjs, i));
    }

    public d bFi() {
        return this.hkz;
    }

    public void dN(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.hjt.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hjt.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hkA = bVar;
    }

    public void a(e eVar) {
        this.hkB = eVar;
    }

    public void uV(int i) {
        this.hjv.setVisibility(i);
    }

    public void onChangeSkinType() {
        al.j(this.abq, d.C0141d.cp_bg_line_d);
        al.h(this.abq, d.C0141d.cp_cont_j);
        al.j(this.hju, d.C0141d.cp_bg_line_c);
        al.i(this.hjv, d.f.bg_bottom_up_list_dialog_item);
        al.h(this.hjv, d.C0141d.cp_cont_f);
        al.i(this.hkC, d.f.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bFf() {
        if (!StringUtils.isNull(this.titleText)) {
            this.abq.setText(this.titleText);
        } else {
            this.abq.setVisibility(8);
        }
        if (this.hkA != null) {
            this.hjv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.hkA.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aon;
        private View dNV;
        private j hkE;
        private c hkF;
        private TextView mTextView;
        private View mView;
        private int mTextColor = d.f.person_more_pop_cancel_text_selector;
        private int hjA = d.f.person_more_pop_item_bg_selector;
        private int hjB = 17;
        private boolean hjD = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hkF != null) {
                    a.this.hkF.onClick();
                }
                if (a.this.hkE != null && a.this.hkE.bFi() != null) {
                    a.this.hkE.bFi().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.aon = str;
            this.hkE = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.hkF = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, d.C0141d.cp_cont_f);
            al.j(this.dNV, d.C0141d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hkE != null && this.hkE.getContext() != null) {
                this.mView = LayoutInflater.from(this.hkE.getContext()).inflate(d.i.bottom_up_list_dialog_item, this.hkE.adg(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.aon);
                this.mTextView.setGravity(this.hjB);
                this.dNV = this.mView.findViewById(d.g.divider_line);
                if (this.hjD) {
                    this.dNV.setVisibility(0);
                } else {
                    this.dNV.setVisibility(8);
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
