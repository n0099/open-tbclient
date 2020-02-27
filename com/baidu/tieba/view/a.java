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
    private TextView cKQ;
    private Context cVI;
    private LinearLayout cVK;
    private View cVL;
    private TextView cVM;
    private d kHD;
    private b kHE;
    private boolean kHF;
    private List<C0629a> mItems;
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
            this.cVI = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.cVK = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cKQ = (TextView) this.view.findViewById(R.id.title);
            this.cVL = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cVM = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cVI;
    }

    public ViewGroup getView() {
        return this.cVK;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cTr() {
        return this.kHD;
    }

    public void az(List<C0629a> list) {
        if (list != null) {
            this.mItems = list;
            this.cVK.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0629a c0629a = list.get(i2);
                    if (c0629a != null) {
                        this.cVK.addView(c0629a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kHE = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cKQ, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.cKQ, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cVL, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVM, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cVM, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0629a c0629a : this.mItems) {
                c0629a.onChangeSkinType();
            }
        }
        if (this.kHF) {
            if (!StringUtils.isNull(this.titleText) && this.cKQ != null && (this.cKQ.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.cKQ.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0629a c0629a2 = this.mItems.get(0);
                if (!c0629a2.kHJ) {
                    c0629a2.kHJ = true;
                    c0629a2.onChangeSkinType();
                }
            }
        }
    }

    public View aEP() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKQ.setText(this.titleText);
            this.cVL.setVisibility(0);
        } else {
            this.cKQ.setVisibility(8);
            this.cVL.setVisibility(8);
        }
        if (this.kHE != null) {
            this.cVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kHE.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0629a {
        private View cVt;
        private int cVu;
        private int cVv;
        private boolean cVx;
        private a kHH;
        private c kHI;
        public boolean kHJ;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0629a(a aVar) {
            this(null, aVar);
        }

        public C0629a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.cVu = R.drawable.person_more_pop_item_bg_selector;
            this.cVv = 17;
            this.cVx = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0629a.this.kHI != null) {
                        C0629a.this.kHI.onClick();
                    }
                    if (C0629a.this.kHH != null && C0629a.this.kHH.cTr() != null) {
                        C0629a.this.kHH.cTr().k(C0629a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.kHH = aVar;
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
            this.kHI = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.kHJ) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.kv(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.cVt, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kHH != null && this.kHH.getContext() != null) {
                this.mView = LayoutInflater.from(this.kHH.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kHH.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cVv);
                this.cVt = this.mView.findViewById(R.id.divider_line);
                if (this.cVx) {
                    this.cVt.setVisibility(0);
                } else {
                    this.cVt.setVisibility(8);
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
