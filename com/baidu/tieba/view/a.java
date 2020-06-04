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
    private Context dJh;
    private LinearLayout dJj;
    private View dJk;
    private TextView dJl;
    private TextView dyo;
    private d lNw;
    private b lNx;
    private boolean lNy;
    private List<C0746a> mItems;
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
            this.dJh = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.dJj = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dyo = (TextView) this.view.findViewById(R.id.title);
            this.dJk = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dJl = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dJh;
    }

    public ViewGroup getView() {
        return this.dJj;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dme() {
        return this.lNw;
    }

    public void aD(List<C0746a> list) {
        if (list != null) {
            this.mItems = list;
            this.dJj.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0746a c0746a = list.get(i2);
                    if (c0746a != null) {
                        this.dJj.addView(c0746a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.lNx = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dyo, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.dyo, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.dJk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dJl, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.dJl, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0746a c0746a : this.mItems) {
                c0746a.onChangeSkinType();
            }
        }
        if (this.lNy) {
            if (!StringUtils.isNull(this.titleText) && this.dyo != null && (this.dyo.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dyo.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0746a c0746a2 = this.mItems.get(0);
                if (!c0746a2.lNC) {
                    c0746a2.lNC = true;
                    c0746a2.onChangeSkinType();
                }
            }
        }
    }

    public View aTh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dyo.setText(this.titleText);
            this.dJk.setVisibility(0);
        } else {
            this.dyo.setVisibility(8);
            this.dJk.setVisibility(8);
        }
        if (this.lNx != null) {
            this.dJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lNx.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0746a {
        private View dIS;
        private int dIT;
        private int dIU;
        private boolean dIW;
        private a lNA;
        private c lNB;
        public boolean lNC;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0746a(a aVar) {
            this(null, aVar);
        }

        public C0746a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.dIT = R.drawable.person_more_pop_item_bg_selector;
            this.dIU = 17;
            this.dIW = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0746a.this.lNB != null) {
                        C0746a.this.lNB.onClick();
                    }
                    if (C0746a.this.lNA != null && C0746a.this.lNA.dme() != null) {
                        C0746a.this.lNA.dme().k(C0746a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.lNA = aVar;
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
            this.lNB = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.lNC) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.le(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.dIS, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.lNA != null && this.lNA.getContext() != null) {
                this.mView = LayoutInflater.from(this.lNA.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.lNA.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.dIU);
                this.dIS = this.mView.findViewById(R.id.divider_line);
                if (this.dIW) {
                    this.dIS.setVisibility(0);
                } else {
                    this.dIS.setVisibility(8);
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
