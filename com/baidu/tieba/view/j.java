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
    private Context bOk;
    private LinearLayout bOm;
    private View bOn;
    private TextView bOo;
    private RadioButton fHb;
    private RadioButton fHc;
    private RadioButton fHd;
    private RadioButton fHe;
    private RadioButton fHf;
    private d jIK;
    private b jIL;
    private e jIM;
    private LinearLayout jIN;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == j.this.fHb) {
                j.this.fHc.setChecked(false);
                j.this.fHd.setChecked(false);
                j.this.fHe.setChecked(false);
                j.this.fHf.setChecked(false);
                j.this.mScore = 1;
            } else if (view == j.this.fHc) {
                j.this.fHb.setChecked(true);
                j.this.fHd.setChecked(false);
                j.this.fHe.setChecked(false);
                j.this.fHf.setChecked(false);
                j.this.mScore = 2;
            } else if (view == j.this.fHd) {
                j.this.fHb.setChecked(true);
                j.this.fHc.setChecked(true);
                j.this.fHe.setChecked(false);
                j.this.fHf.setChecked(false);
                j.this.mScore = 3;
            } else if (view == j.this.fHe) {
                j.this.fHb.setChecked(true);
                j.this.fHc.setChecked(true);
                j.this.fHd.setChecked(true);
                j.this.fHf.setChecked(false);
                j.this.mScore = 4;
            } else if (view == j.this.fHf) {
                j.this.fHb.setChecked(true);
                j.this.fHc.setChecked(true);
                j.this.fHd.setChecked(true);
                j.this.fHe.setChecked(true);
                j.this.mScore = 5;
            }
            if (j.this.jIM != null) {
                j.this.jIM.zy(j.this.mScore);
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
        void mC(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void zy(int i);
    }

    public j(Context context) {
        if (context != null) {
            this.bOk = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.bOm = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bCd = (TextView) this.view.findViewById(R.id.title);
            this.bOn = this.view.findViewById(R.id.title_divide_line);
            this.aPr = new ArrayList();
            this.bOo = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.fHb = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.fHb.setOnClickListener(this.mOnClickListener);
            this.fHc = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.fHc.setOnClickListener(this.mOnClickListener);
            this.fHd = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.fHd.setOnClickListener(this.mOnClickListener);
            this.fHe = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.fHe.setOnClickListener(this.mOnClickListener);
            this.fHf = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.fHf.setOnClickListener(this.mOnClickListener);
            this.jIN = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.bOk;
    }

    public ViewGroup ahb() {
        return this.bOm;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void rV(boolean z) {
        this.fHb.setEnabled(z);
        this.fHc.setEnabled(z);
        this.fHd.setEnabled(z);
        this.fHe.setEnabled(z);
        this.fHf.setEnabled(z);
    }

    public void CC(int i) {
        switch (i) {
            case 1:
                this.fHb.setChecked(true);
                this.fHc.setChecked(false);
                this.fHd.setChecked(false);
                this.fHe.setChecked(false);
                this.fHf.setChecked(false);
                return;
            case 2:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(false);
                this.fHe.setChecked(false);
                this.fHf.setChecked(false);
                return;
            case 3:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(true);
                this.fHe.setChecked(false);
                this.fHf.setChecked(false);
                return;
            case 4:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(true);
                this.fHe.setChecked(true);
                this.fHf.setChecked(false);
                return;
            case 5:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(true);
                this.fHe.setChecked(true);
                this.fHf.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void CD(int i) {
        this.jIN.setVisibility(i);
    }

    public void D(int i, int i2, int i3, int i4) {
        this.jIN.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.bCd.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.bCd.setTextSize(0, l.g(this.bOk, i));
    }

    public d cyq() {
        return this.jIK;
    }

    public void W(List<a> list) {
        if (list != null) {
            this.aPr = list;
            this.bOm.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.bOm.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jIL = bVar;
    }

    public void a(e eVar) {
        this.jIM = eVar;
    }

    public void CE(int i) {
        this.bOo.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.l(this.bCd, R.color.cp_bg_line_d);
        am.j(this.bCd, R.color.cp_cont_j);
        am.l(this.bOn, R.color.cp_bg_line_c);
        am.k(this.bOo, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.bOo, R.color.cp_cont_f);
        am.k(this.jIN, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.aPr != null) {
            for (a aVar : this.aPr) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View ahd() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCd.setText(this.titleText);
        } else {
            this.bCd.setVisibility(8);
        }
        if (this.jIL != null) {
            this.bOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.jIL.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String amD;
        private View bNX;
        private j jIP;
        private c jIQ;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int bNY = R.drawable.person_more_pop_item_bg_selector;
        private int bNZ = 17;
        private boolean bOb = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.j.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jIQ != null) {
                    a.this.jIQ.onClick();
                }
                if (a.this.jIP != null && a.this.jIP.cyq() != null) {
                    a.this.jIP.cyq().mC(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, j jVar) {
            this.amD = str;
            this.jIP = jVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.jIQ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.j(this.mTextView, R.color.cp_cont_f);
            am.l(this.bNX, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jIP != null && this.jIP.getContext() != null) {
                this.mView = LayoutInflater.from(this.jIP.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jIP.ahb(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.amD);
                this.mTextView.setGravity(this.bNZ);
                this.bNX = this.mView.findViewById(R.id.divider_line);
                if (this.bOb) {
                    this.bNX.setVisibility(0);
                } else {
                    this.bNX.setVisibility(8);
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
