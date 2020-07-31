package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView dJr;
    private Context dWp;
    private LinearLayout dWr;
    private View dWs;
    private TextView dWt;
    private List<C0772a> mItems;
    private d moM;
    private b moN;
    private boolean moO;
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
            this.dWp = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.dWr = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dJr = (TextView) this.view.findViewById(R.id.title);
            this.dWs = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dWt = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dWp;
    }

    public ViewGroup getView() {
        return this.dWr;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dtC() {
        return this.moM;
    }

    public void aS(List<C0772a> list) {
        if (list != null) {
            this.mItems = list;
            this.dWr.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0772a c0772a = list.get(i2);
                    if (c0772a != null) {
                        this.dWr.addView(c0772a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.moN = bVar;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.dJr, R.drawable.bg_title_corner_dialog_item);
        ao.setViewTextColor(this.dJr, R.color.cp_cont_c);
        ao.setBackgroundColor(this.dWs, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.dWt, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.dWt, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0772a c0772a : this.mItems) {
                c0772a.onChangeSkinType();
            }
        }
        if (this.moO) {
            if (!StringUtils.isNull(this.titleText) && this.dJr != null && (this.dJr.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dJr.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (x.getCount(this.mItems) > 0) {
                C0772a c0772a2 = this.mItems.get(0);
                if (!c0772a2.moS) {
                    c0772a2.moS = true;
                    c0772a2.onChangeSkinType();
                }
            }
        }
    }

    public View aZb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dJr.setText(this.titleText);
            this.dWs.setVisibility(0);
        } else {
            this.dJr.setVisibility(8);
            this.dWs.setVisibility(8);
        }
        if (this.moN != null) {
            this.dWt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.moN.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0772a {
        private View dWa;
        private int dWb;
        private int dWc;
        private boolean dWe;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a moQ;
        private c moR;
        public boolean moS;

        public C0772a(a aVar) {
            this(null, aVar);
        }

        public C0772a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.dWb = R.drawable.person_more_pop_item_bg_selector;
            this.dWc = 17;
            this.dWe = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0772a.this.moR != null) {
                        C0772a.this.moR.onClick();
                    }
                    if (C0772a.this.moQ != null && C0772a.this.moQ.dtC() != null) {
                        C0772a.this.moQ.dtC().k(C0772a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.moQ = aVar;
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
            this.moR = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.moS) {
                    ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ao.lM(R.color.cp_bg_line_k));
                }
            }
            ao.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ao.setBackgroundColor(this.dWa, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.moQ != null && this.moQ.getContext() != null) {
                this.mView = LayoutInflater.from(this.moQ.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.moQ.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.dWc);
                this.dWa = this.mView.findViewById(R.id.divider_line);
                if (this.dWe) {
                    this.dWa.setVisibility(0);
                } else {
                    this.dWa.setVisibility(8);
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
