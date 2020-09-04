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
    private TextView dSD;
    private Context efT;
    private LinearLayout efV;
    private View efW;
    private TextView efX;
    private RadioButton iiF;
    private RadioButton iiG;
    private RadioButton iiH;
    private RadioButton iiI;
    private RadioButton iiJ;
    private List<a> mItems;
    private d mJT;
    private b mJU;
    private e mJV;
    private LinearLayout mJW;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iiF) {
                h.this.iiG.setChecked(false);
                h.this.iiH.setChecked(false);
                h.this.iiI.setChecked(false);
                h.this.iiJ.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.iiG) {
                h.this.iiF.setChecked(true);
                h.this.iiH.setChecked(false);
                h.this.iiI.setChecked(false);
                h.this.iiJ.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.iiH) {
                h.this.iiF.setChecked(true);
                h.this.iiG.setChecked(true);
                h.this.iiI.setChecked(false);
                h.this.iiJ.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.iiI) {
                h.this.iiF.setChecked(true);
                h.this.iiG.setChecked(true);
                h.this.iiH.setChecked(true);
                h.this.iiJ.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.iiJ) {
                h.this.iiF.setChecked(true);
                h.this.iiG.setChecked(true);
                h.this.iiH.setChecked(true);
                h.this.iiI.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.mJV != null) {
                h.this.mJV.Gc(h.this.mScore);
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
        void Gc(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.efT = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.efV = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dSD = (TextView) this.view.findViewById(R.id.title);
            this.efW = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.efX = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.iiF = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.iiF.setOnClickListener(this.mOnClickListener);
            this.iiG = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.iiG.setOnClickListener(this.mOnClickListener);
            this.iiH = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.iiH.setOnClickListener(this.mOnClickListener);
            this.iiI = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.iiI.setOnClickListener(this.mOnClickListener);
            this.iiJ = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.iiJ.setOnClickListener(this.mOnClickListener);
            this.mJW = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.efT;
    }

    public ViewGroup getView() {
        return this.efV;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void wV(boolean z) {
        this.iiF.setEnabled(z);
        this.iiG.setEnabled(z);
        this.iiH.setEnabled(z);
        this.iiI.setEnabled(z);
        this.iiJ.setEnabled(z);
    }

    public void Jl(int i) {
        switch (i) {
            case 1:
                this.iiF.setChecked(true);
                this.iiG.setChecked(false);
                this.iiH.setChecked(false);
                this.iiI.setChecked(false);
                this.iiJ.setChecked(false);
                return;
            case 2:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(false);
                this.iiI.setChecked(false);
                this.iiJ.setChecked(false);
                return;
            case 3:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(true);
                this.iiI.setChecked(false);
                this.iiJ.setChecked(false);
                return;
            case 4:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(true);
                this.iiI.setChecked(true);
                this.iiJ.setChecked(false);
                return;
            case 5:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(true);
                this.iiI.setChecked(true);
                this.iiJ.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Jm(int i) {
        this.mJW.setVisibility(i);
    }

    public void H(int i, int i2, int i3, int i4) {
        this.mJW.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dSD.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dSD.setTextSize(0, l.getDimens(this.efT, i));
    }

    public d dFv() {
        return this.mJT;
    }

    public void aT(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.efV.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.efV.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mJU = bVar;
    }

    public void a(e eVar) {
        this.mJV = eVar;
    }

    public void Jn(int i) {
        this.efX.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.dSD, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dSD, R.color.cp_cont_j);
        ap.setBackgroundColor(this.efW, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.efX, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.efX, R.color.cp_cont_f);
        ap.setBackgroundResource(this.mJW, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bhw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dSD.setText(this.titleText);
        } else {
            this.dSD.setVisibility(8);
        }
        if (this.mJU != null) {
            this.efX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.mJU.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View efE;
        private h mJY;
        private c mJZ;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int efF = R.drawable.person_more_pop_item_bg_selector;
        private int efG = 17;
        private boolean efI = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mJZ != null) {
                    a.this.mJZ.onClick();
                }
                if (a.this.mJY != null && a.this.mJY.dFv() != null) {
                    a.this.mJY.dFv().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.mJY = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.mJZ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ap.setBackgroundColor(this.efE, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mJY != null && this.mJY.getContext() != null) {
                this.mView = LayoutInflater.from(this.mJY.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mJY.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.efG);
                this.efE = this.mView.findViewById(R.id.divider_line);
                if (this.efI) {
                    this.efE.setVisibility(0);
                } else {
                    this.efE.setVisibility(8);
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
