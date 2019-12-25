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
    private TextView cGB;
    private TextView cRA;
    private Context cRw;
    private LinearLayout cRy;
    private View cRz;
    private d kDc;
    private b kDd;
    private boolean kDe;
    private List<C0616a> mItems;
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
        void k(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.cRw = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.cRy = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cGB = (TextView) this.view.findViewById(R.id.title);
            this.cRz = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cRA = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cRw;
    }

    public ViewGroup aCk() {
        return this.cRy;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cQR() {
        return this.kDc;
    }

    public void aA(List<C0616a> list) {
        if (list != null) {
            this.mItems = list;
            this.cRy.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0616a c0616a = list.get(i2);
                    if (c0616a != null) {
                        this.cRy.addView(c0616a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kDd = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cGB, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.cGB, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cRz, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cRA, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cRA, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0616a c0616a : this.mItems) {
                c0616a.onChangeSkinType();
            }
        }
        if (this.kDe) {
            if (!StringUtils.isNull(this.titleText) && this.cGB != null && (this.cGB.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.cGB.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0616a c0616a2 = this.mItems.get(0);
                if (!c0616a2.kDi) {
                    c0616a2.kDi = true;
                    c0616a2.onChangeSkinType();
                }
            }
        }
    }

    public View aCm() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cGB.setText(this.titleText);
            this.cRz.setVisibility(0);
        } else {
            this.cGB.setVisibility(8);
            this.cRz.setVisibility(8);
        }
        if (this.kDd != null) {
            this.cRA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kDd.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0616a {
        private View cRh;
        private int cRi;
        private int cRj;
        private boolean cRl;
        private a kDg;
        private c kDh;
        public boolean kDi;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0616a(a aVar) {
            this(null, aVar);
        }

        public C0616a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.cRi = R.drawable.person_more_pop_item_bg_selector;
            this.cRj = 17;
            this.cRl = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0616a.this.kDh != null) {
                        C0616a.this.kDh.onClick();
                    }
                    if (C0616a.this.kDg != null && C0616a.this.kDg.cQR() != null) {
                        C0616a.this.kDg.cQR().k(C0616a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.kDg = aVar;
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
            this.kDh = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.kDi) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.ke(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.cRh, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kDg != null && this.kDg.getContext() != null) {
                this.mView = LayoutInflater.from(this.kDg.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kDg.aCk(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cRj);
                this.cRh = this.mView.findViewById(R.id.divider_line);
                if (this.cRl) {
                    this.cRh.setVisibility(0);
                } else {
                    this.cRh.setVisibility(8);
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
