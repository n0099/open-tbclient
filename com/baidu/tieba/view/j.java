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
    private List<a> aPr;
    private TextView bCd;
    private Context bOf;
    private LinearLayout bOh;
    private View bOi;
    private TextView bOj;
    private RadioButton fGn;
    private RadioButton fGo;
    private RadioButton fGp;
    private RadioButton fGq;
    private RadioButton fGr;
    private d jHD;
    private b jHE;
    private e jHF;
    private LinearLayout jHG;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fGn) {
                j.this.fGo.setChecked(false);
                j.this.fGp.setChecked(false);
                j.this.fGq.setChecked(false);
                j.this.fGr.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fGo) {
                j.this.fGn.setChecked(true);
                j.this.fGp.setChecked(false);
                j.this.fGq.setChecked(false);
                j.this.fGr.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fGp) {
                j.this.fGn.setChecked(true);
                j.this.fGo.setChecked(true);
                j.this.fGq.setChecked(false);
                j.this.fGr.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fGq) {
                j.this.fGn.setChecked(true);
                j.this.fGo.setChecked(true);
                j.this.fGp.setChecked(true);
                j.this.fGr.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fGr) {
                j.this.fGn.setChecked(true);
                j.this.fGo.setChecked(true);
                j.this.fGp.setChecked(true);
                j.this.fGq.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jHF != null) {
                j.this.jHF.zw(j.this.mScore);
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
        void mB(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void zw(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.bOf = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.bOh = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bCd = (TextView) this.view.findViewById(R.id.title);
            this.bOi = this.view.findViewById(R.id.title_divide_line);
            this.aPr = new ArrayList();
            this.bOj = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.fGn = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.fGn.setOnClickListener(this.mOnClickListener);
            this.fGo = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.fGo.setOnClickListener(this.mOnClickListener);
            this.fGp = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.fGp.setOnClickListener(this.mOnClickListener);
            this.fGq = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.fGq.setOnClickListener(this.mOnClickListener);
            this.fGr = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.fGr.setOnClickListener(this.mOnClickListener);
            this.jHG = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.bOf;
    }

    public ViewGroup agZ() {
        return this.bOh;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void rU(boolean z) {
        this.fGn.setEnabled(z);
        this.fGo.setEnabled(z);
        this.fGp.setEnabled(z);
        this.fGq.setEnabled(z);
        this.fGr.setEnabled(z);
    }

    public void CA(int i) {
        switch (i) {
            case 1:
                this.fGn.setChecked(true);
                this.fGo.setChecked(false);
                this.fGp.setChecked(false);
                this.fGq.setChecked(false);
                this.fGr.setChecked(false);
                return;
            case 2:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(false);
                this.fGq.setChecked(false);
                this.fGr.setChecked(false);
                return;
            case 3:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(true);
                this.fGq.setChecked(false);
                this.fGr.setChecked(false);
                return;
            case 4:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(true);
                this.fGq.setChecked(true);
                this.fGr.setChecked(false);
                return;
            case 5:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(true);
                this.fGq.setChecked(true);
                this.fGr.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void CB(int i) {
        this.jHG.setVisibility(i);
    }

    public void D(int i, int i2, int i3, int i4) {
        this.jHG.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bCd.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bCd.setTextSize(0, l.g(this.bOf, i));
    }

    public d cxU() {
        return this.jHD;
    }

    public void W(List<a> list) {
        if (list != null) {
            this.aPr = list;
            this.bOh.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bOh.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jHE = bVar;
    }

    public void a(e eVar) {
        this.jHF = eVar;
    }

    public void CC(int i) {
        this.bOj.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.l(this.bCd, R.color.cp_bg_line_d);
        am.j(this.bCd, R.color.cp_cont_j);
        am.l(this.bOi, R.color.cp_bg_line_c);
        am.k(this.bOj, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.bOj, R.color.cp_cont_f);
        am.k(this.jHG, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.aPr != null) {
            for (a aVar : this.aPr) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View ahb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCd.setText(this.titleText);
        } else {
            this.bCd.setVisibility(8);
        }
        if (this.jHE != null) {
            this.bOj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jHE.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String amD;
        private View bNS;
        private j jHI;
        private c jHJ;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int bNT = R.drawable.person_more_pop_item_bg_selector;
        private int bNU = 17;
        private boolean bNW = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jHJ != null) {
                    a.this.jHJ.onClick();
                }
                if (a.this.jHI != null && a.this.jHI.cxU() != null) {
                    a.this.jHI.cxU().mB(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.amD = str;
            this.jHI = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jHJ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.j(this.mTextView, R.color.cp_cont_f);
            am.l(this.bNS, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jHI != null && this.jHI.getContext() != null) {
                this.mView = LayoutInflater.from(this.jHI.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jHI.agZ(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.amD);
                this.mTextView.setGravity(this.bNU);
                this.bNS = this.mView.findViewById(R.id.divider_line);
                if (this.bNW) {
                    this.bNS.setVisibility(0);
                } else {
                    this.bNS.setVisibility(8);
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
