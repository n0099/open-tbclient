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
    private TextView eHx;
    private Context eVI;
    private LinearLayout eVK;
    private View eVN;
    private TextView eVO;
    private RadioButton jyF;
    private RadioButton jyG;
    private RadioButton jyH;
    private RadioButton jyI;
    private RadioButton jyJ;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.jyF) {
                h.this.jyG.setChecked(false);
                h.this.jyH.setChecked(false);
                h.this.jyI.setChecked(false);
                h.this.jyJ.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.jyG) {
                h.this.jyF.setChecked(true);
                h.this.jyH.setChecked(false);
                h.this.jyI.setChecked(false);
                h.this.jyJ.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.jyH) {
                h.this.jyF.setChecked(true);
                h.this.jyG.setChecked(true);
                h.this.jyI.setChecked(false);
                h.this.jyJ.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.jyI) {
                h.this.jyF.setChecked(true);
                h.this.jyG.setChecked(true);
                h.this.jyH.setChecked(true);
                h.this.jyJ.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.jyJ) {
                h.this.jyF.setChecked(true);
                h.this.jyG.setChecked(true);
                h.this.jyH.setChecked(true);
                h.this.jyI.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.oab != null) {
                h.this.oab.HJ(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d nZZ;
    private b oaa;
    private e oab;
    private LinearLayout oac;
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
        void dV(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void HJ(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.eVI = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eVK = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eHx = (TextView) this.view.findViewById(R.id.title);
            this.eVN = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eVO = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.jyF = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.jyF.setOnClickListener(this.mOnClickListener);
            this.jyG = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.jyG.setOnClickListener(this.mOnClickListener);
            this.jyH = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.jyH.setOnClickListener(this.mOnClickListener);
            this.jyI = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.jyI.setOnClickListener(this.mOnClickListener);
            this.jyJ = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.jyJ.setOnClickListener(this.mOnClickListener);
            this.oac = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.eVI;
    }

    public ViewGroup getView() {
        return this.eVK;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void zp(boolean z) {
        this.jyF.setEnabled(z);
        this.jyG.setEnabled(z);
        this.jyH.setEnabled(z);
        this.jyI.setEnabled(z);
        this.jyJ.setEnabled(z);
    }

    public void KW(int i) {
        switch (i) {
            case 1:
                this.jyF.setChecked(true);
                this.jyG.setChecked(false);
                this.jyH.setChecked(false);
                this.jyI.setChecked(false);
                this.jyJ.setChecked(false);
                return;
            case 2:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(false);
                this.jyI.setChecked(false);
                this.jyJ.setChecked(false);
                return;
            case 3:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(true);
                this.jyI.setChecked(false);
                this.jyJ.setChecked(false);
                return;
            case 4:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(true);
                this.jyI.setChecked(true);
                this.jyJ.setChecked(false);
                return;
            case 5:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(true);
                this.jyI.setChecked(true);
                this.jyJ.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void KX(int i) {
        this.oac.setVisibility(i);
    }

    public void L(int i, int i2, int i3, int i4) {
        this.oac.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.eHx.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.eHx.setTextSize(0, l.getDimens(this.eVI, i));
    }

    public d dWf() {
        return this.nZZ;
    }

    public void bw(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eVK.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eVK.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.oaa = bVar;
    }

    public void a(e eVar) {
        this.oab = eVar;
    }

    public void KY(int i) {
        this.eVO.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eHx, R.color.CAM_X0201);
        ap.setViewTextColor(this.eHx, R.color.CAM_X0107);
        ap.setBackgroundColor(this.eVN, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eVO, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eVO, R.color.CAM_X0106);
        ap.setBackgroundResource(this.oac, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bqR() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eHx.setText(this.titleText);
        } else {
            this.eHx.setVisibility(8);
        }
        if (this.oaa != null) {
            this.eVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.oaa.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eVm;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h oae;
        private c oaf;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eVn = R.drawable.person_more_pop_item_bg_selector;
        private int eVo = 17;
        private boolean eVq = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oaf != null) {
                    a.this.oaf.onClick();
                }
                if (a.this.oae != null && a.this.oae.dWf() != null) {
                    a.this.oae.dWf().dV(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.oae = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.oaf = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0106);
            ap.setBackgroundColor(this.eVm, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.oae != null && this.oae.getContext() != null) {
                this.mView = LayoutInflater.from(this.oae.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.oae.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eVo);
                this.eVm = this.mView.findViewById(R.id.divider_line);
                if (this.eVq) {
                    this.eVm.setVisibility(0);
                } else {
                    this.eVm.setVisibility(8);
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
