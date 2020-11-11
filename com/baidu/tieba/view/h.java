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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private Context eIE;
    private LinearLayout eIG;
    private View eIH;
    private TextView eII;
    private TextView evg;
    private RadioButton iWT;
    private RadioButton iWU;
    private RadioButton iWV;
    private RadioButton iWW;
    private RadioButton iWX;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iWT) {
                h.this.iWU.setChecked(false);
                h.this.iWV.setChecked(false);
                h.this.iWW.setChecked(false);
                h.this.iWX.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.iWU) {
                h.this.iWT.setChecked(true);
                h.this.iWV.setChecked(false);
                h.this.iWW.setChecked(false);
                h.this.iWX.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.iWV) {
                h.this.iWT.setChecked(true);
                h.this.iWU.setChecked(true);
                h.this.iWW.setChecked(false);
                h.this.iWX.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.iWW) {
                h.this.iWT.setChecked(true);
                h.this.iWU.setChecked(true);
                h.this.iWV.setChecked(true);
                h.this.iWX.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.iWX) {
                h.this.iWT.setChecked(true);
                h.this.iWU.setChecked(true);
                h.this.iWV.setChecked(true);
                h.this.iWW.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.nBG != null) {
                h.this.nBG.HP(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d nBE;
    private b nBF;
    private e nBG;
    private LinearLayout nBH;
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
        void HP(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eIE = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eIG = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.evg = (TextView) this.view.findViewById(R.id.title);
            this.eIH = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eII = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.iWT = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.iWT.setOnClickListener(this.mOnClickListener);
            this.iWU = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.iWU.setOnClickListener(this.mOnClickListener);
            this.iWV = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.iWV.setOnClickListener(this.mOnClickListener);
            this.iWW = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.iWW.setOnClickListener(this.mOnClickListener);
            this.iWX = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.iWX.setOnClickListener(this.mOnClickListener);
            this.nBH = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eIE;
    }

    public ViewGroup getView() {
        return this.eIG;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void yl(boolean z) {
        this.iWT.setEnabled(z);
        this.iWU.setEnabled(z);
        this.iWV.setEnabled(z);
        this.iWW.setEnabled(z);
        this.iWX.setEnabled(z);
    }

    public void La(int i) {
        switch (i) {
            case 1:
                this.iWT.setChecked(true);
                this.iWU.setChecked(false);
                this.iWV.setChecked(false);
                this.iWW.setChecked(false);
                this.iWX.setChecked(false);
                return;
            case 2:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(false);
                this.iWW.setChecked(false);
                this.iWX.setChecked(false);
                return;
            case 3:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(true);
                this.iWW.setChecked(false);
                this.iWX.setChecked(false);
                return;
            case 4:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(true);
                this.iWW.setChecked(true);
                this.iWX.setChecked(false);
                return;
            case 5:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(true);
                this.iWW.setChecked(true);
                this.iWX.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Lb(int i) {
        this.nBH.setVisibility(i);
    }

    public void I(int i, int i2, int i3, int i4) {
        this.nBH.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.evg.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.evg.setTextSize(0, l.getDimens(this.eIE, i));
    }

    public d dSL() {
        return this.nBE;
    }

    public void br(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eIG.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eIG.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nBF = bVar;
    }

    public void a(e eVar) {
        this.nBG = eVar;
    }

    public void Lc(int i) {
        this.eII.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.evg, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.evg, R.color.cp_cont_j);
        ap.setBackgroundColor(this.eIH, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eII, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eII, R.color.cp_cont_f);
        ap.setBackgroundResource(this.nBH, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bps() {
        if (!StringUtils.isNull(this.titleText)) {
            this.evg.setText(this.titleText);
        } else {
            this.evg.setVisibility(8);
        }
        if (this.nBF != null) {
            this.eII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.nBF.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eIp;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h nBJ;
        private c nBK;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eIq = R.drawable.person_more_pop_item_bg_selector;
        private int eIr = 17;
        private boolean eIt = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nBK != null) {
                    a.this.nBK.onClick();
                }
                if (a.this.nBJ != null && a.this.nBJ.dSL() != null) {
                    a.this.nBJ.dSL().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.nBJ = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nBK = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ap.setBackgroundColor(this.eIp, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.nBJ != null && this.nBJ.getContext() != null) {
                this.mView = LayoutInflater.from(this.nBJ.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nBJ.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eIr);
                this.eIp = this.mView.findViewById(R.id.divider_line);
                if (this.eIt) {
                    this.eIp.setVisibility(0);
                } else {
                    this.eIp.setVisibility(8);
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
