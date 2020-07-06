package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView dDu;
    private Context dPX;
    private LinearLayout dPZ;
    private View dQa;
    private TextView dQb;
    private List<C0762a> mItems;
    private d mhw;
    private b mhx;
    private boolean mhy;
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
            this.dPX = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.dPZ = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dDu = (TextView) this.view.findViewById(R.id.title);
            this.dQa = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dQb = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dPX;
    }

    public ViewGroup getView() {
        return this.dPZ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dqt() {
        return this.mhw;
    }

    public void aL(List<C0762a> list) {
        if (list != null) {
            this.mItems = list;
            this.dPZ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0762a c0762a = list.get(i2);
                    if (c0762a != null) {
                        this.dPZ.addView(c0762a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mhx = bVar;
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.dDu, R.drawable.bg_title_corner_dialog_item);
        an.setViewTextColor(this.dDu, (int) R.color.cp_cont_c);
        an.setBackgroundColor(this.dQa, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.dQb, R.drawable.bg_bottom_up_list_dialog_item);
        an.setViewTextColor(this.dQb, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0762a c0762a : this.mItems) {
                c0762a.onChangeSkinType();
            }
        }
        if (this.mhy) {
            if (!StringUtils.isNull(this.titleText) && this.dDu != null && (this.dDu.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dDu.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (w.getCount(this.mItems) > 0) {
                C0762a c0762a2 = this.mItems.get(0);
                if (!c0762a2.mhC) {
                    c0762a2.mhC = true;
                    c0762a2.onChangeSkinType();
                }
            }
        }
    }

    public View aVb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dDu.setText(this.titleText);
            this.dQa.setVisibility(0);
        } else {
            this.dDu.setVisibility(8);
            this.dQa.setVisibility(8);
        }
        if (this.mhx != null) {
            this.dQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mhx.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0762a {
        private View dPI;
        private int dPJ;
        private int dPK;
        private boolean dPM;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a mhA;
        private c mhB;
        public boolean mhC;

        public C0762a(a aVar) {
            this(null, aVar);
        }

        public C0762a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.dPJ = R.drawable.person_more_pop_item_bg_selector;
            this.dPK = 17;
            this.dPM = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0762a.this.mhB != null) {
                        C0762a.this.mhB.onClick();
                    }
                    if (C0762a.this.mhA != null && C0762a.this.mhA.dqt() != null) {
                        C0762a.this.mhA.dqt().k(C0762a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.mhA = aVar;
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
            this.mhB = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.mhC) {
                    an.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(an.ls(R.color.cp_bg_line_k));
                }
            }
            an.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.dPI, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mhA != null && this.mhA.getContext() != null) {
                this.mView = LayoutInflater.from(this.mhA.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mhA.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.dPK);
                this.dPI = this.mView.findViewById(R.id.divider_line);
                if (this.dPM) {
                    this.dPI.setVisibility(0);
                } else {
                    this.dPI.setVisibility(8);
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
