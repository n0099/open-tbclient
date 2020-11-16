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
    private Context eGZ;
    private LinearLayout eHb;
    private View eHd;
    private TextView eHe;
    private TextView etx;
    private RadioButton iXF;
    private RadioButton iXG;
    private RadioButton iXH;
    private RadioButton iXI;
    private RadioButton iXJ;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iXF) {
                h.this.iXG.setChecked(false);
                h.this.iXH.setChecked(false);
                h.this.iXI.setChecked(false);
                h.this.iXJ.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.iXG) {
                h.this.iXF.setChecked(true);
                h.this.iXH.setChecked(false);
                h.this.iXI.setChecked(false);
                h.this.iXJ.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.iXH) {
                h.this.iXF.setChecked(true);
                h.this.iXG.setChecked(true);
                h.this.iXI.setChecked(false);
                h.this.iXJ.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.iXI) {
                h.this.iXF.setChecked(true);
                h.this.iXG.setChecked(true);
                h.this.iXH.setChecked(true);
                h.this.iXJ.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.iXJ) {
                h.this.iXF.setChecked(true);
                h.this.iXG.setChecked(true);
                h.this.iXH.setChecked(true);
                h.this.iXI.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.nDd != null) {
                h.this.nDd.In(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d nDb;
    private b nDc;
    private e nDd;
    private LinearLayout nDe;
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
        void In(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eGZ = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eHb = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.etx = (TextView) this.view.findViewById(R.id.title);
            this.eHd = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eHe = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.iXF = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.iXF.setOnClickListener(this.mOnClickListener);
            this.iXG = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.iXG.setOnClickListener(this.mOnClickListener);
            this.iXH = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.iXH.setOnClickListener(this.mOnClickListener);
            this.iXI = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.iXI.setOnClickListener(this.mOnClickListener);
            this.iXJ = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.iXJ.setOnClickListener(this.mOnClickListener);
            this.nDe = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eGZ;
    }

    public ViewGroup getView() {
        return this.eHb;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void ys(boolean z) {
        this.iXF.setEnabled(z);
        this.iXG.setEnabled(z);
        this.iXH.setEnabled(z);
        this.iXI.setEnabled(z);
        this.iXJ.setEnabled(z);
    }

    public void LD(int i) {
        switch (i) {
            case 1:
                this.iXF.setChecked(true);
                this.iXG.setChecked(false);
                this.iXH.setChecked(false);
                this.iXI.setChecked(false);
                this.iXJ.setChecked(false);
                return;
            case 2:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(false);
                this.iXI.setChecked(false);
                this.iXJ.setChecked(false);
                return;
            case 3:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(true);
                this.iXI.setChecked(false);
                this.iXJ.setChecked(false);
                return;
            case 4:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(true);
                this.iXI.setChecked(true);
                this.iXJ.setChecked(false);
                return;
            case 5:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(true);
                this.iXI.setChecked(true);
                this.iXJ.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void LE(int i) {
        this.nDe.setVisibility(i);
    }

    public void J(int i, int i2, int i3, int i4) {
        this.nDe.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.etx.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.etx.setTextSize(0, l.getDimens(this.eGZ, i));
    }

    public d dSK() {
        return this.nDb;
    }

    public void br(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eHb.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eHb.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nDc = bVar;
    }

    public void a(e eVar) {
        this.nDd = eVar;
    }

    public void LF(int i) {
        this.eHe.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.etx, R.color.CAM_X0201);
        ap.setViewTextColor(this.etx, R.color.CAM_X0107);
        ap.setBackgroundColor(this.eHd, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eHe, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eHe, R.color.CAM_X0106);
        ap.setBackgroundResource(this.nDe, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bow() {
        if (!StringUtils.isNull(this.titleText)) {
            this.etx.setText(this.titleText);
        } else {
            this.etx.setVisibility(8);
        }
        if (this.nDc != null) {
            this.eHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.nDc.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eGI;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h nDg;
        private c nDh;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eGJ = R.drawable.person_more_pop_item_bg_selector;
        private int eGK = 17;
        private boolean eGM = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nDh != null) {
                    a.this.nDh.onClick();
                }
                if (a.this.nDg != null && a.this.nDg.dSK() != null) {
                    a.this.nDg.dSK().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.nDg = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nDh = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0106);
            ap.setBackgroundColor(this.eGI, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nDg != null && this.nDg.getContext() != null) {
                this.mView = LayoutInflater.from(this.nDg.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nDg.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eGK);
                this.eGI = this.mView.findViewById(R.id.divider_line);
                if (this.eGM) {
                    this.eGI.setVisibility(0);
                } else {
                    this.eGI.setVisibility(8);
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
