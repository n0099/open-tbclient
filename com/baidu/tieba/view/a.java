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
    private TextView eKc;
    private Context eYd;
    private LinearLayout eYf;
    private View eYi;
    private TextView eYj;
    private List<C0909a> mItems;
    private d nRm;
    private b nRn;
    private boolean nRo;
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
            this.eYd = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eYf = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eKc = (TextView) this.view.findViewById(R.id.title);
            this.eYi = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eYj = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eYd;
    }

    public ViewGroup getView() {
        return this.eYf;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dXv() {
        return this.nRm;
    }

    public void bB(List<C0909a> list) {
        if (list != null) {
            this.mItems = list;
            this.eYf.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0909a c0909a = list.get(i2);
                    if (c0909a != null) {
                        this.eYf.addView(c0909a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nRn = bVar;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.view, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eKc, R.drawable.bg_title_corner_dialog_item);
        ao.setViewTextColor(this.eKc, R.color.CAM_X0108);
        ao.setBackgroundColor(this.eYi, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eYj, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.eYj, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (C0909a c0909a : this.mItems) {
                c0909a.onChangeSkinType();
            }
        }
        if (this.nRo) {
            if (!StringUtils.isNull(this.titleText) && this.eKc != null && (this.eKc.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.eKc.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (x.getCount(this.mItems) > 0) {
                C0909a c0909a2 = this.mItems.get(0);
                if (!c0909a2.nRs) {
                    c0909a2.nRs = true;
                    c0909a2.onChangeSkinType();
                }
            }
        }
    }

    public View bus() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eKc.setText(this.titleText);
            this.eYi.setVisibility(0);
        } else {
            this.eKc.setVisibility(8);
            this.eYi.setVisibility(8);
        }
        if (this.nRn != null) {
            this.eYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nRn.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0909a {
        private View eXI;
        private int eXJ;
        private int eXK;
        private boolean eXM;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a nRq;
        private c nRr;
        public boolean nRs;

        public C0909a(a aVar) {
            this(null, aVar);
        }

        public C0909a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.eXJ = R.drawable.person_more_pop_item_bg_selector;
            this.eXK = 17;
            this.eXM = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0909a.this.nRr != null) {
                        C0909a.this.nRr.onClick();
                    }
                    if (C0909a.this.nRq != null && C0909a.this.nRq.dXv() != null) {
                        C0909a.this.nRq.dXv().k(C0909a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.nRq = aVar;
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
            this.nRr = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nRs) {
                    ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ao.qe(R.color.CAM_X0211));
                }
            }
            ao.setViewTextColor(this.mTextView, R.color.CAM_X0105);
            ao.setBackgroundColor(this.eXI, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nRq != null && this.nRq.getContext() != null) {
                this.mView = LayoutInflater.from(this.nRq.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nRq.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eXK);
                this.eXI = this.mView.findViewById(R.id.divider_line);
                if (this.eXM) {
                    this.eXI.setVisibility(0);
                } else {
                    this.eXI.setVisibility(8);
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
