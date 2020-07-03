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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private TextView dDu;
    private Context dPX;
    private LinearLayout dPZ;
    private View dQa;
    private TextView dQb;
    private RadioButton hOr;
    private RadioButton hOs;
    private RadioButton hOt;
    private RadioButton hOu;
    private RadioButton hOv;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.hOr) {
                h.this.hOs.setChecked(false);
                h.this.hOt.setChecked(false);
                h.this.hOu.setChecked(false);
                h.this.hOv.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.hOs) {
                h.this.hOr.setChecked(true);
                h.this.hOt.setChecked(false);
                h.this.hOu.setChecked(false);
                h.this.hOv.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.hOt) {
                h.this.hOr.setChecked(true);
                h.this.hOs.setChecked(true);
                h.this.hOu.setChecked(false);
                h.this.hOv.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.hOu) {
                h.this.hOr.setChecked(true);
                h.this.hOs.setChecked(true);
                h.this.hOt.setChecked(true);
                h.this.hOv.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.hOv) {
                h.this.hOr.setChecked(true);
                h.this.hOs.setChecked(true);
                h.this.hOt.setChecked(true);
                h.this.hOu.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.mjo != null) {
                h.this.mjo.Dl(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d mjm;
    private b mjn;
    private e mjo;
    private LinearLayout mjp;
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
        void Dl(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.dPX = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.dPZ = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dDu = (TextView) this.view.findViewById(R.id.title);
            this.dQa = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dQb = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.hOr = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.hOr.setOnClickListener(this.mOnClickListener);
            this.hOs = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.hOs.setOnClickListener(this.mOnClickListener);
            this.hOt = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.hOt.setOnClickListener(this.mOnClickListener);
            this.hOu = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.hOu.setOnClickListener(this.mOnClickListener);
            this.hOv = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.hOv.setOnClickListener(this.mOnClickListener);
            this.mjp = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.dPX;
    }

    public ViewGroup getView() {
        return this.dPZ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void vA(boolean z) {
        this.hOr.setEnabled(z);
        this.hOs.setEnabled(z);
        this.hOt.setEnabled(z);
        this.hOu.setEnabled(z);
        this.hOv.setEnabled(z);
    }

    public void Gt(int i) {
        switch (i) {
            case 1:
                this.hOr.setChecked(true);
                this.hOs.setChecked(false);
                this.hOt.setChecked(false);
                this.hOu.setChecked(false);
                this.hOv.setChecked(false);
                return;
            case 2:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(false);
                this.hOu.setChecked(false);
                this.hOv.setChecked(false);
                return;
            case 3:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(true);
                this.hOu.setChecked(false);
                this.hOv.setChecked(false);
                return;
            case 4:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(true);
                this.hOu.setChecked(true);
                this.hOv.setChecked(false);
                return;
            case 5:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(true);
                this.hOu.setChecked(true);
                this.hOv.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Gu(int i) {
        this.mjp.setVisibility(i);
    }

    public void G(int i, int i2, int i3, int i4) {
        this.mjp.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dDu.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dDu.setTextSize(0, l.getDimens(this.dPX, i));
    }

    public d dqA() {
        return this.mjm;
    }

    public void aL(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.dPZ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.dPZ.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mjn = bVar;
    }

    public void a(e eVar) {
        this.mjo = eVar;
    }

    public void Gv(int i) {
        this.dQb.setVisibility(i);
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.dDu, R.color.cp_bg_line_d);
        an.setViewTextColor(this.dDu, (int) R.color.cp_cont_j);
        an.setBackgroundColor(this.dQa, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.dQb, R.drawable.bg_bottom_up_list_dialog_item);
        an.setViewTextColor(this.dQb, (int) R.color.cp_cont_f);
        an.setBackgroundResource(this.mjp, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View aVb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dDu.setText(this.titleText);
        } else {
            this.dDu.setVisibility(8);
        }
        if (this.mjn != null) {
            this.dQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.mjn.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View dPI;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h mjr;
        private c mjs;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int dPJ = R.drawable.person_more_pop_item_bg_selector;
        private int dPK = 17;
        private boolean dPM = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mjs != null) {
                    a.this.mjs.onClick();
                }
                if (a.this.mjr != null && a.this.mjr.dqA() != null) {
                    a.this.mjr.dqA().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.mjr = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.mjs = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            an.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            an.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            an.setBackgroundColor(this.dPI, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mjr != null && this.mjr.getContext() != null) {
                this.mView = LayoutInflater.from(this.mjr.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mjr.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.dPK);
                this.dPI = this.mView.findViewById(R.id.divider_line);
                if (this.dPM) {
                    this.dPI.setVisibility(0);
                } else {
                    this.dPI.setVisibility(8);
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
