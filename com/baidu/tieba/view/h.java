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
    private Context eCP;
    private LinearLayout eCR;
    private View eCS;
    private TextView eCT;
    private TextView epn;
    private RadioButton iQW;
    private RadioButton iQX;
    private RadioButton iQY;
    private RadioButton iQZ;
    private RadioButton iRa;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iQW) {
                h.this.iQX.setChecked(false);
                h.this.iQY.setChecked(false);
                h.this.iQZ.setChecked(false);
                h.this.iRa.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.iQX) {
                h.this.iQW.setChecked(true);
                h.this.iQY.setChecked(false);
                h.this.iQZ.setChecked(false);
                h.this.iRa.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.iQY) {
                h.this.iQW.setChecked(true);
                h.this.iQX.setChecked(true);
                h.this.iQZ.setChecked(false);
                h.this.iRa.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.iQZ) {
                h.this.iQW.setChecked(true);
                h.this.iQX.setChecked(true);
                h.this.iQY.setChecked(true);
                h.this.iRa.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.iRa) {
                h.this.iQW.setChecked(true);
                h.this.iQX.setChecked(true);
                h.this.iQY.setChecked(true);
                h.this.iQZ.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.nvM != null) {
                h.this.nvM.HC(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d nvK;
    private b nvL;
    private e nvM;
    private LinearLayout nvN;
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
        void HC(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eCP = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eCR = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.epn = (TextView) this.view.findViewById(R.id.title);
            this.eCS = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eCT = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.iQW = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.iQW.setOnClickListener(this.mOnClickListener);
            this.iQX = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.iQX.setOnClickListener(this.mOnClickListener);
            this.iQY = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.iQY.setOnClickListener(this.mOnClickListener);
            this.iQZ = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.iQZ.setOnClickListener(this.mOnClickListener);
            this.iRa = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.iRa.setOnClickListener(this.mOnClickListener);
            this.nvN = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eCP;
    }

    public ViewGroup getView() {
        return this.eCR;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void yc(boolean z) {
        this.iQW.setEnabled(z);
        this.iQX.setEnabled(z);
        this.iQY.setEnabled(z);
        this.iQZ.setEnabled(z);
        this.iRa.setEnabled(z);
    }

    public void KN(int i) {
        switch (i) {
            case 1:
                this.iQW.setChecked(true);
                this.iQX.setChecked(false);
                this.iQY.setChecked(false);
                this.iQZ.setChecked(false);
                this.iRa.setChecked(false);
                return;
            case 2:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(false);
                this.iQZ.setChecked(false);
                this.iRa.setChecked(false);
                return;
            case 3:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(true);
                this.iQZ.setChecked(false);
                this.iRa.setChecked(false);
                return;
            case 4:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(true);
                this.iQZ.setChecked(true);
                this.iRa.setChecked(false);
                return;
            case 5:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(true);
                this.iQZ.setChecked(true);
                this.iRa.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void KO(int i) {
        this.nvN.setVisibility(i);
    }

    public void I(int i, int i2, int i3, int i4) {
        this.nvN.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.epn.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.epn.setTextSize(0, l.getDimens(this.eCP, i));
    }

    public d dQj() {
        return this.nvK;
    }

    public void bk(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eCR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eCR.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nvL = bVar;
    }

    public void a(e eVar) {
        this.nvM = eVar;
    }

    public void KP(int i) {
        this.eCT.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.epn, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.epn, R.color.cp_cont_j);
        ap.setBackgroundColor(this.eCS, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eCT, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eCT, R.color.cp_cont_f);
        ap.setBackgroundResource(this.nvN, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bmS() {
        if (!StringUtils.isNull(this.titleText)) {
            this.epn.setText(this.titleText);
        } else {
            this.epn.setVisibility(8);
        }
        if (this.nvL != null) {
            this.eCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.nvL.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eCA;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h nvP;
        private c nvQ;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eCB = R.drawable.person_more_pop_item_bg_selector;
        private int eCC = 17;
        private boolean eCE = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nvQ != null) {
                    a.this.nvQ.onClick();
                }
                if (a.this.nvP != null && a.this.nvP.dQj() != null) {
                    a.this.nvP.dQj().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.nvP = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nvQ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ap.setBackgroundColor(this.eCA, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.nvP != null && this.nvP.getContext() != null) {
                this.mView = LayoutInflater.from(this.nvP.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nvP.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eCC);
                this.eCA = this.mView.findViewById(R.id.divider_line);
                if (this.eCE) {
                    this.eCA.setVisibility(0);
                } else {
                    this.eCA.setVisibility(8);
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
