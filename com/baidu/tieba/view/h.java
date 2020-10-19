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
    private TextView egP;
    private Context euq;
    private LinearLayout eus;
    private View eut;
    private TextView euu;
    private RadioButton iEA;
    private RadioButton iEB;
    private RadioButton iEC;
    private RadioButton iED;
    private RadioButton iEE;
    private List<a> mItems;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iEA) {
                h.this.iEB.setChecked(false);
                h.this.iEC.setChecked(false);
                h.this.iED.setChecked(false);
                h.this.iEE.setChecked(false);
                h.this.mScore = 1;
            } else if (view == h.this.iEB) {
                h.this.iEA.setChecked(true);
                h.this.iEC.setChecked(false);
                h.this.iED.setChecked(false);
                h.this.iEE.setChecked(false);
                h.this.mScore = 2;
            } else if (view == h.this.iEC) {
                h.this.iEA.setChecked(true);
                h.this.iEB.setChecked(true);
                h.this.iED.setChecked(false);
                h.this.iEE.setChecked(false);
                h.this.mScore = 3;
            } else if (view == h.this.iED) {
                h.this.iEA.setChecked(true);
                h.this.iEB.setChecked(true);
                h.this.iEC.setChecked(true);
                h.this.iEE.setChecked(false);
                h.this.mScore = 4;
            } else if (view == h.this.iEE) {
                h.this.iEA.setChecked(true);
                h.this.iEB.setChecked(true);
                h.this.iEC.setChecked(true);
                h.this.iED.setChecked(true);
                h.this.mScore = 5;
            }
            if (h.this.njl != null) {
                h.this.njl.Hj(h.this.mScore);
            }
        }
    };
    private int mScore;
    private d njj;
    private b njk;
    private e njl;
    private LinearLayout njm;
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
        void Hj(int i);
    }

    public h(Context context) {
        if (context != null) {
            this.euq = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.rate_list_dialog_view, (ViewGroup) null);
            this.eus = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.egP = (TextView) this.view.findViewById(R.id.title);
            this.eut = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.euu = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
            this.iEA = (RadioButton) this.view.findViewById(R.id.comment_grade_1);
            this.iEA.setOnClickListener(this.mOnClickListener);
            this.iEB = (RadioButton) this.view.findViewById(R.id.comment_grade_2);
            this.iEB.setOnClickListener(this.mOnClickListener);
            this.iEC = (RadioButton) this.view.findViewById(R.id.comment_grade_3);
            this.iEC.setOnClickListener(this.mOnClickListener);
            this.iED = (RadioButton) this.view.findViewById(R.id.comment_grade_4);
            this.iED.setOnClickListener(this.mOnClickListener);
            this.iEE = (RadioButton) this.view.findViewById(R.id.comment_grade_5);
            this.iEE.setOnClickListener(this.mOnClickListener);
            this.njm = (LinearLayout) this.view.findViewById(R.id.comment_grade);
        }
    }

    public Context getContext() {
        return this.euq;
    }

    public ViewGroup getView() {
        return this.eus;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void xL(boolean z) {
        this.iEA.setEnabled(z);
        this.iEB.setEnabled(z);
        this.iEC.setEnabled(z);
        this.iED.setEnabled(z);
        this.iEE.setEnabled(z);
    }

    public void Kv(int i) {
        switch (i) {
            case 1:
                this.iEA.setChecked(true);
                this.iEB.setChecked(false);
                this.iEC.setChecked(false);
                this.iED.setChecked(false);
                this.iEE.setChecked(false);
                return;
            case 2:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(false);
                this.iED.setChecked(false);
                this.iEE.setChecked(false);
                return;
            case 3:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(true);
                this.iED.setChecked(false);
                this.iEE.setChecked(false);
                return;
            case 4:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(true);
                this.iED.setChecked(true);
                this.iEE.setChecked(false);
                return;
            case 5:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(true);
                this.iED.setChecked(true);
                this.iEE.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void Kw(int i) {
        this.njm.setVisibility(i);
    }

    public void H(int i, int i2, int i3, int i4) {
        this.njm.setPadding(i, i2, i3, i4);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.egP.setPadding(i, i2, i3, i4);
    }

    public void setTitleSize(int i) {
        this.egP.setTextSize(0, l.getDimens(this.euq, i));
    }

    public d dNb() {
        return this.njj;
    }

    public void ba(List<a> list) {
        if (list != null) {
            this.mItems = list;
            this.eus.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.eus.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.njk = bVar;
    }

    public void a(e eVar) {
        this.njl = eVar;
    }

    public void Kx(int i) {
        this.euu.setVisibility(i);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.egP, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.egP, R.color.cp_cont_j);
        ap.setBackgroundColor(this.eut, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.euu, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.euu, R.color.cp_cont_f);
        ap.setBackgroundResource(this.njm, R.drawable.bg_bottom_up_list_dialog_item);
        if (this.mItems != null) {
            for (a aVar : this.mItems) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bkZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.egP.setText(this.titleText);
        } else {
            this.egP.setVisibility(8);
        }
        if (this.njk != null) {
            this.euu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.njk.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private View eub;
        private String mText;
        private TextView mTextView;
        private View mView;
        private h njo;
        private c njp;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int euc = R.drawable.person_more_pop_item_bg_selector;
        private int eud = 17;
        private boolean euf = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.njp != null) {
                    a.this.njp.onClick();
                }
                if (a.this.njo != null && a.this.njo.dNb() != null) {
                    a.this.njo.dNb().onItemClick(a.this.mId);
                }
            }
        };
        private int mId = hashCode();

        public a(String str, h hVar) {
            this.mText = str;
            this.njo = hVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.njp = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            ap.setBackgroundColor(this.eub, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.njo != null && this.njo.getContext() != null) {
                this.mView = LayoutInflater.from(this.njo.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.njo.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eud);
                this.eub = this.mView.findViewById(R.id.divider_line);
                if (this.euf) {
                    this.eub.setVisibility(0);
                } else {
                    this.eub.setVisibility(8);
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
