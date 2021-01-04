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
    private List<C0871a> mItems;
    private d nRn;
    private b nRo;
    private boolean nRp;
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

    public d dXu() {
        return this.nRn;
    }

    public void bB(List<C0871a> list) {
        if (list != null) {
            this.mItems = list;
            this.eYf.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0871a c0871a = list.get(i2);
                    if (c0871a != null) {
                        this.eYf.addView(c0871a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nRo = bVar;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.view, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eKc, R.drawable.bg_title_corner_dialog_item);
        ao.setViewTextColor(this.eKc, R.color.CAM_X0108);
        ao.setBackgroundColor(this.eYi, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eYj, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.eYj, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (C0871a c0871a : this.mItems) {
                c0871a.onChangeSkinType();
            }
        }
        if (this.nRp) {
            if (!StringUtils.isNull(this.titleText) && this.eKc != null && (this.eKc.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.eKc.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (x.getCount(this.mItems) > 0) {
                C0871a c0871a2 = this.mItems.get(0);
                if (!c0871a2.nRt) {
                    c0871a2.nRt = true;
                    c0871a2.onChangeSkinType();
                }
            }
        }
    }

    public View bur() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eKc.setText(this.titleText);
            this.eYi.setVisibility(0);
        } else {
            this.eKc.setVisibility(8);
            this.eYi.setVisibility(8);
        }
        if (this.nRo != null) {
            this.eYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nRo.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0871a {
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
        private a nRr;
        private c nRs;
        public boolean nRt;

        public C0871a(a aVar) {
            this(null, aVar);
        }

        public C0871a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.eXJ = R.drawable.person_more_pop_item_bg_selector;
            this.eXK = 17;
            this.eXM = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0871a.this.nRs != null) {
                        C0871a.this.nRs.onClick();
                    }
                    if (C0871a.this.nRr != null && C0871a.this.nRr.dXu() != null) {
                        C0871a.this.nRr.dXu().k(C0871a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.nRr = aVar;
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
            this.nRs = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nRt) {
                    ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ao.qe(R.color.CAM_X0211));
                }
            }
            ao.setViewTextColor(this.mTextView, R.color.CAM_X0105);
            ao.setBackgroundColor(this.eXI, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nRr != null && this.nRr.getContext() != null) {
                this.mView = LayoutInflater.from(this.nRr.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nRr.getView(), false);
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
