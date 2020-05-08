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
    private TextView dko;
    private Context dvm;
    private LinearLayout dvo;
    private View dvp;
    private TextView dvq;
    private d ltL;
    private b ltM;
    private boolean ltN;
    private List<C0692a> mItems;
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
            this.dvm = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.dvo = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dko = (TextView) this.view.findViewById(R.id.title);
            this.dvp = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dvq = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dvm;
    }

    public ViewGroup getView() {
        return this.dvo;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dez() {
        return this.ltL;
    }

    public void aI(List<C0692a> list) {
        if (list != null) {
            this.mItems = list;
            this.dvo.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0692a c0692a = list.get(i2);
                    if (c0692a != null) {
                        this.dvo.addView(c0692a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.ltM = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dko, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.dko, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.dvp, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dvq, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.dvq, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0692a c0692a : this.mItems) {
                c0692a.onChangeSkinType();
            }
        }
        if (this.ltN) {
            if (!StringUtils.isNull(this.titleText) && this.dko != null && (this.dko.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dko.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0692a c0692a2 = this.mItems.get(0);
                if (!c0692a2.ltR) {
                    c0692a2.ltR = true;
                    c0692a2.onChangeSkinType();
                }
            }
        }
    }

    public View aNh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dko.setText(this.titleText);
            this.dvp.setVisibility(0);
        } else {
            this.dko.setVisibility(8);
            this.dvp.setVisibility(8);
        }
        if (this.ltM != null) {
            this.dvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ltM.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0692a {
        private View duX;
        private int duY;
        private int duZ;
        private boolean dvb;
        private a ltP;
        private c ltQ;
        public boolean ltR;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0692a(a aVar) {
            this(null, aVar);
        }

        public C0692a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.duY = R.drawable.person_more_pop_item_bg_selector;
            this.duZ = 17;
            this.dvb = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0692a.this.ltQ != null) {
                        C0692a.this.ltQ.onClick();
                    }
                    if (C0692a.this.ltP != null && C0692a.this.ltP.dez() != null) {
                        C0692a.this.ltP.dez().k(C0692a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.ltP = aVar;
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
            this.ltQ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.ltR) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.kC(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.duX, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.ltP != null && this.ltP.getContext() != null) {
                this.mView = LayoutInflater.from(this.ltP.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.ltP.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.duZ);
                this.duX = this.mView.findViewById(R.id.divider_line);
                if (this.dvb) {
                    this.duX.setVisibility(0);
                } else {
                    this.duX.setVisibility(8);
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
