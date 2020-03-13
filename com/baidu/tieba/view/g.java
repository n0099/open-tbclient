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
public class g {
    private TextView cKS;
    private Context cVK;
    private LinearLayout cVM;
    private View cVN;
    private TextView cVO;
    private RadioButton gBi;
    private RadioButton gBj;
    private RadioButton gBk;
    private RadioButton gBl;
    private RadioButton gBm;
    private d kJo;
    private b kJp;
    private e kJq;
    private LinearLayout kJr;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gBi) {
                g.this.gBj.setChecked(false);
                g.this.gBk.setChecked(false);
                g.this.gBl.setChecked(false);
                g.this.gBm.setChecked(false);
                g.this.mScore = 1;
            } else if (view == g.this.gBj) {
                g.this.gBi.setChecked(true);
                g.this.gBk.setChecked(false);
                g.this.gBl.setChecked(false);
                g.this.gBm.setChecked(false);
                g.this.mScore = 2;
            } else if (view == g.this.gBk) {
                g.this.gBi.setChecked(true);
                g.this.gBj.setChecked(true);
                g.this.gBl.setChecked(false);
                g.this.gBm.setChecked(false);
                g.this.mScore = 3;
            } else if (view == g.this.gBl) {
                g.this.gBi.setChecked(true);
                g.this.gBj.setChecked(true);
                g.this.gBk.setChecked(true);
                g.this.gBm.setChecked(false);
                g.this.mScore = 4;
            } else if (view == g.this.gBm) {
                g.this.gBi.setChecked(true);
                g.this.gBj.setChecked(true);
                g.this.gBk.setChecked(true);
                g.this.gBl.setChecked(true);
                g.this.mScore = 5;
            }
            if (g.this.kJq != null) {
                g.this.kJq.AP(g.this.mScore);
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
        void AP(int i);
    }

    public g(Context context) {
        if (context != null) {
            this.cVK = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.cVM = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cKS = (TextView) this.view.findViewById(R.id.title);
            this.cVN = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cVO = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.gBi = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.gBi.setOnClickListener(this.mOnClickListener);
            this.gBj = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.gBj.setOnClickListener(this.mOnClickListener);
            this.gBk = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.gBk.setOnClickListener(this.mOnClickListener);
            this.gBl = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.gBl.setOnClickListener(this.mOnClickListener);
            this.gBm = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.gBm.setOnClickListener(this.mOnClickListener);
            this.kJr = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.cVK;
    }

    public ViewGroup getView() {
        return this.cVM;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void tC(boolean z) {
        this.gBi.setEnabled(z);
        this.gBj.setEnabled(z);
        this.gBk.setEnabled(z);
        this.gBl.setEnabled(z);
        this.gBm.setEnabled(z);
    }

    public void DS(int i) {
        switch (i) {
            case 1:
                this.gBi.setChecked(true);
                this.gBj.setChecked(false);
                this.gBk.setChecked(false);
                this.gBl.setChecked(false);
                this.gBm.setChecked(false);
                return;
            case 2:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(false);
                this.gBl.setChecked(false);
                this.gBm.setChecked(false);
                return;
            case 3:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(true);
                this.gBl.setChecked(false);
                this.gBm.setChecked(false);
                return;
            case 4:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(true);
                this.gBl.setChecked(true);
                this.gBm.setChecked(false);
                return;
            case 5:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(true);
                this.gBl.setChecked(true);
                this.gBm.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void DT(int i) {
        this.kJr.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.kJr.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.cKS.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.cKS.setTextSize(0, l.getDimens(this.cVK, i));
    }

    public d cTB() {
        return this.kJo;
    }

    public void az(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.cVM.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.cVM.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kJp = bVar;
    }

    public void a(e eVar) {
        this.kJq = eVar;
    }

    public void DU(int i) {
        this.cVO.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.cKS, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cKS, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.cVN, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVO, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cVO, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.kJr, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aER() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKS.setText(this.titleText);
        } else {
            this.cKS.setVisibility(8);
        }
        if (this.kJp != null) {
            this.cVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.kJp.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View cVv;
        private g kJt;
        private c kJu;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int cVw = R.drawable.person_more_pop_item_bg_selector;
        private int cVx = 17;
        private boolean cVz = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.g.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kJu != null) {
                    a.this.kJu.onClick();
                }
                if (a.this.kJt != null && a.this.kJt.cTB() != null) {
                    a.this.kJt.cTB().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, g gVar) {
            this.mText = str;
            this.kJt = gVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.kJu = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.cVv, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kJt != null && this.kJt.getContext() != null) {
                this.mView = LayoutInflater.from(this.kJt.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kJt.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cVx);
                this.cVv = this.mView.findViewById(R.id.divider_line);
                if (this.cVz) {
                    this.cVv.setVisibility(0);
                } else {
                    this.cVv.setVisibility(8);
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
