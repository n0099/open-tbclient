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
public class h {
    private TextView dko;
    private Context dvm;
    private LinearLayout dvo;
    private View dvp;
    private TextView dvq;
    private RadioButton hlI;
    private RadioButton hlJ;
    private RadioButton hlK;
    private RadioButton hlL;
    private RadioButton hlM;
    private d lvw;
    private b lvx;
    private e lvy;
    private LinearLayout lvz;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.hlI) {
                h.this.hlJ.setChecked(false);
                h.this.hlK.setChecked(false);
                h.this.hlL.setChecked(false);
                h.this.hlM.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.hlJ) {
                h.this.hlI.setChecked(true);
                h.this.hlK.setChecked(false);
                h.this.hlL.setChecked(false);
                h.this.hlM.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.hlK) {
                h.this.hlI.setChecked(true);
                h.this.hlJ.setChecked(true);
                h.this.hlL.setChecked(false);
                h.this.hlM.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.hlL) {
                h.this.hlI.setChecked(true);
                h.this.hlJ.setChecked(true);
                h.this.hlK.setChecked(true);
                h.this.hlM.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.hlM) {
                h.this.hlI.setChecked(true);
                h.this.hlJ.setChecked(true);
                h.this.hlK.setChecked(true);
                h.this.hlL.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.lvy != null) {
                h.this.lvy.Bx(h.this.mScore);
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
        void Bx(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.dvm = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.dvo = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dko = (TextView) this.view.findViewById(R.id.title);
            this.dvp = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dvq = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.hlI = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.hlI.setOnClickListener(this.mOnClickListener);
            this.hlJ = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.hlJ.setOnClickListener(this.mOnClickListener);
            this.hlK = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.hlK.setOnClickListener(this.mOnClickListener);
            this.hlL = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.hlL.setOnClickListener(this.mOnClickListener);
            this.hlM = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.hlM.setOnClickListener(this.mOnClickListener);
            this.lvz = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.dvm;
    }

    public ViewGroup getView() {
        return this.dvo;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void uK(boolean z) {
        this.hlI.setEnabled(z);
        this.hlJ.setEnabled(z);
        this.hlK.setEnabled(z);
        this.hlL.setEnabled(z);
        this.hlM.setEnabled(z);
    }

    public void EC(int i) {
        switch (i) {
            case 1:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(false);
                this.hlK.setChecked(false);
                this.hlL.setChecked(false);
                this.hlM.setChecked(false);
                return;
            case 2:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(false);
                this.hlL.setChecked(false);
                this.hlM.setChecked(false);
                return;
            case 3:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(true);
                this.hlL.setChecked(false);
                this.hlM.setChecked(false);
                return;
            case 4:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(true);
                this.hlL.setChecked(true);
                this.hlM.setChecked(false);
                return;
            case 5:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(true);
                this.hlL.setChecked(true);
                this.hlM.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void ED(int i) {
        this.lvz.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.lvz.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dko.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dko.setTextSize(0, l.getDimens(this.dvm, i));
    }

    public d deH() {
        return this.lvw;
    }

    public void aI(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.dvo.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.dvo.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.lvx = bVar;
    }

    public void a(e eVar) {
        this.lvy = eVar;
    }

    public void EE(int i) {
        this.dvq.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dko, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dko, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.dvp, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dvq, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.dvq, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.lvz, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aNh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dko.setText(this.titleText);
        } else {
            this.dko.setVisibility(8);
        }
        if (this.lvx != null) {
            this.dvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.lvx.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View duX;
        private h lvB;
        private c lvC;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int duY = R.drawable.person_more_pop_item_bg_selector;
        private int duZ = 17;
        private boolean dvb = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lvC != null) {
                    a.this.lvC.onClick();
                }
                if (a.this.lvB != null && a.this.lvB.deH() != null) {
                    a.this.lvB.deH().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.lvB = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.lvC = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.duX, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.lvB != null && this.lvB.getContext() != null) {
                this.mView = LayoutInflater.from(this.lvB.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.lvB.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.duZ);
                this.duX = this.mView.findViewById(R.id.divider_line);
                if (this.dvb) {
                    this.duX.setVisibility(0);
                } else {
                    this.duX.setVisibility(8);
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
