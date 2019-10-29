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
    private TextView bUW;
    private Context cfP;
    private LinearLayout cfR;
    private View cfS;
    private TextView cfT;
    private RadioButton fIi;
    private RadioButton fIj;
    private RadioButton fIk;
    private RadioButton fIl;
    private RadioButton fIm;
    private d jKU;
    private b jKV;
    private e jKW;
    private LinearLayout jKX;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fIi) {
                j.this.fIj.setChecked(false);
                j.this.fIk.setChecked(false);
                j.this.fIl.setChecked(false);
                j.this.fIm.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fIj) {
                j.this.fIi.setChecked(true);
                j.this.fIk.setChecked(false);
                j.this.fIl.setChecked(false);
                j.this.fIm.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fIk) {
                j.this.fIi.setChecked(true);
                j.this.fIj.setChecked(true);
                j.this.fIl.setChecked(false);
                j.this.fIm.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fIl) {
                j.this.fIi.setChecked(true);
                j.this.fIj.setChecked(true);
                j.this.fIk.setChecked(true);
                j.this.fIm.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fIm) {
                j.this.fIi.setChecked(true);
                j.this.fIj.setChecked(true);
                j.this.fIk.setChecked(true);
                j.this.fIl.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jKW != null) {
                j.this.jKW.yg(j.this.mScore);
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
        void lL(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void yg(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.cfP = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cfR = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bUW = (TextView) this.view.findViewById(R.id.title);
            this.cfS = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cfT = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.fIi = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.fIi.setOnClickListener(this.mOnClickListener);
            this.fIj = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.fIj.setOnClickListener(this.mOnClickListener);
            this.fIk = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.fIk.setOnClickListener(this.mOnClickListener);
            this.fIl = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.fIl.setOnClickListener(this.mOnClickListener);
            this.fIm = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.fIm.setOnClickListener(this.mOnClickListener);
            this.jKX = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.cfP;
    }

    public ViewGroup alc() {
        return this.cfR;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void rH(boolean z) {
        this.fIi.setEnabled(z);
        this.fIj.setEnabled(z);
        this.fIk.setEnabled(z);
        this.fIl.setEnabled(z);
        this.fIm.setEnabled(z);
    }

    public void Bl(int i) {
        switch (i) {
            case 1:
                this.fIi.setChecked(true);
                this.fIj.setChecked(false);
                this.fIk.setChecked(false);
                this.fIl.setChecked(false);
                this.fIm.setChecked(false);
                return;
            case 2:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(false);
                this.fIl.setChecked(false);
                this.fIm.setChecked(false);
                return;
            case 3:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(true);
                this.fIl.setChecked(false);
                this.fIm.setChecked(false);
                return;
            case 4:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(true);
                this.fIl.setChecked(true);
                this.fIm.setChecked(false);
                return;
            case 5:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(true);
                this.fIl.setChecked(true);
                this.fIm.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Bm(int i) {
        this.jKX.setVisibility(i);
    }

    public void B(int i, int i2, int i3, int i4) {
        this.jKX.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bUW.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bUW.setTextSize(0, l.getDimens(this.cfP, i));
    }

    public d cwS() {
        return this.jKU;
    }

    public void at(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cfR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cfR.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jKV = bVar;
    }

    public void a(e eVar) {
        this.jKW = eVar;
    }

    public void Bn(int i) {
        this.cfT.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.bUW, R.color.cp_bg_line_d);
        am.setViewTextColor(this.bUW, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cfS, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cfT, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cfT, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.jKX, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View ale() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bUW.setText(this.titleText);
        } else {
            this.bUW.setVisibility(8);
        }
        if (this.jKV != null) {
            this.cfT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jKV.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View cfA;
        private j jKZ;
        private c jLa;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int cfB = R.drawable.person_more_pop_item_bg_selector;
        private int cfC = 17;
        private boolean cfE = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jLa != null) {
                    a.this.jLa.onClick();
                }
                if (a.this.jKZ != null && a.this.jKZ.cwS() != null) {
                    a.this.jKZ.cwS().lL(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.mText = str;
            this.jKZ = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jLa = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.cfA, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jKZ != null && this.jKZ.getContext() != null) {
                this.mView = LayoutInflater.from(this.jKZ.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jKZ.alc(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cfC);
                this.cfA = this.mView.findViewById(R.id.divider_line);
                if (this.cfE) {
                    this.cfA.setVisibility(0);
                } else {
                    this.cfA.setVisibility(8);
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
