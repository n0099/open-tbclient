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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private TextView eFr;
    private Context eTs;
    private LinearLayout eTu;
    private View eTx;
    private TextView eTy;
    private RadioButton jsZ;
    private RadioButton jta;
    private RadioButton jtb;
    private RadioButton jtc;
    private RadioButton jtd;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.jsZ) {
                h.this.jta.setChecked(false);
                h.this.jtb.setChecked(false);
                h.this.jtc.setChecked(false);
                h.this.jtd.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.jta) {
                h.this.jsZ.setChecked(true);
                h.this.jtb.setChecked(false);
                h.this.jtc.setChecked(false);
                h.this.jtd.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.jtb) {
                h.this.jsZ.setChecked(true);
                h.this.jta.setChecked(true);
                h.this.jtc.setChecked(false);
                h.this.jtd.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.jtc) {
                h.this.jsZ.setChecked(true);
                h.this.jta.setChecked(true);
                h.this.jtb.setChecked(true);
                h.this.jtd.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.jtd) {
                h.this.jsZ.setChecked(true);
                h.this.jta.setChecked(true);
                h.this.jtb.setChecked(true);
                h.this.jtc.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.nPW != null) {
                h.this.nPW.Hr(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d nPU;
    private b nPV;
    private e nPW;
    private LinearLayout nPX;
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
        void dR(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void Hr(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eTs = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eTu = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eFr = (TextView) this.view.findViewById(R.id.title);
            this.eTx = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eTy = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.jsZ = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.jsZ.setOnClickListener(this.mOnClickListener);
            this.jta = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.jta.setOnClickListener(this.mOnClickListener);
            this.jtb = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.jtb.setOnClickListener(this.mOnClickListener);
            this.jtc = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.jtc.setOnClickListener(this.mOnClickListener);
            this.jtd = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.jtd.setOnClickListener(this.mOnClickListener);
            this.nPX = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eTs;
    }

    public ViewGroup getView() {
        return this.eTu;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void yT(boolean z) {
        this.jsZ.setEnabled(z);
        this.jta.setEnabled(z);
        this.jtb.setEnabled(z);
        this.jtc.setEnabled(z);
        this.jtd.setEnabled(z);
    }

    public void KB(int i) {
        switch (i) {
            case 1:
                this.jsZ.setChecked(true);
                this.jta.setChecked(false);
                this.jtb.setChecked(false);
                this.jtc.setChecked(false);
                this.jtd.setChecked(false);
                return;
            case 2:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(false);
                this.jtc.setChecked(false);
                this.jtd.setChecked(false);
                return;
            case 3:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(true);
                this.jtc.setChecked(false);
                this.jtd.setChecked(false);
                return;
            case 4:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(true);
                this.jtc.setChecked(true);
                this.jtd.setChecked(false);
                return;
            case 5:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(true);
                this.jtc.setChecked(true);
                this.jtd.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void KC(int i) {
        this.nPX.setVisibility(i);
    }

    public void N(int i, int i2, int i3, int i4) {
        this.nPX.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.eFr.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.eFr.setTextSize(0, l.getDimens(this.eTs, i));
    }

    public d dTR() {
        return this.nPU;
    }

    public void bB(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eTu.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eTu.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nPV = bVar;
    }

    public void a(e eVar) {
        this.nPW = eVar;
    }

    public void KD(int i) {
        this.eTy.setVisibility(i);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.eFr, R.color.CAM_X0201);
        ao.setViewTextColor(this.eFr, R.color.CAM_X0107);
        ao.setBackgroundColor(this.eTx, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eTy, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.eTy, R.color.CAM_X0106);
        ao.setBackgroundResource(this.nPX, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bqy() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eFr.setText(this.titleText);
        } else {
            this.eFr.setVisibility(8);
        }
        if (this.nPV != null) {
            this.eTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.nPV.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eSX;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h nPZ;
        private c nQa;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eSY = R.drawable.person_more_pop_item_bg_selector;
        private int eSZ = 17;
        private boolean eTb = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nQa != null) {
                    a.this.nQa.onClick();
                }
                if (a.this.nPZ != null && a.this.nPZ.dTR() != null) {
                    a.this.nPZ.dTR().dR(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.nPZ = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nQa = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ao.setViewTextColor(this.mTextView, R.color.CAM_X0106);
            ao.setBackgroundColor(this.eSX, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nPZ != null && this.nPZ.getContext() != null) {
                this.mView = LayoutInflater.from(this.nPZ.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nPZ.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eSZ);
                this.eSX = this.mView.findViewById(R.id.divider_line);
                if (this.eTb) {
                    this.eSX.setVisibility(0);
                } else {
                    this.eSX.setVisibility(8);
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
