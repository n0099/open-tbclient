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
    private TextView dkk;
    private Context dvi;
    private LinearLayout dvk;
    private View dvl;
    private TextView dvm;
    private RadioButton hlC;
    private RadioButton hlD;
    private RadioButton hlE;
    private RadioButton hlF;
    private RadioButton hlG;
    private d lvs;
    private b lvt;
    private e lvu;
    private LinearLayout lvv;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.hlC) {
                h.this.hlD.setChecked(false);
                h.this.hlE.setChecked(false);
                h.this.hlF.setChecked(false);
                h.this.hlG.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.hlD) {
                h.this.hlC.setChecked(true);
                h.this.hlE.setChecked(false);
                h.this.hlF.setChecked(false);
                h.this.hlG.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.hlE) {
                h.this.hlC.setChecked(true);
                h.this.hlD.setChecked(true);
                h.this.hlF.setChecked(false);
                h.this.hlG.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.hlF) {
                h.this.hlC.setChecked(true);
                h.this.hlD.setChecked(true);
                h.this.hlE.setChecked(true);
                h.this.hlG.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.hlG) {
                h.this.hlC.setChecked(true);
                h.this.hlD.setChecked(true);
                h.this.hlE.setChecked(true);
                h.this.hlF.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.lvu != null) {
                h.this.lvu.Bx(h.this.mScore);
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
            this.dvi = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.dvk = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dkk = (TextView) this.view.findViewById(R.id.title);
            this.dvl = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dvm = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.hlC = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.hlC.setOnClickListener(this.mOnClickListener);
            this.hlD = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.hlD.setOnClickListener(this.mOnClickListener);
            this.hlE = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.hlE.setOnClickListener(this.mOnClickListener);
            this.hlF = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.hlF.setOnClickListener(this.mOnClickListener);
            this.hlG = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.hlG.setOnClickListener(this.mOnClickListener);
            this.lvv = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.dvi;
    }

    public ViewGroup getView() {
        return this.dvk;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void uK(boolean z) {
        this.hlC.setEnabled(z);
        this.hlD.setEnabled(z);
        this.hlE.setEnabled(z);
        this.hlF.setEnabled(z);
        this.hlG.setEnabled(z);
    }

    public void EC(int i) {
        switch (i) {
            case 1:
                this.hlC.setChecked(true);
                this.hlD.setChecked(false);
                this.hlE.setChecked(false);
                this.hlF.setChecked(false);
                this.hlG.setChecked(false);
                return;
            case 2:
                this.hlC.setChecked(true);
                this.hlD.setChecked(true);
                this.hlE.setChecked(false);
                this.hlF.setChecked(false);
                this.hlG.setChecked(false);
                return;
            case 3:
                this.hlC.setChecked(true);
                this.hlD.setChecked(true);
                this.hlE.setChecked(true);
                this.hlF.setChecked(false);
                this.hlG.setChecked(false);
                return;
            case 4:
                this.hlC.setChecked(true);
                this.hlD.setChecked(true);
                this.hlE.setChecked(true);
                this.hlF.setChecked(true);
                this.hlG.setChecked(false);
                return;
            case 5:
                this.hlC.setChecked(true);
                this.hlD.setChecked(true);
                this.hlE.setChecked(true);
                this.hlF.setChecked(true);
                this.hlG.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void ED(int i) {
        this.lvv.setVisibility(i);
    }

    public void F(int i, int i2, int i3, int i4) {
        this.lvv.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dkk.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dkk.setTextSize(0, l.getDimens(this.dvi, i));
    }

    public d deK() {
        return this.lvs;
    }

    public void aI(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.dvk.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.dvk.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.lvt = bVar;
    }

    public void a(e eVar) {
        this.lvu = eVar;
    }

    public void EE(int i) {
        this.dvm.setVisibility(i);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dkk, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dkk, (int) R.color.cp_cont_j);
        am.setBackgroundColor(this.dvl, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dvm, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.dvm, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.lvv, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aNj() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dkk.setText(this.titleText);
        } else {
            this.dkk.setVisibility(8);
        }
        if (this.lvt != null) {
            this.dvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.lvt.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View duT;
        private h lvx;
        private c lvy;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int duU = R.drawable.person_more_pop_item_bg_selector;
        private int duV = 17;
        private boolean duX = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lvy != null) {
                    a.this.lvy.onClick();
                }
                if (a.this.lvx != null && a.this.lvx.deK() != null) {
                    a.this.lvx.deK().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.lvx = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.lvy = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            am.setBackgroundColor(this.duT, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.lvx != null && this.lvx.getContext() != null) {
                this.mView = LayoutInflater.from(this.lvx.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.lvx.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.duV);
                this.duT = this.mView.findViewById(R.id.divider_line);
                if (this.duX) {
                    this.duT.setVisibility(0);
                } else {
                    this.duT.setVisibility(8);
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
