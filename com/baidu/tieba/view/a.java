package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView bUW;
    private Context cfP;
    private LinearLayout cfR;
    private View cfS;
    private TextView cfT;
    private d jJK;
    private b jJL;
    private boolean jJM;
    private List<C0537a> mItems;
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
        void m(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.cfP = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.cfR = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bUW = (TextView) this.view.findViewById(R.id.title);
            this.cfS = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cfT = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cfP;
    }

    public ViewGroup alc() {
        return this.cfR;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cwO() {
        return this.jJK;
    }

    public void at(List<C0537a> list) {
        if (list != null) {
            this.mItems = list;
            this.cfR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0537a c0537a = list.get(i2);
                    if (c0537a != null) {
                        this.cfR.addView(c0537a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jJL = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.bUW, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.bUW, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cfS, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cfT, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cfT, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0537a c0537a : this.mItems) {
                c0537a.onChangeSkinType();
            }
        }
        if (this.jJM) {
            if (!StringUtils.isNull(this.titleText) && this.bUW != null && (this.bUW.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.bUW.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0537a c0537a2 = this.mItems.get(0);
                if (!c0537a2.jJQ) {
                    c0537a2.jJQ = true;
                    c0537a2.onChangeSkinType();
                }
            }
        }
    }

    public View ale() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bUW.setText(this.titleText);
            this.cfS.setVisibility(0);
        } else {
            this.bUW.setVisibility(8);
            this.cfS.setVisibility(8);
        }
        if (this.jJL != null) {
            this.cfT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jJL.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0537a {
        private View cfA;
        private int cfB;
        private int cfC;
        private boolean cfE;
        private a jJO;
        private c jJP;
        public boolean jJQ;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0537a(a aVar) {
            this(null, aVar);
        }

        public C0537a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.cfB = R.drawable.person_more_pop_item_bg_selector;
            this.cfC = 17;
            this.cfE = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0537a.this.jJP != null) {
                        C0537a.this.jJP.onClick();
                    }
                    if (C0537a.this.jJO != null && C0537a.this.jJO.cwO() != null) {
                        C0537a.this.jJO.cwO().m(C0537a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.jJO = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.mText = str;
            this.mTextView.setText(this.mText);
        }

        public void a(c cVar) {
            this.jJP = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.jJQ) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.it(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.cfA, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jJO != null && this.jJO.getContext() != null) {
                this.mView = LayoutInflater.from(this.jJO.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jJO.alc(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cfC);
                this.cfA = this.mView.findViewById(R.id.divider_line);
                if (this.cfE) {
                    this.cfA.setVisibility(0);
                } else {
                    this.cfA.setVisibility(8);
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
