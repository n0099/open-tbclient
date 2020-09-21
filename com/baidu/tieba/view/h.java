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
    private TextView dUN;
    private Context eii;
    private LinearLayout eik;
    private View eil;
    private TextView eim;
    private RadioButton ipH;
    private RadioButton ipI;
    private RadioButton ipJ;
    private RadioButton ipK;
    private RadioButton ipL;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.ipH) {
                h.this.ipI.setChecked(false);
                h.this.ipJ.setChecked(false);
                h.this.ipK.setChecked(false);
                h.this.ipL.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.ipI) {
                h.this.ipH.setChecked(true);
                h.this.ipJ.setChecked(false);
                h.this.ipK.setChecked(false);
                h.this.ipL.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.ipJ) {
                h.this.ipH.setChecked(true);
                h.this.ipI.setChecked(true);
                h.this.ipK.setChecked(false);
                h.this.ipL.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.ipK) {
                h.this.ipH.setChecked(true);
                h.this.ipI.setChecked(true);
                h.this.ipJ.setChecked(true);
                h.this.ipL.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.ipL) {
                h.this.ipH.setChecked(true);
                h.this.ipI.setChecked(true);
                h.this.ipJ.setChecked(true);
                h.this.ipK.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.mTL != null) {
                h.this.mTL.GD(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d mTJ;
    private b mTK;
    private e mTL;
    private LinearLayout mTM;
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
        void GD(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eii = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eik = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dUN = (TextView) this.view.findViewById(R.id.title);
            this.eil = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eim = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.ipH = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.ipH.setOnClickListener(this.mOnClickListener);
            this.ipI = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.ipI.setOnClickListener(this.mOnClickListener);
            this.ipJ = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.ipJ.setOnClickListener(this.mOnClickListener);
            this.ipK = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.ipK.setOnClickListener(this.mOnClickListener);
            this.ipL = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.ipL.setOnClickListener(this.mOnClickListener);
            this.mTM = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eii;
    }

    public ViewGroup getView() {
        return this.eik;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void xe(boolean z) {
        this.ipH.setEnabled(z);
        this.ipI.setEnabled(z);
        this.ipJ.setEnabled(z);
        this.ipK.setEnabled(z);
        this.ipL.setEnabled(z);
    }

    public void JP(int i) {
        switch (i) {
            case 1:
                this.ipH.setChecked(true);
                this.ipI.setChecked(false);
                this.ipJ.setChecked(false);
                this.ipK.setChecked(false);
                this.ipL.setChecked(false);
                return;
            case 2:
                this.ipH.setChecked(true);
                this.ipI.setChecked(true);
                this.ipJ.setChecked(false);
                this.ipK.setChecked(false);
                this.ipL.setChecked(false);
                return;
            case 3:
                this.ipH.setChecked(true);
                this.ipI.setChecked(true);
                this.ipJ.setChecked(true);
                this.ipK.setChecked(false);
                this.ipL.setChecked(false);
                return;
            case 4:
                this.ipH.setChecked(true);
                this.ipI.setChecked(true);
                this.ipJ.setChecked(true);
                this.ipK.setChecked(true);
                this.ipL.setChecked(false);
                return;
            case 5:
                this.ipH.setChecked(true);
                this.ipI.setChecked(true);
                this.ipJ.setChecked(true);
                this.ipK.setChecked(true);
                this.ipL.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void JQ(int i) {
        this.mTM.setVisibility(i);
    }

    public void H(int i, int i2, int i3, int i4) {
        this.mTM.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.dUN.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.dUN.setTextSize(0, l.getDimens(this.eii, i));
    }

    public d dJp() {
        return this.mTJ;
    }

    public void aX(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eik.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eik.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mTK = bVar;
    }

    public void a(e eVar) {
        this.mTL = eVar;
    }

    public void JR(int i) {
        this.eim.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.dUN, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dUN, R.color.cp_cont_j);
        ap.setBackgroundColor(this.eil, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eim, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eim, R.color.cp_cont_f);
        ap.setBackgroundResource(this.mTM, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View biq() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dUN.setText(this.titleText);
        } else {
            this.dUN.setVisibility(8);
        }
        if (this.mTK != null) {
            this.eim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.mTK.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View ehT;
        private h mTO;
        private c mTP;
        private String mText;
        private TextView mTextView;
        private View mView;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int ehU = R.drawable.person_more_pop_item_bg_selector;
        private int ehV = 17;
        private boolean ehX = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mTP != null) {
                    a.this.mTP.onClick();
                }
                if (a.this.mTO != null && a.this.mTO.dJp() != null) {
                    a.this.mTO.dJp().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.mTO = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.mTP = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ap.setBackgroundColor(this.ehT, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mTO != null && this.mTO.getContext() != null) {
                this.mView = LayoutInflater.from(this.mTO.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mTO.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.ehV);
                this.ehT = this.mView.findViewById(R.id.divider_line);
                if (this.ehX) {
                    this.ehT.setVisibility(0);
                } else {
                    this.ehT.setVisibility(8);
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
