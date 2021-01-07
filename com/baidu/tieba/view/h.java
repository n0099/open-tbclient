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
    private TextView eKc;
    private Context eYd;
    private LinearLayout eYf;
    private View eYi;
    private TextView eYj;
    private RadioButton jxF;
    private RadioButton jxG;
    private RadioButton jxH;
    private RadioButton jxI;
    private RadioButton jxJ;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.jxF) {
                h.this.jxG.setChecked(false);
                h.this.jxH.setChecked(false);
                h.this.jxI.setChecked(false);
                h.this.jxJ.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.jxG) {
                h.this.jxF.setChecked(true);
                h.this.jxH.setChecked(false);
                h.this.jxI.setChecked(false);
                h.this.jxJ.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.jxH) {
                h.this.jxF.setChecked(true);
                h.this.jxG.setChecked(true);
                h.this.jxI.setChecked(false);
                h.this.jxJ.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.jxI) {
                h.this.jxF.setChecked(true);
                h.this.jxG.setChecked(true);
                h.this.jxH.setChecked(true);
                h.this.jxJ.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.jxJ) {
                h.this.jxF.setChecked(true);
                h.this.jxG.setChecked(true);
                h.this.jxH.setChecked(true);
                h.this.jxI.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.nUB != null) {
                h.this.nUB.IY(h.this.mScore);
            }
        }
    };
    private int mScore;
    private b nUA;
    private e nUB;
    private LinearLayout nUC;
    private d nUz;
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
        void fx(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void IY(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eYd = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eYf = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eKc = (TextView) this.view.findViewById(R.id.title);
            this.eYi = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eYj = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.jxF = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.jxF.setOnClickListener(this.mOnClickListener);
            this.jxG = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.jxG.setOnClickListener(this.mOnClickListener);
            this.jxH = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.jxH.setOnClickListener(this.mOnClickListener);
            this.jxI = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.jxI.setOnClickListener(this.mOnClickListener);
            this.jxJ = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.jxJ.setOnClickListener(this.mOnClickListener);
            this.nUC = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eYd;
    }

    public ViewGroup getView() {
        return this.eYf;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void yX(boolean z) {
        this.jxF.setEnabled(z);
        this.jxG.setEnabled(z);
        this.jxH.setEnabled(z);
        this.jxI.setEnabled(z);
        this.jxJ.setEnabled(z);
    }

    public void Mi(int i) {
        switch (i) {
            case 1:
                this.jxF.setChecked(true);
                this.jxG.setChecked(false);
                this.jxH.setChecked(false);
                this.jxI.setChecked(false);
                this.jxJ.setChecked(false);
                return;
            case 2:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(false);
                this.jxI.setChecked(false);
                this.jxJ.setChecked(false);
                return;
            case 3:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(true);
                this.jxI.setChecked(false);
                this.jxJ.setChecked(false);
                return;
            case 4:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(true);
                this.jxI.setChecked(true);
                this.jxJ.setChecked(false);
                return;
            case 5:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(true);
                this.jxI.setChecked(true);
                this.jxJ.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Mj(int i) {
        this.nUC.setVisibility(i);
    }

    public void N(int i, int i2, int i3, int i4) {
        this.nUC.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.eKc.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.eKc.setTextSize(0, l.getDimens(this.eYd, i));
    }

    public d dXJ() {
        return this.nUz;
    }

    public void bB(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eYf.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eYf.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nUA = bVar;
    }

    public void a(e eVar) {
        this.nUB = eVar;
    }

    public void Mk(int i) {
        this.eYj.setVisibility(i);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.eKc, R.color.CAM_X0201);
        ao.setViewTextColor(this.eKc, R.color.CAM_X0107);
        ao.setBackgroundColor(this.eYi, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eYj, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.eYj, R.color.CAM_X0106);
        ao.setBackgroundResource(this.nUC, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bus() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eKc.setText(this.titleText);
        } else {
            this.eKc.setVisibility(8);
        }
        if (this.nUA != null) {
            this.eYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.nUA.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eXI;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h nUE;
        private c nUF;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eXJ = R.drawable.person_more_pop_item_bg_selector;
        private int eXK = 17;
        private boolean eXM = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nUF != null) {
                    a.this.nUF.onClick();
                }
                if (a.this.nUE != null && a.this.nUE.dXJ() != null) {
                    a.this.nUE.dXJ().fx(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.nUE = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nUF = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ao.setViewTextColor(this.mTextView, R.color.CAM_X0106);
            ao.setBackgroundColor(this.eXI, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nUE != null && this.nUE.getContext() != null) {
                this.mView = LayoutInflater.from(this.nUE.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nUE.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eXK);
                this.eXI = this.mView.findViewById(R.id.divider_line);
                if (this.eXM) {
                    this.eXI.setVisibility(0);
                } else {
                    this.eXI.setVisibility(8);
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
